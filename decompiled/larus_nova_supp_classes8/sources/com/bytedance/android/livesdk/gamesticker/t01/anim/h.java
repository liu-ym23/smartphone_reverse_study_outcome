package com.bytedance.android.livesdk.gamesticker.t01.anim;

import android.view.View;
import com.bytedance.android.livesdk.chatroom.model.r3;
import com.bytedance.android.livesdk.chatroom.model.t3;
import com.bytedance.android.livesdk.gamesticker.t01.T01GameLiveView;
import com.bytedance.android.livesdk.gamesticker.t01.T01GameRoleView;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class h extends b {
    public final t3 d;
    public final List<r3> e;

    @Override // com.bytedance.android.livesdk.gamesticker.t01.anim.b
    public final void a() {
    }

    @Override // com.bytedance.android.livesdk.gamesticker.t01.anim.b
    public final String e() {
        return "UpdateInfoTask";
    }

    @Override // com.bytedance.android.livesdk.gamesticker.t01.anim.b
    public final void d() {
        c(TaskState.START);
        i r0 = this.c;
        if (r0 == null) goto L12;
        ((T01GameRoleView) f(new T01GameRoleView[]{r0.d(), r0.a()}, r0.d())).setRoleInfo(this.d);
        T01GameLiveView r1 = (T01GameLiveView) f(new T01GameLiveView[]{r0.c(), r0.b()}, r0.c());
        Iterator<r3> r2 = this.e.iterator();
    L6:
        if (r2.hasNext() == false) goto L12;
        r3 r3 = r2.next();
        r3 r4 = r1.getLiveInfo();
        if (r4 == null) goto L6;
        if (r4.a() != r3.a()) goto L6;
        b("updateLiveInfoView index " + r3.a());
        r1.setLiveInfo(r3);
    L12:
        c(TaskState.END);
    }

    public h(t3 r2, List<r3> r3) {
        Intrinsics.checkNotNullParameter(r2, "roleInfo");
        Intrinsics.checkNotNullParameter(r3, "liveInfos");
        this.d = r2;
        this.e = r3;
    }

    public static Object f(Object[] r4, Object r5) {
        int r1 = 0;
        if (r4.length != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return r5;
    L8:
        int r2 = r4.length;
    L9:
        if (r1 >= r2) goto L16;
        Object r3 = r4[r1];
        if ((r3 instanceof View) == false) goto L15;
        if (((View) r3).getVisibility() != 0) goto L15;
        return r3;
    L15:
        r1 = r1 + 1;
        goto L9
    L16:
        return r5;
    L5:
        r0 = false;
        goto L6
    }
}
