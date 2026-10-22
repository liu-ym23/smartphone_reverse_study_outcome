package x4;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap f13528a = null;

    static {
        f13528a = new ConcurrentHashMap(4);
    }

    public m() {
    }

    public static void a(Context r8, j0 r10) {
        if (r8 == null) goto L13;
        if (r10 == null) goto L15;
        f13528a.remove(r10.a());
        k5.a.a(r8, r10).edit().remove("cdid").apply();
        if (r10.J == false) goto L8;
        int r11 = k5.d.f8934b;
        String r12 = t2.b.j("Y29tLnNzLmFuZHJvaWQuZGV2aWNlcmVnaXN0ZXIudXRpbHMuQ2RpZA==");
    L9:
        SharedPreferences r13 = r8.getSharedPreferences(r12, 0);
        if (r13.contains("cdid") == false) goto L14;
        r13.edit().remove("cdid").apply();
        return;
    L14:
        return;
    L8:
        StringBuilder r14 = new StringBuilder();
        int r15 = k5.d.f8934b;
        r14.append(t2.b.j("Y29tLnNzLmFuZHJvaWQuZGV2aWNlcmVnaXN0ZXIudXRpbHMuQ2RpZA=="));
        r14.append("_");
        r14.append(r10.f13463a);
        r12 = r14.toString();
        goto L9
    L15:
        return;
    }

    public static String b(j0 r8) {
        String r10 = null;
        if (r8 != null) goto L5;
        return null;
    L5:
        String r11 = r8.a();
        ConcurrentHashMap r12 = f13528a;
        String r13 = (String) r12.get(r11);
        if (r13 == null) goto L8;
    L22:
        return r13;
    L8:
        monitor-enter(m.class);
        if (r13 == null) goto L23;
    L17:
        monitor-exit(m.class);     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        throw th;
    L23:
        if (x0.f(r8.f13465c) == false) goto L13;
        r10 = c(r8);     // Catch: Throwable -> L19
        r12.put(r11, r10);     // Catch: Throwable -> L19
        v0.a(r8.f13465c).c(r8.a(), "cdid", r10);     // Catch: Throwable -> L19
    L16:
        r13 = r10;
        goto L17
    L13:
        Context r14 = r8.f13465c;     // Catch: Throwable -> L19
        if (r14 == null) goto L16;
        v0.a(r14).b(r8.a(), "cdid", new l());     // Catch: Throwable -> L19
        r10 = (String) r12.get(r8.a());     // Catch: Throwable -> L19
        goto L16
    }

    public static String c(j0 r8) {
        if (r8 != null) goto L5;
        return null;
    L5:
        Context r10 = r8.f13465c;
        SharedPreferences r11 = k5.a.a(r10, r8);
        String r12 = r11.getString("cdid", null);
        if (TextUtils.isEmpty(r12) == true) goto L8;
        return r12;
    L8:
        if (r8.J == false) goto L10;
        int r13 = k5.d.f8934b;
        String r14 = t2.b.j("Y29tLnNzLmFuZHJvaWQuZGV2aWNlcmVnaXN0ZXIudXRpbHMuQ2RpZA==");
    L11:
        SharedPreferences r15 = r10.getSharedPreferences(r14, 0);
        String r16 = r15.getString("cdid", null);
        if (TextUtils.isEmpty(r16) == false) goto L14;
        r16 = UUID.randomUUID().toString();
    L14:
        String r17 = r16;
        r15.edit().putString("cdid", r17).apply();
        r11.edit().putString("cdid", r17).putBoolean("cdid_migrate", true).apply();
        return r17;
    L10:
        StringBuilder r18 = new StringBuilder();
        int r19 = k5.d.f8934b;
        r18.append(t2.b.j("Y29tLnNzLmFuZHJvaWQuZGV2aWNlcmVnaXN0ZXIudXRpbHMuQ2RpZA=="));
        r18.append("_");
        r18.append(r8.f13463a);
        r14 = r18.toString();
        goto L11
    }
}
