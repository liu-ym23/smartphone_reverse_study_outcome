package com.ttnet.org.chromium.net.impl;

import android.content.Context;
import com.ttnet.org.chromium.net.CronetEngine;
import com.ttnet.org.chromium.net.CronetProvider;
import com.ttnet.org.chromium.net.ExperimentalCronetEngine;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;

/* JADX INFO: loaded from: classes6.dex */
public class NativeCronetProvider extends CronetProvider {
    public NativeCronetProvider(Context r3) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.ttnet.org.chromium.net.CronetProvider
    public CronetEngine.Builder createBuilder(boolean r2) {
        return new ExperimentalCronetEngine.Builder(new NativeCronetEngineBuilderWithLibraryLoaderImpl(this.mContext, r2));
    }

    public boolean equals(Object r3) {
        if (r3 != this) goto L5;
    L10:
        return true;
    L5:
        if (ZeusTransformUtils.instanceOf(r3, NativeCronetProvider.class) == true) goto L7;
    L9:
        return false;
    L7:
        if (this.mContext.equals(((NativeCronetProvider) ZeusTransformUtils.preCheckCast(r3, NativeCronetProvider.class, "com.obric.memorydata.plugin")).mContext) == false) goto L9;
        goto L9
    }

    @Override // com.ttnet.org.chromium.net.CronetProvider
    public String getName() {
        return CronetProvider.PROVIDER_NAME_APP_PACKAGED;
    }

    @Override // com.ttnet.org.chromium.net.CronetProvider
    public String getVersion() {
        return ImplVersion.getCronetVersion();
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{NativeCronetProvider.class, this.mContext});
    }

    @Override // com.ttnet.org.chromium.net.CronetProvider
    public boolean isEnabled() {
        return true;
    }
}
