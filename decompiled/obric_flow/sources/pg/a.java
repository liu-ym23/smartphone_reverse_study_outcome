package pg;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.news.common.settings.api.annotation.ILocalSettings;
import com.bytedance.news.common.settings.api.annotation.ISettings;
import com.lynx.tasm.utils.g;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import ko.r;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final ConcurrentHashMap f21340i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final ConcurrentHashMap f21341j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final ConcurrentHashMap f21342k = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile b f21343a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Handler f21344b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ConcurrentHashMap f21345c;
    public final com.bytedance.android.monitorV2.lynx.impl.a d;
    public final r e;
    public final String f;
    public volatile d g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile boolean f21346h;

    static {
        f21340i = new ConcurrentHashMap();
        f21341j = new ConcurrentHashMap();
        f21342k = new ConcurrentHashMap();
    }

    public a(String r5) {
        this.f21344b = new Handler(Looper.getMainLooper());
        this.f21345c = new ConcurrentHashMap();
        this.d = new com.bytedance.android.monitorV2.lynx.impl.a();
        this.e = new r(16);
        this.f21346h = false;
        this.f = r5;
        f21342k.put(r5, Boolean.TRUE);
    }

    public static a b(String r5) {
        if (TextUtils.isEmpty(r5) == true) goto L19;
        ConcurrentHashMap r10 = f21340i;
        a r11 = (a) r10.get(r5);
        if (r11 == null) goto L7;
        return r11;
    L7:
        monitor-enter(a.class);
        a r12 = (a) r10.get(r5);     // Catch: Throwable -> L11
        if (r12 != null) goto L13;
        r12 = new a(r5);     // Catch: Throwable -> L11
        r10.putIfAbsent(r5, r12);     // Catch: Throwable -> L11
    L13:
        monitor-exit(a.class);     // Catch: Throwable -> L11
        return r12;
    L11:
        th = move-exception;
        throw th;
    L19:
        throw new IllegalArgumentException("settingsId不能为空");
    }

    public final Object a(Class r5) {
        c();
        Object r10 = null;
        if (ISettings.class.isAssignableFrom(r5) == false) goto L41;
        com.bytedance.android.monitorV2.lynx.impl.a r11 = this.d;
        d r12 = this.g;
        String r13 = this.f;
        ISettings r14 = (ISettings) r11.f3652a.get(r5);
        if (r14 != null) goto L37;
        rg.a r15 = (rg.a) r5.getAnnotation(rg.a.class);
        if (r15 != null) goto L9;
        String r16 = "";
    L11:
        if (r13.equals(r16) == false) goto L35;
        ConcurrentHashMap r17 = r11.f3653b;
        monitor-enter(r17);
    L17:
        th = move-exception;
        throw th;
    L15:
        if (r11.f3653b.containsKey(r5) == false) goto L19;
        r10 = r11.f3653b.get(r5);     // Catch: Throwable -> L17
    L19:
        if (r10 != null) goto L21;
        r10 = new Object();     // Catch: Throwable -> L17
        r11.f3653b.put(r5, r10);     // Catch: Throwable -> L17
    L21:
        monitor-exit(r17);     // Catch: Throwable -> L17
        monitor-enter(r10);
        ISettings r18 = (ISettings) r11.f3652a.get(r5);     // Catch: Throwable -> L26
        if (r18 != null) goto L28;
        r18 = com.bytedance.android.monitorV2.lynx.impl.a.a(r5, r12);     // Catch: Throwable -> L26
        r11.f3652a.put(r5, r18);     // Catch: Throwable -> L26
    L28:
        monitor-exit(r10);     // Catch: Throwable -> L26
        return r18;
    L26:
        th = move-exception;
        throw th;
    L35:
        throw new IllegalArgumentException(g.d("Settings声明id与Manager不匹配：", r16, " - "));
    L9:
        r16 = r15.settingsId();
        goto L11
    L37:
        if (r11.f3653b.containsKey(r5) == false) goto L39;
        r11.f3653b.remove(r5);
    L39:
        return r14;
    L41:
        if (ILocalSettings.class.isAssignableFrom(r5) == false) goto L82;
        r r19 = this.e;
        d r20 = this.g;
        String r21 = this.f;
        ILocalSettings r22 = (ILocalSettings) ((ConcurrentHashMap) r19.f18729c).get(r5);
        if (r22 != null) goto L78;
        rg.a r23 = (rg.a) r5.getAnnotation(rg.a.class);
        if (r23 != null) goto L47;
        String r24 = "";
    L49:
        if (r21.equals(r24) == false) goto L76;
        ConcurrentHashMap r25 = (ConcurrentHashMap) r19.f18728b;
        monitor-enter(r25);
    L55:
        th = move-exception;
        throw th;
    L53:
        if (((ConcurrentHashMap) r19.f18728b).containsKey(r5) == false) goto L57;
        r10 = ((ConcurrentHashMap) r19.f18728b).get(r5);     // Catch: Throwable -> L55
    L57:
        if (r10 != null) goto L59;
        r10 = new Object();     // Catch: Throwable -> L55
        ((ConcurrentHashMap) r19.f18728b).put(r5, r10);     // Catch: Throwable -> L55
    L59:
        monitor-exit(r25);     // Catch: Throwable -> L55
        monitor-enter(r10);
        ILocalSettings r26 = (ILocalSettings) ((ConcurrentHashMap) r19.f18729c).get(r5);     // Catch: Throwable -> L66
        if (r26 != null) goto L68;
        r26 = r.d(r5, r20);     // Catch: Throwable -> L66
        if (r26 == null) goto L68;
        ((ConcurrentHashMap) r19.f18729c).put(r5, r26);     // Catch: Throwable -> L66
    L68:
        r22 = r26;
        monitor-exit(r10);     // Catch: Throwable -> L66
    L80:
        return r22;
    L66:
        th = move-exception;
        throw th;
    L76:
        throw new IllegalArgumentException(g.d("Settings声明id与Manager不匹配：", r24, " - "));
    L47:
        r24 = r23.settingsId();
        goto L49
    L78:
        if (((ConcurrentHashMap) r19.f18728b).containsKey(r5) == false) goto L80;
        ((ConcurrentHashMap) r19.f18728b).remove(r5);
        goto L80
    L82:
        throw new IllegalArgumentException("tClass必须是ISettings或ILocalSettings的子类");
    }

    public final void c() {
        if (this.f21343a == null) goto L32;
        monitor-enter(this);
    L22:
        th = move-exception;
        throw th;
    L6:
        if (this.f21343a == null) goto L26;
        d r5 = this.f21343a.create();     // Catch: Throwable -> L22
        r5.f21352c.f5320b = this.f;     // Catch: Throwable -> L22
        Context r10 = r5.f21350a;     // Catch: Throwable -> L22
        monitor-enter(ug.a.class);     // Catch: Throwable -> L22
    L16:
        th = move-exception;
        throw th;     // Catch: Throwable -> L22
    L10:
        if (ug.a.f22352a == null) goto L12;
    L19:
        monitor-exit(ug.a.class);     // Catch: Throwable -> L22
    L20:
        this.g = r5;     // Catch: Throwable -> L22
        goto L26
    L12:
        if ((r10 instanceof Application) == false) goto L18;
        ug.a.f22352a = r10;     // Catch: Throwable -> L16
        monitor-exit(ug.a.class);     // Catch: Throwable -> L22
        goto L20
    L18:
        ug.a.f22352a = r10.getApplicationContext();     // Catch: Throwable -> L16
    L26:
        this.f21343a = null;     // Catch: Throwable -> L22
        monitor-exit(this);     // Catch: Throwable -> L22
    L32:
        if (this.g == null) goto L35;
        return;
    L35:
        throw new IllegalStateException("IndividualManager尚未被配置");
    }

    public final void d() {
        c();
        if (this.f21346h == false) goto L5;
        return;
    L5:
        ((ExecutorService) this.g.f21352c.d).execute(new jm.a(this, 6));
    }
}
