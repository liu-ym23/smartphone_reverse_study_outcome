package r7;

import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap<String, b> f11537a = null;

    static {
        a r8 = new a();
        ConcurrentHashMap<String, b> r10 = new ConcurrentHashMap();
        f11537a = r10;
        r10.put("default", r8);
    }
}
