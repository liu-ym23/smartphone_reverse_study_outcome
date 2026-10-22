package com.larus.voice_setting.voice.editvoice;

import com.google.android.material.appbar.AppBarLayout;
import com.larus.im.bean.bot.MixVoice;
import com.larus.im.bean.bot.SpeakerVoice;
import com.larus.voice_setting.impl.databinding.LarusTtsSpeakerContentNewStyleBinding;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class k0 implements v2a.d {
    public final /* synthetic */ j0 a;

    @Override // v2a.d
    public final void b(SpeakerVoice r1, Integer r2) {
    }

    @Override // v2a.d
    public final void c(SpeakerVoice r1) {
    }

    @Override // v2a.d
    public final void a() {
        LarusTtsSpeakerContentNewStyleBinding r0 = this.a.c;
        if (r0 == null) goto L8;
        AppBarLayout r1 = r0.b;
        if (r1 == null) goto L9;
        r1.setExpanded(false);
        return;
    L9:
        return;
    }

    public k0(j0 r1) {
        this.a = r1;
    }

    @Override // v2a.d
    public final void d(SpeakerVoice r3) {
        this.a.c("audition", r3);
    }

    @Override // v2a.d
    public final void e(MixVoice r4) {
        Intrinsics.checkNotNullParameter(r4, "item");
        SpeakerVoiceEditModel r0 = this.a.d;
        if (r0 == null) goto L5;
        int r1 = SpeakerVoiceEditModel.P;
        r0.q(null, false);
    L5:
        this.a.c("delete_voice", r4.getVoiceItem());
    }
}
