package com.obric.aikernel.model_decrypt.impl;

import android.util.Base64;
import com.bytedance.crypto.CryptoSdk;
import com.bytedance.crypto.cloudtrans.CloudTransCryptoManager;
import com.google.gson.k;
import com.obric.aikernel.api.b;
import com.obric.aikernel.middleware.api.appcontext.AppContext;
import com.obric.aikernel.middleware.api.log.AIKLog;
import com.obric.aikernel.model_decrypt.api.IDecryptFeature;
import com.obric.aikernel.model_decrypt.api.IDecryptFeatureKt;
import com.obric.aikernel.model_decrypt.api.callback.IKeyInfoDistribute;
import com.obric.aikernel.model_decrypt.api.callback.IModelInfoProvider;
import com.obric.aikernel.model_decrypt.api.filemeta.IModelFileMetaDataManagerKt;
import com.obric.aikernel.model_decrypt.api.filemeta.ModelFileMetaData;
import com.obric.aikernel.model_decrypt.impl.util.DiskDecryptHelper;
import com.obric.aikernel.model_decrypt.impl.util.KeyInfoReEncryptHelper;
import com.obric.aikernel.model_decrypt.impl.util.KeyInfoRequestHelper;
import com.obric.aikernel.model_decrypt.impl.util.MemoryDecryptHelper;
import com.obric.aikernel.utils.e;
import java.io.File;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Set;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: classes2.dex */
public final class DecryptFeatureImpl implements IDecryptFeature {
    public static final DecryptFeatureImpl INSTANCE = null;
    private static final long MAX_MEMORY_SIZE = 5368709120L;
    private static final String TAG = "DecryptFeatureImpl";
    public static volatile IKeyInfoDistribute iKeyInfoDistribute;
    public static volatile IModelInfoProvider iModelInfoProvider;

    /* JADX INFO: renamed from: com.obric.aikernel.model_decrypt.impl.DecryptFeatureImpl$decrypt$1, reason: invalid class name and case insensitive filesystem */
    @DebugMetadata(c = "com.obric.aikernel.model_decrypt.impl.DecryptFeatureImpl", f = "DecryptFeatureImpl.kt", i = {0, 0}, l = {124}, m = "decrypt", n = {"srcFile", "deleteSrcFileOnSucceed"}, s = {"L$0", "Z$0"})
    static final class C03541 extends ContinuationImpl {
        Object L$0;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ DecryptFeatureImpl this$0;

        C03541(DecryptFeatureImpl r10, Continuation<? super C03541> r11) {
            this.this$0 = r10;
            super(r11);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r10) {
            this.result = r10;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.decrypt(null, null, false, null, this);
        }
    }

    static {
        INSTANCE = new DecryptFeatureImpl();
        CryptoSdk.initLogger(new AnonymousClass1());
        CryptoSdk.initEventReporter(new AnonymousClass2());
    }

    private DecryptFeatureImpl() {
    }

    public static /* synthetic */ boolean a() {
        return dataEncrypt$lambda$5();
    }

    private static final boolean dataEncrypt$lambda$5() {
        return false;
    }

    @JvmStatic
    public static final DecryptFeatureImpl getInst() {
        return INSTANCE;
    }

    @Override // com.obric.aikernel.model_decrypt.api.IDecryptFeature
    public String dataDecrypt(String r10) {
        Intrinsics.checkNotNullParameter(r10, "encodedText");
        byte[] r11 = Base64.decode(r10, 0);
        IDecryptFeature r12 = IDecryptFeatureKt.getDecryptFeature();
        Intrinsics.checkNotNullExpressionValue(r11, "decodedText");
        byte[] r13 = r12.dataDecrypt(r11);
        if (r13 != null) goto L7;
        return null;
    L7:
        return new String(r13, Charsets.UTF_8);
    }

    @Override // com.obric.aikernel.model_decrypt.api.IDecryptFeature
    public byte[] dataDecrypt(byte[] r10) {
        Intrinsics.checkNotNullParameter(r10, "inText");
        b.f4431a.b().e();
        return CloudTransCryptoManager.getInstance().dataDecrypt(r10);
    L5:
        e = move-exception;
        AIKLog.INSTANCE.e(TAG, "dataDecrypt failed: " + e.getMessage(), e);
        return null;
    }

    @Override // com.obric.aikernel.model_decrypt.api.IDecryptFeature
    public String dataEncrypt(String r10) {
        Intrinsics.checkNotNullParameter(r10, "inText");
        IDecryptFeature r11 = IDecryptFeatureKt.getDecryptFeature();
        byte[] r12 = r10.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(r12, "this as java.lang.String).getBytes(charset)");
        String r13 = Base64.encodeToString(r11.dataEncrypt(r12), 0);
        if (r13 == null) goto L5;
        return r13;
    L5:
        AIKLog.INSTANCE.e(TAG, "encrypt failed");
        throw new Exception("encrypt failed");
    }

    @Override // com.obric.aikernel.model_decrypt.api.IDecryptFeature
    public byte[] dataEncrypt(byte[] r10) {
        Intrinsics.checkNotNullParameter(r10, "inText");
        b.f4431a.b().e();
        CloudTransCryptoManager r11 = CloudTransCryptoManager.getInstance();     // Catch: Exception -> L5
        AppContext r12 = AppContext.INSTANCE;     // Catch: Exception -> L5
        r11.init(r12.getContext(), "ocean_aikernel", r12.getServerDeviceId(), a.f4684a);     // Catch: Exception -> L5
        return CloudTransCryptoManager.getInstance().dataEncrypt(r10);
    L5:
        e = move-exception;
        AIKLog.INSTANCE.e(TAG, "dataEncrypt failed: " + e.getMessage(), e);
        return null;
    }

    @Override // com.obric.aikernel.model_decrypt.api.IDecryptFeature
    public Object decrypt(String r10, String r11, boolean r12, String r13, Continuation<? super Boolean> r14) {
        if ((r14 instanceof C03541) == false) goto L7;
        C03541 r15 = (C03541) r14;
        int r16 = r15.label;
        if ((r16 & Integer.MIN_VALUE) == 0) goto L7;
        r15.label = r16 - Integer.MIN_VALUE;
    L8:
        Object r17 = r15.result;
        Object r18 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r19 = r15.label;
        boolean r20 = true;
        if (r19 == 0) goto L14;
        if (r19 != 1) goto L13;
        r12 = r15.Z$0;
        File r21 = (File) r15.L$0;
        ResultKt.throwOnFailure(r17);
    L28:
        boolean r22 = ((Boolean) r17).booleanValue();
        if (r22 == false) goto L48;
        if (r12 == false) goto L48;
        Result.Companion r23 = Result.Companion;     // Catch: Throwable -> L39
        if (r21.exists() == true) goto L34;
    L37:
        Object r24 = Result.m32constructorimpl(Boxing.boxBoolean(r20));     // Catch: Throwable -> L39
    L41:
        Boolean r110 = Boxing.boxBoolean(false);
        if (Result.m38isFailureimpl(r24) == false) goto L45;
        r24 = r110;
    L45:
        if (((Boolean) r24).booleanValue() == true) goto L48;
        AIKLog.INSTANCE.w(TAG, "delete deleteSrcFile failed: " + r21 + ", exists = " + e.b(r21));
        goto L48
    L34:
        if (r21.delete() == true) goto L37;
        r20 = false;
    L39:
        th = move-exception;
        Result.Companion r111 = Result.Companion;
        r24 = Result.m32constructorimpl(ResultKt.createFailure(th));
    L48:
        return Boxing.boxBoolean(r22);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r17);
        b.f4431a.b().e();
        AIKLog.INSTANCE.d(TAG, "decrypt: srcPath = " + r10 + ", targetPath = " + r11 + ", deleteSrcFileOnSucceed = " + r12 + ", fileMetaKey = " + r13);
        File r25 = new File(r10);
        DiskDecryptHelper r26 = DiskDecryptHelper.INSTANCE;
        File r27 = new File(r11);
        if (r13 != null) goto L17;
    L20:
        boolean r28 = true;
    L21:
        if (r28 == false) goto L23;
        File r112 = new File(r11);
    L24:
        r15.L$0 = r25;
        r15.Z$0 = r12;
        r15.label = 1;
        Object r29 = r26.decryptFile(r25, r27, r112, r15);
        if (r29 != r18) goto L27;
        return r18;
    L27:
        r21 = r25;
        r17 = r29;
        goto L28
    L23:
        r112 = new File(r13);
        goto L24
    L17:
        if (r13.length() == 0) goto L20;
        r28 = false;
    L7:
        r15 = new C03541(this, r14);
        goto L8
    }

    @Override // com.obric.aikernel.model_decrypt.api.IDecryptFeature
    public boolean decrypt(String r10, ByteBuffer r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r10, "srcPath");
        Intrinsics.checkNotNullParameter(r11, "targetBuffer");
        b.f4431a.b().e();
        AIKLog.INSTANCE.d(TAG, "decrypt: srcPath = " + r10 + ", targetBuffer.remaining = " + r11.remaining() + ", deleteSrcFileOnSucceed = " + r12);
        File r13 = new File(r10);
        boolean r14 = MemoryDecryptHelper.INSTANCE.decryptFile(r10, r11);
        if (r14 == false) goto L22;
        if (r12 == false) goto L22;
        Result.Companion r15 = Result.Companion;     // Catch: Throwable -> L14
        if (r13.exists() == true) goto L8;
    L11:
        boolean r16 = true;
    L12:
        Object r17 = Result.m32constructorimpl(Boolean.valueOf(r16));     // Catch: Throwable -> L14
    L16:
        Boolean r18 = Boolean.FALSE;
        if (Result.m38isFailureimpl(r17) == false) goto L20;
        r17 = r18;
    L20:
        if (((Boolean) r17).booleanValue() == true) goto L22;
        AIKLog.INSTANCE.w(TAG, "delete deleteSrcFile failed: " + r13 + ", exists = " + e.b(r13));
        goto L22
    L8:
        if (r13.delete() == true) goto L11;
        r16 = false;
    L14:
        th = move-exception;
        Result.Companion r19 = Result.Companion;
        r17 = Result.m32constructorimpl(ResultKt.createFailure(th));
    L22:
        return r14;
    }

    @Override // com.obric.aikernel.model_decrypt.api.IDecryptFeature
    public long getDecryptFileSize(String r10) {
        Intrinsics.checkNotNullParameter(r10, "filePath");
        ModelFileMetaData r11 = IModelFileMetaDataManagerKt.getModelFileMetaDataManager().get(new File(r10));
        if (r11 != null) goto L6;
        AIKLog.INSTANCE.w(TAG, "getDecryptFileSize: meta is null " + r10);
        return 0;
    L6:
        long r12 = r11.getOriginSizeBytes();
        AIKLog r13 = AIKLog.INSTANCE;
        r13.d(TAG, "getDecryptFileSize: " + r10 + ", fileSize = " + r12);
        if (r12 >= 0) goto L11;
        StringBuilder r14 = new StringBuilder();
        String r15 = "file size should not less than zero ";
    L9:
        r14.append(r15);
        r14.append(r10);
        r13.e(TAG, r14.toString());
        return 0;
    L11:
        if (r12 < MAX_MEMORY_SIZE) goto L14;
        r14 = new StringBuilder();
        r15 = "file size should no more than 5G ";
        goto L9
    L14:
        return r12;
    }

    public final IKeyInfoDistribute getIKeyInfoDistribute() {
        IKeyInfoDistribute r10 = iKeyInfoDistribute;
        if (r10 == null) goto L5;
        return r10;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("iKeyInfoDistribute");
        return null;
    }

    public final IModelInfoProvider getIModelInfoProvider() {
        IModelInfoProvider r10 = iModelInfoProvider;
        if (r10 == null) goto L5;
        return r10;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("iModelInfoProvider");
        return null;
    }

    public final File getModelDir(String r10) {
        Intrinsics.checkNotNullParameter(r10, "modelName");
        return getIModelInfoProvider().getModelSaveDir(r10);
    }

    public final List<Pair<String, k>> getModelFileInfoList(String r10) {
        Intrinsics.checkNotNullParameter(r10, "modelName");
        return getIModelInfoProvider().getModelFileInfoList(r10);
    }

    public final List<String> getModelFileList(String r10) {
        Intrinsics.checkNotNullParameter(r10, "modelName");
        return getIModelInfoProvider().getModelFileNameList(r10);
    }

    @Override // com.obric.aikernel.model_decrypt.api.IDecryptFeature
    public void init(IModelInfoProvider r10, IKeyInfoDistribute r11) {
        Intrinsics.checkNotNullParameter(r10, "iModelInfoProvider");
        Intrinsics.checkNotNullParameter(r11, "iKeyInfoDistribute");
        AIKLog.INSTANCE.d(TAG, "init: iModelInfoProvider = " + r10 + ", keyInfoRequestApi = " + r11);
        setIModelInfoProvider(r10);
        setIKeyInfoDistribute(r11);
    }

    @Override // com.obric.aikernel.model_decrypt.api.IDecryptFeature
    public boolean isEnable() {
        return true;
    }

    @Override // com.obric.aikernel.model_decrypt.api.IDecryptFeature
    public Object reEncryptKeyInfo(File r10, Continuation<? super Boolean> r11) {
        ModelFileMetaData r12 = IModelFileMetaDataManagerKt.getModelFileMetaDataManager().get(r10);
        if (r12 != null) goto L7;
        AIKLog.INSTANCE.w(TAG, "reEncryptFile: fileMeta is null, file = " + r10);
        return Boxing.boxBoolean(false);
    L7:
        return KeyInfoReEncryptHelper.INSTANCE.reEncryptKeyInfo(r10, r12.isPreset(), r12.getPresetKeyInfo(), r11);
    }

    @Override // com.obric.aikernel.model_decrypt.api.IDecryptFeature
    public Object requestKeyInfo(List<String> r10, Continuation<? super Unit> r11) {
        Object r12 = KeyInfoRequestHelper.INSTANCE.requestKeyInfo(r10, r11);
        if (r12 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r12;
    L6:
        return Unit.INSTANCE;
    }

    public final void setIKeyInfoDistribute(IKeyInfoDistribute r10) {
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        iKeyInfoDistribute = r10;
    }

    public final void setIModelInfoProvider(IModelInfoProvider r10) {
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        iModelInfoProvider = r10;
    }

    @Override // com.obric.aikernel.model_decrypt.api.IDecryptFeature
    /* JADX INFO: renamed from: simpleRequestKeyInfo-BWLJW6A */
    public Object mo18simpleRequestKeyInfoBWLJW6A(String r10, String r11, String r12, Continuation<? super Result<? extends Set<IKeyInfoDistribute.KeyInfoItem>>> r13) {
        return IDecryptFeature.DefaultImpls.m20simpleRequestKeyInfoBWLJW6A(this, r10, r11, r12, r13);
    }

    @Override // com.obric.aikernel.model_decrypt.api.IDecryptFeature
    /* JADX INFO: renamed from: simpleRequestKeyInfo-BWLJW6A */
    public Object mo19simpleRequestKeyInfoBWLJW6A(String r10, String r11, Set<String> r12, Continuation<? super Result<? extends Set<IKeyInfoDistribute.KeyInfoItem>>> r13) {
        if ((r13 instanceof DecryptFeatureImpl$simpleRequestKeyInfo$1) == false) goto L7;
        DecryptFeatureImpl$simpleRequestKeyInfo$1 r14 = (DecryptFeatureImpl$simpleRequestKeyInfo$1) r13;
        int r15 = r14.label;
        if ((r15 & Integer.MIN_VALUE) == 0) goto L7;
        r14.label = r15 - Integer.MIN_VALUE;
    L8:
        Object r16 = r14.result;
        Object r17 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r18 = r14.label;
        if (r18 == 0) goto L14;
        if (r18 != 1) goto L13;
        ResultKt.throwOnFailure(r16);
        Object r19 = ((Result) r16).m41unboximpl();
    L21:
        Throwable r20 = Result.m35exceptionOrNullimpl(r19);
        if (r20 == null) goto L24;
        AIKLog.INSTANCE.w(TAG, "requestKeyInfo failed: " + r20, r20);
    L24:
        return r19;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r16);
        if (iKeyInfoDistribute != null) goto L18;
        Result.Companion r21 = Result.Companion;
        return Result.m32constructorimpl(ResultKt.createFailure(new IllegalStateException("iKeyInfoDistribute is not initialized")));
    L18:
        IKeyInfoDistribute r22 = getIKeyInfoDistribute();
        r14.label = 1;
        r19 = r22.mo17onRequestKeyInfoBWLJW6A(r10, r11, r12, r14);
        if (r19 != r17) goto L21;
        return r17;
    L7:
        r14 = new DecryptFeatureImpl$simpleRequestKeyInfo$1(this, r13);
        goto L8
    }
}
