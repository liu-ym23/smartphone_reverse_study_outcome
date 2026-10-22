package com.ss.android.socialbase.downloader.core.module.normal;

import android.util.SparseArray;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.ss.android.socialbase.downloader.core.DownloadModuleChain;
import com.ss.android.socialbase.downloader.core.DownloadSingleResponseHandler;
import com.ss.android.socialbase.downloader.core.module.BaseDownloadNetworkModule;
import com.ss.android.socialbase.downloader.core.module.DownloadCommonParams;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.network.AbsDownloadHttpConnection;
import com.ss.android.socialbase.downloader.network.IDownloadHttpConnection;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public class DownloadSingleSegmentModule extends BaseDownloadNetworkModule {
    public IDownloadHttpConnection g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public DownloadSingleResponseHandler f15327h;

    public DownloadSingleSegmentModule() {
    }

    @Override // com.ss.android.socialbase.downloader.core.module.BaseDownloadNetworkModule, com.ss.android.socialbase.downloader.core.IDownloadModule
    public final void a(DownloadModuleChain r5) {
        if (Logger.a(this.f15290c) == false) goto L5;
        Logger.a("DownloadSingleSegmentModule", this.f15290c, "proceed", "Run");
    L5:
        DownloadCommonParams r10 = this.f;
        if (r10.f15312i == false) goto L9;
        r5.c();
        return;
    L9:
        r10.f15312i = true;
        if (b() == false) goto L18;
        return;
    L18:
        d();     // Catch: Throwable -> L15
        BaseDownloadNetworkModule.a(this.g);
        r5.c();
        return;
    L15:
        th = move-exception;
        BaseDownloadNetworkModule.a(this.g);
        throw th;
    }

    @Override // com.ss.android.socialbase.downloader.core.AbsDownloadModule, com.ss.android.socialbase.downloader.core.IDownloadModule
    public final void cancel() {
        DownloadSingleResponseHandler r5 = this.f15327h;
        if (r5 == null) goto L6;
        r5.a();
        return;
    L6:
        BaseDownloadNetworkModule.a(this.g);
    }

    public final void d() {
        String r5 = this.f15290c.h();
        DownloadInfo r10 = this.f15290c;
        SparseArray r11 = DownloadHelper.f16133a;
        if (r10 != null) goto L5;
        long r12 = -1;
    L6:
        int r13 = this.d.a("verify_response_pre_file_length", 0);
        if (r13 <= 0) goto L13;
        String r14 = DownloadConstants.f15275a;
        if (r13 >= 32768) goto L13;
        long r15 = r13;
        if (r12 <= r15) goto L13;
        DownloadInfo r16 = this.f15290c;
        r16.L0 = r12;
        r12 = r12 - r15;
        r16.b(r12);
    L13:
        DownloadInfo r17 = this.f15290c;
        r17.d();
        long r18 = r17.T0.optLong("start_offset") + r12;
        ArrayList r19 = a(r18, this.f15290c.k(), true);
        this.f.f15317n.a(r19);
        this.f15290c.C0 = r19.toString();
        this.g = a(r5, r19, r18);
        if (b() == true) goto L21;
        a(r5, r12, this.g);
        DownloadInfo r20 = this.f15290c;
        long r21 = r20.f15817h0;
        b(r21, r20.f15819j);
        if (b() == false) goto L19;
        return;
    L19:
        DownloadSingleResponseHandler r22 = new DownloadSingleResponseHandler(this.f, this.g, r18, r21 - r12, this);
        this.f15327h = r22;
        r22.b();
        return;
    L21:
        return;
    L5:
        r12 = r10.i();
        goto L6
    }

    @Override // com.ss.android.socialbase.downloader.core.AbsDownloadModule, com.ss.android.socialbase.downloader.core.IDownloadModule
    public final void a() {
        DownloadSingleResponseHandler r5 = this.f15327h;
        if (r5 == null) goto L6;
        r5.c();
        return;
    L6:
        BaseDownloadNetworkModule.a(this.g);
    }

    @Override // com.ss.android.socialbase.downloader.core.AbsDownloadModule, com.ss.android.socialbase.downloader.core.IDownloadModule
    public final void a(long r5, int r10) {
        if (DownloadSetting.a(this.f15290c.l(), null).a("use_default_throttle_speed", 1) == 1) goto L13;
        IDownloadHttpConnection r11 = this.g;
        if (r11 != null) goto L7;
        return;
    L7:
        if ((r11 instanceof AbsDownloadHttpConnection) == false) goto L22;
        AbsDownloadHttpConnection r12 = (AbsDownloadHttpConnection) r11;     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        th.printStackTrace();
        return;
    L22:
        return;
    L13:
        DownloadSingleResponseHandler r13 = this.f15327h;
        if (r13 == null) goto L21;
        DownloadInfo r14 = r13.f15297a;
        r14.I0 = r5;
        r14.J0 = r10;
        r13.f15304l = true;
        return;
    }
}
