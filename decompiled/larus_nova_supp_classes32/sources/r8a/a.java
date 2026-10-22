package r8a;

import android.content.Context;
import android.view.View;
import androidx.viewpager.widget.ViewPager;
import com.lynx.tasm.behavior.ui.IDrawChildHook;
import com.lynx.xelement.viewpager.childitem.LynxViewpagerItem;
import com.lynx.xelement.viewpager.viewpager.BaseCustomViewPager;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;
import x6a.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class a extends com.lynx.tasm.behavior.ui.view.a {
    public final LynxViewpagerItem a;

    @Override // com.lynx.tasm.behavior.ui.view.a, x6a.e
    public /* bridge */ /* synthetic */ int getRendererHostHeight() {
        return d.e(this);
    }

    @Override // com.lynx.tasm.behavior.ui.view.a, x6a.e
    public /* bridge */ /* synthetic */ int getRendererHostScrollX() {
        return d.f(this);
    }

    @Override // com.lynx.tasm.behavior.ui.view.a, x6a.e
    public /* bridge */ /* synthetic */ int getRendererHostScrollY() {
        return d.g(this);
    }

    @Override // com.lynx.tasm.behavior.ui.view.a, x6a.e
    public /* bridge */ /* synthetic */ int getRendererHostWidth() {
        return d.h(this);
    }

    @Override // com.lynx.tasm.behavior.ui.view.a, x6a.e
    public /* bridge */ /* synthetic */ void setClipChildrenForRenderer(boolean r1) {
        d.k(this, r1);
    }

    @Override // com.lynx.tasm.behavior.ui.view.a, x6a.e
    public /* bridge */ /* synthetic */ void setWillNotDrawForRenderer(boolean r1) {
        d.l(this, r1);
    }

    public a(Context r2, LynxViewpagerItem r3) {
        Intrinsics.checkNotNullParameter(r3, "viewpagerItem");
        new LinkedHashMap();
        super(r2);
        this.a = r3;
    }

    @Override // com.lynx.tasm.behavior.ui.view.a, android.view.View
    public final void onMeasure(int r2, int r3) {
        super.onMeasure(r2, r3);
        if (getMeasuredWidth() != 0) goto L15;
        ViewPager r4 = getParent();
        if ((r4 instanceof BaseCustomViewPager) == false) goto L7;
        ViewPager r5 = (BaseCustomViewPager) r4;
    L8:
        if (r5 == null) goto L10;
        int r6 = r5.getMeasuredWidth();
    L11:
        setMeasuredDimension(r6, View.MeasureSpec.getSize(r3));
        IDrawChildHook r7 = this.mDrawChildHook;
        if (r7 == null) goto L16;
        r7.performMeasureChildrenUI();
        return;
    L16:
        return;
    L10:
        r6 = this.a.getWidth();
        goto L11
    L7:
        r5 = null;
        goto L8
    }
}
