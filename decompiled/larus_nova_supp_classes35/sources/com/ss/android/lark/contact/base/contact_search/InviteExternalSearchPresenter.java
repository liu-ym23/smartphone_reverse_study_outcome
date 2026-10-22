package com.ss.android.lark.contact.base.contact_search;

import android.app.Activity;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.framework.mvp.BasePresenter;
import com.larksuite.framework.mvp.IView;
import com.ss.android.lark.utils.ApiUtils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class InviteExternalSearchPresenter extends BasePresenter<a, b, b.a> {
    public String a;
    public String b;
    public String c;
    public final Fragment d;

    public abstract class InviteSearchViewDelegate<T> implements b.a {
        public IGetDataCallback<T> a;
        public final /* synthetic */ InviteExternalSearchPresenter b;

        @Override // com.ss.android.lark.contact.base.contact_search.b.a
        public final void H4() {
            if (TextUtils.isEmpty(this.b.a) == false) goto L5;
            Activity r0 = ((b) this.b.getView()).getActivity();
            ApiUtils.a r1 = new u(this);
            int r2 = com.ss.android.lark.contact.base.service.c0.a;
            com.ss.android.lark.contact.base.service.c0.a.a(r0, r1);
            return;
        L5:
            b r3 = (b) this.b.getView();
            InviteExternalSearchPresenter r4 = this.b;
            String r5 = r4.b;
            r3.M0(r4.a);
        }

        @Override // com.ss.android.lark.contact.base.contact_search.b.a
        public final String getUniqueId() {
            return this.b.c;
        }

        public InviteSearchViewDelegate(InviteExternalSearchPresenter r1) {
            this.b = r1;
        }

        @Override // com.ss.android.lark.contact.base.contact_search.b.a
        public final void x0(final String r3) {
            ((b) this.b.getView()).N5();
            this.a = new AnonymousClass1(this, r3);
            ((a) this.b.getModel()).x3(r3, this.a);
        }

        @Override // com.ss.android.lark.contact.base.contact_search.b.a
        public final void v3(String r4, boolean r5) {
            final InviteExternalSearchPresenter r0 = this.b;
            ((b) r0.getView()).i0();
            ((a) r0.getModel()).w4(r4, r5, new AnonymousClass2(r0));
        }
    }

    public final IView.IViewDelegate createViewDelegate() {
        return new t(this);
    }

    public InviteExternalSearchPresenter(Fragment r1, c r2, b0 r3) {
        super(r2, r3);
        this.d = r1;
        r3.b = new t(this);
    }
}
