package com.obric.memorydata.ability.condition;

import com.obric.memorydata.ability.data.h;
import com.obric.memorydata.ability.k;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.task.condition.Condition;
import com.obric.memorydata.utils.handler.GlobalHandlerUtil;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0013\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0016¢\u0006\u0002\u0010\u0014J\b\u0010\u0015\u001a\u00020\u0013H\u0016J\u0017\u0010\u0016\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0017\u001a\u00020\u0018H\u0016¢\u0006\u0002\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0007H\u0002J\b\u0010\u001d\u001a\u00020\u001bH\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/obric/memorydata/ability/condition/BatteryCharge10MinCondition;", "Lcom/obric/memorydata/ability/condition/AbilityStateCondition;", "condition", "Lcom/obric/memorydata/task/condition/Condition;", "<init>", "(Lcom/obric/memorydata/task/condition/Condition;)V", "chargeStartTime", "", "disconnectTime", "accumulatedChargeTime", "CHARGE_DELAY_MS", "TOLERANCE_WINDOW_MS", "needWait", "", "isRegisteredDelayRunnable", "delayRunnable", "Ljava/lang/Runnable;", "getSubscribeAbilityParams", "", "Lcom/obric/memorydata/ability/AbilityParams;", "()[Lcom/obric/memorydata/ability/AbilityParams;", "getQueryAbilityParams", "extractState", "data", "Lcom/obric/memorydata/ability/data/IStandardData;", "(Lcom/obric/memorydata/ability/data/IStandardData;)Ljava/lang/Boolean;", "registerDelayRunnable", "", "delayMs", "unRegisterDelayRunnable", "Companion", "ability_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class b extends com.obric.memorydata.ability.condition.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f8313b = null;
    private long c;
    private long d;
    private long e;
    private final long f;
    private final long g;
    private volatile boolean h;
    private volatile boolean i;
    private final Runnable j;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/ability/condition/BatteryCharge10MinCondition$Companion;", "", "<init>", "()V", "TAG", "", "ability_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.ability.condition.b$b, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/obric/memorydata/ability/condition/BatteryCharge10MinCondition$delayRunnable$1$1", "Lcom/obric/memorydata/ability/IAbilityDataReceiver;", "onDataReceive", "", "data", "Lcom/obric/memorydata/ability/data/IStandardData;", "ability_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class C0418b implements k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f8314a;

        C0418b(b r1) {
            this.f8314a = r1;
        }

        @Override // com.obric.memorydata.ability.k
        public void a(h r4) {
            h r5 = (h) ZeusTransformUtils.wrapperContextForParams(r4, h.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "data");
            Boolean r6 = this.f8314a.a(r5);
            RunLog.INSTANCE.debug("BatteryCharge10MinCondition", "延时任务处理查询结果，newState=" + r6);
            if (r6 == null) goto L6;
            this.f8314a.a(r6.booleanValue());
            return;
        }

        @Override // com.obric.memorydata.ability.k
        public String g_() {
            return k.a.a(this);
        }
    }

    static {
        f8313b = new a(null);
    }

    public b(Condition r3) {
        Intrinsics.checkNotNullParameter(r3, "condition");
        super(r3);
        this.f = 600000;
        this.g = 180000;
        this.j = new $$Lambda$b$V8jx1Vc4hvsaxCQzqgVavXnq7g(this);
    }

    private final void a(long r2) {
        if (this.i == true) goto L6;
        this.i = true;
        GlobalHandlerUtil.Companion.getInstance().postDelay(this.j, r2);
        return;
    }

    private static final void a(b r4) {
        RunLog.INSTANCE.debug("BatteryCharge10MinCondition", "延时任务触发，查询当前电量状态");
        r4.a().query(r4.f(), (k) ZeusTransformUtils.preCheckCast(new C0418b(r4), k.class, "com.obric.memorydata.plugin"));
    }

    private final void j() {
        if (this.i == false) goto L6;
        GlobalHandlerUtil.Companion.getInstance().removeCallbacks(this.j);
        this.i = false;
        return;
    }

    /* JADX INFO: renamed from: lambda$V8jx-1Vc4hvsaxCQzqgVavXnq7g, reason: not valid java name */
    public static /* synthetic */ void m432lambda$V8jx1Vc4hvsaxCQzqgVavXnq7g(b r0) {
        a(r0);
    }

    @Override // com.obric.memorydata.ability.condition.a
    public Boolean a(h r17) {
        h r1 = (h) ZeusTransformUtils.wrapperContextForParams(r17, h.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "data");
        if (ZeusTransformUtils.instanceOf(r1, com.obric.memorydata.ability.data.a.class) == false) goto L54;
        boolean r3 = ((com.obric.memorydata.ability.data.a) ZeusTransformUtils.preCheckCast(r1, com.obric.memorydata.ability.data.a.class, "com.obric.memorydata.plugin")).c();
        double r2 = ((com.obric.memorydata.ability.data.a) ZeusTransformUtils.preCheckCast(r1, com.obric.memorydata.ability.data.a.class, "com.obric.memorydata.plugin")).a();
        long r4 = System.currentTimeMillis();
        RunLog.INSTANCE.debug("BatteryCharge10MinCondition", "extractState called: isCharging=" + r3 + ", level=" + r2);
        if (r3 == true) goto L7;
        String r7 = "BatteryCharge10MinCondition";
        long r5 = this.c;
        if (r5 <= 0) goto L41;
        long r6 = r4 - r5;
        this.e += r6;
        this.c = 0;
        this.d = r4;
        RunLog.INSTANCE.debug(r7, "拔出电源，本次充电时长=" + r6 + " ms, 累计充电时长=" + this.e + " ms");
        j();
    L41:
        boolean r8 = false;
        if (r3 == true) goto L46;
        return false;
    L46:
        if (this.h == true) goto L49;
        RunLog.INSTANCE.debug(r7, "插电时电量 >= 80%，无需等待，返回 true");
        return true;
    L49:
        long r9 = this.e + (r4 - this.c);
        if (r9 < this.f) goto L52;
        r8 = true;
    L52:
        RunLog.INSTANCE.debug(r7, "总充电时长=" + r9 + " ms, 满10分钟要求=" + this.f + " ms, 满足条件=" + r8);
        return Boolean.valueOf(r8);
    L7:
        if (this.c != 0) goto L37;
        long r12 = this.d;
        if (r12 > 0) goto L11;
        r7 = "BatteryCharge10MinCondition";
    L16:
        if (r12 <= 0) goto L22;
        RunLog r10 = RunLog.INSTANCE;
        StringBuilder r14 = new StringBuilder().append("超过容忍期插电，重新计时: needWait=");
        if (r2 >= 80.0d) goto L20;
        boolean r15 = true;
    L21:
        StringBuilder r11 = r14.append(r15).append(", 断电时间=").append(r4 - this.d).append(" ms");
    L27:
        r10.debug(r7, r11.toString());
        this.e = 0;
        this.d = 0;
        if (r2 >= 80.0d) goto L30;
        boolean r13 = true;
    L31:
        this.h = r13;
    L32:
        this.c = r4;
        if (this.h == false) goto L41;
        long r16 = this.e;
        long r18 = this.f;
        if (r16 >= r18) goto L41;
        long r19 = r18 - r16;
        RunLog.INSTANCE.debug(r7, "设定延时任务，剩余等待时间=" + r19 + " ms");
        a(r19);
        goto L41
    L30:
        r13 = false;
        goto L31
    L20:
        r15 = false;
        goto L21
    L22:
        r10 = RunLog.INSTANCE;
        StringBuilder r20 = new StringBuilder().append("首次插电，开始计时: needWait=");
        if (r2 >= 80.0d) goto L25;
        boolean r110 = true;
    L26:
        r11 = r20.append(r110);
        goto L27
    L25:
        r110 = false;
        goto L26
    L11:
        if ((r4 - r12) > this.g) goto L13;
        this.d = 0;
        r7 = "BatteryCharge10MinCondition";
        RunLog.INSTANCE.debug(r7, "在容忍期内重新插电，恢复计时: accumulatedChargeTime=" + this.e + ", needWait=" + this.h);
        goto L32
    L13:
        r7 = "BatteryCharge10MinCondition";
        goto L16
    L37:
        r7 = "BatteryCharge10MinCondition";
        goto L41
    L54:
        return null;
    }

    @Override // com.obric.memorydata.ability.condition.a
    public com.obric.memorydata.ability.f[] e() {
        return new com.obric.memorydata.ability.f[]{new com.obric.memorydata.ability.f(100000010, MapsKt.mapOf(TuplesKt.to("mode", 1))), new com.obric.memorydata.ability.f(100000010, MapsKt.mapOf(TuplesKt.to("mode", 2))), new com.obric.memorydata.ability.f(100000010, MapsKt.mapOf(TuplesKt.to("mode", 3)))};
    }

    @Override // com.obric.memorydata.ability.condition.a
    public com.obric.memorydata.ability.f f() {
        return new com.obric.memorydata.ability.f(100000010, MapsKt.emptyMap());
    }
}
