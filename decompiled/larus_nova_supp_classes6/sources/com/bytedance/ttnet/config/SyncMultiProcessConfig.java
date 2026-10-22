package com.bytedance.ttnet.config;

import android.webkit.CookieManager;
import ay5.a;
import com.bytedance.common.utility.Lists;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.frameworks.baselib.network.http.NetworkParams;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.SsCronetHttpClient;
import com.bytedance.frameworks.baselib.network.http.impl.b;
import com.bytedance.frameworks.baselib.network.http.ok3.impl.SsOkHttp3Client;
import com.bytedance.frameworks.baselib.network.queryfilter.QueryFilterEngine;
import com.bytedance.ttnet.HttpClient;
import com.bytedance.ttnet.TTNetInit;
import com.bytedance.ttnet.retrofit.SsInterceptor;
import com.bytedance.ttnet.utils.TtnetUtil;
import com.obric.sva.sdk.session.IWakeupSessionConstant;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public class SyncMultiProcessConfig implements NetworkParams.h, a.a, HttpClient.IHttpClientConfig, SsCronetHttpClient.ICronetHttpDnsConfig, SsCronetHttpClient.ICronetBootFailureChecker {
    private static final String TAG = "SyncMainProcessConfig";
    private static volatile SyncMultiProcessConfig mInstance;
    private int mAddSsQueriesHeaderOpen;
    private int mAddSsQueriesOpen;
    private int mAddSsQueriesPlaintextOpen;
    private int mChromiumBootFailures;
    private int mHttpDnsEnabled;
    private String mShareCookieHostList;

    public static SyncMultiProcessConfig inst() {
        if (mInstance != null) goto L15;
        monitor-enter(SyncMultiProcessConfig.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (mInstance != null) goto L9;
        mInstance = new SyncMultiProcessConfig();     // Catch: Throwable -> L11
    L9:
        monitor-exit(SyncMultiProcessConfig.class);     // Catch: Throwable -> L11
    L15:
        return mInstance;
    }

    public boolean isChromiumOpen() {
        if (AppConfig.sForceNotUseCronet == false) goto L7;
        SsOkHttp3Client.setFallbackReason(0);
        return false;
    L7:
        if (AppConfig.sCronetUnsupportedModel == false) goto L11;
        SsOkHttp3Client.setFallbackReason(8);
        return false;
    L11:
        if (AppConfig.isCronetUnsupportedABI() == false) goto L14;
        return false;
    L14:
        if (AppConfig.sDisableFallbackReasonBoot == true) goto L20;
        if (this.mChromiumBootFailures <= 5) goto L20;
        SsOkHttp3Client.setFallbackReason(3);
        Logger.e(TAG, "After five consecutive crashes of cronet on subprocess, you must reinstall app to enable cronet, or wait until several hours");
        return false;
    L20:
        if (TTNetInit.getTTNetDepend().isCronetPluginInstalled() == true) goto L23;
        SsOkHttp3Client.setFallbackReason(6);
        return false;
    L23:
        return true;
    }

    public boolean isCronetBootFailureExpected() {
        if (AppConfig.sDisableFallbackReasonBoot == false) goto L6;
        return true;
    L6:
        if (TTNetInit.getTTNetDepend().getProviderInt(TTNetInit.getTTNetDepend().getContext(), "chromium_boot_failures", 0) <= 5) goto L10;
        return false;
    L10:
        return true;
    }

    public boolean isCronetHttpDnsOpen() {
        if (AppConfig.sForceNotUseCronet == false) goto L6;
        return false;
    L6:
        if (this.mHttpDnsEnabled <= 0) goto L9;
        return true;
    L9:
        return false;
    }

    public boolean isSsQueriesHeaderOpen() {
        if (this.mAddSsQueriesHeaderOpen <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isSsQueriesOpen() {
        if (this.mAddSsQueriesOpen <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isSsQueriesPlaintextOpen() {
        if (this.mAddSsQueriesPlaintextOpen <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    private SyncMultiProcessConfig() {
        SyncMainProcessConfig();
    }

    public void SyncMainProcessConfig() {
        TTNetInit.getTTNetDepend();     // Catch: Throwable -> L27
        Logger.w(TAG, "Sync main process config in current process.");
        this.mShareCookieHostList = TTNetInit.getTTNetDepend().getProviderString(TTNetInit.getTTNetDepend().getContext(), "share_cookie_host_list", "");
        TTNetInit.getTTNetDepend().onShareCookieConfigUpdated(this.mShareCookieHostList);
        boolean r4 = false;
        this.mAddSsQueriesOpen = TTNetInit.getTTNetDepend().getProviderInt(TTNetInit.getTTNetDepend().getContext(), "add_ss_queries_open", 0);
        int r0 = TTNetInit.getTTNetDepend().getProviderInt(TTNetInit.getTTNetDepend().getContext(), "add_ss_queries_header_open", 0);
        this.mAddSsQueriesHeaderOpen = r0;
        if (this.mAddSsQueriesOpen > 0) goto L6;
        if (r0 > 0) goto L6;
    L7:
        this.mAddSsQueriesPlaintextOpen = TTNetInit.getTTNetDepend().getProviderInt(TTNetInit.getTTNetDepend().getContext(), "add_ss_queries_plaintext_open", 1);
        this.mHttpDnsEnabled = TTNetInit.getTTNetDepend().getProviderInt(TTNetInit.getTTNetDepend().getContext(), "http_dns_enabled", 0);
        this.mChromiumBootFailures = TTNetInit.getTTNetDepend().getProviderInt(TTNetInit.getTTNetDepend().getContext(), "chromium_boot_failures", 0);
        int r1 = TTNetInit.getTTNetDepend().getProviderInt(TTNetInit.getTTNetDepend().getContext(), "query_filter_enabled", IWakeupSessionConstant.RC_ERROR);
        String r2 = TTNetInit.getTTNetDepend().getProviderString(TTNetInit.getTTNetDepend().getContext(), "query_filter_actions", "");
        String r3 = TTNetInit.getTTNetDepend().getProviderString(TTNetInit.getTTNetDepend().getContext(), "L0_params", "");
        QueryFilterEngine.inst().parseL0ParamsString(r3);
        if (r1 == Integer.MIN_VALUE) goto L15;
        QueryFilterEngine r5 = QueryFilterEngine.inst();
        if (r1 <= 0) goto L12;
        boolean r6 = true;
    L13:
        r5.enableQueryFilterEngine(r6);
        QueryFilterEngine.inst().onNetConfigChanged(r2);
        goto L15
    L12:
        r6 = false;
    L15:
        if (TTNetInit.getTTNetDepend().getProviderInt(TTNetInit.getTTNetDepend().getContext(), "private_protocol_enabled", 1) < 1) goto L17;
        boolean r7 = true;
    L18:
        NetworkParams.setPrivateProtocolEnabled(r7);
        if (TTNetInit.getTTNetDepend().getProviderInt(TTNetInit.getTTNetDepend().getContext(), "disable_rotating_host_path_retry", -1) < 1) goto L21;
        boolean r8 = true;
    L22:
        NetworkParams.setDisableRotationHostRetryByTnc(r8);
        if (TTNetInit.getTTNetDepend().getProviderInt(TTNetInit.getTTNetDepend().getContext(), "pp_force_use_shared_stream", 0) < 1) goto L25;
        r4 = true;
    L25:
        NetworkParams.setEnablePPForceUseSharedStream(r4);
        return;
    L21:
        r8 = false;
        goto L22
    L17:
        r7 = false;
    L6:
        SsInterceptor.EnableEncryptQuery(true);
    }

    public List<String> getShareCookieHostList(String r8) {
        ArrayList r0 = new ArrayList();
        if (StringUtils.isEmpty(this.mShareCookieHostList) == false) goto L24;
    L7:
        String[] r1 = null;
    L8:
        if (r1 == null) goto L15;
        int r3 = r1.length;
        int r4 = 0;
    L10:
        if (r4 >= r3) goto L15;
        String r5 = r1[r4];
        if (StringUtils.isEmpty(r5) == true) goto L14;
        r0.add(r5);
    L14:
        r4 = r4 + 1;
    L15:
        String r2 = TTNetInit.getTTNetDepend().getShareCookieMainDomain();
        if (StringUtils.isEmpty(r2) == true) goto L21;
        if (TtnetUtil.inCookieHostList(r2, r0) == true) goto L21;
        r0.add(r2);
    L21:
        if (TtnetUtil.inCookieHostList(r8, r0) == false) goto L23;
        return r0;
    L23:
        return null;
    L24:
        r1 = this.mShareCookieHostList.split(",");     // Catch: Throwable -> L6
        goto L8
    }

    public List<String> getShareCookie(CookieManager r10, b r11, URI r12) {
        ArrayList r0 = null;
        if (r12 == null) goto L45;
        if (r10 != null) goto L7;
        if (r11 == null) goto L45;
    L7:
        String r1 = TTNetInit.getTTNetDepend().getShareCookieMainDomain();
        if (StringUtils.isEmpty(r1) == false) goto L46;
        return null;
    L46:
        String r2 = r12.getHost();     // Catch: Exception -> L12
    L13:
        ArrayList r3 = new ArrayList();
        if (StringUtils.isEmpty(this.mShareCookieHostList) == false) goto L50;
    L18:
        String[] r4 = null;
    L19:
        if (r4 == null) goto L27;
        int r5 = r4.length;
        int r6 = 0;
    L21:
        if (r6 >= r5) goto L27;
        String r7 = r4[r6];
        if (StringUtils.isEmpty(r7) == true) goto L25;
        r3.add(r7);
    L25:
        r6 = r6 + 1;
    L27:
        if (StringUtils.isEmpty(r2) == true) goto L45;
        if (TtnetUtil.inCookieHostList(r2, r3) == false) goto L45;
        r0 = new ArrayList();
        if (r10 == null) goto L37;
        String r13 = r10.getCookie(r1);
        if (StringUtils.isEmpty(r13) == true) goto L37;
        r0.add(r13);
    L37:
        if (Lists.isEmpty(r0) == false) goto L45;
        if (r11 == null) goto L45;
        String r14 = r11.a(URI.create(r12.getScheme() + "://" + r1));     // Catch: Throwable -> L43
        if (StringUtils.isEmpty(r14) == true) goto L45;
        r0.add(r14);     // Catch: Throwable -> L43
        r0.add("x-tt-cookie-backup-source=1");     // Catch: Throwable -> L43
    L43:
        th = move-exception;
        th.printStackTrace();
        goto L45
    L50:
        r4 = this.mShareCookieHostList.split(",");     // Catch: Throwable -> L17
    L12:
        r2 = null;
    L45:
        return r0;
    }
}
