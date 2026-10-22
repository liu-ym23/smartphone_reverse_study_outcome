package tsc;

import com.larus.business.markdown.api.depend.IMarkdownEnsureManagerKt;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class e extends i {
    public static boolean h;

    public static final class a {
    }

    static {
    }

    @Override // tsc.h
    public final void o(lsc.m r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "visitor");
        if (r3 != null) goto L5;
    L17:
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L9
        super.o(r2, r3);     // Catch: Throwable -> L9
        Object r4 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L9
    L11:
        Throwable r5 = Result.exceptionOrNull-impl(r4);
        if (r5 == null) goto L19;
        com.larus.business.markdown.api.depend.c r6 = IMarkdownEnsureManagerKt.a();
        if (r6 == null) goto L20;
        r6.ensureNotReachHere(r5, String.valueOf(r5.getMessage()));
        return;
    L20:
        return;
    L19:
        return;
    L9:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        r4 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L11
    L5:
        if (h == true) goto L17;
        h = true;
        goto L17
    }

    public e(List r2, Map r3, boolean r4, boolean r5, boolean r6) {
        n(new y(r3, r4));
        n(new f(r3, r4));
        n(new p(r3, r4));
        n(new z(r3, r4));
        n(new c0(r3, r4));
        n(new tw8.c(r2, r5, r6));
        Set r7 = SetsKt.setOf(new String[]{"data-block", "data-block-full", "img-gallery"});
        this.f.addAll(r7);
        this.b.b.addAll(r7);
        Set r8 = SetsKt.setOf(new String[]{"data-inline", "data-inline-no-margin"});
        this.b.c.addAll(r8);
    }
}
