package e18;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public interface a<T> {

    /* JADX INFO: renamed from: e18.a$a, reason: collision with other inner class name */
    public static final class C0102a {
        /* JADX WARN: Multi-variable type inference failed */
        public static <T> int a(a<T> r1, Object r2) {
            Intrinsics.checkNotNullParameter(r2, "any");
            if (r2 != 0) goto L7;
            return 0;
        L7:
            return r1.indexOf(r2);
        }
    }

    int a(Object r1);

    T getItem(int r1);

    int getItemsCount();

    int indexOf(T r1);
}
