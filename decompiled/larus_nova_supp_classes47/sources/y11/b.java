package y11;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.revlink.impl.multianchor.utils.b0;
import com.bytedance.android.livesdk.link.model.bridge.k;
import com.bytedance.android.livesdk.link.model.p;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b implements a {
    public final com.bytedance.android.live.revlink.impl.global.c a;
    public final x11.a b;

    public final String b() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.a;
        if (r0 == null) goto L5;
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r1 = r0.Ig();
    L6:
        if (r1 != null) goto L8;
        return null;
    L8:
        return r1.getTeamModeStr();
    L5:
        r1 = null;
        goto L6
    }

    public final String c() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.a;
        if (r0 == null) goto L5;
        b0 r1 = r0.Tj();
    L6:
        if (r1 == null) goto L11;
        com.bytedance.android.live.revlink.impl.mergepk.pkmulti.b r2 = r1.a();
        if (r2 == null) goto L11;
        String r3 = r2.getInviteModeStatus();
        if (r3 == null) goto L11;
        return r3;
    L11:
        return "";
    L5:
        r1 = null;
        goto L6
    }

    public final List<k> d() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.a;
        if (r0 == null) goto L5;
        com.bytedance.android.live.revlink.impl.multianchor.service.d r1 = r0.R8();
    L6:
        if (r1 != null) goto L10;
        return new ArrayList();
    L10:
        return r1.getLinkUserCenter().getOnlineUserList();
    L5:
        r1 = null;
        goto L6
    }

    public final boolean e() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.a;
        com.bytedance.android.live.revlink.impl.mergepk.pkmulti.b r1 = null;
        if (r0 == null) goto L5;
        b0 r2 = r0.Tj();
    L6:
        if (r2 == null) goto L16;
        com.bytedance.android.live.revlink.impl.mergepk.pkmulti.b r3 = r2.a();
        if ((r3 instanceof p11.g) == false) goto L11;
        r1 = r3;
    L11:
        p11.g r4 = (p11.g) r1;
        if (r4 == null) goto L16;
        if (r4.isMultiPk() != true) goto L16;
        return true;
    L16:
        return false;
    L5:
        r2 = null;
        goto L6
    }

    @Override // y11.a
    public final int g() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.a;
        if (r0 == null) goto L5;
        com.bytedance.android.live.revlink.impl.multianchor.service.d r1 = r0.R8();
    L7:
        if (r1 != null) goto L9;
        return 0;
    L9:
        i11.b r2 = r1.getLinkUserCenter();
        if (r2.getOnlineUserList().isEmpty() == false) goto L13;
        return 0;
    L13:
        return r2.getOnlineUserList().size();
    L5:
        r1 = null;
        goto L7
    }

    @Override // y11.a
    public final boolean a(String r3) {
        if (r3 != null) goto L6;
        return false;
    L6:
        if (f(7, r3) == false) goto L8;
    L9:
        return true;
    L8:
        if (f(14, r3) == true) goto L9;
        return false;
    }

    public b(com.bytedance.android.live.revlink.impl.global.c r2, x11.a r3) {
        Intrinsics.checkNotNullParameter(r3, "internalLinkService");
        this.a = r2;
        this.b = r3;
    }

    public final boolean f(int r5, String r6) {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.a;
        if (r0 == null) goto L5;
        com.bytedance.android.live.revlink.impl.multianchor.service.d r1 = r0.R8();
    L6:
        if (r1 != null) goto L9;
    L10:
        i11.b r7 = null;
    L13:
        if (r7 != null) goto L16;
        return false;
    L16:
        if (r7.getOnlineUserList().isEmpty() == false) goto L18;
        return false;
    L18:
        Iterator<p> r8 = r7.getOnlineUserList().iterator();
    L20:
        if (r8.hasNext() == false) goto L31;
        p r2 = r8.next();
        if (r2.getUser() == null) goto L20;
        IBaseUser r3 = r2.getUser();
        if (r3 == null) goto L26;
        String r4 = r3.getIdString();
    L28:
        if (Intrinsics.areEqual(r4, r6) == false) goto L20;
        return true;
    L26:
        r4 = null;
        goto L28
    L31:
        return false;
    L9:
        if (r5 != 7) goto L10;
        r7 = r1.getLinkUserCenter();
        goto L13
    L5:
        r1 = null;
        goto L6
    }
}
