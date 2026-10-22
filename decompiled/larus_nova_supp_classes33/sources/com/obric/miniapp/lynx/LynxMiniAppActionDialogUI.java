package com.obric.miniapp.lynx;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.lynx.tasm.EventEmitter;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxProp;
import com.lynx.tasm.behavior.ui.UIGroup;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.obric.oui.dialog.v2.action.OActionDialog;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000 82\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00018B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0018H\u0014J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u000bH\u0007J\u0012\u0010\u001c\u001a\u00020\u001a2\b\u0010\u001d\u001a\u0004\u0018\u00010\rH\u0007J\b\u0010\u001e\u001a\u00020\u001aH\u0016J\b\u0010\u001f\u001a\u00020\u001aH\u0002J\b\u0010 \u001a\u00020\u001aH\u0002J\u001e\u0010!\u001a\u00020\"2\u0006\u0010\u0003\u001a\u00020\u00182\f\u0010#\u001a\b\u0012\u0004\u0012\u00020%0$H\u0002J\u0018\u0010&\u001a\u00020\u001a2\u0006\u0010'\u001a\u00020\u000b2\u0006\u0010(\u001a\u00020\u000bH\u0002J\u001a\u0010)\u001a\u00020\u001a2\u0006\u0010*\u001a\u00020+2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0002J\u0010\u0010,\u001a\u00020\u001a2\u0006\u0010-\u001a\u00020\rH\u0002J\u0018\u0010.\u001a\b\u0012\u0004\u0012\u00020%0$2\b\u0010/\u001a\u0004\u0018\u00010\u0010H\u0002J\u0016\u00100\u001a\b\u0012\u0004\u0012\u00020%0$2\u0006\u0010#\u001a\u000201H\u0002J(\u00102\u001a\u00020%2\u0006\u0010\f\u001a\u00020\r2\u0006\u00103\u001a\u00020+2\u0006\u00104\u001a\u00020\r2\u0006\u00105\u001a\u00020\u000bH\u0002J\u001a\u00106\u001a\u00020+2\u0006\u0010*\u001a\u00020+2\b\u00107\u001a\u0004\u0018\u00010\u0010H\u0002R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0002X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00069"}, d2 = {"Lcom/obric/miniapp/lynx/LynxMiniAppActionDialogUI;", "Lcom/lynx/tasm/behavior/ui/UIGroup;", "Landroid/widget/FrameLayout;", "context", "Lcom/lynx/tasm/behavior/LynxContext;", "<init>", "(Lcom/lynx/tasm/behavior/LynxContext;)V", "anchorView", "dialog", "Lcom/obric/oui/dialog/v2/action/OActionDialog;", "visible", "", "title", "", "message", "optionsJson", "Lorg/json/JSONObject;", "emitCancelOnNextDismiss", "emitDismissOnNextDismiss", "hasActionTriggered", "showPosted", "showRunnable", "Ljava/lang/Runnable;", "createView", "Landroid/content/Context;", "setVisible", "", "value", "setOptions", "options", "destroy", "scheduleShow", "showIfPossible", "buildActionListView", "Landroid/view/View;", "items", "", "Lcom/obric/miniapp/lynx/MiniAppDialogActionItem;", "dismissDialog", "emitCancel", "emitDismiss", "sendSelectEvent", "index", "", "sendSimpleEvent", "type", "resolveActionItems", "json", "parseActionItems", "Lorg/json/JSONArray;", "buildActionItem", "styleIndex", "eventType", "disabled", "resolveButtonStyleIndex", "itemJson", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LynxMiniAppActionDialogUI extends UIGroup<FrameLayout> {
    public static final int l = 0;
    public static final int m = 0;
    public FrameLayout a;
    public OActionDialog b;
    public boolean c;
    public String d;
    public String e;
    public JSONObject f;
    public boolean g;
    public boolean h;
    public boolean i;
    public boolean j;
    public final l k;

    public static final class a {
    }

    static {
        Resources r1 = Resources.getSystem();
        l = MathKt.roundToInt(TypedValue.applyDimension(1, 12, WindowDisplayMetricsOverride.apply(r1, r1.getDisplayMetrics())));
        Resources r2 = Resources.getSystem();
        m = MathKt.roundToInt(TypedValue.applyDimension(1, 24, WindowDisplayMetricsOverride.apply(r2, r2.getDisplayMetrics())));
    }

    public final void destroy() {
        FrameLayout r0 = this.a;
        if (r0 == null) goto L5;
        r0.removeCallbacks(this.k);
    L5:
        O(false);
        this.b = null;
        this.a = null;
        super.destroy();
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [com.obric.miniapp.lynx.l] */
    public LynxMiniAppActionDialogUI(LynxContext r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.g = true;
        this.h = true;
        this.k = new l(this);
    }

    public static void M(OActionDialog r3) {
        Handler r0 = DialogLancet.resolveDialogHandler(r3);
        if (r0 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r3);
        r3.dismiss();     // Catch: Throwable -> L11 Exception -> L13
    L17:
        DialogLancet.afterDialogDismiss(r3);
        return;
    L13:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r1 == null) goto L17;
        com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r3);
        throw th;
    L5:
        if (Looper.myLooper() == r0.getLooper()) goto L8;
        r0.post(DialogLancet.createDismissRunnable(r3));
    }

    public final void O(boolean r4) {
        OActionDialog r0 = this.b;
        if (r0 != null) goto L5;
        return;
    L5:
        this.g = false;
        this.h = r4;
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L8
        M(r0);     // Catch: Throwable -> L8
        Object r6 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L8
    L10:
        Throwable r7 = Result.exceptionOrNull-impl(r6);
        if (r7 == null) goto L16;
        com.bytedance.ai.utils.g.a.e("LynxMiniAppDialogUI", "dismiss dialog failed", r7);
        return;
    L16:
        return;
    L8:
        th = move-exception;
        Result.Companion r1 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L10
    }

    public final void P(String r4) {
        LynxContext r0 = getLynxContext();
        if (r0 == null) goto L8;
        EventEmitter r1 = r0.getEventEmitter();
        if (r1 == null) goto L9;
        r1.sendCustomEvent(new m7a.a(getSign(), r4));
        return;
    L9:
        return;
    }

    public final View createView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        FrameLayout r0 = new FrameLayout(r4);
        r0.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        r0.setVisibility(8);
        r0.setClipChildren(false);
        r0.setClipToPadding(false);
        r0.setClickable(false);
        r0.setFocusable(false);
        this.a = r0;
        return r0;
    }

    @LynxProp(name = "options")
    public final void setOptions(String r7) {
        boolean r0 = true;
        String r1 = null;
        if (r7 != null) goto L5;
    L20:
        JSONObject r8 = null;
    L21:
        this.f = r8;
        if (r8 != null) goto L24;
        return;
    L24:
        if (r8.has("title") == false) goto L35;
        String r2 = StringsKt.trim(r8.optString("title")).toString();
        if (r2.length() <= 0) goto L28;
        boolean r3 = true;
    L30:
        if (Boolean.valueOf(r3).booleanValue() == true) goto L33;
        r2 = null;
    L33:
        this.d = r2;
        goto L35
    L28:
        r3 = false;
    L35:
        if (r8.has("message") == false) goto L46;
        String r4 = StringsKt.trim(r8.optString("message")).toString();
        if (r4.length() <= 0) goto L39;
        boolean r5 = true;
    L41:
        if (Boolean.valueOf(r5).booleanValue() == true) goto L44;
        r4 = null;
    L44:
        this.e = r4;
        goto L46
    L39:
        r5 = false;
    L46:
        if (r8.has("subtitle") == false) goto L61;
        String r9 = StringsKt.trim(r8.optString("subtitle")).toString();
        if (r9.length() > 0) goto L52;
        r0 = false;
    L52:
        if (Boolean.valueOf(r0).booleanValue() == false) goto L54;
        r1 = r9;
    L54:
        if (r1 != null) goto L56;
        r1 = this.e;
    L56:
        this.e = r1;
        return;
    L61:
        return;
    L5:
        if ((!StringsKt.isBlank(r7)) == true) goto L8;
        r7 = null;
    L8:
        if (r7 == null) goto L20;
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L11
        Object r10 = Result.constructor-impl(new JSONObject(r7));     // Catch: Throwable -> L11
    L13:
        Throwable r11 = Result.exceptionOrNull-impl(r10);
        if (r11 == null) goto L17;
        com.bytedance.ai.utils.g.a.e("LynxMiniAppDialogUI", "parse options failed", r11);
    L17:
        if (Result.isFailure-impl(r10) == false) goto L19;
        r10 = null;
    L19:
        r8 = (JSONObject) r10;
    L11:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        r10 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L13
    }

    @LynxProp(name = "visible")
    public final void setVisible(boolean r3) {
        this.c = r3;
        if (r3 == false) goto L11;
        FrameLayout r4 = this.a;
        if (r4 != null) goto L8;
        return;
    L8:
        if (this.j == true) goto L15;
        this.j = true;
        r4.post(this.k);
        return;
    L15:
        return;
    L11:
        O(true);
    }

    public static t4 N(String r2, int r3, String r4, boolean r5) {
        if (r3 != 0) goto L5;
        int r6 = 2131952835;
    L10:
        return new t4(r2, r6, r4, r5);
    L5:
        if (r3 == 1) goto L7;
        r6 = 2131952831;
        goto L10
    L7:
        r6 = 2131952833;
        goto L10
    }
}
