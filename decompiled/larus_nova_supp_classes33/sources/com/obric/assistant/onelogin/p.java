package com.obric.assistant.onelogin;

import androidx.lifecycle.LifecycleOwnerKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class p implements Function0 {
    public final /* synthetic */ ObricOneLoginTransparentActivity a;

    public /* synthetic */ p(ObricOneLoginTransparentActivity r1) {
        this.a = r1;
    }

    public final Object invoke() {
        ObricOneLoginTransparentActivity r0 = this.a;
        int r1 = ObricOneLoginTransparentActivity.d;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r0), null, null, new ObricOneLoginTransparentActivity$onCreate$2$1(r0, null), 3, null);
        return Unit.INSTANCE;
    }
}
