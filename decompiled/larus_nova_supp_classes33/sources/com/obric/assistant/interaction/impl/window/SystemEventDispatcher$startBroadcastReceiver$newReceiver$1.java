package com.obric.assistant.interaction.impl.window;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.event.WindowEvent;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/obric/assistant/interaction/impl/window/SystemEventDispatcher$startBroadcastReceiver$newReceiver$1", "Landroid/content/BroadcastReceiver;", "onReceive", "", "ctx", "Landroid/content/Context;", MemorySourceLinkType.INTENT, "Landroid/content/Intent;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SystemEventDispatcher$startBroadcastReceiver$newReceiver$1 extends BroadcastReceiver {
    final /* synthetic */ SystemEventDispatcher this$0;

    public SystemEventDispatcher$startBroadcastReceiver$newReceiver$1(SystemEventDispatcher r1) {
        this.this$0 = r1;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context r5, Intent r6) {
        Intrinsics.checkNotNullParameter(r5, "ctx");
        Intrinsics.checkNotNullParameter(r6, MemorySourceLinkType.INTENT);
        if (SystemEventDispatcher.access$getStarted$p(this.this$0) == true) goto L5;
        return;
    L5:
        if (SystemEventDispatcher.access$getReceiver$p(this.this$0) != this) goto L40;
        String r7 = r6.getAction();
        FLogger r0 = FLogger.a;
        r0.i("SystemEventDispatcher", "onReceive action: " + r7);
        if (Intrinsics.areEqual("android.intent.action.CLOSE_SYSTEM_DIALOGS", r7) == false) goto L28;
        String r8 = r6.getStringExtra(WindowEvent.Params.REASON);
        r0.i("SystemEventDispatcher", "onReceive action: " + r7 + ", reason: " + r8);
        if (r8 == null) goto L35;
        int r9 = r8.hashCode();
        if (r9 == 350448461) goto L25;
        if (r9 == 1092716832) goto L22;
        if (r9 == 2014770135) goto L19;
        return;
    L19:
        if (r8.equals("fs_gesture") == false) goto L42;
    L26:
        SystemEventDispatcher.access$getListener$p(this.this$0).onHomeKeyOrRecent();
        return;
    L42:
        return;
    L22:
        if (r8.equals("homekey") == true) goto L26;
        return;
    L25:
        if (r8.equals("recentapps") == true) goto L26;
        return;
    L35:
        return;
    L28:
        if (Intrinsics.areEqual("android.intent.action.SCREEN_OFF", r7) == false) goto L31;
        SystemEventDispatcher.access$dispatchScreenOff(this.this$0, "broadcast");
        return;
    L31:
        if (Intrinsics.areEqual("android.intent.action.SCREEN_ON", r7) == false) goto L39;
        SystemEventDispatcher.access$setScreenOffDispatched$p(this.this$0, false);
        return;
    L39:
        return;
    }
}
