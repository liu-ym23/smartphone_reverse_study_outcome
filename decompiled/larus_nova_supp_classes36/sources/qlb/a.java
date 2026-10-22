package qlb;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a {
    public final Uri a;
    public final Bitmap b;
    public final Integer c;
    public boolean d;
    public int e;
    public int f;
    public Rect g;
    public final boolean h;

    public a(Uri r4) {
        String r0 = r4.toString();
        if (r0.startsWith("file:///") == true) goto L5;
    L7:
        this.b = null;
        this.a = r4;
        this.c = null;
        this.d = true;
        return;
    L5:
        if (new PolarisFileWrapper(r0.substring(7)).exists() == true) goto L7;
        r4 = UriProtector.parse(URLDecoder.decode(r0, "UTF-8"));     // Catch: UnsupportedEncodingException -> L9
        goto L7
    }

    public static a a(Bitmap r2) {
        if (r2 == null) goto L6;
        return new a(r2, true);
    L6:
        throw new NullPointerException("Bitmap must not be null");
    }

    public a(int r2) {
        this.b = null;
        this.a = null;
        this.c = Integer.valueOf(r2);
        this.d = true;
    }

    public a(Bitmap r2, boolean r3) {
        this.b = r2;
        this.a = null;
        this.c = null;
        this.d = false;
        this.e = r2.getWidth();
        this.f = r2.getHeight();
        this.h = r3;
    }
}
