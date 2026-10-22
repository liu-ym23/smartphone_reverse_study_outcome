package com.ss.android.socialbase.downloader.core.module;

import android.util.SparseArray;
import com.ss.android.socialbase.downloader.core.AbsDownloadModule;
import com.ss.android.socialbase.downloader.core.DownloadModuleChain;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import dn.a;

/* JADX INFO: loaded from: classes3.dex */
public class DownloadCheckTaskCanResumedModule extends AbsDownloadModule {
    public DownloadCheckTaskCanResumedModule() {
    }

    @Override // com.ss.android.socialbase.downloader.core.AbsDownloadModule
    public final AbsDownloadModule a(DownloadCommonParams r5) {
        if (r5.f15310c.b1 == false) goto L7;
        return null;
    L7:
        return super.a(r5);
    }

    @Override // com.ss.android.socialbase.downloader.core.IDownloadModule
    public final void a(DownloadModuleChain r14) {
        if (Logger.a(this.f15290c) == false) goto L5;
        Logger.a("DownloadCheckTaskCanResumedModule", this.f15290c, "proceed", "Run");
    L5:
        DownloadInfo r5 = this.f15290c;
        SparseArray r10 = DownloadHelper.f16133a;
        if (r5 == null) goto L13;
        boolean r11 = r5.u();
        if (Logger.a(r5) == false) goto L11;
        Logger.a("DownloadHelper", r5.l(), r5.P, "getCurByte", "ResumeAvailable:" + r11, false);
    L11:
        if (r11 == false) goto L13;
        long r12 = r5.i();
    L14:
        long r13 = this.f15290c.i();
        if (Logger.a(this.f15290c) == false) goto L17;
        DownloadInfo r15 = this.f15290c;
        StringBuilder r16 = a.K(r12, "Offset:", " curBytes: ");
        r16.append(r13);
        Logger.a("DownloadCheckTaskCanResumedModule", r15, "checkTaskCanResume", r16.toString());
    L17:
        this.f15290c.b(r12);
        if (r12 > 0) goto L27;
        if (this.f.f15313j == true) goto L27;
        if (Logger.a(this.f15290c) == false) goto L25;
        Logger.a("DownloadCheckTaskCanResumedModule", this.f15290c, "checkTaskCanResume", "deleteAllDownloadFiles");
    L25:
        this.f15288a.q(this.f15290c.l());
        DownloadUtils.b(this.f15290c, true);
    L27:
        if (this.d.a("clean_installed_apk", 0) <= 0) goto L29;
        DownloadInfo r17 = this.f15290c;
        r17.Z = 0;
        r17.f15806a0 = false;
    L29:
        r14.c();
        return;
    L13:
        r12 = 0;
        goto L14
    }
}
