package com.larus.chat.search.impl.chat;

import androidx.lifecycle.Observer;
import kotlin.Function;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class s {

    public static final class a implements Observer, FunctionAdapter {
        public final /* synthetic */ Function1 a;

        public a(n r2) {
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

    public static String a(String r12) {
        if (r12 != null) goto L4;
        r12 = "";
    L4:
        String r13 = StringsKt.replace$default(StringsKt.replace$default(r12, "\n", "\\n", false, 4, null), "\r", "\\r", false, 4, null);
        if (r13.length() > 32) goto L8;
        return r13;
    L8:
        return StringsKt.take(r13, 32) + "...";
    }
}
