package com.ss.android.lark.filedetail.impl.folder.manage.page.title;

import android.view.View;
import com.ss.android.lark.chat.constant.ChatFromType;
import com.ss.android.lark.filedetail.FileDetailModule;
import com.ss.android.lark.officesdk.integrator.mock.FileDetailModuleDependencyMock;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b implements View.OnClickListener {
    public final /* synthetic */ FolderTitleFragment a;

    public b(FolderTitleFragment r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r4) {
        int r5 = pfb.d.a;
        pfb.d.a.e(this.a.d.b, ChatFromType.SEARCH, "none", null);
        com.ss.android.lark.storage.a r6 = FileDetailModule.a;
        hfb.b r7 = FileDetailModule.a.a();
        if (r7 != null) goto L5;
        return;
    L5:
        if (r7.getSearchDependency() == null) goto L9;
        FileDetailModuleDependencyMock.f(this.a.getContext(), this.a.d.b);
        return;
    }
}
