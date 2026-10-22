package com.obric.capabilitykit;

import android.app.Application;
import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import androidx.core.app.NotificationCompat;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.capabilitykit.apphost.AppHost;
import com.obric.capabilitykit.common.DispatchContext;
import com.obric.capabilitykit.common.FloatingIntentParams;
import com.obric.capabilitykit.common.IMAppAction;
import com.obric.capabilitykit.common.TaskStateInfo;
import com.obric.capabilitykit.common.execution.fileaccess.IUriFileReceiver;
import com.obric.capabilitykit.common.execution.fileaccess.UriFileAccessSession;
import com.obric.capabilitykit.common.intent.IntentFunction;
import com.obric.capabilitykit.common.intent.IntentResult;
import com.obric.capabilitykit.entity.EntityInitParam;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import com.obric.capabilitykit.logger.ILogger;
import com.obric.capabilitykit.logger.Logger;
import com.obric.capabilitykit.sync.EntitySyncDataSupplier;
import com.obric.memorydata.middleware.impl.bdtracker.TrackerImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000æ\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010$\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001:\u0002stB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0015\u001a\u00020\f2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0007J\u0010\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u0012H\u0002J\u001c\u0010\u0019\u001a\u00020\f2\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\f0\u001bH\u0002J\b\u0010\u001c\u001a\u00020\u001dH\u0002J\b\u0010\u001e\u001a\u00020\fH\u0002J\u000e\u0010\u001f\u001a\u00020\f2\u0006\u0010 \u001a\u00020!J\b\u0010\"\u001a\u00020\u0014H\u0002J+\u0010#\u001a\u0004\u0018\u00010$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010+J \u0010,\u001a\u0004\u0018\u00010$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*J\u000e\u0010-\u001a\u00020\f2\u0006\u0010 \u001a\u00020!J\u0010\u0010.\u001a\u00020\f2\u0006\u0010/\u001a\u000200H\u0007J\u0015\u00101\u001a\u0004\u0018\u00010\u000f2\u0006\u0010 \u001a\u00020!¢\u0006\u0002\u00102J\u0011\u00103\u001a\u00020\u000fH\u0086@ø\u0001\u0000¢\u0006\u0002\u00104J\r\u00105\u001a\u00020\fH\u0000¢\u0006\u0002\b6J\r\u00107\u001a\u00020\fH\u0000¢\u0006\u0002\b8J!\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020\b2\u0006\u0010<\u001a\u00020=H\u0087@ø\u0001\u0000¢\u0006\u0002\u0010>JE\u0010?\u001a\u00020\u00042\u0006\u0010@\u001a\u00020A2\u0006\u0010<\u001a\u00020=2\"\u0010B\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020D\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0E\u0012\u0006\u0012\u0004\u0018\u00010\u00010CH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010FJE\u0010G\u001a\u00020\u00042\u0006\u0010;\u001a\u00020\b2\u0006\u0010<\u001a\u00020=2\"\u0010B\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020D\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0E\u0012\u0006\u0012\u0004\u0018\u00010\u00010CH\u0087@ø\u0001\u0000¢\u0006\u0002\u0010HJ$\u0010I\u001a\u00020\f2\u000e\u0010J\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030K2\n\b\u0002\u0010L\u001a\u0004\u0018\u00010\bH\u0007J\u000e\u0010M\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020NJ\u0016\u0010O\u001a\u00020\f2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0007J9\u0010P\u001a\u00020\f2\u0006\u0010Q\u001a\u00020\b2\u0006\u0010R\u001a\u00020S2\n\b\u0002\u0010T\u001a\u0004\u0018\u00010U2\n\b\u0002\u0010V\u001a\u0004\u0018\u00010!H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010WJ%\u0010X\u001a\u00020\f2\u0006\u0010<\u001a\u00020=2\u0006\u0010;\u001a\u00020\b2\u0006\u0010Y\u001a\u00020ZH\u0000¢\u0006\u0002\b[J\u0015\u0010\\\u001a\u00020\f2\u0006\u0010T\u001a\u00020]H\u0000¢\u0006\u0002\b^J!\u0010_\u001a\u00020\f2\n\u0010T\u001a\u0006\u0012\u0002\b\u00030`2\u0006\u0010a\u001a\u00020]H\u0000¢\u0006\u0002\bbJ\u0010\u0010c\u001a\u00020\f2\u0006\u0010d\u001a\u00020eH\u0007J\u0015\u0010f\u001a\u00020\f2\u0006\u0010g\u001a\u00020\u000fH\u0000¢\u0006\u0002\bhJ\u001e\u0010i\u001a\u00020\f2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*J\u001d\u0010j\u001a\u00020\f2\u0006\u0010<\u001a\u00020=2\u0006\u0010;\u001a\u00020\bH\u0000¢\u0006\u0002\bkJ\u0018\u0010l\u001a\u00020\f2\u000e\u0010J\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030KH\u0007J\u000e\u0010m\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020NJ\"\u0010n\u001a\u00020\f2\n\u0010T\u001a\u0006\u0012\u0002\b\u00030`2\u0006\u0010o\u001a\u00020&2\u0006\u0010p\u001a\u00020\u000fJ:\u0010n\u001a\u00020\f2\n\u0010T\u001a\u0006\u0012\u0002\b\u00030`2\u0006\u0010 \u001a\u00020!2\u0006\u0010p\u001a\u00020\u000f2\u0016\b\u0002\u0010q\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010rR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006u"}, d2 = {"Lcom/obric/capabilitykit/AtomicCapabilitySdk;", "", "()V", "ERROR_INVALID_ACTION_NAME", "", "ERROR_NO_ERROR", "MAX_PENDING_FUN_CALL", "TAG", "", "connectionListeners", "Ljava/util/concurrent/CopyOnWriteArraySet;", "Lkotlin/Function0;", "", "extBindFlags", "mPendingCallsExecuted", "", "mPendingCals", "", "Lcom/obric/capabilitykit/AtomicCapabilitySdk$ApiCall;", "mSendResultApi", "Lcom/obric/capabilitykit/AbstractCapabilityManager;", "addConnectionListener", "listener", "addPendingCall", NotificationCompat.CATEGORY_CALL, "callOrAddPendingCall", "func", "Lkotlin/Function1;", "checkInit", "Landroid/app/Application;", "execPendingCalls", "finishFloatingActivity", "questionId", "", "getApi", "getFloatingPendingIntent", "Landroid/app/PendingIntent;", "context", "Lcom/obric/capabilitykit/common/DispatchContext;", MemorySourceLinkType.INTENT, "Landroid/content/Intent;", TrackerImpl.PARAMS, "Lcom/obric/capabilitykit/common/FloatingIntentParams;", "(Lcom/obric/capabilitykit/common/DispatchContext;Landroid/content/Intent;Lcom/obric/capabilitykit/common/FloatingIntentParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getFloatingPendingIntentNonBlock", "hideIntentResultCard", CommonConsts.APM_INNER_EVENT_COST_INIT, "config", "Lcom/obric/capabilitykit/AtomicCapabilitySdk$InitConfig;", "isCardViewVisible", "(J)Ljava/lang/Boolean;", "isKeyguardReallyLocked", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onApiInitComplete", "onApiInitComplete$capabilitykit_release", "onConnectionClosed", "onConnectionClosed$capabilitykit_release", "openFileDescriptorPrivileged", "Lcom/obric/capabilitykit/common/execution/fileaccess/UriFileAccessSession;", ObricMemoryConstants.KEY_PACKAGE_NAME, "uri", "Landroid/net/Uri;", "(Ljava/lang/String;Landroid/net/Uri;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "openInputStream", "entity", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "onGranted", "Lkotlin/Function2;", "Ljava/io/InputStream;", "Lkotlin/coroutines/Continuation;", "(Lcom/obric/capabilitykit/entity/app/AppEntity;Landroid/net/Uri;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "openInputStreamPrivileged", "(Ljava/lang/String;Landroid/net/Uri;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "registerIntent", "function", "Lcom/obric/capabilitykit/common/intent/IntentFunction;", "serviceName", "registerResultCallback", "Lcom/obric/capabilitykit/ErrorCodeCallback;", "removeConnectionListener", "requestStateChanged", OaidModel.KEY_ID, "stateInfo", "Lcom/obric/capabilitykit/common/TaskStateInfo;", "result", "Lcom/obric/capabilitykit/TaskStateChangeCallback;", LocationMonitorConst.TIMEOUT, "(Ljava/lang/String;Lcom/obric/capabilitykit/common/TaskStateInfo;Lcom/obric/capabilitykit/TaskStateChangeCallback;Ljava/lang/Long;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requestUriFileAccess", "requester", "Lcom/obric/capabilitykit/common/execution/fileaccess/IUriFileReceiver;", "requestUriFileAccess$capabilitykit_release", "sendActionExecuteResult", "Lcom/obric/capabilitykit/common/IMAppAction;", "sendActionExecuteResult$capabilitykit_release", "sendIntentExecutionResult", "Lcom/obric/capabilitykit/common/intent/IntentResult;", "oldResult", "sendIntentExecutionResult$capabilitykit_release", "setLogger", "logger", "Lcom/obric/capabilitykit/logger/ILogger;", "setPendingCallsExecuted", "isExecuted", "setPendingCallsExecuted$capabilitykit_release", "startFloatingActivity", "stopUriFileAccess", "stopUriFileAccess$capabilitykit_release", "unregisterIntent", "unregisterResultCallback", "updateIntentResult", "dispatchContext", "isStatusChange", "ext", "", "ApiCall", "InitConfig", "capabilitykit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class AtomicCapabilitySdk {
    public static final int ERROR_INVALID_ACTION_NAME = -1;
    public static final int ERROR_NO_ERROR = 0;
    public static final AtomicCapabilitySdk INSTANCE = null;
    private static final int MAX_PENDING_FUN_CALL = 1024;
    public static final String TAG = "AtomicCapabilitySdk";
    private static final CopyOnWriteArraySet<Function0<Unit>> connectionListeners = null;
    private static int extBindFlags;
    private static boolean mPendingCallsExecuted;
    private static final List<a> mPendingCals = null;
    private static com.obric.capabilitykit.a mSendResultApi;

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\tHÆ\u0003J\t\u0010\u001b\u001a\u00020\u000bHÆ\u0003JA\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020\u000bHÖ\u0001J\t\u0010!\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006\""}, d2 = {"Lcom/obric/capabilitykit/AtomicCapabilitySdk$InitConfig;", "", "app", "Landroid/app/Application;", "entitySupplier", "Lcom/obric/capabilitykit/EntitySupplier;", "entityProcessName", "", "entitySyncDataSupplier", "Lcom/obric/capabilitykit/sync/EntitySyncDataSupplier;", "extBindFlags", "", "(Landroid/app/Application;Lcom/obric/capabilitykit/EntitySupplier;Ljava/lang/String;Lcom/obric/capabilitykit/sync/EntitySyncDataSupplier;I)V", "getApp", "()Landroid/app/Application;", "getEntityProcessName", "()Ljava/lang/String;", "getEntitySupplier", "()Lcom/obric/capabilitykit/EntitySupplier;", "getEntitySyncDataSupplier", "()Lcom/obric/capabilitykit/sync/EntitySyncDataSupplier;", "getExtBindFlags", "()I", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "capabilitykit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class InitConfig {
        private final Application app;
        private final String entityProcessName;
        private final EntitySupplier entitySupplier;
        private final EntitySyncDataSupplier entitySyncDataSupplier;
        private final int extBindFlags;

        public InitConfig(Application r3, EntitySupplier r4, String r5, EntitySyncDataSupplier r6, int r7) {
            Application r8 = (Application) ZeusTransformUtils.wrapperContextForParams(r3, Application.class, "com.obric.memorydata.plugin");
            EntitySupplier r9 = (EntitySupplier) ZeusTransformUtils.wrapperContextForParams(r4, EntitySupplier.class, "com.obric.memorydata.plugin");
            EntitySyncDataSupplier r10 = (EntitySyncDataSupplier) ZeusTransformUtils.wrapperContextForParams(r6, EntitySyncDataSupplier.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r8, "app");
            this.app = r8;
            this.entitySupplier = r9;
            this.entityProcessName = r5;
            this.entitySyncDataSupplier = r10;
            this.extBindFlags = r7;
        }

        public /* synthetic */ InitConfig(Application r4, EntitySupplier r5, String r6, EntitySyncDataSupplier r7, int r8, int r9, DefaultConstructorMarker r10) {
            Application r11 = (Application) ZeusTransformUtils.wrapperContextForParams(r4, Application.class, "com.obric.memorydata.plugin");
            EntitySupplier r12 = (EntitySupplier) ZeusTransformUtils.wrapperContextForParams(r5, EntitySupplier.class, "com.obric.memorydata.plugin");
            EntitySyncDataSupplier r13 = (EntitySyncDataSupplier) ZeusTransformUtils.wrapperContextForParams(r7, EntitySyncDataSupplier.class, "com.obric.memorydata.plugin");
            EntitySyncDataSupplier r0 = null;
            if ((r9 & 2) == 0) goto L5;
            EntitySupplier r14 = null;
        L7:
            if ((r9 & 4) == 0) goto L9;
            String r1 = null;
        L11:
            if ((r9 & 8) != 0) goto L15;
            r0 = r13;
        L15:
            if ((r9 & 16) == 0) goto L17;
            r8 = 0;
        L17:
            this(r11, r14, r1, r0, r8);
            return;
        L9:
            r1 = r6;
            goto L11
        L5:
            r14 = r12;
            goto L7
        }

        public static /* synthetic */ InitConfig copy$default(InitConfig r6, Application r7, EntitySupplier r8, String r9, EntitySyncDataSupplier r10, int r11, int r12, Object r13) {
            Application r14 = (Application) ZeusTransformUtils.wrapperContextForParams(r7, Application.class, "com.obric.memorydata.plugin");
            EntitySupplier r15 = (EntitySupplier) ZeusTransformUtils.wrapperContextForParams(r8, EntitySupplier.class, "com.obric.memorydata.plugin");
            EntitySyncDataSupplier r16 = (EntitySyncDataSupplier) ZeusTransformUtils.wrapperContextForParams(r10, EntitySyncDataSupplier.class, "com.obric.memorydata.plugin");
            if ((r12 & 1) == 0) goto L5;
            r14 = r6.app;
        L5:
            Application r1 = r14;
            if ((r12 & 2) == 0) goto L8;
            r15 = r6.entitySupplier;
        L8:
            EntitySupplier r2 = r15;
            if ((r12 & 4) == 0) goto L11;
            r9 = r6.entityProcessName;
        L11:
            String r3 = r9;
            if ((r12 & 8) == 0) goto L14;
            r16 = r6.entitySyncDataSupplier;
        L14:
            EntitySyncDataSupplier r4 = r16;
            if ((r12 & 16) == 0) goto L18;
            r11 = r6.extBindFlags;
        L18:
            return r6.copy(r1, r2, r3, r4, r11);
        }

        public final Application component1() {
            return this.app;
        }

        public final EntitySupplier component2() {
            return this.entitySupplier;
        }

        public final String component3() {
            return this.entityProcessName;
        }

        public final EntitySyncDataSupplier component4() {
            return this.entitySyncDataSupplier;
        }

        public final int component5() {
            return this.extBindFlags;
        }

        public final InitConfig copy(Application r8, EntitySupplier r9, String r10, EntitySyncDataSupplier r11, int r12) {
            Application r2 = (Application) ZeusTransformUtils.wrapperContextForParams(r8, Application.class, "com.obric.memorydata.plugin");
            EntitySupplier r3 = (EntitySupplier) ZeusTransformUtils.wrapperContextForParams(r9, EntitySupplier.class, "com.obric.memorydata.plugin");
            EntitySyncDataSupplier r5 = (EntitySyncDataSupplier) ZeusTransformUtils.wrapperContextForParams(r11, EntitySyncDataSupplier.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r2, "app");
            return new InitConfig(r2, r3, r10, r5, r12);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, InitConfig.class) == true) goto L8;
            return false;
        L8:
            InitConfig r6 = (InitConfig) ZeusTransformUtils.preCheckCast(r5, InitConfig.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.app, r6.app) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.entitySupplier, r6.entitySupplier) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.entityProcessName, r6.entityProcessName) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.entitySyncDataSupplier, r6.entitySyncDataSupplier) == true) goto L21;
            return false;
        L21:
            if (this.extBindFlags == r6.extBindFlags) goto L23;
            return false;
        L23:
            return true;
        }

        public final Application getApp() {
            return this.app;
        }

        public final String getEntityProcessName() {
            return this.entityProcessName;
        }

        public final EntitySupplier getEntitySupplier() {
            return this.entitySupplier;
        }

        public final EntitySyncDataSupplier getEntitySyncDataSupplier() {
            return this.entitySyncDataSupplier;
        }

        public final int getExtBindFlags() {
            return this.extBindFlags;
        }

        public int hashCode() {
            int r0 = this.app.hashCode() * 31;
            EntitySupplier r1 = this.entitySupplier;
            int r2 = 0;
            if (r1 != null) goto L5;
            int r3 = 0;
        L6:
            int r4 = (r0 + r3) * 31;
            String r5 = this.entityProcessName;
            if (r5 != null) goto L9;
            int r6 = 0;
        L10:
            int r7 = (r4 + r6) * 31;
            EntitySyncDataSupplier r8 = this.entitySyncDataSupplier;
            if (r8 == null) goto L15;
            r2 = r8.hashCode();
        L15:
            return ((r7 + r2) * 31) + Integer.hashCode(this.extBindFlags);
        L9:
            r6 = r5.hashCode();
            goto L10
        L5:
            r3 = r1.hashCode();
            goto L6
        }

        public String toString() {
            return "InitConfig(app=" + this.app + ", entitySupplier=" + this.entitySupplier + ", entityProcessName=" + this.entityProcessName + ", entitySyncDataSupplier=" + this.entitySyncDataSupplier + ", extBindFlags=" + this.extBindFlags + ')';
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bb\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/obric/capabilitykit/AtomicCapabilitySdk$ApiCall;", "", NotificationCompat.CATEGORY_CALL, "", "capabilitykit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public interface a {
        void a();
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/obric/capabilitykit/AtomicCapabilitySdk$callOrAddPendingCall$1", "Lcom/obric/capabilitykit/AtomicCapabilitySdk$ApiCall;", NotificationCompat.CATEGORY_CALL, "", "capabilitykit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class b implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1<com.obric.capabilitykit.a, Unit> f7419a;

        public b(Function1<? super com.obric.capabilitykit.a, Unit> r3) {
            this.f7419a = (Function1) ZeusTransformUtils.wrapperContextForParams(r3, Function1.class, "com.obric.memorydata.plugin");
        }

        @Override // com.obric.capabilitykit.AtomicCapabilitySdk.a
        public void a() {
            this.f7419a.invoke(AtomicCapabilitySdk.access$getApi(AtomicCapabilitySdk.INSTANCE));
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/obric/capabilitykit/AbstractCapabilityManager;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class c extends Lambda implements Function1<com.obric.capabilitykit.a, Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f7420a;

        public c(long r1) {
            this.f7420a = r1;
            super(1);
        }

        public final void a(com.obric.capabilitykit.a r3) {
            Intrinsics.checkNotNullParameter((com.obric.capabilitykit.a) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.capabilitykit.a.class, "com.obric.memorydata.plugin"), "it");
            AtomicCapabilitySdk.access$getApi(AtomicCapabilitySdk.INSTANCE).b(this.f7420a);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* synthetic */ Unit invoke(com.obric.capabilitykit.a r3) {
            a((com.obric.capabilitykit.a) ZeusTransformUtils.preCheckCast(r3, com.obric.capabilitykit.a.class, "com.obric.memorydata.plugin"));
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/obric/capabilitykit/AbstractCapabilityManager;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class d extends Lambda implements Function1<com.obric.capabilitykit.a, Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Continuation<PendingIntent> f7421a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ DispatchContext f7422b;
        public final /* synthetic */ Intent c;
        public final /* synthetic */ FloatingIntentParams d;

        public d(Continuation<? super PendingIntent> r3, DispatchContext r4, Intent r5, FloatingIntentParams r6) {
            this.f7421a = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            this.f7422b = r4;
            this.c = r5;
            this.d = r6;
            super(1);
        }

        public final void a(com.obric.capabilitykit.a r4) {
            Intrinsics.checkNotNullParameter((com.obric.capabilitykit.a) ZeusTransformUtils.wrapperContextForParams(r4, com.obric.capabilitykit.a.class, "com.obric.memorydata.plugin"), "it");
            this.f7421a.resumeWith(Result.m1421constructorimpl(AtomicCapabilitySdk.INSTANCE.getFloatingPendingIntentNonBlock(this.f7422b, this.c, this.d)));
        }

        @Override // kotlin.jvm.functions.Function1
        public /* synthetic */ Unit invoke(com.obric.capabilitykit.a r3) {
            a((com.obric.capabilitykit.a) ZeusTransformUtils.preCheckCast(r3, com.obric.capabilitykit.a.class, "com.obric.memorydata.plugin"));
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/obric/capabilitykit/AbstractCapabilityManager;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class e extends Lambda implements Function1<com.obric.capabilitykit.a, Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f7423a;

        public e(long r1) {
            this.f7423a = r1;
            super(1);
        }

        public final void a(com.obric.capabilitykit.a r3) {
            Intrinsics.checkNotNullParameter((com.obric.capabilitykit.a) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.capabilitykit.a.class, "com.obric.memorydata.plugin"), "it");
            AtomicCapabilitySdk.access$getApi(AtomicCapabilitySdk.INSTANCE).a(this.f7423a);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* synthetic */ Unit invoke(com.obric.capabilitykit.a r3) {
            a((com.obric.capabilitykit.a) ZeusTransformUtils.preCheckCast(r3, com.obric.capabilitykit.a.class, "com.obric.memorydata.plugin"));
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/obric/capabilitykit/AbstractCapabilityManager;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class f extends Lambda implements Function1<com.obric.capabilitykit.a, Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Continuation<Boolean> f7424a;

        public f(Continuation<? super Boolean> r3) {
            this.f7424a = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            super(1);
        }

        public final void a(com.obric.capabilitykit.a r3) {
            Intrinsics.checkNotNullParameter((com.obric.capabilitykit.a) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.capabilitykit.a.class, "com.obric.memorydata.plugin"), "it");
            this.f7424a.resumeWith(Result.m1421constructorimpl(Boolean.valueOf(AtomicCapabilitySdk.access$getApi(AtomicCapabilitySdk.INSTANCE).a())));
        }

        @Override // kotlin.jvm.functions.Function1
        public /* synthetic */ Unit invoke(com.obric.capabilitykit.a r3) {
            a((com.obric.capabilitykit.a) ZeusTransformUtils.preCheckCast(r3, com.obric.capabilitykit.a.class, "com.obric.memorydata.plugin"));
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/obric/capabilitykit/AbstractCapabilityManager;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class g extends Lambda implements Function1<com.obric.capabilitykit.a, Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IntentFunction<?, ?> f7425a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f7426b;

        public g(IntentFunction<?, ?> r3, String r4) {
            this.f7425a = (IntentFunction) ZeusTransformUtils.wrapperContextForParams(r3, IntentFunction.class, "com.obric.memorydata.plugin");
            this.f7426b = r4;
            super(1);
        }

        public final void a(com.obric.capabilitykit.a r4) {
            Intrinsics.checkNotNullParameter((com.obric.capabilitykit.a) ZeusTransformUtils.wrapperContextForParams(r4, com.obric.capabilitykit.a.class, "com.obric.memorydata.plugin"), "it");
            com.obric.capabilitykit.a r5 = AtomicCapabilitySdk.access$getApi(AtomicCapabilitySdk.INSTANCE);
            String r0 = this.f7425a.getName();
            String r1 = this.f7425a.getClass().getName();
            Intrinsics.checkNotNullExpressionValue(r1, "function.javaClass.name");
            r5.a(r0, r1, this.f7426b);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* synthetic */ Unit invoke(com.obric.capabilitykit.a r3) {
            a((com.obric.capabilitykit.a) ZeusTransformUtils.preCheckCast(r3, com.obric.capabilitykit.a.class, "com.obric.memorydata.plugin"));
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/obric/capabilitykit/AbstractCapabilityManager;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class h extends Lambda implements Function1<com.obric.capabilitykit.a, Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ErrorCodeCallback f7427a;

        public h(ErrorCodeCallback r1) {
            this.f7427a = r1;
            super(1);
        }

        public final void a(com.obric.capabilitykit.a r3) {
            Intrinsics.checkNotNullParameter((com.obric.capabilitykit.a) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.capabilitykit.a.class, "com.obric.memorydata.plugin"), "it");
            AtomicCapabilitySdk.access$getApi(AtomicCapabilitySdk.INSTANCE).b(this.f7427a);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* synthetic */ Unit invoke(com.obric.capabilitykit.a r3) {
            a((com.obric.capabilitykit.a) ZeusTransformUtils.preCheckCast(r3, com.obric.capabilitykit.a.class, "com.obric.memorydata.plugin"));
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/obric/capabilitykit/AbstractCapabilityManager;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class i extends Lambda implements Function1<com.obric.capabilitykit.a, Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f7428a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ TaskStateInfo f7429b;
        public final /* synthetic */ TaskStateChangeCallback c;
        public final /* synthetic */ Long d;

        public i(String r1, TaskStateInfo r2, TaskStateChangeCallback r3, Long r4) {
            this.f7428a = r1;
            this.f7429b = r2;
            this.c = r3;
            this.d = r4;
            super(1);
        }

        public final void a(com.obric.capabilitykit.a r4) {
            Intrinsics.checkNotNullParameter((com.obric.capabilitykit.a) ZeusTransformUtils.wrapperContextForParams(r4, com.obric.capabilitykit.a.class, "com.obric.memorydata.plugin"), "it");
            AtomicCapabilitySdk.access$getApi(AtomicCapabilitySdk.INSTANCE).a(this.f7428a, this.f7429b, this.c, this.d);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* synthetic */ Unit invoke(com.obric.capabilitykit.a r3) {
            a((com.obric.capabilitykit.a) ZeusTransformUtils.preCheckCast(r3, com.obric.capabilitykit.a.class, "com.obric.memorydata.plugin"));
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/obric/capabilitykit/AbstractCapabilityManager;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class j extends Lambda implements Function1<com.obric.capabilitykit.a, Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Uri f7430a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f7431b;
        public final /* synthetic */ IUriFileReceiver c;

        public j(Uri r3, String r4, IUriFileReceiver r5) {
            IUriFileReceiver r6 = (IUriFileReceiver) ZeusTransformUtils.wrapperContextForParams(r5, IUriFileReceiver.class, "com.obric.memorydata.plugin");
            this.f7430a = r3;
            this.f7431b = r4;
            this.c = r6;
            super(1);
        }

        public final void a(com.obric.capabilitykit.a r3) {
            Intrinsics.checkNotNullParameter((com.obric.capabilitykit.a) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.capabilitykit.a.class, "com.obric.memorydata.plugin"), "it");
            AtomicCapabilitySdk.access$getApi(AtomicCapabilitySdk.INSTANCE).a(this.f7430a, this.f7431b, this.c);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* synthetic */ Unit invoke(com.obric.capabilitykit.a r3) {
            a((com.obric.capabilitykit.a) ZeusTransformUtils.preCheckCast(r3, com.obric.capabilitykit.a.class, "com.obric.memorydata.plugin"));
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/obric/capabilitykit/AbstractCapabilityManager;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class k extends Lambda implements Function1<com.obric.capabilitykit.a, Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IMAppAction f7432a;

        public k(IMAppAction r1) {
            this.f7432a = r1;
            super(1);
        }

        public final void a(com.obric.capabilitykit.a r3) {
            Intrinsics.checkNotNullParameter((com.obric.capabilitykit.a) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.capabilitykit.a.class, "com.obric.memorydata.plugin"), "it");
            AtomicCapabilitySdk.access$getApi(AtomicCapabilitySdk.INSTANCE).a(this.f7432a);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* synthetic */ Unit invoke(com.obric.capabilitykit.a r3) {
            a((com.obric.capabilitykit.a) ZeusTransformUtils.preCheckCast(r3, com.obric.capabilitykit.a.class, "com.obric.memorydata.plugin"));
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/obric/capabilitykit/AbstractCapabilityManager;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class l extends Lambda implements Function1<com.obric.capabilitykit.a, Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IntentResult<?> f7433a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ IMAppAction f7434b;

        public l(IntentResult<?> r1, IMAppAction r2) {
            this.f7433a = r1;
            this.f7434b = r2;
            super(1);
        }

        public final void a(com.obric.capabilitykit.a r3) {
            Intrinsics.checkNotNullParameter((com.obric.capabilitykit.a) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.capabilitykit.a.class, "com.obric.memorydata.plugin"), "it");
            AtomicCapabilitySdk.access$getApi(AtomicCapabilitySdk.INSTANCE).a(this.f7433a, this.f7434b);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* synthetic */ Unit invoke(com.obric.capabilitykit.a r3) {
            a((com.obric.capabilitykit.a) ZeusTransformUtils.preCheckCast(r3, com.obric.capabilitykit.a.class, "com.obric.memorydata.plugin"));
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/obric/capabilitykit/AbstractCapabilityManager;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class m extends Lambda implements Function1<com.obric.capabilitykit.a, Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DispatchContext f7435a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Intent f7436b;
        public final /* synthetic */ FloatingIntentParams c;

        public m(DispatchContext r1, Intent r2, FloatingIntentParams r3) {
            this.f7435a = r1;
            this.f7436b = r2;
            this.c = r3;
            super(1);
        }

        public final void a(com.obric.capabilitykit.a r4) {
            Intrinsics.checkNotNullParameter((com.obric.capabilitykit.a) ZeusTransformUtils.wrapperContextForParams(r4, com.obric.capabilitykit.a.class, "com.obric.memorydata.plugin"), "it");
            PendingIntent r3 = AtomicCapabilitySdk.INSTANCE.getFloatingPendingIntentNonBlock(this.f7435a, this.f7436b, this.c);     // Catch: Exception -> L7 PendingIntent.CanceledException -> L9
            if (r3 == null) goto L15;
            r3.send();     // Catch: Exception -> L7 PendingIntent.CanceledException -> L9
        L16:
            return;
        L15:
            return;
        L9:
            e = move-exception;
            Logger r5 = Logger.INSTANCE;
            StringBuilder r1 = new StringBuilder().append("PendingIntent was canceled: ");
            String r6 = e.getMessage();
        L11:
            r5.e(AtomicCapabilitySdk.TAG, r1.append(r6).toString());
            return;
        L7:
            e = move-exception;
            r5 = Logger.INSTANCE;
            r1 = new StringBuilder().append("Error sending PendingIntent: ");
            r6 = e.getMessage();
            goto L11
        }

        @Override // kotlin.jvm.functions.Function1
        public /* synthetic */ Unit invoke(com.obric.capabilitykit.a r3) {
            a((com.obric.capabilitykit.a) ZeusTransformUtils.preCheckCast(r3, com.obric.capabilitykit.a.class, "com.obric.memorydata.plugin"));
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/obric/capabilitykit/AbstractCapabilityManager;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class n extends Lambda implements Function1<com.obric.capabilitykit.a, Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Uri f7437a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f7438b;

        public n(Uri r1, String r2) {
            this.f7437a = r1;
            this.f7438b = r2;
            super(1);
        }

        public final void a(com.obric.capabilitykit.a r3) {
            Intrinsics.checkNotNullParameter((com.obric.capabilitykit.a) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.capabilitykit.a.class, "com.obric.memorydata.plugin"), "it");
            AtomicCapabilitySdk.access$getApi(AtomicCapabilitySdk.INSTANCE).a(this.f7437a, this.f7438b);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* synthetic */ Unit invoke(com.obric.capabilitykit.a r3) {
            a((com.obric.capabilitykit.a) ZeusTransformUtils.preCheckCast(r3, com.obric.capabilitykit.a.class, "com.obric.memorydata.plugin"));
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/obric/capabilitykit/AbstractCapabilityManager;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class o extends Lambda implements Function1<com.obric.capabilitykit.a, Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IntentFunction<?, ?> f7439a;

        public o(IntentFunction<?, ?> r3) {
            this.f7439a = (IntentFunction) ZeusTransformUtils.wrapperContextForParams(r3, IntentFunction.class, "com.obric.memorydata.plugin");
            super(1);
        }

        public final void a(com.obric.capabilitykit.a r3) {
            Intrinsics.checkNotNullParameter((com.obric.capabilitykit.a) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.capabilitykit.a.class, "com.obric.memorydata.plugin"), "it");
            com.obric.capabilitykit.a r4 = AtomicCapabilitySdk.access$getApi(AtomicCapabilitySdk.INSTANCE);
            String r0 = this.f7439a.getName();
            String r2 = this.f7439a.getClass().getName();
            Intrinsics.checkNotNullExpressionValue(r2, "function.javaClass.name");
            r4.a(r0, r2);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* synthetic */ Unit invoke(com.obric.capabilitykit.a r3) {
            a((com.obric.capabilitykit.a) ZeusTransformUtils.preCheckCast(r3, com.obric.capabilitykit.a.class, "com.obric.memorydata.plugin"));
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/obric/capabilitykit/AbstractCapabilityManager;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class p extends Lambda implements Function1<com.obric.capabilitykit.a, Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ErrorCodeCallback f7440a;

        public p(ErrorCodeCallback r1) {
            this.f7440a = r1;
            super(1);
        }

        public final void a(com.obric.capabilitykit.a r3) {
            Intrinsics.checkNotNullParameter((com.obric.capabilitykit.a) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.capabilitykit.a.class, "com.obric.memorydata.plugin"), "it");
            AtomicCapabilitySdk.access$getApi(AtomicCapabilitySdk.INSTANCE).a(this.f7440a);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* synthetic */ Unit invoke(com.obric.capabilitykit.a r3) {
            a((com.obric.capabilitykit.a) ZeusTransformUtils.preCheckCast(r3, com.obric.capabilitykit.a.class, "com.obric.memorydata.plugin"));
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/obric/capabilitykit/AbstractCapabilityManager;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class q extends Lambda implements Function1<com.obric.capabilitykit.a, Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IntentResult<?> f7441a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long f7442b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ Map<String, String> d;

        public q(IntentResult<?> r3, long r4, boolean r6, Map<String, String> r7) {
            Map<String, String> r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r7, Map.class, "com.obric.memorydata.plugin");
            this.f7441a = r3;
            this.f7442b = r4;
            this.c = r6;
            this.d = r8;
            super(1);
        }

        public final void a(com.obric.capabilitykit.a r7) {
            Intrinsics.checkNotNullParameter((com.obric.capabilitykit.a) ZeusTransformUtils.wrapperContextForParams(r7, com.obric.capabilitykit.a.class, "com.obric.memorydata.plugin"), "it");
            AtomicCapabilitySdk.access$getApi(AtomicCapabilitySdk.INSTANCE).a(this.f7441a, this.f7442b, this.c, this.d);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* synthetic */ Unit invoke(com.obric.capabilitykit.a r3) {
            a((com.obric.capabilitykit.a) ZeusTransformUtils.preCheckCast(r3, com.obric.capabilitykit.a.class, "com.obric.memorydata.plugin"));
            return Unit.INSTANCE;
        }
    }

    static {
        INSTANCE = new AtomicCapabilitySdk();
        mPendingCals = new ArrayList();
        connectionListeners = new CopyOnWriteArraySet();
    }

    private AtomicCapabilitySdk() {
    }

    public static final /* synthetic */ com.obric.capabilitykit.a access$getApi(AtomicCapabilitySdk r0) {
        return r0.getApi();
    }

    @JvmStatic
    public static final void addConnectionListener(Function0<Unit> r2) {
        Function0<Unit> r3 = (Function0) ZeusTransformUtils.wrapperContextForParams(r2, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "listener");
        connectionListeners.add(r3);
    }

    private final void addPendingCall(a r4) {
        a r3 = (a) ZeusTransformUtils.wrapperContextForParams(r4, a.class, "com.obric.memorydata.plugin");
        Logger r5 = Logger.INSTANCE;
        r5.i(TAG, "addPendingCall");
        List<a> r0 = mPendingCals;
        monitor-enter(r0);
    L19:
        th = move-exception;
        throw th;
    L5:
        if (mPendingCallsExecuted == false) goto L10;
        r5.w(TAG, "in addPendingCall: pending-calls have all been executed; this call shall be execute RIGHT AWAY.");     // Catch: Throwable -> L19
        r3.a();     // Catch: Throwable -> L19
        monitor-exit(r0);
        return;
    L10:
        if (r0.size() <= 1024) goto L14;
        r5.w(TAG, "addPendingCall too may pending call, drop");     // Catch: Throwable -> L19
        monitor-exit(r0);
        return;
    L14:
        r0.add(r3);     // Catch: Throwable -> L19
        r5.i(TAG, "addPendingCall: queued, pendingSize=" + r0.size() + ", mPendingCallsExecuted=" + mPendingCallsExecuted);     // Catch: Throwable -> L19
        monitor-exit(r0);
    }

    private final void callOrAddPendingCall(Function1<? super com.obric.capabilitykit.a, Unit> r4) {
        Function1 r5 = (Function1) ZeusTransformUtils.wrapperContextForParams(r4, Function1.class, "com.obric.memorydata.plugin");
        com.obric.capabilitykit.a r0 = getApi();
        if (Intrinsics.areEqual(r0, com.obric.capabilitykit.f.f7587a) == true) goto L5;
        r5.invoke(r0);
        return;
    L5:
        Logger.INSTANCE.i(TAG, "callOrAddPendingCall: api unavailable (Empty), enqueue pending call");
        addPendingCall(new b(r5));
    }

    private final Application checkInit() {
        return (Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppHost.Companion.getApplication(), "com.obric.memorydata.plugin"), Application.class, "com.obric.memorydata.plugin");
    }

    private final void execPendingCalls() {
        Logger r5 = Logger.INSTANCE;
        r5.i(TAG, "execPendingCalls");
        List<a> r0 = mPendingCals;
        monitor-enter(r0);
        r5.i(TAG, "execPendingCalls: flush start, pendingSize=" + r0.size());     // Catch: Throwable -> L12
        Iterator<T> r6 = r0.iterator();     // Catch: Throwable -> L12
    L7:
        if (r6.hasNext() == false) goto L9;
        a r1 = (a) ZeusTransformUtils.preCheckCast(r6.next(), a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L12
        Logger.INSTANCE.i(TAG, "exec foreach call");     // Catch: Throwable -> L12
        r1.a();     // Catch: Throwable -> L12
        goto L7
    L9:
        mPendingCals.clear();     // Catch: Throwable -> L12
        mPendingCallsExecuted = true;     // Catch: Throwable -> L12
        monitor-exit(r0);
        return;
    L12:
        th = move-exception;
        throw th;
    }

    private final com.obric.capabilitykit.a getApi() {
        return com.obric.capabilitykit.c.f7476a.a(extBindFlags);
    }

    @JvmStatic
    public static final void init(InitConfig r5) {
        Intrinsics.checkNotNullParameter(r5, "config");
        Logger.INSTANCE.i(TAG, "AtomicCapabilitySdk init");
        AppHost.Companion.setAppHost(new com.obric.capabilitykit.l((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r5.getApp(), "com.obric.memorydata.plugin"), Application.class, "com.obric.memorydata.plugin")));
        EntityProvider.INSTANCE.init$capabilitykit_release(new EntityInitParam(r5.getEntitySupplier(), r5.getEntityProcessName(), r5.getEntitySyncDataSupplier()));
        extBindFlags = r5.getExtBindFlags();
    }

    @JvmStatic
    public static final void registerIntent(IntentFunction<?, ?> r4, String r5) {
        IntentFunction r6 = (IntentFunction) ZeusTransformUtils.wrapperContextForParams(r4, IntentFunction.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "function");
        AtomicCapabilitySdk r0 = INSTANCE;
        Application r1 = (Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r0.checkInit(), "com.obric.memorydata.plugin"), Application.class, "com.obric.memorydata.plugin");
        r0.callOrAddPendingCall(new g(r6, r5));
    }

    public static /* synthetic */ void registerIntent$default(IntentFunction r1, String r2, int r3, Object r4) {
        IntentFunction r5 = (IntentFunction) ZeusTransformUtils.wrapperContextForParams(r1, IntentFunction.class, "com.obric.memorydata.plugin");
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        registerIntent(r5, r2);
    }

    @JvmStatic
    public static final void removeConnectionListener(Function0<Unit> r2) {
        Function0 r3 = (Function0) ZeusTransformUtils.wrapperContextForParams(r2, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "listener");
        connectionListeners.remove(r3);
    }

    public static /* synthetic */ Object requestStateChanged$default(AtomicCapabilitySdk r6, String r7, TaskStateInfo r8, TaskStateChangeCallback r9, Long r10, Continuation r11, int r12, Object r13) {
        Continuation<? super Unit> r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r11, Continuation.class, "com.obric.memorydata.plugin");
        if ((r12 & 4) == 0) goto L5;
        TaskStateChangeCallback r3 = null;
    L7:
        if ((r12 & 8) == 0) goto L9;
        Long r4 = null;
    L11:
        return r6.requestStateChanged(r7, r8, r3, r4, r5);
    L9:
        r4 = r10;
        goto L11
    L5:
        r3 = r9;
        goto L7
    }

    @JvmStatic
    public static final void setLogger(ILogger r2) {
        ILogger r3 = (ILogger) ZeusTransformUtils.wrapperContextForParams(r2, ILogger.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "logger");
        Logger r0 = Logger.INSTANCE;
        r0.setLogger(r3);
        r0.i(TAG, "AtomicCapabilitySdk setLogger");
    }

    @JvmStatic
    public static final void unregisterIntent(IntentFunction<?, ?> r4) {
        IntentFunction r5 = (IntentFunction) ZeusTransformUtils.wrapperContextForParams(r4, IntentFunction.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "function");
        AtomicCapabilitySdk r0 = INSTANCE;
        Application r1 = (Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r0.checkInit(), "com.obric.memorydata.plugin"), Application.class, "com.obric.memorydata.plugin");
        r0.callOrAddPendingCall(new o(r5));
    }

    public static /* synthetic */ void updateIntentResult$default(AtomicCapabilitySdk r6, IntentResult r7, long r8, boolean r10, Map r11, int r12, Object r13) {
        Map<String, String> r14 = (Map) ZeusTransformUtils.wrapperContextForParams(r11, Map.class, "com.obric.memorydata.plugin");
        if ((r12 & 8) == 0) goto L5;
        r14 = null;
    L5:
        r6.updateIntentResult(r7, r8, r10, r14);
    }

    public final void finishFloatingActivity(long r2) {
        callOrAddPendingCall(new c(r2));
    }

    public final Object getFloatingPendingIntent(DispatchContext r3, Intent r4, FloatingIntentParams r5, Continuation<? super PendingIntent> r6) {
        Continuation r2 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
        SafeContinuation r7 = new SafeContinuation(IntrinsicsKt.intercepted(r2));
        INSTANCE.callOrAddPendingCall(new d(r7, r3, r4, r5));
        Object r8 = r7.getOrThrow();
        if (r8 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
        DebugProbesKt.probeCoroutineSuspended(r2);
    L5:
        return r8;
    }

    public final PendingIntent getFloatingPendingIntentNonBlock(DispatchContext r2, Intent r3, FloatingIntentParams r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, MemorySourceLinkType.INTENT);
        Intrinsics.checkNotNullParameter(r4, TrackerImpl.PARAMS);
        Long r1 = r2.getQuestionId();
        if (r1 == null) goto L5;
        long r5 = r1.longValue();
        return INSTANCE.getApi().a(r5, r3, r4);
    L5:
        return null;
    }

    public final void hideIntentResultCard(long r2) {
        callOrAddPendingCall(new e(r2));
    }

    public final Boolean isCardViewVisible(long r1) {
        return getApi().c(r1);
    }

    public final Object isKeyguardReallyLocked(Continuation<? super Boolean> r3) {
        Continuation r2 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
        SafeContinuation r4 = new SafeContinuation(IntrinsicsKt.intercepted(r2));
        INSTANCE.callOrAddPendingCall(new f(r4));
        Object r5 = r4.getOrThrow();
        if (r5 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
        DebugProbesKt.probeCoroutineSuspended(r2);
    L5:
        return r5;
    }

    public final void onApiInitComplete$capabilitykit_release() {
        execPendingCalls();
    }

    public final void onConnectionClosed$capabilitykit_release() {
        Iterator<T> r4 = connectionListeners.iterator();
    L4:
        if (r4.hasNext() == false) goto L13;
        ((Function0) ZeusTransformUtils.preCheckCast(r4.next(), Function0.class, "com.obric.memorydata.plugin")).invoke();     // Catch: Throwable -> L8
        Object r0 = Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L8
    L10:
        Throwable r1 = Result.m1424exceptionOrNullimpl(r0);
        if (r1 == null) goto L4;
        Logger.INSTANCE.e(TAG, "connectionListener throw exception: " + ExceptionsKt.stackTraceToString(r1));
    L8:
        th = move-exception;
        r0 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L10
    }

    @v
    public final Object openFileDescriptorPrivileged(String r2, Uri r3, Continuation<? super UriFileAccessSession> r4) {
        Continuation<? super UriFileAccessSession> r1 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        return w.f7636a.a(r2, r3, r1);
    }

    public final Object openInputStream(AppEntity r2, Uri r3, Function2<? super InputStream, ? super Continuation<? super Unit>, ? extends Object> r4, Continuation<? super Integer> r5) {
        Function2<? super InputStream, ? super Continuation<? super Unit>, ? extends Object> r1 = (Function2) ZeusTransformUtils.wrapperContextForParams(r4, Function2.class, "com.obric.memorydata.plugin");
        Continuation<? super Integer> r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        return w.f7636a.a(r2, r3, r1, r6);
    }

    @v
    public final Object openInputStreamPrivileged(String r2, Uri r3, Function2<? super InputStream, ? super Continuation<? super Unit>, ? extends Object> r4, Continuation<? super Integer> r5) {
        Function2<? super InputStream, ? super Continuation<? super Unit>, ? extends Object> r1 = (Function2) ZeusTransformUtils.wrapperContextForParams(r4, Function2.class, "com.obric.memorydata.plugin");
        Continuation<? super Integer> r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        return w.f7636a.a(r2, r3, r1, r6);
    }

    public final void registerResultCallback(ErrorCodeCallback r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        callOrAddPendingCall(new h(r2));
    }

    public final Object requestStateChanged(String r3, TaskStateInfo r4, TaskStateChangeCallback r5, Long r6, Continuation<? super Unit> r7) {
        Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r7, Continuation.class, "com.obric.memorydata.plugin");
        callOrAddPendingCall(new i(r3, r4, r5, r6));
        return Unit.INSTANCE;
    }

    public final void requestUriFileAccess$capabilitykit_release(Uri r3, String r4, IUriFileReceiver r5) {
        IUriFileReceiver r6 = (IUriFileReceiver) ZeusTransformUtils.wrapperContextForParams(r5, IUriFileReceiver.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "uri");
        Intrinsics.checkNotNullParameter(r4, ObricMemoryConstants.KEY_PACKAGE_NAME);
        Intrinsics.checkNotNullParameter(r6, "requester");
        callOrAddPendingCall(new j(r3, r4, r6));
    }

    public final void sendActionExecuteResult$capabilitykit_release(IMAppAction r2) {
        Intrinsics.checkNotNullParameter(r2, "result");
        callOrAddPendingCall(new k(r2));
    }

    public final void sendIntentExecutionResult$capabilitykit_release(IntentResult<?> r2, IMAppAction r3) {
        Intrinsics.checkNotNullParameter(r2, "result");
        Intrinsics.checkNotNullParameter(r3, "oldResult");
        callOrAddPendingCall(new l(r2, r3));
    }

    public final void setPendingCallsExecuted$capabilitykit_release(boolean r1) {
        List<a> r0 = mPendingCals;
        monitor-enter(r0);
        mPendingCallsExecuted = r1;     // Catch: Throwable -> L7
        monitor-exit(r0);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public final void startFloatingActivity(DispatchContext r2, Intent r3, FloatingIntentParams r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, MemorySourceLinkType.INTENT);
        Intrinsics.checkNotNullParameter(r4, TrackerImpl.PARAMS);
        Long r1 = r2.getQuestionId();
        if (r1 == null) goto L6;
        r1.longValue();
        INSTANCE.callOrAddPendingCall(new m(r2, r3, r4));
        return;
    }

    public final void stopUriFileAccess$capabilitykit_release(Uri r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "uri");
        Intrinsics.checkNotNullParameter(r3, ObricMemoryConstants.KEY_PACKAGE_NAME);
        callOrAddPendingCall(new n(r2, r3));
    }

    public final void unregisterResultCallback(ErrorCodeCallback r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        callOrAddPendingCall(new p(r2));
    }

    public final void updateIntentResult(IntentResult<?> r7, long r8, boolean r10, Map<String, String> r11) {
        Map r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r11, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "result");
        callOrAddPendingCall(new q(r7, r8, r10, r5));
    }

    public final void updateIntentResult(IntentResult<?> r9, DispatchContext r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r9, "result");
        Intrinsics.checkNotNullParameter(r10, "dispatchContext");
        Long r0 = r10.getQuestionId();
        if (r0 == null) goto L5;
        long r1 = r0.longValue();
    L6:
        updateIntentResult(r9, r1, r11, r10.getExt());
        return;
    L5:
        r1 = 0;
        goto L6
    }
}
