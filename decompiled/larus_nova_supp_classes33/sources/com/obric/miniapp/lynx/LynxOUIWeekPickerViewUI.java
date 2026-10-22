package com.obric.miniapp.lynx;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxProp;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.LynxUI;
import com.obric.oui.calendar.OWeekPickerView;
import com.obric.oui.calendar.PickerSelectionMode;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0007\u0018\u0000 &2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001&B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0014H\u0014J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0012\u0010\u0019\u001a\u00020\u00162\b\u0010\u001a\u001a\u0004\u0018\u00010\fH\u0007J\u0012\u0010\u001b\u001a\u00020\u00162\b\u0010\u001c\u001a\u0004\u0018\u00010\fH\u0007J\u0010\u0010\u001d\u001a\u00020\u00162\u0006\u0010\u001e\u001a\u00020\u000eH\u0007J\b\u0010\u001f\u001a\u00020\u0016H\u0016J\"\u0010 \u001a\u00020\u00162\u0006\u0010!\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\u000e2\b\u0010\"\u001a\u0004\u0018\u00010\fH\u0002J\u0016\u0010#\u001a\u00020\u00162\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002J\u000e\u0010%\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0002X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/obric/miniapp/lynx/LynxOUIWeekPickerViewUI;", "Lcom/lynx/tasm/behavior/ui/LynxUI;", "Landroid/widget/FrameLayout;", "context", "Lcom/lynx/tasm/behavior/LynxContext;", "<init>", "(Lcom/lynx/tasm/behavior/LynxContext;)V", "rootView", "weekPickerView", "Lcom/obric/oui/calendar/OWeekPickerView;", "titles", "", "", "selectedIndex", "", "optionsJson", "Lorg/json/JSONObject;", "suppressEvent", "", "createView", "Landroid/content/Context;", "updatePropertiesInterval", "", "props", "Lcom/lynx/tasm/behavior/StylesDiffMap;", "setOptions", "options", "setTitles", "titlesJson", "setSelectedIndex", "index", "destroy", "sendEvent", "type", "title", "applyTitles", "newTitles", "currentTitles", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LynxOUIWeekPickerViewUI extends LynxUI<FrameLayout> {
    public static final List<String> f = null;
    public OWeekPickerView a;
    public List<String> b;
    public int c;
    public JSONObject d;
    public boolean e;

    public static final class a {
    }

    public final void destroy() {
        this.a = null;
        super.destroy();
    }

    static {
        f = CollectionsKt.listOf(new String[]{"日", "一", "二", "三", "四", "五", "六"});
    }

    public final List<String> M() {
        List<String> r0 = this.b;
        if (r0 == null) goto L13;
        if (r0.size() != f.size()) goto L7;
        boolean r1 = true;
    L8:
        if (r1 == true) goto L11;
        r0 = null;
    L11:
        if (r0 == null) goto L13;
        return r0;
    L7:
        r1 = false;
    L13:
        return f;
    }

    public LynxOUIWeekPickerViewUI(LynxContext r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        if (r2.getDefaultOverflowVisible() == false) goto L6;
        ((LynxBaseUI) this).mOverflow = 3;
        return;
    }

    public final View createView(Context r7) {
        Intrinsics.checkNotNullParameter(r7, "context");
        FrameLayout r0 = new FrameLayout(r7);
        int r1 = o1.t(r7, 56);
        r0.setMinimumHeight(r1);
        r0.setLayoutParams(new FrameLayout.LayoutParams(-1, r1));
        View r8 = LayoutInflater.from(r7).inflate(2131563667, null, false);
        Intrinsics.checkNotNull(r8, "null cannot be cast to non-null type com.obric.oui.calendar.OWeekPickerView");
        OWeekPickerView r9 = (OWeekPickerView) r8;
        r9.setMinimumHeight(r1);
        r9.setFirstDayOfWeek(1);
        r9.setSelectionMode(PickerSelectionMode.SINGLE);
        r9.setOnDaysChangedListener(new h4(this));
        this.a = r9;
        FrameLayout.LayoutParams r2 = new FrameLayout.LayoutParams(-1, -2);
        r2.gravity = 17;
        Unit r3 = Unit.INSTANCE;
        r0.addView(r9, r2);
        List<String> r10 = M();
        this.b = r10;
        OWeekPickerView r4 = this.a;
        if (r4 == null) goto L5;
        r4.setLabels(r10);
    L5:
        setSelectedIndex(this.c);
        return r0;
    }

    @LynxProp(name = "options")
    public final void setOptions(String r4) {
        JSONObject r5 = o1.G(r4);
        this.d = r5;
        if (r5 != null) goto L5;
        return;
    L5:
        Object r0 = r5.opt("titles");
        if (r0 != null) goto L8;
        r0 = r5.opt("items");
    L8:
        List<String> r1 = o1.H(r0);
        if (r1.size() != 7) goto L14;
        this.b = r1;
        OWeekPickerView r2 = this.a;
        if (r2 == null) goto L14;
        r2.setLabels(r1);
    L14:
        if (r5.has("selectedIndex") == false) goto L17;
        setSelectedIndex(r5.optInt("selectedIndex", this.c));
        return;
    }

    @LynxProp(name = "selectedIndex")
    public final void setSelectedIndex(int r3) {
        if (r3 >= 0) goto L4;
        return;
    L4:
        if (r3 >= M().size()) goto L12;
        this.c = r3;
        OWeekPickerView r0 = this.a;
        if (r0 != null) goto L9;
        return;
    L9:
        this.e = true;
        r0.setSelectedDays(CollectionsKt.listOf(Integer.valueOf(r3)));
        this.e = false;
        return;
    }

    @LynxProp(name = "titles")
    public final void setTitles(String r3) {
        List<String> r4 = o1.H(r3);
        if (r4.size() != 7) goto L8;
        this.b = r4;
        OWeekPickerView r0 = this.a;
        if (r0 == null) goto L9;
        r0.setLabels(r4);
        return;
    L9:
        return;
    }

    public final void updatePropertiesInterval(com.lynx.tasm.behavior.x0 r5) {
        Intrinsics.checkNotNullParameter(r5, "props");
        super/*com.lynx.tasm.behavior.ui.LynxBaseUI*/.updatePropertiesInterval(o1.S(r5, this.d, new String[]{"titles", "items", "selectedIndex"}, new String[]{"titles", "items"}, 2));
    }
}
