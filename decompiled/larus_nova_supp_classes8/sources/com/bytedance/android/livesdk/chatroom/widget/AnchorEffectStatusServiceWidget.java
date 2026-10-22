package com.bytedance.android.livesdk.chatroom.widget;

import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.wrds.syncdata.effect.AnchorEffectStatusSyncModel;
import com.bytedance.android.livesdkapi.eventbus.CheckAnchorStickerStatusCallback;
import com.bytedance.android.livesdkapi.eventbus.CheckAnchorStickerStatusEvent;
import com.bytedance.android.livesdkapi.eventbus.InteractEffectSyncData;
import com.bytedance.android.livesdkapi.eventbus.StickerInfo;
import com.bytedance.android.livesdkapi.eventbus.StickerInfoList;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.performance.task.AtlasAsyncExecutor;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.performance.task.AtlasAsyncExtKt;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/widget/AnchorEffectStatusServiceWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", "<init>", "()V", "a", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorEffectStatusServiceWidget extends LiveRecyclableWidget {
    public final CompositeDisposable a;
    public Map<String, StickerInfoList> b;
    public final CopyOnWriteArrayList<Long> c;
    public final CopyOnWriteArrayList<Long> d;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ AnchorEffectStatusServiceWidget a;

        public b(AnchorEffectStatusServiceWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            AnchorEffectStatusServiceWidget r0 = this.a;
            Map<String, StickerInfoList> r5 = ((InteractEffectSyncData) r4).stickerInfoMap;
            r0.b = r5;
            if (r5 == null) goto L6;
            StickerInfoList r6 = r5.get(com.bytedance.android.live.effect.api.d0.c);
            if (r6 == null) goto L6;
        L7:
            final com.bytedance.android.livesdk.chatroom.widget.a r1 = new com.bytedance.android.livesdk.chatroom.widget.a(this, r6.stickerInfoList);
            AtlasAsyncExtKt.executeTask(AtlasAsyncExecutor.INSTANCE, "AnchorEffectStatusServiceWidget.onLoad", r1, new AnchorEffectStatusServiceWidget$onLoad$1$1(r1));
            return;
        L6:
            r6 = new StickerInfoList();
            goto L7
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ AnchorEffectStatusServiceWidget a;

        public c(AnchorEffectStatusServiceWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r9) {
            CheckAnchorStickerStatusEvent r10 = (CheckAnchorStickerStatusEvent) r9;
            CheckAnchorStickerStatusCallback r0 = r10.getCallback();
            Map<String, StickerInfoList> r1 = this.a.b;
            boolean r2 = false;
            Object r4 = null;
            if (r1 == null) goto L20;
            StickerInfoList r3 = r1.get(r10.getPanel());
            if (r3 == null) goto L20;
            List r5 = r3.stickerInfoList;
            if (r5 == null) goto L20;
            Iterator<T> r6 = r5.iterator();
        L10:
            if (r6.hasNext() == false) goto L19;
            T r7 = r6.next();
            StickerInfo r8 = (StickerInfo) r7;
            if (r8.use == true) goto L14;
        L16:
            boolean r11 = false;
        L17:
            if (r11 == false) goto L10;
            r4 = r7;
            goto L19
        L14:
            if (Intrinsics.areEqual(String.valueOf(r8.effectID), r10.getEffectID()) == false) goto L16;
            r11 = true;
        L19:
            r4 = (StickerInfo) r4;
        L20:
            if (r4 == null) goto L22;
            r2 = true;
        L22:
            r0.onResult(r2);
        }
    }

    static {
    }

    public final void onInit(Object[] r1) {
    }

    public final void onUnload() {
        this.a.clear();
        this.b = null;
        this.c.clear();
        this.d.clear();
    }

    public AnchorEffectStatusServiceWidget() {
        this.a = new CompositeDisposable();
        this.b = MapsKt.emptyMap();
        this.c = new CopyOnWriteArrayList();
        this.d = new CopyOnWriteArrayList();
    }

    public final void onLoad(Object[] r5) {
        dc2.c r3 = null;
        RoomContext r6 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r6 == null) goto L9;
        com.bytedance.live.datacontext.j r7 = r6.getAnchorEffectStatusSyncModel();
        if (r7 == null) goto L9;
        AnchorEffectStatusSyncModel r8 = (AnchorEffectStatusSyncModel) r7.getValue();
        if (r8 == null) goto L9;
        r3 = r8.getAnchorEffectStatusSyncData();
    L9:
        if (r3 == null) goto L15;
        Observable r9 = r3.d;
        if (r9 == null) goto L15;
        Disposable r10 = r9.subscribe(new b(this));
        if (r10 == null) goto L15;
        RxUtilKt.c(r10, this.a);
    L15:
        RxUtilKt.c(xs2.b.a().b(CheckAnchorStickerStatusEvent.class).subscribe(new c(this)), this.a);
    }
}
