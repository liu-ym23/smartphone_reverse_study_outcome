package b64;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import com.bytedance.awemeopen.infra.base.env.AoEnv;
import com.bytedance.awemeopen.infra.base.log.AoLogger;
import com.bytedance.awemeopen.infra.base.net.AoFromSource;
import com.bytedance.awemeopen.infra.base.net.AoNet;
import com.bytedance.awemeopen.infra.base.net.AoNetCode;
import com.bytedance.awemeopen.infra.base.net.AoNetRequest;
import com.bytedance.awemeopen.infra.base.net.AoNetResponse;
import com.bytedance.awemeopen.infra.base.net.AoNetworkEventHelper;
import com.bytedance.awemeopen.infra.base.net.AoRequestHelper;
import com.bytedance.awemeopen.infra.base.net.IAoNetCall;
import com.bytedance.awemeopen.infra.util.NetworkUtils;
import com.bytedance.awemeopen.infra.util.o;
import com.bytedance.awemeopen.servicesapi.event.AoEventService;
import com.bytedance.awemeopen.servicesapi.network.AoNetworkMetric;
import com.bytedance.awemeopen.servicesapi.network.AoNetworkService;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import q64.c;
import q64.e;
import q64.f;
import q64.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a implements IAoNetCall {
    public final AoNetRequest a;
    public volatile boolean b;
    public volatile boolean c;
    public final AoNetworkMetric d;
    public AoNetResponse e;
    public final g f;
    public volatile boolean g;

    /* JADX INFO: renamed from: b64.a$a, reason: collision with other inner class name */
    public final class C0005a extends e {
        public final e i;
        public final /* synthetic */ a j;

        @Override // q64.e
        public final byte[] a() {
            byte[] r0 = this.i.a();     // Catch: Throwable -> L5
            this.j.b();
            return r0;
        L5:
            th = move-exception;
            this.j.b();
            throw th;
        }

        @Override // q64.e
        public final long b() {
            return this.i.b();
        }

        @Override // q64.e
        public final String c() {
            return this.i.c();
        }

        @Override // q64.e, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
            this.i.close();     // Catch: Throwable -> L5
            this.j.b();
            return;
        L5:
            th = move-exception;
            this.j.b();
            throw th;
        }

        @Override // q64.e
        public final boolean d() {
            return this.i.d();
        }

        @Override // q64.e
        public final String f() {
            String r0 = this.i.f();     // Catch: Throwable -> L5
            this.j.b();
            return r0;
        L5:
            th = move-exception;
            this.j.b();
            throw th;
        }

        @Override // q64.e
        public final boolean isClosed() {
            return this.i.isClosed();
        }

        @Override // q64.e, java.io.InputStream
        public final int read() {
            int r0 = this.i.read();     // Catch: Throwable -> L5
            this.j.b();
            return r0;
        L5:
            th = move-exception;
            this.j.b();
            throw th;
        }

        @Override // q64.e
        public final boolean e() {
            boolean r0 = super.e();     // Catch: Throwable -> L5
            this.j.b();
            return r0;
        L5:
            th = move-exception;
            this.j.b();
            throw th;
        }

        public C0005a(a r3, e r4) {
            Intrinsics.checkNotNullParameter(r4, "res");
            this.j = r3;
            super(r4.c(), r4.b(), r4);
            this.i = r4;
        }
    }

    public static final class b {
    }

    static {
    }

    @Override // com.bytedance.awemeopen.infra.base.net.IAoNetCall
    public final void cancel() {
        AoLogger.g("BdpHostCallWrapper", new Object[]{"cancel"});
        this.c = true;
        this.f.cancel();
    }

    public final void b() {
        AoNetResponse r0 = this.e;
        if (r0 != null) goto L5;
    L11:
        boolean r1 = false;
    L12:
        if (r1 == true) goto L15;
        return;
    L15:
        if (this.g == true) goto L22;
        this.g = true;
        this.d.update(this.f.a());
        if (this.a.getReportMonitor() == true) goto L19;
        return;
    L19:
        if (this.a.getFrom() == AoFromSource.event) goto L24;
        AoNetworkEventHelper r2 = AoNetworkEventHelper.INSTANCE;
        AoNetRequest r3 = this.a;
        AoNetResponse r4 = this.e;
        Intrinsics.checkNotNull(r4);
        r2.mpNetMonitor(r3, r4, this.c);
        return;
    L24:
        return;
    L22:
        return;
    L5:
        if (r0.getBody() != null) goto L7;
    L10:
        r1 = true;
        goto L12
    L7:
        if (r0.getBody().isClosed() == true) goto L10;
        if (r0.getBody().d() == false) goto L11;
        goto L10
    }

    @Override // com.bytedance.awemeopen.infra.base.net.IAoNetCall
    public final AoNetResponse execute() {
        if (this.b == true) goto L5;
        this.b = true;
        q64.b r1 = this.f.execute();
        e r2 = r1.e;
        if (r2 == null) goto L9;
        C0005a r3 = new C0005a(this, r2);
    L10:
        C0005a r9 = r3;
        Throwable r4 = r1.f;
        if (r4 == null) goto L13;
        AoRequestHelper r5 = AoRequestHelper.INSTANCE;
        Intrinsics.checkNotNull(r4);
        int r6 = r5.buildNativeErrorCode(r4);
    L14:
        AoNetResponse r7 = new AoNetResponse(r6, r1.b, r1.c, r1.d, r9, r1.f, this.a.getRequestLibType(), this.d, this.a.getExtraInfo());
        this.e = r7;
        if (r7.isSuccessful() == false) goto L17;
        AoLogger.g("BdpHostCallWrapper", new Object[]{"request", this.a, "response", r7});
    L18:
        b();
        return r7;
    L17:
        AoLogger.c("BdpHostCallWrapper", new Object[]{"request", this.a, "response", r7, Log.getStackTraceString(r7.getThrowable())});
        goto L18
    L13:
        r6 = r1.a;
        goto L14
    L9:
        r3 = null;
        goto L10
    L5:
        return AoRequestHelper.INSTANCE.buildNativeErrorResponse(this.a.getUrl(), AoNetCode.NATIVE_REQUEST_EXECUTED, "call has requested", this.a.getRequestLibType());
    }

    @Override // com.bytedance.awemeopen.infra.base.net.IAoNetCall
    public final AoNetRequest getRequest() {
        return this.a;
    }

    public static boolean a(String r4) {
        if (StringsKt.startsWith$default(r4, "https://content-open.douyin.com/aweme", false, 2, null) == false) goto L5;
    L10:
        return true;
    L5:
        if (StringsKt.startsWith$default(r4, "http://open-boe.douyin.com/", false, 2, null) == true) goto L10;
        if (StringsKt.startsWith$default(r4, "https://content-open.douyin.com/", false, 2, null) == true) goto L10;
        if (StringsKt.startsWith$default(r4, "https://aweme.snssdk.com/", false, 2, null) == true) goto L10;
        return false;
    }

    public a(Context r18, AoNetRequest r19) {
        Intrinsics.checkNotNullParameter(r18, "mContext");
        Intrinsics.checkNotNullParameter(r19, "mBdpRequest");
        this.a = r19;
        this.d = new AoNetworkMetric();
        c.a r2 = new c.a(r19.getHeaders());
        if (r19.getAddHostCommonParams() == true) goto L6;
        r2.b("X-SS-No-Cookie", "true");
    L6:
        if (r19.getAddHostSecurityParams() == true) goto L8;
        r2.b("X-METASEC-MODE", "1");
    L8:
        String r1 = r19.getUrl();
        Intrinsics.checkNotNullParameter(r1, "url");
        Intrinsics.checkNotNullParameter(r2, "bdpNetHeaders");
        int r8 = 0;
        if (a(r1) == false) goto L39;
        Intrinsics.checkNotNullParameter("access-token", "key");
        List<c.C0256c> r3 = r2.a;
        ArrayList r10 = new ArrayList();
        Iterator r4 = ((ArrayList) r3).iterator();
    L13:
        if (r4.hasNext() == false) goto L17;
        Object r11 = r4.next();
        if (StringsKt.equals(((c.C0256c) r11).a, "access-token", true) == false) goto L13;
        r10.add(r11);
        goto L13
    L17:
        ArrayList r5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r10, 10));
        Iterator r12 = r10.iterator();
    L19:
        if (r12.hasNext() == false) goto L21;
        r5.add(((c.C0256c) r12.next()).b);
        goto L19
    L21:
        String r13 = (String) AoNet.a.invoke();
        if (r13 != null) goto L24;
        r13 = "";
    L24:
        String r14 = (String) AoNet.b.invoke();
        if (r14 != null) goto L28;
        r14 = "";
    L28:
        if (r5.isEmpty() == true) goto L30;
        String r6 = (String) ListProtector.get(r5, 0);
        r2.a(MapsKt.mapOf(TuplesKt.to("bd-ticket-guard-target", r6)));
        if (Intrinsics.areEqual(r6, r13) == false) goto L39;
        r2.a(MapsKt.mapOf(TuplesKt.to("ao-open-id", r14)));
        goto L39
    L30:
        if (r13.length() != 0) goto L32;
        boolean r7 = true;
    L33:
        if (r7 == true) goto L39;
        r2.a(MapsKt.mapOf(TuplesKt.to("access-token", r13)));
        r2.a(MapsKt.mapOf(TuplesKt.to("bd-ticket-guard-target", r13)));
        r2.a(MapsKt.mapOf(TuplesKt.to("ao-open-id", r14)));
        goto L39
    L32:
        r7 = false;
    L39:
        String r9 = this.a.getUrl();
        Intrinsics.checkNotNullParameter(r9, "url");
        Intrinsics.checkNotNullParameter(r2, "bdpNetHeaders");
        f r15 = AoEnv.a().g0();
        if (r15 == null) goto L51;
        String r16 = r15.a(r9);
        String r17 = r15.a;
        if (r16 != null) goto L45;
    L48:
        boolean r110 = true;
    L49:
        if (r110 == true) goto L51;
        r2.a(MapsKt.mapOf(new Pair[]{TuplesKt.to("x-tt-env", r16), TuplesKt.to(r17, "1")}));
        goto L51
    L45:
        if (r16.length() == 0) goto L48;
        r110 = false;
    L51:
        String r20 = this.a.getUrl();
        Intrinsics.checkNotNullParameter(r20, "url");
        Intrinsics.checkNotNullParameter(r2, "bdpNetHeaders");
        if (a(r20) == true) goto L55;
    L97:
        String r21 = this.a.getUrl();
        boolean r22 = this.a.getAddCommonParams();
        Intrinsics.checkNotNullParameter(r21, "url");
        if (a(r21) == true) goto L100;
        if (r22 == true) goto L100;
    L101:
        String r23 = r21;
        this.a.getRequestBody();
        if (AoEnv.j() == false) goto L104;
        Function0<String> r24 = AoNet.a;
    L104:
        q64.a r25 = new q64.a(r23, this.a.getMethod(), this.a.getResponseStreaming(), this.a.getAddHostCommonParams(), this.a.getAddHostMd5Stub(), new c(r2.a), this.a.getRequestBody(), this.a.getConnectTimeOut(), this.a.getReadTimeOut(), this.a.getWriteTimeOut());
        int r26 = j64.b.a;
        this.f = j64.b.a(AoNetworkService.class).s2(r25);
        return;
    L100:
        AoEventService r27 = j64.a.a(AoEventService.class);
        Intrinsics.checkNotNull(r27);
        r21 = r27.k(r21);
        goto L101
    L55:
        if (StringsKt.startsWith$default(r20, "https://aweme.snssdk.com/", false, 2, null) == false) goto L63;
        HashMap<String, Function0<String>> r28 = a64.a.a;
        Intrinsics.checkNotNullParameter(r2, "bdpNetHeaders");
        LinkedHashMap r29 = new LinkedHashMap();
        r29.put("X-Query-App-Id", AoEnv.d());
        r29.put("X-Query-Device-Id", AoEnv.c());
        r29.put("use-content-sdk", "1");
        HashMap<String, Function0<String>> r30 = a64.a.a;
        if ((!r30.isEmpty()) == false) goto L62;
        Iterator<Map.Entry<String, Function0<String>>> r31 = r30.entrySet().iterator();
    L60:
        if (r31.hasNext() == false) goto L62;
        Map.Entry<String, Function0<String>> r32 = r31.next();
        r29.put(r32.getKey(), r32.getValue().invoke());
    L62:
        r2.a(r29);
        goto L97
    L63:
        HashMap<String, Function0<String>> r33 = a64.a.a;
        Intrinsics.checkNotNullParameter(r2, "bdpNetHeaders");
        LinkedHashMap r34 = new LinkedHashMap();
        Application r35 = y54.a.a();
        Intrinsics.checkNotNullParameter(r35, "context");
        Intrinsics.checkNotNullParameter(r34, "params");
        r34.put("ao-app-id", AoEnv.d());
        r34.put("ao-device-id", AoEnv.c());
        r34.put("ao-bd-device-id", (String) AoEnv.b.invoke());
        int r36 = NetworkUtils.a;
        Intrinsics.checkNotNullParameter(r35, "context");
        NetworkUtils.NetworkType r37 = NetworkUtils.a(r35);
        Intrinsics.checkNotNullParameter(r37, "nt");
        if (r37 != NetworkUtils.NetworkType.WIFI) goto L67;
        String r38 = "wifi";
    L82:
        r34.put("ao-ac", r38);
        r34.put("ao-host-version", AoEnv.f());
        r34.put("ao-sdk-version", AoEnv.g());
        r34.put("ao-sdk-version-code", String.valueOf(37300));
        r34.put("ao-device-type", Build.MODEL);
        r34.put("ao-app-name", AoEnv.a().getHostAppName());
        r34.put("ao-channel", AoEnv.b());
        r34.put("ao-os-version", Build.VERSION.RELEASE);
        r34.put("ao-device-platform", "android");
        if (TextUtils.isEmpty(o.a) == false) goto L90;
        int r39 = o.a(r35);
        Resources r40 = r35.getResources();
        DisplayMetrics r41 = WindowDisplayMetricsOverride.apply(r40, r40.getDisplayMetrics());
        if (r41 == null) goto L87;
        r8 = r41.heightPixels;
    L87:
        if (r39 <= 0) goto L90;
        if (r8 <= 0) goto L90;
        StringBuilder r42 = new StringBuilder();
        r42.append(r8);
        r42.append('*');
        r42.append(r39);
        o.a = r42.toString();
    L90:
        r34.put("ao-resolution", o.a);
        r34.put("ao-host-version-code", String.valueOf(AoEnv.e()));
        r34.put("ao-biz-name", AoEnv.c);
        r34.put("ao-biz-version", AoEnv.d);
        r34.put("ao-biz-version-code", String.valueOf(0));
        AoEnv.a().N();
        r34.put("odin-tt", "");
        HashMap<String, Function0<String>> r43 = a64.a.a;
        if ((!r43.isEmpty()) == false) goto L96;
        Iterator<Map.Entry<String, Function0<String>>> r44 = r43.entrySet().iterator();
    L94:
        if (r44.hasNext() == false) goto L96;
        Map.Entry<String, Function0<String>> r45 = r44.next();
        r34.put(r45.getKey(), r45.getValue().invoke());
    L96:
        r2.a(r34);
        goto L97
    L67:
        if (r37 != NetworkUtils.NetworkType.MOBILE_2G) goto L70;
        r38 = "2g";
        goto L82
    L70:
        if (r37 != NetworkUtils.NetworkType.MOBILE_3G) goto L73;
        r38 = "3g";
        goto L82
    L73:
        if (r37 != NetworkUtils.NetworkType.MOBILE_4G) goto L76;
        r38 = "4g";
        goto L82
    L76:
        if (r37 != NetworkUtils.NetworkType.MOBILE_5G) goto L79;
        r38 = "5g";
        goto L82
    L79:
        if (r37 != NetworkUtils.NetworkType.MOBILE) goto L81;
        r38 = "mobile";
        goto L82
    L81:
        r38 = "";
        goto L82
    }
}
