package com.obric.memorydata.middleware.impl.feedback;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import androidx.core.app.NotificationCompat;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.obric.feedback.sdk.c;
import com.obric.memorydata.BuildConfig;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.feedback.IFeedbackManager;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010#\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\f\u001a\u00020\u0000H\u0007J\b\u0010\r\u001a\u00020\u000eH\u0002J\"\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u00052\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0013H\u0016J\u001e\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00050\u00132\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0013H\u0002J,\u0010\u0015\u001a\u00020\u000e2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00050\u00172\u0006\u0010\u0018\u001a\u00020\u00052\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/obric/memorydata/middleware/impl/feedback/FeedbackManagerImpl;", "Lcom/obric/memorydata/middleware/api/feedback/IFeedbackManager;", "<init>", "()V", "TAG", "", "initialized", "", "KEY_FEEDBACK_SUCCESS", "KEY_FEEDBACK_ERROR_MSG", "KEY_FEEDBACK_ERROR_CODE", "ALOG_DIR_NAME", "getInst", CommonConsts.APM_INNER_EVENT_COST_INIT, "", "triggerFeedback", "Landroid/os/Bundle;", "problemDesc", "customFilePathList", "", "buildReportFilePathList", "addALogDirectory", "reportFilePaths", "", "owner", "filesDirProvider", "Lkotlin/Function0;", "Ljava/io/File;", "middleware_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class FeedbackManagerImpl implements IFeedbackManager {
    private static final String ALOG_DIR_NAME = "logs";
    public static final FeedbackManagerImpl INSTANCE = null;
    private static final String KEY_FEEDBACK_ERROR_CODE = "error_code";
    private static final String KEY_FEEDBACK_ERROR_MSG = "error_msg";
    private static final String KEY_FEEDBACK_SUCCESS = "success";
    private static final String TAG = "FeedbackManagerImpl";
    private static boolean initialized;

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0016J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"com/obric/memorydata/middleware/impl/feedback/FeedbackManagerImpl$init$1", "Lcom/obric/feedback/sdk/IAppInfoProvider;", "getUid", "", "getDid", "getTraceContentTimeWindow", "", "middleware_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a implements com.obric.feedback.sdk.b {
        a() {
        }

        @Override // com.obric.feedback.sdk.b
        public String a() {
            return AppContext.INSTANCE.getUserId();
        }

        @Override // com.obric.feedback.sdk.b
        public String b() {
            return AppContext.INSTANCE.getServerDeviceId();
        }

        @Override // com.obric.feedback.sdk.b
        public long c() {
            return 300;
        }
    }

    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0018\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J \u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¨\u0006\u000b"}, d2 = {"com/obric/memorydata/middleware/impl/feedback/FeedbackManagerImpl$init$2", "Lcom/obric/feedback/sdk/IFeedbackSdkLogger;", "d", "", LocationMonitorConst.TAG, "", NotificationCompat.CATEGORY_MESSAGE, "e", "throwable", "", "i", "middleware_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b implements c {
        b() {
        }

        @Override // com.obric.feedback.sdk.c
        public void a(String r7, String r8) {
            Intrinsics.checkNotNullParameter(r7, LocationMonitorConst.TAG);
            Intrinsics.checkNotNullParameter(r8, NotificationCompat.CATEGORY_MESSAGE);
            IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), FeedbackManagerImpl.TAG, r8, null, 4, null);
        }

        @Override // com.obric.feedback.sdk.c
        public void b(String r7, String r8) {
            Intrinsics.checkNotNullParameter(r7, LocationMonitorConst.TAG);
            Intrinsics.checkNotNullParameter(r8, NotificationCompat.CATEGORY_MESSAGE);
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), FeedbackManagerImpl.TAG, r8, false, 4, null);
        }
    }

    static {
        INSTANCE = new FeedbackManagerImpl();
    }

    private FeedbackManagerImpl() {
    }

    private final void addALogDirectory(Set<String> r3, String r4, Function0<? extends File> r5) {
        Set r2 = (Set) ZeusTransformUtils.wrapperContextForParams(r3, Set.class, "com.obric.memorydata.plugin");
        File r6 = new File((File) ZeusTransformUtils.preCheckCast(((Function0) ZeusTransformUtils.wrapperContextForParams(r5, Function0.class, "com.obric.memorydata.plugin")).invoke(), File.class, "com.obric.memorydata.plugin"), ALOG_DIR_NAME);     // Catch: Exception -> L13
        if (r6.exists() == true) goto L6;
        return;
    L6:
        if (r6.isDirectory() == true) goto L8;
        return;
    L8:
        if (r6.canRead() == false) goto L19;
        String r7 = r6.getAbsolutePath();     // Catch: Exception -> L13
        Intrinsics.checkNotNullExpressionValue(r7, "getAbsolutePath(...)");     // Catch: Exception -> L13
        r2.add(r7);     // Catch: Exception -> L13
        return;
    L19:
        return;
    L13:
        e = move-exception;
        RunLog.INSTANCE.warn(TAG, "resolve " + r4 + " alog directory failed", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
    }

    private final List<String> buildReportFilePathList(List<String> r7) {
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin");
        LinkedHashSet r0 = new LinkedHashSet();
        if (r8 != null) goto L5;
        r8 = CollectionsKt.emptyList();
    L5:
        Iterable r9 = (Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.memorydata.plugin");
        Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r10 = r9.iterator();
    L7:
        if (r10.hasNext() == false) goto L11;
        Object r3 = r10.next();
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.memorydata.plugin"), CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L7;
        r2.add(r3);
        goto L7
    L11:
        Iterator r11 = ((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L13:
        if (r11.hasNext() == false) goto L15;
        r0.add((String) ZeusTransformUtils.preCheckCast(r11.next(), String.class, "com.obric.memorydata.plugin"));
        goto L13
    L15:
        addALogDirectory((Set) ZeusTransformUtils.preCheckCast(r0, Set.class, "com.obric.memorydata.plugin"), "host", $$Lambda$FeedbackManagerImpl$AHVtVkrhIgQkNYCHihKhr3MJr6c.INSTANCE);
        addALogDirectory((Set) ZeusTransformUtils.preCheckCast(r0, Set.class, "com.obric.memorydata.plugin"), BuildConfig.BUILD_PRODUCT_TYPE, $$Lambda$FeedbackManagerImpl$iveVeeGnVIUmLcZ7u8ox9JiHyM.INSTANCE);
        return CollectionsKt.toList((Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin"));
    }

    private static final File buildReportFilePathList$lambda$0() {
        File r0 = ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getApplication(), "com.obric.memorydata.plugin"), Application.class, "com.obric.memorydata.plugin")).getFilesDir();
        Intrinsics.checkNotNullExpressionValue(r0, "getFilesDir(...)");
        return r0;
    }

    private static final File buildReportFilePathList$lambda$1() {
        File r0 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getFilesDir();
        Intrinsics.checkNotNullExpressionValue(r0, "getFilesDir(...)");
        return r0;
    }

    @JvmStatic
    public static final FeedbackManagerImpl getInst() {
        return INSTANCE;
    }

    private final synchronized void init() {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (initialized == false) goto L8;
        monitor-exit(this);
        return;
    L8:
        initialized = true;     // Catch: Throwable -> L11
        com.obric.feedback.sdk.a.f8037a.a((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getApplication(), "com.obric.memorydata.plugin"), Application.class, "com.obric.memorydata.plugin"), (com.obric.feedback.sdk.b) ZeusTransformUtils.preCheckCast(new a(), com.obric.feedback.sdk.b.class, "com.obric.memorydata.plugin"), (c) ZeusTransformUtils.preCheckCast(new b(), c.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L11
        monitor-exit(this);
    }

    public static /* synthetic */ File lambda$AHVtVkrhIgQkNYCHihKhr3MJr6c() {
        return buildReportFilePathList$lambda$0();
    }

    /* JADX INFO: renamed from: lambda$iveVeeGnVI-UmLcZ7u8ox9JiHyM, reason: not valid java name */
    public static /* synthetic */ File m1017lambda$iveVeeGnVIUmLcZ7u8ox9JiHyM() {
        return buildReportFilePathList$lambda$1();
    }

    @Override // com.obric.memorydata.middleware.api.feedback.IFeedbackManager
    public Bundle triggerFeedback(String r10, List<String> r11) {
        List<String> r12 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r10, "problemDesc");
    L21:
        th = move-exception;
        RunLog.INSTANCE.error(TAG, "feedback trigger failed", th);
        return null;
    L4:
        if (initialized == true) goto L6;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "feedback sdk not initialized, try init with default provider", null, 4, null);     // Catch: Throwable -> L21
        init();     // Catch: Throwable -> L21
    L6:
        List<String> r9 = buildReportFilePathList(r12);     // Catch: Throwable -> L21
        if (r9.isEmpty() == false) goto L9;
        Bundle r13 = com.obric.feedback.sdk.a.a(com.obric.feedback.sdk.a.f8037a, r10, null, 2, null);     // Catch: Throwable -> L21
    L10:
        if (r13 == null) goto L12;
        Boolean r14 = Boolean.valueOf(r13.getBoolean("success", false));     // Catch: Throwable -> L21
    L13:
        if (r13 == null) goto L15;
        String r15 = r13.getString(KEY_FEEDBACK_ERROR_MSG, "");     // Catch: Throwable -> L21
    L16:
        if (r13 == null) goto L18;
        Integer r2 = Integer.valueOf(r13.getInt("error_code"));     // Catch: Throwable -> L21
    L19:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "feedback triggered, success=" + r14 + ", errCode=" + r2 + ", errorMsg=" + r15, false, 4, null);     // Catch: Throwable -> L21
        return r13;
    L18:
        r2 = null;
        goto L19
    L15:
        r15 = null;
        goto L16
    L12:
        r14 = null;
        goto L13
    L9:
        r13 = com.obric.feedback.sdk.a.f8037a.a(r10, r9);     // Catch: Throwable -> L21
        goto L10
    }
}
