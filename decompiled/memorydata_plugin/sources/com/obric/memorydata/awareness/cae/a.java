package com.obric.memorydata.awareness.cae;

import android.content.Context;
import android.os.RemoteException;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.crash.entity.EventBody;
import com.obric.cae.libs.useraware.CellAwareInfo;
import com.obric.cae.libs.useraware.WifiStandardData;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.bdtracker.Tracker;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.utils.q;
import com.obric.memorydata.utils.u;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.al;
import kotlinx.coroutines.am;
import kotlinx.coroutines.ba;
import kotlinx.coroutines.cu;
import kotlinx.coroutines.flow.ae;
import kotlinx.coroutines.flow.at;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\u0018\u0000 (2\u00020\u0001:\u0001(B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0019\u001a\u00020\u0016J\b\u0010\u001a\u001a\u00020\u0016H\u0002J\u0014\u0010\u001b\u001a\u00020\u00162\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dJ\u000e\u0010\u001f\u001a\u00020\u00162\u0006\u0010 \u001a\u00020!J\u000e\u0010\"\u001a\u00020\u00162\u0006\u0010 \u001a\u00020!J\u0014\u0010#\u001a\u00020\u00162\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dJ\u0006\u0010$\u001a\u00020\u0016J\u0016\u0010%\u001a\u00020\u00162\u0006\u0010&\u001a\u00020\u00102\u0006\u0010'\u001a\u00020\u000bR\"\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/obric/memorydata/awareness/cae/CAEAwareClient;", "", "<init>", "()V", EventBody.KEY_VALUE, "Lcom/obric/cae/libs/useraware/UserAwareAdapter;", "service", "getService", "()Lcom/obric/cae/libs/useraware/UserAwareAdapter;", "serviceBindState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "getServiceBindState", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "wifiInfoChangeCallback", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/obric/memorydata/awareness/cae/WifiInfoChangeCallback;", "ioScope", "Lkotlinx/coroutines/CoroutineScope;", "permissionListenerRegistered", "locationPermissionChangeListener", "Lkotlin/Function0;", "", "caeCallback", "Lcom/obric/cae/libs/useraware/ICaeUserAwareCallback;", CommonConsts.APM_INNER_EVENT_COST_INIT, "registerLocationPermissionListenerIfNeeded", "addBssidsToAvoidRomingScan", "bssids", "", "", "notifyGeofenceChanged", "event", "", "notifyRoomChangedPredicted", "addHomeWifiBssids", "release", "registerWifiInfoCallback", "callback", "register", "Companion", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0431a f8559a = null;
    private static final Lazy<a> i = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.obric.cae.libs.useraware.f f8560b;
    private final ae<Boolean> c;
    private final CopyOnWriteArrayList<j> d;
    private final al e;
    private boolean f;
    private final Function0<Unit> g;
    private final com.obric.cae.libs.useraware.d h;

    /* JADX INFO: renamed from: com.obric.memorydata.awareness.cae.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\f\u001a\u00020\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/obric/memorydata/awareness/cae/CAEAwareClient$Companion;", "", "<init>", "()V", "TAG", "", "instanceLazy", "Lcom/obric/memorydata/awareness/cae/CAEAwareClient;", "getInstanceLazy", "()Lcom/obric/memorydata/awareness/cae/CAEAwareClient;", "instanceLazy$delegate", "Lkotlin/Lazy;", "getInstance", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class C0431a {
        private C0431a() {
        }

        public /* synthetic */ C0431a(DefaultConstructorMarker r1) {
            this();
        }

        private final a b() {
            return (a) ZeusTransformUtils.preCheckCast(a.d().getValue(), a.class, "com.obric.memorydata.plugin");
        }

        public final a a() {
            return b();
        }
    }

    @Metadata(d1 = {"\u0000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005H\u0016J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\u0006H\u0016J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0012\u0010\f\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\u001a\u0010\u000f\u001a\u00020\u00032\u0010\u0010\u0010\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0018\u00010\u0011H\u0016J\u001c\u0010\u0012\u001a\u00020\u00032\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016J\u001a\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0014H\u0016¨\u0006\u001a"}, d2 = {"com/obric/memorydata/awareness/cae/CAEAwareClient$caeCallback$1", "Lcom/obric/cae/libs/useraware/ICaeUserAwareCallback$Stub;", "onWifiScanInfoChanged", "", "results", "", "Lcom/obric/cae/libs/useraware/WifiStandardData;", "onWifiConnectInfoChanged", "info", "onWifiNetworkAvailable", "available", "", "onCellInfoChange", "cellInfo", "Lcom/obric/cae/libs/useraware/CellAwareInfo;", "onCellNeighbourInfoChange", "cellInfos", "", "onUserAwareReportData", "p0", "", "p1", "onInSubWayChange", "isInSubway", "", "stationName", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b extends com.obric.cae.libs.useraware.d.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ a f8561a;

        b(a r1) {
            this.f8561a = r1;
        }

        @Override // com.obric.cae.libs.useraware.d
        public void a(int r8, String r9) {
            boolean r0 = true;
            if (r8 == 0) goto L7;
            if (r8 == 1) goto L7;
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "CAEAwareClient", "ignore invalid subway state: " + r8, null, 4, null);
            return;
        L7:
            if (r9 == null) goto L9;
            String r10 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.memorydata.plugin")).toString();
        L10:
            if (r10 != null) goto L12;
            r10 = "";
        L12:
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "CAEAwareClient", "收到地铁状态变化，isInSubway=" + r8 + "，stationName=" + q.f13259a.a(r10), false, 4, null);
            com.obric.memorydata.awareness.impl.location.b r7 = com.obric.memorydata.awareness.impl.location.b.f8730a;
            if (r8 == 1) goto L16;
            r0 = false;
        L16:
            r7.a(r0, r10);
            return;
        L9:
            r10 = null;
            goto L10
        }

        @Override // com.obric.cae.libs.useraware.d
        public void a(CellAwareInfo r10) {
            RunLog r0 = RunLog.INSTANCE;
            StringBuilder r1 = new StringBuilder().append("Cell info changed: ");
            if (r10 == null) goto L5;
            String r3 = u.a(r10);
        L6:
            r0.debug("CAEAwareClient", r1.append(r3).toString());
            if (r10 != null) goto L9;
            return;
        L9:
            kotlinx.coroutines.i.a(a.c(this.f8561a), null, null, (Function2) ZeusTransformUtils.preCheckCast(new CAEAwareClient$caeCallback$1$onCellInfoChange$1(new StringBuilder().append(r10.getMci()).append('_').append(r10.getPci()).append('_').append(r10.getTac()).toString(), r10, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
            return;
        L5:
            r3 = null;
            goto L6
        }

        @Override // com.obric.cae.libs.useraware.d
        public void a(WifiStandardData r4) {
            if (r4 == null) goto L7;
            Iterator r3 = ((Iterable) ZeusTransformUtils.preCheckCast(a.b(this.f8561a), Iterable.class, "com.obric.memorydata.plugin")).iterator();
        L5:
            if (r3.hasNext() == false) goto L9;
            ((j) ZeusTransformUtils.preCheckCast(r3.next(), j.class, "com.obric.memorydata.plugin")).a(r4);
            goto L5
        L9:
            return;
        }

        @Override // com.obric.cae.libs.useraware.d
        public void a(String r7, String r8) {
            CharSequence r6 = (CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.memorydata.plugin");
            boolean r1 = false;
            if (r6 != null) goto L5;
        L8:
            boolean r9 = true;
        L9:
            if (r9 == true) goto L19;
            CharSequence r10 = (CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.memorydata.plugin");
            if (r10 != null) goto L13;
        L14:
            r1 = true;
        L15:
            if (r1 == true) goto L19;
            Tracker.INSTANCE.reportEvent(r7, new JSONObject(r8));
            return;
        L13:
            if (r10.length() != 0) goto L15;
        L19:
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "CAEAwareClient", "p0 is " + r7 + ", p1 is " + r8 + ", onUserAwareReportData return", false, 4, null);
            return;
        L5:
            if (r6.length() == 0) goto L8;
            r9 = false;
            goto L9
        }

        @Override // com.obric.cae.libs.useraware.d
        public void a(List<WifiStandardData> r4) {
            List<? extends WifiStandardData> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
            Iterator r3 = ((Iterable) ZeusTransformUtils.preCheckCast(a.b(this.f8561a), Iterable.class, "com.obric.memorydata.plugin")).iterator();
        L4:
            if (r3.hasNext() == false) goto L10;
            j r0 = (j) ZeusTransformUtils.preCheckCast(r3.next(), j.class, "com.obric.memorydata.plugin");
            if (r5 != null) goto L8;
            List<? extends WifiStandardData> r2 = CollectionsKt.emptyList();
        L9:
            r0.a(r2);
            goto L4
        L8:
            r2 = r5;
            goto L9
        }

        @Override // com.obric.cae.libs.useraware.d
        public void a(boolean r7) {
            Iterator r6 = ((Iterable) ZeusTransformUtils.preCheckCast(a.b(this.f8561a), Iterable.class, "com.obric.memorydata.plugin")).iterator();
        L4:
            if (r6.hasNext() == false) goto L6;
            ((j) ZeusTransformUtils.preCheckCast(r6.next(), j.class, "com.obric.memorydata.plugin")).a(r7);
            goto L4
        L6:
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "CAEAwareClient", "WiFi network available: " + r7, false, 4, null);
        }

        @Override // com.obric.cae.libs.useraware.d
        public void b(List<? extends CellAwareInfo> r3) {
            List r2 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            RunLog r4 = RunLog.INSTANCE;
            StringBuilder r0 = new StringBuilder().append("Cell neighbour info changed: ");
            if (r2 == null) goto L5;
            String r5 = u.a(r2);
        L6:
            r4.debug("CAEAwareClient", r0.append(r5).toString());
            return;
        L5:
            r5 = null;
            goto L6
        }
    }

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016¨\u0006\u0007"}, d2 = {"com/obric/memorydata/awareness/cae/CAEAwareClient$init$1", "Lcom/obric/cae/libs/useraware/UserAwareAdapter$ServiceConnectionListener;", "onServiceConnected", "", "p0", "Lcom/obric/cae/libs/useraware/UserAwareAdapter;", "onServiceDisconnected", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class c implements com.obric.cae.libs.useraware.f.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ a f8562a;

        c(a r1) {
            this.f8562a = r1;
        }

        @Override // com.obric.cae.libs.useraware.f.a
        public void a() {
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "CAEAwareClient", "CAEService disconnected", false, 4, null);
            com.obric.cae.libs.useraware.f r0 = this.f8562a.a();     // Catch: RemoteException -> L7
            if (r0 == null) goto L9;
            r0.b(a.a(this.f8562a));     // Catch: RemoteException -> L7
        L9:
            a.a(this.f8562a, null);
            ae<Boolean> r9 = this.f8562a.b();
        L10:
            Boolean r1 = r9.c();
            ((Boolean) ZeusTransformUtils.preCheckCast(r1, Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
            if (r9.a(r1, false) == false) goto L10;
            return;
        L7:
            e = move-exception;
            e.printStackTrace();
            goto L9
        }

        @Override // com.obric.cae.libs.useraware.f.a
        public void a(com.obric.cae.libs.useraware.f r10) {
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "CAEAwareClient", "CAEService connected", false, 4, null);
            a.a(this.f8562a, r10);
            com.obric.cae.libs.useraware.f r11 = this.f8562a.a();     // Catch: RemoteException -> L7
            if (r11 == null) goto L9;
            r11.a(a.a(this.f8562a));     // Catch: RemoteException -> L7
        L9:
            ae<Boolean> r9 = this.f8562a.b();
        L10:
            Boolean r12 = r9.c();
            ((Boolean) ZeusTransformUtils.preCheckCast(r12, Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
            if (r9.a(r12, true) == false) goto L10;
            return;
        L7:
            e = move-exception;
            e.printStackTrace();
            goto L9
        }
    }

    static {
        f8559a = new C0431a(null);
        i = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, $$Lambda$a$7HgJKAUHPV6dVed3WBrZ0uPDbL0.INSTANCE);
    }

    public a() {
        this.c = at.a(false);
        this.d = new CopyOnWriteArrayList();
        this.e = am.a(cu.a(null, 1, null).plus((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin")));
        this.g = new $$Lambda$a$O62DD9TRsC05VhCPPmexH6_laPA(this);
        this.h = (com.obric.cae.libs.useraware.d) ZeusTransformUtils.preCheckCast(new b(this), com.obric.cae.libs.useraware.d.class, "com.obric.memorydata.plugin");
    }

    public static final /* synthetic */ com.obric.cae.libs.useraware.d a(a r0) {
        return r0.h;
    }

    public static final /* synthetic */ void a(a r0, com.obric.cae.libs.useraware.f r1) {
        r0.f8560b = r1;
    }

    public static final /* synthetic */ CopyOnWriteArrayList b(a r0) {
        return r0.d;
    }

    public static final /* synthetic */ al c(a r0) {
        return r0.e;
    }

    public static final /* synthetic */ Lazy d() {
        return i;
    }

    private static final Unit d(a r7) {
        if (r7.f8560b != null) goto L6;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "CAEAwareClient", "location permission changed, retry CAEAwareClient init", false, 4, null);
        r7.c();
    L6:
        return Unit.INSTANCE;
    }

    private final void e() {
        if (this.f == false) goto L5;
        return;
    L5:
        this.f = true;
        com.obric.memorydata.b.a.f8796a.a(this.g);
    }

    private static final a f() {
        a r0 = new a();
        r0.c();
        return r0;
    }

    public static /* synthetic */ a lambda$7HgJKAUHPV6dVed3WBrZ0uPDbL0() {
        return f();
    }

    public static /* synthetic */ Unit lambda$O62DD9TRsC05VhCPPmexH6_laPA(a r0) {
        return d(r0);
    }

    public final com.obric.cae.libs.useraware.f a() {
        return this.f8560b;
    }

    public final void a(int r3) {
        com.obric.cae.libs.useraware.f r2 = this.f8560b;     // Catch: RemoteException -> L6
        if (r2 == null) goto L11;
        r2.a(r3);     // Catch: RemoteException -> L6
        return;
    L11:
        return;
    L6:
        e = move-exception;
        RunLog.INSTANCE.error("CAEAwareClient", "notifyGeofenceChanged failed", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
    }

    public final void a(j r3, boolean r4) {
        j r5 = (j) ZeusTransformUtils.wrapperContextForParams(r3, j.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "callback");
        CopyOnWriteArrayList<j> r2 = this.d;
        if (r4 == false) goto L5;
        r2.addIfAbsent(r5);
        return;
    L5:
        r2.remove(r5);
    }

    public final void a(List<String> r5) {
        List<String> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "bssids");
        RunLog.INSTANCE.debug("CAEAwareClient", "===>set indoor_bssids: " + r6);
        com.obric.cae.libs.useraware.f r4 = this.f8560b;     // Catch: RemoteException -> L7
        if (r4 == null) goto L12;
        r4.b(r6);     // Catch: RemoteException -> L7
        return;
    L12:
        return;
    L7:
        e = move-exception;
        RunLog.INSTANCE.error("CAEAwareClient", "addBssidsToAvoidRomingScan failed", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
    }

    public final ae<Boolean> b() {
        return this.c;
    }

    public final void b(int r3) {
        com.obric.cae.libs.useraware.f r2 = this.f8560b;     // Catch: RemoteException -> L6
        if (r2 == null) goto L11;
        r2.b(r3);     // Catch: RemoteException -> L6
        return;
    L11:
        return;
    L6:
        e = move-exception;
        RunLog.INSTANCE.error("CAEAwareClient", "notifyRoomChangedPredicted failed", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
    }

    public final void b(List<String> r5) {
        List<String> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "bssids");
        RunLog.INSTANCE.debug("CAEAwareClient", "add home wifi bssids: " + r6);
        com.obric.cae.libs.useraware.f r0 = this.f8560b;     // Catch: RemoteException -> L10
        if (r0 == null) goto L6;
        r0.a();     // Catch: RemoteException -> L10
    L6:
        com.obric.cae.libs.useraware.f r4 = this.f8560b;     // Catch: RemoteException -> L10
        if (r4 == null) goto L15;
        r4.a(r6);     // Catch: RemoteException -> L10
        return;
    L15:
        return;
    L10:
        e = move-exception;
        RunLog.INSTANCE.error("CAEAwareClient", "addHomeWifiBssids failed", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
    }

    public final void c() {
        if (this.f8560b != null) goto L10;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "CAEAwareClient", "init UserAwareAdapter", false, 4, null);
        if (com.obric.memorydata.b.a.f8796a.b() == true) goto L8;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "CAEAwareClient", "CAEAwareClient init failed, location permission is missing", null, 4, null);
        e();
        return;
    L8:
        this.f8560b = com.obric.cae.libs.useraware.f.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), (com.obric.cae.libs.useraware.f.a) ZeusTransformUtils.preCheckCast(new c(this), com.obric.cae.libs.useraware.f.a.class, "com.obric.memorydata.plugin"));
        return;
    }
}
