package btb;

import com.ss.android.lark.notification.export.AbstractNotification;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class e {
    public final Map<Integer, AbstractNotification> a;
    public final c b;

    public e(c r2) {
        this.a = new ConcurrentHashMap();
        this.b = r2;
    }
}
