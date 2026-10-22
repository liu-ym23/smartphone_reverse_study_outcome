package com.bytedance.android.live.broadcastgame.opengame.message;

import com.bytedance.android.livesdk.message.model.sc;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class i0 implements com.bytedance.android.live.broadcastgame.c0<a>, vlc.l {
    public com.bytedance.android.live.broadcastgame.b0 a;
    public final vlc.d b;

    public static final class a implements com.bytedance.android.live.broadcastgame.v {
        public final sc a;

        public final boolean equals(Object r2) {
            if (this != r2) goto L4;
            return true;
        L4:
            if ((r2 instanceof a) == true) goto L6;
            return false;
        L6:
            if (Intrinsics.areEqual(this.a, ((a) r2).a) == true) goto L13;
            return false;
        L13:
            return true;
        }

        public final int hashCode() {
            sc r0 = this.a;
            if (r0 != null) goto L7;
            return 0;
        L7:
            return r0.hashCode();
        }

        public final String toString() {
            return "OpenPlatformControlMessage(msg=" + this.a + ")";
        }

        public a(sc r2) {
            Intrinsics.checkNotNullParameter(r2, "msg");
            this.a = r2;
        }
    }

    @Override // com.bytedance.android.live.broadcastgame.c0
    public final void release() {
        vlc.d r0 = this.b;
        if (r0 == null) goto L6;
        r0.removeMessageListener(this);
        return;
    }

    public i0(vlc.d r1) {
        this.b = r1;
    }

    @Override // com.bytedance.android.live.broadcastgame.c0
    public final void a(com.bytedance.android.live.broadcastgame.b0 r2) {
        Intrinsics.checkNotNullParameter(r2, "queue");
        this.a = r2;
        vlc.d r3 = this.b;
        if (r3 == null) goto L6;
        r3.addMessageListener(MessageType.INTERACT_OPEN_PLATFORM_CONTROL_MESSAGE.getIntType(), this);
        return;
    }

    public final void onMessage(tlc.d r3) {
        if ((r3 instanceof sc) == false) goto L8;
        com.bytedance.android.live.broadcastgame.b0 r0 = this.a;
        if (r0 == null) goto L9;
        r0.insert(new a((sc) r3));
        return;
    L9:
        return;
    }
}
