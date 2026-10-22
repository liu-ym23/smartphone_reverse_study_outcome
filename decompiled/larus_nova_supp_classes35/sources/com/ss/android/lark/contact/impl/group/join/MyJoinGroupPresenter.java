package com.ss.android.lark.contact.impl.group.join;

import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.framework.callback.UIGetDataCallback;
import com.larksuite.framework.mvp.BasePresenter;
import com.larksuite.framework.mvp.IView;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.log.Log;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class MyJoinGroupPresenter extends BasePresenter<a, b, b.a> {

    /* JADX INFO: renamed from: com.ss.android.lark.contact.impl.group.join.MyJoinGroupPresenter$2, reason: invalid class name */
    class AnonymousClass2 implements IGetDataCallback<List<Chat>> {
        final /* synthetic */ MyJoinGroupPresenter this$0;

        public AnonymousClass2(MyJoinGroupPresenter r1) {
            this.this$0 = r1;
        }

        public void onError(ErrorResult r3) {
            Log.e("get joined groups failed: " + r3.toString());
        }

        public void onSuccess(List<Chat> r2) {
            ((b) this.this$0.getView()).X7(r2);
        }

        public /* bridge */ /* synthetic */ void onError(Object r1) {
            onError((ErrorResult) r1);
        }

        public /* bridge */ /* synthetic */ void onSuccess(Object r1) {
            onSuccess((List) r1);
        }
    }

    public class ViewDelegate implements b.a {
        public final /* synthetic */ MyJoinGroupPresenter a;

        @Override // com.ss.android.lark.contact.impl.group.join.b.a
        public final boolean canLoadMore() {
            return ((a) this.a.getModel()).isHasMore();
        }

        @Override // com.ss.android.lark.contact.impl.group.join.b.a
        public final void v1() {
            ((a) this.a.getModel()).N0(new UIGetDataCallback(new AnonymousClass1(this)));
        }

        public ViewDelegate(MyJoinGroupPresenter r1) {
            this.a = r1;
        }
    }

    public final IView.IViewDelegate createViewDelegate() {
        return new ViewDelegate(this);
    }

    public final void create() {
        super.create();
        ((a) getModel()).t5(new UIGetDataCallback(new AnonymousClass1(this)));
    }

    public MyJoinGroupPresenter(c r1, MyJoinGroupView r2) {
        super(r1, r2);
    }
}
