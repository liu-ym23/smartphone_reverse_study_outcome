package h68;

import com.larus.audio.audiov3.task.asr.AsrState;
import com.larus.audio.report.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public interface e {
    int a(byte[] r1, int r2);

    boolean b();

    void c(String r1, Object r2, Object r3, Object r4);

    void cancel();

    AsrState d();

    long e();

    void f(d r1);

    void g(h r1);

    y58.a getConfig();

    String getTaskId();

    void release();

    void start();

    void stop();
}
