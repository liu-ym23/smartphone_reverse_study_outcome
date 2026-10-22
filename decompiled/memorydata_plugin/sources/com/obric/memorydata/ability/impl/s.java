package com.obric.memorydata.ability.impl;

import android.content.Context;
import android.os.PowerManager;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.middleware.impl.bdtracker.TrackerImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 !2\u00020\u00012\u00020\u0002:\u0001!B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0006H\u0016J\b\u0010\u0016\u001a\u00020\u0014H\u0016J\u0018\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0018\u0010\u001b\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0018\u0010\u001c\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0010\u0010\u001d\u001a\u00020\u00142\u0006\u0010\u001e\u001a\u00020\u000eH\u0016J\b\u0010\u001f\u001a\u00020\u0014H\u0002J\u0010\u0010 \u001a\u00020\u00142\u0006\u0010\u001e\u001a\u00020\u000eH\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000fR\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/obric/memorydata/ability/impl/TemperatureStateAbility;", "Lcom/obric/memorydata/ability/impl/IMetaAbility;", "Landroid/os/PowerManager$OnThermalStatusChangedListener;", "<init>", "()V", "abilityContext", "Lcom/obric/memorydata/ability/IAbilityContext;", "context", "Landroid/content/Context;", "isRegistered", "", "powerManager", "Landroid/os/PowerManager;", "currentState", "", "Ljava/lang/Integer;", "subscribedKeys", "Ljava/util/concurrent/CopyOnWriteArraySet;", "", "onCreate", "", "iAbilityContext", "onDestroy", "onQuery", "key", TrackerImpl.PARAMS, "Lcom/obric/memorydata/ability/AbilityParams;", "onSubscribe", "onUnsubscribe", "onThermalStatusChanged", "status", "doUnsubscribe", "publishStateData", "Companion", "ability_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class s implements PowerManager.OnThermalStatusChangedListener, i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f8414a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.obric.memorydata.ability.j f8415b;
    private Context c;
    private boolean d;
    private PowerManager e;
    private Integer f;
    private CopyOnWriteArraySet<String> g;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/ability/impl/TemperatureStateAbility$Companion;", "", "<init>", "()V", "TAG", "", "ability_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f8414a = new a(null);
    }

    public s() {
        this.g = new CopyOnWriteArraySet();
    }

    private final void a(int r6) {
        this.f = Integer.valueOf(r6);
        com.obric.memorydata.ability.data.s r0 = new com.obric.memorydata.ability.data.s(r6);
        Iterator<String> r7 = this.g.iterator();
        Intrinsics.checkNotNullExpressionValue(r7, "iterator(...)");
    L4:
        if (r7.hasNext() == false) goto L8;
        com.obric.memorydata.ability.j r1 = this.f8415b;
        if (r1 == null) goto L4;
        String r2 = r7.next();
        Intrinsics.checkNotNullExpressionValue(r2, "next(...)");
        r1.a((String) ZeusTransformUtils.preCheckCast(r2, String.class, "com.obric.memorydata.plugin"), (com.obric.memorydata.ability.data.h) ZeusTransformUtils.preCheckCast(r0, com.obric.memorydata.ability.data.h.class, "com.obric.memorydata.plugin"));
        goto L4
    }

    private final void b() {
        if (this.d == false) goto L9;
        PowerManager r0 = this.e;
        if (r0 == null) goto L7;
        r0.removeThermalStatusListener((PowerManager.OnThermalStatusChangedListener) ZeusTransformUtils.preCheckCast(this, PowerManager.OnThermalStatusChangedListener.class, "com.obric.memorydata.plugin"));
    L7:
        this.d = false;
        return;
    }

    @Override // com.obric.memorydata.ability.impl.i
    public void a() {
        b();
        this.f8415b = null;
        this.c = ZeusTransformUtils.wrapperContext(null, "com.obric.memorydata.plugin");
        this.e = null;
    }

    @Override // com.obric.memorydata.ability.impl.i
    public void a(com.obric.memorydata.ability.j r4) {
        com.obric.memorydata.ability.j r5 = (com.obric.memorydata.ability.j) ZeusTransformUtils.wrapperContextForParams(r4, com.obric.memorydata.ability.j.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "iAbilityContext");
        this.f8415b = r5;
        Context r6 = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r5.a(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
        this.c = r6;
        PowerManager r0 = null;
        if (r6 == null) goto L5;
        Object r7 = r6.getSystemService("power");
    L7:
        if (ZeusTransformUtils.instanceOf(r7, PowerManager.class) == false) goto L9;
        r0 = (PowerManager) ZeusTransformUtils.preCheckCast(r7, PowerManager.class, "com.obric.memorydata.plugin");
    L9:
        this.e = r0;
        return;
    L5:
        r7 = null;
        goto L7
    }

    @Override // com.obric.memorydata.ability.impl.i
    public boolean a(com.obric.memorydata.ability.f r1) {
        return i.a.a(this, r1);
    }

    @Override // com.obric.memorydata.ability.impl.i
    public boolean a(String r8, com.obric.memorydata.ability.f r9) {
        Intrinsics.checkNotNullParameter(r8, "key");
        Intrinsics.checkNotNullParameter(r9, TrackerImpl.PARAMS);
        PowerManager r10 = this.e;
        if (r10 == null) goto L9;
        this.g.add(r8);
        if (this.d == false) goto L8;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "TemperatureStateAbility", "onSubscribe, already registered", false, 4, null);
        return true;
    L8:
        this.d = true;
        r10.addThermalStatusListener((PowerManager.OnThermalStatusChangedListener) ZeusTransformUtils.preCheckCast(this, PowerManager.OnThermalStatusChangedListener.class, "com.obric.memorydata.plugin"));
        return true;
    L9:
        return false;
    }

    @Override // com.obric.memorydata.ability.impl.i
    public boolean b(String r2, com.obric.memorydata.ability.f r3) {
        Intrinsics.checkNotNullParameter(r2, "key");
        Intrinsics.checkNotNullParameter(r3, TrackerImpl.PARAMS);
        this.g.remove(r2);
        if (this.g.isEmpty() == false) goto L7;
        b();
        return true;
    L7:
        return true;
    }

    @Override // com.obric.memorydata.ability.impl.i
    public boolean c(String r11, com.obric.memorydata.ability.f r12) {
        Intrinsics.checkNotNullParameter(r11, "key");
        Intrinsics.checkNotNullParameter(r12, TrackerImpl.PARAMS);
        PowerManager r2 = this.e;     // Catch: Exception -> L14
        if (r2 == null) goto L7;
        Integer r3 = Integer.valueOf(r2.getCurrentThermalStatus());     // Catch: Exception -> L14
    L8:
        if (r3 != null) goto L10;
        return false;
    L10:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "TemperatureStateAbility", "onQuery: " + r3, false, 4, null);
        com.obric.memorydata.ability.j r10 = this.f8415b;
        if (r10 == null) goto L19;
        r10.a(r11, (com.obric.memorydata.ability.data.h) ZeusTransformUtils.preCheckCast(new com.obric.memorydata.ability.data.s(((Number) ZeusTransformUtils.preCheckCast(r3, Number.class, "com.obric.memorydata.plugin")).intValue()), com.obric.memorydata.ability.data.h.class, "com.obric.memorydata.plugin"));
        return true;
    L19:
        return false;
    L7:
        r3 = null;
    L14:
        e = move-exception;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "TemperatureStateAbility", "onQuery: " + e.getMessage(), null, 4, null);
        return false;
    }

    @Override // android.os.PowerManager.OnThermalStatusChangedListener
    public void onThermalStatusChanged(int r8) {
        Integer r0 = this.f;
        if (r0 != null) goto L6;
    L8:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "TemperatureStateAbility", "onThermalStatusChanged status: " + r8, false, 4, null);
        a(r8);
        return;
    L6:
        if (r8 != r0.intValue()) goto L8;
    }
}
