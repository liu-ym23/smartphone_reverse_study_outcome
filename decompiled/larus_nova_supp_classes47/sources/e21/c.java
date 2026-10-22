package e21;

import com.bytedance.android.live.revlink.impl.multianchor.match.MultiPkMatchContext;
import com.bytedance.android.livesdk.link.model.e6;
import com.bytedance.android.livesdk.link.model.i6;
import com.bytedance.android.livesdk.link.model.p0;
import com.bytedance.android.livesdk.link.model.s1;
import com.bytedance.live.datacontext.n;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.TypesJVMKt;
import kotlin.text.StringsKt;
import mz0.o;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c {
    public static final p0 a(i6 r3) {
        if (r3 == null) goto L23;
        e6 r4 = r3.getInvite();
        if (r4 == null) goto L23;
        Object r0 = null;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L12
        String r5 = r4.getBattleAttachedInfoStr();     // Catch: Throwable -> L12
        if (r5 == null) goto L9;
        p0 r6 = (p0) l97.a.a.fromJson(r5, TypesJVMKt.getJavaType(Reflection.typeOf(p0.class)));     // Catch: Throwable -> L12
    L10:
        Object r7 = Result.constructor-impl(r6);     // Catch: Throwable -> L12
    L15:
        if (Result.isFailure-impl(r7) == true) goto L18;
        r0 = r7;
    L18:
        p0 r2 = (p0) r0;
        if (r2 != null) goto L21;
        r2 = (p0) vh7.f.c(p0.class);
    L21:
        if (r2 == null) goto L23;
        return r2;
    L9:
        r6 = null;
    L12:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
    L23:
        return vh7.f.c(p0.class);
    }

    public static final p0 b(s1 r3) {
        Object r0 = null;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L11
        if (r3 == null) goto L8;
        String r4 = r3.getBattleAttachedInfo();     // Catch: Throwable -> L11
        if (r4 == null) goto L8;
        p0 r5 = (p0) l97.a.a.fromJson(r4, TypesJVMKt.getJavaType(Reflection.typeOf(p0.class)));     // Catch: Throwable -> L11
    L9:
        Object r6 = Result.constructor-impl(r5);     // Catch: Throwable -> L11
    L14:
        if (Result.isFailure-impl(r6) == true) goto L17;
        r0 = r6;
    L17:
        p0 r2 = (p0) r0;
        if (r2 == null) goto L20;
        return r2;
    L20:
        return vh7.f.c(p0.class);
    L8:
        r5 = null;
    L11:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L14
    }

    public static final p0 c(p0.a r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "$this$parse");
        Object r4 = null;
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L9
        if (r3 == null) goto L6;
        p0 r5 = (p0) l97.a.a.fromJson(r3, TypesJVMKt.getJavaType(Reflection.typeOf(p0.class)));     // Catch: Throwable -> L9
    L7:
        Object r6 = Result.constructor-impl(r5);     // Catch: Throwable -> L9
    L12:
        if (Result.isFailure-impl(r6) == true) goto L16;
        r4 = r6;
    L16:
        return (p0) r4;
    L6:
        r5 = null;
    L9:
        th = move-exception;
        Result.Companion r1 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L12
    }

    public static final void d(o r1, MultiPkMatchContext r2) {
        Intrinsics.checkNotNullParameter(r1, "$this$putBattleInfo");
        p0.a r0 = p0.Companion;
        if (r2 == null) goto L7;
        n<String> r3 = r2.getBattleAttachedInfo();
        if (r3 == null) goto L7;
        String r4 = (String) r3.getValue();
    L8:
        e(r1, c(r0, r4));
        return;
    L7:
        r4 = null;
        goto L8
    }

    public static final void e(o r1, p0 r2) {
        Intrinsics.checkNotNullParameter(r1, "$this$putBattleInfo");
        if (r2 != null) goto L5;
        return;
    L5:
        String r3 = r2.getStrategyLogId();
        if (r3 != null) goto L8;
        return;
    L8:
        if ((!StringsKt.isBlank(r3)) == true) goto L11;
        r3 = null;
    L11:
        if (r3 == null) goto L15;
        r1.a("request_id", r3);
        return;
    }
}
