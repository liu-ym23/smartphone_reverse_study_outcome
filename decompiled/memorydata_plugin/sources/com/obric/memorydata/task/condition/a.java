package com.obric.memorydata.task.condition;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Handler;
import android.os.PowerManager;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.volcengine.zeus.receiver.PluginBroadcastReceiver;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000'\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0007\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\t\u001a\u00020\nH\u0016J\u0012\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\rH&R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\b¨\u0006\u000e"}, d2 = {"Lcom/obric/memorydata/task/condition/AbstractScreenCondition;", "Lcom/obric/memorydata/task/condition/BaseCondition;", "<init>", "()V", "taskHandler", "Landroid/os/Handler;", "receiver", "com/obric/memorydata/task/condition/AbstractScreenCondition$receiver$1", "Lcom/obric/memorydata/task/condition/AbstractScreenCondition$receiver$1;", "register", "", "notifyConditionChangeListener", "listener", "Lcom/obric/memorydata/task/condition/ConditionChangeListener;", "task_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class a extends b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Handler f12872a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final C0705a f12873b;

    /* JADX INFO: renamed from: com.obric.memorydata.task.condition.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, d2 = {"com/obric/memorydata/task/condition/AbstractScreenCondition$receiver$1", "Landroid/content/BroadcastReceiver;", "onReceive", "", "context", "Landroid/content/Context;", MemorySourceLinkType.INTENT, "Landroid/content/Intent;", "task_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class C0705a extends PluginBroadcastReceiver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ a f12874a;

        C0705a(a r1) {
            this.f12874a = r1;
        }

        private static final void a(Intent r2, a r3) {
            if (r2 == null) goto L18;
            String r4 = r2.getAction();
            if (r4 == null) goto L21;
            Boolean r0 = null;
            if (Intrinsics.areEqual(r4, "android.intent.action.SCREEN_ON") == false) goto L11;
            boolean r5 = true;
        L9:
            r0 = Boolean.valueOf(r5);
        L13:
            if (r0 != null) goto L15;
            return;
        L15:
            if (Intrinsics.areEqual(r0, Boolean.valueOf(r3.i())) == true) goto L20;
            r3.b(r0.booleanValue());
            r3.a(r3.h());
            return;
        L20:
            return;
        L11:
            if (Intrinsics.areEqual(r4, "android.intent.action.SCREEN_OFF") == false) goto L13;
            r5 = false;
            goto L9
        L21:
            return;
        }

        public static /* synthetic */ void lambda$A_i5uXDQJnnnb1WUrFvDZV1sKGw(Intent r0, a r1) {
            a(r0, r1);
        }

        public void onReceive(Context r3, final Intent r4) {
            Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
            Handler r6 = a.a(this.f12874a);
            final a r2 = this.f12874a;
            r6.post(new $$Lambda$a$a$A_i5uXDQJnnnb1WUrFvDZV1sKGw(r4, r2));
        }
    }

    public a() {
        this.f12872a = new Handler(com.obric.memorydata.task.e.f12914a.a().getLooper());
        this.f12873b = new C0705a(this);
    }

    public static final /* synthetic */ Handler a(a r0) {
        return r0.f12872a;
    }

    public abstract void a(d r1);

    @Override // com.obric.memorydata.task.condition.b
    public void b() {
        Object r0 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getSystemService("power");
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type android.os.PowerManager");
        b(((PowerManager) ZeusTransformUtils.preCheckCast(r0, PowerManager.class, "com.obric.memorydata.plugin")).isInteractive());
        IntentFilter r1 = new IntentFilter();
        r1.addAction("android.intent.action.SCREEN_ON");
        r1.addAction("android.intent.action.SCREEN_OFF");
        if (Build.VERSION.SDK_INT < 33) goto L5;
        ZeusTransformUtils.registerReceiver((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), (PluginBroadcastReceiver) ZeusTransformUtils.preCheckCast(this.f12873b, PluginBroadcastReceiver.class, "com.obric.memorydata.plugin"), r1, 2, "com.obric.memorydata.plugin");
        return;
    L5:
        ZeusTransformUtils.registerReceiver((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), (PluginBroadcastReceiver) ZeusTransformUtils.preCheckCast(this.f12873b, PluginBroadcastReceiver.class, "com.obric.memorydata.plugin"), r1, "com.obric.memorydata.plugin");
    }
}
