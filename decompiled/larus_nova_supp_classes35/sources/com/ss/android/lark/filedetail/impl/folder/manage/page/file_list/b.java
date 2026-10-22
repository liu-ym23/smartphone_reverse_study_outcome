package com.ss.android.lark.filedetail.impl.folder.manage.page.file_list;

import com.larksuite.framework.callback.UIGetDataCallback;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b implements j.a {
    public final /* synthetic */ a a;

    @Override // com.ss.android.lark.filedetail.impl.folder.manage.page.file_list.j.a
    public final int M() {
        return ((i) this.a.getModel()).M();
    }

    @Override // com.ss.android.lark.filedetail.impl.folder.manage.page.file_list.j.a
    public final boolean o0() {
        return ((i) this.a.getModel()).w2();
    }

    @Override // com.ss.android.lark.filedetail.impl.folder.manage.page.file_list.j.a
    public final void onLoadMore() {
        ((i) this.a.getModel()).m6(new UIGetDataCallback(this.a.d));
    }

    public b(a r1) {
        this.a = r1;
    }

    @Override // com.ss.android.lark.filedetail.impl.folder.manage.page.file_list.j.a
    public final void U(int r2) {
        ((i) this.a.getModel()).U(r2);
    }
}
