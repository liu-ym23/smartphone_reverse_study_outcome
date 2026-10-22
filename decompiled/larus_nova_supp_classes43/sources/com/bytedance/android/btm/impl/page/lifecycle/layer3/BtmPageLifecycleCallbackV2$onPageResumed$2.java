package com.bytedance.android.btm.impl.page.lifecycle.layer3;

import com.byted.cast.sink.api.IAPI;
import com.bytedance.android.btm.impl.page.lifecycle.ResumeFuncOrigin;
import com.bytedance.android.btm.impl.page.model.PageInfo;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lorg/json/JSONObject;", "invoke"}, k = 3, mv = {1, 1, IAPI.OPTION_PLAYER_TYPE})
public final class BtmPageLifecycleCallbackV2$onPageResumed$2 extends Lambda implements Function0<JSONObject> {
    final /* synthetic */ PageInfo $pi;
    final /* synthetic */ ResumeFuncOrigin $resumeFuncOrigin;

    public BtmPageLifecycleCallbackV2$onPageResumed$2(ResumeFuncOrigin r1, PageInfo r10) {
        this.$resumeFuncOrigin = r1;
        this.$pi = r10;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final JSONObject m848invoke() {
        JSONObject r0 = new JSONObject();
        r0.put("resumeFuncOrigin", this.$resumeFuncOrigin);
        r0.put("pageInfo", this.$pi);
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        return m848invoke();
    }
}
