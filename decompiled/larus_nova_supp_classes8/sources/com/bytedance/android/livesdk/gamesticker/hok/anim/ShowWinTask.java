package com.bytedance.android.livesdk.gamesticker.hok.anim;

import com.bytedance.android.livesdk.chatroom.model.b2;
import com.bytedance.android.livesdk.chatroom.model.c3;
import com.bytedance.android.livesdk.gamesticker.hok.HokGameRoleView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class ShowWinTask extends c {
    public final c3 e;
    public final b2 f;

    @Override // com.bytedance.android.livesdk.gamesticker.hok.anim.a
    public final String e() {
        return "ShowWinTask";
    }

    @Override // com.bytedance.android.livesdk.gamesticker.hok.anim.a
    public final void d() {
        c(TaskState.START);
        final g r0 = this.c;
        if (r0 == null) goto L27;
        boolean r1 = c.h(r0);
        boolean r2 = c.i(r0);
        if (r1 == true) goto L8;
        if (r2 == true) goto L8;
        b("left gone, right gone");
        r0.d().setRoleInfo(this.e);
        r0.c().setLiveInfo(this.f);
        c(TaskState.END);
    L8:
        if (r1 == false) goto L11;
        if (r2 == true) goto L11;
        b("left visible, right gone");
        c.g(r0).setRoleInfo(this.e);
        r0.c().setLiveInfo(this.f);
        c(TaskState.END);
    L11:
        if (r1 == true) goto L14;
        if (r2 == false) goto L14;
        b("left gone, right visible");
        c(TaskState.END);
    L14:
        b("left visible, right visible");
        boolean r3 = true;
        boolean r4 = !Intrinsics.areEqual(c.g(r0).getRoleInfo(), this.e);
        if (r0.c().getVisibility() != 0) goto L17;
        r0.c().setLiveInfo(this.f);
        r3 = false;
    L17:
        b("left visible, needChangeLeft: " + r4 + ", right visible needChangeRight: " + r3);
        if (r4 == false) goto L21;
        if (r3 == false) goto L21;
        final HokGameRoleView r6 = c.g(r0);
        final HokGameRoleView r5 = c.f(r0);
        final com.bytedance.android.livesdk.gamesticker.hok.e r7 = n(r0);
        b("needChangeRight  rightVisibleView:" + r7);
        l(r5, r6, r0.c(), r7.getView(), new ShowWinTask$start$$inlined$let$lambda$1(r5, r0, this), new ShowWinTask$start$$inlined$let$lambda$2(r6, r7, this));
    L21:
        if (r4 == false) goto L23;
        final HokGameRoleView r8 = c.g(r0);
        final HokGameRoleView r9 = c.f(r0);
        m(r9, r8, new ShowWinTask$start$$inlined$let$lambda$3(r9, this), new ShowWinTask$start$$inlined$let$lambda$4(r8, this));
        goto L27
    L23:
        if (r3 == false) goto L25;
        final com.bytedance.android.livesdk.gamesticker.hok.e r10 = n(r0);
        b("needChangeRight  rightVisibleView:" + r10);
        m(r0.c(), r10.getView(), new ShowWinTask$start$$inlined$let$lambda$5(r0, this), new ShowWinTask$start$$inlined$let$lambda$6(r10, this));
        goto L27
    L25:
        c(TaskState.END);
    L27:
        if (this.c != null) goto L30;
        c(TaskState.END);
        return;
    }

    public final com.bytedance.android.livesdk.gamesticker.hok.e n(g r2) {
        Intrinsics.checkNotNullParameter(r2, "viewGetter");
        if (r2.e().getVisibility() != 0) goto L7;
        return r2.e();
    L7:
        if (r2.b().getVisibility() != 0) goto L11;
        return r2.b();
    L11:
        return r2.c();
    }

    public ShowWinTask(c3 r2, b2 r3) {
        Intrinsics.checkNotNullParameter(r2, "roleInfo");
        Intrinsics.checkNotNullParameter(r3, "winInfo");
        this.e = r2;
        this.f = r3;
    }
}
