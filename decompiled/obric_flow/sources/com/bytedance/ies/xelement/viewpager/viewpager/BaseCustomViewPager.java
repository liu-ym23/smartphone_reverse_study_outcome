package com.bytedance.ies.xelement.viewpager.viewpager;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.bytedance.ies.xelement.viewpager.ReversingAdapter;
import com.lynx.base.log.LynxLog;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import xe.h;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\t\b\u0016\u0018\u00002\u00020\u0001J\u0011\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0004¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0011\u0010\r\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015R\"\u0010\u001b\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u0015R$\u0010#\u001a\u0004\u0018\u00010\u001c8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\"\u0010+\u001a\u00020$8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\"\u0010/\u001a\u00020$8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b,\u0010&\u001a\u0004\b-\u0010(\"\u0004\b.\u0010*R\"\u00105\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b2\u0010\u0007\"\u0004\b3\u00104R\u001d\u0010;\u001a\b\u0012\u0002\b\u0003\u0018\u0001068\u0006¢\u0006\f\n\u0004\b7\u00108\u001a\u0004\b9\u0010:R\"\u0010=\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b<\u0010\u0017\u001a\u0004\b=\u0010\u0019\"\u0004\b>\u0010\u0015¨\u0006?"}, d2 = {"Lcom/bytedance/ies/xelement/viewpager/viewpager/BaseCustomViewPager;", "Landroidx/viewpager/widget/ViewPager;", "Ljava/lang/reflect/Field;", "getIsUnableToDrag", "()Ljava/lang/reflect/Field;", "", "getCurrentItem", "()I", "Landroidx/viewpager/widget/PagerAdapter;", "adapter", "", "setAdapter", "(Landroidx/viewpager/widget/PagerAdapter;)V", "getAdapter", "()Landroidx/viewpager/widget/PagerAdapter;", "Lcom/bytedance/ies/xelement/viewpager/ReversingAdapter;", "getReversingAdapter", "()Lcom/bytedance/ies/xelement/viewpager/ReversingAdapter;", "", "rtlMode", "setRTL", "(Z)V", "a", "Z", "getMAllowHorizontalGesture", "()Z", "setMAllowHorizontalGesture", "mAllowHorizontalGesture", "Lxe/h;", "b", "Lxe/h;", "getMInterceptTouchEventListener", "()Lxe/h;", "setMInterceptTouchEventListener", "(Lxe/h;)V", "mInterceptTouchEventListener", "", "c", "F", "getMLastMotionX", "()F", "setMLastMotionX", "(F)V", "mLastMotionX", "d", "getMLastMotionY", "setMLastMotionY", "mLastMotionY", "e", "I", "getMActivePointerId", "setMActivePointerId", "(I)V", "mActivePointerId", "Ljava/lang/Class;", "f", "Ljava/lang/Class;", "getSuperclass", "()Ljava/lang/Class;", "superclass", "g", "isRTLMode", "setRTLMode", "x-element-fold-view_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class BaseCustomViewPager extends ViewPager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f6564a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public h f6565b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f6566c;
    public float d;
    public int e;
    public final Class f;
    public boolean g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final HashMap f6567h;

    public BaseCustomViewPager(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        new LinkedHashMap();
        super(r5);
        this.f6564a = true;
        this.e = -1;
        Class<? super Object> r10 = getClass().getSuperclass();
        if (r10 == null) goto L5;
        Class<? super Object> r11 = r10.getSuperclass();
    L6:
        this.f = r11;
        this.f6567h = new HashMap();
        return;
    L5:
        r11 = null;
        goto L6
    }

    @Override // androidx.viewpager.widget.ViewPager
    public final void addOnPageChangeListener(ViewPager.OnPageChangeListener r5) {
        Intrinsics.checkNotNullParameter(r5, "listener");
        ReversingOnPageChangeListener r10 = new ReversingOnPageChangeListener(r5, this, super.getAdapter());
        this.f6567h.put(r5, r10);
        super.addOnPageChangeListener(r10);
    }

    @Override // androidx.viewpager.widget.ViewPager
    public final boolean canScroll(View r5, boolean r10, int r11, int r12, int r13) {
        Intrinsics.checkNotNullParameter(r5, "childView");
        if ((r5 instanceof BaseCustomViewPager) == false) goto L13;
        if (super.canScroll(r5, r10, r11, r12, r13) == true) goto L7;
        return false;
    L7:
        if (((BaseCustomViewPager) r5).f6564a == false) goto L14;
        return true;
    L14:
        return false;
    L13:
        return super.canScroll(r5, r10, r11, r12, r13);
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public boolean canScrollHorizontally(int r5) {
        if (this.f6564a == true) goto L7;
        return false;
    L7:
        return super.canScrollHorizontally(r5);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r5) {
        return super.dispatchTouchEvent(r5);
    L4:
        e = move-exception;
        LynxLog.b(4, "Foldview#BaseViewPagerImpl", e.toString());
        return false;
    }

    @Override // androidx.viewpager.widget.ViewPager
    public PagerAdapter getAdapter() {
        ReversingAdapter r5 = (ReversingAdapter) super.getAdapter();
        if (r5 != null) goto L5;
        return null;
    L5:
        return r5.f6523a;
    }

    @Override // androidx.viewpager.widget.ViewPager
    public int getCurrentItem() {
        int r5 = super.getCurrentItem();
        PagerAdapter r10 = super.getAdapter();
        if (r10 != null) goto L5;
    L8:
        return r5;
    L5:
        if (this.g == false) goto L8;
        return (r10.getCount() - r5) - 1;
    }

    public final Field getIsUnableToDrag() {
        Class r5 = this.f;     // Catch: NoSuchFieldException -> L8
        if (r5 == null) goto L7;
        return r5.getDeclaredField("mIsUnableToDrag");
    L7:
        return null;
    L8:
        LynxLog.b(4, "Foldview#BaseViewPagerImpl", "no such field mIsUnableToDrag");
        return null;
    }

    public final int getMActivePointerId() {
        return this.e;
    }

    public final boolean getMAllowHorizontalGesture() {
        return this.f6564a;
    }

    public final h getMInterceptTouchEventListener() {
        return this.f6565b;
    }

    public final float getMLastMotionX() {
        return this.f6566c;
    }

    public final float getMLastMotionY() {
        return this.d;
    }

    public final ReversingAdapter getReversingAdapter() {
        PagerAdapter r5 = super.getAdapter();
        if ((r5 instanceof ReversingAdapter) == true) goto L5;
        return null;
    L5:
        return (ReversingAdapter) r5;
    }

    public final Class<?> getSuperclass() {
        return this.f;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        Class r5 = this.f;     // Catch: NoSuchMethodException -> L13
        if (r5 == null) goto L6;
        Method r10 = r5.getDeclaredMethod("populate", null);     // Catch: NoSuchMethodException -> L13
    L7:
        if (r10 == null) goto L10;
        r10.setAccessible(true);     // Catch: NoSuchMethodException -> L13
    L10:
        if (r10 == null) goto L17;
        r10.invoke(this, null);     // Catch: NoSuchMethodException -> L13
        return;
    L17:
        return;
    L6:
        r10 = null;
    L13:
        LynxLog.b(4, "Foldview#BaseViewPagerImpl", "populate failed");
    }

    @Override // androidx.viewpager.widget.ViewPager
    public final void removeOnPageChangeListener(ViewPager.OnPageChangeListener r5) {
        Intrinsics.checkNotNullParameter(r5, "listener");
        ReversingOnPageChangeListener r10 = (ReversingOnPageChangeListener) this.f6567h.remove(r5);
        if (r10 == null) goto L6;
        super.removeOnPageChangeListener(r10);
        return;
    }

    @Override // androidx.viewpager.widget.ViewPager
    public void setAdapter(PagerAdapter r5) {
        if (r5 == null) goto L4;
        r5 = new ReversingAdapter(r5);
    L4:
        super.setAdapter(r5);
    }

    public final void setMActivePointerId(int r5) {
        this.e = r5;
    }

    public final void setMAllowHorizontalGesture(boolean r5) {
        this.f6564a = r5;
    }

    public final void setMInterceptTouchEventListener(h r5) {
        this.f6565b = r5;
    }

    public final void setMLastMotionX(float r5) {
        this.f6566c = r5;
    }

    public final void setMLastMotionY(float r5) {
        this.d = r5;
    }

    public final void setRTL(boolean r5) {
        this.g = r5;
    }

    public final void setRTLMode(boolean r5) {
        this.g = r5;
    }
}
