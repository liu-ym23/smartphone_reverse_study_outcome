package com.obric.memorydata.middleware.impl.image;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.al;
import kotlinx.coroutines.au;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.middleware.impl.image.ImageXBatchUpload$upload$2$1$1$1", f = "ImageXBatchUpload.kt", i = {}, l = {21, 23, 24}, m = "invokeSuspend", n = {}, s = {})
final class ImageXBatchUpload$upload$2$1$1$1 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $index;
    final /* synthetic */ String $path;
    final /* synthetic */ d[] $results;
    final /* synthetic */ Function2<String, Continuation<? super d>, Object> $uploadSingle;
    int label;

    ImageXBatchUpload$upload$2$1$1$1(Function2<? super String, ? super Continuation<? super d>, ? extends Object> r3, String r4, d[] r5, int r6, Continuation<? super ImageXBatchUpload$upload$2$1$1$1> r7) {
        Function2<String, Continuation<? super d>, Object> r8 = (Function2) ZeusTransformUtils.wrapperContextForParams(r3, Function2.class, "com.obric.memorydata.plugin");
        Continuation r9 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r7, Continuation.class, "com.obric.memorydata.plugin");
        this.$uploadSingle = r8;
        this.$path = r4;
        this.$results = r5;
        this.$index = r6;
        super(2, r9);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r9, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new ImageXBatchUpload$upload$2$1$1$1(this.$uploadSingle, this.$path, this.$results, this.$index, r6), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super Unit> r4) {
        return ((ImageXBatchUpload$upload$2$1$1$1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), ImageXBatchUpload$upload$2$1$1$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x0065 -> B:15:0x0034). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r9) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L12;
        if (r1 == 1) goto L11;
        if (r1 == 2) goto L10;
        if (r1 == 3) goto L11;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        ResultKt.throwOnFailure(r9);
    L20:
        Function2<String, Continuation<? super d>, Object> r10 = this.$uploadSingle;
        String r2 = this.$path;
        this.label = 3;
        r9 = r10.invoke(r2, this);
        if (r9 == r0) goto L22;
    L15:
        d r11 = (d) ZeusTransformUtils.preCheckCast(r9, d.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(r11.c(), "UPLOAD_BUSY") == false) goto L23;
        Continuation r12 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.label = 2;
        if (au.a(25, r12) != r0) goto L20;
        return r0;
    L23:
        this.$results[this.$index] = r11;
        return Unit.INSTANCE;
    L22:
        return r0;
    L11:
        ResultKt.throwOnFailure(r9);
        goto L15
    L12:
        ResultKt.throwOnFailure(r9);
        Function2<String, Continuation<? super d>, Object> r13 = this.$uploadSingle;
        String r3 = this.$path;
        this.label = 1;
        r9 = r13.invoke(r3, this);
        if (r9 != r0) goto L15;
        return r0;
    }
}
