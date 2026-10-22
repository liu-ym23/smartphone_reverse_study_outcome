package com.bytedance.android.livesdk.gamecp.impl;

import com.bytedance.android.livesdk.chatroom.utils.n3;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class n implements dw.i {
    public final HashMap<vv.c, vlc.l> a;

    public static final class a implements vlc.l {
        public final /* synthetic */ vv.c a;
        public final /* synthetic */ String b;

        public a(vv.c r1, String r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void onMessage(tlc.d r4) {
            this.a.onMessage(this.b, GsonProtectorUtils.toJson(new Gson(), r4));
        }
    }

    public n() {
        this.a = new HashMap();
    }

    public final void b(long r2, vv.c r4) {
        Intrinsics.checkNotNullParameter(r4, "listener");
        vlc.l r0 = this.a.get(r4);
        if (r0 != null) goto L5;
        return;
    L5:
        vlc.d r3 = n3.c(r2);
        if (r3 == null) goto L8;
        r3.removeMessageListener(r0);
    L8:
        this.a.remove(r4);
    }

    public final void a(long r6, String r8, vv.c r9) {
        Intrinsics.checkNotNullParameter(r8, "type");
        Intrinsics.checkNotNullParameter(r9, "listener");
        a r0 = new a(r9, r8);
        this.a.put(r9, r0);
        MessageType[] r10 = MessageType.values();
        int r1 = r10.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L8;
        MessageType r3 = r10[r2];
        if (Intrinsics.areEqual(r3.getWsMethod(), r8) == true) goto L9;
        r2 = r2 + 1;
    L9:
        if (r3 == null) goto L16;
        vlc.d r7 = n3.c(r6);
        if (r7 == null) goto L17;
        r7.addMessageListener(r3.getIntType(), r0);
        return;
    L17:
        return;
    L16:
        return;
    L8:
        r3 = null;
        goto L9
    }
}
