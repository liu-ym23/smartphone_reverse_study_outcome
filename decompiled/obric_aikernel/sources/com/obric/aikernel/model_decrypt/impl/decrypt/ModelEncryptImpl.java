package com.obric.aikernel.model_decrypt.impl.decrypt;

import android.os.SystemClock;
import com.bytedance.common.wschannel.WsConstants;
import com.obric.aikernel.middleware.api.appcontext.AppContext;
import com.obric.aikernel.middleware.api.log.AIKLog;
import com.obric.aikernel.middleware.api.traker.TrackerApi;
import com.obric.aikernel.model_decrypt.api.decrypt.IModelDecrypt;
import com.obric.aikernel.model_decrypt.api.util.ByteBufferBackedOutputStream;
import com.obric.aikernel.model_decrypt.impl.util.String_extKt;
import com.obric.aikernel.utils.j;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import u7.d;

/* JADX INFO: loaded from: classes2.dex */
public final class ModelEncryptImpl implements IModelDecrypt {
    public static final ModelEncryptImpl INSTANCE = null;
    private static final String TAG = "ModelEncryptionImpl";

    static {
        INSTANCE = new ModelEncryptImpl();
    }

    private ModelEncryptImpl() {
    }

    @JvmStatic
    public static final ModelEncryptImpl getInst() {
        return INSTANCE;
    }

    private final void reportCheckIntegrity(String r10, boolean r11, long r12, int r13, String r14) {
        JSONObject r15 = new JSONObject();
        r15.put("encryptFilePath", String_extKt.shortFilePath(r10));
        r15.put("isSuccess", r11);
        r15.put("duration", r12);
        if (r11 == true) goto L5;
        r15.put("errorCode", r13);
        r15.put("errorMsg", r14);
        r15.put("hasNet", j.f5600a.a());
    L5:
        d.b("model_decrypt_check_integrity", r15);
        if (r11 == true) goto L9;
        TrackerApi r16 = TrackerApi.INSTANCE;
        JSONObject r17 = new JSONObject();
        r17.put(WsConstants.KEY_CONNECTION_TYPE, "check_integrity");
        r17.put("errorCode", r13);
        AppContext r18 = AppContext.INSTANCE;
        r17.put("isAdminMode", r18.isAdminMode());
        r17.put("isDebug", r18.isDebug());
        r17.put("channel", r18.getChannel());
        r17.put("hasNet", j.f5600a.a());
        Unit r19 = Unit.INSTANCE;
        JSONObject r110 = new JSONObject();
        r110.put("duration", r12);
        JSONObject r111 = new JSONObject();
        r111.put("encryptFilePath", String_extKt.shortFilePath(r10));
        r111.put("errorMsg", r14);
        r16.monitorEvent("model_decrypt_error", r17, r110, r111);
        return;
    }

    static /* synthetic */ void reportCheckIntegrity$default(ModelEncryptImpl r10, String r11, boolean r12, long r13, int r14, String r15, int r16, Object r17) {
        if ((r16 & 16) == 0) goto L5;
        r15 = null;
    L5:
        r10.reportCheckIntegrity(r11, r12, r13, r14, r15);
    }

    private final void reportDecryptModelFileByKeyInfo(String r17, boolean r18, long r19, int r21, String r22, String r23, boolean r24) {
        JSONObject r10 = new JSONObject();
        r10.put("encryptFilePath", String_extKt.shortFilePath(r17));
        r10.put("isSuccess", r18);
        r10.put("duration", r19);
        r10.put("keyType", r23);
        r10.put("extractToMemory", r24);
        if (r18 == true) goto L5;
        r10.put("errorCode", r21);
        r10.put("errorMsg", r22);
        r10.put("hasNet", j.f5600a.a());
    L5:
        d.b("model_decrypt_decrypt", r10);
        if (r18 == true) goto L9;
        TrackerApi r11 = TrackerApi.INSTANCE;
        JSONObject r12 = new JSONObject();
        r12.put(WsConstants.KEY_CONNECTION_TYPE, "decrypt_file");
        r12.put("errorCode", r21);
        AppContext r13 = AppContext.INSTANCE;
        r12.put("isAdminMode", r13.isAdminMode());
        r12.put("isDebug", r13.isDebug());
        r12.put("channel", r13.getChannel());
        r12.put("hasNet", j.f5600a.a());
        r12.put("keyType", r23);
        r12.put("extractToMemory", r24);
        Unit r14 = Unit.INSTANCE;
        JSONObject r15 = new JSONObject();
        r15.put("duration", r19);
        JSONObject r16 = new JSONObject();
        r16.put("encryptFilePath", String_extKt.shortFilePath(r17));
        r16.put("errorMsg", r22);
        r11.monitorEvent("model_decrypt_error", r12, r15, r16);
        return;
    }

    static /* synthetic */ void reportDecryptModelFileByKeyInfo$default(ModelEncryptImpl r10, String r11, boolean r12, long r13, int r15, String r16, String r17, boolean r18, int r19, Object r20) {
        if ((r19 & 16) == 0) goto L5;
        String r14 = null;
    L6:
        r10.reportDecryptModelFileByKeyInfo(r11, r12, r13, r15, r14, r17, r18);
        return;
    L5:
        r14 = r16;
        goto L6
    }

    @Override // com.obric.aikernel.model_decrypt.api.decrypt.IModelDecrypt
    public boolean checkModelIntegrity(String r10) {
        Intrinsics.checkNotNullParameter(r10, "encryptFilePath");
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L13
        FileInputStream r12 = new FileInputStream(r10);     // Catch: Throwable -> L13
        boolean r13 = INSTANCE.checkModelIntegrity(r10, r12);     // Catch: Throwable -> L8
        CloseableKt.closeFinally(r12, null);     // Catch: Throwable -> L13
        Object r14 = Result.m32constructorimpl(Boolean.valueOf(r13));     // Catch: Throwable -> L13
    L15:
        Throwable r15 = Result.m35exceptionOrNullimpl(r14);
        if (r15 == null) goto L18;
        AIKLog.INSTANCE.w(TAG, "checkModelIntegrity failed: encryptFilePath = " + r10 + ", " + r15.getMessage(), r15);
    L18:
        Boolean r16 = Boolean.FALSE;
        if (Result.m38isFailureimpl(r14) == false) goto L22;
        r14 = r16;
    L22:
        return ((Boolean) r14).booleanValue();
    L8:
        th = move-exception;
        throw th;     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        CloseableKt.closeFinally(r12, th);     // Catch: Throwable -> L13
        throw th;     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        Result.Companion r17 = Result.Companion;
        r14 = Result.m32constructorimpl(ResultKt.createFailure(th));
        goto L15
    }

    @Override // com.obric.aikernel.model_decrypt.api.decrypt.IModelDecrypt
    public boolean checkModelIntegrity(String r13, InputStream r14) {
        Intrinsics.checkNotNullParameter(r13, "logLabel");
        Intrinsics.checkNotNullParameter(r14, "encryptInputStream");
        long r10 = SystemClock.elapsedRealtime();
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L5
        AIKLog.INSTANCE.d(TAG, "checkModelIntegrity start: logLabel = " + r13);     // Catch: Throwable -> L5
        Object r15 = Result.m32constructorimpl(Integer.valueOf(DecryptSdkWrapper.INSTANCE.checkModelIntegrity(r14)));     // Catch: Throwable -> L5
    L7:
        Throwable r12 = Result.m35exceptionOrNullimpl(r15);
        if (r12 == null) goto L14;
        AIKLog.INSTANCE.w(TAG, "checkModelIntegrity failed: logLabel = " + r13 + ", " + r12.getMessage(), r12);
        ModelEncryptImpl r16 = INSTANCE;
        long r17 = SystemClock.elapsedRealtime() - r10;
        String r18 = r12.getMessage();
        if (r18 != null) goto L12;
        r18 = "";
    L12:
        r16.reportCheckIntegrity(r13, false, r17, -1000, r18);
    L14:
        if (Result.m39isSuccessimpl(r15) == false) goto L21;
        int r19 = ((Number) r15).intValue();
        AIKLog.INSTANCE.w(TAG, "checkModelIntegrity finished: encryptFilePath = " + r13 + ", ret = " + r19);
        ModelEncryptImpl r20 = INSTANCE;
        if (r19 != 0) goto L18;
        boolean r21 = true;
    L19:
        r20.reportCheckIntegrity(r13, r21, SystemClock.elapsedRealtime() - r10, r19, null);
        goto L21
    L18:
        r21 = false;
    L21:
        if (Result.m38isFailureimpl(r15) == false) goto L24;
        r15 = -1000;
    L24:
        if (((Number) r15).intValue() != 0) goto L27;
        return true;
    L27:
        return false;
    L5:
        th = move-exception;
        Result.Companion r22 = Result.Companion;
        r15 = Result.m32constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    @Override // com.obric.aikernel.model_decrypt.api.decrypt.IModelDecrypt
    public boolean decryptModelFileByFEKCipher(String r17, InputStream r18, OutputStream r19, String r20, boolean r21, boolean r22) {
        Intrinsics.checkNotNullParameter(r17, "logLabel");
        Intrinsics.checkNotNullParameter(r18, "inputStream");
        Intrinsics.checkNotNullParameter(r19, "outputStream");
        Intrinsics.checkNotNullParameter(r20, "FEKCipher");
        long r11 = SystemClock.elapsedRealtime();
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L5
        Object r12 = Result.m32constructorimpl(Integer.valueOf(DecryptSdkWrapper.INSTANCE.decryptModelFileByFEKCipher(AppContext.INSTANCE.getContext(), r18, r19, r20, r21)));     // Catch: Throwable -> L5
    L8:
        if (Result.m39isSuccessimpl(r12) == false) goto L14;
        int r13 = ((Number) r12).intValue();
        AIKLog.INSTANCE.d(TAG, "decryptModelFileByFEKCipher finished. ret = " + r13);
        ModelEncryptImpl r14 = INSTANCE;
        if (r13 != 0) goto L12;
        boolean r15 = true;
    L13:
        r14.reportDecryptModelFileByKeyInfo(r17, r15, SystemClock.elapsedRealtime() - r11, r13, null, "FEKCipher", r22);
        goto L14
    L12:
        r15 = false;
    L14:
        Throwable r16 = Result.m35exceptionOrNullimpl(r12);
        if (r16 == null) goto L21;
        AIKLog.INSTANCE.w(TAG, "decryptModelFileByFEKCipher failed: " + r16.getMessage(), r16);
        ModelEncryptImpl r23 = INSTANCE;
        long r24 = SystemClock.elapsedRealtime() - r11;
        String r25 = r16.getMessage();
        if (r25 != null) goto L19;
        r25 = "";
    L19:
        r23.reportDecryptModelFileByKeyInfo(r17, false, r24, -1000, r25, "FEKCipher", r22);
    L21:
        if (Result.m38isFailureimpl(r12) == false) goto L24;
        r12 = -1000;
    L24:
        if (((Number) r12).intValue() != 0) goto L27;
        return true;
    L27:
        return false;
    L5:
        th = move-exception;
        Result.Companion r26 = Result.Companion;
        r12 = Result.m32constructorimpl(ResultKt.createFailure(th));
        goto L8
    }

    @Override // com.obric.aikernel.model_decrypt.api.decrypt.IModelDecrypt
    public boolean decryptModelFileByFEKCipher(String r14, InputStream r15, String r16, String r17, boolean r18) {
        Intrinsics.checkNotNullParameter(r14, "logLabel");
        Intrinsics.checkNotNullParameter(r15, "inputStream");
        Intrinsics.checkNotNullParameter(r16, "outputFilePath");
        Intrinsics.checkNotNullParameter(r17, "FEKCipher");
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L5
        Object r11 = Result.m32constructorimpl(new FileOutputStream(r16));     // Catch: Throwable -> L5
    L7:
        Throwable r12 = Result.m35exceptionOrNullimpl(r11);
        if (r12 == null) goto L11;
        AIKLog.INSTANCE.w(TAG, "decryptModelFileByFEKCipher create output stream failed: " + r12.getMessage() + ", inputLabel = " + r14, r12);
    L11:
        if (Result.m38isFailureimpl(r11) == false) goto L13;
        r11 = null;
    L13:
        FileOutputStream r13 = (FileOutputStream) r11;
        if (r13 == null) goto L26;
        boolean r19 = IModelDecrypt.DefaultImpls.decryptModelFileByFEKCipher$default(INSTANCE, r14, r15, r13, r17, r18, false, 32, null);     // Catch: Throwable -> L19
        CloseableKt.closeFinally(r13, null);
        if (r19 != true) goto L26;
        return true;
    L19:
        th = move-exception;
        throw th;     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        CloseableKt.closeFinally(r13, th);
        throw th;
    L26:
        return false;
    L5:
        th = move-exception;
        Result.Companion r20 = Result.Companion;
        r11 = Result.m32constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    @Override // com.obric.aikernel.model_decrypt.api.decrypt.IModelDecrypt
    public boolean decryptModelFileByFEKCipher(String r10, InputStream r11, ByteBuffer r12, String r13, boolean r14) {
        Intrinsics.checkNotNullParameter(r10, "logLabel");
        Intrinsics.checkNotNullParameter(r11, "inputStream");
        Intrinsics.checkNotNullParameter(r12, "outBuffer");
        Intrinsics.checkNotNullParameter(r13, "FEKCipher");
        Result.Companion r15 = Result.Companion;     // Catch: Throwable -> L5
        Object r16 = Result.m32constructorimpl(new ByteBufferBackedOutputStream(r12));     // Catch: Throwable -> L5
    L7:
        Throwable r17 = Result.m35exceptionOrNullimpl(r16);
        if (r17 == null) goto L11;
        AIKLog.INSTANCE.w(TAG, "decryptModelFileByFEKCipher create output stream failed: " + r17.getMessage() + ", inputLabel = " + r10, r17);
    L11:
        if (Result.m38isFailureimpl(r16) == false) goto L13;
        r16 = null;
    L13:
        ByteBufferBackedOutputStream r18 = (ByteBufferBackedOutputStream) r16;
        if (r18 != null) goto L27;
        return false;
    L27:
        boolean r19 = INSTANCE.decryptModelFileByFEKCipher(r10, r11, r18, r13, r14, true);     // Catch: Throwable -> L20
        CloseableKt.closeFinally(r18, null);
        return r19;
    L20:
        th = move-exception;
        throw th;     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        CloseableKt.closeFinally(r18, th);
        throw th;
    L5:
        th = move-exception;
        Result.Companion r110 = Result.Companion;
        r16 = Result.m32constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    @Override // com.obric.aikernel.model_decrypt.api.decrypt.IModelDecrypt
    public boolean decryptModelFileByFEKCipher(String r14, String r15, String r16, String r17, boolean r18) {
        Intrinsics.checkNotNullParameter(r14, "logLabel");
        Intrinsics.checkNotNullParameter(r15, "inputFilePath");
        Intrinsics.checkNotNullParameter(r16, "outputFilePath");
        Intrinsics.checkNotNullParameter(r17, "FEKCipher");
        Unit r10 = null;
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L5
        Object r12 = Result.m32constructorimpl(new FileInputStream(r15));     // Catch: Throwable -> L5
    L7:
        Throwable r13 = Result.m35exceptionOrNullimpl(r12);     // Catch: Throwable -> L62
        if (r13 == null) goto L12;
        AIKLog.INSTANCE.w(TAG, "decryptModelFileByFEKCipher create input stream failed: " + r13.getMessage() + ", inputLabel = " + r14, r13);     // Catch: Throwable -> L62
    L12:
        if (Result.m38isFailureimpl(r12) == false) goto L14;
        r12 = null;
    L14:
        FileInputStream r19 = (FileInputStream) r12;     // Catch: Throwable -> L62
        if (r19 != null) goto L98;
        Result.Companion r20 = Result.Companion;     // Catch: Throwable -> L55
        Result.m32constructorimpl(null);     // Catch: Throwable -> L55
    L96:
        Result.Companion r21 = Result.Companion;     // Catch: Throwable -> L59
        Result.m32constructorimpl(null);     // Catch: Throwable -> L59
    L61:
        return false;
    L59:
        th = move-exception;
        Result.Companion r22 = Result.Companion;
        Result.m32constructorimpl(ResultKt.createFailure(th));
    L55:
        th = move-exception;
        Result.Companion r23 = Result.Companion;
        Result.m32constructorimpl(ResultKt.createFailure(th));
        goto L96
    L98:
        Result.Companion r24 = Result.Companion;     // Catch: Throwable -> L19
        Object r25 = Result.m32constructorimpl(new FileOutputStream(r16));     // Catch: Throwable -> L19
    L21:
        Throwable r26 = Result.m35exceptionOrNullimpl(r25);     // Catch: Throwable -> L51
        if (r26 == null) goto L25;
        AIKLog.INSTANCE.w(TAG, "decryptModelFileByFEKCipher create output stream failed: " + r26.getMessage() + ", inputLabel = " + r14, r26);     // Catch: Throwable -> L51
    L25:
        if (Result.m38isFailureimpl(r25) == false) goto L27;
        r25 = null;
    L27:
        FileOutputStream r110 = (FileOutputStream) r25;     // Catch: Throwable -> L51
        if (r110 != null) goto L92;
        Result.Companion r27 = Result.Companion;     // Catch: Throwable -> L44
        r19.close();     // Catch: Throwable -> L44
        Result.m32constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L44
    L88:
        Result.Companion r28 = Result.Companion;     // Catch: Throwable -> L48
        Result.m32constructorimpl(null);     // Catch: Throwable -> L48
    L50:
        return false;
    L48:
        th = move-exception;
        Result.Companion r29 = Result.Companion;
        Result.m32constructorimpl(ResultKt.createFailure(th));
    L44:
        th = move-exception;
        Result.Companion r30 = Result.Companion;
        Result.m32constructorimpl(ResultKt.createFailure(th));
        goto L88
    L92:
        boolean r31 = IModelDecrypt.DefaultImpls.decryptModelFileByFEKCipher$default(this, r14, r19, r110, r17, r18, false, 32, null);     // Catch: Throwable -> L40
        Result.Companion r32 = Result.Companion;     // Catch: Throwable -> L33
        r19.close();     // Catch: Throwable -> L33
        Result.m32constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L33
    L82:
        Result.Companion r33 = Result.Companion;     // Catch: Throwable -> L37
        r110.close();     // Catch: Throwable -> L37
        Result.m32constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L37
    L39:
        return r31;
    L37:
        th = move-exception;
        Result.Companion r34 = Result.Companion;
        Result.m32constructorimpl(ResultKt.createFailure(th));
    L33:
        th = move-exception;
        Result.Companion r35 = Result.Companion;
        Result.m32constructorimpl(ResultKt.createFailure(th));
    L40:
        th = move-exception;
        Throwable r36 = th;
    L94:
        Result.Companion r37 = Result.Companion;     // Catch: Throwable -> L70
        if (r19 == null) goto L67;
        r19.close();     // Catch: Throwable -> L70
        Unit r38 = Unit.INSTANCE;     // Catch: Throwable -> L70
    L68:
        Result.m32constructorimpl(r38);     // Catch: Throwable -> L70
    L84:
        Result.Companion r39 = Result.Companion;     // Catch: Throwable -> L77
        if (r110 == null) goto L75;
        r110.close();     // Catch: Throwable -> L77
        r10 = Unit.INSTANCE;     // Catch: Throwable -> L77
    L75:
        Result.m32constructorimpl(r10);     // Catch: Throwable -> L77
        throw r36;
    L77:
        th = move-exception;
        Result.Companion r40 = Result.Companion;
        Result.m32constructorimpl(ResultKt.createFailure(th));
        throw r36;
    L67:
        r38 = null;
    L70:
        th = move-exception;
        Result.Companion r41 = Result.Companion;
        Result.m32constructorimpl(ResultKt.createFailure(th));
        goto L84
    L19:
        th = move-exception;
        Result.Companion r42 = Result.Companion;     // Catch: Throwable -> L51
        r25 = Result.m32constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L51
    L51:
        th = move-exception;
        r36 = th;
        r110 = null;
        goto L94
    L5:
        th = move-exception;
        Result.Companion r43 = Result.Companion;     // Catch: Throwable -> L62
        r12 = Result.m32constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L62
    L62:
        th = move-exception;
        r36 = th;
        r19 = null;
        r110 = null;
        goto L94
    }

    @Override // com.obric.aikernel.model_decrypt.api.decrypt.IModelDecrypt
    public boolean decryptModelFileByKeyInfo(String r17, InputStream r18, String r19, String r20, String r21) {
        Intrinsics.checkNotNullParameter(r17, "logLabel");
        Intrinsics.checkNotNullParameter(r18, "inputStream");
        Intrinsics.checkNotNullParameter(r19, "outputFilePath");
        Intrinsics.checkNotNullParameter(r20, "keyAlias");
        Intrinsics.checkNotNullParameter(r21, "keyInfo");
        AIKLog.INSTANCE.d(TAG, "decryptModelFileToFile: logLabel = " + r17 + ", outputFilePath = " + r19);
        long r12 = SystemClock.elapsedRealtime();
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L15
        FileOutputStream r11 = new FileOutputStream(r19);     // Catch: Throwable -> L15
        int r13 = DecryptSdkWrapper.INSTANCE.decryptModelFileByKeyInfo(AppContext.INSTANCE.getContext(), r18, r11, r20, r21);     // Catch: Throwable -> L8
        CloseableKt.closeFinally(r11, null);     // Catch: Throwable -> L15
        Object r14 = Result.m32constructorimpl(Integer.valueOf(r13));     // Catch: Throwable -> L15
    L18:
        if (Result.m39isSuccessimpl(r14) == false) goto L24;
        int r15 = ((Number) r14).intValue();
        AIKLog.INSTANCE.d(TAG, "decryptModelFileToFile finished. ret = " + r15);
        ModelEncryptImpl r16 = INSTANCE;
        if (r15 != 0) goto L22;
        boolean r22 = true;
    L23:
        r16.reportDecryptModelFileByKeyInfo(r17, r22, SystemClock.elapsedRealtime() - r12, r15, null, "keyInfo", false);
        goto L24
    L22:
        r22 = false;
    L24:
        Throwable r23 = Result.m35exceptionOrNullimpl(r14);
        if (r23 == null) goto L31;
        AIKLog.INSTANCE.w(TAG, "decryptModelFileToFile failed " + r23.getMessage() + ", logLabel = " + r17, r23);
        ModelEncryptImpl r24 = INSTANCE;
        long r25 = SystemClock.elapsedRealtime() - r12;
        String r26 = r23.getMessage();
        if (r26 != null) goto L29;
        r26 = "";
    L29:
        r24.reportDecryptModelFileByKeyInfo(r17, false, r25, -1000, r26, "keyInfo", false);
    L31:
        if (Result.m38isFailureimpl(r14) == false) goto L34;
        r14 = -1000;
    L34:
        if (((Number) r14).intValue() != 0) goto L37;
        return true;
    L37:
        return false;
    L8:
        th = move-exception;
        throw th;     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        CloseableKt.closeFinally(r11, th);     // Catch: Throwable -> L15
        throw th;     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        Result.Companion r27 = Result.Companion;
        r14 = Result.m32constructorimpl(ResultKt.createFailure(th));
        goto L18
    }

    @Override // com.obric.aikernel.model_decrypt.api.decrypt.IModelDecrypt
    public boolean decryptModelFileByKeyInfo(String r10, String r11, String r12, String r13) {
        Intrinsics.checkNotNullParameter(r10, "inputFilePath");
        Intrinsics.checkNotNullParameter(r11, "outputFilePath");
        Intrinsics.checkNotNullParameter(r12, "keyAlias");
        Intrinsics.checkNotNullParameter(r13, "keyInfo");
        AIKLog.INSTANCE.d(TAG, "decryptModelFileToFile: encryptFilePath = " + r10 + ", outputFilePath = " + r11);
        Result.Companion r14 = Result.Companion;     // Catch: Throwable -> L5
        Object r15 = Result.m32constructorimpl(new FileInputStream(r10));     // Catch: Throwable -> L5
    L7:
        Throwable r16 = Result.m35exceptionOrNullimpl(r15);
        if (r16 == null) goto L11;
        AIKLog.INSTANCE.w(TAG, "decryptModelFileToFile failed: " + r16.getMessage(), r16);
    L11:
        if (Result.m38isFailureimpl(r15) == false) goto L13;
        r15 = null;
    L13:
        FileInputStream r17 = (FileInputStream) r15;
        if (r17 == null) goto L25;
        boolean r18 = INSTANCE.decryptModelFileByKeyInfo(r10, r17, r11, r12, r13);     // Catch: Throwable -> L19
        CloseableKt.closeFinally(r17, null);
        if (r18 != true) goto L25;
        return true;
    L19:
        th = move-exception;
        throw th;     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        CloseableKt.closeFinally(r17, th);
        throw th;
    L25:
        return false;
    L5:
        th = move-exception;
        Result.Companion r19 = Result.Companion;
        r15 = Result.m32constructorimpl(ResultKt.createFailure(th));
        goto L7
    }
}
