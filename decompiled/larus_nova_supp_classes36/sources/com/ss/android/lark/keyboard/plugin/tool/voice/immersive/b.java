package com.ss.android.lark.keyboard.plugin.tool.voice.immersive;

import android.widget.EditText;
import kotlin.Pair;
import kotlin.TuplesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b implements com.ss.android.lark.keyboard.plugin.tool.voice.immersive.model.g {
    public final /* synthetic */ AsrInputVoiceView a;

    @Override // com.ss.android.lark.keyboard.plugin.tool.voice.immersive.model.g
    public final Pair<String, Integer> a() {
        EditText r0 = this.a.e.L().c();
        return TuplesKt.to(r0.getText().toString(), Integer.valueOf(r0.getSelectionEnd()));
    }

    public b(AsrInputVoiceView r1) {
        this.a = r1;
    }
}
