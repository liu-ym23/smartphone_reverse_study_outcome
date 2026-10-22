package ko;

import com.lynx.tasm.service.IServiceProvider;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public interface d extends IServiceProvider {
    void reportCrashGlobalContextTag(String r5, String r10);

    void reportImageInfo(k r5);

    void reportImageStatus(String r5, JSONObject r10);
}
