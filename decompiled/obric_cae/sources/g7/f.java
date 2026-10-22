package g7;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import java.util.ArrayList;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class f extends i {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public e f7729o;

    public f() {
    }

    @Override // g7.i
    public final a.EnumC0079a g(String r8, ArrayList r10) {
        Logger.d("f", "dispatch action " + this.f7729o.f7725a);
        a.EnumC0079a r11 = a.EnumC0079a.f7708a;
        Uri r12 = Uri.parse(r8);
        if (r12.getHost() != null) goto L5;
    L12:
        return r11;
    L5:
        if (d(r12) == false) goto L12;
        e r13 = this.f7729o;
        if (r13 == null) goto L12;
        r11 = a.EnumC0079a.f7709b;
        String r14 = r13.a(r12);
        if (r8.equals(r14) == true) goto L11;
        r10.set(0, r14);
        goto L12
    L11:
        r10.set(0, r8);
        goto L12
    }

    @Override // g7.i
    public final int h() {
        return this.f7729o.f7725a.ordinal();
    }

    @Override // g7.i
    public final boolean i(JSONObject r8, ArrayList r10) {
        e(r8);
        String r11 = r8.optString("service_name");
        if (TextUtils.isEmpty(r11) == true) goto L5;
        this.f7705k = r11;
    L5:
        int r12 = r8.optInt("dispatch_strategy", 0);
        JSONObject r13 = r8.optJSONObject("strategy_info");
        if (r12 >= 0) goto L8;
    L16:
        this.f7729o = null;
        return false;
    L8:
        if (r12 > 5) goto L16;
        e.a r14 = e.a.values()[r12];
        int r15 = e.f7724b;
        if (r14.ordinal() == 1) goto L13;
        Logger.d("e", "dispatch strategy " + r14 + " is not supported, fallback to default strategy");
        e r16 = new b();
    L14:
        this.f7729o = r16;
        r16.b();
        r10.set(0, Boolean.FALSE);
        return true;
    L13:
        r16 = new g(r13);
        goto L14
    }
}
