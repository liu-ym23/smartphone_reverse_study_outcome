package com.ss.android.lark.keyboard.plugin.tool.voice.immersive.usecase;

import android.content.Context;
import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.keyboard.plugin.tool.voice.immersive.animation.VoiceBubbleMotionScene;
import com.ss.android.lark.keyboard.plugin.tool.voice.immersive.model.ImmersiveVoiceViewModel;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class n implements View.OnLayoutChangeListener {
    public final /* synthetic */ VoiceBubbleAreaUseCase a;
    public final /* synthetic */ ImmersiveVoiceViewModel b;
    public final /* synthetic */ int c;
    public final /* synthetic */ AppCompatTextView d;
    public final /* synthetic */ int e;
    public final /* synthetic */ Context f;
    public final /* synthetic */ boolean g;

    public n(VoiceBubbleAreaUseCase r1, ImmersiveVoiceViewModel r2, int r3, AppCompatTextView r4, int r5, Context r6, boolean r7) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View r12, int r13, int r14, int r15, int r16, int r17, int r18, int r19, int r20) {
        r12.removeOnLayoutChangeListener(this);
        VoiceBubbleAreaUseCase.e(this.a, CollectionsKt.mutableListOf(new Integer[]{2131392773, 2131363256}), CollectionsKt.mutableListOf(new Integer[]{2131384022, 2131387916, 2131386396, 2131388751, 2131388770, 2131392750}));
        this.a.d.h().clearAnimation();
        this.a.d.s().b(this.a.h());
        if (this.b.isSecondVoiceInput() == false) goto L5;
        VoiceBubbleAreaUseCase r1 = this.a;
        r1.w.d(VoiceBubbleAreaUseCase.c(r1), this.c);
        return;
    L5:
        this.a.d.a().setEnabled(false);
        if (this.b.getImmersiveVoiceMode().b() == false) goto L17;
        VoiceBubbleMotionScene r2 = this.a.w;
        Intrinsics.checkNotNull(this.d);
        AppCompatTextView r3 = this.d;
        VoiceBubbleAreaUseCase r4 = this.a;
        VoiceBubbleMotionScene.a(r2, r3, r4.w.p, VoiceBubbleAreaUseCase.c(r4), this.c, this.e, -1, new VoiceBubbleAreaUseCase$initObserver$1$1$1$4$1(this.a));
        AppCompatTextView r5 = this.a.d.n();
        r5.setVisibility(0);
        Function1<Context, CharSequence> r6 = this.a.f().getOnlyAsrRecognizingTipsProvider();
        if (r6 == null) goto L10;
        Intrinsics.checkNotNull(this.f);
        CharSequence r7 = (CharSequence) r6.invoke(this.f);
    L11:
        if (r7 == null) goto L13;
    L16:
        r5.setText(r7);
        return;
    L13:
        if (this.g == false) goto L15;
        r7 = UIUtils.getString(this.f, 2131890989);
        goto L16
    L15:
        r7 = UIUtils.getString(this.f, 2131890972);
        goto L16
    L10:
        r7 = null;
        goto L11
    L17:
        VoiceBubbleMotionScene r8 = this.a.w;
        Intrinsics.checkNotNull(this.d);
        AppCompatTextView r9 = this.d;
        VoiceBubbleAreaUseCase r10 = this.a;
        VoiceBubbleMotionScene.a(r8, r9, r10.w.r, VoiceBubbleAreaUseCase.c(r10), this.c, this.e, 2131388763, new VoiceBubbleAreaUseCase$initObserver$1$1$1$4$3(this.a));
    }
}
