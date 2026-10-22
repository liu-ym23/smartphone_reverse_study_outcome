package com.obric.memorydata.database.util.file_utils;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.obric.aikernel.sdk.ext.Params;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\b\t\n\u0002\u0010$\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u001dB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u0007J0\u0010\u000e\u001a\u0014\u0012\u0004\u0012\u00020\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00110\u000f2\u0006\u0010\u000b\u001a\u00020\f2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00100\tH\u0002J&\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u00102\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00070\u0011H\u0002J\u001e\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\f2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00100\tH\u0002J@\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u00102\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00100\u001b2\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u001bH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/obric/memorydata/database/util/file_utils/PassageGenerator;", "", "<init>", "()V", "TAG", "", "PASSAGE_MAX_LENGTH", "", "processDocTreeToPassages", "", "Lcom/obric/memorydata/database/util/file_utils/PassageGenerator$PassageMaterial;", "docTree", "Lcom/obric/memorydata/database/util/file_utils/DocumentTree;", "passageMaxLength", "findSubtreeScope", "Lkotlin/Pair;", "Lcom/obric/memorydata/database/util/file_utils/DocNode;", "", "nodes", "buildPartialSubtree", "root", "includedIds", "findLCA", "findPairLCA", "a", "b", "parentMap", "", "depthMap", "PassageMaterial", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final s f9665a = null;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/obric/memorydata/database/util/file_utils/PassageGenerator$PassageMaterial;", "", Params.CONTENT, "", "passageDocNodeTreeJson", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getContent", "()Ljava/lang/String;", "getPassageDocNodeTreeJson", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f9666a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f9667b;

        public a(String r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, Params.CONTENT);
            Intrinsics.checkNotNullParameter(r3, "passageDocNodeTreeJson");
            this.f9666a = r2;
            this.f9667b = r3;
        }

        public final String a() {
            return this.f9666a;
        }

        public final String b() {
            return this.f9667b;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f9666a, r6.f9666a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f9667b, r6.f9667b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.f9666a.hashCode() * 31) + this.f9667b.hashCode();
        }

        public String toString() {
            return "PassageMaterial(content=" + this.f9666a + ", passageDocNodeTreeJson=" + this.f9667b + ')';
        }
    }

    static {
        f9665a = new s();
    }

    private s() {
    }

    private static final JsonObject a(Set<Integer> r5, j r6, h r7) {
        Set r8 = (Set) ZeusTransformUtils.wrapperContextForParams(r5, Set.class, "com.obric.memorydata.plugin");
        if (r8.contains(Integer.valueOf(r7.a())) == true) goto L6;
        return null;
    L6:
        JsonObject r0 = new JsonObject();
        r0.addProperty("i", (Number) ZeusTransformUtils.preCheckCast(Integer.valueOf(r7.a()), Number.class, "com.obric.memorydata.plugin"));
        r0.addProperty("l", (Number) ZeusTransformUtils.preCheckCast(Integer.valueOf(r7.f()), Number.class, "com.obric.memorydata.plugin"));
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r7.e(), Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L21;
        JsonArray r2 = new JsonArray();
        List r9 = CollectionsKt.toList((Iterable) ZeusTransformUtils.preCheckCast(r7.e(), Iterable.class, "com.obric.memorydata.plugin"));     // Catch: ConcurrentModificationException -> L11
    L12:
        Iterator r10 = ((Iterable) ZeusTransformUtils.preCheckCast(r9, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L14:
        if (r10.hasNext() == false) goto L20;
        h r3 = r6.a(((Number) ZeusTransformUtils.preCheckCast(r10.next(), Number.class, "com.obric.memorydata.plugin")).intValue());
        if (r3 == null) goto L14;
        JsonObject r4 = a(r8, r6, r3);
        if (r4 == null) goto L14;
        r2.add((JsonElement) ZeusTransformUtils.preCheckCast(r4, JsonElement.class, "com.obric.memorydata.plugin"));
        goto L14
    L20:
        Unit r11 = Unit.INSTANCE;
        r0.add("c", (JsonElement) ZeusTransformUtils.preCheckCast(r2, JsonElement.class, "com.obric.memorydata.plugin"));
    L11:
        r9 = CollectionsKt.emptyList();
    L21:
        return r0;
    }

    private final h a(h r4, h r5, Map<Integer, h> r6, Map<Integer, Integer> r7) {
        Map r3 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.memorydata.plugin");
        Map r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r7, Map.class, "com.obric.memorydata.plugin");
    L4:
        if (Intrinsics.areEqual(r8.get(Integer.valueOf(r4.a())), r8.get(Integer.valueOf(r5.a()))) == true) goto L10;
        Object r9 = r8.get(Integer.valueOf(r4.a()));
        Intrinsics.checkNotNull(r9);
        int r10 = ((Number) ZeusTransformUtils.preCheckCast(r9, Number.class, "com.obric.memorydata.plugin")).intValue();
        Object r1 = r8.get(Integer.valueOf(r5.a()));
        Intrinsics.checkNotNull(r1);
        if (r10 > ((Number) ZeusTransformUtils.preCheckCast(r1, Number.class, "com.obric.memorydata.plugin")).intValue()) goto L7;
        Object r11 = r3.get(Integer.valueOf(r5.a()));
        Intrinsics.checkNotNull(r11);
        r5 = (h) ZeusTransformUtils.preCheckCast(r11, h.class, "com.obric.memorydata.plugin");
        goto L4
    L7:
        Object r12 = r3.get(Integer.valueOf(r4.a()));
        Intrinsics.checkNotNull(r12);
        r4 = (h) ZeusTransformUtils.preCheckCast(r12, h.class, "com.obric.memorydata.plugin");
    L10:
        if (r4.a() == r5.a()) goto L12;
        Object r13 = r3.get(Integer.valueOf(r4.a()));
        Intrinsics.checkNotNull(r13);
        r4 = (h) ZeusTransformUtils.preCheckCast(r13, h.class, "com.obric.memorydata.plugin");
        Object r14 = r3.get(Integer.valueOf(r5.a()));
        Intrinsics.checkNotNull(r14);
        r5 = (h) ZeusTransformUtils.preCheckCast(r14, h.class, "com.obric.memorydata.plugin");
        goto L10
    L12:
        return r4;
    }

    private static final CharSequence a(h r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        return (CharSequence) ZeusTransformUtils.preCheckCast(r2.c(), CharSequence.class, "com.obric.memorydata.plugin");
    }

    private final String a(j r2, h r3, Set<Integer> r4) {
        JsonObject r1 = a((Set) ZeusTransformUtils.wrapperContextForParams(r4, Set.class, "com.obric.memorydata.plugin"), r2, r3);
        if (r1 == null) goto L6;
        String r5 = r1.toString();
        if (r5 == null) goto L6;
        return r5;
    L6:
        return "{}";
    }

    public static /* synthetic */ List a(s r0, j r1, int r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = 512;
    L6:
        return r0.a(r1, r2);
    }

    private static final List a(Exception r7) {
        Intrinsics.checkNotNullParameter(r7, "it");
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "PassageGenerator", "processDocTreeToPassages failed, error: " + r7, null, 4, null);
        return CollectionsKt.emptyList();
    }

    private final Pair<h, Set<Integer>> a(j r6, List<h> r7) {
        List<h> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin");
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r8, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L18;
        h r5 = b(r6, r8);
        Set r0 = (Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.memorydata.plugin");
        Iterator r9 = ((Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L6:
        if (r9.hasNext() == false) goto L15;
        h r2 = (h) ZeusTransformUtils.preCheckCast(r9.next(), h.class, "com.obric.memorydata.plugin");
    L8:
        if (r2 == null) goto L6;
        if (r2.a() == r5.a()) goto L6;
        r0.add(Integer.valueOf(r2.a()));
        Integer r3 = r2.d();
        if (r3 != null) goto L13;
        r2 = null;
        goto L8
    L13:
        r2 = r6.a(((Number) ZeusTransformUtils.preCheckCast(r3, Number.class, "com.obric.memorydata.plugin")).intValue());
        goto L8
    L15:
        r0.add(Integer.valueOf(r5.a()));
        return TuplesKt.to(r5, r0);
    L18:
        throw new IllegalArgumentException("Nodes list cannot be empty".toString());
    }

    private static final void a(List<h> r3, j r4, h r5) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r5.c(), CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L5;
    L17:
        List r7 = CollectionsKt.toList((Iterable) ZeusTransformUtils.preCheckCast(r5.e(), Iterable.class, "com.obric.memorydata.plugin"));     // Catch: ConcurrentModificationException -> L9
    L10:
        Iterator r8 = ((Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L12:
        if (r8.hasNext() == false) goto L16;
        h r0 = r4.a(((Number) ZeusTransformUtils.preCheckCast(r8.next(), Number.class, "com.obric.memorydata.plugin")).intValue());
        if (r0 == null) goto L12;
        a(r6, r4, r0);
        goto L12
    L16:
        return;
    L9:
        r7 = CollectionsKt.emptyList();
        goto L10
    L5:
        if (r5.getType() == NodeType.VIRTUAL) goto L17;
        r6.add(r5);
        goto L17
    }

    private static final void a(Map<Integer, Integer> r7, j r8, Map<Integer, h> r9, h r10) {
        Map r11 = (Map) ZeusTransformUtils.wrapperContextForParams(r7, Map.class, "com.obric.memorydata.plugin");
        Map r12 = (Map) ZeusTransformUtils.wrapperContextForParams(r9, Map.class, "com.obric.memorydata.plugin");
        ArrayDeque r0 = new ArrayDeque();
        r0.add(r10);
        r11.put(Integer.valueOf(r10.a()), 0);
    L4:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r0, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L15;
        h r13 = (h) ZeusTransformUtils.preCheckCast(r0.removeFirst(), h.class, "com.obric.memorydata.plugin");
        List r2 = CollectionsKt.toList((Iterable) ZeusTransformUtils.preCheckCast(r13.e(), Iterable.class, "com.obric.memorydata.plugin"));     // Catch: ConcurrentModificationException -> L8
    L9:
        Iterator r3 = ((Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L11:
        if (r3.hasNext() == false) goto L4;
        h r4 = r8.a(((Number) ZeusTransformUtils.preCheckCast(r3.next(), Number.class, "com.obric.memorydata.plugin")).intValue());
        if (r4 == null) goto L11;
        r12.put(Integer.valueOf(r4.a()), r13);
        Integer r5 = Integer.valueOf(r4.a());
        Object r6 = r11.get(Integer.valueOf(r13.a()));
        Intrinsics.checkNotNull(r6);
        r11.put(r5, Integer.valueOf(((Number) ZeusTransformUtils.preCheckCast(r6, Number.class, "com.obric.memorydata.plugin")).intValue() + 1));
        r0.add(r4);
    L8:
        r2 = CollectionsKt.emptyList();
        goto L9
    }

    private final h b(j r8, List<h> r9) {
        List r10 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.memorydata.plugin");
        int r2 = 1;
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r10, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L16;
        if (r10.size() == 1) goto L7;
        Map<Integer, h> r0 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        Map<Integer, Integer> r4 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        h r5 = r8.a();
        if (r5 == null) goto L11;
        a(r4, r8, r0, r5);
    L11:
        h r11 = (h) ZeusTransformUtils.preCheckCast(r10.get(0), h.class, "com.obric.memorydata.plugin");
        int r3 = r10.size();
    L12:
        if (r2 >= r3) goto L14;
        r11 = a(r11, (h) ZeusTransformUtils.preCheckCast(r10.get(r2), h.class, "com.obric.memorydata.plugin"), r0, r4);
        r2 = r2 + 1;
        goto L12
    L14:
        return r11;
    L7:
        return (h) ZeusTransformUtils.preCheckCast(r10.get(0), h.class, "com.obric.memorydata.plugin");
    L16:
        throw new IllegalArgumentException("Nodes list cannot be empty".toString());
    }

    private static final List b(j r18, int r19) {
        if (r18.b().size() <= 300000) goto L6;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "PassageGenerator", "节点数量超过最大限制: " + r18.b().size() + " > 300000", null, 4, null);
        return CollectionsKt.emptyList();
    L6:
        List r1 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        List r3 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        h r4 = r18.a();
        if (r4 == null) goto L9;
        a(r3, r18, r4);
    L9:
        List r5 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        r5.add((List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin"));
        Iterator r6 = ((Iterable) ZeusTransformUtils.preCheckCast(r3, Iterable.class, "com.obric.memorydata.plugin")).iterator();
        int r7 = 0;
    L11:
        if (r6.hasNext() == false) goto L18;
        h r8 = (h) ZeusTransformUtils.preCheckCast(r6.next(), h.class, "com.obric.memorydata.plugin");
        if ((r8.f() + r7) <= r19) goto L17;
        if ((!((Collection) ZeusTransformUtils.preCheckCast(CollectionsKt.last(r5), Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L17;
        r5.add((List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin"));
        r7 = 0;
    L17:
        ((List) ZeusTransformUtils.preCheckCast(CollectionsKt.last(r5), List.class, "com.obric.memorydata.plugin")).add(r8);
        r7 = r7 + r8.f();
        goto L11
    L18:
        Iterable r9 = (Iterable) ZeusTransformUtils.preCheckCast(r5, Iterable.class, "com.obric.memorydata.plugin");
        Collection r10 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r11 = r9.iterator();
    L20:
        if (r11.hasNext() == false) goto L24;
        Object r12 = r11.next();
        if ((!((Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r12, List.class, "com.obric.memorydata.plugin"), Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L20;
        r10.add(r12);
        goto L20
    L24:
        Iterator r13 = ((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r10, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L26:
        if (r13.hasNext() == false) goto L28;
        List<h> r14 = (List) ZeusTransformUtils.preCheckCast(r13.next(), List.class, "com.obric.memorydata.plugin");
        s r15 = f9665a;
        Pair<h, Set<Integer>> r16 = r15.a(r18, r14);
        r1.add(new a(CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(r14, Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("\n", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, $$Lambda$s$sMCzQ2S4IycYb_N3kPrb2ssAgLo.INSTANCE, 30, null), r15.a(r18, (h) ZeusTransformUtils.preCheckCast(r16.component1(), h.class, "com.obric.memorydata.plugin"), (Set) ZeusTransformUtils.preCheckCast(r16.component2(), Set.class, "com.obric.memorydata.plugin"))));
        goto L26
    L28:
        return r1;
    }

    public static /* synthetic */ List lambda$3nmFCjI46FdQyDsl47zfcZ2FTXY(j r0, int r1) {
        return b(r0, r1);
    }

    public static /* synthetic */ List lambda$G1yovEZK6kN0TPk7uMTjFY679Uo(Exception r0) {
        return a(r0);
    }

    public static /* synthetic */ CharSequence lambda$sMCzQ2S4IycYb_N3kPrb2ssAgLo(h r0) {
        return a(r0);
    }

    public final List<a> a(final j r2, final int r3) {
        Intrinsics.checkNotNullParameter(r2, "docTree");
        List<a> r1 = (List) ZeusTransformUtils.preCheckCast(com.obric.memorydata.utils.y.a($$Lambda$s$G1yovEZK6kN0TPk7uMTjFY679Uo.INSTANCE, new $$Lambda$s$3nmFCjI46FdQyDsl47zfcZ2FTXY(r2, r3)), List.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L5;
        return r1;
    L5:
        return CollectionsKt.emptyList();
    }
}
