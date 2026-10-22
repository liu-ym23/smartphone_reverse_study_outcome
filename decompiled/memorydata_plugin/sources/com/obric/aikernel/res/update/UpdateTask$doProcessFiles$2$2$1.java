package com.obric.aikernel.res.update;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", ""}, k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.obric.aikernel.res.update.UpdateTask$doProcessFiles$2$2$1", f = "UpdateTask.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class UpdateTask$doProcessFiles$2$2$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ File $dir;
    final /* synthetic */ File $targetFile;
    final /* synthetic */ File $tempTargetFile;
    final /* synthetic */ Ref.ObjectRef<Pair<Boolean, String>> $unzipRet;
    final /* synthetic */ File $zipFile;
    int label;

    UpdateTask$doProcessFiles$2$2$1(File r3, File r4, File r5, Ref.ObjectRef<Pair<Boolean, String>> r6, File r7, Continuation<? super UpdateTask$doProcessFiles$2$2$1> r8) {
        Continuation r9 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r8, Continuation.class, "com.obric.memorydata.plugin");
        this.$targetFile = r3;
        this.$zipFile = r4;
        this.$tempTargetFile = r5;
        this.$unzipRet = r6;
        this.$dir = r7;
        super(1, r9);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> r10) {
        Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r10, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new UpdateTask$doProcessFiles$2$2$1(this.$targetFile, this.$zipFile, this.$tempTargetFile, this.$unzipRet, this.$dir, r8), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function1
    public /* synthetic */ Object invoke(Continuation<? super Unit> r3) {
        return invoke2((Continuation) ZeusTransformUtils.preCheckCast(r3, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(Continuation<? super Unit> r3) {
        return ((UpdateTask$doProcessFiles$2$2$1) ZeusTransformUtils.preCheckCast(create((Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin")), UpdateTask$doProcessFiles$2$2$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [T, kotlin.Pair] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r7) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L18;
        ResultKt.throwOnFailure(r7);
        if (this.$targetFile.exists() == false) goto L10;
        if (this.$targetFile.isFile() == false) goto L10;
        com.obric.aikernel.res.utils.a.f6155a.c(this.$targetFile, this.$zipFile);
    L10:
        if (this.$zipFile.exists() == false) goto L16;
        com.obric.aikernel.res.b.b r8 = com.obric.aikernel.res.b.b.f6004a;
        String r0 = this.$zipFile.getPath();
        Intrinsics.checkNotNullExpressionValue(r0, "zipFile.path");
        String r1 = this.$tempTargetFile.getPath();
        Intrinsics.checkNotNullExpressionValue(r1, "tempTargetFile.path");
        final File r3 = this.$dir;
        if (r8.a(r0, r1, (Function1) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r3), Function1.class, "com.obric.memorydata.plugin")) == true) goto L14;
        this.$unzipRet.element = new Pair(Boxing.boxBoolean(false), ((String) ZeusTransformUtils.preCheckCast(((Pair) ZeusTransformUtils.preCheckCast(this.$unzipRet.element, Pair.class, "com.obric.memorydata.plugin")).getSecond(), String.class, "com.obric.memorydata.plugin")) + ' ' + this.$targetFile.getName() + " unzip failed.");
        goto L16
    L14:
        this.$zipFile.delete();
        com.obric.aikernel.res.utils.a.f6155a.c(this.$tempTargetFile, this.$targetFile);
    L16:
        return Unit.INSTANCE;
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
