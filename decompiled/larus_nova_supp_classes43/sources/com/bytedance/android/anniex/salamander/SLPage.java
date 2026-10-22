package com.bytedance.android.anniex.salamander;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import com.bytedance.android.anniex.container.util.AnnieXContainerManager;
import com.bytedance.android.anniex.monitor.MonitorManager;
import com.bytedance.anniex.bd.foundation.impl.m;
import com.bytedance.ies.bullet.base.core.common.Components;
import com.bytedance.ies.bullet.base.utils.keyboard.SoftInputKt;
import com.bytedance.ies.bullet.core.common.Arch;
import com.bytedance.ies.bullet.core.common.Scenes;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.salamander.anniex.AnnieXNavBarItemName;
import com.bytedance.salamander.anniex.e2;
import com.bytedance.salamander.anniex.g;
import com.bytedance.salamander.anniex.i0;
import com.bytedance.salamander.anniex.j;
import com.bytedance.salamander.anniex.j0;
import com.bytedance.salamander.anniex.o0;
import com.bytedance.salamander.anniex.p0;
import com.bytedance.salamander.anniex.r0;
import com.bytedance.salamander.anniex.t0;
import com.bytedance.salamander.anniex.y;
import i36.d;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import y36.i;
import y36.r;
import y36.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class SLPage extends AbsPageAndPopup {
    public final Components u;
    public final com.bytedance.android.anniex.base.lifecycle.a v;
    public final Lazy w;

    public static final class a {
    }

    static {
    }

    public final r0 n() {
        t0 r15 = new t0(getActivity());
        Arch r0 = Arch.SL;
        Intrinsics.checkNotNullParameter(r0, "<set-?>");
        r15.d = r0;
        Scenes r1 = Scenes.AnnieXPage;
        Intrinsics.checkNotNullParameter(r1, "<set-?>");
        r15.e = r1;
        b r13 = new b(getActivity());
        v36.a r10 = d();
        if (r10 == null) goto L9;
        y36.a r11 = r10.h();
        if (r11 == null) goto L9;
        if (((i) r11).a != true) goto L9;
        boolean r12 = true;
    L10:
        if (r12 == false) goto L16;
        v36.a r14 = d();
        if (r14 == null) goto L16;
        y36.a r16 = r14.h();
        if (r16 == null) goto L16;
        boolean r17 = Intrinsics.areEqual(((i) r16).b, Boolean.TRUE);
    L17:
        v36.a r18 = d();
        if (r18 == null) goto L24;
        y36.a r19 = r18.i();
        if (r19 == null) goto L24;
        if (((i) r19).a != true) goto L24;
        boolean r20 = true;
    L26:
        if (r20 == false) goto L33;
        v36.a r21 = d();
        if (r21 == null) goto L32;
        y36.a r22 = r21.i();
        if (r22 == null) goto L32;
        Boolean r23 = (Boolean) ((i) r22).b;
    L43:
        p0 r110 = new p0();
        v36.a r24 = d();
        if (r24 == null) goto L48;
        r r25 = r24.e();
        if (r25 == null) goto L48;
        String r26 = r25.a();
    L49:
        if (r26 != null) goto L51;
    L53:
        v36.a r27 = d();
        if (r27 == null) goto L58;
        r r28 = r27.b();
        if (r28 == null) goto L58;
        String r29 = r28.a();
    L59:
        if (r29 != null) goto L61;
    L63:
        v36.a r30 = d();
        if (r30 == null) goto L68;
        r r31 = r30.d();
        if (r31 == null) goto L68;
        String r32 = r31.a();
    L69:
        if (r32 != null) goto L71;
    L73:
        v36.a r33 = d();
        if (r33 == null) goto L78;
        r r34 = r33.c();
        if (r34 == null) goto L78;
        String r35 = r34.a();
    L79:
        if (r35 != null) goto L81;
    L83:
        v36.a r36 = d();
        if (r36 == null) goto L91;
        i r37 = r36.o;
        if (r37 != null) goto L89;
        Intrinsics.throwUninitializedPropertyAccessException("showError");
        r37 = null;
    L89:
        if (r37 == null) goto L91;
        boolean r38 = Intrinsics.areEqual(r37.b, Boolean.TRUE);
    L92:
        ((j) r110).e = r38;
        ((j) r110).f = !Intrinsics.areEqual(r23, Boolean.FALSE);
        ((j) r110).k = r17;
        v36.a r39 = d();
        if (r39 == null) goto L99;
        y36.a r40 = r39.j();
        if (r40 == null) goto L99;
        if (((i) r40).a != true) goto L99;
        boolean r41 = true;
    L100:
        if (r41 == false) goto L106;
        v36.a r42 = d();
        if (r42 == null) goto L106;
        y36.a r43 = r42.j();
        if (r43 == null) goto L106;
        Boolean r44 = (Boolean) ((i) r43).b;
    L107:
        ((j) r110).p = r44;
        v36.a r45 = d();
        if (r45 == null) goto L115;
        i r46 = r45.G;
        if (r46 != null) goto L113;
        Intrinsics.throwUninitializedPropertyAccessException("disableInputScroll");
        r46 = null;
    L113:
        if (r46 == null) goto L115;
        boolean r47 = Intrinsics.areEqual(r46.b, Boolean.TRUE);
    L116:
        ((j) r110).h = r47;
        v36.c r48 = o();
        if (r48 == null) goto L126;
        i r49 = r48.m;
        if (r49 != null) goto L122;
        Intrinsics.throwUninitializedPropertyAccessException("shouldFullScreen");
        r49 = null;
    L122:
        if (r49 == null) goto L126;
        if (r49.a != true) goto L126;
        boolean r50 = true;
    L127:
        if (r50 == false) goto L136;
        v36.c r51 = o();
        if (r51 == null) goto L136;
        i r52 = r51.m;
        if (r52 != null) goto L134;
        Intrinsics.throwUninitializedPropertyAccessException("shouldFullScreen");
        r52 = null;
    L134:
        if (r52 == null) goto L136;
        Boolean r53 = (Boolean) r52.b;
    L137:
        ((j) r110).l = r53;
        Uri r54 = this.l;
        if (r54 == null) goto L140;
        String r55 = UriProtector.getQueryParameter(r54, "status_bar_bg_color");
    L141:
        if (r55 != null) goto L143;
    L145:
        Uri r56 = this.l;
        if (r56 == null) goto L148;
        String r57 = UriProtector.getQueryParameter(r56, "status_bar_color");
    L149:
        if (r57 != null) goto L151;
    L153:
        Uri r58 = this.l;
        if (r58 == null) goto L156;
        String r59 = UriProtector.getQueryParameter(r58, "status_font_mode");
    L157:
        r110.d(r59);
        v36.a r60 = d();
        if (r60 == null) goto L162;
        y36.a r61 = r60.g();
        if (r61 == null) goto L162;
        boolean r62 = Intrinsics.areEqual(((i) r61).b, Boolean.TRUE);
    L163:
        ((j) r110).g = r62;
        ((j) r110).q = p();
        Uri r63 = this.l;
        if (r63 == null) goto L166;
        String r64 = UriProtector.getQueryParameter(r63, "pad_adapter");
    L167:
        r110.c(r64);
        Intrinsics.checkNotNullParameter(r110, "<set-?>");
        this.h = r110;
        final Context r65 = r15.getContext();
        v36.a r66 = d();
        if (r66 == null) goto L172;
        s r67 = r66.f();
        if (r67 == null) goto L172;
        Uri r68 = (Uri) ((i) r67).b;
    L173:
        final String r69 = String.valueOf(r68);
        final String r70 = this.b;
        final String r71 = this.c;
        boolean r72 = ((j) r110).q;
        m r73 = g.d;
        g r74 = g.a.b();
        v36.c r75 = o();
        if (r75 == null) goto L181;
        i r76 = ((x36.b) r75).h;
        if (r76 != null) goto L179;
        Intrinsics.throwUninitializedPropertyAccessException("titleColor");
        r76 = null;
    L179:
        if (r76 == null) goto L181;
        Integer r77 = (Integer) r76.b;
    L182:
        if (r77 == null) goto L193;
        int r78 = com.bytedance.android.anniex.container.util.a.a;
        v36.c r79 = o();
        if (r79 == null) goto L191;
        i r80 = ((x36.b) r79).h;
        if (r80 != null) goto L189;
        Intrinsics.throwUninitializedPropertyAccessException("titleColor");
        r80 = null;
    L189:
        if (r80 == null) goto L191;
        Integer r81 = (Integer) r80.b;
    L192:
        r74 = com.bytedance.android.anniex.container.util.a.a(r81, null, null);
    L191:
        r81 = null;
    L193:
        g r82 = r74;
        String r83 = AnnieXNavBarItemName.BACK.getValue();
        int r111 = y.a;
        j0 r84 = new j0(r83, "sl://raw/ic_arrowleft_outlined", r82, new SLPage$buildNavBarModel$backItem$1(this));
        ArrayList r85 = new ArrayList();
        r85.add(r84);
        ArrayList r112 = new ArrayList();
        j0 r113 = new j0("search", "res:///2131820572", r82, new SLPage$buildSearchNavBarItem$1(r70, r65, r71));
        j0 r114 = new j0(com.bytedance.android.ec.core.event.a.VALUE_MORE, "res:///2131820571", r82, new SLPage$buildMoreNavBarItem$1(r70, this, r65, r69, r71));
        if (r72 == true) goto L197;
        r112.add(r113);
        r112.add(r114);
    L197:
        if (p() == false) goto L204;
        Uri r86 = this.l;
        if (r86 == null) goto L202;
        String r87 = UriProtector.getQueryParameter(r86, "use_webview_title");
    L203:
        if (r87 == null) goto L204;
        boolean r88 = Intrinsics.areEqual(r87, "1");
    L206:
        i0 r115 = new i0();
        Intrinsics.checkNotNullParameter(r85, "items");
        r115.d = r85;
        Intrinsics.checkNotNullParameter(r112, "items");
        r115.e = r112;
        String r89 = this.c;
        Intrinsics.checkNotNullParameter(r89, "annieXId");
        r115.a = r89;
        r115.h = r88;
        v36.c r90 = o();
        if (r90 == null) goto L214;
        i r91 = ((x36.b) r90).a;
        if (r91 != null) goto L212;
        Intrinsics.throwUninitializedPropertyAccessException("hideNavBar");
        r91 = null;
    L212:
        if (r91 == null) goto L214;
        boolean r92 = Intrinsics.areEqual(r91.b, Boolean.TRUE);
    L215:
        if (r92 == true) goto L228;
        v36.c r93 = o();
        if (r93 == null) goto L224;
        i r94 = r93.m;
        if (r94 != null) goto L222;
        Intrinsics.throwUninitializedPropertyAccessException("shouldFullScreen");
        r94 = null;
    L222:
        if (r94 == null) goto L224;
        boolean r95 = Intrinsics.areEqual(r94.b, Boolean.TRUE);
    L225:
        if (r95 == true) goto L228;
        boolean r96 = false;
    L229:
        r115.c = r96;
        v36.c r97 = o();
        if (r97 == null) goto L239;
        i r98 = ((x36.b) r97).c;
        if (r98 != null) goto L235;
        Intrinsics.throwUninitializedPropertyAccessException("navBarColor");
        r98 = null;
    L235:
        if (r98 == null) goto L239;
        Integer r99 = (Integer) r98.b;
        if (r99 == null) goto L239;
        int r100 = r99.intValue();
        int r101 = com.bytedance.android.anniex.container.util.a.a;
        g r102 = com.bytedance.android.anniex.container.util.a.a(Integer.valueOf(r100), Integer.valueOf(r100), Integer.valueOf(r100));
    L240:
        Intrinsics.checkNotNullParameter(r102, "backgroundColor");
        r115.b = r102;
        v36.c r103 = o();
        if (r103 == null) goto L249;
        i r104 = ((x36.b) r103).g;
        if (r104 == null) goto L245;
        i r105 = r104;
    L246:
        if (r105 == null) goto L249;
        String r106 = (String) r105.b;
        if (r106 == null) goto L249;
    L250:
        Intrinsics.checkNotNullParameter(r106, "title");
        r115.f = r106;
        Intrinsics.checkNotNullParameter(r82, "titleColor");
        r115.g = r82;
        String r107 = this.d;
        String r116 = this.c;
        o0 r108 = new o0(r107, r116, r116, this.b, new LinkedHashMap(), r110, r115, r15);
        Intrinsics.checkNotNullParameter(r108, "<set-?>");
        this.g = r108;
        com.bytedance.android.anniex.lite.utils.b.a = this.c;
        o0 r109 = f();
        Intrinsics.checkNotNull(r109, "null cannot be cast to non-null type com.bytedance.salamander.anniex.AnnieXPageProps");
        o0 r117 = r109;
        int r118 = r0.p;
        Intrinsics.checkNotNullParameter(r117, "props");
        Intrinsics.checkNotNullParameter(r13, "coordinator");
        r0 r119 = new r0(r117, r13);
        Intrinsics.checkNotNullParameter(r119, "<set-?>");
        this.i = r119;
        e2 r120 = e2.b;
        e2.a.a().b(this.c, h());
        Activity r121 = getActivity();
        r0 r122 = h();
        Intrinsics.checkNotNull(r122, "null cannot be cast to non-null type com.bytedance.salamander.anniex.AnnieXPageViewModel");
        ua.c r123 = new ua.c(r121, r122, g(), new SLPage$createFakeContainer$1(this));
        Intrinsics.checkNotNullParameter(r123, "<set-?>");
        this.f = r123;
        AnnieXContainerManager.INSTANCE.addContainer(c());
        Map<String, d> r124 = MonitorManager.a;
        MonitorManager.h(this.c, this.u.getTag());
        if (this.f == null) goto L253;
        boolean r125 = true;
    L254:
        if (r125 == false) goto L256;
        r15.c = this.v;
        r15.b = c();
    L256:
        r0 r126 = h();
        Intrinsics.checkNotNull(r126, "null cannot be cast to non-null type com.bytedance.salamander.anniex.AnnieXPageViewModel");
        return r126;
    L253:
        r125 = false;
        goto L254
    L245:
        Intrinsics.throwUninitializedPropertyAccessException("title");
        r105 = null;
    L249:
        r106 = "";
    L239:
        r102 = g.a.a();
    L224:
        r95 = false;
    L228:
        r96 = true;
    L214:
        r92 = false;
        goto L215
    L202:
        r87 = null;
    L204:
        r88 = true;
    L181:
        r77 = null;
    L172:
        r68 = null;
        goto L173
    L166:
        r64 = null;
    L162:
        r62 = false;
        goto L163
    L156:
        r59 = null;
        goto L157
    L151:
        if (com.bytedance.anniex.bd.foundation.impl.d.b(r57) == false) goto L153;
        ((j) r110).n = new m(r57);
        goto L153
    L148:
        r57 = null;
        goto L149
    L143:
        if (com.bytedance.anniex.bd.foundation.impl.d.b(r55) == false) goto L145;
        ((j) r110).m = new m(r55);
        goto L145
    L140:
        r55 = null;
    L136:
        r53 = null;
    L126:
        r50 = false;
    L115:
        r47 = false;
    L106:
        r44 = null;
    L99:
        r41 = false;
    L91:
        r38 = false;
        goto L92
    L81:
        if (com.bytedance.anniex.bd.foundation.impl.d.b(r35) == false) goto L83;
        ((j) r110).c = new m(r35);
    L78:
        r35 = null;
        goto L79
    L71:
        if (com.bytedance.anniex.bd.foundation.impl.d.b(r32) == false) goto L73;
        ((j) r110).b = new m(r32);
    L68:
        r32 = null;
        goto L69
    L61:
        if (com.bytedance.anniex.bd.foundation.impl.d.b(r29) == false) goto L63;
        ((j) r110).a = new m(r29);
    L58:
        r29 = null;
        goto L59
    L51:
        if (com.bytedance.anniex.bd.foundation.impl.d.b(r26) == false) goto L53;
        ((j) r110).d = new m(r26);
    L48:
        r26 = null;
    L32:
        r23 = null;
        goto L43
    L33:
        v36.a r127 = d();
        if (r127 == null) goto L41;
        i r128 = ((x36.a) r127).b;
        if (r128 != null) goto L39;
        Intrinsics.throwUninitializedPropertyAccessException("hideLoading");
        r128 = null;
    L39:
        if (r128 == null) goto L41;
        boolean r129 = Intrinsics.areEqual(r128.b, Boolean.TRUE);
    L42:
        r23 = Boolean.valueOf(!r129);
    L41:
        r129 = false;
    L24:
        r20 = false;
    L16:
        r17 = false;
    L9:
        r12 = false;
        goto L10
    }

    public final v36.c o() {
        return (v36.c) this.w.getValue();
    }

    public final boolean p() {
        Integer r0 = (Integer) ((i) new y36.d(g(), "web_domain_party", null)).b;
        if (r0 != null) goto L6;
    L8:
        return false;
    L6:
        if (r0.intValue() != 1) goto L8;
        return true;
    }

    @Override // com.bytedance.android.anniex.salamander.AbsPageAndPopup
    public final void i() {
        SoftInputKt.c(getActivity(), this.q);
    }

    @Override // com.bytedance.android.anniex.salamander.AbsPageAndPopup
    public final void l() {
        super.l();
        c().release();
        e2 r0 = e2.b;
        e2 r1 = e2.a.a();
        String r10 = this.c;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r10, "anniexContainerId");
        r1.a.delete(r10);
    }

    @Override // com.bytedance.android.anniex.salamander.AbsPageAndPopup
    public final void k(Bundle r10) {
        super.k(r10);
        m16.b r11 = this.k;
        if (r11 == null) goto L5;
        r11.g(ia.c.class, c());
    L5:
        m16.b r12 = this.k;
        if (r12 == null) goto L9;
        r12.d(com.bytedance.android.anniex.lite.utils.a.class, new com.bytedance.android.anniex.lite.utils.a("sl"));
        return;
    }

    @Override // com.bytedance.android.anniex.salamander.AbsPageAndPopup
    public final void m(View r10, Bundle r11) {
        Intrinsics.checkNotNullParameter(r10, "view");
        super.m(r10, r11);
    }

    public SLPage(Activity r10, String r11, String r12, String r13, Components r14, com.bytedance.android.anniex.base.lifecycle.a r15) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.VALUE_ACTIVITY);
        Intrinsics.checkNotNullParameter(r11, "currentBid");
        Intrinsics.checkNotNullParameter(r12, "containerId");
        Intrinsics.checkNotNullParameter(r13, "currentSchema");
        Intrinsics.checkNotNullParameter(r14, "clientComponent");
        super(r10, r11, r12, r13);
        this.u = r14;
        this.v = r15;
        this.w = LazyKt.lazy(new SLPage$pageModel$2(this));
    }
}
