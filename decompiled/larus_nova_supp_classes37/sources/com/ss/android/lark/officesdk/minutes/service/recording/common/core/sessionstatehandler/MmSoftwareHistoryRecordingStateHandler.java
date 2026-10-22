package com.ss.android.lark.officesdk.minutes.service.recording.common.core.sessionstatehandler;

import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingSource;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.MmRecordingSession;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.MinutesForegroundService;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.statessync.MmRecordingStatesSyncService;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.upload.MmRecordingUploadService;
import com.ss.android.lark.utils.UIHelper;
import java.util.concurrent.CancellationException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class MmSoftwareHistoryRecordingStateHandler extends f {
    public static final Companion h = null;
    public final String b;
    public final com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a c;
    public final Lazy d;
    public final Lazy e;
    public final Lazy f;
    public final Lazy g;

    public static final class Companion {
        public Companion() {
        }

        public final Object a(Function1<? super Continuation<? super String>, ? extends Object> r5, Function1<? super Throwable, Unit> r6, Continuation<? super String> r7) {
            if ((r7 instanceof MmSoftwareHistoryRecordingStateHandler$Companion$awaitRecordingIdForHistoryUpload$1) == false) goto L7;
            MmSoftwareHistoryRecordingStateHandler$Companion$awaitRecordingIdForHistoryUpload$1 r0 = (MmSoftwareHistoryRecordingStateHandler$Companion$awaitRecordingIdForHistoryUpload$1) r7;
            int r1 = r0.label;
            if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
            r0.label = r1 - Integer.MIN_VALUE;
        L8:
            Object r8 = r0.result;
            Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r3 = r0.label;
            if (r3 == 0) goto L16;
            if (r3 != 1) goto L15;
            r6 = (Function1) r0.L$0;
            ResultKt.throwOnFailure(r8);     // Catch: Throwable -> L22
        L20:
            return (String) r8;
        L15:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L16:
            ResultKt.throwOnFailure(r8);
            r0.L$0 = r6;     // Catch: Throwable -> L22
            r0.label = 1;     // Catch: Throwable -> L22
            r8 = r5.invoke(r0);     // Catch: Throwable -> L22
            if (r8 != r2) goto L20;
            return r2;
        L22:
            th = move-exception;
            if ((th instanceof CancellationException) == true) goto L27;
            r6.invoke(th);
            return null;
        L27:
            throw th;
        L7:
            r0 = new MmSoftwareHistoryRecordingStateHandler$Companion$awaitRecordingIdForHistoryUpload$1(this, r7);
            goto L8
        }
    }

    static {
        h = new Companion();
    }

    public final MmRecordingStatesSyncService d() {
        return (MmRecordingStatesSyncService) this.e.getValue();
    }

    public MmSoftwareHistoryRecordingStateHandler(final MmRecordingSession r2) {
        Intrinsics.checkNotNullParameter(r2, "recordingSession");
        super(r2);
        this.b = "MmHistoryRecordingHandler";
        this.c = r2.b;
        this.d = LazyKt.lazy(new MmSoftwareHistoryRecordingStateHandler$networkService$2(this));
        this.e = LazyKt.lazy(new MmSoftwareHistoryRecordingStateHandler$syncService$2(r2));
        this.f = LazyKt.lazy(new MmSoftwareHistoryRecordingStateHandler$uploadService$2(r2));
        this.g = LazyKt.lazy(new MmSoftwareHistoryRecordingStateHandler$historyUploadResumeTracker$2(r2));
    }

    public static final Object c(MmSoftwareHistoryRecordingStateHandler r4, Continuation r5) {
        r4.getClass();
        if ((r5 instanceof MmSoftwareHistoryRecordingStateHandler$buildHistoryForegroundNotificationAction$1) == false) goto L7;
        MmSoftwareHistoryRecordingStateHandler$buildHistoryForegroundNotificationAction$1 r0 = (MmSoftwareHistoryRecordingStateHandler$buildHistoryForegroundNotificationAction$1) r5;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r6 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        boolean r7 = true;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r6);
    L17:
        String r8 = ((ovb.b) r6).a;
        if (StringsKt.isBlank(r8) == false) goto L22;
        r8 = r4.a.e;
        if (r8 != null) goto L22;
        r8 = "";
    L22:
        MmRecordingSource r9 = r4.d().q(r8);
        if (r9 != null) goto L25;
    L27:
        r7 = false;
    L28:
        if (r7 == false) goto L35;
        if (r9 != MmRecordingSource.DOUBAO_STANDALONE_AI_INTERPRETATION) goto L32;
        int r10 = 2131890207;
    L36:
        return new com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.d(UIHelper.getString(r10), "", MinutesForegroundService.ForegroundServiceType.DATA_SYNC);
    L32:
        r10 = 2131892840;
        goto L36
    L35:
        return new com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.d(UIHelper.getString(2131889394), UIHelper.getString(2131892843), MinutesForegroundService.ForegroundServiceType.DATA_SYNC);
    L25:
        if (r9.isStandaloneAIInterpretationSource() != true) goto L27;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r6);
        MmRecordingSession r11 = r4.a;
        r0.label = 1;
        r6 = r11.r(r0);
        if (r6 != r2) goto L17;
        return r2;
    L7:
        r0 = new MmSoftwareHistoryRecordingStateHandler$buildHistoryForegroundNotificationAction$1(r4, r5);
        goto L8
    }

    @Override // com.ss.android.lark.officesdk.minutes.service.recording.common.core.sessionstatehandler.f
    public final void a(com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c r9, com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c r10) {
        Intrinsics.checkNotNullParameter(r9, "oldState");
        Intrinsics.checkNotNullParameter(r10, "newState");
        lvb.a.e(this.b, "onStateChanged: " + r9 + " -> " + r10);
        if (Intrinsics.areEqual(r10, com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c.C0037c.c) == false) goto L6;
        BuildersKt.launch$default(this.a.u, null, null, new MmSoftwareHistoryRecordingStateHandler$onStateChanged$1(this, null), 3, null);
        return;
    L6:
        if ((r10 instanceof com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c.b) == false) goto L9;
        d().F(r10);
        BuildersKt.launch$default(this.a.u, null, null, new MmSoftwareHistoryRecordingStateHandler$onStateChanged$2(this, null), 3, null);
        return;
    L9:
        if (Intrinsics.areEqual(r10, com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c.i.c) == false) goto L12;
        BuildersKt.launch$default(this.a.u, null, null, new MmSoftwareHistoryRecordingStateHandler$onStateChanged$3(this, null), 3, null);
        return;
    L12:
        if (Intrinsics.areEqual(r10, com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c.n.c) == false) goto L14;
        ((MmRecordingUploadService) this.f.getValue()).k();
        String r11 = this.a.w.a;
        MmRecordingStatesSyncService r12 = d();
        r12.getClass();
        Intrinsics.checkNotNullParameter(r11, "meetingId");
        String r1 = r12.l().t(r11);
        lvb.a.e(r12.c, "[sourceSessionKey] get result, meetingId:" + r11 + ", sessionKey:" + r1);
        lvb.a.e(this.b, "[historyUploadCleanup] uploaded, meetingId=" + r11 + ", sourceSessionKey=" + r1);
        BuildersKt.launch$default(this.a.u, null, null, new MmSoftwareHistoryRecordingStateHandler$onStateChanged$4(this, r11, r1, null), 3, null);
        return;
    L14:
        Unit r13 = Unit.INSTANCE;
    }
}
