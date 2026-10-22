package com.bytedance.android.livesdk.gamesticker.hok.anim;

import com.bytedance.android.livesdk.chatroom.model.c3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class b extends a {
    public final c3 d;

    @Override // com.bytedance.android.livesdk.gamesticker.hok.anim.a
    public final void a() {
    }

    @Override // com.bytedance.android.livesdk.gamesticker.hok.anim.a
    public final String e() {
        return "OnlyShowRoleTask";
    }

    @Override // com.bytedance.android.livesdk.gamesticker.hok.anim.a
    public final void d() {
        c(TaskState.START);
        g r0 = this.c;
        if (r0 == null) goto L5;
        r0.d().setRoleInfo(this.d);
        r0.a().setRoleInfo(null);
        r0.c().setLiveInfo(null);
        r0.b().setMoneyCount(null);
        r0.e().setEquipState(null);
    L5:
        c(TaskState.END);
    }

    public b(c3 r2) {
        Intrinsics.checkNotNullParameter(r2, "roleInfo");
        this.d = r2;
    }
}
