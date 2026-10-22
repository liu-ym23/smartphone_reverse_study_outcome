package com.ss.android.lark.keyboard.component;

import com.ss.android.lark.chat.chatwindow.biz.component.keyboard.BaseKeyboardComponentV2;
import com.ss.android.lark.keyboard.keyboard2.KeyboardMenuItemKey;
import com.ss.android.lark.keyboard.keyboard2.d;
import com.ss.android.lark.keyboard.plugin.tool.voice.audio2.AudioKBPlugin;
import com.ss.android.lark.keyboard.plugin.tool.voice.audio2.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a implements zxa.b {
    public final /* synthetic */ FlowKeyboardComponent a;

    public final CharSequence b() {
        FlowKeyboardComponent r0 = this.a;
        int r1 = FlowKeyboardComponent.A;
        com.ss.android.lark.keyboard.b r2 = ((BaseKeyboardComponentV2) r0).n;
        if (r2 == null) goto L13;
        d r3 = r2.H();
        if (r3 == null) goto L13;
        AudioKBPlugin r4 = (AudioKBPlugin) r3.i(KeyboardMenuItemKey.Voice, AudioKBPlugin.class);
        if (r4 == null) goto L13;
        e r5 = r4.u;
        if (r5 == null) goto L13;
        CharSequence r6 = r5.b();
        if (r6 == null) goto L13;
        return r6;
    L13:
        return "";
    }

    public a(FlowKeyboardComponent r1) {
        this.a = r1;
    }

    public final void a(CharSequence r4) {
        FlowKeyboardComponent r0 = this.a;
        int r1 = FlowKeyboardComponent.A;
        com.ss.android.lark.keyboard.b r2 = ((BaseKeyboardComponentV2) r0).n;
        if (r2 == null) goto L12;
        d r3 = r2.H();
        if (r3 == null) goto L13;
        AudioKBPlugin r5 = (AudioKBPlugin) r3.i(KeyboardMenuItemKey.Voice, AudioKBPlugin.class);
        if (r5 == null) goto L14;
        e r6 = r5.u;
        if (r6 == null) goto L15;
        r6.a(r4);
        return;
    L15:
        return;
    L14:
        return;
    L13:
        return;
    }
}
