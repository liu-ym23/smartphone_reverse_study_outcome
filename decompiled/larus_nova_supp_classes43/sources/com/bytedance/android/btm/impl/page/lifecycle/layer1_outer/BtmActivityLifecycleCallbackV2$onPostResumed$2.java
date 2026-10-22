package com.bytedance.android.btm.impl.page.lifecycle.layer1_outer;

import com.byted.cast.sink.api.IAPI;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 1, IAPI.OPTION_PLAYER_TYPE})
public final class BtmActivityLifecycleCallbackV2$onPostResumed$2 extends Lambda implements Function0<String> {
    public static final BtmActivityLifecycleCallbackV2$onPostResumed$2 INSTANCE = null;

    static {
        INSTANCE = new BtmActivityLifecycleCallbackV2$onPostResumed$2();
    }

    public BtmActivityLifecycleCallbackV2$onPostResumed$2() {
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final String m753invoke() {
        return "first resume";
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        return m753invoke();
    }
}
