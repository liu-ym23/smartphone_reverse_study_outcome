package okhttp3;

import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public interface h {
    public static final a a = null;

    public static class a implements h {
        public a() {
        }

        @Override // okhttp3.h
        public final void b(HttpUrl r1, List<g> r2) {
        }

        @Override // okhttp3.h
        public final List<g> a(HttpUrl r1) {
            return Collections.emptyList();
        }
    }

    List<g> a(HttpUrl r1);

    void b(HttpUrl r1, List<g> r2);

    static {
        a = new a();
    }
}
