package n;

import android.content.ContentValues;
import androidx.annotation.NonNull;
import com.bytedance.apm6.cpu.collect.CpuReportEvent;
import com.bytedance.common.wschannel.WsConstants;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class a extends m.a<b0.a> implements m.a.b<b0.a> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static volatile a f11154e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static String f11155f = "_id <= ? ";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final String[] f11156g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static String f11157h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static String f11158i;

    static {
        f11156g = new String[]{"_id", CpuReportEvent.VALUE_FRONT, WsConstants.KEY_CONNECTION_TYPE, "timestamp", "accumulation", "version_id", "source", "status", "scene", "process", "main_process", "sid"};
        f11157h = "main_process = 1 AND delete_flag = 0";
        f11158i = "main_process = 0 AND delete_flag = 0 AND timestamp <= ? ";
    }

    private a() {
    }

    public static a k() {
        if (f11154e != null) goto L15;
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f11154e != null) goto L9;
        f11154e = new a();     // Catch: Throwable -> L11
    L9:
        monitor-exit(a.class);     // Catch: Throwable -> L11
    L15:
        return f11154e;
    }

    @Override // m.a.b
    @NonNull
    public /* bridge */ /* synthetic */ b0.a a(m.a.c r10) {
        return j(r10);
    }

    @Override // m.a
    public String[] b() {
        return f11156g;
    }

    @Override // m.a
    public String d() {
        return "t_battery";
    }

    @NonNull
    public b0.a j(m.a.c r22) {
        long r10 = r22.c("_id");
        long r11 = r22.c(CpuReportEvent.VALUE_FRONT);
        String r12 = r22.d(WsConstants.KEY_CONNECTION_TYPE);
        long r13 = r22.c("timestamp");
        long r14 = r22.c("accumulation");
        long r15 = r22.c("version_id");
        String r16 = r22.d("source");
        long r17 = r22.c("status");
        String r18 = r22.d("scene");
        int r19 = r22.b("main_process");
        String r110 = r22.d("process");
        if (r11 == 0) goto L5;
        boolean r20 = true;
    L7:
        if (r17 == 0) goto L9;
        boolean r111 = true;
    L10:
        b0.a r21 = new b0.a(r20, r13, r12, r111, r14, r18, r16);
        r21.q(r110);
        r21.o(r10);
        r21.u(r15);
        if (r19 != 1) goto L13;
        boolean r23 = true;
    L14:
        r21.p(r23);
        r21.s(r22.d("sid"));
        return r21;
    L13:
        r23 = false;
        goto L14
    L9:
        r111 = false;
        goto L10
    L5:
        r20 = false;
        goto L7
    }

    public synchronized List<b0.a> l(boolean r10, long r11) {
        monitor-enter(this);
        if (r10 == false) goto L5;
        List<b0.a> r12 = g(f11157h, null, "_id", this);     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
        return r12;
    L5:
        r12 = g(f11158i, new String[]{String.valueOf(r11)}, "_id", this);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        throw th;
    }

    public synchronized long m(b0.a r10) {
        monitor-enter(this);
        if (r10 != null) goto L27;
        monitor-exit(this);
        return -1;
    L27:
        ContentValues r11 = new ContentValues();     // Catch: Throwable -> L22 Exception -> L25
        int r12 = 1;
        if (r10.k() == false) goto L10;
        int r13 = 1;
    L11:
        r11.put(CpuReportEvent.VALUE_FRONT, Integer.valueOf(r13));     // Catch: Throwable -> L22 Exception -> L25
        r11.put("source", r10.e());     // Catch: Throwable -> L22 Exception -> L25
        r11.put(WsConstants.KEY_CONNECTION_TYPE, r10.h());     // Catch: Throwable -> L22 Exception -> L25
        r11.put("timestamp", Long.valueOf(r10.g()));     // Catch: Throwable -> L22 Exception -> L25
        r11.put("accumulation", Long.valueOf(r10.a()));     // Catch: Throwable -> L22 Exception -> L25
        r11.put("version_id", Long.valueOf(r10.i()));     // Catch: Throwable -> L22 Exception -> L25
        if (r10.n() == false) goto L14;
        int r14 = 1;
    L15:
        r11.put("status", Integer.valueOf(r14));     // Catch: Throwable -> L22 Exception -> L25
        r11.put("scene", r10.d());     // Catch: Throwable -> L22 Exception -> L25
        if (r10.l() == true) goto L19;
        r12 = 0;
    L19:
        r11.put("main_process", Integer.valueOf(r12));     // Catch: Throwable -> L22 Exception -> L25
        r11.put("process", r10.c());     // Catch: Throwable -> L22 Exception -> L25
        r11.put("sid", r10.f());     // Catch: Throwable -> L22 Exception -> L25
        long r15 = f(r11);     // Catch: Throwable -> L22 Exception -> L25
        monitor-exit(this);
        return r15;
        goto L26
    L14:
        r14 = 0;
        goto L15
    L10:
        r13 = 0;
    L22:
        th = move-exception;
        throw th;
    L26:
        return -1;
    }

    public synchronized void n(long r10) {
        monitor-enter(this);
        ContentValues r11 = new ContentValues();     // Catch: Throwable -> L6
        r11.put("delete_flag", 1);     // Catch: Throwable -> L6
        i(r11, f11155f, new String[]{String.valueOf(r10)});     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }
}
