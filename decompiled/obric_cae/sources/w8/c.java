package w8;

import android.content.Context;
import java.util.ArrayList;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public interface c {
    int getAppId();

    String[] getConfigServers();

    Context getContext();

    ArrayList<String> getCookieFlushPathList();

    String getHostSuffix();

    int getProviderInt(Context r8, String r10, int r11);

    String getProviderString(Context r8, String r10, String r11);

    String getShareCookieMainDomain();

    Map<String, String> getTTNetServiceDomainMap();

    boolean isCronetPluginInstalled();

    boolean isPrivateApiAccessEnabled();

    void mobOnEvent(Context r8, String r10, String r11, JSONObject r12);

    void monitorLogSend(String r8, JSONObject r10);

    @Deprecated
    void onAppConfigUpdated(Context r8, JSONObject r10);

    void onColdStartFinish();

    void onShareCookieConfigUpdated(String r8);

    void saveMapToProvider(Context r8, Map<String, ?> r10);
}
