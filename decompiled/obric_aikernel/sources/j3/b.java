package j3;

/* JADX INFO: loaded from: classes.dex */
public class b extends c.a {

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final b f9758a = null;

        static {
            f9758a = new b();
        }

        static /* synthetic */ b a() {
            return f9758a;
        }
    }

    public b() {
    }

    public static b a() {
        return a.a();
    }

    @Override // j3.c.a, com.bytedance.apm6.util.log.ILogger
    public void e(String r10, String r11) {
        super.e(r10, r11);
        j3.a.d(r10, r11, null);
    }

    @Override // j3.c.a, com.bytedance.apm6.util.log.ILogger
    public void e(String r10, String r11, Throwable r12) {
        super.e(r10, r11, r12);
        j3.a.d(r10, r11, r12);
    }

    @Override // j3.c.a, com.bytedance.apm6.util.log.ILogger
    public void wtf(String r10, String r11) {
        super.wtf(r10, r11);
        j3.a.d(r10, r11, null);
    }

    @Override // j3.c.a, com.bytedance.apm6.util.log.ILogger
    public void wtf(String r10, String r11, Throwable r12) {
        super.wtf(r10, r11, r12);
        j3.a.d(r10, r11, r12);
    }
}
