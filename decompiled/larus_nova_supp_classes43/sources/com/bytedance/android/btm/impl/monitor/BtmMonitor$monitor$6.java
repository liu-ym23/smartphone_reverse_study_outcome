package com.bytedance.android.btm.impl.monitor;

import com.byted.cast.sink.api.IAPI;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "Lorg/json/JSONObject;", "<anonymous parameter 1>", "", "invoke"}, k = 3, mv = {1, 1, IAPI.OPTION_PLAYER_TYPE})
final class BtmMonitor$monitor$6 extends Lambda implements Function2<JSONObject, String, Unit> {
    public static final BtmMonitor$monitor$6 INSTANCE = null;

    static {
        INSTANCE = new BtmMonitor$monitor$6();
    }

    public BtmMonitor$monitor$6() {
        super(2);
    }

    public final void invoke(JSONObject r1, String r10) {
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r10) {
        invoke((JSONObject) r1, (String) r10);
        return Unit.INSTANCE;
    }
}
