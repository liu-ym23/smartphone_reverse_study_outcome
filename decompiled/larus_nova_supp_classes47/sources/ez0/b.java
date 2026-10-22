package ez0;

import com.bytedance.android.live.revenue.platform.interacteffect.api.MessageType;
import com.bytedance.android.live.revenue.platform.interacteffect.api.Scene;
import io.reactivex.Observable;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public interface b extends dy0.a {
    void Vf(MessageType r1, Scene r2, int r3, String r4);

    Observable<a> observeEffectMessage();

    Observable<JSONObject> observeGiftMsgContent();

    void p2(JSONObject r1);
}
