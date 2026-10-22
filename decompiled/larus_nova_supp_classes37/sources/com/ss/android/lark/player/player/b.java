package com.ss.android.lark.player.player;

import android.os.Bundle;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public abstract class b {
    public int a;
    public n b;
    public m c;
    public l d;
    public int e;
    public a f;

    public interface a {
        void a(float r1, float r2);
    }

    public b() {
        this.a = 0;
    }

    public final void a(int r2, Bundle r3) {
        n r0 = this.b;
        if (r0 == null) goto L6;
        r0.a(r2, r3);
        return;
    }
}
