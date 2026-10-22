package com.loc;

import android.content.Context;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.obric.aivoice.core.data.NameKeys;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import n4a.f5;
import n4a.l1;
import n4a.y;
import n4a.y4;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class u {
    public static volatile b a;
    public static volatile d b;
    public static volatile String c;
    public static volatile String d;
    public static volatile long e;
    public static volatile a f;
    public static volatile long g;
    public static volatile String h;
    public static volatile String i;
    public static volatile long j;
    public static volatile long k;
    public static volatile boolean l;
    public static volatile boolean m;

    public static final enum a extends Enum<a> {
        public static final a a = null;
        public static final a b = null;
        public static final a c = null;
        public static final /* synthetic */ a[] e = null;
        private int d;

        static {
            a r0 = new a("Unknow", 0, -1);
            a = r0;
            a r1 = new a("NotAgree", 1, 0);
            b = r1;
            a r2 = new a("DidAgree", 2, 1);
            c = r2;
            e = new a[]{r0, r1, r2};
        }

        public a(String r1, int r2, int r3) {
            super(r1, r2);
            this.d = r3;
        }

        public static a a(int r2) {
            a r0 = b;
            if (r2 != r0.a()) goto L5;
            return r0;
        L5:
            a r1 = c;
            if (r2 != r1.a()) goto L9;
            return r1;
        L9:
            return a;
        }

        public static a valueOf(String r1) {
            return (a) r27.a.a(a.class, r1);
        }

        public static a[] values() {
            return (a[]) e.clone();
        }

        public final int a() {
            return this.d;
        }
    }

    public static final enum b extends Enum<b> {
        public static final b a = null;
        public static final b b = null;
        public static final b c = null;
        public static final /* synthetic */ b[] e = null;
        private int d;

        static {
            b r0 = new b("Unknow", 0, -1);
            a = r0;
            b r1 = new b("NotContain", 1, 0);
            b = r1;
            b r2 = new b("DidContain", 2, 1);
            c = r2;
            e = new b[]{r0, r1, r2};
        }

        public b(String r1, int r2, int r3) {
            super(r1, r2);
            this.d = r3;
        }

        public static b a(int r2) {
            b r0 = b;
            if (r2 != r0.a()) goto L5;
            return r0;
        L5:
            b r1 = c;
            if (r2 != r1.a()) goto L9;
            return r1;
        L9:
            return a;
        }

        public static b valueOf(String r1) {
            return (b) r27.a.a(b.class, r1);
        }

        public static b[] values() {
            return (b[]) e.clone();
        }

        public final int a() {
            return this.d;
        }
    }

    public static final enum c extends Enum<c> {
        public static final c a = null;
        public static final c b = null;
        public static final c c = null;
        public static final c d = null;
        public static final c e = null;
        public static final c f = null;
        public static final c g = null;
        public static final c h = null;
        public static final c i = null;
        public static final /* synthetic */ c[] k = null;
        private final int j;

        static {
            c r0 = new c("SuccessCode", 0, 0);
            a = r0;
            c r1 = new c("ShowUnknowCode", 1, 555570);
            b = r1;
            c r3 = new c("ShowNoShowCode", 2, 555571);
            c = r3;
            c r4 = new c("InfoUnknowCode", 3, 555572);
            d = r4;
            c r6 = new c("InfoNotContainCode", 4, 555573);
            e = r6;
            c r8 = new c("AgreeUnknowCode", 5, 555574);
            f = r8;
            c r10 = new c("AgreeNotAgreeCode", 6, 555575);
            g = r10;
            c r12 = new c("InvaildUserKeyCode", 7, 10001);
            h = r12;
            c r14 = new c("IllegalArgument", 8, 20001);
            i = r14;
            k = new c[]{r0, r1, r3, r4, r6, r8, r10, r12, r14};
        }

        public c(String r1, int r2, int r3) {
            super(r1, r2);
            this.j = r3;
        }

        public static c valueOf(String r1) {
            return (c) r27.a.a(c.class, r1);
        }

        public static c[] values() {
            return (c[]) k.clone();
        }

        public final int a() {
            return this.j;
        }
    }

    public static final enum d extends Enum<d> {
        public static final d a = null;
        public static final d b = null;
        public static final d c = null;
        public static final /* synthetic */ d[] e = null;
        private int d;

        static {
            d r0 = new d("Unknow", 0, -1);
            a = r0;
            d r1 = new d("NotShow", 1, 0);
            b = r1;
            d r2 = new d("DidShow", 2, 1);
            c = r2;
            e = new d[]{r0, r1, r2};
        }

        public d(String r1, int r2, int r3) {
            super(r1, r2);
            this.d = r3;
        }

        public static d a(int r2) {
            d r0 = b;
            if (r2 != r0.a()) goto L5;
            return r0;
        L5:
            d r1 = c;
            if (r2 != r1.a()) goto L9;
            return r1;
        L9:
            return a;
        }

        public static d valueOf(String r1) {
            return (d) r27.a.a(d.class, r1);
        }

        public static d[] values() {
            return (d[]) e.clone();
        }

        public final int a() {
            return this.d;
        }
    }

    public class e extends l1 {
        public final /* synthetic */ boolean b;
        public final /* synthetic */ Context c;
        public final /* synthetic */ long d;
        public final /* synthetic */ JSONObject e;

        public e(boolean r1, Context r2, long r3, JSONObject r5) {
            this.b = r1;
            this.c = r2;
            this.d = r3;
            this.e = r5;
        }

        @Override // n4a.l1
        public final void a() {
            if (this.b == false) goto L8;
            Iterator<File> r1 = u.c(u.h(this.c)).iterator();
        L6:
            if (r1.hasNext() == false) goto L8;
            u.a(this.c, r1.next().getName());
        L8:
            u.f(this.c);
            Context r2 = this.c;
            JSONObject r3 = this.e;
            long r4 = this.d;
            byte[] r5 = r3.toString().getBytes();     // Catch: Throwable -> L28
            byte[] r6 = y.j(r2);     // Catch: Throwable -> L19
            byte[] r7 = y.b;     // Catch: Throwable -> L19
            if (r7 != null) goto L14;
        L16:
            r7 = Arrays.copyOfRange(y.j(r2), 0, y.j(r2).length / 2);     // Catch: Throwable -> L19
            y.b = r7;     // Catch: Throwable -> L19
        L17:
            byte[] r8 = y4.f(r6, r5, r7);     // Catch: Throwable -> L19
        L20:
            String r9 = u.b(r4);     // Catch: Throwable -> L28
            PolarisFileWrapper r10 = new PolarisFileWrapper(u.h(r2) + "/" + r9);     // Catch: Throwable -> L28
            if (r10.getParentFile().exists() == true) goto L23;
            r10.getParentFile().mkdirs();     // Catch: Throwable -> L28
        L23:
            PolarisFileOutputStreamWrapper r11 = new PolarisFileOutputStreamWrapper(r10);     // Catch: Throwable -> L28
            r11.write(r8);     // Catch: Throwable -> L26
        L69:
            r11.close();     // Catch: Throwable -> L34
        L36:
            boolean r12 = u.e(this.c, this.e);
            if (r12 != true) goto L51;
            Context r13 = this.c;
            String r14 = u.b(this.d);
            if (r14 == null) goto L51;
            if (r14.length() == 0) goto L51;
            PolarisFileWrapper r15 = new PolarisFileWrapper(u.h(r13) + "/" + r14);     // Catch: Throwable -> L48
            if (r15.exists() == false) goto L51;
            r15.delete();     // Catch: Throwable -> L48
        L48:
            th = move-exception;
            th.printStackTrace();
        L51:
            if (this.b == false) goto L53;
            u.d(this.c);
        L53:
            if (r12 == true) goto L78;
            u.a(this.c, u.b(this.d));
            return;
        L78:
            return;
        L34:
            th = move-exception;
            th.printStackTrace();
        L26:
            Throwable th = th;
        L73:
            th.printStackTrace();     // Catch: Throwable -> L56
            if (r11 == null) goto L36;
        L56:
            th = move-exception;
            if (r11 != null) goto L67;
        L62:
            throw th;
        L67:
            r11.close();     // Catch: Throwable -> L60
        L60:
            th = move-exception;
            th.printStackTrace();
            goto L62
        L14:
            if (r7.length <= 0) goto L16;
        L19:
            r8 = new byte[0];     // Catch: Throwable -> L28
        L28:
            th = move-exception;
            th = th;
            r11 = null;
            goto L73
        }
    }

    static {
        a = b.a;
        b = d.a;
        c = NameKeys.UnloadStrategy_No_Strategy;
        d = NameKeys.UnloadStrategy_No_Strategy;
        e = -1;
        f = a.a;
        g = -1;
        h = NameKeys.UnloadStrategy_No_Strategy;
        i = NameKeys.UnloadStrategy_No_Strategy;
        j = 0;
        k = 0;
        l = false;
        m = true;
    }

    public static String b(long r2) {
        return String.format("%d-%s", new Object[]{Long.valueOf(r2), "privacy.data"});
    }

    public static ArrayList<File> c(String r4) {
        ArrayList<File> r0 = new ArrayList();
        if (r4 != null) goto L5;
    L17:
        return r0;
    L5:
        if (r4.length() == 0) goto L17;
        PolarisFileWrapper r1 = new PolarisFileWrapper(r4);
        if (r1.exists() == true) goto L10;
        return r0;
    L10:
        File[] r5 = r1.listFiles();
        int r2 = 0;
    L12:
        if (r2 >= r5.length) goto L17;
        File r3 = r5[r2];
        if (r3.isFile() == false) goto L16;
        r0.add(r3);
    L16:
        r2 = r2 + 1;
        goto L12
    }

    public static synchronized void f(Context r6) {
        monitor-enter(u.class);
        if (r6 != null) goto L22;
        monitor-exit(u.class);
        return;
    L22:
    L17:
        th = move-exception;
        throw th;
    L8:
        if (l == true) goto L20;
        g(r6);     // Catch: Throwable -> L17
        l = true;     // Catch: Throwable -> L17
    L20:
        y.d(r6, "AMap.privacy.data", "AMap.privacy.data", String.format("%d&%d&%d&%s&%s&%d&%d&%s&%s&%d&%d", new Object[]{Integer.valueOf(a.a()), Integer.valueOf(b.a()), Long.valueOf(e), c, d, Integer.valueOf(f.a()), Long.valueOf(g), h, i, Long.valueOf(j), Long.valueOf(k)}));     // Catch: Throwable -> L13
        monitor-exit(u.class);
        return;
    L13:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L17
    }

    public static void g(Context r2) {
        if (r2 != null) goto L22;
        return;
    L22:
        String r3 = y.c(r2, "AMap.privacy.data", "AMap.privacy.data");     // Catch: Throwable -> L7
    L9:
        if (r3 != null) goto L11;
        return;
    L11:
        String[] r4 = r3.split("&");
        if (r4.length == 11) goto L20;
        return;
    L20:
        a = b.a(CastIntegerProtector.parseInt(r4[0]));     // Catch: Throwable -> L17
        b = d.a(CastIntegerProtector.parseInt(r4[1]));     // Catch: Throwable -> L17
        e = CastLongProtector.parseLong(r4[2]);     // Catch: Throwable -> L17
        d = r4[3];     // Catch: Throwable -> L17
        d = r4[4];     // Catch: Throwable -> L17
        f = a.a(CastIntegerProtector.parseInt(r4[5]));     // Catch: Throwable -> L17
        g = CastLongProtector.parseLong(r4[6]);     // Catch: Throwable -> L17
        h = r4[7];     // Catch: Throwable -> L17
        i = r4[8];     // Catch: Throwable -> L17
        j = CastLongProtector.parseLong(r4[9]);     // Catch: Throwable -> L17
        k = CastLongProtector.parseLong(r4[10]);     // Catch: Throwable -> L17
        return;
    L17:
        th = move-exception;
        th.printStackTrace();
        return;
    L7:
        th = move-exception;
        th.printStackTrace();
        r3 = null;
        goto L9
    }

    public static String h(Context r1) {
        return r1.getFilesDir().getAbsolutePath() + "/AMap/Privacy/Upload";
    }

    public static void d(Context r9) {
        Iterator<File> r0 = c(r9.getFilesDir().getAbsolutePath() + "/AMap/Privacy/Reload").iterator();     // Catch: Throwable -> L36
    L3:
        if (r0.hasNext() == false) goto L35;
        File r1 = r0.next();     // Catch: Throwable -> L36
        String r2 = r1.getName();     // Catch: Throwable -> L26
        if (r2.endsWith("-privacy.data") == false) goto L31;
        String[] r3 = r2.split("-");     // Catch: Throwable -> L26
        if (r3 != null) goto L15;
        if (r3.length != 2) goto L31;
    L15:
        if (CastLongProtector.parseLong(r3[0]) <= 0) goto L31;
        PolarisFileInputStreamWrapper r4 = new PolarisFileInputStreamWrapper(r1);     // Catch: Throwable -> L26
        byte[] r5 = new byte[r4.available()];     // Catch: Throwable -> L26
        r4.read(r5);     // Catch: Throwable -> L26
        byte[] r6 = y.j(r9);     // Catch: Throwable -> L26 Exception -> L28
        byte[] r7 = y.b;     // Catch: Throwable -> L26 Exception -> L28
    L19:
        if (r7 != null) goto L21;
    L23:
        r7 = Arrays.copyOfRange(y.j(r9), 0, y.j(r9).length / 2);     // Catch: Throwable -> L26 Exception -> L28
        y.b = r7;     // Catch: Throwable -> L26 Exception -> L28
    L24:
        byte[] r8 = y4.c(r6, r5, r7);     // Catch: Throwable -> L26 Exception -> L28
    L30:
        if (e(r9, new JSONObject(new String(r8))) == false) goto L3;
    L21:
        if (r7.length <= 0) goto L23;
    L28:
        r8 = new byte[0];     // Catch: Throwable -> L26
    L31:
        r1.delete();     // Catch: Throwable -> L26
        goto L3
    L26:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L36
        goto L3
    L35:
        return;
    L36:
        th = move-exception;
        th.printStackTrace();
    }

    public static void a(Context r3, String r4) {
        if (r4 != null) goto L5;
        return;
    L5:
        if (r4.length() == 0) goto L21;
        PolarisFileWrapper r2 = new PolarisFileWrapper(h(r3) + "/" + r4);     // Catch: Throwable -> L15
        if (r2.exists() == true) goto L10;
        return;
    L10:
        PolarisFileWrapper r5 = new PolarisFileWrapper((r3.getFilesDir().getAbsolutePath() + "/AMap/Privacy/Reload") + "/" + r4);     // Catch: Throwable -> L15
        if (r5.getParentFile().exists() == true) goto L13;
        r5.getParentFile().mkdirs();     // Catch: Throwable -> L15
    L13:
        r2.renameTo(r5);     // Catch: Throwable -> L15
        return;
    L15:
        th = move-exception;
        th.printStackTrace();
        return;
    }

    public static boolean e(Context r3, JSONObject r4) {
        n4a.u r2 = new n4a.u();     // Catch: Throwable -> L9
        r2.l = r3;     // Catch: Throwable -> L9
        r2.k = r4;     // Catch: Throwable -> L9
        i.x();     // Catch: Throwable -> L9
        JSONObject r5 = new JSONObject(f5.d(com.loc.c.a(r2).a));     // Catch: Throwable -> L9
        if (r5.has("status") == false) goto L14;
        if (JSONObjectProtectorUtils.getInt(r5, "status") != 1) goto L15;
        return true;
    L15:
        return false;
    L14:
        return false;
    L9:
        th = move-exception;
        th.printStackTrace();
        return false;
    }
}
