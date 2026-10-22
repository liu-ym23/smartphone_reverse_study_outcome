package com.bytedance.android.bcm.impl.paramcheck;

import com.byted.cast.sink.api.IAPI;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 1, IAPI.OPTION_PLAYER_TYPE})
final class BcmRuleStore$init$4$callback$1 extends Lambda implements Function0<String> {
    final /* synthetic */ InputStream $stream;

    public BcmRuleStore$init$4$callback$1(InputStream r1) {
        this.$stream = r1;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final String m516invoke() {
        StringBuilder r0 = new StringBuilder("receive gecko resource, has content: ");
        if (this.$stream == null) goto L5;
        boolean r1 = true;
    L6:
        r0.append(r1);
        return r0.toString();
    L5:
        r1 = false;
        goto L6
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        return m516invoke();
    }
}
