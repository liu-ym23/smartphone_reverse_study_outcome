package com.bytedance.android.livesdk.dslservice.slice.action;

import android.view.View;
import com.bytedance.android.ecom.arch.slice.action.IAction;
import com.bytedance.android.ecom.arch.slice.action.SlcCommonAction;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
import yt1.h;
import yt1.i;
import yt1.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a implements i {
    public final HashMap<String, h> a;
    public i b;

    public a(i r1) {
        this.b = r1;
        this.a = new HashMap();
    }

    @Override // yt1.i
    public final boolean a(IAction r3, View r4, j r5) {
        Intrinsics.checkNotNullParameter(r3, "action");
        Intrinsics.checkNotNullParameter(r4, "targetView");
        Intrinsics.checkNotNullParameter(r5, "curTemplateHolder");
        i r0 = this.b;
        if (r0 != null) goto L5;
    L7:
        h r6 = this.a.get(r3.getType());
        if (r6 != null) goto L10;
        return false;
    L10:
        if ((r3 instanceof SlcCommonAction) == false) goto L12;
        ((SlcCommonAction) r3).getData();
        r6.b(r3.getParams(), r5);
    L12:
        return true;
    L5:
        if (r0.a(r3, r4, r5) != true) goto L7;
        return true;
    }
}
