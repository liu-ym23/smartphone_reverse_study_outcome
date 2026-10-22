package d5;

import android.content.SharedPreferences;
import org.json.JSONObject;
import x4.j0;
import x4.x0;

/* JADX INFO: loaded from: classes.dex */
public final class w extends d {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final j0 f6829e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final x4.s f6830f;

    public w(j0 r8, x4.s r10) {
        this.f6829e = r8;
        this.f6830f = r10;
    }

    @Override // d5.d
    public final boolean a(JSONObject r14) {
        x4.s r8 = this.f6830f;
        j0 r13 = this.f6829e;
        SharedPreferences r10 = r8.a(r13);
        String r15 = ((i5.a) i5.d.a(i5.a.class, String.valueOf(r13.f13463a))).getDeviceId();
        String r11 = r10.getString("bd_did", null);
        String r12 = r10.getString("install_id", null);
        String r16 = r10.getString("ssid", null);
        String r17 = r10.getString("klink_edi", null);
        String r18 = r10.getString("klink_eii", null);
        String r19 = r10.getString("klink_egdi", null);
        int r20 = x4.r.f13543a;
        x0.h(r14, "install_id", r12);
        x0.h(r14, "device_id", r15);
        x0.h(r14, "ssid", r16);
        x0.h(r14, "bd_did", r11);
        x0.h(r14, "klink_edi", r17);
        x0.h(r14, "klink_eii", r18);
        x0.h(r14, "klink_egdi", r19);
        return true;
    }

    @Override // d5.d
    public final void b(JSONObject r8) {
        r8.remove("bd_did");
        r8.remove("install_id");
        r8.remove("ssid");
        r8.remove("device_id");
        r8.remove("klink_edi");
        r8.remove("klink_eii");
    }
}
