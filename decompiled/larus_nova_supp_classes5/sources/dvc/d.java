package dvc;

import javax.annotation.Nullable;
import okhttp3.Request;
import okhttp3.Response;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class d {

    @Nullable
    public final Request a;

    @Nullable
    public final Response b;

    public d(Request r1, Response r2) {
        this.a = r1;
        this.b = r2;
    }

    public static boolean a(Response r3, Request r4) {
        int r0 = r3.code();
        if (r0 == 200) goto L35;
        if (r0 == 410) goto L35;
        if (r0 == 414) goto L35;
        if (r0 == 501) goto L35;
        if (r0 == 203) goto L35;
        if (r0 == 204) goto L35;
        if (r0 == 307) goto L25;
        if (r0 == 308) goto L35;
        if (r0 == 404) goto L35;
        if (r0 == 405) goto L35;
        switch(r0) {
            case 300: goto L35;
            case 301: goto L35;
            case 302: goto L25;
            default: goto L33;
        };
    L33:
        return false;
    L25:
        if (r3.header("Expires") != null) goto L35;
        if (r3.cacheControl().maxAgeSeconds() != (-1)) goto L35;
        if (r3.cacheControl().isPublic() == true) goto L35;
        if (r3.cacheControl().isPrivate() == false) goto L33;
    L35:
        if (r3.cacheControl().noStore() == false) goto L37;
        return false;
    L37:
        if (r4.cacheControl().noStore() == true) goto L41;
        return true;
    L41:
        return false;
    }
}
