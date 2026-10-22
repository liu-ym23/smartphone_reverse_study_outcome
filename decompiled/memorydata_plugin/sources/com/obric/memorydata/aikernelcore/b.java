package com.obric.memorydata.aikernelcore;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.gson.internal.LinkedTreeMap;
import com.obric.aikernel.sdk.autotest.AutoTestConstant;
import com.obric.memorydata.init.tasks.pitaya.APIInfo;
import com.obric.memorydata.init.tasks.pitaya.BridgeData;
import com.obric.memorydata.middleware.api.bridge.AiProactiveAgentBridgeAPI;
import com.obric.memorydata.middleware.api.bridge.AppEntityIndexBridgeAPI;
import com.obric.memorydata.middleware.api.bridge.AuditoryBridgeAPI;
import com.obric.memorydata.middleware.api.bridge.AutoMemoryProBridgeAPI;
import com.obric.memorydata.middleware.api.bridge.CaeRouteBridgeAPI;
import com.obric.memorydata.middleware.api.bridge.CoreBridgeAPI;
import com.obric.memorydata.middleware.api.bridge.DbBridgeAPI;
import com.obric.memorydata.middleware.api.bridge.EntitySearchBridgeApi;
import com.obric.memorydata.middleware.api.bridge.ExperimentBridgeAPI;
import com.obric.memorydata.middleware.api.bridge.FeatureBridgeAPI;
import com.obric.memorydata.middleware.api.bridge.GlassBridgeAPI;
import com.obric.memorydata.middleware.api.bridge.HarnessDebugBridgeAPI;
import com.obric.memorydata.middleware.api.bridge.InAppRuleBridgeAPI;
import com.obric.memorydata.middleware.api.bridge.InvertedIndexDbBridgeAPI;
import com.obric.memorydata.middleware.api.bridge.LifeLogBridgeAPI;
import com.obric.memorydata.middleware.api.bridge.LocationSlotProcessBridgeAPI;
import com.obric.memorydata.middleware.api.bridge.MemoryBuildBridgeAPI;
import com.obric.memorydata.middleware.api.bridge.MemoryStorageBridgeAPI;
import com.obric.memorydata.middleware.api.bridge.NetworkBridgeAPI;
import com.obric.memorydata.middleware.api.bridge.PlaygroundAPI;
import com.obric.memorydata.middleware.api.bridge.ProactiveMemoryBridgeAPI;
import com.obric.memorydata.middleware.api.bridge.SecurityGuardAPI;
import com.obric.memorydata.middleware.api.bridge.StoreBridgeAPI;
import com.obric.memorydata.middleware.api.bridge.TaskConditionBridgeApi;
import com.obric.memorydata.middleware.api.bridge.TaskProgressBridgeAPI;
import com.obric.memorydata.middleware.api.bridge.UnionMemoryBuildBridgeAPI;
import com.obric.memorydata.middleware.api.bridge.UserProfileTaskBridgeAPI;
import com.obric.memorydata.middleware.api.bridge.VectorDbBridgeAPI;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.utils.ab;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\t\u001a\u0004\u0018\u00010\u00012\u0006\u0010\n\u001a\u00020\u000bJ2\u0010\f\u001a\u0004\u0018\u00010\u00012\u0006\u0010\r\u001a\u00020\u00012\u0016\u0010\u000e\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0018\u00010\u00100\u000f2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u001e\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/obric/memorydata/aikernelcore/BridgeHandler;", "", "<init>", "()V", "TAG", "", "MODULE_API", "", "Ljava/lang/Class;", "handle", "data", "Lcom/obric/memorydata/init/tasks/pitaya/BridgeData;", "checkListItemTypes", AutoTestConstant.PARAM, "genericParameterTypesGetter", "Lkotlin/Function0;", "", "Ljava/lang/reflect/Type;", "index", "", "aikernel_core_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f8455a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Map<String, Class<?>> f8456b = null;

    static {
        f8455a = new b();
        f8456b = MapsKt.mapOf(new Pair[]{TuplesKt.to("in_app_rule", InAppRuleBridgeAPI.class), TuplesKt.to("core", CoreBridgeAPI.class), TuplesKt.to("cae_route", CaeRouteBridgeAPI.class), TuplesKt.to("store_manager", StoreBridgeAPI.class), TuplesKt.to("feature_manager", FeatureBridgeAPI.class), TuplesKt.to("glass", GlassBridgeAPI.class), TuplesKt.to("network", NetworkBridgeAPI.class), TuplesKt.to("app_entity_index_manager", AppEntityIndexBridgeAPI.class), TuplesKt.to("vector_manager", VectorDbBridgeAPI.class), TuplesKt.to("entity_search_bridge", EntitySearchBridgeApi.class), TuplesKt.to("experiment", ExperimentBridgeAPI.class), TuplesKt.to("location_slot_processor", LocationSlotProcessBridgeAPI.class), TuplesKt.to("entity_search_bridge", EntitySearchBridgeApi.class), TuplesKt.to("memory_build", MemoryBuildBridgeAPI.class), TuplesKt.to("memory_storage", MemoryStorageBridgeAPI.class), TuplesKt.to("task_condition_bridge", TaskConditionBridgeApi.class), TuplesKt.to("db_manager", DbBridgeAPI.class), TuplesKt.to("inverted_index_db_manager", InvertedIndexDbBridgeAPI.class), TuplesKt.to("user_profile_task", UserProfileTaskBridgeAPI.class), TuplesKt.to("proactive_memory", ProactiveMemoryBridgeAPI.class), TuplesKt.to("union_memory", UnionMemoryBuildBridgeAPI.class), TuplesKt.to("life_log", LifeLogBridgeAPI.class), TuplesKt.to("security_guard", SecurityGuardAPI.class), TuplesKt.to("task_callback", TaskProgressBridgeAPI.class), TuplesKt.to("auto_memory_pro", AutoMemoryProBridgeAPI.class), TuplesKt.to("auditory", AuditoryBridgeAPI.class), TuplesKt.to("harness_debug", HarnessDebugBridgeAPI.class), TuplesKt.to("ai_proactive_agent", AiProactiveAgentBridgeAPI.class), TuplesKt.to("playground", PlaygroundAPI.class)});
    }

    private b() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v4, types: [java.util.List] */
    private final Object a(Object r5, Function0<Type[]> r6, int r7) {
        Function0 r4 = (Function0) ZeusTransformUtils.wrapperContextForParams(r6, Function0.class, "com.obric.memorydata.plugin");
        if (r5 != 0) goto L5;
    L58:
        return r5;
    L5:
        if (List.class.isAssignableFrom(r5.getClass()) == false) goto L58;
        Type[] r8 = (Type[]) ZeusTransformUtils.preCheckCast(r4.invoke(), Type[].class, "com.obric.memorydata.plugin");
        List r9 = null;
        if (r8 == null) goto L9;
        Type r10 = (Type) ZeusTransformUtils.preCheckCast(ArraysKt.getOrNull(r8, r7), Type.class, "com.obric.memorydata.plugin");
    L11:
        if (ZeusTransformUtils.instanceOf(r10, ParameterizedType.class) == false) goto L13;
        ParameterizedType r11 = (ParameterizedType) ZeusTransformUtils.preCheckCast(r10, ParameterizedType.class, "com.obric.memorydata.plugin");
    L14:
        if (r11 == null) goto L18;
        Type[] r12 = r11.getActualTypeArguments();
        if (r12 == null) goto L18;
        Object r13 = (Type) ZeusTransformUtils.preCheckCast(ArraysKt.getOrNull(r12, 0), Type.class, "com.obric.memorydata.plugin");
    L20:
        if (ZeusTransformUtils.instanceOf(r13, Class.class) == false) goto L23;
    L21:
        Class r14 = (Class) ZeusTransformUtils.preCheckCast(r13, Class.class, "com.obric.memorydata.plugin");
    L28:
        if (r14 == null) goto L58;
        if (TypeIntrinsics.isMutableList(r5) == false) goto L32;
        r9 = (List) ZeusTransformUtils.preCheckCast(r5, List.class, "com.obric.memorydata.plugin");
    L32:
        if (r9 == null) goto L58;
        r5 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        Iterator r15 = ((Iterable) ZeusTransformUtils.preCheckCast(r9, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L35:
        if (r15.hasNext() == false) goto L58;
        Object r16 = r15.next();
        String r1 = r14.getName();
        if (Intrinsics.areEqual(r1, "java.lang.Long") == true) goto L38;
        if (Intrinsics.areEqual(r1, "java.lang.Integer") == true) goto L42;
        if (Intrinsics.areEqual(r1, "java.lang.Short") == true) goto L45;
        if (Intrinsics.areEqual(r1, "java.lang.Byte") == true) goto L48;
        if (Intrinsics.areEqual(r1, "java.lang.Double") == true) goto L51;
        if (Intrinsics.areEqual(r1, "java.lang.Float") == true) goto L54;
        if (Intrinsics.areEqual(r1, JSONObject.class.getName()) == false) goto L39;
        r5.add(new JSONObject(ab.a().toJson(r16)));
    L39:
        r5.add(r16);
        goto L35
    L54:
        Intrinsics.checkNotNull(r16, "null cannot be cast to non-null type kotlin.Number");
        r16 = Float.valueOf(((Number) ZeusTransformUtils.preCheckCast(r16, Number.class, "com.obric.memorydata.plugin")).floatValue());
        goto L39
    L51:
        Intrinsics.checkNotNull(r16, "null cannot be cast to non-null type kotlin.Number");
        r16 = Double.valueOf(((Number) ZeusTransformUtils.preCheckCast(r16, Number.class, "com.obric.memorydata.plugin")).doubleValue());
        goto L39
    L48:
        Intrinsics.checkNotNull(r16, "null cannot be cast to non-null type kotlin.Number");
        r16 = Byte.valueOf(((Number) ZeusTransformUtils.preCheckCast(r16, Number.class, "com.obric.memorydata.plugin")).byteValue());
        goto L39
    L45:
        Intrinsics.checkNotNull(r16, "null cannot be cast to non-null type kotlin.Number");
        r16 = Short.valueOf(((Number) ZeusTransformUtils.preCheckCast(r16, Number.class, "com.obric.memorydata.plugin")).shortValue());
        goto L39
    L42:
        Intrinsics.checkNotNull(r16, "null cannot be cast to non-null type kotlin.Number");
        r16 = Integer.valueOf(((Number) ZeusTransformUtils.preCheckCast(r16, Number.class, "com.obric.memorydata.plugin")).intValue());
        goto L39
    L38:
        Intrinsics.checkNotNull(r16, "null cannot be cast to non-null type kotlin.Number");
        r16 = Long.valueOf(((Number) ZeusTransformUtils.preCheckCast(r16, Number.class, "com.obric.memorydata.plugin")).longValue());
        goto L39
    L23:
        if (ZeusTransformUtils.instanceOf(r13, WildcardType.class) == false) goto L27;
        Type[] r17 = ((WildcardType) ZeusTransformUtils.preCheckCast(r13, WildcardType.class, "com.obric.memorydata.plugin")).getUpperBounds();
        Intrinsics.checkNotNullExpressionValue(r17, "getUpperBounds(...)");
        r13 = ArraysKt.firstOrNull((Object[]) ZeusTransformUtils.preCheckCast(r17, Object[].class, "com.obric.memorydata.plugin"));
        if (ZeusTransformUtils.instanceOf(r13, Class.class) == true) goto L21;
    L27:
        r14 = null;
    L18:
        r13 = null;
        goto L20
    L13:
        r11 = null;
        goto L14
    L9:
        r10 = null;
        goto L11
    }

    private static final Type[] a(Type[][] r2, Method r3) {
        if (r2[0] != null) goto L6;
        r2[0] = r3.getGenericParameterTypes();
    L6:
        return r2[0];
    }

    /* JADX INFO: renamed from: lambda$egrHqZ4oMb0cd7RF-Gt2TLDNdlY, reason: not valid java name */
    public static /* synthetic */ Type[] m464lambda$egrHqZ4oMb0cd7RFGt2TLDNdlY(Type[][] r0, Method r1) {
        return a(r0, r1);
    }

    public final Object a(BridgeData r21) {
        Intrinsics.checkNotNullParameter(r21, "data");
        APIInfo r0 = r21.getApiInfo();
        Class r2 = (Class) ZeusTransformUtils.preCheckCast(f8456b.get(r0.getModule()), Class.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L119;
    L7:
        if (r2 == null) goto L116;
        Method[] r5 = r2.getDeclaredMethods();
        Intrinsics.checkNotNullExpressionValue(r5, "getDeclaredMethods(...)");
        Object[] r6 = (Object[]) ZeusTransformUtils.preCheckCast(r5, Object[].class, "com.obric.memorydata.plugin");
        int r7 = r6.length;
        int r9 = 0;
        boolean r10 = false;
        Object r11 = null;
    L10:
        if (r9 >= r7) goto L22;
        Object r13 = r6[r9];
        Method r14 = (Method) ZeusTransformUtils.preCheckCast(r13, Method.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(r14.getName(), r0.getApiName()) == true) goto L14;
    L16:
        boolean r8 = false;
    L17:
        if (r8 == false) goto L21;
        if (r10 == true) goto L23;
        r10 = true;
        r11 = r13;
    L23:
        r11 = null;
    L24:
        final Method r12 = (Method) ZeusTransformUtils.preCheckCast(r11, Method.class, "com.obric.memorydata.plugin");
        if (r12 == null) goto L113;
        List r15 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        final Type[][] r16 = {null};
        Function0<Type[]> r17 = new $$Lambda$b$egrHqZ4oMb0cd7RFGt2TLDNdlY(r16, r12);
        Class<?>[] r18 = r12.getParameterTypes();
        Intrinsics.checkNotNullExpressionValue(r18, "getParameterTypes(...)");
        Object[] r19 = (Object[]) ZeusTransformUtils.preCheckCast(r18, Object[].class, "com.obric.memorydata.plugin");
        int r110 = r19.length;
        int r111 = 0;
        int r112 = 0;
    L27:
        if (r111 >= r110) goto L108;
        int r113 = r112 + 1;
        Class r20 = (Class) ZeusTransformUtils.preCheckCast(r19[r111], Class.class, "com.obric.memorydata.plugin");
        Object r114 = f8455a.a(r0.getParams().get(r112), r17, r112);
        if (r114 != null) goto L31;
    L106:
        Object[] r115 = r19;
        r15.add(r114);
    L107:
        r111 = r111 + 1;
        r112 = r113;
        r19 = r115;
        goto L27
    L31:
        if (Intrinsics.areEqual(r20, r114.getClass()) == true) goto L106;
        String r116 = r20.getName();     // Catch: ClassCastException -> L103
        if (r116 != null) goto L35;
    L87:
        r115 = r19;
    L89:
        if (r20.isAssignableFrom(r0.getParams().get(r112).getClass()) == false) goto L92;
        r15.add(r114);     // Catch: ClassCastException -> L103
        goto L107
    L92:
        if (Set.class.isAssignableFrom(r20) == false) goto L97;
        if (List.class.isAssignableFrom(r114.getClass()) == false) goto L97;
        Object r22 = CollectionsKt.toSet((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r114, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"));     // Catch: ClassCastException -> L103
    L59:
        r15.add(r22);     // Catch: ClassCastException -> L103
    L97:
        if (Intrinsics.areEqual(JSONObject.class, r20) == false) goto L101;
        if (Intrinsics.areEqual(r0.getParams().get(r112).getClass(), LinkedTreeMap.class) == false) goto L101;
        r22 = new JSONObject(ab.a().toJson(r114));     // Catch: ClassCastException -> L103
    L101:
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "BridgeHandler", r114.getClass() + " not match type " + r20.getName(), null, 4, null);     // Catch: ClassCastException -> L103
        throw new IllegalArgumentException(r0.getParams().get(r112).getClass() + " not match method param type " + r20.getName() + ", request bridge info: " + r21);     // Catch: ClassCastException -> L103
    L35:
        switch(r116.hashCode()) {
            case -2056817302: goto L83;
            case -1325958191: goto L79;
            case -527879800: goto L75;
            case -515992664: goto L71;
            case 104431: goto L68;
            case 3039496: goto L64;
            case 3327612: goto L60;
            case 64711720: goto L55;
            case 97526364: goto L52;
            case 109413500: goto L49;
            case 344809556: goto L46;
            case 398507100: goto L43;
            case 398795216: goto L40;
            case 761287205: goto L37;
            default: goto L87;
        };     // Catch: ClassCastException -> L103
    L37:
        r115 = r19;
        if (r116.equals("java.lang.Double") == false) goto L89;
    L82:
        r22 = Double.valueOf(((Number) ZeusTransformUtils.preCheckCast(r114, Number.class, "com.obric.memorydata.plugin")).doubleValue());     // Catch: ClassCastException -> L103
        goto L59
    L40:
        r115 = r19;
        if (r116.equals("java.lang.Long") == false) goto L89;
    L63:
        r22 = Long.valueOf(((Number) ZeusTransformUtils.preCheckCast(r114, Number.class, "com.obric.memorydata.plugin")).longValue());     // Catch: ClassCastException -> L103
        goto L59
    L43:
        r115 = r19;
        if (r116.equals("java.lang.Byte") == false) goto L89;
    L67:
        r22 = Byte.valueOf(((Number) ZeusTransformUtils.preCheckCast(r114, Number.class, "com.obric.memorydata.plugin")).byteValue());     // Catch: ClassCastException -> L103
        goto L59
    L46:
        r115 = r19;
        if (r116.equals("java.lang.Boolean") == false) goto L89;
    L58:
        r22 = (Boolean) ZeusTransformUtils.preCheckCast(r114, Boolean.class, "com.obric.memorydata.plugin");     // Catch: ClassCastException -> L103
        goto L59
    L49:
        r115 = r19;
        if (r116.equals("short") == false) goto L89;
    L74:
        r22 = Short.valueOf(((Number) ZeusTransformUtils.preCheckCast(r114, Number.class, "com.obric.memorydata.plugin")).shortValue());     // Catch: ClassCastException -> L103
        goto L59
    L52:
        r115 = r19;
        if (r116.equals(TypedValues.Custom.S_FLOAT) == false) goto L89;
    L78:
        r22 = Float.valueOf(((Number) ZeusTransformUtils.preCheckCast(r114, Number.class, "com.obric.memorydata.plugin")).floatValue());     // Catch: ClassCastException -> L103
        goto L59
    L55:
        r115 = r19;
        if (r116.equals(TypedValues.Custom.S_BOOLEAN) == true) goto L58;
    L60:
        r115 = r19;
        if (r116.equals("long") == true) goto L63;
    L64:
        r115 = r19;
        if (r116.equals("byte") == true) goto L67;
    L68:
        r115 = r19;
        if (r116.equals("int") == false) goto L89;
    L86:
        r22 = Integer.valueOf(((Number) ZeusTransformUtils.preCheckCast(r114, Number.class, "com.obric.memorydata.plugin")).intValue());     // Catch: ClassCastException -> L103
        goto L59
    L71:
        r115 = r19;
        if (r116.equals("java.lang.Short") == true) goto L74;
    L75:
        r115 = r19;
        if (r116.equals("java.lang.Float") == true) goto L78;
    L79:
        r115 = r19;
        if (r116.equals("double") == true) goto L82;
    L83:
        r115 = r19;
        if (r116.equals("java.lang.Integer") == true) goto L86;
    L103:
        e = move-exception;
        e.printStackTrace();
        throw new RuntimeException("param " + r114 + " is not " + r20.getName() + " Type, request bridge info: " + r21);
    L108:
        Field r1 = r2.getDeclaredField("INSTANCE");
        r1.setAccessible(true);
        Object r3 = r1.get(null);
        r12.setAccessible(true);
        if (Intrinsics.areEqual(Void.TYPE, r12.getReturnType()) == false) goto L111;
        Object[] r4 = ((Collection) ZeusTransformUtils.preCheckCast(r15, Collection.class, "com.obric.memorydata.plugin")).toArray(new Object[0]);
        r12.invoke(r3, Arrays.copyOf(r4, r4.length));
        return Void.TYPE;
    L111:
        Object[] r23 = ((Collection) ZeusTransformUtils.preCheckCast(r15, Collection.class, "com.obric.memorydata.plugin")).toArray(new Object[0]);
        return r12.invoke(r3, Arrays.copyOf(r23, r23.length));
    L113:
        String r24 = "Method not found or parameters do not match, request bridge info: " + r21;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "BridgeHandler", r24, null, 4, null);
        throw new RuntimeException(r24);
    L21:
        r9 = r9 + 1;
        goto L10
    L14:
        if (r14.getParameterCount() != r0.getParams().size()) goto L16;
        r8 = true;
        goto L17
    L22:
        if (r10 == true) goto L24;
    L116:
        throw new RuntimeException("module " + r0.getModule() + " not found, request bridge info: " + r21);
    L119:
        r2 = ZeusTransformUtils.forName(r21.getApiInfo().getModule(), "com.obric.memorydata.plugin");     // Catch: ClassNotFoundException -> L6
    L6:
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "BridgeHandler", "not found class " + r21.getApiInfo().getModule() + ", request bridge info: " + r21, null, 4, null);
        goto L7
    }
}
