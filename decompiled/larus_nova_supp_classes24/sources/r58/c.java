package r58;

import com.larus.audio.audiov3.audio.record.AudioRecordState;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public interface c {
    void a(String r1);

    void b(long r1, long r3);

    int c();

    long d(long r1);

    void e(Function0<Unit> r1);

    void f(Function2<? super String, ? super Long, Unit> r1);

    void g(Function2<? super Boolean, ? super String, Unit> r1);

    void h(v58.a r1);

    int i(byte[] r1, int r2);

    void j();

    void k(Function2<? super d, ? super byte[], Unit> r1);

    AudioRecordState l();

    void prepare();

    void release();

    void start();

    void stop();
}
