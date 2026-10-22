package com.larus.uaigc.share;

import android.content.Context;
import com.larus.bmhome.video.IVideoDownloadLoadingMgrService;
import com.larus.platform.api.creation.UserCreation;
import com.larus.platform.api.creation.UserCreationFromIM;
import iz9.c;
import java.util.Map;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import nr9.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class AigcVideoSaveHelper {
    public AigcVideoSaveHelper() {
    }

    public final void a(Context r14, String r15, g r16, CoroutineScope r17, Function0<Unit> r18, boolean r19, UserCreationFromIM r20, UserCreation r21, Function4<? super Integer, ? super String, ? super Long, ? super Boolean, Unit> r22, Function0<Unit> r23, Function1<? super Continuation<? super String>, ? extends Object> r24) {
        Intrinsics.checkNotNullParameter(r15, "downloadTaskKey");
        Intrinsics.checkNotNullParameter(r17, "scope");
        if (r20 == null) goto L6;
        c.a.getClass();
        Map r0 = c.g(r20, null);
        if (r0 == null) goto L6;
    L8:
        Map r7 = r0;
    L10:
        if (r16 == null) goto L12;
        String r1 = r16.a;
    L13:
        if (r1 != null) goto L15;
    L18:
        boolean r2 = true;
    L19:
        if (r2 == false) goto L21;
        Function1<? super Continuation<? super String>, ? extends Object> r10 = r24;
    L22:
        IVideoDownloadLoadingMgrService.a.getClass();
        IVideoDownloadLoadingMgrService r3 = (IVideoDownloadLoadingMgrService) IVideoDownloadLoadingMgrService.a.b.getValue();
        if (r3 == null) goto L26;
        r3.b(r14, r15, r16, r17, r18, r19, r7, r22, r23, r10, true);
        return;
    L26:
        return;
    L21:
        r10 = new AigcVideoSaveHelper$saveAigcVideoAndLoading$wrappedOnInterceptUrl$1(r16, this, r24, null);
        goto L22
    L15:
        if (r1.length() == 0) goto L18;
        r2 = false;
        goto L19
    L12:
        r1 = null;
    L6:
        if (r21 == null) goto L9;
        c.a.getClass();
        r0 = c.f(r21, null);
        goto L8
    L9:
        r7 = null;
        goto L10
    }
}
