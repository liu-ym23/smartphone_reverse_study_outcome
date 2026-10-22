package com.obric.aikernel.phx.sdk.api;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.RemoteException;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.aikernel.a;
import com.obric.aikernel.b;
import com.obric.aikernel.core.data.IdlKeys;
import com.obric.aikernel.core.log.AIKLog;
import com.obric.aikernel.core.log.ILog;
import com.obric.aikernel.phx.compat.ParamsCompat;
import com.obric.aikernel.phx.core.api.AbsApi;
import com.obric.aikernel.phx.core.api.CloudBizApi;
import com.obric.aikernel.phx.core.api.ScriptBizApi;
import com.obric.aikernel.phx.core.conn.BinderMonitor;
import com.obric.aikernel.phx.core.conn.ServiceConnector;
import com.obric.aikernel.phx.sdk.IAIKernelManager;
import com.obric.aikernel.sdk.AIKernelConfig;
import com.obric.aikernel.sdk.AIKernelException;
import com.obric.aikernel.sdk.config.RequestParams;
import com.obric.aikernel.sdk.data.PackageResource;
import com.obric.aikernel.sdk.ext.BundleExtKt;
import com.obric.aikernel.sdk.phx.BuildConfig;
import com.obric.memorydata.middleware.impl.bdtracker.TrackerImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Closeable;
import java.util.Collection;
import java.util.List;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.al;
import kotlinx.coroutines.am;
import kotlinx.coroutines.ar;
import kotlinx.coroutines.ba;
import kotlinx.coroutines.bx;
import kotlinx.coroutines.cu;
import kotlinx.coroutines.da;
import kotlinx.coroutines.i;
import kotlinx.coroutines.n;
import kotlinx.coroutines.o;
import kotlinx.coroutines.w;
import kotlinx.coroutines.y;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 O2\u00020\u0001:\u0001OB\u0007\b\u0016¢\u0006\u0002\u0010\u0002B'\b\u0010\u0012\u001e\u0010\u0003\u001a\u001a\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0004¢\u0006\u0002\u0010\tJ\u0019\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u001cJ\u001d\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\b\u0002\u0010\u001f\u001a\u00020 H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010!J\u001f\u0010\"\u001a\u0004\u0018\u00010#2\b\b\u0002\u0010\u001f\u001a\u00020 H\u0080@ø\u0001\u0000¢\u0006\u0004\b$\u0010!J2\u0010%\u001a\b\u0012\u0004\u0012\u00020'0&2\u0006\u0010(\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u001bH\u0096@ø\u0001\u0001ø\u0001\u0002ø\u0001\u0000ø\u0001\u0000¢\u0006\u0004\b)\u0010*J>\u0010+\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020'0,0&2\f\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00150,2\u0006\u0010\u001a\u001a\u00020\u001bH\u0082@ø\u0001\u0001ø\u0001\u0002ø\u0001\u0000ø\u0001\u0000¢\u0006\u0004\b.\u0010/J2\u00100\u001a\b\u0012\u0004\u0012\u00020'0&2\u0006\u0010(\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u001bH\u0082@ø\u0001\u0001ø\u0001\u0002ø\u0001\u0000ø\u0001\u0000¢\u0006\u0004\b1\u0010*J\u001a\u00102\u001a\u00020\u00192\u0006\u00103\u001a\u00020\u00062\n\b\u0002\u00104\u001a\u0004\u0018\u000105J+\u00106\u001a\u0004\u0018\u0001072\u0006\u00108\u001a\u00020\u00152\u0006\u00109\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u001bH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010:J\u0010\u0010;\u001a\u00020 2\u0006\u0010<\u001a\u00020 H\u0002J2\u0010=\u001a\b\u0012\u0004\u0012\u00020'0&2\u0006\u0010(\u001a\u00020'2\u0006\u0010\u001a\u001a\u00020\u001bH\u0096@ø\u0001\u0001ø\u0001\u0002ø\u0001\u0000ø\u0001\u0000¢\u0006\u0004\b>\u0010?J2\u0010@\u001a\b\u0012\u0004\u0012\u00020'0&2\u0006\u0010A\u001a\u00020'2\u0006\u0010\u001a\u001a\u00020\u001bH\u0082@ø\u0001\u0001ø\u0001\u0002ø\u0001\u0000ø\u0001\u0000¢\u0006\u0004\bB\u0010?J>\u0010C\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020'0,0&2\f\u0010D\u001a\b\u0012\u0004\u0012\u00020'0,2\u0006\u0010\u001a\u001a\u00020\u001bH\u0082@ø\u0001\u0001ø\u0001\u0002ø\u0001\u0000ø\u0001\u0000¢\u0006\u0004\bE\u0010/J\u001b\u0010F\u001a\u0004\u0018\u00010\b2\u0006\u0010\u001f\u001a\u00020 H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010!JM\u0010G\u001a\u0004\u0018\u0001HH\"\u0004\b\u0000\u0010H2\u0006\u0010\u001a\u001a\u00020\u001b2\n\b\u0002\u0010I\u001a\u0004\u0018\u00010\u001e2\u001e\u0010J\u001a\u001a\b\u0001\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u0001HH0L\u0012\u0006\u0012\u0004\u0018\u00010M0KH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010NR\u000e\u0010\n\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R&\u0010\u0003\u001a\u001a\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000f\n\u0002\b\u0019\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006P"}, d2 = {"Lcom/obric/aikernel/phx/sdk/api/AIKernelApi;", "Lcom/obric/aikernel/phx/sdk/IAIKernelManager;", "()V", "serviceConnectorFactory", "Lkotlin/Function3;", "Landroid/content/Context;", "Lcom/obric/aikernel/sdk/AIKernelConfig;", "Landroid/content/ComponentName;", "Lcom/obric/aikernel/phx/core/conn/ServiceConnector;", "(Lkotlin/jvm/functions/Function3;)V", "connector", "connectorReady", "Lkotlinx/coroutines/CompletableDeferred;", "hasConnectedOnce", "", "legacyArch", "getLegacyArch", "()Z", "setLegacyArch", "(Z)V", "servicePackageName", "", "transactScope", "Lkotlinx/coroutines/CoroutineScope;", "clearAIKernelData", "", TrackerImpl.PARAMS, "Lcom/obric/aikernel/sdk/config/RequestParams;", "(Lcom/obric/aikernel/sdk/config/RequestParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getBinder", "Lcom/obric/aikernel/AIKBinder;", "timeoutMs", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getMainProcessIpcBinding", "Lcom/obric/aikernel/phx/core/conn/ServiceConnector$MainProcessIpcBinding;", "getMainProcessIpcBinding$sdk_release", "getPackage", "Lkotlin/Result;", "Lcom/obric/aikernel/sdk/data/PackageResource;", "business", "getPackage-0E7RQCE", "(Ljava/lang/String;Lcom/obric/aikernel/sdk/config/RequestParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getPackageInfos", "", "names", "getPackageInfos-0E7RQCE", "(Ljava/util/List;Lcom/obric/aikernel/sdk/config/RequestParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getPackageResource", "getPackageResource-0E7RQCE", CommonConsts.APM_INNER_EVENT_COST_INIT, "config", "logger", "Lcom/obric/aikernel/core/log/ILog;", "loadPackage", "Lcom/obric/aikernel/phx/sdk/api/IBaseModel;", ActivityLifecycle.NAME, "useCloud", "(Ljava/lang/String;ZLcom/obric/aikernel/sdk/config/RequestParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "remainMs", "deadlineMs", "updatePackage", "updatePackage-0E7RQCE", "(Lcom/obric/aikernel/sdk/data/PackageResource;Lcom/obric/aikernel/sdk/config/RequestParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updatePackageInner", "bizPackage", "updatePackageInner-0E7RQCE", "updatePackages", "bizs", "updatePackages-0E7RQCE", "waitForConnector", "wrapApiCall", ExifInterface.GPS_DIRECTION_TRUE, "targetBinder", "block", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "(Lcom/obric/aikernel/sdk/config/RequestParams;Lcom/obric/aikernel/AIKBinder;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class AIKernelApi implements IAIKernelManager {
    public static final Companion Companion = null;
    private static final long FIRST_CONNECT_TIMEOUT = 15000;
    public static final String TAG = "AIKernelApi";
    private ServiceConnector connector;
    private final w<ServiceConnector> connectorReady;
    private volatile boolean hasConnectedOnce;
    private boolean legacyArch;
    private final Function3<Context, AIKernelConfig, ComponentName, ServiceConnector> serviceConnectorFactory;
    private volatile String servicePackageName;
    private final al transactScope;

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0002\u001a\u001bB\u0007\b\u0002¢\u0006\u0002\u0010\u0002JF\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\b2\u0006\u0010\u000b\u001a\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\t2\u0006\u0010\u000e\u001a\u00020\u000fH\u0086@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002ø\u0001\u0002¢\u0006\u0004\b\u0010\u0010\u0011J-\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000fH\u0080@ø\u0001\u0002¢\u0006\u0004\b\u0015\u0010\u0016JF\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\b2\u0006\u0010\u000b\u001a\u00020\f2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000e\u001a\u00020\u000fH\u0086@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002ø\u0001\u0002¢\u0006\u0004\b\u0019\u0010\u0011R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000\u0082\u0002\u000f\n\u0002\b!\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u001c"}, d2 = {"Lcom/obric/aikernel/phx/sdk/api/AIKernelApi$Companion;", "", "()V", "FIRST_CONNECT_TIMEOUT", "", "TAG", "", "getPackageInfos", "Lkotlin/Result;", "", "Lcom/obric/aikernel/sdk/data/PackageResource;", "binder", "Lcom/obric/aikernel/AIKBinder;", "names", TrackerImpl.PARAMS, "Lcom/obric/aikernel/sdk/config/RequestParams;", "getPackageInfos-BWLJW6A", "(Lcom/obric/aikernel/AIKBinder;Ljava/util/List;Lcom/obric/aikernel/sdk/config/RequestParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadPackage", "Lcom/obric/aikernel/phx/sdk/api/AIKernelApi$Companion$LoadedPackage;", "biz", "loadPackage$sdk_release", "(Lcom/obric/aikernel/AIKBinder;Ljava/lang/String;Lcom/obric/aikernel/sdk/config/RequestParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updatePackages", "bizs", "updatePackages-BWLJW6A", "ExecutionBinderSource", "LoadedPackage", "sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0080\u0001\u0018\u0000 \u00052\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0005B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0006"}, d2 = {"Lcom/obric/aikernel/phx/sdk/api/AIKernelApi$Companion$ExecutionBinderSource;", "", "(Ljava/lang/String;I)V", "CHILD_PROCESS", "IDLE_UNBIND_UNSUPPORTED", "Companion", "sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static final enum ExecutionBinderSource extends Enum<ExecutionBinderSource> {
            private static final /* synthetic */ ExecutionBinderSource[] $VALUES = null;
            public static final ExecutionBinderSource CHILD_PROCESS = null;
            public static final C0253Companion Companion = null;
            public static final ExecutionBinderSource IDLE_UNBIND_UNSUPPORTED = null;

            /* JADX INFO: renamed from: com.obric.aikernel.phx.sdk.api.AIKernelApi$Companion$ExecutionBinderSource$Companion, reason: collision with other inner class name */
            @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/aikernel/phx/sdk/api/AIKernelApi$Companion$ExecutionBinderSource$Companion;", "", "()V", "fromTargetProcess", "Lcom/obric/aikernel/phx/sdk/api/AIKernelApi$Companion$ExecutionBinderSource;", "targetProcess", "", "sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
            public static final class C0253Companion {
                private C0253Companion() {
                }

                public /* synthetic */ C0253Companion(DefaultConstructorMarker r1) {
                    this();
                }

                public final ExecutionBinderSource fromTargetProcess(String r5) {
                    boolean r1 = true;
                    if (r5 != null) goto L5;
                L7:
                    boolean r3 = false;
                L8:
                    if (r3 == true) goto L18;
                    if (r5 != null) goto L11;
                L13:
                    r1 = false;
                L14:
                    if (r1 == true) goto L18;
                    return ExecutionBinderSource.IDLE_UNBIND_UNSUPPORTED;
                L11:
                    if (StringsKt.endsWith$default(r5, ":llm", false, 2, null) != true) goto L13;
                L18:
                    return ExecutionBinderSource.CHILD_PROCESS;
                L5:
                    if (StringsKt.endsWith$default(r5, ":infer", false, 2, null) != true) goto L7;
                    r3 = true;
                    goto L8
                }
            }

            private static final /* synthetic */ ExecutionBinderSource[] $values() {
                return new ExecutionBinderSource[]{CHILD_PROCESS, IDLE_UNBIND_UNSUPPORTED};
            }

            static {
                CHILD_PROCESS = new ExecutionBinderSource("CHILD_PROCESS", 0);
                IDLE_UNBIND_UNSUPPORTED = new ExecutionBinderSource("IDLE_UNBIND_UNSUPPORTED", 1);
                $VALUES = $values();
                Companion = new C0253Companion(null);
            }

            private ExecutionBinderSource(String r1, int r2) {
                super(r1, r2);
            }

            public static ExecutionBinderSource valueOf(String r2) {
                return (ExecutionBinderSource) ZeusTransformUtils.preCheckCast(Enum.valueOf(ExecutionBinderSource.class, r2), ExecutionBinderSource.class, "com.obric.memorydata.plugin");
            }

            public static ExecutionBinderSource[] values() {
                return (ExecutionBinderSource[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), ExecutionBinderSource[].class, "com.obric.memorydata.plugin");
            }
        }

        @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0018"}, d2 = {"Lcom/obric/aikernel/phx/sdk/api/AIKernelApi$Companion$LoadedPackage;", "", "binder", "Lcom/obric/aikernel/AIKBinder;", "targetProcess", "", "(Lcom/obric/aikernel/AIKBinder;Ljava/lang/String;)V", "getBinder", "()Lcom/obric/aikernel/AIKBinder;", "executionBinderSource", "Lcom/obric/aikernel/phx/sdk/api/AIKernelApi$Companion$ExecutionBinderSource;", "getExecutionBinderSource", "()Lcom/obric/aikernel/phx/sdk/api/AIKernelApi$Companion$ExecutionBinderSource;", "getTargetProcess", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static final class LoadedPackage {
            private final a binder;
            private final ExecutionBinderSource executionBinderSource;
            private final String targetProcess;

            public LoadedPackage(a r3, String r4) {
                a r5 = (a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.memorydata.plugin");
                Intrinsics.checkNotNullParameter(r5, "binder");
                this.binder = r5;
                this.targetProcess = r4;
                this.executionBinderSource = ExecutionBinderSource.Companion.fromTargetProcess(r4);
            }

            public static /* synthetic */ LoadedPackage copy$default(LoadedPackage r1, a r2, String r3, int r4, Object r5) {
                a r6 = (a) ZeusTransformUtils.wrapperContextForParams(r2, a.class, "com.obric.memorydata.plugin");
                if ((r4 & 1) == 0) goto L6;
                r6 = r1.binder;
            L6:
                if ((r4 & 2) == 0) goto L9;
                r3 = r1.targetProcess;
            L9:
                return r1.copy(r6, r3);
            }

            public final a component1() {
                return this.binder;
            }

            public final String component2() {
                return this.targetProcess;
            }

            public final LoadedPackage copy(a r2, String r3) {
                a r1 = (a) ZeusTransformUtils.wrapperContextForParams(r2, a.class, "com.obric.memorydata.plugin");
                Intrinsics.checkNotNullParameter(r1, "binder");
                return new LoadedPackage(r1, r3);
            }

            public boolean equals(Object r5) {
                if (this != r5) goto L6;
                return true;
            L6:
                if (ZeusTransformUtils.instanceOf(r5, LoadedPackage.class) == true) goto L8;
                return false;
            L8:
                LoadedPackage r6 = (LoadedPackage) ZeusTransformUtils.preCheckCast(r5, LoadedPackage.class, "com.obric.memorydata.plugin");
                if (Intrinsics.areEqual(this.binder, r6.binder) == true) goto L12;
                return false;
            L12:
                if (Intrinsics.areEqual(this.targetProcess, r6.targetProcess) == true) goto L14;
                return false;
            L14:
                return true;
            }

            public final a getBinder() {
                return this.binder;
            }

            public final ExecutionBinderSource getExecutionBinderSource() {
                return this.executionBinderSource;
            }

            public final String getTargetProcess() {
                return this.targetProcess;
            }

            public int hashCode() {
                int r0 = this.binder.hashCode() * 31;
                String r1 = this.targetProcess;
                if (r1 != null) goto L5;
                int r2 = 0;
            L7:
                return r0 + r2;
            L5:
                r2 = r1.hashCode();
                goto L7
            }

            public String toString() {
                return "LoadedPackage(binder=" + this.binder + ", targetProcess=" + this.targetProcess + ')';
            }
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v13 */
        /* JADX WARN: Type inference failed for: r2v14, types: [kotlin.jvm.internal.Ref$ObjectRef] */
        /* JADX WARN: Type inference failed for: r2v18 */
        /* JADX WARN: Type inference failed for: r2v23 */
        /* JADX WARN: Type inference failed for: r2v24 */
        /* JADX WARN: Type inference failed for: r2v25 */
        /* JADX WARN: Type inference failed for: r2v3, types: [java.lang.Object, java.util.List] */
        /* JADX WARN: Type inference failed for: r2v4 */
        /* JADX WARN: Type inference failed for: r2v5, types: [kotlin.jvm.internal.Ref$ObjectRef] */
        /* JADX WARN: Type inference failed for: r2v8 */
        /* JADX WARN: Type inference failed for: r2v9, types: [java.lang.Object, java.util.List] */
        /* JADX WARN: Type inference failed for: r3v12, types: [T, kotlinx.coroutines.bx] */
        /* JADX INFO: renamed from: getPackageInfos-BWLJW6A, reason: not valid java name */
        public final Object m200getPackageInfosBWLJW6A(a r26, List<String> r27, RequestParams r28, Continuation<? super Result<? extends List<PackageResource>>> r29) {
            a r0 = (a) ZeusTransformUtils.wrapperContextForParams(r26, a.class, "com.obric.memorydata.plugin");
            ?? r2 = (List) ZeusTransformUtils.wrapperContextForParams(r27, List.class, "com.obric.memorydata.plugin");
            Continuation r3 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r29, Continuation.class, "com.obric.memorydata.plugin");
            if (ZeusTransformUtils.instanceOf(r3, AIKernelApi$Companion$getPackageInfos$1.class) == false) goto L7;
            AIKernelApi$Companion$getPackageInfos$1 r4 = (AIKernelApi$Companion$getPackageInfos$1) ZeusTransformUtils.preCheckCast(r3, AIKernelApi$Companion$getPackageInfos$1.class, "com.obric.memorydata.plugin");
            if ((r4.label & Integer.MIN_VALUE) == 0) goto L7;
            r4.label -= Integer.MIN_VALUE;
        L8:
            Object r5 = r4.result;
            Object r6 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r7 = r4.label;
            if (r7 == 0) goto L22;
            if (r7 == 1) goto L17;
            if (r7 != 2) goto L16;
            Bundle r1 = (Bundle) ZeusTransformUtils.preCheckCast(r4.L$4, Bundle.class, "com.obric.memorydata.plugin");
            Ref.ObjectRef r8 = (Ref.ObjectRef) ZeusTransformUtils.preCheckCast(r4.L$3, Ref.ObjectRef.class, "com.obric.memorydata.plugin");
            CoroutineContext r9 = (CoroutineContext) ZeusTransformUtils.preCheckCast(r4.L$2, CoroutineContext.class, "com.obric.memorydata.plugin");
            List r10 = (List) ZeusTransformUtils.preCheckCast(r4.L$1, List.class, "com.obric.memorydata.plugin");
            a r11 = (a) ZeusTransformUtils.preCheckCast(r4.L$0, a.class, "com.obric.memorydata.plugin");
            ResultKt.throwOnFailure(r5);     // Catch: Throwable -> L20
            r2 = r8;
        L32:
            Object r12 = ((Result) ZeusTransformUtils.preCheckCast(r5, Result.class, "com.obric.memorydata.plugin")).m1430unboximpl();     // Catch: Throwable -> L20
            bx r13 = (bx) ZeusTransformUtils.preCheckCast(r2.element, bx.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L20
            if (r13 == null) goto L35;
            bx.a.a(r13, null, 1, null);     // Catch: Throwable -> L20
        L35:
            AIKLog r14 = AIKLog.INSTANCE;     // Catch: Throwable -> L20
            StringBuilder r15 = new StringBuilder().append("[SDK] end getPackageInfos: ");     // Catch: Throwable -> L20
            if (Result.m1427isFailureimpl(r12) == false) goto L38;
            Object r16 = null;
        L39:
            r14.i(AIKernelApi.TAG, r15.append(r16).append(' ').append(Result.m1424exceptionOrNullimpl(r12)).toString());     // Catch: Throwable -> L20
            return ((Result) ZeusTransformUtils.preCheckCast(r5, Result.class, "com.obric.memorydata.plugin")).m1430unboximpl();
        L38:
            r16 = r12;
            goto L39
        L16:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L17:
            Ref.ObjectRef r17 = (Ref.ObjectRef) ZeusTransformUtils.preCheckCast(r4.L$3, Ref.ObjectRef.class, "com.obric.memorydata.plugin");
            CoroutineContext r18 = (CoroutineContext) ZeusTransformUtils.preCheckCast(r4.L$2, CoroutineContext.class, "com.obric.memorydata.plugin");
            List r19 = (List) ZeusTransformUtils.preCheckCast(r4.L$1, List.class, "com.obric.memorydata.plugin");
            a r110 = (a) ZeusTransformUtils.preCheckCast(r4.L$0, a.class, "com.obric.memorydata.plugin");
            ResultKt.throwOnFailure(r5);     // Catch: Throwable -> L20
            CoroutineContext r20 = r18;
            r0 = r110;
            Object r111 = r5;
            Ref.ObjectRef r21 = r17;
            final ?? r22 = r19;
        L26:
            Bundle r112 = BundleExtKt.commonParams$default((Bundle) ZeusTransformUtils.preCheckCast(r111, Bundle.class, "com.obric.memorydata.plugin"), null, IdlKeys.Method_GetPackageRes, IdlKeys.Call_Type_CallBiz, null, AIKernelApi.TAG, "getPackageInfos", null, false, 201, null);     // Catch: Throwable -> L41
            r112.putStringArray(IdlKeys.Args_Pkgs, (String[]) ZeusTransformUtils.preCheckCast(((Collection) ZeusTransformUtils.preCheckCast(r22, Collection.class, "com.obric.memorydata.plugin")).toArray(new String[0]), String[].class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L41
            r4.L$0 = r0;     // Catch: Throwable -> L41
            r4.L$1 = r22;     // Catch: Throwable -> L41
            r4.L$2 = r20;     // Catch: Throwable -> L41
            r4.L$3 = r21;     // Catch: Throwable -> L41
            r4.L$4 = r112;     // Catch: Throwable -> L41
            r4.label = 2;     // Catch: Throwable -> L41
            o r113 = new o(IntrinsicsKt.intercepted((Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin")), 1);     // Catch: Throwable -> L41
            r113.e();     // Catch: Throwable -> L41
            final n r23 = (n) ZeusTransformUtils.preCheckCast(r113, n.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L41
            r21.element = BinderMonitor.INSTANCE.monitorTransact(r20, r0, (Function0) ZeusTransformUtils.preCheckCast(new AIKernelApi$Companion$getPackageInfos$2$1(r23), Function0.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L41
            r0.a(r112, (b) ZeusTransformUtils.preCheckCast(new AIKernelApi$Companion$getPackageInfos$2$2(r23, r22), b.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L41
            r5 = r113.h();     // Catch: Throwable -> L41
            if (r5 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L29;
            DebugProbesKt.probeCoroutineSuspended((Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L41
        L41:
            th = move-exception;
            Throwable r114 = th;
            ?? r24 = r21;
        L43:
            AIKLog.INSTANCE.e(AIKernelApi.TAG, "[SDK] getPackageInfos error: " + r114);
            bx r25 = (bx) ZeusTransformUtils.preCheckCast(r24.element, bx.class, "com.obric.memorydata.plugin");
            if (r25 == null) goto L46;
            bx.a.a(r25, null, 1, null);
        L46:
            Result.Companion r30 = Result.Companion;
            return Result.m1421constructorimpl(ResultKt.createFailure((Throwable) ZeusTransformUtils.preCheckCast(new AIKernelException(102, "Got remote error.", r114, 0, 8, null), Throwable.class, "com.obric.memorydata.plugin")));
        L29:
            if (r5 != r6) goto L31;
            return r6;
        L31:
            r2 = r21;
            goto L32
        L22:
            ResultKt.throwOnFailure(r5);
            AIKLog.INSTANCE.i(AIKernelApi.TAG, "[SDK] start getPackageInfos count:" + r2.size());
            r20 = r4.getContext();
            r21 = new Ref.ObjectRef();
            ParamsCompat r115 = ParamsCompat.INSTANCE;     // Catch: Throwable -> L41
            r4.L$0 = r0;     // Catch: Throwable -> L41
            r4.L$1 = r2;     // Catch: Throwable -> L41
            r4.L$2 = r20;     // Catch: Throwable -> L41
            r4.L$3 = r21;     // Catch: Throwable -> L41
            r4.label = 1;     // Catch: Throwable -> L41
            r111 = r115.startCompat(r28, r4);     // Catch: Throwable -> L41
            r22 = r2;
            if (r111 != r6) goto L26;
            return r6;
        L20:
            th = move-exception;
            r114 = th;
            r24 = r2;
        L7:
            r4 = new AIKernelApi$Companion$getPackageInfos$1(this, r3);
            goto L8
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v11, types: [T, kotlinx.coroutines.bx] */
        /* JADX WARN: Type inference failed for: r12v3, types: [com.obric.aikernel.phx.core.conn.BinderMonitor] */
        /* JADX WARN: Type inference failed for: r1v13 */
        /* JADX WARN: Type inference failed for: r1v19 */
        /* JADX WARN: Type inference failed for: r1v2, types: [com.obric.aikernel.a, java.lang.Object] */
        /* JADX WARN: Type inference failed for: r1v20 */
        /* JADX WARN: Type inference failed for: r1v3 */
        /* JADX WARN: Type inference failed for: r1v4, types: [kotlin.jvm.internal.Ref$ObjectRef] */
        /* JADX WARN: Type inference failed for: r1v6 */
        /* JADX WARN: Type inference failed for: r1v7, types: [com.obric.aikernel.a, java.lang.Object] */
        /* JADX WARN: Type inference failed for: r1v8 */
        /* JADX WARN: Type inference failed for: r1v9, types: [kotlin.jvm.internal.Ref$ObjectRef] */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        public final Object loadPackage$sdk_release(a r24, String r25, RequestParams r26, Continuation<? super LoadedPackage> r27) {
            ?? r1 = (a) ZeusTransformUtils.wrapperContextForParams(r24, a.class, "com.obric.memorydata.plugin");
            Continuation r3 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r27, Continuation.class, "com.obric.memorydata.plugin");
            if (ZeusTransformUtils.instanceOf(r3, AIKernelApi$Companion$loadPackage$1.class) == false) goto L7;
            AIKernelApi$Companion$loadPackage$1 r4 = (AIKernelApi$Companion$loadPackage$1) ZeusTransformUtils.preCheckCast(r3, AIKernelApi$Companion$loadPackage$1.class, "com.obric.memorydata.plugin");
            if ((r4.label & Integer.MIN_VALUE) == 0) goto L7;
            r4.label -= Integer.MIN_VALUE;
        L8:
            Object r5 = r4.result;
            Object r6 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r7 = r4.label;
            if (r7 == 0) goto L22;
            if (r7 == 1) goto L17;
            if (r7 != 2) goto L16;
            Bundle r0 = (Bundle) ZeusTransformUtils.preCheckCast(r4.L$3, Bundle.class, "com.obric.memorydata.plugin");
            Ref.ObjectRef r2 = (Ref.ObjectRef) ZeusTransformUtils.preCheckCast(r4.L$2, Ref.ObjectRef.class, "com.obric.memorydata.plugin");
            CoroutineContext r8 = (CoroutineContext) ZeusTransformUtils.preCheckCast(r4.L$1, CoroutineContext.class, "com.obric.memorydata.plugin");
            a r9 = (a) ZeusTransformUtils.preCheckCast(r4.L$0, a.class, "com.obric.memorydata.plugin");
            ResultKt.throwOnFailure(r5);     // Catch: Throwable -> L20
            r1 = r2;
        L33:
            LoadedPackage r10 = (LoadedPackage) ZeusTransformUtils.preCheckCast(r5, LoadedPackage.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L20
            bx r11 = (bx) ZeusTransformUtils.preCheckCast(r1.element, bx.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L20
            if (r11 == null) goto L36;
            bx.a.a(r11, null, 1, null);     // Catch: Throwable -> L20
        L36:
            return r5;
        L16:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L17:
            Ref.ObjectRef r12 = (Ref.ObjectRef) ZeusTransformUtils.preCheckCast(r4.L$3, Ref.ObjectRef.class, "com.obric.memorydata.plugin");
            CoroutineContext r13 = (CoroutineContext) ZeusTransformUtils.preCheckCast(r4.L$2, CoroutineContext.class, "com.obric.memorydata.plugin");
            String r14 = (String) ZeusTransformUtils.preCheckCast(r4.L$1, String.class, "com.obric.memorydata.plugin");
            a r15 = (a) ZeusTransformUtils.preCheckCast(r4.L$0, a.class, "com.obric.memorydata.plugin");
            ResultKt.throwOnFailure(r5);     // Catch: Throwable -> L20
            String r16 = r14;
            Ref.ObjectRef r17 = r12;
            ?? r18 = r15;
        L27:
            Bundle r19 = BundleExtKt.commonParams$default((Bundle) ZeusTransformUtils.preCheckCast(r5, Bundle.class, "com.obric.memorydata.plugin"), r16, IdlKeys.Method_LoadPackage, IdlKeys.Call_Type_CallBiz, null, AIKernelApi.TAG, "loadPackage", null, false, 200, null);     // Catch: Throwable -> L37
            r4.L$0 = r18;     // Catch: Throwable -> L37
            r4.L$1 = r13;     // Catch: Throwable -> L37
            r4.L$2 = r17;     // Catch: Throwable -> L37
            r4.L$3 = r19;     // Catch: Throwable -> L37
            r4.label = 2;     // Catch: Throwable -> L37
            o r110 = new o(IntrinsicsKt.intercepted((Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin")), 1);     // Catch: Throwable -> L37
            r110.e();     // Catch: Throwable -> L37
            final n r20 = (n) ZeusTransformUtils.preCheckCast(r110, n.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L37
            r17.element = BinderMonitor.INSTANCE.monitorTransact(r13, r18, (Function0) ZeusTransformUtils.preCheckCast(new AIKernelApi$Companion$loadPackage$2$1(r20), Function0.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L37
            r18.a(r19, (b) ZeusTransformUtils.preCheckCast(new AIKernelApi$Companion$loadPackage$2$2(r20), b.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L37
            r5 = r110.h();     // Catch: Throwable -> L37
            if (r5 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L30;
            DebugProbesKt.probeCoroutineSuspended((Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L37
        L37:
            th = th;
            r1 = r17;
        L39:
            AIKLog.INSTANCE.e(AIKernelApi.TAG, "[SDK] loadPackage error: " + th);
            bx r21 = (bx) ZeusTransformUtils.preCheckCast(r1.element, bx.class, "com.obric.memorydata.plugin");
            if (r21 == null) goto L42;
            bx.a.a(r21, null, 1, null);
        L42:
            return null;
        L30:
            if (r5 != r6) goto L32;
            return r6;
        L32:
            r1 = r17;
            goto L33
        L22:
            ResultKt.throwOnFailure(r5);
            AIKLog.INSTANCE.i(AIKernelApi.TAG, "[SDK] start loadPackage " + r25);
            CoroutineContext r22 = r4.getContext();
            r17 = new Ref.ObjectRef();
            ParamsCompat r111 = ParamsCompat.INSTANCE;     // Catch: Throwable -> L37
            r4.L$0 = r1;     // Catch: Throwable -> L37
            r4.L$1 = r25;     // Catch: Throwable -> L37
            r4.L$2 = r22;     // Catch: Throwable -> L37
            r4.L$3 = r17;     // Catch: Throwable -> L37
            r4.label = 1;     // Catch: Throwable -> L37
            Object r112 = r111.startCompat(r26, r4);     // Catch: Throwable -> L37
            if (r112 != r6) goto L26;
            return r6;
        L26:
            r16 = r25;
            r13 = r22;
            r5 = r112;
            r18 = r1;
        L20:
            th = th;
        L7:
            r4 = new AIKernelApi$Companion$loadPackage$1(this, r3);
            goto L8
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v25 */
        /* JADX WARN: Type inference failed for: r2v26, types: [kotlin.jvm.internal.Ref$ObjectRef] */
        /* JADX WARN: Type inference failed for: r2v3, types: [java.lang.Object, java.util.List] */
        /* JADX WARN: Type inference failed for: r2v30 */
        /* JADX WARN: Type inference failed for: r2v35 */
        /* JADX WARN: Type inference failed for: r2v36 */
        /* JADX WARN: Type inference failed for: r2v37 */
        /* JADX WARN: Type inference failed for: r2v4 */
        /* JADX WARN: Type inference failed for: r2v5, types: [kotlin.jvm.internal.Ref$ObjectRef] */
        /* JADX WARN: Type inference failed for: r2v8 */
        /* JADX WARN: Type inference failed for: r2v9, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r3v12, types: [T, kotlinx.coroutines.bx] */
        /* JADX INFO: renamed from: updatePackages-BWLJW6A, reason: not valid java name */
        public final Object m201updatePackagesBWLJW6A(a r26, List<PackageResource> r27, RequestParams r28, Continuation<? super Result<? extends List<PackageResource>>> r29) {
            a r0 = (a) ZeusTransformUtils.wrapperContextForParams(r26, a.class, "com.obric.memorydata.plugin");
            ?? r2 = (List) ZeusTransformUtils.wrapperContextForParams(r27, List.class, "com.obric.memorydata.plugin");
            Continuation r3 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r29, Continuation.class, "com.obric.memorydata.plugin");
            if (ZeusTransformUtils.instanceOf(r3, AIKernelApi$Companion$updatePackages$1.class) == false) goto L7;
            AIKernelApi$Companion$updatePackages$1 r4 = (AIKernelApi$Companion$updatePackages$1) ZeusTransformUtils.preCheckCast(r3, AIKernelApi$Companion$updatePackages$1.class, "com.obric.memorydata.plugin");
            if ((r4.label & Integer.MIN_VALUE) == 0) goto L7;
            r4.label -= Integer.MIN_VALUE;
        L8:
            Object r5 = r4.result;
            Object r6 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r7 = r4.label;
            if (r7 == 0) goto L22;
            if (r7 == 1) goto L17;
            if (r7 != 2) goto L16;
            Bundle r1 = (Bundle) ZeusTransformUtils.preCheckCast(r4.L$3, Bundle.class, "com.obric.memorydata.plugin");
            Ref.ObjectRef r8 = (Ref.ObjectRef) ZeusTransformUtils.preCheckCast(r4.L$2, Ref.ObjectRef.class, "com.obric.memorydata.plugin");
            CoroutineContext r9 = (CoroutineContext) ZeusTransformUtils.preCheckCast(r4.L$1, CoroutineContext.class, "com.obric.memorydata.plugin");
            a r10 = (a) ZeusTransformUtils.preCheckCast(r4.L$0, a.class, "com.obric.memorydata.plugin");
            ResultKt.throwOnFailure(r5);     // Catch: Throwable -> L20
            r2 = r8;
        L32:
            Object r11 = ((Result) ZeusTransformUtils.preCheckCast(r5, Result.class, "com.obric.memorydata.plugin")).m1430unboximpl();     // Catch: Throwable -> L20
            bx r12 = (bx) ZeusTransformUtils.preCheckCast(r2.element, bx.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L20
            if (r12 == null) goto L35;
            bx.a.a(r12, null, 1, null);     // Catch: Throwable -> L20
        L35:
            AIKLog r13 = AIKLog.INSTANCE;     // Catch: Throwable -> L20
            StringBuilder r14 = new StringBuilder().append("[SDK] end updatePackages: ");     // Catch: Throwable -> L20
            if (Result.m1427isFailureimpl(r11) == false) goto L38;
            Object r15 = null;
        L39:
            r13.i(AIKernelApi.TAG, r14.append(r15).append(' ').append(Result.m1424exceptionOrNullimpl(r11)).toString());     // Catch: Throwable -> L20
            return ((Result) ZeusTransformUtils.preCheckCast(r5, Result.class, "com.obric.memorydata.plugin")).m1430unboximpl();
        L38:
            r15 = r11;
            goto L39
        L16:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L17:
            Ref.ObjectRef r16 = (Ref.ObjectRef) ZeusTransformUtils.preCheckCast(r4.L$3, Ref.ObjectRef.class, "com.obric.memorydata.plugin");
            CoroutineContext r17 = (CoroutineContext) ZeusTransformUtils.preCheckCast(r4.L$2, CoroutineContext.class, "com.obric.memorydata.plugin");
            List r18 = (List) ZeusTransformUtils.preCheckCast(r4.L$1, List.class, "com.obric.memorydata.plugin");
            a r19 = (a) ZeusTransformUtils.preCheckCast(r4.L$0, a.class, "com.obric.memorydata.plugin");
            ResultKt.throwOnFailure(r5);     // Catch: Throwable -> L20
            CoroutineContext r20 = r17;
            r0 = r19;
            Object r110 = r5;
            Ref.ObjectRef r21 = r16;
            ?? r22 = r18;
        L26:
            Bundle r111 = BundleExtKt.commonParams$default((Bundle) ZeusTransformUtils.preCheckCast(r110, Bundle.class, "com.obric.memorydata.plugin"), null, IdlKeys.Method_UpdatePackages, IdlKeys.Call_Type_CallBiz, null, AIKernelApi.TAG, "updatePackages", null, false, 201, null);     // Catch: Throwable -> L41
            r111.putParcelableArray(IdlKeys.Args_Pkgs, (Parcelable[]) ZeusTransformUtils.preCheckCast(((Collection) ZeusTransformUtils.preCheckCast(r22, Collection.class, "com.obric.memorydata.plugin")).toArray(new PackageResource[0]), Parcelable[].class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L41
            r4.L$0 = r0;     // Catch: Throwable -> L41
            r4.L$1 = r20;     // Catch: Throwable -> L41
            r4.L$2 = r21;     // Catch: Throwable -> L41
            r4.L$3 = r111;     // Catch: Throwable -> L41
            r4.label = 2;     // Catch: Throwable -> L41
            o r23 = new o(IntrinsicsKt.intercepted((Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin")), 1);     // Catch: Throwable -> L41
            r23.e();     // Catch: Throwable -> L41
            final n r24 = (n) ZeusTransformUtils.preCheckCast(r23, n.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L41
            r21.element = BinderMonitor.INSTANCE.monitorTransact(r20, r0, (Function0) ZeusTransformUtils.preCheckCast(new AIKernelApi$Companion$updatePackages$2$1(r24), Function0.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L41
            r0.a(r111, (b) ZeusTransformUtils.preCheckCast(new AIKernelApi$Companion$updatePackages$2$2(r24), b.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L41
            r5 = r23.h();     // Catch: Throwable -> L41
            if (r5 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L29;
            DebugProbesKt.probeCoroutineSuspended((Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L41
        L41:
            th = move-exception;
            Throwable r112 = th;
            ?? r25 = r21;
        L43:
            AIKLog.INSTANCE.e(AIKernelApi.TAG, "[SDK] updatePackages error: " + r112);
            bx r30 = (bx) ZeusTransformUtils.preCheckCast(r25.element, bx.class, "com.obric.memorydata.plugin");
            if (r30 == null) goto L46;
            bx.a.a(r30, null, 1, null);
        L46:
            Result.Companion r31 = Result.Companion;
            return Result.m1421constructorimpl(ResultKt.createFailure((Throwable) ZeusTransformUtils.preCheckCast(new AIKernelException(102, "Got remote error.", r112, 0, 8, null), Throwable.class, "com.obric.memorydata.plugin")));
        L29:
            if (r5 != r6) goto L31;
            return r6;
        L31:
            r2 = r21;
            goto L32
        L22:
            ResultKt.throwOnFailure(r5);
            AIKLog.INSTANCE.i(AIKernelApi.TAG, "[SDK] start updatePackages count:" + r2.size());
            r20 = r4.getContext();
            r21 = new Ref.ObjectRef();
            ParamsCompat r113 = ParamsCompat.INSTANCE;     // Catch: Throwable -> L41
            r4.L$0 = r0;     // Catch: Throwable -> L41
            r4.L$1 = r2;     // Catch: Throwable -> L41
            r4.L$2 = r20;     // Catch: Throwable -> L41
            r4.L$3 = r21;     // Catch: Throwable -> L41
            r4.label = 1;     // Catch: Throwable -> L41
            r110 = r113.startCompat(r28, r4);     // Catch: Throwable -> L41
            r22 = r2;
            if (r110 != r6) goto L26;
            return r6;
        L20:
            th = move-exception;
            r112 = th;
            r25 = r2;
        L7:
            r4 = new AIKernelApi$Companion$updatePackages$1(this, r3);
            goto L8
        }
    }

    /* JADX INFO: renamed from: com.obric.aikernel.phx.sdk.api.AIKernelApi$clearAIKernelData$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.obric.aikernel.phx.sdk.api.AIKernelApi", f = "AIKernelApi.kt", i = {0, 1, 1, 1, 1, 1}, l = {326, 599}, m = "clearAIKernelData", n = {TrackerImpl.PARAMS, "binding", "binder", "formatBundle", "ctx", "monitorTask"}, s = {"L$0", "L$0", "L$1", "L$2", "L$3", "L$4"})
    static final class C10061 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ AIKernelApi this$0;

        C10061(AIKernelApi r3, Continuation<? super C10061> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            super(r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r3) {
            this.result = r3;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.clearAIKernelData(null, (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin"));
        }
    }

    /* JADX INFO: renamed from: com.obric.aikernel.phx.sdk.api.AIKernelApi$getBinder$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.obric.aikernel.phx.sdk.api.AIKernelApi", f = "AIKernelApi.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 2}, l = {157, 162, 171}, m = "getBinder", n = {"this", "timeoutMs", "totalBudgetMs", "deadlineMs", "this", "serviceConnector", "timeoutMs", "totalBudgetMs", "this"}, s = {"L$0", "J$0", "J$1", "J$2", "L$0", "L$1", "J$0", "J$1", "L$0"})
    static final class C10071 extends ContinuationImpl {
        long J$0;
        long J$1;
        long J$2;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ AIKernelApi this$0;

        C10071(AIKernelApi r3, Continuation<? super C10071> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            super(r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r3) {
            this.result = r3;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.getBinder(0, (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin"));
        }
    }

    /* JADX INFO: renamed from: com.obric.aikernel.phx.sdk.api.AIKernelApi$init$5, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.obric.aikernel.phx.sdk.api.AIKernelApi$init$5", f = "AIKernelApi.kt", i = {}, l = {136}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass5 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ AIKernelApi this$0;

        AnonymousClass5(AIKernelApi r3, Continuation<? super AnonymousClass5> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            super(2, r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new AnonymousClass5(this.this$0, r4), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super Unit> r4) {
            return ((AnonymousClass5) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AnonymousClass5.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r7) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r7);
        L15:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r7);
            ServiceConnector r8 = AIKernelApi.access$getConnector$p(this.this$0);
            if (r8 != null) goto L11;
            Intrinsics.throwUninitializedPropertyAccessException("connector");
            r8 = null;
        L11:
            Continuation<? super a> r2 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            if (r8.getService(15000, r2) != r0) goto L15;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.aikernel.phx.sdk.api.AIKernelApi$loadPackage$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\u008a@"}, d2 = {"<anonymous>", "Lcom/obric/aikernel/phx/core/api/AbsApi;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.obric.aikernel.phx.sdk.api.AIKernelApi$loadPackage$2", f = "AIKernelApi.kt", i = {}, l = {303, 306, 307}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function1<Continuation<? super AbsApi>, Object> {
        final /* synthetic */ String $name;
        final /* synthetic */ RequestParams $params;
        final /* synthetic */ boolean $useCloud;
        Object L$0;
        int label;
        final /* synthetic */ AIKernelApi this$0;

        AnonymousClass2(boolean r3, String r4, AIKernelApi r5, RequestParams r6, Continuation<? super AnonymousClass2> r7) {
            Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r7, Continuation.class, "com.obric.memorydata.plugin");
            this.$useCloud = r3;
            this.$name = r4;
            this.this$0 = r5;
            this.$params = r6;
            super(1, r8);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> r9) {
            Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r9, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new AnonymousClass2(this.$useCloud, this.$name, this.this$0, this.$params, r7), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function1
        public /* synthetic */ Object invoke(Continuation<? super AbsApi> r3) {
            return invoke2((Continuation) ZeusTransformUtils.preCheckCast(r3, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(Continuation<? super AbsApi> r3) {
            return ((AnonymousClass2) ZeusTransformUtils.preCheckCast(create((Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin")), AnonymousClass2.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r14) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            ServiceConnector r5 = null;
            if (r1 == 0) goto L16;
            if (r1 == 1) goto L15;
            if (r1 == 2) goto L14;
            if (r1 != 3) goto L13;
            Closeable r2 = (Closeable) ZeusTransformUtils.preCheckCast(this.L$0, Closeable.class, "com.obric.memorydata.plugin");
            ResultKt.throwOnFailure(r14);     // Catch: Throwable -> L10
        L39:
            Companion.LoadedPackage r15 = (Companion.LoadedPackage) ZeusTransformUtils.preCheckCast(r14, Companion.LoadedPackage.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
            CloseableKt.closeFinally(r2, null);
            Companion.LoadedPackage r3 = r15;
        L47:
            if (r3 != null) goto L50;
            return null;
        L50:
            if (this.this$0.getLegacyArch() == true) goto L59;
            if (r3.getExecutionBinderSource() == Companion.ExecutionBinderSource.CHILD_PROCESS) goto L59;
            ServiceConnector r16 = AIKernelApi.access$getConnector$p(this.this$0);
            if (r16 != null) goto L56;
            Intrinsics.throwUninitializedPropertyAccessException("connector");
        L57:
            r5.suppressIdleReleaseForCurrentBinding$sdk_release();
            goto L59
        L56:
            r5 = r16;
        L59:
            return new ScriptBizApi(this.$name, this.$params, r3.getBinder(), AIKernelApi.access$getServicePackageName$p(this.this$0), r3.getTargetProcess());
        L10:
            th = th;
        L64:
            throw th;     // Catch: Throwable -> L44
        L44:
            th = move-exception;
            CloseableKt.closeFinally(r2, th);
            throw th;
        L13:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L14:
            ResultKt.throwOnFailure(r14);
        L32:
            ServiceConnector.MainProcessIpcBinding r17 = (ServiceConnector.MainProcessIpcBinding) ZeusTransformUtils.preCheckCast(r14, ServiceConnector.MainProcessIpcBinding.class, "com.obric.memorydata.plugin");
            if (r17 != null) goto L34;
        L28:
            r3 = null;
            goto L47
        L34:
            Closeable r18 = (Closeable) ZeusTransformUtils.preCheckCast(r17, Closeable.class, "com.obric.memorydata.plugin");
            String r4 = this.$name;
            RequestParams r6 = this.$params;
            ServiceConnector.MainProcessIpcBinding r7 = (ServiceConnector.MainProcessIpcBinding) ZeusTransformUtils.preCheckCast(r18, ServiceConnector.MainProcessIpcBinding.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L41
            Companion r8 = AIKernelApi.Companion;     // Catch: Throwable -> L41
            a r9 = r7.getBinder();     // Catch: Throwable -> L41
            this.L$0 = r18;     // Catch: Throwable -> L41
            this.label = 3;     // Catch: Throwable -> L41
            Object r10 = r8.loadPackage$sdk_release(r9, r4, r6, this);     // Catch: Throwable -> L41
            if (r10 != r0) goto L38;
            return r0;
        L38:
            r2 = r18;
            r14 = r10;
        L41:
            th = th;
            r2 = r18;
            goto L64
        L15:
            ResultKt.throwOnFailure(r14);
        L25:
            a r19 = (a) ZeusTransformUtils.preCheckCast(r14, a.class, "com.obric.memorydata.plugin");
            if (r19 == null) goto L28;
            r3 = new Companion.LoadedPackage(r19, null);
            goto L47
        L16:
            ResultKt.throwOnFailure(r14);
            if (this.$useCloud == true) goto L19;
            boolean r110 = this.this$0.getLegacyArch();
            AIKernelApi r11 = this.this$0;
            if (r110 == false) goto L29;
            Continuation r12 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            r14 = AIKernelApi.getBinder$default(r11, 0, r12, 1, null);
            if (r14 != r0) goto L25;
            return r0;
        L29:
            Continuation r13 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 2;
            r14 = AIKernelApi.getMainProcessIpcBinding$sdk_release$default(r11, 0, r13, 1, null);
            if (r14 != r0) goto L32;
            return r0;
        L19:
            return new CloudBizApi(this.$name);
        }
    }

    /* JADX INFO: renamed from: com.obric.aikernel.phx.sdk.api.AIKernelApi$waitForConnector$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "Lcom/obric/aikernel/phx/core/conn/ServiceConnector;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.obric.aikernel.phx.sdk.api.AIKernelApi$waitForConnector$3", f = "AIKernelApi.kt", i = {}, l = {203}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass3 extends SuspendLambda implements Function2<al, Continuation<? super ServiceConnector>, Object> {
        int label;
        final /* synthetic */ AIKernelApi this$0;

        AnonymousClass3(AIKernelApi r3, Continuation<? super AnonymousClass3> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            super(2, r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new AnonymousClass3(this.this$0, r4), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super ServiceConnector> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super ServiceConnector> r4) {
            return ((AnonymousClass3) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AnonymousClass3.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r5) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r5);
        L11:
            return r5;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r5);
            w r6 = AIKernelApi.access$getConnectorReady$p(this.this$0);
            Continuation r2 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            r5 = r6.a(r2);
            if (r5 != r0) goto L11;
            return r0;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public AIKernelApi() {
        this((Function3) ZeusTransformUtils.preCheckCast(AnonymousClass1.INSTANCE, Function3.class, "com.obric.memorydata.plugin"));
    }

    public AIKernelApi(Function3<? super Context, ? super AIKernelConfig, ? super ComponentName, ServiceConnector> r6) {
        Function3<Context, AIKernelConfig, ComponentName, ServiceConnector> r7 = (Function3) ZeusTransformUtils.wrapperContextForParams(r6, Function3.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "serviceConnectorFactory");
        this.connectorReady = y.a(null, 1, null);
        this.transactScope = am.a(ba.c().plus((CoroutineContext) ZeusTransformUtils.preCheckCast(cu.a(null, 1, null), CoroutineContext.class, "com.obric.memorydata.plugin")).plus((CoroutineContext) ZeusTransformUtils.preCheckCast((CoroutineExceptionHandler) ZeusTransformUtils.preCheckCast(new AIKernelApi$special$$inlined$CoroutineExceptionHandler$1(CoroutineExceptionHandler.f17198b), CoroutineExceptionHandler.class, "com.obric.memorydata.plugin"), CoroutineContext.class, "com.obric.memorydata.plugin")));
        this.legacyArch = true;
        this.servicePackageName = "com.obric.aikernel";
        this.serviceConnectorFactory = r7;
    }

    public static final /* synthetic */ ServiceConnector access$getConnector$p(AIKernelApi r0) {
        return r0.connector;
    }

    public static final /* synthetic */ w access$getConnectorReady$p(AIKernelApi r0) {
        return r0.connectorReady;
    }

    /* JADX INFO: renamed from: access$getPackageInfos-0E7RQCE, reason: not valid java name */
    public static final /* synthetic */ Object m192access$getPackageInfos0E7RQCE(AIKernelApi r2, List r3, RequestParams r4, Continuation r5) {
        return r2.m196getPackageInfos0E7RQCE((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"), r4, (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: access$getPackageResource-0E7RQCE, reason: not valid java name */
    public static final /* synthetic */ Object m193access$getPackageResource0E7RQCE(AIKernelApi r2, String r3, RequestParams r4, Continuation r5) {
        return r2.m197getPackageResource0E7RQCE(r3, r4, (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin"));
    }

    public static final /* synthetic */ String access$getServicePackageName$p(AIKernelApi r0) {
        return r0.servicePackageName;
    }

    public static final /* synthetic */ al access$getTransactScope$p(AIKernelApi r0) {
        return r0.transactScope;
    }

    /* JADX INFO: renamed from: access$updatePackageInner-0E7RQCE, reason: not valid java name */
    public static final /* synthetic */ Object m194access$updatePackageInner0E7RQCE(AIKernelApi r2, PackageResource r3, RequestParams r4, Continuation r5) {
        return r2.m198updatePackageInner0E7RQCE(r3, r4, (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: access$updatePackages-0E7RQCE, reason: not valid java name */
    public static final /* synthetic */ Object m195access$updatePackages0E7RQCE(AIKernelApi r2, List r3, RequestParams r4, Continuation r5) {
        return r2.m199updatePackages0E7RQCE((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"), r4, (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin"));
    }

    public static final /* synthetic */ Object access$waitForConnector(AIKernelApi r2, long r3, Continuation r5) {
        return r2.waitForConnector(r3, (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin"));
    }

    public static /* synthetic */ Object getBinder$default(AIKernelApi r1, long r2, Continuation r4, int r5, Object r6) {
        Continuation<? super a> r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        if ((r5 & 1) == 0) goto L6;
        r2 = 5000;
    L6:
        return r1.getBinder(r2, r7);
    }

    public static /* synthetic */ Object getMainProcessIpcBinding$sdk_release$default(AIKernelApi r1, long r2, Continuation r4, int r5, Object r6) {
        Continuation<? super ServiceConnector.MainProcessIpcBinding> r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        if ((r5 & 1) == 0) goto L6;
        r2 = 5000;
    L6:
        return r1.getMainProcessIpcBinding$sdk_release(r2, r7);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v20, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r2v33 */
    /* JADX WARN: Type inference failed for: r2v34 */
    /* JADX WARN: Type inference failed for: r2v6, types: [int] */
    /* JADX WARN: Type inference failed for: r2v7, types: [java.io.Closeable] */
    /* JADX INFO: renamed from: getPackageInfos-0E7RQCE, reason: not valid java name */
    private final Object m196getPackageInfos0E7RQCE(List<String> r17, RequestParams r18, Continuation<? super Result<? extends List<PackageResource>>> r19) {
        AIKernelApi r0 = this;
        List<String> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r17, List.class, "com.obric.memorydata.plugin");
        Continuation r1 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r19, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r1, AIKernelApi$getPackageInfos$1.class) == false) goto L7;
        AIKernelApi$getPackageInfos$1 r2 = (AIKernelApi$getPackageInfos$1) ZeusTransformUtils.preCheckCast(r1, AIKernelApi$getPackageInfos$1.class, "com.obric.memorydata.plugin");
        if ((r2.label & Integer.MIN_VALUE) == 0) goto L7;
        r2.label -= Integer.MIN_VALUE;
    L8:
        AIKernelApi$getPackageInfos$1 r9 = r2;
        Object r3 = r9.result;
        Object r10 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ?? r4 = r9.label;
        boolean r14 = true;
        if (r4 == 0) goto L20;
        if (r4 == 1) goto L19;
        if (r4 != 2) goto L18;
        Closeable r5 = (Closeable) ZeusTransformUtils.preCheckCast(r9.L$2, Closeable.class, "com.obric.memorydata.plugin");
        RequestParams r6 = (RequestParams) ZeusTransformUtils.preCheckCast(r9.L$1, RequestParams.class, "com.obric.memorydata.plugin");
        List<String> r7 = (List) ZeusTransformUtils.preCheckCast(r9.L$0, List.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r3);     // Catch: Throwable -> L15
        Object r11 = ((Result) ZeusTransformUtils.preCheckCast(r3, Result.class, "com.obric.memorydata.plugin")).m1430unboximpl();     // Catch: Throwable -> L15
        r4 = r5;
    L37:
        if (Result.m1427isFailureimpl(r11) == false) goto L39;
        AIKLog.INSTANCE.w(TAG, "[SDK] getPackageInfos binder ready but rpc failed, names=" + r7 + ", traceId=" + r6.getTraceIdStr() + ", error=" + Result.m1424exceptionOrNullimpl(r11));     // Catch: Throwable -> L15
    L39:
        CloseableKt.closeFinally(r4, null);
        return r11;
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        RequestParams r12 = (RequestParams) ZeusTransformUtils.preCheckCast(r9.L$2, RequestParams.class, "com.obric.memorydata.plugin");
        r8 = (List) ZeusTransformUtils.preCheckCast(r9.L$1, List.class, "com.obric.memorydata.plugin");
        AIKernelApi r13 = (AIKernelApi) ZeusTransformUtils.preCheckCast(r9.L$0, AIKernelApi.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r3);
        RequestParams r15 = r12;
        r0 = r13;
    L23:
        ServiceConnector.MainProcessIpcBinding r16 = (ServiceConnector.MainProcessIpcBinding) ZeusTransformUtils.preCheckCast(r3, ServiceConnector.MainProcessIpcBinding.class, "com.obric.memorydata.plugin");
        if (r16 != null) goto L31;
        AIKLog r20 = AIKLog.INSTANCE;
        StringBuilder r21 = new StringBuilder().append("[SDK] getPackageInfos binder is null, names=").append(r8).append(", traceId=").append(r15.getTraceIdStr()).append(", connectorInited=");
        if (r0.connector != null) goto L29;
        r14 = false;
    L29:
        r20.e(TAG, r21.append(r14).append(", hasConnectedOnce=").append(r0.hasConnectedOnce).toString());
        Result.Companion r22 = Result.Companion;
        return Result.m1421constructorimpl(ResultKt.createFailure((Throwable) ZeusTransformUtils.preCheckCast(new AIKernelException(102, "Binder not ready.", null, 0, 12, null), Throwable.class, "com.obric.memorydata.plugin")));
    L31:
        Closeable r23 = (Closeable) ZeusTransformUtils.preCheckCast(r16, Closeable.class, "com.obric.memorydata.plugin");
        ServiceConnector.MainProcessIpcBinding r24 = (ServiceConnector.MainProcessIpcBinding) ZeusTransformUtils.preCheckCast(r23, ServiceConnector.MainProcessIpcBinding.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L15
        Companion r25 = Companion;     // Catch: Throwable -> L15
        a r26 = r24.getBinder();     // Catch: Throwable -> L15
        r9.L$0 = r8;     // Catch: Throwable -> L15
        r9.L$1 = r15;     // Catch: Throwable -> L15
        r9.L$2 = r23;     // Catch: Throwable -> L15
        r9.label = 2;     // Catch: Throwable -> L15
        r11 = r25.m200getPackageInfosBWLJW6A(r26, r8, r15, r9);     // Catch: Throwable -> L15
        if (r11 != r10) goto L35;
        return r10;
    L35:
        r7 = r8;
        r6 = r15;
        r4 = r23;
        goto L37
    L20:
        ResultKt.throwOnFailure(r3);
        r9.L$0 = r0;
        r9.L$1 = r8;
        r15 = r18;
        r9.L$2 = r15;
        r9.label = 1;
        r3 = getMainProcessIpcBinding$sdk_release$default(this, 0, r9, 1, null);
        if (r3 != r10) goto L23;
        return r10;
    L15:
        th = move-exception;
        throw th;     // Catch: Throwable -> L42
    L42:
        th = move-exception;
        CloseableKt.closeFinally(r4, th);
        throw th;
    L7:
        r2 = new AIKernelApi$getPackageInfos$1(r0, r1);
        goto L8
    }

    /* JADX INFO: renamed from: getPackageResource-0E7RQCE, reason: not valid java name */
    private final Object m197getPackageResource0E7RQCE(String r10, RequestParams r11, Continuation<? super Result<PackageResource>> r12) {
        Continuation r13 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r12, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r13, AIKernelApi$getPackageResource$1.class) == false) goto L7;
        AIKernelApi$getPackageResource$1 r0 = (AIKernelApi$getPackageResource$1) ZeusTransformUtils.preCheckCast(r13, AIKernelApi$getPackageResource$1.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r14 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        Object r4 = null;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r14);
        Object r9 = ((Result) ZeusTransformUtils.preCheckCast(r14, Result.class, "com.obric.memorydata.plugin")).m1430unboximpl();
    L20:
        if (Result.m1428isSuccessimpl(r9) == false) goto L31;
        Result.Companion r15 = Result.Companion;
        if (Result.m1427isFailureimpl(r9) == true) goto L25;
        r4 = r9;
    L25:
        List r16 = (List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.memorydata.plugin");
        if (r16 == null) goto L29;
        Object r17 = (PackageResource) ZeusTransformUtils.preCheckCast(CollectionsKt.first(r16), PackageResource.class, "com.obric.memorydata.plugin");
        if (r17 == null) goto L29;
    L33:
        return Result.m1421constructorimpl(r17);
    L29:
        Result.Companion r18 = Result.Companion;
        return Result.m1421constructorimpl(ResultKt.createFailure((Throwable) ZeusTransformUtils.preCheckCast(new AIKernelException(108, "call success but got null!", null, 0, 12, null), Throwable.class, "com.obric.memorydata.plugin")));
    L31:
        Result.Companion r19 = Result.Companion;
        r17 = ResultKt.createFailure(AIKernelException.Companion.getException(r9));
        goto L33
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r14);
        if (r11.getUseLocalPapaya() == true) goto L35;
        List<String> r110 = CollectionsKt.listOf(r10);
        r0.label = 1;
        r9 = m196getPackageInfos0E7RQCE(r110, r11, r0);
        if (r9 != r2) goto L20;
        return r2;
    L35:
        throw new NotImplementedError(null, 1, null);
    L7:
        r0 = new AIKernelApi$getPackageResource$1(this, r13);
        goto L8
    }

    public static /* synthetic */ void init$default(AIKernelApi r1, AIKernelConfig r2, ILog r3, int r4, Object r5) {
        ILog r6 = (ILog) ZeusTransformUtils.wrapperContextForParams(r3, ILog.class, "com.obric.memorydata.plugin");
        if ((r4 & 2) == 0) goto L5;
        r6 = null;
    L5:
        r1.init(r2, r6);
    }

    private final long remainMs(long r3) {
        return Math.max(r3 - System.currentTimeMillis(), 0);
    }

    /* JADX INFO: renamed from: updatePackageInner-0E7RQCE, reason: not valid java name */
    private final Object m198updatePackageInner0E7RQCE(PackageResource r10, RequestParams r11, Continuation<? super Result<PackageResource>> r12) {
        Continuation r13 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r12, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r13, AIKernelApi$updatePackageInner$1.class) == false) goto L7;
        AIKernelApi$updatePackageInner$1 r0 = (AIKernelApi$updatePackageInner$1) ZeusTransformUtils.preCheckCast(r13, AIKernelApi$updatePackageInner$1.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r14 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        Object r4 = null;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r14);
        Object r9 = ((Result) ZeusTransformUtils.preCheckCast(r14, Result.class, "com.obric.memorydata.plugin")).m1430unboximpl();
    L20:
        if (Result.m1428isSuccessimpl(r9) == false) goto L31;
        Result.Companion r15 = Result.Companion;
        if (Result.m1427isFailureimpl(r9) == true) goto L25;
        r4 = r9;
    L25:
        List r16 = (List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.memorydata.plugin");
        if (r16 == null) goto L29;
        Object r17 = (PackageResource) ZeusTransformUtils.preCheckCast(CollectionsKt.first(r16), PackageResource.class, "com.obric.memorydata.plugin");
        if (r17 == null) goto L29;
    L33:
        return Result.m1421constructorimpl(r17);
    L29:
        Result.Companion r18 = Result.Companion;
        return Result.m1421constructorimpl(ResultKt.createFailure((Throwable) ZeusTransformUtils.preCheckCast(new AIKernelException(108, "call success but got null!", null, 0, 12, null), Throwable.class, "com.obric.memorydata.plugin")));
    L31:
        Result.Companion r19 = Result.Companion;
        r17 = ResultKt.createFailure(AIKernelException.Companion.getException(r9));
        goto L33
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r14);
        if (r11.getUseLocalPapaya() == true) goto L35;
        List<PackageResource> r110 = CollectionsKt.listOf(r10);
        r0.label = 1;
        r9 = m199updatePackages0E7RQCE(r110, r11, r0);
        if (r9 != r2) goto L20;
        return r2;
    L35:
        throw new NotImplementedError(null, 1, null);
    L7:
        r0 = new AIKernelApi$updatePackageInner$1(this, r13);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v0, types: [com.obric.aikernel.phx.sdk.api.AIKernelApi] */
    /* JADX WARN: Type inference failed for: r11v1, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r11v12, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r11v21 */
    /* JADX WARN: Type inference failed for: r11v22 */
    /* JADX INFO: renamed from: updatePackages-0E7RQCE, reason: not valid java name */
    private final Object m199updatePackages0E7RQCE(List<PackageResource> r12, RequestParams r13, Continuation<? super Result<? extends List<PackageResource>>> r14) {
        List<PackageResource> r15 = (List) ZeusTransformUtils.wrapperContextForParams(r12, List.class, "com.obric.memorydata.plugin");
        Continuation r16 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r14, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r16, AIKernelApi$updatePackages$1.class) == false) goto L7;
        AIKernelApi$updatePackages$1 r0 = (AIKernelApi$updatePackages$1) ZeusTransformUtils.preCheckCast(r16, AIKernelApi$updatePackages$1.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r17 = r0.result;
        Object r8 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.label;
        if (r2 == 0) goto L20;
        if (r2 == 1) goto L19;
        if (r2 != 2) goto L18;
        Closeable r11 = (Closeable) ZeusTransformUtils.preCheckCast(r0.L$0, Closeable.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r17);     // Catch: Throwable -> L15
        Object r18 = ((Result) ZeusTransformUtils.preCheckCast(r17, Result.class, "com.obric.memorydata.plugin")).m1430unboximpl();     // Catch: Throwable -> L15
        AIKernelApi this = r11;
    L29:
        CloseableKt.closeFinally(this, null);
        return r18;
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        r13 = (RequestParams) ZeusTransformUtils.preCheckCast(r0.L$1, RequestParams.class, "com.obric.memorydata.plugin");
        r15 = (List) ZeusTransformUtils.preCheckCast(r0.L$0, List.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r17);
    L23:
        ServiceConnector.MainProcessIpcBinding r19 = (ServiceConnector.MainProcessIpcBinding) ZeusTransformUtils.preCheckCast(r17, ServiceConnector.MainProcessIpcBinding.class, "com.obric.memorydata.plugin");
        if (r19 == null) goto L34;
        Closeable r110 = (Closeable) ZeusTransformUtils.preCheckCast(r19, Closeable.class, "com.obric.memorydata.plugin");
        ServiceConnector.MainProcessIpcBinding r111 = (ServiceConnector.MainProcessIpcBinding) ZeusTransformUtils.preCheckCast(r110, ServiceConnector.MainProcessIpcBinding.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L15
        Companion r1 = Companion;     // Catch: Throwable -> L15
        a r112 = r111.getBinder();     // Catch: Throwable -> L15
        r0.L$0 = r110;     // Catch: Throwable -> L15
        r0.L$1 = null;     // Catch: Throwable -> L15
        r0.label = 2;     // Catch: Throwable -> L15
        r18 = r1.m201updatePackagesBWLJW6A(r112, r15, r13, r0);     // Catch: Throwable -> L15
        this = r110;
        if (r18 != r8) goto L29;
        return r8;
    L34:
        Result.Companion r113 = Result.Companion;
        return Result.m1421constructorimpl(ResultKt.createFailure((Throwable) ZeusTransformUtils.preCheckCast(new AIKernelException(102, "Binder is null.", null, 0, 12, null), Throwable.class, "com.obric.memorydata.plugin")));
    L20:
        ResultKt.throwOnFailure(r17);
        AIKLog.INSTANCE.i(TAG, "[SDK] updatePackages count:" + r15.size());
        r0.L$0 = r15;
        r0.L$1 = r13;
        r0.label = 1;
        r17 = getMainProcessIpcBinding$sdk_release$default(this, 0, r0, 1, null);
        if (r17 != r8) goto L23;
        return r8;
    L15:
        th = move-exception;
        throw th;     // Catch: Throwable -> L31
    L31:
        th = move-exception;
        CloseableKt.closeFinally(this, th);
        throw th;
    L7:
        r0 = new AIKernelApi$updatePackages$1(this, r16);
        goto L8
    }

    private final Object waitForConnector(long r4, Continuation<? super ServiceConnector> r6) {
        Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
        ServiceConnector r0 = this.connector;
        if (r0 == null) goto L8;
        if (r0 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("connector");
        return null;
    L9:
        return r0;
    L8:
        return da.b(r4, (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass3(this, null), Function2.class, "com.obric.memorydata.plugin"), r7);
    }

    public static /* synthetic */ Object wrapApiCall$default(AIKernelApi r1, RequestParams r2, a r3, Function1 r4, Continuation r5, int r6, Object r7) {
        a r8 = (a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.memorydata.plugin");
        Function1 r9 = (Function1) ZeusTransformUtils.wrapperContextForParams(r4, Function1.class, "com.obric.memorydata.plugin");
        Continuation r10 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        if ((r6 & 2) == 0) goto L6;
        r8 = null;
    L6:
        return r1.wrapApiCall(r2, r8, r9, r10);
    }

    /* JADX WARN: Type inference failed for: r10v4, types: [T, kotlinx.coroutines.bx] */
    @Override // com.obric.aikernel.phx.sdk.IAIKernelManager
    public Object clearAIKernelData(RequestParams r23, Continuation<? super Unit> r24) {
        Continuation r1 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r24, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r1, C10061.class) == false) goto L7;
        C10061 r3 = (C10061) ZeusTransformUtils.preCheckCast(r1, C10061.class, "com.obric.memorydata.plugin");
        if ((r3.label & Integer.MIN_VALUE) == 0) goto L7;
        r3.label -= Integer.MIN_VALUE;
    L8:
        Object r2 = r3.result;
        Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r3.label;
        if (r5 == 0) goto L20;
        if (r5 == 1) goto L19;
        if (r5 != 2) goto L18;
        Ref.ObjectRef r6 = (Ref.ObjectRef) ZeusTransformUtils.preCheckCast(r3.L$4, Ref.ObjectRef.class, "com.obric.memorydata.plugin");
        CoroutineContext r0 = (CoroutineContext) ZeusTransformUtils.preCheckCast(r3.L$3, CoroutineContext.class, "com.obric.memorydata.plugin");
        Bundle r7 = (Bundle) ZeusTransformUtils.preCheckCast(r3.L$2, Bundle.class, "com.obric.memorydata.plugin");
        a r8 = (a) ZeusTransformUtils.preCheckCast(r3.L$1, a.class, "com.obric.memorydata.plugin");
        ServiceConnector.MainProcessIpcBinding r9 = (ServiceConnector.MainProcessIpcBinding) ZeusTransformUtils.preCheckCast(r3.L$0, ServiceConnector.MainProcessIpcBinding.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r2);     // Catch: Throwable -> L15
    L36:
        bx r10 = (bx) ZeusTransformUtils.preCheckCast(r6.element, bx.class, "com.obric.memorydata.plugin");     // Catch: RemoteException -> L47
        if (r10 == null) goto L39;
        bx.a.a(r10, null, 1, null);     // Catch: RemoteException -> L47
    L39:
        r9.close();     // Catch: RemoteException -> L47
    L50:
        return Unit.INSTANCE;
    L15:
        th = th;
    L42:
        bx r11 = (bx) ZeusTransformUtils.preCheckCast(r6.element, bx.class, "com.obric.memorydata.plugin");     // Catch: RemoteException -> L47
        if (r11 == null) goto L45;
        bx.a.a(r11, null, 1, null);     // Catch: RemoteException -> L47
    L45:
        r9.close();     // Catch: RemoteException -> L47
        throw th;     // Catch: RemoteException -> L47
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        RequestParams r12 = (RequestParams) ZeusTransformUtils.preCheckCast(r3.L$0, RequestParams.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r2);
    L24:
        ServiceConnector.MainProcessIpcBinding r13 = (ServiceConnector.MainProcessIpcBinding) ZeusTransformUtils.preCheckCast(r2, ServiceConnector.MainProcessIpcBinding.class, "com.obric.memorydata.plugin");
        if (r13 != null) goto L28;
        AIKLog.INSTANCE.d(TAG, "binder is not ready.");
        return Unit.INSTANCE;
    L28:
        a r14 = r13.getBinder();
        Bundle r15 = BundleExtKt.commonParams$default(r12.start(), "", IdlKeys.Method_ClearData, IdlKeys.Call_Type_CallBiz, "", TAG, "clearAIKernelData", null, false, 192, null);     // Catch: RemoteException -> L47
        AIKLog.INSTANCE.i(TAG, "[SDK] clearAIKernelData formatBundle:" + r15);     // Catch: RemoteException -> L47
        CoroutineContext r16 = r3.getContext();     // Catch: RemoteException -> L47
        Ref.ObjectRef r17 = new Ref.ObjectRef();     // Catch: RemoteException -> L47
        r3.L$0 = r13;     // Catch: Throwable -> L40
        r3.L$1 = r14;     // Catch: Throwable -> L40
        r3.L$2 = r15;     // Catch: Throwable -> L40
        r3.L$3 = r16;     // Catch: Throwable -> L40
        r3.L$4 = r17;     // Catch: Throwable -> L40
        r3.label = 2;     // Catch: Throwable -> L40
        o r18 = new o(IntrinsicsKt.intercepted((Continuation) ZeusTransformUtils.preCheckCast(r3, Continuation.class, "com.obric.memorydata.plugin")), 1);     // Catch: Throwable -> L40
        r18.e();     // Catch: Throwable -> L40
        final n r19 = (n) ZeusTransformUtils.preCheckCast(r18, n.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L40
        r17.element = BinderMonitor.INSTANCE.monitorTransact(r16, r14, (Function0) ZeusTransformUtils.preCheckCast(new AIKernelApi$clearAIKernelData$2$1(r19), Function0.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L40
        r14.a(r15, (b) ZeusTransformUtils.preCheckCast(new AIKernelApi$clearAIKernelData$2$2(r19), b.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L40
        Object r20 = r18.h();     // Catch: Throwable -> L40
        if (r20 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L33;
        DebugProbesKt.probeCoroutineSuspended((Continuation) ZeusTransformUtils.preCheckCast(r3, Continuation.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L40
    L33:
        if (r20 != r4) goto L35;
        return r4;
    L35:
        r9 = r13;
        r6 = r17;
    L40:
        th = th;
        r9 = r13;
        r6 = r17;
        goto L42
    L20:
        ResultKt.throwOnFailure(r2);
        r3.L$0 = r23;
        r3.label = 1;
        Object r21 = getMainProcessIpcBinding$sdk_release(60000, r3);
        if (r21 != r4) goto L23;
        return r4;
    L23:
        r2 = r21;
        r12 = r23;
    L47:
        e = move-exception;
        AIKLog.INSTANCE.e(TAG, "clearAIKernelData error: " + e);
    L7:
        r3 = new C10061(this, r1);
        goto L8
    }

    public final Object getBinder(long r19, Continuation<? super a> r21) {
        AIKernelApi r0 = this;
        long r1 = r19;
        Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r21, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r4, C10071.class) == false) goto L7;
        C10071 r6 = (C10071) ZeusTransformUtils.preCheckCast(r4, C10071.class, "com.obric.memorydata.plugin");
        if ((r6.label & Integer.MIN_VALUE) == 0) goto L7;
        r6.label -= Integer.MIN_VALUE;
    L8:
        Object r5 = r6.result;
        Object r7 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r8 = r6.label;
        if (r8 == 0) goto L18;
        if (r8 == 1) goto L17;
        if (r8 == 2) goto L16;
        if (r8 != 3) goto L15;
        r0 = (AIKernelApi) ZeusTransformUtils.preCheckCast(r6.L$0, AIKernelApi.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r5);
    L43:
        a r2 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L49;
        r0.hasConnectedOnce = true;
        return r2;
    L49:
        return null;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        long r3 = r6.J$1;
        long r14 = r6.J$0;
        ServiceConnector r9 = (ServiceConnector) ZeusTransformUtils.preCheckCast(r6.L$1, ServiceConnector.class, "com.obric.memorydata.plugin");
        AIKernelApi r10 = (AIKernelApi) ZeusTransformUtils.preCheckCast(r6.L$0, AIKernelApi.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r5);
        long r11 = r3;
        r0 = r10;
        Object r12 = r5;
        String r13 = TAG;
    L29:
        a r15 = (a) ZeusTransformUtils.preCheckCast(r12, a.class, "com.obric.memorydata.plugin");
        if (r15 == null) goto L34;
        r0.hasConnectedOnce = true;
        return r15;
    L34:
        if (r14 != 5000) goto L36;
        boolean r16 = true;
    L38:
        if (r0.hasConnectedOnce == true) goto L47;
        if (r16 == false) goto L48;
        AIKLog.INSTANCE.w(r13, "binder not ready in " + r11 + "ms, retry with first-connect timeout.");
        r6.L$0 = r0;
        r6.L$1 = null;
        r6.label = 3;
        r5 = r9.getService(15000, r6);
        if (r5 != r7) goto L43;
        return r7;
    L48:
        return null;
    L47:
        return null;
    L36:
        r16 = false;
        goto L38
    L17:
        long r17 = r6.J$2;
        long r18 = r6.J$1;
        long r110 = r6.J$0;
        AIKernelApi r20 = (AIKernelApi) ZeusTransformUtils.preCheckCast(r6.L$0, AIKernelApi.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r5);
        Object r22 = r5;
        r0 = r20;
        r1 = r110;
        r11 = r18;
        long r111 = r17;
    L21:
        ServiceConnector r23 = (ServiceConnector) ZeusTransformUtils.preCheckCast(r22, ServiceConnector.class, "com.obric.memorydata.plugin");
        if (r23 != null) goto L25;
        AIKernelApi r24 = (AIKernelApi) ZeusTransformUtils.preCheckCast(r0, AIKernelApi.class, "com.obric.memorydata.plugin");
        AIKLog.INSTANCE.w(TAG, "connector not initialized within " + r11 + "ms");
        return null;
    L25:
        long r112 = r0.remainMs(r111);
        r6.L$0 = r0;
        r6.L$1 = r23;
        r6.J$0 = r1;
        r6.J$1 = r11;
        r6.label = 2;
        r12 = r23.getService(r112, r6);
        if (r12 != r7) goto L28;
        return r7;
    L28:
        r14 = r1;
        r9 = r23;
        goto L29
    L18:
        ResultKt.throwOnFailure(r5);
        r11 = Math.max(r1, 0);
        r111 = System.currentTimeMillis() + r11;
        long r25 = r0.remainMs(r111);
        r6.L$0 = r0;
        r6.J$0 = r1;
        r6.J$1 = r11;
        r6.J$2 = r111;
        r6.label = 1;
        r22 = r0.waitForConnector(r25, r6);
        if (r22 != r7) goto L21;
        return r7;
    L7:
        r6 = new C10071(r0, r4);
        goto L8
    }

    public final boolean getLegacyArch() {
        return this.legacyArch;
    }

    public final Object getMainProcessIpcBinding$sdk_release(long r19, Continuation<? super ServiceConnector.MainProcessIpcBinding> r21) {
        AIKernelApi r0 = this;
        long r1 = r19;
        Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r21, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r4, AIKernelApi$getMainProcessIpcBinding$1.class) == false) goto L7;
        AIKernelApi$getMainProcessIpcBinding$1 r6 = (AIKernelApi$getMainProcessIpcBinding$1) ZeusTransformUtils.preCheckCast(r4, AIKernelApi$getMainProcessIpcBinding$1.class, "com.obric.memorydata.plugin");
        if ((r6.label & Integer.MIN_VALUE) == 0) goto L7;
        r6.label -= Integer.MIN_VALUE;
    L8:
        Object r5 = r6.result;
        Object r7 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r8 = r6.label;
        if (r8 == 0) goto L18;
        if (r8 == 1) goto L17;
        if (r8 == 2) goto L16;
        if (r8 != 3) goto L15;
        r0 = (AIKernelApi) ZeusTransformUtils.preCheckCast(r6.L$0, AIKernelApi.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r5);
    L43:
        ServiceConnector.MainProcessIpcBinding r2 = (ServiceConnector.MainProcessIpcBinding) ZeusTransformUtils.preCheckCast(r5, ServiceConnector.MainProcessIpcBinding.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L49;
        r0.hasConnectedOnce = true;
        return r2;
    L49:
        return null;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        long r3 = r6.J$1;
        long r14 = r6.J$0;
        ServiceConnector r9 = (ServiceConnector) ZeusTransformUtils.preCheckCast(r6.L$1, ServiceConnector.class, "com.obric.memorydata.plugin");
        AIKernelApi r10 = (AIKernelApi) ZeusTransformUtils.preCheckCast(r6.L$0, AIKernelApi.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r5);
        long r11 = r3;
        r0 = r10;
        Object r12 = r5;
        String r13 = TAG;
    L29:
        ServiceConnector.MainProcessIpcBinding r15 = (ServiceConnector.MainProcessIpcBinding) ZeusTransformUtils.preCheckCast(r12, ServiceConnector.MainProcessIpcBinding.class, "com.obric.memorydata.plugin");
        if (r15 == null) goto L34;
        r0.hasConnectedOnce = true;
        return r15;
    L34:
        if (r14 != 5000) goto L36;
        boolean r16 = true;
    L38:
        if (r0.hasConnectedOnce == true) goto L47;
        if (r16 == false) goto L48;
        AIKLog.INSTANCE.w(r13, "binder not ready in " + r11 + "ms, retry with first-connect timeout.");
        r6.L$0 = r0;
        r6.L$1 = null;
        r6.label = 3;
        r5 = r9.getServiceWithMainProcessIpcLease$sdk_release(15000, r6);
        if (r5 != r7) goto L43;
        return r7;
    L48:
        return null;
    L47:
        return null;
    L36:
        r16 = false;
        goto L38
    L17:
        long r17 = r6.J$2;
        long r18 = r6.J$1;
        long r110 = r6.J$0;
        AIKernelApi r20 = (AIKernelApi) ZeusTransformUtils.preCheckCast(r6.L$0, AIKernelApi.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r5);
        Object r22 = r5;
        r0 = r20;
        r1 = r110;
        r11 = r18;
        long r111 = r17;
    L21:
        ServiceConnector r23 = (ServiceConnector) ZeusTransformUtils.preCheckCast(r22, ServiceConnector.class, "com.obric.memorydata.plugin");
        if (r23 != null) goto L25;
        AIKernelApi r24 = (AIKernelApi) ZeusTransformUtils.preCheckCast(r0, AIKernelApi.class, "com.obric.memorydata.plugin");
        AIKLog.INSTANCE.w(TAG, "connector not initialized within " + r11 + "ms");
        return null;
    L25:
        long r112 = r0.remainMs(r111);
        r6.L$0 = r0;
        r6.L$1 = r23;
        r6.J$0 = r1;
        r6.J$1 = r11;
        r6.label = 2;
        r12 = r23.getServiceWithMainProcessIpcLease$sdk_release(r112, r6);
        if (r12 != r7) goto L28;
        return r7;
    L28:
        r14 = r1;
        r9 = r23;
        goto L29
    L18:
        ResultKt.throwOnFailure(r5);
        r11 = Math.max(r1, 0);
        r111 = System.currentTimeMillis() + r11;
        long r25 = r0.remainMs(r111);
        r6.L$0 = r0;
        r6.J$0 = r1;
        r6.J$1 = r11;
        r6.J$2 = r111;
        r6.label = 1;
        r22 = r0.waitForConnector(r25, r6);
        if (r22 != r7) goto L21;
        return r7;
    L7:
        r6 = new AIKernelApi$getMainProcessIpcBinding$1(r0, r4);
        goto L8
    }

    @Override // com.obric.aikernel.phx.sdk.IAIKernelManager
    /* JADX INFO: renamed from: getPackage-0E7RQCE */
    public Object mo188getPackage0E7RQCE(String r10, RequestParams r11, Continuation<? super Result<PackageResource>> r12) {
        Continuation r13 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r12, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r13, AIKernelApi$getPackage$1.class) == false) goto L7;
        AIKernelApi$getPackage$1 r0 = (AIKernelApi$getPackage$1) ZeusTransformUtils.preCheckCast(r13, AIKernelApi$getPackage$1.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        AIKernelApi$getPackage$1 r6 = r0;
        Object r14 = r6.result;
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r6.label;
        if (r2 == 0) goto L14;
        if (r2 != 1) goto L13;
        ResultKt.throwOnFailure(r14);
    L17:
        Result r9 = (Result) ZeusTransformUtils.preCheckCast(r14, Result.class, "com.obric.memorydata.plugin");
        if (r9 != null) goto L22;
        Result.Companion r15 = Result.Companion;
        return Result.m1421constructorimpl(ResultKt.createFailure((Throwable) ZeusTransformUtils.preCheckCast(new AIKernelException(108, "[SDK] expect non-null result.", null, 0, 12, null), Throwable.class, "com.obric.memorydata.plugin")));
    L22:
        return r9.m1430unboximpl();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r14);
        Function1 r5 = (Function1) ZeusTransformUtils.preCheckCast(new AIKernelApi$getPackage$2(this, r10, r11, null), Function1.class, "com.obric.memorydata.plugin");
        r6.label = 1;
        r14 = wrapApiCall$default(this, r11, null, r5, r6, 2, null);
        if (r14 != r1) goto L17;
        return r1;
    L7:
        r0 = new AIKernelApi$getPackage$1(this, r13);
        goto L8
    }

    public final synchronized void init(AIKernelConfig r10, ILog r11) {
        monitor-enter(this);
        ILog r12 = (ILog) ZeusTransformUtils.wrapperContextForParams(r11, ILog.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L60
        Intrinsics.checkNotNullParameter(r10, "config");     // Catch: Throwable -> L60
        if (this.connector == null) goto L8;
        AIKLog.INSTANCE.d(TAG, "sdk is already inited!");     // Catch: Throwable -> L60
        monitor-exit(this);
        return;
    L8:
        com.obric.aikernel.core.a.f5987a.a(r10);     // Catch: Throwable -> L60
        com.obric.aikernel.core.a.f5987a.a(BuildConfig.SDK_VERSION);     // Catch: Throwable -> L60
        com.obric.aikernel.core.a.f5987a.a(r10.getAuthBySign());     // Catch: Throwable -> L60
        if (r12 == null) goto L11;
        AIKLog.INSTANCE.registerLog(r12);     // Catch: Throwable -> L60
    L11:
        ComponentName r13 = new ComponentName("com.obric.aikernel", "com.obric.aikernel.AIKernelService");     // Catch: Throwable -> L60
        String r0 = "com.obric.aikernel";
        boolean r1 = true;
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L35
        AIKernelApi r5 = (AIKernelApi) ZeusTransformUtils.preCheckCast(this, AIKernelApi.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L35
        ComponentName r6 = new ComponentName("com.larus.nova", "com.obric.aikernel.AIKernelService");     // Catch: Throwable -> L35
        PackageManager r7 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r10.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getPackageManager();     // Catch: Throwable -> L35
        Intent r8 = new Intent();     // Catch: Throwable -> L35
        r8.setComponent(r6);     // Catch: Throwable -> L35
        Collection r9 = (Collection) ZeusTransformUtils.preCheckCast(r7.queryIntentServices(r8, 131072), Collection.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L35
        if (r9 != null) goto L16;
    L19:
        boolean r14 = true;
    L20:
        if (r14 == false) goto L66;
        PackageInfo r15 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r10.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getPackageManager().getPackageInfo("com.obric.aikernel", 0);     // Catch: Throwable -> L35
        if (r15 == null) goto L28;
        Intrinsics.checkNotNullExpressionValue(r15, "getPackageInfo(IAIKernel…ager.PACKAGE_NAME_AIK, 0)");     // Catch: Throwable -> L35
        if (r15.getLongVersionCode() < 200000999) goto L26;
        r5.legacyArch = false;     // Catch: Throwable -> L35
    L26:
        Unit r16 = Unit.INSTANCE;     // Catch: Throwable -> L35
    L31:
        Object r17 = Result.m1421constructorimpl(r16);     // Catch: Throwable -> L35
    L37:
        Throwable r18 = Result.m1424exceptionOrNullimpl(r17);     // Catch: Throwable -> L60
        if (r18 == null) goto L40;
        AIKLog.INSTANCE.e(TAG, "getServicePackageInfo failed: " + ExceptionsKt.stackTraceToString(r18));     // Catch: Throwable -> L60
    L40:
        ServiceConnector r19 = (ServiceConnector) ZeusTransformUtils.preCheckCast(this.serviceConnectorFactory.invoke((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r10.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r10, r13), ServiceConnector.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L60
        this.connector = r19;     // Catch: Throwable -> L60
        if (r19 != null) goto L44;
        Intrinsics.throwUninitializedPropertyAccessException("connector");     // Catch: Throwable -> L60
        r19 = null;
    L44:
        if (this.legacyArch == false) goto L47;
        r1 = false;
    L47:
        r19.setMainServiceIdleReleaseEnabled$sdk_release(r1);     // Catch: Throwable -> L60
        this.servicePackageName = r0;     // Catch: Throwable -> L60
        if (this.connectorReady.q_() == true) goto L54;
        w<ServiceConnector> r110 = this.connectorReady;     // Catch: Throwable -> L60
        ServiceConnector r2 = this.connector;     // Catch: Throwable -> L60
        if (r2 != null) goto L52;
        Intrinsics.throwUninitializedPropertyAccessException("connector");     // Catch: Throwable -> L60
        r2 = null;
    L52:
        r110.a(r2);     // Catch: Throwable -> L60
    L54:
        if (r10.getBindRemoteOnInit() == false) goto L56;
        i.a(this.transactScope, null, null, (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass5(this, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);     // Catch: Throwable -> L60
    L57:
        AIKLog.INSTANCE.i(TAG, "initialize success.");     // Catch: Throwable -> L60
        monitor-exit(this);
        return;
    L56:
        AIKLog.INSTANCE.d(TAG, "skip remote bind on init by config.");     // Catch: Throwable -> L60
        goto L57
    L28:
        r16 = null;
        goto L31
    L66:
        r0 = "com.larus.nova";
        r5.legacyArch = false;     // Catch: Throwable -> L33
        r16 = Unit.INSTANCE;     // Catch: Throwable -> L33
        r13 = r6;
    L33:
        th = th;
        r13 = r6;
    L36:
        Result.Companion r20 = Result.Companion;     // Catch: Throwable -> L60
        r17 = Result.m1421constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L60
        goto L37
    L16:
        if (r9.isEmpty() == true) goto L19;
        r14 = false;
    L35:
        th = th;
    L60:
        th = move-exception;
        throw th;
    }

    @Override // com.obric.aikernel.phx.sdk.IAIKernelManager
    public Object loadPackage(String r14, boolean r15, RequestParams r16, Continuation<? super IBaseModel> r17) {
        Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r17, Continuation.class, "com.obric.memorydata.plugin");
        return wrapApiCall$default(this, r16, null, (Function1) ZeusTransformUtils.preCheckCast(new AnonymousClass2(r15, r14, this, r16, null), Function1.class, "com.obric.memorydata.plugin"), r6, 2, null);
    }

    public final void setLegacyArch(boolean r1) {
        this.legacyArch = r1;
    }

    @Override // com.obric.aikernel.phx.sdk.IAIKernelManager
    /* JADX INFO: renamed from: updatePackage-0E7RQCE */
    public Object mo189updatePackage0E7RQCE(PackageResource r10, RequestParams r11, Continuation<? super Result<PackageResource>> r12) {
        Continuation r13 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r12, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r13, AIKernelApi$updatePackage$1.class) == false) goto L7;
        AIKernelApi$updatePackage$1 r0 = (AIKernelApi$updatePackage$1) ZeusTransformUtils.preCheckCast(r13, AIKernelApi$updatePackage$1.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        AIKernelApi$updatePackage$1 r6 = r0;
        Object r14 = r6.result;
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r6.label;
        if (r2 == 0) goto L14;
        if (r2 != 1) goto L13;
        ResultKt.throwOnFailure(r14);
    L17:
        Result r9 = (Result) ZeusTransformUtils.preCheckCast(r14, Result.class, "com.obric.memorydata.plugin");
        if (r9 != null) goto L22;
        Result.Companion r15 = Result.Companion;
        return Result.m1421constructorimpl(ResultKt.createFailure((Throwable) ZeusTransformUtils.preCheckCast(new AIKernelException(108, "[SDK] expect non-null result.", null, 0, 12, null), Throwable.class, "com.obric.memorydata.plugin")));
    L22:
        return r9.m1430unboximpl();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r14);
        Function1 r5 = (Function1) ZeusTransformUtils.preCheckCast(new AIKernelApi$updatePackage$2(this, r10, r11, null), Function1.class, "com.obric.memorydata.plugin");
        r6.label = 1;
        r14 = wrapApiCall$default(this, r11, null, r5, r6, 2, null);
        if (r14 != r1) goto L17;
        return r1;
    L7:
        r0 = new AIKernelApi$updatePackage$1(this, r13);
        goto L8
    }

    public final <T> Object wrapApiCall(final RequestParams r12, a r13, Function1<? super Continuation<? super T>, ? extends Object> r14, Continuation<? super T> r15) {
        final a r16 = (a) ZeusTransformUtils.wrapperContextForParams(r13, a.class, "com.obric.memorydata.plugin");
        Function1 r17 = (Function1) ZeusTransformUtils.wrapperContextForParams(r14, Function1.class, "com.obric.memorydata.plugin");
        Continuation<? super T> r18 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r15, Continuation.class, "com.obric.memorydata.plugin");
        long r2 = r12.getTimeout();
        final ar r19 = i.b(this.transactScope, null, null, (Function2) ZeusTransformUtils.preCheckCast(new AIKernelApi$wrapApiCall$ipcJob$1(r12, r17, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        bx r0 = (bx) ZeusTransformUtils.preCheckCast(r18.getContext().get((CoroutineContext.Key) ZeusTransformUtils.preCheckCast(bx.f17252a, CoroutineContext.Key.class, "com.obric.memorydata.plugin")), bx.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L5;
        r0.a((Function1) ZeusTransformUtils.preCheckCast(new C10082(this, r19, r16, r12), Function1.class, "com.obric.memorydata.plugin"));
    L5:
        AIKernelApi r11 = (AIKernelApi) ZeusTransformUtils.preCheckCast(this, AIKernelApi.class, "com.obric.memorydata.plugin");
        if (r2 <= 0) goto L9;
        return da.b(r2, (Function2) ZeusTransformUtils.preCheckCast(new AIKernelApi$wrapApiCall$3$1(r19, null), Function2.class, "com.obric.memorydata.plugin"), r18);
    L9:
        return r19.a(r18);
    }
}
