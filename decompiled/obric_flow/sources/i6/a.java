package i6;

import com.bytedance.android.anniex.base.service.f;
import com.bytedance.apm.j;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends h6.a {
    public static volatile a d;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public com.bytedance.frameworks.baselib.network.http.cronet.b f17504c;

    public static a i() {
        if (d != null) goto L16;
        monitor-enter(a.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (d != null) goto L11;
        d = new a();     // Catch: Throwable -> L9
    L11:
        monitor-exit(a.class);     // Catch: Throwable -> L9
    L16:
        return d;
    }

    @Override // h6.a
    public final void c(h6.b r10) {
        JSONObject r5 = r10.c();
        boolean r11 = r10.b(r5);
        if (j.f3887a == true) goto L18;
    L8:
        if (r11 == false) goto L10;
    L12:
        h6.a.h(r10.e(), r10.a(), r5, r11, false);
        if (this.f17504c == null) goto L20;
        String r12 = r10.a();
        if (v6.b.f22516a.f22517a == false) goto L21;
        "image_monitor_v2".equals(r12);
        return;
    L21:
        return;
    L20:
        return;
    L10:
        if (r10.d() == true) goto L12;
        return;
    L18:
        f.w(new Object[]{"logType: " + r10.e() + ", subType: " + r10.a() + "data: " + r5, " ,sample: " + r11});     // Catch: Exception -> L6
    L6:
        e = move-exception;
        e.printStackTrace();
        goto L8
    }
}
