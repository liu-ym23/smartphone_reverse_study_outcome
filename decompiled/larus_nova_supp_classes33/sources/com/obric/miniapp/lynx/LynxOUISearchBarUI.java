package com.obric.miniapp.lynx;

import android.content.Context;
import android.content.res.Resources;
import android.text.InputFilter;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import com.larus.utils.logger.FLogger;
import com.lynx.tasm.EventEmitter;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxProp;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.LynxUI;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.oui.forms.OEditText;
import com.obric.oui.searchbar.v2.OSearchBar;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u0000 02\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00010B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0015H\u0014J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0012\u0010\u001a\u001a\u00020\u00172\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0007J\u0012\u0010\u001d\u001a\u00020\u00172\b\u0010\u001e\u001a\u0004\u0018\u00010\u001cH\u0007J\u0012\u0010\u001f\u001a\u00020\u00172\b\u0010\u001e\u001a\u0004\u0018\u00010\u001cH\u0007J\u0010\u0010 \u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\fH\u0007J\u0010\u0010!\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u0012H\u0007J\u0010\u0010\"\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\fH\u0007J\b\u0010#\u001a\u00020\u0017H\u0016J\b\u0010$\u001a\u00020\u0017H\u0002J\b\u0010%\u001a\u00020\u0017H\u0002J\u0010\u0010&\u001a\u00020\f2\u0006\u0010'\u001a\u00020(H\u0002J\u0010\u0010)\u001a\u00020\u00172\u0006\u0010'\u001a\u00020(H\u0002J\u0018\u0010*\u001a\u00020\u00172\u0006\u0010+\u001a\u00020\u001c2\u0006\u0010,\u001a\u00020\u001cH\u0002J\u0014\u0010-\u001a\u0004\u0018\u00010\u000e2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0002J\u0018\u0010.\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u00152\u0006\u0010/\u001a\u00020\u0012H\u0002R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00061"}, d2 = {"Lcom/obric/miniapp/lynx/LynxOUISearchBarUI;", "Lcom/lynx/tasm/behavior/ui/LynxUI;", "Landroid/widget/FrameLayout;", "context", "Lcom/lynx/tasm/behavior/LynxContext;", "<init>", "(Lcom/lynx/tasm/behavior/LynxContext;)V", "searchBar", "Lcom/obric/oui/searchbar/v2/OSearchBar;", "hostView", "Lcom/obric/miniapp/lynx/SearchBarHostLayout;", "suppressEvent", "", "optionsJson", "Lorg/json/JSONObject;", "autoFocusRequested", "pendingAutoFocus", "autoFocusRetryCount", "", "autoFocusRetryScheduled", "createView", "Landroid/content/Context;", "updatePropertiesInterval", "", "props", "Lcom/lynx/tasm/behavior/StylesDiffMap;", "setOptions", "options", "", "setValue", "v", "setPlaceholder", "setDisabled", "setMaxLength", "setAutoFocus", "destroy", "requestFocusAndShowIme", "clearFocusAndHideIme", "canRequestFocusNow", "inputView", "Landroid/view/View;", "scheduleAutoFocusRetry", "sendEvent", "type", "value", "parseOptionsJson", "dpToPx", "dp", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LynxOUISearchBarUI extends LynxUI<FrameLayout> {
    public static final /* synthetic */ int i = 0;
    public OSearchBar a;
    public e6 b;
    public boolean c;
    public JSONObject d;
    public boolean e;
    public boolean f;
    public int g;
    public boolean h;

    public static final class a {
    }

    static {
    }

    public final void destroy() {
        this.e = false;
        this.f = false;
        this.g = 0;
        this.h = false;
        this.b = null;
        this.a = null;
        super.destroy();
    }

    public final void M() {
        if (this.f == true) goto L5;
        return;
    L5:
        OSearchBar r0 = this.a;
        if (r0 == null) goto L12;
        final OEditText r1 = r0.getInputView();
        if (r1 == null) goto L13;
        r1.post(new u3(this, r1));
        return;
    L13:
        return;
    }

    public LynxOUISearchBarUI(LynxContext r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        if (r2.getDefaultOverflowVisible() == false) goto L6;
        ((LynxBaseUI) this).mOverflow = 3;
        return;
    }

    public final void N(OEditText r4) {
        if (this.f == true) goto L5;
        return;
    L5:
        if (this.h == true) goto L14;
        int r0 = this.g;
        if (r0 < 12) goto L11;
        FLogger.a.i("LynxOUISearchBarUI", "autoFocus retry exhausted");
        return;
    L11:
        this.g = r0 + 1;
        this.h = true;
        r4.postDelayed(new w3(this), 32);
        return;
    }

    public final View createView(Context r7) {
        Intrinsics.checkNotNullParameter(r7, "context");
        Resources r1 = r7.getResources();
        e6 r2 = new e6(r7, (int) ((40 * WindowDisplayMetricsOverride.apply(r1, r1.getDisplayMetrics()).density) + 0.5f));
        r2.setFocusable(true);
        r2.setFocusableInTouchMode(true);
        this.b = r2;
        View r3 = LayoutInflater.from(r7).inflate(2131563665, r2, false);
        if ((r3 instanceof OSearchBar) == false) goto L5;
        final OSearchBar r4 = (OSearchBar) r3;
    L6:
        if (r4 != null) goto L8;
        r4 = new OSearchBar(r7, null);
    L8:
        r4.setDuplicateParentStateEnabled(false);
        r4.setChangeAlphaWhenPress(false);
        r4.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        r2.addOnLayoutChangeListener(new q3(this));
        r2.addOnAttachStateChangeListener(new x3(this));
        r4.getInputView().setMaxLines(1);
        r4.getInputView().setSingleLine(true);
        r4.getInputView().setImeOptions(3);
        r4.getInputView().addTextChangedListener(new y3(this));
        r4.getInputView().setOnEditorActionListener(new r3(this, r4));
        r4.setOnInputFocusChange(new s3(this, r4));
        this.a = r4;
        r2.addView(r4);
        r2.post(new t3(this));
        return r2;
    L5:
        r4 = null;
        goto L6
    }

    @LynxProp(name = "autoFocus")
    public final void setAutoFocus(boolean r3) {
        this.e = r3;
        if (r3 == true) goto L9;
        this.f = false;
        this.g = 0;
        this.h = false;
        OSearchBar r4 = this.a;
        if (r4 == null) goto L11;
        OEditText r0 = r4.getInputView();
        r0.post(new v3(this, r4, r0));
        return;
    L11:
        return;
    L9:
        this.f = true;
        this.g = 0;
        this.h = false;
        M();
    }

    @LynxProp(name = "disabled")
    public final void setDisabled(boolean r4) {
        OSearchBar r0 = this.a;
        if (r0 != null) goto L5;
        return;
    L5:
        boolean r1 = !r4;
        r0.setEnabled(r1);
        r0.getInputView().setEnabled(r1);
        r0.getInputView().setFocusable(r1);
        r0.getInputView().setFocusableInTouchMode(r1);
        if (r4 == false) goto L12;
        this.f = false;
        this.g = 0;
        this.h = false;
        OSearchBar r5 = this.a;
        if (r5 == null) goto L17;
        OEditText r2 = r5.getInputView();
        r2.post(new v3(this, r5, r2));
        return;
    L17:
        return;
    L12:
        if (this.e == false) goto L16;
        this.f = true;
        M();
        return;
    }

    @LynxProp(name = "maxLength")
    public final void setMaxLength(int r5) {
        OSearchBar r0 = this.a;
        if (r0 == null) goto L13;
        OEditText r1 = r0.getInputView();
        if (r1 != null) goto L8;
        return;
    L8:
        if (r5 > 0) goto L11;
        r1.setFilters(new InputFilter[0]);
        return;
    L11:
        r1.setFilters(new InputFilter.LengthFilter[]{new InputFilter.LengthFilter(r5)});
        return;
    }

    @LynxProp(name = "options")
    public final void setOptions(String r4) {
        JSONObject r0 = null;
        Object r1 = null;
        r0 = null;
        if (r4 != null) goto L5;
    L18:
        this.d = r0;
        if (r0 != null) goto L22;
        return;
    L22:
        if (r0.has("value") == false) goto L25;
        setValue(r0.optString("value"));
    L25:
        if (r0.has("placeholder") == false) goto L28;
        setPlaceholder(r0.optString("placeholder"));
    L28:
        if (r0.has("disabled") == false) goto L31;
        setDisabled(r0.optBoolean("disabled", false));
    L31:
        if (r0.has("maxLength") == false) goto L34;
        setMaxLength(r0.optInt("maxLength"));
    L34:
        if (r0.has("autoFocus") == false) goto L39;
        setAutoFocus(r0.optBoolean("autoFocus", false));
        return;
    L39:
        return;
    L5:
        if ((!StringsKt.isBlank(r4)) == true) goto L8;
        r4 = null;
    L8:
        if (r4 == null) goto L18;
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L11
        Object r5 = Result.constructor-impl(new JSONObject(r4));     // Catch: Throwable -> L11
    L14:
        if (Result.isFailure-impl(r5) == true) goto L17;
        r1 = r5;
    L17:
        r0 = (JSONObject) r1;
    L11:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L14
    }

    @LynxProp(name = "placeholder")
    public final void setPlaceholder(String r2) {
        OSearchBar r0 = this.a;
        if (r0 == null) goto L8;
        OEditText r1 = r0.getInputView();
        if (r1 == null) goto L9;
        r1.setHint(r2);
        return;
    L9:
        return;
    }

    @LynxProp(name = "value")
    public final void setValue(String r3) {
        OSearchBar r0 = this.a;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r3 != null) goto L8;
        r3 = "";
    L8:
        if (Intrinsics.areEqual(r0.getText().toString(), r3) == false) goto L10;
        return;
    L10:
        this.c = true;
        r0.setText(r3);
        int r4 = RangesKt.coerceAtMost(r0.getText().length(), r3.length());
        r0.getInputView().setSelection(r4);
        this.c = false;
    }

    public final void updatePropertiesInterval(com.lynx.tasm.behavior.x0 r7) {
        Intrinsics.checkNotNullParameter(r7, "props");
        super/*com.lynx.tasm.behavior.ui.LynxBaseUI*/.updatePropertiesInterval(o1.S(r7, this.d, new String[]{"value", "placeholder", "disabled", "maxLength", "autoFocus"}, null, 10));
    }

    public final void O(String r4, String r5) {
        LynxContext r0 = getLynxContext();
        if (r0 == null) goto L9;
        EventEmitter r1 = r0.getEventEmitter();
        if (r1 == null) goto L10;
        m7a.a r2 = new m7a.a(getSign(), r4);
        r2.a("value", r5);
        r1.sendCustomEvent(r2);
        return;
    L10:
        return;
    }
}
