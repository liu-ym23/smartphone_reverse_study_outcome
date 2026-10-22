package cfa;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import java.util.Iterator;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class e {
    public static final laa.c a(FragmentManager r4) {
        Iterator r5 = r4.getFragments().iterator();
    L3:
        Object r1 = null;
        if (r5.hasNext() == false) goto L20;
        Fragment r0 = (Fragment) r5.next();
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L8
        Intrinsics.checkNotNull(r0);     // Catch: Throwable -> L8
        Object r3 = Result.constructor-impl(s1a.a.g(r0).getAbility(laa.c.class));     // Catch: Throwable -> L8
    L11:
        if (Result.isFailure-impl(r3) == true) goto L14;
        r1 = r3;
    L14:
        laa.c r6 = (laa.c) r1;
        if (r6 != null) goto L16;
        laa.c r7 = a(r0.getChildFragmentManager());
        if (r7 == null) goto L3;
        return r7;
    L16:
        return r6;
    L8:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        r3 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L11
    L20:
        return null;
    }
}
