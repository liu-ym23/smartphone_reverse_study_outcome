package kga;

import com.obric.assistant.spi.common.IObricUtilService;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class b {
    public static final Lazy a = null;

    static {
        a = LazyKt.lazy(new a());
    }

    public static final IObricUtilService a() {
        return (IObricUtilService) a.getValue();
    }
}
