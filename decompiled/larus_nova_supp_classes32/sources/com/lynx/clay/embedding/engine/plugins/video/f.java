package com.lynx.clay.embedding.engine.plugins.video;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import com.lynx.clay.embedding.android.FlutterView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class f implements d {
    public final SurfaceTexture a;
    public Surface b;
    public a c;

    @Override // com.lynx.clay.embedding.engine.plugins.video.d
    public final int c() {
        return 1;
    }

    @Override // com.lynx.clay.embedding.engine.plugins.video.d
    public final void detach() {
        a r0 = this.c;
        if (r0 == null) goto L5;
        r0.setSurface(null);
        this.c = null;
    L5:
        Surface r1 = this.b;
        if (r1 == null) goto L9;
        r1.release();
        this.b = null;
        return;
    }

    @Override // com.lynx.clay.embedding.engine.plugins.video.d
    public final void dispose() {
        detach();
    }

    public f(SurfaceTexture r1) {
        this.a = r1;
    }

    @Override // com.lynx.clay.embedding.engine.plugins.video.d
    public final void a(FlutterView r2, a r3) {
        if (r2.getAttachedFlutterEngine() != null) goto L5;
        return;
    L5:
        this.c = r3;
        Surface r4 = new Surface(this.a);
        this.b = r4;
        r3.setSurface(r4);
        c5a.c.c("VideoRendererTexture", "attached to view");
    }

    @Override // com.lynx.clay.embedding.engine.plugins.video.d
    public final void b(int r1, int r2, int r3, int r4) {
        a r5 = this.c;
        if (r5 == null) goto L6;
        r5.e();
        return;
    }
}
