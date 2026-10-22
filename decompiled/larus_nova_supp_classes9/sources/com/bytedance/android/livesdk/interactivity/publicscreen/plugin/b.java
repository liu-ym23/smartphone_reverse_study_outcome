package com.bytedance.android.livesdk.interactivity.publicscreen.plugin;

import com.bytedance.android.live.base.model.message.c4;
import com.bytedance.android.live.base.model.message.t;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.SafetyGuard;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.interactivity.api.entity.PSMessageAction;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.PublicScreenConfig$MessageModelType;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.l;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.listener.ShowArea;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.n;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.s;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.x;
import com.bytedance.android.livesdk.interactivity.textmessage.model.i0;
import com.bytedance.android.livesdk.interactivity.textmessage.utils.k;
import java.text.SimpleDateFormat;
import java.util.Date;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b extends x implements s42.b {
    public static final /* synthetic */ int e = 0;
    public final com.bytedance.android.livesdk.sharedpref.e<String> b;
    public boolean c;
    public int d;

    public static final class a {
    }

    static {
    }

    @Override // s42.b
    public final void f() {
    }

    @Override // s42.b
    public final void g() {
    }

    @Override // s42.b
    public final void h(com.bytedance.android.livesdk.interactivity.api.entity.f<?> r1) {
    }

    @Override // s42.b
    public final void m(com.bytedance.android.livesdk.interactivity.api.entity.f<?> r1) {
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.x
    public final void q() {
        Intrinsics.checkNotNullParameter(this, "listener");
        n r0 = this.a;
        if (r0 == null) goto L6;
        r0.removeMessageListener(this);
        return;
    }

    public b() {
        this.b = new com.bytedance.android.livesdk.sharedpref.e("live_public_screen_config_notify_state", String.class);
    }

    @Override // s42.b
    public final void a(t r10) {
        Intrinsics.checkNotNullParameter(r10, "message");
        if (this.c == true) goto L6;
        return;
    L6:
        if ((r10 instanceof c4) == true) goto L8;
        return;
    L8:
        if (r10.isFromFirstRequest() == false) goto L24;
        c4 r11 = (c4) r10;
        if (r11.getRoomMessageType() != 0) goto L25;
        int r0 = k.a;
        int r1 = i0.a(2131107646);
        int r2 = s.k;
        com.bytedance.android.livesdk.interactivity.api.publicscreen.t r3 = s.b.b(PublicScreenConfig$MessageModelType.ROOM_MESSAGE, s1.B(2131921796), Integer.valueOf(r1), false, false, PSMessageAction.SYSTEM, 376);
        l r4 = o();
        if (r4 == null) goto L14;
        r4.insertMessage(r3);
    L14:
        ALogger.i("PublicScreenConfigNotifyPlugin", "insert message. room message content: " + r11.getContent());
        int r13 = this.d;
        if (r13 != 0) goto L17;
        com.bytedance.android.livesdk.sharedpref.e<String> r14 = this.b;
        String r5 = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        r14.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r14, r5);
    L19:
        this.d++;
        this.c = false;
        Intrinsics.checkNotNullParameter(this, "listener");
        n r15 = this.a;
        if (r15 == null) goto L26;
        r15.removeMessageListener(this);
        return;
    L26:
        return;
    L17:
        if (r13 != 1) goto L19;
        com.bytedance.android.livesdk.sharedpref.e<String> r16 = this.b;
        r16.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r16, "#");
        goto L19
    L25:
        return;
    }

    @Override // s42.b
    public final void i(com.bytedance.android.livesdk.interactivity.api.entity.f<?> r2) {
        Intrinsics.checkNotNullParameter(r2, "message");
        Intrinsics.checkNotNullParameter(r2, "message");
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.x
    public final void p(l r5) {
        Intrinsics.checkNotNullParameter(r5, "publicScreenContext");
        String r6 = (String) this.b.getValue();
        boolean r0 = false;
        if (r6 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == false) goto L12;
        this.d = 0;
        r0 = true;
    L18:
        this.c = r0;
        if (r0 == false) goto L23;
        Intrinsics.checkNotNullParameter(this, "listener");
        n r1 = this.a;
        if (r1 == null) goto L23;
        r1.addMessageListener(this);
    L23:
        ALogger.i("PublicScreenConfigNotifyPlugin", "onLoad needNotify=" + this.c + " state=" + r6 + " notifyCount=" + this.d);
        return;
    L12:
        if (Intrinsics.areEqual(r6, "#") == false) goto L14;
        this.d = 2;
        goto L18
    L14:
        this.d = 1;
        r0 = !Intrinsics.areEqual(new SimpleDateFormat("yyyy-MM-dd").format(new Date()), r6);
    L17:
        SafetyGuard.a(null, null, "invalid live_public_screen_config_notify_state value " + r6);
        goto L18
    L5:
        if (r6.length() == 0) goto L8;
        r2 = false;
        goto L9
    }

    @Override // s42.b
    public final void j(com.bytedance.android.livesdk.interactivity.api.entity.f<?> r3, ShowArea r4) {
        Intrinsics.checkNotNullParameter(r3, "message");
        Intrinsics.checkNotNullParameter(r4, "showArea");
        Intrinsics.checkNotNullParameter(r3, "message");
        Intrinsics.checkNotNullParameter(r4, "showArea");
    }
}
