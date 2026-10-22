package com.obric.memorydata.memory.island;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.bytedance.apm6.consumer.slardar.Constants;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.memorydata.database.entity.PendingMemoryCalendar;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001:\u00013B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\f\u001a\u00020\r2\u000e\b\u0004\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u000fH\u0082\bJ\b\u0010\u0010\u001a\u00020\u0011H\u0002J\u0006\u0010\u0012\u001a\u00020\u0013J\u0006\u0010\u0014\u001a\u00020\u0013J\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u00162\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016J\u001a\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00170\u00162\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016J\u000e\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u0017J\u001a\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00170\u00162\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016J\u000e\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u001e\u001a\u00020\u001fJR\u0010 \u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\u001f2B\u0010!\u001a>\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b(%\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00130&¢\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b('\u0012\u0004\u0012\u00020\r0\"J*\u0010(\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u001b\u001a\u00020\u00172\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020\r0)J6\u0010+\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\u001f2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u00162\u0018\u0010!\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020*0\u0016\u0012\u0004\u0012\u00020\r0)J\u0015\u0010,\u001a\u0004\u0018\u00010-2\u0006\u0010\u001e\u001a\u00020\u001f¢\u0006\u0002\u0010.J,\u0010/\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u001b\u001a\u00020\u00172\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020\r0)H\u0002J8\u00100\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\u001f2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u00162\u0018\u0010!\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020*0\u0016\u0012\u0004\u0012\u00020\r0)H\u0002J,\u00101\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u001b\u001a\u00020\u00172\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020\r0)H\u0002J8\u00102\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\u001f2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u00162\u0018\u0010!\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020*0\u0016\u0012\u0004\u0012\u00020\r0)H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0018\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\u00070\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u00064"}, d2 = {"Lcom/obric/memorydata/memory/island/CalendarWriteRouter;", "", "<init>", "()V", "TAG", "", "ioExecutor", "Ljava/util/concurrent/ExecutorService;", "kotlin.jvm.PlatformType", "Ljava/util/concurrent/ExecutorService;", "mainHandler", "Landroid/os/Handler;", "postToMain", "", "block", "Lkotlin/Function0;", "getImpl", "Lcom/obric/memorydata/memory/island/IslandRouter$IslandImpl;", "isVendorDevice", "", "isGRDevice", "filterForVendorDevice", "", "Lcom/obric/memorydata/database/entity/PendingMemoryCalendar;", Constants.KEY_LIST, "filterAll", "shouldIncludeItem", "item", "filterItems", "hasCalendarPermissions", "context", "Landroid/content/Context;", "requestCalendarPermissions", "callback", "Lkotlin/Function2;", "Lkotlin/ParameterName;", ActivityLifecycle.NAME, "allGranted", "", "results", "writeSingleEventWithPermission", "Lkotlin/Function1;", "Lcom/obric/memorydata/memory/island/CalendarWriteRouter$CalendarWriteResult;", "writeEventsWithPermission", "getDefaultCalendarId", "", "(Landroid/content/Context;)Ljava/lang/Long;", "writeViaCalendarUtil", "writeMultiViaCalendarUtil", "writeViaCalendarWriteHelper", "writeMultiViaCalendarWriteHelper", "CalendarWriteResult", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f10194a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ExecutorService f10195b = null;
    private static final Handler c = null;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\b\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nJ\b\u0010\u0011\u001a\u00020\u0007H\u0016J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0007HÆ\u0003J5\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00052\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\rR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/obric/memorydata/memory/island/CalendarWriteRouter$CalendarWriteResult;", "", "item", "Lcom/obric/memorydata/database/entity/PendingMemoryCalendar;", "isSuccess", "", "eventId", "", "error", "<init>", "(Lcom/obric/memorydata/database/entity/PendingMemoryCalendar;ZLjava/lang/String;Ljava/lang/String;)V", "getItem", "()Lcom/obric/memorydata/database/entity/PendingMemoryCalendar;", "()Z", "getEventId", "()Ljava/lang/String;", "getError", "toString", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final PendingMemoryCalendar f10196a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f10197b;
        private final String c;
        private final String d;

        public a(PendingMemoryCalendar r2, boolean r3, String r4, String r5) {
            Intrinsics.checkNotNullParameter(r2, "item");
            this.f10196a = r2;
            this.f10197b = r3;
            this.c = r4;
            this.d = r5;
        }

        public /* synthetic */ a(PendingMemoryCalendar r2, boolean r3, String r4, String r5, int r6, DefaultConstructorMarker r7) {
            if ((r6 & 4) == 0) goto L6;
            r4 = null;
        L6:
            if ((r6 & 8) == 0) goto L8;
            r5 = null;
        L8:
            this(r2, r3, r4, r5);
        }

        public final boolean a() {
            return this.f10197b;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f10196a, r6.f10196a) == true) goto L12;
            return false;
        L12:
            if (this.f10197b == r6.f10197b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r6.d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public int hashCode() {
            int r0 = ((this.f10196a.hashCode() * 31) + Boolean.hashCode(this.f10197b)) * 31;
            String r1 = this.c;
            int r2 = 0;
            if (r1 != null) goto L5;
            int r3 = 0;
        L6:
            int r4 = (r0 + r3) * 31;
            String r5 = this.d;
            if (r5 == null) goto L11;
            r2 = r5.hashCode();
        L11:
            return r4 + r2;
        L5:
            r3 = r1.hashCode();
            goto L6
        }

        public String toString() {
            return "CalendarWriteResult(isSuccess=" + this.f10197b + ", eventId=" + this.c + ", error=" + this.d + ')';
        }
    }

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f10198a = null;

        static {
            int[] r0 = new int[IslandRouter.IslandImpl.values().length];
            r0[IslandRouter.IslandImpl.OBRIC_OS.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[IslandRouter.IslandImpl.GR_GR.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[IslandRouter.IslandImpl.UNSUPPORTED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f10198a = r0;
        }
    }

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function1 f10199a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ List f10200b;

        public c(Function1 r3, List r4) {
            Function1 r5 = (Function1) ZeusTransformUtils.wrapperContextForParams(r3, Function1.class, "com.obric.memorydata.plugin");
            List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
            this.f10199a = r5;
            this.f10200b = r6;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f10199a.invoke(this.f10200b);
        }
    }

    static {
        f10194a = new d();
        f10195b = Executors.newSingleThreadExecutor($$Lambda$d$JGbFqr8ZWEcAwdTMSd9JXCNu1s.INSTANCE);
        c = new Handler(Looper.getMainLooper());
    }

    private d() {
    }

    private static final Thread a(Runnable r2) {
        Thread r0 = new Thread((Runnable) ZeusTransformUtils.wrapperContextForParams(r2, Runnable.class, "com.obric.memorydata.plugin"), "CalendarWriteRouter-IO");
        r0.setDaemon(true);
        return r0;
    }

    private static final Unit a(Function1 r10, List r11) {
        Function1 r12 = (Function1) ZeusTransformUtils.wrapperContextForParams(r10, Function1.class, "com.obric.memorydata.plugin");
        List r13 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r13, "helperResults");
        Iterable r14 = (Iterable) ZeusTransformUtils.preCheckCast(r13, Iterable.class, "com.obric.memorydata.plugin");
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r14, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r15 = r14.iterator();
    L4:
        if (r15.hasNext() == false) goto L10;
        com.obric.memorydata.memory.island.gr.a.C0501a r2 = (com.obric.memorydata.memory.island.gr.a.C0501a) ZeusTransformUtils.preCheckCast(r15.next(), com.obric.memorydata.memory.island.gr.a.C0501a.class, "com.obric.memorydata.plugin");
        PendingMemoryCalendar r4 = r2.a();
        boolean r5 = r2.b();
        Long r6 = r2.c();
        if (r6 == null) goto L8;
        String r7 = r6.toString();
    L9:
        r0.add(new a(r4, r5, r7, r2.d()));
        goto L4
    L8:
        r7 = null;
        goto L9
    L10:
        List r16 = (List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.memorydata.plugin");
        Iterable r1 = (Iterable) ZeusTransformUtils.preCheckCast(r16, Iterable.class, "com.obric.memorydata.plugin");
        int r3 = 0;
        if (ZeusTransformUtils.instanceOf(r1, Collection.class) == true) goto L13;
    L15:
        Iterator r8 = r1.iterator();
    L17:
        if (r8.hasNext() == false) goto L23;
        if (((a) ZeusTransformUtils.preCheckCast(r8.next(), a.class, "com.obric.memorydata.plugin")).a() == false) goto L17;
        r3 = r3 + 1;
        if (r3 >= 0) goto L17;
        CollectionsKt.throwCountOverflow();
    L23:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "CalendarWriteRouter", "writeMultiViaCalendarWriteHelper: done, " + r3 + '/' + r16.size() + " success", false, 4, null);
        r12.invoke(r16);
        return Unit.INSTANCE;
    L13:
        if (((Collection) ZeusTransformUtils.preCheckCast(r1, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L15;
        goto L15
    }

    private static final void a(List r17, Function1 r18) {
        List r2 = (List) ZeusTransformUtils.wrapperContextForParams(r17, List.class, "com.obric.memorydata.plugin");
        Function1 r3 = (Function1) ZeusTransformUtils.wrapperContextForParams(r18, Function1.class, "com.obric.memorydata.plugin");
        List r4 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        Iterator r5 = ((Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.memorydata.plugin")).iterator();
        int r6 = 0;
        int r7 = 0;
    L4:
        if (r5.hasNext() == false) goto L15;
        int r9 = r7 + 1;
        PendingMemoryCalendar r11 = (PendingMemoryCalendar) ZeusTransformUtils.preCheckCast(r5.next(), PendingMemoryCalendar.class, "com.obric.memorydata.plugin");
        RunLog.INSTANCE.debug("CalendarWriteRouter", "writeMultiViaCalendarUtil: writing " + r9 + '/' + r2.size());
        com.obric.memorydata.memory.calendar.a r0 = com.obric.memorydata.memory.calendar.b.f10085a.a(r11, true);     // Catch: Exception -> L12
        boolean r12 = r0.a();     // Catch: Exception -> L12
        String r13 = r0.b();     // Catch: Exception -> L12
        if (r0.a() == true) goto L9;
        String r1 = "CalendarUtil.writeToCalendarApp failed";
    L10:
        r4.add(new a(r11, r12, r13, r1));     // Catch: Exception -> L12
    L14:
        r7 = r9;
        goto L4
    L9:
        r1 = null;
    L12:
        e = move-exception;
        RunLog.INSTANCE.error("CalendarWriteRouter", "writeMultiViaCalendarUtil: exception for item[" + r7 + "]: " + e.getMessage(), (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        r4.add(new a(r11, false, null, "Exception: " + e.getMessage(), 4, null));
        goto L14
    L15:
        Iterable r8 = (Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r8, Collection.class) == true) goto L18;
    L20:
        Iterator r10 = r8.iterator();
    L22:
        if (r10.hasNext() == false) goto L28;
        if (((a) ZeusTransformUtils.preCheckCast(r10.next(), a.class, "com.obric.memorydata.plugin")).a() == false) goto L22;
        r6 = r6 + 1;
        if (r6 >= 0) goto L22;
        CollectionsKt.throwCountOverflow();
    L28:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "CalendarWriteRouter", "writeMultiViaCalendarUtil: done, " + r6 + '/' + r4.size() + " success", false, 4, null);
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L31;
        r3.invoke(r4);
        return;
    L31:
        c.post((Runnable) ZeusTransformUtils.preCheckCast(new c(r3, r4), Runnable.class, "com.obric.memorydata.plugin"));
        return;
    L18:
        if (((Collection) ZeusTransformUtils.preCheckCast(r8, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L20;
        goto L20
    }

    private final IslandRouter.IslandImpl b() {
        return IslandRouter.f10185a.a();
    }

    private final void b(Context r2, List<PendingMemoryCalendar> r3, Function1<? super List<a>, Unit> r4) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        final List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        final Function1 r6 = (Function1) ZeusTransformUtils.wrapperContextForParams(r4, Function1.class, "com.obric.memorydata.plugin");
        RunLog.INSTANCE.debug("CalendarWriteRouter", "writeMultiViaCalendarUtil: count=" + r5.size() + ", dispatch to ioExecutor");
        f10195b.execute(new $$Lambda$d$uZndibD2_ptrgIbpKsW0ju1j8KQ(r5, r6));
    }

    private final void c(Context r3, List<PendingMemoryCalendar> r4, Function1<? super List<a>, Unit> r5) {
        Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        List<PendingMemoryCalendar> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        final Function1 r7 = (Function1) ZeusTransformUtils.wrapperContextForParams(r5, Function1.class, "com.obric.memorydata.plugin");
        RunLog.INSTANCE.debug("CalendarWriteRouter", "writeMultiViaCalendarWriteHelper: count=" + r6.size());
        com.obric.memorydata.memory.island.gr.a.f10204a.a(r2, r6, new $$Lambda$d$k347A3cPJ4f5XRr09Q6d9Vm2T3A(r7));
    }

    /* JADX INFO: renamed from: lambda$JGbFqr8ZWEcAwdTMSd9J-XCNu1s, reason: not valid java name */
    public static /* synthetic */ Thread m714lambda$JGbFqr8ZWEcAwdTMSd9JXCNu1s(Runnable r0) {
        return a(r0);
    }

    public static /* synthetic */ Unit lambda$k347A3cPJ4f5XRr09Q6d9Vm2T3A(Function1 r0, List r1) {
        return a(r0, r1);
    }

    public static /* synthetic */ void lambda$uZndibD2_ptrgIbpKsW0ju1j8KQ(List r0, Function1 r1) {
        a(r0, r1);
    }

    public final List<PendingMemoryCalendar> a(List<PendingMemoryCalendar> r8) {
        List<PendingMemoryCalendar> r9 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r9, Constants.KEY_LIST);
        if (a() == true) goto L6;
        RunLog.INSTANCE.debug("CalendarWriteRouter", "filterItems: not vendor GR device, no TODO filtering, size=" + r9.size());
        return r9;
    L6:
        Iterable r7 = (Iterable) ZeusTransformUtils.preCheckCast(r9, Iterable.class, "com.obric.memorydata.plugin");
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r10 = r7.iterator();
    L8:
        if (r10.hasNext() == false) goto L12;
        Object r2 = r10.next();
        if (f10194a.a((PendingMemoryCalendar) ZeusTransformUtils.preCheckCast(r2, PendingMemoryCalendar.class, "com.obric.memorydata.plugin")) == false) goto L8;
        r0.add(r2);
        goto L8
    L12:
        List<PendingMemoryCalendar> r11 = (List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.memorydata.plugin");
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "CalendarWriteRouter", "filterItems: vendor GR device, input=" + r9.size() + ", output=" + r11.size(), false, 4, null);
        return r11;
    }

    public final void a(Context r9, List<PendingMemoryCalendar> r10, Function1<? super List<a>, Unit> r11) {
        Context r12 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin");
        List<PendingMemoryCalendar> r13 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.memorydata.plugin");
        Function1<? super List<a>, Unit> r14 = (Function1) ZeusTransformUtils.wrapperContextForParams(r11, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r12, "context");
        Intrinsics.checkNotNullParameter(r13, Constants.KEY_LIST);
        Intrinsics.checkNotNullParameter(r14, "callback");
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "CalendarWriteRouter", "writeEventsWithPermission: total=" + r13.size() + ", impl=" + b(), false, 4, null);
        List<PendingMemoryCalendar> r15 = a(r13);
        if (r15.isEmpty() == false) goto L6;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "CalendarWriteRouter", "writeEventsWithPermission: no items after filtering", false, 4, null);
        r14.invoke(CollectionsKt.emptyList());
        return;
    L6:
        int r0 = b.f10198a[b().ordinal()];
        if (r0 != 1) goto L9;
        b(r12, r15, r14);
        return;
    L9:
        if (r0 != 2) goto L11;
    L15:
        c(r12, r15, r14);
        return;
    L11:
        if (r0 != 3) goto L14;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "CalendarWriteRouter", "writeEventsWithPermission: UNSUPPORTED device, falling back to CalendarWriteHelper", false, 4, null);
        goto L15
    L14:
        throw new NoWhenBranchMatchedException();
    }

    public final boolean a() {
        if (b() != IslandRouter.IslandImpl.GR_GR) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean a(PendingMemoryCalendar r4) {
        Intrinsics.checkNotNullParameter(r4, "item");
        if (a() == true) goto L5;
        return true;
    L5:
        boolean r3 = !Intrinsics.areEqual(r4.getEventType(), PendingMemoryCalendar.TYPE_TODO);
        RunLog.INSTANCE.debug("CalendarWriteRouter", "shouldIncludeItem: eventType=" + r4.getEventType() + ", isVendorGR=true, result=" + r3);
        return r3;
    }
}
