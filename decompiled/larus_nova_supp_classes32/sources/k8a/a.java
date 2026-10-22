package k8a;

import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class a {
    public HashMap<String, String> a;

    public a() {
        this.a = new HashMap();
    }

    public boolean update(String r2, String r3) {
        if (r2 != null) goto L4;
        return false;
    L4:
        if (r2.isEmpty() == false) goto L6;
        return false;
    L6:
        if (r2.startsWith("__") == true) goto L17;
        if (r3 != null) goto L10;
        this.a.remove(r2);
        return true;
    L10:
        this.a.put(r2, r3);
        return true;
    L17:
        return false;
    }
}
