package com.ss.android.lark.contact.impl.group.manage;

import com.larksuite.framework.callback.UIGetDataCallback;
import com.larksuite.framework.mvp.BasePresenter;
import com.larksuite.framework.mvp.IView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class MyManageGroupPresenter extends BasePresenter<a, b, b.a> {

    public class ViewDelegate implements b.a {
        public final /* synthetic */ MyManageGroupPresenter a;

        @Override // com.ss.android.lark.contact.impl.group.manage.b.a
        public final void Z7() {
            ((a) this.a.getModel()).U1(new UIGetDataCallback(new AnonymousClass1(this)));
        }

        @Override // com.ss.android.lark.contact.impl.group.manage.b.a
        public final boolean canLoadMore() {
            return ((a) this.a.getModel()).isHasMore();
        }

        public ViewDelegate(MyManageGroupPresenter r1) {
            this.a = r1;
        }
    }

    public final IView.IViewDelegate createViewDelegate() {
        return new ViewDelegate(this);
    }

    public final void create() {
        super.create();
        ((a) getModel()).U1(new UIGetDataCallback(new AnonymousClass1(this)));
    }

    public MyManageGroupPresenter(d r1, MyManageGroupView r2) {
        super(r1, r2);
    }
}
