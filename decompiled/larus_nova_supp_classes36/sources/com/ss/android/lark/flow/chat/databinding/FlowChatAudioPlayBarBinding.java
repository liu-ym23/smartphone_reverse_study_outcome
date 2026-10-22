package com.ss.android.lark.flow.chat.databinding;

import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.ss.android.lark.flow.chat.message.block.audio.FlowAudioWaveView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class FlowChatAudioPlayBarBinding implements ViewBinding {
    public final View a;
    public final CheckBox b;
    public final TextView c;
    public final FlowAudioWaveView d;

    public final View getRoot() {
        return this.a;
    }

    public FlowChatAudioPlayBarBinding(View r1, CheckBox r2, TextView r3, FlowAudioWaveView r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
