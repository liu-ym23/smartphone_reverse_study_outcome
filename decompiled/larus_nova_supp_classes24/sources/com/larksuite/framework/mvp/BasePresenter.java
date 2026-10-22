package com.larksuite.framework.mvp;

import com.larksuite.framework.callback.UICallbackExecutor;
import com.larksuite.framework.mvp.IModel;
import com.larksuite.framework.mvp.IView;
import com.larksuite.framework.mvp.IView.IViewDelegate;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public abstract class BasePresenter<M extends IModel, V extends IView<VD>, VD extends IView.IViewDelegate> implements IPresenter<M, V> {
    private M model;
    private V view;

    public class a implements Runnable {
        public final /* synthetic */ BasePresenter a;

        @Override // java.lang.Runnable
        public final void run() {
            BasePresenter.access$000(this.a).destroy();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(BasePresenter r1) {
            this.a = r1;
        }
    }

    public abstract VD createViewDelegate();

    @Override // com.larksuite.framework.mvp.ILifecycle
    public void create() {
        this.view.create();
        this.model.create();
    }

    @Override // com.larksuite.framework.mvp.ILifecycle
    public void destroy() {
        this.model.destroy();
        UICallbackExecutor.post(new a(this));
    }

    public BasePresenter() {
    }

    public M getModel() {
        return this.model;
    }

    public V getView() {
        return this.view;
    }

    public static /* synthetic */ IView access$000(BasePresenter r0) {
        return r0.view;
    }

    public void setModel(M r1) {
        this.model = r1;
    }

    public void setView(V r1) {
        this.view = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public BasePresenter(M r1, V r2) {
        this.view = r2;
        this.model = r1;
        r2.setViewDelegate(createViewDelegate());
    }
}
