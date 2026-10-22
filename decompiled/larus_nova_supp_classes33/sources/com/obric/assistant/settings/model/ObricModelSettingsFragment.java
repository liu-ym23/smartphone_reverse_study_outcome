package com.obric.assistant.settings.model;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.core.view.ViewGroupKt;
import androidx.viewbinding.ViewBindings;
import com.larus.bmhome.view.NovaTitleBarEx;
import com.larus.bmhome.view.item.ItemGroup;
import com.larus.bmhome.view.item.ItemTextSelector;
import com.larus.trace.tracknode.TraceFragment;
import com.larus.utils.e1;
import com.obric.assistant.impl.databinding.ObricFragmentModelSettingsBinding;
import com.obric.assistant.settings.config.ModelSettingsConfig;
import com.obric.assistant.settings.config.ModelSettingsItem;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J&\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u001a\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u000f2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\n\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0002J\u000f\u0010\u0018\u001a\u0004\u0018\u00010\u000bH\u0002¢\u0006\u0002\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u0010\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/obric/assistant/settings/model/ObricModelSettingsFragment;", "Lcom/larus/trace/tracknode/TraceFragment;", "<init>", "()V", "autoLogEnterPage", "", "getCurrentPageName", "", "binding", "Lcom/obric/assistant/impl/databinding/ObricFragmentModelSettingsBinding;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "setTopBar", "Lcom/larus/bmhome/view/NovaTitleBarEx;", "setupSettings", "()Lkotlin/Unit;", "showModelSelect", "model", "Lcom/obric/assistant/settings/config/ModelSettingsItem;", "doModelSelect", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricModelSettingsFragment extends TraceFragment {
    public static final /* synthetic */ int f = 0;
    public ObricFragmentModelSettingsBinding e;

    public static final class a {
    }

    static {
    }

    public final boolean S90() {
        return true;
    }

    public final String k() {
        return "obric_model_settings_fragment";
    }

    public ObricModelSettingsFragment() {
    }

    public final void U90(ModelSettingsItem r4) {
        ObricFragmentModelSettingsBinding r0 = this.e;
        if (r0 == null) goto L7;
        ItemGroup r1 = r0.b;
        if (r1 == null) goto L7;
        Sequence r2 = ViewGroupKt.getChildren(r1);
    L8:
        if (r2 != null) goto L10;
        r2 = SequencesKt.emptySequence();
    L10:
        Iterator r3 = r2.iterator();
    L12:
        if (r3.hasNext() == false) goto L14;
        View r5 = (View) r3.next();
        r5.setSelected(Intrinsics.areEqual(r5.getTag(), r4));
        goto L12
    L14:
        return;
    L7:
        r2 = null;
        goto L8
    }

    public final void onCreate(Bundle r1) {
        super.onCreate(r1);
    }

    public final void onViewCreated(View r10, Bundle r11) {
        Intrinsics.checkNotNullParameter(r10, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r10, r11);
        ObricFragmentModelSettingsBinding r12 = this.e;
        int r13 = 0;
        if (r12 == null) goto L5;
        NovaTitleBarEx r0 = r12.c;
        r0.setVisibility(0);
        NovaTitleBarEx.Y5(r0, getString(2131911963), null, null, 6);
        NovaTitleBarEx.b6(r0, 2131241477, false, null, null, new com.obric.assistant.settings.model.a(this), 14);
    L5:
        ObricFragmentModelSettingsBinding r14 = this.e;
        if (r14 != null) goto L8;
        return;
    L8:
        if (Build.VERSION.SDK_INT < 33) goto L14;
        Bundle r1 = getArguments();
        if (r1 == null) goto L43;
        ModelSettingsConfig r2 = (ModelSettingsConfig) r1.getParcelable("model_settings_config", ModelSettingsConfig.class);
        if (r2 == null) goto L43;
    L19:
        Bundle r3 = getArguments();
        if (r3 == null) goto L43;
        String r4 = r3.getString("current_assistant_model");
        if (r4 == null) goto L43;
        r14.b.removeAllViews();
        List<ModelSettingsItem> r5 = r2.getModelList();
        int r6 = r5.size();
        Iterator<T> r7 = r5.iterator();
    L26:
        if (r7.hasNext() == false) goto L40;
        int r8 = r13 + 1;
        final ModelSettingsItem r9 = (ModelSettingsItem) r7.next();
        ItemTextSelector r15 = new ItemTextSelector(requireContext());
        String r16 = r9.getName();
        if (r16 != null) goto L30;
        r16 = "";
    L30:
        r15.setText(r16);
        if (r6 != 1) goto L33;
        int r17 = 2131239210;
    L39:
        r15.setBackgroundResource(r17);
        r15.setTag(r9);
        e1.d(r15, new b(this, r9));
        r14.b.addView(r15, new ViewGroup.LayoutParams(-1, -2));
        r13 = r8;
        goto L26
    L33:
        if (r13 != 0) goto L36;
        r17 = 2131239212;
        goto L39
    L36:
        if (r13 != (r6 - 1)) goto L38;
        r17 = 2131239215;
        goto L39
    L38:
        r17 = 2131239218;
        goto L39
    L40:
        ModelSettingsItem r18 = r2.getModel(r4);
        if (r18 == null) goto L43;
        U90(r18);
    L43:
        Unit r19 = Unit.INSTANCE;
        return;
    L14:
        Bundle r20 = getArguments();
        if (r20 == null) goto L18;
        r2 = (ModelSettingsConfig) r20.getParcelable("model_settings_config");
        if (r2 != null) goto L19;
    L18:
        r2 = new ModelSettingsConfig(0, false, null, null, 15, null);
        goto L19
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        View r5 = r2.inflate(2131564003, r3, false);
        int r6 = 2131373982;
        ItemGroup r7 = ViewBindings.findChildViewById(r5, 2131373982);
        if (r7 == null) goto L12;
        r6 = 2131389118;
        NovaTitleBarEx r0 = ViewBindings.findChildViewById(r5, 2131389118);
        if (r0 == null) goto L12;
        LinearLayout r8 = (LinearLayout) r5;
        this.e = new ObricFragmentModelSettingsBinding(r8, r7, r0);
        if (r8 == null) goto L9;
        r8.setTag(2131377847, this);
        return r8;
    L9:
        return null;
    L12:
        throw new NullPointerException("Missing required view with ID: ".concat(r5.getResources().getResourceName(r6)));
    }
}
