package com.obric.aikernel.res;

import android.content.Context;
import android.content.res.AssetManager;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.bdinstall.Api;
import com.bytedance.bdlocation.trace.TraceCons;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.google.gson.JsonObject;
import com.obric.aikernel.res.downloader.d;
import com.obric.aikernel.res.installer.c;
import com.obric.aikernel.res.metadata.NativeLibVersionPolicy;
import com.obric.aikernel.res.metadata.b;
import com.obric.aikernel.res.update.UpdateResult;
import com.obric.aikernel.res.update.j;
import com.obric.aikernel.res.update.n;
import com.obric.aikernel.sdk.ext.Params;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.ExceptionsKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.am;
import kotlinx.coroutines.ar;
import kotlinx.coroutines.ba;
import kotlinx.coroutines.flow.ae;
import kotlinx.coroutines.flow.at;
import kotlinx.coroutines.i;
import okhttp3.RequestBody;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u009c\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0010\b\u0007\u0018\u0000 Z2\u00020\u0001:\u0002Z[B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0011\u0010\u001e\u001a\u00020\u001fH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010 J\u0011\u0010!\u001a\u00020\u001fH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010 J\u0011\u0010\"\u001a\u00020\u001fH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010 J\u001e\u0010#\u001a\u00020\u001f2\u0006\u0010$\u001a\u00020\u00162\u0006\u0010%\u001a\u00020\u00162\u0006\u0010&\u001a\u00020\u0016J(\u0010#\u001a\u00020\u001f2\u0006\u0010$\u001a\u00020\u00162\u0006\u0010%\u001a\u00020\u00162\u0006\u0010&\u001a\u00020\u00162\b\b\u0002\u0010'\u001a\u00020(J\u001e\u0010)\u001a\u00020\u001f2\u0006\u0010$\u001a\u00020\u00162\u0006\u0010%\u001a\u00020\u00162\u0006\u0010&\u001a\u00020\u0016J\u0006\u0010*\u001a\u00020\u001fJ\u0017\u0010+\u001a\b\u0012\u0004\u0012\u00020-0,H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010 J\u0010\u0010.\u001a\u0004\u0018\u00010/2\u0006\u0010%\u001a\u00020\u0016J\u0017\u00100\u001a\b\u0012\u0004\u0012\u0002010,H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010 J\u0011\u00102\u001a\u000201H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010 J\u0010\u00103\u001a\u0004\u0018\u00010/2\u0006\u0010%\u001a\u00020\u0016J\u001b\u00104\u001a\u0004\u0018\u00010-2\u0006\u0010%\u001a\u00020\u0016H\u0086@ø\u0001\u0000¢\u0006\u0002\u00105J\f\u00106\u001a\b\u0012\u0004\u0012\u00020/07J\u001b\u00108\u001a\u0004\u0018\u0001092\u0006\u0010:\u001a\u00020\u0016H\u0086@ø\u0001\u0000¢\u0006\u0002\u00105J\u0019\u0010;\u001a\u00020<2\u0006\u0010:\u001a\u00020\u0016H\u0086@ø\u0001\u0000¢\u0006\u0002\u00105J\u000e\u0010=\u001a\u00020\u001f2\u0006\u0010>\u001a\u00020\u0016J\u0016\u0010?\u001a\u00020\u001f2\u0006\u0010%\u001a\u00020\u00162\u0006\u0010&\u001a\u00020\u0016J\u0019\u0010@\u001a\u00020\u001f2\u0006\u0010A\u001a\u000201H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010BJ\u000e\u0010C\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001cJ\u000e\u0010D\u001a\u00020\u001f2\u0006\u0010%\u001a\u00020\u0016J\u000e\u0010E\u001a\u00020\u001f2\u0006\u0010F\u001a\u00020GJ\u0019\u0010H\u001a\u00020\u001f2\u0006\u0010I\u001a\u00020\u0016H\u0086@ø\u0001\u0000¢\u0006\u0002\u00105J\u001c\u0010J\u001a\u00020\u00162\u0012\u0010K\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u0002090LH\u0002J(\u0010M\u001a\u00020\u001f2\u0006\u0010$\u001a\u00020\u00162\u0006\u0010%\u001a\u00020\u00162\u0006\u0010&\u001a\u00020\u00162\b\b\u0002\u0010'\u001a\u00020(J\u000e\u0010N\u001a\u00020\u001f2\u0006\u0010F\u001a\u00020GJ/\u0010O\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u0002090L2\b\b\u0002\u0010P\u001a\u00020\u00162\u0006\u0010Q\u001a\u00020(H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010RJ7\u0010S\u001a\u0004\u0018\u00010/2\u0006\u0010%\u001a\u00020\u00162\u0006\u0010P\u001a\u00020\u00162\b\b\u0002\u0010T\u001a\u00020(2\b\b\u0002\u0010U\u001a\u00020\u0016H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010VJ?\u0010W\u001a\u0004\u0018\u00010/2\u0006\u0010%\u001a\u00020\u00162\u0006\u0010P\u001a\u00020\u00162\u0006\u0010Q\u001a\u00020(2\b\b\u0002\u0010T\u001a\u00020(2\b\b\u0002\u0010U\u001a\u00020\u0016H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010XJ\u0011\u0010Y\u001a\u00020\u001fH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010 R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R&\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u00150\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\\"}, d2 = {"Lcom/obric/aikernel/res/PackageResourceManager;", "", "presmConfig", "Lcom/obric/aikernel/res/PackageResourceManager$PresmConfig;", "(Lcom/obric/aikernel/res/PackageResourceManager$PresmConfig;)V", "context", "Lcom/obric/aikernel/res/PrmContext;", "getContext", "()Lcom/obric/aikernel/res/PrmContext;", "fusionInstaller", "Lcom/obric/aikernel/res/installer/FusionInstaller;", "getFusionInstaller", "()Lcom/obric/aikernel/res/installer/FusionInstaller;", "globalDownloadController", "Lcom/obric/aikernel/res/downloader/DownloadController;", "metadataController", "Lcom/obric/aikernel/res/metadata/controller/MetadataController;", "packagesListener", "Lcom/obric/aikernel/res/metadata/PackagesListener;", "runningDepsGetter", "Lkotlin/Function0;", "", "", "getRunningDepsGetter", "()Lkotlin/jvm/functions/Function0;", "setRunningDepsGetter", "(Lkotlin/jvm/functions/Function0;)V", "updater", "Lkotlinx/coroutines/Deferred;", "Lcom/obric/aikernel/res/update/PackageUpdater;", "clean", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cleanCache", "cleanDebug", "disable", "type", ActivityLifecycle.NAME, "version", "corrupted", "", "enable", "flushPackageUsage", "getAllPackageConfigs", "", "Lcom/obric/aikernel/res/metadata/config/PackageConfig;", "getAvailPackage", "Lcom/obric/aikernel/res/metadata/data/AIPackage;", "getDownloadInfos", "Lcom/google/gson/JsonObject;", "getDownloadingSummary", "getPackage", "getPackageConfig", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getPackageMap", "", "getPackageUpdateInfo", "Lcom/obric/aikernel/res/update/UpdateResult;", "biz", "getPackageUpdateProgress", "", "installFromPath", "prsPath", "markPackageCorrupt", "pushDebugDistributeInfo", "info", "(Lcom/google/gson/JsonObject;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "refreshAllPackageState", "refreshPackageState", "registerPackageObserver", "observer", "Lcom/obric/aikernel/res/metadata/IPackageListener;", "resumeBlockedUpdateTasksIfNeed", "trigger", "summarizeUpdateResults", "results", "", "uninstall", "unregisterPackageObserver", "updateAll", "caller", TraceCons.METRIC_BACKGROUND, "(Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateByForeground", "force", Params.LORA_TYPE, "(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updatePackage", "(Ljava/lang/String;Ljava/lang/String;ZZLjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "waitLocalPackageInit", "Companion", "PresmConfig", "resource_manager_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class PackageResourceManager {
    public static final a Companion = null;
    public static final String DEBUG_CALLER = ":debug";
    public static final String TAG = "PResM";
    private final PrmContext context;
    private final c fusionInstaller;
    private final d globalDownloadController;
    private final com.obric.aikernel.res.metadata.controller.a metadataController;
    private final b packagesListener;
    private Function0<? extends Set<String>> runningDepsGetter;
    private final ar<n> updater;

    @Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\"\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b$\b\u0087\b\u0018\u00002\u00020\u0001:\u0005stuvwB¹\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\u001c\b\u0002\u0010\u0011\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0013\u0018\u00010\u0012\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0015\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0017\u0012\u000e\b\u0002\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00050\u0019\u0012\u000e\b\u0002\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00050\u0019¢\u0006\u0002\u0010\u001bJ\t\u0010_\u001a\u00020\u0003HÆ\u0003J\u000b\u0010`\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001d\u0010a\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0013\u0018\u00010\u0012HÆ\u0003J\t\u0010b\u001a\u00020\u0015HÆ\u0003J\t\u0010c\u001a\u00020\u0017HÆ\u0003J\u000f\u0010d\u001a\b\u0012\u0004\u0012\u00020\u00050\u0019HÆ\u0003J\u000f\u0010e\u001a\b\u0012\u0004\u0012\u00020\u00050\u0019HÆ\u0003J\t\u0010f\u001a\u00020\u0005HÆ\u0003J\t\u0010g\u001a\u00020\u0005HÆ\u0003J\t\u0010h\u001a\u00020\bHÆ\u0003J\t\u0010i\u001a\u00020\u0005HÆ\u0003J\u000b\u0010j\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010k\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010l\u001a\u0004\u0018\u00010\rHÆ\u0003J\t\u0010m\u001a\u00020\u000fHÆ\u0003JÇ\u0001\u0010n\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00052\u001c\b\u0002\u0010\u0011\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0013\u0018\u00010\u00122\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00172\u000e\b\u0002\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00050\u00192\u000e\b\u0002\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00050\u0019HÆ\u0001J\u0013\u0010o\u001a\u00020\u00152\b\u0010p\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010q\u001a\u00020\u0017HÖ\u0001J\t\u0010r\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0013\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u001c\u0010\"\u001a\u0004\u0018\u00010#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001a\u0010(\u001a\u00020)X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\u001fR\u001c\u0010/\u001a\u0004\u0018\u000100X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104R \u00105\u001a\b\u0012\u0004\u0012\u00020\u001506X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00107\"\u0004\b8\u00109R\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b:\u0010;R\u001b\u0010<\u001a\u00020\u00178FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b?\u0010@\u001a\u0004\b=\u0010>R\u001c\u0010A\u001a\u0004\u0018\u00010BX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\bG\u0010HR\u0011\u0010\u0016\u001a\u00020\u0017¢\u0006\b\n\u0000\u001a\u0004\bI\u0010>R\u0017\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00050\u0019¢\u0006\b\n\u0000\u001a\u0004\bJ\u0010KR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\bL\u0010\u001fR%\u0010\u0011\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0013\u0018\u00010\u0012¢\u0006\b\n\u0000\u001a\u0004\bM\u0010NR\u0017\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00050\u0019¢\u0006\b\n\u0000\u001a\u0004\bO\u0010KR\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bP\u0010\u001fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bQ\u0010\u001fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bR\u0010\u001fR\u001c\u0010S\u001a\u0004\u0018\u00010TX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bU\u0010V\"\u0004\bW\u0010XR\u001a\u0010Y\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bZ\u0010[\"\u0004\b\\\u0010]R\u0011\u0010\u0014\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b^\u0010[¨\u0006x"}, d2 = {"Lcom/obric/aikernel/res/PackageResourceManager$PresmConfig;", "", "context", "Landroid/content/Context;", "rootDir", "", "resRootDir", "appConfig", "Lcom/obric/aikernel/res/PackageResourceManager$PresmConfig$AppConfig;", "pyVmVersion", "assertRootDir", "deviceRootDir", "logger", "Lcom/obric/aikernel/runtime/utils/ILogger;", "packageActionInjector", "Lcom/obric/aikernel/res/PackageResourceManager$PresmConfig$IPackageActionInjector;", "preInitPackageName", "presetLibraries", "", "", "useObricDownloader", "", "parallelDownloadNum", "", "presetModelRoots", "", "platformIntegrityModelRoots", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Lcom/obric/aikernel/res/PackageResourceManager$PresmConfig$AppConfig;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/obric/aikernel/runtime/utils/ILogger;Lcom/obric/aikernel/res/PackageResourceManager$PresmConfig$IPackageActionInjector;Ljava/lang/String;Ljava/util/Map;ZILjava/util/List;Ljava/util/List;)V", "getAppConfig", "()Lcom/obric/aikernel/res/PackageResourceManager$PresmConfig$AppConfig;", "getAssertRootDir", "()Ljava/lang/String;", "getContext", "()Landroid/content/Context;", "customInstaller", "Lcom/obric/aikernel/res/installer/IInstaller;", "getCustomInstaller", "()Lcom/obric/aikernel/res/installer/IInstaller;", "setCustomInstaller", "(Lcom/obric/aikernel/res/installer/IInstaller;)V", "decryptFeature", "Lcom/obric/aikernel/res/PackageResourceManager$PresmConfig$DecryptFeature;", "getDecryptFeature", "()Lcom/obric/aikernel/res/PackageResourceManager$PresmConfig$DecryptFeature;", "setDecryptFeature", "(Lcom/obric/aikernel/res/PackageResourceManager$PresmConfig$DecryptFeature;)V", "getDeviceRootDir", "dynamicResProxy", "Lcom/obric/aikernel/res/metadata/data/dynamic/IDynamicResourceProxy;", "getDynamicResProxy", "()Lcom/obric/aikernel/res/metadata/data/dynamic/IDynamicResourceProxy;", "setDynamicResProxy", "(Lcom/obric/aikernel/res/metadata/data/dynamic/IDynamicResourceProxy;)V", "isInferProcess", "Lkotlin/Function0;", "()Lkotlin/jvm/functions/Function0;", "setInferProcess", "(Lkotlin/jvm/functions/Function0;)V", "getLogger", "()Lcom/obric/aikernel/runtime/utils/ILogger;", "memSize", "getMemSize", "()I", "memSize$delegate", "Lkotlin/Lazy;", "nativeLibLifeCycle", "Lcom/obric/aikernel/res/PackageResourceManager$PresmConfig$INativeLibraryNotifier;", "getNativeLibLifeCycle", "()Lcom/obric/aikernel/res/PackageResourceManager$PresmConfig$INativeLibraryNotifier;", "setNativeLibLifeCycle", "(Lcom/obric/aikernel/res/PackageResourceManager$PresmConfig$INativeLibraryNotifier;)V", "getPackageActionInjector", "()Lcom/obric/aikernel/res/PackageResourceManager$PresmConfig$IPackageActionInjector;", "getParallelDownloadNum", "getPlatformIntegrityModelRoots", "()Ljava/util/List;", "getPreInitPackageName", "getPresetLibraries", "()Ljava/util/Map;", "getPresetModelRoots", "getPyVmVersion", "getResRootDir", "getRootDir", "updateListener", "Lcom/obric/aikernel/res/PackageResourceManager$PresmConfig$UpdateListener;", "getUpdateListener", "()Lcom/obric/aikernel/res/PackageResourceManager$PresmConfig$UpdateListener;", "setUpdateListener", "(Lcom/obric/aikernel/res/PackageResourceManager$PresmConfig$UpdateListener;)V", "useAIKernelModel", "getUseAIKernelModel", "()Z", "setUseAIKernelModel", "(Z)V", "getUseObricDownloader", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "AppConfig", "DecryptFeature", "INativeLibraryNotifier", "IPackageActionInjector", "UpdateListener", "resource_manager_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class PresmConfig {
        private final AppConfig appConfig;
        private final String assertRootDir;
        private final Context context;
        private com.obric.aikernel.res.installer.d customInstaller;
        private a decryptFeature;
        private final String deviceRootDir;
        private com.obric.aikernel.res.metadata.data.a.c dynamicResProxy;
        private Function0<Boolean> isInferProcess;
        private final com.obric.aikernel.runtime.utils.c logger;
        private final Lazy memSize$delegate;
        private b nativeLibLifeCycle;
        private final c packageActionInjector;
        private final int parallelDownloadNum;
        private final List<String> platformIntegrityModelRoots;
        private final String preInitPackageName;
        private final Map<String, Set<String>> presetLibraries;
        private final List<String> presetModelRoots;
        private final String pyVmVersion;
        private final String resRootDir;
        private final String rootDir;
        private d updateListener;
        private boolean useAIKernelModel;
        private final boolean useObricDownloader;

        @Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\bA\b\u0087\b\u0018\u00002\u00020\u0001Bë\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u001c\u0010\u0006\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000e\u0012\u001a\b\u0002\u0010\u0010\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00030\u00120\u0011\u0012\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0011\u0012\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015\u0012\u000e\b\u0002\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u0015\u00127\b\u0002\u0010\u0019\u001a1\b\u0001\u0012\u0013\u0012\u00110\u001b¢\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\u001e\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\b\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u001a\u0012\u000e\b\u0002\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0015\u0012\u000e\b\u0002\u0010 \u001a\b\u0012\u0004\u0012\u00020\u000e0\u0015\u0012\u000e\b\u0002\u0010!\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0015\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010#\u001a\u00020\u000e\u0012\u000e\b\u0002\u0010$\u001a\b\u0012\u0004\u0012\u00020%0\u0015\u0012\u000e\b\u0002\u0010&\u001a\b\u0012\u0004\u0012\u00020%0\u0015\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u0003ø\u0001\u0000¢\u0006\u0002\u0010(J\t\u0010I\u001a\u00020\u0003HÆ\u0003J\t\u0010J\u001a\u00020\u000eHÆ\u0003J\u001b\u0010K\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00030\u00120\u0011HÆ\u0003J\u0011\u0010L\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0011HÆ\u0003J\u000f\u0010M\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015HÆ\u0003J\u000f\u0010N\u001a\b\u0012\u0004\u0012\u00020\u00180\u0015HÆ\u0003J@\u0010O\u001a1\b\u0001\u0012\u0013\u0012\u00110\u001b¢\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\u001e\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\b\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u001aHÆ\u0003ø\u0001\u0000¢\u0006\u0002\u0010?J\u000f\u0010P\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0015HÆ\u0003J\u000f\u0010Q\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0015HÆ\u0003J\u000f\u0010R\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0015HÆ\u0003J\u000b\u0010S\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010T\u001a\u00020\u0003HÆ\u0003J\t\u0010U\u001a\u00020\u000eHÆ\u0003J\u000f\u0010V\u001a\b\u0012\u0004\u0012\u00020%0\u0015HÆ\u0003J\u000f\u0010W\u001a\b\u0012\u0004\u0012\u00020%0\u0015HÆ\u0003J\u000b\u0010X\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010Y\u001a\u00020\u0003HÆ\u0003J'\u0010Z\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0007HÆ\u0003ø\u0001\u0000¢\u0006\u0002\u00109J\t\u0010[\u001a\u00020\u0003HÆ\u0003J\t\u0010\\\u001a\u00020\u0003HÆ\u0003J\t\u0010]\u001a\u00020\u0003HÆ\u0003J\t\u0010^\u001a\u00020\u0003HÆ\u0003J\t\u0010_\u001a\u00020\u000eHÆ\u0003J\u0084\u0003\u0010`\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\u001e\b\u0002\u0010\u0006\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00072\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\u001a\b\u0002\u0010\u0010\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00030\u00120\u00112\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00112\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\u000e\b\u0002\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u001527\b\u0002\u0010\u0019\u001a1\b\u0001\u0012\u0013\u0012\u00110\u001b¢\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\u001e\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\b\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u001a2\u000e\b\u0002\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00152\u000e\b\u0002\u0010 \u001a\b\u0012\u0004\u0012\u00020\u000e0\u00152\u000e\b\u0002\u0010!\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00152\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010#\u001a\u00020\u000e2\u000e\b\u0002\u0010$\u001a\b\u0012\u0004\u0012\u00020%0\u00152\u000e\b\u0002\u0010&\u001a\b\u0012\u0004\u0012\u00020%0\u00152\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0001ø\u0001\u0000¢\u0006\u0002\u0010aJ\u0013\u0010b\u001a\u00020\u000e2\b\u0010c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010d\u001a\u00020\u0018HÖ\u0001J\t\u0010e\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R#\u0010\u0010\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00030\u00120\u0011¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0017\u0010!\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0015¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b/\u0010*R\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015¢\u0006\b\n\u0000\u001a\u0004\b0\u0010.R\u0017\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u0015¢\u0006\b\n\u0000\u001a\u0004\b1\u0010.R\u0017\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0015¢\u0006\b\n\u0000\u001a\u0004\b2\u0010.R\u0019\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b3\u0010,R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b4\u0010*R\u0011\u0010\u000f\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b5\u00106R\u0017\u0010 \u001a\b\u0012\u0004\u0012\u00020\u000e0\u0015¢\u0006\b\n\u0000\u001a\u0004\b7\u0010.R,\u0010\u0006\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0007ø\u0001\u0000¢\u0006\n\n\u0002\u0010:\u001a\u0004\b8\u00109R\u0011\u0010#\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b;\u00106R\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u00106\"\u0004\b<\u0010=RE\u0010\u0019\u001a1\b\u0001\u0012\u0013\u0012\u00110\u001b¢\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\u001e\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\b\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u001aø\u0001\u0000¢\u0006\n\n\u0002\u0010@\u001a\u0004\b>\u0010?R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bA\u0010*R\u0013\u0010'\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bB\u0010*R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bC\u0010*R\u0013\u0010\"\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bD\u0010*R\u0017\u0010$\u001a\b\u0012\u0004\u0012\u00020%0\u0015¢\u0006\b\n\u0000\u001a\u0004\bE\u0010.R\u0017\u0010&\u001a\b\u0012\u0004\u0012\u00020%0\u0015¢\u0006\b\n\u0000\u001a\u0004\bF\u0010.R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bG\u0010*R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bH\u0010*\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006f"}, d2 = {"Lcom/obric/aikernel/res/PackageResourceManager$PresmConfig$AppConfig;", "", "aid", "", "appVersion", "channel", "did", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "userId", "url", "projectId", "semAppVersion", "isDebug", "", "checkAssistantAutoUpdateSwitch", "allowBackgroundUpdate", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lkotlin/Pair;", "autoUpdateTrigger", "autoCleanResourceInterval", "Lkotlin/Function0;", "", "autoCleanResourceTotalGB", "", "networkRequestDelegate", "Lkotlin/Function2;", "Lokhttp3/RequestBody;", "Lkotlin/ParameterName;", ActivityLifecycle.NAME, "body", "autoDeleteDebugPackage", "checkPackageResource", "allowNetworkRequest", "soc", "enableDownloadForegroundService", "startDownloadForegroundService", "", "stopDownloadForegroundService", Api.KEY_REGION, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZLkotlinx/coroutines/flow/MutableStateFlow;Lkotlinx/coroutines/flow/MutableStateFlow;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Ljava/lang/String;ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Ljava/lang/String;)V", "getAid", "()Ljava/lang/String;", "getAllowBackgroundUpdate", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "getAllowNetworkRequest", "()Lkotlin/jvm/functions/Function0;", "getAppVersion", "getAutoCleanResourceInterval", "getAutoCleanResourceTotalGB", "getAutoDeleteDebugPackage", "getAutoUpdateTrigger", "getChannel", "getCheckAssistantAutoUpdateSwitch", "()Z", "getCheckPackageResource", "getDid", "()Lkotlin/jvm/functions/Function1;", "Lkotlin/jvm/functions/Function1;", "getEnableDownloadForegroundService", "setDebug", "(Z)V", "getNetworkRequestDelegate", "()Lkotlin/jvm/functions/Function2;", "Lkotlin/jvm/functions/Function2;", "getProjectId", "getRegion", "getSemAppVersion", "getSoc", "getStartDownloadForegroundService", "getStopDownloadForegroundService", "getUrl", "getUserId", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZLkotlinx/coroutines/flow/MutableStateFlow;Lkotlinx/coroutines/flow/MutableStateFlow;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Ljava/lang/String;ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Ljava/lang/String;)Lcom/obric/aikernel/res/PackageResourceManager$PresmConfig$AppConfig;", "equals", "other", "hashCode", "toString", "resource_manager_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static final class AppConfig {
            private final String aid;
            private final ae<Pair<Boolean, String>> allowBackgroundUpdate;
            private final Function0<Boolean> allowNetworkRequest;
            private final String appVersion;
            private final Function0<Long> autoCleanResourceInterval;
            private final Function0<Integer> autoCleanResourceTotalGB;
            private final Function0<Boolean> autoDeleteDebugPackage;
            private final ae<String> autoUpdateTrigger;
            private final String channel;
            private final boolean checkAssistantAutoUpdateSwitch;
            private final Function0<Boolean> checkPackageResource;
            private final Function1<Continuation<? super String>, Object> did;
            private final boolean enableDownloadForegroundService;
            private boolean isDebug;
            private final Function2<RequestBody, Continuation<? super String>, Object> networkRequestDelegate;
            private final String projectId;
            private final String region;
            private final String semAppVersion;
            private final String soc;
            private final Function0<Unit> startDownloadForegroundService;
            private final Function0<Unit> stopDownloadForegroundService;
            private final String url;
            private final String userId;

            public AppConfig(String r17, String r18, String r19, Function1<? super Continuation<? super String>, ? extends Object> r20, String r21, String r22, String r23, String r24, boolean r25, boolean r26, ae<Pair<Boolean, String>> r27, ae<String> r28, Function0<Long> r29, Function0<Integer> r30, Function2<? super RequestBody, ? super Continuation<? super String>, ? extends Object> r31, Function0<Boolean> r32, Function0<Boolean> r33, Function0<Boolean> r34, String r35, boolean r36, Function0<Unit> r37, Function0<Unit> r38, String r39) {
                Function1<Continuation<? super String>, Object> r8 = (Function1) ZeusTransformUtils.wrapperContextForParams(r20, Function1.class, "com.obric.memorydata.plugin");
                ae<Pair<Boolean, String>> r10 = (ae) ZeusTransformUtils.wrapperContextForParams(r27, ae.class, "com.obric.memorydata.plugin");
                ae<String> r11 = (ae) ZeusTransformUtils.wrapperContextForParams(r28, ae.class, "com.obric.memorydata.plugin");
                Function0<Long> r12 = (Function0) ZeusTransformUtils.wrapperContextForParams(r29, Function0.class, "com.obric.memorydata.plugin");
                Function0<Integer> r13 = (Function0) ZeusTransformUtils.wrapperContextForParams(r30, Function0.class, "com.obric.memorydata.plugin");
                Function2<RequestBody, Continuation<? super String>, Object> r14 = (Function2) ZeusTransformUtils.wrapperContextForParams(r31, Function2.class, "com.obric.memorydata.plugin");
                Function0<Boolean> r15 = (Function0) ZeusTransformUtils.wrapperContextForParams(r32, Function0.class, "com.obric.memorydata.plugin");
                Function0<Boolean> r16 = (Function0) ZeusTransformUtils.wrapperContextForParams(r33, Function0.class, "com.obric.memorydata.plugin");
                Function0<Boolean> r0 = (Function0) ZeusTransformUtils.wrapperContextForParams(r34, Function0.class, "com.obric.memorydata.plugin");
                Function0<Unit> r1 = (Function0) ZeusTransformUtils.wrapperContextForParams(r37, Function0.class, "com.obric.memorydata.plugin");
                Function0<Unit> r2 = (Function0) ZeusTransformUtils.wrapperContextForParams(r38, Function0.class, "com.obric.memorydata.plugin");
                Intrinsics.checkNotNullParameter(r17, "aid");
                Intrinsics.checkNotNullParameter(r18, "appVersion");
                Intrinsics.checkNotNullParameter(r19, "channel");
                Intrinsics.checkNotNullParameter(r8, "did");
                Intrinsics.checkNotNullParameter(r21, "userId");
                Intrinsics.checkNotNullParameter(r22, "url");
                Intrinsics.checkNotNullParameter(r23, "projectId");
                Intrinsics.checkNotNullParameter(r24, "semAppVersion");
                Intrinsics.checkNotNullParameter(r10, "allowBackgroundUpdate");
                Intrinsics.checkNotNullParameter(r12, "autoCleanResourceInterval");
                Intrinsics.checkNotNullParameter(r13, "autoCleanResourceTotalGB");
                Intrinsics.checkNotNullParameter(r15, "autoDeleteDebugPackage");
                Intrinsics.checkNotNullParameter(r16, "checkPackageResource");
                Intrinsics.checkNotNullParameter(r0, "allowNetworkRequest");
                Intrinsics.checkNotNullParameter(r1, "startDownloadForegroundService");
                Intrinsics.checkNotNullParameter(r2, "stopDownloadForegroundService");
                this.aid = r17;
                this.appVersion = r18;
                this.channel = r19;
                this.did = r8;
                this.userId = r21;
                this.url = r22;
                this.projectId = r23;
                this.semAppVersion = r24;
                this.isDebug = r25;
                this.checkAssistantAutoUpdateSwitch = r26;
                this.allowBackgroundUpdate = r10;
                this.autoUpdateTrigger = r11;
                this.autoCleanResourceInterval = r12;
                this.autoCleanResourceTotalGB = r13;
                this.networkRequestDelegate = r14;
                this.autoDeleteDebugPackage = r15;
                this.checkPackageResource = r16;
                this.allowNetworkRequest = r0;
                this.soc = r35;
                this.enableDownloadForegroundService = r36;
                this.startDownloadForegroundService = r1;
                this.stopDownloadForegroundService = r2;
                this.region = r39;
            }

            public /* synthetic */ AppConfig(String r28, String r29, String r30, Function1 r31, String r32, String r33, String r34, String r35, boolean r36, boolean r37, ae r38, ae r39, Function0 r40, Function0 r41, Function2 r42, Function0 r43, Function0 r44, Function0 r45, String r46, boolean r47, Function0 r48, Function0 r49, String r50, int r51, DefaultConstructorMarker r52) {
                Function1 r7 = (Function1) ZeusTransformUtils.wrapperContextForParams(r31, Function1.class, "com.obric.memorydata.plugin");
                ae r1 = (ae) ZeusTransformUtils.wrapperContextForParams(r38, ae.class, "com.obric.memorydata.plugin");
                ae r3 = (ae) ZeusTransformUtils.wrapperContextForParams(r39, ae.class, "com.obric.memorydata.plugin");
                Function0 r4 = (Function0) ZeusTransformUtils.wrapperContextForParams(r40, Function0.class, "com.obric.memorydata.plugin");
                Function0 r5 = (Function0) ZeusTransformUtils.wrapperContextForParams(r41, Function0.class, "com.obric.memorydata.plugin");
                Function2 r6 = (Function2) ZeusTransformUtils.wrapperContextForParams(r42, Function2.class, "com.obric.memorydata.plugin");
                Function0 r8 = (Function0) ZeusTransformUtils.wrapperContextForParams(r43, Function0.class, "com.obric.memorydata.plugin");
                Function0 r9 = (Function0) ZeusTransformUtils.wrapperContextForParams(r44, Function0.class, "com.obric.memorydata.plugin");
                Function0 r10 = (Function0) ZeusTransformUtils.wrapperContextForParams(r45, Function0.class, "com.obric.memorydata.plugin");
                Function0 r11 = (Function0) ZeusTransformUtils.wrapperContextForParams(r48, Function0.class, "com.obric.memorydata.plugin");
                Function0 r12 = (Function0) ZeusTransformUtils.wrapperContextForParams(r49, Function0.class, "com.obric.memorydata.plugin");
                if ((r51 & 256) == 0) goto L5;
                boolean r13 = false;
            L7:
                if ((r51 & 512) == 0) goto L9;
                boolean r15 = false;
            L11:
                if ((r51 & 1024) == 0) goto L14;
                r1 = at.a(new Pair(false, "default disable background update."));
            L14:
                ae r14 = r1;
                if ((r51 & 2048) == 0) goto L17;
                ae r2 = null;
            L19:
                if ((r51 & 4096) == 0) goto L21;
                Function0 r16 = (Function0) ZeusTransformUtils.preCheckCast(AnonymousClass1.INSTANCE, Function0.class, "com.obric.memorydata.plugin");
            L23:
                if ((r51 & 8192) == 0) goto L25;
                Function0 r17 = (Function0) ZeusTransformUtils.preCheckCast(AnonymousClass2.INSTANCE, Function0.class, "com.obric.memorydata.plugin");
            L27:
                if ((r51 & 16384) == 0) goto L29;
                Function2 r18 = null;
            L31:
                if ((32768 & r51) == 0) goto L33;
                Function0 r19 = (Function0) ZeusTransformUtils.preCheckCast(AnonymousClass3.INSTANCE, Function0.class, "com.obric.memorydata.plugin");
            L35:
                if ((65536 & r51) == 0) goto L37;
                Function0 r20 = (Function0) ZeusTransformUtils.preCheckCast(AnonymousClass4.INSTANCE, Function0.class, "com.obric.memorydata.plugin");
            L39:
                if ((131072 & r51) == 0) goto L41;
                Function0 r21 = (Function0) ZeusTransformUtils.preCheckCast(AnonymousClass5.INSTANCE, Function0.class, "com.obric.memorydata.plugin");
            L43:
                if ((262144 & r51) == 0) goto L45;
                String r22 = null;
            L47:
                if ((524288 & r51) == 0) goto L49;
                boolean r23 = false;
            L51:
                if ((1048576 & r51) == 0) goto L53;
                Function0 r24 = (Function0) ZeusTransformUtils.preCheckCast(AnonymousClass6.INSTANCE, Function0.class, "com.obric.memorydata.plugin");
            L55:
                if ((2097152 & r51) == 0) goto L57;
                Function0 r25 = (Function0) ZeusTransformUtils.preCheckCast(AnonymousClass7.INSTANCE, Function0.class, "com.obric.memorydata.plugin");
            L59:
                if ((r51 & 4194304) == 0) goto L61;
                String r26 = null;
            L62:
                this(r28, r29, r30, r7, r32, r33, r34, r35, r13, r15, r14, r2, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26);
                return;
            L61:
                r26 = r50;
                goto L62
            L57:
                r25 = r12;
                goto L59
            L53:
                r24 = r11;
                goto L55
            L49:
                r23 = r47;
                goto L51
            L45:
                r22 = r46;
                goto L47
            L41:
                r21 = r10;
                goto L43
            L37:
                r20 = r9;
                goto L39
            L33:
                r19 = r8;
                goto L35
            L29:
                r18 = r6;
                goto L31
            L25:
                r17 = r5;
                goto L27
            L21:
                r16 = r4;
                goto L23
            L17:
                r2 = r3;
                goto L19
            L9:
                r15 = r37;
                goto L11
            L5:
                r13 = r36;
                goto L7
            }

            public static /* synthetic */ AppConfig copy$default(AppConfig r17, String r18, String r19, String r20, Function1 r21, String r22, String r23, String r24, String r25, boolean r26, boolean r27, ae r28, ae r29, Function0 r30, Function0 r31, Function2 r32, Function0 r33, Function0 r34, Function0 r35, String r36, boolean r37, Function0 r38, Function0 r39, String r40, int r41, Object r42) {
                Function1<Continuation<? super String>, Object> r2 = (Function1) ZeusTransformUtils.wrapperContextForParams(r21, Function1.class, "com.obric.memorydata.plugin");
                ae<Pair<Boolean, String>> r4 = (ae) ZeusTransformUtils.wrapperContextForParams(r28, ae.class, "com.obric.memorydata.plugin");
                ae<String> r5 = (ae) ZeusTransformUtils.wrapperContextForParams(r29, ae.class, "com.obric.memorydata.plugin");
                Function0<Long> r6 = (Function0) ZeusTransformUtils.wrapperContextForParams(r30, Function0.class, "com.obric.memorydata.plugin");
                Function0<Integer> r7 = (Function0) ZeusTransformUtils.wrapperContextForParams(r31, Function0.class, "com.obric.memorydata.plugin");
                Function2<RequestBody, Continuation<? super String>, Object> r8 = (Function2) ZeusTransformUtils.wrapperContextForParams(r32, Function2.class, "com.obric.memorydata.plugin");
                Function0<Boolean> r9 = (Function0) ZeusTransformUtils.wrapperContextForParams(r33, Function0.class, "com.obric.memorydata.plugin");
                Function0<Boolean> r10 = (Function0) ZeusTransformUtils.wrapperContextForParams(r34, Function0.class, "com.obric.memorydata.plugin");
                Function0<Boolean> r11 = (Function0) ZeusTransformUtils.wrapperContextForParams(r35, Function0.class, "com.obric.memorydata.plugin");
                Function0<Unit> r12 = (Function0) ZeusTransformUtils.wrapperContextForParams(r38, Function0.class, "com.obric.memorydata.plugin");
                Function0<Unit> r3 = (Function0) ZeusTransformUtils.wrapperContextForParams(r39, Function0.class, "com.obric.memorydata.plugin");
                if ((r41 & 1) == 0) goto L5;
                String r13 = r17.aid;
            L7:
                if ((r41 & 2) == 0) goto L9;
                String r14 = r17.appVersion;
            L11:
                if ((r41 & 4) == 0) goto L13;
                String r15 = r17.channel;
            L15:
                if ((r41 & 8) == 0) goto L18;
                r2 = r17.did;
            L18:
                if ((r41 & 16) == 0) goto L20;
                String r16 = r17.userId;
            L22:
                if ((r41 & 32) == 0) goto L24;
                String r43 = r17.url;
            L26:
                if ((r41 & 64) == 0) goto L28;
                String r44 = r17.projectId;
            L30:
                if ((r41 & 128) == 0) goto L32;
                String r45 = r17.semAppVersion;
            L34:
                if ((r41 & 256) == 0) goto L36;
                boolean r46 = r17.isDebug;
            L38:
                if ((r41 & 512) == 0) goto L40;
                boolean r47 = r17.checkAssistantAutoUpdateSwitch;
            L42:
                if ((r41 & 1024) == 0) goto L44;
                ae<Pair<Boolean, String>> r48 = r17.allowBackgroundUpdate;
            L46:
                if ((r41 & 2048) == 0) goto L48;
                ae<String> r110 = r17.autoUpdateTrigger;
            L50:
                if ((r41 & 4096) == 0) goto L52;
                Function0<Long> r111 = r17.autoCleanResourceInterval;
            L54:
                if ((r41 & 8192) == 0) goto L56;
                Function0<Integer> r112 = r17.autoCleanResourceTotalGB;
            L57:
                Function0<Integer> r310 = r112;
                if ((r41 & 16384) == 0) goto L60;
                Function2<RequestBody, Continuation<? super String>, Object> r113 = r17.networkRequestDelegate;
            L61:
                Function2<RequestBody, Continuation<? super String>, Object> r311 = r113;
                if ((r41 & 32768) == 0) goto L64;
                Function0<Boolean> r114 = r17.autoDeleteDebugPackage;
            L65:
                Function0<Boolean> r312 = r114;
                if ((r41 & 65536) == 0) goto L68;
                Function0<Boolean> r115 = r17.checkPackageResource;
            L69:
                Function0<Boolean> r313 = r115;
                if ((r41 & 131072) == 0) goto L72;
                Function0<Boolean> r116 = r17.allowNetworkRequest;
            L73:
                Function0<Boolean> r314 = r116;
                if ((r41 & 262144) == 0) goto L76;
                String r117 = r17.soc;
            L77:
                String r315 = r117;
                if ((r41 & 524288) == 0) goto L80;
                boolean r118 = r17.enableDownloadForegroundService;
            L81:
                boolean r316 = r118;
                if ((r41 & 1048576) == 0) goto L84;
                Function0<Unit> r119 = r17.startDownloadForegroundService;
            L85:
                Function0<Unit> r317 = r119;
                if ((r41 & 2097152) == 0) goto L88;
                Function0<Unit> r120 = r17.stopDownloadForegroundService;
            L90:
                if ((r41 & 4194304) == 0) goto L92;
                String r1 = r17.region;
            L94:
                return r17.copy(r13, r14, r15, r2, r16, r43, r44, r45, r46, r47, r48, r110, r111, r310, r311, r312, r313, r314, r315, r316, r317, r120, r1);
            L92:
                r1 = r40;
                goto L94
            L88:
                r120 = r3;
                goto L90
            L84:
                r119 = r12;
                goto L85
            L80:
                r118 = r37;
                goto L81
            L76:
                r117 = r36;
                goto L77
            L72:
                r116 = r11;
                goto L73
            L68:
                r115 = r10;
                goto L69
            L64:
                r114 = r9;
                goto L65
            L60:
                r113 = r8;
                goto L61
            L56:
                r112 = r7;
                goto L57
            L52:
                r111 = r6;
                goto L54
            L48:
                r110 = r5;
                goto L50
            L44:
                r48 = r4;
                goto L46
            L40:
                r47 = r27;
                goto L42
            L36:
                r46 = r26;
                goto L38
            L32:
                r45 = r25;
                goto L34
            L28:
                r44 = r24;
                goto L30
            L24:
                r43 = r23;
                goto L26
            L20:
                r16 = r22;
                goto L22
            L13:
                r15 = r20;
                goto L15
            L9:
                r14 = r19;
                goto L11
            L5:
                r13 = r18;
                goto L7
            }

            public final String component1() {
                return this.aid;
            }

            public final boolean component10() {
                return this.checkAssistantAutoUpdateSwitch;
            }

            public final ae<Pair<Boolean, String>> component11() {
                return this.allowBackgroundUpdate;
            }

            public final ae<String> component12() {
                return this.autoUpdateTrigger;
            }

            public final Function0<Long> component13() {
                return this.autoCleanResourceInterval;
            }

            public final Function0<Integer> component14() {
                return this.autoCleanResourceTotalGB;
            }

            public final Function2<RequestBody, Continuation<? super String>, Object> component15() {
                return this.networkRequestDelegate;
            }

            public final Function0<Boolean> component16() {
                return this.autoDeleteDebugPackage;
            }

            public final Function0<Boolean> component17() {
                return this.checkPackageResource;
            }

            public final Function0<Boolean> component18() {
                return this.allowNetworkRequest;
            }

            public final String component19() {
                return this.soc;
            }

            public final String component2() {
                return this.appVersion;
            }

            public final boolean component20() {
                return this.enableDownloadForegroundService;
            }

            public final Function0<Unit> component21() {
                return this.startDownloadForegroundService;
            }

            public final Function0<Unit> component22() {
                return this.stopDownloadForegroundService;
            }

            public final String component23() {
                return this.region;
            }

            public final String component3() {
                return this.channel;
            }

            public final Function1<Continuation<? super String>, Object> component4() {
                return this.did;
            }

            public final String component5() {
                return this.userId;
            }

            public final String component6() {
                return this.url;
            }

            public final String component7() {
                return this.projectId;
            }

            public final String component8() {
                return this.semAppVersion;
            }

            public final boolean component9() {
                return this.isDebug;
            }

            public final AppConfig copy(String r32, String r33, String r34, Function1<? super Continuation<? super String>, ? extends Object> r35, String r36, String r37, String r38, String r39, boolean r40, boolean r41, ae<Pair<Boolean, String>> r42, ae<String> r43, Function0<Long> r44, Function0<Integer> r45, Function2<? super RequestBody, ? super Continuation<? super String>, ? extends Object> r46, Function0<Boolean> r47, Function0<Boolean> r48, Function0<Boolean> r49, String r50, boolean r51, Function0<Unit> r52, Function0<Unit> r53, String r54) {
                Function1 r0 = (Function1) ZeusTransformUtils.wrapperContextForParams(r35, Function1.class, "com.obric.memorydata.plugin");
                ae r14 = (ae) ZeusTransformUtils.wrapperContextForParams(r42, ae.class, "com.obric.memorydata.plugin");
                ae r12 = (ae) ZeusTransformUtils.wrapperContextForParams(r43, ae.class, "com.obric.memorydata.plugin");
                Function0 r15 = (Function0) ZeusTransformUtils.wrapperContextForParams(r44, Function0.class, "com.obric.memorydata.plugin");
                Function0 r1 = (Function0) ZeusTransformUtils.wrapperContextForParams(r45, Function0.class, "com.obric.memorydata.plugin");
                Function2 r4 = (Function2) ZeusTransformUtils.wrapperContextForParams(r46, Function2.class, "com.obric.memorydata.plugin");
                Function0 r5 = (Function0) ZeusTransformUtils.wrapperContextForParams(r47, Function0.class, "com.obric.memorydata.plugin");
                Function0 r6 = (Function0) ZeusTransformUtils.wrapperContextForParams(r48, Function0.class, "com.obric.memorydata.plugin");
                Function0 r7 = (Function0) ZeusTransformUtils.wrapperContextForParams(r49, Function0.class, "com.obric.memorydata.plugin");
                Function0 r8 = (Function0) ZeusTransformUtils.wrapperContextForParams(r52, Function0.class, "com.obric.memorydata.plugin");
                Function0 r9 = (Function0) ZeusTransformUtils.wrapperContextForParams(r53, Function0.class, "com.obric.memorydata.plugin");
                Intrinsics.checkNotNullParameter(r32, "aid");
                Intrinsics.checkNotNullParameter(r33, "appVersion");
                Intrinsics.checkNotNullParameter(r34, "channel");
                Intrinsics.checkNotNullParameter(r0, "did");
                Intrinsics.checkNotNullParameter(r36, "userId");
                Intrinsics.checkNotNullParameter(r37, "url");
                Intrinsics.checkNotNullParameter(r38, "projectId");
                Intrinsics.checkNotNullParameter(r39, "semAppVersion");
                Intrinsics.checkNotNullParameter(r14, "allowBackgroundUpdate");
                Intrinsics.checkNotNullParameter(r15, "autoCleanResourceInterval");
                Intrinsics.checkNotNullParameter(r1, "autoCleanResourceTotalGB");
                Intrinsics.checkNotNullParameter(r5, "autoDeleteDebugPackage");
                Intrinsics.checkNotNullParameter(r6, "checkPackageResource");
                Intrinsics.checkNotNullParameter(r7, "allowNetworkRequest");
                Intrinsics.checkNotNullParameter(r8, "startDownloadForegroundService");
                Intrinsics.checkNotNullParameter(r9, "stopDownloadForegroundService");
                return new AppConfig(r32, r33, r34, r0, r36, r37, r38, r39, r40, r41, r14, r12, r15, r1, r4, r5, r6, r7, r50, r51, r8, r9, r54);
            }

            public boolean equals(Object r5) {
                if (this != r5) goto L6;
                return true;
            L6:
                if (ZeusTransformUtils.instanceOf(r5, AppConfig.class) == true) goto L8;
                return false;
            L8:
                AppConfig r6 = (AppConfig) ZeusTransformUtils.preCheckCast(r5, AppConfig.class, "com.obric.memorydata.plugin");
                if (Intrinsics.areEqual(this.aid, r6.aid) == true) goto L12;
                return false;
            L12:
                if (Intrinsics.areEqual(this.appVersion, r6.appVersion) == true) goto L15;
                return false;
            L15:
                if (Intrinsics.areEqual(this.channel, r6.channel) == true) goto L18;
                return false;
            L18:
                if (Intrinsics.areEqual(this.did, r6.did) == true) goto L21;
                return false;
            L21:
                if (Intrinsics.areEqual(this.userId, r6.userId) == true) goto L24;
                return false;
            L24:
                if (Intrinsics.areEqual(this.url, r6.url) == true) goto L27;
                return false;
            L27:
                if (Intrinsics.areEqual(this.projectId, r6.projectId) == true) goto L30;
                return false;
            L30:
                if (Intrinsics.areEqual(this.semAppVersion, r6.semAppVersion) == true) goto L33;
                return false;
            L33:
                if (this.isDebug == r6.isDebug) goto L36;
                return false;
            L36:
                if (this.checkAssistantAutoUpdateSwitch == r6.checkAssistantAutoUpdateSwitch) goto L39;
                return false;
            L39:
                if (Intrinsics.areEqual(this.allowBackgroundUpdate, r6.allowBackgroundUpdate) == true) goto L42;
                return false;
            L42:
                if (Intrinsics.areEqual(this.autoUpdateTrigger, r6.autoUpdateTrigger) == true) goto L45;
                return false;
            L45:
                if (Intrinsics.areEqual(this.autoCleanResourceInterval, r6.autoCleanResourceInterval) == true) goto L48;
                return false;
            L48:
                if (Intrinsics.areEqual(this.autoCleanResourceTotalGB, r6.autoCleanResourceTotalGB) == true) goto L51;
                return false;
            L51:
                if (Intrinsics.areEqual(this.networkRequestDelegate, r6.networkRequestDelegate) == true) goto L54;
                return false;
            L54:
                if (Intrinsics.areEqual(this.autoDeleteDebugPackage, r6.autoDeleteDebugPackage) == true) goto L57;
                return false;
            L57:
                if (Intrinsics.areEqual(this.checkPackageResource, r6.checkPackageResource) == true) goto L60;
                return false;
            L60:
                if (Intrinsics.areEqual(this.allowNetworkRequest, r6.allowNetworkRequest) == true) goto L63;
                return false;
            L63:
                if (Intrinsics.areEqual(this.soc, r6.soc) == true) goto L66;
                return false;
            L66:
                if (this.enableDownloadForegroundService == r6.enableDownloadForegroundService) goto L69;
                return false;
            L69:
                if (Intrinsics.areEqual(this.startDownloadForegroundService, r6.startDownloadForegroundService) == true) goto L72;
                return false;
            L72:
                if (Intrinsics.areEqual(this.stopDownloadForegroundService, r6.stopDownloadForegroundService) == true) goto L75;
                return false;
            L75:
                if (Intrinsics.areEqual(this.region, r6.region) == true) goto L77;
                return false;
            L77:
                return true;
            }

            public final String getAid() {
                return this.aid;
            }

            public final ae<Pair<Boolean, String>> getAllowBackgroundUpdate() {
                return this.allowBackgroundUpdate;
            }

            public final Function0<Boolean> getAllowNetworkRequest() {
                return this.allowNetworkRequest;
            }

            public final String getAppVersion() {
                return this.appVersion;
            }

            public final Function0<Long> getAutoCleanResourceInterval() {
                return this.autoCleanResourceInterval;
            }

            public final Function0<Integer> getAutoCleanResourceTotalGB() {
                return this.autoCleanResourceTotalGB;
            }

            public final Function0<Boolean> getAutoDeleteDebugPackage() {
                return this.autoDeleteDebugPackage;
            }

            public final ae<String> getAutoUpdateTrigger() {
                return this.autoUpdateTrigger;
            }

            public final String getChannel() {
                return this.channel;
            }

            public final boolean getCheckAssistantAutoUpdateSwitch() {
                return this.checkAssistantAutoUpdateSwitch;
            }

            public final Function0<Boolean> getCheckPackageResource() {
                return this.checkPackageResource;
            }

            public final Function1<Continuation<? super String>, Object> getDid() {
                return this.did;
            }

            public final boolean getEnableDownloadForegroundService() {
                return this.enableDownloadForegroundService;
            }

            public final Function2<RequestBody, Continuation<? super String>, Object> getNetworkRequestDelegate() {
                return this.networkRequestDelegate;
            }

            public final String getProjectId() {
                return this.projectId;
            }

            public final String getRegion() {
                return this.region;
            }

            public final String getSemAppVersion() {
                return this.semAppVersion;
            }

            public final String getSoc() {
                return this.soc;
            }

            public final Function0<Unit> getStartDownloadForegroundService() {
                return this.startDownloadForegroundService;
            }

            public final Function0<Unit> getStopDownloadForegroundService() {
                return this.stopDownloadForegroundService;
            }

            public final String getUrl() {
                return this.url;
            }

            public final String getUserId() {
                return this.userId;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v17, types: [int] */
            /* JADX WARN: Type inference failed for: r0v19, types: [int] */
            /* JADX WARN: Type inference failed for: r0v39, types: [int] */
            /* JADX WARN: Type inference failed for: r1v15, types: [int] */
            /* JADX WARN: Type inference failed for: r1v17, types: [int] */
            /* JADX WARN: Type inference failed for: r1v47 */
            /* JADX WARN: Type inference failed for: r1v48 */
            /* JADX WARN: Type inference failed for: r1v49 */
            /* JADX WARN: Type inference failed for: r1v50 */
            /* JADX WARN: Type inference failed for: r2v0 */
            /* JADX WARN: Type inference failed for: r2v1, types: [int] */
            /* JADX WARN: Type inference failed for: r2v2 */
            public int hashCode() {
                int r0 = ((((((((((((((this.aid.hashCode() * 31) + this.appVersion.hashCode()) * 31) + this.channel.hashCode()) * 31) + this.did.hashCode()) * 31) + this.userId.hashCode()) * 31) + this.url.hashCode()) * 31) + this.projectId.hashCode()) * 31) + this.semAppVersion.hashCode()) * 31;
                boolean r1 = this.isDebug;
                ?? r2 = 1;
                ?? r3 = r1;
                if (r1 == false) goto L5;
                r3 = 1;
            L5:
                int r4 = (r0 + r3) * 31;
                boolean r5 = this.checkAssistantAutoUpdateSwitch;
                ?? r6 = r5;
                if (r5 == false) goto L8;
                r6 = 1;
            L8:
                int r7 = (((r4 + r6) * 31) + this.allowBackgroundUpdate.hashCode()) * 31;
                ae<String> r8 = this.autoUpdateTrigger;
                int r9 = 0;
                if (r8 != null) goto L11;
                int r10 = 0;
            L12:
                int r11 = (((((r7 + r10) * 31) + this.autoCleanResourceInterval.hashCode()) * 31) + this.autoCleanResourceTotalGB.hashCode()) * 31;
                Function2<RequestBody, Continuation<? super String>, Object> r12 = this.networkRequestDelegate;
                if (r12 != null) goto L15;
                int r13 = 0;
            L16:
                int r14 = (((((((r11 + r13) * 31) + this.autoDeleteDebugPackage.hashCode()) * 31) + this.checkPackageResource.hashCode()) * 31) + this.allowNetworkRequest.hashCode()) * 31;
                String r15 = this.soc;
                if (r15 != null) goto L19;
                int r16 = 0;
            L20:
                int r17 = (r14 + r16) * 31;
                boolean r18 = this.enableDownloadForegroundService;
                if (r18 == true) goto L24;
                r2 = r18;
            L24:
                int r19 = (((((r17 + r2) * 31) + this.startDownloadForegroundService.hashCode()) * 31) + this.stopDownloadForegroundService.hashCode()) * 31;
                String r20 = this.region;
                if (r20 == null) goto L29;
                r9 = r20.hashCode();
            L29:
                return r19 + r9;
            L19:
                r16 = r15.hashCode();
                goto L20
            L15:
                r13 = r12.hashCode();
                goto L16
            L11:
                r10 = r8.hashCode();
                goto L12
            }

            public final boolean isDebug() {
                return this.isDebug;
            }

            public final void setDebug(boolean r1) {
                this.isDebug = r1;
            }

            public String toString() {
                StringBuilder r0 = new StringBuilder();
                r0.append("AppConfig(aid=").append(this.aid).append(", appVersion=").append(this.appVersion).append(", channel=").append(this.channel).append(", did=").append(this.did).append(", userId=").append(this.userId).append(", url=").append(this.url).append(", projectId=").append(this.projectId).append(", semAppVersion=").append(this.semAppVersion).append(", isDebug=").append(this.isDebug).append(", checkAssistantAutoUpdateSwitch=").append(this.checkAssistantAutoUpdateSwitch).append(", allowBackgroundUpdate=").append(this.allowBackgroundUpdate).append(", autoUpdateTrigger=");
                r0.append(this.autoUpdateTrigger).append(", autoCleanResourceInterval=").append(this.autoCleanResourceInterval).append(", autoCleanResourceTotalGB=").append(this.autoCleanResourceTotalGB).append(", networkRequestDelegate=").append(this.networkRequestDelegate).append(", autoDeleteDebugPackage=").append(this.autoDeleteDebugPackage).append(", checkPackageResource=").append(this.checkPackageResource).append(", allowNetworkRequest=").append(this.allowNetworkRequest).append(", soc=").append(this.soc).append(", enableDownloadForegroundService=").append(this.enableDownloadForegroundService).append(", startDownloadForegroundService=").append(this.startDownloadForegroundService).append(", stopDownloadForegroundService=").append(this.stopDownloadForegroundService).append(", region=").append(this.region);
                r0.append(')');
                return r0.toString();
            }
        }

        @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001JE\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0005H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u000bJ\b\u0010\f\u001a\u00020\u0004H\u0016J\u0018\u0010\r\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0016J\u0018\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0016J\u0018\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0016J7\u0010\u0010\u001a\u00020\u00112$\u0010\u0012\u001a \u0012\u0004\u0012\u00020\u0005\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00150\u00030\u00140\u0013H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0016J!\u0010\u0017\u001a\u00020\u00112\u000e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0019H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u001a\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001b"}, d2 = {"Lcom/obric/aikernel/res/PackageResourceManager$PresmConfig$DecryptFeature;", "", "decrypt", "Lkotlin/Pair;", "", "", "model", "version", "installPath", "srcPath", "targetPath", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "enable", "getEncryptedPresetModelPath", "isEncryptedPresetModel", "isPresetDecrypted", "updatePendingDecryptModels", "", "modelFiles", "", "", "Lcom/google/gson/JsonObject;", "(Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "waitDecrypting", "modelSet", "", "(Ljava/util/Collection;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resource_manager_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public interface a {

            /* JADX INFO: renamed from: com.obric.aikernel.res.PackageResourceManager$PresmConfig$a$a, reason: collision with other inner class name */
            @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
            public static final class C0255a {
                public static Object a(a r0, String r1, String r2, String r3, String r4, String r5, Continuation<? super Pair<Boolean, String>> r6) {
                    a r7 = (a) ZeusTransformUtils.wrapperContextForParams(r0, a.class, "com.obric.memorydata.plugin");
                    Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
                    return new Pair(Boxing.boxBoolean(true), "");
                }

                public static Object a(a r2, Collection<String> r3, Continuation<? super Unit> r4) {
                    a r5 = (a) ZeusTransformUtils.wrapperContextForParams(r2, a.class, "com.obric.memorydata.plugin");
                    Collection r6 = (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin");
                    Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
                    return Unit.INSTANCE;
                }

                public static Object a(a r2, Map<String, ? extends List<Pair<String, JsonObject>>> r3, Continuation<? super Unit> r4) {
                    a r5 = (a) ZeusTransformUtils.wrapperContextForParams(r2, a.class, "com.obric.memorydata.plugin");
                    Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
                    Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
                    return Unit.INSTANCE;
                }

                public static boolean a(a r2) {
                    a r3 = (a) ZeusTransformUtils.wrapperContextForParams(r2, a.class, "com.obric.memorydata.plugin");
                    return false;
                }

                public static boolean a(a r2, String r3, String r4) {
                    a r5 = (a) ZeusTransformUtils.wrapperContextForParams(r2, a.class, "com.obric.memorydata.plugin");
                    Intrinsics.checkNotNullParameter(r3, "model");
                    Intrinsics.checkNotNullParameter(r4, "version");
                    return false;
                }

                public static String b(a r2, String r3, String r4) {
                    a r5 = (a) ZeusTransformUtils.wrapperContextForParams(r2, a.class, "com.obric.memorydata.plugin");
                    Intrinsics.checkNotNullParameter(r3, "model");
                    Intrinsics.checkNotNullParameter(r4, "version");
                    return "";
                }

                public static boolean c(a r2, String r3, String r4) {
                    a r5 = (a) ZeusTransformUtils.wrapperContextForParams(r2, a.class, "com.obric.memorydata.plugin");
                    Intrinsics.checkNotNullParameter(r3, "model");
                    Intrinsics.checkNotNullParameter(r4, "version");
                    return false;
                }
            }

            Object a(String r1, String r2, String r3, String r4, String r5, Continuation<? super Pair<Boolean, String>> r6);

            Object a(Collection<String> r1, Continuation<? super Unit> r2);

            Object a(Map<String, ? extends List<Pair<String, JsonObject>>> r1, Continuation<? super Unit> r2);

            boolean a();

            boolean a(String r1, String r2);

            String b(String r1, String r2);

            boolean c(String r1, String r2);
        }

        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0006J\u0016\u0010\u0007\u001a\u00020\u00032\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\tH&J\u000e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u000bH&\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\f"}, d2 = {"Lcom/obric/aikernel/res/PackageResourceManager$PresmConfig$INativeLibraryNotifier;", "", "onSubprocessNativeLibUpdated", "", "proc", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "pushDebugPackages", "packages", "", "syncNativeLibInfo", "Lkotlinx/coroutines/Deferred;", "resource_manager_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public interface b {
            Object a(String r1, Continuation<? super Unit> r2);

            ar<Unit> a();

            void a(List<String> r1);
        }

        @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u0000 \t2\u00020\u0001:\u0001\tJ \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016¨\u0006\n"}, d2 = {"Lcom/obric/aikernel/res/PackageResourceManager$PresmConfig$IPackageActionInjector;", "", "isAllow", "", "action", "", "pkg", "", "caller", "Companion", "resource_manager_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public interface c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final a f5997a = null;

            @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/obric/aikernel/res/PackageResourceManager$PresmConfig$IPackageActionInjector$Companion;", "", "()V", "ACTION_UPDATE", "", "resource_manager_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
            public static final class a {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                static final /* synthetic */ a f5998a = null;

                static {
                    f5998a = new a();
                }

                private a() {
                }
            }

            @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
            public static final class b {
                public static boolean a(c r1, int r2, String r3, String r4) {
                    c r5 = (c) ZeusTransformUtils.wrapperContextForParams(r1, c.class, "com.obric.memorydata.plugin");
                    Intrinsics.checkNotNullParameter(r3, "pkg");
                    Intrinsics.checkNotNullParameter(r4, "caller");
                    return true;
                }
            }

            static {
                f5997a = a.f5998a;
            }

            boolean a(int r1, String r2, String r3);
        }

        @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\tH&J \u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¨\u0006\u0010"}, d2 = {"Lcom/obric/aikernel/res/PackageResourceManager$PresmConfig$UpdateListener;", "", "onAutoUpdateAttempt", "", "result", "Lcom/obric/aikernel/res/update/AutoUpdateAttemptResult;", "onModelDownloadResult", "Lcom/obric/aikernel/res/update/ModelDownloadResult;", "onResult", "Lcom/obric/aikernel/res/update/UpdateResult;", "onStartUpdate", "constriction", "Lcom/obric/aikernel/res/update/PackageUpdater$Constriction;", "bizStat", "", "type", "resource_manager_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public interface d {
            void a(UpdateResult r1);

            void a(com.obric.aikernel.res.update.a r1);

            void a(j r1);

            void a(n.b r1, String r2, String r3);
        }

        @Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"com/obric/aikernel/res/PackageResourceManager$PresmConfig$decryptFeature$1", "Lcom/obric/aikernel/res/PackageResourceManager$PresmConfig$DecryptFeature;", "resource_manager_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static final class e implements a {
            e() {
            }

            @Override // com.obric.aikernel.res.PackageResourceManager.PresmConfig.a
            public Object a(String r8, String r9, String r10, String r11, String r12, Continuation<? super Pair<Boolean, String>> r13) {
                return a.C0255a.a(this, r8, r9, r10, r11, r12, (Continuation) ZeusTransformUtils.wrapperContextForParams(r13, Continuation.class, "com.obric.memorydata.plugin"));
            }

            @Override // com.obric.aikernel.res.PackageResourceManager.PresmConfig.a
            public Object a(Collection<String> r3, Continuation<? super Unit> r4) {
                return a.C0255a.a(this, (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin"));
            }

            @Override // com.obric.aikernel.res.PackageResourceManager.PresmConfig.a
            public Object a(Map<String, ? extends List<Pair<String, JsonObject>>> r3, Continuation<? super Unit> r4) {
                return a.C0255a.a(this, (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin"));
            }

            @Override // com.obric.aikernel.res.PackageResourceManager.PresmConfig.a
            public boolean a() {
                return a.C0255a.a(this);
            }

            @Override // com.obric.aikernel.res.PackageResourceManager.PresmConfig.a
            public boolean a(String r1, String r2) {
                return a.C0255a.a(this, r1, r2);
            }

            @Override // com.obric.aikernel.res.PackageResourceManager.PresmConfig.a
            public String b(String r1, String r2) {
                return a.C0255a.b(this, r1, r2);
            }

            @Override // com.obric.aikernel.res.PackageResourceManager.PresmConfig.a
            public boolean c(String r1, String r2) {
                return a.C0255a.c(this, r1, r2);
            }
        }

        public PresmConfig(Context r15, String r16, String r17, AppConfig r18, String r19, String r20, String r21, com.obric.aikernel.runtime.utils.c r22, c r23, String r24, Map<String, ? extends Set<String>> r25, boolean r26, int r27, List<String> r28, List<String> r29) {
            Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r15, Context.class, "com.obric.memorydata.plugin");
            com.obric.aikernel.runtime.utils.c r8 = (com.obric.aikernel.runtime.utils.c) ZeusTransformUtils.wrapperContextForParams(r22, com.obric.aikernel.runtime.utils.c.class, "com.obric.memorydata.plugin");
            c r9 = (c) ZeusTransformUtils.wrapperContextForParams(r23, c.class, "com.obric.memorydata.plugin");
            Map<String, Set<String>> r10 = (Map) ZeusTransformUtils.wrapperContextForParams(r25, Map.class, "com.obric.memorydata.plugin");
            List<String> r11 = (List) ZeusTransformUtils.wrapperContextForParams(r28, List.class, "com.obric.memorydata.plugin");
            List<String> r12 = (List) ZeusTransformUtils.wrapperContextForParams(r29, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r6, "context");
            Intrinsics.checkNotNullParameter(r16, "rootDir");
            Intrinsics.checkNotNullParameter(r17, "resRootDir");
            Intrinsics.checkNotNullParameter(r18, "appConfig");
            Intrinsics.checkNotNullParameter(r19, "pyVmVersion");
            Intrinsics.checkNotNullParameter(r9, "packageActionInjector");
            Intrinsics.checkNotNullParameter(r11, "presetModelRoots");
            Intrinsics.checkNotNullParameter(r12, "platformIntegrityModelRoots");
            this.context = ZeusTransformUtils.wrapperContext(r6, "com.obric.memorydata.plugin");
            this.rootDir = r16;
            this.resRootDir = r17;
            this.appConfig = r18;
            this.pyVmVersion = r19;
            this.assertRootDir = r20;
            this.deviceRootDir = r21;
            this.logger = r8;
            this.packageActionInjector = r9;
            this.preInitPackageName = r24;
            this.presetLibraries = r10;
            this.useObricDownloader = r26;
            this.parallelDownloadNum = r27;
            this.presetModelRoots = r11;
            this.platformIntegrityModelRoots = r12;
            this.memSize$delegate = LazyKt.lazy((Function0) ZeusTransformUtils.preCheckCast(PackageResourceManager$PresmConfig$memSize$2.INSTANCE, Function0.class, "com.obric.memorydata.plugin"));
            this.decryptFeature = (a) ZeusTransformUtils.preCheckCast(new e(), a.class, "com.obric.memorydata.plugin");
            this.isInferProcess = (Function0) ZeusTransformUtils.preCheckCast(PackageResourceManager$PresmConfig$isInferProcess$1.INSTANCE, Function0.class, "com.obric.memorydata.plugin");
            if (r8 == null) goto L5;
            com.obric.aikernel.runtime.utils.d.f6216a.a(r8);
        L5:
            if (r26 == false) goto L8;
            com.obric.aikernel.res.downloader.obric.a.f6030a.a(this);
            return;
        }

        public /* synthetic */ PresmConfig(Context r20, String r21, String r22, AppConfig r23, String r24, String r25, String r26, com.obric.aikernel.runtime.utils.c r27, c r28, String r29, Map r30, boolean r31, int r32, List r33, List r34, int r35, DefaultConstructorMarker r36) {
            Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r20, Context.class, "com.obric.memorydata.plugin");
            com.obric.aikernel.runtime.utils.c r1 = (com.obric.aikernel.runtime.utils.c) ZeusTransformUtils.wrapperContextForParams(r27, com.obric.aikernel.runtime.utils.c.class, "com.obric.memorydata.plugin");
            c r3 = (c) ZeusTransformUtils.wrapperContextForParams(r28, c.class, "com.obric.memorydata.plugin");
            Map r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r30, Map.class, "com.obric.memorydata.plugin");
            List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r33, List.class, "com.obric.memorydata.plugin");
            List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r34, List.class, "com.obric.memorydata.plugin");
            if ((r35 & 32) == 0) goto L5;
            String r10 = null;
        L7:
            if ((r35 & 64) == 0) goto L9;
            String r11 = null;
        L11:
            if ((r35 & 128) == 0) goto L14;
            r1 = null;
        L14:
            if ((r35 & 256) == 0) goto L16;
            c r12 = (c) ZeusTransformUtils.preCheckCast(new AnonymousClass1(), c.class, "com.obric.memorydata.plugin");
        L18:
            if ((r35 & 512) == 0) goto L20;
            String r13 = null;
        L22:
            if ((r35 & 1024) == 0) goto L24;
            Map r14 = null;
        L26:
            if ((r35 & 2048) == 0) goto L28;
            boolean r15 = false;
        L30:
            if ((r35 & 4096) == 0) goto L32;
            int r16 = 4;
        L34:
            if ((r35 & 8192) == 0) goto L36;
            List r17 = CollectionsKt.emptyList();
        L38:
            if ((r35 & 16384) == 0) goto L40;
            List r18 = CollectionsKt.emptyList();
        L41:
            this(r4, r21, r22, r23, r24, r10, r11, r1, r12, r13, r14, r15, r16, r17, r18);
            return;
        L40:
            r18 = r7;
            goto L41
        L36:
            r17 = r6;
            goto L38
        L32:
            r16 = r32;
            goto L34
        L28:
            r15 = r31;
            goto L30
        L24:
            r14 = r5;
            goto L26
        L20:
            r13 = r29;
            goto L22
        L16:
            r12 = r3;
            goto L18
        L9:
            r11 = r26;
            goto L11
        L5:
            r10 = r25;
            goto L7
        }

        public static /* synthetic */ PresmConfig copy$default(PresmConfig r16, Context r17, String r18, String r19, AppConfig r20, String r21, String r22, String r23, com.obric.aikernel.runtime.utils.c r24, c r25, String r26, Map r27, boolean r28, int r29, List r30, List r31, int r32, Object r33) {
            Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r17, Context.class, "com.obric.memorydata.plugin");
            com.obric.aikernel.runtime.utils.c r4 = (com.obric.aikernel.runtime.utils.c) ZeusTransformUtils.wrapperContextForParams(r24, com.obric.aikernel.runtime.utils.c.class, "com.obric.memorydata.plugin");
            c r5 = (c) ZeusTransformUtils.wrapperContextForParams(r25, c.class, "com.obric.memorydata.plugin");
            Map<String, Set<String>> r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r27, Map.class, "com.obric.memorydata.plugin");
            List<String> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r30, List.class, "com.obric.memorydata.plugin");
            List<String> r3 = (List) ZeusTransformUtils.wrapperContextForParams(r31, List.class, "com.obric.memorydata.plugin");
            if ((r32 & 1) == 0) goto L6;
            r2 = r16.context;
        L6:
            if ((r32 & 2) == 0) goto L8;
            String r8 = r16.rootDir;
        L10:
            if ((r32 & 4) == 0) goto L12;
            String r9 = r16.resRootDir;
        L14:
            if ((r32 & 8) == 0) goto L16;
            AppConfig r10 = r16.appConfig;
        L18:
            if ((r32 & 16) == 0) goto L20;
            String r11 = r16.pyVmVersion;
        L22:
            if ((r32 & 32) == 0) goto L24;
            String r12 = r16.assertRootDir;
        L26:
            if ((r32 & 64) == 0) goto L28;
            String r13 = r16.deviceRootDir;
        L30:
            if ((r32 & 128) == 0) goto L33;
            r4 = r16.logger;
        L33:
            if ((r32 & 256) == 0) goto L36;
            r5 = r16.packageActionInjector;
        L36:
            if ((r32 & 512) == 0) goto L38;
            String r14 = r16.preInitPackageName;
        L40:
            if ((r32 & 1024) == 0) goto L43;
            r6 = r16.presetLibraries;
        L43:
            if ((r32 & 2048) == 0) goto L45;
            boolean r15 = r16.useObricDownloader;
        L47:
            if ((r32 & 4096) == 0) goto L49;
            int r34 = r16.parallelDownloadNum;
        L51:
            if ((r32 & 8192) == 0) goto L53;
            List<String> r35 = r16.presetModelRoots;
        L55:
            if ((r32 & 16384) == 0) goto L57;
            List<String> r1 = r16.platformIntegrityModelRoots;
        L59:
            return r16.copy(r2, r8, r9, r10, r11, r12, r13, r4, r5, r14, r6, r15, r34, r35, r1);
        L57:
            r1 = r3;
            goto L59
        L53:
            r35 = r7;
            goto L55
        L49:
            r34 = r29;
            goto L51
        L45:
            r15 = r28;
            goto L47
        L38:
            r14 = r26;
            goto L40
        L28:
            r13 = r23;
            goto L30
        L24:
            r12 = r22;
            goto L26
        L20:
            r11 = r21;
            goto L22
        L16:
            r10 = r20;
            goto L18
        L12:
            r9 = r19;
            goto L14
        L8:
            r8 = r18;
            goto L10
        }

        public final Context component1() {
            return this.context;
        }

        public final String component10() {
            return this.preInitPackageName;
        }

        public final Map<String, Set<String>> component11() {
            return this.presetLibraries;
        }

        public final boolean component12() {
            return this.useObricDownloader;
        }

        public final int component13() {
            return this.parallelDownloadNum;
        }

        public final List<String> component14() {
            return this.presetModelRoots;
        }

        public final List<String> component15() {
            return this.platformIntegrityModelRoots;
        }

        public final String component2() {
            return this.rootDir;
        }

        public final String component3() {
            return this.resRootDir;
        }

        public final AppConfig component4() {
            return this.appConfig;
        }

        public final String component5() {
            return this.pyVmVersion;
        }

        public final String component6() {
            return this.assertRootDir;
        }

        public final String component7() {
            return this.deviceRootDir;
        }

        public final com.obric.aikernel.runtime.utils.c component8() {
            return this.logger;
        }

        public final c component9() {
            return this.packageActionInjector;
        }

        public final PresmConfig copy(Context r20, String r21, String r22, AppConfig r23, String r24, String r25, String r26, com.obric.aikernel.runtime.utils.c r27, c r28, String r29, Map<String, ? extends Set<String>> r30, boolean r31, int r32, List<String> r33, List<String> r34) {
            Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r20, Context.class, "com.obric.memorydata.plugin");
            com.obric.aikernel.runtime.utils.c r10 = (com.obric.aikernel.runtime.utils.c) ZeusTransformUtils.wrapperContextForParams(r27, com.obric.aikernel.runtime.utils.c.class, "com.obric.memorydata.plugin");
            c r11 = (c) ZeusTransformUtils.wrapperContextForParams(r28, c.class, "com.obric.memorydata.plugin");
            Map r13 = (Map) ZeusTransformUtils.wrapperContextForParams(r30, Map.class, "com.obric.memorydata.plugin");
            List r0 = (List) ZeusTransformUtils.wrapperContextForParams(r33, List.class, "com.obric.memorydata.plugin");
            List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r34, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, "context");
            Intrinsics.checkNotNullParameter(r21, "rootDir");
            Intrinsics.checkNotNullParameter(r22, "resRootDir");
            Intrinsics.checkNotNullParameter(r23, "appConfig");
            Intrinsics.checkNotNullParameter(r24, "pyVmVersion");
            Intrinsics.checkNotNullParameter(r11, "packageActionInjector");
            Intrinsics.checkNotNullParameter(r0, "presetModelRoots");
            Intrinsics.checkNotNullParameter(r1, "platformIntegrityModelRoots");
            return new PresmConfig(r3, r21, r22, r23, r24, r25, r26, r10, r11, r29, r13, r31, r32, r0, r1);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, PresmConfig.class) == true) goto L8;
            return false;
        L8:
            PresmConfig r6 = (PresmConfig) ZeusTransformUtils.preCheckCast(r5, PresmConfig.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.context, r6.context) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.rootDir, r6.rootDir) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.resRootDir, r6.resRootDir) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.appConfig, r6.appConfig) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.pyVmVersion, r6.pyVmVersion) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.assertRootDir, r6.assertRootDir) == true) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.deviceRootDir, r6.deviceRootDir) == true) goto L30;
            return false;
        L30:
            if (Intrinsics.areEqual(this.logger, r6.logger) == true) goto L33;
            return false;
        L33:
            if (Intrinsics.areEqual(this.packageActionInjector, r6.packageActionInjector) == true) goto L36;
            return false;
        L36:
            if (Intrinsics.areEqual(this.preInitPackageName, r6.preInitPackageName) == true) goto L39;
            return false;
        L39:
            if (Intrinsics.areEqual(this.presetLibraries, r6.presetLibraries) == true) goto L42;
            return false;
        L42:
            if (this.useObricDownloader == r6.useObricDownloader) goto L45;
            return false;
        L45:
            if (this.parallelDownloadNum == r6.parallelDownloadNum) goto L48;
            return false;
        L48:
            if (Intrinsics.areEqual(this.presetModelRoots, r6.presetModelRoots) == true) goto L51;
            return false;
        L51:
            if (Intrinsics.areEqual(this.platformIntegrityModelRoots, r6.platformIntegrityModelRoots) == true) goto L53;
            return false;
        L53:
            return true;
        }

        public final AppConfig getAppConfig() {
            return this.appConfig;
        }

        public final String getAssertRootDir() {
            return this.assertRootDir;
        }

        public final Context getContext() {
            return this.context;
        }

        public final com.obric.aikernel.res.installer.d getCustomInstaller() {
            return this.customInstaller;
        }

        public final a getDecryptFeature() {
            return this.decryptFeature;
        }

        public final String getDeviceRootDir() {
            return this.deviceRootDir;
        }

        public final com.obric.aikernel.res.metadata.data.a.c getDynamicResProxy() {
            return this.dynamicResProxy;
        }

        public final com.obric.aikernel.runtime.utils.c getLogger() {
            return this.logger;
        }

        public final int getMemSize() {
            return ((Number) ZeusTransformUtils.preCheckCast(this.memSize$delegate.getValue(), Number.class, "com.obric.memorydata.plugin")).intValue();
        }

        public final b getNativeLibLifeCycle() {
            return this.nativeLibLifeCycle;
        }

        public final c getPackageActionInjector() {
            return this.packageActionInjector;
        }

        public final int getParallelDownloadNum() {
            return this.parallelDownloadNum;
        }

        public final List<String> getPlatformIntegrityModelRoots() {
            return this.platformIntegrityModelRoots;
        }

        public final String getPreInitPackageName() {
            return this.preInitPackageName;
        }

        public final Map<String, Set<String>> getPresetLibraries() {
            return this.presetLibraries;
        }

        public final List<String> getPresetModelRoots() {
            return this.presetModelRoots;
        }

        public final String getPyVmVersion() {
            return this.pyVmVersion;
        }

        public final String getResRootDir() {
            return this.resRootDir;
        }

        public final String getRootDir() {
            return this.rootDir;
        }

        public final d getUpdateListener() {
            return this.updateListener;
        }

        public final boolean getUseAIKernelModel() {
            return this.useAIKernelModel;
        }

        public final boolean getUseObricDownloader() {
            return this.useObricDownloader;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v23, types: [int] */
        /* JADX WARN: Type inference failed for: r1v24, types: [int] */
        /* JADX WARN: Type inference failed for: r1v29 */
        /* JADX WARN: Type inference failed for: r1v34 */
        public int hashCode() {
            int r0 = ((((((((this.context.hashCode() * 31) + this.rootDir.hashCode()) * 31) + this.resRootDir.hashCode()) * 31) + this.appConfig.hashCode()) * 31) + this.pyVmVersion.hashCode()) * 31;
            String r1 = this.assertRootDir;
            int r2 = 0;
            if (r1 != null) goto L5;
            int r3 = 0;
        L6:
            int r4 = (r0 + r3) * 31;
            String r5 = this.deviceRootDir;
            if (r5 != null) goto L9;
            int r6 = 0;
        L10:
            int r7 = (r4 + r6) * 31;
            com.obric.aikernel.runtime.utils.c r8 = this.logger;
            if (r8 != null) goto L13;
            int r9 = 0;
        L14:
            int r10 = (((r7 + r9) * 31) + this.packageActionInjector.hashCode()) * 31;
            String r11 = this.preInitPackageName;
            if (r11 != null) goto L17;
            int r12 = 0;
        L18:
            int r13 = (r10 + r12) * 31;
            Map<String, Set<String>> r14 = this.presetLibraries;
            if (r14 == null) goto L22;
            r2 = r14.hashCode();
        L22:
            int r15 = (r13 + r2) * 31;
            boolean r16 = this.useObricDownloader;
            ?? r17 = r16;
            if (r16 == false) goto L26;
            r17 = 1;
        L26:
            return ((((((r15 + r17) * 31) + Integer.hashCode(this.parallelDownloadNum)) * 31) + this.presetModelRoots.hashCode()) * 31) + this.platformIntegrityModelRoots.hashCode();
        L17:
            r12 = r11.hashCode();
            goto L18
        L13:
            r9 = r8.hashCode();
            goto L14
        L9:
            r6 = r5.hashCode();
            goto L10
        L5:
            r3 = r1.hashCode();
            goto L6
        }

        public final Function0<Boolean> isInferProcess() {
            return this.isInferProcess;
        }

        public final void setCustomInstaller(com.obric.aikernel.res.installer.d r3) {
            this.customInstaller = (com.obric.aikernel.res.installer.d) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.aikernel.res.installer.d.class, "com.obric.memorydata.plugin");
        }

        public final void setDecryptFeature(a r3) {
            a r4 = (a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r4, "<set-?>");
            this.decryptFeature = r4;
        }

        public final void setDynamicResProxy(com.obric.aikernel.res.metadata.data.a.c r3) {
            this.dynamicResProxy = (com.obric.aikernel.res.metadata.data.a.c) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.aikernel.res.metadata.data.a.c.class, "com.obric.memorydata.plugin");
        }

        public final void setInferProcess(Function0<Boolean> r3) {
            Function0<Boolean> r4 = (Function0) ZeusTransformUtils.wrapperContextForParams(r3, Function0.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r4, "<set-?>");
            this.isInferProcess = r4;
        }

        public final void setNativeLibLifeCycle(b r3) {
            this.nativeLibLifeCycle = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.memorydata.plugin");
        }

        public final void setUpdateListener(d r3) {
            this.updateListener = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.memorydata.plugin");
        }

        public final void setUseAIKernelModel(boolean r1) {
            this.useAIKernelModel = r1;
        }

        public String toString() {
            StringBuilder r0 = new StringBuilder();
            r0.append("PresmConfig(context=").append(this.context).append(", rootDir=").append(this.rootDir).append(", resRootDir=").append(this.resRootDir).append(", appConfig=").append(this.appConfig).append(", pyVmVersion=").append(this.pyVmVersion).append(", assertRootDir=").append(this.assertRootDir).append(", deviceRootDir=").append(this.deviceRootDir).append(", logger=").append(this.logger).append(", packageActionInjector=").append(this.packageActionInjector).append(", preInitPackageName=").append(this.preInitPackageName).append(", presetLibraries=").append(this.presetLibraries).append(", useObricDownloader=");
            r0.append(this.useObricDownloader).append(", parallelDownloadNum=").append(this.parallelDownloadNum).append(", presetModelRoots=").append(this.presetModelRoots).append(", platformIntegrityModelRoots=").append(this.platformIntegrityModelRoots).append(')');
            return r0.toString();
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/aikernel/res/PackageResourceManager$Companion;", "", "()V", "DEBUG_CALLER", "", "TAG", "resource_manager_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.obric.aikernel.res.PackageResourceManager$clean$1, reason: invalid class name */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.obric.aikernel.res.PackageResourceManager", f = "PackageResourceManager.kt", i = {0}, l = {313}, m = "clean", n = {"this"}, s = {"L$0"})
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ PackageResourceManager this$0;

        AnonymousClass1(PackageResourceManager r3, Continuation<? super AnonymousClass1> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            super(r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r3) {
            this.result = r3;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.clean((Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin"));
        }
    }

    /* JADX INFO: renamed from: com.obric.aikernel.res.PackageResourceManager$cleanCache$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.obric.aikernel.res.PackageResourceManager", f = "PackageResourceManager.kt", i = {}, l = {TypedValues.AttributesType.TYPE_PIVOT_TARGET}, m = "cleanCache", n = {}, s = {})
    static final class C10091 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ PackageResourceManager this$0;

        C10091(PackageResourceManager r3, Continuation<? super C10091> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            super(r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r3) {
            this.result = r3;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.cleanCache((Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin"));
        }
    }

    /* JADX INFO: renamed from: com.obric.aikernel.res.PackageResourceManager$getAllPackageConfigs$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.obric.aikernel.res.PackageResourceManager", f = "PackageResourceManager.kt", i = {}, l = {127}, m = "getAllPackageConfigs", n = {}, s = {})
    static final class C10101 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ PackageResourceManager this$0;

        C10101(PackageResourceManager r3, Continuation<? super C10101> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            super(r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r3) {
            this.result = r3;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.getAllPackageConfigs((Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin"));
        }
    }

    /* JADX INFO: renamed from: com.obric.aikernel.res.PackageResourceManager$getDownloadingSummary$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.obric.aikernel.res.PackageResourceManager", f = "PackageResourceManager.kt", i = {0, 0}, l = {332}, m = "getDownloadingSummary", n = {CommonConsts.COUNT_TYPE, "totalSpeed"}, s = {"L$0", "L$1"})
    static final class C10111 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ PackageResourceManager this$0;

        C10111(PackageResourceManager r3, Continuation<? super C10111> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            super(r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r3) {
            this.result = r3;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.getDownloadingSummary((Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin"));
        }
    }

    /* JADX INFO: renamed from: com.obric.aikernel.res.PackageResourceManager$getPackageConfig$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.obric.aikernel.res.PackageResourceManager", f = "PackageResourceManager.kt", i = {0}, l = {129}, m = "getPackageConfig", n = {ActivityLifecycle.NAME}, s = {"L$0"})
    static final class C10121 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ PackageResourceManager this$0;

        C10121(PackageResourceManager r3, Continuation<? super C10121> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            super(r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r3) {
            this.result = r3;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.getPackageConfig(null, (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin"));
        }
    }

    /* JADX INFO: renamed from: com.obric.aikernel.res.PackageResourceManager$getPackageUpdateInfo$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.obric.aikernel.res.PackageResourceManager", f = "PackageResourceManager.kt", i = {0}, l = {124}, m = "getPackageUpdateInfo", n = {"biz"}, s = {"L$0"})
    static final class C10131 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ PackageResourceManager this$0;

        C10131(PackageResourceManager r3, Continuation<? super C10131> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            super(r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r3) {
            this.result = r3;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.getPackageUpdateInfo(null, (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin"));
        }
    }

    /* JADX INFO: renamed from: com.obric.aikernel.res.PackageResourceManager$getPackageUpdateProgress$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.obric.aikernel.res.PackageResourceManager", f = "PackageResourceManager.kt", i = {0}, l = {131}, m = "getPackageUpdateProgress", n = {"biz"}, s = {"L$0"})
    static final class C10141 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ PackageResourceManager this$0;

        C10141(PackageResourceManager r3, Continuation<? super C10141> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            super(r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r3) {
            this.result = r3;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.getPackageUpdateProgress(null, (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin"));
        }
    }

    /* JADX INFO: renamed from: com.obric.aikernel.res.PackageResourceManager$pushDebugDistributeInfo$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.obric.aikernel.res.PackageResourceManager", f = "PackageResourceManager.kt", i = {0, 2}, l = {305, 305, 307, 307}, m = "pushDebugDistributeInfo", n = {"biz", "info"}, s = {"L$0", "L$0"})
    static final class C10151 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ PackageResourceManager this$0;

        C10151(PackageResourceManager r3, Continuation<? super C10151> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            super(r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r3) {
            this.result = r3;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.pushDebugDistributeInfo(null, (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin"));
        }
    }

    /* JADX INFO: renamed from: com.obric.aikernel.res.PackageResourceManager$resumeBlockedUpdateTasksIfNeed$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.obric.aikernel.res.PackageResourceManager", f = "PackageResourceManager.kt", i = {0}, l = {345}, m = "resumeBlockedUpdateTasksIfNeed", n = {"trigger"}, s = {"L$0"})
    static final class C10161 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ PackageResourceManager this$0;

        C10161(PackageResourceManager r3, Continuation<? super C10161> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            super(r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r3) {
            this.result = r3;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.resumeBlockedUpdateTasksIfNeed(null, (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin"));
        }
    }

    /* JADX INFO: renamed from: com.obric.aikernel.res.PackageResourceManager$updateAll$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.obric.aikernel.res.PackageResourceManager", f = "PackageResourceManager.kt", i = {0, 0, 0, 0, 1, 1, 1}, l = {271, 273}, m = "updateAll", n = {"caller", "packageNames", "$this$updateAll_u24lambda_u2414", TraceCons.METRIC_BACKGROUND, "caller", "$this$updateAll_u24lambda_u2414", TraceCons.METRIC_BACKGROUND}, s = {"L$0", "L$1", "L$2", "Z$0", "L$0", "L$1", "Z$0"})
    static final class C10171 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ PackageResourceManager this$0;

        C10171(PackageResourceManager r3, Continuation<? super C10171> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            super(r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r3) {
            this.result = r3;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.updateAll(null, false, (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin"));
        }
    }

    /* JADX INFO: renamed from: com.obric.aikernel.res.PackageResourceManager$updateByForeground$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.obric.aikernel.res.PackageResourceManager", f = "PackageResourceManager.kt", i = {0, 0, 0, 0, 0, 1, 1}, l = {138, 138}, m = "updateByForeground", n = {"this", ActivityLifecycle.NAME, "caller", Params.LORA_TYPE, "force", "this", ActivityLifecycle.NAME}, s = {"L$0", "L$1", "L$2", "L$3", "Z$0", "L$0", "L$1"})
    static final class C10181 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ PackageResourceManager this$0;

        C10181(PackageResourceManager r3, Continuation<? super C10181> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            super(r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r7) {
            this.result = r7;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.updateByForeground(null, null, false, null, (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin"));
        }
    }

    /* JADX INFO: renamed from: com.obric.aikernel.res.PackageResourceManager$updatePackage$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.obric.aikernel.res.PackageResourceManager", f = "PackageResourceManager.kt", i = {0, 0, 0, 0, 0, 0, 1, 1}, l = {157, 157}, m = "updatePackage", n = {"this", ActivityLifecycle.NAME, "caller", Params.LORA_TYPE, TraceCons.METRIC_BACKGROUND, "force", "this", ActivityLifecycle.NAME}, s = {"L$0", "L$1", "L$2", "L$3", "Z$0", "Z$1", "L$0", "L$1"})
    static final class C10191 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        boolean Z$0;
        boolean Z$1;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ PackageResourceManager this$0;

        C10191(PackageResourceManager r3, Continuation<? super C10191> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            super(r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r8) {
            this.result = r8;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.updatePackage(null, null, false, false, null, (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin"));
        }
    }

    static {
        Companion = new a(null);
    }

    public PackageResourceManager(PresmConfig r13) {
        Intrinsics.checkNotNullParameter(r13, "presmConfig");
        PrmContext r0 = new PrmContext(r13, this);
        this.context = r0;
        this.runningDepsGetter = (Function0) ZeusTransformUtils.preCheckCast(PackageResourceManager$runningDepsGetter$1.INSTANCE, Function0.class, "com.obric.memorydata.plugin");
        b r1 = new b(r0.getScope$resource_manager_release());
        this.packagesListener = r1;
        com.obric.aikernel.res.metadata.controller.a r2 = new com.obric.aikernel.res.metadata.controller.a(r0, r1);
        this.metadataController = r2;
        d r3 = new d(r0);
        this.globalDownloadController = r3;
        NativeLibVersionPolicy.INSTANCE.init(r0);
        if (r13.getAppConfig().getCheckAssistantAutoUpdateSwitch() == false) goto L5;
        com.obric.aikernel.res.a.f5999a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r13.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
    L5:
        r0.setMetadataCtrl$resource_manager_release(r2);
        r0.setDownloadCtrl$resource_manager_release(r3);
        File r4 = new File(r13.getRootDir());
        if (r4.exists() == true) goto L8;
        r4.mkdirs();
    L8:
        r2.h();
        com.obric.aikernel.runtime.utils.d.f6216a.a(TAG, "init config: " + r13);
        List r14 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        com.obric.aikernel.res.installer.d r5 = r0.getConfig().getCustomInstaller();
        if (r5 == null) goto L11;
        r14.add(r5);
    L11:
        String r6 = r0.getConfig().getAssertRootDir();
        boolean r7 = true;
        if (r6 != null) goto L14;
    L22:
        String r8 = r0.getConfig().getDeviceRootDir();
        if (r8 != null) goto L25;
    L33:
        this.fusionInstaller = new c(r14);
        this.updater = i.b(am.a((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.a(), CoroutineContext.class, "com.obric.memorydata.plugin")), null, null, (Function2) ZeusTransformUtils.preCheckCast(new PackageResourceManager$updater$1(this, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        return;
    L25:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.memorydata.plugin")).length() > 0) goto L28;
        r7 = false;
    L28:
        if (r7 == true) goto L31;
        r8 = null;
    L31:
        if (r8 == null) goto L33;
        r14.add(new com.obric.aikernel.res.installer.b(r8));
        goto L33
    L14:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L16;
        boolean r9 = true;
    L17:
        if (r9 == true) goto L20;
        r6 = null;
    L20:
        if (r6 == null) goto L22;
        AssetManager r10 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r0.getConfig().getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getAssets();
        Intrinsics.checkNotNullExpressionValue(r10, "context.config.context.assets");
        r14.add(new com.obric.aikernel.res.installer.a(r10, r6));
        goto L22
    L16:
        r9 = false;
        goto L17
    }

    public static final /* synthetic */ com.obric.aikernel.res.metadata.controller.a access$getMetadataController$p(PackageResourceManager r0) {
        return r0.metadataController;
    }

    public static /* synthetic */ void disable$default(PackageResourceManager r0, String r1, String r2, String r3, boolean r4, int r5, Object r6) {
        if ((r5 & 8) == 0) goto L5;
        r4 = false;
    L5:
        r0.disable(r1, r2, r3, r4);
    }

    private final String summarizeUpdateResults(Map<String, UpdateResult> r13) {
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
        return "resultCount=" + r12.size() + " success=" + r2 + " failed=" + (r12.size() - r2) + " failureSummary=[" + CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"), null, null, null, 5, null, (Function1) ZeusTransformUtils.preCheckCast(PackageResourceManager$summarizeUpdateResults$failureSummary$2.INSTANCE, Function1.class, "com.obric.memorydata.plugin"), 23, null) + ']';
    L5:
        if (((Collection) ZeusTransformUtils.preCheckCast(r14, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L7;
        goto L7
    }

    public static /* synthetic */ void uninstall$default(PackageResourceManager r0, String r1, String r2, String r3, boolean r4, int r5, Object r6) {
        if ((r5 & 8) == 0) goto L5;
        r4 = false;
    L5:
        r0.uninstall(r1, r2, r3, r4);
    }

    public static /* synthetic */ Object updateAll$default(PackageResourceManager r1, String r2, boolean r3, Continuation r4, int r5, Object r6) {
        Continuation<? super Map<String, UpdateResult>> r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        if ((r5 & 1) == 0) goto L6;
        r2 = DEBUG_CALLER;
    L6:
        return r1.updateAll(r2, r3, r7);
    }

    public static /* synthetic */ Object updateByForeground$default(PackageResourceManager r6, String r7, String r8, boolean r9, String r10, Continuation r11, int r12, Object r13) {
        Continuation<? super com.obric.aikernel.res.metadata.data.b> r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r11, Continuation.class, "com.obric.memorydata.plugin");
        if ((r12 & 4) == 0) goto L5;
        r9 = false;
    L5:
        boolean r3 = r9;
        if ((r12 & 8) == 0) goto L9;
        r10 = "";
    L9:
        return r6.updateByForeground(r7, r8, r3, r10, r5);
    }

    public static /* synthetic */ Object updatePackage$default(PackageResourceManager r7, String r8, String r9, boolean r10, boolean r11, String r12, Continuation r13, int r14, Object r15) {
        Continuation<? super com.obric.aikernel.res.metadata.data.b> r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r13, Continuation.class, "com.obric.memorydata.plugin");
        if ((r14 & 8) == 0) goto L5;
        r11 = false;
    L5:
        boolean r4 = r11;
        if ((r14 & 16) == 0) goto L9;
        r12 = "";
    L9:
        return r7.updatePackage(r8, r9, r10, r4, r12, r6);
    }

    public final Object clean(Continuation<? super Unit> r6) {
        Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r7, AnonymousClass1.class) == false) goto L7;
        AnonymousClass1 r0 = (AnonymousClass1) ZeusTransformUtils.preCheckCast(r7, AnonymousClass1.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r8 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        PackageResourceManager this = (PackageResourceManager) ZeusTransformUtils.preCheckCast(r0.L$0, PackageResourceManager.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r8);
    L17:
        n.a((n) ZeusTransformUtils.preCheckCast(r8, n.class, "com.obric.memorydata.plugin"), false, 1, null);
        this.metadataController.f();
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r8);
        ar<n> r9 = this.updater;
        r0.L$0 = this;
        r0.label = 1;
        r8 = r9.a(r0);
        if (r8 != r2) goto L17;
        return r2;
    L7:
        r0 = new AnonymousClass1(this, r7);
        goto L8
    }

    public final Object cleanCache(Continuation<? super Unit> r6) {
        Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r7, C10091.class) == false) goto L7;
        C10091 r0 = (C10091) ZeusTransformUtils.preCheckCast(r7, C10091.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r8 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r8);
    L17:
        ((n) ZeusTransformUtils.preCheckCast(r8, n.class, "com.obric.memorydata.plugin")).a(false);
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r8);
        ar<n> r5 = this.updater;
        r0.label = 1;
        r8 = r5.a(r0);
        if (r8 != r2) goto L17;
        return r2;
    L7:
        r0 = new C10091(this, r7);
        goto L8
    }

    public final Object cleanDebug(Continuation<? super Unit> r3) {
        Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
        this.metadataController.e();
        return Unit.INSTANCE;
    }

    public final void disable(String r4, final String r5, final String r6) {
        Intrinsics.checkNotNullParameter(r4, "type");
        Intrinsics.checkNotNullParameter(r5, ActivityLifecycle.NAME);
        Intrinsics.checkNotNullParameter(r6, "version");
        Map<String, com.obric.aikernel.res.metadata.data.d> r7 = this.metadataController.b().a(r4, r5);
        Function1 r0 = (Function1) ZeusTransformUtils.preCheckCast(new PackageResourceManager$disable$packageAction$1(this, r5, r6), Function1.class, "com.obric.memorydata.plugin");
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L5;
        boolean r8 = true;
    L6:
        if (r8 == false) goto L20;
        com.obric.aikernel.res.metadata.controller.a.c r3 = (com.obric.aikernel.res.metadata.controller.a.c) ZeusTransformUtils.preCheckCast(this.metadataController.b().a().get("package"), com.obric.aikernel.res.metadata.controller.a.c.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L26;
        Map<String, Map<String, com.obric.aikernel.res.metadata.data.d>> r9 = r3.a();
        if (r9 == null) goto L27;
        Collection<Map<String, com.obric.aikernel.res.metadata.data.d>> r10 = r9.values();
        if (r10 == null) goto L28;
        Iterator r11 = ((Iterable) ZeusTransformUtils.preCheckCast(r10, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L15:
        if (r11.hasNext() == false) goto L30;
        Iterator r12 = ((Iterable) ZeusTransformUtils.preCheckCast(((Map) ZeusTransformUtils.preCheckCast(r11.next(), Map.class, "com.obric.memorydata.plugin")).values(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L18:
        if (r12.hasNext() == false) goto L15;
        com.obric.aikernel.res.metadata.data.d r13 = (com.obric.aikernel.res.metadata.data.d) ZeusTransformUtils.preCheckCast(r12.next(), com.obric.aikernel.res.metadata.data.d.class, "com.obric.memorydata.plugin");
        r13.o();
        r0.invoke(r13);
        goto L18
    L30:
        return;
    L28:
        return;
    L27:
        return;
    L26:
        return;
    L20:
        com.obric.aikernel.res.metadata.data.d r14 = (com.obric.aikernel.res.metadata.data.d) ZeusTransformUtils.preCheckCast(r7.get(r6), com.obric.aikernel.res.metadata.data.d.class, "com.obric.memorydata.plugin");
        if (r14 == null) goto L29;
        r14.o();
        r0.invoke(r14);
        return;
    L29:
        return;
    L5:
        r8 = false;
        goto L6
    }

    public final void disable(String r2, String r3, String r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r2, "type");
        Intrinsics.checkNotNullParameter(r3, ActivityLifecycle.NAME);
        Intrinsics.checkNotNullParameter(r4, "version");
        if (Intrinsics.areEqual(r2, "package") == false) goto L6;
        this.metadataController.b(r3, r4, r5);
        return;
    }

    public final void enable(String r4, final String r5, final String r6) {
        Intrinsics.checkNotNullParameter(r4, "type");
        Intrinsics.checkNotNullParameter(r5, ActivityLifecycle.NAME);
        Intrinsics.checkNotNullParameter(r6, "version");
        Map<String, com.obric.aikernel.res.metadata.data.d> r7 = this.metadataController.b().a(r4, r5);
        Function1 r0 = (Function1) ZeusTransformUtils.preCheckCast(new PackageResourceManager$enable$packageAction$1(this, r5, r6), Function1.class, "com.obric.memorydata.plugin");
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L5;
        boolean r8 = true;
    L6:
        if (r8 == false) goto L20;
        com.obric.aikernel.res.metadata.controller.a.c r3 = (com.obric.aikernel.res.metadata.controller.a.c) ZeusTransformUtils.preCheckCast(this.metadataController.b().a().get("package"), com.obric.aikernel.res.metadata.controller.a.c.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L26;
        Map<String, Map<String, com.obric.aikernel.res.metadata.data.d>> r9 = r3.a();
        if (r9 == null) goto L27;
        Collection<Map<String, com.obric.aikernel.res.metadata.data.d>> r10 = r9.values();
        if (r10 == null) goto L28;
        Iterator r11 = ((Iterable) ZeusTransformUtils.preCheckCast(r10, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L15:
        if (r11.hasNext() == false) goto L30;
        Iterator r12 = ((Iterable) ZeusTransformUtils.preCheckCast(((Map) ZeusTransformUtils.preCheckCast(r11.next(), Map.class, "com.obric.memorydata.plugin")).values(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L18:
        if (r12.hasNext() == false) goto L15;
        r0.invoke((com.obric.aikernel.res.metadata.data.d) ZeusTransformUtils.preCheckCast(r12.next(), com.obric.aikernel.res.metadata.data.d.class, "com.obric.memorydata.plugin"));
        goto L18
    L30:
        return;
    L28:
        return;
    L27:
        return;
    L26:
        return;
    L20:
        com.obric.aikernel.res.metadata.data.d r13 = (com.obric.aikernel.res.metadata.data.d) ZeusTransformUtils.preCheckCast(r7.get(r6), com.obric.aikernel.res.metadata.data.d.class, "com.obric.memorydata.plugin");
        if (r13 == null) goto L29;
        r0.invoke(r13);
        return;
    L29:
        return;
    L5:
        r8 = false;
        goto L6
    }

    public final void flushPackageUsage() {
        this.metadataController.g();
    }

    public final Object getAllPackageConfigs(Continuation<? super List<com.obric.aikernel.res.metadata.config.i>> r6) {
        Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r7, C10101.class) == false) goto L7;
        C10101 r0 = (C10101) ZeusTransformUtils.preCheckCast(r7, C10101.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r8 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r8);
    L18:
        return ((n) ZeusTransformUtils.preCheckCast(r8, n.class, "com.obric.memorydata.plugin")).b();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r8);
        ar<n> r5 = this.updater;
        r0.label = 1;
        r8 = r5.a(r0);
        if (r8 != r2) goto L18;
        return r2;
    L7:
        r0 = new C10101(this, r7);
        goto L8
    }

    public final com.obric.aikernel.res.metadata.data.b getAvailPackage(String r2) {
        Intrinsics.checkNotNullParameter(r2, ActivityLifecycle.NAME);
        com.obric.aikernel.res.metadata.data.b r1 = this.metadataController.a(r2);
        if (r1 == null) goto L8;
        if (r1.d() == false) goto L8;
        return r1;
    L8:
        return null;
    }

    public final PrmContext getContext() {
        return this.context;
    }

    public final Object getDownloadInfos(Continuation<? super List<JsonObject>> r3) {
        Continuation<? super List<JsonObject>> r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
        return this.context.getDownloadCtrl$resource_manager_release().a(r4);
    }

    public final Object getDownloadingSummary(Continuation<? super JsonObject> r8) {
        Continuation r9 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r8, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r9, C10111.class) == false) goto L7;
        C10111 r0 = (C10111) ZeusTransformUtils.preCheckCast(r9, C10111.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r10 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        Ref.DoubleRef r7 = (Ref.DoubleRef) ZeusTransformUtils.preCheckCast(r0.L$1, Ref.DoubleRef.class, "com.obric.memorydata.plugin");
        Ref.IntRef r1 = (Ref.IntRef) ZeusTransformUtils.preCheckCast(r0.L$0, Ref.IntRef.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r10);
    L18:
        Iterable r11 = (Iterable) ZeusTransformUtils.preCheckCast(r10, Iterable.class, "com.obric.memorydata.plugin");
        Collection r4 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r12 = r11.iterator();
    L20:
        if (r12.hasNext() == false) goto L24;
        Object r5 = r12.next();
        if (((JsonObject) ZeusTransformUtils.preCheckCast(r5, JsonObject.class, "com.obric.memorydata.plugin")).get("downloading").getAsBoolean() == false) goto L20;
        r4.add(r5);
        goto L20
    L24:
        Iterator r13 = ((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L26:
        if (r13.hasNext() == false) goto L28;
        JsonObject r6 = (JsonObject) ZeusTransformUtils.preCheckCast(r13.next(), JsonObject.class, "com.obric.memorydata.plugin");
        r1.element++;
        r7.element += r6.get("speed").getAsDouble();
        goto L26
    L28:
        JsonObject r14 = new JsonObject();
        r14.addProperty(CommonConsts.COUNT_TYPE, (Number) ZeusTransformUtils.preCheckCast(Boxing.boxInt(r1.element), Number.class, "com.obric.memorydata.plugin"));
        r14.addProperty("speed", (Number) ZeusTransformUtils.preCheckCast(Boxing.boxDouble(r7.element), Number.class, "com.obric.memorydata.plugin"));
        return r14;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r10);
        Ref.IntRef r15 = new Ref.IntRef();
        Ref.DoubleRef r16 = new Ref.DoubleRef();
        r0.L$0 = r15;
        r0.L$1 = r16;
        r0.label = 1;
        Object r17 = getDownloadInfos(r0);
        if (r17 != r2) goto L17;
        return r2;
    L17:
        r1 = r15;
        r10 = r17;
        r7 = r16;
    L7:
        r0 = new C10111(this, r9);
        goto L8
    }

    public final c getFusionInstaller() {
        return this.fusionInstaller;
    }

    public final com.obric.aikernel.res.metadata.data.b getPackage(String r2) {
        Intrinsics.checkNotNullParameter(r2, ActivityLifecycle.NAME);
        return this.metadataController.a(r2);
    }

    public final Object getPackageConfig(String r6, Continuation<? super com.obric.aikernel.res.metadata.config.i> r7) {
        Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r7, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r8, C10121.class) == false) goto L7;
        C10121 r0 = (C10121) ZeusTransformUtils.preCheckCast(r8, C10121.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r9 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        r6 = (String) ZeusTransformUtils.preCheckCast(r0.L$0, String.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r9);
    L18:
        return ((n) ZeusTransformUtils.preCheckCast(r9, n.class, "com.obric.memorydata.plugin")).b(r6);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r9);
        ar<n> r5 = this.updater;
        r0.L$0 = r6;
        r0.label = 1;
        r9 = r5.a(r0);
        if (r9 != r2) goto L18;
        return r2;
    L7:
        r0 = new C10121(this, r8);
        goto L8
    }

    public final Collection<com.obric.aikernel.res.metadata.data.b> getPackageMap() {
        return this.metadataController.a().values();
    }

    public final Object getPackageUpdateInfo(String r6, Continuation<? super UpdateResult> r7) {
        Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r7, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r8, C10131.class) == false) goto L7;
        C10131 r0 = (C10131) ZeusTransformUtils.preCheckCast(r8, C10131.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r9 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        r6 = (String) ZeusTransformUtils.preCheckCast(r0.L$0, String.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r9);
    L18:
        return ((n) ZeusTransformUtils.preCheckCast(r9, n.class, "com.obric.memorydata.plugin")).a(r6);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r9);
        ar<n> r5 = this.updater;
        r0.L$0 = r6;
        r0.label = 1;
        r9 = r5.a(r0);
        if (r9 != r2) goto L18;
        return r2;
    L7:
        r0 = new C10131(this, r8);
        goto L8
    }

    public final Object getPackageUpdateProgress(String r6, Continuation<? super Float> r7) {
        Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r7, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r8, C10141.class) == false) goto L7;
        C10141 r0 = (C10141) ZeusTransformUtils.preCheckCast(r8, C10141.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r9 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        r6 = (String) ZeusTransformUtils.preCheckCast(r0.L$0, String.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r9);
    L18:
        return Boxing.boxFloat(((n) ZeusTransformUtils.preCheckCast(r9, n.class, "com.obric.memorydata.plugin")).c(r6));
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r9);
        ar<n> r5 = this.updater;
        r0.L$0 = r6;
        r0.label = 1;
        r9 = r5.a(r0);
        if (r9 != r2) goto L18;
        return r2;
    L7:
        r0 = new C10141(this, r8);
        goto L8
    }

    public final Function0<Set<String>> getRunningDepsGetter() {
        return this.runningDepsGetter;
    }

    public final void installFromPath(String r3) {
        Intrinsics.checkNotNullParameter(r3, "prsPath");
        this.context.runInstaller((com.obric.aikernel.res.installer.d) ZeusTransformUtils.preCheckCast(new com.obric.aikernel.res.installer.b(r3), com.obric.aikernel.res.installer.d.class, "com.obric.memorydata.plugin"));
    }

    public final void markPackageCorrupt(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, ActivityLifecycle.NAME);
        Intrinsics.checkNotNullParameter(r3, "version");
        this.metadataController.b(r2, r3);
    }

    public final Object pushDebugDistributeInfo(JsonObject r22, Continuation<? super Unit> r23) {
        Continuation r2 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r23, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r2, C10151.class) == false) goto L7;
        C10151 r4 = (C10151) ZeusTransformUtils.preCheckCast(r2, C10151.class, "com.obric.memorydata.plugin");
        if ((r4.label & Integer.MIN_VALUE) == 0) goto L7;
        r4.label -= Integer.MIN_VALUE;
    L8:
        C10151 r9 = r4;
        Object r3 = r9.result;
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r6 = r9.label;
        if (r6 == 0) goto L20;
        if (r6 == 1) goto L19;
        if (r6 == 2) goto L18;
        if (r6 == 3) goto L17;
        if (r6 != 4) goto L16;
        ResultKt.throwOnFailure(r3);
    L36:
        Unit r0 = Unit.INSTANCE;
    L38:
        return Unit.INSTANCE;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        JsonObject r1 = (JsonObject) ZeusTransformUtils.preCheckCast(r9.L$0, JsonObject.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r3);
    L33:
        n r7 = (n) ZeusTransformUtils.preCheckCast(r3, n.class, "com.obric.memorydata.plugin");
        r9.L$0 = null;
        r9.label = 4;
        if (r7.a(r1, r9) != r5) goto L36;
        return r5;
    L18:
        ResultKt.throwOnFailure(r3);
        goto L38
    L19:
        String r8 = (String) ZeusTransformUtils.preCheckCast(r9.L$0, String.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r3);
    L26:
        n r10 = (n) ZeusTransformUtils.preCheckCast(r3, n.class, "com.obric.memorydata.plugin");
        List r11 = CollectionsKt.listOf(r8);
        n.b r12 = new n.b("push_debug", 200, false, false, false, false, false, 60, null);
        r9.L$0 = null;
        r9.label = 2;
        if (n.a(r10, r11, r12, null, r9, 4, null) != r5) goto L38;
        return r5;
    L20:
        ResultKt.throwOnFailure(r3);
        JsonObject r13 = r22.getAsJsonObject("businesses");
        Set<String> r14 = r13.keySet();
        Intrinsics.checkNotNullExpressionValue(r14, "it.keySet()");
        String r15 = (String) ZeusTransformUtils.preCheckCast(CollectionsKt.first((Iterable) ZeusTransformUtils.preCheckCast(r14, Iterable.class, "com.obric.memorydata.plugin")), String.class, "com.obric.memorydata.plugin");
        boolean r16 = Intrinsics.areEqual(r13.getAsJsonObject(r15).getAsJsonObject("add").getAsJsonObject("dependency").get("py_vm").getAsString(), this.context.getConfig().getPyVmVersion());
        ar<n> r17 = this.updater;
        if (r16 == true) goto L29;
        r9.L$0 = r15;
        r9.label = 1;
        r3 = r17.a(r9);
        if (r3 != r5) goto L25;
        return r5;
    L25:
        r8 = r15;
        goto L26
    L29:
        r9.L$0 = r22;
        r9.label = 3;
        r3 = r17.a(r9);
        if (r3 != r5) goto L32;
        return r5;
    L32:
        r1 = r22;
    L7:
        r4 = new C10151(this, r2);
        goto L8
    }

    public final ar<Unit> refreshAllPackageState() {
        return this.metadataController.d();
    }

    public final void refreshPackageState(String r2) {
        Intrinsics.checkNotNullParameter(r2, ActivityLifecycle.NAME);
        this.metadataController.c(r2);
    }

    public final void registerPackageObserver(com.obric.aikernel.res.metadata.a r3) {
        com.obric.aikernel.res.metadata.a r4 = (com.obric.aikernel.res.metadata.a) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.aikernel.res.metadata.a.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "observer");
        this.packagesListener.a(r4);
    }

    public final Object resumeBlockedUpdateTasksIfNeed(String r6, Continuation<? super Unit> r7) {
        Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r7, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r8, C10161.class) == false) goto L7;
        C10161 r0 = (C10161) ZeusTransformUtils.preCheckCast(r8, C10161.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r9 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        r6 = (String) ZeusTransformUtils.preCheckCast(r0.L$0, String.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r9);
    L17:
        ((n) ZeusTransformUtils.preCheckCast(r9, n.class, "com.obric.memorydata.plugin")).d(r6);
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r9);
        ar<n> r5 = this.updater;
        r0.L$0 = r6;
        r0.label = 1;
        r9 = r5.a(r0);
        if (r9 != r2) goto L17;
        return r2;
    L7:
        r0 = new C10161(this, r8);
        goto L8
    }

    public final void setRunningDepsGetter(Function0<? extends Set<String>> r3) {
        Function0<? extends Set<String>> r4 = (Function0) ZeusTransformUtils.wrapperContextForParams(r3, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "<set-?>");
        this.runningDepsGetter = r4;
    }

    public final void uninstall(String r2, String r3, String r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r2, "type");
        Intrinsics.checkNotNullParameter(r3, ActivityLifecycle.NAME);
        Intrinsics.checkNotNullParameter(r4, "version");
        if (Intrinsics.areEqual(r2, "package") == false) goto L6;
        this.metadataController.c(r3, r4, r5);
        return;
    }

    public final void unregisterPackageObserver(com.obric.aikernel.res.metadata.a r3) {
        com.obric.aikernel.res.metadata.a r4 = (com.obric.aikernel.res.metadata.a) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.aikernel.res.metadata.a.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "observer");
        this.packagesListener.b(r4);
    }

    public final Object updateAll(String r27, boolean r28, Continuation<? super Map<String, UpdateResult>> r29) {
        String r1 = r27;
        boolean r2 = r28;
        Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r29, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r4, C10171.class) == false) goto L7;
        C10171 r6 = (C10171) ZeusTransformUtils.preCheckCast(r4, C10171.class, "com.obric.memorydata.plugin");
        if ((r6.label & Integer.MIN_VALUE) == 0) goto L7;
        r6.label -= Integer.MIN_VALUE;
    L8:
        C10171 r11 = r6;
        Object r5 = r11.result;
        Object r7 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r8 = r11.label;
        if (r8 == 0) goto L26;
        if (r8 == 1) goto L19;
        if (r8 != 2) goto L18;
        boolean r3 = r11.Z$0;
        PackageResourceManager r0 = (PackageResourceManager) ZeusTransformUtils.preCheckCast(r11.L$1, PackageResourceManager.class, "com.obric.memorydata.plugin");
        String r9 = (String) ZeusTransformUtils.preCheckCast(r11.L$0, String.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r5);     // Catch: Throwable -> L15
        Object r10 = r5;
        boolean r12 = true;
        String r13 = TAG;
        String r15 = " background=";
        r2 = r3;
        r1 = r9;
    L48:
        Map<String, UpdateResult> r14 = (Map) ZeusTransformUtils.preCheckCast(r10, Map.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L54
        com.obric.aikernel.runtime.utils.d r16 = com.obric.aikernel.runtime.utils.d.f6216a;     // Catch: Throwable -> L54
        StringBuilder r17 = new StringBuilder().append("updateAll end caller=").append(r1).append(r15);     // Catch: Throwable -> L54
        if (r2 == true) goto L52;
        r12 = false;
    L52:
        r16.b(r13, r17.append(r12).append(' ').append(r0.summarizeUpdateResults(r14)).toString());     // Catch: Throwable -> L54
        Object r18 = Result.m1421constructorimpl((Map) ZeusTransformUtils.preCheckCast(r10, Map.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L54
    L59:
        Throwable r19 = Result.m1424exceptionOrNullimpl(r18);
        if (r19 == null) goto L62;
        com.obric.aikernel.runtime.utils.d.f6216a.c(r13, "updateAll failed caller=" + r1 + r15 + r2 + ' ' + ExceptionsKt.stackTraceToString(r19));
    L62:
        ResultKt.throwOnFailure(r18);
        return r18;
    L54:
        Throwable th = th;
    L58:
        Result.Companion r20 = Result.Companion;
        r18 = Result.m1421constructorimpl(ResultKt.createFailure(th));
    L15:
        th = th;
        r13 = TAG;
        r15 = " background=";
        r2 = r3;
        r1 = r9;
        goto L58
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        boolean r21 = r11.Z$0;
        r0 = (PackageResourceManager) ZeusTransformUtils.preCheckCast(r11.L$2, PackageResourceManager.class, "com.obric.memorydata.plugin");
        List<String> r22 = (List) ZeusTransformUtils.preCheckCast(r11.L$1, List.class, "com.obric.memorydata.plugin");
        String r23 = (String) ZeusTransformUtils.preCheckCast(r11.L$0, String.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r5);     // Catch: Throwable -> L23
        List<String> r25 = r22;
        r2 = r21;
        r1 = r23;
    L22:
        List<String> r24 = r25;
        n r26 = (n) ZeusTransformUtils.preCheckCast(r5, n.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L56
        com.obric.aikernel.runtime.utils.d r30 = com.obric.aikernel.runtime.utils.d.f6216a;     // Catch: Throwable -> L56
        StringBuilder r31 = new StringBuilder().append("updateAll enter updater.update caller=").append(r1).append(" background=");     // Catch: Throwable -> L56
        if (r2 == false) goto L38;
        boolean r110 = true;
    L39:
        r30.b(TAG, r31.append(r110).toString());     // Catch: Throwable -> L56
        int r111 = 0;
        boolean r112 = true;
        boolean r113 = true;
        boolean r210 = false;
        boolean r211 = false;
        if (r2 == false) goto L42;
        boolean r212 = true;
    L43:
        n.b r32 = new n.b(r1, r111, r112, r113, r210, r211, r212, 50, null);     // Catch: Throwable -> L56
        r11.L$0 = r1;     // Catch: Throwable -> L56
        r11.L$1 = r0;     // Catch: Throwable -> L56
        r11.L$2 = null;     // Catch: Throwable -> L56
        r11.Z$0 = r2;     // Catch: Throwable -> L56
        r11.label = 2;     // Catch: Throwable -> L56
        r12 = true;
        r13 = TAG;
        r15 = " background=";
        r10 = n.a(r26, r24, r32, null, r11, 4, null);     // Catch: Throwable -> L54
        if (r10 != r7) goto L48;
        return r7;
    L56:
        th = th;
    L25:
        r13 = TAG;
        r15 = " background=";
        goto L58
    L42:
        r212 = false;
        goto L43
    L38:
        r110 = false;
    L23:
        th = th;
        r2 = r21;
        r1 = r23;
        goto L25
    L26:
        ResultKt.throwOnFailure(r5);
        List<String> r33 = this.metadataController.c();
        com.obric.aikernel.runtime.utils.d.f6216a.b(TAG, "updateAll start caller=" + r1 + " background=" + r2 + " packageCount=" + r33.size() + " packages=" + CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(r33, Iterable.class, "com.obric.memorydata.plugin"), null, null, null, 10, null, null, 55, null));
        Result.Companion r34 = Result.Companion;     // Catch: Throwable -> L56
        r0 = (PackageResourceManager) ZeusTransformUtils.preCheckCast(this, PackageResourceManager.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L56
        com.obric.aikernel.runtime.utils.d r35 = com.obric.aikernel.runtime.utils.d.f6216a;     // Catch: Throwable -> L56
        StringBuilder r36 = new StringBuilder().append("updateAll awaiting updater caller=").append(r1).append(" background=");     // Catch: Throwable -> L56
        if (r2 == false) goto L30;
        boolean r37 = true;
    L31:
        r35.b(TAG, r36.append(r37).toString());     // Catch: Throwable -> L56
        ar<n> r38 = r0.updater;     // Catch: Throwable -> L56
        r11.L$0 = r1;     // Catch: Throwable -> L56
        r11.L$1 = r33;     // Catch: Throwable -> L56
        r11.L$2 = r0;     // Catch: Throwable -> L56
        r11.Z$0 = r2;     // Catch: Throwable -> L56
        r11.label = 1;     // Catch: Throwable -> L56
        Object r39 = r38.a(r11);     // Catch: Throwable -> L56
        if (r39 != r7) goto L34;
        return r7;
    L34:
        r25 = r33;
        r5 = r39;
        goto L22
    L30:
        r37 = false;
    L7:
        r6 = new C10171(this, r4);
        goto L8
    }

    public final Object updateByForeground(String r22, String r23, boolean r24, String r25, Continuation<? super com.obric.aikernel.res.metadata.data.b> r26) {
        PackageResourceManager r0 = this;
        Continuation r2 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r26, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r2, C10181.class) == false) goto L7;
        C10181 r4 = (C10181) ZeusTransformUtils.preCheckCast(r2, C10181.class, "com.obric.memorydata.plugin");
        if ((r4.label & Integer.MIN_VALUE) == 0) goto L7;
        r4.label -= Integer.MIN_VALUE;
    L8:
        Object r3 = r4.result;
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r6 = r4.label;
        if (r6 == 0) goto L16;
        if (r6 == 1) goto L15;
        if (r6 != 2) goto L14;
        String r1 = (String) ZeusTransformUtils.preCheckCast(r4.L$1, String.class, "com.obric.memorydata.plugin");
        PackageResourceManager r7 = (PackageResourceManager) ZeusTransformUtils.preCheckCast(r4.L$0, PackageResourceManager.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r3);
    L25:
        return r7.getPackage(r1);
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        boolean r8 = r4.Z$0;
        String r9 = (String) ZeusTransformUtils.preCheckCast(r4.L$3, String.class, "com.obric.memorydata.plugin");
        String r10 = (String) ZeusTransformUtils.preCheckCast(r4.L$2, String.class, "com.obric.memorydata.plugin");
        String r11 = (String) ZeusTransformUtils.preCheckCast(r4.L$1, String.class, "com.obric.memorydata.plugin");
        PackageResourceManager r12 = (PackageResourceManager) ZeusTransformUtils.preCheckCast(r4.L$0, PackageResourceManager.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r3);
        boolean r13 = r8;
        r0 = r12;
        Object r14 = r3;
        String r15 = r11;
        String r16 = r10;
    L20:
        n r17 = (n) ZeusTransformUtils.preCheckCast(r14, n.class, "com.obric.memorydata.plugin");
        List<String> r18 = CollectionsKt.listOf(r15);
        n.b r19 = new n.b(r16, 100, false, r13, false, false, false, 52, null);
        r4.L$0 = r0;
        r4.L$1 = r15;
        r4.L$2 = null;
        r4.L$3 = null;
        r4.label = 2;
        if (r17.update(r18, r19, r9, r4) != r5) goto L23;
        return r5;
    L23:
        r7 = r0;
        r1 = r15;
        goto L25
    L16:
        ResultKt.throwOnFailure(r3);
        ar<n> r20 = r0.updater;
        r4.L$0 = r0;
        r15 = r22;
        r4.L$1 = r15;
        r4.L$2 = r23;
        r4.L$3 = r25;
        r4.Z$0 = r24;
        r4.label = 1;
        r14 = r20.a(r4);
        if (r14 != r5) goto L19;
        return r5;
    L19:
        r13 = r24;
        r16 = r23;
        r9 = r25;
    L7:
        r4 = new C10181(r0, r2);
        goto L8
    }

    public final Object updatePackage(String r22, String r23, boolean r24, boolean r25, String r26, Continuation<? super com.obric.aikernel.res.metadata.data.b> r27) {
        PackageResourceManager r0 = this;
        Continuation r2 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r27, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r2, C10191.class) == false) goto L7;
        C10191 r4 = (C10191) ZeusTransformUtils.preCheckCast(r2, C10191.class, "com.obric.memorydata.plugin");
        if ((r4.label & Integer.MIN_VALUE) == 0) goto L7;
        r4.label -= Integer.MIN_VALUE;
    L8:
        Object r3 = r4.result;
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r6 = r4.label;
        if (r6 == 0) goto L16;
        if (r6 == 1) goto L15;
        if (r6 != 2) goto L14;
        String r1 = (String) ZeusTransformUtils.preCheckCast(r4.L$1, String.class, "com.obric.memorydata.plugin");
        PackageResourceManager r7 = (PackageResourceManager) ZeusTransformUtils.preCheckCast(r4.L$0, PackageResourceManager.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r3);
    L25:
        return r7.getPackage(r1);
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        boolean r8 = r4.Z$1;
        boolean r9 = r4.Z$0;
        String r10 = (String) ZeusTransformUtils.preCheckCast(r4.L$3, String.class, "com.obric.memorydata.plugin");
        String r11 = (String) ZeusTransformUtils.preCheckCast(r4.L$2, String.class, "com.obric.memorydata.plugin");
        String r12 = (String) ZeusTransformUtils.preCheckCast(r4.L$1, String.class, "com.obric.memorydata.plugin");
        PackageResourceManager r13 = (PackageResourceManager) ZeusTransformUtils.preCheckCast(r4.L$0, PackageResourceManager.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r3);
        boolean r15 = r8;
        r0 = r13;
        boolean r18 = r9;
        String r14 = r11;
        String r16 = r10;
    L20:
        n r17 = (n) ZeusTransformUtils.preCheckCast(r3, n.class, "com.obric.memorydata.plugin");
        List<String> r19 = CollectionsKt.listOf(r12);
        n.b r20 = new n.b(r14, 100, false, r15, false, false, r18, 52, null);
        r4.L$0 = r0;
        r4.L$1 = r12;
        r4.L$2 = null;
        r4.L$3 = null;
        r4.label = 2;
        if (r17.update(r19, r20, r16, r4) != r5) goto L23;
        return r5;
    L23:
        r7 = r0;
        r1 = r12;
        goto L25
    L16:
        ResultKt.throwOnFailure(r3);
        ar<n> r21 = r0.updater;
        r4.L$0 = r0;
        r4.L$1 = r22;
        r4.L$2 = r23;
        r16 = r26;
        r4.L$3 = r16;
        r4.Z$0 = r24;
        r4.Z$1 = r25;
        r4.label = 1;
        Object r28 = r21.a(r4);
        if (r28 != r5) goto L19;
        return r5;
    L19:
        r14 = r23;
        r18 = r24;
        r15 = r25;
        r12 = r22;
        r3 = r28;
    L7:
        r4 = new C10191(r0, r2);
        goto L8
    }

    public final Object waitLocalPackageInit(Continuation<? super Unit> r3) {
        Continuation<? super n> r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
        Object r2 = this.updater.a(r4);
        if (r2 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r2;
    L6:
        return Unit.INSTANCE;
    }
}
