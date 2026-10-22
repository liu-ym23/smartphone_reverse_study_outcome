package com.larus.avlink.plugins;

import android.app.Application;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.ContextCompat;
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
public final class DoraLiteLiveActivityPlugin extends com.larus.audio.call.arch.a<n4> {
    public boolean f;
    public Job g;

    public static final class a implements com.larus.audio.call.mgr.f.a {
        public final /* synthetic */ DoraLiteLiveActivityPlugin a;

        public a(DoraLiteLiveActivityPlugin r1) {
            this.a = r1;
        }

        public final void Q(MajorState r3, MajorState r4) {
            Intrinsics.checkNotNullParameter(r3, "prev");
            Intrinsics.checkNotNullParameter(r4, "current");
            this.a.getClass();
            com.larus.avlink.n1.d("DoraLiveActivityPlugin", "state changed: prev: " + r3.b + ", current: " + r4.b + '.');
            DoraLiteLiveActivityPlugin r5 = this.a;
            r5.getClass();
            if ((r4 instanceof MajorState.g) == false) goto L5;
        L17:
            r5.l3(r4);
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
            r5.l3(r4);
            goto L18
        }
    }

    public static final class b extends com.larus.audio.call.play.e {
        public final /* synthetic */ DoraLiteLiveActivityPlugin a;

        public final void onPlayComplete() {
            this.a.getClass();
            com.larus.avlink.n1.d("DoraLiveActivityPlugin", "onPlayComplete.");
            if (com.larus.audio.call.f.f() == false) goto L11;
            if ((((AVKitDuplexState) ((n4) this.a.getContext()).a().y().getValue()).getDownState() instanceof AVKitCoreStates.DownWaiting) == false) goto L14;
            DoraLiteLiveActivityPlugin r0 = this.a;
            MajorState.From r1 = MajorState.From.ASR;
            MajorState.InterruptType r2 = MajorState.InterruptType.NOTHING;
            Intrinsics.checkNotNullParameter(r1, "from");
            Intrinsics.checkNotNullParameter(r2, "interruptType");
            r0.getClass();
            if (BaseDoraLiteLiveAiPlugin.l == false) goto L17;
            r0.k3(r0.j3(3, r0.f), 3);
            return;
        L17:
            return;
        L14:
            return;
        L11:
            if ((((n4) this.a.getContext()).a().s1() instanceof MajorState.d) == false) goto L16;
            DoraLiteLiveActivityPlugin r3 = this.a;
            r3.l3(((n4) r3.getContext()).a().s1());
            return;
        }

        public b(DoraLiteLiveActivityPlugin r1) {
            this.a = r1;
        }
    }

    public final String T2() {
        return "DoraLiveActivityPlugin";
    }

    public final void a3() {
        com.larus.voicecall.impl.notification.d.a.getClass();
        com.larus.voicecall.impl.notification.d.b("dora_pre");
        CoroutineScope r0 = ((n4) getContext()).r();
        if (r0 == null) goto L6;
        kotlinx.coroutines.flow.e.x(new FlowKt__TransformKt$onEach$.inlined.unsafeTransform.1(com.larus.voicecall.impl.notification.e.a, new DoraLiteLiveActivityPlugin$onPreStart$1$1(this, null)), r0);
        return;
    }

    public final void b3() {
        NotificationManagerCompat.from(AppHost.a.getApplication()).cancel(101);
        com.larus.voicecall.impl.notification.d.a.getClass();
        com.larus.voicecall.impl.notification.d.h("dora_release");
    }

    public final com.larus.audio.call.mgr.f.a P2() {
        if (com.larus.audio.call.f.f() == false) goto L11;
        Job r0 = this.g;
        if (r0 != null) goto L7;
    L8:
        this.g = U2(new DoraLiteLiveActivityPlugin$createCallStateObserver$1(this, null));
    L9:
        return null;
    L7:
        if (r0.isActive() == true) goto L9;
    L11:
        return new a(this);
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

    public DoraLiteLiveActivityPlugin(n4 r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
    }

    public final void l3(MajorState r3) {
        boolean r0 = BaseDoraLiteLiveAiPlugin.l;
        if (BaseDoraLiteLiveAiPlugin.l == true) goto L5;
        return;
    L5:
        k3(j3(r3.a, this.f), r3.a);
    }

    public final String j3(int r4, boolean r5) {
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

    public final void k3(String r16, int r17) {
        AppHost.Companion r1 = AppHost.a;
        NotificationManagerCompat r2 = NotificationManagerCompat.from(r1.getApplication());
        if (ContextCompat.checkSelfPermission(r1.getApplication().getApplicationContext(), "android.permission.POST_NOTIFICATIONS") == 0) goto L5;
        return;
    L5:
        com.larus.voicecall.impl.notification.d r3 = com.larus.voicecall.impl.notification.d.a;
        Application r4 = r1.getApplication();
        String r6 = r1.getApplication().getString(2131894310);
        Bitmap r8 = BitmapFactory.decodeResource(r1.getApplication().getResources(), 2131241551);
        int r5 = com.larus.voicecall.impl.ui.t.a;
        IRtcNotificationService.a r14 = new IRtcNotificationService.a(r6, r16, r8, com.larus.voicecall.impl.ui.t.b(r17, this.f), this.f, true, false, null);
        r3.getClass();
        r2.notify(101, com.larus.voicecall.impl.notification.d.c(r4, r14, false, "dora"));
    }
}
