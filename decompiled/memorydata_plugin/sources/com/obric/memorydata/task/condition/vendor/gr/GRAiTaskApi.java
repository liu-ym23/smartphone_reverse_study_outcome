package com.obric.memorydata.task.condition.vendor.gr;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import androidx.core.content.ContextCompat;
import com.bytedance.crash.entity.EventBody;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.utils.threadpool.ThreadPoolContainer;
import com.volcengine.zeus.receiver.PluginBroadcastReceiver;
import com.volcengine.zeus.transform.ZeusProviderTransform;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000Y\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\t*\u0001\u0010\bÆ\u0002\u0018\u00002\u00020\u0001:\u0003$%&B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0012\u001a\u00020\u0013H\u0002J.\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00182\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00130\u001aJ\u0018\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020\u0016J\u000e\u0010 \u001a\u00020\u00132\u0006\u0010!\u001a\u00020\nJ\u0010\u0010\"\u001a\u00020\u00132\u0006\u0010#\u001a\u00020\fH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0011¨\u0006'"}, d2 = {"Lcom/obric/memorydata/task/condition/vendor/gr/GRAiTaskApi;", "", "<init>", "()V", "TAG", "", "AI_TASK_ACTION", "AI_TASK_PERMISSION", "availabilityChangeListeners", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/obric/memorydata/task/condition/vendor/gr/GRAiTaskApi$OnAvailabilityChangeListener;", "currentStatus", "Lcom/obric/memorydata/task/condition/vendor/gr/GRAiTaskApi$Availability;", "receiverRegistered", "Ljava/util/concurrent/atomic/AtomicBoolean;", "statusReceiver", "com/obric/memorydata/task/condition/vendor/gr/GRAiTaskApi$statusReceiver$1", "Lcom/obric/memorydata/task/condition/vendor/gr/GRAiTaskApi$statusReceiver$1;", "ensureReceiver", "", "getAvailabilityWindow", "retryCount", "", "needLogcat", "", "onResult", "Lkotlin/Function1;", "checkShouldStop", "Lcom/obric/memorydata/task/condition/vendor/gr/GRAiTaskApi$StopCheckResult;", "startTime", "", "runLevel", "addAvailabilityChangeListener", "listener", "notifyAvailabilityChange", "new", "Availability", "StopCheckResult", "OnAvailabilityChangeListener", "task_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class GRAiTaskApi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final GRAiTaskApi f12900a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final CopyOnWriteArrayList<a> f12901b = null;
    private static volatile Availability c;
    private static final AtomicBoolean d = null;
    private static final c e = null;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/obric/memorydata/task/condition/vendor/gr/GRAiTaskApi$Availability;", "", EventBody.KEY_VALUE, "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "STATUS_OVERLOAD_STOP", "STATUS_UNAVAILABLE", "STATUS_AI_SEARCH_RUNNING", "STATUS_LIGHT_RUN", "STATUS_HEAVY_RUN", "task_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final enum Availability extends Enum<Availability> {
        private static final /* synthetic */ EnumEntries $ENTRIES = null;
        private static final /* synthetic */ Availability[] $VALUES = null;
        public static final Availability STATUS_AI_SEARCH_RUNNING = null;
        public static final Availability STATUS_HEAVY_RUN = null;
        public static final Availability STATUS_LIGHT_RUN = null;
        public static final Availability STATUS_OVERLOAD_STOP = null;
        public static final Availability STATUS_UNAVAILABLE = null;
        private final int value;

        private static final /* synthetic */ Availability[] $values() {
            return new Availability[]{STATUS_OVERLOAD_STOP, STATUS_UNAVAILABLE, STATUS_AI_SEARCH_RUNNING, STATUS_LIGHT_RUN, STATUS_HEAVY_RUN};
        }

        static {
            STATUS_OVERLOAD_STOP = new Availability("STATUS_OVERLOAD_STOP", 0, -1);
            STATUS_UNAVAILABLE = new Availability("STATUS_UNAVAILABLE", 1, 0);
            STATUS_AI_SEARCH_RUNNING = new Availability("STATUS_AI_SEARCH_RUNNING", 2, 1);
            STATUS_LIGHT_RUN = new Availability("STATUS_LIGHT_RUN", 3, 2);
            STATUS_HEAVY_RUN = new Availability("STATUS_HEAVY_RUN", 4, 3);
            Availability[] r0 = $values();
            $VALUES = r0;
            $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
        }

        private Availability(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }

        public static EnumEntries<Availability> getEntries() {
            return $ENTRIES;
        }

        public static Availability valueOf(String r2) {
            return (Availability) ZeusTransformUtils.preCheckCast(Enum.valueOf(Availability.class, r2), Availability.class, "com.obric.memorydata.plugin");
        }

        public static Availability[] values() {
            return (Availability[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), Availability[].class, "com.obric.memorydata.plugin");
        }

        public final int getValue() {
            return this.value;
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/task/condition/vendor/gr/GRAiTaskApi$OnAvailabilityChangeListener;", "", "onChange", "", "availability", "Lcom/obric/memorydata/task/condition/vendor/gr/GRAiTaskApi$Availability;", "task_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface a {
        void a(Availability r1);
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0014"}, d2 = {"Lcom/obric/memorydata/task/condition/vendor/gr/GRAiTaskApi$StopCheckResult;", "", "shouldStop", "", "stopReason", "", "<init>", "(ZLjava/lang/String;)V", "getShouldStop", "()Z", "getStopReason", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "task_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f12902a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f12903b;

        public b(boolean r2, String r3) {
            Intrinsics.checkNotNullParameter(r3, "stopReason");
            this.f12902a = r2;
            this.f12903b = r3;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
            return false;
        L8:
            b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.memorydata.plugin");
            if (this.f12902a == r6.f12902a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f12903b, r6.f12903b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (Boolean.hashCode(this.f12902a) * 31) + this.f12903b.hashCode();
        }

        public String toString() {
            return "StopCheckResult(shouldStop=" + this.f12902a + ", stopReason=" + this.f12903b + ')';
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/obric/memorydata/task/condition/vendor/gr/GRAiTaskApi$statusReceiver$1", "Landroid/content/BroadcastReceiver;", "onReceive", "", "context", "Landroid/content/Context;", MemorySourceLinkType.INTENT, "Landroid/content/Intent;", "task_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class c extends PluginBroadcastReceiver {
        c() {
        }

        public void onReceive(Context r6, Intent r7) {
            Intrinsics.checkNotNullParameter((Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.memorydata.plugin"), "context");
            Intrinsics.checkNotNullParameter(r7, MemorySourceLinkType.INTENT);
            int r5 = r7.getIntExtra("availability_status", 0);
            RunLog.INSTANCE.info("VendorCondition", "receive status " + r5 + ", desc=" + r7.getStringExtra("availability_status_desc"), true);
            Availability[] r8 = Availability.values();
            int r0 = r8.length;
            int r1 = 0;
        L3:
            if (r1 >= r0) goto L11;
            Availability r3 = r8[r1];
            if (r3.getValue() != r5) goto L7;
            boolean r4 = true;
        L8:
            if (r4 == true) goto L12;
            r1 = r1 + 1;
        L12:
            if (r3 != null) goto L14;
            r3 = Availability.STATUS_UNAVAILABLE;
        L14:
            GRAiTaskApi.a(GRAiTaskApi.f12900a, r3);
            return;
        L7:
            r4 = false;
            goto L8
        L11:
            r3 = null;
            goto L12
        }
    }

    static {
        f12900a = new GRAiTaskApi();
        f12901b = new CopyOnWriteArrayList();
        c = Availability.STATUS_UNAVAILABLE;
        d = new AtomicBoolean(false);
        e = new c();
    }

    private GRAiTaskApi() {
    }

    private final void a() {
        if (d.compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "VendorCondition", "register GR receiver", false, 4, null);
        Application r8 = (Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getApplication(), "com.obric.memorydata.plugin"), Application.class, "com.obric.memorydata.plugin");
        IntentFilter r4 = new IntentFilter("com.xiaomi.aicr.action.AI_SEARCH_IDLE");
        ContextCompat.registerReceiver((Context) ZeusTransformUtils.preCheckCast(r8, Context.class, "com.obric.memorydata.plugin"), (PluginBroadcastReceiver) ZeusTransformUtils.preCheckCast(e, PluginBroadcastReceiver.class, "com.obric.memorydata.plugin"), r4, "com.xiaomi.aicr.permission.AI_TASK_AVAILABILITY", null, 2);
        ThreadPoolContainer.Companion.execute($$Lambda$GRAiTaskApi$PhdKGJiWksauFsQwXFU6r1THLl0.INSTANCE);
    }

    private final void a(Availability r4) {
        if (c != r4) goto L5;
        return;
    L5:
        RunLog.INSTANCE.info("VendorCondition", "availability change " + r4, true);
        c = r4;
        Iterator r3 = ((Iterable) ZeusTransformUtils.preCheckCast(f12901b, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L7:
        if (r3.hasNext() == false) goto L9;
        ((a) ZeusTransformUtils.preCheckCast(r3.next(), a.class, "com.obric.memorydata.plugin")).a(r4);
        goto L7
    }

    private static final void a(GRAiTaskApi r2, int r3, boolean r4, Function1 r5) {
        Function1<? super Availability, Unit> r6 = (Function1) ZeusTransformUtils.wrapperContextForParams(r5, Function1.class, "com.obric.memorydata.plugin");
        Thread.sleep(1000);     // Catch: InterruptedException -> L6
    L4:
        r2.a(r3 - 1, r4, r6);
    }

    public static /* synthetic */ void a(GRAiTaskApi r1, int r2, boolean r3, Function1 r4, int r5, Object r6) {
        Function1<? super Availability, Unit> r7 = (Function1) ZeusTransformUtils.wrapperContextForParams(r4, Function1.class, "com.obric.memorydata.plugin");
        if ((r5 & 1) == 0) goto L6;
        r2 = 0;
    L6:
        if ((r5 & 2) == 0) goto L8;
        r3 = false;
    L8:
        r1.a(r2, r3, r7);
    }

    public static final /* synthetic */ void a(GRAiTaskApi r0, Availability r1) {
        r0.a(r1);
    }

    private static final Unit b(Availability r1) {
        Intrinsics.checkNotNullParameter(r1, "initialStatus");
        f12900a.a(r1);
        return Unit.INSTANCE;
    }

    private static final void b() {
        f12900a.a(5, true, $$Lambda$GRAiTaskApi$eBS0Bk5coqX6ZeHYTkvyDdrbtfg.INSTANCE);
    }

    private static final void b(int r2, boolean r3, Function1 r4) {
        Function1<? super Availability, Unit> r5 = (Function1) ZeusTransformUtils.wrapperContextForParams(r4, Function1.class, "com.obric.memorydata.plugin");
        Thread.sleep(1000);     // Catch: InterruptedException -> L6
    L4:
        f12900a.a(r2 - 1, r3, r5);
    }

    /* JADX INFO: renamed from: lambda$Li-sJmfGJyUuZLvbfu492JTUJDY, reason: not valid java name */
    public static /* synthetic */ void m1188lambda$LisJmfGJyUuZLvbfu492JTUJDY(int r0, boolean r1, Function1 r2) {
        b(r0, r1, r2);
    }

    public static /* synthetic */ void lambda$PhdKGJiWksauFsQwXFU6r1THLl0() {
        b();
    }

    public static /* synthetic */ Unit lambda$eBS0Bk5coqX6ZeHYTkvyDdrbtfg(Availability r0) {
        return b(r0);
    }

    /* JADX INFO: renamed from: lambda$r1JuS2HEeM5r5Zg7AkRpW-X0jKU, reason: not valid java name */
    public static /* synthetic */ void m1189lambda$r1JuS2HEeM5r5Zg7AkRpWX0jKU(GRAiTaskApi r0, int r1, boolean r2, Function1 r3) {
        a(r0, r1, r2, r3);
    }

    public final b a(long r17, int r19) {
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Bundle r8 = new Bundle();
        r8.putLong("start_time", r17);
        r8.putInt("run_level", r19);
        Bundle r1 = ZeusProviderTransform.call(r0.getContentResolver(), "com.xiaomi.aicr.aitask.availability", "check_should_stop", null, r8, "com.obric.memorydata.plugin");     // Catch: Exception -> L5
    L8:
        if (r1 != null) goto L11;
        GRAiTaskApi r2 = (GRAiTaskApi) ZeusTransformUtils.preCheckCast(this, GRAiTaskApi.class, "com.obric.memorydata.plugin");
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "VendorCondition", "checkShouldStop: call failed, returning shouldStop=true for safety", null, 4, null);
        r2.a(Availability.STATUS_UNAVAILABLE);
        return new b(true, "call_failed");
    L11:
        boolean r3 = r1.getBoolean("should_stop");
        String r5 = r1.getString("stop_reason");
        if (r5 != null) goto L14;
        r5 = "";
    L14:
        int r6 = r1.getInt("temperature");
        int r7 = r1.getInt("battery_level");
        int r9 = r1.getInt("charging");
        int r10 = r1.getInt("screen_interactive");
        int r4 = r1.getInt("ai_search_run_state");
        RunLog.INSTANCE.debug("VendorCondition", "checkShouldStop: shouldStop=" + r3 + ", reason=" + r5 + ", temp=" + r6 + ", battery=" + r7 + ", charging=" + r9 + ", screen=" + r10 + ", aiSearchState=" + r4);
        if (r3 == false) goto L19;
        RunLog.INSTANCE.info("VendorCondition", "checkShouldStop: shouldStop=true, reason=" + r5 + ", temp=" + r6 + ", battery=" + r7 + ", charging=" + r9 + ", screen=" + r10 + ", aiSearchState=" + r4, true);
        a(Availability.STATUS_UNAVAILABLE);
    L19:
        return new b(r3, r5);
    L5:
        e = move-exception;
        String r11 = Log.getStackTraceString((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        Intrinsics.checkNotNullExpressionValue(r11, "getStackTraceString(...)");
        RunLog.INSTANCE.error("VendorCondition", "checkShouldStop: call failed with exception\n" + r11, (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        r1 = null;
        goto L8
    }

    public final void a(final int r12, final boolean r13, Function1<? super Availability, Unit> r14) {
        final Function1 r15 = (Function1) ZeusTransformUtils.wrapperContextForParams(r14, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r15, "onResult");
        Availability r3 = null;
        Bundle r1 = ZeusProviderTransform.call(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getContentResolver(), "com.xiaomi.aicr.aitask.availability", "get_availability_window", null, null, "com.obric.memorydata.plugin");     // Catch: Exception -> L5
    L7:
        if (r1 != null) goto L13;
        final GRAiTaskApi r11 = (GRAiTaskApi) ZeusTransformUtils.preCheckCast(this, GRAiTaskApi.class, "com.obric.memorydata.plugin");
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "VendorCondition", "getAvailabilityWindow: call failed, returning STATUS_UNAVAILABLE", null, 4, null);
        if (r12 <= 0) goto L11;
        ThreadPoolContainer.Companion.execute(new $$Lambda$GRAiTaskApi$r1JuS2HEeM5r5Zg7AkRpWX0jKU(r11, r12, r13, r15));
        return;
    L11:
        r15.invoke(Availability.STATUS_UNAVAILABLE);
        return;
    L13:
        int r16 = r1.getInt("availability_status");
        RunLog.INSTANCE.info("VendorCondition", "getAvailabilityWindow: status=" + r16 + ", statusDesc=" + r1.getString("availability_status_desc") + ", temp=" + r1.getInt("temperature") + ", battery=" + r1.getInt("battery_level") + ", charging=" + r1.getInt("charging") + ", screen=" + r1.getInt("screen_interactive") + ", aiSearchState=" + r1.getInt("ai_search_run_state"), r13);
        Availability[] r0 = Availability.values();
        int r2 = r0.length;
        int r4 = 0;
    L14:
        if (r4 >= r2) goto L22;
        Availability r5 = r0[r4];
        if (r5.getValue() != r16) goto L18;
        boolean r6 = true;
    L19:
        if (r6 == true) goto L20;
        r4 = r4 + 1;
        goto L14
    L20:
        r3 = r5;
        goto L22
    L18:
        r6 = false;
    L22:
        if (r3 == null) goto L24;
        r15.invoke(r3);
        return;
    L24:
        if (r12 <= 0) goto L26;
        ThreadPoolContainer.Companion.execute(new $$Lambda$GRAiTaskApi$LisJmfGJyUuZLvbfu492JTUJDY(r12, r13, r15));
        return;
    L26:
        r15.invoke(Availability.STATUS_UNAVAILABLE);
        return;
    L5:
        e = move-exception;
        String r7 = Log.getStackTraceString((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        Intrinsics.checkNotNullExpressionValue(r7, "getStackTraceString(...)");
        RunLog.INSTANCE.error("VendorCondition", "getAvailabilityWindow: call failed\n" + r7, (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        r1 = null;
        goto L7
    }

    public final void a(a r7) {
        a r8 = (a) ZeusTransformUtils.wrapperContextForParams(r7, a.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r8, "listener");
        a();
        f12901b.add(r8);
        r8.a(c);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "VendorCondition", "add availability change listener, initial state " + c, false, 4, null);
    }
}
