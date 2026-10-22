package com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.statessync;

import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.utils.NetworkUtils;
import com.ss.android.lark.officesdk.manager.OfficeSDKManager;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingSource;
import com.ss.android.lark.officesdk.minutes.api.recording.doubao.DoubaoBizInfo;
import com.ss.android.lark.officesdk.minutes.service.foundation.mvi.thread.MMCoroutines;
import com.ss.android.lark.officesdk.minutes.service.foundation.network.request.http.MmCreateAudioRequest;
import com.ss.android.lark.officesdk.minutes.service.foundation.network.response.http.MmCreateAudioResponse;
import com.ss.android.lark.officesdk.minutes.service.foundation.utils.net.MmNetworkUtils;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.exception.MmCreateRecordingException;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.UIHelper;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.j1;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class MmRecordingCreateService {
    public static final Companion j = null;
    public final com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a a;
    public final long b;
    public a c;
    public final String d;
    public final CoroutineScope e;
    public final Job f;
    public String g;
    public Deferred h;
    public final StateFlowImpl i;

    public static final class Companion {
        public Companion() {
        }

        public final Object a(com.ss.android.lark.officesdk.minutes.service.foundation.network.b r16, String r17, String r18, int r19, MmCreateAudioRequest.CreateMinutesStatus r20, DoubaoBizInfo r21, MmRecordingSource r22, String r23, boolean r24, Continuation<? super Result<MmCreateAudioResponse>> r25) {
            if ((r25 instanceof MmRecordingCreateService$Companion$sendCreateRecordingObjectRequest$1) == false) goto L7;
            MmRecordingCreateService$Companion$sendCreateRecordingObjectRequest$1 r1 = (MmRecordingCreateService$Companion$sendCreateRecordingObjectRequest$1) r25;
            int r2 = r1.label;
            if ((r2 & Integer.MIN_VALUE) == 0) goto L7;
            r1.label = r2 - Integer.MIN_VALUE;
        L8:
            Object r0 = r1.result;
            Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r4 = r1.label;
            if (r4 == 0) goto L14;
            if (r4 != 1) goto L13;
            ResultKt.throwOnFailure(r0);
            return ((Result) r0).unbox-impl();
        L13:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L14:
            ResultKt.throwOnFailure(r0);
            MmCreateAudioRequest r5 = new MmCreateAudioRequest(r17, r18, r19, r20, r21, r22, r23, r24);
            r1.label = 1;
            Object r6 = r16.c(MmCreateAudioResponse.class, r5, r1);
            if (r6 != r3) goto L18;
            return r3;
        L18:
            return r6;
        L7:
            r1 = new MmRecordingCreateService$Companion$sendCreateRecordingObjectRequest$1(this, r25);
            goto L8
        }
    }

    public interface a {
        void a(Object r1);

        void b(Object r1);
    }

    static {
        j = new Companion();
    }

    public MmRecordingCreateService(com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a r6) {
        Intrinsics.checkNotNullParameter(r6, "userComponentContext");
        Intrinsics.checkNotNullParameter(r6, "userComponentContext");
        this.a = r6;
        this.b = 5000;
        String r7 = "MmRecordingCreateService_" + hashCode();
        this.d = r7;
        CoroutineScope r0 = CoroutineScopeKt.CoroutineScope(MMCoroutines.a().plus(SupervisorKt.SupervisorJob$default(null, 1, null)));
        this.e = r0;
        this.i = j1.a(Boolean.TRUE);
        Object r1 = MmNetworkUtils.a;
        this.f = MmNetworkUtils.c("createAudio", r0, 500, new AnonymousClass1(this));
        lvb.a.e(r7, "Network state listener registered");
    }

    public static final void b(MmRecordingCreateService r18, String r19, Throwable r20) {
        r18.getClass();
        String r2 = null;
        if ((r20 instanceof MmCreateRecordingException.MmRecordingOtherException) == false) goto L5;
        MmCreateRecordingException.MmRecordingOtherException r1 = (MmCreateRecordingException.MmRecordingOtherException) r20;
    L6:
        if (r1 == null) goto L8;
        Integer r6 = Integer.valueOf(r1.getErrorCode());
    L9:
        qvb.a r3 = qvb.a.a;
        if (r20 == null) goto L12;
        String r4 = r20.getMessage();
    L13:
        if (r4 != null) goto L15;
    L18:
        boolean r5 = true;
    L19:
        if (r5 == false) goto L21;
        String r7 = r19;
    L26:
        if (r20 == null) goto L28;
        r2 = r20.getClass().getSimpleName();
    L28:
        if (r2 != null) goto L30;
        String r8 = "";
    L31:
        Intrinsics.checkNotNullParameter(r7, "errorMsg");
        Intrinsics.checkNotNullParameter(r8, "responseName");
        Intrinsics.checkNotNullParameter("error", "severity");
        qvb.a.c(r3, "creation", "error", r6, r7, r8, null, null, null, null, null, null, Boolean.valueOf(NetworkUtils.d(LarkContext.getApplication())), null, 6112);
        return;
    L30:
        r8 = r2;
        goto L31
    L21:
        StringBuilder r9 = new StringBuilder();
        r9.append(r19);
        r9.append(':');
        if (r20 == null) goto L24;
        String r10 = r20.getMessage();
    L25:
        r9.append(r10);
        r7 = r9.toString();
        goto L26
    L24:
        r10 = null;
        goto L25
    L15:
        if (StringsKt.isBlank(r4) == true) goto L18;
        r5 = false;
        goto L19
    L12:
        r4 = null;
        goto L13
    L8:
        r6 = null;
        goto L9
    L5:
        r1 = null;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object c(String r21, int r22, Function0<? extends MmCreateAudioRequest.CreateMinutesStatus> r23, DoubaoBizInfo r24, MmRecordingSource r25, String r26, boolean r27, Continuation<? super String> r28) {
        if ((r28 instanceof MmRecordingCreateService$createRecordObjectWithAdvancedRetry$1) == false) goto L7;
        MmRecordingCreateService$createRecordObjectWithAdvancedRetry$1 r2 = (MmRecordingCreateService$createRecordObjectWithAdvancedRetry$1) r28;
        int r3 = r2.label;
        if ((r3 & Integer.MIN_VALUE) == 0) goto L7;
        r2.label = r3 - Integer.MIN_VALUE;
    L8:
        MmRecordingCreateService$createRecordObjectWithAdvancedRetry$1 r12 = r2;
        Object r1 = r12.result;
        Object r13 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r12.label;
        if (r4 == 0) goto L18;
        if (r4 != 1) goto L17;
        Deferred r5 = (Deferred) r12.L$0;
        ResultKt.throwOnFailure(r1);     // Catch: Throwable -> L14
        r4 = r5;
    L36:
        String r6 = (String) r1;     // Catch: Throwable -> L14
        if (this.h != r4) goto L40;
        this.h = null;
    L40:
        return r6;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r1);
        if (r21.length() != 0) goto L21;
        boolean r7 = true;
    L22:
        if (r7 == false) goto L25;
        lvb.a.b(this.d, "createMinutesTokenWithAdvancedRetry failed: meetingId is empty");
        qvb.a.g("meeting_id_empty", "create_minutes_token", null, 9);
        return null;
    L25:
        String r8 = this.d;
        StringBuilder r9 = new StringBuilder("createMinutesTokenWithAdvancedRetry meetingId:");
        r9.append(r21);
        r9.append(", createAudioStatus: ");
        if (r23 == null) goto L28;
        MmCreateAudioRequest.CreateMinutesStatus r10 = (MmCreateAudioRequest.CreateMinutesStatus) r23.invoke();
    L29:
        r9.append(r10);
        lvb.a.e(r8, r9.toString());
        Deferred r11 = this.h;
        if (r11 == null) goto L32;
        Job.DefaultImpls.cancel$default(r11, null, 1, null);
    L32:
        this.h = null;
        this.g = r21;
        Deferred r14 = BuildersKt.async$default(this.e, null, CoroutineStart.LAZY, new MmRecordingCreateService$createRecordObjectWithAdvancedRetry$result$1(this, r22, r21, r23, r24, r25, r26, r27, null), 1, null);
        this.h = r14;
        r14.start();
        r12.L$0 = r14;     // Catch: Throwable -> L14
        r12.label = 1;     // Catch: Throwable -> L14
        r1 = r14.await(r12);     // Catch: Throwable -> L14
        r4 = r14;
        if (r1 != r13) goto L36;
        return r13;
    L28:
        r10 = null;
        goto L29
    L21:
        r7 = false;
    L14:
        th = move-exception;
        if (this.h != r4) goto L44;
        this.h = null;
    L44:
        throw th;
    L7:
        r2 = new MmRecordingCreateService$createRecordObjectWithAdvancedRetry$1(this, r28);
        goto L8
    }

    public static final Object a(MmRecordingCreateService r17, com.ss.android.lark.officesdk.minutes.service.foundation.network.b r18, String r19, MmCreateAudioRequest.CreateMinutesStatus r20, DoubaoBizInfo r21, MmRecordingSource r22, String r23, boolean r24, Continuation r25) {
        r17.getClass();
        if ((r25 instanceof MmRecordingCreateService$createMinutesTokenOnce$1) == false) goto L7;
        MmRecordingCreateService$createMinutesTokenOnce$1 r2 = (MmRecordingCreateService$createMinutesTokenOnce$1) r25;
        int r3 = r2.label;
        if ((r3 & Integer.MIN_VALUE) == 0) goto L7;
        r2.label = r3 - Integer.MIN_VALUE;
    L8:
        MmRecordingCreateService$createMinutesTokenOnce$1 r13 = r2;
        Object r1 = r13.result;
        Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r13.label;
        boolean r14 = false;
        if (r5 == 0) goto L14;
        if (r5 != 1) goto L13;
        boolean r6 = r13.Z$0;
        String r7 = (String) r13.L$2;
        MmRecordingSource r8 = (MmRecordingSource) r13.L$1;
        DoubaoBizInfo r9 = (DoubaoBizInfo) r13.L$0;
        ResultKt.throwOnFailure(r1);
        Object r10 = ((Result) r1).unbox-impl();
        DoubaoBizInfo r11 = r9;
    L27:
        String r12 = null;
        Object r15 = null;
        Object r16 = null;
        Integer r26 = null;
        if (Result.isFailure-impl(r10) == false) goto L30;
        Object r27 = null;
    L31:
        MmCreateAudioResponse r28 = (MmCreateAudioResponse) r27;
        if (r28 == null) goto L35;
        r28.normalizeObjectToken();
    L35:
        if (Result.isFailure-impl(r10) == false) goto L37;
        Object r29 = null;
    L38:
        MmCreateAudioResponse r30 = (MmCreateAudioResponse) r29;
        if (r30 == null) goto L41;
        boolean r31 = r30.getCanAudioCreateRetry();
    L43:
        if (Result.isFailure-impl(r10) == false) goto L45;
        Object r32 = null;
    L46:
        MmCreateAudioResponse r33 = (MmCreateAudioResponse) r32;
        String r34 = "";
        if (r33 == null) goto L50;
        String r35 = r33.getObjectToken();
        if (r35 == null) goto L50;
    L52:
        if (Result.isFailure-impl(r10) == false) goto L54;
        Object r110 = null;
    L55:
        MmCreateAudioResponse r111 = (MmCreateAudioResponse) r110;
        if (r111 == null) goto L65;
        String r112 = r111.getRecordingId();
        if (r112 == null) goto L65;
        if ((!StringsKt.isBlank(r112)) == true) goto L63;
        r112 = null;
    L63:
        if (r112 == null) goto L65;
    L75:
        if (r6 == false) goto L89;
        if (r112.length() <= 0) goto L79;
        boolean r36 = true;
    L80:
        if (r36 == false) goto L89;
        if (Result.isFailure-impl(r10) == true) goto L85;
        r15 = r10;
    L85:
        MmCreateAudioResponse r37 = (MmCreateAudioResponse) r15;
        if (r37 == null) goto L211;
        r37.setRecordingId(r112);
    L211:
        return r10;
    L79:
        r36 = false;
    L89:
        if (r35.length() <= 0) goto L91;
        boolean r38 = true;
    L92:
        if (r38 == true) goto L211;
        Intrinsics.areEqual(OfficeSDKManager.isDebug(), Boxing.boxBoolean(true));
        ErrorResult r39 = Result.exceptionOrNull-impl(r10);
        if ((r39 instanceof ErrorResult) == false) goto L97;
        ErrorResult r40 = r39;
    L98:
        lvb.a.b(r17.d, "errorResult:" + r40);
        if (Result.isSuccess-impl(r10) == false) goto L108;
        if (r31 == true) goto L108;
        qvb.a r0 = qvb.a.a;
        if (r8 == null) goto L104;
        String r41 = r8.name();
    L105:
        if (r41 != null) goto L107;
        r41 = "";
    L107:
        qvb.a.g("create_minutes_token_empty_result", r41, null, 9);
        goto L108
    L104:
        r41 = null;
    L108:
        c r42 = c.a;
        if (r35.length() != 0) goto L111;
        boolean r43 = true;
    L112:
        r42.getClass();
        boolean r44 = c.b(r40);
        if (r40 != null) goto L115;
    L117:
        boolean r45 = false;
    L118:
        if (r45 == true) goto L127;
        if (r40 != null) goto L121;
    L123:
        boolean r46 = false;
    L124:
        if (r46 == true) goto L127;
        boolean r47 = false;
    L128:
        if (r47 == false) goto L158;
        MmCreateRecordingException.MmRecordingNoQuotaException r48 = new MmCreateRecordingException.MmRecordingNoQuotaException();
        if (r40 == null) goto L132;
        String r49 = r40.getDebugMsg();
    L133:
        String r50 = c.a(r49);
        if (r50 != null) goto L209;
    L152:
        if (r26 == null) goto L154;
        b r51 = new b.d(r26.intValue());
    L155:
        if (r44 == false) goto L157;
        r51 = b.c.a;
    L157:
        com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.statessync.a r52 = new com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.statessync.a(r48, r51);
    L208:
        return Result.constructor-impl(ResultKt.createFailure(r52.a));
    L154:
        r51 = b.a.a;
        goto L155
    L209:
        JSONObject r53 = new JSONObject(r50);     // Catch: Throwable -> L145
        if (r53.has("deny_type") == false) goto L140;
        Integer r54 = Integer.valueOf(r53.optInt("deny_type"));     // Catch: Throwable -> L145
    L143:
        Object r55 = Result.constructor-impl(r54);     // Catch: Throwable -> L145
    L148:
        if (Result.isFailure-impl(r55) == true) goto L151;
        r16 = r55;
    L151:
        r26 = (Integer) r16;
        goto L152
    L140:
        if (r53.has("denyType") == false) goto L142;
        r54 = Integer.valueOf(r53.optInt("denyType"));     // Catch: Throwable -> L145
        goto L143
    L142:
        r54 = null;
    L145:
        th = move-exception;
        Result.Companion r56 = Result.Companion;
        r55 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L148
    L132:
        r49 = null;
        goto L133
    L158:
        if (r40 != null) goto L160;
    L162:
        boolean r57 = false;
    L163:
        if (r57 == false) goto L168;
        MmCreateRecordingException.MmRecordingCreateFailedException r58 = new MmCreateRecordingException.MmRecordingCreateFailedException();
        b r59 = b.C0027b.a;
        if (r44 == false) goto L167;
        r59 = b.c.a;
    L167:
        r52 = new com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.statessync.a(r58, r59);
        goto L208
    L168:
        if (r40 != null) goto L170;
    L172:
        if (r14 == false) goto L174;
        r52 = new com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.statessync.a(new MmCreateRecordingException.MmRecordingOccupiedException(), b.c.a);
        goto L208
    L174:
        if (r43 == false) goto L198;
        if (r31 == true) goto L198;
        MmCreateRecordingException.MmRecordingCreateFailedException r60 = new MmCreateRecordingException.MmRecordingCreateFailedException();
        boolean r61 = r40 instanceof ErrorResult;
        if (r61 == false) goto L179;
        ErrorResult r62 = r40;
    L181:
        if (c.b(r62) == false) goto L183;
        b r63 = b.c.a;
    L194:
        if (r44 == false) goto L196;
        r63 = b.c.a;
    L196:
        r52 = new com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.statessync.a(r60, r63);
        goto L208
    L183:
        if (r61 == false) goto L186;
        r12 = r40.getDebugMsg();
    L190:
        String r64 = c.a(r12);
        if (r64 == null) goto L193;
        r63 = new b.e(r64);
        goto L194
    L193:
        r63 = b.a.a;
        goto L194
    L186:
        if ((r40 instanceof MmCreateRecordingException.MmRecordingOtherException) == false) goto L188;
        r12 = ((MmCreateRecordingException.MmRecordingOtherException) r40).getErrorMsg();
        goto L190
    L188:
        if (r40 == null) goto L190;
        r12 = r40.getMessage();
        goto L190
    L179:
        r62 = null;
    L198:
        if (r40 == null) goto L200;
        int r65 = r40.getCode();
    L201:
        if (r40 == null) goto L206;
        String r66 = r40.getDebugMsg();
        if (r66 == null) goto L206;
        r34 = r66;
    L206:
        r52 = new com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.statessync.a(new MmCreateRecordingException.MmRecordingOtherException(r65, r34), b.c.a);
        goto L208
    L200:
        r65 = -1;
        goto L201
    L170:
        if (r40.getCode() != 409) goto L172;
        r14 = true;
        goto L172
    L160:
        if (r40.getCode() != 220204) goto L162;
        r57 = true;
        goto L163
    L121:
        if (r40.getStatus() != 1007) goto L123;
        r46 = true;
    L127:
        r47 = true;
        goto L128
    L115:
        if (r40.getCode() != 220202) goto L117;
        r45 = true;
        goto L118
    L111:
        r43 = false;
        goto L112
    L97:
        r40 = null;
        goto L98
    L91:
        r38 = false;
    L65:
        if ((!StringsKt.isBlank(r7)) == true) goto L68;
        r7 = null;
    L68:
        if (r7 != null) goto L74;
        if (r11 == null) goto L71;
        r112 = r11.getRecordingId();
    L72:
        if (r112 != null) goto L75;
        r112 = "";
        goto L75
    L71:
        r112 = null;
        goto L72
    L74:
        r112 = r7;
        goto L75
    L54:
        r110 = r10;
    L50:
        r35 = "";
        goto L52
    L45:
        r32 = r10;
        goto L46
    L41:
        r31 = true;
        goto L43
    L37:
        r29 = r10;
        goto L38
    L30:
        r27 = r10;
        goto L31
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r1);
        int r67 = r17.a.getSettingsService().h.getSliceDurationInSec();
        if (1 <= r67) goto L17;
    L19:
        boolean r68 = false;
    L20:
        if (r68 == false) goto L22;
        int r69 = r67;
    L23:
        Companion r70 = j;
        String r71 = UIHelper.getString(2131892881);
        r11 = r21;
        r13.L$0 = r11;
        r13.L$1 = r22;
        r13.L$2 = r23;
        r13.Z$0 = r24;
        r13.label = 1;
        Object r72 = r70.a(r18, r19, r71, r69, r20, r21, r22, r23, r24, r13);
        if (r72 == r4) goto L212;
        r8 = r22;
        r6 = r24;
        r10 = r72;
        r7 = r23;
        goto L27
    L212:
        return r4;
    L22:
        r69 = 3;
        goto L23
    L17:
        if (r67 >= 61) goto L19;
        r68 = true;
    L7:
        r2 = new MmRecordingCreateService$createMinutesTokenOnce$1(r17, r25);
        goto L8
    }
}
