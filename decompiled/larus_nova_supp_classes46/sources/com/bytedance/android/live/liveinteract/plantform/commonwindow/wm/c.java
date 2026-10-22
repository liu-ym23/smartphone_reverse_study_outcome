package com.bytedance.android.live.liveinteract.plantform.commonwindow.wm;

import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.liveinteract.utils.MultiLinkLoadWidgetUtils;
import com.bytedance.android.live.liveinteract.utils.MultiSceneEnterRoomStatisticsUtils;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.util.IMultiSceneCommonStatistics;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import zg1.p2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c implements ViewTreeObserver.OnGlobalLayoutListener {
    public final /* synthetic */ BaseMultiLinkWindowManager a;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ c a;

        public a(c r1) {
            this.a = r1;
        }

        public final void accept(Object r12) {
            Long r13 = (Long) r12;
            ALogger.d("BaseMultiLinkWindowManager", "[smoothEnterRoom] dismiss mock view from layout");
            UtilityKotlinExtentionsKt.x(this.a.a.y);
            this.a.a.C.put("cmd_multi_enter_room_remove_view_mock", Boolean.TRUE);
            this.a.a.C.put("cmd_voice_chat_room_show_background", new p2("observeWindowDraw_immediately"));
            Disposable r14 = this.a.a.f;
            if (r14 == null) goto L5;
            r14.dispose();
        L5:
            int r15 = MultiSceneEnterRoomStatisticsUtils.u;
            DataCenter r16 = this.a.a.C;
            com.bytedance.android.livesdk.chatroom.o r2 = com.bytedance.android.live.liveinteract.api.utils.m.n(r16, null, 2);
            long r3 = 0;
            if (r2 == null) goto L12;
            com.bytedance.live.datacontext.m r4 = r2.getRoom();
            if (r4 == null) goto L12;
            IRoom r5 = (IRoom) r4.getValue();
            if (r5 == null) goto L12;
            long r6 = r5.getId();
        L13:
            MultiSceneEnterRoomStatisticsUtils r7 = MultiSceneEnterRoomStatisticsUtils.a.a(r16, Long.valueOf(r6));
            if (r7 == null) goto L16;
            IMultiSceneCommonStatistics.DefaultImpls.recordSubElementShow$default(r7, "guest_seat_load", 0, 2, null);
        L16:
            DataCenter r17 = this.a.a.C;
            com.bytedance.android.livesdk.chatroom.o r0 = com.bytedance.android.live.liveinteract.api.utils.m.n(r17, null, 2);
            if (r0 == null) goto L23;
            com.bytedance.live.datacontext.m r1 = r0.getRoom();
            if (r1 == null) goto L23;
            IRoom r8 = (IRoom) r1.getValue();
            if (r8 == null) goto L23;
            r3 = r8.getId();
        L23:
            MultiSceneEnterRoomStatisticsUtils r18 = MultiSceneEnterRoomStatisticsUtils.a.a(r17, Long.valueOf(r3));
            if (r18 == null) goto L26;
            r18.c();
        L26:
            System.currentTimeMillis();
            return;
        L12:
            r6 = 0;
            goto L13
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
        if (r2 <= 0) goto L45;
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
        long r7 = vm2.h.S().a();
        long r8 = 0;
        if (r7 != 0) goto L43;
        ALogger.d("BaseMultiLinkWindowManager", "[smoothEnterRoom] dismiss mock view from layout");
        UtilityKotlinExtentionsKt.x(this.a.y);
        this.a.Q0();
        Disposable r9 = this.a.f;
        if (r9 == null) goto L21;
        r9.dispose();
    L21:
        int r10 = MultiSceneEnterRoomStatisticsUtils.u;
        DataCenter r11 = this.a.C;
        com.bytedance.android.livesdk.chatroom.o r12 = com.bytedance.android.live.liveinteract.api.utils.m.n(r11, null, 2);
        if (r12 == null) goto L28;
        com.bytedance.live.datacontext.m r13 = r12.getRoom();
        if (r13 == null) goto L28;
        IRoom r14 = (IRoom) r13.getValue();
        if (r14 == null) goto L28;
        long r15 = r14.getId();
    L29:
        MultiSceneEnterRoomStatisticsUtils r16 = MultiSceneEnterRoomStatisticsUtils.a.a(r11, Long.valueOf(r15));
        if (r16 == null) goto L32;
        IMultiSceneCommonStatistics.DefaultImpls.recordSubElementShow$default(r16, "guest_seat_load", 0, 2, null);
    L32:
        DataCenter r17 = this.a.C;
        com.bytedance.android.livesdk.chatroom.o r18 = com.bytedance.android.live.liveinteract.api.utils.m.n(r17, null, 2);
        if (r18 == null) goto L39;
        com.bytedance.live.datacontext.m r19 = r18.getRoom();
        if (r19 == null) goto L39;
        IRoom r20 = (IRoom) r19.getValue();
        if (r20 == null) goto L39;
        r8 = r20.getId();
    L39:
        MultiSceneEnterRoomStatisticsUtils r21 = MultiSceneEnterRoomStatisticsUtils.a.a(r17, Long.valueOf(r8));
        if (r21 == null) goto L42;
        r21.c();
    L42:
        System.currentTimeMillis();
        return;
    L28:
        r15 = 0;
        goto L29
    L43:
        this.a.e.add(Observable.timer(r7, TimeUnit.MILLISECONDS).compose(RxUtil.rxSchedulerHelper()).subscribe(new a(this)));
        return;
    L45:
        return;
    L7:
        r2 = 0;
        goto L8
    }

    public c(BaseMultiLinkWindowManager r1) {
        this.a = r1;
    }
}
