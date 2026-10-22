package fdb;

import android.content.Context;
import com.larksuite.framework.callback.IGetDataCallback;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public interface b {
    void N8();

    int Ue();

    Boolean Y();

    boolean e6(String r1);

    boolean e9(String r1);

    Context getContext();

    String getUserId();

    void ic(Context r1, IGetDataCallback<Map<String, Boolean>> r2);

    int mc();

    void sendEvent(String r1, JSONObject r2);

    void ve(ndb.a r1);
}
