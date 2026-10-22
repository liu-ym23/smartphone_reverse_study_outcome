package com.bytedance.android.live.revlink.impl.pk.service;

import com.bytedance.android.livesdk.link.model.bridge.v1;
import com.bytedance.android.livesdk.link.model.d7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public interface d {

    public static final class a {
        public final boolean a;

        public a() {
            this(false);
        }

        public final boolean equals(Object r2) {
            if (this != r2) goto L4;
            return true;
        L4:
            if ((r2 instanceof a) == true) goto L6;
            return false;
        L6:
            if (this.a == ((a) r2).a) goto L13;
            return false;
        L13:
            return true;
        }

        public final int hashCode() {
            boolean r0 = this.a;
            if (r0 == false) goto L6;
            return 1;
        L6:
            return r0 ? 1 : 0;
        }

        public final String toString() {
            return "LinkOptParams(isBizOptLink=" + this.a + ")";
        }

        public a(boolean r1) {
            this.a = r1;
        }
    }

    long channelId();

    m41.b getUnLoadSource();

    String guestLinkMicId();

    String linkmicId();

    d7 multiLiveCoreInfo();

    v1 multiRtcInfo();

    void setUnLoadSource(m41.b r1);
}
