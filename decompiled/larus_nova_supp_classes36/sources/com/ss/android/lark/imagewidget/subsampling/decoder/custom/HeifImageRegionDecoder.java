package com.ss.android.lark.imagewidget.subsampling.decoder.custom;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.net.Uri;
import com.bumptech.glide.integration.heif.bean.Heif;
import com.bumptech.glide.integration.heif.bean.HeifData;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.vfs.VFSFiles;
import java.io.Closeable;
import java.io.InputStream;
import rlb.d;
import skb.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class HeifImageRegionDecoder implements d {
    private static final String ASSET_PREFIX = "file:///android_asset/";
    private static final String FILE_PREFIX = "file://";
    private static final String TAG = "HeifImageRegionDecoder";
    private byte[] data;

    public HeifImageRegionDecoder() {
    }

    @Override // rlb.d
    public void recycle() {
        this.data = null;
    }

    @Override // rlb.d
    public boolean isReady() {
        if (this.data == null) goto L5;
        return true;
    L5:
        return false;
    }

    private byte[] readUri(String r9) {
        Closeable r1 = null;
        byte[] r2 = null;
        if (r9 != null) goto L33;
        return null;
    L33:
    L22:
        e = e;
        Closeable r4 = null;
    L31:
        Log.e(TAG, "readUri failed:" + e.toString());     // Catch: Throwable -> L27
        com.larksuite.framework.utils.d.b(new Closeable[]{r4});
    L26:
        return r2;
    L27:
        th = th;
        r1 = r4;
    L29:
        com.larksuite.framework.utils.d.b(new Closeable[]{r1});
        throw th;
    L20:
        th = th;
        goto L29
    L7:
        if (r9.startsWith(ASSET_PREFIX) == false) goto L10;
        InputStream r10 = LarkContext.getApplication().getAssets().open(r9.substring(22), 1);     // Catch: Throwable -> L20 Exception -> L22
    L34:
        r2 = a.b(r10);     // Catch: Throwable -> L16 Exception -> L18
        com.larksuite.framework.utils.d.b(new Closeable[]{r10});
        goto L26
    L18:
        e = move-exception;
        r4 = r10;
        e = e;
    L16:
        th = move-exception;
        r1 = r10;
        th = th;
        goto L29
    L10:
        if (r9.startsWith("file://") == false) goto L13;
        r10 = VFSFiles.b.k(r9.substring(7));     // Catch: Throwable -> L20 Exception -> L22
        goto L34
    L13:
        r10 = null;
        goto L34
    }

    @Override // rlb.d
    public Bitmap decodeRegion(Rect r11, int r12) {
        Log.i(TAG, "decodeRegion" + r12);
        byte[] r2 = this.data;
        Bitmap r0 = null;
        if (r2 != null) goto L5;
    L11:
        if (r0 == null) goto L15;
        Log.i(TAG, "size:" + ((r0.getByteCount() / 1024) / 1024));
        return r0;
    L15:
        throw new RuntimeException("decode heif region failed");
    L5:
        if (r12 >= 1) goto L7;
        int r5 = 1;
    L8:
        HeifData r13 = Heif.toRgba(r2, r2.length, false, r5, r11.left, r11.top, r11.height(), r11.width());
        if (r13 == null) goto L11;
        r0 = r13.newBitmap(null);
        goto L11
    L7:
        r5 = r12;
        goto L8
    }

    @Override // rlb.d
    public Point init(Context r3, Uri r4) throws Exception {
        byte[] r5 = readUri(r4.toString());
        this.data = r5;
        if (r5 == null) goto L11;
        int[] r6 = Heif.parseSimpleMeta(r5, r5.length);
        if (r6 == null) goto L11;
        if (r6.length < 2) goto L11;
        return new Point(r6[0], r6[1]);
    L11:
        throw new RuntimeException("parse heif meta failed");
    }
}
