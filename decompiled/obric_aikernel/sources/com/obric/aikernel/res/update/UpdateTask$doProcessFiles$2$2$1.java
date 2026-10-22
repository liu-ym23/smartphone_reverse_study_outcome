package com.obric.aikernel.res.update;

import java.io.File;
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

/* JADX INFO: loaded from: classes2.dex */
@DebugMetadata(c = "com.obric.aikernel.res.update.UpdateTask$doProcessFiles$2$2$1", f = "UpdateTask.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class UpdateTask$doProcessFiles$2$2$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ File $dir;
    final /* synthetic */ File $targetFile;
    final /* synthetic */ File $tempTargetFile;
    final /* synthetic */ Ref.ObjectRef<Pair<Boolean, String>> $unzipRet;
    final /* synthetic */ File $zipFile;
    int label;

    UpdateTask$doProcessFiles$2$2$1(File r10, File r11, File r12, Ref.ObjectRef<Pair<Boolean, String>> r13, File r14, Continuation<? super UpdateTask$doProcessFiles$2$2$1> r15) {
        this.$targetFile = r10;
        this.$zipFile = r11;
        this.$tempTargetFile = r12;
        this.$unzipRet = r13;
        this.$dir = r14;
        super(1, r15);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> r10) {
        return new UpdateTask$doProcessFiles$2$2$1(this.$targetFile, this.$zipFile, this.$tempTargetFile, this.$unzipRet, this.$dir, r10);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Continuation<? super Unit> r10) {
        return invoke2(r10);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(Continuation<? super Unit> r10) {
        return ((UpdateTask$doProcessFiles$2$2$1) create(r10)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [T, kotlin.Pair] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L18;
        ResultKt.throwOnFailure(r10);
        if (this.$targetFile.exists() == false) goto L10;
        if (this.$targetFile.isFile() == false) goto L10;
        com.obric.aikernel.res.utils.a.f5222a.i(this.$targetFile, this.$zipFile);
    L10:
        if (this.$zipFile.exists() == false) goto L16;
        d8.b r11 = d8.b.f8513a;
        String r12 = this.$zipFile.getPath();
        Intrinsics.checkNotNullExpressionValue(r12, "zipFile.path");
        String r13 = this.$tempTargetFile.getPath();
        Intrinsics.checkNotNullExpressionValue(r13, "tempTargetFile.path");
        final File r14 = this.$dir;
        if (r11.b(r12, r13, new AnonymousClass1(r14)) == true) goto L14;
        this.$unzipRet.element = new Pair(Boxing.boxBoolean(false), this.$unzipRet.element.getSecond() + ' ' + this.$targetFile.getName() + " unzip failed.");
        goto L16
    L14:
        this.$zipFile.delete();
        com.obric.aikernel.res.utils.a.f5222a.i(this.$tempTargetFile, this.$targetFile);
    L16:
        return Unit.INSTANCE;
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
