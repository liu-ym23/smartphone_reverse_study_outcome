package i0c;

import com.ss.android.lark.passportc.impl.v2.entity.UpdateUserContext;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class e<S, C, R> implements d<S, C, R> {
    public final S a;
    public final S b;
    public final b<S, C, R> c;

    @Override // i0c.d
    public final S getFrom() {
        return this.a;
    }

    @Override // i0c.d
    public final S getTo() {
        return this.b;
    }

    @Override // i0c.d
    public final h0c.b a(UpdateUserContext r4) {
        return this.c.a(r4, this.a, this.b);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public e(Object r2, Object r3, com.ss.android.lark.passportc.impl.v2.action.d r4) {
        Intrinsics.checkNotNullParameter(r4, "action");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
