package j4;

import com.bytedance.ai.bridge.ContainerType;
import com.bytedance.ai.bridge.protocol.model.ProtocolMessage;
import d3.a0;
import m4.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public interface a {
    public static final C0167a a = null;

    /* JADX INFO: renamed from: j4.a$a, reason: collision with other inner class name */
    public static final class C0167a {
        public static final /* synthetic */ C0167a a = null;
        public static a b;

        static {
            a = new C0167a();
        }

        public C0167a() {
        }

        public static a a() {
            if (b != null) goto L6;
            com.bytedance.ai.applet.base.log.a.d("ai_bridge", "bridge monitor is not registered!", null);
        L6:
            return b;
        }
    }

    static {
        a = C0167a.a;
    }

    void a(String r1);

    void b(String r1, ProtocolMessage r10);

    void c(String r1);

    void d(String r1);

    void e(String r1, long r10);

    void f(String r1, a0 r10, String r11);

    void g(String r1, long r10, a0 r11, String r12, c r13);

    void h(String r1);

    void i(String r1, c r10);

    void j(String r1);

    void k(String r1, ContainerType r10);

    void l(String r1, c r10);

    void markError(String r1);
}
