package com.bytedance.ai.widget.contianer;

import android.app.Activity;
import android.view.View;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public abstract class h implements k2.i {
    public HashMap<String, Object> a;

    public h() {
    }

    public abstract boolean f();

    public abstract Activity getActivity();

    public abstract String h(String r1);

    public abstract String j();

    public abstract m k();

    public abstract String l();

    public abstract void m();

    public abstract void o(m r1);

    public boolean g(View r10) {
        Intrinsics.checkNotNullParameter(r10, "view");
        if (Intrinsics.areEqual(realView(), r10) == false) goto L5;
    L8:
        return true;
    L5:
        if (Intrinsics.areEqual(engineView(), r10) == true) goto L8;
        return false;
    }
}
