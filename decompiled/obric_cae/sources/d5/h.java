package d5;

import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;
import x4.j0;

/* JADX INFO: loaded from: classes.dex */
public final class h extends d {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final j0 f6792e;

    public h(j0 r8) {
        super(false, true);
        this.f6792e = r8;
    }

    @Override // d5.d
    public final boolean a(JSONObject r8) {
        Map<String, Object> r10 = this.f6792e.f13474l;
        if (r10 == null) goto L26;
    L14:
        e = move-exception;
        e.printStackTrace();
        return true;
    L5:
        if (r10.isEmpty() == true) goto L27;
        Iterator<Map.Entry<String, Object>> r11 = r10.entrySet().iterator();     // Catch: Exception -> L14
    L8:
        if (r11.hasNext() == false) goto L28;
        Map.Entry<String, Object> r12 = r11.next();     // Catch: Exception -> L14
        if (r12 == null) goto L8;
        r8.put(r12.getKey(), r12.getValue());     // Catch: Exception -> L14
        goto L8
    L28:
        return true;
    L27:
        return true;
    L26:
        return true;
    }
}
