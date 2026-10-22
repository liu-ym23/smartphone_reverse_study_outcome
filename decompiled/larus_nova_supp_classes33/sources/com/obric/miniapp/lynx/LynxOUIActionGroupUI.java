package com.obric.miniapp.lynx;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxProp;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.LynxUI;
import com.obric.oui.button.OButton;
import com.obric.oui.button.OButtonGroup;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u000bH\u0014J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0012\u0010\u0010\u001a\u00020\r2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0007J\b\u0010\u0013\u001a\u00020\rH\u0016J\u001a\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0012H\u0002R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0002X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/obric/miniapp/lynx/LynxOUIActionGroupUI;", "Lcom/lynx/tasm/behavior/ui/LynxUI;", "Landroid/widget/FrameLayout;", "context", "Lcom/lynx/tasm/behavior/LynxContext;", "<init>", "(Lcom/lynx/tasm/behavior/LynxContext;)V", "root", "optionsJson", "Lorg/json/JSONObject;", "createView", "Landroid/content/Context;", "updatePropertiesInterval", "", "props", "Lcom/lynx/tasm/behavior/StylesDiffMap;", "setOptions", "options", "", "destroy", "sendClickEvent", "index", "", "title", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LynxOUIActionGroupUI extends LynxUI<FrameLayout> {
    public static final /* synthetic */ int c = 0;
    public FrameLayout a;
    public JSONObject b;

    public final void destroy() {
        this.a = null;
        super.destroy();
    }

    public LynxOUIActionGroupUI(LynxContext r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        if (r2.getDefaultOverflowVisible() == false) goto L6;
        ((LynxBaseUI) this).mOverflow = 3;
        return;
    }

    public final View createView(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        FrameLayout r0 = new FrameLayout(r3);
        r0.setMinimumHeight(o1.t(r3, 48));
        this.a = r0;
        return r0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v6, types: [android.view.View, com.obric.oui.button.OButtonGroup] */
    @LynxProp(name = "options")
    public final void setOptions(String r21) {
        JSONObject r1 = o1.G(r21);
        this.b = r1;
        FrameLayout r2 = this.a;
        if (r2 != 0) goto L5;
        return;
    L5:
        if (r1 != null) goto L7;
        r1 = new JSONObject();
    L7:
        JSONArray r3 = r1.optJSONArray("items");
        if (r3 != null) goto L12;
        r3 = r1.optJSONArray("actions");
        if (r3 != null) goto L12;
        r3 = new JSONArray();
    L12:
        Integer r4 = o1.i(r1.opt("radiusDp"));
        boolean r5 = true;
        String r6 = null;
        boolean r7 = false;
        if (r4 != null) goto L15;
    L23:
        int r8 = 0;
    L24:
        if (r8 > 0) goto L26;
        r2.setOutlineProvider(null);
        r2.setClipToOutline(false);
    L27:
        r2.removeAllViews();
        if (r3.length() > 0) goto L30;
        return;
    L30:
        ?? r9 = new OButtonGroup(r2.getContext(), null, 0, 14);
        q4 r10 = o1.g(r1, r2.getContext());
        int r11 = r3.length();
        final int r12 = 0;
    L31:
        if (r12 >= r11) goto L72;
        JSONObject r13 = r3.optJSONObject(r12);
        if (r13 == null) goto L36;
        final String r14 = o1.C(r13, new String[]{"title", "label", "text", "name"});
        if (r14 == null) goto L36;
    L42:
        Context r15 = r2.getContext();
        if (r13 != null) goto L45;
        JSONObject r16 = new JSONObject();
    L46:
        Drawable r17 = o1.N(r15, r16);
        if (StringsKt.isBlank(r14) == false) goto L50;
        if (r17 != null) goto L50;
        r10 = r10;
    L71:
        r12 = r12 + 1;
        r10 = r10;
        r5 = true;
        r6 = null;
        r7 = false;
    L50:
        q4 r18 = o1.e(r10, o1.g(r13, r2.getContext()));
        if (r13 == null) goto L53;
        boolean r19 = r13.optBoolean("disabled", r7);
    L54:
        OButton r110 = o1.d(r2.getContext());
        Drawable r20 = o1.q(r110.getBackground());
        ColorStateList r111 = r110.getTextColors();
        int r22 = o1.K(r18, r19, r110.getCurrentTextColor());
        Integer r23 = o1.k(r18, r19, r22);
        Drawable r112 = o1.n(r17, r23);
        r110.setText(r14);
        if (StringsKt.isBlank(r14) == false) goto L57;
        r110.setMIcon(r112);
        r110.setCompoundDrawablesRelativeWithIntrinsicBounds(null, null, null, null);
        r110.setCompoundDrawablePadding(0);
        r110.setCompoundDrawableTintList(null);
    L66:
        r110.setBackground(o1.j(r2.getContext(), r18, r19, r20, 12.0f));
        o1.p(r110, r18);
        if (o1.v(r18) == false) goto L69;
        r110.setTextColor(r22);
    L70:
        r110.setEnabled(!r19);
        r110.setOnClickListener(new j1(this, r12, r14));
        r9.D(r110, new ViewGroup.MarginLayoutParams(-2, -2));
        goto L71
    L69:
        r110.setTextColor(r111);
        goto L70
    L57:
        r110.setMIcon(null);
        r110.setCompoundDrawablesRelativeWithIntrinsicBounds(r112, null, null, null);
        if (r112 == null) goto L60;
        int r113 = o1.t(r110.getContext(), 6);
    L61:
        r110.setCompoundDrawablePadding(r113);
        if (r23 == null) goto L64;
        ColorStateList r24 = ColorStateList.valueOf(r23.intValue());
    L65:
        r110.setCompoundDrawableTintList(r24);
        goto L66
    L64:
        r24 = null;
        goto L65
    L60:
        r113 = 0;
        goto L61
    L53:
        r19 = false;
        goto L54
    L45:
        r16 = r13;
    L36:
        r14 = r3.optString(r12);
        Intrinsics.checkNotNull(r14);
        if ((StringsKt.isBlank(r14) ^ r5) == true) goto L40;
        r14 = r6;
    L40:
        if (r14 != null) goto L42;
        r14 = "";
        goto L42
    L72:
        r2.removeAllViews();
        FrameLayout.LayoutParams r25 = new FrameLayout.LayoutParams(-2, -2);
        r25.gravity = 17;
        Unit r26 = Unit.INSTANCE;
        r2.addView(r9, r25);
        return;
    L26:
        r2.setOutlineProvider(new p1(r8));
        r2.setClipToOutline(true);
        goto L27
    L15:
        if (r4.intValue() <= 0) goto L17;
        boolean r27 = true;
    L18:
        if (r27 == true) goto L21;
        r4 = null;
    L21:
        if (r4 == null) goto L23;
        r8 = o1.t(r2.getContext(), r4.intValue());
        goto L24
    L17:
        r27 = false;
        goto L18
    }

    public final void updatePropertiesInterval(com.lynx.tasm.behavior.x0 r22) {
        Intrinsics.checkNotNullParameter(r22, "props");
        super/*com.lynx.tasm.behavior.ui.LynxBaseUI*/.updatePropertiesInterval(o1.S(r22, this.b, new String[]{"items", "actions", "radiusDp", "backgroundColor", "textColor", "borderColor", "borderWidth", "iconTint", "buttonSize", "buttonSizeDp", "iconSize", "iconSizeDp", "disablePressEffect", "disableGreyInteraction", "disableGrayInteraction", "disabledBackgroundColor", "disabledTextColor", "disabledBorderColor"}, new String[]{"items", "actions"}, 2));
    }
}
