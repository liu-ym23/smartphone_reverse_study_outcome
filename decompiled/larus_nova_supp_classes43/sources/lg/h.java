package lg;

import com.bytedance.android.ec.core.apt.APTNodeType;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class h extends b {
    public final int a;

    @Override // lg.b
    public int getType() {
        return this.a;
    }

    public h(String r10, JSONObject r11) {
        Intrinsics.checkNotNullParameter(r10, "eventName");
        this.a = APTNodeType.EVENT.getValue();
        JSONObject r0 = new JSONObject();
        r0.put("event_name", r10);
        r0.put("event_params", r11);
        Unit r12 = Unit.INSTANCE;
    }
}
