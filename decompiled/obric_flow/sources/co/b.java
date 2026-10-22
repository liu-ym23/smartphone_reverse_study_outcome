package co;

import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public final class b extends a {
    public b(HashMap r5) {
        super(r5);
        if (r5.get("reloadBundleStart") == null) goto L6;
        ((Double) r5.get("reloadBundleStart")).getClass();
    L6:
        if (r5.get("reloadBundleEnd") == null) goto L9;
        ((Double) r5.get("reloadBundleEnd")).getClass();
    L9:
        if (r5.get("reloadBackgroundStart") == null) goto L12;
        ((Double) r5.get("reloadBackgroundStart")).getClass();
    L12:
        if (r5.get("reloadBackgroundEnd") == null) goto L15;
        ((Double) r5.get("reloadBackgroundEnd")).getClass();
    L15:
        if (r5.get("ffiStart") == null) goto L18;
        ((Double) r5.get("ffiStart")).getClass();
    L18:
        if (r5.get("ffiEnd") == null) goto L21;
        ((Double) r5.get("ffiEnd")).getClass();
        return;
    }
}
