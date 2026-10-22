package q0;

import android.graphics.Bitmap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public abstract class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final char[] f21459a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final char[] f21460b = null;

    static {
        f21459a = "0123456789abcdef".toCharArray();
        f21460b = new char[64];
    }

    public static boolean a(Object r5, Object r10) {
        if (r5 != null) goto L7;
        if (r10 != null) goto L5;
        return true;
    L5:
        return false;
    L7:
        return r5.equals(r10);
    }

    public static int b(int r5, int r10, Bitmap.Config r11) {
        int r12 = r5 * r10;
        if (r11 != null) goto L5;
        r11 = Bitmap.Config.ARGB_8888;
    L5:
        int r13 = h.f21458a[r11.ordinal()];
        int r14 = 1;
        if (r13 == 1) goto L16;
        r14 = 2;
        if (r13 == 2) goto L16;
        if (r13 == 3) goto L16;
        r14 = 4;
        if (r13 != 4) goto L16;
        r14 = 8;
    L16:
        return r12 * r14;
    }

    public static int c(Bitmap r5) {
        if (r5.isRecycled() == true) goto L9;
        return r5.getAllocationByteCount();
    L7:
        return r5.getRowBytes() * r5.getHeight();
    L9:
        throw new IllegalStateException("Cannot obtain size for recycled Bitmap: " + r5 + "[" + r5.getWidth() + "x" + r5.getHeight() + "] " + r5.getConfig());
    }

    public static ArrayList d(Collection r5) {
        ArrayList r10 = new ArrayList(r5.size());
        Iterator r11 = r5.iterator();
    L4:
        if (r11.hasNext() == false) goto L8;
        Object r12 = r11.next();
        if (r12 == null) goto L4;
        r10.add(r12);
        goto L4
    L8:
        return r10;
    }

    public static int e(int r5, int r10) {
        return (r10 * 31) + r5;
    }

    public static int f(int r5, Object r10) {
        if (r10 != null) goto L4;
        int r11 = 0;
    L6:
        return e(r11, r5);
    L4:
        r11 = r10.hashCode();
        goto L6
    }

    public static boolean g(int r5, int r10) {
        if (r5 > 0) goto L5;
        if (r5 == Integer.MIN_VALUE) goto L5;
    L8:
        return false;
    L5:
        if (r10 > 0) goto L9;
        if (r10 != Integer.MIN_VALUE) goto L8;
    L9:
        return true;
    }
}
