package com.bytedance.privacy;

import android.content.Context;
import com.bytedance.privacy.a.a;
import com.bytedance.privacy.a.c;
import com.bytedance.privacy.a.d;
import com.bytedance.privacy.attestation.b;
import com.bytedance.privacy.exception.BdPrivacyException;
import com.bytedance.privacy.pcc.PccManager;
import com.bytedance.privacy.pseudoid.PseudoManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public class PrivacySdk {
    private static volatile boolean initialized = false;

    static {
    }

    public PrivacySdk() {
    }

    private static void checkInitialized() {
        if (initialized == false) goto L6;
        return;
    L6:
        throw new IllegalStateException("Privacy SDK not initialized. Please call PrivacySdk.init(...) during app startup.");
    }

    public static b getIdAttestationManager() {
        checkInitialized();
        return b.a();
    }

    public static PccManager getPccManager(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        checkInitialized();
        return PccManager.getInstance(r3);
    }

    public static PseudoManager getPseudoManager() {
        checkInitialized();
        return PseudoManager.getInstance();
    }

    public static void init(a r2, com.bytedance.privacy.a.b r3) {
        a r4 = (a) ZeusTransformUtils.wrapperContextForParams(r2, a.class, "com.obric.memorydata.plugin");
        com.bytedance.privacy.a.b r5 = (com.bytedance.privacy.a.b) ZeusTransformUtils.wrapperContextForParams(r3, com.bytedance.privacy.a.b.class, "com.obric.memorydata.plugin");
        if (initialized == false) goto L5;
        return;
    L5:
        monitor-enter(PrivacySdk.class);
    L17:
        th = move-exception;
        throw th;
    L7:
        if (initialized == true) goto L15;
        if (r4 == null) goto L14;
        if (r5 == null) goto L12;
        com.bytedance.privacy.pseudoid.a.a.a(r4);     // Catch: Throwable -> L17
        com.bytedance.privacy.c.b.a().a(r5);     // Catch: Throwable -> L17
        initialized = true;     // Catch: Throwable -> L17
        goto L15
    L12:
        throw new BdPrivacyException("IEnvBridge cannot be null");     // Catch: Throwable -> L17
    L14:
        throw new BdPrivacyException("IAccountBridge cannot be null");     // Catch: Throwable -> L17
    L15:
        monitor-exit(PrivacySdk.class);     // Catch: Throwable -> L17
    }

    public static void initEventReporter(c r2) {
        com.bytedance.privacy.e.b.a((c) ZeusTransformUtils.wrapperContextForParams(r2, c.class, "com.obric.memorydata.plugin"));
    }

    public static void initLogger(d r2) {
        com.bytedance.privacy.e.c.a((d) ZeusTransformUtils.wrapperContextForParams(r2, d.class, "com.obric.memorydata.plugin"));
    }

    public static boolean isInitialized() {
        return initialized;
    }
}
