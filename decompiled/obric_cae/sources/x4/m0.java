package x4;

import android.text.TextUtils;
import com.bytedance.bdlocation.client.LocationInfoConst;

/* JADX INFO: loaded from: classes.dex */
public final class m0 implements Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f13529a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f13530b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final String f13531m;

    public m0(String r8, String r10) {
        this.f13531m = "";
        b(r8);
        this.f13529a = r8;
        b(r10);
        this.f13530b = r10;
    }

    public static m0 a(String r8, boolean r10) {
        String r11 = r8.concat("/service/2/device_register/");
        String r12 = r8.concat("/service/2/app_alert_check/");
        if (r10 == false) goto L7;
        return new m0(r11, r12, r8.concat("/service/1/client_context/"));
    L7:
        return new m0(r11, r12);
    }

    public static void b(String r8) {
        if (TextUtils.isEmpty(r8) == false) goto L5;
        return;
    L5:
        if (r8.startsWith(LocationInfoConst.HTTPS) == false) goto L8;
        return;
    L8:
        throw new IllegalArgumentException("url protocol should be https");
    }

    public final boolean equals(Object r8) {
        if (r8 != this) goto L6;
        return true;
    L6:
        if ((r8 instanceof m0) == false) goto L16;
        m0 r10 = (m0) r8;
        String r11 = r10.f13530b;
        if (TextUtils.equals(this.f13530b, r11) == false) goto L15;
        if (TextUtils.equals(this.f13529a, r10.f13529a) == false) goto L15;
        if (TextUtils.equals(this.f13531m, r10.f13531m) == false) goto L15;
        return true;
    L15:
        return false;
    L16:
        return false;
    }

    public final String toString() {
        StringBuilder r8 = new StringBuilder("{r='");
        r8.append(this.f13529a);
        r8.append("', a='");
        r8.append(this.f13530b);
        r8.append("', v='");
        return android.aimedia.a.i(r8, this.f13531m, "'}");
    }

    public m0(String r8, String r10, String r11) {
        this.f13531m = "";
        b(r8);
        this.f13529a = r8;
        b(r10);
        this.f13530b = r10;
        b(r11);
        this.f13531m = r11;
    }
}
