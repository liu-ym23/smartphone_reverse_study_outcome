package com.obric.miniapp.lynx;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.core.content.ContextCompat;
import com.lynx.tasm.EventEmitter;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxProp;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.LynxUI;
import com.obric.oui.button.OIconButtonFloating;
import com.obric.oui.layout.OUIFrameLayout;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 H2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001HB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0019H\u0014J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u0012\u0010\u001e\u001a\u00020\u001b2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0013H\u0007J\u0012\u0010 \u001a\u00020\u001b2\b\u0010!\u001a\u0004\u0018\u00010\u0013H\u0007J\u0012\u0010\"\u001a\u00020\u001b2\b\u0010!\u001a\u0004\u0018\u00010\u0013H\u0007J\u0012\u0010#\u001a\u00020\u001b2\b\u0010!\u001a\u0004\u0018\u00010\u0013H\u0007J\u0012\u0010$\u001a\u00020\u001b2\b\u0010!\u001a\u0004\u0018\u00010\u0013H\u0007J\u0012\u0010%\u001a\u00020\u001b2\b\u0010!\u001a\u0004\u0018\u00010\u0013H\u0007J\u0012\u0010&\u001a\u00020\u001b2\b\u0010!\u001a\u0004\u0018\u00010\u0013H\u0007J\u0012\u0010'\u001a\u00020\u001b2\b\u0010!\u001a\u0004\u0018\u00010\u0013H\u0007J\u0012\u0010(\u001a\u00020\u001b2\b\u0010!\u001a\u0004\u0018\u00010\u0013H\u0007J\u0010\u0010)\u001a\u00020\u001b2\u0006\u0010!\u001a\u00020*H\u0007J\u0012\u0010+\u001a\u00020\u001b2\b\u0010!\u001a\u0004\u0018\u00010\u0013H\u0007J\u0012\u0010,\u001a\u00020\u001b2\b\u0010!\u001a\u0004\u0018\u00010\u0013H\u0007J\u0012\u0010-\u001a\u00020\u001b2\b\u0010!\u001a\u0004\u0018\u00010\u0013H\u0007J\u0010\u0010.\u001a\u00020\u001b2\u0006\u0010!\u001a\u00020\u0011H\u0007J\b\u0010/\u001a\u00020\u001bH\u0016J\u0010\u00100\u001a\u00020\u001b2\u0006\u00101\u001a\u00020\tH\u0002J\u0012\u00102\u001a\u00020\u001b2\b\b\u0002\u00103\u001a\u00020\u0011H\u0002J\b\u00104\u001a\u00020\u001bH\u0002J\b\u00105\u001a\u00020\u001bH\u0002J\u0018\u00106\u001a\u00020\u001b2\u0006\u00107\u001a\u00020\u00132\u0006\u00108\u001a\u00020\u0013H\u0002J\u001a\u00109\u001a\u00020\u001b2\u0006\u0010:\u001a\u00020\u00132\b\u0010!\u001a\u0004\u0018\u00010;H\u0002J\u0012\u0010<\u001a\u00020\u001b2\b\u0010=\u001a\u0004\u0018\u00010\u000fH\u0002J\u0018\u0010>\u001a\u00020?2\u0006\u0010\u0003\u001a\u00020\u00192\u0006\u0010@\u001a\u00020?H\u0002J\b\u0010A\u001a\u00020\u001bH\u0002J\u0012\u0010B\u001a\u0004\u0018\u00010\r2\u0006\u0010C\u001a\u00020DH\u0002J\u0012\u0010E\u001a\u00020\u00132\b\u0010=\u001a\u0004\u0018\u00010\u000fH\u0002J\u0010\u0010F\u001a\u00020*2\u0006\u00108\u001a\u00020\u0013H\u0002J\u0010\u0010G\u001a\u00020*2\u0006\u00108\u001a\u00020\u0013H\u0002R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0002X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0016R\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0016¨\u0006I"}, d2 = {"Lcom/obric/miniapp/lynx/LynxOUIBasicButtonFloatingUI;", "Lcom/lynx/tasm/behavior/ui/LynxUI;", "Landroid/widget/FrameLayout;", "context", "Lcom/lynx/tasm/behavior/LynxContext;", "<init>", "(Lcom/lynx/tasm/behavior/LynxContext;)V", "root", "buttonView", "Lcom/obric/oui/button/OIconButtonFloating;", "contentView", "Landroid/view/ViewGroup;", "iconView", "Landroid/widget/ImageView;", "optionsJson", "Lorg/json/JSONObject;", "disabled", "", "currentPreset", "", "iconWidthDp", "", "Ljava/lang/Float;", "iconHeightDp", "createView", "Landroid/content/Context;", "updatePropertiesInterval", "", "props", "Lcom/lynx/tasm/behavior/StylesDiffMap;", "setOptions", "options", "setPreset", "value", "setButtonPreset", "setVariant", "setIcon", "setIconResName", "setBuiltinIcon", "setIconBuiltin", "setIconName", "setIconResId", "", "setIconSize", "setIconWidth", "setIconHeight", "setDisabled", "destroy", "bindClick", "button", "ensureButtonPreset", "force", "applyIcon", "applyDisabled", "sendEvent", "type", "preset", "updateOptionField", "key", "", "resolveIconSize", "source", "applyIconBounds", "Landroid/graphics/drawable/Drawable;", "drawable", "applyIconViewSize", "findIconView", "view", "Landroid/view/View;", "resolvePreset", "layoutResForPreset", "buttonIdForPreset", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LynxOUIBasicButtonFloatingUI extends LynxUI<FrameLayout> {
    public static final /* synthetic */ int j = 0;
    public FrameLayout a;
    public OIconButtonFloating b;
    public ViewGroup c;
    public ImageView d;
    public JSONObject e;
    public boolean f;
    public String g;
    public Float h;
    public Float i;

    public static final class a {
    }

    static {
    }

    public final void destroy() {
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.a = null;
        super.destroy();
    }

    public final void M() {
        OIconButtonFloating r0 = this.b;
        if (r0 == null) goto L6;
        r0.setEnabled(!this.f);
        return;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [android.widget.FrameLayout, com.obric.oui.button.OIconButtonFloating] */
    public final void N() {
        ?? r0 = this.b;
        if (r0 != 0) goto L5;
        return;
    L5:
        JSONObject r1 = this.e;
        if (r1 != null) goto L8;
    L20:
        r1 = new JSONObject().put("iconResName", "icon_circle_20");
    L21:
        cla.a r8 = cla.a.a;
        Context r9 = r0.getContext();
        Intrinsics.checkNotNull(r1);
        String[] r3 = {"icon", "builtinIcon", "iconBuiltin", "iconName"};
        String[] r2 = {"iconResId"};
        String[] r4 = {"iconResName", "builtinIcon", "iconBuiltin", "iconName"};
        r8.getClass();
        Intrinsics.checkNotNullParameter(r9, "context");
        Intrinsics.checkNotNullParameter(r1, "json");
        Intrinsics.checkNotNullParameter(r3, "valueKeys");
        Intrinsics.checkNotNullParameter(r2, "resIdKeys");
        Intrinsics.checkNotNullParameter(r4, "resNameKeys");
        int r6 = 0;
    L22:
        boolean r10 = true;
        Integer r11 = null;
        if (r6 >= 4) goto L74;
        Object r12 = r1.opt(r3[r6]);
        if ((r12 instanceof Number) == false) goto L37;
        if (((Number) r12).intValue() <= 0) goto L73;
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L30
        Object r7 = Result.constructor-impl(ContextCompat.getDrawable(r9, ((Number) r12).intValue()));     // Catch: Throwable -> L30
    L33:
        if (Result.isFailure-impl(r7) == false) goto L35;
        r7 = null;
    L35:
        Drawable r13 = (Drawable) r7;
    L101:
        if (r13 == null) goto L158;
        Context r14 = r0.getContext();
        Float r15 = this.h;
        Float r16 = this.i;
        if (r15 == null) goto L157;
        if (r16 == null) goto L157;
        cla.a.a.getClass();
        Drawable.ConstantState r17 = r13.getConstantState();
        if (r17 == null) goto L112;
        Drawable r18 = r17.newDrawable();
        if (r18 == null) goto L112;
        Drawable r19 = r18.mutate();
        if (r19 == null) goto L112;
    L113:
        r19.setState(r13.getState());
        r19.setLevel(r13.getLevel());
        if (r13.getBounds().isEmpty() == true) goto L116;
        r19.setBounds(new Rect(r13.getBounds()));
    L156:
        r19.setBounds(0, 0, cla.a.a(r14, r15.floatValue()), cla.a.a(r14, r16.floatValue()));
        r13 = r19;
        goto L157
    L116:
        Integer r20 = Integer.valueOf(r19.getIntrinsicWidth());
        if (r20.intValue() <= 0) goto L119;
        boolean r21 = true;
    L120:
        if (r21 == true) goto L123;
        r20 = null;
    L123:
        if (r20 != null) goto L133;
        r20 = Integer.valueOf(r13.getIntrinsicWidth());
        if (r20.intValue() <= 0) goto L128;
        boolean r22 = true;
    L129:
        if (r22 == true) goto L132;
        r20 = null;
    L132:
        if (r20 != null) goto L133;
        int r23 = 0;
    L135:
        Integer r24 = Integer.valueOf(r19.getIntrinsicHeight());
        if (r24.intValue() <= 0) goto L138;
        boolean r110 = true;
    L139:
        if (r110 == true) goto L142;
        r24 = null;
    L142:
        if (r24 == null) goto L144;
        int r25 = r24.intValue();
    L153:
        if (r23 <= 0) goto L156;
        if (r25 <= 0) goto L156;
        r19.setBounds(0, 0, r23, r25);
        goto L156
    L144:
        Integer r26 = Integer.valueOf(r13.getIntrinsicHeight());
        if (r26.intValue() > 0) goto L148;
        r10 = false;
    L148:
        if (r10 == false) goto L150;
        r11 = r26;
    L150:
        if (r11 == null) goto L152;
        r25 = r11.intValue();
        goto L153
    L152:
        r25 = 0;
        goto L153
    L138:
        r110 = false;
        goto L139
    L128:
        r22 = false;
    L133:
        r23 = r20.intValue();
        goto L135
    L119:
        r21 = false;
    L112:
        r19 = r13.mutate();
    L157:
        r0.setIcon(r13);
    L158:
        O();
        return;
    L30:
        th = move-exception;
        Result.Companion r27 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
    L73:
        r6 = r6 + 1;
        goto L22
    L37:
        if ((r12 instanceof String) == false) goto L42;
        cla.a.a.getClass();
        Drawable r111 = cla.a.f(r9, (String) r12);
        if (r111 == null) goto L73;
    L40:
        r13 = r111;
        goto L101
    L42:
        if ((r12 instanceof JSONObject) == false) goto L73;
        JSONObject r112 = (JSONObject) r12;
        Integer r113 = Integer.valueOf(r112.optInt("resId"));
        if (r113.intValue() <= 0) goto L46;
        boolean r114 = true;
    L47:
        if (r114 == true) goto L50;
        r113 = null;
    L50:
        if (r113 != null) goto L51;
        String r115 = r112.optString("resName");
        Intrinsics.checkNotNull(r115);
        if ((!StringsKt.isBlank(r115)) == true) goto L64;
        r115 = null;
    L64:
        if (r115 != null) goto L69;
        r115 = r112.optString("iconResName");
        Intrinsics.checkNotNull(r115);
        if ((!StringsKt.isBlank(r115)) == true) goto L69;
        r115 = null;
    L69:
        if (r115 == null) goto L73;
        cla.a.a.getClass();
        r111 = cla.a.f(r9, r115);
        if (r111 == null) goto L73;
    L51:
        int r28 = r113.intValue();
        Result.Companion r29 = Result.Companion;     // Catch: Throwable -> L54
        Object r30 = Result.constructor-impl(ContextCompat.getDrawable(r9, r28));     // Catch: Throwable -> L54
    L57:
        if (Result.isFailure-impl(r30) == false) goto L59;
        r30 = null;
    L59:
        r13 = (Drawable) r30;
    L54:
        th = move-exception;
        Result.Companion r31 = Result.Companion;
        r30 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L57
    L46:
        r114 = false;
        goto L47
    L74:
        Integer r32 = Integer.valueOf(r1.optInt(r2[0]));
        if (r32.intValue() <= 0) goto L77;
        boolean r33 = true;
    L78:
        if (r33 == true) goto L81;
        r32 = null;
    L81:
        if (r32 == null) goto L91;
        int r34 = r32.intValue();
        Result.Companion r35 = Result.Companion;     // Catch: Throwable -> L85
        Object r36 = Result.constructor-impl(ContextCompat.getDrawable(r9, r34));     // Catch: Throwable -> L85
    L88:
        if (Result.isFailure-impl(r36) == false) goto L90;
        r36 = null;
    L90:
        r13 = (Drawable) r36;
    L85:
        th = move-exception;
        Result.Companion r37 = Result.Companion;
        r36 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L88
    L91:
        int r38 = 0;
    L92:
        if (r38 >= 4) goto L100;
        String r39 = r1.optString(r4[r38]);
        Intrinsics.checkNotNull(r39);
        if ((!StringsKt.isBlank(r39)) == true) goto L97;
        r39 = null;
    L97:
        if (r39 != null) goto L98;
        r38 = r38 + 1;
        goto L92
    L98:
        cla.a.a.getClass();
        r13 = cla.a.f(r9, r39);
        goto L101
    L100:
        r13 = null;
        goto L101
    L77:
        r33 = false;
        goto L78
    L8:
        if (r1.has("icon") == true) goto L21;
        if (r1.has("builtinIcon") == true) goto L21;
        if (r1.has("iconBuiltin") == true) goto L21;
        if (r1.has("iconName") == true) goto L21;
        if (r1.has("iconResId") == true) goto L21;
        if (r1.has("iconResName") == false) goto L20;
        goto L20
    }

    public final void O() {
        OUIFrameLayout r0 = this.b;
        if (r0 != null) goto L5;
        return;
    L5:
        ImageView r1 = this.d;
        if (r1 != null) goto L13;
        r1 = Q(r0);
        if (r1 == null) goto L10;
        this.d = r1;
    L11:
        if (r1 != null) goto L13;
        return;
    L10:
        r1 = null;
    L13:
        Float r2 = this.h;
        if (r2 != null) goto L16;
        Float r3 = this.i;
    L17:
        Float r4 = this.i;
        if (r4 == null) goto L21;
        r2 = r4;
    L21:
        ViewGroup.LayoutParams r5 = r1.getLayoutParams();
        if (r5 == null) goto L24;
    L28:
        if (r3 != null) goto L31;
        if (r2 != null) goto L31;
        r5.width = -1;
        r5.height = -1;
    L44:
        if ((r5 instanceof FrameLayout.LayoutParams) == false) goto L46;
        ((FrameLayout.LayoutParams) r5).gravity = 17;
    L46:
        r1.setLayoutParams(r5);
        r1.setScaleType(ImageView.ScaleType.FIT_CENTER);
        r1.setAdjustViewBounds(true);
        r1.requestLayout();
        r1.invalidate();
        return;
    L31:
        cla.a r6 = cla.a.a;
        Context r7 = r0.getContext();
        float r8 = 0.0f;
        if (r3 == null) goto L34;
        float r9 = r3.floatValue();
    L37:
        r6.getClass();
        r5.width = cla.a.a(r7, r9);
        Context r10 = r0.getContext();
        if (r2 == null) goto L40;
        r8 = r2.floatValue();
    L42:
        r5.height = cla.a.a(r10, r8);
        goto L44
    L40:
        if (r3 == null) goto L42;
        r8 = r3.floatValue();
        goto L42
    L34:
        if (r2 == null) goto L36;
        r9 = r2.floatValue();
        goto L37
    L36:
        r9 = 0.0f;
        goto L37
    L24:
        if ((r1.getParent() instanceof FrameLayout) == false) goto L26;
        r5 = new FrameLayout.LayoutParams(-1, -1, 17);
    L27:
        r1.setLayoutParams(r5);
        goto L28
    L26:
        r5 = new ViewGroup.LayoutParams(-1, -1);
        goto L27
    L16:
        r3 = r2;
        goto L17
    }

    public LynxOUIBasicButtonFloatingUI(LynxContext r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.g = "btn_s_a5";
        if (r2.getDefaultOverflowVisible() == false) goto L6;
        ((LynxBaseUI) this).mOverflow = 3;
        return;
    }

    public static ImageView Q(View r3) {
        if ((r3 instanceof ImageView) == false) goto L7;
        return (ImageView) r3;
    L7:
        if ((r3 instanceof ViewGroup) == false) goto L14;
        ViewGroup r4 = (ViewGroup) r3;
        int r0 = r4.getChildCount();
        int r1 = 0;
    L9:
        if (r1 >= r0) goto L18;
        ImageView r2 = Q(r4.getChildAt(r1));
        if (r2 != null) goto L12;
        r1 = r1 + 1;
        goto L9
    L12:
        return r2;
    L18:
        return null;
    L14:
        return null;
    }

    public static String S(final JSONObject r4) {
        String r0 = null;
        if (r4 == null) goto L5;
        String r5 = (String) SequencesKt.firstOrNull(SequencesKt.mapNotNull(SequencesKt.sequenceOf(new String[]{"preset", "buttonPreset", "variant"}), new k1(r4)));
    L6:
        if (r5 == null) goto L11;
        String r6 = StringsKt.trim(r5).toString();
        if (r6 == null) goto L11;
        r0 = r6.toLowerCase(Locale.ROOT);
    L11:
        if (r0 != null) goto L13;
        return "btn_s_a5";
    L13:
        switch(r0.hashCode()) {
            case 3520319: goto L21;
            case 3520320: goto L19;
            case 2108394306: goto L17;
            case 2108394307: goto L15;
            default: goto L28;
        };
    L15:
        r0.equals("btn_s_a5");
        return "btn_s_a5";
    L19:
        r0.equals("s_a5");
        return "btn_s_a5";
    L28:
        return "btn_s_a5";
    L17:
        if (r0.equals("btn_s_a4") == true) goto L23;
        return "btn_s_a5";
    L23:
        return "btn_s_a4";
    L21:
        if (r0.equals("s_a4") == true) goto L23;
        return "btn_s_a5";
    L5:
        r5 = null;
        goto L6
    }

    /* JADX WARN: Type inference failed for: r2v5, types: [android.view.View, android.widget.FrameLayout, com.obric.oui.button.OIconButtonFloating, java.lang.Object] */
    public final void P(boolean r7) {
        FrameLayout r0 = this.a;
        if (r0 != null) goto L6;
        return;
    L6:
        if (Intrinsics.areEqual(this.g, "btn_s_a4") == false) goto L8;
        int r1 = 2131563661;
    L9:
        ViewGroup r3 = this.c;
        OIconButtonFloating r4 = this.b;
        if (r7 == true) goto L16;
        if (r3 == null) goto L16;
        if (r4 == null) goto L16;
        if (Intrinsics.areEqual(r3.getTag(2131364819), Integer.valueOf(r1)) == false) goto L16;
        return;
    L16:
        r0.removeAllViews();
        View r8 = LayoutInflater.from(r0.getContext()).inflate(r1, r0, false);
        Intrinsics.checkNotNull(r8, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup r9 = (ViewGroup) r8;
        if (Intrinsics.areEqual(this.g, "btn_s_a4") == false) goto L19;
        int r2 = 2131364819;
    L20:
        ?? r5 = (OIconButtonFloating) r9.findViewById(r2);
        Intrinsics.checkNotNull(r5);
        r5.setOnClickListener(new l1(this));
        r9.setTag(2131364819, Integer.valueOf(r1));
        r0.addView(r9, new FrameLayout.LayoutParams(-2, -2, 17));
        this.c = r9;
        this.b = r5;
        this.d = Q(r5);
        O();
        return;
    L19:
        r2 = 2131364820;
        goto L20
    L8:
        r1 = 2131563662;
        goto L9
    }

    public final void R(JSONObject r4) {
        cla.a r0 = cla.a.a;
        Object r1 = null;
        if (r4 == null) goto L5;
        Object r2 = r4.opt("iconSize");
    L6:
        r0.getClass();
        Float r3 = cla.a.b(r2);
        if (r4 == null) goto L9;
        Object r5 = r4.opt("iconWidth");
    L10:
        Float r6 = cla.a.b(r5);
        if (r6 != null) goto L13;
        r6 = r3;
    L13:
        this.h = r6;
        if (r4 == null) goto L16;
        r1 = r4.opt("iconHeight");
    L16:
        Float r7 = cla.a.b(r1);
        if (r7 == null) goto L20;
        r3 = r7;
    L20:
        this.i = r3;
        return;
    L9:
        r5 = null;
        goto L10
    L5:
        r2 = null;
        goto L6
    }

    public final View createView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        FrameLayout r0 = new FrameLayout(r2);
        r0.setClipChildren(false);
        r0.setClipToPadding(false);
        this.a = r0;
        P(true);
        N();
        M();
        return r0;
    }

    @LynxProp(name = "builtinIcon")
    public final void setBuiltinIcon(String r2) {
        U("builtinIcon", r2);
        N();
    }

    @LynxProp(name = "buttonPreset")
    public final void setButtonPreset(String r2) {
        U("buttonPreset", r2);
        this.g = S(this.e);
        P(false);
        N();
        M();
    }

    @LynxProp(name = "disabled")
    public final void setDisabled(boolean r3) {
        U("disabled", Boolean.valueOf(r3));
        this.f = r3;
        M();
    }

    @LynxProp(name = "icon")
    public final void setIcon(String r2) {
        U("icon", r2);
        N();
    }

    @LynxProp(name = "iconBuiltin")
    public final void setIconBuiltin(String r2) {
        U("iconBuiltin", r2);
        N();
    }

    @LynxProp(name = "iconHeight")
    public final void setIconHeight(String r2) {
        U("iconHeight", r2);
        R(this.e);
        N();
    }

    @LynxProp(name = "iconName")
    public final void setIconName(String r2) {
        U("iconName", r2);
        N();
    }

    @LynxProp(name = "iconResId")
    public final void setIconResId(int r2) {
        U("iconResId", Integer.valueOf(r2));
        N();
    }

    @LynxProp(name = "iconResName")
    public final void setIconResName(String r2) {
        U("iconResName", r2);
        N();
    }

    @LynxProp(name = "iconSize")
    public final void setIconSize(String r2) {
        U("iconSize", r2);
        R(this.e);
        N();
    }

    @LynxProp(name = "iconWidth")
    public final void setIconWidth(String r2) {
        U("iconWidth", r2);
        R(this.e);
        N();
    }

    @LynxProp(name = "options")
    public final void setOptions(String r3) {
        cla.a.a.getClass();
        JSONObject r0 = null;
        Object r1 = null;
        r0 = null;
        if (r3 != null) goto L5;
    L18:
        this.e = r0;
        if (r0 == null) goto L21;
        boolean r2 = r0.optBoolean("disabled", false);
    L22:
        this.f = r2;
        this.g = S(this.e);
        R(this.e);
        P(false);
        N();
        M();
        return;
    L21:
        r2 = false;
        goto L22
    L5:
        if ((!StringsKt.isBlank(r3)) == true) goto L8;
        r3 = null;
    L8:
        if (r3 == null) goto L18;
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L11
        Object r5 = Result.constructor-impl(new JSONObject(r3));     // Catch: Throwable -> L11
    L14:
        if (Result.isFailure-impl(r5) == true) goto L17;
        r1 = r5;
    L17:
        r0 = (JSONObject) r1;
    L11:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L14
    }

    @LynxProp(name = "preset")
    public final void setPreset(String r2) {
        U("preset", r2);
        this.g = S(this.e);
        P(false);
        N();
        M();
    }

    @LynxProp(name = "variant")
    public final void setVariant(String r2) {
        U("variant", r2);
        this.g = S(this.e);
        P(false);
        N();
        M();
    }

    public final void updatePropertiesInterval(com.lynx.tasm.behavior.x0 r15) {
        Intrinsics.checkNotNullParameter(r15, "props");
        super/*com.lynx.tasm.behavior.ui.LynxBaseUI*/.updatePropertiesInterval(o1.S(r15, this.e, new String[]{"preset", "buttonPreset", "variant", "icon", "iconResId", "iconResName", "builtinIcon", "iconBuiltin", "iconName", "iconSize", "iconWidth", "iconHeight", "disabled"}, null, 10));
    }

    public final void T(String r4, String r5) {
        LynxContext r0 = getLynxContext();
        if (r0 == null) goto L9;
        EventEmitter r1 = r0.getEventEmitter();
        if (r1 == null) goto L10;
        m7a.a r2 = new m7a.a(getSign(), r4);
        r2.a("preset", r5);
        r2.a("value", r5);
        r1.sendCustomEvent(r2);
        return;
    L10:
        return;
    }

    public final void U(String r3, Object r4) {
        JSONObject r0 = this.e;
        if (r0 != null) goto L5;
        r0 = new JSONObject();
    L5:
        this.e = r0;
        if (r4 != null) goto L9;
        r0.remove(r3);
        return;
    L9:
        if ((r4 instanceof String) == true) goto L11;
        r0.put(r3, r4);
        return;
    L11:
        if (StringsKt.isBlank((CharSequence) r4) == false) goto L13;
        r0.remove(r3);
        return;
    L13:
        r0.put(r3, r4);
    }
}
