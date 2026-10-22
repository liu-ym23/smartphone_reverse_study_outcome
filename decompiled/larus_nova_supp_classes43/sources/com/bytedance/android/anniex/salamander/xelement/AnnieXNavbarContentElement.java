package com.bytedance.android.anniex.salamander.xelement;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.salamander.anniex.e2;
import com.bytedance.salamander.anniex.r0;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxProp;
import com.lynx.tasm.behavior.ui.UIGroup;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0007J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/anniex/salamander/xelement/AnnieXNavbarContentElement;", "Lcom/lynx/tasm/behavior/ui/UIGroup;", "Landroid/widget/FrameLayout;", "", "annieXContainerId", "", "setAnnieXContainerId", "a", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final class AnnieXNavbarContentElement extends UIGroup<FrameLayout> {
    public String a;
    public FrameLayout b;

    public static final class a {
    }

    static {
    }

    public AnnieXNavbarContentElement(LynxContext r1) {
        super(r1);
    }

    @LynxProp(name = "annieXContainerId")
    public final void setAnnieXContainerId(String r10) {
        Intrinsics.checkNotNullParameter(r10, "annieXContainerId");
        if (Intrinsics.areEqual(this.a, r10) == true) goto L10;
        this.a = r10;
        if (r10 == null) goto L11;
        e2 r0 = e2.b;
        r0 r11 = e2.a.a().a(r10);
        Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type com.bytedance.salamander.anniex.AnnieXPageViewModel");
        r0 r12 = r11;
        if (r12.h() == null) goto L12;
        FrameLayout r1 = this.b;
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type android.view.ViewGroup{ com.bytedance.salamander.anniex.AnnieXPlatformviewKt.AnnieXPlatformRootView }");
        Intrinsics.checkNotNullParameter(r1, "view");
        Intrinsics.checkNotNullParameter(r12, "viewModel");
        return;
    L12:
        return;
    L11:
        return;
    }

    public final View createView(Context r10, Object r11) {
        if (r10 == null) goto L4;
        FrameLayout r12 = new FrameLayout(r10);
        r12.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.b = r12;
        return r12;
    L4:
        return null;
    }
}
