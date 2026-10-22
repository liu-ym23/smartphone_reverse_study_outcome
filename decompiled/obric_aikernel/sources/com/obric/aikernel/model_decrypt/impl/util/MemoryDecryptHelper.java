package com.obric.aikernel.model_decrypt.impl.util;

import com.bytedance.common.wschannel.WsConstants;
import com.obric.aikernel.middleware.api.appcontext.AppContext;
import com.obric.aikernel.middleware.api.log.AIKLog;
import com.obric.aikernel.middleware.api.traker.TrackerApi;
import com.obric.aikernel.model_decrypt.api.decrypt.IModelDecrypt;
import com.obric.aikernel.model_decrypt.api.decrypt.IModelDecryptKt;
import com.obric.aikernel.model_decrypt.api.filemeta.IModelFileMetaDataManager;
import com.obric.aikernel.model_decrypt.api.filemeta.IModelFileMetaDataManagerKt;
import com.obric.aikernel.model_decrypt.api.filemeta.ModelFileMetaData;
import com.obric.aikernel.model_decrypt.api.util.ByteBufferBackedOutputStream;
import com.obric.aikernel.utils.j;
import java.io.File;
import java.io.InputStream;
import java.nio.ByteBuffer;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.h;
import org.json.JSONObject;
import u7.d;

/* JADX INFO: loaded from: classes2.dex */
public final class MemoryDecryptHelper {
    public static final MemoryDecryptHelper INSTANCE = null;
    private static final String TAG = "MemoryDecryptHelper";

    static {
        INSTANCE = new MemoryDecryptHelper();
    }

    private MemoryDecryptHelper() {
    }

    /*  JADX ERROR: ConcurrentModificationException in pass: ConstructorVisitor
        java.util.ConcurrentModificationException
        	at java.base/java.util.ArrayList$Itr.checkForComodification(ArrayList.java:1104)
        	at java.base/java.util.ArrayList$Itr.next(ArrayList.java:1058)
        	at jadx.core.dex.visitors.ConstructorVisitor.insertPhiInsn(ConstructorVisitor.java:139)
        	at jadx.core.dex.visitors.ConstructorVisitor.processInvoke(ConstructorVisitor.java:91)
        	at jadx.core.dex.visitors.ConstructorVisitor.replaceInvoke(ConstructorVisitor.java:56)
        	at jadx.core.dex.visitors.ConstructorVisitor.visit(ConstructorVisitor.java:42)
        */
    private final boolean decryptModelFileByFEKCipher(
    /*  JADX ERROR: ConcurrentModificationException in pass: ConstructorVisitor
        java.util.ConcurrentModificationException
        	at java.base/java.util.ArrayList$Itr.checkForComodification(ArrayList.java:1104)
        	at java.base/java.util.ArrayList$Itr.next(ArrayList.java:1058)
        	at jadx.core.dex.visitors.ConstructorVisitor.insertPhiInsn(ConstructorVisitor.java:139)
        	at jadx.core.dex.visitors.ConstructorVisitor.processInvoke(ConstructorVisitor.java:91)
        	at jadx.core.dex.visitors.ConstructorVisitor.replaceInvoke(ConstructorVisitor.java:56)
        */
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r29v0 ??
        	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:236)
        	at jadx.core.codegen.MethodGen.addMethodArguments(MethodGen.java:215)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:150)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:415)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
        	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
        	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
        	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
        	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
        	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
        	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
        	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
        	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
        	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
        	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
        	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
        	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
        	at jadx.core.ProcessClass.process(ProcessClass.java:89)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
        	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
        	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
        */

    private final void reportDecryptFile(String r19, String r20, boolean r21, long r22, String r24, long r25, boolean r27, boolean r28) {
        JSONObject r10 = new JSONObject();
        r10.put("modelName", r19);
        r10.put("encryptFile", r20);
        r10.put("isSuccess", r21);
        r10.put("duration", r22);
        r10.put("fileSizeKB", r25);
        r10.put("extractToMemory", r27);
        r10.put("isPreset", r28);
        if (r21 == true) goto L6;
        r10.put("errorMsg", r24);
        r10.put("hasNet", j.f5600a.a());
    L6:
        d.b("model_decrypt_process", r10);
        if (r21 == true) goto L10;
        TrackerApi r11 = TrackerApi.INSTANCE;
        JSONObject r12 = new JSONObject();
        r12.put(WsConstants.KEY_CONNECTION_TYPE, "process");
        AppContext r13 = AppContext.INSTANCE;
        r12.put("isAdminMode", r13.isAdminMode());
        r12.put("isDebug", r13.isDebug());
        r12.put("channel", r13.getChannel());
        r12.put("hasNet", j.f5600a.a());
        r12.put("extractToMemory", r27);
        r12.put("isPreset", r28);
        Unit r14 = Unit.INSTANCE;
        JSONObject r15 = new JSONObject();
        r15.put("duration", r22);
        r15.put("fileSizeKB", r25);
        JSONObject r16 = new JSONObject();
        r16.put("encryptFile", r20);
        r16.put("errorMsg", r24);
        r16.put("modelName", r19);
        r11.monitorEvent("model_decrypt_error", r12, r15, r16);
        return;
    }

    static /* synthetic */ void reportDecryptFile$default(MemoryDecryptHelper r14, String r15, String r16, boolean r17, long r18, String r20, long r21, boolean r23, boolean r24, int r25, Object r26) {
        if ((r25 & 64) == 0) goto L5;
        boolean r12 = true;
    L7:
        if ((r25 & 128) == 0) goto L9;
        boolean r13 = true;
    L10:
        r14.reportDecryptFile(r15, r16, r17, r18, r20, r21, r12, r13);
        return;
    L9:
        r13 = r24;
        goto L10
    L5:
        r12 = r23;
        goto L7
    }

    public final boolean decryptFile(String r30, ByteBuffer r31) {
        Intrinsics.checkNotNullParameter(r30, "filePath");
        Intrinsics.checkNotNullParameter(r31, "outBuffer");
        AIKLog r10 = AIKLog.INSTANCE;
        r10.d(TAG, "decryptFile: filePath = " + r30 + ", outBuffer size = " + r31.remaining());
        final File r11 = new File(r30);
        ModelFileMetaData r12 = IModelFileMetaDataManagerKt.getModelFileMetaDataManager().get(r11);
        if (r12 != null) goto L7;
        r10.w(TAG, "decryptFile: meta is null " + r30);
        String r13 = r11.getName();
        Intrinsics.checkNotNullExpressionValue(r13, "encryptFile.name");
        boolean r19 = false;
        long r20 = 0;
        long r23 = 0;
        boolean r25 = false;
        boolean r26 = false;
        int r27 = 192;
        Object r28 = null;
        String r17 = "";
        String r22 = "file meta is null";
        String r18 = r13;
    L5:
        reportDecryptFile$default(this, r17, r18, r19, r20, r22, r23, r25, r26, r27, r28);
        return false;
    L7:
        long r24 = r12.getOriginSizeBytes() / ((long) 1024);
        if (r31.remaining() != 0) goto L12;
        r10.w(TAG, "decryptFile: outBuffer is empty, filePath = " + r30);
        r17 = r12.getModelName();
        String r14 = r11.getName();
        Intrinsics.checkNotNullExpressionValue(r14, "encryptFile.name");
        r19 = false;
        r20 = 0;
        boolean r15 = false;
        r26 = r12.isPreset();
        r27 = 64;
        r28 = null;
        r22 = "outBuffer is empty";
    L10:
        r18 = r14;
        r23 = r24;
        r25 = r15;
        goto L5
    L12:
        if (r12.isEncryptResource() == false) goto L29;
        if (r12.getFEKCipher().length() != 0) goto L16;
        boolean r16 = true;
    L17:
        if (r16 == false) goto L29;
        r10.w(TAG, "decryptFile: FEKCipher is empty, filePath = " + r30);
        String r110 = (String) h.f(null, new MemoryDecryptHelper$decryptFile$FEKCipher$1(r11, r12.isPreset(), r12.getPresetKeyInfo(), null), 1, null);
        if (r110 != null) goto L21;
    L24:
        boolean r21 = true;
    L25:
        if (r21 == false) goto L27;
        r17 = r12.getModelName();
        r14 = r11.getName();
        Intrinsics.checkNotNullExpressionValue(r14, "encryptFile.name");
        r19 = false;
        r20 = 0;
        r15 = false;
        r26 = r12.isPreset();
        r27 = 64;
        r28 = null;
        r22 = "no FEKCipher";
        goto L10
    L27:
        r12 = ModelFileMetaData.copy$default(r12, null, null, null, false, 0, false, false, null, null, null, null, r110, false, false, 14335, null);
        goto L29
    L21:
        if (r110.length() == 0) goto L24;
        r21 = false;
        goto L25
    L16:
        r16 = false;
    L29:
        ModelFileMetaData r111 = r12;
        if (r111.isPresetToAssets() == false) goto L78;
        final String r29 = r111.getPresetPath();
        r10.d(TAG, "assetPath = " + r29);
        if (r29.length() != 0) goto L34;
        boolean r112 = true;
    L35:
        if (r112 == false) goto L39;
        r10.w(TAG, "assetPath is empty, filePath = " + r30);
        String r113 = r111.getModelName();
        String r32 = r11.getName();
        Intrinsics.checkNotNullExpressionValue(r32, "encryptFile.name");
        reportDecryptFile$default(this, r113, r32, false, 0, "no asset path", r24, false, r111.isPreset(), 64, null);
        return false;
    L39:
        if (r111.isEncryptResource() == true) goto L95;
        Result.Companion r33 = Result.Companion;     // Catch: Throwable -> L67
        InputStream r34 = AppContext.INSTANCE.getContext().getAssets().open(r29);     // Catch: Throwable -> L67
        ByteBufferBackedOutputStream r35 = new ByteBufferBackedOutputStream(r31);     // Catch: Throwable -> L60
        byte[] r36 = new byte[4096];     // Catch: Throwable -> L53
    L45:
        int r37 = r34.read(r36);     // Catch: Throwable -> L53
        if (r37 == (-1)) goto L48;
        r35.write(r36, 0, r37);     // Catch: Throwable -> L53
        goto L45
    L48:
        Unit r38 = Unit.INSTANCE;     // Catch: Throwable -> L53
    L50:
        CloseableKt.closeFinally(r35, null);     // Catch: Throwable -> L60
        CloseableKt.closeFinally(r34, null);     // Catch: Throwable -> L67
        Object r39 = Result.m32constructorimpl(Boolean.TRUE);     // Catch: Throwable -> L67
    L69:
        Throwable r40 = Result.m35exceptionOrNullimpl(r39);
        if (r40 == null) goto L72;
        AIKLog.INSTANCE.w(TAG, "read from assets failed: " + r40.getMessage(), r40);
    L72:
        Boolean r41 = Boolean.FALSE;
        if (Result.m38isFailureimpl(r39) == false) goto L76;
        r39 = r41;
    L76:
        return ((Boolean) r39).booleanValue();
    L53:
        th = move-exception;
        throw th;     // Catch: Throwable -> L56
    L56:
        th = move-exception;
        CloseableKt.closeFinally(r35, th);     // Catch: Throwable -> L60
        throw th;     // Catch: Throwable -> L60
    L60:
        th = move-exception;
        throw th;     // Catch: Throwable -> L63
    L63:
        th = move-exception;
        CloseableKt.closeFinally(r34, th);     // Catch: Throwable -> L67
        throw th;     // Catch: Throwable -> L67
    L67:
        th = move-exception;
        Result.Companion r42 = Result.Companion;
        r39 = Result.m32constructorimpl(ResultKt.createFailure(th));
        goto L69
    L95:
        return decryptModelFileByFEKCipher(r111.getModelName(), r11, new AnonymousClass1(r29), r31, r111.getFEKCipher(), r111.isPreset(), r24);
    L34:
        r112 = false;
        goto L35
    L78:
        if (r111.getCheckModelIntegrity() == true) goto L85;
        IModelDecrypt r43 = IModelDecryptKt.getModelDecrypt();
        String r44 = r11.getAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(r44, "encryptFile.absolutePath");
        if (r43.checkModelIntegrity(r44) == false) goto L82;
        IModelFileMetaDataManager.DefaultImpls.update$default(IModelFileMetaDataManagerKt.getModelFileMetaDataManager(), r11, false, AnonymousClass4.INSTANCE, 2, null);
        goto L85
    L82:
        r10.w(TAG, "checkModelIntegrity failed: " + r11);
        return false;
    L85:
        return decryptModelFileByFEKCipher(r111.getModelName(), r11, new AnonymousClass5(r11), r31, r111.getFEKCipher(), r111.isPreset(), r24);
    }
}
