package com.obric.flow.cardlistpage.ui.component.overlayanimator;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class u implements com.obric.flow.cardlistpage.mvi.k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MutableState f11705a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MutableState f11706b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final MutableState f11707c;
    public final MutableState d;
    public final MutableState e;
    public final MutableState f;
    public final MutableState g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final MutableState f11708h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final MutableState f11709i;

    public u() {
        Boolean r5 = Boolean.FALSE;
        this.f11705a = SnapshotStateKt.mutableStateOf$default(r5, null, 2, null);
        this.f11706b = SnapshotStateKt.mutableStateOf$default(ControllerState.HIDDEN, null, 2, null);
        Float r10 = Float.valueOf(0.0f);
        this.f11707c = SnapshotStateKt.mutableStateOf$default(r10, null, 2, null);
        this.d = SnapshotStateKt.mutableStateOf$default(r10, null, 2, null);
        this.e = SnapshotStateKt.mutableStateOf$default(Float.valueOf(1.0f), null, 2, null);
        this.f = SnapshotStateKt.mutableStateOf$default(r5, null, 2, null);
        this.g = SnapshotStateKt.mutableStateOf$default(OverlayTransitionMode.SNAP, null, 2, null);
        this.f11708h = SnapshotStateKt.mutableStateOf$default(Boolean.TRUE, null, 2, null);
        this.f11709i = SnapshotStateKt.mutableStateOf$default(0, null, 2, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.obric.flow.cardlistpage.mvi.k
    public final String a() {
        boolean r5 = ((Boolean) this.f11705a.getValue()).booleanValue();
        ControllerState r10 = d();
        float r11 = c();
        float r12 = b();
        boolean r13 = ((Boolean) this.f.getValue()).booleanValue();
        OverlayTransitionMode r14 = (OverlayTransitionMode) this.g.getValue();
        boolean r15 = ((Boolean) this.f11708h.getValue()).booleanValue();
        StringBuilder r16 = new StringBuilder("OverlayAnimatorState(committedOpen=");
        r16.append(r5);
        r16.append(", state=");
        r16.append(r10);
        r16.append(", progress=");
        r16.append(r11);
        r16.append(", alpha=");
        r16.append(r12);
        r16.append(", rtl=");
        r16.append(r13);
        r16.append(", transitionMode=");
        r16.append(r14);
        r16.append(", isVisible=");
        return ai.j0.r(r16, r15, ")");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final float b() {
        return ((Number) this.e.getValue()).floatValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final float c() {
        return ((Number) this.f11707c.getValue()).floatValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final ControllerState d() {
        return (ControllerState) this.f11706b.getValue();
    }

    public final void e(ControllerState r5) {
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        this.f11706b.setValue(r5);
    }

    public final void f(OverlayTransitionMode r5) {
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        this.g.setValue(r5);
    }

    public final void g(boolean r5) {
        Boolean r10 = Boolean.valueOf(r5);
        this.f11708h.setValue(r10);
    }
}
