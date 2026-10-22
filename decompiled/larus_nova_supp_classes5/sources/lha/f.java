package lha;

import com.obric.assistant.system.IDeviceLockedStateService;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class f {
    public static final Lazy a = null;

    static {
        a = LazyKt.lazy(new e());
    }

    public static final IDeviceLockedStateService a() {
        return (IDeviceLockedStateService) a.getValue();
    }
}
