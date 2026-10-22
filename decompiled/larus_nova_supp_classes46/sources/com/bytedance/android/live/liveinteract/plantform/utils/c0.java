package com.bytedance.android.live.liveinteract.plantform.utils;

import com.bytedance.android.live.core.log.ALogger;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c0 {
    public static volatile AtomicInteger c;
    public final ArrayList<q> a;
    public boolean b;

    public static final class a {
        public static c0 a(d0 r7) {
            Intrinsics.checkNotNullParameter(r7, "manager");
            us1.a r1 = vm2.h.f0();
            com.bytedance.live.datacontext.j r2 = com.bytedance.android.live.liveinteract.api.utils.m.d().getVideoTalkRoomSubScene();
            c0 r3 = null;
            if (r2 == null) goto L9;
            com.bytedance.android.livesdk.chatroom.viewmodel.e r4 = (com.bytedance.android.livesdk.chatroom.viewmodel.e) r2.getValue();
            if (r4 == null) goto L9;
            com.bytedance.android.livesdk.chatroom.viewmodel.j r5 = r4.t();
            if (r5 == null) goto L9;
            Integer r6 = Integer.valueOf(r5.a);
        L17:
            if (r6 != null) goto L19;
        L37:
            return r3;
        L19:
            if (r6.intValue() == 0) goto L37;
            if (r1.getType() != 2) goto L24;
        L25:
            List r8 = r1.a();
            if (r8 == null) goto L37;
            if (r8.contains(String.valueOf(r6.intValue())) != true) goto L37;
            Intrinsics.checkNotNullParameter(r7, "manager");
            r3 = new c0();
            q r0 = r7.a(2);
            if (r0 != null) goto L32;
            ALogger.e("LiveStreamInfoSenderHolder", "IM_ENABLE is null");
        L33:
            q r9 = r7.a(1);
            if (r9 != null) goto L36;
            ALogger.e("LiveStreamInfoSenderHolder", "SEI_ENABLE is null");
            goto L37
        L36:
            r3.a(1, r9);
            goto L37
        L32:
            r3.a(2, r0);
            goto L33
        L24:
            if (r1.getType() != 3) goto L37;
        L9:
            com.bytedance.live.datacontext.j r10 = com.bytedance.android.live.liveinteract.api.utils.m.d().s();
            if (r10 == null) goto L16;
            com.bytedance.android.livesdk.chatroom.viewmodel.f r11 = (com.bytedance.android.livesdk.chatroom.viewmodel.f) r10.getValue();
            if (r11 == null) goto L16;
            com.bytedance.android.livesdk.chatroom.viewmodel.i r12 = r11.t();
            if (r12 == null) goto L16;
            r6 = Integer.valueOf(r12.a);
        L16:
            r6 = null;
            goto L17
        }

        public static c0 b(d0 r4) {
            Intrinsics.checkNotNullParameter(r4, "manager");
            us1.a r1 = vm2.h.f0();
            if (r1.getType() != 2) goto L5;
        L8:
            Intrinsics.checkNotNullParameter(r4, "manager");
            c0 r0 = new c0();
            q r2 = r4.a(2);
            if (r2 != null) goto L11;
            ALogger.e("LiveStreamInfoSenderHolder", "IM_ENABLE is null");
        L12:
            q r5 = r4.a(1);
            if (r5 != null) goto L15;
            ALogger.e("LiveStreamInfoSenderHolder", "SEI_ENABLE is null");
        L17:
            return r0;
        L15:
            r0.a(1, r5);
            goto L17
        L11:
            r0.a(2, r2);
            goto L12
        L5:
            if (r1.getType() == 3) goto L8;
            return null;
        }
    }

    static {
        c = new AtomicInteger(0);
    }

    public c0() {
        this.a = new ArrayList();
    }

    public final void a(int r2, q r3) {
        Intrinsics.checkNotNullParameter(r3, "sender");
        this.a.add(r3);
        if (r2 != 2) goto L6;
        this.b = true;
        return;
    }
}
