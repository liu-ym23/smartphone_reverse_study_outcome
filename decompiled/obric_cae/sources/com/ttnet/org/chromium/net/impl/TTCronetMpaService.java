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

    public TTCronetMpaService(CronetUrlRequestContext r8) {
        this.mMpaServiceAdapterLock = new Object();
        this.mRequestContext = r8;
    }

    public static /* synthetic */ TTMpaService.ICallback access$000(TTCronetMpaService r8) {
        return r8.mInitCallback;
    }

    public static /* synthetic */ String access$100() {
        return TAG;
    }

    public static /* synthetic */ TTMpaService.ICallback access$200(TTCronetMpaService r8) {
        return r8.mAccAddressCallback;
    }

    @NativeClassQualifiedName("TTCronetMpaServiceAdapter")
    private native void nativeCommand(long r8, String r10, String r11);

    private native long nativeCreateMpaServiceAdapter(long r8);

    @NativeClassQualifiedName("TTCronetMpaServiceAdapter")
    private native void nativeInit(long r8);

    @NativeClassQualifiedName("TTCronetMpaServiceAdapter")
    private native void nativeSetAccAddress(long r8, String[] r10);

    @NativeClassQualifiedName("TTCronetMpaServiceAdapter")
    private native void nativeStart(long r8);

    @NativeClassQualifiedName("TTCronetMpaServiceAdapter")
    private native void nativeStop(long r8);

    @CalledByNative
    private void onInitFinish(final boolean r8, final String r10) {
        postToSubThread(new AnonymousClass1(this, r8, r10));
    }

    @CalledByNative
    private void onSetAccAddressFinish(final boolean r8, final String r10) {
        postToSubThread(new AnonymousClass2(this, r8, r10));
    }

    private void postToSubThread(Runnable r8) {
        Thread r10 = new Thread(r8);
        r10.setName("TTCronetMpaService_Thread");
        r10.start();
    }

    @Override // com.ttnet.org.chromium.net.TTMpaService
    public void command(String r8, String r10) {
        Object r11 = this.mMpaServiceAdapterLock;
        monitor-enter(r11);
        long r12 = this.mMpaServiceAdapter;     // Catch: Throwable -> L11
        if (r12 != 0) goto L8;
        monitor-exit(r11);     // Catch: Throwable -> L11
        return;
    L8:
        nativeCommand(r12, r8, r10);     // Catch: Throwable -> L11
        monitor-exit(r11);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.TTMpaService
    public void init(TTMpaService.ICallback r8) {
        Object r10 = this.mMpaServiceAdapterLock;
        monitor-enter(r10);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (this.mMpaServiceAdapter != 0) goto L7;
        this.mMpaServiceAdapter = nativeCreateMpaServiceAdapter(this.mRequestContext.getUrlRequestContextAdapter());     // Catch: Throwable -> L10
    L7:
        this.mInitCallback = r8;     // Catch: Throwable -> L10
        nativeInit(this.mMpaServiceAdapter);     // Catch: Throwable -> L10
        monitor-exit(r10);     // Catch: Throwable -> L10
    }

    @Override // com.ttnet.org.chromium.net.TTMpaService
    public void setAccAddress(List<String> r8, TTMpaService.ICallback r10) {
        Object r11 = this.mMpaServiceAdapterLock;
        monitor-enter(r11);
        long r12 = this.mMpaServiceAdapter;     // Catch: Throwable -> L11
        if (r12 != 0) goto L8;
        monitor-exit(r11);     // Catch: Throwable -> L11
        return;
    L8:
        this.mAccAddressCallback = r10;     // Catch: Throwable -> L11
        nativeSetAccAddress(r12, (String[]) r8.toArray(new String[r8.size()]));     // Catch: Throwable -> L11
        monitor-exit(r11);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.TTMpaService
    public void start() {
        Object r8 = this.mMpaServiceAdapterLock;
        monitor-enter(r8);
        long r10 = this.mMpaServiceAdapter;     // Catch: Throwable -> L11
        if (r10 != 0) goto L8;
        monitor-exit(r8);     // Catch: Throwable -> L11
        return;
    L8:
        nativeStart(r10);     // Catch: Throwable -> L11
        monitor-exit(r8);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.TTMpaService
    public void stop() {
        Object r8 = this.mMpaServiceAdapterLock;
        monitor-enter(r8);
        long r10 = this.mMpaServiceAdapter;     // Catch: Throwable -> L11
        if (r10 != 0) goto L8;
        monitor-exit(r8);     // Catch: Throwable -> L11
        return;
    L8:
        nativeStop(r10);     // Catch: Throwable -> L11
        monitor-exit(r8);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    }
}
