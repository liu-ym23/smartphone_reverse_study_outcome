package com.ss.android.lark.officesdk.minutes.assembly.recording.common;

import android.app.Activity;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingSource;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingUILaunchMode;
import com.ss.android.lark.officesdk.minutes.api.recording.doubao.applet.route.MmAppletPage;
import com.ss.android.lark.officesdk.minutes.assembly.recording.common.router.MmRecordPageRouter;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.MmRecordingSession;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.MmRecordingRepo;
import com.ss.android.lark.officesdk.minutes.ui.record.endwindow.MmBaseEndWindowActivity;
import com.ss.android.lark.picker.base.view.ItemViewType;
import iub.k;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt__LimitKt$take$;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.assembly.recording.common.MmRecordingCapacityImpl$observeEndRecordingEvent$1", f = "MmRecordingCapacityImpl.kt", i = {}, l = {381}, m = "invokeSuspend", n = {}, s = {})
final class MmRecordingCapacityImpl$observeEndRecordingEvent$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Flow<com.ss.android.lark.officesdk.minutes.service.recording.common.repo.endwindow.g> $endRecordingEventFlow;
    final /* synthetic */ Ref.ObjectRef<Job> $observeEndWindowJob;
    final /* synthetic */ String $recordingId;
    final /* synthetic */ MmRecordingSession $session;
    final /* synthetic */ MmRecordingUILaunchMode $uiLaunchMode;
    int label;
    final /* synthetic */ MmRecordingCapacityImpl this$0;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ MmRecordingSession a;
        public final /* synthetic */ MmRecordingCapacityImpl b;
        public final /* synthetic */ MmRecordingUILaunchMode c;
        public final /* synthetic */ Ref.ObjectRef<Job> d;
        public final /* synthetic */ String e;

        public a(MmRecordingSession r1, MmRecordingCapacityImpl r2, MmRecordingUILaunchMode r3, Ref.ObjectRef<Job> r4, String r5) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
        }

        public final Object emit(Object r12, Continuation r13) {
            com.ss.android.lark.officesdk.minutes.service.recording.common.repo.endwindow.g r14 = (com.ss.android.lark.officesdk.minutes.service.recording.common.repo.endwindow.g) r12;
            String r15 = this.a.e();
            String r0 = this.e;
            if (StringsKt.isBlank(r15) == false) goto L5;
            r15 = r0;
        L5:
            String r1 = this.b.d;
            StringBuilder r2 = new StringBuilder("[observeEndRecordingEvent] EndRecording received, entity=");
            boolean r4 = false;
            if (r14.a == null) goto L8;
            boolean r3 = true;
        L9:
            r2.append(r3);
            r2.append(", source=");
            k r5 = this.a.f;
            if (r5 == null) goto L12;
            MmRecordingSource r6 = r5.a;
        L13:
            r2.append(r6);
            lvb.a.e(r1, r2.toString());
            MmRecordPageRouter r7 = (MmRecordPageRouter) this.b.h.getValue();
            MmRecordingCapacityImpl r8 = this.b;
            yub.d r9 = yub.d.a;
            Activity r10 = MmRecordingCapacityImpl.a(r8, com.ss.android.lark.appcontext.applifecycle2.api.a.a());
            MmRecordingUILaunchMode r11 = this.c;
            com.ss.android.lark.officesdk.minutes.service.recording.common.repo.endwindow.c r16 = r14.a;
            r7.getClass();
            Intrinsics.checkNotNullParameter(r15, "recordingId");
            Intrinsics.checkNotNullParameter(r11, "uiLaunchMode");
            if (r11.shouldHandleUI() == true) goto L17;
            lvb.a.e("MmRecordPageRouter", "[routeToEndWindow] skip route, uiLaunchMode=" + r11 + ", recordingId=" + r15);
        L72:
            Job r17 = (Job) this.d.element;
            if (r17 == null) goto L75;
            Job.DefaultImpls.cancel$default(r17, null, 1, null);
        L75:
            MmRecordingRepo r18 = this.a.f();
            if (r18 == null) goto L78;
            r18.B();
        L78:
            wub.a.a.clear();
            return Unit.INSTANCE;
        L17:
            if (r11.supportAppletNavigator() == true) goto L19;
            uub.a r19 = null;
        L20:
            StringBuilder r20 = new StringBuilder("[routeToEndWindow] uiLaunchMode=");
            r20.append(r11);
            r20.append(", hasNavigator=");
            if (r19 == null) goto L23;
            boolean r110 = true;
        L24:
            r20.append(r110);
            r20.append(", recordingId=");
            r20.append(r15);
            lvb.a.e("MmRecordPageRouter", r20.toString());
            if (r19 != null) goto L27;
            if (r16 == null) goto L64;
            if (r10 == null) goto L64;
            if (StringsKt.isBlank(r16.a) == false) goto L48;
            r16 = com.ss.android.lark.officesdk.minutes.service.recording.common.repo.endwindow.c.a(r16, r15, null, null, 1022);
        L48:
            bwb.a.a.getClass();
            Intrinsics.checkNotNullParameter(r10, "context");
            Intrinsics.checkNotNullParameter(r16, "entity");
            com.ss.android.lark.officesdk.minutes.ui.style.e.a.getClass();
            com.ss.android.lark.officesdk.minutes.ui.style.contract.h r21 = com.ss.android.lark.officesdk.minutes.ui.style.e.c(r11);
            if (r21 == null) goto L62;
            String r22 = r21.getActivity().a();
            if (StringsKt.isBlank(r22) == false) goto L80;
            lvb.a.b("MmRecordPageRouter", "[startEndWindow] activityClassName is blank, ui=" + r11);
            goto L62
        L80:
            Result.Companion r23 = Result.Companion;     // Catch: Throwable -> L56
            int r24 = MmBaseEndWindowActivity.d;     // Catch: Throwable -> L56
            MmBaseEndWindowActivity.a.a(r10, r22, r16);     // Catch: Throwable -> L56
            Object r111 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L56
        L58:
            Throwable r25 = Result.exceptionOrNull-impl(r111);
            if (r25 == null) goto L61;
            lvb.a.b("MmRecordPageRouter", "[startEndWindow] ui=" + r11 + ", error=" + r25);
        L61:
            r4 = Result.isSuccess-impl(r111);
        L56:
            th = move-exception;
            Result.Companion r26 = Result.Companion;
            r111 = Result.constructor-impl(ResultKt.createFailure(th));
        L62:
            if (r4 == true) goto L72;
            lvb.a.b("MmRecordPageRouter", "[routeToNativeEndWindow] fallback failed, recordingId=" + r15);
            r7.a.N().e(r15);
        L64:
            StringBuilder r27 = new StringBuilder("[routeToNativeEndWindow] skip route, activity=");
            if (r10 == null) goto L67;
            boolean r28 = true;
        L68:
            r27.append(r28);
            r27.append(", entity=");
            if (r16 == null) goto L71;
            r4 = true;
        L71:
            r27.append(r4);
            lvb.a.b("MmRecordPageRouter", r27.toString());
            r7.a.N().e(r15);
            goto L72
        L67:
            r28 = false;
            goto L68
        L27:
            if (r16 == null) goto L40;
            if (r10 == null) goto L40;
            String r29 = r16.a;
            if (StringsKt.isBlank(r29) == true) goto L34;
            r15 = r29;
        L34:
            if (StringsKt.isBlank(r15) == false) goto L37;
            lvb.a.b("MmRecordPageRouter", "[handleEndWindowAvailable] skip open end window because sessionId is blank");
            lvb.a.e("MmRecordPageRouter", "[handleEndWindowUnavailable] closeApplet in applet");
            r7.a.N().e(r15);
            r19.n0();
            goto L72
        L37:
            if (StringsKt.isBlank(r16.a) == false) goto L39;
            r16 = com.ss.android.lark.officesdk.minutes.service.recording.common.repo.endwindow.c.a(r16, r15, null, null, 1022);
        L39:
            int r30 = com.ss.android.lark.officesdk.minutes.api.recording.doubao.applet.route.a.b;
            Intrinsics.checkNotNullParameter(r15, "sessionId");
            MmAppletPage.a r31 = MmAppletPage.Companion;
            MmAppletPage r32 = MmAppletPage.END_WINDOW;
            r31.getClass();
            String r112 = MmAppletPage.a.a(r32, r15);
            ConcurrentHashMap<String, Object> r33 = uub.c.a;
            Intrinsics.checkNotNullParameter(r112, "dataKey");
            Intrinsics.checkNotNullParameter(r16, "data");
            uub.c.a.put(r112, r16);
            r19.Z0(r10, new com.ss.android.lark.officesdk.minutes.api.recording.doubao.applet.route.a(r112));
            lvb.a.e("MmRecordPageRouter", "[handleEndWindowAvailable] reLaunch to end window success");
        L40:
            if (r10 != null) goto L42;
            lvb.a.e("MmRecordPageRouter", "[routeToAppletEndWindow] skip open end window because activity is null");
        L42:
            lvb.a.e("MmRecordPageRouter", "[handleEndWindowUnavailable] closeApplet in applet");
            r7.a.N().e(r15);
            r19.n0();
            goto L72
        L23:
            r110 = false;
            goto L24
        L19:
            r19 = (uub.a) r7.a.u(uub.a.class);
            goto L20
        L12:
            r6 = null;
            goto L13
        L8:
            r3 = false;
            goto L9
        }
    }

    public MmRecordingCapacityImpl$observeEndRecordingEvent$1(Flow<com.ss.android.lark.officesdk.minutes.service.recording.common.repo.endwindow.g> r1, MmRecordingSession r2, MmRecordingCapacityImpl r3, MmRecordingUILaunchMode r4, Ref.ObjectRef<Job> r5, String r6, Continuation<? super MmRecordingCapacityImpl$observeEndRecordingEvent$1> r7) {
        this.$endRecordingEventFlow = r1;
        this.$session = r2;
        this.this$0 = r3;
        this.$uiLaunchMode = r4;
        this.$observeEndWindowJob = r5;
        this.$recordingId = r6;
        super(2, r7);
    }

    public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
        return new MmRecordingCapacityImpl$observeEndRecordingEvent$1(this.$endRecordingEventFlow, this.$session, this.this$0, this.$uiLaunchMode, this.$observeEndWindowJob, this.$recordingId, r10);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r10);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        FlowKt__LimitKt$take$.inlined.unsafeFlow.1 r2 = new FlowKt__LimitKt$take$.inlined.unsafeFlow.1(kotlinx.coroutines.flow.e.w(this.$endRecordingEventFlow, Dispatchers.getMain()));
        a r11 = new a(this.$session, this.this$0, this.$uiLaunchMode, this.$observeEndWindowJob, this.$recordingId);
        this.label = 1;
        if (r2.collect(r11, this) != r0) goto L12;
        return r0;
    }
}
