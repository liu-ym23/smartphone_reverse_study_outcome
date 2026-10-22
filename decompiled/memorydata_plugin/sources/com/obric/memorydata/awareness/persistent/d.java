package com.obric.memorydata.awareness.persistent;

import android.content.Context;
import android.os.Binder;
import android.os.Bundle;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.crash.entity.EventBody;
import com.obric.capabilitykit.common.Ext;
import com.obric.memorydata.awareness.api.FeatureManager;
import com.obric.memorydata.awareness.cae.DualBoundaryGeofence;
import com.obric.memorydata.middleware.api.app.UserSettings;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.sdk.MemoryResponse;
import com.obric.memorydata.sdk.awareness.AwarenessConditionConfig;
import com.obric.memorydata.sdk.awareness.AwarenessConditionRule;
import com.obric.memorydata.sdk.awareness.AwarenessEventData;
import com.obric.memorydata.sdk.awareness.EventNames;
import com.obric.memorydata.sdk.awareness.GeoFenceRequest;
import com.obric.memorydata.sdk.awareness.PersistentAwarenessRegisterRequest;
import com.obric.memorydata.utils.ak;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\tJ\u0012\u0010\u000e\u001a\u00020\t2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0002J\"\u0010\u0011\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u0005H\u0002J\u001a\u0010\u0015\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0016H\u0002J\u001a\u0010\u0017\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\tH\u0002J\u001a\u0010\u0018\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\tH\u0002J\u0010\u0010\u0019\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u001a\u0010\u001a\u001a\u0004\u0018\u00010\t2\u0006\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u001a\u0010\u001a\u001a\u0004\u0018\u00010\t2\u0006\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u0005H\u0002J\u0012\u0010\u001d\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0010\u0010 \u001a\u00020\u001f2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0012\u0010!\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0012\u001a\u00020\u0016H\u0002J\u0010\u0010\"\u001a\u00020\u001f2\u0006\u0010#\u001a\u00020$H\u0002J\u0010\u0010%\u001a\u00020\u001f2\u0006\u0010#\u001a\u00020$H\u0002J\u0014\u0010&\u001a\u0004\u0018\u00010\u00132\b\u0010\r\u001a\u0004\u0018\u00010\tH\u0002J\u0014\u0010'\u001a\u0004\u0018\u00010\u00162\b\u0010\r\u001a\u0004\u0018\u00010\tH\u0002J\u0014\u0010(\u001a\u0004\u0018\u00010\u00102\b\u0010\r\u001a\u0004\u0018\u00010\tH\u0002J\u0012\u0010)\u001a\u0004\u0018\u00010\u00052\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0018\u0010*\u001a\u00020\t2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\u0005H\u0002J\u0010\u0010.\u001a\u00020\t*\u0006\u0012\u0002\b\u00030/H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00060"}, d2 = {"Lcom/obric/memorydata/awareness/persistent/PersistentAwarenessCallHandler;", "", "<init>", "()V", "TAG", "", "featurePermission", "", "handle", "Landroid/os/Bundle;", "context", "Landroid/content/Context;", "method", "extras", "reportAwarenessEvent", "data", "Lcom/obric/memorydata/sdk/awareness/AwarenessEventData;", "register", Ext.KEY_REQUEST, "Lcom/obric/memorydata/sdk/awareness/PersistentAwarenessRegisterRequest;", "expectedType", "addGeoFence", "Lcom/obric/memorydata/sdk/awareness/GeoFenceRequest;", "removeGeoFence", "unregister", "clearAllForCaller", "validatePermission", "ownerPackage", "permission", "validateParams", "isGeoFenceIdCondition", "", "initialLastMatched", "validateGeoFenceRequest", "isValidLongitude", EventBody.KEY_VALUE, "", "isValidLatitude", "readRegister", "readGeoFenceRequest", "readAwarenessEvent", "getCallPackage", "result", "code", "", "message", "toResultBundle", "Lcom/obric/memorydata/sdk/MemoryResponse;", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f8768a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Map<String, String> f8769b = null;

    static {
        f8768a = new d();
        f8769b = MapsKt.mapOf(new Pair[]{TuplesKt.to("current_location_type", "android.permission.ACCESS_FINE_LOCATION"), TuplesKt.to("current_location_info", "android.permission.ACCESS_FINE_LOCATION"), TuplesKt.to("current_geofences", "android.permission.ACCESS_FINE_LOCATION")});
    }

    private d() {
    }

    private final Bundle a(int r1, String r2) {
        return com.obric.memorydata.sdk.awareness.g.f12826a.a(r1, r2);
    }

    private final Bundle a(Context r9) {
        Context r10 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin");
        String r0 = b(r10);
        if (r0 != null) goto L7;
        return a(402, "calling package is unknown");
    L7:
        if (UserSettings.INSTANCE.hasAgreePrivacy() == true) goto L10;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "PersistentAwarenessCallHandler", "privacy not allowed for clear owner=" + r0, null, 4, null);
        return a(403, "memorydata privacy not allowed");
    L10:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "PersistentAwarenessCallHandler", "clear persistent request owner=" + r0, false, 4, null);
        return a(g.f8772a.a(r10, r0));
    }

    private final Bundle a(Context r8, Bundle r9) {
        Context r10 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.memorydata.plugin");
        if (r9 == null) goto L7;
        String r11 = r9.getString("fence_id");
        if (r11 == null) goto L7;
        String r12 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.memorydata.plugin")).toString();
    L8:
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(r12, CharSequence.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L11;
    L14:
        boolean r1 = true;
    L16:
        if (r1 == false) goto L20;
        return a(405, "fenceId is missing");
    L20:
        if (DualBoundaryGeofence.f8549a.e(r12) == false) goto L24;
        return a(405, "fenceId uses reserved prefix");
    L24:
        if (UserSettings.INSTANCE.hasAgreePrivacy() == false) goto L26;
        String r13 = b(r10);
        if (r13 == null) goto L30;
        Bundle r2 = a(r13, "android.permission.ACCESS_FINE_LOCATION");
        if (r2 == null) goto L34;
        return r2;
    L34:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "PersistentAwarenessCallHandler", "remove geofence request owner=" + r13 + " fenceId=" + r12, false, 4, null);
        return a(g.f8772a.a(r12));
    L30:
        return a(402, "calling package is unknown");
    L26:
        return a(403, "memorydata privacy not allowed");
    L11:
        if (r0.length() == 0) goto L14;
        r1 = false;
    L7:
        r12 = null;
        goto L8
    }

    private final Bundle a(Context r8, GeoFenceRequest r9) {
        Context r10 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.memorydata.plugin");
        if (r9 == null) goto L5;
        Bundle r0 = a(r9);
        if (r0 == null) goto L10;
        return r0;
    L10:
        if (UserSettings.INSTANCE.hasAgreePrivacy() == false) goto L12;
        String r11 = b(r10);
        if (r11 == null) goto L16;
        Bundle r1 = a(r11, "android.permission.ACCESS_FINE_LOCATION");
        if (r1 == null) goto L20;
        return r1;
    L20:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "PersistentAwarenessCallHandler", "add geofence request owner=" + r11 + " fenceId=" + r9.getFenceId(), false, 4, null);
        return a(g.f8772a.a(r9, r11));
    L16:
        return a(402, "calling package is unknown");
    L12:
        return a(403, "memorydata privacy not allowed");
    L5:
        return a(405, "geofence request is missing");
    }

    private final Bundle a(Context r10, PersistentAwarenessRegisterRequest r11, String r12) {
        Context r13 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.memorydata.plugin");
        if (r11 != null) goto L7;
        return a(405, "register request is missing");
    L7:
        if (Intrinsics.areEqual(r11.getTarget().getTargetType(), r12) == true) goto L11;
        return a(405, "target type mismatch");
    L11:
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r11.getSubscriptionId(), CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L15;
        return a(405, "subscriptionId is empty");
    L15:
        if (UserSettings.INSTANCE.hasAgreePrivacy() == false) goto L17;
        String r14 = b(r13);
        if (r14 == null) goto L21;
        Bundle r0 = a(r14, r11);
        if (r0 == null) goto L25;
        return r0;
    L25:
        Bundle r1 = a(r11);
        if (r1 == null) goto L28;
        return r1;
    L28:
        h r2 = new h(r14, r11.getSubscriptionId(), r11.getTarget().getTargetType(), r11.getTarget().getTargetName(), f.f8771a.a(r11.getCondition()), c(r11));
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "PersistentAwarenessCallHandler", "register persistent request owner=" + r14 + " subscriptionId=" + r11.getSubscriptionId() + " target=" + r11.getTarget().getTargetType() + '/' + r11.getTarget().getTargetName() + " condition=" + r2.e() + " lastMatched=" + r2.f(), false, 4, null);
        return a(g.f8772a.a(r13, r2));
    L21:
        return a(402, "calling package is unknown");
    L17:
        return a(403, "memorydata privacy not allowed");
    }

    private final Bundle a(MemoryResponse<?> r2) {
        return com.obric.memorydata.sdk.awareness.g.f12826a.a(r2.getCode(), r2.getMessage());
    }

    private final Bundle a(AwarenessEventData r8) {
        if (r8 != null) goto L6;
        return a(405, "awareness event is missing");
    L6:
        if (UserSettings.INSTANCE.hasAgreePrivacy() == false) goto L8;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "PersistentAwarenessCallHandler", "report awareness event key=" + r8.getKey(), false, 4, null);
        return a(c.f8766a.a(r8));
    L8:
        return a(403, "memorydata privacy not allowed");
    }

    private final Bundle a(GeoFenceRequest r5) {
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r5.getFenceId(), CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L8;
        String r6 = "fenceId is empty";
    L6:
        return a(405, r6);
    L8:
        if (DualBoundaryGeofence.f8549a.e(r5.getFenceId()) == false) goto L11;
        r6 = "fenceId uses reserved prefix";
        goto L6
    L11:
        if (a(r5.getLongitude()) == true) goto L14;
        r6 = "longitude is invalid";
        goto L6
    L14:
        if (b(r5.getLatitude()) == true) goto L17;
        r6 = "latitude is invalid";
        goto L6
    L17:
        if (r5.getRadius() > 0) goto L19;
        r6 = "radius must be greater than 0";
        goto L6
    L19:
        return null;
    }

    private final Bundle a(PersistentAwarenessRegisterRequest r6) {
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r6.getTarget().getTargetName(), CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L8;
        String r7 = "targetName is empty";
    L6:
        return a(405, r7);
    L8:
        if (Intrinsics.areEqual(r6.getTarget().getTargetType(), "event") == false) goto L21;
        if (r6.getCondition().isAlways() == true) goto L21;
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(r6.getCondition().getExtraKey(), CharSequence.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L14;
    L17:
        boolean r1 = true;
    L18:
        if (r1 == false) goto L21;
        r7 = "event condition extraKey is empty";
        goto L6
    L14:
        if (StringsKt.isBlank(r0) == true) goto L17;
        r1 = false;
    L21:
        if (Intrinsics.areEqual(r6.getTarget().getTargetType(), "event") == true) goto L23;
        return null;
    L23:
        if (EventNames.INSTANCE.isGeoFenceEvent(r6.getTarget().getTargetName()) == true) goto L25;
        return null;
    L25:
        if (b(r6) == true) goto L30;
        r7 = "geofence event condition must equal one fence_id";
        goto L6
    L30:
        return null;
    }

    private final Bundle a(String r4, PersistentAwarenessRegisterRequest r5) {
        if (Intrinsics.areEqual(r5.getTarget().getTargetType(), "feature") == false) goto L5;
        String r6 = (String) ZeusTransformUtils.preCheckCast(f8769b.get(r5.getTarget().getTargetName()), String.class, "com.obric.memorydata.plugin");
    L6:
        if (r6 != null) goto L9;
        return null;
    L9:
        return a(r4, r6);
    L5:
        r6 = null;
        goto L6
    }

    private final Bundle a(String r9, String r10) {
        if (ak.f13164a.a(r9, r10) == false) goto L5;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "PersistentAwarenessCallHandler", "permission granted owner=" + r9 + " permission=" + r10, false, 4, null);
        return null;
    L5:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "PersistentAwarenessCallHandler", "permission denied owner=" + r9 + " permission=" + r10, null, 4, null);
        return a(402, "no permission " + r10);
    }

    private final PersistentAwarenessRegisterRequest a(Bundle r3) {
        com.obric.memorydata.sdk.awareness.g r2 = com.obric.memorydata.sdk.awareness.g.f12826a;
        if (r3 != null) goto L7;
        return null;
    L7:
        return (PersistentAwarenessRegisterRequest) ZeusTransformUtils.preCheckCast(r2.a(r3, "register_request", PersistentAwarenessRegisterRequest.class), PersistentAwarenessRegisterRequest.class, "com.obric.memorydata.plugin");
    }

    private final boolean a(double r3) {
        if (Double.isNaN(r3) == false) goto L5;
    L11:
        return false;
    L5:
        if (Double.isInfinite(r3) == true) goto L11;
        if (r3 < (-180.0d)) goto L11;
        if (r3 > 180.0d) goto L11;
        return true;
    }

    private final Bundle b(Context r11, Bundle r12) {
        Context r13 = (Context) ZeusTransformUtils.wrapperContextForParams(r11, Context.class, "com.obric.memorydata.plugin");
        if (r12 == null) goto L5;
        String r14 = r12.getString("subscription_id");
    L6:
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(r14, CharSequence.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L9;
    L12:
        boolean r1 = true;
    L13:
        if (r1 == true) goto L15;
        String r2 = b(r13);
        if (r2 != null) goto L21;
        return a(402, "calling package is unknown");
    L21:
        if (UserSettings.INSTANCE.hasAgreePrivacy() == true) goto L24;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "PersistentAwarenessCallHandler", "privacy not allowed for unregister owner=" + r2 + " subscriptionId=" + r14, null, 4, null);
        return a(403, "memorydata privacy not allowed");
    L24:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "PersistentAwarenessCallHandler", "unregister persistent request owner=" + r2 + " subscriptionId=" + r14, false, 4, null);
        return a(g.f8772a.a(r13, r2, r14));
    L15:
        return a(405, "subscriptionId is missing");
    L9:
        if (StringsKt.isBlank(r0) == true) goto L12;
        r1 = false;
        goto L13
    L5:
        r14 = null;
        goto L6
    }

    private final GeoFenceRequest b(Bundle r3) {
        com.obric.memorydata.sdk.awareness.g r2 = com.obric.memorydata.sdk.awareness.g.f12826a;
        if (r3 != null) goto L7;
        return null;
    L7:
        return (GeoFenceRequest) ZeusTransformUtils.preCheckCast(r2.a(r3, "geofence_request", GeoFenceRequest.class), GeoFenceRequest.class, "com.obric.memorydata.plugin");
    }

    private final String b(Context r12) {
        Context r11 = (Context) ZeusTransformUtils.wrapperContextForParams(r12, Context.class, "com.obric.memorydata.plugin");
        int r13 = Binder.getCallingUid();
        String[] r1 = r11.getPackageManager().getPackagesForUid(r13);
        String r14 = null;
        if (r1 == null) goto L5;
        String r10 = (String) ZeusTransformUtils.preCheckCast(ArraysKt.getOrNull(r1, 0), String.class, "com.obric.memorydata.plugin");
    L6:
        IRunLog r0 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r15 = new StringBuilder().append("getCallPackage uid=").append(r13).append(" package=").append(r10).append(" packages=");
        if (r1 == null) goto L9;
        r14 = ArraysKt.joinToString$default(r1, null, null, null, 0, null, null, 63, null);
    L9:
        IRunLog.a.a(r0, "PersistentAwarenessCallHandler", r15.append(r14).toString(), false, 4, null);
        return r10;
    L5:
        r10 = null;
        goto L6
    }

    private final boolean b(double r3) {
        if (Double.isNaN(r3) == false) goto L5;
    L11:
        return false;
    L5:
        if (Double.isInfinite(r3) == true) goto L11;
        if (r3 < (-90.0d)) goto L11;
        if (r3 > 90.0d) goto L11;
        return true;
    }

    private final boolean b(PersistentAwarenessRegisterRequest r6) {
        AwarenessConditionConfig r5 = r6.getCondition();
        AwarenessConditionRule r7 = (AwarenessConditionRule) ZeusTransformUtils.preCheckCast(CollectionsKt.singleOrNull((List) ZeusTransformUtils.preCheckCast(r5.getRules(), List.class, "com.obric.memorydata.plugin")), AwarenessConditionRule.class, "com.obric.memorydata.plugin");
        if (r7 != null) goto L5;
        return false;
    L5:
        String r2 = (String) ZeusTransformUtils.preCheckCast(CollectionsKt.singleOrNull((List) ZeusTransformUtils.preCheckCast(r7.getValues(), List.class, "com.obric.memorydata.plugin")), String.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(r5.getExtraKey(), "fence_id") == true) goto L11;
        return false;
    L11:
        if (Intrinsics.areEqual(r5.getValueType(), TypedValues.Custom.S_STRING) == true) goto L13;
        return false;
    L13:
        if (Intrinsics.areEqual(r7.getOperator(), "eq") == true) goto L15;
        return false;
    L15:
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L17;
        return false;
    L17:
        if (Intrinsics.areEqual(r2, StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin")).toString()) == true) goto L19;
        return false;
    L19:
        return true;
    }

    private final AwarenessEventData c(Bundle r3) {
        com.obric.memorydata.sdk.awareness.g r2 = com.obric.memorydata.sdk.awareness.g.f12826a;
        if (r3 != null) goto L7;
        return null;
    L7:
        return (AwarenessEventData) ZeusTransformUtils.preCheckCast(r2.a(r3, "awareness_event", AwarenessEventData.class), AwarenessEventData.class, "com.obric.memorydata.plugin");
    }

    private final boolean c(PersistentAwarenessRegisterRequest r11) {
        if (Intrinsics.areEqual(r11.getTarget().getTargetType(), "feature") == true) goto L5;
    L17:
        return false;
    L5:
        if (r11.getCondition().isAlways() == true) goto L17;
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L9
        d r10 = (d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L9
        boolean r12 = a.f8761a.a(FeatureManager.INSTANCE.getFeature(r11.getTarget().getTargetName()), r11.getCondition());     // Catch: Throwable -> L9
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "PersistentAwarenessCallHandler", "initial persistent feature match subscriptionId=" + r11.getSubscriptionId() + " target=" + r11.getTarget().getTargetName() + " matched=" + r12, false, 4, null);     // Catch: Throwable -> L9
        Object r13 = Result.m1421constructorimpl(Boolean.valueOf(r12));     // Catch: Throwable -> L9
    L11:
        Throwable r3 = Result.m1424exceptionOrNullimpl(r13);
        if (r3 == null) goto L16;
        RunLog.INSTANCE.warn("PersistentAwarenessCallHandler", "initial persistent feature match failed subscriptionId=" + r11.getSubscriptionId() + " target=" + r11.getTarget().getTargetName(), r3);
        r13 = false;
    L16:
        return ((Boolean) ZeusTransformUtils.preCheckCast(r13, Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    L9:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        r13 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L11
    }

    public final Bundle a(Context r8, String r9, Bundle r10) {
        Context r11 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r11, "context");
        Intrinsics.checkNotNullParameter(r9, "method");
        if (ak.f13164a.a() == false) goto L6;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "PersistentAwarenessCallHandler", "refuse unknown app call", null, 4, null);
        return a(402, "refuse unknown app call");
    L6:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "PersistentAwarenessCallHandler", "handle persistent call method=" + r9, false, 4, null);
        switch(r9.hashCode()) {
            case -2049611138: goto L34;
            case -1837151010: goto L30;
            case -211801762: goto L26;
            case 810770053: goto L22;
            case 1340170885: goto L18;
            case 1412531906: goto L14;
            case 2037700827: goto L10;
            default: goto L39;
        };
    L10:
        if (r9.equals("remove_geofence") == false) goto L39;
        return a(r11, r10);
    L14:
        if (r9.equals("unregister_persistent_subscription") == false) goto L39;
        return b(r11, r10);
    L18:
        if (r9.equals("report_awareness_event") == false) goto L39;
        return a(c(r10));
    L22:
        if (r9.equals("register_persistent_feature_event") == false) goto L39;
        PersistentAwarenessRegisterRequest r12 = a(r10);
        String r13 = "feature";
    L45:
        return a(r11, r12, r13);
    L26:
        if (r9.equals("add_geofence") == false) goto L39;
        return a(r11, b(r10));
    L30:
        if (r9.equals("clear_all_persistent_subscriptions") == false) goto L39;
        return a(r11);
    L34:
        if (r9.equals("register_persistent_context_event") == false) goto L39;
        r12 = a(r10);
        r13 = "event";
    L39:
        return a(401, "unknown method=" + r9);
    }
}
