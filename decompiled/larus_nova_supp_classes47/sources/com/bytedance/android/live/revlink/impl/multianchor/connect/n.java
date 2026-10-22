package com.bytedance.android.live.revlink.impl.multianchor.connect;

import com.bytedance.android.livesdk.link.model.i6;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public abstract class n {

    public static final class a extends n {
        public final i6 a;

        public a(i6 r2) {
            Intrinsics.checkNotNullParameter(r2, "linkerMessage");
            this.a = r2;
        }
    }

    public static final class b extends n {
        public final d11.o a;

        public b(d11.o r2) {
            Intrinsics.checkNotNullParameter(r2, "params");
            this.a = r2;
        }
    }

    public static final class c extends n {
        public static final c a = null;

        static {
            a = new c();
        }

        public c() {
        }
    }

    public n() {
    }

    public final String toString() {
        if (Intrinsics.areEqual(this, c.a) == false) goto L6;
        return "None";
    L6:
        if ((this instanceof b) == false) goto L9;
        return "Inviting";
    L9:
        if ((this instanceof a) == false) goto L13;
        return "BeInvited";
    L13:
        throw new NoWhenBranchMatchedException();
    }
}
