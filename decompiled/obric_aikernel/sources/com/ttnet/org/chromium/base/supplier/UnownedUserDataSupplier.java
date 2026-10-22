package com.ttnet.org.chromium.base.supplier;

import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import com.ttnet.org.chromium.base.UnownedUserData;
import com.ttnet.org.chromium.base.UnownedUserDataHost;
import com.ttnet.org.chromium.base.UnownedUserDataKey;
import com.ttnet.org.chromium.base.lifetime.DestroyChecker;
import com.ttnet.org.chromium.base.lifetime.Destroyable;

/* JADX INFO: loaded from: classes2.dex */
public abstract class UnownedUserDataSupplier<E> extends ObservableSupplierImpl<E> implements Destroyable, UnownedUserData {
    private final DestroyChecker mDestroyChecker;
    private final UnownedUserDataKey<UnownedUserDataSupplier<E>> mUudKey;

    /* JADX WARN: Multi-variable type inference failed */
    protected UnownedUserDataSupplier(@NonNull UnownedUserDataKey<? extends UnownedUserDataSupplier<E>> r10) {
        this.mDestroyChecker = new DestroyChecker();
        this.mUudKey = r10;
    }

    public void attach(@NonNull UnownedUserDataHost r10) {
        this.mDestroyChecker.checkNotDestroyed();
        this.mUudKey.attachToHost(r10, this);
    }

    @Override // com.ttnet.org.chromium.base.lifetime.Destroyable
    @CallSuper
    public void destroy() {
        this.mDestroyChecker.destroy();
        this.mUudKey.detachFromAllHosts(this);
    }
}
