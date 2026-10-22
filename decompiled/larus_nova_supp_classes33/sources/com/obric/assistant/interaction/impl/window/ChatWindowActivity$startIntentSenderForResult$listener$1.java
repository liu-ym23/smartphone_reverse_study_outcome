package com.obric.assistant.interaction.impl.window;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.Handler;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.api.service.ActivityProxyListener;
import com.obric.assistant.interaction.impl.activityresult.ActivityProxyCancelCallback;
import com.obric.assistant.interaction.impl.activityresult.ActivityProxyCancelReason;
import com.obric.assistant.interaction.impl.activityresult.ActivityProxyTerminalGate;
import com.obric.assistant.interaction.impl.activityresult.ActivityProxyTerminalOwner;
import com.obric.assistant.interaction.impl.window.event.WindowEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000E\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010J\u0010\u0010\u0011\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\"\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0018"}, d2 = {"com/obric/assistant/interaction/impl/window/ChatWindowActivity$startIntentSenderForResult$listener$1", "Lcom/obric/assistant/interaction/api/service/ActivityProxyListener;", "Lcom/obric/assistant/interaction/impl/activityresult/ActivityProxyCancelCallback;", "Lcom/obric/assistant/interaction/impl/activityresult/ActivityProxyTerminalOwner;", "proxyTerminalGate", "Lcom/obric/assistant/interaction/impl/activityresult/ActivityProxyTerminalGate;", "getProxyTerminalGate", "()Lcom/obric/assistant/interaction/impl/activityresult/ActivityProxyTerminalGate;", "onProxyCanceled", "", WindowEvent.Params.REASON, "Lcom/obric/assistant/interaction/impl/activityresult/ActivityProxyCancelReason;", "completeCancelOnce", "message", "", "activity", "Landroid/app/Activity;", "onActivityReady", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChatWindowActivity$startIntentSenderForResult$listener$1 implements ActivityProxyListener, ActivityProxyCancelCallback, ActivityProxyTerminalOwner {
    final /* synthetic */ int $extraFlags;
    final /* synthetic */ Intent $fillInIntent;
    final /* synthetic */ int $flagsMask;
    final /* synthetic */ int $flagsValues;
    final /* synthetic */ IntentSender $intent;
    final /* synthetic */ Bundle $options;
    final /* synthetic */ int $requestCode;
    private final ActivityProxyTerminalGate proxyTerminalGate;
    final /* synthetic */ ChatWindowActivity this$0;

    public static /* synthetic */ void a(ChatWindowActivity r0, int r1, int r2, Intent r3) {
        onActivityResult$lambda$1(r0, r1, r2, r3);
    }

    public static /* synthetic */ void b(ChatWindowActivity r0, int r1) {
        completeCancelOnce$lambda$0(r0, r1);
    }

    @Override // com.obric.assistant.interaction.impl.activityresult.ActivityProxyTerminalOwner
    public ActivityProxyTerminalGate getProxyTerminalGate() {
        return this.proxyTerminalGate;
    }

    @Override // com.obric.assistant.interaction.api.service.ActivityProxyListener
    public void onActivityReady(Activity r10) {
        Intrinsics.checkNotNullParameter(r10, "activity");
        ActivityCompat.startIntentSenderForResult(r10, this.$intent, this.$requestCode, this.$fillInIntent, this.$flagsMask, this.$flagsValues, this.$extraFlags, this.$options);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        FLogger.a.e(ChatWindowActivity.TAG, "startIntentSenderForResult via proxy failed", th);
        completeCancelOnce("startIntentSenderForResult via proxy failed, requestCode=" + this.$requestCode, r10);
    }

    @Override // com.obric.assistant.interaction.api.service.ActivityProxyListener
    public void onFragmentCreate(Fragment r1) {
        ActivityProxyListener.DefaultImpls.onFragmentCreate(this, r1);
    }

    @Override // com.obric.assistant.interaction.api.service.ActivityProxyListener
    public void onFragmentStart(Fragment r1) {
        ActivityProxyListener.DefaultImpls.onFragmentStart(this, r1);
    }

    @Override // com.obric.assistant.interaction.impl.activityresult.ActivityProxyCancelCallback
    public void onProxyCanceled(ActivityProxyCancelReason r3) {
        Intrinsics.checkNotNullParameter(r3, WindowEvent.Params.REASON);
        completeCancelOnce("startIntentSenderForResult proxy canceled, requestCode=" + this.$requestCode + ", reason=" + r3, null);
    }

    private static final void completeCancelOnce$lambda$0(ChatWindowActivity r2, int r3) {
        r2.onActivityResult(r3, 0, null);
    }

    public final void completeCancelOnce(String r4, Activity r5) {
        Intrinsics.checkNotNullParameter(r4, "message");
        if (getProxyTerminalGate().tryComplete() == true) goto L5;
        return;
    L5:
        FLogger.a.w(ChatWindowActivity.TAG, r4);
        Handler r6 = ChatWindowActivity.access$getMainHandler$p(this.this$0);
        final ChatWindowActivity r0 = this.this$0;
        final int r1 = this.$requestCode;
        r6.post(new i(r0, r1));
        if (r5 == null) goto L9;
        r5.finish();
        return;
    }

    @Override // com.obric.assistant.interaction.api.service.ActivityProxyListener
    public void onActivityResult(final int r4, final int r5, final Intent r6) {
        if (getProxyTerminalGate().tryComplete() == true) goto L5;
        return;
    L5:
        WindowHost.pop$default(WindowHost.INSTANCE, null, 1, null);
        Handler r0 = ChatWindowActivity.access$getMainHandler$p(this.this$0);
        final ChatWindowActivity r1 = this.this$0;
        r0.post(new h(r1, r4, r5, r6));
    }

    private static final void onActivityResult$lambda$1(ChatWindowActivity r0, int r1, int r2, Intent r3) {
        r0.onActivityResult(r1, r2, r3);
    }

    public ChatWindowActivity$startIntentSenderForResult$listener$1(int r1, ChatWindowActivity r2, IntentSender r3, Intent r4, int r5, int r6, int r7, Bundle r8) {
        this.$requestCode = r1;
        this.this$0 = r2;
        this.$intent = r3;
        this.$fillInIntent = r4;
        this.$flagsMask = r5;
        this.$flagsValues = r6;
        this.$extraFlags = r7;
        this.$options = r8;
        this.proxyTerminalGate = new ActivityProxyTerminalGate();
    }
}
