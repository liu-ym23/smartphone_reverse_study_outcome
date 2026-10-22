package androidx.lifecycle;

import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final /* synthetic */ class p implements Function1 {
    public final /* synthetic */ MediatorLiveData a;

    public /* synthetic */ p(MediatorLiveData r1) {
        this.a = r1;
    }

    public final Object invoke(Object r2) {
        return Transformations.d(this.a, r2);
    }
}
