package com.larus.cdm.impl;

import android.companion.AssociationInfo;
import android.companion.CompanionDeviceService;
import android.net.MacAddress;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0017J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0017¨\u0006\u000b"}, d2 = {"Lcom/larus/cdm/impl/FlowCDMService;", "Landroid/companion/CompanionDeviceService;", "<init>", "()V", "onDeviceAppeared", "", "address", "", "onDeviceDisappeared", "associationInfo", "Landroid/companion/AssociationInfo;", "impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FlowCDMService extends CompanionDeviceService {
    public FlowCDMService() {
    }

    @Override // android.companion.CompanionDeviceService
    public final void onDeviceAppeared(AssociationInfo r4) {
        Intrinsics.checkNotNullParameter(r4, "associationInfo");
        FLogger.a.i("flow_cdm", "[FlowCDMService] onDeviceAppeared " + r4);
        MacAddress r5 = r4.getDeviceMacAddress();
        if (r5 == null) goto L6;
        String r6 = r5.toString();
        if (r6 == null) goto L6;
    L7:
        FlowCompanionDeviceManagerDelegate.a.getClass();
        FlowCompanionDeviceManagerDelegate.q(r6, true);
        return;
    L6:
        r6 = "";
        goto L7
    }

    @Override // android.companion.CompanionDeviceService
    public final void onDeviceDisappeared(AssociationInfo r4) {
        Intrinsics.checkNotNullParameter(r4, "associationInfo");
        FLogger.a.i("flow_cdm", "[FlowCDMService] onDeviceDisappeared " + r4);
        MacAddress r5 = r4.getDeviceMacAddress();
        if (r5 == null) goto L6;
        String r6 = r5.toString();
        if (r6 == null) goto L6;
    L7:
        FlowCompanionDeviceManagerDelegate.a.getClass();
        FlowCompanionDeviceManagerDelegate.q(r6, false);
        return;
    L6:
        r6 = "";
        goto L7
    }

    @Override // android.companion.CompanionDeviceService
    public final void onDeviceAppeared(String r4) {
        Intrinsics.checkNotNullParameter(r4, "address");
        FLogger.a.i("flow_cdm", "[FlowCDMService] onDeviceAppeared " + r4);
        FlowCompanionDeviceManagerDelegate.a.getClass();
        FlowCompanionDeviceManagerDelegate.q(r4, true);
    }

    @Override // android.companion.CompanionDeviceService
    public final void onDeviceDisappeared(String r4) {
        Intrinsics.checkNotNullParameter(r4, "address");
        FLogger.a.i("flow_cdm", "[FlowCDMService] onDeviceDisappeared " + r4);
        FlowCompanionDeviceManagerDelegate.a.getClass();
        FlowCompanionDeviceManagerDelegate.q(r4, false);
    }
}
