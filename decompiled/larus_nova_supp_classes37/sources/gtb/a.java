package gtb;

import android.os.Bundle;
import com.ss.android.lark.officesdk.api.base.IOfficeSDKProtocol;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public interface a extends IOfficeSDKProtocol {
    void flush();

    void onEventV3(String r1, Bundle r2);

    void onEventV3(String r1, JSONObject r2);

    void onMiscEvent(String r1, JSONObject r2);
}
