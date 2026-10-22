package com.ss.android.lark.keyboard.plugin.tool.voice.immersive;

import androidx.lifecycle.Observer;
import com.ss.android.lark.keyboard.plugin.tool.voice.immersive.model.ImmersiveVoiceViewModel;
import com.ss.android.lark.log.Log;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class g<T> implements Observer {
    public final /* synthetic */ AsrInputVoiceView a;
    public final /* synthetic */ ImmersiveVoiceViewModel b;

    public g(AsrInputVoiceView r1, ImmersiveVoiceViewModel r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void onChanged(Object r2) {
        if (((Boolean) r2).booleanValue() == false) goto L6;
        Log.i("AsrInputVoiceView", "RecordHardWareReady");
        AsrInputVoiceView r3 = this.a;
        r3.r.removeCallbacks(r3.D);
        AsrInputVoiceView r4 = this.a;
        r4.r.post(r4.E);
        AsrInputVoiceView r5 = this.a;
        r5.f7(AsrInputVoiceView.o6(r5));
        this.b.updateVoiceStateIfNeed(new com.ss.android.lark.keyboard.plugin.tool.voice.immersive.model.m());
        return;
    }
}
