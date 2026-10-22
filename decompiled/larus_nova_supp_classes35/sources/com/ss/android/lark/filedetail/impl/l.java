package com.ss.android.lark.filedetail.impl;

import android.view.View;
import com.larksuite.framework.thread.CoreThreadPool;
import com.ss.android.lark.chat.entity.message.content.FileContent;
import com.ss.android.lark.filedetail.impl.detail.FileDownloadState;
import com.ss.android.lark.filedetail.impl.detail.FileHitPointUtil;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class l implements View.OnClickListener {
    public final /* synthetic */ FileDetailFragment a;

    public l(FileDetailFragment r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r5) {
        FileDetailFragment r6 = this.a;
        if (r6.x == FileDownloadState.DONE) goto L6;
        r6.V90(FileDownloadState.STOP);
        FileDetailFragment r7 = this.a;
        String r0 = r7.s;
        FileContent r1 = r7.i;
        int r8 = r7.e;
        Lazy r2 = FileHitPointUtil.a;
        Intrinsics.checkNotNullParameter(r1, "fileContent");
        CoreThreadPool.getDefault().getFixedThreadPool().execute(new com.ss.android.lark.filedetail.impl.detail.d(r8, r0, r1));
        return;
    }
}
