package p6;

import com.bytedance.common.wschannel.WsConstants;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class q extends o6.a implements v6.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private File f12351b;

    public q() {
        this.f12351b = null;
    }

    @Override // v6.a
    public List<String> a() {
        ArrayList r10 = new ArrayList();
        File r11 = this.f12351b;
        if (r11 == null) goto L5;
        r10.add(r11.getAbsolutePath());
    L5:
        return r10;
    }

    @Override // o6.a
    public String f() {
        return "stat";
    }

    @Override // o6.a
    public boolean g(n6.a r13) {
        JSONObject r10 = new JSONObject(r13.c());
        String r11 = r10.optString(WsConstants.KEY_CONNECTION_TYPE, "system_info");
        if (e(r10, r13) == false) goto L5;
        return true;
    L5:
        JSONObject r12 = new JSONObject();
        if ("all".equals(r11) == false) goto L9;
        r12.put("all", new q6.a().a());
    L14:
        File r14 = r6.h.a(k6.a.k().i(), r12);
        if (r14 != null) goto L18;
        k("系统信息文件生成失败", r13);
        return true;
    L18:
        this.f12351b = r14;
        u6.a.c(new w6.a("json", 0, false, r13.b(), this, null));
        return true;
    L9:
        if ("stack_info".equals(r11) == true) goto L14;
        if ("system_info".equals(r11) == false) goto L14;
        r12.put("system_info", new q6.a().a());
        goto L14
    }
}
