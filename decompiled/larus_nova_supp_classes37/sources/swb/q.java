package swb;

import java.security.SecureRandom;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class q {
    public static final ThreadLocal<SecureRandom> a = null;

    static {
        a = new ThreadLocal();
    }
}
