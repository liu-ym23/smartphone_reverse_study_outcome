package w20;

import com.bytedance.android.live.browser.jsbridge.base.LiveSetEffectAudioProcessResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import w20.fb;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public abstract class k3<P extends fb, R extends LiveSetEffectAudioProcessResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    public final void onTerminate() {
    }

    public k3() {
    }

    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PRIVATE;
    }
}
