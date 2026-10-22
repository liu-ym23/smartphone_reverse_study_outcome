package com.ss.android.lark.keyboard.plugin.tool.voice.immersive.usecase;

import android.content.Context;
import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.lifecycle.LifecycleOwner;
import com.ss.android.lark.keyboard.plugin.tool.voice.immersive.model.ImmersiveVoiceViewModel;
import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class e0 implements View.OnLayoutChangeListener {
    public final /* synthetic */ ImmersiveVoiceViewModel a;
    public final /* synthetic */ LifecycleOwner b;
    public final /* synthetic */ AppCompatTextView c;
    public final /* synthetic */ VoiceBubbleAreaUseCase d;
    public final /* synthetic */ int e;
    public final /* synthetic */ Context f;
    public final /* synthetic */ ArrayList g;
    public final /* synthetic */ int h;

    public e0(ImmersiveVoiceViewModel r1, LifecycleOwner r2, AppCompatTextView r3, VoiceBubbleAreaUseCase r4, int r5, Context r6, ArrayList r7, int r8) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r8;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View r12, int r13, int r14, int r15, int r16, int r17, int r18, int r19, int r20) {
        r12.removeOnLayoutChangeListener(this);
        this.a.getImmersiveVoiceState().observe(this.b, new p(this.c, this.d, this.e, this.f, this.a, this.g, this.h));
    }
}
