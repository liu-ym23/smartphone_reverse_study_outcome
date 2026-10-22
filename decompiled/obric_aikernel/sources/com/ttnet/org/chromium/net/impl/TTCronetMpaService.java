package com.ttnet.org.chromium.net.impl;

import com.ttnet.org.chromium.base.annotations.CalledByNative;
import com.ttnet.org.chromium.base.annotations.JNINamespace;
import com.ttnet.org.chromium.base.annotations.NativeClassQualifiedName;
import com.ttnet.org.chromium.net.TTMpaService;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@JNINamespace("cronet")
public final class TTCronetMpaService extends TTMpaService {
    private static final String TAG = "TTCronetMpaService";
    private TTMpaService.ICallback mAccAddressCallback;
    private TTMpaService.ICallback mInitCallback;
    private long mMpaServiceAdapter;
    private final Object mMpaServiceAdapterLock;
    private CronetUrlRequestContext mRequestContext;

    static {
    }

    public TTCronetMpaService(CronetUrlRequestContext r10) {
        this.mMpaServiceAdapterLock = new Object();
        this.mRequestContext = r10;
    }

    static /* synthetic */ TTMpaService.ICallback access$000(TTCronetMpaService r10) {
        return r10.mInitCallback;
    }

    static /* synthetic */ String access$100() {
        return TAG;
    }

    static /* synthetic */ TTMpaService.ICallback access$200(TTCronetMpaService r10) {
        return r10.mAccAddressCallback;
    }

    @NativeClassQualifiedName("TTCronetMpaServiceAdapter")
    private native void nativeCommand(long r10, String r11, String r12);

    private native long nativeCreateMpaServiceAdapter(long r10);

    @NativeClassQualifiedName("TTCronetMpaServiceAdapter")
    private native void nativeInit(long r10);

    @NativeClassQualifiedName("TTCronetMpaServiceAdapter")
    private native void nativeSetAccAddress(long r10, String[] r11);

    @NativeClassQualifiedName("TTCronetMpaServiceAdapter")
    private native void nativeStart(long r10);

    @NativeClassQualifiedName("TTCronetMpaServiceAdapter")
    private native void nativeStop(long r10);

    @CalledByNative
    private void onInitFinish(final boolean r10, final String r11) {
        postToSubThread(new AnonymousClass1(this, r10, r11));
    }

    @CalledByNative
    private void onSetAccAddressFinish(final boolean r10, final String r11) {
        postToSubThread(new AnonymousClass2(this, r10, r11));
    }

    private void postToSubThread(Runnable r10) {
        Thread r11 = new Thread(r10);
        r11.setName("TTCronetMpaService_Thread");
        r11.start();
    }

    @Override // com.ttnet.org.chromium.net.TTMpaService
    public void command(String r10, String r11) {
        Object r12 = this.mMpaServiceAdapterLock;
        monitor-enter(r12);
        long r13 = this.mMpaServiceAdapter;     // Catch: Throwable -> L11
        if (r13 != 0) goto L8;
        monitor-exit(r12);     // Catch: Throwable -> L11
        return;
    L8:
        nativeCommand(r13, r10, r11);     // Catch: Throwable -> L11
        monitor-exit(r12);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.TTMpaService
    public void init(TTMpaService.ICallback r10) {
        Object r11 = this.mMpaServiceAdapterLock;
        monitor-enter(r11);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (this.mMpaServiceAdapter != 0) goto L7;
        this.mMpaServiceAdapter = nativeCreateMpaServiceAdapter(this.mRequestContext.getUrlRequestContextAdapter());     // Catch: Throwable -> L10
    L7:
        this.mInitCallback = r10;     // Catch: Throwable -> L10
        nativeInit(this.mMpaServiceAdapter);     // Catch: Throwable -> L10
        monitor-exit(r11);     // Catch: Throwable -> L10
    }

    @Override // com.ttnet.org.chromium.net.TTMpaService
    public void setAccAddress(List<String> r10, TTMpaService.ICallback r11) {
        Object r12 = this.mMpaServiceAdapterLock;
        monitor-enter(r12);
        long r13 = this.mMpaServiceAdapter;     // Catch: Throwable -> L11
        if (r13 != 0) goto L8;
        monitor-exit(r12);     // Catch: Throwable -> L11
        return;
    L8:
        this.mAccAddressCallback = r11;     // Catch: Throwable -> L11
        nativeSetAccAddress(r13, (String[]) r10.toArray(new String[r10.size()]));     // Catch: Throwable -> L11
        monitor-exit(r12);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.TTMpaService
    public void start() {
        Object r10 = this.mMpaServiceAdapterLock;
        monitor-enter(r10);
        long r11 = this.mMpaServiceAdapter;     // Catch: Throwable -> L11
        if (r11 != 0) goto L8;
        monitor-exit(r10);     // Catch: Throwable -> L11
        return;
    L8:
        nativeStart(r11);     // Catch: Throwable -> L11
        monitor-exit(r10);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.TTMpaService
    public void stop() {
        Object r10 = this.mMpaServiceAdapterLock;
        monitor-enter(r10);
        long r11 = this.mMpaServiceAdapter;     // Catch: Throwable -> L11
        if (r11 != 0) goto L8;
        monitor-exit(r10);     // Catch: Throwable -> L11
        return;
    L8:
        nativeStop(r11);     // Catch: Throwable -> L11
        monitor-exit(r10);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    }
}
