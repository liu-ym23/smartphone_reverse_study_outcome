package f4;

import java.util.UUID;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private JSONObject f8849a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private JSONObject f8850b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f8851c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f8852d;

    public d(JSONObject r10, JSONObject r11) {
        this(r10, r11, UUID.randomUUID().toString(), true);
    }

    public d(JSONObject r10, JSONObject r11, String r12, boolean r13) {
        this.f8852d = true;
        this.f8849a = r10;
        this.f8850b = r11;
        this.f8851c = r12;
        this.f8852d = r13;
    }

    public JSONObject a() {
        return this.f8849a;
    }

    public String b() {
        return this.f8851c;
    }

    public JSONObject c() {
        return this.f8850b;
    }

    public boolean d() {
        return this.f8852d;
    }
}
