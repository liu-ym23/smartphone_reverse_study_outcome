package com.obric.memorydata.memory.calendar;

import android.os.Looper;
import androidx.fragment.app.FragmentTransaction;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.obric.capabilitykit.entity.memory.MemoryEntity;
import com.obric.memorydata.constants.AppInfo;
import com.obric.memorydata.database.entity.PendingMemoryCalendar;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.utils.q;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005H\u0002J\u0018\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n2\b\u0010\f\u001a\u0004\u0018\u00010\u0005J,\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\n2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00052\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000b0\nJ,\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\n2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0011\u001a\u00020\u00052\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000b0\nJ,\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\n2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00052\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000b0\nJ,\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\n2\u0006\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u00052\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000b0\nJ\u001a\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u000e0\n2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u000e0\nJ\u001e\u0010\u001f\u001a\u00020 2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u000e0\n2\b\b\u0002\u0010!\u001a\u00020 J\u0016\u0010\u001f\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u000e2\u0006\u0010$\u001a\u00020 J\u000e\u0010%\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\u000eJ\u0010\u0010%\u001a\u00020\u00072\b\u0010\u0011\u001a\u0004\u0018\u00010\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/obric/memorydata/memory/calendar/CalendarUtil;", "", "<init>", "()V", "TAG", "", "warnIfMainThread", "", "method", "parseCalendarJson", "", "Lcom/obric/memorydata/memory/calendar/CalendarJsonItem;", "calendarJson", "buildCalendarDataWithMemoryEntity", "Lcom/obric/memorydata/database/entity/PendingMemoryCalendar;", "memoryEntity", "Lcom/obric/capabilitykit/entity/memory/MemoryEntity;", "memoryUUID", "calendarItems", "buildCalendarDataWithEpisodicMemoryEntity", "episodicRelevantData", "Lcom/obric/memorydata/database/entity/EpisodicMemoryWithRelevant;", "buildCalendarDataWithAppEntity", "entityType", "", "entityUUID", "buildCalendarDataWithNoEntity", "sourcePackageName", "sourceAppName", "saveCalendarData", "calendarDataList", "writeToCalendarApp", "", "needCheckCalendarEnableState", "Lcom/obric/memorydata/memory/calendar/CalendarResult;", "calendarData", "markInDb", "deletePendingCalendar", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f10085a = null;

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"com/obric/memorydata/memory/calendar/CalendarUtil$parseCalendarJson$typeToken$1", "Lcom/google/gson/reflect/TypeToken;", "", "Lcom/obric/memorydata/memory/calendar/CalendarJsonItem;", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a extends TypeToken<List<? extends CalendarJsonItem>> {
        a() {
        }
    }

    static {
        f10085a = new b();
    }

    private b() {
    }

    private final void c(String r7) {
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L6;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "CalendarUtil", r7 + " called on MAIN THREAD! This will trigger Room's assertNotMainThread. Caller must switch to a background thread.", null, 4, null);
        return;
    }

    public final com.obric.memorydata.memory.calendar.a a(PendingMemoryCalendar r19, boolean r20) {
        Intrinsics.checkNotNullParameter(r19, "calendarData");
        c("writeToCalendarApp(single)");
        RunLog.INSTANCE.debug("CalendarUtil", "writeToCalendarApp calendarData: " + r19);
        com.obric.memorydata.memory.calendar.a r15 = com.obric.memorydata.memory.provider.b.f10359a.a(r19);
        if (r20 == false) goto L8;
        if (r15.a() == false) goto L8;
        MemoryDbEngine.INSTANCE.getPersonalDbEngine().getPendingMemoryCalendarDao().update(PendingMemoryCalendar.copy$default(r19, 0, null, null, null, null, null, null, null, null, null, null, null, 1, 4095, null));
    L8:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "CalendarUtil", "writeToCalendarApp createCalendar " + q.f13259a.b(r19.getTitle()) + ", result: " + r15, false, 4, null);
        return r15;
    }

    public final List<PendingMemoryCalendar> a(int r26, String r27, List<CalendarJsonItem> r28) {
        String r12 = "com.obric.memorydata.plugin";
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r28, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r27, "entityUUID");
        Intrinsics.checkNotNullParameter(r1, "calendarItems");
        RunLog.INSTANCE.debug("CalendarUtil", "buildCalendarDataWithMemoryEntity entityType: " + r26 + ", entityUUID: " + r27);
        RunLog.INSTANCE.debug("CalendarUtil", "buildCalendarDataWithMemoryEntity calendarItems: " + r1);
        if (r26 != 101) goto L5;
        AppInfo r2 = AppInfo.Message;
    L15:
        AppInfo r18 = r2;
        Iterable r3 = (Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.memorydata.plugin");
        Collection r11 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r3, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r19 = r3.iterator();
    L17:
        if (r19.hasNext() == false) goto L33;
        CalendarJsonItem r4 = (CalendarJsonItem) ZeusTransformUtils.preCheckCast(r19.next(), CalendarJsonItem.class, r12);
        String r5 = r4.getTitle();
        String r6 = r4.getType();
        Long r8 = r4.getStart_datetime();
        Long r9 = r4.getEnd_datetime();
        String r7 = r4.getLocation();
        String r10 = r4.getDescription();
        String r13 = r4.getRrule();
        if (r18 == null) goto L24;
        String r14 = r18.getPackageName();
        if (r14 == null) goto L24;
        String r20 = r14;
    L25:
        if (r18 == null) goto L30;
        String r15 = r18.getAppName();
        if (r15 == null) goto L30;
        String r21 = r15;
    L31:
        Collection r23 = r11;
        String r24 = r12;
        r23.add(new PendingMemoryCalendar(0, r5, r7, r6, r10, r8, r9, r13, r20, r21, r27, Integer.valueOf(r26), 0, FragmentTransaction.TRANSIT_FRAGMENT_OPEN, null));
        r11 = r23;
        r12 = r24;
    L30:
        r21 = "";
    L24:
        r20 = "";
        goto L25
    L33:
        return (List) ZeusTransformUtils.preCheckCast(r11, List.class, r12);
    L5:
        if (r26 != 202) goto L7;
        r2 = AppInfo.Contact;
        goto L15
    L7:
        if (r26 != 301) goto L9;
        r2 = AppInfo.Gallery;
        goto L15
    L9:
        if (r26 == 501) goto L11;
        r2 = null;
        goto L15
    L11:
        r2 = AppInfo.Recorder;
        goto L15
    }

    public final List<PendingMemoryCalendar> a(MemoryEntity r25, String r26, List<CalendarJsonItem> r27) {
        String r12 = "com.obric.memorydata.plugin";
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r27, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r25, "memoryEntity");
        Intrinsics.checkNotNullParameter(r26, "memoryUUID");
        Intrinsics.checkNotNullParameter(r1, "calendarItems");
        RunLog.INSTANCE.debug("CalendarUtil", "buildCalendarDataWithMemoryEntity memoryEntity: " + r25);
        RunLog.INSTANCE.debug("CalendarUtil", "buildCalendarDataWithMemoryEntity memoryUUID: " + r26);
        RunLog.INSTANCE.debug("CalendarUtil", "buildCalendarDataWithMemoryEntity calendarItems: " + r1);
        Iterable r2 = (Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.memorydata.plugin");
        Collection r11 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r2, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r18 = r2.iterator();
    L4:
        if (r18.hasNext() == false) goto L15;
        CalendarJsonItem r3 = (CalendarJsonItem) ZeusTransformUtils.preCheckCast(r18.next(), CalendarJsonItem.class, r12);
        String r4 = r3.getTitle();
        String r6 = r3.getType();
        Long r8 = r3.getStart_datetime();
        Long r9 = r3.getEnd_datetime();
        String r5 = r3.getLocation();
        String r7 = r3.getDescription();
        String r10 = r3.getRrule();
        String r13 = r25.getSourcePackageName();
        if (r13 != null) goto L8;
        String r19 = "";
    L9:
        String r14 = r25.getSourceAppName();
        if (r14 != null) goto L12;
        String r20 = "";
    L13:
        Collection r22 = r11;
        String r23 = r12;
        r22.add(new PendingMemoryCalendar(0, r4, r5, r6, r7, r8, r9, r10, r19, r20, r26, Integer.valueOf(r25.getType()), 0, FragmentTransaction.TRANSIT_FRAGMENT_OPEN, null));
        r11 = r22;
        r12 = r23;
        goto L4
    L12:
        r20 = r14;
        goto L13
    L8:
        r19 = r13;
        goto L9
    L15:
        return (List) ZeusTransformUtils.preCheckCast(r11, List.class, r12);
    }

    public final List<CalendarJsonItem> a(String r11) {
        IRunLog r2 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r10 = new StringBuilder().append("parseCalendarJson calendarJson.isNullOrEmpty(): ");
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.memorydata.plugin");
        boolean r8 = false;
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        IRunLog.a.a(r2, "CalendarUtil", r10.append(r1).toString(), false, 4, null);
        RunLog.INSTANCE.debug("CalendarUtil", "parseCalendarJson calendarJson: " + r11);
        CharSequence r12 = (CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.memorydata.plugin");
        if (r12 != null) goto L12;
    L13:
        r8 = true;
    L15:
        if (r8 == false) goto L30;
        return null;
    L30:
        List r13 = (List) ZeusTransformUtils.preCheckCast(new Gson().fromJson(r11, new a().getType()), List.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L27
        if (r13 == null) goto L37;
        Iterable r14 = (Iterable) ZeusTransformUtils.preCheckCast(r13, Iterable.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L27
        Collection r3 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L27
        Iterator r15 = r14.iterator();     // Catch: Exception -> L27
    L21:
        if (r15.hasNext() == false) goto L25;
        Object r4 = r15.next();     // Catch: Exception -> L27
        if (((CalendarJsonItem) ZeusTransformUtils.preCheckCast(r4, CalendarJsonItem.class, "com.obric.memorydata.plugin")).isValid() == false) goto L21;
        r3.add(r4);     // Catch: Exception -> L27
        goto L21
    L25:
        return (List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.memorydata.plugin");
    L37:
        return null;
    L27:
        e = move-exception;
        RunLog.INSTANCE.warn("CalendarUtil", "parseCalendarJson error", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        return null;
    L12:
        if (r12.length() != 0) goto L15;
    L5:
        if (r0.length() == 0) goto L8;
        r1 = false;
        goto L9
    }

    public final List<PendingMemoryCalendar> a(List<PendingMemoryCalendar> r25) {
        List<PendingMemoryCalendar> r0 = (List) ZeusTransformUtils.wrapperContextForParams(r25, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r0, "calendarDataList");
        c("saveCalendarData");
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "CalendarUtil", "saveCalendarData calendarDataList: " + r0.size(), false, 4, null);
        Iterable r2 = (Iterable) ZeusTransformUtils.preCheckCast(MemoryDbEngine.INSTANCE.getPersonalDbEngine().getPendingMemoryCalendarDao().batchInsert(r0), Iterable.class, "com.obric.memorydata.plugin");
        Collection r3 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r2, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r4 = r2.iterator();
        int r5 = 0;
    L4:
        if (r4.hasNext() == false) goto L10;
        Object r6 = r4.next();
        int r7 = r5 + 1;
        if (r5 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        r3.add(PendingMemoryCalendar.copy$default((PendingMemoryCalendar) ZeusTransformUtils.preCheckCast(r0.get(r5), PendingMemoryCalendar.class, "com.obric.memorydata.plugin"), ((Number) ZeusTransformUtils.preCheckCast(r6, Number.class, "com.obric.memorydata.plugin")).longValue(), null, null, null, null, null, null, null, null, null, null, null, 0, 8190, null));
        r5 = r7;
        goto L4
    L10:
        return (List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.memorydata.plugin");
    }

    public final boolean a(List<PendingMemoryCalendar> r9, boolean r10) {
        List r11 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r11, "calendarDataList");
        c("writeToCalendarApp(list)");
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "CalendarUtil", "writeToCalendarApp calendarDataList: " + r11.size(), false, 4, null);
        if (r10 == true) goto L5;
    L7:
        Iterator r12 = r11.iterator();
    L8:
        boolean r3 = true;
    L10:
        if (r12.hasNext() == false) goto L18;
        com.obric.memorydata.memory.calendar.a r4 = a((PendingMemoryCalendar) ZeusTransformUtils.preCheckCast(r12.next(), PendingMemoryCalendar.class, "com.obric.memorydata.plugin"), !r10);
        if (r3 == false) goto L16;
        if (r4.a() == true) goto L8;
    L16:
        r3 = false;
        goto L10
    L18:
        return r3;
    L5:
        if (com.obric.memorydata.memory.provider.b.f10359a.a() == true) goto L7;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "CalendarUtil", "writeToCalendarApp calendar auto import is disabled", null, 4, null);
        return false;
    }

    public final void b(String r7) {
        c("deletePendingCalendar(uuid)");
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "CalendarUtil", "deletePendingCalendar " + r7, false, 4, null);
        if (r7 == null) goto L6;
        MemoryDbEngine.INSTANCE.getPersonalDbEngine().getPendingMemoryCalendarDao().delete(r7);
        return;
    }
}
