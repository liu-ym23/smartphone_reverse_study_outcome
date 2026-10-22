package com.ss.android.lark.forwardv3;

import androidx.lifecycle.Observer;
import com.ss.android.lark.log.Log;
import java.util.ArrayList;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class v<T> implements Observer {
    public final /* synthetic */ ForwardNewFragment a;

    public v(ForwardNewFragment r1) {
        this.a = r1;
    }

    public final void onChanged(Object r3) {
        ArrayList r0 = new ArrayList();
        r0.addAll(((Map) r3).values());
        Log.i("NewForward", "select item change size: " + r0.size());
        tib.e r4 = this.a.e;
        if (r4 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("chatPicker");
        r4 = null;
    L5:
        r4.f(r0);
        this.a.ea0(false);
    }
}
