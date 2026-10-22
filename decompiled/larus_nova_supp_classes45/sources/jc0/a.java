package jc0;

import com.bytedance.android.live.liveinteract.api.utils.m;
import com.bytedance.android.livesdk.chatroom.u;
import com.bytedance.android.livesdk.chatroom.viewmodel.e;
import com.bytedance.android.livesdk.chatroom.viewmodel.f;
import com.bytedance.android.livesdk.chatroom.viewmodel.i;
import com.bytedance.live.datacontext.j;
import kotlin.jvm.internal.Intrinsics;
import vm2.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a {
    public static boolean a;
    public static boolean b;

    public static final boolean b(int r1, int r2) {
        if (r1 == 9) goto L5;
    L7:
        return false;
    L5:
        if (r2 != 61) goto L7;
        return true;
    }

    public static final boolean a() {
        u r0 = m.d();
        if (r0 != null) goto L5;
        return false;
    L5:
        j r2 = r0.s();
        if (r2 == null) goto L23;
        f r3 = (f) r2.getValue();
        if (r3 == null) goto L24;
        i r4 = r3.t();
        if (r4 != null) goto L12;
        return false;
    L12:
        if (r4.a != 9) goto L26;
        j r1 = r0.s();
        if (r1 == null) goto L27;
        f r5 = (f) r1.getValue();
        if (r5 == null) goto L28;
        i r6 = r5.t();
        if (r6 != null) goto L20;
        return false;
    L20:
        if (r6.b != 61) goto L30;
        return true;
    L30:
        return false;
    L28:
        return false;
    L27:
        return false;
    L26:
        return false;
    L24:
        return false;
    L23:
        return false;
    }

    public static final boolean c() {
        u r0 = m.d();
        if (r0 != null) goto L5;
        return false;
    L5:
        j r2 = r0.getVideoTalkRoomSubScene();
        if (r2 == null) goto L23;
        e r3 = (e) r2.getValue();
        if (r3 == null) goto L24;
        com.bytedance.android.livesdk.chatroom.viewmodel.j r4 = r3.t();
        if (r4 != null) goto L12;
        return false;
    L12:
        if (r4.a != 8) goto L26;
        j r1 = r0.getVideoTalkRoomSubScene();
        if (r1 == null) goto L27;
        e r5 = (e) r1.getValue();
        if (r5 == null) goto L28;
        com.bytedance.android.livesdk.chatroom.viewmodel.j r6 = r5.t();
        if (r6 != null) goto L20;
        return false;
    L20:
        if (r6.c != 63) goto L30;
        return true;
    L30:
        return false;
    L28:
        return false;
    L27:
        return false;
    L26:
        return false;
    L24:
        return false;
    L23:
        return false;
    }

    public static final boolean d(int r2, int r3) {
        if ((!Intrinsics.areEqual(m.i().isAnchor(), Boolean.TRUE)) == true) goto L5;
    L9:
        return false;
    L5:
        if (b(r2, r3) == false) goto L9;
        if (c.k() == true) goto L9;
        return true;
    }
}
