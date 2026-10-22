package com.obric.memorydata.personalcontext.impl.events.handlers;

import com.obric.aikernel.sdk.ext.Params;
import com.obric.memorydata.BuildConfig;
import com.obric.memorydata.database.entity.gu;
import com.obric.memorydata.sdk.awareness.EventNames;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J(\u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000b\u001a\u00020\fH\u0016J \u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J2\u0010\u0010\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00122\u0018\b\u0002\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u0012\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u0014H\u0002J\u001a\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0006\u0012\u0004\u0018\u00010\f0\u0014*\u00020\u0016H\u0002J\f\u0010\u0017\u001a\u00020\u0018*\u00020\u0016H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/obric/memorydata/personalcontext/impl/events/handlers/NoteEntityEventHandler;", "Lcom/obric/memorydata/personalcontext/impl/events/RawEntityEventHandler;", "<init>", "()V", "suppressor", "Lcom/obric/memorydata/personalcontext/impl/events/EventDispatchUtils$BurstSuppressor;", "onInsert", "", "Lcom/obric/memorydata/personalcontext/impl/events/AwarenessEvent;", "rawId", "", "raw", "", "onUpdate", "oldRaw", "onDelete", "buildEvent", "operation", "", "old", "", "toSnapshot", "Lcom/obric/memorydata/database/entity/RawNoteEntity;", "isContentEmpty", "", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class i implements com.obric.memorydata.personalcontext.impl.events.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.obric.memorydata.personalcontext.impl.events.b.a f12218a;

    public i() {
        this.f12218a = new com.obric.memorydata.personalcontext.impl.events.b.a(5, 1000);
    }

    private final com.obric.memorydata.personalcontext.impl.events.a a(long r2, String r4, Map<String, ? extends Object> r5) {
        Map r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.memorydata.plugin");
        Map r6 = MapsKt.createMapBuilder();
        r6.put("raw_id", Long.valueOf(r2));
        r6.put("raw_table", "RawNoteEntity");
        r6.put("operation", r4);
        if (r1 == null) goto L6;
        r6.put("old_note", r1);
    L6:
        return new com.obric.memorydata.personalcontext.impl.events.a(EventNames.NOTE_CHANGED, MapsKt.build(r6));
    }

    static /* synthetic */ com.obric.memorydata.personalcontext.impl.events.a a(i r1, long r2, String r4, Map r5, int r6, Object r7) {
        Map<String, ? extends Object> r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.memorydata.plugin");
        if ((r6 & 4) == 0) goto L6;
        r8 = null;
    L6:
        return r1.a(r2, r4, r8);
    }

    private final Map<String, Object> a(gu r3) {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to("title", r3.a()), TuplesKt.to(Params.CONTENT, r3.b()), TuplesKt.to("is_favorite", Boolean.valueOf(r3.f()))});
    }

    private final boolean b(gu r3) {
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r3.a(), CharSequence.class, "com.obric.memorydata.plugin")) == true) goto L5;
    L7:
        return false;
    L5:
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r3.b(), CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L7;
        return true;
    }

    @Override // com.obric.memorydata.personalcontext.impl.events.c
    public List<com.obric.memorydata.personalcontext.impl.events.a> a(long r8, Object r10) {
        Intrinsics.checkNotNullParameter(r10, "raw");
        if (ZeusTransformUtils.instanceOf(r10, gu.class) == false) goto L5;
        gu r11 = (gu) ZeusTransformUtils.preCheckCast(r10, gu.class, "com.obric.memorydata.plugin");
    L6:
        if (r11 != null) goto L10;
        return CollectionsKt.emptyList();
    L10:
        if (com.obric.memorydata.personalcontext.impl.events.b.f12198a.a(r11.getCreateTime()) == true) goto L21;
        if (b(r11) == true) goto L21;
        if (this.f12218a.a() == true) goto L19;
        return CollectionsKt.emptyList();
    L19:
        return CollectionsKt.listOf(a(this, r8, "insert", null, 4, null));
    L21:
        return CollectionsKt.emptyList();
    L5:
        r11 = null;
        goto L6
    }

    @Override // com.obric.memorydata.personalcontext.impl.events.c
    public List<com.obric.memorydata.personalcontext.impl.events.a> a(long r11, Object r13, Object r14) {
        Intrinsics.checkNotNullParameter(r14, "raw");
        Map<String, ? extends Object> r2 = null;
        if (ZeusTransformUtils.instanceOf(r14, gu.class) == false) goto L5;
        gu r15 = (gu) ZeusTransformUtils.preCheckCast(r14, gu.class, "com.obric.memorydata.plugin");
    L6:
        if (r15 != null) goto L10;
        return CollectionsKt.emptyList();
    L10:
        if (ZeusTransformUtils.instanceOf(r13, gu.class) == false) goto L12;
        gu r16 = (gu) ZeusTransformUtils.preCheckCast(r13, gu.class, "com.obric.memorydata.plugin");
    L13:
        boolean r1 = true;
        if (b(r15) == false) goto L23;
        if (r16 != null) goto L17;
    L19:
        boolean r0 = false;
    L20:
        if (r0 == true) goto L23;
        return CollectionsKt.emptyList();
    L17:
        if (b(r16) == true) goto L19;
        r0 = true;
    L23:
        if (r16 == null) goto L25;
        r2 = a(r16);
    L25:
        if (r2 == null) goto L31;
        if (Intrinsics.areEqual(r2, a(r15)) == false) goto L31;
        return CollectionsKt.emptyList();
    L31:
        if (this.f12218a.a() == false) goto L33;
        if (r16 != null) goto L36;
    L38:
        r1 = false;
    L39:
        if (r1 == true) goto L41;
    L43:
        com.obric.memorydata.personalcontext.impl.events.a r10 = a(r11, BuildConfig.CHANNEL, r2);
    L45:
        return CollectionsKt.listOf(r10);
    L41:
        if (b(r15) == true) goto L43;
        r10 = a(this, r11, "insert", null, 4, null);
        goto L45
    L36:
        if (b(r16) != true) goto L38;
    L33:
        return CollectionsKt.emptyList();
    L12:
        r16 = null;
        goto L13
    L5:
        r15 = null;
        goto L6
    }

    @Override // com.obric.memorydata.personalcontext.impl.events.c
    public List<com.obric.memorydata.personalcontext.impl.events.a> b(long r4, Object r6) {
        if (this.f12218a.a() == false) goto L5;
        Map<String, ? extends Object> r1 = null;
        if (ZeusTransformUtils.instanceOf(r6, gu.class) == false) goto L9;
        gu r7 = (gu) ZeusTransformUtils.preCheckCast(r6, gu.class, "com.obric.memorydata.plugin");
    L10:
        if (r7 == null) goto L13;
        r1 = a(r7);
    L13:
        return CollectionsKt.listOf(a(r4, "delete", r1));
    L9:
        r7 = null;
        goto L10
    L5:
        return CollectionsKt.emptyList();
    }
}
