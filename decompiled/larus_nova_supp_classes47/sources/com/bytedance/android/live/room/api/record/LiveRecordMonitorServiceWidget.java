package com.bytedance.android.live.room.api.record;

import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.os.Handler;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.core.utils.FileUtils;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.livesdk.chatroom.MiddlewareRoomContext;
import com.bytedance.android.livesdk.experience.record.FromType;
import com.bytedance.android.livesdk.interactivity.api.h;
import com.bytedance.android.livesdk.interactivity.api.q;
import com.bytedance.android.livesdk.utils.p6;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.live.datacontext.j;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.subjects.PublishSubject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/room/api/record/LiveRecordMonitorServiceWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", "Landroidx/lifecycle/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "<init>", "()V", "experience-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveRecordMonitorServiceWidget extends LiveRecyclableWidget implements Observer<KVData> {
    public final String a;
    public dv1.a b;
    public final Lazy c;
    public final Lazy d;
    public final PublishSubject<String> e;
    public final CompositeDisposable f;
    public long g;
    public long h;
    public final a i;

    public static final class a implements dv1.c {
        public final /* synthetic */ LiveRecordMonitorServiceWidget a;

        public a(LiveRecordMonitorServiceWidget r1) {
            this.a = r1;
        }

        public final void a(FromType r7) {
            Intrinsics.checkNotNullParameter(r7, "from");
            LiveRecordMonitorContext r8 = this.a.wq();
            if (r8 == null) goto L5;
            r8.markRecordStared(true);
        L5:
            LiveRecordMonitorServiceWidget r9 = this.a;
            r9.g = p6.b();
            LiveRecordMonitorContext r10 = this.a.wq();
            if (r10 == null) goto L12;
            DataCenter r1 = ((Widget) this.a).dataCenter;
            if (r1 == null) goto L10;
            Boolean r2 = (Boolean) r1.get("cmd_playfragment_visible", Boolean.TRUE);
        L11:
            r10.ignoreThisRecord(true ^ Intrinsics.areEqual(r2, Boolean.TRUE));
            goto L12
        L10:
            r2 = null;
        L12:
            ALogger.i(this.a.a, "screen record monitor, onScreenRecordStarted");
            LiveScreenRecordGuideConfig.c.getClass();
            if (LiveScreenRecordGuideConfig.a.b().a() == false) goto L16;
            UtilityKotlinExtentionsKt.s(0, false, false, LiveRecordMonitorServiceWidget$callback$1$onScreenRecordStarted$1.INSTANCE, 7);
            return;
        }

        public final void b(FromType r7, String r8, boolean r9) {
            Intrinsics.checkNotNullParameter(r7, "from");
            LiveScreenRecordGuideConfig.c.getClass();
            if (LiveScreenRecordGuideConfig.a.b().a() == false) goto L5;
            UtilityKotlinExtentionsKt.s(0, false, false, LiveRecordMonitorServiceWidget$callback$1$onScreenRecordStopped$1.INSTANCE, 7);
        L5:
            ALogger.i(this.a.a, "screen record monitor stop, the path is " + r8 + ", has startCallback is " + r9);
            if (r8 != null) goto L9;
            return;
        L9:
            if (FileUtils.isFileEmpty(r8) == false) goto L12;
            ALogger.i(this.a.a, "screen record monitor stop, video file is empty");
            return;
        L12:
            LiveRecordMonitorContext r10 = this.a.wq();
            if (r10 != null) goto L15;
        L17:
            boolean r12 = false;
        L19:
            if (LiveScreenRecordGuideConfig.a.b().f() == false) goto L23;
            if (r12 == true) goto L23;
            ALogger.i(this.a.a, "screen record monitor stop, not recieve start event");
            return;
        L23:
            LiveRecordMonitorContext r13 = this.a.wq();
            if (r13 != null) goto L26;
        L29:
            this.a.h = p6.b();
            this.a.e.onNext(r8);
            return;
        L26:
            if (r13.isIgnoreThisRecord() != true) goto L29;
            ALogger.i(this.a.a, "screen record monitor stop, ignore this record");
            return;
        L15:
            if (r10.isRecordStared() != true) goto L17;
            r12 = true;
            goto L19
        }
    }

    public final void onInit(Object[] r1) {
    }

    public final void onUnload() {
        dv1.a r0 = this.b;
        if (r0 != null) goto L24;
    L22:
        this.f.clear();
        return;
    L24:
        Handler r2 = r0.c;     // Catch: Exception -> L20
        if (r2 == null) goto L8;
        r2.removeCallbacksAndMessages(null);     // Catch: Exception -> L20
    L8:
        PthreadHandlerThreadV2 r3 = r0.b;     // Catch: Exception -> L20
        if (r3 == null) goto L11;
        r3.quit();     // Catch: Exception -> L20
    L11:
        ContentObserver r4 = r0.a;     // Catch: Exception -> L20
        if (r4 == null) goto L18;
        Context r1 = (Context) r0.f.get();     // Catch: Exception -> L20
        if (r1 == null) goto L18;
        ContentResolver r5 = r1.getContentResolver();     // Catch: Exception -> L20
        if (r5 == null) goto L18;
        r5.unregisterContentObserver(r4);     // Catch: Exception -> L20
    L18:
        ALogger.d("ScreenRecordMonitorService", "ContentObserver unregistered");     // Catch: Exception -> L20
    L20:
        e = move-exception;
        ALogger.e("ScreenRecordMonitorService", "Failed to unregister ContentObserver: " + e.getMessage());
        goto L22
    }

    public final LiveRecordMonitorContext wq() {
        MiddlewareRoomContext r0 = MiddlewareRoomContext.a.c(MiddlewareRoomContext.Companion, ((Widget) this).dataCenter, 0, 2);
        ViewModel r1 = null;
        if (r0 == null) goto L5;
        j r2 = r0.getRecordMonitorViewModel();
    L6:
        if (r2 != null) goto L8;
    L9:
        LiveRecordMonitorContext r3 = new LiveRecordMonitorContext();
        if (r2 == null) goto L12;
        r2.d(r3);
    L12:
        if (r2 == null) goto L14;
        ViewModel r4 = (ViewModel) r2.getValue();
    L16:
        if ((r4 instanceof LiveRecordMonitorContext) == false) goto L20;
        r1 = r4;
    L20:
        return (LiveRecordMonitorContext) r1;
    L14:
        r4 = null;
        goto L16
    L8:
        if (((ViewModel) r2.getValue()) != null) goto L12;
    L5:
        r2 = null;
        goto L6
    }

    public LiveRecordMonitorServiceWidget() {
        this.a = "LiveRecordMonitorServiceWidget";
        this.c = LazyKt.lazy(new LiveRecordMonitorServiceWidget$isPortrait$2(this));
        this.d = LazyKt.lazy(new LiveRecordMonitorServiceWidget$isMiddlewareMediaRoom$2(this));
        this.e = PublishSubject.create();
        this.f = new CompositeDisposable();
        this.i = new a(this);
    }

    public final void onChanged(Object r4) {
        KVData r5 = (KVData) r4;
        Intrinsics.checkNotNullParameter(r5, "kvData");
        String r0 = r5.getKey();
        if (r0.hashCode() == 1046302364) goto L6;
        return;
    L6:
        if (r0.equals("cmd_playfragment_visible") == false) goto L16;
        ALogger.i(this.a, "当前直播间不可见，停止录屏监听");
        if ((!Intrinsics.areEqual((Boolean) r5.getData(), Boolean.FALSE)) == true) goto L17;
        LiveScreenRecordGuideConfig.c.getClass();
        if (LiveScreenRecordGuideConfig.a.b().a() == false) goto L12;
        f2.c("当前直播间不可见，停止录屏监听", 0);
    L12:
        LiveRecordMonitorContext r6 = wq();
        if (r6 == null) goto L18;
        r6.ignoreThisRecord(true);
        return;
    L18:
        return;
    L17:
        return;
    }

    public final void onLoad(Object[] r3) {
        if (((Boolean) this.c.getValue()).booleanValue() == true) goto L5;
        return;
    L5:
        if (((Boolean) this.d.getValue()).booleanValue() == true) goto L22;
        wq();
        h r4 = q.g();
        if (r4 == null) goto L12;
        j r5 = r4.getHighlightEnable();
        if (r5 == null) goto L12;
        Boolean r6 = (Boolean) r5.getValue();
    L13:
        final boolean r7 = Intrinsics.areEqual(r6, Boolean.TRUE);
        h r0 = q.g();
        if (r0 == null) goto L20;
        j r1 = r0.getHighlightEnable();
        if (r1 == null) goto L21;
        r1.c(new AnonymousClass1(this, r7));
        return;
    L21:
        return;
    L20:
        return;
    L12:
        r6 = null;
        goto L13
    }
}
