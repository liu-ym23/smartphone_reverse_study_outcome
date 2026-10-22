package com.bytedance.android.live.openplatform.impl.miniappanchor.explaincardsetting;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class s<T> {
    public final MutableLiveData<T> a;

    public static final class a<T> implements Observer {
        public final /* synthetic */ Function1 a;

        public a(Function1 r1) {
            this.a = r1;
        }

        public final void onChanged(T r2) {
            this.a.invoke(r2);
        }
    }

    public s() {
        this.a = new MutableLiveData();
    }

    public final void a(LifecycleOwner r3, Function1<? super T, Unit> r4) {
        Intrinsics.checkNotNullParameter(r3, "owner");
        Intrinsics.checkNotNullParameter(r4, "block");
        this.a.observe(r3, new a(r4));
    }
}
