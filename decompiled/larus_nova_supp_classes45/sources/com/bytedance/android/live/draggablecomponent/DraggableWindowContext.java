package com.bytedance.android.live.draggablecomponent;

import androidx.lifecycle.ViewModel;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.live.room.api.messagewindow.monitor.CardAlogParamsBuilder;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.DataContext;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Action;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 !2\u00020\u00012\u00020\u0002:\u0001\"B\u0017\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\u0006\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b\u001f\u0010 J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\u0006\u0010\n\u001a\u00020\u0003R\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR*\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0016\u0010\t\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u0010\u0014R\u001a\u0010\u0016\u001a\u00020\u00158\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001b\u001a\u00020\u001a8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e¨\u0006#"}, d2 = {"Lcom/bytedance/android/live/draggablecomponent/DraggableWindowContext;", "Lcom/bytedance/live/datacontext/DataContext;", "Lc61/g;", "", "doOnRelease", "Lc61/d;", "Lc61/f;", "windowContainer", "Lc61/e;", "monitor", "initialize", "Lio/reactivex/disposables/CompositeDisposable;", "cd", "Lio/reactivex/disposables/CompositeDisposable;", KtvSubElement.CONTAINER, "Lc61/d;", "getContainer", "()Lc61/d;", "setContainer", "(Lc61/d;)V", "Lc61/e;", "Lcom/bytedance/android/livesdk/chatroom/RoomContext;", "roomContext", "Lcom/bytedance/android/livesdk/chatroom/RoomContext;", "getRoomContext", "()Lcom/bytedance/android/livesdk/chatroom/RoomContext;", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "dataCenter", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "getDataCenter", "()Lcom/bytedance/ies/sdk/widgets/DataCenter;", "<init>", "(Lcom/bytedance/android/livesdk/chatroom/RoomContext;Lcom/bytedance/ies/sdk/widgets/DataCenter;)V", "Companion", "b", "experience-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DraggableWindowContext extends DataContext implements c61.g {
    public static final b Companion = null;
    private static final String TAG = "DraggableWindowContext";
    private final CompositeDisposable cd;
    private c61.d<c61.f> container;
    private final DataCenter dataCenter;
    private c61.e monitor;
    private final RoomContext roomContext;

    public static final class a implements Action {
        public final /* synthetic */ DraggableWindowContext a;

        public a(DraggableWindowContext r1) {
            this.a = r1;
        }

        public final void run() {
            this.a.setContainer(null);
            DraggableWindowContext.access$getCd$p(this.a).clear();
        }
    }

    public static final class b {
        public static c61.g a() {
            DataContext r1 = com.bytedance.live.datacontext.d.d(DraggableWindowContext.TAG);
            ViewModel r3 = null;
            if ((r1 instanceof c61.g) == true) goto L5;
            r1 = null;
        L5:
            c61.g r2 = (c61.g) r1;
            if (r2 != null) goto L25;
            RoomContext r4 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
            if (r4 == null) goto L20;
            com.bytedance.live.datacontext.j r5 = r4.getDraggableWindowContext();
            if (r5 == null) goto L20;
            ViewModel r6 = (ViewModel) r5.getValue();
            if (r6 == null) goto L20;
            if ((r6 instanceof c61.g) == false) goto L17;
            r3 = r6;
        L17:
            c61.g r7 = (c61.g) r3;
            if (r7 == null) goto L20;
            r2 = r7;
        L20:
            if (r2 != null) goto L25;
            com.bytedance.android.live.room.api.messagewindow.monitor.i r8 = com.bytedance.android.live.room.api.messagewindow.monitor.d.a();
            if (r8 == null) goto L25;
            CardAlogParamsBuilder r9 = new CardAlogParamsBuilder();
            r9.d(DraggableWindowContext.TAG);
            r9.c("the draggable window context is null");
            Unit r0 = Unit.INSTANCE;
            r8.d(r9.b());
        L25:
            return r2;
        }

        public b() {
        }
    }

    static {
        Companion = new b();
    }

    private final void doOnRelease() {
        this.container = null;
    }

    public final void initialize() {
        com.bytedance.live.datacontext.b.a(this, TAG);
        doOnRelease();
    }

    public final c61.d<c61.f> getContainer() {
        return this.container;
    }

    public DataCenter getDataCenter() {
        return this.dataCenter;
    }

    public RoomContext getRoomContext() {
        return this.roomContext;
    }

    public c61.e monitor() {
        return this.monitor;
    }

    public c61.d<c61.f> windowContainer() {
        return this.container;
    }

    public static final /* synthetic */ CompositeDisposable access$getCd$p(DraggableWindowContext r0) {
        return r0.cd;
    }

    public final void setContainer(c61.d<c61.f> r1) {
        this.container = r1;
    }

    public DraggableWindowContext(RoomContext r2, DataCenter r3) {
        Intrinsics.checkNotNullParameter(r2, "roomContext");
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        this.roomContext = r2;
        this.dataCenter = r3;
        CompositeDisposable r4 = new CompositeDisposable();
        this.cd = r4;
        RxUtilKt.c(getOnCleared().subscribe(new a(this)), r4);
        this.monitor = com.bytedance.android.live.draggablecomponent.b.a;
    }
}
