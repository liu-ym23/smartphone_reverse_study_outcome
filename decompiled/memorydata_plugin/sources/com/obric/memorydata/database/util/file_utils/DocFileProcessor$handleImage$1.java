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
import org.apache.poi.hwpf.usermodel.Picture;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.database.util.file_utils.DocFileProcessor$handleImage$1", f = "DocFileProcessor.kt", i = {}, l = {95}, m = "invokeSuspend", n = {}, s = {})
final class DocFileProcessor$handleImage$1 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
    final /* synthetic */ FileEntity $docFileEntity;
    final /* synthetic */ int $index;
    final /* synthetic */ int $parentId;
    final /* synthetic */ Picture $picture;
    final /* synthetic */ j $tree;
    int label;
    final /* synthetic */ g this$0;

    DocFileProcessor$handleImage$1(g r3, Picture r4, int r5, j r6, int r7, FileEntity r8, Continuation<? super DocFileProcessor$handleImage$1> r9) {
        Continuation r10 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r9, Continuation.class, "com.obric.memorydata.plugin");
        this.this$0 = r3;
        this.$picture = r4;
        this.$index = r5;
        this.$tree = r6;
        this.$parentId = r7;
        this.$docFileEntity = r8;
        super(2, r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r11, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new DocFileProcessor$handleImage$1(this.this$0, this.$picture, this.$index, this.$tree, this.$parentId, this.$docFileEntity, r8), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super Unit> r4) {
        return ((DocFileProcessor$handleImage$1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), DocFileProcessor$handleImage$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
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
        byte[] r5 = this.$picture.getContent();
        Intrinsics.checkNotNullExpressionValue(r5, "getContent(...)");
        String r7 = this.$picture.suggestFileExtension();
        Intrinsics.checkNotNullExpressionValue(r7, "suggestFileExtension(...)");
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
