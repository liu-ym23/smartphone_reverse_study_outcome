package com.bytedance.android.livesdk.gamesticker.hok.anim;

import com.bytedance.android.livesdk.chatroom.model.j0;
import com.bytedance.android.livesdk.chatroom.model.k2;
import com.bytedance.android.livesdk.chatroom.model.o;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class f extends a {
    public final o d;

    @Override // com.bytedance.android.livesdk.gamesticker.hok.anim.a
    public final void a() {
    }

    @Override // com.bytedance.android.livesdk.gamesticker.hok.anim.a
    public final String e() {
        return "UpdateBattleTask";
    }

    @Override // com.bytedance.android.livesdk.gamesticker.hok.anim.a
    public final void d() {
        c(TaskState.START);
        g r0 = this.c;
        if (r0 == null) goto L52;
        o r1 = this.d;
        k2 r2 = null;
        if (r1 != null) goto L7;
    L16:
        j0 r3 = null;
    L17:
        if (r3 != null) goto L19;
    L21:
        o r4 = this.d;
        if (r4 != null) goto L24;
    L48:
        if (r2 == null) goto L52;
        if (r0.b().getVisibility() != 0) goto L52;
        b("UpdateBattleTask update moneyView");
        r0.b().setMoneyCount(r2);
        goto L52
    L24:
        if (r4.b() == null) goto L48;
        k2 r5 = r4.b();
        if (r5 == null) goto L29;
        String r6 = r5.b();
    L30:
        boolean r7 = true;
        if (r6 != null) goto L33;
    L36:
        boolean r8 = true;
    L37:
        if (r8 == true) goto L48;
        if (r5 == null) goto L40;
        String r9 = r5.a();
    L41:
        if (r9 != null) goto L43;
    L46:
        if (r7 == true) goto L48;
        r2 = r5;
        goto L48
    L43:
        if (r9.length() == 0) goto L46;
        r7 = false;
        goto L46
    L40:
        r9 = null;
        goto L41
    L33:
        if (r6.length() == 0) goto L36;
        r8 = false;
        goto L37
    L29:
        r6 = null;
        goto L30
    L19:
        if (r0.e().getVisibility() != 0) goto L21;
        b("UpdateBattleTask update equipView");
        r0.e().setEquipState(r3);
        goto L21
    L7:
        if (r1.a() == null) goto L16;
        j0 r10 = r1.a();
        if (r10 == null) goto L12;
        long r11 = r10.a();
    L14:
        if (r11 <= 0) goto L16;
        r3 = r1.a();
        goto L17
    L12:
        r11 = 0;
    L52:
        c(TaskState.END);
    }

    public f(o r2) {
        Intrinsics.checkNotNullParameter(r2, "battleInfo");
        this.d = r2;
    }
}
