package e21;

import com.bytedance.android.live.revlink.impl.global.LinkFakeGlobalService;
import com.bytedance.android.live.revlink.impl.pk.utils.l;
import com.bytedance.android.livesdk.link.model.v3;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.TypesJVMKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b {
    public final com.bytedance.android.live.revlink.impl.global.c a;

    public b(LinkFakeGlobalService r1) {
        this.a = r1;
    }

    public static v3 c(String r2) {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L7
        if (r2 != null) goto L5;
        r2 = "";
    L5:
        Object r3 = Result.constructor-impl((v3) l97.a.a.fromJson(r2, TypesJVMKt.getJavaType(Reflection.typeOf(v3.class))));     // Catch: Throwable -> L7
    L10:
        if (Result.isFailure-impl(r3) == false) goto L13;
        r3 = null;
    L13:
        return (v3) r3;
    L7:
        th = move-exception;
        Result.Companion r1 = Result.Companion;
        r3 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L10
    }

    public static v3 a(String r1, String r2, String r3, String r4, String r5, String r6) {
        Intrinsics.checkNotNullParameter(r4, "listNum");
        Intrinsics.checkNotNullParameter(r5, "inviterRoomStatus");
        Intrinsics.checkNotNullParameter(r6, "inviterConnectCnt");
        v3 r0 = vh7.f.c(v3.class);
        if (r1 != null) goto L5;
        r1 = "";
    L5:
        r0.setPointTag(r1);
        r0.setImprId(r3);
        r0.setInviteMode(r2);
        r0.setListNum(r4);
        r0.setInviterRoomStatus(r5);
        r0.setInviterConnectCnt(r6);
        return r0;
    }

    public static v3 b(b r8, l r9, String r10, String r12, String r13, String r14, String r15, int r16) {
        String r1 = null;
        if ((r16 & 4) == 0) goto L5;
        String r4 = null;
    L7:
        if ((r16 & 8) == 0) goto L9;
        String r5 = "";
    L11:
        if ((r16 & 32) == 0) goto L19;
        com.bytedance.android.live.revlink.impl.global.c r17 = r8.a;
        if (r17 == null) goto L15;
        d31.d r18 = r17.getRevLinkLogHelper();
    L16:
        if (r18 == null) goto L18;
        r14 = r18.s();
        goto L19
    L18:
        r14 = "";
        goto L19
    L15:
        r18 = null;
    L19:
        String r6 = r14;
        if ((r16 & 64) == 0) goto L31;
        com.bytedance.android.live.revlink.impl.global.c r19 = r8.a;
        if (r19 == null) goto L24;
        d31.d r110 = r19.getRevLinkLogHelper();
    L25:
        if (r110 == null) goto L30;
        String r111 = r110.a();
        if (r111 == null) goto L30;
        r15 = r111;
    L30:
        r15 = "";
        goto L31
    L24:
        r110 = null;
    L31:
        String r7 = r15;
        r8.getClass();
        Intrinsics.checkNotNullParameter(r5, "listNum");
        Intrinsics.checkNotNullParameter(r6, "inviterRoomStatus");
        Intrinsics.checkNotNullParameter(r7, "inviterConnectCnt");
        if (r9 == null) goto L35;
        r1 = r9.a;
    L35:
        return a(r1, r10, r4, r5, r6, r7);
    L9:
        r5 = r13;
        goto L11
    L5:
        r4 = r12;
        goto L7
    }
}
