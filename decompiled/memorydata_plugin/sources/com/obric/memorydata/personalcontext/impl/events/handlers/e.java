package com.obric.memorydata.personalcontext.impl.events.handlers;

import com.obric.memorydata.BuildConfig;
import com.obric.memorydata.database.entity.EpisodicMemoryEntity;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.sdk.awareness.EventNames;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J(\u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000b\u001a\u00020\fH\u0016J \u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\u001e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0018\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u0016H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/obric/memorydata/personalcontext/impl/events/handlers/EpisodicMemoryEventHandler;", "Lcom/obric/memorydata/personalcontext/impl/events/RawEntityEventHandler;", "<init>", "()V", "observationMemorySuppressor", "Lcom/obric/memorydata/personalcontext/impl/events/EventDispatchUtils$BurstSuppressor;", "onInsert", "", "Lcom/obric/memorydata/personalcontext/impl/events/AwarenessEvent;", "rawId", "", "raw", "", "onUpdate", "oldRaw", "onDelete", "dispatch", "operation", "", "isObservationMemory", "", "entity", "Lcom/obric/memorydata/database/entity/EpisodicMemoryEntity;", "hasContentChanged", "oldEntity", "Companion", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class e implements com.obric.memorydata.personalcontext.impl.events.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f12210a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.obric.memorydata.personalcontext.impl.events.b.a f12211b;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/obric/memorydata/personalcontext/impl/events/handlers/EpisodicMemoryEventHandler$Companion;", "", "<init>", "()V", "TAG", "", "OP_INSERT", "OP_UPDATE", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f12210a = new a(null);
    }

    public e() {
        this.f12211b = new com.obric.memorydata.personalcontext.impl.events.b.a(5, 1000);
    }

    private final List<com.obric.memorydata.personalcontext.impl.events.a> a(long r7, String r9) {
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EpisodicMemoryEventHandler", "dispatch episodic_memory_changed(" + r9 + ") rawId=" + r7, false, 4, null);
        return CollectionsKt.listOf(new com.obric.memorydata.personalcontext.impl.events.a(EventNames.EPISODIC_MEMORY_CHANGED, MapsKt.mapOf(new Pair[]{TuplesKt.to("raw_id", Long.valueOf(r7)), TuplesKt.to("raw_table", "ShortMemory"), TuplesKt.to("operation", r9)})));
    }

    private final boolean a(EpisodicMemoryEntity r1) {
        return com.obric.memorydata.database.model.e.f9611a.a(r1.getProductType());
    }

    private final boolean a(EpisodicMemoryEntity r2, EpisodicMemoryEntity r3) {
        if (Intrinsics.areEqual(r2.getContent(), r3.getContent()) == true) goto L5;
    L8:
        return true;
    L5:
        if (Intrinsics.areEqual(r2.getFullContent(), r3.getFullContent()) == false) goto L8;
        return false;
    }

    @Override // com.obric.memorydata.personalcontext.impl.events.c
    public List<com.obric.memorydata.personalcontext.impl.events.a> a(long r4, Object r6) {
        Intrinsics.checkNotNullParameter(r6, "raw");
        if (ZeusTransformUtils.instanceOf(r6, EpisodicMemoryEntity.class) == false) goto L5;
        EpisodicMemoryEntity r7 = (EpisodicMemoryEntity) ZeusTransformUtils.preCheckCast(r6, EpisodicMemoryEntity.class, "com.obric.memorydata.plugin");
    L6:
        if (r7 != null) goto L10;
        return CollectionsKt.emptyList();
    L10:
        if (com.obric.memorydata.personalcontext.impl.events.b.f12198a.a(r7.getCreateTime()) == false) goto L14;
        RunLog.INSTANCE.debug("EpisodicMemoryEventHandler", "history filtered rawId=" + r4 + " createTime=" + r7.getCreateTime());
        return CollectionsKt.emptyList();
    L14:
        if (a(r7) == false) goto L20;
        if (this.f12211b.a() == true) goto L20;
        RunLog.INSTANCE.debug("EpisodicMemoryEventHandler", "observation burst suppressed rawId=" + r4);
        return CollectionsKt.emptyList();
    L20:
        return a(r4, "insert");
    L5:
        r7 = null;
        goto L6
    }

    @Override // com.obric.memorydata.personalcontext.impl.events.c
    public List<com.obric.memorydata.personalcontext.impl.events.a> a(long r4, Object r6, Object r7) {
        Intrinsics.checkNotNullParameter(r7, "raw");
        EpisodicMemoryEntity r2 = null;
        if (ZeusTransformUtils.instanceOf(r7, EpisodicMemoryEntity.class) == false) goto L5;
        EpisodicMemoryEntity r8 = (EpisodicMemoryEntity) ZeusTransformUtils.preCheckCast(r7, EpisodicMemoryEntity.class, "com.obric.memorydata.plugin");
    L6:
        if (r8 != null) goto L10;
        return CollectionsKt.emptyList();
    L10:
        if (ZeusTransformUtils.instanceOf(r6, EpisodicMemoryEntity.class) == false) goto L13;
        r2 = (EpisodicMemoryEntity) ZeusTransformUtils.preCheckCast(r6, EpisodicMemoryEntity.class, "com.obric.memorydata.plugin");
    L13:
        if (r2 == null) goto L19;
        if (a(r2, r8) == true) goto L19;
        RunLog.INSTANCE.debug("EpisodicMemoryEventHandler", "content unchanged, skip rawId=" + r4);
        return CollectionsKt.emptyList();
    L19:
        if (a(r8) == true) goto L28;
        boolean r9 = true;
        if (r2 != null) goto L23;
    L25:
        r9 = false;
    L26:
        if (r9 == true) goto L28;
    L32:
        return a(r4, BuildConfig.CHANNEL);
    L23:
        if (a(r2) != true) goto L25;
    L28:
        if (this.f12211b.a() == true) goto L32;
        RunLog.INSTANCE.debug("EpisodicMemoryEventHandler", "observation burst suppressed rawId=" + r4);
        return CollectionsKt.emptyList();
    L5:
        r8 = null;
        goto L6
    }

    @Override // com.obric.memorydata.personalcontext.impl.events.c
    public List<com.obric.memorydata.personalcontext.impl.events.a> b(long r1, Object r3) {
        return CollectionsKt.emptyList();
    }
}
