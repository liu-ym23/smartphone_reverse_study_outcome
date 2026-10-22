package com.bytedance.android.live.broadcastgame.opengame.openapi;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 3})
final class NetworkRequestMethod$onResponseSuccess$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ String $data;
    final /* synthetic */ JSONObject $header;
    final /* synthetic */ int $statusCode;
    final /* synthetic */ NetworkRequestMethod this$0;

    public NetworkRequestMethod$onResponseSuccess$1(NetworkRequestMethod r1, int r2, JSONObject r3, String r4) {
        this.this$0 = r1;
        this.$statusCode = r2;
        this.$header = r3;
        this.$data = r4;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m247invoke() {
        JSONObject r0 = new JSONObject();
        r0.put("statusCode", this.$statusCode);
        r0.put("header", this.$header);
        NetworkRequestMethod r1 = this.this$0;
        r0.put("data", this.$data);
        Unit r2 = Unit.INSTANCE;
        r1.r(r0);
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m247invoke();
        return Unit.INSTANCE;
    }
}
