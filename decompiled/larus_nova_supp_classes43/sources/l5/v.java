package l5;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final /* synthetic */ class v implements Function0 {
    public final /* synthetic */ String a;

    public /* synthetic */ v(String r1) {
        this.a = r1;
    }

    public final Object invoke() {
        String r0 = this.a;
        w.c.remove(r0);
        return Unit.INSTANCE;
    }
}
