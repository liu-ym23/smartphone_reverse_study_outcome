package com.obric.memorydata.database.util.file_utils;

import com.obric.capabilitykit.entity.app.FileEntity;
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

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.database.util.file_utils.DocxFileProcessor$handleImage$3", f = "DocxFileProcessor.kt", i = {}, l = {125}, m = "invokeSuspend", n = {}, s = {})
final class DocxFileProcessor$handleImage$3 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
    final /* synthetic */ FileEntity $docFileEntity;
    final /* synthetic */ String $fileExtension;
    final /* synthetic */ byte[] $imageBytes;
    final /* synthetic */ int $index;
    final /* synthetic */ int $parentId;
    final /* synthetic */ j $tree;
    int label;
    final /* synthetic */ k this$0;

    DocxFileProcessor$handleImage$3(k r3, byte[] r4, String r5, int r6, j r7, int r8, FileEntity r9, Continuation<? super DocxFileProcessor$handleImage$3> r10) {
        Continuation r11 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r10, Continuation.class, "com.obric.memorydata.plugin");
        this.this$0 = r3;
        this.$imageBytes = r4;
        this.$fileExtension = r5;
        this.$index = r6;
        this.$tree = r7;
        this.$parentId = r8;
        this.$docFileEntity = r9;
        super(2, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r11, Continuation<?> r12) {
        Continuation r9 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r12, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new DocxFileProcessor$handleImage$3(this.this$0, this.$imageBytes, this.$fileExtension, this.$index, this.$tree, this.$parentId, this.$docFileEntity, r9), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super Unit> r4) {
        return ((DocxFileProcessor$handleImage$3) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), DocxFileProcessor$handleImage$3.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r15) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r15);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r15);
        n r4 = (n) ZeusTransformUtils.preCheckCast(this.this$0, n.class, "com.obric.memorydata.plugin");
        byte[] r5 = this.$imageBytes;
        Intrinsics.checkNotNull(r5);
        String r7 = this.$fileExtension;
        Intrinsics.checkNotNull(r7);
        i r16 = new i(r7, null, this.$index, 2, null);
        j r8 = this.$tree;
        int r9 = this.$parentId;
        FileEntity r10 = this.$docFileEntity;
        Continuation r11 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.label = 1;
        if (n.a.a(r4, r5, r16, r8, r9, r10, false, r11, 32, null) != r0) goto L12;
        return r0;
    }
}
