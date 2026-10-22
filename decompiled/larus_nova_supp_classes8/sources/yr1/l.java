package yr1;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import com.bytedance.android.live.base.model.user.IBaseUser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public interface l {
    com.bytedance.android.livesdk.chatroom.vs_host.business.q a(Activity r1, String r2, String r3, IBaseUser r4, long r5, boolean r7);

    void c(IBaseUser r1, boolean r2);

    com.bytedance.android.livesdk.chatroom.vs_host.business.r d();

    boolean f(Integer r1, String r2);

    void showManagePoiDialog(Context r1, boolean r2, long r3, DialogInterface.OnDismissListener r5);

    void showPoiInfoDialogForAudience(Context r1, String r2, String r3, String r4);
}
