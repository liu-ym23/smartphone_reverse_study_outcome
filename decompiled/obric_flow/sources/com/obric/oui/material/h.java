package com.obric.oui.material;

import android.R;
import android.content.res.ColorStateList;
import android.graphics.Color;
import com.obric.oui.graphic.BlendMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.FloatSpreadBuilder;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: classes3.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f13658a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int[][] f13659b = null;

    static {
        f13658a = new h();
        f13659b = new int[][]{new int[]{R.attr.state_pressed, R.attr.state_checked}, new int[]{R.attr.state_hovered, R.attr.state_checked}, new int[]{R.attr.state_pressed, R.attr.state_selected}, new int[]{R.attr.state_hovered, R.attr.state_selected}, new int[]{R.attr.state_pressed, R.attr.state_activated}, new int[]{R.attr.state_hovered, R.attr.state_activated}, new int[]{R.attr.state_pressed}, new int[]{R.attr.state_hovered}, new int[]{R.attr.state_checked}, new int[]{R.attr.state_selected}, new int[]{-16842910}, new int[]{R.attr.state_enabled}};
    }

    public static final c[] a(XmlPullParser r5) {
        h r10 = f13658a;
        ArrayList r11 = new ArrayList();
        int r12 = r5.getDepth();
    L3:
        int r13 = r5.next();
        if (r13 == 1) goto L17;
        if (r13 != 2) goto L8;
        if (Intrinsics.areEqual(h(r5.getName()), "material_config") == true) goto L15;
        v(r5);
        goto L3
    L15:
        r11.add(r10.p(r5));
        goto L3
    L8:
        if (r13 != 3) goto L3;
        if (r5.getDepth() != r12) goto L3;
    L17:
        Object[] r14 = r11.toArray(new c[0]);
        if (r14 == null) goto L25;
        if (((c[]) r14).length != 0) goto L23;
        r14 = null;
    L23:
        return (c[]) r14;
    L25:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    }

    public static cs.a b(g r17) {
        boolean r5 = r17.a(MaterialXmlParser$buildBlendConfigStateList$1.INSTANCE);
        Object r10 = r17.f13655a;
        if (r5 == false) goto L6;
        com.obric.oui.color.a[] r11 = (com.obric.oui.color.a[]) r10;
        Intrinsics.checkNotNullParameter(r11, "configs");
        return new cs.a(new cs.b(new int[][]{cs.b.d}, new com.obric.oui.color.a[][]{r11}, r11));
    L6:
        int[][] r12 = f13659b;
        com.obric.oui.color.a[] r13 = (com.obric.oui.color.a[]) r17.d;
        com.obric.oui.color.a[] r14 = (com.obric.oui.color.a[]) r17.e;
        com.obric.oui.color.a[][] r15 = {r13, r13, r14, r14, r14, r14, (com.obric.oui.color.a[]) r17.f13656b, (com.obric.oui.color.a[]) r17.f13657c, r13, r14, (com.obric.oui.color.a[]) r17.f, (com.obric.oui.color.a[]) r10};
        Intrinsics.checkNotNullParameter(r12, "states");
        Intrinsics.checkNotNullParameter(r15, "configs");
        int[] r16 = cs.b.d;
        int r18 = 0;
    L8:
        if (r18 >= 12) goto L13;
        if (r12[r18].length == 0) goto L11;
        r18 = r18 + 1;
        goto L8
    L11:
        com.obric.oui.color.a[] r19 = r15[r18];
    L14:
        if (r19 != null) goto L17;
        r19 = r15[0];
    L17:
        return new cs.a(new cs.b(r12, r15, r19));
    L13:
        r19 = null;
        goto L14
    }

    public static ColorStateList c(g r17) {
        boolean r5 = r17.a(MaterialXmlParser$buildColorStateList$1.INSTANCE);
        Object r10 = r17.f13655a;
        if (r5 == true) goto L5;
        int[][] r11 = f13659b;
        Number r12 = (Number) r17.d;
        int r13 = r12.intValue();
        int r14 = r12.intValue();
        Number r15 = (Number) r17.e;
        return new ColorStateList(r11, new int[]{r13, r14, r15.intValue(), r15.intValue(), r15.intValue(), r15.intValue(), ((Number) r17.f13656b).intValue(), ((Number) r17.f13657c).intValue(), r12.intValue(), r15.intValue(), ((Number) r17.f).intValue(), ((Number) r10).intValue()});
    L5:
        return ColorStateList.valueOf(((Number) r10).intValue());
    }

    public static String d(XmlPullParser r5, String... r10) {
        if (r10.length != 0) goto L5;
        return null;
    L5:
        Set r11 = ArraysKt.toSet(r10);
        int r12 = r5.getAttributeCount();
        int r13 = 0;
    L6:
        if (r13 >= r12) goto L23;
        int r14 = r13 + 1;
        String r15 = r5.getAttributeName(r13);
        if (r15 == null) goto L22;
        if (r11.contains(r15) == false) goto L22;
        String r16 = r5.getAttributeValue(r13);
        if (r16 == null) goto L29;
        String r17 = StringsKt.trim(r16).toString();
        if (r17 != null) goto L19;
        return null;
    L19:
        if (r17.length() > 0) goto L21;
        return null;
    L21:
        return r17;
    L29:
        return null;
    L22:
        r13 = r14;
        goto L6
    L23:
        return null;
    }

    public static String e(XmlPullParser r5, MaterialXmlParser$MaterialState r10, String r11, String r12) {
        String r13 = r10.getXmlName();
        List r14 = CollectionsKt.createListBuilder();
        if (r12 != null) goto L5;
    L11:
        if (r11 == null) goto L14;
        r14.add(r13 + '_' + r11);
    L14:
        if (r11 != null) goto L16;
        r14.add(r13);
    L16:
        Object[] r15 = CollectionsKt.build(r14).toArray(new String[0]);
        if (r15 == null) goto L21;
        String[] r16 = (String[]) r15;
        return d(r5, (String[]) Arrays.copyOf(r16, r16.length));
    L21:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    L5:
        if (StringsKt.isBlank(r12) == true) goto L11;
        r14.add(r12 + '_' + r13);
        if (r11 == null) goto L11;
        r14.add(r12 + '_' + r13 + '_' + r11);
        goto L11
    }

    public static /* synthetic */ String f(h r5, XmlPullParser r10, MaterialXmlParser$MaterialState r11, String r12, int r13) {
        if ((r13 & 8) == 0) goto L5;
        r12 = null;
    L5:
        r5.getClass();
        return e(r10, r11, null, r12);
    }

    public static boolean g(XmlPullParser r5, String... r10) {
        if (d(r5, (String[]) Arrays.copyOf(r10, r10.length)) == null) goto L5;
        return true;
    L5:
        return false;
    }

    public static String h(String r5) {
        return StringsKt.E(StringsKt.trim(r5).toString().toLowerCase(Locale.ROOT), '-', '_');
    }

    public static com.obric.oui.color.a[] i(XmlPullParser r5) {
        ArrayList r10 = new ArrayList();
        int r11 = r5.getDepth();
    L3:
        int r12 = r5.next();
        if (r12 == 1) goto L20;
        if (r12 != 2) goto L8;
        if (Intrinsics.areEqual(h(r5.getName()), "blend_config") == true) goto L15;
        v(r5);
        goto L3
    L15:
        com.obric.oui.color.a r13 = k(r5);
        if (r13 == null) goto L3;
        r10.add(r13);
        goto L3
    L8:
        if (r12 != 3) goto L3;
        if (r5.getDepth() != r11) goto L3;
    L20:
        Object[] r14 = r10.toArray(new com.obric.oui.color.a[0]);
        if (r14 == null) goto L28;
        if (((com.obric.oui.color.a[]) r14).length != 0) goto L26;
        r14 = null;
    L26:
        return (com.obric.oui.color.a[]) r14;
    L28:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    }

    public static f j(XmlPullParser r14) {
        f r5 = r(r14, null);
        if (r5 == null) goto L5;
        v(r14);
        return r5;
    L5:
        if (g(r14, new String[]{"color"}) == false) goto L14;
        com.obric.oui.color.a r15 = k(r14);
        if (r15 != null) goto L9;
        com.obric.oui.color.a[] r10 = null;
    L10:
        if (r10 != null) goto L12;
        return null;
    L12:
        Intrinsics.checkNotNullParameter(r10, "configs");
        return new f(r10, new cs.a(new cs.b(new int[][]{cs.b.d}, new com.obric.oui.color.a[][]{r10}, r10)));
    L9:
        r10 = new com.obric.oui.color.a[]{r15};
        goto L10
    L14:
        ArrayList r11 = new ArrayList();
        int r12 = r14.getDepth();
        com.obric.oui.color.a[] r13 = null;
        com.obric.oui.color.a[] r16 = null;
        com.obric.oui.color.a[] r17 = null;
        com.obric.oui.color.a[] r18 = null;
        com.obric.oui.color.a[] r19 = null;
        com.obric.oui.color.a[] r110 = null;
    L15:
        int r20 = r14.next();
        if (r20 == 1) goto L51;
        if (r20 != 2) goto L20;
        String r21 = h(r14.getName());
        if (Intrinsics.areEqual(r21, "blend_config") == true) goto L27;
        if (Intrinsics.areEqual(r21, MaterialXmlParser$MaterialState.NORMAL.getNodeName()) == true) goto L33;
        if (Intrinsics.areEqual(r21, MaterialXmlParser$MaterialState.PRESS.getNodeName()) == true) goto L36;
        if (Intrinsics.areEqual(r21, MaterialXmlParser$MaterialState.HOVER.getNodeName()) == true) goto L39;
        if (Intrinsics.areEqual(r21, MaterialXmlParser$MaterialState.CHECKED.getNodeName()) == true) goto L42;
        if (Intrinsics.areEqual(r21, MaterialXmlParser$MaterialState.SELECTED.getNodeName()) == true) goto L45;
        if (Intrinsics.areEqual(r21, MaterialXmlParser$MaterialState.DISABLE.getNodeName()) == true) goto L48;
        v(r14);
        goto L15
    L48:
        r110 = i(r14);
        goto L15
    L45:
        r19 = i(r14);
        goto L15
    L42:
        r18 = i(r14);
        goto L15
    L39:
        r17 = i(r14);
        goto L15
    L36:
        r16 = i(r14);
        goto L15
    L33:
        r13 = i(r14);
        goto L15
    L27:
        com.obric.oui.color.a r22 = k(r14);
        if (r22 == null) goto L15;
        r11.add(r22);
        goto L15
    L20:
        if (r20 != 3) goto L15;
        if (r14.getDepth() != r12) goto L15;
    L51:
        if (r13 != null) goto L60;
        if (r11.isEmpty() == true) goto L60;
        Object[] r23 = r11.toArray(new com.obric.oui.color.a[0]);
        if (r23 == null) goto L59;
        r13 = (com.obric.oui.color.a[]) r23;
        goto L60
    L59:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    L60:
        g r24 = u(r13, r16, r17, r18, r19, r110);
        if (r24 == null) goto L64;
        cs.a r111 = b(r24);
        return new f(r111.f16500a.f16503c, r111);
    L64:
        Object[] r25 = r11.toArray(new com.obric.oui.color.a[0]);
        if (r25 == null) goto L75;
        if (((com.obric.oui.color.a[]) r25).length != 0) goto L69;
        r25 = null;
    L69:
        com.obric.oui.color.a[] r26 = (com.obric.oui.color.a[]) r25;
        if (r26 == null) goto L110;
        Intrinsics.checkNotNullParameter(r26, "configs");
        return new f(r26, new cs.a(new cs.b(new int[][]{cs.b.d}, new com.obric.oui.color.a[][]{r26}, r26)));
    L110:
        return null;
    L75:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    }

    public static com.obric.oui.color.a k(XmlPullParser r5) {
        Integer r10 = m(d(r5, new String[]{"color"}));
        if (r10 != null) goto L6;
        v(r5);
        return null;
    L6:
        int r11 = r10.intValue();
        Integer r12 = l(d(r5, new String[]{"blend_mode"}));
        if (r12 != null) goto L9;
        int r13 = BlendMode.SRC_OVER.porterDuffMode;
    L10:
        v(r5);
        return new com.obric.oui.color.a(r11, r13);
    L9:
        r13 = r12.intValue();
        goto L10
    }

    public static Integer l(String r10) {
        if (r10 != null) goto L5;
    L4:
        String r11 = null;
    L10:
        if (r11 != null) goto L12;
        return null;
    L12:
        Integer r5 = StringsKt.toIntOrNull(r11);
        if (r5 != null) goto L26;
        String r12 = h(r11).toUpperCase(Locale.ROOT);
        BlendMode[] r13 = BlendMode.values();
        int r14 = r13.length;
        int r15 = 0;
    L15:
        if (r15 >= r14) goto L20;
        BlendMode r16 = r13[r15];
        if (Intrinsics.areEqual(h(r16.name()).toUpperCase(Locale.ROOT), r12) == true) goto L21;
        r15 = r15 + 1;
    L21:
        if (r16 != null) goto L24;
        return null;
    L24:
        return Integer.valueOf(r16.porterDuffMode);
    L20:
        r16 = null;
        goto L21
    L26:
        return Integer.valueOf(r5.intValue());
    L5:
        r11 = StringsKt.trim(r10).toString();
        if (r11 == null) goto L4;
        if (r11.length() <= 0) goto L4;
        goto L4
    }

    public static Integer m(String r5) {
        if (r5 != null) goto L5;
    L4:
        String r10 = null;
    L10:
        if (r10 != null) goto L28;
        return null;
    L28:
        if (StringsKt.P(r10, "#") == false) goto L16;
        int r11 = Color.parseColor(r10);     // Catch: Throwable -> L27
    L25:
        return Integer.valueOf(r11);
    L16:
        if (StringsKt.M(r10, "0x") == false) goto L18;
        r11 = (int) Long.parseLong(r10.substring(2), CharsKt.checkRadix(16));     // Catch: Throwable -> L27
        goto L25
    L18:
        Long r12 = StringsKt.toLongOrNull(r10);     // Catch: Throwable -> L27
        if (r12 != null) goto L21;
        Integer r13 = null;
    L22:
        if (r13 != null) goto L24;
        r11 = Color.parseColor(r10);     // Catch: Throwable -> L27
        goto L25
    L24:
        r11 = r13.intValue();     // Catch: Throwable -> L27
        goto L25
    L21:
        r13 = Integer.valueOf((int) r12.longValue());     // Catch: Throwable -> L27
    L30:
        return null;
    L5:
        r10 = StringsKt.trim(r5).toString();
        if (r10 == null) goto L4;
        if (r10.length() <= 0) goto L4;
        goto L4
    }

    public static Integer n(XmlPullParser r5) {
        Integer r10 = m(d(r5, new String[]{"color"}));
        if (r10 != null) goto L27;
        StringBuilder r11 = new StringBuilder();
        int r12 = r5.getDepth();
    L5:
        int r13 = r5.next();
        if (r13 == 1) goto L21;
        if (r13 != 2) goto L10;
        v(r5);
        goto L5
    L10:
        if (r13 != 3) goto L12;
        if (r5.getDepth() != r12) goto L5;
    L12:
        if (r13 == 4) goto L16;
        if (r13 != 5) goto L5;
    L16:
        r11.append(r5.getText());
    L21:
        String r14 = StringsKt.trim(r11.toString()).toString();
        if (r14.length() > 0) goto L26;
        r14 = null;
    L26:
        return m(r14);
    L27:
        int r15 = r10.intValue();
        v(r5);
        return Integer.valueOf(r15);
    }

    public static Float o(String r5) {
        if (r5 != null) goto L5;
    L4:
        String r10 = null;
    L10:
        if (r10 != null) goto L13;
        return null;
    L13:
        return StringsKt.toFloatOrNull(StringsKt.B(StringsKt.B(StringsKt.B(r10, "dp"), "px"), "sp"));
    L5:
        r10 = StringsKt.trim(r5).toString();
        if (r10 == null) goto L4;
        if (r10.length() <= 0) goto L4;
        goto L4
    }

    public static com.obric.oui.color.a[] q(XmlPullParser r5, String r10, MaterialXmlParser$MaterialState r11) {
        Integer r12 = m(e(r5, r11, "color", r10));
        if (r12 != null) goto L5;
        com.obric.oui.color.a r13 = null;
    L10:
        if (r13 != null) goto L13;
        return null;
    L13:
        return new com.obric.oui.color.a[]{r13};
    L5:
        int r14 = r12.intValue();
        Integer r15 = l(e(r5, r11, "blend_mode", r10));
        if (r15 != null) goto L8;
        int r16 = BlendMode.SRC_OVER.porterDuffMode;
    L9:
        r13 = new com.obric.oui.color.a(r14, r16);
        goto L10
    L8:
        r16 = r15.intValue();
        goto L9
    }

    public static f r(XmlPullParser r10, String r11) {
        if (r11 != null) goto L6;
    L4:
        r11 = null;
    L7:
        g r12 = u(q(r10, r11, MaterialXmlParser$MaterialState.NORMAL), q(r10, r11, MaterialXmlParser$MaterialState.PRESS), q(r10, r11, MaterialXmlParser$MaterialState.HOVER), q(r10, r11, MaterialXmlParser$MaterialState.CHECKED), q(r10, r11, MaterialXmlParser$MaterialState.SELECTED), q(r10, r11, MaterialXmlParser$MaterialState.DISABLE));
        if (r12 != null) goto L10;
        return null;
    L10:
        cs.a r13 = b(r12);
        return new f(r13.f16500a.f16503c, r13);
    L6:
        if (StringsKt.isBlank(r11) == true) goto L4;
        goto L4
    }

    public static com.obric.oui.color.d s(XmlPullParser r10) {
        Float r5 = o(d(r10, new String[]{"width"}));
        Integer r11 = m(d(r10, new String[]{"color"}));
        Integer r12 = l(d(r10, new String[]{"blend_mode"}));
        v(r10);
        BlendMode r13 = null;
        if (r5 == null) goto L19;
        if (r11 == null) goto L19;
        float r14 = r5.floatValue();
        int r15 = r11.intValue();
        if (r12 == null) goto L15;
        int r16 = r12.intValue();
        BlendMode[] r17 = BlendMode.values();
        int r18 = r17.length;
        int r19 = 0;
    L10:
        if (r19 >= r18) goto L15;
        BlendMode r20 = r17[r19];
        if (r20.porterDuffMode == r16) goto L13;
        r19 = r19 + 1;
        goto L10
    L13:
        r13 = r20;
    L15:
        if (r13 != null) goto L18;
        r13 = BlendMode.SRC_OVER;
    L18:
        return new com.obric.oui.color.d(r14, r15, r13);
    L19:
        return null;
    }

    public static com.obric.oui.color.d t(XmlPullParser r5) {
        if (g(r5, new String[]{"width", "color"}) == true) goto L5;
        int r10 = r5.getDepth();
    L7:
        int r11 = r5.next();
        if (r11 == 1) goto L30;
        if (r11 == 2) goto L18;
        if (r11 != 3) goto L7;
        if (r5.getDepth() != r10) goto L7;
        return null;
    L18:
        if (Intrinsics.areEqual(h(r5.getName()), "stroke") == true) goto L29;
        v(r5);
        return null;
    L29:
        return s(r5);
    L30:
        return null;
    L5:
        return s(r5);
    }

    public static g u(Object r10, Object r11, Object r12, Object r13, Object r14, Object r15) {
        if (r10 != null) goto L5;
        return null;
    L5:
        if (r11 != null) goto L7;
        Object r5 = r10;
    L8:
        if (r12 != null) goto L10;
        Object r16 = r5;
    L12:
        if (r13 != null) goto L14;
        Object r17 = r10;
    L15:
        if (r14 != null) goto L17;
        Object r18 = r10;
    L18:
        if (r15 != null) goto L20;
        Object r19 = r10;
    L22:
        return new g(r10, r5, r16, r17, r18, r19);
    L20:
        r19 = r15;
        goto L22
    L17:
        r18 = r14;
        goto L18
    L14:
        r17 = r13;
        goto L15
    L10:
        r16 = r12;
        goto L12
    L7:
        r5 = r11;
        goto L8
    }

    public static void v(XmlPullParser r5) {
        int r10 = 1;
    L3:
        if (r10 <= 0) goto L13;
        int r11 = r5.next();
        if (r11 == 1) goto L23;
        if (r11 != 2) goto L9;
        r10 = r10 + 1;
        goto L3
    L9:
        if (r11 != 3) goto L3;
        r10 = r10 - 1;
        goto L3
    L23:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final c p(XmlPullParser r29) {
        h r5 = this;
        Integer r10 = m(f(r5, r29, MaterialXmlParser$MaterialState.NORMAL, "fallback_bg_color", 4));
        if (r10 != null) goto L5;
        r10 = m(d(r29, new String[]{"fallback_bg_color"}));
    L5:
        g r11 = u(r10, m(f(r5, r29, MaterialXmlParser$MaterialState.PRESS, "fallback_bg_color", 4)), m(f(r5, r29, MaterialXmlParser$MaterialState.HOVER, "fallback_bg_color", 4)), m(f(r5, r29, MaterialXmlParser$MaterialState.CHECKED, "fallback_bg_color", 4)), m(f(r5, r29, MaterialXmlParser$MaterialState.SELECTED, "fallback_bg_color", 4)), m(f(r5, r29, MaterialXmlParser$MaterialState.DISABLE, "fallback_bg_color", 4)));
        String r13 = null;
        if (r11 != null) goto L8;
        ColorStateList r12 = null;
    L9:
        c r14 = new c(r12, null, null, null, o(d(r29, new String[]{"blur_radius"})), null, 894);
        f r15 = r(r29, "blend_configs");
        if (r15 == null) goto L13;
        r14.f13611c = r15.f13653a;
        r14.f13610b = r15.f13654b;
    L13:
        int r16 = r29.getDepth();
    L14:
        int r17 = r29.next();
        if (r17 == 1) goto L366;
        int r18 = 3;
        if (r17 != 2) goto L18;
        String r19 = h(r29.getName());
        int r20 = 0;
        float r110 = 0.0f;
        switch(r19.hashCode()) {
            case -1622636237: goto L360;
            case -1115483408: goto L349;
            case -891980232: goto L345;
            case -220247165: goto L332;
            case 97532362: goto L277;
            case 737726312: goto L213;
            case 1690590746: goto L127;
            case 1873723302: goto L78;
            case 2053811027: goto L27;
            default: goto L25;
        };
    L27:
        if (r19.equals("shadows") == false) goto L25;
        ArrayList r21 = new ArrayList();
        int r22 = r29.getDepth();
    L30:
        int r111 = r29.next();
        if (r111 == 1) goto L68;
        if (r111 != 2) goto L33;
        if (Intrinsics.areEqual(h(r29.getName()), "shadow") == false) goto L67;
        Integer r23 = m(d(r29, new String[]{"color"}));
        if (r23 != null) goto L43;
        v(r29);
        Object r24 = r13;
    L64:
        if (r24 != null) goto L66;
    L65:
        r18 = 3;
        goto L30
    L66:
        r21.add(r24);
        goto L65
    L43:
        int r25 = r23.intValue();
        Float r112 = o(d(r29, new String[]{"x"}));
        if (r112 != null) goto L46;
        float r26 = 0.0f;
    L47:
        Float r113 = o(d(r29, new String[]{"y"}));
        if (r113 != null) goto L50;
        float r27 = 0.0f;
    L51:
        Float r114 = o(d(r29, new String[]{"blur_radius"}));
        if (r114 != null) goto L54;
        float r28 = 0.0f;
    L55:
        Float r115 = o(d(r29, new String[]{"spread"}));
        if (r115 != null) goto L58;
        float r210 = 0.0f;
    L59:
        Integer r116 = l(d(r29, new String[]{"blend_mode"}));
        if (r116 != null) goto L62;
        int r211 = -1;
    L63:
        r24 = new es.a(r25, r211, r26, r27, r28, r210);
        v(r29);
        goto L64
    L62:
        r211 = r116.intValue();
        goto L63
    L58:
        r210 = r115.floatValue();
        goto L59
    L54:
        r28 = r114.floatValue();
        goto L55
    L50:
        r27 = r113.floatValue();
        goto L51
    L46:
        r26 = r112.floatValue();
        goto L47
    L67:
        v(r29);
        goto L65
    L33:
        if (r111 != r18) goto L30;
        if (r29.getDepth() != r22) goto L30;
    L68:
        Object r30 = r21.toArray(new es.a[0]);
        if (r30 == null) goto L76;
        if (((es.a[]) r30).length != 0) goto L73;
        r30 = r13;
    L73:
        r14.f13613i = (es.a[]) r30;
        goto L14
    L76:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    L78:
        if (r19.equals("fallback_bg_color") == false) goto L25;
        g r31 = u(m(f(r5, r29, MaterialXmlParser$MaterialState.NORMAL, r13, 12)), m(f(r5, r29, MaterialXmlParser$MaterialState.PRESS, r13, 12)), m(f(r5, r29, MaterialXmlParser$MaterialState.HOVER, r13, 12)), m(f(r5, r29, MaterialXmlParser$MaterialState.CHECKED, r13, 12)), m(f(r5, r29, MaterialXmlParser$MaterialState.SELECTED, r13, 12)), m(f(r5, r29, MaterialXmlParser$MaterialState.DISABLE, r13, 12)));
        if (r31 != null) goto L83;
        Object r32 = r13;
    L84:
        if (r32 != null) goto L124;
        Integer r33 = m(d(r29, new String[]{"color"}));
        if (r33 == null) goto L88;
        v(r29);
        ColorStateList r34 = ColorStateList.valueOf(r33.intValue());
    L125:
        r14.f13609a = r34;
        goto L14
    L88:
        int r35 = r29.getDepth();
        Object r36 = r13;
        Object r212 = r36;
        Object r213 = r212;
        Object r214 = r213;
        Object r215 = r214;
        Object r216 = r215;
    L89:
        int r37 = r29.next();
        if (r37 == 1) goto L117;
        if (r37 != 2) goto L93;
        String r38 = h(r29.getName());
        if (Intrinsics.areEqual(r38, MaterialXmlParser$MaterialState.NORMAL.getNodeName()) == true) goto L100;
        if (Intrinsics.areEqual(r38, MaterialXmlParser$MaterialState.PRESS.getNodeName()) == true) goto L103;
        if (Intrinsics.areEqual(r38, MaterialXmlParser$MaterialState.HOVER.getNodeName()) == true) goto L106;
        if (Intrinsics.areEqual(r38, MaterialXmlParser$MaterialState.CHECKED.getNodeName()) == true) goto L109;
        if (Intrinsics.areEqual(r38, MaterialXmlParser$MaterialState.SELECTED.getNodeName()) == true) goto L112;
        if (Intrinsics.areEqual(r38, MaterialXmlParser$MaterialState.DISABLE.getNodeName()) == true) goto L115;
        v(r29);
        goto L89
    L115:
        r216 = n(r29);
        goto L89
    L112:
        r215 = n(r29);
        goto L89
    L109:
        r214 = n(r29);
        goto L89
    L106:
        r213 = n(r29);
        goto L89
    L103:
        r212 = n(r29);
        goto L89
    L100:
        r36 = n(r29);
        goto L89
    L93:
        if (r37 != 3) goto L89;
        if (r29.getDepth() != r35) goto L89;
    L117:
        if (r36 != null) goto L119;
        Object r217 = r13;
    L120:
        g r39 = u(r217, r212, r213, r214, r215, r216);
        if (r39 != null) goto L123;
        r34 = r13;
        goto L125
    L123:
        r34 = c(r39);
        goto L125
    L119:
        r217 = r36;
        goto L120
    L124:
        v(r29);
        r34 = r32;
        goto L125
    L83:
        r32 = c(r31);
        goto L84
    L127:
        if (r19.equals("blur_config") == false) goto L25;
        Float r40 = o(d(r29, new String[]{"blur_radius"}));
        String r41 = d(r29, new String[]{"direction"});
        if (r41 != null) goto L132;
        Integer r42 = r13;
    L159:
        if (r42 != 0) goto L161;
        int r218 = 0;
    L162:
        Float r43 = o(d(r29, new String[]{"alpha"}));
        if (r43 != null) goto L165;
        float r219 = 1.0f;
    L166:
        String r44 = d(r29, new String[]{"curve_type"});
        if (r44 != null) goto L169;
        Integer r45 = r13;
    L200:
        if (r45 != 0) goto L202;
    L201:
        int r220 = r20;
        Float r46 = o(d(r29, new String[]{"end_point"}));
        if (r46 != null) goto L206;
        float r221 = 1.0f;
    L207:
        v(r29);
        if (r40 != null) goto L210;
        xq.a r47 = r13;
    L211:
        r14.g = r47;
        goto L14
    L210:
        r47 = new xq.a(r40.floatValue(), r219, r221, r218, r220);
        goto L211
    L206:
        r221 = r46.floatValue();
        goto L207
    L202:
        r20 = r45.intValue();
        goto L201
    L169:
        String r117 = h(r44);
        switch(r117.hashCode()) {
            case -1102672091: goto L197;
            case -356211779: goto L193;
            case -32570448: goto L189;
            case 54365080: goto L185;
            case 1672389401: goto L181;
            case 1829408660: goto L177;
            case 1939029025: goto L173;
            default: goto L198;
        };
    L198:
        r45 = StringsKt.toIntOrNull(r44);
        goto L200
    L173:
        if (r117.equals("in_quad") == false) goto L198;
        r45 = 1;
        goto L200
    L177:
        if (r117.equals("inout_cubic") == false) goto L198;
        r45 = 6;
        goto L200
    L181:
        if (r117.equals("out_cubic") == false) goto L198;
        r45 = 5;
        goto L200
    L185:
        if (r117.equals("out_quad") == false) goto L198;
        r45 = 2;
        goto L200
    L189:
        if (r117.equals("in_cubic") == false) goto L198;
        r45 = 4;
        goto L200
    L193:
        if (r117.equals("inout_quad") == false) goto L198;
        r45 = 3;
        goto L200
    L197:
        if (r117.equals("linear") == false) goto L198;
        r45 = 0;
        goto L200
    L165:
        r219 = r43.floatValue();
        goto L166
    L161:
        r218 = r42.intValue();
        goto L162
    L132:
        String r48 = h(r41);
        switch(r48.hashCode()) {
            case -1372950257: goto L156;
            case -1039745817: goto L152;
            case -885896177: goto L148;
            case -149309725: goto L144;
            case 3387192: goto L140;
            case 818060433: goto L136;
            default: goto L157;
        };
    L157:
        r42 = StringsKt.toIntOrNull(r41);
        goto L159
    L136:
        if (r48.equals("progress_rightleft") == false) goto L157;
        r42 = 4;
        goto L159
    L140:
        if (r48.equals("none") == false) goto L157;
        r42 = -1;
        goto L159
    L144:
        if (r48.equals("progress_leftright") == false) goto L157;
        r42 = 3;
        goto L159
    L148:
        if (r48.equals("progress_updown") == false) goto L157;
        r42 = 2;
        goto L159
    L152:
        if (r48.equals("normal") == false) goto L157;
        r42 = 0;
        goto L159
    L156:
        if (r48.equals("progress_downup") == false) goto L157;
        r42 = 1;
    L25:
        char r49 = 4;
    L362:
        v(r29);
    L331:
        r5 = this;
    L274:
        r13 = null;
        goto L14
    L213:
        if (r19.equals("stroke_statelist") == false) goto L25;
        boolean r50 = g(r29, new String[]{"width", "color"});
        int[] r51 = cs.c.d;
        if (r50 == false) goto L221;
        com.obric.oui.color.d r52 = s(r29);
        if (r52 != null) goto L220;
        cs.c r53 = r13;
    L272:
        if (r53 == 0) goto L274;
        r14.d = r53;
        goto L274
    L220:
        r53 = new cs.c(new int[][]{r51}, new com.obric.oui.color.d[]{r52}, r52);
        goto L272
    L221:
        int r54 = r29.getDepth();
        Object r55 = r13;
        Object r56 = r55;
        Object r222 = r56;
        Object r223 = r222;
        Object r224 = r223;
        Object r225 = r224;
        Object r226 = r225;
    L222:
        int r118 = r29.next();
        if (r118 == 1) goto L254;
        if (r118 != 2) goto L226;
        String r119 = h(r29.getName());
        if (Intrinsics.areEqual(r119, "stroke") == false) goto L236;
        r56 = s(r29);
        goto L222
    L236:
        if (Intrinsics.areEqual(r119, MaterialXmlParser$MaterialState.NORMAL.getNodeName()) == false) goto L239;
        r55 = t(r29);
        goto L222
    L239:
        if (Intrinsics.areEqual(r119, MaterialXmlParser$MaterialState.PRESS.getNodeName()) == false) goto L242;
        r222 = t(r29);
        goto L222
    L242:
        if (Intrinsics.areEqual(r119, MaterialXmlParser$MaterialState.HOVER.getNodeName()) == false) goto L245;
        r223 = t(r29);
        goto L222
    L245:
        if (Intrinsics.areEqual(r119, MaterialXmlParser$MaterialState.CHECKED.getNodeName()) == false) goto L248;
        r224 = t(r29);
        goto L222
    L248:
        if (Intrinsics.areEqual(r119, MaterialXmlParser$MaterialState.SELECTED.getNodeName()) == false) goto L251;
        r225 = t(r29);
        goto L222
    L251:
        if (Intrinsics.areEqual(r119, MaterialXmlParser$MaterialState.DISABLE.getNodeName()) == false) goto L253;
        r226 = t(r29);
        goto L222
    L253:
        v(r29);
        goto L222
    L226:
        if (r118 != 3) goto L222;
        if (r29.getDepth() != r54) goto L222;
    L254:
        if (r55 != null) goto L256;
        Object r227 = r56;
    L257:
        g r57 = u(r227, r222, r223, r224, r225, r226);
        if (r57 != null) goto L260;
        r53 = 0;
        goto L272
    L260:
        com.obric.oui.color.d r58 = (com.obric.oui.color.d) r57.f13655a;
        com.obric.oui.color.d r59 = (com.obric.oui.color.d) r57.f13656b;
        com.obric.oui.color.d r60 = (com.obric.oui.color.d) r57.f13657c;
        com.obric.oui.color.d r61 = (com.obric.oui.color.d) r57.d;
        com.obric.oui.color.d r62 = (com.obric.oui.color.d) r57.f;
        if (Intrinsics.areEqual(r58, r58) == true) goto L263;
    L271:
        r53 = new cs.c(new int[][]{new int[]{R.attr.state_pressed}, new int[]{R.attr.state_hovered}, new int[]{R.attr.state_checked}, new int[]{R.attr.state_activated}, new int[]{-16842910}, new int[]{R.attr.state_enabled}}, new com.obric.oui.color.d[]{r59, r60, r61, r58, r62, r58}, r58);
        goto L272
    L263:
        if (Intrinsics.areEqual(r58, r61) == false) goto L271;
        if (Intrinsics.areEqual(r58, r59) == false) goto L271;
        if (Intrinsics.areEqual(r58, r60) == false) goto L271;
        if (Intrinsics.areEqual(r58, r62) == false) goto L271;
        r53 = new cs.c(new int[][]{r51}, new com.obric.oui.color.d[]{r58}, r58);
        goto L272
    L256:
        r227 = r55;
        goto L257
    L277:
        if (r19.equals("fluid") == false) goto L25;
        Float r63 = o(d(r29, new String[]{"refraction_height"}));
        if (r63 != null) goto L282;
    L281:
        float[] r64 = null;
        r49 = 4;
    L330:
        v(r29);
        r14.f13614j = new com.obric.oui.fluid.a(r64);
        goto L331
    L282:
        float r65 = r63.floatValue();
        Float r66 = o(d(r29, new String[]{"refraction_strength"}));
        if (r66 == null) goto L281;
        float r67 = r66.floatValue();
        Float r68 = o(d(r29, new String[]{"highlight_angle"}));
        if (r68 == null) goto L281;
        float r69 = r68.floatValue();
        Float r120 = o(d(r29, new String[]{"highlight_falloff"}));
        if (r120 == null) goto L281;
        float r121 = r120.floatValue();
        Float r122 = o(d(r29, new String[]{"highlight_width"}));
        if (r122 == null) goto L281;
        float r123 = r122.floatValue();
        Float r124 = o(d(r29, new String[]{"highlight_alpha"}));
        if (r124 == null) goto L281;
        float r125 = r124.floatValue();
        Float r70 = o(d(r29, new String[]{"highlight_inset"}));
        if (r70 == null) goto L281;
        float r71 = r70.floatValue();
        Float r72 = o(d(r29, new String[]{"highlight_strength"}));
        if (r72 == null) goto L281;
        r49 = 4;
        r64 = new float[]{r65, r67, r69, r121, r123, r125, r71, r72.floatValue()};
        Integer r73 = m(d(r29, new String[]{"first_layer_highlight_color"}));
        Integer r74 = l(d(r29, new String[]{"first_layer_highlight_blend_mode"}));
        Integer r75 = m(d(r29, new String[]{"second_layer_highlight_color"}));
        Integer r76 = l(d(r29, new String[]{"second_layer_highlight_blend_mode"}));
        Float r126 = o(d(r29, new String[]{"chromatic_aberration"}));
        if (r73 != null) goto L309;
        if (r74 != null) goto L309;
        if (r75 != null) goto L309;
        if (r76 != null) goto L309;
        if (r126 == null) goto L330;
    L309:
        FloatSpreadBuilder r127 = new FloatSpreadBuilder(6);
        r127.addSpread(r64);
        FloatCompanionObject r77 = FloatCompanionObject.INSTANCE;
        if (r73 != null) goto L312;
        int r78 = 0;
    L313:
        r127.add(Float.intBitsToFloat(r78));
        if (r74 != null) goto L316;
        int r79 = BlendMode.SRC_OVER.porterDuffMode;
    L317:
        r127.add(r79);
        if (r75 == null) goto L321;
        r20 = r75.intValue();
    L321:
        r127.add(Float.intBitsToFloat(r20));
        if (r76 != null) goto L324;
        int r80 = BlendMode.SRC_OVER.porterDuffMode;
    L325:
        r127.add(r80);
        if (r126 == null) goto L329;
        r110 = r126.floatValue();
    L329:
        r127.add(r110);
        r64 = r127.toArray();
        goto L330
    L324:
        r80 = r76.intValue();
        goto L325
    L316:
        r79 = r74.intValue();
        goto L317
    L312:
        r78 = r73.intValue();
        goto L313
    L332:
        r49 = 4;
        if (r19.equals("blend_configs") == false) goto L362;
        f r81 = j(r29);
        if (r81 != null) goto L338;
        com.obric.oui.color.a[] r82 = null;
    L339:
        r14.f13611c = r82;
        if (r81 != null) goto L342;
        cs.a r83 = null;
    L343:
        if (r83 == null) goto L331;
        r14.f13610b = r81.f13654b;
        goto L331
    L342:
        r83 = r81.f13654b;
        goto L343
    L338:
        r82 = r81.f13653a;
        goto L339
    L345:
        r49 = 4;
        if (r19.equals("stroke") == false) goto L362;
        r14.e = s(r29);
        goto L331
    L349:
        r49 = 4;
        if (r19.equals("blend_config") == false) goto L362;
        if (g(r29, new String[]{"color"}) == false) goto L358;
        com.obric.oui.color.a r84 = k(r29);
        if (r84 != null) goto L357;
        com.obric.oui.color.a[] r85 = null;
    L359:
        r14.f13611c = r85;
        goto L331
    L357:
        r85 = new com.obric.oui.color.a[]{r84};
        goto L359
    L358:
        r85 = i(r29);
        goto L359
    L360:
        r49 = 4;
        if (r19.equals("overlayblend_configs") == false) goto L362;
        f r86 = j(r29);
        if (r86 == null) goto L331;
        r14.f = r86.f13654b;
        goto L331
    L18:
        if (r17 != 3) goto L14;
        if (r29.getDepth() != r16) goto L14;
        return r14;
    L366:
        return r14;
    L8:
        r12 = c(r11);
        goto L9
    }
}
