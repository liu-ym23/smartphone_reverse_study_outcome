package com.ss.android.lark.officesdk.container;

import com.ss.android.lark.officesdk.api.init.IDeviceInfoProvider;
import com.ss.android.lark.officesdk.api.init.IOfficeSDKHostAppHeaderProvider;
import com.ss.android.lark.officesdk.api.init.IOfficeSDKLifeCycle;
import com.ss.android.lark.officesdk.api.init.IOfficeSDKTokenProvider;
import com.ss.android.lark.officesdk.api.service.capacity.IHostLifecycle;
import com.ss.android.lark.officesdk.api.service.capacity.IOfficeAppBaseInfo;
import com.ss.android.lark.officesdk.api.service.capacity.NullAppBaseInfoImpl;
import com.ss.android.lark.officesdk.manager.OfficeSDKManager;
import com.ss.android.lark.picker.base.view.ItemViewType;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0007J\b\u0010\u0006\u001a\u00020\u0007H\u0007J\b\u0010\b\u001a\u00020\tH\u0007J\b\u0010\n\u001a\u00020\u000bH\u0007J\b\u0010\f\u001a\u00020\rH\u0007J\b\u0010\u000e\u001a\u00020\u000fH\u0007¨\u0006\u0010"}, d2 = {"Lcom/ss/android/lark/officesdk/container/OfficeSDKConfigProviderModule;", "", "<init>", "()V", "provideLifeCycle", "Lcom/ss/android/lark/officesdk/api/init/IOfficeSDKLifeCycle;", "provideTokenProvider", "Lcom/ss/android/lark/officesdk/api/init/IOfficeSDKTokenProvider;", "provideDeviceInfoProvider", "Lcom/ss/android/lark/officesdk/api/init/IDeviceInfoProvider;", "provideHostLifecycle", "Lcom/ss/android/lark/officesdk/api/service/capacity/IHostLifecycle;", "provideAppBaseInfo", "Lcom/ss/android/lark/officesdk/api/service/capacity/IOfficeAppBaseInfo;", "provideHostAppHeaderProvider", "Lcom/ss/android/lark/officesdk/api/init/IOfficeSDKHostAppHeaderProvider;", "officesdk-core_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@Module
public final class OfficeSDKConfigProviderModule {
    public static final OfficeSDKConfigProviderModule INSTANCE = null;

    static {
        INSTANCE = new OfficeSDKConfigProviderModule();
    }

    private OfficeSDKConfigProviderModule() {
    }

    @Provides
    @Singleton
    public final IOfficeAppBaseInfo provideAppBaseInfo() {
        IOfficeAppBaseInfo r0 = (IOfficeAppBaseInfo) OfficeSDKManager.getHostGlobalService(IOfficeAppBaseInfo.class);
        if (r0 == null) goto L5;
        return r0;
    L5:
        return new NullAppBaseInfoImpl();
    }

    @Provides
    @Singleton
    public final IDeviceInfoProvider provideDeviceInfoProvider() {
        IDeviceInfoProvider r0 = OfficeSDKManager.getDeviceInfoProvider();
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new IllegalStateException("OfficeSDK not initialized: IDeviceInfoProvider is null");
    }

    @Provides
    @Singleton
    public final IOfficeSDKHostAppHeaderProvider provideHostAppHeaderProvider() {
        if (OfficeSDKManager.isInitialized() == false) goto L9;
        IOfficeSDKHostAppHeaderProvider r0 = OfficeSDKManager.getHostAppHeaderProvider();
        if (r0 == null) goto L7;
        return r0;
    L7:
        return new AnonymousClass1();
    L9:
        throw new IllegalStateException("OfficeSDK not initialized: IOfficeSDKHostAppHeaderProvider is unavailable");
    }

    @Provides
    @Singleton
    public final IHostLifecycle provideHostLifecycle() {
        return OfficeSDKManager.getHostLifecycle();
    }

    @Provides
    @Singleton
    public final IOfficeSDKLifeCycle provideLifeCycle() {
        IOfficeSDKLifeCycle r0 = OfficeSDKManager.getLifeCycle();
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new IllegalStateException("OfficeSDK not initialized: IOfficeSDKLifeCycle is null");
    }

    @Provides
    @Singleton
    public final IOfficeSDKTokenProvider provideTokenProvider() {
        IOfficeSDKTokenProvider r0 = OfficeSDKManager.getTokenProvider();
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new IllegalStateException("OfficeSDK not initialized: IOfficeSDKTokenProvider is null");
    }
}
