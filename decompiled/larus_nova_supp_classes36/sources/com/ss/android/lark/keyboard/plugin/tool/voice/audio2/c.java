package com.ss.android.lark.keyboard.plugin.tool.voice.audio2;

import com.ss.android.lark.biz.im.api.extension.keyboard.inputstate.AudioPanelType;
import com.ss.android.lark.keyboard.event.k;
import com.ss.android.lark.keyboard.plugin.tool.voice.immersive.g0;
import com.ss.android.lark.keyboard.plugin.tool.voice.utils.AudioPluginHelper;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c implements g0 {
    public final /* synthetic */ AudioKBPlugin a;

    @Override // com.ss.android.lark.keyboard.plugin.tool.voice.immersive.g0
    public final void a() {
        k.a.a(this.a.n().e(), AudioPanelType.OLD);
        ((AudioPluginHelper) this.a.s.getValue()).b();
    }

    public c(AudioKBPlugin r1) {
        this.a = r1;
    }
}
