package com.obric.memorydata.union.build.storage;

import com.obric.memorydata.database.dao.MemoryProcessSourceEventDao;
import com.obric.memorydata.database.dao.MemoryProcessTriggerStateDao;
import com.obric.memorydata.database.entity.cy;
import com.obric.memorydata.database.entity.cz;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.obric.memorydata.database.manager.MemoryFrameDb;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/obric/memorydata/union/build/storage/MemoryProcessSourceCommitManager;", "", "<init>", "()V", "MAX_SOURCE_EVENTS", "", "supersede", "payload", "", "memory_build_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f13116a = null;

    static {
        f13116a = new c();
    }

    private c() {
    }

    private static final Integer a(MemoryFrameDb r27, List r28) {
        List<String> r0 = (List) ZeusTransformUtils.wrapperContextForParams(r28, List.class, "com.obric.memorydata.plugin");
        MemoryProcessSourceEventDao r2 = r27.getMemoryProcessSourceEventDao();
        MemoryProcessTriggerStateDao r3 = r27.getMemoryProcessTriggerStateDao();
        Iterable r1 = (Iterable) ZeusTransformUtils.preCheckCast(r2.queryByEventIds(r0), Iterable.class, "com.obric.memorydata.plugin");
        Collection r4 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r5 = r1.iterator();
    L4:
        if (r5.hasNext() == false) goto L8;
        Object r6 = r5.next();
        if (Intrinsics.areEqual(((cy) ZeusTransformUtils.preCheckCast(r6, cy.class, "com.obric.memorydata.plugin")).k(), "PENDING") == false) goto L4;
        r4.add(r6);
        goto L4
    L8:
        List r7 = (List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.memorydata.plugin");
        if (r7.isEmpty() == true) goto L11;
        long r14 = System.currentTimeMillis();
        Iterable r8 = (Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.memorydata.plugin");
        Collection r9 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r8, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r10 = r8.iterator();
    L14:
        if (r10.hasNext() == false) goto L16;
        r9.add(((cy) ZeusTransformUtils.preCheckCast(r10.next(), cy.class, "com.obric.memorydata.plugin")).a());
        goto L14
    L16:
        int r11 = r2.updateState((List) ZeusTransformUtils.preCheckCast(r9, List.class, "com.obric.memorydata.plugin"), "SUPERSEDED", r14);
        int r12 = 1;
        if (r11 != r7.size()) goto L19;
        boolean r13 = true;
    L20:
        if (r13 == false) goto L49;
        Iterable r15 = (Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.memorydata.plugin");
        Map r16 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        Iterator r17 = r15.iterator();
    L23:
        if (r17.hasNext() == false) goto L28;
        Object r18 = r17.next();
        cy r19 = (cy) ZeusTransformUtils.preCheckCast(r18, cy.class, "com.obric.memorydata.plugin");
        Triple r20 = new Triple(r19.c(), r19.h(), r19.d());
        Object r21 = r16.get(r20);
        if (r21 != null) goto L27;
        r21 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        r16.put(r20, r21);
    L27:
        ((List) ZeusTransformUtils.preCheckCast(r21, List.class, "com.obric.memorydata.plugin")).add(r18);
        goto L23
    L28:
        Iterator r22 = r16.entrySet().iterator();
    L30:
        if (r22.hasNext() == false) goto L47;
        Triple r23 = (Triple) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r22.next(), Map.Entry.class, "com.obric.memorydata.plugin")).getKey(), Triple.class, "com.obric.memorydata.plugin");
        cz r24 = r3.queryByGroup((String) ZeusTransformUtils.preCheckCast(r23.getFirst(), String.class, "com.obric.memorydata.plugin"), (String) ZeusTransformUtils.preCheckCast(r23.getSecond(), String.class, "com.obric.memorydata.plugin"), (String) ZeusTransformUtils.preCheckCast(r23.getThird(), String.class, "com.obric.memorydata.plugin"));
        if (r24 != null) goto L34;
        int r25 = r12;
        long r26 = r14;
    L43:
        r12 = r25;
        r14 = r26;
        goto L30
    L34:
        int r110 = r3.countPendingSources((String) ZeusTransformUtils.preCheckCast(r23.getFirst(), String.class, "com.obric.memorydata.plugin"), (String) ZeusTransformUtils.preCheckCast(r23.getSecond(), String.class, "com.obric.memorydata.plugin"), (String) ZeusTransformUtils.preCheckCast(r23.getThird(), String.class, "com.obric.memorydata.plugin"));
        if (r110 != 0) goto L37;
        String r29 = "DONE";
    L38:
        r26 = r14;
        r25 = r12;
        if (r3.update(cz.a(r24, null, null, null, null, r29, 0, 0, 0, null, r110, null, r26, 1519, null)) != r25) goto L41;
        int r111 = r25;
    L42:
        if (r111 != 0) goto L43;
        throw new IllegalStateException("trigger state update failed".toString());
    L41:
        r111 = 0;
        goto L42
    L37:
        r29 = "DIRTY";
        goto L38
    L47:
        return Integer.valueOf(r11);
    L49:
        throw new IllegalStateException("source supersede update incomplete".toString());
    L19:
        r13 = false;
        goto L20
    L11:
        return 0;
    }

    public static /* synthetic */ Integer lambda$sZStpvliUS5evTqtpmb_AgNse4U(MemoryFrameDb r0, List r1) {
        return a(r0, r1);
    }

    public final int a(String r8) {
        Intrinsics.checkNotNullParameter(r8, "payload");
        boolean r1 = true;
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L31;
        JSONArray r7 = new JSONObject(r8).optJSONArray("event_ids");
        List r9 = CollectionsKt.createListBuilder();
        if (r7 == null) goto L18;
        int r3 = r7.length();
        int r4 = 0;
    L7:
        if (r4 >= r3) goto L18;
        String r5 = r7.optString(r4);
        Intrinsics.checkNotNullExpressionValue(r5, "optString(...)");
        String r6 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin")).toString();
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L11;
        boolean r10 = true;
    L12:
        if (r10 == true) goto L15;
        r6 = null;
    L15:
        if (r6 == null) goto L17;
        r9.add(r6);
    L17:
        r4 = r4 + 1;
        goto L7
    L11:
        r10 = false;
    L18:
        final List r11 = CollectionsKt.distinct((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.build(r9), Iterable.class, "com.obric.memorydata.plugin"));
        if (r11.size() <= 500) goto L22;
        r1 = false;
    L22:
        if (r1 == false) goto L29;
        if (r11.isEmpty() == false) goto L26;
        return 0;
    L26:
        final MemoryFrameDb r12 = MemoryDbEngine.INSTANCE.getGlobalDbEngine();
        return ((Number) ZeusTransformUtils.preCheckCast(r12.runInTransaction(new $$Lambda$c$sZStpvliUS5evTqtpmb_AgNse4U(r12, r11)), Number.class, "com.obric.memorydata.plugin")).intValue();
    L29:
        throw new IllegalArgumentException("too many source events".toString());
    L31:
        throw new IllegalArgumentException("supersede payload is blank".toString());
    }
}
