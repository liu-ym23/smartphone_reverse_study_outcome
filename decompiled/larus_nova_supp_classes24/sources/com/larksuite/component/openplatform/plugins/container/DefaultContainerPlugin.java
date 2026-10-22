package com.larksuite.component.openplatform.plugins.container;

import com.larksuite.component.openplatform.plugins.config.LKOpenApiAccessConfig;
import com.larksuite.framework.apiplugin.annotation.LKPluginFunction;
import com.larksuite.framework.apiplugin.common.GetApiAccessConfig$GetDomainResponse;
import i18.b;
import j18.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public class DefaultContainerPlugin extends b {
    private jz7.b container;

    @Override // i18.d
    public void onRelease() {
        this.container = null;
    }

    public DefaultContainerPlugin(jz7.b r1) {
        this.container = r1;
    }

    @LKPluginFunction(async = true, eventName = {"getApiAccessConfig"})
    public void getDomains(f<GetApiAccessConfig$GetDomainResponse> r3) {
        GetApiAccessConfig$GetDomainResponse r0 = new GetApiAccessConfig$GetDomainResponse();
        LKOpenApiAccessConfig r1 = this.container.g;
        if (r1 != null) goto L5;
    L10:
        r3.callback(r0);
        return;
    L5:
        if (r1.getDomain() == null) goto L7;
        r0.mDomain = this.container.g.getDomain().name();
    L7:
        r0.mScene = this.container.g.getScene();
        if (this.container.g.getBizType() == null) goto L10;
        r0.mBizType = this.container.g.getBizType().name();
        goto L10
    }
}
