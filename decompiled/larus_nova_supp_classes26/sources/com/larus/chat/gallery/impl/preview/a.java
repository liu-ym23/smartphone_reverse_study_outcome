package com.larus.chat.gallery.impl.preview;

import com.facebook.datasource.BaseDataSubscriber;
import com.facebook.datasource.DataSource;
import com.larus.utils.logger.FLogger;
import kotlin.Result;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class a extends BaseDataSubscriber<Void> {
    public final /* synthetic */ String a;
    public final /* synthetic */ String b;
    public final /* synthetic */ kotlinx.coroutines.i<Boolean> c;

    public final void onFailureImpl(DataSource<Void> r4) {
        Intrinsics.checkNotNullParameter(r4, "ds");
        FLogger.a.e("OriginalImagePreloader", "awaitPrefetchReady: prefetch failed, bizTag=" + this.a + ", path=" + this.b, r4.getFailureCause());
        if (this.c.isActive() == false) goto L6;
        kotlinx.coroutines.i<Boolean> r5 = this.c;
        Result.Companion r0 = Result.Companion;
        r5.resumeWith(Result.constructor-impl(Boolean.FALSE));
        return;
    }

    public final void onNewResultImpl(DataSource<Void> r2) {
        Intrinsics.checkNotNullParameter(r2, "ds");
        if (r2.isFinished() == true) goto L5;
        return;
    L5:
        if (this.c.isActive() == false) goto L9;
        kotlinx.coroutines.i<Boolean> r3 = this.c;
        Result.Companion r0 = Result.Companion;
        r3.resumeWith(Result.constructor-impl(Boolean.TRUE));
        return;
    }

    public a(String r1, String r2, kotlinx.coroutines.j r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
