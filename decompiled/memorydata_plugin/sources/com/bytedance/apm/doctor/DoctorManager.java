package com.bytedance.apm.doctor;

import com.bytedance.apm6.util.ListUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class DoctorManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f1296a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private List<ApmListener> f1297b;
    private boolean c;

    public interface ApmListener {
        void onDataEvent(int r1, String r2, JSONObject r3);

        void onEvent(String r1, String r2);
    }

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final DoctorManager f1302a = null;

        static {
            f1302a = new DoctorManager(null);
        }

        static /* synthetic */ DoctorManager a() {
            return f1302a;
        }
    }

    private DoctorManager() {
        this.f1296a = "doctor";
        this.f1297b = new ArrayList();
        this.c = false;
    }

    /* synthetic */ DoctorManager(AnonymousClass1 r1) {
        this();
    }

    public static DoctorManager getInstance() {
        return a.a();
    }

    public void a(final String r4, final String r5) {
        if (ListUtils.isEmpty(this.f1297b) == false) goto L5;
        return;
    L5:
        final ArrayList r0 = new ArrayList(this.f1297b);
        com.bytedance.monitor.util.thread.a.a().a(new AnonymousClass1(this, r0, r4, r5));
    }

    public void a(final String r4, final JSONObject r5) {
        if (ListUtils.isEmpty(this.f1297b) == true) goto L8;
        if (r5 == null) goto L9;
        final ArrayList r0 = new ArrayList(this.f1297b);
        com.bytedance.monitor.util.thread.a.a().a(new AnonymousClass2(this, r5, r4, r0));
        return;
    L9:
        return;
    }
}
