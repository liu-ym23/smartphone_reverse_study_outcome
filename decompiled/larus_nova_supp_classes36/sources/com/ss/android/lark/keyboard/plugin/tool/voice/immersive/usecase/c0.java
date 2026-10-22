package com.ss.android.lark.keyboard.plugin.tool.voice.immersive.usecase;

import androidx.lifecycle.Observer;
import com.ss.android.lark.utils.UIHelper;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c0<T> implements Observer {
    public final /* synthetic */ VoiceBubbleAreaUseCase a;

    public c0(VoiceBubbleAreaUseCase r1) {
        this.a = r1;
    }

    public final void onChanged(Object r10) {
        final com.ss.android.lark.keyboard.plugin.tool.voice.immersive.model.f r11 = (com.ss.android.lark.keyboard.plugin.tool.voice.immersive.model.f) r10;
        this.a.d.r().setVisibility(0);
        this.a.d.r().setText(StringsKt.replace$default(UIHelper.getString(2131890970), "{num}", "" + r11.a, false, 4, null));
        com.ss.android.lark.keyboard.plugin.tool.voice.immersive.animation.c r2 = new com.ss.android.lark.keyboard.plugin.tool.voice.immersive.animation.c(this.a.d.o());
        final VoiceBubbleAreaUseCase r0 = this.a;
        com.ss.android.lark.keyboard.plugin.tool.voice.immersive.animation.c.a(r2, r0.d.o(), new VoiceBubbleAreaUseCase$initObserver$1$8$1$1(r0, r11));
        com.ss.android.lark.keyboard.plugin.tool.voice.immersive.animation.c.c(r2, null, null, 0, null, 15);
    }
}
