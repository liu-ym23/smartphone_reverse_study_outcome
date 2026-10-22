package com.obric.memorydata.awareness.persistent;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.crash.entity.EventBody;
import com.obric.memorydata.sdk.awareness.AwarenessConditionConfig;
import com.obric.memorydata.sdk.awareness.AwarenessConditionRule;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010\u0006\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0007\u001a\u00020\bJ&\u0010\t\u001a\u00020\u00052\u0016\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u000b2\u0006\u0010\u0007\u001a\u00020\bJ(\u0010\r\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u000e\u001a\u00020\f2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u0010H\u0002J(\u0010\u0011\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u000e\u001a\u00020\f2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u0010H\u0002J(\u0010\u0012\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u000e\u001a\u00020\f2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u0010H\u0002J(\u0010\u0013\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u000e\u001a\u00020\f2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u0010H\u0002J(\u0010\u0014\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u000e\u001a\u00020\f2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u0010H\u0002J\u0018\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0017H\u0002J\u0017\u0010\u0019\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\fH\u0002¢\u0006\u0002\u0010\u001a¨\u0006\u001b"}, d2 = {"Lcom/obric/memorydata/awareness/persistent/AwarenessConditionEvaluator;", "", "<init>", "()V", "matches", "", EventBody.KEY_VALUE, "config", "Lcom/obric/memorydata/sdk/awareness/AwarenessConditionConfig;", "matchesExtras", WsConstants.KEY_EXTRA, "", "", "matchLong", "operator", "values", "", "matchDouble", "matchString", "matchStringList", "matchBoolean", "equalsDouble", "left", "", "right", "parseBoolean", "(Ljava/lang/String;)Ljava/lang/Boolean;", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f8761a = null;

    static {
        f8761a = new a();
    }

    private a() {
    }

    private final Boolean a(String r1) {
        String r0 = r1.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(r0, "toLowerCase(...)");
        if (Intrinsics.areEqual(r0, "true") == false) goto L7;
        boolean r2 = true;
    L11:
        return Boolean.valueOf(r2);
    L7:
        if (Intrinsics.areEqual(r0, "false") == false) goto L9;
        r2 = false;
        goto L11
    L9:
        return null;
    }

    private final boolean a(double r1, double r3) {
        if (Math.abs(r1 - r3) >= 1.0E-6d) goto L5;
        return true;
    L5:
        return false;
    }

    private final boolean a(Object r7, String r8, List<String> r9) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r7, Byte.class) == false) goto L8;
        int r10 = ((Number) ZeusTransformUtils.preCheckCast(r7, Number.class, "com.obric.memorydata.plugin")).byteValue();
    L5:
        long r1 = r10;
    L6:
        Long r11 = Long.valueOf(r1);
    L27:
        if (r11 == null) goto L97;
        long r2 = r11.longValue();
        Iterable r12 = (Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.memorydata.plugin");
        Collection r13 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r14 = r12.iterator();
    L30:
        if (r14.hasNext() == false) goto L34;
        Long r3 = StringsKt.toLongOrNull((String) ZeusTransformUtils.preCheckCast(r14.next(), String.class, "com.obric.memorydata.plugin"));
        if (r3 == null) goto L30;
        r13.add(r3);
        goto L30
    L34:
        List r15 = (List) ZeusTransformUtils.preCheckCast(r13, List.class, "com.obric.memorydata.plugin");
        Long r16 = (Long) ZeusTransformUtils.preCheckCast(CollectionsKt.firstOrNull(r15), Long.class, "com.obric.memorydata.plugin");
        if (r16 == null) goto L98;
        long r4 = r16.longValue();
        int r17 = r8.hashCode();
        if (r17 == (-1012440496)) goto L88;
        if (r17 == 3244) goto L82;
        if (r17 == 3309) goto L76;
        if (r17 == 3464) goto L70;
        if (r17 == 3511) goto L64;
        if (r17 == 102680) goto L58;
        if (r17 == 107485) goto L52;
        return false;
    L52:
        if (r8.equals(LocationInfoConst.LTE) == true) goto L55;
        return false;
    L55:
        if (r2 <= r4) goto L105;
        return false;
    L105:
        return true;
    L58:
        if (r8.equals("gte") == true) goto L61;
        return false;
    L61:
        if (r2 >= r4) goto L105;
        return false;
    L64:
        if (r8.equals("ne") == true) goto L67;
        return false;
    L67:
        if (r2 != r4) goto L105;
        return false;
    L70:
        if (r8.equals("lt") == true) goto L73;
        return false;
    L73:
        if (r2 < r4) goto L105;
        return false;
    L76:
        if (r8.equals("gt") == true) goto L79;
        return false;
    L79:
        if (r2 > r4) goto L105;
        return false;
    L82:
        if (r8.equals("eq") == true) goto L85;
        return false;
    L85:
        if (r2 == r4) goto L105;
        return false;
    L88:
        if (r8.equals("one_of") == true) goto L91;
        return false;
    L91:
        return r15.contains(Long.valueOf(r2));
    L98:
        return false;
    L97:
        return false;
    L8:
        if (ZeusTransformUtils.instanceOf(r7, Short.class) == false) goto L11;
        r10 = ((Number) ZeusTransformUtils.preCheckCast(r7, Number.class, "com.obric.memorydata.plugin")).shortValue();
        goto L5
    L11:
        if (ZeusTransformUtils.instanceOf(r7, Integer.class) == false) goto L14;
        r10 = ((Number) ZeusTransformUtils.preCheckCast(r7, Number.class, "com.obric.memorydata.plugin")).intValue();
        goto L5
    L14:
        if (ZeusTransformUtils.instanceOf(r7, Long.class) == false) goto L17;
        r11 = (Long) ZeusTransformUtils.preCheckCast(r7, Long.class, "com.obric.memorydata.plugin");
        goto L27
    L17:
        if (ZeusTransformUtils.instanceOf(r7, Float.class) == false) goto L20;
        r1 = (long) ((Number) ZeusTransformUtils.preCheckCast(r7, Number.class, "com.obric.memorydata.plugin")).floatValue();
        goto L6
    L20:
        if (ZeusTransformUtils.instanceOf(r7, Double.class) == false) goto L23;
        r1 = (long) ((Number) ZeusTransformUtils.preCheckCast(r7, Number.class, "com.obric.memorydata.plugin")).doubleValue();
        goto L6
    L23:
        if (ZeusTransformUtils.instanceOf(r7, String.class) == false) goto L25;
        r11 = StringsKt.toLongOrNull((String) ZeusTransformUtils.preCheckCast(r7, String.class, "com.obric.memorydata.plugin"));
        goto L27
    L25:
        r11 = null;
        goto L27
    }

    private final boolean b(Object r9, String r10, List<String> r11) {
        List r12 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r9, Byte.class) == false) goto L8;
        int r13 = ((Number) ZeusTransformUtils.preCheckCast(r9, Number.class, "com.obric.memorydata.plugin")).byteValue();
    L5:
        double r2 = r13;
    L6:
        Double r14 = Double.valueOf(r2);
    L27:
        if (r14 == null) goto L99;
        double r3 = r14.doubleValue();
        Iterable r15 = (Iterable) ZeusTransformUtils.preCheckCast(r12, Iterable.class, "com.obric.memorydata.plugin");
        Collection r16 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r17 = r15.iterator();
    L30:
        if (r17.hasNext() == false) goto L34;
        Double r4 = StringsKt.toDoubleOrNull((String) ZeusTransformUtils.preCheckCast(r17.next(), String.class, "com.obric.memorydata.plugin"));
        if (r4 == null) goto L30;
        r16.add(r4);
        goto L30
    L34:
        List r18 = (List) ZeusTransformUtils.preCheckCast(r16, List.class, "com.obric.memorydata.plugin");
        Double r19 = (Double) ZeusTransformUtils.preCheckCast(CollectionsKt.firstOrNull(r18), Double.class, "com.obric.memorydata.plugin");
        if (r19 == null) goto L108;
        double r5 = r19.doubleValue();
        int r110 = r10.hashCode();
        if (r110 == (-1012440496)) goto L86;
        if (r110 == 3244) goto L82;
        if (r110 == 3309) goto L76;
        if (r110 == 3464) goto L70;
        if (r110 == 3511) goto L64;
        if (r110 == 102680) goto L58;
        if (r110 == 107485) goto L52;
        return false;
    L52:
        if (r10.equals(LocationInfoConst.LTE) == true) goto L55;
        return false;
    L55:
        if (r3 <= r5) goto L114;
        return false;
    L114:
        return true;
    L58:
        if (r10.equals("gte") == true) goto L61;
        return false;
    L61:
        if (r3 >= r5) goto L114;
        return false;
    L64:
        if (r10.equals("ne") == true) goto L67;
        return false;
    L67:
        if (a(r3, r5) == false) goto L114;
        return false;
    L70:
        if (r10.equals("lt") == true) goto L73;
        return false;
    L73:
        if (r3 < r5) goto L114;
        return false;
    L76:
        if (r10.equals("gt") == true) goto L79;
        return false;
    L79:
        if (r3 > r5) goto L114;
        return false;
    L82:
        if (r10.equals("eq") == true) goto L115;
        return false;
    L115:
        return a(r3, r5);
    L86:
        if (r10.equals("one_of") == false) goto L123;
        Iterable r8 = (Iterable) ZeusTransformUtils.preCheckCast(r18, Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r8, Collection.class) == true) goto L91;
    L93:
        Iterator r20 = r8.iterator();
    L95:
        if (r20.hasNext() == false) goto L125;
        if (f8761a.a(r3, ((Number) ZeusTransformUtils.preCheckCast(r20.next(), Number.class, "com.obric.memorydata.plugin")).doubleValue()) == false) goto L95;
    L125:
        return false;
    L91:
        if (((Collection) ZeusTransformUtils.preCheckCast(r8, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L93;
        return false;
    L123:
        return false;
    L108:
        return false;
    L99:
        return false;
    L8:
        if (ZeusTransformUtils.instanceOf(r9, Short.class) == false) goto L11;
        r13 = ((Number) ZeusTransformUtils.preCheckCast(r9, Number.class, "com.obric.memorydata.plugin")).shortValue();
        goto L5
    L11:
        if (ZeusTransformUtils.instanceOf(r9, Integer.class) == false) goto L14;
        r13 = ((Number) ZeusTransformUtils.preCheckCast(r9, Number.class, "com.obric.memorydata.plugin")).intValue();
        goto L5
    L14:
        if (ZeusTransformUtils.instanceOf(r9, Long.class) == false) goto L17;
        r2 = ((Number) ZeusTransformUtils.preCheckCast(r9, Number.class, "com.obric.memorydata.plugin")).longValue();
        goto L6
    L17:
        if (ZeusTransformUtils.instanceOf(r9, Float.class) == false) goto L20;
        r2 = ((Number) ZeusTransformUtils.preCheckCast(r9, Number.class, "com.obric.memorydata.plugin")).floatValue();
        goto L6
    L20:
        if (ZeusTransformUtils.instanceOf(r9, Double.class) == false) goto L23;
        r14 = (Double) ZeusTransformUtils.preCheckCast(r9, Double.class, "com.obric.memorydata.plugin");
        goto L27
    L23:
        if (ZeusTransformUtils.instanceOf(r9, String.class) == false) goto L25;
        r14 = StringsKt.toDoubleOrNull((String) ZeusTransformUtils.preCheckCast(r9, String.class, "com.obric.memorydata.plugin"));
        goto L27
    L25:
        r14 = null;
        goto L27
    }

    private final boolean c(Object r4, String r5, List<String> r6) {
        List r3 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L31;
        String r7 = r4.toString();
        if (r7 == null) goto L36;
        String r0 = (String) ZeusTransformUtils.preCheckCast(CollectionsKt.firstOrNull(r3), String.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L10;
        return false;
    L10:
        int r1 = r5.hashCode();
        if (r1 == (-1012440496)) goto L27;
        if (r1 == 3244) goto L24;
        if (r1 == 3511) goto L18;
        return false;
    L18:
        if (r5.equals("ne") == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(r7, r0) == true) goto L32;
        return true;
    L32:
        return false;
    L24:
        if (r5.equals("eq") == true) goto L35;
        return false;
    L35:
        return Intrinsics.areEqual(r7, r0);
    L27:
        if (r5.equals("one_of") == true) goto L30;
        return false;
    L30:
        return r3.contains(r7);
    L36:
        return false;
    L31:
        return false;
    }

    private final boolean d(Object r8, String r9, List<String> r10) {
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.memorydata.plugin");
        List r1 = null;
        if ((r8 instanceof Object[]) == false) goto L15;
        Object[] r11 = (Object[]) ZeusTransformUtils.preCheckCast(r8, Object[].class, "com.obric.memorydata.plugin");
        Collection r12 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        int r3 = r11.length;
        int r4 = 0;
    L5:
        if (r4 >= r3) goto L13;
        Object r5 = r11[r4];
        if (ZeusTransformUtils.instanceOf(r5, String.class) == false) goto L9;
        String r6 = (String) ZeusTransformUtils.preCheckCast(r5, String.class, "com.obric.memorydata.plugin");
    L10:
        if (r6 == null) goto L12;
        r12.add(r6);
    L12:
        r4 = r4 + 1;
        goto L5
    L9:
        r6 = null;
    L13:
        r1 = (List) ZeusTransformUtils.preCheckCast(r12, List.class, "com.obric.memorydata.plugin");
    L25:
        if (r1 != null) goto L27;
        return false;
    L27:
        String r13 = (String) ZeusTransformUtils.preCheckCast(CollectionsKt.firstOrNull(r7), String.class, "com.obric.memorydata.plugin");
        if (r13 != null) goto L30;
        return false;
    L30:
        int r14 = r9.hashCode();
        if (r14 == (-1012440496)) goto L54;
        if (r14 == (-567445985)) goto L50;
        if (r14 == 3244) goto L46;
        if (r14 == 3511) goto L40;
        return false;
    L40:
        if (r9.equals("ne") == true) goto L43;
        return false;
    L43:
        if (Intrinsics.areEqual(r1, r7) == false) goto L79;
        return false;
    L79:
        return true;
    L46:
        if (r9.equals("eq") == true) goto L80;
        return false;
    L80:
        return Intrinsics.areEqual(r1, r7);
    L50:
        if (r9.equals("contains") == true) goto L81;
        return false;
    L81:
        return r1.contains(r13);
    L54:
        if (r9.equals("one_of") == false) goto L86;
        Iterable r15 = (Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r15, Collection.class) == true) goto L59;
    L61:
        Iterator r16 = r15.iterator();
    L63:
        if (r16.hasNext() == false) goto L88;
        if (r1.contains((String) ZeusTransformUtils.preCheckCast(r16.next(), String.class, "com.obric.memorydata.plugin")) == false) goto L63;
    L88:
        return false;
    L59:
        if (((Collection) ZeusTransformUtils.preCheckCast(r15, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L61;
        return false;
    L86:
        return false;
    L15:
        if (ZeusTransformUtils.instanceOf(r8, Iterable.class) == false) goto L25;
        Iterable r17 = (Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.memorydata.plugin");
        r12 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r18 = r17.iterator();
    L18:
        if (r18.hasNext() == false) goto L13;
        Object r19 = r18.next();
        if (ZeusTransformUtils.instanceOf(r19, String.class) == false) goto L22;
        String r20 = (String) ZeusTransformUtils.preCheckCast(r19, String.class, "com.obric.memorydata.plugin");
    L23:
        if (r20 == null) goto L18;
        r12.add(r20);
        goto L18
    L22:
        r20 = null;
        goto L23
    }

    private final boolean e(Object r3, String r4, List<String> r5) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r3, Boolean.class) == false) goto L6;
        Boolean r2 = (Boolean) ZeusTransformUtils.preCheckCast(r3, Boolean.class, "com.obric.memorydata.plugin");
    L10:
        if (r2 == null) goto L23;
        boolean r7 = r2.booleanValue();
        String r8 = (String) ZeusTransformUtils.preCheckCast(CollectionsKt.firstOrNull(r6), String.class, "com.obric.memorydata.plugin");
        if (r8 == null) goto L24;
        Boolean r9 = f8761a.a(r8);
        if (r9 == null) goto L25;
        boolean r10 = r9.booleanValue();
        if (Intrinsics.areEqual(r4, "eq") == false) goto L20;
        if (r7 == r10) goto L27;
        return false;
    L27:
        return true;
    L20:
        if (Intrinsics.areEqual(r4, "ne") == false) goto L28;
        if (r7 != r10) goto L27;
        return false;
    L28:
        return false;
    L25:
        return false;
    L24:
        return false;
    L23:
        return false;
    L6:
        if (ZeusTransformUtils.instanceOf(r3, String.class) == false) goto L8;
        r2 = a((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.memorydata.plugin"));
        goto L10
    L8:
        r2 = null;
        goto L10
    }

    public final boolean a(Object r8, AwarenessConditionConfig r9) {
        Intrinsics.checkNotNullParameter(r9, "config");
        if (r9.isAlways() == false) goto L5;
        return true;
    L5:
        ArrayList<AwarenessConditionRule> r7 = r9.getRules();
        if (r7.isEmpty() == false) goto L8;
        return true;
    L8:
        Iterable r10 = (Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.memorydata.plugin");
        Collection r1 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r10, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r11 = r10.iterator();
    L9:
        boolean r4 = false;
        if (r11.hasNext() == false) goto L36;
        AwarenessConditionRule r3 = (AwarenessConditionRule) ZeusTransformUtils.preCheckCast(r11.next(), AwarenessConditionRule.class, "com.obric.memorydata.plugin");
        String r5 = r9.getValueType();
        if (r5 == null) goto L35;
        switch(r5.hashCode()) {
            case -1510577140: goto L32;
            case -1325958191: goto L28;
            case -891985903: goto L24;
            case 104431: goto L21;
            case 64711720: goto L17;
            default: goto L35;
        };
    L17:
        if (r5.equals(TypedValues.Custom.S_BOOLEAN) == false) goto L35;
        r4 = f8761a.e(r8, r3.getOperator(), (List) ZeusTransformUtils.preCheckCast(r3.getValues(), List.class, "com.obric.memorydata.plugin"));
        goto L35
    L21:
        if (r5.equals("int") == false) goto L35;
        r4 = f8761a.a(r8, r3.getOperator(), (List) ZeusTransformUtils.preCheckCast(r3.getValues(), List.class, "com.obric.memorydata.plugin"));
        goto L35
    L24:
        if (r5.equals(TypedValues.Custom.S_STRING) == false) goto L35;
        r4 = f8761a.c(r8, r3.getOperator(), (List) ZeusTransformUtils.preCheckCast(r3.getValues(), List.class, "com.obric.memorydata.plugin"));
        goto L35
    L28:
        if (r5.equals("double") == false) goto L35;
        r4 = f8761a.b(r8, r3.getOperator(), (List) ZeusTransformUtils.preCheckCast(r3.getValues(), List.class, "com.obric.memorydata.plugin"));
        goto L35
    L32:
        if (r5.equals("string_list") == false) goto L35;
        r4 = f8761a.d(r8, r3.getOperator(), (List) ZeusTransformUtils.preCheckCast(r3.getValues(), List.class, "com.obric.memorydata.plugin"));
    L35:
        r1.add(Boolean.valueOf(r4));
        goto L9
    L36:
        List r12 = (List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(r9.getMatchMode(), "any") == false) goto L49;
        Iterable r13 = (Iterable) ZeusTransformUtils.preCheckCast(r12, Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r13, Collection.class) == true) goto L41;
    L43:
        Iterator r14 = r13.iterator();
    L45:
        if (r14.hasNext() == false) goto L60;
        if (((Boolean) ZeusTransformUtils.preCheckCast(r14.next(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L45;
        return true;
    L60:
        return false;
    L41:
        if (((Collection) ZeusTransformUtils.preCheckCast(r13, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L43;
    L49:
        Iterable r15 = (Iterable) ZeusTransformUtils.preCheckCast(r12, Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r15, Collection.class) == true) goto L52;
    L54:
        Iterator r16 = r15.iterator();
    L56:
        if (r16.hasNext() == false) goto L82;
        if (((Boolean) ZeusTransformUtils.preCheckCast(r16.next(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == true) goto L56;
    L82:
        return true;
    L52:
        if (((Collection) ZeusTransformUtils.preCheckCast(r15, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L54;
        return true;
    }

    public final boolean a(Map<String, ? extends Object> r5, AwarenessConditionConfig r6) {
        Map r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "config");
        if (r6.isAlways() == false) goto L5;
        return true;
    L5:
        String r0 = r6.getExtraKey();
        if (r0 == null) goto L17;
        Object r2 = null;
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L11;
        r0 = null;
    L11:
        if (r0 == null) goto L19;
        if (r7 == null) goto L16;
        r2 = r7.get(r0);
    L16:
        return a(r2, r6);
    L19:
        return false;
    L17:
        return false;
    }
}
