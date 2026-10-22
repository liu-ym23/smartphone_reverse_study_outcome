package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.os.Parcelable;
import com.obric.cae.smartBluetooth.deviceIdentification.bdim.BdimCategoryConstants;
import h1.a;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes.dex */
public class IconCompatParcelizer {
    public IconCompatParcelizer() {
    }

    public static IconCompat read(a r8) {
        IconCompat r10 = new IconCompat();
        r10.f1677a = r8.j(r10.f1677a, 1);
        byte[] r11 = r10.f1679c;
        if (r8.h(2) == false) goto L6;
        r11 = r8.f();
    L6:
        r10.f1679c = r11;
        Parcelable r12 = r10.f1680d;
        if (r8.h(3) == false) goto L10;
        r12 = r8.k();
    L10:
        r10.f1680d = r12;
        r10.f1681e = r8.j(r10.f1681e, 4);
        r10.f1682f = r8.j(r10.f1682f, 5);
        Parcelable r13 = r10.f1683g;
        if (r8.h(6) == false) goto L14;
        r13 = r8.k();
    L14:
        r10.f1683g = (ColorStateList) r13;
        String r14 = r10.f1685i;
        if (r8.h(7) == false) goto L18;
        r14 = r8.l();
    L18:
        r10.f1685i = r14;
        String r15 = r10.f1686j;
        if (r8.h(8) == false) goto L22;
        r15 = r8.l();
    L22:
        r10.f1686j = r15;
        r10.f1684h = PorterDuff.Mode.valueOf(r10.f1685i);
        switch(r10.f1677a) {
            case -1: goto L35;
            case 0: goto L40;
            case 1: goto L31;
            case 2: goto L26;
            case 3: goto L25;
            case 4: goto L26;
            case 5: goto L31;
            case 6: goto L26;
            default: goto L40;
        };
    L25:
        r10.f1678b = r10.f1679c;
        goto L40
    L26:
        String r16 = new String(r10.f1679c, Charset.forName("UTF-16"));
        r10.f1678b = r16;
        if (r10.f1677a != 2) goto L40;
        if (r10.f1686j != null) goto L40;
        r10.f1686j = r16.split(BdimCategoryConstants.SEPARATOR_COLON, -1)[0];
        goto L40
    L31:
        Parcelable r17 = r10.f1680d;
        if (r17 != null) goto L37;
        byte[] r18 = r10.f1679c;
        r10.f1678b = r18;
        r10.f1677a = 3;
        r10.f1681e = 0;
        r10.f1682f = r18.length;
    L37:
        r10.f1678b = r17;
        goto L40
    L35:
        r17 = r10.f1680d;
        if (r17 != null) goto L37;
        throw new IllegalArgumentException("Invalid icon");
    L40:
        return r10;
    }

    public static void write(IconCompat r8, a r10) {
        r10.getClass();
        r8.f1685i = r8.f1684h.name();
        switch(r8.f1677a) {
            case -1: goto L8;
            case 0: goto L9;
            case 1: goto L8;
            case 2: goto L7;
            case 3: goto L6;
            case 4: goto L5;
            case 5: goto L8;
            case 6: goto L5;
            default: goto L9;
        };
    L5:
        r8.f1679c = r8.f1678b.toString().getBytes(Charset.forName("UTF-16"));
        goto L9
    L6:
        r8.f1679c = (byte[]) r8.f1678b;
        goto L9
    L7:
        r8.f1679c = ((String) r8.f1678b).getBytes(Charset.forName("UTF-16"));
        goto L9
    L8:
        r8.f1680d = (Parcelable) r8.f1678b;
    L9:
        int r11 = r8.f1677a;
        if ((-1) == r11) goto L12;
        r10.s(r11, 1);
    L12:
        byte[] r12 = r8.f1679c;
        if (r12 == null) goto L15;
        r10.n(2);
        r10.p(r12);
    L15:
        Parcelable r13 = r8.f1680d;
        if (r13 == null) goto L18;
        r10.n(3);
        r10.t(r13);
    L18:
        int r14 = r8.f1681e;
        if (r14 == 0) goto L21;
        r10.s(r14, 4);
    L21:
        int r15 = r8.f1682f;
        if (r15 == 0) goto L24;
        r10.s(r15, 5);
    L24:
        ColorStateList r16 = r8.f1683g;
        if (r16 == null) goto L27;
        r10.n(6);
        r10.t(r16);
    L27:
        String r17 = r8.f1685i;
        if (r17 == null) goto L30;
        r10.n(7);
        r10.u(r17);
    L30:
        String r18 = r8.f1686j;
        if (r18 == null) goto L34;
        r10.n(8);
        r10.u(r18);
        return;
    }
}
