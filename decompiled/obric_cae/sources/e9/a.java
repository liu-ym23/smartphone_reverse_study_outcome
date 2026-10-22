package e9;

import android.text.TextUtils;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile boolean f7199a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static List<b> f7200b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ReentrantReadWriteLock.ReadLock f7201c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ReentrantReadWriteLock.WriteLock f7202d = null;

    /* JADX INFO: renamed from: e9.a$a, reason: collision with other inner class name */
    public static class C0066a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f7203a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f7204b;
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Pattern f7205a;

        public b() {
        }

        public final boolean a(URI r8) {
            if (r8 != null) goto L4;
            return false;
        L4:
            if (TextUtils.isEmpty(r8.getHost()) == false) goto L6;
            return false;
        L6:
            if (this.f7205a == null) goto L16;
            String r10 = r8.getHost();
            if (TextUtils.isEmpty(r8.getPath()) == true) goto L12;
            StringBuilder r11 = android.aimedia.a.j(r10);
            r11.append(r8.getPath());
            r10 = r11.toString();
        L12:
            return this.f7205a.matcher(r10).matches();
        L16:
            return false;
        }
    }

    static {
        f7200b = new ArrayList();
        ReentrantReadWriteLock r8 = new ReentrantReadWriteLock();
        f7201c = r8.readLock();
        f7202d = r8.writeLock();
    }

    public static void a(JSONArray r8, int r10) {
        if (r10 <= 0) goto L25;
        ArrayList r11 = new ArrayList();
        if (r8 == null) goto L24;
        int r12 = r8.length();
        int r13 = 0;
    L7:
        if (r13 >= r12) goto L18;
        String r14 = r8.optString(r13);
        if (TextUtils.isEmpty(r14) == true) goto L17;
        b r15 = new b();
        r15.f7205a = Pattern.compile(r14);     // Catch: PatternSyntaxException -> L13
        boolean r16 = true;
    L15:
        if (r16 == false) goto L17;
        r11.add(r15);
    L13:
        e = move-exception;
        e.printStackTrace();
        r16 = false;
    L17:
        r13 = r13 + 1;
        goto L7
    L18:
        ReentrantReadWriteLock.WriteLock r17 = f7202d;
        r17.lock();     // Catch: Throwable -> L21
        f7200b = r11;     // Catch: Throwable -> L21
        r17.unlock();
    L21:
        th = move-exception;
        r17.unlock();
        throw th;
    L24:
        f7199a = true;
        return;
    L25:
        f7199a = false;
    }
}
