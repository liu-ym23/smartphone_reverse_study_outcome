package com.bytedance.ies.xelement.reveal;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.GestureDetectorCompat;
import androidx.customview.widget.ViewDragHelper;
import com.lynx.jsbridge.LynxResourceModule;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.behavior.c0;
import com.lynx.tasm.behavior.f0;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.LynxUI;
import com.lynx.tasm.behavior.ui.view.UISimpleView;
import com.lynx.tasm.behavior.ui.view.b;
import com.obric.oui.panel.i;
import java.lang.reflect.Field;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import sj.e;
import ue.c;
import ue.d;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0007¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/ies/xelement/reveal/LynxRevealView;", "Lcom/lynx/tasm/behavior/ui/view/UISimpleView;", "Lue/c;", "", "mode", "", "setRevealLayoutMode", "(Ljava/lang/String;)V", "Lcom/lynx/react/bridge/ReadableMap;", LynxResourceModule.PARAMS_KEY, "toggleActive", "(Lcom/lynx/react/bridge/ReadableMap;)V", "x-element-reveal-view_release"}, k = 1, mv = {1, 4, 0})
public class LynxRevealView extends UISimpleView<c> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c f6503a;

    @Override // com.lynx.tasm.behavior.ui.LynxUI
    public final View createView(Context r10) {
        Field r5 = null;
        if (r10 != null) goto L5;
        return null;
    L5:
        c r11 = new c(r10);
        this.f6503a = r11;
        r11.f22331n = 2;
        r11.f22328k = 300;
        r11.f22330m = 1;
        r11.g = (int) ((1 * r11.getContext().getResources().getDisplayMetrics().density) + 0.5f);
        ViewDragHelper r12 = ViewDragHelper.create(r11, 1.0f, r11.f22336t);
        r11.f22335r = r12;
        if (r12 != null) goto L24;
    L12:
        if (r5 == null) goto L14;
        r5.setAccessible(true);     // Catch: IllegalAccessException -> L8 NoSuchFieldException -> L10
    L14:
        if (r5 == null) goto L19;
        r5.set(r11.f22335r, new d(r11.getContext(), new i(3)));     // Catch: IllegalAccessException -> L8 NoSuchFieldException -> L10
    L8:
        e = move-exception;
        e.printStackTrace();
    L10:
        e = move-exception;
        e.printStackTrace();
    L19:
        ViewDragHelper r13 = r11.f22335r;
        if (r13 == null) goto L22;
        r13.setEdgeTrackingEnabled(15);
    L22:
        r11.s = new GestureDetectorCompat(r11.getContext(), r11.f22337u);
        this.f6503a.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.f6503a.setSwipeListener(new e());
        return this.f6503a;
    L24:
        r5 = r12.getClass().getDeclaredField("mScroller");     // Catch: IllegalAccessException -> L8 NoSuchFieldException -> L10
        goto L12
    }

    @Override // com.lynx.tasm.behavior.ui.UIGroup, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r5) {
        return new ViewGroup.LayoutParams(-2, -2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.lynx.tasm.behavior.ui.UIGroup, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void insertChild(LynxBaseUI r5, int r10) {
        if ((r5 instanceof LynxUI) == false) goto L25;
        this.mChildren.add(r10, r5);
        LynxUI r11 = (LynxUI) r5;
        r11.setParent(this);
        if ((r5 instanceof LynxRevealInnerLeft) == false) goto L9;
        this.f6503a.b((b) ((LynxRevealInnerLeft) r5).getView());
        this.f6503a.setDragEdge(1);
        return;
    L9:
        if ((r5 instanceof LynxRevealInnerRight) == false) goto L13;
        this.f6503a.b((b) ((LynxRevealInnerRight) r5).getView());
        this.f6503a.setDragEdge(2);
        return;
    L13:
        if ((r5 instanceof LynxRevealInnerTop) == false) goto L17;
        this.f6503a.b((b) ((LynxRevealInnerTop) r5).getView());
        this.f6503a.setDragEdge(4);
        return;
    L17:
        if ((r5 instanceof LynxRevealInnerBottom) == false) goto L20;
        this.f6503a.b((b) ((LynxRevealInnerBottom) r5).getView());
        this.f6503a.setDragEdge(8);
        return;
    L20:
        c r12 = this.f6503a;
        View r13 = r11.getView();
        if (r12.f22322a == null) goto L23;
        Log.w("RevealLayout", "already added ,replacing the main view");
        r12.removeView(r12.f22322a);
    L23:
        r12.f22322a = r13;
        r12.addView(r13);
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.UIGroup, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final boolean needCustomLayout() {
        return true;
    }

    @Override // com.lynx.tasm.behavior.ui.UIGroup, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void removeChild(LynxBaseUI r5) {
        if ((r5 instanceof LynxUI) == false) goto L6;
        this.mChildren.remove(r5);
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void setEvents(Map r5) {
        super.setEvents(r5);
        Log.d("LynxRevealView", "events: " + r5);
        if (r5 == null) goto L6;
        r5.containsKey("state");
        return;
    }

    @c0(defaultInt = 0, name = "mode")
    public final void setRevealLayoutMode(String r5) {
        String r10 = r5.toLowerCase(Locale.ROOT);
        int r11 = r10.hashCode();
        if (r11 == (-1394648469)) goto L15;
        if (r11 == (-1039745817)) goto L8;
        return;
    L8:
        if (r10.equals("normal") == false) goto L21;
        c r12 = this.f6503a;
        if (r12 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("mRevealLayout");
    L12:
        r12.setMode$x_element_reveal_view_release(0);
        return;
    L21:
        return;
    L15:
        if (r10.equals("same_level") == false) goto L22;
        c r13 = this.f6503a;
        if (r13 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("mRevealLayout");
    L19:
        r13.setMode$x_element_reveal_view_release(1);
        return;
    }

    @f0
    public final void toggleActive(ReadableMap r5) {
        if (r5.hasKey("state") == false) goto L20;
        String r10 = r5.getString("state");
        if (r10 == null) goto L28;
        int r11 = r10.hashCode();
        if (r11 == 3417674) goto L17;
        if (r11 == 94756344) goto L13;
        return;
    L13:
        if (r10.equals("close") == false) goto L26;
        this.f6503a.c(true);
        return;
    L26:
        return;
    L17:
        if (r10.equals("open") == false) goto L27;
        this.f6503a.d(true);
        return;
    L27:
        return;
    L28:
        return;
    L20:
        c r12 = this.f6503a;
        if (r12.f22329l != 2) goto L24;
        r12.c(true);
        return;
    L24:
        r12.d(true);
    }
}
