package com.bytedance.android.live.core.utils;

import com.ss.android.ugc.aweme.debug.LocalTestManager;
import io.reactivex.functions.Consumer;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class t2<T> implements Consumer {
    public final /* synthetic */ Ref.ObjectRef a;
    public final /* synthetic */ Function1 b;

    public t2(Ref.ObjectRef r1, Function1 r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r3) {
        Long r4 = (Long) r3;
        if (((AnimationStatus) this.a.element) != AnimationStatus.IDLE) goto L8;
        LocalTestManager.a(new Class[]{wy.a.class});
        Function1 r5 = this.b;
        if (r5 == null) goto L9;
        Unit r6 = (Unit) r5.invoke(((AnimationStatus) this.a.element).name());
        return;
    L9:
        return;
    }
}
