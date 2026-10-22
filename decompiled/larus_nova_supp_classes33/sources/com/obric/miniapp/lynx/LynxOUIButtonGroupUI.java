package com.obric.miniapp.lynx;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.utils.logger.FLogger;
import com.lynx.tasm.EventEmitter;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxProp;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.LynxUI;
import com.obric.oui.button.OButtonGroup;
import com.obric.oui.segmentedtab.OTabSegmentedLayout;
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
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 :2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001:B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010 \u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020!H\u0014J\u0010\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%H\u0016J\u0012\u0010&\u001a\u00020#2\b\u0010'\u001a\u0004\u0018\u00010\u0010H\u0007J\u0010\u0010(\u001a\u00020#2\u0006\u0010)\u001a\u00020\u0012H\u0007J\b\u0010*\u001a\u00020#H\u0016J\u0010\u0010+\u001a\u00020#2\u0006\u0010,\u001a\u00020\rH\u0002J\b\u0010-\u001a\u00020#H\u0002J\u0010\u0010.\u001a\u00020#2\u0006\u0010/\u001a\u00020\u000bH\u0002J(\u00100\u001a\u0002012\u0006\u0010\u0003\u001a\u00020!2\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u0002052\u0006\u0010)\u001a\u00020\u0012H\u0002J\"\u00106\u001a\u00020#2\u0006\u00107\u001a\u00020\u00102\u0006\u0010)\u001a\u00020\u00122\b\u00108\u001a\u0004\u0018\u00010\u0010H\u0002J\u0010\u00109\u001a\u00020#2\u0006\u0010,\u001a\u00020\rH\u0002J\b\u00109\u001a\u00020#H\u0002R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0002X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0014R\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0014R\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0014R\u0012\u0010\u001b\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0014R\u000e\u0010\u001c\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006;"}, d2 = {"Lcom/obric/miniapp/lynx/LynxOUIButtonGroupUI;", "Lcom/lynx/tasm/behavior/ui/LynxUI;", "Landroid/widget/FrameLayout;", "context", "Lcom/lynx/tasm/behavior/LynxContext;", "<init>", "(Lcom/lynx/tasm/behavior/LynxContext;)V", "rootView", "segmentedView", "Lcom/obric/oui/segmentedtab/OTabSegmentedLayout;", "actionGroupView", "Lcom/obric/oui/button/OButtonGroup;", "optionsJson", "Lorg/json/JSONObject;", "titlesCache", "", "", "selectedIndex", "", "defaultBarColor", "Ljava/lang/Integer;", "defaultIndicatorColor", "defaultSelectedTextColor", "defaultUnselectedTextColor", "barColorOverride", "indicatorColorOverride", "selectedTextColorOverride", "unselectedTextColorOverride", "originalIndicatorColor", "originalSelectedTextColor", "suppressEvent", "", "createView", "Landroid/content/Context;", "updatePropertiesInterval", "", "props", "Lcom/lynx/tasm/behavior/StylesDiffMap;", "setOptions", "options", "setSelectedIndex", "index", "destroy", "renderActionButtonGroup", "json", "attachSegmentedView", "attachActionGroupView", "group", "createActionGroupItemView", "Landroid/view/View;", "groupAppearance", "Lcom/obric/miniapp/lynx/MiniAppButtonAppearance;", "item", "Lcom/obric/miniapp/lynx/MiniAppButtonGroupItem;", "sendEvent", "type", "title", "applyButtonGroupAppearance", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LynxOUIButtonGroupUI extends LynxUI<FrameLayout> {
    public static final /* synthetic */ int q = 0;
    public FrameLayout a;
    public OTabSegmentedLayout b;
    public JSONObject c;
    public List<String> d;
    public int e;
    public Integer f;
    public int g;
    public int h;
    public int i;
    public Integer j;
    public Integer k;
    public Integer l;
    public Integer m;
    public int n;
    public int o;
    public boolean p;

    public static final class a {
    }

    static {
    }

    public final void destroy() {
        this.a = null;
        this.b = null;
        super.destroy();
    }

    public LynxOUIButtonGroupUI(LynxContext r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.d = CollectionsKt.emptyList();
        if (r2.getDefaultOverflowVisible() == false) goto L6;
        ((LynxBaseUI) this).mOverflow = 3;
        return;
    }

    public final View createView(Context r6) {
        Intrinsics.checkNotNullParameter(r6, "context");
        FrameLayout r0 = new FrameLayout(r6);
        r0.setMinimumHeight(o1.t(r6, 52));
        r0.setClipChildren(false);
        r0.setClipToPadding(false);
        Object r4 = null;
        OTabSegmentedLayout r2 = LayoutInflater.from(r6).inflate(2131563663, null, false);
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.obric.oui.segmentedtab.OTabSegmentedLayout");
        OTabSegmentedLayout r3 = r2;
        r3.setClipChildren(false);
        r3.setClipToPadding(false);
        r3.setOnTabSelectListener(new y1(this));
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L5
        Field r5 = OTabSegmentedLayout.class.getDeclaredField("mBarColor");     // Catch: Throwable -> L5
        r5.setAccessible(true);     // Catch: Throwable -> L5
        Object r7 = Result.constructor-impl(Integer.valueOf(r5.getInt(r3)));     // Catch: Throwable -> L5
    L8:
        if (Result.isFailure-impl(r7) == true) goto L11;
        r4 = r7;
    L11:
        this.f = (Integer) r4;
        this.g = r3.getIndicatorColor();
        this.n = r3.getIndicatorColor();
        this.h = r3.getTextSelectColor();
        this.o = r3.getTextSelectColor();
        this.i = r3.getTextUnselectColor();
        this.a = r0;
        this.b = r3;
        FrameLayout.LayoutParams r8 = new FrameLayout.LayoutParams(-1, o1.t(r6, 44));
        r8.gravity = 17;
        Unit r9 = Unit.INSTANCE;
        r0.addView(r3, r8);
        return r0;
    L5:
        th = move-exception;
        Result.Companion r10 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v67, types: [android.widget.FrameLayout] */
    /* JADX WARN: Type inference failed for: r15v2, types: [android.view.View, android.widget.Button, com.obric.oui.button.OButton] */
    /* JADX WARN: Type inference failed for: r15v3, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r15v4, types: [android.widget.ImageView, androidx.appcompat.widget.AppCompatImageView, com.obric.oui.button.OIconButton] */
    /* JADX WARN: Type inference failed for: r6v18 */
    /* JADX WARN: Type inference failed for: r6v7 */
    /* JADX WARN: Type inference failed for: r6v8, types: [android.view.ViewGroup] */
    /* JADX WARN: Type inference failed for: r8v5, types: [android.view.View, android.widget.FrameLayout, com.obric.oui.button.OButtonGroup] */
    @LynxProp(name = "options")
    public final void setOptions(String r22) {
        JSONObject r2 = o1.G(r22);
        this.c = r2;
        OTabSegmentedLayout r3 = this.b;
        if (r3 != null) goto L5;
        return;
    L5:
        if (r2 != null) goto L7;
        return;
    L7:
        boolean r4 = true;
        Object r6 = null;
        if (r2.optBoolean("selectable", true) == true) goto L68;
        FrameLayout r0 = this.a;
        if (r0 == null) goto L158;
        List r5 = o1.h(r0.getContext(), r2);
        List r9 = r5;
        ArrayList r10 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r9, 10));
        Iterator r8 = r9.iterator();
    L14:
        if (r8.hasNext() == false) goto L16;
        r10.add(((r4) r8.next()).a);
        goto L14
    L16:
        this.d = r10;
        r0.removeAllViews();
        if (r5.isEmpty() == true) goto L159;
        ?? r11 = new OButtonGroup(r0.getContext(), null, 0, 14);
        q4 r7 = o1.g(r2, r0.getContext());
        Iterator r12 = r5.iterator();
        final int r13 = 0;
    L21:
        if (r12.hasNext() == false) goto L57;
        Object r14 = r12.next();
        int r15 = r13 + 1;
        if (r13 >= 0) goto L25;
        CollectionsKt.throwIndexOverflow();
    L25:
        final r4 r16 = (r4) r14;
        Context r17 = r0.getContext();
        q4 r18 = o1.e(r7, o1.g(r16.e, r17));
        if (StringsKt.isBlank(r16.a) == false) goto L37;
        ?? r19 = o1.c(r17, r18);
        Drawable r20 = o1.q(r19.getBackground());
        ColorStateList r110 = r19.getImageTintList();
        Integer r21 = o1.k(r18, r16.d, o1.K(r18, r16.d, ColorProtector.parseColor("#1F2329")));
        r19.setImageDrawable(o1.q(r16.b));
        boolean r111 = r16.d;
        Float r23 = r18.b;
        if (r23 == null) goto L30;
        float r24 = r23.floatValue();
    L31:
        r19.setBackground(o1.j(r17, r18, r111, r20, r24));
        if (r21 == null) goto L35;
        ColorStateList r25 = ColorStateList.valueOf(r21.intValue());
        if (r25 == null) goto L35;
    L36:
        r19.setImageTintList(r25);
        o1.b(r19, r18);
        r19.setEnabled(r16.d ^ r4);
        r19.setOnClickListener(new w1(this, r13));
        Object r26 = null;
    L56:
        r11.D(r19, new ViewGroup.MarginLayoutParams(-2, -2));
        r6 = r26;
        r13 = r15;
        r0 = r0;
        r7 = r7;
        r4 = true;
    L35:
        r25 = r110;
        goto L36
    L30:
        r24 = 12.0f;
        goto L31
    L37:
        r19 = o1.d(r17);
        Drawable r27 = o1.q(r19.getBackground());
        ColorStateList r28 = r19.getTextColors();
        int r29 = o1.K(r18, r16.d, r19.getCurrentTextColor());
        Integer r112 = o1.k(r18, r16.d, r29);
        Drawable r30 = o1.n(r16.b, r112);
        Drawable r1 = o1.n(r16.c, r112);
        r19.setText(r16.a);
        r26 = null;
        r19.setCompoundDrawablesRelativeWithIntrinsicBounds(r30, null, r1, null);
        if (r30 != null) goto L42;
        if (r1 != null) goto L42;
        int r31 = 0;
    L43:
        r19.setCompoundDrawablePadding(r31);
        if (r112 == null) goto L46;
        ColorStateList r32 = ColorStateList.valueOf(r112.intValue());
    L47:
        r19.setCompoundDrawableTintList(r32);
        boolean r33 = r16.d;
        Float r34 = r18.b;
        if (r34 == null) goto L50;
        float r35 = r34.floatValue();
    L51:
        r19.setBackground(o1.j(r17, r18, r33, r27, r35));
        o1.p(r19, r18);
        if (o1.v(r18) == false) goto L54;
        r19.setTextColor(r29);
    L55:
        r19.setEnabled(!r16.d);
        r19.setOnClickListener(new x1(this, r13, r16));
        goto L56
    L54:
        r19.setTextColor(r28);
        goto L55
    L50:
        r35 = 12.0f;
        goto L51
    L46:
        r32 = null;
    L42:
        r31 = o1.t(r17, 6);
        goto L43
    L57:
        Object r36 = r6;
        ?? r37 = this.a;
        if (r37 == 0) goto L160;
        ViewParent r38 = r11.getParent();
        if ((r38 instanceof ViewGroup) == false) goto L63;
        ?? r39 = (ViewGroup) r38;
    L64:
        if (r39 == 0) goto L66;
        r39.removeView(r11);
    L66:
        r37.removeAllViews();
        FrameLayout.LayoutParams r40 = new FrameLayout.LayoutParams(-2, -2);
        r40.gravity = 17;
        Unit r41 = Unit.INSTANCE;
        r37.addView(r11, r40);
        return;
    L63:
        r39 = r36;
        goto L64
    L160:
        return;
    L159:
        return;
    L158:
        return;
    L68:
        FrameLayout r42 = this.a;
        if (r42 == null) goto L81;
        OTabSegmentedLayout r43 = this.b;
        if (r43 == null) goto L81;
        ViewParent r44 = r43.getParent();
        if ((r44 instanceof ViewGroup) == false) goto L77;
        ViewGroup r45 = (ViewGroup) r44;
    L78:
        if (r45 == null) goto L80;
        r45.removeView(r43);
    L80:
        r42.removeAllViews();
        FrameLayout.LayoutParams r46 = new FrameLayout.LayoutParams(-1, o1.t(r42.getContext(), 44));
        r46.gravity = 17;
        Unit r47 = Unit.INSTANCE;
        r42.addView(r43, r46);
        r43.setVisibility(0);
        goto L81
    L77:
        r45 = null;
    L81:
        OTabSegmentedLayout r48 = this.b;
        if (r48 == null) goto L84;
        Context r49 = r48.getContext();
    L85:
        this.j = o1.E(o1.D(r2, new String[]{"barColor", "backgroundColor", "bar_color", "background_color"}), r49);
        this.k = o1.E(o1.D(r2, new String[]{"indicatorColor", "selectedBackgroundColor", "indicator_color", "selected_background_color"}), r49);
        this.l = o1.E(o1.D(r2, new String[]{"textSelectColor", "selectedTextColor", "text_select_color", "selected_text_color"}), r49);
        this.m = o1.E(o1.D(r2, new String[]{"textUnselectColor", "unselectedTextColor", "text_unselect_color", "unselected_text_color"}), r49);
        OTabSegmentedLayout r50 = this.b;
        if (r50 == null) goto L121;
        Integer r51 = this.j;
        if (r51 != null) goto L91;
        r51 = this.f;
    L91:
        if (r51 == null) goto L101;
        int r52 = r51.intValue();
        Result.Companion r53 = Result.Companion;     // Catch: Throwable -> L95
        Field r54 = OTabSegmentedLayout.class.getDeclaredField("mBarColor");     // Catch: Throwable -> L95
        r54.setAccessible(true);     // Catch: Throwable -> L95
        r54.setInt(r50, r52);     // Catch: Throwable -> L95
        r50.invalidate();     // Catch: Throwable -> L95
        Object r55 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L95
    L97:
        Throwable r56 = Result.exceptionOrNull-impl(r55);
        if (r56 == null) goto L101;
        FLogger.a.e("LynxOUIButtonGroupUI", "set segmented bar color failed", r56);
    L95:
        th = move-exception;
        Result.Companion r57 = Result.Companion;
        r55 = Result.constructor-impl(ResultKt.createFailure(th));
    L101:
        if (this.e != (-1)) goto L107;
        r50.setIndicatorColor(0);
        Integer r58 = this.m;
        if (r58 == null) goto L105;
        int r59 = r58.intValue();
    L106:
        r50.setTextSelectColor(r59);
    L116:
        Integer r60 = this.m;
        if (r60 == null) goto L119;
        int r61 = r60.intValue();
    L120:
        r50.setTextUnselectColor(r61);
        goto L121
    L119:
        r61 = this.i;
        goto L120
    L105:
        r59 = this.i;
        goto L106
    L107:
        Integer r62 = this.k;
        if (r62 == null) goto L110;
        int r63 = r62.intValue();
    L111:
        r50.setIndicatorColor(r63);
        Integer r64 = this.l;
        if (r64 == null) goto L114;
        int r65 = r64.intValue();
    L115:
        r50.setTextSelectColor(r65);
        goto L116
    L114:
        r65 = this.h;
        goto L115
    L110:
        r63 = this.g;
    L121:
        List r66 = o1.h(r3.getContext(), r2);
        List r67 = r66;
        ArrayList r68 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r67, 10));
        Iterator r69 = r67.iterator();
    L123:
        if (r69.hasNext() == false) goto L126;
        r68.add(((r4) r69.next()).a);
        goto L123
    L126:
        if (r68.isEmpty() == false) goto L129;
        this.d = CollectionsKt.emptyList();
        r3.setVisibility(8);
        return;
    L129:
        this.d = r68;
        r3.setVisibility(0);
        this.p = true;
        Result.Companion r70 = Result.Companion;     // Catch: Throwable -> L139
        String[] r71 = (String[]) r68.toArray(new String[0]);     // Catch: Throwable -> L139
        List r72 = r66;     // Catch: Throwable -> L139
        ArrayList r73 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r72, 10));     // Catch: Throwable -> L139
        Iterator r74 = r72.iterator();     // Catch: Throwable -> L139
    L132:
        if (r74.hasNext() == false) goto L137;
        Object r75 = ((r4) r74.next()).b;     // Catch: Throwable -> L139
        if (r75 != null) goto L136;
        r75 = new ColorDrawable(0);     // Catch: Throwable -> L139
    L136:
        r73.add(r75);     // Catch: Throwable -> L139
        goto L132
    L137:
        r3.e(r71, (Drawable[]) r73.toArray(new Drawable[0]));     // Catch: Throwable -> L139
        Object r76 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L139
    L141:
        Throwable r77 = Result.exceptionOrNull-impl(r76);
        if (r77 == null) goto L144;
        FLogger.a.e("LynxOUIButtonGroupUI", "set titles failed", r77);
    L144:
        this.p = false;
        setSelectedIndex(r2.optInt("selectedIndex", this.e));
        return;
    L139:
        th = move-exception;
        Result.Companion r78 = Result.Companion;
        r76 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L141
    L84:
        r49 = null;
        goto L85
    }

    @LynxProp(name = "selectedIndex")
    public final void setSelectedIndex(int r6) {
        OTabSegmentedLayout r0 = this.b;
        if (r0 != null) goto L6;
        return;
    L6:
        if (r6 >= 0) goto L8;
    L9:
        r6 = -1;
    L10:
        this.e = r6;
        this.p = true;
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L31
        if (r6 != (-1)) goto L18;
        r0.setIndicatorColor(0);     // Catch: Throwable -> L31
        r0.setTextSelectColor(r0.getTextUnselectColor());     // Catch: Throwable -> L31
        if ((!this.d.isEmpty()) == true) goto L16;
    L29:
        Object r7 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L31
    L33:
        Throwable r8 = Result.exceptionOrNull-impl(r7);
        if (r8 == null) goto L36;
        FLogger.a.e("LynxOUIButtonGroupUI", "set selected index failed", r8);
    L36:
        this.p = false;
        return;
    L16:
        if (r0.getCurrentTab() >= 0) goto L29;
        r0.setCurrentTab(0);     // Catch: Throwable -> L31
        goto L29
    L18:
        Integer r9 = this.k;     // Catch: Throwable -> L31
        if (r9 == null) goto L21;
        int r10 = r9.intValue();     // Catch: Throwable -> L31
    L22:
        r0.setIndicatorColor(r10);     // Catch: Throwable -> L31
        Integer r11 = this.l;     // Catch: Throwable -> L31
        if (r11 == null) goto L25;
        int r12 = r11.intValue();     // Catch: Throwable -> L31
    L26:
        r0.setTextSelectColor(r12);     // Catch: Throwable -> L31
        int r13 = r0.getCurrentTab();     // Catch: Throwable -> L31
        int r1 = this.e;     // Catch: Throwable -> L31
        if (r13 == r1) goto L29;
        r0.setCurrentTab(r1);     // Catch: Throwable -> L31
        goto L29
    L25:
        r12 = this.o;     // Catch: Throwable -> L31
        goto L26
    L21:
        r10 = this.n;     // Catch: Throwable -> L31
    L31:
        th = move-exception;
        Result.Companion r2 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L33
    L8:
        if (r6 < this.d.size()) goto L10;
        goto L9
    }

    public final void updatePropertiesInterval(com.lynx.tasm.behavior.x0 r14) {
        Intrinsics.checkNotNullParameter(r14, "props");
        super/*com.lynx.tasm.behavior.ui.LynxBaseUI*/.updatePropertiesInterval(o1.S(r14, this.c, new String[]{"titles", "items", "selectedIndex", "selectable", "barColor", "backgroundColor", "indicatorColor", "selectedBackgroundColor", "textSelectColor", "selectedTextColor", "textUnselectColor", "unselectedTextColor"}, new String[]{"titles", "items"}, 2));
    }

    public final void M(int r5, String r6) {
        LynxContext r0 = getLynxContext();
        if (r0 == null) goto L12;
        EventEmitter r1 = r0.getEventEmitter();
        if (r1 == null) goto L13;
        m7a.a r2 = new m7a.a(getSign(), "change");
        r2.a("index", Integer.valueOf(r5));
        r2.a("value", Integer.valueOf(r5));
        if (r6 == null) goto L10;
        r2.a("title", r6);
    L10:
        r1.sendCustomEvent(r2);
        return;
    L13:
        return;
    }
}
