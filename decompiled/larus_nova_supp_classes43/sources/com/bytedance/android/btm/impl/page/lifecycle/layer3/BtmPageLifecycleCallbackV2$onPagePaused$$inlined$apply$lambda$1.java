package com.bytedance.android.btm.impl.page.lifecycle.layer3;

import com.byted.cast.sink.api.IAPI;
import com.bytedance.android.btm.impl.page.lifecycle.PauseFuncOrigin;
import com.bytedance.android.ec.base.api.ai.AIStateLogRequest;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, d2 = {"<anonymous>", "Lorg/json/JSONObject;", "invoke", "com/bytedance/android/btm/impl/page/lifecycle/layer3/BtmPageLifecycleCallbackV2$onPagePaused$4$1"}, k = 3, mv = {1, 1, IAPI.OPTION_PLAYER_TYPE})
public final class BtmPageLifecycleCallbackV2$onPagePaused$$inlined$apply$lambda$1 extends Lambda implements Function0<JSONObject> {
    final /* synthetic */ boolean $isForward;
    final /* synthetic */ Object $page$inlined;
    final /* synthetic */ String $pageClassName$inlined;
    final /* synthetic */ PauseFuncOrigin $pauseFuncOrigin$inlined;
    final /* synthetic */ String $pi;

    public BtmPageLifecycleCallbackV2$onPagePaused$$inlined$apply$lambda$1(boolean r1, String r10, Object r11, PauseFuncOrigin r12, String r13) {
        this.$isForward = r1;
        this.$pi = r10;
        this.$page$inlined = r11;
        this.$pauseFuncOrigin$inlined = r12;
        this.$pageClassName$inlined = r13;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final JSONObject m846invoke() {
        JSONObject r0 = new JSONObject();
        r0.put(AIStateLogRequest.SOURCE_PAGE, this.$pageClassName$inlined);
        r0.put("pauseFuncOrigin", this.$pauseFuncOrigin$inlined);
        r0.put("isForward", this.$isForward);
        r0.put("pausedInfo", this.$pi);
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        return m846invoke();
    }
}
