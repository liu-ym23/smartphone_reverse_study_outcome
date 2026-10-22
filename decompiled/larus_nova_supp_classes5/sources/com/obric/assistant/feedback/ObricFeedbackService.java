package com.obric.assistant.feedback;

import aka.a;
import aka.b;
import android.app.Application;
import android.content.ContentResolver;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import com.bytedance.keva.Keva;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.audio.utils.e1;
import com.larus.audio.utils.g1;
import com.larus.common.apphost.AppHost;
import com.larus.platform.service.AccountService;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.obric.assistant.common.spi.alog.ObricAlogServiceDelegate;
import com.obric.assistant.zeus.plugin.IZeusPluginService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.io.BufferedOutputStream;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\b\f*\u0002\u0007\n\b\u0007\u0018\u0000 52\u00020\u0001:\u000245B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0010\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0016\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u00172\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0012\u0010\u0019\u001a\u00020\r2\b\b\u0001\u0010\u001a\u001a\u00020\u001bH\u0002J\u0016\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00180\u00172\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J*\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020\u00182\b\u0010#\u001a\u0004\u0018\u00010\u00182\u0006\u0010$\u001a\u00020\u0018H\u0002J\b\u0010%\u001a\u00020\rH\u0002J\u0016\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00180\u00172\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J,\u0010'\u001a\u0004\u0018\u00010(2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00180*2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00180*H\u0082@¢\u0006\u0002\u0010,JQ\u0010-\u001a\u00020\u00182\u000e\u0010.\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u00172\b\u0010/\u001a\u0004\u0018\u00010\u00182\u000e\u00100\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u00172\b\u00101\u001a\u0004\u0018\u00010\u001b2\u000e\u00102\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017H\u0002¢\u0006\u0002\u00103R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\bR\u0010\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000b¨\u00066"}, d2 = {"Lcom/obric/assistant/feedback/ObricFeedbackService;", "Lcom/obric/assistant/feedback/IObricFeedbackService;", "<init>", "()V", "keva", "Lcom/bytedance/keva/Keva;", "provider", "com/obric/assistant/feedback/ObricFeedbackService$provider$1", "Lcom/obric/assistant/feedback/ObricFeedbackService$provider$1;", "logger", "com/obric/assistant/feedback/ObricFeedbackService$logger$1", "Lcom/obric/assistant/feedback/ObricFeedbackService$logger$1;", "init", "", "isOAppSelfReport", "", "setOAppSelfReport", "feedback", "param", "Lcom/obric/assistant/feedback/IObricFeedbackService$FeedbackParam;", "reportToVoc", "drainOmniUploadImagesForFeedback", "buildOmniUploadFeedbackTags", "", "", "showReportAppToast", "stringID", "", "getAIKernelAlogFiles", "context", "Landroid/content/Context;", "resolveSafeChildFile", "Ljava/io/File;", "rootCanonical", "rootCanonicalPathWithSep", "relative", "fallbackName", "launchReportApp", "getReportFilePathList", "batchGetMessage", "Lcom/obric/assistant/feedback/ObricFeedbackService$FeedbackMessageResult;", "ids", "", "logIdSourceIds", "(Ljava/util/Set;Ljava/util/Set;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "wrapContent", "tagList", "content", "urlList", "score", "logIdList", "(Ljava/util/List;Ljava/lang/String;Ljava/util/List;Ljava/lang/Integer;Ljava/util/List;)Ljava/lang/String;", "FeedbackMessageResult", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricFeedbackService implements IObricFeedbackService {
    public static final /* synthetic */ int e = 0;
    public Keva b;
    public final d c;
    public final c d;

    public static final class c implements aka.c {
        public c() {
        }

        public final void i(String r3) {
            Intrinsics.checkNotNullParameter("FeedbackSdk", "tag");
            Intrinsics.checkNotNullParameter(r3, "msg");
            FLogger.a.i("ObricFeedbackService_FeedbackSdk", r3);
        }

        public final void e(String r3, String r4) {
            Intrinsics.checkNotNullParameter(r3, "tag");
            Intrinsics.checkNotNullParameter(r4, "msg");
            FLogger.a.e("ObricFeedbackService_".concat(r3), r4);
        }
    }

    public static final class d implements b {
        public d() {
        }

        public final void a() {
        }

        public final void getDid() {
        }

        public final String getUid() {
            return AccountService.a.getUserId();
        }
    }

    static {
    }

    public final void init() {
        Application r0 = a.a;
        Application r1 = AppHost.a.getApplication();
        d r2 = this.c;
        c r3 = this.d;
        Intrinsics.checkNotNullParameter(r1, "application");
        Intrinsics.checkNotNullParameter(r2, "provider");
        Intrinsics.checkNotNullParameter(r3, "logger");
        a.a = r1;
        a.b = r2;
        a.c = r3;
        Keva r4 = Keva.getRepo("obric_feedback_common_config", 0);
        this.b = r4;
        Keva r5 = null;
        if (r4 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("keva");
        r4 = null;
    L6:
        if (r4.contains("key_feedback_mode_init") == true) goto L16;
        Keva r6 = this.b;
        if (r6 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("keva");
        r6 = null;
    L10:
        r6.storeBoolean("obric_feedback_mode", !t9a.b.a().b());
        Keva r7 = this.b;
        if (r7 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("keva");
    L14:
        r5.storeBoolean("key_feedback_mode_init", true);
        return;
    L13:
        r5 = r7;
        goto L14
    }

    public ObricFeedbackService() {
        this.c = new d();
        this.d = new c();
    }

    public static List e(IObricFeedbackService.c r4) {
        List r0 = r4.a;
        if (r0 != null) goto L5;
        r0 = CollectionsKt.emptyList();
    L5:
        List r1 = CollectionsKt.toMutableList(r0);
        String r2 = r4.q;
        String r3 = null;
        if (r2 != null) goto L8;
    L13:
        String r5 = r4.f;
        if (r5 != null) goto L16;
    L20:
        return r1;
    L16:
        if ((!StringsKt.isBlank(r5)) == false) goto L18;
        r3 = r5;
    L18:
        if (r3 == null) goto L20;
        r1.add("__omni_feedback_source=".concat(r3));
        goto L20
    L8:
        if ((!StringsKt.isBlank(r2)) == true) goto L11;
        r2 = null;
    L11:
        if (r2 == null) goto L13;
        r1.add("__omni_feedback_type=".concat(r2));
        goto L13
    }

    public final void a(IObricFeedbackService.c r10) {
        Intrinsics.checkNotNullParameter(r10, "param");
        FLogger.a.i("ObricFeedbackService", "feedback: called, tagList = " + r10.a + ", content = " + r10.b + ", urlList = " + r10.c + ", messageIdList = " + r10.d + ", feedbackMsgId = " + r10.e + ", feedbackSource = " + r10.f + ", feedbackBizType = " + r10.g + ", searchTool = " + r10.h + ", isConsentChecked = " + r10.i + ", filePathList = " + r10.l);
        if (r10.n == true) goto L5;
    L7:
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new feedback.1(r10, this, new AtomicBoolean(false), null), 3, null);
        return;
    L5:
        if (o0.d(r10.b) == false) goto L7;
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new reportToVoc.1(r10, null), 3, null);
        goto L7
    }

    public static final List b(ObricFeedbackService r17, Context r18) {
        r17.getClass();
        if (Build.VERSION.SDK_INT < 29) goto L127;
        long r0 = System.currentTimeMillis() / ((long) 1000);
        String r2 = null;
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L8
        ContentResolver r4 = r18.getContentResolver();     // Catch: Throwable -> L8
        Bundle r6 = new Bundle();     // Catch: Throwable -> L8
        Duration.Companion r8 = Duration.Companion;     // Catch: Throwable -> L8
        r6.putLong("start_time", r0 - Duration.m442toLongimpl(DurationKt.toDuration(3, DurationUnit.DAYS), DurationUnit.SECONDS));     // Catch: Throwable -> L8
        r6.putLong("end_time", r0);     // Catch: Throwable -> L8
        Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L8
        Object r5 = Result.constructor-impl(r4.call("com.obric.aikernel.provider.AIKernelCommonProvider", "getALogFiles", null, r6));     // Catch: Throwable -> L8
    L11:
        if (Result.isFailure-impl(r5) == false) goto L13;
        r5 = null;
    L13:
        Bundle r7 = (Bundle) r5;
        if (r7 != null) goto L16;
        FLogger.a.w("ObricFeedbackService", "getAIKernelAlogFiles: contentResolver.call return null");
        return CollectionsKt.emptyList();
    L16:
        PolarisFileWrapper r9 = new PolarisFileWrapper(r18.getFilesDir(), "aikernel_logs");
        FilesKt.deleteRecursively(r9);
        r9.mkdirs();
        Object r10 = Result.constructor-impl(r9.getCanonicalFile());     // Catch: Throwable -> L19
    L22:
        if (Result.isFailure-impl(r10) == false) goto L24;
        r10 = r9;
    L24:
        File r11 = (File) r10;
        String r12 = r11.getPath() + File.separator;
        ArrayList<String> r13 = r7.getStringArrayList("alog_files_relative_path");
        List r14 = r7.getParcelableArrayList("alog_files_fd");
        if (r14 != null) goto L27;
        r14 = CollectionsKt.emptyList();
    L27:
        List r15 = r14;
        Iterator r16 = r15.iterator();
        int r19 = 0;
    L29:
        if (r16.hasNext() == false) goto L102;
        Object r20 = r16.next();
        int r110 = r19 + 1;
        if (r19 >= 0) goto L33;
        CollectionsKt.throwIndexOverflow();
    L33:
        ParcelFileDescriptor r111 = (ParcelFileDescriptor) r20;
        if (r13 == null) goto L36;
        String r21 = (String) CollectionsKt.getOrNull(r13, r19);
    L37:
        Intrinsics.checkNotNull(r11);
        String r112 = String.valueOf(r19);
        if (r21 == null) goto L40;
        String r22 = StringsKt.trim(r21).toString();
    L41:
        if (r22 != null) goto L43;
    L46:
        boolean r113 = true;
    L47:
        if (r113 == false) goto L50;
        r22 = r2;
    L50:
        if (r22 != null) goto L52;
        r22 = r112;
    L52:
        PolarisFileWrapper r114 = new PolarisFileWrapper(r11, r22);
        Result.Companion r23 = Result.Companion;     // Catch: Throwable -> L55
        Object r24 = Result.constructor-impl(r114.getCanonicalFile());     // Catch: Throwable -> L55
    L57:
        Object r115 = r114;
        if (Result.isFailure-impl(r24) == true) goto L61;
        r115 = r24;
    L61:
        File r116 = (File) r115;
        if (StringsKt.startsWith$default(r116.getPath(), r12, false, 2, r2) == false) goto L64;
        Intrinsics.checkNotNull(r116);
    L65:
        File r25 = r116.getParentFile();
        if (r25 == null) goto L115;
        r25.mkdirs();
    L115:
        ParcelFileDescriptor.AutoCloseInputStream r117 = new ParcelFileDescriptor.AutoCloseInputStream(r111);     // Catch: Throwable -> L96
        BufferedOutputStream r26 = new PolarisFileOutputStreamWrapper(r116);     // Catch: Throwable -> L89
        if ((r26 instanceof BufferedOutputStream) == false) goto L104;
        BufferedOutputStream r118 = r26;
    L75:
        r2 = null;
        long r119 = ByteStreamsKt.copyTo$default(r117, r118, 0, 2, null);     // Catch: Throwable -> L80
        CloseableKt.closeFinally(r118, null);     // Catch: Throwable -> L89
        CloseableKt.closeFinally(r117, null);     // Catch: Throwable -> L96
        Object r27 = Result.constructor-impl(Long.valueOf(r119));     // Catch: Throwable -> L96
    L98:
        Throwable r28 = Result.exceptionOrNull-impl(r27);
        if (r28 == null) goto L101;
        FLogger.a.e("ObricFeedbackService", "getAIKernelAlogFiles: copy failed, index=" + r19 + ", path=" + r116.getAbsolutePath(), r28);
    L101:
        r19 = r110;
        goto L29
    L80:
        th = move-exception;
        throw th;     // Catch: Throwable -> L83
    L83:
        th = move-exception;
        CloseableKt.closeFinally(r118, th);     // Catch: Throwable -> L89
        throw th;     // Catch: Throwable -> L89
    L104:
        r118 = new BufferedOutputStream(r26, 8192);     // Catch: Throwable -> L87
    L87:
        th = th;
        r2 = null;
    L90:
        Throwable r120 = th;
        throw r120;     // Catch: Throwable -> L92
    L92:
        th = move-exception;
        CloseableKt.closeFinally(r117, r120);     // Catch: Throwable -> L96
        throw th;     // Catch: Throwable -> L96
    L89:
        th = th;
    L96:
        th = move-exception;
        Result.Companion r121 = Result.Companion;
        r27 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L98
    L64:
        r116 = new PolarisFileWrapper(r11, r112);
    L55:
        th = move-exception;
        Result.Companion r122 = Result.Companion;
        r24 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L57
    L43:
        if (r22.length() == 0) goto L46;
        r113 = false;
        goto L47
    L40:
        r22 = r2;
        goto L41
    L36:
        r21 = r2;
        goto L37
    L102:
        List r29 = CollectionsKt.listOf(r9.getAbsolutePath());
        FLogger.a.i("ObricFeedbackService", "getAIKernelAlogFiles: fileNum = " + r15.size() + ", fileList = " + r29);
        return r29;
    L19:
        th = move-exception;
        Result.Companion r30 = Result.Companion;
        r10 = Result.constructor-impl(ResultKt.createFailure(th));
    L8:
        th = move-exception;
        Result.Companion r31 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L11
    L127:
        return CollectionsKt.emptyList();
    }

    public static final List c(ObricFeedbackService r2, IObricFeedbackService.c r3) {
        r2.getClass();
        ArrayList r4 = new ArrayList();
        IZeusPluginService r0 = (IZeusPluginService) ServiceManager.get().getService(IZeusPluginService.class);
        if (r0 == null) goto L5;
        List r1 = r0.b(AppHost.a.getApplication());
    L6:
        if (r1 == null) goto L11;
        Iterator r5 = r1.iterator();
    L9:
        if (r5.hasNext() == false) goto L11;
        r4.add((String) r5.next());
    L11:
        List r6 = r3.l;
        if (r6 == null) goto L17;
        Iterator r7 = r6.iterator();
    L15:
        if (r7.hasNext() == false) goto L17;
        r4.add((String) r7.next());
    L17:
        List r8 = ObricAlogServiceDelegate.b.b();
        if (r8 == null) goto L23;
        Iterator r9 = r8.iterator();
    L21:
        if (r9.hasNext() == false) goto L23;
        r4.add((String) r9.next());
    L23:
        FLogger.a.i("ObricFeedbackService", "getReportFilePathList: path = " + r4);
        return r4;
    L5:
        r1 = null;
        goto L6
    }

    public static final void d(ObricFeedbackService r1, int r2) {
        r1.getClass();
        Handler r3 = g1.a;
        b r4 = new b(r2);
        Intrinsics.checkNotNullParameter(r4, "block");
        if (ThreadMethodProxy.getLooperThread(Looper.getMainLooper()) != ThreadMethodProxy.currentThread()) goto L5;
        r4.invoke();
        return;
    L5:
        g1.a.post(new e1(r4));
    }
}
