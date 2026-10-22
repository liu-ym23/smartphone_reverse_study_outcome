package com.obric.miniapp.lynx;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.larus.utils.logger.FLogger;
import com.lynx.tasm.EventEmitter;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxProp;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.LynxUI;
import com.lynx.tasm.behavior.ui.UIGroup;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.assistant.interaction.impl.window.event.WindowEvent;
import com.obric.assistant.interaction.impl.window.helpers.OverlaySource;
import com.obric.assistant.interaction.impl.window.helpers.PopupWindowLancet;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildPopupWindowBoundsAdapter;
import com.obric.capabilitykit.common.ErrorCode;
import com.obric.oui.popover.menu.OPopoverEntranceMenuView;
import com.obric.oui.popover.menu.PopoverMenuLinearLayout;
import com.obric.oui.popover.v2.OPopoverBase;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 K2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001KB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0016H\u0014J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0012\u0010\u001b\u001a\u00020\u00182\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0007J\u0010\u0010\u001e\u001a\u00020\u00182\u0006\u0010\u001f\u001a\u00020\rH\u0007J\u0012\u0010 \u001a\u00020\u00182\b\u0010!\u001a\u0004\u0018\u00010\u001dH\u0007J\u0012\u0010\"\u001a\u00020\u00182\b\u0010#\u001a\u0004\u0018\u00010\u001dH\u0007J\u0012\u0010$\u001a\u00020\u00182\b\u0010%\u001a\u0004\u0018\u00010\u001dH\u0007J\u0012\u0010&\u001a\u00020\u00182\b\u0010'\u001a\u0004\u0018\u00010\u001dH\u0007J\b\u0010(\u001a\u00020\u0018H\u0016J\u0014\u0010)\u001a\u00020\u00182\n\u0010*\u001a\u0006\u0012\u0002\b\u00030+H\u0016J\b\u0010,\u001a\u00020\u0018H\u0002J\b\u0010-\u001a\u00020\rH\u0002J\u0010\u0010.\u001a\u00020\r2\u0006\u0010/\u001a\u00020\tH\u0002J\b\u00100\u001a\u00020\u0018H\u0002J0\u00101\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u00102\u001a\u0002032\u0006\u0010%\u001a\u0002042\u0006\u00105\u001a\u0002042\u0006\u0010/\u001a\u00020\tH\u0002J\b\u00106\u001a\u00020\u0018H\u0002J\u001e\u00107\u001a\u00020\u00182\u0006\u00108\u001a\u0002092\f\u0010:\u001a\b\u0012\u0004\u0012\u0002040;H\u0002J$\u0010<\u001a\u00020\u00182\u0006\u00108\u001a\u0002092\u0012\u0010=\u001a\u000e\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u00020\u001d0>H\u0002J$\u0010?\u001a\u00020\u00182\u0006\u00108\u001a\u0002092\u0012\u0010@\u001a\u000e\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u0002040>H\u0002J\u0012\u0010A\u001a\u00020\u00182\b\u0010B\u001a\u0004\u0018\u00010\u001dH\u0002J$\u0010C\u001a\u00020\u00182\u0006\u0010D\u001a\u0002042\b\u0010E\u001a\u0004\u0018\u00010\u001d2\b\u0010F\u001a\u0004\u0018\u00010\u001dH\u0002J\u0010\u0010G\u001a\u00020\u00182\u0006\u0010H\u001a\u00020\u001dH\u0002J\u0014\u0010I\u001a\u0004\u0018\u00010J2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0016H\u0002R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0002X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006L"}, d2 = {"Lcom/obric/miniapp/lynx/LynxOUIPopoverUI;", "Lcom/lynx/tasm/behavior/ui/UIGroup;", "Landroid/widget/FrameLayout;", "context", "Lcom/lynx/tasm/behavior/LynxContext;", "<init>", "(Lcom/lynx/tasm/behavior/LynxContext;)V", "root", "optionsJson", "Lorg/json/JSONObject;", "popover", "Lcom/obric/oui/popover/v2/OPopover;", "hasSelected", "", "visibleCache", "pendingShow", "menuWidthDp", "", "Ljava/lang/Float;", "showRunnable", "Ljava/lang/Runnable;", "createView", "Landroid/content/Context;", "updatePropertiesInterval", "", "props", "Lcom/lynx/tasm/behavior/StylesDiffMap;", "setOptions", "options", "", "setVisible", "visible", "setPlacement", "placement", "setPosition", "position", "setGravity", "gravity", "setMenuWidth", "width", "destroy", "insertView", "child", "Lcom/lynx/tasm/behavior/ui/LynxUI;", "scheduleShow", "shouldDeferShowUntilAfterTap", "hasCustomPopoverPosition", "json", "showIfPossible", "showPopoverAtCustomPosition", "anchor", "Landroid/view/View;", "", "marginPx", "dismiss", "suppressPopoverSelectionIndicators", "menuView", "Lcom/obric/oui/popover/menu/OPopoverEntranceMenuView;", "rowIndices", "", "applyPopoverTrailingTexts", "rowTrailingTexts", "", "applyPopoverTitleColors", "rowTitleColors", "updatePlacement", "rawValue", "sendSelectEvent", "index", "title", "value", "sendSimpleEvent", "type", "findActivity", "Landroid/app/Activity;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LynxOUIPopoverUI extends UIGroup<FrameLayout> {
    public static final /* synthetic */ int i = 0;
    public FrameLayout a;
    public JSONObject b;
    public com.obric.oui.popover.v2.c c;
    public boolean d;
    public boolean e;
    public boolean f;
    public Float g;
    public final p3 h;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;
        public static final /* synthetic */ int[] b = null;

        static {
            int[] r0 = new int[PopoverOptionMode.values().length];
            r0[PopoverOptionMode.NONE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
        L17:
            r0[PopoverOptionMode.SINGLE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
        L23:
            r0[PopoverOptionMode.MULTI.ordinal()] = 3;     // Catch: NoSuchFieldError -> L14
        L7:
            a = r0;
            int[] r1 = new int[PopoverOptionPosition.values().length];
            r1[PopoverOptionPosition.RIGHT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L15
        L19:
            r1[PopoverOptionPosition.LEFT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L16
        L10:
            b = r1;
        }
    }

    public static final class c implements com.obric.oui.popover.v2.c.c {
        public final /* synthetic */ LynxOUIPopoverUI a;

        public final void bubbleDismiss() {
            LynxOUIPopoverUI r0 = this.a;
            r0.c = null;
            if (r0.d == true) goto L11;
            LynxContext r1 = r0.getLynxContext();
            if (r1 == null) goto L12;
            EventEmitter r2 = r1.getEventEmitter();
            if (r2 == null) goto L13;
            r2.sendCustomEvent(new m7a.a(r0.getSign(), WindowEvent.WindowOpenPerfResult.CANCEL));
            return;
        L13:
            return;
        L12:
            return;
        }

        public c(LynxOUIPopoverUI r1) {
            this.a = r1;
        }
    }

    static {
    }

    public final void O() {
        this.f = false;
        FrameLayout r0 = this.a;
        if (r0 == null) goto L16;
        r0.removeCallbacks(this.h);
    L16:
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L12
        com.obric.oui.popover.v2.c r2 = this.c;     // Catch: Throwable -> L12
        if (r2 == null) goto L9;
        PopupWindowLancet.handleDismissBeforeOrigin(r2);     // Catch: Throwable -> L12
        r2.dismiss();     // Catch: Throwable -> L12
        Unit r3 = Unit.INSTANCE;     // Catch: Throwable -> L12
    L10:
        Result.constructor-impl(r3);     // Catch: Throwable -> L12
    L14:
        this.c = null;
        return;
    L9:
        r3 = null;
    L12:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L14
    }

    public final void destroy() {
        this.e = false;
        O();
        FrameLayout r0 = this.a;
        if (r0 == null) goto L5;
        r0.removeCallbacks(this.h);
    L5:
        this.a = null;
        super.destroy();
    }

    public final void Q() {
        FrameLayout r0 = this.a;
        if (r0 != null) goto L6;
        return;
    L6:
        if (r0.isAttachedToWindow() == false) goto L21;
        if (r0.isLaidOut() == false) goto L21;
        JSONObject r1 = this.b;
        if (r1 != null) goto L12;
        boolean r2 = false;
    L16:
        if (r2 == true) goto L21;
        S();
        return;
    L12:
        Boolean r3 = o1.B(r1, new String[]{"popoverDeferShow", "deferShow", "showAfterTap", "popover_defer_show", "show_after_tap"});
        if (r3 == null) goto L15;
        r2 = r3.booleanValue();
        goto L16
    L15:
        r2 = P(r1);
    L21:
        if (this.f == true) goto L24;
        this.f = true;
        r0.post(this.h);
        return;
    }

    public final void S() {
        FrameLayout r3 = this.a;
        if (r3 != null) goto L6;
        return;
    L6:
        if (this.e == true) goto L8;
        return;
    L8:
        JSONObject r0 = this.b;
        if (r0 != null) goto L11;
        return;
    L11:
        JSONArray r2 = r0.optJSONArray("items");
        if (r2 != null) goto L15;
        return;
    L15:
        if (r3.isAttachedToWindow() == true) goto L18;
        Q();
        return;
    L18:
        String r4 = o1.C(r0, new String[]{"placement", "position", "gravity"});
        if (r4 == null) goto L23;
        String r5 = StringsKt.trim(r4).toString();
        if (r5 == null) goto L23;
        String r6 = r5.toLowerCase(Locale.ROOT);
    L24:
        String r7 = "right";
        String r8 = "end";
        if (r6 != null) goto L27;
    L50:
        int r9 = 80;
    L51:
        O();
        this.d = false;
        Context r10 = r3.getContext();
    L53:
        if ((r10 instanceof ContextWrapper) == false) goto L59;
        if ((r10 instanceof Activity) == true) goto L56;
        r10 = ((ContextWrapper) r10).getBaseContext();
        goto L53
    L56:
        final Activity r11 = (Activity) r10;
    L62:
        String r15 = "LynxOUIPopoverUI";
        if (r11 != null) goto L66;
        FLogger.a.w("LynxOUIPopoverUI", "show popover failed: activity is null");
        return;
    L66:
        OPopoverEntranceMenuView.Builder r14 = new OPopoverEntranceMenuView.Builder(r11);
        Float r12 = o1.F(o1.D(r0, new String[]{"itemPaddingStartDelta", "item_padding_start_delta", "itemPaddingLeftDelta", "item_padding_left_delta"}));
        if (r12 == null) goto L69;
        float r13 = r12.floatValue();
    L70:
        Float r16 = Float.valueOf(r13);
        if (r16.floatValue() <= 0.0f) goto L73;
        boolean r17 = true;
    L74:
        if (r17 == true) goto L77;
        r16 = null;
    L77:
        if (r16 == null) goto L79;
        final Integer r18 = Integer.valueOf(o1.s(r3.getContext(), r16.floatValue()));
    L80:
        if (r18 == null) goto L82;
        Function1 r19 = new i3(r18);
        Intrinsics.checkNotNullParameter(r19, "process");
        r14.b = r19;
    L82:
        Float r20 = this.g;
        if (r20 != null) goto L91;
        Double r21 = Double.valueOf(r0.optDouble("menuWidth"));
        if (Double.isNaN(r21.doubleValue()) == false) goto L88;
        r21 = null;
    L88:
        if (r21 == null) goto L90;
        r20 = Float.valueOf((float) r21.doubleValue());
        goto L91
    L90:
        r20 = null;
    L91:
        if (r20 != null) goto L93;
    L99:
        String r22 = o1.C(r0, new String[]{"optionMode", "selectionMode", "checkMode"});
        if (r22 == null) goto L104;
        String r23 = StringsKt.trim(r22).toString();
        if (r23 == null) goto L104;
        String r24 = r23.toLowerCase(Locale.ROOT);
    L105:
        String r25 = "type";
        if (r24 == null) goto L134;
        switch(r24.hashCode()) {
            case -1849881029: goto L130;
            case -902265784: goto L126;
            case 104256825: goto L123;
            case 108270587: goto L120;
            case 653829648: goto L117;
            case 1536891843: goto L114;
            case 2121932876: goto L111;
            default: goto L134;
        };
    L111:
        if (r24.equals("single_option") == false) goto L134;
    L128:
        b6 r26 = new b6(PopoverOptionMode.SINGLE, true);
    L155:
        final LinkedHashMap r27 = new LinkedHashMap();
        final LinkedHashMap r110 = new LinkedHashMap();
        r14.f = new j3(r27, r11);
        r14.g = new k3(r110, r11);
        ArrayList r111 = new ArrayList();
        LinkedHashMap r112 = new LinkedHashMap();
        int r28 = r9;
        LinkedHashMap r29 = new LinkedHashMap();
        int r30 = r2.length();
        int r1 = 0;
        int r113 = 0;
        boolean r31 = false;
    L156:
        if (r1 >= r30) goto L326;
        int r32 = r30;
        JSONObject r33 = r2.optJSONObject(r1);
        if (r33 != null) goto L162;
        JSONArray r34 = r2;
        String r35 = r25;
        LinkedHashMap r114 = r112;
        ArrayList r115 = r111;
    L160:
        LinkedHashMap r210 = r110;
        String r211 = r15;
    L195:
        String r116 = r7;
        Activity r45 = r11;
        LinkedHashMap r36 = r114;
        ArrayList r37 = r115;
        LinkedHashMap r40 = r210;
        String r44 = r211;
        String r117 = r8;
        OPopoverEntranceMenuView.Builder r46 = r14;
        final int r118 = r1;
        OPopoverEntranceMenuView.Builder r38 = r46;
    L325:
        int r39 = r118 + 1;
        r14 = r38;
        r111 = r37;
        r1 = r39;
        r112 = r36;
        r8 = r117;
        r7 = r116;
        r30 = r32;
        r2 = r34;
        r25 = r35;
        r110 = r40;
        r27 = r27;
        r15 = r44;
        r11 = r45;
        goto L156
    L162:
        r34 = r2;
        String r41 = StringsKt.trim(r33.optString(r25)).toString();
        r35 = r25;
        Locale r42 = Locale.ROOT;
        String r43 = r41.toLowerCase(r42);
        r114 = r112;
        if (Intrinsics.areEqual(r43, "divider") == true) goto L168;
        r115 = r111;
        if (r33.optBoolean("divider", false) == true) goto L169;
        boolean r119 = false;
    L170:
        if (r119 == false) goto L172;
        r14.c.add(OPopoverEntranceMenuView.b.n);
        goto L160
    L172:
        r210 = r110;
        if (Intrinsics.areEqual(r43, "section") == false) goto L175;
    L184:
        boolean r120 = true;
    L185:
        r211 = r15;
        r8 = r8;
        if (r120 == false) goto L196;
        String r47 = o1.C(r33, new String[]{"sectionTitle", "title", "label", "text"});
        if (r47 == null) goto L195;
        if ((!StringsKt.isBlank(r47)) == true) goto L193;
        r47 = null;
    L193:
        if (r47 == null) goto L195;
        Intrinsics.checkNotNullParameter(r47, "title");
        r14.c.add(new OPopoverEntranceMenuView.b(r47, true, 2, 12288));
        Unit r48 = Unit.INSTANCE;
        goto L195
    L196:
        final String r49 = o1.C(r33, new String[]{"title", "label", "text", "name"});
        if (r49 != null) goto L199;
        r49 = "";
    L199:
        String r212 = o1.C(r33, new String[]{"subTitle", "subtitle", "description"});
        final String r121 = o1.C(r33, new String[]{"value", "detail", "trailingText"});
        String r122 = o1.C(r33, new String[]{"trailingText", "rightText", "tailText", "detail"});
        if (r122 != null) goto L202;
        String r213 = r121;
    L203:
        boolean r214 = r33.optBoolean("highlighted", false);
        OPopoverEntranceMenuView.Builder r310 = r14;
        String r311 = r7;
        r37 = r115;
        r40 = r210;
        r36 = r114;
        r44 = r211;
        int r123 = o1.m(r11, r33, r27, new String[]{"iconRes", "icon"}, new String[]{"iconResId"}, new String[]{"iconResName", "builtinIcon", "iconBuiltin", "iconName"});
        int r312 = r1;
        int r50 = o1.m(r11, r33, r40, new String[]{"tailIconRes", "tailIcon"}, new String[]{"tailIconResId"}, new String[]{"tailIconResName", "tailBuiltinIcon", "builtinTailIcon", "tailIconName"});
        Integer r124 = o1.E(r33.opt("iconTint"), r11);
        if (r124 == null) goto L206;
        int r125 = r124.intValue();
    L207:
        Integer r126 = o1.E(r33.opt("titleColor"), r11);
        int r127 = r113 + 1;
        if (r126 == null) goto L210;
        r36.put(Integer.valueOf(r113), r126);
    L210:
        PopoverOptionMode r128 = r26.a;
        PopoverOptionMode r129 = PopoverOptionMode.NONE;
        if (r128 == r129) goto L221;
        if (r122 != null) goto L214;
    L217:
        boolean r130 = true;
    L218:
        if (r130 == true) goto L221;
        r29.put(Integer.valueOf(r113), r122);
        goto L221
    L214:
        if (StringsKt.isBlank(r122) == true) goto L217;
        r130 = false;
    L221:
        if (Intrinsics.areEqual(r43, "arrow") == false) goto L223;
    L230:
        int r313 = r127;
    L231:
        boolean r131 = true;
    L232:
        if (r50 == 0) goto L234;
        int r51 = r50;
    L237:
        boolean r52 = !r33.optBoolean("selectable", true);
        if (r52 == false) goto L240;
        r45 = r11;
    L243:
        boolean r215 = false;
    L244:
        Boolean r132 = o1.B(r33, new String[]{"checkable", "enableCheckable"});
        boolean r53 = o1.y(r43, r33);
        if (r52 == false) goto L248;
    L249:
        boolean r54 = false;
    L258:
        if (r26.a == r129) goto L261;
        if (r52 == false) goto L261;
        r37.add(Integer.valueOf(r113));
    L261:
        PopoverOptionMode r55 = r26.a;
        if (r55 == r129) goto L320;
        if (r31 == true) goto L272;
        int r56 = b.a[r55.ordinal()];
        if (r56 != 2) goto L267;
        r38 = r310;
        r38.e = 1;
        Unit r133 = Unit.INSTANCE;
    L271:
        r31 = true;
    L273:
        r118 = r312;
        Function2 r134 = new l3(this, r118, r49, r121);
        if (r33.optBoolean("rightOption", false) == false) goto L277;
        PopoverOptionPosition r57 = PopoverOptionPosition.RIGHT;
    L279:
        String r135 = r8;
        r116 = r311;
    L307:
        int r58 = b.b[r57.ordinal()];
        if (r58 != 1) goto L310;
        Integer r136 = Integer.valueOf(r123);
        Integer r216 = Integer.valueOf(r51);
        Integer r217 = Integer.valueOf(r125);
        if (r215 == false) goto L317;
        int r137 = 6;
    L318:
        r38.a(r137, r54, r136, r216, r217, r49, r212, null, r214, null, r134);
    L319:
        r117 = r135;
    L324:
        r113 = r313;
        goto L325
    L317:
        r137 = 2;
        goto L318
    L310:
        if (r58 != 2) goto L313;
        r38.c(Integer.valueOf(r123), Integer.valueOf(r51), Integer.valueOf(r125), r49, r212, r214, r54, r215, r134);
        goto L319
    L313:
        throw new NoWhenBranchMatchedException();
    L277:
        if (r33.optBoolean("leftOption", false) == false) goto L280;
        r57 = PopoverOptionPosition.LEFT;
        goto L279
    L280:
        String r59 = o1.C(r33, new String[]{"optionPosition", "option", "checkPosition"});
        if (r59 == null) goto L285;
        String r60 = StringsKt.trim(r59).toString();
        if (r60 == null) goto L285;
        String r61 = r60.toLowerCase(r42);
    L286:
        if (r61 == null) goto L305;
        int r138 = r61.hashCode();
        if (r138 != 100571) goto L290;
        r135 = r8;
        r116 = r311;
        if (r61.equals(r135) == false) goto L306;
    L304:
        r57 = PopoverOptionPosition.RIGHT;
    L306:
        r57 = PopoverOptionPosition.LEFT;
        goto L307
    L290:
        if (r138 != 3552336) goto L292;
        r116 = r311;
        if (r61.equals("tail") == true) goto L300;
    L299:
        r135 = r8;
    L300:
        r135 = r8;
        goto L304
    L292:
        if (r138 != 108511772) goto L305;
        r116 = r311;
        if (r61.equals(r116) == false) goto L299;
    L305:
        r135 = r8;
        r116 = r311;
    L285:
        r61 = null;
        goto L286
    L267:
        if (r56 == 3) goto L269;
        Unit r62 = Unit.INSTANCE;
        r38 = r310;
        goto L271
    L269:
        r38 = r310;
        r38.e = 2;
        Unit r139 = Unit.INSTANCE;
        goto L271
    L272:
        r38 = r310;
        goto L273
    L320:
        r117 = r8;
        r118 = r312;
        r116 = r311;
        r38 = r310;
        if (r126 == null) goto L323;
        Integer r140 = Integer.valueOf(r123);
        Integer r218 = Integer.valueOf(r51);
        Integer r219 = Integer.valueOf(r125);
        int r63 = r126.intValue();
        String r220 = r49;
        String r221 = r213;
        r38.a(0, false, r140, r218, r219, r220, r212, r221, r214, Integer.valueOf(r63), new m3(this, r118, r49, r121));
        goto L324
    L323:
        r38.b(Integer.valueOf(r123), Integer.valueOf(r51), Integer.valueOf(r125), r49, r212, r213, r214, new n3(this, r118, r49, r121));
        goto L324
    L248:
        if (b.a[r26.a.ordinal()] == 1) goto L249;
        if (r132 == null) goto L252;
        r54 = r132.booleanValue();
        goto L258
    L252:
        if (r53 == true) goto L256;
        if (r215 == true) goto L256;
        r54 = r26.b;
    L256:
        r54 = true;
        goto L258
    L240:
        r45 = r11;
        Boolean r141 = o1.B(r33, new String[]{"checked", "selected", "isChecked"});
        if (r141 == null) goto L243;
        r215 = r141.booleanValue();
        goto L244
    L234:
        if (r131 == false) goto L236;
        r51 = 2131244160;
        goto L237
    L236:
        r51 = 0;
        goto L237
    L223:
        if (Intrinsics.areEqual(r43, "arrow_item") == true) goto L230;
        r313 = r127;
        if (r33.optBoolean("showArrow", false) == true) goto L231;
        if (r33.optBoolean("arrow", false) == true) goto L231;
        r131 = false;
        goto L232
    L206:
        r125 = 0;
        goto L207
    L202:
        r213 = r122;
        goto L203
    L175:
        if (Intrinsics.areEqual(r43, "section_title") == true) goto L184;
        if (Intrinsics.areEqual(r43, "sectiontitle") == true) goto L184;
        if (r33.optBoolean("section", false) == true) goto L184;
        if ((!StringsKt.isBlank(r33.optString("sectionTitle"))) == true) goto L184;
        r120 = false;
    L169:
        r119 = true;
        goto L170
    L168:
        r115 = r111;
        goto L169
    L326:
        LinkedHashMap r64 = r112;
        ArrayList r65 = r111;
        String r410 = r15;
        OPopoverEntranceMenuView r66 = r14.e();
        M(r66, r64);
        N(r66, r29);
        U(r66, r65);
        com.obric.oui.popover.v2.c.a r67 = new com.obric.oui.popover.v2.c.a(r11);
        Intrinsics.checkNotNullParameter(r66, "view");
        ((com.obric.oui.popover.v2.h) r67).f = r66;
        c r68 = new c(this);
        Intrinsics.checkNotNullParameter(r68, "listener");
        ((com.obric.oui.popover.v2.h) r67).g = r68;
        com.obric.oui.popover.v2.c r69 = r67.a();
        this.c = r69;
        Result.Companion r70 = Result.Companion;     // Catch: Throwable -> L337
        Float r71 = o1.F(o1.D(r0, new String[]{"margin", "anchorMargin", "anchor_margin", "popoverMargin", "popover_margin"}));     // Catch: Throwable -> L337
        if (r71 == null) goto L330;
        float r72 = r71.floatValue();     // Catch: Throwable -> L337
    L331:
        int r73 = o1.s(r3.getContext(), r72);     // Catch: Throwable -> L337
        if (T(r69, r3, r28, r73, r0) == true) goto L335;
        com.obric.oui.popover.v2.i.c(r69, r3, r28, r73, false, 224);     // Catch: Throwable -> L337
    L335:
        M(r66, r64);     // Catch: Throwable -> L337
        N(r66, r29);     // Catch: Throwable -> L337
        U(r66, r65);     // Catch: Throwable -> L337
        Object r74 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L337
    L339:
        Throwable r75 = Result.exceptionOrNull-impl(r74);
        if (r75 == null) goto L355;
        FLogger.a.e(r410, "show popover failed", r75);
        this.c = null;
        return;
    L355:
        return;
    L330:
        r72 = 12.0f;
    L337:
        th = move-exception;
        Result.Companion r76 = Result.Companion;
        r74 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L339
    L114:
        if (r24.equals("checkbox") == false) goto L134;
    L132:
        r26 = new b6(PopoverOptionMode.MULTI, true);
        goto L155
    L117:
        if (r24.equals("multiple") == true) goto L132;
    L120:
        if (r24.equals("radio") == true) goto L128;
    L123:
        if (r24.equals("multi") == true) goto L132;
    L126:
        if (r24.equals("single") == true) goto L128;
    L130:
        if (r24.equals("multi_option") == true) goto L132;
    L134:
        if (r0.optBoolean("multiOption", false) == false) goto L136;
    L154:
        r26 = new b6(PopoverOptionMode.MULTI, true);
        goto L155
    L136:
        if (r0.optBoolean("allowMultiple", false) == true) goto L154;
        if (r0.optBoolean("singleOption", false) == false) goto L141;
    L153:
        r26 = new b6(PopoverOptionMode.SINGLE, true);
        goto L155
    L141:
        if (r0.optBoolean("optionMenu", false) == true) goto L153;
        int r77 = r2.length();
        int r78 = 0;
    L144:
        if (r78 >= r77) goto L152;
        JSONObject r142 = r2.optJSONObject(r78);
        if (r142 == null) goto L151;
        if (o1.y(StringsKt.trim(r142.optString("type")).toString().toLowerCase(Locale.ROOT), r142) == false) goto L151;
        r26 = new b6(PopoverOptionMode.SINGLE, false);
    L151:
        r78 = r78 + 1;
        goto L144
    L152:
        r26 = new b6(PopoverOptionMode.NONE, false);
    L104:
        r24 = null;
        goto L105
    L93:
        if (r20.floatValue() <= 0.0f) goto L99;
        Float r79 = o1.F(o1.D(r0, new String[]{"menuWidthDelta", "menuWidthExtra", "menu_width_delta", "menu_width_extra"}));
        if (r79 == null) goto L97;
        float r143 = r79.floatValue();
    L98:
        r14.d = o1.s(r3.getContext(), r20.floatValue() + r143);
        goto L99
    L97:
        r143 = 3.0f;
        goto L98
    L79:
        r18 = null;
        goto L80
    L73:
        r17 = false;
        goto L74
    L69:
        r13 = 3.0f;
        goto L70
    L59:
        if ((r10 instanceof Activity) == false) goto L61;
        r11 = (Activity) r10;
        goto L62
    L61:
        r11 = null;
        goto L62
    L27:
        switch(r6.hashCode()) {
            case 3739: goto L47;
            case 100571: goto L43;
            case 115029: goto L40;
            case 3317767: goto L36;
            case 108511772: goto L33;
            case 109757538: goto L30;
            default: goto L50;
        };
    L30:
        if (r6.equals("start") == false) goto L50;
    L38:
        r9 = 3;
        goto L51
    L33:
        if (r6.equals("right") == false) goto L50;
    L45:
        r9 = 5;
        goto L51
    L36:
        if (r6.equals("left") == true) goto L38;
    L40:
        if (r6.equals("top") == false) goto L50;
    L49:
        r9 = 48;
        goto L51
    L43:
        if (r6.equals("end") == true) goto L45;
    L47:
        if (r6.equals("up") == true) goto L49;
    L23:
        r6 = null;
        goto L24
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.obric.miniapp.lynx.p3] */
    public LynxOUIPopoverUI(LynxContext r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.h = new p3(this);
        if (r2.getDefaultOverflowVisible() == false) goto L6;
        ((LynxBaseUI) this).mOverflow = 3;
        return;
    }

    public static boolean P(JSONObject r9) {
        if (Intrinsics.areEqual(o1.B(r9, new String[]{"popoverAlignTopToAnchor", "alignTopToAnchor", "alignToAnchorTop", "popover_align_top_to_anchor", "align_top_to_anchor"}), Boolean.TRUE) == false) goto L5;
    L12:
        return true;
    L5:
        if (o1.D(r9, new String[]{"popoverScreenPaddingStart", "screenPaddingStart", "startSafeMargin", "leftSafeMargin", "popover_screen_padding_start", "screen_padding_start", "start_safe_margin", "left_safe_margin"}) != null) goto L12;
        if (o1.D(r9, new String[]{"popoverTopOffset", "topOffset", "popover_top_offset", "top_offset"}) != null) goto L12;
        if (o1.D(r9, new String[]{"popoverHorizontalOffset", "horizontalOffset", "xOffset", "popover_horizontal_offset", "horizontal_offset", "x_offset"}) != null) goto L12;
        return false;
    }

    public final void V(String r6) {
        JSONObject r0 = this.b;
        if (r0 != null) goto L5;
        r0 = new JSONObject();
    L5:
        if (r6 == null) goto L7;
        String r7 = StringsKt.trim(r6).toString();
    L8:
        if (r7 != null) goto L11;
        r7 = "";
    L11:
        if (r7.length() != 0) goto L13;
        boolean r1 = true;
    L15:
        if (r1 == false) goto L17;
        r0.remove("placement");
        r0.remove("position");
        r0.remove("gravity");
    L18:
        this.b = r0;
        if (this.e == false) goto L22;
        Q();
        return;
    L22:
        return;
    L17:
        r0.put("placement", r7);
        r0.put("position", r7);
        r0.put("gravity", r7);
        goto L18
    L13:
        r1 = false;
        goto L15
    L7:
        r7 = null;
        goto L8
    }

    public final View createView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        FrameLayout r0 = new FrameLayout(r4);
        r0.setMinimumWidth(o1.t(r4, 2));
        r0.setMinimumHeight(o1.t(r4, 2));
        this.a = r0;
        return r0;
    }

    public final void insertView(LynxUI<?> r2) {
        Intrinsics.checkNotNullParameter(r2, "child");
        super.insertView(r2);
        if (this.e == true) goto L5;
        return;
    L5:
        FrameLayout r3 = this.a;
        if (r3 == null) goto L9;
        r3.post(new o3(this));
        return;
    }

    @LynxProp(name = "gravity")
    public final void setGravity(String r1) {
        V(r1);
    }

    @LynxProp(name = "menuWidth")
    public final void setMenuWidth(String r1) {
        if (r1 == null) goto L4;
        Float r2 = StringsKt.toFloatOrNull(r1);
    L5:
        this.g = r2;
        return;
    L4:
        r2 = null;
        goto L5
    }

    @LynxProp(name = "options")
    public final void setOptions(String r1) {
        this.b = o1.G(r1);
        if (this.e == false) goto L6;
        Q();
        return;
    }

    @LynxProp(name = "placement")
    public final void setPlacement(String r1) {
        V(r1);
    }

    @LynxProp(name = "position")
    public final void setPosition(String r1) {
        V(r1);
    }

    @LynxProp(name = "visible")
    public final void setVisible(boolean r1) {
        this.e = r1;
        if (r1 == false) goto L5;
        Q();
        return;
    L5:
        O();
    }

    public final void updatePropertiesInterval(com.lynx.tasm.behavior.x0 r15) {
        Intrinsics.checkNotNullParameter(r15, "props");
        super/*com.lynx.tasm.behavior.ui.LynxBaseUI*/.updatePropertiesInterval(o1.S(r15, this.b, new String[]{"items", "placement", "position", "gravity", "menuWidth", "popoverAlignTopToAnchor", "alignTopToAnchor", "popoverScreenPaddingStart", "screenPaddingStart", "popoverTopOffset", "topOffset", "popoverHorizontalOffset", "horizontalOffset"}, new String[]{"items"}, 2));
    }

    public static void M(OPopoverEntranceMenuView r3, Map r4) {
        if (r4.isEmpty() == false) goto L5;
        return;
    L5:
        Iterator r5 = ((LinkedHashMap) r4).entrySet().iterator();
    L7:
        if (r5.hasNext() == false) goto L22;
        Map.Entry r0 = (Map.Entry) r5.next();
        int r1 = ((Number) r0.getKey()).intValue();
        int r2 = ((Number) r0.getValue()).intValue();
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L11
        Object r7 = Result.constructor-impl(r3.c(r1));     // Catch: Throwable -> L11
    L14:
        if (Result.isFailure-impl(r7) == false) goto L16;
        r7 = null;
    L16:
        PopoverMenuLinearLayout r8 = (PopoverMenuLinearLayout) r7;
        if (r8 == null) goto L7;
        TextView r9 = (TextView) r8.findViewById(2131391130);
        if (r9 == null) goto L7;
        r9.setTextColor(r2);
    L11:
        th = move-exception;
        Result.Companion r10 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L14
    }

    public static void N(OPopoverEntranceMenuView r3, Map r4) {
        if (r4.isEmpty() == false) goto L5;
        return;
    L5:
        Iterator r5 = ((LinkedHashMap) r4).entrySet().iterator();
    L7:
        if (r5.hasNext() == false) goto L22;
        Map.Entry r0 = (Map.Entry) r5.next();
        int r1 = ((Number) r0.getKey()).intValue();
        String r2 = (String) r0.getValue();
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L11
        Object r7 = Result.constructor-impl(r3.c(r1));     // Catch: Throwable -> L11
    L14:
        if (Result.isFailure-impl(r7) == false) goto L16;
        r7 = null;
    L16:
        PopoverMenuLinearLayout r8 = (PopoverMenuLinearLayout) r7;
        if (r8 == null) goto L7;
        TextView r9 = (TextView) r8.findViewById(2131391132);
        if (r9 == null) goto L7;
        r9.setText(r2);
        r9.setVisibility(0);
    L11:
        th = move-exception;
        Result.Companion r10 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L14
    }

    public static void U(OPopoverEntranceMenuView r2, List r3) {
        if (((ArrayList) r3).isEmpty() == false) goto L5;
        return;
    L5:
        Iterator r4 = r3.iterator();
    L7:
        if (r4.hasNext() == false) goto L23;
        int r0 = ((Number) r4.next()).intValue();
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L11
        Object r5 = Result.constructor-impl(r2.c(r0));     // Catch: Throwable -> L11
    L14:
        if (Result.isFailure-impl(r5) == false) goto L16;
        r5 = null;
    L16:
        PopoverMenuLinearLayout r6 = (PopoverMenuLinearLayout) r5;
        if (r6 == null) goto L7;
        View r7 = r6.findViewById(2131382765);
        if (r7 == null) goto L7;
        r7.setVisibility(4);
        r7.setSelected(false);
        r7.setActivated(false);
        r7.requestLayout();
    L11:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L14
    }

    public final void R(int r5, String r6, String r7) {
        LynxContext r0 = getLynxContext();
        if (r0 == null) goto L14;
        EventEmitter r1 = r0.getEventEmitter();
        if (r1 == null) goto L15;
        m7a.a r2 = new m7a.a(getSign(), "select");
        r2.a("index", Integer.valueOf(r5));
        if (r6 == null) goto L10;
        r2.a("title", r6);
    L10:
        if (r7 == null) goto L12;
        r2.a("value", r7);
    L12:
        r1.sendCustomEvent(r2);
        return;
    L15:
        return;
    }

    public static boolean T(com.obric.oui.popover.v2.c r17, View r18, int r19, int r20, JSONObject r21) {
        Boolean r2 = o1.B(r21, new String[]{"popoverAlignTopToAnchor", "alignTopToAnchor", "alignToAnchorTop", "popover_align_top_to_anchor", "align_top_to_anchor"});
        if (r2 == null) goto L5;
        boolean r3 = r2.booleanValue();
    L6:
        Float r4 = o1.F(o1.D(r21, new String[]{"popoverScreenPaddingStart", "screenPaddingStart", "startSafeMargin", "leftSafeMargin", "popover_screen_padding_start", "screen_padding_start", "start_safe_margin", "left_safe_margin"}));
        Float r5 = o1.F(o1.D(r21, new String[]{"popoverTopOffset", "topOffset", "popover_top_offset", "top_offset"}));
        Float r6 = o1.F(o1.D(r21, new String[]{"popoverHorizontalOffset", "horizontalOffset", "xOffset", "popover_horizontal_offset", "horizontal_offset", "x_offset"}));
        if (P(r21) == true) goto L9;
        return false;
    L9:
        int[] r9 = new int[2];
        r18.getLocationOnScreen(r9);
        int r10 = r9[0];
        int r11 = r9[1];
        int r12 = r18.getMeasuredWidth() + r10;
        int r13 = r18.getMeasuredHeight() + r11;
        r17.getContentView().measure(0, 0);
        int r14 = r17.getContentView().getMeasuredWidth();
        int r15 = r17.getContentView().getMeasuredHeight();
        if (r14 <= 0) goto L76;
        if (r15 <= 0) goto L81;
        Rect r16 = new Rect();
        View r1 = r18.getRootView();
        if (r1 == null) goto L17;
        r1.getWindowVisibleDisplayFrame(r16);
    L17:
        if (r16.width() > 0) goto L19;
    L20:
        Resources r7 = r18.getContext().getResources();
        DisplayMetrics r8 = WindowDisplayMetricsOverride.apply(r7, r7.getDisplayMetrics());
        r16.set(0, 0, r8.widthPixels, r8.heightPixels);
    L21:
        int r22 = r19 & ErrorCode.DEVICE_LOCK_ERROR;
        int r23 = r19 & 7;
        if (r23 != 3) goto L24;
        r10 = r12 - r14;
    L27:
        int r24 = r16.left;
        Context r25 = r18.getContext();
        if (r4 == null) goto L30;
        float r26 = r4.floatValue();
    L31:
        int r27 = r24 + o1.s(r25, r26);
        int r28 = RangesKt.coerceAtLeast((r16.right - r14) - o1.s(r18.getContext(), 8.0f), r27);
        if (r6 == null) goto L34;
        float r29 = r6.floatValue();
        int r30 = o1.s(r18.getContext(), r29);
    L35:
        int r31 = RangesKt.coerceIn(RangesKt.coerceIn(r10, r27, r28) + r30, r27, r28);
        Integer r32 = Integer.valueOf(r22);
        if (r32.intValue() == 0) goto L38;
        boolean r33 = true;
    L39:
        if (r33 == true) goto L42;
        r32 = null;
    L42:
        int r34 = 80;
        if (r32 == null) goto L45;
        int r35 = r32.intValue();
    L47:
        if (r3 == true) goto L56;
        if (r35 == 48) goto L50;
    L52:
        if (r35 != 80) goto L56;
        int r36 = o1.s(r18.getContext(), 12.0f);
        if (((r13 + r15) + r20) <= (r16.bottom - r36)) goto L56;
        r34 = 48;
    L57:
        if (r5 == null) goto L59;
        float r37 = r5.floatValue();
        int r38 = o1.s(r18.getContext(), r37);
    L60:
        if (r3 == true) goto L65;
        if (r34 != 48) goto L64;
        r11 = (r11 - r15) - r20;
        goto L65
    L64:
        r11 = r13 + r20;
    L65:
        int r39 = r16.top;
        int r40 = RangesKt.coerceAtLeast((r16.bottom - r15) - o1.s(r18.getContext(), 12.0f), r39);
        int r41 = RangesKt.coerceIn(RangesKt.coerceIn(r11, r39, r40) + r38, r39, r40);
        OPopoverBase.b.e(r17, r19);
        if (PopupWindowLancet.hasSubWindowToken(r18) == false) goto L69;
        return true;
    L69:
        if (LandscapeChildPopupWindowBoundsAdapter.isShowAtLocationBypassTarget(r17) == false) goto L71;
        r17.showAtLocation(r18, 0, r31, r41);
        return true;
    L71:
        OverlaySource r110 = PopupWindowLancet.resolveSource(r18);
        if (PopupWindowLancet.rewriteDirectShowAtLocationIfNeeded(r17, r18, r110, 0, r31, r41) == true) goto L80;
        r17.showAtLocation(r18, 0, r31, r41);
        PopupWindowLancet.trackAfterShow(r17, r110, r18);
        return true;
    L80:
        return true;
    L59:
        r38 = 0;
        goto L60
    L50:
        if (((r11 - r15) - r20) >= r16.top) goto L52;
    L56:
        r34 = r35;
        goto L57
    L45:
        r35 = 80;
        goto L47
    L38:
        r33 = false;
        goto L39
    L34:
        r30 = 0;
        goto L35
    L30:
        r26 = 8.0f;
        goto L31
    L24:
        if (r23 == 5) goto L27;
        r10 = r10 + ((r18.getMeasuredWidth() - r14) / 2);
        goto L27
    L19:
        if (r16.height() > 0) goto L21;
    L81:
        return false;
    L76:
        return false;
    L5:
        r3 = false;
        goto L6
    }
}
