package com.bytedance.android.live.saas.middleware.baselib.di;

import com.bytedance.android.live.saas.middleware.base.BaseFunction;
import com.bytedance.android.live.saas.middleware.baselib.BaseLibConfig;
import com.bytedance.android.live.saas.middleware.di.FuncEnumKey;
import com.bytedance.android.live.saas.middleware.di.FuncType;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoMap;
import javax.inject.Named;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00050\u0004H\u0007¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/saas/middleware/baselib/di/BaseLibModule;", "", "()V", "provideFunction", "Lcom/bytedance/android/live/saas/middleware/base/BaseFunction;", "Lcom/bytedance/android/live/saas/middleware/baselib/BaseLibConfig;", "middleware_release"}, k = 1, mv = {1, 4, 3})
@Module
public final class BaseLibModule {
    public BaseLibModule() {
    }

    @Provides
    @Named("baselib")
    @FuncEnumKey(FuncType.TYPE_INHOUSE)
    @IntoMap
    public final BaseFunction<Object, BaseLibConfig> provideFunction() {
        return new AnonymousClass1();
    }
}
