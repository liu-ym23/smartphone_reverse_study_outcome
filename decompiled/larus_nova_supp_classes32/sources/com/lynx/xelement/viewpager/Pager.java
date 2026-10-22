package com.lynx.xelement.viewpager;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewpager.widget.PagerAdapter;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.behavior.render.PlatformRendererContext;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.xelement.viewpager.childitem.LynxViewpagerItem;
import com.lynx.xelement.viewpager.viewpager.BaseCustomViewPager;
import com.lynx.xelement.viewpager.viewpager.CustomViewPager;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import x6a.d;
import x6a.e;
import x6a.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public abstract class Pager<T extends BaseCustomViewPager> extends LinearLayout implements e {
    public T a;
    public final List<LynxViewpagerItem> b;
    public final List<LynxViewpagerItem> c;
    public i d;
    public int e;
    public final Pager<T>.Adapter f;
    public boolean g;
    public boolean h;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/lynx/xelement/viewpager/Pager$Adapter;", "Landroidx/viewpager/widget/PagerAdapter;", "ViewPager_release"}, k = 1, mv = {1, 6, 0})
    public final class Adapter extends PagerAdapter {
        public final /* synthetic */ Pager<T> a;

        public final CharSequence getPageTitle(int r1) {
            return null;
        }

        public final int getCount() {
            return ((ArrayList) this.a.b).size();
        }

        public Adapter(Pager r1) {
            this.a = r1;
        }

        public final int getItemPosition(Object r2) {
            Intrinsics.checkNotNullParameter(r2, "object");
            int r3 = CollectionsKt.indexOf(this.a.b, r2);
            if (r3 != (-1)) goto L6;
            return -2;
        L6:
            return r3;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v0, types: [android.view.View] */
        public final Object instantiateItem(ViewGroup r4, int r5) {
            Intrinsics.checkNotNullParameter(r4, "container");
            LynxViewpagerItem r0 = (LynxViewpagerItem) ListProtector.get(this.a.b, r5);
            ViewGroup r1 = (ViewGroup) ((r8a.a) r0.getView()).getParent();
            if (r1 == 0) goto L5;
            r1.removeView(r0.getView());
        L5:
            r4.addView(r0.getView());
            r0.sendIsAttachedEvent(true, r5);
            return r0;
        }

        public final boolean isViewFromObject(View r3, Object r4) {
            Intrinsics.checkNotNullParameter(r3, "view");
            Intrinsics.checkNotNullParameter(r4, "obj");
            if ((r4 instanceof LynxViewpagerItem) == true) goto L5;
            return false;
        L5:
            if (r3 != ((LynxViewpagerItem) r4).getView()) goto L9;
            return true;
        L9:
            return false;
        }

        public final void destroyItem(ViewGroup r2, int r3, Object r4) {
            Intrinsics.checkNotNullParameter(r2, "container");
            Intrinsics.checkNotNullParameter(r4, "object");
            if ((r4 instanceof LynxViewpagerItem) == false) goto L6;
            LynxViewpagerItem r5 = (LynxViewpagerItem) r4;
            r2.removeView(r5.getView());
            r5.sendIsAttachedEvent(false, r3);
            return;
        }
    }

    public static final class a {
    }

    public interface b {
        void a();
    }

    static {
    }

    @Override // x6a.e
    public final /* synthetic */ void applyRendererClipBounds(boolean r1, Rect r2) {
        d.a(this, r1, r2);
    }

    @Override // x6a.e
    public final /* synthetic */ void applyRendererOpacity(float r1) {
        d.b(this, r1);
    }

    @Override // x6a.e
    public final /* synthetic */ void applyRendererTransform(float[] r1) {
        d.c(this, r1);
    }

    @Override // x6a.e
    public final /* synthetic */ PointF convertPointInRendererHostToScreen(PointF r1) {
        return d.d(this, r1);
    }

    @Override // x6a.e
    public /* bridge */ /* synthetic */ int getRendererHostHeight() {
        return d.e(this);
    }

    @Override // x6a.e
    public /* bridge */ /* synthetic */ int getRendererHostScrollX() {
        return d.f(this);
    }

    @Override // x6a.e
    public /* bridge */ /* synthetic */ int getRendererHostScrollY() {
        return d.g(this);
    }

    @Override // x6a.e
    public /* bridge */ /* synthetic */ int getRendererHostWidth() {
        return d.h(this);
    }

    @Override // x6a.e
    public View getView() {
        return this;
    }

    @Override // x6a.e
    public final /* synthetic */ void invalidateForRenderer() {
        d.i(this);
    }

    @Override // x6a.e
    public final /* synthetic */ boolean invokeUIMethod(String r1, ReadableMap r2, Callback r3) {
        return false;
    }

    @Override // x6a.e
    public final /* synthetic */ void requestLayoutForRenderer() {
        d.j(this);
    }

    @Override // x6a.e
    public /* bridge */ /* synthetic */ void setClipChildrenForRenderer(boolean r1) {
        d.k(this, r1);
    }

    @Override // x6a.e
    public /* bridge */ /* synthetic */ void setWillNotDrawForRenderer(boolean r1) {
        d.l(this, r1);
    }

    public final boolean getMChanged() {
        return this.h;
    }

    public final List<LynxViewpagerItem> getMPendingChildren() {
        return this.c;
    }

    public final T getMViewPager() {
        return this.a;
    }

    @Override // x6a.e
    public i getRenderer() {
        return this.d;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas r2) {
        Intrinsics.checkNotNullParameter(r2, "canvas");
        super.dispatchDraw(r2);
        i r0 = this.d;
        if (r0 == null) goto L6;
        r0.a(r2);
        return;
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onDraw(Canvas r2) {
        Intrinsics.checkNotNullParameter(r2, "canvas");
        i r0 = this.d;
        if (r0 == null) goto L6;
        r0.g(r2);
        return;
    L6:
        super.onDraw(r2);
    }

    public final void setAllowHorizontalGesture(boolean r2) {
        this.a.setMAllowHorizontalGesture(r2);
    }

    public final void setCurrentSelectIndex(int r2) {
        this.a.setCurrentItem(r2);
    }

    public final void setKeepItemView(boolean r2) {
        if (r2 == false) goto L4;
        this.a.setOffscreenPageLimit(Integer.MAX_VALUE);
        return;
    L4:
        this.a.setOffscreenPageLimit(1);
    }

    public final void setLynxDirection(int r4) {
        if (r4 == 2) goto L7;
        if (r4 == 2) goto L7;
        boolean r5 = false;
    L9:
        if (r5 == this.g) goto L15;
        ReversingAdapter r0 = this.a.getReversingAdapter();
        int r1 = this.a.getCurrentItem();
        this.g = r5;
        this.a.setRTL(r5);
        if (r0 == null) goto L13;
        r0.b = r5;
        r0.notifyDataSetChanged();
    L13:
        this.a.setCurrentItem(r1);
        return;
    L15:
        return;
    L7:
        r5 = true;
        goto L9
    }

    public final void setMChanged(boolean r1) {
        this.h = r1;
    }

    public final void setMViewPager(T r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.a = r2;
    }

    public final void setRTLMode(boolean r1) {
        this.g = r1;
    }

    @Override // x6a.e
    public void setRenderer(i r2) {
        Intrinsics.checkNotNullParameter(r2, "renderer");
        this.d = r2;
    }

    public final void setSelectedIndex(int r1) {
        this.e = r1;
    }

    public Pager(CustomViewPager r3, Context r4) {
        Intrinsics.checkNotNullParameter(r3, "mViewPager");
        Intrinsics.checkNotNullParameter(r4, "context");
        new LinkedHashMap();
        super(r4);
        this.a = r3;
        this.b = new ArrayList();
        this.c = new ArrayList();
        Pager<T>.Adapter r5 = new Adapter(this);
        this.f = r5;
        this.h = true;
        setOrientation(1);
        this.a.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        this.a.setAdapter(r5);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        addView(this.a, 0);
    }

    @Override // x6a.e
    public final i createRenderer(PlatformRendererContext r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "platformRendererContext");
        return new i(r2, r3);
    }

    @Override // android.view.ViewGroup
    public final boolean drawChild(Canvas r2, View r3, long r4) {
        Intrinsics.checkNotNullParameter(r2, "canvas");
        Intrinsics.checkNotNullParameter(r3, "child");
        i r0 = this.d;
        if (r0 == null) goto L5;
        r0.b(r2, r3);
    L5:
        boolean r5 = super.drawChild(r2, r3, r4);
        if (this.d == null) goto L8;
        r2.restore();
    L8:
        return r5;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r2, int r3, int r4, int r5, int r6) {
        i r0 = this.d;
        if (r0 == null) goto L7;
        LynxBaseUI r1 = r0.h;
        if (r1 == null) goto L7;
        r1.measure();
    L7:
        super.onLayout(r2, r3, r4, r5, r6);
    }
}
