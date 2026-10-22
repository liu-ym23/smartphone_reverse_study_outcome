package com.bytedance.android.livesdk.chatroom.utils;

import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class x1 {
    public static final boolean a() {
        com.bytedance.android.livesdk.chatroom.o r0 = o3.f();
        if (r0 == null) goto L11;
        com.bytedance.live.datacontext.j r1 = r0.getVideoTalkRoomSubScene();
        if (r1 == null) goto L11;
        com.bytedance.android.livesdk.chatroom.viewmodel.e r2 = (com.bytedance.android.livesdk.chatroom.viewmodel.e) r1.getValue();
        if (r2 == null) goto L11;
        com.bytedance.android.livesdk.chatroom.viewmodel.j r3 = r2.t();
        if (r3 == null) goto L11;
        Integer r4 = Integer.valueOf(r3.a);
    L12:
        if (r0 == null) goto L18;
        com.bytedance.live.datacontext.j r5 = r0.getVideoTalkRoomSubScene();
        if (r5 == null) goto L18;
        com.bytedance.android.livesdk.chatroom.viewmodel.e r6 = (com.bytedance.android.livesdk.chatroom.viewmodel.e) r5.getValue();
        if (r6 == null) goto L18;
        r6.t();
    L18:
        if (r4 != null) goto L21;
        return false;
    L21:
        if (r4.intValue() == 8) goto L23;
        return false;
    L23:
        if (com.bytedance.android.livesdk.chatroom.interact.model.d0.d() == false) goto L28;
        return true;
    L28:
        return false;
    L11:
        r4 = null;
        goto L12
    }

    public static final boolean b() {
        com.bytedance.android.livesdk.chatroom.o r0 = o3.f();
        List<Integer> r1 = null;
        if (r0 == null) goto L11;
        com.bytedance.live.datacontext.j r2 = r0.getVideoTalkRoomSubScene();
        if (r2 == null) goto L11;
        com.bytedance.android.livesdk.chatroom.viewmodel.e r3 = (com.bytedance.android.livesdk.chatroom.viewmodel.e) r2.getValue();
        if (r3 == null) goto L11;
        com.bytedance.android.livesdk.chatroom.viewmodel.j r4 = r3.t();
        if (r4 == null) goto L11;
        Integer r5 = Integer.valueOf(r4.a);
    L12:
        if (r0 == null) goto L20;
        com.bytedance.live.datacontext.j r6 = r0.getVideoTalkRoomSubScene();
        if (r6 == null) goto L20;
        com.bytedance.android.livesdk.chatroom.viewmodel.e r7 = (com.bytedance.android.livesdk.chatroom.viewmodel.e) r6.getValue();
        if (r7 == null) goto L20;
        com.bytedance.android.livesdk.chatroom.viewmodel.j r8 = r7.t();
        if (r8 == null) goto L20;
        r1 = r8.b;
    L20:
        if (r5 != null) goto L23;
        return false;
    L23:
        if (r5.intValue() == 8) goto L25;
        return false;
    L25:
        if (com.bytedance.android.livesdk.chatroom.interact.model.d0.g(r1) == false) goto L30;
        return true;
    L30:
        return false;
    L11:
        r5 = null;
        goto L12
    }

    public static final boolean c() {
        com.bytedance.android.livesdk.chatroom.o r0 = o3.f();
        if (r0 == null) goto L13;
        com.bytedance.live.datacontext.j r1 = r0.getVideoTalkRoomSubScene();
        if (r1 == null) goto L13;
        com.bytedance.android.livesdk.chatroom.viewmodel.e r2 = (com.bytedance.android.livesdk.chatroom.viewmodel.e) r1.getValue();
        if (r2 == null) goto L13;
        com.bytedance.android.livesdk.chatroom.viewmodel.j r3 = r2.t();
        if (r3 == null) goto L13;
        if (r3.a != 12) goto L13;
        return true;
    L13:
        return false;
    }

    public static final boolean d() {
        com.bytedance.android.livesdk.chatroom.o r0 = o3.f();
        if (r0 == null) goto L13;
        com.bytedance.live.datacontext.j r1 = r0.getVideoTalkRoomSubScene();
        if (r1 == null) goto L13;
        com.bytedance.android.livesdk.chatroom.viewmodel.e r2 = (com.bytedance.android.livesdk.chatroom.viewmodel.e) r1.getValue();
        if (r2 == null) goto L13;
        com.bytedance.android.livesdk.chatroom.viewmodel.j r3 = r2.t();
        if (r3 == null) goto L13;
        if (r3.a != 16) goto L13;
        return true;
    L13:
        return false;
    }

    public static final boolean e() {
        com.bytedance.android.livesdk.chatroom.o r0 = o3.f();
        if (r0 == null) goto L12;
        com.bytedance.live.datacontext.j r1 = r0.getVideoTalkRoomSubScene();
        if (r1 == null) goto L12;
        com.bytedance.android.livesdk.chatroom.viewmodel.e r2 = (com.bytedance.android.livesdk.chatroom.viewmodel.e) r1.getValue();
        if (r2 == null) goto L12;
        com.bytedance.android.livesdk.chatroom.viewmodel.j r3 = r2.t();
        if (r3 == null) goto L12;
        if (r3.a != 8) goto L12;
    L21:
        return true;
    L12:
        if (r0 == null) goto L22;
        com.bytedance.live.datacontext.j r4 = r0.getVideoTalkRoomSubScene();
        if (r4 == null) goto L22;
        com.bytedance.android.livesdk.chatroom.viewmodel.e r5 = (com.bytedance.android.livesdk.chatroom.viewmodel.e) r4.getValue();
        if (r5 == null) goto L22;
        com.bytedance.android.livesdk.chatroom.viewmodel.j r6 = r5.t();
        if (r6 == null) goto L22;
        if (r6.a == 12) goto L21;
    L22:
        return false;
    }
}
