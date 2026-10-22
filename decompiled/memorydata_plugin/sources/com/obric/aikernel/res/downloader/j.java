package com.obric.aikernel.res.downloader;

import android.security.obric.guard.ObricSecurityGuardStub;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.bdlocation.trace.TraceCons;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.bytedance.keva.KevaImpl;
import com.google.gson.JsonObject;
import com.obric.aikernel.res.PackageResourceManager;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.depend.IDownloadMonitorDepend;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.ak;
import kotlinx.coroutines.al;
import kotlinx.coroutines.am;
import kotlinx.coroutines.ar;
import kotlinx.coroutines.au;
import kotlinx.coroutines.bx;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000¤\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u001e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u0000 o2\u00020\u0001:\u0003opqB\u0095\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u0012\u0014\b\u0002\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00130\u0012\u0012\u0014\b\u0002\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00150\u0012\u0012\u000e\b\u0002\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00100\u0017\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0019\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0019¢\u0006\u0002\u0010\u001bJ\u0006\u0010Q\u001a\u00020!J4\u0010R\u001a\u00020!2\f\u0010S\u001a\b\u0012\u0004\u0012\u00020\u00050T2\u001e\u0010U\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050 \u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020!0\u001fJ\u000e\u0010V\u001a\u00020!2\u0006\u0010W\u001a\u00020\u0005J/\u0010X\u001a \u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020>07\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t07H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010YJ\u0011\u0010Z\u001a\u00020!H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010YJ\u0011\u0010[\u001a\u00020\u0010H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010YJ\b\u0010\\\u001a\u00020\u0010H\u0002J\u0006\u0010]\u001a\u00020\u0005J\b\u0010^\u001a\u00020!H\u0002J\u0017\u0010_\u001a\b\u0012\u0004\u0012\u00020`0\tH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010YJ\u0006\u0010a\u001a\u00020\u0010J\u0011\u0010b\u001a\u00020\u0010H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010YJ\u000e\u0010c\u001a\u00020\u00102\u0006\u0010W\u001a\u00020\u0005J\u0006\u0010d\u001a\u00020\u0010J\u0006\u0010e\u001a\u00020\u0010J\r\u0010f\u001a\u00020!H\u0000¢\u0006\u0002\bgJ\r\u0010h\u001a\u00020!H\u0000¢\u0006\u0002\biJ\u0006\u0010j\u001a\u00020!J$\u0010k\u001a\u00020\u00102\u0006\u0010W\u001a\u00020\u00052\u0014\b\u0002\u0010l\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020!0\u0012J\u0017\u0010m\u001a\b\u0012\u0004\u0012\u00020\u00100JH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010YJ\b\u0010n\u001a\u00020\u0010H\u0002R\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00050\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010\u001e\u001a\u001c\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050 \u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020!\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00100\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\"\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001a\u0010'\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010$\"\u0004\b)\u0010&R\u000e\u0010*\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00150\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010+\u001a\u00020,X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u001a\u00101\u001a\u00020\u0019X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u001a\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00130\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R \u00106\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\n070\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b8\u00109R\u0017\u0010:\u001a\b\u0012\u0004\u0012\u00020\u00050\u001d¢\u0006\b\n\u0000\u001a\u0004\b;\u0010<R\u000e\u0010=\u001a\u00020>X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b?\u0010@R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010A\u001a\u00020>X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER\u000e\u0010F\u001a\u00020GX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010H\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010I\u001a\b\u0012\u0004\u0012\u00020\u00100JX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010K\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010$\"\u0004\bM\u0010&R\u001a\u0010N\u001a\u00020>X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bO\u0010C\"\u0004\bP\u0010E\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006r"}, d2 = {"Lcom/obric/aikernel/res/downloader/DownloadTask;", "", "config", "Lcom/obric/aikernel/res/PackageResourceManager$PresmConfig;", OaidModel.KEY_ID, "", "parentScope", "Lkotlin/coroutines/CoroutineContext;", KevaImpl.PrivateConstants.FILES_DIR_NAME, "", "Lcom/obric/aikernel/res/downloader/DownloadTask$FileInfo;", "downloadListener", "Lcom/ss/android/socialbase/downloader/depend/IDownloadListener;", "monitorDepend", "Lcom/ss/android/socialbase/downloader/depend/IDownloadMonitorDepend;", "enableBackgroundRestriction", "", "downloadTaskFactory", "Lkotlin/Function1;", "Lcom/obric/aikernel/res/downloader/IDownloadTask;", "downloadNetworkStateProvider", "Lcom/obric/aikernel/res/downloader/DownloadNetworkState;", "assistantAutoUpdateBlockedProvider", "Lkotlin/Function0;", "infoUpdateIntervalMs", "", "awaitRetryIntervalMs", "(Lcom/obric/aikernel/res/PackageResourceManager$PresmConfig;Ljava/lang/String;Lkotlin/coroutines/CoroutineContext;Ljava/util/List;Lcom/ss/android/socialbase/downloader/depend/IDownloadListener;Lcom/ss/android/socialbase/downloader/depend/IDownloadMonitorDepend;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;JJ)V", "activeTelemetryKeys", "", "activeTelemetryListener", "Lkotlin/Function2;", "", "", TraceCons.METRIC_BACKGROUND, "getBackground", "()Z", "setBackground", "(Z)V", "canRunSplit", "getCanRunSplit", "setCanRunSplit", "completed", "downloadProgress", "", "getDownloadProgress", "()F", "setDownloadProgress", "(F)V", "downloadSize", "getDownloadSize$resource_manager_release", "()J", "setDownloadSize$resource_manager_release", "(J)V", "downloadTasks", "Lkotlin/Pair;", "getFiles", "()Ljava/util/List;", "groups", "getGroups", "()Ljava/util/Set;", "holderCount", "", "getId", "()Ljava/lang/String;", "prior", "getPrior", "()I", "setPrior", "(I)V", "scope", "Lkotlinx/coroutines/CoroutineScope;", "slotActive", "splitTask", "Lkotlinx/coroutines/Deferred;", "started", "getStarted", "setStarted", "state", "getState", "setState", "acquireHolder", "addActiveTelemetryKeys", "keys", "", "listener", "addGroup", "group", "await", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", ObricSecurityGuardStub.SettingsEventConst.EVENT_RESULT_CANCEL, "completeAndFinishIfDownloadedFromTasks", "completeIfDownloadedFromTasks", "describeLifecycleForLog", "downloadSplit", "getDownloadInfos", "Lcom/google/gson/JsonObject;", "isCompleted", "isFinish", "isGroup", "isSafeToReplaceAfterFailure", "isSuccess", "notifyActiveStart", "notifyActiveStart$resource_manager_release", "notifyActiveStop", "notifyActiveStop$resource_manager_release", "releaseHolder", "removeGroup", "action", "run", "shouldEarlyFinish", "Companion", "FileInfo", "LazyDownloadTask", "resource_manager_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f6022a = null;
    private long A;
    private final List<Pair<n, b>> B;
    private volatile ar<Boolean> C;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final PackageResourceManager.PresmConfig f6023b;
    private final String c;
    private final CoroutineContext d;
    private final List<b> e;
    private final IDownloadListener f;
    private final IDownloadMonitorDepend g;
    private final boolean h;
    private final Function1<b, n> i;
    private final Function1<PackageResourceManager.PresmConfig, g> j;
    private final Function0<Boolean> k;
    private final long l;
    private final long m;
    private final Set<String> n;
    private volatile int o;
    private volatile boolean p;
    private volatile boolean q;
    private volatile int r;
    private volatile boolean s;
    private float t;
    private volatile boolean u;
    private volatile int v;
    private volatile boolean w;
    private final Set<String> x;
    private Function2<? super Set<String>, ? super Boolean, Unit> y;
    private final al z;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/obric/aikernel/res/downloader/DownloadTask$Companion;", "", "()V", "AWAIT_RETRY_INTERVAL", "", "DOWNLOAD_SIZE_FACTOR", "", "INFO_UPDATE_INTERVAL", "TAG", "", "resource_manager_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0017\u0018\u00002\u00020\u0001Bg\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000b¢\u0006\u0002\u0010\u0011J\u0006\u0010#\u001a\u00020\u000bR\u0011\u0010\u000e\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0013R\u0011\u0010\u000f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0015R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0015R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u001a\u0010\u0010\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0013\"\u0004\b\u001f\u0010 R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0015R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0015¨\u0006$"}, d2 = {"Lcom/obric/aikernel/res/downloader/DownloadTask$FileInfo;", "", ActivityLifecycle.NAME, "", "md5", "url", "savePath", "tmpPath", "size", "", "onlyWifi", "", "retryCount", "", "enableBackgroundRestriction", "resourceType", "success", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JZIZLjava/lang/String;Z)V", "getEnableBackgroundRestriction", "()Z", "getMd5", "()Ljava/lang/String;", "getName", "getOnlyWifi", "getResourceType", "getRetryCount", "()I", "getSavePath", "getSize", "()J", "getSuccess", "setSuccess", "(Z)V", "getTmpPath", "getUrl", "hasMaterializedTarget", "resource_manager_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f6024a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f6025b;
        private final String c;
        private final String d;
        private final String e;
        private final long f;
        private final boolean g;
        private final int h;
        private final boolean i;
        private final String j;
        private volatile boolean k;

        public b(String r2, String r3, String r4, String r5, String r6, long r7, boolean r9, int r10, boolean r11, String r12, boolean r13) {
            Intrinsics.checkNotNullParameter(r2, ActivityLifecycle.NAME);
            Intrinsics.checkNotNullParameter(r3, "md5");
            Intrinsics.checkNotNullParameter(r4, "url");
            Intrinsics.checkNotNullParameter(r5, "savePath");
            Intrinsics.checkNotNullParameter(r6, "tmpPath");
            Intrinsics.checkNotNullParameter(r12, "resourceType");
            this.f6024a = r2;
            this.f6025b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
            this.f = r7;
            this.g = r9;
            this.h = r10;
            this.i = r11;
            this.j = r12;
            this.k = r13;
        }

        public /* synthetic */ b(String r17, String r18, String r19, String r20, String r21, long r22, boolean r24, int r25, boolean r26, String r27, boolean r28, int r29, DefaultConstructorMarker r30) {
            if ((r29 & 64) == 0) goto L5;
            boolean r11 = true;
        L7:
            if ((r29 & 128) == 0) goto L9;
            int r12 = 3;
        L11:
            if ((r29 & 256) == 0) goto L13;
            boolean r13 = true;
        L15:
            if ((r29 & 512) == 0) goto L17;
            String r14 = "";
        L19:
            if ((r29 & 1024) == 0) goto L21;
            boolean r15 = false;
        L22:
            this(r17, r18, r19, r20, r21, r22, r11, r12, r13, r14, r15);
            return;
        L21:
            r15 = r28;
            goto L22
        L17:
            r14 = r27;
            goto L19
        L13:
            r13 = r26;
            goto L15
        L9:
            r12 = r25;
            goto L11
        L5:
            r11 = r24;
            goto L7
        }

        public final String a() {
            return this.f6024a;
        }

        public final void a(boolean r1) {
            this.k = r1;
        }

        public final String b() {
            return this.f6025b;
        }

        public final String c() {
            return this.c;
        }

        public final String d() {
            return this.d;
        }

        public final String e() {
            return this.e;
        }

        public final long f() {
            return this.f;
        }

        public final boolean g() {
            return this.g;
        }

        public final int h() {
            return this.h;
        }

        public final boolean i() {
            return this.i;
        }

        public final String j() {
            return this.j;
        }

        public final boolean k() {
            return this.k;
        }

        public final boolean l() {
            File r0 = new File(this.d, this.f6024a);
            if (r0.isFile() == true) goto L18;
            String[] r3 = r0.list();
            if (r3 != null) goto L8;
        L14:
            boolean r4 = true;
        L15:
            if (r4 == false) goto L17;
            return false;
        L17:
            return true;
        L8:
            if (r3.length != 0) goto L10;
            boolean r5 = true;
        L11:
            if (r5 == true) goto L14;
            r4 = false;
            goto L15
        L10:
            r5 = false;
            goto L11
        L18:
            return r0.exists();
        }
    }

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0011\u0010\u000e\u001a\u00020\u000fH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0010J\u0011\u0010\u0011\u001a\u00020\u000fH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0010J\u0011\u0010\u0012\u001a\u00020\u0013H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0010J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\u0011\u0010\u0016\u001a\u00020\u0015H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0010J\u0011\u0010\u0017\u001a\u00020\u0015H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0010J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\u0011\u0010\u001a\u001a\u00020\u000fH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0010J\u0011\u0010\u001b\u001a\u00020\u000fH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0010J\u0011\u0010\u001c\u001a\u00020\u000fH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0010R\u001b\u0010\u0007\u001a\u00020\u00018BX\u0082\u0084\u0002¢\u0006\f\u001a\u0004\b\n\u0010\u000b*\u0004\b\b\u0010\tR\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00010\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001d"}, d2 = {"Lcom/obric/aikernel/res/downloader/DownloadTask$LazyDownloadTask;", "Lcom/obric/aikernel/res/downloader/IDownloadTask;", "file", "Lcom/obric/aikernel/res/downloader/DownloadTask$FileInfo;", "factory", "Lkotlin/Function1;", "(Lcom/obric/aikernel/res/downloader/DownloadTask$FileInfo;Lkotlin/jvm/functions/Function1;)V", "delegate", "getDelegate$delegate", "(Lcom/obric/aikernel/res/downloader/DownloadTask$LazyDownloadTask;)Ljava/lang/Object;", "getDelegate", "()Lcom/obric/aikernel/res/downloader/IDownloadTask;", "delegateHolder", "Lkotlin/Lazy;", ObricSecurityGuardStub.SettingsEventConst.EVENT_RESULT_CANCEL, "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "finish", "getDownloadInfos", "Lcom/google/gson/JsonObject;", "getId", "", "getProgress", "getStatus", "isDownloaded", "", "pause", "resume", CommonConsts.APM_INNER_EVENT_COST_START, "resource_manager_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    private static final class c implements n {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final b f6026a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Function1<b, n> f6027b;
        private final Lazy<n> c;

        public c(b r3, Function1<? super b, ? extends n> r4) {
            Function1<b, n> r5 = (Function1) ZeusTransformUtils.wrapperContextForParams(r4, Function1.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, "file");
            Intrinsics.checkNotNullParameter(r5, "factory");
            this.f6026a = r3;
            this.f6027b = r5;
            this.c = LazyKt.lazy((Function0) ZeusTransformUtils.preCheckCast(new DownloadTask$LazyDownloadTask$delegateHolder$1(this), Function0.class, "com.obric.memorydata.plugin"));
        }

        public static final /* synthetic */ Function1 a(c r0) {
            return r0.f6027b;
        }

        public static final /* synthetic */ b b(c r0) {
            return r0.f6026a;
        }

        private final n c() {
            return (n) ZeusTransformUtils.preCheckCast(this.c.getValue(), n.class, "com.obric.memorydata.plugin");
        }

        @Override // com.obric.aikernel.res.downloader.n
        public int a() {
            if (this.c.isInitialized() == true) goto L7;
            return 0;
        L7:
            return c().a();
        }

        @Override // com.obric.aikernel.res.downloader.n
        public Object a(Continuation<? super Unit> r3) {
            Continuation<? super Unit> r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            Object r2 = c().a(r4);
            if (r2 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
            return r2;
        L6:
            return Unit.INSTANCE;
        }

        @Override // com.obric.aikernel.res.downloader.n
        public Object b(Continuation<? super Unit> r3) {
            Continuation<? super Unit> r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            Object r2 = c().b(r4);
            if (r2 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
            return r2;
        L6:
            return Unit.INSTANCE;
        }

        @Override // com.obric.aikernel.res.downloader.n
        public boolean b() {
            if (this.c.isInitialized() == false) goto L6;
            return c().b();
        L6:
            return this.f6026a.l();
        }

        @Override // com.obric.aikernel.res.downloader.n
        public Object c(Continuation<? super Unit> r3) {
            Continuation<? super Unit> r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            if (this.c.isInitialized() == false) goto L10;
            Object r2 = c().c(r4);
            if (r2 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L8;
            return r2;
        L8:
            return Unit.INSTANCE;
        L10:
            return Unit.INSTANCE;
        }

        @Override // com.obric.aikernel.res.downloader.n
        public Object d(Continuation<? super Unit> r3) {
            Continuation<? super Unit> r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            if (this.c.isInitialized() == false) goto L10;
            Object r2 = c().d(r4);
            if (r2 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L8;
            return r2;
        L8:
            return Unit.INSTANCE;
        L10:
            return Unit.INSTANCE;
        }

        @Override // com.obric.aikernel.res.downloader.n
        public Object e(Continuation<? super Unit> r3) {
            Continuation<? super Unit> r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            if (this.c.isInitialized() == false) goto L10;
            Object r2 = c().e(r4);
            if (r2 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L8;
            return r2;
        L8:
            return Unit.INSTANCE;
        L10:
            return Unit.INSTANCE;
        }

        @Override // com.obric.aikernel.res.downloader.n
        public Object f(Continuation<? super Integer> r3) {
            Continuation<? super Integer> r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            if (this.c.isInitialized() == false) goto L7;
            return c().f(r4);
        L7:
            return Boxing.boxInt(0);
        }

        @Override // com.obric.aikernel.res.downloader.n
        public Object g(Continuation<? super Integer> r3) {
            Continuation<? super Integer> r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            if (this.c.isInitialized() == false) goto L7;
            return c().g(r4);
        L7:
            return Boxing.boxInt(0);
        }

        @Override // com.obric.aikernel.res.downloader.n
        public Object h(Continuation<? super JsonObject> r4) {
            Continuation<? super JsonObject> r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            if (this.c.isInitialized() == true) goto L5;
            JsonObject r6 = new JsonObject();
            r6.addProperty(ActivityLifecycle.NAME, this.f6026a.a());
            r6.addProperty("speed", (Number) ZeusTransformUtils.preCheckCast(Boxing.boxInt(0), Number.class, "com.obric.memorydata.plugin"));
            r6.addProperty("downloading", Boxing.boxBoolean(false));
            r6.addProperty("notStarted", Boxing.boxBoolean(true));
            return r6;
        L5:
            return c().h(r5);
        }
    }

    static {
        f6022a = new a(null);
    }

    public j(PackageResourceManager.PresmConfig r13, String r14, CoroutineContext r15, List<b> r16, IDownloadListener r17, IDownloadMonitorDepend r18, boolean r19, Function1<? super b, ? extends n> r20, Function1<? super PackageResourceManager.PresmConfig, g> r21, Function0<Boolean> r22, long r23, long r25) {
        CoroutineContext r3 = (CoroutineContext) ZeusTransformUtils.wrapperContextForParams(r15, CoroutineContext.class, "com.obric.memorydata.plugin");
        List<b> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r16, List.class, "com.obric.memorydata.plugin");
        IDownloadListener r6 = (IDownloadListener) ZeusTransformUtils.wrapperContextForParams(r17, IDownloadListener.class, "com.obric.memorydata.plugin");
        IDownloadMonitorDepend r7 = (IDownloadMonitorDepend) ZeusTransformUtils.wrapperContextForParams(r18, IDownloadMonitorDepend.class, "com.obric.memorydata.plugin");
        Function1<b, n> r8 = (Function1) ZeusTransformUtils.wrapperContextForParams(r20, Function1.class, "com.obric.memorydata.plugin");
        Function1<PackageResourceManager.PresmConfig, g> r9 = (Function1) ZeusTransformUtils.wrapperContextForParams(r21, Function1.class, "com.obric.memorydata.plugin");
        Function0<Boolean> r10 = (Function0) ZeusTransformUtils.wrapperContextForParams(r22, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r13, "config");
        Intrinsics.checkNotNullParameter(r14, OaidModel.KEY_ID);
        Intrinsics.checkNotNullParameter(r3, "parentScope");
        Intrinsics.checkNotNullParameter(r5, KevaImpl.PrivateConstants.FILES_DIR_NAME);
        Intrinsics.checkNotNullParameter(r6, "downloadListener");
        Intrinsics.checkNotNullParameter(r7, "monitorDepend");
        Intrinsics.checkNotNullParameter(r8, "downloadTaskFactory");
        Intrinsics.checkNotNullParameter(r9, "downloadNetworkStateProvider");
        Intrinsics.checkNotNullParameter(r10, "assistantAutoUpdateBlockedProvider");
        this.f6023b = r13;
        this.c = r14;
        this.d = r3;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r19;
        this.i = r8;
        this.j = r9;
        this.k = r10;
        this.l = r23;
        this.m = r25;
        this.n = (Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.memorydata.plugin");
        this.p = true;
        this.x = (Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.memorydata.plugin");
        this.z = am.a(r3.plus((CoroutineContext) ZeusTransformUtils.preCheckCast(new ak(r14), CoroutineContext.class, "com.obric.memorydata.plugin")));
        Iterable r1 = (Iterable) ZeusTransformUtils.preCheckCast(r5, Iterable.class, "com.obric.memorydata.plugin");
        Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r4 = r1.iterator();
    L4:
        if (r4.hasNext() == false) goto L11;
        b r11 = (b) ZeusTransformUtils.preCheckCast(r4.next(), b.class, "com.obric.memorydata.plugin");
        if (r11.l() == false) goto L8;
        Pair r12 = (Pair) ZeusTransformUtils.preCheckCast(null, Pair.class, "com.obric.memorydata.plugin");
    L9:
        if (r12 == null) goto L4;
        r2.add(r12);
        goto L4
    L8:
        this.A += r11.f();
        r12 = new Pair(new c(r11, this.i), r11);
        goto L9
    L11:
        List<Pair<n, b>> r24 = (List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.memorydata.plugin");
        this.B = r24;
        this.u = k.a(r24.isEmpty());
        this.C = kotlinx.coroutines.i.b(this.z, null, null, (Function2) ZeusTransformUtils.preCheckCast(new DownloadTask$splitTask$1(this, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
    }

    public /* synthetic */ j(final PackageResourceManager.PresmConfig r19, String r20, CoroutineContext r21, List r22, IDownloadListener r23, IDownloadMonitorDepend r24, boolean r25, Function1 r26, Function1 r27, Function0 r28, long r29, long r31, int r33, DefaultConstructorMarker r34) {
        CoroutineContext r6 = (CoroutineContext) ZeusTransformUtils.wrapperContextForParams(r21, CoroutineContext.class, "com.obric.memorydata.plugin");
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r22, List.class, "com.obric.memorydata.plugin");
        final IDownloadListener r8 = (IDownloadListener) ZeusTransformUtils.wrapperContextForParams(r23, IDownloadListener.class, "com.obric.memorydata.plugin");
        final IDownloadMonitorDepend r9 = (IDownloadMonitorDepend) ZeusTransformUtils.wrapperContextForParams(r24, IDownloadMonitorDepend.class, "com.obric.memorydata.plugin");
        Function1 r1 = (Function1) ZeusTransformUtils.wrapperContextForParams(r26, Function1.class, "com.obric.memorydata.plugin");
        Function1 r3 = (Function1) ZeusTransformUtils.wrapperContextForParams(r27, Function1.class, "com.obric.memorydata.plugin");
        Function0 r4 = (Function0) ZeusTransformUtils.wrapperContextForParams(r28, Function0.class, "com.obric.memorydata.plugin");
        if ((r33 & 64) == 0) goto L5;
        boolean r10 = true;
    L7:
        if ((r33 & 128) == 0) goto L10;
        r1 = (Function1) ZeusTransformUtils.preCheckCast(new DownloadTask$1(r19, r8, r9), Function1.class, "com.obric.memorydata.plugin");
    L10:
        Function1 r11 = r1;
        if ((r33 & 256) == 0) goto L13;
        Function1 r12 = (Function1) ZeusTransformUtils.preCheckCast(DownloadTask$2.INSTANCE, Function1.class, "com.obric.memorydata.plugin");
    L15:
        if ((r33 & 512) == 0) goto L17;
        Function0 r13 = (Function0) ZeusTransformUtils.preCheckCast(DownloadTask$3.INSTANCE, Function0.class, "com.obric.memorydata.plugin");
    L19:
        if ((r33 & 1024) == 0) goto L21;
        long r14 = 5000;
    L23:
        if ((r33 & 2048) == 0) goto L25;
        long r16 = 1000;
    L26:
        this(r19, r20, r6, r7, r8, r9, r10, r11, r12, r13, r14, r16);
        return;
    L25:
        r16 = r31;
        goto L26
    L21:
        r14 = r29;
        goto L23
    L17:
        r13 = r4;
        goto L19
    L13:
        r12 = r3;
        goto L15
    L5:
        r10 = r25;
        goto L7
    }

    public static final /* synthetic */ Object a(j r2, Continuation r3) {
        return r2.f((Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin"));
    }

    public static final /* synthetic */ List a(j r0) {
        return r0.B;
    }

    public static final /* synthetic */ void a(j r0, boolean r1) {
        r0.u = r1;
    }

    public static /* synthetic */ boolean a(j r1, String r2, Function1 r3, int r4, Object r5) {
        Function1<? super Boolean, Unit> r6 = (Function1) ZeusTransformUtils.wrapperContextForParams(r3, Function1.class, "com.obric.memorydata.plugin");
        if ((r4 & 2) == 0) goto L6;
        r6 = (Function1) ZeusTransformUtils.preCheckCast(DownloadTask$removeGroup$1.INSTANCE, Function1.class, "com.obric.memorydata.plugin");
    L6:
        return r1.a(r2, r6);
    }

    public static final /* synthetic */ boolean b(j r0) {
        return r0.q();
    }

    public static final /* synthetic */ long c(j r2) {
        return r2.l;
    }

    public static final /* synthetic */ PackageResourceManager.PresmConfig d(j r0) {
        return r0.f6023b;
    }

    public static final /* synthetic */ boolean e(j r0) {
        return r0.s();
    }

    private final Object f(Continuation<? super Boolean> r8) {
        Continuation r9 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r8, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r9, DownloadTask$completeAndFinishIfDownloadedFromTasks$1.class) == false) goto L7;
        DownloadTask$completeAndFinishIfDownloadedFromTasks$1 r0 = (DownloadTask$completeAndFinishIfDownloadedFromTasks$1) ZeusTransformUtils.preCheckCast(r9, DownloadTask$completeAndFinishIfDownloadedFromTasks$1.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r10 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        Iterator r7 = (Iterator) ZeusTransformUtils.preCheckCast(r0.L$1, Iterator.class, "com.obric.memorydata.plugin");
        j r4 = (j) ZeusTransformUtils.preCheckCast(r0.L$0, j.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r10);
        j r11 = r4;
    L20:
        if (r7.hasNext() == false) goto L24;
        n r5 = (n) ZeusTransformUtils.preCheckCast(((Pair) ZeusTransformUtils.preCheckCast(r7.next(), Pair.class, "com.obric.memorydata.plugin")).getFirst(), n.class, "com.obric.memorydata.plugin");
        r0.L$0 = r11;
        r0.L$1 = r7;
        r0.label = 1;
        if (r5.e(r0) != r2) goto L20;
        return r2;
    L24:
        r11.u = k.a(true);
        return Boxing.boxBoolean(true);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r10);
        if (s() == false) goto L17;
        r11 = this;
        r7 = ((Iterable) ZeusTransformUtils.preCheckCast(this.B, Iterable.class, "com.obric.memorydata.plugin")).iterator();
        goto L20
    L17:
        return Boxing.boxBoolean(false);
    L7:
        r0 = new DownloadTask$completeAndFinishIfDownloadedFromTasks$1(this, r9);
        goto L8
    }

    private final boolean q() {
        g r1 = (g) ZeusTransformUtils.preCheckCast(this.j.invoke(this.f6023b), g.class, "com.obric.memorydata.plugin");
        boolean r5 = ((Boolean) ZeusTransformUtils.preCheckCast(this.f6023b.getAppConfig().getAllowNetworkRequest().invoke(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
        boolean r6 = !((Collection) ZeusTransformUtils.preCheckCast(this.n, Collection.class, "com.obric.memorydata.plugin")).isEmpty();
        boolean r7 = this.h;
        boolean r8 = this.p;
        boolean r9 = ((Boolean) ZeusTransformUtils.preCheckCast(((Pair) ZeusTransformUtils.preCheckCast(this.f6023b.getAppConfig().getAllowBackgroundUpdate().c(), Pair.class, "com.obric.memorydata.plugin")).getFirst(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
        String r10 = (String) ZeusTransformUtils.preCheckCast(((Pair) ZeusTransformUtils.preCheckCast(this.f6023b.getAppConfig().getAllowBackgroundUpdate().c(), Pair.class, "com.obric.memorydata.plugin")).getSecond(), String.class, "com.obric.memorydata.plugin");
        Iterable r2 = (Iterable) ZeusTransformUtils.preCheckCast(this.e, Iterable.class, "com.obric.memorydata.plugin");
        Collection r4 = (Collection) ZeusTransformUtils.preCheckCast((Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.memorydata.plugin"), Collection.class, "com.obric.memorydata.plugin");
        Iterator r3 = r2.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        r4.add(((b) ZeusTransformUtils.preCheckCast(r3.next(), b.class, "com.obric.memorydata.plugin")).j());
        goto L4
    L6:
        Set r11 = (Set) ZeusTransformUtils.preCheckCast(r4, Set.class, "com.obric.memorydata.plugin");
        boolean r12 = ((Boolean) ZeusTransformUtils.preCheckCast(this.k.invoke(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
        boolean r13 = r1.a();
        Iterable r14 = (Iterable) ZeusTransformUtils.preCheckCast(this.e, Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r14, Collection.class) == true) goto L9;
    L11:
        Iterator r15 = r14.iterator();
    L13:
        if (r15.hasNext() == false) goto L10;
        if (((b) ZeusTransformUtils.preCheckCast(r15.next(), b.class, "com.obric.memorydata.plugin")).g() == false) goto L13;
        boolean r16 = true;
    L17:
        com.obric.aikernel.res.downloader.a r17 = com.obric.aikernel.res.downloader.b.a(new com.obric.aikernel.res.downloader.c(r5, r6, r7, r8, r9, r10, r11, r12, r13, r16, r1.b()));
        if (r17.c() == true) goto L20;
        return false;
    L20:
        this.r = r17.a();
        int r18 = r17.a();
        if (r18 != 1) goto L23;
        com.obric.aikernel.runtime.utils.d.f6216a.f("DownloadTask", "download task " + this.c + " quit by caller is all canceled");
    L41:
        return true;
    L23:
        if (r18 != 2) goto L25;
        com.obric.aikernel.runtime.utils.d r19 = com.obric.aikernel.runtime.utils.d.f6216a;
        StringBuilder r0 = new StringBuilder().append("background download task ").append(this.c);
        String r20 = " quit by disallow reason: ";
    L39:
        r19.f("DownloadTask", r0.append(r20).append(r17.b()).toString());
        goto L41
    L25:
        if (r18 != 3) goto L27;
        com.obric.aikernel.runtime.utils.d r21 = com.obric.aikernel.runtime.utils.d.f6216a;
        String r22 = "no STATE_NEED_WIFI";
    L37:
        r21.f("DownloadTask", r22);
        goto L41
    L27:
        if (r18 != 4) goto L29;
        r19 = com.obric.aikernel.runtime.utils.d.f6216a;
        r0 = new StringBuilder().append("download task ").append(this.c);
        r20 = " blocked by ";
        goto L39
    L29:
        if (r18 != 5) goto L31;
        r21 = com.obric.aikernel.runtime.utils.d.f6216a;
        r22 = "no valid internet";
        goto L37
    L31:
        if (r18 != 7) goto L41;
        r19 = com.obric.aikernel.runtime.utils.d.f6216a;
        r0 = new StringBuilder().append("assistant auto-update gate blocks background download task ").append(this.c);
        r20 = " reason: ";
    L10:
        r16 = false;
        goto L17
    L9:
        if (((Collection) ZeusTransformUtils.preCheckCast(r14, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L11;
        goto L10
    }

    private final void r() {
        this.C = kotlinx.coroutines.i.b(this.z, null, null, (Function2) ZeusTransformUtils.preCheckCast(new DownloadTask$downloadSplit$1(this, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
    }

    private final boolean s() {
        if (this.B.isEmpty() == false) goto L6;
        this.u = k.a(true);
        return true;
    L6:
        Iterable r0 = (Iterable) ZeusTransformUtils.preCheckCast(this.B, Iterable.class, "com.obric.memorydata.plugin");
        boolean r4 = false;
        if (ZeusTransformUtils.instanceOf(r0, Collection.class) == true) goto L9;
    L11:
        Iterator r1 = r0.iterator();
    L13:
        if (r1.hasNext() == false) goto L10;
        Pair r2 = (Pair) ZeusTransformUtils.preCheckCast(r1.next(), Pair.class, "com.obric.memorydata.plugin");
        n r5 = (n) ZeusTransformUtils.preCheckCast(r2.component1(), n.class, "com.obric.memorydata.plugin");
        b r3 = (b) ZeusTransformUtils.preCheckCast(r2.component2(), b.class, "com.obric.memorydata.plugin");
        if (r3.k() == false) goto L17;
    L20:
        boolean r6 = true;
    L21:
        if (r6 == false) goto L23;
        r3.a(true);
    L23:
        if (r6 == true) goto L13;
    L24:
        if (r4 == false) goto L26;
        this.u = k.a(true);
    L26:
        return r4;
    L17:
        if (r5.b() == true) goto L20;
        r6 = false;
    L10:
        r4 = true;
        goto L24
    L9:
        if (((Collection) ZeusTransformUtils.preCheckCast(r0, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L11;
        goto L10
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x00b6 -> B:21:0x00b7). Please report as a decompilation issue!!! */
    public final Object a(Continuation<? super List<JsonObject>> r8) {
        Continuation r9 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r8, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r9, DownloadTask$getDownloadInfos$1.class) == false) goto L7;
        DownloadTask$getDownloadInfos$1 r0 = (DownloadTask$getDownloadInfos$1) ZeusTransformUtils.preCheckCast(r9, DownloadTask$getDownloadInfos$1.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r10 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        Collection r7 = (Collection) ZeusTransformUtils.preCheckCast(r0.L$2, Collection.class, "com.obric.memorydata.plugin");
        Iterator r4 = (Iterator) ZeusTransformUtils.preCheckCast(r0.L$1, Iterator.class, "com.obric.memorydata.plugin");
        Collection r5 = (Collection) ZeusTransformUtils.preCheckCast(r0.L$0, Collection.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r10);
    L21:
        r7.add((JsonObject) ZeusTransformUtils.preCheckCast(r10, JsonObject.class, "com.obric.memorydata.plugin"));
        r7 = r5;
    L16:
        if (r4.hasNext() == false) goto L23;
        n r11 = (n) ZeusTransformUtils.preCheckCast(((Pair) ZeusTransformUtils.preCheckCast(r4.next(), Pair.class, "com.obric.memorydata.plugin")).getFirst(), n.class, "com.obric.memorydata.plugin");
        r0.L$0 = r7;
        r0.L$1 = r4;
        r0.L$2 = r7;
        r0.label = 1;
        r10 = r11.h(r0);
        if (r10 != r2) goto L20;
        return r2;
    L20:
        r5 = r7;
        goto L21
    L23:
        return (List) ZeusTransformUtils.preCheckCast(r7, List.class, "com.obric.memorydata.plugin");
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r10);
        Iterable r12 = (Iterable) ZeusTransformUtils.preCheckCast(this.B, Iterable.class, "com.obric.memorydata.plugin");
        Collection r13 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r12, 10)), Collection.class, "com.obric.memorydata.plugin");
        r4 = r12.iterator();
        r7 = r13;
    L7:
        r0 = new DownloadTask$getDownloadInfos$1(this, r9);
        goto L8
    }

    public final String a() {
        return this.c;
    }

    public final void a(float r1) {
        this.t = r1;
    }

    public final void a(int r1) {
        this.o = r1;
    }

    public final synchronized void a(String r2) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r2, "group");     // Catch: Throwable -> L6
        this.n.add(r2);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public final void a(Collection<String> r5, Function2<? super Set<String>, ? super Boolean, Unit> r6) {
        Collection r7 = (Collection) ZeusTransformUtils.wrapperContextForParams(r5, Collection.class, "com.obric.memorydata.plugin");
        Function2<? super Set<String>, ? super Boolean, Unit> r8 = (Function2) ZeusTransformUtils.wrapperContextForParams(r6, Function2.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "keys");
        Intrinsics.checkNotNullParameter(r8, "listener");
        monitor-enter(this);
        this.y = r8;     // Catch: Throwable -> L24
        Iterable r9 = (Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L24
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L24
        Iterator r10 = r9.iterator();     // Catch: Throwable -> L24
    L6:
        if (r10.hasNext() == false) goto L10;
        Object r1 = r10.next();     // Catch: Throwable -> L24
        if (this.x.add((String) ZeusTransformUtils.preCheckCast(r1, String.class, "com.obric.memorydata.plugin")) == false) goto L6;
        r0.add(r1);     // Catch: Throwable -> L24
        goto L6
    L10:
        Set r11 = CollectionsKt.toSet((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L24
        if (this.w == false) goto L16;
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r11, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L16;
        boolean r2 = true;
    L17:
        if (r2 == true) goto L20;
        r11 = null;
    L20:
        monitor-exit(this);
        if (r11 == null) goto L34;
        r8.invoke(r11, true);
        return;
    L34:
        return;
    L16:
        r2 = false;
    L24:
        th = move-exception;
        throw th;
    }

    public final void a(boolean r1) {
        this.p = r1;
    }

    public final synchronized boolean a(String r3, Function1<? super Boolean, Unit> r4) {
        monitor-enter(this);
        Function1 r5 = (Function1) ZeusTransformUtils.wrapperContextForParams(r4, Function1.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L13
        Intrinsics.checkNotNullParameter(r3, "group");     // Catch: Throwable -> L13
        Intrinsics.checkNotNullParameter(r5, "action");     // Catch: Throwable -> L13
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L6;
        boolean r0 = true;
    L7:
        if (r0 == false) goto L9;
        this.n.clear();     // Catch: Throwable -> L13
    L10:
        boolean r6 = this.n.isEmpty();     // Catch: Throwable -> L13
        r5.invoke(Boolean.valueOf(r6));     // Catch: Throwable -> L13
        monitor-exit(this);
        return r6;
    L9:
        this.n.remove(r3);     // Catch: Throwable -> L13
        goto L10
    L6:
        r0 = false;
    L13:
        th = move-exception;
        throw th;
    }

    public final int b() {
        return this.o;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x017e -> B:14:0x0058). Please report as a decompilation issue!!! */
    public final Object b(Continuation<? super Pair<Pair<Boolean, Integer>, ? extends List<b>>> r25) {
        j r0 = this;
        Continuation r2 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r25, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r2, DownloadTask$await$1.class) == false) goto L7;
        DownloadTask$await$1 r4 = (DownloadTask$await$1) ZeusTransformUtils.preCheckCast(r2, DownloadTask$await$1.class, "com.obric.memorydata.plugin");
        if ((r4.label & Integer.MIN_VALUE) == 0) goto L7;
        r4.label -= Integer.MIN_VALUE;
    L8:
        Object r3 = r4.result;
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r6 = r4.label;
        boolean r13 = true;
        if (r6 == 0) goto L19;
        if (r6 == 1) goto L18;
        if (r6 == 2) goto L17;
        if (r6 != 3) goto L16;
        int r1 = r4.I$0;
        j r7 = (j) ZeusTransformUtils.preCheckCast(r4.L$0, j.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r3);
    L14:
        j r23 = r7;
        int r8 = r1;
        r0 = r23;
    L20:
        ar<Boolean> r9 = r0.C;
        r4.L$0 = r0;
        r4.I$0 = r8;
        r4.label = 1;
        r3 = r9.a(r4);
        if (r3 != r5) goto L23;
        return r5;
    L23:
        int r24 = r8;
        r7 = r0;
        int r10 = r24;
    L25:
        if (((Boolean) ZeusTransformUtils.preCheckCast(r3, Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == true) goto L40;
        r4.L$0 = r7;
        r4.I$0 = r10;
        r4.label = 2;
        r3 = r7.f(r4);
        if (r3 != r5) goto L30;
        return r5;
    L30:
        if (((Boolean) ZeusTransformUtils.preCheckCast(r3, Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L32;
        r7.C = kotlinx.coroutines.i.b(r7.z, null, null, (Function2) ZeusTransformUtils.preCheckCast(new DownloadTask$await$3(null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        goto L40
    L32:
        r1 = r10 + 1;
        if (r1 != 1) goto L35;
    L36:
        com.obric.aikernel.runtime.utils.d.f6216a.b("DownloadTask", "download await waiting id=" + r7.c + " waitLoop=" + r1 + ' ' + r7.i());
    L37:
        long r11 = r7.m;
        r4.L$0 = r7;
        r4.I$0 = r1;
        r4.label = 3;
        if (au.a(r11, r4) != r5) goto L14;
        return r5;
    L35:
        if ((r1 % 30) != 0) goto L37;
    L40:
        Iterable r12 = (Iterable) ZeusTransformUtils.preCheckCast(r7.B, Iterable.class, "com.obric.memorydata.plugin");
        Collection r14 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r12, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r15 = r12.iterator();
    L42:
        if (r15.hasNext() == false) goto L47;
        b r16 = (b) ZeusTransformUtils.preCheckCast(((Pair) ZeusTransformUtils.preCheckCast(r15.next(), Pair.class, "com.obric.memorydata.plugin")).getSecond(), b.class, "com.obric.memorydata.plugin");
        if (r16.k() == true) goto L46;
        r13 = false;
    L46:
        r14.add(r16);
        goto L42
    L47:
        List r17 = (List) ZeusTransformUtils.preCheckCast(r14, List.class, "com.obric.memorydata.plugin");
        com.obric.aikernel.runtime.utils.d.f6216a.b("DownloadTask", "download await end id=" + r7.c + " success=" + r13 + ' ' + r7.i() + " files=" + CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(r17, Iterable.class, "com.obric.memorydata.plugin"), null, null, null, 8, null, (Function1) ZeusTransformUtils.preCheckCast(DownloadTask$await$4.INSTANCE, Function1.class, "com.obric.memorydata.plugin"), 23, null));
        return new Pair(new Pair(Boxing.boxBoolean(r13), Boxing.boxInt(r7.r)), r17);
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        r10 = r4.I$0;
        r7 = (j) ZeusTransformUtils.preCheckCast(r4.L$0, j.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r3);
        goto L30
    L18:
        r10 = r4.I$0;
        r7 = (j) ZeusTransformUtils.preCheckCast(r4.L$0, j.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r3);
        goto L25
    L19:
        ResultKt.throwOnFailure(r3);
        com.obric.aikernel.runtime.utils.d.f6216a.b("DownloadTask", "download await start id=" + r0.c + ' ' + i() + " files=" + CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(r0.B, Iterable.class, "com.obric.memorydata.plugin"), null, null, null, 8, null, (Function1) ZeusTransformUtils.preCheckCast(DownloadTask$await$2.INSTANCE, Function1.class, "com.obric.memorydata.plugin"), 23, null));
        r8 = 0;
    L7:
        r4 = new DownloadTask$await$1(r0, r2);
        goto L8
    }

    public final void b(int r1) {
        this.r = r1;
    }

    public final void b(boolean r1) {
        this.q = r1;
    }

    public final synchronized boolean b(String r2) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r2, "group");     // Catch: Throwable -> L6
        boolean r3 = this.n.contains(r2);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r3;
    L6:
        th = move-exception;
        throw th;
    }

    public final Object c(Continuation<? super Unit> r14) {
        Continuation r15 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r14, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r15, DownloadTask$cancel$1.class) == false) goto L7;
        DownloadTask$cancel$1 r0 = (DownloadTask$cancel$1) ZeusTransformUtils.preCheckCast(r15, DownloadTask$cancel$1.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r16 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        Iterator r13 = (Iterator) ZeusTransformUtils.preCheckCast(r0.L$1, Iterator.class, "com.obric.memorydata.plugin");
        j r4 = (j) ZeusTransformUtils.preCheckCast(r0.L$0, j.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r16);
        j r17 = r4;
    L16:
        if (r13.hasNext() == false) goto L20;
        n r5 = (n) ZeusTransformUtils.preCheckCast(((Pair) ZeusTransformUtils.preCheckCast(r13.next(), Pair.class, "com.obric.memorydata.plugin")).getFirst(), n.class, "com.obric.memorydata.plugin");
        r0.L$0 = r17;
        r0.L$1 = r13;
        r0.label = 1;
        if (r5.d(r0) != r2) goto L16;
        return r2;
    L20:
        r17.u = true;
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r16);
        ar<Boolean> r18 = this.C;
        this.C = kotlinx.coroutines.i.b(this.z, null, null, (Function2) ZeusTransformUtils.preCheckCast(new DownloadTask$cancel$2(null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        bx.a.a((bx) ZeusTransformUtils.preCheckCast(r18, bx.class, "com.obric.memorydata.plugin"), null, 1, null);
        r17 = this;
        r13 = ((Iterable) ZeusTransformUtils.preCheckCast(this.B, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L7:
        r0 = new DownloadTask$cancel$1(this, r15);
        goto L8
    }

    public final void c(boolean r1) {
        this.s = r1;
    }

    public final boolean c() {
        return this.p;
    }

    public final Object d(Continuation<? super Boolean> r3) {
        Continuation<? super Boolean> r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
        return this.C.a(r4);
    }

    public final boolean d() {
        return this.q;
    }

    public final int e() {
        return this.r;
    }

    public final Object e(Continuation<? super ar<Boolean>> r15) {
        Continuation r16 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r15, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r16, DownloadTask$run$1.class) == false) goto L7;
        DownloadTask$run$1 r1 = (DownloadTask$run$1) ZeusTransformUtils.preCheckCast(r16, DownloadTask$run$1.class, "com.obric.memorydata.plugin");
        if ((r1.label & Integer.MIN_VALUE) == 0) goto L7;
        r1.label -= Integer.MIN_VALUE;
    L8:
        Object r17 = r1.result;
        Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r1.label;
        if (r4 == 0) goto L18;
        if (r4 == 1) goto L17;
        if (r4 == 2) goto L16;
        if (r4 != 3) goto L15;
        j this = (j) ZeusTransformUtils.preCheckCast(r1.L$0, j.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r17);
    L34:
        if (((Boolean) ZeusTransformUtils.preCheckCast(r17, Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L36;
        this.C = kotlinx.coroutines.i.b(this.z, null, null, (Function2) ZeusTransformUtils.preCheckCast(new DownloadTask$run$3(null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
    L38:
        return this.C;
    L36:
        this.r();
        goto L38
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        this = (j) ZeusTransformUtils.preCheckCast(r1.L$0, j.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r17);
    L29:
        if (((Boolean) ZeusTransformUtils.preCheckCast(r17, Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == true) goto L38;
        r1.L$0 = this;
        r1.label = 3;
        r17 = this.f(r1);
        if (r17 != r3) goto L34;
        return r3;
    L17:
        this = (j) ZeusTransformUtils.preCheckCast(r1.L$0, j.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r17);
    L22:
        if (((Boolean) ZeusTransformUtils.preCheckCast(r17, Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L25;
        this.C = kotlinx.coroutines.i.b(this.z, null, null, (Function2) ZeusTransformUtils.preCheckCast(new DownloadTask$run$2(null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        return this.C;
    L25:
        ar<Boolean> r18 = this.C;
        r1.L$0 = this;
        r1.label = 2;
        r17 = r18.a(r1);
        if (r17 != r3) goto L29;
        return r3;
    L18:
        ResultKt.throwOnFailure(r17);
        this.s = true;
        r1.L$0 = this;
        r1.label = 1;
        r17 = f(r1);
        if (r17 != r3) goto L22;
        return r3;
    L7:
        r1 = new DownloadTask$run$1(this, r16);
        goto L8
    }

    public final boolean f() {
        return this.s;
    }

    public final float g() {
        return this.t;
    }

    public final long h() {
        return this.A;
    }

    public final synchronized String i() {
        monitor-enter(this);
        String r0 = "state=" + this.r + " started=" + this.q + " completed=" + this.u + " prior=" + this.o + " background=" + this.p + " canRunSplit=" + this.s + " holderCount=" + this.v + " groupCount=" + this.n.size() + " fileCount=" + this.B.size() + " progress=" + this.t + " size=" + this.A;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public final void j() {
        monitor-enter(this);
        this.w = true;     // Catch: Throwable -> L15
        Pair r1 = TuplesKt.to(CollectionsKt.toSet((Iterable) ZeusTransformUtils.preCheckCast(this.x, Iterable.class, "com.obric.memorydata.plugin")), this.y);     // Catch: Throwable -> L15
        monitor-exit(this);
        Function2 r5 = (Function2) ZeusTransformUtils.preCheckCast(r1.getSecond(), Function2.class, "com.obric.memorydata.plugin");
        if (r5 != null) goto L9;
        return;
    L9:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r1.getFirst(), Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == true) goto L12;
        r5 = null;
    L12:
        if (r5 == null) goto L21;
        r5.invoke(r1.getFirst(), true);
        return;
    L21:
        return;
    L15:
        th = move-exception;
        throw th;
    }

    public final void k() {
        monitor-enter(this);
        this.w = false;     // Catch: Throwable -> L15
        Pair r1 = TuplesKt.to(CollectionsKt.toSet((Iterable) ZeusTransformUtils.preCheckCast(this.x, Iterable.class, "com.obric.memorydata.plugin")), this.y);     // Catch: Throwable -> L15
        monitor-exit(this);
        Function2 r5 = (Function2) ZeusTransformUtils.preCheckCast(r1.getSecond(), Function2.class, "com.obric.memorydata.plugin");
        if (r5 != null) goto L9;
        return;
    L9:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r1.getFirst(), Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == true) goto L12;
        r5 = null;
    L12:
        if (r5 == null) goto L21;
        r5.invoke(r1.getFirst(), false);
        return;
    L21:
        return;
    L15:
        th = move-exception;
        throw th;
    }

    public final boolean l() {
        Iterable r4 = (Iterable) ZeusTransformUtils.preCheckCast(this.B, Iterable.class, "com.obric.memorydata.plugin");
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r4, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r5 = r4.iterator();
    L4:
        if (r5.hasNext() == false) goto L10;
        b r2 = (b) ZeusTransformUtils.preCheckCast(((Pair) ZeusTransformUtils.preCheckCast(r5.next(), Pair.class, "com.obric.memorydata.plugin")).getSecond(), b.class, "com.obric.memorydata.plugin");
        if (r2.k() == false) goto L7;
        r0.add(r2);
        goto L4
    L7:
        return false;
    L10:
        List r6 = (List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.memorydata.plugin");
        return true;
    }

    public final synchronized void m() {
        monitor-enter(this);
        this.v++;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized void n() {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (this.v <= 0) goto L6;
        this.v--;     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
    }

    public final boolean o() {
        return k.a(this.u, this.C.q_(), l(), this.r, this.v);
    }

    public final boolean p() {
        return this.u;
    }
}
