package com.obric.assistant.interaction.impl.keyguard;

import android.app.KeyguardManager;
import android.os.Build;
import androidx.core.content.ContextCompat;
import com.bytedance.keva.Keva;
import com.larus.common.apphost.AppHost;
import com.larus.platform.service.o2;
import com.larus.utils.logger.FLogger;
import com.larus.utils.t0;
import com.obric.assistant.audio.service.ObricLiveServiceDelegate;
import com.obric.assistant.interaction.api.IKeyguardState;
import com.obric.assistant.interaction.api.OnKeyguardLockStateChangedListener;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import lha.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 \u00142\u00020\u0001:\u0003\u0014\u0015\u0016B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0012\u001a\u00020\nH\u0016J\b\u0010\u0013\u001a\u00020\nH\u0016R\u001b\u0010\u0004\u001a\u00020\u00018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0017"}, d2 = {"Lcom/obric/assistant/interaction/impl/keyguard/KeyguardStateImpl;", "Lcom/obric/assistant/interaction/api/IKeyguardState;", "<init>", "()V", "keyGuardState", "getKeyGuardState", "()Lcom/obric/assistant/interaction/api/IKeyguardState;", "keyGuardState$delegate", "Lkotlin/Lazy;", "isKeyguardLocked", "", "getKeyguardLockTime", "", "registerKeyguardLockStateChangedListener", "", "listener", "Lcom/obric/assistant/interaction/api/OnKeyguardLockStateChangedListener;", "unregisterKeyguardLockStateChangedListener", "isDeviceLocked", "isDeviceSecure", "Companion", "NewOSKeyguardStateImpl", "OldOSKeyguardStateImpl", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class KeyguardStateImpl implements IKeyguardState {
    public static final Companion Companion = null;
    public static final String OBRIC_KEYGUARD_LOCKED_TIME = "obric_keyguard_locked_time";
    private static final String TAG = "KeyGuardStateImpl";
    private static final CopyOnWriteArrayList<OnKeyguardLockStateChangedListener> keyguardLockStateChangedListeners = null;
    private final Lazy keyGuardState$delegate;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\u0014\u001a\u00020\u0013H\u0016J\b\u0010\u0015\u001a\u00020\u000bH\u0016J\b\u0010\u0016\u001a\u00020\u000bH\u0016R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u001e\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000b@BX\u0082\u000e¢\u0006\b\n\u0000\"\u0004\b\r\u0010\u000eR\u0016\u0010\u000f\u001a\n \u0011*\u0004\u0018\u00010\u00100\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/obric/assistant/interaction/impl/keyguard/KeyguardStateImpl$NewOSKeyguardStateImpl;", "Lcom/obric/assistant/interaction/api/IKeyguardState;", "<init>", "()V", "keyGuardManager", "Landroid/app/KeyguardManager;", "getKeyGuardManager", "()Landroid/app/KeyguardManager;", "keyGuardManager$delegate", "Lkotlin/Lazy;", "value", "", "isKeyguardLocked", "setKeyguardLocked", "(Z)V", "keva", "Lcom/bytedance/keva/Keva;", "kotlin.jvm.PlatformType", "currentKeyguardLockedTime", "", "getKeyguardLockTime", "isDeviceLocked", "isDeviceSecure", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class NewOSKeyguardStateImpl implements IKeyguardState {
        private long currentKeyguardLockedTime;
        private volatile boolean isKeyguardLocked;
        private final Keva keva;
        private final Lazy keyGuardManager$delegate;

        public static /* synthetic */ void a(boolean r0) {
            _set_isKeyguardLocked_$lambda$3(r0);
        }

        public static /* synthetic */ void b(NewOSKeyguardStateImpl r0, NewOSKeyguardStateImpl r1, boolean r2) {
            lambda$5$lambda$4(r0, r1, r2);
        }

        public static /* synthetic */ KeyguardManager c() {
            return keyGuardManager_delegate$lambda$0();
        }

        private final KeyguardManager getKeyGuardManager() {
            return (KeyguardManager) this.keyGuardManager$delegate.getValue();
        }

        private static final KeyguardManager keyGuardManager_delegate$lambda$0() {
            Object r0 = AppHost.a.getApplication().getSystemService("keyguard");
            Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type android.app.KeyguardManager");
            return (KeyguardManager) r0;
        }

        public NewOSKeyguardStateImpl() {
            this.keyGuardManager$delegate = LazyKt.lazy(new d());
            boolean r0 = getKeyGuardManager().isKeyguardLocked();
            FLogger r1 = FLogger.a;
            r1.i(KeyguardStateImpl.TAG, "onKeyguardLockedStateChanged init isKeyguardLocked = " + r0);
            this.isKeyguardLocked = r0;
            Keva r2 = Keva.getRepo(o2.a.e(), 0);
            this.keva = r2;
            long r6 = r2.getLong(KeyguardStateImpl.OBRIC_KEYGUARD_LOCKED_TIME, 0);
            this.currentKeyguardLockedTime = r6;
            if (r6 == 0) goto L5;
        L7:
            r1.i(KeyguardStateImpl.TAG, "init: isKeyguardLocked = false, currentKeyguardLockedTime: " + this.currentKeyguardLockedTime);
        L16:
            Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L10
            getKeyGuardManager().addKeyguardLockedStateListener(AppHost.a.getApplication().getMainExecutor(), new e(this, this));     // Catch: Throwable -> L10
            Object r4 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L10
        L12:
            Throwable r5 = Result.exceptionOrNull-impl(r4);
            if (r5 == null) goto L18;
            FLogger.a.w(KeyguardStateImpl.TAG, "addKeyguardLockedStateListener failed: " + r5.getMessage(), r5);
            return;
        L18:
            return;
        L10:
            th = move-exception;
            Result.Companion r7 = Result.Companion;
            r4 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L12
        L5:
            if (this.isKeyguardLocked == false) goto L7;
            this.currentKeyguardLockedTime = AppHost.a.getAppClock().currentTimeMillis() / ((long) 1000);
            r1.i(KeyguardStateImpl.TAG, "init: isKeyguardLocked = true, currentKeyguardLockedTime: " + this.currentKeyguardLockedTime);
            r2.storeLong(KeyguardStateImpl.OBRIC_KEYGUARD_LOCKED_TIME, this.currentKeyguardLockedTime);
            goto L16
        }

        public boolean isDeviceLocked() {
            return f.a().isDeviceLocked();
        }

        public boolean isDeviceSecure() {
            return getKeyGuardManager().isDeviceSecure();
        }

        public long getKeyguardLockTime() {
            return this.currentKeyguardLockedTime;
        }

        public boolean isKeyguardLocked() {
            return this.isKeyguardLocked;
        }

        private static final void _set_isKeyguardLocked_$lambda$3(boolean r2) {
            Iterator r0 = KeyguardStateImpl.access$getKeyguardLockStateChangedListeners$cp().iterator();
        L4:
            if (r0.hasNext() == false) goto L6;
            ((OnKeyguardLockStateChangedListener) r0.next()).onKeyguardLockStateChanged(r2);
            goto L4
        }

        private final void setKeyguardLocked(boolean r2) {
            if (r2 == this.isKeyguardLocked) goto L6;
            this.isKeyguardLocked = r2;
            t0.e(new f(r2));
            return;
        }

        public void registerKeyguardLockStateChangedListener(OnKeyguardLockStateChangedListener r1) {
            IKeyguardState.DefaultImpls.registerKeyguardLockStateChangedListener(this, r1);
        }

        public void unregisterKeyguardLockStateChangedListener(OnKeyguardLockStateChangedListener r1) {
            IKeyguardState.DefaultImpls.unregisterKeyguardLockStateChangedListener(this, r1);
        }

        private static final void lambda$5$lambda$4(NewOSKeyguardStateImpl r7, NewOSKeyguardStateImpl r8, boolean r9) {
            FLogger r0 = FLogger.a;
            r0.i("NewOSKeyguardStateImpl", "onKeyguardLockedStateChanged: isKeyguardLocked = " + r9);
            r7.setKeyguardLocked(r9);
            if (r9 == false) goto L5;
            r8.currentKeyguardLockedTime = AppHost.a.getAppClock().currentTimeMillis() / ((long) 1000);
            r0.i(KeyguardStateImpl.TAG, "onKeyguardLockedStateChanged: isKeyguardLocked = " + r9 + ", currentKeyguardLockedTime: " + r8.currentKeyguardLockedTime);
            r8.keva.storeLong(KeyguardStateImpl.OBRIC_KEYGUARD_LOCKED_TIME, r8.currentKeyguardLockedTime);
            r8.keva.storeBoolean("obric_first_open_in_keyguard_locked", true);
            r8.keva.storeLong("obric_real_keyguard_locked_time", System.currentTimeMillis());
            return;
        L5:
            r8.keva.storeBoolean("obric_first_open_in_keyguard_locked", false);
            r8.keva.storeLong("obric_real_keyguard_locked_time", 0);
            ObricLiveServiceDelegate.b.b();
        }
    }

    public static /* synthetic */ IKeyguardState a() {
        return keyGuardState_delegate$lambda$0();
    }

    static {
        Companion = new Companion(null);
        keyguardLockStateChangedListeners = new CopyOnWriteArrayList();
    }

    private final IKeyguardState getKeyGuardState() {
        return (IKeyguardState) this.keyGuardState$delegate.getValue();
    }

    private static final IKeyguardState keyGuardState_delegate$lambda$0() {
        if (Build.VERSION.SDK_INT < 33) goto L9;
        if (ContextCompat.checkSelfPermission(AppHost.a.getApplication(), "android.permission.SUBSCRIBE_TO_KEYGUARD_LOCKED_STATE") == 0) goto L10;
        FLogger.a.w(TAG, "has no permission SUBSCRIBE_TO_KEYGUARD_LOCKED_STATE");
        return new OldOSKeyguardStateImpl();
    L10:
        return new NewOSKeyguardStateImpl();
    L9:
        return new OldOSKeyguardStateImpl();
    }

    public KeyguardStateImpl() {
        this.keyGuardState$delegate = LazyKt.lazy(new c());
    }

    public long getKeyguardLockTime() {
        return getKeyGuardState().getKeyguardLockTime();
    }

    public boolean isDeviceLocked() {
        return getKeyGuardState().isDeviceLocked();
    }

    public boolean isDeviceSecure() {
        return getKeyGuardState().isDeviceSecure();
    }

    public boolean isKeyguardLocked() {
        return getKeyGuardState().isKeyguardLocked();
    }

    public static final /* synthetic */ CopyOnWriteArrayList access$getKeyguardLockStateChangedListeners$cp() {
        return keyguardLockStateChangedListeners;
    }

    public void registerKeyguardLockStateChangedListener(OnKeyguardLockStateChangedListener r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        keyguardLockStateChangedListeners.add(r2);
    }

    public void unregisterKeyguardLockStateChangedListener(OnKeyguardLockStateChangedListener r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        keyguardLockStateChangedListeners.remove(r2);
    }
}
