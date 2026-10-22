package com.obric.assistant.live.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.api.IKeyguardStateKt;
import com.obric.assistant.spi.keyguard.IKeyguardService$a;
import com.obric.assistant.spi.keyguard.KeyguardService;
import com.obric.assistant.t1;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010\n\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0002¨\u0006\f"}, d2 = {"Lcom/obric/assistant/live/receiver/GRIslandReceiver;", "Landroid/content/BroadcastReceiver;", "<init>", "()V", "onReceive", "", "context", "Landroid/content/Context;", MemorySourceLinkType.INTENT, "Landroid/content/Intent;", "sendForwardIntent", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GRIslandReceiver extends BroadcastReceiver {
    public static final /* synthetic */ int a = 0;

    public static final class a {
    }

    public static final class b implements oga.a {
        public final /* synthetic */ GRIslandReceiver a;
        public final /* synthetic */ Context b;
        public final /* synthetic */ Intent c;

        @Override // oga.a
        public final void onDismissFailed() {
        }

        @Override // oga.a
        public final void onDismissSucceeded() {
            FLogger.a.i("GRIslandReceiver", "onDismissSucceeded");
            GRIslandReceiver r0 = this.a;
            Context r1 = this.b;
            Intent r2 = this.c;
            int r3 = GRIslandReceiver.a;
            r0.getClass();
            GRIslandReceiver.a(r1, r2);
        }

        public b(GRIslandReceiver r1, Context r2, Intent r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    static {
    }

    public GRIslandReceiver() {
    }

    public static void a(Context r3, Intent r4) {
        Intent r0 = new Intent(r3, ObricLiveReceiver.class);
        r0.setAction("com.obric.assistant.obric.live.pending.action");
        r0.setPackage(r3.getPackageName());
        Bundle r5 = r4.getExtras();
        if (r5 == null) goto L5;
        r0.putExtras(r5);
    L5:
        FLogger.a.d("GRIslandReceiver", "onReceive() forwardIntent: " + r0);
        r3.sendBroadcast(r0);
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context r12, Intent r13) {
        Intrinsics.checkNotNullParameter(r12, "context");
        Intrinsics.checkNotNullParameter(r13, MemorySourceLinkType.INTENT);
        FLogger r0 = FLogger.a;
        r0.i("GRIslandReceiver", "onReceive() intent: " + r13);
        String r1 = r13.getAction();
        if (r1 != null) goto L6;
        return;
    L6:
        if (Intrinsics.areEqual(r1, "com.obric.assistant.obric.gr.island.pending.action") == true) goto L12;
        if (Intrinsics.areEqual(r1, "com.obric.assistant.obric.gr.island.pending.action2") == true) goto L12;
        r0.d("GRIslandReceiver", "onReceive() action: " + r1 + ", not GR_ACTION or GR_ACTION2, ignore");
        return;
    L12:
        if (r13.getIntExtra("live_state", -1) == (-101)) goto L14;
    L19:
        a(r12, r13);
        return;
    L14:
        if (t1.a.i() == true) goto L19;
        if (IKeyguardStateKt.getKeyguardState().isDeviceLocked() == false) goto L19;
        r0.i("GRIslandReceiver", "isKeyguardLocked and isLockedScreenUseEnabled false, requestDismissKeyguard");
        IKeyguardService$a.a(KeyguardService.a, new b(this, r12, r13), false, false, false, false, null, 62);
    }
}
