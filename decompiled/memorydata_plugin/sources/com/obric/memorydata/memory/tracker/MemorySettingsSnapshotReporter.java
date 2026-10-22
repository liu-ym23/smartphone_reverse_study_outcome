package com.obric.memorydata.memory.tracker;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.provider.Settings;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.common.wschannel.WsConstants;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.aiproactive.api.DoubaoGlassesConnectionSnapshot;
import com.obric.aiproactive.api.DoubaoGlassesConnectionState;
import com.obric.capabilitykit.common.Ext;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import com.obric.memorydata.awareness.api.AwarenessManager;
import com.obric.memorydata.awareness.api.FeatureManager;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.obric.memorydata.memory.api.MemoryService;
import com.obric.memorydata.memory.ui.settings.contextawareness.ContextAwarenessGlobalSource;
import com.obric.memorydata.memory.ui.settings.contextawareness.ContextAwarenessSystemApp;
import com.obric.memorydata.memory.utils.PinnedShortcutState;
import com.obric.memorydata.memory.utils.m;
import com.obric.memorydata.middleware.api.app.UserSettings;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.logging.o;
import com.obric.memorydata.middleware.api.logging.t;
import com.obric.memorydata.middleware.api.store.IStore;
import com.obric.memorydata.middleware.api.store.IStoreManager;
import com.obric.memorydata.middleware.api.store.StoreManager;
import com.obric.memorydata.recommend.RecommendApi;
import com.obric.memorydata.ui.IdentityController;
import com.volcengine.zeus.LocalBroadcastManager;
import com.volcengine.zeus.receiver.PluginBroadcastReceiver;
import com.volcengine.zeus.transform.ZeusProviderTransform;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.al;
import kotlinx.coroutines.am;
import kotlinx.coroutines.ba;
import kotlinx.coroutines.channels.k;
import kotlinx.coroutines.channels.l;
import kotlinx.coroutines.cu;
import kotlinx.coroutines.da;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0089\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u001e\n\u0002\b\u0005*\u0001\u001e\bÀ\u0002\u0018\u00002\u00020\u0001:\u0003GHIB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\"\u001a\u00020\u0011J\u0006\u0010#\u001a\u00020\u0011J\u0006\u0010$\u001a\u00020\u0011J\u0012\u0010%\u001a\u00020\u00112\b\b\u0002\u0010&\u001a\u00020'H\u0002J\u000e\u0010(\u001a\u00020\u0011H\u0082@¢\u0006\u0002\u0010)J\u0010\u0010*\u001a\u0004\u0018\u00010+H\u0082@¢\u0006\u0002\u0010)J\u0018\u0010,\u001a\u00020\u00112\u0006\u0010-\u001a\u00020+2\u0006\u0010.\u001a\u00020/H\u0002J\u0010\u00100\u001a\u00020\u00112\u0006\u0010-\u001a\u00020+H\u0002J\u0010\u00101\u001a\u0002022\u0006\u00103\u001a\u00020!H\u0002J\b\u00104\u001a\u000202H\u0002J\n\u00105\u001a\u0004\u0018\u00010/H\u0002J\n\u00106\u001a\u0004\u0018\u00010/H\u0002J\n\u00107\u001a\u0004\u0018\u000108H\u0002J\b\u00109\u001a\u00020\u0011H\u0002J\b\u0010:\u001a\u00020\u0011H\u0002J\b\u0010;\u001a\u00020\u0011H\u0002J\b\u0010<\u001a\u00020\u0011H\u0002J\u0010\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020\u0005H\u0002J\u0010\u0010@\u001a\u00020>2\u0006\u0010?\u001a\u00020\u0005H\u0002J\u0010\u0010A\u001a\u0002022\u0006\u0010B\u001a\u00020\u0005H\u0002J\u0016\u0010C\u001a\u00020\u00052\f\u0010D\u001a\b\u0012\u0004\u0012\u00020\u00050EH\u0002J\f\u0010F\u001a\u00020>*\u000202H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\u00020\u00138BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u001b\u0010\u0016\u001a\u00020\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u0018\u0010\u0019R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001fR\u0010\u0010 \u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006J"}, d2 = {"Lcom/obric/memorydata/memory/tracker/MemorySettingsSnapshotReporter;", "", "<init>", "()V", "LAST_REPORT_TIMESTAMP_KEY", "", "OPERATE_PACKAGE", "CHANGE_DEBOUNCE_MILLIS", "", "initialized", "Ljava/util/concurrent/atomic/AtomicBoolean;", "lifecycleLock", "accountReportLock", "listenerScope", "Lkotlinx/coroutines/CoroutineScope;", "requests", "Lkotlinx/coroutines/channels/Channel;", "", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "memoryStore", "Lcom/obric/memorydata/middleware/api/store/IStore;", "getMemoryStore", "()Lcom/obric/memorydata/middleware/api/store/IStore;", "memoryStore$delegate", "Lkotlin/Lazy;", "glassesTimerStore", "glassesTimerListener", "com/obric/memorydata/memory/tracker/MemorySettingsSnapshotReporter$glassesTimerListener$1", "Lcom/obric/memorydata/memory/tracker/MemorySettingsSnapshotReporter$glassesTimerListener$1;", "session", "Lcom/obric/memorydata/memory/tracker/MemorySettingsSnapshotReporter$AccountSession;", CommonConsts.APM_INNER_EVENT_COST_INIT, "onAccountChanged", "reportOnScreenOn", "requestSnapshot", "signal", "Lcom/obric/memorydata/memory/tracker/MemorySettingsSnapshotReporter$Signal;", "consumeRequests", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitSnapshotRequest", "Lcom/obric/memorydata/memory/tracker/MemorySettingsSnapshotReporter$SnapshotRequest;", "reportIfNeeded", Ext.KEY_REQUEST, "snapshot", "Lcom/obric/memorydata/memory/tracker/MemoryEventTracker$MemorySettingsSnapshotParams;", "consumeSignals", "isCurrentAccount", "", "current", "isPersonalDatabaseReady", "readSnapshot", "collectSnapshot", "readGlassesTimerSettings", "Lcom/obric/memorydata/memory/api/GlassesEnvironmentTimerSettings;", "registerSettingObservers", "registerStateFlows", "registerGlassesListener", "registerFeatureAndShortcutListeners", "manualSwitchState", "", "key", "storedState", "hasLocation", "feature", "enabledPackagesJson", "packages", "", "asState", "Signal", "AccountSession", "SnapshotRequest", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class MemorySettingsSnapshotReporter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final MemorySettingsSnapshotReporter f10517a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final AtomicBoolean f10518b = null;
    private static final Object c = null;
    private static final Object d = null;
    private static final al e = null;
    private static final kotlinx.coroutines.channels.i<Unit> f = null;
    private static final Lazy g = null;
    private static IStore h;
    private static final d i = null;
    private static volatile a j;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/memorydata/memory/tracker/MemorySettingsSnapshotReporter$Signal;", "", "<init>", "(Ljava/lang/String;I)V", "INITIALIZE", "CHANGE", "SCREEN_ON", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final enum Signal extends Enum<Signal> {
        private static final /* synthetic */ EnumEntries $ENTRIES = null;
        private static final /* synthetic */ Signal[] $VALUES = null;
        public static final Signal CHANGE = null;
        public static final Signal INITIALIZE = null;
        public static final Signal SCREEN_ON = null;

        private static final /* synthetic */ Signal[] $values() {
            return new Signal[]{INITIALIZE, CHANGE, SCREEN_ON};
        }

        static {
            INITIALIZE = new Signal("INITIALIZE", 0);
            CHANGE = new Signal("CHANGE", 1);
            SCREEN_ON = new Signal("SCREEN_ON", 2);
            Signal[] r0 = $values();
            $VALUES = r0;
            $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
        }

        private Signal(String r1, int r2) {
            super(r1, r2);
        }

        public static EnumEntries<Signal> getEntries() {
            return $ENTRIES;
        }

        public static Signal valueOf(String r2) {
            return (Signal) ZeusTransformUtils.preCheckCast(Enum.valueOf(Signal.class, r2), Signal.class, "com.obric.memorydata.plugin");
        }

        public static Signal[] values() {
            return (Signal[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), Signal[].class, "com.obric.memorydata.plugin");
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0011\"\u0004\b\u0016\u0010\u0013R\u001a\u0010\u0017\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0011\"\u0004\b\u0019\u0010\u0013R\u001a\u0010\u001a\u001a\u00020\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010 \u001a\u00020\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u001d\"\u0004\b\"\u0010\u001f¨\u0006#"}, d2 = {"Lcom/obric/memorydata/memory/tracker/MemorySettingsSnapshotReporter$AccountSession;", "", "userId", "", "<init>", "(Ljava/lang/String;)V", "getUserId", "()Ljava/lang/String;", "baseline", "Lcom/obric/memorydata/memory/tracker/MemoryEventTracker$MemorySettingsSnapshotParams;", "getBaseline", "()Lcom/obric/memorydata/memory/tracker/MemoryEventTracker$MemorySettingsSnapshotParams;", "setBaseline", "(Lcom/obric/memorydata/memory/tracker/MemoryEventTracker$MemorySettingsSnapshotParams;)V", "pendingChange", "", "getPendingChange", "()Z", "setPendingChange", "(Z)V", "pendingScreenOn", "getPendingScreenOn", "setPendingScreenOn", "needsRead", "getNeedsRead", "setNeedsRead", "signalVersion", "", "getSignalVersion", "()J", "setSignalVersion", "(J)V", "lastChangeElapsedMillis", "getLastChangeElapsedMillis", "setLastChangeElapsedMillis", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f10519a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private MemoryEventTracker.MemorySettingsSnapshotParams f10520b;
        private boolean c;
        private boolean d;
        private boolean e;
        private long f;
        private long g;

        public a(String r2) {
            Intrinsics.checkNotNullParameter(r2, "userId");
            this.f10519a = r2;
        }

        public final String a() {
            return this.f10519a;
        }

        public final void a(long r1) {
            this.f = r1;
        }

        public final void a(MemoryEventTracker.MemorySettingsSnapshotParams r1) {
            this.f10520b = r1;
        }

        public final void a(boolean r1) {
            this.c = r1;
        }

        public final MemoryEventTracker.MemorySettingsSnapshotParams b() {
            return this.f10520b;
        }

        public final void b(long r1) {
            this.g = r1;
        }

        public final void b(boolean r1) {
            this.d = r1;
        }

        public final void c(boolean r1) {
            this.e = r1;
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

        public final long f() {
            return this.f;
        }

        public final long g() {
            return this.g;
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÆ\u0003J1\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00072\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010¨\u0006\u001d"}, d2 = {"Lcom/obric/memorydata/memory/tracker/MemorySettingsSnapshotReporter$SnapshotRequest;", "", "account", "Lcom/obric/memorydata/memory/tracker/MemorySettingsSnapshotReporter$AccountSession;", "version", "", "changed", "", "screenOn", "<init>", "(Lcom/obric/memorydata/memory/tracker/MemorySettingsSnapshotReporter$AccountSession;JZZ)V", "getAccount", "()Lcom/obric/memorydata/memory/tracker/MemorySettingsSnapshotReporter$AccountSession;", "getVersion", "()J", "getChanged", "()Z", "getScreenOn", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final a f10521a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f10522b;
        private final boolean c;
        private final boolean d;

        public b(a r2, long r3, boolean r5, boolean r6) {
            Intrinsics.checkNotNullParameter(r2, "account");
            this.f10521a = r2;
            this.f10522b = r3;
            this.c = r5;
            this.d = r6;
        }

        public final a a() {
            return this.f10521a;
        }

        public final long b() {
            return this.f10522b;
        }

        public final boolean c() {
            return this.c;
        }

        public final boolean d() {
            return this.d;
        }

        public boolean equals(Object r9) {
            if (this != r9) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r9, b.class) == true) goto L8;
            return false;
        L8:
            b r10 = (b) ZeusTransformUtils.preCheckCast(r9, b.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f10521a, r10.f10521a) == true) goto L12;
            return false;
        L12:
            if (this.f10522b == r10.f10522b) goto L15;
            return false;
        L15:
            if (this.c == r10.c) goto L18;
            return false;
        L18:
            if (this.d == r10.d) goto L20;
            return false;
        L20:
            return true;
        }

        public int hashCode() {
            return (((((this.f10521a.hashCode() * 31) + Long.hashCode(this.f10522b)) * 31) + Boolean.hashCode(this.c)) * 31) + Boolean.hashCode(this.d);
        }

        public String toString() {
            return "SnapshotRequest(account=" + this.f10521a + ", version=" + this.f10522b + ", changed=" + this.c + ", screenOn=" + this.d + ')';
        }
    }

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f10523a = null;

        static {
            int[] r0 = new int[PinnedShortcutState.values().length];
            r0[PinnedShortcutState.ACTIVE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r0[PinnedShortcutState.DISABLED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r0[PinnedShortcutState.ABSENT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[PinnedShortcutState.UNKNOWN.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            f10523a = r0;
        }
    }

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¨\u0006\u0007"}, d2 = {"com/obric/memorydata/memory/tracker/MemorySettingsSnapshotReporter$glassesTimerListener$1", "Lcom/obric/memorydata/middleware/api/store/StoreChangeListener;", "onKeyChanged", "", "repoName", "", "key", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class d implements com.obric.memorydata.middleware.api.store.b {
        d() {
        }

        @Override // com.obric.memorydata.middleware.api.store.b
        public void onKeyChanged(String r1, String r2) {
            Intrinsics.checkNotNullParameter(r1, "repoName");
            Intrinsics.checkNotNullParameter(r2, "key");
            if (Intrinsics.areEqual(r2, "glasses_environment_timer_settings") == false) goto L6;
            MemorySettingsSnapshotReporter.a(MemorySettingsSnapshotReporter.f10517a, null, 1, null);
            return;
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/obric/memorydata/memory/tracker/MemorySettingsSnapshotReporter$registerFeatureAndShortcutListeners$1", "Landroid/content/BroadcastReceiver;", "onReceive", "", "context", "Landroid/content/Context;", MemorySourceLinkType.INTENT, "Landroid/content/Intent;", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class e extends PluginBroadcastReceiver {
        e() {
        }

        public void onReceive(Context r2, Intent r3) {
            Intrinsics.checkNotNullParameter((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"), "context");
            Intrinsics.checkNotNullParameter(r3, MemorySourceLinkType.INTENT);
            if (Intrinsics.areEqual(r3.getStringExtra("extra_shortcut_id"), "memory_home_shortcut") == false) goto L6;
            MemorySettingsSnapshotReporter.a(MemorySettingsSnapshotReporter.f10517a, null, 1, null);
            return;
        }
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007H\u0016J<\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\b2\b\u0010\f\u001a\u0004\u0018\u00010\b2\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007H\u0016¨\u0006\r"}, d2 = {"com/obric/memorydata/memory/tracker/MemorySettingsSnapshotReporter$registerFeatureAndShortcutListeners$listener$1", "Lcom/obric/memorydata/awareness/api/EventListener;", "onEvent", "", "eventName", "", WsConstants.KEY_EXTRA, "", "", "onFeatureChanged", "feature", "oldValue", "newValue", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class f implements com.obric.memorydata.awareness.api.a {
        f() {
        }

        @Override // com.obric.memorydata.awareness.api.a
        public void a(String r1, Object r2, Object r3, Map<String, ? extends Object> r4) {
            Map r0 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r1, "feature");
            MemorySettingsSnapshotReporter.a(MemorySettingsSnapshotReporter.f10517a, null, 1, null);
        }

        @Override // com.obric.memorydata.awareness.api.a
        public void a(String r2, Map<String, ? extends Object> r3) {
            Map r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r2, "eventName");
        }

        @Override // com.obric.memorydata.awareness.api.a
        public boolean a() {
            return com.obric.memorydata.awareness.api.a.C0430a.a(this);
        }

        @Override // com.obric.memorydata.awareness.api.a
        public void b(String r3, Object r4, Object r5, Map<String, ? extends Object> r6) {
            com.obric.memorydata.awareness.api.a.C0430a.a(this, r3, r4, r5, (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.memorydata.plugin"));
        }
    }

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¨\u0006\u0007"}, d2 = {"com/obric/memorydata/memory/tracker/MemorySettingsSnapshotReporter$registerSettingObservers$2", "Lcom/obric/memorydata/middleware/api/store/StoreChangeListener;", "onKeyChanged", "", "repoName", "", "key", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class g implements com.obric.memorydata.middleware.api.store.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ List<String> f10524a;

        g(List<String> r3) {
            this.f10524a = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        }

        @Override // com.obric.memorydata.middleware.api.store.b
        public void onKeyChanged(String r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "repoName");
            Intrinsics.checkNotNullParameter(r3, "key");
            if (this.f10524a.contains(r3) == false) goto L6;
            MemorySettingsSnapshotReporter.a(MemorySettingsSnapshotReporter.f10517a, null, 1, null);
            return;
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/obric/memorydata/memory/tracker/MemorySettingsSnapshotReporter$registerSettingObservers$observer$1", "Landroid/database/ContentObserver;", "onChange", "", "selfChange", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class h extends ContentObserver {
        h(Handler r1) {
            super(r1);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean r2) {
            MemorySettingsSnapshotReporter.a(MemorySettingsSnapshotReporter.f10517a, null, 1, null);
        }
    }

    static {
        f10517a = new MemorySettingsSnapshotReporter();
        f10518b = new AtomicBoolean(false);
        c = new Object();
        d = new Object();
        e = am.a(cu.a(null, 1, null).plus((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin")));
        f = l.a(-1, null, null, 6, null);
        g = LazyKt.lazy($$Lambda$MemorySettingsSnapshotReporter$iDYbi3iZqNKgGHqzqQuc78bEmC4.INSTANCE);
        i = new d();
    }

    private MemorySettingsSnapshotReporter() {
    }

    private final int a(String r4) {
        boolean r1 = true;
        if (Settings.System.getInt(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getContentResolver(), r4, 1) == 1) goto L7;
        r1 = false;
    L7:
        return a(r1);
    }

    private final int a(boolean r1) {
        return r1 ? 1 : 0;
    }

    public static final /* synthetic */ Object a(MemorySettingsSnapshotReporter r2, Continuation r3) {
        return r2.a((Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x00b1 -> B:14:0x0053). Please report as a decompilation issue!!! */
    private final Object a(Continuation<? super Unit> r15) {
        Continuation r16 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r15, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r16, MemorySettingsSnapshotReporter$consumeRequests$1.class) == false) goto L7;
        MemorySettingsSnapshotReporter$consumeRequests$1 r1 = (MemorySettingsSnapshotReporter$consumeRequests$1) ZeusTransformUtils.preCheckCast(r16, MemorySettingsSnapshotReporter$consumeRequests$1.class, "com.obric.memorydata.plugin");
        if ((r1.label & Integer.MIN_VALUE) == 0) goto L7;
        r1.label -= Integer.MIN_VALUE;
    L8:
        Object r17 = r1.result;
        Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r1.label;
        if (r4 == 0) goto L21;
        if (r4 == 1) goto L20;
        if (r4 != 2) goto L19;
        k<Unit> r14 = (k) ZeusTransformUtils.preCheckCast(r1.L$1, k.class, "com.obric.memorydata.plugin");
        MemorySettingsSnapshotReporter r0 = (MemorySettingsSnapshotReporter) ZeusTransformUtils.preCheckCast(r1.L$0, MemorySettingsSnapshotReporter.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r17);     // Catch: Exception -> L15 CancellationException -> L16
    L14:
        MemorySettingsSnapshotReporter r13 = r0;
        k<Unit> r2 = r14;
        MemorySettingsSnapshotReporter this = r13;
        b r18 = (b) ZeusTransformUtils.preCheckCast(r17, b.class, "com.obric.memorydata.plugin");     // Catch: CancellationException -> L16 Exception -> L44
        if (r18 != null) goto L36;
    L43:
        k<Unit> r19 = r2;
    L22:
        r1.L$0 = this;
        r1.L$1 = r19;
        r1.label = 1;
        Object r5 = r19.a(r1);
        if (r5 != r3) goto L25;
        return r3;
    L25:
        r0 = this;
        r14 = r19;
        r17 = r5;
    L27:
        if (((Boolean) ZeusTransformUtils.preCheckCast(r17, Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L48;
        r14.a();
        r1.L$0 = r0;     // Catch: Exception -> L15 CancellationException -> L16
        r1.L$1 = r14;     // Catch: Exception -> L15 CancellationException -> L16
        r1.label = 2;     // Catch: Exception -> L15 CancellationException -> L16
        r17 = r0.b(r1);     // Catch: Exception -> L15 CancellationException -> L16
        if (r17 != r3) goto L14;
        return r3;
    L48:
        return Unit.INSTANCE;
    L36:
        if (this.a(r18.a()) == false) goto L43;
        MemoryEventTracker.MemorySettingsSnapshotParams r6 = this.g();     // Catch: CancellationException -> L16 Exception -> L44
        if (r6 == null) goto L43;
        if (this.a(r18.a()) == false) goto L43;
        this.a(r18, r6);     // Catch: CancellationException -> L16 Exception -> L44
    L44:
        r19 = r2;
        ((o) ZeusTransformUtils.preCheckCast(t.f11635a, o.class, "com.obric.memorydata.plugin")).a("settings_snapshot_request_failed", "设置快照处理失败", new com.obric.memorydata.middleware.api.logging.e(null, null, null, 7, null), new com.obric.memorydata.middleware.api.logging.g().a());
    L16:
        e = move-exception;
        throw e;
    L15:
        r19 = r14;
        this = r0;
        ((o) ZeusTransformUtils.preCheckCast(t.f11635a, o.class, "com.obric.memorydata.plugin")).a("settings_snapshot_request_failed", "设置快照处理失败", new com.obric.memorydata.middleware.api.logging.e(null, null, null, 7, null), new com.obric.memorydata.middleware.api.logging.g().a());
        goto L22
    L19:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L20:
        r14 = (k) ZeusTransformUtils.preCheckCast(r1.L$1, k.class, "com.obric.memorydata.plugin");
        r0 = (MemorySettingsSnapshotReporter) ZeusTransformUtils.preCheckCast(r1.L$0, MemorySettingsSnapshotReporter.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r17);
        goto L27
    L21:
        ResultKt.throwOnFailure(r17);
        r19 = f.l();
    L7:
        r1 = new MemorySettingsSnapshotReporter$consumeRequests$1(this, r16);
        goto L8
    }

    private final String a(Collection<String> r4) {
        Collection r3 = (Collection) ZeusTransformUtils.wrapperContextForParams(r4, Collection.class, "com.obric.memorydata.plugin");
        JSONObject r5 = new JSONObject();
        Iterator r6 = ((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.sorted((Iterable) ZeusTransformUtils.preCheckCast(r3, Iterable.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r6.hasNext() == false) goto L6;
        r5.put((String) ZeusTransformUtils.preCheckCast(r6.next(), String.class, "com.obric.memorydata.plugin"), 1);
        goto L4
    L6:
        String r7 = r5.toString();
        Intrinsics.checkNotNullExpressionValue(r7, "toString(...)");
        return r7;
    }

    private final void a(Signal r6) {
        Object r5 = c;
        monitor-enter(r5);
        a r0 = j;     // Catch: Throwable -> L18
        if (r0 != null) goto L9;
        monitor-exit(r5);
        return;
    L9:
        if (r6 != Signal.CHANGE) goto L12;
        r0.a(true);     // Catch: Throwable -> L18
        r0.b(SystemClock.elapsedRealtime());     // Catch: Throwable -> L18
    L12:
        if (r6 != Signal.SCREEN_ON) goto L14;
        r0.b(true);     // Catch: Throwable -> L18
    L14:
        r0.c(true);     // Catch: Throwable -> L18
        r0.a(r0.f() + 1);     // Catch: Throwable -> L18
        monitor-exit(r5);
        f.mo54trySendJP2dKIU(Unit.INSTANCE);
        return;
    L18:
        th = move-exception;
        throw th;
    }

    private final void a(b r6) {
        Object r5 = c;
        monitor-enter(r5);
        a r0 = r6.a();     // Catch: Throwable -> L12
        if (j == r0) goto L7;
    L9:
        Unit r7 = Unit.INSTANCE;     // Catch: Throwable -> L12
        monitor-exit(r5);
        return;
    L7:
        if (r0.f() != r6.b()) goto L9;
        r0.a(false);     // Catch: Throwable -> L12
        r0.b(false);     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;
    }

    private final void a(b r36, MemoryEventTracker.MemorySettingsSnapshotParams r37) {
        a r1 = r36.a();
        IStore r15 = StoreManager.INSTANCE.getPersonalStore();
        if (r15 != null) goto L5;
        return;
    L5:
        MemoryEventTracker.MemorySettingsSnapshotParams r2 = r1.b();
        boolean r3 = true;
        if (r2 == null) goto L8;
        boolean r4 = !Intrinsics.areEqual(r2, r37);
    L9:
        long r13 = System.currentTimeMillis();
        if (r4 == false) goto L12;
    L17:
        if (r3 == false) goto L19;
        if (r4 == false) goto L25;
        String r5 = "on_change";
    L26:
        String r23 = r5;
        Object r28 = d;
        monitor-enter(r28);
        MemorySettingsSnapshotReporter r12 = f10517a;     // Catch: Throwable -> L42
        if (r12.a(r1) == true) goto L33;
        monitor-exit(r28);
        return;
    L33:
        if (MemoryEventTracker.f10515a.a(MemoryEventTracker.MemorySettingsSnapshotParams.copy$default(r37, 0, 0, 0, 0, null, 0, 0, 0, 0, 0, null, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, r23, null, null, 14680063, null)) == true) goto L35;
    L39:
        Unit r0 = Unit.INSTANCE;     // Catch: Throwable -> L42
        monitor-exit(r28);
        return;
    L35:
        if (r12.a(r1) == true) goto L38;
        monitor-exit(r28);
        return;
    L38:
        r15.syncSave("memory_settings_last_report_timestamp_ms", r13);     // Catch: Throwable -> L42
        r1.a(r37);     // Catch: Throwable -> L42
        r12.a(r36);     // Catch: Throwable -> L42
    L42:
        th = move-exception;
        throw th;
    L25:
        r5 = "daily_timed";
        goto L26
    L19:
        if (r1.b() != null) goto L21;
        r1.a(r37);
    L21:
        a(r36);
        return;
    L12:
        if (r36.d() == true) goto L14;
    L16:
        r3 = false;
        goto L17
    L14:
        if (MemorySwitchReportGate.a(MemorySwitchReportGate.f10526a, r15.getLong("memory_settings_last_report_timestamp_ms", 0), r13, null, 4, null).a() == false) goto L16;
    L8:
        r4 = r36.c();
        goto L9
    }

    public static final /* synthetic */ void a(MemorySettingsSnapshotReporter r0, Signal r1) {
        r0.a(r1);
    }

    static /* synthetic */ void a(MemorySettingsSnapshotReporter r0, Signal r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = Signal.CHANGE;
    L5:
        r0.a(r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final void a(Ref.ObjectRef r8, DoubaoGlassesConnectionSnapshot r9) {
        Intrinsics.checkNotNullParameter(r9, "snapshot");
        Object r0 = c;
        monitor-enter(r0);
        DoubaoGlassesConnectionSnapshot r1 = (DoubaoGlassesConnectionSnapshot) ZeusTransformUtils.preCheckCast(r8.element, DoubaoGlassesConnectionSnapshot.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L17
        r8.element = r9;     // Catch: Throwable -> L17
        Signal r2 = null;
        if (r9.getGeneration() > 0) goto L8;
    L13:
        monitor-exit(r0);
        if (r2 == null) goto L21;
        f10517a.a(r2);
        return;
    L21:
        return;
    L8:
        if (r1.getGeneration() > 0) goto L11;
        r2 = Signal.INITIALIZE;     // Catch: Throwable -> L17
        goto L13
    L11:
        if (r1.getEnvironmentMemoryEnabled() == r9.getEnvironmentMemoryEnabled()) goto L13;
        r2 = Signal.CHANGE;     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        throw th;
    }

    private final boolean a(a r2) {
        if (j == r2) goto L5;
    L13:
        return false;
    L5:
        if (AppContext.INSTANCE.isLogin() == false) goto L13;
        if (Intrinsics.areEqual(UserSettings.INSTANCE.getUserId(), r2.a()) == false) goto L13;
        if (Intrinsics.areEqual(AppContext.INSTANCE.getUserId(), r2.a()) == false) goto L13;
        if (com.obric.memorydata.middleware.database.b.f11646a.b() == false) goto L13;
        return true;
    }

    private final int b(String r3) {
        return a(e().getBoolean(r3, false));
    }

    public static final /* synthetic */ Object b(MemorySettingsSnapshotReporter r2, Continuation r3) {
        return r2.b((Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin"));
    }

    private final Object b(Continuation<? super b> r12) {
        Continuation r13 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r12, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r13, MemorySettingsSnapshotReporter$awaitSnapshotRequest$1.class) == false) goto L7;
        MemorySettingsSnapshotReporter$awaitSnapshotRequest$1 r0 = (MemorySettingsSnapshotReporter$awaitSnapshotRequest$1) ZeusTransformUtils.preCheckCast(r13, MemorySettingsSnapshotReporter$awaitSnapshotRequest$1.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r11 = r0.result;
        Object r14 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = r0.label;
        if (r1 == 0) goto L14;
        if (r1 == 1) goto L14;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r11);
    L16:
        if (am.a(e) == false) goto L43;
        Object r15 = c;
        monitor-enter(r15);
        a r4 = j;     // Catch: Throwable -> L40
        if (r4 == null) goto L21;
        if (r4.e() == false) goto L25;
        if (r4.c() == false) goto L30;
        long r7 = (r4.g() + 500) - SystemClock.elapsedRealtime();     // Catch: Throwable -> L40
    L32:
        if (r7 <= 0) goto L33;
        monitor-exit(r15);
        Function2 r16 = (Function2) ZeusTransformUtils.preCheckCast(new MemorySettingsSnapshotReporter$awaitSnapshotRequest$2(null), Function2.class, "com.obric.memorydata.plugin");
        r0.label = 1;
        if (da.b(r7, r16, r0) != r14) goto L16;
        return r14;
    L33:
        r4.c(false);     // Catch: Throwable -> L40
        b r17 = new b(r4, r4.f(), r4.c(), r4.d());     // Catch: Throwable -> L40
        monitor-exit(r15);
        return r17;
    L30:
        r7 = 0;
        goto L32
    L25:
        monitor-exit(r15);
        return null;
    L21:
        monitor-exit(r15);
        return null;
    L40:
        th = move-exception;
        throw th;
    L43:
        return null;
    L7:
        r0 = new MemorySettingsSnapshotReporter$awaitSnapshotRequest$1(this, r13);
        goto L8
    }

    private final boolean c(String r2) {
        Object r1 = FeatureManager.INSTANCE.getFeature(r2);
        if (ZeusTransformUtils.instanceOf(r1, List.class) == false) goto L5;
        List r3 = (List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.memorydata.plugin");
    L7:
        if (r3 != null) goto L9;
        return false;
    L9:
        if (r3.size() != 2) goto L13;
        return true;
    L13:
        return false;
    L5:
        r3 = null;
        goto L7
    }

    public static final /* synthetic */ kotlinx.coroutines.channels.i d() {
        return f;
    }

    private final IStore e() {
        return (IStore) ZeusTransformUtils.preCheckCast(g.getValue(), IStore.class, "com.obric.memorydata.plugin");
    }

    private final boolean f() {
        String r1 = com.obric.memorydata.middleware.database.b.f11646a.c(MemoryDbEngine.USER_LOGIC_DB_NAME);
        return Intrinsics.areEqual(MemoryDbEngine.INSTANCE.getPersonalDbEngine().getOpenHelper().getDatabaseName(), r1);
    }

    private final MemoryEventTracker.MemorySettingsSnapshotParams g() {
    L9:
        o r9 = (o) ZeusTransformUtils.preCheckCast(t.f11635a, o.class, "com.obric.memorydata.plugin");
        com.obric.memorydata.middleware.api.logging.e r1 = new com.obric.memorydata.middleware.api.logging.e(null, null, null, 7, null);
        com.obric.memorydata.middleware.api.logging.f r3 = new com.obric.memorydata.middleware.api.logging.g().a();
        String r4 = "settings_snapshot_db_unavailable";
    L10:
        r9.a(r4, "设置快照读取失败", r1, r3);
        return null;
    L8:
        r9 = (o) ZeusTransformUtils.preCheckCast(t.f11635a, o.class, "com.obric.memorydata.plugin");
        r1 = new com.obric.memorydata.middleware.api.logging.e(null, null, null, 7, null);
        r3 = new com.obric.memorydata.middleware.api.logging.g().a();
        r4 = "settings_snapshot_access_denied";
        goto L10
    L4:
        if (f() == true) goto L6;
        return null;
    L6:
    L14:
        return h();
    }

    private final Context getContext() {
        return (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
    }

    private final MemoryEventTracker.MemorySettingsSnapshotParams h() {
        String r2 = null;
        if (DoubaoGlassesConnectionState.INSTANCE.currentSnapshot().getGeneration() > 0) goto L5;
        return null;
    L5:
        int r1 = c.f10523a[m.f11550a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "memory_home_shortcut").ordinal()];
        if (r1 != 1) goto L8;
    L17:
        int r22 = 1;
    L18:
        Set r3 = (Set) ZeusTransformUtils.preCheckCast(com.obric.memorydata.memory.ui.settings.l.f11479a.a().i().c(), Set.class, "com.obric.memorydata.plugin");
        com.obric.memorydata.memory.api.a r6 = i();
        if (Settings.Global.getInt(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getContentResolver(), "recorder_always_on_enable", 0) != 1) goto L21;
        boolean r7 = true;
    L22:
        Iterable r8 = (Iterable) ZeusTransformUtils.preCheckCast(ContextAwarenessSystemApp.getEntries(), Iterable.class, "com.obric.memorydata.plugin");
        Collection r9 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r10 = r8.iterator();
    L24:
        if (r10.hasNext() == false) goto L28;
        Object r11 = r10.next();
        if (f10517a.e().getBoolean(com.obric.memorydata.memory.ui.settings.contextawareness.h.f11453a.a((ContextAwarenessSystemApp) ZeusTransformUtils.preCheckCast(r11, ContextAwarenessSystemApp.class, "com.obric.memorydata.plugin")), false) == false) goto L24;
        r9.add(r11);
        goto L24
    L28:
        Iterable r4 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r9, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");
        Collection r12 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r4, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r5 = r4.iterator();
    L30:
        if (r5.hasNext() == false) goto L32;
        r12.add(((ContextAwarenessSystemApp) ZeusTransformUtils.preCheckCast(r5.next(), ContextAwarenessSystemApp.class, "com.obric.memorydata.plugin")).getPackageName());
        goto L30
    L32:
        List r13 = (List) ZeusTransformUtils.preCheckCast(r12, List.class, "com.obric.memorydata.plugin");
        int r14 = a(ObricMemoryConstants.SETTINGS_KEY_SHORTCUT_KEY_ENABLED);
        int r15 = a(ObricMemoryConstants.SETTINGS_KEY_SHORTCUT_GESTURE_ENABLED);
        int r16 = a(com.obric.memorydata.d.f8801a.a());
        int r17 = a(r3.contains("assistant.history"));
        Iterable r18 = (Iterable) ZeusTransformUtils.preCheckCast(r3, Iterable.class, "com.obric.memorydata.plugin");
        Collection r19 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r20 = r18.iterator();
    L34:
        if (r20.hasNext() == false) goto L38;
        Object r110 = r20.next();
        if ((!Intrinsics.areEqual((String) ZeusTransformUtils.preCheckCast(r110, String.class, "com.obric.memorydata.plugin"), "assistant.history")) == false) goto L34;
        r19.add(r110);
        goto L34
    L38:
        String r111 = a((Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r19, List.class, "com.obric.memorydata.plugin"), Collection.class, "com.obric.memorydata.plugin"));
        int r112 = a(com.obric.memorydata.address.a.f8427a.a());
        int r113 = a(c("location_home_gps"));
        int r114 = a(c("location_company_gps"));
        int r115 = a(((Boolean) ZeusTransformUtils.preCheckCast(RecommendApi.INSTANCE.screenObservationEnabled().c(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue());
        int r116 = a(r7);
        String r117 = a((Collection) ZeusTransformUtils.preCheckCast(r13, Collection.class, "com.obric.memorydata.plugin"));
        int r118 = b("context_awareness_notification_content_enabled");
        int r21 = b("context_awareness_device_state_enabled");
        int r23 = b("context_awareness_location_enabled");
        int r24 = b("context_awareness_motion_state_enabled");
        int r25 = a(com.obric.memorydata.memory.glasses.a.f10137a.a());
        int r26 = RecommendApi.INSTANCE.getBlockMemoryRuleSnapshots().size();
        int r28 = a(RecommendApi.INSTANCE.getScreenObservationCellularEnabled());
        int r29 = a(IdentityController.f12979a.c());
        int r0 = a(((Boolean) ZeusTransformUtils.preCheckCast(MemoryService.INSTANCE.experienceState().c(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue());
        String r30 = null;
        if (r6 == null) goto L41;
        String r31 = r6.b();
    L42:
        if (r6 == null) goto L45;
        r2 = r6.c();
    L45:
        return new MemoryEventTracker.MemorySettingsSnapshotParams(r14, r15, r16, r17, r111, r112, r113, r114, r115, r116, r117, r118, r21, r23, r24, r25, r26, r28, r29, r0, r22, r30, r31, r2, 2097152, null);
    L41:
        r31 = null;
        goto L42
    L21:
        r7 = false;
        goto L22
    L8:
        if (r1 == 2) goto L17;
        if (r1 != 3) goto L12;
        r22 = 0;
        goto L18
    L12:
        if (r1 != 4) goto L15;
        return null;
    L15:
        throw new NoWhenBranchMatchedException();
    }

    private final com.obric.memorydata.memory.api.a i() {
        IStore r5 = StoreManager.INSTANCE.getPersonalStore();
        if (r5 != null) goto L5;
        return null;
    L5:
        IStore r1 = h;
        if (r1 != r5) goto L8;
    L11:
        com.obric.memorydata.memory.api.a r6 = com.obric.memorydata.memory.api.a.f10058a.a(r5.getString("glasses_environment_timer_settings"));
        if (r6 != null) goto L14;
        return null;
    L14:
        if (Intrinsics.areEqual(r6.a(), UserSettings.INSTANCE.getUserId()) == true) goto L16;
        return null;
    L16:
        return r6;
    L8:
        if (r1 == null) goto L10;
        r1.unregisterChangeListener((com.obric.memorydata.middleware.api.store.b) ZeusTransformUtils.preCheckCast(i, com.obric.memorydata.middleware.api.store.b.class, "com.obric.memorydata.plugin"));
    L10:
        r5.registerChangeListener((com.obric.memorydata.middleware.api.store.b) ZeusTransformUtils.preCheckCast(i, com.obric.memorydata.middleware.api.store.b.class, "com.obric.memorydata.plugin"));
        h = r5;
        goto L11
    }

    private final void j() {
        h r1 = new h(new Handler(Looper.getMainLooper()));
        Iterable r0 = (Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.listOf(new String[]{ObricMemoryConstants.SETTINGS_KEY_SHORTCUT_KEY_ENABLED, ObricMemoryConstants.SETTINGS_KEY_SHORTCUT_GESTURE_ENABLED, "smart_memory_enabled"}), Iterable.class, "com.obric.memorydata.plugin");
        Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r3 = r0.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        r2.add(Settings.System.getUriFor((String) ZeusTransformUtils.preCheckCast(r3.next(), String.class, "com.obric.memorydata.plugin")));
        goto L4
    L6:
        Iterator r4 = ((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.plus((Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.memorydata.plugin"), Collection.class, "com.obric.memorydata.plugin"), (Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.listOf(new Uri[]{Settings.Global.getUriFor("recorder_always_on_enable"), Uri.parse("content://com.obric.memorydata.memory.ailabprovider/recorder_settings/block_rules")}), Iterable.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L8:
        if (r4.hasNext() == false) goto L10;
        ZeusProviderTransform.registerContentObserver(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(f10517a.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getContentResolver(), (Uri) ZeusTransformUtils.preCheckCast(r4.next(), Uri.class, "com.obric.memorydata.plugin"), false, (ContentObserver) ZeusTransformUtils.preCheckCast(r1, ContentObserver.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
        goto L8
    L10:
        Iterable r5 = (Iterable) ZeusTransformUtils.preCheckCast(ContextAwarenessSystemApp.getEntries(), Iterable.class, "com.obric.memorydata.plugin");
        com.obric.memorydata.memory.ui.settings.contextawareness.h r6 = com.obric.memorydata.memory.ui.settings.contextawareness.h.f11453a;
        Collection r7 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r5, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r8 = r5.iterator();
    L12:
        if (r8.hasNext() == false) goto L14;
        r7.add(r6.a((ContextAwarenessSystemApp) ZeusTransformUtils.preCheckCast(r8.next(), ContextAwarenessSystemApp.class, "com.obric.memorydata.plugin")));
        goto L12
    L14:
        Collection r9 = (Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r7, List.class, "com.obric.memorydata.plugin"), Collection.class, "com.obric.memorydata.plugin");
        Iterable r10 = (Iterable) ZeusTransformUtils.preCheckCast(ContextAwarenessGlobalSource.getEntries(), Iterable.class, "com.obric.memorydata.plugin");
        com.obric.memorydata.memory.ui.settings.contextawareness.h r11 = com.obric.memorydata.memory.ui.settings.contextawareness.h.f11453a;
        Collection r12 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r10, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r13 = r10.iterator();
    L16:
        if (r13.hasNext() == false) goto L18;
        r12.add(r11.a((ContextAwarenessGlobalSource) ZeusTransformUtils.preCheckCast(r13.next(), ContextAwarenessGlobalSource.class, "com.obric.memorydata.plugin")));
        goto L16
    L18:
        e().registerChangeListener((com.obric.memorydata.middleware.api.store.b) ZeusTransformUtils.preCheckCast(new g(CollectionsKt.plus((Collection) ZeusTransformUtils.preCheckCast(CollectionsKt.plus(r9, (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r12, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin")), Collection.class, "com.obric.memorydata.plugin"), "auto_learn_common_address")), com.obric.memorydata.middleware.api.store.b.class, "com.obric.memorydata.plugin"));
    }

    private final void k() {
        Iterator r8 = ((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.listOf(new kotlinx.coroutines.flow.i[]{com.obric.memorydata.memory.ui.settings.l.f11479a.a().i(), IdentityController.f12979a.a(), MemoryService.INSTANCE.experienceState(), RecommendApi.INSTANCE.screenObservationEnabled(), RecommendApi.INSTANCE.screenObservationCellularEnabled()}), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r8.hasNext() == false) goto L6;
        kotlinx.coroutines.i.a(e, null, null, (Function2) ZeusTransformUtils.preCheckCast(new MemorySettingsSnapshotReporter$registerStateFlows$1$1((kotlinx.coroutines.flow.i) ZeusTransformUtils.preCheckCast(r8.next(), kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin"), null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        goto L4
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [T, com.obric.aiproactive.api.DoubaoGlassesConnectionSnapshot] */
    private final void l() {
        final Ref.ObjectRef r2 = new Ref.ObjectRef();
        r2.element = DoubaoGlassesConnectionState.INSTANCE.currentSnapshot();
        DoubaoGlassesConnectionState.INSTANCE.registerListener(new $$Lambda$MemorySettingsSnapshotReporter$Qd7LXMGh6wHUP7y6tngCJHerLNI(r2), true);
    }

    public static /* synthetic */ void lambda$Qd7LXMGh6wHUP7y6tngCJHerLNI(Ref.ObjectRef r0, DoubaoGlassesConnectionSnapshot r1) {
        a(r0, r1);
    }

    public static /* synthetic */ IStore lambda$iDYbi3iZqNKgGHqzqQuc78bEmC4() {
        return n();
    }

    private final void m() {
        f r0 = new f();
        AwarenessManager.INSTANCE.registerAwarenessEvent("location_home_gps", (com.obric.memorydata.awareness.api.a) ZeusTransformUtils.preCheckCast(r0, com.obric.memorydata.awareness.api.a.class, "com.obric.memorydata.plugin"));
        AwarenessManager.INSTANCE.registerAwarenessEvent("location_company_gps", (com.obric.memorydata.awareness.api.a) ZeusTransformUtils.preCheckCast(r0, com.obric.memorydata.awareness.api.a.class, "com.obric.memorydata.plugin"));
        LocalBroadcastManager.getInstance((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).registerReceiver((PluginBroadcastReceiver) ZeusTransformUtils.preCheckCast(new e(), PluginBroadcastReceiver.class, "com.obric.memorydata.plugin"), new IntentFilter("com.obric.memorydata.action.SHORTCUT_RESULT"));
    }

    private static final IStore n() {
        return IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null);
    }

    public final void a() {
        if (f10518b.compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        kotlinx.coroutines.i.a(e, null, null, (Function2) ZeusTransformUtils.preCheckCast(new MemorySettingsSnapshotReporter$init$1(null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        b();
        j();
        k();
        m();
        l();
    }

    public final void b() {
        Object r0 = d;
        monitor-enter(r0);
        Object r1 = c;     // Catch: Throwable -> L15
        monitor-enter(r1);     // Catch: Throwable -> L15
        j = new a(UserSettings.INSTANCE.getUserId());     // Catch: Throwable -> L12
        Unit r2 = Unit.INSTANCE;     // Catch: Throwable -> L12
        monitor-exit(r1);     // Catch: Throwable -> L15
        Unit r3 = Unit.INSTANCE;     // Catch: Throwable -> L15
        monitor-exit(r0);
        a(Signal.INITIALIZE);
        return;
    L12:
        th = move-exception;
        throw th;     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        throw th;
    }

    public final void c() {
        a(Signal.SCREEN_ON);
    }
}
