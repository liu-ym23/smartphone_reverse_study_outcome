package com.ss.android.lark.component.appcontext;

import android.app.Application;
import com.ss.android.lark.component.appcontext.model.LarkBuildConfig;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class c implements ILarkAppContext {
    public c() {
    }

    @Override // com.ss.android.lark.component.appcontext.ILarkAppContext
    public final b8b.a appIdInfo() {
        return ((b) AppContextDependencyProvider.a.getValue()).getAppId();
    }

    @Override // com.ss.android.lark.component.appcontext.ILarkAppContext
    public final LarkBuildConfig buildConfig() {
        return ((b) AppContextDependencyProvider.a.getValue()).getBuildConfig();
    }

    @Override // com.ss.android.lark.component.appcontext.ILarkAppContext, com.ss.android.lark.component.appcontext.a
    public Application getContext() {
        return ((b) AppContextDependencyProvider.a.getValue()).getContext();
    }

    @Override // com.ss.android.lark.component.appcontext.ILarkAppContext
    public final b8b.b releaseInfo() {
        return ((b) AppContextDependencyProvider.a.getValue()).getReleaseInformation();
    }
}
