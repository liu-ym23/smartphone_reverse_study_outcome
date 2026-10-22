package com.larus.avlink.gallery.processor;

import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.avlink.gallery.model.MediaMetadata;
import com.larus.avlink.gallery.view.mob.GalleryMobHelper;
import com.larus.platform.model.GeoLocationInfo;
import com.larus.platform.service.o3;
import com.larus.utils.logger.FLogger;
import java.io.File;
import java.util.Arrays;
import java.util.LinkedHashMap;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.io.CloseableKt;
import kotlin.io.FilesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import v98.r;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class VideoPackProcessor implements i {
    public static final s98.c a = null;

    public static final class a {
    }

    public VideoPackProcessor() {
    }

    static {
        a = new s98.c(0);
    }

    public static void d(String r12, MediaMetadata r13) {
        PolarisFileWrapper r0 = new PolarisFileWrapper(r12 + ".tmp.mp4");
        LinkedHashMap r1 = new LinkedHashMap();
        GeoLocationInfo r2 = r13.getGeoLocationInfo();
        boolean r3 = true;
        if (r2 == null) goto L8;
        double r5 = r2.getLongitude();
        double r7 = r2.getLatitude();
        if (r5 <= 180.0d) goto L7;
        r5 = r5 - ((double) 360);
    L7:
        String r6 = String.format("%+.4f%+.4f/", Arrays.copyOf(new Object[]{Double.valueOf(r7), Double.valueOf(r5)}, 2));
        FLogger.a.i("VideoPackProcessor", "Formatted location (ISO 6709): " + r6);
        r1.put("location", r6);
        r1.put("xyz", r6);
    L8:
        String r8 = "";
        if (r1.isEmpty() == true) goto L14;
        r3 = o3.b.i(r12, r0.getAbsolutePath(), r1);
        if (r3 == false) goto L13;
        new PolarisFileWrapper(r12).delete();
        r0.renameTo(new PolarisFileWrapper(r12));
        FLogger.a.i("VideoPackProcessor", "Location metadata (xyz) set successfully for ".concat(r12));
        goto L14
    L13:
        r0.delete();
        FLogger.a.e("VideoPackProcessor", "Failed to set location metadata (xyz) for ".concat(r12));
        r8 = "Failed to set location metadata (xyz)";
    L14:
        if (r2 == null) goto L20;
        GalleryMobHelper r14 = GalleryMobHelper.a;
        String r15 = r13.getMediaType();
        if (r15 != null) goto L18;
        r15 = "image";
    L18:
        r14.getClass();
        GalleryMobHelper.j(r15, r2, r3, r8);
        return;
    }

    @Override // com.larus.avlink.gallery.processor.i
    public final Object a(String r4, MediaMetadata r5, Continuation<? super k> r6) {
        return BuildersKt.withContext(Dispatchers.getIO(), new VideoPackProcessor$processSync$2(this, r4, r5, null), r6);
    }

    /* JADX WARN: Unreachable blocks removed: 2, instructions: 9 */
    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached with updateSeq = 32291. Try increasing type updates limit count.
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:79)
        */
    public final java.lang.Object c(java.lang.String r61, com.larus.avlink.gallery.model.MediaMetadata r62, kotlin.coroutines.Continuation<? super com.larus.avlink.gallery.processor.k> r63) {
        /*  JADX ERROR: Simple mode code generation failed
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0035: INSTANCE_OF (r6v2 ?? I:boolean) = (r63v0 ?? I:??[OBJECT, ARRAY]) A[DECLARE_VAR] (LINE:50331701) com.larus.avlink.gallery.processor.VideoPackProcessor$processVideo$1 in method: com.larus.avlink.gallery.processor.VideoPackProcessor.c(java.lang.String, com.larus.avlink.gallery.model.MediaMetadata, kotlin.coroutines.Continuation<? super com.larus.avlink.gallery.processor.k>):java.lang.Object, file: /private/tmp/nixiang/classes25.dex
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
            	at jadx.core.codegen.MethodGen.generateSimpleCode(MethodGen.java:348)
            	at jadx.core.codegen.MethodGen.addSimpleMethodCode(MethodGen.java:316)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:279)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
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
            Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.ArgType.getPrimitiveType()" because "type" is null
            	at jadx.core.codegen.ClassGen.useType(ClassGen.java:564)
            	at jadx.core.codegen.InsnGen.useType(InsnGen.java:269)
            	at jadx.core.codegen.InsnGen.declareVar(InsnGen.java:166)
            	at jadx.core.codegen.InsnGen.declareVar(InsnGen.java:159)
            	at jadx.core.codegen.InsnGen.assignVar(InsnGen.java:152)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:299)
            	... 31 more
            */
        /*
            Method dump skipped, instruction units count: 3229
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.larus.avlink.gallery.processor.VideoPackProcessor.c(java.lang.String, com.larus.avlink.gallery.model.MediaMetadata, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static k b(String r26, String r27, String r28, String r29, long r30, boolean r32, String r33, MediaMetadata r34) {
        if (r32 == false) goto L95;
        FLogger r10 = FLogger.a;
        r10.w("VideoPackProcessor", "Attempting fallback: extracting raw video from pack without stabilization");
        PolarisFileWrapper r5 = new PolarisFileWrapper(r26);     // Catch: Throwable -> L71 Exception -> L73
        if (r5.exists() == false) goto L143;
        r10.i("VideoPackProcessor", "Attempting to extract raw video from pack (fallback mode): " + r26);     // Catch: Throwable -> L71 Exception -> L73
        File r6 = new PolarisFileWrapper(r5.getParentFile(), "fallback_unpack_" + System.currentTimeMillis());     // Catch: Throwable -> L71 Exception -> L73
        r6.mkdirs();     // Catch: Throwable -> L67 Exception -> L69
        PolarisFileInputStreamWrapper r4 = new PolarisFileInputStreamWrapper(r5);     // Catch: Throwable -> L67 Exception -> L69
        ja8.f.a(r4, r6.getAbsolutePath());     // Catch: Throwable -> L60
        Unit r7 = Unit.INSTANCE;     // Catch: Throwable -> L60
    L15:
        CloseableKt.closeFinally(r4, null);     // Catch: Throwable -> L67 Exception -> L69
        r10.i("VideoPackProcessor", "Successfully unpacked to: " + r6.getAbsolutePath());     // Catch: Throwable -> L67 Exception -> L69
        File[] r8 = r6.listFiles();     // Catch: Throwable -> L67 Exception -> L69
        if (r8 == null) goto L29;
        int r9 = r8.length;     // Catch: Throwable -> L67 Exception -> L69
        int r11 = 0;
    L18:
        if (r11 >= r9) goto L29;
        File r13 = r8[r11];     // Catch: Throwable -> L67 Exception -> L69
        if (r13.isFile() == false) goto L25;
        if (StringsKt.endsWith(r13.getName(), ".mp4", true) == false) goto L25;
        boolean r14 = true;
    L26:
        if (r14 == true) goto L27;
        r11 = r11 + 1;     // Catch: Throwable -> L67 Exception -> L69
        goto L18
    L27:
        File r20 = r13;
    L30:
        if (r20 != null) goto L38;
        FLogger r0 = FLogger.a;     // Catch: Throwable -> L67 Exception -> L69
        r0.e("VideoPackProcessor", "No .mp4 file found in unpacked directory");     // Catch: Throwable -> L67 Exception -> L69
    L36:
        e = e;
        FLogger r12 = FLogger.a;
        StringBuilder r15 = new StringBuilder("Failed to cleanup temp unpack directory: ");
    L83:
        r15.append(e.getMessage());
        r12.w("VideoPackProcessor", r15.toString());
    L84:
        boolean r16 = false;
    L114:
        if (r16 == false) goto L123;
        int r1 = j0.a;
        a.d(r27, r28, r29);
        if (r32 == false) goto L120;
        PolarisFileWrapper r2 = new PolarisFileWrapper(r26);
        if (r2.exists() == false) goto L120;
        r.a.a(r26, r2.getName(), r2.length());
    L120:
        d(r27, r34);
        return new k(true, r27, null, System.currentTimeMillis() - r30, MapsKt.mapOf(TuplesKt.to("fallback_reason", r33)), true, 4);
    L123:
        return new k(false, null, r33 + ", fallback also failed", System.currentTimeMillis() - r30, null, false, 50);
    L33:
        if (r6.exists() == false) goto L136;
        FilesKt.deleteRecursively(r6);     // Catch: Exception -> L36
        r0.d("VideoPackProcessor", "Cleaned up temp unpack directory: " + r6.getAbsolutePath());     // Catch: Exception -> L36
    L136:
        goto L84
    L38:
        FLogger r17 = FLogger.a;     // Catch: Throwable -> L67 Exception -> L69
        r17.i("VideoPackProcessor", "Found raw video: " + r20.getName() + " (" + r20.length() + " bytes)");     // Catch: Throwable -> L67 Exception -> L69
        PolarisFileWrapper r18 = new PolarisFileWrapper(r27);     // Catch: Throwable -> L67 Exception -> L69
        File r19 = r18.getParentFile();     // Catch: Throwable -> L67 Exception -> L69
        if (r19 == null) goto L41;
        r19.mkdirs();     // Catch: Throwable -> L67 Exception -> L69
    L41:
        FilesKt.copyTo$default(r20, r18, true, 0, 4, null);     // Catch: Throwable -> L67 Exception -> L69
        if (r18.exists() == true) goto L44;
    L53:
        r17.e("VideoPackProcessor", "Failed to copy extracted video to output path");     // Catch: Throwable -> L67 Exception -> L69
    L58:
        e = e;
        r12 = FLogger.a;
        r15 = new StringBuilder("Failed to cleanup temp unpack directory: ");
        goto L83
    L55:
        if (r6.exists() == false) goto L136;
        FilesKt.deleteRecursively(r6);     // Catch: Exception -> L58
        r17.d("VideoPackProcessor", "Cleaned up temp unpack directory: " + r6.getAbsolutePath());     // Catch: Exception -> L58
        goto L136
    L44:
        if (r18.length() <= 0) goto L53;
        r17.i("VideoPackProcessor", "Successfully extracted raw video (fallback): " + r27 + " (" + r18.length() + " bytes)");     // Catch: Throwable -> L67 Exception -> L69
    L50:
        e = move-exception;
        FLogger.a.w("VideoPackProcessor", "Failed to cleanup temp unpack directory: " + e.getMessage());
    L52:
        r16 = true;
        goto L114
    L47:
        if (r6.exists() == false) goto L52;
        FilesKt.deleteRecursively(r6);     // Catch: Exception -> L50
        r17.d("VideoPackProcessor", "Cleaned up temp unpack directory: " + r6.getAbsolutePath());     // Catch: Exception -> L50
    L25:
        r14 = false;
    L29:
        r20 = null;
    L60:
        th = move-exception;
        throw th;     // Catch: Throwable -> L63
    L63:
        th = move-exception;
        CloseableKt.closeFinally(r4, th);     // Catch: Throwable -> L67 Exception -> L69
        throw th;     // Catch: Throwable -> L67 Exception -> L69
    L69:
        e = e;
        File r21 = r6;
    L145:
        FLogger r22 = FLogger.a;     // Catch: Throwable -> L85
        r22.e("VideoPackProcessor", "Failed to extract raw video from pack (fallback): " + e.getMessage(), e);     // Catch: Throwable -> L85
        if (r21 == null) goto L84;
    L81:
        e = e;
        r12 = FLogger.a;
        r15 = new StringBuilder("Failed to cleanup temp unpack directory: ");
        goto L83
    L78:
        if (r21.exists() == false) goto L84;
        FilesKt.deleteRecursively(r21);     // Catch: Exception -> L81
        r22.d("VideoPackProcessor", "Cleaned up temp unpack directory: " + r21.getAbsolutePath());     // Catch: Exception -> L81
    L85:
        th = th;
    L86:
        Throwable r3 = th;
    L87:
        if (r21 == null) goto L150;
    L92:
        e = move-exception;
        FLogger.a.w("VideoPackProcessor", "Failed to cleanup temp unpack directory: " + e.getMessage());
        throw r3;
    L89:
        if (r21.exists() == false) goto L151;
        FilesKt.deleteRecursively(r21);     // Catch: Exception -> L92
        FLogger.a.d("VideoPackProcessor", "Cleaned up temp unpack directory: " + r21.getAbsolutePath());     // Catch: Exception -> L92
        throw r3;
    L151:
        throw r3;
    L150:
        throw r3;
    L67:
        th = move-exception;
        r3 = th;
        r21 = r6;
        goto L87
    L143:
        r10.e("VideoPackProcessor", "Pack file not found: " + r26);     // Catch: Throwable -> L9 Exception -> L73
    L9:
        th = move-exception;
        r3 = th;
        r21 = null;
    L71:
        th = th;
        r21 = null;
    L73:
        e = e;
        r21 = null;
        goto L145
    L95:
        boolean r23 = true;
        FLogger r24 = FLogger.a;
        r24.w("VideoPackProcessor", "Attempting fallback: copying input mp4 without stabilization");
        PolarisFileWrapper r110 = new PolarisFileWrapper(r26);     // Catch: Exception -> L112
        if (r110.exists() == true) goto L99;
        r24.e("VideoPackProcessor", "Source video not found: " + r26);     // Catch: Exception -> L112
        goto L84
    L99:
        PolarisFileWrapper r111 = new PolarisFileWrapper(r27);     // Catch: Exception -> L112
        File r112 = r111.getParentFile();     // Catch: Exception -> L112
        if (r112 == null) goto L102;
        r112.mkdirs();     // Catch: Exception -> L112
    L102:
        FilesKt.copyTo$default(r110, r111, true, 0, 4, null);     // Catch: Exception -> L112
        if (r111.exists() == true) goto L105;
    L107:
        r23 = false;
    L108:
        if (r23 == false) goto L110;
        r24.i("VideoPackProcessor", "Copied raw video to fallback output: " + r27 + " (" + r111.length() + " bytes)");     // Catch: Exception -> L112
    L111:
        r16 = r23;
        goto L114
    L110:
        r24.e("VideoPackProcessor", "Failed to copy raw video to fallback output: " + r27);     // Catch: Exception -> L112
        goto L111
    L105:
        if (r111.length() <= 0) goto L107;
    L112:
        e = move-exception;
        FLogger.a.e("VideoPackProcessor", "Failed to copy raw video: " + e.getMessage(), e);
        goto L84
    }
}
