package com.obric.matrix.platform.sdk.ones.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.memorydata.memory.ui.automemory.settings.MemoryInfoSectionEditActivity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0017*\u0004\n\r\u0010\u001d\u0018\u0000 O2\u00020\u0001:\u0002OPB\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u0017J\u0006\u0010&\u001a\u00020$J\u0006\u0010'\u001a\u00020$J\u0012\u0010(\u001a\u00020$2\b\b\u0002\u0010)\u001a\u00020\u0014H\u0002J\b\u0010*\u001a\u0004\u0018\u00010+J\b\u0010,\u001a\u0004\u0018\u00010+J\b\u0010-\u001a\u0004\u0018\u00010+J\b\u0010.\u001a\u0004\u0018\u00010+J\u000e\u0010/\u001a\u00020$2\u0006\u00100\u001a\u000201J\u000e\u00102\u001a\u00020$2\u0006\u00100\u001a\u000203J\u0016\u00104\u001a\u00020$2\u0006\u00100\u001a\u0002012\u0006\u00105\u001a\u000206J\"\u00107\u001a\u00020$2\b\b\u0002\u00108\u001a\u00020+2\u0006\u00109\u001a\u00020:2\b\u0010;\u001a\u0004\u0018\u000106J\u000e\u0010<\u001a\u00020$2\u0006\u00100\u001a\u000203J\u000e\u0010=\u001a\u00020$2\u0006\u00100\u001a\u000203J\u0016\u0010>\u001a\u00020$2\u0006\u0010?\u001a\u0002032\u0006\u0010@\u001a\u00020\u0014J\u001a\u0010A\u001a\u00020$2\u0006\u0010B\u001a\u00020+2\n\b\u0002\u0010C\u001a\u0004\u0018\u00010+J\u0016\u0010D\u001a\u00020$2\u0006\u0010E\u001a\u00020+2\u0006\u0010F\u001a\u000206J\u0018\u0010G\u001a\u00020$2\u0006\u0010E\u001a\u00020+2\u0006\u0010F\u001a\u000206H\u0002J\u001e\u0010H\u001a\u00020$2\u0006\u00108\u001a\u00020+2\u0006\u00100\u001a\u0002012\u0006\u0010I\u001a\u000206J\"\u0010H\u001a\u00020$2\u0006\u00108\u001a\u00020+2\b\u0010J\u001a\u0004\u0018\u00010+2\b\b\u0002\u00100\u001a\u000203J\b\u0010K\u001a\u00020$H\u0002J\u0006\u0010L\u001a\u00020$J\u000e\u0010M\u001a\u00020$2\u0006\u0010%\u001a\u00020\u0017J\f\u0010N\u001a\u000206*\u000206H\u0002R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001eR\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006Q"}, d2 = {"Lcom/obric/matrix/platform/sdk/ones/dataanalysis/MatrixTeaManager;", "", "context", "Landroid/content/Context;", "config", "Lcom/obric/matrix/platform/sdk/ones/dataanalysis/MatrixTeaConfig;", "(Landroid/content/Context;Lcom/obric/matrix/platform/sdk/ones/dataanalysis/MatrixTeaConfig;)V", "backgroundHandler", "Landroid/os/Handler;", "binderDeathRecipient", "com/obric/matrix/platform/sdk/ones/dataanalysis/MatrixTeaManager$binderDeathRecipient$1", "Lcom/obric/matrix/platform/sdk/ones/dataanalysis/MatrixTeaManager$binderDeathRecipient$1;", WsConstants.KEY_CONNECTION, "com/obric/matrix/platform/sdk/ones/dataanalysis/MatrixTeaManager$connection$1", "Lcom/obric/matrix/platform/sdk/ones/dataanalysis/MatrixTeaManager$connection$1;", "deviceInfoCallback", "com/obric/matrix/platform/sdk/ones/dataanalysis/MatrixTeaManager$deviceInfoCallback$1", "Lcom/obric/matrix/platform/sdk/ones/dataanalysis/MatrixTeaManager$deviceInfoCallback$1;", "handler", "isBound", "", "listeners", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/obric/matrix/platform/sdk/ones/dataanalysis/DeviceInfoListener;", "pendingEvents", "Lcom/obric/matrix/platform/sdk/ones/dataanalysis/MatrixTeaManager$PendingEvent;", "rebindRunnable", "Ljava/lang/Runnable;", "retryRunnable", "com/obric/matrix/platform/sdk/ones/dataanalysis/MatrixTeaManager$retryRunnable$1", "Lcom/obric/matrix/platform/sdk/ones/dataanalysis/MatrixTeaManager$retryRunnable$1;", "service", "Lcom/obric/matrix/platform/sdk/ones/dataanalysis/IDataService;", "serviceBinder", "Landroid/os/IBinder;", "addDeviceInfoListener", "", "listener", "bindService", "bindServiceInternal", "clearServiceConnectionState", "unlinkDeathRecipient", "getDeviceId", "", "getInstallId", "getOAID", "getUDID", "onApmColdLaunchFirstFrameEvent", "duration", "", "onApmColdLaunchFirstFrameEventTail", "", "onApmColdLaunchUserCompleteEvent", "extraInfo", "Lorg/json/JSONObject;", "onApmFpsEvent", "pageName", "fps", "", "frameDrop", "onApmHotLaunchEvent", "onApmHotLaunchEventTail", "onApmMemoryEvent", "memorySize", "isForeGround", "onButtonClickEvent", "componentName", MemoryInfoSectionEditActivity.KIND_SCENE, "onEvent", "eventName", "jsonObject", "onEventInternal", "onPageShowEvent", WsConstants.KEY_EXTRA, "prevPageName", "processPendingEvents", "rebindService", "removeDeviceInfoListener", "copyJson", "Companion", "PendingEvent", "sdk_platform_ones_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f8062a = null;
    private static e p;
    private static final AtomicBoolean q = null;
    private static String r;
    private static String s;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f8063b;
    private final com.obric.matrix.platform.sdk.ones.a.d c;
    private com.obric.matrix.platform.sdk.ones.a.b d;
    private IBinder e;
    private boolean f;
    private final CopyOnWriteArrayList<com.obric.matrix.platform.sdk.ones.a.a> g;
    private final Handler h;
    private final CopyOnWriteArrayList<b> i;
    private final Runnable j;
    private final c k;
    private final f l;
    private final Handler m;
    private final BinderC0399e n;
    private final d o;

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0017\u001a\u00020\u0012J\u0016\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dJ\u0006\u0010\u0013\u001a\u00020\u001eR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/obric/matrix/platform/sdk/ones/dataanalysis/MatrixTeaManager$Companion;", "", "()V", "BIND_RETRY_INTERVAL", "", "EVENT_APM_COLD_LAUNCH_FIRST_FRAME", "", "EVENT_APM_COLD_LAUNCH_FIRST_FRAME_TAIL", "EVENT_APM_COLD_USER_COMPLETE", "EVENT_APM_FPS", "EVENT_APM_HOT_LAUNCH", "EVENT_APM_HOT_LAUNCH_TAIL", "EVENT_APM_MEMORY", "EVENT_BUTTON_CLICK", "EVENT_PAGE_SHOW", "TAG", "did", "instance", "Lcom/obric/matrix/platform/sdk/ones/dataanalysis/MatrixTeaManager;", "isInited", "Ljava/util/concurrent/atomic/AtomicBoolean;", "mUDid", "myInstallId", "getInstance", CommonConsts.APM_INNER_EVENT_COST_INIT, "", "context", "Landroid/content/Context;", "config", "Lcom/obric/matrix/platform/sdk/ones/dataanalysis/MatrixTeaConfig;", "", "sdk_platform_ones_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public final e a() {
            if (e.d() == null) goto L7;
            e r1 = e.d();
            Intrinsics.checkNotNull(r1);
            return r1;
        L7:
            throw new IllegalStateException("MatrixTeaManager还没初始化，请先调用init方法进行初始化~~~".toString());
        }

        public final void a(Context r3, com.obric.matrix.platform.sdk.ones.a.d r4) {
            Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r2, "context");
            Intrinsics.checkNotNullParameter(r4, "config");
            if (e.d() == null) goto L5;
        L15:
            e r5 = e.d();
            Intrinsics.checkNotNull(r5);
            r5.bindService();
            return;
        L5:
            monitor-enter(e.class);
        L12:
            th = move-exception;
            throw th;
        L7:
            if (e.d() != null) goto L9;
            a r0 = e.f8062a;     // Catch: Throwable -> L12
            e.a(new e(r2, r4, null));     // Catch: Throwable -> L12
        L9:
            Unit r6 = Unit.INSTANCE;     // Catch: Throwable -> L12
            monitor-exit(e.class);
            goto L15
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/obric/matrix/platform/sdk/ones/dataanalysis/MatrixTeaManager$PendingEvent;", "", "eventName", "", "jsonObject", "Lorg/json/JSONObject;", "(Ljava/lang/String;Lorg/json/JSONObject;)V", "getEventName", "()Ljava/lang/String;", "getJsonObject", "()Lorg/json/JSONObject;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "sdk_platform_ones_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f8064a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final JSONObject f8065b;

        public b(String r2, JSONObject r3) {
            Intrinsics.checkNotNullParameter(r2, "eventName");
            Intrinsics.checkNotNullParameter(r3, "jsonObject");
            this.f8064a = r2;
            this.f8065b = r3;
        }

        public final String a() {
            return this.f8064a;
        }

        public final JSONObject b() {
            return this.f8065b;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
            return false;
        L8:
            b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f8064a, r6.f8064a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f8065b, r6.f8065b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.f8064a.hashCode() * 31) + this.f8065b.hashCode();
        }

        public String toString() {
            return "PendingEvent(eventName=" + this.f8064a + ", jsonObject=" + this.f8065b + ')';
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/obric/matrix/platform/sdk/ones/dataanalysis/MatrixTeaManager$binderDeathRecipient$1", "Landroid/os/IBinder$DeathRecipient;", "binderDied", "", "sdk_platform_ones_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class c implements IBinder.DeathRecipient {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ e f8066a;

        c(e r1) {
            this.f8066a = r1;
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            com.obric.matrix.platform.sdk.ones.internal.b.b.d("MatrixTeaManager", "dataanalysis service binder died", null, 4, null);
            e.a(this.f8066a, false);
            this.f8066a.a();
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\t"}, d2 = {"com/obric/matrix/platform/sdk/ones/dataanalysis/MatrixTeaManager$connection$1", "Landroid/content/ServiceConnection;", "onServiceConnected", "", ActivityLifecycle.NAME, "Landroid/content/ComponentName;", "service", "Landroid/os/IBinder;", "onServiceDisconnected", "sdk_platform_ones_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class d implements ServiceConnection {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ e f8067a;

        d(e r1) {
            this.f8067a = r1;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName r6, IBinder r7) {
            IBinder r8 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r7, IBinder.class, "com.obric.memorydata.plugin");
            com.obric.matrix.platform.sdk.ones.internal.b.b.b("MatrixTeaManager", "onServiceConnected: ", null, 4, null);     // Catch: Exception -> L12
            e.c(this.f8067a).removeCallbacksAndMessages(null);     // Catch: Exception -> L12
            if (r8 != null) goto L7;
            com.obric.matrix.platform.sdk.ones.internal.b.b.d("MatrixTeaManager", "onServiceConnected error, binder is null", null, 4, null);     // Catch: Exception -> L12
            this.f8067a.a();     // Catch: Exception -> L12
            return;
        L7:
            e.a(this.f8067a, false, 1, null);     // Catch: Exception -> L12
            r8.linkToDeath((IBinder.DeathRecipient) ZeusTransformUtils.preCheckCast(e.e(this.f8067a), IBinder.DeathRecipient.class, "com.obric.memorydata.plugin"), 0);     // Catch: Exception -> L12
            e.a(this.f8067a, r8);     // Catch: Exception -> L12
            e.a(this.f8067a, com.obric.matrix.platform.sdk.ones.a.b.a.a(r8));     // Catch: Exception -> L12
            e.b(this.f8067a, true);     // Catch: Exception -> L12
            com.obric.matrix.platform.sdk.ones.a.b r9 = e.f(this.f8067a);     // Catch: Exception -> L12
            if (r9 == null) goto L10;
            r9.a((com.obric.matrix.platform.sdk.ones.a.c) ZeusTransformUtils.preCheckCast(e.g(this.f8067a), com.obric.matrix.platform.sdk.ones.a.c.class, "com.obric.memorydata.plugin"));     // Catch: Exception -> L12
        L10:
            e.h(this.f8067a);     // Catch: Exception -> L12
            return;
        L12:
            e = move-exception;
            com.obric.matrix.platform.sdk.ones.internal.b.b.d("MatrixTeaManager", "onServiceConnected error", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
            this.f8067a.a();
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName r1) {
            this.f8067a.a();
        }
    }

    /* JADX INFO: renamed from: com.obric.matrix.platform.sdk.ones.a.e$e, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0005H\u0016¨\u0006\b"}, d2 = {"com/obric/matrix/platform/sdk/ones/dataanalysis/MatrixTeaManager$deviceInfoCallback$1", "Lcom/obric/matrix/platform/sdk/ones/dataanalysis/IDeviceInfoCallback$Stub;", "onDeviceId", "", "deviceId", "", "onInstallId", "installId", "sdk_platform_ones_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class BinderC0399e extends com.obric.matrix.platform.sdk.ones.a.c.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ e f8068a;

        BinderC0399e(e r1) {
            this.f8068a = r1;
        }

        @Override // com.obric.matrix.platform.sdk.ones.a.c
        public void a(String r8) {
            Intrinsics.checkNotNullParameter(r8, "deviceId");
            com.obric.matrix.platform.sdk.ones.internal.b.b.b("MatrixTeaManager", "回调deviceId: " + r8 + "， listeners.size = " + e.d(this.f8068a).size(), null, 4, null);
            a r0 = e.f8062a;
            e.a(r8);
            Iterator r7 = ((Iterable) ZeusTransformUtils.preCheckCast(e.d(this.f8068a), Iterable.class, "com.obric.memorydata.plugin")).iterator();
        L4:
            if (r7.hasNext() == false) goto L6;
            com.obric.matrix.platform.sdk.ones.a.a r1 = (com.obric.matrix.platform.sdk.ones.a.a) ZeusTransformUtils.preCheckCast(r7.next(), com.obric.matrix.platform.sdk.ones.a.a.class, "com.obric.memorydata.plugin");
            com.obric.matrix.platform.sdk.ones.internal.b.b.b("MatrixTeaManager", "回调deviceId了，开始回调listener: " + r8 + " , listener = " + r1, null, 4, null);
            r1.onDeviceIdLoaded(r8);
            goto L4
        }

        @Override // com.obric.matrix.platform.sdk.ones.a.c
        public void b(String r4) {
            Intrinsics.checkNotNullParameter(r4, "installId");
            a r0 = e.f8062a;
            e.b(r4);
            Iterator r3 = ((Iterable) ZeusTransformUtils.preCheckCast(e.d(this.f8068a), Iterable.class, "com.obric.memorydata.plugin")).iterator();
        L4:
            if (r3.hasNext() == false) goto L6;
            ((com.obric.matrix.platform.sdk.ones.a.a) ZeusTransformUtils.preCheckCast(r3.next(), com.obric.matrix.platform.sdk.ones.a.a.class, "com.obric.memorydata.plugin")).onInstallIdLoaded(r4);
            goto L4
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/obric/matrix/platform/sdk/ones/dataanalysis/MatrixTeaManager$retryRunnable$1", "Ljava/lang/Runnable;", "run", "", "sdk_platform_ones_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class f implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ e f8069a;

        f(e r1) {
            this.f8069a = r1;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (e.b(this.f8069a) == true) goto L6;
            com.obric.matrix.platform.sdk.ones.internal.b.b.b("MatrixTeaManager", "尝试重新绑定下载服务", null, 4, null);
            this.f8069a.b();
            e.c(this.f8069a).postDelayed((Runnable) ZeusTransformUtils.preCheckCast(this, Runnable.class, "com.obric.memorydata.plugin"), 5000);
            return;
        }
    }

    static {
        f8062a = new a(null);
        q = new AtomicBoolean(false);
    }

    private e(Context r3, com.obric.matrix.platform.sdk.ones.a.d r4) {
        this.f8063b = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
        this.c = r4;
        this.g = new CopyOnWriteArrayList();
        this.h = new Handler(Looper.getMainLooper());
        this.i = new CopyOnWriteArrayList();
        this.j = new $$Lambda$e$Z_LjzaqCxn9f65S6uwT6Plzn1c(this);
        this.k = new c(this);
        this.l = new f(this);
        HandlerThread r5 = new HandlerThread("MatrixTeaBackgroundThread");
        r5.start();
        this.m = new Handler(r5.getLooper());
        this.n = new BinderC0399e(this);
        this.o = new d(this);
    }

    public /* synthetic */ e(Context r2, com.obric.matrix.platform.sdk.ones.a.d r3, DefaultConstructorMarker r4) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"), r3);
    }

    private final JSONObject a(JSONObject r5) {
        List r4 = (List) ZeusTransformUtils.preCheckCast(new LinkedList(), List.class, "com.obric.memorydata.plugin");
        Iterator<String> r0 = r5.keys();
    L4:
        if (r0.hasNext() == false) goto L22;
        String r2 = r0.next();
        Intrinsics.checkNotNullExpressionValue(r2, "keysIterable.next()");
        r4.add(r2);
        goto L4
    L22:
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L11
        Object[] r6 = ((Collection) ZeusTransformUtils.preCheckCast(r4, Collection.class, "com.obric.memorydata.plugin")).toArray(new String[0]);     // Catch: Throwable -> L11
        if (r6 == null) goto L10;
        Object r7 = Result.m1421constructorimpl(new JSONObject(r5, (String[]) ZeusTransformUtils.preCheckCast(r6, String[].class, "com.obric.memorydata.plugin")));     // Catch: Throwable -> L11
    L13:
        Throwable r3 = Result.m1424exceptionOrNullimpl(r7);
        if (r3 == null) goto L16;
        com.obric.matrix.platform.sdk.ones.internal.b.b.d("MatrixTeaManager", "copyJson error", r3);
    L16:
        Object r8 = r5;
        if (Result.m1427isFailureimpl(r7) == true) goto L21;
        r8 = r7;
    L21:
        return (JSONObject) ZeusTransformUtils.preCheckCast(r8, JSONObject.class, "com.obric.memorydata.plugin");
    L10:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        Result.Companion r9 = Result.Companion;
        r7 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L13
    }

    public static final /* synthetic */ void a(e r0) {
        p = r0;
    }

    public static final /* synthetic */ void a(e r2, IBinder r3) {
        r2.e = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.memorydata.plugin");
    }

    public static final /* synthetic */ void a(e r2, com.obric.matrix.platform.sdk.ones.a.b r3) {
        r2.d = (com.obric.matrix.platform.sdk.ones.a.b) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.matrix.platform.sdk.ones.a.b.class, "com.obric.memorydata.plugin");
    }

    private static final void a(e r1, String r2, JSONObject r3, JSONObject r4) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        Intrinsics.checkNotNullParameter(r2, "$eventName");
        Intrinsics.checkNotNullParameter(r3, "$copyJson");
        Intrinsics.checkNotNullParameter(r4, "$jsonObject");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L9
        com.obric.matrix.platform.sdk.ones.a.b r5 = r1.d;     // Catch: Throwable -> L9
        if (r5 == null) goto L6;
        r5.a(r2, r3.toString());     // Catch: Throwable -> L9
        Unit r6 = Unit.INSTANCE;     // Catch: Throwable -> L9
    L7:
        Object r7 = Result.m1421constructorimpl(r6);     // Catch: Throwable -> L9
    L11:
        Throwable r8 = Result.m1424exceptionOrNullimpl(r7);
        if (r8 == null) goto L17;
        r1.i.add(new b(r2, r4));
        com.obric.matrix.platform.sdk.ones.internal.b.b.d("MatrixTeaManager", "onEvent error", r8);
        return;
    L17:
        return;
    L6:
        r6 = null;
    L9:
        th = move-exception;
        Result.Companion r9 = Result.Companion;
        r7 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L11
    }

    public static final /* synthetic */ void a(e r0, boolean r1) {
        r0.a(r1);
    }

    static /* synthetic */ void a(e r0, boolean r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = true;
    L5:
        r0.a(r1);
    }

    public static final /* synthetic */ void a(String r0) {
        r = r0;
    }

    private final void a(boolean r6) {
        if (r6 == false) goto L13;
        IBinder r7 = this.e;
        if (r7 == null) goto L13;
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L8
        Object r8 = Result.m1421constructorimpl(Boolean.valueOf(r7.unlinkToDeath((IBinder.DeathRecipient) ZeusTransformUtils.preCheckCast(((e) ZeusTransformUtils.preCheckCast(this, e.class, "com.obric.memorydata.plugin")).k, IBinder.DeathRecipient.class, "com.obric.memorydata.plugin"), 0)));     // Catch: Throwable -> L8
    L10:
        Throwable r9 = Result.m1424exceptionOrNullimpl(r8);
        if (r9 == null) goto L13;
        com.obric.matrix.platform.sdk.ones.internal.b.b.b("MatrixTeaManager", "unlinkToDeath skipped: " + r9.getMessage(), null, 4, null);
    L8:
        th = move-exception;
        Result.Companion r0 = Result.Companion;
        r8 = Result.m1421constructorimpl(ResultKt.createFailure(th));
    L13:
        this.e = null;
        this.d = null;
        this.f = false;
    }

    public static final /* synthetic */ void b(e r0, boolean r1) {
        r0.f = r1;
    }

    public static final /* synthetic */ void b(String r0) {
        s = r0;
    }

    private final void b(final String r4, final JSONObject r5) {
        final JSONObject r0 = a(r5);
        this.m.post(new $$Lambda$e$f1F0wLctWyJ3PcNN5Ek74qLp8s(this, r4, r0, r5));
    }

    public static final /* synthetic */ boolean b(e r0) {
        return r0.f;
    }

    public static final /* synthetic */ Handler c(e r0) {
        return r0.h;
    }

    public static final /* synthetic */ e d() {
        return p;
    }

    public static final /* synthetic */ CopyOnWriteArrayList d(e r0) {
        return r0.g;
    }

    public static final /* synthetic */ c e(e r0) {
        return r0.k;
    }

    private final void e() {
        if (this.i.isEmpty() == false) goto L6;
        com.obric.matrix.platform.sdk.ones.internal.b.b.b("MatrixTeaManager", "没有暂存的事件需要处理", null, 4, null);
        return;
    L6:
        com.obric.matrix.platform.sdk.ones.internal.b.b.b("MatrixTeaManager", "开始处理 " + this.i.size() + " 个暂存事件", null, 4, null);
        Iterable r0 = (Iterable) ZeusTransformUtils.preCheckCast(this.i, Iterable.class, "com.obric.memorydata.plugin");
        Collection r4 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r1 = r0.iterator();
    L8:
        if (r1.hasNext() == false) goto L20;
        Object r6 = r1.next();
        b r7 = (b) ZeusTransformUtils.preCheckCast(r6, b.class, "com.obric.memorydata.plugin");
        boolean r8 = false;
        JSONObject r10 = new JSONObject(r7.b().toString());     // Catch: Exception -> L16
        r10.put("app_package_name", this.c.a());     // Catch: Exception -> L16
        r10.put("app_version_code", this.c.b());     // Catch: Exception -> L16
        r10.put("app_version_name", this.c.c());     // Catch: Exception -> L16
        if (this.c.d() == false) goto L13;
        int r12 = 1;
    L14:
        r10.put("app_is_boe", r12);     // Catch: Exception -> L16
        b(r7.a(), r10);     // Catch: Exception -> L16
        com.obric.matrix.platform.sdk.ones.internal.b.b.b("MatrixTeaManager", "成功发送暂存事件: " + r7.a(), null, 4, null);     // Catch: Exception -> L16
    L18:
        if (r8 == false) goto L8;
        r4.add(r6);
        goto L8
    L13:
        r12 = 0;
    L16:
        e = move-exception;
        com.obric.matrix.platform.sdk.ones.internal.b.b.d("MatrixTeaManager", "发送暂存事件 " + r7.a() + " 失败", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        r8 = true;
        goto L18
    L20:
        List r2 = (List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.memorydata.plugin");
        this.i.clear();
        this.i.addAll((Collection) ZeusTransformUtils.preCheckCast(r2, Collection.class, "com.obric.memorydata.plugin"));
    }

    public static final /* synthetic */ com.obric.matrix.platform.sdk.ones.a.b f(e r0) {
        return r0.d;
    }

    public static final /* synthetic */ BinderC0399e g(e r0) {
        return r0.n;
    }

    public static final /* synthetic */ void h(e r0) {
        r0.e();
    }

    private static final void i(e r4) {
        Intrinsics.checkNotNullParameter(r4, "this$0");
        r4.b();
        r4.h.removeCallbacks((Runnable) ZeusTransformUtils.preCheckCast(r4.l, Runnable.class, "com.obric.memorydata.plugin"));
        r4.h.postDelayed((Runnable) ZeusTransformUtils.preCheckCast(r4.l, Runnable.class, "com.obric.memorydata.plugin"), 5000);
    }

    /* JADX INFO: renamed from: lambda$Z-_LjzaqCxn9f65S6uwT6Plzn1c, reason: not valid java name */
    public static /* synthetic */ void m423lambda$Z_LjzaqCxn9f65S6uwT6Plzn1c(e r0) {
        i(r0);
    }

    /* JADX INFO: renamed from: lambda$f1F0wL-ctWyJ3PcNN5Ek74qLp8s, reason: not valid java name */
    public static /* synthetic */ void m424lambda$f1F0wLctWyJ3PcNN5Ek74qLp8s(e r0, String r1, JSONObject r2, JSONObject r3) {
        a(r0, r1, r2, r3);
    }

    public final void a() {
        a(this, false, 1, null);     // Catch: Exception -> L5
        this.h.removeCallbacks(this.j);     // Catch: Exception -> L5
        this.h.postDelayed(this.j, 3000);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        com.obric.matrix.platform.sdk.ones.internal.b.b.d("MatrixTeaManager", "rebindService error", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
    }

    public final void a(com.obric.matrix.platform.sdk.ones.a.a r8) {
        com.obric.matrix.platform.sdk.ones.a.a r9 = (com.obric.matrix.platform.sdk.ones.a.a) ZeusTransformUtils.wrapperContextForParams(r8, com.obric.matrix.platform.sdk.ones.a.a.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r9, "listener");
        com.obric.matrix.platform.sdk.ones.internal.b.b.b("MatrixTeaManager", "addDeviceInfoListener " + r9, null, 4, null);
        if (this.g.contains(r9) == true) goto L5;
        this.g.add(r9);
        com.obric.matrix.platform.sdk.ones.internal.b.b.b("MatrixTeaManager", "addDeviceInfoListener不包含，添加进listeners中,当前size = " + this.g.size(), null, 4, null);
    L5:
        CharSequence r7 = (CharSequence) ZeusTransformUtils.preCheckCast(r, CharSequence.class, "com.obric.memorydata.plugin");
        boolean r0 = false;
        if (r7 != null) goto L8;
    L11:
        boolean r10 = true;
    L12:
        if (r10 == true) goto L14;
        com.obric.matrix.platform.sdk.ones.internal.b.b.b("MatrixTeaManager", "注册deviceInfoListener时did有值，立即回调 " + r, null, 4, null);
        String r11 = r;
        Intrinsics.checkNotNull(r11);
        r9.onDeviceIdLoaded(r11);
    L14:
        CharSequence r12 = (CharSequence) ZeusTransformUtils.preCheckCast(s, CharSequence.class, "com.obric.memorydata.plugin");
        if (r12 != null) goto L17;
    L18:
        r0 = true;
    L19:
        if (r0 == true) goto L22;
        com.obric.matrix.platform.sdk.ones.internal.b.b.b("MatrixTeaManager", "注册deviceInfoListener时installId有值，立即回调 " + s, null, 4, null);
        String r13 = s;
        Intrinsics.checkNotNull(r13);
        r9.onInstallIdLoaded(r13);
        return;
    L22:
        return;
    L17:
        if (r12.length() != 0) goto L19;
    L8:
        if (r7.length() == 0) goto L11;
        r10 = false;
        goto L12
    }

    public final void a(String r2, float r3, JSONObject r4) {
        Intrinsics.checkNotNullParameter(r2, "pageName");
        if (r4 != null) goto L5;
        r4 = new JSONObject();
    L5:
        r4.put("page_name", r2);
        r4.put("fps", Float.valueOf(r3));
        a("apm_event_fps", r4);
    }

    public final void a(String r7, JSONObject r8) {
        Intrinsics.checkNotNullParameter(r7, "eventName");
        Intrinsics.checkNotNullParameter(r8, "jsonObject");
        String r1 = r8.toString();     // Catch: Throwable -> L24
        Intrinsics.checkNotNullExpressionValue(r1, "jsonObject.toString()");     // Catch: Throwable -> L24
        byte[] r2 = r1.getBytes(Charsets.UTF_8);     // Catch: Throwable -> L24
        Intrinsics.checkNotNullExpressionValue(r2, "this as java.lang.String).getBytes(charset)");     // Catch: Throwable -> L24
        int r3 = r2.length;     // Catch: Throwable -> L24
        if (r3 <= 204800) goto L9;
        com.obric.matrix.platform.sdk.ones.internal.b.b.d("MatrixTeaManager", "事件 " + r7 + " 数据大小 " + r3 + " 字节超过200KB限制，已丢弃", null, 4, null);
        return;
    L9:
        if (this.f == true) goto L29;
        this.i.add(new b(r7, new JSONObject(r8.toString())));     // Catch: Exception -> L20
        com.obric.matrix.platform.sdk.ones.internal.b.b.b("MatrixTeaManager", "服务未绑定，暂存事件: " + r7 + " 成功，当前暂存数量: " + this.i.size(), null, 4, null);     // Catch: Exception -> L20
        return;
    L20:
        e = move-exception;
        String r9 = "服务未绑定，暂存事件 " + r7 + " 失败";
        Throwable r6 = (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin");
    L22:
        com.obric.matrix.platform.sdk.ones.internal.b.b.d("MatrixTeaManager", r9, r6);
        return;
    L29:
        r8.put("app_package_name", this.c.a());     // Catch: Exception -> L16
        r8.put("app_version_code", this.c.b());     // Catch: Exception -> L16
        r8.put("app_version_name", this.c.c());     // Catch: Exception -> L16
        if (this.c.d() == false) goto L13;
        int r4 = 1;
    L14:
        r8.put("app_is_boe", r4);     // Catch: Exception -> L16
        b(r7, r8);     // Catch: Exception -> L16
        return;
    L13:
        r4 = 0;
    L16:
        e = move-exception;
        r6 = (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin");
        r9 = "onEvent error";
    L24:
        th = move-exception;
        com.obric.matrix.platform.sdk.ones.internal.b.b.d("MatrixTeaManager", "计算事件大小失败，已丢弃事件 " + r7, th);
    }

    public final void b() {
        if (this.f == false) goto L6;
        com.obric.matrix.platform.sdk.ones.internal.b.b.b("MatrixTeaManager", "bindServiceInternal: service is already bound", null, 4, null);
        return;
    L6:
        Intent r0 = new Intent();
        r0.setAction("com.obric.matrix.dataanalysis.service");
        r0.setPackage("com.obric.matrix");
        ZeusTransformUtils.bindService(this.f8063b, r0, (ServiceConnection) ZeusTransformUtils.preCheckCast(this.o, ServiceConnection.class, "com.obric.memorydata.plugin"), 1, "com.obric.memorydata.plugin");
    }

    public final void b(com.obric.matrix.platform.sdk.ones.a.a r5) {
        com.obric.matrix.platform.sdk.ones.a.a r6 = (com.obric.matrix.platform.sdk.ones.a.a) ZeusTransformUtils.wrapperContextForParams(r5, com.obric.matrix.platform.sdk.ones.a.a.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "listener");
        this.g.remove(r6);     // Catch: Exception -> L5
        com.obric.matrix.platform.sdk.ones.internal.b.b.b("MatrixTeaManager", "removeDeviceInfoListener " + r6 + ", size = " + this.g.size(), null, 4, null);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        com.obric.matrix.platform.sdk.ones.internal.b.b.d("MatrixTeaManager", "removeDeviceInfoListener error", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
    }

    public final void bindService() {
        if (q.compareAndSet(false, true) == true) goto L6;
        com.obric.matrix.platform.sdk.ones.internal.b.b.a("tea has inited");
        return;
    L6:
        b();
        this.h.postDelayed((Runnable) ZeusTransformUtils.preCheckCast(this.l, Runnable.class, "com.obric.memorydata.plugin"), 5000);
    }

    public final String c() {
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(r, CharSequence.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L10:
        if (r1 == true) goto L14;
        com.obric.matrix.platform.sdk.ones.internal.b.b.b("MatrixTeaManager", "getDeviceId 有值，立即回调 " + r, null, 4, null);
        return r;
    L14:
        if (this.f == true) goto L26;
        com.obric.matrix.platform.sdk.ones.internal.b.b.d("MatrixTeaManager", "getDeviceId error,Service not bounded", null, 4, null);
        return null;
    L26:
        com.obric.matrix.platform.sdk.ones.a.b r5 = this.d;     // Catch: Exception -> L21
        if (r5 == null) goto L18;
        String r6 = r5.a();     // Catch: Exception -> L21
    L19:
        r = r6;     // Catch: Exception -> L21
        return r6;
    L18:
        r6 = null;
    L21:
        e = move-exception;
        com.obric.matrix.platform.sdk.ones.internal.b.b.d("MatrixTeaManager", "getDeviceId error", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        return null;
    L5:
        if (r0.length() == 0) goto L8;
        r1 = false;
        goto L10
    }
}
