package s4;

import com.bytedance.retrofit2.RetrofitMetrics;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public interface b {
    void a(n4.c r10, RetrofitMetrics r11);

    void b(n4.c r10);

    default n4.c c(n4.c r10) {
        return r10;
    }

    boolean d(n4.c r10, RetrofitMetrics r11, Executor r12, Runnable r13);
}
