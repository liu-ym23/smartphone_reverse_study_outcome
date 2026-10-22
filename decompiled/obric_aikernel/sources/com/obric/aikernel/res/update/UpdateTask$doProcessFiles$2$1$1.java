package com.obric.aikernel.res.update;

import com.obric.aikernel.res.PackageResourceManager;
import com.obric.aikernel.res.metadata.config.DistConfig;
import java.io.File;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes2.dex */
@DebugMetadata(c = "com.obric.aikernel.res.update.UpdateTask$doProcessFiles$2$1$1", f = "UpdateTask.kt", i = {}, l = {828}, m = "invokeSuspend", n = {}, s = {})
final class UpdateTask$doProcessFiles$2$1$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ Ref.ObjectRef<Pair<Boolean, String>> $decryptRet;
    final /* synthetic */ com.obric.aikernel.res.metadata.config.b $downloadable;
    final /* synthetic */ File $encryptDir;
    final /* synthetic */ File $encryptFile;
    final /* synthetic */ String $installPathPrefix;
    final /* synthetic */ DistConfig $it;
    final /* synthetic */ File $targetFile;
    final /* synthetic */ File $tempTarget;
    Object L$0;
    int label;
    final /* synthetic */ UpdateTask this$0;

    UpdateTask$doProcessFiles$2$1$1(File r10, com.obric.aikernel.res.metadata.config.b r11, UpdateTask r12, Ref.ObjectRef<Pair<Boolean, String>> r13, DistConfig r14, String r15, File r16, File r17, File r18, Continuation<? super UpdateTask$doProcessFiles$2$1$1> r19) {
        this.$encryptFile = r10;
        this.$downloadable = r11;
        this.this$0 = r12;
        this.$decryptRet = r13;
        this.$it = r14;
        this.$installPathPrefix = r15;
        this.$tempTarget = r16;
        this.$encryptDir = r17;
        this.$targetFile = r18;
        super(1, r19);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> r13) {
        return new UpdateTask$doProcessFiles$2$1$1(this.$encryptFile, this.$downloadable, this.this$0, this.$decryptRet, this.$it, this.$installPathPrefix, this.$tempTarget, this.$encryptDir, this.$targetFile, r13);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Continuation<? super Unit> r10) {
        return invoke2(r10);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(Continuation<? super Unit> r10) {
        return ((UpdateTask$doProcessFiles$2$1$1) create(r10)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r12) {
        Object r10 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r11 = this.label;
        if (r11 == 0) goto L8;
        if (r11 != 1) goto L7;
        Ref.ObjectRef<Pair<Boolean, String>> r13 = (Ref.ObjectRef) this.L$0;
        ResultKt.throwOnFailure(r12);
        T r14 = r12;
    L16:
        r13.element = r14;
        if (this.$decryptRet.element.getFirst().booleanValue() == false) goto L31;
        if (this.$encryptDir.exists() == false) goto L28;
        File r15 = this.$encryptDir;
        Result.Companion r16 = Result.Companion;     // Catch: Throwable -> L23
        Object r17 = Result.m32constructorimpl(Boxing.boxBoolean(FilesKt.deleteRecursively(r15)));     // Catch: Throwable -> L23
    L25:
        File r18 = this.$encryptDir;
        Throwable r19 = Result.m35exceptionOrNullimpl(r17);
        if (r19 == null) goto L28;
        com.obric.aikernel.runtime.utils.d.f5417a.l("PackageUpdater", "doProcessFile delete " + r18 + " failed " + r19);
    L23:
        th = move-exception;
        Result.Companion r20 = Result.Companion;
        r17 = Result.m32constructorimpl(ResultKt.createFailure(th));
    L28:
        com.obric.aikernel.res.utils.a.f5222a.i(this.$tempTarget, this.$targetFile);
    L31:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r12);
        if (this.$encryptFile.exists() == true) goto L11;
    L29:
        com.obric.aikernel.runtime.utils.d.f5417a.d("PackageUpdater", this.$downloadable.o() + " do not decrypt");
        goto L31
    L11:
        if (this.$downloadable.v(UpdateTask.h(this.this$0).getConfig().getDecryptFeature()) == false) goto L29;
        Ref.ObjectRef<Pair<Boolean, String>> r110 = this.$decryptRet;
        PackageResourceManager.PresmConfig.b r21 = UpdateTask.h(this.this$0).getConfig().getDecryptFeature();
        String r22 = this.$it.g();
        String r23 = this.$it.i();
        String r24 = this.$installPathPrefix + '/' + this.$downloadable.o();
        String r25 = this.$encryptFile.getPath();
        Intrinsics.checkNotNullExpressionValue(r25, "encryptFile.path");
        String r26 = this.$tempTarget.getPath();
        Intrinsics.checkNotNullExpressionValue(r26, "tempTarget.path");
        this.L$0 = r110;
        this.label = 1;
        Object r27 = r21.a(r22, r23, r24, r25, r26, this);
        if (r27 != r10) goto L15;
        return r10;
    L15:
        r13 = r110;
        r14 = r27;
        goto L16
    }
}
