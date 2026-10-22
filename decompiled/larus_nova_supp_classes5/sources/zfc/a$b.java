package zfc;

import android.content.Context;
import android.os.Bundle;
import java.util.Map;
import org.json.JSONObject;
import rgc.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public interface a$b extends a {
    void F0();

    void U();

    void V(Bundle r1);

    void W2();

    boolean f();

    Map<String, String> getHttpCommonParams();

    boolean n0();

    void onEvent(Context r1, String r2, String r3, String r4, long r5, long r7, JSONObject r9);

    void onEventV3(String r1, JSONObject r2);
}
