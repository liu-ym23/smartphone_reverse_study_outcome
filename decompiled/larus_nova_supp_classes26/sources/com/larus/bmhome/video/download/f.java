package com.larus.bmhome.video.download;

import com.larus.platform.service.watermark.WatermarkPerfLogger;
import com.larus.utils.logger.FLogger;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function4;
import kotlinx.coroutines.CoroutineExceptionHandler;
import nr9.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class f extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {
    public final /* synthetic */ String a;
    public final /* synthetic */ WatermarkPerfLogger.a b;
    public final /* synthetic */ Function4 c;
    public final /* synthetic */ VideoDownloadLoadingMgr d;
    public final /* synthetic */ g e;

    public final void handleException(CoroutineContext r4, Throwable r5) {
        FLogger.a.e("saveVideoAndLoadingInternal Error", "execute err! msg=" + r5 + " with downloadTaskKey " + this.a);
        WatermarkPerfLogger.a r6 = this.b;
        if (r6 == null) goto L5;
        r6.b(WatermarkPerfLogger.Result.FAIL, r5.getClass().getSimpleName());
    L5:
        Function4 r7 = this.c;
        if (r7 == null) goto L8;
        r7.invoke(Integer.valueOf(this.d.g), "", 0L, null);
    L8:
        this.d.l.invoke(this.e);
    }

    public f(CoroutineExceptionHandler.Key r1, String r2, WatermarkPerfLogger.a r3, Function4 r4, VideoDownloadLoadingMgr r5, g r6) {
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        super(r1);
    }
}
