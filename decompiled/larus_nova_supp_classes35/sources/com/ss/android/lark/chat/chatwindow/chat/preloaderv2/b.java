package com.ss.android.lark.chat.chatwindow.chat.preloaderv2;

import com.ss.android.lark.log.Log;
import com.ss.android.lark.passportc.api.ContainerConstsKt;
import com.ss.android.lark.passportc.api.j;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.passportc.internal.v;
import e0c.k;
import f0c.g;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b extends c0c.b implements d {
    public final /* synthetic */ d b;
    public final v c;
    public final com.ss.android.lark.passportc.convention.b<d> d;

    @Override // com.ss.android.lark.chat.chatwindow.chat.preloaderv2.d
    public final <S> Object B6(w3b.d<S> r2, Continuation<? super Result<? extends S>> r3) {
        Object r4 = this.b.B6(r2, r3);
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        return r4;
    }

    public b(j r4, v r5) {
        UserSession r1 = r4.b();
        if (r1 != null) goto L5;
        r1 = ContainerConstsKt.a();
    L5:
        com.ss.android.lark.passportc.convention.b<d> r0 = new com.ss.android.lark.passportc.convention.b(k.b(r5.c(r1), d.class), d.class);
        Intrinsics.checkNotNullParameter(r4, "passport");
        Intrinsics.checkNotNullParameter(r5, "accessor");
        Intrinsics.checkNotNullParameter(r0, "instanceHolder");
        super(r4);
        this.b = (d) r0.b();
        this.c = r5;
        this.d = r0;
    }

    public final void qf(g r2, g r3) {
        Log.i("DataPreloaderV2", "preparing IChatLauncherV2");
        v r4 = this.c;
        if (r3 == null) goto L6;
        UserSession r5 = r3.b;
        if (r5 == null) goto L6;
    L7:
        d r6 = (d) k.b(r4.c(r5), d.class);
        this.d.e(r6);
        return;
    L6:
        r5 = ContainerConstsKt.a();
        goto L7
    }
}
