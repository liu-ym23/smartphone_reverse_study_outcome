package com.obric.audio.continuous_talk;

import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public interface c extends m1a.a {

    public static final class a {
        public static /* synthetic */ void b(c r1, int r2, Integer r3, int r4) {
            if ((r4 & 1) == 0) goto L6;
            r2 = 0;
        L6:
            if ((r4 & 4) == 0) goto L8;
            r3 = null;
        L8:
            r1.Yd(r2, null, r3);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void a(c r1, ObricContinuousTalkEndType r2, Map r3, boolean r4, boolean r5, int r6) {
            if ((r6 & 1) == 0) goto L6;
            r2 = ObricContinuousTalkEndType.OTHER;
        L6:
            if ((r6 & 2) == 0) goto L9;
            r3 = null;
        L9:
            if ((r6 & 4) == 0) goto L12;
            r4 = true;
        L12:
            if ((r6 & 8) == 0) goto L14;
            r5 = false;
        L14:
            r1.f10(r2, r3, r4, r5);
        }
    }

    void Yd(int r1, Map<String, Object> r2, Integer r3);

    void f10(ObricContinuousTalkEndType r1, Map<String, Object> r2, boolean r3, boolean r4);

    boolean m0();

    boolean qO(int r1);
}
