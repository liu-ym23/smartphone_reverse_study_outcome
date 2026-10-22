package com.obric.assistant.zeus.plugin;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, d2 = {"com/obric/assistant/zeus/plugin/ZeusAutoFetchManager$init$2", "Landroid/content/BroadcastReceiver;", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ZeusAutoFetchManager$init$2 extends BroadcastReceiver {
    public ZeusAutoFetchManager$init$2() {
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context r2, Intent r3) {
        if (r3 == null) goto L4;
        String r4 = r3.getAction();
    L6:
        if (Intrinsics.areEqual("android.intent.action.USER_PRESENT", r4) == false) goto L9;
        FLogger.a.i("ZeusAutoFetchManager", "User unlocked screen, triggering fetch for all plugins");
        c r5 = c.a;
        c.c("user_present");
        return;
    L9:
        return;
    L4:
        r4 = null;
        goto L6
    }
}
