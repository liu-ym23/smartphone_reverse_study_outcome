package com.ss.android.lark.keyboard.plugin.tool.voice.immersive.usecase;

import android.content.Context;
import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import com.ss.android.lark.audio.voiceinput.VoiceInputScene;
import com.ss.android.lark.keyboard.plugin.tool.voice.immersive.animation.VoiceBubbleMotionScene;
import com.ss.android.lark.keyboard.plugin.tool.voice.immersive.model.ImmersiveVoiceViewModel;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class l implements View.OnLayoutChangeListener {
    public final /* synthetic */ VoiceBubbleAreaUseCase a;
    public final /* synthetic */ AppCompatTextView b;
    public final /* synthetic */ int c;
    public final /* synthetic */ int d;
    public final /* synthetic */ ImmersiveVoiceViewModel e;
    public final /* synthetic */ Context f;

    public l(VoiceBubbleAreaUseCase r1, AppCompatTextView r2, int r3, int r4, ImmersiveVoiceViewModel r5, Context r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View r12, int r13, int r14, int r15, int r16, int r17, int r18, int r19, int r20) {
        r12.removeOnLayoutChangeListener(this);
        boolean r2 = true;
        VoiceBubbleAreaUseCase.e(this.a, CollectionsKt.mutableListOf(new Integer[]{2131392773}), CollectionsKt.mutableListOf(new Integer[]{2131384022, 2131387916, 2131386396, 2131388751, 2131388770, 2131363256, 2131392750}));
        VoiceBubbleMotionScene r1 = this.a.w;
        Intrinsics.checkNotNull(this.b);
        AppCompatTextView r3 = this.b;
        VoiceBubbleAreaUseCase r4 = this.a;
        VoiceBubbleMotionScene.c(r1, r3, r4.w.p, VoiceBubbleAreaUseCase.b(r4), VoiceBubbleAreaUseCase.d(this.a), this.c, this.d, 2131388764);
        AppCompatTextView r5 = this.a.d.n();
        if (this.e.getImmersiveVoiceMode().b == VoiceInputScene.SecretChat) goto L6;
        r2 = false;
    L6:
        if (r2 == false) goto L8;
        String r6 = this.f.getString(2131890416);
    L9:
        r5.setText(r6);
        return;
    L8:
        r6 = this.f.getString(2131890973);
        goto L9
    }
}
