package androidx.lifecycle;

import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final /* synthetic */ class d implements Function1 {
    public final /* synthetic */ MediatorLiveData a;

    public /* synthetic */ d(MediatorLiveData r1) {
        this.a = r1;
    }

    public final Object invoke(Object r2) {
        return CoroutineLiveDataKt.addDisposableSource.2.a(this.a, r2);
    }
}
