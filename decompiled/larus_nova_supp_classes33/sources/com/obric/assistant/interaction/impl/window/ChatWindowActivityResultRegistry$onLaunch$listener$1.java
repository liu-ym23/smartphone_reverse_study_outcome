package com.obric.assistant.interaction.impl.window;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import androidx.activity.result.IntentSenderRequest;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.api.service.ActivityProxyListener;
import com.obric.assistant.interaction.api.window.animation.WindowAnimationType;
import com.obric.assistant.interaction.impl.activityresult.ActivityProxyCancelCallback;
import com.obric.assistant.interaction.impl.activityresult.ActivityProxyCancelReason;
import com.obric.assistant.interaction.impl.activityresult.ActivityProxyTerminalGate;
import com.obric.assistant.interaction.impl.activityresult.ActivityProxyTerminalOwner;
import com.obric.assistant.interaction.impl.window.event.WindowEvent;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000K\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J,\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u0014J\u0010\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\"\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00182\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u001a"}, d2 = {"com/obric/assistant/interaction/impl/window/ChatWindowActivityResultRegistry$onLaunch$listener$1", "Lcom/obric/assistant/interaction/api/service/ActivityProxyListener;", "Lcom/obric/assistant/interaction/impl/activityresult/ActivityProxyCancelCallback;", "Lcom/obric/assistant/interaction/impl/activityresult/ActivityProxyTerminalOwner;", "proxyTerminalGate", "Lcom/obric/assistant/interaction/impl/activityresult/ActivityProxyTerminalGate;", "getProxyTerminalGate", "()Lcom/obric/assistant/interaction/impl/activityresult/ActivityProxyTerminalGate;", "onProxyCanceled", "", WindowEvent.Params.REASON, "Lcom/obric/assistant/interaction/impl/activityresult/ActivityProxyCancelReason;", "completeCancelOnce", "message", "", "data", "Landroid/content/Intent;", "activity", "Landroid/app/Activity;", "restoreWindow", "", "onActivityReady", "onActivityResult", "requestCode", "", "resultCode", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChatWindowActivityResultRegistry$onLaunch$listener$1 implements ActivityProxyListener, ActivityProxyCancelCallback, ActivityProxyTerminalOwner {
    final /* synthetic */ WeakReference<Dialog> $dialogRetention;
    final /* synthetic */ Intent $intent;
    final /* synthetic */ Ref.ObjectRef<Bundle> $optionsBundle;
    final /* synthetic */ int $requestCode;
    private final ActivityProxyTerminalGate proxyTerminalGate;
    final /* synthetic */ ChatWindowActivityResultRegistry this$0;

    @Override // com.obric.assistant.interaction.impl.activityresult.ActivityProxyTerminalOwner
    public ActivityProxyTerminalGate getProxyTerminalGate() {
        return this.proxyTerminalGate;
    }

    @Override // com.obric.assistant.interaction.api.service.ActivityProxyListener
    public void onActivityReady(Activity r18) {
        Intrinsics.checkNotNullParameter(r18, "activity");
        String r0 = this.$intent.getAction();
        if (r0 == null) goto L35;
        int r2 = r0.hashCode();
        if (r2 == (-1837081951)) goto L21;
        if (r2 != (-591152331)) goto L35;
        if (r0.equals("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST") == false) goto L35;
        IntentSenderRequest r1 = this.$intent.getParcelableExtra("androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST");
        if (r1 != null) goto L37;
        completeCancelOnce$default(this, "IntentSenderRequest missing for requestCode=" + this.$requestCode, null, r18, false, 8, null);
        return;
    L37:
        ActivityCompat.startIntentSenderForResult(r18, r1.getIntentSender(), this.$requestCode, r1.getFillInIntent(), r1.getFlagsMask(), r1.getFlagsValues(), 0, (Bundle) this.$optionsBundle.element);     // Catch: IntentSender.SendIntentException -> L18
        return;
    L18:
        e = move-exception;
        completeCancelOnce$default(this, "startIntentSenderForResult via proxy failed, requestCode=" + this.$requestCode, new Intent().setAction("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST").putExtra("androidx.activity.result.contract.extra.SEND_INTENT_EXCEPTION", e), r18, false, 8, null);
        return;
    L21:
        if (r0.equals("androidx.activity.result.contract.action.REQUEST_PERMISSIONS") == false) goto L35;
        String[] r3 = this.$intent.getStringArrayExtra("androidx.activity.result.contract.extra.PERMISSIONS");
        if (r3 != null) goto L39;
        r3 = new String[0];
    L39:
        ActivityCompat.requestPermissions(r18, r3, this.$requestCode);     // Catch: Throwable -> L28
        return;
    L28:
        th = move-exception;
        FLogger.a.e("ChatWindowActivityResultRegistry", "requestPermissions via proxy failed, requestCode=" + this.$requestCode, th);
        completeCancelOnce$default(this, "requestPermissions via proxy failed, requestCode=" + this.$requestCode, null, r18, false, 8, null);
        return;
    L35:
        ActivityCompat.startActivityForResult(r18, this.$intent, this.$requestCode, (Bundle) this.$optionsBundle.element);     // Catch: Throwable -> L32
        return;
    L32:
        th = move-exception;
        FLogger.a.e("ChatWindowActivityResultRegistry", "startActivityForResult via proxy failed, requestCode=" + this.$requestCode, th);
        completeCancelOnce$default(this, "startActivityForResult via proxy failed, requestCode=" + this.$requestCode, null, r18, false, 8, null);
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
        String r0 = "proxy canceled, requestCode=" + this.$requestCode + ", reason=" + r3;
        if (r3 == ActivityProxyCancelReason.PROXY_DESTROYED_BEFORE_RESULT) goto L5;
        boolean r4 = true;
    L6:
        completeCancelOnce(r0, null, null, r4);
        return;
    L5:
        r4 = false;
        goto L6
    }

    @Override // com.obric.assistant.interaction.api.service.ActivityProxyListener
    public void onActivityResult(int r3, int r4, Intent r5) {
        if (getProxyTerminalGate().tryComplete() == true) goto L5;
        return;
    L5:
        WindowHost.INSTANCE.pop(WindowAnimationType.Slide);
        ChatWindowActivityResultRegistry.access$onLaunch$dispatchResultAndRelease(this.this$0, this.$dialogRetention, this.$requestCode, r4, r5);
    }

    public final void completeCancelOnce(String r3, Intent r4, Activity r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r3, "message");
        if (getProxyTerminalGate().tryComplete() == true) goto L5;
        return;
    L5:
        FLogger.a.w("ChatWindowActivityResultRegistry", r3);
        if (r6 == true) goto L8;
    L12:
        ChatWindowActivityResultRegistry.access$onLaunch$dispatchResultAndRelease(this.this$0, this.$dialogRetention, this.$requestCode, 0, r4);
        if (r5 == null) goto L16;
        r5.finish();
        return;
    L16:
        return;
    L8:
        if (this.$dialogRetention == null) goto L12;
        WindowHost r7 = WindowHost.INSTANCE;
        if (r7.isStashed() == false) goto L12;
        r7.pop(WindowAnimationType.Slide);
        goto L12
    }

    public ChatWindowActivityResultRegistry$onLaunch$listener$1(int r1, WeakReference<Dialog> r2, ChatWindowActivityResultRegistry r3, Intent r4, Ref.ObjectRef<Bundle> r5) {
        this.$requestCode = r1;
        this.$dialogRetention = r2;
        this.this$0 = r3;
        this.$intent = r4;
        this.$optionsBundle = r5;
        this.proxyTerminalGate = new ActivityProxyTerminalGate();
    }

    public static /* synthetic */ void completeCancelOnce$default(ChatWindowActivityResultRegistry$onLaunch$listener$1 r0, String r1, Intent r2, Activity r3, boolean r4, int r5, Object r6) {
        if ((r5 & 8) == 0) goto L5;
        r4 = true;
    L5:
        r0.completeCancelOnce(r1, r2, r3, r4);
    }
}
