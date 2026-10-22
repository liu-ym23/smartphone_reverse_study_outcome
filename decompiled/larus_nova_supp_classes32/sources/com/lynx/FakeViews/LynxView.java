package com.lynx.FakeViews;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.behavior.LynxUIRenderer;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.LynxFlattenUI;
import com.lynx.tasm.behavior.ui.LynxUI;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class LynxView extends ViewGroup implements IBytestLynx {
    private static final String TAG = null;
    protected static final Field sAttachInfoField = null;
    protected static final Field sViewParentField = null;
    private boolean mEnableClay;
    private LynxBaseUI mLynxUiGroup;
    private ViewGroup mNativeView;
    private String mResName;

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
    }

    static {
        TAG = "LynxView";
        Field r0 = null;
        Field r1 = View.class.getDeclaredField("mParent");     // Catch: NoSuchFieldException -> L8
        r0 = View.class.getDeclaredField("mAttachInfo");     // Catch: NoSuchFieldException -> L6
        r1.setAccessible(true);     // Catch: NoSuchFieldException -> L6
        r0.setAccessible(true);     // Catch: NoSuchFieldException -> L6
    L11:
        sViewParentField = r1;
        sAttachInfoField = r0;
        return;
    L6:
        e = e;
        Field r2 = r0;
        r0 = r1;
    L10:
        e.printStackTrace();
        Field r4 = r2;
        r1 = r0;
        r0 = r4;
    L8:
        e = e;
        r2 = null;
        goto L10
    }

    private int getLynxChildCount() {
        LynxBaseUI r0 = this.mLynxUiGroup;
        if (r0 != null) goto L5;
        return 0;
    L5:
        if (r0.getChildren() != null) goto L7;
        return 0;
    L7:
        return this.mLynxUiGroup.getChildren().size();
    }

    @Override // com.lynx.FakeViews.IBytestLynx
    public Rect getBoundRect() {
        if (this.mEnableClay == false) goto L8;
        ViewGroup r0 = this.mNativeView;
        if ((r0 instanceof com.lynx.tasm.LynxView) == false) goto L8;
        int[] r2 = new int[2];
        r0.getLocationInWindow(r2);
        Rect r1 = new Rect(0, 0, this.mNativeView.getWidth(), this.mNativeView.getHeight());
        r1.offset(r2[0], r2[1]);
        return r1;
    L8:
        LynxBaseUI r3 = this.mLynxUiGroup;
        if (r3 == null) goto L13;
        return r3.getRectToWindow();
    L13:
        return new Rect(0, 0, 0, 0);
    }

    @Override // android.view.View
    public CharSequence getContentDescription() {
        return this.mNativeView.getContentDescription();
    }

    @Override // android.view.View
    public Object getTag() {
        LynxBaseUI r0 = this.mLynxUiGroup;
        if (r0 == null) goto L9;
        if ((r0 instanceof LynxFlattenUI) == false) goto L9;
        return r0.getTestID();
    L9:
        return this.mNativeView.getTag();
    }

    @Override // android.view.View
    public boolean hasWindowFocus() {
        return this.mNativeView.hasWindowFocus();
    }

    public int hashCode() {
        LynxBaseUI r0 = this.mLynxUiGroup;
        if (r0 == null) goto L7;
        return r0.hashCode();
    L7:
        return super.hashCode();
    }

    @Override // android.view.View
    public boolean isShown() {
        LynxBaseUI r0 = this.mLynxUiGroup;
        if (r0 != null) goto L5;
        return false;
    L5:
        return r0.getVisibility();
    }

    @Override // android.view.ViewGroup
    public int getChildCount() {
        if (getLynxChildCount() <= 0) goto L7;
        return getLynxChildCount();
    L7:
        return this.mNativeView.getChildCount();
    }

    @Override // com.lynx.FakeViews.IBytestLynx
    public String getResName() {
        return this.mResName;
    }

    public LynxView(com.lynx.tasm.LynxView r3) {
        super(r3.getContext());
        this.mResName = null;
        this.mEnableClay = false;
        this.mNativeView = r3;
        this.mLynxUiGroup = r3.getLynxUIRoot();
        if ((r3.lynxUIRenderer() instanceof LynxUIRenderer) == true) goto L8;
        this.mEnableClay = true;
    L8:
        sViewParentField.set(this, this.mNativeView.getParent());     // Catch: Exception -> L7
        Field r0 = sAttachInfoField;     // Catch: Exception -> L7
        r0.set(this, r0.get(r3));     // Catch: Exception -> L7
        return;
    }

    @Override // android.view.ViewGroup
    public View getChildAt(int r4) {
    L27:
        e = move-exception;
        LLog.e(TAG, "error get lynx child " + e);
        return null;
    L3:
        if (getLynxChildCount() == 0) goto L5;
        LynxBaseUI r5 = this.mLynxUiGroup.getChildAt(r4);     // Catch: Exception -> L27
        if ((r5 instanceof LynxUI) == false) goto L18;
        View r0 = ((LynxUI) r5).getView();     // Catch: Exception -> L27
        if ((r0 instanceof com.lynx.tasm.LynxView) == false) goto L13;
        return new LynxView((com.lynx.tasm.LynxView) r0);
    L13:
        if ((r0 instanceof ViewGroup) == true) goto L15;
        return r0;
    L15:
        return new LynxView((ViewGroup) r0, r5, this);
    L18:
        if ((r5 instanceof LynxFlattenUI) == true) goto L20;
        LLog.w(TAG, "lynx child is none of lynxUI nor LynxFlattenUI");     // Catch: Exception -> L27
        return null;
    L20:
        if (r5.getChildren().size() != 0) goto L24;
        return new FlattenView(r5, this.mNativeView, this);
    L24:
        return new LynxView(this.mNativeView, r5, this);
    L5:
        return this.mNativeView.getChildAt(r4);
    }

    public void setResName(String r1) {
        this.mResName = r1;
    }

    public LynxView(Context r1) {
        super(r1);
        this.mResName = null;
        this.mEnableClay = false;
    }

    @Override // android.view.View
    public boolean getGlobalVisibleRect(Rect r4, Point r5) {
        Rect r6 = getBoundRect();
        if (r6.width() > 0) goto L5;
        return false;
    L5:
        if (r6.height() > 0) goto L7;
        return false;
    L7:
        if (this.mNativeView.getGlobalVisibleRect(r4) == true) goto L9;
        return false;
    L9:
        if (r6.left <= r4.right) goto L11;
        return false;
    L11:
        if (r6.right >= r4.left) goto L13;
        return false;
    L13:
        if (r6.top <= r4.bottom) goto L15;
        return false;
    L15:
        if (r6.bottom < r4.top) goto L24;
        return true;
    L24:
        return false;
    }

    public LynxView(ViewGroup r2, LynxBaseUI r3, View r4) {
        super(r2.getContext());
        this.mResName = null;
        this.mEnableClay = false;
        this.mNativeView = r2;
        this.mLynxUiGroup = r3;
        sViewParentField.set(this, r4);     // Catch: Exception -> L5
        return;
    }
}
