package com.obric.memorydata.awareness.cae;

import android.os.Bundle;
import android.os.Parcelable;
import com.amap.api.location.AMapLocation;
import com.bytedance.bdlocation.monitor.LBSLightLocationTraceLogger;
import com.bytedance.crash.entity.EventBody;
import com.obric.cae.libs.location.CoordinateTransformUtils;
import com.obric.memorydata.middleware.api.bridge.ICaeRouteBridgeAPI;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.al;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0005\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u000b\u001a\u00020\u0000H\u0007JJ\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0016\u001a\u00020\u0005H\u0016JB\u0010\u0017\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0016\u001a\u00020\u0005H\u0016J\n\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0002J\u0017\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001d\u001a\u00020\u0005H\u0002¢\u0006\u0002\u0010\u001eJ\u0017\u0010\u001f\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u001d\u001a\u00020\u0005H\u0002¢\u0006\u0002\u0010 J\u001f\u0010!\u001a\u00020\r2\u0006\u0010\"\u001a\u00020\u00052\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\r0$H\u0082\bJ\u0010\u0010%\u001a\u00020\r2\u0006\u0010&\u001a\u00020\u0005H\u0002J\u001e\u0010'\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010)\u0018\u00010(*\u0004\u0018\u00010\rH\u0002J\u0014\u0010*\u001a\u0004\u0018\u00010)2\b\u0010\u001d\u001a\u0004\u0018\u00010)H\u0002J\u0012\u0010+\u001a\u00020\r2\b\u0010,\u001a\u0004\u0018\u00010-H\u0002J\u0014\u0010.\u001a\u0004\u0018\u00010)2\b\u0010\u001d\u001a\u0004\u0018\u00010)H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"Lcom/obric/memorydata/awareness/cae/CaeRouteBridgeAPIImpl;", "Lcom/obric/memorydata/middleware/api/bridge/ICaeRouteBridgeAPI;", "<init>", "()V", "TAG", "", "DIRECTION_TYPE_TRANSIT", "", "DIRECTION_TYPE_DRIVING", "DIRECTION_TYPE_WALKING", "DIRECTION_TYPE_RIDING", "getInst", "searchDirection", "Lorg/json/JSONObject;", "oriLat", "", "oriLng", "destLat", "destLng", "inCoordType", "outCoordType", "extraInfos", "directionType", "searchDirectionByAddress", "destAddress", "getLocationServiceOrNull", "Lcom/obric/cae/libs/location/IStarLocationService;", "parseCoordinateSystem", "", EventBody.KEY_VALUE, "(Ljava/lang/String;)Ljava/lang/Byte;", "parseDirectionType", "(Ljava/lang/String;)Ljava/lang/Integer;", "runRouteCall", "apiName", "block", "Lkotlin/Function0;", "errorResult", "message", "toAidlMap", "", "", "jsonValueToAidlValue", "bundleToJson", "bundle", "Landroid/os/Bundle;", "bundleValueToJsonValue", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class CaeRouteBridgeAPIImpl implements ICaeRouteBridgeAPI {
    private static final int DIRECTION_TYPE_DRIVING = 2;
    private static final int DIRECTION_TYPE_RIDING = 4;
    private static final int DIRECTION_TYPE_TRANSIT = 1;
    private static final int DIRECTION_TYPE_WALKING = 3;
    public static final CaeRouteBridgeAPIImpl INSTANCE = null;
    private static final String TAG = "CaeRouteBridgeAPIImpl";

    /* JADX INFO: renamed from: com.obric.memorydata.awareness.cae.CaeRouteBridgeAPIImpl$getLocationServiceOrNull$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/obric/cae/libs/location/IStarLocationService;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.awareness.cae.CaeRouteBridgeAPIImpl$getLocationServiceOrNull$1", f = "CaeRouteBridgeAPIImpl.kt", i = {}, l = {96}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<al, Continuation<? super com.obric.cae.libs.location.b>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> r3) {
            super(2, (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin"));
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
            return (Continuation) ZeusTransformUtils.preCheckCast(new AnonymousClass1((Continuation) ZeusTransformUtils.wrapperContextForParams(r2, Continuation.class, "com.obric.memorydata.plugin")), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super com.obric.cae.libs.location.b> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super com.obric.cae.libs.location.b> r4) {
            return ((AnonymousClass1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AnonymousClass1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r7) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r7);
        L12:
            if (((Boolean) ZeusTransformUtils.preCheckCast(r7, Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == true) goto L15;
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), CaeRouteBridgeAPIImpl.TAG, "cae location service not ready", null, 4, null);
            return null;
        L15:
            com.obric.cae.libs.location.b r6 = b.f8563a.k();
            if (r6 != null) goto L18;
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), CaeRouteBridgeAPIImpl.TAG, "cae location service is null", null, 4, null);
        L18:
            return r6;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r7);
            b.f8563a.i();
            b r8 = b.f8563a;
            Continuation<? super Boolean> r2 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            r7 = r8.a(r2);
            if (r7 != r0) goto L12;
            return r0;
        }
    }

    static {
        INSTANCE = new CaeRouteBridgeAPIImpl();
    }

    private CaeRouteBridgeAPIImpl() {
    }

    private final JSONObject bundleToJson(Bundle r8) {
        JSONObject r0 = new JSONObject();
        if (r8 != null) goto L6;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "route result bundle is null", null, 4, null);
        return r0;
    L6:
        Iterator<String> r2 = r8.keySet().iterator();
    L8:
        if (r2.hasNext() == false) goto L10;
        String r3 = (String) ZeusTransformUtils.preCheckCast(r2.next(), String.class, "com.obric.memorydata.plugin");
        r0.put(r3, bundleValueToJsonValue(r8.get(r3)));
        goto L8
    L10:
        return r0;
    }

    private final Object bundleValueToJsonValue(Object r5) {
        if (r5 != null) goto L5;
        return JSONObject.NULL;
    L5:
        if (ZeusTransformUtils.instanceOf(r5, Bundle.class) == false) goto L8;
        return bundleToJson((Bundle) ZeusTransformUtils.preCheckCast(r5, Bundle.class, "com.obric.memorydata.plugin"));
    L8:
        if (ZeusTransformUtils.instanceOf(r5, List.class) == false) goto L14;
        JSONArray r4 = new JSONArray();
        Iterator r6 = ((Iterable) ZeusTransformUtils.preCheckCast(r5, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L11:
        if (r6.hasNext() == false) goto L57;
        r4.put(INSTANCE.bundleValueToJsonValue(r6.next()));
    L57:
        return r4;
    L14:
        int r0 = 0;
        if ((r5 instanceof Object[]) == false) goto L20;
        r4 = new JSONArray();
        Object[] r7 = (Object[]) ZeusTransformUtils.preCheckCast(r5, Object[].class, "com.obric.memorydata.plugin");
        int r1 = r7.length;
    L17:
        if (r0 >= r1) goto L57;
        r4.put(INSTANCE.bundleValueToJsonValue(r7[r0]));
        r0 = r0 + 1;
        goto L17
    L20:
        if ((r5 instanceof int[]) == false) goto L25;
        r4 = new JSONArray();
        int[] r8 = (int[]) ZeusTransformUtils.preCheckCast(r5, int[].class, "com.obric.memorydata.plugin");
        int r2 = r8.length;
    L22:
        if (r0 >= r2) goto L57;
        r4.put(r8[r0]);
        r0 = r0 + 1;
        goto L22
    L25:
        if ((r5 instanceof long[]) == false) goto L30;
        r4 = new JSONArray();
        long[] r9 = (long[]) ZeusTransformUtils.preCheckCast(r5, long[].class, "com.obric.memorydata.plugin");
        int r3 = r9.length;
    L27:
        if (r0 >= r3) goto L57;
        r4.put(r9[r0]);
        r0 = r0 + 1;
        goto L27
    L30:
        if ((r5 instanceof double[]) == false) goto L35;
        r4 = new JSONArray();
        double[] r10 = (double[]) ZeusTransformUtils.preCheckCast(r5, double[].class, "com.obric.memorydata.plugin");
        int r11 = r10.length;
    L32:
        if (r0 >= r11) goto L57;
        r4.put(r10[r0]);
        r0 = r0 + 1;
        goto L32
    L35:
        if ((r5 instanceof float[]) == false) goto L40;
        r4 = new JSONArray();
        float[] r12 = (float[]) ZeusTransformUtils.preCheckCast(r5, float[].class, "com.obric.memorydata.plugin");
        int r13 = r12.length;
    L37:
        if (r0 >= r13) goto L57;
        r4.put(r12[r0]);
        r0 = r0 + 1;
        goto L37
    L40:
        if ((r5 instanceof boolean[]) == false) goto L45;
        r4 = new JSONArray();
        boolean[] r14 = (boolean[]) ZeusTransformUtils.preCheckCast(r5, boolean[].class, "com.obric.memorydata.plugin");
        int r15 = r14.length;
    L42:
        if (r0 >= r15) goto L57;
        r4.put(r14[r0]);
        r0 = r0 + 1;
        goto L42
    L45:
        if (ZeusTransformUtils.instanceOf(r5, Parcelable.class) == true) goto L47;
        return r5;
    L47:
        return r5.toString();
    }

    private final JSONObject errorResult(String r3) {
        JSONObject r2 = new JSONObject();
        r2.put("status", -1);
        r2.put("message", r3);
        r2.put(LBSLightLocationTraceLogger.TOTAL, 0);
        r2.put("routes", new JSONArray());
        return r2;
    }

    @JvmStatic
    public static final CaeRouteBridgeAPIImpl getInst() {
        return INSTANCE;
    }

    private final com.obric.cae.libs.location.b getLocationServiceOrNull() {
        return (com.obric.cae.libs.location.b) ZeusTransformUtils.preCheckCast(kotlinx.coroutines.i.a(null, (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass1(null), Function2.class, "com.obric.memorydata.plugin"), 1, null), com.obric.cae.libs.location.b.class, "com.obric.memorydata.plugin");
    }

    private final Object jsonValueToAidlValue(Object r6) {
        if (r6 != null) goto L4;
    L15:
        return null;
    L4:
        if (Intrinsics.areEqual(r6, JSONObject.NULL) == true) goto L15;
        if (ZeusTransformUtils.instanceOf(r6, JSONObject.class) == false) goto L10;
        return toAidlMap((JSONObject) ZeusTransformUtils.preCheckCast(r6, JSONObject.class, "com.obric.memorydata.plugin"));
    L10:
        if (ZeusTransformUtils.instanceOf(r6, JSONArray.class) == false) goto L19;
        ArrayList r0 = new ArrayList();
        int r2 = 0;
        int r3 = ((JSONArray) ZeusTransformUtils.preCheckCast(r6, JSONArray.class, "com.obric.memorydata.plugin")).length();
    L12:
        if (r2 >= r3) goto L20;
        r0.add(jsonValueToAidlValue(((JSONArray) ZeusTransformUtils.preCheckCast(r6, JSONArray.class, "com.obric.memorydata.plugin")).opt(r2)));
        r2 = r2 + 1;
        goto L12
    L20:
        return r0;
    L19:
        return r6;
    }

    private final Byte parseCoordinateSystem(String r2) {
        String r1 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin")).toString().toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(r1, "toUpperCase(...)");
        int r3 = r1.hashCode();
        if (r3 == 2033099) goto L17;
        if (r3 == 67638640) goto L14;
        if (r3 == 82543039) goto L10;
    L18:
        return null;
    L10:
        if (r1.equals(AMapLocation.COORD_TYPE_WGS84) == false) goto L18;
        CoordinateTransformUtils.CoordinateSystem r4 = CoordinateTransformUtils.CoordinateSystem.WGS84;
    L21:
        return Byte.valueOf((byte) r4.ordinal());
    L14:
        if (r1.equals(AMapLocation.COORD_TYPE_GCJ02) == false) goto L18;
        r4 = CoordinateTransformUtils.CoordinateSystem.GCJ02;
        goto L21
    L17:
        if (r1.equals("BD09") == false) goto L18;
        r4 = CoordinateTransformUtils.CoordinateSystem.BD09;
        goto L21
    }

    private final Integer parseDirectionType(String r2) {
        String r1 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin")).toString().toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(r1, "toLowerCase(...)");
        switch(r1.hashCode()) {
            case -1067059757: goto L18;
            case -931190859: goto L14;
            case 1118815609: goto L10;
            case 1920367559: goto L6;
            default: goto L22;
        };
    L22:
        return null;
    L6:
        if (r1.equals("driving") == false) goto L22;
        int r3 = 2;
    L24:
        return Integer.valueOf(r3);
    L10:
        if (r1.equals("walking") == false) goto L22;
        r3 = 3;
        goto L24
    L14:
        if (r1.equals("riding") == false) goto L22;
        r3 = 4;
        goto L24
    L18:
        if (r1.equals("transit") == false) goto L22;
        r3 = 1;
        goto L24
    }

    private final JSONObject runRouteCall(String r5, Function0<? extends JSONObject> r6) {
        Function0 r4 = (Function0) ZeusTransformUtils.wrapperContextForParams(r6, Function0.class, "com.obric.memorydata.plugin");
        Result.Companion r7 = Result.Companion;     // Catch: Throwable -> L5
        Object r8 = Result.m1421constructorimpl(r4.invoke());     // Catch: Throwable -> L5
    L7:
        Throwable r9 = Result.m1424exceptionOrNullimpl(r8);
        if (r9 == null) goto L15;
        RunLog.INSTANCE.error(TAG, "route bridge " + r5 + " failed", r9);
        CaeRouteBridgeAPIImpl r10 = INSTANCE;
        String r11 = r9.getMessage();
        if (r11 != null) goto L13;
        r11 = r5 + " failed";
    L13:
        r8 = r10.errorResult(r11);
    L15:
        return (JSONObject) ZeusTransformUtils.preCheckCast(r8, JSONObject.class, "com.obric.memorydata.plugin");
    L5:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        r8 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    private final Map<String, Object> toAidlMap(JSONObject r6) {
        if (r6 != null) goto L5;
        return null;
    L5:
        LinkedHashMap r5 = new LinkedHashMap();
        Iterator<String> r0 = r6.keys();
        Intrinsics.checkNotNullExpressionValue(r0, "keys(...)");
    L7:
        if (r0.hasNext() == false) goto L10;
        String r1 = (String) ZeusTransformUtils.preCheckCast(r0.next(), String.class, "com.obric.memorydata.plugin");
        ((Map) ZeusTransformUtils.preCheckCast(r5, Map.class, "com.obric.memorydata.plugin")).put(r1, INSTANCE.jsonValueToAidlValue(r6.opt(r1)));
        goto L7
    L10:
        return (Map) ZeusTransformUtils.preCheckCast(r5, Map.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.memorydata.middleware.api.bridge.ICaeRouteBridgeAPI
    public JSONObject searchDirection(double r20, double r22, double r24, double r26, String r28, String r29, JSONObject r30, String r31) {
        Intrinsics.checkNotNullParameter(r28, "inCoordType");
        Intrinsics.checkNotNullParameter(r29, "outCoordType");
        Intrinsics.checkNotNullParameter(r31, "directionType");
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L20
        CaeRouteBridgeAPIImpl r4 = INSTANCE;     // Catch: Throwable -> L20
        Byte r5 = r4.parseCoordinateSystem(r28);     // Catch: Throwable -> L20
        if (r5 == null) goto L17;
        byte r15 = r5.byteValue();     // Catch: Throwable -> L20
        Byte r0 = r4.parseCoordinateSystem(r29);     // Catch: Throwable -> L20
        if (r0 == null) goto L16;
        byte r16 = r0.byteValue();     // Catch: Throwable -> L20
        Integer r1 = r4.parseDirectionType(r31);     // Catch: Throwable -> L20
        if (r1 == null) goto L15;
        int r18 = r1.intValue();     // Catch: Throwable -> L20
        com.obric.cae.libs.location.b r6 = r4.getLocationServiceOrNull();     // Catch: Throwable -> L20
        if (r6 != null) goto L14;
        String r2 = "cae location service not ready";
    L13:
        JSONObject r7 = r4.errorResult(r2);     // Catch: Throwable -> L20
    L18:
        Object r8 = Result.m1421constructorimpl(r7);     // Catch: Throwable -> L20
    L22:
        Throwable r9 = Result.m1424exceptionOrNullimpl(r8);
        if (r9 == null) goto L30;
        RunLog.INSTANCE.error(TAG, "route bridge searchDirection failed", r9);
        CaeRouteBridgeAPIImpl r10 = INSTANCE;
        String r11 = r9.getMessage();
        if (r11 != null) goto L28;
        r11 = "searchDirection failed";
    L28:
        r8 = r10.errorResult(r11);
    L30:
        return (JSONObject) ZeusTransformUtils.preCheckCast(r8, JSONObject.class, "com.obric.memorydata.plugin");
    L14:
        r7 = r4.bundleToJson(r6.a(r20, r22, r24, r26, r15, r16, r4.toAidlMap(r30), r18));     // Catch: Throwable -> L20
        goto L18
    L15:
        r2 = "unsupported direction type: " + r31;     // Catch: Throwable -> L20
        goto L13
    L16:
        r2 = "unsupported coord type: " + r29;     // Catch: Throwable -> L20
        goto L13
    L17:
        r2 = "unsupported coord type: " + r28;     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        r8 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L22
    }

    @Override // com.obric.memorydata.middleware.api.bridge.ICaeRouteBridgeAPI
    public JSONObject searchDirectionByAddress(double r14, double r16, String r18, String r19, String r20, JSONObject r21, String r22) {
        Intrinsics.checkNotNullParameter(r18, "destAddress");
        Intrinsics.checkNotNullParameter(r19, "inCoordType");
        Intrinsics.checkNotNullParameter(r20, "outCoordType");
        Intrinsics.checkNotNullParameter(r22, "directionType");
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L23
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r18, CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L6;
        JSONObject r0 = INSTANCE.errorResult("destAddress is blank");     // Catch: Throwable -> L23
    L21:
        Object r1 = Result.m1421constructorimpl(r0);     // Catch: Throwable -> L23
    L25:
        Throwable r2 = Result.m1424exceptionOrNullimpl(r1);
        if (r2 == null) goto L33;
        RunLog.INSTANCE.error(TAG, "route bridge searchDirectionByAddress failed", r2);
        CaeRouteBridgeAPIImpl r3 = INSTANCE;
        String r5 = r2.getMessage();
        if (r5 != null) goto L31;
        r5 = "searchDirectionByAddress failed";
    L31:
        r1 = r3.errorResult(r5);
    L33:
        return (JSONObject) ZeusTransformUtils.preCheckCast(r1, JSONObject.class, "com.obric.memorydata.plugin");
    L6:
        CaeRouteBridgeAPIImpl r12 = INSTANCE;     // Catch: Throwable -> L23
        Byte r6 = r12.parseCoordinateSystem(r19);     // Catch: Throwable -> L23
        if (r6 == null) goto L20;
        byte r7 = r6.byteValue();     // Catch: Throwable -> L23
        Byte r8 = r12.parseCoordinateSystem(r20);     // Catch: Throwable -> L23
        if (r8 == null) goto L19;
        byte r9 = r8.byteValue();     // Catch: Throwable -> L23
        Integer r10 = r12.parseDirectionType(r22);     // Catch: Throwable -> L23
        if (r10 == null) goto L18;
        int r11 = r10.intValue();     // Catch: Throwable -> L23
        com.obric.cae.libs.location.b r13 = r12.getLocationServiceOrNull();     // Catch: Throwable -> L23
        if (r13 != null) goto L17;
        String r15 = "cae location service not ready";
    L16:
        r0 = r12.errorResult(r15);     // Catch: Throwable -> L23
        goto L21
    L17:
        r0 = r12.bundleToJson(r13.a(r14, r16, r18, r7, r9, r12.toAidlMap(r21), r11));     // Catch: Throwable -> L23
        goto L21
    L18:
        r15 = "unsupported direction type: " + r22;     // Catch: Throwable -> L23
        goto L16
    L19:
        r15 = "unsupported coord type: " + r20;     // Catch: Throwable -> L23
        goto L16
    L20:
        r15 = "unsupported coord type: " + r19;     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        Result.Companion r17 = Result.Companion;
        r1 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L25
    }
}
