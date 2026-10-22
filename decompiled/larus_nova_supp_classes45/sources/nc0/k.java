package nc0;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class k {
    public static final <T extends vh7.c<T>> vh7.c<T> a(vh7.c<T> r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$flexInstance");
        if ((r1 instanceof vh7.e) == false) goto L9;
        Object r2 = ((vh7.e) r1).getFlexInstance();
        if (r2 == null) goto L8;
        return (vh7.c) r2;
    L8:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.tools.kcp.modelx.runtime.FlexModel<T>");
    L9:
        return r1;
    }
}
