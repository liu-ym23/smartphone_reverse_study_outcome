package com.obric.assistant.cocreationreview.modules.proactive;

import android.content.Context;
import com.obric.assistant.cocreationreview.g5;
import com.obric.assistant.cocreationreview.h5;
import com.obric.assistant.cocreationreview.l5;
import com.obric.memorydata.sdk.proactive.ProactiveAllPageSnapshot;
import com.obric.memorydata.sdk.proactive.ProactiveDayHeaderDto;
import com.obric.memorydata.sdk.proactive.ProactiveDayPageResult;
import com.obric.memorydata.sdk.proactive.ProactiveLabelingFeedbackConfigDto;
import com.obric.memorydata.sdk.proactive.ProactiveRecommendationDto;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class ProactiveAgentRepository {
    public static final /* synthetic */ int b = 0;
    public final Context a;

    public static final class a {
    }

    static {
    }

    public ProactiveAgentRepository(Context r1) {
        if (r1 == null) goto L5;
        Context r2 = r1.getApplicationContext();
    L6:
        this.a = r2;
        return;
    L5:
        r2 = null;
        goto L6
    }

    public final n d(g5 r8) {
        Intrinsics.checkNotNullParameter(r8, "request");
        l5 r0 = e.a;
        ProactiveLabelingFeedbackConfigDto r3 = new ProactiveLabelingFeedbackConfigDto(i.a().g, i.a().h, i.a().i);
        Context r2 = this.a;
        if (r2 != null) goto L7;
        return new n(CollectionsKt.emptyList(), r3);
    L7:
        return (n) BuildersKt.runBlocking$default(null, new ProactiveAgentRepository$loadSnapshot$1(r2, r3, r8, this, null), 1, null);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x009b -> B:22:0x00a7). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x00c1 -> B:27:0x00c7). Please report as a decompilation issue!!! */
    public static final Object b(ProactiveAgentRepository r13, g5 r14, Continuation r15) {
        r13.getClass();
        if ((r15 instanceof ProactiveAgentRepository$loadRecommendationsWithoutSnapshot$1) == false) goto L7;
        ProactiveAgentRepository$loadRecommendationsWithoutSnapshot$1 r0 = (ProactiveAgentRepository$loadRecommendationsWithoutSnapshot$1) r15;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r16 = r0.result;
        Object r17 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.label;
        if (r2 == 0) goto L14;
        if (r2 != 1) goto L13;
        int r18 = r0.I$0;
        String r3 = (String) r0.L$3;
        Iterator r4 = (Iterator) r0.L$2;
        LinkedHashMap r5 = (LinkedHashMap) r0.L$1;
        g5 r6 = (g5) r0.L$0;
        ResultKt.throwOnFailure(r16);
        ProactiveAgentRepository$loadRecommendationsWithoutSnapshot$1 r12 = r0;
        Object r7 = r17;
        String r19 = r3;
        ProactiveAgentRepository$loadRecommendationsWithoutSnapshot$1 r8 = r12;
    L27:
        ProactiveDayPageResult r110 = (ProactiveDayPageResult) r16;
        List r9 = r110.d;
        ArrayList r10 = new ArrayList();
        Iterator r11 = r9.iterator();
    L29:
        if (r11.hasNext() == false) goto L38;
        Object r20 = r11.next();
        ProactiveRecommendationDto r111 = (ProactiveRecommendationDto) r20;
        if (m.b(r111) == true) goto L33;
    L35:
        boolean r112 = false;
    L36:
        if (r112 == false) goto L29;
        r10.add(r20);
        goto L29
    L33:
        if (m.a(r6, r111.j) == false) goto L35;
        r112 = true;
        goto L36
    L38:
        Iterator r21 = r10.iterator();
    L40:
        if (r21.hasNext() == false) goto L42;
        ProactiveRecommendationDto r22 = (ProactiveRecommendationDto) r21.next();
        r5.put(m.e(r22), r22);
        goto L40
    L42:
        int r113 = r18 + r110.d.size();
        if (r110.c == true) goto L45;
    L47:
        boolean r114 = false;
    L48:
        g5 r115 = r6;
        boolean r23 = r114;
        LinkedHashMap r116 = r5;
        String r24 = r19;
        int r117 = r113;
        r14 = r115;
    L22:
        if (r23 == false) goto L49;
        ska.b r25 = ska.b.a;
        r8.L$0 = r14;
        r8.L$1 = r116;
        r8.L$2 = r4;
        r8.L$3 = r24;
        r8.I$0 = r117;
        r8.label = 1;
        ProactiveDayPageResult r26 = ska.b.c(r25, 0, r24, r117);
        if (r26 == r7) goto L64;
        String r118 = r24;
        r5 = r116;
        r16 = r26;
        r6 = r14;
        r18 = r117;
        r19 = r118;
        goto L27
    L64:
        return r7;
    L49:
        r17 = r7;
        r0 = r8;
        Iterator r27 = r4;
    L20:
        if (r27.hasNext() == false) goto L50;
        r24 = (String) r27.next();
        r23 = true;
        r4 = r27;
        r8 = r0;
        r7 = r17;
        r117 = 0;
        goto L22
    L50:
        Collection r119 = r116.values();
        ArrayList r120 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r119, 10));
        Iterator r121 = r119.iterator();
    L52:
        if (r121.hasNext() == false) goto L55;
        ProactiveRecommendationDto r122 = (ProactiveRecommendationDto) r121.next();
        Intrinsics.checkNotNull(r122);
        r120.add(m.f(r122));
        goto L52
    L55:
        return CollectionsKt.sortedWith(r120, new p(new o()));
    L45:
        if ((!r110.d.isEmpty()) == false) goto L47;
        r114 = true;
        goto L48
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r16);
        r116 = new LinkedHashMap();
        h5 r28 = g5.a(r14);
        ZoneId r29 = ZoneId.systemDefault();
        LocalDate r30 = Instant.ofEpochMilli(r28.b).atZone(r29).toLocalDate();
        LocalDate r31 = Instant.ofEpochMilli(r28.a).atZone(r29).toLocalDate();
        ArrayList r32 = new ArrayList();
    L16:
        if (r30.isBefore(r31) == true) goto L18;
        r32.add(r30.toString());
        r30 = r30.minusDays(1);
        goto L16
    L18:
        r27 = r32.iterator();
    L7:
        r0 = new ProactiveAgentRepository$loadRecommendationsWithoutSnapshot$1(r13, r15);
        goto L8
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0070 -> B:20:0x0079). Please report as a decompilation issue!!! */
    public final Object c(long r19, String r21, Continuation<? super List<ProactiveRecommendationDto>> r22) {
        if ((r22 instanceof ProactiveAgentRepository$loadPagedDayRecommendations$1) == false) goto L7;
        ProactiveAgentRepository$loadPagedDayRecommendations$1 r1 = (ProactiveAgentRepository$loadPagedDayRecommendations$1) r22;
        int r2 = r1.label;
        if ((r2 & Integer.MIN_VALUE) == 0) goto L7;
        r1.label = r2 - Integer.MIN_VALUE;
    L8:
        Object r0 = r1.result;
        Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r1.label;
        if (r4 == 0) goto L14;
        if (r4 != 1) goto L13;
        int r5 = r1.I$0;
        long r7 = r1.J$0;
        List r9 = (List) r1.L$1;
        String r10 = (String) r1.L$0;
        ResultKt.throwOnFailure(r0);
        Object r11 = r3;
        String r6 = r10;
        List r12 = r9;
    L20:
        ProactiveDayPageResult r8 = (ProactiveDayPageResult) r0;
        long r13 = r8.a;
        if (r13 != 0) goto L23;
    L25:
        CollectionsKt.addAll(r12, r8.d);
        int r14 = r5 + r8.d.size();
        if (r8.c == true) goto L28;
    L30:
        boolean r15 = false;
    L31:
        List r16 = r12;
        boolean r17 = r15;
        ProactiveAgentRepository$loadPagedDayRecommendations$1 r18 = r1;
        long r20 = r7;
        Object r23 = r11;
        List r24 = r16;
        int r25 = r14;
    L15:
        if (r17 == false) goto L32;
        ska.b r110 = ska.b.a;
        r18.L$0 = r6;
        r18.L$1 = r24;
        r18.J$0 = r20;
        r18.I$0 = r25;
        r18.label = 1;
        ProactiveDayPageResult r111 = ska.b.c(r110, r20, r6, r25);
        if (r111 != r23) goto L19;
        return r23;
    L19:
        long r112 = r20;
        r1 = r18;
        r5 = r25;
        r0 = r111;
        r12 = r24;
        r11 = r23;
        r7 = r112;
        goto L20
    L32:
        return r24;
    L28:
        if ((!r8.d.isEmpty()) == false) goto L30;
        r15 = true;
        goto L31
    L23:
        if (r13 == r7) goto L25;
        return r12;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r0);
        r24 = new ArrayList();
        r18 = r1;
        r23 = r3;
        r25 = 0;
        r17 = true;
        r20 = r19;
        r6 = r21;
    L7:
        r1 = new ProactiveAgentRepository$loadPagedDayRecommendations$1(this, r22);
        goto L8
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0072 -> B:20:0x0077). Please report as a decompilation issue!!! */
    public final Object e(ProactiveAllPageSnapshot r12, ProactiveDayHeaderDto r13, Continuation<? super List<ProactiveRecommendationDto>> r14) {
        if ((r14 instanceof ProactiveAgentRepository$loadTodayRecommendations$1) == false) goto L7;
        ProactiveAgentRepository$loadTodayRecommendations$1 r0 = (ProactiveAgentRepository$loadTodayRecommendations$1) r14;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r15 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        int r16 = r0.I$0;
        List r17 = (List) r0.L$2;
        ProactiveDayHeaderDto r4 = (ProactiveDayHeaderDto) r0.L$1;
        ProactiveAllPageSnapshot r5 = (ProactiveAllPageSnapshot) r0.L$0;
        ResultKt.throwOnFailure(r15);
        int r6 = r16;
        r12 = r5;
        Object r7 = r2;
        ProactiveAgentRepository$loadTodayRecommendations$1 r8 = r0;
        ProactiveDayHeaderDto r9 = r4;
    L20:
        ProactiveDayPageResult r18 = (ProactiveDayPageResult) r15;
        long r10 = r18.a;
        if (r10 != 0) goto L23;
    L25:
        CollectionsKt.addAll(r17, r18.d);
        r6 = r6 + r18.d.size();
        if (r18.c == true) goto L28;
    L30:
        boolean r19 = false;
    L31:
        Object r11 = r7;
        boolean r20 = r19;
        ProactiveDayHeaderDto r110 = r9;
        r0 = r8;
        r2 = r11;
    L15:
        if (r20 == false) goto L32;
        ska.b r21 = ska.b.a;
        long r22 = r12.a;
        String r23 = r110.a;
        r0.L$0 = r12;
        r0.L$1 = r110;
        r0.L$2 = r17;
        r0.I$0 = r6;
        r0.label = 1;
        ProactiveDayPageResult r24 = ska.b.c(r21, r22, r23, r6);
        if (r24 != r2) goto L19;
        return r2;
    L19:
        ProactiveAgentRepository$loadTodayRecommendations$1 r111 = r0;
        r9 = r110;
        r15 = r24;
        r7 = r2;
        r8 = r111;
    L32:
        return r17;
    L28:
        if ((!r18.d.isEmpty()) == false) goto L30;
        r19 = true;
        goto L31
    L23:
        if (r10 == r12.a) goto L25;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r15);
        List r112 = CollectionsKt.toMutableList(r12.c);
        r6 = r112.size();
        r20 = r12.d;
        r110 = r13;
        r17 = r112;
    L7:
        r0 = new ProactiveAgentRepository$loadTodayRecommendations$1(this, r14);
        goto L8
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x00d1 -> B:23:0x00d7). Please report as a decompilation issue!!! */
    public final Object f(ProactiveAllPageSnapshot r19, g5 r20, h5 r21, Continuation<? super List<ProactiveRecommendationDto>> r22) {
        ProactiveAllPageSnapshot r0 = r19;
        if ((r22 instanceof ProactiveAgentRepository$loadWindowRecommendations$1) == false) goto L7;
        ProactiveAgentRepository$loadWindowRecommendations$1 r2 = (ProactiveAgentRepository$loadWindowRecommendations$1) r22;
        int r3 = r2.label;
        if ((r3 & Integer.MIN_VALUE) == 0) goto L7;
        r2.label = r3 - Integer.MIN_VALUE;
    L8:
        Object r1 = r2.result;
        Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r2.label;
        if (r5 == 0) goto L14;
        if (r5 != 1) goto L13;
        int r6 = r2.I$0;
        List r7 = (List) r2.L$3;
        h5 r8 = (h5) r2.L$2;
        g5 r9 = (g5) r2.L$1;
        ProactiveAllPageSnapshot r10 = (ProactiveAllPageSnapshot) r2.L$0;
        ResultKt.throwOnFailure(r1);
        List r11 = r7;
        int r12 = r6;
        r0 = r10;
        ProactiveAgentRepository$loadWindowRecommendations$1 r13 = r2;
        h5 r14 = r8;
        Object r15 = r4;
    L23:
        ProactiveDayPageResult r16 = (ProactiveDayPageResult) r1;
        long r17 = r16.a;
        if (r17 != 0) goto L26;
    L28:
        CollectionsKt.addAll(r11, r16.d);
        r12 = r12 + r16.d.size();
        if (r16.c == false) goto L34;
        if ((!r16.d.isEmpty()) == false) goto L34;
        boolean r18 = true;
    L35:
        g5 r23 = r9;
        List r24 = r11;
    L15:
        if (r18 == false) goto L37;
        ska.b r110 = ska.b.a;
        long r111 = r0.a;
        long r112 = r14.a;
        long r25 = r14.b;
        r13.L$0 = r0;
        r13.L$1 = r23;
        r13.L$2 = r14;
        r13.L$3 = r24;
        r13.I$0 = r12;
        r13.label = 1;
        r110.getClass();
        String r26 = ska.b.a("loadAiProactiveRecommendationsPage", "requestJson", new JSONObject().put("batchId", r111).put("earliestTimeMillis", r112).put("latestTimeMillis", r25).put("offset", r12).put("limit", 50).toString());
        if (r26 == null) goto L19;
        ProactiveDayPageResult r27 = ska.b.f(r26);
    L20:
        if (r27 != r15) goto L22;
        return r15;
    L22:
        List r113 = r24;
        r9 = r23;
        r1 = r27;
        r11 = r113;
        goto L23
    L19:
        r27 = new ProactiveDayPageResult(r111, "window", false, CollectionsKt.emptyList());
    L37:
        ArrayList r28 = new ArrayList();
        Iterator r29 = r24.iterator();
    L39:
        if (r29.hasNext() == false) goto L48;
        Object r30 = r29.next();
        ProactiveRecommendationDto r31 = (ProactiveRecommendationDto) r30;
        if (m.b(r31) == true) goto L43;
    L45:
        boolean r32 = false;
    L46:
        if (r32 == false) goto L39;
        r28.add(r30);
        goto L39
    L43:
        if (m.a(r23, r31.j) == false) goto L45;
        r32 = true;
        goto L46
    L48:
        HashSet r33 = new HashSet();
        ArrayList r34 = new ArrayList();
        Iterator r35 = r28.iterator();
    L50:
        if (r35.hasNext() == false) goto L54;
        Object r36 = r35.next();
        if (r33.add(m.e((ProactiveRecommendationDto) r36)) == false) goto L50;
        r34.add(r36);
        goto L50
    L54:
        return r34;
    L34:
        r18 = false;
        goto L35
    L26:
        if (r17 == r0.a) goto L28;
        r23 = r9;
        r24 = r11;
        goto L37
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r1);
        List r37 = CollectionsKt.toMutableList(r0.c);
        r12 = r37.size();
        r24 = r37;
        r18 = r0.d;
        r23 = r20;
        r15 = r4;
        r13 = r2;
        r14 = r21;
    L7:
        r2 = new ProactiveAgentRepository$loadWindowRecommendations$1(this, r22);
        goto L8
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:66:0x0167 -> B:67:0x016f). Please report as a decompilation issue!!! */
    public static final Object a(ProactiveAgentRepository r21, ProactiveAllPageSnapshot r22, g5 r23, h5 r24, boolean r25, Continuation r26) {
        ProactiveAllPageSnapshot r1 = r22;
        r21.getClass();
        if ((r26 instanceof ProactiveAgentRepository$loadRecommendations$1) == false) goto L7;
        ProactiveAgentRepository$loadRecommendations$1 r4 = (ProactiveAgentRepository$loadRecommendations$1) r26;
        int r5 = r4.label;
        if ((r5 & Integer.MIN_VALUE) == 0) goto L7;
        r4.label = r5 - Integer.MIN_VALUE;
    L8:
        Object r3 = r4.result;
        Object r6 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r7 = r4.label;
        if (r7 == 0) goto L18;
        if (r7 == 1) goto L17;
        if (r7 == 2) goto L16;
        if (r7 != 3) goto L15;
        Iterator r2 = (Iterator) r4.L$4;
        LinkedHashMap r8 = (LinkedHashMap) r4.L$3;
        String r9 = (String) r4.L$2;
        g5 r11 = (g5) r4.L$1;
        ProactiveAllPageSnapshot r12 = (ProactiveAllPageSnapshot) r4.L$0;
        ResultKt.throwOnFailure(r3);
    L67:
        List r10 = (List) r3;
    L62:
        String r20 = r9;
        Iterator r13 = r2;
        r1 = r12;
        String r14 = r20;
        ArrayList r15 = new ArrayList();
        Iterator r16 = r10.iterator();
    L70:
        if (r16.hasNext() == false) goto L79;
        Object r17 = r16.next();
        ProactiveRecommendationDto r18 = (ProactiveRecommendationDto) r17;
        if (m.b(r18) == true) goto L74;
    L76:
        boolean r19 = false;
    L77:
        if (r19 == false) goto L70;
        r15.add(r17);
        goto L70
    L74:
        if (m.a(r11, r18.j) == false) goto L76;
        r19 = true;
        goto L77
    L79:
        Iterator r27 = r15.iterator();
    L81:
        if (r27.hasNext() == false) goto L83;
        ProactiveRecommendationDto r28 = (ProactiveRecommendationDto) r27.next();
        r8.put(m.e(r28), r28);
        goto L81
    L83:
        g5 r29 = r11;
    L54:
        if (r13.hasNext() == false) goto L85;
        ProactiveDayHeaderDto r30 = (ProactiveDayHeaderDto) r13.next();
        if (Intrinsics.areEqual(r30.a, r14) == false) goto L63;
        r4.L$0 = r1;
        r4.L$1 = r29;
        r4.L$2 = r14;
        r4.L$3 = r8;
        r4.L$4 = r13;
        r4.label = 2;
        Object r31 = r21.e(r1, r30, r4);
        if (r31 == r6) goto L100;
        r11 = r29;
        String r210 = r14;
        r12 = r1;
        r2 = r13;
        r9 = r210;
        r10 = (List) r31;
        goto L62
    L100:
        return r6;
    L63:
        long r32 = r1.a;
        String r33 = r30.a;
        r4.L$0 = r1;
        r4.L$1 = r29;
        r4.L$2 = r14;
        r4.L$3 = r8;
        r4.L$4 = r13;
        r4.label = 3;
        Object r34 = r21.c(r32, r33, r4);
        if (r34 == r6) goto L101;
        r11 = r29;
        r3 = r34;
        String r211 = r14;
        r12 = r1;
        r2 = r13;
        r9 = r211;
        goto L67
    L101:
        return r6;
    L85:
        return CollectionsKt.toList(r8.values());
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        r2 = (Iterator) r4.L$4;
        r8 = (LinkedHashMap) r4.L$3;
        r9 = (String) r4.L$2;
        r11 = (g5) r4.L$1;
        r12 = (ProactiveAllPageSnapshot) r4.L$0;
        ResultKt.throwOnFailure(r3);
        r10 = (List) r3;
        goto L62
    L17:
        ResultKt.throwOnFailure(r3);
    L98:
        return r3;
    L18:
        ResultKt.throwOnFailure(r3);
        if (r25 == false) goto L24;
        r4.label = 1;
        r3 = r21.f(r1, r23, r24, r4);
        if (r3 != r6) goto L98;
        return r6;
    L24:
        r29 = r23;
        Iterator r35 = r1.b.iterator();
        r14 = null;
        if (r35.hasNext() == true) goto L27;
        Object r110 = null;
    L37:
        ProactiveDayHeaderDto r111 = (ProactiveDayHeaderDto) r110;
        if (r111 == null) goto L40;
        r14 = r111.a;
    L40:
        List r36 = r1.b;
        ArrayList r37 = new ArrayList();
        Iterator r38 = r36.iterator();
    L42:
        if (r38.hasNext() == false) goto L52;
        Object r112 = r38.next();
        long r113 = ((ProactiveDayHeaderDto) r112).b;
        if (((r113 + 86400000) - 1) >= r24.a) goto L46;
    L48:
        boolean r39 = false;
    L49:
        if (r39 == false) goto L42;
        r37.add(r112);
        goto L42
    L46:
        if (r113 > r24.b) goto L48;
        r39 = true;
        goto L49
    L52:
        r8 = new LinkedHashMap();
        r13 = r37.iterator();
        goto L54
    L27:
        r110 = r35.next();
        if (r35.hasNext() == false) goto L37;
        long r114 = ((ProactiveDayHeaderDto) r110).b;
    L31:
        Object r115 = r35.next();
        Object r212 = r110;
        long r116 = ((ProactiveDayHeaderDto) r115).b;
        if (r114 >= r116) goto L34;
        r114 = r116;
        r110 = r115;
    L36:
        if (r35.hasNext() == true) goto L31;
    L34:
        r110 = r212;
    L7:
        r4 = new ProactiveAgentRepository$loadRecommendations$1(r21, r26);
        goto L8
    }
}
