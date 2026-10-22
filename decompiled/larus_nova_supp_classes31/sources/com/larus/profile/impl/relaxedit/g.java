package com.larus.profile.impl.relaxedit;

import androidx.lifecycle.Observer;
import com.larus.trace.CopyContentTypeString;
import com.lynx.react.bridge.JavaOnlyMap;
import kotlin.Function;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class g {

    public static final class a implements Observer, FunctionAdapter {
        public final /* synthetic */ Function1 a;

        public a(Function1 r2) {
            Intrinsics.checkNotNullParameter(r2, "function");
            this.a = r2;
        }

        public final boolean equals(Object r3) {
            if ((r3 instanceof Observer) == true) goto L5;
            return false;
        L5:
            if ((r3 instanceof FunctionAdapter) == true) goto L7;
            return false;
        L7:
            return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) r3).getFunctionDelegate());
        }

        public final Function<?> getFunctionDelegate() {
            return this.a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        public final /* synthetic */ void onChanged(Object r2) {
            this.a.invoke(r2);
        }
    }

    public static final JavaOnlyMap a(String r2, boolean r3, String r4, String r5) {
        JavaOnlyMap r0 = new JavaOnlyMap();
        r0.putString("requestId", r2);
        r0.putBoolean("success", r3);
        r0.putString(CopyContentTypeString.CODE, r4);
        r0.putString("message", r5);
        return r0;
    }

    public static final JavaOnlyMap b(String r2, String r3, boolean r4, String r5, String r6) {
        JavaOnlyMap r0 = new JavaOnlyMap();
        r0.putString("requestId", r2);
        r0.putString("userName", r3);
        r0.putBoolean("isUnique", r4);
        r0.putString(CopyContentTypeString.CODE, r5);
        r0.putString("message", r6);
        return r0;
    }

    public static /* synthetic */ JavaOnlyMap c(String r2, String r3, boolean r4, String r5, int r6) {
        String r1 = "";
        if ((r6 & 8) == 0) goto L6;
        r5 = "";
    L6:
        if ((r6 & 16) != 0) goto L10;
        r1 = null;
    L10:
        return b(r2, r3, r4, r5, r1);
    }
}
