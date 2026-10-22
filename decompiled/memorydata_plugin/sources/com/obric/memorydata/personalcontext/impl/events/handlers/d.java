package com.obric.memorydata.personalcontext.impl.events.handlers;

import com.obric.memorydata.BuildConfig;
import com.obric.memorydata.database.entity.fz;
import com.obric.memorydata.sdk.awareness.EventNames;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.bouncycastle.jcajce.util.AnnotatedPrivateKey;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0010$\n\u0002\b\u0004\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000eH\u0016J(\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\f\u001a\u00020\b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\r\u001a\u00020\u000eH\u0016J \u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\f\u001a\u00020\b2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J \u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n2\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002JL\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u00172\u0018\b\u0002\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u0017\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0018\u00010\u00182\u0018\b\u0002\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00020\u0017\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0018\u00010\u0018H\u0002J\u001a\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\u0017\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u0018*\u00020\u0014H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/obric/memorydata/personalcontext/impl/events/handlers/CountdownEntityEventHandler;", "Lcom/obric/memorydata/personalcontext/impl/events/RawEntityEventHandler;", "<init>", "()V", "suppressor", "Lcom/obric/memorydata/personalcontext/impl/events/EventDispatchUtils$BurstSuppressor;", "pendingPausedInserts", "", "", "onInsert", "", "Lcom/obric/memorydata/personalcontext/impl/events/AwarenessEvent;", "rawId", "raw", "", "onUpdate", "oldRaw", "onDelete", "dispatchPendingInsert", "countdown", "Lcom/obric/memorydata/database/entity/RawCountdownEntity;", "buildEvent", "operation", "", "", "old", "toSnapshot", "Companion", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class d implements com.obric.memorydata.personalcontext.impl.events.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f12208a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.obric.memorydata.personalcontext.impl.events.b.a f12209b;
    private final Set<Long> c;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/personalcontext/impl/events/handlers/CountdownEntityEventHandler$Companion;", "", "<init>", "()V", "PAUSED_STATUS", "", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f12208a = new a(null);
    }

    public d() {
        this.f12209b = new com.obric.memorydata.personalcontext.impl.events.b.a(5, 1000);
        this.c = (Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.memorydata.plugin");
    }

    private final com.obric.memorydata.personalcontext.impl.events.a a(long r2, String r4, Map<String, ? extends Object> r5, Map<String, ? extends Object> r6) {
        Map r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.memorydata.plugin");
        Map r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.memorydata.plugin");
        Map r8 = MapsKt.createMapBuilder();
        r8.put("raw_id", Long.valueOf(r2));
        r8.put("raw_table", "RawCountdownEntity");
        r8.put("operation", r4);
        if (r1 == null) goto L5;
        r8.putAll(r1);
    L5:
        if (r7 == null) goto L8;
        r8.put("old_countdown", r7);
    L8:
        return new com.obric.memorydata.personalcontext.impl.events.a(EventNames.COUNTDOWN_CHANGED, MapsKt.build(r8));
    }

    static /* synthetic */ com.obric.memorydata.personalcontext.impl.events.a a(d r7, long r8, String r10, Map r11, Map r12, int r13, Object r14) {
        Map<String, ? extends Object> r15 = (Map) ZeusTransformUtils.wrapperContextForParams(r11, Map.class, "com.obric.memorydata.plugin");
        Map<String, ? extends Object> r16 = (Map) ZeusTransformUtils.wrapperContextForParams(r12, Map.class, "com.obric.memorydata.plugin");
        if ((r13 & 4) == 0) goto L5;
        Map<String, ? extends Object> r5 = null;
    L7:
        if ((r13 & 8) == 0) goto L9;
        Map<String, ? extends Object> r6 = null;
    L11:
        return r7.a(r8, r10, r5, r6);
    L9:
        r6 = r16;
        goto L11
    L5:
        r5 = r15;
        goto L7
    }

    private final List<com.obric.memorydata.personalcontext.impl.events.a> a(long r12, fz r14) {
        Set<Long> r0 = this.c;
        monitor-enter(r0);
    L16:
        th = move-exception;
        throw th;
    L5:
        if (this.c.contains(Long.valueOf(r12)) == true) goto L8;
        List<com.obric.memorydata.personalcontext.impl.events.a> r11 = null;
    L14:
        monitor-exit(r0);
        return r11;
    L8:
        if (Intrinsics.areEqual(r14.c(), "PAUSED") == false) goto L11;
    L9:
        r11 = CollectionsKt.emptyList();     // Catch: Throwable -> L16
        goto L14
    L11:
        if (this.f12209b.a() == false) goto L9;
        this.c.remove(Long.valueOf(r12));     // Catch: Throwable -> L16
        r11 = CollectionsKt.listOf(a(this, r12, "insert", a(r14), null, 8, null));     // Catch: Throwable -> L16
        goto L14
    }

    private final Map<String, Object> a(fz r3) {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to(AnnotatedPrivateKey.LABEL, r3.b()), TuplesKt.to("countdown_seconds", Long.valueOf(r3.a())), TuplesKt.to("status", r3.c())});
    }

    @Override // com.obric.memorydata.personalcontext.impl.events.c
    public List<com.obric.memorydata.personalcontext.impl.events.a> a(long r9, Object r11) {
        Intrinsics.checkNotNullParameter(r11, "raw");
        if (ZeusTransformUtils.instanceOf(r11, fz.class) == false) goto L5;
        fz r12 = (fz) ZeusTransformUtils.preCheckCast(r11, fz.class, "com.obric.memorydata.plugin");
    L6:
        if (r12 != null) goto L10;
        return CollectionsKt.emptyList();
    L10:
        if (com.obric.memorydata.personalcontext.impl.events.b.f12198a.a(r12.getCreateTime()) == false) goto L14;
        return CollectionsKt.emptyList();
    L14:
        if (Intrinsics.areEqual(r12.c(), "PAUSED") == false) goto L25;
        Set<Long> r13 = this.c;
        monitor-enter(r13);
        this.c.add(Long.valueOf(r9));     // Catch: Throwable -> L21
        monitor-exit(r13);
        return CollectionsKt.emptyList();
    L21:
        th = move-exception;
        throw th;
    L25:
        if (this.f12209b.a() == true) goto L29;
        return CollectionsKt.emptyList();
    L29:
        return CollectionsKt.listOf(a(this, r9, "insert", a(r12), null, 8, null));
    L5:
        r12 = null;
        goto L6
    }

    @Override // com.obric.memorydata.personalcontext.impl.events.c
    public List<com.obric.memorydata.personalcontext.impl.events.a> a(long r10, Object r12, Object r13) {
        Intrinsics.checkNotNullParameter(r13, "raw");
        Map<String, Object> r2 = null;
        if (ZeusTransformUtils.instanceOf(r13, fz.class) == false) goto L5;
        fz r14 = (fz) ZeusTransformUtils.preCheckCast(r13, fz.class, "com.obric.memorydata.plugin");
    L6:
        if (r14 != null) goto L10;
        return CollectionsKt.emptyList();
    L10:
        if (ZeusTransformUtils.instanceOf(r12, fz.class) == false) goto L12;
        fz r15 = (fz) ZeusTransformUtils.preCheckCast(r12, fz.class, "com.obric.memorydata.plugin");
    L13:
        if (r15 == null) goto L15;
        r2 = a(r15);
    L15:
        Map<String, Object> r8 = r2;
        if (r8 != null) goto L18;
    L21:
        List<com.obric.memorydata.personalcontext.impl.events.a> r16 = a(r10, r14);
        if (r16 == null) goto L25;
        return r16;
    L25:
        if (this.f12209b.a() == true) goto L29;
        return CollectionsKt.emptyList();
    L29:
        return CollectionsKt.listOf(a(r10, BuildConfig.CHANNEL, a(r14), r8));
    L18:
        if (Intrinsics.areEqual(r8, a(r14)) == false) goto L21;
        return CollectionsKt.emptyList();
    L12:
        r15 = null;
        goto L13
    L5:
        r14 = null;
        goto L6
    }

    @Override // com.obric.memorydata.personalcontext.impl.events.c
    public List<com.obric.memorydata.personalcontext.impl.events.a> b(long r9, Object r11) {
        Set<Long> r0 = this.c;
        monitor-enter(r0);
        boolean r1 = this.c.remove(Long.valueOf(r9));     // Catch: Throwable -> L22
        monitor-exit(r0);
        if (r1 == false) goto L10;
        return CollectionsKt.emptyList();
    L10:
        if (this.f12209b.a() == true) goto L14;
        return CollectionsKt.emptyList();
    L14:
        if (ZeusTransformUtils.instanceOf(r11, fz.class) == false) goto L16;
        fz r12 = (fz) ZeusTransformUtils.preCheckCast(r11, fz.class, "com.obric.memorydata.plugin");
    L17:
        if (r12 == null) goto L19;
        Map<String, Object> r5 = a(r12);
    L21:
        return CollectionsKt.listOf(a(this, r9, "delete", null, r5, 4, null));
    L19:
        r5 = null;
        goto L21
    L16:
        r12 = null;
    L22:
        th = move-exception;
        throw th;
    }
}
