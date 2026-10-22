package com.obric.miniapp.lynx;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.lynx.tasm.EventEmitter;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxProp;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.LynxUI;
import com.obric.oui.button.OButtonFloating;
import com.obric.oui.button.OIconButtonFloating;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u000fH\u0014J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0012\u0010\u0014\u001a\u00020\u00112\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0007J\b\u0010\u0017\u001a\u00020\u0011H\u0016J\u0012\u0010\u0018\u001a\u00020\u00112\b\u0010\u0019\u001a\u0004\u0018\u00010\u0016H\u0002R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0002X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/obric/miniapp/lynx/LynxOUIFabUI;", "Lcom/lynx/tasm/behavior/ui/LynxUI;", "Landroid/widget/FrameLayout;", "context", "Lcom/lynx/tasm/behavior/LynxContext;", "<init>", "(Lcom/lynx/tasm/behavior/LynxContext;)V", "root", "optionsJson", "Lorg/json/JSONObject;", "fab", "Landroid/view/View;", "appearance", "Lcom/obric/miniapp/lynx/MiniAppButtonAppearance;", "createView", "Landroid/content/Context;", "updatePropertiesInterval", "", "props", "Lcom/lynx/tasm/behavior/StylesDiffMap;", "setOptions", "options", "", "destroy", "sendClickEvent", "text", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LynxOUIFabUI extends LynxUI<FrameLayout> {
    public static final /* synthetic */ int d = 0;
    public FrameLayout a;
    public JSONObject b;
    public q4 c;

    public final void destroy() {
        this.a = null;
        super.destroy();
    }

    public LynxOUIFabUI(LynxContext r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3);
        this.c = new q4(0);
        if (r3.getDefaultOverflowVisible() == false) goto L6;
        ((LynxBaseUI) this).mOverflow = 3;
        return;
    }

    public final void M(String r5) {
        LynxContext r0 = getLynxContext();
        if (r0 == null) goto L17;
        EventEmitter r1 = r0.getEventEmitter();
        if (r1 == null) goto L18;
        m7a.a r2 = new m7a.a(getSign(), "click");
        if (r5 != null) goto L10;
    L15:
        r1.sendCustomEvent(r2);
        return;
    L10:
        if ((!StringsKt.isBlank(r5)) == true) goto L13;
        r5 = null;
    L13:
        if (r5 == null) goto L15;
        r2.a("text", r5);
        r2.a("value", r5);
        goto L15
    L18:
        return;
    }

    public final View createView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        FrameLayout r0 = new FrameLayout(r4);
        r0.setMinimumWidth(o1.t(r4, 48));
        r0.setMinimumHeight(o1.t(r4, 48));
        this.a = r0;
        return r0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v17, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r1v18, types: [android.view.View, android.widget.FrameLayout, com.obric.oui.button.OButtonFloating, com.obric.oui.button.OShadowFrame] */
    /* JADX WARN: Type inference failed for: r1v20 */
    /* JADX WARN: Type inference failed for: r1v21 */
    /* JADX WARN: Type inference failed for: r1v8, types: [android.view.View, android.widget.FrameLayout, com.obric.oui.button.OIconButtonFloating, com.obric.oui.button.OShadowFrame] */
    /* JADX WARN: Type inference failed for: r2v0, types: [android.widget.FrameLayout] */
    @LynxProp(name = "options")
    public final void setOptions(String r17) {
        JSONObject r1 = o1.G(r17);
        this.b = r1;
        ?? r2 = this.a;
        if (r2 != 0) goto L5;
        return;
    L5:
        if (r1 != null) goto L7;
        r1 = new JSONObject();
    L7:
        this.c = o1.g(r1, r2.getContext());
        final String r3 = o1.C(r1, new String[]{"text", "title", "label"});
        Drawable r4 = o1.N(r2.getContext(), r1);
        Drawable r5 = o1.O(r2.getContext(), r1, new String[]{"tailIcon"}, new String[]{"tailIconResId"}, new String[]{"tailIconResName"});
        int r7 = 0;
        boolean r6 = r1.optBoolean("disabled", false);
        int r8 = o1.K(this.c, r6, ColorProtector.parseColor("#1F2329"));
        Integer r9 = o1.k(this.c, r6, r8);
        Integer r10 = o1.E(o1.D(r1, new String[]{"iconBgColor", "backgroundColor", "icon_bg_color", "background_color"}), r2.getContext());
        if (r3 != null) goto L10;
    L13:
        boolean r12 = true;
    L14:
        ColorStateList r14 = null;
        if (r12 == true) goto L31;
        ?? r11 = new OButtonFloating(r2.getContext(), null, 0, 14);
        Drawable r13 = o1.q(r11.getBackground());
        r11.setTitle(r3);
        TextView r15 = r11.getTitleView();
        r15.setTextColor(r8);
        r15.setCompoundDrawablesRelativeWithIntrinsicBounds(r4, null, r5, null);
        if (r4 != null) goto L19;
        if (r5 != null) goto L19;
    L20:
        r15.setCompoundDrawablePadding(r7);
        if (r9 == null) goto L23;
        r14 = ColorStateList.valueOf(r9.intValue());
    L23:
        r15.setCompoundDrawableTintList(r14);
        Context r16 = r2.getContext();
        q4 r18 = this.c;
        Float r19 = r18.b;
        if (r19 == null) goto L26;
        float r110 = r19.floatValue();
    L27:
        r11.setBackground(o1.j(r16, r18, r6, r13, r110));
        if (r10 == null) goto L30;
        r11.setBgColor(r10.intValue());
    L30:
        o1.p(r11, this.c);
        r11.setEnabled(!r6);
        r11.setOnClickListener(new b3(this, r3));
        ?? r20 = r11;
    L70:
        r2.removeAllViews();
        FrameLayout.LayoutParams r21 = new FrameLayout.LayoutParams(-2, -2);
        r21.gravity = 17;
        Unit r22 = Unit.INSTANCE;
        r2.addView(r20, r21);
        return;
    L26:
        r110 = 12.0f;
    L19:
        r7 = o1.t(r15.getContext(), 6);
        goto L20
    L31:
        Context r23 = r2.getContext();
        String r24 = o1.C(r1, new String[]{"variant", "tone", "style", "emphasis"});
        if (r24 == null) goto L36;
        String r25 = StringsKt.trim(r24).toString();
        if (r25 == null) goto L36;
        String r26 = r25.toLowerCase(Locale.ROOT);
    L37:
        if (r26 != null) goto L39;
    L54:
        int r27 = 2131563910;
    L55:
        Object r28 = LayoutInflater.from(r23).inflate(r27, null, false);
        Intrinsics.checkNotNull(r28, "null cannot be cast to non-null type com.obric.oui.button.OIconButtonFloating");
        ?? r29 = (OIconButtonFloating) r28;
        Drawable r30 = o1.q(r29.getBackground());
        if (r4 != null) goto L58;
        r4 = r5;
    L58:
        if (r4 == null) goto L60;
        r29.setIcon(r4);
    L60:
        if (r9 == null) goto L62;
        r29.setIconTintColor(ColorStateList.valueOf(r9.intValue()));
    L62:
        Context r31 = r2.getContext();
        q4 r32 = this.c;
        Float r33 = r32.b;
        if (r33 == null) goto L65;
        float r111 = r33.floatValue();
    L66:
        r29.setBackground(o1.j(r31, r32, r6, r30, r111));
        if (r10 == null) goto L69;
        r29.setBgColor(r10.intValue());
    L69:
        o1.p(r29, this.c);
        r29.setEnabled(!r6);
        r29.setOnClickListener(new c3(this));
        r20 = r29;
        goto L70
    L65:
        r111 = 12.0f;
        goto L66
    L39:
        switch(r26.hashCode()) {
            case -1423461174: goto L51;
            case -681210700: goto L48;
            case -314765822: goto L45;
            case 951117504: goto L42;
            default: goto L54;
        };
    L42:
        if (r26.equals("confirm") == false) goto L54;
    L53:
        r27 = 2131563913;
        goto L55
    L45:
        if (r26.equals("primary") == false) goto L54;
    L48:
        if (r26.equals("highlight") == true) goto L53;
    L51:
        if (r26.equals("accent") == true) goto L53;
    L36:
        r26 = null;
        goto L37
    L10:
        if (StringsKt.isBlank(r3) == true) goto L13;
        r12 = false;
        goto L14
    }

    public final void updatePropertiesInterval(com.lynx.tasm.behavior.x0 r26) {
        Intrinsics.checkNotNullParameter(r26, "props");
        super/*com.lynx.tasm.behavior.ui.LynxBaseUI*/.updatePropertiesInterval(o1.S(r26, this.b, new String[]{"text", "title", "label", "icon", "iconResName", "iconResId", "tailIcon", "tailIconResName", "tailIconResId", "disabled", "backgroundColor", "radiusDp", "cornerRadius", "borderRadius", "textColor", "borderColor", "borderWidth", "iconTint", "iconBgColor", "disabledBackgroundColor", "disabledTextColor", "disabledBorderColor"}, new String[]{"icon", "tailIcon"}, 2));
    }
}
