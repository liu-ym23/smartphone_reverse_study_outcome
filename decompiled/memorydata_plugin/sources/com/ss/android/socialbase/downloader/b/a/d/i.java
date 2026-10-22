package com.ss.android.socialbase.downloader.b.a.d;

import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.obric.memorydata.database.entity.ChatMessage;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private DownloadInfo f15267a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f15268b;
    private long c;
    private long d;
    private long e;
    private int f;
    private Map<String, a> g;
    private long h;
    private long i;
    private int j;
    private int k;

    public class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ i f15269a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f15270b;
        private int c;
        private String d;
        private long e;
        private long f;
        private int g;
        private int h;
        private int i;
        private long j;

        public a(i r1) {
            this.f15269a = r1;
        }

        static /* synthetic */ int a(a r0, int r1) {
            r0.g = r1;
            return r1;
        }

        static /* synthetic */ long a(a r2) {
            return r2.j;
        }

        static /* synthetic */ long a(a r0, long r1) {
            r0.j = r1;
            return r1;
        }

        static /* synthetic */ String a(a r0, String r1) {
            r0.d = r1;
            return r1;
        }

        static /* synthetic */ boolean a(a r0, boolean r1) {
            r0.f15270b = r1;
            return r1;
        }

        static /* synthetic */ int b(a r1) {
            int r0 = r1.i + 1;
            r1.i = r0;
            return r0;
        }

        static /* synthetic */ int b(a r0, int r1) {
            r0.h = r1;
            return r1;
        }

        static /* synthetic */ long b(a r0, long r1) {
            r0.f = r1;
            return r1;
        }

        static /* synthetic */ int c(a r0) {
            return r0.g;
        }

        static /* synthetic */ int c(a r0, int r1) {
            r0.c = r1;
            return r1;
        }

        static /* synthetic */ long c(a r0, long r1) {
            r0.e = r1;
            return r1;
        }

        static /* synthetic */ int d(a r1) {
            int r0 = r1.i - 1;
            r1.i = r0;
            return r0;
        }

        static /* synthetic */ long e(a r2) {
            return r2.f;
        }

        static /* synthetic */ int f(a r0) {
            return r0.i;
        }

        static /* synthetic */ long g(a r2) {
            return r2.e;
        }

        static /* synthetic */ boolean h(a r0) {
            return r0.f15270b;
        }

        static /* synthetic */ int i(a r0) {
            return r0.c;
        }

        static /* synthetic */ int j(a r0) {
            return r0.h;
        }

        static /* synthetic */ String k(a r0) {
            return r0.d;
        }
    }

    public i(DownloadInfo r2, int r3) {
        this.g = new LinkedHashMap();
        this.j = 0;
        this.k = 0;
        this.f15267a = r2;
        r2.setPcdnStats(null);
        this.f = r3;
    }

    private void a(long r6, String r8, com.ss.android.socialbase.downloader.network.h r9, Throwable r10, boolean r11, long r12) {
        com.ss.android.socialbase.downloader.network.h r13 = (com.ss.android.socialbase.downloader.network.h) ZeusTransformUtils.wrapperContextForParams(r9, com.ss.android.socialbase.downloader.network.h.class, "com.obric.memorydata.plugin");
        a r0 = (a) ZeusTransformUtils.preCheckCast(this.g.get(r8), a.class, "com.obric.memorydata.plugin");
        if (a.c(r0) != 0) goto L16;
        if (r13 == null) goto L16;
        if (ZeusTransformUtils.instanceOf(r13, com.ss.android.socialbase.downloader.network.a.class) == false) goto L16;
        com.ss.android.socialbase.downloader.network.a r2 = (com.ss.android.socialbase.downloader.network.a) ZeusTransformUtils.preCheckCast(r13, com.ss.android.socialbase.downloader.network.a.class, "com.obric.memorydata.plugin");
        if (r2.f() == true) goto L15;
        a.a(r0, 4);
        String r3 = r2.h();
        if (TextUtils.isEmpty(r3) == true) goto L16;
        JSONObject r4 = new JSONObject(r3);     // Catch: Throwable -> L13
        a.a(r0, r4.optJSONObject(ChatMessage.TYPE_RESPONSE).optInt("connection_info"));     // Catch: Throwable -> L13
        a.b(r0, r4.optJSONObject("timing").optJSONObject("detailed_duration").optInt("ttfb"));     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        th.printStackTrace();
        goto L16
    L15:
        a.a(r0, 1);
    L16:
        if (r10 == null) goto L23;
        if (r11 == true) goto L23;
        if (ZeusTransformUtils.instanceOf(r10, BaseException.class) == false) goto L21;
        int r14 = ((BaseException) ZeusTransformUtils.preCheckCast(r10, BaseException.class, "com.obric.memorydata.plugin")).getErrorCode();
    L22:
        a.c(r0, r14);
        a.a(r0, r10.toString());
    L28:
        a.d(r0);
        a.b(r0, a.e(r0) + (r6 - a.a(r0)));
        if (a.f(r0) != 0) goto L31;
        r6 = 0;
    L31:
        a.a(r0, r6);
        a.c(r0, a.g(r0) + r12);
        this.g.put(r8, r0);
        return;
    L21:
        r14 = 1000;
    L23:
        if (r13 == null) goto L28;
        a.c(r0, r13.b());     // Catch: Throwable -> L26
        a.a(r0, "");     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        th.printStackTrace();
        goto L28
    }

    private void a(long r5, boolean r7, long r8) {
        if (r7 == false) goto L8;
        int r9 = this.k - 1;
        this.k = r9;
        this.f15268b += r8;
        this.d += r5 - this.h;
        if (r9 != 0) goto L7;
        this.h = 0;
        return;
    L7:
        this.h = r5;
        return;
    L8:
        int r10 = this.j - 1;
        this.j = r10;
        this.c += r8;
        this.e += r5 - this.i;
        if (r10 != 0) goto L11;
        this.i = 0;
        return;
    L11:
        this.i = r5;
    }

    private void a(boolean r5) {
        if (r5 == false) goto L9;
        if (this.h > 0) goto L7;
        this.h = System.currentTimeMillis();
    L7:
        this.k++;
        return;
    L9:
        if (this.i > 0) goto L11;
        this.i = System.currentTimeMillis();
    L11:
        this.j++;
    }

    private void b(String r6, boolean r7) {
        a r0 = (a) ZeusTransformUtils.preCheckCast(this.g.get(r6), a.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L6;
        r0 = new a(this);
        a.a(r0, r7);
    L6:
        if (a.a(r0) > 0) goto L8;
        a.a(r0, System.currentTimeMillis());
    L8:
        a.b(r0);
        this.g.put(r6, r0);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public void a() {
        monitor-enter(this);
        JSONObject r0 = new JSONObject();     // Catch: Throwable -> L9
        r0.put("bus_id", this.f15267a.getMonitorScene());     // Catch: Throwable -> L9
        r0.put("pcdn_size", this.f15268b);     // Catch: Throwable -> L9
        r0.put("pcdn_dur", this.d);     // Catch: Throwable -> L9
        r0.put("cdn_size", this.c);     // Catch: Throwable -> L9
        r0.put("cdn_dur", this.e);     // Catch: Throwable -> L9
        r0.put("retry_times_max", this.f);     // Catch: Throwable -> L9
        JSONArray r1 = new JSONArray();     // Catch: Throwable -> L9
        Iterator<Map.Entry<String, a>> r2 = this.g.entrySet().iterator();     // Catch: Throwable -> L9
    L5:
        if (r2.hasNext() == false) goto L7;
        Map.Entry r3 = (Map.Entry) ZeusTransformUtils.preCheckCast(r2.next(), Map.Entry.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L9
        JSONObject r4 = new JSONObject();     // Catch: Throwable -> L9
        r4.put("url", r3.getKey());     // Catch: Throwable -> L9
        a r5 = (a) ZeusTransformUtils.preCheckCast(r3.getValue(), a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L9
        r4.put("is_pcdn", a.h(r5));     // Catch: Throwable -> L9
        r4.put("code", a.i(r5));     // Catch: Throwable -> L9
        r4.put("size", a.g(r5));     // Catch: Throwable -> L9
        r4.put("duration", a.e(r5));     // Catch: Throwable -> L9
        r4.put("protocol", a.c(r5));     // Catch: Throwable -> L9
        r4.put("ttfb", a.j(r5));     // Catch: Throwable -> L9
        r4.put(NotificationCompat.CATEGORY_ERROR, a.k(r5));     // Catch: Throwable -> L9
        r1.put(r4);     // Catch: Throwable -> L9
        goto L5
    L7:
        r0.put("urls", r1);     // Catch: Throwable -> L9
        this.f15267a.setPcdnStats(r0);     // Catch: Throwable -> L9
    L11:
        monitor-exit(this);     // Catch: Throwable -> L13
        return;
    L9:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;
    }

    public void a(String r15, long r16, boolean r18, boolean r19, com.ss.android.socialbase.downloader.network.h r20, com.ss.android.socialbase.downloader.b.d r21, Throwable r22) {
        com.ss.android.socialbase.downloader.network.h r5 = (com.ss.android.socialbase.downloader.network.h) ZeusTransformUtils.wrapperContextForParams(r20, com.ss.android.socialbase.downloader.network.h.class, "com.obric.memorydata.plugin");
        monitor-enter(this);
        long r0 = 0;
        if (r21 != null) goto L13;
    L7:
        long r10 = r0;
        long r12 = System.currentTimeMillis();     // Catch: Throwable -> L10
        a(r12, r15, r5, r22, r19, r10);     // Catch: Throwable -> L10
        a(r12, r18, r10);     // Catch: Throwable -> L10
        monitor-exit(this);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    L13:
        r0 = r21.d() - r16;     // Catch: Throwable -> L10
        goto L7
    }

    public void a(String r1, boolean r2) {
        monitor-enter(this);
        b(r1, r2);     // Catch: Throwable -> L6
        a(r2);     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    }
}
