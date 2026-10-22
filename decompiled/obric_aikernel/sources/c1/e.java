package c1;

import android.util.Pair;
import com.bytedance.applog.IBDAccountCallback;
import com.bytedance.applog.monitor.MonitorKey;
import com.bytedance.applog.monitor.MonitorState;
import f1.m;
import i1.i;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class e implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final i1.b f611a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final a1.c f612b;

    class a implements f1.e.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ a1.c f613a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ i1.b f614b;

        a(e r10, a1.c r11, i1.b r12) {
            this.f613a = r11;
            this.f614b = r12;
        }

        @Override // f1.e.b
        public Object a() {
            JSONObject r10 = new JSONObject();
            r10.put("appId", this.f613a.s().getAppId());     // Catch: Throwable -> L5
            r10.put("config", this.f614b.b());     // Catch: Throwable -> L5
        L4:
            return r10;
        }
    }

    public e(a1.c r10, i1.b r11) {
        this.f612b = r10;
        this.f611a = r11;
        m.d("sampling_config", new a(this, r10, r11));
    }

    private i b() {
        i r10 = new i(this.f612b.s().p(), this.f612b.s().getDid(), this.f612b.s().W());
        IBDAccountCallback r11 = this.f612b.s().t();
        if (r11 == null) goto L11;
        Pair<Integer, Long> r12 = r11.getOdinUserInfo();
        if (((Long) r12.second).longValue() <= 0) goto L9;
        r10.f(String.valueOf(r12.second));
        String r13 = String.valueOf(r12.first);
    L7:
        r10.g(r13);
    L12:
        return r10;
    L9:
        if (this.f612b.C().f62d != 0) goto L12;
        r10.f(String.valueOf(this.f612b.C().f60b));
        r13 = String.valueOf(this.f612b.C().f60b);
        goto L7
    L11:
        r10.f(String.valueOf(this.f612b.C().f59a));
        goto L12
    }

    public static e e(a1.c r10, String r11) {
        return new e(r10, i1.c.c(r10.w(), r11));
    }

    public static e f(a1.c r10, JSONObject r11, e r12, String r13) {
        return new e(r10, i1.c.b(r10.w(), r13, r11, r12.c()));
    }

    @Override // c1.d
    public boolean a(MonitorKey r10, String r11, String r12) {
        if (MonitorKey.event_v3.equals(r10) == false) goto L5;
    L8:
        boolean r13 = this.f611a.d(b(), r11, r12);
        if (r13 == false) goto L11;
        this.f612b.s().R().h(r10, MonitorState.f_sampling);
        this.f612b.s().R().m(MonitorKey.sampling_event, r11);
    L11:
        return r13;
    L5:
        if (MonitorKey.log_data.equals(r10) == true) goto L8;
        return false;
    }

    public i1.b c() {
        return this.f611a;
    }

    public int d() {
        return this.f611a.c();
    }
}
