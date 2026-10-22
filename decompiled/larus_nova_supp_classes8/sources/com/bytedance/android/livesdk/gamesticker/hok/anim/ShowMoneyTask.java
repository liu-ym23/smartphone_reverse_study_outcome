package com.bytedance.android.livesdk.gamesticker.hok.anim;

import com.bytedance.android.livesdk.chatroom.model.c3;
import com.bytedance.android.livesdk.chatroom.model.k2;
import com.bytedance.android.livesdk.gamesticker.hok.HokGameRoleView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class ShowMoneyTask extends c {
    public final c3 e;
    public final k2 f;

    @Override // com.bytedance.android.livesdk.gamesticker.hok.anim.a
    public final String e() {
        return "ShowMoneyTask";
    }

    @Override // com.bytedance.android.livesdk.gamesticker.hok.anim.a
    public final void d() {
        c(TaskState.START);
        final g r0 = this.c;
        if (r0 == null) goto L32;
        boolean r1 = c.h(r0);
        boolean r2 = c.i(r0);
        if (r1 == true) goto L11;
        if (c.i(r0) == true) goto L11;
        b("left gone, right gone");
        r0.d().setRoleInfo(this.e);
        r0.b().setMoneyCount(this.f);
        c(TaskState.END);
        return;
    L11:
        if (r1 == false) goto L15;
        if (r2 == true) goto L15;
        b("left visible, right gone");
        c.g(r0).setRoleInfo(this.e);
        r0.b().setMoneyCount(this.f);
        c(TaskState.END);
        return;
    L15:
        if (r1 == true) goto L19;
        if (r2 == false) goto L19;
        b("left visible, right gone");
        c(TaskState.END);
        return;
    L19:
        b("left visible, right visible");
        boolean r3 = true;
        boolean r4 = !Intrinsics.areEqual(c.g(r0).getRoleInfo(), this.e);
        if (r0.b().getVisibility() != 0) goto L22;
        r0.b().setMoneyCount(this.f);
        r3 = false;
    L22:
        b("left visible, needChangeLeft: " + r4 + ", right visible needChangeRight: " + r3);
        if (r4 == false) goto L26;
        if (r3 == false) goto L26;
        final HokGameRoleView r6 = c.g(r0);
        final HokGameRoleView r5 = c.f(r0);
        final com.bytedance.android.livesdk.gamesticker.hok.e r7 = n(r0);
        b("needChangeRight  rightVisibleView:" + r7);
        l(r5, r6, r0.b(), r7.getView(), new ShowMoneyTask$start$$inlined$let$lambda$1(r5, r0, this), new ShowMoneyTask$start$$inlined$let$lambda$2(r6, r7, this));
    L26:
        if (r4 == false) goto L28;
        final HokGameRoleView r8 = c.g(r0);
        final HokGameRoleView r9 = c.f(r0);
        m(r9, r8, new ShowMoneyTask$start$$inlined$let$lambda$3(r9, this), new ShowMoneyTask$start$$inlined$let$lambda$4(r8, this));
        goto L32
    L28:
        if (r3 == false) goto L30;
        final com.bytedance.android.livesdk.gamesticker.hok.e r10 = n(r0);
        b("needChangeRight  rightVisibleView:" + r10);
        m(r0.b(), r10.getView(), new ShowMoneyTask$start$$inlined$let$lambda$5(r0, this), new ShowMoneyTask$start$$inlined$let$lambda$6(r10, this));
        goto L32
    L30:
        c(TaskState.END);
    L32:
        if (this.c != null) goto L35;
        c(TaskState.END);
        return;
    }

    public final com.bytedance.android.livesdk.gamesticker.hok.e n(g r2) {
        Intrinsics.checkNotNullParameter(r2, "viewGetter");
        if (r2.e().getVisibility() != 0) goto L7;
        return r2.e();
    L7:
        if (r2.c().getVisibility() != 0) goto L11;
        return r2.c();
    L11:
        return r2.b();
    }

    public ShowMoneyTask(c3 r2, k2 r3) {
        Intrinsics.checkNotNullParameter(r2, "roleInfo");
        Intrinsics.checkNotNullParameter(r3, "moneyCount");
        this.e = r2;
        this.f = r3;
    }
}
