package com.larksuite.framework.mvp;

import com.larksuite.framework.mvp.IView.IViewDelegate;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public interface IView<VD extends IViewDelegate> extends ILifecycle {

    public interface IViewDelegate {
    }

    void setViewDelegate(VD r1);
}
