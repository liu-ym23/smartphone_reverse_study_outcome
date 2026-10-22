package com.larus.bmhome.upload.sdk.impl.post;

import java.util.Iterator;
import java.util.List;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class PostUploadActionChain {
    public final List<b> a;

    /* JADX WARN: Multi-variable type inference failed */
    public PostUploadActionChain(List<? extends b> r2) {
        Intrinsics.checkNotNullParameter(r2, "actions");
        this.a = r2;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x005e -> B:23:0x0061). Please report as a decompilation issue!!! */
    public final Object a(c r7, Continuation<? super c> r8) {
        if ((r8 instanceof PostUploadActionChain$execute$1) == false) goto L7;
        PostUploadActionChain$execute$1 r0 = (PostUploadActionChain$execute$1) r8;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r9 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        Iterator<b> r10 = (Iterator) r0.L$0;
        ResultKt.throwOnFailure(r9);
    L23:
        c r11 = (c) r9;
    L16:
        if (r10.hasNext() == false) goto L24;
        b r4 = r10.next();
        if (r4.a(r11.b) == false) goto L16;
        r0.L$0 = r10;
        r0.label = 1;
        r9 = r4.b(r11, r0);
        if (r9 != r2) goto L23;
        return r2;
    L24:
        return r11;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r9);
        Iterator<b> r12 = this.a.iterator();
        r11 = r7;
        r10 = r12;
    L7:
        r0 = new PostUploadActionChain$execute$1(this, r8);
        goto L8
    }
}
