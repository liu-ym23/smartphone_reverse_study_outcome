package q82;

import com.bytedance.android.livesdk.interactivity.jsb.ImageRecognitionResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import q82.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public abstract class a<P extends d, R extends ImageRecognitionResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    public final void onTerminate() {
    }

    public a() {
    }

    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PRIVATE;
    }
}
