package com.obric.memorydata.ability.impl;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.SystemClock;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.middleware.impl.bdtracker.TrackerImpl;
import com.volcengine.zeus.receiver.PluginBroadcastReceiver;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00182\u00020\u00012\u00020\u0002:\u0001\u0018B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0006H\u0016J\b\u0010\f\u001a\u00020\nH\u0002J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0018\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0014\u001a\u00020\nH\u0016J\u001c\u0010\u0015\u001a\u00020\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/obric/memorydata/ability/impl/DeviceShutdownAbility;", "Landroid/content/BroadcastReceiver;", "Lcom/obric/memorydata/ability/impl/IMetaAbility;", "<init>", "()V", "abilityContext", "Lcom/obric/memorydata/ability/IAbilityContext;", "context", "Landroid/content/Context;", "onCreate", "", "iAbilityContext", "registerShutdownReceiver", "onSubscribe", "", "key", "", TrackerImpl.PARAMS, "Lcom/obric/memorydata/ability/AbilityParams;", "onUnsubscribe", "onDestroy", "onReceive", MemorySourceLinkType.INTENT, "Landroid/content/Intent;", "Companion", "ability_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class f extends PluginBroadcastReceiver implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f8376a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.obric.memorydata.ability.j f8377b;
    private Context c;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/ability/impl/DeviceShutdownAbility$Companion;", "", "<init>", "()V", "TAG", "", "ability_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f8376a = new a(null);
    }

    public f() {
    }

    private final void b() {
        IntentFilter r0 = new IntentFilter();
        r0.addAction("android.intent.action.ACTION_SHUTDOWN");
        Context r1 = this.c;
        Intrinsics.checkNotNull(r1);
        ZeusTransformUtils.registerReceiver(r1, (PluginBroadcastReceiver) ZeusTransformUtils.preCheckCast(this, PluginBroadcastReceiver.class, "com.obric.memorydata.plugin"), r0, 2, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.memorydata.ability.impl.i
    public void a() {
        Context r0 = this.c;
        Intrinsics.checkNotNull(r0);
        ZeusTransformUtils.unregisterReceiver(r0, (PluginBroadcastReceiver) ZeusTransformUtils.preCheckCast(this, PluginBroadcastReceiver.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
        this.c = ZeusTransformUtils.wrapperContext(null, "com.obric.memorydata.plugin");
        this.f8377b = null;
    }

    @Override // com.obric.memorydata.ability.impl.i
    public void a(com.obric.memorydata.ability.j r3) {
        com.obric.memorydata.ability.j r4 = (com.obric.memorydata.ability.j) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.memorydata.ability.j.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "iAbilityContext");
        this.f8377b = r4;
        this.c = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.a(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
        b();
    }

    @Override // com.obric.memorydata.ability.impl.i
    public boolean a(com.obric.memorydata.ability.f r1) {
        return i.a.a(this, r1);
    }

    @Override // com.obric.memorydata.ability.impl.i
    public boolean a(String r7, com.obric.memorydata.ability.f r8) {
        Intrinsics.checkNotNullParameter(r7, "key");
        Intrinsics.checkNotNullParameter(r8, TrackerImpl.PARAMS);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "DeviceShutdownAbility", "onSubscribe", false, 4, null);
        return true;
    }

    @Override // com.obric.memorydata.ability.impl.i
    public boolean b(String r7, com.obric.memorydata.ability.f r8) {
        Intrinsics.checkNotNullParameter(r7, "key");
        Intrinsics.checkNotNullParameter(r8, TrackerImpl.PARAMS);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "DeviceShutdownAbility", "onUnsubscribe", false, 4, null);
        return true;
    }

    @Override // com.obric.memorydata.ability.impl.i
    public boolean c(String r1, com.obric.memorydata.ability.f r2) {
        return i.a.a(this, r1, r2);
    }

    public void onReceive(Context r9, Intent r10) {
        if (((Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin")) == null) goto L12;
        if (r10 == null) goto L15;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "DeviceShutdownAbility", "broadcast onReceive: " + r10.getAction(), false, 4, null);
        if (Intrinsics.areEqual("android.intent.action.ACTION_SHUTDOWN", r10.getAction()) == false) goto L13;
        com.obric.memorydata.ability.j r8 = this.f8377b;
        if (r8 == null) goto L14;
        r8.a((com.obric.memorydata.ability.data.h) ZeusTransformUtils.preCheckCast(new com.obric.memorydata.ability.data.e(SystemClock.elapsedRealtime() / ((long) 1000)), com.obric.memorydata.ability.data.h.class, "com.obric.memorydata.plugin"));
        return;
    L14:
        return;
    L13:
        return;
    L15:
        return;
    }
}
