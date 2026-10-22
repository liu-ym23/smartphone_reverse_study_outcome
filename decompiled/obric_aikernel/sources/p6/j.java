package p6;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class j extends o6.a implements v6.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private File f12346b;

    public j() {
        this.f12346b = null;
    }

    @Override // v6.a
    public List<String> a() {
        ArrayList r10 = new ArrayList(1);
        File r11 = this.f12346b;
        if (r11 == null) goto L5;
        r10.add(r11.getAbsolutePath());
    L5:
        return r10;
    }

    @Override // o6.a
    public String f() {
        return "network";
    }

    @Override // o6.a
    public boolean g(n6.a r11) {
        if (e(new JSONObject(r11.c()), r11) == false) goto L5;
        return true;
    L5:
        File r10 = r6.e.a(k6.a.k().i(), new JSONObject(r11.c()));
        if (r10 != null) goto L9;
        k("网络信息文件生成失败", r11);
        return true;
    L9:
        this.f12346b = r10;
        u6.a.c(new w6.a("json", 0, false, r11.b(), this, null));
        return true;
    }
}
