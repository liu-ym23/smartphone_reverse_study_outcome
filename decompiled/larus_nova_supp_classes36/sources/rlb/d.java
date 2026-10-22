package rlb;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.net.Uri;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public interface d {
    Bitmap decodeRegion(Rect r1, int r2);

    Point init(Context r1, Uri r2) throws Exception;

    boolean isReady();

    void recycle();
}
