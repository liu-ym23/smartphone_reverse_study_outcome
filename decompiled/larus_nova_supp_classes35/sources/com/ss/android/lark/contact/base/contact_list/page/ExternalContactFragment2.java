package com.ss.android.lark.contact.base.contact_list.page;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.ss.android.lark.base.fragment.BaseFragment;
import com.ss.android.lark.contact.base.contact_list.mvp.ExternalContactPresenter2;
import com.ss.android.lark.contact.base.contact_list.mvp.ExternalContactView2;
import qqb.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class ExternalContactFragment2 extends BaseFragment {
    public static final /* synthetic */ int g = 0;
    public ExternalContactPresenter2 d;
    public View e;
    public a f;

    public class a implements ExternalContactView2.c {
        public final /* synthetic */ ExternalContactFragment2 a;

        public a(ExternalContactFragment2 r1) {
            this.a = r1;
        }
    }

    public ExternalContactFragment2() {
        this.f = new a(this);
    }

    public final void onDestroy() {
        super.onDestroy();
        ExternalContactPresenter2 r0 = this.d;
        if (r0 == null) goto L5;
        r0.destroy();
    L5:
        this.f = null;
    }

    public final View onCreateView(final LayoutInflater r1, final ViewGroup r2, Bundle r3) {
        return (View) c.b("ExternalContactFragment2 onCreateView", new x8b.a(this, r1, r2));
    }
}
