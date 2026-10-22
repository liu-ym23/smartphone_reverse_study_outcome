package com.obric.memorydata.personalcontext.impl.events.handlers;

import com.obric.aikernel.sdk.ext.Params;
import com.obric.memorydata.BuildConfig;
import com.obric.memorydata.database.entity.AutoMemoryProEntity;
import com.obric.memorydata.database.entity.MemoryRuleEntity;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.obric.memorydata.memory.lab.AILabCheckPermissionTask;
import com.obric.memorydata.memory.ui.automemory.AutoMemoryViewModel;
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
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J(\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\n2\u0006\u0010\t\u001a\u00020\nH\u0016J \u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J&\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002¨\u0006\u0013"}, d2 = {"Lcom/obric/memorydata/personalcontext/impl/events/handlers/AutoMemoryProEntityEventHandler;", "Lcom/obric/memorydata/personalcontext/impl/events/RawEntityEventHandler;", "<init>", "()V", "onInsert", "", "Lcom/obric/memorydata/personalcontext/impl/events/AwarenessEvent;", "rawId", "", "raw", "", "onUpdate", "oldRaw", "onDelete", "buildAutoMemoryChangedEvent", "Lcom/obric/memorydata/database/entity/AutoMemoryProEntity;", "op", "", "Companion", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class b implements com.obric.memorydata.personalcontext.impl.events.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f12207a = null;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/obric/memorydata/personalcontext/impl/events/handlers/AutoMemoryProEntityEventHandler$Companion;", "", "<init>", "()V", "TAG", "", "SOURCE_AI_PROACTIVE", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f12207a = new a(null);
    }

    public b() {
    }

    private final List<com.obric.memorydata.personalcontext.impl.events.a> a(long r4, AutoMemoryProEntity r6, String r7) {
        MemoryRuleEntity r3 = (MemoryRuleEntity) ZeusTransformUtils.preCheckCast(MemoryDbEngine.INSTANCE.getPersonalDbEngine().getMemoryRuleDao().queryById(r6.getRuleId()), MemoryRuleEntity.class, "com.obric.memorydata.plugin");
        RunLog r0 = RunLog.INSTANCE;
        StringBuilder r8 = new StringBuilder().append(r7).append(" AutoMemoryProEntity rawId=").append(r4).append(" ruleId=").append(r6.getRuleId()).append(" title=");
        String r1 = null;
        if (r3 == null) goto L5;
        String r2 = r3.getTitle();
    L6:
        StringBuilder r9 = r8.append(r2).append(" source=");
        if (r3 == null) goto L9;
        String r5 = r3.getSource();
    L10:
        r0.debug("AutoMemoryProEntityEventHandler", r9.append(r5).toString());
        if (r3 == null) goto L14;
        r1 = r3.getSource();
    L14:
        if (Intrinsics.areEqual(r1, AutoMemoryViewModel.SOURCE_AI_PROACTIVE) == true) goto L18;
        return CollectionsKt.emptyList();
    L18:
        return CollectionsKt.listOf(new com.obric.memorydata.personalcontext.impl.events.a(EventNames.AUTO_MEMORY_CHANGED, MapsKt.mapOf(new Pair[]{TuplesKt.to("raw_id", Long.valueOf(r4)), TuplesKt.to("raw_table", "AutoMemoryPro"), TuplesKt.to("rule_id", Long.valueOf(r6.getRuleId())), TuplesKt.to(AILabCheckPermissionTask.KEY_SOURCE, AutoMemoryViewModel.SOURCE_AI_PROACTIVE), TuplesKt.to("title", r6.getTitle()), TuplesKt.to(Params.CONTENT, r6.getContent()), TuplesKt.to("create_time", Long.valueOf(r6.getCreateTime())), TuplesKt.to("timestamp", Long.valueOf(r6.getTimestamp()))})));
    L9:
        r5 = null;
        goto L10
    L5:
        r2 = null;
        goto L6
    }

    @Override // com.obric.memorydata.personalcontext.impl.events.c
    public List<com.obric.memorydata.personalcontext.impl.events.a> a(long r3, Object r5) {
        Intrinsics.checkNotNullParameter(r5, "raw");
        if (ZeusTransformUtils.instanceOf(r5, AutoMemoryProEntity.class) == true) goto L7;
        return CollectionsKt.emptyList();
    L7:
        return a(r3, (AutoMemoryProEntity) ZeusTransformUtils.preCheckCast(r5, AutoMemoryProEntity.class, "com.obric.memorydata.plugin"), "insert");
    }

    @Override // com.obric.memorydata.personalcontext.impl.events.c
    public List<com.obric.memorydata.personalcontext.impl.events.a> a(long r2, Object r4, Object r5) {
        Intrinsics.checkNotNullParameter(r5, "raw");
        if (ZeusTransformUtils.instanceOf(r5, AutoMemoryProEntity.class) == true) goto L7;
        return CollectionsKt.emptyList();
    L7:
        return a(r2, (AutoMemoryProEntity) ZeusTransformUtils.preCheckCast(r5, AutoMemoryProEntity.class, "com.obric.memorydata.plugin"), BuildConfig.CHANNEL);
    }

    @Override // com.obric.memorydata.personalcontext.impl.events.c
    public List<com.obric.memorydata.personalcontext.impl.events.a> b(long r1, Object r3) {
        return CollectionsKt.emptyList();
    }
}
