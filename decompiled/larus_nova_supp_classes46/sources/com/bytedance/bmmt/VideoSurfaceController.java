package com.bytedance.bmmt;

import android.view.Surface;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public class VideoSurfaceController {
    private static VideoSurfaceController instance;
    private BmmtSurfaceListener mSurfaceLisener;
    private boolean usePassSurfaceMode;

    public interface BmmtSurfaceListener {
        void onSurfaceAvailable(Surface r1);
    }

    static {
        instance = new VideoSurfaceController();
    }

    private VideoSurfaceController() {
        this.usePassSurfaceMode = false;
        this.mSurfaceLisener = null;
    }

    public static VideoSurfaceController getInstance() {
        return instance;
    }

    public boolean usePassSurfaceMode() {
        return this.usePassSurfaceMode;
    }

    public void setSurface(Surface r2) {
        BmmtSurfaceListener r0 = this.mSurfaceLisener;
        if (r0 == null) goto L6;
        r0.onSurfaceAvailable(r2);
        return;
    }
}
