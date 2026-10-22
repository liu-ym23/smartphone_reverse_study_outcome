package com.larus.avlink.gallery.executor;

import android.media.ExifInterface;
import android.os.Build;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.avlink.gallery.business.MediaLifecycleStateManager;
import com.larus.avlink.gallery.database.AlbumDataBaseHelper;
import com.larus.avlink.gallery.model.MediaMetadata;
import com.larus.platform.model.GeoLocationInfo;
import com.larus.utils.logger.FLogger;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Locale;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class MediaProcessingExecutor {
    public static final /* synthetic */ int k = 0;
    public final CoroutineScope a;
    public final MediaLifecycleStateManager b;
    public Channel<b> c;
    public Channel<b> d;
    public final Set<String> e;
    public final Set<String> f;
    public final AtomicBoolean g;
    public final AtomicInteger h;
    public Job i;
    public Job j;

    public static final class a {
    }

    public static final class b {
        public final String a;
        public final boolean b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r0 = this.a.hashCode() * 31;
            if (this.b == false) goto L5;
            int r1 = 1231;
        L7:
            return r0 + r1;
        L5:
            r1 = 1237;
            goto L7
        }

        public final String toString() {
            return "ProcessingTask(uniqId=" + this.a + ", isRecovery=" + this.b + ')';
        }

        public final String a() {
            return this.a;
        }

        public final boolean b() {
            return this.b;
        }

        public b(String r2, boolean r3) {
            Intrinsics.checkNotNullParameter(r2, "uniqId");
            this.a = r2;
            this.b = r3;
        }
    }

    static {
    }

    public final void g() {
        if (this.g.compareAndSet(false, true) == true) goto L6;
        FLogger.a.w("MediaProcessingExecutor", "Processing queue already running, skipping start");
        return;
    L6:
        FLogger r0 = FLogger.a;
        r0.i("MediaProcessingExecutor", "Starting processing queue");
        if (this.c != null) goto L10;
        this.c = ChannelKt.Channel$default(Integer.MAX_VALUE, null, null, 6, null);
    L10:
        if (this.d != null) goto L12;
        this.d = ChannelKt.Channel$default(Integer.MAX_VALUE, null, null, 6, null);
    L12:
        Job r3 = this.i;
        if (r3 == null) goto L15;
        Job.DefaultImpls.cancel$default(r3, null, 1, null);
    L15:
        this.i = BuildersKt.launch$default(this.a, null, null, new MediaProcessingExecutor$startImageProcessingWorker$1(this, null), 3, null);
        Job r4 = this.j;
        if (r4 == null) goto L18;
        Job.DefaultImpls.cancel$default(r4, null, 1, null);
    L18:
        this.j = BuildersKt.launch$default(this.a, null, null, new MediaProcessingExecutor$startVideoProcessingWorker$1(this, null), 3, null);
        r0.i("MediaProcessingExecutor", "Processing queue started");
    }

    public MediaProcessingExecutor(CoroutineScope r2) {
        Intrinsics.checkNotNullParameter(r2, "scope");
        this.a = r2;
        this.b = MediaLifecycleStateManager.b.a();
        this.e = new LinkedHashSet();
        this.f = new LinkedHashSet();
        this.g = new AtomicBoolean(false);
        this.h = new AtomicInteger(0);
        g();
    }

    public static String c(long r4) {
        int r5 = TimeZone.getDefault().getOffset(r4) / 60000;
        if (r5 < 0) goto L5;
        String r6 = "+";
    L6:
        if (r5 >= 0) goto L9;
        r5 = -r5;
    L9:
        StringCompanionObject r0 = StringCompanionObject.INSTANCE;
        return String.format(Locale.US, "%s%02d:%02d", Arrays.copyOf(new Object[]{r6, Integer.valueOf(r5 / 60), Integer.valueOf(r5 % 60)}, 3));
    L5:
        r6 = "-";
        goto L6
    }

    public static boolean d(PolarisFileWrapper r11, PolarisFileWrapper r12) {
        if (r11.exists() == true) goto L6;
        FLogger.a.e("MediaProcessingExecutor", "Processed source file does not exist: " + r11.getAbsolutePath());
        return false;
    L6:
        File r1 = r12.getParentFile();
        if (r1 == null) goto L10;
        r1.mkdirs();
    L10:
        if (r12.exists() == false) goto L16;
        if (r12.delete() == true) goto L16;
        FLogger.a.e("MediaProcessingExecutor", "Failed to delete existing processed target: " + r12.getAbsolutePath());
        return false;
    L16:
        if (r11.renameTo(r12) == false) goto L26;
        return true;
    L26:
        FilesKt.copyTo$default(r11, r12, true, 0, 4, null);     // Catch: Exception -> L23
        if (r11.delete() == true) goto L22;
        FLogger.a.w("MediaProcessingExecutor", "Failed to delete source file after copy: " + r11.getAbsolutePath());     // Catch: Exception -> L23
    L22:
        return true;
    L23:
        e = move-exception;
        FLogger.a.e("MediaProcessingExecutor", "Failed to move processed file from " + r11.getAbsolutePath() + " to " + r12.getAbsolutePath() + ": " + e.getMessage(), e);
        return false;
    }

    public final void a(String r8, boolean r9) {
        Intrinsics.checkNotNullParameter(r8, "uniqId");
        BuildersKt.launch$default(this.a, null, null, new MediaProcessingExecutor$enqueueTask$1(r8, this, r9, null), 3, null);
    }

    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached with updateSeq = 32021. Try increasing type updates limit count.
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:79)
        */
    public final java.lang.Object b(com.larus.avlink.gallery.executor.MediaProcessingExecutor.b r52, kotlin.coroutines.Continuation<? super kotlin.Unit> r53) {
        /*  JADX ERROR: Simple mode code generation failed
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0004: CONST_STR (r3v0 ?? I:java.lang.String) = "[" A[DECLARE_VAR] (LINE:33554436) in method: com.larus.avlink.gallery.executor.MediaProcessingExecutor.b(com.larus.avlink.gallery.executor.MediaProcessingExecutor$b, kotlin.coroutines.Continuation<? super kotlin.Unit>):java.lang.Object, file: /private/tmp/nixiang/classes25.dex
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
            Method dump skipped, instruction units count: 3202
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.larus.avlink.gallery.executor.MediaProcessingExecutor.b(com.larus.avlink.gallery.executor.MediaProcessingExecutor$b, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Object h(String r10, Continuation<? super Unit> r11) {
        if ((r11 instanceof MediaProcessingExecutor$triggerMediaSync$1) == false) goto L7;
        MediaProcessingExecutor$triggerMediaSync$1 r3 = (MediaProcessingExecutor$triggerMediaSync$1) r11;
        int r4 = r3.label;
        if ((r4 & Integer.MIN_VALUE) == 0) goto L7;
        r3.label = r4 - Integer.MIN_VALUE;
    L8:
        Object r12 = r3.result;
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r6 = r3.label;
        if (r6 == 0) goto L20;
        if (r6 == 1) goto L17;
        if (r6 != 2) goto L16;
        r10 = (String) r3.L$0;
        ResultKt.throwOnFailure(r12);     // Catch: Exception -> L32
    L29:
        FLogger.a.i("MediaProcessingExecutor", "Sync completed for media: " + r10);     // Catch: Exception -> L32
    L35:
        return Unit.INSTANCE;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        r10 = (String) r3.L$0;
        ResultKt.throwOnFailure(r12);     // Catch: Exception -> L32
    L24:
        MediaMetadata r13 = (MediaMetadata) r12;     // Catch: Exception -> L32
        if (r13 == null) goto L30;
        FLogger.a.i("MediaProcessingExecutor", "Auto-syncing media to system album: " + r10);     // Catch: Exception -> L32
        MediaSyncExecutor r0 = MediaSyncExecutor.a;     // Catch: Exception -> L32
        r3.L$0 = r10;     // Catch: Exception -> L32
        r3.label = 2;     // Catch: Exception -> L32
        if (r0.f(r13, r3) != r5) goto L29;
        return r5;
    L30:
        FLogger.a.w("MediaProcessingExecutor", "Skip sync due to updatedMetadata is null: " + r10);     // Catch: Exception -> L32
        goto L35
    L20:
        ResultKt.throwOnFailure(r12);
        AlbumDataBaseHelper r14 = AlbumDataBaseHelper.a;     // Catch: Exception -> L32
        r3.L$0 = r10;     // Catch: Exception -> L32
        r3.label = 1;     // Catch: Exception -> L32
        r12 = r14.o(r10, r3);     // Catch: Exception -> L32
        if (r12 != r5) goto L24;
        return r5;
    L32:
        e = move-exception;
        FLogger.a.e("MediaProcessingExecutor", "Error auto-syncing media " + r10 + ": " + e.getMessage(), e);
    L7:
        r3 = new MediaProcessingExecutor$triggerMediaSync$1(this, r11);
        goto L8
    }

    public static String e(MediaMetadata r12, String r13, String r14) {
        String r0 = r12.getDownloadFilePath();
        File r1 = null;
        if (r0 == null) goto L5;
        PolarisFileWrapper r2 = new PolarisFileWrapper(r0);
    L7:
        if (r2 != null) goto L9;
    L25:
        File r3 = new PolarisFileWrapper(r12.getFilePath()).getParentFile();
        if (r3 == null) goto L40;
        File[] r4 = r3.listFiles();
        if (r4 == null) goto L40;
        int r5 = r4.length;
        int r7 = 0;
    L30:
        if (r7 >= r5) goto L40;
        File r8 = r4[r7];
        if (StringsKt.contains$default(r8.getName(), "_" + r14 + '_', false, 2, null) == true) goto L34;
    L36:
        boolean r9 = false;
    L37:
        if (r9 == true) goto L38;
        r7 = r7 + 1;
        goto L30
    L38:
        r1 = r8;
        goto L40
    L34:
        if (StringsKt.endsWith(r8.getName(), ".pack", true) == false) goto L36;
        r9 = true;
    L40:
        if (r1 != null) goto L42;
    L45:
        FLogger.a.w("MediaProcessingExecutor", "[" + r13 + "] Pack file not found, using metadata.filePath");
        return r12.getFilePath();
    L42:
        if (r1.exists() == false) goto L45;
        FLogger.a.d("MediaProcessingExecutor", "[" + r13 + "] Found fallback pack file: " + r1.getAbsolutePath());
        return r1.getAbsolutePath();
    L9:
        if (r2.exists() == false) goto L25;
        if (StringsKt.endsWith(r2.getName(), ".zip", true) == false) goto L23;
        String r15 = r12.getUnpackDirPath();
        if (r15 == null) goto L18;
        PolarisFileWrapper r6 = new PolarisFileWrapper(r15);
        if (r6.exists() == false) goto L18;
        int r16 = com.larus.avlink.gallery.processor.e.a;
        r1 = com.larus.avlink.gallery.processor.e.a.b(r6);
    L18:
        if (r1 == null) goto L21;
        FLogger.a.d("MediaProcessingExecutor", "[" + r13 + "] Found live photo inner pack file: " + r1.getAbsolutePath());
        return r1.getAbsolutePath();
    L21:
        FLogger.a.w("MediaProcessingExecutor", "[" + r13 + "] Live photo inner pack file not found, using metadata.filePath");
        return r12.getFilePath();
    L23:
        FLogger.a.d("MediaProcessingExecutor", "[" + r13 + "] Found pack file: " + r0);
        return r0;
    L5:
        r2 = null;
        goto L7
    }

    public static void f(File r9, long r10, MediaMetadata r12) {
        int r2 = Build.VERSION.SDK_INT;     // Catch: Exception -> L25
        if (r2 >= 24) goto L6;
        return;
    L6:
        ExifInterface r4 = new ExifInterface(r9.getAbsolutePath());     // Catch: Exception -> L25
        long r11 = r10 * ((long) 1000);     // Catch: Exception -> L25
        String r5 = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss", Locale.ROOT).format(new Date(r11));     // Catch: Exception -> L25
        r4.setAttribute("DateTime", r5);     // Catch: Exception -> L25
        if (r2 < 24) goto L10;
        r4.setAttribute("DateTimeOriginal", r5);     // Catch: Exception -> L25
        r4.setAttribute("DateTimeDigitized", r5);     // Catch: Exception -> L25
    L10:
        if (r2 < 30) goto L12;
        String r13 = c(r11);     // Catch: Exception -> L25
        r4.setAttribute("OffsetTime", r13);     // Catch: Exception -> L25
        r4.setAttribute("OffsetTimeOriginal", r13);     // Catch: Exception -> L25
        r4.setAttribute("OffsetTimeDigitized", r13);     // Catch: Exception -> L25
    L12:
        GeoLocationInfo r14 = r12.getGeoLocationInfo();     // Catch: Exception -> L25
        if (r14 == null) goto L23;
        double r15 = r14.getLatitude();     // Catch: Exception -> L25
        double r3 = r14.getLongitude();     // Catch: Exception -> L25
        if (r15 < 0.0d) goto L17;
        String r8 = "N";
    L18:
        r4.setAttribute("GPSLatitudeRef", r8);     // Catch: Exception -> L25
        if (r3 < 0.0d) goto L21;
        String r6 = "E";
    L22:
        r4.setAttribute("GPSLongitudeRef", r6);     // Catch: Exception -> L25
        r4.setAttribute("GPSLatitude", com.larus.avlink.gallery.c.c(r15));     // Catch: Exception -> L25
        r4.setAttribute("GPSLongitude", com.larus.avlink.gallery.c.c(r3));     // Catch: Exception -> L25
        goto L23
    L21:
        r6 = "W";
        goto L22
    L17:
        r8 = "S";
    L23:
        r4.saveAttributes();     // Catch: Exception -> L25
        FLogger.a.d("MediaProcessingExecutor", "Successfully set EXIF date for " + r9.getName() + " to: " + r5);     // Catch: Exception -> L25
        return;
    L25:
        e = move-exception;
        FLogger.a.e("MediaProcessingExecutor", "Failed to set EXIF date for " + r9.getName() + ": " + e.getMessage(), e);
    }
}
