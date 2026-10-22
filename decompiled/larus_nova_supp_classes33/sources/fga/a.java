package fga;

import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public interface a extends m1a.a {

    /* JADX INFO: renamed from: fga.a$a, reason: collision with other inner class name */
    public static final class C0055a {
        public static /* synthetic */ Object a(a r2, boolean r3, boolean r4, Continuation r5, int r6) {
            if ((r6 & 2) == 0) goto L6;
            r3 = false;
        L6:
            if ((r6 & 4) == 0) goto L9;
            r4 = false;
        L9:
            return r2.w80(false, r3, r4, r5);
        }
    }

    Object w80(boolean r1, boolean r2, boolean r3, Continuation<? super Boolean> r4);
}
