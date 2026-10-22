package com.obric.aiagent.flow.applog;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.apm6.consumer.slardar.Constants;
import com.bytedance.bdinstall.Api;
import com.bytedance.bdlocation.monitor.InfoRequestQPSOptTraceLogger;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.aiagent.flow.applog.a.c;
import com.obric.aiagent.platform.a.e;
import com.obric.aikernel.sdk.autotest.AutoTestConstant;
import com.obric.memorydata.middleware.impl.bdtracker.TrackerImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000¦\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\b\u0003\n\u0002\b\u0016\n\u0002\u0010%\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011*\u0002/2\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001eB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u00104\u001a\u00020-H\u0002J\b\u00105\u001a\u00020-H\u0002J\b\u00106\u001a\u00020-H\u0002J\b\u00107\u001a\u00020-H\u0002J\b\u00108\u001a\u00020-H\u0002J\b\u00109\u001a\u00020-H\u0002J\u0010\u0010:\u001a\u00020-2\u0006\u0010;\u001a\u00020\u0007H\u0002J\u0010\u0010<\u001a\u00020-2\u0006\u0010=\u001a\u00020\u0005H\u0002J\u0010\u0010>\u001a\u00020-2\u0006\u0010=\u001a\u00020\u0005H\u0002J*\u0010?\u001a\u00020-2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010@\u001a\u00020#2\b\b\u0002\u0010A\u001a\u00020\u00192\b\b\u0002\u0010;\u001a\u00020\u0007J\u0006\u0010B\u001a\u00020-J\b\u0010C\u001a\u00020-H\u0002J\u000e\u0010D\u001a\u00020-2\u0006\u0010@\u001a\u00020#J\u000e\u0010E\u001a\u00020\u00162\u0006\u0010@\u001a\u00020#J \u0010F\u001a\u00020-2\u0018\u0010G\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010HJ\u000e\u0010I\u001a\u00020-2\u0006\u0010J\u001a\u00020\u0005J\u0018\u0010I\u001a\u00020-2\u0006\u0010J\u001a\u00020\u00052\b\u0010G\u001a\u0004\u0018\u00010(J\u0018\u0010I\u001a\u00020-2\u0006\u0010J\u001a\u00020\u00052\b\u0010K\u001a\u0004\u0018\u00010*J\u000e\u0010L\u001a\u00020-2\u0006\u0010M\u001a\u00020NJ\u000e\u0010O\u001a\u00020-2\u0006\u0010M\u001a\u00020NJ\u000e\u0010P\u001a\u00020-2\u0006\u0010Q\u001a\u00020RJ\u000e\u0010S\u001a\u00020-2\u0006\u0010Q\u001a\u00020RJ\u000e\u0010T\u001a\u00020-2\u0006\u0010@\u001a\u00020UJ\u000e\u0010V\u001a\u00020-2\u0006\u0010@\u001a\u00020UJ\u0016\u0010W\u001a\u00020-2\u0006\u0010X\u001a\u00020\u00052\u0006\u0010Y\u001a\u00020\u0019J\u0006\u0010Z\u001a\u00020-J\u0006\u0010[\u001a\u00020-J\u000e\u0010\\\u001a\u00020-2\u0006\u0010]\u001a\u00020\u0005J\u0006\u0010^\u001a\u00020-J\b\u0010_\u001a\u0004\u0018\u00010\u0005J\u0006\u0010`\u001a\u00020\u0005J\u0006\u0010a\u001a\u00020\u0005J\u0006\u0010b\u001a\u00020\u0005J\u0006\u0010c\u001a\u00020\u0005J\b\u0010d\u001a\u00020-H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010!\u001a\b\u0012\u0004\u0012\u00020#0\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010$\u001a\b\u0012\u0004\u0012\u00020#0\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00050\"X\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010&\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010(0'0\"X\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010)\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010*0'0\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010+\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020-0,0\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010.\u001a\u00020/X\u0082\u0004¢\u0006\u0004\n\u0002\u00100R\u0010\u00101\u001a\u000202X\u0082\u0004¢\u0006\u0004\n\u0002\u00103¨\u0006f"}, d2 = {"Lcom/obric/aiagent/flow/applog/FlowAppLog;", "", "<init>", "()V", "TAG", "", "DISABLE_AUTO_UNBIND_DELAY_MS", "", "context", "Landroid/content/Context;", "did", "iid", Api.KEY_SSID, "userUniqueID", "userID", "instance", "Landroid/os/IBinder;", "service", "Lcom/obric/aiagent/flow/applog/idl/IFlowAppLogIDL;", "deathRecipient", "Landroid/os/IBinder$DeathRecipient;", "onBindSuccess", "", "isBinding", "bindFlags", "", "autoUnbindDelayMs", "myHandlerThread", "Landroid/os/HandlerThread;", "myHandler", "Landroid/os/Handler;", "autoUnbindRunnable", "Ljava/lang/Runnable;", "bindInitListener", "Lcom/obric/aiagent/flow/applog/FlowAppLog$BoundedCache;", "Lcom/obric/aiagent/flow/applog/IRegisterIPCListener;", "bindAddedListener", "eventCache", "eventJsonCache", "Lkotlin/Pair;", "Lorg/json/JSONObject;", "eventBundleCache", "Landroid/os/Bundle;", "pendingActions", "Lkotlin/Function0;", "", "dataObserver", "com/obric/aiagent/flow/applog/FlowAppLog$dataObserver$1", "Lcom/obric/aiagent/flow/applog/FlowAppLog$dataObserver$1;", "serviceConnection", "com/obric/aiagent/flow/applog/FlowAppLog$serviceConnection$1", "Lcom/obric/aiagent/flow/applog/FlowAppLog$serviceConnection$1;", "handleDisconnectListener", "handleCacheAndListener", "handleConnected", "onBinderDied", "clearDeathRecipient", "safeUnbind", "updateAutoUnbindConfigLocked", "unbindDelayMs", "cancelAutoUnbindLocked", InfoRequestQPSOptTraceLogger.REASON, "scheduleAutoUnbindLocked", "bind", "listener", "flags", "unBind", "executeBind", "registBindListener", "unregistBindListener", "setHeaderInfo", TrackerImpl.PARAMS, "", "onEventV3", "event", AutoTestConstant.PARAM, "addSessionHook", "hook", "Lcom/obric/aiagent/flow/applog/idl/IFlowAppLogSessionObserverIDL;", "removeSessionHook", "addEventObserver", "iEventObserver", "Lcom/obric/aiagent/flow/applog/idl/IFlowAppLogEventObserverIDL;", "removeEventObserver", "addDataObserver", "Lcom/obric/aiagent/flow/applog/idl/IFlowAppLogDataObserverIDL;", "removeDataObserver", "onResume", "activity", "hashCode", "onPause", "onStop", "setLaunchService", "launchService", "clearLaunchService", "getDid", "getIid", "getSsid", "getUserUniqueID", "getUserID", "clearAllId", "BoundedCache", "flow-applog_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f5912a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Context f5913b;
    private static String c;
    private static String d;
    private static String e;
    private static IBinder f;
    private static c g;
    private static IBinder.DeathRecipient h;
    private static volatile boolean i;
    private static volatile boolean j;
    private static int k;
    private static long l;
    private static final HandlerThread m = null;
    private static final Handler n = null;
    private static final Runnable o = null;
    private static final C0230a<com.obric.aiagent.flow.applog.b> p = null;
    private static final C0230a<com.obric.aiagent.flow.applog.b> q = null;
    private static final C0230a<String> r = null;
    private static final C0230a<Pair<String, JSONObject>> s = null;
    private static final C0230a<Pair<String, Bundle>> t = null;
    private static final C0230a<Function0<Unit>> u = null;
    private static final b v = null;
    private static final d w = null;

    /* JADX INFO: renamed from: com.obric.aiagent.flow.applog.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010!\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0013\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00028\u0000¢\u0006\u0002\u0010\u000fJ\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\nJ\u0006\u0010\u0011\u001a\u00020\rJ\u0013\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00028\u0000¢\u0006\u0002\u0010\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R4\u0010\u0007\u001a&\u0012\f\u0012\n \t*\u0004\u0018\u00018\u00008\u0000 \t*\u0012\u0012\f\u0012\n \t*\u0004\u0018\u00018\u00008\u0000\u0018\u00010\n0\bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000bR\u0011\u0010\u0015\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/obric/aiagent/flow/applog/FlowAppLog$BoundedCache;", ExifInterface.GPS_DIRECTION_TRUE, "", "maxSize", "", "<init>", "(I)V", Constants.KEY_LIST, "", "kotlin.jvm.PlatformType", "", "Ljava/util/List;", "add", "", "item", "(Ljava/lang/Object;)V", "getAll", "clear", "remove", "", "(Ljava/lang/Object;)Z", "size", "getSize", "()I", "flow-applog_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class C0230a<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f5914a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final List<T> f5915b;

        public C0230a(int r3) {
            this.f5914a = r3;
            this.f5915b = Collections.synchronizedList((List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin"));
        }

        public final List<T> a() {
            List<T> r0 = this.f5915b;
            Intrinsics.checkNotNullExpressionValue(r0, Constants.KEY_LIST);
            monitor-enter(r0);
            List<T> r3 = this.f5915b;     // Catch: Throwable -> L7
            Intrinsics.checkNotNullExpressionValue(r3, Constants.KEY_LIST);     // Catch: Throwable -> L7
            List<T> r4 = CollectionsKt.toList((Iterable) ZeusTransformUtils.preCheckCast(r3, Iterable.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L7
            monitor-exit(r0);
            return r4;
        L7:
            th = move-exception;
            throw th;
        }

        public final void a(T r3) {
            List<T> r0 = this.f5915b;
            Intrinsics.checkNotNullExpressionValue(r0, Constants.KEY_LIST);
            monitor-enter(r0);
            this.f5915b.add(r3);     // Catch: Throwable -> L11
        L6:
            if (this.f5915b.size() <= this.f5914a) goto L8;
            List<T> r4 = this.f5915b;     // Catch: Throwable -> L11
            Intrinsics.checkNotNullExpressionValue(r4, Constants.KEY_LIST);     // Catch: Throwable -> L11
            CollectionsKt.removeFirst(r4);     // Catch: Throwable -> L11
            goto L6
        L8:
            Unit r2 = Unit.INSTANCE;     // Catch: Throwable -> L11
            monitor-exit(r0);
            return;
        L11:
            th = move-exception;
            throw th;
        }

        public final void b() {
            List<T> r0 = this.f5915b;
            Intrinsics.checkNotNullExpressionValue(r0, Constants.KEY_LIST);
            monitor-enter(r0);
            this.f5915b.clear();     // Catch: Throwable -> L7
            Unit r2 = Unit.INSTANCE;     // Catch: Throwable -> L7
            monitor-exit(r0);
            return;
        L7:
            th = move-exception;
            throw th;
        }
    }

    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J&\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005H\u0016JL\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u00052\b\u0010\r\u001a\u0004\u0018\u00010\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0011"}, d2 = {"com/obric/aiagent/flow/applog/FlowAppLog$dataObserver$1", "Lcom/obric/aiagent/flow/applog/idl/IFlowAppLogDataObserverIDL$Stub;", "onIdLoaded", "", "did", "", "iid", Api.KEY_SSID, "onRemoteIdGet", "changed", "", "oldDid", "newDid", "oldIid", "newIid", "oldSsid", "newSsid", "flow-applog_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b extends com.obric.aiagent.flow.applog.a.a.AbstractBinderC0231a {
        b() {
        }

        @Override // com.obric.aiagent.flow.applog.a.a
        public void a(String r3, String r4, String r5) {
            e.f5957b.b("FlowAppLog", "addDataObserver onIdLoaded, did: " + r3 + ", iid: " + r4 + ", ssid: " + r5);
            a r2 = a.f5912a;
            a.c(r3);
            a r6 = a.f5912a;
            a.d(r4);
            a r7 = a.f5912a;
            a.e(r5);
        }

        @Override // com.obric.aiagent.flow.applog.a.a
        public void a(boolean r3, String r4, String r5, String r6, String r7, String r8, String r9) {
            e.f5957b.b("FlowAppLog", "addDataObserver onRemoteIdGet, changed: " + r3 + ", oldDid: " + r4 + ", newDid: " + r5 + ", oldIid: " + r6 + ", newIid: " + r7 + ", oldSsid: " + r8 + ", newSsid: " + r9);
            if (r3 == false) goto L6;
            a r2 = a.f5912a;
            a.c(r5);
            a r10 = a.f5912a;
            a.d(r7);
            a r11 = a.f5912a;
            a.e(r9);
            return;
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/obric/aiagent/flow/applog/FlowAppLog$handleConnected$2$dr$1", "Landroid/os/IBinder$DeathRecipient;", "binderDied", "", "flow-applog_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class c implements IBinder.DeathRecipient {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ a f5916a;

        c(a r1) {
            this.f5916a = r1;
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            a.a(this.f5916a);
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\t"}, d2 = {"com/obric/aiagent/flow/applog/FlowAppLog$serviceConnection$1", "Landroid/content/ServiceConnection;", "onServiceConnected", "", ActivityLifecycle.NAME, "Landroid/content/ComponentName;", "binder", "Landroid/os/IBinder;", "onServiceDisconnected", "flow-applog_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class d implements ServiceConnection {
        d() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName r1, IBinder r2) {
            IBinder r0 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r2, IBinder.class, "com.obric.memorydata.plugin");
            if (r0 != null) goto L6;
            com.obric.aiagent.platform.a.d.f5954a.b("FlowAppLog", "onServiceConnected: service is null");
            return;
        L6:
            a r3 = a.f5912a;
            monitor-enter(r3);
            a r4 = a.f5912a;     // Catch: Throwable -> L12
            a.a(c.a.a(r0));     // Catch: Throwable -> L12
            a r5 = a.f5912a;     // Catch: Throwable -> L12
            a.a(r0);     // Catch: Throwable -> L12
            a r6 = a.f5912a;     // Catch: Throwable -> L12
            a.a(true);     // Catch: Throwable -> L12
            a r7 = a.f5912a;     // Catch: Throwable -> L12
            a.b(false);     // Catch: Throwable -> L12
            Unit r8 = Unit.INSTANCE;     // Catch: Throwable -> L12
            monitor-exit(r3);
            a.b(a.f5912a);
            return;
        L12:
            th = move-exception;
            throw th;
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName r5) {
            a r4 = a.f5912a;
            monitor-enter(r4);
            com.obric.aiagent.platform.a.d.f5954a.b("FlowAppLog", "onServiceDisconnected: " + r5);     // Catch: Throwable -> L7
            a.c(a.f5912a);     // Catch: Throwable -> L7
            a.d(a.f5912a);     // Catch: Throwable -> L7
            a.e(a.f5912a);     // Catch: Throwable -> L7
            a r6 = a.f5912a;     // Catch: Throwable -> L7
            a.a(null);     // Catch: Throwable -> L7
            a r0 = a.f5912a;     // Catch: Throwable -> L7
            a.a(null);     // Catch: Throwable -> L7
            Unit r7 = Unit.INSTANCE;     // Catch: Throwable -> L7
            monitor-exit(r4);
            return;
        L7:
            th = move-exception;
            throw th;
        }
    }

    static {
        f5912a = new a();
        k = 1;
        l = -1;
        HandlerThread r0 = new HandlerThread("FlowAppLog");
        r0.start();
        m = r0;
        n = new Handler(r0.getLooper());
        o = $$Lambda$a$3iwGs8vdf9GhjdjzJmel5MfHf1k.INSTANCE;
        p = new C0230a(10);
        q = new C0230a(100);
        r = new C0230a(5000);
        s = new C0230a(5000);
        t = new C0230a(5000);
        u = new C0230a(100);
        v = new b();
        w = new d();
    }

    private a() {
    }

    private final void a(long r4) {
        l = r4;
        if (r4 > 0) goto L7;
        f("disabled");
        com.obric.aiagent.platform.a.d.b r3 = com.obric.aiagent.platform.a.d.f5954a;
        StringBuilder r0 = new StringBuilder();
        String r2 = "auto unbind disabled, delay: ";
    L5:
        r3.b("FlowAppLog", r0.append(r2).append(r4).toString());
        return;
    L7:
        r3 = com.obric.aiagent.platform.a.d.f5954a;
        r0 = new StringBuilder();
        r2 = "auto unbind enabled, delay: ";
        goto L5
    }

    public static final /* synthetic */ void a(IBinder r2) {
        f = (IBinder) ZeusTransformUtils.wrapperContextForParams(r2, IBinder.class, "com.obric.memorydata.plugin");
    }

    public static final /* synthetic */ void a(c r2) {
        g = (c) ZeusTransformUtils.wrapperContextForParams(r2, c.class, "com.obric.memorydata.plugin");
    }

    public static final /* synthetic */ void a(a r0) {
        r0.h();
    }

    public static /* synthetic */ void a(a r3, Context r4, com.obric.aiagent.flow.applog.b r5, int r6, long r7, int r9, Object r10) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        com.obric.aiagent.flow.applog.b r11 = (com.obric.aiagent.flow.applog.b) ZeusTransformUtils.wrapperContextForParams(r5, com.obric.aiagent.flow.applog.b.class, "com.obric.memorydata.plugin");
        if ((r9 & 4) == 0) goto L5;
        r6 = 1;
    L5:
        int r0 = r6;
        if ((r9 & 8) == 0) goto L8;
        r7 = -1;
    L8:
        r3.a(r8, r11, r0, r7);
    }

    private static final void a(List r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L9
        Iterator r5 = ((Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Throwable -> L9
    L5:
        if (r5.hasNext() == false) goto L7;
        ((com.obric.aiagent.flow.applog.b) ZeusTransformUtils.preCheckCast(r5.next(), com.obric.aiagent.flow.applog.b.class, "com.obric.memorydata.plugin")).b();     // Catch: Throwable -> L9
        goto L5
    L7:
        Object r6 = Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L9
    L11:
        Throwable r7 = Result.m1424exceptionOrNullimpl(r6);
        if (r7 == null) goto L18;
        com.obric.aiagent.platform.a.d.f5954a.b("FlowAppLog", "handleDisconnectListener async error", r7);
        return;
    L18:
        return;
    L9:
        th = move-exception;
        Result.Companion r1 = Result.Companion;
        r6 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L11
    }

    private static final void a(List r4, List r5, List r6, List r7, List r8, List r9) {
        List r10 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        List r11 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        List r12 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        List r13 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin");
        List r14 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.memorydata.plugin");
        List r15 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.memorydata.plugin");
        a r0 = f5912a;
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L29
        r0.a((com.obric.aiagent.flow.applog.a.a) ZeusTransformUtils.preCheckCast(v, com.obric.aiagent.flow.applog.a.a.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L29
        Iterator r16 = ((Iterable) ZeusTransformUtils.preCheckCast(r10, Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Throwable -> L29
    L5:
        if (r16.hasNext() == false) goto L7;
        ((com.obric.aiagent.flow.applog.b) ZeusTransformUtils.preCheckCast(r16.next(), com.obric.aiagent.flow.applog.b.class, "com.obric.memorydata.plugin")).a();     // Catch: Throwable -> L29
        goto L5
    L7:
        Iterator r17 = ((Iterable) ZeusTransformUtils.preCheckCast(r11, Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Throwable -> L29
    L9:
        if (r17.hasNext() == false) goto L11;
        ((com.obric.aiagent.flow.applog.b) ZeusTransformUtils.preCheckCast(r17.next(), com.obric.aiagent.flow.applog.b.class, "com.obric.memorydata.plugin")).a();     // Catch: Throwable -> L29
        goto L9
    L11:
        Iterator r18 = ((Iterable) ZeusTransformUtils.preCheckCast(r12, Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Throwable -> L29
    L13:
        if (r18.hasNext() == false) goto L15;
        String r19 = (String) ZeusTransformUtils.preCheckCast(r18.next(), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L29
        f5912a.a(r19);     // Catch: Throwable -> L29
        goto L13
    L15:
        Iterator r20 = ((Iterable) ZeusTransformUtils.preCheckCast(r13, Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Throwable -> L29
    L17:
        if (r20.hasNext() == false) goto L19;
        Pair r21 = (Pair) ZeusTransformUtils.preCheckCast(r20.next(), Pair.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L29
        f5912a.a((String) ZeusTransformUtils.preCheckCast(r21.getFirst(), String.class, "com.obric.memorydata.plugin"), (JSONObject) ZeusTransformUtils.preCheckCast(r21.getSecond(), JSONObject.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L29
        goto L17
    L19:
        Iterator r22 = ((Iterable) ZeusTransformUtils.preCheckCast(r14, Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Throwable -> L29
    L21:
        if (r22.hasNext() == false) goto L23;
        Pair r23 = (Pair) ZeusTransformUtils.preCheckCast(r22.next(), Pair.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L29
        f5912a.a((String) ZeusTransformUtils.preCheckCast(r23.getFirst(), String.class, "com.obric.memorydata.plugin"), (Bundle) ZeusTransformUtils.preCheckCast(r23.getSecond(), Bundle.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L29
        goto L21
    L23:
        Iterator r24 = ((Iterable) ZeusTransformUtils.preCheckCast(r15, Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Throwable -> L29
    L25:
        if (r24.hasNext() == false) goto L27;
        ((Function0) ZeusTransformUtils.preCheckCast(r24.next(), Function0.class, "com.obric.memorydata.plugin")).invoke();     // Catch: Throwable -> L29
        goto L25
    L27:
        Object r25 = Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L29
    L31:
        Throwable r26 = Result.m1424exceptionOrNullimpl(r25);
        if (r26 == null) goto L43;
        com.obric.aiagent.platform.a.d.f5954a.b("FlowAppLog", "handleCacheAndListener async error", r26);
        return;
    L43:
        return;
    L29:
        th = move-exception;
        Result.Companion r27 = Result.Companion;
        r25 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L31
    }

    public static final /* synthetic */ void a(boolean r0) {
        i = r0;
    }

    private static final Unit b(com.obric.aiagent.flow.applog.a.a r2) {
        com.obric.aiagent.flow.applog.a.a r3 = (com.obric.aiagent.flow.applog.a.a) ZeusTransformUtils.wrapperContextForParams(r2, com.obric.aiagent.flow.applog.a.a.class, "com.obric.memorydata.plugin");
        c r0 = g;
        if (r0 == null) goto L6;
        r0.a(r3);
    L6:
        return Unit.INSTANCE;
    }

    private static final Unit b(String r3, int r4) {
        com.obric.aiagent.platform.a.d.f5954a.b("FlowAppLog", "Cache onResume report " + r3);
        c r0 = g;
        if (r0 == null) goto L6;
        r0.a(r3, r4);
    L6:
        return Unit.INSTANCE;
    }

    public static final /* synthetic */ void b(a r0) {
        r0.g();
    }

    public static final /* synthetic */ void b(boolean r0) {
        j = r0;
    }

    public static final /* synthetic */ void c(a r0) {
        r0.i();
    }

    public static final /* synthetic */ void c(String r0) {
        c = r0;
    }

    public static final /* synthetic */ void d(a r0) {
        r0.j();
    }

    public static final /* synthetic */ void d(String r0) {
        d = r0;
    }

    private final void e() {
        C0230a<com.obric.aiagent.flow.applog.b> r5 = q;     // Catch: Exception -> L14
        monitor-enter(r5);     // Catch: Exception -> L14
        final List<com.obric.aiagent.flow.applog.b> r0 = r5.a();     // Catch: Throwable -> L11
        monitor-exit(r5);     // Catch: Exception -> L14
        Iterator r6 = ((Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Exception -> L14
    L8:
        if (r6.hasNext() == false) goto L10;
        ((com.obric.aiagent.flow.applog.b) ZeusTransformUtils.preCheckCast(r6.next(), com.obric.aiagent.flow.applog.b.class, "com.obric.memorydata.plugin")).b();     // Catch: Exception -> L14
        goto L8
    L10:
        n.post(new $$Lambda$a$Okoh1tDMBuznGK7ZbrFpnWT0Pxo(r0));     // Catch: Exception -> L14
        return;
    L11:
        th = move-exception;
        throw th;     // Catch: Exception -> L14
    L14:
        e = move-exception;
        com.obric.aiagent.platform.a.d.f5954a.b("FlowAppLog", "handleDisconnectListener error", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
    }

    public static final /* synthetic */ void e(a r0) {
        r0.e();
    }

    public static final /* synthetic */ void e(String r0) {
        e = r0;
    }

    private final void f() {
        C0230a<com.obric.aiagent.flow.applog.b> r8 = p;     // Catch: Exception -> L45
        monitor-enter(r8);     // Catch: Exception -> L45
        final List<com.obric.aiagent.flow.applog.b> r1 = r8.a();     // Catch: Throwable -> L42
        r8.b();     // Catch: Throwable -> L42
        monitor-exit(r8);     // Catch: Exception -> L45
        C0230a<com.obric.aiagent.flow.applog.b> r9 = q;     // Catch: Exception -> L45
        monitor-enter(r9);     // Catch: Exception -> L45
        final List<com.obric.aiagent.flow.applog.b> r2 = r9.a();     // Catch: Throwable -> L39
        monitor-exit(r9);     // Catch: Exception -> L45
        C0230a<String> r10 = r;     // Catch: Exception -> L45
        monitor-enter(r10);     // Catch: Exception -> L45
        final List<String> r3 = r10.a();     // Catch: Throwable -> L36
        r10.b();     // Catch: Throwable -> L36
        monitor-exit(r10);     // Catch: Exception -> L45
        C0230a<Pair<String, JSONObject>> r11 = s;     // Catch: Exception -> L45
        monitor-enter(r11);     // Catch: Exception -> L45
        final List<Pair<String, JSONObject>> r4 = r11.a();     // Catch: Throwable -> L33
        r11.b();     // Catch: Throwable -> L33
        monitor-exit(r11);     // Catch: Exception -> L45
        C0230a<Pair<String, Bundle>> r12 = t;     // Catch: Exception -> L45
        monitor-enter(r12);     // Catch: Exception -> L45
        final List<Pair<String, Bundle>> r5 = r12.a();     // Catch: Throwable -> L30
        r12.b();     // Catch: Throwable -> L30
        monitor-exit(r12);     // Catch: Exception -> L45
        C0230a<Function0<Unit>> r13 = u;     // Catch: Exception -> L45
        monitor-enter(r13);     // Catch: Exception -> L45
        final List<Function0<Unit>> r6 = r13.a();     // Catch: Throwable -> L27
        r13.b();     // Catch: Throwable -> L27
        monitor-exit(r13);     // Catch: Exception -> L45
        n.post(new $$Lambda$a$AHO2v3RsSVxMR0pa8jdUZTgx2U(r1, r2, r3, r4, r5, r6));     // Catch: Exception -> L45
        return;
    L27:
        th = move-exception;
        throw th;     // Catch: Exception -> L45
    L30:
        th = move-exception;
        throw th;     // Catch: Exception -> L45
    L33:
        th = move-exception;
        throw th;     // Catch: Exception -> L45
    L36:
        th = move-exception;
        throw th;     // Catch: Exception -> L45
    L39:
        th = move-exception;
        throw th;     // Catch: Exception -> L45
    L42:
        th = move-exception;
        throw th;     // Catch: Exception -> L45
    L45:
        e = move-exception;
        com.obric.aiagent.platform.a.d.f5954a.b("FlowAppLog", "handleCacheAndListener error", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
    }

    private final void f(String r3) {
        n.removeCallbacks(o);
        com.obric.aiagent.platform.a.d.f5954a.b("FlowAppLog", "cancelAutoUnbindLocked, reason: " + r3);
    }

    private final void g() {
        monitor-enter(this);
        f5912a.i();     // Catch: Throwable -> L36
        Unit r0 = Unit.INSTANCE;     // Catch: Throwable -> L36
        monitor-exit(this);
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L23
        a r4 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L23
        c r2 = new c(r4);     // Catch: Throwable -> L23
        monitor-enter(r4);     // Catch: Throwable -> L23
        IBinder r3 = f;     // Catch: Throwable -> L20
        if (r3 == null) goto L10;
        r3.linkToDeath((IBinder.DeathRecipient) ZeusTransformUtils.preCheckCast(r2, IBinder.DeathRecipient.class, "com.obric.memorydata.plugin"), 0);     // Catch: Throwable -> L20
    L10:
        h = (IBinder.DeathRecipient) ZeusTransformUtils.preCheckCast(r2, IBinder.DeathRecipient.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L20
        Unit r5 = Unit.INSTANCE;     // Catch: Throwable -> L20
        monitor-exit(r4);     // Catch: Throwable -> L23
        r4.f();     // Catch: Throwable -> L23
        monitor-enter(r4);     // Catch: Throwable -> L23
        r4.g("service connected");     // Catch: Throwable -> L17
        Unit r6 = Unit.INSTANCE;     // Catch: Throwable -> L17
        monitor-exit(r4);     // Catch: Throwable -> L23
        com.obric.aiagent.platform.a.d.f5954a.b("FlowAppLog", "handleConnected: linkToDeath success");     // Catch: Throwable -> L23
        Object r7 = Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L23
    L25:
        Throwable r8 = Result.m1424exceptionOrNullimpl(r7);
        if (r8 == null) goto L35;
        com.obric.aiagent.platform.a.d.f5954a.b("FlowAppLog", "handleConnected: fail " + ExceptionsKt.stackTraceToString(r8), r8);
        a r9 = f5912a;
        monitor-enter(r9);
        r9.i();     // Catch: Throwable -> L32
        r9.j();     // Catch: Throwable -> L32
        f = null;     // Catch: Throwable -> L32
        g = null;     // Catch: Throwable -> L32
        Unit r10 = Unit.INSTANCE;     // Catch: Throwable -> L32
        monitor-exit(r9);
        return;
    L32:
        th = move-exception;
        throw th;
    L35:
        return;
    L17:
        th = move-exception;
        throw th;     // Catch: Throwable -> L23
    L20:
        th = move-exception;
        throw th;     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        r7 = Result.m1421constructorimpl(ResultKt.createFailure(th));
    L36:
        th = move-exception;
        throw th;
    }

    private final void g(String r5) {
        long r0 = l;
        f("reschedule: " + r5);
        if (r0 > 0) goto L5;
        return;
    L5:
        if (i == false) goto L10;
        n.postDelayed(o, r0);
        com.obric.aiagent.platform.a.d.f5954a.b("FlowAppLog", "scheduleAutoUnbindLocked, delayMs: " + r0 + ", reason: " + r5);
        return;
    }

    private static final Unit h(String r1) {
        c r0 = g;
        if (r0 == null) goto L6;
        r0.b(r1);
    L6:
        return Unit.INSTANCE;
    }

    private final void h() {
        monitor-enter(this);
        a r0 = f5912a;     // Catch: Throwable -> L6
        r0.i();     // Catch: Throwable -> L6
        r0.j();     // Catch: Throwable -> L6
        f = null;     // Catch: Throwable -> L6
        g = null;     // Catch: Throwable -> L6
        Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    private final void i() {
        IBinder.DeathRecipient r2 = h;
        if (r2 == null) goto L15;
        IBinder r0 = f;
        if (r0 != null) goto L13;
    L11:
        h = null;
        return;
    L13:
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L8
        Object r3 = Result.m1421constructorimpl(Boolean.valueOf(r0.unlinkToDeath(r2, 0)));     // Catch: Throwable -> L8
    L10:
        Result.m1420boximpl(r3);
    L8:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        r3 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L10
    }

    private final void j() {
        if (i == true) goto L5;
        return;
    L5:
        f("safeUnbind");
        g = null;
        i = false;
        j = false;
        i();
        Context r4 = f5913b;
        if (r4 == null) goto L18;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L9
        ZeusTransformUtils.unbindService(r4, (ServiceConnection) ZeusTransformUtils.preCheckCast(w, ServiceConnection.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");     // Catch: Throwable -> L9
        Object r5 = Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L9
    L11:
        Throwable r0 = Result.m1424exceptionOrNullimpl(r5);
        if (r0 == null) goto L14;
        com.obric.aiagent.platform.a.d.f5954a.b("FlowAppLog", "safeUnbind error", r0);
    L14:
        Result.m1420boximpl(r5);
        return;
    L9:
        th = move-exception;
        Result.Companion r2 = Result.Companion;
        r5 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L11
    }

    private final void k() {
        if (i == false) goto L5;
    L38:
        com.obric.aiagent.platform.a.d.f5954a.b("FlowAppLog", "has binded or binding, skip executeBind, onBindSuccess: " + i + ", isBinding: " + j);
        return;
    L5:
        if (j == true) goto L38;
        if (f5913b != null) goto L11;
        com.obric.aiagent.platform.a.d.f5954a.b("FlowAppLog", "context is null, skip executeBind");
        return;
    L11:
        com.obric.aiagent.platform.a.d.f5954a.b("FlowAppLog", "executeBind: " + ExceptionsKt.stackTraceToString(new Throwable()));
        j();
        com.obric.aiagent.platform.a.d.f5954a.b("FlowAppLog", "executeBind started");
        Intent r7 = new Intent("com.obric.memorydata.awareness.FLOW_APPLOG_IPC");
        r7.setPackage("com.larus.nova");
        Context r0 = f5913b;
        String r3 = null;
        if (r0 != null) goto L40;
        Result r8 = null;
    L22:
        boolean r1 = false;
        if (r8 == null) goto L28;
        Object r4 = r8.m1430unboximpl();
        if (Result.m1427isFailureimpl(r4) == false) goto L27;
        r4 = false;
    L27:
        r1 = ((Boolean) ZeusTransformUtils.preCheckCast(r4, Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    L28:
        if (r8 == null) goto L30;
        Throwable r9 = Result.m1424exceptionOrNullimpl(r8.m1430unboximpl());
    L31:
        if (r1 == false) goto L33;
        j = true;
    L33:
        com.obric.aiagent.platform.a.d.b r2 = com.obric.aiagent.platform.a.d.f5954a;
        StringBuilder r5 = new StringBuilder().append("bind res: ").append(r1).append(", error: ");
        if (r9 == null) goto L36;
        r3 = ExceptionsKt.stackTraceToString(r9);
    L36:
        r2.b("FlowAppLog", r5.append(r3).toString());
        return;
    L30:
        r9 = null;
        goto L31
    L40:
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L15
        Object r10 = Result.m1421constructorimpl(Boolean.valueOf(ZeusTransformUtils.bindService(r0, r7, (ServiceConnection) ZeusTransformUtils.preCheckCast(w, ServiceConnection.class, "com.obric.memorydata.plugin"), k, "com.obric.memorydata.plugin")));     // Catch: Throwable -> L15
    L17:
        Throwable r11 = Result.m1424exceptionOrNullimpl(r10);
        if (r11 == null) goto L20;
        com.obric.aiagent.platform.a.d.f5954a.b("FlowAppLog", "executeBind error: " + r11.getMessage(), r11);
    L20:
        r8 = Result.m1420boximpl(r10);
    L15:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        r10 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L17
    }

    private static final void l() {
        a r0 = f5912a;
        monitor-enter(r0);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (i == true) goto L7;
    L10:
        Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L13
        monitor-exit(r0);
        return;
    L7:
        if (l <= 0) goto L10;
        com.obric.aiagent.platform.a.d.f5954a.b("FlowAppLog", "auto unbind triggered, delayMs: " + l);     // Catch: Throwable -> L13
        r0.j();     // Catch: Throwable -> L13
        goto L10
    }

    public static /* synthetic */ Unit lambda$2q_nLXRaZ0L9R3kHgL7ICxUCm_Q(com.obric.aiagent.flow.applog.a.a r0) {
        return b(r0);
    }

    public static /* synthetic */ Unit lambda$2r8wZgFNY8RJr_8_gaRtwjP2REE() {
        return o();
    }

    public static /* synthetic */ void lambda$3iwGs8vdf9GhjdjzJmel5MfHf1k() {
        l();
    }

    /* JADX INFO: renamed from: lambda$AHO2-v3RsSVxMR0pa8jdUZTgx2U, reason: not valid java name */
    public static /* synthetic */ void m147lambda$AHO2v3RsSVxMR0pa8jdUZTgx2U(List r0, List r1, List r2, List r3, List r4, List r5) {
        a(r0, r1, r2, r3, r4, r5);
    }

    /* JADX INFO: renamed from: lambda$CPV-bERaIjQQ_uPhpvhYASmobvU, reason: not valid java name */
    public static /* synthetic */ Unit m148lambda$CPVbERaIjQQ_uPhpvhYASmobvU(String r0) {
        return h(r0);
    }

    /* JADX INFO: renamed from: lambda$H8XNrtHduMFMrUfRVmYr-AyHqM8, reason: not valid java name */
    public static /* synthetic */ Unit m149lambda$H8XNrtHduMFMrUfRVmYrAyHqM8(String r0, int r1) {
        return b(r0, r1);
    }

    public static /* synthetic */ Unit lambda$JK8wC7phqkor0jNhswmNmXfLats() {
        return n();
    }

    public static /* synthetic */ void lambda$Okoh1tDMBuznGK7ZbrFpnWT0Pxo(List r0) {
        a(r0);
    }

    public static /* synthetic */ Unit lambda$Z7eSNDpIXN5NqapaUSeoSXEHgfo() {
        return m();
    }

    private static final Unit m() {
        c r0 = g;
        if (r0 == null) goto L6;
        r0.a();
    L6:
        return Unit.INSTANCE;
    }

    private static final Unit n() {
        c r0 = g;
        if (r0 == null) goto L6;
        r0.b();
    L6:
        return Unit.INSTANCE;
    }

    private static final Unit o() {
        c r0 = g;
        if (r0 == null) goto L6;
        r0.c();
    L6:
        return Unit.INSTANCE;
    }

    public final void a() {
        monitor-enter(this);
        com.obric.aiagent.platform.a.d.f5954a.b("FlowAppLog", "unBind, context: " + f5913b);     // Catch: Throwable -> L6
        f5912a.j();     // Catch: Throwable -> L6
        Unit r0 = Unit.INSTANCE;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public final void a(Context r3, com.obric.aiagent.flow.applog.b r4, int r5, long r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        com.obric.aiagent.flow.applog.b r8 = (com.obric.aiagent.flow.applog.b) ZeusTransformUtils.wrapperContextForParams(r4, com.obric.aiagent.flow.applog.b.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "context");
        Intrinsics.checkNotNullParameter(r8, "listener");
        monitor-enter(this);
        a r0 = f5912a;     // Catch: Throwable -> L17
        r0.a(r6);     // Catch: Throwable -> L17
        if (i == false) goto L10;
        com.obric.aiagent.platform.a.d.f5954a.b("FlowAppLog", "has bind success, skip bind");     // Catch: Throwable -> L17
        r8.a();     // Catch: Throwable -> L17
        monitor-exit(this);
        return;
    L10:
        if (j == false) goto L14;
        com.obric.aiagent.platform.a.d.f5954a.b("FlowAppLog", "is binding, skip bind");     // Catch: Throwable -> L17
        p.a(r8);     // Catch: Throwable -> L17
        monitor-exit(this);
        return;
    L14:
        com.obric.aiagent.platform.a.d.f5954a.b("FlowAppLog", "bind: " + r5 + ", context: " + r7);     // Catch: Throwable -> L17
        k = r5;     // Catch: Throwable -> L17
        f5913b = r7;     // Catch: Throwable -> L17
        r0.k();     // Catch: Throwable -> L17
        Unit r9 = Unit.INSTANCE;     // Catch: Throwable -> L17
        monitor-exit(this);
        return;
    L17:
        th = move-exception;
        throw th;
    }

    public final void a(com.obric.aiagent.flow.applog.a.a r6) {
        final com.obric.aiagent.flow.applog.a.a r7 = (com.obric.aiagent.flow.applog.a.a) ZeusTransformUtils.wrapperContextForParams(r6, com.obric.aiagent.flow.applog.a.a.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "listener");
        monitor-enter(this);
        com.obric.aiagent.platform.a.d.f5954a.b("FlowAppLog", "addDataObserver");     // Catch: Throwable -> L22
    L17:
        e = move-exception;
        com.obric.aiagent.platform.a.d.f5954a.b("FlowAppLog", "addDataObserver error", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L22
    L19:
        Unit r8 = Unit.INSTANCE;     // Catch: Throwable -> L22
        monitor-exit(this);
        return;
    L6:
        if (i == false) goto L15;
        c r0 = g;     // Catch: Exception -> L17 Throwable -> L22
        if (r0 == null) goto L15;
        Intrinsics.checkNotNull(r0);     // Catch: Exception -> L17 Throwable -> L22
        if (r0.asBinder().isBinderAlive() == false) goto L15;
        c r1 = g;     // Catch: Exception -> L17 Throwable -> L22
        if (r1 == null) goto L14;
        r1.a(r7);     // Catch: Exception -> L17 Throwable -> L22
    L14:
        f5912a.g("addDataObserver");     // Catch: Exception -> L17 Throwable -> L22
    L15:
        u.a(new $$Lambda$a$2q_nLXRaZ0L9R3kHgL7ICxUCm_Q(r7));     // Catch: Exception -> L17 Throwable -> L22
        f5912a.k();     // Catch: Exception -> L17 Throwable -> L22
    L22:
        th = move-exception;
        throw th;
    }

    public final void a(String r6) {
        Intrinsics.checkNotNullParameter(r6, "event");
        monitor-enter(this);
    L16:
        th = move-exception;
        throw th;
    L18:
        e = move-exception;
        com.obric.aiagent.platform.a.d.f5954a.b("FlowAppLog", "onEventV3 error", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L16
    L20:
        Unit r7 = Unit.INSTANCE;     // Catch: Throwable -> L16
        monitor-exit(this);
        return;
    L5:
        if (i == false) goto L14;
        c r0 = g;     // Catch: Throwable -> L16 Exception -> L18
        if (r0 == null) goto L14;
        Intrinsics.checkNotNull(r0);     // Catch: Throwable -> L16 Exception -> L18
        if (r0.asBinder().isBinderAlive() == false) goto L14;
        c r1 = g;     // Catch: Throwable -> L16 Exception -> L18
        if (r1 == null) goto L13;
        r1.a(r6);     // Catch: Throwable -> L16 Exception -> L18
    L13:
        f5912a.g("onEventV3");     // Catch: Throwable -> L16 Exception -> L18
    L14:
        r.a(r6);     // Catch: Throwable -> L16 Exception -> L18
        f5912a.k();     // Catch: Throwable -> L16 Exception -> L18
        goto L20
    }

    public final void a(final String r5, final int r6) {
        Intrinsics.checkNotNullParameter(r5, "activity");
        monitor-enter(this);
        com.obric.aiagent.platform.a.d.f5954a.b("FlowAppLog", "onResume");     // Catch: Throwable -> L22
    L17:
        e = move-exception;
        com.obric.aiagent.platform.a.d.f5954a.b("FlowAppLog", "onResume error", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L22
    L19:
        Unit r7 = Unit.INSTANCE;     // Catch: Throwable -> L22
        monitor-exit(this);
        return;
    L6:
        if (i == false) goto L15;
        c r0 = g;     // Catch: Exception -> L17 Throwable -> L22
        if (r0 == null) goto L15;
        Intrinsics.checkNotNull(r0);     // Catch: Exception -> L17 Throwable -> L22
        if (r0.asBinder().isBinderAlive() == false) goto L15;
        com.obric.aiagent.platform.a.d.f5954a.b("FlowAppLog", "onBindSuccess onResume " + r5);     // Catch: Exception -> L17 Throwable -> L22
        c r1 = g;     // Catch: Exception -> L17 Throwable -> L22
        if (r1 == null) goto L14;
        r1.a(r5, r6);     // Catch: Exception -> L17 Throwable -> L22
    L14:
        f5912a.g("onResume");     // Catch: Exception -> L17 Throwable -> L22
    L15:
        com.obric.aiagent.platform.a.d.f5954a.b("FlowAppLog", "Cache onResume " + r5);     // Catch: Exception -> L17 Throwable -> L22
        u.a(new $$Lambda$a$H8XNrtHduMFMrUfRVmYrAyHqM8(r5, r6));     // Catch: Exception -> L17 Throwable -> L22
        f5912a.k();     // Catch: Exception -> L17 Throwable -> L22
    L22:
        th = move-exception;
        throw th;
    }

    public final void a(String r5, Bundle r6) {
        Intrinsics.checkNotNullParameter(r5, "event");
        monitor-enter(this);
    L18:
        e = move-exception;
        com.obric.aiagent.platform.a.d.f5954a.b("FlowAppLog", "onEventV3Bundle error", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L16
    L20:
        Unit r7 = Unit.INSTANCE;     // Catch: Throwable -> L16
        monitor-exit(this);
        return;
    L5:
        if (i == false) goto L14;
        c r0 = g;     // Catch: Throwable -> L16 Exception -> L18
        if (r0 == null) goto L14;
        Intrinsics.checkNotNull(r0);     // Catch: Throwable -> L16 Exception -> L18
        if (r0.asBinder().isBinderAlive() == false) goto L14;
        c r1 = g;     // Catch: Throwable -> L16 Exception -> L18
        if (r1 == null) goto L13;
        r1.a(r5, r6);     // Catch: Throwable -> L16 Exception -> L18
    L13:
        f5912a.g("onEventV3Bundle");     // Catch: Throwable -> L16 Exception -> L18
    L14:
        t.a(TuplesKt.to(r5, r6));     // Catch: Throwable -> L16 Exception -> L18
        f5912a.k();     // Catch: Throwable -> L16 Exception -> L18
    L16:
        th = move-exception;
        throw th;
    }

    public final void a(String r5, JSONObject r6) {
        Intrinsics.checkNotNullParameter(r5, "event");
        monitor-enter(this);
    L19:
        th = move-exception;
        throw th;
    L21:
        e = move-exception;
        com.obric.aiagent.platform.a.d.f5954a.b("FlowAppLog", "onEventV3Json error", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L19
    L23:
        Unit r7 = Unit.INSTANCE;     // Catch: Throwable -> L19
        monitor-exit(this);
        return;
    L5:
        if (i == false) goto L17;
        c r0 = g;     // Catch: Throwable -> L19 Exception -> L21
        if (r0 == null) goto L17;
        Intrinsics.checkNotNull(r0);     // Catch: Throwable -> L19 Exception -> L21
        if (r0.asBinder().isBinderAlive() == false) goto L17;
        c r1 = g;     // Catch: Throwable -> L19 Exception -> L21
        if (r1 == null) goto L16;
        if (r6 == null) goto L14;
        String r8 = r6.toString();     // Catch: Throwable -> L19 Exception -> L21
    L15:
        r1.a(r5, r8);     // Catch: Throwable -> L19 Exception -> L21
        goto L16
    L14:
        r8 = null;
    L16:
        f5912a.g("onEventV3Json");     // Catch: Throwable -> L19 Exception -> L21
    L17:
        s.a(TuplesKt.to(r5, r6));     // Catch: Throwable -> L19 Exception -> L21
        f5912a.k();     // Catch: Throwable -> L19 Exception -> L21
        goto L23
    }

    public final void b() {
        monitor-enter(this);
        com.obric.aiagent.platform.a.d.f5954a.b("FlowAppLog", "onPause");     // Catch: Throwable -> L21
    L16:
        e = move-exception;
        com.obric.aiagent.platform.a.d.f5954a.b("FlowAppLog", "onPause error", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L21
    L18:
        Unit r0 = Unit.INSTANCE;     // Catch: Throwable -> L21
        monitor-exit(this);
        return;
    L5:
        if (i == false) goto L14;
        c r1 = g;     // Catch: Exception -> L16 Throwable -> L21
        if (r1 == null) goto L14;
        Intrinsics.checkNotNull(r1);     // Catch: Exception -> L16 Throwable -> L21
        if (r1.asBinder().isBinderAlive() == false) goto L14;
        c r2 = g;     // Catch: Exception -> L16 Throwable -> L21
        if (r2 == null) goto L13;
        r2.a();     // Catch: Exception -> L16 Throwable -> L21
    L13:
        f5912a.g("onPause");     // Catch: Exception -> L16 Throwable -> L21
    L14:
        u.a($$Lambda$a$Z7eSNDpIXN5NqapaUSeoSXEHgfo.INSTANCE);     // Catch: Exception -> L16 Throwable -> L21
        f5912a.k();     // Catch: Exception -> L16 Throwable -> L21
    L21:
        th = move-exception;
        throw th;
    }

    public final void b(final String r6) {
        Intrinsics.checkNotNullParameter(r6, "launchService");
        monitor-enter(this);
        com.obric.aiagent.platform.a.d.f5954a.b("FlowAppLog", "setLaunchService " + r6);     // Catch: Throwable -> L22
    L17:
        e = move-exception;
        com.obric.aiagent.platform.a.d.f5954a.b("FlowAppLog", "setLaunchService error", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L22
    L19:
        Unit r7 = Unit.INSTANCE;     // Catch: Throwable -> L22
        monitor-exit(this);
        return;
    L6:
        if (i == false) goto L15;
        c r0 = g;     // Catch: Exception -> L17 Throwable -> L22
        if (r0 == null) goto L15;
        Intrinsics.checkNotNull(r0);     // Catch: Exception -> L17 Throwable -> L22
        if (r0.asBinder().isBinderAlive() == false) goto L15;
        c r1 = g;     // Catch: Exception -> L17 Throwable -> L22
        if (r1 == null) goto L14;
        r1.b(r6);     // Catch: Exception -> L17 Throwable -> L22
    L14:
        f5912a.g("setLaunchService");     // Catch: Exception -> L17 Throwable -> L22
    L15:
        u.a(new $$Lambda$a$CPVbERaIjQQ_uPhpvhYASmobvU(r6));     // Catch: Exception -> L17 Throwable -> L22
        f5912a.k();     // Catch: Exception -> L17 Throwable -> L22
    L22:
        th = move-exception;
        throw th;
    }

    public final void c() {
        monitor-enter(this);
        com.obric.aiagent.platform.a.d.f5954a.b("FlowAppLog", "onStop");     // Catch: Throwable -> L21
    L16:
        e = move-exception;
        com.obric.aiagent.platform.a.d.f5954a.b("FlowAppLog", "onStop error", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L21
    L18:
        Unit r0 = Unit.INSTANCE;     // Catch: Throwable -> L21
        monitor-exit(this);
        return;
    L5:
        if (i == false) goto L14;
        c r1 = g;     // Catch: Exception -> L16 Throwable -> L21
        if (r1 == null) goto L14;
        Intrinsics.checkNotNull(r1);     // Catch: Exception -> L16 Throwable -> L21
        if (r1.asBinder().isBinderAlive() == false) goto L14;
        c r2 = g;     // Catch: Exception -> L16 Throwable -> L21
        if (r2 == null) goto L13;
        r2.b();     // Catch: Exception -> L16 Throwable -> L21
    L13:
        f5912a.g("onStop");     // Catch: Exception -> L16 Throwable -> L21
    L14:
        u.a($$Lambda$a$JK8wC7phqkor0jNhswmNmXfLats.INSTANCE);     // Catch: Exception -> L16 Throwable -> L21
        f5912a.k();     // Catch: Exception -> L16 Throwable -> L21
    L21:
        th = move-exception;
        throw th;
    }

    public final void d() {
        monitor-enter(this);
        com.obric.aiagent.platform.a.d.f5954a.b("FlowAppLog", "clearLaunchService");     // Catch: Throwable -> L21
    L16:
        e = move-exception;
        com.obric.aiagent.platform.a.d.f5954a.b("FlowAppLog", "clearLaunchService error", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L21
    L18:
        Unit r0 = Unit.INSTANCE;     // Catch: Throwable -> L21
        monitor-exit(this);
        return;
    L5:
        if (i == false) goto L14;
        c r1 = g;     // Catch: Exception -> L16 Throwable -> L21
        if (r1 == null) goto L14;
        Intrinsics.checkNotNull(r1);     // Catch: Exception -> L16 Throwable -> L21
        if (r1.asBinder().isBinderAlive() == false) goto L14;
        c r2 = g;     // Catch: Exception -> L16 Throwable -> L21
        if (r2 == null) goto L13;
        r2.c();     // Catch: Exception -> L16 Throwable -> L21
    L13:
        f5912a.g("clearLaunchService");     // Catch: Exception -> L16 Throwable -> L21
    L14:
        u.a($$Lambda$a$2r8wZgFNY8RJr_8_gaRtwjP2REE.INSTANCE);     // Catch: Exception -> L16 Throwable -> L21
        f5912a.k();     // Catch: Exception -> L16 Throwable -> L21
    L21:
        th = move-exception;
        throw th;
    }
}
