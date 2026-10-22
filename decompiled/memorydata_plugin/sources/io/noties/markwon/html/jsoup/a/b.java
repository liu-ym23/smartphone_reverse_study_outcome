package io.noties.markwon.html.jsoup.a;

/* JADX INFO: loaded from: classes6.dex */
public final class b {
    public static void a(Object r1) {
        if (r1 == null) goto L5;
        return;
    L5:
        throw new IllegalArgumentException("Object must not be null");
    }

    public static void a(String r1) {
        if (r1 == null) goto L7;
        if (r1.length() == 0) goto L7;
        return;
    L7:
        throw new IllegalArgumentException("String must not be empty");
    }

    public static void a(boolean r1) {
        if (r1 == false) goto L5;
        return;
    L5:
        throw new IllegalArgumentException("Must be true");
    }

    public static void a(boolean r0, String r1) {
        if (r0 == true) goto L5;
        return;
    L5:
        throw new IllegalArgumentException(r1);
    }

    public static void b(String r1) {
        throw new IllegalArgumentException(r1);
    }

    public static void b(boolean r1) {
        if (r1 == true) goto L5;
        return;
    L5:
        throw new IllegalArgumentException("Must be false");
    }
}
