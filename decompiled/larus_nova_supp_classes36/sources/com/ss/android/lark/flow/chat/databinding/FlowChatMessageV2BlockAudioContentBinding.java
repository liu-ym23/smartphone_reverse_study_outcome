package com.ss.android.lark.flow.chat.databinding;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.ss.android.lark.flow.chat.message.block.audio.FlowAudioLoadingDotsView;
import com.ss.android.lark.flow.chat.message.block.audio.FlowAudioPlayBar;
import com.ss.android.lark.widget.light.LKUILightTextView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class FlowChatMessageV2BlockAudioContentBinding implements ViewBinding {
    public final ConstraintLayout a;
    public final FlowAudioLoadingDotsView b;
    public final View c;
    public final FlowAudioPlayBar d;
    public final LKUILightTextView e;

    public final View getRoot() {
        return this.a;
    }

    public FlowChatMessageV2BlockAudioContentBinding(ConstraintLayout r1, FlowAudioLoadingDotsView r2, View r3, FlowAudioPlayBar r4, LKUILightTextView r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }
}
