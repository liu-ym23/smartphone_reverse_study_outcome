package com.bytedance.android.anniex.detect;

import java.util.Iterator;
import java.util.List;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class SnapshotPipeline {
    public final List<m> a;
    public final Function1<k, Boolean> b;

    public SnapshotPipeline() {
        throw null;
    }

    public SnapshotPipeline(List r10) {
        AnonymousClass1 r0 = AnonymousClass1.INSTANCE;
        Intrinsics.checkNotNullParameter(r10, "steps");
        Intrinsics.checkNotNullParameter(r0, "shouldInterrupt");
        this.a = r10;
        this.b = r0;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x0065 -> B:21:0x0068). Please report as a decompilation issue!!! */
    public final Object a(j r10, Continuation<? super k> r11) {
        if ((r11 instanceof SnapshotPipeline$run$1) == false) goto L7;
        SnapshotPipeline$run$1 r0 = (SnapshotPipeline$run$1) r11;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r12 = r0.result;
        Object r13 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r14 = r0.label;
        if (r14 == 0) goto L14;
        if (r14 != 1) goto L13;
        Iterator<m> r15 = (Iterator) r0.L$2;
        j r16 = (j) r0.L$1;
        SnapshotPipeline r17 = (SnapshotPipeline) r0.L$0;
        ResultKt.throwOnFailure(r12);
    L21:
        k r18 = (k) r12;
        if (((Boolean) r17.b.invoke(r18)).booleanValue() == false) goto L24;
        return r18;
    L24:
        j r19 = r16;
    L16:
        if (r15.hasNext() == false) goto L26;
        m r20 = r15.next();
        r0.L$0 = r17;
        r0.L$1 = r19;
        r0.L$2 = r15;
        r0.label = 1;
        Object r21 = r20.a(r19, r0);
        if (r21 != r13) goto L20;
        return r13;
    L20:
        r16 = r19;
        r12 = r21;
        goto L21
    L26:
        return new k(true, null);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r12);
        Iterator<m> r22 = this.a.iterator();
        r17 = this;
        r19 = r10;
        r15 = r22;
    L7:
        r0 = new SnapshotPipeline$run$1(this, r11);
        goto L8
    }
}
