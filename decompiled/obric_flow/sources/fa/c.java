package fa;

import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap f16887a = null;

    static {
        a r5 = new a();
        ConcurrentHashMap r10 = new ConcurrentHashMap();
        f16887a = r10;
        r10.put("default", r5);
    }
}
