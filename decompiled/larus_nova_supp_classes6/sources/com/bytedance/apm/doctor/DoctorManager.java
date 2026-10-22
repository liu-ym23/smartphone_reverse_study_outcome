package com.bytedance.apm.doctor;

import f27.d;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
import xu3.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public class DoctorManager {
    public final List<ApmListener> a;

    public interface ApmListener {
        void onDataEvent(int r1, String r2, JSONObject r3);

        void onEvent(String r1, String r2);
    }

    public DoctorManager() {
        this.a = new ArrayList();
    }

    public static DoctorManager getInstance() {
        return c.a;
    }

    public void registerApmListener(ApmListener r2) {
        if (r2 == null) goto L5;
        ((ArrayList) this.a).add(r2);
        return;
    }

    public final void a(String r4, JSONObject r5) {
        if (e.b(this.a) == true) goto L8;
        if (r5 == null) goto L9;
        ArrayList r0 = new ArrayList(this.a);
        Object r1 = d.f;
        d.a.a.h(new b(r5, r4, r0));
        return;
    L9:
        return;
    }

    public final void b(String r4, String r5) {
        if (e.b(this.a) == false) goto L5;
        return;
    L5:
        ArrayList r0 = new ArrayList(this.a);
        Object r1 = d.f;
        d.a.a.h(new a(r0, r4, r5));
    }
}
