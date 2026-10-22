package org.chromium.mpa;

import com.bytedance.common.utility.reflect.Reflect;
import com.bytedance.ttnet.TTNetInit;
import com.ttnet.org.chromium.net.CronetEngine;
import com.ttnet.org.chromium.net.TTMpaService;
import java.util.List;
import org.chromium.CronetClient;
import s2.a;

/* JADX INFO: loaded from: classes3.dex */
public class CronetMpaServiceImpl {
    private static final String PRE_CNIT_KETNEL_FUNC = "preInitCronetKernel";
    private static final String TTNET_INIT_CLASS = "com.bytedance.ttnet.TTNetInit";
    private TTMpaService.ICallback mCronetAccAddressCallback;
    private CronetEngine mCronetEngine;
    private TTMpaService.ICallback mCronetInitCallback;
    private a mOuterAccAddressCallback;
    private a mOuterInitCallback;
    private TTMpaService mTTNetMpaService;

    public CronetMpaServiceImpl() {
        this.mCronetInitCallback = new AnonymousClass1(this);
        this.mCronetAccAddressCallback = new AnonymousClass2(this);
    }

    static /* synthetic */ a access$000(CronetMpaServiceImpl r10) {
        return r10.mOuterInitCallback;
    }

    static /* synthetic */ a access$100(CronetMpaServiceImpl r10) {
        return r10.mOuterAccAddressCallback;
    }

    static /* synthetic */ a access$102(CronetMpaServiceImpl r10, a r11) {
        r10.mOuterAccAddressCallback = r11;
        return r11;
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
        String r10 = TTNetInit.DOMAIN_HTTPDNS_KEY;     // Catch: Throwable -> L8
        Reflect.on(TTNetInit.class.newInstance()).call(PRE_CNIT_KETNEL_FUNC);     // Catch: Throwable -> L8
        CronetEngine r11 = CronetClient.getCronetEngine();     // Catch: Throwable -> L8
        this.mCronetEngine = r11;     // Catch: Throwable -> L8
        if (r11 == null) goto L14;
        return true;
    L14:
        return false;
    L8:
        th = move-exception;
        th.printStackTrace();
        return false;
    }

    public void command(String r10, String r11) {
        TTMpaService r12 = this.mTTNetMpaService;
        if (r12 == null) goto L6;
        r12.command(r10, r11);
        return;
    }

    public void init(a r10) {
        if (createMpaService() == true) goto L6;
        r10.onFinish(false, "Create MpaService Failed");
        return;
    L6:
        this.mOuterInitCallback = r10;
        this.mTTNetMpaService.init(this.mCronetInitCallback);
    }

    public void setAccAddress(List<String> r10, a r11) {
        if (this.mTTNetMpaService != null) goto L5;
        if (r11 == null) goto L23;
        r11.onFinish(false, "TTNetMpaService is null");
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
        if (r11 == null) goto L10;
        r11.onFinish(false, "setAccAddress is running");     // Catch: Throwable -> L15
    L10:
        monitor-exit(CronetMpaServiceImpl.class);     // Catch: Throwable -> L15
        return;
    L12:
        this.mOuterAccAddressCallback = r11;     // Catch: Throwable -> L15
        monitor-exit(CronetMpaServiceImpl.class);     // Catch: Throwable -> L15
        this.mTTNetMpaService.setAccAddress(r10, this.mCronetAccAddressCallback);
    }

    public void start() {
        TTMpaService r10 = this.mTTNetMpaService;
        if (r10 == null) goto L6;
        r10.start();
        return;
    }

    public void stop() {
        TTMpaService r10 = this.mTTNetMpaService;
        if (r10 == null) goto L6;
        r10.stop();
        return;
    }
}
