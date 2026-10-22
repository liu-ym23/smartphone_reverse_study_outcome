package e92;

import androidx.lifecycle.LiveData;
import com.bytedance.android.live.core.utils.a0;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.interactivity.medialink.ui.MediaMultiAnchorWindowV2;
import com.bytedance.android.livesdk.interactivity.medialink.ui.window.MediaMultiLinkAnchorWindowManager;
import com.bytedance.android.livesdk.interactivity.medialink.ui.window.UILayout;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class m {
    public static final UILayout a() {
        x82.e.A2.getClass();
        x82.e r0 = x82.e.a.a();
        if (r0 == null) goto L7;
        UILayout r1 = r0.getUILayout();
        if (r1 == null) goto L7;
        return r1;
    L7:
        return UILayout.Normal;
    }

    public static final long b() {
        ey.g.a.getClass();
        nc0.b r0 = ey.g.a.a();
        if (r0 == null) goto L9;
        LiveData r1 = r0.c();
        if (r1 == null) goto L9;
        ey.f r2 = (ey.f) r1.getValue();
        if (r2 == null) goto L9;
        return r2.a;
    L9:
        return 0;
    }

    public static final boolean d() {
        com.bytedance.android.livesdk.interactivity.medialink.contract.a.Q0.getClass();
        com.bytedance.android.livesdk.interactivity.medialink.contract.a r0 = com.bytedance.android.livesdk.interactivity.medialink.contract.a.C0183a.a();
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.k0(256) != true) goto L7;
        return true;
    }

    public static final int h() {
        x82.b.u2.getClass();
        x82.b r0 = x82.b.a.a();
        if (r0 == null) goto L9;
        MediaMultiLinkAnchorWindowManager r1 = r0.yn();
        if (r1 == null) goto L9;
        ArrayList<MediaMultiAnchorWindowV2> r2 = r1.b;
        if (r2 == null) goto L9;
        return r2.size();
    L9:
        return 0;
    }

    public static final boolean c() {
        if (d() == true) goto L14;
        com.bytedance.android.livesdk.interactivity.medialink.contract.a.Q0.getClass();
        com.bytedance.android.livesdk.interactivity.medialink.contract.a r0 = com.bytedance.android.livesdk.interactivity.medialink.contract.a.C0183a.a();
        if (r0 != null) goto L7;
    L9:
        boolean r1 = false;
    L10:
        if (r1 == true) goto L15;
        return false;
    L15:
        return true;
    L7:
        if (r0.k0(4) != true) goto L9;
        r1 = true;
        goto L10
    L14:
        return true;
    }

    public static boolean e() {
        String r0 = ey.c.b();
        Intrinsics.checkNotNullParameter(r0, "uid");
        x82.a.t2.getClass();
        x82.a r1 = x82.a.C0295a.a();
        if (r1 != null) goto L7;
        return false;
    L7:
        return r1.N(r0);
    }

    public static final boolean f() {
        String r0 = ey.c.b();
        String r5 = null;
        RoomContext r1 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r1 == null) goto L10;
        com.bytedance.live.datacontext.m r2 = r1.getRoom();
        if (r2 == null) goto L10;
        Room r3 = (Room) r2.getValue();
        if (r3 == null) goto L10;
        r5 = r3.getOwnerUserIdString();
    L10:
        return Intrinsics.areEqual(r0, r5);
    }

    public static final boolean g(DataCenter r1) {
        String r0 = ey.c.b();
        if (r1 == null) goto L7;
        IRoom r2 = a0.o(r1);
        if (r2 == null) goto L7;
        String r3 = r2.getOwnerUserIdString();
    L9:
        return Intrinsics.areEqual(r0, r3);
    L7:
        r3 = null;
        goto L9
    }
}
