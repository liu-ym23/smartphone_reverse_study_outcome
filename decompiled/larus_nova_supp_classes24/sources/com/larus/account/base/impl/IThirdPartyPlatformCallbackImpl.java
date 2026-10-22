package com.larus.account.base.impl;

import android.content.Intent;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larus.account.base.api.IThirdPartyPlatformCallbackService;
import com.larus.account.base.provider.IThirdPartyPlatformCallbackProvider;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Iterator;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010\u000b\u001a\u00020\u0005H\u0016¨\u0006\f"}, d2 = {"Lcom/larus/account/base/impl/IThirdPartyPlatformCallbackImpl;", "Lcom/larus/account/base/api/IThirdPartyPlatformCallbackService;", "<init>", "()V", "onReceiveResult", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onDestroy", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class IThirdPartyPlatformCallbackImpl implements IThirdPartyPlatformCallbackService {
    public IThirdPartyPlatformCallbackImpl() {
    }

    @Override // com.larus.account.base.api.IThirdPartyPlatformCallbackService
    public final void onDestroy() {
        Iterator r0 = ServiceManager.get().getServices(IThirdPartyPlatformCallbackProvider.class).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((IThirdPartyPlatformCallbackProvider) r0.next()).onDestroy();
        goto L4
    }

    @Override // com.larus.account.base.api.IThirdPartyPlatformCallbackService
    public final void a(int r1, int r2, Intent r3) {
        Iterator r4 = ServiceManager.get().getServices(IThirdPartyPlatformCallbackProvider.class).iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        ((IThirdPartyPlatformCallbackProvider) r4.next()).a();
        goto L4
    }
}
