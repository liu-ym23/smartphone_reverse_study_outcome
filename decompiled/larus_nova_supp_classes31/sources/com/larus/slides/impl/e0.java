package com.larus.slides.impl;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.viewbinding.ViewBinding;
import com.larus.office.base.OfficeBaseFragment;
import com.larus.office.base.service.BizMenuData;
import com.larus.office.base.service.BizMenuItem;
import com.larus.slides.biz.impl.databinding.LarusLayoutSlidesDetailFragmentBinding;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class e0 implements com.larus.office.base.service.b {
    public final /* synthetic */ SlidesFragment a;

    public final Function0<String> getIdGetter() {
        return null;
    }

    public final ViewGroup b() {
        return this.a.ta0();
    }

    public final void f() {
        SlidesFragment r0 = this.a;
        int r1 = SlidesFragment.O;
        Fragment r2 = ((OfficeBaseFragment) r0).f;
        if (r2 == null) goto L11;
        va8.g0 r3 = s1a.a.g(r2).o(Reflection.getOrCreateKotlinClass(va8.g0.class));
        if (r3 == null) goto L7;
        r3.expand("web");
    L7:
        va8.p r4 = s1a.a.g(r2).o(Reflection.getOrCreateKotlinClass(va8.p.class));
        if (r4 == null) goto L12;
        r4.O5(true);
        return;
    L12:
        return;
    }

    public e0(SlidesFragment r1) {
        this.a = r1;
    }

    public final void c(boolean r3) {
        SlidesFragment r0 = this.a;
        r0.i = r3;
        if (r3 == false) goto L5;
        SlidesFragment.ka0(r0, false, "onCustomHeaderVisibilityChanged");
        return;
    L5:
        SlidesFragment.fa0(r0);
    }

    public final void d(ViewGroup r1) {
        this.a.ua0();
    }

    /* JADX WARN: Type inference failed for: r10v0, types: [com.larus.slides.impl.z] */
    /* JADX WARN: Type inference failed for: r9v0, types: [com.larus.slides.impl.y] */
    public final void e(BizMenuData r19, final com.larus.office.base.plugins.titlebar.c r20, final com.larus.office.base.plugins.titlebar.d r21) {
        Intrinsics.checkNotNullParameter(r20, "onMenuClick");
        if (this.a.isAdded() == true) goto L5;
        return;
    L5:
        if (xw9.g.a() == false) goto L11;
        FLogger.a.w("SlidesFragment", "onTitleMenuUpdate setting disable slides presentation mode");
        SlidesFragment r2 = this.a;
        int r8 = SlidesFragment.O;
        LarusLayoutSlidesDetailFragmentBinding r3 = (LarusLayoutSlidesDetailFragmentBinding) ((OfficeBaseFragment) r2).e;
        if (r3 == null) goto L47;
        ImageView r4 = r3.o;
        if (r4 == null) goto L47;
        e1.o(r4);
    L47:
        if (r19 == null) goto L58;
        List r5 = r19.getItems();
        if (r5 == null) goto L58;
        Iterator r6 = r5.iterator();
    L52:
        if (r6.hasNext() == false) goto L56;
        Object r9 = r6.next();
        if (Intrinsics.areEqual(((BizMenuItem) r9).getId(), "UNDO") == false) goto L52;
    L57:
        final BizMenuItem r10 = (BizMenuItem) r9;
    L59:
        if (r10 != null) goto L65;
        SlidesFragment r7 = this.a;
        int r11 = SlidesFragment.O;
        LarusLayoutSlidesDetailFragmentBinding r12 = (LarusLayoutSlidesDetailFragmentBinding) ((OfficeBaseFragment) r7).e;
        if (r12 == null) goto L94;
        ImageView r13 = r12.s;
        if (r13 == null) goto L94;
        r13.setVisibility(8);
    L94:
        if (r19 == null) goto L105;
        List r14 = r19.getItems();
        if (r14 == null) goto L105;
        Iterator r15 = r14.iterator();
    L99:
        if (r15.hasNext() == false) goto L103;
        Object r16 = r15.next();
        if (Intrinsics.areEqual(((BizMenuItem) r16).getId(), "REDO") == false) goto L99;
    L104:
        final BizMenuItem r17 = (BizMenuItem) r16;
    L106:
        if (r17 != null) goto L112;
        SlidesFragment r18 = this.a;
        int r22 = SlidesFragment.O;
        LarusLayoutSlidesDetailFragmentBinding r23 = (LarusLayoutSlidesDetailFragmentBinding) ((OfficeBaseFragment) r18).e;
        if (r23 == null) goto L141;
        ImageView r24 = r23.p;
        if (r24 == null) goto L141;
        r24.setVisibility(8);
    L141:
        if (r19 == null) goto L152;
        List r25 = r19.getItems();
        if (r25 == null) goto L152;
        Iterator r26 = r25.iterator();
    L146:
        if (r26.hasNext() == false) goto L150;
        Object r27 = r26.next();
        if (Intrinsics.areEqual(((BizMenuItem) r27).getId(), "MORE_OPERATE") == false) goto L146;
    L151:
        final BizMenuItem r28 = (BizMenuItem) r27;
    L153:
        if (r28 != null) goto L160;
        SlidesFragment r1 = this.a;
        int r29 = SlidesFragment.O;
        LarusLayoutSlidesDetailFragmentBinding r30 = (LarusLayoutSlidesDetailFragmentBinding) ((OfficeBaseFragment) r1).e;
        if (r30 == null) goto L200;
        ImageView r31 = r30.n;
        if (r31 == null) goto L201;
        r31.setVisibility(8);
        return;
    L201:
        return;
    L200:
        return;
    L160:
        if (this.a.C == false) goto L162;
    L164:
        LarusLayoutSlidesDetailFragmentBinding r32 = (LarusLayoutSlidesDetailFragmentBinding) ((OfficeBaseFragment) this.a).e;
        if (r32 == null) goto L170;
        ImageView r33 = r32.n;
        if (r33 == null) goto L170;
        r33.setVisibility(0);
    L170:
        if (r28.getDisabled() == false) goto L176;
        SlidesFragment r34 = this.a;
        LarusLayoutSlidesDetailFragmentBinding r35 = (LarusLayoutSlidesDetailFragmentBinding) ((OfficeBaseFragment) r34).e;
        if (r35 == null) goto L181;
        ImageView r36 = r35.n;
        if (r36 == null) goto L181;
        r36.setColorFilter(r34.getResources().getColor(2131103140));
    L181:
        final SlidesFragment r37 = this.a;
        LarusLayoutSlidesDetailFragmentBinding r38 = (LarusLayoutSlidesDetailFragmentBinding) ((OfficeBaseFragment) r37).e;
        if (r38 == null) goto L203;
        ImageView r39 = r38.n;
        if (r39 == null) goto L204;
        e1.d(r39, new c0(r20, r28, r37, r21));
        return;
    L204:
        return;
    L203:
        return;
    L176:
        SlidesFragment r40 = this.a;
        LarusLayoutSlidesDetailFragmentBinding r41 = (LarusLayoutSlidesDetailFragmentBinding) ((OfficeBaseFragment) r40).e;
        if (r41 == null) goto L181;
        ImageView r42 = r41.n;
        if (r42 == null) goto L181;
        r42.setColorFilter(r40.getResources().getColor(2131103136));
        goto L181
    L162:
        if (r28.getDisabled() == true) goto L164;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this.a), Dispatchers.getIO(), null, new SlidesFragment$initTitleBarService$1$onTitleMenuUpdate$8(this.a, null), 2, null);
        goto L164
    L150:
        r27 = null;
    L152:
        r28 = null;
        goto L153
    L112:
        SlidesFragment r43 = this.a;
        if (r43.B == false) goto L115;
    L119:
        LarusLayoutSlidesDetailFragmentBinding r44 = (LarusLayoutSlidesDetailFragmentBinding) ((OfficeBaseFragment) this.a).e;
        if (r44 == null) goto L124;
        ImageView r45 = r44.p;
        if (r45 == null) goto L124;
        r45.setVisibility(0);
    L124:
        this.a.A = !r17.getDisabled();
        if (r17.getDisabled() == false) goto L131;
        SlidesFragment r46 = this.a;
        LarusLayoutSlidesDetailFragmentBinding r47 = (LarusLayoutSlidesDetailFragmentBinding) ((OfficeBaseFragment) r46).e;
        if (r47 == null) goto L136;
        ImageView r48 = r47.p;
        if (r48 == null) goto L136;
        r48.setColorFilter(r46.getResources().getColor(2131103140));
    L136:
        final SlidesFragment r49 = this.a;
        LarusLayoutSlidesDetailFragmentBinding r50 = (LarusLayoutSlidesDetailFragmentBinding) ((OfficeBaseFragment) r49).e;
        if (r50 == null) goto L141;
        ImageView r51 = r50.p;
        if (r51 == null) goto L141;
        e1.d(r51, new b0(r20, r17, r49));
        goto L141
    L131:
        SlidesFragment r52 = this.a;
        LarusLayoutSlidesDetailFragmentBinding r53 = (LarusLayoutSlidesDetailFragmentBinding) ((OfficeBaseFragment) r52).e;
        if (r53 == null) goto L136;
        ImageView r54 = r53.p;
        if (r54 == null) goto L136;
        r54.setColorFilter(r52.getResources().getColor(2131103136));
        goto L136
    L115:
        if (r43.A == true) goto L119;
        if (r17.getDisabled() == true) goto L119;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this.a), Dispatchers.getIO(), null, new SlidesFragment$initTitleBarService$1$onTitleMenuUpdate$6(this.a, null), 2, null);
        goto L119
    L103:
        r16 = null;
    L105:
        r17 = null;
        goto L106
    L65:
        SlidesFragment r55 = this.a;
        if (r55.z == false) goto L68;
    L72:
        LarusLayoutSlidesDetailFragmentBinding r56 = (LarusLayoutSlidesDetailFragmentBinding) ((OfficeBaseFragment) this.a).e;
        if (r56 == null) goto L77;
        ImageView r57 = r56.s;
        if (r57 == null) goto L77;
        r57.setVisibility(0);
    L77:
        this.a.y = !r10.getDisabled();
        if (r10.getDisabled() == false) goto L84;
        SlidesFragment r58 = this.a;
        LarusLayoutSlidesDetailFragmentBinding r59 = (LarusLayoutSlidesDetailFragmentBinding) ((OfficeBaseFragment) r58).e;
        if (r59 == null) goto L89;
        ImageView r60 = r59.s;
        if (r60 == null) goto L89;
        r60.setColorFilter(r58.getResources().getColor(2131103140));
    L89:
        final SlidesFragment r61 = this.a;
        LarusLayoutSlidesDetailFragmentBinding r62 = (LarusLayoutSlidesDetailFragmentBinding) ((OfficeBaseFragment) r61).e;
        if (r62 == null) goto L94;
        ImageView r63 = r62.s;
        if (r63 == null) goto L94;
        e1.d(r63, new a0(r20, r10, r61));
        goto L94
    L84:
        SlidesFragment r64 = this.a;
        LarusLayoutSlidesDetailFragmentBinding r65 = (LarusLayoutSlidesDetailFragmentBinding) ((OfficeBaseFragment) r64).e;
        if (r65 == null) goto L89;
        ImageView r66 = r65.s;
        if (r66 == null) goto L89;
        r66.setColorFilter(r64.getResources().getColor(2131103136));
        goto L89
    L68:
        if (r55.y == true) goto L72;
        if (r10.getDisabled() == true) goto L72;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this.a), Dispatchers.getIO(), null, new SlidesFragment$initTitleBarService$1$onTitleMenuUpdate$4(this.a, null), 2, null);
        goto L72
    L56:
        r9 = null;
    L58:
        r10 = null;
        goto L59
    L11:
        final SlidesFragment r67 = this.a;
        int r68 = SlidesFragment.O;
        LarusLayoutSlidesDetailFragmentBinding r69 = (LarusLayoutSlidesDetailFragmentBinding) ((OfficeBaseFragment) r67).e;
        if (r69 == null) goto L14;
        ImageView r70 = r69.o;
    L15:
        final ?? r71 = new y(r67);
        final ?? r110 = new z(r67);
        if (r19 == null) goto L27;
        List r111 = r19.getItems();
        if (r111 == null) goto L27;
        Iterator r112 = r111.iterator();
    L21:
        if (r112.hasNext() == false) goto L25;
        Object r113 = r112.next();
        if (Intrinsics.areEqual(((BizMenuItem) r113).getId(), "PRESENTATION") == false) goto L21;
    L26:
        BizMenuItem r114 = (BizMenuItem) r113;
    L28:
        if (r114 != null) goto L31;
        if (r70 == null) goto L45;
        r70.setVisibility(8);
    L45:
        if (r70 == null) goto L47;
        e1.d(r70, new s(r20, r110, r71));
        goto L47
    L31:
        if (r70 == null) goto L33;
        r70.setVisibility(0);
    L33:
        if (r70 == null) goto L36;
        r70.setEnabled(!r114.getDisabled());
    L36:
        if (r114.getDisabled() == false) goto L39;
        if (r70 == null) goto L45;
        r70.setColorFilter(r67.getResources().getColor(2131103140));
        goto L45
    L39:
        if (r70 == null) goto L42;
        r70.setColorFilter(r67.getResources().getColor(2131103136));
    L42:
        if (r67.x == true) goto L44;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r67), Dispatchers.getIO(), null, new SlidesFragment$initTitleBarService$1$onTitleMenuUpdate$1$1(r67, null), 2, null);
    L44:
        Unit r72 = Unit.INSTANCE;
        goto L45
    L25:
        r113 = null;
    L27:
        r114 = null;
        goto L28
    L14:
        r70 = null;
        goto L15
    }

    public final void a(Integer r6, String r7, String r8, String r9) {
        FLogger.a.i("SlidesFragment", "On received title, type=" + r6 + ", title=" + r7 + ", subTitle=" + r8);
        if (this.a.isAdded() == false) goto L69;
        SlidesFragment r0 = this.a;
        r0.p = r9;
        ViewBinding r10 = ((OfficeBaseFragment) r0).e;
        LarusLayoutSlidesDetailFragmentBinding r1 = (LarusLayoutSlidesDetailFragmentBinding) r10;
        if (r1 == null) goto L7;
        TextView r2 = r1.r;
    L8:
        LarusLayoutSlidesDetailFragmentBinding r11 = (LarusLayoutSlidesDetailFragmentBinding) r10;
        if (r11 == null) goto L11;
        TextView r12 = r11.q;
    L12:
        if (r6 == null) goto L25;
        if (r6.intValue() != 2) goto L25;
        if (r2 == null) goto L18;
        r2.setTextColor(this.a.getResources().getColor(2131103143));
    L18:
        if (r2 == null) goto L20;
        r2.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
    L20:
        if (r2 == null) goto L22;
        r2.setText(r8);
    L22:
        if (r12 == null) goto L70;
        e1.o(r12);
        return;
    L70:
        return;
    L25:
        if (r6 != null) goto L28;
    L39:
        if (r6 != null) goto L42;
    L56:
        if (r2 == null) goto L58;
        r2.setTextColor(this.a.getResources().getColor(2131103136));
    L58:
        if (r2 == null) goto L60;
        r2.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
    L60:
        if (r2 == null) goto L63;
        r2.setText(r7);
    L63:
        if (com.larus.utils.o0.d(r8) == false) goto L76;
        if (r12 == null) goto L66;
        r12.setText(r8);
    L66:
        if (r12 == null) goto L77;
        e1.x(r12);
        return;
    L77:
        return;
    L76:
        return;
    L42:
        if (r6.intValue() != 4) goto L56;
        if (r2 == null) goto L45;
        r2.setTextColor(this.a.getResources().getColor(2131103203));
    L45:
        if (r2 == null) goto L47;
        r2.setText(r7);
    L47:
        Context r13 = this.a.getContext();
        if (r13 == null) goto L54;
        Drawable r14 = AppCompatResources.getDrawable(r13, 2131240817);
        if (r2 == null) goto L52;
        r2.setCompoundDrawablesWithIntrinsicBounds(r14, null, null, null);
    L52:
        if (r2 == null) goto L54;
        r2.setCompoundDrawablePadding(i5.j0());
    L54:
        if (r12 == null) goto L74;
        e1.o(r12);
        return;
    L74:
        return;
    L28:
        if (r6.intValue() != 3) goto L39;
        if (r2 == null) goto L31;
        r2.setTextColor(this.a.getResources().getColor(2131103136));
    L31:
        if (r2 == null) goto L33;
        r2.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
    L33:
        if (r2 == null) goto L35;
        r2.setText(r7);
    L35:
        if (r12 == null) goto L37;
        r12.setText(r8);
    L37:
        if (r12 == null) goto L72;
        e1.x(r12);
        return;
    L72:
        return;
    L11:
        r12 = null;
        goto L12
    L7:
        r2 = null;
        goto L8
    }
}
