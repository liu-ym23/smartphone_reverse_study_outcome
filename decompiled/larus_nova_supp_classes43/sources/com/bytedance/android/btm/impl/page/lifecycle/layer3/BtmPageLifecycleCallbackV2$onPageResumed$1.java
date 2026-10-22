package com.bytedance.android.btm.impl.page.lifecycle.layer3;

import com.byted.cast.sink.api.IAPI;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lorg/json/JSONObject;", "invoke"}, k = 3, mv = {1, 1, IAPI.OPTION_PLAYER_TYPE})
public final class BtmPageLifecycleCallbackV2$onPageResumed$1 extends Lambda implements Function1<JSONObject, Unit> {
    public static final BtmPageLifecycleCallbackV2$onPageResumed$1 INSTANCE = null;

    static {
        INSTANCE = new BtmPageLifecycleCallbackV2$onPageResumed$1();
    }

    public BtmPageLifecycleCallbackV2$onPageResumed$1() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((JSONObject) r1);
        return Unit.INSTANCE;
    }

    public final void invoke(JSONObject r10) {
        r10.put("type", "onPageResumed_Not_Null");
    }
}
