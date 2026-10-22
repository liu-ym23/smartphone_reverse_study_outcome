package com.ss.android.lark.keyboard.editor;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class g implements zxa.b {
    public final /* synthetic */ d a;

    public final CharSequence b() {
        com.ss.android.lark.keyboard.plugin.tool.voice.audio2.i r0 = this.a.j;
        if (r0 == null) goto L6;
        CharSequence r1 = r0.b();
        if (r1 == null) goto L6;
        return r1;
    L6:
        return "";
    }

    public g(d r1) {
        this.a = r1;
    }

    public final void a(CharSequence r2) {
        com.ss.android.lark.keyboard.plugin.tool.voice.audio2.i r0 = this.a.j;
        if (r0 == null) goto L6;
        r0.a(r2);
        return;
    }
}
