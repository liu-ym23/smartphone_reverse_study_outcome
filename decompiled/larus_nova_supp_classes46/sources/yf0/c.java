package yf0;

import android.app.Activity;
import com.bytedance.android.live.liveinteract.linkpanel.contract.BaseTalkInviteListWidgetContract$View;
import com.bytedance.android.livehostapi.business.IMiddlewareHostSocial;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public abstract class c extends f<BaseTalkInviteListWidgetContract$View> {
    public abstract void d(boolean r1);

    public abstract void e();

    public abstract void f();

    public abstract void g(int r1, List<? extends IMiddlewareHostSocial.InviteFriendsConfig.Friend> r2, Function2<? super List<? extends IMiddlewareHostSocial.InviteFriendsConfig.Friend>, ? super IRoom, Unit> r3);

    public abstract void h(Activity r1);

    public c(BaseTalkInviteListWidgetContract$View r2) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super(r2);
    }
}
