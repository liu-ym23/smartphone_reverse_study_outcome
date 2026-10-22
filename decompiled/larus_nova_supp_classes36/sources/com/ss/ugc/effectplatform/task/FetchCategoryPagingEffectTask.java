package com.ss.ugc.effectplatform.task;

import bytekn.foundation.io.file.FileManager;
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
public final class FetchCategoryPagingEffectTask extends BaseNetworkTask<CategoryPageModel, CategoryEffectListResponse> {
    public final EffectConfig n;
    public final String o;
    public final String p;
    public final int q;
    public final int r;
    public final int s;
    public final String t;
    public final Map<String, String> u;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0083\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/ss/ugc/effectplatform/task/FetchCategoryPagingEffectTask$CategoryVersion;", "", "version", "", "cursor", "", "sorting_position", "(Ljava/lang/String;II)V", "getCursor", "()I", "getSorting_position", "getVersion", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", INotificationHitPoint.NoticeType.OTHER, "hashCode", "toString", "effectplatform_release"}, k = 1, mv = {1, 1, 16})
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
        r8.append("/effect/api/category/page/effects");
        return new NetRequest(com.ss.ugc.effectplatform.util.m.a(r1, r8.toString()), null, r6, null, null, null, false, null, 250, null);
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

    public final void k(String r22, String r23, ExceptionResult r24) {
        r24.setTrackParams(r22, this.n.E, r23);
        if (this.r != 0) goto L39;
        int r0 = b0.a.a;
        long r6 = System.currentTimeMillis();
        com.ss.ugc.effectplatform.cache.j r1 = (com.ss.ugc.effectplatform.cache.j) this.n.A.a;
        if (r1 == null) goto L7;
        int r3 = com.ss.ugc.effectplatform.util.f.a;
        bytekn.foundation.io.file.g r4 = r1.queryToStream(com.ss.ugc.effectplatform.util.f.c(this.o, this.p, this.q, this.r, this.s));
    L8:
        if (r4 != null) goto L50;
    L33:
        boolean r2 = false;
    L34:
        if (r2 == false) goto L39;
        boolean r5 = true;
    L40:
        if (r5 == true) goto L42;
        super.k(r22, r23, r24);
    L42:
        EffectConfig r7 = this.n;
        klc.a r8 = (klc.a) r7.v.a;
        if (r8 == null) goto L54;
        Pair[] r9 = new Pair[4];
        r9[0] = TuplesKt.to("log_id", ((BaseNetworkTask) this).g);
        r9[1] = TuplesKt.to("panel", this.o);
        String r10 = this.p;
        if (r10 != null) goto L48;
        r10 = "";
    L48:
        r9[2] = TuplesKt.to("category", r10);
        r9[3] = TuplesKt.to("error_code", Integer.valueOf(r24.getErrorCode()));
        klc.b.b(r8, false, "category_paged", r7, MapsKt.mapOf(r9), r24.getMsg());
        return;
    L54:
        return;
    L50:
        String r11 = FileManager.a;     // Catch: Throwable -> L15
        String r12 = FileManager.h(r4);     // Catch: Throwable -> L15
        dlc.a r13 = this.n.t;     // Catch: Throwable -> L15
        if (r13 == null) goto L14;
        CategoryEffectListResponse r14 = (CategoryEffectListResponse) r13.a.convertJsonToObj(r12, CategoryEffectListResponse.class);     // Catch: Throwable -> L15
    L18:
        FileManager.b(r4);
        if (r14 == null) goto L33;
        if (r14.checkValue() == false) goto L33;
        if (this.n.P == true) goto L25;
    L27:
        CategoryPageModel r15 = r14.getData();
        if (r15 == null) goto L32;
        CategoryEffectModel r16 = r15.getCategory_effects();
        if (r16 == null) goto L32;
        r16.setCache(true);
    L32:
        super.l(r6, r6, r6, r14);
        r2 = true;
        goto L34
    L25:
        if (r14.verifySign() == true) goto L27;
    L14:
        r14 = null;
    L15:
        th = move-exception;
        Logger.e$default(Logger.INSTANCE, "FetchCategoryEffectCacheTask", "Json Parse Exception: " + th, null, 4, null);     // Catch: Throwable -> L36
        String r17 = FileManager.a;
    L36:
        th = move-exception;
        String r18 = FileManager.a;
        FileManager.b(r4);
        throw th;
    L7:
        r4 = null;
    L39:
        r5 = false;
        goto L40
    }

    public final void l(long r19, long r21, long r23, com.ss.ugc.effectplatform.model.e r25) {
        CategoryEffectListResponse r8 = (CategoryEffectListResponse) r25;
        CategoryPageModel r0 = r8.getData();
        if (r0 == null) goto L119;
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
        String r18 = r17.getRec_id();
        if (r18 == null) goto L36;
        CategoryEffectModel r20 = r0.getCategory_effects();
        if (r20 == null) goto L25;
        List<Effect> r22 = r20.getCategory_effects();
    L26:
        com.ss.ugc.effectplatform.util.h.f(r18, r22);
        CategoryEffectModel r24 = r0.getCategory_effects();
        if (r24 == null) goto L29;
        List<Effect> r26 = r24.getCollection();
    L30:
        com.ss.ugc.effectplatform.util.h.f(r18, r26);
        CategoryEffectModel r27 = r0.getCategory_effects();
        if (r27 == null) goto L33;
        List<Effect> r28 = r27.getBind_effects();
    L34:
        com.ss.ugc.effectplatform.util.h.f(r18, r28);
        goto L36
    L33:
        r28 = null;
        goto L34
    L29:
        r26 = null;
        goto L30
    L25:
        r22 = null;
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
        int r38 = this.r;
        long r39 = 0;
        if (r38 != 0) goto L117;
        int r40 = com.ss.ugc.effectplatform.util.f.a;
        String r41 = com.ss.ugc.effectplatform.util.f.c(this.o, this.p, this.q, r38, this.s);
        dlc.a r42 = this.n.t;     // Catch: Exception -> L64
        if (r42 == null) goto L56;
        String r43 = r42.a.convertObjToJson(r8);     // Catch: Exception -> L64
    L57:
        if (r43 == null) goto L115;
        com.ss.ugc.effectplatform.cache.j r44 = (com.ss.ugc.effectplatform.cache.j) this.n.A.a;     // Catch: Exception -> L64
        if (r44 == null) goto L61;
        long r45 = r44.save(r41, r43);     // Catch: Exception -> L64
    L62:
        int r46 = elc.a.a;     // Catch: Exception -> L64
        r39 = r45 / ((long) 1024);     // Catch: Exception -> L64
        goto L115
    L61:
        r45 = 0;
    L115:
        CategoryPageModel r47 = r8.getData();     // Catch: Exception -> L94
        if (r47 == null) goto L73;
        CategoryEffectModel r48 = r47.getCategory_effects();     // Catch: Exception -> L94
        if (r48 == null) goto L73;
        String r49 = r48.getVersion();     // Catch: Exception -> L94
        if (r49 == null) goto L73;
    L74:
        CategoryPageModel r50 = r8.getData();     // Catch: Exception -> L94
        if (r50 == null) goto L79;
        CategoryEffectModel r51 = r50.getCategory_effects();     // Catch: Exception -> L94
        if (r51 == null) goto L79;
        int r52 = r51.getCursor();     // Catch: Exception -> L94
    L80:
        CategoryPageModel r53 = r8.getData();     // Catch: Exception -> L94
        if (r53 == null) goto L85;
        CategoryEffectModel r54 = r53.getCategory_effects();     // Catch: Exception -> L94
        if (r54 == null) goto L85;
        int r55 = r54.getSorting_position();     // Catch: Exception -> L94
    L86:
        CategoryVersion r56 = new CategoryVersion(r49, r52, r55);     // Catch: Exception -> L94
        dlc.a r57 = this.n.t;     // Catch: Exception -> L94
        if (r57 == null) goto L89;
        r5 = r57.a.convertObjToJson(r56);     // Catch: Exception -> L94
    L89:
        if (r5 == null) goto L105;
        com.ss.ugc.effectplatform.cache.j r58 = (com.ss.ugc.effectplatform.cache.j) this.n.A.a;     // Catch: Exception -> L94
        if (r58 == null) goto L105;
        int r59 = com.ss.ugc.effectplatform.util.f.a;     // Catch: Exception -> L94
        r58.save(com.ss.ugc.effectplatform.util.f.d(this.o, this.p), r5);     // Catch: Exception -> L94
    L105:
        long r110 = r39;
        super.l(r19, r21, r23, r8);
        int r60 = b0.a.a;
        long r61 = System.currentTimeMillis();
        EffectConfig r62 = this.n;
        klc.a r63 = (klc.a) r62.v.a;
        if (r63 == null) goto L120;
        Pair[] r64 = new Pair[8];
        r64[0] = TuplesKt.to("log_id", ((BaseNetworkTask) this).g);
        r64[1] = TuplesKt.to("panel", this.o);
        String r65 = this.p;
        if (r65 != null) goto L111;
        r65 = "";
    L111:
        r64[2] = TuplesKt.to("category", r65);
        r64[3] = TuplesKt.to("duration", Long.valueOf(r61 - r19));
        r64[4] = TuplesKt.to("network_time", Long.valueOf(r21 - r19));
        r64[5] = TuplesKt.to("json_time", Long.valueOf(r23 - r21));
        r64[6] = TuplesKt.to("io_time", Long.valueOf(r61 - r23));
        r64[7] = TuplesKt.to("size", Long.valueOf(r110));
        klc.b.c(r63, "category_paged", r62, MapsKt.mapOf(r64));
        return;
    L120:
        return;
    L85:
        r55 = 0;
    L79:
        r52 = 0;
    L73:
        r49 = "0";
    L94:
        e = move-exception;
        Logger.e$default(Logger.INSTANCE, "FetchCategoryEffectTask", "Json Exception: " + e, null, 4, null);
        goto L105
    L56:
        r43 = null;
    L64:
        e = move-exception;
        Logger.e$default(Logger.INSTANCE, "FetchCategoryEffectTask", "Json Exception: " + e, null, 4, null);
        goto L115
    L117:
        dlc.a r66 = this.n.t;     // Catch: Exception -> L102
        if (r66 == null) goto L104;
        String r67 = r66.a.convertObjToJson(r8);     // Catch: Exception -> L102
        if (r67 == null) goto L104;
        r39 = r67.length();     // Catch: Exception -> L102
    L104:
        int r68 = elc.a.a;
        r39 = r39 / ((long) 1024);
    L102:
        e = move-exception;
        Logger.e$default(Logger.INSTANCE, "FetchCategoryEffectTask", "Json Exception: " + e, null, 4, null);
        goto L104
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

    public FetchCategoryPagingEffectTask(EffectConfig r10, String r11, String r12, String r13, int r14, int r15, int r16, String r17, Map<String, String> r18) {
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
