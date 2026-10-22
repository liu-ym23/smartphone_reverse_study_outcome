package ni0;

import android.text.TextUtils;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.liveinteract.revenue.game.api.LinkMicGameApi;
import io.reactivex.functions.Consumer;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class f<T> implements Consumer {
    public static final f a = null;

    static {
        a = new f();
    }

    public f() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void accept(Object r5) {
        com.bytedance.android.live.network.response.e r6 = (com.bytedance.android.live.network.response.e) r5;
        ALogger.i("GroupLiveGameInviteUtils", "inviteFriends success, response: " + ((LinkMicGameApi.a) r6.data));
        LinkMicGameApi.a r7 = (LinkMicGameApi.a) r6.data;
        if (r7 != null) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r7.b()) == true) goto L7;
        f2.c(r7.b(), 0);
    L7:
        List<String> r8 = r7.a();
        if (r8 == null) goto L15;
        Iterator<T> r9 = r8.iterator();
    L11:
        if (r9.hasNext() == false) goto L16;
        e.c.put((String) r9.next(), Long.valueOf(System.currentTimeMillis()));
        goto L11
    L16:
        return;
    }
}
