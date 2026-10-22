package com.obric.memorydata.memory.island;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.capabilitykit.entity.memory.MemoryEntity;
import com.obric.livecard.api.ILiveCard;
import com.obric.memorydata.database.entity.PendingMemoryCalendar;
import com.obric.memorydata.memory.island.gr.e;
import com.obric.memorydata.memory.island.gr.f;
import com.obric.memorydata.memory.island.obric.IslandSessionUtils;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.device.DeviceInfoState;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0010\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001=B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\f\u001a\u00020\tJ\u0006\u0010\r\u001a\u00020\u000bJ\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0013JD\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\b\b\u0002\u0010\u001b\u001a\u00020\u000b2\u000e\b\u0002\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dJ\u000e\u0010\u001f\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u0005JN\u0010 \u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00172\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00190\u001d2\u000e\b\u0002\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00190\u001d2\b\b\u0002\u0010\u001b\u001a\u00020\u000b2\u000e\b\u0002\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dJ \u0010#\u001a\u00020\u000f2\u0006\u0010$\u001a\u00020%2\u0006\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u001b\u001a\u00020\u000bJ(\u0010&\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u00192\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00192\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dJ\u0006\u0010'\u001a\u00020\u000fJ\u000e\u0010(\u001a\u00020\u000fH\u0086@¢\u0006\u0002\u0010)J\b\u0010*\u001a\u0004\u0018\u00010\u0001J\u0006\u0010+\u001a\u00020\u000fJ\u0018\u0010,\u001a\u00020\u000f2\b\b\u0002\u0010-\u001a\u00020.H\u0086@¢\u0006\u0002\u0010/J \u00100\u001a\u00020\u000f2\u0006\u00101\u001a\u00020\u001e2\b\u00102\u001a\u0004\u0018\u00010\u0005H\u0086@¢\u0006\u0002\u00103J\u0006\u00104\u001a\u00020\u000fJ\u0006\u00105\u001a\u00020\u000fJ\u0006\u00106\u001a\u00020\u000fJ\u0010\u00107\u001a\u00020\u000f2\b\b\u0002\u00108\u001a\u00020\u000bJ\u0006\u00109\u001a\u00020\u000fJ\u0006\u0010:\u001a\u00020\u000fJ\u0010\u0010;\u001a\u00020\u000b2\u0006\u0010<\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006>"}, d2 = {"Lcom/obric/memorydata/memory/island/IslandRouter;", "", "<init>", "()V", "TAG", "", "KNOWN_GR_MODELS", "", "cachedImpl", "Lcom/obric/memorydata/memory/island/IslandRouter$IslandImpl;", "initialized", "", "getImpl", "isSupported", CommonConsts.APM_INNER_EVENT_COST_INIT, "", "application", "Landroid/app/Application;", "context", "Landroid/content/Context;", "showMemory", OaidModel.KEY_ID, "state", "", "entity", "Lcom/obric/capabilitykit/entity/memory/MemoryEntity;", "oldEntity", "needEffect", "calendars", "", "Lcom/obric/memorydata/database/entity/PendingMemoryCalendar;", "showMemoryCancelled", "showMemoryList", "entities", "oldEntities", "showBatchMemorySummary", "summary", "Lcom/obric/memorydata/memory/island/BatchMemoryIslandSummary;", "showCalendar", "showEffect", "destroyAll", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCurrentContent", "clearCurrentContent", "autoDismiss", "delayMs", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "showCalendarConfirm", "calendarItem", "eventUuid", "(Lcom/obric/memorydata/database/entity/PendingMemoryCalendar;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "mockTestBeginThenSuccess", "mockTestBeginThenSuccessWithCalendar", "mockTestBeginThenFailed", "mockTestShowMemoryFullPath", "withCalendar", "mockPrintSessionJson", "mockDestroyAll", "ensureInitialized", "caller", "IslandImpl", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class IslandRouter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final IslandRouter f10185a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Set<String> f10186b = null;
    private static volatile IslandImpl c;
    private static volatile boolean d;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/memorydata/memory/island/IslandRouter$IslandImpl;", "", "<init>", "(Ljava/lang/String;I)V", "OBRIC_OS", "GR_GR", "UNSUPPORTED", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final enum IslandImpl extends Enum<IslandImpl> {
        private static final /* synthetic */ EnumEntries $ENTRIES = null;
        private static final /* synthetic */ IslandImpl[] $VALUES = null;
        public static final IslandImpl GR_GR = null;
        public static final IslandImpl OBRIC_OS = null;
        public static final IslandImpl UNSUPPORTED = null;

        private static final /* synthetic */ IslandImpl[] $values() {
            return new IslandImpl[]{OBRIC_OS, GR_GR, UNSUPPORTED};
        }

        static {
            OBRIC_OS = new IslandImpl("OBRIC_OS", 0);
            GR_GR = new IslandImpl("GR_GR", 1);
            UNSUPPORTED = new IslandImpl("UNSUPPORTED", 2);
            IslandImpl[] r0 = $values();
            $VALUES = r0;
            $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
        }

        private IslandImpl(String r1, int r2) {
            super(r1, r2);
        }

        public static EnumEntries<IslandImpl> getEntries() {
            return $ENTRIES;
        }

        public static IslandImpl valueOf(String r2) {
            return (IslandImpl) ZeusTransformUtils.preCheckCast(Enum.valueOf(IslandImpl.class, r2), IslandImpl.class, "com.obric.memorydata.plugin");
        }

        public static IslandImpl[] values() {
            return (IslandImpl[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), IslandImpl[].class, "com.obric.memorydata.plugin");
        }
    }

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f10187a = null;

        static {
            int[] r0 = new int[IslandImpl.values().length];
            r0[IslandImpl.OBRIC_OS.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[IslandImpl.GR_GR.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[IslandImpl.UNSUPPORTED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f10187a = r0;
        }
    }

    static {
        f10185a = new IslandRouter();
        f10186b = SetsKt.setOf(new String[]{"Genesis-R", "genesis", "pacific", "nerida", "nerida-lite"});
    }

    private IslandRouter() {
    }

    public static /* synthetic */ void a(IslandRouter r7, String r8, int r9, MemoryEntity r10, MemoryEntity r11, boolean r12, List r13, int r14, Object r15) {
        List<PendingMemoryCalendar> r16 = (List) ZeusTransformUtils.wrapperContextForParams(r13, List.class, "com.obric.memorydata.plugin");
        if ((r14 & 16) == 0) goto L5;
        r12 = true;
    L5:
        boolean r5 = r12;
        if ((r14 & 32) == 0) goto L8;
        r16 = CollectionsKt.emptyList();
    L8:
        r7.a(r8, r9, r10, r11, r5, r16);
    }

    private final boolean b(String r11) {
        if (d == false) goto L5;
        return true;
    L5:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "IslandRouter", r11 + ": IslandRouter.init() has NOT been called, try init now", null, 4, null);
        a((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getApplication(), "com.obric.memorydata.plugin"), Application.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L12
        if (d == true) goto L11;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "IslandRouter", r11 + ": IslandRouter is still not initialized, skip island call", null, 4, null);
        return false;
    L11:
        return true;
    L12:
        th = move-exception;
        RunLog.INSTANCE.error("IslandRouter", r11 + ": IslandRouter init failed, skip island call", th);
        return false;
    }

    public final IslandImpl a() {
        IslandImpl r4 = c;
        if (r4 == null) goto L5;
        return r4;
    L5:
        String r5 = DeviceInfoState.INSTANCE.getDeviceModel();
        if (DeviceInfoState.INSTANCE.isObricOsDevice() == false) goto L9;
        RunLog.INSTANCE.debug("IslandRouter", "getImpl: ObricOS device → OBRIC_OS");
        IslandImpl r6 = IslandImpl.OBRIC_OS;
    L12:
        c = r6;
        return r6;
    L9:
        if (f10186b.contains(r5) == false) goto L11;
        RunLog.INSTANCE.debug("IslandRouter", "getImpl: deviceModel=" + r5 + " → GR_GR");
        r6 = IslandImpl.GR_GR;
        goto L12
    L11:
        RunLog.INSTANCE.debug("IslandRouter", "getImpl: deviceModel=" + r5 + ", buildModel=" + Build.MODEL + ", isObricOs=" + DeviceInfoState.INSTANCE.isObricOsDevice() + " → UNSUPPORTED");
        r6 = IslandImpl.UNSUPPORTED;
        goto L12
    }

    public final synchronized void a(Application r9) {
        monitor-enter(this);
        Application r10 = (Application) ZeusTransformUtils.wrapperContextForParams(r9, Application.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L33
        Intrinsics.checkNotNullParameter(r10, "application");     // Catch: Throwable -> L33
        if (d == false) goto L8;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "IslandRouter", "init: already initialized, skipping", null, 4, null);     // Catch: Throwable -> L33
        monitor-exit(this);
        return;
    L8:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "IslandRouter", "init: impl=" + a() + ", deviceModel=" + DeviceInfoState.INSTANCE.getDeviceModel() + ", buildModel=" + Build.MODEL + ", pkg=" + r10.getPackageName(), false, 4, null);     // Catch: Throwable -> L33
        int r0 = a.f10187a[a().ordinal()];     // Catch: Throwable -> L33
        if (r0 != 1) goto L11;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "IslandRouter", "init: initializing ILiveCard SDK ...", false, 4, null);     // Catch: Throwable -> L33
        ILiveCard.Companion.getInst().init(r10);     // Catch: Throwable -> L29
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "IslandRouter", "init: ILiveCard SDK initialized successfully", false, 4, null);     // Catch: Throwable -> L29
        d = true;     // Catch: Throwable -> L29
    L26:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "IslandRouter", "init: DONE", false, 4, null);     // Catch: Throwable -> L33
        monitor-exit(this);
        return;
    L29:
        th = move-exception;
        RunLog.INSTANCE.error("IslandRouter", "init: ILiveCard SDK init failed: " + th.getMessage(), th);     // Catch: Throwable -> L33
        return;
    L11:
        if (r0 != 2) goto L13;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "IslandRouter", "init: initializing IslandNotificationManager (GR) ...", false, 4, null);     // Catch: Throwable -> L33
        e.f10211a.a((Context) ZeusTransformUtils.preCheckCast(r10, Context.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L20
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "IslandRouter", "init: IslandNotificationManager initialized successfully", false, 4, null);     // Catch: Throwable -> L20
        d = true;     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        RunLog.INSTANCE.error("IslandRouter", "init: IslandNotificationManager init failed: " + th.getMessage(), th);     // Catch: Throwable -> L33
        return;
    L13:
        if (r0 != 3) goto L16;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "IslandRouter", "init: device not supported, no initialization needed", false, 4, null);     // Catch: Throwable -> L33
        d = true;     // Catch: Throwable -> L33
        goto L26
    L16:
        throw new NoWhenBranchMatchedException();     // Catch: Throwable -> L33
    L33:
        th = move-exception;
        throw th;
    }

    public final void a(MemoryEntity r9, MemoryEntity r10, List<PendingMemoryCalendar> r11) {
        List<PendingMemoryCalendar> r12 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r9, "entity");
        Intrinsics.checkNotNullParameter(r12, "calendars");
        if (b("showCalendar") == true) goto L5;
        return;
    L5:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "IslandRouter", "showCalendar: entity.type=" + r9.getType() + ", calendars.size=" + r12.size() + ", impl=" + a(), false, 4, null);
        int r8 = a.f10187a[a().ordinal()];
        if (r8 != 1) goto L8;
        IslandSessionUtils.f10217a.a(r9, r10, r12);
        return;
    L8:
        if (r8 != 2) goto L10;
        f.f10213a.a(r9, r10, r12);
        return;
    L10:
        if (r8 != 3) goto L13;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "IslandRouter", "showCalendar: device not supported, skipping", false, 4, null);
        return;
    L13:
        throw new NoWhenBranchMatchedException();
    }

    public final void a(c r10, int r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r10, "summary");
        if (b("showBatchMemorySummary") == true) goto L5;
        return;
    L5:
        IRunLog r3 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r0 = new StringBuilder().append("showBatchMemorySummary: id=").append(r10.a()).append(", state=").append(r11).append(", total=").append(r10.b()).append(", success=").append(r10.f()).append(", failure=").append(r10.c()).append(", items=");
        Iterable r1 = (Iterable) ZeusTransformUtils.preCheckCast(r10.d(), Iterable.class, "com.obric.memorydata.plugin");
        Map r4 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        Iterator r2 = r1.iterator();
    L7:
        if (r2.hasNext() == false) goto L12;
        Object r5 = r2.next();
        BatchMemoryIslandKind r6 = ((b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.memorydata.plugin")).a();
        Object r7 = r4.get(r6);
        if (r7 != null) goto L11;
        r7 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        r4.put(r6, r7);
    L11:
        ((List) ZeusTransformUtils.preCheckCast(r7, List.class, "com.obric.memorydata.plugin")).add(r5);
        goto L7
    L12:
        Map r8 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(MapsKt.mapCapacity(r4.size())), Map.class, "com.obric.memorydata.plugin");
        Iterator r9 = ((Iterable) ZeusTransformUtils.preCheckCast(r4.entrySet(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L14:
        if (r9.hasNext() == false) goto L16;
        Object r13 = r9.next();
        r8.put(((Map.Entry) ZeusTransformUtils.preCheckCast(r13, Map.Entry.class, "com.obric.memorydata.plugin")).getKey(), Integer.valueOf(((List) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r13, Map.Entry.class, "com.obric.memorydata.plugin")).getValue(), List.class, "com.obric.memorydata.plugin")).size()));
        goto L14
    L16:
        IRunLog.a.a(r3, "IslandRouter", r0.append(r8).append(", impl=").append(a()).toString(), false, 4, null);
        IslandImpl r14 = a();
        int r15 = a.f10187a[r14.ordinal()];
        if (r15 != 1) goto L19;
        IslandSessionUtils.f10217a.a(r10, r11, r12);
        return;
    L19:
        if (r15 != 2) goto L21;
        f.f10213a.a(r10, r11, r12);
        return;
    L21:
        if (r15 != 3) goto L24;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "IslandRouter", "showBatchMemorySummary: device not supported, skipping", false, 4, null);
        return;
    L24:
        throw new NoWhenBranchMatchedException();
    }

    public final void a(String r8) {
        Intrinsics.checkNotNullParameter(r8, OaidModel.KEY_ID);
        if (b("showMemoryCancelled") == true) goto L5;
        return;
    L5:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "IslandRouter", "showMemoryCancelled: id=" + r8 + ", impl=" + a(), false, 4, null);
        int r7 = a.f10187a[a().ordinal()];
        if (r7 != 1) goto L8;
        IslandSessionUtils.f10217a.a(r8);
        return;
    L8:
        if (r7 != 2) goto L10;
        f.f10213a.a(r8);
        return;
    L10:
        if (r7 != 3) goto L13;
        return;
    L13:
        throw new NoWhenBranchMatchedException();
    }

    public final void a(String r10, int r11, MemoryEntity r12, MemoryEntity r13, boolean r14, List<PendingMemoryCalendar> r15) {
        List<PendingMemoryCalendar> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r15, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r10, OaidModel.KEY_ID);
        Intrinsics.checkNotNullParameter(r8, "calendars");
        if (b("showMemory") == true) goto L5;
        return;
    L5:
        IRunLog r2 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r16 = new StringBuilder().append("showMemory: id=").append(r10).append(", state=").append(r11).append(", entity.type=");
        if (r12 == null) goto L8;
        Object r0 = Integer.valueOf(r12.getType());
    L9:
        IRunLog.a.a(r2, "IslandRouter", r16.append(r0).append(", calendars.size=").append(r8.size()).append(", impl=").append(a()).toString(), false, 4, null);
        IslandImpl r9 = a();
        int r17 = a.f10187a[r9.ordinal()];
        if (r17 != 1) goto L12;
        IslandSessionUtils.f10217a.a(r10, r11, r12, r13, r14, r8);
        return;
    L12:
        if (r17 != 2) goto L14;
        f.f10213a.a(r10, r11, r12, r13, r14, r8);
        return;
    L14:
        if (r17 != 3) goto L17;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "IslandRouter", "showMemory: device not supported, skipping", false, 4, null);
        return;
    L17:
        throw new NoWhenBranchMatchedException();
    L8:
        r0 = "null";
        goto L9
    }

    public final void b() {
        if (b("showEffect") == true) goto L5;
        return;
    L5:
        RunLog.INSTANCE.debug("IslandRouter", "showEffect: impl=" + a());
        int r3 = a.f10187a[a().ordinal()];
        if (r3 != 1) goto L8;
        IslandSessionUtils.f10217a.a();
        return;
    L8:
        if (r3 != 2) goto L10;
        f.f10213a.a();
        return;
    L10:
        if (r3 != 3) goto L13;
        RunLog.INSTANCE.debug("IslandRouter", "showEffect: device not supported, skipping");
        return;
    L13:
        throw new NoWhenBranchMatchedException();
    }
}
