package vv0;

import com.bytedance.android.livesdk.config.im;
import com.bytedance.android.livesdkapi.model.AnchorVStreamPerfConfig;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class f {
    public final List<JSONObject> a;
    public final int b;

    public f() {
        this.a = new ArrayList();
        this.b = ((AnchorVStreamPerfConfig) im.a.getValue()).getRealCalTimes();
    }
}
