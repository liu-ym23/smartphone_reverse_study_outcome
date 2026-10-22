package com.bytedance.android.livesdk.floatview.inner;

import android.app.Application;
import android.os.CountDownTimer;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.floatview.IInnerFloatWindowManager;
import com.bytedance.android.livesdkapi.floatview.InnerFloatViewTAG;
import com.bytedance.android.livesdkapi.floatview.InnerFloatWindowHelper;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class i extends rx1.c {
    public final /* synthetic */ VideoWatchingInnerFloatWindowManager a;

    public static final class a extends CountDownTimer {
        public final /* synthetic */ i a;

        @Override // android.os.CountDownTimer
        public final void onFinish() {
        }

        @Override // android.os.CountDownTimer
        public final void onTick(long r6) {
            if (r6 >= 15000) goto L15;
            if (r6 <= 10000) goto L15;
            k r0 = this.a.a.j;
            if (r0 == null) goto L15;
            TextView r1 = r0.m;
            if (r1 == null) goto L11;
            r1.setVisibility(8);
        L11:
            RelativeLayout r2 = r0.n;
            if (r2 == null) goto L15;
            r2.setVisibility(0);
        L15:
            if (r6 > 10000) goto L25;
            k r7 = this.a.a.j;
            if (r7 == null) goto L26;
            TextView r8 = r7.m;
            if (r8 == null) goto L21;
            r8.setVisibility(8);
        L21:
            RelativeLayout r9 = r7.n;
            if (r9 == null) goto L27;
            r9.setVisibility(8);
            return;
        L27:
            return;
        L26:
            return;
        }

        public a(long r3, i r5) {
            this.a = r5;
            super(r3, 1000);
        }
    }

    @Override // rx1.c, rx1.e
    public final void a() {
        com.bytedance.android.livesdk.floatview.mob.b r0 = this.a.i;
        if (r0 == null) goto L6;
        r0.m();
        return;
    }

    @Override // rx1.c, rx1.e
    public final void onClick() {
        if (b.h.a == false) goto L15;
        int r0 = com.bytedance.android.livesdk.floatview.l.a;
        Application r1 = jc1.a.b();
        Application r2 = jc1.a.b();
        if (r2 == null) goto L8;
        String r3 = r2.getPackageName();
        if (r3 == null) goto L8;
    L10:
        if (com.bytedance.android.livesdk.floatview.l.b(r1, r3) == false) goto L19;
        VideoWatchingInnerFloatWindowManager r4 = this.a;
        com.bytedance.android.livesdk.floatview.mob.b r5 = r4.i;
        if (r5 == null) goto L14;
        Room r6 = r4.b;
        int r7 = com.bytedance.android.livesdk.floatview.mob.b.o;
        r5.k(r6, null);
    L14:
        VideoWatchingInnerFloatWindowManager.b(this.a);
        IInnerFloatWindowManager.DefaultImpls.dismissFloatWindow$default(this.a, 0, null, false, 7, null);
    L19:
        f.a("click window");
        InnerFloatWindowHelper.triggerWindowCallBack$default(InnerFloatWindowHelper.INSTANCE, this.a.m, InnerFloatWindowHelper.ActionType.CLICK, false, 4, null);
        return;
    L8:
        r3 = "";
        goto L10
    L15:
        VideoWatchingInnerFloatWindowManager r8 = this.a;
        com.bytedance.android.livesdk.floatview.mob.b r9 = r8.i;
        if (r9 == null) goto L18;
        Room r10 = r8.b;
        int r11 = com.bytedance.android.livesdk.floatview.mob.b.o;
        r9.k(r10, null);
    L18:
        VideoWatchingInnerFloatWindowManager.b(this.a);
        IInnerFloatWindowManager.DefaultImpls.dismissFloatWindow$default(this.a, 0, null, false, 7, null);
        goto L19
    }

    @Override // rx1.e
    public final void onShow() {
        if (Intrinsics.areEqual(this.a.a, InnerFloatViewTAG.TAG_LOTTERY_PREVIEW.getTag()) == false) goto L22;
        CountDownTimer r0 = this.a.n;
        if (r0 == null) goto L7;
        r0.cancel();
        this.a.n = null;
    L7:
        Long r1 = this.a.l;
        if (r1 == null) goto L22;
        long r2 = r1.longValue() - System.currentTimeMillis();
        if (r2 > 10000) goto L19;
        k r3 = this.a.j;
        if (r3 == null) goto L19;
        TextView r4 = r3.m;
        if (r4 == null) goto L16;
        r4.setVisibility(8);
    L16:
        RelativeLayout r5 = r3.n;
        if (r5 == null) goto L19;
        r5.setVisibility(8);
    L19:
        this.a.n = new a(r2, this);
        CountDownTimer r6 = this.a.n;
        if (r6 == null) goto L22;
        r6.start();
    L22:
        InnerFloatWindowHelper.triggerWindowCallBack$default(InnerFloatWindowHelper.INSTANCE, this.a.m, InnerFloatWindowHelper.ActionType.SHOW, false, 4, null);
    }

    public i(VideoWatchingInnerFloatWindowManager r1) {
        this.a = r1;
    }
}
