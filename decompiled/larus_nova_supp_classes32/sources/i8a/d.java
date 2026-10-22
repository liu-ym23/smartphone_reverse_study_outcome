package i8a;

import com.lynx.tasm.service.IServiceProvider;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public interface d extends IServiceProvider {
    void reportCrashGlobalContextTag(String r1, String r2);

    void reportImageInfo(j r1);

    void reportImageStatus(String r1, JSONObject r2);
}
