package com.davemorrissey.labs.subscaleview.decoder;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.text.TextUtils;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.InputStream;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class SkiaImageDecoder implements ImageDecoder {
    private static final String ASSET_PREFIX = "file:///android_asset/";
    private static final String FILE_PREFIX = "file://";
    private static final String RESOURCE_PREFIX = "android.resource://";
    private final Bitmap.Config bitmapConfig;

    public SkiaImageDecoder() {
        this(null);
    }

    public SkiaImageDecoder(Bitmap.Config r2) {
        Bitmap.Config r0 = SubsamplingScaleImageView.getPreferredBitmapConfig();
        if (r2 == null) goto L5;
    L4:
        this.bitmapConfig = r2;
        return;
    L5:
        if (r0 == null) goto L7;
        this.bitmapConfig = r0;
        return;
    L7:
        r2 = Bitmap.Config.RGB_565;
        goto L4
    }

    @Override // com.davemorrissey.labs.subscaleview.decoder.ImageDecoder
    public Bitmap decode(Context r9, Uri r10) {
        Context r11 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin");
        String r0 = r10.toString();
        BitmapFactory.Options r2 = new BitmapFactory.Options();
        r2.inPreferredConfig = this.bitmapConfig;
        if (r0.startsWith(RESOURCE_PREFIX) == false) goto L18;
        String r8 = r10.getAuthority();
        if (r11.getPackageName().equals(r8) == false) goto L7;
        Resources r1 = ZeusTransformUtils.getResources(r11, "com.obric.memorydata.plugin");
    L8:
        List<String> r12 = r10.getPathSegments();
        int r3 = r12.size();
        int r6 = 0;
        if (r3 == 2) goto L11;
    L13:
        if (r3 == 1) goto L15;
    L17:
        Bitmap r13 = BitmapFactory.decodeResource(ZeusTransformUtils.getResources(r11, "com.obric.memorydata.plugin"), r6, r2);
    L29:
        if (r13 == null) goto L32;
        return r13;
    L32:
        throw new RuntimeException("Skia image region decoder returned null bitmap - image format may not be supported");
    L15:
        if (TextUtils.isDigitsOnly((CharSequence) ZeusTransformUtils.preCheckCast(r12.get(0), CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L17;
        r6 = Integer.parseInt((String) ZeusTransformUtils.preCheckCast(r12.get(0), String.class, "com.obric.memorydata.plugin"));     // Catch: NumberFormatException -> L39
        goto L17
    L11:
        if (((String) ZeusTransformUtils.preCheckCast(r12.get(0), String.class, "com.obric.memorydata.plugin")).equals("drawable") == false) goto L13;
        r6 = ZeusTransformUtils.getIdentifier(r1, (String) ZeusTransformUtils.preCheckCast(r12.get(1), String.class, "com.obric.memorydata.plugin"), "drawable", r8, "com.obric.memorydata.plugin");
        goto L17
    L7:
        r1 = r11.getPackageManager().getResourcesForApplication(r8);
        goto L8
    L18:
        InputStream r4 = null;
        if (r0.startsWith(ASSET_PREFIX) == false) goto L22;
        String r14 = r0.substring(22);
        r13 = BitmapFactory.decodeStream(r11.getAssets().open(r14), null, r2);
        goto L29
    L22:
        if (r0.startsWith(FILE_PREFIX) == false) goto L46;
        r13 = BitmapFactory.decodeFile(r0.substring(7), r2);
        goto L29
    L46:
        InputStream r15 = r11.getContentResolver().openInputStream(r10);     // Catch: Throwable -> L35
        Bitmap r16 = BitmapFactory.decodeStream(r15, null, r2);     // Catch: Throwable -> L33
        if (r15 != null) goto L48;
    L28:
        r13 = r16;
        goto L29
    L48:
        r15.close();     // Catch: Exception -> L40
    L33:
        th = th;
        r4 = r15;
    L36:
        if (r4 != null) goto L42;
    L38:
        throw th;
    L42:
        r4.close();     // Catch: Exception -> L41
    L35:
        th = th;
        goto L36
    }
}
