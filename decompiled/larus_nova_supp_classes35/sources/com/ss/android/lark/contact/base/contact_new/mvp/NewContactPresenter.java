package com.ss.android.lark.contact.base.contact_new.mvp;

import com.larksuite.framework.callback.UICallbackExecutor;
import com.larksuite.framework.callback.UIGetDataCallback;
import com.larksuite.framework.mvp.BasePresenter;
import com.larksuite.framework.mvp.IView;
import com.larksuite.framework.utils.y;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.contact.base.dto.ChatApplication;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class NewContactPresenter extends BasePresenter<com.ss.android.lark.contact.base.contact_new.mvp.a, b, b.a> {

    public class ViewDelegate implements b.a {
        public final /* synthetic */ NewContactPresenter a;

        @Override // com.ss.android.lark.contact.base.contact_new.mvp.b.a
        public final void T() {
            ((com.ss.android.lark.contact.base.contact_new.mvp.a) this.a.getModel()).e4(new UIGetDataCallback(new AnonymousClass1(this)));
        }

        @Override // com.ss.android.lark.contact.base.contact_new.mvp.b.a
        public final boolean canLoadMore() {
            return ((com.ss.android.lark.contact.base.contact_new.mvp.a) this.a.getModel()).isHasMore();
        }

        public ViewDelegate(NewContactPresenter r1) {
            this.a = r1;
        }

        @Override // com.ss.android.lark.contact.base.contact_new.mvp.b.a
        public final void j0(final NewContactView.a r5) {
            ((com.ss.android.lark.contact.base.contact_new.mvp.a) this.a.getModel()).a4(r5.a, new UIGetDataCallback(new AnonymousClass2(this, r5)));
        }

        @Override // com.ss.android.lark.contact.base.contact_new.mvp.b.a
        public final void t0(String r2, String r3) {
            ((b) this.a.getView()).J(r2, r3);
        }
    }

    public class a implements com.ss.android.lark.contact.base.contact_new.mvp.a.InterfaceC0166a {
        public final /* synthetic */ NewContactPresenter a;

        /* JADX INFO: renamed from: com.ss.android.lark.contact.base.contact_new.mvp.NewContactPresenter$a$a, reason: collision with other inner class name */
        public class RunnableC0165a implements Runnable {
            public final /* synthetic */ List a;
            public final /* synthetic */ a b;

            @Override // java.lang.Runnable
            public final void run() {
                b r0 = (b) this.b.a.getView();     // Catch: Throwable -> L4
                NewContactPresenter r1 = this.b.a;     // Catch: Throwable -> L4
                List r2 = this.a;     // Catch: Throwable -> L4
                r1.getClass();     // Catch: Throwable -> L4
                r0.B1(y.a(r2, new h(r1)));     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }

            public RunnableC0165a(a r1, List r2) {
                this.b = r1;
                this.a = r2;
            }
        }

        public a(NewContactPresenter r1) {
            this.a = r1;
        }

        @Override // com.ss.android.lark.contact.base.contact_new.mvp.a.InterfaceC0166a
        public final void a(List<ChatApplication> r2) {
            UICallbackExecutor.execute(new RunnableC0165a(this, r2));
        }
    }

    public final IView.IViewDelegate createViewDelegate() {
        return new ViewDelegate(this);
    }

    public final void create() {
        super.create();
        ((b) getView()).showLoading();
        ((com.ss.android.lark.contact.base.contact_new.mvp.a) getModel()).e4(new UIGetDataCallback(new AnonymousClass1(this)));
    }

    public NewContactPresenter(g r1, NewContactView r2) {
        super(r1, r2);
        ((com.ss.android.lark.contact.base.contact_new.mvp.a) getModel()).X1(new a(this));
    }
}
