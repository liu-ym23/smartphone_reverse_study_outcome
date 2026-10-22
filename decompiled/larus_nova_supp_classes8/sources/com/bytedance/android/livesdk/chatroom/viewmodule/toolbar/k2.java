package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar;

import com.bytedance.android.livesdk.chatroom.progress.service.IPlayerProgressService;
import com.bytedance.android.livesdk.chatroom.vsplayer.api.IVSPlayerService;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.Widget;
import io.reactivex.disposables.Disposable;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class k2 implements BaseActionSheet.c {
    public final /* synthetic */ ScheduleCloseWidget a;

    public k2(ScheduleCloseWidget r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.BaseActionSheet.c
    public final void a(BaseActionSheet.d r9) {
        Intrinsics.checkNotNullParameter(r9, "item");
        int r0 = i2.d;
        int r10 = r9.b;
        if (r0 != r10) goto L5;
        return;
    L5:
        i2.d = r10;
        if (r10 == 0) goto L27;
        if (r10 != 1) goto L9;
        Disposable r11 = i2.c;
        if (r11 == null) goto L21;
        r11.dispose();
    L21:
        i2.e = -1;
        ScheduleCloseWidget r12 = this.a;
        int r4 = ScheduleCloseWidget.d;
        r12.getClass();
        IVSPlayerService r5 = (IVSPlayerService) jc1.k.f(IVSPlayerService.class);
        if (r5 == null) goto L26;
        IPlayerProgressService r6 = r5.provideVSProgressService(((Widget) r12).dataCenter);
        if (r6 == null) goto L26;
        r6.addProgressChangeListener(r12.b);
    L26:
        ScheduleCloseWidget.wq(this.a, com.bytedance.android.live.core.utils.s1.B(2131923383));
        Intrinsics.checkNotNullParameter("until_the_episode", "<set-?>");
        i2.f = "until_the_episode";
    L31:
        com.bytedance.android.livesdk.log.u.l().sendLog("timing_off_option_click", MapsKt.mapOf(TuplesKt.to("vs_timingoff_type", i2.f)), new Object[]{Room.class, am2.x.class});
        return;
    L9:
        if (r10 != 2) goto L11;
        ScheduleCloseWidget r13 = this.a;
        int r7 = ScheduleCloseWidget.d;
        r13.xq();
        i2.b(1800000);
        ScheduleCloseWidget.wq(this.a, com.bytedance.android.live.core.utils.s1.C(2131923384, new Object[]{30L}));
        Intrinsics.checkNotNullParameter("30min", "<set-?>");
        i2.f = "30min";
        goto L31
    L11:
        if (r10 != 3) goto L13;
        ScheduleCloseWidget r14 = this.a;
        int r8 = ScheduleCloseWidget.d;
        r14.xq();
        i2.b(3600000);
        ScheduleCloseWidget.wq(this.a, com.bytedance.android.live.core.utils.s1.C(2131923384, new Object[]{60L}));
        Intrinsics.checkNotNullParameter("60min", "<set-?>");
        i2.f = "60min";
        goto L31
    L13:
        if (r10 == 4) goto L15;
        Intrinsics.checkNotNullParameter("cancel", "<set-?>");
        i2.f = "cancel";
        goto L31
    L15:
        ScheduleCloseWidget r15 = this.a;
        int r2 = ScheduleCloseWidget.d;
        r15.xq();
        i2.b(60000);
        ScheduleCloseWidget.wq(this.a, com.bytedance.android.live.core.utils.s1.C(2131923384, new Object[]{1}) + "(测试)");
        goto L31
    L27:
        ScheduleCloseWidget r16 = this.a;
        int r17 = ScheduleCloseWidget.d;
        r16.xq();
        Disposable r18 = i2.c;
        if (r18 == null) goto L30;
        r18.dispose();
    L30:
        i2.e = -2;
        Intrinsics.checkNotNullParameter("not_start", "<set-?>");
        i2.f = "not_start";
        goto L31
    }
}
