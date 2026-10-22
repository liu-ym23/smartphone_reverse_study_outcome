package com.larus.bitable.sdk.impl.proxy;

import com.larus.bitable.sdk.api.IBitableSdkService;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.office.base.service.ISdkLifecycleV2;
import com.ss.android.lark.officesdk.api.api.OfficeSDKUserApi;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\n\u001a\u00020\u0005H\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016¨\u0006\u000f"}, d2 = {"Lcom/larus/bitable/sdk/impl/proxy/BitableLifecycleAdapter;", "Lcom/larus/office/base/service/ISdkLifecycleV2;", "<init>", "()V", "preInitDocSdk", "", "officeSDKUserApi", "Lcom/ss/android/lark/officesdk/api/api/OfficeSDKUserApi;", "initDocSdk", "postInitDocSdk", "destroyDocSdk", "lifecycleOrder", "", "lifecycleCategory", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class BitableLifecycleAdapter implements ISdkLifecycleV2 {
    public BitableLifecycleAdapter() {
    }

    public final String lifecycleCategory() {
        return "bitable";
    }

    public final int lifecycleOrder() {
        return 2;
    }

    public final void destroyDocSdk() {
        IBitableSdkService r0 = (IBitableSdkService) ServiceManager.get().getService(IBitableSdkService.class);
        if (r0 == null) goto L6;
        r0.destroyDocSdk();
        return;
    }

    public final void initDocSdk(OfficeSDKUserApi r3) {
        Intrinsics.checkNotNullParameter(r3, "officeSDKUserApi");
        IBitableSdkService r0 = (IBitableSdkService) ServiceManager.get().getService(IBitableSdkService.class);
        if (r0 == null) goto L6;
        r0.initDocSdk(r3);
        return;
    }

    public final void postInitDocSdk(OfficeSDKUserApi r3) {
        Intrinsics.checkNotNullParameter(r3, "officeSDKUserApi");
        IBitableSdkService r0 = (IBitableSdkService) ServiceManager.get().getService(IBitableSdkService.class);
        if (r0 == null) goto L6;
        r0.postInitDocSdk(r3);
        return;
    }

    public final void preInitDocSdk(OfficeSDKUserApi r3) {
        Intrinsics.checkNotNullParameter(r3, "officeSDKUserApi");
        IBitableSdkService r0 = (IBitableSdkService) ServiceManager.get().getService(IBitableSdkService.class);
        if (r0 == null) goto L6;
        r0.preInitDocSdk(r3);
        return;
    }
}
