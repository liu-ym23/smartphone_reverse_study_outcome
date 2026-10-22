package com.larksuite.framework.mvp;

import com.larksuite.framework.callback.CallbackManager;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public class BaseModel implements IModel {
    private CallbackManager mCallbackManager;

    @Override // com.larksuite.framework.mvp.ILifecycle
    public void create() {
    }

    @Override // com.larksuite.framework.mvp.ILifecycle
    public void destroy() {
        this.mCallbackManager.cancelCallbacks();
    }

    public BaseModel() {
        this.mCallbackManager = new CallbackManager();
    }

    public CallbackManager getCallbackManager() {
        return this.mCallbackManager;
    }
}
