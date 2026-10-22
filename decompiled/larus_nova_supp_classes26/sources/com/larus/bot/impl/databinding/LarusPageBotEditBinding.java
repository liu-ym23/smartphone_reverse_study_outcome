package com.larus.bot.impl.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.larus.bmhome.view.NovaTitleBarEx;
import com.larus.bmhome.view.item.ItemGroup;
import com.larus.bmhome.view.item.ItemLongTextArrow;
import com.larus.bmhome.view.item.ItemTextArrow;
import com.larus.bmhome.view.item.ItemTextToggle;
import com.larus.bot.impl.feature.edit.feature.firstmet.tts.BotCreateTtsPlayerView;
import com.larus.bot.impl.feature.edit.view.BotEditScrollView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class LarusPageBotEditBinding implements ViewBinding {
    public final FrameLayout A;
    public final AppCompatImageView B;
    public final View C;
    public final View D;
    public final ConstraintLayout E;
    public final AppCompatTextView F;
    public final ViewStub G;
    public final ViewStub H;
    public final ConstraintLayout I;
    public final BotEditScrollView J;
    public final NovaTitleBarEx K;
    public final ItemTextToggle L;
    public final ConstraintLayout a;
    public final ItemLongTextArrow b;
    public final ItemLongTextArrow c;
    public final ConstraintLayout d;
    public final ConstraintLayout e;
    public final FrameLayout f;
    public final LarusLayoutBotBioEditBinding g;
    public final ConstraintLayout h;
    public final TextView i;
    public final View j;
    public final TextView k;
    public final AppCompatTextView l;
    public final AppCompatTextView m;
    public final AppCompatTextView n;
    public final AppCompatEditText o;
    public final LarusBotCreateDescSkeletonBinding p;
    public final LarusLayoutBotFirstMetEditBinding q;
    public final ItemTextToggle r;
    public final ItemGroup s;
    public final ItemTextArrow t;
    public final ItemTextArrow u;
    public final ItemTextArrow v;
    public final ItemTextArrow w;
    public final ItemTextArrow x;
    public final ItemTextArrow y;
    public final AppCompatEditText z;

    public final View getRoot() {
        return this.a;
    }

    public static LarusPageBotEditBinding a(LayoutInflater r42, ViewGroup r43) {
        ConstraintLayout r0 = r42.inflate(2131563002, r43, false);
        int r1 = 2131361971;
        ItemLongTextArrow r5 = (ItemLongTextArrow) ViewBindings.findChildViewById(r0, 2131361971);
        if (r5 == null) goto L135;
        r1 = 2131361972;
        ItemLongTextArrow r6 = (ItemLongTextArrow) ViewBindings.findChildViewById(r0, 2131361972);
        if (r6 == null) goto L135;
        r1 = 2131362304;
        ConstraintLayout r7 = ViewBindings.findChildViewById(r0, 2131362304);
        if (r7 == null) goto L135;
        r1 = 2131362305;
        ConstraintLayout r8 = ViewBindings.findChildViewById(r0, 2131362305);
        if (r8 == null) goto L135;
        r1 = 2131363653;
        FrameLayout r9 = (FrameLayout) ViewBindings.findChildViewById(r0, 2131363653);
        if (r9 == null) goto L135;
        r1 = 2131364180;
        ConstraintLayout r3 = ViewBindings.findChildViewById(r0, 2131364180);
        if (r3 == null) goto L135;
        int r2 = 2131364179;
        AppCompatEditText r4 = ViewBindings.findChildViewById(r3, 2131364179);
        if (r4 == null) goto L133;
        r2 = 2131364182;
        View r10 = ViewBindings.findChildViewById(r3, 2131364182);
        if (r10 == null) goto L133;
        LarusBotCreateDescSkeletonBinding r11 = LarusBotCreateDescSkeletonBinding.a(r10);
        AppCompatTextView r12 = ViewBindings.findChildViewById(r3, 2131364183);
        if (r12 == null) goto L131;
        LarusLayoutBotBioEditBinding r13 = new LarusLayoutBotBioEditBinding(r3, r4, r11, r12);
        r1 = 2131364458;
        ConstraintLayout r14 = ViewBindings.findChildViewById(r0, 2131364458);
        if (r14 == null) goto L135;
        r1 = 2131368186;
        TextView r15 = (TextView) ViewBindings.findChildViewById(r0, 2131368186);
        if (r15 == null) goto L135;
        r1 = 2131368187;
        View r16 = ViewBindings.findChildViewById(r0, 2131368187);
        if (r16 == null) goto L135;
        r1 = 2131368205;
        TextView r17 = (TextView) ViewBindings.findChildViewById(r0, 2131368205);
        if (r17 == null) goto L135;
        r1 = 2131368833;
        AppCompatTextView r18 = ViewBindings.findChildViewById(r0, 2131368833);
        if (r18 == null) goto L135;
        r1 = 2131368834;
        AppCompatTextView r19 = ViewBindings.findChildViewById(r0, 2131368834);
        if (r19 == null) goto L135;
        r1 = 2131368843;
        AppCompatTextView r110 = ViewBindings.findChildViewById(r0, 2131368843);
        if (r110 == null) goto L135;
        r1 = 2131368852;
        AppCompatEditText r111 = ViewBindings.findChildViewById(r0, 2131368852);
        if (r111 == null) goto L135;
        r1 = 2131368853;
        if (ViewBindings.findChildViewById(r0, 2131368853) == null) goto L135;
        r1 = 2131368860;
        View r20 = ViewBindings.findChildViewById(r0, 2131368860);
        if (r20 == null) goto L135;
        LarusBotCreateDescSkeletonBinding r112 = LarusBotCreateDescSkeletonBinding.a(r20);
        r1 = 2131371873;
        if (ViewBindings.findChildViewById(r0, 2131371873) == null) goto L135;
        r1 = 2131371874;
        if (ViewBindings.findChildViewById(r0, 2131371874) == null) goto L135;
        r1 = 2131372602;
        ConstraintLayout r21 = ViewBindings.findChildViewById(r0, 2131372602);
        if (r21 == null) goto L135;
        int r22 = 2131383366;
        AppCompatEditText r23 = ViewBindings.findChildViewById(r21, 2131383366);
        if (r23 == null) goto L130;
        r22 = 2131383367;
        View r24 = ViewBindings.findChildViewById(r21, 2131383367);
        if (r24 == null) goto L130;
        LarusBotCreateDescSkeletonBinding r25 = LarusBotCreateDescSkeletonBinding.a(r24);
        r22 = 2131383368;
        View r26 = ViewBindings.findChildViewById(r21, 2131383368);
        if (r26 == null) goto L130;
        r22 = 2131383369;
        AppCompatTextView r27 = ViewBindings.findChildViewById(r21, 2131383369);
        if (r27 == null) goto L130;
        r22 = 2131387703;
        ItemTextArrow r28 = (ItemTextArrow) ViewBindings.findChildViewById(r21, 2131387703);
        if (r28 == null) goto L130;
        r22 = 2131389947;
        BotCreateTtsPlayerView r29 = (BotCreateTtsPlayerView) ViewBindings.findChildViewById(r21, 2131389947);
        if (r29 == null) goto L130;
        LarusLayoutBotFirstMetEditBinding r30 = new LarusLayoutBotFirstMetEditBinding(r21, r23, r25, r26, r27, r28, r29);
        ItemTextToggle r210 = (ItemTextToggle) ViewBindings.findChildViewById(r0, 2131373618);
        if (r210 != null) goto L61;
        r1 = 2131373618;
        goto L135
    L61:
        if (((ItemGroup) ViewBindings.findChildViewById(r0, 2131374005)) == null) goto L127;
        ItemGroup r211 = (ItemGroup) ViewBindings.findChildViewById(r0, 2131374006);
        if (r211 == null) goto L126;
        ItemTextArrow r212 = (ItemTextArrow) ViewBindings.findChildViewById(r0, 2131375786);
        if (r212 == null) goto L125;
        ItemTextArrow r213 = (ItemTextArrow) ViewBindings.findChildViewById(r0, 2131375787);
        if (r213 == null) goto L124;
        ItemTextArrow r214 = (ItemTextArrow) ViewBindings.findChildViewById(r0, 2131375890);
        if (r214 == null) goto L123;
        ItemTextArrow r215 = (ItemTextArrow) ViewBindings.findChildViewById(r0, 2131375891);
        if (r215 == null) goto L122;
        ItemTextArrow r216 = (ItemTextArrow) ViewBindings.findChildViewById(r0, 2131380246);
        if (r216 == null) goto L121;
        ItemTextArrow r217 = (ItemTextArrow) ViewBindings.findChildViewById(r0, 2131380247);
        if (r217 == null) goto L120;
        AppCompatEditText r218 = ViewBindings.findChildViewById(r0, 2131380599);
        if (r218 == null) goto L119;
        FrameLayout r31 = (FrameLayout) ViewBindings.findChildViewById(r0, 2131380600);
        if (r31 == null) goto L118;
        AppCompatImageView r32 = ViewBindings.findChildViewById(r0, 2131380601);
        if (r32 != null) goto L83;
        r1 = 2131380601;
        goto L135
    L83:
        if (ViewBindings.findChildViewById(r0, 2131380602) == null) goto L116;
        View r33 = ViewBindings.findChildViewById(r0, 2131380603);
        if (r33 == null) goto L115;
        View r34 = ViewBindings.findChildViewById(r0, 2131380604);
        if (r34 == null) goto L114;
        ConstraintLayout r35 = ViewBindings.findChildViewById(r0, 2131380605);
        if (r35 == null) goto L113;
        AppCompatTextView r36 = ViewBindings.findChildViewById(r0, 2131380612);
        if (r36 == null) goto L112;
        ViewStub r37 = (ViewStub) ViewBindings.findChildViewById(r0, 2131380694);
        if (r37 == null) goto L111;
        ViewStub r38 = (ViewStub) ViewBindings.findChildViewById(r0, 2131381428);
        if (r38 == null) goto L110;
        ConstraintLayout r39 = ViewBindings.findChildViewById(r0, 2131385222);
        if (r39 == null) goto L109;
        BotEditScrollView r310 = (BotEditScrollView) ViewBindings.findChildViewById(r0, 2131385238);
        if (r310 == null) goto L108;
        NovaTitleBarEx r40 = (NovaTitleBarEx) ViewBindings.findChildViewById(r0, 2131388772);
        if (r40 == null) goto L107;
        ItemTextToggle r41 = (ItemTextToggle) ViewBindings.findChildViewById(r0, 2131393129);
        if (r41 != null) goto L105;
        r1 = 2131393129;
        goto L135
    L105:
        return new LarusPageBotEditBinding(r0, r5, r6, r7, r8, r9, r13, r14, r15, r16, r17, r18, r19, r110, r111, r112, r30, r210, r211, r212, r213, r214, r215, r216, r217, r218, r31, r32, r33, r34, r35, r36, r37, r38, r39, r310, r40, r41);
    L107:
        r1 = 2131388772;
        goto L135
    L108:
        r1 = 2131385238;
        goto L135
    L109:
        r1 = 2131385222;
        goto L135
    L110:
        r1 = 2131381428;
        goto L135
    L111:
        r1 = 2131380694;
        goto L135
    L112:
        r1 = 2131380612;
        goto L135
    L113:
        r1 = 2131380605;
        goto L135
    L114:
        r1 = 2131380604;
        goto L135
    L115:
        r1 = 2131380603;
        goto L135
    L116:
        r1 = 2131380602;
        goto L135
    L118:
        r1 = 2131380600;
        goto L135
    L119:
        r1 = 2131380599;
        goto L135
    L120:
        r1 = 2131380247;
        goto L135
    L121:
        r1 = 2131380246;
        goto L135
    L122:
        r1 = 2131375891;
        goto L135
    L123:
        r1 = 2131375890;
        goto L135
    L124:
        r1 = 2131375787;
        goto L135
    L125:
        r1 = 2131375786;
        goto L135
    L126:
        r1 = 2131374006;
        goto L135
    L127:
        r1 = 2131374005;
    L130:
        throw new NullPointerException("Missing required view with ID: ".concat(r21.getResources().getResourceName(r22)));
    L131:
        r2 = 2131364183;
    L133:
        throw new NullPointerException("Missing required view with ID: ".concat(r3.getResources().getResourceName(r2)));
    L135:
        throw new NullPointerException("Missing required view with ID: ".concat(r0.getResources().getResourceName(r1)));
    }

    public LarusPageBotEditBinding(ConstraintLayout r3, ItemLongTextArrow r4, ItemLongTextArrow r5, ConstraintLayout r6, ConstraintLayout r7, FrameLayout r8, LarusLayoutBotBioEditBinding r9, ConstraintLayout r10, TextView r11, View r12, TextView r13, AppCompatTextView r14, AppCompatTextView r15, AppCompatTextView r16, AppCompatEditText r17, LarusBotCreateDescSkeletonBinding r18, LarusLayoutBotFirstMetEditBinding r19, ItemTextToggle r20, ItemGroup r21, ItemTextArrow r22, ItemTextArrow r23, ItemTextArrow r24, ItemTextArrow r25, ItemTextArrow r26, ItemTextArrow r27, AppCompatEditText r28, FrameLayout r29, AppCompatImageView r30, View r31, View r32, ConstraintLayout r33, AppCompatTextView r34, ViewStub r35, ViewStub r36, ConstraintLayout r37, BotEditScrollView r38, NovaTitleBarEx r39, ItemTextToggle r40) {
        this.a = r3;
        this.b = r4;
        this.c = r5;
        this.d = r6;
        this.e = r7;
        this.f = r8;
        this.g = r9;
        this.h = r10;
        this.i = r11;
        this.j = r12;
        this.k = r13;
        this.l = r14;
        this.m = r15;
        this.n = r16;
        this.o = r17;
        this.p = r18;
        this.q = r19;
        this.r = r20;
        this.s = r21;
        this.t = r22;
        this.u = r23;
        this.v = r24;
        this.w = r25;
        this.x = r26;
        this.y = r27;
        this.z = r28;
        this.A = r29;
        this.B = r30;
        this.C = r31;
        this.D = r32;
        this.E = r33;
        this.F = r34;
        this.G = r35;
        this.H = r36;
        this.I = r37;
        this.J = r38;
        this.K = r39;
        this.L = r40;
    }
}
