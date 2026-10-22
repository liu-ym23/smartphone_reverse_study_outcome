package com.larus.common.location.impl;

import com.larus.api.CoordinateType;
import com.larus.api.LocationService;
import com.larus.common.apphost.AppHost;
import com.larus.platform.model.LocateScene;
import com.larus.platform.model.LocationResult;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.random.Random;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class FlowLocationScheduler {
    public final LocationClient a;
    public final com.larus.common.location.impl.settings.a b;
    public final Function2<LocateScene, Boolean, Boolean> c;
    public Job d;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/common/location/impl/FlowLocationScheduler$FrequencyLevel;", "", "<init>", "(Ljava/lang/String;I)V", "NORMAL", "REDUCE_FREQUENCY", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum FrequencyLevel extends Enum<FrequencyLevel> {
        public static final FrequencyLevel NORMAL = null;
        public static final FrequencyLevel REDUCE_FREQUENCY = null;
        public static final /* synthetic */ FrequencyLevel[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<FrequencyLevel> getEntries() {
            return b;
        }

        static {
            FrequencyLevel r0 = new FrequencyLevel("NORMAL", 0);
            NORMAL = r0;
            FrequencyLevel r1 = new FrequencyLevel("REDUCE_FREQUENCY", 1);
            REDUCE_FREQUENCY = r1;
            FrequencyLevel[] r3 = {r0, r1};
            a = r3;
            b = EnumEntriesKt.enumEntries(r3);
        }

        public static FrequencyLevel[] values() {
            return (FrequencyLevel[]) a.clone();
        }

        public static FrequencyLevel valueOf(String r1) {
            return (FrequencyLevel) r27.a.a(FrequencyLevel.class, r1);
        }

        public FrequencyLevel(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a {
    }

    static {
    }

    public final void e(String r4) {
        Intrinsics.checkNotNullParameter(r4, "reason");
        FLogger.a.d("loc_poll", "stop poll, cause:" + r4);
        Job r5 = this.d;
        if (r5 == null) goto L5;
        Job.DefaultImpls.cancel$default(r5, null, 1, null);
    L5:
        this.d = null;
    }

    public static long c(Integer r5, Integer r6) {
        if (r5 == null) goto L11;
        r5.intValue();
        if (r6 == null) goto L13;
        r6.intValue();
        int r7 = Math.max(0, r5.intValue());
        int r8 = Math.max(0, r6.intValue());
        if (r7 != r8) goto L10;
        return ((long) r7) * 1000;
    L10:
        return Random.Default.nextLong(((long) r7) * 1000, ((long) r8) * 1000);
    L13:
        return 0;
    L11:
        return 0;
    }

    public FlowLocationScheduler(LocationClient r2, com.larus.common.location.impl.settings.a r3, Function2<? super LocateScene, ? super Boolean, Boolean> r4) {
        Intrinsics.checkNotNullParameter(r2, "locationService");
        Intrinsics.checkNotNullParameter(r3, "config");
        Intrinsics.checkNotNullParameter(r4, "canContinuePoll");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }

    public static final long a(FlowLocationScheduler r2, LocateScene r3, FrequencyLevel r4) {
        r2.getClass();
        if (r3.isDoraGRadicalStrategy() == false) goto L9;
        Integer r5 = r2.b.b();
        if (r5 == null) goto L7;
        int r6 = r5.intValue();
    L14:
        return ((long) r6) * 1000;
    L7:
        r6 = 180;
        goto L14
    L9:
        long r0 = c(r2.b.j(), r2.b.f());
        if (r4 != FrequencyLevel.REDUCE_FREQUENCY) goto L13;
        return c(r2.b.i(), r2.b.h());
    L13:
        return r0;
    }

    public final boolean d(LocateScene r9, CoordinateType r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r9, "scene");
        Intrinsics.checkNotNullParameter(r10, "coordinateType");
        FLogger r0 = FLogger.a;
        r0.i("loc_poll", "[" + r9.name() + "] try start poll, isInBackgroundWhenStartingPoll:" + r11);
        if (this.b.l() == true) goto L6;
        r0.e("loc_poll", "[" + r9.name() + "] try start, no config:" + this.b);
        return false;
    L6:
        Job r12 = this.d;
        if (r12 == null) goto L9;
        Job.DefaultImpls.cancel$default(r12, null, 1, null);
    L9:
        this.d = BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new FlowLocationScheduler$startPoll$1(r9, this, r10, null), 3, null);
        return true;
    }

    public static final Object b(FlowLocationScheduler r4, LocateScene r5, CoordinateType r6, Continuation r7) {
        r4.getClass();
        SafeContinuation r0 = new SafeContinuation(IntrinsicsKt.intercepted(r7));
        Ref.BooleanRef r1 = new Ref.BooleanRef();
        if (AppHost.a.a().isAppBackground() == true) goto L5;
    L7:
        LocationService.a.a(r4.a, LocateScene.POLL, r6, new com.larus.common.location.impl.a(r1, r0), 24);
    L8:
        Object r8 = r0.getOrThrow();
        if (r8 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L11;
        DebugProbesKt.probeCoroutineSuspended(r7);
    L11:
        return r8;
    L5:
        if (((Boolean) r4.c.invoke(r5, Boxing.boxBoolean(true))).booleanValue() == true) goto L7;
        FLogger.a.i("loc_poll", r5.name() + ";poll loc abort: can not continue poll in background");
        Result.Companion r9 = Result.Companion;
        r0.resumeWith(Result.constructor-impl(LocationResult.STOP_POLL_IN_BACKGROUND));
        goto L8
    }
}
