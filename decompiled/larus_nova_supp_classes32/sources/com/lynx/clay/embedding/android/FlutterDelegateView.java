package com.lynx.clay.embedding.android;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.lynx.clay.embedding.engine.renderer.FlutterRenderer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class FlutterDelegateView extends View implements s5a.c {
    public boolean a;
    public FlutterRenderer b;

    @Override // s5a.c
    public final void b() {
        FlutterRenderer r0 = this.b;
        if (r0 == null) goto L5;
        r0.b(false);
        this.b = null;
        return;
    L5:
        c5a.c.d(5, "FlutterDelegateView", "detachFromRenderer() invoked when no FlutterRenderer was attached.");
    }

    @Override // s5a.c
    public final void pause() {
        if (this.b == null) goto L5;
        this.b = null;
        return;
    L5:
        c5a.c.d(5, "FlutterDelegateView", "pause() invoked when no FlutterRenderer was attached.");
    }

    @Override // s5a.c
    public FlutterRenderer getAttachedRenderer() {
        return this.b;
    }

    public FlutterDelegateView(Context r2) {
        this(r2, null);
    }

    @Override // s5a.c
    public final void a(FlutterRenderer r3) {
        c5a.c.e();
        if (this.b == null) goto L5;
        c5a.c.e();
        this.b.b(false);
    L5:
        this.b = r3;
        if (this.a == true) goto L9;
        return;
    L9:
        throw null;
    }

    public FlutterDelegateView(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.a = false;
    }
}
