package com.bytedance.ttnet.config;

import android.content.Context;
import android.webkit.CookieManager;
import com.bytedance.common.utility.Logger;
import com.bytedance.frameworks.baselib.network.http.ok3.impl.o;
import com.bytedance.ttnet.TTNetInit;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class h implements com.bytedance.frameworks.baselib.network.http.cronet.impl.h.a, com.bytedance.frameworks.baselib.network.http.cronet.impl.h.b, com.bytedance.frameworks.baselib.network.http.f.j, com.bytedance.frameworks.core.encrypt.a.InterfaceC0132a, com.bytedance.ttnet.c.b {
    private static volatile h g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f3252a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f3253b;
    private int c;
    private int d;
    private int e;
    private int f;

    private h() {
        b();
    }

    public static h a() {
        if (g != null) goto L15;
        monitor-enter(h.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (g != null) goto L9;
        g = new h();     // Catch: Throwable -> L11
    L9:
        monitor-exit(h.class);     // Catch: Throwable -> L11
    L15:
        return g;
    }

    public void b() {
        TTNetInit.getTTNetDepend();     // Catch: Throwable -> L27
        Logger.w("SyncMainProcessConfig", "Sync main process config in current process.");
        this.f3252a = TTNetInit.getTTNetDepend().a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(TTNetInit.getTTNetDepend().getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "share_cookie_host_list", "");
        TTNetInit.getTTNetDepend().a(this.f3252a);
        boolean r5 = false;
        this.f3253b = TTNetInit.getTTNetDepend().a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(TTNetInit.getTTNetDepend().getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "add_ss_queries_open", 0);
        int r0 = TTNetInit.getTTNetDepend().a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(TTNetInit.getTTNetDepend().getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "add_ss_queries_header_open", 0);
        this.c = r0;
        if (this.f3253b > 0) goto L6;
        if (r0 > 0) goto L6;
    L7:
        this.d = TTNetInit.getTTNetDepend().a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(TTNetInit.getTTNetDepend().getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "add_ss_queries_plaintext_open", 1);
        this.e = TTNetInit.getTTNetDepend().a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(TTNetInit.getTTNetDepend().getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "http_dns_enabled", 0);
        this.f = TTNetInit.getTTNetDepend().a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(TTNetInit.getTTNetDepend().getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "chromium_boot_failures", 0);
        int r9 = TTNetInit.getTTNetDepend().a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(TTNetInit.getTTNetDepend().getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "query_filter_enabled", Integer.MIN_VALUE);
        String r1 = TTNetInit.getTTNetDepend().a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(TTNetInit.getTTNetDepend().getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "query_filter_actions", "");
        com.bytedance.frameworks.baselib.network.c.d.a().b(TTNetInit.getTTNetDepend().a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(TTNetInit.getTTNetDepend().getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "L0_params", ""));
        if (r9 == Integer.MIN_VALUE) goto L15;
        com.bytedance.frameworks.baselib.network.c.d r2 = com.bytedance.frameworks.baselib.network.c.d.a();
        if (r9 <= 0) goto L12;
        boolean r10 = true;
    L13:
        r2.a(r10);
        com.bytedance.frameworks.baselib.network.c.d.a().a(r1);
        goto L15
    L12:
        r10 = false;
    L15:
        if (TTNetInit.getTTNetDepend().a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(TTNetInit.getTTNetDepend().getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "private_protocol_enabled", 1) < 1) goto L17;
        boolean r11 = true;
    L18:
        com.bytedance.frameworks.baselib.network.http.f.e(r11);
        if (TTNetInit.getTTNetDepend().a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(TTNetInit.getTTNetDepend().getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "disable_rotating_host_path_retry", -1) < 1) goto L21;
        boolean r12 = true;
    L22:
        com.bytedance.frameworks.baselib.network.http.f.d(r12);
        if (TTNetInit.getTTNetDepend().a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(TTNetInit.getTTNetDepend().getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "pp_force_use_shared_stream", 0) < 1) goto L25;
        r5 = true;
    L25:
        com.bytedance.frameworks.baselib.network.http.f.f(r5);
        return;
    L21:
        r12 = false;
        goto L22
    L17:
        r11 = false;
    L6:
        com.bytedance.ttnet.retrofit.b.a(true);
    }

    @Override // com.bytedance.frameworks.baselib.network.http.f.j
    public List<String> getShareCookie(CookieManager r9, com.bytedance.frameworks.baselib.network.http.impl.b r10, URI r11) {
        if (r11 == null) goto L45;
        if (r9 != null) goto L7;
        if (r10 == null) goto L45;
    L7:
        String r1 = TTNetInit.getTTNetDepend().e();
        if (com.bytedance.common.utility.h.a(r1) == false) goto L47;
        return null;
    L47:
        String r2 = r11.getHost();     // Catch: Exception -> L12
    L13:
        ArrayList r3 = new ArrayList();
        if (com.bytedance.common.utility.h.a(this.f3252a) == false) goto L51;
    L17:
        String[] r8 = null;
    L18:
        if (r8 == null) goto L26;
        int r4 = r8.length;
        int r5 = 0;
    L20:
        if (r5 >= r4) goto L26;
        String r6 = r8[r5];
        if (com.bytedance.common.utility.h.a(r6) == true) goto L24;
        r3.add(r6);
    L24:
        r5 = r5 + 1;
    L26:
        if (com.bytedance.common.utility.h.a(r2) == true) goto L45;
        if (com.bytedance.ttnet.utils.d.a(r2, r3) == false) goto L45;
        ArrayList r12 = new ArrayList();
        if (r9 == null) goto L36;
        String r13 = r9.getCookie(r1);
        if (com.bytedance.common.utility.h.a(r13) == true) goto L36;
        r12.add(r13);
    L36:
        if (com.bytedance.common.utility.d.a(r12) == false) goto L44;
        if (r10 == null) goto L44;
        String r14 = r10.a(URI.create(r11.getScheme() + "://" + r1));     // Catch: Throwable -> L42
        if (com.bytedance.common.utility.h.a(r14) == true) goto L44;
        r12.add(r14);     // Catch: Throwable -> L42
        r12.add("x-tt-cookie-backup-source=1");     // Catch: Throwable -> L42
    L42:
        th = move-exception;
        th.printStackTrace();
    L44:
        return r12;
    L51:
        r8 = this.f3252a.split(",");     // Catch: Throwable -> L46
    L12:
        r2 = null;
    L45:
        return null;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.f.j
    public List<String> getShareCookieHostList(String r7) {
        ArrayList r0 = new ArrayList();
        if (com.bytedance.common.utility.h.a(this.f3252a) == false) goto L24;
    L6:
        String[] r6 = null;
    L7:
        if (r6 == null) goto L14;
        int r1 = r6.length;
        int r3 = 0;
    L9:
        if (r3 >= r1) goto L14;
        String r4 = r6[r3];
        if (com.bytedance.common.utility.h.a(r4) == true) goto L13;
        r0.add(r4);
    L13:
        r3 = r3 + 1;
    L14:
        String r8 = TTNetInit.getTTNetDepend().e();
        if (com.bytedance.common.utility.h.a(r8) == true) goto L20;
        if (com.bytedance.ttnet.utils.d.a(r8, r0) == true) goto L20;
        r0.add(r8);
    L20:
        if (com.bytedance.ttnet.utils.d.a(r7, r0) == false) goto L22;
        return r0;
    L22:
        return null;
    L24:
        r6 = this.f3252a.split(",");     // Catch: Throwable -> L23
        goto L7
    }

    @Override // com.bytedance.ttnet.c.b
    public boolean isChromiumOpen() {
        if (AppConfig.sForceNotUseCronet == false) goto L7;
        o.a(0);
        return false;
    L7:
        if (AppConfig.sCronetUnsupportedModel == false) goto L11;
        o.a(8);
        return false;
    L11:
        if (AppConfig.isCronetUnsupportedABI() == false) goto L14;
        return false;
    L14:
        if (AppConfig.sDisableFallbackReasonBoot == true) goto L20;
        if (this.f <= 5) goto L20;
        o.a(3);
        Logger.e("SyncMainProcessConfig", "After five consecutive crashes of cronet on subprocess, you must reinstall app to enable cronet, or wait until several hours");
        return false;
    L20:
        if (TTNetInit.getTTNetDepend().a() == true) goto L23;
        o.a(6);
        return false;
    L23:
        return true;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.impl.h.a
    public boolean isCronetBootFailureExpected() {
        if (AppConfig.sDisableFallbackReasonBoot == false) goto L6;
        return true;
    L6:
        if (TTNetInit.getTTNetDepend().a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(TTNetInit.getTTNetDepend().getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "chromium_boot_failures", 0) > 5) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.impl.h.b
    public boolean isCronetHttpDnsOpen() {
        if (AppConfig.sForceNotUseCronet == false) goto L6;
        return false;
    L6:
        if (this.e <= 0) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // com.bytedance.frameworks.core.encrypt.a.InterfaceC0132a
    public boolean isSsQueriesHeaderOpen() {
        if (this.c <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.frameworks.core.encrypt.a.InterfaceC0132a
    public boolean isSsQueriesOpen() {
        if (this.f3253b <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.frameworks.core.encrypt.a.InterfaceC0132a
    public boolean isSsQueriesPlaintextOpen() {
        if (this.d <= 0) goto L5;
        return true;
    L5:
        return false;
    }
}
