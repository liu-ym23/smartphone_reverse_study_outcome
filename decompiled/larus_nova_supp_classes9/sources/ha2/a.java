package ha2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public interface a {

    /* JADX INFO: renamed from: ha2.a$a, reason: collision with other inner class name */
    public static final class C0234a {
        public static /* synthetic */ void a(a r1, boolean r2, String r3, int r4) {
            if ((r4 & 2) == 0) goto L5;
            r3 = null;
        L5:
            r1.b(r2, r3, null, null);
        }
    }

    void a(boolean r1, String r2, boolean r3);

    void b(boolean r1, String r2, String r3, String r4);

    void c(boolean r1, String r2, boolean r3);

    boolean d();

    void e(boolean r1, String r2, boolean r3);

    void f(String r1, boolean r2);

    void g(String r1, String r2);

    fa2.c getMessageHandler();

    void onClear();

    void onEvent(o42.b r1);
}
