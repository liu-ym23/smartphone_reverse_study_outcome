package com.bytedance.android.live.liveinteract.plantform.datamerge.handler;

import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveTheme;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class h0 extends com.bytedance.android.live.liveinteract.plantform.datamerge.handler.a {
    public final int b;
    public final a c;
    public final boolean d;
    public final DataCenter e;

    public static final class a<T> implements Observer {
        public final /* synthetic */ h0 a;

        public a(h0 r1) {
            this.a = r1;
        }

        public final void onChanged(Object r4) {
            IVoiceLiveTheme r5 = (IVoiceLiveTheme) r4;
            if (r5 == null) goto L8;
            h0 r0 = this.a;
            int r1 = r0.b;
            Intrinsics.checkNotNullParameter(r5, "theme");
            if (r1 != r0.b) goto L9;
            r0.a().L0(r5);
            return;
        L9:
            return;
        }
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamerge.handler.h
    public final void detach() {
        IInteractService r0 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r0 == null) goto L8;
        x00.a r1 = r0.getThemeManager(this.d, this.e);
        if (r1 == null) goto L9;
        r1.f(this.c, this.b);
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamerge.handler.h
    public final void attach() {
        LifecycleOwner r0 = a().k();
        if (r0 == null) goto L10;
        IInteractService r1 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r1 == null) goto L11;
        x00.a r2 = r1.getThemeManager(this.d, this.e);
        if (r2 == null) goto L12;
        r2.j(r0, this.c, this.b);
        return;
    L12:
        return;
    L11:
        return;
    }

    public h0(boolean r8, DataCenter r9) {
        this.d = r8;
        this.e = r9;
        int r0 = 2;
        com.bytedance.live.datacontext.j r1 = com.bytedance.android.live.liveinteract.api.utils.m.h(r9, null, 2).getVideoTalkRoomSubScene();
        if (r1 == null) goto L10;
        com.bytedance.android.livesdk.chatroom.viewmodel.e r2 = (com.bytedance.android.livesdk.chatroom.viewmodel.e) r1.getValue();
        if (r2 == null) goto L10;
        com.bytedance.android.livesdk.chatroom.viewmodel.j r3 = r2.t();
        if (r3 == null) goto L10;
        if (r3.a != 8) goto L10;
    L26:
        byte r10 = 0;
    L63:
        if (r10 == 0) goto L70;
        if (r10 == 1) goto L71;
        if (r10 == 2) goto L69;
        if (r10 == 3) goto L68;
        r0 = 0;
        goto L71
    L68:
        r0 = 100;
        goto L71
    L69:
        r0 = 1;
    L71:
        this.b = r0;
        this.c = new a(this);
        return;
    L70:
        r0 = 3;
    L10:
        com.bytedance.live.datacontext.j r4 = com.bytedance.android.live.liveinteract.api.utils.m.h(r9, null, 2).getVideoTalkRoomSubScene();
        if (r4 == null) goto L18;
        com.bytedance.android.livesdk.chatroom.viewmodel.e r5 = (com.bytedance.android.livesdk.chatroom.viewmodel.e) r4.getValue();
        if (r5 == null) goto L18;
        com.bytedance.android.livesdk.chatroom.viewmodel.j r6 = r5.t();
        if (r6 == null) goto L18;
        if (r6.a == 12) goto L26;
    L18:
        com.bytedance.live.datacontext.j r7 = com.bytedance.android.live.liveinteract.api.utils.m.h(r9, null, 2).getVideoTalkRoomSubScene();
        if (r7 == null) goto L27;
        com.bytedance.android.livesdk.chatroom.viewmodel.e r11 = (com.bytedance.android.livesdk.chatroom.viewmodel.e) r7.getValue();
        if (r11 == null) goto L27;
        com.bytedance.android.livesdk.chatroom.viewmodel.j r12 = r11.t();
        if (r12 == null) goto L27;
        if (r12.a == 16) goto L26;
    L27:
        com.bytedance.live.datacontext.j r13 = com.bytedance.android.live.liveinteract.api.utils.m.h(r9, null, 2).s();
        if (r13 == null) goto L35;
        com.bytedance.android.livesdk.chatroom.viewmodel.f r14 = (com.bytedance.android.livesdk.chatroom.viewmodel.f) r13.getValue();
        if (r14 == null) goto L35;
        com.bytedance.android.livesdk.chatroom.viewmodel.i r15 = r14.t();
        if (r15 == null) goto L35;
        if (r15.a != 5) goto L35;
    L43:
        r10 = 1;
    L35:
        com.bytedance.live.datacontext.j r16 = com.bytedance.android.live.liveinteract.api.utils.m.h(r9, null, 2).s();
        if (r16 == null) goto L44;
        com.bytedance.android.livesdk.chatroom.viewmodel.f r17 = (com.bytedance.android.livesdk.chatroom.viewmodel.f) r16.getValue();
        if (r17 == null) goto L44;
        com.bytedance.android.livesdk.chatroom.viewmodel.i r18 = r17.t();
        if (r18 == null) goto L44;
        if (r18.a == 16) goto L43;
    L44:
        com.bytedance.live.datacontext.j r19 = com.bytedance.android.live.liveinteract.api.utils.m.h(r9, null, 2).s();
        if (r19 == null) goto L62;
        com.bytedance.android.livesdk.chatroom.viewmodel.f r20 = (com.bytedance.android.livesdk.chatroom.viewmodel.f) r19.getValue();
        if (r20 == null) goto L62;
        com.bytedance.android.livesdk.chatroom.viewmodel.i r21 = r20.t();
        if (r21 == null) goto L62;
        if (r21.a != 9) goto L62;
        com.bytedance.live.datacontext.j r22 = com.bytedance.android.live.liveinteract.api.utils.m.h(r9, null, 2).s();
        if (r22 == null) goto L61;
        com.bytedance.android.livesdk.chatroom.viewmodel.f r23 = (com.bytedance.android.livesdk.chatroom.viewmodel.f) r22.getValue();
        if (r23 == null) goto L61;
        com.bytedance.android.livesdk.chatroom.viewmodel.i r24 = r23.t();
        if (r24 == null) goto L61;
        if (r24.b != 61) goto L61;
        r10 = 3;
    L61:
        r10 = 2;
    L62:
        r10 = -1;
        goto L63
    }
}
