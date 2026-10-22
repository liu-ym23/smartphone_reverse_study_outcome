package org.ehcache;

/* JADX INFO: loaded from: classes7.dex */
public interface a<K, V> extends Iterable<InterfaceC0893a<K, V>> {

    /* JADX INFO: renamed from: org.ehcache.a$a, reason: collision with other inner class name */
    public interface InterfaceC0893a<K, V> {
        K a();

        V b();
    }

    V a(K r1);

    org.ehcache.config.c<K, V> a();

    void a(K r1, V r2);
}
