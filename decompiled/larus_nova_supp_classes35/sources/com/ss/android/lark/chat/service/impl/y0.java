package com.ss.android.lark.chat.service.impl;

import com.ss.android.lark.log.Log;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class y0 {
    public static final Disposable a(String r1, String r2, Function0<? extends Disposable> r3) {
        Intrinsics.checkNotNullParameter(r1, "logTag");
        Intrinsics.checkNotNullParameter(r2, "currentUserId");
        Intrinsics.checkNotNullParameter(r3, "observePushBlock");
        if (Intrinsics.areEqual(r2, "absent_user") == false) goto L6;
        Log.i(r1, "currentUserId is ABSENT_USER_ID, do not really call observePush");
        Disposable r4 = Disposables.empty();
        Intrinsics.checkNotNull(r4);
        return r4;
    L6:
        return (Disposable) r3.invoke();
    }
}
