package com.ss.android.lark.keyboard.keyboard2;

import com.ss.android.lark.keyboard.editor.input.interceptor.ChatEditorMenuLayoutManager;
import com.ss.android.lark.keyboard.plugin.tool.voice.audio2.AudioKBPlugin;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public interface d extends c {
    public static final a N1 = null;

    public static final class a implements c.a<d> {
        public static final /* synthetic */ a a = null;

        static {
            a = new a();
        }

        public a() {
        }
    }

    static {
        N1 = a.a;
    }

    void C(ChatEditorMenuLayoutManager.b r1);

    void G(m r1);

    void M(e r1);

    void f(KeyboardMenuItemKey r1);

    boolean h();

    <T extends m> T i(KeyboardMenuItemKey r1, Class<T> r2);

    m k();

    void m();

    void q(g.a.C0152a r1);

    boolean w(KeyboardMenuItemKey r1);

    void x(AudioKBPlugin r1);
}
