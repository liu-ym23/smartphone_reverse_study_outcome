package com.facebook.imagepipeline.request;

import android.net.Uri;
import com.facebook.common.util.UriUtil;
import com.facebook.imagepipeline.common.ImageDecodeOptions;
import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.common.RotationOptions;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class ImageRequestBuilder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Uri f8434a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ImageRequest.RequestLevel f8435b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ResizeOptions f8436c;
    public RotationOptions d;
    public ImageDecodeOptions e;
    public ImageRequest.CacheChoice f;
    public boolean g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Priority f8437h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Postprocessor f8438i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f8439j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f8440k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f8441l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f8442m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final long f8443n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final boolean f8444o;

    public static class BuilderException extends RuntimeException {
        public BuilderException(String r5) {
            super("Invalid request builder: ".concat(r5));
        }
    }

    public ImageRequestBuilder() {
        this.f8434a = null;
        this.f8435b = ImageRequest.RequestLevel.f8431b;
        this.f8436c = null;
        this.d = null;
        this.e = ImageDecodeOptions.e;
        this.f = ImageRequest.CacheChoice.f8430c;
        this.g = false;
        this.f8437h = Priority.f8050c;
        this.f8438i = null;
        this.f8439j = true;
        this.f8440k = true;
        this.f8441l = null;
        this.f8442m = 1;
        this.f8443n = -1;
        this.f8444o = true;
    }

    public ImageRequestBuilder a(Map r5) {
        return this;
    }

    public static ImageRequestBuilder a(Uri r5) {
        ImageRequestBuilder r10 = new ImageRequestBuilder();
        r5.getClass();
        r10.f8434a = r5;
        return r10;
    }

    public static ImageRequestBuilder a(ImageRequest r5) {
        ImageRequestBuilder r10 = a(r5.f8415b);
        r10.e = r5.f;
        r10.f = r5.f8414a;
        r10.f8435b = r5.f8419j;
        r10.f8438i = r5.f8422m;
        r10.g = r5.e;
        r10.f8437h = r5.f8418i;
        r10.f8436c = r5.g;
        r10.d = r5.f8417h;
        return r10;
    }

    public final ImageRequest a() {
        Uri r5 = this.f8434a;
        if (r5 == null) goto L39;
        Uri r10 = UriUtil.f7699a;
        if ("res".equals(r5.getScheme()) == false) goto L19;
        if (this.f8434a.isAbsolute() == false) goto L17;
        if (this.f8434a.getPath().isEmpty() == true) goto L15;
        Integer.parseInt(this.f8434a.getPath().substring(1));     // Catch: NumberFormatException -> L12
    L13:
        throw new BuilderException("Resource URI path must be a resource id.");
    L15:
        throw new BuilderException("Resource URI must not be empty");
    L17:
        throw new BuilderException("Resource URI path must be absolute.");
    L19:
        if (this.f8441l == null) goto L21;
    L25:
        Uri r11 = this.f8434a;
        if (r11 != null) goto L28;
        String r12 = null;
    L30:
        if ("asset".equals(r12) == false) goto L37;
        if (this.f8434a.isAbsolute() == true) goto L37;
        throw new BuilderException("Asset URI path must be absolute.");
    L37:
        return new ImageRequest(this);
    L28:
        r12 = r11.getScheme();
        goto L30
    L21:
        if (this.f.equals(ImageRequest.CacheChoice.f8428a) == false) goto L25;
        throw new BuilderException("CustomCacheName must be set as you have choice your cacheChoice as 'CUSTOM'");
    L39:
        throw new BuilderException("Source must be set!");
    }
}
