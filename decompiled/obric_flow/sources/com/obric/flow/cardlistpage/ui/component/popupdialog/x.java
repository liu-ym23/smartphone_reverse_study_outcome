package com.obric.flow.cardlistpage.ui.component.popupdialog;

import ai.j0;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class x implements com.obric.flow.cardlistpage.mvi.k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MutableState f11747a;

    public x() {
        this.f11747a = SnapshotStateKt.mutableStateOf$default(z.f11751a, null, 2, null);
    }

    @Override // com.obric.flow.cardlistpage.mvi.k
    public final String a() {
        b0 r10 = b();
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (Intrinsics.areEqual(r10, z.f11751a) == false) goto L6;
        String r11 = "Hidden";
    L23:
        return j0.k("PopupDialogState(visibilityState=", r11, ")");
    L6:
        if ((r10 instanceof a0) == false) goto L9;
        r11 = j0.k("Visible(", ug.a.o(((a0) r10).f11717a), ")");
        goto L23
    L9:
        if ((r10 instanceof y) == false) goto L25;
        y r12 = (y) r10;
        e r5 = r12.f11748a;
        String r13 = "null";
        if (r5 == null) goto L14;
        String r14 = ug.a.o(r5);
        if (r14 == null) goto L14;
    L15:
        e r15 = r12.f11749b;
        if (r15 == null) goto L21;
        String r16 = ug.a.o(r15);
        if (r16 == null) goto L21;
        r13 = r16;
    L21:
        r11 = j0.r(androidx.constraintlayout.motion.widget.a.y("Dismissing(current=", r14, ", next=", r13, ", withAnim="), r12.f11750c, ")");
    L14:
        r14 = "null";
        goto L15
    L25:
        throw new NoWhenBranchMatchedException();
    }

    public final b0 b() {
        return (b0) this.f11747a.getValue();
    }
}
