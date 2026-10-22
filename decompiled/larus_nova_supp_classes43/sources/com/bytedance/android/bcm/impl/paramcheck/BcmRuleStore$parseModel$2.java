package com.bytedance.android.bcm.impl.paramcheck;

import com.byted.cast.sink.api.IAPI;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 1, IAPI.OPTION_PLAYER_TYPE})
final class BcmRuleStore$parseModel$2 extends Lambda implements Function0<String> {
    final /* synthetic */ Ref.IntRef $acceptedRule;
    final /* synthetic */ com.bytedance.android.bcm.impl.model.a $model;
    final /* synthetic */ Ref.IntRef $rejectRule;
    final /* synthetic */ BcmRuleStore this$0;

    public BcmRuleStore$parseModel$2(BcmRuleStore r1, com.bytedance.android.bcm.impl.model.a r10, Ref.IntRef r11, Ref.IntRef r12) {
        this.this$0 = r1;
        this.$model = r10;
        this.$acceptedRule = r11;
        this.$rejectRule = r12;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final String m517invoke() {
        StringBuilder r0 = new StringBuilder("parse rule success, raw data size: ");
        List r1 = this.$model.a().a();
        if (r1 == null) goto L5;
        Integer r10 = Integer.valueOf(r1.size());
    L6:
        r0.append(r10);
        r0.append(", rule size: ");
        r0.append(this.this$0.b.size());
        r0.append(",accepted rules: ");
        r0.append(this.$acceptedRule.element);
        r0.append(", rejected rules: ");
        r0.append(this.$rejectRule.element);
        r0.append(",should check bcm size: ");
        r0.append(this.this$0.d.size());
        return r0.toString();
    L5:
        r10 = null;
        goto L6
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        return m517invoke();
    }
}
