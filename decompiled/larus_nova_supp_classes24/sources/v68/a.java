package v68;

import com.larus.audio.call.aec.w;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import r58.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public interface a {
    void a(String r1);

    void b(int r1);

    void c(long r1, Long r3);

    void d(v58.a r1, Function2<? super d, ? super byte[], Unit> r2);

    void e(Function0<Unit> r1);

    void f(Function2<? super String, ? super Long, Unit> r1);

    void g(Function2<? super Boolean, ? super String, Unit> r1);

    w h();

    void release();

    void setBluetoothForceToMedia(boolean r1);

    boolean start(Function1<? super Exception, Unit> r1);

    void stopRecord();
}
