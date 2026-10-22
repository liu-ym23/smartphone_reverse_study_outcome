package com.obric.miniapp.lynx;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.core.content.ContextCompat;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxProp;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.LynxUI;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.common.oui.BuildConfig;
import com.obric.oui.button.OButtonGroup;
import com.obric.oui.layout.OUIFrameLayout;
import com.obric.oui.layout.OUILinearLayout;
import com.obric.oui.text.OTextView;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0007\u0018\u0000 )2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001)B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\rH\u0014J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0012\u0010\u0012\u001a\u00020\u000f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0007J\u0010\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u000bH\u0007J\b\u0010\u0017\u001a\u00020\u000fH\u0016J\b\u0010\u0018\u001a\u00020\u000fH\u0016J\b\u0010\u0019\u001a\u00020\u000fH\u0002J\u0018\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\u000bH\u0002J\u001a\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u000b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0014H\u0002J8\u0010\u001f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\r2\u0006\u0010 \u001a\u00020\t2\u0006\u0010!\u001a\u00020\t2\u0006\u0010\"\u001a\u00020\u000b2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020$H\u0002J?\u0010&\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0003\u001a\u00020\r2\u0006\u0010 \u001a\u00020\t2\u0006\u0010!\u001a\u00020\t2\u0006\u0010'\u001a\u00020\u000b2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020$H\u0002¢\u0006\u0002\u0010(R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0002X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lcom/obric/miniapp/lynx/LynxMiniAppButtonGroupUI;", "Lcom/lynx/tasm/behavior/ui/LynxUI;", "Landroid/widget/FrameLayout;", "context", "Lcom/lynx/tasm/behavior/LynxContext;", "<init>", "(Lcom/lynx/tasm/behavior/LynxContext;)V", "rootView", "optionsJson", "Lorg/json/JSONObject;", "selectedIndex", "", "createView", "Landroid/content/Context;", "updatePropertiesInterval", "", "props", "Lcom/lynx/tasm/behavior/StylesDiffMap;", "setOptions", "options", "", "setSelectedIndex", "index", "onNodeReload", "destroy", "render", "resolveSelectedIndex", "json", "itemCount", "sendChangeEvent", "title", "resolveItemTintColor", "groupJson", "itemJson", "defaultTintColor", "selected", "", "disabled", "resolveItemIconTintColor", "resolvedTextColor", "(Landroid/content/Context;Lorg/json/JSONObject;Lorg/json/JSONObject;IZZ)Ljava/lang/Integer;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LynxMiniAppButtonGroupUI extends LynxUI<FrameLayout> {
    public static final /* synthetic */ int d = 0;
    public b a;
    public JSONObject b;
    public int c;

    public static final class a {
    }

    static {
    }

    public final void destroy() {
        this.a = null;
        super.destroy();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v14, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r29v1, types: [com.obric.oui.button.OButtonGroup] */
    /* JADX WARN: Type inference failed for: r34v0, types: [android.widget.FrameLayout] */
    /* JADX WARN: Type inference failed for: r4v20 */
    /* JADX WARN: Type inference failed for: r4v31 */
    /* JADX WARN: Type inference failed for: r4v7, types: [android.widget.FrameLayout, com.obric.oui.button.OButtonGroup, com.obric.oui.button.OShadowFrame] */
    /* JADX WARN: Type inference failed for: r4v8 */
    public final void M() {
        LynxMiniAppButtonGroupUI r1 = this;
        b r0 = r1.a;
        if (r0 != null) goto L5;
        return;
    L5:
        JSONObject r2 = r1.b;
        if (r2 != null) goto L8;
        r2 = new JSONObject();
    L8:
        Context r3 = r0.getContext();
        JSONArray r4 = r2.optJSONArray("items");
        boolean r7 = true;
        if (r4 != null) goto L15;
        r4 = r2.optJSONArray("actions");
        if (r4 != null) goto L15;
        r4 = r2.optJSONArray("titles");
        if (r4 != null) goto L15;
        List r5 = CollectionsKt.emptyList();
    L37:
        r0.removeAllViews();
        if (r5.isEmpty() == false) goto L40;
        return;
    L40:
        Context r6 = r0.getContext();
        String r8 = s.f(r2, new String[]{"styleable"});
        if (Intrinsics.areEqual(r8, "S") == false) goto L43;
        int r9 = 2131564152;
    L44:
        Object r10 = LayoutInflater.from(r6).inflate(r9, null, false);
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type com.obric.oui.button.OButtonGroup");
        ?? r11 = (OButtonGroup) r10;
        int r12 = ContextCompat.getColor(r11.getContext(), 2131104350);
        Context r13 = r11.getContext();
        if ((r13.getResources().getConfiguration().uiMode & 48) != 32) goto L47;
        List r14 = CollectionsKt.listOf(new String[]{"OFloatingTitleBar_Action_Dark", "OFloatingTitleBar_Action_Overlay", "OFloatingTitleBar_Action_Standard"});
    L48:
        Iterator r15 = r14.iterator();
    L50:
        if (r15.hasNext() == false) goto L60;
        Integer r16 = Integer.valueOf(r13.getResources().getIdentifier((String) r15.next(), "style", BuildConfig.LIBRARY_PACKAGE_NAME));
        if (r16.intValue() == 0) goto L54;
        boolean r17 = true;
    L55:
        if (r17 == true) goto L58;
        r16 = null;
    L58:
        if (r16 == null) goto L50;
    L61:
        if (r16 == null) goto L63;
        int r18 = r16.intValue();
    L65:
        if ((r11.getContext().getResources().getConfiguration().uiMode & 48) != 32) goto L67;
        boolean r19 = true;
    L68:
        TypedArray r20 = r11.getContext().obtainStyledAttributes(r18, new int[]{2130973365, 2130973366, 2130973374, 2130973381, 2130973383, 2130973385, 2130973386, 2130973389, 2130973391, 2130973392, 2130973394, 2130973395, 2130973396, 2130973397, 2130973398, 2130973400, 2130973401, 2130973403, 2130973404, 2130973406, 2130973407});
        int r110 = r20.getColor(0, 0);     // Catch: Throwable -> L269
        int r111 = r20.getColor(12, 0);     // Catch: Throwable -> L269
        int r112 = r20.getColor(1, r110);     // Catch: Throwable -> L269
        int r21 = r20.getColor(20, r12);     // Catch: Throwable -> L269
        r20.recycle();
        Integer r22 = o1.E(o1.D(r2, new String[]{"backgroundColor", "barColor", "background_color", "bar_color"}), r11.getContext());
        Integer r113 = o1.E(o1.D(r2, new String[]{"disabledBackgroundColor", "disabled_background_color"}), r11.getContext());
        Integer r114 = o1.E(o1.D(r2, new String[]{"textColor", "iconTint", "textUnselectColor", "unselectedTextColor", "text_color", "icon_tint"}), r11.getContext());
        Integer r23 = o1.E(o1.D(r2, new String[]{"pressColor", "press_color"}), r11.getContext());
        int r24 = r21;
        String r115 = "disable_gray_interaction";
        String r116 = "disableGrayInteraction";
        Boolean r117 = s.e(r2, new String[]{"disablePressEffect", "disable_press_effect", "disableGreyInteraction", "disable_gray_interaction", "disableGrayInteraction"});
        String r25 = "disable_press_effect";
        int r26 = -1;
        String r27 = "disableGreyInteraction";
        if (r22 == null) goto L84;
        int r28 = r22.intValue();
        if (r19 == false) goto L81;
        if (r28 == (-1)) goto L78;
        if (r28 == (-1)) goto L78;
        boolean r29 = false;
    L79:
        if (r29 == false) goto L81;
        boolean r30 = true;
    L82:
        if (r30 == true) goto L84;
    L85:
        if (r22 == null) goto L87;
        int r31 = r22.intValue();
    L88:
        if (r113 == null) goto L90;
        int r32 = r113.intValue();
    L91:
        if (r23 == null) goto L93;
        int r33 = r23.intValue();
    L94:
        if (r114 == null) goto L96;
        r24 = r114.intValue();
    L96:
        r11.k = r31;
        r11.l = r32;
        boolean r34 = com.obric.oui.color.h0.b(r31);
        r11.g(r34);
        if (r34 == false) goto L99;
        int r35 = 2;
    L101:
        if (r35 == r11.u) goto L103;
        r11.d(r35);
    L105:
        if (Intrinsics.areEqual(r117, Boolean.TRUE) == true) goto L125;
        if (r117 == null) goto L108;
    L123:
        if (r33 == 0) goto L126;
        r11.setPressColor(r33);
    L126:
        Context r36 = r0.getContext();
        Float r37 = s.g(o1.D(r2, new String[]{"itemSpacing", "itemGap", "spacing", "gap", "item_spacing", "item_gap"}));
        if (r37 == null) goto L129;
        r37.floatValue();
        float r38 = s.a(r36.getResources()).density;
    L129:
        Integer r39 = s.c(r0.getContext(), r2, true);
        Integer r40 = s.c(r0.getContext(), r2, false);
        int r41 = r5.size();
        if (r2.has("selectedIndex") == false) goto L132;
        int r42 = r2.optInt("selectedIndex", r1.c);
    L133:
        Integer r43 = Integer.valueOf(r42);
        int r118 = r43.intValue();
        if (r118 < 0) goto L137;
        if (r118 >= r41) goto L137;
        boolean r44 = true;
    L138:
        if (r44 == true) goto L141;
        r43 = null;
    L141:
        if (r43 == null) goto L143;
        r26 = r43.intValue();
    L143:
        Iterator r45 = r5.iterator();
        int r46 = 0;
        ?? r47 = r11;
    L145:
        if (r45.hasNext() == false) goto L267;
        Object r119 = r45.next();
        int r210 = r46 + 1;
        if (r46 >= 0) goto L149;
        CollectionsKt.throwIndexOverflow();
    L149:
        final p4 r120 = (p4) r119;
        Context r121 = r0.getContext();
        JSONObject r122 = r120.e;
        Iterator r211 = r45;
        if (r46 != r26) goto L152;
        boolean r212 = true;
    L153:
        ?? r213 = r47;
        if (r120.d == false) goto L162;
        Integer r310 = r40;
        List r311 = r5;
        Integer r48 = o1.E(o1.D(r122, new String[]{"disabledTextColor", "disabled_text_color"}), r121);
        if (r48 == null) goto L158;
        int r49 = r48.intValue();
    L161:
        Integer r214 = r39;
        String r312 = r115;
    L183:
        Context r50 = r0.getContext();
        JSONObject r51 = r120.e;
        if (r46 != r26) goto L186;
        boolean r52 = true;
    L187:
        boolean r123 = r120.d;
        String r313 = r116;
        Integer r124 = o1.E(o1.D(r51, new String[]{"iconTint", "iconColor", "icon_tint", "icon_color"}), r50);
        if (r124 == null) goto L193;
        int r53 = r124.intValue();
        if (r123 == false) goto L192;
        r53 = s.d(r53);
    L192:
        Integer r54 = Integer.valueOf(r53);
    L206:
        Context r55 = r0.getContext();
        String r56 = r120.a;
        Drawable r57 = r120.b;
        Drawable r58 = r120.c;
        if (r46 != r26) goto L209;
        boolean r125 = true;
    L211:
        if (StringsKt.isBlank(r56) == false) goto L219;
        if (r57 != null) goto L214;
        r57 = r58;
    L214:
        OUILinearLayout r59 = new OUIFrameLayout(r55, null, 0, 14);
        float r60 = 36;
        r59.setLayoutParams(new ViewGroup.MarginLayoutParams(MathKt.roundToInt(TypedValue.applyDimension(1, r60, s.a(Resources.getSystem()))), MathKt.roundToInt(TypedValue.applyDimension(1, r60, s.a(Resources.getSystem())))));
        r59.setMinimumHeight((int) ((48 * s.a(r55.getResources()).density) + 0.5f));
        float r61 = 7;
        r59.setPadding(MathKt.roundToInt(TypedValue.applyDimension(1, r61, s.a(Resources.getSystem()))), MathKt.roundToInt(TypedValue.applyDimension(1, r61, s.a(Resources.getSystem()))), MathKt.roundToInt(TypedValue.applyDimension(1, r61, s.a(Resources.getSystem()))), MathKt.roundToInt(TypedValue.applyDimension(1, r61, s.a(Resources.getSystem()))));
        r59.setClickable(true);
        r59.setRadius(MathKt.roundToInt(TypedValue.applyDimension(1, 99, s.a(Resources.getSystem()))));
        ImageView r62 = new ImageView(r55);
        r62.setImageDrawable(r57);
        if (r54 == null) goto L217;
        r62.setColorFilter(r54.intValue());
    L217:
        float r63 = 22;
        FrameLayout.LayoutParams r64 = new FrameLayout.LayoutParams(MathKt.roundToInt(TypedValue.applyDimension(1, r63, s.a(Resources.getSystem()))), MathKt.roundToInt(TypedValue.applyDimension(1, r63, s.a(Resources.getSystem()))));
        r64.gravity = 17;
        Unit r65 = Unit.INSTANCE;
        r59.addView(r62, r64);
        b r314 = r0;
        OUILinearLayout r126 = r59;
        int r315 = r26;
        r46 = r46;
    L239:
        String r66 = r25;
        String r67 = r27;
        String r68 = r312;
        Boolean r69 = s.e(r120.e, new String[]{"disablePressEffect", r66, r67, r68, r313});
        if (r69 != null) goto L244;
        r69 = s.e(r2, new String[]{"disablePressEffect", r66, r67, r68, r313});
        if (r69 != null) goto L244;
        boolean r70 = false;
    L246:
        if (r70 == false) goto L249;
        r126.setChangeAlphaWhenPress(false);
        r126.f1(true);
        r126.setOverridePressColor(0);
        r126.m1("LynxMiniAppButtonGroup");
        r126.setForeground(null);
    L249:
        if (r46 != 0) goto L252;
        if (r214 == null) goto L252;
        int r71 = r214.intValue();
    L253:
        final int r127 = r46;
        if (r127 != CollectionsKt.getLastIndex(r311)) goto L257;
        if (r310 == null) goto L257;
        int r72 = r310.intValue();
    L258:
        if (r71 != 0) goto L261;
        if (r72 != 0) goto L261;
    L262:
        r126.setEnabled(!r120.d);
        r126.isEnabled();
        if (r120.d == false) goto L265;
        float r73 = 0.45f;
    L266:
        r126.setAlpha(r73);
        r126.setOnClickListener(new t(r120, this, r127));
        ViewGroup.LayoutParams r74 = r126.getLayoutParams();
        Intrinsics.checkNotNull(r74, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        r213.D(r126, (ViewGroup.MarginLayoutParams) r74);
        r25 = r66;
        r27 = r67;
        r115 = r68;
        r116 = r313;
        r47 = r213;
        r1 = this;
        r46 = r210;
        r39 = r214;
        r45 = r211;
        r40 = r310;
        r5 = r311;
        r0 = r314;
        r26 = r315;
        goto L145
    L265:
        r73 = 1.0f;
    L261:
        r126.setPaddingRelative(r126.getPaddingStart() + r71, r126.getPaddingTop(), r126.getPaddingEnd() + r72, r126.getPaddingBottom());
    L257:
        r72 = 0;
    L252:
        r71 = 0;
    L244:
        r70 = r69.booleanValue();
        goto L246
    L219:
        r315 = r26;
        r126 = new OUILinearLayout(r55, null, 0, 14);
        r126.setLayoutParams(new ViewGroup.MarginLayoutParams(-2, -2));
        r126.setMinimumHeight((int) ((48 * s.a(r55.getResources()).density) + 0.5f));
        float r75 = 7;
        r314 = r0;
        r126.setPadding(MathKt.roundToInt(TypedValue.applyDimension(1, r75, s.a(Resources.getSystem()))), 0, MathKt.roundToInt(TypedValue.applyDimension(1, r75, s.a(Resources.getSystem()))), 0);
        r126.setClickable(true);
        r126.setRadius(MathKt.roundToInt(TypedValue.applyDimension(1, 99, s.a(Resources.getSystem()))));
        r126.setOrientation(0);
        r126.setGravity(16);
        if (r57 == null) goto L226;
        ImageView r128 = new ImageView(r55);
        r128.setImageDrawable(r57);
        if (r54 == null) goto L224;
        r128.setColorFilter(r54.intValue());
    L224:
        float r76 = 20;
        LinearLayout.LayoutParams r77 = new LinearLayout.LayoutParams(MathKt.roundToInt(TypedValue.applyDimension(1, r76, s.a(Resources.getSystem()))), MathKt.roundToInt(TypedValue.applyDimension(1, r76, s.a(Resources.getSystem()))));
        r77.gravity = 16;
        r77.setMarginEnd(MathKt.roundToInt(TypedValue.applyDimension(1, 4, s.a(Resources.getSystem()))));
        Unit r78 = Unit.INSTANCE;
        r126.addView(r128, r77);
    L226:
        OTextView r79 = new OTextView(r55, null, 0, 14);
        r79.setText(r56);
        r79.setGravity(17);
        float r80 = 4;
        r79.setPadding(MathKt.roundToInt(TypedValue.applyDimension(1, r80, s.a(Resources.getSystem()))), 0, MathKt.roundToInt(TypedValue.applyDimension(1, r80, s.a(Resources.getSystem()))), 0);
        r79.setSingleLine(true);
        r79.setMinHeight(MathKt.roundToInt(TypedValue.applyDimension(1, 22, s.a(Resources.getSystem()))));
        if (r125 == false) goto L229;
        int r81 = 2131953751;
    L230:
        r79.setTextAppearance(r81);
        if (r49 == 0) goto L233;
        r79.setTextColor(r49);
    L233:
        LinearLayout.LayoutParams r82 = new LinearLayout.LayoutParams(-2, -2);
        r82.gravity = 16;
        Unit r83 = Unit.INSTANCE;
        r126.addView(r79, r82);
        if (r58 == null) goto L239;
        ImageView r84 = new ImageView(r55);
        r84.setImageDrawable(r58);
        if (r54 == null) goto L238;
        r84.setColorFilter(r54.intValue());
    L238:
        float r85 = 20;
        LinearLayout.LayoutParams r86 = new LinearLayout.LayoutParams(MathKt.roundToInt(TypedValue.applyDimension(1, r85, s.a(Resources.getSystem()))), MathKt.roundToInt(TypedValue.applyDimension(1, r85, s.a(Resources.getSystem()))));
        r86.gravity = 16;
        r86.setMarginStart(MathKt.roundToInt(TypedValue.applyDimension(1, r80, s.a(Resources.getSystem()))));
        r126.addView(r84, r86);
        goto L239
    L229:
        r81 = 2131951950;
        goto L230
    L209:
        r125 = false;
        goto L211
    L193:
        Integer r87 = o1.E(o1.D(r2, new String[]{"iconTint", "iconColor", "icon_tint", "icon_color"}), r50);
        if (r87 == null) goto L200;
        int r88 = r87.intValue();
        if (r123 == false) goto L198;
        r88 = s.d(r88);
    L198:
        r54 = Integer.valueOf(r88);
        goto L206
    L200:
        if (s.b(r51, r52, r123) == false) goto L202;
    L205:
        r54 = Integer.valueOf(r49);
        goto L206
    L202:
        if (s.b(r2, r52, r123) == true) goto L205;
        r54 = null;
        goto L206
    L186:
        r52 = false;
        goto L187
    L158:
        Integer r89 = o1.E(o1.D(r2, new String[]{"disabledTextColor", "disabled_text_color"}), r121);
        if (r89 == null) goto L163;
        r49 = r89.intValue();
    L163:
        if (r212 == false) goto L170;
        r214 = r39;
        r312 = r115;
        Integer r129 = o1.E(o1.D(r122, new String[]{"textSelectColor", "selectedTextColor", "text_select_color", "selected_text_color"}), r121);
        if (r129 == null) goto L167;
        r49 = r129.intValue();
        goto L183
    L167:
        Integer r90 = o1.E(o1.D(r2, new String[]{"textSelectColor", "selectedTextColor", "text_select_color", "selected_text_color"}), r121);
        if (r90 == null) goto L176;
        r49 = r90.intValue();
    L176:
        Integer r91 = o1.E(o1.D(r122, new String[]{"textColor", "iconTint", "text_color", "icon_tint"}), r121);
        if (r91 == null) goto L179;
        r49 = r91.intValue();
        goto L183
    L179:
        Integer r92 = o1.E(o1.D(r2, new String[]{"textColor", "iconTint", "text_color", "icon_tint"}), r121);
        if (r92 == null) goto L182;
        r49 = r92.intValue();
        goto L183
    L182:
        r49 = r24;
        goto L183
    L170:
        r214 = r39;
        r312 = r115;
        Integer r130 = o1.E(o1.D(r122, new String[]{"textUnselectColor", "unselectedTextColor", "text_unselect_color", "unselected_text_color"}), r121);
        if (r130 == null) goto L173;
        r49 = r130.intValue();
        goto L183
    L173:
        Integer r93 = o1.E(o1.D(r2, new String[]{"textUnselectColor", "unselectedTextColor", "text_unselect_color", "unselected_text_color"}), r121);
        if (r93 == null) goto L176;
        r49 = r93.intValue();
        goto L183
    L162:
        r311 = r5;
        r310 = r40;
        goto L163
    L152:
        r212 = false;
        goto L153
    L267:
        FrameLayout.LayoutParams r94 = new FrameLayout.LayoutParams(-2, -2);
        r94.gravity = 17;
        Unit r95 = Unit.INSTANCE;
        r0.addView(r47, r94);
        return;
    L137:
        r44 = false;
        goto L138
    L132:
        r42 = r1.c;
        goto L133
    L108:
        if (Color.alpha(r31) == 0) goto L120;
        float[] r96 = new float[3];
        Color.colorToHSV(r31, r96);
        if (r96[1] > 0.12f) goto L120;
        float r97 = r96[2];
        if (0.35f <= r97) goto L115;
    L117:
        boolean r98 = false;
    L118:
        if (r98 == false) goto L120;
        boolean r99 = true;
    L121:
        if (r99 == false) goto L123;
    L115:
        if (r97 > 0.98f) goto L117;
        r98 = true;
    L120:
        r99 = false;
    L125:
        r11.setPressColor(0);
        goto L126
    L103:
        r11.t(r11.isEnabled());
        goto L105
    L99:
        r35 = 1;
        goto L101
    L93:
        r33 = r111;
        goto L94
    L90:
        r32 = r112;
        goto L91
    L87:
        r31 = r110;
    L78:
        r29 = true;
    L81:
        r30 = false;
    L84:
        r22 = null;
    L269:
        th = move-exception;
        r20.recycle();
        throw th;
    L67:
        r19 = false;
        goto L68
    L63:
        r18 = 2131952740;
        goto L65
    L54:
        r17 = false;
        goto L55
    L60:
        r16 = null;
        goto L61
    L47:
        r14 = CollectionsKt.listOf("OFloatingTitleBar_Action_Standard");
        goto L48
    L43:
        Intrinsics.areEqual(r8, "M");
        r9 = 2131564151;
    L15:
        List r100 = CollectionsKt.createListBuilder();
        int r101 = r4.length();
        int r131 = 0;
    L16:
        if (r131 >= r101) goto L36;
        JSONObject r132 = r4.optJSONObject(r131);
        String r133 = r4.optString(r131);
        Intrinsics.checkNotNull(r133);
        if ((StringsKt.isBlank(r133) ^ r7) == true) goto L22;
        r133 = null;
    L22:
        if (r132 != null) goto L26;
        r132 = new JSONObject();
        if (r133 == null) goto L26;
        r132.put("title", r133);
    L26:
        String r102 = s.f(r132, new String[]{"title", "label", "text", "name", "value"});
        if (r102 != null) goto L29;
        r102 = "";
    L29:
        String r134 = r102;
        Drawable r135 = s.i(r3, r132, new String[]{"icon"}, new String[]{"iconResId"}, new String[]{"iconResName"});
        Drawable r136 = s.i(r3, r132, new String[]{"tailIcon"}, new String[]{"tailIconResId"}, new String[]{"tailIconResName"});
        boolean r137 = r132.optBoolean("disabled", false);
        if (StringsKt.isBlank(r134) == false) goto L34;
        if (r135 != null) goto L34;
        if (r136 != null) goto L34;
    L35:
        r131 = r131 + 1;
        r7 = true;
    L34:
        r100.add(new p4(r134, r135, r136, r137, r132));
        goto L35
    L36:
        r5 = CollectionsKt.build(r100);
        goto L37
    }

    public final void onNodeReload() {
        super/*com.lynx.tasm.behavior.ui.LynxBaseUI*/.onNodeReload();
        M();
    }

    public LynxMiniAppButtonGroupUI(LynxContext r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.c = -1;
        if (r2.getDefaultOverflowVisible() == false) goto L6;
        ((LynxBaseUI) this).mOverflow = 3;
        return;
    }

    public final View createView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        b r0 = new b(r4);
        Resources r1 = Resources.getSystem();
        r0.setMinimumHeight(MathKt.roundToInt(TypedValue.applyDimension(1, 48, WindowDisplayMetricsOverride.apply(r1, r1.getDisplayMetrics()))));
        r0.setClipChildren(false);
        r0.setClipToPadding(false);
        this.a = r0;
        return r0;
    }

    @LynxProp(name = "options")
    public final void setOptions(String r3) {
        JSONObject r0 = null;
        Object r1 = null;
        r0 = null;
        if (r3 != null) goto L5;
    L18:
        this.b = r0;
        M();
        return;
    L5:
        if ((!StringsKt.isBlank(r3)) == true) goto L8;
        r3 = null;
    L8:
        if (r3 == null) goto L18;
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L11
        Object r4 = Result.constructor-impl(new JSONObject(r3));     // Catch: Throwable -> L11
    L13:
        Result.exceptionOrNull-impl(r4);
        if (Result.isFailure-impl(r4) == true) goto L17;
        r1 = r4;
    L17:
        r0 = (JSONObject) r1;
    L11:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        r4 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L13
    }

    @LynxProp(name = "selectedIndex")
    public final void setSelectedIndex(int r1) {
        this.c = r1;
        M();
    }

    public final void updatePropertiesInterval(com.lynx.tasm.behavior.x0 r32) {
        Intrinsics.checkNotNullParameter(r32, "props");
        super/*com.lynx.tasm.behavior.ui.LynxBaseUI*/.updatePropertiesInterval(o1.S(r32, this.b, new String[]{"items", "titles", "actions", "selectedIndex", "itemSpacing", "itemGap", "spacing", "gap", "horizontalPadding", "horizontalInset", "paddingStart", "paddingEnd", "paddingLeft", "paddingRight", "leftPadding", "rightPadding", "textColor", "iconTint", "backgroundColor", "barColor", "disabledTextColor", "textSelectColor", "selectedTextColor", "textUnselectColor", "unselectedTextColor", "disablePressEffect", "disableGreyInteraction", "disableGrayInteraction"}, new String[]{"items", "titles", "actions"}, 2));
    }
}
