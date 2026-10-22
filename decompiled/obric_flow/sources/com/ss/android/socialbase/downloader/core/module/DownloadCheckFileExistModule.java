package com.ss.android.socialbase.downloader.core.module;

import android.text.TextUtils;
import com.ss.android.socialbase.downloader.constants.RunStatus;
import com.ss.android.socialbase.downloader.core.AbsDownloadModule;
import com.ss.android.socialbase.downloader.core.DownloadModuleChain;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;

/* JADX INFO: loaded from: classes3.dex */
public class DownloadCheckFileExistModule extends AbsDownloadModule {
    public DownloadCheckFileExistModule() {
    }

    public static void b(DownloadCommonParams r5) {
        if (r5.f15315l.equals(r5.f15310c.f15808b) == false) goto L5;
        r5.f = RunStatus.d;
    L6:
        r5.f15310c.M0 = true;
        return;
    L5:
        r5.f = RunStatus.f;
        goto L6
    }

    @Override // com.ss.android.socialbase.downloader.core.AbsDownloadModule
    public final AbsDownloadModule a(DownloadCommonParams r5) {
        if (r5.f15310c.b1 == false) goto L7;
        return null;
    L7:
        return super.a(r5);
    }

    @Override // com.ss.android.socialbase.downloader.core.IDownloadModule
    public final void a(DownloadModuleChain r5) {
        if (Logger.a(this.f15290c) == false) goto L6;
        Logger.a("DownloadCheckFileExistModule", this.f15290c, "proceed", "Run");
    L6:
        if (TextUtils.isEmpty(this.f.f15315l) == true) goto L14;
        DownloadInfo r10 = this.f15290c;
        if (r10.R == false) goto L10;
        DownloadCommonParams r11 = this.f;
        r11.f15313j = DownloadUtils.a(r10, r10.S);
    L10:
        DownloadCommonParams r12 = this.f;
        if (r12.f15313j == true) goto L14;
        b(r12);
        return;
    L14:
        DownloadInfo r13 = this.f15290c;
        if (r13.R == true) goto L20;
        char[] r14 = DownloadUtils.f16142a;
        if (DownloadUtils.a(r13, r13.f15828o, r13.C) == false) goto L20;
        DownloadCommonParams r15 = this.f;
        DownloadInfo r16 = this.f15290c;
        r15.f15315l = r16.f15808b;
        r15.f15314k = r16.e;
        b(r15);
        return;
    L20:
        DownloadInfo r17 = this.f15290c;
        if (r17.f15814e0 <= 1) goto L23;
        r17.z();
        DownloadUtils.b(this.f15290c, true);
        this.f15288a.a(this.f15290c);
    L23:
        r5.c();
    }
}
