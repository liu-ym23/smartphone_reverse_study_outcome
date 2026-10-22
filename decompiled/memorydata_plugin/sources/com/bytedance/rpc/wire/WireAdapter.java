package com.bytedance.rpc.wire;

import com.bytedance.rpc.internal.TypeUtils;
import com.bytedance.rpc.log.Logger;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public class WireAdapter {
    public static final ProtoAdapter<byte[]> BYTE_ARRAY = null;
    private static boolean sAllowModifyCollections = true;
    private static final ThreadLocal<Map<Object, Integer>> sEncodeSizeMap = null;
    private static final Map<String, ProtoAdapter<?>> sKeyAdapter = null;
    private static final Map<Type, ProtoAdapter<?>> sTypeAdapter = null;

    static {
        sEncodeSizeMap = new ThreadLocal();
        sTypeAdapter = new ConcurrentHashMap(128);
        sKeyAdapter = new ConcurrentHashMap(8);
        final FieldEncoding r1 = FieldEncoding.LENGTH_DELIMITED;
        final Class<byte[]> r2 = byte[].class;
        BYTE_ARRAY = new AnonymousClass1(r1, r2);
    }

    public WireAdapter() {
    }

    private static ProtoAdapter<?> basicTypeAdapter(Type r2) {
        Type r3 = (Type) ZeusTransformUtils.wrapperContextForParams(r2, Type.class, "com.obric.memorydata.plugin");
        if (r3 != String.class) goto L7;
        return ProtoAdapter.STRING;
    L7:
        if (r3 == Integer.class) goto L46;
        if (r3 == Integer.TYPE) goto L46;
        if (r3 == Boolean.class) goto L44;
        if (r3 == Boolean.TYPE) goto L44;
        if (r3 == Long.class) goto L42;
        if (r3 == Long.TYPE) goto L42;
        if (r3 == Float.class) goto L40;
        if (r3 == Float.TYPE) goto L40;
        if (r3 == Double.class) goto L38;
        if (r3 == Double.TYPE) goto L38;
        if (r3 == byte[].class) goto L34;
        return null;
    L34:
        return BYTE_ARRAY;
    L38:
        return ProtoAdapter.DOUBLE;
    L40:
        return ProtoAdapter.FLOAT;
    L42:
        return ProtoAdapter.INT64;
    L44:
        return ProtoAdapter.BOOL;
    L46:
        return ProtoAdapter.INT32;
    }

    private static ProtoAdapter<?> collectionTypeAdapter(Type r5) {
        Type r6 = (Type) ZeusTransformUtils.wrapperContextForParams(r5, Type.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r6, ParameterizedType.class) == false) goto L14;
        ParameterizedType r7 = (ParameterizedType) ZeusTransformUtils.preCheckCast(r6, ParameterizedType.class, "com.obric.memorydata.plugin");
        Type[] r0 = r7.getActualTypeArguments();
        Class r8 = (Class) ZeusTransformUtils.preCheckCast(r7.getRawType(), Class.class, "com.obric.memorydata.plugin");
        if (List.class.isAssignableFrom(r8) == false) goto L9;
        return getAdapter(null, r0[0]);
    L9:
        if (r0.length != 2) goto L14;
        if (Map.class.isAssignableFrom(r8) == false) goto L14;
        return ProtoAdapter.newMapAdapter(getAdapter(null, r0[0]), getAdapter(null, r0[1]));
    L14:
        return null;
    }

    private static ProtoAdapter<?> generalTypeAdapter(Class<?> r3) {
        return (ProtoAdapter) ZeusTransformUtils.preCheckCast(r3.getField("ADAPTER").get(null), ProtoAdapter.class, "com.obric.memorydata.plugin");
    L4:
        Logger.w(String.format("can not find ADAPTER in %s", new Object[]{r3}));
        if (Enum.class.isAssignableFrom(r3) == false) goto L13;
        if (WireEnum.class.isAssignableFrom(r3) == false) goto L11;
        return ProtoAdapter.newEnumAdapter(r3);
    L11:
        return new EnumProtoAdapter(r3);
    L13:
        if (Message.class.isAssignableFrom(r3) == false) goto L17;
        return ProtoAdapter.newMessageAdapter(r3);
    L17:
        return RuntimeGeneralAdapter.create(r3);
    }

    public static <M> ProtoAdapter<M> getAdapter(Class<M> r1) {
        return (ProtoAdapter<M>) getAdapter(null, r1);
    }

    public static ProtoAdapter<?> getAdapter(String r3, Type r4) {
        Type r5 = (Type) ZeusTransformUtils.wrapperContextForParams(r4, Type.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L5;
    L12:
        ProtoAdapter<?> r0 = null;
    L13:
        if (r5 == null) goto L18;
        ProtoAdapter<?> r1 = (ProtoAdapter) ZeusTransformUtils.preCheckCast(sTypeAdapter.get(r5), ProtoAdapter.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L17;
        return r1;
    L17:
        r0 = loadAdapterByType(r5);
    L18:
        if (r0 != null) goto L20;
        Logger.w(String.format("can't create adapter with type %s,adapter key=%s", new Object[]{r5, r3}));
    L20:
        return r0;
    L5:
        if (r3.isEmpty() == true) goto L12;
        ProtoAdapter<?> r2 = (ProtoAdapter) ZeusTransformUtils.preCheckCast(sKeyAdapter.get(r3), ProtoAdapter.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L9;
        return r2;
    L9:
        r0 = loadAdapterByKey(r3);
        if (r0 == null) goto L13;
        return r0;
    }

    public static Map<Object, Integer> getEncodeSizeMap() {
        ThreadLocal<Map<Object, Integer>> r0 = sEncodeSizeMap;
        Map<Object, Integer> r1 = (Map) ZeusTransformUtils.preCheckCast(r0.get(), Map.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L6;
        HashMap r2 = new HashMap();
        r0.set(r2);
        return r2;
    L6:
        return r1;
    }

    public static ProtoAdapter<?> getMapAdapter(Type r7, String r8, String r9) {
        Type r10 = (Type) ZeusTransformUtils.wrapperContextForParams(r7, Type.class, "com.obric.memorydata.plugin");
        Map<Type, ProtoAdapter<?>> r0 = sTypeAdapter;
        ProtoAdapter<?> r2 = (ProtoAdapter) ZeusTransformUtils.preCheckCast(r0.get(r10), ProtoAdapter.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L5;
        return r2;
    L5:
        ProtoAdapter<?> r3 = null;
        if (ZeusTransformUtils.instanceOf(r10, ParameterizedType.class) == false) goto L12;
        ParameterizedType r4 = (ParameterizedType) ZeusTransformUtils.preCheckCast(r10, ParameterizedType.class, "com.obric.memorydata.plugin");
        Type[] r5 = r4.getActualTypeArguments();
        if (r5.length != 2) goto L12;
        if (Map.class.isAssignableFrom((Class) ZeusTransformUtils.preCheckCast(r4.getRawType(), Class.class, "com.obric.memorydata.plugin")) == false) goto L12;
        r3 = getAdapter(r8, r5[0]);
        ProtoAdapter<?> r11 = getAdapter(r9, r5[1]);
    L13:
        if (r3 == null) goto L18;
        if (r11 == null) goto L18;
        ProtoAdapter<?> r12 = ProtoAdapter.newMapAdapter(r3, r11);
        r0.put(r10, r12);
        return r12;
    L18:
        throw new RuntimeException("map field must have parameterized type , for " + r10);
    L12:
        r11 = null;
        goto L13
    }

    public static boolean isAllowModifyCollections() {
        return sAllowModifyCollections;
    }

    private static ProtoAdapter<?> loadAdapterByKey(String r6) {
        ProtoAdapter<?> r4 = null;
        int r1 = r6.indexOf(35);     // Catch: Exception -> L5
        String r5 = r6.substring(0, r1);     // Catch: Exception -> L5
        r4 = (ProtoAdapter) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.forName(r5, "com.obric.memorydata.plugin").getField(r6.substring(r1 + 1)).get(null), ProtoAdapter.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L5
    L6:
        if (r4 == null) goto L8;
        sKeyAdapter.put(r6, r4);
    L8:
        return r4;
    L5:
        Logger.w(String.format("can not find ProtoAdapter with %s", new Object[]{r6}));
        goto L6
    }

    private static ProtoAdapter<?> loadAdapterByType(Type r2) {
        Type r3 = (Type) ZeusTransformUtils.wrapperContextForParams(r2, Type.class, "com.obric.memorydata.plugin");
        ProtoAdapter<?> r0 = basicTypeAdapter(r3);
        if (r0 == null) goto L6;
    L4:
        sTypeAdapter.put(r3, r0);
        return r0;
    L6:
        r0 = collectionTypeAdapter(r3);
        if (r0 != null) goto L4;
        r0 = generalTypeAdapter(TypeUtils.getRawType(r3));
        if (r0 != null) goto L4;
        return null;
    }
}
