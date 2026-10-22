package z3;

import com.bytedance.monitor.util.thread.AsyncTaskType;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes.dex */
public interface c extends a4.c {

    public interface a {
        void a(Throwable r10, String r11);
    }

    void a(Throwable r10, String r11);

    void c(a r10);

    void e(ExecutorService r10);

    ExecutorService h();

    long i(AsyncTaskType r10);

    e j();
}
