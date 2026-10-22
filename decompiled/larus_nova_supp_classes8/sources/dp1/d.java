package dp1;

import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.interact_tools.IInteractToolsRetrofitApi;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.live.datacontext.m;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class d {
    public static void a(String r5) {
        Intrinsics.checkNotNullParameter(r5, "pluginId");
        RoomContext r0 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r0 == null) goto L10;
        m r1 = r0.getRoom();
        if (r1 == null) goto L11;
        Room r2 = (Room) r1.getValue();
        if (r2 == null) goto L12;
        long r3 = r2.getRoomId();
        ((IInteractToolsRetrofitApi) com.bytedance.android.live.network.c.b().e(IInteractToolsRetrofitApi.class)).reportHistory(r5, r3, 2).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(b.a, c.a);
        return;
    L12:
        return;
    L11:
        return;
    }
}
