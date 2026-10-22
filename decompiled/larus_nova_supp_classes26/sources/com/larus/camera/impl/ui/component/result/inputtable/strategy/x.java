package com.larus.camera.impl.ui.component.result.inputtable.strategy;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.core.content.ContextCompat;
import com.larus.camera.impl.ui.arch.CameraContainer;
import com.larus.camera.impl.ui.component.result.general.e2;
import com.larus.camera.impl.ui.component.result.inputtable.ResultInputControlBinder;
import com.larus.camera.impl.ui.viewmodel.CameraResultViewModel;
import com.larus.camera.impl.widget.CameraInputContainer;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.larus.utils.w0;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.MutableSharedFlow;
import v19.c7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class x extends d {
    public final w d;

    @Override // com.larus.camera.impl.ui.component.result.inputtable.strategy.d
    public final void k() {
        MutableSharedFlow<com.larus.camera.impl.utils.eventbus.g> r0 = com.larus.camera.impl.utils.eventbus.c.a;
        com.larus.camera.impl.utils.eventbus.c.a(h(), new com.larus.camera.impl.utils.eventbus.d(new e2.a(0)));
    }

    public x(ResultInputControlBinder.b r2) {
        Intrinsics.checkNotNullParameter(r2, "inputComponentAbility");
        super(r2);
        this.d = new w(r2, this);
    }

    @Override // vx8.a
    public final CameraContainer.b d(CameraContainer.b r2) {
        Intrinsics.checkNotNullParameter(r2, "layoutParams");
        ((FrameLayout.LayoutParams) r2).width = -1;
        ((FrameLayout.LayoutParams) r2).height = -1;
        return r2;
    }

    @Override // vx8.a
    public final View f(LayoutInflater r7, ViewGroup r8) {
        Intrinsics.checkNotNullParameter(r7, "inflater");
        Intrinsics.checkNotNullParameter(r8, "parent");
        FLogger.a.i("ResultInputtableControlComponent", "[inflate] IconStyleControlInputViewStrategy");
        View r9 = r7.inflate(2131562913, r8, false);
        ViewGroup r0 = (ViewGroup) r9.findViewById(2131375355);
        Intrinsics.checkNotNull(r0);
        g(r0);
        i();
        Intrinsics.checkNotNull(r9);
        int r1 = ContextCompat.getColor(r9.getContext(), 2131102613);
        int r3 = c7.b(16);
        FrameLayout r4 = (FrameLayout) r9.findViewById(2131377775);
        w0.e(r4, r3);
        r4.setBackgroundColor(r1);
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Unit r5 = Unit.INSTANCE;
        int r6 = c7.b(16);
        FrameLayout r10 = (FrameLayout) r9.findViewById(2131384589);
        w0.e(r10, r6);
        r10.setBackgroundColor(r1);
        Intrinsics.checkNotNullParameter(r10, "<this>");
        final CameraResultViewModel r2 = this.a.a();
        if (r2 == null) goto L6;
        ImageView r11 = (ImageView) r9.findViewById(2131377773);
        w0.e(r11, c7.b(16));
        r11.setBackgroundColor(0);
        r11.setImageResource(2131241091);
        e1.d(r11, new t(r2));
    L6:
        ImageView r12 = (ImageView) r9.findViewById(2131384584);
        w0.e(r12, c7.b(16));
        r12.setBackgroundColor(0);
        r12.setImageResource(2131241093);
        e1.d(r12, new s(this));
        r12.setOnTouchListener(this.d);
        ImageView r13 = (ImageView) r9.findViewById(2131379443);
        r13.setImageResource(2131241096);
        e1.d(r13, new u(this));
        r9.setOnTouchListener(new p(this));
        CameraInputContainer r14 = (CameraInputContainer) r9.findViewById(2131375355);
        Function0<Unit> r15 = new q(this);
        r14.getClass();
        Intrinsics.checkNotNullParameter(r15, "block");
        r14.e = r15;
        Function0<Unit> r16 = new r(this);
        Intrinsics.checkNotNullParameter(r16, "block");
        r14.f = r16;
        return r9;
    }
}
