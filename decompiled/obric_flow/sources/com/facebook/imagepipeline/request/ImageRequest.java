package com.facebook.imagepipeline.request;

import android.net.Uri;
import android.text.TextUtils;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.Fn;
import com.facebook.common.internal.Objects;
import com.facebook.common.media.MediaUtils;
import com.facebook.common.media.MimeTypeMapWrapper;
import com.facebook.common.util.UriUtil;
import com.facebook.imagepipeline.common.ImageDecodeOptions;
import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.common.RotationOptions;
import com.lynx.jsbridge.LynxResourceModule;
import java.io.File;
import java.util.Arrays;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class ImageRequest {
    public static final Fn s = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CacheChoice f8414a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Uri f8415b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f8416c;
    public File d;
    public final boolean e;
    public final ImageDecodeOptions f;
    public final ResizeOptions g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final RotationOptions f8417h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Priority f8418i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final RequestLevel f8419j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f8420k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f8421l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Postprocessor f8422m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final long f8423n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final String f8424o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final boolean f8425p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f8426q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f8427r;

    public static final enum CacheChoice extends Enum<CacheChoice> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final CacheChoice f8428a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final CacheChoice f8429b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final CacheChoice f8430c = null;
        public static final /* synthetic */ CacheChoice[] d = null;

        static {
            CacheChoice r5 = new CacheChoice("CUSTOM", 0);
            f8428a = r5;
            CacheChoice r10 = new CacheChoice("SMALL", 1);
            f8429b = r10;
            CacheChoice r11 = new CacheChoice("DEFAULT", 2);
            f8430c = r11;
            d = new CacheChoice[]{r5, r10, r11};
        }

        public CacheChoice(String r5, int r10) {
            super(r5, r10);
        }

        public static CacheChoice valueOf(String r5) {
            return (CacheChoice) Enum.valueOf(CacheChoice.class, r5);
        }

        public static CacheChoice[] values() {
            return (CacheChoice[]) d.clone();
        }
    }

    public static final enum RequestLevel extends Enum<RequestLevel> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final RequestLevel f8431b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final RequestLevel f8432c = null;
        public static final RequestLevel d = null;
        public static final /* synthetic */ RequestLevel[] e = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f8433a;

        static {
            RequestLevel r5 = new RequestLevel("FULL_FETCH", 0, 1);
            f8431b = r5;
            RequestLevel r10 = new RequestLevel("DISK_CACHE", 1, 2);
            f8432c = r10;
            RequestLevel r11 = new RequestLevel("ENCODED_MEMORY_CACHE", 2, 3);
            RequestLevel r12 = new RequestLevel("BITMAP_MEMORY_CACHE", 3, 4);
            d = r12;
            e = new RequestLevel[]{r5, r10, r11, r12};
        }

        public RequestLevel(String r5, int r10, int r11) {
            super(r5, r10);
            this.f8433a = r11;
        }

        public static RequestLevel valueOf(String r5) {
            return (RequestLevel) Enum.valueOf(RequestLevel.class, r5);
        }

        public static RequestLevel[] values() {
            return (RequestLevel[]) e.clone();
        }
    }

    static {
        s = new AnonymousClass1();
    }

    public ImageRequest(ImageRequestBuilder r10) {
        this.f8414a = r10.f;
        Uri r5 = r10.f8434a;
        this.f8415b = r5;
        boolean r11 = false;
        if (r5 != null) goto L6;
    L48:
        int r12 = -1;
    L49:
        this.f8416c = r12;
        this.e = r10.g;
        this.f = r10.e;
        this.g = r10.f8436c;
        RotationOptions r13 = r10.d;
        if (r13 != null) goto L52;
        r13 = RotationOptions.f8054c;
    L52:
        this.f8417h = r13;
        this.f8418i = r10.f8437h;
        this.f8419j = r10.f8435b;
        if (r10.f8439j == true) goto L55;
    L57:
        this.f8420k = r11;
        this.f8421l = r10.f8440k;
        this.f8422m = r10.f8438i;
        this.f8423n = r10.f8443n;
        this.f8424o = r10.f8441l;
        this.f8425p = r10.f8444o;
        return;
    L55:
        if (UriUtil.b(r10.f8434a) == false) goto L57;
        r11 = true;
        goto L57
    L6:
        if (UriUtil.b(r5) == false) goto L8;
        r12 = 0;
        goto L49
    L8:
        String r14 = null;
        if ("file".equals(r5.getScheme()) == false) goto L31;
        String r15 = r5.getPath();
        Map r16 = MediaUtils.f7659a;
        int r17 = r15.lastIndexOf(46);
        if (r17 >= 0) goto L13;
    L16:
        String r18 = null;
    L17:
        if (r18 == null) goto L25;
        String r19 = r18.toLowerCase(Locale.US);
        String r20 = (String) MimeTypeMapWrapper.f7661b.get(r19);
        if (r20 == null) goto L22;
    L21:
        r14 = r20;
        if (r14 != null) goto L25;
        r14 = (String) MediaUtils.f7659a.get(r19);
        goto L25
    L22:
        r20 = MimeTypeMapWrapper.f7660a.getMimeTypeFromExtension(r19);
    L25:
        if (r14 != null) goto L27;
    L29:
        r12 = 3;
        goto L49
    L27:
        if (r14.startsWith("video/") == false) goto L29;
        r12 = 2;
        goto L49
    L13:
        if (r17 == (r15.length() - 1)) goto L16;
        r18 = r15.substring(r17 + 1);
        goto L17
    L31:
        if (UriUtil.a(r5) == false) goto L37;
        if (TextUtils.isEmpty(null) == true) goto L35;
        Map r21 = MediaUtils.f7659a;
    L35:
        r12 = 4;
        goto L49
    L37:
        if ("asset".equals(r5.getScheme()) == false) goto L40;
        r12 = 5;
        goto L49
    L40:
        if ("res".equals(r5.getScheme()) == false) goto L43;
        r12 = 6;
        goto L49
    L43:
        if ("data".equals(r5.getScheme()) == false) goto L46;
        r12 = 7;
        goto L49
    L46:
        if ("android.resource".equals(r5.getScheme()) == false) goto L48;
        r12 = 8;
        goto L49
    }

    public final synchronized File a() {
        monitor-enter(this);
    L6:
        th = move-exception;
        throw th;
    L4:
        if (this.d != null) goto L8;
        this.d = new File(this.f8415b.getPath());     // Catch: Throwable -> L6
    L8:
        File r5 = this.d;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r5;
    }

    public final boolean equals(Object r5) {
        if ((r5 instanceof ImageRequest) == true) goto L5;
        return false;
    L5:
        ImageRequest r10 = (ImageRequest) r5;
        r10.getClass();
        if (this.f8420k == r10.f8420k) goto L9;
        return false;
    L9:
        if (this.f8421l == r10.f8421l) goto L12;
        return false;
    L12:
        if (Objects.a(this.f8415b, r10.f8415b) == true) goto L14;
    L43:
        return false;
    L14:
        if (Objects.a(this.f8414a, r10.f8414a) == false) goto L43;
        if (Objects.a(this.d, r10.d) == false) goto L43;
        CacheKey r11 = null;
        if (Objects.a(null, null) == false) goto L43;
        if (Objects.a(this.f, r10.f) == false) goto L43;
        if (Objects.a(this.g, r10.g) == false) goto L43;
        if (Objects.a(this.f8418i, r10.f8418i) == false) goto L43;
        if (Objects.a(this.f8419j, r10.f8419j) == false) goto L43;
        if (Objects.a(null, null) == false) goto L43;
        if (Objects.a(null, null) == false) goto L43;
        if (Objects.a(this.f8417h, r10.f8417h) == false) goto L43;
        Postprocessor r12 = this.f8422m;
        if (r12 == null) goto L37;
        CacheKey r13 = r12.a();
    L38:
        Postprocessor r14 = r10.f8422m;
        if (r14 == null) goto L42;
        r11 = r14.a();
    L42:
        return Objects.a(r13, r11);
    L37:
        r13 = null;
        goto L38
    }

    public final int hashCode() {
        Postprocessor r5 = this.f8422m;
        if (r5 == null) goto L6;
        CacheKey r10 = r5.a();
    L5:
        CacheKey r13 = r10;
        CacheChoice r11 = this.f8414a;
        Uri r12 = this.f8415b;
        Priority r14 = this.f8418i;
        RequestLevel r15 = this.f8419j;
        Boolean r16 = Boolean.valueOf(this.f8420k);
        Boolean r17 = Boolean.valueOf(this.f8421l);
        ImageDecodeOptions r18 = this.f;
        ResizeOptions r19 = this.g;
        RotationOptions r110 = this.f8417h;
        return Arrays.hashCode(new Object[]{r11, r12, Boolean.FALSE, null, r14, r15, r16, r17, r18, null, r19, r110, r13, null});
    L6:
        r10 = null;
        goto L5
    }

    public final String toString() {
        return new Objects.ToStringHelper(getClass().getSimpleName()).a(LynxResourceModule.URI_KEY, this.f8415b).a("cacheChoice", this.f8414a).a("decodeOptions", this.f).a("postprocessor", this.f8422m).a("priority", this.f8418i).a("resizeOptions", this.g).a("rotationOptions", this.f8417h).a("bytesRange", null).a("resizingAllowedOverride", null).a("progressiveRenderingEnabled", String.valueOf(this.e)).a("localThumbnailPreviewsEnabled", String.valueOf(false)).a("lowestPermittedRequestLevel", this.f8419j).a("isDiskCacheEnabled", String.valueOf(this.f8420k)).a("isMemoryCacheEnabled", String.valueOf(this.f8421l)).a("decodePrefetches", null).toString();
    }
}
