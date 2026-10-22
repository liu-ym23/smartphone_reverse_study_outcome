package com.bytedance.rpc.serialize;

import com.bytedance.rpc.RpcService;
import com.bytedance.rpc.annotation.RpcField;
import com.bytedance.rpc.annotation.RpcFieldFrom;
import com.bytedance.rpc.annotation.RpcFieldModify;
import com.bytedance.rpc.annotation.RpcFieldTo;
import com.bytedance.rpc.callback.RpcInvokeInterceptor;
import com.bytedance.rpc.internal.TypeUtils;
import com.bytedance.rpc.transport.TransportInput;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class SerializeManager {
    private static final Pattern CHARSET = null;
    private String ACCEPT;
    private boolean mAllowResolvedFactory;
    private final Map<SerializeType, SerializeFactory> mSerializerFactory;

    static {
        CHARSET = Pattern.compile("\\Wcharset=([^\\s;]+)", 2);
    }

    public SerializeManager() {
        this.ACCEPT = "";
        this.mSerializerFactory = new HashMap(2);
        this.mAllowResolvedFactory = true;
    }

    private static Object convertIfEnum(Object r3) {
        if (ZeusTransformUtils.instanceOf(r3, Enum.class) == false) goto L13;
        SerializedName r0 = (SerializedName) ZeusTransformUtils.preCheckCast(r3.getClass().getField(String.valueOf(r3)).getAnnotation(SerializedName.class), SerializedName.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L7;
        String r1 = null;
    L8:
        if (r1 != null) goto L10;
        return r3;
    L10:
        if (r1.length() > 0) goto L12;
        return r3;
    L12:
        return r1;
    L7:
        r1 = r0.value();
        goto L8
    L13:
        return r3;
    }

    private static Object convertNumber(Type r2, String r3) {
        Type r4 = (Type) ZeusTransformUtils.wrapperContextForParams(r2, Type.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r4, Class.class) == false) goto L42;
        Class<?> r5 = (Class) ZeusTransformUtils.preCheckCast(r4, Class.class, "com.obric.memorydata.plugin");
    L37:
        e = move-exception;
        e.printStackTrace();
        return null;
    L6:
        if (Integer.class.isAssignableFrom(r5) == true) goto L36;
        if (Integer.TYPE.isAssignableFrom(r5) == true) goto L36;
        if (Long.class.isAssignableFrom(r5) == true) goto L34;
        if (Long.TYPE.isAssignableFrom(r5) == true) goto L34;
        if (Float.class.isAssignableFrom(r5) == true) goto L32;
        if (Float.TYPE.isAssignableFrom(r5) == true) goto L32;
        if (Double.class.isAssignableFrom(r5) == true) goto L30;
        if (Double.TYPE.isAssignableFrom(r5) == true) goto L30;
        if (BigDecimal.class.isAssignableFrom(r5) == true) goto L28;
        return null;
    L28:
        return new BigDecimal(r3);
    L30:
        return Double.valueOf(Double.parseDouble(r3));
    L32:
        return Float.valueOf(Float.parseFloat(r3));
    L34:
        return Long.valueOf(Long.parseLong(r3));
    L36:
        return Integer.valueOf(Integer.parseInt(r3));
    L42:
        return null;
    }

    private SerializeFactory createFactory(String r2) {
        Object r1 = TypeUtils.instance(r2);
        if (ZeusTransformUtils.instanceOf(r1, SerializeFactory.class) == true) goto L7;
        return null;
    L7:
        return (SerializeFactory) ZeusTransformUtils.preCheckCast(r1, SerializeFactory.class, "com.obric.memorydata.plugin");
    }

    public static void dump(Object r9, Map<String, String> r10, Map<String, String> r11, Map<String, Object> r12) {
        Map r13 = (Map) ZeusTransformUtils.wrapperContextForParams(r10, Map.class, "com.obric.memorydata.plugin");
        Map r14 = (Map) ZeusTransformUtils.wrapperContextForParams(r11, Map.class, "com.obric.memorydata.plugin");
        Map r15 = (Map) ZeusTransformUtils.wrapperContextForParams(r12, Map.class, "com.obric.memorydata.plugin");
        if (r9 == null) goto L60;
        if (r13 != null) goto L8;
        if (r14 != null) goto L8;
        if (r15 != null) goto L8;
        return;
    L8:
        Field[] r0 = r9.getClass().getDeclaredFields();
        if (r0 != null) goto L11;
        return;
    L11:
        if (r0.length <= 0) goto L75;
        int r2 = r0.length;
        int r3 = 0;
    L13:
        if (r3 >= r2) goto L77;
        Field r4 = r0[r3];
        if (Modifier.isStatic(r4.getModifiers()) == true) goto L59;
        RpcField r5 = (RpcField) ZeusTransformUtils.preCheckCast(r4.getAnnotation(RpcField.class), RpcField.class, "com.obric.memorydata.plugin");
        RpcFieldTo r6 = (RpcFieldTo) ZeusTransformUtils.preCheckCast(r4.getAnnotation(RpcFieldTo.class), RpcFieldTo.class, "com.obric.memorydata.plugin");
        if (r5 != null) goto L21;
        if (r6 != null) goto L20;
        FieldType r7 = null;
    L22:
        if (r7 == null) goto L59;
        r4.setAccessible(true);     // Catch: Exception -> L57
        Object r8 = r4.get(r9);     // Catch: Exception -> L57
        if (r8 == null) goto L59;
        if (r7 == FieldType.HEADER) goto L43;
        if (r7 == FieldType.QUERY) goto L43;
        if (r7 != FieldType.BODY) goto L59;
        if (r15 == null) goto L59;
        SerializedName r16 = (SerializedName) ZeusTransformUtils.preCheckCast(r4.getAnnotation(SerializedName.class), SerializedName.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L57
        if (r16 != null) goto L40;
        String r17 = r4.getName();     // Catch: Exception -> L57
    L41:
        r15.put(r17, convertIfEnum(r8));     // Catch: Exception -> L57
        goto L59
    L40:
        r17 = r16.value();     // Catch: Exception -> L57
    L43:
        if (r7 != FieldType.HEADER) goto L45;
        Map r18 = r13;
    L46:
        if (r18 == null) goto L59;
        if (ZeusTransformUtils.instanceOf(r8, Map.class) == false) goto L51;
        dumpMap(r18, (Map) ZeusTransformUtils.preCheckCast(r8, Map.class, "com.obric.memorydata.plugin"));     // Catch: Exception -> L57
        goto L59
    L51:
        SerializedName r19 = (SerializedName) ZeusTransformUtils.preCheckCast(r4.getAnnotation(SerializedName.class), SerializedName.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L57
        if (r19 != null) goto L54;
        String r20 = r4.getName();     // Catch: Exception -> L57
    L55:
        r18.put(r20, String.valueOf(convertIfEnum(r8)));     // Catch: Exception -> L57
        goto L59
    L54:
        r20 = r19.value();     // Catch: Exception -> L57
        goto L55
    L45:
        r18 = r14;
    L57:
        e = move-exception;
        e.printStackTrace();
        goto L59
    L20:
        r7 = r6.value();
        goto L22
    L21:
        r7 = r5.value();
    L59:
        r3 = r3 + 1;
        goto L13
    L77:
        return;
    L75:
        return;
    }

    private static void dumpJSON(Map<String, String> r4, JSONObject r5) {
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
        if (r5 != null) goto L5;
        return;
    L5:
        if (r5.length() == 0) goto L22;
        Iterator<String> r0 = r5.keys();
    L9:
        if (r0.hasNext() == false) goto L23;
        String r2 = (String) ZeusTransformUtils.preCheckCast(r0.next(), String.class, "com.obric.memorydata.plugin");
        Object r3 = r5.opt(r2);
        if (r2 == null) goto L9;
        if (r3 == null) goto L9;
        r6.put(r2, String.valueOf(r3));
        goto L9
    L23:
        return;
    }

    private static void dumpJson(Map<String, String> r4, JsonObject r5) {
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
        Set<Map.Entry<String, JsonElement>> r7 = r5.entrySet();
        if (r7 != null) goto L5;
        return;
    L5:
        if (r7.size() <= 0) goto L21;
        Iterator<Map.Entry<String, JsonElement>> r8 = r7.iterator();
    L8:
        if (r8.hasNext() == false) goto L22;
        Map.Entry r0 = (Map.Entry) ZeusTransformUtils.preCheckCast(r8.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        String r2 = (String) ZeusTransformUtils.preCheckCast(r0.getKey(), String.class, "com.obric.memorydata.plugin");
        JsonElement r1 = (JsonElement) ZeusTransformUtils.preCheckCast(r0.getValue(), JsonElement.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L8;
        if (r1 == null) goto L8;
        r6.put(r2, r1.getAsString());
        goto L8
    L22:
        return;
    }

    private static void dumpMap(Map<String, String> r3, Map<?, ?> r4) {
        Map r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
        if (r6.isEmpty() == true) goto L11;
        Iterator r7 = r6.entrySet().iterator();
    L6:
        if (r7.hasNext() == false) goto L19;
        Map.Entry r0 = (Map.Entry) ZeusTransformUtils.preCheckCast(r7.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        Object r2 = r0.getKey();
        Object r1 = r0.getValue();
        if (r2 == null) goto L6;
        if (r1 == null) goto L6;
        r5.put(String.valueOf(r2), String.valueOf(r1));
        goto L6
    L19:
        return;
    }

    public static Map<String, String> dumpQuery(Object r14, Map<String, String> r15) {
        Map<String, String> r16 = (Map) ZeusTransformUtils.wrapperContextForParams(r15, Map.class, "com.obric.memorydata.plugin");
        if (r16 != null) goto L6;
        r16 = new HashMap(8);
    L6:
        if ((r14 instanceof Object[]) == false) goto L8;
        Object[] r17 = (Object[]) ZeusTransformUtils.preCheckCast((Object[]) ZeusTransformUtils.preCheckCast(r14, Object[].class, "com.obric.memorydata.plugin"), Object[].class, "com.obric.memorydata.plugin");
    L9:
        int r0 = r17.length;
        int r4 = 0;
    L10:
        if (r4 >= r0) goto L65;
        Object r5 = r17[r4];
        if (r5 == null) goto L64;
        Class<?> r6 = r5.getClass();
        if (Map.class.isAssignableFrom(r6) == false) goto L18;
        dumpMap(r16, (Map) ZeusTransformUtils.preCheckCast(r5, Map.class, "com.obric.memorydata.plugin"));
        goto L64
    L18:
        if (JsonObject.class.isAssignableFrom(r6) == false) goto L21;
        dumpJson(r16, (JsonObject) ZeusTransformUtils.preCheckCast(r5, JsonObject.class, "com.obric.memorydata.plugin"));
        goto L64
    L21:
        if (JSONObject.class.isAssignableFrom(r6) == false) goto L23;
        dumpJSON(r16, (JSONObject) ZeusTransformUtils.preCheckCast(r5, JSONObject.class, "com.obric.memorydata.plugin"));
        goto L64
    L23:
        Field[] r7 = r5.getClass().getDeclaredFields();
        if (r7 == null) goto L64;
        if (r7.length <= 0) goto L64;
        int r8 = r7.length;
        int r9 = 0;
    L28:
        if (r9 >= r8) goto L64;
        Field r10 = r7[r9];
        if (Modifier.isStatic(r10.getModifiers()) == true) goto L63;
        if (r10.getAnnotation(RpcFieldTo.class) != null) goto L63;
        if (r10.getAnnotation(RpcField.class) != null) goto L63;
        r10.setAccessible(true);
        Object r11 = r10.get(r5);
        if (r11 == null) goto L63;
        if (ZeusTransformUtils.instanceOf(r11, Map.class) == false) goto L43;
        dumpMap(r16, (Map) ZeusTransformUtils.preCheckCast(r11, Map.class, "com.obric.memorydata.plugin"));
        goto L63
    L43:
        if (ZeusTransformUtils.instanceOf(r11, List.class) == false) goto L57;
        SerializedName r12 = (SerializedName) ZeusTransformUtils.preCheckCast(r10.getAnnotation(SerializedName.class), SerializedName.class, "com.obric.memorydata.plugin");
        if (r12 != null) goto L47;
        String r13 = r10.getName();
    L48:
        StringBuilder r18 = new StringBuilder();
        Iterator r19 = ((List) ZeusTransformUtils.preCheckCast(r11, List.class, "com.obric.memorydata.plugin")).iterator();
    L50:
        if (r19.hasNext() == false) goto L54;
        Object r110 = r19.next();
        if (r110 == null) goto L50;
        r18.append(convertIfEnum(r110).toString()).append(",");
        goto L50
    L54:
        String r111 = r18.toString();
        if (r111.length() <= 0) goto L62;
        r111 = r111.substring(0, r111.length() - 1);
    L62:
        r16.put(r13, r111);
        goto L63
    L47:
        r13 = r12.value();
        goto L48
    L57:
        SerializedName r112 = (SerializedName) ZeusTransformUtils.preCheckCast(r10.getAnnotation(SerializedName.class), SerializedName.class, "com.obric.memorydata.plugin");
        if (r112 != null) goto L60;
        r13 = r10.getName();
    L61:
        r111 = String.valueOf(convertIfEnum(r11));
        goto L62
    L60:
        r13 = r112.value();
    L63:
        r9 = r9 + 1;
    L64:
        r4 = r4 + 1;
        goto L10
    L65:
        return r16;
    L8:
        r17 = new Object[]{r14};
        goto L9
    }

    public static void fillResult(Object r8, Map<String, String> r9) {
        Map r10 = (Map) ZeusTransformUtils.wrapperContextForParams(r9, Map.class, "com.obric.memorydata.plugin");
        if (r8.getClass().getAnnotation(RpcFieldModify.class) != null) goto L5;
        return;
    L5:
        Field[] r0 = r8.getClass().getDeclaredFields();
        if (r0 != null) goto L8;
        return;
    L8:
        if (r0.length <= 0) goto L49;
        int r2 = r0.length;
        int r3 = 0;
    L10:
        if (r3 >= r2) goto L50;
        Field r4 = r0[r3];
        if (Modifier.isStatic(r4.getModifiers()) == true) goto L37;
        RpcField r5 = (RpcField) ZeusTransformUtils.preCheckCast(r4.getAnnotation(RpcField.class), RpcField.class, "com.obric.memorydata.plugin");
        RpcFieldFrom r6 = (RpcFieldFrom) ZeusTransformUtils.preCheckCast(r4.getAnnotation(RpcFieldFrom.class), RpcFieldFrom.class, "com.obric.memorydata.plugin");
        if (r5 != null) goto L18;
        if (r6 != null) goto L17;
        FieldType r7 = null;
    L19:
        if (r7 == null) goto L37;
        if (r7 != FieldType.HEADER) goto L37;
        SerializedName r11 = (SerializedName) ZeusTransformUtils.preCheckCast(r4.getAnnotation(SerializedName.class), SerializedName.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L35
        if (r11 != null) goto L26;
        String r12 = r4.getName();     // Catch: Exception -> L35
    L27:
        String r13 = (String) ZeusTransformUtils.preCheckCast(r10.get(r12), String.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L35
        if (r13 == null) goto L37;
        r4.setAccessible(true);     // Catch: Exception -> L35
        Object r14 = r13;
        if (CharSequence.class.isAssignableFrom(r4.getType()) == false) goto L32;
    L31:
        r4.set(r8, r14);     // Catch: Exception -> L35
        goto L37
    L32:
        Object r15 = convertNumber(r4.getType(), r13);     // Catch: Exception -> L35
        r14 = r15;
        if (r15 == null) goto L37;
    L26:
        r12 = r11.value();     // Catch: Exception -> L35
    L35:
        e = move-exception;
        e.printStackTrace();
        goto L37
    L17:
        r7 = r6.value();
        goto L19
    L18:
        r7 = r5.value();
    L37:
        r3 = r3 + 1;
        goto L10
    L50:
        return;
    }

    public static String parseCharset(String r1, String r2) {
        Matcher r3 = CHARSET.matcher(r1);
        if (r3.find() == true) goto L5;
        return r2;
    L5:
        return r3.group(1).replaceAll("[\"\\\\]", "");
    }

    private void resolveFactoryFromDependencies() {
        if (this.mSerializerFactory.get(SerializeType.JSON) != null) goto L6;
        registerSerializeFactory(createFactory("com.bytedance.rpc.serialize.JsonSerializeFactory"));
    L6:
        if (this.mSerializerFactory.get(SerializeType.PB) != null) goto L13;
        SerializeFactory r0 = createFactory("com.bytedance.rpc.serialize.PbSerializeFactory");
        SerializeFactory r2 = createFactory("com.bytedance.rpc.serialize.WireSerializeFactory");
        if (r0 == null) goto L11;
        if (r2 == null) goto L11;
        registerSerializeFactory(new SerializeFactoryContainer(r0.getSerializeType(), new SerializeFactory[]{r0, r2}));
    L11:
        registerSerializeFactory(r0);
        registerSerializeFactory(r2);
    L13:
        if (this.mSerializerFactory.get(SerializeType.THRIFT) != null) goto L15;
        registerSerializeFactory(createFactory("com.bytedance.rpc.serialize.ThriftSerializeFactory"));
    L15:
        Object r1 = TypeUtils.instance("com.bytedance.rpc.rxjava.RxJavaInvokeInterceptor");
        if (ZeusTransformUtils.instanceOf(r1, RpcInvokeInterceptor.class) == false) goto L18;
        RpcService.addRpcInvokeInterceptor((RpcInvokeInterceptor) ZeusTransformUtils.preCheckCast(r1, RpcInvokeInterceptor.class, "com.obric.memorydata.plugin"));
    L18:
        this.mAllowResolvedFactory = false;
    }

    public void clear() {
        Map<SerializeType, SerializeFactory> r0 = this.mSerializerFactory;
        monitor-enter(r0);
        this.mAllowResolvedFactory = false;     // Catch: Throwable -> L8
        this.mSerializerFactory.clear();     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public TransportInput createTransportInput(final byte[] r2, final SerializeType r3) {
        return new AnonymousClass1(this, r3, r2);
    }

    public String getAcceptContentTypes() {
        if (this.mAllowResolvedFactory == false) goto L15;
        Map<SerializeType, SerializeFactory> r0 = this.mSerializerFactory;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (this.mAllowResolvedFactory == false) goto L9;
        resolveFactoryFromDependencies();     // Catch: Throwable -> L11
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L11
    L15:
        return this.ACCEPT;
    }

    public SerializeFactory getSerializeFactory(SerializeType r6) {
        if (r6 != null) goto L5;
        return null;
    L5:
        Map<SerializeType, SerializeFactory> r1 = this.mSerializerFactory;
        monitor-enter(r1);
        SerializeFactory r2 = (SerializeFactory) ZeusTransformUtils.preCheckCast(this.mSerializerFactory.get(r6), SerializeFactory.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L18
        if (r2 == null) goto L12;
        monitor-exit(r1);     // Catch: Throwable -> L18
        return r2;
    L12:
        if (this.mAllowResolvedFactory == false) goto L16;
        resolveFactoryFromDependencies();     // Catch: Throwable -> L18
        SerializeFactory r5 = (SerializeFactory) ZeusTransformUtils.preCheckCast(this.mSerializerFactory.get(r6), SerializeFactory.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L18
        monitor-exit(r1);     // Catch: Throwable -> L18
        return r5;
    L16:
        monitor-exit(r1);     // Catch: Throwable -> L18
        return null;
    L18:
        th = move-exception;
        throw th;
    }

    public SerializeType[] getSupportedSerializeType() {
        Map<SerializeType, SerializeFactory> r0 = this.mSerializerFactory;
        monitor-enter(r0);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (this.mAllowResolvedFactory == false) goto L7;
        resolveFactoryFromDependencies();     // Catch: Throwable -> L12
    L7:
        int r1 = this.mSerializerFactory.size();     // Catch: Throwable -> L12
        SerializeType[] r2 = new SerializeType[r1];     // Catch: Throwable -> L12
        if (r1 <= 0) goto L10;
        this.mSerializerFactory.keySet().toArray(r2);     // Catch: Throwable -> L12
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L12
        return r2;
    }

    public boolean isSerializeSupported(SerializeType r3) {
        Map<SerializeType, SerializeFactory> r0 = this.mSerializerFactory;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (this.mAllowResolvedFactory == false) goto L7;
        resolveFactoryFromDependencies();     // Catch: Throwable -> L10
    L7:
        boolean r2 = this.mSerializerFactory.containsKey(r3);     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r2;
    }

    public SerializeType parserDeserializerType(String r7, Type r8, SerializeType r9) {
        Type r6 = (Type) ZeusTransformUtils.wrapperContextForParams(r8, Type.class, "com.obric.memorydata.plugin");
        SerializeType r10 = SerializeType.parser(r7);
        if (r10 != null) goto L13;
        if (r7 == null) goto L13;
        String[] r0 = SerializeType.getTypeAndSubType(r7);
        if (r0.length <= 0) goto L13;
        SerializeType[] r1 = SerializeType.values();
        int r2 = r1.length;
        int r3 = 0;
    L8:
        if (r3 >= r2) goto L13;
        SerializeType r4 = r1[r3];
        if (Arrays.equals(r0, r4.getTypeAndSubType()) == true) goto L11;
        r3 = r3 + 1;
        goto L8
    L11:
        r10 = r4;
    L13:
        if (r10 == null) goto L15;
    L21:
        if (r10 != null) goto L24;
        return r9;
    L24:
        return r10;
    L15:
        if (r6 != String.class) goto L21;
        if (r7.contains(IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT) == false) goto L19;
    L20:
        r10 = SerializeType.JSON;
        goto L21
    L19:
        if (r7.contains("html") == false) goto L21;
        goto L20
    }

    public void registerSerializeFactory(SerializeFactory r6) {
        SerializeFactory r7 = (SerializeFactory) ZeusTransformUtils.wrapperContextForParams(r6, SerializeFactory.class, "com.obric.memorydata.plugin");
        if (r7 == null) goto L23;
        SerializeType r0 = r7.getSerializeType();
        if (r0 == null) goto L26;
        Map<SerializeType, SerializeFactory> r1 = this.mSerializerFactory;
        monitor-enter(r1);
    L20:
        th = move-exception;
        throw th;
    L9:
        if (((SerializeFactory) ZeusTransformUtils.preCheckCast(this.mSerializerFactory.put(r0, r7), SerializeFactory.class, "com.obric.memorydata.plugin")) != null) goto L18;
        String r8 = this.ACCEPT;     // Catch: Throwable -> L20
        if (r8 != null) goto L13;
    L17:
        String r9 = r0.getContentType();     // Catch: Throwable -> L20
    L16:
        this.ACCEPT = r9;     // Catch: Throwable -> L20
        goto L18
    L13:
        if (r8.length() == 0) goto L17;
        r9 = String.format("%s,%s", new Object[]{this.ACCEPT, r0.getContentType()});     // Catch: Throwable -> L20
    L18:
        monitor-exit(r1);     // Catch: Throwable -> L20
        return;
    L26:
        return;
    }

    public void removeSerializeFactory(SerializeType r6) {
        if (r6 == null) goto L23;
        Map<SerializeType, SerializeFactory> r0 = this.mSerializerFactory;
        monitor-enter(r0);
    L20:
        th = move-exception;
        throw th;
    L6:
        if (this.mAllowResolvedFactory == false) goto L9;
        resolveFactoryFromDependencies();     // Catch: Throwable -> L20
    L9:
        if (((SerializeFactory) ZeusTransformUtils.preCheckCast(this.mSerializerFactory.remove(r6), SerializeFactory.class, "com.obric.memorydata.plugin")) == null) goto L18;
        StringBuilder r7 = new StringBuilder(this.ACCEPT.length());     // Catch: Throwable -> L20
        Iterator<SerializeType> r1 = this.mSerializerFactory.keySet().iterator();     // Catch: Throwable -> L20
    L12:
        if (r1.hasNext() == false) goto L15;
        r7.append(((SerializeType) ZeusTransformUtils.preCheckCast(r1.next(), SerializeType.class, "com.obric.memorydata.plugin")).getContentType()).append(',');     // Catch: Throwable -> L20
        goto L12
    L15:
        if (r7.length() <= 0) goto L17;
        r7.deleteCharAt(r7.length() - 1);     // Catch: Throwable -> L20
    L17:
        this.ACCEPT = r7.toString();     // Catch: Throwable -> L20
    L18:
        monitor-exit(r0);     // Catch: Throwable -> L20
        return;
    }
}
