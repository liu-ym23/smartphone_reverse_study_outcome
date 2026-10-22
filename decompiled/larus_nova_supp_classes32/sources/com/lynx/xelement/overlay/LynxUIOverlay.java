package com.lynx.xelement.overlay;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.View;
import com.lynx.jsbridge.LynxResourceModule;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.b1;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.LynxUI;
import com.lynx.tasm.behavior.ui.UIGroup;
import com.lynx.tasm.behavior.ui.k;
import com.lynx.tasm.behavior.x0;
import com.lynx.tasm.event.EventsListener;
import com.lynx.tasm.utils.DisplayMetricsHolder;
import com.obric.aivoice.core.data.NameKeys;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010!\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u0000 \\2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001]B\u0019\u0012\u0006\u0010\u0005\u001a\u00020W\u0012\b\u0010X\u001a\u0004\u0018\u00010+¢\u0006\u0004\bY\u0010ZB\u0011\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020W¢\u0006\u0004\bY\u0010[J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0014J\u0092\u0001\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u00072\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016J\u0012\u0010\u001e\u001a\u00020\u001a2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0016J\"\u0010!\u001a\u00020 2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\b\u0010\u001f\u001a\u0004\u0018\u00010\u0018H\u0016J\u001a\u0010$\u001a\u00020\u001a2\b\u0010\"\u001a\u0004\u0018\u00010\u001c2\u0006\u0010#\u001a\u00020\u0007H\u0016J\u0016\u0010&\u001a\u00020\u001a2\f\u0010\"\u001a\b\u0012\u0002\b\u0003\u0018\u00010%H\u0016J\u001c\u0010(\u001a\u00020\u001a2\b\u0010'\u001a\u0004\u0018\u00010\u001c2\b\u0010\"\u001a\u0004\u0018\u00010\u001cH\u0016J\u0012\u0010)\u001a\u00020\u001a2\b\u0010\"\u001a\u0004\u0018\u00010\u001cH\u0016J\u0012\u0010*\u001a\u00020\u001a2\b\u0010\"\u001a\u0004\u0018\u00010\u001cH\u0016J\u0012\u0010-\u001a\u00020\u001a2\b\u0010,\u001a\u0004\u0018\u00010+H\u0016J\b\u0010.\u001a\u00020 H\u0016J\u0012\u00101\u001a\u00020\u001a2\b\u00100\u001a\u0004\u0018\u00010/H\u0016J\b\u00102\u001a\u00020\u001aH\u0016J\u001e\u00107\u001a\u00020\u001a2\u0014\u00106\u001a\u0010\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u000205\u0018\u000103H\u0016J\n\u00109\u001a\u0004\u0018\u000108H\u0016J\u0012\u0010<\u001a\u00020\u001a2\b\u0010;\u001a\u0004\u0018\u00010:H\u0016J\u0012\u0010=\u001a\u00020\u001a2\b\u0010;\u001a\u0004\u0018\u00010:H\u0016J\u0010\u0010?\u001a\u00020\u001a2\u0006\u0010>\u001a\u00020\u0007H\u0016J\f\u0010@\u001a\u0006\u0012\u0002\b\u00030%H\u0016J\b\u0010A\u001a\u00020\u001aH\u0016J\b\u0010B\u001a\u00020\u0007H\u0016J\u0010\u0010C\u001a\u00020\u001c2\u0006\u0010#\u001a\u00020\u0007H\u0016J\u000e\u0010E\u001a\b\u0012\u0004\u0012\u00020\u001c0DH\u0016J\u001a\u0010H\u001a\u00020\u001a2\u0006\u0010F\u001a\u00020\u00072\b\u0010G\u001a\u0004\u0018\u000104H\u0016J\b\u0010I\u001a\u00020 H\u0016J\b\u0010J\u001a\u00020 H\u0016R\u0014\u0010L\u001a\u00020K8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bL\u0010MR\"\u0010N\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bN\u0010O\u001a\u0004\bP\u0010Q\"\u0004\bR\u0010SR\"\u0010T\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bT\u0010O\u001a\u0004\bU\u0010Q\"\u0004\bV\u0010S¨\u0006^"}, d2 = {"Lcom/lynx/xelement/overlay/LynxUIOverlay;", "Lcom/lynx/tasm/behavior/ui/UIGroup;", "Lcom/lynx/tasm/behavior/ui/view/a;", "Lcom/lynx/tasm/behavior/ui/d;", "Landroid/content/Context;", "context", "createView", NameKeys.UnloadStrategy_No_Strategy, "left", "top", "width", "height", "paddingLeft", "paddingTop", "paddingRight", "paddingBottom", "marginLeft", "marginTop", "marginRight", "marginBottom", "borderLeftWidth", "borderTopWidth", "borderRightWidth", "borderBottomWidth", "Landroid/graphics/Rect;", "bound", NameKeys.UnloadStrategy_No_Strategy, "updateLayout", "Lcom/lynx/tasm/behavior/ui/LynxBaseUI;", "layout", "updateLayoutInfo", "bounds", NameKeys.UnloadStrategy_No_Strategy, "updateDrawingLayoutInfo", "child", "index", "insertChild", "Lcom/lynx/tasm/behavior/ui/LynxUI;", "insertView", "mark", "insertDrawList", "removeChild", "removeView", NameKeys.UnloadStrategy_No_Strategy, "extraData", "updateExtraData", "isUserInteractionEnabled", "Lcom/lynx/tasm/behavior/ui/k;", "parent", "setParent", "onDetach", NameKeys.UnloadStrategy_No_Strategy, NameKeys.UnloadStrategy_No_Strategy, "Lcom/lynx/tasm/event/EventsListener;", "events", "setEvents", "Lcom/lynx/tasm/behavior/b1;", "getTouchEventDispatcher", "Lcom/lynx/tasm/behavior/x0;", "props", "updatePropertiesInterval", "afterPropsUpdated", "backgroundColor", "setBackgroundColor", "getTransitionUI", "onAnimationUpdated", "getChildCount", "getChildAt", NameKeys.UnloadStrategy_No_Strategy, "getChildren", "sign", "tagName", "setSign", "isViewVisible", "isOverlay", "Lcom/lynx/xelement/overlay/LynxOverlayView;", "mOverlayView", "Lcom/lynx/xelement/overlay/LynxOverlayView;", "screenHeight", "I", "getScreenHeight", "()I", "setScreenHeight", "(I)V", "screenWidth", "getScreenWidth", "setScreenWidth", "Lcom/lynx/tasm/behavior/LynxContext;", LynxResourceModule.PARAMS_KEY, "<init>", "(Lcom/lynx/tasm/behavior/LynxContext;Ljava/lang/Object;)V", "(Lcom/lynx/tasm/behavior/LynxContext;)V", "Companion", "a", "Overlay_release"}, k = 1, mv = {1, 6, 0})
public class LynxUIOverlay extends UIGroup<com.lynx.tasm.behavior.ui.view.a> implements com.lynx.tasm.behavior.ui.d {
    public static final String CUT_OUT_MODE = "cut-out-mode";
    public static final a Companion = null;
    public static final String PROP_ADAPT_EDGE_TO_EDGE = "android-adapt-edge-to-edge";
    public static final String PROP_ALWAYS_SHOW = "always-show";
    public static final String PROP_ANDROID_HIDE_NAVIGATION_BAR = "android-hide-navigation-bar";
    public static final String PROP_ANDROID_LAZY_INIT_CONTEXT = "android-lazy-init-context";
    public static final String PROP_ANDROID_NAVIGATION_BAR_STYLE = "android-navigation-bar-style";
    public static final String PROP_CONTAINER_POPUP_TAG = "android-container-popup-tag";
    public static final String PROP_EVENTS_PASS_THROUGH = "events-pass-through";
    public static final String PROP_FULL_SCREEN = "android-full-screen";
    public static final String PROP_LEVEL = "level";
    public static final String PROP_NEST_SCROLL = "nest-scroll";
    public static final String PROP_STATUS_BAR_TRANSLUCENT = "status-bar-translucent";
    public static final String PROP_STATUS_BAR_TRANSLUCENT_STYLE = "status-bar-translucent-style";
    public static final String PROP_STATUS_BAR_TRANSLUCENT_STYLE_DARK = "dark";
    public static final String PROP_STATUS_BAR_TRANSLUCENT_STYLE_LITE = "lite";
    public static final String PROP_VISIBLE = "visible";
    private final LynxOverlayView mOverlayView;
    private int screenHeight;
    private int screenWidth;

    public static final class a {
        public a() {
        }
    }

    public static final class b extends com.lynx.tasm.behavior.ui.view.a {
        public final /* synthetic */ LynxUIOverlay a;

        @Override // com.lynx.tasm.behavior.ui.view.a, x6a.e
        public /* bridge */ /* synthetic */ int getRendererHostHeight() {
            return x6a.d.e(this);
        }

        @Override // com.lynx.tasm.behavior.ui.view.a, x6a.e
        public /* bridge */ /* synthetic */ int getRendererHostScrollX() {
            return x6a.d.f(this);
        }

        @Override // com.lynx.tasm.behavior.ui.view.a, x6a.e
        public /* bridge */ /* synthetic */ int getRendererHostScrollY() {
            return x6a.d.g(this);
        }

        @Override // com.lynx.tasm.behavior.ui.view.a, x6a.e
        public /* bridge */ /* synthetic */ int getRendererHostWidth() {
            return x6a.d.h(this);
        }

        @Override // com.lynx.tasm.behavior.ui.view.a, android.view.ViewGroup, android.view.View
        public final void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        }

        @Override // com.lynx.tasm.behavior.ui.view.a, x6a.e
        public /* bridge */ /* synthetic */ void setClipChildrenForRenderer(boolean r1) {
            x6a.d.k(this, r1);
        }

        @Override // com.lynx.tasm.behavior.ui.view.a, x6a.e
        public /* bridge */ /* synthetic */ void setWillNotDrawForRenderer(boolean r1) {
            x6a.d.l(this, r1);
        }

        public b(Context r1, LynxUIOverlay r2) {
            this.a = r2;
            new LinkedHashMap();
            super(r1);
        }

        @Override // com.lynx.tasm.behavior.ui.view.a, android.view.View
        public final void onMeasure(int r1, int r2) {
            setMeasuredDimension(0, 0);
        }

        @Override // android.view.View
        public final void onVisibilityChanged(View r2, int r3) {
            Intrinsics.checkNotNullParameter(r2, "changedView");
            if (r3 != 0) goto L5;
            this.a.onAttach();
            return;
        L5:
            if (r3 != 4) goto L7;
        L9:
            this.a.onDetach();
            return;
        L7:
            if (r3 == 8) goto L9;
        }
    }

    static {
        Companion = new a();
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public boolean isOverlay() {
        return true;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI, com.lynx.tasm.behavior.event.EventTarget
    public boolean isUserInteractionEnabled() {
        return false;
    }

    @Override // com.lynx.tasm.behavior.ui.UIGroup
    public int getChildCount() {
        return this.mOverlayView.getChildCount();
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public List<LynxBaseUI> getChildren() {
        return this.mOverlayView.getChildren();
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public b1 getTouchEventDispatcher() {
        return this.mOverlayView.C;
    }

    public boolean isViewVisible() {
        return this.mOverlayView.c;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public void onAnimationUpdated() {
        this.mOverlayView.onAnimationUpdated();
    }

    @Override // com.lynx.tasm.behavior.ui.UIGroup, com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public void onDetach() {
        this.mOverlayView.onDetach();
    }

    public final int getScreenHeight() {
        return this.screenHeight;
    }

    public final int getScreenWidth() {
        return this.screenWidth;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI
    public LynxUI<?> getTransitionUI() {
        return this.mOverlayView;
    }

    public LynxUIOverlay(LynxContext r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public void afterPropsUpdated(x0 r2) {
        this.mOverlayView.afterPropsUpdated(r2);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI
    public com.lynx.tasm.behavior.ui.view.a createView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        return new b(r2, this);
    }

    @Override // com.lynx.tasm.behavior.ui.UIGroup, com.lynx.tasm.behavior.ui.LynxBaseUI
    public LynxBaseUI getChildAt(int r2) {
        return this.mOverlayView.getChildAt(r2);
    }

    @Override // com.lynx.tasm.behavior.ui.UIGroup
    public void insertView(LynxUI<?> r2) {
        this.mOverlayView.insertView(r2);
    }

    @Override // com.lynx.tasm.behavior.ui.UIGroup, com.lynx.tasm.behavior.ui.LynxBaseUI
    public void removeChild(LynxBaseUI r2) {
        this.mOverlayView.removeChild(r2);
    }

    @Override // com.lynx.tasm.behavior.ui.UIGroup
    public void removeView(LynxBaseUI r2) {
        this.mOverlayView.removeView(r2);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public void setBackgroundColor(int r2) {
        this.mOverlayView.setBackgroundColor(r2);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public void setEvents(Map<String, EventsListener> r2) {
        this.mOverlayView.setEvents(r2);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public void setParent(k r2) {
        super.setParent(r2);
        this.mOverlayView.setParent(r2);
    }

    public final void setScreenHeight(int r1) {
        this.screenHeight = r1;
    }

    public final void setScreenWidth(int r1) {
        this.screenWidth = r1;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public void updateExtraData(Object r2) {
        this.mOverlayView.updateExtraData(r2);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public void updateLayoutInfo(LynxBaseUI r2) {
        super.updateLayoutInfo(r2);
        this.mOverlayView.updateLayoutInfo(r2);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public void updatePropertiesInterval(x0 r2) {
        this.mOverlayView.updatePropertiesInterval(r2);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI
    public /* bridge */ /* synthetic */ View createView(Context r1) {
        return createView(r1);
    }

    public LynxUIOverlay(LynxContext r2, Object r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        this.mOverlayView = new LynxOverlayView(r2, this);
        super.insertChild(this.mOverlayView, 0);
        Activity r4 = com.lynx.tasm.utils.a.getActivity(r2);
        if (r4 == null) goto L6;
        DisplayMetrics r5 = DisplayMetricsHolder.getRealScreenDisplayMetrics(r4);
        this.screenHeight = r5.heightPixels;
        this.screenWidth = r5.widthPixels;
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.UIGroup, com.lynx.tasm.behavior.ui.LynxBaseUI
    public void insertChild(LynxBaseUI r2, int r3) {
        this.mOverlayView.insertChild(r2, r3);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI
    public void insertDrawList(LynxBaseUI r2, LynxBaseUI r3) {
        this.mOverlayView.insertDrawList(r2, r3);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public void setSign(int r2, String r3) {
        super.setSign(r2, r3);
        this.mOverlayView.setSign(r2, r3);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public boolean updateDrawingLayoutInfo(int r2, int r3, Rect r4) {
        super.updateDrawingLayoutInfo(r2, r3, r4);
        return this.mOverlayView.updateDrawingLayoutInfo(r2, r3, r4);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public void updateLayout(int r21, int r22, int r23, int r24, int r25, int r26, int r27, int r28, int r29, int r30, int r31, int r32, int r33, int r34, int r35, int r36, Rect r37) {
        super.updateLayout(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null);
        DisplayMetrics r1 = DisplayMetricsHolder.getRealScreenDisplayMetrics(this.mContext);
        this.mOverlayView.updateLayout(0, 0, r1.widthPixels, r1.heightPixels, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null);
    }
}
