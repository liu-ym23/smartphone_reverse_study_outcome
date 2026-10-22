package com.ss.android.socialbase.downloader.core.module;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.ss.android.socialbase.downloader.core.AbsDownloadModule;
import com.ss.android.socialbase.downloader.core.DownloadModuleChain;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.service.DownloadServiceManager;
import com.ss.android.socialbase.downloader.service.IDownloadIdGeneratorService;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;

/* JADX INFO: loaded from: classes3.dex */
public class DownloadCheckHasAnotherSameTaskModule extends AbsDownloadModule {
    public DownloadCheckHasAnotherSameTaskModule() {
    }

    @Override // com.ss.android.socialbase.downloader.core.AbsDownloadModule
    public final AbsDownloadModule a(DownloadCommonParams r5) {
        if (r5.f15310c.b1 == false) goto L7;
        return null;
    L7:
        return super.a(r5);
    }

    @Override // com.ss.android.socialbase.downloader.core.IDownloadModule
    public final void a(DownloadModuleChain r10) {
        if (Logger.a(this.f15290c) == false) goto L5;
        Logger.a("DownloadCheckHasAnotherSameTaskModule", this.f15290c, "proceed", "Run");
    L5:
        int r5 = this.f15290c.l();
        DownloadInfo r11 = this.f15290c;
        Context r12 = DownloadComponentManager.f15515a;
        int r13 = ((IDownloadIdGeneratorService) DownloadServiceManager.a(IDownloadIdGeneratorService.class)).a(r11);
        DownloadInfo r14 = this.f15288a.a(r13);
        if (r14 != null) goto L8;
    L29:
        r10.c();
        return;
    L8:
        if (r14.l() == r5) goto L29;
        DownloadInfo r15 = this.f15290c;
        if (r15 == null) goto L29;
        String r16 = r14.d;
        if (r16 == null) goto L29;
        if (r16.equals(r15.d) == false) goto L29;
        String r17 = r14.e;
        if (r17 == null) goto L29;
        if (r17.equals(r15.e) == false) goto L29;
        if (DownloadComponentManager.j().i(r14.l()) == true) goto L27;
        DownloadUtils.b(this.f15290c, true);
        this.f15288a.d(r13);
        if (r14.u() == false) goto L29;
        this.f15290c.a(r14, false);
        this.f15288a.a(this.f15290c);
        throw new BaseException(1089, "retry task because id generator changed");
    L27:
        this.f15288a.d(r5);
        throw new BaseException(InputDeviceCompat.SOURCE_GAMEPAD, "another same task is downloading");
    }
}
