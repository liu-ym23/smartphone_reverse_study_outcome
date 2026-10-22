package com.bytedance.android.live.liveinteract.videolink;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.o;
import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomBase;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a {
    public int a;
    public int b;
    public boolean c;
    public long d;
    public Integer e;
    public boolean f;
    public final IRoomBase g;
    public final IBaseUser h;
    public final int i;

    public final String a() {
        String r0 = o.a(this.h);
        if (r0 != null) goto L6;
        return "";
    L6:
        return r0;
    }

    public final String b() {
        IBaseUser r0 = this.h;
        if (r0 != null) goto L7;
        return "";
    L7:
        return r0.getIdString();
    }

    public final String toString() {
        StringBuilder r0 = new StringBuilder("InviteAudienceParams{, user=");
        IBaseUser r1 = this.h;
        if (r1 != null) goto L5;
        String r2 = "null";
    L6:
        r0.append(r2);
        r0.append(", position=");
        r0.append(this.i);
        r0.append(", teamId=");
        r0.append(this.b);
        r0.append(", fromList=");
        r0.append(this.c);
        r0.append(", messageBoardItemId=");
        r0.append(this.d);
        r0.append(", inviteSource=");
        r0.append(this.e);
        r0.append('}');
        return r0.toString();
    L5:
        r2 = r1.getIdString();
        goto L6
    }

    public a(IRoomBase r2, IBaseUser r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, PbRequest.SwitchType.ROOM);
        Intrinsics.checkNotNullParameter(r3, "user");
        this.g = r2;
        this.h = r3;
        this.i = r4;
        this.f = true;
    }
}
