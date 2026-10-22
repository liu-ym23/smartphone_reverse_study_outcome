package m8;

import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public interface a {
    String onGetDeviceId();

    String onGetUDID();

    String onGetUserId();

    Map<String, String> onGetXttTokenMap();

    boolean onIsAccountLogin();
}
