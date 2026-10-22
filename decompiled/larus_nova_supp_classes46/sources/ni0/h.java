package ni0;

import android.content.Context;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.liveinteract.api.utils.m;
import com.bytedance.android.live.liveinteract.revenue.game.api.LinkMicGameApi;
import com.bytedance.android.livehostapi.business.IMiddlewareHostSocial;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class h implements IMiddlewareHostSocial.ICommonInviteParams.IClickCallback {
    public final /* synthetic */ e a;
    public final /* synthetic */ Context b;

    public final void onInvite(List<IMiddlewareHostSocial.ICommonInviteParams.ISelectedContact> r8) {
        ALogger.i("GroupLiveGameInviteUtils", "onInvite: " + r8);
        e r0 = this.a;
        Context r2 = this.b;
        r0.getClass();
        o r1 = m.i();
        if (r1 == null) goto L9;
        com.bytedance.live.datacontext.m r3 = r1.getRoom();
        if (r3 == null) goto L9;
        IRoom r4 = (IRoom) r3.getValue();
        if (r4 == null) goto L9;
        long r5 = r4.getRoomId();
    L10:
        if (r8 == null) goto L16;
        List<IMiddlewareHostSocial.ICommonInviteParams.ISelectedContact> r6 = r8;
        ArrayList r7 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r6, 10));
        Iterator<T> r9 = r6.iterator();
    L13:
        if (r9.hasNext() == false) goto L15;
        r7.add(((IMiddlewareHostSocial.ICommonInviteParams.ISelectedContact) r9.next()).getUid());
        goto L13
    L15:
        String r10 = r7.toString();
    L17:
        ALogger.i("GroupLiveGameInviteUtils", "inviteFriends, roomId: " + r5 + ", toUserIds: " + r10);
        if (r10 == null) goto L24;
        if (r8 != null) goto L21;
    L23:
        RxUtilKt.i(((LinkMicGameApi) com.bytedance.android.live.network.c.b().e(LinkMicGameApi.class)).groupLiveGameInviteFriend(r5, r10)).subscribe(f.a, new g(r2));
        return;
    L21:
        if (r8.isEmpty() != true) goto L23;
    L24:
        ALogger.e("GroupLiveGameInviteUtils", "inviteFriends return, cause: toUserIds is null");
        return;
    L16:
        r10 = null;
    L9:
        r5 = 0;
        goto L10
    }

    public h(e r1, Context r2) {
        this.a = r1;
        this.b = r2;
    }
}
