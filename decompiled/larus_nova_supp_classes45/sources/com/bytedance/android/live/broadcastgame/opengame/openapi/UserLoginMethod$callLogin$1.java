package com.bytedance.android.live.broadcastgame.opengame.openapi;

import com.bytedance.android.live.core.log.ALogger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lorg/json/JSONObject;", "invoke"}, k = 3, mv = {1, 4, 3})
final class UserLoginMethod$callLogin$1 extends Lambda implements Function1<JSONObject, Unit> {
    final /* synthetic */ i1 this$0;

    public UserLoginMethod$callLogin$1(i1 r1) {
        this.this$0 = r1;
        super(1);
    }

    public final void invoke(JSONObject r3) {
        Intrinsics.checkNotNullParameter(r3, "it");
        ALogger.i("UserLoginMethod_callLogin", "login success: " + r3);
        this.this$0.r(r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((JSONObject) r1);
        return Unit.INSTANCE;
    }
}
