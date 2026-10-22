package com.bytedance.android.livesdk.gamesticker.t01.anim;

import android.view.View;
import com.bytedance.android.livesdk.chatroom.model.r3;
import com.bytedance.android.livesdk.chatroom.model.t3;
import com.bytedance.android.livesdk.gamesticker.t01.T01GameLiveView;
import com.bytedance.android.livesdk.gamesticker.t01.T01GameRoleView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class ShowInfoTask extends d {
    public final t3 e;
    public final r3 f;

    @Override // com.bytedance.android.livesdk.gamesticker.t01.anim.b
    public final String e() {
        return "ShowInfoTask";
    }

    @Override // com.bytedance.android.livesdk.gamesticker.t01.anim.b
    public final void d() {
        c(TaskState.START);
        i r0 = this.c;
        if (r0 == null) goto L24;
        boolean r2 = d.g(new View[]{r0.d(), r0.a()});
        boolean r3 = d.g(new View[]{r0.c(), r0.b()});
        if (r2 == true) goto L8;
        if (r3 == true) goto L8;
        b("left gone, right gone");
        r0.d().setRoleInfo(this.e);
        r0.c().setLiveInfo(this.f);
        c(TaskState.END);
    L8:
        if (r2 == false) goto L11;
        if (r3 == true) goto L11;
        b("left visible, right gone");
        l(r0).setRoleInfo(this.e);
        r0.c().setLiveInfo(this.f);
        c(TaskState.END);
    L11:
        if (r2 == true) goto L14;
        if (r3 == false) goto L14;
        b("left gone, right visible");
        c(TaskState.END);
    L14:
        b("left visible, right visible");
        boolean r4 = !Intrinsics.areEqual(l(r0).getRoleInfo(), this.e);
        boolean r5 = !Intrinsics.areEqual(((T01GameLiveView) d.f(new T01GameLiveView[]{r0.c(), r0.b()}, r0.c(), 0)).getLiveInfo(), this.f);
        final T01GameRoleView r8 = l(r0);
        final T01GameRoleView r7 = (T01GameRoleView) d.f(new T01GameRoleView[]{r0.d(), r0.a()}, r0.d(), 8);
        final T01GameLiveView r10 = (T01GameLiveView) d.f(new T01GameLiveView[]{r0.c(), r0.b()}, r0.c(), 0);
        final T01GameLiveView r9 = (T01GameLiveView) d.f(new T01GameLiveView[]{r0.c(), r0.b()}, r0.c(), 8);
        b("needChangeLeft: " + r4 + ", needChangeRight: " + r5);
        if (r4 == false) goto L18;
        if (r5 == false) goto L18;
        j(r7, r8, r9, r10, new ShowInfoTask$start$$inlined$let$lambda$1(r7, r9, this), new ShowInfoTask$start$$inlined$let$lambda$2(r8, r10, this));
    L18:
        if (r4 == false) goto L20;
        k(r7, r8, new ShowInfoTask$start$$inlined$let$lambda$3(r7, this), new ShowInfoTask$start$$inlined$let$lambda$4(r8, this));
        goto L24
    L20:
        if (r5 == false) goto L22;
        k(r9, r10, new ShowInfoTask$start$$inlined$let$lambda$5(r9, this), new ShowInfoTask$start$$inlined$let$lambda$6(r10, this));
        goto L24
    L22:
        c(TaskState.END);
    L24:
        if (this.c != null) goto L27;
        c(TaskState.END);
        return;
    }

    public static T01GameRoleView l(i r4) {
        return (T01GameRoleView) d.f(new T01GameRoleView[]{r4.d(), r4.a()}, r4.d(), 0);
    }

    public ShowInfoTask(t3 r2, r3 r3) {
        Intrinsics.checkNotNullParameter(r2, "roleInfo");
        Intrinsics.checkNotNullParameter(r3, "liveInfo");
        this.e = r2;
        this.f = r3;
    }
}
