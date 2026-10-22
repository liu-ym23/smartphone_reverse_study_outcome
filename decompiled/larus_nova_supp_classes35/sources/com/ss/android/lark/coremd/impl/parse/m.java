package com.ss.android.lark.coremd.impl.parse;

import com.ss.android.lark.coremd.base.parse.v;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import v7b.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class m implements v {
    public static final /* synthetic */ int b = 0;
    public final Function2<v, Integer, Unit> a;

    public static final class a {
        public static m a(final com.ss.android.lark.coremd.base.parse.i r3, final s r4) {
            Intrinsics.checkNotNullParameter(r3, "parseContext");
            Intrinsics.checkNotNullParameter(r4, "node");
            final com.ss.android.lark.coremd.base.parse.n.b r0 = r3.g().b(r4.getClass());
            if (r0 != null) goto L7;
            return null;
        L7:
            return new m(new ProxyClickSpanInner$Companion$proxyNodeClickInner$1$proxySpan$1(r3, r4, r3, r0));
        }
    }

    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public m(Function2<? super v, ? super Integer, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "clickRaiser");
        this.a = r2;
    }

    @Override // com.ss.android.lark.coremd.base.parse.v
    public final void a(int r2) {
        this.a.invoke(this, Integer.valueOf(r2));
    }
}
