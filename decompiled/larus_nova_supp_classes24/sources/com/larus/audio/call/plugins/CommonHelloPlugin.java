package com.larus.audio.call.plugins;

import com.larus.audio.call.arch.c;
import com.larus.audio.call.mgr.MajorState;
import com.larus.audio.call.mgr.ReducerPosition;
import com.larus.im.service.audio.AudioSessionType;
import com.larus.im.service.audio.cmd.TriggerMode;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public class CommonHelloPlugin<C extends com.larus.audio.call.arch.c> extends com.larus.audio.call.arch.a<C> implements y0 {
    public final String f;
    public boolean g;
    public com.larus.audio.call.o h;
    public int i;
    public MajorState.From j;
    public boolean k;
    public final HelloDownReducer l;
    public Job m;

    public static final class a implements com.larus.audio.call.mgr.f.a {
        public final /* synthetic */ CommonHelloPlugin<C> a;

        public a(CommonHelloPlugin<C> r1) {
            this.a = r1;
        }

        @Override // com.larus.audio.call.mgr.f.a
        public final void Q(MajorState r2, MajorState r3) {
            Intrinsics.checkNotNullParameter(r2, "prev");
            Intrinsics.checkNotNullParameter(r3, "current");
            CommonHelloPlugin<C> r4 = this.a;
            r4.i = r3.a;
            if ((r3 instanceof MajorState.d) == false) goto L13;
            MajorState.From r5 = ((MajorState.d) r3).c;
            if (r5 == MajorState.From.PLAY_COMPLETE) goto L7;
            return;
        L7:
            if (r4.k == false) goto L15;
            r4.k = false;
            r4.j = r5;
            com.larus.audio.call.o r6 = r4.h;
            if (r6 == null) goto L11;
            r6.a();
        L11:
            r4.h = null;
            com.larus.audio.call.arch.b.a(this.a.getContext()).l1();
            com.larus.audio.call.util.e.a.i(this.a.T2(), "Listening , isFromTriggerHello , startAudioRecord!!");
            return;
        L15:
            return;
        }
    }

    public static final class b extends com.larus.im.service.audio.z0 {
        public final String a;
        public final /* synthetic */ CommonHelloPlugin<C> b;

        public final String g() {
            return this.a;
        }

        public b(CommonHelloPlugin<C> r1) {
            this.b = r1;
            this.a = r1.T2();
        }

        public final void n(com.larus.im.service.audio.z0.a r4) {
            Intrinsics.checkNotNullParameter(r4, "event");
            Intrinsics.checkNotNullParameter(r4, "event");
            if ((r4 instanceof pf9.r) == false) goto L14;
            pf9.r r5 = (pf9.r) r4;
            if (r5.getType() != TriggerMode.HELLO) goto L7;
        L10:
            boolean r6 = true;
        L11:
            if (r6 == false) goto L15;
            this.b.g = true;
            return;
        L15:
            return;
        L7:
            if (r5.getType() == TriggerMode.HELLO_NEW) goto L10;
            r6 = false;
            goto L11
        }
    }

    public void C1() {
    }

    @Override // com.larus.audio.call.arch.a
    public final com.larus.im.service.audio.v R2() {
        return new CommonHelloPlugin$createSessionConnStateListener$1(this);
    }

    @Override // com.larus.audio.call.arch.a
    public final com.larus.im.service.audio.z0 S2() {
        return new b(this);
    }

    public boolean j3() {
        com.larus.audio.call.util.e.a.i(T2(), "[CALL] canSendHelloEvent [" + this.g + "][" + getContext().params().A + "][" + getContext().params().I + "][" + getContext().params().s + ']');
        if (this.g == false) goto L5;
    L11:
        return false;
    L5:
        if (getContext().params().A == false) goto L7;
    L10:
        return true;
    L7:
        if (getContext().params().I < 0) goto L11;
        if (getContext().params().s == AudioSessionType.SAMI) goto L11;
        goto L10
    }

    public void k3() {
        ouc.e0 r0 = new ouc.e0();
        q68.d.b(r0, "enter_method", getContext().params().p.i);
        String r1 = getContext().params().p.a;
        boolean r3 = true;
        if ((!StringsKt.isBlank(r1)) == false) goto L5;
        q68.d.b(r0, "message_id", r1);
    L5:
        String r2 = getContext().params().p.p;
        if (r2 != null) goto L8;
    L16:
        ouc.d0 r4 = r0.a();
        id9.d r5 = getContext().j();
        if (r5 == null) goto L20;
        r5.p(TriggerMode.HELLO, r4.toString());
        return;
    L20:
        return;
    L8:
        if (r2.length() > 0) goto L11;
        r3 = false;
    L11:
        if (r3 == true) goto L14;
        r2 = null;
    L14:
        if (r2 == null) goto L16;
        q68.d.b(r0, "bot_say_hello_text_key", r2);
        goto L16
    }

    @Override // com.larus.audio.call.arch.a
    public final com.larus.audio.call.mgr.f.a P2() {
        if (com.larus.audio.call.f.f() == false) goto L11;
        Job r0 = this.m;
        if (r0 != null) goto L7;
    L8:
        this.m = U2(new CommonHelloPlugin$createCallStateObserver$1(this, null));
    L9:
        return null;
    L7:
        if (r0.isActive() == true) goto L9;
    L11:
        return new a(this);
    }

    @Override // com.larus.audio.call.plugins.y0
    public boolean b1() {
        return j3();
    }

    @Override // com.larus.audio.call.arch.a
    public final void e3() {
        super.e3();
        getContext().a().F2(this.l, ReducerPosition.APPEND);
    }

    @Override // com.larus.audio.call.arch.a
    public String T2() {
        return this.f;
    }

    @Override // com.larus.audio.call.arch.a
    public final void g3() {
        super.g3();
    }

    public CommonHelloPlugin(C r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.f = "CommonHelloPlugin";
        this.i = -1;
        this.l = new HelloDownReducer();
    }
}
