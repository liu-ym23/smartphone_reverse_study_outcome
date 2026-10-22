package y3;

import com.ivy.ivykit.api.plugin.IIvyHybridMonitorService;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a {
    public final String a;
    public final com.ivy.ivykit.api.plugin.a b;

    /* JADX INFO: renamed from: y3.a$a, reason: collision with other inner class name */
    public static final class C0214a {
    }

    static {
    }

    public a(String r1) {
        if (r1 != null) goto L5;
        r1 = "";
    L5:
        this.a = r1;
        this.b = IIvyHybridMonitorService.a.a();
        new JSONObject();
    }
}
