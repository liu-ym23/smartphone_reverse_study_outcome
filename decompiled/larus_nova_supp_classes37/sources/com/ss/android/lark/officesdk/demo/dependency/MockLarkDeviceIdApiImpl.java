package com.ss.android.lark.officesdk.demo.dependency;

import android.content.Context;
import com.bytedance.i18n.claymore.ClaymoreImpl;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.officesdk.api.init.IDeviceInfoProvider;
import com.ss.android.lark.officesdk.manager.OfficeSDKManager;
import com.ss.android.lark.passport.signinsdk_api.entity.DeviceId;
import com.ss.android.lark.picker.base.view.ItemViewType;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@ClaymoreImpl(epb.a.class)
@Singleton
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\u0007\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016J\"\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rH\u0016J*\u0010\u000f\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0012\u0010\u0012\u001a\u00020\t2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\u0012\u0010\u0015\u001a\u00020\u00162\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010\u0017\u001a\u00020\tH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/ss/android/lark/officesdk/demo/dependency/MockLarkDeviceIdApiImpl;", "Lcom/ss/android/lark/lark_device/api/ILarkDeviceIdApi;", "<init>", "()V", "defaultDid", "", "getInstallId", "getDeviceIdFromLocal", "getDeviceId", "", "context", "Landroid/content/Context;", "callback", "Lcom/larksuite/framework/callback/IGetDataCallback;", "Lcom/ss/android/lark/passport/signinsdk_api/entity/DeviceId;", "getDeviceIdWithTimeout", "timeoutMillis", "", "addDeviceIdChangeListener", "listener", "Lcom/ss/android/lark/lark_device/api/ILarkDeviceIdApi$IDeviceIdChangeListener;", "removeDeviceIdChangeListener", "", "setAppLogUriRuntime", "officesdk-assemble_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class MockLarkDeviceIdApiImpl implements epb.a {
    private final String defaultDid;

    public void setAppLogUriRuntime() {
    }

    @Inject
    public MockLarkDeviceIdApiImpl() {
        this.defaultDid = "0000";
    }

    public String getDeviceId() {
        IDeviceInfoProvider r0 = OfficeSDKManager.getDeviceInfoProvider();
        if (r0 == null) goto L7;
        String r1 = r0.getDeviceId();
        if (r1 == null) goto L7;
        return r1;
    L7:
        return this.defaultDid;
    }

    public String getDeviceIdFromLocal() {
        return getDeviceId();
    }

    public String getInstallId() {
        IDeviceInfoProvider r0 = OfficeSDKManager.getDeviceInfoProvider();
        if (r0 == null) goto L7;
        String r1 = r0.getInstallId();
        if (r1 == null) goto L7;
        return r1;
    L7:
        return this.defaultDid;
    }

    public void addDeviceIdChangeListener(epb.a.a r2) {
        throw new IllegalAccessException("not implementation");
    }

    public boolean removeDeviceIdChangeListener(epb.a.a r2) {
        throw new IllegalAccessException("not implementation");
    }

    public void getDeviceId(Context r2, IGetDataCallback<DeviceId> r3) {
        if (r3 == null) goto L5;
        r3.onSuccess(new DeviceId(getDeviceIdFromLocal()));
        return;
    }

    public void getDeviceIdWithTimeout(Context r1, IGetDataCallback<DeviceId> r2, long r3) {
        if (r2 == null) goto L5;
        r2.onSuccess(new DeviceId(getDeviceIdFromLocal()));
        return;
    }
}
