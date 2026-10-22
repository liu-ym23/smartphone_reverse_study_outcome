package com.obric.assistant.spi.keyguard;

import android.content.ComponentName;
import android.os.Bundle;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.i1;
import kotlinx.coroutines.flow.j1;
import oga.a;
import oga.b;
import oga.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\u000e\u001a\u00020\nH\u0016J:\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00132\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\n\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\n\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u0013H\u0016J\u000e\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00130\u001fH\u0016J\b\u0010 \u001a\u00020\u0013H\u0016R\u001d\u0010\u0004\u001a\u0004\u0018\u00010\u00018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006!"}, d2 = {"Lcom/obric/assistant/spi/keyguard/KeyguardService;", "Lcom/obric/assistant/spi/keyguard/IKeyguardService;", "<init>", "()V", "impl", "getImpl", "()Lcom/obric/assistant/spi/keyguard/IKeyguardService;", "impl$delegate", "Lkotlin/Lazy;", "registerDismissKeyguardChangedListener", "", "listener", "Lcom/obric/assistant/spi/keyguard/IDismissKeyguardStatusListener;", "unregisterDismissKeyguardChangedListener", "cancelDismissKeyguard", "requestDismissKeyguard", "callback", "Lcom/obric/assistant/spi/keyguard/DismissKeyguardCallback;", "fastFailWhenAppBackground", "", "playTts", "allowBiometricUnlock", "autoPopupWindow", "reportParams", "Landroid/os/Bundle;", "getHelperActivityName", "", "getHelperActivityComponentName", "Landroid/content/ComponentName;", "isKeyguardLocked", "isDismissingKeyguard", "Lkotlinx/coroutines/flow/StateFlow;", "isRequestingDismissKeyguard", "obric_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class KeyguardService implements IKeyguardService {
    public static final KeyguardService a = null;
    public static final Lazy b = null;

    private KeyguardService() {
    }

    static {
        a = new KeyguardService();
        b = LazyKt.lazy(new g());
    }

    public static IKeyguardService a() {
        return (IKeyguardService) b.getValue();
    }

    public final void cancelDismissKeyguard() {
        IKeyguardService r0 = a();
        if (r0 == null) goto L6;
        r0.cancelDismissKeyguard();
        return;
    }

    public final ComponentName getHelperActivityComponentName() {
        IKeyguardService r0 = a();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getHelperActivityComponentName();
    }

    public final String getHelperActivityName() {
        IKeyguardService r0 = a();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getHelperActivityName();
    }

    public final i1<Boolean> isDismissingKeyguard() {
        IKeyguardService r0 = a();
        if (r0 == null) goto L7;
        i1<Boolean> r1 = r0.isDismissingKeyguard();
        if (r1 == null) goto L7;
        return r1;
    L7:
        return j1.a(Boolean.FALSE);
    }

    public final boolean isKeyguardLocked() {
        IKeyguardService r0 = a();
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.isKeyguardLocked();
    }

    public final boolean isRequestingDismissKeyguard() {
        IKeyguardService r0 = a();
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.isRequestingDismissKeyguard();
    }

    public final void registerDismissKeyguardChangedListener(b r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        IKeyguardService r0 = a();
        if (r0 == null) goto L6;
        r0.registerDismissKeyguardChangedListener(r2);
        return;
    }

    public final void unregisterDismissKeyguardChangedListener(b r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        IKeyguardService r0 = a();
        if (r0 == null) goto L6;
        r0.unregisterDismissKeyguardChangedListener(r2);
        return;
    }

    public final void requestDismissKeyguard(a r9, boolean r10, boolean r11, boolean r12, boolean r13, Bundle r14) {
        Intrinsics.checkNotNullParameter(r9, "callback");
        IKeyguardService r1 = a();
        if (r1 == null) goto L5;
        r1.requestDismissKeyguard(r9, r10, r11, r12, r13, r14);
        return;
    L5:
        r9.onDismissSucceeded();
    }
}
