package com.larus.dora.impl.device.settings.camera;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.bytedance.dora.device.DoraDevice;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.i1;
import kotlinx.coroutines.flow.j1;
import kotlinx.coroutines.flow.z0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u000b\u001a\u00020\fJ\u0006\u0010\r\u001a\u00020\fJ\u0006\u0010\u000e\u001a\u00020\fJ\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/larus/dora/impl/device/settings/camera/CameraSettingsViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "_cameraSettingsStateFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/larus/dora/impl/device/settings/camera/CameraSettingsState;", "cameraSettingsStateFlow", "Lkotlinx/coroutines/flow/StateFlow;", "getCameraSettingsStateFlow", "()Lkotlinx/coroutines/flow/StateFlow;", "loadCameraSettings", "", "updateBurstTakeImageEnable", "updateLiveAITalkEnable", "formatTime", "", "seconds", "", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CameraSettingsViewModel extends ViewModel {
    public static final a Companion = null;
    private static final String TAG = "CameraSettingsViewModel";
    private final z0<f> _cameraSettingsStateFlow;
    private final i1<f> cameraSettingsStateFlow;

    public static final class a {
        public a() {
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.device.settings.camera.CameraSettingsViewModel$loadCameraSettings$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.device.settings.camera.CameraSettingsViewModel$loadCameraSettings$1", f = "CameraSettingsViewModel.kt", i = {}, l = {26}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ CameraSettingsViewModel this$0;

        public AnonymousClass1(CameraSettingsViewModel r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass1(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r7) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r7);
        L21:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r7);
            DoraDevice r8 = kj4.a.g().c();
            g49.d.d(CameraSettingsViewModel.TAG, "loadCameraSettings: " + r8);
            if (r8 == null) goto L21;
            z0 r9 = CameraSettingsViewModel.access$get_cameraSettingsStateFlow$p(this.this$0);
            boolean r4 = false;
            if (kj4.a.g().d.n() != 1) goto L13;
            boolean r3 = true;
        L15:
            if (kj4.a.g().d.l() != 1) goto L17;
            r4 = true;
        L17:
            f.b r2 = new f.b(r3, r4);
            this.label = 1;
            if (r9.emit(r2, this) != r0) goto L21;
            return r0;
        L13:
            r3 = false;
            goto L15
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.device.settings.camera.CameraSettingsViewModel$updateBurstTakeImageEnable$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.device.settings.camera.CameraSettingsViewModel$updateBurstTakeImageEnable$1", f = "CameraSettingsViewModel.kt", i = {}, l = {40}, m = "invokeSuspend", n = {}, s = {})
    public static final class C02501 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ CameraSettingsViewModel this$0;

        public C02501(CameraSettingsViewModel r1, Continuation<? super C02501> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C02501(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r5) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r5);
        L18:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r5);
            if ((CameraSettingsViewModel.access$get_cameraSettingsStateFlow$p(this.this$0).getValue() instanceof f.b) == false) goto L18;
            z0 r6 = CameraSettingsViewModel.access$get_cameraSettingsStateFlow$p(this.this$0);
            Object r2 = CameraSettingsViewModel.access$get_cameraSettingsStateFlow$p(this.this$0).getValue();
            Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.larus.dora.impl.device.settings.camera.CameraSettingsState.Success");
            f.b r3 = (f.b) r2;
            if (kj4.a.g().d.l() != 1) goto L13;
            boolean r4 = true;
        L14:
            r3.getClass();
            f.b r7 = new f.b(true, r4);
            this.label = 1;
            if (r6.emit(r7, this) != r0) goto L18;
            return r0;
        L13:
            r4 = false;
            goto L14
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.device.settings.camera.CameraSettingsViewModel$updateLiveAITalkEnable$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.device.settings.camera.CameraSettingsViewModel$updateLiveAITalkEnable$1", f = "CameraSettingsViewModel.kt", i = {}, l = {52}, m = "invokeSuspend", n = {}, s = {})
    public static final class C02511 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ CameraSettingsViewModel this$0;

        public C02511(CameraSettingsViewModel r1, Continuation<? super C02511> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C02511(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r5) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r5);
        L14:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r5);
            if ((CameraSettingsViewModel.access$get_cameraSettingsStateFlow$p(this.this$0).getValue() instanceof f.b) == false) goto L14;
            z0 r6 = CameraSettingsViewModel.access$get_cameraSettingsStateFlow$p(this.this$0);
            Object r2 = CameraSettingsViewModel.access$get_cameraSettingsStateFlow$p(this.this$0).getValue();
            Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.larus.dora.impl.device.settings.camera.CameraSettingsState.Success");
            f.b r3 = (f.b) r2;
            boolean r4 = r3.a;
            r3.getClass();
            f.b r7 = new f.b(r4, true);
            this.label = 1;
            if (r6.emit(r7, this) != r0) goto L14;
            return r0;
        }
    }

    static {
        Companion = new a();
    }

    public CameraSettingsViewModel() {
        StateFlowImpl r0 = j1.a(f.a.a);
        this._cameraSettingsStateFlow = r0;
        this.cameraSettingsStateFlow = r0;
    }

    public final void loadCameraSettings() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new AnonymousClass1(this, null), 2, null);
    }

    public final void updateBurstTakeImageEnable() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C02501(this, null), 2, null);
    }

    public final void updateLiveAITalkEnable() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C02511(this, null), 2, null);
    }

    public final i1<f> getCameraSettingsStateFlow() {
        return this.cameraSettingsStateFlow;
    }

    public static final /* synthetic */ z0 access$get_cameraSettingsStateFlow$p(CameraSettingsViewModel r0) {
        return r0._cameraSettingsStateFlow;
    }

    private final String formatTime(int r5) {
        int r0 = r5 / 3600;
        int r6 = r5 % 3600;
        int r1 = r6 / 60;
        int r7 = r6 % 60;
        String r2 = "";
        if (r0 <= 0) goto L5;
        StringBuilder r3 = new StringBuilder();
        r3.append(r0);
        r3.append('h');
        String r4 = r3.toString();
    L6:
        if (r1 <= 0) goto L8;
        String r8 = r1 + "min";
    L9:
        if (r7 <= 0) goto L12;
        StringBuilder r9 = new StringBuilder();
        r9.append(r7);
        r9.append('s');
        r2 = r9.toString();
    L12:
        return r4 + r8 + StringsKt.trim(r2).toString();
    L8:
        r8 = "";
        goto L9
    L5:
        r4 = "";
        goto L6
    }
}
