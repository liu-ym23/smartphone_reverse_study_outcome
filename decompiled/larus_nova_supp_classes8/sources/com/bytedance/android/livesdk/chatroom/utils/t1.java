package com.bytedance.android.livesdk.chatroom.utils;

import android.graphics.drawable.Drawable;
import android.view.View;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class t1 implements z2 {
    public final Object a;

    public final Drawable c() {
        Object r0 = this.a;
        Object r2 = null;
        if ((r0 instanceof Integer) == false) goto L14;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L6
        Object r3 = Result.constructor-impl(com.bytedance.android.live.core.utils.s1.m(((Number) r0).intValue()));     // Catch: Throwable -> L6
    L9:
        if (Result.isFailure-impl(r3) == true) goto L19;
        r2 = r3;
    L19:
        return (Drawable) r2;
    L6:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        r3 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L9
    L14:
        if ((r0 instanceof Drawable) == true) goto L16;
        return null;
    L16:
        return (Drawable) r0;
    }

    @Override // com.bytedance.android.livesdk.chatroom.utils.z2
    public final Observable<Drawable> a() {
        Drawable r0 = c();
        if (r0 != null) goto L7;
        return null;
    L7:
        return Observable.just(r0);
    }

    public t1(Object r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.livesdk.chatroom.utils.z2
    public final Disposable b(View r4, SkinLoader$loopLoadImg$2 r5) {
        Intrinsics.checkNotNullParameter(r4, "view");
        Drawable r0 = c();
        if (r0 == null) goto L5;
        r5.b(SkinLoadResultType.SUCCESS, "");
        r4.setBackgroundDrawable(r0);
        return null;
    L5:
        r5.b(SkinLoadResultType.ERROR, "drawable is null");
        return null;
    }
}
