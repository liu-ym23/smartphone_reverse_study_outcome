package ia8;

import com.larus.avlink.n1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class q {
    public static final q a = null;
    public static final String b = null;

    public q() {
    }

    static {
        a = new q();
        b = "MusicCoverUtils";
    }

    public static String a(String r3, String r4, String r5) {
        boolean r0 = true;
        if (r3 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == false) goto L11;
    L23:
        n1.b(b, "coverImage: error coverUrl:" + r3 + ",coverUri:" + r4 + ",coverPrefix:" + r5);
        return null;
    L11:
        if (r4.length() != 0) goto L13;
        boolean r6 = true;
    L14:
        if (r6 == true) goto L23;
        if (r5.length() == 0) goto L19;
        r0 = false;
    L19:
        if (r0 == true) goto L23;
        return r3 + r4 + '~' + r5 + "-crop-center:100:100.jpg";
    L13:
        r6 = false;
        goto L14
    L5:
        if (r3.length() == 0) goto L8;
        r2 = false;
        goto L9
    }
}
