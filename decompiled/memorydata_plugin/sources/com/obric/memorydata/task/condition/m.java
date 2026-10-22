package com.obric.memorydata.task.condition;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.NetworkInfo;
import com.bytedance.common.utility.NetworkUtils;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import com.obric.memorydata.middleware.api.app.UserSettings;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.receiver.PluginBroadcastReceiver;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000)\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0005\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\nH\u0016J\u0006\u0010\u000b\u001a\u00020\nJ\b\u0010\f\u001a\u00020\rH\u0016R\u0010\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/obric/memorydata/task/condition/WifiConnectedCondition;", "Lcom/obric/memorydata/task/condition/BaseCondition;", "<init>", "()V", "receiver", "com/obric/memorydata/task/condition/WifiConnectedCondition$receiver$1", "Lcom/obric/memorydata/task/condition/WifiConnectedCondition$receiver$1;", "getUnsatisfiedReason", "", "register", "", "unregister", "isSatisfied", "", "Companion", "task_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class m extends com.obric.memorydata.task.condition.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f12894a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final b f12895b;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/task/condition/WifiConnectedCondition$Companion;", "", "<init>", "()V", "TAG", "", "task_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, d2 = {"com/obric/memorydata/task/condition/WifiConnectedCondition$receiver$1", "Landroid/content/BroadcastReceiver;", "onReceive", "", "context", "Landroid/content/Context;", MemorySourceLinkType.INTENT, "Landroid/content/Intent;", "task_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b extends PluginBroadcastReceiver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ m f12896a;

        b(m r1) {
            this.f12896a = r1;
        }

        public void onReceive(Context r3, Intent r4) {
            Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
            if (r4 == null) goto L5;
            String r6 = r4.getAction();
        L7:
            if (Intrinsics.areEqual(r6, "android.net.wifi.STATE_CHANGE") == true) goto L9;
            return;
        L9:
            if (UserSettings.INSTANCE.hasAgreePrivacy() == true) goto L11;
            return;
        L11:
            NetworkInfo r7 = (NetworkInfo) ZeusTransformUtils.preCheckCast(r4.getParcelableExtra("networkInfo"), NetworkInfo.class, "com.obric.memorydata.plugin");
            boolean r8 = true;
            if (r7 != null) goto L14;
        L16:
            r8 = false;
        L18:
            if (r8 == this.f12896a.i()) goto L24;
            this.f12896a.b(r8);
            RunLog.INSTANCE.debug("WifiConnectedCondition", "wifi connect status => " + this.f12896a.i());
            d r9 = this.f12896a.h();
            if (r9 == null) goto L25;
            r9.onConditionChange(Condition.WIFI_CONNECTED, this.f12896a.i());
            return;
        L25:
            return;
        L24:
            return;
        L14:
            if (r7.isConnected() != true) goto L16;
        L5:
            r6 = null;
            goto L7
        }
    }

    static {
        f12894a = new a(null);
    }

    public m() {
        this.f12895b = new b(this);
    }

    public final void a() {
        ZeusTransformUtils.unregisterReceiver((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), (PluginBroadcastReceiver) ZeusTransformUtils.preCheckCast(this.f12895b, PluginBroadcastReceiver.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
    }

    @Override // com.obric.memorydata.task.condition.b
    public void b() {
        if (UserSettings.INSTANCE.hasAgreePrivacy() == false) goto L5;
        boolean r0 = NetworkUtils.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
    L6:
        b(r0);
        IntentFilter r1 = new IntentFilter("android.net.wifi.STATE_CHANGE");
        ZeusTransformUtils.registerReceiver((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), (PluginBroadcastReceiver) ZeusTransformUtils.preCheckCast(this.f12895b, PluginBroadcastReceiver.class, "com.obric.memorydata.plugin"), r1, "com.obric.memorydata.plugin");
        return;
    L5:
        r0 = true;
        goto L6
    }

    @Override // com.obric.memorydata.task.condition.b
    public boolean c() {
        if (UserSettings.INSTANCE.hasAgreePrivacy() == true) goto L7;
        return true;
    L7:
        return i();
    }

    @Override // com.obric.memorydata.task.condition.b
    public String g() {
        if (c() == false) goto L7;
        return "";
    L7:
        return "WifiConnectedCondition(isWifiConnected=" + i() + ')';
    }
}
