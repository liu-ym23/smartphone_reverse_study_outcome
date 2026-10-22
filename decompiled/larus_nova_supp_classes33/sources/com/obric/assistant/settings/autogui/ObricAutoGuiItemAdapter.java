package com.obric.assistant.settings.autogui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.impl.databinding.ItemObricAutoAppTypeAvailableBinding;
import com.obric.assistant.impl.databinding.ItemObricAutoAppTypeGuiSwitchBinding;
import com.obric.assistant.impl.databinding.ItemObricAutoAppTypeInavailableBinding;
import com.obric.assistant.impl.databinding.ItemObricAutoAppTypeLoadingBinding;
import com.obric.assistant.impl.databinding.ItemObricAutoAppTypeTitleBinding;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.obric.assistant.settings.IObricAutoGuiSettingsApi;
import com.obric.assistant.t1;
import com.obric.oui.badge.OBadgeView;
import com.obric.oui.constraintlayout.widget.ConstraintLayout;
import com.obric.oui.dialog.v2.alert.style.ButtonStyleController;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.oswitch.OSwitch;
import com.obric.oui.sectiontitlebar.OSectionSupportiveText;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 \u001a2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\b\u001a\u001b\u001c\u001d\u001e\u001f !B#\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\u0018\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0012H\u0016J\u0018\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0012H\u0016R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/obric/assistant/settings/autogui/ObricAutoGuiItemAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/obric/assistant/settings/autogui/ObricAutoGuiItemUIModel;", "Lcom/obric/assistant/settings/autogui/ObricAutoGuiItemAdapter$ObricAutoGuiItemViewHolder;", "activity", "Landroidx/fragment/app/FragmentActivity;", "onSwitchChanged", "Lkotlin/Function0;", "", "<init>", "(Landroidx/fragment/app/FragmentActivity;Lkotlin/jvm/functions/Function0;)V", "getActivity", "()Landroidx/fragment/app/FragmentActivity;", "getOnSwitchChanged", "()Lkotlin/jvm/functions/Function0;", "isObricOS", "", "getItemViewType", "", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "Companion", "ObricAutoGuiItemViewHolder", "ObricAutoGuiItemEmptyViewHolder", "ObricAutoGuiItemGuiSwitchViewHolder", "ObricAutoGuiItemTitleViewHolder", "ObricAutoGuiItemAvailableViewHolder", "ObricAutoGuiItemInAvailableViewHolder", "ObricAutoGuiItemLoadingHintViewHolder", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricAutoGuiItemAdapter extends ListAdapter<b0, ObricAutoGuiItemViewHolder> {
    public static final ObricAutoGuiItemAdapter$Companion$DIFF_CALLBACK$1 d = null;
    public final FragmentActivity a;
    public final Function0<Unit> b;
    public final boolean c;

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B#\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u0012\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u0018\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0018\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0010\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u001aH\u0002R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u001b"}, d2 = {"Lcom/obric/assistant/settings/autogui/ObricAutoGuiItemAdapter$ObricAutoGuiItemAvailableViewHolder;", "Lcom/obric/assistant/settings/autogui/ObricAutoGuiItemAdapter$ObricAutoGuiItemViewHolder;", "activity", "Landroidx/fragment/app/FragmentActivity;", "isObricOS", "", "binding", "Lcom/obric/assistant/impl/databinding/ItemObricAutoAppTypeAvailableBinding;", "<init>", "(Landroidx/fragment/app/FragmentActivity;ZLcom/obric/assistant/impl/databinding/ItemObricAutoAppTypeAvailableBinding;)V", "getActivity", "()Landroidx/fragment/app/FragmentActivity;", "getBinding", "()Lcom/obric/assistant/impl/databinding/ItemObricAutoAppTypeAvailableBinding;", "bindData", "", "obricAutoAppItemUIModel", "Lcom/obric/assistant/settings/autogui/ObricAutoGuiItemUIModel;", "bindSwitchStyle", "item", "Lcom/obric/oui/lisitem/OCardListItem;", "packageName", "", "bindGoSettingStyle", "openScreenAutomationAppDetail", "context", "Landroid/content/Context;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ObricAutoGuiItemAvailableViewHolder extends ObricAutoGuiItemViewHolder {
        public static final /* synthetic */ int d = 0;
        public final FragmentActivity a;
        public final boolean b;
        public final ItemObricAutoAppTypeAvailableBinding c;

        public final FragmentActivity getActivity() {
            return this.a;
        }

        @Override // com.obric.assistant.settings.autogui.ObricAutoGuiItemAdapter.ObricAutoGuiItemViewHolder
        public final void U3(b0 r9) {
            ItemObricAutoAppTypeAvailableBinding r0 = this.c;
            if (r0 == null) goto L31;
            OCardListItem.h(r0.b, ObricAutoGuiItemViewHolder.V3(r9));
            com.obric.assistant.settings.b r1 = null;
            if (r9 == null) goto L26;
            com.obric.assistant.settings.b r2 = r9.e;
            if (r2 == null) goto L26;
            r0.b.setTitle(r2.b);
            OCardListItem r3 = r0.b;
            ObricAutoGuiItemAdapter$Companion$DIFF_CALLBACK$1 r4 = ObricAutoGuiItemAdapter.d;
            r3.setAppIcon(a.a(r2.a));
            boolean r5 = false;
            if (r9.m == false) goto L14;
            final OCardListItem r6 = r0.b;
            OSwitch r7 = r6.getEndSwitch();
            if (r7 == null) goto L13;
            r7.setOnCheckedChangeListener(null);
        L13:
            r6.setDefaultCustomEndView(3);
            r6.k(r6.getContext().getString(2131912176), -1);
            r6.m(true);
            r6.setDefaultTailIcon(0);
            r6.r(true);
            r6.setOnContentClickListener(new o(this, r6));
        L25:
            a.b(r0.b);
            goto L26
        L14:
            OCardListItem r8 = r0.b;
            final String r10 = r2.a;
            r8.setDefaultCustomEndView(1);
            r8.m(true);
            r8.r(false);
            r8.setOnContentClickListener(null);
            OSwitch r11 = r8.getEndSwitch();
            if (r11 == null) goto L17;
            r11.setOnCheckedChangeListener(new n(r10));
        L17:
            OSwitch r12 = r8.getEndSwitch();
            if (r12 == null) goto L25;
            IObricAutoGuiSettingsApi r13 = (IObricAutoGuiSettingsApi) ServiceManager.get().getService(IObricAutoGuiSettingsApi.class);
            if (r13 != null) goto L22;
        L24:
            r12.setChecked(!r5);
            goto L25
        L22:
            if (r13.e(r10, false) == true) goto L24;
            r5 = true;
        L26:
            ObricAutoGuiItemViewHolder.T3(r0.b, this.b);
            FLogger r14 = FLogger.a;
            StringBuilder r15 = new StringBuilder("createSelectItemByAppInfo, ");
            if (r9 == null) goto L29;
            r1 = r9.e;
        L29:
            r15.append(r1);
            r14.i("ObricAutoGuiSettingsFragment", r15.toString());
            return;
        }

        public ObricAutoGuiItemAvailableViewHolder(FragmentActivity r2, boolean r3, ItemObricAutoAppTypeAvailableBinding r4) {
            View r0 = r4.a;
            if (r0 != null) goto L6;
            r0 = new View(r2);
        L6:
            super(r0);
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016¨\u0006\n"}, d2 = {"Lcom/obric/assistant/settings/autogui/ObricAutoGuiItemAdapter$ObricAutoGuiItemEmptyViewHolder;", "Lcom/obric/assistant/settings/autogui/ObricAutoGuiItemAdapter$ObricAutoGuiItemViewHolder;", "parent", "Landroid/view/ViewGroup;", "<init>", "(Landroid/view/ViewGroup;)V", "bindData", "", "obricAutoAppItemUIModel", "Lcom/obric/assistant/settings/autogui/ObricAutoGuiItemUIModel;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ObricAutoGuiItemEmptyViewHolder extends ObricAutoGuiItemViewHolder {
        @Override // com.obric.assistant.settings.autogui.ObricAutoGuiItemAdapter.ObricAutoGuiItemViewHolder
        public final void U3(b0 r1) {
        }

        public ObricAutoGuiItemEmptyViewHolder(ViewGroup r2) {
            Intrinsics.checkNotNullParameter(r2, "parent");
            super(r2);
        }
    }

    @Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B3\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t¢\u0006\u0004\b\u000b\u0010\fJ\u0012\u0010\u0014\u001a\u00020\n2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u0019\u0010\u0017\u001a\u0004\u0018\u00010\n2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0002¢\u0006\u0002\u0010\u0018J\u001a\u0010\u0019\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0016H\u0002J\u0019\u0010\u001d\u001a\u0004\u0018\u00010\n2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0002¢\u0006\u0002\u0010\u0018J\u0010\u0010\u001e\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020 H\u0002J\u0019\u0010!\u001a\u0004\u0018\u00010\n2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0002¢\u0006\u0002\u0010\u0018J\u0019\u0010\"\u001a\u0004\u0018\u00010\n2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0002¢\u0006\u0002\u0010\u0018J\u0018\u0010#\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0016H\u0002J\u0019\u0010$\u001a\u0004\u0018\u00010\n2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0002¢\u0006\u0002\u0010\u0018J\u0019\u0010%\u001a\u0004\u0018\u00010\n2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0002¢\u0006\u0002\u0010\u0018J\u001a\u0010&\u001a\u00020\n2\b\u0010'\u001a\u0004\u0018\u00010(2\u0006\u0010)\u001a\u00020\u0005H\u0002J3\u0010*\u001a\u00020\n2\u0006\u0010)\u001a\u00020\u00052!\u0010+\u001a\u001d\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(/\u0012\u0004\u0012\u00020\n0,H\u0002J\u0010\u00100\u001a\u0002012\u0006\u00102\u001a\u00020\u0003H\u0002R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0019\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00063"}, d2 = {"Lcom/obric/assistant/settings/autogui/ObricAutoGuiItemAdapter$ObricAutoGuiItemGuiSwitchViewHolder;", "Lcom/obric/assistant/settings/autogui/ObricAutoGuiItemAdapter$ObricAutoGuiItemViewHolder;", "activity", "Landroidx/fragment/app/FragmentActivity;", "isObricOS", "", "binding", "Lcom/obric/assistant/impl/databinding/ItemObricAutoAppTypeGuiSwitchBinding;", "onSwitchChanged", "Lkotlin/Function0;", "", "<init>", "(Landroidx/fragment/app/FragmentActivity;ZLcom/obric/assistant/impl/databinding/ItemObricAutoAppTypeGuiSwitchBinding;Lkotlin/jvm/functions/Function0;)V", "getActivity", "()Landroidx/fragment/app/FragmentActivity;", "getBinding", "()Lcom/obric/assistant/impl/databinding/ItemObricAutoAppTypeGuiSwitchBinding;", "getOnSwitchChanged", "()Lkotlin/jvm/functions/Function0;", "needIgnoreChanged", "bindData", "obricAutoAppItemUIModel", "Lcom/obric/assistant/settings/autogui/ObricAutoGuiItemUIModel;", "setupAutoGuiSwitch", "(Lcom/obric/assistant/settings/autogui/ObricAutoGuiItemUIModel;)Lkotlin/Unit;", "setupBetaTitle", "item", "Lcom/obric/oui/lisitem/OCardListItem;", "model", "setupSkillExtensionEntry", "openSkillExtensionSettings", "anchor", "Landroid/view/View;", "setupOUseClipboard", "setupFastModeUseEntry", "showFastModeUsePopover", "setupAutoExecuteAuthEntry", "setupRiskPreferenceEntry", "setSwitchCheckedSilently", "switch", "Landroid/widget/CompoundButton;", "checked", "showAutoGuiConfirmDialog", "callback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "isUserConfirm", "buildSwitchOnMessageWithPrivacyLink", "", "context", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ObricAutoGuiItemGuiSwitchViewHolder extends ObricAutoGuiItemViewHolder {
        public static final /* synthetic */ int f = 0;
        public final FragmentActivity a;
        public final boolean b;
        public final ItemObricAutoAppTypeGuiSwitchBinding c;
        public final Function0<Unit> d;
        public boolean e;

        public final FragmentActivity getActivity() {
            return this.a;
        }

        @Override // com.obric.assistant.settings.autogui.ObricAutoGuiItemAdapter.ObricAutoGuiItemViewHolder
        public final void U3(final b0 r9) {
            ItemObricAutoAppTypeGuiSwitchBinding r0 = this.c;
            ViewGroup.MarginLayoutParams r1 = null;
            if (r0 == null) goto L54;
            OCardListItem r2 = r0.c;
            boolean r3 = true;
            if (r9 != null) goto L7;
        L9:
            boolean r5 = false;
        L10:
            if (r5 == true) goto L16;
            if (r9 == null) goto L14;
            String r6 = r9.c;
            if (r6 == null) goto L14;
        L15:
            r2.setTitle(r6);
            r2.s(true);
        L40:
            final OSwitch r4 = r0.c.getEndSwitch();
            if (r4 == null) goto L43;
            r4.setClickable(true);
        L43:
            if (r9 != null) goto L45;
        L47:
            r3 = false;
        L48:
            if (r4 == null) goto L50;
            r4.setOnCheckedChangeListener(null);
        L50:
            if (r4 == null) goto L52;
            r4.setChecked(r3);
        L52:
            if (r4 == null) goto L54;
            r4.setOnCheckedChangeListener(new t(this, r4, r9));
            Unit r7 = Unit.INSTANCE;
            goto L54
        L45:
            if (r9.f != true) goto L47;
        L14:
            r6 = "";
            goto L15
        L16:
            View r8 = r2.c();
            if ((r8 instanceof ViewGroup) == false) goto L19;
            ViewGroup r10 = (ViewGroup) r8;
        L20:
            if (r10 != null) goto L25;
            r2.i(2131561649, false);
            View r11 = r2.c();
            if ((r11 instanceof ViewGroup) == false) goto L24;
            r10 = (ViewGroup) r11;
            goto L25
        L24:
            r10 = null;
        L25:
            if (r10 == null) goto L39;
            r10.findViewById(2131368477).setText(r9.c);
            TextView r12 = (TextView) r10.findViewById(2131368475);
            if (r12 == null) goto L29;
            r12.setVisibility(8);
        L29:
            ImageView r13 = (ImageView) r10.findViewById(2131368478);
            if (r13 == null) goto L32;
            r13.setVisibility(8);
        L32:
            ImageView r14 = (ImageView) r10.findViewById(2131368471);
            if (r14 == null) goto L35;
            r14.setVisibility(0);
        L35:
            OBadgeView r15 = r10.findViewById(2131368476);
            if (r15 == null) goto L38;
            r15.setVisibility(8);
        L38:
            r2.s(false);
            goto L40
        L39:
            r2.setTitle(r9.c);
            r2.s(true);
            goto L40
        L19:
            r10 = null;
            goto L20
        L7:
            if (r9.d != true) goto L9;
            r5 = true;
        L54:
            a4(r9);
            Y3(r9);
            X3(r9);
            W3(r9);
            Z3(r9);
            ItemObricAutoAppTypeGuiSwitchBinding r16 = this.c;
            if (r16 != null) goto L57;
            return;
        L57:
            if (this.b == true) goto L63;
            ViewGroup.LayoutParams r17 = r16.c.getLayoutParams();
            if ((r17 instanceof ViewGroup.MarginLayoutParams) == false) goto L61;
            r1 = (ViewGroup.MarginLayoutParams) r17;
        L61:
            if (r1 == null) goto L63;
            r1.topMargin = i5.A();
            r16.c.setLayoutParams(r1);
        L63:
            ObricAutoGuiItemViewHolder.T3(r16.c, this.b);
            ObricAutoGuiItemViewHolder.T3(r16.g, this.b);
            ObricAutoGuiItemViewHolder.T3(r16.e, this.b);
            ObricAutoGuiItemViewHolder.T3(r16.d, this.b);
            ObricAutoGuiItemViewHolder.T3(r16.b, this.b);
            ObricAutoGuiItemViewHolder.T3(r16.f, this.b);
        }

        public final void W3(b0 r6) {
            final ItemObricAutoAppTypeGuiSwitchBinding r0 = this.c;
            if (r0 != null) goto L5;
            return;
        L5:
            if (r6 != null) goto L7;
        L9:
            boolean r3 = false;
        L10:
            if (r3 == true) goto L12;
        L14:
            boolean r7 = false;
        L15:
            if (r7 == true) goto L17;
            r0.b.setVisibility(8);
            r0.b.setOnContentClickListener(null);
        L18:
            Unit r8 = Unit.INSTANCE;
            return;
        L17:
            r0.b.setVisibility(0);
            OCardListItem r9 = r0.b;
            r9.setTitle(r9.getContext().getString(2131912438));
            r0.b.s(true);
            r0.b.setSubTitle("");
            r0.b.q(false);
            r0.b.m(false);
            r0.b.setDefaultTailIcon(0);
            r0.b.r(true);
            r0.b.setOnContentClickListener(new p(r0));
            goto L18
        L12:
            if (r6.g == false) goto L14;
            r7 = true;
            goto L15
        L7:
            if (r6.f != true) goto L9;
            r3 = true;
            goto L10
        }

        public final void X3(final b0 r7) {
            final ItemObricAutoAppTypeGuiSwitchBinding r0 = this.c;
            if (r0 == null) goto L18;
            boolean r1 = false;
            if (r7 != null) goto L7;
        L9:
            boolean r3 = false;
        L10:
            if (r3 == true) goto L12;
            r0.d.setVisibility(8);
            r0.d.setOnContentClickListener(null);
        L16:
            Unit r8 = Unit.INSTANCE;
            return;
        L12:
            r0.d.setVisibility(0);
            OCardListItem r4 = r0.d;
            r4.setTitle(r4.getContext().getString(2131912447));
            r0.d.s(true);
            r0.d.setSubTitle("");
            r0.d.q(false);
            r0.d.setDefaultCustomEndView(4);
            String r5 = m0.a(t1.a.getAutoGuiFastModeUseSettings());
            r0.d.k(r5, -1);
            OCardListItem r6 = r0.d;
            if (r5.length() <= 0) goto L15;
            r1 = true;
        L15:
            r6.m(r1);
            r0.d.setDefaultTailIcon(1);
            r0.d.r(true);
            r0.d.setOnContentClickListener(new s(this, r0, r7));
            goto L16
        L7:
            if (r7.f != true) goto L9;
            r3 = true;
            goto L10
        }

        public final void Y3(b0 r5) {
            ItemObricAutoAppTypeGuiSwitchBinding r0 = this.c;
            if (r0 != null) goto L5;
            return;
        L5:
            if (r5 == null) goto L9;
            boolean r3 = true;
            if (r5.f != true) goto L9;
        L10:
            if (r3 == true) goto L12;
            r0.e.setVisibility(8);
        L21:
            Unit r6 = Unit.INSTANCE;
            return;
        L12:
            r0.e.setVisibility(0);
            OSwitch r1 = r0.e.getEndSwitch();
            if (r5 == null) goto L19;
            boolean r7 = r5.j;
            if (r1 == null) goto L17;
            r1.setOnCheckedChangeListener(null);
        L17:
            if (r1 == null) goto L19;
            r1.setChecked(r7);
        L19:
            if (r1 == null) goto L21;
            r1.setOnCheckedChangeListener(new r());
        L9:
            r3 = false;
            goto L10
        }

        public final void Z3(b0 r7) {
            final ItemObricAutoAppTypeGuiSwitchBinding r0 = this.c;
            if (r0 != null) goto L5;
            return;
        L5:
            if (r7 != null) goto L7;
        L9:
            boolean r3 = false;
        L10:
            if (r3 == true) goto L12;
            r0.f.setVisibility(8);
            r0.f.setOnContentClickListener(null);
        L22:
            Unit r8 = Unit.INSTANCE;
            return;
        L12:
            r0.f.setVisibility(0);
            OCardListItem r4 = r0.f;
            r4.setTitle(r4.getContext().getString(2131912455));
            r0.f.s(true);
            r0.f.setSubTitle("");
            r0.f.q(false);
            r0.f.setDefaultCustomEndView(3);
            if (r7 == null) goto L15;
            r0.f.k(r7.h, -1);
        L15:
            if (r7 == null) goto L21;
            OCardListItem r5 = r0.f;
            if (r7.h.length() <= 0) goto L19;
            boolean r9 = true;
        L20:
            r5.m(r9);
            goto L21
        L19:
            r9 = false;
        L21:
            r0.f.setDefaultTailIcon(0);
            r0.f.r(true);
            r0.f.setOnContentClickListener(new u(r0));
            goto L22
        L7:
            if (r7.f != true) goto L9;
            r3 = true;
            goto L10
        }

        public final void a4(b0 r6) {
            final ItemObricAutoAppTypeGuiSwitchBinding r0 = this.c;
            if (r0 != null) goto L5;
            return;
        L5:
            if (r6 != null) goto L7;
        L9:
            boolean r3 = false;
        L10:
            if (r6 != null) goto L12;
        L14:
            boolean r4 = false;
        L15:
            if (r3 == false) goto L28;
            if (r4 == false) goto L28;
            r0.g.setVisibility(0);
            r0.g.setDefaultCustomEndView(3);
            OCardListItem r5 = r0.g;
            Context r7 = r5.getContext();
            if (r6 != null) goto L21;
        L23:
            boolean r8 = false;
        L24:
            if (r8 == false) goto L26;
            int r9 = 2131912465;
        L27:
            r5.k(r7.getString(r9), -1);
            r0.g.m(true);
            r0.g.setDefaultTailIcon(0);
            r0.g.r(true);
            r0.g.setOnContentClickListener(new v(this, r0));
        L29:
            Unit r10 = Unit.INSTANCE;
            return;
        L26:
            r9 = 2131912464;
            goto L27
        L21:
            if (r6.l != true) goto L23;
            r8 = true;
        L28:
            r0.g.setVisibility(8);
            r0.g.setOnContentClickListener(null);
            goto L29
        L12:
            if (r6.k != true) goto L14;
            r4 = true;
            goto L15
        L7:
            if (r6.f != true) goto L9;
            r3 = true;
            goto L10
        }

        public final void b4(boolean r23, final Function1<? super Boolean, Unit> r24) {
            FragmentActivity r2 = this.a;
            if (r2 == null) goto L41;
            if (r23 == false) goto L6;
            String r3 = AppHost.a.getApplication().getString(2131912446);
        L7:
            Intrinsics.checkNotNull(r3);
            if (r23 == false) goto L13;
            String r4 = AppHost.a.getApplication().getString(2131912445);
            SpannableStringBuilder r5 = new SpannableStringBuilder(StringsKt.replace$default(StringsKt.replace$default(r4, "{", "", false, 4, null), "}", "", false, 4, null));
            int r14 = StringsKt.indexOf$default(r4, '{', 0, false, 6, null);
            int r6 = StringsKt.indexOf$default(r4, '}', 0, false, 6, null) - 1;
            CharSequence r7 = r5;
            r7 = r5;
            if (r14 == (-1)) goto L14;
            if (r6 <= r14) goto L14;
            r5.setSpan(new a0(r2), r14, r6, 33);
            r7 = r5;
        L14:
            if (r23 == false) goto L16;
            String r8 = AppHost.a.getApplication().getString(2131912444);
        L17:
            Intrinsics.checkNotNull(r8);
            if (r23 == false) goto L20;
            String r9 = AppHost.a.getApplication().getString(2131912443);
        L21:
            Intrinsics.checkNotNull(r9);
            com.obric.oui.dialog.v2.alert.g r10 = new com.obric.oui.dialog.v2.alert.g(r2);
            r10.w = false;
            r10.j = false;
            r10.h = r3;
            r10.i = r7;
            com.obric.oui.dialog.v2.alert.g.c(r10);
            DialogInterface.OnClickListener r11 = new z(r24);
            if (r23 == true) goto L24;
            ButtonStyleController.TextColorType r12 = ButtonStyleController.TextColorType.Negative;
        L25:
            r10.d(r9, r11, r12);
            r10.h(r8, new q(r24));
            com.obric.oui.dialog.v2.alert.c r1 = r10.a();
            if (r23 == false) goto L33;
            if (Build.VERSION.SDK_INT < 30) goto L33;
            TextView r13 = r1.K;
            if (r13 == null) goto L33;
            r13.setMovementMethod(LinkMovementMethod.getInstance());
        L33:
            if (DialogLancet.shouldBlockDialogShow(r1) == false) goto L39;
            DialogLancet.handleBlockedDialogShow(r1);
            return;
        L39:
            DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L38
        L36:
            DialogLancet.beforeDialogShow(r1);
            r1.show();
            DialogLancet.afterDialogShow(r1);
            return;
        L24:
            r12 = null;
            goto L25
        L20:
            r9 = AppHost.a.getApplication().getString(2131912439);
            goto L21
        L16:
            r8 = AppHost.a.getApplication().getString(2131912440);
            goto L17
        L13:
            String r15 = AppHost.a.getApplication().getString(2131912441);
            Intrinsics.checkNotNull(r15);
            r7 = r15;
            goto L14
        L6:
            r3 = AppHost.a.getApplication().getString(2131912442);
            goto L7
        }

        public ObricAutoGuiItemGuiSwitchViewHolder(FragmentActivity r2, boolean r3, ItemObricAutoAppTypeGuiSwitchBinding r4, Function0<Unit> r5) {
            View r0 = r4.a;
            if (r0 != null) goto L6;
            r0 = new View(r2);
        L6:
            super(r0);
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B#\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u0012\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u001f\u0010\u0012\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0014H\u0002¢\u0006\u0002\u0010\u0015R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0016"}, d2 = {"Lcom/obric/assistant/settings/autogui/ObricAutoGuiItemAdapter$ObricAutoGuiItemInAvailableViewHolder;", "Lcom/obric/assistant/settings/autogui/ObricAutoGuiItemAdapter$ObricAutoGuiItemViewHolder;", "activity", "Landroidx/fragment/app/FragmentActivity;", "isObricOS", "", "binding", "Lcom/obric/assistant/impl/databinding/ItemObricAutoAppTypeInavailableBinding;", "<init>", "(Landroidx/fragment/app/FragmentActivity;ZLcom/obric/assistant/impl/databinding/ItemObricAutoAppTypeInavailableBinding;)V", "getActivity", "()Landroidx/fragment/app/FragmentActivity;", "getBinding", "()Lcom/obric/assistant/impl/databinding/ItemObricAutoAppTypeInavailableBinding;", "bindData", "", "obricAutoAppItemUIModel", "Lcom/obric/assistant/settings/autogui/ObricAutoGuiItemUIModel;", "bindCommonInAvailableItem", "appInfo", "Lcom/obric/assistant/settings/AppInfo;", "(Lcom/obric/assistant/settings/autogui/ObricAutoGuiItemUIModel;Lcom/obric/assistant/settings/AppInfo;)Lkotlin/Unit;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ObricAutoGuiItemInAvailableViewHolder extends ObricAutoGuiItemViewHolder {
        public final FragmentActivity a;
        public final boolean b;
        public final ItemObricAutoAppTypeInavailableBinding c;

        public final FragmentActivity getActivity() {
            return this.a;
        }

        @Override // com.obric.assistant.settings.autogui.ObricAutoGuiItemAdapter.ObricAutoGuiItemViewHolder
        public final void U3(b0 r5) {
            if (r5 == null) goto L41;
            com.obric.assistant.settings.b r0 = r5.e;
            if (r0 == null) goto L42;
            Lazy r1 = o0.a;
            if (Build.VERSION.SDK_INT < 37) goto L8;
            boolean r2 = true;
        L9:
            if (r2 == false) goto L20;
            W3(r5, r0);
            ItemObricAutoAppTypeInavailableBinding r6 = this.c;
            if (r6 == null) goto L15;
            OCardListItem r7 = r6.b;
            if (r7 == null) goto L15;
            r7.setSubTitle(r7.getContext().getString(2131912433));
            r7.q(true);
        L15:
            ItemObricAutoAppTypeInavailableBinding r8 = this.c;
            if (r8 == null) goto L43;
            OCardListItem r9 = r8.b;
            if (r9 == null) goto L44;
            ObricAutoGuiItemViewHolder.T3(r9, this.b);
            return;
        L44:
            return;
        L43:
            return;
        L20:
            int r3 = r0.g;
            if (r3 == 0) goto L29;
            if (r3 != 1) goto L24;
            ItemObricAutoAppTypeInavailableBinding r4 = this.c;
            if (r4 == null) goto L35;
            W3(r5, r0);
            OCardListItem r10 = r4.b;
            t1 r11 = t1.a;
            r10.setSubTitle(r11.getObricAutoGuiBlacklistConfig().getObricAutoGuiAppBlockedByObricHint());
            r4.b.q(Intrinsics.areEqual(r11.getObricAutoGuiBlacklistConfig().getObricAutoGuiAppBlockedByObricHintEnable(), Boolean.TRUE));
            FLogger.a.i("ObricAutoGuiSettingsFragment", "createSelectItemByAppInfo, " + r5.e);
        L35:
            ItemObricAutoAppTypeInavailableBinding r12 = this.c;
            if (r12 == null) goto L46;
            OCardListItem r13 = r12.b;
            if (r13 == null) goto L47;
            ObricAutoGuiItemViewHolder.T3(r13, this.b);
            return;
        L47:
            return;
        L46:
            return;
        L24:
            if (r3 != 2) goto L35;
        L29:
            ItemObricAutoAppTypeInavailableBinding r14 = this.c;
            if (r14 == null) goto L35;
            W3(r5, r0);
            OCardListItem r15 = r14.b;
            t1 r16 = t1.a;
            String r17 = r16.getObricAutoGuiBlacklistConfig().getObricAutoGuiAppBlockedByThirdPartyHint();
            if (r17 != null) goto L34;
            r17 = AppHost.a.getApplication().getString(2131912432);
        L34:
            r15.setSubTitle(r17);
            r14.b.q(Intrinsics.areEqual(r16.getObricAutoGuiBlacklistConfig().getObricAutoGuiAppBlockedByThirdPartyHintEnable(), Boolean.TRUE));
            goto L35
        L8:
            r2 = false;
            goto L9
        L42:
            return;
        }

        public final void W3(b0 r3, com.obric.assistant.settings.b r4) {
            ItemObricAutoAppTypeInavailableBinding r0 = this.c;
            if (r0 == null) goto L6;
            OCardListItem.h(r0.b, ObricAutoGuiItemViewHolder.V3(r3));
            r0.b.setTitle(r4.b);
            r0.b.s(true);
            OCardListItem r5 = r0.b;
            ObricAutoGuiItemAdapter$Companion$DIFF_CALLBACK$1 r1 = ObricAutoGuiItemAdapter.d;
            r5.setAppIcon(a.a(r4.a));
            r0.b.r(false);
            a.b(r0.b);
            Unit r6 = Unit.INSTANCE;
            return;
        }

        public ObricAutoGuiItemInAvailableViewHolder(FragmentActivity r2, boolean r3, ItemObricAutoAppTypeInavailableBinding r4) {
            View r0 = r4.a;
            if (r0 != null) goto L6;
            r0 = new View(r2);
        L6:
            super(r0);
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B#\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u0012\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0012"}, d2 = {"Lcom/obric/assistant/settings/autogui/ObricAutoGuiItemAdapter$ObricAutoGuiItemLoadingHintViewHolder;", "Lcom/obric/assistant/settings/autogui/ObricAutoGuiItemAdapter$ObricAutoGuiItemViewHolder;", "activity", "Landroidx/fragment/app/FragmentActivity;", "isObricOS", "", "binding", "Lcom/obric/assistant/impl/databinding/ItemObricAutoAppTypeLoadingBinding;", "<init>", "(Landroidx/fragment/app/FragmentActivity;ZLcom/obric/assistant/impl/databinding/ItemObricAutoAppTypeLoadingBinding;)V", "getActivity", "()Landroidx/fragment/app/FragmentActivity;", "getBinding", "()Lcom/obric/assistant/impl/databinding/ItemObricAutoAppTypeLoadingBinding;", "bindData", "", "obricAutoAppItemUIModel", "Lcom/obric/assistant/settings/autogui/ObricAutoGuiItemUIModel;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ObricAutoGuiItemLoadingHintViewHolder extends ObricAutoGuiItemViewHolder {
        public final FragmentActivity a;

        @Override // com.obric.assistant.settings.autogui.ObricAutoGuiItemAdapter.ObricAutoGuiItemViewHolder
        public final void U3(b0 r1) {
        }

        public final FragmentActivity getActivity() {
            return this.a;
        }

        public ObricAutoGuiItemLoadingHintViewHolder(FragmentActivity r1, ItemObricAutoAppTypeLoadingBinding r2) {
            View r3 = r2.a;
            if (r3 != null) goto L6;
            r3 = new View(r1);
        L6:
            super(r3);
            this.a = r1;
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B#\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u0012\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0012"}, d2 = {"Lcom/obric/assistant/settings/autogui/ObricAutoGuiItemAdapter$ObricAutoGuiItemTitleViewHolder;", "Lcom/obric/assistant/settings/autogui/ObricAutoGuiItemAdapter$ObricAutoGuiItemViewHolder;", "activity", "Landroidx/fragment/app/FragmentActivity;", "isObricOS", "", "binding", "Lcom/obric/assistant/impl/databinding/ItemObricAutoAppTypeTitleBinding;", "<init>", "(Landroidx/fragment/app/FragmentActivity;ZLcom/obric/assistant/impl/databinding/ItemObricAutoAppTypeTitleBinding;)V", "getActivity", "()Landroidx/fragment/app/FragmentActivity;", "getBinding", "()Lcom/obric/assistant/impl/databinding/ItemObricAutoAppTypeTitleBinding;", "bindData", "", "obricAutoAppItemUIModel", "Lcom/obric/assistant/settings/autogui/ObricAutoGuiItemUIModel;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ObricAutoGuiItemTitleViewHolder extends ObricAutoGuiItemViewHolder {
        public final FragmentActivity a;
        public final ItemObricAutoAppTypeTitleBinding b;

        public final FragmentActivity getActivity() {
            return this.a;
        }

        @Override // com.obric.assistant.settings.autogui.ObricAutoGuiItemAdapter.ObricAutoGuiItemViewHolder
        public final void U3(b0 r2) {
            ItemObricAutoAppTypeTitleBinding r0 = this.b;
            if (r0 == null) goto L12;
            OSectionSupportiveText r1 = r0.b;
            if (r1 == null) goto L13;
            if (r2 == null) goto L9;
            String r3 = r2.c;
            if (r3 == null) goto L9;
        L10:
            r1.setSectionDes(r3);
            return;
        L9:
            r3 = "";
            goto L10
        L13:
            return;
        }

        public ObricAutoGuiItemTitleViewHolder(FragmentActivity r2, ItemObricAutoAppTypeTitleBinding r3) {
            View r0 = r3.a;
            if (r0 != null) goto L6;
            r0 = new View(r2);
        L6:
            super(r0);
            this.a = r2;
            this.b = r3;
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b&\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH&J\u0010\u0010\n\u001a\u00020\u000b2\b\u0010\b\u001a\u0004\u0018\u00010\tJ\u0016\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010¨\u0006\u0011"}, d2 = {"Lcom/obric/assistant/settings/autogui/ObricAutoGuiItemAdapter$ObricAutoGuiItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "bindData", "", "obricAutoAppItemUIModel", "Lcom/obric/assistant/settings/autogui/ObricAutoGuiItemUIModel;", "getItemPosition", "", "applyCardStyle", "item", "Lcom/obric/oui/lisitem/OCardListItem;", "isObricOS", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static abstract class ObricAutoGuiItemViewHolder extends RecyclerView.ViewHolder {

        public /* synthetic */ class a {
            public static final /* synthetic */ int[] a = null;

            static {
                int[] r0 = new int[ObricAutoGuiItemBgType.values().length];
                r0[ObricAutoGuiItemBgType.NORMAL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
            L13:
                r0[ObricAutoGuiItemBgType.TOP_CORNERS.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
            L19:
                r0[ObricAutoGuiItemBgType.BOTTOM_CORNERS.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
            L15:
                r0[ObricAutoGuiItemBgType.CORNERS.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
            L7:
                a = r0;
            }
        }

        public abstract void U3(b0 r1);

        public ObricAutoGuiItemViewHolder(View r2) {
            Intrinsics.checkNotNullParameter(r2, "itemView");
            super(r2);
        }

        public static int V3(b0 r2) {
            if (r2 == null) goto L4;
            ObricAutoGuiItemBgType r3 = r2.b;
        L5:
            if (r3 != null) goto L7;
            int r4 = -1;
        L9:
            if (r4 == 1) goto L17;
            if (r4 != 2) goto L12;
            return 1;
        L12:
            if (r4 == 3) goto L15;
            return 0;
        L15:
            return 3;
        L17:
            return 2;
        L7:
            r4 = a.a[r3.ordinal()];
            goto L9
        L4:
            r3 = null;
            goto L5
        }

        public static void T3(OCardListItem r1, boolean r2) {
            Intrinsics.checkNotNullParameter(r1, "item");
            if (r2 == false) goto L5;
            return;
        L5:
            int r3 = rda.a.a;
            rda.a.a(r1, r1.getCardPosition());
        }
    }

    public static final class a {
        public a() {
        }

        public static final Drawable a(String r5) {
            ObricAutoGuiItemAdapter$Companion$DIFF_CALLBACK$1 r0 = ObricAutoGuiItemAdapter.d;
            PackageManager r1 = AppHost.a.getApplication().getPackageManager();
            Drawable r2 = r1.getApplicationIcon(r5);     // Catch: Exception -> L5
            Intrinsics.checkNotNull(r2);     // Catch: Exception -> L5
            return r2;
        L5:
            e = move-exception;
            FLogger.a.e("ObricAutoGuiSettingsFragment", "loadAppIcon failed, packageName: " + r5 + ", error: " + e);
            Drawable r3 = r1.getDefaultActivityIcon();
            Intrinsics.checkNotNull(r3);
            return r3;
        }

        public static final void b(final OCardListItem r3) {
            ObricAutoGuiItemAdapter$Companion$DIFF_CALLBACK$1 r0 = ObricAutoGuiItemAdapter.d;
            LinearLayout r1 = r3.getTitleContainer();
            ConstraintLayout.LayoutParams r2 = r3.getTitleContainer().getLayoutParams();
            if ((r2 instanceof ConstraintLayout.LayoutParams) == false) goto L5;
            ConstraintLayout.LayoutParams r4 = r2;
        L6:
            if (r4 == null) goto L8;
            ((ViewGroup.MarginLayoutParams) r4).width = 0;
            r4.W = false;
            r4.L = 0;
        L9:
            r1.setLayoutParams(r4);
            r3.post(new m(r3));
            return;
        L8:
            r4 = r3.getTitleContainer().getLayoutParams();
            goto L9
        L5:
            r4 = null;
            goto L6
        }
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.obric.assistant.settings.autogui.ObricAutoGuiItemAdapter$Companion$DIFF_CALLBACK$1] */
    static {
        new a();
        d = new ObricAutoGuiItemAdapter$Companion$DIFF_CALLBACK$1();
    }

    public final FragmentActivity getActivity() {
        return this.a;
    }

    public final int getItemViewType(int r1) {
        return ((b0) getItem(r1)).a.getValue();
    }

    public ObricAutoGuiItemAdapter(FragmentActivity r2, c0 r3) {
        super(d);
        this.a = r2;
        this.b = r3;
        this.c = t9a.b.a().b();
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r2, int r3) {
        ObricAutoGuiItemViewHolder r4 = (ObricAutoGuiItemViewHolder) r2;
        Intrinsics.checkNotNullParameter(r4, "holder");
        r4.U3((b0) getItem(r3));
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r13, int r14) {
        Intrinsics.checkNotNullParameter(r13, "parent");
        if (r14 != ObricAutoGuiItemViewType.AUTO_GUI_SWITCH.getValue()) goto L20;
        FragmentActivity r0 = this.a;
        boolean r2 = this.c;
        View r15 = LayoutInflater.from(r13.getContext()).inflate(2131561632, r13, false);
        int r1 = 2131373925;
        OCardListItem r6 = ViewBindings.findChildViewById(r15, 2131373925);
        if (r6 == null) goto L18;
        r1 = 2131373926;
        OCardListItem r7 = ViewBindings.findChildViewById(r15, 2131373926);
        if (r7 == null) goto L18;
        r1 = 2131373958;
        OCardListItem r8 = ViewBindings.findChildViewById(r15, 2131373958);
        if (r8 == null) goto L18;
        r1 = 2131373990;
        OCardListItem r9 = ViewBindings.findChildViewById(r15, 2131373990);
        if (r9 == null) goto L18;
        r1 = 2131374002;
        OCardListItem r10 = ViewBindings.findChildViewById(r15, 2131374002);
        if (r10 == null) goto L18;
        r1 = 2131374009;
        OCardListItem r11 = ViewBindings.findChildViewById(r15, 2131374009);
        if (r11 == null) goto L18;
        return new ObricAutoGuiItemGuiSwitchViewHolder(r0, r2, new ItemObricAutoAppTypeGuiSwitchBinding((LinearLayout) r15, r6, r7, r8, r9, r10, r11), this.b);
    L18:
        throw new NullPointerException("Missing required view with ID: ".concat(r15.getResources().getResourceName(r1)));
    L20:
        if (r14 != ObricAutoGuiItemViewType.TITLE_HINT.getValue()) goto L27;
        FragmentActivity r3 = this.a;
        OSectionSupportiveText r16 = LayoutInflater.from(r13.getContext()).inflate(2131561635, r13, false);
        if (r16 == null) goto L25;
        OSectionSupportiveText r17 = r16;
        return new ObricAutoGuiItemTitleViewHolder(r3, new ItemObricAutoAppTypeTitleBinding(r17, r17));
    L25:
        throw new NullPointerException("rootView");
    L27:
        if (r14 != ObricAutoGuiItemViewType.APP_AVAILABLE.getValue()) goto L34;
        FragmentActivity r4 = this.a;
        boolean r5 = this.c;
        OCardListItem r18 = LayoutInflater.from(r13.getContext()).inflate(2131561631, r13, false);
        if (r18 == null) goto L32;
        OCardListItem r19 = r18;
        return new ObricAutoGuiItemAvailableViewHolder(r4, r5, new ItemObricAutoAppTypeAvailableBinding(r19, r19));
    L32:
        throw new NullPointerException("rootView");
    L34:
        if (r14 != ObricAutoGuiItemViewType.APP_INAVAILABLE.getValue()) goto L41;
        FragmentActivity r12 = this.a;
        boolean r20 = this.c;
        OCardListItem r110 = LayoutInflater.from(r13.getContext()).inflate(2131561633, r13, false);
        if (r110 == null) goto L39;
        OCardListItem r111 = r110;
        return new ObricAutoGuiItemInAvailableViewHolder(r12, r20, new ItemObricAutoAppTypeInavailableBinding(r111, r111));
    L39:
        throw new NullPointerException("rootView");
    L41:
        if (r14 != ObricAutoGuiItemViewType.LOADING_HINT.getValue()) goto L48;
        FragmentActivity r21 = this.a;
        View r112 = LayoutInflater.from(r13.getContext()).inflate(2131561634, r13, false);
        if (r112 == null) goto L46;
        return new ObricAutoGuiItemLoadingHintViewHolder(r21, new ItemObricAutoAppTypeLoadingBinding((TextView) r112));
    L46:
        throw new NullPointerException("rootView");
    L48:
        return new ObricAutoGuiItemEmptyViewHolder(r13);
    }
}
