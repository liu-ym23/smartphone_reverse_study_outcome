package com.larus.camera.impl.ui.component.result.general;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.larus.camera.impl.ui.base.BaseCameraViewModel;
import com.larus.camera.impl.ui.viewmodel.CameraResultViewModel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import v19.c7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class f {
    public static final /* synthetic */ int g = 0;
    public final View a;
    public final Context b;
    public final CoroutineScope c;
    public final ResultConfirmControlStyle d;
    public final Function0<CameraResultViewModel> e;
    public final Lazy f;

    public static final class a {
    }

    static {
    }

    public final void a() {
        final CameraResultViewModel r0 = (CameraResultViewModel) this.e.invoke();
        if (r0 != null) goto L5;
        return;
    L5:
        BaseCameraViewModel.tryAdaptBottomLine$default(r0, b(2131367728), 0, null, 6, null);
        int r2 = c7.b(16);
        int r3 = ((Number) this.f.getValue()).intValue();
        FrameLayout r5 = (FrameLayout) b(2131377775);
        com.larus.utils.w0.e(r5, r2);
        r5.setBackgroundColor(r3);
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Unit r4 = Unit.INSTANCE;
        int r6 = c7.b(16);
        int r7 = ((Number) this.f.getValue()).intValue();
        FrameLayout r8 = (FrameLayout) b(2131384589);
        com.larus.utils.w0.e(r8, r6);
        r8.setBackgroundColor(r7);
        Intrinsics.checkNotNullParameter(r8, "<this>");
        int r9 = c7.b(16);
        View r10 = b(2131377773);
        ImageView r11 = (ImageView) r10;
        com.larus.utils.w0.e(r11, r9);
        r11.setBackgroundColor(0);
        ImageView r12 = (ImageView) r10;
        Intrinsics.checkNotNullParameter(r12, "$this$configLeftButton");
        int r13 = com.larus.utils.j0.a;
        r12.setContentDescription(com.larus.utils.j0.d(2131898809));
        r12.setImageResource(2131241091);
        com.larus.utils.e1.d(r12, new e(r0));
        Unit r14 = Unit.INSTANCE;
        int r1 = c7.b(16);
        View r15 = b(2131384584);
        ImageView r16 = (ImageView) r15;
        com.larus.utils.w0.e(r16, r1);
        r16.setBackgroundColor(0);
        final ImageView r17 = (ImageView) r15;
        Intrinsics.checkNotNullParameter(r17, "$this$configRightButton");
        int r18 = com.larus.utils.j0.a;
        r17.setContentDescription(com.larus.utils.j0.d(2131898814));
        r17.setImageResource(2131241092);
        com.larus.utils.e1.d(r17, new c(r0, r17));
        Unit r19 = Unit.INSTANCE;
        ImageView r20 = (ImageView) b(2131379443);
        Intrinsics.checkNotNullParameter(r20, "$this$configMainButtonContainer");
        int r21 = com.larus.utils.j0.a;
        r20.setContentDescription(com.larus.utils.j0.d(2131898783));
        r20.setImageResource(2131241096);
        com.larus.utils.e1.d(r20, new d(r0));
        Unit r22 = Unit.INSTANCE;
        if (this.d != ResultConfirmControlStyle.EDU) goto L9;
        int r23 = com.larus.camera.impl.utils.c0.d;
        float r24 = com.larus.camera.impl.utils.c0.a.a(r0.getParamOrientation(), false);
        FrameLayout r25 = (FrameLayout) b(2131377775);
        Intrinsics.checkNotNullParameter(r25, "$this$configLeftButtonContainer");
        r25.setRotation(r24);
        FrameLayout r26 = (FrameLayout) b(2131384589);
        Intrinsics.checkNotNullParameter(r26, "$this$configRightButtonContainer");
        r26.setRotation(r24);
        ImageView r27 = (ImageView) b(2131379443);
        Intrinsics.checkNotNullParameter(r27, "$this$configMainButtonContainer");
        r27.setRotation(r24);
        BuildersKt.launch$default(this.c, null, null, new ResultConfirmControlBinder$bindEduState$4(r0, this, null), 3, null);
        return;
    }

    public final <T extends View> T b(int r2) {
        return (T) this.a.findViewById(r2);
    }

    public f(View r2, Context r3, CoroutineScope r4, ResultConfirmControlStyle r5, Function0<CameraResultViewModel> r6) {
        Intrinsics.checkNotNullParameter(r2, "rootView");
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "scope");
        Intrinsics.checkNotNullParameter(r5, "style");
        Intrinsics.checkNotNullParameter(r6, "viewModelProvider");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = LazyKt.lazy(new b(this));
    }
}
