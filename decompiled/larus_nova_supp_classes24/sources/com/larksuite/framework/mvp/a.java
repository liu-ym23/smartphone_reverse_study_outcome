package com.larksuite.framework.mvp;

import com.larksuite.framework.mvp.IView.IViewDelegate;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public class a<VD extends IView.IViewDelegate> implements IView<VD> {
    public VD a;

    public a() {
    }

    @Override // com.larksuite.framework.mvp.ILifecycle
    public void destroy() {
        this.a = null;
    }

    @Override // com.larksuite.framework.mvp.IView
    public void setViewDelegate(VD r1) {
        this.a = r1;
    }
}
