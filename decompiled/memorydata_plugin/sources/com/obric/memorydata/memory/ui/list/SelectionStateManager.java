package com.obric.memorydata.memory.ui.list;

import com.bytedance.apm6.hub.config.internal.SlardarSettingsConstants;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.crash.entity.EventBody;
import com.obric.memorydata.database.entity.cu;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u0002\n\u0002\b\u0014\u0018\u0000 =2\u00020\u0001:\u0002=>B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\u00142\u0006\u0010-\u001a\u00020\u001aJ\b\u0010.\u001a\u00020+H\u0002J\u000e\u0010/\u001a\u00020+2\u0006\u0010,\u001a\u00020\u0014J\u000e\u00100\u001a\u00020\u001a2\u0006\u0010,\u001a\u00020\u0014J\u0006\u00101\u001a\u00020+J\u0006\u00102\u001a\u00020+J\u0006\u00103\u001a\u00020+J\u0016\u00104\u001a\u00020\n2\u0006\u00105\u001a\u00020\u00062\u0006\u00106\u001a\u00020\u0014J\u001e\u00104\u001a\u00020\n2\u0006\u00105\u001a\u00020\u00062\u0006\u00106\u001a\u00020\u00142\u0006\u00107\u001a\u00020\u0014J\u0016\u00108\u001a\u00020\n2\u0006\u00109\u001a\u00020\u00142\u0006\u00106\u001a\u00020\u0014J\u0006\u0010:\u001a\u00020+J\u0006\u0010;\u001a\u00020+J\u0006\u0010<\u001a\u00020+R\u0019\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\f¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\rR\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\f¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u001d\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00060\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u001d\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00060\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016R\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\f¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\rR\u000e\u0010\u001d\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u001f\u001a\u00020\u00142\u0006\u0010\u001e\u001a\u00020\u0014@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001a\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u001a0\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010%\u001a\u00020\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)¨\u0006?"}, d2 = {"Lcom/obric/memorydata/memory/ui/list/SelectionStateManager;", "", "<init>", "()V", "detailMetaInfo", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/obric/memorydata/database/entity/MemoryMetaInfo;", "getDetailMetaInfo", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "_isEditMode", "", "isEditMode", "Lkotlinx/coroutines/flow/StateFlow;", "()Lkotlinx/coroutines/flow/StateFlow;", "_selectAllState", "Lcom/obric/memorydata/memory/ui/list/SelectionStateManager$SelectAllState;", "selectAllState", "getSelectAllState", "selectedItems", "Ljava/util/concurrent/ConcurrentHashMap;", "", "getSelectedItems", "()Ljava/util/concurrent/ConcurrentHashMap;", "deselectedItems", "getDeselectedItems", "_selectedCount", "", "selectedCount", "getSelectedCount", "lock", EventBody.KEY_VALUE, "currentTab", "getCurrentTab", "()Ljava/lang/String;", "setCurrentTab", "(Ljava/lang/String;)V", "totalCounts", "totalCount", "getTotalCount", "()I", "setTotalCount", "(I)V", "setTotalCounts", "", "key", CommonConsts.COUNT_TYPE, "reconcileStateAfterTotalCountChange", "removeTotalCount", "queryTotalCount", "enterEditMode", "exitEditMode", SlardarSettingsConstants.SETTING_GENERAL_CLEANUP, "toggleSelection", "memoryMetaInfo", LocationMonitorConst.TAG, "selectionKey", "isSelected", "itemId", "toggleSelectAll", "updateSelectedCount", "checkSelectAllState", "Companion", "SelectAllState", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SelectionStateManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f11168a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final kotlinx.coroutines.flow.ae<cu> f11169b;
    private final kotlinx.coroutines.flow.ae<Boolean> c;
    private final kotlinx.coroutines.flow.ar<Boolean> d;
    private final kotlinx.coroutines.flow.ae<SelectAllState> e;
    private final kotlinx.coroutines.flow.ar<SelectAllState> f;
    private final ConcurrentHashMap<String, cu> g;
    private final ConcurrentHashMap<String, cu> h;
    private final kotlinx.coroutines.flow.ae<Integer> i;
    private final kotlinx.coroutines.flow.ar<Integer> j;
    private final Object k;
    private volatile String l;
    private ConcurrentHashMap<String, Integer> m;
    private volatile int n;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/obric/memorydata/memory/ui/list/SelectionStateManager$SelectAllState;", "", "<init>", "(Ljava/lang/String;I)V", "NONE", "ALL_SELECTED", "PARTIAL_UNSELECTED", "PARTIAL_SELECTED", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final enum SelectAllState extends Enum<SelectAllState> {
        private static final /* synthetic */ EnumEntries $ENTRIES = null;
        private static final /* synthetic */ SelectAllState[] $VALUES = null;
        public static final SelectAllState ALL_SELECTED = null;
        public static final SelectAllState NONE = null;
        public static final SelectAllState PARTIAL_SELECTED = null;
        public static final SelectAllState PARTIAL_UNSELECTED = null;

        private static final /* synthetic */ SelectAllState[] $values() {
            return new SelectAllState[]{NONE, ALL_SELECTED, PARTIAL_UNSELECTED, PARTIAL_SELECTED};
        }

        static {
            NONE = new SelectAllState("NONE", 0);
            ALL_SELECTED = new SelectAllState("ALL_SELECTED", 1);
            PARTIAL_UNSELECTED = new SelectAllState("PARTIAL_UNSELECTED", 2);
            PARTIAL_SELECTED = new SelectAllState("PARTIAL_SELECTED", 3);
            SelectAllState[] r0 = $values();
            $VALUES = r0;
            $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
        }

        private SelectAllState(String r1, int r2) {
            super(r1, r2);
        }

        public static EnumEntries<SelectAllState> getEntries() {
            return $ENTRIES;
        }

        public static SelectAllState valueOf(String r2) {
            return (SelectAllState) ZeusTransformUtils.preCheckCast(Enum.valueOf(SelectAllState.class, r2), SelectAllState.class, "com.obric.memorydata.plugin");
        }

        public static SelectAllState[] values() {
            return (SelectAllState[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), SelectAllState[].class, "com.obric.memorydata.plugin");
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\u0006\u001a\u00020\u00052\u0012\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\b\"\u00020\u0005¢\u0006\u0002\u0010\tJ\u0016\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/obric/memorydata/memory/ui/list/SelectionStateManager$Companion;", "", "<init>", "()V", "TAG", "", "generateKey", "keys", "", "([Ljava/lang/String;)Ljava/lang/String;", "generateSourceSelectionKey", "sourcePrefix", "entityId", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public final String a(String r1, String r2) {
            Intrinsics.checkNotNullParameter(r1, "sourcePrefix");
            Intrinsics.checkNotNullParameter(r2, "entityId");
            return r1 + ':' + r2;
        }

        public final String a(String... r10) {
            Intrinsics.checkNotNullParameter(r10, "keys");
            return ArraysKt.joinToString$default(r10, (CharSequence) ZeusTransformUtils.preCheckCast("_", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, null, 62, null);
        }
    }

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f11170a = null;

        static {
            int[] r0 = new int[SelectAllState.values().length];
            r0[SelectAllState.ALL_SELECTED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r0[SelectAllState.PARTIAL_UNSELECTED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r0[SelectAllState.PARTIAL_SELECTED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[SelectAllState.NONE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            f11170a = r0;
        }
    }

    static {
        f11168a = new a(null);
    }

    public SelectionStateManager() {
        this.f11169b = kotlinx.coroutines.flow.at.a(null);
        kotlinx.coroutines.flow.ae<Boolean> r1 = kotlinx.coroutines.flow.at.a(false);
        this.c = r1;
        this.d = kotlinx.coroutines.flow.k.a(r1);
        kotlinx.coroutines.flow.ae<SelectAllState> r2 = kotlinx.coroutines.flow.at.a(SelectAllState.NONE);
        this.e = r2;
        this.f = kotlinx.coroutines.flow.k.a(r2);
        this.g = new ConcurrentHashMap();
        this.h = new ConcurrentHashMap();
        kotlinx.coroutines.flow.ae<Integer> r3 = kotlinx.coroutines.flow.at.a(0);
        this.i = r3;
        this.j = kotlinx.coroutines.flow.k.a(r3);
        this.k = new Object();
        this.l = f11168a.a(new String[0]);
        this.m = new ConcurrentHashMap();
    }

    private final void o() {
        if (((Boolean) ZeusTransformUtils.preCheckCast(this.c.c(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == true) goto L5;
        return;
    L5:
        SelectAllState r0 = (SelectAllState) ZeusTransformUtils.preCheckCast(this.e.c(), SelectAllState.class, "com.obric.memorydata.plugin");
        int r1 = b.f11170a[r0.ordinal()];
        if (r1 != 1) goto L8;
        return;
    L8:
        if (r1 == 2) goto L25;
        if (r1 == 3) goto L17;
        if (r1 != 4) goto L15;
        return;
    L15:
        throw new NoWhenBranchMatchedException();
    L17:
        if (this.n <= 0) goto L22;
        if (this.g.size() < this.n) goto L22;
        this.g.clear();
        this.h.clear();
        kotlinx.coroutines.flow.ae<SelectAllState> r3 = this.e;
        SelectAllState r2 = SelectAllState.ALL_SELECTED;
    L28:
        r3.b(r2);
        return;
    L22:
        if (this.g.isEmpty() == false) goto L33;
    L27:
        r3 = this.e;
        r2 = SelectAllState.NONE;
        goto L28
    L33:
        return;
    L25:
        if (this.n > 0) goto L30;
    L26:
        this.g.clear();
        this.h.clear();
        goto L27
    L30:
        if (this.h.size() >= this.n) goto L26;
    }

    public final kotlinx.coroutines.flow.ae<cu> a() {
        return this.f11169b;
    }

    public final void a(int r1) {
        this.n = r1;
    }

    public final void a(String r9) {
        Intrinsics.checkNotNullParameter(r9, EventBody.KEY_VALUE);
        Object r0 = this.k;
        monitor-enter(r0);
        this.l = r9;     // Catch: Throwable -> L7
        Integer r1 = this.m.getOrDefault(r9, 0);     // Catch: Throwable -> L7
        Intrinsics.checkNotNullExpressionValue(r1, "getOrDefault(...)");     // Catch: Throwable -> L7
        this.n = ((Number) ZeusTransformUtils.preCheckCast(r1, Number.class, "com.obric.memorydata.plugin")).intValue();     // Catch: Throwable -> L7
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "SelectionStateManager", "currentTab: " + r9 + ", totalCounts: " + this.m + ", totalCount: " + this.n, false, 4, null);     // Catch: Throwable -> L7
        m();     // Catch: Throwable -> L7
        Unit r8 = Unit.INSTANCE;     // Catch: Throwable -> L7
        monitor-exit(r0);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public final void a(String r9, int r10) {
        Intrinsics.checkNotNullParameter(r9, "key");
        Object r0 = this.k;
        monitor-enter(r0);
        ((Map) ZeusTransformUtils.preCheckCast(this.m, Map.class, "com.obric.memorydata.plugin")).put(r9, Integer.valueOf(r10));     // Catch: Throwable -> L20
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "SelectionStateManager", "setTotalCounts: " + r9 + ", " + r10 + ", currentTab: " + this.l, false, 4, null);     // Catch: Throwable -> L20
        if (Intrinsics.areEqual(r9, this.l) == true) goto L7;
    L17:
        Unit r8 = Unit.INSTANCE;     // Catch: Throwable -> L20
        monitor-exit(r0);
        return;
    L7:
        if (((Boolean) ZeusTransformUtils.preCheckCast(this.c.c(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L16;
        if (r10 != 0) goto L16;
        if (this.n <= 0) goto L16;
        if (this.e.c() == SelectAllState.NONE) goto L16;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "SelectionStateManager", "setTotalCounts ignored transient zero: tab=" + this.l + ", oldTotalCount=" + this.n + ", state=" + this.e.c() + ", selectedCount=" + ((Number) ZeusTransformUtils.preCheckCast(this.i.c(), Number.class, "com.obric.memorydata.plugin")).intValue(), false, 4, null);     // Catch: Throwable -> L20
        monitor-exit(r0);
        return;
    L16:
        this.n = r10;     // Catch: Throwable -> L20
        o();     // Catch: Throwable -> L20
        m();     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        throw th;
    }

    public final boolean a(cu r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "memoryMetaInfo");
        Intrinsics.checkNotNullParameter(r3, LocationMonitorConst.TAG);
        return a(r2, r3, r2.a());
    }

    public final boolean a(cu r10, String r11, String r12) {
        Intrinsics.checkNotNullParameter(r10, "memoryMetaInfo");
        Intrinsics.checkNotNullParameter(r11, LocationMonitorConst.TAG);
        Intrinsics.checkNotNullParameter(r12, "selectionKey");
        Object r0 = this.k;
        monitor-enter(r0);
        boolean r1 = a(r12, "SelectionStateManager");     // Catch: Throwable -> L27
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "SelectionStateManager", r11 + " before toggleSelection: _selectAllState: " + this.e.c() + ", itemId: " + r10.a() + ", selectedIds: " + this.g.keySet() + ", deselectedIds: " + this.h.keySet(), false, 4, null);     // Catch: Throwable -> L27
        int r13 = b.f11170a[((SelectAllState) ZeusTransformUtils.preCheckCast(this.e.c(), SelectAllState.class, "com.obric.memorydata.plugin")).ordinal()];     // Catch: Throwable -> L27
        if (r13 != 1) goto L7;
    L20:
        if (r1 == false) goto L22;
        Map r14 = (Map) ZeusTransformUtils.preCheckCast(this.h, Map.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L27
    L19:
        r14.put(r12, r10);     // Catch: Throwable -> L27
    L23:
        n();     // Catch: Throwable -> L27
        m();     // Catch: Throwable -> L27
        boolean r9 = !r1;
        monitor-exit(r0);
        return r9;
    L22:
        ConcurrentHashMap<String, cu> r15 = this.h;     // Catch: Throwable -> L27
    L17:
        r15.remove(r12);     // Catch: Throwable -> L27
        goto L23
    L7:
        if (r13 == 2) goto L20;
        if (r13 != 3) goto L11;
    L15:
        if (r1 == false) goto L18;
        r15 = this.g;     // Catch: Throwable -> L27
        goto L17
    L18:
        r14 = (Map) ZeusTransformUtils.preCheckCast(this.g, Map.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L27
        goto L19
    L11:
        if (r13 == 4) goto L15;
        throw new NoWhenBranchMatchedException();     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        throw th;
    }

    public final boolean a(String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "itemId");
        Intrinsics.checkNotNullParameter(r11, LocationMonitorConst.TAG);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "SelectionStateManager", r11 + " _selectAllState: " + this.e.c() + ", itemId: " + r10 + ", selectedIds: " + this.g.keySet() + ", deselectedIds: " + this.h.keySet(), false, 4, null);
        int r12 = b.f11170a[((SelectAllState) ZeusTransformUtils.preCheckCast(this.e.c(), SelectAllState.class, "com.obric.memorydata.plugin")).ordinal()];
        if (r12 == 1) goto L17;
        if (r12 == 2) goto L15;
        if (r12 == 3) goto L18;
        if (r12 != 4) goto L12;
        return false;
    L12:
        throw new NoWhenBranchMatchedException();
    L18:
        return this.g.containsKey(r10);
    L15:
        if (this.h.containsKey(r10) == false) goto L17;
        return false;
    L17:
        return true;
    }

    public final kotlinx.coroutines.flow.ar<Boolean> b() {
        return this.d;
    }

    public final void b(String r3) {
        Intrinsics.checkNotNullParameter(r3, "key");
        Object r0 = this.k;
        monitor-enter(r0);
        this.m.remove(r3);     // Catch: Throwable -> L10
        if (Intrinsics.areEqual(r3, this.l) == false) goto L7;
        this.n = 0;     // Catch: Throwable -> L10
        m();     // Catch: Throwable -> L10
    L7:
        Unit r2 = Unit.INSTANCE;     // Catch: Throwable -> L10
        monitor-exit(r0);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public final int c(String r2) {
        Intrinsics.checkNotNullParameter(r2, "key");
        Integer r1 = this.m.getOrDefault(r2, 0);
        Intrinsics.checkNotNullExpressionValue(r1, "getOrDefault(...)");
        return ((Number) ZeusTransformUtils.preCheckCast(r1, Number.class, "com.obric.memorydata.plugin")).intValue();
    }

    public final kotlinx.coroutines.flow.ar<SelectAllState> c() {
        return this.f;
    }

    public final ConcurrentHashMap<String, cu> d() {
        return this.g;
    }

    public final ConcurrentHashMap<String, cu> e() {
        return this.h;
    }

    public final kotlinx.coroutines.flow.ar<Integer> f() {
        return this.j;
    }

    public final String g() {
        return this.l;
    }

    public final int h() {
        return this.n;
    }

    public final void i() {
        Object r0 = this.k;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (((Boolean) ZeusTransformUtils.preCheckCast(this.c.c(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L8;
        monitor-exit(r0);
        return;
    L8:
        k();     // Catch: Throwable -> L11
        this.c.b(true);     // Catch: Throwable -> L11
        Unit r4 = Unit.INSTANCE;     // Catch: Throwable -> L11
        monitor-exit(r0);
    }

    public final void j() {
        if (((Boolean) ZeusTransformUtils.preCheckCast(this.c.c(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L15;
        Object r0 = this.k;
        monitor-enter(r0);
    L12:
        th = move-exception;
        throw th;
    L7:
        if (((Boolean) ZeusTransformUtils.preCheckCast(this.c.c(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L9;
        this.c.b(false);     // Catch: Throwable -> L12
        k();     // Catch: Throwable -> L12
    L9:
        Unit r4 = Unit.INSTANCE;     // Catch: Throwable -> L12
        monitor-exit(r0);
        return;
    }

    public final void k() {
        this.g.clear();
        this.h.clear();
        this.e.b(SelectAllState.NONE);
        this.i.b(0);
    }

    public final void l() {
        Object r0 = this.k;
        monitor-enter(r0);
        SelectAllState r1 = (SelectAllState) ZeusTransformUtils.preCheckCast(this.e.c(), SelectAllState.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L18
        int r2 = ((Number) ZeusTransformUtils.preCheckCast(this.i.c(), Number.class, "com.obric.memorydata.plugin")).intValue();     // Catch: Throwable -> L18
        if (b.f11170a[((SelectAllState) ZeusTransformUtils.preCheckCast(this.e.c(), SelectAllState.class, "com.obric.memorydata.plugin")).ordinal()] != 1) goto L8;
        this.g.clear();     // Catch: Throwable -> L18
        this.h.clear();     // Catch: Throwable -> L18
        kotlinx.coroutines.flow.ae<SelectAllState> r3 = this.e;     // Catch: Throwable -> L18
        SelectAllState r4 = SelectAllState.NONE;     // Catch: Throwable -> L18
    L7:
        r3.b(r4);     // Catch: Throwable -> L18
        m();     // Catch: Throwable -> L18
        if (this.e.c() == SelectAllState.ALL_SELECTED) goto L12;
    L15:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "SelectionStateManager", "toggleSelectAll: tab=" + this.l + ", beforeState=" + r1 + ", afterState=" + this.e.c() + ", beforeCount=" + r2 + ", afterCount=" + ((Number) ZeusTransformUtils.preCheckCast(this.i.c(), Number.class, "com.obric.memorydata.plugin")).intValue() + ", totalCount=" + this.n, false, 4, null);     // Catch: Throwable -> L18
        Unit r10 = Unit.INSTANCE;     // Catch: Throwable -> L18
        monitor-exit(r0);
        return;
    L12:
        if (((Number) ZeusTransformUtils.preCheckCast(this.i.c(), Number.class, "com.obric.memorydata.plugin")).intValue() != 0) goto L15;
        if (r2 <= 0) goto L15;
        this.i.b(Integer.valueOf(r2));     // Catch: Throwable -> L18
        goto L15
    L8:
        this.g.clear();     // Catch: Throwable -> L18
        this.h.clear();     // Catch: Throwable -> L18
        r3 = this.e;     // Catch: Throwable -> L18
        r4 = SelectAllState.ALL_SELECTED;     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        throw th;
    }

    public final void m() {
        kotlinx.coroutines.flow.ae<Integer> r0 = this.i;
        SelectAllState r1 = (SelectAllState) ZeusTransformUtils.preCheckCast(this.e.c(), SelectAllState.class, "com.obric.memorydata.plugin");
        int r2 = b.f11170a[r1.ordinal()];
        int r3 = 0;
        if (r2 != 1) goto L5;
        r3 = RangesKt.coerceAtLeast(this.n, 0);
    L16:
        r0.b(Integer.valueOf(r3));
        return;
    L5:
        if (r2 != 2) goto L7;
        r3 = RangesKt.coerceAtLeast(this.n - this.h.size(), 0);
        goto L16
    L7:
        if (r2 != 3) goto L9;
        r3 = this.g.size();
        goto L16
    L9:
        if (r2 == 4) goto L16;
        throw new NoWhenBranchMatchedException();
    }

    public final void n() {
        if (this.e.c() != SelectAllState.ALL_SELECTED) goto L8;
        if (this.h.isEmpty() == false) goto L8;
    L6:
        this.g.clear();
        this.h.clear();
        SelectAllState r0 = SelectAllState.ALL_SELECTED;
    L36:
        this.e.b(r0);
        return;
    L8:
        if (this.e.c() == SelectAllState.ALL_SELECTED) goto L12;
        if (this.e.c() == SelectAllState.PARTIAL_UNSELECTED) goto L12;
    L15:
        if (this.e.c() == SelectAllState.PARTIAL_SELECTED) goto L19;
        if (this.e.c() == SelectAllState.NONE) goto L19;
    L24:
        if (this.e.c() != SelectAllState.PARTIAL_UNSELECTED) goto L29;
        if (this.h.isEmpty() == true) goto L6;
    L29:
        if (this.e.c() == SelectAllState.NONE) goto L33;
        if (this.e.c() == SelectAllState.PARTIAL_SELECTED) goto L33;
    L35:
        this.g.clear();
        this.h.clear();
        r0 = SelectAllState.NONE;
    L33:
        if ((!((Map) ZeusTransformUtils.preCheckCast(this.g, Map.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L35;
        this.h.clear();
        r0 = SelectAllState.PARTIAL_SELECTED;
    L19:
        if (this.n <= 0) goto L24;
        if (this.g.size() < this.n) goto L24;
    L12:
        if ((!((Map) ZeusTransformUtils.preCheckCast(this.h, Map.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L15;
        r0 = SelectAllState.PARTIAL_UNSELECTED;
        goto L36
    }
}
