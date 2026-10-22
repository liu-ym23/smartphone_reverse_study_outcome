package com.ttnet.org.chromium.net.impl;

import android.content.Context;
import com.ttnet.org.chromium.base.annotations.UsedByReflection;
import com.ttnet.org.chromium.net.CronetEngine;
import com.ttnet.org.chromium.net.CronetProvider;
import com.ttnet.org.chromium.net.ExperimentalCronetEngine;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public class NativeCronetProvider extends CronetProvider {
    @UsedByReflection("CronetProvider.java")
    public NativeCronetProvider(Context r10) {
        super(r10);
    }

    @Override // com.ttnet.org.chromium.net.CronetProvider
    public CronetEngine.Builder createBuilder(boolean r10) {
        return new ExperimentalCronetEngine.Builder(new NativeCronetEngineBuilderWithLibraryLoaderImpl(this.mContext, r10));
    }

    public boolean equals(Object r10) {
        if (r10 != this) goto L4;
    L9:
        return true;
    L4:
        if ((r10 instanceof NativeCronetProvider) == true) goto L6;
    L8:
        return false;
    L6:
        if (this.mContext.equals(((NativeCronetProvider) r10).mContext) == false) goto L8;
        goto L8
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
