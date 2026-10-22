package com.lynx.canvas;

import android.graphics.SurfaceTexture;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public interface KryptonCamera {

    public static class Config {
        public static final String RESOLUTION_HIGH = "high";
        public static final String RESOLUTION_LOW = "low";
        public static final String RESOLUTION_MEDIUM = "medium";
        public boolean autoFocus;
        public String extraJson;
        public String faceMode;
        public String resolution;
        public CustomSize size;

        public Config() {
        }
    }

    public static class CustomSize {
        public int height;
        public int width;

        public CustomSize(int r1, int r2) {
            this.width = r1;
            this.height = r2;
        }
    }

    void focus();

    int getHeight();

    int getWidth();

    void pause();

    void play();

    void release();

    boolean requestWithConfig(Config r1);

    void setupPreviewTexture(SurfaceTexture r1);
}
