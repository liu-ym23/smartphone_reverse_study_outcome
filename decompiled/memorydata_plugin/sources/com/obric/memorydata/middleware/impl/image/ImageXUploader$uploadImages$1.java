package com.obric.memorydata.middleware.impl.image;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;
import kotlinx.coroutines.al;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.middleware.impl.image.ImageXUploader$uploadImages$1", f = "ImageXUploader.kt", i = {}, l = {55}, m = "invokeSuspend", n = {}, s = {})
final class ImageXUploader$uploadImages$1 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
    final /* synthetic */ ImageXBizType $bizType;
    final /* synthetic */ String[] $uploadPaths;
    int label;
    final /* synthetic */ m this$0;

    ImageXUploader$uploadImages$1(String[] r3, m r4, ImageXBizType r5, Continuation<? super ImageXUploader$uploadImages$1> r6) {
        Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
        this.$uploadPaths = r3;
        this.this$0 = r4;
        this.$bizType = r5;
        super(2, r7);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new ImageXUploader$uploadImages$1(this.$uploadPaths, this.this$0, this.$bizType, r6), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super Unit> r4) {
        return ((ImageXUploader$uploadImages$1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), ImageXUploader$uploadImages$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r13) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r13);
    L11:
        Iterable r14 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r13, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");
        m r2 = this.this$0;
        Iterator r15 = r14.iterator();
        int r4 = 0;
    L13:
        if (r15.hasNext() == false) goto L35;
        Object r5 = r15.next();
        int r6 = r4 + 1;
        if (r4 >= 0) goto L17;
        CollectionsKt.throwIndexOverflow();
    L17:
        d r7 = (d) ZeusTransformUtils.preCheckCast(r5, d.class, "com.obric.memorydata.plugin");
        String r8 = r7.a();
        CharSequence r9 = (CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.memorydata.plugin");
        if (r9 != null) goto L20;
    L23:
        boolean r10 = true;
    L24:
        if (r10 == false) goto L33;
        k r11 = m.a(r2);
        Long r12 = r7.b();
        if (r12 == null) goto L28;
        long r16 = r12.longValue();
    L29:
        String r17 = r7.c();
        if (r17 != null) goto L32;
        r17 = "";
    L32:
        r11.a(r4, r16, r17);
    L34:
        r4 = r6;
        goto L13
    L28:
        r16 = 0;
        goto L29
    L33:
        m.a(r2).a(r4, r8);
        goto L34
    L20:
        if (StringsKt.isBlank(r9) == true) goto L23;
        r10 = false;
        goto L24
    L35:
        m.a(this.this$0).a();
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r13);
        c r18 = c.f11721a;
        String[] r19 = this.$uploadPaths;
        Function2 r20 = (Function2) ZeusTransformUtils.preCheckCast(new ImageXUploader$uploadImages$1$results$1(this.$bizType, null), Function2.class, "com.obric.memorydata.plugin");
        Continuation r21 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.label = 1;
        r13 = c.a(r18, r19, 0, r20, r21, 2, null);
        if (r13 != r0) goto L11;
        return r0;
    }
}
