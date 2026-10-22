package v4;

import androidx.annotation.Nullable;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class c implements w.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final JSONObject f13186a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f13187b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f13188c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f13189d;

    public c(JSONObject r10, String r11, boolean r12, String r13) {
        this.f13186a = r10;
        this.f13187b = r11;
        this.f13188c = r12;
        this.f13189d = r13;
    }

    @Override // w.b
    public String a() {
        return this.f13189d;
    }

    @Override // w.b
    public boolean b(JSONObject r10) {
        if ("app_launch_trace".equals(this.f13187b) == false) goto L7;
        return o0.c.c("start_trace");
    L7:
        if (b.a().b(this.f13188c, this.f13187b) == 0) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // w.b
    @Nullable
    public JSONObject c() {
        return this.f13186a;
    }

    @Override // w.b
    public boolean d() {
        return false;
    }

    @Override // w.b
    public String e() {
        return "tracing";
    }
}
