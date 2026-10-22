package r12;

import com.bytedance.android.livesdk.gift.platform.format.jsb.FormatSendGiftResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import r12.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public abstract class a<P extends f, R extends FormatSendGiftResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    public a() {
    }

    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PRIVATE;
    }
}
