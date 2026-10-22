package com.bytedance.android.btm.impl.startnode;

import com.byted.cast.sink.api.IAPI;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lorg/json/JSONObject;", "invoke"}, k = 3, mv = {1, 1, IAPI.OPTION_PLAYER_TYPE})
final class StartNodeManager$recoveryFromCache$2$1 extends Lambda implements Function0<JSONObject> {
    final /* synthetic */ String $data;

    public StartNodeManager$recoveryFromCache$2$1(String r1) {
        this.$data = r1;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final JSONObject m946invoke() {
        JSONObject r0 = new JSONObject();
        r0.putOpt("data", this.$data);
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        return m946invoke();
    }
}
