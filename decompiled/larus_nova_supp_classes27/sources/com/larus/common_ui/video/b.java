package com.larus.common_ui.video;

import android.view.View;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class b {
    public int a;
    public int b;
    public int c;
    public FrameLayout d;
    public View e;
    public final com.larus.common_ui.video.a f;

    public static final class a {
    }

    static {
    }

    public final void a() {
        View r0 = this.e;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.removeCallbacks(this.f);
        View r1 = this.e;
        if (r1 == null) goto L9;
        r1.postOnAnimation(this.f);
        return;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.larus.common_ui.video.a] */
    public b() {
        this.f = new com.larus.common_ui.video.a(this);
    }
}
