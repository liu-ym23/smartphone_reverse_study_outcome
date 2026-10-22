package com.ss.android.lark.keyboard.plugin.tool.voice.immersive.usecase;

import android.view.View;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class i0 implements View.OnClickListener {
    public final /* synthetic */ VoiceBubbleAreaUseCase a;

    public i0(VoiceBubbleAreaUseCase r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r6) {
        sob.d r7 = sob.d.a;
        String r0 = this.a.f().currentChatId$keyboard_biz_voice_release();
        String r1 = this.a.f().getCurrentRecordSourceId();
        String r2 = this.a.f().currentHitPointScene$keyboard_biz_voice_release();
        r7.getClass();
        Intrinsics.checkNotNullParameter(r0, "chatId");
        Intrinsics.checkNotNullParameter(r1, "sourceId");
        Intrinsics.checkNotNullParameter(r2, "scene");
        sob.d.f("im_voice_input_click", new Pair[]{new Pair("chat_id", r0), new Pair("source_id", r1), new Pair("click", "click_origin_words"), new Pair("location", "im_input_button"), new Pair("voice_input_scene", r2)});
        this.a.f().onShowOriginal();
    }
}
