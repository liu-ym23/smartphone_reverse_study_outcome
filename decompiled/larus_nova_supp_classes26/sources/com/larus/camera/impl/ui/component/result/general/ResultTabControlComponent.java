package com.larus.camera.impl.ui.component.result.general;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.larus.camera.impl.ui.arch.CameraContainer;
import com.larus.camera.impl.ui.component.result.inputtable.ResultInputControlBinder;
import com.larus.camera.impl.ui.viewmodel.CameraResultViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt__TransformKt$filterNotNull$;
import kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$;
import kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class ResultTabControlComponent extends com.larus.camera.impl.ui.arch.b {
    public final ResultConfirmControlStyle m;
    public View n;
    public ResultInputControlBinder o;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/camera/impl/ui/component/result/general/ResultTabControlComponent$DisplayState;", "", "<init>", "(Ljava/lang/String;I)V", "CONFIRM", "INPUT", "HIDDEN", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum DisplayState extends Enum<DisplayState> {
        public static final DisplayState CONFIRM = null;
        public static final DisplayState HIDDEN = null;
        public static final DisplayState INPUT = null;
        public static final /* synthetic */ DisplayState[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<DisplayState> getEntries() {
            return b;
        }

        static {
            DisplayState r0 = new DisplayState("CONFIRM", 0);
            CONFIRM = r0;
            DisplayState r1 = new DisplayState("INPUT", 1);
            INPUT = r1;
            DisplayState r3 = new DisplayState("HIDDEN", 2);
            HIDDEN = r3;
            DisplayState[] r5 = {r0, r1, r3};
            a = r5;
            b = EnumEntriesKt.enumEntries(r5);
        }

        public static DisplayState[] values() {
            return (DisplayState[]) a.clone();
        }

        public static DisplayState valueOf(String r1) {
            return (DisplayState) r27.a.a(DisplayState.class, r1);
        }

        public DisplayState(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a {
    }

    static {
    }

    @Override // com.larus.camera.impl.ui.arch.b
    public final void m() {
        CameraResultViewModel r0 = (CameraResultViewModel) ((com.larus.camera.impl.ui.arch.b.a) this.e.getValue()).a();
        if (r0 != null) goto L5;
        return;
    L5:
        View r1 = this.n;
        if (r1 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("confirmView");
        View r2 = null;
    L9:
        new f(r2, getContext(), k(), this.m, new d0(this)).a();
        kotlinx.coroutines.flow.i1<px8.e> r3 = r0.getResultBottomState();
        kotlinx.coroutines.flow.i1<Boolean> r4 = r0.isInCropMode();
        String r5 = r0.getCameraData().getCaptureMode();
        if (fx8.a.e.contains(r5) == false) goto L16;
        final ChannelFlowTransformLatest r6 = kotlinx.coroutines.flow.e.G(new FlowKt__TransformKt$filterNotNull$.inlined.unsafeTransform.1(r0.getEduImageAbility()), new ResultTabControlComponent$bottomReadyFlow$$inlined$flatMapLatest$1(null));
        kotlinx.coroutines.flow.v0 r7 = new ResultTabControlComponent$bottomReadyFlow$$inlined$map$1(r6);
        if (Intrinsics.areEqual(r5, "CAPTURE_MODE_EDU_GENERAL_PHOTO") == false) goto L14;
    L15:
        kotlinx.coroutines.flow.v0 r8 = new kotlinx.coroutines.flow.v0(r7, r0.getEduResultTabState(), new ResultTabControlComponent$bottomReadyFlow$1(null));
    L17:
        r7 = r8;
    L18:
        final Flow r9 = kotlinx.coroutines.flow.e.n(kotlinx.coroutines.flow.e.j(r3, r4, r7, new ResultTabControlComponent$onViewCreated$displayStateFlow$1(null)));
        ResultInputControlBinder r10 = this.o;
        if (r10 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("inputBinder");
        r10 = null;
    L21:
        r10.b(new ResultTabControlComponent$onViewCreated$$inlined$map$1(r9));
        kotlinx.coroutines.flow.e.x(new FlowKt__TransformKt$onEach$.inlined.unsafeTransform.1(r0.getResultDetectionStatus(), new ResultTabControlComponent$onViewCreated$3(this, null)), k());
        final kotlinx.coroutines.flow.i1<px8.b> r11 = r0.getEduResultTabState();
        kotlinx.coroutines.flow.e.x(new FlowKt__TransformKt$onEach$.inlined.unsafeTransform.1(kotlinx.coroutines.flow.e.n(new ResultTabControlComponent$onViewCreated$$inlined$map$2(r11)), new ResultTabControlComponent$onViewCreated$5(this, null)), k());
        kotlinx.coroutines.flow.e.x(new FlowKt__TransformKt$onEach$.inlined.unsafeTransform.1(r9, new ResultTabControlComponent$onViewCreated$6(this, null)), k());
        return;
    L14:
        if (Intrinsics.areEqual(r5, "CAPTURE_MODE_EDU_HOMEWORK_PHOTO") == false) goto L18;
    L16:
        r8 = new kotlinx.coroutines.flow.v0(r0.getResultDetectionStatus(), r0.getEduResultTabState(), new ResultTabControlComponent$bottomReadyFlow$2(r0, null));
        goto L17
    L8:
        r2 = r1;
        goto L9
    }

    @Override // com.larus.camera.impl.ui.arch.b
    public final void n() {
        ResultInputControlBinder r0 = this.o;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("inputBinder");
        r0 = null;
    L5:
        CameraResultViewModel r1 = (CameraResultViewModel) r0.c.invoke();
        if (r1 == null) goto L9;
        r1.enableFreeInputMode(false);
        return;
    }

    public ResultTabControlComponent(ResultConfirmControlStyle r3) {
        Intrinsics.checkNotNullParameter(r3, "confirmControlStyle");
        com.larus.camera.impl.ui.arch.c r0 = com.larus.camera.impl.ui.arch.c.a;
        super(80, com.larus.camera.impl.ui.arch.c.c);
        this.m = r3;
    }

    @Override // com.larus.camera.impl.ui.arch.b
    public final CameraContainer.b f(int r3) {
        CameraContainer.b r0 = new CameraContainer.b(-1, -1);
        ((FrameLayout.LayoutParams) r0).gravity = r3;
        return r0;
    }

    @Override // com.larus.camera.impl.ui.arch.b
    public final View g(LayoutInflater r6, ViewGroup r7) {
        Intrinsics.checkNotNullParameter(r6, "inflater");
        Intrinsics.checkNotNullParameter(r7, "parent");
        FrameLayout r0 = new FrameLayout(r7.getContext());
        View r1 = r6.inflate(2131562908, r0, false);
        Intrinsics.checkNotNull(r1);
        com.larus.utils.e1.o(r1);
        this.n = r1;
        r0.addView(r1, new FrameLayout.LayoutParams(-1, -1));
        ResultInputControlBinder r2 = new ResultInputControlBinder(r7.getContext(), k(), new e0(this));
        this.o = r2;
        View r8 = r2.c(r6, r0, r7);
        com.larus.utils.e1.o(r8);
        ResultInputControlBinder r9 = this.o;
        if (r9 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("inputBinder");
        r9 = null;
    L5:
        CameraContainer.b r3 = new CameraContainer.b(-2, -2);
        ((FrameLayout.LayoutParams) r3).gravity = 80;
        Unit r4 = Unit.INSTANCE;
        r9.getClass();
        Intrinsics.checkNotNullParameter(r3, "layoutParams");
        r0.addView(r8, r9.d().d(r3));
        return r0;
    }
}
