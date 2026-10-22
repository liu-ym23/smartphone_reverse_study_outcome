package org.ehcache.shadow.org.terracotta.statistics;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes7.dex */
public final class h {

    static class a<T extends a<T>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        protected final Set<String> f18153a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        protected final Map<String, Object> f18154b;
        protected Object c;
        protected String d;

        a() {
            this.f18153a = new HashSet();
            this.f18154b = new HashMap();
        }

        public T a(Object r2) {
            if (this.c != null) goto L7;
            this.c = r2;
            return this;
        L7:
            throw new IllegalStateException("Context already defined");
        }

        public T a(String r2) {
            if (this.d != null) goto L7;
            this.d = r2;
            return this;
        L7:
            throw new IllegalStateException("Name already defined");
        }

        public T a(String... r2) {
            Collections.addAll(this.f18153a, r2);
            return this;
        }
    }

    public static class b<T extends Enum<T>> extends a<b<T>> {
        private final Class<T> e;

        public b(Class<T> r1) {
            this.e = r1;
        }

        public org.ehcache.shadow.org.terracotta.statistics.a.b<T> a() {
            if (this.c == null) goto L9;
            if (this.d == null) goto L9;
            return i.a(this.c, this.d, this.f18153a, this.f18154b, this.e);
        L9:
            throw new IllegalStateException();
        }
    }

    public static <T extends Enum<T>> b<T> a(Class<T> r1) {
        return new b(r1);
    }
}
