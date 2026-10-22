package com.larus.avlink.simulInterpret.settings;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBindings;
import com.larus.avlink.impl.databinding.LarusDoraPageTimbreCloneBinding;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.view.NovaTitleBarEx;
import com.larus.bmhome.view.item.CustomSwitchCompat;
import com.larus.bmhome.view.item.ItemTextToggle;
import com.larus.common_ui.dialog.CommonDialog;
import com.larus.dora.api.DoraConfig;
import com.larus.trace.tracknode.TraceFragment;
import com.larus.utils.o0;
import ga8.b;
import ga8.c;
import ga8.e;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u000e\u001a\u00020\fH\u0016J&\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u001a\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u00102\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\b\u0010\u0019\u001a\u00020\u0007H\u0016J\n\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0002J\u0010\u0010\u001c\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\fH\u0002J\u0010\u0010\u001e\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\fH\u0002J\u0010\u0010\u001f\u001a\u00020\r2\u0006\u0010 \u001a\u00020\fH\u0002J\b\u0010!\u001a\u00020\rH\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/larus/avlink/simulInterpret/settings/TimbreCloneFragment;", "Lcom/larus/trace/tracknode/TraceFragment;", "<init>", "()V", "binding", "Lcom/larus/avlink/impl/databinding/LarusDoraPageTimbreCloneBinding;", "TAG", "", "speakCloneDialog", "Lcom/larus/common_ui/dialog/CommonDialog;", "switchListener", "Lkotlin/Function1;", "", "", "autoLogEnterPage", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "getCurrentPageName", "setupTitle", "Lcom/larus/bmhome/view/NovaTitleBarEx;", "showRestartDialog", "isChecked", "saveSpeakerCloneOption", "restoreSwitchState", "targetState", "dismissRestartDialog", "Companion", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class TimbreCloneFragment extends TraceFragment {
    public static final /* synthetic */ int i = 0;
    public LarusDoraPageTimbreCloneBinding e;
    public final String f;
    public CommonDialog g;
    public ga8.a h;

    public static final class a {
    }

    static {
    }

    public final boolean S90() {
        return true;
    }

    public final String k() {
        return "general_setting";
    }

    public TimbreCloneFragment() {
        this.f = "TimbreCloneFragment";
    }

    public final void U90(boolean r3) {
        LarusDoraPageTimbreCloneBinding r0 = this.e;
        if (r0 == null) goto L11;
        ItemTextToggle r1 = r0.b;
        if (r1 == null) goto L12;
        CustomSwitchCompat r2 = r1.getToggleView();
        if (r2 == null) goto L13;
        r2.setOnCheckedChangeListener(null);
        r2.setChecked(r3);
        r2.setOnCheckedChangeListener(new e(this));
        return;
    L13:
        return;
    L12:
        return;
    }

    public final void onViewCreated(View r8, Bundle r9) {
        Intrinsics.checkNotNullParameter(r8, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r8, r9);
        LarusDoraPageTimbreCloneBinding r10 = this.e;
        if (r10 == null) goto L5;
        NovaTitleBarEx r0 = r10.c;
        NovaTitleBarEx.Y5(r0, getString(2131904004), null, null, 6);
        NovaTitleBarEx.b6(r0, 2131241477, false, null, null, new c(this), 14);
    L5:
        LarusDoraPageTimbreCloneBinding r11 = this.e;
        if (r11 == null) goto L12;
        ItemTextToggle r12 = r11.b;
        if (r12 == null) goto L12;
        CustomSwitchCompat r13 = r12.getToggleView();
        if (r13 == null) goto L12;
        r13.setChecked(o0.d(DoraConfig.a.getString("key_timbre_clone", "")));
    L12:
        this.h = new ga8.a(this);
        LarusDoraPageTimbreCloneBinding r14 = this.e;
        if (r14 == null) goto L20;
        ItemTextToggle r15 = r14.b;
        if (r15 == null) goto L21;
        CustomSwitchCompat r16 = r15.getToggleView();
        if (r16 == null) goto L22;
        r16.setOnCheckedChangeListener(new b(this));
        return;
    L22:
        return;
    L21:
        return;
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        ConstraintLayout r5 = r2.inflate(2131562293, r3, false);
        int r6 = 2131369711;
        if (ViewBindings.findChildViewById(r5, 2131369711) == null) goto L15;
        r6 = 2131385238;
        if (((ScrollView) ViewBindings.findChildViewById(r5, 2131385238)) == null) goto L15;
        r6 = 2131388650;
        if (ViewBindings.findChildViewById(r5, 2131388650) == null) goto L15;
        r6 = 2131388652;
        ItemTextToggle r7 = ViewBindings.findChildViewById(r5, 2131388652);
        if (r7 == null) goto L15;
        r6 = 2131388772;
        NovaTitleBarEx r0 = ViewBindings.findChildViewById(r5, 2131388772);
        if (r0 == null) goto L15;
        ConstraintLayout r8 = r5;
        this.e = new LarusDoraPageTimbreCloneBinding(r8, r7, r0);
        return r8;
    L15:
        throw new NullPointerException("Missing required view with ID: ".concat(r5.getResources().getResourceName(r6)));
    }
}
