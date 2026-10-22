package com.ss.ugc.effectplatform.task;

import bytekn.foundation.logger.Logger;
import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import com.ss.ugc.effectplatform.EffectConfig;
import com.ss.ugc.effectplatform.bridge.network.ByteReadStream;
import com.ss.ugc.effectplatform.bridge.network.HTTPMethod;
import com.ss.ugc.effectplatform.bridge.network.INetworkClient;
import com.ss.ugc.effectplatform.bridge.network.NetRequest;
import com.ss.ugc.effectplatform.model.CategoryEffectModel;
import com.ss.ugc.effectplatform.model.CategoryPageModel;
import com.ss.ugc.effectplatform.model.Effect;
import com.ss.ugc.effectplatform.model.ExceptionResult;
import com.ss.ugc.effectplatform.model.net.CategoryEffectListResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class FetchCategoryEffectTask extends BaseNetworkTask<CategoryPageModel, CategoryEffectListResponse> {
    public final EffectConfig n;
    public final String o;
    public final String p;
    public final int q;
    public final int r;
    public final int s;
    public final String t;
    public final Map<String, String> u;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0083\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/ss/ugc/effectplatform/task/FetchCategoryEffectTask$CategoryVersion;", "", "version", "", "cursor", "", "sorting_position", "(Ljava/lang/String;II)V", "getCursor", "()I", "getSorting_position", "getVersion", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", INotificationHitPoint.NoticeType.OTHER, "hashCode", "toString", "effectplatform_release"}, k = 1, mv = {1, 1, 16})
    public static final class CategoryVersion {
        private final int cursor;
        private final int sorting_position;
        private final String version;

        public static /* synthetic */ CategoryVersion copy$default(CategoryVersion r0, String r1, int r2, int r3, int r4, Object r5) {
            if ((r4 & 1) == 0) goto L6;
            r1 = r0.version;
        L6:
            if ((r4 & 2) == 0) goto L9;
            r2 = r0.cursor;
        L9:
            if ((r4 & 4) == 0) goto L12;
            r3 = r0.sorting_position;
        L12:
            return r0.copy(r1, r2, r3);
        }

        public final String component1() {
            return this.version;
        }

        public final int component2() {
            return this.cursor;
        }

        public final int component3() {
            return this.sorting_position;
        }

        public final CategoryVersion copy(String r2, int r3, int r4) {
            return new CategoryVersion(r2, r3, r4);
        }

        public boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof CategoryVersion) == false) goto L12;
            CategoryVersion r4 = (CategoryVersion) r3;
            if (Intrinsics.areEqual(this.version, r4.version) == true) goto L8;
            return false;
        L8:
            if (this.cursor == r4.cursor) goto L10;
            return false;
        L10:
            if (this.sorting_position == r4.sorting_position) goto L19;
            return false;
        L19:
            return true;
        L12:
            return false;
        }

        public int hashCode() {
            String r0 = this.version;
            if (r0 == null) goto L5;
            int r1 = r0.hashCode();
        L7:
            return (((r1 * 31) + this.cursor) * 31) + this.sorting_position;
        L5:
            r1 = 0;
            goto L7
        }

        public String toString() {
            return "CategoryVersion(version=" + this.version + ", cursor=" + this.cursor + ", sorting_position=" + this.sorting_position + ")";
        }

        public final int getCursor() {
            return this.cursor;
        }

        public final int getSorting_position() {
            return this.sorting_position;
        }

        public final String getVersion() {
            return this.version;
        }

        public CategoryVersion(String r1, int r2, int r3) {
            this.version = r1;
            this.cursor = r2;
            this.sorting_position = r3;
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
        String r2 = this.p;
        if (r2 != null) goto L6;
        r2 = "hot";
    L6:
        r1.put("category", r2);
        r1.put("cursor", String.valueOf(this.r));
        r1.put("count", String.valueOf(this.q));
        r1.put("sorting_position", String.valueOf(this.s));
        String r3 = this.t;
        if (r3 != null) goto L10;
        r3 = "0";
    L10:
        r1.put("version", r3);
        String r4 = this.n.C;
        if (r4 == null) goto L13;
        r1.put("test_status", r4);
    L13:
        Map<String, String> r5 = this.u;
        if (r5 == null) goto L16;
        r1.putAll(r5);
    L16:
        HTTPMethod r6 = HTTPMethod.GET;
        int r7 = com.ss.ugc.effectplatform.util.m.a;
        StringBuilder r8 = new StringBuilder();
        r8.append(this.n.E);
        this.n.getClass();
        r8.append("/effect/api");
        if (this.n.s != 2) goto L19;
        String r9 = "/category/effects/v2";
    L20:
        r8.append(r9);
        return new NetRequest(com.ss.ugc.effectplatform.util.m.a(r1, r8.toString()), null, r6, null, null, null, false, null, 250, null);
    L19:
        r9 = "/category/effects";
        goto L20
    }

    public final int i() {
        return this.n.q;
    }

    public final com.ss.ugc.effectplatform.model.e o(dlc.a r2, ByteReadStream r3) {
        return (CategoryEffectListResponse) r2.a.convertJsonToObj(r3, CategoryEffectListResponse.class);
    }

    public final com.ss.ugc.effectplatform.model.e p(dlc.a r2, String r3) {
        return (CategoryEffectListResponse) r2.a.convertJsonToObj(r3, CategoryEffectListResponse.class);
    }

    public final void k(String r6, String r7, ExceptionResult r8) {
        r8.setTrackParams(r6, this.n.E, r7);
        super.k(r6, r7, r8);
        EffectConfig r9 = this.n;
        klc.a r10 = (klc.a) r9.v.a;
        if (r10 == null) goto L15;
        Pair[] r0 = new Pair[5];
        r0[0] = TuplesKt.to("log_id", ((BaseNetworkTask) this).g);
        r0[1] = TuplesKt.to("panel", this.o);
        String r1 = this.p;
        String r3 = "";
        if (r1 != null) goto L8;
        r1 = "";
    L8:
        r0[2] = TuplesKt.to("category", r1);
        r0[3] = TuplesKt.to("error_code", Integer.valueOf(r8.getErrorCode()));
        Map<String, String> r2 = this.u;
        if (r2 == null) goto L13;
        String r4 = r2.get("source");
        if (r4 == null) goto L13;
        r3 = r4;
    L13:
        r0[4] = TuplesKt.to("source", r3);
        klc.b.a(r10, false, r9, MapsKt.mapOf(r0), r8.getMsg());
        return;
    }

    public final void l(long r18, long r20, long r22, com.ss.ugc.effectplatform.model.e r24) {
        CategoryEffectListResponse r8 = (CategoryEffectListResponse) r24;
        CategoryPageModel r0 = r8.getData();
        if (r0 == null) goto L113;
        com.ss.ugc.effectplatform.util.h r1 = com.ss.ugc.effectplatform.util.h.a;
        String r2 = this.n.i;
        String r3 = this.o;
        CategoryEffectModel r4 = r0.getCategory_effects();
        String r5 = null;
        if (r4 == null) goto L7;
        List<Effect> r6 = r4.getCategory_effects();
    L8:
        r1.getClass();
        com.ss.ugc.effectplatform.util.h.d(r2, r3, r6);
        String r7 = this.n.i;
        String r9 = this.o;
        CategoryEffectModel r10 = r0.getCategory_effects();
        if (r10 == null) goto L11;
        List<Effect> r11 = r10.getCollection();
    L12:
        com.ss.ugc.effectplatform.util.h.d(r7, r9, r11);
        String r12 = this.n.i;
        String r13 = this.o;
        CategoryEffectModel r14 = r0.getCategory_effects();
        if (r14 == null) goto L15;
        List<Effect> r15 = r14.getBind_effects();
    L16:
        com.ss.ugc.effectplatform.util.h.d(r12, r13, r15);
        CategoryPageModel r16 = r8.getData();
        if (r16 == null) goto L36;
        CategoryPageModel.Extra r17 = r16.getExtra();
        if (r17 == null) goto L36;
        String r19 = r17.getRec_id();
        if (r19 == null) goto L36;
        CategoryEffectModel r21 = r0.getCategory_effects();
        if (r21 == null) goto L25;
        List<Effect> r23 = r21.getCategory_effects();
    L26:
        com.ss.ugc.effectplatform.util.h.f(r19, r23);
        CategoryEffectModel r25 = r0.getCategory_effects();
        if (r25 == null) goto L29;
        List<Effect> r26 = r25.getCollection();
    L30:
        com.ss.ugc.effectplatform.util.h.f(r19, r26);
        CategoryEffectModel r27 = r0.getCategory_effects();
        if (r27 == null) goto L33;
        List<Effect> r28 = r27.getBind_effects();
    L34:
        com.ss.ugc.effectplatform.util.h.f(r19, r28);
        goto L36
    L33:
        r28 = null;
        goto L34
    L29:
        r26 = null;
        goto L30
    L25:
        r23 = null;
    L36:
        if (this.n.s != 2) goto L50;
        List<String> r29 = r0.getUrl_prefix();
        CategoryEffectModel r30 = r0.getCategory_effects();
        if (r30 == null) goto L40;
        List<Effect> r31 = r30.getCategory_effects();
    L41:
        com.ss.ugc.effectplatform.util.h.h(r29, r31);
        List<String> r32 = r0.getUrl_prefix();
        CategoryEffectModel r33 = r0.getCategory_effects();
        if (r33 == null) goto L44;
        List<Effect> r34 = r33.getCollection();
    L45:
        com.ss.ugc.effectplatform.util.h.h(r32, r34);
        List<String> r35 = r0.getUrl_prefix();
        CategoryEffectModel r36 = r0.getCategory_effects();
        if (r36 == null) goto L48;
        List<Effect> r37 = r36.getBind_effects();
    L49:
        com.ss.ugc.effectplatform.util.h.h(r35, r37);
        goto L50
    L48:
        r37 = null;
        goto L49
    L44:
        r34 = null;
        goto L45
    L40:
        r31 = null;
    L50:
        int r38 = com.ss.ugc.effectplatform.util.f.a;
        String r39 = com.ss.ugc.effectplatform.util.f.a(this.o, this.p, this.q, this.r, this.s);
        long r40 = 0;
        dlc.a r41 = this.n.t;     // Catch: Exception -> L62
        if (r41 == null) goto L54;
        String r42 = r41.a.convertObjToJson(r8);     // Catch: Exception -> L62
    L55:
        if (r42 == null) goto L64;
        com.ss.ugc.effectplatform.cache.j r43 = (com.ss.ugc.effectplatform.cache.j) this.n.A.a;     // Catch: Exception -> L62
        if (r43 == null) goto L59;
        long r44 = r43.save(r39, r42);     // Catch: Exception -> L62
    L60:
        int r45 = elc.a.a;     // Catch: Exception -> L62
        r40 = r44 / ((long) 1024);     // Catch: Exception -> L62
        goto L64
    L59:
        r44 = 0;
    L64:
        long r110 = r40;
        CategoryPageModel r46 = r8.getData();     // Catch: Exception -> L93
        if (r46 == null) goto L72;
        CategoryEffectModel r47 = r46.getCategory_effects();     // Catch: Exception -> L93
        if (r47 == null) goto L72;
        String r48 = r47.getVersion();     // Catch: Exception -> L93
        if (r48 == null) goto L72;
    L73:
        CategoryPageModel r49 = r8.getData();     // Catch: Exception -> L93
        if (r49 == null) goto L78;
        CategoryEffectModel r50 = r49.getCategory_effects();     // Catch: Exception -> L93
        if (r50 == null) goto L78;
        int r51 = r50.getCursor();     // Catch: Exception -> L93
    L79:
        CategoryPageModel r52 = r8.getData();     // Catch: Exception -> L93
        if (r52 == null) goto L84;
        CategoryEffectModel r53 = r52.getCategory_effects();     // Catch: Exception -> L93
        if (r53 == null) goto L84;
        int r54 = r53.getSorting_position();     // Catch: Exception -> L93
    L85:
        CategoryVersion r55 = new CategoryVersion(r48, r51, r54);     // Catch: Exception -> L93
        dlc.a r56 = this.n.t;     // Catch: Exception -> L93
        if (r56 == null) goto L88;
        r5 = r56.a.convertObjToJson(r55);     // Catch: Exception -> L93
    L88:
        if (r5 == null) goto L95;
        com.ss.ugc.effectplatform.cache.j r57 = (com.ss.ugc.effectplatform.cache.j) this.n.A.a;     // Catch: Exception -> L93
        if (r57 == null) goto L95;
        int r58 = com.ss.ugc.effectplatform.util.f.a;     // Catch: Exception -> L93
        r57.save(com.ss.ugc.effectplatform.util.f.d(this.o, this.p), r5);     // Catch: Exception -> L93
    L95:
        super.l(r18, r20, r22, r8);
        int r59 = b0.a.a;
        long r60 = System.currentTimeMillis();
        EffectConfig r61 = this.n;
        klc.a r62 = (klc.a) r61.v.a;
        if (r62 == null) goto L114;
        Pair[] r63 = new Pair[9];
        r63[0] = TuplesKt.to("log_id", ((BaseNetworkTask) this).g);
        r63[1] = TuplesKt.to("panel", this.o);
        String r64 = this.p;
        if (r64 != null) goto L101;
        r64 = "";
    L101:
        r63[2] = TuplesKt.to("category", r64);
        r63[3] = TuplesKt.to("duration", Long.valueOf(r60 - r18));
        r63[4] = TuplesKt.to("network_time", Long.valueOf(r20 - r18));
        r63[5] = TuplesKt.to("json_time", Long.valueOf(r22 - r20));
        r63[6] = TuplesKt.to("io_time", Long.valueOf(r60 - r22));
        r63[7] = TuplesKt.to("size", Long.valueOf(r110));
        Map<String, String> r65 = this.u;
        if (r65 == null) goto L106;
        String r66 = r65.get("source");
        if (r66 == null) goto L106;
    L107:
        r63[8] = TuplesKt.to("source", r66);
        klc.b.a(r62, true, r61, MapsKt.mapOf(r63), "");
        return;
    L106:
        r66 = "";
        goto L107
    L114:
        return;
    L84:
        r54 = 0;
    L78:
        r51 = 0;
    L72:
        r48 = "0";
    L93:
        e = move-exception;
        Logger.e$default(Logger.INSTANCE, "FetchCategoryEffectTask", "Json Exception: " + e, null, 4, null);
        goto L95
    L54:
        r42 = null;
    L62:
        e = move-exception;
        Logger.e$default(Logger.INSTANCE, "FetchCategoryEffectTask", "Json Exception: " + e, null, 4, null);
        goto L64
    L15:
        r15 = null;
        goto L16
    L11:
        r11 = null;
        goto L12
    L7:
        r6 = null;
        goto L8
    }

    public FetchCategoryEffectTask(EffectConfig r10, String r11, String r12, String r13, int r14, int r15, int r16, String r17, Map<String, String> r18) {
        super((INetworkClient) r10.u.a, r10.t, r10.N, r12, r10.P, r10);
        this.n = r10;
        this.o = r11;
        this.p = r13;
        this.q = r14;
        this.r = r15;
        this.s = r16;
        this.t = r17;
        this.u = r18;
    }
}
