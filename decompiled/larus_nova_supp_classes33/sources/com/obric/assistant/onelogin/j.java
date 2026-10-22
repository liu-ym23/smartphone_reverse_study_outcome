package com.obric.assistant.onelogin;

import androidx.lifecycle.Observer;
import com.larus.common_ui.activity.FlowCommonAppCompatActivity;
import java.lang.ref.WeakReference;
import kotlin.Function;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class j {

    public static final class a implements Observer, FunctionAdapter {
        public final /* synthetic */ Function1 a;

        public a(f r2) {
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

    /* JADX WARN: Multi-variable type inference failed */
    public static final ObricOneLoginActivity a(WeakReference r2) {
        FlowCommonAppCompatActivity r3 = (ObricOneLoginActivity) r2.get();
        if (r3 != null) goto L6;
        return null;
    L6:
        if (r3.isFinishing() == false) goto L8;
    L9:
        r3 = null;
    L11:
        return r3;
    L8:
        if (r3.isDestroyed() == false) goto L11;
        goto L9
    }
}
