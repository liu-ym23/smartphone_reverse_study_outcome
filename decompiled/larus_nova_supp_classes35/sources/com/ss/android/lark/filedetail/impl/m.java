package com.ss.android.lark.filedetail.impl;

import android.view.View;
import com.larksuite.component.ui.toast.LKUIToast;
import com.larksuite.framework.thread.CoreThreadPool;
import com.ss.android.lark.chat.entity.message.content.FileContent;
import com.ss.android.lark.filedetail.impl.detail.DecryptFileProcessor;
import com.ss.android.lark.filedetail.impl.detail.FileDownloadState;
import com.ss.android.lark.filedetail.impl.detail.FileHitPointUtil;
import com.ss.android.lark.filedetail.impl.detail.FileTransmissionPresenter;
import com.ss.android.lark.filedetail.impl.detail.y;
import com.ss.android.lark.filedetail.impl.open.FileOpenUtils;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.LarkContext;
import com.ss.lark.android.encryption.CipherManager;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class m implements View.OnClickListener {
    public final /* synthetic */ FileDetailFragment a;

    public m(FileDetailFragment r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r7) {
        hfb.b.InterfaceC0233b r8 = FileOpenUtils.a;
        if (CipherManager.d() != 1) goto L5;
        boolean r9 = true;
    L6:
        if (r9 == false) goto L9;
        Log.e("FileDetailFragment", "[cipher] FileDetailFragment: Cipher is ON, download is forbidden!");
        LKUIToast.enableToast();
        LKUIToast.show(LarkContext.getApplication(), 2131890600);
        CipherManager.h();
        return;
    L9:
        FileDetailFragment r10 = this.a;
        FileDownloadState r1 = r10.x;
        if (r1 != FileDownloadState.DONE) goto L12;
        r10.aa0();
        return;
    L12:
        FileDownloadState r2 = FileDownloadState.DOWNLOADING;
        if (r1 != r2) goto L16;
        FileHitPointUtil.d(r10.s, r10.i, r10.e, r1, "click_pause_download");
        FileDetailFragment r11 = this.a;
        r11.v = true;
        r11.V90(FileDownloadState.PAUSE);
        return;
    L16:
        if (r1 != FileDownloadState.DECRYPT_FAILED) goto L21;
        FileContent r0 = r10.i;
        FileTransmissionPresenter r12 = r10.f;
        if (r12 == null) goto L40;
        String r3 = r0.getFilePath();
        String r4 = r0.getName();
        ((DecryptFileProcessor) DecryptFileProcessor.e.getValue()).a(r12.l, r3, r4, new y(r12, r0));
        return;
    L40:
        return;
    L21:
        if (r1 != FileDownloadState.BURNED) goto L23;
        return;
    L23:
        if (r1 != FileDownloadState.RECALL) goto L25;
        return;
    L25:
        if (r1 != FileDownloadState.NORMAL) goto L27;
    L35:
        String r5 = r10.s;
        FileContent r6 = r10.i;
        int r13 = r10.e;
        Lazy r14 = FileHitPointUtil.a;
        Intrinsics.checkNotNullParameter(r6, "fileContent");
        CoreThreadPool.getDefault().getFixedThreadPool().execute(new com.ss.android.lark.filedetail.impl.detail.e(r13, r5, r6));
    L36:
        this.a.V90(r2);
        return;
    L27:
        if (r1 == FileDownloadState.STOP) goto L35;
        if (r1 != FileDownloadState.PAUSE) goto L33;
        FileHitPointUtil.c(r10.s, r10.i, r10.e, "click_resume_download");
        goto L36
    L33:
        if (r1 != FileDownloadState.DOWNLOAD_NETWORK) goto L36;
        FileHitPointUtil.c(r10.s, r10.i, r10.e, "click_retry_download");
        goto L36
    L5:
        r9 = false;
        goto L6
    }
}
