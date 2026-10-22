package yz0;

import io.reactivex.Observable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public interface h extends f80.b {

    public static final class a {
        public static /* synthetic */ Observable a(h r0, yh6.b r1, boolean r2, int r3) {
            if ((r3 & 2) == 0) goto L6;
            r2 = false;
        L6:
            return r0.S4(r1, r2, null);
        }
    }

    <T extends yh6.c> Observable<T> S4(yh6.b<T> r1, boolean r2, String r3);
}
