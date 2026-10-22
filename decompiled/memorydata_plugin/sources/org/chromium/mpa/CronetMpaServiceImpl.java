package org.chromium.mpa;

import com.bytedance.common.utility.reflect.Reflect;
import com.bytedance.frameworks.baselib.network.http.cronet.b.a;
import com.ttnet.org.chromium.net.CronetEngine;
import com.ttnet.org.chromium.net.TTMpaService;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import org.chromium.CronetClient;

/* JADX INFO: loaded from: classes7.dex */
public class CronetMpaServiceImpl implements a {
    private static final String PRE_CNIT_KETNEL_FUNC = "preInitCronetKernel";
    private static final String TTNET_INIT_CLASS = "com.bytedance.ttnet.TTNetInit";
    private TTMpaService.ICallback mCronetAccAddressCallback;
    private CronetEngine mCronetEngine;
    private TTMpaService.ICallback mCronetInitCallback;
    private a.InterfaceC0127a mOuterAccAddressCallback;
    private a.InterfaceC0127a mOuterInitCallback;
    private TTMpaService mTTNetMpaService;

    public CronetMpaServiceImpl() {
        this.mCronetInitCallback = new AnonymousClass1(this);
        this.mCronetAccAddressCallback = new AnonymousClass2(this);
    }

    static /* synthetic */ a.InterfaceC0127a access$000(CronetMpaServiceImpl r0) {
        return r0.mOuterInitCallback;
    }

    static /* synthetic */ a.InterfaceC0127a access$100(CronetMpaServiceImpl r0) {
        return r0.mOuterAccAddressCallback;
    }

    static /* synthetic */ a.InterfaceC0127a access$102(CronetMpaServiceImpl r2, a.InterfaceC0127a r3) {
        a.InterfaceC0127a r4 = (a.InterfaceC0127a) ZeusTransformUtils.wrapperContextForParams(r3, a.InterfaceC0127a.class, "com.obric.memorydata.plugin");
        r2.mOuterAccAddressCallback = r4;
        return r4;
    }

    private boolean createMpaService() {
        if (loadCronetKernel() == true) goto L7;
        return false;
    L7:
        if (this.mTTNetMpaService != null) goto L11;
        this.mTTNetMpaService = this.mCronetEngine.createTTMpaService();
        return true;
    L11:
        return true;
    }

    private boolean loadCronetKernel() {
        if (this.mCronetEngine == null) goto L12;
        return true;
    L12:
        Reflect.on(ZeusTransformUtils.forName(TTNET_INIT_CLASS, "com.obric.memorydata.plugin").newInstance()).call(PRE_CNIT_KETNEL_FUNC);     // Catch: Throwable -> L8
        CronetEngine r0 = CronetClient.getCronetEngine();     // Catch: Throwable -> L8
        this.mCronetEngine = r0;     // Catch: Throwable -> L8
        if (r0 == null) goto L14;
        return true;
    L14:
        return false;
    L8:
        th = move-exception;
        th.printStackTrace();
        return false;
    }

    public void command(String r1, String r2) {
        TTMpaService r0 = this.mTTNetMpaService;
        if (r0 == null) goto L6;
        r0.command(r1, r2);
        return;
    }

    public void init(a.InterfaceC0127a r3) {
        a.InterfaceC0127a r4 = (a.InterfaceC0127a) ZeusTransformUtils.wrapperContextForParams(r3, a.InterfaceC0127a.class, "com.obric.memorydata.plugin");
        if (createMpaService() == true) goto L6;
        r4.a(false, "Create MpaService Failed");
        return;
    L6:
        this.mOuterInitCallback = r4;
        this.mTTNetMpaService.init(this.mCronetInitCallback);
    }

    public void setAccAddress(List<String> r4, a.InterfaceC0127a r5) {
        List<String> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        a.InterfaceC0127a r7 = (a.InterfaceC0127a) ZeusTransformUtils.wrapperContextForParams(r5, a.InterfaceC0127a.class, "com.obric.memorydata.plugin");
        if (this.mTTNetMpaService != null) goto L5;
        if (r7 == null) goto L23;
        r7.a(false, "TTNetMpaService is null");
        return;
    L23:
        return;
    L5:
        monitor-enter(CronetMpaServiceImpl.class);
    L15:
        th = move-exception;
        throw th;
    L7:
        if (this.mOuterAccAddressCallback == null) goto L12;
        if (r7 == null) goto L10;
        r7.a(false, "setAccAddress is running");     // Catch: Throwable -> L15
    L10:
        monitor-exit(CronetMpaServiceImpl.class);     // Catch: Throwable -> L15
        return;
    L12:
        this.mOuterAccAddressCallback = r7;     // Catch: Throwable -> L15
        monitor-exit(CronetMpaServiceImpl.class);     // Catch: Throwable -> L15
        this.mTTNetMpaService.setAccAddress(r6, this.mCronetAccAddressCallback);
    }

    public void start() {
        TTMpaService r0 = this.mTTNetMpaService;
        if (r0 == null) goto L6;
        r0.start();
        return;
    }

    public void stop() {
        TTMpaService r0 = this.mTTNetMpaService;
        if (r0 == null) goto L6;
        r0.stop();
        return;
    }
}
