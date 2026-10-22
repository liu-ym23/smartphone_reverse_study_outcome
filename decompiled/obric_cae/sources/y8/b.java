package y8;

import com.bytedance.common.utility.Logger;
import java.util.HashMap;
import java.util.Observable;

/* JADX INFO: loaded from: classes.dex */
public final class b extends Observable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile b f14092a;

    public b() {
    }

    public final void a(String r8, String r10, String r11) {
        StringBuilder r12 = defpackage.b.i("onStoreIdcChanged idc: ", r8, " region: ", r10, " source: ");
        r12.append(r11);
        Logger.d("CronetDataStorageAccess", r12.toString());
        HashMap r13 = new HashMap();
        r13.put("store_idc", r8);
        r13.put("store_region", r10);
        r13.put("region_source", r11);
        setChanged();
        notifyObservers(r13);
    }
}
