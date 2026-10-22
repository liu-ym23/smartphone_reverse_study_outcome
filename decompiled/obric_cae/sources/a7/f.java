package a7;

import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class f {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static volatile f f93e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile int f94a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile int f95b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile int f96c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CopyOnWriteArrayList f97d;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<String> f98a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List<String> f99b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public ArrayList f100c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public ArrayList f101d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public ArrayList f102e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public HashSet f103f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f104g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f105h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final String f106i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public volatile int f107j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public volatile long f108k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public volatile boolean f109l;

        public a(ArrayList r8, ArrayList r10) {
            this.f98a = r8;
            this.f99b = r10;
            this.f108k = SystemClock.uptimeMillis();
            this.f107j = 0;
            this.f105h = Integer.MAX_VALUE;
            this.f104g = 0;
            this.f109l = false;
            this.f106i = UUID.randomUUID().toString();
        }
    }

    public f() {
        this.f94a = 0;
        this.f95b = 0;
        this.f97d = new CopyOnWriteArrayList();
        this.f96c = 4;
    }

    public static f c() {
        if (f93e != null) goto L15;
        monitor-enter(f.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f93e != null) goto L9;
        f93e = new f();     // Catch: Throwable -> L11
    L9:
        monitor-exit(f.class);     // Catch: Throwable -> L11
    L15:
        return f93e;
    }

    public static boolean f(String r8, ArrayList r10, JSONObject r11) {
        int r12 = 0;
        if (r11 != null) goto L5;
    L17:
        return false;
    L5:
        if (TextUtils.isEmpty(r8) == true) goto L17;
        JSONArray r13 = r11.optJSONArray(r8);
        if (r13 != null) goto L10;
        return false;
    L10:
        if (r12 >= r13.length()) goto L15;
        String r14 = r13.optString(r12);
        if (TextUtils.isEmpty(r14) == true) goto L14;
        r10.add(r14);
    L14:
        r12 = r12 + 1;
        goto L10
    L15:
        return true;
    }

    public final a a(String r8) {
        Iterator r10 = this.f97d.iterator();
    L4:
        if (r10.hasNext() == false) goto L8;
        a r11 = (a) r10.next();
        if (r11.f106i.equals(r8) == false) goto L4;
        return r11;
    L8:
        return null;
    }

    public final boolean b(int r8, String r10) {
        if (r8 != 0) goto L4;
        return false;
    L4:
        if (TextUtils.isEmpty(r10) == true) goto L16;
        a r11 = a(r10);
        if (r11 == null) goto L15;
        HashSet r12 = r11.f103f;
        if (r12 != null) goto L12;
        return false;
    L12:
        return r12.contains(Integer.valueOf(r8));
    L15:
        return false;
    L16:
        return false;
    }

    public final void d(String r8, boolean r10) {
        if (TextUtils.isEmpty(r8) == false) goto L5;
        return;
    L5:
        a r11 = a(r8);
        if (r11 != null) goto L9;
        return;
    L9:
        if (Logger.debug() == false) goto L11;
        Logger.d("f", "Forbidden: " + r11.f109l + " failed count: " + r11.f107j + " max count: " + r11.f105h);
    L11:
        int r12 = r11.f107j;
        if (r10 == false) goto L18;
        if (r12 == 0) goto L15;
    L17:
        r11.f107j = 0;
        r11.f109l = false;
        return;
    L15:
        if (r11.f109l == true) goto L17;
        return;
    L18:
        int r13 = r12 + 1;
        r11.f107j = r13;
        if (r13 >= r11.f105h) goto L22;
        return;
    L22:
        if (r11.f109l == true) goto L25;
        r11.f109l = true;
        r11.f108k = SystemClock.uptimeMillis();
    L25:
        if (Logger.debug() == false) goto L29;
        Logger.d("f", "Forbidden: " + r11.f109l + " failed count: " + r11.f107j);
        return;
    }

    public final void e(String r8) {
        Logger.d("f", "onNetConfigChanged config: " + r8);
        if (TextUtils.isEmpty(r8) == false) goto L12;
        return;
    L12:
        JSONObject r10 = new JSONObject(r8);     // Catch: Throwable -> L10
        int r11 = 0;
        this.f94a = r10.optInt("enabled", 0);     // Catch: Throwable -> L10
        this.f96c = r10.optInt("connect_interval", 4);     // Catch: Throwable -> L10
        this.f95b = r10.optInt("retry_for_not_2xx_code", 0);     // Catch: Throwable -> L10
        this.f97d.clear();     // Catch: Throwable -> L10
        JSONArray r12 = r10.getJSONArray("match_rules");     // Catch: Throwable -> L10
    L7:
        if (r11 >= r12.length()) goto L15;
        g((JSONObject) r12.get(r11));     // Catch: Throwable -> L10
        r11 = r11 + 1;
        goto L7
    L15:
        return;
    L10:
        Logger.d("f", "parse json config error");
    }

    public final void g(JSONObject r10) {
        ArrayList r8 = new ArrayList();
        f("host_group", r8, r10);
        ArrayList r11 = new ArrayList();
        f("concurrent_hosts", r11, r10);
        if (r8.isEmpty() == false) goto L5;
        return;
    L5:
        if (r11.size() < 2) goto L39;
        a r12 = new a(r8, r11);
        ArrayList r13 = new ArrayList();
        if (f("equal_group", r13, r10) == false) goto L10;
        r12.f100c = r13;
    L10:
        ArrayList r14 = new ArrayList();
        if (f("prefix_group", r14, r10) == false) goto L13;
        r12.f101d = r14;
    L13:
        ArrayList r15 = new ArrayList();
        JSONArray r16 = r10.optJSONArray("pattern_group");
        int r17 = 0;
        if (r16 == null) goto L23;
        int r18 = 0;
    L17:
        if (r18 >= r16.length()) goto L22;
        String r19 = r16.optString(r18);
        if (TextUtils.isEmpty(r19) == true) goto L21;
        r15.add(Pattern.compile(r19, 2));     // Catch: Throwable -> L31
    L21:
        r18 = r18 + 1;
        goto L17
    L22:
        r12.f102e = r15;
    L23:
        r12.f105h = r10.optInt("fail_count", Integer.MAX_VALUE);
        r12.f104g = r10.optInt("forbid_seconds", 0);
        HashSet r20 = new HashSet();
        JSONArray r21 = r10.optJSONArray("block_code_list");
        if (r21 != null) goto L26;
    L29:
        this.f97d.add(r12);
        return;
    L26:
        if (r17 >= r21.length()) goto L28;
        r20.add(Integer.valueOf(r21.optInt(r17)));
        r17 = r17 + 1;
        goto L26
    L28:
        r12.f103f = r20;
        goto L29
    }
}
