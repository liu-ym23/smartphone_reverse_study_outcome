package com.obric.aikernel.middleware.impl.store.keva;

import android.content.Context;
import androidx.core.app.NotificationCompat;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.bytedance.keva.KevaBuilder;
import com.bytedance.keva.KevaConstants;
import com.bytedance.keva.KevaMonitor;
import com.obric.aikernel.middleware.api.appcontext.AppContext;
import com.obric.aikernel.middleware.api.log.AIKLog;
import com.obric.aikernel.middleware.api.store.IStoreManager;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class StoreManagerImpl implements IStoreManager {
    public static final StoreManagerImpl INSTANCE = null;
    private static final AtomicBoolean isInit = null;

    public static final class a extends KevaMonitor {
        a() {
        }

        @Override // com.bytedance.keva.KevaMonitor
        protected void logDebug(String r10) {
            Intrinsics.checkNotNullParameter(r10, NotificationCompat.CATEGORY_MESSAGE);
            AIKLog.INSTANCE.d(KevaConstants.TAG, r10);
        }
    }

    static {
        INSTANCE = new StoreManagerImpl();
        isInit = new AtomicBoolean(false);
    }

    private StoreManagerImpl() {
    }

    @JvmStatic
    public static final StoreManagerImpl getInst() {
        return INSTANCE;
    }

    private final int getMode(int r10) {
        if (r10 == 1) goto L7;
        return 0;
    L7:
        return 1;
    }

    @Override // com.obric.aikernel.middleware.api.store.IStoreManager
    public t7.a getStore(String r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, ActivityLifecycle.NAME);
        if (hasInit() == true) goto L6;
        init(AppContext.INSTANCE.getContext());
    L6:
        return new w7.a(r10, getMode(r11));
    }

    @Override // com.obric.aikernel.middleware.api.store.IStoreManager
    public boolean hasInit() {
        return isInit.get();
    }

    @Override // com.obric.aikernel.middleware.api.store.IStoreManager
    public synchronized void init(Context r10) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r10, "context");     // Catch: Throwable -> L13
        AtomicBoolean r11 = isInit;     // Catch: Throwable -> L13
        if (r11.get() == false) goto L7;
        monitor-exit(this);
        return;
    L7:
        KevaBuilder.getInstance().setContext(r10);     // Catch: Throwable -> L13
        if (AppContext.INSTANCE.isDebug() == false) goto L10;
        KevaBuilder.getInstance().setMonitor(new a());     // Catch: Throwable -> L13
    L10:
        r11.set(true);     // Catch: Throwable -> L13
        monitor-exit(this);
        return;
    L13:
        th = move-exception;
        throw th;
    }
}
