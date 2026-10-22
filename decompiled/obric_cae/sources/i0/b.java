package i0;

import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class b {
    public static boolean a(Object r8, Object r10) {
        return Objects.equals(r8, r10);
    }

    public static int b(Object... r8) {
        return Objects.hash(r8);
    }
}
