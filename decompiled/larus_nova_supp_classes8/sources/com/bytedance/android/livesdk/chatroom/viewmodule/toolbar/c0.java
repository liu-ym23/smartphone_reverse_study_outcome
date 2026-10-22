package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar;

import android.graphics.drawable.Drawable;
import android.view.View;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.Maybe;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public interface c0 {

    public interface a extends b {
        Maybe<Drawable> getIcon();

        Maybe<String> getTitle();
    }

    public interface b extends View.OnClickListener {
        void Bh(ToolbarButton r1);

        void Mr(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s r1);

        void R9(View r1, DataCenter r2);

        void SY(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s r1);

        void Y6();

        void dv(e r1);

        com.bytedance.android.livesdk.reddot.a h7();

        void onHide(boolean r1);

        void p4(View r1, DataCenter r2);

        void setAlpha(float r1);

        boolean showRedDot();
    }

    public static class c {
        public final ExtendedToolbarButton a;
        public final b b;
        public final boolean c;

        public c(ExtendedToolbarButton r1, b r2, boolean r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    public static class d {
        public final ExtendedToolbarButton a;
        public final boolean b;

        public d(ExtendedToolbarButton r1, boolean r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    void a(ToolbarButton r1, String r2);

    void b(ToolbarButton r1, e r2);

    void c(ExtendedToolbarButton r1);

    void d(ToolbarButton r1, b r2);

    void e(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s r1, b r2);

    void f(ExtendedToolbarButton r1, b r2);

    boolean g(ToolbarButton r1);

    void h(ExtendedToolbarButton r1);

    void i(ExtendedToolbarButton r1);

    String j(ToolbarButton r1);

    void k(ToolbarButton r1, b r2);

    void l(ExtendedToolbarButton r1, String r2);

    void m(com.bytedance.android.livesdk.chatroom.utils.c0 r1);

    boolean n(ToolbarButton r1);

    void o(ToolbarButton r1);

    void p(ExtendedToolbarButton r1, b r2);
}
