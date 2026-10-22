package com.obric.assistant.settings.complextask;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBindings;
import com.larus.audio.call.util.n;
import com.larus.bmhome.view.NovaTitleBarEx;
import com.larus.bmhome.view.item.CustomSwitchCompat;
import com.larus.bmhome.view.item.ItemGroup;
import com.larus.bmhome.view.item.ItemTextArrow;
import com.larus.bmhome.view.item.ItemTextToggle;
import com.larus.trace.tracknode.TraceFragment;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.ComplexTaskSettingsCommonItem;
import com.obric.assistant.impl.databinding.ObricFragmentComplexTaskSettingsMainBinding;
import com.obric.assistant.t1;
import dga.e;
import dga.f;
import dga.g;
import dga.h;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J&\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u001a\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u000f2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\n\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0002J\u000f\u0010\u0018\u001a\u0004\u0018\u00010\u000bH\u0002¢\u0006\u0002\u0010\u0019J\u000f\u0010\u001a\u001a\u0004\u0018\u00010\u000bH\u0002¢\u0006\u0002\u0010\u0019J\u000f\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0002¢\u0006\u0002\u0010\u001dR\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/obric/assistant/settings/complextask/ObricComplexTaskSettingsMainFragment;", "Lcom/larus/trace/tracknode/TraceFragment;", "<init>", "()V", "autoLogEnterPage", "", "getCurrentPageName", "", "binding", "Lcom/obric/assistant/impl/databinding/ObricFragmentComplexTaskSettingsMainBinding;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "setTopBar", "Lcom/larus/bmhome/view/NovaTitleBarEx;", "setupComplexTaskLLMModelSettings", "()Lkotlin/Unit;", "setupComplexTaskModeSettings", "setupLocalDeepSearchSettings", "", "()Ljava/lang/Integer;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricComplexTaskSettingsMainFragment extends TraceFragment {
    public static final /* synthetic */ int f = 0;
    public ObricFragmentComplexTaskSettingsMainBinding e;

    public static final class a {
    }

    static {
    }

    public final boolean S90() {
        return true;
    }

    public final String k() {
        return "obric_complex_task_setting_main_fragment";
    }

    public ObricComplexTaskSettingsMainFragment() {
    }

    public final void onCreate(Bundle r1) {
        super.onCreate(r1);
    }

    public final void onViewCreated(View r11, Bundle r12) {
        Intrinsics.checkNotNullParameter(r11, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r11, r12);
        ObricFragmentComplexTaskSettingsMainBinding r13 = this.e;
        String r14 = null;
        boolean r0 = false;
        if (r13 == null) goto L5;
        NovaTitleBarEx r1 = r13.h;
        r1.setVisibility(0);
        NovaTitleBarEx.Y5(r1, getString(2131912119), null, null, 6);
        NovaTitleBarEx.b6(r1, 2131241477, false, null, null, new e(this), 14);
    L5:
        ObricFragmentComplexTaskSettingsMainBinding r15 = this.e;
        if (r15 == null) goto L45;
        FLogger.a.i("ObricComplexTaskSettingsMainFragment", "setupComplexTaskLLMModelSettings");
        r15.e.setVisibility(0);
        r15.c.setClickable(true);
        t1 r5 = t1.a;
        String r6 = r5.Q();
        List r7 = r5.i0().getComplexTaskLlmModelList();
        if (r7 == null) goto L18;
        Iterator r8 = r7.iterator();
        int r9 = 0;
    L11:
        if (r8.hasNext() == false) goto L16;
        if (Intrinsics.areEqual(((ComplexTaskSettingsCommonItem) r8.next()).getKey(), r6) == true) goto L17;
        r9 = r9 + 1;
    L17:
        Integer r10 = Integer.valueOf(r9);
    L19:
        if (r10 != null) goto L21;
    L27:
        FLogger.a.i("ObricComplexTaskSettingsMainFragment", "setupComplexTaskLLMModelSettings, fallback to default, current: " + r6 + ", list: " + r7);
        t1 r16 = t1.a;
        String r17 = r16.i0().getDefaultComplexTaskLlmModel();
        if (r17 != null) goto L30;
        r17 = "claude-37";
    L30:
        r16.D(r17);
        if (r7 == null) goto L42;
        Iterator r18 = r7.iterator();
    L34:
        if (r18.hasNext() == false) goto L38;
        Object r19 = r18.next();
        if (Intrinsics.areEqual(((ComplexTaskSettingsCommonItem) r19).getKey(), r17) == false) goto L34;
    L39:
        ComplexTaskSettingsCommonItem r20 = (ComplexTaskSettingsCommonItem) r19;
        if (r20 == null) goto L42;
        String r21 = r20.getValue();
    L43:
        r15.c.getSubTextView().setText(r21);
    L44:
        r15.c.setOnClickListener(new g(this));
        Unit r110 = Unit.INSTANCE;
        goto L45
    L38:
        r19 = null;
    L42:
        r21 = null;
        goto L43
    L21:
        if (r10.intValue() <= (-1)) goto L27;
        ComplexTaskSettingsCommonItem r22 = (ComplexTaskSettingsCommonItem) n.a(r7, r10.intValue());
        if (r22 == null) goto L25;
        String r23 = r22.getValue();
    L26:
        r15.c.getSubTextView().setText(r23);
        goto L44
    L25:
        r23 = null;
        goto L26
    L16:
        r9 = -1;
        goto L17
    L18:
        r10 = null;
    L45:
        ObricFragmentComplexTaskSettingsMainBinding r111 = this.e;
        if (r111 == null) goto L83;
        FLogger.a.i("ObricComplexTaskSettingsMainFragment", "setupComplexTaskModeSettings");
        r111.d.setVisibility(0);
        r111.b.setClickable(true);
        t1 r24 = t1.a;
        String r25 = r24.f0();
        List r26 = r24.i0().getComplexTaskModeList();
        if (r26 == null) goto L58;
        Iterator r27 = r26.iterator();
        int r28 = 0;
    L51:
        if (r27.hasNext() == false) goto L56;
        if (Intrinsics.areEqual(((ComplexTaskSettingsCommonItem) r27.next()).getKey(), r25) == true) goto L57;
        r28 = r28 + 1;
    L57:
        Integer r29 = Integer.valueOf(r28);
    L59:
        if (r29 != null) goto L61;
    L66:
        FLogger.a.i("ObricComplexTaskSettingsMainFragment", "setupComplexTaskModeSettings, fallback to default, current: " + r25 + ", list: " + r26);
        t1 r2 = t1.a;
        String r3 = r2.i0().getDefaultComplexTaskMode();
        if (r3 != null) goto L69;
        r3 = "planexecute";
    L69:
        r2.H1(r3);
        if (r26 == null) goto L81;
        Iterator r4 = r26.iterator();
    L73:
        if (r4.hasNext() == false) goto L77;
        Object r30 = r4.next();
        if (Intrinsics.areEqual(((ComplexTaskSettingsCommonItem) r30).getKey(), r3) == false) goto L73;
    L78:
        ComplexTaskSettingsCommonItem r31 = (ComplexTaskSettingsCommonItem) r30;
        if (r31 == null) goto L81;
        r14 = r31.getValue();
        goto L81
    L77:
        r30 = null;
    L81:
        r111.b.getSubTextView().setText(r14);
    L82:
        r111.b.setOnClickListener(new h(this));
        Unit r112 = Unit.INSTANCE;
        goto L83
    L61:
        if (r29.intValue() <= (-1)) goto L66;
        ComplexTaskSettingsCommonItem r32 = (ComplexTaskSettingsCommonItem) n.a(r26, r29.intValue());
        if (r32 == null) goto L65;
        r14 = r32.getValue();
    L65:
        r111.b.getSubTextView().setText(r14);
        goto L82
    L56:
        r28 = -1;
        goto L57
    L58:
        r29 = null;
    L83:
        ObricFragmentComplexTaskSettingsMainBinding r113 = this.e;
        if (r113 == null) goto L100;
        r113.f.setVisibility(0);
        int r114 = t1.a.T0();
        CustomSwitchCompat r33 = r113.g.getToggleView();
        if (r114 == 0) goto L88;
        r0 = true;
    L88:
        r33.setChecked(r0);
        r113.g.getToggleView().setOnCheckedChangeListener(new f());
        return;
    }

    public final View onCreateView(LayoutInflater r10, ViewGroup r11, Bundle r12) {
        Intrinsics.checkNotNullParameter(r10, "inflater");
        View r13 = r10.inflate(2131564000, r11, false);
        int r14 = 2131367603;
        ItemTextArrow r2 = ViewBindings.findChildViewById(r13, 2131367603);
        if (r2 == null) goto L22;
        r14 = 2131367605;
        ItemTextArrow r3 = ViewBindings.findChildViewById(r13, 2131367605);
        if (r3 == null) goto L22;
        r14 = 2131373937;
        ItemGroup r4 = ViewBindings.findChildViewById(r13, 2131373937);
        if (r4 == null) goto L22;
        r14 = 2131373938;
        ItemGroup r5 = ViewBindings.findChildViewById(r13, 2131373938);
        if (r5 == null) goto L22;
        r14 = 2131373977;
        ItemGroup r6 = ViewBindings.findChildViewById(r13, 2131373977);
        if (r6 == null) goto L22;
        r14 = 2131379102;
        ItemTextToggle r7 = ViewBindings.findChildViewById(r13, 2131379102);
        if (r7 == null) goto L22;
        r14 = 2131389118;
        NovaTitleBarEx r8 = ViewBindings.findChildViewById(r13, 2131389118);
        if (r8 == null) goto L22;
        LinearLayout r15 = (LinearLayout) r13;
        this.e = new ObricFragmentComplexTaskSettingsMainBinding(r15, r2, r3, r4, r5, r6, r7, r8);
        if (r15 == null) goto L19;
        r15.setTag(2131377847, this);
        return r15;
    L19:
        return null;
    L22:
        throw new NullPointerException("Missing required view with ID: ".concat(r13.getResources().getResourceName(r14)));
    }
}
