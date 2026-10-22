package com.larus.bmhome.upload.sdk.impl.core;

import is8.g;
import java.util.Iterator;
import java.util.List;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class UploadPreprocessChain {
    public final List<c> a;

    /* JADX WARN: Multi-variable type inference failed */
    public UploadPreprocessChain(List<? extends c> r2) {
        Intrinsics.checkNotNullParameter(r2, "preprocessors");
        this.a = r2;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x0070 -> B:21:0x0071). Please report as a decompilation issue!!! */
    public final Object a(g r6, Continuation<? super g> r7) {
        if ((r7 instanceof UploadPreprocessChain$process$1) == false) goto L7;
        UploadPreprocessChain$process$1 r0 = (UploadPreprocessChain$process$1) r7;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r8 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        Ref.ObjectRef r9 = (Ref.ObjectRef) r0.L$2;
        Iterator r4 = (Iterator) r0.L$1;
        Ref.ObjectRef r5 = (Ref.ObjectRef) r0.L$0;
        ResultKt.throwOnFailure(r8);
    L21:
        r9.element = r8;
        r9 = r5;
    L16:
        if (r4.hasNext() == false) goto L23;
        c r10 = (c) r4.next();
        g r11 = (g) r9.element;
        r0.L$0 = r9;
        r0.L$1 = r4;
        r0.L$2 = r9;
        r0.label = 1;
        r8 = r10.a(r11);
        if (r8 != r2) goto L20;
        return r2;
    L20:
        r5 = r9;
        goto L21
    L23:
        return r9.element;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r8);
        Ref.ObjectRef r12 = new Ref.ObjectRef();
        r12.element = r6;
        r4 = this.a.iterator();
        r9 = r12;
    L7:
        r0 = new UploadPreprocessChain$process$1(this, r7);
        goto L8
    }
}
