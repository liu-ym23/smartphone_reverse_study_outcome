package com.davemorrissey.labs.subscaleview;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.net.Uri;
import com.bytedance.rpc.internal.RpcUtils;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class ImageSource {
    static final String ASSET_SCHEME = "file:///android_asset/";
    static final String FILE_SCHEME = "file:///";
    private final Bitmap bitmap;
    private boolean cached;
    private final Integer resource;
    private int sHeight;
    private Rect sRegion;
    private int sWidth;
    private boolean tile;
    private final Uri uri;

    private ImageSource(int r2) {
        this.bitmap = null;
        this.uri = null;
        this.resource = Integer.valueOf(r2);
        this.tile = true;
    }

    private ImageSource(Bitmap r2, boolean r3) {
        this.bitmap = r2;
        this.uri = null;
        this.resource = null;
        this.tile = false;
        this.sWidth = r2.getWidth();
        this.sHeight = r2.getHeight();
        this.cached = r3;
    }

    private ImageSource(Uri r4) {
        String r0 = r4.toString();
        if (r0.startsWith(FILE_SCHEME) == true) goto L5;
    L7:
        this.bitmap = null;
        this.uri = r4;
        this.resource = null;
        this.tile = true;
        return;
    L5:
        if (new File(r0.substring(7)).exists() == true) goto L7;
        r4 = Uri.parse(URLDecoder.decode(r0, RpcUtils.CHARSET_UTF8));     // Catch: UnsupportedEncodingException -> L9
        goto L7
    }

    public static ImageSource asset(String r2) {
        Objects.requireNonNull(r2, "Asset name must not be null");
        return uri(ASSET_SCHEME + r2);
    }

    public static ImageSource bitmap(Bitmap r2) {
        Objects.requireNonNull(r2, "Bitmap must not be null");
        return new ImageSource(r2, false);
    }

    public static ImageSource cachedBitmap(Bitmap r2) {
        Objects.requireNonNull(r2, "Bitmap must not be null");
        return new ImageSource(r2, true);
    }

    public static ImageSource resource(int r1) {
        return new ImageSource(r1);
    }

    private void setInvariants() {
        Rect r0 = this.sRegion;
        if (r0 == null) goto L6;
        this.tile = true;
        this.sWidth = r0.width();
        this.sHeight = this.sRegion.height();
        return;
    }

    public static ImageSource uri(Uri r1) {
        Objects.requireNonNull(r1, "Uri must not be null");
        return new ImageSource(r1);
    }

    public static ImageSource uri(String r2) {
        Objects.requireNonNull(r2, "Uri must not be null");
        if (r2.contains("://") == true) goto L9;
        if (r2.startsWith("/") == false) goto L7;
        r2 = r2.substring(1);
    L7:
        r2 = FILE_SCHEME + r2;
    L9:
        return new ImageSource(Uri.parse(r2));
    }

    public ImageSource dimensions(int r2, int r3) {
        if (this.bitmap != null) goto L5;
        this.sWidth = r2;
        this.sHeight = r3;
    L5:
        setInvariants();
        return this;
    }

    public final Bitmap getBitmap() {
        return this.bitmap;
    }

    public final Integer getResource() {
        return this.resource;
    }

    public final int getSHeight() {
        return this.sHeight;
    }

    public final Rect getSRegion() {
        return this.sRegion;
    }

    public final int getSWidth() {
        return this.sWidth;
    }

    public final boolean getTile() {
        return this.tile;
    }

    public final Uri getUri() {
        return this.uri;
    }

    public final boolean isCached() {
        return this.cached;
    }

    public ImageSource region(Rect r1) {
        this.sRegion = r1;
        setInvariants();
        return this;
    }

    public ImageSource tiling(boolean r1) {
        this.tile = r1;
        return this;
    }

    public ImageSource tilingDisabled() {
        return tiling(false);
    }

    public ImageSource tilingEnabled() {
        return tiling(true);
    }
}
