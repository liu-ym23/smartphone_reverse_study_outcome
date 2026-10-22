package m;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.apm.d;
import com.bytedance.apm6.util.constant.CommonConsts;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f10950a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f10951b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Uri f10952c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final HashMap<String, Integer> f10953d;

    /* JADX INFO: renamed from: m.a$a, reason: collision with other inner class name */
    static /* synthetic */ class C0237a {
    }

    public interface b<T> {
        T a(c r10);
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Cursor f10954a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final HashMap<String, Integer> f10955b;

        private c(Cursor r10, HashMap<String, Integer> r11) {
            this.f10954a = r10;
            this.f10955b = r11;
        }

        /* synthetic */ c(Cursor r10, HashMap r11, C0237a r12) {
            this(r10, r11);
        }

        private int a(String r10) {
            Integer r11 = this.f10955b.get(r10);
            if (r11 != null) goto L9;
            r11 = Integer.valueOf(this.f10954a.getColumnIndex(r10));     // Catch: Throwable -> L6
        L7:
            this.f10955b.put(r10, r11);
        L6:
            r11 = -1;
        L9:
            return r11.intValue();
        }

        public int b(String r10) {
            return this.f10954a.getInt(a(r10));
        L4:
            return -1;
        }

        public long c(String r10) {
            return this.f10954a.getLong(a(r10));
        L4:
            return -1;
        }

        public String d(String r10) {
            return this.f10954a.getString(a(r10));
        L4:
            return "";
        }
    }

    protected a() {
        this.f10953d = new HashMap();
        Context r10 = d.g();
        this.f10950a = r10;
        this.f10951b = r10.getPackageName() + CommonConsts.MONITOR_PROVIDER_SUFFIX;
    }

    private static void h(Cursor r10) {
        if (r10 == null) goto L10;
        if (r10.isClosed() == true) goto L11;
        r10.close();     // Catch: Exception -> L7
        return;
    L11:
        return;
    L12:
        return;
    }

    public abstract String[] b();

    public String c() {
        return "apm_monitor_t1.db";
    }

    public abstract String d();

    public Uri e() {
        if (this.f10952c != null) goto L6;
        this.f10952c = Uri.parse("content://" + this.f10951b + "/" + c() + "/" + d());
    L6:
        return this.f10952c;
    }

    public synchronized <I extends T> long f(ContentValues r10) {
        monitor-enter(this);
        if (r10 != null) goto L22;
        monitor-exit(this);
        return -1;
    L22:
        Uri r11 = d.g().getContentResolver().insert(e(), r10);     // Catch: Throwable -> L17 Exception -> L20
        if (r11 != null) goto L25;
        monitor-exit(this);
        return -1;
    L25:
        long r12 = Long.parseLong(r11.getLastPathSegment());     // Catch: Exception -> L14 Throwable -> L17
        monitor-exit(this);
        return r12;
    L14:
        return 1;
    L17:
        th = move-exception;
        throw th;
    L21:
        return -1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public List<T> g(String r10, String[] r11, String r12, b<T> r13) {
        Cursor r14 = null;
        Object[] r15 = 0;
        Cursor r16 = this.f10950a.getContentResolver().query(e(), b(), r10, r11, r12);     // Catch: Throwable -> L31
        if (r16 != null) goto L32;
    L25:
        List<T> r17 = Collections.emptyList();     // Catch: Throwable -> L28
        h(r16);
        return r17;
    L32:
    L28:
        r14 = r16;
        goto L29
    L6:
        if (r16.getCount() <= 0) goto L25;
        int r18 = Integer.MAX_VALUE;
        if (TextUtils.isEmpty(r12) == true) goto L17;
        int r19 = r12.indexOf("LIMIT");     // Catch: Throwable -> L28
        if (r19 <= 0) goto L17;
        int r110 = r12.indexOf("OFF");     // Catch: Throwable -> L28
        int r20 = r19 + 5;     // Catch: Throwable -> L28
        if (r110 <= 0) goto L16;
        Integer r111 = Integer.valueOf(r12.substring(r20, r110).trim());     // Catch: Throwable -> L28
    L15:
        r18 = r111.intValue();     // Catch: Throwable -> L28
        goto L17
    L16:
        r111 = Integer.valueOf(r12.substring(r20).trim());     // Catch: Throwable -> L28
    L17:
        LinkedList r112 = new LinkedList();     // Catch: Throwable -> L28
        int r21 = 0;
    L19:
        if (r16.moveToNext() == false) goto L23;
        if (r21 >= r18) goto L23;
        r112.add(r13.a(new c(r16, this.f10953d, r15 == true ? 1 : 0)));     // Catch: Throwable -> L28
        r21 = r21 + 1;
    L23:
        h(r16);
        return r112;
    L29:
        h(r14);
        return Collections.emptyList();
    }

    public int i(ContentValues r10, String r11, String[] r12) {
        if (r10 != null) goto L8;
        return -1;
    L8:
        return d.g().getContentResolver().update(e(), r10, r11, r12);
    L7:
        return -1;
    }
}
