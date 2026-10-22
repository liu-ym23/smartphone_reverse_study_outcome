package com.obric.memorydata.personalcontext.impl.events.handlers;

import com.obric.memorydata.BuildConfig;
import com.obric.memorydata.database.entity.gi;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.sdk.awareness.EventNames;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J(\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\n2\u0006\u0010\t\u001a\u00020\nH\u0016J \u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J&\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\n0\u000f2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¨\u0006\u0013"}, d2 = {"Lcom/obric/memorydata/personalcontext/impl/events/handlers/IcsProtocolEntityEventHandler;", "Lcom/obric/memorydata/personalcontext/impl/events/RawEntityEventHandler;", "<init>", "()V", "onInsert", "", "Lcom/obric/memorydata/personalcontext/impl/events/AwarenessEvent;", "rawId", "", "raw", "", "onUpdate", "oldRaw", "onDelete", "metaExtras", "", "", "op", "Companion", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class g implements com.obric.memorydata.personalcontext.impl.events.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f12213a = null;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/obric/memorydata/personalcontext/impl/events/handlers/IcsProtocolEntityEventHandler$Companion;", "", "<init>", "()V", "TAG", "", "OP_INSERT", "OP_UPDATE", "OP_DELETE", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f12213a = new a(null);
    }

    public g() {
    }

    private final Map<String, Object> a(long r1, String r3) {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to("raw_id", Long.valueOf(r1)), TuplesKt.to("raw_table", "RawICSProtocolEntity"), TuplesKt.to("operation", r3)});
    }

    @Override // com.obric.memorydata.personalcontext.impl.events.c
    public List<com.obric.memorydata.personalcontext.impl.events.a> a(long r10, Object r12) {
        Intrinsics.checkNotNullParameter(r12, "raw");
        if (ZeusTransformUtils.instanceOf(r12, gi.class) == true) goto L7;
        return CollectionsKt.emptyList();
    L7:
        if (com.obric.memorydata.personalcontext.impl.events.b.f12198a.a(((gi) ZeusTransformUtils.preCheckCast(r12, gi.class, "com.obric.memorydata.plugin")).getModifyTime()) == false) goto L10;
        RunLog.INSTANCE.debug("IcsProtocolEntityEventHandler", "history filtered rawId=" + r10 + " modifyTime=" + ((gi) ZeusTransformUtils.preCheckCast(r12, gi.class, "com.obric.memorydata.plugin")).getModifyTime());
        return CollectionsKt.emptyList();
    L10:
        Map r0 = MapsKt.createMapBuilder();
        r0.putAll(a(r10, "insert"));
        String r9 = ((gi) ZeusTransformUtils.preCheckCast(r12, gi.class, "com.obric.memorydata.plugin")).b();
        boolean r1 = true;
        if (r9 != null) goto L13;
    L18:
        Map r11 = MapsKt.build(r0);
        IRunLog r3 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r13 = new StringBuilder().append("dispatch calendar_event_changed(insert) rawId=").append(r10).append(" hasICal=");
        String r14 = ((gi) ZeusTransformUtils.preCheckCast(r12, gi.class, "com.obric.memorydata.plugin")).b();
        if (r14 != null) goto L21;
    L23:
        r1 = false;
    L24:
        IRunLog.a.a(r3, "IcsProtocolEntityEventHandler", r13.append(r1).toString(), false, 4, null);
        return CollectionsKt.listOf(new com.obric.memorydata.personalcontext.impl.events.a(EventNames.CALENDAR_EVENT_CHANGED, r11));
    L21:
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r14, CharSequence.class, "com.obric.memorydata.plugin"))) != true) goto L23;
    L13:
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L16;
        r9 = null;
    L16:
        if (r9 == null) goto L18;
        r0.put("icalendar_event", r9);
        goto L18
    }

    @Override // com.obric.memorydata.personalcontext.impl.events.c
    public List<com.obric.memorydata.personalcontext.impl.events.a> a(long r11, Object r13, Object r14) {
        Intrinsics.checkNotNullParameter(r14, "raw");
        if (ZeusTransformUtils.instanceOf(r14, gi.class) == false) goto L5;
        String r1 = null;
        if (ZeusTransformUtils.instanceOf(r13, gi.class) == false) goto L9;
        gi r0 = (gi) ZeusTransformUtils.preCheckCast(r13, gi.class, "com.obric.memorydata.plugin");
    L10:
        if (r0 == null) goto L12;
        String r2 = r0.b();
    L14:
        if (ZeusTransformUtils.instanceOf(r13, gi.class) == true) goto L16;
    L19:
        Map r15 = MapsKt.createMapBuilder();
        r15.putAll(a(r11, BuildConfig.CHANNEL));
        String r10 = ((gi) ZeusTransformUtils.preCheckCast(r14, gi.class, "com.obric.memorydata.plugin")).b();
        boolean r3 = true;
        if (r10 != null) goto L22;
    L27:
        if (r2 != null) goto L29;
    L33:
        Map r12 = MapsKt.build(r15);
        IRunLog r4 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r16 = new StringBuilder().append("dispatch calendar_event_changed(update) rawId=").append(r11).append(" hasICal=");
        String r17 = ((gi) ZeusTransformUtils.preCheckCast(r14, gi.class, "com.obric.memorydata.plugin")).b();
        if (r17 != null) goto L36;
    L38:
        boolean r18 = false;
    L39:
        StringBuilder r19 = r16.append(r18).append(" hasOldICal=");
        if (r2 != null) goto L42;
    L44:
        r3 = false;
    L45:
        IRunLog.a.a(r4, "IcsProtocolEntityEventHandler", r19.append(r3).toString(), false, 4, null);
        return CollectionsKt.listOf(new com.obric.memorydata.personalcontext.impl.events.a(EventNames.CALENDAR_EVENT_CHANGED, r12));
    L42:
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin"))) != true) goto L44;
    L36:
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r17, CharSequence.class, "com.obric.memorydata.plugin"))) != true) goto L38;
        r18 = true;
        goto L39
    L29:
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L31;
        r1 = r2;
    L31:
        if (r1 == null) goto L33;
        r15.put("old_icalendar_event", r1);
        goto L33
    L22:
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L25;
        r10 = null;
    L25:
        if (r10 == null) goto L27;
        r15.put("icalendar_event", r10);
        goto L27
    L16:
        if (Intrinsics.areEqual(r2, ((gi) ZeusTransformUtils.preCheckCast(r14, gi.class, "com.obric.memorydata.plugin")).b()) == false) goto L19;
        RunLog.INSTANCE.debug("IcsProtocolEntityEventHandler", "iCal unchanged, skip rawId=" + r11);
        return CollectionsKt.emptyList();
    L12:
        r2 = null;
        goto L14
    L9:
        r0 = null;
        goto L10
    L5:
        return CollectionsKt.emptyList();
    }

    @Override // com.obric.memorydata.personalcontext.impl.events.c
    public List<com.obric.memorydata.personalcontext.impl.events.a> b(long r7, Object r9) {
        Map r0 = MapsKt.createMapBuilder();
        r0.putAll(a(r7, "delete"));
        String r1 = null;
        if (ZeusTransformUtils.instanceOf(r9, gi.class) == false) goto L5;
        gi r6 = (gi) ZeusTransformUtils.preCheckCast(r9, gi.class, "com.obric.memorydata.plugin");
    L6:
        if (r6 == null) goto L14;
        String r8 = r6.b();
        if (r8 == null) goto L14;
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L12;
        r1 = r8;
    L12:
        if (r1 == null) goto L14;
        r0.put("icalendar_event", r1);
    L14:
        Map r10 = MapsKt.build(r0);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "IcsProtocolEntityEventHandler", "dispatch calendar_event_changed(delete) rawId=" + r7, false, 4, null);
        return CollectionsKt.listOf(new com.obric.memorydata.personalcontext.impl.events.a(EventNames.CALENDAR_EVENT_CHANGED, r10));
    L5:
        r6 = null;
        goto L6
    }
}
