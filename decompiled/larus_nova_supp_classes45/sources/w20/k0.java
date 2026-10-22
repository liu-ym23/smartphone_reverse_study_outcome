package w20;

import com.bytedance.android.live.browser.jsbridge.base.CropAndUploadEmojiResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import w20.q8;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public abstract class k0<P extends q8, R extends CropAndUploadEmojiResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    public final void onTerminate() {
    }

    public k0() {
    }

    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PRIVATE;
    }
}
