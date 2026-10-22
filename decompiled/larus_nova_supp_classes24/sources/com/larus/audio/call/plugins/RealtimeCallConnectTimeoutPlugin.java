package com.larus.audio.call.plugins;

import com.larus.audio.call.mgr.MajorState;
import com.larus.im.service.audio.AudioSessionType;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public class RealtimeCallConnectTimeoutPlugin extends com.larus.audio.call.arch.a<com.larus.audio.call.arch.c> {
    public final float f;
    public final String g;
    public Job h;
    public volatile boolean i;
    public Job j;

    public static final class a implements com.larus.audio.call.mgr.f.a {
        public final /* synthetic */ RealtimeCallConnectTimeoutPlugin a;

        public a(RealtimeCallConnectTimeoutPlugin r1) {
            this.a = r1;
        }

        @Override // com.larus.audio.call.mgr.f.a
        public final void Q(MajorState r2, MajorState r3) {
            Intrinsics.checkNotNullParameter(r2, "prev");
            Intrinsics.checkNotNullParameter(r3, "current");
            if (this.a.k3() == false) goto L6;
            return;
        L6:
            if ((r3 instanceof MajorState.a) == false) goto L8;
            this.a.l3();
            return;
        L8:
            this.a.j3(r3);
        }
    }

    public final void l3() {
        Job r0 = null;
        j3(null);
        com.larus.audio.call.util.e r1 = com.larus.audio.call.util.e.a;
        r1.i(this.g, "startTimeoutCheckJob");
        if (this.i == true) goto L6;
        r1.i(this.g, "not first connect, skip");
    L6:
        if (this.i == true) goto L8;
        return;
    L8:
        CoroutineScope r2 = getContext().r();
        if (r2 == null) goto L11;
        r0 = BuildersKt.launch$default(r2, Dispatchers.getIO(), null, new RealtimeCallConnectTimeoutPlugin$startTimeoutCheckJob$1(this, null), 2, null);
    L11:
        this.h = r0;
    }

    @Override // com.larus.audio.call.arch.a
    public com.larus.audio.call.mgr.f.a P2() {
        if (com.larus.audio.call.f.f() == false) goto L11;
        Job r0 = this.j;
        if (r0 != null) goto L7;
    L8:
        this.j = U2(new RealtimeCallConnectTimeoutPlugin$createCallStateObserver$1(this, null));
    L9:
        return null;
    L7:
        if (r0.isActive() == true) goto L9;
    L11:
        return new a(this);
    }

    @Override // com.larus.audio.call.arch.a
    public final void g3() {
        super.g3();
        com.larus.audio.call.util.e.a.w(this.g, "stop, reset flag");
        this.i = true;
    }

    public final boolean k3() {
        if (getContext().params().s != AudioSessionType.SAMI) goto L5;
    L8:
        return true;
    L5:
        if (this.f <= 0.0f) goto L8;
        return false;
    }

    @Override // com.larus.audio.call.arch.a
    public final String T2() {
        return this.g;
    }

    public final void j3(MajorState r6) {
        if (this.h != null) goto L5;
        return;
    L5:
        com.larus.audio.call.util.e r0 = com.larus.audio.call.util.e.a;
        String r1 = this.g;
        StringBuilder r2 = new StringBuilder("cancelTimeoutCheckJob, isActive: ");
        Job r3 = this.h;
        if (r3 == null) goto L8;
        Boolean r4 = Boolean.valueOf(r3.isActive());
    L9:
        r2.append(r4);
        r2.append(", isCompleted: ");
        Job r5 = this.h;
        if (r5 == null) goto L12;
        Boolean r7 = Boolean.valueOf(r5.isCompleted());
    L13:
        r2.append(r7);
        r2.append(" current: ");
        if (r6 == null) goto L16;
        String r8 = r6.b;
    L17:
        r2.append(r8);
        r0.i(r1, r2.toString());
        Job r9 = this.h;
        boolean r10 = false;
        if (r9 != null) goto L20;
    L22:
        if (r10 == false) goto L26;
        Job r11 = this.h;
        if (r11 == null) goto L26;
        Job.DefaultImpls.cancel$default(r11, null, 1, null);
    L26:
        this.h = null;
        return;
    L20:
        if (r9.isActive() != true) goto L22;
        r10 = true;
        goto L22
    L16:
        r8 = null;
        goto L17
    L12:
        r7 = null;
        goto L13
    L8:
        r4 = null;
        goto L9
    }

    public RealtimeCallConnectTimeoutPlugin(com.larus.audio.call.arch.c r4, float r5) {
        Intrinsics.checkNotNullParameter(r4, "context");
        super(r4);
        this.f = r5;
        this.g = "RealtimeCallConnectTimeoutPlugin";
        this.i = true;
        com.larus.audio.call.util.e.a.i("RealtimeCallConnectTimeoutPlugin", "rtcConnectingTimeLimit = " + r5);
    }
}
