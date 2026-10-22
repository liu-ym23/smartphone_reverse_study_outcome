package com.lynx.animax.player;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import com.lynx.animax.base.AnimaXError;
import com.lynx.animax.service.IAnimaXMonitorService;
import com.lynx.animax.util.AnimaXLog;
import com.lynx.jsbridge.LynxResourceModule;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public abstract class a implements IVideoPlayer {
    public VideoAsset a;
    public SurfaceTexture b;
    public Surface c;
    public float[] d;
    public boolean e;
    public int f;
    public boolean g;
    public boolean h;
    public final g i;

    @Override // com.lynx.animax.player.IVideoPlayer
    public void destroy() {
        AnimaXLog.b("AbsVideoPlayer", "destroy: " + this);
        this.a = null;
        Surface r1 = this.c;
        if (r1 == null) goto L5;
        r1.release();
        this.c = null;
    L5:
        SurfaceTexture r2 = this.b;
        if (r2 == null) goto L9;
        r2.setOnFrameAvailableListener(null);
        this.b.release();
        this.b = null;
    L9:
        if (this.f <= 0) goto L13;
        b("[" + getClass().getName() + "]: Error has occurred, mHasDrewOnce: " + this.g + ", mHasDrewOnceAfterError: " + this.h);
        return;
    }

    @Override // com.lynx.animax.player.IVideoPlayer
    public final float[] getTransformMatrix() {
        if (this.d != null) goto L5;
        this.d = new float[]{1.0f, 0.0f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 1.0f};
    L5:
        SurfaceTexture r0 = this.b;
        if (r0 == null) goto L9;
        r0.getTransformMatrix(this.d);
    L9:
        return this.d;
    }

    public a(g r3) {
        this.e = false;
        this.f = 0;
        this.g = false;
        this.h = false;
        AnimaXLog.b("AbsVideoPlayer", "create: " + this);
        this.i = r3;
    }

    public final void a(String r3) {
        AnimaXLog.a("AbsVideoPlayer", "Error(" + this.f + "): " + r3);
    }

    @Override // com.lynx.animax.player.IVideoPlayer
    public void attachAsset(VideoAsset r3) {
        if (this.a == null) goto L6;
        AnimaXLog.a("AbsVideoPlayer", "Attach asset more than once");
        return;
    L6:
        if (r3 != null) goto L8;
    L12:
        AnimaXLog.a("AbsVideoPlayer", "attachAsset error: asset isn't valid");
        return;
    L8:
        if (r3.c == false) goto L12;
        this.a = r3;
    }

    public final void b(String r5) {
        a(r5);
        IAnimaXMonitorService r0 = (IAnimaXMonitorService) this.i.a.a(IAnimaXMonitorService.class);
        if (r0 != null) goto L5;
        return;
    L5:
        HashMap r1 = new HashMap();
        r1.put(LynxResourceModule.CODE_KEY, Integer.valueOf(AnimaXError.VIDEO_PLAYER_ERROR_HAS_OCCURRED.ordinal()));
        r1.put("msg", r5);
        r1.put("error_count", Integer.valueOf(this.f));
        r0.reportError(new t4a.a(r1));
    }

    @Override // com.lynx.animax.player.IVideoPlayer
    public void setSurface(int r3) {
        Surface r0 = this.c;
        if (r0 == null) goto L5;
        r0.release();
        this.c = null;
    L5:
        SurfaceTexture r1 = this.b;
        if (r1 == null) goto L8;
        r1.setOnFrameAvailableListener(null);
        this.b.release();
        this.b = null;
    L8:
        this.b = new SurfaceTexture(r3);
        this.c = new Surface(this.b);
    }
}
