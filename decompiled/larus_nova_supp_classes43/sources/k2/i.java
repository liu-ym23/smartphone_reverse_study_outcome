package k2;

import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public interface i extends u4.a, h, o {
    String getAppletId();

    String getBotId();

    HashMap<String, Object> getEventCommonParams();

    String getPageID();

    void onDestroy();

    void onHide();

    void onHostDestroy();

    void onHostHide();

    void onHostShow();

    void onShow();

    void onViewError(String r1);

    void onViewFinish(String r1);

    void onViewStart(String r1);

    void setEventCommonParams(HashMap<String, Object> r1);
}
