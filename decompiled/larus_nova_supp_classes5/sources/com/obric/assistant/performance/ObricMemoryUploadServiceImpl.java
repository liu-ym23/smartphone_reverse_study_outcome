package com.obric.assistant.performance;

import android.app.Application;
import android.os.Debug;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.applog.api.IApplog;
import com.larus.common.apphost.AppHost;
import com.larus.common.mssdk.api.ISecPrivacyService;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.ObricThresholdItemConfig;
import com.obric.assistant.ObricThresholdPssUploadFilesConfig;
import com.obric.assistant.t1;
import java.io.BufferedOutputStream;
import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0003\b\u0007\u0018\u0000 !2\u00020\u0001:\u0001!B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\tH\u0002J\b\u0010\r\u001a\u00020\tH\u0002J\u0010\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\n\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0002J\u001e\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0015H\u0082@¢\u0006\u0002\u0010\u0016J\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0014\u001a\u00020\u0015H\u0082@¢\u0006\u0002\u0010\u0018J\u0018\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0010\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u0012H\u0002J\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0014\u001a\u00020\u0015H\u0082@¢\u0006\u0002\u0010\u0018J\u0010\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\b\u0010 \u001a\u00020\u0012H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/obric/assistant/performance/ObricMemoryUploadServiceImpl;", "Lcom/obric/assistant/performance/IObricMemoryUploadService;", "<init>", "()V", "scope", "Lkotlinx/coroutines/CoroutineScope;", "uploadMemoryInfoRetryCount", "", "isUploadingMemoryInfo", "", "init", "", "shouldUploadMemoryInfo", "isPrivacyAgreed", "retryUploadPendingFile", "did", "", "findPendingMemoryInfoFile", "Ljava/io/File;", "uploadMemoryInfoFilesOnce", "config", "Lcom/obric/assistant/ObricThresholdItemConfig;", "(Ljava/lang/String;Lcom/obric/assistant/ObricThresholdItemConfig;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "prepareUploadFile", "(Lcom/obric/assistant/ObricThresholdItemConfig;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "uploadFileOnce", "file", "cleanupUploadFile", "mergeUploadMemoryFiles", "buildMemoryUploadFile", "timestamp", "", "resolveMemoryUploadDir", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricMemoryUploadServiceImpl implements IObricMemoryUploadService {
    public static final /* synthetic */ int e = 0;
    public final CoroutineScope b;
    public volatile int c;
    public volatile boolean d;

    /* JADX INFO: renamed from: com.obric.assistant.performance.ObricMemoryUploadServiceImpl$init$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.assistant.performance.ObricMemoryUploadServiceImpl$init$1", f = "ObricMemoryUploadServiceImpl.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2}, l = {73, 79, 93}, m = "invokeSuspend", n = {"$this$launch", "processConfig", "customDid", "thresholdPssKb", "checkIntervalMs", "$this$launch", "processConfig", "customDid", "thresholdPssKb", "checkIntervalMs", "$this$launch", "processConfig", "customDid", "thresholdPssKb", "checkIntervalMs"}, s = {"L$0", "L$1", "L$2", "F$0", "J$0", "L$0", "L$1", "L$2", "F$0", "J$0", "L$0", "L$1", "L$2", "F$0", "J$0"})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        float F$0;
        long J$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        int label;
        final /* synthetic */ ObricMemoryUploadServiceImpl this$0;

        public AnonymousClass1(ObricMemoryUploadServiceImpl r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            AnonymousClass1 r0 = new AnonymousClass1(this.this$0, r4);
            r0.L$0 = r3;
            return r0;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:63:0x018e -> B:69:0x01ab). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:65:0x0194 -> B:69:0x01ab). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:67:0x01a8 -> B:69:0x01ab). Please report as a decompilation issue!!! */
        public final Object invokeSuspend(Object r21) {
            Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r4 = this.label;
            int r6 = 2;
            boolean r7 = true;
            if (r4 == 0) goto L18;
            if (r4 == 1) goto L15;
            if (r4 == 2) goto L12;
            if (r4 != 3) goto L11;
            long r9 = this.J$0;
            float r0 = this.F$0;
            String r2 = (String) this.L$2;
            ObricThresholdItemConfig r5 = (ObricThresholdItemConfig) this.L$1;
            CoroutineScope r11 = (CoroutineScope) this.L$0;
            ResultKt.throwOnFailure(r21);     // Catch: Exception -> L70
            AnonymousClass1 r12 = this;
        L69:
            r6 = 2;
            r7 = true;
        L44:
            if (CoroutineScopeKt.isActive(r11) == false) goto L73;
            r12.L$0 = r11;     // Catch: Exception -> L70
            r12.L$1 = r5;     // Catch: Exception -> L70
            r12.L$2 = r2;     // Catch: Exception -> L70
            r12.F$0 = r0;     // Catch: Exception -> L70
            r12.J$0 = r9;     // Catch: Exception -> L70
            r12.label = r6;     // Catch: Exception -> L70
            if (DelayKt.delay(r9, r12) != r3) goto L48;
            return r3;
        L48:
            ObricMemoryUploadServiceImpl r13 = r12.this$0;     // Catch: Exception -> L70
            int r14 = ObricMemoryUploadServiceImpl.e;     // Catch: Exception -> L70
            r13.getClass();     // Catch: Exception -> L70
            ISecPrivacyService.a.getClass();     // Catch: Exception -> L70
            ISecPrivacyService r15 = ISecPrivacyService.a.a();     // Catch: Exception -> L70
            boolean r16 = false;
            if (r15 != null) goto L51;
        L53:
            boolean r17 = false;
        L54:
            if (r17 == true) goto L56;
            FLogger.a.i("ObricMemoryUploadServiceImpl", "stop upload monitor, privacy switch disabled");     // Catch: Exception -> L70
            goto L73
        L56:
            int r18 = r12.this$0.c;     // Catch: Exception -> L70
            if (r18 < 0) goto L60;
            if (r18 >= 3) goto L60;
            r16 = true;
        L60:
            if (r16 == false) goto L73;
            long r19 = Debug.getPss();     // Catch: Exception -> L70
            FLogger.a.d("ObricMemoryUploadServiceImpl", "check threshold, totalPssKb=" + r19 + ", thresholdPssKb=" + r0 + ", isUploading=" + r12.this$0.d);     // Catch: Exception -> L70
            if (r19 < r0) goto L69;
            if (r12.this$0.d == true) goto L69;
            ObricMemoryUploadServiceImpl r8 = r12.this$0;     // Catch: Exception -> L70
            r12.L$0 = r11;     // Catch: Exception -> L70
            r12.L$1 = r5;     // Catch: Exception -> L70
            r12.L$2 = r2;     // Catch: Exception -> L70
            r12.F$0 = r0;     // Catch: Exception -> L70
            r12.J$0 = r9;     // Catch: Exception -> L70
            r12.label = 3;     // Catch: Exception -> L70
            if (ObricMemoryUploadServiceImpl.b(r8, r2, r5, r12) != r3) goto L69;
            return r3;
        L51:
            if (r15.h() != r7) goto L53;
            r17 = true;
        L73:
            return Unit.INSTANCE;
        L11:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L12:
            r9 = this.J$0;
            r0 = this.F$0;
            r2 = (String) this.L$2;
            r5 = (ObricThresholdItemConfig) this.L$1;
            r11 = (CoroutineScope) this.L$0;
            ResultKt.throwOnFailure(r21);     // Catch: Exception -> L70
            r12 = this;
            goto L48
        L15:
            r9 = this.J$0;
            r0 = this.F$0;
            r2 = (String) this.L$2;
            r5 = (ObricThresholdItemConfig) this.L$1;
            r11 = (CoroutineScope) this.L$0;
            ResultKt.throwOnFailure(r21);     // Catch: Exception -> L70
        L39:
            if (ObricMemoryUploadServiceImpl.a(this.this$0, r2) == true) goto L41;
            r12 = this;
            goto L44
        L41:
            return Unit.INSTANCE;
        L18:
            ResultKt.throwOnFailure(r21);
            r11 = (CoroutineScope) this.L$0;
            ObricThresholdPssUploadFilesConfig r10 = t1.a.N0();     // Catch: Exception -> L70
            Map r20 = r10.getProcessConfigs();     // Catch: Exception -> L70
            if (r20 == null) goto L23;
            ObricThresholdItemConfig r22 = (ObricThresholdItemConfig) r20.get("main");     // Catch: Exception -> L70
            if (r22 == null) goto L23;
        L24:
            float r110 = r22.getPssLimit();     // Catch: Exception -> L70
            long r111 = RangesKt.coerceAtLeast(r10.getCheckIntervalMs(), 1);     // Catch: Exception -> L70
            FLogger r112 = FLogger.a;     // Catch: Exception -> L70
            r112.i("ObricMemoryUploadServiceImpl", "start, config=" + r10);     // Catch: Exception -> L70
            if (r10.getEnableMemInfo() == true) goto L31;
            if (Intrinsics.areEqual(AppHost.a.getBuildChannel(), "auto_test") == true) goto L31;
            r112.i("ObricMemoryUploadServiceImpl", "start ignored, disable upload files");     // Catch: Exception -> L70
            return Unit.INSTANCE;
        L31:
            if (r110 >= 1024.0f) goto L34;
            r112.i("ObricMemoryUploadServiceImpl", "start ignored, invalid thresholdPssKb=" + r110);     // Catch: Exception -> L70
            return Unit.INSTANCE;
        L34:
            r2 = "4245639790640852";
            r112.i("ObricMemoryUploadServiceImpl", "start wait memory stable, delayMs=30000");     // Catch: Exception -> L70
            this.L$0 = r11;     // Catch: Exception -> L70
            this.L$1 = r22;     // Catch: Exception -> L70
            this.L$2 = "4245639790640852";     // Catch: Exception -> L70
            this.F$0 = r110;     // Catch: Exception -> L70
            this.J$0 = r111;     // Catch: Exception -> L70
            this.label = 1;     // Catch: Exception -> L70
            if (DelayKt.delay(30000, this) != r3) goto L37;
            return r3;
        L37:
            r5 = r22;
            r0 = r110;
            r9 = r111;
        L23:
            r22 = new ObricThresholdItemConfig(false, false, 0.0f, 0, 15, null);     // Catch: Exception -> L70
        L70:
            e = move-exception;
            FLogger.a.e("ObricMemoryUploadServiceImpl", "start error: " + e);
            goto L73
        }
    }

    static {
    }

    public static PolarisFileWrapper e() {
        Application r0 = AppHost.a.getApplication();
        File r1 = r0.getFilesDir();
        if (r1 != null) goto L8;
        r1 = r0.getCacheDir();
        if (r1 != null) goto L8;
        r1 = r0.getDir("obric_memory_upload", 0);
    L8:
        return new PolarisFileWrapper(r1, "obric_memory_upload");
    }

    public final void init() {
        BuildersKt.launch$default(this.b, null, null, new AnonymousClass1(this, null), 3, null);
    }

    public ObricMemoryUploadServiceImpl() {
        this.b = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO()));
    }

    public static File c() {
        File[] r0 = e().listFiles(new g());
        File r1 = null;
        if (r0 != null) goto L5;
        return null;
    L5:
        int r4 = 1;
        if (r0.length != 0) goto L8;
        boolean r2 = true;
    L9:
        if (r2 == true) goto L21;
        r1 = r0[0];
        int r3 = ArraysKt.getLastIndex(r0);
        if (r3 == 0) goto L21;
        long r5 = r1.lastModified();
        if (1 > r3) goto L21;
    L16:
        File r6 = r0[r4];
        long r7 = r6.lastModified();
        if (r5 >= r7) goto L19;
        r1 = r6;
        r5 = r7;
    L19:
        if (r4 == r3) goto L21;
        r4 = r4 + 1;
    L21:
        return r1;
    L8:
        r2 = false;
        goto L9
    }

    public static final boolean a(ObricMemoryUploadServiceImpl r6, String r7) {
        r6.getClass();
        ISecPrivacyService.a.getClass();
        ISecPrivacyService r0 = ISecPrivacyService.a.a();
        if (r0 != null) goto L5;
    L7:
        boolean r1 = false;
    L9:
        if (r1 == true) goto L11;
        FLogger.a.i("ObricMemoryUploadServiceImpl", "retryUpload stop, privacy switch disabled");
        return false;
    L11:
        File r2 = c();
        if (r2 == null) goto L25;
        FLogger r4 = FLogger.a;
        r4.i("ObricMemoryUploadServiceImpl", "retryUpload found pending file");
        if (r2.exists() == true) goto L18;
        r4.i("ObricMemoryUploadServiceImpl", "retryUpload file missing");
        return false;
    L18:
        if (r6.d == false) goto L20;
        r4.i("ObricMemoryUploadServiceImpl", "retryUpload skipped, upload in progress");
    L21:
        return true;
    L20:
        r6.d = true;
        r6.f(r2, r7);
        goto L21
    L25:
        return false;
    L5:
        if (r0.h() != true) goto L7;
        r1 = true;
        goto L9
    }

    public final Object d(ObricThresholdItemConfig r14, Continuation<? super File> r15) {
        if ((r15 instanceof mergeUploadMemoryFiles.1) == false) goto L7;
        mergeUploadMemoryFiles.1 r0 = (mergeUploadMemoryFiles.1) r15;
        int r1 = r0.label;
        if ((r1 & IntCompanionObject.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - IntCompanionObject.MIN_VALUE;
    L8:
        Object r16 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        long r4 = r0.J$0;
        File r17 = (File) r0.L$1;
        ObricThresholdItemConfig r5 = (ObricThresholdItemConfig) r0.L$0;
        ResultKt.throwOnFailure(r16);
    L30:
        List r18 = (List) r16;
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L59
        File r7 = r17.getParentFile();     // Catch: Throwable -> L59
        if (r7 == null) goto L35;
        Boxing.boxBoolean(r7.mkdirs());     // Catch: Throwable -> L59
    L35:
        if (r17.exists() == false) goto L37;
        r17.delete();     // Catch: Throwable -> L59
    L37:
        BufferedOutputStream r8 = new PolarisFileOutputStreamWrapper(r17);     // Catch: Throwable -> L59
        if ((r8 instanceof BufferedOutputStream) == false) goto L40;
        BufferedOutputStream r9 = r8;     // Catch: Throwable -> L59
    L41:
        ZipOutputStream r10 = new ZipOutputStream(r9);     // Catch: Throwable -> L59
        r10.putNextEntry(new ZipEntry("memoryinfo.txt"));     // Catch: Throwable -> L48
        ObricMemoryUploadFileHelper.a.getClass();     // Catch: Throwable -> L48
        r10.write(ObricMemoryUploadFileHelper.b(r4).getBytes(Charsets.UTF_8));     // Catch: Throwable -> L48
        r10.closeEntry();     // Catch: Throwable -> L48
        r10.putNextEntry(new ZipEntry("smaps.txt"));     // Catch: Throwable -> L48
        PolarisFileInputStreamWrapper r11 = new PolarisFileInputStreamWrapper(new PolarisFileWrapper("/proc/self/smaps"));     // Catch: Throwable -> L48
        ByteStreamsKt.copyTo$default(r11, r10, 0, 2, null);     // Catch: Throwable -> L50
        CloseableKt.closeFinally(r11, null);     // Catch: Throwable -> L48
        r10.closeEntry();     // Catch: Throwable -> L48
        int r19 = ObricMemoryUploadFileHelper.a(r10, r18, r5);     // Catch: Throwable -> L48
        CloseableKt.closeFinally(r10, null);     // Catch: Throwable -> L59
        Object r110 = Result.constructor-impl(Boxing.boxInt(r19));     // Catch: Throwable -> L59
    L61:
        Throwable r12 = Result.exceptionOrNull-impl(r110);
        if (r12 == null) goto L65;
        r17.delete();
        FLogger.a.e("ObricMemoryUploadServiceImpl", "mergeMemoryFiles error", r12);
    L65:
        if (Result.isSuccess-impl(r110) == false) goto L67;
        ((Number) r110).intValue();
        Object r111 = Result.constructor-impl(r17);
    L69:
        if (Result.isFailure-impl(r111) == false) goto L72;
        return null;
    L72:
        return r111;
    L67:
        r111 = Result.constructor-impl(r110);
        goto L69
    L50:
        th = move-exception;
        throw th;     // Catch: Throwable -> L52
    L52:
        th = move-exception;
        CloseableKt.closeFinally(r11, th);     // Catch: Throwable -> L48
        throw th;     // Catch: Throwable -> L48
    L48:
        th = move-exception;
        throw th;     // Catch: Throwable -> L56
    L56:
        th = move-exception;
        CloseableKt.closeFinally(r10, th);     // Catch: Throwable -> L59
        throw th;     // Catch: Throwable -> L59
    L40:
        r9 = new BufferedOutputStream(r8, 8192);     // Catch: Throwable -> L59
    L59:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        r110 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L61
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r16);
        long r20 = System.currentTimeMillis();
        Result.Companion r21 = Result.Companion;     // Catch: Throwable -> L17
        StringBuilder r22 = new StringBuilder("memory_snapshot_");     // Catch: Throwable -> L17
        ObricMemoryUploadFileHelper.a.getClass();     // Catch: Throwable -> L17
        r22.append(ObricMemoryUploadFileHelper.d(r20));     // Catch: Throwable -> L17
        r22.append("__");     // Catch: Throwable -> L17
        r22.append(AppHost.a.getApplication().getPackageName());     // Catch: Throwable -> L17
        r22.append("__");     // Catch: Throwable -> L17
        r22.append(IApplog.a.getDeviceId());     // Catch: Throwable -> L17
        r22.append(".zip");     // Catch: Throwable -> L17
        Object r112 = Result.constructor-impl(new PolarisFileWrapper(e(), r22.toString()));     // Catch: Throwable -> L17
    L19:
        Throwable r23 = Result.exceptionOrNull-impl(r112);
        if (r23 == null) goto L23;
        FLogger.a.e("ObricMemoryUploadServiceImpl", "buildMemoryUploadFile error, timestamp=" + r20, r23);
    L23:
        if (Result.exceptionOrNull-impl(r112) == null) goto L26;
        r112 = new PolarisFileWrapper(e(), "memory_snapshot_" + r20 + ".zip");
    L26:
        File r113 = (File) r112;
        ObricMemoryUploadFileHelper r24 = ObricMemoryUploadFileHelper.a;
        r0.L$0 = r14;
        r0.L$1 = r113;
        r0.J$0 = r20;
        r0.label = 1;
        Object r25 = r24.c(r20, r14, r0);
        if (r25 != r2) goto L29;
        return r2;
    L29:
        r4 = r20;
        r5 = r14;
        r17 = r113;
        r16 = r25;
    L17:
        th = move-exception;
        Result.Companion r26 = Result.Companion;
        r112 = Result.constructor-impl(ResultKt.createFailure(th));
    L7:
        r0 = new mergeUploadMemoryFiles.1(this, r15);
        goto L8
    }

    public final void f(File r12, String r13) {
        if (r12.exists() == true) goto L14;
        FLogger.a.w("ObricMemoryUploadServiceImpl", "uploadOnce skipped, file not exists");
        this.d = false;
        this.c++;
        return;
    L14:
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L8
        new xs3.a().c(String.valueOf(AppHost.a.getAppId()), r13, "memory_snapshot", CollectionsKt.listOf(r12.getAbsolutePath()), "main_upload", new JSONObject(), new b(this, r12));     // Catch: Throwable -> L8
        Object r14 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L8
    L10:
        Throwable r15 = Result.exceptionOrNull-impl(r14);
        if (r15 == null) goto L16;
        this.c++;
        this.d = false;
        FLogger.a.e("ObricMemoryUploadServiceImpl", "uploadOnce exception, retryCount=" + this.c, r15);
        return;
    L16:
        return;
    L8:
        th = move-exception;
        Result.Companion r16 = Result.Companion;
        r14 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L10
    }

    public static final Object b(ObricMemoryUploadServiceImpl r7, String r8, ObricThresholdItemConfig r9, Continuation r10) {
        r7.getClass();
        if ((r10 instanceof uploadMemoryInfoFilesOnce.1) == false) goto L7;
        uploadMemoryInfoFilesOnce.1 r0 = (uploadMemoryInfoFilesOnce.1) r10;
        int r1 = r0.label;
        if ((r1 & IntCompanionObject.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - IntCompanionObject.MIN_VALUE;
    L8:
        Object r11 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        r8 = (String) r0.L$0;
        ResultKt.throwOnFailure(r11);
    L40:
        File r12 = (File) r11;
        if (r12 != null) goto L43;
        r7.c++;
        FLogger.a.w("ObricMemoryUploadServiceImpl", "uploadMemoryInfoFilesOnce skipped, dump file failed");
        return Unit.INSTANCE;
    L43:
        r7.d = true;
        r7.f(r12, r8);
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r11);
        int r13 = r7.c;
        if (r13 >= 0) goto L17;
    L19:
        boolean r14 = false;
    L20:
        if (r14 == true) goto L23;
        FLogger.a.i("ObricMemoryUploadServiceImpl", "uploadMemoryInfoFilesOnce skipped");
        return Unit.INSTANCE;
    L23:
        if (StringsKt.isBlank(r8) == false) goto L25;
        r7.c++;
        FLogger.a.w("ObricMemoryUploadServiceImpl", "uploadMemoryInfoFilesOnce skipped, did is blank");
        return Unit.INSTANCE;
    L25:
        FLogger r15 = FLogger.a;
        r15.i("ObricMemoryUploadServiceImpl", "uploadMemoryInfoFilesOnce start");
        r0.L$0 = r8;
        r0.label = 1;
        File r4 = c();
        if (r4 == null) goto L29;
        r15.i("ObricMemoryUploadServiceImpl", "prepareUploadFile retry");
        r11 = r4;
    L38:
        if (r11 != r2) goto L40;
        return r2;
    L29:
        if (r9.getEnableHprof() == true) goto L45;
    L37:
        r11 = r7.d(r9, r0);
        goto L38
    L45:
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L32
        r15.i("ObricMemoryUploadServiceImpl", "prepareUploadFile trigger HeapDumper");     // Catch: Throwable -> L32
        s17.d.f().d(System.currentTimeMillis(), 2);     // Catch: Throwable -> L32
        Object r16 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L32
    L34:
        Throwable r17 = Result.exceptionOrNull-impl(r16);
        if (r17 == null) goto L37;
        FLogger.a.e("ObricMemoryUploadServiceImpl", "prepareUploadFile trigger HeapDumper error", r17);
    L32:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        r16 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L34
    L17:
        if (r13 >= 3) goto L19;
        r14 = true;
    L7:
        r0 = new uploadMemoryInfoFilesOnce.1(r7, r10);
        goto L8
    }
}
