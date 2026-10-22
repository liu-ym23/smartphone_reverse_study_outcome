package com.bytedance.android.livesdk.chatroom.utils;

import com.bytedance.android.livesdk.vscore_api.multicamera.IMultiCameraView;
import com.bytedance.android.livesdkapi.depend.model.live.episode.VSCameraInfo;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class u4 implements dq1.d {
    public final /* synthetic */ Function0 a;
    public final /* synthetic */ Function0 b;
    public final /* synthetic */ Function0 c;

    @Override // dq1.d
    public final boolean g1() {
        com.bytedance.android.live.room.h r0 = (com.bytedance.android.live.room.h) this.a.invoke();
        if (r0 != null) goto L7;
        return true;
    L7:
        return r0.g1();
    }

    @Override // dq1.d
    public final void y6() {
        this.c.invoke();
    }

    @Override // dq1.d
    public final void x6(VSCameraInfo r2, boolean r3) {
        gs0.c r0 = (gs0.c) this.b.invoke();
        if (r0 == null) goto L6;
        r0.x6(r2, r3);
        return;
    }

    public u4(fk1.r r1, fk1.s r2, fk1.c r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // dq1.d
    public final void Ma(boolean r3, boolean r4, IMultiCameraView.Source r5) {
        Intrinsics.checkNotNullParameter(r5, "source");
        Object r0 = this.a.invoke();
        if ((r0 instanceof IMultiCameraView) == true) goto L5;
        r0 = null;
    L5:
        IMultiCameraView r1 = (IMultiCameraView) r0;
        if (r1 == null) goto L9;
        r1.Ma(r3, r4, r5);
        return;
    }

    @Override // dq1.d
    public final void X5(boolean r3, boolean r4, IMultiCameraView.Source r5) {
        Intrinsics.checkNotNullParameter(r5, "source");
        Object r0 = this.a.invoke();
        if ((r0 instanceof IMultiCameraView) == true) goto L5;
        r0 = null;
    L5:
        IMultiCameraView r1 = (IMultiCameraView) r0;
        if (r1 == null) goto L9;
        r1.X5(r3, r4, r5);
        return;
    }

    @Override // dq1.d
    public final void a4(VSCameraInfo r2, boolean r3, boolean r4, boolean r5) {
        gs0.c r0 = (gs0.c) this.b.invoke();
        if (r0 == null) goto L6;
        r0.a4(r2, r3, r4, r5);
        return;
    }
}
