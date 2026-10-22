package com.obric.capabilitykit;

import android.app.Application;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.net.Uri;
import com.obric.assistant.interaction.api.service.IInteractionStateService;
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
import com.obric.capabilitykit.logger.ILogger;
import com.obric.capabilitykit.logger.Logger;
import com.obric.capabilitykit.sync.EntitySyncDataSupplier;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
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
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$BooleanRef;
import wia.n;
import wia.q;
import wia.u;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000æ\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010$\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001:\u0002stB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0015\u001a\u00020\f2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0007J\u0010\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u0012H\u0002J\u001c\u0010\u0019\u001a\u00020\f2\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\f0\u001bH\u0002J\b\u0010\u001c\u001a\u00020\u001dH\u0002J\b\u0010\u001e\u001a\u00020\fH\u0002J\u000e\u0010\u001f\u001a\u00020\f2\u0006\u0010 \u001a\u00020!J\b\u0010\"\u001a\u00020\u0014H\u0002J+\u0010#\u001a\u0004\u0018\u00010$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010+J \u0010,\u001a\u0004\u0018\u00010$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*J\u000e\u0010-\u001a\u00020\f2\u0006\u0010 \u001a\u00020!J\u0010\u0010.\u001a\u00020\f2\u0006\u0010/\u001a\u000200H\u0007J\u0015\u00101\u001a\u0004\u0018\u00010\u000f2\u0006\u0010 \u001a\u00020!¢\u0006\u0002\u00102J\u0011\u00103\u001a\u00020\u000fH\u0086@ø\u0001\u0000¢\u0006\u0002\u00104J\r\u00105\u001a\u00020\fH\u0000¢\u0006\u0002\b6J\r\u00107\u001a\u00020\fH\u0000¢\u0006\u0002\b8J!\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020\b2\u0006\u0010<\u001a\u00020=H\u0087@ø\u0001\u0000¢\u0006\u0002\u0010>JE\u0010?\u001a\u00020\u00042\u0006\u0010@\u001a\u00020A2\u0006\u0010<\u001a\u00020=2\"\u0010B\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020D\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0E\u0012\u0006\u0012\u0004\u0018\u00010\u00010CH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010FJE\u0010G\u001a\u00020\u00042\u0006\u0010;\u001a\u00020\b2\u0006\u0010<\u001a\u00020=2\"\u0010B\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020D\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0E\u0012\u0006\u0012\u0004\u0018\u00010\u00010CH\u0087@ø\u0001\u0000¢\u0006\u0002\u0010HJ$\u0010I\u001a\u00020\f2\u000e\u0010J\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030K2\n\b\u0002\u0010L\u001a\u0004\u0018\u00010\bH\u0007J\u000e\u0010M\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020NJ\u0016\u0010O\u001a\u00020\f2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0007J9\u0010P\u001a\u00020\f2\u0006\u0010Q\u001a\u00020\b2\u0006\u0010R\u001a\u00020S2\n\b\u0002\u0010T\u001a\u0004\u0018\u00010U2\n\b\u0002\u0010V\u001a\u0004\u0018\u00010!H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010WJ%\u0010X\u001a\u00020\f2\u0006\u0010<\u001a\u00020=2\u0006\u0010;\u001a\u00020\b2\u0006\u0010Y\u001a\u00020ZH\u0000¢\u0006\u0002\b[J\u0015\u0010\\\u001a\u00020\f2\u0006\u0010T\u001a\u00020]H\u0000¢\u0006\u0002\b^J!\u0010_\u001a\u00020\f2\n\u0010T\u001a\u0006\u0012\u0002\b\u00030`2\u0006\u0010a\u001a\u00020]H\u0000¢\u0006\u0002\bbJ\u0010\u0010c\u001a\u00020\f2\u0006\u0010d\u001a\u00020eH\u0007J\u0015\u0010f\u001a\u00020\f2\u0006\u0010g\u001a\u00020\u000fH\u0000¢\u0006\u0002\bhJ\u001e\u0010i\u001a\u00020\f2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*J\u001d\u0010j\u001a\u00020\f2\u0006\u0010<\u001a\u00020=2\u0006\u0010;\u001a\u00020\bH\u0000¢\u0006\u0002\bkJ\u0018\u0010l\u001a\u00020\f2\u000e\u0010J\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030KH\u0007J\u000e\u0010m\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020NJ\"\u0010n\u001a\u00020\f2\n\u0010T\u001a\u0006\u0012\u0002\b\u00030`2\u0006\u0010o\u001a\u00020&2\u0006\u0010p\u001a\u00020\u000fJ:\u0010n\u001a\u00020\f2\n\u0010T\u001a\u0006\u0012\u0002\b\u00030`2\u0006\u0010 \u001a\u00020!2\u0006\u0010p\u001a\u00020\u000f2\u0016\b\u0002\u0010q\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010rR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006u"}, d2 = {"Lcom/obric/capabilitykit/AtomicCapabilitySdk;", "", "()V", "ERROR_INVALID_ACTION_NAME", "", "ERROR_NO_ERROR", "MAX_PENDING_FUN_CALL", "TAG", "", "connectionListeners", "Ljava/util/concurrent/CopyOnWriteArraySet;", "Lkotlin/Function0;", "", "extBindFlags", "mPendingCallsExecuted", "", "mPendingCals", "", "Lcom/obric/capabilitykit/AtomicCapabilitySdk$ApiCall;", "mSendResultApi", "Lcom/obric/capabilitykit/AbstractCapabilityManager;", "addConnectionListener", "listener", "addPendingCall", "call", "callOrAddPendingCall", "func", "Lkotlin/Function1;", "checkInit", "Landroid/app/Application;", "execPendingCalls", "finishFloatingActivity", "questionId", "", "getApi", "getFloatingPendingIntent", "Landroid/app/PendingIntent;", "context", "Lcom/obric/capabilitykit/common/DispatchContext;", "intent", "Landroid/content/Intent;", "params", "Lcom/obric/capabilitykit/common/FloatingIntentParams;", "(Lcom/obric/capabilitykit/common/DispatchContext;Landroid/content/Intent;Lcom/obric/capabilitykit/common/FloatingIntentParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getFloatingPendingIntentNonBlock", "hideIntentResultCard", "init", "config", "Lcom/obric/capabilitykit/AtomicCapabilitySdk$InitConfig;", "isCardViewVisible", "(J)Ljava/lang/Boolean;", "isKeyguardReallyLocked", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onApiInitComplete", "onApiInitComplete$capabilitykit_release", "onConnectionClosed", "onConnectionClosed$capabilitykit_release", "openFileDescriptorPrivileged", "Lcom/obric/capabilitykit/common/execution/fileaccess/UriFileAccessSession;", DBDefinition.PACKAGE_NAME, "uri", "Landroid/net/Uri;", "(Ljava/lang/String;Landroid/net/Uri;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "openInputStream", "entity", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "onGranted", "Lkotlin/Function2;", "Ljava/io/InputStream;", "Lkotlin/coroutines/Continuation;", "(Lcom/obric/capabilitykit/entity/app/AppEntity;Landroid/net/Uri;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "openInputStreamPrivileged", "(Ljava/lang/String;Landroid/net/Uri;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "registerIntent", "function", "Lcom/obric/capabilitykit/common/intent/IntentFunction;", "serviceName", "registerResultCallback", "Lcom/obric/capabilitykit/ErrorCodeCallback;", "removeConnectionListener", "requestStateChanged", "id", "stateInfo", "Lcom/obric/capabilitykit/common/TaskStateInfo;", "result", "Lcom/obric/capabilitykit/TaskStateChangeCallback;", "timeout", "(Ljava/lang/String;Lcom/obric/capabilitykit/common/TaskStateInfo;Lcom/obric/capabilitykit/TaskStateChangeCallback;Ljava/lang/Long;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requestUriFileAccess", "requester", "Lcom/obric/capabilitykit/common/execution/fileaccess/IUriFileReceiver;", "requestUriFileAccess$capabilitykit_release", "sendActionExecuteResult", "Lcom/obric/capabilitykit/common/IMAppAction;", "sendActionExecuteResult$capabilitykit_release", "sendIntentExecutionResult", "Lcom/obric/capabilitykit/common/intent/IntentResult;", "oldResult", "sendIntentExecutionResult$capabilitykit_release", "setLogger", "logger", "Lcom/obric/capabilitykit/logger/ILogger;", "setPendingCallsExecuted", "isExecuted", "setPendingCallsExecuted$capabilitykit_release", "startFloatingActivity", "stopUriFileAccess", "stopUriFileAccess$capabilitykit_release", "unregisterIntent", "unregisterResultCallback", "updateIntentResult", "dispatchContext", "isStatusChange", "ext", "", "ApiCall", "InitConfig", "capabilitykit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
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
    private static n mSendResultApi;

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\tHÆ\u0003J\t\u0010\u001b\u001a\u00020\u000bHÆ\u0003JA\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020\u000bHÖ\u0001J\t\u0010!\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006\""}, d2 = {"Lcom/obric/capabilitykit/AtomicCapabilitySdk$InitConfig;", "", "app", "Landroid/app/Application;", "entitySupplier", "Lcom/obric/capabilitykit/EntitySupplier;", "entityProcessName", "", "entitySyncDataSupplier", "Lcom/obric/capabilitykit/sync/EntitySyncDataSupplier;", "extBindFlags", "", "(Landroid/app/Application;Lcom/obric/capabilitykit/EntitySupplier;Ljava/lang/String;Lcom/obric/capabilitykit/sync/EntitySyncDataSupplier;I)V", "getApp", "()Landroid/app/Application;", "getEntityProcessName", "()Ljava/lang/String;", "getEntitySupplier", "()Lcom/obric/capabilitykit/EntitySupplier;", "getEntitySyncDataSupplier", "()Lcom/obric/capabilitykit/sync/EntitySyncDataSupplier;", "getExtBindFlags", "()I", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", IInteractionStateService.WAKE_UP_SOURCE_OTHER, "hashCode", "toString", "capabilitykit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class InitConfig {
        private final Application app;
        private final String entityProcessName;
        private final EntitySupplier entitySupplier;
        private final EntitySyncDataSupplier entitySyncDataSupplier;
        private final int extBindFlags;

        public InitConfig(Application r2, EntitySupplier r3, String r4, EntitySyncDataSupplier r5, int r6) {
            Intrinsics.checkNotNullParameter(r2, "app");
            this.app = r2;
            this.entitySupplier = r3;
            this.entityProcessName = r4;
            this.entitySyncDataSupplier = r5;
            this.extBindFlags = r6;
        }

        public /* synthetic */ InitConfig(Application r8, EntitySupplier r9, String r10, EntitySyncDataSupplier r11, int r12, int r13, DefaultConstructorMarker r14) {
            if ((r13 & 2) == 0) goto L5;
            EntitySupplier r3 = null;
        L7:
            if ((r13 & 4) == 0) goto L9;
            String r4 = null;
        L11:
            if ((r13 & 8) == 0) goto L13;
            EntitySyncDataSupplier r5 = null;
        L15:
            if ((r13 & 16) == 0) goto L17;
            int r6 = 0;
        L18:
            this(r8, r3, r4, r5, r6);
            return;
        L17:
            r6 = r12;
            goto L18
        L13:
            r5 = r11;
            goto L15
        L9:
            r4 = r10;
            goto L11
        L5:
            r3 = r9;
            goto L7
        }

        public static /* synthetic */ InitConfig copy$default(InitConfig r3, Application r4, EntitySupplier r5, String r6, EntitySyncDataSupplier r7, int r8, int r9, Object r10) {
            if ((r9 & 1) == 0) goto L6;
            r4 = r3.app;
        L6:
            if ((r9 & 2) == 0) goto L8;
            r5 = r3.entitySupplier;
        L8:
            EntitySupplier r11 = r5;
            if ((r9 & 4) == 0) goto L11;
            r6 = r3.entityProcessName;
        L11:
            String r0 = r6;
            if ((r9 & 8) == 0) goto L14;
            r7 = r3.entitySyncDataSupplier;
        L14:
            EntitySyncDataSupplier r1 = r7;
            if ((r9 & 16) == 0) goto L17;
            r8 = r3.extBindFlags;
        L17:
            Application r12 = r4;
            return r3.copy(r12, r11, r0, r1, r8);
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
            Intrinsics.checkNotNullParameter(r8, "app");
            return new InitConfig(r8, r9, r10, r11, r12);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof InitConfig) == true) goto L8;
            return false;
        L8:
            InitConfig r6 = (InitConfig) r5;
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
            return ((r7 + r2) * 31) + this.extBindFlags;
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

    static {
        INSTANCE = new AtomicCapabilitySdk();
        mPendingCals = new ArrayList();
        connectionListeners = new CopyOnWriteArraySet();
    }

    private AtomicCapabilitySdk() {
    }

    public static final /* synthetic */ n access$getApi(AtomicCapabilitySdk r0) {
        return r0.getApi();
    }

    @JvmStatic
    public static final void addConnectionListener(Function0<Unit> r1) {
        Intrinsics.checkNotNullParameter(r1, "listener");
        connectionListeners.add(r1);
    }

    private final void addPendingCall(a r6) {
        Logger r1 = Logger.INSTANCE;
        r1.i(TAG, "addPendingCall");
        List<a> r2 = mPendingCals;
        monitor-enter(r2);
    L19:
        th = move-exception;
        throw th;
    L5:
        if (mPendingCallsExecuted == false) goto L10;
        r1.w(TAG, "in addPendingCall: pending-calls have all been executed; this call shall be execute RIGHT AWAY.");     // Catch: Throwable -> L19
        r6.a();     // Catch: Throwable -> L19
        monitor-exit(r2);
        return;
    L10:
        if (r2.size() <= MAX_PENDING_FUN_CALL) goto L14;
        r1.w(TAG, "addPendingCall too may pending call, drop");     // Catch: Throwable -> L19
        monitor-exit(r2);
        return;
    L14:
        r2.add(r6);     // Catch: Throwable -> L19
        r1.i(TAG, "addPendingCall: queued, pendingSize=" + r2.size() + ", mPendingCallsExecuted=" + mPendingCallsExecuted);     // Catch: Throwable -> L19
        monitor-exit(r2);
    }

    private final void callOrAddPendingCall(Function1<? super n, Unit> r4) {
        n r0 = getApi();
        if (Intrinsics.areEqual(r0, q.a) == true) goto L5;
        r4.invoke(r0);
        return;
    L5:
        Logger.INSTANCE.i(TAG, "callOrAddPendingCall: api unavailable (Empty), enqueue pending call");
        addPendingCall(new b(r4));
    }

    private final Application checkInit() {
        return AppHost.Companion.getApplication();
    }

    private final void execPendingCalls() {
        Logger r1 = Logger.INSTANCE;
        r1.i(TAG, "execPendingCalls");
        List<a> r2 = mPendingCals;
        monitor-enter(r2);
        r1.i(TAG, "execPendingCalls: flush start, pendingSize=" + r2.size());     // Catch: Throwable -> L12
        Iterator<T> r0 = r2.iterator();     // Catch: Throwable -> L12
    L7:
        if (r0.hasNext() == false) goto L9;
        a r3 = (a) r0.next();     // Catch: Throwable -> L12
        Logger.INSTANCE.i(TAG, "exec foreach call");     // Catch: Throwable -> L12
        r3.a();     // Catch: Throwable -> L12
        goto L7
    L9:
        mPendingCals.clear();     // Catch: Throwable -> L12
        mPendingCallsExecuted = true;     // Catch: Throwable -> L12
        monitor-exit(r2);
        return;
    L12:
        th = move-exception;
        throw th;
    }

    @JvmStatic
    public static final void init(InitConfig r5) {
        Intrinsics.checkNotNullParameter(r5, "config");
        Logger.INSTANCE.i(TAG, "AtomicCapabilitySdk init");
        AppHost.Companion.setAppHost(new u(r5.getApp()));
        EntityProvider.INSTANCE.init$capabilitykit_release(new EntityInitParam(r5.getEntitySupplier(), r5.getEntityProcessName(), r5.getEntitySyncDataSupplier()));
        extBindFlags = r5.getExtBindFlags();
    }

    @JvmStatic
    public static final void registerIntent(IntentFunction<?, ?> r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "function");
        AtomicCapabilitySdk r0 = INSTANCE;
        r0.checkInit();
        r0.callOrAddPendingCall(new g(r2, r3));
    }

    public static /* synthetic */ void registerIntent$default(IntentFunction r0, String r1, int r2, Object r3) {
        if ((r2 & 2) == 0) goto L5;
        r1 = null;
    L5:
        registerIntent(r0, r1);
    }

    @JvmStatic
    public static final void removeConnectionListener(Function0<Unit> r1) {
        Intrinsics.checkNotNullParameter(r1, "listener");
        connectionListeners.remove(r1);
    }

    public static /* synthetic */ Object requestStateChanged$default(AtomicCapabilitySdk r7, String r8, TaskStateInfo r9, TaskStateChangeCallback r10, Long r11, Continuation r12, int r13, Object r14) {
        if ((r13 & 4) == 0) goto L5;
        TaskStateChangeCallback r4 = null;
    L7:
        if ((r13 & 8) == 0) goto L9;
        Long r5 = null;
    L11:
        return r7.requestStateChanged(r8, r9, r4, r5, r12);
    L9:
        r5 = r11;
        goto L11
    L5:
        r4 = r10;
        goto L7
    }

    @JvmStatic
    public static final void setLogger(ILogger r2) {
        Intrinsics.checkNotNullParameter(r2, "logger");
        Logger r0 = Logger.INSTANCE;
        r0.setLogger(r2);
        r0.i(TAG, "AtomicCapabilitySdk setLogger");
    }

    @JvmStatic
    public static final void unregisterIntent(IntentFunction<?, ?> r2) {
        Intrinsics.checkNotNullParameter(r2, "function");
        AtomicCapabilitySdk r0 = INSTANCE;
        r0.checkInit();
        r0.callOrAddPendingCall(new o(r2));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void updateIntentResult$default(AtomicCapabilitySdk r6, IntentResult r7, long r8, boolean r10, Map r11, int r12, Object r13) {
        if ((r12 & 8) == 0) goto L5;
        r11 = null;
    L5:
        r6.updateIntentResult(r7, r8, r10, r11);
    }

    public final void finishFloatingActivity(long r2) {
        callOrAddPendingCall(new c(r2));
    }

    public final Object getFloatingPendingIntent(DispatchContext r4, Intent r5, FloatingIntentParams r6, Continuation<? super PendingIntent> r7) {
        SafeContinuation r0 = new SafeContinuation(IntrinsicsKt.intercepted(r7));
        INSTANCE.callOrAddPendingCall(new d(r0, r4, r5, r6));
        Object r8 = r0.getOrThrow();
        if (r8 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
        DebugProbesKt.probeCoroutineSuspended(r7);
    L5:
        return r8;
    }

    public final PendingIntent getFloatingPendingIntentNonBlock(DispatchContext r3, Intent r4, FloatingIntentParams r5) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "intent");
        Intrinsics.checkNotNullParameter(r5, "params");
        Long r6 = r3.getQuestionId();
        if (r6 == null) goto L5;
        long r0 = r6.longValue();
        return INSTANCE.getApi().e(r0, r4, r5);
    L5:
        return null;
    }

    public final void hideIntentResultCard(long r2) {
        callOrAddPendingCall(new e(r2));
    }

    public final Boolean isCardViewVisible(long r2) {
        return getApi().c(r2);
    }

    public final Object isKeyguardReallyLocked(Continuation<? super Boolean> r4) {
        SafeContinuation r0 = new SafeContinuation(IntrinsicsKt.intercepted(r4));
        INSTANCE.callOrAddPendingCall(new f(r0));
        Object r1 = r0.getOrThrow();
        if (r1 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
        DebugProbesKt.probeCoroutineSuspended(r4);
    L5:
        return r1;
    }

    public final void onApiInitComplete$capabilitykit_release() {
        execPendingCalls();
    }

    public final void onConnectionClosed$capabilitykit_release() {
        Iterator<T> r0 = connectionListeners.iterator();
    L4:
        if (r0.hasNext() == false) goto L13;
        ((Function0) r0.next()).invoke();     // Catch: Throwable -> L8
        Object r1 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L8
    L10:
        Throwable r2 = Result.exceptionOrNull-impl(r1);
        if (r2 == null) goto L4;
        Logger.INSTANCE.e(TAG, "connectionListener throw exception: " + ExceptionsKt.stackTraceToString(r2));
    L8:
        th = move-exception;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L10
    }

    @v
    public final Object openFileDescriptorPrivileged(String r2, Uri r3, Continuation<? super UriFileAccessSession> r4) {
        return w.a.c(r2, r3, r4);
    }

    @v
    public final Object openInputStreamPrivileged(String r2, Uri r3, Function2<? super InputStream, ? super Continuation<? super Unit>, ? extends Object> r4, Continuation<? super Integer> r5) {
        return w.a.d(r2, r3, r4, r5);
    }

    public final void registerResultCallback(ErrorCodeCallback r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        callOrAddPendingCall(new h(r2));
    }

    public final Object requestStateChanged(String r1, TaskStateInfo r2, TaskStateChangeCallback r3, Long r4, Continuation<? super Unit> r5) {
        callOrAddPendingCall(new i(r1, r2, r3, r4));
        return Unit.INSTANCE;
    }

    public final void requestUriFileAccess$capabilitykit_release(Uri r2, String r3, IUriFileReceiver r4) {
        Intrinsics.checkNotNullParameter(r2, "uri");
        Intrinsics.checkNotNullParameter(r3, DBDefinition.PACKAGE_NAME);
        Intrinsics.checkNotNullParameter(r4, "requester");
        callOrAddPendingCall(new j(r2, r3, r4));
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

    public final void setPendingCallsExecuted$capabilitykit_release(boolean r2) {
        List<a> r0 = mPendingCals;
        monitor-enter(r0);
        mPendingCallsExecuted = r2;     // Catch: Throwable -> L7
        monitor-exit(r0);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public final void startFloatingActivity(DispatchContext r3, Intent r4, FloatingIntentParams r5) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "intent");
        Intrinsics.checkNotNullParameter(r5, "params");
        Long r0 = r3.getQuestionId();
        if (r0 == null) goto L6;
        r0.longValue();
        INSTANCE.callOrAddPendingCall(new m(r3, r4, r5));
        return;
    }

    public final void stopUriFileAccess$capabilitykit_release(Uri r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "uri");
        Intrinsics.checkNotNullParameter(r3, DBDefinition.PACKAGE_NAME);
        callOrAddPendingCall(new n(r2, r3));
    }

    public final void unregisterResultCallback(ErrorCodeCallback r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        callOrAddPendingCall(new p(r2));
    }

    public final void updateIntentResult(IntentResult<?> r8, long r9, boolean r11, Map<String, String> r12) {
        Intrinsics.checkNotNullParameter(r8, "result");
        callOrAddPendingCall(new q(r8, r9, r11, r12));
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

    private final n getApi() {
        ServiceConnection r0 = c.a;
        int r1 = extBindFlags;
        Object r4 = c.c;
        monitor-enter(r4);
        Logger r5 = Logger.INSTANCE;     // Catch: Throwable -> L92
        StringBuilder r7 = new StringBuilder("getApi: enter, mBindState=");     // Catch: Throwable -> L92
        r7.append(c.f);     // Catch: Throwable -> L92
        r7.append(", api=");     // Catch: Throwable -> L92
        if (c.b != null) goto L9;
        String r3 = "null";
    L10:
        r7.append(r3);     // Catch: Throwable -> L92
        r5.i("AgentServiceConnection", r7.toString());     // Catch: Throwable -> L92
        n r6 = c.b;     // Catch: Throwable -> L92
        if (r6 == null) goto L100;
        monitor-exit(r4);
    L91:
        return r6;
    L100:
    L68:
        th = move-exception;
        Object r2 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L92
    L70:
        Throwable r8 = Result.exceptionOrNull-impl(r2);     // Catch: Throwable -> L92
        if (r8 != null) goto L74;
    L84:
        monitor-exit(r4);
        n r9 = c.b;
        if (r9 != null) goto L88;
        r9 = q.a;
    L88:
        r6 = r9;
        if (Intrinsics.areEqual(r6, q.a) == false) goto L91;
        Logger.INSTANCE.i("AgentServiceConnection", "getApi: return EmptyCapabilityManager, mBindState=" + c.f);
        goto L91
    L74:
        Logger.INSTANCE.e("AgentServiceConnection", "bindService throw exception: " + ExceptionsKt.stackTraceToString(r8));     // Catch: Throwable -> L92
        c.f = c.a.a;     // Catch: Throwable -> L92
        AppHost.Companion.getApplication().unbindService(r0);     // Catch: Throwable -> L77
        Object r10 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L77
    L79:
        Throwable r11 = Result.exceptionOrNull-impl(r10);     // Catch: Throwable -> L92
        if (r11 == null) goto L84;
        Logger.INSTANCE.e("AgentServiceConnection", "unbindService throw exception: " + ExceptionsKt.stackTraceToString(r11));     // Catch: Throwable -> L92
        goto L84
    L77:
        th = move-exception;
        r10 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L92
        goto L79
    L15:
        if (c.f != c.a.b) goto L17;
        r5.i("AgentServiceConnection", "getApi: api is null but mBindState=Started (connecting), wait onServiceConnected");     // Catch: Throwable -> L68
    L66:
        r2 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L68
        goto L70
    L17:
        r5.i("AgentServiceConnection", "getApi: api is null, try rebind, current mBindState=" + c.f);     // Catch: Throwable -> L68
        Intent r12 = new Intent("com.obric.aiagent.executionengine.CAPABILITY_REGISTER_SERVICE");     // Catch: Throwable -> L68
        List<ResolveInfo> r13 = AppHost.Companion.getApplication().getPackageManager().queryIntentServices(r12, 0);     // Catch: Throwable -> L68
        ServiceInfo r14 = null;
        Object r15 = null;
        if (r13 == null) goto L32;
        ArrayList r16 = new ArrayList();     // Catch: Throwable -> L68
        Iterator<T> r17 = r13.iterator();     // Catch: Throwable -> L68
    L21:
        if (r17.hasNext() == false) goto L25;
        ServiceInfo r18 = ((ResolveInfo) r17.next()).serviceInfo;     // Catch: Throwable -> L68
        if (r18 == null) goto L21;
        r16.add(r18);     // Catch: Throwable -> L68
        goto L21
    L25:
        Iterator r19 = r16.iterator();     // Catch: Throwable -> L68
    L27:
        if (r19.hasNext() == false) goto L31;
        Object r20 = r19.next();     // Catch: Throwable -> L68
        if (PackageUtils.INSTANCE.checkSignature(((ServiceInfo) r20).packageName) == false) goto L27;
        r15 = r20;
    L31:
        r14 = (ServiceInfo) r15;     // Catch: Throwable -> L68
    L32:
        if (r14 == null) goto L34;
        r12.setComponent(new ComponentName(r14.packageName, r14.name));     // Catch: Throwable -> L68
        r12.setPackage(r14.packageName);     // Catch: Throwable -> L68
    L34:
        INSTANCE.setPendingCallsExecuted$capabilitykit_release(false);     // Catch: Throwable -> L68
        Ref$BooleanRef r21 = new Ref$BooleanRef();     // Catch: Throwable -> L68
        int r22 = 0;
    L36:
        if (r22 >= 3) goto L58;
        if (r21.element == true) goto L56;
    L45:
        th = move-exception;
        Object r23 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L68
    L47:
        Throwable r24 = Result.exceptionOrNull-impl(r23);     // Catch: Throwable -> L68
        if (r24 != null) goto L51;
    L52:
        Boolean r25 = Boolean.FALSE;     // Catch: Throwable -> L68
        if (Result.isFailure-impl(r23) == false) goto L55;
        r23 = r25;
    L55:
        r21.element = ((Boolean) r23).booleanValue();     // Catch: Throwable -> L68
        goto L56
    L51:
        Logger.INSTANCE.e("AgentServiceConnection", "startService attempt " + (r22 + 1) + " failed: " + ExceptionsKt.stackTraceToString(r24));     // Catch: Throwable -> L68
        goto L52
    L40:
        if (AppHost.Companion.getApplication().startService(r12) == null) goto L42;
        boolean r26 = true;
    L43:
        r23 = Result.constructor-impl(Boolean.valueOf(r26));     // Catch: Throwable -> L45
    L42:
        r26 = false;
    L56:
        r22 = r22 + 1;     // Catch: Throwable -> L68
        goto L36
    L58:
        if (r21.element == false) goto L64;
        AppHost.Companion r27 = AppHost.Companion;     // Catch: Throwable -> L68
        if (r27.getApplication().bindService(r12, r0, r1) == false) goto L62;
        c.f = c.a.b;     // Catch: Throwable -> L68
        goto L66
    L62:
        Logger.INSTANCE.i("AgentServiceConnection", "bindService fail");     // Catch: Throwable -> L68
        c.f = c.a.a;     // Catch: Throwable -> L68
        r27.getApplication().unbindService(r0);     // Catch: Throwable -> L68
        goto L66
    L64:
        throw new IllegalStateException("startService failed after 3 attempts");     // Catch: Throwable -> L68
    L9:
        r3 = "non-null";
    L92:
        th = move-exception;
        throw th;
    }

    public final Object openInputStream(AppEntity r3, Uri r4, Function2<? super InputStream, ? super Continuation<? super Unit>, ? extends Object> r5, Continuation<? super Integer> r6) {
        w r0 = w.a;
        r0.getClass();
        String r7 = r3.getPackageName();
        if (r7.length() != 0) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L9;
        Logger.INSTANCE.e("UriShareHelper", "no sharer package found in entity.");
        return Boxing.boxInt(3);
    L9:
        return r0.d(r7, r4, r5, r6);
    L5:
        r1 = false;
        goto L6
    }
}
