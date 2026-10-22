package e;

import com.bytedance.apm.internal.ApmDelegate;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class b {
    public static void a(Object r10, boolean r11) {
        if (h.a.f9124a == true) goto L6;
        return;
    L6:
        if ((r10 instanceof String) == false) goto L8;
        String r12 = (String) r10;
    L9:
        JSONObject r13 = new JSONObject();
        if ((r10 instanceof a) == false) goto L13;
        r13.put("label", ((a) r10).a());     // Catch: Exception -> L22
    L13:
        if (r11 == false) goto L15;
        String r14 = "page_show";
    L16:
        if (r11 == true) goto L18;
    L20:
        f.a.c(r14, r12, r13);
        return;
    L18:
        if (ApmDelegate.j().h().m() == null) goto L20;
        ApmDelegate.j().h().m().a(r12, true);
        goto L20
    L15:
        r14 = "page_hide";
        goto L16
    L8:
        r12 = r10.getClass().getName();
        goto L9
    }
}
