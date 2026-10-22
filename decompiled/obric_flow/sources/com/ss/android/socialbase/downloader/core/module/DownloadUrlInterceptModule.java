package com.ss.android.socialbase.downloader.core.module;

import android.text.TextUtils;
import com.ss.android.socialbase.downloader.core.AbsDownloadModule;
import com.ss.android.socialbase.downloader.core.DownloadModuleChain;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.logger.Logger;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class DownloadUrlInterceptModule extends AbsDownloadModule {
    public JSONArray g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public JSONArray f15324h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public JSONArray f15325i;

    public DownloadUrlInterceptModule() {
    }

    @Override // com.ss.android.socialbase.downloader.core.AbsDownloadModule
    public final AbsDownloadModule a(DownloadCommonParams r5) {
        JSONObject r10 = r5.d.d("url_intercept_config");
        if (r10 != null) goto L5;
        return null;
    L5:
        this.g = r10.optJSONArray("host_list");
        this.f15324h = r10.optJSONArray("path_list");
        JSONArray r11 = r10.optJSONArray("pattern_list");
        this.f15325i = r11;
        if (this.g != null) goto L12;
        if (this.f15324h != null) goto L12;
        if (r11 != null) goto L12;
        return null;
    L12:
        return super.a(r5);
    }

    @Override // com.ss.android.socialbase.downloader.core.IDownloadModule
    public final void a(DownloadModuleChain r11) {
        String r5 = this.f15290c.d;
        URL r10 = new URL(r5);     // Catch: MalformedURLException -> L41
        String r12 = r10.getHost();
        String r13 = r10.getPath();
        int r14 = 0;
        if (this.g == null) goto L16;
        int r15 = 0;
    L8:
        if (r15 >= this.g.length()) goto L16;
        String r16 = this.g.optString(r15);
        if (TextUtils.isEmpty(r16) == true) goto L14;
        if (r12.equals(r16) == false) goto L14;
    L37:
        throw new BaseException(1083, "download url intercept");
    L14:
        r15 = r15 + 1;
    L16:
        if (this.f15324h == null) goto L27;
        int r17 = 0;
    L19:
        if (r17 >= this.f15324h.length()) goto L27;
        String r18 = this.f15324h.optString(r17);
        if (TextUtils.isEmpty(r18) == true) goto L25;
        if (r13.equals(r18) == true) goto L37;
    L25:
        r17 = r17 + 1;
    L27:
        if (this.f15325i != null) goto L29;
    L43:
        r11.c();
        return;
    L29:
        if (r14 >= this.f15325i.length()) goto L43;
        String r19 = this.f15325i.optString(r14);
        if (TextUtils.isEmpty(r19) == true) goto L40;
        if (Pattern.matches(r19, r5) == true) goto L37;
    L38:
        th = move-exception;
        Logger.a("DownloadUrlInterceptModule", this.f15290c.l(), "checkUrlIntercept", "Error:" + th);
    L40:
        r14 = r14 + 1;
    L41:
        e = move-exception;
        Logger.a("DownloadUrlInterceptModule", this.f15290c.l(), "checkUrlIntercept", "Error:" + e);
        goto L43
    }
}
