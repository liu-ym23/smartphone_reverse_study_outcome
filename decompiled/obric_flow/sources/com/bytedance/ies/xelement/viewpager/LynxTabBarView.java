package com.bytedance.ies.xelement.viewpager;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.RequiresApi;
import androidx.core.view.ViewCompat;
import bf.b;
import com.bytedance.ai.bridge.method.router.OpenPageMethod;
import com.bytedance.ies.xelement.viewpager.childitem.LynxTabbarItem;
import com.google.android.material.tabs.TabLayout;
import com.lynx.animax.i;
import com.lynx.jsbridge.LynxResourceModule;
import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.b0;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.c0;
import com.lynx.tasm.behavior.f0;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.LynxUI;
import com.lynx.tasm.behavior.ui.utils.e;
import com.lynx.tasm.behavior.ui.view.UISimpleView;
import com.lynx.tasm.behavior.ui.z;
import com.lynx.tasm.r;
import com.obric.launcher.widget.R$drawable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.TypeIntrinsics;
import xe.c;
import ym.d;
import ze.a;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0017\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001/J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\f\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0007¢\u0006\u0004\b\f\u0010\u0007J\u0017\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\rH\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\rH\u0007¢\u0006\u0004\b\u0011\u0010\u0010J\u0017\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\rH\u0007¢\u0006\u0004\b\u0012\u0010\u0010J\u0017\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0013H\u0007¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0013H\u0007¢\u0006\u0004\b\u0018\u0010\u0016J\u0017\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\rH\u0007¢\u0006\u0004\b\u0019\u0010\u0010J\u0017\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\rH\u0007¢\u0006\u0004\b\u001a\u0010\u0010J\u0017\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\rH\u0007¢\u0006\u0004\b\u001b\u0010\u0010J\u0017\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\rH\u0007¢\u0006\u0004\b\u001c\u0010\u0010J\u0017\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u0003H\u0007¢\u0006\u0004\b\u001e\u0010\u0007J\u0017\u0010 \u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\rH\u0007¢\u0006\u0004\b \u0010\u0010J\u0017\u0010\"\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\rH\u0007¢\u0006\u0004\b\"\u0010\u0010J\u0017\u0010$\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\rH\u0007¢\u0006\u0004\b$\u0010\u0010J\u0017\u0010%\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0007¢\u0006\u0004\b%\u0010\u0007J\u0017\u0010'\u001a\u00020\u00052\u0006\u0010&\u001a\u00020\bH\u0007¢\u0006\u0004\b'\u0010\u000bJ\u0017\u0010(\u001a\u00020\u00052\u0006\u0010&\u001a\u00020\bH\u0007¢\u0006\u0004\b(\u0010\u000bJ#\u0010-\u001a\u00020\u00052\u0006\u0010*\u001a\u00020)2\n\b\u0002\u0010,\u001a\u0004\u0018\u00010+H\u0007¢\u0006\u0004\b-\u0010.¨\u00060"}, d2 = {"Lcom/bytedance/ies/xelement/viewpager/LynxTabBarView;", "Lcom/lynx/tasm/behavior/ui/view/UISimpleView;", "Lze/a;", "", "color", "", "setBackground", "(Ljava/lang/String;)V", "", "enable", "setTabNewGesture", "(Z)V", "setTabIndicatorColor", "", "value", "setTabInterspace", "(F)V", "setTabHeight", "setTabHeightRpx", "", OpenPageMethod.ALIGN_LEFT, "setTabPaddingLeft", "(I)V", "right", "setTabPaddingRight", "setTabIndicatorWidth", "setTabIndicatorHeight", "setTabIndicatorRadius", "set", "gravity", "setTablayoutGravity", "height", "setBorderHeight", "top", "setBorderTop", "width", "setBorderWidth", "setBorderLineColor", "disable", "setDisableAttachEvent", "setOriginChangeEvent", "Lcom/lynx/react/bridge/ReadableMap;", LynxResourceModule.PARAMS_KEY, "Lcom/lynx/react/bridge/Callback;", "callback", "selectTab", "(Lcom/lynx/react/bridge/ReadableMap;Lcom/lynx/react/bridge/Callback;)V", "com/lynx/tasm/behavior/ui/utils/e", "x-element-fold-view_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class LynxTabBarView extends UISimpleView<a> {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ int f6512k = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f6513a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a f6514b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f6515c;
    public d d;
    public TabLayout.Tab e;
    public boolean f;
    public final HashMap g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ArrayList f6516h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f6517i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final c f6518j;

    public LynxTabBarView(b0 r5, z r10) {
        super(r5, r10);
        this.f6515c = 9.0f;
        this.f = true;
        this.g = new HashMap();
        this.f6516h = new ArrayList();
        this.f6517i = -1.0f;
        this.f6518j = new c(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v19, types: [T, com.google.android.material.tabs.TabLayout$Tab] */
    /* JADX WARN: Type inference failed for: r3v2, types: [T, com.google.android.material.tabs.TabLayout$Tab] */
    public final void b(int r10, int r11) {
        int r5 = this.mChildren.size();
    L3:
        if (r10 >= r5) goto L52;
        LynxBaseUI r12 = this.mChildren.get(r10);
        Ref.ObjectRef r13 = new Ref.ObjectRef();
        a r14 = this.f6514b;
        TabLayout.TabView r15 = null;
        if (r14 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("mTabLayout");
        r14 = null;
    L7:
        ?? r16 = r14.getTabAt(r10);
        r13.element = r16;
        if (r16 != 0) goto L17;
        a r17 = this.f6514b;
        if (r17 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("mTabLayout");
        r17 = null;
    L12:
        ?? r18 = r17.newTab();
        a r19 = this.f6514b;
        a r20 = r19;
        if (r19 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("mTabLayout");
        r20 = 0;
    L15:
        r20.addTab(r18);
        r13.element = r18;
    L17:
        if ((r12 instanceof LynxTabbarItem) == false) goto L19;
        ((LynxTabbarItem) r12).f6546b = (TabLayout.Tab) r13.element;
    L19:
        if (r11 != r10) goto L23;
        TabLayout.Tab r21 = (TabLayout.Tab) r13.element;
        if (r21 == null) goto L23;
        r21.select();
    L23:
        TabLayout.Tab r22 = (TabLayout.Tab) r13.element;
        if (r22 == null) goto L27;
        r22.setCustomView((View) this.f6516h.get(r10));
    L27:
        TabLayout.Tab r23 = (TabLayout.Tab) r13.element;
        if (r23 == null) goto L30;
        TabLayout.TabView r24 = r23.view;
    L31:
        if (r24 == null) goto L33;
        r24.setBackgroundColor(0);
    L33:
        int r25 = com.lynx.jsbridge.a.a(this.mContext, this.f6515c);
        TabLayout.Tab r26 = (TabLayout.Tab) r13.element;
        if (r26 == null) goto L36;
        View r27 = r26.getCustomView();
    L37:
        Intrinsics.checkNotNull(r27);
        TabLayout.Tab r28 = (TabLayout.Tab) r13.element;
        if (r28 == null) goto L40;
        View r29 = r28.getCustomView();
    L41:
        Intrinsics.checkNotNull(r29);
        int r30 = r29.getPaddingTop();
        TabLayout.Tab r31 = (TabLayout.Tab) r13.element;
        if (r31 == null) goto L44;
        View r32 = r31.getCustomView();
    L45:
        Intrinsics.checkNotNull(r32);
        ViewCompat.setPaddingRelative(r27, r25, r30, r25, r32.getPaddingBottom());
        TabLayout.Tab r33 = (TabLayout.Tab) r13.element;
        if (r33 == null) goto L48;
        r15 = r33.view;
    L48:
        if (r15 == null) goto L51;
        r15.setOnClickListener(new com.google.android.material.snackbar.a(8, this, r13));
        r10 = r10 + 1;
        goto L3
    L51:
        throw new NullPointerException("null cannot be cast to non-null type android.view.View");
    L44:
        r32 = null;
        goto L45
    L40:
        r29 = null;
        goto L41
    L36:
        r27 = null;
        goto L37
    L30:
        r24 = null;
        goto L31
    }

    public final void c(int r5) {
        Iterator<T> r10 = this.mChildren.iterator();
    L4:
        if (r10.hasNext() == false) goto L10;
        Object r11 = r10.next();
        LynxBaseUI r12 = (LynxBaseUI) r11;
        if ((r12 instanceof LynxTabbarItem) == false) goto L4;
        if (((LynxTabbarItem) r12).d == false) goto L4;
    L11:
        LynxTabbarItem r13 = (LynxTabbarItem) r11;
        if (r13 == null) goto L16;
        Integer r14 = r13.f6545a;
        if (r14 == null) goto L16;
        r5 = r14.intValue();
    L16:
        b(0, r5);
        return;
    L10:
        r11 = null;
        goto L11
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI
    public final View createView(Context r5) {
        if (r5 == null) goto L11;
        a r10 = e.h(r5);
        this.f6514b = r10;
        this.d = new d(this);
        r10.addOnAttachStateChangeListener(new b(this, 6));
        a r11 = this.f6514b;
        if (r11 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("mTabLayout");
        return null;
    L9:
        return r11;
    L11:
        return null;
    }

    @Override // com.lynx.tasm.behavior.ui.UIGroup, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r5) {
        return new LinearLayout.LayoutParams(-2, -2);
    }

    public final void i() {
        a r5 = this.f6514b;
        if (r5 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mTabLayout");
        r5 = null;
    L5:
        c r10 = this.f6518j;
        r5.addOnTabSelectedListener(r10);
        if (this.f == true) goto L41;
        a r11 = this.f6514b;
        if (r11 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("mTabLayout");
        r11 = null;
    L10:
        a r12 = this.f6514b;
        if (r12 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("mTabLayout");
        r12 = null;
    L13:
        TabLayout.Tab r13 = r11.getTabAt(r12.getSelectedTabPosition());
        LynxTabBarView r14 = r10.f23108a;
        if (r14.f6513a == false) goto L42;
        int r15 = 0;
        if (r13 == null) goto L30;
        a r16 = r14.f6514b;
        if (r16 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("mTabLayout");
        r16 = null;
    L21:
        int r17 = r16.getTabCount();
        int r18 = 0;
    L22:
        if (r18 >= r17) goto L30;
        a r19 = r14.f6514b;
        if (r19 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("mTabLayout");
        r19 = null;
    L27:
        if (r19.getTabAt(r18) == r13) goto L28;
        r18 = r18 + 1;
        goto L22
    L28:
        r15 = r18;
    L30:
        LynxTabBarView r20 = r10.f23108a;
        r r21 = r20.getLynxContext().g;
        i r22 = new i(r20.getSign(), "change");
        String r23 = (String) r20.g.get(Integer.valueOf(r15));
        if (r23 != null) goto L33;
        r23 = "";
    L33:
        r22.a("tag", r23);
        r22.a("index", Integer.valueOf(r15));
        if (r20.e != r13) goto L36;
        String r24 = "click";
    L37:
        r22.a("scene", r24);
        r21.b(r22);
        r20.e = null;
        return;
    L36:
        r24 = "slide";
        goto L37
    L42:
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.UIGroup, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void insertChild(LynxBaseUI r5, int r10) {
        if ((r5 instanceof LynxUI) == true) goto L5;
    L18:
        Log.e("LynxTabBarView", "child didn't match LynxTabbarItem");
        return;
    L5:
        if ((r5 instanceof LynxTabbarItem) == false) goto L18;
        LynxTabbarItem r11 = (LynxTabbarItem) r5;
        r11.setParent(this);
        this.mChildren.add(r10, r5);
        xe.a r12 = new xe.a(this.mContext);
        r12.setOverflow(r11.getOverflow());
        r12.addView(((LynxUI) r5).getView());
        r11.f6547c = r12;
        this.f6516h.add(r10, r12);
        if (r11.getProps().containsKey("tag") == false) goto L10;
        Integer r13 = Integer.valueOf(r10);
        this.g.put(r13, String.valueOf(r11.getProps().get("tag")));
    L10:
        if (r11.d == false) goto L12;
        int r14 = r10;
    L13:
        b(r10, r14);
        a r15 = this.f6514b;
        if (r15 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("mTabLayout");
        r15 = null;
    L16:
        Intrinsics.checkNotNullParameter(r15, "tabLayout");
        r11.f6545a = Integer.valueOf(r10);
        r11.e = r15;
        return;
    L12:
        r14 = 0;
        goto L13
    }

    public final void j() {
        a r5 = this.f6514b;
        a r10 = null;
        if (r5 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("mTabLayout");
        r5 = null;
    L6:
        if (r5.getBackground() != null) goto L16;
        a r11 = this.f6514b;
        if (r11 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("mTabLayout");
        r11 = null;
    L10:
        r11.setBackgroundResource(R$drawable.lynx_tab_line_bg);
        a r12 = this.f6514b;
        if (r12 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("mTabLayout");
    L14:
        r10.getBackground().mutate();
        return;
    L13:
        r10 = r12;
        goto L14
    }

    @Override // com.lynx.tasm.behavior.ui.UIGroup, com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void measure() {
        if (this.f6517i <= 0.0f) goto L11;
        a r5 = this.f6514b;
        if (r5 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("mTabLayout");
        r5 = null;
    L7:
        ViewGroup.LayoutParams r10 = r5.getLayoutParams();
        if (r10 == null) goto L11;
        LynxContext r11 = this.mContext;
        float r12 = this.f6517i;
        Intrinsics.checkNotNullParameter(r11, "context");
        r10.height = (int) ((r12 * r11.getResources().getDisplayMetrics().widthPixels) / 750);
    L11:
        super.measure();
    }

    @Override // com.lynx.tasm.behavior.ui.UIGroup, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final boolean needCustomLayout() {
        return true;
    }

    @Override // com.lynx.tasm.behavior.ui.UIGroup, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void removeChild(LynxBaseUI r5) {
        if ((r5 instanceof LynxUI) == true) goto L5;
        return;
    L5:
        if ((r5 instanceof LynxTabbarItem) == false) goto L12;
        this.mChildren.remove(r5);
        ArrayList r10 = this.f6516h;
        LynxTabbarItem r11 = (LynxTabbarItem) r5;
        xe.a r12 = r11.f6547c;
        TypeIntrinsics.asMutableCollection(r10).remove(r12);
        a r13 = this.f6514b;
        if (r13 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("mTabLayout");
        r13 = null;
    L9:
        r13.removeTab(r11.f6546b);
        return;
    }

    @f0
    public final void selectTab(ReadableMap r10, Callback r11) {
        Intrinsics.checkNotNullParameter(r10, LynxResourceModule.PARAMS_KEY);
        JavaOnlyMap r5 = new JavaOnlyMap();
        r5.put("success", Boolean.FALSE);
        if (r10.hasKey("index") == false) goto L26;
        int r12 = r10.getInt("index");
        if (r12 < 0) goto L22;
        a r13 = this.f6514b;
        a r14 = null;
        if (r13 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("mTabLayout");
        r13 = null;
    L10:
        if (r12 >= r13.getTabCount()) goto L22;
        a r15 = this.f6514b;
        if (r15 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("mTabLayout");
    L15:
        TabLayout.Tab r16 = r14.getTabAt(r12);
        if (r16 == null) goto L18;
        r16.select();
    L18:
        r5.put("success", Boolean.TRUE);
        if (r11 == null) goto L30;
        r11.invoke(new Object[]{0, r5});
        return;
    L30:
        return;
    L14:
        r14 = r15;
    L22:
        r5.put("msg", "index out of bounds");
        if (r11 == null) goto L31;
        r11.invoke(new Object[]{0, r5});
        return;
    L31:
        return;
    L26:
        r5.put("msg", "no index key");
        if (r11 == null) goto L32;
        r11.invoke(new Object[]{0, r5});
        return;
    }

    @c0(name = "tab-indicator-top")
    public final void set(float r10) {
        a r5 = this.f6514b;
        LayerDrawable r11 = null;
        if (r5 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mTabLayout");
        r5 = null;
    L5:
        Drawable r12 = r5.getTabSelectedIndicator();
        if ((r12 instanceof LayerDrawable) == false) goto L8;
        r11 = (LayerDrawable) r12;
    L8:
        LayerDrawable r13 = r11;
        if (r13 == null) goto L12;
        r13.setLayerInset(0, 0, 0, 0, com.lynx.jsbridge.a.a(this.mContext, r10));
        return;
    }

    @c0(name = "background")
    public final void setBackground(String r5) {
        Intrinsics.checkNotNullParameter(r5, "color");
        j();
        a r10 = this.f6514b;
        GradientDrawable r11 = null;
        if (r10 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mTabLayout");
        r10 = null;
    L5:
        Drawable r12 = r10.getBackground();
        if ((r12 instanceof LayerDrawable) == false) goto L8;
        LayerDrawable r13 = (LayerDrawable) r12;
    L9:
        if (r13 == null) goto L11;
        Drawable r14 = r13.getDrawable(0);
    L13:
        if ((r14 instanceof GradientDrawable) == false) goto L15;
        r11 = (GradientDrawable) r14;
    L15:
        if (r11 == null) goto L18;
        r11.setColor(com.lynx.jsbridge.a.b(r5));
        return;
    L18:
        return;
    L11:
        r14 = null;
        goto L13
    L8:
        r13 = null;
        goto L9
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void setBackgroundColor(int r5) {
        j();
        a r10 = this.f6514b;
        GradientDrawable r11 = null;
        if (r10 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mTabLayout");
        r10 = null;
    L5:
        Drawable r12 = r10.getBackground();
        if ((r12 instanceof LayerDrawable) == false) goto L8;
        LayerDrawable r13 = (LayerDrawable) r12;
    L9:
        if (r13 == null) goto L11;
        Drawable r14 = r13.getDrawable(0);
    L13:
        if ((r14 instanceof GradientDrawable) == false) goto L15;
        r11 = (GradientDrawable) r14;
    L15:
        if (r11 == null) goto L18;
        r11.setColor(r5);
        return;
    L18:
        return;
    L11:
        r14 = null;
        goto L13
    L8:
        r13 = null;
        goto L9
    }

    @c0(name = "border-height")
    public final void setBorderHeight(float r5) {
        j();
        a r10 = this.f6514b;
        GradientDrawable r11 = null;
        if (r10 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mTabLayout");
        r10 = null;
    L5:
        Drawable r12 = r10.getBackground();
        if ((r12 instanceof LayerDrawable) == false) goto L8;
        LayerDrawable r13 = (LayerDrawable) r12;
    L9:
        if (r13 == null) goto L11;
        Drawable r14 = r13.getDrawable(1);
    L13:
        if ((r14 instanceof GradientDrawable) == false) goto L15;
        r11 = (GradientDrawable) r14;
    L15:
        if (r11 == null) goto L18;
        r11.setSize(r11.getIntrinsicWidth(), com.lynx.jsbridge.a.a(this.mContext, r5));
        return;
    L18:
        return;
    L11:
        r14 = null;
        goto L13
    L8:
        r13 = null;
        goto L9
    }

    @c0(name = "border-color")
    public final void setBorderLineColor(String r5) {
        Intrinsics.checkNotNullParameter(r5, "color");
        j();
        a r10 = this.f6514b;
        GradientDrawable r11 = null;
        if (r10 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mTabLayout");
        r10 = null;
    L5:
        Drawable r12 = r10.getBackground();
        if ((r12 instanceof LayerDrawable) == false) goto L8;
        LayerDrawable r13 = (LayerDrawable) r12;
    L9:
        if (r13 == null) goto L11;
        Drawable r14 = r13.getDrawable(1);
    L13:
        if ((r14 instanceof GradientDrawable) == false) goto L15;
        r11 = (GradientDrawable) r14;
    L15:
        if (r11 == null) goto L18;
        r11.setColor(com.lynx.jsbridge.a.b(r5));
        return;
    L18:
        return;
    L11:
        r14 = null;
        goto L13
    L8:
        r13 = null;
        goto L9
    }

    @c0(name = "border-top")
    public final void setBorderTop(float r10) {
        j();
        a r5 = this.f6514b;
        LayerDrawable r11 = null;
        if (r5 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mTabLayout");
        r5 = null;
    L5:
        Drawable r12 = r5.getBackground();
        if ((r12 instanceof LayerDrawable) == false) goto L8;
        r11 = (LayerDrawable) r12;
    L8:
        LayerDrawable r13 = r11;
        if (r13 == null) goto L12;
        r13.setLayerInset(0, 0, 0, 0, com.lynx.jsbridge.a.a(this.mContext, r10));
        return;
    }

    @c0(name = "border-width")
    public final void setBorderWidth(float r5) {
        j();
        LynxContext r10 = this.mContext;
        Intrinsics.checkNotNullParameter(r10, "context");
        int r11 = (int) ((r5 / 375.0f) * r10.getResources().getDisplayMetrics().widthPixels);
        a r12 = this.f6514b;
        GradientDrawable r13 = null;
        if (r12 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mTabLayout");
        r12 = null;
    L5:
        Drawable r14 = r12.getBackground();
        if ((r14 instanceof LayerDrawable) == false) goto L8;
        LayerDrawable r15 = (LayerDrawable) r14;
    L9:
        if (r15 == null) goto L11;
        Drawable r16 = r15.getDrawable(1);
    L13:
        if ((r16 instanceof GradientDrawable) == false) goto L15;
        r13 = (GradientDrawable) r16;
    L15:
        if (r13 == null) goto L18;
        r13.setSize(r11, r13.getIntrinsicHeight());
        return;
    L18:
        return;
    L11:
        r16 = null;
        goto L13
    L8:
        r15 = null;
        goto L9
    }

    @c0(defaultBoolean = true, name = "disable-attach-event")
    public final void setDisableAttachEvent(boolean r5) {
        this.f = r5;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void setEvents(Map r5) {
        super.setEvents(r5);
        Log.d("LynxTabBarView", "events: " + r5);
        if (r5 == null) goto L6;
        this.f6513a = r5.containsKey("change");
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void setLynxDirection(int r5) {
        super.setLynxDirection(r5);
        a r10 = null;
        if (r5 == 2) goto L12;
        if (r5 == 2) goto L12;
        a r11 = this.f6514b;
        if (r11 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("mTabLayout");
    L10:
        ViewCompat.setLayoutDirection(r10, 0);
        return;
    L9:
        r10 = r11;
    L12:
        a r12 = this.f6514b;
        if (r12 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("mTabLayout");
    L16:
        ViewCompat.setLayoutDirection(r10, 1);
        return;
    L15:
        r10 = r12;
        goto L16
    }

    @c0(defaultBoolean = false, name = "android-force-bind-change-event")
    public final void setOriginChangeEvent(boolean r5) {
        if (this.f6514b == null) goto L6;
        i();
        return;
    }

    @c0(name = "tab-height")
    public final void setTabHeight(float r5) {
        a r10 = this.f6514b;
        a r11 = null;
        if (r10 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mTabLayout");
        r10 = null;
    L5:
        ViewGroup.LayoutParams r12 = r10.getLayoutParams();
        if (r12 == null) goto L9;
        r12.height = com.lynx.jsbridge.a.a(this.mContext, r5);
    L9:
        a r13 = this.f6514b;
        if (r13 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("mTabLayout");
    L13:
        r11.requestLayout();
        return;
    L12:
        r11 = r13;
        goto L13
    }

    @c0(name = "tab-height-rpx")
    public final void setTabHeightRpx(float r10) {
        this.f6517i = r10;
        a r11 = this.f6514b;
        a r5 = null;
        if (r11 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mTabLayout");
        r11 = null;
    L5:
        ViewGroup.LayoutParams r12 = r11.getLayoutParams();
        if (r12 == null) goto L9;
        LynxContext r13 = this.mContext;
        float r14 = this.f6517i;
        Intrinsics.checkNotNullParameter(r13, "context");
        r12.height = (int) ((r14 * r13.getResources().getDisplayMetrics().widthPixels) / 750);
    L9:
        a r15 = this.f6514b;
        if (r15 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("mTabLayout");
    L13:
        r5.requestLayout();
        return;
    L12:
        r5 = r15;
        goto L13
    }

    @c0(name = "tab-indicator-color")
    public final void setTabIndicatorColor(String r5) {
        Intrinsics.checkNotNullParameter(r5, "color");
        a r10 = this.f6514b;
        if (r10 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mTabLayout");
        r10 = null;
    L5:
        r10.setSelectedTabIndicatorColor(com.lynx.jsbridge.a.b(r5));
    }

    @c0(name = "tab-indicator-height")
    public final void setTabIndicatorHeight(float r10) {
        a r5 = this.f6514b;
        a r11 = null;
        if (r5 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mTabLayout");
        r5 = null;
    L5:
        Drawable r12 = r5.getTabSelectedIndicator();
        if ((r12 instanceof LayerDrawable) == false) goto L8;
        LayerDrawable r13 = (LayerDrawable) r12;
    L9:
        if (r13 == null) goto L11;
        Drawable r14 = r13.getDrawable(0);
    L13:
        if ((r14 instanceof GradientDrawable) == false) goto L15;
        GradientDrawable r15 = (GradientDrawable) r14;
    L16:
        if (r15 == null) goto L18;
        r15.setSize(r15.getIntrinsicWidth(), com.lynx.jsbridge.a.a(this.mContext, r10));
    L18:
        a r16 = this.f6514b;
        if (r16 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("mTabLayout");
    L22:
        r11.requestLayout();
        return;
    L21:
        r11 = r16;
        goto L22
    L15:
        r15 = null;
        goto L16
    L11:
        r14 = null;
        goto L13
    L8:
        r13 = null;
        goto L9
    }

    @c0(name = "tab-indicator-radius")
    public final void setTabIndicatorRadius(float r5) {
        a r10 = this.f6514b;
        a r11 = null;
        if (r10 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mTabLayout");
        r10 = null;
    L5:
        Drawable r12 = r10.getTabSelectedIndicator();
        if ((r12 instanceof LayerDrawable) == false) goto L8;
        LayerDrawable r13 = (LayerDrawable) r12;
    L9:
        if (r13 == null) goto L11;
        Drawable r14 = r13.getDrawable(0);
    L13:
        if ((r14 instanceof GradientDrawable) == false) goto L15;
        GradientDrawable r15 = (GradientDrawable) r14;
    L16:
        if (r15 == null) goto L19;
        r15.setCornerRadius(com.lynx.jsbridge.a.a(this.mContext, r5));
    L19:
        a r16 = this.f6514b;
        if (r16 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("mTabLayout");
    L23:
        r11.requestLayout();
        return;
    L22:
        r11 = r16;
        goto L23
    L15:
        r15 = null;
        goto L16
    L11:
        r14 = null;
        goto L13
    L8:
        r13 = null;
        goto L9
    }

    @c0(name = "tab-indicator-width")
    public final void setTabIndicatorWidth(float r10) {
        a r5 = this.f6514b;
        a r11 = null;
        if (r5 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mTabLayout");
        r5 = null;
    L5:
        Drawable r12 = r5.getTabSelectedIndicator();
        if ((r12 instanceof LayerDrawable) == false) goto L8;
        LayerDrawable r13 = (LayerDrawable) r12;
    L9:
        if (r13 == null) goto L11;
        Drawable r14 = r13.getDrawable(0);
    L13:
        if ((r14 instanceof GradientDrawable) == false) goto L15;
        GradientDrawable r15 = (GradientDrawable) r14;
    L16:
        if (r15 == null) goto L18;
        LynxContext r16 = this.mContext;
        Intrinsics.checkNotNullParameter(r16, "context");
        r15.setSize((int) ((r10 / 375.0f) * r16.getResources().getDisplayMetrics().widthPixels), r15.getIntrinsicHeight());
    L18:
        a r17 = this.f6514b;
        if (r17 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("mTabLayout");
    L22:
        r11.requestLayout();
        return;
    L21:
        r11 = r17;
        goto L22
    L15:
        r15 = null;
        goto L16
    L11:
        r14 = null;
        goto L13
    L8:
        r13 = null;
        goto L9
    }

    @c0(name = "tab-inter-space")
    public final void setTabInterspace(float r5) {
        this.f6515c = r5 / 2;
    }

    @c0(defaultBoolean = false, name = "tab-new-gesture-enable")
    public final void setTabNewGesture(boolean r5) {
        a r10 = this.f6514b;
        if (r10 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mTabLayout");
        r10 = null;
    L5:
        r10.getClass();
    }

    @c0(name = "tab-padding-left")
    public final void setTabPaddingLeft(int r10) {
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L6
        a r11 = this.f6514b;     // Catch: Throwable -> L6
        Object r12 = null;
        if (r11 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mTabLayout");     // Catch: Throwable -> L6
        r11 = null;
    L8:
        Class<? super Object> r13 = r11.getClass().getSuperclass();     // Catch: Throwable -> L6
        if (r13 == null) goto L11;
        Field r14 = r13.getDeclaredField("contentInsetStart");     // Catch: Throwable -> L6
    L13:
        if (r14 == null) goto L16;
        r14.setAccessible(true);     // Catch: Throwable -> L6
    L16:
        if (r14 == null) goto L21;
        a r15 = this.f6514b;     // Catch: Throwable -> L6
        if (r15 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("mTabLayout");     // Catch: Throwable -> L6
        r15 = null;
    L20:
        r14.set(r15, Integer.valueOf(com.lynx.jsbridge.a.a(this.mContext, r10)));     // Catch: Throwable -> L6
    L21:
        a r16 = this.f6514b;     // Catch: Throwable -> L6
        if (r16 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("mTabLayout");     // Catch: Throwable -> L6
        r16 = null;
    L24:
        Class<? super Object> r17 = r16.getClass().getSuperclass();     // Catch: Throwable -> L6
        if (r17 == null) goto L27;
        Method r18 = r17.getDeclaredMethod("applyModeAndGravity", null);     // Catch: Throwable -> L6
    L28:
        if (r18 == null) goto L31;
        r18.setAccessible(true);     // Catch: Throwable -> L6
    L31:
        if (r18 == null) goto L36;
        a r19 = this.f6514b;     // Catch: Throwable -> L6
        if (r19 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("mTabLayout");     // Catch: Throwable -> L6
        r19 = null;
    L35:
        r12 = r18.invoke(r19, null);     // Catch: Throwable -> L6
    L36:
        Result.m124constructorimpl(r12);     // Catch: Throwable -> L6
        return;
    L27:
        r18 = null;
        goto L28
    L11:
        r14 = null;
    L6:
        th = move-exception;
        Result.Companion r20 = Result.Companion;
        Result.m124constructorimpl(ResultKt.createFailure(th));
    }

    @RequiresApi(17)
    @c0(name = "tab-padding-right")
    public final void setTabPaddingRight(int r10) {
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L6
        a r11 = this.f6514b;     // Catch: Throwable -> L6
        a r12 = null;
        if (r11 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mTabLayout");     // Catch: Throwable -> L6
        r11 = null;
    L8:
        Class<? super Object> r13 = r11.getClass().getSuperclass();     // Catch: Throwable -> L6
        if (r13 == null) goto L11;
        Field r14 = r13.getDeclaredField("slidingTabIndicator");     // Catch: Throwable -> L6
    L12:
        if (r14 == null) goto L15;
        r14.setAccessible(true);     // Catch: Throwable -> L6
    L15:
        if (r14 == null) goto L20;
        a r15 = this.f6514b;     // Catch: Throwable -> L6
        if (r15 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("mTabLayout");     // Catch: Throwable -> L6
        r15 = null;
    L19:
        Object r16 = r14.get(r15);     // Catch: Throwable -> L6
    L21:
        if (r16 == null) goto L29;
        LinearLayout r17 = (LinearLayout) r16;     // Catch: Throwable -> L6
        ViewCompat.setPaddingRelative(r17, r17.getPaddingStart(), r17.getPaddingTop(), com.lynx.jsbridge.a.a(this.mContext, r10), r17.getPaddingBottom());     // Catch: Throwable -> L6
        a r18 = this.f6514b;     // Catch: Throwable -> L6
        if (r18 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("mTabLayout");     // Catch: Throwable -> L6
    L26:
        r12.requestLayout();     // Catch: Throwable -> L6
        Result.m124constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L6
        return;
    L25:
        r12 = r18;
        goto L26
    L29:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout");     // Catch: Throwable -> L6
    L20:
        r16 = null;
        goto L21
    L11:
        r14 = null;
    L6:
        th = move-exception;
        Result.Companion r19 = Result.Companion;
        Result.m124constructorimpl(ResultKt.createFailure(th));
    }

    @c0(name = "tab-layout-gravity")
    public final void setTablayoutGravity(String r10) {
        Intrinsics.checkNotNullParameter(r10, "gravity");
        String r11 = r10.toLowerCase(Locale.ROOT);
        int r5 = r11.hashCode();
        a r12 = null;
        if (r5 == (-1364013995)) goto L48;
        if (r5 == 3143043) goto L26;
        if (r5 == 3317767) goto L10;
        return;
    L10:
        if (r11.equals(OpenPageMethod.ALIGN_LEFT) == false) goto L91;
        a r13 = this.f6514b;
        if (r13 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("mTabLayout");
        r13 = null;
    L15:
        ViewGroup.LayoutParams r14 = r13.getLayoutParams();
        if (r14 == null) goto L19;
        r14.width = -1;
    L19:
        a r15 = this.f6514b;
        if (r15 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("mTabLayout");
    L23:
        r12.requestLayout();
        return;
    L22:
        r12 = r15;
        goto L23
    L91:
        return;
    L26:
        if (r11.equals("fill") == false) goto L92;
        a r16 = this.f6514b;
        if (r16 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("mTabLayout");
        r16 = null;
    L31:
        r16.setTabMode(1);
        a r17 = this.f6514b;
        if (r17 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("mTabLayout");
        r17 = null;
    L34:
        ViewGroup.LayoutParams r18 = r17.getLayoutParams();
        if (r18 == null) goto L38;
        r18.width = -1;
    L38:
        a r19 = this.f6514b;
        if (r19 != null) goto L41;
        Intrinsics.throwUninitializedPropertyAccessException("mTabLayout");
        r19 = null;
    L41:
        r19.setTabGravity(0);
        a r20 = this.f6514b;
        if (r20 != null) goto L44;
        Intrinsics.throwUninitializedPropertyAccessException("mTabLayout");
    L45:
        r12.requestLayout();
        return;
    L44:
        r12 = r20;
        goto L45
    L92:
        return;
    L48:
        if (r11.equals("center") == false) goto L93;
        a r21 = this.f6514b;
        if (r21 != null) goto L53;
        Intrinsics.throwUninitializedPropertyAccessException("mTabLayout");
        r21 = null;
    L53:
        r21.setTabGravity(1);
        a r22 = this.f6514b;
        if (r22 != null) goto L56;
        Intrinsics.throwUninitializedPropertyAccessException("mTabLayout");
        r22 = null;
    L56:
        ViewGroup.LayoutParams r23 = r22.getLayoutParams();
        if (r23 == null) goto L89;
        r23.width = -1;
    L89:
        Result.Companion r24 = Result.Companion;     // Catch: Throwable -> L63
        a r25 = this.f6514b;     // Catch: Throwable -> L63
        if (r25 != null) goto L65;
        Intrinsics.throwUninitializedPropertyAccessException("mTabLayout");     // Catch: Throwable -> L63
        r25 = null;
    L65:
        Class<? super Object> r26 = r25.getClass().getSuperclass();     // Catch: Throwable -> L63
        if (r26 == null) goto L68;
        Field r27 = r26.getDeclaredField("slidingTabIndicator");     // Catch: Throwable -> L63
    L69:
        if (r27 == null) goto L72;
        r27.setAccessible(true);     // Catch: Throwable -> L63
    L72:
        if (r27 == null) goto L77;
        a r28 = this.f6514b;     // Catch: Throwable -> L63
        if (r28 != null) goto L76;
        Intrinsics.throwUninitializedPropertyAccessException("mTabLayout");     // Catch: Throwable -> L63
        r28 = null;
    L76:
        Object r29 = r27.get(r28);     // Catch: Throwable -> L63
    L78:
        if (r29 == null) goto L81;
        LinearLayout r30 = (LinearLayout) r29;     // Catch: Throwable -> L63
        r30.setGravity(17);     // Catch: Throwable -> L63
        r30.getLayoutParams().width = -2;     // Catch: Throwable -> L63
        Result.m124constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L63
    L83:
        a r31 = this.f6514b;
        if (r31 != null) goto L86;
        Intrinsics.throwUninitializedPropertyAccessException("mTabLayout");
    L87:
        r12.requestLayout();
        return;
    L86:
        r12 = r31;
        goto L87
    L81:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout");     // Catch: Throwable -> L63
    L77:
        r29 = null;
        goto L78
    L68:
        r27 = null;
    L63:
        th = move-exception;
        Result.Companion r32 = Result.Companion;
        Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L83
    }
}
