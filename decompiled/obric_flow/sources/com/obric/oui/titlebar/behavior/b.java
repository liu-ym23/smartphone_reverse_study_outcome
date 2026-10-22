package com.obric.oui.titlebar.behavior;

import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import com.obric.oui.titlebar.OUnitedTitleBar;

/* JADX INFO: loaded from: classes3.dex */
public final class b implements AccessibilityViewCommand {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CoordinatorLayout f14860a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ OUnitedTitleBar f14861b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ View f14862c;
    public final /* synthetic */ int d;
    public final /* synthetic */ BaseBehavior e;

    public b(BaseBehavior r5, CoordinatorLayout r10, OUnitedTitleBar r11, View r12, int r13) {
        this.e = r5;
        this.f14860a = r10;
        this.f14861b = r11;
        this.f14862c = r12;
        this.d = r13;
    }

    @Override // androidx.core.view.accessibility.AccessibilityViewCommand
    public final boolean perform(View r5, AccessibilityViewCommand.CommandArguments r10) {
        OUnitedTitleBar r11 = this.f14861b;
        int r12 = this.d;
        BaseBehavior r13 = this.e;
        CoordinatorLayout r14 = this.f14860a;
        r13.d(r14, r11, r12, new int[]{0, 0});
        return true;
    }
}
