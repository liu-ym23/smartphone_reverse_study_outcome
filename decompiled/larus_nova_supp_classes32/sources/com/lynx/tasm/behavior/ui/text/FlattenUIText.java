package com.lynx.tasm.behavior.ui.text;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Layout;
import android.text.Spanned;
import android.text.TextUtils;
import android.view.View;
import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.ReadableArray;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.base.TraceEvent;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.event.EventTarget;
import com.lynx.tasm.behavior.ui.ILynxUIMeaningfulContent$MeaningfulContentStatus;
import com.lynx.tasm.behavior.ui.LynxFlattenUI;
import com.lynx.tasm.behavior.ui.LynxUI;
import com.lynx.tasm.behavior.ui.k;
import com.lynx.tasm.behavior.ui.m;
import com.lynx.tasm.event.EventsListener;
import com.lynx.tasm.service.ILynxTextService;
import com.lynx.tasm.utils.UIThreadUtils;
import java.lang.ref.WeakReference;
import java.util.Map;
import z6a.w;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class FlattenUIText extends LynxFlattenUI {
    private boolean mHasImage;
    private boolean mIsJustify;
    private boolean mNeedDrawStroke;
    private CharSequence mOriginText;
    private w mTextBundle;
    private Layout mTextLayout;
    private PointF mTextTranslateOffset;
    private ILynxTextService.a mTextraPage;

    public static class a implements Drawable.Callback {
        public final WeakReference<FlattenUIText> a;
        public final WeakReference<m> b;

        public a(FlattenUIText r2) {
            this.a = new WeakReference(r2);
            if (r2.getLynxContext().isEnginePoolEnabled() == true) goto L5;
            return;
        L5:
            if ((FlattenUIText.access$000(r2) instanceof LynxUI) == false) goto L9;
            this.b = new WeakReference(((LynxUI) FlattenUIText.access$100(r2)).getViewInfo());
            return;
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public final void invalidateDrawable(Drawable r1) {
            if (UIThreadUtils.isOnUiThread() == true) goto L5;
            return;
        L5:
            WeakReference<m> r2 = this.b;
            if (r2 == null) goto L8;
            m r3 = r2.get();
        L9:
            if (r3 == null) goto L14;
            View r4 = r3.b;
            if (r4 == null) goto L20;
            r4.invalidate();
            return;
        L20:
            return;
        L14:
            FlattenUIText r5 = this.a.get();
            if (r5 == null) goto L19;
            r5.invalidate();
            return;
        L19:
            return;
        L8:
            r3 = null;
            goto L9
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public final void unscheduleDrawable(Drawable r1, Runnable r2) {
            UIThreadUtils.removeCallbacks(r2, r1);
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public final void scheduleDrawable(Drawable r1, Runnable r2, long r3) {
            UIThreadUtils.runOnUiThreadAtTime(r2, r1, r3);
        }
    }

    @Override // com.lynx.tasm.behavior.ui.LynxFlattenUI, x6a.e
    public /* bridge */ /* synthetic */ boolean invokeUIMethod(String r1, ReadableMap r2, Callback r3) {
        return false;
    }

    public void setColor(int r1) {
    }

    public void setColor(f6a.a r1) {
    }

    public void setTextGradient(ReadableArray r1) {
    }

    private void dispatchDetachImageSpan() {
        if (this.mHasImage == true) goto L5;
        return;
    L5:
        if ((getText() instanceof Spanned) == false) goto L16;
        Spanned r0 = (Spanned) getText();
        int r3 = 0;
        com.lynx.tasm.behavior.ui.text.a[] r1 = (com.lynx.tasm.behavior.ui.text.a[]) r0.getSpans(0, r0.length(), com.lynx.tasm.behavior.ui.text.a.class);
        int r2 = r1.length;
    L7:
        if (r3 >= r2) goto L17;
        com.lynx.tasm.behavior.ui.text.a r4 = r1[r3];
        r4.f();
        if (getLynxContext().isEnginePoolEnabled() == true) goto L11;
        r4.j(null);
    L11:
        r3 = r3 + 1;
        goto L7
    L17:
        return;
    }

    private void release() {
        if (this.mHasImage == true) goto L5;
        return;
    L5:
        if ((getText() instanceof Spanned) == false) goto L9;
        com.lynx.tasm.behavior.ui.text.a.i((Spanned) getText(), null);
        return;
    }

    public int getDrawOffsetLeft() {
        int r0 = this.mPaddingLeft + this.mBorderLeftWidth;
        PointF r1 = this.mTextTranslateOffset;
        if (r1 == null) goto L5;
        int r2 = (int) r1.x;
    L7:
        return r0 + r2;
    L5:
        r2 = 0;
        goto L7
    }

    public int getDrawOffsetTop() {
        int r0 = this.mPaddingTop + this.mBorderTopWidth;
        PointF r1 = this.mTextTranslateOffset;
        if (r1 == null) goto L5;
        int r2 = (int) r1.y;
    L7:
        return r0 + r2;
    L5:
        r2 = 0;
        goto L7
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public ILynxUIMeaningfulContent$MeaningfulContentStatus getMeaningfulContentStatus() {
        if (this.mTextLayout != null) goto L10;
        if (this.mTextraPage != null) goto L10;
        return ILynxUIMeaningfulContent$MeaningfulContentStatus.PENDING;
    L10:
        return ILynxUIMeaningfulContent$MeaningfulContentStatus.PRESENTED;
    }

    public CharSequence getText() {
        Layout r0 = this.mTextLayout;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getText();
    }

    private void dispatchLayoutEventIfNeeded() {
        if (getLynxContext().isLayoutInElementModeOn() == true) goto L5;
        return;
    L5:
        if (this.mTextBundle == null) goto L16;
        Map<String, EventsListener> r0 = this.mEvents;
        if (r0 != null) goto L10;
        return;
    L10:
        if (r0.containsKey("layout") == false) goto L17;
        com.lynx.tasm.behavior.shadow.text.b.c(getLynxContext(), getSign(), this.mTextBundle);
        return;
    L17:
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public void destroy() {
        super.destroy();
        release();
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public CharSequence getAccessibilityLabel() {
        CharSequence r0 = super.getAccessibilityLabel();
        if (TextUtils.isEmpty(r0) == true) goto L6;
        return r0;
    L6:
        return getText();
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public void onLayoutUpdated() {
        super.onLayoutUpdated();
        invalidate();
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public void onNodeReady() {
        super.onNodeReady();
        if (this.mContext.isLayoutInElementModeOn() == false) goto L5;
        updateExtraData(this.mContext.getLynxUIOwner().takeTextLayout(getSign()));
    L5:
        w r0 = this.mTextBundle;
        if (r0 == null) goto L9;
        b.a(r0, this);
        return;
    }

    public CharSequence getOriginText() {
        return this.mOriginText;
    }

    public w getTextBundle() {
        return this.mTextBundle;
    }

    public Layout getTextLayout() {
        return this.mTextLayout;
    }

    public FlattenUIText(Context r1) {
        this((LynxContext) r1);
    }

    public static /* synthetic */ k access$000(FlattenUIText r0) {
        return r0.mDrawParent;
    }

    public static /* synthetic */ k access$100(FlattenUIText r0) {
        return r0.mDrawParent;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxFlattenUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public void detachWithViewInfo(m r2) {
        super.detachWithViewInfo(r2);
        if (this.mHasImage == true) goto L5;
        return;
    L5:
        if ((getText() instanceof Spanned) == false) goto L9;
        com.lynx.tasm.behavior.ui.text.a.i((Spanned) getText(), new a(this));
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxFlattenUI
    public void onDraw(Canvas r8) {
        TraceEvent.beginSection("text.FlattenUIText.onDraw");
        if (getVisibility() == true) goto L6;
        TraceEvent.endSection("text.FlattenUIText.onDraw");
        return;
    L6:
        super.onDraw(r8);
        if (isDetachedWithView() == false) goto L11;
        TraceEvent.endSection("text.FlattenUIText.onDraw");
        return;
    L11:
        if (this.mTextraPage == null) goto L23;
        int r1 = this.mPaddingLeft + this.mBorderLeftWidth;
        int r2 = this.mPaddingRight + this.mBorderRightWidth;
        int r3 = this.mPaddingTop + this.mBorderTopWidth;
        int r4 = this.mPaddingBottom + this.mBorderBottomWidth;
        r8.save();
        if (getOverflow() == 0) goto L18;
        Rect r5 = getBoundRectForOverflow();
        if (r5 == null) goto L20;
        r8.clipRect(r5);
    L20:
        r8.translate(r1, r3);
        this.mTextraPage.d(r8, new a(this));
        r8.restore();
        TraceEvent.endSection("text.FlattenUIText.onDraw");
        return;
    L18:
        if (this.mContext.isTextOverflowEnabled() == true) goto L20;
        r8.clipRect(r1, r3, getWidth() - r2, getHeight() - r4);
        goto L20
    L23:
        if (this.mTextLayout != null) goto L26;
        TraceEvent.endSection("text.FlattenUIText.onDraw");
        return;
    L26:
        int r6 = this.mPaddingLeft + this.mBorderLeftWidth;
        int r7 = this.mPaddingRight + this.mBorderRightWidth;
        int r9 = this.mPaddingTop + this.mBorderTopWidth;
        int r10 = this.mPaddingBottom + this.mBorderBottomWidth;
        r8.save();
        if (getOverflow() == 0) goto L32;
        Rect r11 = getBoundRectForOverflow();
        if (r11 == null) goto L34;
        r8.clipRect(r11);
    L34:
        PointF r12 = this.mTextTranslateOffset;
        r8.translate(r6 + r12.x, r9 + r12.y);
        Layout r13 = this.mTextLayout;
        if (r13 == null) goto L37;
        Spanned r14 = (Spanned) r13.getText();
    L38:
        int r15 = com.lynx.tasm.behavior.ui.text.a.p;
        if (r14 == null) goto L45;
        int r16 = 0;
        com.lynx.tasm.behavior.ui.text.a[] r17 = (com.lynx.tasm.behavior.ui.text.a[]) r14.getSpans(0, r14.length(), com.lynx.tasm.behavior.ui.text.a.class);
        int r18 = r17.length;
    L42:
        if (r16 >= r18) goto L45;
        r17[r16].d();
        r16 = r16 + 1;
    L45:
        if (this.mIsJustify == true) goto L47;
    L49:
        this.mTextLayout.draw(r8);
    L51:
        if (this.mNeedDrawStroke == false) goto L53;
        com.lynx.tasm.behavior.shadow.text.b.g(this.mTextLayout, r8);
    L53:
        com.lynx.tasm.behavior.shadow.text.b.e(r8, this.mTextLayout);
        r8.restore();
        TraceEvent.endSection("text.FlattenUIText.onDraw");
        return;
    L47:
        if (Build.VERSION.SDK_INT >= 26) goto L49;
        com.lynx.tasm.behavior.shadow.text.b.f(r8, this.mTextLayout, (getWidth() - r6) - r7);
        goto L51
    L37:
        r14 = null;
        goto L38
    L32:
        if (this.mContext.isTextOverflowEnabled() == true) goto L34;
        r8.clipRect(r6, r9, getWidth() - r7, getHeight() - r10);
        goto L34
    }

    public void setTextBundle(w r3) {
        this.mTextBundle = r3;
        this.mTextraPage = null;
        dispatchDetachImageSpan();
        this.mTextLayout = r3.c;
        this.mTextTranslateOffset = r3.e;
        boolean r0 = r3.a;
        this.mHasImage = r0;
        this.mNeedDrawStroke = r3.f;
        this.mIsJustify = r3.b;
        this.mOriginText = r3.g;
        if (r0 == true) goto L5;
    L7:
        invalidate();
        return;
    L5:
        if ((getText() instanceof Spanned) == false) goto L7;
        com.lynx.tasm.behavior.ui.text.a.i((Spanned) getText(), new a(this));
        goto L7
    }

    public void setTextGradient(String r2) {
        LLog.e("FlattenUIText", "setTextGradient(String) is deprecated");
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public void updateExtraData(Object r2) {
        if ((r2 instanceof w) == false) goto L6;
        setTextBundle((w) r2);
        dispatchLayoutEventIfNeeded();
        return;
    L6:
        if ((r2 instanceof ILynxTextService.a) == false) goto L10;
        setTextBundle((ILynxTextService.a) r2);
        return;
    }

    public FlattenUIText(LynxContext r2) {
        this(r2, null);
    }

    public void setTextBundle(ILynxTextService.a r2) {
        this.mTextraPage = r2;
        this.mTextBundle = null;
        dispatchDetachImageSpan();
        this.mTextLayout = null;
        this.mTextTranslateOffset = new PointF();
        this.mHasImage = false;
        this.mNeedDrawStroke = false;
        this.mIsJustify = false;
        this.mOriginText = null;
        invalidate();
    }

    public FlattenUIText(LynxContext r1, Object r2) {
        super(r1, r2);
        this.mAccessibilityElementStatus = 1;
        if (this.mContext.isTextOverflowEnabled() == true) goto L5;
        return;
    L5:
        if (this.mContext.isLayoutInElementModeOn() == true) goto L9;
        this.mOverflow = 3;
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI, com.lynx.tasm.behavior.event.EventTarget
    public EventTarget hitTest(float r2, float r3) {
        return hitTest(r2, r3, false);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI, com.lynx.tasm.behavior.event.EventTarget
    public EventTarget hitTest(float r11, float r12, boolean r13) {
        float r2 = r11 - (this.mPaddingLeft + this.mBorderLeftWidth);
        float r3 = r12 - (this.mPaddingTop + this.mBorderTopWidth);
        Layout r5 = this.mTextLayout;
        Spanned r14 = null;
        if (r5 != null) goto L6;
    L9:
        return b.c(this, r2, r3, this, r5, r14, this.mTextTranslateOffset, this.mTextraPage, r13);
    L6:
        if ((r5.getText() instanceof Spanned) == false) goto L9;
        r14 = (Spanned) r5.getText();
        goto L9
    }
}
