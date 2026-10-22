package fi;

import android.content.Context;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public interface b {
    void a(String r1);

    String addCommonParams(String r1);

    void b(Context r1, String r10, String r11, String r12, long r13, JSONObject r14);

    String getSessionKey();

    void onEventV3(String r1, JSONObject r10);
}
