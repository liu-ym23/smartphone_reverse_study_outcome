package com.bytedance.android.live.liveinteract.plantform.performance;

import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import io.reactivex.functions.Consumer;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class e<T> implements Consumer {
    public final /* synthetic */ a a;

    public e(a r1) {
        this.a = r1;
    }

    public final void accept(Object r7) {
        final Map r8 = (Map) r7;
        UtilityKotlinExtentionsKt.s(0, false, false, new MultiLinkAllPerfAbilityManager$initSourceCombined$2$1(this, r8), 7);
    }
}
