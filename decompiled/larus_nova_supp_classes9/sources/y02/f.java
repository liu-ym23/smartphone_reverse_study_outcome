package y02;

import com.bytedance.android.livesdk.gift.platform.business.normal.model.NormalGiftMessage;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public interface f<T> {
    void a(Function1<? super T, Unit> r1);

    int b();

    void c(com.bytedance.android.livesdk.gift.platform.business.tray2.manager.a r1);

    void clear();

    boolean d(NormalGiftMessage r1);

    g<T> iterator();

    T pollFirst();

    void put(T r1);

    void putFirst(T r1);

    int size();
}
