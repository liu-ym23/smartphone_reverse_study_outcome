package com.larus.setting.impl;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.viewbinding.ViewBindings;
import com.larus.bmhome.chat.setting.bean.UserConfigKey;
import com.larus.bmhome.chat.setting.bean.UserConfigPullReason;
import com.larus.bmhome.view.NovaTitleBarEx;
import com.larus.setting.api.data.FlowSettingsScene;
import com.larus.setting.impl.databinding.LarusPageNotifySettingBinding;
import com.larus.trace.tracknode.TraceFragment;
import com.tencent.open.log.TraceLevel;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u001aH\u0002J\n\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0002J\b\u0010\u001e\u001a\u00020\u001fH\u0016J\b\u0010 \u001a\u00020!H\u0016J\b\u0010\"\u001a\u00020\u001aH\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\b\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/larus/setting/impl/NotifySettingsFragment;", "Lcom/larus/trace/tracknode/TraceFragment;", "<init>", "()V", "binding", "Lcom/larus/setting/impl/databinding/LarusPageNotifySettingBinding;", "provider", "Lcom/larus/setting/api/FlowNotifySettingsProvider;", "model", "Lcom/larus/setting/impl/SettingModel;", "getModel", "()Lcom/larus/setting/impl/SettingModel;", "model$delegate", "Lkotlin/Lazy;", "sectionFetchGeneration", "", "remoteRefreshGeneration", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "", "setSettingItem", "setupTitle", "Lcom/larus/bmhome/view/NovaTitleBarEx;", "autoLogEnterPage", "", "getCurrentPageName", "", "onDestroyView", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class NotifySettingsFragment extends TraceFragment {
    public static final /* synthetic */ int j = 0;
    public LarusPageNotifySettingBinding e;
    public final com.larus.setting.api.h f;
    public final Lazy g;
    public int h;
    public int i;

    public final boolean S90() {
        return true;
    }

    public final String k() {
        return "notify_settings_page";
    }

    public final void onDestroyView() {
        this.h++;
        this.i++;
        this.e = null;
        super/*androidx.fragment.app.Fragment*/.onDestroyView();
    }

    public NotifySettingsFragment() {
        this.f = com.larus.setting.api.h.a;
        final Function0<Fragment> r0 = new NotifySettingsFragment$special$$inlined$viewModels$default$1(this);
        this.g = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(SettingModel.class), new NotifySettingsFragment$special$$inlined$viewModels$default$2(r0), new NotifySettingsFragment$special$$inlined$viewModels$default$3(r0, this));
    }

    public final void onResume() {
        super.onResume();
        final int r0 = this.i + 1;
        this.i = r0;
        ((SettingModel) this.g.getValue()).updateUserConfigs(CollectionsKt.listOf(new Integer[]{Integer.valueOf(UserConfigKey.SYSTEM_PUSH_SWITCH.getValue()), Integer.valueOf(UserConfigKey.IN_APP_BANNER_SWITCH.getValue()), Integer.valueOf(UserConfigKey.IN_APP_BANNER_SHOW_DETAIL.getValue()), Integer.valueOf(UserConfigKey.IN_APP_BANNER_SHOW_DETAIL_ADMIN_SWITCH.getValue())}), UserConfigPullReason.NOTIFIED.getValue(), new e1(r0, this));
    }

    public final View onCreateView(LayoutInflater r9, ViewGroup r10, Bundle r11) {
        Intrinsics.checkNotNullParameter(r9, "inflater");
        View r12 = r9.inflate(2131563054, r10, false);
        int r13 = 2131367771;
        LinearLayout r14 = (LinearLayout) ViewBindings.findChildViewById(r12, 2131367771);
        if (r14 == null) goto L17;
        r13 = 2131381070;
        NovaTitleBarEx r1 = ViewBindings.findChildViewById(r12, 2131381070);
        if (r1 == null) goto L17;
        r13 = 2131385238;
        if (((ScrollView) ViewBindings.findChildViewById(r12, 2131385238)) == null) goto L17;
        this.e = new LarusPageNotifySettingBinding((LinearLayout) r12, r14, r1);
        NovaTitleBarEx.Y5(r1, getString(2131909301), null, null, 6);
        NovaTitleBarEx.b6(r1, 2131241477, false, null, null, new f1(this), 14);
        LarusPageNotifySettingBinding r15 = this.e;
        if (r15 == null) goto L12;
        int r16 = this.h + 1;
        this.h = r16;
        this.f.a(getActivity(), FlowSettingsScene.NOTIFY, new d1(this, r16, r15));
    L12:
        LarusPageNotifySettingBinding r17 = this.e;
        if (r17 != null) goto L15;
        return null;
    L15:
        return r17.a;
    L17:
        throw new NullPointerException("Missing required view with ID: ".concat(r12.getResources().getResourceName(r13)));
    }
}
