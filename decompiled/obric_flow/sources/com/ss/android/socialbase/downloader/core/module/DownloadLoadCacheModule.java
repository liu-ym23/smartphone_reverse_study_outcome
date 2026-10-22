package com.ss.android.socialbase.downloader.core.module;

import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.core.AbsDownloadModule;
import com.ss.android.socialbase.downloader.core.DownloadModuleChain;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.impls.DefaultDownloadCache;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.service.DownloadServiceManager;
import com.ss.android.socialbase.downloader.service.IDownloadIdGeneratorService;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import java.util.HashSet;

/* JADX INFO: loaded from: classes3.dex */
public class DownloadLoadCacheModule extends AbsDownloadModule {
    public DownloadLoadCacheModule() {
    }

    @Override // com.ss.android.socialbase.downloader.core.AbsDownloadModule
    public final AbsDownloadModule a(DownloadCommonParams r5) {
        if (r5.f15310c.b1 == false) goto L7;
        return null;
    L7:
        return super.a(r5);
    }

    @Override // com.ss.android.socialbase.downloader.core.IDownloadModule
    public final void a(DownloadModuleChain r12) {
        if (Logger.a(this.f15290c) == false) goto L5;
        Logger.a("DownloadLoadCacheModule", this.f15290c, "proceed", "Run");
    L5:
        int r5 = this.f15290c.l();
        boolean r10 = this.f15288a.e();
        DownloadInfo r11 = this.f15288a.a(r5);
        if (r11 != null) goto L12;
        if (r10 == false) goto L10;
        SparseArray r13 = DownloadHelper.f16133a;
        DownloadSetting r14 = DownloadSetting.f;
        HashSet r15 = DownloadHelper.a(r14.c("skip_db_init_monitor_scene_list"));
        HashSet r16 = DownloadHelper.a(r14.c("skip_db_init_expect_mime_type"));
        HashSet r17 = DownloadHelper.a(r14.c("db_init_monitor_scene_list"));
        DownloadInfo r18 = this.f15290c;
        if (DownloadHelper.a(r15, r16, r17, r18.f15839u, r18.P) == false) goto L12;
    L10:
        r11 = ((DefaultDownloadCache) this.f15288a).f15675b.a(r5);
    L12:
        if (Logger.a(this.f15290c) == false) goto L14;
        Logger.a("DownloadLoadCacheModule", this.f15290c, "doLoadCache", "Find Cache:" + r10 + "CacheDownloadInfo" + r11);
    L14:
        boolean r19 = true;
        if (r11 != null) goto L17;
    L45:
        this.f15290c.z();
        if (Logger.a(this.f15290c) == false) goto L48;
        Logger.a("DownloadLoadCacheModule", this.f15290c, "doLoadCache", "Download reset");
    L48:
        if (r19 == false) goto L51;
        this.f15288a.a(this.f15290c);
    L51:
        if (Logger.a(this.f15290c) == false) goto L54;
        Logger.a("DownloadLoadCacheModule", this.f15290c, "doLoadCache", "After load:" + this.f15290c);
    L54:
        if (b() == false) goto L56;
        return;
    L56:
        r12.c();
        return;
    L17:
        if (r11.o() == 0) goto L45;
        if (r11.f15828o == true) goto L45;
        DownloadInfo r20 = this.f15290c;
        r20.d();
        long r21 = r20.T0.optLong("start_offset");
        r11.d();
        if (r21 != r11.T0.optLong("start_offset")) goto L45;
        if (this.f15290c.k() != r11.k()) goto L45;
        this.f15290c.a(r11, true);
        boolean r22 = false;
        if (this.d.a("enable_replace_external_path", 0) > 0) goto L29;
    L33:
        DownloadInfo r23 = this.f15290c;
        if (r11 == r23) goto L37;
        r22 = true;
    L37:
        if (r23.e.equals(r11.e) == false) goto L41;
        char[] r24 = DownloadUtils.f16142a;
        if (DownloadUtils.a(r11, r11.f15828o, r11.C) == false) goto L41;
        DownloadCommonParams r25 = this.f;
        r25.f15315l = r11.f15808b;
        r25.f15314k = r11.e;
    L44:
        r19 = r22;
    L41:
        Context r26 = DownloadComponentManager.f15515a;
        if (((IDownloadIdGeneratorService) DownloadServiceManager.a(IDownloadIdGeneratorService.class)).a(r11) == r5) goto L44;
        this.f15288a.d(r5);
        goto L48
    L29:
        if (TextUtils.isEmpty(this.f15290c.C) == false) goto L33;
        if (TextUtils.isEmpty(r11.C) == true) goto L33;
        this.f15290c.C = r11.C;
        goto L33
    }
}
