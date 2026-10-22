package com.obric.aikernel.res.update;

import android.content.Context;
import android.os.Process;
import android.os.SystemClock;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.bdlocation.annotation.LocationAnnotation;
import com.bytedance.bdlocation.trace.TraceCons;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.google.gson.JsonObject;
import com.obric.aikernel.res.PackageResourceManager;
import com.obric.aikernel.res.PrmContext;
import com.obric.aikernel.sdk.ext.Params;
import com.obric.memorydata.BuildConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.AbstractCoroutineContextElement;
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
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.ak;
import kotlinx.coroutines.al;
import kotlinx.coroutines.am;
import kotlinx.coroutines.ar;
import kotlinx.coroutines.au;
import kotlinx.coroutines.ba;
import kotlinx.coroutines.cu;
import okhttp3.HttpUrl;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000¢\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 G2\u00020\u0001:\u0002GHB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004JN\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00150\u00142\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00110\u00172\u0006\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\n\u0010\u001f\u001a\u00060 j\u0002`!H\u0002J\b\u0010\"\u001a\u00020#H\u0002J\u0010\u0010$\u001a\u00020#2\b\b\u0002\u0010%\u001a\u00020&J\u001a\u0010'\u001a\u00020#2\u0006\u0010(\u001a\u00020&2\b\u0010)\u001a\u0004\u0018\u00010\nH\u0002J\u0006\u0010*\u001a\u00020#J\f\u0010+\u001a\b\u0012\u0004\u0012\u00020,0\u0017J\u001a\u0010-\u001a\u00020\u00122\u0006\u0010.\u001a\u00020\u00112\b\b\u0002\u0010/\u001a\u00020\u001cH\u0002J\u0010\u00100\u001a\u0004\u0018\u00010,2\u0006\u00101\u001a\u00020\u0011J\u0012\u00102\u001a\u0004\u0018\u00010\u00122\u0006\u0010.\u001a\u00020\u0011H\u0002J\u0010\u00103\u001a\u0004\u0018\u0001042\u0006\u0010.\u001a\u00020\u0011J\u000e\u00105\u001a\u0002062\u0006\u0010.\u001a\u00020\u0011J\b\u00107\u001a\u00020&H\u0002J\u0006\u00108\u001a\u00020#J\u0018\u00109\u001a\u00020&2\u0006\u0010.\u001a\u00020\u00112\u0006\u0010/\u001a\u00020\u001cH\u0002J\u0019\u0010:\u001a\u00020#2\u0006\u0010;\u001a\u00020<H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010=J\u000e\u0010>\u001a\u00020#2\u0006\u0010?\u001a\u00020\u0011J\u001c\u0010@\u001a\u00020\u00112\u0012\u0010A\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u0002040\u0014H\u0002J?\u0010B\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u0002040\u00142\u000e\b\u0002\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00110\u00172\u0006\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u0018\u001a\u00020\u0011H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010CJ5\u0010D\u001a\u00020E2\u000e\b\u0002\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00110\u00172\u0006\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u0018\u001a\u00020\u0011H\u0080@ø\u0001\u0000¢\u0006\u0004\bF\u0010CR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u00108\u0002X\u0083\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006I"}, d2 = {"Lcom/obric/aikernel/res/update/PackageUpdater;", "", "ctx", "Lcom/obric/aikernel/res/PrmContext;", "(Lcom/obric/aikernel/res/PrmContext;)V", "adapter", "Lcom/obric/aikernel/res/legacy/Adapter;", "modelDownloadTelemetry", "Lcom/obric/aikernel/res/update/ModelDownloadTelemetryRecorder;", "rootDir", "Ljava/io/File;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "updateDaemon", "Lcom/obric/aikernel/res/task/UpdateDaemon;", "updateTaskMap", "", "", "Lcom/obric/aikernel/res/update/UpdateTask;", "buildRequestInfoMap", "", "Lcom/obric/aikernel/res/update/MetadataRequest$IPackageInfo;", "bizs", "", Params.LORA_TYPE, "constriction", "Lcom/obric/aikernel/res/update/PackageUpdater$Constriction;", "requestTimestamp", "", "rootCoroutine", "Lkotlin/coroutines/CoroutineContext;", "bizRequestStatus", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "checkToResumeUpdateTask", "", "clean", LocationAnnotation.LightLocationType.LIGHT_LOCATION_ALL, "", "cleanUpdateDownloadsIfIdle", "onlyDownload", "externalDir", "destroy", "getAllPackageConfigs", "Lcom/obric/aikernel/res/metadata/config/PackageConfig;", "getOrCreateTask", "biz", OaidModel.KEY_TIME, "getPackageConfig", ActivityLifecycle.NAME, "getTask", "getUpdateInfo", "Lcom/obric/aikernel/res/update/UpdateResult;", "getUpdateProcess", "", "hasActiveUpdateJobUsingDownloads", CommonConsts.APM_INNER_EVENT_COST_INIT, "isTaskOutdated", "pushDebugDistribute", "distInfo", "Lcom/google/gson/JsonObject;", "(Lcom/google/gson/JsonObject;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resumeBlockedUpdateTasksIfNeed", "trigger", "summarizeUpdateResults", "results", BuildConfig.CHANNEL, "(Ljava/util/List;Lcom/obric/aikernel/res/update/PackageUpdater$Constriction;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateWithExecutionResult", "Lcom/obric/aikernel/res/update/UpdateExecutionResult;", "updateWithExecutionResult$resource_manager_release", "Companion", "Constriction", "resource_manager_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f6142a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final PrmContext f6143b;
    private final al c;
    private final com.obric.aikernel.res.legacy.a d;
    private final File e;
    private final l f;
    private final com.obric.aikernel.res.task.c g;
    private final Map<String, s> h;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\nX\u0080T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/obric/aikernel/res/update/PackageUpdater$Companion;", "", "()V", "PENDING_RETRY_TRIGGER", "", "PRIOR_CLIENT_API", "", "PRIOR_DEFAULT", "PRIOR_MAX", "RETRY_INTERVAL", "", "TAG", "UPDATE_INTERVAL", "resource_manager_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001c\b\u0086\b\u0018\u00002\u00020\u0001BI\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0007¢\u0006\u0002\u0010\fJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0007HÆ\u0003JO\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u00072\b\b\u0002\u0010\u000b\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u001f\u001a\u00020\u00072\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\u0005HÖ\u0001J\t\u0010\"\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u000b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0011\u0010\t\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u0011\u0010\n\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000e¨\u0006#"}, d2 = {"Lcom/obric/aikernel/res/update/PackageUpdater$Constriction;", "", "caller", "", "prior", "", "updateAll", "", "force", "onlyDownload", "onlyFetchConfig", TraceCons.METRIC_BACKGROUND, "(Ljava/lang/String;IZZZZZ)V", "getBackground", "()Z", "getCaller", "()Ljava/lang/String;", "getForce", "getOnlyDownload", "getOnlyFetchConfig", "getPrior", "()I", "getUpdateAll", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "toString", "resource_manager_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f6144a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f6145b;
        private final boolean c;
        private final boolean d;
        private final boolean e;
        private final boolean f;
        private final boolean g;

        public b(String r2, int r3, boolean r4, boolean r5, boolean r6, boolean r7, boolean r8) {
            Intrinsics.checkNotNullParameter(r2, "caller");
            this.f6144a = r2;
            this.f6145b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
            this.f = r7;
            this.g = r8;
        }

        public /* synthetic */ b(String r7, int r8, boolean r9, boolean r10, boolean r11, boolean r12, boolean r13, int r14, DefaultConstructorMarker r15) {
            boolean r1 = false;
            if ((r14 & 2) == 0) goto L5;
            int r0 = 0;
        L7:
            if ((r14 & 4) == 0) goto L9;
            boolean r2 = false;
        L11:
            if ((r14 & 8) == 0) goto L13;
            boolean r3 = false;
        L15:
            if ((r14 & 16) == 0) goto L17;
            boolean r4 = false;
        L19:
            if ((r14 & 32) != 0) goto L23;
            r1 = r12;
        L23:
            if ((r14 & 64) == 0) goto L25;
            boolean r5 = true;
        L26:
            this(r7, r0, r2, r3, r4, r1, r5);
            return;
        L25:
            r5 = r13;
            goto L26
        L17:
            r4 = r11;
            goto L19
        L13:
            r3 = r10;
            goto L15
        L9:
            r2 = r9;
            goto L11
        L5:
            r0 = r8;
            goto L7
        }

        public final String a() {
            return this.f6144a;
        }

        public final int b() {
            return this.f6145b;
        }

        public final boolean c() {
            return this.c;
        }

        public final boolean d() {
            return this.d;
        }

        public final boolean e() {
            return this.e;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
            return false;
        L8:
            b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f6144a, r6.f6144a) == true) goto L12;
            return false;
        L12:
            if (this.f6145b == r6.f6145b) goto L15;
            return false;
        L15:
            if (this.c == r6.c) goto L18;
            return false;
        L18:
            if (this.d == r6.d) goto L21;
            return false;
        L21:
            if (this.e == r6.e) goto L24;
            return false;
        L24:
            if (this.f == r6.f) goto L27;
            return false;
        L27:
            if (this.g == r6.g) goto L29;
            return false;
        L29:
            return true;
        }

        public final boolean f() {
            return this.f;
        }

        public final boolean g() {
            return this.g;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v11, types: [int] */
        /* JADX WARN: Type inference failed for: r0v13, types: [int] */
        /* JADX WARN: Type inference failed for: r0v5, types: [int] */
        /* JADX WARN: Type inference failed for: r0v7, types: [int] */
        /* JADX WARN: Type inference failed for: r0v9, types: [int] */
        /* JADX WARN: Type inference failed for: r1v10 */
        /* JADX WARN: Type inference failed for: r1v11 */
        /* JADX WARN: Type inference failed for: r1v12 */
        /* JADX WARN: Type inference failed for: r1v13 */
        /* JADX WARN: Type inference failed for: r1v14 */
        /* JADX WARN: Type inference failed for: r1v15 */
        /* JADX WARN: Type inference failed for: r1v16 */
        /* JADX WARN: Type inference failed for: r1v17 */
        /* JADX WARN: Type inference failed for: r1v3, types: [int] */
        /* JADX WARN: Type inference failed for: r1v5, types: [int] */
        /* JADX WARN: Type inference failed for: r1v7, types: [int] */
        /* JADX WARN: Type inference failed for: r1v9, types: [int] */
        /* JADX WARN: Type inference failed for: r2v0 */
        /* JADX WARN: Type inference failed for: r2v1, types: [int] */
        /* JADX WARN: Type inference failed for: r2v2 */
        public int hashCode() {
            int r0 = ((this.f6144a.hashCode() * 31) + Integer.hashCode(this.f6145b)) * 31;
            boolean r1 = this.c;
            ?? r2 = 1;
            ?? r3 = r1;
            if (r1 == false) goto L5;
            r3 = 1;
        L5:
            int r4 = (r0 + r3) * 31;
            boolean r5 = this.d;
            ?? r6 = r5;
            if (r5 == false) goto L8;
            r6 = 1;
        L8:
            int r7 = (r4 + r6) * 31;
            boolean r8 = this.e;
            ?? r9 = r8;
            if (r8 == false) goto L11;
            r9 = 1;
        L11:
            int r10 = (r7 + r9) * 31;
            boolean r11 = this.f;
            ?? r12 = r11;
            if (r11 == false) goto L14;
            r12 = 1;
        L14:
            int r13 = (r10 + r12) * 31;
            boolean r14 = this.g;
            if (r14 == true) goto L19;
            r2 = r14;
        L19:
            return r13 + r2;
        }

        public String toString() {
            return "Constriction(caller=" + this.f6144a + ", prior=" + this.f6145b + ", updateAll=" + this.c + ", force=" + this.d + ", onlyDownload=" + this.e + ", onlyFetchConfig=" + this.f + ", background=" + this.g + ')';
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class c<T> implements Comparator {
        public c() {
        }

        @Override // java.util.Comparator
        public final int compare(T r2, T r3) {
            return ComparisonsKt.compareValues((Comparable) ZeusTransformUtils.preCheckCast(((com.obric.aikernel.res.metadata.data.d) ZeusTransformUtils.preCheckCast(r2, com.obric.aikernel.res.metadata.data.d.class, "com.obric.memorydata.plugin")).t(), Comparable.class, "com.obric.memorydata.plugin"), (Comparable) ZeusTransformUtils.preCheckCast(((com.obric.aikernel.res.metadata.data.d) ZeusTransformUtils.preCheckCast(r3, com.obric.aikernel.res.metadata.data.d.class, "com.obric.memorydata.plugin")).t(), Comparable.class, "com.obric.memorydata.plugin"));
        }
    }

    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\u00020\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t¸\u0006\u0000"}, d2 = {"kotlinx/coroutines/CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "handleException", "", "context", "Lkotlin/coroutines/CoroutineContext;", CommonConsts.LOG_REPORT_TYPE_EXCEPTION, "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class d extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {
        public d(CoroutineExceptionHandler.a r3) {
            super((CoroutineContext.Key) ZeusTransformUtils.preCheckCast(r3, CoroutineContext.Key.class, "com.obric.memorydata.plugin"));
        }

        @Override // kotlinx.coroutines.CoroutineExceptionHandler
        public void handleException(CoroutineContext r2, Throwable r3) {
            com.obric.aikernel.runtime.utils.d.f6216a.c("PackageUpdater", ((CoroutineContext) ZeusTransformUtils.wrapperContextForParams(r2, CoroutineContext.class, "com.obric.memorydata.plugin")) + " crashed " + ExceptionsKt.stackTraceToString(r3));
        }
    }

    static {
        f6142a = new a(null);
    }

    public n(PrmContext r11) {
        Intrinsics.checkNotNullParameter(r11, "ctx");
        this.f6143b = r11;
        al r0 = am.a(ba.c().plus((CoroutineContext) ZeusTransformUtils.preCheckCast(new ak("PackageUpdater"), CoroutineContext.class, "com.obric.memorydata.plugin")).plus((CoroutineContext) ZeusTransformUtils.preCheckCast(cu.a(null, 1, null), CoroutineContext.class, "com.obric.memorydata.plugin")).plus((CoroutineContext) ZeusTransformUtils.preCheckCast((CoroutineExceptionHandler) ZeusTransformUtils.preCheckCast(new d(CoroutineExceptionHandler.f17198b), CoroutineExceptionHandler.class, "com.obric.memorydata.plugin"), CoroutineContext.class, "com.obric.memorydata.plugin")));
        this.c = r0;
        this.d = new com.obric.aikernel.res.legacy.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r11.getConfig().getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
        File r1 = new File(r11.getConfig().getRootDir(), BuildConfig.CHANNEL);
        this.e = r1;
        this.f = new l(r1, (Function1) ZeusTransformUtils.preCheckCast(new PackageUpdater$modelDownloadTelemetry$1(this), Function1.class, "com.obric.memorydata.plugin"), null, 4, null);
        this.g = new com.obric.aikernel.res.task.c(r11, r0, this);
        if (r1.exists() == true) goto L5;
        r1.mkdirs();
    L5:
        this.h = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
    }

    public static final /* synthetic */ PrmContext a(n r0) {
        return r0.f6143b;
    }

    public static final /* synthetic */ s a(n r0, String r1) {
        return r0.e(r1);
    }

    public static /* synthetic */ Object a(n r1, List r2, b r3, String r4, Continuation r5, int r6, Object r7) {
        List<String> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
        Continuation<? super Map<String, UpdateResult>> r9 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        if ((r6 & 1) == 0) goto L6;
        r8 = CollectionsKt.emptyList();
    L6:
        if ((r6 & 4) == 0) goto L9;
        r4 = "";
    L9:
        return r1.update(r8, r3, r4, r9);
    }

    private final String a(Map<String, UpdateResult> r13) {
        Map r12 = (Map) ZeusTransformUtils.wrapperContextForParams(r13, Map.class, "com.obric.memorydata.plugin");
        Iterable r14 = (Iterable) ZeusTransformUtils.preCheckCast(r12.values(), Iterable.class, "com.obric.memorydata.plugin");
        int r2 = 0;
        if (ZeusTransformUtils.instanceOf(r14, Collection.class) == true) goto L5;
    L7:
        Iterator r15 = r14.iterator();
    L9:
        if (r15.hasNext() == false) goto L15;
        if (((UpdateResult) ZeusTransformUtils.preCheckCast(r15.next(), UpdateResult.class, "com.obric.memorydata.plugin")).getSuccess() == false) goto L9;
        r2 = r2 + 1;
        if (r2 >= 0) goto L9;
        CollectionsKt.throwCountOverflow();
    L15:
        Iterable r16 = (Iterable) ZeusTransformUtils.preCheckCast(r12.values(), Iterable.class, "com.obric.memorydata.plugin");
        Collection r1 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r17 = r16.iterator();
    L17:
        if (r17.hasNext() == false) goto L22;
        Object r3 = r17.next();
        if (((UpdateResult) ZeusTransformUtils.preCheckCast(r3, UpdateResult.class, "com.obric.memorydata.plugin")).getSuccess() == true) goto L17;
        r1.add(r3);
        goto L17
    L22:
        return "resultCount=" + r12.size() + " success=" + r2 + " failed=" + (r12.size() - r2) + " failureSummary=[" + CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"), null, null, null, 5, null, (Function1) ZeusTransformUtils.preCheckCast(PackageUpdater$summarizeUpdateResults$failureSummary$2.INSTANCE, Function1.class, "com.obric.memorydata.plugin"), 23, null) + ']';
    L5:
        if (((Collection) ZeusTransformUtils.preCheckCast(r14, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L7;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final Map<String, com.obric.aikernel.res.update.d.b> a(List<String> r17, String r18, b r19, long r20, CoroutineContext r22, StringBuilder r23) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r17, List.class, "com.obric.memorydata.plugin");
        CoroutineContext r7 = (CoroutineContext) ZeusTransformUtils.wrapperContextForParams(r22, CoroutineContext.class, "com.obric.memorydata.plugin");
        Iterable r6 = (Iterable) ZeusTransformUtils.preCheckCast(r5, Iterable.class, "com.obric.memorydata.plugin");
        Collection r8 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r9 = r6.iterator();
    L4:
        if (r9.hasNext() == false) goto L74;
        String r10 = (String) ZeusTransformUtils.preCheckCast(r9.next(), String.class, "com.obric.memorydata.plugin");
        r23.append(r10);
        List r11 = CollectionsKt.sortedWith((Iterable) ZeusTransformUtils.preCheckCast(this.f6143b.getMetadataCtrl$resource_manager_release().b(r10).values(), Iterable.class, "com.obric.memorydata.plugin"), (Comparator) ZeusTransformUtils.preCheckCast(new c(), Comparator.class, "com.obric.memorydata.plugin"));
        ListIterator r12 = r11.listIterator(r11.size());
    L6:
        Pair r14 = null;
        Object[] r15 = 0;
        Object[] r16 = 0;
        Object[] r110 = 0;
        if (r12.hasPrevious() == false) goto L14;
        Object r13 = r12.previous();
        if (StringsKt.toIntOrNull(((com.obric.aikernel.res.metadata.data.d) ZeusTransformUtils.preCheckCast(r13, com.obric.aikernel.res.metadata.data.d.class, "com.obric.memorydata.plugin")).t()) == null) goto L11;
        boolean r111 = true;
    L12:
        if (r111 == false) goto L6;
    L16:
        if (ZeusTransformUtils.instanceOf(r13, com.obric.aikernel.res.metadata.data.b.class) == false) goto L18;
        com.obric.aikernel.res.metadata.data.b r112 = (com.obric.aikernel.res.metadata.data.b) ZeusTransformUtils.preCheckCast(r13, com.obric.aikernel.res.metadata.data.b.class, "com.obric.memorydata.plugin");
    L19:
        if (r112 != null) goto L21;
    L25:
        Pair r113 = new Pair(r10, new com.obric.aikernel.res.update.d.c(r110 == true ? 1 : 0, r16 == true ? 1 : 0, 3, r15 == true ? 1 : 0));
    L27:
        if (r19.d() == false) goto L29;
    L63:
        String r114 = " update by force, ";
    L64:
        r23.append(r114);
    L65:
        if (r113 == null) goto L71;
        s r21 = b(r10, r20);
        r21.a(r7, r19);
        if (r21.a().getStage() >= 100) goto L69;
        r21.a().setStage(100);
    L69:
        r14 = r113;
    L71:
        if (r14 == null) goto L4;
        r8.add(r14);
        goto L4
    L29:
        if (r19.c() == true) goto L63;
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r18, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L34;
        boolean r115 = true;
    L35:
        if (r115 == false) goto L51;
        Pair<com.obric.aikernel.res.metadata.data.f, com.obric.aikernel.res.metadata.data.b> r116 = com.obric.aikernel.res.metadata.data.f.f6090a.a(r10, r18, this.f6143b);
        if (r116 != null) goto L39;
    L47:
        boolean r117 = false;
    L48:
        if (r117 == true) goto L51;
        r114 = " update lora " + r18 + ", ";
        goto L64
    L39:
        if (((com.obric.aikernel.res.metadata.data.f) ZeusTransformUtils.preCheckCast(r116.getFirst(), com.obric.aikernel.res.metadata.data.f.class, "com.obric.memorydata.plugin")).d() == true) goto L41;
    L43:
        boolean r118 = false;
    L45:
        if (r118 != true) goto L47;
        r117 = true;
        goto L48
    L41:
        if (((com.obric.aikernel.res.metadata.data.b) ZeusTransformUtils.preCheckCast(r116.getSecond(), com.obric.aikernel.res.metadata.data.b.class, "com.obric.memorydata.plugin")).d() == false) goto L43;
        r118 = true;
    L51:
        if (a(r10, r20) == true) goto L54;
        String r119 = " merge to current request, ";
    L53:
        r23.append(r119);
        r113 = (Pair) ZeusTransformUtils.preCheckCast(null, Pair.class, "com.obric.memorydata.plugin");
        goto L65
    L54:
        if (r112 != null) goto L57;
        r114 = " update by notExist, ";
        goto L64
    L57:
        if (r112.d() == true) goto L59;
    L62:
        r114 = " update by notAvail, ";
        goto L64
    L59:
        if (r112.a_(t.a(r19.a())) == true) goto L62;
        r119 = " don't need update, ";
        goto L53
    L34:
        r115 = false;
        goto L35
    L21:
        if (r112.d() == false) goto L23;
        r113 = new Pair(r10, new com.obric.aikernel.res.update.d.C0271d(r112.t(), r112.v()));
    L24:
        if (r113 != null) goto L27;
    L23:
        r113 = (Pair) ZeusTransformUtils.preCheckCast(null, Pair.class, "com.obric.memorydata.plugin");
        goto L24
    L18:
        r112 = null;
        goto L19
    L11:
        r111 = false;
        goto L12
    L14:
        r13 = null;
        goto L16
    L74:
        return MapsKt.toMap((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r8, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"));
    }

    public static /* synthetic */ void a(n r0, boolean r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = true;
    L5:
        r0.a(r1);
    }

    private final void a(boolean r19, File r20) {
        File r8 = new File(this.e, "packages");
        boolean r9 = c();
        String r13 = o.a(r8, 0, 2, null);
        if (o.a(r8, r9, r19) == true) goto L30;
        com.obric.aikernel.runtime.utils.d r1 = com.obric.aikernel.runtime.utils.d.f6216a;
        StringBuilder r2 = new StringBuilder().append("skip clean update downloads: onlyDownload=").append(r19).append(" hasActiveUpdateJob=").append(r9).append(" packagesExists=").append(r8.exists()).append(" packagesCount=");
        String[] r3 = r8.list();
        if (r3 == null) goto L7;
        Integer r12 = Integer.valueOf(r3.length);
    L8:
        StringBuilder r4 = r2.append(r12).append(" packages=").append(r13).append(" reason=");
        if (r19 == false) goto L11;
        String r0 = "only_download_request";
    L28:
        r1.b("PackageUpdater", r4.append(r0).toString());
        return;
    L11:
        if (r9 == false) goto L14;
        r0 = "active_download_job";
        goto L28
    L14:
        if (r8.exists() == false) goto L27;
        String[] r5 = r8.list();
        if (r5 != null) goto L18;
    L24:
        boolean r10 = false;
    L25:
        if (r10 == false) goto L27;
        r0 = "pending_package_dirs_exist";
        goto L28
    L18:
        if (r5.length != 0) goto L20;
        boolean r6 = true;
    L22:
        if ((!r6) != true) goto L24;
        r10 = true;
        goto L25
    L20:
        r6 = false;
    L27:
        r0 = "not_idle";
        goto L28
    L7:
        r12 = null;
        goto L8
    L30:
        File r11 = new File(this.e, "downloads");
        Result.Companion r7 = Result.Companion;     // Catch: Throwable -> L53
        n r14 = (n) ZeusTransformUtils.preCheckCast(this, n.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L53
        boolean r15 = o.b(r11);     // Catch: Throwable -> L53
        if (r15 == false) goto L36;
        String r16 = "com.obric.memorydata.plugin";
        r14.f.a(2);     // Catch: Throwable -> L51
    L37:
        com.obric.aikernel.runtime.utils.d r17 = com.obric.aikernel.runtime.utils.d.f6216a;     // Catch: Throwable -> L51
        Class r18 = n.class;
        StringBuilder r21 = new StringBuilder().append("clean update downloads: ").append(r11.getPath()).append(" deleted=").append(r15).append(" exists=").append(r11.exists()).append(" count=");     // Catch: Throwable -> L49
        String[] r22 = r11.list();     // Catch: Throwable -> L49
        if (r22 == null) goto L42;
        Integer r23 = Integer.valueOf(r22.length);     // Catch: Throwable -> L49
    L43:
        StringBuilder r24 = r21.append(r23).append(" packagesExists=").append(r8.exists()).append(" packagesCount=");     // Catch: Throwable -> L49
        String[] r25 = r8.list();     // Catch: Throwable -> L49
        if (r25 == null) goto L46;
        Integer r26 = Integer.valueOf(r25.length);     // Catch: Throwable -> L49
    L47:
        r17.b("PackageUpdater", r24.append(r26).append(" packages=").append(r13).append(" reason=idle_no_pending_package_dirs").toString());     // Catch: Throwable -> L49
        Object r27 = Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L49
    L57:
        Throwable r28 = Result.m1424exceptionOrNullimpl(r27);
        if (r28 == null) goto L60;
        com.obric.aikernel.runtime.utils.d.f6216a.f("PackageUpdater", "clean downloads file failed " + r28);
    L60:
        if (r20 == null) goto L86;
        File r29 = o.a(r20, new File(this.f6143b.getConfig().getRootDir()), r11);
        Result.Companion r30 = Result.Companion;     // Catch: Throwable -> L71
        n r31 = (n) ZeusTransformUtils.preCheckCast(this, r18, r16);     // Catch: Throwable -> L71
        boolean r32 = o.b(r29);     // Catch: Throwable -> L71
        if (r32 == false) goto L65;
        r31.f.a(2);     // Catch: Throwable -> L71
    L65:
        com.obric.aikernel.runtime.utils.d r33 = com.obric.aikernel.runtime.utils.d.f6216a;     // Catch: Throwable -> L71
        StringBuilder r34 = new StringBuilder().append("clean external update downloads: ").append(r29.getPath()).append(" deleted=").append(r32).append(" exists=").append(r29.exists()).append(" count=");     // Catch: Throwable -> L71
        String[] r35 = r29.list();     // Catch: Throwable -> L71
        if (r35 == null) goto L68;
        Integer r110 = Integer.valueOf(r35.length);     // Catch: Throwable -> L71
    L69:
        r33.b("PackageUpdater", r34.append(r110).toString());     // Catch: Throwable -> L71
        Object r36 = Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L71
    L73:
        Throwable r37 = Result.m1424exceptionOrNullimpl(r36);
        if (r37 == null) goto L76;
        com.obric.aikernel.runtime.utils.d.f6216a.f("PackageUpdater", "clean " + r29 + " failed " + r37);
    L76:
        Result.m1420boximpl(r36);
        return;
    L68:
        r110 = null;
    L71:
        th = move-exception;
        Result.Companion r38 = Result.Companion;
        r36 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L73
    L86:
        return;
    L46:
        r26 = null;
        goto L47
    L42:
        r23 = null;
    L49:
        th = th;
    L56:
        Result.Companion r39 = Result.Companion;
        r27 = Result.m1421constructorimpl(ResultKt.createFailure(th));
    L51:
        th = th;
    L55:
        r18 = n.class;
        goto L56
    L36:
        r16 = "com.obric.memorydata.plugin";
    L53:
        th = th;
        r16 = "com.obric.memorydata.plugin";
        goto L55
    }

    private static final boolean a(File r0, String r1) {
        return r0.isDirectory();
    }

    private final boolean a(String r2, long r3) {
        s r1 = e(r2);
        boolean r0 = false;
        if (r1 == null) goto L8;
        if (r1.a(r3) == true) goto L8;
        r0 = true;
    L8:
        return !r0;
    }

    private final s b(String r7, long r8) {
        monitor-enter(this);
        s r0 = (s) ZeusTransformUtils.preCheckCast(this.h.get(r7), s.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        if (r0 != null) goto L6;
    L7:
        s r9 = new s(r7, this.c, this.f6143b, this.e, this.f);     // Catch: Throwable -> L11
        this.h.put(r7, r9);     // Catch: Throwable -> L11
        r0 = r9;
    L9:
        monitor-exit(this);
        return r0;
    L6:
        if (a(r7, r8) == false) goto L9;
    L11:
        th = move-exception;
        throw th;
    }

    public static final /* synthetic */ File b(n r0) {
        return r0.e;
    }

    public static /* synthetic */ Object b(n r1, List r2, b r3, String r4, Continuation r5, int r6, Object r7) {
        List<String> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
        Continuation<? super q> r9 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        if ((r6 & 1) == 0) goto L6;
        r8 = CollectionsKt.emptyList();
    L6:
        if ((r6 & 4) == 0) goto L9;
        r4 = "";
    L9:
        return r1.a(r8, r3, r4, r9);
    }

    private final boolean c() {
        monitor-enter(this);
        Iterable r0 = (Iterable) ZeusTransformUtils.preCheckCast(this.h.values(), Iterable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L23
        boolean r2 = true;
        if (ZeusTransformUtils.instanceOf(r0, Collection.class) == true) goto L6;
    L8:
        Iterator r1 = r0.iterator();     // Catch: Throwable -> L23
    L9:
        if (r1.hasNext() == false) goto L20;
        s r3 = (s) ZeusTransformUtils.preCheckCast(r1.next(), s.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L23
        UpdateResult r4 = r3.a();     // Catch: Throwable -> L23
        ar<UpdateResult> r5 = r3.b();     // Catch: Throwable -> L23
        if (r5 != null) goto L14;
    L16:
        boolean r6 = false;
    L18:
        if (o.a(r4, r6) == false) goto L9;
    L21:
        monitor-exit(this);
        return r2;
    L14:
        if (r5.a() != true) goto L16;
        r6 = true;
    L20:
        r2 = false;
        goto L21
    L6:
        if (((Collection) ZeusTransformUtils.preCheckCast(r0, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L8;
    L23:
        th = move-exception;
        throw th;
    }

    public static final /* synthetic */ boolean c(n r0) {
        return r0.c();
    }

    public static final /* synthetic */ al d(n r0) {
        return r0.c;
    }

    private final void d() {
        kotlinx.coroutines.i.a(this.c, null, null, (Function2) ZeusTransformUtils.preCheckCast(new PackageUpdater$checkToResumeUpdateTask$1(this, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        if (this.f6143b.getConfig().getAppConfig().getCheckAssistantAutoUpdateSwitch() == false) goto L5;
        kotlinx.coroutines.i.a(this.c, null, null, (Function2) ZeusTransformUtils.preCheckCast(new PackageUpdater$checkToResumeUpdateTask$2(this, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
    L5:
        kotlinx.coroutines.i.a(this.c, null, null, (Function2) ZeusTransformUtils.preCheckCast(new PackageUpdater$checkToResumeUpdateTask$3(this, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
    }

    private final s e(String r3) {
        monitor-enter(this);
        s r4 = (s) ZeusTransformUtils.preCheckCast(this.h.get(r3), s.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L6
        monitor-exit(this);
        return r4;
    L6:
        th = move-exception;
        throw th;
    }

    public static /* synthetic */ boolean lambda$qsDs_Jh6KdjXSW0hTe4R4NdZ_48(File r0, String r1) {
        return a(r0, r1);
    }

    public final UpdateResult a(String r18) {
        Intrinsics.checkNotNullParameter(r18, "biz");
        s r2 = e(r18);
        if (r2 == null) goto L6;
        UpdateResult r3 = r2.a();
        if (r3 == null) goto L6;
        return r3;
    L6:
        com.obric.aikernel.res.metadata.config.k r15 = s.f6149a.a(r18, this.e, this.f6143b);
        if (r15 == null) goto L9;
        UpdateResult r14 = new UpdateResult(r18, false, 0, null, false, 0, 0, null, 0, false, 1022, null);
        r14.setCfg(r15);
        return r14;
    L9:
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v2, types: [T, java.util.List] */
    public final Object a(JsonObject r33, Continuation<? super Unit> r34) {
        n r0 = this;
        Continuation r2 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r34, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r2, PackageUpdater$pushDebugDistribute$1.class) == false) goto L7;
        PackageUpdater$pushDebugDistribute$1 r4 = (PackageUpdater$pushDebugDistribute$1) ZeusTransformUtils.preCheckCast(r2, PackageUpdater$pushDebugDistribute$1.class, "com.obric.memorydata.plugin");
        if ((r4.label & Integer.MIN_VALUE) == 0) goto L7;
        r4.label -= Integer.MIN_VALUE;
    L8:
        Object r3 = r4.result;
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r6 = r4.label;
        com.obric.aikernel.res.metadata.config.d r12 = null;
        if (r6 == 0) goto L20;
        if (r6 == 1) goto L19;
        if (r6 == 2) goto L18;
        if (r6 == 3) goto L17;
        if (r6 != 4) goto L16;
        Function0 r1 = (Function0) ZeusTransformUtils.preCheckCast(r4.L$1, Function0.class, "com.obric.memorydata.plugin");
        n r7 = (n) ZeusTransformUtils.preCheckCast(r4.L$0, n.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r3);
    L109:
        Process.sendSignal(Process.myPid(), 15);
    L110:
        com.obric.aikernel.res.a.a.f6001a.b((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r7.f6143b.getConfig().getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
        r1.invoke();
    L112:
        return Unit.INSTANCE;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        ResultKt.throwOnFailure(r3);
    L89:
        Process.sendSignal(Process.myPid(), 15);
        goto L112
    L18:
        Ref.ObjectRef r8 = (Ref.ObjectRef) ZeusTransformUtils.preCheckCast(r4.L$2, Ref.ObjectRef.class, "com.obric.memorydata.plugin");
        Ref.BooleanRef r9 = (Ref.BooleanRef) ZeusTransformUtils.preCheckCast(r4.L$1, Ref.BooleanRef.class, "com.obric.memorydata.plugin");
        r7 = (n) ZeusTransformUtils.preCheckCast(r4.L$0, n.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r3);
    L75:
        List r10 = (List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.memorydata.plugin");
        Ref.ObjectRef r11 = r8;
        final List r13 = r10;
    L77:
        r1 = (Function0) ZeusTransformUtils.preCheckCast(new PackageUpdater$pushDebugDistribute$loggerPushFinished$1(r13), Function0.class, "com.obric.memorydata.plugin");
        if (r9.element == false) goto L90;
        PackageResourceManager.PresmConfig.b r14 = r7.f6143b.getConfig().getNativeLibLifeCycle();
        if (r14 == null) goto L86;
        Iterable r15 = (Iterable) ZeusTransformUtils.preCheckCast(r11.element, Iterable.class, "com.obric.memorydata.plugin");
        Collection r16 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r15, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r17 = r15.iterator();
    L83:
        if (r17.hasNext() == false) goto L85;
        r16.add(((com.obric.aikernel.res.metadata.config.i) ZeusTransformUtils.preCheckCast(r17.next(), com.obric.aikernel.res.metadata.config.i.class, "com.obric.memorydata.plugin")).a());
        goto L83
    L85:
        r14.a((List) ZeusTransformUtils.preCheckCast(r16, List.class, "com.obric.memorydata.plugin"));
    L86:
        r1.invoke();
        r4.L$0 = null;
        r4.L$1 = null;
        r4.L$2 = null;
        r4.label = 3;
        if (au.a(1000, r4) != r5) goto L89;
        return r5;
    L90:
        Iterator r18 = ((Iterable) ZeusTransformUtils.preCheckCast(r11.element, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L92:
        if (r18.hasNext() == false) goto L96;
        Object r19 = r18.next();
        if (Intrinsics.areEqual(((com.obric.aikernel.res.metadata.config.i) ZeusTransformUtils.preCheckCast(r19, com.obric.aikernel.res.metadata.config.i.class, "com.obric.memorydata.plugin")).a(), "vlm_local") == false) goto L92;
    L98:
        if (((com.obric.aikernel.res.metadata.config.i) ZeusTransformUtils.preCheckCast(r19, com.obric.aikernel.res.metadata.config.i.class, "com.obric.memorydata.plugin")) == null) goto L110;
        PackageResourceManager.PresmConfig.b r20 = r7.f6143b.getConfig().getNativeLibLifeCycle();
        if (r20 == null) goto L106;
        Iterable r21 = (Iterable) ZeusTransformUtils.preCheckCast(r11.element, Iterable.class, "com.obric.memorydata.plugin");
        Collection r22 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r21, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r23 = r21.iterator();
    L103:
        if (r23.hasNext() == false) goto L105;
        r22.add(((com.obric.aikernel.res.metadata.config.i) ZeusTransformUtils.preCheckCast(r23.next(), com.obric.aikernel.res.metadata.config.i.class, "com.obric.memorydata.plugin")).a());
        goto L103
    L105:
        r20.a((List) ZeusTransformUtils.preCheckCast(r22, List.class, "com.obric.memorydata.plugin"));
    L106:
        r1.invoke();
        r4.L$0 = r7;
        r4.L$1 = r1;
        r4.L$2 = null;
        r4.label = 4;
        if (au.a(1000, r4) != r5) goto L109;
        return r5;
    L96:
        r19 = null;
        goto L98
    L19:
        r0 = (n) ZeusTransformUtils.preCheckCast(r4.L$0, n.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r3);
    L23:
        Map r24 = (Map) ZeusTransformUtils.preCheckCast(r3, Map.class, "com.obric.memorydata.plugin");
        r9 = new Ref.BooleanRef();
        r11 = new Ref.ObjectRef();
        r11.element = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        List r25 = (List) ZeusTransformUtils.preCheckCast(r24.get("package"), List.class, "com.obric.memorydata.plugin");
        if (r25 == null) goto L76;
        Iterable r26 = (Iterable) ZeusTransformUtils.preCheckCast(r25, Iterable.class, "com.obric.memorydata.plugin");
        Collection r110 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r27 = r26.iterator();
    L27:
        if (r27.hasNext() == false) goto L71;
        com.obric.aikernel.res.metadata.config.a r111 = (com.obric.aikernel.res.metadata.config.a) ZeusTransformUtils.preCheckCast(r27.next(), com.obric.aikernel.res.metadata.config.a.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNull(r111, "null cannot be cast to non-null type com.obric.aikernel.res.metadata.config.PackageConfig");
        com.obric.aikernel.res.metadata.config.i r112 = (com.obric.aikernel.res.metadata.config.i) ZeusTransformUtils.preCheckCast(r111, com.obric.aikernel.res.metadata.config.i.class, "com.obric.memorydata.plugin");
        ((List) ZeusTransformUtils.preCheckCast(r11.element, List.class, "com.obric.memorydata.plugin")).add(r112);
        boolean r113 = r9.element;
        Iterator r28 = ((Iterable) ZeusTransformUtils.preCheckCast(r112.m(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L30:
        if (r28.hasNext() == false) goto L63;
        Object r114 = r28.next();
        com.obric.aikernel.res.metadata.config.a r29 = (com.obric.aikernel.res.metadata.config.a) ZeusTransformUtils.preCheckCast(r114, com.obric.aikernel.res.metadata.config.a.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r29, com.obric.aikernel.res.metadata.config.d.class) == false) goto L34;
        com.obric.aikernel.res.metadata.config.d r115 = (com.obric.aikernel.res.metadata.config.d) ZeusTransformUtils.preCheckCast(r29, com.obric.aikernel.res.metadata.config.d.class, "com.obric.memorydata.plugin");
    L35:
        Iterator r35 = r27;
        if (r115 == null) goto L58;
        Iterator r116 = r28;
        Object r117 = r5;
        Object r118 = r114;
        if (StringsKt.startsWith$default(r115.a(), "native_", false, 2, r12) == false) goto L57;
        com.obric.aikernel.res.metadata.data.i r30 = new com.obric.aikernel.res.metadata.data.i(r115.a(), r115.c(), r0.f6143b.getConfig());
        com.obric.aikernel.res.metadata.config.a r31 = r30.J();
        if (r31 == null) goto L42;
        String r32 = new com.obric.aikernel.res.metadata.config.c(r31.a(), r31.b(), 0, false, 12, null).g();
    L43:
        com.obric.aikernel.res.metadata.config.c r36 = (com.obric.aikernel.res.metadata.config.c) ZeusTransformUtils.preCheckCast(CollectionsKt.firstOrNull(r29.e()), com.obric.aikernel.res.metadata.config.c.class, "com.obric.memorydata.plugin");
        if (r36 == null) goto L46;
        String r37 = r36.g();
    L47:
        if (r32 != 0) goto L49;
    L51:
        boolean r38 = false;
    L52:
        Ref.ObjectRef r210 = r11;
        com.obric.aikernel.runtime.utils.d.f6216a.a("PackageUpdater", r115.a() + '@' + r115.c() + " md5 Changed:" + r38 + " installedMd5:" + r32 + " targetMd5:" + r37);
        if (r38 == false) goto L55;
    L56:
        boolean r39 = true;
    L60:
        if (r39 == true) goto L61;
        r27 = r35;
        r28 = r116;
        r5 = r117;
        r11 = r210;
        r12 = null;
        goto L30
    L61:
        Object r119 = r118;
    L64:
        if (r119 == null) goto L66;
        boolean r40 = true;
    L67:
        r9.element = r113 | r40;
        com.obric.aikernel.runtime.utils.d.f6216a.a("PackageUpdater", r112.a(), r112.c(), "pushDebugDistribute 【推送开始】" + r112 + ", " + com.obric.aikernel.res.metadata.config.b.b(r112.b(), "version_debug") + ", nativeLibChanged: " + r9.element);
        s r41 = new s(r112.a(), r0.c, r0.f6143b, r0.e, r0.f);
        r41.a(r4.getContext(), new b("push_debug", 200, false, true, false, false, false, 52, null));
        r41.a((com.obric.aikernel.res.metadata.config.k) ZeusTransformUtils.preCheckCast(r112, com.obric.aikernel.res.metadata.config.k.class, "com.obric.memorydata.plugin"));
        ar<UpdateResult> r42 = r41.b();
        if (r42 == null) goto L70;
        r110.add(r42);
    L70:
        r27 = r35;
        r5 = r117;
        r11 = r210;
        r12 = null;
        goto L27
    L66:
        r40 = false;
        goto L67
    L55:
        if (r30.j() == false) goto L56;
    L59:
        r39 = false;
        goto L60
    L49:
        if (Intrinsics.areEqual(r32, r37) == true) goto L51;
        r38 = true;
        goto L52
    L46:
        r37 = r12;
        goto L47
    L42:
        r32 = r12;
        goto L43
    L57:
        r210 = r11;
        goto L59
    L58:
        r210 = r11;
        r117 = r5;
        r116 = r28;
        r118 = r114;
        goto L59
    L34:
        r115 = r12;
        goto L35
    L63:
        r35 = r27;
        r210 = r11;
        r117 = r5;
        r119 = null;
        goto L64
    L71:
        Ref.ObjectRef r211 = r11;
        Collection r43 = (Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r110, List.class, "com.obric.memorydata.plugin"), Collection.class, "com.obric.memorydata.plugin");
        r4.L$0 = r0;
        r4.L$1 = r9;
        r4.L$2 = r211;
        r4.label = 2;
        Object r44 = kotlinx.coroutines.f.a(r43, r4);
        r5 = r5;
        if (r44 != r5) goto L74;
        return r5;
    L74:
        r7 = r0;
        r8 = r211;
        r3 = r44;
        goto L75
    L76:
        r7 = r0;
        r13 = null;
        goto L77
    L20:
        ResultKt.throwOnFailure(r3);
        com.obric.aikernel.res.update.d r45 = new com.obric.aikernel.res.update.d(r0.f6143b);
        r4.L$0 = r0;
        r4.label = 1;
        r3 = r45.a(r33, r4);
        if (r3 != r5) goto L23;
        return r5;
    L7:
        r4 = new PackageUpdater$pushDebugDistribute$1(r0, r2);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:230:0x0994 -> B:231:0x0999). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:242:0x09d4 -> B:243:0x09d5). Please report as a decompilation issue!!! */
    public final Object a(List<String> r37, b r38, String r39, Continuation<? super q> r40) {
        final n r0 = this;
        final b r9 = r38;
        String r10 = r39;
        Class<n> r11 = n.class;
        List<String> r13 = (List) ZeusTransformUtils.wrapperContextForParams(r37, List.class, "com.obric.memorydata.plugin");
        Continuation r1 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r40, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r1, PackageUpdater$updateWithExecutionResult$1.class) == false) goto L7;
        PackageUpdater$updateWithExecutionResult$1 r2 = (PackageUpdater$updateWithExecutionResult$1) ZeusTransformUtils.preCheckCast(r1, PackageUpdater$updateWithExecutionResult$1.class, "com.obric.memorydata.plugin");
        if ((r2.label & Integer.MIN_VALUE) == 0) goto L7;
        r2.label -= Integer.MIN_VALUE;
    L8:
        PackageUpdater$updateWithExecutionResult$1 r14 = r2;
        Object r3 = r14.result;
        Object r15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r14.label;
        String r6 = " updateAll=";
        Object r17 = r15;
        if (r4 != 0) goto L11;
        ResultKt.throwOnFailure(r3);
        com.obric.aikernel.runtime.utils.d.f6216a.b("PackageUpdater", "updateWithExecutionResult start caller=" + r38.a() + " updateAll=" + r38.c() + " background=" + r38.g() + " onlyDownload=" + r38.e() + " onlyFetchConfig=" + r38.f() + " force=" + r38.d() + " bizCount=" + r13.size() + " loraType=" + r10);
        StringBuilder r7 = new StringBuilder();
        if (r38.c() == false) goto L23;
        String r5 = LocationAnnotation.LightLocationType.LIGHT_LOCATION_ALL;
    L24:
        String r8 = r5;
        final CoroutineContext r12 = r14.getContext();
        PackageUpdater$updateWithExecutionResult$1 r20 = r14;
        long r16 = SystemClock.elapsedRealtime();
        String r24 = " onlyDownload=";
        Map<String, com.obric.aikernel.res.update.d.b> r18 = a(r13, r39, r38, r16, r12, r7);
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L27;
        boolean r19 = true;
    L28:
        if (r19 == false) goto L30;
        String r21 = r10;
    L31:
        r7.append("loraType:" + r21);
        PackageResourceManager.PresmConfig.d r22 = r0.f6143b.getConfig().getUpdateListener();
        if (r22 == null) goto L35;
        kotlinx.coroutines.i.a(r0.c, null, null, (Function2) ZeusTransformUtils.preCheckCast(new PackageUpdater$updateWithExecutionResult$4$1(r22, r38, r7, r8, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
    L35:
        Function2 r23 = (Function2) ZeusTransformUtils.preCheckCast(new PackageUpdater$updateWithExecutionResult$addNewTaskConfig$1(r0, r9, r12), Function2.class, "com.obric.memorydata.plugin");
        Set r25 = (Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.memorydata.plugin");
        r25.addAll((Collection) ZeusTransformUtils.preCheckCast(r13, Collection.class, "com.obric.memorydata.plugin"));
        Ref.ObjectRef r26 = new Ref.ObjectRef();
        if (r38.e() == true) goto L191;
        String r27 = "PackageUpdater";
        com.obric.aikernel.runtime.utils.d.f6216a.b(r27, "updateWithExecutionResult metadata request start caller=" + r38.a() + " updateType=" + r8 + " requestBiz=" + CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(r13, Iterable.class, "com.obric.memorydata.plugin"), null, null, null, 10, null, null, 55, null) + " loraType=" + r10);
        com.obric.aikernel.res.update.d r28 = new com.obric.aikernel.res.update.d(r0.f6143b);
        boolean r29 = r38.c();
        com.obric.aikernel.res.legacy.a r30 = r0.d;
        PackageUpdater$updateWithExecutionResult$1 r110 = r20;
        r110.L$0 = r0;
        r110.L$1 = r13;
        r110.L$2 = r9;
        r110.L$3 = r10;
        r110.L$4 = r12;
        r110.L$5 = r23;
        r110.L$6 = r25;
        r110.L$7 = r26;
        r110.L$8 = r26;
        r110.J$0 = r16;
        r110.I$0 = 0;
        r110.label = 1;
        r3 = r28.b(r29, r18, r30, r110);
        Object r31 = r17;
        if (r3 != r31) goto L40;
        return r31;
    L40:
        CoroutineContext r32 = r12;
        Ref.ObjectRef r33 = r26;
        Ref.ObjectRef r34 = r33;
        b r210 = r9;
        int r35 = 0;
        Function2 r36 = r23;
    L19:
        T r310 = r3;
        n r41 = r0;
        r33.element = r310;
        Map<String, List<com.obric.aikernel.res.metadata.config.k>> r42 = ((f) ZeusTransformUtils.preCheckCast(r34.element, f.class, "com.obric.memorydata.plugin")).a();
        com.obric.aikernel.runtime.utils.d r43 = com.obric.aikernel.runtime.utils.d.f6216a;
        int r311 = r35;
        CoroutineContext r312 = r32;
        r17 = r31;
        StringBuilder r44 = new StringBuilder().append("updateWithExecutionResult metadata request end caller=").append(r210.a()).append(" success=").append(((f) ZeusTransformUtils.preCheckCast(r34.element, f.class, "com.obric.memorydata.plugin")).c()).append(" packageConfigCount=");
        r20 = r110;
        List r45 = (List) ZeusTransformUtils.preCheckCast(r42.get("package"), List.class, "com.obric.memorydata.plugin");
        if (r45 == null) goto L44;
        int r46 = r45.size();
    L45:
        StringBuilder r47 = r44.append(r46).append(" loraConfigCount=");
        String r211 = r10;
        List r111 = (List) ZeusTransformUtils.preCheckCast(r42.get("lora"), List.class, "com.obric.memorydata.plugin");
        if (r111 == null) goto L48;
        int r112 = r111.size();
    L49:
        r43.b(r27, r47.append(r112).toString());
        if (r210.f() == true) goto L52;
        List r48 = (List) ZeusTransformUtils.preCheckCast(r42.get("package"), List.class, "com.obric.memorydata.plugin");
        if (r48 == null) goto L101;
        Iterator r113 = ((Iterable) ZeusTransformUtils.preCheckCast(r48, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L64:
        if (r113.hasNext() == false) goto L100;
        com.obric.aikernel.res.metadata.config.k r114 = (com.obric.aikernel.res.metadata.config.k) ZeusTransformUtils.preCheckCast(r113.next(), com.obric.aikernel.res.metadata.config.k.class, "com.obric.memorydata.plugin");
        Result.Companion r49 = Result.Companion;     // Catch: Throwable -> L93
        Ref.ObjectRef r212 = r34;
        Class<n> r50 = r11;
        n r51 = (n) ZeusTransformUtils.preCheckCast(r41, r50, "com.obric.memorydata.plugin");     // Catch: Throwable -> L89
        if (r210.c() == true) goto L75;
        Iterator r313 = r113;
        if (r13.contains(r114.a()) == true) goto L76;
        List<String> r115 = r13;
        long r213 = r16;
    L81:
        Object r52 = Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L83
    L96:
        Throwable r53 = Result.m1424exceptionOrNullimpl(r52);
        if (r53 == null) goto L99;
        com.obric.aikernel.runtime.utils.d.f6216a.g(r27, "process config " + r114 + " error: " + r53);
    L99:
        r113 = r313;
        r13 = r115;
        r16 = r213;
        r11 = r50;
        r34 = r212;
    L76:
        s r54 = r51.b(r114.a(), r16);     // Catch: Throwable -> L87
        r115 = r13;
        r213 = r16;
        com.obric.aikernel.runtime.utils.d.f6216a.b(r27, "update package config " + r114.a() + '@' + r114.c() + " depVersion=" + r114.l());     // Catch: Throwable -> L83
        r36.invoke(r54, r114);     // Catch: Throwable -> L83
        r25.add(r114.a());     // Catch: Throwable -> L83
    L83:
        th = th;
    L95:
        Result.Companion r116 = Result.Companion;
        r52 = Result.m1421constructorimpl(ResultKt.createFailure(th));
    L85:
        th = th;
    L92:
        r213 = r16;
    L87:
        th = th;
    L91:
        r115 = r13;
        goto L92
    L75:
        r313 = r113;
    L89:
        th = th;
        r313 = r113;
    L93:
        th = th;
        r212 = r34;
        r313 = r113;
        r213 = r16;
        r50 = r11;
        r115 = r13;
        goto L95
    L100:
        Ref.ObjectRef r214 = r34;
        long r215 = r16;
        Class<n> r55 = r11;
        Unit r56 = Unit.INSTANCE;
    L102:
        List r57 = (List) ZeusTransformUtils.preCheckCast(r42.get("lora"), List.class, "com.obric.memorydata.plugin");
        if (r57 == null) goto L189;
        Iterator r58 = ((Iterable) ZeusTransformUtils.preCheckCast(r57, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L106:
        if (r58.hasNext() == false) goto L188;
        com.obric.aikernel.res.metadata.config.k r59 = (com.obric.aikernel.res.metadata.config.k) ZeusTransformUtils.preCheckCast(r58.next(), com.obric.aikernel.res.metadata.config.k.class, "com.obric.memorydata.plugin");
        Result.Companion r60 = Result.Companion;     // Catch: Throwable -> L179
        n r61 = (n) ZeusTransformUtils.preCheckCast(r41, r55, "com.obric.memorydata.plugin");     // Catch: Throwable -> L179
        Intrinsics.checkNotNull(r59, "null cannot be cast to non-null type com.obric.aikernel.res.metadata.config.LoraConfig");     // Catch: Throwable -> L179
        com.obric.aikernel.res.metadata.config.e r117 = (com.obric.aikernel.res.metadata.config.e) ZeusTransformUtils.preCheckCast(r59, com.obric.aikernel.res.metadata.config.e.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L179
        Pair<com.obric.aikernel.res.metadata.data.f, com.obric.aikernel.res.metadata.data.b> r118 = com.obric.aikernel.res.metadata.data.f.f6090a.a(((com.obric.aikernel.res.metadata.config.e) ZeusTransformUtils.preCheckCast(r59, com.obric.aikernel.res.metadata.config.e.class, "com.obric.memorydata.plugin")).h(), r59.a(), r61.f6143b);     // Catch: Throwable -> L179
        if (r210.c() == false) goto L112;
        if (r118 == null) goto L112;
        boolean r119 = true;
    L113:
        String r120 = r211;
        boolean r121 = Intrinsics.areEqual(r120, r59.a());     // Catch: Throwable -> L176
        if (r119 == true) goto L122;
        if (r121 == true) goto L122;
        if (((com.obric.aikernel.res.metadata.config.e) ZeusTransformUtils.preCheckCast(r59, com.obric.aikernel.res.metadata.config.e.class, "com.obric.memorydata.plugin")).i() == true) goto L122;
        boolean r122 = false;
    L123:
        com.obric.aikernel.runtime.utils.d r123 = com.obric.aikernel.runtime.utils.d.f6216a;     // Catch: Throwable -> L176
        n r124 = r41;
        Iterator r314 = r58;
    L172:
        th = th;
    L181:
        long r125 = r215;
    L183:
        Result.Companion r62 = Result.Companion;
        Object r63 = Result.m1421constructorimpl(ResultKt.createFailure(th));
    L184:
        Throwable r64 = Result.m1424exceptionOrNullimpl(r63);
        if (r64 == null) goto L187;
        com.obric.aikernel.runtime.utils.d.f6216a.g(r27, "process config " + r59 + " error: " + r64);
    L187:
        r58 = r314;
        r215 = r125;
        r211 = r120;
        r41 = r124;
        goto L106
    L275:
        String r65 = r6;
        r6 = r65;
        StringBuilder r66 = new StringBuilder().append("update lora decision ").append(r59.a()).append('@').append(r59.c()).append(r65).append(r210.c()).append(" matchedCurrentLora=");     // Catch: Throwable -> L172
        if (r118 == null) goto L137;
        boolean r67 = true;
    L138:
        StringBuilder r68 = r66.append(r67).append(" loraTypeMatch=");     // Catch: Throwable -> L172
        if (r121 == false) goto L141;
        boolean r69 = true;
    L142:
        StringBuilder r70 = r68.append(r69).append(" requestLoraType=").append(r120).append(" autoDownload=").append(((com.obric.aikernel.res.metadata.config.e) ZeusTransformUtils.preCheckCast(r59, com.obric.aikernel.res.metadata.config.e.class, "com.obric.memorydata.plugin")).i()).append(" action=");     // Catch: Throwable -> L172
        if (r122 == false) goto L145;
        String r71 = "enqueue_task";
    L146:
        r123.b(r27, r70.append(r71).toString());     // Catch: Throwable -> L172
        if (r122 == false) goto L154;
        r125 = r215;
        s r72 = r61.b(r59.a(), r125);     // Catch: Throwable -> L165
        com.obric.aikernel.runtime.utils.d.f6216a.a(r27, new StringBuilder().append("update lora config enqueue ").append(r59.a()).append('@').append(r59.c()).append(" task=").append(r72).toString());     // Catch: Throwable -> L165
        r36.invoke(r72, r59);     // Catch: Throwable -> L165
        Object r73 = Boxing.boxBoolean(r25.add(r59.a()));     // Catch: Throwable -> L165
    L263:
        r63 = Result.m1421constructorimpl(r73);     // Catch: Throwable -> L161
    L161:
        th = th;
    L163:
        th = th;
    L165:
        th = th;
        goto L183
    L154:
        r125 = r215;
        com.obric.aikernel.runtime.utils.d.f6216a.a(r27, "update lora config saveConfigOnly " + r59.a() + '@' + r59.c());     // Catch: Throwable -> L163
        new com.obric.aikernel.res.metadata.data.f(r59.a(), r59.c(), r61.f6143b.getConfig()).a((com.obric.aikernel.res.metadata.config.a) ZeusTransformUtils.preCheckCast(r59, com.obric.aikernel.res.metadata.config.a.class, "com.obric.memorydata.plugin"), true);     // Catch: Throwable -> L161
        r73 = Unit.INSTANCE;     // Catch: Throwable -> L161
        goto L263
    L145:
        r71 = "save_config_only";
        goto L146
    L141:
        r69 = false;
        goto L142
    L137:
        r67 = false;
    L167:
        th = th;
        r6 = r65;
    L169:
        th = th;
        r125 = r215;
    L174:
        th = th;
    L178:
        r314 = r58;
    L122:
        r122 = true;
    L176:
        th = th;
        r124 = r41;
    L112:
        r119 = false;
    L179:
        th = th;
        r124 = r41;
        r314 = r58;
        r120 = r211;
        goto L181
    L188:
        n r126 = r41;
        Unit r74 = Unit.INSTANCE;
    L190:
        int r75 = r311;
        CoroutineContext r76 = r312;
        r0 = r126;
        r9 = r210;
        Ref.ObjectRef r77 = r214;
    L192:
        com.obric.aikernel.runtime.utils.d.f6216a.b(r27, "updateWithExecutionResult prepared targets caller=" + r9.a() + " targetCount=" + r25.size() + " targets=" + CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(r25, Iterable.class, "com.obric.memorydata.plugin"), null, null, null, 15, null, null, 55, null));
        com.obric.aikernel.runtime.utils.d.f6216a.b(r27, "updateWithExecutionResult awaitAll start caller=" + r9.a() + " targetCount=" + r25.size());
        Iterable r78 = (Iterable) ZeusTransformUtils.preCheckCast(r25, Iterable.class, "com.obric.memorydata.plugin");
        int r79 = 10;
        Collection r80 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r78, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r81 = r78.iterator();
    L194:
        if (r81.hasNext() == false) goto L196;
        r80.add(kotlinx.coroutines.i.b(r0.c, null, null, (Function2) ZeusTransformUtils.preCheckCast(new PackageUpdater$updateWithExecutionResult$result$1$1(r0, (String) ZeusTransformUtils.preCheckCast(r81.next(), String.class, "com.obric.memorydata.plugin"), r9, r76, null), Function2.class, "com.obric.memorydata.plugin"), 3, null));
        goto L194
    L196:
        Collection r82 = (Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r80, List.class, "com.obric.memorydata.plugin"), Collection.class, "com.obric.memorydata.plugin");
        PackageUpdater$updateWithExecutionResult$1 r83 = r20;
        r83.L$0 = r0;
        r83.L$1 = r9;
        r83.L$2 = r77;
        File r84 = null;
        r83.L$3 = null;
        r83.L$4 = null;
        r83.L$5 = null;
        r83.L$6 = null;
        r83.L$7 = null;
        r83.L$8 = null;
        r83.I$0 = r75;
        r83.label = 2;
        r3 = kotlinx.coroutines.f.a(r82, r83);
        Object r85 = r17;
        if (r3 != r85) goto L199;
        return r85;
    L199:
        int r315 = r75;
        n r86 = r0;
        int r87 = r315;
    L200:
        Iterable r88 = (Iterable) ZeusTransformUtils.preCheckCast(r3, Iterable.class, "com.obric.memorydata.plugin");
        Map r89 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r88, r79)), 16)), Map.class, "com.obric.memorydata.plugin");
        n r127 = r86;
        Iterator r90 = r88.iterator();
        Ref.ObjectRef r91 = r77;
        Map r92 = r89;
    L202:
        if (r90.hasNext() == false) goto L248;
        Object r93 = r90.next();
        UpdateResult r128 = (UpdateResult) ZeusTransformUtils.preCheckCast(r93, UpdateResult.class, "com.obric.memorydata.plugin");
        if (o.b(r128, r9.g()) == false) goto L232;
        s r129 = r127.e(r128.getBiz());
        com.obric.aikernel.runtime.utils.d r130 = com.obric.aikernel.runtime.utils.d.f6216a;
        StringBuilder r94 = new StringBuilder().append("updateWithExecutionResult foreground retry start caller=").append(r9.a()).append(" result=").append(o.a(r128)).append(" taskActive=");
        if (r129 == null) goto L210;
        ar<UpdateResult> r131 = r129.b();
        if (r131 == null) goto L210;
        Boolean r132 = Boxing.boxBoolean(r131.a());
    L211:
        StringBuilder r95 = r94.append(r132).append(" taskResult=");
        if (r129 == null) goto L216;
        UpdateResult r133 = r129.a();
        if (r133 == null) goto L216;
        String r134 = o.a(r133);
    L217:
        r130.b(r27, r95.append(r134).toString());
        if (r129 == null) goto L220;
        r129.a(r9);
        Unit r96 = Unit.INSTANCE;
    L220:
        String r97 = r128.getBiz();
        if (r129 == null) goto L226;
        UpdateResult r135 = r129.a();
        if (r135 == null) goto L226;
        UpdateResult r136 = r135;
    L227:
        String r216 = r27;
        Function1 r137 = (Function1) ZeusTransformUtils.preCheckCast(new PackageUpdater$updateWithExecutionResult$result$2$2(r129, r128, r9, null), Function1.class, "com.obric.memorydata.plugin");
        r83.L$0 = r127;
        r83.L$1 = r9;
        r83.L$2 = r91;
        r83.L$3 = r92;
        r83.L$4 = r90;
        r83.L$5 = r93;
        r83.L$6 = r92;
        r83.I$0 = r87;
        r83.label = 3;
        Object r98 = o.a(r97, r9, r136, "foreground_retry", r137, r83);
        if (r98 != r85) goto L230;
        return r85;
    L230:
        r14 = r83;
        Object r138 = r85;
        Object r99 = r93;
        r3 = r98;
        Map r100 = r92;
        n r139 = r127;
    L231:
        r128 = (UpdateResult) ZeusTransformUtils.preCheckCast(r3, UpdateResult.class, "com.obric.memorydata.plugin");
        r93 = r99;
        r83 = r14;
        r85 = r138;
        n r140 = r139;
    L243:
        String r141 = r216;
        com.obric.aikernel.runtime.utils.d.f6216a.b(r141, "updateWithExecutionResult target final caller=" + r9.a() + ' ' + o.a(r128));
        PackageResourceManager.PresmConfig.d r101 = r140.f6143b.getConfig().getUpdateListener();
        if (r101 == null) goto L246;
        File r102 = null;
        kotlinx.coroutines.i.a(r140.c, null, null, (Function2) ZeusTransformUtils.preCheckCast(new PackageUpdater$updateWithExecutionResult$result$2$5$1$1(r101, r128, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        Unit r103 = Unit.INSTANCE;
    L247:
        r92.put(r128.getBiz(), r93);
        r92 = r100;
        r27 = r141;
        r84 = r102;
        r83 = r83;
        r127 = r140;
        goto L202
    L246:
        r102 = null;
    L226:
        r136 = r128;
    L216:
        r134 = null;
    L210:
        r132 = null;
        goto L211
    L232:
        r216 = r27;
        f r104 = (f) ZeusTransformUtils.preCheckCast(r91.element, f.class, "com.obric.memorydata.plugin");
        if (r104 == null) goto L242;
        MetadataRequestException r105 = r104.b();
        if (r105 == null) goto L242;
        if (o.a(r128, (f) ZeusTransformUtils.preCheckCast(r91.element, f.class, "com.obric.memorydata.plugin")) == true) goto L240;
        r105 = null;
    L240:
        if (r105 == null) goto L242;
        o.a(r128, r105);
        Unit r106 = Unit.INSTANCE;
    L242:
        r100 = r92;
        r140 = r127;
        goto L243
    L248:
        File r107 = r84;
        String r142 = r27;
        com.obric.aikernel.runtime.utils.d.f6216a.b(r142, "updateWithExecutionResult awaitAll end caller=" + r9.a() + ' ' + r127.a(r92));
        boolean r108 = r9.e();
        if (r127.f6143b.getConfig().getUseObricDownloader() == false) goto L251;
        r107 = new File("/data/download_server");
    L251:
        r127.a(r108, r107);
        com.obric.aikernel.runtime.utils.d.f6216a.b(r142, "updateWithExecutionResult clean done caller=" + r9.a() + r24 + r9.e());
        return new q(r92, (f) ZeusTransformUtils.preCheckCast(r91.element, f.class, "com.obric.memorydata.plugin"), r87);
    L189:
        r126 = r41;
        goto L190
    L101:
        r214 = r34;
        r215 = r16;
        r55 = r11;
        goto L102
    L52:
        if (((f) ZeusTransformUtils.preCheckCast(r34.element, f.class, "com.obric.memorydata.plugin")).c() == false) goto L57;
        File r109 = new File(r41.e, "packages");
        List r143 = (List) ZeusTransformUtils.preCheckCast(r42.get("package"), List.class, "com.obric.memorydata.plugin");
        if (r143 != null) goto L56;
        r143 = CollectionsKt.emptyList();
    L56:
        int r144 = o.a(r109, (Collection) ZeusTransformUtils.preCheckCast(r143, Collection.class, "com.obric.memorydata.plugin"));
    L58:
        com.obric.aikernel.runtime.utils.d.f6216a.b(r27, "updateWithExecutionResult onlyFetchConfig return caller=" + r210.a() + " cachedPackageCount=" + r144);
        return new q(MapsKt.emptyMap(), (f) ZeusTransformUtils.preCheckCast(r34.element, f.class, "com.obric.memorydata.plugin"), r144);
    L57:
        r144 = r311;
        goto L58
    L48:
        r112 = 0;
        goto L49
    L44:
        r46 = 0;
        goto L45
    L191:
        r27 = "PackageUpdater";
        r76 = r12;
        r77 = r26;
        r75 = 0;
        goto L192
    L30:
        r21 = null;
        goto L31
    L27:
        r19 = false;
        goto L28
    L23:
        r5 = "specific";
        goto L24
    L11:
        if (r4 == 1) goto L18;
        if (r4 == 2) goto L17;
        if (r4 != 3) goto L16;
        r87 = r14.I$0;
        r92 = (Map) ZeusTransformUtils.preCheckCast(r14.L$6, Map.class, "com.obric.memorydata.plugin");
        r99 = r14.L$5;
        r90 = (Iterator) ZeusTransformUtils.preCheckCast(r14.L$4, Iterator.class, "com.obric.memorydata.plugin");
        Map r145 = (Map) ZeusTransformUtils.preCheckCast(r14.L$3, Map.class, "com.obric.memorydata.plugin");
        r91 = (Ref.ObjectRef) ZeusTransformUtils.preCheckCast(r14.L$2, Ref.ObjectRef.class, "com.obric.memorydata.plugin");
        r9 = (b) ZeusTransformUtils.preCheckCast(r14.L$1, b.class, "com.obric.memorydata.plugin");
        n r146 = (n) ZeusTransformUtils.preCheckCast(r14.L$0, r11, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r3);
        r24 = " onlyDownload=";
        r100 = r145;
        r216 = "PackageUpdater";
        r138 = r17;
        r139 = r146;
        goto L231
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        r87 = r14.I$0;
        r77 = (Ref.ObjectRef) ZeusTransformUtils.preCheckCast(r14.L$2, Ref.ObjectRef.class, "com.obric.memorydata.plugin");
        b r147 = (b) ZeusTransformUtils.preCheckCast(r14.L$1, b.class, "com.obric.memorydata.plugin");
        r86 = (n) ZeusTransformUtils.preCheckCast(r14.L$0, r11, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r3);
        r9 = r147;
        r24 = " onlyDownload=";
        r83 = r14;
        r27 = "PackageUpdater";
        r85 = r17;
        r84 = null;
        r79 = 10;
        goto L200
    L18:
        int r148 = r14.I$0;
        long r149 = r14.J$0;
        r33 = (Ref.ObjectRef) ZeusTransformUtils.preCheckCast(r14.L$8, Ref.ObjectRef.class, "com.obric.memorydata.plugin");
        r34 = (Ref.ObjectRef) ZeusTransformUtils.preCheckCast(r14.L$7, Ref.ObjectRef.class, "com.obric.memorydata.plugin");
        r25 = (Set) ZeusTransformUtils.preCheckCast(r14.L$6, Set.class, "com.obric.memorydata.plugin");
        r36 = (Function2) ZeusTransformUtils.preCheckCast(r14.L$5, Function2.class, "com.obric.memorydata.plugin");
        CoroutineContext r150 = (CoroutineContext) ZeusTransformUtils.preCheckCast(r14.L$4, CoroutineContext.class, "com.obric.memorydata.plugin");
        String r151 = (String) ZeusTransformUtils.preCheckCast(r14.L$3, String.class, "com.obric.memorydata.plugin");
        r210 = (b) ZeusTransformUtils.preCheckCast(r14.L$2, b.class, "com.obric.memorydata.plugin");
        r13 = (List) ZeusTransformUtils.preCheckCast(r14.L$1, List.class, "com.obric.memorydata.plugin");
        r0 = (n) ZeusTransformUtils.preCheckCast(r14.L$0, r11, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r3);
        r24 = " onlyDownload=";
        r32 = r150;
        r110 = r14;
        r27 = "PackageUpdater";
        r10 = r151;
        r16 = r149;
        r31 = r17;
        r35 = r148;
    L7:
        r2 = new PackageUpdater$updateWithExecutionResult$1(r0, r1);
        goto L8
    }

    public final void a() {
        com.obric.aikernel.runtime.utils.d.f6216a.b("PackageUpdater", "init start rootDir=" + this.e);
        this.g.a();
        d();
        com.obric.aikernel.runtime.utils.d.f6216a.b("PackageUpdater", "init end rootDir=" + this.e);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void a(boolean r25) {
        n r1 = this;
        if (r1.f6143b.getConfig().getUseObricDownloader() == false) goto L5;
        File r4 = new File("/data/download_server");
    L6:
        File r0 = new File(r1.e, "packages");
        int r7 = 0;
        String r9 = "PackageUpdater";
        com.obric.aikernel.runtime.utils.d.f6216a.b("PackageUpdater", new StringBuilder().append("clean start all=").append(r25).append(" packagesExists=").append(r0.exists()).append(" packages=").append(o.a(r0, 0, 2, null)).append(" activeDownloadJob=").append(c()).toString());
        File[] r5 = r0.listFiles();
        boolean r6 = true;
        if (r5 == null) goto L71;
        Intrinsics.checkNotNullExpressionValue(r5, "listFiles()");
        int r11 = r5.length;
        int r12 = 0;
        n r2 = r1;
    L9:
        if (r12 >= r11) goto L71;
        File r13 = r5[r12];
        String r14 = r13.getName();
        s.a r3 = s.f6149a;
        File r15 = r2.e;
        Intrinsics.checkNotNullExpressionValue(r14, ActivityLifecycle.NAME);
        com.obric.aikernel.res.metadata.config.k r8 = r3.a(r15, r14, r2.f6143b.getConfig());
        com.obric.aikernel.res.metadata.data.d.a r10 = com.obric.aikernel.res.metadata.data.d.f;
        Intrinsics.checkNotNullExpressionValue(r13, "pkgRoot");
        com.obric.aikernel.res.metadata.config.a r16 = r10.a("package", r14, r13);
        if (r16 == null) goto L15;
        String r17 = r16.c();
        if (r17 == null) goto L15;
        int r18 = com.obric.aikernel.res.metadata.data.b.e.a(r17);
    L16:
        com.obric.aikernel.res.metadata.data.b r19 = r2.f6143b.getMetadataCtrl$resource_manager_release().a(r14);
        if (r19 == null) goto L21;
        String r20 = r19.t();
        if (r20 == null) goto L21;
        int r21 = com.obric.aikernel.res.metadata.data.b.e.a(r20);
    L22:
        if (r19 != null) goto L24;
    L26:
        boolean r22 = false;
    L27:
        File[] r110 = r5;
        int r111 = r11;
        File r112 = r4;
        int r23 = r12;
        if (r22 == false) goto L57;
        if (r21 >= r18) goto L93;
        com.obric.aikernel.runtime.utils.d r24 = com.obric.aikernel.runtime.utils.d.f6216a;
        String r26 = "clean pending package dir keep biz=" + r14 + " path=" + r13.getPath() + " pendingCfg=" + o.a((com.obric.aikernel.res.metadata.config.a) ZeusTransformUtils.preCheckCast(r8, com.obric.aikernel.res.metadata.config.a.class, "com.obric.memorydata.plugin")) + " packageCfg=" + o.a(r16) + " current=" + r19.t() + '@' + r19.v() + " currentVersionCode=" + r21 + " targetVersionCode=" + r18 + " reason=current_version_lt_pending";
        com.obric.aikernel.runtime.utils.d r27 = r24;
    L56:
        r27.a(r9, r26);
    L70:
        r12 = r23 + 1;
        r5 = r110;
        r11 = r111;
        r4 = r112;
        r6 = true;
        r7 = 0;
        r2 = this;
        goto L9
    L93:
        Result.Companion r28 = Result.Companion;     // Catch: Throwable -> L32
        n r29 = (n) ZeusTransformUtils.preCheckCast(r2, n.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L32
        Object r30 = Result.m1421constructorimpl(Boolean.valueOf(FilesKt.deleteRecursively(r13)));     // Catch: Throwable -> L32
    L35:
        if (Result.m1428isSuccessimpl(r30) == false) goto L52;
        String r210 = r9;
        boolean r31 = ((Boolean) ZeusTransformUtils.preCheckCast(r30, Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
        if (r31 == false) goto L49;
        l r32 = r2.f;
        if (r8 == null) goto L45;
        String r211 = r8.getType();
        if (r211 == null) goto L45;
    L43:
        String r33 = r211;
    L48:
        r32.a(r33, r14, 1);
    L50:
        com.obric.aikernel.runtime.utils.d r34 = com.obric.aikernel.runtime.utils.d.f6216a;
        StringBuilder r35 = new StringBuilder().append("clean pending package dir delete biz=").append(r14).append(" path=").append(r13.getPath()).append(" deleted=").append(r31).append(" exists=").append(r13.exists()).append(" pendingCfg=").append(o.a((com.obric.aikernel.res.metadata.config.a) ZeusTransformUtils.preCheckCast(r8, com.obric.aikernel.res.metadata.config.a.class, "com.obric.memorydata.plugin"))).append(" packageCfg=").append(o.a(r16)).append(" current=").append(r19.t()).append('@').append(r19.v()).append(" currentVersionCode=").append(r21).append(" targetVersionCode=");
        r18 = r18;
        r9 = r210;
        r34.b(r9, r35.append(r18).append(" reason=current_version_ge_pending").toString());
    L45:
        if (r16 == null) goto L47;
        r211 = r16.getType();
        goto L43
    L47:
        r33 = null;
        goto L48
    L49:
        r18 = r18;
    L52:
        Throwable r36 = Result.m1424exceptionOrNullimpl(r30);
        if (r36 == null) goto L70;
        r9 = r9;
        com.obric.aikernel.runtime.utils.d.f6216a.f(r9, "clean pending package dir delete failed biz=" + r14 + " path=" + r13.getPath() + " pendingCfg=" + o.a((com.obric.aikernel.res.metadata.config.a) ZeusTransformUtils.preCheckCast(r8, com.obric.aikernel.res.metadata.config.a.class, "com.obric.memorydata.plugin")) + " packageCfg=" + o.a(r16) + " current=" + r19.t() + '@' + r19.v() + " currentVersionCode=" + r21 + " targetVersionCode=" + r18 + ' ' + r36);
    L32:
        th = move-exception;
        Result.Companion r212 = Result.Companion;
        r30 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L35
    L57:
        com.obric.aikernel.runtime.utils.d r37 = com.obric.aikernel.runtime.utils.d.f6216a;
        StringBuilder r38 = new StringBuilder().append("clean pending package dir keep biz=").append(r14).append(" path=").append(r13.getPath()).append(" pendingCfg=").append(o.a((com.obric.aikernel.res.metadata.config.a) ZeusTransformUtils.preCheckCast(r8, com.obric.aikernel.res.metadata.config.a.class, "com.obric.memorydata.plugin"))).append(" packageCfg=").append(o.a(r16)).append(" current=");
        if (r19 == null) goto L60;
        String r39 = r19.t();
    L61:
        StringBuilder r40 = r38.append(r39).append('@');
        if (r19 == null) goto L64;
        String r41 = r19.v();
    L65:
        StringBuilder r42 = r40.append(r41).append(" currentAvailable=");
        if (r19 == null) goto L68;
        Boolean r43 = Boolean.valueOf(r19.d());
    L69:
        r26 = r42.append(r43).append(" currentVersionCode=").append(r21).append(" targetVersionCode=").append(r18).append(" reason=current_unavailable").toString();
        r27 = r37;
        goto L56
    L68:
        r43 = null;
        goto L69
    L64:
        r41 = null;
        goto L65
    L60:
        r39 = null;
        goto L61
    L24:
        if (r19.d() != r6) goto L26;
        r22 = r6;
    L21:
        r21 = 0;
    L15:
        r18 = r7;
    L71:
        File r44 = r4;
        boolean r45 = r7;
        a(r45, r44);
        if (r25 == true) goto L74;
        return;
    L74:
        File[] r46 = new File[2];
        r46[r45 ? 1 : 0] = this.e;
        r46[1] = r44;
        Iterator r47 = ((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.listOf(r46), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L76:
        if (r47.hasNext() == false) goto L92;
        File r48 = (File) ZeusTransformUtils.preCheckCast(r47.next(), File.class, "com.obric.memorydata.plugin");
        if (r48 == null) goto L76;
        String[] r49 = r48.list($$Lambda$n$qsDs_Jh6KdjXSW0hTe4R4NdZ_48.INSTANCE);
        if (r49 == null) goto L76;
        int r50 = r49.length;
        int r51 = r45 ? 1 : 0;
    L82:
        if (r51 >= r50) goto L76;
        File r52 = new File(this.e, r49[r51]);
        String[] r53 = r52.list();
        if (r53 == null) goto L91;
        Intrinsics.checkNotNullExpressionValue(r53, "list()");
        int r54 = r53.length;
        int r55 = r45 ? 1 : 0;
    L86:
        if (r55 >= r54) goto L91;
        File r113 = new File(r52, r53[r55]);
        com.obric.aikernel.res.task.b.a r114 = com.obric.aikernel.res.task.b.f6101a;
        PackageResourceManager.PresmConfig r115 = this.f6143b.getConfig();
        String r116 = r113.getPath();
        Intrinsics.checkNotNullExpressionValue(r116, "file.path");
        if (r114.a(r115, r116) == false) goto L90;
        FilesKt.deleteRecursively(r113);
    L90:
        r55 = r55 + 1;
    L91:
        r51 = r51 + 1;
        goto L82
    L92:
        return;
    L5:
        r4 = null;
        goto L6
    }

    public final com.obric.aikernel.res.metadata.config.i b(String r3) {
        Intrinsics.checkNotNullParameter(r3, ActivityLifecycle.NAME);
        com.obric.aikernel.res.metadata.config.k r2 = s.f6149a.a(r3, this.e, this.f6143b);
        if (ZeusTransformUtils.instanceOf(r2, com.obric.aikernel.res.metadata.config.i.class) == true) goto L7;
        return null;
    L7:
        return (com.obric.aikernel.res.metadata.config.i) ZeusTransformUtils.preCheckCast(r2, com.obric.aikernel.res.metadata.config.i.class, "com.obric.memorydata.plugin");
    }

    public final List<com.obric.aikernel.res.metadata.config.i> b() {
        Set r0 = (Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.memorydata.plugin");
        r0.addAll((Collection) ZeusTransformUtils.preCheckCast(this.f6143b.getMetadataCtrl$resource_manager_release().c(), Collection.class, "com.obric.memorydata.plugin"));
        String[] r1 = new File(this.e, "packages").list();
        if (r1 == null) goto L5;
        CollectionsKt.addAll((Collection) ZeusTransformUtils.preCheckCast(r0, Collection.class, "com.obric.memorydata.plugin"), r1);
    L5:
        Iterable r2 = (Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin");
        Collection r3 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r4 = r2.iterator();
    L7:
        if (r4.hasNext() == false) goto L15;
        String r5 = (String) ZeusTransformUtils.preCheckCast(r4.next(), String.class, "com.obric.memorydata.plugin");
        com.obric.aikernel.res.metadata.config.k r6 = s.f6149a.a(r5, this.e, this.f6143b);
        if (ZeusTransformUtils.instanceOf(r6, com.obric.aikernel.res.metadata.config.i.class) == false) goto L11;
        com.obric.aikernel.res.metadata.config.i r7 = (com.obric.aikernel.res.metadata.config.i) ZeusTransformUtils.preCheckCast(r6, com.obric.aikernel.res.metadata.config.i.class, "com.obric.memorydata.plugin");
    L12:
        if (r7 == null) goto L7;
        r3.add(r7);
        goto L7
    L11:
        r7 = null;
        goto L12
    L15:
        return (List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.memorydata.plugin");
    }

    public final float c(String r2) {
        Intrinsics.checkNotNullParameter(r2, "biz");
        s r1 = e(r2);
        if (r1 != null) goto L7;
        return 0.0f;
    L7:
        return r1.c();
    }

    public final void d(final String r23) {
        Intrinsics.checkNotNullParameter(r23, "trigger");
        final long r8 = SystemClock.elapsedRealtime();
        boolean r1 = c();
        File r2 = new File(this.e, "packages");
        boolean r3 = com.obric.aikernel.runtime.utils.h.f6225a.b((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f6143b.getConfig().getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
        if (com.obric.aikernel.runtime.utils.h.f6225a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f6143b.getConfig().getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")) == false) goto L5;
    L8:
        boolean r4 = true;
    L9:
        monitor-enter(this);
        Map r5 = MapsKt.toMutableMap(this.h);     // Catch: Throwable -> L38
        List<String> r6 = o.a(r2);     // Catch: Throwable -> L38
        String r10 = CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.memorydata.plugin"), null, null, null, 0, null, (Function1) ZeusTransformUtils.preCheckCast(new PackageUpdater$resumeBlockedUpdateTasksIfNeed$1$pendingConfigs$1(this), Function1.class, "com.obric.memorydata.plugin"), 31, null);     // Catch: Throwable -> L38
        com.obric.aikernel.runtime.utils.d r11 = com.obric.aikernel.runtime.utils.d.f6216a;     // Catch: Throwable -> L38
        StringBuilder r13 = new StringBuilder().append("resumeBlockedUpdateTasksIfNeed trigger=").append(r23).append(" pendingCount=").append(r6.size()).append(" pending=");     // Catch: Throwable -> L38
        CharSequence r12 = (CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L38
        if (r12.length() != 0) goto L13;
        boolean r14 = true;
    L14:
        if (r14 == false) goto L16;
        r12 = HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
    L16:
        r11.a("PackageUpdater", r13.append((String) ZeusTransformUtils.preCheckCast(r12, String.class, "com.obric.memorydata.plugin")).append(" taskCount=").append(r5.size()).append(" activeDownloadJob=").append(r1).append(" validatedNetwork=").append(r3).append(" unmeteredNetwork=").append(r4).append(" packages=").append(o.a(r2, 0, 2, null)).toString());     // Catch: Throwable -> L38
        Iterator r7 = ((Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Throwable -> L38
    L18:
        if (r7.hasNext() == false) goto L22;
        String r9 = (String) ZeusTransformUtils.preCheckCast(r7.next(), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L38
        if (r5.containsKey(r9) == true) goto L18;
        r5.put(r9, b(r9, r8));     // Catch: Throwable -> L38
        goto L18
    L22:
        List r15 = CollectionsKt.toList((Iterable) ZeusTransformUtils.preCheckCast(r5.values(), Iterable.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L38
        monitor-exit(this);
        Iterator r16 = ((Iterable) ZeusTransformUtils.preCheckCast(r15, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L26:
        if (r16.hasNext() == false) goto L37;
        final s r17 = (s) ZeusTransformUtils.preCheckCast(r16.next(), s.class, "com.obric.memorydata.plugin");
        ar<UpdateResult> r18 = r17.b();
        if (r18 == null) goto L33;
        if (r18.a() != true) goto L33;
        boolean r19 = true;
    L34:
        if (r19 == false) goto L35;
        com.obric.aikernel.runtime.utils.d.f6216a.a("PackageUpdater", "resumeBlockedUpdateTasksIfNeed skip active biz=" + r17.a().getBiz() + " trigger=" + r23 + " stage=" + r17.a().getStage() + " stageLabel=" + o.a(r17.a().getStage()) + " result=" + o.a(r17.a()));
        goto L26
    L35:
        o.a(r23, r17.a().getBiz(), (Function0) ZeusTransformUtils.preCheckCast(new PackageUpdater$resumeBlockedUpdateTasksIfNeed$2$1(this, r17, r23, r8), Function0.class, "com.obric.memorydata.plugin"));
    L33:
        r19 = false;
        goto L34
    L37:
        return;
    L13:
        r14 = false;
    L38:
        th = move-exception;
        throw th;
    L5:
        if (com.obric.aikernel.runtime.utils.h.f6225a.c((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f6143b.getConfig().getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")) == true) goto L8;
        r4 = false;
        goto L9
    }

    public final Object update(List<String> r12, b r13, String r14, Continuation<? super Map<String, UpdateResult>> r15) {
        List<String> r16 = (List) ZeusTransformUtils.wrapperContextForParams(r12, List.class, "com.obric.memorydata.plugin");
        Continuation r17 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r15, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r17, PackageUpdater$update$1.class) == false) goto L7;
        PackageUpdater$update$1 r1 = (PackageUpdater$update$1) ZeusTransformUtils.preCheckCast(r17, PackageUpdater$update$1.class, "com.obric.memorydata.plugin");
        if ((r1.label & Integer.MIN_VALUE) == 0) goto L7;
        r1.label -= Integer.MIN_VALUE;
    L8:
        Object r18 = r1.result;
        Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r1.label;
        if (r4 == 0) goto L16;
        if (r4 != 1) goto L15;
        n r11 = (n) ZeusTransformUtils.preCheckCast(r1.L$1, n.class, "com.obric.memorydata.plugin");
        r13 = (b) ZeusTransformUtils.preCheckCast(r1.L$0, b.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r18);     // Catch: Throwable -> L22
    L20:
        Map<String, UpdateResult> r19 = ((q) ZeusTransformUtils.preCheckCast(r18, q.class, "com.obric.memorydata.plugin")).a();     // Catch: Throwable -> L22
        com.obric.aikernel.runtime.utils.d.f6216a.b("PackageUpdater", "update end caller=" + r13.a() + ' ' + r11.a(r19));     // Catch: Throwable -> L22
        Object r110 = Result.m1421constructorimpl(r19);     // Catch: Throwable -> L22
    L24:
        Throwable r111 = Result.m1424exceptionOrNullimpl(r110);
        if (r111 == null) goto L27;
        com.obric.aikernel.runtime.utils.d.f6216a.c("PackageUpdater", "update failed caller=" + r13.a() + " updateAll=" + r13.c() + " background=" + r13.g() + ' ' + ExceptionsKt.stackTraceToString(r111));
    L27:
        ResultKt.throwOnFailure(r110);
        return r110;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r18);
        com.obric.aikernel.runtime.utils.d.f6216a.b("PackageUpdater", "update start caller=" + r13.a() + " updateAll=" + r13.c() + " background=" + r13.g() + " onlyDownload=" + r13.e() + " onlyFetchConfig=" + r13.f() + " bizCount=" + r16.size() + " loraType=" + r14);
        Result.Companion r112 = Result.Companion;     // Catch: Throwable -> L22
        r11 = (n) ZeusTransformUtils.preCheckCast(this, n.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L22
        r1.L$0 = r13;     // Catch: Throwable -> L22
        r1.L$1 = r11;     // Catch: Throwable -> L22
        r1.label = 1;     // Catch: Throwable -> L22
        r18 = r11.a(r16, r13, r14, r1);     // Catch: Throwable -> L22
        if (r18 != r3) goto L20;
        return r3;
    L22:
        th = move-exception;
        Result.Companion r113 = Result.Companion;
        r110 = Result.m1421constructorimpl(ResultKt.createFailure(th));
    L7:
        r1 = new PackageUpdater$update$1(this, r17);
        goto L8
    }
}
