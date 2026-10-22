package com.bytedance.ies.xelement.viewpager.viewpager;

import android.content.Context;
import android.view.MotionEvent;
import androidx.viewpager.widget.PagerAdapter;
import bf.a;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.a1;
import java.lang.reflect.Field;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import xe.h;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ies/xelement/viewpager/viewpager/CustomViewPager;", "Lcom/bytedance/ies/xelement/viewpager/viewpager/BaseCustomViewPager;", "", "item", "", "setCurrentItem", "(I)V", "x-element-fold-view_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CustomViewPager extends BaseCustomViewPager {
    public CustomViewPager(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        new LinkedHashMap();
        super(r5);
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r10) {
        if (getMAllowHorizontalGesture() == true) goto L29;
        if (r10 == null) goto L6;
        Integer r5 = Integer.valueOf(r10.getActionMasked());
    L7:
        boolean r11 = false;
        if (r5 != null) goto L11;
    L13:
        if (r5 != null) goto L16;
    L30:
        h r12 = getMInterceptTouchEventListener();
        if (r12 == null) goto L41;
        a r13 = (a) r12;
        if (r11 == false) goto L41;
        LynxContext r14 = r13.f908a.getLynxContext();
        if (r14 == null) goto L41;
        a1 r15 = r14.f10140h;
        if (r15 == null) goto L41;
        r15.f10189q = true;
        if (r15.f.isEmpty() == true) goto L41;
        r15.d(8);
    L41:
        return r11;
    L16:
        if (r5.intValue() != 2) goto L30;
        if (getMActivePointerId() == (-1)) goto L30;
        int r16 = r10.findPointerIndex(getMActivePointerId());
        float r17 = r10.getX(r16);
        float r18 = r10.getY(r16);
        if ((Math.abs(r17 - getMLastMotionX()) * 0.5f) <= Math.abs(r18 - getMLastMotionY())) goto L30;
        setMLastMotionX(r17);
        setMLastMotionY(r18);
        Field r19 = getIsUnableToDrag();
        if (r19 == null) goto L25;
        r19.setAccessible(true);
    L25:
        if (r19 == null) goto L30;
        if (r19.getBoolean(this) == false) goto L30;
        r19.set(this, Boolean.FALSE);
        goto L30
    L11:
        if (r5.intValue() != 0) goto L13;
        setMLastMotionX(r10.getX());
        setMLastMotionY(r10.getY());
        setMActivePointerId(r10.getPointerId(0));
        goto L30
    L6:
        r5 = null;
        goto L7
    L29:
        r11 = super.onInterceptTouchEvent(r10);
        goto L30
    }

    @Override // androidx.viewpager.widget.ViewPager
    public void setCurrentItem(int r5) {
        PagerAdapter r10 = super.getAdapter();
        if (r10 != null) goto L5;
    L7:
        super.setCurrentItem(r5);
        return;
    L5:
        if (this.g == false) goto L7;
        r5 = (r10.getCount() - r5) - 1;
        goto L7
    }

    @Override // androidx.viewpager.widget.ViewPager
    public final void setCurrentItem(int r5, boolean r10) {
        PagerAdapter r11 = super.getAdapter();
        if (r11 != null) goto L5;
    L7:
        super.setCurrentItem(r5, r10);
        return;
    L5:
        if (this.g == false) goto L7;
        r5 = (r11.getCount() - r5) - 1;
        goto L7
    }
}
