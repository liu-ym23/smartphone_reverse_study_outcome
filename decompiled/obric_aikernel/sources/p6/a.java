package p6;

import android.text.TextUtils;
import com.bytedance.crash.entity.EventBody;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class a extends o6.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private m6.a f12328b;

    public a() {
    }

    @Override // o6.a
    public String f() {
        return "abtest";
    }

    @Override // o6.a
    public boolean g(n6.a r10) {
        JSONObject r11 = new JSONObject(r10.c());
        if (this.f12328b != null) goto L6;
        return false;
    L6:
        if (e(r11, r10) == false) goto L8;
        return true;
    L8:
        String r12 = r11.optString("field");
        if (TextUtils.isEmpty(r12) == false) goto L11;
        return false;
    L11:
        Object r13 = r11.get(EventBody.KEY_VALUE);
        this.f12328b.h(r12, r13);
        if (this.f12328b.g() == false) goto L14;
        String r14 = r11.optString("spKey");
        this.f12328b.i(r14, r13);
    L14:
        n6.b r15 = this.f12328b.c();
        if (r15.d() == false) goto L17;
        l(r10);
    L18:
        return true;
    L17:
        j(r15.b(), r15.c(), r10);
        goto L18
    }

    public void m(m6.a r10) {
        this.f12328b = r10;
    }
}
