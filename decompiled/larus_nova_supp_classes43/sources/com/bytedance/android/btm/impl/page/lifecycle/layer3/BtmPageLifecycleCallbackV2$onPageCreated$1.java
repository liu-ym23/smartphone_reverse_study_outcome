package com.bytedance.android.btm.impl.page.lifecycle.layer3;

import com.byted.cast.sink.api.IAPI;
import com.bytedance.android.btm.api.PageProp;
import com.bytedance.android.btm.impl.page.model.PageInfoStack;
import com.bytedance.android.ec.base.api.ai.AIStateLogRequest;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lorg/json/JSONObject;", "invoke"}, k = 3, mv = {1, 1, IAPI.OPTION_PLAYER_TYPE})
public final class BtmPageLifecycleCallbackV2$onPageCreated$1 extends Lambda implements Function0<JSONObject> {
    final /* synthetic */ String $pageClassName;
    final /* synthetic */ PageProp $prop;
    final /* synthetic */ PageInfoStack $savedInfoStack;

    public BtmPageLifecycleCallbackV2$onPageCreated$1(String r1, PageProp r10, PageInfoStack r11) {
        this.$pageClassName = r1;
        this.$prop = r10;
        this.$savedInfoStack = r11;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final JSONObject m841invoke() {
        JSONObject r0 = new JSONObject();
        r0.put(AIStateLogRequest.SOURCE_PAGE, this.$pageClassName);
        r0.put("prop", this.$prop.toString());
        r0.put("savedInfoStack", String.valueOf(this.$savedInfoStack));
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        return m841invoke();
    }
}
