package com.obric.miniapp.lynx;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.larus.utils.logger.FLogger;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxProp;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.LynxUI;
import com.obric.oui.segmentedtab.OBottomNavActionBar;
import com.obric.oui.segmentedtab.OBottomNavigationBar;
import com.obric.oui.segmentedtab.ONaviIndicatorDrawable;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\b\u0007\u0018\u0000 52\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00015B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0012H\u0014J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0012\u0010\u0017\u001a\u00020\u00142\b\u0010\u0018\u001a\u0004\u0018\u00010\rH\u0007J\u0010\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u001bH\u0007J\b\u0010\u001c\u001a\u00020\u0014H\u0016J\u0010\u0010\u001d\u001a\u00020\u00142\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\u0010\u0010 \u001a\u00020\u00142\u0006\u0010!\u001a\u00020\"H\u0002J\u001a\u0010#\u001a\u00020\u00142\u0006\u0010!\u001a\u00020\"2\b\b\u0002\u0010$\u001a\u00020\u0010H\u0002J\u0010\u0010%\u001a\u00020\u00142\u0006\u0010!\u001a\u00020\"H\u0002J\u0010\u0010&\u001a\u00020\u00142\u0006\u0010'\u001a\u00020\u001fH\u0002J\u001c\u0010(\u001a\u0004\u0018\u00010)2\b\u0010*\u001a\u0004\u0018\u00010)2\u0006\u0010+\u001a\u00020\u0010H\u0002J\u0012\u0010,\u001a\u0004\u0018\u00010-2\u0006\u0010!\u001a\u00020\"H\u0002J\u0010\u0010.\u001a\u00020/2\u0006\u0010!\u001a\u00020\"H\u0002J\u0010\u00100\u001a\u00020\u00142\u0006\u00101\u001a\u00020-H\u0002J\"\u00102\u001a\u00020\u00142\u0006\u00103\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u001b2\b\u00104\u001a\u0004\u0018\u00010\rH\u0002R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00066"}, d2 = {"Lcom/obric/miniapp/lynx/LynxOUIBottomNavigationBarUI;", "Lcom/lynx/tasm/behavior/ui/LynxUI;", "Landroid/widget/FrameLayout;", "context", "Lcom/lynx/tasm/behavior/LynxContext;", "<init>", "(Lcom/lynx/tasm/behavior/LynxContext;)V", "bottomNav", "Lcom/obric/oui/segmentedtab/OBottomNavigationBar;", "optionsJson", "Lorg/json/JSONObject;", "titlesCache", "", "", "itemsSignatureCache", "suppressEvent", "", "createView", "Landroid/content/Context;", "updatePropertiesInterval", "", "props", "Lcom/lynx/tasm/behavior/StylesDiffMap;", "setOptions", "options", "setSelectedIndex", "index", "", "destroy", "clearBottomNavigationSelfClip", "view", "Landroid/view/View;", "ensureBottomNavigationIndicatorTracksLayout", "actionBar", "Lcom/obric/oui/segmentedtab/OBottomNavActionBar;", "requestBottomNavigationIndicatorRecalc", "async", "syncBottomNavigationTabVisualState", "cancelBottomNavigationTabAnimation", "tabView", "resolveBottomNavigationTabTypeface", "Landroid/graphics/Typeface;", "originTypeface", "isSelected", "findBottomNavigationIndicatorDrawable", "Lcom/obric/oui/segmentedtab/ONaviIndicatorDrawable;", "resolveBottomNavigationIndicatorTop", "", "cancelBottomNavigationIndicatorAnimation", "indicatorDrawable", "sendEvent", "type", "title", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LynxOUIBottomNavigationBarUI extends LynxUI<FrameLayout> {
    public static final /* synthetic */ int f = 0;
    public OBottomNavigationBar a;
    public JSONObject b;
    public List<String> c;
    public String d;
    public boolean e;

    public static final class a {
    }

    static {
    }

    public final void destroy() {
        this.a = null;
        this.d = null;
        super.destroy();
    }

    public LynxOUIBottomNavigationBarUI(LynxContext r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.c = CollectionsKt.emptyList();
        if (r2.getDefaultOverflowVisible() == false) goto L6;
        ((LynxBaseUI) this).mOverflow = 3;
        return;
    }

    public static void M(ONaviIndicatorDrawable r7) {
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L5
        Field r2 = ONaviIndicatorDrawable.class.getDeclaredField("positionAnimator");     // Catch: Throwable -> L5
        r2.setAccessible(true);     // Catch: Throwable -> L5
        Object r3 = Result.constructor-impl(r2.get(r7));     // Catch: Throwable -> L5
    L7:
        Object r4 = null;
        if (Result.isFailure-impl(r3) == false) goto L11;
        r3 = null;
    L11:
        if (r3 == null) goto L42;
        Object r5 = Result.constructor-impl(r3.getClass().getMethod("cancelAnimation", new Class[0]).invoke(r3, new Object[0]));     // Catch: Throwable -> L14
    L16:
        Result.box-impl(r5);
    L14:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
    L42:
        Field r8 = ONaviIndicatorDrawable.class.getDeclaredField("sizeAnimator");     // Catch: Throwable -> L19
        r8.setAccessible(true);     // Catch: Throwable -> L19
        Object r9 = Result.constructor-impl(r8.get(r7));     // Catch: Throwable -> L19
    L22:
        if (Result.isFailure-impl(r9) == true) goto L25;
        r4 = r9;
    L25:
        if (r4 != null) goto L38;
    L36:
        Field r10 = ONaviIndicatorDrawable.class.getDeclaredField("isAnimRunning");     // Catch: Throwable -> L33
        r10.setAccessible(true);     // Catch: Throwable -> L33
        r10.setBoolean(r7, false);     // Catch: Throwable -> L33
        Result.constructor-impl(r10);     // Catch: Throwable -> L33
        return;
    L33:
        th = move-exception;
        Result.Companion r0 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        return;
    L38:
        Object r11 = Result.constructor-impl(r4.getClass().getMethod("cancelAnimation", new Class[0]).invoke(r4, new Object[0]));     // Catch: Throwable -> L28
    L30:
        Result.box-impl(r11);
    L28:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        r11 = Result.constructor-impl(ResultKt.createFailure(th));
    L19:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        r9 = Result.constructor-impl(ResultKt.createFailure(th));
    L5:
        th = move-exception;
        Result.Companion r14 = Result.Companion;
        r3 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }

    public static float O(OBottomNavActionBar r5) {
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L5
        Field r2 = OBottomNavActionBar.class.getDeclaredField("indicatorSpacing");     // Catch: Throwable -> L5
        r2.setAccessible(true);     // Catch: Throwable -> L5
        Object r3 = Result.constructor-impl(Float.valueOf(r2.getInt(r5)));     // Catch: Throwable -> L5
    L7:
        Float r4 = Float.valueOf(0.0f);
        if (Result.isFailure-impl(r3) == false) goto L10;
        r3 = r4;
    L10:
        float r6 = ((Number) r3).floatValue();
        Field r7 = OBottomNavActionBar.class.getDeclaredField("mBarStrokeWidth");     // Catch: Throwable -> L13
        r7.setAccessible(true);     // Catch: Throwable -> L13
        Object r8 = Result.constructor-impl(Float.valueOf(r7.getFloat(r5)));     // Catch: Throwable -> L13
    L15:
        Float r0 = Float.valueOf(0.0f);
        if (Result.isFailure-impl(r8) == false) goto L19;
        r8 = r0;
    L19:
        return r6 + ((Number) r8).floatValue();
    L13:
        th = move-exception;
        Result.Companion r9 = Result.Companion;
        r8 = Result.constructor-impl(ResultKt.createFailure(th));
    L5:
        th = move-exception;
        Result.Companion r10 = Result.Companion;
        r3 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }

    public static void P(OBottomNavActionBar r10) {
        int r0 = r10.getCurrentTab();
        Iterator r1 = r10.getTabList().iterator();
        int r3 = 0;
    L4:
        if (r1.hasNext() == false) goto L33;
        Object r4 = r1.next();
        int r5 = r3 + 1;
        if (r3 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        View r6 = (View) r4;
        Result.Companion r7 = Result.Companion;     // Catch: Throwable -> L11
        Result.constructor-impl(r6.getClass().getMethod("cancelAnim", new Class[0]).invoke(r6, new Object[0]));     // Catch: Throwable -> L11
    L13:
        if (r3 != r0) goto L15;
        boolean r8 = true;
    L16:
        if (r8 == false) goto L18;
        int r9 = r10.getTextSelectColor();
    L19:
        r6.setSelected(r8);
        TextView r11 = (TextView) r6.findViewById(2131391548);
        if (r11 == null) goto L29;
        r11.setTextColor(r9);
        Typeface r12 = r11.getTypeface();
        if (r8 == false) goto L28;
        if (r12 == null) goto L28;
        if (Build.VERSION.SDK_INT < 28) goto L28;
        r12 = Typeface.create(r12, 500, false);
    L28:
        r11.setTypeface(r12);
    L29:
        ImageView r13 = (ImageView) r6.findViewById(2131391546);
        if (r13 == null) goto L32;
        r13.setImageTintList(ColorStateList.valueOf(r9));
        r13.setImageAlpha(255);
    L32:
        r3 = r5;
        goto L4
    L18:
        r9 = r10.getTextUnselectColor();
        goto L19
    L15:
        r8 = false;
    L11:
        th = move-exception;
        Result.Companion r14 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L13
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.obric.miniapp.lynx.s1] */
    public final void N(final OBottomNavActionBar r3) {
        final ?? r0 = new s1(this, r3);
        r3.post(new t1(r0));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v1, types: [android.view.ViewTreeObserver$OnPreDrawListener, com.obric.miniapp.lynx.r1] */
    public final View createView(Context r6) {
        Intrinsics.checkNotNullParameter(r6, "context");
        i4 r0 = new i4(r6);
        r0.setClipChildren(false);
        r0.setClipToPadding(false);
        OBottomNavigationBar r7 = LayoutInflater.from(r6).inflate(2131563660, null, false);
        Intrinsics.checkNotNull(r7, "null cannot be cast to non-null type com.obric.oui.segmentedtab.OBottomNavigationBar");
        OBottomNavigationBar r8 = r7;
        r8.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        r8.setChangeAlphaWhenPress(false);
        r8.setChangeAlphaWhenDisable(false);
        r8.setDuplicateParentStateEnabled(false);
        r8.setClipChildren(false);
        r8.setClipToPadding(false);
        final OBottomNavActionBar r2 = r8.getNavigationBar();
        r2.setClipChildren(false);
        r2.setClipToPadding(false);
        r2.setOnTabSelectListener(new u1(this, r2));
        final Ref.ObjectRef r3 = new Ref.ObjectRef();
        r2.addOnLayoutChangeListener(new q1(this, r2));
        ?? r4 = new r1(r2, r3, this);
        r2.addOnAttachStateChangeListener(new v1(r2, r4));
        if (r2.isAttachedToWindow() == true) goto L5;
    L7:
        r8.setClipChildren(false);
        r8.setClipToPadding(false);
        r8.setClipToOutline(false);
        this.a = r8;
        r0.addView(r8);
        return r0;
    L5:
        if (r2.getViewTreeObserver().isAlive() == false) goto L7;
        r2.getViewTreeObserver().addOnPreDrawListener(r4);
        goto L7
    }

    @LynxProp(name = "options")
    public final void setOptions(String r17) {
        JSONObject r0 = o1.G(r17);
        this.b = r0;
        OBottomNavigationBar r2 = this.a;
        if (r2 != null) goto L5;
        return;
    L5:
        if (r0 != null) goto L7;
        return;
    L7:
        JSONArray r3 = r0.optJSONArray("items");
        if (r3 != null) goto L15;
        r3 = r0.optJSONArray("tabs");
        if (r3 != null) goto L15;
        r3 = r0.optJSONArray("list");
        if (r3 != null) goto L15;
        r3 = new JSONArray();
    L15:
        if (r3.length() > 0) goto L18;
        this.c = CollectionsKt.emptyList();
        this.d = null;
        return;
    L18:
        String r4 = r3.toString();
        boolean r6 = !Intrinsics.areEqual(r4, this.d);
        ArrayList r8 = new ArrayList(r3.length());
        if (r6 == false) goto L21;
        ArrayList r9 = new ArrayList(r3.length());
    L22:
        int r10 = r3.length();
        int r12 = 0;
        boolean r13 = false;
    L23:
        if (r12 >= r10) goto L47;
        JSONObject r14 = r3.optJSONObject(r12);
        if (r14 == null) goto L28;
        String r5 = o1.C(r14, new String[]{"title", "label", "text", "name"});
        if (r5 == null) goto L28;
    L34:
        r8.add(r5);
        if (r6 == false) goto L46;
        Context r7 = r2.getContext();
        if (r14 != null) goto L39;
        r14 = new JSONObject();
    L39:
        Object r11 = o1.N(r7, r14);
        if (r11 == null) goto L42;
        r13 = true;
    L42:
        if (r9 == null) goto L46;
        if (r11 != null) goto L45;
        r11 = new ColorDrawable(0);
    L45:
        r9.add(r11);
    L46:
        r12 = r12 + 1;
    L28:
        r5 = r3.optString(r12);
        Intrinsics.checkNotNull(r5);
        if ((!StringsKt.isBlank(r5)) == true) goto L32;
        r5 = null;
    L32:
        if (r5 != null) goto L34;
        r5 = "";
        goto L34
    L47:
        this.e = true;
        Result.Companion r15 = Result.Companion;     // Catch: Throwable -> L63
        if (r6 == false) goto L56;
        OBottomNavActionBar r16 = r2.getNavigationBar();     // Catch: Throwable -> L63
        String[] r18 = (String[]) r8.toArray(new String[0]);     // Catch: Throwable -> L63
        if (r13 == false) goto L54;
        if (r9 == null) goto L54;
        Drawable[] r19 = (Drawable[]) r9.toArray(new Drawable[0]);     // Catch: Throwable -> L63
    L55:
        r16.h(r18, r19);     // Catch: Throwable -> L63
    L54:
        r19 = null;
    L56:
        int r1 = RangesKt.coerceIn(r0.optInt("selectedIndex", 0), 0, RangesKt.coerceAtLeast(r8.size() - 1, 0));     // Catch: Throwable -> L63
        if (r6 == false) goto L59;
    L60:
        r2.getNavigationBar().setCurrentTab(r1);     // Catch: Throwable -> L63
    L61:
        N(r2.getNavigationBar());     // Catch: Throwable -> L63
        Object r20 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L63
    L65:
        Throwable r21 = Result.exceptionOrNull-impl(r20);
        if (r21 == null) goto L68;
        FLogger.a.e("LynxOUIBottomNavigationBarUI", "setOptions failed", r21);
    L68:
        this.e = false;
        this.c = r8;
        this.d = r4;
        return;
    L59:
        if (r2.getNavigationBar().getCurrentTab() == r1) goto L61;
    L63:
        th = move-exception;
        Result.Companion r22 = Result.Companion;
        r20 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L65
    L21:
        r9 = null;
        goto L22
    }

    @LynxProp(name = "selectedIndex")
    public final void setSelectedIndex(int r3) {
        OBottomNavigationBar r0 = this.a;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r3 >= 0) goto L7;
        return;
    L7:
        if (r3 >= this.c.size()) goto L19;
        this.e = true;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L12
        r0.getNavigationBar().setCurrentTab(r3);     // Catch: Throwable -> L12
        N(r0.getNavigationBar());     // Catch: Throwable -> L12
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L12
    L14:
        this.e = false;
        return;
    L12:
        th = move-exception;
        Result.Companion r2 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L14
    }

    public final void updatePropertiesInterval(com.lynx.tasm.behavior.x0 r6) {
        Intrinsics.checkNotNullParameter(r6, "props");
        super/*com.lynx.tasm.behavior.ui.LynxBaseUI*/.updatePropertiesInterval(o1.S(r6, this.b, new String[]{"items", "tabs", "list", "selectedIndex"}, new String[]{"items", "tabs", "list"}, 2));
    }
}
