package com.larus.avlink.gallery.gecko;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.common.apphost.AppHost;
import com.larus.ivykit.forest.IFlowForestService;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.io.File;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.i;
import kotlinx.coroutines.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class MorphoGeckoFileHelper {
    public static final MorphoGeckoFileHelper a = null;
    public static final CoroutineScope b = null;
    public static final AtomicBoolean c = null;

    public static final class a implements Function2<Boolean, String, Unit> {
        public final /* synthetic */ MorphoGeckoFileHelper a;
        public final /* synthetic */ i<String> b;
        public final /* synthetic */ IFlowForestService c;
        public final /* synthetic */ String d;

        public a(MorphoGeckoFileHelper r1, j r2, IFlowForestService r3, String r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        public final Object invoke(Object r4, Object r5) {
            boolean r6 = ((Boolean) r4).booleanValue();
            String r7 = (String) r5;
            Intrinsics.checkNotNullParameter(r7, "errorMessage");
            this.a.getClass();
            MorphoGeckoFileHelper.h("[download] downloadResAsync: success=" + r6 + ", message=" + r7);
            if (this.b.isActive() == false) goto L6;
            this.c.c(this.d, new com.larus.avlink.gallery.gecko.a(this.a, this.b));
        L6:
            return Unit.INSTANCE;
        }
    }

    public MorphoGeckoFileHelper() {
    }

    static {
        a = new MorphoGeckoFileHelper();
        b = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO()));
        c = new AtomicBoolean(false);
    }

    public static PolarisFileWrapper e() {
        return new PolarisFileWrapper(new PolarisFileWrapper(AppHost.a.getApplication().getFilesDir(), "morpho_plugin"), "facev2.bin");
    }

    public static void d() {
        PolarisFileWrapper r0 = e();
        h("[ensure] checking model: path=" + r0.getAbsolutePath());
        if (f(r0) == false) goto L7;
        h("[ensure] model ready: size=" + r0.length());
        return;
    L7:
        if (c.compareAndSet(false, true) == false) goto L9;
        h("[ensure] model unavailable, starting background download");
        BuildersKt.launch$default(b, null, null, new MorphoGeckoFileHelper$startDownloadIfNeeded$1(null), 3, null);
        return;
    L9:
        h("[ensure] model download already in progress");
    }

    public static void b(PolarisFileWrapper r2) {
        if (r2.exists() == true) goto L5;
    L8:
        boolean r0 = true;
    L9:
        if (r0 == false) goto L12;
        return;
    L12:
        throw new IllegalStateException(("Failed to delete file: " + r2.getAbsolutePath()).toString());
    L5:
        if (r2.delete() == true) goto L8;
        r0 = false;
        goto L9
    }

    public static boolean f(File r6) {
        if (r6 != null) goto L5;
    L7:
        boolean r2 = false;
    L8:
        if (r2 == true) goto L10;
        return false;
    L10:
        if (r6.length() <= 0) goto L14;
        return true;
    L14:
        return false;
    L5:
        if (r6.isFile() != true) goto L7;
        r2 = true;
        goto L8
    }

    public static void h(String r2) {
        FLogger.a.i("MorphoGeckoFileHelper", r2);
    }

    public static File k(PolarisFileWrapper r3) {
        File r0 = r3.getParentFile();
        if (r0 == null) goto L16;
        if (r0.exists() == false) goto L7;
    L10:
        boolean r4 = true;
    L11:
        if (r4 == false) goto L14;
        return r0;
    L14:
        throw new IllegalStateException(("Failed to create target directory: " + r0.getAbsolutePath()).toString());
    L7:
        if (r0.mkdirs() == true) goto L10;
        r4 = false;
        goto L11
    L16:
        throw new IllegalStateException(("Target parent is missing: " + r3.getAbsolutePath()).toString());
    }

    public static void l(PolarisFileWrapper r2) {
        if (f(r2) == false) goto L6;
        return;
    L6:
        throw new IllegalStateException(("File is missing or empty: " + r2.getAbsolutePath()).toString());
    }

    public final Object c(Continuation<? super Unit> r14) {
        if ((r14 instanceof MorphoGeckoFileHelper$downloadAndInstallFaceSrModel$1) == false) goto L7;
        MorphoGeckoFileHelper$downloadAndInstallFaceSrModel$1 r0 = (MorphoGeckoFileHelper$downloadAndInstallFaceSrModel$1) r14;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r15 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        boolean r4 = true;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r15);
    L21:
        File r16 = (File) r15;
        if (r16 != null) goto L25;
        h("[install] stopped, Gecko resource unavailable");
        return Unit.INSTANCE;
    L25:
        Object r5 = null;
        File r6 = null;
        r6 = null;
        r6 = null;
        if (r16.isDirectory() == false) goto L41;
        Iterator r7 = FilesKt.walkTopDown(r16).iterator();
    L29:
        if (r7.hasNext() == false) goto L38;
        Object r8 = r7.next();
        File r9 = (File) r8;
        a.getClass();
        if (Intrinsics.areEqual(r9.getName(), "facev2.bin") == true) goto L33;
    L35:
        boolean r10 = false;
    L36:
        if (r10 == false) goto L29;
    L39:
        File r11 = (File) r8;
    L49:
        if (r11 == null) goto L51;
        h("[install] using Gecko model: path=" + r11.getAbsolutePath());
        File r12 = e();
        if (f(r11) == true) goto L109;
        h("[install] source file invalid: path=" + r11.getAbsolutePath());
    L103:
        if (f(r6) == false) goto L105;
        String r17 = "[install] success";
    L106:
        h(r17);
        return Unit.INSTANCE;
    L105:
        r17 = "[install] failed";
        goto L106
    L109:
        Result.Companion r13 = Result.Companion;     // Catch: Throwable -> L89
        File r18 = k(r12);     // Catch: Throwable -> L89
        PolarisFileWrapper r19 = new PolarisFileWrapper(r18, "." + r12.getName() + ".tmp");     // Catch: Throwable -> L89
        PolarisFileWrapper r110 = new PolarisFileWrapper(r18, "." + r12.getName() + ".backup");     // Catch: Throwable -> L89
        b(r19);     // Catch: Throwable -> L89
        b(r110);     // Catch: Throwable -> L89
        FilesKt.copyTo$default(r11, r19, true, 0, 4, null);     // Catch: Throwable -> L82
        l(r19);     // Catch: Throwable -> L82
        boolean r20 = r12.exists();     // Catch: Throwable -> L82
        if (r20 == false) goto L67;
        if (r12.renameTo(r110) == true) goto L67;
        throw new IllegalStateException(("Failed to back up target file: " + r12.getAbsolutePath()).toString());     // Catch: Throwable -> L82
    L67:
        if (r19.renameTo(r12) == true) goto L75;
        if (r20 == false) goto L74;
        if (r110.renameTo(r12) == true) goto L74;
        throw new IllegalStateException(("Failed to restore target file: " + r12.getAbsolutePath()).toString());     // Catch: Throwable -> L82
    L74:
        throw new IllegalStateException(("Failed to move temp file to target: " + r12.getAbsolutePath()).toString());     // Catch: Throwable -> L82
    L75:
        b(r110);     // Catch: Throwable -> L82
        b(r19);     // Catch: Throwable -> L89
        if (r12.exists() == false) goto L79;
    L81:
        l(r12);     // Catch: Throwable -> L89
        Object r111 = Result.constructor-impl(r12);     // Catch: Throwable -> L89
    L92:
        if (Result.isSuccess-impl(r111) == false) goto L94;
        File r21 = (File) r111;
        MorphoGeckoFileHelper r22 = a;
        String r23 = "[install] model copied: path=" + r12.getAbsolutePath() + ", size=" + r12.length();
        r22.getClass();
        h(r23);
    L94:
        Throwable r24 = Result.exceptionOrNull-impl(r111);
        if (r24 == null) goto L98;
        MorphoGeckoFileHelper r25 = a;
        String r26 = "[install] failed to copy model: target=" + r12.getAbsolutePath();
        r25.getClass();
        g(r26, r24);
    L98:
        if (Result.isFailure-impl(r111) == true) goto L101;
        r5 = r111;
    L101:
        r6 = (File) r5;
        goto L103
    L79:
        if (r110.exists() == false) goto L81;
        r110.renameTo(r12);     // Catch: Throwable -> L89
    L82:
        th = move-exception;
        b(r19);     // Catch: Throwable -> L89
        if (r12.exists() == false) goto L86;
    L88:
        throw th;     // Catch: Throwable -> L89
    L86:
        if (r110.exists() == false) goto L88;
        r110.renameTo(r12);     // Catch: Throwable -> L89
    L89:
        th = move-exception;
        Result.Companion r27 = Result.Companion;
        r111 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L92
    L51:
        if (r16.isDirectory() == false) goto L53;
        h("[install] facev2.bin missing: directory=" + r16.getAbsolutePath());
        goto L103
    L53:
        h("[install] Gecko resource is not target model: path=" + r16.getAbsolutePath());
        goto L103
    L33:
        if (f(r9) == false) goto L35;
        r10 = true;
        goto L36
    L38:
        r8 = null;
        goto L39
    L41:
        if (Intrinsics.areEqual(r16.getName(), "facev2.bin") == true) goto L43;
    L45:
        r4 = false;
    L46:
        if (r4 == false) goto L48;
        r11 = r16;
        goto L49
    L48:
        r11 = null;
        goto L49
    L43:
        if (f(r16) == false) goto L45;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r15);
        PolarisFileWrapper r112 = e();
        h("[install] start: model=facev2.bin");
        if (f(r112) == false) goto L18;
        h("[install] skipped, model already ready: path=" + r112.getAbsolutePath());
        return Unit.INSTANCE;
    L18:
        r0.label = 1;
        r15 = j(r0);
        if (r15 != r2) goto L21;
        return r2;
    L7:
        r0 = new MorphoGeckoFileHelper$downloadAndInstallFaceSrModel$1(this, r14);
        goto L8
    }

    public final Object j(Continuation<? super File> r5) {
        if ((r5 instanceof MorphoGeckoFileHelper$queryLocalFaceSrModelFromGecko$1) == false) goto L7;
        MorphoGeckoFileHelper$queryLocalFaceSrModelFromGecko$1 r0 = (MorphoGeckoFileHelper$queryLocalFaceSrModelFromGecko$1) r5;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r6 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r6);
    L17:
        File r7 = (File) r6;
        StringBuilder r4 = new StringBuilder("[download] Gecko resource ready: path=");
        if (r7 == null) goto L20;
        String r8 = r7.getAbsolutePath();
    L21:
        r4.append(r8);
        h(r4.toString());
        return r7;
    L20:
        r8 = null;
        goto L21
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r6);
        r0.label = 1;
        r6 = i("local", "facev2.bin", r0);
        if (r6 != r2) goto L17;
        return r2;
    L7:
        r0 = new MorphoGeckoFileHelper$queryLocalFaceSrModelFromGecko$1(this, r5);
        goto L8
    }

    public static final Object a(MorphoGeckoFileHelper r5, Continuation r6) {
        r5.getClass();
        if ((r6 instanceof MorphoGeckoFileHelper$downloadAndInstallFaceSrModelSafely$1) == false) goto L7;
        MorphoGeckoFileHelper$downloadAndInstallFaceSrModelSafely$1 r0 = (MorphoGeckoFileHelper$downloadAndInstallFaceSrModelSafely$1) r6;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r7 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L15;
        if (r3 != 1) goto L14;
        ResultKt.throwOnFailure(r7);     // Catch: Throwable -> L19
    L26:
    L21:
        c.set(false);
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r7);
        r0.label = 1;     // Catch: Throwable -> L19
        if (r5.c(r0) != r2) goto L26;
        return r2;
    L19:
        th = move-exception;
        g("[install] unexpected failure", th);     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        c.set(false);
        throw th;
    L7:
        r0 = new MorphoGeckoFileHelper$downloadAndInstallFaceSrModelSafely$1(r5, r6);
        goto L8
    }

    public static void g(String r2, Throwable r3) {
        FLogger.a.e("MorphoGeckoFileHelper", r2 + ", error=" + r3.getMessage(), r3);
    }

    public final Object i(String r10, String r11, Continuation<? super File> r12) {
        if ((r12 instanceof MorphoGeckoFileHelper$queryGeckoFile$1) == false) goto L7;
        MorphoGeckoFileHelper$queryGeckoFile$1 r0 = (MorphoGeckoFileHelper$queryGeckoFile$1) r12;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r13 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        String r4 = "";
        if (r3 == 0) goto L16;
        if (r3 != 1) goto L15;
        MorphoGeckoFileHelper$queryGeckoFile$1 r14 = (MorphoGeckoFileHelper$queryGeckoFile$1) r0.L$3;
        MorphoGeckoFileHelper r15 = (MorphoGeckoFileHelper) r0.L$2;
        String r16 = (String) r0.L$1;
        r10 = (String) r0.L$0;
        ResultKt.throwOnFailure(r13);     // Catch: Throwable -> L28
    L26:
        Object r17 = Result.constructor-impl((String) r13);     // Catch: Throwable -> L28
    L30:
        Throwable r18 = Result.exceptionOrNull-impl(r17);
        if (r18 == null) goto L33;
        a.getClass();
        g("[download] Gecko " + r10 + " query failed", r18);
    L33:
        PolarisFileWrapper r5 = null;
        if (Result.isFailure-impl(r17) == false) goto L36;
        r17 = null;
    L36:
        String r19 = (String) r17;
        if (r19 == null) goto L40;
        r4 = r19;
    L40:
        h("[download] Gecko path=".concat(r4));
        if ((!StringsKt.isBlank(r4)) == false) goto L43;
        String r110 = r4;
    L44:
        if (r110 == null) goto L55;
        PolarisFileWrapper r111 = new PolarisFileWrapper(r110);
        if (r111.isDirectory() == true) goto L51;
        a.getClass();
        if (f(r111) == true) goto L51;
        boolean r112 = false;
    L52:
        if (r112 == false) goto L55;
        r5 = r111;
    L51:
        r112 = true;
    L55:
        if ((!StringsKt.isBlank(r4)) == false) goto L58;
        if (r5 != null) goto L58;
        h("[download] Gecko " + r10 + " path invalid: path=" + r4);
    L58:
        return r5;
    L43:
        r110 = null;
        goto L44
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r13);
        Result.Companion r113 = Result.Companion;     // Catch: Throwable -> L28
        r0.L$0 = r10;     // Catch: Throwable -> L28
        r0.L$1 = r11;     // Catch: Throwable -> L28
        r0.L$2 = this;     // Catch: Throwable -> L28
        r0.L$3 = r0;     // Catch: Throwable -> L28
        r0.label = 1;     // Catch: Throwable -> L28
        j r114 = new j(IntrinsicsKt.intercepted(r0), 1);     // Catch: Throwable -> L28
        r114.C();     // Catch: Throwable -> L28
        IFlowForestService r6 = (IFlowForestService) ServiceManager.get().getService(IFlowForestService.class);     // Catch: Throwable -> L28
        if (r6 != null) goto L20;
        h("[download] Gecko " + r10 + " query failed: IFlowForestService unavailable");     // Catch: Throwable -> L28
        r114.resumeWith(Result.constructor-impl(""));     // Catch: Throwable -> L28
    L21:
        r13 = r114.B();     // Catch: Throwable -> L28
        if (r13 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L24;
        DebugProbesKt.probeCoroutineSuspended(r0);     // Catch: Throwable -> L28
    L24:
        if (r13 != r2) goto L26;
        return r2;
    L20:
        r6.e("FlowGeckoResDownloadAsync", CollectionsKt.listOf("com_flow_dora_g2_facesr"), 3, new a(this, r114, r6, r11));     // Catch: Throwable -> L28
    L28:
        th = move-exception;
        Result.Companion r115 = Result.Companion;
        r17 = Result.constructor-impl(ResultKt.createFailure(th));
    L7:
        r0 = new MorphoGeckoFileHelper$queryGeckoFile$1(this, r12);
        goto L8
    }
}
