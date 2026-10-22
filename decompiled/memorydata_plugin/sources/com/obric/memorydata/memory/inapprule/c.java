package com.obric.memorydata.memory.inapprule;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.capabilitykit.common.Ext;
import com.obric.memorydata.database.dao.InAppL1RuleDao;
import com.obric.memorydata.database.entity.ca;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.obric.memorydata.database.manager.MemoryFrameDb;
import com.obric.memorydata.memory.g;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0006\u001a\u00020\u0005J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0005J\u0006\u0010\n\u001a\u00020\bJ\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\rH\u0002J\u000e\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010\u000f\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\rJD\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0018\u0010\u0015\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00160\u0011H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/obric/memorydata/memory/inapprule/InAppRuleStore;", "", "<init>", "()V", "activeRun", "", "beginRun", "endRun", "", "runId", "invalidateRun", "checkRun", Ext.KEY_REQUEST, "Lorg/json/JSONObject;", "snapshot", "apply", "merge", "", "Lcom/obric/memorydata/database/entity/InAppL1RuleEntity;", "previous", "additions", "deletions", "Lkotlin/Pair;", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f10152a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static String f10153b;

    static {
        f10152a = new c();
    }

    private c() {
    }

    private final List<ca> a(List<ca> r5, List<ca> r6, List<Pair<String, String>> r7) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        List r9 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin");
        Iterable r10 = (Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.memorydata.plugin");
        Map r11 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r10, 10)), 16)), Map.class, "com.obric.memorydata.plugin");
        Iterator r12 = r10.iterator();
    L4:
        if (r12.hasNext() == false) goto L6;
        Object r1 = r12.next();
        ca r2 = (ca) ZeusTransformUtils.preCheckCast(r1, ca.class, "com.obric.memorydata.plugin");
        r11.put(TuplesKt.to(r2.a(), r2.b()), r1);
        goto L4
    L6:
        Map r13 = MapsKt.toMutableMap(r11);
        Iterator r14 = ((Iterable) ZeusTransformUtils.preCheckCast(r9, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L8:
        if (r14.hasNext() == false) goto L10;
        r13.remove((Pair) ZeusTransformUtils.preCheckCast(r14.next(), Pair.class, "com.obric.memorydata.plugin"));
        goto L8
    L10:
        Iterator r15 = ((Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L12:
        if (r15.hasNext() == false) goto L15;
        ca r16 = (ca) ZeusTransformUtils.preCheckCast(r15.next(), ca.class, "com.obric.memorydata.plugin");
        r13.put(TuplesKt.to(r16.a(), r16.b()), r16);
        goto L12
    L15:
        return CollectionsKt.toList((Iterable) ZeusTransformUtils.preCheckCast(r13.values(), Iterable.class, "com.obric.memorydata.plugin"));
    }

    /* JADX WARN: Type inference failed for: r11v15, types: [T, java.lang.Object, org.json.JSONObject] */
    private static final void a(MemoryFrameDb r11, JSONObject r12, List r13, List r14, Ref.ObjectRef r15) {
        List<ca> r16 = (List) ZeusTransformUtils.wrapperContextForParams(r13, List.class, "com.obric.memorydata.plugin");
        List<Pair<String, String>> r17 = (List) ZeusTransformUtils.wrapperContextForParams(r14, List.class, "com.obric.memorydata.plugin");
        List<ca> r0 = r11.getInAppL1RuleDao().readAll();
        if (Intrinsics.areEqual(a.f10149a.a(r0), r12.getString("baseDigest")) == false) goto L108;
        List<ca> r2 = f10152a.a(r0, r16, r17);
        int r5 = 0;
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r2, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L7;
    L10:
        boolean r3 = true;
    L12:
        if (r3 == false) goto L106;
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r2, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L16;
        g.f10124a.a(a.f10149a.b(r2));
    L16:
        String r4 = a.f10149a.a(r2);
        if (Intrinsics.areEqual(r4, r12.getString("targetDigest")) == false) goto L104;
        Iterable r18 = (Iterable) ZeusTransformUtils.preCheckCast(r16, Iterable.class, "com.obric.memorydata.plugin");
        Collection r19 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r110 = r18.iterator();
    L20:
        if (r110.hasNext() == false) goto L41;
        Object r6 = r110.next();
        ca r7 = (ca) ZeusTransformUtils.preCheckCast(r6, ca.class, "com.obric.memorydata.plugin");
        Iterable r8 = (Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r8, Collection.class) == true) goto L24;
    L26:
        Iterator r9 = r8.iterator();
    L28:
        if (r9.hasNext() == false) goto L25;
        ca r10 = (ca) ZeusTransformUtils.preCheckCast(r9.next(), ca.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(r10.a(), r7.a()) == true) goto L32;
    L36:
        boolean r20 = false;
    L37:
        if (r20 == false) goto L28;
        boolean r21 = false;
    L39:
        if (r21 == false) goto L20;
        r19.add(r6);
        goto L20
    L32:
        if (Intrinsics.areEqual(r10.b(), r7.b()) == false) goto L36;
        if (Intrinsics.areEqual(r10.d(), r7.d()) == false) goto L36;
        r20 = true;
    L25:
        r21 = true;
        goto L39
    L24:
        if (((Collection) ZeusTransformUtils.preCheckCast(r8, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L26;
    L41:
        List<ca> r111 = (List) ZeusTransformUtils.preCheckCast(r19, List.class, "com.obric.memorydata.plugin");
        Iterable r112 = (Iterable) ZeusTransformUtils.preCheckCast(r17, Iterable.class, "com.obric.memorydata.plugin");
        Collection r113 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r114 = r112.iterator();
    L43:
        if (r114.hasNext() == false) goto L62;
        Object r22 = r114.next();
        Pair r23 = (Pair) ZeusTransformUtils.preCheckCast(r22, Pair.class, "com.obric.memorydata.plugin");
        Iterable r24 = (Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r24, Collection.class) == true) goto L47;
    L49:
        Iterator r25 = r24.iterator();
    L51:
        if (r25.hasNext() == false) goto L48;
        ca r26 = (ca) ZeusTransformUtils.preCheckCast(r25.next(), ca.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(r26.a(), r23.getFirst()) == true) goto L55;
    L57:
        boolean r27 = false;
    L58:
        if (r27 == false) goto L51;
        boolean r28 = true;
    L60:
        if (r28 == false) goto L43;
        r113.add(r22);
        goto L43
    L55:
        if (Intrinsics.areEqual(r26.b(), r23.getSecond()) == false) goto L57;
        r27 = true;
    L48:
        r28 = false;
        goto L60
    L47:
        if (((Collection) ZeusTransformUtils.preCheckCast(r24, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L49;
    L62:
        List r115 = (List) ZeusTransformUtils.preCheckCast(r113, List.class, "com.obric.memorydata.plugin");
        Iterator r116 = ((Iterable) ZeusTransformUtils.preCheckCast(r115, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L64:
        if (r116.hasNext() == false) goto L66;
        Pair r29 = (Pair) ZeusTransformUtils.preCheckCast(r116.next(), Pair.class, "com.obric.memorydata.plugin");
        InAppL1RuleDao r30 = r11.getInAppL1RuleDao();
        Object r31 = r29.getFirst();
        Intrinsics.checkNotNullExpressionValue(r31, "<get-first>(...)");
        String r32 = (String) ZeusTransformUtils.preCheckCast(r31, String.class, "com.obric.memorydata.plugin");
        Object r33 = r29.getSecond();
        Intrinsics.checkNotNullExpressionValue(r33, "<get-second>(...)");
        r30.remove(r32, (String) ZeusTransformUtils.preCheckCast(r33, String.class, "com.obric.memorydata.plugin"));
        goto L64
    L66:
        r11.getInAppL1RuleDao().upsert(r111);
        Iterable r117 = (Iterable) ZeusTransformUtils.preCheckCast(r111, Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r117, Collection.class) == true) goto L69;
    L71:
        Iterator r118 = r117.iterator();
        int r119 = 0;
    L73:
        if (r118.hasNext() == false) goto L94;
        ca r34 = (ca) ZeusTransformUtils.preCheckCast(r118.next(), ca.class, "com.obric.memorydata.plugin");
        Iterable r35 = (Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r35, Collection.class) == true) goto L77;
    L79:
        Iterator r36 = r35.iterator();
    L81:
        if (r36.hasNext() == false) goto L78;
        ca r37 = (ca) ZeusTransformUtils.preCheckCast(r36.next(), ca.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(r37.a(), r34.a()) == true) goto L85;
    L87:
        boolean r38 = false;
    L88:
        if (r38 == false) goto L81;
        boolean r39 = false;
    L90:
        if (r39 == false) goto L73;
        r119 = r119 + 1;
        if (r119 >= 0) goto L73;
        CollectionsKt.throwCountOverflow();
        goto L73
    L85:
        if (Intrinsics.areEqual(r37.b(), r34.b()) == false) goto L87;
        r38 = true;
    L78:
        r39 = true;
        goto L90
    L77:
        if (((Collection) ZeusTransformUtils.preCheckCast(r35, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L79;
    L94:
        r5 = r119;
    L95:
        JSONObject r120 = new JSONObject();
        if (r111.isEmpty() == true) goto L98;
    L100:
        String r121 = "APPLIED";
    L101:
        ?? r122 = r120.put("status", r121).put("dbDigest", r4).put("inserted", r5).put("updated", r111.size() - r5).put("removed", r115.size()).put("registration", "pending");
        Intrinsics.checkNotNullExpressionValue(r122, "put(...)");
        r15.element = r122;
        return;
    L98:
        if (r115.isEmpty() == false) goto L100;
        r121 = "UNCHANGED";
        goto L101
    L69:
        if (((Collection) ZeusTransformUtils.preCheckCast(r117, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L71;
    L104:
        throw new IllegalArgumentException("INVALID_CATALOG".toString());
    L106:
        throw new IllegalArgumentException("INVALID_CATALOG".toString());
    L7:
        if (r12.optBoolean("allowEmpty", false) == true) goto L10;
        r3 = false;
        goto L12
    L108:
        throw new IllegalArgumentException("BASE_CHANGED".toString());
    }

    private final void c(JSONObject r3) {
        boolean r0 = false;
        if (r3.getInt("schemaVersion") != 1) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == false) goto L17;
        if (f10153b != null) goto L10;
    L12:
        if (r0 == false) goto L15;
        return;
    L15:
        throw new IllegalArgumentException("STALE_RUN".toString());
    L10:
        if (Intrinsics.areEqual(r3.getString("runId"), f10153b) == false) goto L12;
        r0 = true;
        goto L12
    L17:
        throw new IllegalArgumentException("UNSUPPORTED_SCHEMA".toString());
    L5:
        r2 = false;
        goto L6
    }

    public static /* synthetic */ void lambda$8snjcY6XQMetVQEz9Aa7fNIMrKI(MemoryFrameDb r0, JSONObject r1, List r2, List r3, Ref.ObjectRef r4) {
        a(r0, r1, r2, r3, r4);
    }

    public final synchronized String a() {
        monitor-enter(this);
        String r0 = UUID.randomUUID().toString();     // Catch: Throwable -> L6
        Intrinsics.checkNotNullExpressionValue(r0, "toString(...)");     // Catch: Throwable -> L6
        f10153b = r0;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized JSONObject a(JSONObject r12) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r12, Ext.KEY_REQUEST);     // Catch: Throwable -> L43
        c(r12);     // Catch: Throwable -> L43
        List<ca> r0 = MemoryDbEngine.INSTANCE.getGlobalDbEngine().getInAppL1RuleDao().readAll();     // Catch: Throwable -> L43
        String r1 = a.f10149a.a(r0);     // Catch: Throwable -> L43
        JSONObject r2 = r12.optJSONObject("cursor");     // Catch: Throwable -> L43
        boolean r3 = true;
        if (r2 != null) goto L6;
    L9:
        boolean r5 = true;
    L10:
        if (r5 == false) goto L42;
        if (r2 == null) goto L13;
        int r4 = r2.getInt(TypedValues.CycleType.S_WAVE_OFFSET);     // Catch: Throwable -> L43
    L14:
        if (r4 >= 0) goto L16;
    L18:
        boolean r6 = false;
    L19:
        if (r6 == false) goto L40;
        int r13 = r12.optInt("pageSize", 100);     // Catch: Throwable -> L43
        if (1 <= r13) goto L23;
    L25:
        r3 = false;
    L26:
        if (r3 == false) goto L38;
        List r14 = CollectionsKt.take((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.drop((Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin"), r4), Iterable.class, "com.obric.memorydata.plugin"), r13);     // Catch: Throwable -> L43
        JSONObject r7 = new JSONObject().put("baseDigest", r1);     // Catch: Throwable -> L43
        JSONArray r8 = new JSONArray();     // Catch: Throwable -> L43
        Iterator r9 = ((Iterable) ZeusTransformUtils.preCheckCast(r14, Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Throwable -> L43
    L29:
        if (r9.hasNext() == false) goto L31;
        ca r10 = (ca) ZeusTransformUtils.preCheckCast(r9.next(), ca.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L43
        r8.put(new JSONObject().put(ObricMemoryConstants.KEY_PACKAGE_NAME, r10.a()).put("ruleId", r10.b()).put("ruleVersion", r10.d()));     // Catch: Throwable -> L43
        goto L29
    L31:
        Unit r11 = Unit.INSTANCE;     // Catch: Throwable -> L43
        JSONObject r15 = r7.put("rows", r8);     // Catch: Throwable -> L43
        if ((r14.size() + r4) >= r0.size()) goto L34;
        r15.put("nextCursor", new JSONObject().put("digest", r1).put(TypedValues.CycleType.S_WAVE_OFFSET, r4 + r14.size()));     // Catch: Throwable -> L43
    L34:
        Intrinsics.checkNotNullExpressionValue(r15, "apply(...)");     // Catch: Throwable -> L43
        monitor-exit(this);
        return r15;
    L38:
        throw new IllegalArgumentException("Failed requirement.".toString());     // Catch: Throwable -> L43
    L23:
        if (r13 >= 101) goto L25;
    L40:
        throw new IllegalArgumentException("Failed requirement.".toString());     // Catch: Throwable -> L43
    L16:
        if (r4 > r0.size()) goto L18;
        r6 = true;
        goto L19
    L13:
        r4 = 0;
        goto L14
    L42:
        throw new IllegalArgumentException("BASE_CHANGED".toString());     // Catch: Throwable -> L43
    L6:
        if (Intrinsics.areEqual(r2.getString("digest"), r1) == true) goto L9;
        r5 = false;
    L43:
        th = move-exception;
        throw th;
    }

    public final synchronized void a(String r2) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r2, "runId");     // Catch: Throwable -> L8
        if (Intrinsics.areEqual(f10153b, r2) == false) goto L6;
        f10153b = null;     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    /* JADX WARN: Type inference failed for: r2v21, types: [T, org.json.JSONObject] */
    public final synchronized JSONObject b(final JSONObject r14) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r14, Ext.KEY_REQUEST);     // Catch: Throwable -> L32
        c(r14);     // Catch: Throwable -> L32
        JSONArray r0 = r14.getJSONArray("upserts");     // Catch: Throwable -> L32
        JSONArray r1 = r14.getJSONArray("removes");     // Catch: Throwable -> L32
        boolean r4 = true;
        if ((r0.length() + r1.length()) > 1000) goto L6;
        boolean r2 = true;
    L7:
        if (r2 == false) goto L31;
        Iterable r3 = (Iterable) ZeusTransformUtils.preCheckCast(RangesKt.until(0, r0.length()), Iterable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L32
        Collection r5 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r3, 10)), Collection.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L32
        Iterator r6 = r3.iterator();     // Catch: Throwable -> L32
    L10:
        if (r6.hasNext() == false) goto L12;
        int r7 = ((IntIterator) ZeusTransformUtils.preCheckCast(r6, IntIterator.class, "com.obric.memorydata.plugin")).nextInt();     // Catch: Throwable -> L32
        a r8 = a.f10149a;     // Catch: Throwable -> L32
        JSONObject r9 = r0.getJSONObject(r7);     // Catch: Throwable -> L32
        Intrinsics.checkNotNullExpressionValue(r9, "getJSONObject(...)");     // Catch: Throwable -> L32
        r5.add(r8.a(r9));     // Catch: Throwable -> L32
        goto L10
    L12:
        final List r10 = (List) ZeusTransformUtils.preCheckCast(r5, List.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L32
        Iterable r11 = (Iterable) ZeusTransformUtils.preCheckCast(RangesKt.until(0, r1.length()), Iterable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L32
        Collection r12 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r11, 10)), Collection.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L32
        Iterator r13 = r11.iterator();     // Catch: Throwable -> L32
    L14:
        if (r13.hasNext() == false) goto L16;
        JSONObject r15 = r1.getJSONObject(((IntIterator) ZeusTransformUtils.preCheckCast(r13, IntIterator.class, "com.obric.memorydata.plugin")).nextInt());     // Catch: Throwable -> L32
        r12.add(TuplesKt.to(r15.getString(ObricMemoryConstants.KEY_PACKAGE_NAME), r15.getString("ruleId")));     // Catch: Throwable -> L32
        goto L14
    L16:
        final List r16 = (List) ZeusTransformUtils.preCheckCast(r12, List.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L32
        Iterable r17 = (Iterable) ZeusTransformUtils.preCheckCast(r10, Iterable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L32
        Collection r18 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r17, 10)), Collection.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L32
        Iterator r19 = r17.iterator();     // Catch: Throwable -> L32
    L18:
        if (r19.hasNext() == false) goto L20;
        ca r20 = (ca) ZeusTransformUtils.preCheckCast(r19.next(), ca.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L32
        r18.add(TuplesKt.to(r20.a(), r20.b()));     // Catch: Throwable -> L32
        goto L18
    L20:
        List r21 = CollectionsKt.plus((Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r18, List.class, "com.obric.memorydata.plugin"), Collection.class, "com.obric.memorydata.plugin"), (Iterable) ZeusTransformUtils.preCheckCast(r16, Iterable.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L32
        if (CollectionsKt.distinct((Iterable) ZeusTransformUtils.preCheckCast(r21, Iterable.class, "com.obric.memorydata.plugin")).size() == r21.size()) goto L24;
        r4 = false;
    L24:
        if (r4 == false) goto L29;
        final MemoryFrameDb r22 = MemoryDbEngine.INSTANCE.getGlobalDbEngine();     // Catch: Throwable -> L32
        final Ref.ObjectRef r23 = new Ref.ObjectRef();     // Catch: Throwable -> L32
        r23.element = new JSONObject();     // Catch: Throwable -> L32
        r22.runInTransaction(new $$Lambda$c$8snjcY6XQMetVQEz9Aa7fNIMrKI(r22, r14, r10, r16, r23));     // Catch: Throwable -> L32
        b.f10150a.c();     // Catch: Throwable -> L32
        JSONObject r110 = (JSONObject) ZeusTransformUtils.preCheckCast(r23.element, JSONObject.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L32
        monitor-exit(this);
        return r110;
    L29:
        throw new IllegalArgumentException("INVALID_CATALOG".toString());     // Catch: Throwable -> L32
    L31:
        throw new IllegalArgumentException("TOO_LARGE".toString());     // Catch: Throwable -> L32
    L6:
        r2 = false;
    L32:
        th = move-exception;
        throw th;
    }

    public final synchronized void b() {
        monitor-enter(this);
        f10153b = null;     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
