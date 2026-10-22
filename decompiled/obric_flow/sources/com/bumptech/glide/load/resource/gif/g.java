package com.bumptech.glide.load.resource.gif;

import android.os.Handler;
import android.os.Message;

/* JADX INFO: loaded from: classes.dex */
public final class g implements Handler.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ GifFrameLoader f1658a;

    public g(GifFrameLoader r5) {
        this.f1658a = r5;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message r5) {
        int r10 = r5.what;
        GifFrameLoader r11 = this.f1658a;
        if (r10 != 1) goto L7;
        r11.onFrameReady((e) r5.obj);
        return true;
    L7:
        if (r10 != 2) goto L11;
        e r12 = (e) r5.obj;
        r11.requestManager.j(r12);
        return false;
    L11:
        return false;
    }
}
