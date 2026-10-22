package com.obric.memorydata.memory.lab;

import android.content.Context;
import android.content.Intent;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import com.obric.memorydata.memory.ui.settings.l;
import com.obric.memorydata.memory.utils.v;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.receiver.PluginBroadcastReceiver;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016¨\u0006\u000b"}, d2 = {"Lcom/obric/memorydata/memory/lab/AILabPackageInstallReceiver;", "Landroid/content/BroadcastReceiver;", "<init>", "()V", "onReceive", "", "context", "Landroid/content/Context;", MemorySourceLinkType.INTENT, "Landroid/content/Intent;", "Companion", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AILabPackageInstallReceiver extends PluginBroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f10235a = null;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/memory/lab/AILabPackageInstallReceiver$Companion;", "", "<init>", "()V", "TAG", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f10235a = new a(null);
    }

    public AILabPackageInstallReceiver() {
    }

    public void onReceive(Context r8, Intent r9) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.memorydata.plugin");
        if (r7 == null) goto L18;
        if (r9 != null) goto L7;
        return;
    L7:
        if (v.f11566a.b() == true) goto L16;
        return;
    L16:
    L13:
        e = move-exception;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "PackageInstallReceiver", "处理包变更广播失败: " + e.getMessage(), null, 4, null);
        return;
    L10:
        if (Intrinsics.areEqual(r9.getAction(), "android.intent.action.MY_PACKAGE_REPLACED") == false) goto L19;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "PackageInstallReceiver", "设置应用自身被更新，重新检查权限状态", false, 4, null);     // Catch: Exception -> L13
        com.obric.memorydata.memory.lab.a.f10241a.b(r7);     // Catch: Exception -> L13
        l.f11479a.a().g(r7);     // Catch: Exception -> L13
        return;
    L19:
        return;
    }
}
