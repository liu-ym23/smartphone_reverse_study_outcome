package o3a;

import com.larus.utils.t0;
import com.larus.voicecall.impl.component.translator.QuicInterpretComponent;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final /* synthetic */ class f implements Function1 {
    public final /* synthetic */ QuicInterpretComponent a;

    public /* synthetic */ f(QuicInterpretComponent r1) {
        this.a = r1;
    }

    public final Object invoke(Object r5) {
        final QuicInterpretComponent r0 = this.a;
        final String r6 = (String) r5;
        Intrinsics.checkNotNullParameter(r6, "it");
        t0.d(new k(r0, r6), 400);
        return Unit.INSTANCE;
    }
}
