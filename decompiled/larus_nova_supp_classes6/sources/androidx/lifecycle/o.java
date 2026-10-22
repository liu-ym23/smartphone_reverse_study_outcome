package androidx.lifecycle;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final /* synthetic */ class o implements Function1 {
    public final /* synthetic */ Function1 a;
    public final /* synthetic */ Ref.ObjectRef b;
    public final /* synthetic */ MediatorLiveData c;

    public /* synthetic */ o(Function1 r1, Ref.ObjectRef r2, MediatorLiveData r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final Object invoke(Object r4) {
        return Transformations.a(this.a, this.b, this.c, r4);
    }
}
