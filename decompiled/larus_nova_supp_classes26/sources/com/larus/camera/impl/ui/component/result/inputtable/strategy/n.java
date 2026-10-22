package com.larus.camera.impl.ui.component.result.inputtable.strategy;

import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import com.larus.camera.impl.ui.arch.CameraContainer;
import com.larus.camera.impl.ui.component.result.general.e2;
import com.larus.camera.impl.ui.component.result.inputtable.ResultInputControlBinder;
import com.larus.camera.impl.widget.CameraInputContainer;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.MutableSharedFlow;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class n extends d {
    public volatile boolean d;
    public long e;

    public static final class a {
    }

    static {
    }

    @Override // com.larus.camera.impl.ui.component.result.inputtable.strategy.d, vx8.a
    public final void a() {
        this.d = false;
        MutableSharedFlow<com.larus.camera.impl.utils.eventbus.g> r0 = com.larus.camera.impl.utils.eventbus.c.a;
        com.larus.camera.impl.utils.eventbus.c.a(h(), new com.larus.camera.impl.utils.eventbus.f(true));
    }

    @Override // com.larus.camera.impl.ui.component.result.inputtable.strategy.d, vx8.a
    public final void e() {
        this.d = true;
        MutableSharedFlow<com.larus.camera.impl.utils.eventbus.g> r0 = com.larus.camera.impl.utils.eventbus.c.a;
        com.larus.camera.impl.utils.eventbus.c.a(h(), new com.larus.camera.impl.utils.eventbus.f(false));
    }

    @Override // com.larus.camera.impl.ui.component.result.inputtable.strategy.d
    public final void k() {
        final int[] r0 = new int[2];
        ViewGroup r1 = this.c;
        if (r1 == null) goto L6;
        r1.post(new j(this, r0));
        return;
    }

    @Override // com.larus.camera.impl.ui.component.result.inputtable.strategy.d, vx8.a
    public final void onViewCreated() {
        k();
        ViewGroup r0 = this.c;
        if ((r0 instanceof CameraInputContainer) == false) goto L5;
        CameraInputContainer r1 = (CameraInputContainer) r0;
    L6:
        if (r1 == null) goto L9;
        r1.post(new k(this));
        return;
    L9:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public n(ResultInputControlBinder.b r2) {
        Intrinsics.checkNotNullParameter(r2, "inputComponentAbility");
        super(r2);
    }

    @Override // com.larus.camera.impl.ui.component.result.inputtable.strategy.d, vx8.a
    public final void c(View r2) {
        Intrinsics.checkNotNullParameter(r2, "parent");
        e1.d(r2, new i(this));
    }

    @Override // vx8.a
    public final CameraContainer.b d(CameraContainer.b r2) {
        Intrinsics.checkNotNullParameter(r2, "layoutParams");
        ((FrameLayout.LayoutParams) r2).width = -1;
        ((FrameLayout.LayoutParams) r2).height = -2;
        return r2;
    }

    public final void l(int r5) {
        ViewGroup r0 = this.c;
        if ((r0 instanceof CameraInputContainer) == false) goto L5;
        CameraInputContainer r1 = (CameraInputContainer) r0;
    L6:
        if (r1 == null) goto L9;
        int r2 = r1.getMinBottomPadding();
        MutableSharedFlow<com.larus.camera.impl.utils.eventbus.g> r3 = com.larus.camera.impl.utils.eventbus.c.a;
        com.larus.camera.impl.utils.eventbus.c.a(h(), new com.larus.camera.impl.utils.eventbus.d(new e2.b(r5 + r2)));
        return;
    L9:
        return;
    L5:
        r1 = null;
        goto L6
    }

    @Override // com.larus.camera.impl.ui.component.result.inputtable.strategy.d, vx8.a
    public final void b(int r6, long r7) {
        Fragment r0 = this.b;
        if (r0 == null) goto L5;
        View r1 = r0.getView();
    L6:
        if (r1 != null) goto L9;
        return;
    L9:
        if (this.d == true) goto L14;
        if (r6 == 0) goto L15;
        FLogger.a.i("ResultInputtableControlComponent", "[onInputHeightWillChange] deltaPx:" + r6 + " durationMs:" + r7);
        this.e = (SystemClock.uptimeMillis() + r7) + 50;
        l(r1.getHeight() + r6);
        r1.postDelayed(new l(this), r7 + 50);
        return;
    L15:
        return;
    L14:
        return;
    L5:
        r1 = null;
        goto L6
    }

    @Override // vx8.a
    public final View f(LayoutInflater r4, ViewGroup r5) {
        Intrinsics.checkNotNullParameter(r4, "inflater");
        Intrinsics.checkNotNullParameter(r5, "parent");
        FLogger.a.i("ResultInputtableControlComponent", "[inflate] FullStyleControlInputViewStrategy");
        View r6 = r4.inflate(2131562912, r5, false);
        CameraInputContainer r7 = (CameraInputContainer) r6.findViewById(2131375355);
        Intrinsics.checkNotNull(r7);
        g(r7);
        Function0<Unit> r0 = new f(this);
        r7.getClass();
        Intrinsics.checkNotNullParameter(r0, "block");
        r7.e = r0;
        Function0<Unit> r1 = new g(this);
        Intrinsics.checkNotNullParameter(r1, "block");
        r7.f = r1;
        Function0<Unit> r2 = new h(this);
        Intrinsics.checkNotNullParameter(r2, "block");
        r7.g = r2;
        Intrinsics.checkNotNull(r6);
        return r6;
    }
}
