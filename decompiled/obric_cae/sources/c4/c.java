package c4;

import androidx.lifecycle.s;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public abstract class c implements g {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ConcurrentHashMap f3327c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f3328a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList f3329b;

    static {
        f3327c = new ConcurrentHashMap();
    }

    public c() {
        ArrayList r8 = new ArrayList();
        this.f3329b = r8;
        r8.add("logger@" + hashCode());
    }

    public static String q(String r8, Object... r10) {
        StringBuilder r11 = new StringBuilder();     // Catch: Throwable -> L30
        if (r10.length != 0) goto L5;
    L27:
        r11.append(r8);     // Catch: Throwable -> L30
    L28:
        return r11.toString();
    L5:
        if (r8.contains("{}") == false) goto L27;
        int r12 = r8.length();     // Catch: Throwable -> L30
        int r13 = 0;
        int r14 = 0;
    L8:
        if (r13 >= r12) goto L28;
        char r15 = r8.charAt(r13);     // Catch: Throwable -> L30
        if (r13 >= (r12 - 1)) goto L12;
        char r16 = r8.charAt(r13 + 1);     // Catch: Throwable -> L30
    L14:
        if (r15 == '{') goto L16;
    L25:
        r11.append(r15);     // Catch: Throwable -> L30
    L26:
        r13 = r13 + 1;     // Catch: Throwable -> L30
        goto L8
    L16:
        if (r16 != '}') goto L25;
        if (r14 >= r10.length) goto L24;
        int r17 = r14 + 1;     // Catch: Throwable -> L30
        Object r18 = r10[r14];     // Catch: Throwable -> L30
        if (r18 == null) goto L22;
        String r19 = r18.toString();     // Catch: Throwable -> L30
    L23:
        r11.append(r19);     // Catch: Throwable -> L30
        r14 = r17;
        goto L24
    L22:
        r19 = "";
    L24:
        r13 = r13 + 1;     // Catch: Throwable -> L30
        goto L26
    L12:
        r16 = ' ';
    L36:
        return r8;
    }

    public void r(int r8, int r10, List<String> r11, Throwable r12, String r13, Object... r14) {
        boolean r15 = true;
        if (j.f3347a.isEmpty() == true) goto L5;
    L7:
        boolean r16 = false;
    L8:
        if (r16 == false) goto L10;
        return;
    L10:
        i.a r17 = i.f3338i;
        s r18 = new s(3);
        String r19 = this.f3328a;
        Object r20 = r18.f2194b;
        ((i) r20).f3339a = r19;
        ((i) r20).f3342d = r8;
        ((i) r20).f3341c = r10;
        ((i) r20).f3340b = Thread.currentThread().getName();
        ((i) r20).f3346h = r12;
        ArrayList r21 = this.f3329b;
        if (r11 != null) goto L13;
    L15:
        ((i) r20).f3343e = r21;
        ((i) r20).f3344f = q(r13, r14);
        i r22 = (i) r20;
        j.a(r22);
        String r23 = this.f3328a;
        if (r23 != null) goto L18;
    L20:
        r15 = false;
    L21:
        if (r15 == false) goto L23;
        h r24 = (h) j.f3348b.get(r23);
    L24:
        if (r24 == null) goto L27;
        r24.a(r22);
        return;
    L27:
        return;
    L23:
        r24 = null;
        goto L24
    L18:
        if (r23.isEmpty() == true) goto L20;
    L13:
        if (r11.size() <= 0) goto L15;
        ArrayList r25 = new ArrayList();
        r25.addAll(r21);
        r25.addAll(r11);
        r21 = r25;
        goto L15
    L5:
        if (j.f3348b.isEmpty() == false) goto L7;
        r16 = true;
        goto L8
    }

    public void s(String r8) {
        this.f3328a = r8;
        f3327c.put(r8, this);
        m r10 = (m) this;
        r10.e("Current logger bind to appId {}", new Object[]{r8});
    }
}
