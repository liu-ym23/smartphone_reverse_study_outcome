package tu1;

import com.bytedance.android.livesdk.dynamicstrategy.impl.express.parse.ExpressNodeType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class b {
    public final ExpressNodeType a;
    public final Object b;
    public b c;
    public b d;

    public final boolean b() {
        ExpressNodeType r0 = this.a;
        if (r0 != ExpressNodeType.OPERATOR_COMPARE) goto L5;
    L10:
        return true;
    L5:
        if (r0 == ExpressNodeType.OPERATOR_AND) goto L10;
        if (r0 == ExpressNodeType.OPERATOR_OR) goto L10;
        return false;
    }

    public final boolean c() {
        ExpressNodeType r0 = this.a;
        if (r0 != ExpressNodeType.PARAM) goto L5;
    L16:
        return true;
    L5:
        if (r0 == ExpressNodeType.CONST_LONG) goto L16;
        if (r0 == ExpressNodeType.CONST_DOUBLE) goto L16;
        if (r0 == ExpressNodeType.CONST_FLOAT) goto L16;
        if (r0 == ExpressNodeType.CONST_INT) goto L16;
        if (r0 == ExpressNodeType.CONST_BOOLEAN) goto L16;
        return false;
    }

    public final boolean a() {
        if (b() == true) goto L5;
    L10:
        return true;
    L5:
        if (this.c != null) goto L7;
    L9:
        return false;
    L7:
        if (this.d == null) goto L9;
        goto L9
    }

    public final ExpressNodeType getType() {
        return this.a;
    }

    public b(ExpressNodeType r2, Object r3) {
        Intrinsics.checkNotNullParameter(r2, "type");
        Intrinsics.checkNotNullParameter(r3, "value");
        this.a = r2;
        this.b = r3;
        this.c = null;
        this.d = null;
    }
}
