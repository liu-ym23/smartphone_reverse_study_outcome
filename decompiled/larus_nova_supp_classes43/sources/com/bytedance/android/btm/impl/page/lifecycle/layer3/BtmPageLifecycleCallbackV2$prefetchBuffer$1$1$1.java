package com.bytedance.android.btm.impl.page.lifecycle.layer3;

import com.byted.cast.sink.api.IAPI;
import com.bytedance.android.btm.api.model.BufferBtm;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 1, IAPI.OPTION_PLAYER_TYPE})
final class BtmPageLifecycleCallbackV2$prefetchBuffer$1$1$1 extends Lambda implements Function0<String> {
    final /* synthetic */ BufferBtm $it;

    public BtmPageLifecycleCallbackV2$prefetchBuffer$1$1$1(BufferBtm r1) {
        this.$it = r1;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final String m855invoke() {
        return "prefetchBuffer " + this.$it;
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        return m855invoke();
    }
}
