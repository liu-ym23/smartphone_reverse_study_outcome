package com.bytedance.android.bcm.impl2;

import com.byted.cast.sink.api.IAPI;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 1, IAPI.OPTION_PLAYER_TYPE})
final class ScopedBcmHolder$setUnitParamsByToken$2 extends Lambda implements Function0<String> {
    final /* synthetic */ Map $params;

    public ScopedBcmHolder$setUnitParamsByToken$2(Map r1) {
        this.$params = r1;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final String m553invoke() {
        return "setUnitParamsByToken params is " + this.$params;
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        return m553invoke();
    }
}
