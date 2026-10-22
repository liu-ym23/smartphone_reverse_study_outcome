package com.ss.android.lark.inline.ai.utils;

import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.ss.android.lark.log.Log;
import java.io.File;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.i;
import kotlinx.coroutines.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c implements RequestListener<File> {
    public final /* synthetic */ Ref.IntRef a;
    public final /* synthetic */ int b;
    public final /* synthetic */ i<File> c;
    public final /* synthetic */ RequestManager d;
    public final /* synthetic */ String e;

    public c(Ref.IntRef r1, j r2, RequestManager r3, String r4) {
        this.a = r1;
        this.b = 2;
        this.c = r2;
        this.d = r3;
        this.e = r4;
    }

    public final boolean onLoadFailed(GlideException r1, Object r2, Target<File> r3, boolean r4) {
        Log.e("GlideUtils", "downloadImageFile failed, retryTimes = " + this.a.element + ", maxRetryTimes = " + this.b + ", isActive = " + this.c.isActive() + ", isCancelled = " + this.c.isCancelled(), r1);
        if (this.c.isActive() == true) goto L5;
    L15:
        return false;
    L5:
        if (this.c.isCancelled() == true) goto L15;
        if (this.a.element < this.b) goto L14;
        i<File> r5 = this.c;
        Result.Companion r6 = Result.Companion;
        if (r1 != null) goto L13;
        r1 = new IllegalStateException("download failed");
    L13:
        r5.resumeWith(Result.constructor-impl(ResultKt.createFailure(r1)));
        goto L15
    L14:
        this.d.downloadOnly().load(this.e).listener(this).preload();
        this.a.element++;
        goto L15
    }

    public final boolean onResourceReady(Object r1, Object r2, Target r3, DataSource r4, boolean r5) {
        File r6 = (File) r1;
        Intrinsics.checkNotNullParameter(r6, "resource");
        Log.i("GlideUtils", "download success, isActive = " + this.c.isActive() + ", isCancelled = " + this.c.isCancelled());
        if (this.c.isActive() == true) goto L5;
        return false;
    L5:
        if (this.c.isCancelled() == true) goto L10;
        this.c.resumeWith(Result.constructor-impl(r6));
        return false;
    L10:
        return false;
    }
}
