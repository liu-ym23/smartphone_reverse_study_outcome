package com.lynx.clay.embedding.android;

import android.graphics.Bitmap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class Screenshot {
    private static Screenshot instance;
    public a mListener;

    public static abstract class a {
    }

    public void SetScreenshotListener(a r1) {
    }

    static {
        instance = new Screenshot();
    }

    public Screenshot() {
    }

    public static Screenshot getInstance() {
        return instance;
    }

    private static void ScreenshotCallback(Bitmap r0) {
        getInstance().getClass();
    }
}
