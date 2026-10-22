package com.lynx.animax.player;

import android.media.MediaExtractor;
import com.lynx.animax.util.AnimaXLog;
import java.io.IOException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class e {
    public static boolean a(MediaExtractor r1, String r2) {
        r1.setDataSource(r2);     // Catch: IOException -> L5
        return true;
    L5:
        e = move-exception;
        AnimaXLog.a("VideoAssetExtractor", "setDataSource IOException: " + e.getMessage());
        return false;
    }
}
