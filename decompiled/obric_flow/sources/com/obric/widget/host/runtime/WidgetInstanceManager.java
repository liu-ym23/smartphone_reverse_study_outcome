package com.obric.widget.host.runtime;

import ai.j0;
import android.os.SystemClock;
import android.util.Log;
import androidx.core.view.ViewCompat;
import androidx.room.jarjarred.org.stringtemplate.v4.ST;
import androidx.room.jarjarred.org.stringtemplate.v4.STGroup;
import com.bytedance.ai.model.n;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 E2\u00020\u0001:\u0001EB'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\t\u0010\nJ\u0016\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018J\u000e\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016J\u000e\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016J\u0016\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u001cJ\"\u0010\u001e\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u001f\u001a\u00020\u001c2\b\b\u0002\u0010 \u001a\u00020\bH\u0007J\u0018\u0010!\u001a\u00020\u001c2\u0006\u0010\"\u001a\u00020\u00122\b\u0010\u0017\u001a\u0004\u0018\u00010\u0003J\u0018\u0010!\u001a\u00020\u001c2\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0003J\u0018\u0010#\u001a\u00020\u00142\u0006\u0010\"\u001a\u00020\u00122\b\u0010\u0017\u001a\u0004\u0018\u00010\u0003J\u0018\u0010#\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0003J\u001a\u0010$\u001a\u00020\u00142\u0006\u0010%\u001a\u00020\u000e2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0003H\u0002J\u0010\u0010&\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\"\u001a\u00020\u0012J\u0010\u0010&\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0015\u001a\u00020\u0016J\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u000e0(J\u0010\u0010)\u001a\u0004\u0018\u00010\u000e2\u0006\u0010*\u001a\u00020\u0012J\u0010\u0010+\u001a\u0004\u0018\u00010\u000e2\u0006\u0010,\u001a\u00020\u0012J\u0015\u0010-\u001a\u0004\u0018\u00010\u00122\u0006\u0010,\u001a\u00020\u0012¢\u0006\u0002\u0010.J\u000e\u0010/\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020\u0012J\u0006\u00100\u001a\u00020\u0003J\u000e\u00101\u001a\u00020\b2\u0006\u0010\"\u001a\u00020\u0012J\u000e\u00101\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u0016J\u0016\u00102\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020\u00122\u0006\u00103\u001a\u00020\u0003J\u000e\u00104\u001a\u00020\u001c2\u0006\u0010\"\u001a\u00020\u0012J\u000e\u00104\u001a\u00020\u001c2\u0006\u0010\u0015\u001a\u00020\u0016J$\u00105\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0012\u00106\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u001407H\u0002J\u0018\u00108\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J \u00105\u001a\u00020\u00142\u0006\u0010%\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0010\u00109\u001a\u00020\u00142\u0006\u0010%\u001a\u00020\u000eH\u0002J\u0010\u0010:\u001a\u00020\u00142\u0006\u0010%\u001a\u00020\u000eH\u0002J\u0010\u0010;\u001a\u00020\u001c2\u0006\u0010%\u001a\u00020\u000eH\u0002J\u0010\u0010<\u001a\u00020\u00142\u0006\u0010\"\u001a\u00020\u0012H\u0002J\u0010\u0010<\u001a\u00020\u00142\u0006\u0010=\u001a\u00020\rH\u0002J\u0010\u0010>\u001a\u00020\u00142\u0006\u0010=\u001a\u00020\rH\u0002J\b\u0010?\u001a\u00020\u0014H\u0002J\u0016\u0010@\u001a\b\u0012\u0004\u0012\u00020\u000e0(2\u0006\u0010\"\u001a\u00020\u0012H\u0002J$\u0010A\u001a\u00020\u00142\u0006\u0010B\u001a\u00020\u00032\u0006\u0010%\u001a\u00020\u000e2\n\b\u0002\u0010C\u001a\u0004\u0018\u00010\u0003H\u0002J\u0010\u0010D\u001a\u00020\u00032\u0006\u0010%\u001a\u00020\u000eH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\r0\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006F"}, d2 = {"Lcom/obric/widget/host/runtime/WidgetInstanceManager;", "", "hostId", "", "renderStateStore", "Lcom/obric/widget/host/runtime/WidgetRenderStateStore;", "elapsedRealtimeProvider", "Lkotlin/Function0;", "", "<init>", "(Ljava/lang/String;Lcom/obric/widget/host/runtime/WidgetRenderStateStore;Lkotlin/jvm/functions/Function0;)V", "instanceRecords", "Ljava/util/LinkedHashMap;", "Lcom/obric/widget/host/runtime/WidgetInstanceRecordKey;", "Lcom/obric/widget/host/runtime/WidgetInstanceRecord;", "destroyedInstanceKeys", "Ljava/util/LinkedHashSet;", "destroyedInstanceIds", "", "bindInstance", "", "snapshot", "Lcom/obric/widget/host/runtime/WidgetInstanceSnapshot;", "reason", "Lcom/obric/widget/host/runtime/WidgetBindReason;", "onViewAttached", "onViewDetached", "onViewVisibilityChanged", "", "isVisible", "onRenderCompleted", "success", "renderedDirtyVersion", "markDirty", "hostWidgetInstanceId", "onInstanceRemoved", "removeRecordLocked", "record", "peekRecord", "snapshotRecords", "", "findRecordByHostItemId", "hostItemId", "findRecordByAppWidgetId", "appWidgetId", "findHostWidgetInstanceIdByAppWidgetId", "(I)Ljava/lang/Integer;", "describeRecord", "dumpState", "currentDirtyVersion", "resolvePreferredRefreshReason", "fallbackReason", "isDestroyed", "updateRecord", "block", "Lkotlin/Function1;", "newRecord", "hydratePersistedRenderState", "persistRenderedState", "shouldScheduleVisibleRefreshLocked", "rememberDestroyedInstanceLocked", STGroup.DICT_KEY, "clearDestroyedInstanceLocked", "trimDestroyedInstancesLocked", "recordsForInstanceLocked", "logRecord", "event", "extra", "recordSummary", "Companion", "widget-host-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nWidgetInstanceManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WidgetInstanceManager.kt\ncom/obric/widget/host/runtime/WidgetInstanceManager\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,710:1\n1863#2,2:711\n1863#2,2:713\n1557#2:715\n1628#2,3:716\n295#2,2:719\n295#2,2:721\n295#2,2:723\n1755#2,3:725\n1863#2,2:728\n1755#2,3:731\n1755#2,3:734\n1755#2,3:737\n774#2:740\n865#2,2:741\n1#3:730\n*S KotlinDebug\n*F\n+ 1 WidgetInstanceManager.kt\ncom/obric/widget/host/runtime/WidgetInstanceManager\n*L\n273#1:711,2\n332#1:713,2\n380#1:715\n380#1:716,3\n386#1:719,2\n394#1:721,2\n402#1:723,2\n415#1:725,3\n435#1:728,2\n480#1:731,3\n483#1:734,3\n485#1:737,3\n616#1:740\n616#1:741,2\n*E\n"})
public final class WidgetInstanceManager {
    public static final Companion Companion = null;
    public static final int INVALID_INSTANCE_ID = -1;
    private static final int MAX_DESTROYED_INSTANCE_TOMBSTONES = 64;
    private static final String TAG = "WidgetInstanceMgr";
    private final LinkedHashSet<Integer> destroyedInstanceIds;
    private final LinkedHashSet<WidgetInstanceRecordKey> destroyedInstanceKeys;
    private final Function0<Long> elapsedRealtimeProvider;
    private final String hostId;
    private final LinkedHashMap<WidgetInstanceRecordKey, WidgetInstanceRecord> instanceRecords;
    private final WidgetRenderStateStore renderStateStore;

    /* JADX INFO: renamed from: com.obric.widget.host.runtime.WidgetInstanceManager$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function0<Long> {
        public static final AnonymousClass1 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass1();
        }

        public AnonymousClass1() {
            super(0, SystemClock.class, "elapsedRealtime", "elapsedRealtime()J", 0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Long invoke() {
            return Long.valueOf(SystemClock.elapsedRealtime());
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Long invoke() {
            return invoke();
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/obric/widget/host/runtime/WidgetInstanceManager$Companion;", "", "<init>", "()V", "TAG", "", "MAX_DESTROYED_INSTANCE_TOMBSTONES", "", "INVALID_INSTANCE_ID", "widget-host-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }

        private Companion() {
        }
    }

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r5 = new int[WidgetBindReason.values().length];
            r5[WidgetBindReason.ADD.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r5[WidgetBindReason.RESTORE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            $EnumSwitchMapping$0 = r5;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public WidgetInstanceManager(String r5, WidgetRenderStateStore r10, Function0<Long> r11) {
        Intrinsics.checkNotNullParameter(r5, "hostId");
        Intrinsics.checkNotNullParameter(r10, "renderStateStore");
        Intrinsics.checkNotNullParameter(r11, "elapsedRealtimeProvider");
        this.hostId = r5;
        this.renderStateStore = r10;
        this.elapsedRealtimeProvider = r11;
        this.instanceRecords = new LinkedHashMap();
        this.destroyedInstanceKeys = new LinkedHashSet();
        this.destroyedInstanceIds = new LinkedHashSet();
    }

    public static /* synthetic */ Unit a(Ref.BooleanRef r5, WidgetInstanceManager r10, String r11, WidgetInstanceRecord r12) {
        return markDirty$lambda$8(r5, r10, r11, r12);
    }

    public static /* synthetic */ CharSequence b(WidgetInstanceManager r5, WidgetInstanceRecord r10) {
        return describeRecord$lambda$24$lambda$22(r5, r10);
    }

    public static /* synthetic */ Unit c(WidgetInstanceManager r5, WidgetInstanceRecord r10) {
        return onViewDetached$lambda$3(r5, r10);
    }

    private final void clearDestroyedInstanceLocked(WidgetInstanceRecordKey r5) {
        this.destroyedInstanceKeys.remove(r5);
    }

    public static /* synthetic */ Unit d(boolean r5, WidgetInstanceManager r10, Ref.BooleanRef r11, WidgetInstanceRecord r12) {
        return onViewVisibilityChanged$lambda$4(r5, r10, r11, r12);
    }

    private static final CharSequence describeRecord$lambda$24$lambda$22(WidgetInstanceManager r5, WidgetInstanceRecord r10) {
        Intrinsics.checkNotNullParameter(r5, "this$0");
        Intrinsics.checkNotNullParameter(r10, ST.IMPLICIT_ARG_NAME);
        return r5.recordSummary(r10);
    }

    public static /* synthetic */ Unit e(long r5, boolean r10, WidgetInstanceManager r11, WidgetInstanceRecord r12) {
        return onRenderCompleted$lambda$5(r5, r10, r11, r12);
    }

    public static /* synthetic */ Unit f(WidgetInstanceManager r5, WidgetInstanceRecord r10) {
        return onViewAttached$lambda$2(r5, r10);
    }

    private final void hydratePersistedRenderState(WidgetInstanceRecord r5) {
        if (r5.getHasRenderedContent() == false) goto L6;
        return;
    L6:
        if (this.renderStateStore.hasRendered(this.hostId, r5.getAppletId(), r5.getWidgetId()) == false) goto L9;
        r5.setHasRenderedContent(true);
        return;
    }

    private final void logRecord(String r5, WidgetInstanceRecord r10, String r11) {
        StringBuilder r12 = new StringBuilder("host=");
        androidx.constraintlayout.motion.widget.a.C(r12, this.hostId, ", ", r5, ": ");
        r12.append(recordSummary(r10));
        if (r11 != null) goto L5;
    L8:
        Log.d(TAG, r12.toString());
        return;
    L5:
        if (StringsKt.isBlank(r11) == true) goto L8;
        r12.append(", ");
        r12.append(r11);
        goto L8
    }

    public static /* synthetic */ void logRecord$default(WidgetInstanceManager r5, String r10, WidgetInstanceRecord r11, String r12, int r13, Object r14) {
        if ((r13 & 4) == 0) goto L5;
        r12 = null;
    L5:
        r5.logRecord(r10, r11, r12);
    }

    private static final Unit markDirty$lambda$8(Ref.BooleanRef r5, WidgetInstanceManager r10, String r11, WidgetInstanceRecord r12) {
        Intrinsics.checkNotNullParameter(r5, "$shouldRefresh");
        Intrinsics.checkNotNullParameter(r10, "this$0");
        Intrinsics.checkNotNullParameter(r12, "record");
        if (r12.getDestroyed() == true) goto L5;
        boolean r13 = true;
        r12.setDirty(true);
        r12.setDirtyVersion(r12.getDirtyVersion() + 1);
        if (r12.getVisible() == true) goto L9;
    L11:
        r13 = false;
    L12:
        r5.element = r13;
        if (r13 == false) goto L15;
        WidgetLifecycleState r14 = WidgetLifecycleState.VISIBLE_LOADING;
    L16:
        r12.setLifecycleState(r14);
        r10.logRecord("markDirty", r12, "reason=" + r11 + ", shouldRefresh=" + r5.element);
        return Unit.INSTANCE;
    L15:
        r14 = WidgetLifecycleState.HIDDEN_DIRTY;
        goto L16
    L9:
        if (r12.getAttached() == false) goto L11;
    L5:
        return Unit.INSTANCE;
    }

    private final WidgetInstanceRecord newRecord(WidgetInstanceSnapshot r34, WidgetBindReason r35) {
        return new WidgetInstanceRecord(r34.getHostWidgetInstanceId(), r34.getHostItemId(), r34.getAppWidgetId(), r34.getHostId(), r34.getAppletId(), r34.getWidgetId(), r34.getDefinitionId(), r34.getScreenId(), r34.getCellX(), r34.getCellY(), r34.getSpanX(), r34.getSpanY(), r35, false, false, false, false, false, null, 0, 0, 0, 0, 0, 16769024, null);
    }

    public static /* synthetic */ void onRenderCompleted$default(WidgetInstanceManager r5, WidgetInstanceSnapshot r10, boolean r11, long r12, int r13, Object r14) {
        if ((r13 & 4) == 0) goto L5;
        r12 = r5.currentDirtyVersion(r10);
    L5:
        r5.onRenderCompleted(r10, r11, r12);
    }

    private static final Unit onRenderCompleted$lambda$5(long r5, boolean r10, WidgetInstanceManager r11, WidgetInstanceRecord r12) {
        Intrinsics.checkNotNullParameter(r11, "this$0");
        Intrinsics.checkNotNullParameter(r12, "record");
        if (r12.getDestroyed() == true) goto L5;
        r12.setLastRenderedDirtyVersion(Math.max(r12.getLastRenderedDirtyVersion(), r5));
        if (r10 == false) goto L23;
        r12.setHasRenderedContent(true);
        r11.persistRenderedState(r12);
        r12.setLastSuccessElapsedRealtime(r11.elapsedRealtimeProvider.invoke().longValue());
        if (r12.getDirtyVersion() > r5) goto L12;
        r12.setDirty(false);
    L12:
        if (r12.getDirty() == false) goto L18;
        if (r12.getVisible() == false) goto L16;
        WidgetLifecycleState r13 = WidgetLifecycleState.VISIBLE_LOADING;
    L21:
        r12.setLifecycleState(r13);
    L30:
        r11.logRecord("onRenderCompleted", r12, "success=" + r10 + ", renderedDirtyVersion=" + r5 + ", currentDirtyVersion=" + r12.getDirtyVersion());
        return Unit.INSTANCE;
    L16:
        r13 = WidgetLifecycleState.HIDDEN_DIRTY;
        goto L21
    L18:
        if (r12.getVisible() == false) goto L20;
        r13 = WidgetLifecycleState.VISIBLE_READY;
        goto L21
    L20:
        r13 = WidgetLifecycleState.ATTACHED_HIDDEN;
        goto L21
    L23:
        if (r12.getVisible() == false) goto L26;
        WidgetLifecycleState r14 = WidgetLifecycleState.VISIBLE_STALE;
    L29:
        r12.setLifecycleState(r14);
        goto L30
    L26:
        if (r12.getDirty() == false) goto L28;
        r14 = WidgetLifecycleState.HIDDEN_DIRTY;
        goto L29
    L28:
        r14 = WidgetLifecycleState.ATTACHED_HIDDEN;
        goto L29
    L5:
        return Unit.INSTANCE;
    }

    private static final Unit onViewAttached$lambda$2(WidgetInstanceManager r10, WidgetInstanceRecord r11) {
        Intrinsics.checkNotNullParameter(r10, "this$0");
        Intrinsics.checkNotNullParameter(r11, "record");
        if (r11.getDestroyed() == true) goto L5;
        r11.setAttached(true);
        r11.setVisible(false);
        r11.setLastAttachElapsedRealtime(r10.elapsedRealtimeProvider.invoke().longValue());
        if (r11.getDirty() == false) goto L9;
        WidgetLifecycleState r5 = WidgetLifecycleState.HIDDEN_DIRTY;
    L10:
        r11.setLifecycleState(r5);
        logRecord$default(r10, "onViewAttached", r11, null, 4, null);
        return Unit.INSTANCE;
    L9:
        r5 = WidgetLifecycleState.ATTACHED_HIDDEN;
        goto L10
    L5:
        return Unit.INSTANCE;
    }

    private static final Unit onViewDetached$lambda$3(WidgetInstanceManager r10, WidgetInstanceRecord r11) {
        Intrinsics.checkNotNullParameter(r10, "this$0");
        Intrinsics.checkNotNullParameter(r11, "record");
        if (r11.getDestroyed() == true) goto L5;
        r11.setAttached(false);
        r11.setVisible(false);
        r11.setLifecycleState(WidgetLifecycleState.PERSISTED);
        logRecord$default(r10, "onViewDetached", r11, null, 4, null);
        return Unit.INSTANCE;
    L5:
        return Unit.INSTANCE;
    }

    private static final Unit onViewVisibilityChanged$lambda$4(boolean r5, WidgetInstanceManager r10, Ref.BooleanRef r11, WidgetInstanceRecord r12) {
        Intrinsics.checkNotNullParameter(r10, "this$0");
        Intrinsics.checkNotNullParameter(r11, "$shouldRefresh");
        Intrinsics.checkNotNullParameter(r12, "record");
        if (r12.getDestroyed() == true) goto L32;
        if (r12.getAttached() == false) goto L32;
        if (r12.getVisible() == r5) goto L10;
        r12.setVisible(r5);
        if (r5 == false) goto L25;
        r12.setLastVisibleElapsedRealtime(r10.elapsedRealtimeProvider.invoke().longValue());
        if (r12.getDirty() == false) goto L16;
    L22:
        WidgetLifecycleState r13 = WidgetLifecycleState.VISIBLE_LOADING;
    L23:
        r12.setLifecycleState(r13);
        r11.element = r10.shouldScheduleVisibleRefreshLocked(r12);
    L29:
        r10.logRecord("onViewVisibilityChanged", r12, "visible=" + r5 + ", shouldRefresh=" + r11.element);
        return Unit.INSTANCE;
    L16:
        if (r12.getHasRenderedContent() == false) goto L22;
        WidgetLifecycleState r14 = r12.getLifecycleState();
        r13 = WidgetLifecycleState.VISIBLE_STALE;
        if (r14 == r13) goto L23;
        r13 = WidgetLifecycleState.VISIBLE_READY;
        goto L23
    L25:
        if (r12.getDirty() == false) goto L27;
        WidgetLifecycleState r15 = WidgetLifecycleState.HIDDEN_DIRTY;
    L28:
        r12.setLifecycleState(r15);
        goto L29
    L27:
        r15 = WidgetLifecycleState.ATTACHED_HIDDEN;
        goto L28
    L10:
        return Unit.INSTANCE;
    L32:
        return Unit.INSTANCE;
    }

    private final void persistRenderedState(WidgetInstanceRecord r5) {
        this.renderStateStore.markRendered(this.hostId, r5.getAppletId(), r5.getWidgetId());
    }

    private final String recordSummary(WidgetInstanceRecord r5) {
        return "instance=" + r5.getHostWidgetInstanceId() + ", itemId=" + r5.getHostItemId() + ", appWidgetId=" + r5.getAppWidgetId() + ", recordHostId=" + r5.getHostId() + ", appletId=" + r5.getAppletId() + ", widgetId=" + r5.getWidgetId() + ", definitionId=" + r5.getDefinitionId() + ", bindReason=" + r5.getBindReason() + ", state=" + r5.getLifecycleState() + ", attached=" + r5.getAttached() + ", visible=" + r5.getVisible() + ", dirty=" + r5.getDirty() + ", destroyed=" + r5.getDestroyed() + ", hasRenderedContent=" + r5.getHasRenderedContent() + ", dirtyVersion=" + r5.getDirtyVersion() + ", lastRenderedDirtyVersion=" + r5.getLastRenderedDirtyVersion() + ", screen=" + r5.getScreenId() + ", cell=" + r5.getCellX() + ',' + r5.getCellY() + ", span=" + r5.getSpanX() + 'x' + r5.getSpanY();
    }

    private final List<WidgetInstanceRecord> recordsForInstanceLocked(int r5) {
        Collection<WidgetInstanceRecord> r10 = this.instanceRecords.values();
        ArrayList r11 = new ArrayList();
        Iterator<T> r12 = r10.iterator();
    L4:
        if (r12.hasNext() == false) goto L8;
        Object r13 = r12.next();
        if (((WidgetInstanceRecord) r13).getHostWidgetInstanceId() != r5) goto L4;
        r11.add(r13);
        goto L4
    L8:
        return r11;
    }

    private final void rememberDestroyedInstanceLocked(int r5) {
        this.destroyedInstanceIds.remove(Integer.valueOf(r5));
        this.destroyedInstanceIds.add(Integer.valueOf(r5));
        trimDestroyedInstancesLocked();
    }

    private final void removeRecordLocked(WidgetInstanceRecord r5, String r10) {
        WidgetInstanceRecordKey r11 = WidgetInstanceRecordKey.Companion.from(r5);
        r5.setDestroyed(true);
        r5.setAttached(false);
        r5.setVisible(false);
        r5.setLifecycleState(WidgetLifecycleState.DESTROYED);
        rememberDestroyedInstanceLocked(r5.getAppWidgetId());
        rememberDestroyedInstanceLocked(r11);
        logRecord("onInstanceRemoved", r5, j0.C("reason=", r10));
        this.instanceRecords.remove(r11);
    }

    private final boolean shouldScheduleVisibleRefreshLocked(WidgetInstanceRecord r5) {
        if (r5.getDestroyed() == false) goto L5;
        return false;
    L5:
        if (r5.getAttached() == true) goto L7;
        return false;
    L7:
        if (r5.getVisible() == true) goto L10;
        return false;
    L10:
        if (r5.getLifecycleState() != WidgetLifecycleState.VISIBLE_LOADING) goto L12;
    L13:
        return true;
    L12:
        if (r5.getLifecycleState() == WidgetLifecycleState.VISIBLE_STALE) goto L13;
        return false;
    }

    private final void trimDestroyedInstancesLocked() {
    L3:
        if (this.destroyedInstanceIds.size() <= 64) goto L9;
        Iterator<Integer> r5 = this.destroyedInstanceIds.iterator();
        if (r5.hasNext() == false) goto L7;
        r5.next();
        r5.remove();
        goto L3
    L7:
        return;
    L9:
        if (this.destroyedInstanceKeys.size() <= 64) goto L13;
        Iterator<WidgetInstanceRecordKey> r10 = this.destroyedInstanceKeys.iterator();
        if (r10.hasNext() == false) goto L18;
        r10.next();
        r10.remove();
        goto L9
    L18:
        return;
    }

    private final void updateRecord(WidgetInstanceSnapshot r5, Function1<? super WidgetInstanceRecord, Unit> r10) {
        LinkedHashMap<WidgetInstanceRecordKey, WidgetInstanceRecord> r11 = this.instanceRecords;
        monitor-enter(r11);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (r5.getHostWidgetInstanceId() != (-1)) goto L11;
        Log.w(TAG, "updateRecord ignored: invalid instance id for snapshot=" + r5);     // Catch: Throwable -> L9
        monitor-exit(r11);
        return;
    L11:
        WidgetInstanceRecordKey r12 = WidgetInstanceRecordKey.Companion.from(r5);     // Catch: Throwable -> L9
        clearDestroyedInstanceLocked(r12);     // Catch: Throwable -> L9
        WidgetInstanceRecord r13 = this.instanceRecords.get(r12);     // Catch: Throwable -> L9
        if (r13 != null) goto L14;
        r13 = newRecord(r5, WidgetBindReason.RESTORE);     // Catch: Throwable -> L9
        this.instanceRecords.put(r12, r13);     // Catch: Throwable -> L9
    L14:
        updateRecord(r13, r5, r13.getBindReason());     // Catch: Throwable -> L9
        r10.invoke(r13);     // Catch: Throwable -> L9
        Unit r14 = Unit.INSTANCE;     // Catch: Throwable -> L9
        monitor-exit(r11);
    }

    public final void bindInstance(WidgetInstanceSnapshot r10, WidgetBindReason r11) {
        Intrinsics.checkNotNullParameter(r10, "snapshot");
        Intrinsics.checkNotNullParameter(r11, "reason");
        LinkedHashMap<WidgetInstanceRecordKey, WidgetInstanceRecord> r5 = this.instanceRecords;
        monitor-enter(r5);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (r10.getHostWidgetInstanceId() != (-1)) goto L11;
        Log.w(TAG, "bindInstance ignored: invalid instance id for snapshot=" + r10);     // Catch: Throwable -> L9
        monitor-exit(r5);
        return;
    L11:
        WidgetInstanceRecordKey r12 = WidgetInstanceRecordKey.Companion.from(r10);     // Catch: Throwable -> L9
        clearDestroyedInstanceLocked(r12);     // Catch: Throwable -> L9
        WidgetInstanceRecord r13 = this.instanceRecords.get(r12);     // Catch: Throwable -> L9
        if (r13 != null) goto L14;
        r13 = newRecord(r10, r11);     // Catch: Throwable -> L9
        this.instanceRecords.put(r12, r13);     // Catch: Throwable -> L9
    L14:
        updateRecord(r13, r10, r11);     // Catch: Throwable -> L9
        if (r11 != WidgetBindReason.RESTORE) goto L18;
        hydratePersistedRenderState(r13);     // Catch: Throwable -> L9
    L18:
        if (r13.getAttached() == false) goto L20;
    L22:
        logRecord("bindInstance", r13, "reason=" + r11);     // Catch: Throwable -> L9
        Unit r14 = Unit.INSTANCE;     // Catch: Throwable -> L9
        monitor-exit(r5);
        return;
    L20:
        if (r13.getDestroyed() == true) goto L22;
        r13.setLifecycleState(WidgetLifecycleState.PERSISTED);     // Catch: Throwable -> L9
        goto L22
    }

    public final long currentDirtyVersion(int r5) {
        LinkedHashMap<WidgetInstanceRecordKey, WidgetInstanceRecord> r10 = this.instanceRecords;
        monitor-enter(r10);
        Iterator<T> r11 = recordsForInstanceLocked(r5).iterator();     // Catch: Throwable -> L13
        if (r11.hasNext() == true) goto L7;
        Long r12 = null;
    L16:
        if (r12 == null) goto L19;
        long r13 = r12.longValue();     // Catch: Throwable -> L13
    L20:
        monitor-exit(r10);
        return r13;
    L19:
        r13 = 0;
        goto L20
    L7:
        Long r14 = Long.valueOf(((WidgetInstanceRecord) r11.next()).getDirtyVersion());     // Catch: Throwable -> L13
    L9:
        if (r11.hasNext() == false) goto L15;
        Long r15 = Long.valueOf(((WidgetInstanceRecord) r11.next()).getDirtyVersion());     // Catch: Throwable -> L13
        if (r14.compareTo(r15) >= 0) goto L9;
        r14 = r15;
        goto L9
    L15:
        r12 = r14;
    L13:
        th = move-exception;
        throw th;
    }

    public final String describeRecord(int r10) {
        LinkedHashMap<WidgetInstanceRecordKey, WidgetInstanceRecord> r5 = this.instanceRecords;
        monitor-enter(r5);
        List<WidgetInstanceRecord> r11 = recordsForInstanceLocked(r10);     // Catch: Throwable -> L9
        if (r11.isEmpty() == true) goto L12;
        String r12 = CollectionsKt.q(r11, "\n", null, null, 0, null, new b(this, 0), 30);     // Catch: Throwable -> L9
        monitor-exit(r5);
        return r12;
    L12:
        if (this.destroyedInstanceIds.contains(Integer.valueOf(r10)) == true) goto L25;
        LinkedHashSet<WidgetInstanceRecordKey> r13 = this.destroyedInstanceKeys;     // Catch: Throwable -> L9
        if (r13 != null) goto L16;
    L18:
        Iterator<T> r14 = r13.iterator();     // Catch: Throwable -> L9
    L20:
        if (r14.hasNext() == false) goto L24;
        if (((WidgetInstanceRecordKey) r14.next()).getInstanceId() != r10) goto L20;
    L24:
        String r15 = "instance=" + r10 + ", state=missing";     // Catch: Throwable -> L9
    L26:
        monitor-exit(r5);
        return r15;
    L16:
        if (r13.isEmpty() == false) goto L18;
    L25:
        r15 = "instance=" + r10 + ", state=DESTROYED(tombstone)";     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    }

    public final String dumpState() {
        LinkedHashMap<WidgetInstanceRecordKey, WidgetInstanceRecord> r5 = this.instanceRecords;
        monitor-enter(r5);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.instanceRecords.isEmpty() == true) goto L7;
    L13:
        StringBuilder r10 = new StringBuilder();     // Catch: Throwable -> L11
        r10.append("WidgetInstanceManager{hostId=");     // Catch: Throwable -> L11
        r10.append(this.hostId);     // Catch: Throwable -> L11
        r10.append(", active=");     // Catch: Throwable -> L11
        r10.append(this.instanceRecords.size());     // Catch: Throwable -> L11
        r10.append('}');     // Catch: Throwable -> L11
        Iterator<T> r11 = this.instanceRecords.values().iterator();     // Catch: Throwable -> L11
    L15:
        if (r11.hasNext() == false) goto L18;
        WidgetInstanceRecord r12 = (WidgetInstanceRecord) r11.next();     // Catch: Throwable -> L11
        r10.append('\n');     // Catch: Throwable -> L11
        r10.append(" - ");     // Catch: Throwable -> L11
        Intrinsics.checkNotNull(r12);     // Catch: Throwable -> L11
        r10.append(recordSummary(r12));     // Catch: Throwable -> L11
        goto L15
    L18:
        if (this.destroyedInstanceIds.isEmpty() == true) goto L20;
        r10.append('\n');     // Catch: Throwable -> L11
        r10.append(" - destroyedTombstones=");     // Catch: Throwable -> L11
        r10.append(CollectionsKt.q(this.destroyedInstanceIds, null, "[", "]", 0, null, null, 57));     // Catch: Throwable -> L11
    L20:
        String r13 = r10.toString();     // Catch: Throwable -> L11
        monitor-exit(r5);
        return r13;
    L7:
        if (this.destroyedInstanceIds.isEmpty() == false) goto L13;
        String r14 = "WidgetInstanceManager{hostId=" + this.hostId + ", active=0}";     // Catch: Throwable -> L11
        monitor-exit(r5);
        return r14;
    }

    public final Integer findHostWidgetInstanceIdByAppWidgetId(int r5) {
        LinkedHashMap<WidgetInstanceRecordKey, WidgetInstanceRecord> r10 = this.instanceRecords;
        monitor-enter(r10);
        Iterator<T> r11 = this.instanceRecords.values().iterator();     // Catch: Throwable -> L10
    L5:
        Integer r12 = null;
        if (r11.hasNext() == false) goto L12;
        Object r13 = r11.next();     // Catch: Throwable -> L10
        if (((WidgetInstanceRecord) r13).getAppWidgetId() != r5) goto L5;
    L13:
        WidgetInstanceRecord r14 = (WidgetInstanceRecord) r13;     // Catch: Throwable -> L10
        if (r14 == null) goto L16;
        r12 = Integer.valueOf(r14.getHostWidgetInstanceId());     // Catch: Throwable -> L10
    L16:
        monitor-exit(r10);
        return r12;
    L12:
        r13 = null;
    L10:
        th = move-exception;
        throw th;
    }

    public final WidgetInstanceRecord findRecordByAppWidgetId(int r37) {
        LinkedHashMap<WidgetInstanceRecordKey, WidgetInstanceRecord> r5 = this.instanceRecords;
        monitor-enter(r5);
        Iterator<T> r10 = this.instanceRecords.values().iterator();     // Catch: Throwable -> L10
    L5:
        WidgetInstanceRecord r11 = null;
        if (r10.hasNext() == false) goto L12;
        Object r12 = r10.next();     // Catch: Throwable -> L10
        if (((WidgetInstanceRecord) r12).getAppWidgetId() != r37) goto L5;
    L13:
        WidgetInstanceRecord r13 = (WidgetInstanceRecord) r12;     // Catch: Throwable -> L10
        if (r13 == null) goto L16;
        r11 = WidgetInstanceRecord.copy$default(r13, 0, 0, 0, null, null, null, null, 0, 0, 0, 0, 0, null, false, false, false, false, false, null, 0, 0, 0, 0, 0, ViewCompat.MEASURED_SIZE_MASK, null);     // Catch: Throwable -> L10
    L16:
        monitor-exit(r5);
        return r11;
    L12:
        r12 = null;
    L10:
        th = move-exception;
        throw th;
    }

    public final WidgetInstanceRecord findRecordByHostItemId(int r37) {
        LinkedHashMap<WidgetInstanceRecordKey, WidgetInstanceRecord> r5 = this.instanceRecords;
        monitor-enter(r5);
        Iterator<T> r10 = this.instanceRecords.values().iterator();     // Catch: Throwable -> L10
    L5:
        WidgetInstanceRecord r11 = null;
        if (r10.hasNext() == false) goto L12;
        Object r12 = r10.next();     // Catch: Throwable -> L10
        if (((WidgetInstanceRecord) r12).getHostItemId() != r37) goto L5;
    L13:
        WidgetInstanceRecord r13 = (WidgetInstanceRecord) r12;     // Catch: Throwable -> L10
        if (r13 == null) goto L16;
        r11 = WidgetInstanceRecord.copy$default(r13, 0, 0, 0, null, null, null, null, 0, 0, 0, 0, 0, null, false, false, false, false, false, null, 0, 0, 0, 0, 0, ViewCompat.MEASURED_SIZE_MASK, null);     // Catch: Throwable -> L10
    L16:
        monitor-exit(r5);
        return r11;
    L12:
        r12 = null;
    L10:
        th = move-exception;
        throw th;
    }

    public final boolean isDestroyed(int r10) {
        LinkedHashMap<WidgetInstanceRecordKey, WidgetInstanceRecord> r5 = this.instanceRecords;
        monitor-enter(r5);
        List<WidgetInstanceRecord> r11 = recordsForInstanceLocked(r10);     // Catch: Throwable -> L9
        boolean r12 = false;
        if (r11 != null) goto L7;
    L11:
        Iterator<T> r13 = r11.iterator();     // Catch: Throwable -> L9
    L13:
        if (r13.hasNext() == false) goto L18;
        if (((WidgetInstanceRecord) r13.next()).getDestroyed() == true) goto L13;
        monitor-exit(r5);
        return false;
    L18:
        if (r11 != null) goto L20;
    L22:
        Iterator<T> r14 = r11.iterator();     // Catch: Throwable -> L9
    L24:
        if (r14.hasNext() == false) goto L29;
        if (((WidgetInstanceRecord) r14.next()).getDestroyed() == false) goto L24;
    L40:
        r12 = true;
    L41:
        monitor-exit(r5);
        return r12;
    L29:
        if (this.destroyedInstanceIds.contains(Integer.valueOf(r10)) == true) goto L40;
        LinkedHashSet<WidgetInstanceRecordKey> r15 = this.destroyedInstanceKeys;     // Catch: Throwable -> L9
        if (r15 != null) goto L33;
    L35:
        Iterator<T> r16 = r15.iterator();     // Catch: Throwable -> L9
    L36:
        if (r16.hasNext() == false) goto L41;
        if (((WidgetInstanceRecordKey) r16.next()).getInstanceId() != r10) goto L36;
    L33:
        if (r15.isEmpty() == false) goto L35;
    L20:
        if (r11.isEmpty() == false) goto L22;
    L7:
        if (r11.isEmpty() == false) goto L11;
    L9:
        th = move-exception;
        throw th;
    }

    public final boolean markDirty(int r10, String r11) {
        LinkedHashMap<WidgetInstanceRecordKey, WidgetInstanceRecord> r5 = this.instanceRecords;
        monitor-enter(r5);
        List<WidgetInstanceRecord> r12 = recordsForInstanceLocked(r10);     // Catch: Throwable -> L10
        if (r12.isEmpty() == true) goto L7;
        Iterator<T> r13 = r12.iterator();     // Catch: Throwable -> L10
        boolean r14 = false;
    L16:
        if (r13.hasNext() == false) goto L36;
        WidgetInstanceRecord r15 = (WidgetInstanceRecord) r13.next();     // Catch: Throwable -> L10
        if (r15.getDestroyed() == true) goto L16;
        r15.setDirty(true);     // Catch: Throwable -> L10
        r15.setDirtyVersion(r15.getDirtyVersion() + 1);     // Catch: Throwable -> L10
        if (r15.getVisible() == true) goto L23;
    L25:
        boolean r16 = false;
    L26:
        if (r16 == false) goto L28;
        WidgetLifecycleState r17 = WidgetLifecycleState.VISIBLE_LOADING;     // Catch: Throwable -> L10
    L29:
        r15.setLifecycleState(r17);     // Catch: Throwable -> L10
        if (r14 == true) goto L34;
        if (r16 == true) goto L34;
        r14 = false;
    L35:
        logRecord("markDirty", r15, "reason=" + r11 + ", shouldRefresh=" + r16);     // Catch: Throwable -> L10
    L34:
        r14 = true;
        goto L35
    L28:
        r17 = WidgetLifecycleState.HIDDEN_DIRTY;     // Catch: Throwable -> L10
        goto L29
    L23:
        if (r15.getAttached() == false) goto L25;
        r16 = true;
        goto L26
    L36:
        Unit r18 = Unit.INSTANCE;     // Catch: Throwable -> L10
        monitor-exit(r5);
        return r14;
    L7:
        if (this.destroyedInstanceIds.contains(Integer.valueOf(r10)) == false) goto L12;
        Log.d(TAG, "markDirty ignored: instance=" + r10 + " already destroyed, reason=" + r11);     // Catch: Throwable -> L10
    L12:
        monitor-exit(r5);
        return false;
    L10:
        th = move-exception;
        throw th;
    }

    public final void onInstanceRemoved(int r5, String r10) {
        LinkedHashMap<WidgetInstanceRecordKey, WidgetInstanceRecord> r11 = this.instanceRecords;
        monitor-enter(r11);
        List<WidgetInstanceRecord> r12 = recordsForInstanceLocked(r5);     // Catch: Throwable -> L9
        if (r12.isEmpty() == false) goto L11;
        rememberDestroyedInstanceLocked(r5);     // Catch: Throwable -> L9
        Log.d(TAG, "onInstanceRemoved: instance=" + r5 + ", reason=" + r10 + ", record=missing");     // Catch: Throwable -> L9
        monitor-exit(r11);
        return;
    L11:
        Iterator<T> r13 = r12.iterator();     // Catch: Throwable -> L9
    L13:
        if (r13.hasNext() == false) goto L15;
        removeRecordLocked((WidgetInstanceRecord) r13.next(), r10);     // Catch: Throwable -> L9
        goto L13
    L15:
        Unit r14 = Unit.INSTANCE;     // Catch: Throwable -> L9
        monitor-exit(r11);
        return;
    L9:
        th = move-exception;
        throw th;
    }

    @JvmOverloads
    public final void onRenderCompleted(WidgetInstanceSnapshot r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r10, "snapshot");
        onRenderCompleted$default(this, r10, r11, 0, 4, null);
    }

    public final void onViewAttached(WidgetInstanceSnapshot r5) {
        Intrinsics.checkNotNullParameter(r5, "snapshot");
        updateRecord(r5, new b(this, 1));
    }

    public final void onViewDetached(WidgetInstanceSnapshot r5) {
        Intrinsics.checkNotNullParameter(r5, "snapshot");
        updateRecord(r5, new b(this, 2));
    }

    public final boolean onViewVisibilityChanged(WidgetInstanceSnapshot r5, boolean r10) {
        Intrinsics.checkNotNullParameter(r5, "snapshot");
        Ref.BooleanRef r11 = new Ref.BooleanRef();
        updateRecord(r5, new n(1, this, r10, r11));
        return r11.element;
    }

    public final WidgetInstanceRecord peekRecord(int r35) {
        LinkedHashMap<WidgetInstanceRecordKey, WidgetInstanceRecord> r5 = this.instanceRecords;
        monitor-enter(r5);
        WidgetInstanceRecord r10 = (WidgetInstanceRecord) CollectionsKt.firstOrNull(recordsForInstanceLocked(r35));     // Catch: Throwable -> L8
        if (r10 == null) goto L10;
        WidgetInstanceRecord r11 = WidgetInstanceRecord.copy$default(r10, 0, 0, 0, null, null, null, null, 0, 0, 0, 0, 0, null, false, false, false, false, false, null, 0, 0, 0, 0, 0, ViewCompat.MEASURED_SIZE_MASK, null);     // Catch: Throwable -> L8
    L11:
        monitor-exit(r5);
        return r11;
    L10:
        r11 = null;
    L8:
        th = move-exception;
        throw th;
    }

    public final String resolvePreferredRefreshReason(int r5, String r10) {
        Intrinsics.checkNotNullParameter(r10, "fallbackReason");
        LinkedHashMap<WidgetInstanceRecordKey, WidgetInstanceRecord> r11 = this.instanceRecords;
        monitor-enter(r11);
        WidgetInstanceRecord r12 = (WidgetInstanceRecord) CollectionsKt.firstOrNull(recordsForInstanceLocked(r5));     // Catch: Throwable -> L17
        if (r12 != null) goto L9;
        monitor-exit(r11);
        return r10;
    L9:
        if (r12.getHasRenderedContent() == false) goto L12;
        monitor-exit(r11);
        return r10;
    L12:
        WidgetBindReason r13 = r12.getBindReason();     // Catch: Throwable -> L17
        int r14 = WhenMappings.$EnumSwitchMapping$0[r13.ordinal()];     // Catch: Throwable -> L17
        if (r14 != 1) goto L15;
        String r15 = "onAdd";
    L22:
        monitor-exit(r11);
        return r15;
    L15:
        if (r14 != 2) goto L20;
        r15 = "onRestore";
        goto L22
    L20:
        throw new NoWhenBranchMatchedException();     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        throw th;
    }

    public final List<WidgetInstanceRecord> snapshotRecords() {
        LinkedHashMap<WidgetInstanceRecordKey, WidgetInstanceRecord> r5 = this.instanceRecords;
        monitor-enter(r5);
        Collection<WidgetInstanceRecord> r10 = this.instanceRecords.values();     // Catch: Throwable -> L9
        ArrayList r11 = new ArrayList(CollectionsKt.h(r10));     // Catch: Throwable -> L9
        Iterator<T> r12 = r10.iterator();     // Catch: Throwable -> L9
    L6:
        if (r12.hasNext() == false) goto L11;
        r11.add(WidgetInstanceRecord.copy$default((WidgetInstanceRecord) r12.next(), 0, 0, 0, null, null, null, null, 0, 0, 0, 0, 0, null, false, false, false, false, false, null, 0, 0, 0, 0, 0, ViewCompat.MEASURED_SIZE_MASK, null));     // Catch: Throwable -> L9
        goto L6
    L11:
        monitor-exit(r5);
        return r11;
    L9:
        th = move-exception;
        throw th;
    }

    @JvmOverloads
    public final void onRenderCompleted(WidgetInstanceSnapshot r5, final boolean r10, final long r11) {
        Intrinsics.checkNotNullParameter(r5, "snapshot");
        updateRecord(r5, new a(r11, r10, this));
    }

    public final long currentDirtyVersion(WidgetInstanceSnapshot r5) {
        Intrinsics.checkNotNullParameter(r5, "snapshot");
        LinkedHashMap<WidgetInstanceRecordKey, WidgetInstanceRecord> r10 = this.instanceRecords;
        monitor-enter(r10);
        WidgetInstanceRecord r11 = this.instanceRecords.get(WidgetInstanceRecordKey.Companion.from(r5));     // Catch: Throwable -> L8
        if (r11 == null) goto L10;
        long r12 = r11.getDirtyVersion();     // Catch: Throwable -> L8
    L11:
        monitor-exit(r10);
        return r12;
    L10:
        r12 = 0;
    L8:
        th = move-exception;
        throw th;
    }

    public final WidgetInstanceRecord peekRecord(WidgetInstanceSnapshot r36) {
        Intrinsics.checkNotNullParameter(r36, "snapshot");
        LinkedHashMap<WidgetInstanceRecordKey, WidgetInstanceRecord> r5 = this.instanceRecords;
        monitor-enter(r5);
        WidgetInstanceRecord r10 = this.instanceRecords.get(WidgetInstanceRecordKey.Companion.from(r36));     // Catch: Throwable -> L8
        if (r10 == null) goto L10;
        WidgetInstanceRecord r11 = WidgetInstanceRecord.copy$default(r10, 0, 0, 0, null, null, null, null, 0, 0, 0, 0, 0, null, false, false, false, false, false, null, 0, 0, 0, 0, 0, ViewCompat.MEASURED_SIZE_MASK, null);     // Catch: Throwable -> L8
    L11:
        monitor-exit(r5);
        return r11;
    L10:
        r11 = null;
    L8:
        th = move-exception;
        throw th;
    }

    private final void rememberDestroyedInstanceLocked(WidgetInstanceRecordKey r5) {
        this.destroyedInstanceKeys.remove(r5);
        this.destroyedInstanceKeys.add(r5);
        trimDestroyedInstancesLocked();
    }

    public /* synthetic */ WidgetInstanceManager(String r5, WidgetRenderStateStore r10, Function0 r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 4) == 0) goto L5;
        r11 = AnonymousClass1.INSTANCE;
    L5:
        this(r5, r10, r11);
    }

    public final void onInstanceRemoved(WidgetInstanceSnapshot r5, String r10) {
        Intrinsics.checkNotNullParameter(r5, "snapshot");
        LinkedHashMap<WidgetInstanceRecordKey, WidgetInstanceRecord> r11 = this.instanceRecords;
        monitor-enter(r11);
        WidgetInstanceRecordKey r12 = WidgetInstanceRecordKey.Companion.from(r5);     // Catch: Throwable -> L9
        WidgetInstanceRecord r13 = this.instanceRecords.get(r12);     // Catch: Throwable -> L9
        if (r13 != null) goto L11;
        rememberDestroyedInstanceLocked(r12);     // Catch: Throwable -> L9
        Log.d(TAG, "onInstanceRemoved: instance=" + r5.getHostWidgetInstanceId() + ", reason=" + r10 + ", record=missing");     // Catch: Throwable -> L9
        monitor-exit(r11);
        return;
    L11:
        removeRecordLocked(r13, r10);     // Catch: Throwable -> L9
        Unit r14 = Unit.INSTANCE;     // Catch: Throwable -> L9
        monitor-exit(r11);
        return;
    L9:
        th = move-exception;
        throw th;
    }

    private final void updateRecord(WidgetInstanceRecord r5, WidgetInstanceSnapshot r10, WidgetBindReason r11) {
        r5.setHostItemId(r10.getHostItemId());
        r5.setAppWidgetId(r10.getAppWidgetId());
        r5.setHostId(r10.getHostId());
        r5.setAppletId(r10.getAppletId());
        r5.setWidgetId(r10.getWidgetId());
        r5.setDefinitionId(r10.getDefinitionId());
        r5.setScreenId(r10.getScreenId());
        r5.setCellX(r10.getCellX());
        r5.setCellY(r10.getCellY());
        r5.setSpanX(r10.getSpanX());
        r5.setSpanY(r10.getSpanY());
        r5.setBindReason(r11);
    }

    public final boolean isDestroyed(WidgetInstanceSnapshot r5) {
        Intrinsics.checkNotNullParameter(r5, "snapshot");
        LinkedHashMap<WidgetInstanceRecordKey, WidgetInstanceRecord> r10 = this.instanceRecords;
        monitor-enter(r10);
        WidgetInstanceRecordKey r11 = WidgetInstanceRecordKey.Companion.from(r5);     // Catch: Throwable -> L9
        WidgetInstanceRecord r12 = this.instanceRecords.get(r11);     // Catch: Throwable -> L9
        boolean r13 = true;
        if (r12 != null) goto L7;
    L11:
        if (this.destroyedInstanceKeys.contains(r11) == true) goto L15;
        r13 = false;
    L15:
        monitor-exit(r10);
        return r13;
    L7:
        if (r12.getDestroyed() != true) goto L11;
    L9:
        th = move-exception;
        throw th;
    }

    public final boolean markDirty(WidgetInstanceSnapshot r5, String r10) {
        Intrinsics.checkNotNullParameter(r5, "snapshot");
        Ref.BooleanRef r11 = new Ref.BooleanRef();
        updateRecord(r5, new com.bytedance.ai.bridge.method.sqlite.b(r11, this, r10));
        return r11.element;
    }
}
