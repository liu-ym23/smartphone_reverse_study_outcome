package com.obric.memorydata.personalcontext.impl.events.handlers;

import com.obric.memorydata.BuildConfig;
import com.obric.memorydata.database.entity.fq;
import com.obric.memorydata.sdk.awareness.EventNames;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J(\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\n2\u0006\u0010\t\u001a\u00020\nH\u0016J \u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u0018\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002¨\u0006\u0011"}, d2 = {"Lcom/obric/memorydata/personalcontext/impl/events/handlers/CallHistorySummaryEventHandler;", "Lcom/obric/memorydata/personalcontext/impl/events/RawEntityEventHandler;", "<init>", "()V", "onInsert", "", "Lcom/obric/memorydata/personalcontext/impl/events/AwarenessEvent;", "rawId", "", "raw", "", "onUpdate", "oldRaw", "onDelete", "buildEvent", "operation", "", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class c implements com.obric.memorydata.personalcontext.impl.events.c {
    public c() {
    }

    private final com.obric.memorydata.personalcontext.impl.events.a a(long r2, String r4) {
        return new com.obric.memorydata.personalcontext.impl.events.a(EventNames.CALL_HISTORY_CHANGED, MapsKt.mapOf(new Pair[]{TuplesKt.to("raw_id", Long.valueOf(r2)), TuplesKt.to("raw_table", "RawCallHistoryEntity"), TuplesKt.to("operation", r4)}));
    }

    @Override // com.obric.memorydata.personalcontext.impl.events.c
    public List<com.obric.memorydata.personalcontext.impl.events.a> a(long r4, Object r6) {
        Intrinsics.checkNotNullParameter(r6, "raw");
        if (ZeusTransformUtils.instanceOf(r6, fq.class) == true) goto L7;
        return CollectionsKt.emptyList();
    L7:
        if (com.obric.memorydata.personalcontext.impl.events.b.f12198a.a(((fq) ZeusTransformUtils.preCheckCast(r6, fq.class, "com.obric.memorydata.plugin")).getCreateTime()) == false) goto L11;
        return CollectionsKt.emptyList();
    L11:
        return CollectionsKt.listOf(a(r4, "insert"));
    }

    @Override // com.obric.memorydata.personalcontext.impl.events.c
    public List<com.obric.memorydata.personalcontext.impl.events.a> a(long r4, Object r6, Object r7) {
        Intrinsics.checkNotNullParameter(r7, "raw");
        if (ZeusTransformUtils.instanceOf(r7, fq.class) == false) goto L5;
        String r1 = null;
        if (ZeusTransformUtils.instanceOf(r6, fq.class) == false) goto L9;
        fq r8 = (fq) ZeusTransformUtils.preCheckCast(r6, fq.class, "com.obric.memorydata.plugin");
    L10:
        if (r8 == null) goto L14;
        String r9 = r8.h();
        if (r9 == null) goto L14;
        String r10 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.memorydata.plugin")).toString();
    L15:
        String r11 = ((fq) ZeusTransformUtils.preCheckCast(r7, fq.class, "com.obric.memorydata.plugin")).h();
        if (r11 == null) goto L19;
        r1 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.memorydata.plugin")).toString();
    L19:
        if (Intrinsics.areEqual(r10, r1) == false) goto L23;
        return CollectionsKt.emptyList();
    L23:
        return CollectionsKt.listOf(a(r4, BuildConfig.CHANNEL));
    L14:
        r10 = null;
        goto L15
    L9:
        r8 = null;
        goto L10
    L5:
        return CollectionsKt.emptyList();
    }

    @Override // com.obric.memorydata.personalcontext.impl.events.c
    public List<com.obric.memorydata.personalcontext.impl.events.a> b(long r1, Object r3) {
        return CollectionsKt.emptyList();
    }
}
