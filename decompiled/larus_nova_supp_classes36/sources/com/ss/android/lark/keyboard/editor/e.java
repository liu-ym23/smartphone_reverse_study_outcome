package com.ss.android.lark.keyboard.editor;

import com.ss.android.lark.biz.im.api.extension.chat_window.ChatWindowKeyboard;
import com.ss.android.lark.keyboard.editor.input.BaseRichTextInputPlugin;
import java.util.Iterator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class e implements BaseRichTextInputPlugin.b {
    public final /* synthetic */ d a;

    @Override // com.ss.android.lark.keyboard.editor.input.BaseRichTextInputPlugin.b
    public final void onResume() {
        Iterator<ChatWindowKeyboard.a> r0 = this.a.f.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().f();
        goto L4
    }

    @Override // com.ss.android.lark.keyboard.editor.input.BaseRichTextInputPlugin.b
    public final void onStop() {
        Iterator<ChatWindowKeyboard.a> r0 = this.a.f.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().d();
        goto L4
    }

    public e(d r1) {
        this.a = r1;
    }
}
