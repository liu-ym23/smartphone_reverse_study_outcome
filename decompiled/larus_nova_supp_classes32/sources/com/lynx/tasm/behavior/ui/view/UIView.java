package com.lynx.tasm.behavior.ui.view;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import androidx.core.view.ViewCompat;
import com.lynx.jsbridge.LynxResourceModule;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxProp;
import com.lynx.tasm.behavior.ui.accessibility.CustomAccessibilityDelegateCompat;
import com.lynx.tasm.behavior.ui.utils.g;
import com.lynx.tasm.behavior.ui.utils.i;
import com.lynx.xelement.viewpager.childitem.LynxViewpagerItem;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class UIView extends UISimpleView<com.lynx.tasm.behavior.ui.view.a> {

    public class a implements View.OnAttachStateChangeListener {
        public final /* synthetic */ UIView a;

        public a(UIView r1) {
            this.a = r1;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View r4) {
            if (r4 == this.a.getView()) goto L5;
            return;
        L5:
            if (UIView.access$000(this.a) != null) goto L7;
            return;
        L7:
            if (UIView.access$100(this.a).containsKey(LynxViewpagerItem.BIND_ON_ATTACH) == false) goto L14;
            m7a.b r1 = new m7a.b(this.a.getSign(), LynxViewpagerItem.BIND_ON_ATTACH);
            HashMap<String, Object> r5 = new HashMap();
            r5.put("impression_id", ((com.lynx.tasm.behavior.ui.view.a) this.a.getView()).getImpressionId());
            r1.b = LynxResourceModule.PARAMS_KEY;
            r1.c = r5;
            if (this.a.getLynxContext().getEventEmitter() == null) goto L15;
            this.a.getLynxContext().getEventEmitter().sendCustomEvent(r1);
            return;
        L15:
            return;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View r4) {
            if (r4 == this.a.getView()) goto L5;
            return;
        L5:
            if (UIView.access$200(this.a) != null) goto L7;
            return;
        L7:
            if (UIView.access$300(this.a).containsKey("detach") == false) goto L14;
            m7a.b r1 = new m7a.b(this.a.getSign(), "detach");
            HashMap<String, Object> r5 = new HashMap();
            r5.put("impression_id", ((com.lynx.tasm.behavior.ui.view.a) this.a.getView()).getImpressionId());
            r1.b = LynxResourceModule.PARAMS_KEY;
            r1.c = r5;
            if (this.a.getLynxContext().getEventEmitter() == null) goto L15;
            this.a.getLynxContext().getEventEmitter().sendCustomEvent(r1);
            return;
        L15:
            return;
        }
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI, p7a.a
    public boolean canConsumeGesture(float r1, float r2) {
        return true;
    }

    @LynxProp(name = "copyable")
    public void copyable(boolean r1) {
    }

    @Override // com.lynx.tasm.behavior.ui.UIGroup
    public boolean enableAutoClipRadius() {
        return true;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI, p7a.a
    public int getMemberScrollX() {
        return 0;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI, p7a.a
    public int getMemberScrollY() {
        return 0;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI, p7a.a
    public int getScrollContainerDirection() {
        return 0;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI, p7a.a
    public boolean isAtBorder(boolean r1) {
        return false;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI, p7a.a
    public void onGestureScrollBy(float r1, float r2) {
    }

    private i getMaskDrawable() {
        g r0 = this.mLynxMask;
        if (r0 == null) goto L9;
        T r1 = r0.b;
        if (r1 != 0) goto L8;
        return null;
    L8:
        return (i) r1;
    L9:
        return null;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public int getInitialOverflowType() {
        return !this.mContext.getDefaultOverflowVisible() ? 1 : 0;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public void onPropsUpdated() {
        T r0 = this.mView;
        if (r0 == 0) goto L5;
        ((com.lynx.tasm.behavior.ui.view.a) r0).setNativeInteractionEnabled(this.nativeInteractionEnabled);
        ((com.lynx.tasm.behavior.ui.view.a) this.mView).setConsumeHoverEvent(this.mConsumeHoverEvent);
    L5:
        super.onPropsUpdated();
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI, p7a.a
    public Map<Integer, t7a.a> getGestureHandlers() {
        return super.getGestureHandlers();
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI
    public void initAccessibilityDelegate() {
        super.initAccessibilityDelegate();
        T r0 = this.mView;
        if (r0 == 0) goto L6;
        ViewCompat.setAccessibilityDelegate(r0, new CustomAccessibilityDelegateCompat(this));
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI, p7a.a
    public void onInvalidate() {
        if (isEnableNewGesture() == true) goto L5;
        return;
    L5:
        ViewCompat.postInvalidateOnAnimation(this.mView);
    }

    @Override // com.lynx.tasm.behavior.ui.UIGroup, com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public void destroy() {
        super.destroy();
    }

    public UIView(Context r1) {
        super((LynxContext) r1);
    }

    public static /* synthetic */ Map access$000(UIView r0) {
        return r0.mEvents;
    }

    public static /* synthetic */ Map access$100(UIView r0) {
        return r0.mEvents;
    }

    public static /* synthetic */ Map access$200(UIView r0) {
        return r0.mEvents;
    }

    public static /* synthetic */ Map access$300(UIView r0) {
        return r0.mEvents;
    }

    @Override // com.lynx.tasm.behavior.ui.UIGroup, com.lynx.tasm.behavior.ui.IDrawChildHook
    public void afterDraw(Canvas r5) {
        super.afterDraw(r5);
        if (getMaskDrawable() != null) goto L5;
        return;
    L5:
        if (getWidth() > 0) goto L7;
        return;
    L7:
        if (getHeight() <= 0) goto L12;
        getMaskDrawable().setBounds(0, 0, getWidth(), getHeight());
        getMaskDrawable().draw(r5);
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI
    public com.lynx.tasm.behavior.ui.view.a createView(Context r2) {
        com.lynx.tasm.behavior.ui.view.a r3 = onCreateView(r2);
        r3.addOnAttachStateChangeListener(new a(this));
        return r3;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public void interceptGesture(boolean r2) {
        super.interceptGesture(r2);
        ((com.lynx.tasm.behavior.ui.view.a) this.mView).interceptGesture(r2);
    }

    public com.lynx.tasm.behavior.ui.view.a onCreateView(Context r2) {
        return new com.lynx.tasm.behavior.ui.view.a(r2);
    }

    @LynxProp(defaultBoolean = true, name = "android-enable-auto-blur")
    public void setBlurAutoUpdate(boolean r2) {
        ((com.lynx.tasm.behavior.ui.view.a) this.mView).setBlurAutoUpdate(r2);
    }

    @LynxProp(defaultInt = 0, name = "blur-sampling")
    public void setBlurSampling(int r2) {
        ((com.lynx.tasm.behavior.ui.view.a) this.mView).setBlurSampling(r2);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public void setGestureDetectors(Map<Integer, s7a.a> r2) {
        super.setGestureDetectors(r2);
        if (r2 != null) goto L5;
        return;
    L5:
        if (r2.isEmpty() == true) goto L10;
        ((com.lynx.tasm.behavior.ui.view.a) this.mView).setGestureManager(getGestureArenaManager());
        return;
    }

    @LynxProp(name = "impression_id")
    public void setImpressionId(String r2) {
        ((com.lynx.tasm.behavior.ui.view.a) this.mView).setImpressionId(r2);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI, com.lynx.tasm.behavior.event.EventTarget
    public void setPanInterceptAncestors(boolean r2) {
        ((com.lynx.tasm.behavior.ui.view.a) this.mView).setPanInterceptAncestors(r2);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI, com.lynx.tasm.behavior.event.EventTarget
    public void setPanInterceptDescendants(boolean r2) {
        ((com.lynx.tasm.behavior.ui.view.a) this.mView).setPanInterceptDescendants(r2);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI, com.lynx.tasm.behavior.event.EventTarget
    public void setPanInterceptSelf(boolean r2) {
        ((com.lynx.tasm.behavior.ui.view.a) this.mView).setPanInterceptSelf(r2);
    }

    public UIView(LynxContext r2) {
        this(r2, null);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI
    public /* bridge */ /* synthetic */ View createView(Context r1) {
        return createView(r1);
    }

    public UIView(LynxContext r1, Object r2) {
        super(r1, r2);
        if (r1.getDefaultOverflowVisible() == false) goto L6;
        this.mOverflow = 3;
        return;
    }
}
