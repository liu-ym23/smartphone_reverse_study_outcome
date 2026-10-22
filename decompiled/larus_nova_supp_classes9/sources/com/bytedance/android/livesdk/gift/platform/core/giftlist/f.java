package com.bytedance.android.livesdk.gift.platform.core.giftlist;

import com.bytedance.android.livesdk.gift.model.h1;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class f implements com.bytedance.android.scope.o {
    public final ArrayList<h1> a;
    public final GiftListFilterService b;

    public static final class a {
    }

    static {
    }

    public final void onStart() {
    }

    public final void onStop() {
        this.a.clear();
    }

    public f(GiftListFilterService r2) {
        Intrinsics.checkNotNullParameter(r2, "listFilterService");
        this.b = r2;
        this.a = new ArrayList();
    }
}
