package org.ehcache.shadow.org.terracotta.statistics;

/* JADX INFO: loaded from: classes7.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile a f18160a;

    public interface a {
        long a();
    }

    static {
        f18160a = new AnonymousClass1();
    }

    public static long a() {
        return f18160a.a();
    }
}
