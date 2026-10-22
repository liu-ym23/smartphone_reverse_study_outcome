package com.larus.bmhome.chat.doclink;

import com.bytedance.keva.Keva;
import com.larus.bmhome.auth.LaunchBiz;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class MessageDocPreviewRepository {
    public static final MessageDocPreviewRepository a = null;

    public static final class a {
        public final Map<String, h> a;
        public final Set<String> b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof a) == true) goto L8;
            return false;
        L8:
            a r6 = (a) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.a.hashCode() * 31) + this.b.hashCode();
        }

        public final String toString() {
            return "FetchResult(previewsByUrl=" + this.a + ", previewUrls=" + this.b + ')';
        }

        public a(Map<String, h> r2, Set<String> r3) {
            Intrinsics.checkNotNullParameter(r2, "previewsByUrl");
            Intrinsics.checkNotNullParameter(r3, "previewUrls");
            this.a = r2;
            this.b = r3;
        }
    }

    public static final class b implements Function1<Map<String, ? extends h>, Unit> {
        public final /* synthetic */ kotlinx.coroutines.i<Map<String, h>> a;

        public b(kotlinx.coroutines.j r1) {
            this.a = r1;
        }

        public final Object invoke(Object r2) {
            Map r3 = (Map) r2;
            Intrinsics.checkNotNullParameter(r3, "previews");
            if (this.a.isActive() == false) goto L6;
            this.a.resumeWith(Result.constructor-impl(r3));
        L6:
            return Unit.INSTANCE;
        }
    }

    static {
        a = new MessageDocPreviewRepository();
    }

    public MessageDocPreviewRepository() {
    }

    public static Map.Entry b(Map r7, String r8) {
        Set r9 = r7.entrySet();
        ArrayList r0 = new ArrayList();
        Iterator r10 = r9.iterator();
    L3:
        Object r2 = null;
        if (r10.hasNext() == false) goto L13;
        Object r1 = r10.next();
        String r3 = l.a((String) ((Map.Entry) r1).getKey());
        boolean r5 = true;
        if ((!StringsKt.isBlank(r3)) == true) goto L8;
    L10:
        r5 = false;
    L11:
        if (r5 == false) goto L3;
        r0.add(r1);
        goto L3
    L8:
        if (StringsKt.startsWith$default(r8, r3, false, 2, null) == false) goto L10;
    L13:
        Iterator r11 = r0.iterator();
        if (r11.hasNext() == false) goto L26;
        r2 = r11.next();
        if (r11.hasNext() == false) goto L26;
        int r12 = l.a((String) ((Map.Entry) r2).getKey()).length();
    L20:
        Object r4 = r11.next();
        int r6 = l.a((String) ((Map.Entry) r4).getKey()).length();
        if (r12 >= r6) goto L24;
        r2 = r4;
        r12 = r6;
    L24:
        if (r11.hasNext() == true) goto L20;
    L26:
        return (Map.Entry) r2;
    }

    public static a e(String r3, List r4) {
        Intrinsics.checkNotNullParameter(r3, "messageId");
        Intrinsics.checkNotNullParameter(r4, "urls");
        List r5 = r4;
        ArrayList r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r5, 10));
        Iterator r6 = r5.iterator();
    L4:
        if (r6.hasNext() == false) goto L6;
        r0.add(l.a((String) r6.next()));
        goto L4
    L6:
        ArrayList r7 = new ArrayList();
        Iterator r1 = r0.iterator();
    L8:
        if (r1.hasNext() == false) goto L12;
        Object r2 = r1.next();
        if ((!StringsKt.isBlank((String) r2)) == false) goto L8;
        r7.add(r2);
        goto L8
    L12:
        List r8 = CollectionsKt.distinct(r7);
        g.a.getClass();
        List r9 = g.b(r8);
        f.a.getClass();
        Map r10 = f.c(r3, r9);
        return new a(r10, r10.keySet());
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:53:0x0130 -> B:55:0x0133). Please report as a decompilation issue!!! */
    public final Object f(List<String> r13, Continuation<? super List<String>> r14) {
        if ((r14 instanceof MessageDocPreviewRepository$normalizeDistinctPreviewUrlsForRemote$1) == false) goto L7;
        MessageDocPreviewRepository$normalizeDistinctPreviewUrlsForRemote$1 r0 = (MessageDocPreviewRepository$normalizeDistinctPreviewUrlsForRemote$1) r14;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r15 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        long r6 = r0.J$0;
        List r16 = (List) r0.L$0;
        ResultKt.throwOnFailure(r15);
    L55:
        r6 = r6 + 500;
        g.a.getClass();
        List r17 = g.b(r16);
        if (g.c() == false) goto L49;
    L57:
        return r17;
    L49:
        if (r17.isEmpty() == false) goto L57;
        if (r6 >= 3000) goto L57;
        r0.L$0 = r16;
        r0.J$0 = r6;
        r0.label = 1;
        if (DelayKt.delay(500, r0) != r2) goto L55;
        return r2;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r15);
        List<String> r18 = r13;
        ArrayList r19 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r18, 10));
        Iterator<T> r110 = r18.iterator();
    L16:
        if (r110.hasNext() == false) goto L18;
        r19.add(l.a((String) r110.next()));
        goto L16
    L18:
        ArrayList r111 = new ArrayList();
        Iterator r112 = r19.iterator();
    L20:
        if (r112.hasNext() == false) goto L24;
        Object r4 = r112.next();
        if ((!StringsKt.isBlank((String) r4)) == false) goto L20;
        r111.add(r4);
        goto L20
    L24:
        r16 = CollectionsKt.distinct(r111);
        g.a.getClass();
        r17 = g.b(r16);
        if (r17.isEmpty() == false) goto L57;
        if ((!r16.isEmpty()) == false) goto L57;
        if (g.c() == true) goto L57;
        if (g.c() == false) goto L33;
    L47:
        r6 = 0;
        goto L49
    L33:
        if (g.b.compareAndSet(false, true) == false) goto L47;
        Result.Companion r7 = Result.Companion;     // Catch: Throwable -> L37
        FLogger.a.i("MessageDocPreviewDomainMatcher", "requestPreviewUrlRulesIfNeeded request im launch");     // Catch: Throwable -> L37
        AuthModelDelegate.b.t("MessageDocPreviewDomainMatcher", SetsKt.setOf(LaunchBiz.IM), true);     // Catch: Throwable -> L37
        Object r8 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L37
    L39:
        Throwable r9 = Result.exceptionOrNull-impl(r8);
        if (r9 == null) goto L43;
        g.b.set(false);
        FLogger.a.i("MessageDocPreviewDomainMatcher", "requestPreviewUrlRulesIfNeeded failed=" + r9.getMessage());
    L43:
        if (Result.isSuccess-impl(r8) == false) goto L47;
        Unit r10 = (Unit) r8;
        g.a.getClass();
        if (g.c() == true) goto L47;
        g.b.set(false);
    L37:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        r8 = Result.constructor-impl(ResultKt.createFailure(th));
    L7:
        r0 = new MessageDocPreviewRepository$normalizeDistinctPreviewUrlsForRemote$1(this, r14);
        goto L8
    }

    public static String c(Map r7, String r8, List r9) {
        String r0 = l.a(r8);
        Iterator r1 = r7.keySet().iterator();
    L3:
        Object r4 = null;
        if (r1.hasNext() == false) goto L14;
        Object r2 = r1.next();
        String r5 = (String) r2;
        if (Intrinsics.areEqual(r5, r8) == false) goto L8;
    L11:
        boolean r6 = true;
    L12:
        if (r6 == false) goto L3;
    L15:
        String r3 = (String) r2;
        if (r3 != null) goto L18;
    L23:
        Map.Entry r10 = b(r7, r0);
        if (r10 == null) goto L34;
        String r11 = (String) r10.getKey();
        if (r11 == null) goto L34;
        if ((!StringsKt.isBlank(r11)) == true) goto L31;
        r11 = null;
    L31:
        if (r11 == null) goto L34;
        return r11;
    L34:
        if (r9.size() == 1) goto L36;
        return null;
    L36:
        if (r7.size() != 1) goto L54;
        Iterator r12 = r7.keySet().iterator();
    L39:
        if (r12.hasNext() == false) goto L44;
        Object r13 = r12.next();
        if ((!StringsKt.isBlank((String) r13)) == false) goto L39;
        r4 = r13;
    L44:
        return (String) r4;
    L54:
        return null;
    L18:
        if ((!StringsKt.isBlank(r3)) == true) goto L21;
        r3 = null;
    L21:
        if (r3 == null) goto L23;
        return r3;
    L8:
        if (Intrinsics.areEqual(l.a(r5), r0) == true) goto L11;
        r6 = false;
        goto L12
    L14:
        r2 = null;
        goto L15
    }

    public static String d(Map r5, String r6, List r7) {
        String r0 = l.a(r6);
        String r8 = (String) r5.get(r6);
        Object r1 = null;
        if (r8 != null) goto L5;
    L10:
        String r9 = (String) r5.get(r0);
        if (r9 != null) goto L13;
    L18:
        Iterator r10 = r5.entrySet().iterator();
    L20:
        if (r10.hasNext() == false) goto L24;
        Object r3 = r10.next();
        if (Intrinsics.areEqual(l.a((String) ((Map.Entry) r3).getKey()), r0) == false) goto L20;
    L25:
        Map.Entry r4 = (Map.Entry) r3;
        if (r4 == null) goto L35;
        String r11 = (String) r4.getValue();
        if (r11 == null) goto L35;
        if ((!StringsKt.isBlank(r11)) == true) goto L33;
        r11 = null;
    L33:
        if (r11 == null) goto L35;
        return r11;
    L35:
        Map.Entry r12 = b(r5, r0);
        if (r12 == null) goto L46;
        String r13 = (String) r12.getValue();
        if (r13 == null) goto L46;
        if ((!StringsKt.isBlank(r13)) == true) goto L43;
        r13 = null;
    L43:
        if (r13 == null) goto L46;
        return r13;
    L46:
        if (r7.size() == 1) goto L48;
        return null;
    L48:
        if (r5.size() != 1) goto L64;
        Iterator r14 = r5.values().iterator();
    L51:
        if (r14.hasNext() == false) goto L56;
        Object r15 = r14.next();
        if ((!StringsKt.isBlank((String) r15)) == false) goto L51;
        r1 = r15;
    L56:
        return (String) r1;
    L64:
        return null;
    L24:
        r3 = null;
        goto L25
    L13:
        if ((!StringsKt.isBlank(r9)) == true) goto L16;
        r9 = null;
    L16:
        if (r9 == null) goto L18;
        return r9;
    L5:
        if ((!StringsKt.isBlank(r8)) == true) goto L8;
        r8 = null;
    L8:
        if (r8 == null) goto L10;
        return r8;
    }

    public final Object a(String r19, List<String> r20, Continuation<? super a> r21) {
        if ((r21 instanceof MessageDocPreviewRepository$fetchRemotePreviews$1) == false) goto L7;
        MessageDocPreviewRepository$fetchRemotePreviews$1 r2 = (MessageDocPreviewRepository$fetchRemotePreviews$1) r21;
        int r3 = r2.label;
        if ((r3 & Integer.MIN_VALUE) == 0) goto L7;
        r2.label = r3 - Integer.MIN_VALUE;
    L8:
        Object r0 = r2.result;
        Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r2.label;
        if (r5 == 0) goto L18;
        if (r5 == 1) goto L17;
        if (r5 == 2) goto L16;
        if (r5 != 3) goto L15;
        Map r6 = (Map) r2.L$5;
        List r7 = (List) r2.L$4;
        Set r8 = (Set) r2.L$3;
        LinkedHashMap r9 = (LinkedHashMap) r2.L$2;
        List r10 = (List) r2.L$1;
        String r11 = (String) r2.L$0;
        ResultKt.throwOnFailure(r0);
    L112:
        Map r12 = (Map) r0;
        LinkedHashMap r13 = new LinkedHashMap();
        Iterator r1 = r10.iterator();
    L114:
        if (r1.hasNext() == false) goto L134;
        String r14 = (String) r1.next();
        String r15 = d(r9, r14, r10);
        if (r15 == null) goto L114;
        h r16 = (h) r12.get(r15);
        if (r16 == null) goto L121;
    L126:
        if (r16 == null) goto L114;
        String r17 = c(r9, r14, r10);
        if (r17 != null) goto L130;
        r17 = r14;
    L130:
        String r18 = l.a(r14);
        String r110 = r16.c;
        if (StringsKt.isBlank(r110) == false) goto L133;
        r110 = r17;
    L133:
        r13.put(r18, h.a(r16, null, r110, r17, 4091));
        goto L114
    L121:
        if (r10.size() == 1) goto L123;
    L125:
        r16 = null;
        goto L126
    L123:
        if (r12.values().size() != 1) goto L125;
        r16 = (h) CollectionsKt.firstOrNull(r12.values());
        goto L126
    L134:
        f.a.getClass();
        Intrinsics.checkNotNullParameter(r11, "messageId");
        Intrinsics.checkNotNullParameter(r13, "previewsByUrl");
        if (StringsKt.isBlank(r11) == false) goto L137;
    L163:
        FLogger.a.i("MessageDocPreviewRepository", "fetchRemotePreviews entityCount=" + r12.size() + ", renderCount=" + r13.size());
        return new a(r13, r8);
    L137:
        if (r13.isEmpty() == true) goto L163;
        Iterator r22 = r13.entrySet().iterator();
    L141:
        if (r22.hasNext() == false) goto L163;
        Map.Entry r23 = (Map.Entry) r22.next();
        String r24 = (String) r23.getKey();
        h r25 = (h) r23.getValue();
        f r111 = f.a;
        r111.getClass();
        Intrinsics.checkNotNullParameter(r11, "messageId");
        Intrinsics.checkNotNullParameter(r24, "url");
        Intrinsics.checkNotNullParameter(r25, "preview");
        String r112 = f.a(r11, r24);
        if (r112 == null) goto L141;
        Result.Companion r113 = Result.Companion;     // Catch: Throwable -> L157
        Keva r114 = f.d();     // Catch: Throwable -> L157
        String r115 = r25.c;     // Catch: Throwable -> L157
        if (StringsKt.isBlank(r115) == false) goto L148;
        r115 = r24;
    L148:
        String r116 = r25.m;     // Catch: Throwable -> L157
        if (r116 == null) goto L167;
        r24 = r116;
    L167:
        r114.storeString(r112, f.j(h.a(r25, null, r115, r24, 4091)).toString());     // Catch: Throwable -> L155
        r111.h(r112);     // Catch: Throwable -> L155
        Object r26 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L155
    L160:
        Throwable r27 = Result.exceptionOrNull-impl(r26);
        if (r27 == null) goto L141;
        FLogger.a.w("MessageDocPreviewCache", "store failed, key=" + r112 + ", err=" + r27.getMessage());
    L155:
        th = th;
    L159:
        Result.Companion r28 = Result.Companion;
        r26 = Result.constructor-impl(ResultKt.createFailure(th));
    L157:
        th = th;
        goto L159
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        LinkedHashMap r29 = (LinkedHashMap) r2.L$5;
        LinkedHashMap r30 = (LinkedHashMap) r2.L$4;
        List r117 = (List) r2.L$3;
        Map r118 = (Map) r2.L$2;
        List r119 = (List) r2.L$1;
        String r120 = (String) r2.L$0;
        ResultKt.throwOnFailure(r0);
    L63:
        r29.putAll((Map) r0);
        r9 = r30;
        r10 = r119;
    L65:
        List r31 = r10;
        ArrayList r121 = new ArrayList();
        Iterator r122 = r31.iterator();
    L67:
        if (r122.hasNext() == false) goto L74;
        String r123 = (String) r122.next();
        if (d(r9, r123, r10) != null) goto L72;
        r123 = null;
    L72:
        if (r123 == null) goto L67;
        r121.add(r123);
        goto L67
    L74:
        ArrayList r124 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r121, 10));
        Iterator r125 = r121.iterator();
    L76:
        if (r125.hasNext() == false) goto L78;
        r124.add(l.a((String) r125.next()));
        goto L76
    L78:
        Set r126 = CollectionsKt.toSet(r124);
        ArrayList r127 = new ArrayList();
        Iterator r128 = r31.iterator();
    L80:
        if (r128.hasNext() == false) goto L85;
        String r32 = d(r9, (String) r128.next(), r10);
        if (r32 == null) goto L80;
        r127.add(r32);
        goto L80
    L85:
        List r33 = CollectionsKt.distinct(r127);
        FLogger.a.i("MessageDocPreviewRepository", "fetchRemotePreviews previewIdCount=" + r33.size() + ", cachedPreviewIdCount=" + r118.size() + ", proxyUrlCount=" + r117.size() + ", rawMapSize=" + r9.size());
        if (r33.isEmpty() == true) goto L88;
        ArrayList r34 = new ArrayList();
        Iterator r35 = r31.iterator();
    L91:
        if (r35.hasNext() == false) goto L102;
        String r129 = (String) r35.next();
        String r130 = d(r9, r129, r10);
        if (r130 == null) goto L99;
        String r131 = c(r9, r129, r10);
        if (r131 == null) goto L98;
        r129 = r131;
    L98:
        Pair r132 = TuplesKt.to(r130, r129);
    L100:
        if (r132 == null) goto L91;
        r34.add(r132);
        goto L91
    L99:
        r132 = null;
        goto L100
    L102:
        Map r36 = MapsKt.toMap(r34);
        r2.L$0 = r120;
        r2.L$1 = r10;
        r2.L$2 = r9;
        r2.L$3 = r126;
        r2.L$4 = r33;
        r2.L$5 = r36;
        r2.label = 3;
        kotlinx.coroutines.j r37 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r2), 1);
        r37.C();
        int r38 = k.a;
        b r39 = new b(r37);
        Intrinsics.checkNotNullParameter(r33, "previewIds");
        Intrinsics.checkNotNullParameter(r36, "fallbackUrlsByPreviewId");
        Intrinsics.checkNotNullParameter(r39, "callback");
        IMessageDocPreviewService r133 = k.a();
        if (r133 == null) goto L105;
        r133.c(r33, r36, r39);
    L106:
        r0 = r37.B();
        if (r0 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L109;
        DebugProbesKt.probeCoroutineSuspended(r2);
    L109:
        if (r0 != r4) goto L111;
        return r4;
    L111:
        r8 = r126;
        r11 = r120;
        goto L112
    L105:
        r39.invoke(MapsKt.emptyMap());
        goto L106
    L88:
        return new a(MapsKt.emptyMap(), r126);
    L17:
        String r40 = (String) r2.L$0;
        ResultKt.throwOnFailure(r0);
        Object r41 = r0;
        String r42 = r40;
    L30:
        r119 = (List) r41;
        if (StringsKt.isBlank(r42) == true) goto L166;
        if (r119.isEmpty() == true) goto L166;
        f.a.getClass();
        Map r43 = f.c(r42, r119);
        LinkedHashMap r134 = new LinkedHashMap(MapsKt.mapCapacity(r43.size()));
        Iterator r44 = r43.entrySet().iterator();
    L37:
        if (r44.hasNext() == false) goto L39;
        Map.Entry r135 = (Map.Entry) r44.next();
        r134.put(r135.getKey(), ((h) r135.getValue()).a);
        goto L37
    L39:
        LinkedHashMap r45 = new LinkedHashMap();
        Iterator r136 = r134.entrySet().iterator();
    L41:
        if (r136.hasNext() == false) goto L45;
        Map.Entry r137 = (Map.Entry) r136.next();
        if ((!StringsKt.isBlank((String) r137.getValue())) == false) goto L41;
        r45.put(r137.getKey(), r137.getValue());
        goto L41
    L45:
        ArrayList r138 = new ArrayList();
        Iterator r139 = r119.iterator();
    L47:
        if (r139.hasNext() == false) goto L57;
        Object r140 = r139.next();
        String r141 = d(r45, (String) r140, r119);
        if (r141 != null) goto L51;
    L54:
        boolean r142 = true;
    L55:
        if (r142 == false) goto L47;
        r138.add(r140);
        goto L47
    L51:
        if (StringsKt.isBlank(r141) == true) goto L54;
        r142 = false;
        goto L55
    L57:
        r30 = new LinkedHashMap();
        r30.putAll(r45);
        if ((!r138.isEmpty()) == false) goto L64;
        CoroutineDispatcher r143 = Dispatchers.getIO();
        MessageDocPreviewRepository$fetchRemotePreviews$2 r144 = new MessageDocPreviewRepository$fetchRemotePreviews$2(r138, r42, null);
        r2.L$0 = r42;
        r2.L$1 = r119;
        r2.L$2 = r45;
        r2.L$3 = r138;
        r2.L$4 = r30;
        r2.L$5 = r30;
        r2.label = 2;
        Object r145 = BuildersKt.withContext(r143, r144, r2);
        if (r145 != r4) goto L62;
        return r4;
    L62:
        r118 = r45;
        r29 = r30;
        r120 = r42;
        r0 = r145;
        r117 = r138;
        goto L63
    L64:
        r118 = r45;
        r9 = r30;
        r10 = r119;
        r117 = r138;
        r120 = r42;
    L166:
        return new a(MapsKt.emptyMap(), SetsKt.emptySet());
    L18:
        ResultKt.throwOnFailure(r0);
        IMessageDocPreviewService r46 = k.a();
        if (r46 != null) goto L21;
    L23:
        boolean r47 = false;
    L24:
        if (r47 == false) goto L26;
        r42 = r19;
        r2.L$0 = r42;
        r2.label = 1;
        r41 = f(r20, r2);
        if (r41 != r4) goto L30;
        return r4;
    L26:
        return new a(MapsKt.emptyMap(), SetsKt.emptySet());
    L21:
        if (r46.isSupported() != true) goto L23;
        r47 = true;
    L7:
        r2 = new MessageDocPreviewRepository$fetchRemotePreviews$1(this, r21);
        goto L8
    }
}
