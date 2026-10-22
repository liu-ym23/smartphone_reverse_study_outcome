package com.obric.memorydata.awareness;

import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.util.Size;
import android.util.SizeF;
import android.util.SparseArray;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import com.obric.memorydata.awareness.api.AwarenessManager;
import com.obric.memorydata.awareness.api.FeatureManager;
import com.obric.memorydata.awareness.impl.k;
import com.obric.memorydata.awareness.location.LocationProcessor;
import com.obric.memorydata.database.entity.MemoryKeyInfoEntity;
import com.obric.memorydata.memory.api.CommonAddressManager;
import com.obric.memorydata.memory.api.model.AddressInfo;
import com.obric.memorydata.memory.ui.list.MemoryListActivity;
import com.obric.memorydata.middleware.api.app.UserSettings;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.bdtracker.Tracker;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.sdk.MemoryResponse;
import com.obric.memorydata.sdk.awareness.e;
import com.obric.memorydata.sdk.awareness.f;
import com.obric.memorydata.utils.ak;
import com.volcengine.zeus.service.PluginService;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.i;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0002\u0012\u001c\u0018\u00002\u00020\u0001:\u0001*B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0016\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0019\u001a\u00020\u0005H\u0002J\n\u0010\u001a\u001a\u0004\u0018\u00010\u0005H\u0002J0\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00052\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\"2\u0006\u0010$\u001a\u00020\u00052\u0006\u0010%\u001a\u00020\u0005H\u0002J\u0012\u0010&\u001a\u00020\b2\b\u0010'\u001a\u0004\u0018\u00010(H\u0016J\u0012\u0010)\u001a\u00020\u001f2\b\u0010'\u001a\u0004\u0018\u00010(H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00050\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\r\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u000e0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0013R\u001a\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001d¨\u0006+"}, d2 = {"Lcom/obric/memorydata/awareness/ContextAwarenessService;", "Landroid/app/Service;", "<init>", "()V", "TAG", "", "featureListenerMap", "Ljava/util/concurrent/ConcurrentHashMap;", "Landroid/os/IBinder;", "Lcom/obric/memorydata/awareness/api/EventListener;", "eventListenerMap", "durationListenerMap", "Lcom/obric/memorydata/awareness/ContextAwarenessService$FeatureDurationListenerKey;", "registeredFeaturesByPackage", "", "dailyReportRegistered", "Ljava/util/concurrent/atomic/AtomicBoolean;", "registerFeatureDailyCallback", "com/obric/memorydata/awareness/ContextAwarenessService$registerFeatureDailyCallback$1", "Lcom/obric/memorydata/awareness/ContextAwarenessService$registerFeatureDailyCallback$1;", "featurePermission", "", "checkFeaturePermission", "Lcom/obric/memorydata/sdk/MemoryResponse;", "callPkg", "featureName", "getCallPackage", "binder", "com/obric/memorydata/awareness/ContextAwarenessService$binder$1", "Lcom/obric/memorydata/awareness/ContextAwarenessService$binder$1;", "isValidSetLocationParams", "", "locationType", "longitude", "", "latitude", ActivityLifecycle.NAME, MemoryListActivity.JUMP_FROM_DETAIL, "onBind", MemorySourceLinkType.INTENT, "Landroid/content/Intent;", "onUnbind", "FeatureDurationListenerKey", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ContextAwarenessService extends PluginService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f8489a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ConcurrentHashMap<IBinder, com.obric.memorydata.awareness.api.a> f8490b;
    private final ConcurrentHashMap<IBinder, com.obric.memorydata.awareness.api.a> c;
    private final ConcurrentHashMap<a, String> d;
    private final ConcurrentHashMap<String, Set<String>> e;
    private final AtomicBoolean f;
    private final c g;
    private final Map<String, String> h;
    private final b i;

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\bHÆ\u0003J\t\u0010\u001a\u001a\u00020\nHÆ\u0003J;\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\u001c\u001a\u00020\n2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006!"}, d2 = {"Lcom/obric/memorydata/awareness/ContextAwarenessService$FeatureDurationListenerKey;", "", "binder", "Landroid/os/IBinder;", "featureName", "", "targetFeatureValue", "durationSec", "", "oneShot", "", "<init>", "(Landroid/os/IBinder;Ljava/lang/String;Ljava/lang/String;JZ)V", "getBinder", "()Landroid/os/IBinder;", "getFeatureName", "()Ljava/lang/String;", "getTargetFeatureValue", "getDurationSec", "()J", "getOneShot", "()Z", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "", "toString", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final IBinder f8491a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f8492b;
        private final String c;
        private final long d;
        private final boolean e;

        public a(IBinder r3, String r4, String r5, long r6, boolean r8) {
            IBinder r7 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r7, "binder");
            Intrinsics.checkNotNullParameter(r4, "featureName");
            Intrinsics.checkNotNullParameter(r5, "targetFeatureValue");
            this.f8491a = r7;
            this.f8492b = r4;
            this.c = r5;
            this.d = r6;
            this.e = r8;
        }

        public boolean equals(Object r9) {
            if (this != r9) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r9, a.class) == true) goto L8;
            return false;
        L8:
            a r10 = (a) ZeusTransformUtils.preCheckCast(r9, a.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f8491a, r10.f8491a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f8492b, r10.f8492b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r10.c) == true) goto L18;
            return false;
        L18:
            if (this.d == r10.d) goto L21;
            return false;
        L21:
            if (this.e == r10.e) goto L23;
            return false;
        L23:
            return true;
        }

        public int hashCode() {
            return (((((((this.f8491a.hashCode() * 31) + this.f8492b.hashCode()) * 31) + this.c.hashCode()) * 31) + Long.hashCode(this.d)) * 31) + Boolean.hashCode(this.e);
        }

        public String toString() {
            return "FeatureDurationListenerKey(binder=" + this.f8491a + ", featureName=" + this.f8492b + ", targetFeatureValue=" + this.c + ", durationSec=" + this.d + ", oneShot=" + this.e + ')';
        }
    }

    @Metadata(d1 = {"\u0000k\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\u0005H\u0016J\u0016\u0010\n\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u001e\u0010\u000e\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u001c\u0010\u0011\u001a\u0006\u0012\u0002\b\u00030\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u001e\u0010\u0012\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u000b2\u0006\u0010\u0013\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0014H\u0016J4\u0010\u0015\u001a\u0006\u0012\u0002\b\u00030\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u001aH\u0016J4\u0010\u001b\u001a\u0006\u0012\u0002\b\u00030\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u001aH\u0016J(\u0010\u001c\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001f\u001a\u00020\rH\u0002J\u0016\u0010 \u001a\b\u0012\u0004\u0012\u00020!0\u000b2\u0006\u0010\"\u001a\u00020\rH\u0016J\u0016\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00050\u000b2\u0006\u0010$\u001a\u00020\rH\u0016J6\u0010%\u001a\b\u0012\u0004\u0012\u00020&0\u000b2\u0006\u0010'\u001a\u00020\r2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020)2\u0006\u0010+\u001a\u00020\r2\u0006\u0010,\u001a\u00020\rH\u0016¨\u0006-"}, d2 = {"com/obric/memorydata/awareness/ContextAwarenessService$binder$1", "Lcom/obric/memorydata/sdk/awareness/IContextAwarenessService$Stub;", "onTransact", "", "code", "", "data", "Landroid/os/Parcel;", "reply", "flags", "getFeature", "Lcom/obric/memorydata/sdk/MemoryResponse;", "featureName", "", "registerFeature", "listener", "Lcom/obric/memorydata/sdk/awareness/IFeatureChangeListener;", "unregisterFeature", "registerEvent", "event", "Lcom/obric/memorydata/sdk/awareness/IEventChangeListener;", "registerFeatureDuration", "targetFeatureValue", "durationSec", "", "oneShot", "Lcom/obric/memorydata/sdk/awareness/IFeatureDurationListener;", "unregisterFeatureDuration", "validateTargetFeatureValue", "currentValue", "", "targetValueRaw", "getLocation", "Landroid/location/Location;", "locationFeature", "getGeoFenceStatus", "fenceId", "setLocation", "Ljava/lang/Void;", "locationType", "longitude", "", "latitude", ActivityLifecycle.NAME, MemoryListActivity.JUMP_FROM_DETAIL, "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b extends com.obric.memorydata.sdk.awareness.c.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ContextAwarenessService f8493a;

        @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J(\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0016\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\tH\u0016J<\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00072\b\u0010\r\u001a\u0004\u0018\u00010\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\n2\u0016\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\tH\u0016¨\u0006\u000f"}, d2 = {"com/obric/memorydata/awareness/ContextAwarenessService$binder$1$registerEvent$internalListener$1", "Lcom/obric/memorydata/awareness/api/EventListener;", "observable", "", "onEvent", "", "eventName", "", WsConstants.KEY_EXTRA, "", "", "onFeatureChanged", "feature", "oldValue", "newValue", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class a implements com.obric.memorydata.awareness.api.a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ ContextAwarenessService f8494a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ String f8495b;
            final /* synthetic */ com.obric.memorydata.sdk.awareness.d c;

            a(ContextAwarenessService r3, String r4, com.obric.memorydata.sdk.awareness.d r5) {
                ContextAwarenessService r6 = (ContextAwarenessService) ZeusTransformUtils.wrapperContextForParams(r3, ContextAwarenessService.class, "com.obric.memorydata.plugin");
                com.obric.memorydata.sdk.awareness.d r7 = (com.obric.memorydata.sdk.awareness.d) ZeusTransformUtils.wrapperContextForParams(r5, com.obric.memorydata.sdk.awareness.d.class, "com.obric.memorydata.plugin");
                this.f8494a = r6;
                this.f8495b = r4;
                this.c = r7;
            }

            @Override // com.obric.memorydata.awareness.api.a
            public void a(String r1, Object r2, Object r3, Map<String, ? extends Object> r4) {
                Map r0 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
                Intrinsics.checkNotNullParameter(r1, "feature");
            }

            @Override // com.obric.memorydata.awareness.api.a
            public void a(String r8, Map<String, ? extends Object> r9) {
                Map<String, ? extends Object> r10 = (Map) ZeusTransformUtils.wrapperContextForParams(r9, Map.class, "com.obric.memorydata.plugin");
                Intrinsics.checkNotNullParameter(r8, "eventName");
                IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), ContextAwarenessService.b(this.f8494a), "notify client eventChanged: event=" + r8 + " extras=" + r10, false, 4, null);
                com.obric.memorydata.awareness.a.f8503a.a(r8, r10, this.f8495b);
                com.obric.memorydata.sdk.awareness.d r7 = this.c;     // Catch: RemoteException -> L9
                if (r10 == null) goto L6;
                Bundle r11 = com.obric.memorydata.sdk.a.a(r10);     // Catch: RemoteException -> L9
            L7:
                r7.a(r8, r11);     // Catch: RemoteException -> L9
                return;
            L6:
                r11 = null;
            L9:
                e = move-exception;
                e.printStackTrace();
            }

            @Override // com.obric.memorydata.awareness.api.a
            public boolean a() {
                return true;
            }

            @Override // com.obric.memorydata.awareness.api.a
            public void b(String r3, Object r4, Object r5, Map<String, ? extends Object> r6) {
                com.obric.memorydata.awareness.api.a.C0430a.a(this, r3, r4, r5, (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.memorydata.plugin"));
            }
        }

        /* JADX INFO: renamed from: com.obric.memorydata.awareness.ContextAwarenessService$b$b, reason: collision with other inner class name */
        @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J(\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0016\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\tH\u0016J<\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00072\b\u0010\r\u001a\u0004\u0018\u00010\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\n2\u0016\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\tH\u0016¨\u0006\u000f"}, d2 = {"com/obric/memorydata/awareness/ContextAwarenessService$binder$1$registerFeature$internalListener$1", "Lcom/obric/memorydata/awareness/api/EventListener;", "observable", "", "onEvent", "", "eventName", "", WsConstants.KEY_EXTRA, "", "", "onFeatureChanged", "feature", "oldValue", "newValue", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class C0429b implements com.obric.memorydata.awareness.api.a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f8496a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ ContextAwarenessService f8497b;
            final /* synthetic */ e c;

            C0429b(String r3, ContextAwarenessService r4, e r5) {
                ContextAwarenessService r6 = (ContextAwarenessService) ZeusTransformUtils.wrapperContextForParams(r4, ContextAwarenessService.class, "com.obric.memorydata.plugin");
                e r7 = (e) ZeusTransformUtils.wrapperContextForParams(r5, e.class, "com.obric.memorydata.plugin");
                this.f8496a = r3;
                this.f8497b = r6;
                this.c = r7;
            }

            @Override // com.obric.memorydata.awareness.api.a
            public void a(String r26, Object r27, Object r28, Map<String, ? extends Object> r29) {
                Map<String, ? extends Object> r12 = (Map) ZeusTransformUtils.wrapperContextForParams(r29, Map.class, "com.obric.memorydata.plugin");
                Intrinsics.checkNotNullParameter(r26, "feature");
                Bundle r14 = new Bundle();
                r14.putString("feature_name", r26);
                String r1 = "Unsupported type ";
                boolean r19 = false;
                if (r27 != null) goto L5;
                String r15 = "Unsupported ArrayList element type for key=";
                String r0 = " for key=";
            L167:
                if (r28 == 0) goto L330;
                String r21 = r0;
                if (ZeusTransformUtils.instanceOf(r28, Boolean.class) == false) goto L172;
                r14.putBoolean("new_value", ((Boolean) ZeusTransformUtils.preCheckCast(r28, Boolean.class, "com.obric.memorydata.plugin")).booleanValue());
                goto L330
            L172:
                if (ZeusTransformUtils.instanceOf(r28, Byte.class) == false) goto L175;
                r14.putByte("new_value", ((Number) ZeusTransformUtils.preCheckCast(r28, Number.class, "com.obric.memorydata.plugin")).byteValue());
                goto L330
            L175:
                if (ZeusTransformUtils.instanceOf(r28, Character.class) == false) goto L178;
                r14.putChar("new_value", ((Character) ZeusTransformUtils.preCheckCast(r28, Character.class, "com.obric.memorydata.plugin")).charValue());
                goto L330
            L178:
                if (ZeusTransformUtils.instanceOf(r28, Short.class) == false) goto L181;
                r14.putShort("new_value", ((Number) ZeusTransformUtils.preCheckCast(r28, Number.class, "com.obric.memorydata.plugin")).shortValue());
                goto L330
            L181:
                if (ZeusTransformUtils.instanceOf(r28, Integer.class) == false) goto L184;
                r14.putInt("new_value", ((Number) ZeusTransformUtils.preCheckCast(r28, Number.class, "com.obric.memorydata.plugin")).intValue());
                goto L330
            L184:
                if (ZeusTransformUtils.instanceOf(r28, Long.class) == false) goto L187;
                r14.putLong("new_value", ((Number) ZeusTransformUtils.preCheckCast(r28, Number.class, "com.obric.memorydata.plugin")).longValue());
                goto L330
            L187:
                if (ZeusTransformUtils.instanceOf(r28, Float.class) == false) goto L190;
                r14.putFloat("new_value", ((Number) ZeusTransformUtils.preCheckCast(r28, Number.class, "com.obric.memorydata.plugin")).floatValue());
                goto L330
            L190:
                if (ZeusTransformUtils.instanceOf(r28, Double.class) == false) goto L193;
                r14.putDouble("new_value", ((Number) ZeusTransformUtils.preCheckCast(r28, Number.class, "com.obric.memorydata.plugin")).doubleValue());
                goto L330
            L193:
                if (ZeusTransformUtils.instanceOf(r28, String.class) == false) goto L196;
                r14.putString("new_value", (String) ZeusTransformUtils.preCheckCast(r28, String.class, "com.obric.memorydata.plugin"));
                goto L330
            L196:
                if (ZeusTransformUtils.instanceOf(r28, CharSequence.class) == false) goto L199;
                r14.putCharSequence("new_value", (CharSequence) ZeusTransformUtils.preCheckCast(r28, CharSequence.class, "com.obric.memorydata.plugin"));
                goto L330
            L199:
                if (ZeusTransformUtils.instanceOf(r28, Parcelable.class) == false) goto L202;
                r14.putParcelable("new_value", (Parcelable) ZeusTransformUtils.preCheckCast(r28, Parcelable.class, "com.obric.memorydata.plugin"));
                goto L330
            L202:
                if (ZeusTransformUtils.instanceOf(r28, Serializable.class) == false) goto L205;
                r14.putSerializable("new_value", (Serializable) ZeusTransformUtils.preCheckCast(r28, Serializable.class, "com.obric.memorydata.plugin"));
                goto L330
            L205:
                if ((r28 instanceof boolean[]) == false) goto L208;
                r14.putBooleanArray("new_value", (boolean[]) ZeusTransformUtils.preCheckCast(r28, boolean[].class, "com.obric.memorydata.plugin"));
                goto L330
            L208:
                if ((r28 instanceof byte[]) == false) goto L211;
                r14.putByteArray("new_value", (byte[]) ZeusTransformUtils.preCheckCast(r28, byte[].class, "com.obric.memorydata.plugin"));
                goto L330
            L211:
                if ((r28 instanceof char[]) == false) goto L214;
                r14.putCharArray("new_value", (char[]) ZeusTransformUtils.preCheckCast(r28, char[].class, "com.obric.memorydata.plugin"));
                goto L330
            L214:
                if ((r28 instanceof short[]) == false) goto L217;
                r14.putShortArray("new_value", (short[]) ZeusTransformUtils.preCheckCast(r28, short[].class, "com.obric.memorydata.plugin"));
                goto L330
            L217:
                if ((r28 instanceof int[]) == false) goto L220;
                r14.putIntArray("new_value", (int[]) ZeusTransformUtils.preCheckCast(r28, int[].class, "com.obric.memorydata.plugin"));
                goto L330
            L220:
                if ((r28 instanceof long[]) == false) goto L223;
                r14.putLongArray("new_value", (long[]) ZeusTransformUtils.preCheckCast(r28, long[].class, "com.obric.memorydata.plugin"));
                goto L330
            L223:
                if ((r28 instanceof float[]) == false) goto L226;
                r14.putFloatArray("new_value", (float[]) ZeusTransformUtils.preCheckCast(r28, float[].class, "com.obric.memorydata.plugin"));
                goto L330
            L226:
                if ((r28 instanceof double[]) == false) goto L229;
                r14.putDoubleArray("new_value", (double[]) ZeusTransformUtils.preCheckCast(r28, double[].class, "com.obric.memorydata.plugin"));
                goto L330
            L229:
                if ((r28 instanceof Object[]) == false) goto L242;
                if ((((Object[]) ZeusTransformUtils.preCheckCast(r28, Object[].class, "com.obric.memorydata.plugin")) instanceof String[]) == false) goto L234;
                r14.putStringArray("new_value", (String[]) ZeusTransformUtils.preCheckCast(r28, String[].class, "com.obric.memorydata.plugin"));
                goto L330
            L234:
                if ((((Object[]) ZeusTransformUtils.preCheckCast(r28, Object[].class, "com.obric.memorydata.plugin")) instanceof CharSequence[]) == false) goto L237;
                r14.putCharSequenceArray("new_value", (CharSequence[]) ZeusTransformUtils.preCheckCast(r28, CharSequence[].class, "com.obric.memorydata.plugin"));
                goto L330
            L237:
                if ((((Object[]) ZeusTransformUtils.preCheckCast(r28, Object[].class, "com.obric.memorydata.plugin")) instanceof Parcelable[]) == false) goto L240;
                r14.putParcelableArray("new_value", (Parcelable[]) ZeusTransformUtils.preCheckCast(r28, Parcelable[].class, "com.obric.memorydata.plugin"));
                goto L330
            L240:
                throw new IllegalStateException(("Unsupported Array element type for key=new_value").toString());
            L242:
                if (ZeusTransformUtils.instanceOf(r28, ArrayList.class) == false) goto L302;
                Iterable r2 = (Iterable) ZeusTransformUtils.preCheckCast(r28, Iterable.class, "com.obric.memorydata.plugin");
                if (ZeusTransformUtils.instanceOf(r2, Collection.class) == true) goto L246;
            L248:
                Iterator r3 = r2.iterator();
            L250:
                if (r3.hasNext() == false) goto L247;
                Iterator r22 = r3;
                if (ZeusTransformUtils.instanceOf(r3.next(), String.class) == false) goto L253;
                r3 = r22;
                goto L250
            L253:
                boolean r4 = false;
            L255:
                if (r4 == false) goto L257;
                r14.putStringArrayList("new_value", (ArrayList) ZeusTransformUtils.preCheckCast(r28, ArrayList.class, "com.obric.memorydata.plugin"));
                goto L330
            L257:
                Iterable r5 = (Iterable) ZeusTransformUtils.preCheckCast(r28, Iterable.class, "com.obric.memorydata.plugin");
                if (ZeusTransformUtils.instanceOf(r5, Collection.class) == true) goto L260;
            L262:
                Iterator r6 = r5.iterator();
            L264:
                if (r6.hasNext() == false) goto L261;
                Iterator r23 = r6;
                if (ZeusTransformUtils.instanceOf(r6.next(), CharSequence.class) == false) goto L267;
                r6 = r23;
                goto L264
            L267:
                boolean r7 = false;
            L269:
                if (r7 == false) goto L271;
                r14.putCharSequenceArrayList("new_value", (ArrayList) ZeusTransformUtils.preCheckCast(r28, ArrayList.class, "com.obric.memorydata.plugin"));
                goto L330
            L271:
                Iterable r8 = (Iterable) ZeusTransformUtils.preCheckCast(r28, Iterable.class, "com.obric.memorydata.plugin");
                if (ZeusTransformUtils.instanceOf(r8, Collection.class) == true) goto L274;
            L276:
                Iterator r9 = r8.iterator();
            L278:
                if (r9.hasNext() == false) goto L275;
                Iterator r24 = r9;
                if (ZeusTransformUtils.instanceOf(r9.next(), Integer.class) == false) goto L281;
                r9 = r24;
                goto L278
            L281:
                boolean r10 = false;
            L283:
                if (r10 == false) goto L285;
                r14.putIntegerArrayList("new_value", (ArrayList) ZeusTransformUtils.preCheckCast(r28, ArrayList.class, "com.obric.memorydata.plugin"));
                goto L330
            L285:
                Iterable r11 = (Iterable) ZeusTransformUtils.preCheckCast(r28, Iterable.class, "com.obric.memorydata.plugin");
                if (ZeusTransformUtils.instanceOf(r11, Collection.class) == true) goto L288;
            L290:
                Iterator r13 = r11.iterator();
            L292:
                if (r13.hasNext() == false) goto L289;
                Iterator r25 = r13;
                if (ZeusTransformUtils.instanceOf(r13.next(), Parcelable.class) == false) goto L295;
                r13 = r25;
                goto L292
            L295:
                boolean r16 = false;
            L297:
                if (r16 == false) goto L300;
                r14.putParcelableArrayList("new_value", (ArrayList) ZeusTransformUtils.preCheckCast(r28, ArrayList.class, "com.obric.memorydata.plugin"));
                goto L330
            L300:
                throw new IllegalStateException((r15 + "new_value").toString());
            L289:
                r16 = true;
                goto L297
            L288:
                if (((Collection) ZeusTransformUtils.preCheckCast(r11, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L290;
            L275:
                r10 = true;
                goto L283
            L274:
                if (((Collection) ZeusTransformUtils.preCheckCast(r8, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L276;
            L261:
                r7 = true;
                goto L269
            L260:
                if (((Collection) ZeusTransformUtils.preCheckCast(r5, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L262;
            L247:
                r4 = true;
                goto L255
            L246:
                if (((Collection) ZeusTransformUtils.preCheckCast(r2, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L248;
            L302:
                if (ZeusTransformUtils.instanceOf(r28, SparseArray.class) == false) goto L305;
                r14.putSparseParcelableArray("new_value", (SparseArray) ZeusTransformUtils.preCheckCast(r28, SparseArray.class, "com.obric.memorydata.plugin"));
                goto L330
            L305:
                if (ZeusTransformUtils.instanceOf(r28, IBinder.class) == false) goto L312;
                if (Build.VERSION.SDK_INT < 18) goto L310;
                r14.putBinder("new_value", (IBinder) ZeusTransformUtils.preCheckCast(r28, IBinder.class, "com.obric.memorydata.plugin"));
                goto L330
            L310:
                throw new IllegalStateException("IBinder requires API 18+".toString());
            L312:
                if (ZeusTransformUtils.instanceOf(r28, Size.class) == false) goto L319;
                if (Build.VERSION.SDK_INT < 21) goto L317;
                r14.putSize("new_value", (Size) ZeusTransformUtils.preCheckCast(r28, Size.class, "com.obric.memorydata.plugin"));
                goto L330
            L317:
                throw new IllegalStateException("Size requires API 21+".toString());
            L319:
                if (ZeusTransformUtils.instanceOf(r28, SizeF.class) == false) goto L326;
                if (Build.VERSION.SDK_INT < 21) goto L324;
                r14.putSizeF("new_value", (SizeF) ZeusTransformUtils.preCheckCast(r28, SizeF.class, "com.obric.memorydata.plugin"));
                goto L330
            L324:
                throw new IllegalStateException("SizeF requires API 21+".toString());
            L326:
                if (ZeusTransformUtils.instanceOf(r28, Bundle.class) == false) goto L329;
                r14.putBundle("new_value", (Bundle) ZeusTransformUtils.preCheckCast(r28, Bundle.class, "com.obric.memorydata.plugin"));
                goto L330
            L329:
                throw new IllegalStateException((r1 + r28.getClass() + r21 + "new_value").toString());
            L330:
                if (r12 == null) goto L487;
                Bundle r17 = com.obric.memorydata.sdk.a.a(r12);
                if (r17 != null) goto L335;
                r14.remove("extras");
                goto L487
            L335:
                if (ZeusTransformUtils.instanceOf(r17, Boolean.class) == false) goto L338;
                r14.putBoolean("extras", ((Boolean) ZeusTransformUtils.preCheckCast(r17, Boolean.class, "com.obric.memorydata.plugin")).booleanValue());
                goto L487
            L338:
                if (ZeusTransformUtils.instanceOf(r17, Byte.class) == false) goto L341;
                r14.putByte("extras", ((Number) ZeusTransformUtils.preCheckCast(r17, Number.class, "com.obric.memorydata.plugin")).byteValue());
                goto L487
            L341:
                if (ZeusTransformUtils.instanceOf(r17, Character.class) == false) goto L344;
                r14.putChar("extras", ((Character) ZeusTransformUtils.preCheckCast(r17, Character.class, "com.obric.memorydata.plugin")).charValue());
                goto L487
            L344:
                if (ZeusTransformUtils.instanceOf(r17, Short.class) == false) goto L347;
                r14.putShort("extras", ((Number) ZeusTransformUtils.preCheckCast(r17, Number.class, "com.obric.memorydata.plugin")).shortValue());
                goto L487
            L347:
                if (ZeusTransformUtils.instanceOf(r17, Integer.class) == false) goto L350;
                r14.putInt("extras", ((Number) ZeusTransformUtils.preCheckCast(r17, Number.class, "com.obric.memorydata.plugin")).intValue());
                goto L487
            L350:
                if (ZeusTransformUtils.instanceOf(r17, Long.class) == false) goto L353;
                r14.putLong("extras", ((Number) ZeusTransformUtils.preCheckCast(r17, Number.class, "com.obric.memorydata.plugin")).longValue());
                goto L487
            L353:
                if (ZeusTransformUtils.instanceOf(r17, Float.class) == false) goto L356;
                r14.putFloat("extras", ((Number) ZeusTransformUtils.preCheckCast(r17, Number.class, "com.obric.memorydata.plugin")).floatValue());
                goto L487
            L356:
                if (ZeusTransformUtils.instanceOf(r17, Double.class) == false) goto L359;
                r14.putDouble("extras", ((Number) ZeusTransformUtils.preCheckCast(r17, Number.class, "com.obric.memorydata.plugin")).doubleValue());
                goto L487
            L359:
                if (ZeusTransformUtils.instanceOf(r17, String.class) == false) goto L362;
                r14.putString("extras", (String) ZeusTransformUtils.preCheckCast(r17, String.class, "com.obric.memorydata.plugin"));
                goto L487
            L362:
                if (ZeusTransformUtils.instanceOf(r17, CharSequence.class) == false) goto L365;
                r14.putCharSequence("extras", (CharSequence) ZeusTransformUtils.preCheckCast(r17, CharSequence.class, "com.obric.memorydata.plugin"));
                goto L487
            L365:
                if (ZeusTransformUtils.instanceOf(r17, Parcelable.class) == false) goto L368;
                r14.putParcelable("extras", (Parcelable) ZeusTransformUtils.preCheckCast(r17, Parcelable.class, "com.obric.memorydata.plugin"));
                goto L487
            L368:
                if (ZeusTransformUtils.instanceOf(r17, Serializable.class) == false) goto L371;
                r14.putSerializable("extras", (Serializable) ZeusTransformUtils.preCheckCast(r17, Serializable.class, "com.obric.memorydata.plugin"));
                goto L487
            L371:
                if ((r17 instanceof boolean[]) == false) goto L374;
                r14.putBooleanArray("extras", (boolean[]) ZeusTransformUtils.preCheckCast(r17, boolean[].class, "com.obric.memorydata.plugin"));
                goto L487
            L374:
                if ((r17 instanceof byte[]) == false) goto L377;
                r14.putByteArray("extras", (byte[]) ZeusTransformUtils.preCheckCast(r17, byte[].class, "com.obric.memorydata.plugin"));
                goto L487
            L377:
                if ((r17 instanceof char[]) == false) goto L380;
                r14.putCharArray("extras", (char[]) ZeusTransformUtils.preCheckCast(r17, char[].class, "com.obric.memorydata.plugin"));
                goto L487
            L380:
                if ((r17 instanceof short[]) == false) goto L383;
                r14.putShortArray("extras", (short[]) ZeusTransformUtils.preCheckCast(r17, short[].class, "com.obric.memorydata.plugin"));
                goto L487
            L383:
                if ((r17 instanceof int[]) == false) goto L386;
                r14.putIntArray("extras", (int[]) ZeusTransformUtils.preCheckCast(r17, int[].class, "com.obric.memorydata.plugin"));
                goto L487
            L386:
                if ((r17 instanceof long[]) == false) goto L389;
                r14.putLongArray("extras", (long[]) ZeusTransformUtils.preCheckCast(r17, long[].class, "com.obric.memorydata.plugin"));
                goto L487
            L389:
                if ((r17 instanceof float[]) == false) goto L392;
                r14.putFloatArray("extras", (float[]) ZeusTransformUtils.preCheckCast(r17, float[].class, "com.obric.memorydata.plugin"));
                goto L487
            L392:
                if ((r17 instanceof double[]) == false) goto L395;
                r14.putDoubleArray("extras", (double[]) ZeusTransformUtils.preCheckCast(r17, double[].class, "com.obric.memorydata.plugin"));
                goto L487
            L395:
                if ((r17 instanceof Object[]) == false) goto L408;
                if ((((Object[]) ZeusTransformUtils.preCheckCast(r17, Object[].class, "com.obric.memorydata.plugin")) instanceof String[]) == false) goto L400;
                r14.putStringArray("extras", (String[]) ZeusTransformUtils.preCheckCast(r17, String[].class, "com.obric.memorydata.plugin"));
                goto L487
            L400:
                if ((((Object[]) ZeusTransformUtils.preCheckCast(r17, Object[].class, "com.obric.memorydata.plugin")) instanceof CharSequence[]) == false) goto L403;
                r14.putCharSequenceArray("extras", (CharSequence[]) ZeusTransformUtils.preCheckCast(r17, CharSequence[].class, "com.obric.memorydata.plugin"));
                goto L487
            L403:
                if ((((Object[]) ZeusTransformUtils.preCheckCast(r17, Object[].class, "com.obric.memorydata.plugin")) instanceof Parcelable[]) == false) goto L406;
                r14.putParcelableArray("extras", (Parcelable[]) ZeusTransformUtils.preCheckCast(r17, Parcelable[].class, "com.obric.memorydata.plugin"));
                goto L487
            L406:
                throw new IllegalStateException(("Unsupported Array element type for key=extras").toString());
            L408:
                if (ZeusTransformUtils.instanceOf(r17, ArrayList.class) == false) goto L463;
                Iterable r18 = (Iterable) ZeusTransformUtils.preCheckCast(r17, Iterable.class, "com.obric.memorydata.plugin");
                if (ZeusTransformUtils.instanceOf(r18, Collection.class) == true) goto L412;
            L414:
                Iterator r20 = r18.iterator();
            L416:
                if (r20.hasNext() == false) goto L413;
                if (ZeusTransformUtils.instanceOf(r20.next(), String.class) == true) goto L416;
                boolean r30 = false;
            L420:
                if (r30 == false) goto L422;
                r14.putStringArrayList("extras", (ArrayList) ZeusTransformUtils.preCheckCast(r17, ArrayList.class, "com.obric.memorydata.plugin"));
                goto L487
            L422:
                Iterable r31 = (Iterable) ZeusTransformUtils.preCheckCast(r17, Iterable.class, "com.obric.memorydata.plugin");
                if (ZeusTransformUtils.instanceOf(r31, Collection.class) == true) goto L425;
            L427:
                Iterator r32 = r31.iterator();
            L429:
                if (r32.hasNext() == false) goto L426;
                if (ZeusTransformUtils.instanceOf(r32.next(), CharSequence.class) == true) goto L429;
                boolean r33 = false;
            L433:
                if (r33 == false) goto L435;
                r14.putCharSequenceArrayList("extras", (ArrayList) ZeusTransformUtils.preCheckCast(r17, ArrayList.class, "com.obric.memorydata.plugin"));
                goto L487
            L435:
                Iterable r34 = (Iterable) ZeusTransformUtils.preCheckCast(r17, Iterable.class, "com.obric.memorydata.plugin");
                if (ZeusTransformUtils.instanceOf(r34, Collection.class) == true) goto L438;
            L440:
                Iterator r35 = r34.iterator();
            L442:
                if (r35.hasNext() == false) goto L439;
                if (ZeusTransformUtils.instanceOf(r35.next(), Integer.class) == true) goto L442;
                boolean r36 = false;
            L446:
                if (r36 == false) goto L448;
                r14.putIntegerArrayList("extras", (ArrayList) ZeusTransformUtils.preCheckCast(r17, ArrayList.class, "com.obric.memorydata.plugin"));
                goto L487
            L448:
                Iterable r37 = (Iterable) ZeusTransformUtils.preCheckCast(r17, Iterable.class, "com.obric.memorydata.plugin");
                if (ZeusTransformUtils.instanceOf(r37, Collection.class) == true) goto L451;
            L453:
                Iterator r38 = r37.iterator();
            L455:
                if (r38.hasNext() == false) goto L452;
                if (ZeusTransformUtils.instanceOf(r38.next(), Parcelable.class) == true) goto L455;
            L458:
                if (r19 == false) goto L461;
                r14.putParcelableArrayList("extras", (ArrayList) ZeusTransformUtils.preCheckCast(r17, ArrayList.class, "com.obric.memorydata.plugin"));
                goto L487
            L461:
                throw new IllegalStateException((r15 + "extras").toString());
            L452:
                r19 = true;
                goto L458
            L451:
                if (((Collection) ZeusTransformUtils.preCheckCast(r37, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L453;
            L439:
                r36 = true;
                goto L446
            L438:
                if (((Collection) ZeusTransformUtils.preCheckCast(r34, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L440;
            L426:
                r33 = true;
                goto L433
            L425:
                if (((Collection) ZeusTransformUtils.preCheckCast(r31, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L427;
            L413:
                r30 = true;
                goto L420
            L412:
                if (((Collection) ZeusTransformUtils.preCheckCast(r18, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L414;
            L463:
                if (ZeusTransformUtils.instanceOf(r17, SparseArray.class) == false) goto L466;
                r14.putSparseParcelableArray("extras", (SparseArray) ZeusTransformUtils.preCheckCast(r17, SparseArray.class, "com.obric.memorydata.plugin"));
                goto L487
            L466:
                if (ZeusTransformUtils.instanceOf(r17, IBinder.class) == false) goto L473;
                if (Build.VERSION.SDK_INT < 18) goto L471;
                r14.putBinder("extras", (IBinder) ZeusTransformUtils.preCheckCast(r17, IBinder.class, "com.obric.memorydata.plugin"));
                goto L487
            L471:
                throw new IllegalStateException("IBinder requires API 18+".toString());
            L473:
                if (ZeusTransformUtils.instanceOf(r17, Size.class) == false) goto L480;
                if (Build.VERSION.SDK_INT < 21) goto L478;
                r14.putSize("extras", (Size) ZeusTransformUtils.preCheckCast(r17, Size.class, "com.obric.memorydata.plugin"));
                goto L487
            L478:
                throw new IllegalStateException("Size requires API 21+".toString());
            L480:
                if (ZeusTransformUtils.instanceOf(r17, SizeF.class) == true) goto L482;
                r14.putBundle("extras", r17);
                goto L487
            L482:
                if (Build.VERSION.SDK_INT < 21) goto L485;
                r14.putSizeF("extras", (SizeF) ZeusTransformUtils.preCheckCast(r17, SizeF.class, "com.obric.memorydata.plugin"));
                goto L487
            L485:
                throw new IllegalStateException("SizeF requires API 21+".toString());
            L487:
                com.obric.memorydata.awareness.a.f8503a.a(r26, r28, r12, this.f8496a);
                if (com.obric.memorydata.awareness.impl.b.f8632a.a().contains(r26) == false) goto L490;
                IRunLog r39 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
                String r40 = "notify client featureChanged: feature=" + r26;
                boolean r41 = false;
                int r42 = 4;
                Object r43 = null;
                String r44 = ContextAwarenessService.b(this.f8497b);
            L491:
                IRunLog.a.a(r39, r44, r40, r41, r42, r43);
                this.c.a(r14);     // Catch: RemoteException -> L494
                return;
            L494:
                e = move-exception;
                e.printStackTrace();
                return;
            L490:
                IRunLog r45 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
                r41 = false;
                r42 = 4;
                r43 = null;
                r39 = r45;
                r44 = ContextAwarenessService.b(this.f8497b);
                r40 = "notify client featureChanged: feature=" + r26 + " old=" + r27 + " new=" + r28;
                goto L491
            L5:
                if (ZeusTransformUtils.instanceOf(r27, Boolean.class) == false) goto L9;
                r14.putBoolean("old_value", ((Boolean) ZeusTransformUtils.preCheckCast(r27, Boolean.class, "com.obric.memorydata.plugin")).booleanValue());
            L7:
                r15 = "Unsupported ArrayList element type for key=";
                String r210 = "Unsupported type ";
            L162:
                r0 = " for key=";
                r1 = r210;
                goto L167
            L9:
                if (ZeusTransformUtils.instanceOf(r27, Byte.class) == false) goto L12;
                r14.putByte("old_value", ((Number) ZeusTransformUtils.preCheckCast(r27, Number.class, "com.obric.memorydata.plugin")).byteValue());
                goto L7
            L12:
                if (ZeusTransformUtils.instanceOf(r27, Character.class) == false) goto L15;
                r14.putChar("old_value", ((Character) ZeusTransformUtils.preCheckCast(r27, Character.class, "com.obric.memorydata.plugin")).charValue());
                goto L7
            L15:
                if (ZeusTransformUtils.instanceOf(r27, Short.class) == false) goto L18;
                r14.putShort("old_value", ((Number) ZeusTransformUtils.preCheckCast(r27, Number.class, "com.obric.memorydata.plugin")).shortValue());
                goto L7
            L18:
                if (ZeusTransformUtils.instanceOf(r27, Integer.class) == false) goto L21;
                r14.putInt("old_value", ((Number) ZeusTransformUtils.preCheckCast(r27, Number.class, "com.obric.memorydata.plugin")).intValue());
                goto L7
            L21:
                if (ZeusTransformUtils.instanceOf(r27, Long.class) == false) goto L24;
                String r211 = "Unsupported ArrayList element type for key=";
                r210 = "Unsupported type ";
                r14.putLong("old_value", ((Number) ZeusTransformUtils.preCheckCast(r27, Number.class, "com.obric.memorydata.plugin")).longValue());
            L23:
                r15 = r211;
                goto L162
            L24:
                r211 = "Unsupported ArrayList element type for key=";
                r210 = "Unsupported type ";
                if (ZeusTransformUtils.instanceOf(r27, Float.class) == false) goto L28;
                r14.putFloat("old_value", ((Number) ZeusTransformUtils.preCheckCast(r27, Number.class, "com.obric.memorydata.plugin")).floatValue());
                goto L23
            L28:
                if (ZeusTransformUtils.instanceOf(r27, Double.class) == false) goto L31;
                r14.putDouble("old_value", ((Number) ZeusTransformUtils.preCheckCast(r27, Number.class, "com.obric.memorydata.plugin")).doubleValue());
                goto L23
            L31:
                if (ZeusTransformUtils.instanceOf(r27, String.class) == false) goto L34;
                r14.putString("old_value", (String) ZeusTransformUtils.preCheckCast(r27, String.class, "com.obric.memorydata.plugin"));
                goto L23
            L34:
                if (ZeusTransformUtils.instanceOf(r27, CharSequence.class) == false) goto L37;
                r14.putCharSequence("old_value", (CharSequence) ZeusTransformUtils.preCheckCast(r27, CharSequence.class, "com.obric.memorydata.plugin"));
                goto L23
            L37:
                if (ZeusTransformUtils.instanceOf(r27, Parcelable.class) == false) goto L40;
                r14.putParcelable("old_value", (Parcelable) ZeusTransformUtils.preCheckCast(r27, Parcelable.class, "com.obric.memorydata.plugin"));
                goto L23
            L40:
                if (ZeusTransformUtils.instanceOf(r27, Serializable.class) == false) goto L43;
                r14.putSerializable("old_value", (Serializable) ZeusTransformUtils.preCheckCast(r27, Serializable.class, "com.obric.memorydata.plugin"));
                goto L23
            L43:
                if ((r27 instanceof boolean[]) == false) goto L46;
                r14.putBooleanArray("old_value", (boolean[]) ZeusTransformUtils.preCheckCast(r27, boolean[].class, "com.obric.memorydata.plugin"));
                goto L23
            L46:
                if ((r27 instanceof byte[]) == false) goto L49;
                r14.putByteArray("old_value", (byte[]) ZeusTransformUtils.preCheckCast(r27, byte[].class, "com.obric.memorydata.plugin"));
                goto L23
            L49:
                if ((r27 instanceof char[]) == false) goto L52;
                r14.putCharArray("old_value", (char[]) ZeusTransformUtils.preCheckCast(r27, char[].class, "com.obric.memorydata.plugin"));
                goto L23
            L52:
                if ((r27 instanceof short[]) == false) goto L55;
                r14.putShortArray("old_value", (short[]) ZeusTransformUtils.preCheckCast(r27, short[].class, "com.obric.memorydata.plugin"));
                goto L23
            L55:
                if ((r27 instanceof int[]) == false) goto L58;
                r14.putIntArray("old_value", (int[]) ZeusTransformUtils.preCheckCast(r27, int[].class, "com.obric.memorydata.plugin"));
                goto L23
            L58:
                if ((r27 instanceof long[]) == false) goto L61;
                r14.putLongArray("old_value", (long[]) ZeusTransformUtils.preCheckCast(r27, long[].class, "com.obric.memorydata.plugin"));
                goto L23
            L61:
                if ((r27 instanceof float[]) == false) goto L64;
                r14.putFloatArray("old_value", (float[]) ZeusTransformUtils.preCheckCast(r27, float[].class, "com.obric.memorydata.plugin"));
                goto L23
            L64:
                if ((r27 instanceof double[]) == false) goto L67;
                r14.putDoubleArray("old_value", (double[]) ZeusTransformUtils.preCheckCast(r27, double[].class, "com.obric.memorydata.plugin"));
                goto L23
            L67:
                if ((r27 instanceof Object[]) == false) goto L80;
                if ((((Object[]) ZeusTransformUtils.preCheckCast(r27, Object[].class, "com.obric.memorydata.plugin")) instanceof String[]) == false) goto L72;
                r14.putStringArray("old_value", (String[]) ZeusTransformUtils.preCheckCast(r27, String[].class, "com.obric.memorydata.plugin"));
                goto L23
            L72:
                if ((((Object[]) ZeusTransformUtils.preCheckCast(r27, Object[].class, "com.obric.memorydata.plugin")) instanceof CharSequence[]) == false) goto L75;
                r14.putCharSequenceArray("old_value", (CharSequence[]) ZeusTransformUtils.preCheckCast(r27, CharSequence[].class, "com.obric.memorydata.plugin"));
                goto L23
            L75:
                if ((((Object[]) ZeusTransformUtils.preCheckCast(r27, Object[].class, "com.obric.memorydata.plugin")) instanceof Parcelable[]) == false) goto L78;
                r14.putParcelableArray("old_value", (Parcelable[]) ZeusTransformUtils.preCheckCast(r27, Parcelable[].class, "com.obric.memorydata.plugin"));
                goto L23
            L78:
                throw new IllegalStateException(("Unsupported Array element type for key=old_value").toString());
            L80:
                if (ZeusTransformUtils.instanceOf(r27, ArrayList.class) == false) goto L135;
                Iterable r46 = (Iterable) ZeusTransformUtils.preCheckCast(r27, Iterable.class, "com.obric.memorydata.plugin");
                if (ZeusTransformUtils.instanceOf(r46, Collection.class) == true) goto L84;
            L86:
                Iterator r47 = r46.iterator();
            L88:
                if (r47.hasNext() == false) goto L85;
                if (ZeusTransformUtils.instanceOf(r47.next(), String.class) == true) goto L88;
                boolean r48 = false;
            L92:
                if (r48 == false) goto L94;
                r14.putStringArrayList("old_value", (ArrayList) ZeusTransformUtils.preCheckCast(r27, ArrayList.class, "com.obric.memorydata.plugin"));
                goto L23
            L94:
                Iterable r49 = (Iterable) ZeusTransformUtils.preCheckCast(r27, Iterable.class, "com.obric.memorydata.plugin");
                if (ZeusTransformUtils.instanceOf(r49, Collection.class) == true) goto L97;
            L99:
                Iterator r50 = r49.iterator();
            L101:
                if (r50.hasNext() == false) goto L98;
                if (ZeusTransformUtils.instanceOf(r50.next(), CharSequence.class) == true) goto L101;
                boolean r51 = false;
            L105:
                if (r51 == false) goto L107;
                r14.putCharSequenceArrayList("old_value", (ArrayList) ZeusTransformUtils.preCheckCast(r27, ArrayList.class, "com.obric.memorydata.plugin"));
                goto L23
            L107:
                Iterable r52 = (Iterable) ZeusTransformUtils.preCheckCast(r27, Iterable.class, "com.obric.memorydata.plugin");
                if (ZeusTransformUtils.instanceOf(r52, Collection.class) == true) goto L110;
            L112:
                Iterator r53 = r52.iterator();
            L114:
                if (r53.hasNext() == false) goto L111;
                if (ZeusTransformUtils.instanceOf(r53.next(), Integer.class) == true) goto L114;
                boolean r54 = false;
            L118:
                if (r54 == false) goto L120;
                r14.putIntegerArrayList("old_value", (ArrayList) ZeusTransformUtils.preCheckCast(r27, ArrayList.class, "com.obric.memorydata.plugin"));
                goto L23
            L120:
                Iterable r55 = (Iterable) ZeusTransformUtils.preCheckCast(r27, Iterable.class, "com.obric.memorydata.plugin");
                if (ZeusTransformUtils.instanceOf(r55, Collection.class) == true) goto L123;
            L125:
                Iterator r56 = r55.iterator();
            L127:
                if (r56.hasNext() == false) goto L124;
                if (ZeusTransformUtils.instanceOf(r56.next(), Parcelable.class) == true) goto L127;
                boolean r57 = false;
            L131:
                if (r57 == false) goto L134;
                r14.putParcelableArrayList("old_value", (ArrayList) ZeusTransformUtils.preCheckCast(r27, ArrayList.class, "com.obric.memorydata.plugin"));
                goto L23
            L134:
                throw new IllegalStateException((r211 + "old_value").toString());
            L124:
                r57 = true;
                goto L131
            L123:
                if (((Collection) ZeusTransformUtils.preCheckCast(r55, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L125;
            L111:
                r54 = true;
                goto L118
            L110:
                if (((Collection) ZeusTransformUtils.preCheckCast(r52, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L112;
            L98:
                r51 = true;
                goto L105
            L97:
                if (((Collection) ZeusTransformUtils.preCheckCast(r49, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L99;
            L85:
                r48 = true;
                goto L92
            L84:
                if (((Collection) ZeusTransformUtils.preCheckCast(r46, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L86;
            L135:
                r15 = r211;
                if (ZeusTransformUtils.instanceOf(r27, SparseArray.class) == false) goto L139;
                r14.putSparseParcelableArray("old_value", (SparseArray) ZeusTransformUtils.preCheckCast(r27, SparseArray.class, "com.obric.memorydata.plugin"));
                goto L162
            L139:
                if (ZeusTransformUtils.instanceOf(r27, IBinder.class) == false) goto L146;
                if (Build.VERSION.SDK_INT < 18) goto L144;
                r14.putBinder("old_value", (IBinder) ZeusTransformUtils.preCheckCast(r27, IBinder.class, "com.obric.memorydata.plugin"));
                goto L162
            L144:
                throw new IllegalStateException("IBinder requires API 18+".toString());
            L146:
                if (ZeusTransformUtils.instanceOf(r27, Size.class) == false) goto L153;
                if (Build.VERSION.SDK_INT < 21) goto L151;
                r14.putSize("old_value", (Size) ZeusTransformUtils.preCheckCast(r27, Size.class, "com.obric.memorydata.plugin"));
                goto L162
            L151:
                throw new IllegalStateException("Size requires API 21+".toString());
            L153:
                if (ZeusTransformUtils.instanceOf(r27, SizeF.class) == false) goto L160;
                if (Build.VERSION.SDK_INT < 21) goto L158;
                r14.putSizeF("old_value", (SizeF) ZeusTransformUtils.preCheckCast(r27, SizeF.class, "com.obric.memorydata.plugin"));
                goto L162
            L158:
                throw new IllegalStateException("SizeF requires API 21+".toString());
            L160:
                if (ZeusTransformUtils.instanceOf(r27, Bundle.class) == false) goto L164;
                r14.putBundle("old_value", (Bundle) ZeusTransformUtils.preCheckCast(r27, Bundle.class, "com.obric.memorydata.plugin"));
                goto L162
            L164:
                throw new IllegalStateException((r210 + r27.getClass() + " for key=old_value").toString());
            }

            @Override // com.obric.memorydata.awareness.api.a
            public void a(String r2, Map<String, ? extends Object> r3) {
                Map r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
                Intrinsics.checkNotNullParameter(r2, "eventName");
            }

            @Override // com.obric.memorydata.awareness.api.a
            public boolean a() {
                return true;
            }

            @Override // com.obric.memorydata.awareness.api.a
            public void b(String r3, Object r4, Object r5, Map<String, ? extends Object> r6) {
                com.obric.memorydata.awareness.api.a.C0430a.a(this, r3, r4, r5, (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.memorydata.plugin"));
            }
        }

        b(ContextAwarenessService r3) {
            this.f8493a = (ContextAwarenessService) ZeusTransformUtils.wrapperContextForParams(r3, ContextAwarenessService.class, "com.obric.memorydata.plugin");
        }

        private final MemoryResponse<?> a(String r11, Object r12, String r13) {
            if (r12 != null) goto L6;
            return null;
        L6:
            if (ZeusTransformUtils.instanceOf(r12, String.class) == true) goto L46;
            boolean r4 = false;
            if (ZeusTransformUtils.instanceOf(r12, Integer.class) == true) goto L36;
            if (ZeusTransformUtils.instanceOf(r12, Long.class) == true) goto L36;
            if (ZeusTransformUtils.instanceOf(r12, Short.class) == true) goto L36;
            if (ZeusTransformUtils.instanceOf(r12, Byte.class) == true) goto L36;
            if (ZeusTransformUtils.instanceOf(r12, Boolean.class) == false) goto L27;
            String r14 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r13, CharSequence.class, "com.obric.memorydata.plugin")).toString();
            if (StringsKt.equals(r14, "true", true) == false) goto L22;
        L23:
            r4 = true;
        L24:
            if (r4 == true) goto L42;
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), ContextAwarenessService.b(this.f8493a), "registerFeatureDuration invalid boolean target, feature=" + r11 + ", target=" + r13, null, 4, null);
            MemoryResponse<?> r10 = new MemoryResponse(405, "targetFeatureValue is not a valid boolean value", null);
        L41:
            return r10;
        L42:
            return null;
        L22:
            if (StringsKt.equals(r14, "false", true) == false) goto L24;
        L27:
            if (ZeusTransformUtils.instanceOf(r12, Float.class) == true) goto L31;
            if (ZeusTransformUtils.instanceOf(r12, Double.class) == true) goto L31;
            return null;
        L31:
            if (StringsKt.toDoubleOrNull(r13) == null) goto L33;
            r4 = true;
        L33:
            if (r4 == true) goto L44;
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), ContextAwarenessService.b(this.f8493a), "registerFeatureDuration invalid floating target, feature=" + r11 + ", target=" + r13, null, 4, null);
            r10 = new MemoryResponse(405, "targetFeatureValue is not a valid floating value", null);
            goto L41
        L44:
            return null;
        L36:
            if (StringsKt.toLongOrNull(r13) == null) goto L38;
            r4 = true;
        L38:
            if (r4 == true) goto L45;
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), ContextAwarenessService.b(this.f8493a), "registerFeatureDuration invalid integral target, feature=" + r11 + ", target=" + r13, null, 4, null);
            r10 = new MemoryResponse(405, "targetFeatureValue is not a valid integral value", null);
            goto L41
        L45:
            return null;
        L46:
            return null;
        }

        private static final Set a(Function1 r2, Object r3) {
            return (Set) ZeusTransformUtils.preCheckCast(((Function1) ZeusTransformUtils.wrapperContextForParams(r2, Function1.class, "com.obric.memorydata.plugin")).invoke(r3), Set.class, "com.obric.memorydata.plugin");
        }

        private static final Unit a(ContextAwarenessService r8, String r9, String r10, long r11, f r13, k.c r14) {
            ContextAwarenessService r12 = (ContextAwarenessService) ZeusTransformUtils.wrapperContextForParams(r8, ContextAwarenessService.class, "com.obric.memorydata.plugin");
            f r15 = (f) ZeusTransformUtils.wrapperContextForParams(r13, f.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r14, "it");
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), ContextAwarenessService.b(r12), "notify client featureDurationTriggered: feature=" + r9 + " target=" + r10 + " duration=" + r11, false, 4, null);
            r15.a(r9, r10, r11);     // Catch: RemoteException -> L5
        L8:
            return Unit.INSTANCE;
        L5:
            e = move-exception;
            RunLog.INSTANCE.warn(ContextAwarenessService.b(r12), "notify featureDurationTriggered failed", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
            goto L8
        }

        private static final Set b(Function1 r2, Object r3) {
            return (Set) ZeusTransformUtils.preCheckCast(((Function1) ZeusTransformUtils.wrapperContextForParams(r2, Function1.class, "com.obric.memorydata.plugin")).invoke(r3), Set.class, "com.obric.memorydata.plugin");
        }

        private static final Set d(String r2) {
            Intrinsics.checkNotNullParameter(r2, "it");
            return (Set) ZeusTransformUtils.preCheckCast(ConcurrentHashMap.newKeySet(), Set.class, "com.obric.memorydata.plugin");
        }

        private static final Set e(String r2) {
            Intrinsics.checkNotNullParameter(r2, "it");
            return (Set) ZeusTransformUtils.preCheckCast(ConcurrentHashMap.newKeySet(), Set.class, "com.obric.memorydata.plugin");
        }

        public static /* synthetic */ Set lambda$4HH2UaqHMuaoBbUOQyz6Lr1BiLk(Function1 r0, Object r1) {
            return b(r0, r1);
        }

        public static /* synthetic */ Set lambda$6qXqlwUyrGh4FyBG1vc2NcyIGYY(Function1 r0, Object r1) {
            return a(r0, r1);
        }

        public static /* synthetic */ Set lambda$J7RsFQNzNZE5kjdDzBmPAfmmEjA(String r0) {
            return e(r0);
        }

        /* JADX INFO: renamed from: lambda$db3wK-nowOiK4mXbU9gIU_Hp8OM, reason: not valid java name */
        public static /* synthetic */ Set m470lambda$db3wKnowOiK4mXbU9gIU_Hp8OM(String r0) {
            return d(r0);
        }

        /* JADX INFO: renamed from: lambda$ix0517-rLB2obR-Wv6fa_I5_qes, reason: not valid java name */
        public static /* synthetic */ Unit m471lambda$ix0517rLB2obRWv6fa_I5_qes(ContextAwarenessService r0, String r1, String r2, long r3, f r5, k.c r6) {
            return a(r0, r1, r2, r3, r5, r6);
        }

        @Override // com.obric.memorydata.sdk.awareness.c
        public MemoryResponse<?> a(String r13) {
            Intrinsics.checkNotNullParameter(r13, "featureName");
            String r0 = ContextAwarenessService.c(this.f8493a);
            if (UserSettings.INSTANCE.hasAgreePrivacy() == true) goto L6;
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), ContextAwarenessService.b(this.f8493a), "privacy not allowed for package " + r0 + " feature=" + r13, null, 4, null);
            return new MemoryResponse(403, "memorydata privacy not allowed", null);
        L6:
            MemoryResponse<?> r1 = ContextAwarenessService.a(this.f8493a, r0, r13);
            if (r1 == null) goto L10;
            return r1;
        L10:
            if (FeatureManager.INSTANCE.hasDefineFeature(r13) == true) goto L13;
            IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), ContextAwarenessService.b(this.f8493a), "invalid feature parameter: feature=" + r13 + " is not defined", null, 4, null);
            return new MemoryResponse(405, "feature is not defined", null);
        L13:
            Object r2 = FeatureManager.INSTANCE.getFeature(r13);
            if (com.obric.memorydata.awareness.impl.b.f8632a.a().contains(r13) == false) goto L16;
            IRunLog r6 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
            String r7 = ContextAwarenessService.b(this.f8493a);
            StringBuilder r12 = new StringBuilder().append("calling package ").append(r0).append(" getFeature ").append(r13);
        L17:
            IRunLog.a.a(r6, r7, r12.toString(), false, 4, null);
            return new MemoryResponse(0, "success", r2);
        L16:
            r6 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
            r7 = ContextAwarenessService.b(this.f8493a);
            r12 = new StringBuilder().append("calling package ").append(r0).append(" getFeature ").append(r13).append(" return ").append(r2);
            goto L17
        }

        @Override // com.obric.memorydata.sdk.awareness.c
        public MemoryResponse<Void> a(String r16, double r17, double r19, String r21, String r22) {
            Intrinsics.checkNotNullParameter(r16, "locationType");
            Intrinsics.checkNotNullParameter(r21, ActivityLifecycle.NAME);
            Intrinsics.checkNotNullParameter(r22, MemoryListActivity.JUMP_FROM_DETAIL);
            String r2 = ContextAwarenessService.c(this.f8493a);
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), ContextAwarenessService.b(this.f8493a), "calling package " + r2 + " setLocation " + r16, false, 4, null);
            if (UserSettings.INSTANCE.hasAgreePrivacy() == true) goto L7;
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), ContextAwarenessService.b(this.f8493a), "privacy not allowed for package " + r2 + " setLocation " + r16, null, 4, null);
            return new MemoryResponse(403, "memorydata privacy not allowed", null);
        L7:
            if (ak.f13164a.f("android.permission.ACCESS_FINE_LOCATION") == true) goto L11;
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), ContextAwarenessService.b(this.f8493a), "no permission android.permission.ACCESS_FINE_LOCATION for package " + r2 + " setLocation " + r16, null, 4, null);
            return new MemoryResponse(402, "no permission android.permission.ACCESS_FINE_LOCATION", null);
        L11:
            if (ContextAwarenessService.a(this.f8493a, r16, r17, r19, r21, r22) == false) goto L13;
            Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L16
            b r4 = (b) ZeusTransformUtils.preCheckCast(this, b.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L16
            Object r0 = Result.m1421constructorimpl(Boolean.valueOf(CommonAddressManager.INSTANCE.setLocation(r16, r17, r19, StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r21, CharSequence.class, "com.obric.memorydata.plugin")).toString(), StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r22, CharSequence.class, "com.obric.memorydata.plugin")).toString())));     // Catch: Throwable -> L16
        L18:
            ContextAwarenessService r1 = this.f8493a;
            Throwable r5 = Result.m1424exceptionOrNullimpl(r0);
            if (r5 == null) goto L23;
            IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), ContextAwarenessService.b(r1), "setLocation failed: " + r5.getMessage(), null, 4, null);
            r0 = false;
        L23:
            if (((Boolean) ZeusTransformUtils.preCheckCast(r0, Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L26;
            return MemoryResponse.CREATOR.a();
        L26:
            return new MemoryResponse(400, "setLocation failed", null);
        L16:
            th = move-exception;
            Result.Companion r6 = Result.Companion;
            r0 = Result.m1421constructorimpl(ResultKt.createFailure(th));
            goto L18
        L13:
            return new MemoryResponse(405, "setLocation params is invalid", null);
        }

        @Override // com.obric.memorydata.sdk.awareness.c
        public MemoryResponse<?> a(String r11, com.obric.memorydata.sdk.awareness.d r12) {
            com.obric.memorydata.sdk.awareness.d r13 = (com.obric.memorydata.sdk.awareness.d) ZeusTransformUtils.wrapperContextForParams(r12, com.obric.memorydata.sdk.awareness.d.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r11, "event");
            Intrinsics.checkNotNullParameter(r13, "listener");
            IBinder r0 = r13.asBinder();
            String r2 = ContextAwarenessService.c(this.f8493a);
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), ContextAwarenessService.b(this.f8493a), "calling package " + r2 + " registerEvent " + r11, false, 4, null);
            if (UserSettings.INSTANCE.hasAgreePrivacy() == true) goto L7;
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), ContextAwarenessService.b(this.f8493a), "privacy not allowed for package " + r2 + " event=" + r11, null, 4, null);
            return new MemoryResponse(403, "memorydata privacy not allowed", null);
        L7:
            if (ContextAwarenessService.e(this.f8493a).containsKey(r0) == false) goto L10;
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), ContextAwarenessService.b(this.f8493a), "duplicate registerEvent, skip: event=" + r11, false, 4, null);
            return MemoryResponse.CREATOR.a();
        L10:
            a r3 = new a(this.f8493a, r2, r13);
            ((Map) ZeusTransformUtils.preCheckCast(ContextAwarenessService.e(this.f8493a), Map.class, "com.obric.memorydata.plugin")).put(r0, r3);
            AwarenessManager.INSTANCE.registerAwarenessEvent(r11, (com.obric.memorydata.awareness.api.a) ZeusTransformUtils.preCheckCast(r3, com.obric.memorydata.awareness.api.a.class, "com.obric.memorydata.plugin"));
            return MemoryResponse.CREATOR.a();
        }

        @Override // com.obric.memorydata.sdk.awareness.c
        public MemoryResponse<?> a(String r11, e r12) {
            e r13 = (e) ZeusTransformUtils.wrapperContextForParams(r12, e.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r11, "featureName");
            Intrinsics.checkNotNullParameter(r13, "listener");
            IBinder r0 = r13.asBinder();
            String r2 = ContextAwarenessService.c(this.f8493a);
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), ContextAwarenessService.b(this.f8493a), "calling package " + r2 + " registerFeature " + r11, false, 4, null);
            if (UserSettings.INSTANCE.hasAgreePrivacy() == true) goto L6;
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), ContextAwarenessService.b(this.f8493a), "privacy not allowed for package " + r2 + " feature=" + r11, null, 4, null);
            return new MemoryResponse(403, "memorydata privacy not allowed", null);
        L6:
            MemoryResponse<?> r3 = ContextAwarenessService.a(this.f8493a, r2, r11);
            if (r3 == null) goto L10;
            return r3;
        L10:
            if (ContextAwarenessService.d(this.f8493a).containsKey(r0) == false) goto L13;
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), ContextAwarenessService.b(this.f8493a), "duplicate registerFeature, skip: feature=" + r11, false, 4, null);
            return MemoryResponse.CREATOR.a();
        L13:
            C0429b r4 = new C0429b(r2, this.f8493a, r13);
            ((Map) ZeusTransformUtils.preCheckCast(ContextAwarenessService.d(this.f8493a), Map.class, "com.obric.memorydata.plugin")).put(r0, r4);
            AwarenessManager.INSTANCE.registerAwarenessEvent(r11, (com.obric.memorydata.awareness.api.a) ZeusTransformUtils.preCheckCast(r4, com.obric.memorydata.awareness.api.a.class, "com.obric.memorydata.plugin"));
            if (r2 == null) goto L17;
            ConcurrentHashMap r10 = ContextAwarenessService.a(this.f8493a);
            final $$Lambda$ContextAwarenessService$b$db3wKnowOiK4mXbU9gIU_Hp8OM r14 = $$Lambda$ContextAwarenessService$b$db3wKnowOiK4mXbU9gIU_Hp8OM.INSTANCE;
            Object r15 = r10.computeIfAbsent(r2, new $$Lambda$ContextAwarenessService$b$6qXqlwUyrGh4FyBG1vc2NcyIGYY(r14));
            Intrinsics.checkNotNullExpressionValue(r15, "computeIfAbsent(...)");
            ((Set) ZeusTransformUtils.preCheckCast(r15, Set.class, "com.obric.memorydata.plugin")).add(r11);
        L17:
            return MemoryResponse.CREATOR.a();
        }

        @Override // com.obric.memorydata.sdk.awareness.c
        public MemoryResponse<?> a(final String r19, final String r20, final long r21, boolean r23, f r24) {
            final f r13 = (f) ZeusTransformUtils.wrapperContextForParams(r24, f.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r19, "featureName");
            Intrinsics.checkNotNullParameter(r20, "targetFeatureValue");
            Intrinsics.checkNotNullParameter(r13, "listener");
            String r14 = ContextAwarenessService.c(this.f8493a);
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), ContextAwarenessService.b(this.f8493a), "calling package " + r14 + " registerFeatureDuration feature=" + r19 + " target=" + r20 + " duration=" + r21, false, 4, null);
            if (UserSettings.INSTANCE.hasAgreePrivacy() == true) goto L7;
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), ContextAwarenessService.b(this.f8493a), "privacy not allowed for package " + r14 + " featureDuration=" + r19, null, 4, null);
            return new MemoryResponse(403, "memorydata privacy not allowed", null);
        L7:
            if (r21 > 0) goto L10;
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), ContextAwarenessService.b(this.f8493a), "registerFeatureDuration invalid duration=" + r21, null, 4, null);
            return new MemoryResponse(405, "durationSec must be greater than 0", null);
        L10:
            MemoryResponse<?> r1 = ContextAwarenessService.a(this.f8493a, r14, r19);
            if (r1 == null) goto L13;
            return r1;
        L13:
            MemoryResponse<?> r2 = a(r19, FeatureManager.INSTANCE.getFeature(r19), r20);
            if (r2 == null) goto L16;
            return r2;
        L16:
            IBinder r3 = r13.asBinder();
            Intrinsics.checkNotNullExpressionValue(r3, "asBinder(...)");
            a r15 = new a(r3, r19, r20, r21, r23);
            if (ContextAwarenessService.f(this.f8493a).containsKey(r15) == false) goto L20;
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), ContextAwarenessService.b(this.f8493a), "duplicate registerFeatureDuration, skip: key=" + r15, false, 4, null);
            return MemoryResponse.CREATOR.a();
        L20:
            StringBuilder r4 = new StringBuilder().append("sdk:");
            if (r14 != null) goto L23;
            String r5 = "unknown";
        L24:
            String r6 = r4.append(r5).append(':').append(r13.asBinder().hashCode()).append(':').append(r19).append(':').append(r20).append(':').append(r21).append(':').append(r23).toString();
            ((Map) ZeusTransformUtils.preCheckCast(ContextAwarenessService.f(this.f8493a), Map.class, "com.obric.memorydata.plugin")).put(r15, r6);
            k r16 = k.f8704a;
            final ContextAwarenessService r7 = this.f8493a;
            r16.a(r6, CollectionsKt.listOf(new k.b(r19, r20, r21, r23, new $$Lambda$ContextAwarenessService$b$ix0517rLB2obRWv6fa_I5_qes(r7, r19, r20, r21, r13))));
            if (r14 == null) goto L28;
            ConcurrentHashMap r0 = ContextAwarenessService.a(this.f8493a);
            final $$Lambda$ContextAwarenessService$b$J7RsFQNzNZE5kjdDzBmPAfmmEjA r8 = $$Lambda$ContextAwarenessService$b$J7RsFQNzNZE5kjdDzBmPAfmmEjA.INSTANCE;
            Object r9 = r0.computeIfAbsent(r14, new $$Lambda$ContextAwarenessService$b$4HH2UaqHMuaoBbUOQyz6Lr1BiLk(r8));
            Intrinsics.checkNotNullExpressionValue(r9, "computeIfAbsent(...)");
            ((Set) ZeusTransformUtils.preCheckCast(r9, Set.class, "com.obric.memorydata.plugin")).add(r19);
        L28:
            return MemoryResponse.CREATOR.a();
        L23:
            r5 = r14;
            goto L24
        }

        @Override // com.obric.memorydata.sdk.awareness.c
        public MemoryResponse<Location> b(String r19) {
            Intrinsics.checkNotNullParameter(r19, "locationFeature");
            String r2 = ContextAwarenessService.c(this.f8493a);
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), ContextAwarenessService.b(this.f8493a), "calling package " + r2 + " getLocation " + r19, false, 4, null);
            String r6 = null;
            if (UserSettings.INSTANCE.hasAgreePrivacy() == true) goto L7;
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), ContextAwarenessService.b(this.f8493a), "privacy not allowed for package " + r2 + " getLocation " + r19, null, 4, null);
            return new MemoryResponse(403, "memorydata privacy not allowed", null);
        L7:
            if (ak.f13164a.f("android.permission.ACCESS_FINE_LOCATION") == true) goto L10;
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), ContextAwarenessService.b(this.f8493a), "no permission android.permission.ACCESS_FINE_LOCATION for package " + r2 + " getLocation " + r19, null, 4, null);
            return new MemoryResponse(402, "no permission android.permission.ACCESS_FINE_LOCATION", null);
        L10:
            Object r3 = FeatureManager.INSTANCE.getFeature(r19);
            if (r3 != null) goto L13;
        L65:
            IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), ContextAwarenessService.b(this.f8493a), "invalid location data: feature=" + r19 + " value=" + r3, null, 4, null);
            return new MemoryResponse(405, "location data is invalid " + r3, null);
        L13:
            if (ZeusTransformUtils.instanceOf(r3, List.class) == false) goto L65;
            if (((List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.memorydata.plugin")).size() != 2) goto L65;
            Object r4 = ((List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.memorydata.plugin")).get(0);
            Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type kotlin.Double");
            double r8 = ((Double) ZeusTransformUtils.preCheckCast(r4, Double.class, "com.obric.memorydata.plugin")).doubleValue();
            Object r5 = ((List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.memorydata.plugin")).get(1);
            Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type kotlin.Double");
            double r10 = ((Double) ZeusTransformUtils.preCheckCast(r5, Double.class, "com.obric.memorydata.plugin")).doubleValue();
            Location r7 = new Location("gps");
            r7.setLongitude(r8);
            r7.setLatitude(r10);
            if (Intrinsics.areEqual(r19, "location_home_gps") == false) goto L19;
            String r1 = "家";
        L21:
            if (com.obric.memorydata.address.a.f8427a.a() == false) goto L34;
            AddressInfo r9 = CommonAddressManager.INSTANCE.getAutoLearnAddress(r1);
            if (r9 == null) goto L34;
            if (com.obric.memorydata.memory.api.model.a.a(r9) == true) goto L27;
        L31:
            boolean r14 = false;
        L32:
            if (r14 == false) goto L34;
        L35:
            Iterator r11 = ((Iterable) ZeusTransformUtils.preCheckCast(CommonAddressManager.INSTANCE.getAddressList(r1), Iterable.class, "com.obric.memorydata.plugin")).iterator();
        L37:
            if (r11.hasNext() == false) goto L48;
            Object r15 = r11.next();
            AddressInfo r16 = (AddressInfo) ZeusTransformUtils.preCheckCast(r15, AddressInfo.class, "com.obric.memorydata.plugin");
            if (r16.isSelect() == true) goto L41;
        L45:
            boolean r17 = false;
        L46:
            if (r17 == false) goto L37;
        L49:
            AddressInfo r12 = (AddressInfo) ZeusTransformUtils.preCheckCast(r15, AddressInfo.class, "com.obric.memorydata.plugin");
            if (r9 != null) goto L52;
            r9 = r12;
        L52:
            if (r9 == null) goto L55;
            String r13 = r9.getDetail() + r9.getName();
            if (r13 == null) goto L55;
        L56:
            RunLog.INSTANCE.debug(ContextAwarenessService.b(this.f8493a), "address: " + r13);
            Bundle r0 = new Bundle();
            r0.putString(MemoryKeyInfoEntity.KEY_ADDRESS, r13);
            if (r9 == null) goto L59;
            String r18 = r9.getName();
        L60:
            r0.putString(ActivityLifecycle.NAME, r18);
            if (r9 == null) goto L63;
            r6 = r9.getDetail();
        L63:
            r0.putString(MemoryListActivity.JUMP_FROM_DETAIL, r6);
            r7.setExtras(r0);
            return new MemoryResponse(0, "success", r7);
        L59:
            r18 = null;
        L55:
            b r20 = (b) ZeusTransformUtils.preCheckCast(this, b.class, "com.obric.memorydata.plugin");
            r13 = LocationProcessor.INSTANCE.getAddressByGps(r7.getLongitude(), r7.getLatitude());
            goto L56
        L41:
            if (Math.abs(r16.getLongitude() - r8) > 1.0E-4d) goto L45;
            if (Math.abs(r16.getLatitude() - r10) > 1.0E-4d) goto L45;
            r17 = true;
            goto L46
        L48:
            r15 = null;
            goto L49
        L27:
            if (Math.abs(r9.getLongitude() - r8) > 1.0E-4d) goto L31;
            if (Math.abs(r9.getLatitude() - r10) > 1.0E-4d) goto L31;
            r14 = true;
        L34:
            r9 = null;
            goto L35
        L19:
            r1 = "公司";
            goto L21
        }

        @Override // com.obric.memorydata.sdk.awareness.c
        public MemoryResponse<?> b(String r10, e r11) {
            e r12 = (e) ZeusTransformUtils.wrapperContextForParams(r11, e.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r10, "featureName");
            Intrinsics.checkNotNullParameter(r12, "listener");
            IBinder r13 = r12.asBinder();
            String r0 = ContextAwarenessService.c(this.f8493a);
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), ContextAwarenessService.b(this.f8493a), "calling package " + r0 + " unregisterFeature " + r10, false, 4, null);
            if (UserSettings.INSTANCE.hasAgreePrivacy() == true) goto L6;
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), ContextAwarenessService.b(this.f8493a), "privacy not allowed for package " + r0 + " feature=" + r10, null, 4, null);
            return new MemoryResponse(403, "memorydata privacy not allowed", null);
        L6:
            com.obric.memorydata.awareness.api.a r14 = (com.obric.memorydata.awareness.api.a) ZeusTransformUtils.preCheckCast(ContextAwarenessService.d(this.f8493a).remove(r13), com.obric.memorydata.awareness.api.a.class, "com.obric.memorydata.plugin");
            if (r14 == null) goto L9;
            AwarenessManager.INSTANCE.unregisterAwarenessEvent(r10, r14);
        L9:
            if (r0 == null) goto L16;
            ContextAwarenessService r9 = this.f8493a;
            Set r15 = (Set) ZeusTransformUtils.preCheckCast(ContextAwarenessService.a(r9).get(r0), Set.class, "com.obric.memorydata.plugin");
            if (r15 == null) goto L16;
            r15.remove(r10);
            if (r15.isEmpty() == false) goto L16;
            ContextAwarenessService.a(r9).remove(r0);
        L16:
            return MemoryResponse.CREATOR.a();
        }

        @Override // com.obric.memorydata.sdk.awareness.c
        public MemoryResponse<?> b(String r18, String r19, long r20, boolean r22, f r23) {
            f r1 = (f) ZeusTransformUtils.wrapperContextForParams(r23, f.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r18, "featureName");
            Intrinsics.checkNotNullParameter(r19, "targetFeatureValue");
            Intrinsics.checkNotNullParameter(r1, "listener");
            String r10 = ContextAwarenessService.c(this.f8493a);
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), ContextAwarenessService.b(this.f8493a), "calling package " + r10 + " unregisterFeatureDuration feature=" + r18 + " target=" + r19 + " duration=" + r20, false, 4, null);
            if (UserSettings.INSTANCE.hasAgreePrivacy() == true) goto L6;
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), ContextAwarenessService.b(this.f8493a), "privacy not allowed for package " + r10 + " featureDuration=" + r18, null, 4, null);
            return new MemoryResponse(403, "memorydata privacy not allowed", null);
        L6:
            IBinder r2 = r1.asBinder();
            Intrinsics.checkNotNullExpressionValue(r2, "asBinder(...)");
            String r3 = (String) ZeusTransformUtils.preCheckCast(ContextAwarenessService.f(this.f8493a).remove(new a(r2, r18, r19, r20, r22)), String.class, "com.obric.memorydata.plugin");
            if (r3 == null) goto L9;
            k.f8704a.a(r3);
        L9:
            if (r10 == null) goto L16;
            ContextAwarenessService r0 = this.f8493a;
            Set r4 = (Set) ZeusTransformUtils.preCheckCast(ContextAwarenessService.a(r0).get(r10), Set.class, "com.obric.memorydata.plugin");
            if (r4 == null) goto L16;
            r4.remove(r18);
            if (r4.isEmpty() == false) goto L16;
            ContextAwarenessService.a(r0).remove(r10);
        L16:
            return MemoryResponse.CREATOR.a();
        }

        @Override // com.obric.memorydata.sdk.awareness.c
        public MemoryResponse<Integer> c(String r11) {
            Intrinsics.checkNotNullParameter(r11, "fenceId");
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), ContextAwarenessService.b(this.f8493a), "calling package " + ContextAwarenessService.c(this.f8493a) + " getGeoFenceStatus " + r11, false, 4, null);
            if (UserSettings.INSTANCE.hasAgreePrivacy() == true) goto L7;
            return new MemoryResponse(403, "memorydata privacy not allowed", null);
        L7:
            if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.memorydata.plugin")) == true) goto L18;
            if (Intrinsics.areEqual(r11, StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.memorydata.plugin")).toString()) == false) goto L18;
            if (ak.f13164a.f("android.permission.ACCESS_FINE_LOCATION") == true) goto L16;
            return new MemoryResponse(402, "no permission android.permission.ACCESS_FINE_LOCATION", null);
        L16:
            return (MemoryResponse) ZeusTransformUtils.preCheckCast(i.a(null, (Function2) ZeusTransformUtils.preCheckCast(new ContextAwarenessService$binder$1$getGeoFenceStatus$1(r11, null), Function2.class, "com.obric.memorydata.plugin"), 1, null), MemoryResponse.class, "com.obric.memorydata.plugin");
        L18:
            return new MemoryResponse(405, "fenceId is invalid", null);
        }

        @Override // com.obric.memorydata.sdk.awareness.c.a, android.os.Binder
        public boolean onTransact(int r7, Parcel r8, Parcel r9, int r10) {
            Intrinsics.checkNotNullParameter(r8, "data");
            if (ak.f13164a.a() == false) goto L7;
            IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), ContextAwarenessService.b(this.f8493a), "refuse unknown app call", null, 4, null);
            return false;
        L7:
            return super.onTransact(r7, r8, r9, r10);
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/obric/memorydata/awareness/ContextAwarenessService$registerFeatureDailyCallback$1", "Lcom/obric/memorydata/middleware/api/bdtracker/DailyReportCallback;", "onDailyReport", "", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class c implements com.obric.memorydata.middleware.api.bdtracker.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ContextAwarenessService f8499a;

        c(ContextAwarenessService r3) {
            this.f8499a = (ContextAwarenessService) ZeusTransformUtils.wrapperContextForParams(r3, ContextAwarenessService.class, "com.obric.memorydata.plugin");
        }

        @Override // com.obric.memorydata.middleware.api.bdtracker.a
        public void a() {
            Iterator r5 = ((Map) ZeusTransformUtils.preCheckCast(ContextAwarenessService.a(this.f8499a), Map.class, "com.obric.memorydata.plugin")).entrySet().iterator();
        L4:
            if (r5.hasNext() == false) goto L9;
            Map.Entry r0 = (Map.Entry) ZeusTransformUtils.preCheckCast(r5.next(), Map.Entry.class, "com.obric.memorydata.plugin");
            String r2 = (String) ZeusTransformUtils.preCheckCast(r0.getKey(), String.class, "com.obric.memorydata.plugin");
            Iterator r1 = ((Iterable) ZeusTransformUtils.preCheckCast((Set) ZeusTransformUtils.preCheckCast(r0.getValue(), Set.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin")).iterator();
        L7:
            if (r1.hasNext() == false) goto L4;
            String r3 = (String) ZeusTransformUtils.preCheckCast(r1.next(), String.class, "com.obric.memorydata.plugin");
            com.obric.memorydata.awareness.a.f8503a.a(r3, r2);
            goto L7
        }
    }

    public ContextAwarenessService() {
        this.f8489a = "ContextAwarenessService";
        this.f8490b = new ConcurrentHashMap();
        this.c = new ConcurrentHashMap();
        this.d = new ConcurrentHashMap();
        this.e = new ConcurrentHashMap();
        this.f = new AtomicBoolean(false);
        this.g = new c(this);
        this.h = MapsKt.mapOf(new Pair[]{TuplesKt.to("current_location_type", "android.permission.ACCESS_FINE_LOCATION"), TuplesKt.to("current_location_info", "android.permission.ACCESS_FINE_LOCATION"), TuplesKt.to("current_geofences", "android.permission.ACCESS_FINE_LOCATION")});
        this.i = new b(this);
    }

    public static final /* synthetic */ MemoryResponse a(ContextAwarenessService r2, String r3, String r4) {
        return ((ContextAwarenessService) ZeusTransformUtils.wrapperContextForParams(r2, ContextAwarenessService.class, "com.obric.memorydata.plugin")).a(r3, r4);
    }

    private final MemoryResponse<?> a(String r9, String r10) {
        String r11 = (String) ZeusTransformUtils.preCheckCast(this.h.get(r10), String.class, "com.obric.memorydata.plugin");
        if (r11 != null) goto L6;
        return null;
    L6:
        if (ak.f13164a.f(r11) == false) goto L8;
        return null;
    L8:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), this.f8489a, "calling package " + r9 + " no permission " + r11, null, 4, null);
        return new MemoryResponse(402, "no permission " + r11, null);
    }

    private final String a() {
        int r3 = Binder.getCallingUid();
        String[] r4 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getPackageManager().getPackagesForUid(r3);
        if (r4 != null) goto L7;
        return null;
    L7:
        return (String) ZeusTransformUtils.preCheckCast(ArraysKt.getOrNull(r4, 0), String.class, "com.obric.memorydata.plugin");
    }

    public static final /* synthetic */ ConcurrentHashMap a(ContextAwarenessService r2) {
        return ((ContextAwarenessService) ZeusTransformUtils.wrapperContextForParams(r2, ContextAwarenessService.class, "com.obric.memorydata.plugin")).e;
    }

    public static final /* synthetic */ boolean a(ContextAwarenessService r8, String r9, double r10, double r12, String r14, String r15) {
        return ((ContextAwarenessService) ZeusTransformUtils.wrapperContextForParams(r8, ContextAwarenessService.class, "com.obric.memorydata.plugin")).a(r9, r10, r12, r14, r15);
    }

    private final boolean a(String r2, double r3, double r5, String r7, String r8) {
        if (Intrinsics.areEqual(r2, "home") == true) goto L8;
        if (Intrinsics.areEqual(r2, "company") == true) goto L8;
        return false;
    L8:
        if (Double.isNaN(r3) == false) goto L10;
        return false;
    L10:
        if (Double.isInfinite(r3) == false) goto L12;
        return false;
    L12:
        if (Double.isNaN(r5) == false) goto L14;
        return false;
    L14:
        if (Double.isInfinite(r5) == false) goto L17;
        return false;
    L17:
        if (r3 >= (-180.0d)) goto L19;
        return false;
    L19:
        if (r3 <= 180.0d) goto L21;
        return false;
    L21:
        if (r5 >= (-90.0d)) goto L23;
        return false;
    L23:
        if (r5 <= 90.0d) goto L26;
        return false;
    L26:
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L28;
        return false;
    L28:
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L30;
        return false;
    L30:
        return true;
    }

    public static final /* synthetic */ String b(ContextAwarenessService r2) {
        return ((ContextAwarenessService) ZeusTransformUtils.wrapperContextForParams(r2, ContextAwarenessService.class, "com.obric.memorydata.plugin")).f8489a;
    }

    public static final /* synthetic */ String c(ContextAwarenessService r2) {
        return ((ContextAwarenessService) ZeusTransformUtils.wrapperContextForParams(r2, ContextAwarenessService.class, "com.obric.memorydata.plugin")).a();
    }

    public static final /* synthetic */ ConcurrentHashMap d(ContextAwarenessService r2) {
        return ((ContextAwarenessService) ZeusTransformUtils.wrapperContextForParams(r2, ContextAwarenessService.class, "com.obric.memorydata.plugin")).f8490b;
    }

    public static final /* synthetic */ ConcurrentHashMap e(ContextAwarenessService r2) {
        return ((ContextAwarenessService) ZeusTransformUtils.wrapperContextForParams(r2, ContextAwarenessService.class, "com.obric.memorydata.plugin")).c;
    }

    public static final /* synthetic */ ConcurrentHashMap f(ContextAwarenessService r2) {
        return ((ContextAwarenessService) ZeusTransformUtils.wrapperContextForParams(r2, ContextAwarenessService.class, "com.obric.memorydata.plugin")).d;
    }

    public IBinder onBind(Intent r4) {
        if (this.f.compareAndSet(false, true) == false) goto L6;
        Tracker.INSTANCE.registerDailyReportCallback((com.obric.memorydata.middleware.api.bdtracker.a) ZeusTransformUtils.preCheckCast(this.g, com.obric.memorydata.middleware.api.bdtracker.a.class, "com.obric.memorydata.plugin"));
    L6:
        return (IBinder) ZeusTransformUtils.preCheckCast(this.i, IBinder.class, "com.obric.memorydata.plugin");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean onUnbind(Intent r8) {
        if (this.f.get() == false) goto L5;
        Tracker.INSTANCE.unregisterDailyReportCallback((com.obric.memorydata.middleware.api.bdtracker.a) ZeusTransformUtils.preCheckCast(this.g, com.obric.memorydata.middleware.api.bdtracker.a.class, "com.obric.memorydata.plugin"));
        this.f.set(false);
    L5:
        this.e.clear();
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), this.f8489a, "unregister daily report callback on service unbind", false, 4, null);
        return super/*android.app.Service*/.onUnbind(r8);
    }
}
