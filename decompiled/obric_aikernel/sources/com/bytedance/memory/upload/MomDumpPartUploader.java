package com.bytedance.memory.upload;

import android.text.TextUtils;
import com.bytedance.apm6.util.constant.ReportConsts;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
import t4.g;

/* JADX INFO: loaded from: classes.dex */
class MomDumpPartUploader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f2169a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f2170b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final File f2171c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final JSONObject f2172d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final JSONObject f2173e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final long f2174f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Map<String, String> f2175g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final File f2176h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private d f2177i;

    static final enum State extends Enum<State> {
        private static final /* synthetic */ State[] $VALUES = null;
        public static final State FAILED = null;
        public static final State FILE_TOO_SMALL = null;
        public static final State SUCCESS = null;
        public static final State TCC_DROP = null;

        static {
            State r10 = new State("SUCCESS", 0);
            SUCCESS = r10;
            State r11 = new State("TCC_DROP", 1);
            TCC_DROP = r11;
            State r12 = new State("FILE_TOO_SMALL", 2);
            FILE_TOO_SMALL = r12;
            State r13 = new State("FAILED", 3);
            FAILED = r13;
            $VALUES = new State[]{r10, r11, r12, r13};
        }

        private State(String r10, int r11) {
            super(r10, r11);
        }

        public static State valueOf(String r10) {
            return (State) Enum.valueOf(State.class, r10);
        }

        public static State[] values() {
            return (State[]) $VALUES.clone();
        }
    }

    static /* synthetic */ class a {
    }

    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final boolean f2178a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final List<Integer> f2179b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final String f2180c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final String f2181d;

        b(boolean r10, List<Integer> r11, String r12, String r13) {
            this.f2178a = r10;
            this.f2179b = r11;
            this.f2180c = r12;
            this.f2181d = r13;
        }
    }

    private static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final String f2182a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final long f2183b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final long f2184c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final int f2185d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final String f2186e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final String f2187f;

        c(String r10, long r11, long r12, int r13, String r14, String r15) {
            this.f2182a = r10;
            this.f2183b = r11;
            this.f2184c = r12;
            this.f2185d = r13;
            this.f2186e = r14;
            this.f2187f = r15;
        }
    }

    private static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f2188a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        long f2189b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        long f2190c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f2191d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        long f2192e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        long f2193f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        String f2194g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final List<Integer> f2195h;

        private d() {
            this.f2195h = new ArrayList();
        }

        /* synthetic */ d(a r10) {
            this();
        }

        static d b(JSONObject r10) {
            d r11 = new d();
            r11.f2188a = r10.optString("upload_id", null);
            r11.f2189b = r10.optLong("part_size", 0);
            r11.f2190c = r10.optLong("first_part_size", 0);
            int r12 = 0;
            r11.f2191d = r10.optInt("part_count", 0);
            r11.f2192e = r10.optLong("file_size", 0);
            r11.f2193f = r10.optLong("init_timestamp", 0);
            r11.f2194g = r10.optString("tos_url", null);
            JSONArray r13 = r10.optJSONArray("uploaded_parts");
            if (r13 != null) goto L5;
        L12:
            return r11;
        L5:
            if (r12 >= r13.length()) goto L12;
            int r14 = r13.optInt(r12, -1);
            if (r14 <= 0) goto L11;
            if (r11.f2195h.contains(Integer.valueOf(r14)) == true) goto L11;
            r11.f2195h.add(Integer.valueOf(r14));
        L11:
            r12 = r12 + 1;
            goto L5
        }

        void a(int r10) {
            if (r10 > 0) goto L5;
            return;
        L5:
            if (this.f2195h.contains(Integer.valueOf(r10)) == true) goto L8;
            this.f2195h.add(Integer.valueOf(r10));
            return;
        }

        JSONObject c() {
            JSONObject r10 = new JSONObject();
            r10.put("upload_id", this.f2188a);
            r10.put("part_size", this.f2189b);
            r10.put("first_part_size", this.f2190c);
            r10.put("part_count", this.f2191d);
            r10.put("file_size", this.f2192e);
            r10.put("init_timestamp", this.f2193f);
            if (TextUtils.isEmpty(this.f2194g) == true) goto L5;
            r10.put("tos_url", this.f2194g);
        L5:
            JSONArray r11 = new JSONArray();
            List<Integer> r12 = this.f2195h;
            if (r12 != null) goto L8;
        L17:
            r10.put("uploaded_parts", r11);
            return r10;
        L8:
            if (r12.isEmpty() == true) goto L17;
            ArrayList r13 = new ArrayList(this.f2195h);
            Collections.sort(r13);
            Iterator r14 = r13.iterator();
        L11:
            if (r14.hasNext() == false) goto L17;
            Integer r15 = (Integer) r14.next();
            if (r15 == null) goto L11;
            if (r15.intValue() <= 0) goto L11;
            r11.put(r15);
            goto L11
        }
    }

    static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final State f2196a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final String f2197b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final String f2198c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final boolean f2199d;

        e(State r10, String r11, String r12, boolean r13) {
            this.f2196a = r10;
            this.f2197b = r11;
            this.f2198c = r12;
            this.f2199d = r13;
        }

        boolean a() {
            State r10 = this.f2196a;
            if (r10 != State.SUCCESS) goto L5;
        L12:
            return true;
        L5:
            if (r10 == State.TCC_DROP) goto L12;
            if (r10 == State.FILE_TOO_SMALL) goto L9;
        L11:
            return false;
        L9:
            if (this.f2199d == false) goto L11;
            goto L11
        }
    }

    MomDumpPartUploader(String r10, File r11, JSONObject r12, JSONObject r13, Map<String, String> r14) {
        this(r10, r11, r12, r13, r14, 5242880);
    }

    MomDumpPartUploader(String r10, File r11, JSONObject r12, JSONObject r13, Map<String, String> r14, long r15) {
        this.f2169a = r10;
        this.f2171c = r11;
        this.f2172d = r12;
        this.f2173e = r13;
        this.f2174f = a(r15);
        this.f2175g = r14;
        this.f2170b = ReportConsts.HTTPS + new URL(r10).getAuthority();
        this.f2176h = new File(r11.getParentFile(), r11.getName() + ".partupload.tmp");
    }

    private static long a(long r10) {
        if (r10 >= 5242880) goto L6;
        return 5242880;
    L6:
        if (r10 <= 52428800) goto L8;
        return 52428800;
    L8:
        return r10;
    }

    private List<Integer> b(d r10) {
        ArrayList r11 = new ArrayList();
        if (r10 != null) goto L5;
    L16:
        return r11;
    L5:
        if (r10.f2191d <= 0) goto L16;
        int r12 = 1;
    L9:
        if (r12 > r10.f2191d) goto L16;
        List<Integer> r13 = r10.f2195h;
        if (r13 != null) goto L13;
    L14:
        r11.add(Integer.valueOf(r12));
    L15:
        r12 = r12 + 1;
        goto L9
    L13:
        if (r13.contains(Integer.valueOf(r12)) == true) goto L15;
        goto L14
    }

    private b c(c r10) {
        String r11 = r10.f2182a;
        if (TextUtils.isEmpty(r11) == false) goto L5;
        return null;
    L5:
        int r12 = 0;
        b r13 = null;
    L7:
        if (r12 >= 5) goto L42;
        r13 = e(r11);
        if (r13 == null) goto L59;
        if ("upload_expired".equals(r13.f2181d) == true) goto L13;
        if ("success".equals(r13.f2181d) == false) goto L17;
        if (r13.f2178a == true) goto L42;
        List<Integer> r14 = r13.f2179b;
        if (r14 == null) goto L40;
        if (r14.isEmpty() == true) goto L40;
        List<Integer> r15 = j(r13.f2179b, r10.f2185d);
        if (r15.isEmpty() == true) goto L40;
        Iterator<Integer> r16 = r15.iterator();
    L30:
        if (r16.hasNext() == false) goto L40;
        Integer r17 = r16.next();
        if (r17 == null) goto L30;
        if (r17.intValue() <= 0) goto L30;
        if (r(r10, r17.intValue()) == true) goto L30;
        return new b(false, r13.f2179b, r13.f2180c, "reupload_part_failed");
    L40:
        r12 = r12 + 1;
        goto L7
    L17:
        u3.a r18 = u3.a.b();
        String r19 = "upload_dump_parteupload_fail";
    L14:
        r18.f(r19);
        goto L42
    L13:
        r18 = u3.a.b();
        r19 = "upload_dump_parteupload_fail_expired";
        goto L14
    L59:
        return null;
    L42:
        return r13;
    }

    private void d() {
        File r10 = g();
        if (r10 != null) goto L5;
        return;
    L5:
        if (r10.exists() == false) goto L9;
        r10.delete();
        return;
    }

    private b e(String r10) {
        String r11 = this.f2170b + "/monitor/collect/c/mom_dump_collect_part/confirm";
        JSONObject r12 = new JSONObject();     // Catch: Throwable -> L26
        r12.put("upload_id", r10);     // Catch: Throwable -> L26
        t4.c r13 = com.bytedance.apm.d.d(r11, r12.toString().getBytes("UTF-8"), this.f2175g);     // Catch: Throwable -> L26
        if (r13 != null) goto L6;
    L25:
        return null;
    L6:
        if (r13.c() != 200) goto L25;
        if (r13.b() == null) goto L25;
        String r14 = new String(r13.b(), "UTF-8");     // Catch: Throwable -> L26
        if (TextUtils.isEmpty(r14) == false) goto L13;
        return null;
    L13:
        JSONObject r15 = new JSONObject(r14);     // Catch: Throwable -> L26
        String r16 = r15.optString("real_message", "");     // Catch: Throwable -> L26
        JSONObject r17 = r15.optJSONObject("data");     // Catch: Throwable -> L26
        if (r17 == null) goto L16;
        boolean r18 = r17.optBoolean("complete", false);     // Catch: Throwable -> L26
        String r19 = r17.optString("tos_url", null);     // Catch: Throwable -> L26
        ArrayList r20 = new ArrayList();     // Catch: Throwable -> L26
        JSONArray r21 = r17.optJSONArray("missing_parts");     // Catch: Throwable -> L26
        if (r21 == null) goto L24;
        int r22 = 0;
    L21:
        if (r22 >= r21.length()) goto L24;
        r20.add(Integer.valueOf(r21.optInt(r22)));     // Catch: Throwable -> L26
        r22 = r22 + 1;     // Catch: Throwable -> L26
    L24:
        return new b(r18, r20, r19, r16);
    L16:
        return new b(false, null, null, r16);
    L26:
        th = move-exception;
        p3.c.b(th, "MomDumpPartUploader confirm error", new Object[0]);
        return null;
    }

    private c f() {
        String r10 = this.f2170b + "/monitor/collect/c/mom_dump_collect_part/init";
        JSONObject r11 = new JSONObject();     // Catch: Throwable -> L20
        r11.put("header", this.f2172d);     // Catch: Throwable -> L20
        r11.put("data", this.f2173e);     // Catch: Throwable -> L20
        r11.put("file_size", this.f2171c.length());     // Catch: Throwable -> L20
        r11.put("part_size", this.f2174f);     // Catch: Throwable -> L20
        t4.c r12 = com.bytedance.apm.d.d(r10, r11.toString().getBytes("UTF-8"), this.f2175g);     // Catch: Throwable -> L20
        if (r12 != null) goto L6;
    L19:
        return null;
    L6:
        if (r12.c() != 200) goto L19;
        if (r12.b() == null) goto L19;
        String r13 = new String(r12.b(), "UTF-8");     // Catch: Throwable -> L20
        if (TextUtils.isEmpty(r13) == false) goto L13;
        return null;
    L13:
        JSONObject r14 = new JSONObject(r13);     // Catch: Throwable -> L20
        String r16 = r14.optString("real_message", "");     // Catch: Throwable -> L20
        JSONObject r15 = r14.optJSONObject("data");     // Catch: Throwable -> L20
        if (r15 != null) goto L18;
        return new c(null, 0, 0, 0, null, r16);
    L18:
        return new c(r15.optString("upload_id", null), r15.optLong("part_size", this.f2174f), r15.optLong("first_part_size", 0), r15.optInt("part_count", 0), r15.optString("tos_url", null), r16);
    L20:
        th = move-exception;
        p3.c.b(th, "MomDumpPartUploader init error", new Object[0]);
        return null;
    }

    private File g() {
        File r10 = this.f2171c;
        if (r10 == null) goto L5;
        File r11 = r10.getParentFile();
    L6:
        if (r11 != null) goto L9;
        return null;
    L9:
        return new File(r11, this.f2171c.getName() + ".momdump.partupload.state.json");
    L5:
        r11 = null;
        goto L6
    }

    private boolean h(d r10) {
        if (r10 != null) goto L6;
        return false;
    L6:
        if (TextUtils.isEmpty(r10.f2188a) == false) goto L8;
        return false;
    L8:
        if (r10.f2191d > 0) goto L10;
        return false;
    L10:
        if (r10.f2189b > 0) goto L12;
        return false;
    L12:
        if (r10.f2190c > 0) goto L14;
        return false;
    L14:
        if (r10.f2192e > 0) goto L16;
        return false;
    L16:
        if (r10.f2193f <= 0) goto L37;
        File r11 = this.f2171c;
        if (r11 != null) goto L21;
        return false;
    L21:
        if (r11.exists() == true) goto L24;
        return false;
    L24:
        if (r10.f2192e == this.f2171c.length()) goto L27;
        return false;
    L27:
        if ((System.currentTimeMillis() - r10.f2193f) > 604800000) goto L36;
        return true;
    L36:
        return false;
    L37:
        return false;
    }

    private void i(int r10) {
        d r11 = this.f2177i;
        if (r11 == null) goto L8;
        if (r10 <= 0) goto L9;
        r11.a(r10);
        s(this.f2177i);
        return;
    L9:
        return;
    }

    private List<Integer> j(List<Integer> r10, int r11) {
        ArrayList r12 = new ArrayList();
        if (r10 == null) goto L20;
        if (r11 <= 0) goto L20;
        Iterator<Integer> r13 = r10.iterator();
    L8:
        if (r13.hasNext() == false) goto L19;
        Integer r14 = r13.next();
        if (r14 == null) goto L8;
        int r15 = r14.intValue();
        if (r15 <= 0) goto L8;
        if (r15 > r11) goto L8;
        if (r12.contains(Integer.valueOf(r15)) == true) goto L8;
        r12.add(Integer.valueOf(r15));
        goto L8
    L19:
        Collections.sort(r12);
    L20:
        return r12;
    }

    private void k(int r10, long r11, long r12) {
        if (r10 != 1) goto L5;
        r12 = r11;
        long r13 = 0;
    L7:
        if (r13 < 0) goto L40;
        if (r12 <= 0) goto L40;
        if (r13 >= this.f2171c.length()) goto L40;
        RandomAccessFile r14 = null;
        RandomAccessFile r15 = new RandomAccessFile(this.f2171c, "r");     // Catch: Throwable -> L32
        r15.seek(r13);     // Catch: Throwable -> L29
        FileOutputStream r16 = new FileOutputStream(this.f2176h, false);     // Catch: Throwable -> L29
        byte[] r17 = new byte[8192];     // Catch: Throwable -> L27
    L18:
        if (r12 <= 0) goto L23;
        int r18 = r15.read(r17, 0, (int) Math.min(8192, r12));     // Catch: Throwable -> L27
        if (r18 == (-1)) goto L23;
        r16.write(r17, 0, r18);     // Catch: Throwable -> L27
        r12 = r12 - ((long) r18);     // Catch: Throwable -> L27
    L23:
        r16.flush();     // Catch: Throwable -> L27
        r15.close();     // Catch: IOException -> L41
    L45:
        r16.close();     // Catch: IOException -> L42
        return;
    L61:
        return;
    L27:
        th = th;
    L31:
        r14 = r15;
    L34:
        if (r14 != null) goto L51;
    L36:
        if (r16 == null) goto L62;
        r16.close();     // Catch: IOException -> L44
        throw th;
    L63:
        throw th;
    L62:
        throw th;
    L51:
        r14.close();     // Catch: IOException -> L43
    L29:
        th = th;
        r16 = null;
    L32:
        th = th;
        r16 = null;
    L40:
        throw new IOException("invalid part range: part=" + r10);
    L5:
        r13 = r11 + ((((long) r10) - 2) * r12);
        goto L7
    }

    private d l() {
        File r10 = g();
        if (r10 != null) goto L5;
    L34:
        return null;
    L5:
        if (r10.exists() == false) goto L34;
        if (r10.isFile() == false) goto L34;
        FileInputStream r11 = new FileInputStream(r10);     // Catch: Throwable -> L24
        StringBuilder r12 = new StringBuilder();     // Catch: Throwable -> L22
        byte[] r13 = new byte[4096];     // Catch: Throwable -> L22
    L12:
        int r14 = r11.read(r13);     // Catch: Throwable -> L22
        if (r14 == (-1)) goto L15;
        r12.append(new String(r13, 0, r14, "UTF-8"));     // Catch: Throwable -> L22
        goto L12
    L15:
        String r15 = r12.toString();     // Catch: Throwable -> L22
        if (TextUtils.isEmpty(r15) == true) goto L47;
        d r16 = d.b(new JSONObject(r15));     // Catch: Throwable -> L22
        r11.close();     // Catch: IOException -> L35
    L21:
        return r16;
    L47:
        r11.close();     // Catch: IOException -> L36
    L18:
        return null;
    L22:
        th = th;
    L41:
        p3.c.b(th, "MomDumpPartUploader read state error", new Object[0]);     // Catch: Throwable -> L30
        if (r11 != null) goto L51;
    L29:
        return null;
    L51:
        r11.close();     // Catch: IOException -> L37
    L30:
        th = move-exception;
        if (r11 != null) goto L43;
    L33:
        throw th;
    L43:
        r11.close();     // Catch: IOException -> L38
    L24:
        th = th;
        r11 = null;
        goto L41
    }

    private static void m(long r10) {
        Thread.sleep(r10);     // Catch: InterruptedException -> L4
        return;
    L4:
        Thread.currentThread().interrupt();
    }

    private boolean o(c r10, List<Integer> r11) {
        if (r10.f2185d > 0) goto L5;
    L35:
        return false;
    L5:
        if (r10.f2184c <= 0) goto L35;
        if (r10.f2183b <= 0) goto L35;
        if (TextUtils.isEmpty(r10.f2182a) == true) goto L35;
        if (r11 != null) goto L14;
    L19:
        List<Integer> r12 = new ArrayList(r10.f2185d);
        int r13 = 1;
    L21:
        if (r13 > r10.f2185d) goto L23;
        r12.add(Integer.valueOf(r13));
        r13 = r13 + 1;
    L23:
        Iterator<Integer> r14 = r12.iterator();
    L25:
        if (r14.hasNext() == false) goto L34;
        Integer r15 = r14.next();
        if (r15 == null) goto L25;
        if (r15.intValue() <= 0) goto L25;
        if (r(r10, r15.intValue()) == true) goto L25;
        return false;
    L34:
        return true;
    L14:
        if (r11.isEmpty() == true) goto L19;
        r12 = j(r11, r10.f2185d);
        if (r12.isEmpty() == false) goto L23;
        return true;
    }

    private String q(String r12, int r13, long r14, long r16) {
        g r10 = com.bytedance.apm.d.b(this.f2170b + "/monitor/collect/c/mom_dump_collect_part/upload", "UTF-8", false, this.f2175g);     // Catch: Throwable -> L29
        r10.addFormField("upload_id", r12);     // Catch: Throwable -> L29
        r10.addFormField("part_number", String.valueOf(r13));     // Catch: Throwable -> L29
        k(r13, r14, r16);     // Catch: Throwable -> L29
        r10.a("file", this.f2176h, "application/octet-stream", Collections.emptyMap());     // Catch: Throwable -> L29
        HashMap<String, Object> r11 = new HashMap();     // Catch: Throwable -> L29
        r11.put("partNumber", Integer.valueOf(r13));     // Catch: Throwable -> L29
        u3.a.b().c("upload_dump_parteupload", r11);     // Catch: Throwable -> L29
        StringBuilder r15 = new StringBuilder();     // Catch: Throwable -> L29
        r15.append("log upload_dump_parteupload_");     // Catch: Throwable -> L29
        r15.append(r13);     // Catch: Throwable -> L27
        p3.c.c(r15.toString(), new Object[0]);     // Catch: Throwable -> L27
        t4.c r17 = r10.finish();     // Catch: Throwable -> L27
        if (r17 == null) goto L24;
        if (r17.c() != 200) goto L24;
        if (r17.b() == null) goto L24;
        String r18 = new String(r17.b(), "UTF-8");     // Catch: Throwable -> L27
        if (TextUtils.isEmpty(r18) == true) goto L15;
        String r19 = new JSONObject(r18).optString("real_message", "");     // Catch: Throwable -> L27
        if (this.f2176h.exists() == false) goto L22;
        this.f2176h.delete();
    L22:
        return r19;
    L15:
        if (this.f2176h.exists() == false) goto L17;
        this.f2176h.delete();
    L17:
        return "";
    L24:
        if (this.f2176h.exists() == false) goto L26;
        this.f2176h.delete();
    L26:
        return "";
    L27:
        th = th;
    L41:
        p3.c.b(th, "MomDumpPartUploader uploadSinglePart error, part=%d", new Object[]{Integer.valueOf(r13)});     // Catch: Throwable -> L36
        u3.a.b().f("upload_dump_parteupload_fail");     // Catch: Throwable -> L36
        if (this.f2176h.exists() == false) goto L35;
        this.f2176h.delete();
    L35:
        return "";
    L36:
        th = move-exception;
        if (this.f2176h.exists() == false) goto L40;
        this.f2176h.delete();
    L40:
        throw th;
    L29:
        th = th;
        goto L41
    }

    private boolean r(c r11, int r12) {
        int r10 = 0;
    L4:
        if (r10 >= 3) goto L16;
        String r13 = q(r11.f2182a, r12, r11.f2184c, r11.f2183b);
        if ("success".equals(r13) == true) goto L7;
        if ("upload_expired".equals(r13) == true) goto L10;
        r10 = r10 + 1;
        m(((long) r10) * 1000);
        goto L4
    L10:
        return false;
    L7:
        i(r12);
        return true;
    L16:
        return false;
    }

    private void s(d r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        File r11 = g();
        if (r11 != null) goto L7;
        return;
    L7:
        FileOutputStream r12 = null;
        byte[] r13 = r10.c().toString().getBytes("UTF-8");     // Catch: Throwable -> L14
        FileOutputStream r14 = new FileOutputStream(r11, false);     // Catch: Throwable -> L14
        r14.write(r13);     // Catch: Throwable -> L12
        r14.flush();     // Catch: Throwable -> L12
        r14.close();     // Catch: IOException -> L23
    L25:
        return;
    L12:
        th = th;
        r12 = r14;
    L30:
        p3.c.b(th, "MomDumpPartUploader write state error", new Object[0]);     // Catch: Throwable -> L19
        if (r12 == null) goto L35;
        r12.close();     // Catch: IOException -> L23
        goto L25
    L35:
        return;
    L19:
        th = move-exception;
        if (r12 != null) goto L32;
    L22:
        throw th;
    L32:
        r12.close();     // Catch: IOException -> L24
    L14:
        th = th;
    }

    /* JADX WARN: Multi-variable type inference failed */
    e n() {
        File r10 = this.f2171c;     // Catch: Throwable -> L109
        if (r10 != null) goto L6;
    L104:
        e r11 = new e(State.FAILED, "", "invalid_file", false);     // Catch: Throwable -> L109
        if (this.f2176h.exists() == false) goto L108;
        this.f2176h.delete();
    L108:
        return r11;
    L6:
        if (r10.exists() == false) goto L104;
        if (this.f2171c.length() <= 0) goto L104;
        d r12 = l();     // Catch: Throwable -> L109
        String r13 = null;
        Object[] r14 = 0;
        if (h(r12) == false) goto L38;
        u3.a.b().e(r12.f2188a);     // Catch: Throwable -> L109
        u3.a.b().f("partsToUpload_hasinfo");     // Catch: Throwable -> L109
        this.f2177i = r12;     // Catch: Throwable -> L109
        c r15 = new c(r12.f2188a, r12.f2189b, r12.f2190c, r12.f2191d, r12.f2194g, "success");     // Catch: Throwable -> L109
        b r16 = e(r12.f2188a);     // Catch: Throwable -> L109
        if (r16 != null) goto L16;
    L34:
        if (r16 != null) goto L36;
    L33:
        List<Integer> r17 = b(r12);     // Catch: Throwable -> L109
    L39:
        if (r15 != null) goto L74;
        r15 = f();     // Catch: Throwable -> L109
        if (r15 != null) goto L47;
        u3.a.b().f("partsToUpload_doInit_null");     // Catch: Throwable -> L109
        e r18 = new e(State.FAILED, "", "init_failed", false);     // Catch: Throwable -> L109
        if (this.f2176h.exists() == false) goto L46;
        this.f2176h.delete();
    L46:
        return r18;
    L47:
        u3.a.b().e(r15.f2182a);     // Catch: Throwable -> L109
        u3.a.b().f("partsToUpload_doInit");     // Catch: Throwable -> L109
        if ("tcc_drop".equals(r15.f2187f) == false) goto L55;
        d();     // Catch: Throwable -> L109
        e r19 = new e(State.TCC_DROP, "", r15.f2187f, false);     // Catch: Throwable -> L109
        if (this.f2176h.exists() == false) goto L53;
        this.f2176h.delete();
    L53:
        return r19;
    L55:
        if ("file_too_small".equals(r15.f2187f) == false) goto L66;
        d();     // Catch: Throwable -> L109
        boolean r20 = p();     // Catch: Throwable -> L109
        if (r20 == false) goto L59;
        State r21 = State.FILE_TOO_SMALL;     // Catch: Throwable -> L109
    L60:
        e r22 = new e(r21, null, r15.f2187f, r20);     // Catch: Throwable -> L109
        if (this.f2176h.exists() == false) goto L64;
        this.f2176h.delete();
    L64:
        return r22;
    L59:
        r21 = State.FAILED;     // Catch: Throwable -> L109
        goto L60
    L66:
        if ("success".equals(r15.f2187f) == true) goto L72;
        d();     // Catch: Throwable -> L109
        e r23 = new e(State.FAILED, "", r15.f2187f, false);     // Catch: Throwable -> L109
        if (this.f2176h.exists() == false) goto L71;
        this.f2176h.delete();
    L71:
        return r23;
    L72:
        d r24 = new d(r14 == true ? 1 : 0);     // Catch: Throwable -> L109
        r24.f2188a = r15.f2182a;     // Catch: Throwable -> L109
        r24.f2189b = r15.f2183b;     // Catch: Throwable -> L109
        r24.f2190c = r15.f2184c;     // Catch: Throwable -> L109
        r24.f2191d = r15.f2185d;     // Catch: Throwable -> L109
        r24.f2192e = this.f2171c.length();     // Catch: Throwable -> L109
        r24.f2193f = System.currentTimeMillis();     // Catch: Throwable -> L109
        r24.f2194g = r15.f2186e;     // Catch: Throwable -> L109
        this.f2177i = r24;     // Catch: Throwable -> L109
        s(r24);     // Catch: Throwable -> L109
        r17 = null;
    L74:
        if (o(r15, r17) == true) goto L80;
        e r25 = new e(State.FAILED, "", "upload_parts_failed", false);     // Catch: Throwable -> L109
        if (this.f2176h.exists() == false) goto L79;
        this.f2176h.delete();
    L79:
        return r25;
    L80:
        u3.a.b().f("partsToUpload_confirmInfo");     // Catch: Throwable -> L109
        b r26 = c(r15);     // Catch: Throwable -> L109
        if (r26 != null) goto L83;
    L93:
        if (r26 != null) goto L95;
        String r27 = "confirm_failed";
    L96:
        if (r26 == null) goto L99;
        r13 = r26.f2180c;     // Catch: Throwable -> L109
    L99:
        e r28 = new e(State.FAILED, r13, r27, false);     // Catch: Throwable -> L109
        if (this.f2176h.exists() == false) goto L103;
        this.f2176h.delete();
    L103:
        return r28;
    L95:
        r27 = r26.f2181d;     // Catch: Throwable -> L109
        goto L96
    L83:
        if (r26.f2178a == false) goto L93;
        if ("success".equals(r26.f2181d) == false) goto L93;
        if (TextUtils.isEmpty(r26.f2180c) == true) goto L93;
        d();     // Catch: Throwable -> L109
        e r29 = new e(State.SUCCESS, r26.f2180c, r26.f2181d, false);     // Catch: Throwable -> L109
        if (this.f2176h.exists() == false) goto L92;
        this.f2176h.delete();
    L92:
        return r29;
    L36:
        if ("upload_expired".equals(r16.f2181d) == false) goto L33;
        d();     // Catch: Throwable -> L109
        this.f2177i = null;     // Catch: Throwable -> L109
        goto L38
    L16:
        if ("success".equals(r16.f2181d) == false) goto L34;
        if (r16.f2178a == false) goto L28;
        d();     // Catch: Throwable -> L109
        if (TextUtils.isEmpty(r16.f2180c) == true) goto L22;
        String r30 = r16.f2180c;     // Catch: Throwable -> L109
    L23:
        e r31 = new e(State.SUCCESS, r30, r16.f2181d, false);     // Catch: Throwable -> L109
        if (this.f2176h.exists() == false) goto L27;
        this.f2176h.delete();
    L27:
        return r31;
    L22:
        r30 = r12.f2194g;     // Catch: Throwable -> L109
        goto L23
    L28:
        List<Integer> r32 = r16.f2179b;     // Catch: Throwable -> L109
        if (r32 == null) goto L33;
        if (r32.isEmpty() == true) goto L33;
        r17 = j(r16.f2179b, r12.f2191d);     // Catch: Throwable -> L109
    L38:
        r17 = null;
        r15 = null;
    L109:
        th = move-exception;
        p3.c.b(th, "MomDumpPartUploader upload error", new Object[0]);     // Catch: Throwable -> L115
        e r33 = new e(State.FAILED, "", th.getMessage(), false);     // Catch: Throwable -> L115
        if (this.f2176h.exists() == false) goto L114;
        this.f2176h.delete();
    L114:
        return r33;
    L115:
        th = move-exception;
        if (this.f2176h.exists() == false) goto L119;
        this.f2176h.delete();
    L119:
        throw th;
    }

    public boolean p() {
        ArrayList r10 = new ArrayList(1);     // Catch: Throwable -> L13
        r10.add(this.f2171c);     // Catch: Throwable -> L13
        HashMap r11 = new HashMap(2);     // Catch: Throwable -> L13
        r11.put("header", this.f2172d.toString());     // Catch: Throwable -> L13
        r11.put("data", this.f2173e.toString());     // Catch: Throwable -> L13
        String r12 = null;
        u3.a.b().e(null);     // Catch: Throwable -> L13
        u3.a.b().f("upload_dump_singleupload");     // Catch: Throwable -> L13
        t4.c r13 = com.bytedance.apm.d.n0(this.f2169a, r10, r11);     // Catch: Throwable -> L13
        if (r13 != null) goto L6;
    L15:
        return false;
    L6:
        if (r13.c() != 200) goto L15;
        byte[] r14 = r13.b();     // Catch: Throwable -> L13
        if (r14 == null) goto L11;
        r12 = new String(r14);     // Catch: Throwable -> L13
    L11:
        p3.c.c("uploadSingleFile message:" + r12 + " code:" + r13.c(), new Object[0]);     // Catch: Throwable -> L13
        return TextUtils.isEmpty(r12);
    L13:
        th = move-exception;
        p3.c.b(th, "MomDumpPartUploader single upload error", new Object[0]);
        goto L15
    }
}
