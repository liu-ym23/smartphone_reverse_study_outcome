package com.obric.aikernel.model_decrypt.impl.util;

import com.obric.aikernel.middleware.api.appcontext.AppContext;
import com.obric.aikernel.middleware.api.log.AIKLog;
import com.obric.aikernel.model_decrypt.api.decrypt.IModelCert;
import com.obric.aikernel.model_decrypt.api.decrypt.IModelCertKt;
import com.obric.aikernel.model_decrypt.api.decrypt.IModelDecrypt;
import com.obric.aikernel.model_decrypt.api.decrypt.IModelDecryptKt;
import com.obric.aikernel.model_decrypt.api.filemeta.IModelFileMetaDataManager;
import com.obric.aikernel.model_decrypt.api.filemeta.IModelFileMetaDataManagerKt;
import com.obric.aikernel.model_decrypt.api.filemeta.ModelFileMetaData;
import com.obric.aikernel.model_preset.api.IModelPresetResKt;
import java.io.File;
import java.io.InputStream;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes2.dex */
public final class KeyInfoReEncryptHelper {
    public static final KeyInfoReEncryptHelper INSTANCE = null;
    private static final String TAG = "KeyInfoReEncryptHelper";

    /* JADX INFO: renamed from: com.obric.aikernel.model_decrypt.impl.util.KeyInfoReEncryptHelper$reEncryptKeyInfo$1, reason: invalid class name */
    @DebugMetadata(c = "com.obric.aikernel.model_decrypt.impl.util.KeyInfoReEncryptHelper", f = "KeyInfoReEncryptHelper.kt", i = {0}, l = {94}, m = "reEncryptKeyInfo", n = {"encryptFile"}, s = {"L$0"})
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ KeyInfoReEncryptHelper this$0;

        AnonymousClass1(KeyInfoReEncryptHelper r10, Continuation<? super AnonymousClass1> r11) {
            this.this$0 = r10;
            super(r11);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r10) {
            this.result = r10;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.reEncryptKeyInfo(null, false, null, this);
        }
    }

    static {
        INSTANCE = new KeyInfoReEncryptHelper();
    }

    private KeyInfoReEncryptHelper() {
    }

    public static /* synthetic */ Object reEncryptKeyInfo$default(KeyInfoReEncryptHelper r10, File r11, boolean r12, String r13, Continuation r14, int r15, Object r16) {
        if ((r15 & 2) == 0) goto L6;
        r12 = false;
    L6:
        if ((r15 & 4) == 0) goto L9;
        r13 = null;
    L9:
        return r10.reEncryptKeyInfo(r11, r12, r13, r14);
    }

    public final Object reEncryptKeyInfo(File r18, boolean r19, String r20, Continuation<? super Boolean> r21) {
        if ((r21 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r10 = (AnonymousClass1) r21;
        int r11 = r10.label;
        if ((r11 & Integer.MIN_VALUE) == 0) goto L7;
        r10.label = r11 - Integer.MIN_VALUE;
    L8:
        AnonymousClass1 r12 = r10;
        Object r13 = r12.result;
        Object r14 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r15 = r12.label;
        boolean r16 = false;
        if (r15 == 0) goto L14;
        if (r15 != 1) goto L13;
        File r17 = (File) r12.L$0;
        ResultKt.throwOnFailure(r13);
    L87:
        ModelFileMetaData r22 = IModelFileMetaDataManagerKt.getModelFileMetaDataManager().get(r17);
        if (r22 == null) goto L90;
        String r23 = r22.getFEKCipher();
    L91:
        if (r23 != null) goto L93;
    L96:
        boolean r24 = true;
    L97:
        if (r24 == false) goto L101;
        AIKLog.INSTANCE.w(TAG, "re encrypt key is empty, file = " + r17);
        return Boxing.boxBoolean(false);
    L101:
        ModelFileMetaData r25 = IModelFileMetaDataManagerKt.getModelFileMetaDataManager().get(r17);
        if (r25 == null) goto L104;
        String r110 = r25.getFEKCipher();
    L105:
        if (r110 != null) goto L107;
    L108:
        r16 = true;
    L110:
        return Boxing.boxBoolean(!r16);
    L107:
        if (r110.length() != 0) goto L110;
    L104:
        r110 = null;
        goto L105
    L93:
        if (r23.length() == 0) goto L96;
        r24 = false;
        goto L97
    L90:
        r23 = null;
        goto L91
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r13);
        AIKLog r26 = AIKLog.INSTANCE;
        r26.d(TAG, "reEncryptFile: encryptFile " + r18 + ", isPreset = " + r19);
        ModelFileMetaData r111 = IModelFileMetaDataManagerKt.getModelFileMetaDataManager().get(r18);
        if (r111 != null) goto L19;
        r26.w(TAG, "reEncryptFile: fileMeta is null, file = " + r18);
        return Boxing.boxBoolean(false);
    L19:
        if (r111.isEncryptResource() == true) goto L22;
        r26.w(TAG, "reEncryptFile: file is not encrypt resource, file = " + r18);
        return Boxing.boxBoolean(false);
    L22:
        if (r19 == false) goto L33;
        if (Intrinsics.areEqual(r20, IModelPresetResKt.getModelPresetRes().getPresetKeyInfo(r111.getModelName(), r111.getFileName())) == false) goto L33;
        final String r27 = IModelPresetResKt.getModelPresetRes().getReEncryptKeyInfo(r111.getModelName(), r111.getFileName());
        if (r27.length() <= 0) goto L28;
        boolean r28 = true;
    L29:
        if (r28 == false) goto L33;
        IModelFileMetaDataManager.DefaultImpls.update$default(IModelFileMetaDataManagerKt.getModelFileMetaDataManager(), r18, false, new AnonymousClass2(r27), 2, null);
        return Boxing.boxBoolean(true);
    L28:
        r28 = false;
    L33:
        if (r111.isPresetToAssets() == false) goto L58;
        String r29 = r111.getPresetPath();
        Result.Companion r30 = Result.Companion;     // Catch: Throwable -> L37
        Object r31 = Result.m32constructorimpl(AppContext.INSTANCE.getContext().getAssets().open(r29));     // Catch: Throwable -> L37
    L40:
        if (Result.m35exceptionOrNullimpl(r31) == null) goto L43;
        AIKLog.INSTANCE.w(TAG, "open assets failed, assetsPath = " + r29);
    L43:
        if (Result.m38isFailureimpl(r31) == false) goto L45;
        r31 = null;
    L45:
        InputStream r32 = (InputStream) r31;
        if (r32 != null) goto L117;
    L57:
        boolean r33 = false;
    L59:
        if (r33 == false) goto L113;
        IModelFileMetaDataManager.DefaultImpls.update$default(IModelFileMetaDataManagerKt.getModelFileMetaDataManager(), r18, false, AnonymousClass3.INSTANCE, 2, null);
        if (r111.getFEKCipher().length() != 0) goto L63;
        boolean r34 = true;
    L64:
        if (r34 == false) goto L112;
        Ref.BooleanRef r35 = new Ref.BooleanRef();
        if (r19 == false) goto L82;
        if (r20 != null) goto L69;
    L72:
        boolean r36 = true;
    L73:
        if (r36 == true) goto L82;
        IModelCert r37 = IModelCertKt.getModelCert();
        String r38 = r18.getAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(r38, "encryptFile.absolutePath");
        final String r39 = r37.reEncryptFEK(r38, "", r20, r111.isPreset());
        if (r39.length() <= 0) goto L77;
        boolean r40 = true;
    L78:
        if (r40 == false) goto L80;
        AIKLog.INSTANCE.d(TAG, "use preset key info re encrypt success, file = " + r18);
        r35.element = true;
        IModelFileMetaDataManager.DefaultImpls.update$default(IModelFileMetaDataManagerKt.getModelFileMetaDataManager(), r18, false, new KeyInfoReEncryptHelper$reEncryptKeyInfo$4$1(r39), 2, null);
        goto L82
    L80:
        AIKLog.INSTANCE.w(TAG, "use preset key info re encrypt failed, file = " + r18);
        goto L82
    L77:
        r40 = false;
        goto L78
    L69:
        if (r20.length() == 0) goto L72;
        r36 = false;
    L82:
        if (r35.element == true) goto L100;
        KeyInfoRequestHelper r41 = KeyInfoRequestHelper.INSTANCE;
        List<String> r42 = CollectionsKt.listOf(r111.getModelName());
        r12.L$0 = r18;
        r12.label = 1;
        if (r41.requestKeyInfo(r42, r12) != r14) goto L86;
        return r14;
    L86:
        r17 = r18;
        goto L87
    L100:
        r17 = r18;
        goto L101
    L112:
        return Boxing.boxBoolean(true);
    L63:
        r34 = false;
        goto L64
    L113:
        AIKLog.INSTANCE.w(TAG, "verify failed, file = " + r18);
        return Boxing.boxBoolean(false);
    L117:
        boolean r43 = IModelDecryptKt.getModelDecrypt().checkModelIntegrity(r29, r32);     // Catch: Throwable -> L51
        CloseableKt.closeFinally(r32, null);
        if (r43 != true) goto L57;
        r33 = true;
    L51:
        th = move-exception;
        throw th;     // Catch: Throwable -> L54
    L54:
        th = move-exception;
        CloseableKt.closeFinally(r32, th);
        throw th;
    L37:
        th = move-exception;
        Result.Companion r44 = Result.Companion;
        r31 = Result.m32constructorimpl(ResultKt.createFailure(th));
        goto L40
    L58:
        IModelDecrypt r45 = IModelDecryptKt.getModelDecrypt();
        String r46 = r18.getAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(r46, "encryptFile.absolutePath");
        r33 = r45.checkModelIntegrity(r46);
    L7:
        r10 = new AnonymousClass1(this, r21);
        goto L8
    }
}
