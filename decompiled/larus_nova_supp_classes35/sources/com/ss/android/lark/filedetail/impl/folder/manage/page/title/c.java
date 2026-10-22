package com.ss.android.lark.filedetail.impl.folder.manage.page.title;

import android.view.View;
import androidx.fragment.app.FragmentActivity;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class c implements View.OnClickListener {
    public final /* synthetic */ FolderTitleFragment a;

    public c(FolderTitleFragment r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r4) {
        int r5 = pfb.d.a;
        pfb.d.a.e(this.a.p, "close", "im_chat_main_view", null);
        FragmentActivity r6 = this.a.getActivity();
        if (r6 == null) goto L6;
        r6.finish();
        return;
    }
}
