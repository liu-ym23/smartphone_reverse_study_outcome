package com.obric.miniapp.lynx;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.util.TypedValue;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.utils.logger.FLogger;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxProp;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.LynxUI;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.obric.miniapp.view.actionsheet.MiniAppActionSheetAdapter;
import com.obric.miniapp.view.actionsheet.VerticalSpaceItemDecoration;
import com.obric.oui.selection.OActionSheet;
import com.obric.oui.sheet.OInsetSheet;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\b\u0007\u0018\u0000 '2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001'B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u000fH\u0014J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0012\u0010\u0014\u001a\u00020\u00112\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0007J\u0010\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\rH\u0007J\b\u0010\u0019\u001a\u00020\u0011H\u0016J\b\u0010\u001a\u001a\u00020\u0011H\u0002J\u001e\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0003\u001a\u00020\u000f2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001eH\u0002J\b\u0010 \u001a\u00020\u0011H\u0002J\u001a\u0010!\u001a\u00020\u00112\u0006\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010\u0016H\u0002J\u0010\u0010%\u001a\u00020\u00112\u0006\u0010&\u001a\u00020\u0016H\u0002R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0002X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/obric/miniapp/lynx/LynxOUISheetUI;", "Lcom/lynx/tasm/behavior/ui/LynxUI;", "Landroid/widget/FrameLayout;", "context", "Lcom/lynx/tasm/behavior/LynxContext;", "<init>", "(Lcom/lynx/tasm/behavior/LynxContext;)V", "root", "optionsJson", "Lorg/json/JSONObject;", "sheet", "Lcom/obric/oui/selection/OActionSheet;", "hasSelected", "", "createView", "Landroid/content/Context;", "updatePropertiesInterval", "", "props", "Lcom/lynx/tasm/behavior/StylesDiffMap;", "setOptions", "options", "", "setVisible", "visible", "destroy", "showIfPossible", "genSheetContentView", "Landroid/view/View;", "optionList", "", "Lcom/obric/miniapp/view/actionsheet/ActionSheetItemData;", "dismiss", "sendSelectEvent", "index", "", "title", "sendSimpleEvent", "type", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LynxOUISheetUI extends LynxUI<FrameLayout> {
    public static final /* synthetic */ int e = 0;
    public FrameLayout a;
    public JSONObject b;
    public OActionSheet c;
    public boolean d;

    public static final class a {
    }

    static {
    }

    public final void N() {
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L9
        OActionSheet r2 = this.c;     // Catch: Throwable -> L9
        if (r2 == null) goto L6;
        M(r2);     // Catch: Throwable -> L9
        Unit r3 = Unit.INSTANCE;     // Catch: Throwable -> L9
    L7:
        Result.constructor-impl(r3);     // Catch: Throwable -> L9
    L11:
        this.c = null;
        return;
    L6:
        r3 = null;
    L9:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L11
    }

    public final void destroy() {
        N();
        this.a = null;
        super.destroy();
    }

    public LynxOUISheetUI(LynxContext r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        if (r2.getDefaultOverflowVisible() == false) goto L6;
        ((LynxBaseUI) this).mOverflow = 3;
        return;
    }

    public static void M(OActionSheet r3) {
        Handler r0 = DialogLancet.resolveDialogHandler(r3);
        if (r0 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r3);
        OActionSheet.f(r3);     // Catch: Throwable -> L11 Exception -> L16
    L11:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r3);
        throw th;
    L14:
        DialogLancet.afterDialogDismiss(r3);
        return;
    L5:
        if (Looper.myLooper() == r0.getLooper()) goto L8;
        r0.post(DialogLancet.createDismissRunnable(r3));
    }

    public final View createView(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        FrameLayout r0 = new FrameLayout(r3);
        r0.setClickable(false);
        r0.setFocusable(false);
        r0.setFocusableInTouchMode(false);
        r0.setEnabled(false);
        r0.setImportantForAccessibility(2);
        r0.setMinimumWidth(0);
        r0.setMinimumHeight(0);
        r0.setVisibility(8);
        this.a = r0;
        return r0;
    }

    @LynxProp(name = "options")
    public final void setOptions(String r1) {
        this.b = o1.G(r1);
    }

    @LynxProp(name = "visible")
    public final void setVisible(boolean r23) {
        if (r23 == false) goto L100;
        FrameLayout r0 = this.a;
        if (r0 == null) goto L116;
        JSONObject r3 = this.b;
        if (r3 == null) goto L117;
        JSONArray r5 = r3.optJSONArray("items");
        if (r5 == null) goto L118;
        N();
        this.d = false;
        String r8 = r3.optString("title");
        if (StringsKt.isBlank(r8) == false) goto L17;
        r8 = "";
    L17:
        if (Intrinsics.areEqual(r3.optString("width").toLowerCase(Locale.ROOT), "board") == false) goto L19;
        OInsetSheet.PanelWidth r4 = OInsetSheet.PanelWidth.BOARD_WIDTH;
    L20:
        Intrinsics.checkNotNull(r8);
        OActionSheet.Companion.a r9 = new OActionSheet.Companion.a(r4, r8, new z3(this));
        ArrayList r6 = new ArrayList(r5.length());
        int r10 = r5.length();
        int r11 = 0;
    L22:
        if (r11 >= r10) goto L58;
        JSONObject r13 = r5.optJSONObject(r11);
        if (r13 == null) goto L32;
        final String r14 = r13.optString("title");
        if (r14 == null) goto L32;
        if ((!StringsKt.isBlank(r14)) == true) goto L31;
        r14 = null;
    L31:
        if (r14 == null) goto L32;
    L33:
        Context r15 = r0.getContext();
        if (r13 != null) goto L36;
        JSONObject r12 = new JSONObject();
    L37:
        Drawable r17 = o1.N(r15, r12);
        if (r13 == null) goto L40;
        Object r7 = o1.D(r13, new String[]{"textColor", "titleColor", "color", "text_color", "title_color"});
    L41:
        Integer r16 = o1.E(r7, r0.getContext());
        if (r16 != null) goto L53;
        if (r13 == null) goto L52;
        String r18 = r13.optString("style");
        if (r18 == null) goto L52;
        if (StringsKt.equals(r18, "destructive", true) == true) goto L50;
        r18 = null;
    L50:
        if (r18 == null) goto L52;
        r16 = Integer.valueOf(ContextCompat.getColor(r0.getContext(), 2131104979));
    L52:
        Integer r19 = null;
    L54:
        if (r17 == null) goto L56;
        OActionSheet.Companion.ItemStyle r20 = OActionSheet.Companion.ItemStyle.LIST_ICON_AND_TEXT;
    L57:
        Intrinsics.checkNotNull(r14);
        r6.add(new fla.a(r20, r17, r14, r19, new a4(this, r14)));
        r11 = r11 + 1;
        r5 = r5;
        goto L22
    L56:
        r20 = OActionSheet.Companion.ItemStyle.LIST_BUTTON;
    L53:
        r19 = r16;
        goto L54
    L40:
        r7 = null;
        goto L41
    L36:
        r12 = r13;
    L32:
        r14 = r5.optString(r11);
        goto L33
    L58:
        Context r21 = r0.getContext();
        RecyclerView r22 = new RecyclerView(r21);
        r22.setOverScrollMode(2);
        r22.setLayoutManager(new LinearLayoutManager(r21));
        LinearLayout.LayoutParams r24 = new LinearLayout.LayoutParams(-1, -2);
        r24.gravity = 16;
        r22.setLayoutParams(r24);
        float r25 = 12;
        Resources r26 = Resources.getSystem();
        int r27 = MathKt.roundToInt(TypedValue.applyDimension(1, r25, WindowDisplayMetricsOverride.apply(r26, r26.getDisplayMetrics())));
        Resources r110 = Resources.getSystem();
        int r111 = MathKt.roundToInt(TypedValue.applyDimension(1, r25, WindowDisplayMetricsOverride.apply(r110, r110.getDisplayMetrics())));
        Resources r112 = Resources.getSystem();
        int r113 = MathKt.roundToInt(TypedValue.applyDimension(1, r25, WindowDisplayMetricsOverride.apply(r112, r112.getDisplayMetrics())));
        Resources r114 = Resources.getSystem();
        r22.setPadding(r27, r111, r113, MathKt.roundToInt(TypedValue.applyDimension(1, r25, WindowDisplayMetricsOverride.apply(r114, r114.getDisplayMetrics()))));
        Resources r115 = Resources.getSystem();
        r22.addItemDecoration(new VerticalSpaceItemDecoration(MathKt.roundToInt(TypedValue.applyDimension(1, 4, WindowDisplayMetricsOverride.apply(r115, r115.getDisplayMetrics())))));
        MiniAppActionSheetAdapter r28 = new MiniAppActionSheetAdapter(r21);
        r22.setAdapter(r28);
        Intrinsics.checkNotNullParameter(r6, "items");
        ((ArrayList) r28.b).clear();
        ((ArrayList) r28.b).addAll(r6);
        r28.notifyDataSetChanged();
        Intrinsics.checkNotNullParameter(new c4(this), "dialogGetter");
        Function2<? super fla.a, ? super Integer, Unit> r29 = new d4(this);
        Intrinsics.checkNotNullParameter(r29, "listener");
        r28.c = r29;
        OActionSheet r30 = new OActionSheet(r0.getContext(), r9);
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L81
        Method[] r2 = OActionSheet.class.getMethods();     // Catch: Throwable -> L81
        int r31 = r2.length;     // Catch: Throwable -> L81
        int r32 = 0;
    L60:
        if (r32 >= r31) goto L76;
        Method r33 = r2[r32];     // Catch: Throwable -> L81
        if (r33.getParameterTypes().length == 1) goto L64;
    L72:
        boolean r116 = false;
    L73:
        if (r116 == true) goto L77;
        r32 = r32 + 1;     // Catch: Throwable -> L81
    L77:
        if (r33 == null) goto L86;
        r33.setAccessible(true);     // Catch: Throwable -> L81
        Object r34 = Result.constructor-impl(r33.invoke(r30, new Object[]{Boolean.TRUE}));     // Catch: Throwable -> L81
    L83:
        Throwable r35 = Result.exceptionOrNull-impl(r34);
        if (r35 == null) goto L86;
        FLogger.a.w("LynxOUISheetUI", "enable autoSwitchDayNight failed: " + r35.getMessage());
    L86:
        OInsetSheet.d(r30.b(), r22);
        r30.setOnCancelListener(new b4(this));
        this.c = r30;
        Result.Companion r36 = Result.Companion;     // Catch: Throwable -> L95
        if (DialogLancet.shouldBlockDialogShow(r30) == false) goto L103;
        DialogLancet.handleBlockedDialogShow(r30);     // Catch: Throwable -> L95
    L93:
        Object r37 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L95
    L97:
        Throwable r38 = Result.exceptionOrNull-impl(r37);
        if (r38 == null) goto L114;
        FLogger.a.e("LynxOUISheetUI", "show sheet failed", r38);
        this.c = null;
        return;
    L114:
        return;
    L103:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L102 Throwable -> L95
    L92:
        DialogLancet.beforeDialogShow(r30);     // Catch: Throwable -> L95
        r30.show();     // Catch: Throwable -> L95
        DialogLancet.afterDialogShow(r30);     // Catch: Throwable -> L95
    L95:
        th = move-exception;
        Result.Companion r39 = Result.Companion;
        r37 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L97
    L64:
        if (Intrinsics.areEqual(r33.getName(), "autoSwitchDayNight") == true) goto L68;
        if (Intrinsics.areEqual(r33.getName(), "setAutoSwitchDayNight") == false) goto L72;
    L68:
        if (Intrinsics.areEqual(r33.getParameterTypes()[0], Boolean.TYPE) == false) goto L70;
    L71:
        r116 = true;
        goto L73
    L70:
        if (Intrinsics.areEqual(r33.getParameterTypes()[0], Boolean.class) == false) goto L72;
    L76:
        r33 = null;
    L81:
        th = move-exception;
        Result.Companion r40 = Result.Companion;
        r34 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L83
    L19:
        r4 = OInsetSheet.PanelWidth.NARROW_WIDTH;
        goto L20
    L118:
        return;
    L117:
        return;
    L116:
        return;
    L100:
        N();
    }

    public final void updatePropertiesInterval(com.lynx.tasm.behavior.x0 r5) {
        Intrinsics.checkNotNullParameter(r5, "props");
        super/*com.lynx.tasm.behavior.ui.LynxBaseUI*/.updatePropertiesInterval(o1.S(r5, this.b, new String[]{"title", "width", "items"}, new String[]{"items"}, 2));
    }
}
