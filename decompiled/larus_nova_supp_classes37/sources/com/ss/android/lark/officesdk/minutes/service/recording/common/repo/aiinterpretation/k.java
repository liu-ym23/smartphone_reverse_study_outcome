package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation;

import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class k {
    public final com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a a;
    public final String b;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[MmAIInterpretationAecPolicy.values().length];
            r0[MmAIInterpretationAecPolicy.RESTORE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[MmAIInterpretationAecPolicy.TRANSCRIPT_ONLY.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    static {
    }

    public k(com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "mmUccApi");
        Intrinsics.checkNotNullParameter(r3, "logTag");
        this.a = r2;
        this.b = r3;
    }

    public final boolean a(j r6, String r7) {
        Intrinsics.checkNotNullParameter(r6, "action");
        Intrinsics.checkNotNullParameter(r7, "source");
        nub.b r0 = (nub.b) this.a.u(nub.b.class);
        int r1 = 0;
        if (r0 != null) goto L6;
        lvb.a.b(this.b, "[applyRtcAction] rtc service is null, source=" + r7);
        return false;
    L6:
        r0.Q1(r6.a);
        r0.B0(r6.b);
        r0.j0(r6.c);
        int r2 = b.a[r6.d.ordinal()];
        if (r2 != 1) goto L9;
        Integer r3 = this.a.getSettingsService().b.getMmAecOption();
        if (r3 == null) goto L16;
        r1 = r3.intValue();
    L16:
        b(r0, r1);
    L17:
        lvb.a.e(this.b, "[applyRtcAction] source=" + r7 + ", rescale=" + r6.a + ", subChannels=" + r6.b + ", playbackMuted=" + r6.c + ", aec=" + r6.d + ", aecOption=" + r1);
        return true;
    L9:
        if (r2 != 2) goto L12;
        b(r0, 1);
        r1 = 1;
        goto L17
    L12:
        throw new NoWhenBranchMatchedException();
    }

    public final void b(nub.b r4, int r5) {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        r4.x(new JSONObject().put("rtc.aec_option", r5));     // Catch: Throwable -> L4
        Object r6 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L4
    L6:
        Throwable r7 = Result.exceptionOrNull-impl(r6);
        if (r7 == null) goto L12;
        lvb.a.b(this.b, "[setAecOption] option=" + r5 + ", error=" + r7);
        return;
    L12:
        return;
    L4:
        th = move-exception;
        Result.Companion r1 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L6
    }
}
