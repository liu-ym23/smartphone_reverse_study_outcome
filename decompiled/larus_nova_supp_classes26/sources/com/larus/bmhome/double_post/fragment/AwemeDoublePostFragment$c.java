package com.larus.bmhome.double_post.fragment;

import androidx.lifecycle.Observer;
import kotlin.Function;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class AwemeDoublePostFragment$c implements Observer, FunctionAdapter {
    public final /* synthetic */ Function1 a;

    public AwemeDoublePostFragment$c(Function1 r2) {
        Intrinsics.checkNotNullParameter(r2, "function");
        this.a = r2;
    }

    public final boolean equals(Object r3) {
        if ((r3 instanceof Observer) == true) goto L5;
        return false;
    L5:
        if ((r3 instanceof FunctionAdapter) == true) goto L7;
        return false;
    L7:
        return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) r3).getFunctionDelegate());
    }

    public final Function<?> getFunctionDelegate() {
        return this.a;
    }

    public final int hashCode() {
        return getFunctionDelegate().hashCode();
    }

    public final /* synthetic */ void onChanged(Object r2) {
        this.a.invoke(r2);
    }
}
