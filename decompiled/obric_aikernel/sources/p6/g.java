package p6;

import android.os.Debug;
import android.text.TextUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class g extends o6.a implements v6.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private File f12337b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f12338c;

    public g() {
        this.f12337b = null;
        this.f12338c = 0;
    }

    @Override // v6.a
    public List<String> a() {
        ArrayList r10 = new ArrayList(1);
        File r11 = this.f12337b;
        if (r11 == null) goto L5;
        r10.add(r11.getAbsolutePath());
    L5:
        return r10;
    }

    @Override // o6.a
    public String f() {
        return "heap_oom";
    }

    @Override // o6.a
    public boolean g(n6.a r14) {
        JSONObject r10 = new JSONObject(r14.c());
        if (e(r10, r14) == false) goto L6;
        return true;
    L6:
        if ((System.currentTimeMillis() - this.f12338c) >= 300000) goto L8;
        return false;
    L8:
        this.f12338c = System.currentTimeMillis();
        boolean r11 = r10.optBoolean("isTryToCatch", false);
        String r12 = k6.a.j();
        String r13 = "本地未设置dumpFileName";
        if (TextUtils.isEmpty(r12) == false) goto L12;
        k("本地未设置dumpFileName", r14);
        return true;
    L12:
        if (r11 == true) goto L30;
    L17:
        File r15 = new File(r12);
        if (TextUtils.isEmpty(r12) == true) goto L22;
        r13 = null;
    L22:
        if (r15.exists() == true) goto L25;
        r13 = "dumpFile不存在";
    L25:
        if (TextUtils.isEmpty(r13) == true) goto L28;
        k(r13, r14);
        return true;
    L28:
        this.f12337b = r15;
        w6.a r16 = new w6.a("log_heap_oom", 0, false, r14.b(), this, null);
        r16.r(true);
        u6.a.c(r16);
        return true;
    L30:
        Debug.dumpHprofData(r12);     // Catch: Exception -> L15
    L15:
        e = move-exception;
        e.printStackTrace();
        goto L17
    }
}
