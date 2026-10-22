package com.obric.miniapp.lynx;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxProp;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.LynxUI;
import com.obric.oui.oswitch.OSwitch;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0010H\u0014J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0012\u0010\u0015\u001a\u00020\u00122\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0007J\u0010\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u000bH\u0007J\u0010\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u000bH\u0007J\b\u0010\u001c\u001a\u00020\u0012H\u0016J\u0018\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u000bH\u0002R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0002X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/obric/miniapp/lynx/LynxOUISwitchUI;", "Lcom/lynx/tasm/behavior/ui/LynxUI;", "Landroid/widget/FrameLayout;", "context", "Lcom/lynx/tasm/behavior/LynxContext;", "<init>", "(Lcom/lynx/tasm/behavior/LynxContext;)V", "containerView", "switchView", "Lcom/obric/oui/oswitch/OSwitch;", "suppressEvent", "", "checkedCache", "optionsJson", "Lorg/json/JSONObject;", "createView", "Landroid/content/Context;", "updatePropertiesInterval", "", "props", "Lcom/lynx/tasm/behavior/StylesDiffMap;", "setOptions", "options", "", "setChecked", "checked", "setDisabled", "disabled", "destroy", "sendEvent", "type", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LynxOUISwitchUI extends LynxUI<FrameLayout> {
    public static final /* synthetic */ int e = 0;
    public FrameLayout a;
    public OSwitch b;
    public boolean c;
    public JSONObject d;

    public final void destroy() {
        this.a = null;
        this.b = null;
        super.destroy();
    }

    public LynxOUISwitchUI(LynxContext r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        if (r2.getDefaultOverflowVisible() == false) goto L6;
        ((LynxBaseUI) this).mOverflow = 3;
        return;
    }

    public final View createView(Context r6) {
        Intrinsics.checkNotNullParameter(r6, "context");
        FrameLayout r0 = new FrameLayout(r6);
        r0.setMinimumWidth(o1.t(r6, 44));
        r0.setMinimumHeight(o1.t(r6, 32));
        final OSwitch r1 = new OSwitch(r6, null, 6, 0);
        r1.setOnCheckedChangeListener(new e4(this));
        r0.setOnClickListener(new f4(r1));
        r1.isChecked();
        this.a = r0;
        this.b = r1;
        FrameLayout.LayoutParams r7 = new FrameLayout.LayoutParams(-2, -2);
        r7.gravity = 17;
        Unit r2 = Unit.INSTANCE;
        r0.addView(r1, r7);
        return r0;
    }

    @LynxProp(name = "checked")
    public final void setChecked(boolean r3) {
        OSwitch r0 = this.b;
        if (r0 != null) goto L5;
        return;
    L5:
        this.c = true;
        r0.setChecked(r3);
        this.c = false;
    }

    @LynxProp(name = "disabled")
    public final void setDisabled(boolean r3) {
        FrameLayout r0 = this.a;
        if (r0 == null) goto L5;
        r0.setEnabled(!r3);
    L5:
        OSwitch r1 = this.b;
        if (r1 == null) goto L9;
        r1.setEnabled(!r3);
        return;
    }

    @LynxProp(name = "options")
    public final void setOptions(String r4) {
        JSONObject r5 = o1.G(r4);
        this.d = r5;
        if (r5 != null) goto L6;
        return;
    L6:
        if (r5.has("checked") == false) goto L9;
        setChecked(r5.optBoolean("checked", false));
    L12:
        if (r5.has("disabled") == false) goto L15;
        setDisabled(r5.optBoolean("disabled", false));
        return;
    L15:
        return;
    L9:
        if (r5.has("value") == false) goto L12;
        setChecked(r5.optBoolean("value", false));
        goto L12
    }

    public final void updatePropertiesInterval(com.lynx.tasm.behavior.x0 r5) {
        Intrinsics.checkNotNullParameter(r5, "props");
        super/*com.lynx.tasm.behavior.ui.LynxBaseUI*/.updatePropertiesInterval(o1.S(r5, this.d, new String[]{"checked", "value", "disabled"}, null, 10));
    }
}
