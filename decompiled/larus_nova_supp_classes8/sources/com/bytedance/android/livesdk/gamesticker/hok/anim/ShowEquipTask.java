package com.bytedance.android.livesdk.gamesticker.hok.anim;

import com.bytedance.android.livesdk.chatroom.model.c3;
import com.bytedance.android.livesdk.chatroom.model.j0;
import com.bytedance.android.livesdk.gamesticker.hok.HokGameRoleView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class ShowEquipTask extends c {
    public final c3 e;
    public final j0 f;

    @Override // com.bytedance.android.livesdk.gamesticker.hok.anim.a
    public final String e() {
        return "ShowEquipTask";
    }

    @Override // com.bytedance.android.livesdk.gamesticker.hok.anim.a
    public final void d() {
        c(TaskState.START);
        final g r0 = this.c;
        if (r0 == null) goto L31;
        boolean r1 = c.h(r0);
        boolean r2 = c.i(r0);
        if (r1 == true) goto L10;
        if (r2 == true) goto L10;
        b("left gone, right gone");
        r0.d().setRoleInfo(this.e);
        r0.e().setEquipState(this.f);
        c(TaskState.END);
        return;
    L10:
        if (r1 == false) goto L14;
        if (r2 == true) goto L14;
        b("left visible, right gone");
        c.g(r0).setRoleInfo(this.e);
        r0.e().setEquipState(this.f);
        c(TaskState.END);
        return;
    L14:
        if (r1 == true) goto L18;
        if (r2 == false) goto L18;
        b("left visible, right gone");
        c(TaskState.END);
        return;
    L18:
        b("left visible, right visible");
        boolean r3 = true;
        boolean r4 = !Intrinsics.areEqual(c.g(r0).getRoleInfo(), this.e);
        if (r0.e().getVisibility() != 0) goto L21;
        r0.e().setEquipState(this.f);
        r3 = false;
    L21:
        b("left visible, needChangeLeft: " + r4 + ", right visible needChangeRight: " + r3);
        if (r4 == false) goto L25;
        if (r3 == false) goto L25;
        final HokGameRoleView r6 = c.g(r0);
        final HokGameRoleView r5 = c.f(r0);
        final com.bytedance.android.livesdk.gamesticker.hok.e r7 = n(r0);
        b("needChangeRight  rightVisibleView:" + r7);
        l(r5, r6, r0.e(), r7.getView(), new ShowEquipTask$start$$inlined$let$lambda$1(r5, r0, this), new ShowEquipTask$start$$inlined$let$lambda$2(r6, r7, this));
    L25:
        if (r4 == false) goto L27;
        final HokGameRoleView r8 = c.g(r0);
        final HokGameRoleView r9 = c.f(r0);
        m(r9, r8, new ShowEquipTask$start$$inlined$let$lambda$3(r9, this), new ShowEquipTask$start$$inlined$let$lambda$4(r8, this));
        goto L31
    L27:
        if (r3 == false) goto L29;
        final com.bytedance.android.livesdk.gamesticker.hok.e r10 = n(r0);
        b("needChangeRight  rightVisibleView:" + r10);
        m(r0.e(), r10.getView(), new ShowEquipTask$start$$inlined$let$lambda$5(r0, this), new ShowEquipTask$start$$inlined$let$lambda$6(r10, this));
        goto L31
    L29:
        c(TaskState.END);
    L31:
        if (this.c != null) goto L34;
        c(TaskState.END);
        return;
    }

    public final com.bytedance.android.livesdk.gamesticker.hok.e n(g r2) {
        Intrinsics.checkNotNullParameter(r2, "viewGetter");
        if (r2.b().getVisibility() != 0) goto L7;
        return r2.b();
    L7:
        if (r2.c().getVisibility() != 0) goto L11;
        return r2.c();
    L11:
        return r2.e();
    }

    public ShowEquipTask(c3 r2, j0 r3) {
        Intrinsics.checkNotNullParameter(r2, "roleInfo");
        Intrinsics.checkNotNullParameter(r3, "equipState");
        this.e = r2;
        this.f = r3;
    }
}
