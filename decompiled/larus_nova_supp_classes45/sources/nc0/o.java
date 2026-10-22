package nc0;

import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.linker.BattleConfigSetting;
import com.bytedance.android.livesdkapi.depend.model.live.linker.LinkerInviteContent;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class o {
    public static final fy.b a(d11.b r15) {
        Intrinsics.checkNotNullParameter(r15, "$this$toApplyParams");
        int r2 = r15.a;
        long r3 = r15.b;
        long r5 = r15.c;
        int r7 = r15.d;
        String r8 = r15.e;
        String r9 = r15.f;
        long r11 = r15.g;
        Room r1 = r15.h;
        if (r1 == null) goto L7;
        return new fy.b(r2, r3, r5, r7, r8, r9, r11, r1, r15.i, r15.j);
    L7:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdkapi.depend.model.live.Room");
    }

    public static final fy.c b(d11.c r12) {
        Intrinsics.checkNotNullParameter(r12, "$this$toCancelParams");
        int r2 = r12.a;
        long r3 = r12.b;
        long r5 = r12.c;
        String r1 = r12.d;
        if (r1 != null) goto L5;
        r1 = "0";
    L5:
        String r7 = r1;
        String r4 = r12.e;
        if (r4 != null) goto L9;
        r4 = "";
    L9:
        return new fy.c(r2, r3, r5, r7, r4, r12.f, r12.g, r12.h);
    }

    public static final fy.e c(d11.d r31) {
        Intrinsics.checkNotNullParameter(r31, "$this$toInviteParams");
        int r3 = r31.a;
        long r4 = r31.b;
        long r6 = r31.c;
        int r8 = r31.d;
        int r9 = r31.e;
        String r2 = r31.f;
        if (r2 != null) goto L5;
        r2 = "0";
    L5:
        String r11 = r2;
        String r5 = r31.g;
        if (r5 != null) goto L8;
        r5 = "";
    L8:
        String r12 = r5;
        Room r7 = r31.h;
        if (r7 != null) goto L12;
        r7 = new Room();
    L12:
        return new fy.e(r3, r4, r6, r8, r9, r11, r12, r7, r31.j, r31.k, r31.l, r31.m, r31.n, r31.o, r31.p, r31.q, r31.r, r31.s, r31.t, r31.u, r31.v, r31.w, r31.y);
    }

    public static final fy.i d(d11.f r11) {
        Intrinsics.checkNotNullParameter(r11, "$this$toPermitParams");
        int r2 = r11.a;
        long r3 = r11.b;
        int r5 = r11.c;
        long r6 = r11.d;
        String r1 = r11.e;
        if (r1 != null) goto L6;
        r1 = "0";
    L6:
        return new fy.i(r2, r3, r5, r6, r1, r11.f);
    }

    public static final fy.j e(d11.g r32) {
        Intrinsics.checkNotNullParameter(r32, "$this$toReplyParams");
        int r3 = r32.a;
        long r4 = r32.c;
        long r6 = r32.d;
        int r8 = r32.e;
        String r2 = r32.f;
        if (r2 != null) goto L5;
        String r11 = "0";
    L6:
        String r12 = r32.g;
        Boolean r13 = r32.h;
        Integer r14 = r32.i;
        d11.a r0 = r32.j;
        Intrinsics.checkNotNullParameter(r0, "$this$toAnchorReplyParams");
        int r15 = r0.a;
        int r5 = r0.b;
        int r16 = r0.c;
        com.bytedance.android.livesdk.link.model.bridge.p r9 = r0.d;
        vh7.c r17 = null;
        if (r9 == null) goto L9;
        vh7.c r18 = k.a(r9);
    L10:
        BattleConfigSetting r19 = (BattleConfigSetting) r18;
        boolean r21 = r0.e;
        boolean r110 = r0.f;
        boolean r111 = r0.g;
        String r112 = r0.h;
        String r31 = r11;
        int r113 = r0.i;
        String r114 = r0.j;
        if (r114 != null) goto L13;
        String r25 = "0";
    L14:
        vh7.c r1 = r0.k;
        if (r1 == null) goto L18;
        r17 = k.a(r1);
    L18:
        return new fy.j(r3, r4, r6, r8, r31, r12, r13, r14, new fy.a(r15, r5, r16, 0, r19, r21, r110, r111, r112, r113, r25, (LinkerInviteContent) r17));
    L13:
        r25 = r114;
        goto L14
    L9:
        r18 = null;
        goto L10
    L5:
        r11 = r2;
        goto L6
    }
}
