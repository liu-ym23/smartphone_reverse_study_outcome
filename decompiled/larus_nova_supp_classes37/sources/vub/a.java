package vub;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class a {
    public static final Object a = null;
    public static long b;

    static {
        a = new Object();
    }

    public static String b(String r2) {
        return "len=" + r2.length() + ",hash=" + r2.hashCode();
    }

    public static void a(String r3, long r4) {
        Object r0 = a;
        monitor-enter(r0);
        monitor-exit(r0);
        lvb.a.e("MmD1204RuntimeStartup", "[tryStart] skip, trigger=user_scope_ready, user=" + b(r3) + ", generation=" + r4);
    }
}
