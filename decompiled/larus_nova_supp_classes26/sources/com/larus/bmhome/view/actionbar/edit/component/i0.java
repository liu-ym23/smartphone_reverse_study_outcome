package com.larus.bmhome.view.actionbar.edit.component;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.image.loader.ImageLoaderKt;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class i0 {
    public final Context a;
    public final String b;
    public final Map<Integer, Long> c;
    public final Map<Integer, Integer> d;
    public final Function1<com.larus.bmhome.actionbar.model.h, List<com.larus.bmhome.actionbar.model.w>> e;
    public final Function1<com.larus.bmhome.actionbar.model.h, Boolean> f;
    public final Function4<com.larus.bmhome.actionbar.model.h, com.larus.bmhome.actionbar.model.w, Integer, Set<String>, Unit> g;
    public final Function4<com.larus.bmhome.actionbar.model.h, com.larus.bmhome.actionbar.model.w, Integer, String, Unit> h;
    public final Function3<com.larus.bmhome.actionbar.model.j, Integer, Set<String>, Unit> i;
    public final Function3<com.larus.bmhome.actionbar.model.j, Integer, String, Unit> j;
    public final Function1<k0, Unit> k;
    public final Function1<k0, Unit> l;
    public final View m;
    public final LinearLayout n;
    public final Lazy o;
    public final Set<String> p;
    public final Set<String> q;
    public final Map<Integer, Long> r;
    public final Map<Integer, Integer> s;
    public com.larus.bmhome.actionbar.model.a0 t;
    public boolean u;

    public final k0 d() {
        ArrayList r0 = new ArrayList();
        com.larus.bmhome.actionbar.model.a0 r1 = this.t;
        if (r1 == null) goto L5;
        List r2 = r1.c;
    L6:
        if (r2 != null) goto L8;
        r2 = CollectionsKt.emptyList();
    L8:
        Iterator r3 = r2.iterator();
    L10:
        if (r3.hasNext() == false) goto L55;
        com.larus.bmhome.actionbar.model.f0 r4 = (com.larus.bmhome.actionbar.model.f0) r3.next();
        Integer r5 = r4.f();
        if (r5 == null) goto L10;
        int r6 = r5.intValue();
        com.larus.bmhome.actionbar.model.h r7 = r4.d();
        if (r7 == null) goto L29;
        Long r8 = this.c.get(Integer.valueOf(r6));
        List r9 = r7.e;
        if (r9 == null) goto L29;
        Iterator r10 = r9.iterator();
    L19:
        if (r10.hasNext() == false) goto L23;
        Object r11 = r10.next();
        if (Intrinsics.areEqual(((com.larus.bmhome.actionbar.model.w) r11).a, r8) == false) goto L19;
    L24:
        com.larus.bmhome.actionbar.model.w r12 = (com.larus.bmhome.actionbar.model.w) r11;
        if (r12 == null) goto L29;
        k0 r13 = j0.a(r12, r6, this.b);
        if (r13 == null) goto L29;
        r0.add(r13);
        goto L29
    L23:
        r11 = null;
    L29:
        com.larus.bmhome.actionbar.model.j r14 = r4.e();
        if (r14 == null) goto L10;
        Integer r15 = this.d.get(Integer.valueOf(r6));
        String r16 = this.b;
        Intrinsics.checkNotNullParameter(r14, "<this>");
        Intrinsics.checkNotNullParameter(r16, "enterMethod");
        if (j0.f(r14, r15) == true) goto L34;
        k0 r17 = null;
    L53:
        if (r17 == null) goto L10;
        r0.add(r17);
        goto L10
    L34:
        com.larus.bmhome.actionbar.model.z1 r18 = r14.o;
        if (r18 == null) goto L37;
        Map r19 = r18.d;
    L38:
        int r110 = uz8.b.C0138b.c;
        if (r19 == null) goto L41;
        String r111 = (String) r19.get("feature_detail_key");
    L42:
        if (r19 == null) goto L44;
        String r112 = (String) r19.get("feature_detail_value");
    L45:
        List r113 = CollectionsKt.listOfNotNull(uz8.b.C0138b.a.a(r111, r112, r15));
        List r20 = CollectionsKt.listOf(new l0(r6, null, r15, 2));
        com.larus.bmhome.actionbar.model.z1 r21 = r14.o;
        int r22 = uz8.b.e;
        if (r19 == null) goto L48;
        String r23 = (String) r19.get("trigger_scene");
    L49:
        if (r19 == null) goto L51;
        String r24 = (String) r19.get("feature_key");
    L52:
        Intrinsics.checkNotNullParameter(r16, "enterMethod");
        Intrinsics.checkNotNullParameter(r113, "featureDetails");
        r17 = new k0(r20, r21, new uz8.b(r16, r23, r24, uz8.b.a.a(r113)), r113);
        goto L53
    L51:
        r24 = null;
        goto L52
    L48:
        r23 = null;
        goto L49
    L44:
        r112 = null;
        goto L45
    L41:
        r111 = null;
        goto L42
    L37:
        r19 = null;
        goto L38
    L55:
        k0 r25 = (k0) CollectionsKt.firstOrNull(r0);
        if (r25 != null) goto L58;
        return null;
    L58:
        ArrayList r26 = new ArrayList();
        Iterator r27 = r0.iterator();
    L60:
        if (r27.hasNext() == false) goto L62;
        CollectionsKt.addAll(r26, ((k0) r27.next()).a);
        goto L60
    L62:
        ArrayList r28 = new ArrayList();
        Iterator r29 = r0.iterator();
    L64:
        if (r29.hasNext() == false) goto L66;
        CollectionsKt.addAll(r28, ((k0) r29.next()).d);
        goto L64
    L66:
        uz8.b r30 = r25.c;
        int r31 = uz8.b.e;
        uz8.b r32 = new uz8.b(r30.a, r30.b, r30.c, uz8.b.a.a(r28));
        com.larus.bmhome.actionbar.model.z1 r33 = r25.b;
        Intrinsics.checkNotNullParameter(r26, "selections");
        Intrinsics.checkNotNullParameter(r32, "trackingExtra");
        Intrinsics.checkNotNullParameter(r28, "featureDetails");
        return new k0(r26, r33, r32, r28);
    L5:
        r2 = null;
        goto L6
    }

    public final int f() {
        return i(2130972123, 2131103203);
    }

    public final LinearLayout c(String r6) {
        LinearLayout r0 = new LinearLayout(this.a);
        r0.setOrientation(1);
        r0.setPadding(0, e(4), 0, e(12));
        if (r6 != null) goto L5;
    L10:
        return r0;
    L5:
        if ((true ^ StringsKt.isBlank(r6)) == true) goto L8;
        r6 = null;
    L8:
        if (r6 == null) goto L10;
        TextView r1 = new TextView(r0.getContext());
        r1.setText(r6);
        r1.setTextSize(14.0f);
        r1.setTypeface(Typeface.create("sans-serif-medium", 0));
        r1.setTextColor(i(2130972081, 2131103143));
        r1.setPadding(e(16), 0, e(16), 0);
        LinearLayout.LayoutParams r7 = new LinearLayout.LayoutParams(-1, -2);
        r7.bottomMargin = e(8);
        Unit r2 = Unit.INSTANCE;
        r0.addView(r1, r7);
        goto L10
    }

    public final int e(int r3) {
        Resources r0 = this.a.getResources();
        return (int) ((r3 * WindowDisplayMetricsOverride.apply(r0, r0.getDisplayMetrics()).density) + 0.5f);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v53 */
    /* JADX WARN: Type inference failed for: r0v62, types: [android.widget.LinearLayout] */
    /* JADX WARN: Type inference failed for: r0v92 */
    /* JADX WARN: Type inference failed for: r0v93, types: [android.widget.LinearLayout] */
    /* JADX WARN: Type inference failed for: r0v94 */
    /* JADX WARN: Type inference failed for: r0v95 */
    /* JADX WARN: Type inference failed for: r0v98 */
    /* JADX WARN: Type inference failed for: r11v13 */
    /* JADX WARN: Type inference failed for: r11v7 */
    /* JADX WARN: Type inference failed for: r15v1, types: [android.view.View, android.widget.LinearLayout] */
    /* JADX WARN: Type inference failed for: r1v38, types: [com.larus.bmhome.view.actionbar.edit.component.e0] */
    /* JADX WARN: Type inference failed for: r1v80, types: [com.larus.bmhome.view.actionbar.edit.component.c0] */
    /* JADX WARN: Type inference failed for: r2v28, types: [com.larus.bmhome.view.actionbar.edit.component.g0] */
    /* JADX WARN: Type inference failed for: r39v0 */
    /* JADX WARN: Type inference failed for: r39v1 */
    /* JADX WARN: Type inference failed for: r39v2 */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v13, types: [android.widget.LinearLayout] */
    /* JADX WARN: Type inference failed for: r4v14 */
    /* JADX WARN: Type inference failed for: r4v15 */
    /* JADX WARN: Type inference failed for: r4v16 */
    /* JADX WARN: Type inference failed for: r4v18, types: [com.larus.bmhome.view.actionbar.edit.component.d0] */
    /* JADX WARN: Type inference failed for: r4v34 */
    /* JADX WARN: Type inference failed for: r4v53, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r4v54 */
    /* JADX WARN: Type inference failed for: r4v55 */
    /* JADX WARN: Type inference failed for: r4v56 */
    /* JADX WARN: Type inference failed for: r4v57 */
    /* JADX WARN: Type inference failed for: r4v58 */
    /* JADX WARN: Type inference failed for: r4v59 */
    /* JADX WARN: Type inference failed for: r9v2, types: [android.widget.LinearLayout] */
    public final void g(com.larus.bmhome.actionbar.model.a0 r41) {
        Intrinsics.checkNotNullParameter(r41, "config");
        this.t = r41;
        TextView r1 = (TextView) this.m.findViewById(2131390327);
        Intrinsics.checkNotNullParameter(r41, "<this>");
        String r2 = r41.b;
        String r9 = "";
        if (r2 != null) goto L5;
        r2 = "";
    L5:
        r1.setText(r2);
        this.n.removeAllViews();
        List r0 = r41.c;
        if (r0 != null) goto L8;
        r0 = CollectionsKt.emptyList();
    L8:
        Iterator r10 = r0.iterator();
    L10:
        if (r10.hasNext() == false) goto L249;
        com.larus.bmhome.actionbar.model.f0 r3 = (com.larus.bmhome.actionbar.model.f0) r10.next();
        if (r3.d() == null) goto L174;
        LinearLayout r6 = this.n;
        final com.larus.bmhome.actionbar.model.h r5 = r3.d();
        if (r5 != null) goto L16;
        ?? r4 = new View(this.a);
    L47:
        ?? r7 = r4;
        ?? r8 = r6;
        String r26 = r9;
        Iterator r32 = r10;
    L173:
        r8.addView(r7);
    L248:
        r9 = r26;
        r10 = r32;
        goto L10
    L16:
        Integer r11 = r3.f();
        if (r11 == null) goto L171;
        final int r12 = r11.intValue();
        if (r12 == 2) goto L23;
        if (r12 == 1) goto L23;
        boolean r16 = false;
    L24:
        ?? r13 = c(r5.c);
        Long r14 = this.c.get(Integer.valueOf(r12));
        Integer r15 = r5.j;
        if (r15 != null) goto L28;
    L48:
        Function0 r17 = new d0(this, r12);
        final ?? r18 = new e0(this, r5, r12);
        List r19 = (List) this.e.invoke(r5);
        Integer r20 = r5.k;
        if (r20 != null) goto L51;
    L59:
        int r21 = 3;
    L60:
        if (r16 == false) goto L62;
        int r110 = 76;
    L63:
        int r111 = e(r110);
        final ArrayList r112 = new ArrayList();
        ?? r113 = new LinearLayout(this.a);
        r113.setOrientation(1);
        r113.setPadding(e(12), 0, e(12), 0);
        Iterator r114 = CollectionsKt.chunked(r19, r21).iterator();
        int r22 = 0;
        ?? r23 = r13;
    L65:
        if (r114.hasNext() == false) goto L170;
        Object r24 = r114.next();
        int r25 = r22 + 1;
        if (r22 >= 0) goto L69;
        CollectionsKt.throwIndexOverflow();
    L69:
        List r27 = (List) r24;
        LinearLayout r28 = new LinearLayout(r113.getContext());
        r28.setOrientation(0);
        Iterator r29 = r27.iterator();
        int r210 = 0;
        ?? r30 = r23;
    L70:
        String r211 = r9;
        if (r29.hasNext() == false) goto L157;
        Object r31 = r29.next();
        int r212 = r210 + 1;
        if (r210 >= 0) goto L75;
        CollectionsKt.throwIndexOverflow();
    L75:
        final com.larus.bmhome.actionbar.model.w r33 = (com.larus.bmhome.actionbar.model.w) r31;
        final int r213 = (r22 * r21) + r210;
        int r34 = r21;
        this.g.invoke(r5, r33, Integer.valueOf(r213), this.p);
        boolean r35 = Intrinsics.areEqual(r33.a, r14);
        Iterator r36 = r10;
        Long r37 = r14;
        Iterator r214 = r114;
        ?? r115 = r30;
        final ?? r38 = r17;
        com.larus.bmhome.actionbar.model.h r39 = r5;
        Function0 r310 = r17;
        LinearLayout r116 = r6;
        LinearLayout r311 = r28;
        final boolean r40 = r16;
        final ?? r42 = new g0(r18, r33, r213, r38, r112, this, r40);
        if (r16 == false) goto L134;
        String r312 = j0.d(r33);
        if (r312 != null) goto L80;
        String r43 = r211;
    L81:
        LinearLayout r44 = new LinearLayout(this.a);
        r44.setOrientation(1);
        r44.setGravity(17);
        r44.setPadding(0, e(4), 0, 0);
        r44.setContentDescription(r43);
        r44.setClickable(true);
        r44.setFocusable(true);
        if (r35 == false) goto L84;
        int r45 = i(2130972127, 2131103215);
    L85:
        float r46 = e(16);
        if (r35 == false) goto L88;
        Integer r47 = Integer.valueOf(f());
    L89:
        r44.setBackground(j(r45, r46, r47));
        boolean r48 = v19.h.a;
        if (v19.h.a(null) == false) goto L107;
        com.larus.bmhome.actionbar.model.w r49 = r33;
        com.larus.bmhome.actionbar.model.g1 r50 = r49.g;
        if (r50 == null) goto L100;
        String r51 = r50.b;
        if (r51 == null) goto L100;
        if ((!StringsKt.isBlank(r51)) == true) goto L99;
        r51 = null;
    L99:
        if (r51 == null) goto L100;
    L115:
        View r52 = new SimpleDraweeView(this.a);
        GenericDraweeHierarchy r53 = r52.getHierarchy();
        if (r35 == false) goto L118;
        int r313 = f();
    L119:
        r53.setActualImageColorFilter(new PorterDuffColorFilter(r313, PorterDuff.Mode.SRC_IN));
        if (r51 != null) goto L122;
    L125:
        boolean r54 = true;
    L126:
        if (r54 == false) goto L128;
        com.larus.utils.e1.o(r52);
    L129:
        r44.addView(r52, new LinearLayout.LayoutParams(e(20), e(20)));
        TextView r55 = new TextView(r44.getContext());
        r55.setText(r43);
        r55.setTextSize(15.0f);
        r55.setIncludeFontPadding(false);
        r55.setTypeface(Typeface.create("sans-serif-medium", 0));
        r55.setGravity(17);
        if (r35 == false) goto L132;
        int r56 = f();
    L133:
        r55.setTextColor(r56);
        LinearLayout.LayoutParams r57 = new LinearLayout.LayoutParams(-2, -2);
        r57.topMargin = e(4);
        Unit r58 = Unit.INSTANCE;
        r44.addView(r55, r57);
        com.larus.utils.e1.d(r44, new x(r42));
        ?? r314 = r115;
    L153:
        r112.add(TuplesKt.to(r49, r44));
        LinearLayout.LayoutParams r59 = new LinearLayout.LayoutParams(0, r111, 1.0f);
        if (r210 <= 0) goto L156;
        r59.setMarginStart(e(8));
    L156:
        Unit r60 = Unit.INSTANCE;
        r311.addView(r44, r59);
        r28 = r311;
        r9 = r211;
        r210 = r212;
        r114 = r214;
        r21 = r34;
        r10 = r36;
        r14 = r37;
        r5 = r39;
        r17 = r310;
        r6 = r116;
        r30 = r314;
        goto L70
    L132:
        r56 = i(2130972079, 2131103136);
        goto L133
    L128:
        ImageLoaderKt.u(r52, r51, "template_item_photo");
        goto L129
    L122:
        if (StringsKt.isBlank(r51) == true) goto L125;
        r54 = false;
        goto L126
    L118:
        r313 = i(2130972079, 2131103136);
    L100:
        com.larus.bmhome.actionbar.model.g1 r61 = r49.f;
        if (r61 == null) goto L114;
        r51 = r61.b;
        if (r51 == null) goto L114;
        if ((!StringsKt.isBlank(r51)) == true) goto L115;
    L114:
        r51 = null;
        goto L115
    L107:
        r49 = r33;
        com.larus.bmhome.actionbar.model.g1 r62 = r49.f;
        if (r62 == null) goto L114;
        r51 = r62.b;
        if (r51 == null) goto L114;
        if ((!StringsKt.isBlank(r51)) == false) goto L114;
    L88:
        r47 = null;
        goto L89
    L84:
        r45 = i(2130970533, 2131102542);
        goto L85
    L80:
        r43 = r312;
        goto L81
    L134:
        r314 = r115;
        r49 = r33;
        r44 = new LinearLayout(this.a);
        r44.setOrientation(0);
        r44.setGravity(17);
        if (r35 == false) goto L137;
        int r63 = i(2130972127, 2131103215);
    L138:
        float r64 = e(16);
        if (r35 == false) goto L141;
        Integer r65 = Integer.valueOf(f());
    L142:
        r44.setBackground(j(r63, r64, r65));
        TextView r66 = new TextView(r44.getContext());
        String r67 = j0.d(r49);
        if (r67 != null) goto L145;
        r67 = r211;
    L145:
        r66.setText(r67);
        r66.setTextSize(15.0f);
        r66.setIncludeFontPadding(false);
        r66.setMaxLines(1);
        r66.setEllipsize(TextUtils.TruncateAt.END);
        r66.setTypeface(Typeface.create("sans-serif-medium", 0));
        r66.setGravity(17);
        if (r35 == false) goto L148;
        int r68 = f();
    L149:
        r66.setTextColor(r68);
        r44.addView(r66, new LinearLayout.LayoutParams(-2, -2));
        a r69 = b.d(r49);
        if (r69 == null) goto L152;
        View r70 = b.a(r44.getContext(), r69);
        LinearLayout.LayoutParams r71 = new LinearLayout.LayoutParams(-2, -2);
        r71.setMarginStart(e(4));
        Unit r72 = Unit.INSTANCE;
        r44.addView(r70, r71);
    L152:
        com.larus.utils.e1.d(r44, new t(r42));
        goto L153
    L148:
        r68 = i(2130972079, 2131103136);
        goto L149
    L141:
        r65 = null;
        goto L142
    L137:
        r63 = i(2130970533, 2131102542);
        goto L138
    L157:
        int r315 = r21;
        Long r316 = r14;
        ?? r317 = r30;
        com.larus.bmhome.actionbar.model.h r318 = r5;
        LinearLayout r319 = r6;
        LinearLayout r73 = r28;
        Iterator r320 = r10;
        Iterator r215 = r114;
        Function0 r321 = r17;
        int r74 = r315 - r27.size();
        int r75 = 0;
    L158:
        if (r75 >= r74) goto L166;
        View r76 = new View(r113.getContext());
        LinearLayout.LayoutParams r77 = new LinearLayout.LayoutParams(0, r111, 1.0f);
        if ((!r27.isEmpty()) == true) goto L164;
        if (r75 > 0) goto L164;
        int r78 = 0;
    L165:
        r77.setMarginStart(r78);
        Unit r79 = Unit.INSTANCE;
        r73.addView(r76, r77);
        r75 = r75 + 1;
    L164:
        r78 = e(8);
        goto L165
    L166:
        LinearLayout.LayoutParams r80 = new LinearLayout.LayoutParams(-1, r111);
        if (r22 <= 0) goto L169;
        r80.topMargin = e(8);
    L169:
        Unit r81 = Unit.INSTANCE;
        r113.addView(r73, r80);
        r22 = r25;
        r9 = r211;
        r114 = r215;
        r21 = r315;
        r10 = r320;
        r14 = r316;
        r5 = r318;
        r17 = r321;
        r6 = r319;
        r23 = r317;
        goto L65
    L170:
        LinearLayout r322 = r6;
        r26 = r9;
        r32 = r10;
        r23.addView(r113);
        ?? r82 = r23;
    L172:
        r8 = r322;
        r7 = r82;
        goto L173
    L62:
        r110 = 48;
        goto L63
    L51:
        if (r20.intValue() <= 0) goto L53;
        boolean r117 = true;
    L54:
        if (r117 == true) goto L57;
        r20 = null;
    L57:
        if (r20 == null) goto L59;
        r21 = r20.intValue();
        goto L60
    L53:
        r117 = false;
        goto L54
    L28:
        if (r15.intValue() != 3) goto L48;
        ?? r83 = new c0(this, r12, r5);
        LinearLayout r84 = new LinearLayout(this.a);
        r84.setOrientation(1);
        List r85 = r5.e;
        if (r85 != null) goto L32;
        r85 = CollectionsKt.emptyList();
    L32:
        TextView r86 = new TextView(this.a);
        r86.setTextSize(14.0f);
        r86.setTextColor(f());
        r86.setGravity(8388613);
        Iterator r118 = r85.iterator();
        int r119 = 0;
    L34:
        if (r118.hasNext() == false) goto L39;
        if (Intrinsics.areEqual(((com.larus.bmhome.actionbar.model.w) r118.next()).a, r14) == true) goto L37;
        r119 = r119 + 1;
        goto L34
    L37:
        int r120 = r119;
    L40:
        int r87 = RangesKt.coerceAtLeast(r120, 0);
        SeekBar r121 = new SeekBar(this.a);
        r121.setMax(RangesKt.coerceAtLeast(r85.size() - 1, 0));
        r121.setProgress(RangesKt.coerceIn(r87, 0, r121.getMax()));
        r121.setOnSeekBarChangeListener(new h0(r85, r86, r83));
        com.larus.bmhome.actionbar.model.w r88 = (com.larus.bmhome.actionbar.model.w) CollectionsKt.getOrNull(r85, r121.getProgress());
        if (r88 == null) goto L43;
        String r122 = j0.d(r88);
    L44:
        if (r122 != null) goto L46;
        r122 = r9;
    L46:
        r86.setText(r122);
        r84.addView(r86);
        r84.addView(r121);
        r13.addView(r84);
        r4 = r13;
        goto L47
    L43:
        r122 = null;
        goto L44
    L39:
        r120 = -1;
    L23:
        r16 = true;
        goto L24
    L171:
        r322 = r6;
        r26 = r9;
        r32 = r10;
        r82 = new View(this.a);
        goto L172
    L174:
        r26 = r9;
        r32 = r10;
        if (r3.e() == null) goto L248;
        ?? r89 = this.n;
        final com.larus.bmhome.actionbar.model.j r123 = r3.e();
        if (r123 != null) goto L179;
        View r90 = new View(this.a);
    L247:
        r89.addView(r90);
        goto L248
    L179:
        Integer r91 = r3.f();
        if (r91 == null) goto L245;
        final int r124 = r91.intValue();
        LinearLayout r125 = c(r123.b);
        Integer r92 = r123.d;
        if (r92 == null) goto L184;
        int r93 = r92.intValue();
    L185:
        Integer r94 = r123.e;
        if (r94 == null) goto L188;
        int r95 = r94.intValue();
    L189:
        Integer r96 = r123.f;
        if (r96 == null) goto L192;
        int r97 = r96.intValue();
    L193:
        Integer r98 = Integer.valueOf(r97);
        if (r98.intValue() <= 0) goto L196;
        boolean r99 = true;
    L197:
        if (r99 == true) goto L200;
        r98 = null;
    L200:
        if (r98 == null) goto L202;
        int r100 = r98.intValue();
    L203:
        boolean r126 = this.d.containsKey(Integer.valueOf(r124));
        if (r126 == false) goto L207;
        Integer r101 = this.d.get(Integer.valueOf(r124));
    L206:
        Integer r127 = r101;
        if (r127 == null) goto L214;
        int r102 = r127.intValue();
    L218:
        int r128 = RangesKt.coerceIn(r102, r93, r95);
        if (j0.f(r123, this.d.get(Integer.valueOf(r124))) == true) goto L221;
        this.s.put(Integer.valueOf(r124), this.d.get(Integer.valueOf(r124)));
    L221:
        final CollaboratedDurationSliderView r103 = new CollaboratedDurationSliderView(this.a, null, 6, 0);
        boolean r104 = !Intrinsics.areEqual(r123.g, Boolean.FALSE);
        Function1<? super Integer, String> r105 = new r(r123);
        Function1<? super Integer, Integer> r106 = new y(r123, this);
        Intrinsics.checkNotNullParameter(r105, "valueFormatter");
        Intrinsics.checkNotNullParameter(r106, "upgradeBadgeWidthProvider");
        r103.d = r93;
        r103.e = RangesKt.coerceAtLeast(r95, r93);
        Integer r107 = Integer.valueOf(r100);
        if (r107.intValue() <= 0) goto L224;
        boolean r108 = true;
    L225:
        if (r108 == true) goto L228;
        r107 = null;
    L228:
        if (r107 == null) goto L230;
        int r109 = r107.intValue();
    L231:
        r103.f = r109;
        r103.h = r104;
        r103.i = r105;
        r103.j = r106;
        r103.g = RangesKt.coerceIn(r128, r103.d, r103.e);
        r103.f();
        r103.invalidate();
        final FrameLayout r129 = new FrameLayout(this.a);
        r129.setVisibility(8);
        r129.setImportantForAccessibility(2);
        final Ref.ObjectRef r130 = new Ref.ObjectRef();
        final FrameLayout r131 = new FrameLayout(this.a);
        r131.addView(r103, new FrameLayout.LayoutParams(-1, e(80)));
        r131.addView(r129, new FrameLayout.LayoutParams(-2, -2));
        r103.setOnDurationTrackingStarted(new z(r123, this, r124));
        boolean r132 = false;
        r103.setOnDurationChanged(new a0(this, r124, r123, r130, r129, r103, r131));
        r103.setOnDurationTrackingFinished(new b0(this, r124, r123));
        if (r126 == false) goto L241;
        if (r127 != null) goto L235;
    L240:
        if (r132 == true) goto L241;
    L244:
        this.i.invoke(r123, this.d.get(Integer.valueOf(r124)), this.p);
        r125.addView(r131, new LinearLayout.LayoutParams(-1, e(80)));
        b(r123, r130, r129, this, r103, r131, this.d.get(Integer.valueOf(r124)));
        r90 = r125;
        goto L247
    L235:
        if (r127.intValue() == r128) goto L237;
        boolean r133 = true;
        boolean r134 = true;
    L238:
        if (r134 != r133) goto L240;
        r132 = true;
        goto L240
    L237:
        r133 = true;
        r134 = false;
    L241:
        this.d.put(Integer.valueOf(r124), Integer.valueOf(r128));
        if (j0.f(r123, Integer.valueOf(r128)) == true) goto L244;
        this.s.put(Integer.valueOf(r124), Integer.valueOf(r128));
        goto L244
    L230:
        r109 = 1;
        goto L231
    L224:
        r108 = false;
        goto L225
    L214:
        Integer r135 = r123.h;
        if (r135 == null) goto L217;
        r102 = r135.intValue();
        goto L218
    L217:
        r102 = r93;
        goto L218
    L207:
        Integer r136 = r123.h;
        if (r136 == null) goto L210;
        int r137 = r136.intValue();
    L211:
        r101 = Integer.valueOf(r137);
        goto L206
    L210:
        r137 = r93;
        goto L211
    L202:
        r100 = 1;
        goto L203
    L196:
        r99 = false;
        goto L197
    L192:
        r97 = 1;
        goto L193
    L188:
        r95 = r93;
        goto L189
    L184:
        r93 = 0;
        goto L185
    L245:
        r90 = new View(this.a);
        goto L247
    L249:
        k(true);
    }

    public final void h(k0 r12) {
        if (this.u == false) goto L9;
        Set<String> r0 = this.q;
        uz8.b r2 = r12.c;
        if (r0.add(CollectionsKt.joinToString$default(CollectionsKt.listOf(new String[]{r12.a(), r2.a, r2.b, r2.c, r2.d}), "|", null, null, 0, null, null, 62, null)) == false) goto L10;
        this.k.invoke(r12);
        return;
    L10:
        return;
    }

    public final void k(boolean r6) {
        k0 r0 = d();
        TextView r1 = (TextView) this.o.getValue();
        if (r0 == null) goto L13;
        Context r2 = this.a;
        com.larus.bmhome.actionbar.model.z1 r3 = r0.b;
        if (r3 == null) goto L11;
        String r4 = r3.c;
        if (r4 == null) goto L11;
        if ((!StringsKt.isBlank(r4)) == false) goto L11;
    L12:
        String r5 = j0.c(r2, r4);
    L14:
        r1.setText(r5);
        if (r6 == false) goto L19;
        if (r0 == null) goto L20;
        h(r0);
        return;
    L20:
        return;
    L19:
        return;
    L11:
        r4 = null;
        goto L12
    L13:
        r5 = this.a.getString(2131899466);
        Intrinsics.checkNotNull(r5);
        goto L14
    }

    public final int i(int r2, int r3) {
        Context r0 = this.a;
        return ContextCompat.getColor(r0, v19.c.b(r2, r0, r3));
    }

    public final GradientDrawable j(int r3, float r4, Integer r5) {
        GradientDrawable r0 = new GradientDrawable();
        r0.setShape(0);
        r0.setColor(r3);
        r0.setCornerRadius(r4);
        if (r5 == null) goto L5;
        int r6 = r5.intValue();
        r0.setStroke(e(1), r6);
    L5:
        return r0;
    }

    public static final void a(com.larus.bmhome.actionbar.model.j r4, FrameLayout r5, CollaboratedDurationSliderView r6, i0 r7, int r8, int r9) {
        String r10 = r4.a(Integer.valueOf(r8));
        if (r10 != null) goto L5;
        r10 = "";
    L5:
        int r11 = r7.e(2);
        r6.getClass();
        Intrinsics.checkNotNullParameter(r10, "label");
        float r0 = r6.e();
        float r1 = r6.d();
        int r12 = RangesKt.coerceIn(r8, r6.d, r6.e);
        int r2 = r6.e;
        int r3 = r6.d;
        if (r2 <= r3) goto L9;
        r0 = r0 + (((r1 - r0) * (r12 - r3)) / (r2 - r3));
    L9:
        float r13 = r6.s.measureText(r10);
        float r14 = r11;
        float r15 = ((r13 + r14) + r9) / 2.0f;
        float r16 = r6.c();
        float r17 = r15 + r16;
        float r18 = (r6.getWidth() - r15) - r16;
        if (r18 < r17) goto L12;
        float r19 = RangesKt.coerceIn(r0, r17, r18);
    L13:
        r5.setX(((r19 - r15) + r13) + r14);
        r5.setY(r6.a(3));
        return;
    L12:
        r19 = r6.getWidth() / 2.0f;
        goto L13
    }

    public static final void b(final com.larus.bmhome.actionbar.model.j r9, Ref.ObjectRef<String> r10, final FrameLayout r11, final i0 r12, final CollaboratedDurationSliderView r13, FrameLayout r14, final Integer r15) {
        m0 r0 = j0.b(r9, r15);
        if (r0 == null) goto L19;
        if (r15 == null) goto L19;
        final int r1 = r12.e(r0.b);
        int r2 = r12.e(r0.c);
        ViewGroup.LayoutParams r3 = r11.getLayoutParams();
        r3.width = r1;
        r3.height = r2;
        r11.setLayoutParams(r3);
        r11.requestLayout();
        String r4 = r0.a + '|' + r0.b + '|' + r0.c + '|' + r0.d;
        if (Intrinsics.areEqual(r10.element, r4) == true) goto L9;
    L10:
        r10.element = r4;
        r11.removeAllViews();
        SimpleDraweeView r16 = new SimpleDraweeView(r12.a);
        Integer r5 = r0.d;
        if (r5 == null) goto L13;
        r16.getHierarchy().setRoundingParams(RoundingParams.fromCornersRadius(r12.e(r5.intValue())));
    L13:
        ImageLoaderKt.u(r16, r0.a, "template_item_photo");
        r11.addView(r16, new FrameLayout.LayoutParams(r1, r2));
    L15:
        if (r13.getWidth() <= 0) goto L17;
        a(r9, r11, r13, r12, r15.intValue(), r1);
        r11.setVisibility(0);
        return;
    L17:
        r11.setVisibility(4);
        r14.post(new f0(r15, r1, r11, r9, r13, r12));
        return;
    L9:
        if (r11.getChildCount() != 0) goto L15;
    L19:
        r10.element = null;
        r11.removeAllViews();
        r11.setVisibility(8);
    }

    public i0(Context r2, String r3, Map r4, Map r5, k r6, l r7, Function4 r8, Function4 r9, Function3 r10, Function3 r11, Function1 r12, m r13, final n r14, final o r15) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "creationEnterMethod");
        Intrinsics.checkNotNullParameter(r4, "draftDropdownSelections");
        Intrinsics.checkNotNullParameter(r5, "draftDurations");
        Intrinsics.checkNotNullParameter(r6, "visibleOptionProvider");
        Intrinsics.checkNotNullParameter(r7, "shouldInterceptRatioClick");
        Intrinsics.checkNotNullParameter(r8, "onDropdownOptionShow");
        Intrinsics.checkNotNullParameter(r9, "onDropdownOptionClick");
        Intrinsics.checkNotNullParameter(r10, "onDurationOptionShow");
        Intrinsics.checkNotNullParameter(r11, "onDurationOptionClick");
        Intrinsics.checkNotNullParameter(r12, "onSubscribeGuidanceShow");
        Intrinsics.checkNotNullParameter(r13, "onSubscribeRequired");
        Intrinsics.checkNotNullParameter(r14, "onClose");
        Intrinsics.checkNotNullParameter(r15, "onConfirm");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
        this.i = r10;
        this.j = r11;
        this.k = r12;
        this.l = r13;
        View r16 = LayoutInflater.from(r2).inflate(2131562043, null);
        r16.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        com.larus.utils.e1.d(r16.findViewById(2131390326), new u(r14));
        com.larus.utils.e1.d(r16.findViewById(2131390325), new v(this, r15));
        this.m = r16;
        LinearLayout r17 = new LinearLayout(r2);
        r17.setOrientation(1);
        this.n = r17;
        this.o = LazyKt.lazy(new w(this));
        this.p = new LinkedHashSet();
        this.q = new LinkedHashSet();
        this.r = MapsKt.toMutableMap(r4);
        this.s = MapsKt.toMutableMap(r5);
        r16.findViewById(2131367112).addView(r17, new ViewGroup.LayoutParams(-1, -2));
    }
}
