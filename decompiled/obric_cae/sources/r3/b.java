package r3;

import android.text.TextUtils;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f11392a;

        public a(String r8) {
            this.f11392a = r8;
        }

        public final boolean a(c r8) {
            String r10 = r8.f11401i;
            return this.f11392a.equals(r10);
        }
    }

    public static c a(String r8) {
        if (TextUtils.isEmpty(r8) == false) goto L5;
        return null;
    L5:
        Iterator r10 = c.N.iterator();
    L7:
        if (r10.hasNext() == false) goto L11;
        c r11 = (c) r10.next();
        if (r8.equals(r11.f11401i) == false) goto L7;
        return r11;
    L11:
        return null;
    }

    public static String b(f r8, String r10) {
        if (r3.a.f11390a != r8) goto L5;
        boolean r11 = true;
    L6:
        if (r11 == true) goto L10;
        StringBuilder r12 = android.aimedia.a.k(r10, "_");
        r12.append(((c) r8).f11401i);
        return r12.toString();
    L10:
        return r10;
    L5:
        r11 = false;
        goto L6
    }

    public static boolean c(String r8) {
        if (TextUtils.isEmpty(r8) == true) goto L17;
        a r10 = new a(r8);
        Iterator r11 = c.N.iterator();
    L6:
        if (r11.hasNext() == false) goto L10;
        if (r10.a((c) r11.next()) == false) goto L6;
        boolean r12 = true;
    L11:
        if (r12 == true) goto L13;
        return false;
    L13:
        return true;
    L10:
        r12 = false;
        goto L11
    L17:
        return false;
    }
}
