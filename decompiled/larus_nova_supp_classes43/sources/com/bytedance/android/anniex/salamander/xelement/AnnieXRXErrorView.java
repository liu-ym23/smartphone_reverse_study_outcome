package com.bytedance.android.anniex.salamander.xelement;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.salamander.anniex.AnnieXAnnieXServiceCenterKt;
import com.bytedance.salamander.anniex.AnnieXCommonUIViewModel;
import com.bytedance.salamander.anniex.AnnieXContainerUIService;
import com.bytedance.salamander.anniex.AnnieXSalamanderAbility;
import com.bytedance.salamander.anniex.e2;
import com.bytedance.salamander.anniex.f;
import com.bytedance.salamander.anniex.k3;
import com.bytedance.salamander.anniex.s;
import com.bytedance.salamander.anniex.s1;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxProp;
import com.lynx.tasm.behavior.ui.LynxUI;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0007J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/anniex/salamander/xelement/AnnieXRXErrorView;", "Lcom/lynx/tasm/behavior/ui/LynxUI;", "Landroid/widget/FrameLayout;", "", "containerId", "", "setContainerId", "a", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final class AnnieXRXErrorView extends LynxUI<FrameLayout> {
    public String a;
    public FrameLayout b;

    public static final class a {
    }

    static {
    }

    public AnnieXRXErrorView(LynxContext r1) {
        super(r1);
    }

    @LynxProp(name = "containerId")
    public final void setContainerId(String r10) {
        Intrinsics.checkNotNullParameter(r10, "containerId");
        if (Intrinsics.areEqual(this.a, r10) == true) goto L18;
        s r1 = AnnieXSalamanderAbility.a(r10);
        if (r1 == null) goto L16;
        Intrinsics.checkNotNullParameter(r10, "containerId");
        Intrinsics.checkNotNullParameter(r1, "context");
        e2 r0 = e2.b;
        AnnieXCommonUIViewModel r11 = e2.a.a().a(r10);
        AnnieXContainerUIService r12 = null;
        if ((r11 instanceof AnnieXCommonUIViewModel) == false) goto L9;
        AnnieXCommonUIViewModel r13 = r11;
    L10:
        if (r13 == null) goto L16;
        int r14 = s1.a;
        k3 r15 = AnnieXAnnieXServiceCenterKt.a(((f) r13.f()).a);
        if ((r15 instanceof AnnieXContainerUIService) == false) goto L14;
        r12 = (AnnieXContainerUIService) r15;
    L14:
        if (r12 == null) goto L16;
        Intrinsics.checkNotNullParameter(r1, "props");
        goto L16
    L9:
        r13 = null;
    L16:
        this.a = r10;
        return;
    }

    public final View createView(Context r1, Object r10) {
        if (r1 == null) goto L4;
        FrameLayout r11 = new FrameLayout(r1);
        this.b = r11;
        return r11;
    L4:
        return null;
    }
}
