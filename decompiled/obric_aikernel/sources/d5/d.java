package d5;

import com.bytedance.common.utility.Logger;
import com.bytedance.ttnet.priority.TTHttpCallPriorityControl;
import com.bytedance.ttnet.throttle.TTNetThrottle;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static String f8500j = "RequestSpeedController";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final String[] f8501k = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<String, Integer> f8502a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Set<String> f8503b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Set<String> f8504c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Set<String> f8505d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Set<String> f8506e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f8507f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private long f8508g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private long f8509h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private long f8510i;

    static {
        f8501k = new String[0];
    }

    public d() {
        this.f8502a = new ConcurrentHashMap();
        this.f8503b = new CopyOnWriteArraySet();
        this.f8504c = new CopyOnWriteArraySet();
        this.f8505d = new CopyOnWriteArraySet();
        this.f8506e = new CopyOnWriteArraySet();
        this.f8507f = -1;
        this.f8508g = -1;
        this.f8509h = -1;
        this.f8510i = -1;
    }

    public void a() {
        if (Logger.debug() == false) goto L6;
        Logger.d(f8500j, "connectionThrottleStart");
        Logger.d(f8500j, "normal_up throttle " + this.f8503b.size() + " speed " + this.f8507f);
        Logger.d(f8500j, "normal_down throttle " + this.f8504c.size() + " speed " + this.f8508g);
        Logger.d(f8500j, "ws_up throttle " + this.f8505d.size() + " speed " + this.f8509h);
        Logger.d(f8500j, "ws_down throttle " + this.f8506e.size() + " speed " + this.f8510i);
    L6:
        if (this.f8503b.size() <= 0) goto L11;
        if (this.f8507f <= 0) goto L11;
        TTNetThrottle.start((String[]) this.f8503b.toArray(f8501k), 1, this.f8507f);
    L11:
        if (this.f8504c.size() <= 0) goto L16;
        if (this.f8508g <= 0) goto L16;
        TTNetThrottle.start((String[]) this.f8504c.toArray(f8501k), 2, this.f8508g);
    L16:
        if (this.f8505d.size() <= 0) goto L21;
        if (this.f8509h <= 0) goto L21;
        TTNetThrottle.start((String[]) this.f8505d.toArray(f8501k), 4, this.f8509h);
    L21:
        if (this.f8506e.size() > 0) goto L23;
        return;
    L23:
        if (this.f8510i <= 0) goto L27;
        TTNetThrottle.start((String[]) this.f8506e.toArray(f8501k), 8, this.f8510i);
        return;
    }

    public void b() {
        Set<String> r10 = this.f8503b;
        String[] r11 = f8501k;
        TTNetThrottle.stop((String[]) r10.toArray(r11), 1);
        TTNetThrottle.stop((String[]) this.f8504c.toArray(r11), 2);
        TTNetThrottle.stop((String[]) this.f8505d.toArray(r11), 4);
        TTNetThrottle.stop((String[]) this.f8506e.toArray(r11), 8);
    }

    public boolean c(JSONObject r10) {
        b();
        this.f8502a.clear();
        JSONObject r11 = r10.optJSONObject("throttle");
        if (r11 != null) goto L6;
        return false;
    L6:
        JSONObject r12 = r11.optJSONObject("request_throttle");
        if (r12 == null) goto L12;
        Iterator<String> r13 = r12.keys();
    L10:
        if (r13.hasNext() == false) goto L12;
        String r14 = r13.next();
        this.f8502a.put(r14, Integer.valueOf(r12.optInt(r14)));
    L12:
        JSONObject r15 = r11.optJSONObject("connection_throttle");
        if (r15 == null) goto L29;
        JSONObject r16 = r15.optJSONObject("normal_up");
        if (r16 == null) goto L17;
        this.f8503b = TTHttpCallPriorityControl.j(r16, "hosts");
        this.f8507f = r16.optInt("speed", -1);
    L17:
        JSONObject r17 = r15.optJSONObject("normal_down");
        if (r17 == null) goto L20;
        this.f8504c = TTHttpCallPriorityControl.j(r17, "hosts");
        this.f8508g = r17.optInt("speed", -1);
    L20:
        JSONObject r18 = r15.optJSONObject("ws_up");
        if (r18 == null) goto L23;
        this.f8505d = TTHttpCallPriorityControl.j(r18, "hosts");
        this.f8509h = r18.optInt("speed", -1);
    L23:
        JSONObject r19 = r15.optJSONObject("ws_down");
        if (r19 == null) goto L30;
        this.f8506e = TTHttpCallPriorityControl.j(r19, "hosts");
        this.f8510i = r19.optInt("speed", -1);
        return true;
    L30:
        return true;
    L29:
        return true;
    }

    public n4.c d(n4.c r10) {
        Integer r11 = TTHttpCallPriorityControl.i(this.f8502a, r10.A());
        if (r11 != null) goto L5;
        return r10;
    L5:
        n4.c.a r12 = r10.O();
        Object r13 = r10.t();
        if (r13 != null) goto L9;
        r13 = new a5.d();
        r12.e(r13);
    L9:
        if ((r13 instanceof o2.c) == false) goto L11;
        long r14 = r11.longValue();
        ((o2.c) r13).f11439t = r14;
    L11:
        r12.e(r13);
        return r12.a();
    }
}
