package com.bytedance.android.live.revlink.impl.utils;

import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.revlink.impl.global.LinkFakeGlobalService;
import com.bytedance.android.live.revlink.impl.multianchor.ui.UILayout;
import com.bytedance.android.live.revlink.impl.region.RevLinkWindowRegionContext;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class e0 {
    public final com.bytedance.android.live.revlink.impl.global.c a;

    public e0(LinkFakeGlobalService r1) {
        this.a = r1;
    }

    public final void a(List r17) {
        Intrinsics.checkNotNullParameter(r17, "target");
        com.bytedance.android.live.revlink.impl.global.c r3 = this.a;
        if (r3 == null) goto L5;
        RevLinkWindowRegionContext r4 = r3.P8();
    L6:
        if (r4 == null) goto L172;
        com.bytedance.android.live.revlink.impl.region.d r5 = r4.getRevUiRegionUpdater();
        if (r5 == null) goto L173;
        Intrinsics.checkNotNullParameter(r17, "target");
        boolean r6 = false;
        if (r17.isEmpty() == true) goto L148;
        UILayout r7 = r5.b;
        com.bytedance.android.live.revlink.impl.global.c r8 = r5.f;
        if (r8 == null) goto L15;
        com.bytedance.android.live.revlink.impl.multianchor.utils.w r9 = r8.getMultiLinkUtil();
    L16:
        if (r9 == null) goto L18;
        UILayout r10 = r9.b();
    L19:
        if (r7 != r10) goto L40;
        String r12 = r5.c;
        com.bytedance.android.live.revlink.impl.global.c r13 = r5.f;
        if (r13 == null) goto L23;
        com.bytedance.android.live.revlink.impl.multianchor.ui.g r14 = r13.n9();
    L24:
        if (r14 == null) goto L26;
        String r15 = r14.b();
    L28:
        if ((!Intrinsics.areEqual(r12, r15)) == true) goto L40;
        String r16 = r5.d;
        com.bytedance.android.live.revlink.impl.global.c r18 = r5.f;
        if (r18 == null) goto L32;
        com.bytedance.android.live.revlink.impl.multianchor.ui.h r19 = r18.Cg();
    L33:
        if (r19 == null) goto L35;
        String r20 = r19.a();
    L37:
        if ((!Intrinsics.areEqual(r16, r20)) == true) goto L40;
        boolean r22 = false;
    L42:
        if (r22 == true) goto L80;
        RevLinkWindowRegionContext r23 = r5.a();
        if (r23 == null) goto L46;
        Map<String, pc0.c> r24 = r23.getRegions();
    L47:
        if (r24 == null) goto L49;
        int r110 = r24.size();
    L51:
        if (r110 != r17.size()) goto L78;
        int r111 = r17.size();
        int r112 = 0;
    L54:
        if (r112 >= r111) goto L80;
        String r113 = ((com.bytedance.android.live.revlink.impl.region.a) ListProtector.get(r17, r112)).getUserID();
        if ((!Intrinsics.areEqual(r113, DataType.FALSE)) == false) goto L79;
        if (r113.length() <= 0) goto L60;
        boolean r114 = true;
    L61:
        if (r114 == false) goto L79;
        if (r24 == null) goto L64;
        pc0.c r115 = r24.get(r113);
    L65:
        if (r115 == null) goto L78;
        com.bytedance.android.live.revlink.impl.region.a r116 = (com.bytedance.android.live.revlink.impl.region.a) ListProtector.get(r17, r112);
        Intrinsics.checkNotNullParameter(r116, "$this$isSameSize");
        Intrinsics.checkNotNullParameter(r115, "target");
        if (Float.compare(r116.d(), r115.d) == 0) goto L69;
    L76:
        boolean r117 = false;
    L77:
        if (r117 == true) goto L79;
    L69:
        if (Float.compare(r116.a(), r115.e) != 0) goto L76;
        if (Float.compare(r116.b(), r115.c) != 0) goto L76;
        if (Float.compare(r116.e(), r115.b) != 0) goto L76;
        r117 = true;
        goto L77
    L64:
        r115 = null;
        goto L65
    L60:
        r114 = false;
    L79:
        r112 = r112 + 1;
    L78:
        r22 = true;
        goto L80
    L49:
        r110 = 0;
        goto L51
    L46:
        r24 = null;
    L80:
        if (r22 == false) goto L148;
        ((LinkedHashMap) r5.a).clear();
        Iterator r1 = r17.iterator();
    L83:
        if (r1.hasNext() == false) goto L123;
        com.bytedance.android.live.revlink.impl.region.a r2 = (com.bytedance.android.live.revlink.impl.region.a) r1.next();
        String r25 = r2.getUserID();
        if ((!Intrinsics.areEqual(r25, DataType.FALSE)) == false) goto L83;
        if (r25.length() <= 0) goto L89;
        boolean r26 = true;
    L90:
        if (r26 == false) goto L83;
        com.bytedance.android.live.revlink.impl.global.c r27 = r5.f;
        if (r27 == null) goto L94;
        com.bytedance.android.live.revlink.impl.multianchor.ui.g r28 = r27.n9();
    L95:
        if (r28 == null) goto L97;
        String r29 = r28.b();
    L99:
        if (Intrinsics.areEqual(r25, r29) == true) goto L109;
        String r30 = r2.c();
        com.bytedance.android.live.revlink.impl.global.c r118 = r5.f;
        if (r118 == null) goto L103;
        com.bytedance.android.live.revlink.impl.multianchor.ui.h r119 = r118.Cg();
    L104:
        if (r119 == null) goto L106;
        String r120 = r119.a();
    L108:
        if (Intrinsics.areEqual(r30, r120) == true) goto L109;
    L119:
        boolean r32 = false;
    L120:
        if (r32 == true) goto L121;
        r5.a.put(r25, new pc0.c(r25, r2.e(), r2.b(), r2.d(), r2.a()));
        goto L83
    L121:
        b03.a r33 = b03.a.a;
        int r34 = s1.w() - s1.A();
        r5.a.put(r25, new pc0.c(r25, 0.0f, 0.0f, Math.min((r34 * 9) / 16, s1.y()), r34));
        goto L83
    L106:
        r120 = null;
        goto L108
    L103:
        r119 = null;
    L109:
        com.bytedance.android.live.revlink.impl.global.c r35 = r5.f;
        if (r35 == null) goto L112;
        com.bytedance.android.live.revlink.impl.multianchor.utils.w r36 = r35.getMultiLinkUtil();
    L113:
        if (r36 == null) goto L115;
        UILayout r37 = r36.b();
    L117:
        if (r37 != UILayout.FULL) goto L119;
        r32 = true;
        goto L120
    L115:
        r37 = null;
        goto L117
    L112:
        r36 = null;
        goto L113
    L97:
        r29 = null;
        goto L99
    L94:
        r28 = null;
        goto L95
    L89:
        r26 = false;
        goto L90
    L123:
        RevLinkWindowRegionContext r38 = r5.a();
        if (r38 == null) goto L126;
        r38.updateRegions(r5.a);
    L126:
        com.bytedance.android.live.revlink.impl.global.c r39 = r5.f;
        if (r39 == null) goto L129;
        com.bytedance.android.live.revlink.impl.multianchor.utils.w r40 = r39.getMultiLinkUtil();
    L130:
        if (r40 == null) goto L132;
        UILayout r42 = r40.b();
    L133:
        r5.b = r42;
        com.bytedance.android.live.revlink.impl.global.c r43 = r5.f;
        if (r43 == null) goto L136;
        com.bytedance.android.live.revlink.impl.multianchor.ui.g r44 = r43.n9();
    L137:
        if (r44 == null) goto L139;
        String r45 = r44.b();
    L140:
        r5.c = r45;
        com.bytedance.android.live.revlink.impl.global.c r46 = r5.f;
        if (r46 == null) goto L143;
        com.bytedance.android.live.revlink.impl.multianchor.ui.h r47 = r46.Cg();
    L144:
        if (r47 == null) goto L146;
        String r48 = r47.a();
    L147:
        r5.d = r48;
        r6 = true;
        goto L148
    L146:
        r48 = null;
        goto L147
    L143:
        r47 = null;
        goto L144
    L139:
        r45 = null;
        goto L140
    L136:
        r44 = null;
        goto L137
    L132:
        r42 = null;
        goto L133
    L129:
        r40 = null;
        goto L130
    L35:
        r20 = null;
        goto L37
    L32:
        r19 = null;
        goto L33
    L26:
        r15 = null;
        goto L28
    L23:
        r14 = null;
    L40:
        r22 = true;
        goto L42
    L18:
        r10 = null;
        goto L19
    L15:
        r9 = null;
    L148:
        if (r6 != true) goto L174;
        com.bytedance.android.live.revlink.impl.global.c r49 = this.a;
        if (r49 == null) goto L152;
        RevLinkWindowRegionContext r50 = r49.P8();
    L153:
        if (r50 == null) goto L175;
        r50.notifyRegionUpdate();
        return;
    L175:
        return;
    L152:
        r50 = null;
        goto L153
    L174:
        return;
    L173:
        return;
    L172:
        return;
    L5:
        r4 = null;
        goto L6
    }
}
