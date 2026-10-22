package com.obric.miniapp.lynx;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.lynx.tasm.EventEmitter;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxProp;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.LynxUI;
import com.obric.oui.button.OButtonGroup;
import com.obric.oui.button.OIconButton;
import com.obric.oui.layout.OUILinearLayout;
import com.obric.oui.text.OTextView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u001dH\u0014J\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0016J\u0012\u0010\"\u001a\u00020\u001f2\b\u0010#\u001a\u0004\u0018\u00010\rH\u0007J\u0012\u0010$\u001a\u00020\u001f2\b\u0010%\u001a\u0004\u0018\u00010\rH\u0007J\u0010\u0010&\u001a\u00020\u001f2\u0006\u0010'\u001a\u00020\u0016H\u0007J\b\u0010(\u001a\u00020\u001fH\u0016J\b\u0010)\u001a\u00020\u001fH\u0016J\u0012\u0010*\u001a\u00020\u001f2\b\u0010+\u001a\u0004\u0018\u00010\u000fH\u0002J\u0012\u0010,\u001a\u00020\u001f2\b\u0010+\u001a\u0004\u0018\u00010\u000fH\u0002J\b\u0010-\u001a\u00020\u001fH\u0002J\b\u0010.\u001a\u00020\u001fH\u0002J\b\u0010/\u001a\u00020\u001fH\u0002J\u0010\u00100\u001a\u00020\u001f2\u0006\u00101\u001a\u00020\u000bH\u0002J\n\u00102\u001a\u0004\u0018\u000103H\u0002J\u0018\u00104\u001a\u00020\u001f2\u0006\u00105\u001a\u00020\r2\u0006\u00106\u001a\u00020\rH\u0002R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0002X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00067"}, d2 = {"Lcom/obric/miniapp/lynx/LynxMiniAppButtonUI;", "Lcom/lynx/tasm/behavior/ui/LynxUI;", "Landroid/widget/FrameLayout;", "context", "Lcom/lynx/tasm/behavior/LynxContext;", "<init>", "(Lcom/lynx/tasm/behavior/LynxContext;)V", "containerView", "textButtonView", "Landroid/view/ViewGroup;", "iconButtonView", "Lcom/obric/oui/button/OIconButton;", "textCache", "", "iconCache", "Landroid/graphics/drawable/Drawable;", "tailIconCache", "optionsJson", "Lorg/json/JSONObject;", "appearance", "Lcom/obric/miniapp/lynx/MiniAppButtonAppearance;", "disabledCache", "", "defaultTextColor", "", "defaultIconButtonBackgroundCache", "defaultIconButtonTintList", "Landroid/content/res/ColorStateList;", "createView", "Landroid/content/Context;", "updatePropertiesInterval", "", "props", "Lcom/lynx/tasm/behavior/StylesDiffMap;", "setOptions", "options", "setText", "v", "setDisabled", "disabled", "onNodeReload", "destroy", "setIcon", "drawable", "setTailIcon", "applyButtonVisuals", "ensureButtonView", "applyTextButtonVisuals", "applyIconButtonVisuals", "view", "currentButtonView", "Landroid/view/View;", "sendEvent", "type", "text", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LynxMiniAppButtonUI extends LynxUI<FrameLayout> {
    public FrameLayout a;
    public OUILinearLayout b;
    public OIconButton c;
    public String d;
    public Drawable e;
    public Drawable f;
    public JSONObject g;
    public q4 h;
    public boolean i;
    public int j;
    public Drawable k;
    public ColorStateList l;

    public final void destroy() {
        this.a = null;
        this.b = null;
        this.c = null;
        this.e = null;
        this.f = null;
        this.k = null;
        this.l = null;
        super.destroy();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v5, types: [android.view.View, android.widget.FrameLayout, com.obric.oui.button.OButtonGroup] */
    /* JADX WARN: Type inference failed for: r9v7, types: [android.view.View, android.widget.ImageView, com.obric.oui.button.OIconButton] */
    public final void M() {
        this.j = o1.l(((LynxBaseUI) this).mContext);
        FrameLayout r1 = this.a;
        if (r1 == 0) goto L36;
        boolean r9 = StringsKt.isBlank(this.d);
        if (r9 == true) goto L8;
    L10:
        if (r9 == false) goto L12;
    L14:
        r1.removeAllViews();
        this.b = null;
        this.c = null;
        Float r10 = this.h.d;
        if (r10 == null) goto L17;
        int r11 = o1.s(r1.getContext(), r10.floatValue());
    L19:
        if (r9 == false) goto L26;
        ?? r12 = o1.c(r1.getContext(), this.h);
        r12.setOnClickListener(new w(this));
        this.k = o1.q(r12.getBackground());
        this.l = r12.getImageTintList();
        this.c = r12;
        r1.setClipChildren(false);
        r1.setClipToPadding(false);
        FrameLayout.LayoutParams r13 = new FrameLayout.LayoutParams(-2, -2);
        r13.gravity = 17;
        r13.setMarginStart(r11);
        r13.leftMargin = r11;
        Unit r14 = Unit.INSTANCE;
        r1.addView(r12, r13);
        ViewParent r2 = r1.getParent();
        if ((r2 instanceof ViewGroup) == false) goto L23;
        ViewGroup r3 = (ViewGroup) r2;
    L24:
        if (r3 == null) goto L36;
        r3.setClipChildren(false);
        r3.setClipToPadding(false);
        goto L36
    L23:
        r3 = null;
        goto L24
    L26:
        Object r15 = LayoutInflater.from(r1.getContext()).inflate(2131564152, null, false);
        Intrinsics.checkNotNull(r15, "null cannot be cast to non-null type com.obric.oui.button.OButtonGroup");
        ?? r16 = (OButtonGroup) r15;
        String r17 = this.d;
        Context r18 = r1.getContext();
        q4 r19 = this.h;
        Float r110 = r19.c;
        if (r110 == null) goto L29;
        float r111 = r110.floatValue();
    L30:
        int r112 = o1.s(r18, r111);
        int r4 = o1.s(r18, 8.0f);
        OUILinearLayout r5 = new OUILinearLayout(r18, null, 0, 14);
        r5.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        r5.setMinimumHeight(MathKt.roundToInt(TypedValue.applyDimension(1, 36, o1.a(Resources.getSystem()))));
        r5.setPadding(r112, 0, r4, 0);
        r5.setClickable(true);
        r5.setRadius(MathKt.roundToInt(TypedValue.applyDimension(1, 99, o1.a(Resources.getSystem()))));
        r5.setOrientation(0);
        r5.setGravity(16);
        o1.p(r5, r19);
        ImageView r6 = new ImageView(r18);
        r6.setId(2131374718);
        r6.setVisibility(8);
        float r113 = 20;
        LinearLayout.LayoutParams r114 = new LinearLayout.LayoutParams(MathKt.roundToInt(TypedValue.applyDimension(1, r113, o1.a(Resources.getSystem()))), MathKt.roundToInt(TypedValue.applyDimension(1, r113, o1.a(Resources.getSystem()))));
        r114.gravity = 16;
        float r7 = 4;
        r114.setMarginEnd(MathKt.roundToInt(TypedValue.applyDimension(1, r7, o1.a(Resources.getSystem()))));
        Unit r115 = Unit.INSTANCE;
        r5.addView(r6, r114);
        OTextView r8 = new OTextView(r18, null, 0, 14);
        r8.setId(2131388772);
        r8.setText(r17);
        r8.setGravity(16);
        r8.setPadding(MathKt.roundToInt(TypedValue.applyDimension(1, r7, o1.a(Resources.getSystem()))), 0, 0, 0);
        r8.setSingleLine(true);
        r8.setMinHeight(MathKt.roundToInt(TypedValue.applyDimension(1, 22, o1.a(Resources.getSystem()))));
        r8.setTextAppearance(2131953751);
        LinearLayout.LayoutParams r116 = new LinearLayout.LayoutParams(-2, -2);
        r116.gravity = 16;
        r5.addView(r8, r116);
        ImageView r20 = new ImageView(r18);
        r20.setId(2131388166);
        r20.setVisibility(8);
        LinearLayout.LayoutParams r117 = new LinearLayout.LayoutParams(MathKt.roundToInt(TypedValue.applyDimension(1, r113, o1.a(Resources.getSystem()))), MathKt.roundToInt(TypedValue.applyDimension(1, r113, o1.a(Resources.getSystem()))));
        r117.gravity = 16;
        r117.setMarginStart(MathKt.roundToInt(TypedValue.applyDimension(1, r7, o1.a(Resources.getSystem()))));
        r5.addView(r20, r117);
        r16.D(r5, new ViewGroup.MarginLayoutParams(-2, -2));
        r16.setOnClickListener(new x(this));
        r16.setVisibility(0);
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type android.view.ViewGroup");
        this.b = r5;
        r1.setClipChildren(false);
        r1.setClipToPadding(false);
        FrameLayout.LayoutParams r21 = new FrameLayout.LayoutParams(-2, -1);
        r21.gravity = 8388611;
        r21.setMarginStart(r11);
        r21.leftMargin = r11;
        r1.addView(r16, r21);
        ViewParent r22 = r1.getParent();
        if ((r22 instanceof ViewGroup) == false) goto L33;
        ViewGroup r23 = (ViewGroup) r22;
    L34:
        if (r23 == null) goto L36;
        r23.setClipChildren(false);
        r23.setClipToPadding(false);
        goto L36
    L33:
        r23 = null;
        goto L34
    L29:
        r111 = 7.0f;
        goto L30
    L17:
        r11 = 0;
        goto L19
    L12:
        if (this.b == null) goto L14;
    L8:
        if (this.c == null) goto L10;
    L36:
        OUILinearLayout r24 = this.b;
        if (r24 == null) goto L74;
        q4 r25 = this.h;
        boolean r26 = this.i;
        int r27 = o1.K(r25, r26, this.j);
        if (o1.v(r25) == true) goto L54;
        Integer r28 = r25.a;
        if (r28 == null) goto L45;
        boolean r29 = o1.x(r28.intValue());
    L46:
        if (r29 == false) goto L54;
        if (o1.x(r27) == false) goto L54;
        int r30 = Color.rgb(31, 35, 41);
        if (r26 == false) goto L53;
        r30 = o1.R(r30);
    L53:
        r27 = r30;
        goto L54
    L45:
        r29 = false;
    L54:
        TextView r31 = (TextView) r24.findViewById(2131388772);
        if (r31 == null) goto L57;
        r31.setText(this.d);
        r31.setTextColor(r27);
    L57:
        ImageView r32 = (ImageView) r24.findViewById(2131374718);
        if (r32 != null) goto L60;
    L63:
        ImageView r33 = (ImageView) r24.findViewById(2131388166);
        if (r33 != null) goto L66;
    L69:
        r24.setEnabled(!this.i);
        if (this.i == false) goto L72;
        float r34 = 0.48f;
    L73:
        r24.setAlpha(r34);
        o1.p(r24, this.h);
        goto L74
    L72:
        r34 = 1.0f;
        goto L73
    L66:
        if (this.f == null) goto L68;
        r33.setVisibility(0);
        r33.setImageDrawable(this.f);
        r33.setColorFilter(r27);
        goto L69
    L68:
        r33.setVisibility(8);
        r33.setImageDrawable(null);
        goto L69
    L60:
        if (this.e == null) goto L62;
        r32.setVisibility(0);
        r32.setImageDrawable(this.e);
        r32.setColorFilter(r27);
        goto L63
    L62:
        r32.setVisibility(8);
        r32.setImageDrawable(null);
    L74:
        OIconButton r35 = this.c;
        if (r35 == null) goto L78;
        N(r35);
        return;
    }

    public final void onNodeReload() {
        super/*com.lynx.tasm.behavior.ui.LynxBaseUI*/.onNodeReload();
        this.b = null;
        this.c = null;
        this.k = null;
        this.l = null;
        FrameLayout r0 = this.a;
        if (r0 == null) goto L5;
        r0.removeAllViews();
    L5:
        M();
    }

    public LynxMiniAppButtonUI(LynxContext r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3);
        this.d = "00/00";
        this.h = new q4(0);
        this.j = o1.l(((LynxBaseUI) this).mContext);
        if (r3.getDefaultOverflowVisible() == false) goto L6;
        ((LynxBaseUI) this).mOverflow = 3;
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void N(OIconButton r6) {
        r6.setEnabled(!this.i);
        Drawable r0 = this.e;
        if (r0 != null) goto L5;
        r0 = this.f;
    L5:
        r6.setImageDrawable(o1.q(r0));
        Context r1 = r6.getContext();
        q4 r2 = this.h;
        boolean r3 = this.i;
        Drawable r4 = this.k;
        Float r5 = r2.b;
        if (r5 == null) goto L8;
        float r7 = r5.floatValue();
    L9:
        r6.setBackground(o1.j(r1, r2, r3, r4, r7));
        Integer r8 = o1.k(this.h, this.i, o1.K(this.h, this.i, this.j));
        if (r8 == null) goto L13;
        ColorStateList r9 = ColorStateList.valueOf(r8.intValue());
        if (r9 == null) goto L13;
    L14:
        r6.setImageTintList(r9);
        o1.b(r6, this.h);
        return;
    L13:
        r9 = this.l;
        goto L14
    L8:
        r7 = 12.0f;
        goto L9
    }

    public final View createView(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        FrameLayout r0 = new FrameLayout(r3);
        r0.setMinimumHeight(o1.t(r3, 40));
        r0.addOnLayoutChangeListener(new u(this));
        r0.setOnClickListener(new v(this));
        this.a = r0;
        return r0;
    }

    @LynxProp(name = "disabled")
    public final void setDisabled(boolean r2) {
        this.i = r2;
        FrameLayout r0 = this.a;
        if (r0 == null) goto L5;
        r0.setEnabled(!r2);
    L5:
        M();
    }

    @LynxProp(name = "options")
    public final void setOptions(String r5) {
        JSONObject r6 = o1.G(r5);
        this.g = r6;
        if (r6 != null) goto L5;
        r6 = new JSONObject();
    L5:
        this.h = o1.g(r6, ((LynxBaseUI) this).mContext);
        setText(o1.C(r6, new String[]{"text", "label", "title"}));
        this.e = o1.N(((LynxBaseUI) this).mContext, r6);
        M();
        this.f = o1.O(((LynxBaseUI) this).mContext, r6, new String[]{"tailIcon"}, new String[]{"tailIconResId"}, new String[]{"tailIconResName"});
        M();
        if (r6.has("disabled") == false) goto L8;
        setDisabled(r6.optBoolean("disabled", false));
        return;
    L8:
        M();
    }

    @LynxProp(name = "text")
    public final void setText(String r1) {
        if (r1 != null) goto L4;
        r1 = "";
    L4:
        this.d = r1;
        M();
    }

    public final void updatePropertiesInterval(com.lynx.tasm.behavior.x0 r36) {
        Intrinsics.checkNotNullParameter(r36, "props");
        super/*com.lynx.tasm.behavior.ui.LynxBaseUI*/.updatePropertiesInterval(o1.S(r36, this.g, new String[]{"text", "label", "title", "disabled", "icon", "iconResName", "iconResId", "tailIcon", "tailIconResName", "tailIconResId", "backgroundColor", "radiusDp", "cornerRadius", "borderRadius", "textColor", "borderColor", "borderWidth", "iconTint", "disabledBackgroundColor", "disabledTextColor", "disabledBorderColor", "paddingLeftDp", "paddingStartDp", "marginLeftDp", "marginStartDp", "buttonSize", "buttonSizeDp", "iconSize", "iconSizeDp", "disablePressEffect", "disableGreyInteraction", "disableGrayInteraction"}, new String[]{"icon", "tailIcon"}, 2));
    }

    public final void O(String r4, String r5) {
        LynxContext r0 = getLynxContext();
        if (r0 == null) goto L9;
        EventEmitter r1 = r0.getEventEmitter();
        if (r1 == null) goto L10;
        m7a.a r2 = new m7a.a(getSign(), r4);
        r2.a("text", r5);
        r2.a("value", r5);
        r1.sendCustomEvent(r2);
        return;
    L10:
        return;
    }
}
