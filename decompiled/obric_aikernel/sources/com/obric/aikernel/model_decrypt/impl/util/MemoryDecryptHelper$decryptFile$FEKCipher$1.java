package com.obric.aikernel.model_decrypt.impl.util;

import com.obric.aikernel.model_decrypt.api.filemeta.IModelFileMetaDataManagerKt;
import com.obric.aikernel.model_decrypt.api.filemeta.ModelFileMetaData;
import java.io.File;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.l0;

/* JADX INFO: loaded from: classes2.dex */
@DebugMetadata(c = "com.obric.aikernel.model_decrypt.impl.util.MemoryDecryptHelper$decryptFile$FEKCipher$1", f = "MemoryDecryptHelper.kt", i = {}, l = {72}, m = "invokeSuspend", n = {}, s = {})
final class MemoryDecryptHelper$decryptFile$FEKCipher$1 extends SuspendLambda implements Function2<l0, Continuation<? super String>, Object> {
    final /* synthetic */ File $encryptFile;
    final /* synthetic */ boolean $isPreset;
    final /* synthetic */ String $presetKeyInfo;
    int label;

    MemoryDecryptHelper$decryptFile$FEKCipher$1(File r10, boolean r11, String r12, Continuation<? super MemoryDecryptHelper$decryptFile$FEKCipher$1> r13) {
        this.$encryptFile = r10;
        this.$isPreset = r11;
        this.$presetKeyInfo = r12;
        super(2, r13);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new MemoryDecryptHelper$decryptFile$FEKCipher$1(this.$encryptFile, this.$isPreset, this.$presetKeyInfo, r11);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(l0 r10, Continuation<? super String> r11) {
        return invoke2(r10, r11);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(l0 r10, Continuation<? super String> r11) {
        return ((MemoryDecryptHelper$decryptFile$FEKCipher$1) create(r10, r11)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        Object r11 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r12 = this.label;
        if (r12 == 0) goto L8;
        if (r12 != 1) goto L7;
        ResultKt.throwOnFailure(r10);
    L11:
        ModelFileMetaData r13 = IModelFileMetaDataManagerKt.getModelFileMetaDataManager().get(this.$encryptFile);
        if (r13 != null) goto L16;
        return null;
    L16:
        return r13.getFEKCipher();
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        KeyInfoReEncryptHelper r14 = KeyInfoReEncryptHelper.INSTANCE;
        File r15 = this.$encryptFile;
        boolean r16 = this.$isPreset;
        String r17 = this.$presetKeyInfo;
        this.label = 1;
        if (r14.reEncryptKeyInfo(r15, r16, r17, this) != r11) goto L11;
        return r11;
    }
}
