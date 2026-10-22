package x4;

import com.bytedance.common.utility.Logger;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;

/* JADX INFO: loaded from: classes.dex */
public class b extends Observable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile b f13557a;

    static {
    }

    public b() {
    }

    public static b a() {
        if (f13557a != null) goto L15;
        monitor-enter(b.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f13557a != null) goto L9;
        f13557a = new b();     // Catch: Throwable -> L11
    L9:
        monitor-exit(b.class);     // Catch: Throwable -> L11
    L15:
        return f13557a;
    }

    private void b(Map<String, Object> r10) {
        setChanged();
        notifyObservers(r10);
    }

    public void c(String r10, String r11, String r12, String r13, String r14, String r15) {
        if (Logger.debug() == false) goto L5;
        Logger.d("CronetDataStorageAccess", "onStoreIdcChanged idc: " + r10 + " region: " + r11 + " source: " + r12 + " sec_uid:" + r14 + " logid:" + r15);
    L5:
        HashMap r16 = new HashMap();
        r16.put("store_idc", r10);
        r16.put("store_region", r11);
        r16.put("region_source", r12);
        r16.put("region_legacy_user", r13);
        r16.put("sec_uid", r14);
        r16.put("logid", r15);
        b(r16);
    }
}
