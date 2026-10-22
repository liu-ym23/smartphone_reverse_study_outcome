package com.obric.memorydata.memory.review.trace;

import com.obric.memorydata.memory.lab.AILabCheckPermissionTask;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J \u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0010J\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\t0\u0015J\u0006\u0010\u0016\u001a\u00020\u0017J \u0010\u0018\u001a\u00020\u0017*\u00020\u00192\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00170\u001bH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\u0007\u001a\u001e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\bj\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t`\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/obric/memorydata/memory/review/trace/MemoryDeleteTraceContextStore;", "", "maxMappingCount", "", "<init>", "(I)V", "lock", "logIdByEntityId", "Ljava/util/LinkedHashMap;", "", "Lkotlin/collections/LinkedHashMap;", "rememberSearchMappings", "Lcom/obric/memorydata/memory/review/trace/MemoryDeleteTraceCacheResult;", AILabCheckPermissionTask.KEY_SOURCE, "logId", "memoryOps", "Lorg/json/JSONObject;", "takeForDelete", "", "Lcom/obric/memorydata/memory/review/trace/MemoryDeleteTraceMapping;", "entityIds", "", "clear", "", "forEachResultEntityId", "Lorg/json/JSONArray;", "block", "Lkotlin/Function1;", "Companion", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final a f10482a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f10483b;
    private final Object c;
    private final LinkedHashMap<String, String> d;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/obric/memorydata/memory/review/trace/MemoryDeleteTraceContextStore$Companion;", "", "<init>", "()V", "DEFAULT_MAX_MAPPING_COUNT", "", "KEY_SEARCH", "", "KEY_ENTITY_ID", "KEY_RESULT_ENTITIES", "KEY_RESULT_ENTITY_IDS", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f10482a = new a(null);
    }

    public d() {
        this(0, 1, null);
    }

    public d(int r2) {
        this.f10483b = r2;
        this.c = new Object();
        this.d = new LinkedHashMap();
        if (r2 <= 0) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L9;
        return;
    L9:
        throw new IllegalArgumentException("Failed requirement.".toString());
    L5:
        r1 = false;
        goto L6
    }

    public /* synthetic */ d(int r1, int r2, DefaultConstructorMarker r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = 100;
    L5:
        this(r1);
    }

    private static final e a(d r3, String r4) {
        Intrinsics.checkNotNullParameter(r4, "entityId");
        String r5 = (String) ZeusTransformUtils.preCheckCast(r3.d.remove(r4), String.class, "com.obric.memorydata.plugin");
        if (r5 != null) goto L5;
        return null;
    L5:
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L8;
        r5 = null;
    L8:
        if (r5 != null) goto L10;
        return null;
    L10:
        return new e(r4, r5);
    }

    private static final Unit a(d r3, String r4, Ref.IntRef r5, Ref.IntRef r6, String r7) {
        Intrinsics.checkNotNullParameter(r7, "entityId");
        r3.d.remove(r7);
        ((Map) ZeusTransformUtils.preCheckCast(r3.d, Map.class, "com.obric.memorydata.plugin")).put(r7, r4);
        r5.element++;
    L4:
        if (r3.d.size() <= r3.f10483b) goto L12;
        Set<Map.Entry<String, String>> r8 = r3.d.entrySet();
        Intrinsics.checkNotNullExpressionValue(r8, "<get-entries>(...)");
        Map.Entry r9 = (Map.Entry) ZeusTransformUtils.preCheckCast(CollectionsKt.firstOrNull((Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.memorydata.plugin")), Map.Entry.class, "com.obric.memorydata.plugin");
        if (r9 == null) goto L12;
        String r10 = (String) ZeusTransformUtils.preCheckCast(r9.getKey(), String.class, "com.obric.memorydata.plugin");
        if (r10 == null) goto L12;
        r3.d.remove(r10);
        r6.element++;
    L12:
        return Unit.INSTANCE;
    }

    private final void a(JSONArray r11, Function1<? super String, Unit> r12) {
        Function1 r10 = (Function1) ZeusTransformUtils.wrapperContextForParams(r12, Function1.class, "com.obric.memorydata.plugin");
        int r13 = r11.length();
        int r2 = 0;
    L3:
        if (r2 >= r13) goto L35;
        JSONObject r3 = r11.optJSONObject(r2);
        if (r3 == null) goto L34;
        JSONArray r4 = r3.optJSONArray("resultEntities");
        if (r4 == null) goto L22;
        int r6 = r4.length();
        int r7 = 0;
    L10:
        if (r7 >= r6) goto L22;
        JSONObject r8 = r4.optJSONObject(r7);
        if (r8 == null) goto L21;
        String r9 = r8.optString("entityId");
        if (r9 == null) goto L21;
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L19;
        r9 = null;
    L19:
        if (r9 == null) goto L21;
        r10.invoke(r9);
    L21:
        r7 = r7 + 1;
    L22:
        JSONArray r5 = r3.optJSONArray("resultEntityIds");
        if (r5 == null) goto L34;
        int r14 = r5.length();
        int r15 = 0;
    L26:
        if (r15 >= r14) goto L34;
        String r16 = r5.optString(r15);
        Intrinsics.checkNotNull(r16);
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r16, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L31;
        r16 = null;
    L31:
        if (r16 == null) goto L33;
        r10.invoke(r16);
    L33:
        r15 = r15 + 1;
    L34:
        r2 = r2 + 1;
        goto L3
    }

    private static final boolean a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "entityId");
        return !StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: lambda$2Ti0LpJr-xjXpi0FubvT51xV8FA, reason: not valid java name */
    public static /* synthetic */ e m752lambda$2Ti0LpJrxjXpi0FubvT51xV8FA(d r0, String r1) {
        return a(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$GOH5OG39UzRasiQylA-9gopbl0o, reason: not valid java name */
    public static /* synthetic */ Unit m753lambda$GOH5OG39UzRasiQylA9gopbl0o(d r0, String r1, Ref.IntRef r2, Ref.IntRef r3, String r4) {
        return a(r0, r1, r2, r3, r4);
    }

    /* JADX INFO: renamed from: lambda$tRYqaZ3GjYE-oWGAMyEU6_rxKSw, reason: not valid java name */
    public static /* synthetic */ boolean m754lambda$tRYqaZ3GjYEoWGAMyEU6_rxKSw(String r0) {
        return a(r0);
    }

    public final c a(String r5, final String r6, JSONObject r7) {
        Intrinsics.checkNotNullParameter(r5, AILabCheckPermissionTask.KEY_SOURCE);
        Intrinsics.checkNotNullParameter(r6, "logId");
        Intrinsics.checkNotNullParameter(r7, "memoryOps");
        if (Intrinsics.areEqual(r5, "Memory_OperateNew") == true) goto L5;
    L37:
        return null;
    L5:
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.memorydata.plugin")) == true) goto L37;
        JSONArray r8 = r7.optJSONArray("search");
        if (r8 == null) goto L37;
        if (r8.length() <= 0) goto L12;
        boolean r9 = true;
    L13:
        if (r9 == true) goto L16;
        r8 = null;
    L16:
        if (r8 == null) goto L37;
        final Ref.IntRef r10 = new Ref.IntRef();
        final Ref.IntRef r1 = new Ref.IntRef();
        Object r2 = this.c;
        monitor-enter(r2);
        a(r8, new $$Lambda$d$GOH5OG39UzRasiQylA9gopbl0o(this, r6, r10, r1));     // Catch: Throwable -> L34
        Unit r11 = Unit.INSTANCE;     // Catch: Throwable -> L34
        monitor-exit(r2);
        if (r10.element != 0) goto L25;
        return null;
    L25:
        int r12 = r10.element;
        int r13 = r1.element;
        Object r14 = this.c;
        monitor-enter(r14);
        int r4 = this.d.size();     // Catch: Throwable -> L31
        monitor-exit(r14);
        return new c(r12, r13, r4);
    L31:
        th = move-exception;
        throw th;
    L34:
        th = move-exception;
        throw th;
    L12:
        r9 = false;
        goto L13
    }

    public final List<e> a(Collection<String> r4) {
        Collection r5 = (Collection) ZeusTransformUtils.wrapperContextForParams(r4, Collection.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "entityIds");
        if (r5.isEmpty() == true) goto L5;
        Object r0 = this.c;
        monitor-enter(r0);
        List<e> r3 = SequencesKt.toList(SequencesKt.mapNotNull(SequencesKt.distinct(SequencesKt.filter(CollectionsKt.asSequence((Iterable) ZeusTransformUtils.preCheckCast(r5, Iterable.class, "com.obric.memorydata.plugin")), $$Lambda$d$tRYqaZ3GjYEoWGAMyEU6_rxKSw.INSTANCE)), new $$Lambda$d$2Ti0LpJrxjXpi0FubvT51xV8FA(this)));     // Catch: Throwable -> L11
        monitor-exit(r0);
        return r3;
    L11:
        th = move-exception;
        throw th;
    L5:
        return CollectionsKt.emptyList();
    }

    public final void a() {
        Object r0 = this.c;
        monitor-enter(r0);
        this.d.clear();     // Catch: Throwable -> L7
        Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L7
        monitor-exit(r0);
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
