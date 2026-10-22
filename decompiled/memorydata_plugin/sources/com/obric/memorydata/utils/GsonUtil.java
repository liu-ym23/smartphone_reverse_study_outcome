package com.obric.memorydata.utils;

import androidx.exifinterface.media.ExifInterface;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.internal.C$Gson$Types;
import com.google.gson.reflect.TypeToken;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001:\u00014B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\f\u001a\u0004\u0018\u0001H\r\"\u0006\b\u0000\u0010\r\u0018\u00012\u0006\u0010\u000e\u001a\u00020\u0005H\u0086\b¢\u0006\u0002\u0010\u000fJ \u0010\f\u001a\u0004\u0018\u0001H\r\"\u0006\b\u0000\u0010\r\u0018\u00012\u0006\u0010\u000e\u001a\u00020\u0010H\u0086\b¢\u0006\u0002\u0010\u0011J\u001e\u0010\u0012\u001a\u0002H\r\"\u0006\b\u0000\u0010\r\u0018\u00012\u0006\u0010\u000e\u001a\u00020\u0005H\u0086\b¢\u0006\u0002\u0010\u000fJ#\u0010\u0013\u001a\n\u0012\u0004\u0012\u0002H\r\u0018\u00010\u0014\"\u0006\b\u0000\u0010\r\u0018\u00012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0005H\u0086\bJ\u001a\u0010\u0016\u001a\u0002H\r\"\u0006\b\u0000\u0010\r\u0018\u0001*\u0002H\rH\u0086\b¢\u0006\u0002\u0010\u0017J\u000e\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u0001J\u0016\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u00012\u0006\u0010\u001a\u001a\u00020\u001bJ\u000e\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0019\u001a\u00020\u0001J\u0010\u0010\u001e\u001a\u00020\u001b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bJ\u001c\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050 2\b\u0010!\u001a\u0004\u0018\u00010\u0005J\u001a\u0010&\u001a\u00020\u00052\b\u0010\u0019\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u0010'\u001a\u00020(J*\u0010)\u001a\u0004\u0018\u00010\u00012\b\u0010*\u001a\u0004\u0018\u00010\u00012\u0006\u0010'\u001a\u00020(2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020-0,H\u0002J\"\u0010.\u001a\b\u0012\u0004\u0012\u00020/0\u00142\n\u00100\u001a\u0006\u0012\u0002\b\u0003012\u0006\u0010'\u001a\u00020(H\u0002J\u0012\u00102\u001a\u0004\u0018\u00010\u00012\u0006\u00103\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR#\u0010\"\u001a\n #*\u0004\u0018\u00010\u00070\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b%\u0010\u000b\u001a\u0004\b$\u0010\t¨\u00065"}, d2 = {"Lcom/obric/memorydata/utils/GsonUtil;", "", "<init>", "()V", "TAG", "", GsonUtil.TAG, "Lcom/google/gson/Gson;", "getGSON", "()Lcom/google/gson/Gson;", "GSON$delegate", "Lkotlin/Lazy;", "fromJson", ExifInterface.GPS_DIRECTION_TRUE, "json", "(Ljava/lang/String;)Ljava/lang/Object;", "Lcom/google/gson/JsonElement;", "(Lcom/google/gson/JsonElement;)Ljava/lang/Object;", "fromJsonByType", "fromJsonArray", "", "jsonArray", "deepCopy", "(Ljava/lang/Object;)Ljava/lang/Object;", "toJson", "src", "type", "Ljava/lang/reflect/Type;", "toJSONObject", "Lorg/json/JSONObject;", "canonicalize", "convertMap", "", "str", "PRETTY_GSON", "kotlin.jvm.PlatformType", "getPRETTY_GSON", "PRETTY_GSON$delegate", "toPrettyJson", "includeParent", "", "toJsonObject", "obj", "visited", "", "", "getAllFields", "Ljava/lang/reflect/Field;", "clazz", "Ljava/lang/Class;", "parseJsonString", "jsonStr", "JsonString", "utils_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class GsonUtil {
    private static final Lazy GSON$delegate = null;
    public static final GsonUtil INSTANCE = null;
    private static final Lazy PRETTY_GSON$delegate = null;
    public static final String TAG = "GSON";

    @Target({ElementType.FIELD})
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/obric/memorydata/utils/GsonUtil$JsonString;", "", "utils_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    @kotlin.annotation.Target(allowedTargets = {AnnotationTarget.FIELD})
    @Retention(RetentionPolicy.RUNTIME)
    @kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
    public @interface a {
    }

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u001a\u0012\u0016\u0012\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00020\u0001¨\u0006\u0004"}, d2 = {"com/obric/memorydata/utils/GsonUtil$convertMap$1", "Lcom/google/gson/reflect/TypeToken;", "", "", "utils_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b extends TypeToken<Map<String, ? extends String>> {
        b() {
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    @Metadata(d1 = {"\u0000\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u0001¨\u0006\u0003"}, d2 = {"com/obric/memorydata/utils/GsonUtil$fromJsonArray$2$1", "Lcom/google/gson/reflect/TypeToken;", "", "utils_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 176)
    public static final class c<T> extends TypeToken<List<? extends T>> {
        public c() {
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    @Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001¨\u0006\u0002"}, d2 = {"com/obric/memorydata/utils/GsonUtil$fromJsonByType$1", "Lcom/google/gson/reflect/TypeToken;", "utils_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 176)
    public static final class d<T> extends TypeToken<T> {
        public d() {
        }
    }

    static {
        INSTANCE = new GsonUtil();
        GSON$delegate = LazyKt.lazy($$Lambda$GsonUtil$dRRz5IUwpvrjNCiP3R3WKTn_M.INSTANCE);
        PRETTY_GSON$delegate = LazyKt.lazy($$Lambda$GsonUtil$RUo6WnrGAH_vYZYEf04qnehnG4.INSTANCE);
    }

    private GsonUtil() {
    }

    private static final Gson GSON_delegate$lambda$0() {
        return new Gson();
    }

    private static final Gson PRETTY_GSON_delegate$lambda$3() {
        return new GsonBuilder().setPrettyPrinting().serializeNulls().create();
    }

    private final List<Field> getAllFields(Class<?> r8, boolean r9) {
        List<Field> r7 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
    L3:
        if (r8 == null) goto L15;
        if (Intrinsics.areEqual(r8, Object.class) == true) goto L15;
        Field[] r0 = r8.getDeclaredFields();
        Intrinsics.checkNotNullExpressionValue(r0, "getDeclaredFields(...)");
        Object[] r1 = (Object[]) ZeusTransformUtils.preCheckCast(r0, Object[].class, "com.obric.memorydata.plugin");
        Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        int r3 = 0;
        int r4 = r1.length;
    L7:
        if (r3 >= r4) goto L12;
        Object r5 = r1[r3];
        if ((!Modifier.isStatic(((Field) ZeusTransformUtils.preCheckCast(r5, Field.class, "com.obric.memorydata.plugin")).getModifiers())) == false) goto L11;
        r2.add(r5);
    L11:
        r3 = r3 + 1;
        goto L7
    L12:
        r7.addAll((Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.memorydata.plugin"), Collection.class, "com.obric.memorydata.plugin"));
        if (r9 == false) goto L15;
        r8 = r8.getSuperclass();
    L15:
        return r7;
    }

    private final Gson getPRETTY_GSON() {
        return (Gson) ZeusTransformUtils.preCheckCast(PRETTY_GSON$delegate.getValue(), Gson.class, "com.obric.memorydata.plugin");
    }

    /* JADX INFO: renamed from: lambda$RUo6-WnrGAH_vYZYEf04qnehnG4, reason: not valid java name */
    public static /* synthetic */ Gson m1239lambda$RUo6WnrGAH_vYZYEf04qnehnG4() {
        return PRETTY_GSON_delegate$lambda$3();
    }

    /* JADX INFO: renamed from: lambda$dRRz5IUwpvrjN-CiP3-R3WKTn_M, reason: not valid java name */
    public static /* synthetic */ Gson m1240lambda$dRRz5IUwpvrjNCiP3R3WKTn_M() {
        return GSON_delegate$lambda$0();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v0, types: [java.lang.Object, java.lang.String] */
    /* JADX WARN: Type inference failed for: r6v1, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v2, types: [java.lang.Object] */
    private final Object parseJsonString(String r6) {
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L15;
        return r6;
    L15:
        String r0 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.memorydata.plugin")).toString();     // Catch: Exception -> L14
        if (StringsKt.startsWith$default(r0, "{", false, 2, null) == false) goto L10;
        Gson r5 = getGSON();     // Catch: Exception -> L14
        GenericDeclaration r1 = Map.class;
    L8:
        r6 = r5.fromJson(r0, r1);     // Catch: Exception -> L14
        return r6;
    L10:
        if (StringsKt.startsWith$default(r0, "[", false, 2, null) == false) goto L17;
        r5 = getGSON();     // Catch: Exception -> L14
        r1 = List.class;
        goto L8
    L17:
        return r6;
    L18:
        return r6;
    }

    private final Object toJsonObject(Object r10, boolean r11, Set<Integer> r12) {
        Set<Integer> r13 = (Set) ZeusTransformUtils.wrapperContextForParams(r12, Set.class, "com.obric.memorydata.plugin");
        if (r10 != null) goto L7;
        return null;
    L7:
        if (ZeusTransformUtils.instanceOf(r10, Boolean.class) == false) goto L9;
        return r10;
    L9:
        if (ZeusTransformUtils.instanceOf(r10, Number.class) == false) goto L11;
        return r10;
    L11:
        if (ZeusTransformUtils.instanceOf(r10, Character.class) == false) goto L13;
        return r10;
    L13:
        if (ZeusTransformUtils.instanceOf(r10, String.class) == false) goto L16;
        return r10;
    L16:
        if (ZeusTransformUtils.instanceOf(r10, Enum.class) == false) goto L19;
        return ((Enum) ZeusTransformUtils.preCheckCast(r10, Enum.class, "com.obric.memorydata.plugin")).name();
    L19:
        if ((r10 instanceof Object[]) == false) goto L25;
        Object[] r9 = (Object[]) ZeusTransformUtils.preCheckCast(r10, Object[].class, "com.obric.memorydata.plugin");
        Collection r14 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(r9.length), Collection.class, "com.obric.memorydata.plugin");
        int r0 = 0;
        int r2 = r9.length;
    L21:
        if (r0 >= r2) goto L70;
        r14.add(INSTANCE.toJsonObject(r9[r0], r11, r13));
        r0 = r0 + 1;
    L70:
        return (List) ZeusTransformUtils.preCheckCast(r14, List.class, "com.obric.memorydata.plugin");
    L25:
        if (ZeusTransformUtils.instanceOf(r10, Collection.class) == false) goto L31;
        Iterable r15 = (Iterable) ZeusTransformUtils.preCheckCast(r10, Iterable.class, "com.obric.memorydata.plugin");
        r14 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r15, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r16 = r15.iterator();
    L28:
        if (r16.hasNext() == false) goto L70;
        r14.add(INSTANCE.toJsonObject(r16.next(), r11, r13));
        goto L28
    L31:
        if (ZeusTransformUtils.instanceOf(r10, Map.class) == false) goto L36;
        Iterable r17 = (Iterable) ZeusTransformUtils.preCheckCast(((Map) ZeusTransformUtils.preCheckCast(r10, Map.class, "com.obric.memorydata.plugin")).entrySet(), Iterable.class, "com.obric.memorydata.plugin");
        Map r18 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r17, 10)), 16)), Map.class, "com.obric.memorydata.plugin");
        Iterator r19 = r17.iterator();
    L34:
        if (r19.hasNext() == false) goto L72;
        Map.Entry r1 = (Map.Entry) ZeusTransformUtils.preCheckCast(r19.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        Pair r3 = TuplesKt.to(String.valueOf(r1.getKey()), INSTANCE.toJsonObject(r1.getValue(), r11, r13));
        r18.put(r3.getFirst(), r3.getSecond());
        goto L34
    L72:
        return r18;
    L36:
        int r4 = System.identityHashCode(r10);
        if (r13.contains(Integer.valueOf(r4)) == true) goto L39;
        r13.add(Integer.valueOf(r4));
        Map r5 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        Iterator r20 = ((Iterable) ZeusTransformUtils.preCheckCast(getAllFields(r10.getClass(), r11), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L42:
        if (r20.hasNext() == false) goto L54;
        Field r6 = (Field) ZeusTransformUtils.preCheckCast(r20.next(), Field.class, "com.obric.memorydata.plugin");
        r6.setAccessible(true);     // Catch: Exception -> L52
        Object r7 = r6.get(r10);     // Catch: Exception -> L52
        String r8 = r6.getName();     // Catch: Exception -> L52
        if (r6.isAnnotationPresent(a.class) == true) goto L47;
    L49:
        Object r21 = INSTANCE.toJsonObject(r7, r11, r13);     // Catch: Exception -> L52
    L50:
        r5.put(r8, r21);     // Catch: Exception -> L52
        goto L42
    L47:
        if (ZeusTransformUtils.instanceOf(r7, String.class) == false) goto L49;
        r21 = INSTANCE.parseJsonString((String) ZeusTransformUtils.preCheckCast(r7, String.class, "com.obric.memorydata.plugin"));     // Catch: Exception -> L52
    L52:
        e = move-exception;
        r5.put(r6.getName(), "[Error: " + e.getMessage() + ']');
        goto L42
    L54:
        r13.remove(Integer.valueOf(r4));
        return r5;
    L39:
        return "[Circular: " + Reflection.getOrCreateKotlinClass(r10.getClass()).getSimpleName() + ']';
    }

    public static /* synthetic */ String toPrettyJson$default(GsonUtil r0, Object r1, boolean r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = false;
    L6:
        return r0.toPrettyJson(r1, r2);
    }

    public final Type canonicalize(Type r2) {
        Type r1 = C$Gson$Types.canonicalize((Type) ZeusTransformUtils.wrapperContextForParams(r2, Type.class, "com.obric.memorydata.plugin"));
        Intrinsics.checkNotNullExpressionValue(r1, "canonicalize(...)");
        return r1;
    }

    public final Map<String, String> convertMap(String r8) {
        Object r7 = getGSON().fromJson(r8, new b().getType());     // Catch: Exception -> L5
        Intrinsics.checkNotNullExpressionValue(r7, "fromJson(...)");     // Catch: Exception -> L5
        return (Map) ZeusTransformUtils.preCheckCast(r7, Map.class, "com.obric.memorydata.plugin");
    L5:
        e = move-exception;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "json error :" + e, null, 4, null);
        if (AppContext.INSTANCE.isDebug() == false) goto L9;
        throw e;
    L9:
        return (Map) ZeusTransformUtils.preCheckCast(new HashMap(), Map.class, "com.obric.memorydata.plugin");
    }

    public final /* synthetic */ <T> T deepCopy(T r4) {
        String r5 = getGSON().toJson(r4);
        Gson r3 = getGSON();
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return (T) r3.fromJson(r5, (Class) ZeusTransformUtils.preCheckCast(Object.class, Class.class, "com.obric.memorydata.plugin"));
    }

    public final /* synthetic */ <T> T fromJson(JsonElement r7) {
        Intrinsics.checkNotNullParameter(r7, "json");
        Gson r6 = getGSON();     // Catch: Exception -> L5
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);     // Catch: Exception -> L5
        return (T) r6.fromJson(r7, (Class) ZeusTransformUtils.preCheckCast(Object.class, Class.class, "com.obric.memorydata.plugin"));
    L5:
        e = move-exception;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "json error : " + e, null, 4, null);
        if (AppContext.INSTANCE.isDebug() == true) goto L10;
        return null;
    L10:
        throw e;
    }

    public final /* synthetic */ <T> T fromJson(String r7) {
        Intrinsics.checkNotNullParameter(r7, "json");
        Gson r6 = getGSON();     // Catch: Exception -> L5
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);     // Catch: Exception -> L5
        return (T) r6.fromJson(r7, (Class) ZeusTransformUtils.preCheckCast(Object.class, Class.class, "com.obric.memorydata.plugin"));
    L5:
        e = move-exception;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "json error ：" + e, null, 4, null);
        return null;
    }

    public final /* synthetic */ <T> List<T> fromJsonArray(String r3) {
        if (r3 != null) goto L5;
        return null;
    L5:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L7;
        boolean r0 = true;
    L8:
        if (r0 == true) goto L11;
        r3 = null;
    L11:
        if (r3 == null) goto L15;
        Gson r2 = INSTANCE.getGSON();
        Intrinsics.needClassReification();
        return (List) ZeusTransformUtils.preCheckCast(r2.fromJson(r3, new c().getType()), List.class, "com.obric.memorydata.plugin");
    L15:
        return null;
    L7:
        r0 = false;
        goto L8
    }

    public final /* synthetic */ <T> T fromJsonByType(String r2) {
        Intrinsics.checkNotNullParameter(r2, "json");
        Gson r1 = getGSON();
        Intrinsics.needClassReification();
        return (T) r1.fromJson(r2, new d().getType());
    }

    public final Gson getGSON() {
        return (Gson) ZeusTransformUtils.preCheckCast(GSON$delegate.getValue(), Gson.class, "com.obric.memorydata.plugin");
    }

    public final JSONObject toJSONObject(Object r2) {
        Intrinsics.checkNotNullParameter(r2, "src");
        return new JSONObject(getGSON().toJson(r2));
    }

    public final String toJson(Object r2) {
        Intrinsics.checkNotNullParameter(r2, "src");
        String r1 = getGSON().toJson(r2);
        Intrinsics.checkNotNullExpressionValue(r1, "toJson(...)");
        return r1;
    }

    public final String toJson(Object r3, Type r4) {
        Type r5 = (Type) ZeusTransformUtils.wrapperContextForParams(r4, Type.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "src");
        Intrinsics.checkNotNullParameter(r5, "type");
        String r2 = getGSON().toJson(r3, r5);
        Intrinsics.checkNotNullExpressionValue(r2, "toJson(...)");
        return r2;
    }

    public final String toPrettyJson(Object r8, boolean r9) {
        if (r8 != null) goto L11;
        return "null";
    L11:
        String r10 = getPRETTY_GSON().toJson(toJsonObject(r8, r9, (Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.memorydata.plugin")));     // Catch: Exception -> L8
        Intrinsics.checkNotNull(r10);     // Catch: Exception -> L8
        return r10;
    L8:
        e = move-exception;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "prettyJson error: " + e, null, 4, null);
        String r11 = getPRETTY_GSON().toJson(r8);
        Intrinsics.checkNotNull(r11);
        return r11;
    }
}
