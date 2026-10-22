package com.bytedance.android.live.lynx.element.pullrefresh;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.bytedance.android.live.core.log.ALogger;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxUIMethod;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.LynxUI;
import com.lynx.tasm.behavior.ui.UIGroup;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import nl0.b;
import nl0.c;
import nl0.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0017\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0007J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0017¨\u0006\b"}, d2 = {"Lcom/bytedance/android/live/lynx/element/pullrefresh/LynxPullRefreshView;", "Lcom/lynx/tasm/behavior/ui/UIGroup;", "Lcom/scwang/smartrefresh/layout/SmartRefreshLayout;", "Lcom/lynx/react/bridge/ReadableMap;", "params", "", "finishRefresh", "a", "livehybrid-middleware-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class LynxPullRefreshView extends UIGroup<SmartRefreshLayout> {
    public boolean a;
    public boolean b;

    public static final class a {
    }

    static {
    }

    public final boolean needCustomLayout() {
        return true;
    }

    public LynxPullRefreshView(LynxContext r1) {
        super(r1);
        this.a = true;
        this.b = true;
    }

    public final View createView(Context r4) {
        if (r4 != null) goto L4;
        return null;
    L4:
        this.a = true;
        this.b = false;
        SmartRefreshLayout r1 = new SmartRefreshLayout(r4);
        r1.A = this.a;
        r1.g(this.b);
        r1.G(new nl0.a(r4), -2);
        r1.B(60.5f);
        r1.Q = true;
        r1.C(1.25f);
        r1.l = 0.9f;
        r1.W = new b(this);
        r1.i(new c(this));
        r1.p0 = new d(this);
        return r1;
    }

    @LynxUIMethod
    public void finishRefresh(ReadableMap r3) {
        Intrinsics.checkNotNullParameter(r3, "params");
        ALogger.i("LynxPullRefreshView", "finishRefresh -> params = " + r3);
        ((LynxUI) this).mView.h(true);
    }

    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r3) {
        if (r3 == null) goto L6;
        r3.width = -1;
        r3.height = -2;
    L6:
        return new RelativeLayout.LayoutParams(-1, -2);
    }

    public final void removeChild(LynxBaseUI r2) {
        Intrinsics.checkNotNullParameter(r2, "child");
        if ((r2 instanceof LynxUI) == false) goto L6;
        ((LynxBaseUI) this).mChildren.remove(r2);
        return;
    }

    public final void insertChild(LynxBaseUI r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "child");
        ALogger.d("LynxPullRefreshView", "insertChild " + r3 + ' ' + r4);
        onInsertChild(r3, r4);
        if ((r3 instanceof LynxUI) == false) goto L6;
        ((LynxUI) this).mView.E(((LynxUI) r3).getView());
        return;
    }
}
