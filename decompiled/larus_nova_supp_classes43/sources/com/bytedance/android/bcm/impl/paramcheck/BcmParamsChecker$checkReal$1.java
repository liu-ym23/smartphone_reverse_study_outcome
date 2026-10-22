package com.bytedance.android.bcm.impl.paramcheck;

import com.byted.cast.sink.api.IAPI;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 1, IAPI.OPTION_PLAYER_TYPE})
public final class BcmParamsChecker$checkReal$1 extends Lambda implements Function0<String> {
    final /* synthetic */ a $rule;
    final /* synthetic */ c $target;

    public BcmParamsChecker$checkReal$1(c r1, a r10) {
        this.$target = r1;
        this.$rule = r10;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final String m513invoke() {
        StringBuilder r0 = new StringBuilder("Start check ");
        r0.append(this.$target.getBtm());
        r0.append(", find rule: ");
        a r1 = this.$rule;
        boolean r10 = r1.a.isEmpty();
        String r11 = r1.b;
        if (r11 != null) goto L5;
    L8:
        boolean r12 = true;
    L9:
        r0.append(!(r12 & r10));
        return r0.toString();
    L5:
        if (r11.length() == 0) goto L8;
        r12 = false;
        goto L9
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        return m513invoke();
    }
}
