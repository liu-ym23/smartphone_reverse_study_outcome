package com.obric.memorydata.personalcontext.impl.events.handlers;

import com.obric.memorydata.database.entity.hb;
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
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J(\u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000b\u001a\u00020\fH\u0016J \u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\u0016\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\nH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/obric/memorydata/personalcontext/impl/events/handlers/PhotoEntityEventHandler;", "Lcom/obric/memorydata/personalcontext/impl/events/RawEntityEventHandler;", "<init>", "()V", "suppressor", "Lcom/obric/memorydata/personalcontext/impl/events/EventDispatchUtils$BurstSuppressor;", "onInsert", "", "Lcom/obric/memorydata/personalcontext/impl/events/AwarenessEvent;", "rawId", "", "raw", "", "onUpdate", "oldRaw", "onDelete", "dispatch", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class j implements com.obric.memorydata.personalcontext.impl.events.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.obric.memorydata.personalcontext.impl.events.b.a f12219a;

    public j() {
        this.f12219a = new com.obric.memorydata.personalcontext.impl.events.b.a(5, 1000);
    }

    private final List<com.obric.memorydata.personalcontext.impl.events.a> a(long r3) {
        if (this.f12219a.a() == true) goto L7;
        return CollectionsKt.emptyList();
    L7:
        return CollectionsKt.listOf(new com.obric.memorydata.personalcontext.impl.events.a(EventNames.PHOTO_CREATED, MapsKt.mapOf(new Pair[]{TuplesKt.to("raw_id", Long.valueOf(r3)), TuplesKt.to("raw_table", "RawPhotoEntity"), TuplesKt.to("operation", "insert")})));
    }

    @Override // com.obric.memorydata.personalcontext.impl.events.c
    public List<com.obric.memorydata.personalcontext.impl.events.a> a(long r5, Object r7) {
        Intrinsics.checkNotNullParameter(r7, "raw");
        if (ZeusTransformUtils.instanceOf(r7, hb.class) == false) goto L5;
        hb r8 = (hb) ZeusTransformUtils.preCheckCast(r7, hb.class, "com.obric.memorydata.plugin");
    L6:
        if (r8 != null) goto L10;
        return CollectionsKt.emptyList();
    L10:
        if (com.obric.memorydata.personalcontext.impl.events.b.f12198a.b(r8.getCreateTime()) == true) goto L23;
        CharSequence r9 = (CharSequence) ZeusTransformUtils.preCheckCast(r8.c(), CharSequence.class, "com.obric.memorydata.plugin");
        if (r9 != null) goto L14;
    L17:
        boolean r10 = true;
    L18:
        if (r10 == true) goto L23;
        return a(r5);
    L14:
        if (StringsKt.isBlank(r9) == true) goto L17;
        r10 = false;
    L23:
        return CollectionsKt.emptyList();
    L5:
        r8 = null;
        goto L6
    }

    @Override // com.obric.memorydata.personalcontext.impl.events.c
    public List<com.obric.memorydata.personalcontext.impl.events.a> a(long r5, Object r7, Object r8) {
        Intrinsics.checkNotNullParameter(r8, "raw");
        String r1 = null;
        if (ZeusTransformUtils.instanceOf(r8, hb.class) == false) goto L5;
        hb r9 = (hb) ZeusTransformUtils.preCheckCast(r8, hb.class, "com.obric.memorydata.plugin");
    L6:
        if (r9 != null) goto L10;
        return CollectionsKt.emptyList();
    L10:
        if (ZeusTransformUtils.instanceOf(r7, hb.class) == false) goto L12;
        hb r10 = (hb) ZeusTransformUtils.preCheckCast(r7, hb.class, "com.obric.memorydata.plugin");
    L13:
        if (r10 == null) goto L15;
        r1 = r10.c();
    L15:
        CharSequence r11 = (CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.memorydata.plugin");
        boolean r0 = false;
        if (r11 != null) goto L18;
    L21:
        boolean r12 = true;
    L22:
        if (r12 == false) goto L37;
        CharSequence r13 = (CharSequence) ZeusTransformUtils.preCheckCast(r9.c(), CharSequence.class, "com.obric.memorydata.plugin");
        if (r13 != null) goto L26;
    L27:
        r0 = true;
    L28:
        if (r0 == true) goto L37;
        if (com.obric.memorydata.personalcontext.impl.events.b.f12198a.b(r9.getCreateTime()) == false) goto L35;
        return CollectionsKt.emptyList();
    L35:
        return a(r5);
    L26:
        if (StringsKt.isBlank(r13) == false) goto L28;
    L37:
        return CollectionsKt.emptyList();
    L18:
        if (StringsKt.isBlank(r11) == true) goto L21;
        r12 = false;
        goto L22
    L12:
        r10 = null;
        goto L13
    L5:
        r9 = null;
        goto L6
    }

    @Override // com.obric.memorydata.personalcontext.impl.events.c
    public List<com.obric.memorydata.personalcontext.impl.events.a> b(long r1, Object r3) {
        return CollectionsKt.emptyList();
    }
}
