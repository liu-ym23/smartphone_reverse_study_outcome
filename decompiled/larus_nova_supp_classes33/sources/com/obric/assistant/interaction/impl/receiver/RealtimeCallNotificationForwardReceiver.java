package com.obric.assistant.interaction.impl.receiver;

import android.app.Activity;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.larus.voicecall.obric.ObricRealtimeCallServiceDelegate;
import com.obric.assistant.interaction.api.IKeyguardStateKt;
import com.obric.assistant.spi.audio.IObricRealtimeCallExtService;
import com.obric.assistant.spi.keyguard.IKeyguardService$a;
import com.obric.assistant.spi.keyguard.KeyguardService;
import com.obric.assistant.t1;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010\n\u001a\u00020\u0005H\u0002J\b\u0010\u000b\u001a\u00020\fH\u0002¨\u0006\u000e"}, d2 = {"Lcom/obric/assistant/interaction/impl/receiver/RealtimeCallNotificationForwardReceiver;", "Landroid/content/BroadcastReceiver;", "<init>", "()V", "onReceive", "", "context", "Landroid/content/Context;", MemorySourceLinkType.INTENT, "Landroid/content/Intent;", "handleNotificationClick", "hasAliveRealtimeCallActivity", "", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RealtimeCallNotificationForwardReceiver extends BroadcastReceiver {
    public static final Companion Companion = null;
    private static final String TAG = "RealtimeCallNotificationForwardReceiver";

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/assistant/interaction/impl/receiver/RealtimeCallNotificationForwardReceiver$Companion;", "", "<init>", "()V", "TAG", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    private final boolean hasAliveRealtimeCallActivity() {
        List r0 = AppHost.a.a().g();
        ListIterator r1 = r0.listIterator(r0.size());
    L4:
        if (r1.hasPrevious() == false) goto L15;
        Object r2 = r1.previous();
        Activity r4 = (Activity) r2;
        if (ObricRealtimeCallServiceDelegate.b.s(r4) == true) goto L8;
    L12:
        boolean r5 = false;
    L13:
        if (r5 == false) goto L4;
    L16:
        if (r2 != null) goto L25;
        return false;
    L25:
        return true;
    L8:
        if (r4.isFinishing() == true) goto L12;
        if (r4.isDestroyed() == true) goto L12;
        r5 = true;
        goto L13
    L15:
        r2 = null;
        goto L16
    }

    private final void handleNotificationClick() {
        if (hasAliveRealtimeCallActivity() == false) goto L8;
        FLogger.a.i(TAG, "handleNotificationClick: hasAliveRealtimeCallActivity, open it");
        IObricRealtimeCallExtService r0 = (IObricRealtimeCallExtService) ServiceManager.get().getService(IObricRealtimeCallExtService.class);
        if (r0 == null) goto L7;
        r0.setShowWhenLockedForExistingRealtimeCallActivity();
    L7:
        AppHost.Companion r1 = AppHost.a;
        Application r2 = r1.getApplication();
        Intent r3 = new Intent();
        r3.setComponent(new ComponentName(r1.getApplication(), ObricRealtimeCallServiceDelegate.b.u()));
        r3.setFlags(872415232);
        r2.startActivity(r3);
        return;
    L8:
        FLogger.a.i(TAG, "handleNotificationClick: no alive realtime call activity, resumeOrLaunchNewTask");
        IKeyguardService$a.a(KeyguardService.a, new AnonymousClass2(), false, false, false, false, null, 62);
    }

    public RealtimeCallNotificationForwardReceiver() {
    }

    public static final /* synthetic */ void access$handleNotificationClick(RealtimeCallNotificationForwardReceiver r0) {
        r0.handleNotificationClick();
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context r10, Intent r11) {
        if (IKeyguardStateKt.getKeyguardState().isKeyguardLocked() == true) goto L5;
    L8:
        handleNotificationClick();
        return;
    L5:
        if (t1.a.i() == true) goto L8;
        FLogger.a.i(TAG, "onReceive: need dismiss keyguard");
        IKeyguardService$a.a(KeyguardService.a, new AnonymousClass1(this), false, false, false, false, null, 62);
    }
}
