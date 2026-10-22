package k2;

import com.bytedance.ai.bridge.method.floatinginput.InputMode;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public interface t {
    void a(boolean r1);

    void b();

    void c(String r1);

    void d(String r1, String r10);

    void e(String r1);

    void f();

    Object g(String r1, Continuation<? super Unit> r10);

    String getBotId();

    Object h(Continuation<? super Boolean> r1);

    void i(int r1);

    InputMode j();

    Unit k(String r1, boolean r10);

    Object l(String r1, Continuation<? super Unit> r10);

    void m(boolean r1);

    void n(boolean r1, boolean r10);

    void o(InputMode r1);
}
