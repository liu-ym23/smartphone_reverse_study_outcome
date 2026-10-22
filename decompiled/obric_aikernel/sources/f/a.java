package f;

import com.bytedance.apm6.util.constant.CommonConsts;
import org.json.JSONObject;
import y.e;
import y.f;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: f.a$a, reason: collision with other inner class name */
    static class RunnableC0165a implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f8773c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ String f8774g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ JSONObject f8775h;

        RunnableC0165a(String r10, String r11, JSONObject r12) {
            this.f8773c = r10;
            this.f8774g = r11;
            this.f8775h = r12;
        }

        @Override // java.lang.Runnable
        public void run() {
            x.a.p().e(new f(this.f8773c, this.f8774g, this.f8775h, null));
        }
    }

    static class b implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f8776c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ JSONObject f8777g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ JSONObject f8778h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ JSONObject f8779i;

        b(String r10, JSONObject r11, JSONObject r12, JSONObject r13) {
            this.f8776c = r10;
            this.f8777g = r11;
            this.f8778h = r12;
            this.f8779i = r13;
        }

        @Override // java.lang.Runnable
        public void run() {
            e r10 = new e(this.f8776c, "", this.f8777g, this.f8778h, this.f8779i);
            x.a.p().e(r10);
        }
    }

    static class c implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ JSONObject f8780c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ JSONObject f8781g;

        c(JSONObject r10, JSONObject r11) {
            this.f8780c = r10;
            this.f8781g = r11;
        }

        @Override // java.lang.Runnable
        public void run() {
            e r10 = new e(CommonConsts.APM_INNER_EVENT_COST_START, "", this.f8780c, null, this.f8781g);
            x.a.p().e(r10);
        }
    }

    static class d implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f8782c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ long f8783g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ String f8784h;

        d(String r10, long r11, String r12) {
            this.f8782c = r10;
            this.f8783g = r11;
            this.f8784h = r12;
        }

        @Override // java.lang.Runnable
        public void run() {
            JSONObject r10 = new JSONObject();     // Catch: Exception -> L4
            r10.put(this.f8782c, this.f8783g);     // Catch: Exception -> L4
            JSONObject r11 = new JSONObject();     // Catch: Exception -> L4
            r11.put("scene", this.f8784h);     // Catch: Exception -> L4
            e r12 = new e("page_load", "page_load", r10, r11, null);     // Catch: Exception -> L4
            x.a.p().e(r12);     // Catch: Exception -> L4
            return;
        }
    }

    public static void a(String r10, JSONObject r11, JSONObject r12, JSONObject r13) {
        q0.b.f().i(new b(r10, r11, r12, r13));
    }

    public static void b(JSONObject r10, long r11, long r12) {
        JSONObject r13 = new JSONObject();     // Catch: Exception -> L4
        r13.put("begin_time", r11);     // Catch: Exception -> L4
        r13.put("end_time", r12);     // Catch: Exception -> L4
        r13.put("from", CommonConsts.API_CALL_FROM_PLUGIN);     // Catch: Exception -> L4
        q0.b.f().i(new c(r10, r13));     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    public static void c(String r10, String r11, JSONObject r12) {
        q0.b.f().i(new RunnableC0165a(r10, r11, r12));
    }

    public static void d(String r10, String r11, long r12) {
        q0.b.f().i(new d(r11, r12, r10));
    }
}
