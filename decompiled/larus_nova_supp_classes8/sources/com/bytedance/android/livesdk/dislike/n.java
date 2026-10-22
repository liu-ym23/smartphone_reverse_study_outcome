package com.bytedance.android.livesdk.dislike;

import com.bytedance.android.livesdk.dislike.action.OptionAction;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public abstract class n {
    public final ItemType a;
    public final OptionAction b;

    public boolean a(n r2) {
        Intrinsics.checkNotNullParameter(r2, "item");
        if (r2.a == this.a) goto L6;
        return false;
    L6:
        return true;
    }

    public n(ItemType r2, OptionAction r3) {
        Intrinsics.checkNotNullParameter(r2, "identity");
        Intrinsics.checkNotNullParameter(r3, "optionAction");
        this.a = r2;
        this.b = r3;
    }
}
