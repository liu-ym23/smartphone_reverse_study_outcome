package com.bytedance.android.live.profile.ui.base;

import com.bytedance.android.live.profile.model.LifecycleStateType;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class j<T> implements Consumer {
    public final /* synthetic */ LifecycleStateType a;
    public final /* synthetic */ Function1 b;
    public final /* synthetic */ Ref.ObjectRef c;

    public j(LifecycleStateType r1, Function1 r2, Ref.ObjectRef r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void accept(Object r3) {
        com.bytedance.android.live.profile.model.b r4 = (com.bytedance.android.live.profile.model.b) r3;
        if (r4 != null) goto L6;
        return;
    L6:
        if (r4.a.ordinal() < this.a.ordinal()) goto L11;
        this.b.invoke(r4);
        Disposable r5 = (Disposable) this.c.element;
        if (r5 == null) goto L12;
        r5.dispose();
        return;
    L12:
        return;
    }
}
