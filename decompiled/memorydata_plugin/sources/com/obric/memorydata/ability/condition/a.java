package com.obric.memorydata.ability.condition;

import com.obric.memorydata.ability.data.h;
import com.obric.memorydata.ability.k;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.task.condition.Condition;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000E\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u0010\b&\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\rH\u0016J\u0006\u0010\u0015\u001a\u00020\u0013J\u0013\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017H&¢\u0006\u0002\u0010\u0019J\b\u0010\u001a\u001a\u00020\u0018H&J\u0017\u0010\u001b\u001a\u0004\u0018\u00010\r2\u0006\u0010\u001c\u001a\u00020\u001dH&¢\u0006\u0002\u0010\u001eJ\b\u0010\u001f\u001a\u00020\u0013H\u0002J\u0010\u0010 \u001a\u00020\u00132\u0006\u0010!\u001a\u00020\rH\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\tX\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0011¨\u0006#"}, d2 = {"Lcom/obric/memorydata/ability/condition/AbilityStateCondition;", "Lcom/obric/memorydata/task/condition/BaseCondition;", "condition", "Lcom/obric/memorydata/task/condition/Condition;", "<init>", "(Lcom/obric/memorydata/task/condition/Condition;)V", "getCondition", "()Lcom/obric/memorydata/task/condition/Condition;", "abilityManager", "Lcom/obric/memorydata/ability/AbilityManager;", "getAbilityManager", "()Lcom/obric/memorydata/ability/AbilityManager;", "isRegistered", "", "isInit", "dateReceiver", "com/obric/memorydata/ability/condition/AbilityStateCondition$dateReceiver$1", "Lcom/obric/memorydata/ability/condition/AbilityStateCondition$dateReceiver$1;", "register", "", "isSatisfied", "unregister", "getSubscribeAbilityParams", "", "Lcom/obric/memorydata/ability/AbilityParams;", "()[Lcom/obric/memorydata/ability/AbilityParams;", "getQueryAbilityParams", "extractState", "data", "Lcom/obric/memorydata/ability/data/IStandardData;", "(Lcom/obric/memorydata/ability/data/IStandardData;)Ljava/lang/Boolean;", "initStatus", "updateStatus", "newStatus", "Companion", "ability_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class a extends com.obric.memorydata.task.condition.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0417a f8309a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Condition f8310b;
    private final com.obric.memorydata.ability.d c;
    private boolean d;
    private boolean e;
    private final b f;

    /* JADX INFO: renamed from: com.obric.memorydata.ability.condition.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/ability/condition/AbilityStateCondition$Companion;", "", "<init>", "()V", "TAG", "", "ability_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class C0417a {
        private C0417a() {
        }

        public /* synthetic */ C0417a(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/obric/memorydata/ability/condition/AbilityStateCondition$dateReceiver$1", "Lcom/obric/memorydata/ability/IAbilityDataReceiver;", "onDataReceive", "", "data", "Lcom/obric/memorydata/ability/data/IStandardData;", "ability_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b implements k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ a f8311a;

        b(a r1) {
            this.f8311a = r1;
        }

        @Override // com.obric.memorydata.ability.k
        public void a(h r3) {
            h r4 = (h) ZeusTransformUtils.wrapperContextForParams(r3, h.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r4, "data");
            Boolean r5 = this.f8311a.a(r4);
            if (r5 == null) goto L6;
            this.f8311a.a(r5.booleanValue());
            return;
        }

        @Override // com.obric.memorydata.ability.k
        public String g_() {
            return k.a.a(this);
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/obric/memorydata/ability/condition/AbilityStateCondition$initStatus$1", "Lcom/obric/memorydata/ability/IAbilityDataReceiver;", "onDataReceive", "", "data", "Lcom/obric/memorydata/ability/data/IStandardData;", "ability_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class c implements k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ a f8312a;

        c(a r1) {
            this.f8312a = r1;
        }

        @Override // com.obric.memorydata.ability.k
        public void a(h r3) {
            h r4 = (h) ZeusTransformUtils.wrapperContextForParams(r3, h.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r4, "data");
            Boolean r5 = this.f8312a.a(r4);
            if (r5 == null) goto L6;
            this.f8312a.a(r5.booleanValue());
            return;
        }

        @Override // com.obric.memorydata.ability.k
        public String g_() {
            return k.a.a(this);
        }
    }

    static {
        f8309a = new C0417a(null);
    }

    public a(Condition r2) {
        Intrinsics.checkNotNullParameter(r2, "condition");
        this.f8310b = r2;
        this.c = new com.obric.memorydata.ability.d();
        this.f = new b(this);
    }

    private final void j() {
        if (this.e == false) goto L5;
        return;
    L5:
        this.c.query(f(), (k) ZeusTransformUtils.preCheckCast(new c(this), k.class, "com.obric.memorydata.plugin"));
    }

    public final com.obric.memorydata.ability.d a() {
        return this.c;
    }

    public abstract Boolean a(h r1);

    public final void a(boolean r8) {
        if (this.e == true) goto L5;
    L6:
        this.e = true;
        b(r8);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AbilityStateCondition", "condition: " + this.f8310b.getValue() + ", updateStatus: " + r8, false, 4, null);
        com.obric.memorydata.task.condition.d r9 = h();
        if (r9 == null) goto L11;
        r9.onConditionChange(this.f8310b, i());
        return;
    L11:
        return;
    L5:
        if (r8 != i()) goto L6;
    }

    @Override // com.obric.memorydata.task.condition.b
    public void b() {
        if (this.d == false) goto L5;
        return;
    L5:
        j();
        this.d = true;
        com.obric.memorydata.ability.f[] r0 = e();
        int r1 = 0;
        int r2 = r0.length;
    L6:
        if (r1 >= r2) goto L8;
        com.obric.memorydata.ability.f r3 = r0[r1];
        this.c.a(r3, (k) ZeusTransformUtils.preCheckCast(this.f, k.class, "com.obric.memorydata.plugin"));
        r1 = r1 + 1;
        goto L6
    }

    @Override // com.obric.memorydata.task.condition.b
    public boolean c() {
        j();
        return i();
    }

    public final void d() {
        if (this.d == true) goto L5;
        return;
    L5:
        com.obric.memorydata.ability.f[] r0 = e();
        int r1 = r0.length;
        int r3 = 0;
    L6:
        if (r3 >= r1) goto L8;
        this.c.b(r0[r3], (k) ZeusTransformUtils.preCheckCast(this.f, k.class, "com.obric.memorydata.plugin"));
        r3 = r3 + 1;
        goto L6
    L8:
        this.d = false;
    }

    public abstract com.obric.memorydata.ability.f[] e();

    public abstract com.obric.memorydata.ability.f f();
}
