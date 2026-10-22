package com.bytedance.android.live.liveinteract.digitavatar;

import com.bytedance.android.live.network.annotation.PbRequest;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class n {
    public boolean a;
    public AvatarGender b;
    public boolean c;
    public String d;
    public boolean e;
    public long f;

    public n() {
        this(false, null, null, 63);
    }

    public final boolean b() {
        String r0 = this.d;
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L11;
        return false;
    L11:
        if ((!Intrinsics.areEqual("{}", this.d)) == false) goto L15;
        return true;
    L15:
        return false;
    L5:
        if (r0.length() == 0) goto L8;
        r1 = false;
        goto L9
    }

    public final String toString() {
        return "defaultAvatar:" + this.a + ", gender=" + this.b + ", audited=" + this.e + " auditOk=" + this.c + ",avatarData=" + this.d + ", auditId=" + this.f;
    }

    public final void a(n r3) {
        Intrinsics.checkNotNullParameter(r3, PbRequest.SwitchType.OTHER);
        this.a = r3.a;
        this.c = r3.c;
        this.d = r3.d;
        this.e = r3.e;
        this.b = r3.b;
        this.f = r3.f;
    }

    public n(boolean r2, AvatarGender r3, String r4, int r5) {
        if ((r5 & 1) == 0) goto L6;
        r2 = true;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = AvatarGender.Male;
    L9:
        if ((r5 & 8) == 0) goto L11;
        r4 = null;
    L11:
        Intrinsics.checkNotNullParameter(r3, "gender");
        this.a = r2;
        this.b = r3;
        this.c = false;
        this.d = r4;
        this.e = false;
        this.f = 0;
    }
}
