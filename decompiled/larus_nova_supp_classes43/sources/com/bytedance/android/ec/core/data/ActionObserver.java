package com.bytedance.android.ec.core.data;

import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import rg.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00030\u0002¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/ec/core/data/ActionObserver;", "T", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lrg/a;", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ActionObserver<T> implements Observer<a<? extends T>> {
    public final Function1<T, Unit> a;

    /* JADX WARN: Multi-variable type inference failed */
    public ActionObserver(Function1<? super T, Unit> r10) {
        Intrinsics.checkNotNullParameter(r10, "onActionUnhandledContent");
        this.a = r10;
    }

    public final void onChanged(Object r10) {
        a r11 = (a) r10;
        if (r11 == null) goto L8;
        Object r12 = r11.a();
        if (r12 == null) goto L9;
        this.a.invoke(r12);
        return;
    L9:
        return;
    }
}
