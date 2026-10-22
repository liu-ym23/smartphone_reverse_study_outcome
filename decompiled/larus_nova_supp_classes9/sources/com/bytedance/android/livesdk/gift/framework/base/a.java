package com.bytedance.android.livesdk.gift.framework.base;

import com.bytedance.android.anya.BaseMVIComposableViewModel;
import com.bytedance.android.anya.MVIState;
import com.bytedance.android.anya.b0;
import com.bytedance.android.anya.p;
import java.util.Collection;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public abstract class a<STATE extends MVIState<STATE>, ACTION extends p> extends BaseMVIComposableViewModel<STATE, ACTION> {
    public final boolean L0(ACTION r2) {
        Intrinsics.checkNotNullParameter(r2, "action");
        return true;
    }

    public a(Collection<? extends b0<STATE, ?, ?>> r2) {
        Intrinsics.checkNotNullParameter(r2, "childNodes");
        super(r2);
    }
}
