package com.bytedance.android.btm.impl.page.lifecycle.layer3;

import com.byted.cast.sink.api.IAPI;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 1, IAPI.OPTION_PLAYER_TYPE})
public final class BtmPageLifecycleCallbackV2$pollBufferAndPutSourceBtm$5 extends Lambda implements Function0<String> {
    final /* synthetic */ String $pageClassName;

    public BtmPageLifecycleCallbackV2$pollBufferAndPutSourceBtm$5(String r1) {
        this.$pageClassName = r1;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final String m854invoke() {
        return this.$pageClassName + " is the first btmPage";
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        return m854invoke();
    }
}
