package com.lynx.xelement.scroll.coordinator.childitem;

import android.content.Context;
import android.view.View;
import com.lynx.tasm.behavior.LynxBehavior;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxGeneratorName;
import com.lynx.tasm.behavior.LynxProp;
import com.lynx.tasm.behavior.ui.UIGroup;
import com.lynx.tasm.behavior.ui.k;
import com.lynx.xelement.scroll.coordinator.LynxUIScrollCoordinator;
import com.obric.aivoice.core.data.NameKeys;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import q8a.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@LynxBehavior(isCreateAsync = true, tagName = {"scroll-coordinator-header"})
@LynxGeneratorName(packageName = "com.lynx.xelement.scroll.coordinator.childitem")
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0017\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0007¨\u0006\u0007"}, d2 = {"Lcom/lynx/xelement/scroll/coordinator/childitem/LynxUIScrollCoordinatorHeader;", "Lcom/lynx/tasm/behavior/ui/UIGroup;", "Lq8a/b;", NameKeys.UnloadStrategy_No_Strategy, "value", NameKeys.UnloadStrategy_No_Strategy, "setHandleGesture", "ScrollCoordinator_release"}, k = 1, mv = {1, 6, 0})
public class LynxUIScrollCoordinatorHeader extends UIGroup<b> {
    public boolean a;

    @Override // com.lynx.tasm.behavior.ui.LynxUI
    public final View createView(Context r2) {
        return new b(r2);
    }

    @LynxProp(defaultBoolean = false, name = "android-consume-gesture")
    public final void setHandleGesture(boolean r2) {
        ((b) this.mView).setHandleGesture(r2);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void setOverflow(Integer r3) {
        super.setOverflow(r3);
        if (r3 != null) goto L6;
    L7:
        boolean r4 = true;
    L9:
        this.a = r4;
        boolean r5 = !r4;
        ((b) this.mView).setClipChildren(r5);
        if ((getParent() instanceof LynxUIScrollCoordinator) == false) goto L16;
        k r0 = getParent();
        if (r0 == null) goto L15;
        ((LynxUIScrollCoordinator) r0).N().e.setClipChildren(r5);
        return;
    L15:
        throw new NullPointerException("null cannot be cast to non-null type com.lynx.xelement.scroll.coordinator.LynxUIScrollCoordinator");
    L16:
        return;
    L6:
        if (r3.intValue() != 1) goto L7;
        r4 = false;
        goto L9
    }

    public LynxUIScrollCoordinatorHeader(LynxContext r2, Object r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
    }
}
