package n62;

import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.livehostapi.business.depend.share.ShareOutsideDialogParam;
import com.bytedance.android.livehostapi.business.depend.share.ShareParams;
import com.bytedance.android.livehostapi.business.depend.share.ShareScene;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.interactivity.api.chatchannel.model.ChannelInviteMessageItem;
import com.bytedance.android.livesdk.log.filter.n;
import com.bytedance.android.livesdk.log.filter.o;
import com.bytedance.android.livesdk.log.filter.s0;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.ShareResource;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public abstract class a {
    public static boolean d;
    public static boolean e;
    public Disposable a;
    public Disposable b;
    public final RoomContext c;

    /* JADX INFO: renamed from: n62.a$a, reason: collision with other inner class name */
    public static final class C0254a {
    }

    static {
    }

    public a(RoomContext r2) {
        Intrinsics.checkNotNullParameter(r2, "roomContext");
        this.c = r2;
    }

    public static void b(s22.e r5, s22.a r6, List r7) {
        Intrinsics.checkNotNullParameter(r5, "chatManager");
        Intrinsics.checkNotNullParameter(r6, "channel");
        if (r7 != null) goto L5;
        return;
    L5:
        List r8 = CollectionsKt.take(r7, 3);
        ArrayList r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r8, 10));
        Iterator r9 = r8.iterator();
    L7:
        if (r9.hasNext() == false) goto L13;
        com.bytedance.android.live.base.model.user.f r1 = (com.bytedance.android.live.base.model.user.f) r9.next();
        ChannelInviteMessageItem r2 = new ChannelInviteMessageItem();
        r1.getClass();
        Long r3 = StringsKt.toLongOrNull(null);
        if (r3 == null) goto L11;
        long r4 = r3.longValue();
    L12:
        r2.id = r4;
        r2.name = null;
        r2.type = 2;
        r0.add(r2);
        goto L7
    L11:
        r4 = 0;
        goto L12
    L13:
        List<? extends ChannelInviteMessageItem> r10 = CollectionsKt.toList(r0);
        r5.notifyInviteResult(r6.getChannelId(), r10);
    }

    public final ShareParams a(int r5, long r6, String r8) {
        Intrinsics.checkNotNullParameter(r8, "shareText");
        Room r0 = (Room) this.c.getRoom().getValue();
        boolean r2 = false;
        ShareParams.Builder r7 = ShareParams.buildUponRoom(r0).setAnchor(false).setInviteId(r6);
        if (r8.length() <= 0) goto L5;
        r2 = true;
    L5:
        if (r2 == false) goto L7;
        r7.setDescription(r8);
    L7:
        r7.setShareScene(ShareScene.LIVE);
        r7.setRoomId(r0.id);
        HashMap r9 = new HashMap();
        o r10 = u.l().c(n.class);
        if (r10 == null) goto L12;
        Map r11 = r10.getMap();
        if (r11 == null) goto L12;
        r9.putAll(r11);
    L12:
        o r13 = u.l().c(Room.class);
        ImageModel r3 = null;
        if ((r13 instanceof s0) == true) goto L15;
        r13 = null;
    L15:
        s0 r14 = (s0) r13;
        if (r14 == null) goto L20;
        Map r15 = ((com.bytedance.android.livesdk.log.filter.a) r14).b;
        if (r15 == null) goto L20;
        r9.putAll(r15);
    L20:
        Unit r16 = Unit.INSTANCE;
        r7.setActivityInfo(r9);
        ShareOutsideDialogParam r17 = new ShareOutsideDialogParam();
        ShareResource r18 = r0.shareResource;
        if (r18 == null) goto L23;
        r3 = r18.getToastBackground();
    L23:
        r17.setToastBackground(r3);
        r7.setCustomCommandDialogParam(r17);
        r7.setShareConfigId("18109");
        HashMap r19 = new HashMap();
        r19.put("room_type", String.valueOf(r5));
        r7.setExtraParams(r19);
        r7.setIsNewLiveChannel(true);
        r7.getExtras().putInt("aweType", 2104);
        return r7.build();
    }
}
