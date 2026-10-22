package com.ttnet.org.chromium.net.impl;

import android.content.Context;
import com.ttnet.org.chromium.net.CronetEngine;
import com.ttnet.org.chromium.net.CronetProvider;
import com.ttnet.org.chromium.net.ExperimentalCronetEngine;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;

/* JADX INFO: loaded from: classes6.dex */
public class JavaCronetProvider extends CronetProvider {
    public JavaCronetProvider(Context r3) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.ttnet.org.chromium.net.CronetProvider
    public CronetEngine.Builder createBuilder(boolean r2) {
        return new ExperimentalCronetEngine.Builder(new JavaCronetEngineBuilderImpl(this.mContext, r2));
    }

    public boolean equals(Object r3) {
        if (r3 != this) goto L5;
    L10:
        return true;
    L5:
        if (ZeusTransformUtils.instanceOf(r3, JavaCronetProvider.class) == true) goto L7;
    L9:
        return false;
    L7:
        if (this.mContext.equals(((JavaCronetProvider) ZeusTransformUtils.preCheckCast(r3, JavaCronetProvider.class, "com.obric.memorydata.plugin")).mContext) == false) goto L9;
        goto L9
    }

    @Override // com.ttnet.org.chromium.net.CronetProvider
    public String getName() {
        return CronetProvider.PROVIDER_NAME_FALLBACK;
    }

    @Override // com.ttnet.org.chromium.net.CronetProvider
    public String getVersion() {
        return ImplVersion.getCronetVersion();
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{JavaCronetProvider.class, this.mContext});
    }

    @Override // com.ttnet.org.chromium.net.CronetProvider
    public boolean isEnabled() {
        return true;
    }
}
