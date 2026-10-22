package z;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import androidx.appcompat.app.r;
import java.io.IOException;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ThreadLocal<TypedValue> f14146a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final WeakHashMap<d, SparseArray<c>> f14147b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Object f14148c = null;

    public static class a {
        public static Drawable a(Resources r8, int r10, Resources.Theme r11) {
            return r8.getDrawable(r10, r11);
        }

        public static Drawable b(Resources r8, int r10, int r11, Resources.Theme r12) {
            return r8.getDrawableForDensity(r10, r11, r12);
        }
    }

    public static class b {
        public static int a(Resources r8, int r10, Resources.Theme r11) {
            return r8.getColor(r10, r11);
        }

        public static ColorStateList b(Resources r8, int r10, Resources.Theme r11) {
            return r8.getColorStateList(r10, r11);
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ColorStateList f14149a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Configuration f14150b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f14151c;

        public c(ColorStateList r8, Configuration r10, Resources.Theme r11) {
            this.f14149a = r8;
            this.f14150b = r10;
            if (r11 != null) goto L5;
            int r12 = 0;
        L6:
            this.f14151c = r12;
            return;
        L5:
            r12 = r11.hashCode();
            goto L6
        }
    }

    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Resources f14152a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Resources.Theme f14153b;

        public d(Resources r8, Resources.Theme r10) {
            this.f14152a = r8;
            this.f14153b = r10;
        }

        public final boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if (r8 != null) goto L8;
        L17:
            return false;
        L8:
            if (d.class != r8.getClass()) goto L17;
            d r10 = (d) r8;
            if (this.f14152a.equals(r10.f14152a) == false) goto L16;
            if (i0.b.a(this.f14153b, r10.f14153b) == false) goto L16;
            return true;
        L16:
            return false;
        }

        public final int hashCode() {
            return i0.b.b(new Object[]{this.f14152a, this.f14153b});
        }
    }

    public static abstract class e {
        public final void a(int r8) {
            new Handler(Looper.getMainLooper()).post(new g(r8, 0, this));
        }

        public final void b(Typeface r8) {
            new Handler(Looper.getMainLooper()).post(new r(1, this, r8));
        }

        public abstract void c(int r8);

        public abstract void d(Typeface r8);
    }

    static {
        f14146a = new ThreadLocal();
        f14147b = new WeakHashMap(0);
        f14148c = new Object();
    }

    public static Typeface a(Context r8, int r10) {
        if (r8.isRestricted() == false) goto L7;
        return null;
    L7:
        return b(r8, r10, new TypedValue(), 0, null, false, false);
    }

    public static Typeface b(Context r15, int r16, TypedValue r17, int r18, e r19, boolean r20, boolean r21) {
        Resources r8 = r15.getResources();
        r8.getValue(r16, r17, true);
        CharSequence r10 = r17.string;
        if (r10 == null) goto L46;
        String r13 = r10.toString();
        if (r13.startsWith("res/") == true) goto L8;
        if (r19 == null) goto L37;
    L7:
        r19.a(-3);
    L37:
        Typeface r11 = null;
    L38:
        if (r11 != null) goto L44;
        if (r19 != null) goto L44;
        if (r21 == true) goto L44;
        throw new Resources.NotFoundException("Font resource ID #0x" + Integer.toHexString(r16) + " could not be retrieved.");
    L44:
        return r11;
    L8:
        r11 = a0.e.f13b.a(a0.e.d(r8, r16, r13, r17.assetCookie, r18));
        if (r11 == null) goto L12;
        if (r19 == null) goto L38;
        r19.b(r11);
        goto L38
    L12:
        if (r21 == true) goto L37;
    L22:
        e = e;
        String r12 = "Failed to read xml resource ";
    L34:
        Log.e("ResourcesCompat", r12.concat(r13), e);
        if (r19 == null) goto L37;
    L24:
        e = e;
        r12 = "Failed to parse xml resource ";
        goto L34
    L15:
        if (r13.toLowerCase().endsWith(".xml") == false) goto L26;
        z.d.b r14 = z.d.a(r8.getXml(r16), r8);     // Catch: IOException -> L22 XmlPullParserException -> L24
        if (r14 != null) goto L21;
        Log.e("ResourcesCompat", "Failed to find font-family tag");     // Catch: IOException -> L22 XmlPullParserException -> L24
        if (r19 == null) goto L37;
        r19.a(-3);     // Catch: IOException -> L22 XmlPullParserException -> L24
        goto L37
    L21:
        r11 = a0.e.b(r15, r14, r8, r16, r13, r17.assetCookie, r18, r19, r20);     // Catch: IOException -> L22 XmlPullParserException -> L24
        goto L38
    L26:
        r11 = a0.e.c(r8, r16, r13, r17.assetCookie, r18);     // Catch: IOException -> L22 XmlPullParserException -> L24
        if (r19 == null) goto L38;
        if (r11 == null) goto L30;
        r19.b(r11);     // Catch: IOException -> L22 XmlPullParserException -> L24
        goto L38
    L30:
        r19.a(-3);     // Catch: IOException -> L22 XmlPullParserException -> L24
        goto L38
    L46:
        throw new Resources.NotFoundException("Resource \"" + r8.getResourceName(r16) + "\" (" + Integer.toHexString(r16) + ") is not a Font: " + r17);
    }
}
