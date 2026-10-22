package com.obric.cae;

import android.os.Handler;
import android.os.Message;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class d implements Handler.Callback {
    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message r8) {
        return CaeReceiver.a(r8);
    }
}
