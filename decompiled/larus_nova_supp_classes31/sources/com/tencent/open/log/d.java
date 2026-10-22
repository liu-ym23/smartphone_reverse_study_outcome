package com.tencent.open.log;

import android.os.Bundle;
import android.os.Environment;
import android.os.StatFs;
import java.io.File;
import java.text.SimpleDateFormat;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public class d {

    public static final class a {
        public static final boolean a(int r0, int r1) {
            if (r1 != (r0 & r1)) goto L5;
            return true;
        L5:
            return false;
        }
    }

    public static final class b {
        public static boolean a() {
            String r0 = Environment.getExternalStorageState();
            if ("mounted".equals(r0) == false) goto L5;
        L8:
            return true;
        L5:
            if ("mounted_ro".equals(r0) == true) goto L8;
            return false;
        }

        public static c b() {
            if (a() == true) goto L7;
            return null;
        L7:
            return c.b(Environment.getExternalStorageDirectory());
        }
    }

    public static class c {
        private File a;
        private long b;
        private long c;

        public c() {
        }

        public String toString() {
            return String.format("[%s : %d / %d]", new Object[]{a().getAbsolutePath(), Long.valueOf(c()), Long.valueOf(b())});
        }

        public File a() {
            return this.a;
        }

        public long b() {
            return this.b;
        }

        public long c() {
            return this.c;
        }

        public static c b(File r8) {
            c r0 = new c();
            r0.a(r8);
            StatFs r1 = new StatFs(r8.getAbsolutePath());
            long r2 = r1.getBlockSize();
            long r4 = r1.getBlockCount();
            long r6 = r1.getAvailableBlocks();
            r0.a(r4 * r2);
            r0.b(r6 * r2);
            return r0;
        }

        public void a(long r1) {
            this.b = r1;
        }

        public void a(File r1) {
            this.a = r1;
        }

        public void b(long r1) {
            this.c = r1;
        }
    }

    /* JADX INFO: renamed from: com.tencent.open.log.d$d, reason: collision with other inner class name */
    public static final class C0053d {
        public static SimpleDateFormat a(String r1) {
            return new SimpleDateFormat(r1);
        }
    }

    public static boolean a(Bundle r1) {
        if (r1.containsKey("access_token") == false) goto L5;
    L18:
        return true;
    L5:
        if (r1.containsKey("pay_token") == true) goto L18;
        if (r1.containsKey("pfkey") == true) goto L18;
        if (r1.containsKey("expires_in") == true) goto L18;
        if (r1.containsKey("openid") == true) goto L18;
        if (r1.containsKey("proxy_code") == true) goto L18;
        if (r1.containsKey("proxy_expires_in") == true) goto L18;
        return false;
    }

    public static Bundle b(Bundle r1) {
        if (a(r1) == true) goto L5;
        return r1;
    L5:
        Bundle r0 = new Bundle(r1);
        r0.remove("access_token");
        r0.remove("pay_token");
        r0.remove("pfkey");
        r0.remove("expires_in");
        r0.remove("openid");
        r0.remove("proxy_code");
        r0.remove("proxy_expires_in");
        return r0;
    }

    public static boolean a(String r1) {
        if (r1.contains("access_token") == false) goto L5;
    L18:
        return true;
    L5:
        if (r1.contains("pay_token") == true) goto L18;
        if (r1.contains("pfkey") == true) goto L18;
        if (r1.contains("expires_in") == true) goto L18;
        if (r1.contains("openid") == true) goto L18;
        if (r1.contains("proxy_code") == true) goto L18;
        if (r1.contains("proxy_expires_in") == true) goto L18;
        return false;
    }
}
