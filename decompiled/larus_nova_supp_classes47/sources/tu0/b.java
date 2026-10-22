package tu0;

import com.bytedance.android.live.profit.player.jsb.DressPlayFinishResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import com.bytedance.ies.web.jsbridge2.f;
import tu0.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public abstract class b<P extends d, R extends DressPlayFinishResultModel> extends f<P, R> {
    public final void onTerminate() {
    }

    public b() {
    }

    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PRIVATE;
    }
}
