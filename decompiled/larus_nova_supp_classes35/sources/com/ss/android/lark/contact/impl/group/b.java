package com.ss.android.lark.contact.impl.group;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.larksuite.framework.mvp.BasePresenter;
import com.larksuite.framework.mvp.IView;
import q9b.d;
import q9b.e;
import q9b.k;
import q9b.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b extends BasePresenter<k, Object, l> {
    public final /* bridge */ /* synthetic */ IView.IViewDelegate createViewDelegate() {
        return null;
    }

    public b(FragmentActivity r2, ContactsMyGroupFragment.a r3, d r4, FragmentManager r5) {
        setModel(new e(r4));
        setView(new ContactsMyGroupView(((k) getModel()).B7(r2), r3, r5));
    }
}
