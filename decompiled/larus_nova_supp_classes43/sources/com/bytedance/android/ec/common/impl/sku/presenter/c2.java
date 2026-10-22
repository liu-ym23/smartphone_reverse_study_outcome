package com.bytedance.android.ec.common.impl.sku.presenter;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import com.bytedance.android.ec.common.impl.sku.model.SkuInfoVO;
import com.bytedance.android.ec.common.impl.sku.model.SkuItemInfoVO;
import com.bytedance.android.ec.common.impl.sku.model.SpecInfo;
import com.bytedance.android.ec.common.impl.sku.model.SpecInfoItem;
import com.bytedance.android.ec.common.impl.sku.view.GroupTitleLayout;
import com.bytedance.android.ec.common.impl.sku.view.SpecItemGroupLayout;
import com.bytedance.android.ec.common.impl.sku.view.SpecItemLayout$setSkuItemAccessibility$1;
import com.bytedance.android.ec.common.impl.sku.view.SpecItemView;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.model.sku.SkuRestoreState;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class c2<T> implements Observer {
    public final /* synthetic */ f2 a;

    public c2(f2 r1) {
        this.a = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v1, types: [android.view.ViewGroup, com.bytedance.android.ec.common.impl.sku.view.SpecItemGroupLayout, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v150, types: [android.view.ViewGroup, com.bytedance.android.ec.common.impl.sku.view.SpecItemGroupLayout, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v156, types: [android.view.ViewGroup, com.bytedance.android.ec.common.impl.sku.view.SpecItemGroupLayout] */
    /* JADX WARN: Type inference failed for: r1v183 */
    /* JADX WARN: Type inference failed for: r1v215 */
    /* JADX WARN: Type inference failed for: r3v38, types: [android.view.ViewGroup, com.bytedance.android.ec.common.impl.sku.view.SpecItemGroupLayout] */
    /* JADX WARN: Type inference failed for: r5v23, types: [android.view.View, android.widget.TextView, androidx.appcompat.widget.AppCompatTextView, com.bytedance.android.ec.common.impl.sku.view.SpecItemView] */
    /* JADX WARN: Type inference failed for: r5v26, types: [com.bytedance.android.ec.common.impl.sku.view.SpecItemView] */
    public final void onChanged(Object r35) {
        c2<T> r0 = this;
        SkuInfoVO r10 = (SkuInfoVO) r35;
        if (r10 != null) goto L5;
        return;
    L5:
        if (f2.e0(r0.a).getSkuPanelState() != null) goto L7;
        f2.e0(r0.a).setSkuPanelState(new SkuRestoreState(r10.getSpecInfoList().size()));
    L7:
        SkuRestoreState r1 = f2.e0(r0.a).getSkuPanelState();
        Object r11 = null;
        if (r1 != null) goto L10;
    L34:
        Iterator<T> r12 = r10.getSpecInfoList().iterator();
        int r13 = 0;
    L36:
        if (r12.hasNext() == false) goto L55;
        T r14 = r12.next();
        int r15 = r13 + 1;
        if (r13 >= 0) goto L41;
        CollectionsKt.throwIndexOverflow();
    L41:
        if (Intrinsics.areEqual(((SpecInfo) r14).getHideSpec(), Boolean.TRUE) == false) goto L54;
        SkuRestoreState r16 = f2.e0(r0.a).getSkuPanelState();
        if (r16 == null) goto L47;
        String[] r17 = r16.getSelectSkuKeys();
        if (r17 == null) goto L47;
        int r18 = r17.length;
    L48:
        if (r13 >= r18) goto L54;
        SkuRestoreState r19 = f2.e0(r0.a).getSkuPanelState();
        if (r19 == null) goto L54;
        String[] r20 = r19.getSelectSkuKeys();
        if (r20 == null) goto L54;
        r20[r13] = null;
    L47:
        r18 = 0;
    L54:
        r13 = r15;
        goto L36
    L55:
        int r21 = qf.a.a;
        String r110 = "groupTitleVO";
        String r111 = "specTitle";
        if (qf.a.e.a(f2.e0(r0.a).getSkuParams()) == true) goto L278;
        r0.a.i0();
        ?? r22 = f2.d0(r0.a);
        SkuRestoreState r23 = f2.e0(r0.a).getSkuPanelState();
        if (r23 == null) goto L60;
        String[] r24 = r23.getSelectSkuKeys();
    L61:
        int r112 = f2.e0(r0.a).getSkuParams().getSceneType();
        String r25 = f2.e0(r0.a).getBaseParamsJson();
        Integer r113 = f2.e0(r0.a).getSkuParams().getHeightPercent();
        r22.getClass();
        Intrinsics.checkNotNullParameter(r25, "baseParamsJson");
        List<SpecInfo> r26 = r10.getSpecInfoList();
        if (r26 != null) goto L64;
    L67:
        boolean r27 = true;
    L68:
        if (r27 == true) goto L277;
        int r28 = r10.getSpecInfoList().size();
        r22.c = new String[r28];
        if (r10.getPictureMap() == null) goto L276;
        r22.b = new cg.g(r22.getContext(), r10.getSkuList(), r10.getPictureMap(), r10.getBigPicMap(), r10.getUpperLimit(), r10.getLowerLimit(), r10.getLimitText());
        List<SpecInfo> r29 = r10.getSpecInfoList();
        Map<String, String> r210 = r10.getPictureMap();
        List<SpecInfo> r211 = r29;
        if (r211 != null) goto L75;
    L78:
        boolean r212 = true;
    L79:
        if (r212 == true) goto L122;
        r22.j.clear();
        r22.g.clear();
        r22.h.clear();
        r22.i.clear();
        r22.i.add("默认");
        String[] r114 = new String[r29.size()];
        List<String> r115 = r22.g;
        cg.g r30 = r22.b;
        if (r30 == null) goto L84;
        String r31 = r30.j(r114);
    L85:
        r115.add(r31);
        List<String> r32 = r22.h;
        cg.g r116 = r22.b;
        if (r116 == null) goto L88;
        String r117 = r116.h(r114);
    L89:
        r32.add(r117);
        List<SpecInfoItem> r33 = ((SpecInfo) ListProtector.get(r29, 0)).getSpecItems();
        if (r210 != null) goto L92;
    L94:
        Iterator<T> r34 = r33.iterator();
    L96:
        if (r34.hasNext() == false) goto L122;
        SpecInfoItem r36 = (SpecInfoItem) r34.next();
        r114[0] = r36.getId();
        cg.g r118 = r22.b;
        if (r118 == null) goto L100;
        boolean r119 = r118.a(r114);
    L101:
        if (r119 == false) goto L108;
        cg.g r120 = r22.b;
        if (r120 == null) goto L105;
        Object r121 = r120.j(r114);
    L106:
        if (r121 == null) goto L108;
        boolean r122 = true;
    L109:
        if (r122 == false) goto L111;
        Object r123 = r114;
    L112:
        if (r123 == null) goto L96;
        r22.j.add(r36.getId());
        r22.i.add(r36.getName());
        List<String> r37 = r22.g;
        cg.g r38 = r22.b;
        if (r38 == null) goto L116;
        String r39 = r38.j(r114);
    L117:
        r37.add(r39);
        List<String> r40 = r22.h;
        cg.g r41 = r22.b;
        if (r41 == null) goto L120;
        String r42 = r41.h(r114);
    L121:
        r40.add(r42);
        r11 = null;
        goto L96
    L120:
        r42 = null;
        goto L121
    L116:
        r39 = null;
        goto L117
    L111:
        r123 = r11;
        goto L112
    L105:
        r121 = r11;
    L108:
        r122 = false;
        goto L109
    L100:
        r119 = false;
        goto L101
    L92:
        if (r210.size() != 0) goto L94;
    L88:
        r117 = null;
        goto L89
    L84:
        r31 = null;
    L122:
        List<SpecInfo> r43 = r10.getSpecInfoList();
        ArrayList r44 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r43, 10));
        Iterator<T> r124 = r43.iterator();
        int r125 = 0;
        ?? r45 = r22;
    L124:
        if (r124.hasNext() == false) goto L215;
        T r46 = r124.next();
        int r213 = r125 + 1;
        if (r125 >= 0) goto L128;
        CollectionsKt.throwIndexOverflow();
    L128:
        SpecInfo r214 = (SpecInfo) r46;
        ArrayList r47 = new ArrayList();
        Iterator<SpecInfoItem> r48 = r214.getSpecItems().iterator();
    L130:
        if (r48.hasNext() == false) goto L160;
        SpecInfoItem r215 = r48.next();
        if (r215.getId() != null) goto L134;
    L158:
        Iterator<SpecInfoItem> r216 = r48;
        ArrayList r310 = r47;
        String r217 = r25;
    L159:
        r48 = r216;
        r25 = r217;
        r47 = r310;
        goto L130
    L134:
        if (r215.getName() == null) goto L158;
        String r126 = r215.getId();
        Intrinsics.checkNotNull(r126);
        String r127 = r215.getName();
        Intrinsics.checkNotNull(r127);
        r216 = r48;
        r217 = r25;
        com.bytedance.android.ec.common.impl.sku.view.n.c r49 = new com.bytedance.android.ec.common.impl.sku.view.n.c(r126, r127, r215.getDefaultSelect(), r215.getIcon());
        String[] r50 = new String[r28];
        r50[r125] = r215.getId();
        cg.g r51 = r45.b;
        if (r51 == null) goto L138;
        boolean r52 = r51.a(r50);
    L139:
        r49.a = r52;
        r47.add(r49);
        if (r24 == null) goto L142;
        Integer r53 = Integer.valueOf(r24.length);
    L143:
        if (r53 != null) goto L146;
    L157:
        r310 = r47;
        goto L159
    L146:
        if (r28 != r53.intValue()) goto L157;
        r310 = r47;
        if (StringsKt.equals$default(r215.getId(), r24[r125], false, 2, null) == false) goto L159;
        if (r49.a == false) goto L156;
        String[] r54 = r45.c;
        Intrinsics.checkNotNull(r54);
        r54[r125] = r215.getId();
        cg.g r55 = r45.b;
        if (r55 == null) goto L159;
        String[] r56 = r45.c;
        Intrinsics.checkNotNull(r56);
        if (r55.a(r56) == true) goto L159;
        String[] r57 = r45.c;
        Intrinsics.checkNotNull(r57);
        r57[r125] = null;
        r24[r125] = null;
        goto L159
    L156:
        r24[r125] = null;
        goto L159
    L142:
        r53 = null;
        goto L143
    L138:
        r52 = false;
        goto L139
    L160:
        ArrayList r311 = r47;
        String r218 = r25;
        Context r58 = r45.a;
        Intrinsics.checkNotNull(r58);
        if (r10.getStatus() != 2) goto L163;
        boolean r59 = true;
    L164:
        final com.bytedance.android.ec.common.impl.sku.view.n r128 = new com.bytedance.android.ec.common.impl.sku.view.n(r58, 4, r59);
        r128.setOnItemCheckedListener(new com.bytedance.android.ec.common.impl.sku.view.l(r45, r10));
        String r129 = r214.getName();
        ?? r60 = r45;
        Iterator<T> r219 = r124;
        String[] r61 = r24;
        ArrayList r220 = r44;
        int r130 = r28;
        cg.e r62 = cg.f.c(r10, r45.getContext(), r125, 4, r112, r218, r113);
        SpecItemGroupLayout.d r63 = r60.k;
        if (r61 == null) goto L167;
        String r64 = (String) ArraysKt.getOrNull(r61, r125);
    L168:
        Intrinsics.checkNotNullParameter(r129, "specTitle");
        Intrinsics.checkNotNullParameter(r62, "groupTitleVO");
        if (r128.getContext() != null) goto L171;
    L203:
        String[] r312 = r61;
    L205:
        if (Intrinsics.areEqual(r214.getHideSpec(), Boolean.TRUE) == false) goto L207;
        r128.setVisibility(8);
    L207:
        ((ArrayList) r60.d).add(r128);
        LinearLayoutCompat.LayoutParams r65 = new LinearLayoutCompat.LayoutParams(-1, -2);
        if (r125 != 0) goto L210;
        float r66 = UIUtils.dip2Px(r60.getContext(), 18.0f);
    L211:
        ((LinearLayout.LayoutParams) r65).topMargin = (int) r66;
        r128.setLayoutParams(r65);
        r60.addView(r128);
        if (r125 >= (r10.getSpecInfoList().size() - 1)) goto L214;
        View r67 = new View(r60.getContext());
        LinearLayoutCompat.LayoutParams r68 = new LinearLayoutCompat.LayoutParams(-1, 1);
        ((LinearLayout.LayoutParams) r68).topMargin = (int) UIUtils.dip2Px(r67.getContext(), 20.0f);
        Unit r69 = Unit.INSTANCE;
        r67.setLayoutParams(r68);
        r67.setBackgroundColor(th.a.a(r67.getContext(), 2131101237));
        r60.addView(r67);
    L214:
        r220.add(Unit.INSTANCE);
        r44 = r220;
        r45 = r60;
        r25 = r218;
        r28 = r130;
        r124 = r219;
        r125 = r213;
        r24 = r312;
        goto L124
    L210:
        r66 = UIUtils.dip2Px(r60.getContext(), 12.0f);
        goto L211
    L171:
        if (r311.isEmpty() == true) goto L203;
        ArrayList r70 = r311;
        r128.f = r70;
        r128.j = r125;
        r128.i = 1;
        GroupTitleLayout r71 = new GroupTitleLayout(r128.getContext(), null, 6, 0);
        r71.a(r62, r63);
        Unit r72 = Unit.INSTANCE;
        r128.addView(r71);
        int r73 = r70.size();
        com.bytedance.android.ec.common.impl.sku.view.n.c r74 = null;
        TextView r75 = null;
        int r76 = 0;
        int r77 = 0;
    L174:
        if (r76 >= r73) goto L193;
        final com.bytedance.android.ec.common.impl.sku.view.n.c r78 = (com.bytedance.android.ec.common.impl.sku.view.n.c) ListProtector.get(r70, r76);
        String[] r313 = r61;
        TextView r131 = new TextView(r128.getContext());
        r131.setGravity(17);
        r131.setIncludeFontPadding(false);
        int r314 = r73;
        r131.setTextSize(2, 12.0f);
        r131.setGravity(17);
        int r79 = r128.c;
        int r80 = r128.d;
        r131.setPadding(r79, r80, r79, r80);
        r131.setText(r78.c);
        r131.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        ECUrlModel r81 = r78.e;
        if (r81 == null) goto L179;
        com.bytedance.android.ec.core.utils.y.l(r81, 0, 0, new com.bytedance.android.ec.common.impl.sku.view.p(r128, r131));
    L179:
        r128.addView(r131);
        r128.b(r131, r78, null);
        AccessibilityDelegateCompat r82 = new SpecItemLayout$setSkuItemAccessibility$1(r128, r78);
        int r83 = jg.a.a;
        ViewCompat.setAccessibilityDelegate(r131, r82);
        r131.setOnClickListener(new com.bytedance.android.ec.common.impl.sku.view.q(r128, r78));
        if (r78.a == false) goto L185;
        r77 = r77 + 1;
        if (r74 != null) goto L185;
        r74 = r78;
        r75 = r131;
    L185:
        if (r78.d == false) goto L192;
        if (r128.g != null) goto L192;
        if (r64 != null) goto L192;
        r128.g = r78;
        r128.b(r131, r78, r78.b);
        com.bytedance.android.ec.common.impl.sku.view.n.b r84 = r128.k;
        if (r84 == null) goto L192;
        r84.d(r125, r78, false);
    L192:
        r76 = r76 + 1;
        r61 = r313;
        r73 = r314;
        r70 = r70;
        goto L174
    L193:
        r312 = r61;
        if (r128.g == null) goto L196;
    L202:
        r128.requestLayout();
        goto L205
    L196:
        if (r77 != 1) goto L202;
        if (r74 == null) goto L202;
        if (r75 == null) goto L202;
        r128.g = r74;
        r128.h = false;
        r128.b(r75, r74, r74.b);
        com.bytedance.android.ec.common.impl.sku.view.n.b r85 = r128.k;
        if (r85 == null) goto L202;
        r85.d(r128.j, r128.g, false);
        goto L202
    L167:
        r64 = null;
        goto L168
    L163:
        r59 = false;
        goto L164
    L215:
        SpecItemGroupLayout r132 = r45;
        String[] r86 = r132.c;
        if (r86 != null) goto L218;
    L255:
        List<SpecInfo> r87 = r10.getSpecInfoList();
        if ((r87 instanceof Collection) == true) goto L258;
    L260:
        Iterator<T> r88 = r87.iterator();
    L262:
        if (r88.hasNext() == false) goto L269;
        if (((SpecInfo) r88.next()).getSpecType() != 1) goto L266;
        boolean r89 = true;
    L267:
        if (r89 == true) goto L262;
        boolean r133 = false;
    L270:
        if (r133 == false) goto L276;
        com.bytedance.android.ec.common.impl.sku.view.n r90 = (com.bytedance.android.ec.common.impl.sku.view.n) CollectionsKt.firstOrNull(r132.d);
        if (r90 == null) goto L276;
        com.bytedance.android.ec.common.impl.sku.view.n.b r91 = r90.k;
        if (r91 == null) goto L276;
        r91.a();
        goto L276
    L266:
        r89 = false;
    L269:
        r133 = true;
        goto L270
    L258:
        if (r87.isEmpty() == false) goto L260;
    L218:
        if (r86.length < r10.getSpecInfoList().size()) goto L220;
        boolean r92 = true;
    L221:
        if (r92 == false) goto L223;
        String[] r93 = r86;
    L224:
        if (r93 == null) goto L255;
        List<SpecInfo> r94 = r10.getSpecInfoList();
        if (r94 == null) goto L255;
        List<SpecInfo> r95 = r94;
        ArrayList r96 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r95, 10));
        Iterator<T> r97 = r95.iterator();
        int r98 = 0;
    L229:
        if (r97.hasNext() == false) goto L255;
        T r99 = r97.next();
        int r100 = r98 + 1;
        if (r98 >= 0) goto L233;
        CollectionsKt.throwIndexOverflow();
    L233:
        SpecInfo r101 = (SpecInfo) r99;
        String r102 = r93[r98];
        com.bytedance.android.ec.common.impl.sku.view.n r103 = (com.bytedance.android.ec.common.impl.sku.view.n) ListProtector.get(r132.d, r98);
        int r104 = r103.f.size();
        int r105 = 0;
    L234:
        if (r105 >= r104) goto L254;
        com.bytedance.android.ec.common.impl.sku.view.n.c r134 = (com.bytedance.android.ec.common.impl.sku.view.n.c) ListProtector.get(r103.f, r105);
        if (TextUtils.equals(r102, r134.b) == false) goto L253;
        boolean r135 = r134.a;
        if (r135 == false) goto L253;
        if (r103.p == false) goto L254;
        if (r135 == false) goto L254;
        com.bytedance.android.ec.common.impl.sku.view.n.c r136 = r103.g;
        if (r136 == null) goto L248;
        Intrinsics.checkNotNull(r136);
        if (TextUtils.equals(r136.b, r134.b) == false) goto L248;
    L250:
        com.bytedance.android.ec.common.impl.sku.view.n.b r137 = r103.k;
        if (r137 == null) goto L253;
        Intrinsics.checkNotNull(r137);
        r137.d(r98, r103.g, false);
    L248:
        if (r134.a == false) goto L250;
        r103.g = r134;
        r103.h = true;
        Intrinsics.checkNotNull(r134);
        r103.e(r134.b);
    L253:
        r105 = r105 + 1;
    L254:
        r96.add(Unit.INSTANCE);
        r98 = r100;
        goto L229
    L223:
        r93 = null;
        goto L224
    L220:
        r92 = false;
        goto L221
    L75:
        if (r211.isEmpty() == true) goto L78;
        r212 = false;
    L276:
        r0 = this;
    L277:
        f2.e0(r0.a).setImageList(f2.d0(r0.a).getImageUrlList());
        f2.e0(r0.a).setNameList(f2.d0(r0.a).getNameList());
        f2.h0(r0.a);
        return;
    L64:
        if (r26.isEmpty() == true) goto L67;
        r27 = false;
        goto L68
    L60:
        r24 = null;
        goto L61
    L278:
        ?? r138 = f2.d0(r0.a);
        SkuRestoreState r106 = f2.e0(r0.a).getSkuPanelState();
        if (r106 == null) goto L281;
        String[] r139 = r106.getSelectSkuKeys();
    L282:
        int r140 = f2.e0(r0.a).getSkuParams().getSceneType();
        String r141 = f2.e0(r0.a).getBaseParamsJson();
        Integer r142 = f2.e0(r0.a).getSkuParams().getHeightPercent();
        r138.getClass();
        Intrinsics.checkNotNullParameter(r141, "baseParamsJson");
        List<SpecInfo> r107 = r10.getSpecInfoList();
        if (r107 != null) goto L285;
    L288:
        boolean r108 = true;
    L289:
        if (r108 == true) goto L510;
        int r109 = r10.getSpecInfoList().size();
        r138.c = new String[r109];
        if (r10.getPictureMap() == null) goto L509;
        r138.b = r138.l.M0();
        r138.j = r138.l.N0();
        r138.g = r138.l.L0();
        r138.h = r138.l.O0();
        r138.i = r138.l.getNameList();
        List<SpecInfo> r143 = r10.getSpecInfoList();
        ArrayList r144 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r143, 10));
        Iterator<T> r145 = r143.iterator();
        int r146 = 0;
    L295:
        if (r145.hasNext() == false) goto L456;
        T r147 = r145.next();
        int r148 = r146 + 1;
        if (r146 >= 0) goto L299;
        CollectionsKt.throwIndexOverflow();
    L299:
        SpecInfo r149 = (SpecInfo) r147;
        ArrayList r150 = new ArrayList();
        String[] r151 = r138.c;
        if (r151 == null) goto L303;
        String[] r152 = (String[]) Arrays.copyOf(r151, r151.length);
        if (r152 == null) goto L303;
    L304:
        Iterator<SpecInfoItem> r153 = r149.getSpecItems().iterator();
        com.bytedance.android.ec.common.impl.sku.view.n.c r154 = null;
        int r155 = 0;
    L306:
        if (r153.hasNext() == false) goto L323;
        SpecInfoItem r221 = r153.next();
        if (r221.getId() == null) goto L322;
        if (r221.getName() == null) goto L322;
        String r156 = r221.getId();
        Intrinsics.checkNotNull(r156);
        String r157 = r221.getName();
        Intrinsics.checkNotNull(r157);
        com.bytedance.android.ec.common.impl.sku.view.n.c r158 = new com.bytedance.android.ec.common.impl.sku.view.n.c(r156, r157, r221.getDefaultSelect(), r221.getIcon());
        r152[r146] = r221.getId();
        cg.g r159 = r138.b;
        if (r159 == null) goto L314;
        boolean r160 = r159.a(r152);
    L315:
        r158.a = r160;
        if (r160 == false) goto L320;
        r155 = r155 + 1;
        if (r154 != null) goto L320;
        r154 = r158;
    L320:
        r150.add(r158);
        goto L322
    L314:
        r160 = false;
    L322:
        r153 = r153;
        r144 = r144;
        r110 = r110;
        r111 = r111;
        goto L306
    L323:
        ArrayList r222 = r144;
        String r223 = r110;
        String r315 = r111;
        if (r139 == null) goto L326;
        Integer r161 = Integer.valueOf(r139.length);
    L327:
        if (r161 != null) goto L330;
    L369:
        List<com.bytedance.android.ec.common.impl.sku.view.n> r162 = r138.d;
        if (r146 >= 0) goto L372;
    L374:
        Context r163 = r138.a;
        Intrinsics.checkNotNull(r163);
        int r164 = 2;
        if (r10.getStatus() != 2) goto L377;
        boolean r165 = true;
    L378:
        int r166 = 4;
        com.bytedance.android.ec.common.impl.sku.view.n r167 = new com.bytedance.android.ec.common.impl.sku.view.n(r163, 4, r165);
        ListProtector.add(r138.d, r146, r167);
        r138.addView(r167);
        Object r168 = r167;
    L379:
        com.bytedance.android.ec.common.impl.sku.view.n r169 = (com.bytedance.android.ec.common.impl.sku.view.n) r168;
        Integer r170 = Integer.valueOf(r166);
        if (r10.getStatus() != r164) goto L382;
        boolean r171 = true;
    L383:
        r169.p = r171;
        int r172 = r169.o;
        if (r170 == null) goto L389;
        if (r170.intValue() != r172) goto L389;
    L406:
        r169.setOnItemCheckedListener(new com.bytedance.android.ec.common.impl.sku.view.m(r138, r10));
        String r173 = r149.getName();
        int r174 = r146;
        String[] r224 = r139;
        int r175 = r109;
        cg.e r176 = cg.f.c(r10, r138.getContext(), r146, Integer.valueOf(r166), r140, r141, r142);
        SpecItemGroupLayout.d r177 = r138.k;
        String r178 = r315;
        Intrinsics.checkNotNullParameter(r173, r178);
        Intrinsics.checkNotNullParameter(r176, r223);
        if (r169.getContext() != null) goto L409;
    L428:
        r178 = r178;
    L429:
        r169.setCheckedItemViewInfo(null);
        if (Intrinsics.areEqual(r149.getHideSpec(), Boolean.TRUE) == false) goto L433;
        r169.setVisibility(8);
    L433:
        Integer r179 = 4;
        LinearLayoutCompat.LayoutParams r180 = new LinearLayoutCompat.LayoutParams(-1, -2);
        if (r174 != 0) goto L441;
        if (r179 != null) goto L438;
    L440:
        float r181 = UIUtils.dip2Px(r138.getContext(), 18.0f);
    L442:
        ((LinearLayout.LayoutParams) r180).topMargin = (int) r181;
        r169.setLayoutParams(r180);
        List<View> r182 = r138.e;
        if (r174 < 0) goto L448;
        if (r174 > CollectionsKt.getLastIndex(r182)) goto L448;
        Object r183 = ListProtector.get(r182, r174);
    L455:
        r33.add(r183);
        r144 = r222;
        r110 = r223;
        r109 = r175;
        r146 = r148;
        r139 = r224;
        r111 = r178;
    L448:
        if (r174 >= (r10.getSpecInfoList().size() - 1)) goto L450;
        View r184 = new View(r138.getContext());
        LinearLayoutCompat.LayoutParams r185 = new LinearLayoutCompat.LayoutParams(-1, 1);
        ((LinearLayout.LayoutParams) r185).topMargin = (int) UIUtils.dip2Px(r184.getContext(), 20.0f);
        Unit r186 = Unit.INSTANCE;
        r184.setLayoutParams(r185);
        r184.setBackgroundColor(th.a.a(r184.getContext(), 2131101237));
    L451:
        if (r184 == null) goto L453;
        ListProtector.add(r138.e, r174, r184);
        r138.addView(r184);
        r183 = Unit.INSTANCE;
        goto L455
    L453:
        r183 = null;
        goto L455
    L450:
        r184 = null;
        goto L451
    L438:
        if (r179.intValue() != 2) goto L440;
        r181 = UIUtils.dip2Px(r138.getContext(), 14.0f);
        goto L442
    L441:
        r181 = UIUtils.dip2Px(r138.getContext(), 12.0f);
        goto L442
    L409:
        if (r150.isEmpty() == true) goto L428;
        r169.f = r150;
        r169.j = r174;
        r169.i = 1;
        GroupTitleLayout r187 = r169.n;
        if (r187 == null) goto L414;
        r187.b(r176);
    L415:
        int r188 = r150.size();
        int r189 = 0;
    L416:
        if (r189 >= r188) goto L429;
        com.bytedance.android.ec.common.impl.sku.view.n.c r190 = (com.bytedance.android.ec.common.impl.sku.view.n.c) ListProtector.get(r150, r189);
        Object r191 = r169.getChildAt(r169.i + r189);
        if (r191 != null) goto L420;
    L426:
        SpecItemView r192 = new SpecItemView(r169.getContext(), r169);
        r192.setGravity(17);
        r192.setIncludeFontPadding(false);
        r192.setTextSize(2, 12.0f);
        r192.setGravity(17);
        int r193 = r169.c;
        int r194 = r169.d;
        r192.setPadding(r193, r194, r193, r194);
        r192.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        r169.addView(r192);
    L427:
        r192.x(r190, r169.o, r169.p);
        r192.y(r190, null);
        r192.setItemClickListener(r169);
        r189 = r189 + 1;
        goto L416
    L420:
        if ((r191 instanceof SpecItemView) == true) goto L422;
        r191 = null;
    L422:
        r192 = (SpecItemView) r191;
        if (r192 != 0) goto L427;
    L414:
        GroupTitleLayout r195 = new GroupTitleLayout(r169.getContext(), null, 6, 0);
        r195.a(r176, r177);
        Unit r196 = Unit.INSTANCE;
        r169.n = r195;
        r169.addView(r195);
    L389:
        if (r170 == null) goto L395;
        if (r170.intValue() != 3) goto L395;
        r169.d = (int) UIUtils.dip2Px(r169.getContext(), 7.0f);
        th.a.a(r169.getContext(), 2131101247);
        r169.b = r169.c(10.0f);
        r169.c = r169.c(10.0f);
        r169.a = r169.c(10.0f);
    L395:
        if (r170 != null) goto L398;
    L400:
        if (r170 != null) goto L403;
    L405:
        r169.d = (int) UIUtils.dip2Px(r169.getContext(), 7.0f);
        th.a.a(r169.getContext(), 2131106228);
        r169.b = r169.c(10.0f);
        r169.c = r169.c(10.0f);
        r169.a = r169.c(10.0f);
        goto L406
    L403:
        if (r170.intValue() != r166) goto L405;
        r169.d = (int) UIUtils.dip2Px(r169.getContext(), 6.0f);
        th.a.a(r169.getContext(), 2131101245);
        r169.b = r169.c(8.0f);
        r169.c = r169.c(16.0f);
        r169.a = r169.c(8.0f);
        goto L406
    L398:
        if (r170.intValue() != 2) goto L400;
        r169.d = (int) UIUtils.dip2Px(r169.getContext(), 5.0f);
        th.a.a(r169.getContext(), 2131106228);
        r169.b = r169.c(10.0f);
        r169.c = r169.c(10.0f);
        r169.a = r169.c(10.0f);
        goto L406
    L382:
        r171 = false;
        goto L383
    L377:
        r165 = false;
        goto L378
    L372:
        if (r146 > CollectionsKt.getLastIndex(r162)) goto L374;
        r164 = 2;
        r166 = 4;
        r168 = ListProtector.get(r162, r146);
        goto L379
    L330:
        if (r109 != r161.intValue()) goto L369;
        String r197 = r139[r146];
        Iterator r198 = r150.iterator();
    L333:
        if (r198.hasNext() == false) goto L340;
        com.bytedance.android.ec.common.impl.sku.view.n.c r199 = (com.bytedance.android.ec.common.impl.sku.view.n.c) r198.next();
        if (r199.b.equals(r197) == false) goto L333;
        if (r199.a == true) goto L339;
        r139[r146] = null;
        String[] r200 = r138.c;
        Intrinsics.checkNotNull(r200);
        r200[r146] = null;
        goto L333
    L339:
        String[] r201 = r138.c;
        Intrinsics.checkNotNull(r201);
        r201[r146] = r199.b;
        goto L369
    L340:
        Iterator r202 = r150.iterator();
    L342:
        if (r202.hasNext() == false) goto L349;
        com.bytedance.android.ec.common.impl.sku.view.n.c r203 = (com.bytedance.android.ec.common.impl.sku.view.n.c) r202.next();
        if (r203.d == false) goto L342;
        if (r203.a == false) goto L342;
        r139[r146] = r203.b;
        String[] r204 = r138.c;
        Intrinsics.checkNotNull(r204);
        r204[r146] = r203.b;
        goto L369
    L349:
        if (r155 != 1) goto L358;
        if (r154 == null) goto L352;
        String r205 = r154.b;
    L353:
        r139[r146] = r205;
        String[] r206 = r138.c;
        Intrinsics.checkNotNull(r206);
        if (r154 == null) goto L356;
        String r207 = r154.b;
    L357:
        r206[r146] = r207;
        goto L369
    L356:
        r207 = null;
        goto L357
    L352:
        r205 = null;
        goto L353
    L358:
        if (r146 != 0) goto L369;
        if (r149.getSpecType() != 1) goto L369;
        if (r154 == null) goto L363;
        String r208 = r154.b;
    L364:
        r139[r146] = r208;
        String[] r209 = r138.c;
        Intrinsics.checkNotNull(r209);
        if (r154 == null) goto L367;
        String r225 = r154.b;
    L368:
        r209[r146] = r225;
        goto L369
    L367:
        r225 = null;
        goto L368
    L363:
        r208 = null;
        goto L364
    L326:
        r161 = null;
    L303:
        r152 = new String[r109];
        goto L304
    L456:
        int r1100 = r109;
        int r226 = ((ArrayList) r138.d).size();
        int r227 = ((ArrayList) r138.e).size();
        int r228 = r1100 - 1;
        int r229 = r228;
    L457:
        if (r229 >= r227) goto L459;
        r138.removeView((View) ListProtector.remove(r138.e, r228));
        r229 = r229 + 1;
        goto L457
    L459:
        int r230 = r1100;
    L460:
        if (r230 >= r226) goto L462;
        r138.removeView((View) ListProtector.remove(r138.d, r1100));
        r230 = r230 + 1;
        goto L460
    L462:
        int r231 = 0;
    L463:
        if (r231 >= r1100) goto L470;
        com.bytedance.android.ec.common.impl.sku.view.n r232 = (com.bytedance.android.ec.common.impl.sku.view.n) CollectionsKt.getOrNull(r138.d, r231);
        if (r232 == null) goto L469;
        int r233 = r232.f.size();
        int r234 = (r232.getChildCount() - r233) - r232.i;
        int r235 = 0;
    L467:
        if (r235 >= r234) goto L469;
        r232.removeViewAt(r232.i + r233);
        r235 = r235 + 1;
    L469:
        r231 = r231 + 1;
        goto L463
    L470:
        String[] r1101 = r138.c;
        if (r1101 == null) goto L509;
        if ((!ArraysKt.filterNotNull(r1101).isEmpty()) == true) goto L475;
    L477:
        boolean r236 = false;
    L478:
        if (r236 == true) goto L481;
        r1101 = null;
    L481:
        if (r1101 == null) goto L509;
        List<SpecInfo> r237 = r10.getSpecInfoList();
        if (r237 == null) goto L509;
        List<SpecInfo> r238 = r237;
        ArrayList r239 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r238, 10));
        Iterator<T> r240 = r238.iterator();
        int r241 = 0;
    L486:
        if (r240.hasNext() == false) goto L509;
        T r242 = r240.next();
        int r243 = r241 + 1;
        if (r241 >= 0) goto L490;
        CollectionsKt.throwIndexOverflow();
    L490:
        SpecInfo r244 = (SpecInfo) r242;
        String r245 = r1101[r241];
        com.bytedance.android.ec.common.impl.sku.view.n r246 = (com.bytedance.android.ec.common.impl.sku.view.n) ListProtector.get(r138.d, r241);
        Iterator<T> r247 = r246.f.iterator();
        int r248 = 0;
    L492:
        if (r247.hasNext() == false) goto L508;
        T r249 = r247.next();
        int r1102 = r248 + 1;
        if (r248 >= 0) goto L496;
        CollectionsKt.throwIndexOverflow();
    L496:
        com.bytedance.android.ec.common.impl.sku.view.n.c r250 = (com.bytedance.android.ec.common.impl.sku.view.n.c) r249;
        if (Intrinsics.areEqual(r250.b, r245) == false) goto L507;
        Object r251 = r246.getChildAt(r248 + r246.i);
        if ((r251 instanceof SpecItemView) == true) goto L501;
        r251 = null;
    L501:
        SpecItemView r252 = (SpecItemView) r251;
        if (r252 == null) goto L504;
        r252.y(r250, r245);
    L504:
        r246.g = r250;
        com.bytedance.android.ec.common.impl.sku.view.n.b r253 = r246.k;
        if (r253 == null) goto L507;
        Intrinsics.checkNotNull(r253);
        r253.d(r241, r246.g, true);
    L507:
        r248 = r1102;
        goto L492
    L508:
        r239.add(Unit.INSTANCE);
        r241 = r243;
        goto L486
    L475:
        if (r1101.length < r10.getSpecInfoList().size()) goto L477;
        r236 = true;
    L509:
        r0 = this;
    L510:
        String[] r254 = f2.d0(r0.a).getCheckedIdArray();
        if (r254 == null) goto L600;
        List r255 = ArraysKt.filterNotNull(r254);
        if (r255 != null) goto L515;
        return;
    L515:
        if (r255.isEmpty() != true) goto L602;
        f2.h0(r0.a);
        return;
    L602:
        return;
    L600:
        return;
    L285:
        if (r107.isEmpty() == true) goto L288;
        r108 = false;
        goto L289
    L281:
        r139 = null;
        goto L282
    L10:
        if (ArraysKt.filterNotNull(r1.getSelectSkuKeys()).isEmpty() == true) goto L13;
        r1 = null;
    L13:
        if (r1 == null) goto L34;
        Iterator<T> r256 = r10.getSkuList().keySet().iterator();
    L16:
        if (r256.hasNext() == false) goto L34;
        String r257 = (String) r256.next();
        SkuItemInfoVO r258 = r10.getSkuList().get(r257);
        if (r258 == null) goto L20;
        String r259 = r258.getId();
    L21:
        SkuRestoreState r260 = f2.e0(r0.a).getSkuPanelState();
        if (r260 == null) goto L24;
        String r261 = r260.getSelectedSkuId();
    L26:
        if (Intrinsics.areEqual(r259, r261) == false) goto L16;
        SkuRestoreState r262 = f2.e0(r0.a).getSkuPanelState();
        if (r262 == null) goto L16;
        Object[] r263 = new Regex("_").split(r257, 0).toArray(new String[0]);
        if (r263 == null) goto L33;
        r262.setSelectSkuKeys((String[]) r263);
        goto L16
    L33:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    L24:
        r261 = null;
        goto L26
    L20:
        r259 = null;
        goto L21
    }
}
