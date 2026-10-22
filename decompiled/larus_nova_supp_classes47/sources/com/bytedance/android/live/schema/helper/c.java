package com.bytedance.android.live.schema.helper;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c implements Action {
    public final /* synthetic */ Ref.ObjectRef a;

    public c(Ref.ObjectRef r1) {
        this.a = r1;
    }

    public final void run() {
        ((Disposable) this.a.element).dispose();
    }
}
