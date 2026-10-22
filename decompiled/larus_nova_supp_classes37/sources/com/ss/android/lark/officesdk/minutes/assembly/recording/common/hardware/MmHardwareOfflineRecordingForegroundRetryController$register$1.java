package com.ss.android.lark.officesdk.minutes.assembly.recording.common.hardware;

import android.app.Activity;
import android.os.Bundle;
import com.ss.android.lark.appcontext.applifecycle2.api.AppLifecycle2;
import com.ss.android.lark.picker.base.view.ItemViewType;
import java.util.HashMap;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import yub.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.assembly.recording.common.hardware.MmHardwareOfflineRecordingForegroundRetryController$register$1", f = "MmHardwareOfflineRecordingForegroundRetryController.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class MmHardwareOfflineRecordingForegroundRetryController$register$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $recordingId;
    int label;
    final /* synthetic */ MmHardwareOfflineRecordingForegroundRetryController this$0;

    public static final class a implements yub.a.b {
        public final /* synthetic */ MmHardwareOfflineRecordingForegroundRetryController a;
        public final /* synthetic */ String b;

        @Override // yub.a.b
        public final void onActivityCreated(Activity r2) {
            Intrinsics.checkNotNullParameter(r2, "activity");
        }

        @Override // yub.a.b
        public final void onActivityDestroyed(Activity r2) {
            Intrinsics.checkNotNullParameter(r2, "activity");
        }

        @Override // yub.a.b
        public final void onActivityPaused(Activity r2) {
            Intrinsics.checkNotNullParameter(r2, "activity");
        }

        @Override // yub.a.b
        public final void onActivitySaveInstanceState(Activity r2, Bundle r3) {
            Intrinsics.checkNotNullParameter(r2, "activity");
            Intrinsics.checkNotNullParameter(r3, "outState");
        }

        @Override // yub.a.b
        public final void onActivityStopped(Activity r2) {
            Intrinsics.checkNotNullParameter(r2, "activity");
        }

        @Override // yub.a.b
        public final void onActivityResumed(Activity r3) {
            Intrinsics.checkNotNullParameter(r3, "activity");
            MmHardwareOfflineRecordingForegroundRetryController.a(this.a, this.b, this, "activity_resumed");
        }

        @Override // yub.a.b
        public final void onActivityStarted(Activity r3) {
            Intrinsics.checkNotNullParameter(r3, "activity");
            MmHardwareOfflineRecordingForegroundRetryController.a(this.a, this.b, this, "activity_started");
        }

        public a(MmHardwareOfflineRecordingForegroundRetryController r1, String r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public MmHardwareOfflineRecordingForegroundRetryController$register$1(MmHardwareOfflineRecordingForegroundRetryController r1, String r2, Continuation<? super MmHardwareOfflineRecordingForegroundRetryController$register$1> r3) {
        this.this$0 = r1;
        this.$recordingId = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new MmHardwareOfflineRecordingForegroundRetryController$register$1(this.this$0, this.$recordingId, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L15;
        ResultKt.throwOnFailure(r4);
        yub.a.b r5 = (yub.a.b) ((LinkedHashMap) this.this$0.e).get(this.$recordingId);
        if (r5 == null) goto L8;
        MmHardwareOfflineRecordingForegroundRetryController.a(this.this$0, this.$recordingId, r5, "register_again");
        return Unit.INSTANCE;
    L8:
        MmHardwareOfflineRecordingForegroundRetryController r0 = this.this$0;
        String r1 = this.$recordingId;
        a r6 = new a(r0, r1);
        r0.e.put(r1, r6);
        d r2 = d.a;
        Intrinsics.checkNotNullParameter(r6, "observer");
        HashMap<yub.a.b, com.ss.android.lark.appcontext.applifecycle.a> r3 = d.b;
        if (r3.containsKey(r6) == true) goto L12;
        com.ss.android.lark.appcontext.applifecycle.a r7 = new yub.b(r6);
        r3.put(r6, r7);
        int r8 = com.ss.android.lark.appcontext.applifecycle2.api.a.a;
        Intrinsics.checkNotNullParameter(r7, "activityObserver");
        AppLifecycle2.a().b(r7);
    L12:
        lvb.a.e(this.this$0.d, "[register] wait activity foreground, recordingId=" + this.$recordingId);
        MmHardwareOfflineRecordingForegroundRetryController.a(this.this$0, this.$recordingId, r6, "foreground_after_register");
        return Unit.INSTANCE;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
