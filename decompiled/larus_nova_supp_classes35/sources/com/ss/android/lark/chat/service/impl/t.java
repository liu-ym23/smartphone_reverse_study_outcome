package com.ss.android.lark.chat.service.impl;

import com.larksuite.framework.callback.Entity.ErrorResult;
import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.videosend.compress.VideoCompressResult;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import com.tencent.qqmusic.third.api.contract.Keys;
import kotlin.Result;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class t extends com.ss.android.lark.videosend.compress.m {
    public final /* synthetic */ kotlinx.coroutines.i<String> a;
    public final /* synthetic */ Ref.ObjectRef<com.ss.android.lark.videosend.compress.a> b;

    public final void a(float r1) {
    }

    public final void b(ErrorResult r3) {
        Intrinsics.checkNotNullParameter(r3, Keys.API_RETURN_KEY_ERROR);
        Log.e("EditMessageService", "compressLocalMediaInRichText: compress failed : " + r3.getDisplayMsg());
        this.a.resumeWith(Result.constructor-impl(BuildConfig.FLAVOR));
    }

    public final void c(VideoCompressResult r2) {
        Intrinsics.checkNotNullParameter(r2, ChameleonOpenTracker.ParamKey.RESULT);
        Log.i("EditMessageService", "compressLocalMediaInRichText: compress success");
        kotlinx.coroutines.i<String> r3 = this.a;
        com.ss.android.lark.videosend.compress.a r0 = (com.ss.android.lark.videosend.compress.a) this.b.element;
        if (r0 == null) goto L6;
        String r1 = r0.a();
        if (r1 == null) goto L6;
    L7:
        r3.resumeWith(Result.constructor-impl(r1));
        return;
    L6:
        r1 = BuildConfig.FLAVOR;
        goto L7
    }

    public t(kotlinx.coroutines.j r1, Ref.ObjectRef r2) {
        this.a = r1;
        this.b = r2;
    }
}
