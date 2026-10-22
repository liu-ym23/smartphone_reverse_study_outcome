package com.ss.android.lark.imagewidget.subsampling.decoder;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.security.android.aopcheck.ContentResolverWrapper;
import com.ss.android.lark.imagewidget.subsampling.SubsamplingScaleImageView;
import com.ss.android.lark.log.Log;
import java.io.InputStream;
import java.util.List;
import rlb.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class SkiaImageDecoder implements c {
    private static final String ASSET_PREFIX = "file:///android_asset/";
    private static final String FILE_PREFIX = "file://";
    private static final String RESOURCE_PREFIX = "android.resource://";
    private static final String TAG = "SkiaImageDecoder";
    private final Bitmap.Config bitmapConfig;

    public SkiaImageDecoder() {
        this(null);
    }

    public SkiaImageDecoder(Bitmap.Config r2) {
        Bitmap.Config r0 = SubsamplingScaleImageView.getPreferredBitmapConfig();
        if (r2 == null) goto L5;
        this.bitmapConfig = r2;
        return;
    L5:
        if (r0 == null) goto L7;
        this.bitmapConfig = r0;
        return;
    L7:
        this.bitmapConfig = Bitmap.Config.ARGB_8888;
    }

    @Override // rlb.c
    public Bitmap decode(Context r9, Uri r10) throws Exception {
        String r0 = r10.toString();
        BitmapFactory.Options r1 = new BitmapFactory.Options();
        r1.inPreferredConfig = this.bitmapConfig;
        if (r0.startsWith(RESOURCE_PREFIX) == false) goto L18;
        String r2 = r10.getAuthority();
        if (r9.getPackageName().equals(r2) == false) goto L7;
        Resources r3 = r9.getResources();
    L8:
        List<String> r11 = r10.getPathSegments();
        int r4 = r11.size();
        int r6 = 0;
        if (r4 == 2) goto L11;
    L13:
        if (r4 == 1) goto L15;
    L17:
        Bitmap r12 = BitmapFactory.decodeResource(r9.getResources(), r6, r1);
    L31:
        if (r12 == null) goto L33;
        return r12;
    L33:
        Log.e(TAG, "Skia image region decoder returned null bitmap - image format may not be supported");
        throw new RuntimeException("Skia image region decoder returned null bitmap - image format may not be supported");
    L15:
        if (TextUtils.isDigitsOnly((CharSequence) ListProtector.get(r11, 0)) == false) goto L17;
        r6 = CastIntegerProtector.parseInt((String) ListProtector.get(r11, 0));     // Catch: NumberFormatException -> L41
        goto L17
    L11:
        if (((String) ListProtector.get(r11, 0)).equals("drawable") == false) goto L13;
        r6 = r3.getIdentifier((String) ListProtector.get(r11, 1), "drawable", r2);
        goto L17
    L7:
        r3 = r9.getPackageManager().getResourcesForApplication(r2);
        goto L8
    L18:
        InputStream r5 = null;
        if (r0.startsWith(ASSET_PREFIX) == false) goto L22;
        String r13 = r0.substring(22);
        r12 = BitmapFactory.decodeStream(r9.getAssets().open(r13), null, r1);
        goto L31
    L22:
        if (r0.startsWith("file://") == false) goto L49;
        r12 = BitmapFactory.decodeFile(r0.substring(7), r1);
        goto L31
    L49:
        InputStream r14 = ContentResolverWrapper.openInputStream(r9.getContentResolver(), r10);     // Catch: Throwable -> L37
        Bitmap r15 = BitmapFactory.decodeStream(r14, null, r1);     // Catch: Throwable -> L35
        if (r14 != null) goto L43;
    L30:
        r12 = r15;
        goto L31
    L43:
        r14.close();     // Catch: Exception -> L29
    L35:
        th = th;
        r5 = r14;
    L38:
        if (r5 != null) goto L51;
    L40:
        throw th;
    L51:
        r5.close();     // Catch: Exception -> L42
    L37:
        th = th;
        goto L38
    }
}
