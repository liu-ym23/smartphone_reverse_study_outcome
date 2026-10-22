package com.larksuite.component.card.component.audio.service;

import com.larksuite.component.card.protocol.data.media.AudioInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public interface b extends com.larksuite.component.card.service.c {

    public static final class a {
        public final String a;
        public final String b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof a) == true) goto L8;
            return false;
        L8:
            a r6 = (a) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r0 = this.a.hashCode() * 31;
            String r1 = this.b;
            if (r1 != null) goto L5;
            int r2 = 0;
        L7:
            return r0 + r2;
        L5:
            r2 = r1.hashCode();
            goto L7
        }

        public final String toString() {
            return "CardAudioMonitorData(bizID=" + this.a + ", source=" + this.b + ')';
        }

        public a(String r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "bizID");
            this.a = r2;
            this.b = r3;
        }
    }

    void c(String r1, a r2);

    void e(az7.a r1);

    void f(String r1, AudioInfo r2, int r3, a r4);

    CardAudioStateEntity getState(String r1);

    void j(String r1, AudioInfo r2, int r3, a r4, boolean r5);

    void l(String r1, a r2);
}
