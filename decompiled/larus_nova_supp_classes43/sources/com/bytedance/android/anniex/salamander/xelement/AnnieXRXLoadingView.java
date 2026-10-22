package com.bytedance.android.anniex.salamander.xelement;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.salamander.anniex.AnnieXAnnieXServiceCenterKt;
import com.bytedance.salamander.anniex.AnnieXCommonUIViewModel;
import com.bytedance.salamander.anniex.AnnieXContainerUIService;
import com.bytedance.salamander.anniex.AnnieXSalamanderAbility;
import com.bytedance.salamander.anniex.b0;
import com.bytedance.salamander.anniex.e2;
import com.bytedance.salamander.anniex.f;
import com.bytedance.salamander.anniex.k3;
import com.bytedance.salamander.anniex.s1;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxProp;
import com.lynx.tasm.behavior.ui.LynxUI;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\tJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0007J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0003H\u0007¨\u0006\n"}, d2 = {"Lcom/bytedance/android/anniex/salamander/xelement/AnnieXRXLoadingView;", "Lcom/lynx/tasm/behavior/ui/LynxUI;", "Landroid/widget/FrameLayout;", "", "containerId", "", "setContainerId", "text", "setText", "a", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final class AnnieXRXLoadingView extends LynxUI<FrameLayout> {
    public String a;
    public FrameLayout b;

    public static final class a {
    }

    static {
    }

    @LynxProp(name = "text")
    public final void setText(String r10) {
        Intrinsics.checkNotNullParameter(r10, "text");
    }

    public AnnieXRXLoadingView(LynxContext r1) {
        super(r1);
    }

    @LynxProp(name = "containerId")
    public final void setContainerId(String r10) {
        Intrinsics.checkNotNullParameter(r10, "containerId");
        if (Intrinsics.areEqual(this.a, r10) == true) goto L24;
        int r1 = AnnieXSalamanderAbility.a;
        Intrinsics.checkNotNullParameter(r10, "containerId");
        e2 r11 = e2.b;
        AnnieXCommonUIViewModel r12 = e2.a.a().a(r10);
        AnnieXContainerUIService r13 = null;
        if ((r12 instanceof AnnieXCommonUIViewModel) == false) goto L7;
        AnnieXCommonUIViewModel r14 = r12;
    L8:
        if (r14 == null) goto L10;
        b0 r15 = new b0(r14.f().a().getContext());
    L11:
        if (r15 == null) goto L22;
        Intrinsics.checkNotNullParameter(r10, "containerId");
        Intrinsics.checkNotNullParameter(r15, "context");
        AnnieXCommonUIViewModel r0 = e2.a.a().a(r10);
        if ((r0 instanceof AnnieXCommonUIViewModel) == false) goto L15;
        AnnieXCommonUIViewModel r16 = r0;
    L16:
        if (r16 == null) goto L22;
        int r17 = s1.a;
        k3 r18 = AnnieXAnnieXServiceCenterKt.a(((f) r16.f()).a);
        if ((r18 instanceof AnnieXContainerUIService) == false) goto L20;
        r13 = (AnnieXContainerUIService) r18;
    L20:
        if (r13 == null) goto L22;
        Intrinsics.checkNotNullParameter(r15, "props");
        goto L22
    L15:
        r16 = null;
    L22:
        this.a = r10;
        return;
    L10:
        r15 = null;
        goto L11
    L7:
        r14 = null;
        goto L8
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
