package com.larus.share.impl.sdk.special;

import android.content.Context;
import com.larus.utils.logger.FLogger;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class c implements Function1<Throwable, Unit> {
    public final /* synthetic */ ShareImageSpecialHandler a;
    public final /* synthetic */ Ref.IntRef b;
    public final /* synthetic */ Context c;

    public c(ShareImageSpecialHandler r1, Ref.IntRef r2, Context r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final Object invoke(Object r3) {
        Throwable r4 = (Throwable) r3;
        this.a.a.remove(Integer.valueOf(this.b.element));
        FLogger.a.e("ShareImageSpecialHandler", "Download video cancel, downloadId = " + this.b.element);
        Downloader.getInstance(this.c).cancel(this.b.element);
        return Unit.INSTANCE;
    }
}
