package com.ss.android.lark.keyboard.plugin.tool.voice.immersive.usecase;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.Observer;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.audio.voiceinput.VoiceInputScene;
import com.ss.android.lark.keyboard.plugin.tool.voice.KeyboardVoiceFGUtils;
import com.ss.android.lark.keyboard.plugin.tool.voice.immersive.animation.VoiceBubbleMotionScene;
import com.ss.android.lark.keyboard.plugin.tool.voice.immersive.model.ImmersiveVoiceViewModel;
import com.ss.android.lark.keyboard.plugin.tool.voice.immersive.widget.VoiceWaveBar;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class p<T> implements Observer {
    public final /* synthetic */ AppCompatTextView a;
    public final /* synthetic */ VoiceBubbleAreaUseCase b;
    public final /* synthetic */ int c;
    public final /* synthetic */ Context d;
    public final /* synthetic */ ImmersiveVoiceViewModel e;
    public final /* synthetic */ ArrayList<View> f;
    public final /* synthetic */ int g;

    public p(AppCompatTextView r1, VoiceBubbleAreaUseCase r2, int r3, Context r4, ImmersiveVoiceViewModel r5, ArrayList<View> r6, int r7) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
    }

    public final void onChanged(Object r27) {
        com.ss.android.lark.keyboard.plugin.tool.voice.immersive.model.l r1 = (com.ss.android.lark.keyboard.plugin.tool.voice.immersive.model.l) r27;
        com.ss.android.lark.keyboard.plugin.tool.voice.immersive.model.l r2 = r1.c();
        if (r2 == null) goto L5;
        Integer r3 = Integer.valueOf(r2.getState());
    L6:
        boolean r4 = true;
        if (r3 != null) goto L10;
    L12:
        if (r3 != null) goto L15;
    L17:
        if (r3 != null) goto L20;
    L21:
        if (r3 != null) goto L24;
    L26:
        int r5 = 2131388765;
    L28:
        KeyboardVoiceFGUtils r11 = KeyboardVoiceFGUtils.a;
        final boolean r15 = KeyboardVoiceFGUtils.b();
        this.a.setText("");
        switch(r1.getState()) {
            case 0: goto L101;
            case 1: goto L94;
            case 2: goto L81;
            case 3: goto L61;
            case 4: goto L37;
            case 5: goto L31;
            case 6: goto L61;
            default: goto L121;
        };
    L31:
        VoiceBubbleAreaUseCase.e(this.b, CollectionsKt.mutableListOf(new Integer[]{2131363256, 2131392773}), CollectionsKt.mutableListOf(new Integer[]{2131384022, 2131388751, 2131388770, 2131388763, 2131388765, 2131388764, 2131392750}));
        VoiceWaveBar r6 = this.b.d.s();
        r6.a(Float.valueOf(r6.s));
        this.b.d.a().setEnabled(true);
        if (this.e.isSecondVoiceInput() == false) goto L35;
        return;
    L35:
        if (this.e.getImmersiveVoiceMode().b() == false) goto L108;
        com.ss.android.lark.keyboard.plugin.tool.voice.immersive.animation.c r7 = new com.ss.android.lark.keyboard.plugin.tool.voice.immersive.animation.c(this.b.a);
        final VoiceBubbleAreaUseCase r8 = this.b;
        com.ss.android.lark.keyboard.plugin.tool.voice.immersive.animation.c.a(r7, r8.a, new VoiceBubbleAreaUseCase$initObserver$1$1$1$5$1(r15, r8));
        r7.b(VoiceBubbleAreaUseCase$initObserver$1$1$1$5$2.INSTANCE);
        com.ss.android.lark.keyboard.plugin.tool.voice.immersive.animation.c.c(r7, null, null, 0, null, 15);
        return;
    L108:
        return;
    L37:
        VoiceBubbleAreaUseCase r9 = this.b;
        int r10 = VoiceBubbleAreaUseCase.y;
        r9.i(20);
        VoiceBubbleAreaUseCase r12 = this.b;
        ConstraintLayout r13 = r12.a;
        ImmersiveVoiceViewModel r14 = this.e;
        AppCompatTextView r16 = this.a;
        int r17 = this.g;
        Context r18 = this.d;
        if (r13.isLaidOut() == true) goto L40;
    L60:
        r13.addOnLayoutChangeListener(new m(r12, r14, r16, r15, r17, r5, r18));
        return;
    L40:
        if (r13.isLayoutRequested() == true) goto L60;
        VoiceBubbleAreaUseCase.e(r12, CollectionsKt.mutableListOf(new Integer[]{2131392773}), CollectionsKt.mutableListOf(new Integer[]{2131384022, 2131387916, 2131386396, 2131388751, 2131388770, 2131363256, 2131392750}));
        r12.d.h().clearAnimation();
        r12.d.s().b(((Number) r12.t.getValue()).intValue());
        if (r14.getImmersiveVoiceMode().c() == false) goto L49;
        VoiceBubbleMotionScene r19 = r12.w;
        Intrinsics.checkNotNull(r16);
        com.ss.android.lark.keyboard.plugin.tool.voice.immersive.animation.b r110 = r12.w.p;
        if (r15 == false) goto L46;
        int r20 = VoiceBubbleAreaUseCase.a(r12);
    L47:
        r19.b(r16, r110, r20, VoiceBubbleAreaUseCase.d(r12), r17, r5, 2131388764, new VoiceBubbleAreaUseCase$initObserver$1$1$1$3$1(r15, r16, r18, r12));
        return;
    L46:
        r20 = VoiceBubbleAreaUseCase.b(r12);
        goto L47
    L49:
        if (r14.getImmersiveVoiceMode().b() == false) goto L59;
        VoiceBubbleMotionScene r111 = r12.w;
        Intrinsics.checkNotNull(r16);
        if (r15 == false) goto L53;
        com.ss.android.lark.keyboard.plugin.tool.voice.immersive.animation.b r21 = r12.w.p;
    L54:
        com.ss.android.lark.keyboard.plugin.tool.voice.immersive.animation.b r112 = r21;
        int r113 = VoiceBubbleAreaUseCase.a(r12);
        int r22 = VoiceBubbleAreaUseCase.d(r12);
        if (r15 == false) goto L57;
        int r114 = 2131388764;
    L58:
        r111.b(r16, r112, r113, r22, r17, r5, r114, new VoiceBubbleAreaUseCase$initObserver$1$1$1$3$2(r15, r16, r18, r12));
        return;
    L57:
        r114 = 2131388765;
        goto L58
    L53:
        r21 = r12.w.q;
        goto L54
    L59:
        VoiceBubbleMotionScene r115 = r12.w;
        Intrinsics.checkNotNull(r16);
        VoiceBubbleMotionScene.c(r115, r16, r12.w.q, VoiceBubbleAreaUseCase.a(r12), ((Number) r12.o.getValue()).intValue(), r17, r5, 2131388765);
        r12.d.n().setVisibility(8);
        return;
    L61:
        VoiceBubbleAreaUseCase r23 = this.b;
        int r24 = VoiceBubbleAreaUseCase.y;
        r23.i(20);
        VoiceBubbleAreaUseCase r25 = this.b;
        ConstraintLayout r26 = r25.a;
        ImmersiveVoiceViewModel r28 = this.e;
        int r29 = this.c;
        AppCompatTextView r116 = this.a;
        Context r30 = this.d;
        if (r26.isLaidOut() == true) goto L64;
    L80:
        r26.addOnLayoutChangeListener(new n(r25, r28, r29, r116, r5, r30, r15));
        return;
    L64:
        if (r26.isLayoutRequested() == true) goto L80;
        VoiceBubbleAreaUseCase.e(r25, CollectionsKt.mutableListOf(new Integer[]{2131392773, 2131363256}), CollectionsKt.mutableListOf(new Integer[]{2131384022, 2131387916, 2131386396, 2131388751, 2131388770, 2131392750}));
        r25.d.h().clearAnimation();
        r25.d.s().b(r25.h());
        if (r28.isSecondVoiceInput() == false) goto L68;
        r25.w.d(VoiceBubbleAreaUseCase.c(r25), r29);
        return;
    L68:
        r25.d.a().setEnabled(false);
        if (r28.getImmersiveVoiceMode().b() == false) goto L79;
        VoiceBubbleMotionScene r117 = r25.w;
        Intrinsics.checkNotNull(r116);
        VoiceBubbleMotionScene.a(r117, r116, r25.w.p, VoiceBubbleAreaUseCase.c(r25), r29, r5, -1, new VoiceBubbleAreaUseCase$initObserver$1$1$1$4$1(r25));
        AppCompatTextView r31 = r25.d.n();
        r31.setVisibility(0);
        Function1<Context, CharSequence> r32 = r25.f().getOnlyAsrRecognizingTipsProvider();
        if (r32 == null) goto L73;
        Intrinsics.checkNotNull(r30);
        CharSequence r33 = (CharSequence) r32.invoke(r30);
    L74:
        if (r33 != null) goto L78;
        if (r15 == false) goto L77;
        r33 = UIUtils.getString(r30, 2131890989);
        goto L78
    L77:
        r33 = UIUtils.getString(r30, 2131890972);
    L78:
        r31.setText(r33);
        return;
    L73:
        r33 = null;
        goto L74
    L79:
        VoiceBubbleMotionScene r118 = r25.w;
        Intrinsics.checkNotNull(r116);
        VoiceBubbleMotionScene.a(r118, r116, r25.w.r, VoiceBubbleAreaUseCase.c(r25), r29, r5, 2131388763, new VoiceBubbleAreaUseCase$initObserver$1$1$1$4$3(r25));
        return;
    L81:
        VoiceBubbleAreaUseCase r34 = this.b;
        int r35 = VoiceBubbleAreaUseCase.y;
        r34.i(20);
        this.b.v.d();
        this.b.d.h().clearAnimation();
        this.b.d.s().b(this.b.h());
        VoiceBubbleAreaUseCase r36 = this.b;
        ConstraintLayout r37 = r36.a;
        AppCompatTextView r119 = this.a;
        int r38 = this.c;
        ImmersiveVoiceViewModel r120 = this.e;
        Context r121 = this.d;
        if (r37.isLaidOut() == true) goto L84;
    L93:
        r37.addOnLayoutChangeListener(new l(r36, r119, r38, r5, r120, r121));
        return;
    L84:
        if (r37.isLayoutRequested() == true) goto L93;
        VoiceBubbleAreaUseCase.e(r36, CollectionsKt.mutableListOf(new Integer[]{2131392773}), CollectionsKt.mutableListOf(new Integer[]{2131384022, 2131387916, 2131386396, 2131388751, 2131388770, 2131363256, 2131392750}));
        VoiceBubbleMotionScene r122 = r36.w;
        Intrinsics.checkNotNull(r119);
        VoiceBubbleMotionScene.c(r122, r119, r36.w.p, VoiceBubbleAreaUseCase.b(r36), VoiceBubbleAreaUseCase.d(r36), r38, r5, 2131388764);
        AppCompatTextView r39 = r36.d.n();
        if (r120.getImmersiveVoiceMode().b == VoiceInputScene.SecretChat) goto L89;
        r4 = false;
    L89:
        if (r4 == false) goto L91;
        String r40 = r121.getString(2131890416);
    L92:
        r39.setText(r40);
        return;
    L91:
        r40 = r121.getString(2131890973);
        goto L92
    L94:
        AppCompatImageView r41 = this.b.d.h();
        VoiceBubbleAreaUseCase r42 = this.b;
        if (r41.isLaidOut() == true) goto L97;
    L99:
        r41.addOnLayoutChangeListener(new o(r41, r42));
    L100:
        VoiceBubbleAreaUseCase.e(this.b, CollectionsKt.mutableListOf(new Integer[]{2131384022, 2131388764}), CollectionsKt.mutableListOf(new Integer[]{2131387916, 2131386396, 2131388751, 2131388770, 2131363256, 2131392750, 2131392773}));
        VoiceBubbleMotionScene r43 = this.b.w;
        AppCompatTextView r44 = this.a;
        Intrinsics.checkNotNull(r44);
        VoiceBubbleAreaUseCase r45 = this.b;
        VoiceBubbleMotionScene.c(r43, r44, r45.w.p, ((Number) r45.p.getValue()).intValue(), VoiceBubbleAreaUseCase.d(this.b), this.c, -1, 2131388764);
        this.b.d.n().setText(UIUtils.getString(this.d, 2131890969));
        return;
    L97:
        if (r41.isLayoutRequested() == true) goto L99;
        r41.startAnimation((Animation) r42.f.getValue());
        goto L100
    L101:
        VoiceBubbleAreaUseCase r46 = this.b;
        r46.g.applyTo(r46.a);
        VoiceBubbleAreaUseCase r47 = this.b;
        r47.h.applyTo(r47.d.o());
        this.b.d.s().b(this.b.h());
        this.b.d.r().setTextColor(UIUtils.getColor(this.d, this.b.h()));
        this.b.d.a().setText("");
        VoiceBubbleAreaUseCase.e(this.b, new ArrayList(), CollectionsKt.mutableListOf(new Integer[]{2131392773, 2131387916, 2131386396, 2131388751, 2131388770, 2131363256, 2131392750, 2131384022, 2131388763, 2131388765, 2131388764}));
        ArrayList<View> r48 = this.f;
        int r49 = this.c;
        Iterator<T> r50 = r48.iterator();
    L103:
        if (r50.hasNext() == false) goto L105;
        ((View) r50.next()).getBackground().setTint(r49);
        goto L103
    L105:
        VoiceImeWrapperUseCase r51 = this.b.c;
        r51.b.a().setMaxHeight(-1);
        r51.a.g();
        return;
    L121:
        return;
    L24:
        if (r3.intValue() != 2) goto L26;
    L27:
        r5 = 2131388764;
        goto L28
    L20:
        if (r3.intValue() == 1) goto L27;
    L15:
        if (r3.intValue() != 3) goto L17;
        r5 = 2131388763;
        goto L28
    L10:
        if (r3.intValue() != 4) goto L12;
    L5:
        r3 = null;
        goto L6
    }
}
