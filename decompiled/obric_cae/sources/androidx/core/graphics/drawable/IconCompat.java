package androidx.core.graphics.drawable;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.AdaptiveIconDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.versionedparcelable.CustomVersionedParcelable;
import com.obric.cae.smartBluetooth.deviceIdentification.bdim.BdimCategoryConstants;

/* JADX INFO: loaded from: classes.dex */
public class IconCompat extends CustomVersionedParcelable {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final PorterDuff.Mode f1676k = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f1677a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f1678b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public byte[] f1679c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Parcelable f1680d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f1681e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f1682f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ColorStateList f1683g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public PorterDuff.Mode f1684h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f1685i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f1686j;

    public static class a {
        public static Uri a(Object r8) {
            return c.d(r8);
        }

        public static Drawable b(Icon r8, Context r10) {
            return r8.loadDrawable(r10);
        }

        public static Icon c(IconCompat r8, Context r10) {
            int r11 = r8.f1677a;
            switch(r11) {
                case -1: goto L43;
                case 0: goto L5;
                case 1: goto L34;
                case 2: goto L20;
                case 3: goto L19;
                case 4: goto L18;
                case 5: goto L17;
                case 6: goto L6;
                default: goto L5;
            };
        L6:
            if (r11 != (-1)) goto L9;
            Uri r12 = a(r8.f1678b);
        L16:
            Icon r13 = d.a(r12);
        L35:
            ColorStateList r14 = r8.f1683g;
            if (r14 == null) goto L38;
            r13.setTintList(r14);
        L38:
            PorterDuff.Mode r15 = r8.f1684h;
            if (r15 == IconCompat.f1676k) goto L41;
            r13.setTintMode(r15);
        L41:
            return r13;
        L9:
            if (r11 != 4) goto L11;
        L15:
            r12 = Uri.parse((String) r8.f1678b);
            goto L16
        L11:
            if (r11 == 6) goto L15;
            throw new IllegalStateException("called getUri() on " + r8);
        L17:
            r13 = b.b((Bitmap) r8.f1678b);
            goto L35
        L18:
            r13 = Icon.createWithContentUri((String) r8.f1678b);
            goto L35
        L19:
            r13 = Icon.createWithData((byte[]) r8.f1678b, r8.f1681e, r8.f1682f);
            goto L35
        L20:
            if (r11 != (-1)) goto L23;
            String r16 = c.b(r8.f1678b);
        L31:
            r13 = Icon.createWithResource(r16, r8.f1681e);
            goto L35
        L23:
            if (r11 != 2) goto L33;
            String r17 = r8.f1686j;
            if (r17 != null) goto L27;
        L30:
            r16 = ((String) r8.f1678b).split(BdimCategoryConstants.SEPARATOR_COLON, -1)[0];
            goto L31
        L27:
            if (TextUtils.isEmpty(r17) == true) goto L30;
            r16 = r8.f1686j;
            goto L31
        L33:
            throw new IllegalStateException("called getResPackage() on " + r8);
        L34:
            r13 = Icon.createWithBitmap((Bitmap) r8.f1678b);
            goto L35
        L5:
            throw new IllegalArgumentException("Unknown type");
        L43:
            return (Icon) r8.f1678b;
        }
    }

    public static class b {
        public static Drawable a(Drawable r8, Drawable r10) {
            return new AdaptiveIconDrawable(r8, r10);
        }

        public static Icon b(Bitmap r8) {
            return Icon.createWithAdaptiveBitmap(r8);
        }
    }

    public static class c {
        public static int a(Object r8) {
            return ((Icon) r8).getResId();
        }

        public static String b(Object r8) {
            return ((Icon) r8).getResPackage();
        }

        public static int c(Object r8) {
            return ((Icon) r8).getType();
        }

        public static Uri d(Object r8) {
            return ((Icon) r8).getUri();
        }
    }

    public static class d {
        public static Icon a(Uri r8) {
            return Icon.createWithAdaptiveBitmapContentUri(r8);
        }
    }

    static {
        f1676k = PorterDuff.Mode.SRC_IN;
    }

    public IconCompat() {
        this.f1677a = -1;
        this.f1679c = null;
        this.f1680d = null;
        this.f1681e = 0;
        this.f1682f = 0;
        this.f1683g = null;
        this.f1684h = f1676k;
        this.f1685i = null;
    }

    public static IconCompat a(String r8, int r10) {
        r8.getClass();
        if (r10 == 0) goto L7;
        IconCompat r11 = new IconCompat(2);
        r11.f1681e = r10;
        r11.f1678b = r8;
        r11.f1686j = r8;
        return r11;
    L7:
        throw new IllegalArgumentException("Drawable resource ID must not be 0");
    }

    public final int b() {
        int r8 = this.f1677a;
        if (r8 != (-1)) goto L7;
        return c.a(this.f1678b);
    L7:
        if (r8 != 2) goto L11;
        return this.f1681e;
    L11:
        throw new IllegalStateException("called getResId() on " + this);
    }

    public final String toString() {
        if (this.f1677a == (-1)) goto L5;
        StringBuilder r8 = new StringBuilder("Icon(typ=");
        switch(this.f1677a) {
            case 1: goto L14;
            case 2: goto L13;
            case 3: goto L12;
            case 4: goto L11;
            case 5: goto L10;
            case 6: goto L9;
            default: goto L8;
        };
    L8:
        String r10 = BdimCategoryConstants.VALUE_UNKNOWN;
    L15:
        r8.append(r10);
        switch(this.f1677a) {
            case 1: goto L23;
            case 2: goto L22;
            case 3: goto L19;
            case 4: goto L18;
            case 5: goto L23;
            case 6: goto L18;
            default: goto L26;
        };
    L18:
        r8.append(" uri=");
        r8.append(this.f1678b);
        goto L26
    L19:
        r8.append(" len=");
        r8.append(this.f1681e);
        if (this.f1682f == 0) goto L26;
        r8.append(" off=");
        int r11 = this.f1682f;
    L24:
        r8.append(r11);
        goto L26
    L22:
        r8.append(" pkg=");
        r8.append(this.f1686j);
        r8.append(" id=");
        r8.append(String.format("0x%08x", new Object[]{Integer.valueOf(b())}));
        goto L26
    L23:
        r8.append(" size=");
        r8.append(((Bitmap) this.f1678b).getWidth());
        r8.append("x");
        r11 = ((Bitmap) this.f1678b).getHeight();
    L26:
        if (this.f1683g == null) goto L29;
        r8.append(" tint=");
        r8.append(this.f1683g);
    L29:
        if (this.f1684h == f1676k) goto L31;
        r8.append(" mode=");
        r8.append(this.f1684h);
    L31:
        r8.append(")");
        return r8.toString();
    L9:
        r10 = "URI_MASKABLE";
        goto L15
    L10:
        r10 = "BITMAP_MASKABLE";
        goto L15
    L11:
        r10 = "URI";
        goto L15
    L12:
        r10 = "DATA";
        goto L15
    L13:
        r10 = "RESOURCE";
        goto L15
    L14:
        r10 = "BITMAP";
        goto L15
    L5:
        return String.valueOf(this.f1678b);
    }

    public IconCompat(int r8) {
        this.f1679c = null;
        this.f1680d = null;
        this.f1681e = 0;
        this.f1682f = 0;
        this.f1683g = null;
        this.f1684h = f1676k;
        this.f1685i = null;
        this.f1677a = r8;
    }
}
