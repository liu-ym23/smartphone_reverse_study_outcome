package w20;

import com.bytedance.android.live.browser.jsbridge.base.StopSpeechRecognitionResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import w20.ef;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public abstract class u6<P extends ef, R extends StopSpeechRecognitionResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    public final void onTerminate() {
    }

    public u6() {
    }

    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PRIVATE;
    }
}
