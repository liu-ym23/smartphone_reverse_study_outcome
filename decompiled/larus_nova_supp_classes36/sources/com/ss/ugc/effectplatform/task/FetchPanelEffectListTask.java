package com.ss.ugc.effectplatform.task;

import bytekn.foundation.logger.Logger;
import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import com.ss.ugc.effectplatform.EffectConfig;
import com.ss.ugc.effectplatform.bridge.network.ByteReadStream;
import com.ss.ugc.effectplatform.bridge.network.HTTPMethod;
import com.ss.ugc.effectplatform.bridge.network.INetworkClient;
import com.ss.ugc.effectplatform.bridge.network.NetRequest;
import com.ss.ugc.effectplatform.model.EffectChannelModel;
import com.ss.ugc.effectplatform.model.EffectChannelResponse;
import com.ss.ugc.effectplatform.model.ExceptionResult;
import com.ss.ugc.effectplatform.model.net.EffectNetListResponse;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class FetchPanelEffectListTask extends BaseNetworkTask<EffectChannelModel, EffectNetListResponse> {
    public final EffectConfig n;
    public final String o;
    public final Map<String, String> p;
    public final String q;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\u0010"}, d2 = {"Lcom/ss/ugc/effectplatform/task/FetchPanelEffectListTask$Version;", "", "version", "", "(Ljava/lang/String;)V", "getVersion", "()Ljava/lang/String;", "setVersion", "component1", "copy", "equals", "", INotificationHitPoint.NoticeType.OTHER, "hashCode", "", "toString", "effectplatform_release"}, k = 1, mv = {1, 1, 16})
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
        HashMap r1 = com.ss.ugc.effectplatform.util.g.b(this.n, 6);
        r1.put("panel", this.o);
        Map<String, String> r2 = this.p;
        if (r2 == null) goto L5;
        r1.putAll(r2);
    L5:
        HTTPMethod r5 = HTTPMethod.GET;
        int r3 = com.ss.ugc.effectplatform.util.m.a;
        StringBuilder r4 = new StringBuilder();
        r4.append(this.n.E);
        this.n.getClass();
        r4.append("/effect/api/v3/effects");
        return new NetRequest(com.ss.ugc.effectplatform.util.m.a(r1, r4.toString()), null, r5, null, null, null, false, null, 250, null);
    }

    public final int i() {
        return this.n.q;
    }

    public final com.ss.ugc.effectplatform.model.e o(dlc.a r2, ByteReadStream r3) {
        return (EffectNetListResponse) r2.a.convertJsonToObj(r3, EffectNetListResponse.class);
    }

    public final com.ss.ugc.effectplatform.model.e p(dlc.a r2, String r3) {
        return (EffectNetListResponse) r2.a.convertJsonToObj(r3, EffectNetListResponse.class);
    }

    public final void k(String r5, String r6, ExceptionResult r7) {
        r7.setTrackParams(r5, this.n.E, r6);
        super.k(r5, r6, r7);
        EffectConfig r8 = this.n;
        klc.a r9 = (klc.a) r8.v.a;
        if (r9 == null) goto L6;
        klc.b.f(r9, false, r8, MapsKt.mapOf(new Pair[]{TuplesKt.to("log_id", ((BaseNetworkTask) this).g), TuplesKt.to("panel", this.o), TuplesKt.to("error_code", Integer.valueOf(r7.getErrorCode()))}), r7.getMsg());
        return;
    }

    public FetchPanelEffectListTask(EffectConfig r9, String r10, Map<String, String> r11, String r12) {
        super((INetworkClient) r9.u.a, r9.t, r9.N, r12, r9.P, r9);
        this.n = r9;
        this.o = r10;
        this.p = r11;
        this.q = r12;
    }

    public final void l(long r16, long r18, long r20, com.ss.ugc.effectplatform.model.e r22) {
        EffectChannelModel r2 = ((EffectNetListResponse) r22).getData();
        if (r2 == null) goto L36;
        final EffectChannelResponse r3 = new jlc.a(this.o, this.n.i, false).a(r2);
        int r0 = com.ss.ugc.effectplatform.util.f.a;
        String r1 = com.ss.ugc.effectplatform.util.f.k(this.n.e, this.o);
        long r6 = 0;
        String r8 = null;
        dlc.a r9 = this.n.t;     // Catch: Exception -> L16
        if (r9 == null) goto L8;
        String r10 = r9.a.convertObjToJson(r2);     // Catch: Exception -> L16
    L9:
        if (r10 == null) goto L32;
        com.ss.ugc.effectplatform.cache.j r11 = (com.ss.ugc.effectplatform.cache.j) this.n.A.a;     // Catch: Exception -> L16
        if (r11 == null) goto L13;
        long r12 = r11.save(r1, r10);     // Catch: Exception -> L16
    L14:
        int r4 = elc.a.a;     // Catch: Exception -> L16
        r6 = r12 / ((long) 1024);     // Catch: Exception -> L16
        goto L32
    L13:
        r12 = 0;
    L32:
        Version r5 = new Version(r2.getVersion());     // Catch: Exception -> L26
        dlc.a r7 = this.n.t;     // Catch: Exception -> L26
        if (r7 == null) goto L21;
        r8 = r7.a.convertObjToJson(r5);     // Catch: Exception -> L26
    L21:
        if (r8 == null) goto L28;
        com.ss.ugc.effectplatform.cache.j r13 = (com.ss.ugc.effectplatform.cache.j) this.n.A.a;     // Catch: Exception -> L26
        if (r13 == null) goto L28;
        r13.save("effect_version" + this.o, r8);     // Catch: Exception -> L26
    L28:
        e(new FetchPanelEffectListTask$onSuccess$1(this, r3));
        int r14 = b0.a.a;
        long r15 = System.currentTimeMillis();
        EffectConfig r17 = this.n;
        klc.a r19 = (klc.a) r17.v.a;
        if (r19 == null) goto L37;
        klc.b.f(r19, true, r17, MapsKt.mapOf(new Pair[]{TuplesKt.to("log_id", ((BaseNetworkTask) this).g), TuplesKt.to("panel", this.o), TuplesKt.to("duration", Long.valueOf(r15 - r16)), TuplesKt.to("network_time", Long.valueOf(r18 - r16)), TuplesKt.to("json_time", Long.valueOf(r20 - r18)), TuplesKt.to("io_time", Long.valueOf(r15 - r20)), TuplesKt.to("size", Long.valueOf(r6))}), "");
        return;
    L37:
        return;
    L26:
        e = move-exception;
        Logger.e$default(Logger.INSTANCE, "FetchPanelInfoTask", "Json Exception: " + e, null, 4, null);
        goto L28
    L8:
        r10 = null;
    L16:
        e = move-exception;
        Logger.e$default(Logger.INSTANCE, "FetchPanelEffectListTask", "Exception: " + e, null, 4, null);
        goto L32
    }
}
