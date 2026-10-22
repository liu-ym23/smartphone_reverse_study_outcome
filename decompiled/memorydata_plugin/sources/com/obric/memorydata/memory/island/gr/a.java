package com.obric.memorydata.memory.island.gr;

import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.CalendarContract;
import com.bytedance.apm6.consumer.slardar.Constants;
import com.obric.aiproactive.impl.livecard.ProactiveLiveCardDisplayTool;
import com.obric.memorydata.database.entity.PendingMemoryCalendar;
import com.obric.memorydata.memory.permission.PermissionActivity;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.utils.q;
import com.volcengine.zeus.transform.ZeusProviderTransform;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001,B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000eJ\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0010J6\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00102\u0018\u0010\u0016\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u0010\u0012\u0004\u0012\u00020\u00130\u0017J*\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\r\u001a\u00020\u000e2\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00130\u0017J\"\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00180\u00102\u0006\u0010\u0014\u001a\u00020\u00152\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0010J\u0016\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\r\u001a\u00020\u000eJ\u0016\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u001eJ\u0010\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u0005H\u0002J$\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00180\u00102\u0006\u0010\u0014\u001a\u00020\u00152\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0010H\u0002J\u0018\u0010#\u001a\u00020$2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010%\u001a\u00020\u001eH\u0002J\"\u0010&\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010'\u001a\u00020(H\u0002J\u0015\u0010)\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u0014\u001a\u00020\u0015¢\u0006\u0002\u0010*J\u0016\u0010+\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u001eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006-"}, d2 = {"Lcom/obric/memorydata/memory/island/gr/CalendarWriteHelper;", "", "<init>", "()V", "TAG", "", "filterTodo", "", "getFilterTodo", "()Z", "setFilterTodo", "(Z)V", "shouldIncludeItem", "item", "Lcom/obric/memorydata/database/entity/PendingMemoryCalendar;", "filterItems", "", Constants.KEY_LIST, "writeEventsWithPermission", "", "context", "Landroid/content/Context;", "callback", "Lkotlin/Function1;", "Lcom/obric/memorydata/memory/island/gr/CalendarWriteHelper$CalendarWriteResult;", "writeSingleEventWithPermission", "writeEventsToCalendar", "writeSingleEvent", "openEventInCalendar", "eventId", "", "parseDurationToMillis", "duration", "doWriteEvents", "filteredList", "buildContentValues", "Landroid/content/ContentValues;", "calendarId", "addReminder", "minutesBefore", "", "getDefaultCalendarId", "(Landroid/content/Context;)Ljava/lang/Long;", "deleteEvent", "CalendarWriteResult", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f10204a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile boolean f10205b;

    /* JADX INFO: renamed from: com.obric.memorydata.memory.island.gr.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0017\n\u0002\u0010\b\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\f\u0010\rJ\b\u0010\u0018\u001a\u00020\u000bH\u0016J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0012J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u000bHÆ\u0003JF\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bHÆ\u0001¢\u0006\u0002\u0010\u001fJ\u0013\u0010 \u001a\u00020\u00052\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020#HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0010R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006$"}, d2 = {"Lcom/obric/memorydata/memory/island/gr/CalendarWriteHelper$CalendarWriteResult;", "", "item", "Lcom/obric/memorydata/database/entity/PendingMemoryCalendar;", "isSuccess", "", "eventId", "", "eventUri", "Landroid/net/Uri;", "error", "", "<init>", "(Lcom/obric/memorydata/database/entity/PendingMemoryCalendar;ZLjava/lang/Long;Landroid/net/Uri;Ljava/lang/String;)V", "getItem", "()Lcom/obric/memorydata/database/entity/PendingMemoryCalendar;", "()Z", "getEventId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getEventUri", "()Landroid/net/Uri;", "getError", "()Ljava/lang/String;", "toString", "component1", "component2", "component3", "component4", "component5", "copy", "(Lcom/obric/memorydata/database/entity/PendingMemoryCalendar;ZLjava/lang/Long;Landroid/net/Uri;Ljava/lang/String;)Lcom/obric/memorydata/memory/island/gr/CalendarWriteHelper$CalendarWriteResult;", "equals", "other", "hashCode", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class C0501a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final PendingMemoryCalendar f10206a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f10207b;
        private final Long c;
        private final Uri d;
        private final String e;

        public C0501a(PendingMemoryCalendar r2, boolean r3, Long r4, Uri r5, String r6) {
            Intrinsics.checkNotNullParameter(r2, "item");
            this.f10206a = r2;
            this.f10207b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
        }

        public /* synthetic */ C0501a(PendingMemoryCalendar r8, boolean r9, Long r10, Uri r11, String r12, int r13, DefaultConstructorMarker r14) {
            if ((r13 & 4) == 0) goto L5;
            Long r4 = null;
        L7:
            if ((r13 & 8) == 0) goto L9;
            Uri r5 = null;
        L11:
            if ((r13 & 16) == 0) goto L13;
            String r6 = null;
        L14:
            this(r8, r9, r4, r5, r6);
            return;
        L13:
            r6 = r12;
            goto L14
        L9:
            r5 = r11;
            goto L11
        L5:
            r4 = r10;
            goto L7
        }

        public final PendingMemoryCalendar a() {
            return this.f10206a;
        }

        public final boolean b() {
            return this.f10207b;
        }

        public final Long c() {
            return this.c;
        }

        public final String d() {
            return this.e;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, C0501a.class) == true) goto L8;
            return false;
        L8:
            C0501a r6 = (C0501a) ZeusTransformUtils.preCheckCast(r5, C0501a.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f10206a, r6.f10206a) == true) goto L12;
            return false;
        L12:
            if (this.f10207b == r6.f10207b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.e, r6.e) == true) goto L23;
            return false;
        L23:
            return true;
        }

        public int hashCode() {
            int r0 = ((this.f10206a.hashCode() * 31) + Boolean.hashCode(this.f10207b)) * 31;
            Long r1 = this.c;
            int r2 = 0;
            if (r1 != null) goto L5;
            int r3 = 0;
        L6:
            int r4 = (r0 + r3) * 31;
            Uri r5 = this.d;
            if (r5 != null) goto L9;
            int r6 = 0;
        L10:
            int r7 = (r4 + r6) * 31;
            String r8 = this.e;
            if (r8 == null) goto L15;
            r2 = r8.hashCode();
        L15:
            return r7 + r2;
        L9:
            r6 = r5.hashCode();
            goto L10
        L5:
            r3 = r1.hashCode();
            goto L6
        }

        public String toString() {
            return "CalendarWriteResult(isSuccess=" + this.f10207b + ", eventId=" + this.c + ", error=" + this.e + ", title=" + q.f13259a.b(this.f10206a.getTitle()) + ')';
        }
    }

    static {
        f10204a = new a();
        f10205b = true;
    }

    private a() {
    }

    private final ContentValues a(PendingMemoryCalendar r8, long r9) {
        String r7 = TimeZone.getDefault().getID();
        ContentValues r0 = new ContentValues();
        r0.put("calendar_id", Long.valueOf(r9));
        r0.put("title", r8.getTitle());
        r0.put("eventTimezone", r7);
        Long r10 = r8.getDtstart();
        if (r10 == null) goto L5;
        long r1 = ((Number) ZeusTransformUtils.preCheckCast(r10, Number.class, "com.obric.memorydata.plugin")).longValue();
    L6:
        r0.put("dtstart", Long.valueOf(r1));
        CharSequence r11 = (CharSequence) ZeusTransformUtils.preCheckCast(r8.getRrule(), CharSequence.class, "com.obric.memorydata.plugin");
        if (r11 != null) goto L9;
    L12:
        boolean r12 = true;
    L14:
        if (r12 == false) goto L24;
        Long r13 = r8.getDtend();
        if (r13 == null) goto L19;
        Long r14 = Long.valueOf(((Number) ZeusTransformUtils.preCheckCast(r13, Number.class, "com.obric.memorydata.plugin")).longValue());
    L18:
        r0.put("dtend", r14);
    L33:
        String r15 = r8.getLocation();
        if (r15 == null) goto L36;
        r0.put("eventLocation", r15);
    L36:
        String r16 = r8.getDescription();
        if (r16 == null) goto L39;
        r0.put("description", r16);
    L39:
        r0.put("allDay", 0);
        r0.put("eventStatus", 1);
        r0.put("hasAlarm", 1);
        return r0;
    L19:
        Long r17 = r8.getDtstart();
        if (r17 == null) goto L22;
        long r5 = r17.longValue();
    L23:
        r14 = Long.valueOf(r5 + ProactiveLiveCardDisplayTool.DEFAULT_AUTO_DISMISS_DURATION_MS);
        goto L18
    L22:
        r5 = System.currentTimeMillis();
        goto L23
    L24:
        Long r18 = r8.getDtstart();
        if (r18 == null) goto L27;
        long r4 = r18.longValue();
    L28:
        Long r19 = r8.getDtend();
        if (r19 == null) goto L31;
        long r2 = r19.longValue();
    L32:
        r0.put("duration", new StringBuilder().append('P').append((r2 - r4) / ((long) 1000)).append('S').toString());
        r0.put("rrule", r8.getRrule());
        goto L33
    L31:
        r2 = ProactiveLiveCardDisplayTool.DEFAULT_AUTO_DISMISS_DURATION_MS + r4;
        goto L32
    L27:
        r4 = System.currentTimeMillis();
        goto L28
    L9:
        if (r11.length() == 0) goto L12;
        r12 = false;
        goto L14
    L5:
        r1 = System.currentTimeMillis();
        goto L6
    }

    private final List<C0501a> a(Context r5, List<PendingMemoryCalendar> r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        List<C0501a> r0 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        Iterator r9 = ((Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r9.hasNext() == false) goto L6;
        r0.add(a(r7, (PendingMemoryCalendar) ZeusTransformUtils.preCheckCast(r9.next(), PendingMemoryCalendar.class, "com.obric.memorydata.plugin")));
        goto L4
    L6:
        return r0;
    }

    private static final Unit a(Function1 r8, Context r9, PendingMemoryCalendar r10, boolean r11, Map r12) {
        Function1 r13 = (Function1) ZeusTransformUtils.wrapperContextForParams(r8, Function1.class, "com.obric.memorydata.plugin");
        Context r14 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter((Map) ZeusTransformUtils.wrapperContextForParams(r12, Map.class, "com.obric.memorydata.plugin"), "grantResults");
        if (r11 == false) goto L5;
        C0501a r15 = f10204a.a(r14, r10);
    L6:
        r13.invoke(r15);
        return Unit.INSTANCE;
    L5:
        String r5 = "Calendar permissions denied by user";
        r15 = new C0501a(r10, false, null, null, r5, 12, null);
        goto L6
    }

    private static final Unit a(Function1 r10, Context r11, List r12, boolean r13, Map r14) {
        Function1 r15 = (Function1) ZeusTransformUtils.wrapperContextForParams(r10, Function1.class, "com.obric.memorydata.plugin");
        Context r16 = (Context) ZeusTransformUtils.wrapperContextForParams(r11, Context.class, "com.obric.memorydata.plugin");
        List<PendingMemoryCalendar> r17 = (List) ZeusTransformUtils.wrapperContextForParams(r12, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter((Map) ZeusTransformUtils.wrapperContextForParams(r14, Map.class, "com.obric.memorydata.plugin"), "grantResults");
        if (r13 == false) goto L6;
        List<C0501a> r18 = f10204a.a(r16, r17);
    L5:
        r15.invoke(r18);
        return Unit.INSTANCE;
    L6:
        Iterable r19 = (Iterable) ZeusTransformUtils.preCheckCast(r17, Iterable.class, "com.obric.memorydata.plugin");
        Collection r110 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r19, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r111 = r19.iterator();
    L8:
        if (r111.hasNext() == false) goto L10;
        String r7 = "Calendar permissions denied by user";
        r110.add(new C0501a((PendingMemoryCalendar) ZeusTransformUtils.preCheckCast(r111.next(), PendingMemoryCalendar.class, "com.obric.memorydata.plugin"), false, null, null, r7, 12, null));
        goto L8
    L10:
        r18 = (List) ZeusTransformUtils.preCheckCast(r110, List.class, "com.obric.memorydata.plugin");
        goto L5
    }

    private final void a(Context r3, long r4, int r6) {
        Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        ContentValues r5 = new ContentValues();     // Catch: Exception -> L5
        r5.put("event_id", Long.valueOf(r4));     // Catch: Exception -> L5
        r5.put("minutes", Integer.valueOf(r6));     // Catch: Exception -> L5
        r5.put("method", 1);     // Catch: Exception -> L5
        ZeusProviderTransform.insert(r2.getContentResolver(), CalendarContract.Reminders.CONTENT_URI, r5, "com.obric.memorydata.plugin");     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        RunLog.INSTANCE.warn("CalendarWriteHelper", "addReminder failed: " + e.getMessage(), (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
    }

    static /* synthetic */ void a(a r1, Context r2, long r3, int r5, int r6, Object r7) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        if ((r6 & 4) == 0) goto L5;
        r5 = 10;
    L5:
        r1.a(r4, r3, r5);
    }

    /* JADX INFO: renamed from: lambda$0xTa-qnaKsFriBZwOE4gZ_A5w0c, reason: not valid java name */
    public static /* synthetic */ Unit m718lambda$0xTaqnaKsFriBZwOE4gZ_A5w0c(Function1 r0, Context r1, List r2, boolean r3, Map r4) {
        return a(r0, r1, r2, r3, r4);
    }

    public static /* synthetic */ Unit lambda$yxG4gJ_c2KXJR5KeXLlBZjyJiIk(Function1 r0, Context r1, PendingMemoryCalendar r2, boolean r3, Map r4) {
        return a(r0, r1, r2, r3, r4);
    }

    public final C0501a a(Context r19, PendingMemoryCalendar r20) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r19, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r20, "item");
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "CalendarWriteHelper", "writeSingleEvent: title=" + q.f13259a.b(r20.getTitle()) + ", type=" + r20.getEventType() + ", dtstart=" + r20.getDtstart() + ", dtend=" + r20.getDtend() + ", rrule=" + r20.getRrule(), false, 4, null);
        if (a(r20) == true) goto L7;
        return new C0501a(r20, false, null, null, "Item excluded by filterTodo switch, type: " + r20.getEventType(), 12, null);
    L7:
        if (Intrinsics.areEqual(r20.getEventType(), PendingMemoryCalendar.TYPE_EVENT) == true) goto L11;
        return new C0501a(r20, false, null, null, "Only EVENT type is supported, got: " + r20.getEventType(), 12, null);
    L11:
        if (PermissionActivity.f10338a.a(r3) == false) goto L13;
        Long r1 = a(r3);     // Catch: Exception -> L22 IllegalArgumentException -> L24 SecurityException -> L26
        if (r1 == null) goto L21;
        Uri r9 = ZeusProviderTransform.insert(r3.getContentResolver(), CalendarContract.Events.CONTENT_URI, a(r20, r1.longValue()), "com.obric.memorydata.plugin");     // Catch: Exception -> L22 IllegalArgumentException -> L24 SecurityException -> L26
        if (r9 == null) goto L31;
        long r10 = ContentUris.parseId(r9);     // Catch: Exception -> L22 IllegalArgumentException -> L24 SecurityException -> L26
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "CalendarWriteHelper", "writeSingleEvent: event inserted successfully, eventId=" + r10 + ", title=" + q.f13259a.b(r20.getTitle()), false, 4, null);     // Catch: Exception -> L22 IllegalArgumentException -> L24 SecurityException -> L26
        a(this, r3, r10, 0, 4, null);     // Catch: Exception -> L22 IllegalArgumentException -> L24 SecurityException -> L26
        return new C0501a(r20, true, Long.valueOf(r10), r9, null, 16, null);
    L31:
        return new C0501a(r20, false, null, null, "ContentResolver.insert returned null", 12, null);
    L21:
        return new C0501a(r20, false, null, null, "No calendar account found on device", 12, null);
    L24:
        e = move-exception;
        return new C0501a(r20, false, null, null, "IllegalArgumentException: " + e.getMessage(), 12, null);
    L26:
        e = move-exception;
        return new C0501a(r20, false, null, null, "SecurityException: " + e.getMessage(), 12, null);
    L22:
        e = move-exception;
        return new C0501a(r20, false, null, null, "Exception: " + e.getMessage(), 12, null);
    L13:
        return new C0501a(r20, false, null, null, "Missing calendar permissions", 12, null);
    }

    public final Long a(Context r18) {
        Context r0 = (Context) ZeusTransformUtils.wrapperContextForParams(r18, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r0, "context");
        Long r3 = null;
        if (PermissionActivity.f10338a.a(r0) == true) goto L58;
        return null;
    L58:
        Cursor r1 = ZeusProviderTransform.query(r0.getContentResolver(), CalendarContract.Calendars.CONTENT_URI, new String[]{"_id", "calendar_displayName", "account_name", "account_type", "isPrimary", "calendar_access_level"}, "calendar_access_level >= ?", new String[]{"500"}, null, "com.obric.memorydata.plugin");     // Catch: Exception -> L48
        if (r1 == null) goto L47;
        Closeable r2 = (Closeable) ZeusTransformUtils.preCheckCast(r1, Closeable.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L48
        Cursor r4 = (Cursor) ZeusTransformUtils.preCheckCast(r2, Cursor.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L38
        Long r5 = null;
        Long r6 = null;
        Long r7 = null;
    L56:
    L36:
        th = move-exception;
        r3 = r5;
        Throwable r8 = th;
    L66:
        throw r8;     // Catch: Throwable -> L41
    L41:
        th = move-exception;
        CloseableKt.closeFinally(r2, r8);     // Catch: Exception -> L45
        throw th;     // Catch: Exception -> L45
    L45:
        e = e;
    L50:
        RunLog.INSTANCE.error("CalendarWriteHelper", "getDefaultCalendarId error: " + e.getMessage(), (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
    L51:
        if (r3 != null) goto L77;
        if (r6 != null) goto L55;
        return r7;
    L55:
        return r6;
    L77:
        return r3;
    L12:
        if (r4.moveToNext() == false) goto L31;
        long r9 = r4.getLong(r4.getColumnIndexOrThrow("_id"));     // Catch: Throwable -> L36
        String r10 = r4.getString(r4.getColumnIndexOrThrow("account_type"));     // Catch: Throwable -> L36
        if (r10 != null) goto L16;
        r10 = "";
    L16:
        int r11 = r4.getInt(r4.getColumnIndexOrThrow("isPrimary"));     // Catch: Throwable -> L36
        if (r7 != null) goto L20;
        r7 = Long.valueOf(r9);     // Catch: Throwable -> L36
    L20:
        if (r11 != 1) goto L23;
        if (r5 != null) goto L23;
        r5 = Long.valueOf(r9);     // Catch: Throwable -> L36
    L23:
        if (r6 != null) goto L56;
        if (StringsKt.equals(r10, "LOCAL", true) == true) goto L30;
        if (StringsKt.contains((CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("GR", CharSequence.class, "com.obric.memorydata.plugin"), true) == true) goto L30;
        if (StringsKt.contains((CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("miui", CharSequence.class, "com.obric.memorydata.plugin"), true) == false) goto L56;
    L30:
        r6 = Long.valueOf(r9);     // Catch: Throwable -> L36
        goto L56
    L31:
        Unit r12 = Unit.INSTANCE;     // Catch: Throwable -> L36
        CloseableKt.closeFinally(r2, null);     // Catch: Exception -> L34
        r3 = r5;
    L34:
        e = e;
        r3 = r5;
    L38:
        th = move-exception;
        r8 = th;
        r6 = null;
        r7 = null;
        goto L66
    L47:
        r6 = null;
        r7 = null;
    L48:
        e = e;
        r6 = null;
        r7 = null;
        goto L50
    }

    public final List<PendingMemoryCalendar> a(List<PendingMemoryCalendar> r8) {
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, Constants.KEY_LIST);
        Iterable r9 = (Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.memorydata.plugin");
        Collection r1 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r10 = r9.iterator();
    L4:
        if (r10.hasNext() == false) goto L8;
        Object r2 = r10.next();
        if (f10204a.a((PendingMemoryCalendar) ZeusTransformUtils.preCheckCast(r2, PendingMemoryCalendar.class, "com.obric.memorydata.plugin")) == false) goto L4;
        r1.add(r2);
        goto L4
    L8:
        List<PendingMemoryCalendar> r11 = (List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.memorydata.plugin");
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "CalendarWriteHelper", "filterItems: input=" + r7.size() + ", output=" + r11.size() + ", filterTodo=" + f10205b, false, 4, null);
        return r11;
    }

    public final void a(Context r10, final PendingMemoryCalendar r11, Function1<? super C0501a, Unit> r12) {
        final Context r13 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.memorydata.plugin");
        final Function1 r14 = (Function1) ZeusTransformUtils.wrapperContextForParams(r12, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r13, "context");
        Intrinsics.checkNotNullParameter(r11, "item");
        Intrinsics.checkNotNullParameter(r14, "callback");
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "CalendarWriteHelper", "writeSingleEventWithPermission: title=" + q.f13259a.b(r11.getTitle()) + ", type=" + r11.getEventType(), false, 4, null);
        if (a(r11) == true) goto L7;
        r14.invoke(new C0501a(r11, false, null, null, "Item filtered by filterTodo switch", 12, null));
        return;
    L7:
        if (PermissionActivity.f10338a.a(r13) == false) goto L10;
        r14.invoke(a(r13, r11));
        return;
    L10:
        PermissionActivity.f10338a.a(r13, new $$Lambda$a$yxG4gJ_c2KXJR5KeXLlBZjyJiIk(r14, r13, r11));
    }

    public final void a(Context r8, List<PendingMemoryCalendar> r9, Function1<? super List<C0501a>, Unit> r10) {
        final Context r11 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.memorydata.plugin");
        List<PendingMemoryCalendar> r12 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.memorydata.plugin");
        final Function1 r13 = (Function1) ZeusTransformUtils.wrapperContextForParams(r10, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r11, "context");
        Intrinsics.checkNotNullParameter(r12, Constants.KEY_LIST);
        Intrinsics.checkNotNullParameter(r13, "callback");
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "CalendarWriteHelper", "writeEventsWithPermission: total=" + r12.size() + ", filterTodo=" + f10205b, false, 4, null);
        final List<PendingMemoryCalendar> r14 = a(r12);
        if (r14.isEmpty() == false) goto L7;
        r13.invoke(CollectionsKt.emptyList());
        return;
    L7:
        if (PermissionActivity.f10338a.a(r11) == false) goto L10;
        r13.invoke(a(r11, r14));
        return;
    L10:
        PermissionActivity.f10338a.a(r11, new $$Lambda$a$0xTaqnaKsFriBZwOE4gZ_A5w0c(r13, r11, r14));
    }

    public final boolean a() {
        return f10205b;
    }

    public final boolean a(PendingMemoryCalendar r4) {
        Intrinsics.checkNotNullParameter(r4, "item");
        boolean r0 = true;
        if (f10205b == true) goto L6;
    L9:
        RunLog.INSTANCE.debug("CalendarWriteHelper", "shouldIncludeItem: eventType=" + r4.getEventType() + ", filterTodo=" + f10205b + ", result=" + r0);
        return r0;
    L6:
        if (Intrinsics.areEqual(r4.getEventType(), PendingMemoryCalendar.TYPE_TODO) == false) goto L9;
        r0 = false;
        goto L9
    }
}
