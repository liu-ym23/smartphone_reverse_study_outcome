package com.obric.aikernel.model_decrypt.impl.util;

import java.io.File;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.l0;

/* JADX INFO: loaded from: classes2.dex */
@DebugMetadata(c = "com.obric.aikernel.model_decrypt.impl.util.DiskDecryptHelper$startOrReturnExistingDecryptTask$1$1", f = "DiskDecryptHelper.kt", i = {}, l = {64}, m = "invokeSuspend", n = {}, s = {})
final class DiskDecryptHelper$startOrReturnExistingDecryptTask$1$1 extends SuspendLambda implements Function2<l0, Continuation<? super Unit>, Object> {
    final /* synthetic */ File $decryptFile;
    final /* synthetic */ File $encryptFile;
    final /* synthetic */ File $metaFile;
    final /* synthetic */ String $taskId;
    int label;

    DiskDecryptHelper$startOrReturnExistingDecryptTask$1$1(File r10, File r11, File r12, String r13, Continuation<? super DiskDecryptHelper$startOrReturnExistingDecryptTask$1$1> r14) {
        this.$encryptFile = r10;
        this.$decryptFile = r11;
        this.$metaFile = r12;
        this.$taskId = r13;
        super(2, r14);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new DiskDecryptHelper$startOrReturnExistingDecryptTask$1$1(this.$encryptFile, this.$decryptFile, this.$metaFile, this.$taskId, r11);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(l0 r10, Continuation<? super Unit> r11) {
        return invoke2(r10, r11);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(l0 r10, Continuation<? super Unit> r11) {
        return ((DiskDecryptHelper$startOrReturnExistingDecryptTask$1$1) create(r10, r11)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        Object r11 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r12 = this.label;
        if (r12 == 0) goto L8;
        if (r12 != 1) goto L7;
        ResultKt.throwOnFailure(r10);
    L11:
        boolean r13 = ((Boolean) r10).booleanValue();
        DiskDecryptHelper r14 = DiskDecryptHelper.INSTANCE;
        String r15 = this.$taskId;
        Intrinsics.checkNotNullExpressionValue(r15, "taskId");
        DiskDecryptHelper.access$notifyDecryptTaskFinish(r14, r15, r13);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        DiskDecryptHelper r16 = DiskDecryptHelper.INSTANCE;
        File r17 = this.$encryptFile;
        File r18 = this.$decryptFile;
        File r19 = this.$metaFile;
        this.label = 1;
        r10 = DiskDecryptHelper.access$checkAndDecryptFile(r16, r17, r18, r19, this);
        if (r10 != r11) goto L11;
        return r11;
    }
}
