package com.bytedance.android.live.saas.middleware.di;

import com.bytedance.android.live.saas.middleware.BDLiveSdkInternal;
import com.bytedance.android.live.saas.middleware.IBDLiveSdkInit;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoSet;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/saas/middleware/di/BDLiveSdkModule;", "", "()V", "provideFunction", "Lcom/bytedance/android/live/saas/middleware/IBDLiveSdkInit;", "middleware_release"}, k = 1, mv = {1, 4, 3})
@Module
public final class BDLiveSdkModule {
    public BDLiveSdkModule() {
    }

    @Provides
    @IntoSet
    public final IBDLiveSdkInit provideFunction() {
        return BDLiveSdkInternal.INSTANCE;
    }
}
