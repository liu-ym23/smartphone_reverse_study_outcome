package com.larus.audio.asr;

import android.os.SystemClock;
import com.bytedance.flow_audio.api.business.asr.error.FlowAsrErrorType;
import com.larus.audio.audiov3.config.task.sami.asr.AsrResultState;
import com.larus.audio.audiov3.task.asr.AsrEventEnum;
import com.larus.audio.audiov3.task.asr.sami.data.AudioEvent;
import com.larus.audio.report.IAsrTracerFactory;
import com.larus.bmhome.chat.model.repo.IRepoDispatcherService;
import com.larus.bmhome.chat.model.repo.ISettingRepoService;
import com.larus.bmhome.chat.model.repo.RepoDispatcherDelegate;
import com.larus.im.bean.message.Message;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class o implements com.larus.audio.l0 {
    public static final o a = null;
    public static final Lazy b = null;
    public static final Lazy c = null;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[FlowAsrErrorType.values().length];
            r0[FlowAsrErrorType.SOURCE_START_FAILED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r0[FlowAsrErrorType.SOURCE_STOP_FAILED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r0[FlowAsrErrorType.SOURCE_RELEASE_FAILED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[FlowAsrErrorType.SOURCE_PREPARE_FAILED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            a = r0;
        }
    }

    public static final class b implements lw5.h {
        public final /* synthetic */ Ref.BooleanRef b;
        public final /* synthetic */ com.larus.audio.report.h c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;
        public final /* synthetic */ Long f;
        public final /* synthetic */ Continuation<p68.a> g;

        public final void T2(lw5.c r21) {
            Intrinsics.checkNotNullParameter(r21, "result");
            o r2 = o.a;
            o.b(this.d, this.e);
            iw5.c r3 = r21.b;
            if (r3 == null) goto L5;
            iw5.b r4 = r3.e;
        L6:
            if (r4 == null) goto L22;
            if (r3 == null) goto L22;
            iw5.b r5 = r3.e;
            if (r5 == null) goto L22;
            String r6 = r21.a;
            String r7 = r5.a;
            List r8 = r5.b;
            if ((!r8.isEmpty()) == true) goto L14;
            r8 = null;
        L14:
            if (r8 == null) goto L20;
            Lazy r9 = com.larus.utils.gson.b.a;
            List r10 = r8;
            ArrayList r11 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r10, 10));
            Iterator r12 = r10.iterator();
        L17:
            if (r12.hasNext() == false) goto L19;
            iw5.a r13 = (iw5.a) r12.next();
            o r14 = o.a;
            r11.add(new AudioEvent(r13.getType(), r13.b, r13.c, r13.d));
            goto L17
        L19:
            String r15 = com.larus.utils.gson.b.a(r11);
        L21:
            com.larus.audio.c r16 = new com.larus.audio.c(r6, r7, r15, r5.c);
        L23:
            iw5.c r0 = r21.b;
            if (r0 == null) goto L26;
            String r1 = r0.a;
        L27:
            if (r1 != null) goto L29;
            r1 = "";
        L29:
            com.larus.audio.report.h r17 = this.c;
            if (r17 == null) goto L46;
            String r19 = this.d;
            Long r20 = this.f;
            if (r20 == null) goto L34;
            long r110 = r20.longValue();
        L35:
            AsrResultState r111 = AsrResultState.SUCCESS;
            AsrEventEnum r112 = AsrEventEnum.ASR_SUCCESS;
            if (r16 == null) goto L38;
            String r22 = r16.b;
        L39:
            if (r16 == null) goto L41;
            String r23 = r16.c;
        L42:
            if (r16 == null) goto L44;
            String r24 = r16.d;
        L45:
            r17.t(new y58.b(r19, null, null, r1, null, r110, r111, r112, new y58.c(r22, r23, r24), 22), r1);
            goto L46
        L44:
            r24 = null;
            goto L45
        L41:
            r23 = null;
            goto L42
        L38:
            r22 = null;
            goto L39
        L34:
            r110 = 0;
        L46:
            Continuation<p68.a> r25 = this.g;
            String r26 = this.d;
            Long r27 = this.f;
            Result.Companion r29 = Result.Companion;     // Catch: Throwable -> L57
            if (r27 == null) goto L50;
            long r113 = r27.longValue();     // Catch: Throwable -> L57
        L52:
            if (r16 == null) goto L54;
            String r114 = r16.d;     // Catch: Throwable -> L57
        L55:
            r25.resumeWith(Result.constructor-impl(new p68.a.b(r26, r1, r113, "", r114)));     // Catch: Throwable -> L57
            Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L57
        L59:
            o r30 = o.a;
            return;
        L54:
            r114 = null;
            goto L55
        L50:
            r113 = 0;
        L57:
            th = move-exception;
            Result.Companion r31 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
            goto L59
        L26:
            r1 = null;
            goto L27
        L20:
            r15 = null;
        L22:
            r16 = null;
            goto L23
        L5:
            r4 = null;
            goto L6
        }

        public final void c1(hw5.a r19) {
            Intrinsics.checkNotNullParameter(r19, "error");
            long r4 = 0;
            if (r19.getType() != FlowAsrErrorType.EMPTY_RESULT) goto L12;
            o r2 = o.a;
            o.b(this.d, this.e);
            com.larus.audio.report.h r3 = this.c;
            if (r3 == null) goto L26;
            String r7 = this.d;
            Long r6 = this.f;
            if (r6 == null) goto L9;
            long r12 = r6.longValue();
        L10:
            r3.t(new y58.b(r7, null, null, "", null, r12, AsrResultState.SUCCESS, AsrEventEnum.ASR_SUCCESS, null, 22), "");
            goto L26
        L9:
            r12 = 0;
        L26:
            Continuation<p68.a> r5 = this.g;
            String r8 = this.d;
            String r9 = this.e;
            Long r10 = this.f;
            Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L32
            if (r10 == null) goto L30;
            r4 = r10.longValue();     // Catch: Throwable -> L32
        L30:
            r5.resumeWith(Result.constructor-impl(new p68.a.C0119a(r8, r9, r4, Integer.valueOf(r19.c))));     // Catch: Throwable -> L32
            Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L32
        L34:
            o r0 = o.a;
            return;
        L32:
            th = move-exception;
            Result.Companion r13 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
            goto L34
        L12:
            if (this.b.element == true) goto L26;
            o r14 = o.a;
            int r15 = a.a[r19.getType().ordinal()];
            boolean r16 = true;
            if (r15 == 1) goto L21;
            if (r15 == 2) goto L21;
            if (r15 == 3) goto L21;
            if (r15 == 4) goto L21;
        L22:
            if (r16 == false) goto L26;
            com.larus.audio.report.h r17 = this.c;
            if (r17 == null) goto L26;
            r17.r(2, r19.b, r19.c);
        L21:
            r16 = false;
            goto L22
        }

        public final void n(boolean r3) {
            if (r3 == false) goto L4;
            this.b.element = true;
        L4:
            com.larus.audio.report.h r0 = this.c;
            if (r0 == null) goto L8;
            r0.n(r3);
            return;
        }

        public b(Ref.BooleanRef r1, com.larus.audio.report.h r2, String r3, String r4, Long r5, SafeContinuation r6) {
            this.b = r1;
            this.c = r2;
            this.d = r3;
            this.e = r4;
            this.f = r5;
            this.g = r6;
        }
    }

    public static final class c implements Function1<com.larus.audio.b, Unit> {
        public final /* synthetic */ Continuation<p68.a> a;

        public c(SafeContinuation r1) {
            this.a = r1;
        }

        public final Object invoke(Object r10) {
            com.larus.audio.b r11 = (com.larus.audio.b) r10;
            Intrinsics.checkNotNullParameter(r11, "result");
            Continuation<p68.a> r0 = this.a;
            Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L9
            String r3 = r11.a;     // Catch: Throwable -> L9
            String r4 = r11.b;     // Catch: Throwable -> L9
            long r5 = r11.c;     // Catch: Throwable -> L9
            String r7 = r11.d;     // Catch: Throwable -> L9
            com.larus.audio.c r12 = r11.g;     // Catch: Throwable -> L9
            if (r12 == null) goto L6;
            String r13 = r12.d;     // Catch: Throwable -> L9
        L7:
            r0.resumeWith(Result.constructor-impl(new p68.a.b(r3, r4, r5, r7, r13)));     // Catch: Throwable -> L9
            Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L9
        L11:
            o r14 = o.a;
            return Unit.INSTANCE;
        L6:
            r13 = null;
        L9:
            th = move-exception;
            Result.Companion r2 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
            goto L11
        }
    }

    public static final class d implements Function4<String, String, Long, Integer, Unit> {
        public final /* synthetic */ Continuation<p68.a> a;

        public d(SafeContinuation r1) {
            this.a = r1;
        }

        public final Object invoke(Object r7, Object r8, Object r9, Object r10) {
            String r1 = (String) r7;
            String r2 = (String) r8;
            long r3 = ((Number) r9).longValue();
            int r11 = ((Number) r10).intValue();
            Intrinsics.checkNotNullParameter(r1, "taskId");
            Intrinsics.checkNotNullParameter(r2, "path");
            Continuation<p68.a> r12 = this.a;
            Result.Companion r13 = Result.Companion;     // Catch: Throwable -> L5
            r12.resumeWith(Result.constructor-impl(new p68.a.C0119a(r1, r2, r3, Integer.valueOf(r11))));     // Catch: Throwable -> L5
            Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L5
        L7:
            o r14 = o.a;
            return Unit.INSTANCE;
        L5:
            th = move-exception;
            Result.Companion r15 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
            goto L7
        }
    }

    public static final class e implements Function2<String, JSONObject, Unit> {
        public static final e a = null;

        static {
            a = new e();
        }

        public e() {
        }

        public final Object invoke(Object r3, Object r4) {
            String r5 = (String) r3;
            JSONObject r6 = (JSONObject) r4;
            Intrinsics.checkNotNullParameter(r5, "eventName");
            Intrinsics.checkNotNullParameter(r6, "params");
            m0 r1 = l0.a;
            Intrinsics.checkNotNullParameter(r5, "eventName");
            m0 r0 = l0.a;
            if (r0 == null) goto L5;
            Map r7 = r0.B(r5);
        L6:
            if (r7 == null) goto L12;
            Iterator r8 = r7.entrySet().iterator();
        L9:
            if (r8.hasNext() == false) goto L12;
            Map.Entry r2 = (Map.Entry) r8.next();
            r6.put((String) r2.getKey(), r2.getValue());
        L12:
            return Unit.INSTANCE;
        L5:
            r7 = null;
            goto L6
        }
    }

    public o() {
    }

    static {
        a = new o();
        b = LazyKt.lazy(new l());
        c = LazyKt.lazy(new m());
    }

    public static void b(final String r1, final String r2) {
        if (r2.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L10;
        com.larus.utils.t0.a(new n(r2, r1));
        return;
    L10:
        return;
    L5:
        r0 = false;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v37 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6, types: [boolean, int] */
    @Override // com.larus.audio.l0
    public final Object a(Message r33, String r34, String r35, String r36, Long r37, boolean r38, String r39, boolean r40, n58.b r41, Continuation<? super p68.a> r42) {
        SafeContinuation r15 = new SafeContinuation(IntrinsicsKt.intercepted(r42));
        IRepoDispatcherService r0 = (IRepoDispatcherService) ServiceManager.get().getService(IRepoDispatcherService.class);
        if (r0 == null) goto L7;
        ISettingRepoService r1 = r0.c();
        if (r1 == null) goto L7;
        ?? r2 = r1.B();
    L8:
        JSONObject r13 = new JSONObject();
        r13.put("dumpRate", r2);
        r13.put("send_mq", r2);
        if (((Boolean) b.getValue()).booleanValue() == false) goto L29;
        int r3 = c68.b.a;
        c68.b.d("AsrCoroutine", "retry Asr with Kmp version, taskId=".concat(r34));
        RepoDispatcherDelegate r7 = RepoDispatcherDelegate.b;
        String r8 = r7.c().S0();
        Ref.BooleanRef r10 = new Ref.BooleanRef();
        IAsrTracerFactory r4 = (IAsrTracerFactory) ServiceManager.get().getService(IAsrTracerFactory.class);
        if (r4 == null) goto L17;
        long r5 = SystemClock.elapsedRealtime();
        if (r39 != null) goto L15;
        String r6 = "";
    L16:
        k78.b r9 = r4.a(r5, r34, r35, r6, e.a);
    L18:
        k78.b r12 = r9;
        if (r12 == null) goto L21;
        r12.b(true);
    L21:
        ww5.a r14 = (ww5.a) c.getValue();
        if (r14 == null) goto L30;
        com.larus.audio.i0 r11 = com.larus.audio.i0.a;
        if (r39 != null) goto L26;
        String r16 = "";
    L27:
        String r17 = r13.toString();
        String r19 = r7.c().Z(r8);
        r11.getClass();
        r14.U2(r34, com.larus.audio.i0.a(false, r35, r16, r34, r17, 500, r36, r8, r19), new b(r10, r12, r34, r36, r37, r15));
        goto L30
    L26:
        r16 = r39;
    L30:
        Object r20 = r15.getOrThrow();
        if (r20 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L33;
        DebugProbesKt.probeCoroutineSuspended(r42);
    L33:
        return r20;
    L15:
        r6 = r39;
        goto L16
    L17:
        r9 = null;
        goto L18
    L29:
        int r21 = c68.b.a;
        c68.b.d("AsrCoroutine", "start Asr with normal version, taskId=".concat(r34));
        AsrGlobals r22 = AsrGlobals.a;
        com.larus.audio.o0.a.a(r22, r34, null, null, new c(r15), new d(r15), null, null, 102);
        com.larus.audio.o0.a.b(r22, r33, r34, r35, r36, null, r13, r38, r39, r40, r37, r41, null, 0, null, null, null, null, 0, null, 522256);
    L7:
        r2 = 0;
        goto L8
    }
}
