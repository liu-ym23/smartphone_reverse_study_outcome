package com.obric.miniapp.lynx;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.lynx.tasm.EventEmitter;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxProp;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.LynxUI;
import com.obric.oui.button.OButton;
import com.obric.oui.button.OIconButton;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u001fH\u0014J\u0010\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0016J\u0012\u0010$\u001a\u00020!2\b\u0010%\u001a\u0004\u0018\u00010\rH\u0007J\u0012\u0010&\u001a\u00020!2\b\u0010'\u001a\u0004\u0018\u00010\rH\u0007J\u0010\u0010(\u001a\u00020!2\u0006\u0010)\u001a\u00020\u0016H\u0007J\b\u0010*\u001a\u00020!H\u0016J\u0012\u0010+\u001a\u00020!2\b\u0010,\u001a\u0004\u0018\u00010\u000fH\u0002J\u0012\u0010-\u001a\u00020!2\b\u0010,\u001a\u0004\u0018\u00010\u000fH\u0002J\b\u0010.\u001a\u00020!H\u0002J\b\u0010/\u001a\u00020!H\u0002J\u0010\u00100\u001a\u00020!2\u0006\u00101\u001a\u00020\tH\u0002J\u0018\u00102\u001a\u00020!2\u0006\u00101\u001a\u00020\t2\u0006\u00103\u001a\u00020\u001bH\u0002J\u0010\u00104\u001a\u00020!2\u0006\u00101\u001a\u00020\u000bH\u0002J\n\u00105\u001a\u0004\u0018\u000106H\u0002J\u0018\u00107\u001a\u00020!2\u0006\u00108\u001a\u00020\r2\u0006\u00109\u001a\u00020\rH\u0002R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0002X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006:"}, d2 = {"Lcom/obric/miniapp/lynx/LynxOUIButtonUI;", "Lcom/lynx/tasm/behavior/ui/LynxUI;", "Landroid/widget/FrameLayout;", "context", "Lcom/lynx/tasm/behavior/LynxContext;", "<init>", "(Lcom/lynx/tasm/behavior/LynxContext;)V", "containerView", "textButtonView", "Lcom/obric/oui/button/OButton;", "iconButtonView", "Lcom/obric/oui/button/OIconButton;", "textCache", "", "iconCache", "Landroid/graphics/drawable/Drawable;", "tailIconCache", "optionsJson", "Lorg/json/JSONObject;", "appearance", "Lcom/obric/miniapp/lynx/MiniAppButtonAppearance;", "disabledCache", "", "defaultBackgroundCache", "defaultTextColors", "Landroid/content/res/ColorStateList;", "defaultTextColor", "", "defaultIconButtonBackgroundCache", "defaultIconButtonTintList", "createView", "Landroid/content/Context;", "updatePropertiesInterval", "", "props", "Lcom/lynx/tasm/behavior/StylesDiffMap;", "setOptions", "options", "setText", "v", "setDisabled", "disabled", "destroy", "setIcon", "drawable", "setTailIcon", "applyButtonVisuals", "ensureButtonView", "applyTextButtonVisuals", "view", "applyTextButtonIcon", "resolvedTextColor", "applyIconButtonVisuals", "currentButtonView", "Landroid/view/View;", "sendEvent", "type", "text", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LynxOUIButtonUI extends LynxUI<FrameLayout> {
    public FrameLayout a;
    public OButton b;
    public OIconButton c;
    public String d;
    public Drawable e;
    public Drawable f;
    public JSONObject g;
    public q4 h;
    public boolean i;
    public Drawable j;
    public ColorStateList k;
    public int l;
    public Drawable m;
    public ColorStateList n;

    public final void destroy() {
        this.a = null;
        this.b = null;
        this.c = null;
        this.f = null;
        super.destroy();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v11, types: [android.view.View, android.widget.ImageView, com.obric.oui.button.OIconButton] */
    public final void M() {
        FrameLayout r0 = this.a;
        ColorStateList r1 = null;
        if (r0 == 0) goto L18;
        boolean r2 = StringsKt.isBlank(this.d);
        if (r2 == true) goto L8;
    L10:
        if (r2 == false) goto L12;
    L14:
        r0.removeAllViews();
        this.b = null;
        this.c = null;
        if (r2 == false) goto L17;
        ?? r3 = o1.c(r0.getContext(), this.h);
        r3.setOnClickListener(new z1(this));
        this.m = o1.q(r3.getBackground());
        this.n = r3.getImageTintList();
        this.c = r3;
        FrameLayout.LayoutParams r5 = new FrameLayout.LayoutParams(-2, -2);
        r5.gravity = 17;
        Unit r4 = Unit.INSTANCE;
        r0.addView(r3, r5);
        goto L18
    L17:
        OButton r6 = o1.d(r0.getContext());
        r6.setOnClickListener(new a2(this));
        this.j = o1.q(r6.getBackground());
        this.k = r6.getTextColors();
        this.l = r6.getCurrentTextColor();
        this.b = r6;
        FrameLayout.LayoutParams r7 = new FrameLayout.LayoutParams(-2, -1);
        r7.gravity = 17;
        Unit r8 = Unit.INSTANCE;
        r0.addView(r6, r7);
        goto L18
    L12:
        if (this.b == null) goto L14;
    L8:
        if (this.c == null) goto L10;
    L18:
        OButton r9 = this.b;
        if (r9 == null) goto L41;
        r9.setText(this.d);
        r9.setEnabled(!this.i);
        int r10 = o1.K(this.h, this.i, this.l);
        Context r11 = r9.getContext();
        q4 r12 = this.h;
        boolean r13 = this.i;
        Drawable r14 = this.j;
        Float r15 = r12.b;
        if (r15 == null) goto L23;
        float r16 = r15.floatValue();
    L24:
        r9.setBackground(o1.j(r11, r12, r13, r14, r16));
        o1.p(r9, this.h);
        if (o1.v(this.h) == false) goto L27;
        r9.setTextColor(r10);
    L31:
        Integer r17 = o1.k(this.h, this.i, r10);
        Drawable r18 = o1.n(this.e, r17);
        Drawable r19 = o1.n(this.f, r17);
        r9.setMIcon(null);
        r9.setCompoundDrawablesRelativeWithIntrinsicBounds(r18, null, r19, null);
        if (r18 != null) goto L36;
        if (r19 != null) goto L36;
        int r20 = 0;
    L37:
        r9.setCompoundDrawablePadding(r20);
        if (r17 == null) goto L40;
        r1 = ColorStateList.valueOf(r17.intValue());
    L40:
        r9.setCompoundDrawableTintList(r1);
    L36:
        r20 = o1.t(r9.getContext(), 6);
        goto L37
    L27:
        ColorStateList r21 = this.k;
        if (r21 == null) goto L30;
        r9.setTextColor(r21);
        goto L31
    L30:
        r9.setTextColor(this.l);
        goto L31
    L23:
        r16 = 12.0f;
    L41:
        OIconButton r22 = this.c;
        if (r22 == null) goto L45;
        N(r22);
        return;
    }

    public LynxOUIButtonUI(LynxContext r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3);
        this.d = "";
        this.h = new q4(0);
        this.l = ColorProtector.parseColor("#1F2329");
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
        Drawable r4 = this.m;
        Float r5 = r2.b;
        if (r5 == null) goto L8;
        float r7 = r5.floatValue();
    L9:
        r6.setBackground(o1.j(r1, r2, r3, r4, r7));
        Integer r8 = o1.k(this.h, this.i, o1.K(this.h, this.i, this.l));
        if (r8 == null) goto L13;
        ColorStateList r9 = ColorStateList.valueOf(r8.intValue());
        if (r9 == null) goto L13;
    L14:
        r6.setImageTintList(r9);
        o1.b(r6, this.h);
        return;
    L13:
        r9 = this.n;
        goto L14
    L8:
        r7 = 12.0f;
        goto L9
    }

    public final View createView(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        FrameLayout r0 = new FrameLayout(r3);
        r0.setMinimumHeight(o1.t(r3, 40));
        r0.addOnLayoutChangeListener(new b2(this));
        r0.setOnClickListener(new c2(this));
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

    public final void updatePropertiesInterval(com.lynx.tasm.behavior.x0 r32) {
        Intrinsics.checkNotNullParameter(r32, "props");
        super/*com.lynx.tasm.behavior.ui.LynxBaseUI*/.updatePropertiesInterval(o1.S(r32, this.g, new String[]{"text", "label", "title", "disabled", "icon", "iconResName", "iconResId", "tailIcon", "tailIconResName", "tailIconResId", "backgroundColor", "radiusDp", "cornerRadius", "borderRadius", "textColor", "borderColor", "borderWidth", "iconTint", "buttonSize", "buttonSizeDp", "iconSize", "iconSizeDp", "disablePressEffect", "disableGreyInteraction", "disableGrayInteraction", "disabledBackgroundColor", "disabledTextColor", "disabledBorderColor"}, new String[]{"icon", "tailIcon"}, 2));
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
