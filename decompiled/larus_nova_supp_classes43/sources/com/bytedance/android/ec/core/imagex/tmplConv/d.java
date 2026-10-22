package com.bytedance.android.ec.core.imagex.tmplConv;

import com.bytedance.android.ec.core.imagex.common.ImageUrlParser;
import com.bytedance.android.ec.core.imagex.common.l;
import com.bytedance.android.ec.core.imagex.common.p;
import com.bytedance.android.ec.core.imagex.common.z;
import com.bytedance.android.ec.core.imagex.h;
import com.bytedance.android.ec.core.imagex.opt.ImageXModifyConfig;
import com.bytedance.android.ec.core.imagex.r;
import com.bytedance.android.ec.core.imagex.u;
import com.bytedance.android.shopping.api.image.b0;
import com.bytedance.android.shopping.api.image.g;
import com.bytedance.android.shopping.api.image.i0;
import com.bytedance.android.shopping.api.image.j0;
import com.bytedance.android.shopping.api.image.k0;
import com.bytedance.android.shopping.api.image.p0;
import com.bytedance.android.shopping.api.image.q0;
import com.bytedance.android.shopping.api.image.x;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class d extends h {
    @Override // com.bytedance.android.ec.core.imagex.h
    public final String b() {
        return "tmpl_conv_middle_spend";
    }

    public d() {
    }

    public static ECImageXUrlEditorImpl c(r r10, ImageUrlParser r11) {
        int r0 = a.a;
        Intrinsics.checkNotNullParameter(r10, "callerContext");
        Intrinsics.checkNotNullParameter(r11, "imageUrlParser");
        final ECImageXUrlEditorImpl r1 = new ECImageXUrlEditorImpl(r10, r11, r11.x);
        if (r1.e.v == false) goto L196;
        TmplConvConfig r12 = TmplConvConfig.k;
        r12.getClass();
        boolean r13 = false;
        g r14 = null;
        Object r15 = null;
        r14 = null;
        if (((Boolean) TmplConvConfig.g.getValue()).booleanValue() == false) goto L140;
        String r16 = r1.getServiceId();
        x r17 = r1.c.i;
        if (r16 == null) goto L46;
        if (r17 == null) goto L46;
        boolean r18 = r17 instanceof b0;
        if (r18 == false) goto L46;
        if (r18 == true) goto L13;
        x r19 = null;
    L14:
        b0 r20 = (b0) r19;
        if (r20 == null) goto L140;
        if ((r17 instanceof com.bytedance.android.shopping.api.image.d.b) == true) goto L19;
        r17 = null;
    L19:
        com.bytedance.android.shopping.api.image.d.b r21 = (com.bytedance.android.shopping.api.image.d.b) r17;
        if (r21 == null) goto L22;
        boolean r22 = l.b(r21, r10, r1);
    L23:
        if (r22 == false) goto L140;
        String r23 = r20.d();
        String r24 = r20.b();
        if (r24 == null) goto L28;
        r16 = r24;
    L28:
        String r25 = r20.d();
        if (r25 == null) goto L35;
        p0 r26 = r12.b();
        if (r26 == null) goto L35;
        HashMap r27 = r26.b();
        if (r27 == null) goto L35;
        q0 r28 = (q0) r27.get(r25);
    L36:
        if (r28 == null) goto L140;
        if (r23 != null) goto L39;
    L42:
        boolean r29 = true;
    L43:
        if (r29 == true) goto L140;
        r1.p(r16, r23, r28);
        goto L140
    L39:
        if (r23.length() == 0) goto L42;
        r29 = false;
    L35:
        r28 = null;
        goto L36
    L22:
        r22 = true;
        goto L23
    L13:
        r19 = r17;
    L46:
        if ((r17 instanceof j0.a) == false) goto L70;
        j0.a r30 = (j0.a) r17;
        String r31 = r30.d();
        String r32 = r30.b();
        if (r31 == null) goto L54;
        p0 r33 = r12.b();
        if (r33 == null) goto L54;
        HashMap r34 = r33.b();
        if (r34 == null) goto L54;
        q0 r35 = (q0) r34.get(r31);
    L55:
        if (r35 == null) goto L140;
        if (r32 != null) goto L58;
    L61:
        boolean r36 = true;
    L62:
        if (r36 == true) goto L140;
        if (r31.length() <= 0) goto L66;
        boolean r37 = true;
    L67:
        if (r37 == false) goto L140;
        r1.p(r32, r31, r35);
        goto L140
    L66:
        r37 = false;
        goto L67
    L58:
        if (r32.length() == 0) goto L61;
        r36 = false;
    L54:
        r35 = null;
        goto L55
    L70:
        if ((r17 instanceof i0) == false) goto L105;
        i0 r38 = (i0) r17;
        String r39 = r38.d();
        String r40 = r38.b();
        if (r39 == null) goto L89;
        p0 r41 = r12.b();
        if (r41 == null) goto L78;
        HashMap r42 = r41.b();
        if (r42 == null) goto L78;
        q0 r43 = (q0) r42.get(r39);
    L79:
        if (r43 == null) goto L89;
        HashMap r44 = r17.f();
        if (r44 != null) goto L83;
    L86:
        boolean r45 = true;
    L87:
        if (r45 == true) goto L90;
        r43 = q0.b(r43, r17.f());
    L90:
        if (r43 == null) goto L140;
        if (r40 != null) goto L93;
    L96:
        boolean r46 = true;
    L97:
        if (r46 == true) goto L140;
        if (r39.length() <= 0) goto L101;
        boolean r47 = true;
    L102:
        if (r47 == false) goto L140;
        r1.p(r40, r39, r43);
        goto L140
    L101:
        r47 = false;
        goto L102
    L93:
        if (r40.length() == 0) goto L96;
        r46 = false;
        goto L97
    L83:
        if (r44.isEmpty() == true) goto L86;
        r45 = false;
    L78:
        r43 = null;
    L89:
        r43 = null;
        goto L90
    L105:
        if ((r17 instanceof k0) == false) goto L140;
        k0 r48 = (k0) r17;
        String r49 = r48.d();
        String r50 = r48.b();
        if (r49 == null) goto L124;
        p0 r51 = r12.b();
        if (r51 == null) goto L113;
        HashMap r52 = r51.b();
        if (r52 == null) goto L113;
        q0 r53 = (q0) r52.get(r49);
    L114:
        if (r53 == null) goto L124;
        HashMap r54 = r17.f();
        if (r54 != null) goto L118;
    L121:
        boolean r55 = true;
    L122:
        if (r55 == true) goto L125;
        r53 = q0.b(r53, r17.f());
    L125:
        if (r53 == null) goto L140;
        if (r50 != null) goto L128;
    L131:
        boolean r56 = true;
    L132:
        if (r56 == true) goto L140;
        if (r49.length() <= 0) goto L136;
        boolean r57 = true;
    L137:
        if (r57 == false) goto L140;
        r1.p(r50, r49, r53);
        goto L140
    L136:
        r57 = false;
        goto L137
    L128:
        if (r50.length() == 0) goto L131;
        r56 = false;
        goto L132
    L118:
        if (r54.isEmpty() == true) goto L121;
        r55 = false;
    L113:
        r53 = null;
    L124:
        r53 = null;
    L140:
        if (((Boolean) TmplConvConfig.h.getValue()).booleanValue() == false) goto L155;
        p0 r110 = (p0) TmplConvConfig.c.getValue(r12, TmplConvConfig.a[1]);
        if (r110 == null) goto L152;
        List r111 = r110.g();
        if (r111 == null) goto L152;
        Iterator r112 = r111.iterator();
    L147:
        if (r112.hasNext() == false) goto L151;
        Object r58 = r112.next();
        if (l.b((g) r58, r10, r1) == false) goto L147;
        r15 = r58;
    L151:
        r14 = (g) r15;
    L152:
        if (r14 == null) goto L155;
        r1.o(r14.a(r1.getFormat()));
    L155:
        if (r1.c.i == null) goto L196;
        ImageXModifyConfig.c r113 = ImageXModifyConfig.g;
        r113.getClass();
        p r114 = (p) ImageXModifyConfig.d.getValue(r113, ImageXModifyConfig.c.a[0]);
        if (r114 == null) goto L196;
        Function1<r, Unit> r59 = new TmplConvMiddleware$onTmplParamsModify$1(r1);
        Function2<ImageXModifyConfig, String, Unit> r60 = new TmplConvMiddleware$onTmplParamsModify$2(r1);
        Intrinsics.checkNotNullParameter(r114, "$this$matchForEach");
        Intrinsics.checkNotNullParameter(r10, "callerContext");
        Intrinsics.checkNotNullParameter(r60, "onEach");
        List r61 = r114.b();
        if (r61 == null) goto L166;
        Iterator r62 = r61.iterator();
    L162:
        if (r62.hasNext() == false) goto L166;
        z r63 = (z) r62.next();
        if (l.b(r63, r10, r1) == false) goto L162;
        r60.invoke(r63, "common_low_config");
    L166:
        Map r64 = r114.c();
        if (r64 != null) goto L169;
    L172:
        boolean r65 = true;
    L173:
        if (r65 == true) goto L188;
        String r66 = r10.f;
        if (r66 != null) goto L177;
    L178:
        r13 = true;
    L179:
        if (r13 == true) goto L188;
        List r67 = (List) r114.c().get(r66);
        if (r67 == null) goto L188;
        Iterator r68 = r67.iterator();
    L184:
        if (r68.hasNext() == false) goto L188;
        z r69 = (z) r68.next();
        if (l.b(r69, r10, r1) == false) goto L184;
        r60.invoke(r69, "scene_config");
        goto L184
    L177:
        if (r66.length() != 0) goto L179;
    L188:
        Unit r70 = (Unit) r59.invoke(r10);
        List r115 = r114.a();
        if (r115 == null) goto L196;
        Iterator r116 = r115.iterator();
    L192:
        if (r116.hasNext() == false) goto L196;
        z r71 = (z) r116.next();
        if (l.b(r71, r10, r1) == false) goto L192;
        r60.invoke(r71, "common_high_config");
        goto L192
    L169:
        if (r64.isEmpty() == true) goto L172;
        r65 = false;
    L196:
        r1.q();
        r1.b.a = true;
        return r1;
    }

    @Override // com.bytedance.android.ec.core.imagex.h
    public final void a(r r10, ImageUrlParser r11) {
        Intrinsics.checkNotNullParameter(r10, "callerContext");
        Intrinsics.checkNotNullParameter(r11, "imageUrlParser");
        TmplConvConfig r0 = TmplConvConfig.k;
        r0.getClass();
        if (TmplConvConfig.a() == false) goto L39;
        boolean r12 = false;
        boolean r13 = true;
        if (r11.x.length() != 0) goto L7;
        boolean r1 = true;
    L8:
        if (r1 == true) goto L40;
        ReadOnlyProperty r14 = TmplConvConfig.d;
        KProperty[] r15 = TmplConvConfig.a;
        com.bytedance.android.shopping.api.image.h r16 = (com.bytedance.android.shopping.api.image.h) r14.getValue(r0, r15[2]);
        if (r16 == null) goto L12;
        List r17 = r16.e();
    L13:
        List r18 = r17;
        if (r18 != null) goto L16;
    L19:
        boolean r19 = true;
    L20:
        if (r19 == true) goto L27;
        com.bytedance.android.shopping.api.image.h r20 = (com.bytedance.android.shopping.api.image.h) r14.getValue(r0, r15[2]);
        if (r20 != null) goto L24;
    L26:
        r13 = r12;
        goto L27
    L24:
        if (l.b(r20, r10, null) != true) goto L26;
        r12 = true;
    L27:
        if (r13 == false) goto L42;
        ECImageXUrlEditorImpl r110 = c(r10, r11);     // Catch: Exception -> L36
        if ((r10 instanceof u) == true) goto L32;
        r10 = null;
    L32:
        u r21 = (u) r10;     // Catch: Exception -> L36
        if (r21 == null) goto L41;
        r21.z = r110;     // Catch: Exception -> L36
        Unit r22 = Unit.INSTANCE;     // Catch: Exception -> L36
        return;
    L41:
        return;
    L43:
        return;
    L42:
        return;
    L16:
        if (r18.isEmpty() == true) goto L19;
        r19 = false;
        goto L20
    L12:
        r17 = null;
        goto L13
    L40:
        return;
    L7:
        r1 = false;
        goto L8
    }
}
