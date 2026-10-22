package com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block;

import com.ss.android.lark.chat.base.view.vo.message.AudioContentVO;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class c implements com.ss.android.lark.audio.f.c {
    public final /* synthetic */ AudioContentVO a;
    public final /* synthetic */ AudioContentBlock b;
    public final /* synthetic */ n2b.d c;
    public final /* synthetic */ y6b.a<AudioContentVO> d;

    public final int getAudioDuration() {
        return this.a.g();
    }

    public final String getMsgId() {
        return this.d.getId();
    }

    public final int getProgress() {
        return this.a.u;
    }

    public final com.ss.android.lark.audio.opus.e.a m() {
        return new AudioContentBlock.AudioPlayCallbackHandler(this.b.k, this.c.a.n, this.d.getId());
    }

    public final String n() {
        return this.a.t;
    }

    public c(AudioContentVO r1, AudioContentBlock r2, n2b.d r3, y6b.a<AudioContentVO> r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
