package com.obric.oui.titlebar.behavior;

import android.view.View;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import com.obric.oui.titlebar.OUnitedTitleBar;

/* JADX INFO: loaded from: classes3.dex */
public final class c implements AccessibilityViewCommand {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OUnitedTitleBar f14863a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f14864b;

    public c(OUnitedTitleBar r5, boolean r10) {
        this.f14863a = r5;
        this.f14864b = r10;
    }

    @Override // androidx.core.view.accessibility.AccessibilityViewCommand
    public final boolean perform(View r5, AccessibilityViewCommand.CommandArguments r10) {
        this.f14863a.setExpanded(this.f14864b);
        return true;
    }
}
