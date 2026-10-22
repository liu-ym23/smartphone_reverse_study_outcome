package x4;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.bdinstall.BDInstallProvider;
import com.bytedance.common.wschannel.WsConstants;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public final class v0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ConcurrentHashMap f13569c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ConcurrentHashMap f13570d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f13571e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f13572a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicBoolean f13573b;

    public static class a extends k5.l<v0> {
        @Override // k5.l
        public final v0 a(Object[] r8) {
            return new v0((Context) r8[0]);
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Uri f13574a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int[] f13575b;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final /* synthetic */ String f13576m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final /* synthetic */ v0 f13577n;

        public b(v0 r8, Uri r10, int[] r11, String r12) {
            this.f13577n = r8;
            this.f13574a = r10;
            this.f13575b = r11;
            this.f13576m = r12;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f13577n.f13572a.getContentResolver().notifyChange(this.f13574a, null);     // Catch: Exception -> L4
            return;
        L4:
            int[] r8 = this.f13575b;
            int r10 = r8[0] + 1;
            r8[0] = r10;
            if (r10 > 4) goto L10;
            toString();
            int r11 = r.f13543a;
            t.b(this.f13576m).postDelayed(this, 1000);
            return;
        }
    }

    public interface c {
        void a(String r8, String r10);
    }

    static {
        f13569c = new ConcurrentHashMap();
        f13570d = new ConcurrentHashMap();
        f13571e = new a();
    }

    public v0(Context r8) {
        this.f13573b = new AtomicBoolean(false);
        this.f13572a = r8;
    }

    public static v0 a(Context r8) {
        return f13571e.b(new Object[]{r8});
    }

    public final void b(String r8, String r10, c r11) {
        if (this.f13573b.compareAndSet(false, true) == false) goto L10;
        Context r12 = this.f13572a;
        Uri r13 = BDInstallProvider.a(r12);
        if (r13 == null) goto L10;
        r12.getContentResolver().registerContentObserver(r13, true, new w0(this, t.b(t.a(t.f13552d))));
    L10:
        if (TextUtils.isEmpty(r10) == false) goto L12;
        return;
    L12:
        monitor-enter(this);
        ConcurrentHashMap r14 = f13570d;     // Catch: Throwable -> L29
        List r15 = (List) r14.get(r10);     // Catch: Throwable -> L29
        if (r15 != null) goto L16;
        r15 = new ArrayList();     // Catch: Throwable -> L29
        r14.put(r10, r15);     // Catch: Throwable -> L29
    L16:
        r15.add(r11);     // Catch: Throwable -> L29
        ConcurrentHashMap r16 = f13569c;     // Catch: Throwable -> L29
        if (r16.containsKey(r10) == false) goto L23;
        String r17 = (String) r16.get(r10);     // Catch: Throwable -> L29
        if (r11 == null) goto L21;
        r11.a(r17, r8);     // Catch: Throwable -> L29
    L21:
        monitor-exit(this);     // Catch: Throwable -> L29
        return;
    L23:
        String r18 = this.f13572a.getSharedPreferences("ug_install_op_pref", 0).getString(r10 + "_" + r8, null);     // Catch: Throwable -> L29
        if (TextUtils.isEmpty(r18) == true) goto L27;
        if (r11 == null) goto L27;
        r11.a(r18, r8);     // Catch: Throwable -> L29
    L27:
        monitor-exit(this);     // Catch: Throwable -> L29
        return;
    L29:
        th = move-exception;
        throw th;
    }

    @SuppressLint({"ApplySharedPref"})
    public final void c(String r8, String r10, String r11) {
        Context r12 = this.f13572a;
        r12.getSharedPreferences("ug_install_op_pref", 0).edit().putString(r10 + "_" + r8, r11).apply();     // Catch: Exception -> L8
        Uri r13 = BDInstallProvider.a(r12);     // Catch: Exception -> L8
        if (r13 != null) goto L6;
        return;
    L6:
        new b(this, r13.buildUpon().appendQueryParameter("key", r10).appendQueryParameter(WsConstants.KEY_APP_ID, r8).appendQueryParameter("value", r11).build(), new int[1], r8).run();     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        e.printStackTrace();
        int r14 = r.f13543a;
    }
}
