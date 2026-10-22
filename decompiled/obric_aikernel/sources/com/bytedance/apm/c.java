package com.bytedance.apm;

import android.content.Context;
import android.os.Build;
import com.bytedance.apm.util.x;
import com.bytedance.apm6.commonevent.CommonEventDeliverer;
import com.bytedance.crash.dumper.ProcInfo;
import java.io.File;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Arrays;
import java.util.Comparator;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f820a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static File f821b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static long f822c = -1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static boolean f823d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static MappedByteBuffer f824e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static AtomicLong f825f;

    static class a implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ u.d f826c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ JSONObject f827g;

        a(u.d r10, JSONObject r11) {
            this.f826c = r10;
            this.f827g = r11;
        }

        @Override // java.lang.Runnable
        public void run() {
            CommonEventDeliverer.monitorEvent(this.f826c.e(), this.f826c.f(), null, this.f826c.b(), this.f826c.d(), this.f827g);
        }
    }

    static class b implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ u.d f828c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ JSONObject f829g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ JSONObject f830h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ JSONObject f831i;

        b(u.d r10, JSONObject r11, JSONObject r12, JSONObject r13) {
            this.f828c = r10;
            this.f829g = r11;
            this.f830h = r12;
            this.f831i = r13;
        }

        @Override // java.lang.Runnable
        public void run() {
            JSONObject r10 = new y.c(this.f828c.e(), this.f828c.f(), null, this.f829g, this.f830h, this.f831i, this.f828c.g()).c();
            if (r10 == null) goto L6;
            c.t("monitorEvent", r10.toString());
            return;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.apm.c$c, reason: collision with other inner class name */
    static class RunnableC0032c implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f832c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ int f833g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ JSONObject f834h;

        RunnableC0032c(String r10, int r11, JSONObject r12) {
            this.f832c = r10;
            this.f833g = r11;
            this.f834h = r12;
        }

        @Override // java.lang.Runnable
        public void run() {
            JSONObject r10 = new y.c(this.f832c, this.f833g, null, null, null, this.f834h).c();
            if (r10 == null) goto L6;
            c.t("monitorStatusRate", r10.toString());
            return;
        }
    }

    static class d implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f835c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ JSONObject f836g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ JSONObject f837h;

        d(String r10, JSONObject r11, JSONObject r12) {
            this.f835c = r10;
            this.f836g = r11;
            this.f837h = r12;
        }

        @Override // java.lang.Runnable
        public void run() {
            JSONObject r10 = new y.c(this.f835c, 0, this.f836g, null, null, this.f837h).c();
            if (r10 == null) goto L6;
            c.t("monitorDuration", r10.toString());
            return;
        }
    }

    static class e implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f838c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ int f839g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ JSONObject f840h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ JSONObject f841i;

        e(String r10, int r11, JSONObject r12, JSONObject r13) {
            this.f838c = r10;
            this.f839g = r11;
            this.f840h = r12;
            this.f841i = r13;
        }

        @Override // java.lang.Runnable
        public void run() {
            JSONObject r10 = new y.c(this.f838c, this.f839g, this.f840h, null, null, this.f841i).c();
            if (r10 == null) goto L6;
            c.t("monitorStatusAndDuration", r10.toString());
            return;
        }
    }

    static class f implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f842c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ JSONObject f843g;

        f(String r10, JSONObject r11) {
            this.f842c = r10;
            this.f843g = r11;
        }

        @Override // java.lang.Runnable
        public void run() {
            x.a.p().e(new y.d(this.f842c, this.f843g));
        }
    }

    static class g implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ long f844c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ long f845g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ String f846h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ String f847i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final /* synthetic */ String f848j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        final /* synthetic */ int f849k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        final /* synthetic */ JSONObject f850l;

        g(long r10, long r11, String r12, String r13, String r14, int r15, JSONObject r16) {
            this.f844c = r10;
            this.f845g = r11;
            this.f846h = r12;
            this.f847i = r13;
            this.f848j = r14;
            this.f849k = r15;
            this.f850l = r16;
        }

        @Override // java.lang.Runnable
        public void run() {
            x.d.v().e(new y.a("api_all", this.f844c, this.f845g, this.f846h, this.f847i, this.f848j, this.f849k, c.a(this.f850l, false)));
        }
    }

    static class h implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f851c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ JSONObject f852g;

        h(String r10, JSONObject r11) {
            this.f851c = r10;
            this.f852g = r11;
        }

        @Override // java.lang.Runnable
        public void run() {
            JSONObject r10 = new y.d(this.f851c, this.f852g).c();
            if (r10 == null) goto L6;
            c.t("monitorExceptionLog", r10.toString());
            return;
        }
    }

    static class i implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f853c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ JSONObject f854g;

        i(String r10, JSONObject r11) {
            this.f853c = r10;
            this.f854g = r11;
        }

        @Override // java.lang.Runnable
        public void run() {
            CommonEventDeliverer.monitorCommonLog(this.f853c, this.f854g);
        }
    }

    static class j implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f855c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ JSONObject f856g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ boolean f857h;

        j(String r10, JSONObject r11, boolean r12) {
            this.f855c = r10;
            this.f856g = r11;
            this.f857h = r12;
        }

        @Override // java.lang.Runnable
        public void run() {
            JSONObject r10 = new y.b(this.f855c, this.f856g, this.f857h).c();
            if (r10 == null) goto L6;
            c.t("monitorCommonLog", r10.toString());
            return;
        }
    }

    static class k implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ long f858c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ long f859g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ String f860h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ String f861i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final /* synthetic */ String f862j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        final /* synthetic */ int f863k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        final /* synthetic */ JSONObject f864l;

        k(long r10, long r11, String r12, String r13, String r14, int r15, JSONObject r16) {
            this.f858c = r10;
            this.f859g = r11;
            this.f860h = r12;
            this.f861i = r13;
            this.f862j = r14;
            this.f863k = r15;
            this.f864l = r16;
        }

        @Override // java.lang.Runnable
        public void run() {
            JSONObject r12 = new y.a("api_all", this.f858c, this.f859g, this.f860h, this.f861i, this.f862j, this.f863k, this.f864l).c();
            if (r12 == null) goto L6;
            c.t("monitorSLA", r12.toString());
            return;
        }
    }

    static class l implements Comparator<File> {
        l() {
        }

        public int a(File r10, File r11) {
            if (Build.VERSION.SDK_INT >= 19) goto L12;
            long r12 = r10.lastModified();
            long r13 = r11.lastModified();
            if (r12 >= r13) goto L7;
            return -1;
        L7:
            if (r12 != r13) goto L9;
            return 0;
        L9:
            return 1;
        L12:
            return Long.compare(r10.lastModified(), r11.lastModified());
        }

        @Override // java.util.Comparator
        public /* bridge */ /* synthetic */ int compare(File r10, File r11) {
            return a(r10, r11);
        }
    }

    static class m implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ long f865c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ long f866g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ String f867h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ String f868i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final /* synthetic */ String f869j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        final /* synthetic */ int f870k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        final /* synthetic */ JSONObject f871l;

        m(long r10, long r11, String r12, String r13, String r14, int r15, JSONObject r16) {
            this.f865c = r10;
            this.f866g = r11;
            this.f867h = r12;
            this.f868i = r13;
            this.f869j = r14;
            this.f870k = r15;
            this.f871l = r16;
        }

        @Override // java.lang.Runnable
        public void run() {
            x.d.v().e(new y.a("api_error", this.f865c, this.f866g, this.f867h, this.f868i, this.f869j, this.f870k, c.a(this.f871l, false)));
        }
    }

    static class n implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ long f872c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ long f873g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ String f874h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ String f875i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final /* synthetic */ String f876j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        final /* synthetic */ int f877k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        final /* synthetic */ JSONObject f878l;

        n(long r10, long r11, String r12, String r13, String r14, int r15, JSONObject r16) {
            this.f872c = r10;
            this.f873g = r11;
            this.f874h = r12;
            this.f875i = r13;
            this.f876j = r14;
            this.f877k = r15;
            this.f878l = r16;
        }

        @Override // java.lang.Runnable
        public void run() {
            JSONObject r12 = new y.a("api_error", this.f872c, this.f873g, this.f874h, this.f875i, this.f876j, this.f877k, this.f878l).c();
            if (r12 == null) goto L6;
            c.t("monitorApiError", r12.toString());
            return;
        }
    }

    static class o implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f879c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ JSONObject f880g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ JSONObject f881h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ JSONObject f882i;

        o(String r10, JSONObject r11, JSONObject r12, JSONObject r13) {
            this.f879c = r10;
            this.f880g = r11;
            this.f881h = r12;
            this.f882i = r13;
        }

        @Override // java.lang.Runnable
        public void run() {
            JSONObject r10 = new y.c(this.f879c, 0, null, this.f880g, this.f881h, this.f882i).c();
            if (r10 == null) goto L6;
            c.t("monitorEvent", r10.toString());
            return;
        }
    }

    public interface p {
        void a(float r10, float r11, String r12);
    }

    static {
        f825f = new AtomicLong(0);
    }

    public c() {
    }

    static /* synthetic */ JSONObject a(JSONObject r10, boolean r11) {
        return o(r10, r11);
    }

    private static void b(JSONObject r10) {
        if (r10 != null) goto L7;
        return;
    L7:
        JSONObject r11 = new JSONObject();     // Catch: Exception -> L6
        r11.put("_debug_uuid", com.bytedance.apm.d.B() + "_" + f825f.getAndAdd(1));     // Catch: Exception -> L6
        r10.put("_debug_self", r11);     // Catch: Exception -> L6
        return;
    }

    private static JSONObject c(JSONObject r10) {
        if (r10 != null) goto L5;
        r10 = new JSONObject();
    L5:
        if (r10.isNull("timestamp") == true) goto L11;
    L10:
        return r10;
    L11:
        r10.put("timestamp", System.currentTimeMillis());     // Catch: JSONException -> L8
    L8:
        e = move-exception;
        e.printStackTrace();
        goto L10
    }

    public static void d(long r13, long r15, String r17, String r18, String r19, int r20, JSONObject r21) {
        JSONObject r10 = p(r21);
        q0.b.f().i(new m(r13, r15, r17, r18, r19, r20, r10));
        if (com.bytedance.apm.d.G() == false) goto L6;
        q0.c.a().b(new n(r13, r15, r17, r18, r19, r20, r10));
        return;
    }

    public static void e(String r10, JSONObject r11) {
        f(r10, r11, false);
    }

    public static void f(String r10, JSONObject r11, boolean r12) {
        if (CommonEventDeliverer.needSkip(r10, Boolean.FALSE) == false) goto L6;
        n(r10, r11);
        return;
    L6:
        JSONObject r13 = q(r11);
        b(r13);
        q0.b.f().i(new i(r10, r13));
        if (com.bytedance.apm.d.G() == false) goto L10;
        JSONObject r14 = o(r13, true);
        q0.c.a().b(new j(r10, r14, r12));
        return;
    }

    @Deprecated
    public static void g(String r10, JSONObject r11, JSONObject r12) {
        if (CommonEventDeliverer.needSkip(r10, Boolean.TRUE) == false) goto L6;
        n(r10, r11);
        return;
    L6:
        JSONObject r13 = q(r12);
        b(r13);
        if (f823d == false) goto L9;
        JSONObject r14 = com.bytedance.apm.util.i.h(r11);
    L10:
        CommonEventDeliverer.monitorDuration(r10, r14, r13);
        if (com.bytedance.apm.d.G() == false) goto L14;
        JSONObject r15 = o(r11, true);
        JSONObject r16 = o(r13, true);
        q0.c.a().b(new d(r10, r15, r16));
        return;
    L14:
        return;
    L9:
        r14 = r11;
        goto L10
    }

    public static void h(String r10, JSONObject r11, JSONObject r12, JSONObject r13) {
        if (CommonEventDeliverer.needSkip(r10, Boolean.TRUE) == false) goto L6;
        n(r10, r11);
        return;
    L6:
        JSONObject r14 = q(r13);
        b(r14);
        CommonEventDeliverer.monitorEvent(r10, o(r11, true), o(r12, true), r14);
        if (com.bytedance.apm.d.G() == false) goto L10;
        JSONObject r15 = o(r11, true);
        JSONObject r16 = o(r12, true);
        JSONObject r17 = o(r14, true);
        q0.c.a().b(new o(r10, r15, r16, r17));
        return;
    }

    public static void i(u.d r10) {
        if (r10 != null) goto L5;
        return;
    L5:
        if (CommonEventDeliverer.needSkip(r10.e(), Boolean.TRUE) == false) goto L8;
        n(r10.e(), null);
        return;
    L8:
        JSONObject r11 = c(r10.c());
        b(r11);
        q0.b.f().i(new a(r10, r11));
        if (com.bytedance.apm.d.G() == false) goto L12;
        JSONObject r12 = o(r10.b(), true);
        JSONObject r13 = o(r10.d(), true);
        JSONObject r14 = o(r11, true);
        q0.c.a().b(new b(r10, r12, r13, r14));
        return;
    }

    public static void j(String r10, JSONObject r11) {
        JSONObject r12 = q(r11);
        q0.b.f().i(new f(r10, r12));
        if (com.bytedance.apm.d.G() == false) goto L6;
        q0.c.a().b(new h(r10, r12));
        return;
    }

    public static void k(long r13, long r15, String r17, String r18, String r19, int r20, JSONObject r21) {
        JSONObject r10 = p(r21);
        q0.b.f().i(new g(r13, r15, r17, r18, r19, r20, r10));
        if (com.bytedance.apm.d.G() == false) goto L6;
        q0.c.a().b(new k(r13, r15, r17, r18, r19, r20, r10));
        return;
    }

    @Deprecated
    public static void l(String r10, int r11, JSONObject r12, JSONObject r13) {
        if (CommonEventDeliverer.needSkip(r10, Boolean.TRUE) == false) goto L6;
        n(r10, r12);
        return;
    L6:
        JSONObject r14 = p(r13);
        b(r14);
        CommonEventDeliverer.monitorStatusAndDuration(r10, r11, o(r12, true), o(r14, false));
        if (com.bytedance.apm.d.G() == false) goto L10;
        JSONObject r15 = o(r12, true);
        JSONObject r16 = o(r13, true);
        q0.c.a().b(new e(r10, r11, r15, r16));
        return;
    }

    public static void m(String r10, int r11, JSONObject r12) {
        if (CommonEventDeliverer.needSkip(r10, Boolean.TRUE) == false) goto L6;
        n(r10, r12);
        return;
    L6:
        JSONObject r13 = q(r12);
        b(r13);
        CommonEventDeliverer.monitorStatusRate(r10, r11, r13);
        if (com.bytedance.apm.d.G() == false) goto L10;
        JSONObject r14 = o(r13, true);
        q0.c.a().b(new RunnableC0032c(r10, r11, r14));
        return;
    }

    private static void n(String r10, JSONObject r11) {
        if (com.bytedance.apm.d.D() == false) goto L8;
        if (r11 != null) goto L6;
        r11 = new JSONObject();
    L6:
        a0.a.b(r10, r11, false);
        return;
    }

    private static JSONObject o(JSONObject r10, boolean r11) {
        if (f820a == false) goto L8;
        if (r11 == true) goto L7;
        return r10;
    L7:
        return com.bytedance.apm.util.i.j(r10);
    L8:
        return com.bytedance.apm.util.i.c(r10);
    }

    private static JSONObject p(JSONObject r10) {
        if (f820a == false) goto L6;
        return com.bytedance.apm.util.i.j(r10);
    L6:
        return q(r10);
    }

    private static JSONObject q(JSONObject r10) {
        if (r10 != null) goto L6;
        r10 = new JSONObject();     // Catch: Exception -> L9
    L8:
        return r10;
    L6:
        if (r10.isNull("timestamp") == false) goto L8;
        r10.put("timestamp", System.currentTimeMillis());     // Catch: Exception -> L9
        goto L8
    }

    public static void r(Context r10, long r11, long r12, boolean r13) {
    }

    public static int s(String r10) {
        return i0.h.t(r10, true);
    L5:
        return 0;
    }

    public static void t(String r18, String r19) {
        monitor-enter(c.class);     // Catch: Throwable -> L40
        String r10 = com.bytedance.apm.d.h();     // Catch: Throwable -> L36
        long r11 = Thread.currentThread().getId();     // Catch: Throwable -> L36
        long r12 = System.currentTimeMillis();     // Catch: Throwable -> L36
        String r13 = x.a();     // Catch: Throwable -> L36
        StringBuffer r14 = new StringBuffer();     // Catch: Throwable -> L36
        r14.append(r18);     // Catch: Throwable -> L36
        r14.append("#");     // Catch: Throwable -> L36
        r14.append(r11);     // Catch: Throwable -> L36
        r14.append("#");     // Catch: Throwable -> L36
        r14.append(r12);     // Catch: Throwable -> L36
        r14.append("#");     // Catch: Throwable -> L36
        r14.append(r13);     // Catch: Throwable -> L36
        r14.append("\n");     // Catch: Throwable -> L36
        r14.append(r19);     // Catch: Throwable -> L36
        r14.append("\n");     // Catch: Throwable -> L36
        byte[] r15 = r14.toString().getBytes("UTF-8");     // Catch: Throwable -> L36
        String r16 = com.bytedance.apm.d.g().getExternalFilesDir(null).getAbsolutePath();     // Catch: Throwable -> L36
        if (f824e != null) goto L18;
        File r17 = new File(r16 + "/logs");     // Catch: Throwable -> L36
        f821b = new File(r16 + "/logs/proc: " + r10);     // Catch: Throwable -> L36
        File r20 = new File(r16 + "/logs/proc: " + r10 + "/" + r13);     // Catch: Throwable -> L36
        if (r17.exists() == true) goto L10;
        r17.mkdirs();     // Catch: Throwable -> L36
    L10:
        if (f821b.exists() == true) goto L12;
        f821b.mkdirs();     // Catch: Throwable -> L36
    L12:
        r20.createNewFile();     // Catch: Throwable -> L36
        FileChannel r110 = new RandomAccessFile(r20, "rw").getChannel();     // Catch: Throwable -> L36
        FileChannel.MapMode r111 = FileChannel.MapMode.READ_WRITE;     // Catch: Throwable -> L36
        if (com.bytedance.apm.d.I() == false) goto L15;
        long r112 = 2097152;
    L16:
        f824e = r110.map(r111, 0, r112);     // Catch: Throwable -> L36
        goto L18
    L15:
        r112 = 262144;
    L18:
        if (f824e.remaining() >= r15.length) goto L24;
        f824e.force();     // Catch: Throwable -> L36
        FileChannel r113 = new RandomAccessFile(new File(r16 + "/logs/proc: " + r10 + "/" + r13), "rw").getChannel();     // Catch: Throwable -> L36
        FileChannel.MapMode r114 = FileChannel.MapMode.READ_WRITE;     // Catch: Throwable -> L36
        if (com.bytedance.apm.d.I() == false) goto L22;
        long r115 = 2097152;
    L23:
        f824e = r113.map(r114, 0, r115);     // Catch: Throwable -> L36
        goto L24
    L22:
        r115 = 262144;
    L24:
        f824e.put(r15);     // Catch: Throwable -> L36
        if (f822c == (-1)) goto L29;
        if ((System.currentTimeMillis() - f822c) > 3600000) goto L29;
    L34:
        monitor-exit(c.class);     // Catch: Throwable -> L36
        goto L45
    L39:
        return;
    L29:
        if (com.bytedance.apm.util.f.b(f821b) <= ProcInfo.GB) goto L31;
    L32:
        u();     // Catch: Throwable -> L36
    L33:
        f822c = System.currentTimeMillis();     // Catch: Throwable -> L36
        goto L34
    L31:
        if (com.bytedance.apm.util.f.a(com.bytedance.apm.d.g()).getFreeSpace() >= ProcInfo.GB) goto L33;
    L36:
        th = move-exception;
        throw th;     // Catch: Throwable -> L40
    }

    private static void u() {
        if (com.bytedance.apm.d.I() == true) goto L6;
        return;
    L6:
        if (f821b.exists() == true) goto L8;
        return;
    L8:
        File[] r10 = f821b.listFiles();
        Arrays.sort(r10, new l());
        int r11 = 60;
        if (r10.length > 60) goto L12;
        r11 = r10.length;
    L12:
        int r12 = 0;
    L13:
        if (r12 >= r11) goto L15;
        r10[r12].delete();
        r12 = r12 + 1;
        goto L13
    }
}
