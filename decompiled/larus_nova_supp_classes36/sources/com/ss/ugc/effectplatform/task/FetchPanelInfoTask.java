package com.ss.ugc.effectplatform.task;

import bytekn.foundation.logger.Logger;
import com.ss.android.lark.location_ui.statistics.LocationHitPoint$ResultType;
import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import com.ss.ugc.effectplatform.EffectConfig;
import com.ss.ugc.effectplatform.bridge.network.ByteReadStream;
import com.ss.ugc.effectplatform.bridge.network.HTTPMethod;
import com.ss.ugc.effectplatform.bridge.network.INetworkClient;
import com.ss.ugc.effectplatform.bridge.network.NetRequest;
import com.ss.ugc.effectplatform.model.ExceptionResult;
import com.ss.ugc.effectplatform.model.PanelInfoModel;
import com.ss.ugc.effectplatform.model.net.PanelInfoResponse;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class FetchPanelInfoTask extends BaseNetworkTask<PanelInfoModel, PanelInfoResponse> {
    public final a0.b<Long> n;
    public final EffectConfig o;
    public final String p;
    public final boolean q;
    public final String r;
    public final int s;
    public final int t;
    public final boolean u;
    public final Map<String, String> v;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\u0010"}, d2 = {"Lcom/ss/ugc/effectplatform/task/FetchPanelInfoTask$Version;", "", "version", "", "(Ljava/lang/String;)V", "getVersion", "()Ljava/lang/String;", "setVersion", "component1", "copy", "equals", "", INotificationHitPoint.NoticeType.OTHER, "hashCode", "", "toString", "effectplatform_release"}, k = 1, mv = {1, 1, 16})
    public static final class Version {
        private String version;

        public Version() {
            String r0 = null;
            this(r0, 1, r0);
        }

        public static /* synthetic */ Version copy$default(Version r0, String r1, int r2, Object r3) {
            if ((r2 & 1) == 0) goto L6;
            r1 = r0.version;
        L6:
            return r0.copy(r1);
        }

        public final String component1() {
            return this.version;
        }

        public final Version copy(String r2) {
            return new Version(r2);
        }

        public boolean equals(Object r2) {
            if (this != r2) goto L4;
            return true;
        L4:
            if ((r2 instanceof Version) == true) goto L6;
            return false;
        L6:
            if (Intrinsics.areEqual(this.version, ((Version) r2).version) == true) goto L13;
            return false;
        L13:
            return true;
        }

        public int hashCode() {
            String r0 = this.version;
            if (r0 != null) goto L7;
            return 0;
        L7:
            return r0.hashCode();
        }

        public String toString() {
            return "Version(version=" + this.version + ")";
        }

        public final String getVersion() {
            return this.version;
        }

        public Version(String r1) {
            this.version = r1;
        }

        public final void setVersion(String r1) {
            this.version = r1;
        }

        public /* synthetic */ Version(String r1, int r2, DefaultConstructorMarker r3) {
            if ((r2 & 1) == 0) goto L5;
            r1 = "0";
        L5:
            this(r1);
        }
    }

    public static final class a {
    }

    static {
    }

    public final int h() {
        return 10002;
    }

    public final NetRequest f() {
        int r0 = com.ss.ugc.effectplatform.util.g.a;
        HashMap r1 = com.ss.ugc.effectplatform.util.g.b(this.o, 6);
        r1.put("panel", this.p);
        if (this.q == false) goto L9;
        r1.put("has_category_effects", String.valueOf(true));
        String r2 = this.r;
        if (r2 != null) goto L8;
        r2 = LocationHitPoint$ResultType.DEFAULT;
    L8:
        r1.put("category", r2);
        r1.put("cursor", String.valueOf(this.t));
        r1.put("count", String.valueOf(this.s));
    L9:
        String r3 = this.o.C;
        if (r3 == null) goto L12;
        r1.put("test_status", r3);
    L12:
        r1.put("has_children_category", String.valueOf(this.u));
        Map<String, String> r4 = this.v;
        if (r4 == null) goto L15;
        r1.putAll(r4);
    L15:
        HTTPMethod r5 = HTTPMethod.GET;
        int r6 = com.ss.ugc.effectplatform.util.m.a;
        StringBuilder r7 = new StringBuilder();
        r7.append(this.o.E);
        this.o.getClass();
        r7.append("/effect/api");
        if (this.o.s != 2) goto L18;
        String r8 = "/panel/info/v2";
    L19:
        r7.append(r8);
        return new NetRequest(com.ss.ugc.effectplatform.util.m.a(r1, r7.toString()), null, r5, null, null, null, false, null, 250, null);
    L18:
        r8 = "/panel/info";
        goto L19
    }

    public final int i() {
        return this.o.q;
    }

    public final com.ss.ugc.effectplatform.model.e o(dlc.a r2, ByteReadStream r3) {
        return (PanelInfoResponse) r2.a.convertJsonToObj(r3, PanelInfoResponse.class);
    }

    public final com.ss.ugc.effectplatform.model.e p(dlc.a r2, String r3) {
        return (PanelInfoResponse) r2.a.convertJsonToObj(r3, PanelInfoResponse.class);
    }

    public final void k(String r7, String r8, ExceptionResult r9) {
        Logger.e$default(Logger.INSTANCE, "FetchPanelInfoTask", "Failed: " + r9, null, 4, null);
        r9.setTrackParams(r7, this.o.E, r8);
        super.k(r7, r8, r9);
        EffectConfig r10 = this.o;
        klc.a r11 = (klc.a) r10.v.a;
        if (r11 == null) goto L6;
        klc.b.k(r11, false, r10, MapsKt.mapOf(new Pair[]{TuplesKt.to("log_id", ((BaseNetworkTask) this).g), TuplesKt.to("panel", this.p), TuplesKt.to("error_code", Integer.valueOf(r9.getErrorCode()))}), r9.getMsg());
        return;
    }

    public final void m(long r14, long r16, long r18, String r20, com.ss.ugc.effectplatform.model.e r21) {
        PanelInfoResponse r8 = (PanelInfoResponse) r21;
        PanelInfoModel r0 = r8.getData();
        if (r0 == null) goto L54;
        int r1 = y0.a;
        y0.a(this.o, this.p, r0);
        int r2 = com.ss.ugc.effectplatform.util.f.a;
        EffectConfig r3 = this.o;
        String r4 = com.ss.ugc.effectplatform.util.f.g(r3.e, this.p, this.q, this.r, this.t, this.s, r3.s);
        String r5 = null;
    L27:
        e = move-exception;
        Logger.e$default(Logger.INSTANCE, "NewFetchPanelInfoTask", "Exception: " + e, null, 4, null);
    L52:
        PanelInfoModel r6 = r8.getResponseData();     // Catch: Exception -> L41
        if (r6 == null) goto L32;
        String r7 = r6.getVersion();     // Catch: Exception -> L41
    L33:
        Version r9 = new Version(r7);     // Catch: Exception -> L41
        dlc.a r10 = this.o.t;     // Catch: Exception -> L41
        if (r10 == null) goto L36;
        r5 = r10.a.convertObjToJson(r9);     // Catch: Exception -> L41
    L36:
        if (r5 == null) goto L43;
        com.ss.ugc.effectplatform.cache.j r11 = (com.ss.ugc.effectplatform.cache.j) this.o.A.a;     // Catch: Exception -> L41
        if (r11 == null) goto L43;
        int r12 = com.ss.ugc.effectplatform.util.f.a;     // Catch: Exception -> L41
        r11.save(com.ss.ugc.effectplatform.util.f.j(this.p), r5);     // Catch: Exception -> L41
    L43:
        l(r14, r16, r18, r8);
        int r13 = b0.a.a;
        long r15 = System.currentTimeMillis();
        EffectConfig r17 = this.o;
        klc.a r19 = (klc.a) r17.v.a;
        if (r19 == null) goto L55;
        Pair[] r22 = new Pair[8];
        r22[0] = TuplesKt.to("log_id", ((BaseNetworkTask) this).g);
        r22[1] = TuplesKt.to("panel", this.p);
        String r23 = this.r;
        if (r23 != null) goto L49;
        r23 = "";
    L49:
        r22[2] = TuplesKt.to("category", r23);
        r22[3] = TuplesKt.to("duration", Long.valueOf(r15 - r14));
        r22[4] = TuplesKt.to("network_time", Long.valueOf(r16 - r14));
        r22[5] = TuplesKt.to("json_time", Long.valueOf(r18 - r16));
        r22[6] = TuplesKt.to("io_time", Long.valueOf(r15 - r18));
        r22[7] = TuplesKt.to("size", this.n.a);
        klc.b.k(r19, true, r17, MapsKt.mapOf(r22), "");
        return;
    L55:
        return;
    L32:
        r7 = null;
    L41:
        e = move-exception;
        Logger.e$default(Logger.INSTANCE, "FetchPanelInfoTask", "Json Exception: " + e, null, 4, null);
        goto L43
    L6:
        if (r20.length() <= 0) goto L8;
        boolean r24 = true;
    L9:
        long r25 = 0;
        if (r24 == false) goto L17;
        EffectConfig r26 = this.o;     // Catch: Exception -> L27
        if (r26.W != 2) goto L17;
        a0.b<Long> r27 = this.n;     // Catch: Exception -> L27
        com.ss.ugc.effectplatform.cache.j r28 = (com.ss.ugc.effectplatform.cache.j) r26.A.a;     // Catch: Exception -> L27
        if (r28 == null) goto L16;
        r25 = r28.save(r4, r20);     // Catch: Exception -> L27
    L16:
        int r29 = elc.a.a;     // Catch: Exception -> L27
        r27.a = Long.valueOf(r25 / ((long) 1024));     // Catch: Exception -> L27
    L17:
        dlc.a r30 = this.o.t;     // Catch: Exception -> L27
        if (r30 == null) goto L20;
        String r31 = r30.a.convertObjToJson(r8);     // Catch: Exception -> L27
    L21:
        if (r31 == null) goto L52;
        a0.b<Long> r32 = this.n;     // Catch: Exception -> L27
        com.ss.ugc.effectplatform.cache.j r33 = (com.ss.ugc.effectplatform.cache.j) this.o.A.a;     // Catch: Exception -> L27
        if (r33 == null) goto L25;
        r25 = r33.save(r4, r31);     // Catch: Exception -> L27
    L25:
        int r34 = elc.a.a;     // Catch: Exception -> L27
        r32.a = Long.valueOf(r25 / ((long) 1024));     // Catch: Exception -> L27
        goto L52
    L20:
        r31 = null;
        goto L21
    L8:
        r24 = false;
        goto L9
    }

    public FetchPanelInfoTask(EffectConfig r10, String r11, String r12, boolean r13, String r14, int r15, int r16, boolean r17, Map<String, String> r18) {
        super((INetworkClient) r10.u.a, r10.t, r10.N, r12, r10.P, r10);
        this.o = r10;
        this.p = r11;
        this.q = r13;
        this.r = r14;
        this.s = r15;
        this.t = r16;
        this.u = r17;
        this.v = r18;
        this.n = new a0.b(0L);
    }
}
