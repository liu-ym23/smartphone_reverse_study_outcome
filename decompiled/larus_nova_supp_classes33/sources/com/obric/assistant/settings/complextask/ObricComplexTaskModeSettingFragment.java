package com.obric.assistant.settings.complextask;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBindings;
import com.larus.bmhome.view.NovaTitleBarEx;
import com.larus.bmhome.view.item.ItemGroup;
import com.larus.bmhome.view.item.ItemTextSelector;
import com.larus.trace.tracknode.TraceFragment;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.ComplexTaskSettingsCommonItem;
import com.obric.assistant.ComplexTaskSettingsConfig;
import com.obric.assistant.impl.databinding.ObricFragmentComplexTaskModeSettingBinding;
import com.obric.assistant.t1;
import dga.c;
import dga.d;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 '2\u00020\u0001:\u0001'B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u0006H\u0016J\u0012\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J&\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\u001a\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u00122\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\b\u0010\u0019\u001a\u00020\u000eH\u0016J\n\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0002J\u000f\u0010\u001c\u001a\u0004\u0018\u00010\u000eH\u0002¢\u0006\u0002\u0010\u001dJ0\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\t2\u0006\u0010&\u001a\u00020\tH\u0002R\u001c\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/obric/assistant/settings/complextask/ObricComplexTaskModeSettingFragment;", "Lcom/larus/trace/tracknode/TraceFragment;", "<init>", "()V", "modeSettingsItemSelectorMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/larus/bmhome/view/item/ItemTextSelector;", "autoLogEnterPage", "", "getCurrentPageName", "binding", "Lcom/obric/assistant/impl/databinding/ObricFragmentComplexTaskModeSettingBinding;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "onDestroyView", "setTopBar", "Lcom/larus/bmhome/view/NovaTitleBarEx;", "setupModeSetting", "()Lkotlin/Unit;", "createSelectItemByComplexTaskSettingsCommonItem", "context", "Landroid/content/Context;", "parentGroup", "Lcom/larus/bmhome/view/item/ItemGroup;", "item", "Lcom/obric/assistant/ComplexTaskSettingsCommonItem;", "isLast", "isOnly", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricComplexTaskModeSettingFragment extends TraceFragment {
    public static final /* synthetic */ int g = 0;
    public final ConcurrentHashMap<String, ItemTextSelector> e;
    public ObricFragmentComplexTaskModeSettingBinding f;

    public static final class a {
    }

    static {
    }

    public final boolean S90() {
        return true;
    }

    public final String k() {
        return "obric_complex_task_mode_setting";
    }

    public ObricComplexTaskModeSettingFragment() {
        this.e = new ConcurrentHashMap();
    }

    public final void onDestroyView() {
        super/*androidx.fragment.app.Fragment*/.onDestroyView();
        this.e.clear();
    }

    public final void onCreate(Bundle r1) {
        super.onCreate(r1);
    }

    public final void onViewCreated(View r13, Bundle r14) {
        Intrinsics.checkNotNullParameter(r13, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r13, r14);
        this.e.clear();
        ObricFragmentComplexTaskModeSettingBinding r15 = this.f;
        if (r15 == null) goto L5;
        NovaTitleBarEx r0 = r15.c;
        r0.setVisibility(0);
        NovaTitleBarEx.Y5(r0, getString(2131912118), null, null, 6);
        NovaTitleBarEx.b6(r0, 2131241477, false, null, null, new d(this), 14);
    L5:
        ObricFragmentComplexTaskModeSettingBinding r16 = this.f;
        if (r16 == null) goto L55;
        r16.b.setVisibility(0);
        ComplexTaskSettingsConfig r1 = t1.a.i0();
        FLogger.a.i("ObricComplexTaskModeSettingFragment", "setupModeSetting, getComplexTaskSettingsConfig, " + r1);
        r1.getDefaultComplexTaskMode();
        List r2 = r1.getComplexTaskModeList();
        if (r2 == null) goto L41;
        Iterator r3 = r2.iterator();
        int r4 = 0;
    L11:
        if (r3.hasNext() == false) goto L41;
        Object r5 = r3.next();
        int r6 = r4 + 1;
        if (r4 >= 0) goto L15;
        CollectionsKt.throwIndexOverflow();
    L15:
        final ComplexTaskSettingsCommonItem r7 = (ComplexTaskSettingsCommonItem) r5;
        Context r8 = getContext();
        if (r8 == null) goto L40;
        if (r4 != (r2.size() - 1)) goto L20;
        boolean r9 = true;
    L22:
        if (r2.size() != 1) goto L24;
        boolean r10 = true;
    L25:
        final ItemGroup r11 = r16.b;
        ItemTextSelector r12 = new ItemTextSelector(r8);
        if (r10 == false) goto L28;
        r12.setBackgroundResource(2131239222);
    L37:
        r11.addView(r12);
        ViewGroup.LayoutParams r17 = r12.getLayoutParams();
        Intrinsics.checkNotNull(r17, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        LinearLayout.LayoutParams r18 = (LinearLayout.LayoutParams) r17;
        r18.width = -1;
        r18.height = -2;
        r12.getTextView().setText(r7.getValue());
        r12.setClickable(true);
        e1.d(r12, new c(r7, r11));
        FLogger.a.i("ObricComplexTaskModeSettingFragment", "createSelectItemByComplexTaskSettingsCommonItem, " + r7 + ", " + r12);
        String r19 = r7.getKey();
        if (r19 == null) goto L40;
        this.e.put(r19, r12);
        goto L40
    L28:
        Integer r20 = r7.getId();
        if (r20 != null) goto L32;
    L34:
        if (r9 == false) goto L36;
        r12.setBackgroundResource(2131239215);
        goto L37
    L36:
        r12.setBackgroundResource(2131239218);
        goto L37
    L32:
        if (r20.intValue() != 1) goto L34;
        r12.setBackgroundResource(2131239212);
        goto L37
    L24:
        r10 = false;
        goto L25
    L20:
        r9 = false;
    L40:
        r4 = r6;
    L41:
        t1 r110 = t1.a;
        ItemTextSelector r21 = this.e.get(r110.f0());
        if (r21 == null) goto L44;
        r16.b.b(r21);
        Unit r111 = Unit.INSTANCE;
        return;
    L44:
        FLogger.a.i("ObricComplexTaskModeSettingFragment", "setupModeSetting, fallback to default, " + r1);
        String r22 = r110.i0().getDefaultComplexTaskMode();
        if (r22 != null) goto L47;
        r22 = "planexecute";
    L47:
        r110.H1(r22);
        ItemTextSelector r112 = this.e.get(r22);
        if (r112 == null) goto L57;
        r16.b.b(r112);
        Unit r113 = Unit.INSTANCE;
        return;
    L57:
        return;
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        View r5 = r2.inflate(2131563999, r3, false);
        int r6 = 2131373936;
        ItemGroup r7 = ViewBindings.findChildViewById(r5, 2131373936);
        if (r7 == null) goto L12;
        r6 = 2131389118;
        NovaTitleBarEx r0 = ViewBindings.findChildViewById(r5, 2131389118);
        if (r0 == null) goto L12;
        LinearLayout r8 = (LinearLayout) r5;
        this.f = new ObricFragmentComplexTaskModeSettingBinding(r8, r7, r0);
        if (r8 == null) goto L9;
        r8.setTag(2131377847, this);
        return r8;
    L9:
        return null;
    L12:
        throw new NullPointerException("Missing required view with ID: ".concat(r5.getResources().getResourceName(r6)));
    }
}
