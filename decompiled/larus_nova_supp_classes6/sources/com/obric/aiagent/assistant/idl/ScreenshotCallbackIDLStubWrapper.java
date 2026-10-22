package com.obric.aiagent.assistant.idl;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.aiagent.ipc.utils.IPCAnomalyTrace;
import com.obric.aiagent.ipc.utils.IPCException;
import com.obric.aiagent.ipc.utils.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
class ScreenshotCallbackIDLStubWrapper extends IScreenshotCallbackIDL.Stub {
    boolean log;
    final IScreenshotCallbackIDL.Stub origin;

    public ScreenshotCallbackIDLStubWrapper(IScreenshotCallbackIDL.Stub r2) throws RemoteException {
        this(r2, true);
    }

    @Override // com.obric.aiagent.assistant.idl.IScreenshotCallbackIDL
    public void onError(String r20) throws RemoteException {
        long r6 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        int r12 = h.a;
        h.b("ScreenshotCallbackIDLStub", "onError(" + r20 + ")", e);
        IPCException r3 = new IPCException(e);
        long r17 = SystemClock.elapsedRealtimeNanos();
        long r7 = Math.max(0, r17 - r6) / 1000;
        int r0 = com.obric.aiagent.ipc.utils.i.a;
        com.obric.aiagent.ipc.utils.i.c("ScreenshotCallbackIDLStub", "onError(" + r20 + ") = fail", r3, r7);
        IPCAnomalyTrace r1 = IPCAnomalyTrace.a;
        IPCAnomalyTrace.d("ScreenshotCallbackIDLStub", "onError", r3, r7, r17);
        throw r3;
    L4:
        if (this.log == false) goto L6;
        int r2 = h.a;     // Catch: Exception -> L11
        h.c("ScreenshotCallbackIDLStub", "onError(" + r20 + ")");     // Catch: Exception -> L11
    L6:
        this.origin.onError(r20);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        h.d("ScreenshotCallbackIDLStub", "onError = void");     // Catch: Exception -> L11
    L9:
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r18 - r6) / 1000;     // Catch: Exception -> L11
        int r4 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("ScreenshotCallbackIDLStub", "onError(" + r20 + ") = void", r14);     // Catch: Exception -> L11
        IPCAnomalyTrace.a.e("ScreenshotCallbackIDLStub", "onError", r14, r18);     // Catch: Exception -> L11
    }

    @Override // com.obric.aiagent.assistant.idl.IScreenshotCallbackIDL
    public void onReceivedScreenshot(Bitmap r20) throws RemoteException {
        long r6 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        int r12 = h.a;
        h.b("ScreenshotCallbackIDLStub", "onReceivedScreenshot(" + r20 + ")", e);
        IPCException r3 = new IPCException(e);
        long r17 = SystemClock.elapsedRealtimeNanos();
        long r7 = Math.max(0, r17 - r6) / 1000;
        int r0 = com.obric.aiagent.ipc.utils.i.a;
        com.obric.aiagent.ipc.utils.i.c("ScreenshotCallbackIDLStub", "onReceivedScreenshot(" + r20 + ") = fail", r3, r7);
        IPCAnomalyTrace r1 = IPCAnomalyTrace.a;
        IPCAnomalyTrace.d("ScreenshotCallbackIDLStub", "onReceivedScreenshot", r3, r7, r17);
        throw r3;
    L4:
        if (this.log == false) goto L6;
        int r2 = h.a;     // Catch: Exception -> L11
        h.c("ScreenshotCallbackIDLStub", "onReceivedScreenshot(" + r20 + ")");     // Catch: Exception -> L11
    L6:
        this.origin.onReceivedScreenshot(r20);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        h.d("ScreenshotCallbackIDLStub", "onReceivedScreenshot = void");     // Catch: Exception -> L11
    L9:
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r18 - r6) / 1000;     // Catch: Exception -> L11
        int r4 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("ScreenshotCallbackIDLStub", "onReceivedScreenshot(" + r20 + ") = void", r14);     // Catch: Exception -> L11
        IPCAnomalyTrace.a.e("ScreenshotCallbackIDLStub", "onReceivedScreenshot", r14, r18);     // Catch: Exception -> L11
    }

    @Override // com.obric.aiagent.assistant.idl.IScreenshotCallbackIDL
    public void onReceivedScreenshotUri(Uri r20) throws RemoteException {
        long r6 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        int r12 = h.a;
        h.b("ScreenshotCallbackIDLStub", "onReceivedScreenshotUri(" + r20 + ")", e);
        IPCException r3 = new IPCException(e);
        long r17 = SystemClock.elapsedRealtimeNanos();
        long r7 = Math.max(0, r17 - r6) / 1000;
        int r0 = com.obric.aiagent.ipc.utils.i.a;
        com.obric.aiagent.ipc.utils.i.c("ScreenshotCallbackIDLStub", "onReceivedScreenshotUri(" + r20 + ") = fail", r3, r7);
        IPCAnomalyTrace r1 = IPCAnomalyTrace.a;
        IPCAnomalyTrace.d("ScreenshotCallbackIDLStub", "onReceivedScreenshotUri", r3, r7, r17);
        throw r3;
    L4:
        if (this.log == false) goto L6;
        int r2 = h.a;     // Catch: Exception -> L11
        h.c("ScreenshotCallbackIDLStub", "onReceivedScreenshotUri(" + r20 + ")");     // Catch: Exception -> L11
    L6:
        this.origin.onReceivedScreenshotUri(r20);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        h.d("ScreenshotCallbackIDLStub", "onReceivedScreenshotUri = void");     // Catch: Exception -> L11
    L9:
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r18 - r6) / 1000;     // Catch: Exception -> L11
        int r4 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("ScreenshotCallbackIDLStub", "onReceivedScreenshotUri(" + r20 + ") = void", r14);     // Catch: Exception -> L11
        IPCAnomalyTrace.a.e("ScreenshotCallbackIDLStub", "onReceivedScreenshotUri", r14, r18);     // Catch: Exception -> L11
    }

    public ScreenshotCallbackIDLStubWrapper(IScreenshotCallbackIDL.Stub r1, boolean r2) throws RemoteException {
        this.origin = r1;
        this.log = r2;
    }
}
