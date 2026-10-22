package o3a;

import com.larus.utils.t0;
import com.larus.voicecall.impl.component.translator.QuicInterpretComponent;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final /* synthetic */ class e implements Function1 {
    public final /* synthetic */ int a;
    public final /* synthetic */ QuicInterpretComponent b;
    public final /* synthetic */ int c;

    public /* synthetic */ e(int r1, QuicInterpretComponent r2, int r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final Object invoke(Object r4) {
        final int r0 = this.a;
        final QuicInterpretComponent r1 = this.b;
        final int r2 = this.c;
        ((Float) r4).floatValue();
        t0.e(new j(r0, r1, r2));
        return Unit.INSTANCE;
    }
}
