package com.obric.aikernel.res.update;

import com.obric.aikernel.res.PackageResourceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import kotlin.Metadata;
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

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", ""}, k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.obric.aikernel.res.update.UpdateTask$doProcessFiles$2$1$1", f = "UpdateTask.kt", i = {}, l = {902}, m = "invokeSuspend", n = {}, s = {})
final class UpdateTask$doProcessFiles$2$1$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ Ref.ObjectRef<Pair<Boolean, String>> $decryptRet;
    final /* synthetic */ com.obric.aikernel.res.metadata.config.c $downloadable;
    final /* synthetic */ File $encryptDir;
    final /* synthetic */ File $encryptFile;
    final /* synthetic */ String $installPathPrefix;
    final /* synthetic */ com.obric.aikernel.res.metadata.config.a $it;
    final /* synthetic */ File $targetFile;
    final /* synthetic */ File $tempTarget;
    Object L$0;
    int label;
    final /* synthetic */ s this$0;

    UpdateTask$doProcessFiles$2$1$1(File r3, com.obric.aikernel.res.metadata.config.c r4, s r5, Ref.ObjectRef<Pair<Boolean, String>> r6, com.obric.aikernel.res.metadata.config.a r7, String r8, File r9, File r10, File r11, Continuation<? super UpdateTask$doProcessFiles$2$1$1> r12) {
        Continuation r13 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r12, Continuation.class, "com.obric.memorydata.plugin");
        this.$encryptFile = r3;
        this.$downloadable = r4;
        this.this$0 = r5;
        this.$decryptRet = r6;
        this.$it = r7;
        this.$installPathPrefix = r8;
        this.$tempTarget = r9;
        this.$encryptDir = r10;
        this.$targetFile = r11;
        super(1, r13);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> r14) {
        Continuation r12 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r14, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new UpdateTask$doProcessFiles$2$1$1(this.$encryptFile, this.$downloadable, this.this$0, this.$decryptRet, this.$it, this.$installPathPrefix, this.$tempTarget, this.$encryptDir, this.$targetFile, r12), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function1
    public /* synthetic */ Object invoke(Continuation<? super Unit> r3) {
        return invoke2((Continuation) ZeusTransformUtils.preCheckCast(r3, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(Continuation<? super Unit> r3) {
        return ((UpdateTask$doProcessFiles$2$1$1) ZeusTransformUtils.preCheckCast(create((Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin")), UpdateTask$doProcessFiles$2$1$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r13) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        Ref.ObjectRef<Pair<Boolean, String>> r2 = (Ref.ObjectRef) ZeusTransformUtils.preCheckCast(this.L$0, Ref.ObjectRef.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r13);
        T r14 = r13;
    L16:
        r2.element = r14;
        if (((Boolean) ZeusTransformUtils.preCheckCast(((Pair) ZeusTransformUtils.preCheckCast(this.$decryptRet.element, Pair.class, "com.obric.memorydata.plugin")).getFirst(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L31;
        if (this.$encryptDir.exists() == false) goto L28;
        File r15 = this.$encryptDir;
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L23
        Object r16 = Result.m1421constructorimpl(Boxing.boxBoolean(FilesKt.deleteRecursively(r15)));     // Catch: Throwable -> L23
    L25:
        File r4 = this.$encryptDir;
        Throwable r17 = Result.m1424exceptionOrNullimpl(r16);
        if (r17 == null) goto L28;
        com.obric.aikernel.runtime.utils.d.f6216a.f("PackageUpdater", "doProcessFile delete " + r4 + " failed " + r17);
    L23:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        r16 = Result.m1421constructorimpl(ResultKt.createFailure(th));
    L28:
        com.obric.aikernel.res.utils.a.f6155a.c(this.$tempTarget, this.$targetFile);
    L31:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r13);
        if (this.$encryptFile.exists() == true) goto L11;
    L29:
        com.obric.aikernel.runtime.utils.d.f6216a.a("PackageUpdater", this.$downloadable.f() + " do not decrypt");
        goto L31
    L11:
        if (this.$downloadable.a(s.b(this.this$0).getConfig().getDecryptFeature()) == false) goto L29;
        Ref.ObjectRef<Pair<Boolean, String>> r18 = this.$decryptRet;
        PackageResourceManager.PresmConfig.a r6 = s.b(this.this$0).getConfig().getDecryptFeature();
        String r7 = this.$it.a();
        String r8 = this.$it.c();
        String r9 = this.$installPathPrefix + '/' + this.$downloadable.f();
        String r10 = this.$encryptFile.getPath();
        Intrinsics.checkNotNullExpressionValue(r10, "encryptFile.path");
        String r11 = this.$tempTarget.getPath();
        Intrinsics.checkNotNullExpressionValue(r11, "tempTarget.path");
        Continuation<? super Pair<Boolean, String>> r12 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.L$0 = r18;
        this.label = 1;
        Object r19 = r6.a(r7, r8, r9, r10, r11, r12);
        if (r19 != r0) goto L15;
        return r0;
    L15:
        r2 = r18;
        r14 = r19;
        goto L16
    }
}
