package com.larus.voicecall.impl.component.vlm;

import androidx.fragment.app.Fragment;
import com.larus.utils.logger.FLogger;
import com.obric.aivoice.core.data.NameKeys;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.voicecall.impl.component.vlm.RealtimeVideoComponent$requestCameraPermission$2", f = "RealtimeVideoComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class RealtimeVideoComponent$requestCameraPermission$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $caller;
    final /* synthetic */ Function0<Unit> $onGranted;
    final /* synthetic */ Function0<Unit> $onReject;
    int label;
    final /* synthetic */ RealtimeVideoComponent this$0;

    public static final class a implements com.larus.platform.api.g1.c {
        public final /* synthetic */ String a;
        public final /* synthetic */ Function0<Unit> b;
        public final /* synthetic */ Function0<Unit> c;
        public final /* synthetic */ RealtimeVideoComponent d;

        public final void onGoSettingsDialogDismiss(boolean r1) {
        }

        public final void onGoSettingsDialogShow() {
        }

        public final void onSettingPageReturn() {
        }

        public a(String r1, Function0<Unit> r2, Function0<Unit> r3, RealtimeVideoComponent r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        public final void onResult(boolean r1, List<String> r2, List<String> r3, boolean r4) {
            Intrinsics.checkNotNullParameter(r2, "grantedList");
            Intrinsics.checkNotNullParameter(r3, "deniedList");
            if (r1 == false) goto L5;
            FLogger.a.d("RealtimeVideoComponent", "camera permission granted, caller: " + this.a);
            this.b.invoke();
        L6:
            this.d.b1 = false;
            return;
        L5:
            FLogger.a.d("RealtimeVideoComponent", "camera permission not granted, caller: " + this.a);
            this.c.invoke();
            goto L6
        }
    }

    public RealtimeVideoComponent$requestCameraPermission$2(RealtimeVideoComponent r1, String r2, Function0<Unit> r3, Function0<Unit> r4, Continuation<? super RealtimeVideoComponent$requestCameraPermission$2> r5) {
        this.this$0 = r1;
        this.$caller = r2;
        this.$onGranted = r3;
        this.$onReject = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new RealtimeVideoComponent$requestCameraPermission$2(this.this$0, this.$caller, this.$onGranted, this.$onReject, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r8) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L11;
        ResultKt.throwOnFailure(r8);
        RealtimeVideoComponent r9 = this.this$0;
        if (r9.b1 == false) goto L8;
        FLogger.a.d("RealtimeVideoComponent", "request camera permission, caller: " + this.$caller + ", skip");
        return Unit.INSTANCE;
    L8:
        r9.b1 = true;
        com.larus.platform.service.i2 r0 = com.larus.platform.service.i2.b;
        Intrinsics.checkNotNullParameter(r9, "<this>");
        Fragment r1 = com.larus.ui.arch.component.internal.attach.a.b(r9, r9);
        List r2 = CollectionsKt.listOf("android.permission.CAMERA");
        a r3 = new a(this.$caller, this.$onGranted, this.$onReject, this.this$0);
        JSONObject r5 = new JSONObject();
        r5.put("enter_method", "call");
        Unit r10 = Unit.INSTANCE;
        com.larus.platform.api.g1.a.a(r1, r2, r3, null, r5, 8);
        return Unit.INSTANCE;
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
