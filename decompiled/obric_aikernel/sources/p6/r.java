package p6;

import android.text.TextUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class r extends o6.a implements v6.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private m6.j f12352b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private File f12353c;

    public r() {
        this.f12353c = null;
    }

    @Override // v6.a
    public List<String> a() {
        ArrayList r10 = new ArrayList(1);
        File r11 = this.f12353c;
        if (r11 == null) goto L5;
        r10.add(r11.getAbsolutePath());
    L5:
        return r10;
    }

    @Override // o6.a
    public String f() {
        return "custom";
    }

    @Override // o6.a
    public boolean g(n6.a r14) {
        String r10 = r14.c();
        if (this.f12352b != null) goto L6;
        return false;
    L6:
        JSONObject r11 = new JSONObject(r10);
        if (e(r11, r14) == false) goto L9;
        return true;
    L9:
        JSONObject r12 = r11.optJSONObject("template");
        if (r12 != null) goto L14;
        String r13 = "template字段异常";
    L12:
        k(r13, r14);
        return true;
    L14:
        r11.put("cloud_command_id", r14.b());
        String r15 = this.f12352b.j(r12);
        n6.b r16 = this.f12352b.c();
        if (r16.d() == true) goto L17;
        j(r16.b(), r16.c(), r14);
    L27:
        return true;
    L17:
        if (TextUtils.isEmpty(r15) == false) goto L19;
        r15 = "{\"result\" : \"no one handle it.\"}";
    L19:
        File r17 = r6.i.a(k6.a.k().i(), r15);
        if (r17 != null) goto L22;
        r13 = "template文件生成异常";
        goto L12
    L22:
        this.f12353c = r17;
        String r18 = r11.optString("fileContentType", "");
        if (TextUtils.isEmpty(r18) == false) goto L25;
        r18 = r12.optString("fileContentType", "template_file_type");
    L25:
        u6.a.c(new w6.a(r18, 0, false, r14.b(), this, r16.c()));
        goto L27
    }

    public void m(m6.j r10) {
        this.f12352b = r10;
    }
}
