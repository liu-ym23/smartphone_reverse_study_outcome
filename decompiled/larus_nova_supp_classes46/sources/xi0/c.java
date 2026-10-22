package xi0;

import android.content.Context;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.playmode.AbsPlayModeWidget;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.revenue.linkroomfight.core.LinkRoomFightContext;
import je0.d;
import kotlin.jvm.internal.Intrinsics;
import tf0.p;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c implements com.bytedance.android.live.liveinteract.revenuebase.b {
    public c() {
    }

    @Override // xi0.a
    public final com.bytedance.android.live.liveinteract.multiscene.a L1() {
        com.bytedance.android.live.liveinteract.revenue.linkroomfight.core.b r0 = LinkRoomFightContext.Companion.a();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.L1();
    }

    @Override // xi0.a
    public final boolean r2() {
        com.bytedance.android.live.liveinteract.revenue.linkroomfight.core.b r0 = LinkRoomFightContext.Companion.a();
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.r2();
    }

    @Override // xi0.a
    public final boolean A4() {
        if (d.f() != 16) goto L5;
        boolean r0 = true;
    L6:
        com.bytedance.android.live.liveinteract.revenue.linkroomfight.core.b r2 = LinkRoomFightContext.Companion.a();
        if (r2 == null) goto L9;
        boolean r3 = r2.A4();
    L10:
        if (r0 == false) goto L13;
        if (r3 == false) goto L13;
        return true;
    L13:
        return false;
    L9:
        r3 = true;
        goto L10
    L5:
        r0 = false;
        goto L6
    }

    @Override // xi0.a
    public final boolean isFightShowing() {
        if (d.f() != 16) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L12;
        com.bytedance.android.live.liveinteract.revenue.linkroomfight.core.b r1 = LinkRoomFightContext.Companion.a();
        if (r1 == null) goto L10;
        boolean r2 = r1.isFightShowing();
    L11:
        if (r2 == true) goto L12;
        return false;
    L10:
        r2 = false;
    L12:
        return true;
    L5:
        r0 = false;
        goto L6
    }

    @Override // com.bytedance.android.live.liveinteract.revenuebase.b
    public final yi0.a d(Context r3, ILinkPlayerInfoBridge r4) {
        Intrinsics.checkNotNullParameter(r3, "mContext");
        Intrinsics.checkNotNullParameter(r4, "userInfo");
        yi0.a r0 = new yi0.a(r3, r4, true);
        Intrinsics.checkNotNullParameter("seat", "requestPage");
        return r0;
    }

    @Override // gi0.a
    public final void d0(p r3, Object r4) {
        Intrinsics.checkNotNullParameter(r3, "action");
        Object r0 = LinkRoomFightContext.Companion.a();
        if (r0 != null) goto L5;
        return;
    L5:
        if ((r0 instanceof AbsPlayModeWidget) == true) goto L7;
        r0 = null;
    L7:
        AbsPlayModeWidget r1 = (AbsPlayModeWidget) r0;
        if (r1 == null) goto L14;
        ne0.c r2 = r1.getStore();
        if (r2 == null) goto L15;
        r2.d0(r3, r4);
        return;
    L15:
        return;
    }
}
