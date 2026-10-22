package com.obric.aiagent.assistant.idl;

import android.os.Bundle;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.aiagent.ipc.utils.IPCAnomalyTrace;
import com.obric.aiagent.ipc.utils.IPCException;
import com.obric.aiagent.ipc.utils.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
class MusicStateListenerIDLStubWrapper extends IMusicStateListenerIDL.Stub {
    boolean log;
    final IMusicStateListenerIDL.Stub origin;

    public MusicStateListenerIDLStubWrapper(IMusicStateListenerIDL.Stub r2) throws RemoteException {
        this(r2, true);
    }

    @Override // com.obric.aiagent.assistant.idl.IMusicStateListenerIDL
    public void onMusicStateChanged(Bundle r20) throws RemoteException {
        long r6 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        int r12 = h.a;
        h.b("MusicStateListenerIDLStub", "onMusicStateChanged(" + r20 + ")", e);
        IPCException r3 = new IPCException(e);
        long r17 = SystemClock.elapsedRealtimeNanos();
        long r7 = Math.max(0, r17 - r6) / 1000;
        int r0 = com.obric.aiagent.ipc.utils.i.a;
        com.obric.aiagent.ipc.utils.i.c("MusicStateListenerIDLStub", "onMusicStateChanged(" + r20 + ") = fail", r3, r7);
        IPCAnomalyTrace r1 = IPCAnomalyTrace.a;
        IPCAnomalyTrace.d("MusicStateListenerIDLStub", "onMusicStateChanged", r3, r7, r17);
        throw r3;
    L4:
        if (this.log == false) goto L6;
        int r2 = h.a;     // Catch: Exception -> L11
        h.c("MusicStateListenerIDLStub", "onMusicStateChanged(" + r20 + ")");     // Catch: Exception -> L11
    L6:
        this.origin.onMusicStateChanged(r20);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        h.d("MusicStateListenerIDLStub", "onMusicStateChanged = void");     // Catch: Exception -> L11
    L9:
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r18 - r6) / 1000;     // Catch: Exception -> L11
        int r4 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("MusicStateListenerIDLStub", "onMusicStateChanged(" + r20 + ") = void", r14);     // Catch: Exception -> L11
        IPCAnomalyTrace.a.e("MusicStateListenerIDLStub", "onMusicStateChanged", r14, r18);     // Catch: Exception -> L11
    }

    public MusicStateListenerIDLStubWrapper(IMusicStateListenerIDL.Stub r1, boolean r2) throws RemoteException {
        this.origin = r1;
        this.log = r2;
    }
}
