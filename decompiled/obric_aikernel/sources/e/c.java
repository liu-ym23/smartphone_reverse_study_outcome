package e;

import com.bytedance.apm.internal.ApmDelegate;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class c {
    public static void a(Object r10, boolean r11) {
        if ((r10 instanceof String) == false) goto L5;
        String r12 = (String) r10;
    L6:
        JSONObject r13 = new JSONObject();
        if ((r10 instanceof a) == false) goto L10;
        r13.put("label", ((a) r10).a());     // Catch: Exception -> L19
    L10:
        if (r11 == false) goto L12;
        String r14 = "page_show";
    L13:
        if (r11 == true) goto L15;
    L17:
        f.a.c(r14, r12, r13);
        return;
    L15:
        if (ApmDelegate.j().h().m() == null) goto L17;
        ApmDelegate.j().h().m().a(r12, true);
        goto L17
    L12:
        r14 = "page_hide";
        goto L13
    L5:
        r12 = r10.getClass().getName();
        goto L6
    }
}
