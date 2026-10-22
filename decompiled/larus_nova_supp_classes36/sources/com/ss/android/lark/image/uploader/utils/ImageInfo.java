package com.ss.android.lark.image.uploader.utils;

import android.text.TextUtils;
import com.ss.android.lark.utils.ImageUtils;
import java.util.HashMap;
import java.util.Locale;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class ImageInfo {
    public static final HashMap<String, ImageUtils.ImageType> j = null;
    public final int a;
    public final int b;
    public final long c;
    public final int d;
    public final String e;
    public final int f;
    public final boolean g;
    public final ImageUtils.ImageType h;
    public final boolean i;

    public static final class a {
        public int a;
        public int b;
        public long c;
        public int d;
        public String e;
        public int f;
        public boolean g;
        public boolean h;

        public a() {
        }
    }

    static {
        j = new AnonymousClass1();
    }

    public final String toString() {
        Locale r0 = Locale.getDefault();
        Object[] r1 = new Object[7];
        boolean r3 = false;
        r1[0] = Integer.valueOf(this.a);
        r1[1] = Integer.valueOf(this.b);
        r1[2] = Long.valueOf(this.c);
        int r2 = this.d;
        if (r2 >= 0) goto L5;
    L7:
        r1[3] = Boolean.valueOf(r3);
        r1[4] = this.e;
        r1[5] = Integer.valueOf(this.f);
        r1[6] = Boolean.valueOf(this.g);
        return String.format(r0, "w:%d, h:%d, size:%d, compressed:%s, mimeType:%s, exifOrientation:%d, hasExif:%s", r1);
    L5:
        if (r2 >= 95) goto L7;
        r3 = true;
        goto L7
    }

    public ImageInfo(a r4) {
        this.a = r4.a;
        this.b = r4.b;
        this.c = r4.c;
        int r0 = r4.d;
        if (r0 > 0) goto L5;
        r0 = 100;
    L5:
        this.d = r0;
        String r1 = r4.e;
        this.e = r1;
        this.f = r4.f;
        this.g = r4.g;
        if (TextUtils.isEmpty(r1) == true) goto L10;
        HashMap<String, ImageUtils.ImageType> r2 = j;
        if (r2.containsKey(r1) == false) goto L10;
        ImageUtils.ImageType r3 = r2.get(r1);
    L11:
        this.h = r3;
        this.i = r4.h;
        return;
    L10:
        r3 = ImageUtils.ImageType.TYPE_UNKNOWN;
        goto L11
    }

    public static a a(ImageInfo r3) {
        a r0 = new a();
        r0.a = r3.a;
        r0.b = r3.b;
        r0.e = r3.e;
        r0.c = r3.c;
        r0.d = r3.d;
        r0.f = r3.f;
        r0.g = r3.g;
        r0.h = r3.i;
        return r0;
    }
}
