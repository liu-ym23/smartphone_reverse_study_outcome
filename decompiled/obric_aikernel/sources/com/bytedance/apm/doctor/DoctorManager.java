package com.bytedance.apm.doctor;

import com.bytedance.apm6.util.ListUtils;
import com.bytedance.monitor.util.thread.AsyncTaskType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;
import z3.d;

/* JADX INFO: loaded from: classes.dex */
public class DoctorManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<ApmListener> f934a;

    public interface ApmListener {
        void onDataEvent(int r10, String r11, JSONObject r12);

        void onEvent(String r10, String r11);
    }

    class a implements d {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ List f935c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ String f936g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ String f937h;

        a(DoctorManager r10, List r11, String r12, String r13) {
            this.f935c = r11;
            this.f936g = r12;
            this.f937h = r13;
        }

        @Override // z3.d
        public AsyncTaskType J() {
            return AsyncTaskType.LIGHT_WEIGHT;
        }

        @Override // z3.d
        public String P() {
            return "doctor";
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator r10 = this.f935c.iterator();
        L4:
            if (r10.hasNext() == false) goto L6;
            ((ApmListener) r10.next()).onEvent(this.f936g, this.f937h);
            goto L4
        }
    }

    class b implements d {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ JSONObject f938c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ String f939g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ List f940h;

        b(DoctorManager r10, JSONObject r11, String r12, List r13) {
            this.f938c = r11;
            this.f939g = r12;
            this.f940h = r13;
        }

        @Override // z3.d
        public AsyncTaskType J() {
            return AsyncTaskType.LIGHT_WEIGHT;
        }

        @Override // z3.d
        public String P() {
            return "doctor";
        }

        @Override // java.lang.Runnable
        public void run() {
            JSONObject r10 = this.f938c.getJSONObject("DATA_DOCTOR");     // Catch: Exception -> L8
            r10.put(this.f939g, System.currentTimeMillis());     // Catch: Exception -> L8
            int r11 = r10.optInt("DATA_ID");     // Catch: Exception -> L8
            Iterator r12 = this.f940h.iterator();     // Catch: Exception -> L8
        L4:
            if (r12.hasNext() == false) goto L13;
            ((ApmListener) r12.next()).onDataEvent(r11, this.f939g, this.f938c);     // Catch: Exception -> L8
        L13:
            return;
        }
    }

    private static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final DoctorManager f941a = null;

        static {
            f941a = new DoctorManager(null);
        }

        static /* synthetic */ DoctorManager a() {
            return f941a;
        }
    }

    private DoctorManager() {
        this.f934a = new ArrayList();
    }

    /* synthetic */ DoctorManager(a r10) {
        this();
    }

    public static DoctorManager getInstance() {
        return c.a();
    }

    public void a(String r10, JSONObject r11) {
        if (ListUtils.isEmpty(this.f934a) == true) goto L8;
        if (r11 == null) goto L9;
        ArrayList r12 = new ArrayList(this.f934a);
        z3.a.n().d(new b(this, r11, r10, r12));
        return;
    L9:
        return;
    }

    public void b(String r10, String r11) {
        if (ListUtils.isEmpty(this.f934a) == false) goto L5;
        return;
    L5:
        ArrayList r12 = new ArrayList(this.f934a);
        z3.a.n().d(new a(this, r12, r10, r11));
    }

    public void registerApmListener(ApmListener r10) {
        if (r10 == null) goto L5;
        this.f934a.add(r10);
        return;
    }
}
