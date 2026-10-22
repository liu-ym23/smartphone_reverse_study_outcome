package com.obric.aiagent.messenger.stub.permission;

import androidx.fragment.app.FragmentActivity;
import com.larus.platform.api.g1;
import com.larus.platform.service.i2;
import com.larus.utils.logger.FLogger;
import com.obric.aivoice.core.data.NameKeys;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.aiagent.messenger.stub.permission.NativePermissionRequest$requestPermission$1", f = "NativePermissionRequest.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class NativePermissionRequest$requestPermission$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ FragmentActivity $activity;
    final /* synthetic */ Function1<Boolean, Unit> $isAllGranted;
    final /* synthetic */ Function0<Unit> $needSettingTipsMessage;
    final /* synthetic */ List<String> $permissions;
    int label;

    public static final class a implements g1.c {
        public final /* synthetic */ Function1<Boolean, Unit> a;
        public final /* synthetic */ Function0<Unit> b;
        public final /* synthetic */ List<String> c;

        public final void onGoSettingsDialogShow() {
        }

        public final void onSettingPageReturn() {
            FLogger.a.i("NativePermissionRequest", "requestLocationPermission called, IRequestPermissionCallback callback onSettingPageReturn");
            int r0 = f.a;
            if (f.a(this.c) == false) goto L5;
            this.a.invoke(Boolean.TRUE);
            return;
        L5:
            this.a.invoke(Boolean.FALSE);
            this.b.invoke();
        }

        public final void onGoSettingsDialogDismiss(boolean r4) {
            FLogger.a.i("NativePermissionRequest", "requestLocationPermission called, IRequestPermissionCallback callback onGoSettingsDialogDismiss: isConfirmed = " + r4);
            if (r4 == true) goto L6;
            this.a.invoke(Boolean.FALSE);
            this.b.invoke();
            return;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public a(Function1<? super Boolean, Unit> r1, Function0<Unit> r2, List<String> r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void onResult(boolean r4, List<String> r5, List<String> r6, boolean r7) {
            Intrinsics.checkNotNullParameter(r5, "grantedList");
            Intrinsics.checkNotNullParameter(r6, "deniedList");
            FLogger.a.i("NativePermissionRequest", "requestLocationPermission called, IRequestPermissionCallback callback onResult: allGranted = " + r4 + ", grantedList = " + r5 + ", deniedList = " + r6 + ", isGoSettingsDialogShown = " + r7);
            if (r4 == false) goto L5;
            this.a.invoke(Boolean.TRUE);
            return;
        L5:
            if (r7 == true) goto L9;
            this.a.invoke(Boolean.FALSE);
            this.b.invoke();
            return;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public NativePermissionRequest$requestPermission$1(FragmentActivity r1, List<String> r2, Function1<? super Boolean, Unit> r3, Function0<Unit> r4, Continuation<? super NativePermissionRequest$requestPermission$1> r5) {
        this.$activity = r1;
        this.$permissions = r2;
        this.$isAllGranted = r3;
        this.$needSettingTipsMessage = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new NativePermissionRequest$requestPermission$1(this.$activity, this.$permissions, this.$isAllGranted, this.$needSettingTipsMessage, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r8) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r8);
        Function1<Boolean, Unit> r9 = this.$isAllGranted;
        Function0<Unit> r0 = this.$needSettingTipsMessage;
        List<String> r2 = this.$permissions;
        a r3 = new a(r9, r0, r2);
        i2 r10 = i2.b;
        g1.a.b(this.$activity, r2, r3, null, null, 56);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
