package com.ss.android.lark.compose.foundation.toast;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.view.View;
import android.widget.Toast;
import com.larksuite.component.universe_design.icon.UDIconUtils;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class f extends Toast implements g {
    public final i a;

    public static final class a {
    }

    static {
    }

    @Override // android.widget.Toast
    public final void show() {
        int r0 = h.a;
        Intrinsics.checkNotNullParameter(this, "toast");
        boolean r2 = false;
        if (Build.VERSION.SDK_INT != 25) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == true) goto L26;
    L24:
        this.a.b();
        super.show();
        return;
    L26:
        Object r3 = h.a(this, "mTN");     // Catch: Throwable -> L22
        if (r3 == null) goto L24;
        Object r4 = h.a(r3, "mShow");     // Catch: Throwable -> L22
        if (r4 != null) goto L13;
    L15:
        if (r2 == true) goto L24;
        Object r5 = h.a(r3, "mHandler");     // Catch: Throwable -> L22
        if (r5 == null) goto L24;
        if ((r5 instanceof Handler) == false) goto L24;
        h.b(r5, "mCallback", new h.a((Handler) r5));     // Catch: Throwable -> L22
        goto L24
    L13:
        if ((r4 instanceof Runnable) == false) goto L15;
        r2 = h.b(r3, "mShow", new h.b((Runnable) r4));     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        th.printStackTrace();
        goto L24
    L5:
        r1 = false;
        goto L6
    }

    public final boolean isShowing() {
        View r0 = getView();
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.isAttachedToWindow();
    }

    @Override // android.widget.Toast
    public final void cancel() {
        super.cancel();
    }

    public f(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3);
        i r0 = new i(r3);
        this.a = r0;
        setView(r0.b.a);
        setGravity(48, 0, (int) h18.d.b(r3, 100));
    }

    public final void setIcon(int r3) {
        i r0 = this.a;
        r0.a(UDIconUtils.getIconDrawable(r0.a, r3));
    }

    @Override // android.widget.Toast
    public final void setText(int r3) {
        i r0 = this.a;
        String r4 = r0.a.getString(r3);
        Intrinsics.checkNotNullParameter(r4, "s");
        r0.b.e.setText(r4);
    }

    public final void setIcon(Drawable r2) {
        Intrinsics.checkNotNullParameter(r2, "drawable");
        this.a.a(r2);
    }

    @Override // android.widget.Toast
    public final void setText(CharSequence r3) {
        Intrinsics.checkNotNullParameter(r3, "s");
        i r1 = this.a;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r3, "s");
        r1.b.e.setText(r3);
    }
}
