package com.bytedance.android.live.broadcastgame.opengame.control;

import com.bytedance.android.livesdkapi.eventbus.LiveRealStartEvent;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a<T> implements Consumer {
    public final /* synthetic */ OpenPlatformControlService.e a;
    public final /* synthetic */ Function0 b;

    public a(OpenPlatformControlService.e r1, Function0 r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r3) {
        LiveRealStartEvent r4 = (LiveRealStartEvent) r3;
        if (Intrinsics.areEqual(r4.mEnterFrom, "toybox") == true) goto L5;
        return;
    L5:
        if (r4.isVerified() == false) goto L12;
        Disposable r5 = this.a.a;
        if (r5 == null) goto L9;
        r5.dispose();
    L9:
        this.b.invoke();
        return;
    }
}
