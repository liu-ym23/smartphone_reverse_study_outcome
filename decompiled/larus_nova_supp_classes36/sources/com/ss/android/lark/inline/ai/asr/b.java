package com.ss.android.lark.inline.ai.asr;

import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.LarkContext;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.i1;
import slb.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b implements tlb.c {
    public final InlineAIAsrController a;
    public final nsb.b b;
    public final i1<Boolean> c;

    public static final class a {
    }

    static {
    }

    public b(slb.g r2) {
        Intrinsics.checkNotNullParameter(r2, "inlineAIParams");
        this.a = new InlineAIAsrController(r2);
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L5
        Object r4 = Result.constructor-impl((nsb.b) LarkContext.spiByDwarf(nsb.b.class));     // Catch: Throwable -> L5
    L8:
        if (Result.isFailure-impl(r4) == false) goto L10;
        r4 = null;
    L10:
        nsb.b r5 = (nsb.b) r4;
        this.b = r5;
        if (r5 == null) goto L14;
        i1<Boolean> r6 = r5.isEnable();
        if (r6 == null) goto L14;
    L15:
        this.c = r6;
        return;
    L14:
        r6 = (i1) this.a.j.getValue();
    L5:
        th = move-exception;
        Result.Companion r0 = Result.Companion;
        r4 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L8
    }

    @Override // tlb.c
    public final Object a(Continuation<? super List<m>> r5) {
        nsb.b r0 = this.b;
        boolean r1 = false;
        if (r0 == null) goto L7;
        i1<Boolean> r2 = r0.d();
        if (r2 == null) goto L7;
        boolean r3 = ((Boolean) r2.getValue()).booleanValue();
    L8:
        StringBuilder r4 = new StringBuilder("getPrompts  needOnBoarding : ");
        r4.append(r3);
        r4.append(" ， mMyAIApi is null = ");
        if (this.b != null) goto L11;
        r1 = true;
    L11:
        r4.append(r1);
        Log.i("IInlineAIAsrSdkImpl", r4.toString());
        if (r3 == false) goto L16;
        return null;
    L16:
        return this.a.f(r5);
    L7:
        r3 = false;
        goto L8
    }
}
