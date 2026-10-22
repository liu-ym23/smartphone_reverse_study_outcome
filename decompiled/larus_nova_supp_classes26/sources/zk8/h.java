package zk8;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final /* synthetic */ class h implements Function1 {
    public final /* synthetic */ Function0 a;

    public /* synthetic */ h(Function0 r1) {
        this.a = r1;
    }

    public final Object invoke(Object r2) {
        Function0 r0 = this.a;
        ((Float) r2).floatValue();
        n.f = true;
        r0.invoke();
        return Unit.INSTANCE;
    }
}
