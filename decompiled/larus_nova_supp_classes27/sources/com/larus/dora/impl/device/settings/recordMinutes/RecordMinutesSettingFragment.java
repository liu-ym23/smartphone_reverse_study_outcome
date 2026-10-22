package com.larus.dora.impl.device.settings.recordMinutes;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBindings;
import com.larus.bmhome.view.NovaTitleBarEx;
import com.larus.bmhome.view.item.CustomSwitchCompat;
import com.larus.bmhome.view.item.ItemTextToggle;
import com.larus.dora.api.DoraConfig;
import com.larus.dora.impl.databinding.LarusDoraPageRecordMinutesBinding;
import com.larus.dora.impl.device.DoraBaseFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u001a\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\n\u0010\u0013\u001a\u0004\u0018\u00010\u0007H\u0016J\n\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0002J\n\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/larus/dora/impl/device/settings/recordMinutes/RecordMinutesSettingFragment;", "Lcom/larus/dora/impl/device/DoraBaseFragment;", "<init>", "()V", "binding", "Lcom/larus/dora/impl/databinding/LarusDoraPageRecordMinutesBinding;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "getCurrentPageName", "", "getPageMaskView", "setListeners", "Lcom/larus/bmhome/view/item/CustomSwitchCompat;", "setTitle", "Lcom/larus/bmhome/view/NovaTitleBarEx;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RecordMinutesSettingFragment extends DoraBaseFragment {
    public static final /* synthetic */ int g = 0;
    public LarusDoraPageRecordMinutesBinding f;

    public static final class a {
    }

    static {
    }

    public final String k() {
        return "record_minutes_setting";
    }

    @Override // com.larus.dora.impl.device.DoraBaseFragment
    public final View U90() {
        LarusDoraPageRecordMinutesBinding r0 = this.f;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.b;
    }

    public RecordMinutesSettingFragment() {
    }

    public final void onViewCreated(View r8, Bundle r9) {
        Intrinsics.checkNotNullParameter(r8, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r8, r9);
        LarusDoraPageRecordMinutesBinding r10 = this.f;
        if (r10 == null) goto L5;
        NovaTitleBarEx r0 = r10.d;
        NovaTitleBarEx.Y5(r0, getString(2131902912), null, null, 6);
        NovaTitleBarEx.b6(r0, 2131240517, false, null, null, new d(this), 14);
    L5:
        LarusDoraPageRecordMinutesBinding r11 = this.f;
        if (r11 == null) goto L9;
        CustomSwitchCompat r12 = r11.c.getToggleView();
        r12.setOnCheckedChangeListener(null);
        r12.setChecked(DoraConfig.a.getBoolean("key_auto_record_in_call", false));
        r12.setOnCheckedChangeListener(new c());
        return;
    }

    public final View onCreateView(LayoutInflater r3, ViewGroup r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r3, "inflater");
        ConstraintLayout r6 = r3.inflate(2131562289, r4, false);
        int r7 = 2131369962;
        View r8 = ViewBindings.findChildViewById(r6, 2131369962);
        if (r8 == null) goto L15;
        r7 = 2131369993;
        ItemTextToggle r0 = ViewBindings.findChildViewById(r6, 2131369993);
        if (r0 == null) goto L15;
        r7 = 2131369994;
        if (ViewBindings.findChildViewById(r6, 2131369994) == null) goto L15;
        r7 = 2131385238;
        if (((ScrollView) ViewBindings.findChildViewById(r6, 2131385238)) == null) goto L15;
        r7 = 2131388772;
        NovaTitleBarEx r1 = ViewBindings.findChildViewById(r6, 2131388772);
        if (r1 == null) goto L15;
        ConstraintLayout r9 = r6;
        this.f = new LarusDoraPageRecordMinutesBinding(r9, r8, r0, r1);
        return r9;
    L15:
        throw new NullPointerException("Missing required view with ID: ".concat(r6.getResources().getResourceName(r7)));
    }
}
