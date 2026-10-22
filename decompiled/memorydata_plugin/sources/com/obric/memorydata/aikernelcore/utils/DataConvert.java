package com.obric.memorydata.aikernelcore.utils;

import android.os.Bundle;
import android.os.Parcelable;
import com.bytedance.crash.entity.EventBody;
import com.obric.aikernel.sdk.ext.BundleExtKt;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u000b\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J \u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0005H\u0002J \u0010\u000f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u0005H\u0002J\"\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0014\u001a\u00020\rH\u0002J\"\u0010\u0010\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0014\u001a\u00020\u0007H\u0002J\u0012\u0010\u0015\u001a\u00020\u00072\b\u0010\u0016\u001a\u0004\u0018\u00010\u0005H\u0002J\u0018\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u0005H\u0003J\u0012\u0010\u001a\u001a\u00020\u000b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0005H\u0003J\u0018\u0010\u001b\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0005H\u0003¨\u0006\u001d"}, d2 = {"Lcom/obric/memorydata/aikernelcore/utils/DataConvert;", "", "<init>", "()V", "jobj2Bundle", "Landroid/os/Bundle;", "jsonObject", "Lorg/json/JSONObject;", "jarr2Bundle", "", "key", "", "obj", "Lorg/json/JSONArray;", "bundle", "jany2Bundle", "setJson", "idx", "", EventBody.KEY_VALUE, "json", "bundle2Json", "args", "jsonStr2Bundle", "retVal", "retObj", "bundle2JsonStr", "convertOldSigArgs", "ctx", "aikernel_core_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class DataConvert {
    public static final DataConvert INSTANCE = null;

    static {
        INSTANCE = new DataConvert();
    }

    private DataConvert() {
    }

    private final JSONObject bundle2Json(Bundle r6) {
        JSONObject r0 = new JSONObject();
        if (r6 != null) goto L5;
        return r0;
    L5:
        Iterator<String> r1 = r6.keySet().iterator();
    L7:
        if (r1.hasNext() == false) goto L9;
        String r2 = (String) ZeusTransformUtils.preCheckCast(r1.next(), String.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNull(r2);
        setJson(r2, r6.get(r2), r0);
        goto L7
    L9:
        return r0;
    }

    @com.obric.aee.utils.a
    private final String bundle2JsonStr(Bundle r1) {
        String r0 = bundle2Json(r1).toString();
        Intrinsics.checkNotNullExpressionValue(r0, "toString(...)");
        return r0;
    }

    @com.obric.aee.utils.a
    private final void convertOldSigArgs(Bundle r2, Bundle r3) {
        String r4 = r2.getString("_input");
        if (r4 != null) goto L5;
        r4 = "{}";
    L5:
        jsonStr2Bundle(r4, r3);
    }

    private final void jany2Bundle(String r3, Object r4, Bundle r5) {
        if (ZeusTransformUtils.instanceOf(r4, String.class) == false) goto L6;
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type kotlin.String");
        r5.putString(r3, (String) ZeusTransformUtils.preCheckCast(r4, String.class, "com.obric.memorydata.plugin"));
        return;
    L6:
        if (ZeusTransformUtils.instanceOf(r4, Integer.class) == false) goto L9;
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type kotlin.Int");
        r5.putInt(r3, ((Integer) ZeusTransformUtils.preCheckCast(r4, Integer.class, "com.obric.memorydata.plugin")).intValue());
        return;
    L9:
        if (ZeusTransformUtils.instanceOf(r4, Long.class) == false) goto L12;
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type kotlin.Long");
        r5.putLong(r3, ((Long) ZeusTransformUtils.preCheckCast(r4, Long.class, "com.obric.memorydata.plugin")).longValue());
        return;
    L12:
        if (ZeusTransformUtils.instanceOf(r4, Boolean.class) == false) goto L15;
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type kotlin.Boolean");
        r5.putBoolean(r3, ((Boolean) ZeusTransformUtils.preCheckCast(r4, Boolean.class, "com.obric.memorydata.plugin")).booleanValue());
        return;
    L15:
        if (ZeusTransformUtils.instanceOf(r4, Float.class) == false) goto L18;
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type kotlin.Float");
        r5.putFloat(r3, ((Float) ZeusTransformUtils.preCheckCast(r4, Float.class, "com.obric.memorydata.plugin")).floatValue());
        return;
    L18:
        if (ZeusTransformUtils.instanceOf(r4, Double.class) == false) goto L21;
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type kotlin.Double");
        r5.putDouble(r3, ((Double) ZeusTransformUtils.preCheckCast(r4, Double.class, "com.obric.memorydata.plugin")).doubleValue());
        return;
    L21:
        if (ZeusTransformUtils.instanceOf(r4, JSONObject.class) == false) goto L24;
        r5.putBundle(r3, BundleExtKt.json2Bundle$default((JSONObject) ZeusTransformUtils.preCheckCast(r4, JSONObject.class, "com.obric.memorydata.plugin"), false, 2, null));
        return;
    L24:
        if (ZeusTransformUtils.instanceOf(r4, JSONArray.class) == false) goto L34;
        jarr2Bundle(r3, (JSONArray) ZeusTransformUtils.preCheckCast(r4, JSONArray.class, "com.obric.memorydata.plugin"), r5);
        return;
    }

    private final void jarr2Bundle(String r6, JSONArray r7, Bundle r8) {
        if (r7.length() != 0) goto L5;
        return;
    L5:
        int r5 = 0;
        Object r0 = r7.get(0);
        if (ZeusTransformUtils.instanceOf(r0, String.class) == false) goto L12;
        int r1 = r7.length();
        String[] r2 = new String[r1];
    L8:
        if (r5 >= r1) goto L10;
        r2[r5] = r7.getString(r5);
        r5 = r5 + 1;
        goto L8
    L10:
        r8.putStringArray(r6, r2);
        return;
    L12:
        if (ZeusTransformUtils.instanceOf(r0, Integer.class) == false) goto L18;
        int r3 = r7.length();
        Integer[] r4 = new Integer[r3];
    L14:
        if (r5 >= r3) goto L16;
        r4[r5] = Integer.valueOf(r7.getInt(r5));
        r5 = r5 + 1;
        goto L14
    L16:
        r8.putIntArray(r6, ArraysKt.toIntArray(r4));
        return;
    L18:
        if (ZeusTransformUtils.instanceOf(r0, Long.class) == false) goto L24;
        int r9 = r7.length();
        Long[] r10 = new Long[r9];
    L20:
        if (r5 >= r9) goto L22;
        r10[r5] = Long.valueOf(r7.getLong(r5));
        r5 = r5 + 1;
        goto L20
    L22:
        r8.putLongArray(r6, ArraysKt.toLongArray(r10));
        return;
    L24:
        if (ZeusTransformUtils.instanceOf(r0, Boolean.class) == false) goto L30;
        int r11 = r7.length();
        Boolean[] r12 = new Boolean[r11];
    L26:
        if (r5 >= r11) goto L28;
        r12[r5] = Boolean.valueOf(r7.getBoolean(r5));
        r5 = r5 + 1;
        goto L26
    L28:
        r8.putBooleanArray(r6, ArraysKt.toBooleanArray(r12));
        return;
    L30:
        if (ZeusTransformUtils.instanceOf(r0, Double.class) == false) goto L36;
        int r13 = r7.length();
        Double[] r14 = new Double[r13];
    L32:
        if (r5 >= r13) goto L34;
        r14[r5] = Double.valueOf(r7.getDouble(r5));
        r5 = r5 + 1;
        goto L32
    L34:
        r8.putDoubleArray(r6, ArraysKt.toDoubleArray(r14));
        return;
    L36:
        if (ZeusTransformUtils.instanceOf(r0, JSONObject.class) == false) goto L53;
        int r15 = r7.length();
        Bundle[] r16 = new Bundle[r15];
    L38:
        if (r5 >= r15) goto L40;
        DataConvert r17 = INSTANCE;
        JSONObject r18 = r7.optJSONObject(r5);
        Intrinsics.checkNotNullExpressionValue(r18, "optJSONObject(...)");
        r16[r5] = r17.jobj2Bundle(r18);
        r5 = r5 + 1;
        goto L38
    L40:
        r8.putParcelableArray(r6, (Parcelable[]) ZeusTransformUtils.preCheckCast(r16, Parcelable[].class, "com.obric.memorydata.plugin"));
        return;
    }

    @com.obric.aee.utils.a
    private final void jsonStr2Bundle(String r5, Bundle r6) {
        JSONObject r0 = new JSONObject(r5);
        Iterator<String> r7 = r0.keys();
        Intrinsics.checkNotNullExpressionValue(r7, "keys(...)");
    L4:
        if (r7.hasNext() == false) goto L6;
        String r1 = (String) ZeusTransformUtils.preCheckCast(r7.next(), String.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNull(r1);
        Object r2 = r0.get(r1);
        Intrinsics.checkNotNullExpressionValue(r2, "get(...)");
        jany2Bundle(r1, r2, r6);
        goto L4
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private final void setJson(int r7, Object r8, JSONArray r9) {
        if (r8 != null) goto L6;
        Object r6 = JSONObject.NULL;
    L4:
        r9.put(r7, r6);
        return;
    L6:
        if (ZeusTransformUtils.instanceOf(r8, String.class) == false) goto L9;
    L7:
        r9.put(r7, r8);
        return;
    L9:
        if (ZeusTransformUtils.instanceOf(r8, Integer.class) == false) goto L12;
        r9.put(r7, ((Number) ZeusTransformUtils.preCheckCast(r8, Number.class, "com.obric.memorydata.plugin")).intValue());
        return;
    L12:
        if (ZeusTransformUtils.instanceOf(r8, Short.class) == true) goto L7;
        if (ZeusTransformUtils.instanceOf(r8, Long.class) == false) goto L18;
        r9.put(r7, ((Number) ZeusTransformUtils.preCheckCast(r8, Number.class, "com.obric.memorydata.plugin")).longValue());
        return;
    L18:
        if (ZeusTransformUtils.instanceOf(r8, Boolean.class) == false) goto L21;
        r9.put(r7, ((Boolean) ZeusTransformUtils.preCheckCast(r8, Boolean.class, "com.obric.memorydata.plugin")).booleanValue());
        return;
    L21:
        if (ZeusTransformUtils.instanceOf(r8, Float.class) == true) goto L7;
        if (ZeusTransformUtils.instanceOf(r8, Double.class) == false) goto L27;
        r9.put(r7, ((Number) ZeusTransformUtils.preCheckCast(r8, Number.class, "com.obric.memorydata.plugin")).doubleValue());
        return;
    L27:
        if ((r8 instanceof Object[]) == false) goto L33;
        JSONArray r10 = new JSONArray();
        Object[] r11 = (Object[]) ZeusTransformUtils.preCheckCast(r8, Object[].class, "com.obric.memorydata.plugin");
        int r0 = r11.length;
        int r1 = 0;
        int r2 = 0;
    L29:
        if (r1 >= r0) goto L31;
        INSTANCE.setJson(r2, r11[r1], r10);
        r1 = r1 + 1;
        r2 = r2 + 1;
        goto L29
    L31:
        Unit r12 = Unit.INSTANCE;
        r6 = r10;
        goto L4
    L33:
        if (ZeusTransformUtils.instanceOf(r8, Bundle.class) == false) goto L42;
        r6 = bundle2Json((Bundle) ZeusTransformUtils.preCheckCast(r8, Bundle.class, "com.obric.memorydata.plugin"));
        goto L4
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private final void setJson(String r7, Object r8, JSONObject r9) {
        if (ZeusTransformUtils.instanceOf(r8, String.class) == false) goto L6;
    L4:
        r9.put(r7, r8);
        return;
    L6:
        if (ZeusTransformUtils.instanceOf(r8, Integer.class) == false) goto L9;
        r9.put(r7, ((Number) ZeusTransformUtils.preCheckCast(r8, Number.class, "com.obric.memorydata.plugin")).intValue());
        return;
    L9:
        if (ZeusTransformUtils.instanceOf(r8, Short.class) == true) goto L4;
        if (ZeusTransformUtils.instanceOf(r8, Long.class) == false) goto L15;
        r9.put(r7, ((Number) ZeusTransformUtils.preCheckCast(r8, Number.class, "com.obric.memorydata.plugin")).longValue());
        return;
    L15:
        if (ZeusTransformUtils.instanceOf(r8, Boolean.class) == false) goto L18;
        r9.put(r7, ((Boolean) ZeusTransformUtils.preCheckCast(r8, Boolean.class, "com.obric.memorydata.plugin")).booleanValue());
        return;
    L18:
        if (ZeusTransformUtils.instanceOf(r8, Float.class) == true) goto L4;
        if (ZeusTransformUtils.instanceOf(r8, Double.class) == false) goto L23;
        r9.put(r7, ((Number) ZeusTransformUtils.preCheckCast(r8, Number.class, "com.obric.memorydata.plugin")).doubleValue());
        return;
    L23:
        int r2 = 0;
        if ((r8 instanceof float[]) == false) goto L31;
        JSONArray r6 = new JSONArray();
        float[] r10 = (float[]) ZeusTransformUtils.preCheckCast(r8, float[].class, "com.obric.memorydata.plugin");
        int r0 = r10.length;
    L26:
        if (r2 >= r0) goto L28;
        r6.put(Float.valueOf(r10[r2]));
        r2 = r2 + 1;
    L28:
        Unit r11 = Unit.INSTANCE;
        Object r12 = r6;
    L29:
        r9.put(r7, r12);
        return;
    L31:
        if ((r8 instanceof int[]) == false) goto L36;
        r6 = new JSONArray();
        int[] r13 = (int[]) ZeusTransformUtils.preCheckCast(r8, int[].class, "com.obric.memorydata.plugin");
        int r1 = r13.length;
    L33:
        if (r2 >= r1) goto L28;
        r6.put(r13[r2]);
        r2 = r2 + 1;
        goto L33
    L36:
        if ((r8 instanceof long[]) == false) goto L41;
        r6 = new JSONArray();
        long[] r14 = (long[]) ZeusTransformUtils.preCheckCast(r8, long[].class, "com.obric.memorydata.plugin");
        int r3 = r14.length;
    L38:
        if (r2 >= r3) goto L28;
        r6.put(r14[r2]);
        r2 = r2 + 1;
        goto L38
    L41:
        if ((r8 instanceof boolean[]) == false) goto L46;
        r6 = new JSONArray();
        boolean[] r15 = (boolean[]) ZeusTransformUtils.preCheckCast(r8, boolean[].class, "com.obric.memorydata.plugin");
        int r4 = r15.length;
    L43:
        if (r2 >= r4) goto L28;
        r6.put(r15[r2]);
        r2 = r2 + 1;
        goto L43
    L46:
        if ((r8 instanceof double[]) == false) goto L51;
        r6 = new JSONArray();
        double[] r16 = (double[]) ZeusTransformUtils.preCheckCast(r8, double[].class, "com.obric.memorydata.plugin");
        int r5 = r16.length;
    L48:
        if (r2 >= r5) goto L28;
        r6.put(r16[r2]);
        r2 = r2 + 1;
        goto L48
    L51:
        if ((r8 instanceof Object[]) == false) goto L56;
        r6 = new JSONArray();
        Object[] r17 = (Object[]) ZeusTransformUtils.preCheckCast(r8, Object[].class, "com.obric.memorydata.plugin");
        int r18 = r17.length;
        int r19 = 0;
    L53:
        if (r2 >= r18) goto L28;
        INSTANCE.setJson(r19, r17[r2], r6);
        r2 = r2 + 1;
        r19 = r19 + 1;
        goto L53
    L56:
        if (ZeusTransformUtils.instanceOf(r8, Bundle.class) == false) goto L70;
        r12 = bundle2Json((Bundle) ZeusTransformUtils.preCheckCast(r8, Bundle.class, "com.obric.memorydata.plugin"));
        goto L29
    }

    public final Bundle jobj2Bundle(JSONObject r6) {
        Intrinsics.checkNotNullParameter(r6, "jsonObject");
        Bundle r0 = new Bundle();
        Iterator<String> r1 = r6.keys();
        Intrinsics.checkNotNullExpressionValue(r1, "keys(...)");
    L4:
        if (r1.hasNext() == false) goto L6;
        String r2 = (String) ZeusTransformUtils.preCheckCast(r1.next(), String.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNull(r2);
        Object r3 = r6.get(r2);
        Intrinsics.checkNotNullExpressionValue(r3, "get(...)");
        jany2Bundle(r2, r3, r0);
        goto L4
    L6:
        return r0;
    }
}
