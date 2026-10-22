package com.obric.aiagent.assistant.idl;

import android.os.IBinder;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.aiagent.ipc.utils.IPCAnomalyTrace;
import com.obric.aiagent.ipc.utils.IPCException;
import com.obric.aiagent.ipc.utils.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
class ImageXUploadCallbackIDLIpcWrapper implements IImageXUploadCallbackIDL {
    boolean log;
    final IImageXUploadCallbackIDL origin;

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.origin.asBinder();
    }

    public ImageXUploadCallbackIDLIpcWrapper(IImageXUploadCallbackIDL r2) throws RemoteException {
        this(r2, true);
    }

    public ImageXUploadCallbackIDLIpcWrapper(IImageXUploadCallbackIDL r1, boolean r2) throws RemoteException {
        this.origin = r1;
        this.log = r2;
    }

    @Override // com.obric.aiagent.assistant.idl.IImageXUploadCallbackIDL
    public void onResult(boolean r30, String r31, String r32, String r33, String r34) throws RemoteException {
        long r16 = SystemClock.elapsedRealtimeNanos();
    L26:
        e = e;
        String r4 = "onResult(";
        String r20 = ")";
        long r6 = 0;
        String r5 = r34;
    L28:
        int r2 = h.a;     // Catch: Throwable -> L30
        h.b("IImageXUploadCallbackIDLIPC", r4 + r30 + ", " + r31 + ", " + r32 + ", " + r33 + ", " + r5 + r20, e);     // Catch: Throwable -> L30
        IPCException r3 = new IPCException(e);     // Catch: Throwable -> L30
        long r25 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L30
        long r7 = Math.max(r6, r25 - r16) / 1000;     // Catch: Throwable -> L30
        int r0 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Throwable -> L30
        com.obric.aiagent.ipc.utils.i.a("IImageXUploadCallbackIDLIPC", r4 + r30 + ", " + r31 + ", " + r32 + ", " + r33 + ", " + r5 + ") = fail", r3, r7);     // Catch: Throwable -> L30
        IPCAnomalyTrace r1 = IPCAnomalyTrace.a;     // Catch: Throwable -> L30
        IPCAnomalyTrace.b("IImageXUploadCallbackIDLIPC", "onResult", r3, r7, r25);     // Catch: Throwable -> L30
        return;
    L4:
        if (this.log == false) goto L7;
        int r8 = h.a;     // Catch: Exception -> L26 Throwable -> L30
        h.a("IImageXUploadCallbackIDLIPC", "onResult(" + r30 + ", " + r31 + ", " + r32 + ", " + r33 + ", " + r34 + ")");     // Catch: Exception -> L26 Throwable -> L30
    L7:
        if (this.log == false) goto L9;
        int r9 = h.a;     // Catch: Exception -> L26 Throwable -> L30
        h.a("IImageXUploadCallbackIDLIPC", "onResult(" + r30 + ", " + r31 + ", " + r32 + ", " + r33 + ", " + r34 + ")");     // Catch: Exception -> L26 Throwable -> L30
    L9:
        r20 = ")";
        this.origin.onResult(r30, r31, r32, r33, r34);     // Catch: Exception -> L24 Throwable -> L30
        if (this.log == false) goto L14;
        h.d("IImageXUploadCallbackIDLIPC", "onResult = void");     // Catch: Exception -> L24 Throwable -> L30
    L14:
        long r27 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L24 Throwable -> L30
        long r10 = Math.max(0, r27 - r16) / 1000;     // Catch: Exception -> L24 Throwable -> L30
        int r11 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L24 Throwable -> L30
        r4 = "onResult(";
        StringBuilder r12 = new StringBuilder(r4);     // Catch: Exception -> L22 Throwable -> L30
        r12.append(r30);     // Catch: Exception -> L22 Throwable -> L30
        r12.append(", ");     // Catch: Exception -> L22 Throwable -> L30
        r12.append(r31);     // Catch: Exception -> L22 Throwable -> L30
        r12.append(", ");     // Catch: Exception -> L22 Throwable -> L30
        r12.append(r32);     // Catch: Exception -> L22 Throwable -> L30
        r12.append(", ");     // Catch: Exception -> L22 Throwable -> L30
        r12.append(r33);     // Catch: Exception -> L22 Throwable -> L30
        r12.append(", ");     // Catch: Exception -> L22 Throwable -> L30
        r5 = r34;
        r6 = 0;
        r12.append(r5);     // Catch: Exception -> L20 Throwable -> L30
        r12.append(") = void");     // Catch: Exception -> L20 Throwable -> L30
        com.obric.aiagent.ipc.utils.i.b("IImageXUploadCallbackIDLIPC", r12.toString(), r10);     // Catch: Exception -> L20 Throwable -> L30
        IPCAnomalyTrace.a.c("IImageXUploadCallbackIDLIPC", "onResult", r10, r27);     // Catch: Exception -> L20 Throwable -> L30
        return;
    L20:
        e = e;
    L22:
        e = e;
        r5 = r34;
        r6 = 0;
    L24:
        e = e;
        r5 = r34;
        r6 = 0;
        r4 = "onResult(";
        goto L28
    }
}
