package u92;

import com.bytedance.android.live.base.model.message.c4;
import com.bytedance.android.live.broadcastgame.api.interactgame.IMiddlewareInteractGameService;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.api.j;
import com.bytedance.android.livesdk.interactivity.textmessage.model.d0;
import com.bytedance.bdlocation.BuildConfig;
import java.util.Map;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class e implements j {
    public e() {
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.api.j
    public final boolean a(com.bytedance.android.livesdk.interactivity.api.entity.f<?> r8) {
        Intrinsics.checkNotNullParameter(r8, "textMessage");
        IRoomContextService r0 = k.f(IRoomContextService.class);
        Boolean r1 = null;
        if (r0 == null) goto L8;
        o r2 = IRoomContextService.a.a(r0, null, 0, 3);
        if (r2 == null) goto L8;
        r1 = r2.isAnchor();
    L8:
        if (Intrinsics.areEqual(r1, Boolean.TRUE) == false) goto L11;
        return false;
    L11:
        if ((r8 instanceof d0) == true) goto L13;
        return false;
    L13:
        d0 r9 = (d0) r8;
        c4 r3 = r9.b;
        if ((!Intrinsics.areEqual(r3.getBizScene(), "InteractAppStart")) == false) goto L16;
        return false;
    L16:
        Map r4 = r3.getBuriedPoint();
        if (r4 == null) goto L28;
        String r5 = (String) r4.get("app_id");
        if (r5 == null) goto L29;
        IMiddlewareInteractGameService r6 = k.n(IMiddlewareInteractGameService.class);
        int r7 = r6.getEntranceVisibility(r5);
        if (r7 == (-1)) goto L25;
        if (r7 != 0) goto L30;
    L26:
        return true;
    L30:
        return false;
    L25:
        r3.setBizScene(BuildConfig.FLAVOR);
        r6.cacheOpenPlatformMessage(r5, r9.b);
        goto L26
    L29:
        return false;
    L28:
        return false;
    }
}
