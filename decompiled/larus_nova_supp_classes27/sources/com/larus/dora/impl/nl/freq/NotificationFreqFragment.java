package com.larus.dora.impl.nl.freq;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.viewbinding.ViewBindings;
import com.larus.bmhome.view.NovaTitleBarEx;
import com.larus.bmhome.view.item.ItemTextSelector;
import com.larus.dora.impl.databinding.LarusDoraPageNotificationFreqBinding;
import com.larus.dora.impl.device.DoraBaseFragment;
import com.larus.utils.e1;
import com.larus.utils.j0;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u001a\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\n\u0010\u0013\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u0012H\u0002J\n\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0002J\u0017\u0010\u0019\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u001a\u001a\u00020\u001bH\u0002¢\u0006\u0002\u0010\u001cR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/larus/dora/impl/nl/freq/NotificationFreqFragment;", "Lcom/larus/dora/impl/device/DoraBaseFragment;", "<init>", "()V", "binding", "Lcom/larus/dora/impl/databinding/LarusDoraPageNotificationFreqBinding;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "getCurrentPageName", "", "getPageMaskView", "setupTitle", "Lcom/larus/bmhome/view/NovaTitleBarEx;", "titleText", "setPrefer", "Lcom/larus/bmhome/view/item/ItemTextSelector;", "updateSelectItemView", "freq", "", "(I)Lkotlin/Unit;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class NotificationFreqFragment extends DoraBaseFragment {
    public static final /* synthetic */ int g = 0;
    public LarusDoraPageNotificationFreqBinding f;

    public static final class a {
    }

    public static final class b<T> implements FlowCollector {
        public final /* synthetic */ NotificationFreqFragment a;

        public b(NotificationFreqFragment r1) {
            this.a = r1;
        }

        public final Object emit(Object r5, Continuation r6) {
            int r7 = ((Number) r5).intValue();
            LarusDoraPageNotificationFreqBinding r8 = this.a.f;
            if (r8 == null) goto L17;
            ItemTextSelector r0 = r8.d;
            boolean r2 = false;
            if (r7 != NotificationFreq.NOTIFICATION_FREQ_5.getFreq()) goto L7;
            boolean r1 = true;
        L8:
            r0.setSelected(r1);
            ItemTextSelector r3 = r8.b;
            if (r7 != NotificationFreq.NOTIFICATION_FREQ_10.getFreq()) goto L11;
            boolean r4 = true;
        L12:
            r3.setSelected(r4);
            ItemTextSelector r9 = r8.c;
            if (r7 != NotificationFreq.NOTIFICATION_FREQ_15.getFreq()) goto L15;
            r2 = true;
        L15:
            r9.setSelected(r2);
            Unit r10 = Unit.INSTANCE;
            goto L17
        L11:
            r4 = false;
            goto L12
        L7:
            r1 = false;
        L17:
            return Unit.INSTANCE;
        }
    }

    static {
    }

    public final String k() {
        return "proactive_summary_timeliness";
    }

    @Override // com.larus.dora.impl.device.DoraBaseFragment
    public final View U90() {
        LarusDoraPageNotificationFreqBinding r0 = this.f;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.e;
    }

    public NotificationFreqFragment() {
    }

    public final void onViewCreated(View r9, Bundle r10) {
        Intrinsics.checkNotNullParameter(r9, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r9, r10);
        int r11 = j0.a;
        String r12 = j0.d(2131902245);
        LarusDoraPageNotificationFreqBinding r13 = this.f;
        if (r13 == null) goto L5;
        NovaTitleBarEx r1 = r13.f;
        NovaTitleBarEx.Y5(r1, r12, null, null, 6);
        NovaTitleBarEx.b6(r1, 2131240517, false, null, null, new com.larus.dora.impl.nl.freq.a(this), 14);
    L5:
        LarusDoraPageNotificationFreqBinding r14 = this.f;
        if (r14 == null) goto L8;
        ItemTextSelector r15 = r14.d;
        r15.setText(j0.d(NotificationFreq.NOTIFICATION_FREQ_5.getDescResId()));
        e1.d(r15, new com.larus.dora.impl.nl.freq.b());
        ItemTextSelector r16 = r14.b;
        r16.setText(j0.d(NotificationFreq.NOTIFICATION_FREQ_10.getDescResId()));
        e1.d(r16, new c());
        ItemTextSelector r17 = r14.c;
        r17.setText(j0.d(NotificationFreq.NOTIFICATION_FREQ_15.getDescResId()));
        e1.d(r17, new d());
    L8:
        Lifecycle.State r18 = Lifecycle.State.STARTED;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new NotificationFreqFragment$onViewCreated$$inlined$launchAndRepeatWithViewLifecycle$default$1(this, r18, null, this), 3, null);
    }

    public final View onCreateView(LayoutInflater r8, ViewGroup r9, Bundle r10) {
        Intrinsics.checkNotNullParameter(r8, "inflater");
        ConstraintLayout r11 = r8.inflate(2131562279, r9, false);
        int r12 = 2131369761;
        ItemTextSelector r2 = ViewBindings.findChildViewById(r11, 2131369761);
        if (r2 == null) goto L19;
        r12 = 2131369762;
        ItemTextSelector r3 = ViewBindings.findChildViewById(r11, 2131369762);
        if (r3 == null) goto L19;
        r12 = 2131369763;
        ItemTextSelector r4 = ViewBindings.findChildViewById(r11, 2131369763);
        if (r4 == null) goto L19;
        r12 = 2131369764;
        if (ViewBindings.findChildViewById(r11, 2131369764) == null) goto L19;
        r12 = 2131369962;
        View r5 = ViewBindings.findChildViewById(r11, 2131369962);
        if (r5 == null) goto L19;
        r12 = 2131385238;
        if (((ScrollView) ViewBindings.findChildViewById(r11, 2131385238)) == null) goto L19;
        r12 = 2131388772;
        NovaTitleBarEx r6 = ViewBindings.findChildViewById(r11, 2131388772);
        if (r6 == null) goto L19;
        ConstraintLayout r13 = r11;
        this.f = new LarusDoraPageNotificationFreqBinding(r13, r2, r3, r4, r5, r6);
        return r13;
    L19:
        throw new NullPointerException("Missing required view with ID: ".concat(r11.getResources().getResourceName(r12)));
    }
}
