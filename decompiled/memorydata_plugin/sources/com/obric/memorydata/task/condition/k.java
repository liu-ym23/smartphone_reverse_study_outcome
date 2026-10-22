package com.obric.memorydata.task.condition;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.PowerManager;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.volcengine.zeus.receiver.PluginBroadcastReceiver;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\t\u0018\u0000 \u00142\u00020\u00012\u00020\u0002:\u0001\u0014B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u000b\u001a\u00020\fH\u0017J\b\u0010\r\u001a\u00020\u0006H\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\fH\u0002J\u0018\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\u0006H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/obric/memorydata/task/condition/ScreenOnOrChargeCondition;", "Lcom/obric/memorydata/task/condition/BaseCondition;", "Lcom/obric/memorydata/task/condition/ConditionChangeListener;", "<init>", "()V", "isScreenOn", "", "isPowerConnect", "screenStateReceiver", "com/obric/memorydata/task/condition/ScreenOnOrChargeCondition$screenStateReceiver$1", "Lcom/obric/memorydata/task/condition/ScreenOnOrChargeCondition$screenStateReceiver$1;", "register", "", "isSatisfied", "getUnsatisfiedReason", "", "notifyConditionChangeIfNeeded", "onConditionChange", "condition", "Lcom/obric/memorydata/task/condition/Condition;", "Companion", "task_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class k extends com.obric.memorydata.task.condition.b implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f12891a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f12892b;
    private boolean c;
    private final b d;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/task/condition/ScreenOnOrChargeCondition$Companion;", "", "<init>", "()V", "TAG", "", "task_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, d2 = {"com/obric/memorydata/task/condition/ScreenOnOrChargeCondition$screenStateReceiver$1", "Landroid/content/BroadcastReceiver;", "onReceive", "", "context", "Landroid/content/Context;", MemorySourceLinkType.INTENT, "Landroid/content/Intent;", "task_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b extends PluginBroadcastReceiver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ k f12893a;

        b(k r1) {
            this.f12893a = r1;
        }

        public void onReceive(Context r3, Intent r4) {
            Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
            if (r4 == null) goto L19;
            String r6 = r4.getAction();
            if (r6 == null) goto L22;
            Boolean r7 = null;
            if (Intrinsics.areEqual(r6, "android.intent.action.SCREEN_ON") == false) goto L12;
            boolean r8 = true;
        L10:
            r7 = Boolean.valueOf(r8);
        L14:
            if (r7 != null) goto L16;
            return;
        L16:
            if (Intrinsics.areEqual(r7, Boolean.valueOf(k.a(this.f12893a))) == true) goto L21;
            k.a(this.f12893a, r7.booleanValue());
            k.b(this.f12893a);
            return;
        L21:
            return;
        L12:
            if (Intrinsics.areEqual(r6, "android.intent.action.SCREEN_OFF") == false) goto L14;
            r8 = false;
            goto L10
        L22:
            return;
        }
    }

    static {
        f12891a = new a(null);
    }

    public k() {
        this.d = new b(this);
    }

    private final void a() {
        if (c() == i()) goto L8;
        b(c());
        d r0 = h();
        if (r0 == null) goto L9;
        r0.onConditionChange(Condition.SCREEN_ON_OR_CHARGE, i());
        return;
    L9:
        return;
    }

    public static final /* synthetic */ void a(k r0, boolean r1) {
        r0.f12892b = r1;
    }

    public static final /* synthetic */ boolean a(k r0) {
        return r0.f12892b;
    }

    public static final /* synthetic */ void b(k r0) {
        r0.a();
    }

    @Override // com.obric.memorydata.task.condition.b
    public void b() {
        Object r0 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getSystemService("power");
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type android.os.PowerManager");
        this.f12892b = ((PowerManager) ZeusTransformUtils.preCheckCast(r0, PowerManager.class, "com.obric.memorydata.plugin")).isInteractive();
        IntentFilter r1 = new IntentFilter();
        r1.addAction("android.intent.action.SCREEN_ON");
        r1.addAction("android.intent.action.SCREEN_OFF");
        ZeusTransformUtils.registerReceiver((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), (PluginBroadcastReceiver) ZeusTransformUtils.preCheckCast(this.d, PluginBroadcastReceiver.class, "com.obric.memorydata.plugin"), r1, 2, "com.obric.memorydata.plugin");
        com.obric.memorydata.task.condition.b r2 = AbilityConditionManager.INSTANCE.createPowerConnectedCondition();
        r2.b();
        r2.b((d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.task.condition.b
    public boolean c() {
        if (this.f12892b == false) goto L5;
    L8:
        return true;
    L5:
        if (this.c == true) goto L8;
        return false;
    }

    @Override // com.obric.memorydata.task.condition.b
    public String g() {
        if (c() == false) goto L7;
        return "";
    L7:
        return "ScreenOnOrChargeCondition(isScreenOn=" + this.f12892b + ", isPowerConnect=" + this.c + ')';
    }

    @Override // com.obric.memorydata.task.condition.d
    public void onConditionChange(Condition r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "condition");
        if (this.c != r3) goto L5;
        return;
    L5:
        this.c = r3;
        a();
    }
}
