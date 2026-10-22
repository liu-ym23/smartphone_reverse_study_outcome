package com.ss.android.lark.flow.chat.message.block.audio;

import com.ss.android.lark.audio.f;
import com.ss.android.lark.audio.opus.e;
import com.ss.android.lark.chat.base.view.vo.message.AudioContentVO;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a implements f.c {
    public final /* synthetic */ AudioContentVO a;
    public final /* synthetic */ FlowAudioContentBlock.AudioPlayCallbackHandler b;
    public final /* synthetic */ y6b.a<AudioContentVO> c;

    public final int getAudioDuration() {
        return this.a.g();
    }

    public final String getMsgId() {
        return this.c.getId();
    }

    public final int getProgress() {
        return this.a.u;
    }

    public final String n() {
        return this.a.t;
    }

    public final e.a m() {
        return this.b;
    }

    public a(AudioContentVO r1, FlowAudioContentBlock.AudioPlayCallbackHandler r2, y6b.a<AudioContentVO> r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
