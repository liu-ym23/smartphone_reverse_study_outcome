package com.larus.bmhome.upload.sdk.impl.engine;

import com.larus.bmhome.upload.sdk.api.model.UploadEngineType;
import is8.g;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class SkeletonUploadEngine implements c {
    public final UploadEngineType a;

    public static final class a {
    }

    static {
    }

    public SkeletonUploadEngine(UploadEngineType r1) {
        this.a = r1;
    }

    @Override // com.larus.bmhome.upload.sdk.impl.engine.c
    public final boolean a(is8.a r2) {
        Intrinsics.checkNotNullParameter(r2, "route");
        if (r2.b != this.a) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.larus.bmhome.upload.sdk.impl.engine.c
    public final Object b(String r4, g r5, is8.a r6, js8.b r7, Function2<? super Integer, ? super Continuation<? super Unit>, ? extends Object> r8, Continuation<? super b> r9) {
        if ((r9 instanceof SkeletonUploadEngine$upload$1) == false) goto L7;
        SkeletonUploadEngine$upload$1 r10 = (SkeletonUploadEngine$upload$1) r9;
        int r0 = r10.label;
        if ((r0 & Integer.MIN_VALUE) == 0) goto L7;
        r10.label = r0 - Integer.MIN_VALUE;
    L8:
        Object r11 = r10.result;
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r10.label;
        if (r2 == 0) goto L14;
        if (r2 != 1) goto L12;
        r7 = (js8.b) r10.L$2;
        r6 = (is8.a) r10.L$1;
        r4 = (String) r10.L$0;
        ResultKt.throwOnFailure(r11);
    L18:
        throw new IllegalStateException("Skeleton upload engine is not bound to a concrete uploader yet. taskId=" + r4 + ", route=" + r6.b + ", auth=" + r7.a);
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r11);
        Integer r12 = Boxing.boxInt(1);
        r10.L$0 = r4;
        r10.L$1 = r6;
        r10.L$2 = r7;
        r10.label = 1;
        if (r8.invoke(r12, r10) != r1) goto L18;
        return r1;
    L7:
        r10 = new SkeletonUploadEngine$upload$1(this, r9);
        goto L8
    }
}
