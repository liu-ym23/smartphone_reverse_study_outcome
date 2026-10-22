package w20;

import com.bytedance.android.live.browser.jsbridge.base.StartSpeechRecognitionResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import w20.df;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public abstract class t6<P extends df, R extends StartSpeechRecognitionResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    public final void onTerminate() {
    }

    public t6() {
    }

    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PRIVATE;
    }
}
