package com.obric.aikernel.res.update;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.bdlocation.monitor.LBSLightLocationTraceLogger;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.crash.constants.Constants;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.google.gson.JsonObject;
import com.obric.aikernel.res.PackageResourceManager;
import com.obric.aikernel.res.PrmContext;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CancellationException;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.al;
import kotlinx.coroutines.ar;
import kotlinx.coroutines.bx;
import okhttp3.HttpUrl;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000À\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 e2\u00020\u0001:\u0003efgB3\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\fJ\u0010\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)H\u0002J\u0010\u0010*\u001a\u00020'2\u0006\u0010+\u001a\u00020,H\u0002J\u0016\u0010-\u001a\u00020'2\u0006\u0010.\u001a\u00020\u00152\u0006\u0010(\u001a\u00020)J\u0011\u0010/\u001a\u00020\u0019H\u0086@ø\u0001\u0000¢\u0006\u0002\u00100J:\u00101\u001a\u00020'2\u0006\u0010+\u001a\u0002022\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u0002062\u0018\u00107\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u0002060\u001408H\u0002J\u0010\u00109\u001a\u00020:2\u0006\u0010\u0006\u001a\u00020;H\u0002J\u0014\u0010<\u001a\u00020=2\n\b\u0002\u0010+\u001a\u0004\u0018\u000102H\u0002J\u0014\u0010>\u001a\u000e\u0012\u0004\u0012\u00020@\u0012\u0004\u0012\u00020\u001f0?H\u0002J\u0012\u0010A\u001a\u00020\u00032\b\u0010B\u001a\u0004\u0018\u00010CH\u0002J\u0011\u0010D\u001a\u00020\u001fH\u0082@ø\u0001\u0000¢\u0006\u0002\u00100J\b\u0010E\u001a\u00020\u001fH\u0002J\u0011\u0010F\u001a\u00020\u001fH\u0082@ø\u0001\u0000¢\u0006\u0002\u00100J\u0011\u0010G\u001a\u00020\u001fH\u0086@ø\u0001\u0000¢\u0006\u0002\u00100J\u000f\u0010H\u001a\u0004\u0018\u00010@H\u0002¢\u0006\u0002\u0010IJ\u0006\u0010J\u001a\u00020KJ$\u0010L\u001a\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u00030?2\u0006\u0010M\u001a\u00020\u00032\u0006\u0010B\u001a\u00020,H\u0002J\b\u0010N\u001a\u00020\u001fH\u0002J\u0010\u0010O\u001a\u00020\u001f2\u0006\u0010P\u001a\u00020QH\u0002J\u000e\u0010R\u001a\u00020\u001f2\u0006\u0010S\u001a\u00020TJ\b\u0010U\u001a\u00020'H\u0002J\u000e\u0010V\u001a\u00020'2\u0006\u0010+\u001a\u000202J$\u0010W\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020'0Y0X2\u0006\u0010B\u001a\u0002042\u0006\u0010Z\u001a\u00020\tH\u0002J\u0010\u0010[\u001a\u00020'2\u0006\u00105\u001a\u000206H\u0002J\u000e\u0010\\\u001a\u00020'2\u0006\u0010(\u001a\u00020)J\u0016\u0010]\u001a\u00020\u001f2\u0006\u0010(\u001a\u00020)2\u0006\u0010^\u001a\u00020\u0003J\u001e\u0010_\u001a\u00020\u001f2\u0006\u0010(\u001a\u00020)2\u0006\u0010^\u001a\u00020\u00032\u0006\u0010`\u001a\u00020TJ\f\u0010a\u001a\u00020'*\u00020\tH\u0002J\f\u0010b\u001a\u00020'*\u00020\tH\u0002J\f\u0010c\u001a\u00020\u0003*\u00020,H\u0002J\u000e\u0010d\u001a\u00020\u0003*\u0004\u0018\u000102H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u00148\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0018X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u001e\u001a\u00020\u001f8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010!\u001a\u00020\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006h"}, d2 = {"Lcom/obric/aikernel/res/update/UpdateTask;", "", "biz", "", "scope", "Lkotlinx/coroutines/CoroutineScope;", "context", "Lcom/obric/aikernel/res/PrmContext;", "parentDir", "Ljava/io/File;", "modelDownloadTelemetry", "Lcom/obric/aikernel/res/update/ModelDownloadTelemetryRecorder;", "(Ljava/lang/String;Lkotlinx/coroutines/CoroutineScope;Lcom/obric/aikernel/res/PrmContext;Ljava/io/File;Lcom/obric/aikernel/res/update/ModelDownloadTelemetryRecorder;)V", "bizRootDir", "caller", "getCaller", "()Ljava/lang/String;", "setCaller", "(Ljava/lang/String;)V", "callerContexts", "", "Lkotlin/coroutines/CoroutineContext;", "downloadableArchive", "job", "Lkotlinx/coroutines/Deferred;", "Lcom/obric/aikernel/res/update/UpdateResult;", "getJob$resource_manager_release", "()Lkotlinx/coroutines/Deferred;", "setJob$resource_manager_release", "(Lkotlinx/coroutines/Deferred;)V", "startInFlight", "", LocationMonitorConst.TAG, "updateResult", "getUpdateResult", "()Lcom/obric/aikernel/res/update/UpdateResult;", "setUpdateResult", "(Lcom/obric/aikernel/res/update/UpdateResult;)V", "applyConstriction", "", "constriction", "Lcom/obric/aikernel/res/update/PackageUpdater$Constriction;", "archiveConfigFile", "cfg", "Lcom/obric/aikernel/res/metadata/config/DistConfig;", "attachContext", "coroutineContext", "await", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "bindModelDownloadTelemetry", "Lcom/obric/aikernel/res/metadata/config/UpdateTaskConfig;", "model", "Lcom/obric/aikernel/res/metadata/config/ModelConfig;", "task", "Lcom/obric/aikernel/res/downloader/DownloadTask;", "modelTasks", "", "currentConnectivitySnapshot", "Lcom/obric/aikernel/res/update/UpdateTask$ConnectivitySnapshot;", "Landroid/content/Context;", "currentDownloadConstraintGate", "Lcom/obric/aikernel/res/downloader/DownloadConstraintGate;", "currentDownloadConstriction", "Lkotlin/Pair;", "", "describeModelVersionsForLog", "config", "Lcom/obric/aikernel/res/metadata/config/LoraConfig;", "doDownload", "doInstall", "doProcessFiles", "doUpdate", "getBlockedDownloadConstraintState", "()Ljava/lang/Integer;", "getUpdateProgress", "", "install", "type", "installLora", "installPackage", "handlerConfig", "Lcom/obric/aikernel/res/metadata/config/PyHandlerConfig;", "isOutdated", OaidModel.KEY_TIME, "", "onConstrictionUpdated", "onNewConfig", "stageModelArtifacts", "", "Lkotlin/Function0;", "stagingPayload", "startTaskWithCurrentConstriction", "tryResume", "tryResumeIfDownloadConstraintReady", "trigger", "tryResumePendingPackageIfDownloadReady", "now", "cleanDownloadDir", "cleanDownloadTmp", "describeDownloadsForLog", "describeTaskForLog", "Companion", "ConnectivitySnapshot", "PendingDownloadConstraintSource", "resource_manager_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f6149a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f6150b;
    private final al c;
    private final PrmContext d;
    private final File e;
    private final l f;
    private UpdateResult g;
    private final String h;
    private final File i;
    private final File j;
    private String k;
    private ar<UpdateResult> l;
    private final Set<CoroutineContext> m;
    private boolean n;

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u001a\u0010\u000b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0006H\u0002J'\u0010\r\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000fH\u0000¢\u0006\u0002\b\u0010¨\u0006\u0011"}, d2 = {"Lcom/obric/aikernel/res/update/UpdateTask$Companion;", "", "()V", "getConfig", "Lcom/obric/aikernel/res/metadata/config/UpdateTaskConfig;", "biz", "", "parentDir", "Ljava/io/File;", "context", "Lcom/obric/aikernel/res/PrmContext;", "getInstalledConfig", ActivityLifecycle.NAME, "getPendingUpdateConfig", "config", "Lcom/obric/aikernel/res/PackageResourceManager$PresmConfig;", "getPendingUpdateConfig$resource_manager_release", "resource_manager_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        private final com.obric.aikernel.res.metadata.config.k a(PrmContext r3, String r4) {
            com.obric.aikernel.res.metadata.config.k r2 = com.obric.aikernel.res.metadata.data.d.f.a("package", r4, r3.getConfig());
            if (r2 == null) goto L5;
            return r2;
        L5:
            com.obric.aikernel.res.metadata.config.k r5 = com.obric.aikernel.res.metadata.data.d.f.a("lora", r4, r3.getConfig());
            if (r5 == null) goto L8;
            return r5;
        L8:
            return null;
        }

        public final com.obric.aikernel.res.metadata.config.k a(File r4, String r5, PackageResourceManager.PresmConfig r6) {
            Intrinsics.checkNotNullParameter(r4, "parentDir");
            Intrinsics.checkNotNullParameter(r5, "biz");
            Intrinsics.checkNotNullParameter(r6, "config");
            File r7 = new File(new File(r4 + "/packages", r5), "configuration.json");
            if (r7.exists() == false) goto L15;
            JsonObject r3 = (JsonObject) ZeusTransformUtils.preCheckCast(com.obric.aikernel.res.utils.a.f6155a.a(r7, JsonObject.class), JsonObject.class, "com.obric.memorydata.plugin");
            if (r3 != null) goto L8;
            return null;
        L8:
            if (com.obric.aikernel.res.metadata.config.i.f6072a.a(r3) == false) goto L12;
            Object r8 = new com.obric.aikernel.res.metadata.config.i(r5, r3, r6);
        L10:
            Object r9 = ZeusTransformUtils.preCheckCast(r8, com.obric.aikernel.res.metadata.config.k.class, "com.obric.memorydata.plugin");
        L17:
            return (com.obric.aikernel.res.metadata.config.k) r9;
        L12:
            if (com.obric.aikernel.res.metadata.config.e.f6067a.a(r3) == false) goto L14;
            r8 = new com.obric.aikernel.res.metadata.config.e(r5, r3);
            goto L10
        L14:
            com.obric.aikernel.runtime.utils.d.f6216a.c("PackageUpdater", "getPendingUpdateConfig unknown config: " + r3);
        L15:
            r9 = ZeusTransformUtils.preCheckCast(null, com.obric.aikernel.res.metadata.config.k.class, "com.obric.memorydata.plugin");
            goto L17
        }

        public final com.obric.aikernel.res.metadata.config.k a(String r2, File r3, PrmContext r4) {
            Intrinsics.checkNotNullParameter(r2, "biz");
            Intrinsics.checkNotNullParameter(r3, "parentDir");
            Intrinsics.checkNotNullParameter(r4, "context");
            com.obric.aikernel.res.metadata.config.k r5 = a(r3, r2, r4.getConfig());
            if (r5 == null) goto L5;
            return r5;
        L5:
            return a(r4, r2);
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\bHÆ\u0003J;\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\bHÖ\u0001R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\r¨\u0006\u001a"}, d2 = {"Lcom/obric/aikernel/res/update/UpdateTask$ConnectivitySnapshot;", "", "hasInternet", "", "hasValidatedInternet", "isUnmetered", "isWifi", "activeNetwork", "", "(ZZZZLjava/lang/String;)V", "getActiveNetwork", "()Ljava/lang/String;", "getHasInternet", "()Z", "getHasValidatedInternet", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "", "toString", "resource_manager_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f6151a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f6152b;
        private final boolean c;
        private final boolean d;
        private final String e;

        public b(boolean r2, boolean r3, boolean r4, boolean r5, String r6) {
            Intrinsics.checkNotNullParameter(r6, "activeNetwork");
            this.f6151a = r2;
            this.f6152b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
        }

        public final boolean a() {
            return this.f6152b;
        }

        public final boolean b() {
            return this.c;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
            return false;
        L8:
            b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.memorydata.plugin");
            if (this.f6151a == r6.f6151a) goto L12;
            return false;
        L12:
            if (this.f6152b == r6.f6152b) goto L15;
            return false;
        L15:
            if (this.c == r6.c) goto L18;
            return false;
        L18:
            if (this.d == r6.d) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.e, r6.e) == true) goto L23;
            return false;
        L23:
            return true;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v10 */
        /* JADX WARN: Type inference failed for: r0v11 */
        /* JADX WARN: Type inference failed for: r0v3, types: [int] */
        /* JADX WARN: Type inference failed for: r0v5, types: [int] */
        /* JADX WARN: Type inference failed for: r0v7, types: [int] */
        /* JADX WARN: Type inference failed for: r1v0 */
        /* JADX WARN: Type inference failed for: r1v1, types: [int] */
        /* JADX WARN: Type inference failed for: r1v2 */
        /* JADX WARN: Type inference failed for: r2v1, types: [int] */
        /* JADX WARN: Type inference failed for: r2v3, types: [int] */
        /* JADX WARN: Type inference failed for: r2v5 */
        /* JADX WARN: Type inference failed for: r2v6 */
        /* JADX WARN: Type inference failed for: r2v7 */
        /* JADX WARN: Type inference failed for: r2v8 */
        public int hashCode() {
            boolean r0 = this.f6151a;
            ?? r1 = 1;
            ?? r2 = r0;
            if (r0 == false) goto L5;
            r2 = 1;
        L5:
            int r3 = r2 * 31;
            boolean r4 = this.f6152b;
            ?? r5 = r4;
            if (r4 == false) goto L8;
            r5 = 1;
        L8:
            int r6 = (r3 + r5) * 31;
            boolean r7 = this.c;
            ?? r8 = r7;
            if (r7 == false) goto L11;
            r8 = 1;
        L11:
            int r9 = (r6 + r8) * 31;
            boolean r10 = this.d;
            if (r10 == true) goto L16;
            r1 = r10;
        L16:
            return ((r9 + r1) * 31) + this.e.hashCode();
        }

        public String toString() {
            return "ConnectivitySnapshot(hasInternet=" + this.f6151a + ", hasValidatedInternet=" + this.f6152b + ", isUnmetered=" + this.c + ", isWifi=" + this.d + ", activeNetwork=" + this.e + ')';
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/obric/aikernel/res/update/UpdateTask$PendingDownloadConstraintSource;", "", "download", "Lcom/obric/aikernel/res/metadata/config/Downloadable;", "resourceType", "", "(Lcom/obric/aikernel/res/metadata/config/Downloadable;Ljava/lang/String;)V", "getDownload", "()Lcom/obric/aikernel/res/metadata/config/Downloadable;", "getResourceType", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "resource_manager_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    private static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final com.obric.aikernel.res.metadata.config.c f6153a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f6154b;

        public c(com.obric.aikernel.res.metadata.config.c r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "download");
            Intrinsics.checkNotNullParameter(r3, "resourceType");
            this.f6153a = r2;
            this.f6154b = r3;
        }

        public final com.obric.aikernel.res.metadata.config.c a() {
            return this.f6153a;
        }

        public final String b() {
            return this.f6154b;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, c.class) == true) goto L8;
            return false;
        L8:
            c r6 = (c) ZeusTransformUtils.preCheckCast(r5, c.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f6153a, r6.f6153a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f6154b, r6.f6154b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.f6153a.hashCode() * 31) + this.f6154b.hashCode();
        }

        public String toString() {
            return "PendingDownloadConstraintSource(download=" + this.f6153a + ", resourceType=" + this.f6154b + ')';
        }
    }

    static {
        f6149a = new a(null);
    }

    public s(String r23, al r24, PrmContext r25, File r26, l r27) {
        al r2 = (al) ZeusTransformUtils.wrapperContextForParams(r24, al.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r23, "biz");
        Intrinsics.checkNotNullParameter(r2, "scope");
        Intrinsics.checkNotNullParameter(r25, "context");
        Intrinsics.checkNotNullParameter(r26, "parentDir");
        this.f6150b = r23;
        this.c = r2;
        this.d = r25;
        this.e = r26;
        this.f = r27;
        this.g = new UpdateResult(r23, false, 0, null, false, 0, 0, null, 0, false, 1022, null);
        this.h = "update-" + r23;
        this.i = new File(r26, "downloads");
        this.j = new File(r26 + "/packages", r23);
        this.k = "";
        this.m = (Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.memorydata.plugin");
    }

    static /* synthetic */ com.obric.aikernel.res.downloader.a a(s r0, com.obric.aikernel.res.metadata.config.k r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = null;
    L6:
        return r0.c(r1);
    }

    private final b a(Context r9) {
        Object r8 = ((Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin")).getSystemService("connectivity");
        NetworkCapabilities r1 = null;
        if (ZeusTransformUtils.instanceOf(r8, ConnectivityManager.class) == false) goto L5;
        ConnectivityManager r10 = (ConnectivityManager) ZeusTransformUtils.preCheckCast(r8, ConnectivityManager.class, "com.obric.memorydata.plugin");
    L6:
        if (r10 == null) goto L8;
        Network r11 = r10.getActiveNetwork();
    L9:
        if (r11 == null) goto L12;
        r1 = r10.getNetworkCapabilities(r11);
    L12:
        if (r1 != null) goto L14;
    L16:
        boolean r3 = false;
    L17:
        if (r1 != null) goto L19;
    L21:
        boolean r4 = false;
    L22:
        if (r1 != null) goto L24;
    L26:
        boolean r5 = false;
    L27:
        if (r1 != null) goto L29;
    L31:
        boolean r6 = false;
    L32:
        if (r11 == null) goto L35;
        String r12 = r11.toString();
        if (r12 == null) goto L35;
    L37:
        return new b(r3, r4, r5, r6, r12);
    L35:
        r12 = "null";
        goto L37
    L29:
        if (r1.hasTransport(1) != true) goto L31;
        r6 = true;
        goto L32
    L24:
        if (r1.hasCapability(11) != true) goto L26;
        r5 = true;
        goto L27
    L19:
        if (r1.hasCapability(16) != true) goto L21;
        r4 = true;
        goto L22
    L14:
        if (r1.hasCapability(12) != true) goto L16;
        r3 = true;
        goto L17
    L8:
        r11 = null;
        goto L9
    L5:
        r10 = null;
        goto L6
    }

    public static final /* synthetic */ File a(s r0) {
        return r0.i;
    }

    public static final /* synthetic */ Object a(s r2, Continuation r3) {
        return r2.c((Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin"));
    }

    private final String a(com.obric.aikernel.res.metadata.config.a r11) {
        return CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(r11.e(), Iterable.class, "com.obric.memorydata.plugin"), null, (CharSequence) ZeusTransformUtils.preCheckCast("[", CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("]", CharSequence.class, "com.obric.memorydata.plugin"), 0, null, (Function1) ZeusTransformUtils.preCheckCast(UpdateTask$describeDownloadsForLog$1.INSTANCE, Function1.class, "com.obric.memorydata.plugin"), 25, null);
    }

    private final String a(com.obric.aikernel.res.metadata.config.e r1) {
        if (r1 == null) goto L5;
        String r0 = r1.k();
        if (r0 == null) goto L5;
        return r0;
    L5:
        return HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
    }

    private final List<Function0<Unit>> a(com.obric.aikernel.res.metadata.config.h r14, File r15) {
        final List<Function0<Unit>> r0 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        Iterator r16 = ((Iterable) ZeusTransformUtils.preCheckCast(r14.e(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r16.hasNext() == false) goto L8;
        final com.obric.aikernel.res.metadata.config.c r1 = (com.obric.aikernel.res.metadata.config.c) ZeusTransformUtils.preCheckCast(r16.next(), com.obric.aikernel.res.metadata.config.c.class, "com.obric.memorydata.plugin");
        final File r10 = new File(this.i, r1.o());
        final File r5 = new File(r10, r1.f());
        final File r6 = com.obric.aikernel.res.integrity.a.f6050a.a(r15, r1.f());
        final Ref.BooleanRef r11 = new Ref.BooleanRef();
        Function1<? super Boolean, Unit> r3 = (Function1) ZeusTransformUtils.preCheckCast(new UpdateTask$stageModelArtifacts$1$copyArtifact$1(r1, r5, r6, r0, r11, this, r10), Function1.class, "com.obric.memorydata.plugin");
        this.d.getDownloadCtrl$resource_manager_release().a(this.h, r1.o(), r3);
        if (r11.element == true) goto L4;
        r3.invoke(false);
        goto L4
    L8:
        return r0;
    }

    public static final /* synthetic */ List a(s r0, com.obric.aikernel.res.metadata.config.h r1, File r2) {
        return r0.a(r1, r2);
    }

    private final Pair<Boolean, String> a(final String r16, final com.obric.aikernel.res.metadata.config.a r17) {
        final String r10 = r17.a();
        final String r11 = r17.c();
        final Function1 r6 = (Function1) ZeusTransformUtils.preCheckCast(new UpdateTask$install$prepareLibraryFiles$1(r17, this, r16, r10), Function1.class, "com.obric.memorydata.plugin");
        boolean r1 = false;
        if (Intrinsics.areEqual(r17.d(), "debug") == false) goto L13;
        String r0 = com.obric.aikernel.res.metadata.config.b.b(r17.b(), "md5");
        com.obric.aikernel.res.metadata.config.a r5 = new com.obric.aikernel.res.metadata.data.i(r10, r11, this.d.getConfig()).J();
        if (r5 == null) goto L9;
        JsonObject r7 = r5.b();
        if (r7 == null) goto L9;
        String r4 = com.obric.aikernel.res.metadata.config.b.b(r7, "md5");
    L11:
        if (Intrinsics.areEqual(r0, r4) == true) goto L13;
        r1 = true;
    L9:
        r4 = null;
    L13:
        boolean r12 = r1;
        boolean r2 = com.obric.aikernel.res.metadata.controller.a.a(this.d.getMetadataCtrl$resource_manager_release(), r16, r10, r11, r12, false, (Function1) ZeusTransformUtils.preCheckCast(new UpdateTask$install$ret$1(r16, this, r17, r10, r11, r6), Function1.class, "com.obric.memorydata.plugin"), 16, null);
        com.obric.aikernel.runtime.utils.d.f6216a.b("PackageUpdater", "install " + r16 + ' ' + r10 + '@' + r11 + ' ' + r2 + " force:" + r12);
        return new Pair(Boolean.valueOf(r2), "");
    }

    private final void a(com.obric.aikernel.res.downloader.j r5) {
        Pair<Integer, Boolean> r0 = e();
        int r1 = ((Number) ZeusTransformUtils.preCheckCast(r0.component1(), Number.class, "com.obric.memorydata.plugin")).intValue();
        boolean r2 = ((Boolean) ZeusTransformUtils.preCheckCast(r0.component2(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
        this.d.getDownloadCtrl$resource_manager_release().a(r5, r1, r2);
    }

    private final void a(com.obric.aikernel.res.metadata.config.k r3, com.obric.aikernel.res.metadata.config.h r4, com.obric.aikernel.res.downloader.j r5, Map<String, Set<com.obric.aikernel.res.downloader.j>> r6) {
        Map r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.memorydata.plugin");
        final l r0 = this.f;
        if (r0 != null) goto L5;
        return;
    L5:
        i r8 = k.a(r3, r4);
        String r9 = r8.i();
        r0.a(r8, !this.g.getBackground());
        r5.a((Collection) ZeusTransformUtils.preCheckCast(SetsKt.setOf(r9), Collection.class, "com.obric.memorydata.plugin"), (Function2) ZeusTransformUtils.preCheckCast(new UpdateTask$bindModelDownloadTelemetry$1(r0), Function2.class, "com.obric.memorydata.plugin"));
        Object r2 = r7.get(r9);
        if (r2 != null) goto L8;
        r2 = (Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.memorydata.plugin");
        r7.put(r9, r2);
    L8:
        ((Set) ZeusTransformUtils.preCheckCast(r2, Set.class, "com.obric.memorydata.plugin")).add(r5);
    }

    public static final /* synthetic */ void a(s r0, File r1) {
        r0.a(r1);
    }

    public static final /* synthetic */ void a(s r0, boolean r1) {
        r0.n = r1;
    }

    private final void a(File r4) {
        if (r4.exists() == false) goto L14;
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L6
        Object r5 = Result.m1421constructorimpl(Boolean.valueOf(FilesKt.deleteRecursively(r4)));     // Catch: Throwable -> L6
    L8:
        Throwable r6 = Result.m1424exceptionOrNullimpl(r5);
        if (r6 == null) goto L15;
        com.obric.aikernel.runtime.utils.d.f6216a.f("PackageUpdater", "cleanDownloadDir " + r4 + " failed " + r6);
        return;
    L15:
        return;
    L6:
        th = move-exception;
        Result.Companion r0 = Result.Companion;
        r5 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L8
    }

    private final boolean a(final com.obric.aikernel.res.metadata.config.j r11) {
        com.obric.aikernel.res.metadata.config.k r0 = this.g.getCfg();
        Intrinsics.checkNotNull(r0);
        final String r3 = r0.c();
        com.obric.aikernel.res.metadata.controller.a r1 = this.d.getMetadataCtrl$resource_manager_release();
        String r2 = this.f6150b;
        com.obric.aikernel.res.metadata.config.k r4 = this.g.getCfg();
        Intrinsics.checkNotNull(r4);
        return com.obric.aikernel.res.metadata.controller.a.a(r1, r2, r3, r4.b(), Intrinsics.areEqual(r3, "debug"), false, (Function1) ZeusTransformUtils.preCheckCast(new UpdateTask$installPackage$1(this, r3, r11), Function1.class, "com.obric.memorydata.plugin"), 16, null);
    }

    public static final /* synthetic */ PrmContext b(s r0) {
        return r0.d;
    }

    public static final /* synthetic */ Object b(s r2, Continuation r3) {
        return r2.d((Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin"));
    }

    private final String b(com.obric.aikernel.res.metadata.config.k r3) {
        if (r3 != null) goto L5;
        return "unknown";
    L5:
        if (ZeusTransformUtils.instanceOf(r3, com.obric.aikernel.res.metadata.config.e.class) == false) goto L10;
        StringBuilder r2 = new StringBuilder();
        String r1 = "lora:";
    L7:
        StringBuilder r4 = r2.append(r1);
    L14:
        return r4.append(r3.a()).append('@').append(r3.c()).toString();
    L10:
        if (ZeusTransformUtils.instanceOf(r3, com.obric.aikernel.res.metadata.config.i.class) == false) goto L12;
        r2 = new StringBuilder();
        r1 = "package:";
        goto L7
    L12:
        r4 = new StringBuilder().append(r3.getType()).append(':');
        goto L14
    }

    private final void b(com.obric.aikernel.res.metadata.config.a r3) {
        File r0 = new File(this.j, "configuration.json");
        File r2 = r0.getParentFile();
        boolean r1 = false;
        if (r2 != null) goto L5;
    L7:
        if (r1 == false) goto L11;
        File r4 = r0.getParentFile();
        if (r4 == null) goto L11;
        r4.mkdirs();
    L11:
        com.obric.aikernel.res.utils.a r5 = com.obric.aikernel.res.utils.a.f6155a;
        String r6 = r3.b().toString();
        Intrinsics.checkNotNullExpressionValue(r6, "cfg.json.toString()");
        r5.b(r0, r6);
        return;
    L5:
        if (r2.exists() == true) goto L7;
        r1 = true;
        goto L7
    }

    private final void b(n.b r2) {
        monitor-enter(this);
        boolean r3 = t.a(this.g, r2);     // Catch: Throwable -> L8
        monitor-exit(this);
        if (r3 == false) goto L13;
        d();
        return;
    L13:
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public static final /* synthetic */ void b(s r0, File r1) {
        r0.b(r1);
    }

    private final void b(File r5) {
        if (r5.exists() == false) goto L22;
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L13
        File[] r6 = r5.listFiles($$Lambda$s$gx173n8ZGVBNrORSPPqWzqGB7Do.INSTANCE);     // Catch: Throwable -> L13
        if (r6 == null) goto L10;
        Intrinsics.checkNotNullExpressionValue(r6, "listFiles { f -> f.name.contains(\"_temp\") }");     // Catch: Throwable -> L13
        int r0 = 0;
        int r1 = r6.length;     // Catch: Throwable -> L13
    L7:
        if (r0 >= r1) goto L9;
        File r2 = r6[r0];     // Catch: Throwable -> L13
        Intrinsics.checkNotNullExpressionValue(r2, "it");     // Catch: Throwable -> L13
        FilesKt.deleteRecursively(r2);     // Catch: Throwable -> L13
        r0 = r0 + 1;     // Catch: Throwable -> L13
        goto L7
    L9:
        Unit r7 = Unit.INSTANCE;     // Catch: Throwable -> L13
    L11:
        Object r8 = Result.m1421constructorimpl(r7);     // Catch: Throwable -> L13
    L15:
        Throwable r9 = Result.m1424exceptionOrNullimpl(r8);
        if (r9 == null) goto L23;
        com.obric.aikernel.runtime.utils.d.f6216a.f("PackageUpdater", "cleanDownloadTmp " + r5 + " failed " + r9);
        return;
    L23:
        return;
    L10:
        r7 = null;
    L13:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        r8 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L15
    }

    private final com.obric.aikernel.res.downloader.a c(com.obric.aikernel.res.metadata.config.k r22) {
        if (r22 != null) goto L7;
        com.obric.aikernel.res.metadata.config.k r1 = this.g.getCfg();
        if (r1 != null) goto L9;
        r1 = f6149a.a(this.f6150b, this.e, this.d);
    L9:
        if (r1 == null) goto L21;
        List<com.obric.aikernel.res.metadata.config.a> r4 = r1.m();
        if (r4 == null) goto L21;
        Iterable r5 = (Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.memorydata.plugin");
        Collection r6 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r7 = r5.iterator();
    L14:
        if (r7.hasNext() == false) goto L20;
        com.obric.aikernel.res.metadata.config.a r8 = (com.obric.aikernel.res.metadata.config.a) ZeusTransformUtils.preCheckCast(r7.next(), com.obric.aikernel.res.metadata.config.a.class, "com.obric.memorydata.plugin");
        Iterable r9 = (Iterable) ZeusTransformUtils.preCheckCast(r8.e(), Iterable.class, "com.obric.memorydata.plugin");
        Collection r10 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r9, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r11 = r9.iterator();
    L17:
        if (r11.hasNext() == false) goto L19;
        r10.add(new c((com.obric.aikernel.res.metadata.config.c) ZeusTransformUtils.preCheckCast(r11.next(), com.obric.aikernel.res.metadata.config.c.class, "com.obric.memorydata.plugin"), r8.getType()));
        goto L17
    L19:
        CollectionsKt.addAll(r6, (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r10, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"));
        goto L14
    L20:
        List r12 = (List) ZeusTransformUtils.preCheckCast(r6, List.class, "com.obric.memorydata.plugin");
    L22:
        if (r12 != null) goto L24;
        r12 = CollectionsKt.emptyList();
    L24:
        Iterable r13 = (Iterable) ZeusTransformUtils.preCheckCast(r12, Iterable.class, "com.obric.memorydata.plugin");
        Collection r14 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r15 = r13.iterator();
    L26:
        if (r15.hasNext() == false) goto L30;
        Object r16 = r15.next();
        c r17 = (c) ZeusTransformUtils.preCheckCast(r16, c.class, "com.obric.memorydata.plugin");
        File r18 = new File(this.i, r17.a().o());
        if (t.a(new File(r18, r17.a().f()).exists(), new File(new File(r18, LBSLightLocationTraceLogger.ENCRYPT), r17.a().f()).exists()) == false) goto L26;
        r14.add(r16);
        goto L26
    L30:
        List r19 = (List) ZeusTransformUtils.preCheckCast(r14, List.class, "com.obric.memorydata.plugin");
        b r20 = a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.d.getConfig().getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
        boolean r21 = com.obric.aikernel.runtime.utils.h.f6225a.b((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.d.getConfig().getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
        Iterable r23 = (Iterable) ZeusTransformUtils.preCheckCast(r19, Iterable.class, "com.obric.memorydata.plugin");
        Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r23, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r24 = r23.iterator();
    L32:
        if (r24.hasNext() == false) goto L34;
        r2.add(TuplesKt.to(Boolean.valueOf(((c) ZeusTransformUtils.preCheckCast(r24.next(), c.class, "com.obric.memorydata.plugin")).a().l()), true));
        goto L32
    L34:
        boolean r3 = t.a((Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.memorydata.plugin"), Collection.class, "com.obric.memorydata.plugin"));
        if (com.obric.aikernel.runtime.utils.h.f6225a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.d.getConfig().getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")) == false) goto L37;
    L40:
        boolean r25 = true;
    L42:
        if (this.d.getConfig().getAppConfig().getCheckAssistantAutoUpdateSwitch() == true) goto L44;
    L46:
        boolean r110 = false;
    L47:
        boolean r111 = ((Boolean) ZeusTransformUtils.preCheckCast(this.d.getConfig().getAppConfig().getAllowNetworkRequest().invoke(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
        Iterable r112 = (Iterable) ZeusTransformUtils.preCheckCast(r19, Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r112, Collection.class) == true) goto L50;
    L52:
        Iterator r113 = r112.iterator();
    L54:
        if (r113.hasNext() == false) goto L51;
        if (((c) ZeusTransformUtils.preCheckCast(r113.next(), c.class, "com.obric.memorydata.plugin")).a().m() == false) goto L54;
        boolean r114 = true;
    L58:
        boolean r115 = this.g.getBackground();
        boolean r116 = ((Boolean) ZeusTransformUtils.preCheckCast(((Pair) ZeusTransformUtils.preCheckCast(this.d.getConfig().getAppConfig().getAllowBackgroundUpdate().c(), Pair.class, "com.obric.memorydata.plugin")).getFirst(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
        String r117 = (String) ZeusTransformUtils.preCheckCast(((Pair) ZeusTransformUtils.preCheckCast(this.d.getConfig().getAppConfig().getAllowBackgroundUpdate().c(), Pair.class, "com.obric.memorydata.plugin")).getSecond(), String.class, "com.obric.memorydata.plugin");
        Iterable r26 = (Iterable) ZeusTransformUtils.preCheckCast(r19, Iterable.class, "com.obric.memorydata.plugin");
        Collection r27 = (Collection) ZeusTransformUtils.preCheckCast((Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.memorydata.plugin"), Collection.class, "com.obric.memorydata.plugin");
        Iterator r28 = r26.iterator();
    L60:
        if (r28.hasNext() == false) goto L62;
        r27.add(((c) ZeusTransformUtils.preCheckCast(r28.next(), c.class, "com.obric.memorydata.plugin")).b());
        r28 = r28;
        goto L60
    L62:
        boolean r29 = r110;
        com.obric.aikernel.res.downloader.a r30 = com.obric.aikernel.res.downloader.b.a(new com.obric.aikernel.res.downloader.c(r111, true, r114, r115, r116, r117, (Set) ZeusTransformUtils.preCheckCast(r27, Set.class, "com.obric.memorydata.plugin"), r29, r21, r3, r25));
        if (r30.c() == false) goto L65;
    L69:
        com.obric.aikernel.runtime.utils.d r31 = com.obric.aikernel.runtime.utils.d.f6216a;
        StringBuilder r118 = new StringBuilder();
        r118.append("currentDownloadConstraintGate biz=").append(this.f6150b).append(" cfg=").append(b(r1)).append(" stage=").append(this.g.getStage()).append(" connectivitySnapshot=").append(r20).append(" directValidated=").append(r21).append(" directUnmetered=").append(r25).append(" allowBg=").append(this.d.getConfig().getAppConfig().getAllowBackgroundUpdate().c()).append(" assistantAutoUpdateBlocked=").append(r29).append(" requireUnmetered=").append(r3).append(" pendingDownloads=").append(CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(r19, Iterable.class, "com.obric.memorydata.plugin"), null, (CharSequence) ZeusTransformUtils.preCheckCast("[", CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("]", CharSequence.class, "com.obric.memorydata.plugin"), 0, null, (Function1) ZeusTransformUtils.preCheckCast(UpdateTask$currentDownloadConstraintGate$1$1.INSTANCE, Function1.class, "com.obric.memorydata.plugin"), 25, null)).append(" gate=").append(r30.a()).append(':');
        r118.append(r30.b());
        r31.a("PackageUpdater", r118.toString());
    L70:
        return r30;
    L65:
        if (r20.a() != r21) goto L69;
        if (r3 == false) goto L70;
        if (r20.b() == r25) goto L70;
    L51:
        r114 = false;
        goto L58
    L50:
        if (((Collection) ZeusTransformUtils.preCheckCast(r112, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L52;
    L44:
        if (com.obric.aikernel.res.a.f5999a.a() == false) goto L46;
        r110 = true;
        goto L47
    L37:
        if (com.obric.aikernel.runtime.utils.h.f6225a.c((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.d.getConfig().getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")) == true) goto L40;
        r25 = false;
    L21:
        r12 = null;
        goto L22
    L7:
        r1 = r22;
        goto L9
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:104:0x0617 -> B:105:0x0621). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:97:0x05f2 -> B:209:0x05fd). Please report as a decompilation issue!!! */
    private final Object c(Continuation<? super Boolean> r36) {
        Continuation r1 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r36, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r1, UpdateTask$doDownload$1.class) == false) goto L7;
        UpdateTask$doDownload$1 r3 = (UpdateTask$doDownload$1) ZeusTransformUtils.preCheckCast(r1, UpdateTask$doDownload$1.class, "com.obric.memorydata.plugin");
        if ((r3.label & Integer.MIN_VALUE) == 0) goto L7;
        r3.label -= Integer.MIN_VALUE;
    L8:
        Object r2 = r3.result;
        Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r3.label;
        String r6 = "doDownload: ";
        String r8 = " state=";
        String r9 = " downloadTask=";
        String r10 = " dist=";
        String r11 = " background=";
        String r13 = " lora=";
        if (r5 == 0) goto L18;
        if (r5 != 1) goto L17;
        Collection r7 = (Collection) ZeusTransformUtils.preCheckCast(r3.L$8, Collection.class, "com.obric.memorydata.plugin");
        final com.obric.aikernel.res.downloader.j r14 = (com.obric.aikernel.res.downloader.j) ZeusTransformUtils.preCheckCast(r3.L$7, com.obric.aikernel.res.downloader.j.class, "com.obric.memorydata.plugin");
        com.obric.aikernel.res.metadata.config.a r12 = (com.obric.aikernel.res.metadata.config.a) ZeusTransformUtils.preCheckCast(r3.L$6, com.obric.aikernel.res.metadata.config.a.class, "com.obric.memorydata.plugin");
        Iterator r15 = (Iterator) ZeusTransformUtils.preCheckCast(r3.L$5, Iterator.class, "com.obric.memorydata.plugin");
        Collection r16 = (Collection) ZeusTransformUtils.preCheckCast(r3.L$4, Collection.class, "com.obric.memorydata.plugin");
        List r17 = (List) ZeusTransformUtils.preCheckCast(r3.L$3, List.class, "com.obric.memorydata.plugin");
        Map<String, Set<com.obric.aikernel.res.downloader.j>> r18 = (Map) ZeusTransformUtils.preCheckCast(r3.L$2, Map.class, "com.obric.memorydata.plugin");
        com.obric.aikernel.res.metadata.config.k r19 = (com.obric.aikernel.res.metadata.config.k) ZeusTransformUtils.preCheckCast(r3.L$1, com.obric.aikernel.res.metadata.config.k.class, "com.obric.memorydata.plugin");
        UpdateTask$doDownload$1 r20 = r3;
        s r21 = (s) ZeusTransformUtils.preCheckCast(r3.L$0, s.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r2);     // Catch: Throwable -> L14
        String r22 = " state=";
        String r23 = " downloadTask=";
        String r24 = " background=";
        Collection r25 = r16;
        Collection r26 = r7;
        String r110 = " dist=";
        Map<String, Set<com.obric.aikernel.res.downloader.j>> r27 = r18;
        String r111 = "doDownload: ";
        Iterator r112 = r15;
        Object r28 = r4;
        List r29 = r17;
        String r113 = " lora=";
    L209:
        Object r0 = Result.m1421constructorimpl((Pair) ZeusTransformUtils.preCheckCast(r2, Pair.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L100
    L105:
        s r30 = r21;
        UpdateTask$doDownload$1 r31 = r20;
        Map<String, Set<com.obric.aikernel.res.downloader.j>> r34 = r27;
        com.obric.aikernel.res.metadata.config.k r32 = r19;
        Throwable r114 = Result.m1424exceptionOrNullimpl(r0);     // Catch: Throwable -> L132
        if (r114 == null) goto L113;
        UpdateTask$doDownload$1 r35 = r31;
        Map<String, Set<com.obric.aikernel.res.downloader.j>> r115 = r34;
        com.obric.aikernel.res.metadata.config.k r210 = r32;
        String r33 = r23;
        Object r211 = r28;
        String r37 = r22;
        Collection r212 = r25;
        com.obric.aikernel.runtime.utils.d.f6216a.c("PackageUpdater", new StringBuilder().append("doDownload await failed biz=").append(r30.f6150b).append(r110).append(r12.a()).append(r33).append(r14.a()).append(r37).append(r14.e()).append(' ').append(ExceptionsKt.stackTraceToString(r114)).toString());     // Catch: Throwable -> L132
        if (ZeusTransformUtils.instanceOf(r114, CancellationException.class) == false) goto L115;
        Iterator r38 = ((Iterable) ZeusTransformUtils.preCheckCast(r29, Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Throwable -> L132
    L111:
        if (r38.hasNext() == false) goto L115;
        ((com.obric.aikernel.res.downloader.j) ZeusTransformUtils.preCheckCast(((Pair) ZeusTransformUtils.preCheckCast(r38.next(), Pair.class, "com.obric.memorydata.plugin")).getSecond(), com.obric.aikernel.res.downloader.j.class, "com.obric.memorydata.plugin")).a(r30.h, (Function1) ZeusTransformUtils.preCheckCast(new UpdateTask$doDownload$awaitResults$1$ret$2$1$1(r14), Function1.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L132
        r38 = r38;
    L115:
        if (Result.m1427isFailureimpl(r0) == false) goto L117;
        r0 = null;
    L117:
        Pair r39 = (Pair) ZeusTransformUtils.preCheckCast(r0, Pair.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L132
        if (r39 != null) goto L120;
        r39 = new Pair(new Pair(Boxing.boxBoolean(false), Boxing.boxInt(r14.e())), CollectionsKt.emptyList());     // Catch: Throwable -> L132
    L120:
        r14.n();
        Pair r40 = (Pair) ZeusTransformUtils.preCheckCast(r39.getFirst(), Pair.class, "com.obric.memorydata.plugin");
        String r213 = r33;
        com.obric.aikernel.runtime.utils.d.f6216a.b("PackageUpdater", "doDownload await end biz=" + r30.f6150b + r110 + r12.a() + r33 + r14.a() + " success=" + ((Boolean) ZeusTransformUtils.preCheckCast(r40.getFirst(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() + r37 + ((Number) ZeusTransformUtils.preCheckCast(r40.getSecond(), Number.class, "com.obric.memorydata.plugin")).intValue() + " files=" + CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(r39.getSecond(), Iterable.class, "com.obric.memorydata.plugin"), null, null, null, 8, null, (Function1) ZeusTransformUtils.preCheckCast(UpdateTask$doDownload$awaitResults$1$1.INSTANCE, Function1.class, "com.obric.memorydata.plugin"), 23, null));
        String r116 = r111;
        com.obric.aikernel.runtime.utils.d.f6216a.a("PackageUpdater", r116 + r30.f6150b + ' ' + r12.a() + " downloadTask " + r14.a() + ' ' + r39);
        StringBuilder r41 = new StringBuilder().append(r39.getFirst());
        Iterable r42 = (Iterable) ZeusTransformUtils.preCheckCast(r39.getSecond(), Iterable.class, "com.obric.memorydata.plugin");
        Collection r43 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r42, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r44 = r42.iterator();
    L122:
        if (r44.hasNext() == false) goto L124;
        com.obric.aikernel.res.downloader.j.b r45 = (com.obric.aikernel.res.downloader.j.b) ZeusTransformUtils.preCheckCast(r44.next(), com.obric.aikernel.res.downloader.j.b.class, "com.obric.memorydata.plugin");
        r43.add(r45.a() + '-' + r45.k());
        r44 = r44;
        goto L122
    L124:
        Iterator r46 = ((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r43, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin")).iterator();
        if (r46.hasNext() == true) goto L127;
        Object r47 = null;
    L131:
        r26.add(new com.obric.aikernel.res.update.b(r12, r14, r40, r41.append((String) ZeusTransformUtils.preCheckCast(r47, String.class, "com.obric.memorydata.plugin")).toString()));
        UpdateTask$doDownload$1 r48 = r35;
        Iterator r49 = r112;
        String r310 = r110;
        Map<String, Set<com.obric.aikernel.res.downloader.j>> r50 = r115;
        s r51 = r30;
        com.obric.aikernel.res.metadata.config.k r52 = r210;
        r25 = r212;
        r22 = r37;
        r111 = r116;
        r13 = r113;
        r28 = r211;
        r23 = r213;
    L92:
        if (r49.hasNext() == false) goto L135;
        Pair r53 = (Pair) ZeusTransformUtils.preCheckCast(r49.next(), Pair.class, "com.obric.memorydata.plugin");
        r12 = (com.obric.aikernel.res.metadata.config.a) ZeusTransformUtils.preCheckCast(r53.component1(), com.obric.aikernel.res.metadata.config.a.class, "com.obric.memorydata.plugin");
        r14 = (com.obric.aikernel.res.downloader.j) ZeusTransformUtils.preCheckCast(r53.component2(), com.obric.aikernel.res.downloader.j.class, "com.obric.memorydata.plugin");
        r51.a(r14);
        r110 = r310;
        r113 = r13;
        com.obric.aikernel.runtime.utils.d.f6216a.b("PackageUpdater", new StringBuilder().append("doDownload await start biz=").append(r51.f6150b).append(r110).append(r12.a()).append(r23).append(r14.a()).append(r22).append(r14.e()).append(" prior=").append(r14.b()).append(r24).append(r14.c()).toString());
        Result.Companion r54 = Result.Companion;     // Catch: Throwable -> L102
        r48.L$0 = r51;     // Catch: Throwable -> L102
        r48.L$1 = r52;     // Catch: Throwable -> L102
        r48.L$2 = r50;     // Catch: Throwable -> L102
        r48.L$3 = r29;     // Catch: Throwable -> L102
        r48.L$4 = r25;     // Catch: Throwable -> L102
        r48.L$5 = r49;     // Catch: Throwable -> L102
        r48.L$6 = r12;     // Catch: Throwable -> L102
        r48.L$7 = r14;     // Catch: Throwable -> L102
        r48.L$8 = r25;     // Catch: Throwable -> L102
        r48.label = 1;     // Catch: Throwable -> L102
        Object r55 = r14.b(r48);     // Catch: Throwable -> L102
        if (r55 != r28) goto L97;
        return r28;
    L97:
        r20 = r48;
        r112 = r49;
        r21 = r51;
        r26 = r25;
        r2 = r55;
        com.obric.aikernel.res.metadata.config.k r311 = r52;
        r27 = r50;
        r19 = r311;
    L102:
        Throwable th = th;
        r20 = r48;
        r112 = r49;
        r21 = r51;
        r26 = r25;
        com.obric.aikernel.res.metadata.config.k r312 = r52;
        r27 = r50;
        r19 = r312;
    L205:
        Result.Companion r56 = Result.Companion;     // Catch: Throwable -> L132
        r0 = Result.m1421constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L132
        goto L105
    L135:
        String r117 = r13;
        String r118 = r111;
        List r57 = (List) ZeusTransformUtils.preCheckCast(r25, List.class, "com.obric.memorydata.plugin");
        Iterable r58 = (Iterable) ZeusTransformUtils.preCheckCast(r57, Iterable.class, "com.obric.memorydata.plugin");
        Map r59 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r58, 10)), 16)), Map.class, "com.obric.memorydata.plugin");
        Iterator r60 = r58.iterator();
    L137:
        if (r60.hasNext() == false) goto L139;
        com.obric.aikernel.res.update.b r61 = (com.obric.aikernel.res.update.b) ZeusTransformUtils.preCheckCast(r60.next(), com.obric.aikernel.res.update.b.class, "com.obric.memorydata.plugin");
        Pair r62 = TuplesKt.to(r61.a(), r61.b().getFirst());
        r59.put(r62.getFirst(), r62.getSecond());
        goto L137
    L139:
        Iterator<Map.Entry<String, Set<com.obric.aikernel.res.downloader.j>>> r63 = r50.entrySet().iterator();
    L141:
        if (r63.hasNext() == false) goto L166;
        Map.Entry r64 = (Map.Entry) ZeusTransformUtils.preCheckCast(r63.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        String r65 = (String) ZeusTransformUtils.preCheckCast(r64.getKey(), String.class, "com.obric.memorydata.plugin");
        Iterable r66 = (Iterable) ZeusTransformUtils.preCheckCast((Set) ZeusTransformUtils.preCheckCast(r64.getValue(), Set.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");
        Collection r67 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r68 = r66.iterator();
    L144:
        if (r68.hasNext() == false) goto L148;
        Object r69 = r68.next();
        if ((!Intrinsics.areEqual(r59.get((com.obric.aikernel.res.downloader.j) ZeusTransformUtils.preCheckCast(r69, com.obric.aikernel.res.downloader.j.class, "com.obric.memorydata.plugin")), Boxing.boxBoolean(true))) == false) goto L144;
        r67.add(r69);
        goto L144
    L148:
        List r70 = (List) ZeusTransformUtils.preCheckCast(r67, List.class, "com.obric.memorydata.plugin");
        if (r70.isEmpty() == true) goto L150;
        Iterable r71 = (Iterable) ZeusTransformUtils.preCheckCast(r70, Iterable.class, "com.obric.memorydata.plugin");
        Collection r72 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r71, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r73 = r71.iterator();
    L156:
        if (r73.hasNext() == false) goto L159;
        r72.add(Boxing.boxInt(((com.obric.aikernel.res.downloader.j) ZeusTransformUtils.preCheckCast(r73.next(), com.obric.aikernel.res.downloader.j.class, "com.obric.memorydata.plugin")).e()));
        goto L156
    L159:
        if (t.b((Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r72, List.class, "com.obric.memorydata.plugin"), Collection.class, "com.obric.memorydata.plugin")) == true) goto L160;
        l r74 = r51.f;
        if (r74 == null) goto L141;
        r74.c(r65);
    L153:
        Unit r75 = Unit.INSTANCE;
        goto L141
    L160:
        l r76 = r51.f;
        if (r76 == null) goto L141;
        r76.a(r65, 4);
        goto L153
    L150:
        l r77 = r51.f;
        if (r77 == null) goto L141;
        r77.d(r65);
        goto L153
    L166:
        Iterable r78 = (Iterable) ZeusTransformUtils.preCheckCast(r57, Iterable.class, "com.obric.memorydata.plugin");
        Collection r79 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r78, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r80 = r78.iterator();
    L168:
        if (r80.hasNext() == false) goto L170;
        com.obric.aikernel.res.update.b r81 = (com.obric.aikernel.res.update.b) ZeusTransformUtils.preCheckCast(r80.next(), com.obric.aikernel.res.update.b.class, "com.obric.memorydata.plugin");
        r79.add(TuplesKt.to(r81.b(), r81.c()));
        goto L168
    L170:
        Iterator r82 = ((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r79, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin")).iterator();
        if (r82.hasNext() == true) goto L173;
        Object r83 = null;
    L187:
        Pair r84 = (Pair) ZeusTransformUtils.preCheckCast(r83, Pair.class, "com.obric.memorydata.plugin");
        if (r84 != null) goto L190;
        com.obric.aikernel.runtime.utils.d r85 = com.obric.aikernel.runtime.utils.d.f6216a;
        StringBuilder r86 = new StringBuilder().append(r118).append(r51.f6150b).append(' ');
        com.obric.aikernel.res.metadata.config.k r87 = r51.g.getCfg();
        if (r87 == null) goto L199;
        String r119 = r87.c();
    L200:
        r85.b("PackageUpdater", r86.append(r119).append(" do nothing").toString());
        if (ZeusTransformUtils.instanceOf(r52, com.obric.aikernel.res.metadata.config.e.class) == false) goto L204;
        com.obric.aikernel.runtime.utils.d.f6216a.a("PackageUpdater", "doDownload lora no-op biz=" + r51.f6150b + r117 + r52.a() + '@' + r52.c() + " all resources ready or installer hit");
    L204:
        return Boxing.boxBoolean(true);
    L199:
        r119 = null;
        goto L200
    L190:
        if (((Boolean) ZeusTransformUtils.preCheckCast(((Pair) ZeusTransformUtils.preCheckCast(r84.getFirst(), Pair.class, "com.obric.memorydata.plugin")).getFirst(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == true) goto L195;
        r51.g.setStage(((Number) ZeusTransformUtils.preCheckCast(((Pair) ZeusTransformUtils.preCheckCast(r84.getFirst(), Pair.class, "com.obric.memorydata.plugin")).getSecond(), Number.class, "com.obric.memorydata.plugin")).intValue() + 200);
        r51.g.fail((String) ZeusTransformUtils.preCheckCast(r84.getSecond(), String.class, "com.obric.memorydata.plugin"));
        if (ZeusTransformUtils.instanceOf(r52, com.obric.aikernel.res.metadata.config.e.class) == false) goto L195;
        com.obric.aikernel.runtime.utils.d.f6216a.a("PackageUpdater", "doDownload lora failed biz=" + r51.f6150b + r117 + r52.a() + '@' + r52.c() + " stage=" + r51.g.getStage() + " msg=" + ((String) ZeusTransformUtils.preCheckCast(r84.getSecond(), String.class, "com.obric.memorydata.plugin")));
    L195:
        return ((Pair) ZeusTransformUtils.preCheckCast(r84.getFirst(), Pair.class, "com.obric.memorydata.plugin")).getFirst();
    L173:
        r83 = r82.next();
    L175:
        if (r82.hasNext() == false) goto L187;
        Pair r88 = (Pair) ZeusTransformUtils.preCheckCast(r82.next(), Pair.class, "com.obric.memorydata.plugin");
        Pair r89 = (Pair) ZeusTransformUtils.preCheckCast(r83, Pair.class, "com.obric.memorydata.plugin");
        if (((Boolean) ZeusTransformUtils.preCheckCast(((Pair) ZeusTransformUtils.preCheckCast(r89.getFirst(), Pair.class, "com.obric.memorydata.plugin")).getFirst(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == true) goto L179;
    L181:
        boolean r120 = false;
    L182:
        Boolean r90 = Boxing.boxBoolean(r120);
        if (((Number) ZeusTransformUtils.preCheckCast(((Pair) ZeusTransformUtils.preCheckCast(r88.getFirst(), Pair.class, "com.obric.memorydata.plugin")).getSecond(), Number.class, "com.obric.memorydata.plugin")).intValue() == 0) goto L185;
        Object r91 = r88.getFirst();
    L186:
        r83 = new Pair(new Pair(r90, Boxing.boxInt(((Number) ZeusTransformUtils.preCheckCast(((Pair) ZeusTransformUtils.preCheckCast(r91, Pair.class, "com.obric.memorydata.plugin")).getSecond(), Number.class, "com.obric.memorydata.plugin")).intValue())), ((String) ZeusTransformUtils.preCheckCast(r89.getSecond(), String.class, "com.obric.memorydata.plugin")) + ' ' + ((String) ZeusTransformUtils.preCheckCast(r88.getSecond(), String.class, "com.obric.memorydata.plugin")));
        goto L175
    L185:
        r91 = r89.getFirst();
        goto L186
    L179:
        if (((Boolean) ZeusTransformUtils.preCheckCast(((Pair) ZeusTransformUtils.preCheckCast(r88.getFirst(), Pair.class, "com.obric.memorydata.plugin")).getFirst(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L181;
        r120 = true;
        goto L182
    L127:
        r47 = r46.next();
    L129:
        if (r46.hasNext() == false) goto L131;
        String r92 = (String) ZeusTransformUtils.preCheckCast(r46.next(), String.class, "com.obric.memorydata.plugin");
        r47 = ((String) ZeusTransformUtils.preCheckCast(r47, String.class, "com.obric.memorydata.plugin")) + ' ' + r92;
        goto L129
    L113:
        r35 = r31;
        r115 = r34;
        r210 = r32;
        r33 = r23;
        r211 = r28;
        r37 = r22;
        r212 = r25;
    L132:
        th = move-exception;
        r14.n();
        throw th;
    L100:
        th = th;
    L14:
        th = th;
        r22 = " state=";
        r23 = " downloadTask=";
        r24 = " background=";
        r25 = r16;
        r26 = r7;
        r110 = " dist=";
        r27 = r18;
        r111 = "doDownload: ";
        r112 = r15;
        r28 = r4;
        r29 = r17;
        r113 = " lora=";
        goto L205
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        UpdateTask$doDownload$1 r214 = r3;
        ResultKt.throwOnFailure(r2);
        com.obric.aikernel.runtime.utils.d.f6216a.b("PackageUpdater", "doDownload start biz=" + this.f6150b + " cfg=" + b(this.g.getCfg()) + " background=" + this.g.getBackground());
        this.g.setStage(200);
        com.obric.aikernel.res.metadata.config.k r93 = this.g.getCfg();
        Intrinsics.checkNotNull(r93);
        if (ZeusTransformUtils.instanceOf(r93, com.obric.aikernel.res.metadata.config.e.class) == false) goto L21;
        com.obric.aikernel.runtime.utils.d.f6216a.a("PackageUpdater", "doDownload lora start biz=" + this.f6150b + " lora=" + r93.a() + '@' + r93.c() + " models=" + ((com.obric.aikernel.res.metadata.config.e) ZeusTransformUtils.preCheckCast(r93, com.obric.aikernel.res.metadata.config.e.class, "com.obric.memorydata.plugin")).k() + " background=" + this.g.getBackground());
    L21:
        Map<String, Set<com.obric.aikernel.res.downloader.j>> r94 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        Iterable r95 = (Iterable) ZeusTransformUtils.preCheckCast(r93.m(), Iterable.class, "com.obric.memorydata.plugin");
        Collection r96 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r97 = r95.iterator();
    L23:
        if (r97.hasNext() == false) goto L70;
        com.obric.aikernel.res.metadata.config.a r98 = (com.obric.aikernel.res.metadata.config.a) ZeusTransformUtils.preCheckCast(r97.next(), com.obric.aikernel.res.metadata.config.a.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r98, com.obric.aikernel.res.metadata.config.j.class) == false) goto L27;
        String r121 = r93.c();
    L28:
        boolean r122 = r98.a(this.d);
        Iterator r123 = r97;
        String r124 = r6;
        if (r122 == true) goto L31;
    L33:
        boolean r99 = false;
    L35:
        if (ZeusTransformUtils.instanceOf(r93, com.obric.aikernel.res.metadata.config.e.class) == false) goto L40;
        if (ZeusTransformUtils.instanceOf(r98, com.obric.aikernel.res.metadata.config.h.class) == false) goto L40;
        com.obric.aikernel.runtime.utils.d.f6216a.a("PackageUpdater", "doDownload lora model biz=" + this.f6150b + " lora=" + r93.a() + '@' + r93.c() + " model=" + r98.a() + '@' + r98.c() + " needDownload=" + r122 + " installFromInstaller=" + r99 + " from=" + r98.d() + " downloadables=" + a(r98));
    L40:
        if (r122 == true) goto L42;
    L59:
        String r313 = r10;
        if (ZeusTransformUtils.instanceOf(r93, com.obric.aikernel.res.metadata.config.e.class) == true) goto L62;
    L68:
        List r100 = CollectionsKt.emptyList();
    L69:
        CollectionsKt.addAll(r96, (Iterable) ZeusTransformUtils.preCheckCast(r100, Iterable.class, "com.obric.memorydata.plugin"));
        r97 = r123;
        r6 = r124;
        r11 = r11;
        r8 = r8;
        r9 = r9;
        r10 = r313;
        goto L23
    L62:
        if (ZeusTransformUtils.instanceOf(r98, com.obric.aikernel.res.metadata.config.h.class) == false) goto L68;
        com.obric.aikernel.runtime.utils.d r101 = com.obric.aikernel.runtime.utils.d.f6216a;
        StringBuilder r102 = new StringBuilder().append("doDownload lora model skip biz=").append(this.f6150b).append(" lora=").append(r93.a()).append('@').append(r93.c()).append(" model=").append(r98.a()).append('@').append(r98.c()).append(" reason=");
        if (r122 == true) goto L66;
        String r103 = "needDownload=false";
    L67:
        r101.a("PackageUpdater", r102.append(r103).toString());
        goto L68
    L66:
        r103 = "installer_hit";
        goto L67
    L42:
        if (Intrinsics.areEqual(r98.d(), "debug") == true) goto L44;
        if (r99 == true) goto L59;
    L44:
        Iterable r104 = (Iterable) ZeusTransformUtils.preCheckCast(r98.e(), Iterable.class, "com.obric.memorydata.plugin");
        Collection r105 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r104, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r106 = r104.iterator();
    L46:
        if (r106.hasNext() == false) goto L58;
        com.obric.aikernel.res.metadata.config.c r107 = (com.obric.aikernel.res.metadata.config.c) ZeusTransformUtils.preCheckCast(r106.next(), com.obric.aikernel.res.metadata.config.c.class, "com.obric.memorydata.plugin");
        String r108 = r107.o();
        String r125 = this.i + '/' + r108;
        boolean r126 = r107.a(this.d.getConfig().getDecryptFeature());
        Iterator r215 = r106;
        if (new File(r125, r107.f()).exists() == false) goto L50;
        r126 = false;
    L50:
        StringBuilder r109 = new StringBuilder().append(r125);
        if (r126 == false) goto L53;
        String r127 = "/encrypt";
    L54:
        String r128 = r109.append(r127).toString();
        String r314 = r10;
        com.obric.aikernel.res.downloader.j r129 = this.d.getDownloadCtrl$resource_manager_release().a(this.d.getConfig(), this.h, r108, com.obric.aikernel.res.metadata.config.a.a((com.obric.aikernel.res.metadata.config.a) ZeusTransformUtils.preCheckCast(r107, com.obric.aikernel.res.metadata.config.a.class, "com.obric.memorydata.plugin"), r128, r128 + "/tmp", 0, r98.getType(), 4, null));
        com.obric.aikernel.runtime.utils.d.f6216a.a("PackageUpdater", "task " + r129 + " prepare to download " + r128);
        if (ZeusTransformUtils.instanceOf(r98, com.obric.aikernel.res.metadata.config.h.class) == false) goto L57;
        a(r93, (com.obric.aikernel.res.metadata.config.h) ZeusTransformUtils.preCheckCast(r98, com.obric.aikernel.res.metadata.config.h.class, "com.obric.memorydata.plugin"), r129, r94);
    L57:
        r105.add(new Pair(r98, r129));
        r106 = r215;
        r10 = r314;
        goto L46
    L53:
        r127 = "";
        goto L54
    L58:
        r313 = r10;
        r100 = (List) ZeusTransformUtils.preCheckCast(r105, List.class, "com.obric.memorydata.plugin");
        goto L69
    L31:
        if (Intrinsics.areEqual(r98.d(), "debug") == true) goto L33;
        r99 = this.d.tryInstallFromInstaller(r98.getType(), r98.a(), r121);
        goto L35
    L27:
        r121 = r98.c();
        goto L28
    L70:
        r111 = r6;
        r22 = r8;
        r23 = r9;
        r310 = r10;
        r24 = r11;
        List r130 = (List) ZeusTransformUtils.preCheckCast(r96, List.class, "com.obric.memorydata.plugin");
        if (com.obric.aikernel.res.a.f5999a.a() == false) goto L86;
        Iterable r131 = (Iterable) ZeusTransformUtils.preCheckCast(r130, Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r131, Collection.class) == true) goto L75;
    L77:
        Iterator r132 = r131.iterator();
    L79:
        if (r132.hasNext() == false) goto L76;
        if (ZeusTransformUtils.instanceOf((com.obric.aikernel.res.metadata.config.a) ZeusTransformUtils.preCheckCast(((Pair) ZeusTransformUtils.preCheckCast(r132.next(), Pair.class, "com.obric.memorydata.plugin")).component1(), com.obric.aikernel.res.metadata.config.a.class, "com.obric.memorydata.plugin"), com.obric.aikernel.res.metadata.config.h.class) == false) goto L79;
        boolean r133 = true;
    L83:
        if (r133 == false) goto L86;
        this.g.setStage(Constants.UPLOAD_HTTP_ERROR);
        this.g.fail("assistant auto-update gate disallowed");
        return Boxing.boxBoolean(false);
    L76:
        r133 = false;
        goto L83
    L75:
        if (((Collection) ZeusTransformUtils.preCheckCast(r131, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L77;
    L86:
        Iterator r134 = ((Iterable) ZeusTransformUtils.preCheckCast(r130, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L88:
        if (r134.hasNext() == false) goto L90;
        a((com.obric.aikernel.res.downloader.j) ZeusTransformUtils.preCheckCast(((Pair) ZeusTransformUtils.preCheckCast(r134.next(), Pair.class, "com.obric.memorydata.plugin")).component2(), com.obric.aikernel.res.downloader.j.class, "com.obric.memorydata.plugin"));
        goto L88
    L90:
        d();
        Iterable r135 = (Iterable) ZeusTransformUtils.preCheckCast(r130, Iterable.class, "com.obric.memorydata.plugin");
        Collection r136 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r135, 10)), Collection.class, "com.obric.memorydata.plugin");
        r49 = r135.iterator();
        r25 = r136;
        r28 = r4;
        r52 = r93;
        r29 = r130;
        r51 = this;
        r50 = r94;
        r48 = r214;
    L7:
        r3 = new UpdateTask$doDownload$1(this, r1);
        goto L8
    }

    public static final /* synthetic */ String c(s r0) {
        return r0.h;
    }

    private static final boolean c(File r4) {
        String r5 = r4.getName();
        Intrinsics.checkNotNullExpressionValue(r5, "f.name");
        return StringsKt.contains$default((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("_temp", CharSequence.class, "com.obric.memorydata.plugin"), false, 2, null);
    }

    /* JADX WARN: Type inference failed for: r13v5, types: [T, kotlin.Pair] */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v10, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r9v11, types: [T, kotlin.Pair] */
    /* JADX WARN: Type inference failed for: r9v13, types: [T, kotlin.Pair] */
    /* JADX WARN: Type inference failed for: r9v18 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:33:0x02b5 -> B:49:0x03d6). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:46:0x03bc -> B:47:0x03be). Please report as a decompilation issue!!! */
    private final Object d(Continuation<? super Boolean> r30) {
        s r0 = this;
        Continuation r2 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r30, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r2, UpdateTask$doProcessFiles$1.class) == false) goto L7;
        UpdateTask$doProcessFiles$1 r4 = (UpdateTask$doProcessFiles$1) ZeusTransformUtils.preCheckCast(r2, UpdateTask$doProcessFiles$1.class, "com.obric.memorydata.plugin");
        if ((r4.label & Integer.MIN_VALUE) == 0) goto L7;
        r4.label -= Integer.MIN_VALUE;
    L8:
        Object r3 = r4.result;
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r6 = r4.label;
        String r7 = "_temp";
        char r8 = 2;
        ?? r9 = 1;
        if (r6 == 0) goto L16;
        if (r6 == 1) goto L15;
        if (r6 != 2) goto L14;
        Collection r1 = (Collection) ZeusTransformUtils.preCheckCast(r4.L$5, Collection.class, "com.obric.memorydata.plugin");
        Iterator r10 = (Iterator) ZeusTransformUtils.preCheckCast(r4.L$4, Iterator.class, "com.obric.memorydata.plugin");
        Ref.ObjectRef r11 = (Ref.ObjectRef) ZeusTransformUtils.preCheckCast(r4.L$3, Ref.ObjectRef.class, "com.obric.memorydata.plugin");
        Iterator r12 = (Iterator) ZeusTransformUtils.preCheckCast(r4.L$2, Iterator.class, "com.obric.memorydata.plugin");
        Collection r13 = (Collection) ZeusTransformUtils.preCheckCast(r4.L$1, Collection.class, "com.obric.memorydata.plugin");
        s r14 = (s) ZeusTransformUtils.preCheckCast(r4.L$0, s.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r3);
        String r17 = "_temp";
        Ref.ObjectRef r15 = r11;
        Iterator r16 = r12;
        Collection r18 = r13;
    L47:
        String r21 = r17;
    L42:
        if (r10.hasNext() == false) goto L48;
        com.obric.aikernel.res.metadata.config.c r19 = (com.obric.aikernel.res.metadata.config.c) ZeusTransformUtils.preCheckCast(r10.next(), com.obric.aikernel.res.metadata.config.c.class, "com.obric.memorydata.plugin");
        File r110 = new File(r14.i, r19.o());
        File r20 = new File(r110, r19.f());
        File r111 = new File(r20.getPath() + r21);
        File r112 = new File(r110, r19.f() + ".zip");
        com.obric.aikernel.res.task.a r22 = com.obric.aikernel.res.task.a.f6099a;
        String r113 = r19.o();
        r17 = r21;
        Object r114 = r5;
        Collection r23 = r18;
        Function1 r24 = (Function1) ZeusTransformUtils.preCheckCast(new UpdateTask$doProcessFiles$2$2$1(r20, r112, r111, r15, r110, null), Function1.class, "com.obric.memorydata.plugin");
        r4.L$0 = r14;
        r4.L$1 = r23;
        r4.L$2 = r16;
        r4.L$3 = r15;
        r4.L$4 = r10;
        r4.L$5 = r1;
        r4.L$6 = null;
        r4.L$7 = null;
        r4.label = 2;
        if (r22.a(r113, r24, r4) != r114) goto L46;
        return r114;
    L46:
        r18 = r23;
        r5 = r114;
        goto L47
    L48:
        Object r25 = r5;
        Collection r26 = r18;
        String r115 = r21;
        char r27 = 2;
        Pair r28 = (Pair) ZeusTransformUtils.preCheckCast(r15.element, Pair.class, "com.obric.memorydata.plugin");
        Collection r29 = r1;
        r0 = r14;
        Iterator r31 = r16;
    L49:
        r29.add(r28);
        r29 = r26;
        r5 = r25;
        r8 = r27;
        r7 = r115;
        r9 = 1;
    L18:
        if (r31.hasNext() == false) goto L50;
        com.obric.aikernel.res.metadata.config.a r32 = (com.obric.aikernel.res.metadata.config.a) ZeusTransformUtils.preCheckCast(r31.next(), com.obric.aikernel.res.metadata.config.a.class, "com.obric.memorydata.plugin");
        UpdateResult r116 = r0.g;
        r116.setStage(r116.getStage() + r9);
        if (r32.a(r0.d) == true) goto L24;
        r28 = new Pair(Boxing.boxBoolean(r9), "");
        r115 = r7;
        r27 = r8;
        r25 = r5;
        r26 = r29;
        goto L49
    L24:
        if (ZeusTransformUtils.instanceOf(r32, com.obric.aikernel.res.metadata.config.h.class) == false) goto L34;
        String r117 = r0.d.getConfig().getResRootDir() + "/models/" + r32.a() + '/' + r32.c() + '/' + r32.a();
        Ref.ObjectRef r118 = new Ref.ObjectRef();
        r118.element = new Pair(Boxing.boxBoolean(r9), "");
        Iterator r119 = r31;
        com.obric.aikernel.res.metadata.config.a r120 = r32;
        String r121 = r117;
        Iterator r33 = ((Iterable) ZeusTransformUtils.preCheckCast(r32.e(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
        s r34 = r0;
        Collection r35 = r29;
        Ref.ObjectRef r36 = r118;
        Collection r122 = r35;
    L27:
        if (r33.hasNext() == false) goto L33;
        com.obric.aikernel.res.metadata.config.c r123 = (com.obric.aikernel.res.metadata.config.c) ZeusTransformUtils.preCheckCast(r33.next(), com.obric.aikernel.res.metadata.config.c.class, "com.obric.memorydata.plugin");
        File r124 = new File(r34.i, r123.o());
        File r37 = new File(r124, r123.f());
        Collection r210 = r122;
        File r125 = new File(r37.getPath() + r7);
        File r38 = new File(r124, LBSLightLocationTraceLogger.ENCRYPT);
        File r126 = new File(r38, r123.f());
        com.obric.aikernel.res.task.a r127 = com.obric.aikernel.res.task.a.f6099a;
        String r211 = r7;
        String r39 = r123.o();
        Object r212 = r5;
        Collection r213 = r35;
        Iterator r40 = r119;
        com.obric.aikernel.res.metadata.config.a r214 = r120;
        String r215 = r121;
        Function1 r41 = (Function1) ZeusTransformUtils.preCheckCast(new UpdateTask$doProcessFiles$2$1$1(r126, r123, r34, r36, r214, r215, r125, r38, r37, null), Function1.class, "com.obric.memorydata.plugin");
        r4.L$0 = r34;
        r4.L$1 = r210;
        r4.L$2 = r40;
        r4.L$3 = r214;
        r4.L$4 = r215;
        r4.L$5 = r36;
        r4.L$6 = r33;
        r4.L$7 = r213;
        r4.label = 1;
        if (r127.a(r39, r41, r4) == r212) goto L30;
        r119 = r40;
        r122 = r210;
        r120 = r214;
        r35 = r213;
        r121 = r215;
        r5 = r212;
        r7 = r211;
        goto L27
    L30:
        return r212;
    L33:
        Object r128 = r5;
        r28 = (Pair) ZeusTransformUtils.preCheckCast(r36.element, Pair.class, "com.obric.memorydata.plugin");
        r26 = r122;
        r29 = r35;
        r25 = r128;
        r115 = r7;
        r27 = 2;
        s r216 = r34;
        r31 = r119;
        r0 = r216;
        goto L49
    L34:
        r21 = r7;
        if (ZeusTransformUtils.instanceOf(r32, com.obric.aikernel.res.metadata.config.j.class) == true) goto L40;
        Ref.ObjectRef r42 = new Ref.ObjectRef();
        r42.element = new Pair(Boxing.boxBoolean(true), "");
        r10 = ((Iterable) ZeusTransformUtils.preCheckCast(r32.e(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
        r16 = r31;
        r18 = r29;
        r14 = r0;
        r1 = r18;
        r15 = r42;
        goto L42
    L37:
        if (ZeusTransformUtils.instanceOf(r32, com.obric.aikernel.res.metadata.config.d.class) == true) goto L40;
        r28 = new Pair(Boxing.boxBoolean(true), "");
        r25 = r5;
        r115 = r21;
        r27 = 2;
        r26 = r29;
        goto L49
    L40:
        Ref.ObjectRef r43 = new Ref.ObjectRef();
        r43.element = new Pair(Boxing.boxBoolean(true), "");
        r10 = ((Iterable) ZeusTransformUtils.preCheckCast(r32.e(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
        r16 = r31;
        r18 = r29;
        r14 = r0;
        r1 = r18;
        r15 = r43;
        goto L42
    L50:
        Iterator r44 = ((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r29, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin")).iterator();
        if (r44.hasNext() == false) goto L68;
        Object r45 = r44.next();
    L54:
        if (r44.hasNext() == false) goto L62;
        Pair r46 = (Pair) ZeusTransformUtils.preCheckCast(r44.next(), Pair.class, "com.obric.memorydata.plugin");
        Pair r47 = (Pair) ZeusTransformUtils.preCheckCast(r45, Pair.class, "com.obric.memorydata.plugin");
        if (((Boolean) ZeusTransformUtils.preCheckCast(r47.getFirst(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == true) goto L58;
    L60:
        boolean r129 = false;
    L61:
        r45 = new Pair(Boxing.boxBoolean(r129), ((String) ZeusTransformUtils.preCheckCast(r47.getSecond(), String.class, "com.obric.memorydata.plugin")) + ' ' + ((String) ZeusTransformUtils.preCheckCast(r46.getSecond(), String.class, "com.obric.memorydata.plugin")));
        goto L54
    L58:
        if (((Boolean) ZeusTransformUtils.preCheckCast(r46.getFirst(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L60;
        r129 = true;
        goto L61
    L62:
        Pair r48 = (Pair) ZeusTransformUtils.preCheckCast(r45, Pair.class, "com.obric.memorydata.plugin");
        if (((Boolean) ZeusTransformUtils.preCheckCast(r48.getFirst(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == true) goto L66;
        r0.g.fail((String) ZeusTransformUtils.preCheckCast(r48.getSecond(), String.class, "com.obric.memorydata.plugin"));
    L66:
        return r48.getFirst();
    L68:
        throw new UnsupportedOperationException("Empty collection can't be reduced.");
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r35 = (Collection) ZeusTransformUtils.preCheckCast(r4.L$7, Collection.class, "com.obric.memorydata.plugin");
        r33 = (Iterator) ZeusTransformUtils.preCheckCast(r4.L$6, Iterator.class, "com.obric.memorydata.plugin");
        Ref.ObjectRef r130 = (Ref.ObjectRef) ZeusTransformUtils.preCheckCast(r4.L$5, Ref.ObjectRef.class, "com.obric.memorydata.plugin");
        String r131 = (String) ZeusTransformUtils.preCheckCast(r4.L$4, String.class, "com.obric.memorydata.plugin");
        com.obric.aikernel.res.metadata.config.a r132 = (com.obric.aikernel.res.metadata.config.a) ZeusTransformUtils.preCheckCast(r4.L$3, com.obric.aikernel.res.metadata.config.a.class, "com.obric.memorydata.plugin");
        r119 = (Iterator) ZeusTransformUtils.preCheckCast(r4.L$2, Iterator.class, "com.obric.memorydata.plugin");
        Collection r133 = (Collection) ZeusTransformUtils.preCheckCast(r4.L$1, Collection.class, "com.obric.memorydata.plugin");
        r34 = (s) ZeusTransformUtils.preCheckCast(r4.L$0, s.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r3);
        r36 = r130;
        r121 = r131;
        r120 = r132;
        r122 = r133;
        r7 = "_temp";
        goto L27
    L16:
        ResultKt.throwOnFailure(r3);
        com.obric.aikernel.runtime.utils.d.f6216a.b("PackageUpdater", "doProcessFiles start biz=" + r0.f6150b + " cfg=" + r0.b(r0.g.getCfg()));
        r0.g.setStage(300);
        com.obric.aikernel.res.metadata.config.k r49 = r0.g.getCfg();
        Intrinsics.checkNotNull(r49);
        Iterable r50 = (Iterable) ZeusTransformUtils.preCheckCast(r49.m(), Iterable.class, "com.obric.memorydata.plugin");
        r29 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r50, 10)), Collection.class, "com.obric.memorydata.plugin");
        r31 = r50.iterator();
    L7:
        r4 = new UpdateTask$doProcessFiles$1(r0, r2);
        goto L8
    }

    public static final /* synthetic */ String d(s r0) {
        return r0.f6150b;
    }

    private final void d() {
        this.d.getDownloadCtrl$resource_manager_release().a(this.h, this.g.getPrior(), this.g.getBackground());
    }

    public static final /* synthetic */ Set e(s r0) {
        return r0.m;
    }

    private final Pair<Integer, Boolean> e() {
        monitor-enter(this);
        Pair<Integer, Boolean> r0 = TuplesKt.to(Integer.valueOf(this.g.getPrior()), Boolean.valueOf(this.g.getBackground()));     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    private final Integer f() {
        if (this.g.getFinished() == true) goto L5;
        return null;
    L5:
        if (this.g.getStage() < 200) goto L13;
        Integer r3 = Integer.valueOf(this.g.getStage() - 200);
        if (com.obric.aikernel.res.downloader.b.a(((Number) ZeusTransformUtils.preCheckCast(r3, Number.class, "com.obric.memorydata.plugin")).intValue()) == true) goto L10;
        return null;
    L10:
        return r3;
    L13:
        return null;
    }

    private final boolean g() {
        com.obric.aikernel.runtime.utils.d.f6216a.b("PackageUpdater", "doInstall start biz=" + this.f6150b + " cfg=" + b(this.g.getCfg()));
        this.g.setStage(400);
        com.obric.aikernel.res.metadata.config.k r0 = this.g.getCfg();
        Intrinsics.checkNotNull(r0);
        Iterable r1 = (Iterable) ZeusTransformUtils.preCheckCast(r0.m(), Iterable.class, "com.obric.memorydata.plugin");
        Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r1, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r3 = r1.iterator();
        String r6 = null;
        com.obric.aikernel.res.metadata.config.a r7 = null;
    L3:
        boolean r10 = false;
        if (r3.hasNext() == false) goto L17;
        com.obric.aikernel.res.metadata.config.a r8 = (com.obric.aikernel.res.metadata.config.a) ZeusTransformUtils.preCheckCast(r3.next(), com.obric.aikernel.res.metadata.config.a.class, "com.obric.memorydata.plugin");
        UpdateResult r11 = this.g;
        r11.setStage(r11.getStage() + 1);
        if (ZeusTransformUtils.instanceOf(r8, com.obric.aikernel.res.metadata.config.j.class) == false) goto L9;
        Pair<Boolean, String> r9 = new Pair(true, "");
    L16:
        r2.add(r9);
        r7 = r8;
        goto L3
    L9:
        if (ZeusTransformUtils.instanceOf(r8, com.obric.aikernel.res.metadata.config.d.class) == false) goto L13;
        String r12 = "lib";
    L11:
        Pair<Boolean, String> r13 = a(r12, r8);
        r8 = r7;
        r9 = r13;
        goto L16
    L13:
        if (ZeusTransformUtils.instanceOf(r8, com.obric.aikernel.res.metadata.config.h.class) == false) goto L15;
        r12 = "model";
        goto L11
    L15:
        Pair<Boolean, String> r14 = new Pair(false, "not support type " + r8.getClass());
        r8 = r7;
        r9 = r14;
        goto L16
    L17:
        Iterator r4 = ((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin")).iterator();
        if (r4.hasNext() == false) goto L65;
        Object r5 = r4.next();
    L21:
        if (r4.hasNext() == false) goto L29;
        Pair r15 = (Pair) ZeusTransformUtils.preCheckCast(r4.next(), Pair.class, "com.obric.memorydata.plugin");
        Pair r16 = (Pair) ZeusTransformUtils.preCheckCast(r5, Pair.class, "com.obric.memorydata.plugin");
        if (((Boolean) ZeusTransformUtils.preCheckCast(r16.getFirst(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == true) goto L25;
    L27:
        boolean r17 = false;
    L28:
        r5 = new Pair(Boolean.valueOf(r17), ((String) ZeusTransformUtils.preCheckCast(r16.getSecond(), String.class, "com.obric.memorydata.plugin")) + ' ' + ((String) ZeusTransformUtils.preCheckCast(r15.getSecond(), String.class, "com.obric.memorydata.plugin")));
        goto L21
    L25:
        if (((Boolean) ZeusTransformUtils.preCheckCast(r15.getFirst(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L27;
        r17 = true;
        goto L28
    L29:
        Pair r18 = (Pair) ZeusTransformUtils.preCheckCast(r5, Pair.class, "com.obric.memorydata.plugin");
        if (((Boolean) ZeusTransformUtils.preCheckCast(r18.getFirst(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == true) goto L34;
        this.g.fail((String) ZeusTransformUtils.preCheckCast(r18.getSecond(), String.class, "com.obric.memorydata.plugin"));
        return false;
    L34:
        if (ZeusTransformUtils.instanceOf(this.g.getCfg(), com.obric.aikernel.res.metadata.config.i.class) == false) goto L40;
        if (r7 != null) goto L37;
        Intrinsics.throwUninitializedPropertyAccessException("handlerConfig");
        com.obric.aikernel.res.metadata.config.j r19 = null;
    L38:
        r10 = a(r19);
    L42:
        com.obric.aikernel.res.metadata.config.k r20 = this.g.getCfg();
        if (r20 == null) goto L45;
        String r21 = r20.getType();
    L46:
        com.obric.aikernel.res.metadata.config.k r22 = this.g.getCfg();
        if (r22 == null) goto L49;
        r6 = r22.c();
    L49:
        com.obric.aikernel.runtime.utils.d.f6216a.b("PackageUpdater", "install " + r21 + ' ' + this.f6150b + '@' + r6 + ' ' + r10);
        if (r10 == true) goto L52;
    L63:
        return r10;
    L52:
        if (this.j.exists() == false) goto L63;
        Result.Companion r23 = Result.Companion;     // Catch: Throwable -> L55
        Object r24 = Result.m1421constructorimpl(Boolean.valueOf(FilesKt.deleteRecursively(((s) ZeusTransformUtils.preCheckCast(this, s.class, "com.obric.memorydata.plugin")).j)));     // Catch: Throwable -> L55
    L58:
        if (Result.m1428isSuccessimpl(r24) == false) goto L60;
        com.obric.aikernel.runtime.utils.d.f6216a.b("PackageUpdater", "doInstall delete pending config dir biz=" + this.f6150b + " cfg=" + b(this.g.getCfg()) + " path=" + this.j.getPath() + " deleted=" + ((Boolean) ZeusTransformUtils.preCheckCast(r24, Boolean.class, "com.obric.memorydata.plugin")).booleanValue() + " exists=" + this.j.exists());
    L60:
        Throwable r25 = Result.m1424exceptionOrNullimpl(r24);
        if (r25 == null) goto L63;
        com.obric.aikernel.runtime.utils.d.f6216a.f("PackageUpdater", "doInstall delete " + this.j + " failed " + r25);
    L55:
        th = move-exception;
        Result.Companion r26 = Result.Companion;
        r24 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L58
    L45:
        r21 = null;
        goto L46
    L37:
        r19 = (com.obric.aikernel.res.metadata.config.j) ZeusTransformUtils.preCheckCast(r7, com.obric.aikernel.res.metadata.config.j.class, "com.obric.memorydata.plugin");
        goto L38
    L40:
        if (ZeusTransformUtils.instanceOf(this.g.getCfg(), com.obric.aikernel.res.metadata.config.e.class) == false) goto L42;
        r10 = h();
        goto L42
    L65:
        throw new UnsupportedOperationException("Empty collection can't be reduced.");
    }

    private final boolean h() {
        com.obric.aikernel.res.metadata.config.k r0 = this.g.getCfg();
        Intrinsics.checkNotNull(r0);
        final String r4 = r0.c();
        return com.obric.aikernel.res.metadata.controller.a.a(this.d.getMetadataCtrl$resource_manager_release(), "lora", this.f6150b, r4, false, false, (Function1) ZeusTransformUtils.preCheckCast(new UpdateTask$installLora$1(this, r4), Function1.class, "com.obric.memorydata.plugin"), 24, null);
    }

    public static /* synthetic */ boolean lambda$gx173n8ZGVBNrORSPPqWzqGB7Do(File r0) {
        return c(r0);
    }

    public final UpdateResult a() {
        return this.g;
    }

    public final Object a(Continuation<? super UpdateResult> r6) {
        Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r7, UpdateTask$await$1.class) == false) goto L7;
        UpdateTask$await$1 r0 = (UpdateTask$await$1) ZeusTransformUtils.preCheckCast(r7, UpdateTask$await$1.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r8 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        s this = (s) ZeusTransformUtils.preCheckCast(r0.L$0, s.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r8);
    L19:
        UpdateResult r9 = (UpdateResult) ZeusTransformUtils.preCheckCast(r8, UpdateResult.class, "com.obric.memorydata.plugin");
        if (r9 == null) goto L22;
        return r9;
    L22:
        return this.g;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r8);
        ar<UpdateResult> r10 = this.l;
        if (r10 == null) goto L22;
        r0.L$0 = this;
        r0.label = 1;
        r8 = r10.a(r0);
        if (r8 != r2) goto L19;
        return r2;
    L7:
        r0 = new UpdateTask$await$1(this, r7);
        goto L8
    }

    public final void a(com.obric.aikernel.res.metadata.config.k r15) {
        Intrinsics.checkNotNullParameter(r15, "cfg");
        boolean r0 = t.a(this.g.getCaller());
        if (ZeusTransformUtils.instanceOf(r15, com.obric.aikernel.res.metadata.config.i.class) == false) goto L6;
        boolean r1 = this.d.getMetadataCtrl$resource_manager_release().a(r15.a(), r15.c(), r15.b(), r0);
    L10:
        if (ZeusTransformUtils.instanceOf(r15, com.obric.aikernel.res.metadata.config.e.class) == false) goto L24;
        com.obric.aikernel.res.metadata.data.f r3 = new com.obric.aikernel.res.metadata.data.f(r15.a(), r15.c(), this.d.getConfig());
        com.obric.aikernel.res.metadata.config.a r7 = r3.J();
        if (r7 == null) goto L14;
        com.obric.aikernel.res.metadata.config.e r8 = new com.obric.aikernel.res.metadata.config.e(r15.a(), r7.b());
    L15:
        String r9 = ((com.obric.aikernel.res.metadata.config.e) ZeusTransformUtils.preCheckCast(r15, com.obric.aikernel.res.metadata.config.e.class, "com.obric.memorydata.plugin")).k();
        String r10 = a(r8);
        com.obric.aikernel.runtime.utils.d r11 = com.obric.aikernel.runtime.utils.d.f6216a;
        StringBuilder r12 = new StringBuilder().append("onNewConfig lora decision biz=").append(this.f6150b).append(" remote=").append(r15.a()).append('@').append(r15.c()).append(" localConfig=");
        if (r8 == null) goto L18;
        boolean r13 = true;
    L19:
        r11.b("PackageUpdater", r12.append(r13).append(" localReady=").append(r3.f()).append(" localAvailable=").append(r3.d()).append(" fastCheck=").append(r0).append(" needUpdate=").append(r1).append(" modelDrift=").append(!Intrinsics.areEqual(r9, r10)).toString());
        if (r1 == false) goto L22;
    L25:
        monitor-enter(this);
        if (r1 == false) goto L44;
        ar<UpdateResult> r2 = this.l;     // Catch: Throwable -> L48
        if (r2 != null) goto L30;
    L32:
        boolean r4 = false;
    L34:
        if (t.b(r4, this.n) == true) goto L38;
        com.obric.aikernel.runtime.utils.d.f6216a.b("PackageUpdater", "onNewConfig updateTask Running ignore this request");     // Catch: Throwable -> L48
        monitor-exit(this);
        return;
    L38:
        this.n = true;     // Catch: Throwable -> L48
        this.g.start(r15);     // Catch: Throwable -> L48
        b((com.obric.aikernel.res.metadata.config.a) ZeusTransformUtils.preCheckCast(r15, com.obric.aikernel.res.metadata.config.a.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L48
        ar<UpdateResult> r16 = kotlinx.coroutines.i.b(this.c, null, null, (Function2) ZeusTransformUtils.preCheckCast(new UpdateTask$onNewConfig$1$1(this, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);     // Catch: Throwable -> L41
        r16.a((Function1) ZeusTransformUtils.preCheckCast(new UpdateTask$onNewConfig$1$2$1(this), Function1.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L41
        this.l = r16;     // Catch: Throwable -> L48
    L45:
        Unit r17 = Unit.INSTANCE;     // Catch: Throwable -> L48
        monitor-exit(this);
        return;
    L41:
        th = move-exception;
        this.n = false;     // Catch: Throwable -> L48
        throw th;     // Catch: Throwable -> L48
    L30:
        if (r2.a() != true) goto L32;
        r4 = true;
        goto L34
    L44:
        com.obric.aikernel.runtime.utils.d.f6216a.b("PackageUpdater", "onNewConfig no need update biz=" + this.f6150b + " cfg=" + b(r15) + " stageBefore=" + this.g.getStage() + " stageLabel=" + o.a(this.g.getStage()));     // Catch: Throwable -> L48
        this.g.success("no need to update");     // Catch: Throwable -> L48
    L48:
        th = move-exception;
        throw th;
    L22:
        if (Intrinsics.areEqual(r9, r10) == true) goto L25;
        com.obric.aikernel.runtime.utils.d.f6216a.a("PackageUpdater", "onNewConfig lora skipped update with model drift biz=" + this.f6150b + " remote=" + r15.a() + '@' + r15.c() + " remoteModels=" + r9 + " localModels=" + r10);
        goto L25
    L18:
        r13 = false;
        goto L19
    L14:
        r8 = null;
        goto L15
    L24:
        com.obric.aikernel.runtime.utils.d.f6216a.b("PackageUpdater", "onNewConfig: " + this.f6150b + ' ' + r15.a() + '@' + r15.c() + " fastCheck:" + r0 + " needUpdate:" + r1);
        goto L25
    L6:
        if (ZeusTransformUtils.instanceOf(r15, com.obric.aikernel.res.metadata.config.e.class) == false) goto L8;
        r1 = com.obric.aikernel.res.metadata.data.f.f6090a.a(r15.a(), r15.c(), this.d.getConfig(), r0);
        goto L10
    L8:
        r1 = false;
        goto L10
    }

    public final void a(n.b r10) {
        Intrinsics.checkNotNullParameter(r10, "constriction");
        if (this.d.getConfig().getPackageActionInjector().a(1, this.f6150b, r10.a()) == true) goto L6;
        com.obric.aikernel.runtime.utils.d.f6216a.b("PackageUpdater", "tryResume disallowed by packageActionInjector biz=" + this.f6150b + " caller=" + r10.a());
        return;
    L6:
        b(r10);
        com.obric.aikernel.res.metadata.config.k r0 = this.g.getCfg();
        if (r0 != null) goto L10;
        r0 = f6149a.a(this.f6150b, this.e, this.d);
    L10:
        if (r0 != null) goto L13;
        com.obric.aikernel.runtime.utils.d.f6216a.a("PackageUpdater", "tryResume no config biz=" + this.f6150b + " caller=" + r10.a() + " stage=" + this.g.getStage() + " stageLabel=" + o.a(this.g.getStage()) + " finished=" + this.g.getFinished());
        return;
    L13:
        com.obric.aikernel.runtime.utils.d.f6216a.a("PackageUpdater", "tryResume with config biz=" + this.f6150b + " cfg=" + b(r0) + " caller=" + r10.a() + " stage=" + this.g.getStage() + " stageLabel=" + o.a(this.g.getStage()) + " finished=" + this.g.getFinished());
        a(r0);
    }

    public final void a(CoroutineContext r7, n.b r8) {
        CoroutineContext r9 = (CoroutineContext) ZeusTransformUtils.wrapperContextForParams(r7, CoroutineContext.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r9, "coroutineContext");
        Intrinsics.checkNotNullParameter(r8, "constriction");
        monitor-enter(this);
        com.obric.aikernel.runtime.utils.d.f6216a.b("PackageUpdater", "attachContext: try attach " + r9.get((CoroutineContext.Key) ZeusTransformUtils.preCheckCast(bx.f17252a, CoroutineContext.Key.class, "com.obric.memorydata.plugin")) + " to " + this.h + '-' + this);     // Catch: Throwable -> L14
        final bx r10 = (bx) ZeusTransformUtils.preCheckCast(r9.get((CoroutineContext.Key) ZeusTransformUtils.preCheckCast(bx.f17252a, CoroutineContext.Key.class, "com.obric.memorydata.plugin")), bx.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L14
        if (r10 != null) goto L7;
    L9:
        boolean r11 = t.a(this.g, r8);     // Catch: Throwable -> L14
        monitor-exit(this);
        if (r11 == false) goto L19;
        d();
        return;
    L19:
        return;
    L7:
        if (this.m.add(r10) == false) goto L9;
        r10.a((Function1) ZeusTransformUtils.preCheckCast(new UpdateTask$attachContext$1$1$1(this, r10), Function1.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        throw th;
    }

    public final boolean a(long r8) {
        if (this.g.getFinished() == true) goto L6;
    L17:
        return false;
    L6:
        if (this.g.getFinishTimestamp() == 0) goto L17;
        if (this.g.getSuccess() == false) goto L14;
        if (r8 <= (this.g.getFinishTimestamp() + 300000)) goto L14;
        return true;
    L14:
        if (this.g.getSuccess() == true) goto L17;
        if (r8 <= (this.g.getFinishTimestamp() + 10000)) goto L17;
        return true;
    }

    public final boolean a(n.b r12, String r13) {
        Intrinsics.checkNotNullParameter(r12, "constriction");
        Intrinsics.checkNotNullParameter(r13, "trigger");
        Integer r0 = f();
        if (r0 == null) goto L17;
        int r1 = r0.intValue();
        if (t.a(r13, r1) == true) goto L8;
        com.obric.aikernel.runtime.utils.d.f6216a.a("PackageUpdater", "tryResumeIfDownloadConstraintReady skip timer retry biz=" + this.f6150b + " trigger=" + r13 + " stage=" + this.g.getStage() + " blockedState=" + r1);
        return true;
    L8:
        com.obric.aikernel.res.metadata.config.k r2 = this.g.getCfg();
        if (r2 != null) goto L11;
        r2 = f6149a.a(this.f6150b, this.e, this.d);
    L11:
        com.obric.aikernel.res.downloader.a r7 = a(this, null, 1, null);
        if (r7.c() == false) goto L15;
        com.obric.aikernel.runtime.utils.d.f6216a.a("PackageUpdater", "tryResumeIfDownloadConstraintReady keep waiting biz=" + this.f6150b + " cfg=" + b(r2) + " trigger=" + r13 + " stage=" + this.g.getStage() + " blockedState=" + r1 + " currentGate=" + r7.a() + ':' + r7.b());
        return true;
    L15:
        com.obric.aikernel.runtime.utils.d.f6216a.b("PackageUpdater", "tryResumeIfDownloadConstraintReady resume biz=" + this.f6150b + " cfg=" + b(r2) + " trigger=" + r13 + " stage=" + this.g.getStage() + " blockedState=" + r1);
        a(r12);
        return true;
    L17:
        return false;
    }

    public final boolean a(n.b r10, String r11, long r12) {
        Intrinsics.checkNotNullParameter(r10, "constriction");
        Intrinsics.checkNotNullParameter(r11, "trigger");
        com.obric.aikernel.res.metadata.config.k r0 = f6149a.a(this.e, this.f6150b, this.d.getConfig());
        if (r0 != null) goto L5;
        return false;
    L5:
        UpdateResult r2 = this.g;
        ar<UpdateResult> r3 = this.l;
        if (r3 != null) goto L8;
    L10:
        boolean r4 = false;
    L12:
        if (o.a(true, r2, r4, r12) == true) goto L14;
        return false;
    L14:
        com.obric.aikernel.res.downloader.a r13 = c(r0);
        if (r13.c() == true) goto L17;
        com.obric.aikernel.runtime.utils.d.f6216a.b("PackageUpdater", "tryResumePendingPackageIfDownloadReady resume biz=" + this.f6150b + " pendingCfg=" + b(r0) + " trigger=" + r11 + " stage=" + this.g.getStage());
        a(r10);
        return true;
    L17:
        if (t.a(r11, r13.a()) == true) goto L20;
        com.obric.aikernel.runtime.utils.d.f6216a.a("PackageUpdater", "tryResumePendingPackageIfDownloadReady skip timer retry biz=" + this.f6150b + " pendingCfg=" + b(r0) + " trigger=" + r11 + " stage=" + this.g.getStage() + " currentGate=" + r13.a() + ':' + r13.b());
        return true;
    L20:
        com.obric.aikernel.runtime.utils.d.f6216a.a("PackageUpdater", "tryResumePendingPackageIfDownloadReady keep waiting biz=" + this.f6150b + " pendingCfg=" + b(r0) + " trigger=" + r11 + " stage=" + this.g.getStage() + " currentGate=" + r13.a() + ':' + r13.b());
        return true;
    L8:
        if (r3.a() != true) goto L10;
        r4 = true;
        goto L12
    }

    public final Object b(Continuation<? super Boolean> r15) {
        Continuation r16 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r15, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r16, UpdateTask$doUpdate$1.class) == false) goto L7;
        UpdateTask$doUpdate$1 r1 = (UpdateTask$doUpdate$1) ZeusTransformUtils.preCheckCast(r16, UpdateTask$doUpdate$1.class, "com.obric.memorydata.plugin");
        if ((r1.label & Integer.MIN_VALUE) == 0) goto L7;
        r1.label -= Integer.MIN_VALUE;
    L8:
        Object r17 = r1.result;
        Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r1.label;
        if (r4 == 0) goto L16;
        if (r4 == 1) goto L15;
        if (r4 != 2) goto L14;
        s this = (s) ZeusTransformUtils.preCheckCast(r1.L$0, s.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r17);
    L27:
        boolean r18 = ((Boolean) ZeusTransformUtils.preCheckCast(r17, Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
        com.obric.aikernel.runtime.utils.d.f6216a.b("PackageUpdater", "doUpdate after process biz=" + this.f6150b + " success=" + r18 + " stage=" + this.g.getStage() + " finished=" + this.g.getFinished() + " msg=" + StringsKt.take(this.g.getMsg(), 160));
        if (r18 == true) goto L30;
        UpdateResult r14 = this.g;
        String r19 = "process";
        String r0 = "doProcessFiles returned false";
    L22:
        t.a(r14, r19, r0);
        return Boxing.boxBoolean(false);
    L30:
        boolean r110 = this.g();
        com.obric.aikernel.runtime.utils.d.f6216a.b("PackageUpdater", "doUpdate after install biz=" + this.f6150b + " success=" + r110 + " stage=" + this.g.getStage() + " finished=" + this.g.getFinished() + " msg=" + StringsKt.take(this.g.getMsg(), 160));
        if (r110 == true) goto L34;
        t.a(this.g, "install", "doInstall returned false");
    L34:
        return Boxing.boxBoolean(r110);
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        this = (s) ZeusTransformUtils.preCheckCast(r1.L$0, s.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r17);
    L19:
        boolean r111 = ((Boolean) ZeusTransformUtils.preCheckCast(r17, Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
        com.obric.aikernel.runtime.utils.d.f6216a.b("PackageUpdater", "doUpdate after download biz=" + this.f6150b + " success=" + r111 + " stage=" + this.g.getStage() + " finished=" + this.g.getFinished() + " msg=" + StringsKt.take(this.g.getMsg(), 160));
        if (r111 == true) goto L24;
        r14 = this.g;
        r19 = "download";
        r0 = "doDownload returned false";
        goto L22
    L24:
        r1.L$0 = this;
        r1.label = 2;
        r17 = this.d(r1);
        if (r17 != r3) goto L27;
        return r3;
    L16:
        ResultKt.throwOnFailure(r17);
        com.obric.aikernel.runtime.utils.d.f6216a.b("PackageUpdater", "doUpdate start biz=" + this.f6150b + " cfg=" + b(this.g.getCfg()) + " caller=" + this.g.getCaller() + " background=" + this.g.getBackground());
        r1.L$0 = this;
        r1.label = 1;
        r17 = c(r1);
        if (r17 != r3) goto L19;
        return r3;
    L7:
        r1 = new UpdateTask$doUpdate$1(this, r16);
        goto L8
    }

    public final ar<UpdateResult> b() {
        return this.l;
    }

    public final float c() {
        if (this.g.getSuccess() == false) goto L6;
        return 100.0f;
    L6:
        if (this.g.getFinished() == true) goto L14;
        float r0 = this.g.getStage();
        float r1 = 0.0f;
        if (this.g.getStage() != 200) goto L11;
        r1 = this.d.getDownloadCtrl$resource_manager_release().c(this.h);
    L11:
        float r2 = 100;
        float r3 = r0 + (r1 * r2);
        float r4 = r2 * (r3 / 500);
        com.obric.aikernel.runtime.utils.d.f6216a.a("PackageUpdater", "getUpdateProgress: " + r4 + '(' + r3 + '-' + r1 + ") from " + this.g);
        return r4;
    L14:
        return -this.g.getStage();
    }
}
