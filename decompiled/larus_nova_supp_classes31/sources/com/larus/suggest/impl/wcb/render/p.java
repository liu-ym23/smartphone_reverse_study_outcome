package com.larus.suggest.impl.wcb.render;

import com.larus.im.bean.message.Message;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class p {
    public static final /* synthetic */ int b = 0;
    public final String a;

    public static final class a {
        public static p a(Message r1) {
            Intrinsics.checkNotNullParameter(r1, "message");
            String r2 = r1.getLocalMessageId();
            if (r2 != null) goto L6;
            r2 = "";
        L6:
            return new p(r2);
        }
    }

    static {
    }

    public final boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof p) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.a, ((p) r4).a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return "WcbRenderTargetRef(localMessageId=" + this.a + ')';
    }

    public p(String r2) {
        Intrinsics.checkNotNullParameter(r2, "localMessageId");
        this.a = r2;
    }
}
