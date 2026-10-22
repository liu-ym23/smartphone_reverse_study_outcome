package com.obric.assistant.zeus.plugin.debuginfo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.state.ObricSharedStateDelegate;
import com.obric.assistant.zeus.plugin.IZeusPluginService;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import gia.b;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016¨\u0006\u000b"}, d2 = {"Lcom/obric/assistant/zeus/plugin/debuginfo/ZeusDebugInfoReceiver;", "Landroid/content/BroadcastReceiver;", "<init>", "()V", "onReceive", "", "context", "Landroid/content/Context;", MemorySourceLinkType.INTENT, "Landroid/content/Intent;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ZeusDebugInfoReceiver extends BroadcastReceiver {
    public static final /* synthetic */ int a = 0;

    public static final class a {
    }

    static {
    }

    public ZeusDebugInfoReceiver() {
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context r6, Intent r7) {
        AppHost.Companion r8 = AppHost.a;
        Bundle r9 = r8.getApplication().getPackageManager().getApplicationInfo(r8.getApplication().getPackageName(), 128).metaData;
        Intrinsics.checkNotNull(r9);
        int r10 = r9.getInt("ZEUS_HOST_PROTOCOL_VERSION");
        ObricSharedStateDelegate r11 = ObricSharedStateDelegate.c;
        Integer r0 = r11.b("zeus_memory_version");
        int r1 = -1;
        if (r0 == null) goto L5;
        int r2 = r0.intValue();
    L6:
        Integer r12 = r11.b("zeus_aiagent_version");
        if (r12 == null) goto L9;
        r1 = r12.intValue();
    L9:
        b r3 = new b("com.obric.aiagent.plugin", r1);
        boolean r4 = true;
        List r5 = CollectionsKt.listOf(new b[]{new b("com.obric.memorydata.plugin", r2), r3});
        IZeusPluginService r13 = (IZeusPluginService) ServiceManager.get().getService(IZeusPluginService.class);
        if (r13 != null) goto L12;
    L14:
        r4 = false;
    L15:
        String r14 = com.larus.utils.gson.b.a(new gia.a(r10, r5, r4));
        FLogger.a.i("ZeusDebugInfoReceiver", "generate debuginfo\n" + r14);
        setResult(0, r14, Bundle.EMPTY);
        return;
    L12:
        if (r13.e() != true) goto L14;
    L5:
        r2 = -1;
        goto L6
    }
}
