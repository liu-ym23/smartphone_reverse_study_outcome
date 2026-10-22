package com.ss.android.lark.filedetail.impl;

import com.ss.android.lark.filedetail.FileDetailModule;
import com.ss.android.lark.filedetail.impl.detail.FileDownloadState;
import com.ss.android.lark.utils.rxjava.RxScheduledExecutor;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class o implements RxScheduledExecutor.Consumer<String> {
    public final /* synthetic */ FileDetailFragment a;

    public o(FileDetailFragment r1) {
        this.a = r1;
    }

    public final void consume(Object r7) {
        String r8 = (String) r7;
        this.a.i.getName();
        if (sfb.c.c(r8) == false) goto L8;
        this.a.i.setFilePath(r8);
        FileDetailFragment r9 = this.a;
        if (r9.z != FileDetailModule.NetworkType.NO_INTERNET_CONNECTION) goto L7;
        r9.V90(FileDownloadState.DONE);
        r9.ba0();
        return;
    L7:
        r9.W90();
        return;
    L8:
        FileDetailFragment r10 = this.a;
        if (r10.v == false) goto L11;
        r10.V90(FileDownloadState.PAUSE);
        return;
    L11:
        FileDetailModule.NetworkType r0 = r10.z;
        if (r0 != FileDetailModule.NetworkType.WIFI) goto L15;
        r10.V90(FileDownloadState.DOWNLOADING);
        return;
    L15:
        if (r0 != FileDetailModule.NetworkType.CELLULAR_DATA_NETWORK) goto L24;
        long r1 = r10.i.getSize() - ((this.a.i.getSize() * ((long) this.a.vProgressBar.getProgress())) / 100);
        int r11 = FileDetailFragment.N;
        if (r1 > 0) goto L19;
        this.a.V90(FileDownloadState.DOWNLOADING);
        return;
    L19:
        FileDetailFragment r12 = this.a;
        FileDownloadState r2 = r12.x;
        FileDownloadState r3 = FileDownloadState.NORMAL;
        if (r2 == r3) goto L22;
        r3 = FileDownloadState.PAUSE;
    L22:
        r12.V90(r3);
        return;
    L24:
        if (r0 != FileDetailModule.NetworkType.NO_INTERNET_CONNECTION) goto L33;
        r10.V90(r10.x);
        return;
    }
}
