package com.ss.android.lark.reaction.widget.panel;

import android.graphics.drawable.Drawable;
import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class e {
    public final String a;
    public final a b;
    public final int c;
    public final Drawable d;
    public boolean e;
    public b f;

    public interface a {
        void a(View r1);
    }

    public interface b {
        boolean a();

        boolean b();

        void onClick();

        void onHide();

        void onShow();

        void onViewCreated();
    }

    public e(String r2, int r3, a r4) {
        this.c = -1;
        this.d = null;
        this.e = true;
        this.a = r2;
        this.c = r3;
        this.b = r4;
    }

    public e(String r2, Drawable r3, a r4) {
        this.c = -1;
        this.d = null;
        this.e = true;
        this.a = r2;
        this.d = r3;
        this.b = r4;
    }
}
