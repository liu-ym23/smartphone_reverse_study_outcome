package r4;

import android.content.Context;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public interface h {

    public static final class a {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void a(h r10, String r11, String r12, String r13, Map r14, int r15) {
            if ((r15 & 8) == 0) goto L5;
            r14 = null;
        L5:
            r10.d(r11, r12, r13, r14, null);
        }
    }

    Object a(Context r1, String r10, Continuation<? super Boolean> r11);

    void b(String r1, String r10);

    Object c(String r1, int r10, String r11, String r12, Continuation<? super Boolean> r13);

    void d(String r1, String r10, String r11, Map<String, String> r12, Function0<Unit> r13);

    Object e(String r1, Continuation<? super String> r10);

    Object f(String r1, String r10, String r11, String r12, Continuation<? super Boolean> r13);

    void g(Map<String, String> r1, Function0<Unit> r10);

    Object h(j2.b r1, Continuation<? super Boolean> r10);

    void i(String r1, String r10, String r11, List<j2.a> r12, List<String> r13, List<String> r14);

    j2.a j(j2.b r1);

    void k(String r1, String r10);

    void l(String r1, String r10);

    void m(String r1, String r10, String r11);
}
