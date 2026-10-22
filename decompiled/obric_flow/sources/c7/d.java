package c7;

import android.util.Log;
import com.bytedance.apm.j;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class d implements z6.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f1134a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap f1135b;

    public d() {
        this.f1135b = new HashMap();
        this.f1134a = true;
        z6.b.f23409a.a(this);
    }

    @Override // z6.c
    public final void a(long r11) {
        HashMap r5 = this.f1135b;
        if (r5.isEmpty() == true) goto L35;
        Iterator r10 = r5.entrySet().iterator();
        int r12 = com.bytedance.apm.util.e.f3911b;
    L6:
        if (r10.hasNext() == false) goto L48;
        Map.Entry r13 = (Map.Entry) r10.next();
        String r14 = (String) r13.getKey();
        b r15 = (b) r13.getValue();
        if ((r11 - r15.f1132c) <= 120000) goto L6;
        r10.remove();
        int r16 = r15.d;
        if (r16 <= 0) goto L12;
        float r17 = r15.f1131b / r16;
    L14:
        if (j.f3887a == false) goto L17;
        Log.i("<monitor><perf>", com.bytedance.android.anniex.base.service.f.o(new String[]{"aggregate fps: " + r14 + " , value: " + r17}));
    L17:
        if (r17 <= 0.0f) goto L6;
        float r18 = r12;
        if (r17 <= r18) goto L37;
        r17 = r18;
    L37:
        JSONObject r19 = new JSONObject();     // Catch: Exception -> L36
        r19.put("fps", r17);     // Catch: Exception -> L36
        JSONObject r20 = new JSONObject();     // Catch: Exception -> L36
        r20.put("scene", r14);     // Catch: Exception -> L36
        j6.e r21 = new j6.e("fps", r14, r19, r20, null);     // Catch: Exception -> L36
        JSONObject r22 = q7.a.k().m(true);     // Catch: Exception -> L36
        r21.d = r22;     // Catch: Exception -> L36
        r22.put("refresh_rate", r12);     // Catch: Exception -> L36
        if (this.f1134a == false) goto L25;
        this.f1134a = false;     // Catch: Exception -> L36
        r22.put("device_max_refresh_rate", com.bytedance.apm.util.e.f3912c);     // Catch: Exception -> L36
        r22.put("refresh_rate_restricted", true ^ com.bytedance.apm.util.e.d);     // Catch: Exception -> L36
    L25:
        HashMap r23 = r15.f1130a;
        if (r23 != null) goto L28;
    L33:
        i6.a.i().b(r21);     // Catch: Exception -> L36
        goto L6
    L28:
        if (r23.isEmpty() == true) goto L33;
        Iterator r24 = r23.entrySet().iterator();     // Catch: Exception -> L36
    L31:
        if (r24.hasNext() == false) goto L33;
        Map.Entry r25 = (Map.Entry) r24.next();     // Catch: Exception -> L36
        r21.d.put((String) r25.getKey(), r25.getValue());     // Catch: Exception -> L36
        goto L31
    L12:
        r17 = -1.0f;
        goto L14
    L48:
        return;
    }
}
