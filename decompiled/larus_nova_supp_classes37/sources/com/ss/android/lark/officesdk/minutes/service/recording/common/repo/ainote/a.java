package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.ainote;

import android.view.ViewGroup;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public interface a extends com.ss.android.lark.officesdk.minutes.service.foundation.mvi.repo.c<c> {

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.service.recording.common.repo.ainote.a$a, reason: collision with other inner class name */
    public static final class C0040a {
        public static /* synthetic */ void a(a r2, Boolean r3, Boolean r4, Boolean r5, String r6, int r7) {
            if ((r7 & 1) == 0) goto L6;
            r3 = null;
        L6:
            if ((r7 & 2) == 0) goto L9;
            r4 = null;
        L9:
            if ((r7 & 4) == 0) goto L11;
            r5 = null;
        L11:
            r2.d0(r3, r4, r5, r6);
        }
    }

    void G0(long r1, long r3);

    boolean H0();

    void I0();

    Long J();

    void M(String r1);

    void N0();

    void O0(ViewGroup r1, f r2);

    boolean R(String r1);

    e T(d r1);

    void V(boolean r1);

    void d();

    void d0(Boolean r1, Boolean r2, Boolean r3, String r4);

    List<e> m0();

    boolean o(k r1);

    boolean o0();

    boolean q(String r1);

    void q0();

    int t();

    boolean t0();

    void v(Function1<? super List<e>, Unit> r1);

    void v0(boolean r1);

    void w0(boolean r1, String r2);

    boolean y(String r1);

    boolean y0();
}
