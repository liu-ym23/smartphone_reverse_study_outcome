package w3;

import android.content.pm.ServiceInfo;
import android.os.IBinder;
import android.os.Message;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static Field f13313f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static Field f13314g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static Field f13315h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static Field f13316i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static Field f13317j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static Field f13318k;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f13319a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f13320b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f13321c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f13322d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f13323e;

    public c(String r10, int r11, long r12, String r13) {
        this.f13319a = r10;
        this.f13320b = r11;
        this.f13321c = r12;
        this.f13322d = r13;
        this.f13323e = Thread.currentThread().getName();
    }

    public static c a(Message r14) {
        switch(r14.what) {
            case 114: goto L37;
            case 115: goto L30;
            case 116: goto L28;
            case 117: goto L48;
            case 118: goto L48;
            case 119: goto L48;
            case 120: goto L48;
            case 121: goto L21;
            case 122: goto L14;
            case 123: goto L7;
            default: goto L48;
        };
    L48:
        throw new IllegalArgumentException("message.what = " + r14.what + " is not excepted!");     // Catch: Throwable -> L51
    L7:
        if (f13318k != null) goto L9;
        f13318k = a.a(r14.obj.getClass(), "token");     // Catch: Throwable -> L51
    L9:
        IBinder r10 = (IBinder) f13318k.get(r14.obj);     // Catch: Throwable -> L51
        if (r10 == null) goto L50;
        return new c(d.c().d(r10), r14.what, System.currentTimeMillis(), r10.toString());
    L14:
        if (f13317j != null) goto L16;
        f13317j = a.a(r14.obj.getClass(), "token");     // Catch: Throwable -> L51
    L16:
        IBinder r11 = (IBinder) f13317j.get(r14.obj);     // Catch: Throwable -> L51
        if (r11 == null) goto L50;
        return new c(d.c().d(r11), r14.what, System.currentTimeMillis(), r11.toString());
    L21:
        if (f13316i != null) goto L23;
        f13316i = a.a(r14.obj.getClass(), "token");     // Catch: Throwable -> L51
    L23:
        IBinder r12 = (IBinder) f13316i.get(r14.obj);     // Catch: Throwable -> L51
        if (r12 == null) goto L50;
        return new c(d.c().d(r12), r14.what, System.currentTimeMillis(), r12.toString());
    L28:
        return new c(d.c().d((IBinder) r14.obj), r14.what, System.currentTimeMillis(), r14.obj.toString());
    L30:
        if (f13315h != null) goto L32;
        f13315h = a.a(r14.obj.getClass(), "token");     // Catch: Throwable -> L51
    L32:
        IBinder r13 = (IBinder) f13315h.get(r14.obj);     // Catch: Throwable -> L51
        if (r13 == null) goto L50;
        return new c(d.c().d(r13), r14.what, System.currentTimeMillis(), r13.toString());
    L37:
        if (f13313f != null) goto L40;
        f13313f = a.a(r14.obj.getClass(), "info");     // Catch: Throwable -> L51
    L40:
        if (f13314g != null) goto L42;
        f13314g = a.a(r14.obj.getClass(), "token");     // Catch: Throwable -> L51
    L42:
        ServiceInfo r15 = (ServiceInfo) f13313f.get(r14.obj);     // Catch: Throwable -> L51
        String r16 = null;
        if (r15 == null) goto L46;
        r16 = r15.name;     // Catch: Throwable -> L51
    L46:
        return new c(r16, r14.what, System.currentTimeMillis(), f13314g.get(r14.obj).toString());
    L50:
        return new c("unknow", r14.what, System.currentTimeMillis(), "unknow");
    }

    public String toString() {
        return "ServiceFollowBean{mServiceName='" + this.f13319a + "', mWhat=" + this.f13320b + ", mTimeStamp=" + this.f13321c + ", mToken='" + this.f13322d + "', mThreadName='" + this.f13323e + "'}";
    }
}
