package com.larus.search.impl.global;

import com.larus.bmhome.chat.bean.RecommendBot;
import com.larus.network.http.AsyncThrowable;
import com.larus.network.http.HttpExtKt;
import com.larus.network.http.y;
import com.larus.paging.PagingSource;
import com.larus.paging.w0;
import com.larus.platform.model.SearchMobParam;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import tx9.i3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class GlobalSearchPagingSource extends PagingSource<Integer, ws9.c> {
    public final String b;
    public final String c;
    public final WeakReference<by7.e> d;
    public Integer e;
    public final Set<String> f;
    public String g;
    public String h;

    public static final class a {
    }

    static {
    }

    public final Object b(w0 r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
        return r2.b;
    }

    public final Object c(PagingSource.a<Integer> r20, Continuation<? super PagingSource.b<Integer, ws9.c>> r21) {
        if ((r21 instanceof GlobalSearchPagingSource$load$1) == false) goto L7;
        GlobalSearchPagingSource$load$1 r2 = (GlobalSearchPagingSource$load$1) r21;
        int r3 = r2.label;
        if ((r3 & Integer.MIN_VALUE) == 0) goto L7;
        r2.label = r3 - Integer.MIN_VALUE;
    L8:
        GlobalSearchPagingSource$load$1 r13 = r2;
        Object r1 = r13.result;
        Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r13.label;
        boolean r15 = true;
        if (r5 == 0) goto L14;
        if (r5 != 1) goto L13;
        int r6 = r13.I$0;
        String r7 = (String) r13.L$0;
        ResultKt.throwOnFailure(r1);
    L22:
        y r8 = (com.larus.network.http.a) r1;
        ws9.a r9 = (ws9.a) ((com.larus.network.http.a) r8).b;
        com.larus.trace.tracknode.a r10 = this.d;
        if ((r10 instanceof com.larus.trace.tracknode.a) == false) goto L25;
        com.larus.trace.tracknode.a r11 = r10;
    L26:
        if (r11 == null) goto L28;
        String r12 = r11.k();
    L29:
        if (r9 == null) goto L33;
        Map<String, String> r14 = r9.e();
        if (r14 == null) goto L33;
        String r16 = r14.get("request_id");
    L34:
        this.h = r16;
        if (r6 != 0) goto L37;
        this.g = r16;
    L37:
        if (r9 == null) goto L55;
        List<ws9.b> r17 = r9.a();
        if (r17 == null) goto L55;
        Iterator<T> r18 = r17.iterator();
        int r19 = 0;
    L42:
        if (r18.hasNext() == false) goto L55;
        Object r22 = r18.next();
        int r110 = r19 + 1;
        if (r19 >= 0) goto L46;
        CollectionsKt.throwIndexOverflow();
    L46:
        ws9.b r23 = (ws9.b) r22;
        RecommendBot r111 = r23.a();
        if (r111 == null) goto L53;
        String r24 = this.g;
        String r112 = this.h;
        RecommendBot r25 = r23.a();
        if (r25 == null) goto L51;
        String r113 = r25.o();
    L52:
        r111.b = new SearchMobParam(r24, r112, r113, String.valueOf(r19 + r6), r12, 3);
        goto L53
    L51:
        r113 = null;
    L53:
        r19 = r110;
    L55:
        if ((r8 instanceof y) == false) goto L68;
        y r26 = r8;
        Long r27 = r26.g;
        if (r27 != null) goto L60;
    L62:
        Long r28 = r26.g;
        if (r28 == null) goto L65;
        String r29 = r28.toString();
    L66:
        d(r7, r29, (ws9.a) ((com.larus.network.http.a) r26).b, false);
    L70:
        ws9.a r30 = (ws9.a) ((com.larus.network.http.a) r8).b;
        if (r30 == null) goto L73;
        String r31 = this.b;
        List<ws9.b> r32 = r30.a();
        ArrayList r33 = new ArrayList();
        if (r32 == null) goto L102;
        Iterator<T> r34 = r32.iterator();
        int r114 = 0;
    L87:
        if (r34.hasNext() == false) goto L103;
        ws9.b r35 = (ws9.b) r34.next();
        Set<String> r36 = this.f;
        RecommendBot r115 = r35.a();
        if (r115 == null) goto L92;
        String r116 = r115.o();
        if (r116 == null) goto L92;
    L94:
        if (r36.contains(r116) == true) goto L95;
        RecommendBot r37 = r35.a();
        if (r37 == null) goto L101;
        String r38 = r37.o();
        if (r38 == null) goto L101;
        this.f.add(r38);
    L101:
        r33.add(r35);
        goto L87
    L95:
        r114 = r114 + 1;
    L92:
        r116 = "";
    L103:
        if (r32 == null) goto L105;
        int r39 = r32.size();
    L106:
        if (r114 != r39) goto L109;
        r15 = false;
    L109:
        Boolean r40 = Boolean.valueOf(r15);
        ArrayList r41 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r33, 10));
        Iterator r42 = r33.iterator();
    L111:
        if (r42.hasNext() == false) goto L113;
        r41.add(new ws9.c(r31, (ws9.b) r42.next()));
        goto L111
    L113:
        Pair r43 = TuplesKt.to(r40, r41);
        boolean r44 = ((Boolean) r43.getFirst()).booleanValue();
        List r45 = (List) r43.getSecond();
        List<ws9.b> r46 = r30.a();
        if (r46 != null) goto L116;
        r46 = CollectionsKt.emptyList();
    L116:
        int r47 = r46.size() + r6;
        Integer r48 = r30.d();
        if (r48 == null) goto L119;
        int r117 = r48.intValue();
    L120:
        if (r47 < r117) goto L122;
        Integer r49 = null;
    L127:
        if (Intrinsics.areEqual(this.e, r49) == true) goto L131;
        if (r44 == false) goto L131;
        this.e = r49;
        return new PagingSource.b.c(r45, r49);
    L131:
        this.e = null;
        return new PagingSource.b.c(r45, null);
    L122:
        List<ws9.b> r50 = r30.a();
        if (r50 != null) goto L125;
        r50 = CollectionsKt.emptyList();
    L125:
        r49 = Boxing.boxInt(r6 + r50.size());
        goto L127
    L119:
        r117 = 0;
        goto L120
    L105:
        r39 = 0;
        goto L106
    L102:
        r114 = 0;
        goto L103
    L73:
        if ((r8 instanceof com.larus.network.http.f) == false) goto L75;
        com.larus.network.http.f r51 = (com.larus.network.http.f) r8;
    L76:
        if (r51 == null) goto L80;
        AsyncThrowable r52 = r51.d;
        if (r52 == null) goto L80;
    L82:
        return new PagingSource.b.a(r52);
    L80:
        r52 = new Error("unknown error");
        goto L82
    L75:
        r51 = null;
        goto L76
    L65:
        r29 = null;
        goto L66
    L60:
        if (r27.longValue() != 0) goto L62;
        d(r7, null, (ws9.a) ((com.larus.network.http.a) r26).b, true);
        goto L70
    L68:
        if ((r8 instanceof com.larus.network.http.f) == false) goto L70;
        com.larus.network.http.f r53 = (com.larus.network.http.f) r8;
        d(r7, String.valueOf(r53.d.getCode()), (ws9.a) ((com.larus.network.http.a) r53).b, false);
    L33:
        r16 = null;
        goto L34
    L28:
        r12 = null;
        goto L29
    L25:
        r11 = null;
        goto L26
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r1);
        Integer r54 = (Integer) r20.a();
        if (r54 == null) goto L17;
        int r55 = r54.intValue();
    L18:
        String r118 = this.b;
        JSONObject r56 = new JSONObject();
        r56.put("keyword", r118);
        r56.put("offset", r55);
        r56.put("index_type", 2);
        r56.put("size", r20.a);
        Unit r57 = Unit.INSTANCE;
        r13.L$0 = r118;
        r13.I$0 = r55;
        r13.label = 1;
        Object r58 = HttpExtKt.k("Basic", ws9.a.class, "/alice/comprehensive/search", r56, null, null, false, null, null, null, r13, 1008);
        if (r58 != r4) goto L21;
        return r4;
    L21:
        r6 = r55;
        r1 = r58;
        r7 = r118;
        goto L22
    L17:
        r55 = 0;
    L7:
        r2 = new GlobalSearchPagingSource$load$1(this, r21);
        goto L8
    }

    public GlobalSearchPagingSource(String r2, String r3, WeakReference<by7.e> r4) {
        Intrinsics.checkNotNullParameter(r2, "query");
        Intrinsics.checkNotNullParameter(r3, "enterMethod");
        Intrinsics.checkNotNullParameter(r4, "trackNode");
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = -1;
        this.f = new LinkedHashSet();
    }

    public final void d(String r15, String r16, ws9.a r17, boolean r18) {
        String r2 = this.c;
        if (r17 == null) goto L7;
        Integer r1 = r17.d();
        if (r1 == null) goto L7;
        Long r3 = Long.valueOf(r1.intValue());
    L8:
        Long r4 = r3;
        String r6 = iz8.c.d(r15);
        String r8 = this.h;
        String r7 = this.g;
        if (r18 == false) goto L11;
        String r5 = "1";
    L12:
        i3.c("bot_list_discover_search", r2, r16, r4, r15, r6, r7, r8, null, null, r5, this.d.get(), 5696);
        return;
    L11:
        r5 = "0";
    L7:
        r3 = null;
        goto L8
    }
}
