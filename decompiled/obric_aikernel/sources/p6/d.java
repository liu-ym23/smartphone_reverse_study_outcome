package p6;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class d extends o6.a implements v6.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private File f12334b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile boolean f12335c;

    public d() {
        this.f12334b = null;
        this.f12335c = false;
    }

    private void m(n6.a r10) {
        w6.b r11 = new w6.b(0, false, r10.b(), null);
        r11.h(0);
        r11.i("数据库文件正在处理中");
        u6.a.d(r11);
    }

    @Override // v6.a
    public List<String> a() {
        ArrayList r10 = new ArrayList(1);
        File r11 = this.f12334b;
        if (r11 == null) goto L5;
        r10.add(r11.getAbsolutePath());
    L5:
        return r10;
    }

    @Override // o6.a
    public String f() {
        return "db";
    }

    @Override // o6.a
    public boolean g(n6.a r14) {
        JSONObject r10 = new JSONObject(r14.c());
        if (e(r10, r14) == false) goto L6;
        return true;
    L6:
        if (this.f12335c == false) goto L9;
        m(r14);
        return true;
    L9:
        this.f12335c = true;
        File r11 = null;
        String r12 = r10.optString("db_name", "");     // Catch: Throwable -> L17
        r11 = r6.a.b(k6.a.k().i(), r12);     // Catch: Throwable -> L17
    L11:
        this.f12335c = false;
        if (r11 != null) goto L15;
        k("Sqlite文件拷贝失败", r14);
        return true;
    L15:
        this.f12334b = r11;
        w6.a r13 = new w6.a(r10.optString("fileContentType", "default_db_file_type"), 0, false, r14.b(), this, null);
        r13.r(false);
        r13.s(true);
        u6.a.c(r13);
        return true;
    }
}
