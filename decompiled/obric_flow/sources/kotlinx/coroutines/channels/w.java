package kotlinx.coroutines.channels;

import java.util.concurrent.CancellationException;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* JADX INFO: loaded from: classes3.dex */
public interface w {
    Object a(ContinuationImpl r5);

    void cancel(CancellationException r5);

    com.bytedance.ies.web.jsbridge2.p h();

    com.bytedance.ies.web.jsbridge2.p i();

    k iterator();

    Object j();

    Object l(Continuation r5);
}
