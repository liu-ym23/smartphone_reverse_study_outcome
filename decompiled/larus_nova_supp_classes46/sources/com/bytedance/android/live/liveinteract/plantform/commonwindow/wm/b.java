package com.bytedance.android.live.liveinteract.plantform.commonwindow.wm;

import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.liveinteract.utils.MultiLinkLoadWidgetUtils;
import com.bytedance.android.live.liveinteract.utils.MultiSceneEnterRoomStatisticsUtils;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.util.IMultiSceneCommonStatistics;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.disposables.Disposable;
import kotlin.Lazy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b implements ViewTreeObserver.OnGlobalLayoutListener {
    public final /* synthetic */ BaseMultiLinkWindowManager a;

    public static final class a implements Runnable {
        public final /* synthetic */ b a;

        public a(b r1) {
            this.a = r1;
        }

        public final void a() {
            ALogger.d("BaseMultiLinkWindowManager", "[smoothEnterRoom] dismiss mock view from layout");
            UtilityKotlinExtentionsKt.x(this.a.a.y);
            this.a.a.Q0();
            Disposable r0 = this.a.a.f;
            if (r0 == null) goto L5;
            r0.dispose();
        L5:
            int r1 = MultiSceneEnterRoomStatisticsUtils.u;
            DataCenter r2 = this.a.a.C;
            com.bytedance.android.livesdk.chatroom.o r3 = com.bytedance.android.live.liveinteract.api.utils.m.n(r2, null, 2);
            long r4 = 0;
            if (r3 == null) goto L12;
            com.bytedance.live.datacontext.m r5 = r3.getRoom();
            if (r5 == null) goto L12;
            IRoom r6 = (IRoom) r5.getValue();
            if (r6 == null) goto L12;
            long r7 = r6.getId();
        L13:
            MultiSceneEnterRoomStatisticsUtils r8 = MultiSceneEnterRoomStatisticsUtils.a.a(r2, Long.valueOf(r7));
            if (r8 == null) goto L16;
            IMultiSceneCommonStatistics.DefaultImpls.recordSubElementShow$default(r8, "guest_seat_load", 0, 2, null);
        L16:
            DataCenter r9 = this.a.a.C;
            com.bytedance.android.livesdk.chatroom.o r10 = com.bytedance.android.live.liveinteract.api.utils.m.n(r9, null, 2);
            if (r10 == null) goto L23;
            com.bytedance.live.datacontext.m r11 = r10.getRoom();
            if (r11 == null) goto L23;
            IRoom r12 = (IRoom) r11.getValue();
            if (r12 == null) goto L23;
            r4 = r12.getId();
        L23:
            MultiSceneEnterRoomStatisticsUtils r13 = MultiSceneEnterRoomStatisticsUtils.a.a(r9, Long.valueOf(r4));
            if (r13 == null) goto L26;
            r13.c();
        L26:
            System.currentTimeMillis();
            return;
        L12:
            r7 = 0;
            goto L13
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        com.bytedance.android.live.liveinteract.plantform.commonwindow.l r0 = this.a.d;
        if (r0 == null) goto L7;
        ViewGroup r1 = r0.td();
        if (r1 == null) goto L7;
        int r2 = r1.getHeight();
    L8:
        if (r2 <= 0) goto L22;
        com.bytedance.android.live.liveinteract.plantform.commonwindow.l r3 = this.a.d;
        if (r3 == null) goto L16;
        ViewGroup r4 = r3.td();
        if (r4 == null) goto L16;
        ViewTreeObserver r5 = r4.getViewTreeObserver();
        if (r5 == null) goto L16;
        r5.removeOnGlobalLayoutListener(this);
    L16:
        Lazy r6 = MultiLinkLoadWidgetUtils.a;
        MultiLinkLoadWidgetUtils.n(this.a.C, "BaseMultiLinkWindowManager", "[smoothEnterRoom] dismiss mock view from layout");
        com.bytedance.android.live.liveinteract.plantform.commonwindow.l r7 = this.a.d;
        if (r7 == null) goto L23;
        ViewGroup r8 = r7.td();
        if (r8 == null) goto L24;
        r8.postDelayed(new a(this), vm2.d.q0().getSeatDrawProtectTime());
        return;
    L24:
        return;
    L23:
        return;
    L22:
        return;
    L7:
        r2 = 0;
        goto L8
    }

    public b(BaseMultiLinkWindowManager r1) {
        this.a = r1;
    }
}
