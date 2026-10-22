package pi0;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livehostapi.business.depend.xplay.IByteRtcVideoFrame;
import com.bytedance.bmmt.BuildConfig;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c implements Runnable {
    public final /* synthetic */ IByteRtcVideoFrame a;

    public c(IByteRtcVideoFrame r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.release();     // Catch: Throwable -> L4
        ALogger.d("textureToLiveCoreVideoFame", BuildConfig.BUILD_TYPE);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
