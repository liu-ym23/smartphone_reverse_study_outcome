package com.larus.setting.impl.modeltraining;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Observer;
import androidx.viewbinding.ViewBindings;
import com.larus.bmhome.view.NovaTitleBarEx;
import com.larus.bmhome.view.item.ItemGroup;
import com.larus.bmhome.view.item.ItemTextArrow;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.widget.UrlSpanTextView;
import com.larus.setting.impl.DataPermissionBottomSheet;
import com.larus.setting.impl.SettingModel;
import com.larus.setting.impl.databinding.LarusPagePrivacyModelTrainingSettingBinding;
import com.larus.utils.e1;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.obric.assistant.spi.training.IObricPrivacyModelTrainingService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.tencent.open.log.TraceLevel;
import java.util.Arrays;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000 .2\u00020\u0001:\u0001.B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u001a\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00152\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\b\u0010\u001f\u001a\u00020\u001dH\u0016J\b\u0010 \u001a\u00020\u001dH\u0002J\b\u0010!\u001a\u00020\u001dH\u0002J\b\u0010\"\u001a\u00020\u001dH\u0002J\b\u0010#\u001a\u00020\u001dH\u0002J\b\u0010$\u001a\u00020\u001dH\u0002J\u0018\u0010%\u001a\u00020\u001d2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)H\u0002J\u0018\u0010*\u001a\u00020\u001d2\u0006\u0010&\u001a\u00020'2\u0006\u0010+\u001a\u00020\rH\u0002J\u000f\u0010,\u001a\u0004\u0018\u00010\u001dH\u0002¢\u0006\u0002\u0010-R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\f\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\t\u001a\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0011\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\t\u001a\u0004\b\u0012\u0010\u000f¨\u0006/"}, d2 = {"Lcom/larus/setting/impl/modeltraining/PrivacyModelTrainingFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "model", "Lcom/larus/setting/impl/SettingModel;", "getModel", "()Lcom/larus/setting/impl/SettingModel;", "model$delegate", "Lkotlin/Lazy;", "binding", "Lcom/larus/setting/impl/databinding/LarusPagePrivacyModelTrainingSettingBinding;", "statusOn", "", "getStatusOn", "()Ljava/lang/String;", "statusOn$delegate", "statusOff", "getStatusOff", "statusOff$delegate", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "onDestroyView", "initTopBar", "initBackButton", "initPrivacySubtitle", "initViewModel", "openPrivacyNewLink", "setSubText", "item", "Lcom/larus/bmhome/view/item/ItemTextArrow;", "condition", "", "setClickListener", "tag", "initCustomModelTrainingGroup", "()Lkotlin/Unit;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class PrivacyModelTrainingFragment extends Fragment {
    public static final /* synthetic */ int h = 0;
    public final Lazy d;
    public LarusPagePrivacyModelTrainingSettingBinding e;
    public final Lazy f;
    public final Lazy g;

    public static final class a {
    }

    public static final class b implements Observer, FunctionAdapter {
        public final /* synthetic */ Function1 a;

        public b(Function1 r2) {
            Intrinsics.checkNotNullParameter(r2, "function");
            this.a = r2;
        }

        public final boolean equals(Object r3) {
            if ((r3 instanceof Observer) == true) goto L5;
            return false;
        L5:
            if ((r3 instanceof FunctionAdapter) == true) goto L7;
            return false;
        L7:
            return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) r3).getFunctionDelegate());
        }

        public final Function<?> getFunctionDelegate() {
            return this.a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        public final /* synthetic */ void onChanged(Object r2) {
            this.a.invoke(r2);
        }
    }

    static {
    }

    public final SettingModel T90() {
        return (SettingModel) this.d.getValue();
    }

    public final void onDestroyView() {
        IObricPrivacyModelTrainingService r0 = (IObricPrivacyModelTrainingService) ServiceManager.get().getService(IObricPrivacyModelTrainingService.class);
        if (r0 == null) goto L5;
        r0.c();
    L5:
        this.e = null;
        super.onDestroyView();
    }

    public PrivacyModelTrainingFragment() {
        this.d = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(SettingModel.class), new PrivacyModelTrainingFragment$special$$inlined$activityViewModels$default$1(this), new PrivacyModelTrainingFragment$special$$inlined$activityViewModels$default$2(this));
        this.f = LazyKt.lazy(new g(this));
        this.g = LazyKt.lazy(new h(this));
    }

    public static void S90(DataPermissionBottomSheet r2, FragmentManager r3) {
        LandscapeRestrictionOperation r0 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r2, "DataPermissionBottomSheet", r0);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r3, r2, r0) == false) goto L9;
        return;
    L9:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
    L6:
        r2.show(r3, "DataPermissionBottomSheet");
    }

    public final void U90(ItemTextArrow r2, boolean r3) {
        if (r3 == false) goto L4;
        String r4 = (String) this.f.getValue();
    L5:
        int r0 = ItemTextArrow.k;
        r2.Z5(r4, null);
        return;
    L4:
        r4 = (String) this.g.getValue();
        goto L5
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [com.larus.setting.impl.modeltraining.b] */
    public final void onViewCreated(View r14, Bundle r15) {
        Intrinsics.checkNotNullParameter(r14, "view");
        super.onViewCreated(r14, r15);
        int r16 = lt9.a.a;
        Context r17 = getContext();
        IObricPrivacyModelTrainingService r18 = (IObricPrivacyModelTrainingService) ServiceManager.get().getService(IObricPrivacyModelTrainingService.class);
        if (r18 == null) goto L5;
        r18.a();
    L5:
        if (r17 == null) goto L7;
        String r19 = r17.getString(2131908502);
    L8:
        if (r19 == null) goto L11;
        String r110 = String.format(r19, Arrays.copyOf(new Object[]{lt9.a.a(r17)}, 1));
        if (r110 == null) goto L11;
    L12:
        LarusPagePrivacyModelTrainingSettingBinding r111 = this.e;
        if (r111 == null) goto L17;
        UrlSpanTextView r112 = r111.d;
        if (r112 == null) goto L17;
        r112.setUrlSpannedText(r110);
    L17:
        LarusPagePrivacyModelTrainingSettingBinding r113 = this.e;
        if (r113 == null) goto L22;
        UrlSpanTextView r114 = r113.d;
        if (r114 == null) goto L22;
        r114.setOnClickListener(new j(this));
    L22:
        LarusPagePrivacyModelTrainingSettingBinding r115 = this.e;
        if (r115 == null) goto L25;
        NovaTitleBarEx.b6(r115.c, 2131241477, false, null, null, new com.larus.setting.impl.modeltraining.a(this), 14);
    L25:
        SettingModel.updateUserConfigs$default(T90(), null, 0, null, 7, null);
        LarusPagePrivacyModelTrainingSettingBinding r116 = this.e;
        if (r116 == null) goto L31;
        U90(r116.e, T90().isAllowTrainByText());
        final String r1 = "conversation_train";
        e1.d(r116.e, new i(this, r1));
        U90(r116.f, T90().isAllowTrainByUpload());
        final String r2 = "multimedia_train";
        e1.d(r116.f, new i(this, r2));
        U90(r116.h, T90().isOptOutVoiceEnabled());
        final String r3 = "voice_train";
        e1.d(r116.h, new i(this, r3));
        if (AppHost.a.isOversea() == true) goto L30;
        U90(r116.g, T90().isAllowTrainByVideo());
        final String r0 = "video_train";
        e1.d(r116.g, new i(this, r0));
        goto L31
    L30:
        e1.o(r116.g);
    L31:
        final LarusPagePrivacyModelTrainingSettingBinding r117 = this.e;
        if (r117 == null) goto L36;
        T90().getAllowTrainByText().observe(getViewLifecycleOwner(), new b(new c(this, r117)));
        T90().getAllowTrainByUpload().observe(getViewLifecycleOwner(), new b(new d(this, r117)));
        T90().getOptOutVoice().observe(getViewLifecycleOwner(), new b(new e(this, r117)));
        if (AppHost.a.isOversea() == true) goto L36;
        T90().getAllowTrainByVideo().observe(getViewLifecycleOwner(), new b(new f(this, r117)));
    L36:
        LarusPagePrivacyModelTrainingSettingBinding r118 = this.e;
        if (r118 == null) goto L44;
        IObricPrivacyModelTrainingService r119 = (IObricPrivacyModelTrainingService) ServiceManager.get().getService(IObricPrivacyModelTrainingService.class);
        if (r119 == null) goto L42;
        r119.d(this, r118.b, new com.larus.setting.impl.modeltraining.b(this));
    L42:
        Unit r120 = Unit.INSTANCE;
        return;
    L44:
        return;
    L11:
        r110 = "";
        goto L12
    L7:
        r19 = null;
        goto L8
    }

    public final View onCreateView(LayoutInflater r10, ViewGroup r11, Bundle r12) {
        Intrinsics.checkNotNullParameter(r10, "inflater");
        View r13 = r10.inflate(2131563056, r11, false);
        int r14 = 2131367771;
        if (((LinearLayout) ViewBindings.findChildViewById(r13, 2131367771)) == null) goto L43;
        LinearLayout r15 = (LinearLayout) r13;
        if (((ImageView) ViewBindings.findChildViewById(r13, 2131380250)) != null) goto L7;
        r14 = 2131380250;
        goto L43
    L7:
        if (ViewBindings.findChildViewById(r13, 2131380251) == null) goto L40;
        ItemGroup r2 = ViewBindings.findChildViewById(r13, 2131381223);
        if (r2 != null) goto L11;
        r14 = 2131381223;
        goto L43
    L11:
        if (ViewBindings.findChildViewById(r13, 2131385238) == null) goto L38;
        NovaTitleBarEx r3 = ViewBindings.findChildViewById(r13, 2131388772);
        if (r3 != null) goto L15;
        r14 = 2131388772;
        goto L43
    L15:
        if (ViewBindings.findChildViewById(r13, 2131388843) == null) goto L36;
        UrlSpanTextView r4 = ViewBindings.findChildViewById(r13, 2131389318);
        if (r4 != null) goto L19;
        r14 = 2131389318;
        goto L43
    L19:
        if (((TextView) ViewBindings.findChildViewById(r13, 2131389319)) == null) goto L34;
        ItemTextArrow r5 = ViewBindings.findChildViewById(r13, 2131391758);
        if (r5 == null) goto L33;
        ItemTextArrow r6 = ViewBindings.findChildViewById(r13, 2131391759);
        if (r6 == null) goto L32;
        ItemTextArrow r7 = ViewBindings.findChildViewById(r13, 2131391760);
        if (r7 == null) goto L31;
        ItemTextArrow r8 = ViewBindings.findChildViewById(r13, 2131391761);
        if (r8 == null) goto L30;
        this.e = new LarusPagePrivacyModelTrainingSettingBinding(r15, r2, r3, r4, r5, r6, r7, r8);
        return r15;
    L30:
        r14 = 2131391761;
        goto L43
    L31:
        r14 = 2131391760;
        goto L43
    L32:
        r14 = 2131391759;
        goto L43
    L33:
        r14 = 2131391758;
        goto L43
    L34:
        r14 = 2131389319;
        goto L43
    L36:
        r14 = 2131388843;
        goto L43
    L38:
        r14 = 2131385238;
        goto L43
    L40:
        r14 = 2131380251;
    L43:
        throw new NullPointerException("Missing required view with ID: ".concat(r13.getResources().getResourceName(r14)));
    }
}
