package com.obric.memorydata.memory.calendar;

import com.obric.capabilitykit.entity.memory.MemoryEntity;
import com.obric.memorydata.database.entity.PendingMemoryCalendar;
import com.obric.memorydata.database.entity.RawMemoryEntity;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J,\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\b\u0010\f\u001a\u0004\u0018\u00010\rJ,\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\u0006\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\b\u0010\f\u001a\u0004\u0018\u00010\rJ(\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\rJ(\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\rR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/obric/memorydata/memory/calendar/PendingMemoryCalendarConstructor;", "", "<init>", "()V", "TAG", "", "buildCalendarInfos", "", "Lcom/obric/memorydata/database/entity/PendingMemoryCalendar;", "memoryEntity", "Lcom/obric/capabilitykit/entity/memory/MemoryEntity;", "memoryUUID", "memoryJson", "Lorg/json/JSONObject;", "episodicMemoryWithRelevant", "Lcom/obric/memorydata/database/entity/EpisodicMemoryWithRelevant;", "sourcePackageName", "sourceAppName", "entityType", "", "entityUUID", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f10086a = null;

    static {
        f10086a = new c();
    }

    private c() {
    }

    public static /* synthetic */ List a(c r0, MemoryEntity r1, String r2, JSONObject r3, int r4, Object r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = null;
    L6:
        return r0.a(r1, r2, r3);
    }

    public final List<PendingMemoryCalendar> a(int r3, String r4, JSONObject r5) {
        Intrinsics.checkNotNullParameter(r4, "entityUUID");
        if (r5 == null) goto L5;
        String r6 = r5.optString("calendarInfoList");
    L6:
        List<CalendarJsonItem> r7 = b.f10085a.a(r6);
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(r7, Collection.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L9;
    L12:
        boolean r1 = true;
    L13:
        if (r1 == true) goto L18;
        List<PendingMemoryCalendar> r8 = b.f10085a.a(r3, r4, r7);
        if (r8 == null) goto L19;
        b.f10085a.a(r8, true);
        return r8;
    L19:
        return null;
    L18:
        return null;
    L9:
        if (r0.isEmpty() == true) goto L12;
        r1 = false;
        goto L13
    L5:
        r6 = null;
        goto L6
    }

    public final List<PendingMemoryCalendar> a(MemoryEntity r9, String r10, JSONObject r11) {
        Intrinsics.checkNotNullParameter(r9, "memoryEntity");
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "PendingMemoryCalendarConstructor", "buildCalendarInfos", false, 4, null);
        if (r11 == null) goto L5;
        String r12 = r11.optString("calendarInfoList");
    L6:
        List<CalendarJsonItem> r13 = b.f10085a.a(r12);
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(r13, Collection.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L9;
    L12:
        boolean r1 = true;
    L13:
        if (r1 == true) goto L26;
        if (r10 != null) goto L21;
        r10 = r9.getUuid();
        if (r10 != null) goto L21;
        RawMemoryEntity r14 = (RawMemoryEntity) ZeusTransformUtils.preCheckCast(CollectionsKt.firstOrNull(MemoryDbEngine.INSTANCE.getGlobalDbEngine().getRawMemoryEntityDao().queryByEntityId(r9.getId(), r9.get_packageName())), RawMemoryEntity.class, "com.obric.memorydata.plugin");
        if (r14 == null) goto L20;
        r10 = r14.getUuid();
        goto L21
    L20:
        r10 = null;
    L21:
        if (r10 == null) goto L27;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "PendingMemoryCalendarConstructor", "buildCalendarInfos uuid: " + r10, false, 4, null);
        List<PendingMemoryCalendar> r15 = b.f10085a.a(r9, r10, r13);
        if (r15 != null) goto L25;
        return null;
    L25:
        return b.f10085a.a(r15);
    L27:
        return null;
    L26:
        return null;
    L9:
        if (r0.isEmpty() == true) goto L12;
        r1 = false;
        goto L13
    L5:
        r12 = null;
        goto L6
    }
}
