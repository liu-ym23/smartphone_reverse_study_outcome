package com.lynx.FakeViews;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.View;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.text.FlattenUIText;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class FlattenView extends View implements IBytestLynx {
    private View mParent;
    private LynxBaseUI mRealUi;

    @Override // com.lynx.FakeViews.IBytestLynx
    public Rect getBoundRect() {
        return this.mRealUi.getRectToWindow();
    }

    @Override // android.view.View
    public CharSequence getContentDescription() {
        LynxBaseUI r0 = this.mRealUi;
        if ((r0 instanceof FlattenUIText) == false) goto L7;
        return ((FlattenUIText) r0).getText();
    L7:
        return super.getContentDescription();
    }

    @Override // com.lynx.FakeViews.IBytestLynx
    public String getResName() {
        return this.mRealUi.getName();
    }

    @Override // android.view.View
    public Object getTag() {
        return this.mRealUi.getTestID();
    }

    @Override // android.view.View
    public boolean hasWindowFocus() {
        return this.mParent.hasWindowFocus();
    }

    public int hashCode() {
        return this.mRealUi.hashCode();
    }

    @Override // android.view.View
    public boolean isShown() {
        return this.mRealUi.getVisibility();
    }

    public FlattenView(Context r1) {
        super(r1);
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
        if (this.mParent.getGlobalVisibleRect(r4) == true) goto L9;
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

    public FlattenView(LynxBaseUI r2, View r3, View r4) {
        super(r3.getContext());
        this.mRealUi = r2;
        this.mParent = r3;
        Field r5 = LynxView.sAttachInfoField;     // Catch: Exception -> L5
        r5.set(this, r5.get(r3));     // Catch: Exception -> L5
        LynxView.sViewParentField.set(this, r4);     // Catch: Exception -> L5
        return;
    }
}
