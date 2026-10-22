package b9a;

import com.bytedance.news.common.service.manager.ServiceManager;
import com.bytedance.services.slardar.config.IConfigListener;
import com.bytedance.services.slardar.config.IConfigManager;
import com.monitor.cloudmessage.entity.CloudMessageException;
import java.io.PrintWriter;
import java.io.StringWriter;
import org.json.JSONObject;
import z8a.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class c$a implements IConfigListener {
    public final /* synthetic */ a a;
    public final /* synthetic */ c b;

    public final void onReady() {
    }

    public c$a(c r1, a r2) {
        this.b = r1;
        this.a = r2;
    }

    public final void onRefresh(JSONObject r4, boolean r5) {
        c.i(this.b, r4, this.a);     // Catch: Exception -> L4 Throwable -> L6 CloudMessageException -> L8
    L10:
        ((IConfigManager) ServiceManager.getService(IConfigManager.class)).unregisterConfigListener(this);
        return;
    L6:
        th = move-exception;
        ((IConfigManager) ServiceManager.getService(IConfigManager.class)).unregisterConfigListener(this);
        throw th;
    L4:
        e = move-exception;
        StringWriter r1 = new StringWriter();     // Catch: Throwable -> L6
        e.printStackTrace(new PrintWriter(r1));     // Catch: Throwable -> L6
        String r6 = String.format("系统错误：%s", new Object[]{r1.toString()});     // Catch: Throwable -> L6
        c r7 = this.b;     // Catch: Throwable -> L6
        a r0 = this.a;     // Catch: Throwable -> L6
        r7.getClass();     // Catch: Throwable -> L6
        a9a.a.h(r6, r0);     // Catch: Throwable -> L6
    L8:
        e = move-exception;
        c r8 = this.b;     // Catch: Throwable -> L6
        String r9 = e.getMessage();     // Catch: Throwable -> L6
        a r2 = this.a;     // Catch: Throwable -> L6
        r8.getClass();     // Catch: Throwable -> L6
        a9a.a.h(r9, r2);     // Catch: Throwable -> L6
        goto L10
    }
}
