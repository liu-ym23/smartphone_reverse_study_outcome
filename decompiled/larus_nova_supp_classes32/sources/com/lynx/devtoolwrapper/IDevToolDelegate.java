package com.lynx.devtoolwrapper;

import android.graphics.Bitmap;
import com.lynx.react.bridge.ReadableMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public interface IDevToolDelegate {
    String getActualScreenshotMode();

    Bitmap getBitmapOfView();

    int getNodeForLocation(float r1, float r2, String r3);

    float[] getTransformValue(int r1, float[] r2);

    void onDispatchMessageEvent(ReadableMap r1);

    void scrollIntoViewFromUI(int r1);

    void takeScreenshot(ScreenshotBitmapHandler r1, String r2);
}
