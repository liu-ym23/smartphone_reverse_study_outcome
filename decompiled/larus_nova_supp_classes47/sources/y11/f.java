package y11;

import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.revlink.impl.LinkCrossRoomDataHolder;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class f implements e {
    public final com.bytedance.android.live.revlink.impl.global.c a;
    public final x11.a b;

    public final long a() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.a;
        if (r0 == null) goto L5;
        LinkCrossRoomDataHolder r1 = r0.getLinkCrossRoomDataHolder();
    L6:
        if (r1 != null) goto L10;
        return 0;
    L10:
        return r1.c();
    L5:
        r1 = null;
        goto L6
    }

    public final String b() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.a;
        if (r0 == null) goto L5;
        com.bytedance.android.live.revlink.impl.service.internal.a r1 = r0.Do();
    L6:
        if (r1 == null) goto L8;
        int r2 = r1.getCurrentMode();
    L10:
        if (com.bytedance.android.live.utils.c.a(r2, 64) == false) goto L14;
        return this.b.mo1159do().c();
    L14:
        if (com.bytedance.android.live.utils.c.a(r2, 4) == true) goto L16;
        return "";
    L16:
        return this.b.getPkService().getInviteModeStatus();
    L8:
        r2 = 0;
        goto L10
    L5:
        r1 = null;
        goto L6
    }

    @Override // y11.e
    public final String getConnectionType() {
        x11.a r0 = this.b;
        int r1 = r0.Dn().a();
        if (com.bytedance.android.live.utils.c.a(r1, 4) == false) goto L8;
        if ((!Intrinsics.areEqual(r0.getPkService().e(), q11.b.C0295b.b)) == false) goto L13;
        return "pk";
    L13:
        return "link";
    L8:
        if (com.bytedance.android.live.utils.c.a(r1, 64) == true) goto L10;
        return "";
    L10:
        if (r0.mo1159do().e() == false) goto L13;
        return "npk";
    }

    @Override // y11.e
    public final String getLinkAnchorCount() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.a;
        if (r0 == null) goto L5;
        com.bytedance.android.live.revlink.impl.service.internal.a r1 = r0.Do();
    L6:
        if (r1 == null) goto L8;
        int r2 = r1.getCurrentMode();
    L10:
        if (com.bytedance.android.live.utils.c.a(r2, 64) == false) goto L13;
        return String.valueOf(this.b.mo1159do().g());
    L13:
        if (com.bytedance.android.live.utils.c.a(r2, 4) == false) goto L15;
        return "2";
    L15:
        return DataType.TRUE;
    L8:
        r2 = 0;
        goto L10
    L5:
        r1 = null;
        goto L6
    }

    public f(com.bytedance.android.live.revlink.impl.global.c r2, x11.a r3) {
        Intrinsics.checkNotNullParameter(r3, "internalLinkService");
        this.a = r2;
        this.b = r3;
    }
}
