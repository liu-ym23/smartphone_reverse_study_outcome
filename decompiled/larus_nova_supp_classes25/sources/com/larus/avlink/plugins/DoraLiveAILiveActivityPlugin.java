package com.larus.avlink.plugins;

import android.app.Application;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.ContextCompat;
import com.larus.audio.call.InstanceCallState;
import com.larus.audio.call.mgr.AVKitCoreStates;
import com.larus.audio.call.mgr.AVKitDuplexState;
import com.larus.audio.call.mgr.MajorState;
import com.larus.common.apphost.AppHost;
import com.larus.voicecall.api.IRtcNotificationService;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class DoraLiveAILiveActivityPlugin extends c<n4> {
    public boolean f;
    public Job g;

    public static final class a implements com.larus.audio.call.mgr.f.a {
        public final /* synthetic */ DoraLiveAILiveActivityPlugin a;

        public a(DoraLiveAILiveActivityPlugin r1) {
            this.a = r1;
        }

        public final void Q(MajorState r3, MajorState r4) {
            Intrinsics.checkNotNullParameter(r3, "prev");
            Intrinsics.checkNotNullParameter(r4, "current");
            this.a.getClass();
            com.larus.avlink.n1.d("DoraLiveActivityPlugin", "state changed: prev: " + r3.b + ", current: " + r4.b + '.');
            DoraLiveAILiveActivityPlugin r5 = this.a;
            r5.getClass();
            if ((r4 instanceof MajorState.g) == false) goto L5;
        L17:
            r5.n3(r4);
        L18:
            this.a.getClass();
            com.larus.avlink.n1.d("DoraLiveActivityPlugin", "call state changed to " + r4.b);
            return;
        L5:
            if ((r4 instanceof MajorState.h) == true) goto L17;
            if ((r4 instanceof MajorState.a) == true) goto L17;
            if ((r4 instanceof MajorState.j) == true) goto L17;
            if ((r4 instanceof MajorState.i) == true) goto L17;
            if ((r4 instanceof MajorState.d) == false) goto L16;
            com.larus.audio.call.arch.b.a(r5.getContext()).a0();
            goto L18
        L16:
            r5.n3(r4);
            goto L18
        }
    }

    public static final class b extends com.larus.audio.call.play.e {
        public final /* synthetic */ DoraLiveAILiveActivityPlugin a;

        public final void onPlayComplete() {
            this.a.getClass();
            com.larus.avlink.n1.d("DoraLiveActivityPlugin", "onPlayComplete.");
            if (com.larus.audio.call.f.f() == false) goto L8;
            if ((((AVKitDuplexState) ((n4) this.a.getContext()).a().y().getValue()).getDownState() instanceof AVKitCoreStates.DownWaiting) == false) goto L11;
            DoraLiveAILiveActivityPlugin.k3(this.a, 3);
            return;
        L11:
            return;
        L8:
            if ((((n4) this.a.getContext()).a().s1() instanceof MajorState.d) == false) goto L13;
            DoraLiveAILiveActivityPlugin r0 = this.a;
            r0.n3(((n4) r0.getContext()).a().s1());
            return;
        }

        public b(DoraLiveAILiveActivityPlugin r1) {
            this.a = r1;
        }
    }

    public final String T2() {
        return "DoraLiveActivityPlugin";
    }

    public final void b3() {
        NotificationManagerCompat.from(AppHost.a.getApplication()).cancel(101);
        com.larus.voicecall.impl.notification.d.a.getClass();
        com.larus.voicecall.impl.notification.d.h("DoraLive");
    }

    public final com.larus.audio.call.mgr.f.a P2() {
        if (com.larus.audio.call.f.f() == false) goto L11;
        Job r0 = this.g;
        if (r0 != null) goto L7;
    L8:
        this.g = U2(new DoraLiveAILiveActivityPlugin$createCallStateObserver$1(this, null));
    L9:
        return null;
    L7:
        if (r0.isActive() == true) goto L9;
    L11:
        return new a(this);
    }

    public final void a3() {
        CoroutineScope r0 = ((n4) getContext()).r();
        if (r0 == null) goto L6;
        kotlinx.coroutines.flow.e.x(new FlowKt__TransformKt$onEach$.inlined.unsafeTransform.1(com.larus.voicecall.impl.notification.e.a, new DoraLiveAILiveActivityPlugin$onPreStart$1$1(this, null)), r0);
        return;
    }

    public final void e3() {
        super.e3();
        b r0 = new b(this);
        com.larus.audio.call.plugins.t0 r1 = getContext().c(Reflection.getOrCreateKotlinClass(com.larus.audio.call.plugins.t0.class), null);
        if (r1 == null) goto L8;
        u68.c r2 = r1.e0();
        if (r2 == null) goto L9;
        r2.i(r0);
        return;
    L9:
        return;
    }

    public DoraLiveAILiveActivityPlugin(n4 r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
    }

    public final void n3(MajorState r3) {
        m3(l3(r3.a, this.f), r3.a);
    }

    public static final void k3(DoraLiveAILiveActivityPlugin r2, int r3) {
        r2.getClass();
        InstanceCallState.Companion.getClass();
        com.larus.avlink.n1.d("DoraLiveActivityPlugin", "duplex -> instance: ".concat(InstanceCallState.a.a(r3)));
        if (r3 != 3) goto L8;
        if (com.larus.audio.call.arch.b.a(r2.getContext()).a0() == false) goto L8;
        return;
    L8:
        if (r3 != 4) goto L10;
        return;
    L10:
        if (r3 == 9) goto L19;
        String r0 = r2.l3(r3, r2.f);
        if (r0.length() <= 0) goto L14;
        boolean r1 = true;
    L15:
        if (r1 == false) goto L20;
        r2.m3(r0, r3);
        return;
    L20:
        return;
    L14:
        r1 = false;
        goto L15
    }

    public final String l3(int r4, boolean r5) {
        Application r0 = AppHost.a.getApplication();
        if (r4 == 1) goto L28;
        int r2 = 2131908047;
        if (r4 != 2) goto L7;
        if (r5 == true) goto L27;
        r2 = 2131898476;
    L27:
        String r6 = r0.getString(r2);
        Intrinsics.checkNotNull(r6);
        return r6;
    L7:
        if (r4 != 3) goto L9;
        if (r5 == true) goto L23;
        r2 = 2131898446;
    L23:
        String r7 = r0.getString(r2);
        Intrinsics.checkNotNull(r7);
        return r7;
    L9:
        if (r4 != 4) goto L11;
        String r8 = r0.getString(2131910477);
        Intrinsics.checkNotNull(r8);
        return r8;
    L11:
        if (r4 != 5) goto L13;
    L18:
        String r9 = r0.getString(2131908924);
        Intrinsics.checkNotNull(r9);
        return r9;
    L13:
        if (r4 != 7) goto L15;
        String r10 = r0.getString(2131900516);
        Intrinsics.checkNotNull(r10);
        return r10;
    L15:
        if (r4 == 9) goto L18;
        return "";
    L28:
        String r11 = r0.getString(2131898459);
        Intrinsics.checkNotNull(r11);
        return r11;
    }

    public final void m3(String r16, int r17) {
        AppHost.Companion r1 = AppHost.a;
        NotificationManagerCompat r2 = NotificationManagerCompat.from(r1.getApplication());
        if (ContextCompat.checkSelfPermission(r1.getApplication().getApplicationContext(), "android.permission.POST_NOTIFICATIONS") == 0) goto L5;
        return;
    L5:
        com.larus.voicecall.impl.notification.d r3 = com.larus.voicecall.impl.notification.d.a;
        Application r4 = r1.getApplication();
        Bitmap r8 = BitmapFactory.decodeResource(r1.getApplication().getResources(), 2131241169);
        int r5 = com.larus.voicecall.impl.ui.t.a;
        IRtcNotificationService.a r14 = new IRtcNotificationService.a("豆包", r16, r8, com.larus.voicecall.impl.ui.t.b(r17, this.f), this.f, true, false, null);
        r3.getClass();
        r2.notify(101, com.larus.voicecall.impl.notification.d.c(r4, r14, true, "DoraLive"));
    }

    @Override // com.larus.avlink.plugins.c
    public final void j3(int r1, int r2, String r3, String r4) {
        if (r2 != 5) goto L5;
        ((n4) getContext()).mute();
        this.f = true;
        n3(((n4) getContext()).a().s1());
        return;
    L5:
        if (r2 != 6) goto L11;
        ((n4) getContext()).unmute();
        this.f = false;
        n3(((n4) getContext()).a().s1());
        return;
    }
}
