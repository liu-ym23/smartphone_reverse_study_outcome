package com.ss.android.lark.keyboard.plugin.tool.voice.audio2;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import z5c.e4;
import z5c.r;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
final class AudioPluginController$showAIPanel$1 extends Lambda implements Function1<String, Unit> {
    final /* synthetic */ String $text;
    final /* synthetic */ h this$0;

    public AudioPluginController$showAIPanel$1(h r1, String r2) {
        this.this$0 = r1;
        this.$text = r2;
        super(1);
    }

    public final void invoke(String r8) {
        int r9 = com.ss.android.lark.keyboard.plugin.tool.voice.audio2.utils.b.a;
        String r10 = this.this$0.f();
        if (this.$text.length() <= 0) goto L5;
        boolean r0 = true;
    L6:
        Intrinsics.checkNotNullParameter(r10, "sourceId");
        com.ss.android.lark.keyboard.plugin.tool.voice.audio2.utils.b.a("im_chat_voice_msg_click", new Pair[]{new Pair("click", r.N2.b), new Pair("view_type", e4.d.b), new Pair("source_id", r10), new Pair("is_recognized", Boolean.valueOf(r0))});
        int r11 = com.ss.android.lark.keyboard.plugin.tool.voice.audio2.utils.c.a;
        this.this$0.getClass();
        throw null;
    L5:
        r0 = false;
        goto L6
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((String) r1);
        return Unit.INSTANCE;
    }
}
