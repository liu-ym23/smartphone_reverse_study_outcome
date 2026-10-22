package com.bytedance.android.anniex.salamander.xelement;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.salamander.anniex.AnnieXBaseViewModel;
import com.bytedance.salamander.anniex.e2;
import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxProp;
import com.lynx.tasm.behavior.LynxUIMethod;
import com.lynx.tasm.behavior.ui.UIGroup;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000eJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0007J\u001c\u0010\u000b\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0007J\u001c\u0010\f\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0007J\u001c\u0010\r\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0007¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/anniex/salamander/xelement/AnnieXEngineElement;", "Lcom/lynx/tasm/behavior/ui/UIGroup;", "Landroid/widget/FrameLayout;", "", "annieXContainerId", "", "setAnnieXContainerId", "Lcom/lynx/react/bridge/ReadableMap;", "params", "Lcom/lynx/react/bridge/Callback;", "callback", "onTouchesDown", "onTouchesMove", "onEnd", "a", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final class AnnieXEngineElement extends UIGroup<FrameLayout> {
    public a a;
    public String b;

    public static final class a extends FrameLayout {
        public a(Context r10) {
            Intrinsics.checkNotNullParameter(r10, "context");
            super(r10);
        }

        @Override // android.view.ViewGroup
        public final boolean onInterceptTouchEvent(MotionEvent r10) {
            HybridLogger r0 = HybridLogger.a;
            StringBuilder r1 = new StringBuilder("event: ");
            if (r10 == null) goto L5;
            Float r11 = Float.valueOf(r10.getY());
        L6:
            r1.append(r11);
            HybridLogger.m("huqijun", r1.toString(), null, null, 12);
            return super.onInterceptTouchEvent(r10);
        L5:
            r11 = null;
            goto L6
        }

        @Override // android.view.View
        public final boolean onTouchEvent(MotionEvent r10) {
            HybridLogger r0 = HybridLogger.a;
            StringBuilder r1 = new StringBuilder("event: ");
            if (r10 == null) goto L5;
            Float r11 = Float.valueOf(r10.getY());
        L6:
            r1.append(r11);
            HybridLogger.m("huqijun", r1.toString(), null, null, 12);
            return super.onTouchEvent(r10);
        L5:
            r11 = null;
            goto L6
        }
    }

    @LynxUIMethod
    public final void onEnd(ReadableMap r1, Callback r10) {
    }

    @LynxUIMethod
    public final void onTouchesDown(ReadableMap r1, Callback r10) {
    }

    @LynxUIMethod
    public final void onTouchesMove(ReadableMap r1, Callback r10) {
    }

    public AnnieXEngineElement(LynxContext r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10);
    }

    @LynxProp(name = "anniexContainerId")
    public final void setAnnieXContainerId(String r10) {
        Intrinsics.checkNotNullParameter(r10, "annieXContainerId");
        if (Intrinsics.areEqual(this.b, r10) == false) goto L5;
        return;
    L5:
        this.b = r10;
        e2 r0 = e2.b;
        AnnieXBaseViewModel r11 = e2.a.a().a(r10);
        if (r11 == null) goto L13;
        View r12 = r11.a().b();
        if (r12 == null) goto L14;
        a r1 = this.a;
        if (r1 == null) goto L15;
        r1.addView(r12, -1, -1);
        return;
    L15:
        return;
    L14:
        return;
    }

    public final View createView(Context r1, Object r10) {
        if (r1 == null) goto L4;
        a r11 = new a(r1);
        this.a = r11;
        r11.requestDisallowInterceptTouchEvent(false);
        return r11;
    L4:
        return null;
    }
}
