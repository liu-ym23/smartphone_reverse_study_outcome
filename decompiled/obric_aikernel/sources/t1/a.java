package t1;

import android.annotation.TargetApi;
import android.content.SharedPreferences;
import android.os.Build;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final b f12923a = null;

    /* JADX INFO: renamed from: t1.a$a, reason: collision with other inner class name */
    static class C0296a implements b {
        C0296a() {
        }

        @Override // t1.a.b
        public void a(SharedPreferences.Editor r10) {
            r10.commit();
        }
    }

    interface b {
        void a(SharedPreferences.Editor r10);
    }

    static class c implements b {
        c() {
        }

        @Override // t1.a.b
        @TargetApi(9)
        public void a(SharedPreferences.Editor r10) {
            r10.apply();
        }
    }

    static {
        if (Build.VERSION.SDK_INT < 9) goto L5;
        b r10 = new c();
    L6:
        f12923a = r10;
        return;
    L5:
        r10 = new C0296a();
        goto L6
    }

    public static void a(SharedPreferences.Editor r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        f12923a.a(r10);
    }
}
