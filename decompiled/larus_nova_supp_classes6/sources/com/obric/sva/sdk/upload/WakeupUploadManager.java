package com.obric.sva.sdk.upload;

import android.content.Context;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.mammon.audiosdk.SpeechWakeupUploadService;
import com.obric.eventkit.eventstaskmanager.ITaskManager;
import com.obric.sva.sdk.utils.LogUtils;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.io.File;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.CloseableKt;
import kotlin.io.FilesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import kotlinx.coroutines.ExecutorsKt;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u0012\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001c\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002cdB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020#H\u0007J\u000e\u0010(\u001a\u00020&2\u0006\u0010)\u001a\u00020\u000eJ\u0006\u0010*\u001a\u00020&J\u0006\u0010+\u001a\u00020&J\u0016\u0010,\u001a\u00020&2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020\u0005J\u0016\u00100\u001a\u00020&2\u0006\u00101\u001a\u00020\u001f2\u0006\u00102\u001a\u00020\u001fJ\u000e\u00103\u001a\u00020&2\u0006\u00104\u001a\u00020\u0005J\u0016\u00105\u001a\u00020&2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020\u0005J\u0006\u00106\u001a\u00020&J\u0006\u00107\u001a\u00020&J\u0006\u00108\u001a\u00020&J\u000e\u00109\u001a\u00020&2\u0006\u00104\u001a\u00020\u0005JH\u0010:\u001a\u00020&2\u0006\u00104\u001a\u00020\u000526\u0010;\u001a2\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b=\u0012\b\b>\u0012\u0004\b\b(?\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b=\u0012\b\b>\u0012\u0004\b\b(@\u0012\u0004\u0012\u00020A0<H\u0002J,\u0010B\u001a\u00020&2\f\u0010C\u001a\b\u0012\u0004\u0012\u00020E0D2\f\u0010F\u001a\b\u0012\u0004\u0012\u00020E0D2\u0006\u00104\u001a\u00020\u0005H\u0002J0\u0010G\u001a\u00020&2\u0006\u0010H\u001a\u00020I2\u0006\u0010J\u001a\u00020E2\u0006\u0010K\u001a\u00020\u00052\u0006\u0010/\u001a\u00020\u00052\u0006\u00104\u001a\u00020\u0005H\u0002J \u0010L\u001a\u00020&2\u0006\u0010M\u001a\u00020E2\u0006\u00104\u001a\u00020\u00052\u0006\u0010N\u001a\u00020\u0005H\u0002J\u0010\u0010O\u001a\u00020&2\u0006\u0010M\u001a\u00020EH\u0002J\b\u0010P\u001a\u00020&H\u0002J\u0010\u0010Q\u001a\u00020\u000e2\u0006\u0010R\u001a\u00020\u0005H\u0002J\u0010\u0010S\u001a\u00020\u00052\u0006\u0010R\u001a\u00020\u0005H\u0002J\b\u0010T\u001a\u00020&H\u0002J\u000e\u0010U\u001a\b\u0012\u0004\u0012\u00020E0DH\u0002J\u000e\u0010V\u001a\b\u0012\u0004\u0012\u00020E0DH\u0002J\n\u0010W\u001a\u0004\u0018\u00010EH\u0002J*\u0010X\u001a\u00020&2\u0006\u0010-\u001a\u00020.2\u0006\u0010Y\u001a\u00020\u00052\u0006\u0010/\u001a\u00020\u00052\b\b\u0002\u0010Z\u001a\u00020\u001fH\u0002J\u0016\u0010[\u001a\u00020&2\u0006\u0010J\u001a\u00020E2\u0006\u0010/\u001a\u00020\u0005J\u0010\u0010\\\u001a\u00020E2\u0006\u0010]\u001a\u00020EH\u0002J\u0010\u0010^\u001a\u00020\u00052\u0006\u0010]\u001a\u00020EH\u0002J\u0018\u0010_\u001a\u00020&2\u0006\u0010`\u001a\u00020E2\u0006\u0010a\u001a\u00020EH\u0002J\u0018\u0010b\u001a\u00020\u001f2\u0006\u0010]\u001a\u00020E2\u0006\u00104\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000eX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000eX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006e"}, d2 = {"Lcom/obric/sva/sdk/upload/WakeupUploadManager;", "", "<init>", "()V", "TAG", "", "UPLOAD_DIR_NAME", "READY_SUFFIX", "WRITING_SUFFIX", "UPLOADING_SUFFIX", "OWNER_SUFFIX", "VOICE_READY_PREFIX", "BREATH_READY_PREFIX", "VOICE_UPLOAD_COUNT", "", "DEFAULT_BREATH_UPLOAD_COUNT", "MAX_READY_FILE_COUNT", "MAX_UPLOAD_FAILURE_COUNT", "failureSuffixRegex", "Lkotlin/text/Regex;", "singleThreadDispatcher", "Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "uploading", "Ljava/util/concurrent/atomic/AtomicBoolean;", "pendingUploadRequest", "forceVoiceUploadPending", "forceBreathUploadPending", "voiceUploadLock", "voiceWakeupUploadActive", "", "pendingVoiceUploadTask", "Lcom/obric/sva/sdk/upload/WakeupUploadManager$PendingVoiceUploadTask;", "appContext", "Landroid/content/Context;", "breathUploadThreshold", "init", "", "context", "updateBreathUploadThreshold", "maxCacheSize", "onUploadFileReady", "beginVoiceWakeupUpload", "onVoiceUploadTask", "bytes", "", "ownerUserId", "finishVoiceWakeupUploadAttempt", "willRetry", "wakeupPassed", "discardPendingVoiceWakeupUpload", "reason", "onBreathUploadTask", "onVoiceWakeupPassed", "onBreathWakeupPassed", "onFeedbackSubmit", "clearAllPendingFiles", "processUploadTrigger", "shouldUpload", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "voiceCount", "breathCount", "Lcom/obric/sva/sdk/upload/WakeupUploadManager$UploadSelection;", "uploadAllReadyFiles", "files", "", "Ljava/io/File;", "breathFiles", "uploadSingleFile", "service", "Lcom/mammon/audiosdk/SpeechWakeupUploadService;", "readyFile", "header", "handleUploadFailure", "uploadingFile", "cause", "rollbackUploadingFile", "normalizeUploadingFiles", "failureCount", "fileNameWithoutSuffix", "baseNameWithoutFailureSuffix", "enforceMaxReadyFiles", "readyFiles", "readyBreathFiles", "uploadDir", "persistUploadTask", "prefix", "forceVoiceUpload", "writeOwnerForReadyFile", "ownerFile", "file", "readOwner", "renameOwner", "from", "to", "deleteWithOwner", "UploadSelection", "PendingVoiceUploadTask", "libs_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final class WakeupUploadManager {
    private static final String BREATH_READY_PREFIX = "breath_wakeup_";
    private static final int DEFAULT_BREATH_UPLOAD_COUNT = 10;
    public static final WakeupUploadManager INSTANCE = null;
    private static final int MAX_READY_FILE_COUNT = 50;
    private static final int MAX_UPLOAD_FAILURE_COUNT = 3;
    private static final String OWNER_SUFFIX = ".owner";
    private static final String READY_SUFFIX = ".bin";
    private static final String TAG = "WakeupUploadManager";
    private static final String UPLOADING_SUFFIX = ".uploading";
    private static final String UPLOAD_DIR_NAME = "wakeup_upload";
    private static final String VOICE_READY_PREFIX = "voice_wakeup_";
    private static final int VOICE_UPLOAD_COUNT = 10;
    private static final String WRITING_SUFFIX = ".writing";
    private static volatile Context appContext;
    private static volatile int breathUploadThreshold;
    private static final Regex failureSuffixRegex = null;
    private static final AtomicBoolean forceBreathUploadPending = null;
    private static final AtomicBoolean forceVoiceUploadPending = null;
    private static final AtomicBoolean pendingUploadRequest = null;
    private static PendingVoiceUploadTask pendingVoiceUploadTask;
    private static final CoroutineScope scope = null;
    private static final ExecutorCoroutineDispatcher singleThreadDispatcher = null;
    private static final AtomicBoolean uploading = null;
    private static final Object voiceUploadLock = null;
    private static boolean voiceWakeupUploadActive;

    /* JADX INFO: renamed from: com.obric.sva.sdk.upload.WakeupUploadManager$init$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
    @DebugMetadata(c = "com.obric.sva.sdk.upload.WakeupUploadManager$init$1", f = "WakeupUploadManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        public AnonymousClass1(Continuation<? super AnonymousClass1> r2) {
            super(2, r2);
        }

        public static /* synthetic */ UploadSelection a(int r0, int r1) {
            return invokeSuspend$lambda$0(r0, r1);
        }

        public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
            return new AnonymousClass1(r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r3) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L12;
            ResultKt.throwOnFailure(r3);
            WakeupUploadManager r4 = WakeupUploadManager.INSTANCE;
            WakeupUploadManager.access$normalizeUploadingFiles(r4);
            WakeupUploadManager.access$enforceMaxReadyFiles(r4);
            if ((!WakeupUploadManager.access$readyFiles(r4).isEmpty()) == false) goto L7;
        L8:
            WakeupUploadManager.access$processUploadTrigger(r4, "boot_scan", new g());
        L10:
            return Unit.INSTANCE;
        L7:
            if ((!WakeupUploadManager.access$readyBreathFiles(r4).isEmpty()) == false) goto L10;
        L12:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        private static final UploadSelection invokeSuspend$lambda$0(int r4, int r5) {
            boolean r2 = true;
            if (r4 < 10) goto L5;
            boolean r6 = true;
        L7:
            if (r5 >= WakeupUploadManager.access$getBreathUploadThreshold$p()) goto L11;
            r2 = false;
        L11:
            return new UploadSelection(r6, r2);
        L5:
            r6 = false;
            goto L7
        }
    }

    /* JADX INFO: renamed from: com.obric.sva.sdk.upload.WakeupUploadManager$onUploadFileReady$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
    @DebugMetadata(c = "com.obric.sva.sdk.upload.WakeupUploadManager$onUploadFileReady$1", f = "WakeupUploadManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C00091 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        public C00091(Continuation<? super C00091> r2) {
            super(2, r2);
        }

        public static /* synthetic */ UploadSelection a(int r0, int r1) {
            return invokeSuspend$lambda$0(r0, r1);
        }

        public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
            return new C00091(r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r3) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r3);
            WakeupUploadManager.access$processUploadTrigger(WakeupUploadManager.INSTANCE, "file_ready", new j());
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        private static final UploadSelection invokeSuspend$lambda$0(int r4, int r5) {
            boolean r2 = false;
            if (WakeupUploadManager.access$getForceVoiceUploadPending$p().get() == false) goto L5;
        L8:
            boolean r6 = true;
        L10:
            if (WakeupUploadManager.access$getForceBreathUploadPending$p().get() == false) goto L12;
        L13:
            r2 = true;
        L15:
            return new UploadSelection(r6, r2);
        L12:
            if (r5 < WakeupUploadManager.access$getBreathUploadThreshold$p()) goto L15;
        L5:
            if (r4 >= 10) goto L8;
            r6 = false;
            goto L10
        }
    }

    private WakeupUploadManager() {
    }

    public static /* synthetic */ boolean a(File r0) {
        return readyBreathFiles$lambda$23(r0);
    }

    public static /* synthetic */ Thread b(Runnable r0) {
        return singleThreadDispatcher$lambda$1(r0);
    }

    public static /* synthetic */ boolean c(File r0) {
        return normalizeUploadingFiles$lambda$17(r0);
    }

    public static /* synthetic */ boolean d(File r0) {
        return readyFiles$lambda$21(r0);
    }

    public static /* synthetic */ String e(String r0) {
        return uploadAllReadyFiles$lambda$8(r0);
    }

    private static final String uploadAllReadyFiles$lambda$8(String r0) {
        return r0;
    }

    static {
        INSTANCE = new WakeupUploadManager();
        failureSuffixRegex = new Regex("\\.fail(\\d+)$");
        ExecutorCoroutineDispatcher r0 = ExecutorsKt.from(PThreadExecutorsUtils.newSingleThreadExecutor(new a()));
        singleThreadDispatcher = r0;
        scope = CoroutineScopeKt.CoroutineScope(r0.plus(SupervisorKt.SupervisorJob$default(null, 1, null)));
        uploading = new AtomicBoolean(false);
        pendingUploadRequest = new AtomicBoolean(false);
        forceVoiceUploadPending = new AtomicBoolean(false);
        forceBreathUploadPending = new AtomicBoolean(false);
        voiceUploadLock = new Object();
        breathUploadThreshold = 10;
    }

    private final File uploadDir() {
        Context r0 = appContext;
        PolarisFileWrapper r1 = null;
        if (r0 != null) goto L5;
        return null;
    L5:
        File r2 = r0.getFilesDir();
        if (r2 == null) goto L21;
        File r3 = r2.getParentFile();
        if (r3 == null) goto L21;
        r1 = new PolarisFileWrapper(r3, UPLOAD_DIR_NAME);
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L16
        if (r1.exists() == true) goto L14;
        r1.mkdirs();     // Catch: Throwable -> L16
    L14:
        Object r5 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L16
    L18:
        Throwable r6 = Result.exceptionOrNull-impl(r5);
        if (r6 == null) goto L21;
        LogUtils.e(TAG, "create upload dir failed: " + r6.getMessage(), new Object[0]);
    L16:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
    L21:
        return r1;
    }

    public final void beginVoiceWakeupUpload() {
        Object r0 = voiceUploadLock;
        monitor-enter(r0);
        PendingVoiceUploadTask r1 = pendingVoiceUploadTask;     // Catch: Throwable -> L12
        pendingVoiceUploadTask = null;     // Catch: Throwable -> L12
        boolean r2 = true;
        voiceWakeupUploadActive = true;     // Catch: Throwable -> L12
        monitor-exit(r0);
        StringBuilder r3 = new StringBuilder("beginVoiceWakeupUpload discardedStale=");
        if (r1 != null) goto L10;
        r2 = false;
    L10:
        r3.append(r2);
        LogUtils.i(TAG, r3.toString(), new Object[0]);
        return;
    L12:
        th = move-exception;
        throw th;
    }

    public final void onBreathWakeupPassed() {
        forceBreathUploadPending.set(true);
        BuildersKt.launch$default(scope, null, null, new onBreathWakeupPassed.1(null), 3, null);
    }

    public final void onFeedbackSubmit() {
        BuildersKt.launch$default(scope, null, null, new onFeedbackSubmit.1(null), 3, null);
    }

    public final void onUploadFileReady() {
        BuildersKt.launch$default(scope, null, null, new C00091(null), 3, null);
    }

    public final void onVoiceWakeupPassed() {
        BuildersKt.launch$default(scope, null, null, new onVoiceWakeupPassed.1(null), 3, null);
    }

    private final void enforceMaxReadyFiles() {
        List r0 = CollectionsKt.sortedWith(CollectionsKt.plus(readyFiles(), readyBreathFiles()), new WakeupUploadManager$enforceMaxReadyFiles$$inlined$sortedBy$1());
        if (r0.size() > 50) goto L5;
        return;
    L5:
        Iterator r1 = CollectionsKt.take(r0, r0.size() - 50).iterator();
    L7:
        if (r1.hasNext() == false) goto L9;
        File r2 = (File) r1.next();
        LogUtils.w(TAG, "delete overflow wakeup upload file=" + r2.getName() + " deleted=" + INSTANCE.deleteWithOwner(r2, "overflow"), new Object[0]);
        goto L7
    }

    private final void normalizeUploadingFiles() {
        File r0 = uploadDir();
        if (r0 == null) goto L9;
        File[] r1 = r0.listFiles(new c());
        if (r1 == null) goto L11;
        int r2 = r1.length;
        int r3 = 0;
    L7:
        if (r3 >= r2) goto L12;
        File r4 = r1[r3];
        WakeupUploadManager r5 = INSTANCE;
        Intrinsics.checkNotNull(r4);
        r5.rollbackUploadingFile(r4);
        r3 = r3 + 1;
        goto L7
    L12:
        return;
    L11:
        return;
    }

    private final List<File> readyBreathFiles() {
        File r0 = uploadDir();
        if (r0 == null) goto L7;
        File[] r1 = r0.listFiles(new d());
        if (r1 == null) goto L7;
        List<File> r2 = ArraysKt.sortedWith(r1, new WakeupUploadManager$readyBreathFiles$$inlined$sortedBy$1());
    L8:
        if (r2 == null) goto L10;
        return r2;
    L10:
        return CollectionsKt.emptyList();
    L7:
        r2 = null;
        goto L8
    }

    private final List<File> readyFiles() {
        File r0 = uploadDir();
        if (r0 == null) goto L7;
        File[] r1 = r0.listFiles(new b());
        if (r1 == null) goto L7;
        List<File> r2 = ArraysKt.sortedWith(r1, new WakeupUploadManager$readyFiles$$inlined$sortedBy$1());
    L8:
        if (r2 == null) goto L10;
        return r2;
    L10:
        return CollectionsKt.emptyList();
    L7:
        r2 = null;
        goto L8
    }

    public static final /* synthetic */ int access$getBreathUploadThreshold$p() {
        return breathUploadThreshold;
    }

    public static final /* synthetic */ AtomicBoolean access$getForceBreathUploadPending$p() {
        return forceBreathUploadPending;
    }

    public static final /* synthetic */ AtomicBoolean access$getForceVoiceUploadPending$p() {
        return forceVoiceUploadPending;
    }

    public static final /* synthetic */ AtomicBoolean access$getPendingUploadRequest$p() {
        return pendingUploadRequest;
    }

    public static final /* synthetic */ void access$enforceMaxReadyFiles(WakeupUploadManager r0) {
        r0.enforceMaxReadyFiles();
    }

    public static final /* synthetic */ void access$normalizeUploadingFiles(WakeupUploadManager r0) {
        r0.normalizeUploadingFiles();
    }

    public static final /* synthetic */ List access$readyBreathFiles(WakeupUploadManager r0) {
        return r0.readyBreathFiles();
    }

    public static final /* synthetic */ List access$readyFiles(WakeupUploadManager r0) {
        return r0.readyFiles();
    }

    public static final /* synthetic */ File access$uploadDir(WakeupUploadManager r0) {
        return r0.uploadDir();
    }

    private final String baseNameWithoutFailureSuffix(String r3) {
        return failureSuffixRegex.replace(r3, "");
    }

    private final int failureCount(String r5) {
        MatchResult r6 = Regex.find$default(failureSuffixRegex, r5, 0, 2, null);
        if (r6 == null) goto L12;
        List r7 = r6.getGroupValues();
        if (r7 == null) goto L13;
        String r8 = (String) CollectionsKt.getOrNull(r7, 1);
        if (r8 == null) goto L14;
        Integer r9 = StringsKt.toIntOrNull(r8);
        if (r9 != null) goto L11;
        return 0;
    L11:
        return r9.intValue();
    L14:
        return 0;
    L13:
        return 0;
    L12:
        return 0;
    }

    @JvmStatic
    public static final void init(Context r6) {
        Intrinsics.checkNotNullParameter(r6, "context");
        appContext = r6.getApplicationContext();
        BuildersKt.launch$default(scope, null, null, new AnonymousClass1(null), 3, null);
    }

    private static final boolean normalizeUploadingFiles$lambda$17(File r4) {
        if (r4.isFile() == true) goto L5;
        return false;
    L5:
        if (StringsKt.endsWith$default(r4.getName(), UPLOADING_SUFFIX, false, 2, null) == false) goto L9;
        return true;
    L9:
        return false;
    }

    private final File ownerFile(File r4) {
        return new PolarisFileWrapper(r4.getParentFile(), r4.getName() + OWNER_SUFFIX);
    }

    private final String readOwner(File r3) {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        Object r4 = Result.constructor-impl(StringsKt.trim(FilesKt.readText$default(ownerFile(r3), null, 1, null)).toString());     // Catch: Throwable -> L4
    L7:
        if (Result.isFailure-impl(r4) == false) goto L10;
        r4 = "";
    L10:
        return (String) r4;
    L4:
        th = move-exception;
        Result.Companion r1 = Result.Companion;
        r4 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }

    private static final boolean readyBreathFiles$lambda$23(File r5) {
        if (r5.isFile() == true) goto L5;
        return false;
    L5:
        if (StringsKt.startsWith$default(r5.getName(), BREATH_READY_PREFIX, false, 2, null) == true) goto L7;
        return false;
    L7:
        if (StringsKt.endsWith$default(r5.getName(), READY_SUFFIX, false, 2, null) == true) goto L9;
        return false;
    L9:
        if (StringsKt.endsWith$default(r5.getName(), WRITING_SUFFIX, false, 2, null) == true) goto L15;
        return true;
    L15:
        return false;
    }

    private static final boolean readyFiles$lambda$21(File r5) {
        if (r5.isFile() == true) goto L5;
        return false;
    L5:
        if (StringsKt.endsWith$default(r5.getName(), READY_SUFFIX, false, 2, null) == true) goto L7;
        return false;
    L7:
        if (StringsKt.endsWith$default(r5.getName(), WRITING_SUFFIX, false, 2, null) == false) goto L9;
        return false;
    L9:
        if (StringsKt.startsWith$default(r5.getName(), BREATH_READY_PREFIX, false, 2, null) == true) goto L15;
        return true;
    L15:
        return false;
    }

    private final void rollbackUploadingFile(File r6) {
        if (r6.exists() == true) goto L5;
        return;
    L5:
        PolarisFileWrapper r0 = new PolarisFileWrapper(r6.getParentFile(), StringsKt.removeSuffix(r6.getName(), UPLOADING_SUFFIX) + READY_SUFFIX);
        if (r6.renameTo(r0) == true) goto L8;
        LogUtils.w(TAG, "rollbackUploadingFile failed file=" + r6.getAbsolutePath(), new Object[0]);
        return;
    L8:
        renameOwner(r6, r0);
    }

    private static final Thread singleThreadDispatcher$lambda$1(Runnable r2) {
        PthreadThreadV2 r0 = new PthreadThreadV2(r2, TAG);
        r0.setDaemon(true);
        return r0;
    }

    public final void clearAllPendingFiles(String r8) {
        Intrinsics.checkNotNullParameter(r8, "reason");
        discardPendingVoiceWakeupUpload("clear_all:" + r8);
        BuildersKt.launch$default(scope, null, null, new clearAllPendingFiles.1(r8, null), 3, null);
    }

    public final void discardPendingVoiceWakeupUpload(String r6) {
        Intrinsics.checkNotNullParameter(r6, "reason");
        Object r0 = voiceUploadLock;
        monitor-enter(r0);
        voiceWakeupUploadActive = false;     // Catch: Throwable -> L10
        PendingVoiceUploadTask r2 = pendingVoiceUploadTask;     // Catch: Throwable -> L10
        pendingVoiceUploadTask = null;     // Catch: Throwable -> L10
        monitor-exit(r0);
        if (r2 == null) goto L15;
        LogUtils.i(TAG, "discardPendingVoiceWakeupUpload reason=" + r6 + " size=" + r2.getBytes().length, new Object[0]);
        return;
    L15:
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public final void updateBreathUploadThreshold(int r3) {
        if (r3 > 0) goto L5;
        r3 = 10;
    L5:
        breathUploadThreshold = r3;
        LogUtils.i(TAG, "updateBreathUploadThreshold threshold=" + breathUploadThreshold, new Object[0]);
    }

    private final boolean deleteWithOwner(File r5, String r6) {
        boolean r0 = r5.delete();
        LogUtils.i(TAG, "deleteWithOwner file=" + r5.getName() + " deleted=" + r0 + " ownerDeleted=" + ownerFile(r5).delete() + " reason=" + r6, new Object[0]);
        return r0;
    }

    private final void processUploadTrigger(String r13, Function2<? super Integer, ? super Integer, UploadSelection> r14) {
        AtomicBoolean r5 = uploading;
        if (r5.compareAndSet(false, true) == true) goto L53;
        pendingUploadRequest.set(true);
        LogUtils.i(TAG, "processUploadTrigger skipped: uploading, reason=" + r13, new Object[0]);
        return;
    L53:
        normalizeUploadingFiles();     // Catch: Throwable -> L48
        enforceMaxReadyFiles();     // Catch: Throwable -> L48
        List<File> r7 = readyFiles();     // Catch: Throwable -> L48
        List<File> r8 = readyBreathFiles();     // Catch: Throwable -> L48
        int r10 = r7.size() + r8.size();     // Catch: Throwable -> L48
        LogUtils.i(TAG, "processUploadTrigger reason=" + r13 + " readyCount=" + r10 + " voice=" + r7.size() + " breath=" + r8.size(), new Object[0]);     // Catch: Throwable -> L48
        if (r10 != 0) goto L12;
        r5.set(false);
        if (pendingUploadRequest.getAndSet(false) == false) goto L54;
        onUploadFileReady();
        return;
    L54:
        return;
    L12:
        UploadSelection r15 = (UploadSelection) r14.invoke(Integer.valueOf(r7.size()), Integer.valueOf(r8.size()));     // Catch: Throwable -> L48
        if (r15.getUploadVoice() == false) goto L15;
        List<File> r4 = r7;
    L17:
        if (r15.getUploadBreath() == false) goto L19;
        List<File> r16 = r8;
    L21:
        if (r4.isEmpty() == true) goto L23;
    L29:
        Context r0 = appContext;     // Catch: Throwable -> L48
        if (r0 != null) goto L32;
    L38:
        uploadAllReadyFiles(r4, r16, r13);     // Catch: Throwable -> L48
        if (readyFiles().isEmpty() == false) goto L42;
        forceVoiceUploadPending.set(false);     // Catch: Throwable -> L48
    L42:
        if (readyBreathFiles().isEmpty() == false) goto L44;
        forceBreathUploadPending.set(false);     // Catch: Throwable -> L48
    L44:
        r5.set(false);
        if (pendingUploadRequest.getAndSet(false) == false) goto L57;
        onUploadFileReady();
        return;
    L57:
        return;
    L32:
        if (NetworkUtils.isNetworkAvailable(r0) == true) goto L38;
        LogUtils.i(TAG, "processUploadTrigger skipped: network unavailable, reason=" + r13, new Object[0]);     // Catch: Throwable -> L48
        r5.set(false);
        if (pendingUploadRequest.getAndSet(false) == false) goto L56;
        onUploadFileReady();
        return;
    L56:
        return;
    L23:
        if (r16.isEmpty() == false) goto L29;
        LogUtils.i(TAG, "processUploadTrigger skipped: threshold not reached, reason=" + r13 + " voice=" + r7.size() + " breath=" + r8.size(), new Object[0]);     // Catch: Throwable -> L48
        r5.set(false);
        if (pendingUploadRequest.getAndSet(false) == false) goto L55;
        onUploadFileReady();
        return;
    L55:
        return;
    L19:
        r16 = CollectionsKt.emptyList();     // Catch: Throwable -> L48
        goto L21
    L15:
        r4 = CollectionsKt.emptyList();     // Catch: Throwable -> L48
    L48:
        th = move-exception;
        uploading.set(false);
        if (pendingUploadRequest.getAndSet(false) == false) goto L52;
        onUploadFileReady();
    L52:
        throw th;
    }

    private final void renameOwner(File r3, File r4) {
        File r5 = ownerFile(r3);
        if (r5.exists() == true) goto L5;
        return;
    L5:
        File r6 = ownerFile(r4);
        if (r5.renameTo(r6) == true) goto L9;
        LogUtils.w(TAG, "renameOwner failed from=" + r5.getName() + " to=" + r6.getName(), new Object[0]);
        return;
    }

    public final void finishVoiceWakeupUploadAttempt(boolean r5, boolean r6) {
        Object r0 = voiceUploadLock;
        monitor-enter(r0);
    L22:
        th = move-exception;
        throw th;
    L5:
        if (voiceWakeupUploadActive == true) goto L8;
        monitor-exit(r0);
        return;
    L8:
        PendingVoiceUploadTask r1 = null;
        if (r5 == true) goto L13;
        voiceWakeupUploadActive = false;     // Catch: Throwable -> L22
        PendingVoiceUploadTask r3 = pendingVoiceUploadTask;     // Catch: Throwable -> L22
        pendingVoiceUploadTask = null;     // Catch: Throwable -> L22
        r1 = r3;
    L13:
        monitor-exit(r0);
        if (r5 == false) goto L17;
        LogUtils.i(TAG, "finishVoiceWakeupUploadAttempt keep latest task for retry", new Object[0]);
        return;
    L17:
        if (r1 != null) goto L20;
        LogUtils.w(TAG, "finishVoiceWakeupUploadAttempt skipped: final task is null", new Object[0]);
        return;
    L20:
        persistUploadTask(r1.getBytes(), VOICE_READY_PREFIX, r1.getOwnerUserId(), r6);
    }

    public final void onBreathUploadTask(byte[] r9, String r10) {
        Intrinsics.checkNotNullParameter(r9, "bytes");
        Intrinsics.checkNotNullParameter(r10, "ownerUserId");
        persistUploadTask$default(this, r9, BREATH_READY_PREFIX, r10, false, 8, null);
    }

    public final void onVoiceUploadTask(byte[] r7, String r8) {
        Intrinsics.checkNotNullParameter(r7, "bytes");
        Intrinsics.checkNotNullParameter(r8, "ownerUserId");
        Object r2 = voiceUploadLock;
        monitor-enter(r2);
    L16:
        th = move-exception;
        throw th;
    L5:
        if (voiceWakeupUploadActive == true) goto L10;
        LogUtils.w(TAG, "onVoiceUploadTask dropped: no active voice wakeup, size=" + r7.length, new Object[0]);     // Catch: Throwable -> L16
        monitor-exit(r2);
        return;
    L10:
        if (pendingVoiceUploadTask == null) goto L12;
        boolean r1 = true;
    L13:
        pendingVoiceUploadTask = new PendingVoiceUploadTask(Arrays.copyOf(r7, r7.length), r8);     // Catch: Throwable -> L16
        LogUtils.i(TAG, "onVoiceUploadTask cached size=" + r7.length + " replaced=" + r1, new Object[0]);     // Catch: Throwable -> L16
        Unit r9 = Unit.INSTANCE;     // Catch: Throwable -> L16
        monitor-exit(r2);
        return;
    L12:
        r1 = false;
        goto L13
    }

    public final void writeOwnerForReadyFile(File r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, "readyFile");
        Intrinsics.checkNotNullParameter(r5, "ownerUserId");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
        FilesKt.writeText$default(ownerFile(r4), r5, null, 2, null);     // Catch: Throwable -> L5
        Object r6 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L7:
        Throwable r7 = Result.exceptionOrNull-impl(r6);
        if (r7 == null) goto L13;
        LogUtils.e(TAG, "writeOwnerForReadyFile failed file=" + r4.getName() + ": " + r7.getMessage(), new Object[0]);
        return;
    L13:
        return;
    L5:
        th = move-exception;
        Result.Companion r1 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }

    public static final /* synthetic */ void access$processUploadTrigger(WakeupUploadManager r0, String r1, Function2 r2) {
        r0.processUploadTrigger(r1, r2);
    }

    private final void handleUploadFailure(File r11, String r12, String r13) {
        if (r11.exists() == true) goto L5;
        return;
    L5:
        String r0 = StringsKt.removeSuffix(r11.getName(), UPLOADING_SUFFIX);
        int r1 = failureCount(r0) + 1;
        if (r1 < 3) goto L9;
        LogUtils.w(TAG, "delete wakeup upload file after failures file=" + r11.getName() + " failureCount=" + r1 + " deleted=" + deleteWithOwner(r11, "max_failures") + " reason=" + r12 + " cause=" + r13, new Object[0]);
        return;
    L9:
        PolarisFileWrapper r2 = new PolarisFileWrapper(r11.getParentFile(), baseNameWithoutFailureSuffix(r0) + ".fail" + r1 + READY_SUFFIX);
        if (r11.renameTo(r2) == true) goto L12;
        LogUtils.w(TAG, "mark upload failure failed file=" + r11.getAbsolutePath() + " failureCount=" + r1 + " reason=" + r12 + " cause=" + r13, new Object[0]);
        return;
    L12:
        renameOwner(r11, r2);
    }

    private final void uploadAllReadyFiles(List<? extends File> r17, List<? extends File> r18, String r19) {
        tda.b.a r1 = XttTokenProvider.INSTANCE.getFreshSnapshot(appContext);
        String r2 = r1.a;
        String r11 = r1.c;
        tna.a r3 = tna.a.a;
        e r4 = new e(r2);
        r3.getClass();
        String r12 = tna.a.a(r4);
        if (r12 != null) goto L54;
        LogUtils.i(TAG, "uploadAllReadyFiles skipped: xtt token empty, reason=" + r19, new Object[0]);
        return;
    L54:
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L44
        SpeechWakeupUploadService r15 = new SpeechWakeupUploadService();     // Catch: Throwable -> L44
        int r6 = r15.createHandle();     // Catch: Throwable -> L44
        String r7 = " reason=";
        if (r6 == 0) goto L57;
        LogUtils.e(TAG, "createHandle failed ret=" + r6 + " reason=" + r19, new Object[0]);     // Catch: Throwable -> L44
        return;
    L57:
        Iterator<T> r0 = r17.iterator();     // Catch: Throwable -> L33
    L13:
        if (r0.hasNext() == false) goto L17;
        String r13 = r7;
        uploadSingleFile(r15, (File) r0.next(), r12, r11, r19);     // Catch: Throwable -> L31
        r7 = r13;
    L31:
        th = th;
    L35:
        Throwable r8 = th;
        Result.Companion r9 = Result.Companion;     // Catch: Throwable -> L38
        LogUtils.i(TAG, "releaseHandle ret=" + r15.releaseHandle() + r13 + r19, new Object[0]);     // Catch: Throwable -> L38
        Object r10 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L38
    L40:
        Throwable r14 = Result.exceptionOrNull-impl(r10);     // Catch: Throwable -> L44
        if (r14 == null) goto L60;
        LogUtils.e(TAG, "releaseHandle exception reason=" + r19 + " error=" + r14.getMessage(), new Object[0]);     // Catch: Throwable -> L44
        throw r8;     // Catch: Throwable -> L44
    L60:
        throw r8;     // Catch: Throwable -> L44
    L38:
        th = move-exception;
        Result.Companion r16 = Result.Companion;     // Catch: Throwable -> L44
        r10 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L44
        goto L40
    L17:
        r13 = r7;
        Iterator<T> r20 = r18.iterator();     // Catch: Throwable -> L31
    L18:
        if (r20.hasNext() == false) goto L50;
        uploadSingleFile(r15, (File) r20.next(), r12, r11, r19);     // Catch: Throwable -> L31
        goto L18
    L50:
        Result.Companion r21 = Result.Companion;     // Catch: Throwable -> L24
        LogUtils.i(TAG, "releaseHandle ret=" + r15.releaseHandle() + r13 + r19, new Object[0]);     // Catch: Throwable -> L24
        Object r22 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L24
    L26:
        Throwable r23 = Result.exceptionOrNull-impl(r22);     // Catch: Throwable -> L44
        if (r23 == null) goto L29;
        LogUtils.e(TAG, "releaseHandle exception reason=" + r19 + " error=" + r23.getMessage(), new Object[0]);     // Catch: Throwable -> L44
    L29:
        Object r24 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L44
    L46:
        Throwable r25 = Result.exceptionOrNull-impl(r24);
        if (r25 == null) goto L61;
        LogUtils.e(TAG, "uploadAllReadyFiles exception reason=" + r19 + " error=" + r25.getMessage(), new Object[0]);
        return;
    L61:
        return;
    L24:
        th = move-exception;
        Result.Companion r26 = Result.Companion;     // Catch: Throwable -> L44
        r22 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L44
    L33:
        th = th;
        r13 = r7;
    L44:
        th = move-exception;
        Result.Companion r27 = Result.Companion;
        r24 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L46
    }

    private final void persistUploadTask(byte[] r9, String r10, String r11, boolean r12) {
        File r2 = uploadDir();
        if (r2 != null) goto L33;
        LogUtils.w(TAG, "persistUploadTask ignored: upload dir is null, size=" + r9.length, new Object[0]);
        return;
    L33:
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L23
        String r13 = r10 + System.currentTimeMillis() + '_' + StringsKt.take(UUID.randomUUID().toString(), 8);     // Catch: Throwable -> L23
        PolarisFileWrapper r6 = new PolarisFileWrapper(r2, r13 + WRITING_SUFFIX);     // Catch: Throwable -> L23
        PolarisFileWrapper r7 = new PolarisFileWrapper(r2, r13 + READY_SUFFIX);     // Catch: Throwable -> L23
        PolarisFileOutputStreamWrapper r14 = new PolarisFileOutputStreamWrapper(r6);     // Catch: Throwable -> L23
        r14.write(r9);     // Catch: Throwable -> L18
        r14.getFD().sync();     // Catch: Throwable -> L18
        Unit r3 = Unit.INSTANCE;     // Catch: Throwable -> L18
    L9:
        CloseableKt.closeFinally(r14, null);     // Catch: Throwable -> L23
        if (r6.renameTo(r7) == true) goto L12;
        r6.delete();     // Catch: Throwable -> L23
        LogUtils.e(TAG, "persistUploadTask rename failed: " + r6.getAbsolutePath(), new Object[0]);     // Catch: Throwable -> L23
    L16:
        Object r15 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L23
    L25:
        Throwable r16 = Result.exceptionOrNull-impl(r15);
        if (r16 == null) goto L34;
        LogUtils.e(TAG, "persistUploadTask failed: " + r16.getMessage(), new Object[0]);
        return;
    L34:
        return;
    L12:
        writeOwnerForReadyFile(r7, r11);     // Catch: Throwable -> L23
        if (r12 == false) goto L15;
        forceVoiceUploadPending.set(true);     // Catch: Throwable -> L23
    L15:
        onUploadFileReady();     // Catch: Throwable -> L23
        LogUtils.i(TAG, "persistUploadTask saved=" + r7.getAbsolutePath() + " size=" + r9.length, new Object[0]);     // Catch: Throwable -> L23
    L18:
        th = move-exception;
        throw th;     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        CloseableKt.closeFinally(r14, th);     // Catch: Throwable -> L23
        throw th;     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        Result.Companion r17 = Result.Companion;
        r15 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L25
    }

    private final void uploadSingleFile(SpeechWakeupUploadService r9, File r10, String r11, String r12, String r13) {
        String r3 = readOwner(r10);
        if (StringsKt.isBlank(r3) == false) goto L5;
    L27:
        deleteWithOwner(r10, "owner_mismatch fileOwnerLen=" + r3.length() + " tokenOwnerLen=" + r12.length() + " reason=" + r13);
        return;
    L5:
        if (StringsKt.isBlank(r12) == true) goto L27;
        if (Intrinsics.areEqual(r3, r12) == false) goto L27;
        File r14 = new PolarisFileWrapper(r10.getParentFile(), StringsKt.removeSuffix(r10.getName(), READY_SUFFIX) + UPLOADING_SUFFIX);
        if (r10.renameTo(r14) == true) goto L13;
        LogUtils.w(TAG, "rename uploading failed file=" + r10.getAbsolutePath() + " reason=" + r13, new Object[0]);
        return;
    L13:
        renameOwner(r10, r14);
        Result.Companion r15 = Result.Companion;     // Catch: Throwable -> L21
        byte[] r16 = FilesKt.readBytes(r14);     // Catch: Throwable -> L21
        int r17 = r9.upload(r16, r11);     // Catch: Throwable -> L21
        if (r17 != 0) goto L18;
        LogUtils.i(TAG, "upload success file=" + r14.getName() + " size=" + r16.length + " deleted=" + deleteWithOwner(r14, "upload_success") + " reason=" + r13, new Object[0]);     // Catch: Throwable -> L21
    L19:
        Object r18 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L21
    L23:
        Throwable r19 = Result.exceptionOrNull-impl(r18);
        if (r19 == null) goto L31;
        INSTANCE.handleUploadFailure(r14, r13, "exception=" + r19.getMessage());
        LogUtils.e(TAG, "upload exception file=" + r14.getName() + " reason=" + r13 + " error=" + r19.getMessage(), new Object[0]);
        return;
    L31:
        return;
    L18:
        handleUploadFailure(r14, r13, "ret=" + r17);     // Catch: Throwable -> L21
        LogUtils.w(TAG, "upload failed ret=" + r17 + " file=" + r14.getName() + " size=" + r16.length + " reason=" + r13, new Object[0]);     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        Result.Companion r110 = Result.Companion;
        r18 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L23
    }

    public static /* synthetic */ void persistUploadTask$default(WakeupUploadManager r0, byte[] r1, String r2, String r3, boolean r4, int r5, Object r6) {
        if ((r5 & 8) == 0) goto L5;
        r4 = false;
    L5:
        r0.persistUploadTask(r1, r2, r3, r4);
    }
}
