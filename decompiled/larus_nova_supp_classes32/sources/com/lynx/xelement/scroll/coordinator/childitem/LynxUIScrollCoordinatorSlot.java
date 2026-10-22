package com.lynx.xelement.scroll.coordinator.childitem;

import android.content.Context;
import android.view.View;
import com.lynx.tasm.behavior.LynxBehavior;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxGeneratorName;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.LynxUI;
import com.lynx.tasm.behavior.ui.UIGroup;
import com.lynx.tasm.behavior.ui.view.a;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import q8a.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@LynxBehavior(isCreateAsync = true, tagName = {"scroll-coordinator-slot"})
@LynxGeneratorName(packageName = "com.lynx.xelement.scroll.coordinator.childitem")
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0017\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Lcom/lynx/xelement/scroll/coordinator/childitem/LynxUIScrollCoordinatorSlot;", "Lcom/lynx/tasm/behavior/ui/UIGroup;", "Lcom/lynx/tasm/behavior/ui/view/a;", "ScrollCoordinator_release"}, k = 1, mv = {1, 6, 0})
public class LynxUIScrollCoordinatorSlot extends UIGroup<a> {
    public Object a;
    public LynxUIScrollCoordinatorSlotDrag b;
    public Object c;

    @Override // com.lynx.tasm.behavior.ui.LynxUI
    public final View createView(Context r2) {
        return new a(r2);
    }

    public LynxUIScrollCoordinatorSlot(LynxContext r2, Object r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
    }

    @Override // com.lynx.tasm.behavior.ui.UIGroup, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void insertChild(LynxBaseUI r12, int r13) {
        super.insertChild(r12, r13);
        if ((r12 instanceof LynxUI) == false) goto L78;
        LynxUI r14 = (LynxUI) r12;
        r14.setParent(this);
        if ((r12 instanceof LynxUIScrollCoordinatorSlotDrag) == false) goto L14;
        LynxUIScrollCoordinatorSlotDrag r15 = (LynxUIScrollCoordinatorSlotDrag) r12;
        this.b = r15;
        Object r16 = this.a;
        if (r16 == null) goto L9;
        r15.getClass();
        Intrinsics.checkNotNullParameter(r16, "owner");
        r15.P(r16);
    L9:
        Object r17 = this.c;
        if (r17 == null) goto L79;
        r15.getClass();
        Intrinsics.checkNotNullParameter(r17, "viewPager");
        Intrinsics.checkNotNullParameter(r17, "view");
        r15.b = new WeakReference(r17);
        Object r18 = r15.a;
        if (r18 == null) goto L80;
        f.a(r17, r18);
        return;
    L80:
        return;
    L79:
        return;
    L14:
        int r0 = f.a;
        View r1 = r14.getView();
        if (r1 == null) goto L17;
        Method[] r2 = r1.getClass().getMethods();
    L18:
        boolean r4 = false;
        if (r2 == null) goto L49;
        int r5 = r2.length;
        int r6 = 0;
    L23:
        if (r6 >= r5) goto L33;
        Method r8 = r2[r6];
        if (Intrinsics.areEqual(r8.getName(), "setTabLayout") == true) goto L27;
    L29:
        boolean r9 = false;
    L30:
        if (r9 == true) goto L31;
        r6 = r6 + 1;
        goto L23
    L31:
        boolean r7 = true;
    L34:
        if (r7 == false) goto L49;
        int r10 = r2.length;
        int r11 = 0;
    L36:
        if (r11 >= r10) goto L46;
        Method r19 = r2[r11];
        if (Intrinsics.areEqual(r19.getName(), "setTabBarElementAdded") == true) goto L40;
    L42:
        boolean r20 = false;
    L43:
        if (r20 == true) goto L44;
        r11 = r11 + 1;
        goto L36
    L44:
        boolean r3 = true;
    L47:
        if (r3 == false) goto L49;
        r4 = true;
        goto L49
    L40:
        if (r19.getParameterCount() != 1) goto L42;
        r20 = true;
        goto L43
    L46:
        r3 = false;
        goto L47
    L27:
        if (r8.getParameterCount() != 1) goto L29;
        r9 = true;
        goto L30
    L33:
        r7 = false;
    L49:
        if (r4 == false) goto L66;
        View r110 = r14.getView();
        if (r110 == null) goto L86;
        this.c = r110;
        LynxUIScrollCoordinatorSlotDrag r111 = this.b;
        if (r111 == null) goto L62;
        Intrinsics.checkNotNullParameter(r110, "viewPager");
        Intrinsics.checkNotNullParameter(r110, "view");
        r111.b = new WeakReference(r110);
        Object r21 = r111.a;
        if (r21 == null) goto L58;
        f.a(r110, r21);
    L58:
        Object r112 = r111.a;
        if (r112 != null) goto L61;
        r112 = this.a;
    L61:
        this.a = r112;
    L62:
        Object r113 = this.a;
        if (r113 == null) goto L82;
        f.a(r110, r113);
        return;
    L82:
        return;
    L86:
        return;
    L66:
        if (f.b(r12) == false) goto L84;
        this.a = r12;
        LynxUIScrollCoordinatorSlotDrag r114 = this.b;
        if (r114 == null) goto L70;
        Intrinsics.checkNotNullParameter(r12, "owner");
        r114.P(r12);
    L70:
        Object r115 = this.c;
        if (r115 == null) goto L85;
        f.a(r115, r12);
        return;
    L85:
        return;
    L84:
        return;
    L17:
        r2 = null;
        goto L18
    }
}
