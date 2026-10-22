package com.larus.bmhome.taskskill;

import androidx.lifecycle.Observer;
import kotlin.Function;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class x1 {

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

    public static final be8.e a(bs8.a r3) {
        String r0 = r3.b;
        boolean r1 = false;
        if (r0 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == false) goto L17;
        String r4 = r3.d;
        if (r4 != null) goto L13;
    L14:
        r1 = true;
    L15:
        if (r1 == false) goto L17;
        return null;
    L13:
        if (StringsKt.isBlank(r4) == false) goto L15;
    L17:
        String r5 = r3.b;
        String r6 = "";
        if (r5 != null) goto L20;
        r5 = "";
    L20:
        String r7 = r3.d;
        if (r7 == null) goto L25;
        r6 = r7;
    L25:
        return new be8.e(r5, r6);
    L5:
        if (StringsKt.isBlank(r0) == true) goto L8;
        r2 = false;
        goto L9
    }
}
