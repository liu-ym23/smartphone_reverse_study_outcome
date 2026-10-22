package o2;

import com.bytedance.retrofit2.RetrofitMetrics;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<c.b> f11480a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f11481b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List<a> f11482c;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f11483a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f11484b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f11485c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f11486d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public long f11487e;

        public a(String r10, String r11, int r12, long r13, long r14, boolean r15) {
            this.f11483a = r10;
            this.f11484b = r11;
            this.f11485c = r12;
            this.f11486d = r13;
            this.f11487e = r14;
        }
    }

    public i(List<c.b> r10) {
        ArrayList r11 = new ArrayList();
        this.f11480a = r11;
        this.f11481b = 0;
        this.f11482c = new CopyOnWriteArrayList();
        if (r10 != null) goto L5;
        return;
    L5:
        if (r10.isEmpty() == true) goto L10;
        r11.addAll(r10);
        return;
    }

    public JSONObject a() {
        if (this.f11482c.isEmpty() == false) goto L6;
        return null;
    L6:
        JSONObject r10 = new JSONObject();
        Iterator<a> r11 = this.f11482c.iterator();     // Catch: JSONException -> L13
    L9:
        if (r11.hasNext() == false) goto L12;
        a r12 = r11.next();     // Catch: JSONException -> L13
        JSONObject r13 = new JSONObject();     // Catch: JSONException -> L13
        r13.put("callback_duration", r12.f11486d);     // Catch: JSONException -> L13
        r13.put("request_duration", r12.f11487e);     // Catch: JSONException -> L13
        r13.put("code", r12.f11485c);     // Catch: JSONException -> L13
        r10.put(r12.f11483a + r12.f11484b, r13);     // Catch: JSONException -> L13
    L12:
        return r10;
    }

    public c.b b() {
        if (this.f11481b < this.f11480a.size()) goto L6;
        return null;
    L6:
        List<c.b> r10 = this.f11480a;
        int r11 = this.f11481b;
        this.f11481b = r11 + 1;
        return r10.get(r11);
    }

    public boolean c() {
        if (this.f11480a.isEmpty() == false) goto L5;
    L8:
        return true;
    L5:
        if (this.f11481b >= this.f11480a.size()) goto L8;
        return false;
    }

    public void d(String r12, String r13, int r14, long r15, h r17, b r18) {
        if (r17 != null) goto L5;
    L7:
        boolean r10 = false;
    L8:
        boolean r11 = r10;
        long r16 = r18.L;
        if (r16 > 0) goto L12;
        r16 = r18.f11401h;
    L12:
        a r19 = new a(r12, r13, r14, r15, System.currentTimeMillis() - r16, r11);
        this.f11482c.add(r19);
        RetrofitMetrics r20 = r18.O;
        if (r20 == null) goto L16;
        r20.B0 = a();
        return;
    L16:
        return;
    L5:
        if (r17.d() == false) goto L7;
        r10 = true;
        goto L8
    }
}
