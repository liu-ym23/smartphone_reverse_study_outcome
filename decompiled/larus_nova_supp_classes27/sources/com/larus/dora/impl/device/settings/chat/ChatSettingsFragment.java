package com.larus.dora.impl.device.settings.chat;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.viewbinding.ViewBindings;
import com.larus.bmhome.view.NovaTitleBarEx;
import com.larus.bmhome.view.item.ItemGroup;
import com.larus.bmhome.view.item.ItemTextSelector;
import com.larus.bmhome.view.item.ItemTextSelectorSubTitle;
import com.larus.dora.impl.databinding.LarusDoraPageChatSettingsBinding;
import com.larus.dora.impl.device.DoraBaseFragment;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.utils.j0;
import g49.d;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u001a\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\r2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\b\u0010\u0017\u001a\u00020\u0015H\u0002J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\n\u0010\u001a\u001a\u0004\u0018\u00010\rH\u0016J\n\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\t¨\u0006\u001e"}, d2 = {"Lcom/larus/dora/impl/device/settings/chat/ChatSettingsFragment;", "Lcom/larus/dora/impl/device/DoraBaseFragment;", "<init>", "()V", "binding", "Lcom/larus/dora/impl/databinding/LarusDoraPageChatSettingsBinding;", DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL, "Lcom/larus/dora/impl/device/settings/chat/ChatSettingsViewModel;", "getModel", "()Lcom/larus/dora/impl/device/settings/chat/ChatSettingsViewModel;", "model$delegate", "Lkotlin/Lazy;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "setupUI", "getCurrentPageName", "", "getPageMaskView", "setupTitle", "Lcom/larus/bmhome/view/NovaTitleBarEx;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChatSettingsFragment extends DoraBaseFragment {
    public static final /* synthetic */ int h = 0;
    public LarusDoraPageChatSettingsBinding f;
    public final Lazy g;

    public static final class a {
    }

    public static final class b<T> implements FlowCollector {
        public final /* synthetic */ ChatSettingsFragment a;

        public b(ChatSettingsFragment r1) {
            this.a = r1;
        }

        public final Object emit(Object r3, Continuation r4) {
            ChatSettingsViewModel.a r5 = (ChatSettingsViewModel.a) r3;
            d.a("ChatSettingsFragment", "chatSettingsStateFlow: isBurstTakeImageEnabled " + r5.a + ", isPreTakeImageEnabled " + r5.b);
            LarusDoraPageChatSettingsBinding r6 = this.a.f;
            if (r6 == null) goto L12;
            if (r5.a == false) goto L8;
            r6.c.setSelected(false);
            r6.d.setSelected(false);
            goto L12
        L8:
            if (r5.b == false) goto L10;
            r6.c.setSelected(true);
            r6.d.setSelected(false);
            goto L12
        L10:
            r6.c.setSelected(false);
            r6.d.setSelected(true);
        L12:
            return Unit.INSTANCE;
        }
    }

    static {
    }

    public final String k() {
        return "chat_settings";
    }

    @Override // com.larus.dora.impl.device.DoraBaseFragment
    public final View U90() {
        LarusDoraPageChatSettingsBinding r0 = this.f;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.f;
    }

    public ChatSettingsFragment() {
        this.g = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(ChatSettingsViewModel.class), new ChatSettingsFragment$special$$inlined$activityViewModels$default$1(this), new ChatSettingsFragment$special$$inlined$activityViewModels$default$2(this));
    }

    public final void onViewCreated(View r8, Bundle r9) {
        Intrinsics.checkNotNullParameter(r8, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r8, r9);
        LarusDoraPageChatSettingsBinding r10 = this.f;
        if (r10 == null) goto L5;
        NovaTitleBarEx r0 = r10.g;
        NovaTitleBarEx.Y5(r0, "豆包视觉能力", null, null, 6);
        NovaTitleBarEx.b6(r0, 2131240517, false, null, null, new c(this), 14);
    L5:
        LarusDoraPageChatSettingsBinding r11 = this.f;
        if (r11 == null) goto L8;
        ItemTextSelectorSubTitle r1 = r11.c;
        int r2 = j0.a;
        r1.setMainTitle(j0.d(2131902492));
        r11.c.setSubTitle(j0.d(2131902493));
        r11.c.setOnClickListener(new com.larus.dora.impl.device.settings.chat.a(this));
        r11.d.setMainTitle(j0.d(2131902488));
        r11.d.setSubTitle(j0.d(2131902489));
        r11.d.setOnClickListener(new com.larus.dora.impl.device.settings.chat.b(this));
        r11.e.b(r11.b);
    L8:
        Lifecycle.State r12 = Lifecycle.State.STARTED;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new ChatSettingsFragment$onViewCreated$$inlined$launchAndRepeatWithViewLifecycle$default$1(this, r12, null, this), 3, null);
        ((ChatSettingsViewModel) this.g.getValue()).loadCameraSettings();
    }

    public final View onCreateView(LayoutInflater r9, ViewGroup r10, Bundle r11) {
        Intrinsics.checkNotNullParameter(r9, "inflater");
        ConstraintLayout r12 = r9.inflate(2131562258, r10, false);
        int r13 = 2131369434;
        ItemTextSelector r2 = ViewBindings.findChildViewById(r12, 2131369434);
        if (r2 == null) goto L23;
        r13 = 2131369435;
        ItemTextSelectorSubTitle r3 = ViewBindings.findChildViewById(r12, 2131369435);
        if (r3 == null) goto L23;
        r13 = 2131369436;
        ItemTextSelectorSubTitle r4 = ViewBindings.findChildViewById(r12, 2131369436);
        if (r4 == null) goto L23;
        r13 = 2131369437;
        if (ViewBindings.findChildViewById(r12, 2131369437) == null) goto L23;
        r13 = 2131369438;
        if (ViewBindings.findChildViewById(r12, 2131369438) == null) goto L23;
        r13 = 2131369439;
        ItemGroup r5 = ViewBindings.findChildViewById(r12, 2131369439);
        if (r5 == null) goto L23;
        r13 = 2131369962;
        View r6 = ViewBindings.findChildViewById(r12, 2131369962);
        if (r6 == null) goto L23;
        r13 = 2131385238;
        if (((ScrollView) ViewBindings.findChildViewById(r12, 2131385238)) == null) goto L23;
        r13 = 2131388772;
        NovaTitleBarEx r7 = ViewBindings.findChildViewById(r12, 2131388772);
        if (r7 == null) goto L23;
        ConstraintLayout r14 = r12;
        this.f = new LarusDoraPageChatSettingsBinding(r14, r2, r3, r4, r5, r6, r7);
        return r14;
    L23:
        throw new NullPointerException("Missing required view with ID: ".concat(r12.getResources().getResourceName(r13)));
    }
}
