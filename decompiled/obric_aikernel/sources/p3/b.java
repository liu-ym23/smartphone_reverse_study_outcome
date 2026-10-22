package p3;

import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final InterfaceC0275b f12318a = null;

    static class a implements InterfaceC0275b {
        a() {
        }

        @Override // p3.b.InterfaceC0275b
        public void a(Runnable r10, String r11) {
            z3.d r12 = z3.b.d(r11, r10);
            z3.b.a().d(r12);
        }
    }

    /* JADX INFO: renamed from: p3.b$b, reason: collision with other inner class name */
    public interface InterfaceC0275b {
        void a(Runnable r10, String r11);
    }

    static {
        Executors.newScheduledThreadPool(1, new f("CheckToDump"));
        f12318a = new a();
    }
}
