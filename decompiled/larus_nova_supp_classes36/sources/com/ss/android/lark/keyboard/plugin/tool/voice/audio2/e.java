package com.ss.android.lark.keyboard.plugin.tool.voice.audio2;

import com.ss.android.lark.keyboard.plugin.tool.voice.KeyboardVoiceFGUtils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class e implements i {
    public final /* synthetic */ AudioKBPlugin a;

    @Override // com.ss.android.lark.keyboard.plugin.tool.voice.audio2.i
    public final CharSequence b() {
        if (this.a.K() == false) goto L7;
        KeyboardVoiceFGUtils.a("im.messenger.advance_mode_refactor", null);
        return "";
    L7:
        return "";
    }

    public e(AudioKBPlugin r1) {
        this.a = r1;
    }

    @Override // com.ss.android.lark.keyboard.plugin.tool.voice.audio2.i
    public final void a(CharSequence r2) {
        if (KeyboardVoiceFGUtils.a("im.messenger.advance_mode_refactor", null) == false) goto L5;
        this.a.getClass();
        return;
    L5:
        this.a.getClass();
    }
}
