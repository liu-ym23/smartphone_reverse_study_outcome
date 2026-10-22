package com.lynx.xelement.viewpager.viewpager;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.lynx.tasm.base.LLog;
import com.lynx.xelement.viewpager.Pager;
import com.lynx.xelement.viewpager.ReversingAdapter;
import com.obric.aivoice.core.data.NameKeys;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010<\u001a\u00020;¢\u0006\u0004\b=\u0010>J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0004J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0012\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\n\u0010\n\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\f\u001a\u0004\u0018\u00010\u000bJ\u000e\u0010\u000f\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\rR\"\u0010\u0016\u001a\u00020\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R$\u0010\u001e\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\"\u0010&\u001a\u00020\u001f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\"\u0010*\u001a\u00020\u001f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b'\u0010!\u001a\u0004\b(\u0010#\"\u0004\b)\u0010%R\"\u00101\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u001d\u00107\u001a\b\u0012\u0002\b\u0003\u0018\u0001028\u0006¢\u0006\f\n\u0004\b3\u00104\u001a\u0004\b5\u00106R\"\u00109\u001a\u00020\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b8\u0010\u0011\u001a\u0004\b9\u0010\u0013\"\u0004\b:\u0010\u0015¨\u0006?"}, d2 = {"Lcom/lynx/xelement/viewpager/viewpager/BaseCustomViewPager;", "Landroidx/viewpager/widget/ViewPager;", "Ljava/lang/reflect/Field;", "getIsUnableToDrag", NameKeys.UnloadStrategy_No_Strategy, "getCurrentItem", "Landroidx/viewpager/widget/PagerAdapter;", "adapter", NameKeys.UnloadStrategy_No_Strategy, "setAdapter", "getAdapter", "Lcom/lynx/xelement/viewpager/ReversingAdapter;", "getReversingAdapter", NameKeys.UnloadStrategy_No_Strategy, "rtlMode", "setRTL", "a", "Z", "getMAllowHorizontalGesture", "()Z", "setMAllowHorizontalGesture", "(Z)V", "mAllowHorizontalGesture", "Lcom/lynx/xelement/viewpager/Pager$b;", "b", "Lcom/lynx/xelement/viewpager/Pager$b;", "getMInterceptTouchEventListener", "()Lcom/lynx/xelement/viewpager/Pager$b;", "setMInterceptTouchEventListener", "(Lcom/lynx/xelement/viewpager/Pager$b;)V", "mInterceptTouchEventListener", NameKeys.UnloadStrategy_No_Strategy, "c", "F", "getMLastMotionX", "()F", "setMLastMotionX", "(F)V", "mLastMotionX", "d", "getMLastMotionY", "setMLastMotionY", "mLastMotionY", "e", "I", "getMActivePointerId", "()I", "setMActivePointerId", "(I)V", "mActivePointerId", "Ljava/lang/Class;", "f", "Ljava/lang/Class;", "getSuperclass", "()Ljava/lang/Class;", "superclass", "g", "isRTLMode", "setRTLMode", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "ViewPager_release"}, k = 1, mv = {1, 6, 0})
public class BaseCustomViewPager extends ViewPager {
    public boolean a;
    public Pager.b b;
    public float c;
    public float d;
    public int e;
    public final Class<?> f;
    public boolean g;
    public final HashMap<ViewPager.OnPageChangeListener, ReversingOnPageChangeListener> h;

    public final Field getIsUnableToDrag() {
        Class<?> r1 = this.f;     // Catch: NoSuchFieldException -> L7
        if (r1 == null) goto L11;
        return r1.getDeclaredField("mIsUnableToDrag");
    L11:
        return null;
    L7:
        LLog.e("Foldview#BaseViewPagerImpl", "no such field mIsUnableToDrag");
        return null;
    }

    public PagerAdapter getAdapter() {
        ReversingAdapter r0 = (ReversingAdapter) super.getAdapter();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.a;
    }

    public int getCurrentItem() {
        int r0 = super.getCurrentItem();
        PagerAdapter r1 = super.getAdapter();
        if (r1 != null) goto L5;
        return r0;
    L5:
        if (this.g == true) goto L7;
        return r0;
    L7:
        return (r1.getCount() - r0) - 1;
    }

    public final ReversingAdapter getReversingAdapter() {
        PagerAdapter r0 = super.getAdapter();
        if ((r0 instanceof ReversingAdapter) == true) goto L7;
        return null;
    L7:
        return (ReversingAdapter) r0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        Class<?> r0 = this.f;     // Catch: Throwable -> L13
        if (r0 == null) goto L6;
        Method r1 = r0.getDeclaredMethod("populate", new Class[0]);     // Catch: Throwable -> L13
    L7:
        if (r1 == null) goto L10;
        r1.setAccessible(true);     // Catch: Throwable -> L13
    L10:
        if (r1 == null) goto L17;
        r1.invoke(this, new Object[0]);     // Catch: Throwable -> L13
        return;
    L17:
        return;
    L6:
        r1 = null;
    L13:
        LLog.e("Foldview#BaseViewPagerImpl", "populate failed");
        requestLayout();
    }

    public final int getMActivePointerId() {
        return this.e;
    }

    public final boolean getMAllowHorizontalGesture() {
        return this.a;
    }

    public final Pager.b getMInterceptTouchEventListener() {
        return this.b;
    }

    public final float getMLastMotionX() {
        return this.c;
    }

    public final float getMLastMotionY() {
        return this.d;
    }

    public final Class<?> getSuperclass() {
        return this.f;
    }

    public BaseCustomViewPager(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        new LinkedHashMap();
        super(r2);
        this.a = true;
        this.e = -1;
        Class<? super Object> r3 = getClass().getSuperclass();
        if (r3 == null) goto L5;
        Class<? super Object> r4 = r3.getSuperclass();
    L6:
        this.f = r4;
        this.h = new HashMap();
        return;
    L5:
        r4 = null;
        goto L6
    }

    public final void addOnPageChangeListener(ViewPager.OnPageChangeListener r3) {
        Intrinsics.checkNotNullParameter(r3, "listener");
        ReversingOnPageChangeListener r0 = new ReversingOnPageChangeListener(r3, this, super.getAdapter());
        this.h.put(r3, r0);
        super.addOnPageChangeListener(r0);
    }

    public boolean canScrollHorizontally(int r2) {
        if (this.a == true) goto L6;
        return false;
    L6:
        return super.canScrollHorizontally(r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean dispatchTouchEvent(MotionEvent r2) {
        return super/*android.view.ViewGroup*/.dispatchTouchEvent(r2);
    L4:
        e = move-exception;
        LLog.e("Foldview#BaseViewPagerImpl", e.toString());
        return false;
    }

    public final void removeOnPageChangeListener(ViewPager.OnPageChangeListener r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        ReversingOnPageChangeListener r3 = this.h.remove(r2);
        if (r3 == null) goto L6;
        super.removeOnPageChangeListener(r3);
        return;
    }

    public void setAdapter(PagerAdapter r2) {
        if (r2 == null) goto L4;
        r2 = new ReversingAdapter(r2);
    L4:
        super.setAdapter(r2);
    }

    public final void setMActivePointerId(int r1) {
        this.e = r1;
    }

    public final void setMAllowHorizontalGesture(boolean r1) {
        this.a = r1;
    }

    public final void setMInterceptTouchEventListener(Pager.b r1) {
        this.b = r1;
    }

    public final void setMLastMotionX(float r1) {
        this.c = r1;
    }

    public final void setMLastMotionY(float r1) {
        this.d = r1;
    }

    public final void setRTL(boolean r1) {
        this.g = r1;
    }

    public final void setRTLMode(boolean r1) {
        this.g = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean canScroll(View r2, boolean r3, int r4, int r5, int r6) {
        Intrinsics.checkNotNullParameter(r2, "childView");
        if ((r2 instanceof BaseCustomViewPager) == false) goto L11;
        if (super.canScroll(r2, r3, r4, r5, r6) == true) goto L7;
    L9:
        return false;
    L7:
        if (((BaseCustomViewPager) r2).a == false) goto L9;
        return true;
    L11:
        return super.canScroll(r2, r3, r4, r5, r6);
    }
}
