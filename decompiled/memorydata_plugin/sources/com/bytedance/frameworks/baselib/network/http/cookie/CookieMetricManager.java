package com.bytedance.frameworks.baselib.network.http.cookie;

import android.text.TextUtils;
import com.bytedance.keva.Keva;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.net.URI;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import okio.ByteString;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class CookieMetricManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Keva f2377a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AtomicBoolean f2378b;
    private volatile JSONObject c;

    /* JADX INFO: renamed from: com.bytedance.frameworks.baselib.network.http.cookie.CookieMetricManager$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f2379a = null;

        static {
            int[] r0 = new int[RmType.values().length];
            f2379a = r0;
            r0[RmType.All.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            f2379a[RmType.Session.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            f2379a[RmType.Expired.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    public static final enum RmType extends Enum<RmType> {
        private static final /* synthetic */ RmType[] $VALUES = null;
        public static final RmType All = null;
        public static final RmType Expired = null;
        public static final RmType Session = null;

        static {
            RmType r0 = new RmType("All", 0);
            All = r0;
            RmType r1 = new RmType("Session", 1);
            Session = r1;
            RmType r3 = new RmType("Expired", 2);
            Expired = r3;
            $VALUES = new RmType[]{r0, r1, r3};
        }

        private RmType(String r1, int r2) {
            super(r1, r2);
        }

        public static RmType valueOf(String r2) {
            return (RmType) ZeusTransformUtils.preCheckCast(Enum.valueOf(RmType.class, r2), RmType.class, "com.obric.memorydata.plugin");
        }

        public static RmType[] values() {
            return (RmType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), RmType[].class, "com.obric.memorydata.plugin");
        }
    }

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final CookieMetricManager f2380a = null;

        static {
            f2380a = new CookieMetricManager(null);
        }

        static /* synthetic */ CookieMetricManager a() {
            return f2380a;
        }
    }

    private CookieMetricManager() {
        this.f2378b = new AtomicBoolean(true);
        this.c = null;
        this.f2377a = Keva.getRepo("ttnetCookieDetailRepo", 1);
    }

    /* synthetic */ CookieMetricManager(AnonymousClass1 r1) {
        this();
    }

    public static CookieMetricManager a() {
        return a.a();
    }

    private String b(URI r10, e r11) {
        String r9 = null;
        if (r10 == null) goto L31;
        if (r11 == null) goto L32;
        String r0 = d.a(r10);
        String r12 = r10.getPath();
        if (TextUtils.isEmpty(r11.f()) == false) goto L29;
    L12:
        String r1 = r11.a();
        String r2 = r11.d();
        boolean r3 = r11.e();
        long r4 = r11.j();
        long r6 = r11.g();
        StringBuilder r13 = new StringBuilder().append("{\"r_host\":\"");
        if (r0 != null) goto L15;
        r0 = "-";
    L15:
        StringBuilder r14 = r13.append(r0).append("\",\"r_path\":\"");
        if (r12 != null) goto L18;
        r12 = "-";
    L18:
        StringBuilder r15 = r14.append(r12).append("\",\"v_md5\":\"");
        if (r9 != null) goto L21;
        r9 = "-";
    L21:
        StringBuilder r16 = r15.append(r9).append("\",\"domain\":\"");
        if (r1 != null) goto L24;
        r1 = "-";
    L24:
        StringBuilder r17 = r16.append(r1).append("\",\"path\":\"");
        if (r2 != null) goto L28;
        r2 = "-";
    L28:
        return r17.append(r2).append("\",\"sec\":").append(r3).append(",\"age\":").append(r4).append(",\"exp_t\":").append(r6).append("}").toString();
    L29:
        r9 = ByteString.encodeUtf8(r11.f()).md5().hex();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        String r5 = String.valueOf(r11.f().length());
        th.printStackTrace();
        r9 = r5;
        goto L12
    L32:
        return null;
    L31:
        return null;
    }

    private JSONObject c() {
        Map<String, ?> r2 = this.f2377a.getAll();     // Catch: Throwable -> L38
        if (r2 != null) goto L6;
        return null;
    L6:
        if (r2.isEmpty() == true) goto L61;
        JSONObject r3 = new JSONObject();     // Catch: Throwable -> L38
        Iterator<Map.Entry<String, ?>> r4 = r2.entrySet().iterator();     // Catch: Throwable -> L38
    L10:
        if (r4.hasNext() == false) goto L34;
        Map.Entry r5 = (Map.Entry) ZeusTransformUtils.preCheckCast(r4.next(), Map.Entry.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L38
        String r6 = (String) ZeusTransformUtils.preCheckCast(r5.getKey(), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L38
        if (TextUtils.isEmpty(r6) == true) goto L10;
        boolean r7 = r6.startsWith(";remove");     // Catch: Throwable -> L38
        if (r7 == false) goto L17;
    L43:
        String r8 = (String) ZeusTransformUtils.preCheckCast(r5.getValue(), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L22
    L25:
        if (TextUtils.isEmpty(r8) == true) goto L10;
        if (r7 == false) goto L30;
        r6 = r6.substring(1);     // Catch: Throwable -> L32
    L32:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L38
    L30:
        r3.put(r6, new JSONObject(r8));     // Catch: Throwable -> L32
    L22:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L38
        r8 = null;
        goto L25
    L17:
        if (com.bytedance.frameworks.baselib.network.a.b.b(r6) == true) goto L43;
        this.f2377a.erase(r6);     // Catch: Throwable -> L38
        goto L10
    L34:
        if (r3.length() > 0) goto L37;
        return null;
    L37:
        return r3;
    L61:
        return null;
    L38:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    void a(URI r2, e r3) {
        if (r2 == null) goto L18;
        if (r3 != null) goto L5;
        return;
    L5:
        if (com.bytedance.frameworks.baselib.network.a.b.d() == false) goto L7;
        return;
    L7:
        if (com.bytedance.frameworks.baselib.network.a.b.b(r3.c()) == false) goto L22;
        String r4 = b(r2, r3);
        if (TextUtils.isEmpty(r4) == true) goto L21;
        this.f2377a.storeString(r3.c(), r4);     // Catch: Throwable -> L13
        this.f2378b.set(true);     // Catch: Throwable -> L13
        return;
    L13:
        th = move-exception;
        th.printStackTrace();
        return;
    L21:
        return;
    L22:
        return;
    }

    public JSONObject b() {
        if (com.bytedance.frameworks.baselib.network.a.b.d() == false) goto L7;
        return null;
    L7:
        if (this.f2378b.compareAndSet(true, false) == false) goto L10;
        this.c = c();
    L10:
        return this.c;
    }
}
