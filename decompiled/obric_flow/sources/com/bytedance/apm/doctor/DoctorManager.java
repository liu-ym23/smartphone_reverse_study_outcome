package com.bytedance.apm.doctor;

import java.util.ArrayList;
import l6.b;
import org.json.JSONObject;
import td.d;

/* JADX INFO: loaded from: classes2.dex */
public class DoctorManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ArrayList f3865a;

    public interface ApmListener {
        void onDataEvent(int r5, String r10, JSONObject r11);

        void onEvent(String r5, String r10);
    }

    public static DoctorManager getInstance() {
        return b.f19542a;
    }

    public final void a(String r5, String r10) {
        ArrayList r11 = this.f3865a;
        if (d.d(r11) == false) goto L5;
        return;
    L5:
        ArrayList r12 = new ArrayList(r11);
        mg.a.f20082a.f(new a(r5, r10, r12));
    }
}
