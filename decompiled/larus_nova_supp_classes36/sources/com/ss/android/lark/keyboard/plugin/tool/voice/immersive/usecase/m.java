package com.ss.android.lark.keyboard.plugin.tool.voice.immersive.usecase;

import android.content.Context;
import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import com.ss.android.lark.keyboard.plugin.tool.voice.immersive.animation.VoiceBubbleMotionScene;
import com.ss.android.lark.keyboard.plugin.tool.voice.immersive.model.ImmersiveVoiceViewModel;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class m implements View.OnLayoutChangeListener {
    public final /* synthetic */ VoiceBubbleAreaUseCase a;
    public final /* synthetic */ ImmersiveVoiceViewModel b;
    public final /* synthetic */ AppCompatTextView c;
    public final /* synthetic */ boolean d;
    public final /* synthetic */ int e;
    public final /* synthetic */ int f;
    public final /* synthetic */ Context g;

    public m(VoiceBubbleAreaUseCase r1, ImmersiveVoiceViewModel r2, AppCompatTextView r3, boolean r4, int r5, int r6, Context r7) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View r15, int r16, int r17, int r18, int r19, int r20, int r21, int r22, int r23) {
        r15.removeOnLayoutChangeListener(this);
        VoiceBubbleAreaUseCase.e(this.a, CollectionsKt.mutableListOf(new Integer[]{2131392773}), CollectionsKt.mutableListOf(new Integer[]{2131384022, 2131387916, 2131386396, 2131388751, 2131388770, 2131363256, 2131392750}));
        this.a.d.h().clearAnimation();
        this.a.d.s().b(((Number) this.a.t.getValue()).intValue());
        if (this.b.getImmersiveVoiceMode().c() == false) goto L10;
        VoiceBubbleMotionScene r1 = this.a.w;
        Intrinsics.checkNotNull(this.c);
        AppCompatTextView r2 = this.c;
        VoiceBubbleAreaUseCase r3 = this.a;
        com.ss.android.lark.keyboard.plugin.tool.voice.immersive.animation.b r4 = r3.w.p;
        if (this.d == false) goto L7;
        int r5 = VoiceBubbleAreaUseCase.a(r3);
    L8:
        r1.b(r2, r4, r5, VoiceBubbleAreaUseCase.d(this.a), this.e, this.f, 2131388764, new VoiceBubbleAreaUseCase$initObserver$1$1$1$3$1(this.d, this.c, this.g, this.a));
        return;
    L7:
        r5 = VoiceBubbleAreaUseCase.b(r3);
        goto L8
    L10:
        if (this.b.getImmersiveVoiceMode().b() == false) goto L20;
        VoiceBubbleMotionScene r6 = this.a.w;
        Intrinsics.checkNotNull(this.c);
        AppCompatTextView r7 = this.c;
        if (this.d == false) goto L14;
        com.ss.android.lark.keyboard.plugin.tool.voice.immersive.animation.b r8 = this.a.w.p;
    L15:
        int r9 = VoiceBubbleAreaUseCase.a(this.a);
        int r10 = VoiceBubbleAreaUseCase.d(this.a);
        int r11 = this.e;
        int r12 = this.f;
        boolean r13 = this.d;
        if (r13 == false) goto L18;
        int r14 = 2131388764;
    L19:
        r6.b(r7, r8, r9, r10, r11, r12, r14, new VoiceBubbleAreaUseCase$initObserver$1$1$1$3$2(r13, this.c, this.g, this.a));
        return;
    L18:
        r14 = 2131388765;
        goto L19
    L14:
        r8 = this.a.w.q;
        goto L15
    L20:
        VoiceBubbleMotionScene r24 = this.a.w;
        Intrinsics.checkNotNull(this.c);
        AppCompatTextView r25 = this.c;
        VoiceBubbleAreaUseCase r26 = this.a;
        VoiceBubbleMotionScene.c(r24, r25, r26.w.q, VoiceBubbleAreaUseCase.a(r26), ((Number) this.a.o.getValue()).intValue(), this.e, this.f, 2131388765);
        this.a.d.n().setVisibility(8);
    }
}
