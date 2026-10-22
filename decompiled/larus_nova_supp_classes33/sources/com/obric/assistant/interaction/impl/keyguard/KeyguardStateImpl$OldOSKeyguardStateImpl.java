package com.obric.assistant.interaction.impl.keyguard;

import android.app.KeyguardManager;
import android.os.Build;
import com.larus.common.apphost.AppHost;
import com.obric.assistant.interaction.api.IKeyguardState;
import com.obric.assistant.interaction.api.IKeyguardState$DefaultImpls;
import com.obric.assistant.interaction.api.OnKeyguardLockStateChangedListener;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\u000bH\u0016J\b\u0010\u000f\u001a\u00020\u000bH\u0016R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/obric/assistant/interaction/impl/keyguard/KeyguardStateImpl$OldOSKeyguardStateImpl;", "Lcom/obric/assistant/interaction/api/IKeyguardState;", "<init>", "()V", "keyGuardManager", "Landroid/app/KeyguardManager;", "getKeyGuardManager", "()Landroid/app/KeyguardManager;", "keyGuardManager$delegate", "Lkotlin/Lazy;", "isKeyguardLocked", "", "getKeyguardLockTime", "", "isDeviceLocked", "isDeviceSecure", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class KeyguardStateImpl$OldOSKeyguardStateImpl implements IKeyguardState {
    private final Lazy keyGuardManager$delegate;

    public static /* synthetic */ KeyguardManager a() {
        return keyGuardManager_delegate$lambda$0();
    }

    public long getKeyguardLockTime() {
        return 0;
    }

    private final KeyguardManager getKeyGuardManager() {
        return (KeyguardManager) this.keyGuardManager$delegate.getValue();
    }

    private static final KeyguardManager keyGuardManager_delegate$lambda$0() {
        Object r0 = AppHost.a.getApplication().getSystemService("keyguard");
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type android.app.KeyguardManager");
        return (KeyguardManager) r0;
    }

    public boolean isDeviceLocked() {
        if (Build.VERSION.SDK_INT < 22) goto L6;
        return getKeyGuardManager().isDeviceLocked();
    L6:
        return getKeyGuardManager().isKeyguardLocked();
    }

    public boolean isDeviceSecure() {
        if (Build.VERSION.SDK_INT < 23) goto L6;
        return getKeyGuardManager().isDeviceSecure();
    L6:
        return getKeyGuardManager().isKeyguardSecure();
    }

    public KeyguardStateImpl$OldOSKeyguardStateImpl() {
        this.keyGuardManager$delegate = LazyKt.lazy(new g());
    }

    public boolean isKeyguardLocked() {
        return getKeyGuardManager().isKeyguardLocked();
    }

    public void registerKeyguardLockStateChangedListener(OnKeyguardLockStateChangedListener r1) {
        IKeyguardState$DefaultImpls.registerKeyguardLockStateChangedListener(this, r1);
    }

    public void unregisterKeyguardLockStateChangedListener(OnKeyguardLockStateChangedListener r1) {
        IKeyguardState$DefaultImpls.unregisterKeyguardLockStateChangedListener(this, r1);
    }
}
