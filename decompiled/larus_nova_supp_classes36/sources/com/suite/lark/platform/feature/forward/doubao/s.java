package com.suite.lark.platform.feature.forward.doubao;

import androidx.lifecycle.Observer;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class s<T> implements Observer {
    public final /* synthetic */ DoubaoForwardFragment a;

    public s(DoubaoForwardFragment r1) {
        this.a = r1;
    }

    public final void onChanged(Object r3) {
        Map r4 = (Map) r3;
        int r0 = r4.size();
        tib.e r1 = this.a.f;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("chatPicker");
        r1 = null;
    L5:
        r1.f(CollectionsKt.toList(r4.values()));
        this.a.T90(r0);
    }
}
