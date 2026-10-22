package com.obric.aiagent.assistant.idl;

import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.aiagent.ipc.utils.IPCAnomalyTrace;
import com.obric.aiagent.ipc.utils.IPCException;
import com.obric.aiagent.ipc.utils.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
class ImageXUploadCallbackIDLStubWrapper extends IImageXUploadCallbackIDL.Stub {
    boolean log;
    final IImageXUploadCallbackIDL.Stub origin;

    public ImageXUploadCallbackIDLStubWrapper(IImageXUploadCallbackIDL.Stub r2) throws RemoteException {
        this(r2, true);
    }

    public ImageXUploadCallbackIDLStubWrapper(IImageXUploadCallbackIDL.Stub r1, boolean r2) throws RemoteException {
        this.origin = r1;
        this.log = r2;
    }

    @Override // com.obric.aiagent.assistant.idl.IImageXUploadCallbackIDL
    public void onResult(boolean r30, String r31, String r32, String r33, String r34) throws RemoteException {
        long r16 = SystemClock.elapsedRealtimeNanos();
    L23:
        e = e;
        String r4 = "onResult(";
        String r20 = ")";
        long r6 = 0;
        String r5 = r34;
    L25:
        int r2 = h.a;
        h.b("ImageXUploadCallbackIDLStub", r4 + r30 + ", " + r31 + ", " + r32 + ", " + r33 + ", " + r5 + r20, e);
        IPCException r3 = new IPCException(e);
        long r25 = SystemClock.elapsedRealtimeNanos();
        long r7 = Math.max(r6, r25 - r16) / 1000;
        int r0 = com.obric.aiagent.ipc.utils.i.a;
        com.obric.aiagent.ipc.utils.i.c("ImageXUploadCallbackIDLStub", r4 + r30 + ", " + r31 + ", " + r32 + ", " + r33 + ", " + r5 + ") = fail", r3, r7);
        IPCAnomalyTrace r1 = IPCAnomalyTrace.a;
        IPCAnomalyTrace.d("ImageXUploadCallbackIDLStub", "onResult", r3, r7, r25);
        throw r3;
    L4:
        if (this.log == false) goto L6;
        int r8 = h.a;     // Catch: Exception -> L23
        h.c("ImageXUploadCallbackIDLStub", "onResult(" + r30 + ", " + r31 + ", " + r32 + ", " + r33 + ", " + r34 + ")");     // Catch: Exception -> L23
    L6:
        r20 = ")";
        this.origin.onResult(r30, r31, r32, r33, r34);     // Catch: Exception -> L21
        if (this.log == false) goto L11;
        h.d("ImageXUploadCallbackIDLStub", "onResult = void");     // Catch: Exception -> L21
    L11:
        long r27 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L21
        long r9 = Math.max(0, r27 - r16) / 1000;     // Catch: Exception -> L21
        int r10 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L21
        r4 = "onResult(";
        StringBuilder r11 = new StringBuilder(r4);     // Catch: Exception -> L19
        r11.append(r30);     // Catch: Exception -> L19
        r11.append(", ");     // Catch: Exception -> L19
        r11.append(r31);     // Catch: Exception -> L19
        r11.append(", ");     // Catch: Exception -> L19
        r11.append(r32);     // Catch: Exception -> L19
        r11.append(", ");     // Catch: Exception -> L19
        r11.append(r33);     // Catch: Exception -> L19
        r11.append(", ");     // Catch: Exception -> L19
        r5 = r34;
        r6 = 0;
        r11.append(r5);     // Catch: Exception -> L17
        r11.append(") = void");     // Catch: Exception -> L17
        com.obric.aiagent.ipc.utils.i.d("ImageXUploadCallbackIDLStub", r11.toString(), r9);     // Catch: Exception -> L17
        IPCAnomalyTrace.a.e("ImageXUploadCallbackIDLStub", "onResult", r9, r27);     // Catch: Exception -> L17
        return;
    L17:
        e = e;
    L19:
        e = e;
        r5 = r34;
        r6 = 0;
    L21:
        e = e;
        r5 = r34;
        r6 = 0;
        r4 = "onResult(";
        goto L25
    }
}
