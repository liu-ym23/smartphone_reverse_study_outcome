package com.ss.android.lark.keyboard.editor.input;

import com.ss.android.lark.keyboard.keyboard2.KeyboardMenuItemKey;
import com.ss.android.lark.keyboard.plugin.tool.voice.audio2.AudioKBPlugin;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a implements com.ss.android.lark.keyboard.plugin.tool.voice.audio2.i {
    public final /* synthetic */ BaseRichTextInputPlugin a;

    @Override // com.ss.android.lark.keyboard.plugin.tool.voice.audio2.i
    public final CharSequence b() {
        BaseRichTextInputPlugin r0 = this.a;
        if (r0.F == null) goto L13;
        AudioKBPlugin r1 = (AudioKBPlugin) r0.V().H().i(KeyboardMenuItemKey.Voice, AudioKBPlugin.class);
        if (r1 == null) goto L14;
        com.ss.android.lark.keyboard.plugin.tool.voice.audio2.e r2 = r1.u;
        if (r2 == null) goto L15;
        CharSequence r3 = r2.b();
        if (r3 != null) goto L12;
        return "";
    L12:
        return r3;
    L15:
        return "";
    L14:
        return "";
    L13:
        return "";
    }

    public a(BaseRichTextInputPlugin r1) {
        this.a = r1;
    }

    @Override // com.ss.android.lark.keyboard.plugin.tool.voice.audio2.i
    public final void a(CharSequence r4) {
        BaseRichTextInputPlugin r0 = this.a;
        if (r0.F == null) goto L10;
        AudioKBPlugin r1 = (AudioKBPlugin) r0.V().H().i(KeyboardMenuItemKey.Voice, AudioKBPlugin.class);
        if (r1 == null) goto L11;
        com.ss.android.lark.keyboard.plugin.tool.voice.audio2.e r2 = r1.u;
        if (r2 == null) goto L12;
        r2.a(r4);
        return;
    L12:
        return;
    L11:
        return;
    }
}
