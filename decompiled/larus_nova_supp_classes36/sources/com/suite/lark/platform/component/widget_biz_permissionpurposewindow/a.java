package com.suite.lark.platform.component.widget_biz_permissionpurposewindow;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.ss.android.lark.utils.k;
import com.ss.android.lark.utils.l;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;
import yoc.c;
import yoc.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a implements c, d {
    public final k a;
    public TextView b;
    public TextView c;
    public final long d;

    @Override // yoc.c
    public final void getPriority() {
    }

    @Override // yoc.c
    public int getType() {
        return 2131382181;
    }

    @Override // yoc.c
    public final String getId() {
        return String.valueOf(getType());
    }

    @Override // yoc.d
    public final long getDisplayDuration() {
        return this.d;
    }

    public a(l r3) {
        Intrinsics.checkNotNullParameter(r3, "purpose");
        this.a = r3;
        this.d = TimeUnit.SECONDS.toMillis(60);
    }

    @Override // yoc.c
    public final View createView(Context r6) {
        Intrinsics.checkNotNullParameter(r6, "context");
        TextView r1 = null;
        View r7 = LayoutInflater.from(r6).inflate(2131563386, null);
        this.b = (TextView) r7.findViewById(2131382183);
        this.c = (TextView) r7.findViewById(2131382182);
        boolean r3 = true;
        if (this.a.h() == 0) goto L9;
        TextView r0 = this.b;
        if (r0 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("titleTextView");
        r0 = null;
    L7:
        r0.setText(this.a.h());
    L18:
        if (this.a.b() == 0) goto L25;
        TextView r2 = this.c;
        if (r2 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("descTextView");
    L23:
        r1.setText(this.a.b());
    L34:
        Intrinsics.checkNotNull(r7);
        return r7;
    L22:
        r1 = r2;
        goto L23
    L25:
        if (this.a.d().length() > 0) goto L28;
        r3 = false;
    L28:
        if (r3 == false) goto L34;
        TextView r4 = this.c;
        if (r4 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("descTextView");
    L33:
        r1.setText(this.a.d());
        goto L34
    L32:
        r1 = r4;
        goto L33
    L9:
        if (this.a.g().length() <= 0) goto L11;
        boolean r5 = true;
    L12:
        if (r5 == false) goto L18;
        TextView r8 = this.b;
        if (r8 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("titleTextView");
        r8 = null;
    L16:
        r8.setText(this.a.g());
        goto L18
    L11:
        r5 = false;
        goto L12
    }
}
