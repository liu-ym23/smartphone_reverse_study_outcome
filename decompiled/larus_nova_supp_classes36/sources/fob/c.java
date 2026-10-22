package fob;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public interface c<T, D> {

    public static final class a<D> {
        public final boolean a;
        public final D b;

        public /* synthetic */ a() {
            this(false, null);
        }

        public a(boolean r1, D r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    a<D> resolve(T r1);
}
