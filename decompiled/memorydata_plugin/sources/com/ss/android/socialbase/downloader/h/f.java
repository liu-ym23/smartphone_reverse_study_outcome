package com.ss.android.socialbase.downloader.h;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes6.dex */
public class f extends Handler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final WeakReference<a> f15458a;

    public interface a {
        void a(Message r1);
    }

    public f(Looper r3, a r4) {
        a r5 = (a) ZeusTransformUtils.wrapperContextForParams(r4, a.class, "com.obric.memorydata.plugin");
        super(r3);
        this.f15458a = new WeakReference(r5);
    }

    @Override // android.os.Handler
    public void handleMessage(Message r3) {
        a r2 = (a) ZeusTransformUtils.preCheckCast(this.f15458a.get(), a.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L7;
        if (r3 == null) goto L8;
        r2.a(r3);
        return;
    L8:
        return;
    }
}
