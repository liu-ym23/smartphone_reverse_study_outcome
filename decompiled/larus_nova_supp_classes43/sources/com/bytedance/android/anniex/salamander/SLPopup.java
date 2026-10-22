package com.bytedance.android.anniex.salamander;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatDialog;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.anniex.container.util.AnnieXContainerManager;
import com.bytedance.android.anniex.monitor.MonitorManager;
import com.bytedance.anniex.bd.foundation.impl.m;
import com.bytedance.ies.bullet.base.utils.keyboard.SoftInputKt;
import com.bytedance.ies.bullet.core.common.Arch;
import com.bytedance.ies.bullet.core.common.Scenes;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.salamander.anniex.AnnieXNavBarItemName;
import com.bytedance.salamander.anniex.AnnieXPopupType;
import com.bytedance.salamander.anniex.AnnieXPopupViewModel;
import com.bytedance.salamander.anniex.e2;
import com.bytedance.salamander.anniex.g;
import com.bytedance.salamander.anniex.i0;
import com.bytedance.salamander.anniex.j;
import com.bytedance.salamander.anniex.j0;
import com.bytedance.salamander.anniex.t0;
import com.bytedance.salamander.anniex.x0;
import com.bytedance.salamander.anniex.y;
import com.bytedance.salamander.anniex.y0;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import q26.i;
import v36.d;
import y36.l;
import y36.r;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class SLPopup extends AbsPageAndPopup {
    public static final /* synthetic */ int y = 0;
    public final FragmentActivity u;
    public final Lazy v;
    public c w;
    public AppCompatDialog x;

    public static final class a {
        public static SLPopup a(com.bytedance.android.anniex.base.builder.c r10) {
            Intrinsics.checkNotNullParameter(r10, "popupBuilder");
            String r0 = r10.c.getString("__x_inner_schema");
            if (r0 != null) goto L5;
            r0 = "";
        L5:
            String r1 = i.b(UriProtector.parse(r0), r10.c);
            return new SLPopup(r10.e(), r10.b, r1, r0);
        }
    }

    static {
    }

    @Override // com.bytedance.android.anniex.salamander.AbsPageAndPopup
    public final void i() {
        AppCompatDialog r0 = this.x;
        if (r0 == null) goto L6;
        SoftInputKt.d(r0, this.q);
        return;
    }

    public final AnnieXPopupViewModel n() {
        List r1 = i16.a.a;
        int r10 = i16.a.m(i16.a.f(this.u), this.u);
        int r11 = i16.a.m(i16.a.i(this.u), this.u);
        int r12 = i16.a.m(i16.a.j(this.u), this.u);
        c r14 = new c(r10, r11, i16.a.m(e(), this.u), r12);
        this.w = r14;
        v36.a r13 = d();
        boolean r15 = false;
        if (r13 == null) goto L9;
        y36.a r16 = r13.i();
        if (r16 == null) goto L9;
        if (((y36.i) r16).a != true) goto L9;
        boolean r17 = true;
    L10:
        y36.i r18 = null;
        if (r17 == false) goto L18;
        v36.a r19 = d();
        if (r19 == null) goto L17;
        y36.a r20 = r19.i();
        if (r20 == null) goto L17;
        Boolean r21 = (Boolean) ((y36.i) r20).b;
    L28:
        d r22 = o();
        if (r22 == null) goto L38;
        y36.i r23 = ((x36.c) r22).f;
        if (r23 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("radius");
        r23 = null;
    L34:
        if (r23 == null) goto L38;
        if (r23.a != true) goto L38;
        boolean r24 = true;
    L39:
        if (r24 == false) goto L48;
        d r25 = o();
        if (r25 == null) goto L48;
        y36.i r26 = ((x36.c) r25).f;
        if (r26 != null) goto L46;
        Intrinsics.throwUninitializedPropertyAccessException("radius");
        r26 = null;
    L46:
        if (r26 == null) goto L48;
        Double r27 = (Double) r26.b;
    L49:
        y0 r28 = new y0();
        v36.a r29 = d();
        if (r29 == null) goto L54;
        r r30 = r29.e();
        if (r30 == null) goto L54;
        String r31 = r30.a();
    L55:
        if (r31 != null) goto L57;
    L59:
        v36.a r32 = d();
        if (r32 == null) goto L64;
        r r33 = r32.b();
        if (r33 == null) goto L64;
        String r34 = r33.a();
    L65:
        if (r34 != null) goto L67;
    L69:
        v36.a r35 = d();
        if (r35 == null) goto L74;
        r r36 = r35.d();
        if (r36 == null) goto L74;
        String r37 = r36.a();
    L75:
        if (r37 != null) goto L77;
    L79:
        v36.a r38 = d();
        if (r38 == null) goto L84;
        r r39 = r38.c();
        if (r39 == null) goto L84;
        String r40 = r39.a();
    L85:
        if (r40 != null) goto L87;
    L89:
        Uri r41 = this.l;
        if (r41 == null) goto L92;
        String r42 = UriProtector.getQueryParameter(r41, "pad_adapter");
    L93:
        r28.c(r42);
        v36.a r43 = d();
        if (r43 == null) goto L101;
        y36.i r44 = r43.o;
        if (r44 != null) goto L99;
        Intrinsics.throwUninitializedPropertyAccessException("showError");
        r44 = null;
    L99:
        if (r44 == null) goto L101;
        boolean r45 = Intrinsics.areEqual(r44.b, Boolean.TRUE);
    L102:
        ((j) r28).e = r45;
        ((j) r28).f = !Intrinsics.areEqual(r21, Boolean.FALSE);
        v36.a r46 = d();
        if (r46 == null) goto L107;
        y36.a r47 = r46.h();
        if (r47 == null) goto L107;
        boolean r48 = Intrinsics.areEqual(((y36.i) r47).b, Boolean.TRUE);
    L108:
        ((j) r28).k = r48;
        v36.a r49 = d();
        if (r49 == null) goto L113;
        y36.a r50 = r49.j();
        if (r50 == null) goto L113;
        boolean r51 = Intrinsics.areEqual(((y36.i) r50).b, Boolean.TRUE);
    L114:
        ((j) r28).p = Boolean.valueOf(r51);
        v36.a r52 = d();
        if (r52 == null) goto L122;
        y36.i r53 = r52.G;
        if (r53 != null) goto L120;
        Intrinsics.throwUninitializedPropertyAccessException("disableInputScroll");
        r53 = null;
    L120:
        if (r53 == null) goto L122;
        boolean r54 = Intrinsics.areEqual(r53.b, Boolean.TRUE);
    L123:
        ((j) r28).h = r54;
        v36.a r55 = d();
        if (r55 == null) goto L133;
        y36.i r56 = r55.z;
        if (r56 != null) goto L129;
        Intrinsics.throwUninitializedPropertyAccessException("softInputMode");
        r56 = null;
    L129:
        if (r56 == null) goto L133;
        Integer r57 = (Integer) r56.b;
        if (r57 == null) goto L133;
        int r58 = r57.intValue();
    L134:
        ((j) r28).j = r58;
        Uri r59 = this.l;
        if (r59 == null) goto L137;
        String r60 = UriProtector.getQueryParameter(r59, "status_font_mode");
    L138:
        r28.d(r60);
        v36.a r61 = d();
        if (r61 == null) goto L143;
        y36.a r62 = r61.g();
        if (r62 == null) goto L143;
        boolean r63 = Intrinsics.areEqual(((y36.i) r62).b, Boolean.TRUE);
    L144:
        ((j) r28).g = r63;
        d r64 = o();
        if (r64 == null) goto L152;
        y36.i r65 = r64.i;
        if (r65 != null) goto L150;
        Intrinsics.throwUninitializedPropertyAccessException("aspectRatio");
        r65 = null;
    L150:
        if (r65 == null) goto L152;
        Double r66 = (Double) r65.b;
    L153:
        if (r66 != null) goto L155;
    L157:
        d r67 = o();
        if (r67 == null) goto L165;
        y36.i r68 = r67.k;
        if (r68 != null) goto L163;
        Intrinsics.throwUninitializedPropertyAccessException("closeByGesture");
        r68 = null;
    L163:
        if (r68 == null) goto L165;
        Boolean r69 = (Boolean) r68.b;
    L166:
        r28.s = r69;
        d r70 = o();
        if (r70 == null) goto L174;
        y36.i r71 = ((x36.c) r70).a;
        if (r71 != null) goto L172;
        Intrinsics.throwUninitializedPropertyAccessException("disableOutsideClickClose");
        r71 = null;
    L172:
        if (r71 == null) goto L174;
        Boolean r72 = (Boolean) r71.b;
    L175:
        if (r72 == null) goto L177;
        r28.t = r72.booleanValue();
    L177:
        d r73 = o();
        if (r73 == null) goto L185;
        y36.i r74 = r73.n;
        if (r74 != null) goto L183;
        Intrinsics.throwUninitializedPropertyAccessException("dragBack");
        r74 = null;
    L183:
        if (r74 == null) goto L185;
        Boolean r75 = (Boolean) r74.b;
    L186:
        if (r75 == null) goto L188;
        r75.booleanValue();
    L188:
        d r76 = o();
        if (r76 == null) goto L196;
        y36.i r77 = r76.o;
        if (r77 != null) goto L194;
        Intrinsics.throwUninitializedPropertyAccessException("dragByGesture");
        r77 = null;
    L194:
        if (r77 == null) goto L196;
        Boolean r78 = (Boolean) r77.b;
    L197:
        if (r78 == null) goto L199;
        r78.booleanValue();
    L199:
        d r79 = o();
        if (r79 == null) goto L209;
        y36.i r80 = r79.p;
        if (r80 != null) goto L205;
        Intrinsics.throwUninitializedPropertyAccessException("dragDownCloseThreshold");
        r80 = null;
    L205:
        if (r80 == null) goto L209;
        Double r81 = (Double) r80.b;
        if (r81 == null) goto L209;
        Integer r82 = Integer.valueOf((int) r81.doubleValue());
    L210:
        if (r82 != null) goto L212;
    L214:
        d r83 = o();
        if (r83 == null) goto L224;
        y36.i r84 = r83.q;
        if (r84 != null) goto L220;
        Intrinsics.throwUninitializedPropertyAccessException("dragDownThreshold");
        r84 = null;
    L220:
        if (r84 == null) goto L224;
        Double r85 = (Double) r84.b;
        if (r85 == null) goto L224;
        Integer r86 = Integer.valueOf((int) r85.doubleValue());
    L225:
        if (r86 != null) goto L227;
    L229:
        d r87 = o();
        if (r87 == null) goto L237;
        y36.i r88 = r87.r;
        if (r88 != null) goto L235;
        Intrinsics.throwUninitializedPropertyAccessException("dragExceptStatusBar");
        r88 = null;
    L235:
        if (r88 == null) goto L237;
        Boolean r89 = (Boolean) r88.b;
    L238:
        if (r89 == null) goto L240;
        r28.w = r89.booleanValue();
    L240:
        d r90 = o();
        if (r90 == null) goto L250;
        y36.i r91 = r90.t;
        if (r91 != null) goto L246;
        Intrinsics.throwUninitializedPropertyAccessException("dragHeight");
        r91 = null;
    L246:
        if (r91 == null) goto L250;
        Double r92 = (Double) r91.b;
        if (r92 == null) goto L250;
        Integer r93 = Integer.valueOf((int) r92.doubleValue());
    L251:
        if (r93 != null) goto L253;
    L255:
        d r94 = o();
        if (r94 == null) goto L263;
        y36.i r95 = r94.u;
        if (r95 != null) goto L261;
        Intrinsics.throwUninitializedPropertyAccessException("dragHeightPercent");
        r95 = null;
    L261:
        if (r95 == null) goto L263;
        Integer r96 = (Integer) r95.b;
    L265:
        if (r96 != null) goto L267;
    L271:
        d r97 = o();
        if (r97 == null) goto L281;
        y36.i r98 = r97.v;
        if (r98 != null) goto L277;
        Intrinsics.throwUninitializedPropertyAccessException("dragUpThreshold");
        r98 = null;
    L277:
        if (r98 == null) goto L281;
        Double r99 = (Double) r98.b;
        if (r99 == null) goto L281;
        Integer r100 = Integer.valueOf((int) r99.doubleValue());
    L282:
        if (r100 != null) goto L284;
    L286:
        d r101 = o();
        if (r101 == null) goto L294;
        y36.i r102 = ((x36.c) r101).b;
        if (r102 != null) goto L292;
        Intrinsics.throwUninitializedPropertyAccessException("enablePullDownClose");
        r102 = null;
    L292:
        if (r102 == null) goto L294;
        Boolean r103 = (Boolean) r102.b;
    L295:
        if (r103 == null) goto L297;
        r28.y = r103;
    L297:
        d r104 = o();
        if (r104 == null) goto L310;
        y36.i r105 = ((x36.c) r104).c;
        if (r105 != null) goto L304;
        Intrinsics.throwUninitializedPropertyAccessException("gravity");
        r105 = null;
    L304:
        if (r105.a == false) goto L310;
        l r106 = ((x36.c) r104).c;
        if (r106 != null) goto L309;
        Intrinsics.throwUninitializedPropertyAccessException("gravity");
        r106 = null;
    L309:
        String r107 = r106.a();
    L311:
        AnnieXPopupType r108 = AnnieXPopupType.BOTTOM;
        if (Intrinsics.areEqual(r107, r108.getValue()) == true) goto L321;
        r108 = AnnieXPopupType.CENTER;
        if (Intrinsics.areEqual(r107, r108.getValue()) == true) goto L321;
        r108 = AnnieXPopupType.RIGHT;
        if (Intrinsics.areEqual(r107, r108.getValue()) == true) goto L321;
        r108 = null;
    L321:
        if (r108 == null) goto L323;
        r28.z = r108;
    L323:
        d r109 = o();
        if (r109 == null) goto L333;
        y36.i r110 = ((x36.c) r109).d;
        if (r110 != null) goto L329;
        Intrinsics.throwUninitializedPropertyAccessException("height");
        r110 = null;
    L329:
        if (r110 == null) goto L333;
        Double r111 = (Double) r110.b;
        if (r111 == null) goto L333;
        Integer r112 = Integer.valueOf((int) r111.doubleValue());
    L334:
        if (r112 != null) goto L336;
    L338:
        d r113 = o();
        if (r113 == null) goto L346;
        y36.i r114 = r113.w;
        if (r114 != null) goto L344;
        Intrinsics.throwUninitializedPropertyAccessException("heightPercent");
        r114 = null;
    L344:
        if (r114 == null) goto L346;
        Integer r115 = (Integer) r114.b;
    L347:
        if (r115 != null) goto L349;
    L353:
        Uri r116 = this.l;
        if (r116 == null) goto L358;
        String r117 = UriProtector.getQueryParameter(r116, "horizontal_radius");
        if (r117 == null) goto L358;
        Double r118 = StringsKt.toDoubleOrNull(r117);
    L359:
        if (r118 != null) goto L361;
    L363:
        d r119 = o();
        if (r119 == null) goto L371;
        r r120 = ((x36.c) r119).e;
        if (r120 != null) goto L369;
        Intrinsics.throwUninitializedPropertyAccessException("maskBgColor");
        r120 = null;
    L369:
        if (r120 == null) goto L371;
        String r121 = r120.a();
    L372:
        if (r121 != null) goto L374;
    L376:
        if (r27 != null) goto L378;
    L380:
        d r122 = o();
        if (r122 == null) goto L390;
        y36.i r123 = ((x36.c) r122).g;
        if (r123 != null) goto L386;
        Intrinsics.throwUninitializedPropertyAccessException("width");
        r123 = null;
    L386:
        if (r123 == null) goto L390;
        Double r124 = (Double) r123.b;
        if (r124 == null) goto L390;
        Integer r125 = Integer.valueOf((int) r124.doubleValue());
    L391:
        if (r125 != null) goto L393;
    L395:
        d r126 = o();
        if (r126 == null) goto L403;
        y36.i r127 = r126.O;
        if (r127 != null) goto L401;
        Intrinsics.throwUninitializedPropertyAccessException("widthPercent");
        r127 = null;
    L401:
        if (r127 == null) goto L403;
        Integer r128 = (Integer) r127.b;
    L404:
        if (r128 != null) goto L406;
    L410:
        Intrinsics.checkNotNullParameter(r28, "<set-?>");
        this.h = r28;
        String r129 = this.d;
        String r130 = this.c;
        String r131 = this.b;
        LinkedHashMap r210 = new LinkedHashMap();
        m r132 = g.d;
        g r133 = g.a.b();
        ArrayList r134 = new ArrayList();
        String r135 = AnnieXNavBarItemName.CLOSE.getValue();
        int r136 = y.a;
        r134.add(new j0(r135, "sl://raw/ic_close", r133, new SLPopup$buildNavBarModel$leftItems$1$1(this)));
        i0 r137 = new i0();
        Intrinsics.checkNotNullParameter(r134, "items");
        r137.d = r134;
        String r138 = this.c;
        Intrinsics.checkNotNullParameter(r138, "annieXId");
        r137.a = r138;
        r137.h = false;
        d r139 = o();
        if (r139 == null) goto L418;
        y36.i r140 = r139.x;
        if (r140 == null) goto L415;
        r18 = r140;
    L416:
        if (r18 == null) goto L418;
        r15 = Intrinsics.areEqual(r18.b, Boolean.TRUE);
        goto L418
    L415:
        Intrinsics.throwUninitializedPropertyAccessException("hideNavBar");
    L418:
        r137.c = r15;
        g r141 = g.a.c();
        Intrinsics.checkNotNullParameter(r141, "backgroundColor");
        r137.b = r141;
        Intrinsics.checkNotNullParameter(r133, "titleColor");
        r137.g = r133;
        t0 r142 = new t0(getActivity());
        Arch r143 = Arch.SL;
        Intrinsics.checkNotNullParameter(r143, "<set-?>");
        r142.d = r143;
        Scenes r144 = Scenes.PopupFragment;
        Intrinsics.checkNotNullParameter(r144, "<set-?>");
        r142.e = r144;
        Unit r145 = Unit.INSTANCE;
        x0 r146 = new x0(r129, r130, r130, r131, r210, r28, r137, r142);
        int r147 = AnnieXPopupViewModel.s;
        Intrinsics.checkNotNullParameter(r146, "props");
        Intrinsics.checkNotNullParameter(r14, "coordinator");
        AnnieXPopupViewModel r148 = new AnnieXPopupViewModel(r146, r14);
        Intrinsics.checkNotNullParameter(r146, "<set-?>");
        this.g = r146;
        j r149 = r146.b();
        Intrinsics.checkNotNullParameter(r149, "<set-?>");
        this.h = r149;
        Intrinsics.checkNotNullParameter(r148, "<set-?>");
        this.i = r148;
        FragmentActivity r150 = this.u;
        AnnieXPopupViewModel r151 = h();
        Intrinsics.checkNotNull(r151, "null cannot be cast to non-null type com.bytedance.salamander.anniex.AnnieXPopupViewModel");
        ua.d r152 = new ua.d(r150, r151, g(), new SLPopup$createFakeContainer$1(this));
        Intrinsics.checkNotNullParameter(r152, "<set-?>");
        this.f = r152;
        AnnieXContainerManager.INSTANCE.addContainer(c());
        Map<String, i36.d> r153 = MonitorManager.a;
        MonitorManager.h(this.c, r144.getTag());
        e2 r154 = e2.b;
        e2.a.a().b(this.c, h());
        AnnieXPopupViewModel r155 = h();
        Intrinsics.checkNotNull(r155, "null cannot be cast to non-null type com.bytedance.salamander.anniex.AnnieXPopupViewModel");
        return r155;
    L406:
        if (r128.intValue() <= 0) goto L410;
        if (r128.intValue() > 100) goto L410;
        r28.G = r128.intValue();
    L403:
        r128 = null;
        goto L404
    L393:
        if (r125.intValue() <= 0) goto L395;
        r28.F = r125.intValue();
    L390:
        r125 = null;
        goto L391
    L378:
        if (r27.doubleValue() < 0) goto L380;
        r28.E = r27;
        goto L380
    L374:
        if (com.bytedance.anniex.bd.foundation.impl.d.b(r121) == false) goto L376;
        m r156 = new m(r121);
        g r157 = new g();
        r157.a = r156;
        r157.c = r156;
        r157.b = r156;
        r28.D = r157;
    L371:
        r121 = null;
        goto L372
    L361:
        if (r118.doubleValue() <= 0) goto L363;
        r28.C = r118;
    L358:
        r118 = null;
        goto L359
    L349:
        if (r115.intValue() <= 0) goto L353;
        if (r115.intValue() > 100) goto L353;
        r28.B = r115.intValue();
    L346:
        r115 = null;
        goto L347
    L336:
        if (r112.intValue() <= 0) goto L338;
        r28.A = r112.intValue();
    L333:
        r112 = null;
    L310:
        r107 = null;
    L294:
        r103 = null;
        goto L295
    L284:
        if (r100.intValue() <= 0) goto L286;
        r28.x = r100.intValue();
    L281:
        r100 = null;
        goto L282
    L267:
        if (r96.intValue() <= 0) goto L271;
        if (r96.intValue() > 100) goto L271;
        r96.intValue();
    L263:
        r96 = null;
        goto L265
    L253:
        if (r93.intValue() <= 0) goto L255;
        r93.intValue();
    L250:
        r93 = null;
    L237:
        r89 = null;
        goto L238
    L227:
        if (r86.intValue() <= 0) goto L229;
        r28.v = r86.intValue();
    L224:
        r86 = null;
        goto L225
    L212:
        if (r82.intValue() <= 0) goto L214;
        r28.u = r82.intValue();
    L209:
        r82 = null;
    L196:
        r78 = null;
    L185:
        r75 = null;
    L174:
        r72 = null;
    L165:
        r69 = null;
        goto L166
    L155:
        if (r66.doubleValue() <= 0) goto L157;
        r28.r = r66.doubleValue();
    L152:
        r66 = null;
    L143:
        r63 = false;
        goto L144
    L137:
        r60 = null;
    L133:
        r58 = -1;
    L122:
        r54 = false;
    L113:
        r51 = false;
    L107:
        r48 = false;
    L101:
        r45 = false;
        goto L102
    L92:
        r42 = null;
        goto L93
    L87:
        if (com.bytedance.anniex.bd.foundation.impl.d.b(r40) == false) goto L89;
        ((j) r28).c = new m(r40);
    L84:
        r40 = null;
        goto L85
    L77:
        if (com.bytedance.anniex.bd.foundation.impl.d.b(r37) == false) goto L79;
        ((j) r28).b = new m(r37);
    L74:
        r37 = null;
        goto L75
    L67:
        if (com.bytedance.anniex.bd.foundation.impl.d.b(r34) == false) goto L69;
        ((j) r28).a = new m(r34);
    L64:
        r34 = null;
        goto L65
    L57:
        if (com.bytedance.anniex.bd.foundation.impl.d.b(r31) == false) goto L59;
        ((j) r28).d = new m(r31);
    L54:
        r31 = null;
    L48:
        r27 = null;
    L38:
        r24 = false;
    L17:
        r21 = null;
        goto L28
    L18:
        v36.a r158 = d();
        if (r158 == null) goto L26;
        y36.i r159 = ((x36.a) r158).b;
        if (r159 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("hideLoading");
        r159 = null;
    L24:
        if (r159 == null) goto L26;
        boolean r160 = Intrinsics.areEqual(r159.b, Boolean.TRUE);
    L27:
        r21 = Boolean.valueOf(!r160);
    L26:
        r160 = false;
    L9:
        r17 = false;
        goto L10
    }

    public final d o() {
        return (d) this.v.getValue();
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
        FragmentActivity r0 = this.u;
        AnnieXPopupViewModel r1 = h();
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type com.bytedance.salamander.anniex.AnnieXPopupViewModel");
        ua.d r11 = new ua.d(r0, r1, g(), null);
        Intrinsics.checkNotNullParameter(r11, "<set-?>");
        this.f = r11;
        m16.b r12 = this.k;
        if (r12 == null) goto L6;
        r12.g(ia.c.class, c());
        return;
    }

    @Override // com.bytedance.android.anniex.salamander.AbsPageAndPopup
    public final void m(View r10, Bundle r11) {
        Intrinsics.checkNotNullParameter(r10, "view");
        super.m(r10, r11);
        m16.b r12 = this.k;
        if (r12 == null) goto L5;
        r12.g(ia.c.class, c());
    L5:
        m16.b r13 = this.k;
        if (r13 == null) goto L9;
        r13.d(com.bytedance.android.anniex.lite.utils.a.class, new com.bytedance.android.anniex.lite.utils.a("sl"));
        return;
    }

    public SLPopup(FragmentActivity r10, String r11, String r12, String r13) {
        Intrinsics.checkNotNullParameter(r10, "fragmentActivity");
        Intrinsics.checkNotNullParameter(r11, "currentBid");
        Intrinsics.checkNotNullParameter(r12, "containerId");
        Intrinsics.checkNotNullParameter(r13, "currentSchema");
        super(r10, r11, r12, r13);
        this.u = r10;
        this.v = LazyKt.lazy(new SLPopup$popupModel$2(this));
    }
}
