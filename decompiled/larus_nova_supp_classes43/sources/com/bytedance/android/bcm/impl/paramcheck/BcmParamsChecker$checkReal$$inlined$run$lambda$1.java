package com.bytedance.android.bcm.impl.paramcheck;

import com.byted.cast.sink.api.IAPI;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, d2 = {"<anonymous>", "", "invoke", "com/bytedance/android/bcm/impl/paramcheck/BcmParamsChecker$checkReal$rule$1$1"}, k = 3, mv = {1, 1, IAPI.OPTION_PLAYER_TYPE})
public final class BcmParamsChecker$checkReal$$inlined$run$lambda$1 extends Lambda implements Function0<String> {
    final /* synthetic */ c $target$inlined;

    public BcmParamsChecker$checkReal$$inlined$run$lambda$1(c r1) {
        this.$target$inlined = r1;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final String m512invoke() {
        return "Ignore check " + this.$target$inlined.getBtm();
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        return m512invoke();
    }
}
