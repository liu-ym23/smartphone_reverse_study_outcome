package com.bytedance.lego.init;

import ai.j0;
import android.os.MessageQueue;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public final class h implements MessageQueue.IdleHandler {
    @Override // android.os.MessageQueue.IdleHandler
    public final boolean queueIdle() {
        IdleTaskConfig r5 = i.f6734a;
        if (i.g == true) goto L5;
        return true;
    L5:
        ArrayList r10 = i.f6735b;
        final kf.c r11 = null;
        if (Math.min(r10.size(), i.f6734a.getUiThreadTaskNum()) > 0) goto L17;
        ArrayList r12 = i.f6736c;
        int r13 = Math.min(r12.size(), i.f6734a.getNonUIThreadTaskNum());
        int r14 = 0;
    L8:
        if (r14 >= r13) goto L10;
        j0.A(r12.remove(0));
        mh.e.t(new IdleTaskDispatcher$peekNonUITaskExecute$1(r11));
        r14 = r14 + 1;
        goto L8
    L10:
        IdleTaskConfig r15 = i.f6734a;
        if (i.f6736c.isEmpty() == true) goto L13;
        return true;
    L13:
        if (i.f6735b.isEmpty() == true) goto L16;
        return true;
    L16:
        return false;
    L17:
        j0.A(r10.remove(0));
        throw null;
    }
}
