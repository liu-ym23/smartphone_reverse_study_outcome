package com.ss.android.lark.officesdk.minutes.service.recording.common.core.sessionstatehandler;

import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingUILaunchMode;
import com.ss.android.lark.officesdk.minutes.service.foundation.mvi.thread.MMCoroutines;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.data.RecordingSessionType;
import kotlin.Lazy;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class MmRecordingMeetingCreateFailureHandler {
    public final com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a a;
    public final String b;

    public static final class a {
    }

    static {
    }

    public MmRecordingMeetingCreateFailureHandler(com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "userComponentContext");
        Intrinsics.checkNotNullParameter(r3, "logTag");
        this.a = r2;
        this.b = r3;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:35:0x00dc -> B:36:0x00e0). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:37:0x00e7 -> B:38:0x00e9). Please report as a decompilation issue!!! */
    public final Object b(int r20, Continuation<? super Unit> r21) {
        if ((r21 instanceof MmRecordingMeetingCreateFailureHandler$showQuotaDialog$1) == false) goto L7;
        MmRecordingMeetingCreateFailureHandler$showQuotaDialog$1 r2 = (MmRecordingMeetingCreateFailureHandler$showQuotaDialog$1) r21;
        int r3 = r2.label;
        if ((r3 & Integer.MIN_VALUE) == 0) goto L7;
        r2.label = r3 - Integer.MIN_VALUE;
    L8:
        Object r1 = r2.result;
        Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r2.label;
        if (r5 == 0) goto L16;
        if (r5 == 1) goto L15;
        if (r5 != 2) goto L14;
        int r6 = r2.I$2;
        int r7 = r2.I$1;
        int r8 = r2.I$0;
        kub.a r9 = (kub.a) r2.L$0;
        ResultKt.throwOnFailure(r1);
        MmRecordingMeetingCreateFailureHandler r15 = this;
    L36:
        int r18 = r7;
        int r10 = r6;
        int r11 = r8;
        int r12 = r18;
    L38:
        int r13 = r10 + 1;
        int r14 = r12;
        kub.a r16 = r9;
        int r17 = r13;
    L21:
        if (r17 >= r14) goto L40;
        Lazy r19 = MMCoroutines.a;
        MainCoroutineDispatcher r110 = Dispatchers.getMain().getImmediate();
        MmRecordingMeetingCreateFailureHandler$showQuotaDialog$2$shown$1 r111 = new MmRecordingMeetingCreateFailureHandler$showQuotaDialog$2$shown$1(r15, r17, r16, r11, null);
        r2.L$0 = r16;
        r2.I$0 = r11;
        r2.I$1 = r14;
        r2.I$2 = r17;
        r2.I$3 = r17;
        r2.label = 1;
        Object r22 = BuildersKt.withContext(r110, r111, r2);
        if (r22 != r4) goto L25;
        return r4;
    L25:
        kub.a r112 = r16;
        int r23 = r11;
        r1 = r22;
        int r24 = r17;
        r12 = r14;
        r10 = r24;
    L27:
        if (((Boolean) r1).booleanValue() == false) goto L31;
        return Unit.INSTANCE;
    L31:
        if (r24 >= 2) goto L37;
        r2.L$0 = r112;
        r2.I$0 = r23;
        r2.I$1 = r12;
        r2.I$2 = r10;
        r2.label = 2;
        if (DelayKt.delay(1000, r2) != r4) goto L35;
        return r4;
    L35:
        r6 = r10;
        r7 = r12;
        r8 = r23;
        r9 = r112;
        goto L36
    L37:
        r11 = r23;
        r9 = r112;
        goto L38
    L40:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r24 = r2.I$3;
        r10 = r2.I$2;
        r12 = r2.I$1;
        r23 = r2.I$0;
        r112 = (kub.a) r2.L$0;
        ResultKt.throwOnFailure(r1);
        r15 = this;
        goto L27
    L16:
        ResultKt.throwOnFailure(r1);
        r16 = (kub.a) this.a.u(kub.a.class);
        if (r16 != null) goto L20;
        lvb.a.b(this.b, "[showQuotaDialog] quota dependency is null, denyType=" + r20);
        return Unit.INSTANCE;
    L20:
        r11 = r20;
        r14 = 3;
        r17 = 0;
        r15 = this;
    L7:
        r2 = new MmRecordingMeetingCreateFailureHandler$showQuotaDialog$1(this, r21);
        goto L8
    }

    public final Object a(Throwable r5, RecordingSessionType r6, Continuation<? super Unit> r7) {
        e r0 = e.a;
        String r2 = null;
        Object r3 = null;
        if ((r5 instanceof ErrorResult) == false) goto L5;
        ErrorResult r8 = (ErrorResult) r5;
    L6:
        r0.getClass();
        if (r8 == null) goto L9;
        Integer r1 = Integer.valueOf(r8.getCode());
    L10:
        if (r1 != null) goto L13;
    L18:
        if (r1 != null) goto L21;
    L23:
        if (r8 == null) goto L25;
        String r9 = r8.getDebugMsg();
    L26:
        boolean r4 = true;
        if (r9 != null) goto L29;
    L32:
        boolean r10 = true;
    L33:
        if (r10 == false) goto L82;
    L51:
        if (r2 == null) goto L53;
        Object r11 = new d.e(r2);
    L55:
        if (Intrinsics.areEqual(r11, d.c.a) == false) goto L57;
    L76:
        Object r12 = Unit.INSTANCE;
    L78:
        if (r12 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L81;
        return r12;
    L81:
        return Unit.INSTANCE;
    L57:
        if (Intrinsics.areEqual(r11, d.b.a) == false) goto L60;
        com.ss.android.lark.officesdk.minutes.service.foundation.utils.b.d(2131892899);
        goto L76
    L60:
        if (Intrinsics.areEqual(r11, d.a.a) == false) goto L66;
        if (r6 != RecordingSessionType.STANDALONE_AI_INTERPRETATION) goto L64;
        com.ss.android.lark.officesdk.minutes.service.foundation.utils.b.d(2131893499);
        goto L76
    L64:
        com.ss.android.lark.officesdk.minutes.service.foundation.utils.b.d(2131892842);
        goto L76
    L66:
        if ((r11 instanceof d.e) == false) goto L69;
        MmRecordingUILaunchMode r13 = com.ss.android.lark.officesdk.minutes.service.foundation.utils.b.a;
        com.ss.android.lark.officesdk.minutes.service.foundation.utils.b.e(((d.e) r11).a);
        goto L76
    L69:
        if ((r11 instanceof d.C0030d) == false) goto L75;
        r12 = b(((d.C0030d) r11).a, r7);
        if (r12 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L78;
        r12 = Unit.INSTANCE;
        goto L78
    L75:
        throw new NoWhenBranchMatchedException();
    L53:
        r11 = d.a.a;
        goto L55
    L82:
        Result.Companion r14 = Result.Companion;     // Catch: Throwable -> L44
        String r15 = JSONObjectProtectorUtils.getString(new JSONObject(r9), "message");     // Catch: Throwable -> L44
        Intrinsics.checkNotNull(r15);     // Catch: Throwable -> L44
        if (r15.length() > 0) goto L39;
        r4 = false;
    L39:
        if (r4 == true) goto L42;
        r15 = null;
    L42:
        Object r16 = Result.constructor-impl(r15);     // Catch: Throwable -> L44
    L47:
        if (Result.isFailure-impl(r16) == true) goto L50;
        r3 = r16;
    L50:
        r2 = (String) r3;
    L44:
        th = move-exception;
        Result.Companion r17 = Result.Companion;
        r16 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L47
    L29:
        if (r9.length() == 0) goto L32;
        r10 = false;
        goto L33
    L25:
        r9 = null;
        goto L26
    L21:
        if (r1.intValue() != 220204) goto L23;
        r11 = d.b.a;
        goto L55
    L13:
        if (r1.intValue() != 220202) goto L18;
        Integer r18 = e.b(r8);
        if (r18 == null) goto L17;
        r11 = new d.C0030d(r18.intValue());
        goto L55
    L17:
        r11 = d.c.a;
        goto L55
    L9:
        r1 = null;
        goto L10
    L5:
        r8 = null;
        goto L6
    }
}
