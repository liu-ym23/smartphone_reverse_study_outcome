package com.larus.dora.obric.device_management.setting.earbuds.broadcast;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.core.content.ContextCompat;
import androidx.core.widget.TextViewCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwnerKt;
import com.larus.dora.impl.device.DoraBaseFragment;
import com.larus.dora.impl.noti_v3.social_message.model.MessageModeSheetSource;
import com.larus.dora.impl.noti_v3.social_message.viewmodel.NotificationBroadcastV3SocialMessageViewModel;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.assistant.interaction.impl.window.helpers.PopupWindowLancet;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.popover.menu.OPopoverEntranceMenuView;
import com.obric.oui.text.OTextView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0002\u0018\u0000 <2\u00020\u0001:\u0001<B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\u001a\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00172\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\b\u0010!\u001a\u00020\u001fH\u0016J\b\u0010\"\u001a\u00020\u0014H\u0016J\n\u0010#\u001a\u0004\u0018\u00010\u0017H\u0016J\b\u0010$\u001a\u00020%H\u0002J4\u0010&\u001a\u00020\r2\u0006\u0010'\u001a\u00020\u00142\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\u0012\u0010,\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u001f0-H\u0002J\f\u0010.\u001a\u00020\u001f*\u00020\rH\u0002J\f\u0010/\u001a\u00020\u001f*\u00020\rH\u0002J\"\u00100\u001a\u00020\u001f2\u0006\u00101\u001a\u0002022\b\u00103\u001a\u0004\u0018\u00010\u00142\u0006\u00104\u001a\u00020\rH\u0002J\f\u00105\u001a\u00020\u001f*\u000206H\u0002J\b\u00107\u001a\u00020\u001fH\u0002J\b\u00108\u001a\u00020\u001fH\u0002J\f\u00109\u001a\u00020+*\u00020+H\u0002J\f\u0010:\u001a\u00020+*\u00020;H\u0002R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006="}, d2 = {"Lcom/larus/dora/obric/device_management/setting/earbuds/broadcast/DoraObricEarbudsSocialMessageFragment;", "Lcom/larus/dora/impl/device/DoraBaseFragment;", "<init>", "()V", "viewModel", "Lcom/larus/dora/impl/noti_v3/social_message/viewmodel/NotificationBroadcastV3SocialMessageViewModel;", "getViewModel", "()Lcom/larus/dora/impl/noti_v3/social_message/viewmodel/NotificationBroadcastV3SocialMessageViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "page", "Lcom/larus/dora/obric/device_management/setting/earbuds/ui/DoraObricEarbudsOuiPage;", "singleItem", "Lcom/obric/oui/lisitem/OCardListItem;", "groupItem", "specialItem", "singlePopover", "Lcom/obric/oui/popover/v2/OPopover;", "groupPopover", "currentSingleMode", "", "currentGroupMode", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "onDestroyView", "getCurrentPageName", "getPageMaskView", "buildListCard", "Landroid/widget/LinearLayout;", "buildListItem", "title", "hasDrop", "", "position", "", "onClick", "Lkotlin/Function1;", "applyCardStyle", "resetCardContainerMargins", "showModeMenu", "source", "Lcom/larus/dora/impl/noti_v3/social_message/model/MessageModeSheetSource;", "currentMode", "anchor", "applyValueTextStyle", "Lcom/obric/oui/text/OTextView;", "observeSettings", "openSpecialContactsPage", "dp", "sp", "", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraObricEarbudsSocialMessageFragment extends DoraBaseFragment {
    public static final /* synthetic */ int o = 0;
    public final Lazy f;
    public b79.d g;
    public OCardListItem h;
    public OCardListItem i;
    public OCardListItem j;
    public com.obric.oui.popover.v2.c k;
    public com.obric.oui.popover.v2.c l;
    public String m;
    public String n;

    public static final class a {
    }

    static {
    }

    public final String k() {
        return "dora_broadcast_social_settings";
    }

    @Override // com.larus.dora.impl.device.DoraBaseFragment
    public final View U90() {
        b79.d r0 = this.g;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.e;
    }

    public final NotificationBroadcastV3SocialMessageViewModel Z90() {
        return (NotificationBroadcastV3SocialMessageViewModel) this.f.getValue();
    }

    public final void onDestroyView() {
        com.obric.oui.popover.v2.c r0 = this.k;
        if (r0 == null) goto L5;
        W90(r0);
    L5:
        com.obric.oui.popover.v2.c r1 = this.l;
        if (r1 == null) goto L8;
        W90(r1);
    L8:
        this.k = null;
        this.l = null;
        this.h = null;
        this.i = null;
        this.j = null;
        this.g = null;
        super/*androidx.fragment.app.Fragment*/.onDestroyView();
    }

    public DoraObricEarbudsSocialMessageFragment() {
        final Function0<Fragment> r0 = new DoraObricEarbudsSocialMessageFragment$special$$inlined$viewModels$default$1(this);
        this.f = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(NotificationBroadcastV3SocialMessageViewModel.class), new DoraObricEarbudsSocialMessageFragment$special$$inlined$viewModels$default$2(r0), new DoraObricEarbudsSocialMessageFragment$special$$inlined$viewModels$default$3(r0, this));
    }

    public static void W90(com.obric.oui.popover.v2.c r0) {
        PopupWindowLancet.handleDismissBeforeOrigin(r0);
        r0.dismiss();
    }

    public final int Y90(int r3) {
        Resources r0 = getResources();
        return (int) TypedValue.applyDimension(1, r3, WindowDisplayMetricsOverride.apply(r0, r0.getDisplayMetrics()));
    }

    public final void onViewCreated(View r7, Bundle r8) {
        Intrinsics.checkNotNullParameter(r7, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r7, r8);
        Lifecycle.State r9 = Lifecycle.State.STARTED;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DoraObricEarbudsSocialMessageFragment$observeSettings$$inlined$launchAndRepeatWithViewLifecycle$default$1(this, r9, null, this), 3, null);
        Z90().syncSettings();
    }

    public final OCardListItem X90(String r8, int r9, final Function1 r10) {
        ViewGroup.MarginLayoutParams r2 = null;
        final OCardListItem r0 = new OCardListItem(requireContext(), null, 6, 0);
        r0.setCardType(0);
        OCardListItem.h(r0, r9);
        r0.setShowCardBg(true);
        r0.p(false);
        r0.setTitle(r8);
        r0.s(true);
        r0.q(false);
        r0.o(false);
        r0.setDefaultCustomEndView(3);
        r0.m(true);
        r0.k("", Y90(140));
        OTextView r11 = r0.getEndDetail();
        if (r11 == null) goto L5;
        r11.setTextColor(ContextCompat.getColor(requireContext(), 2131104359));
        r11.setTextSize(2, 14.0f);
    L5:
        r0.setTailIcon(2131245082);
        r0.r(true);
        ImageView r12 = r0.getTailIconView();
        r12.setImageTintList(ContextCompat.getColorStateList(r12.getContext(), 2131104363));
        r12.setScaleType(ImageView.ScaleType.FIT_CENTER);
        ViewGroup.LayoutParams r3 = r12.getLayoutParams();
        if (r3 == null) goto L8;
        r3.width = Y90(20);
        r3.height = Y90(20);
    L9:
        r12.setLayoutParams(r3);
        ViewGroup.LayoutParams r13 = r0.getCardContainer().getLayoutParams();
        if ((r13 instanceof ViewGroup.MarginLayoutParams) == false) goto L12;
        r2 = (ViewGroup.MarginLayoutParams) r13;
    L12:
        if (r2 == null) goto L14;
        r2.setMarginStart(0);
        r2.setMarginEnd(0);
        r2.leftMargin = 0;
        r2.rightMargin = 0;
        r0.getCardContainer().setLayoutParams(r2);
    L14:
        r0.getContentContainer().setPadding(0, 0, Y90(4), 0);
        r0.getTitleContainer().setGravity(16);
        r0.getTitleContainer().setPadding(Y90(12), Y90(8), Y90(8), Y90(8));
        OTextView r14 = r0.getTitleView();
        r14.setGravity(8388611);
        r14.setMaxLines(1);
        r14.setTextSize(2, 16.0f);
        Resources r15 = getResources();
        TextViewCompat.setLineHeight(r14, (int) TypedValue.applyDimension(2, 22.0f, WindowDisplayMetricsOverride.apply(r15, r15.getDisplayMetrics())));
        r14.setTypeface(Typeface.create(Typeface.create("sans-serif", 0), 400, false));
        r0.o(false);
        r0.setOnContentClickListener(new y2(r0, r10));
        return r0;
    L8:
        r3 = null;
        goto L9
    }

    public final void aa0(final MessageModeSheetSource r21, String r22, final OCardListItem r23) {
        FragmentActivity r3 = getActivity();
        if (r3 != null) goto L5;
        return;
    L5:
        if (r22 != null) goto L7;
        String r4 = "1";
    L8:
        List<v59.a> r5 = r21.toOptions();
        ArrayList r6 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r5, 10));
        Iterator<T> r7 = r5.iterator();
    L10:
        if (r7.hasNext() == false) goto L16;
        v59.a r8 = (v59.a) r7.next();
        String r9 = r8.c;
        int r10 = com.larus.utils.j0.a;
        String r11 = com.larus.utils.j0.d(r8.a);
        Integer r12 = r8.b;
        if (r12 == null) goto L14;
        String r13 = com.larus.utils.j0.d(r12.intValue());
    L15:
        r6.add(TuplesKt.to(r9, TuplesKt.to(r11, r13)));
        goto L10
    L14:
        r13 = null;
        goto L15
    L16:
        OPopoverEntranceMenuView.Builder r14 = new OPopoverEntranceMenuView.Builder(requireContext());
        r14.f(OPopoverEntranceMenuView.WidthLevel.WIDTH_LEVEL_BROAD);
        r14.h = true;
        r14.e = 1;
        Iterator r15 = r6.iterator();
    L18:
        if (r15.hasNext() == false) goto L20;
        Pair r16 = (Pair) r15.next();
        final String r17 = (String) r16.component1();
        Pair r18 = (Pair) r16.component2();
        OPopoverEntranceMenuView.Builder.d(r14, 0, 0, 0, (CharSequence) r18.getFirst(), (CharSequence) r18.getSecond(), true, Intrinsics.areEqual(r17, r4), new z2(r21, this, r17), 1792);
        goto L18
    L20:
        OPopoverEntranceMenuView r20 = r14.e();
        com.obric.oui.popover.v2.c.a r24 = new com.obric.oui.popover.v2.c.a(r3);
        Intrinsics.checkNotNullParameter(r20, "view");
        ((com.obric.oui.popover.v2.h) r24).f = r20;
        ((com.obric.oui.popover.v2.h) r24).b = true;
        ((com.obric.oui.popover.v2.h) r24).i = true;
        ((com.obric.oui.popover.v2.h) r24).k = true;
        final com.obric.oui.popover.v2.c r25 = r24.a();
        if (r21 != MessageModeSheetSource.SINGLE) goto L26;
        com.obric.oui.popover.v2.c r1 = this.k;
        if (r1 == null) goto L25;
        W90(r1);
    L25:
        this.k = r25;
    L30:
        r23.post(new a3(this, r25, r23));
        return;
    L26:
        com.obric.oui.popover.v2.c r2 = this.l;
        if (r2 == null) goto L29;
        W90(r2);
    L29:
        this.l = r25;
        goto L30
    L7:
        r4 = r22;
        goto L8
    }

    public final View onCreateView(LayoutInflater r4, ViewGroup r5, Bundle r6) {
        Intrinsics.checkNotNullParameter(r4, "inflater");
        Context r7 = requireContext();
        int r8 = com.larus.utils.j0.a;
        b79.d r9 = new b79.d(r7, com.larus.utils.j0.d(2131902296), new u2(this));
        this.g = r9;
        LinearLayout r10 = new LinearLayout(requireContext());
        r10.setOrientation(1);
        r10.setClipChildren(false);
        r10.setClipToPadding(false);
        OCardListItem r11 = X90(getString(2131902282), 1, new v2(this));
        this.h = r11;
        r10.addView(r11);
        OCardListItem r12 = X90(getString(2131902277), 2, new w2(this));
        this.i = r12;
        r10.addView(r12);
        OCardListItem r13 = X90(getString(2131902314), 3, new x2(this));
        this.j = r13;
        r10.addView(r13);
        r9.a(r10, 0);
        return r9.f;
    }
}
