package com.larus.dora.obric.device_management.setting.earbuds.broadcast;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.core.widget.NestedScrollView;
import androidx.core.widget.TextViewCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import com.larus.dora.impl.noti_v3.overview.viewmodel.NotificationBroadcastV3ViewModel;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.sheet.v2.OSheet;
import com.obric.oui.sheet.v2.OSheetBase;
import com.obric.oui.text.OTextView;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\u0018\u0000 -2\u00020\u0001:\u0002,-B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u001bH\u0002J\b\u0010\u001c\u001a\u00020\u001bH\u0002J\u0018\u0010\u001d\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u001f\u001a\u00020 H\u0002J\b\u0010!\u001a\u00020\"H\u0002J\u0018\u0010#\u001a\u00020 2\u0006\u0010$\u001a\u00020 2\u0006\u0010%\u001a\u00020 H\u0002J\u0010\u0010&\u001a\u00020'2\u0006\u0010\u001e\u001a\u00020\u0012H\u0002J\f\u0010(\u001a\u00020'*\u00020\rH\u0002J\f\u0010)\u001a\u00020 *\u00020 H\u0002J\f\u0010*\u001a\u00020 *\u00020+H\u0002R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u000f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R!\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\t\u001a\u0004\b\u0013\u0010\u0014¨\u0006."}, d2 = {"Lcom/larus/dora/obric/device_management/setting/earbuds/broadcast/DoraObricEarbudsServiceNotificationSheet;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "viewModel", "Lcom/larus/dora/impl/noti_v3/overview/viewmodel/NotificationBroadcastV3ViewModel;", "getViewModel", "()Lcom/larus/dora/impl/noti_v3/overview/viewmodel/NotificationBroadcastV3ViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "itemViews", "", "", "Lcom/obric/oui/lisitem/OCardListItem;", "itemSelected", "", "serviceItems", "", "Lcom/larus/dora/obric/device_management/setting/earbuds/broadcast/DoraObricEarbudsServiceNotificationSheet$ServiceItem;", "getServiceItems", "()Ljava/util/List;", "serviceItems$delegate", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "Landroid/os/Bundle;", "buildHeader", "Landroid/view/View;", "buildBody", "buildServiceCard", "item", "position", "", "buildItemLayoutParams", "Landroid/widget/LinearLayout$LayoutParams;", "resolveCardPosition", "index", "size", "onItemClicked", "", "applyCardStyle", "dp", "sp", "", "ServiceItem", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraObricEarbudsServiceNotificationSheet extends DialogFragment {
    public static final /* synthetic */ int h = 0;
    public final Lazy d;
    public final Map<String, OCardListItem> e;
    public final Map<String, Boolean> f;
    public final Lazy g;

    public static final class a {
    }

    public static final class b {
        public final String a;
        public final int b;
        public final int c;
        public final int d;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L15;
            return false;
        L15:
            if (this.c == r6.c) goto L18;
            return false;
        L18:
            if (this.d == r6.d) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            return (((((this.a.hashCode() * 31) + this.b) * 31) + this.c) * 31) + this.d;
        }

        public final String toString() {
            return "ServiceItem(id=" + this.a + ", titleRes=" + this.b + ", subtitleRes=" + this.c + ", iconRes=" + this.d + ')';
        }

        public b(String r2, int r3, int r4, int r5) {
            Intrinsics.checkNotNullParameter(r2, "id");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
        }
    }

    static {
    }

    public DoraObricEarbudsServiceNotificationSheet() {
        final Function0<Fragment> r0 = new DoraObricEarbudsServiceNotificationSheet$special$$inlined$viewModels$default$1(this);
        this.d = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(NotificationBroadcastV3ViewModel.class), new DoraObricEarbudsServiceNotificationSheet$special$$inlined$viewModels$default$2(r0), new DoraObricEarbudsServiceNotificationSheet$special$$inlined$viewModels$default$3(r0, this));
        this.e = new LinkedHashMap();
        this.f = new LinkedHashMap();
        this.g = LazyKt.lazy(new l2());
    }

    public static void S90(DoraObricEarbudsServiceNotificationSheet r1) {
        r1.dismissAllowingStateLoss();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r2 = DialogFragmentLancet.sLastShowStack;
        if (r2 == null) goto L11;
        com.bytedance.crash.d.d(r2, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    public final int T90(int r3) {
        Resources r0 = getResources();
        return (int) ((r3 * WindowDisplayMetricsOverride.apply(r0, r0.getDisplayMetrics()).density) + 0.5f);
    }

    public final Dialog onCreateDialog(Bundle r17) {
        List<String> r1 = ((NotificationBroadcastV3ViewModel) this.d.getValue()).getEnabledServiceIds();
        Iterator r2 = ((List) this.g.getValue()).iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        b r3 = (b) r2.next();
        Map<String, Boolean> r4 = this.f;
        String r5 = r3.a;
        r4.put(r5, Boolean.valueOf(r1.contains(r5)));
        goto L4
    L6:
        OSheet r6 = new OSheet(requireContext(), 0, false, 30);
        OSheetBase.DefaultImpls.p(r6, t2.a(requireContext(), getString(2131902293), new o2(this), new p2(this)).a);
        Context r7 = requireContext();
        LinearLayout r8 = new LinearLayout(r7);
        r8.setOrientation(1);
        Iterator r9 = ((List) this.g.getValue()).iterator();
        int r10 = 0;
    L8:
        if (r9.hasNext() == false) goto L34;
        Object r11 = r9.next();
        int r14 = r10 + 1;
        if (r10 >= 0) goto L12;
        CollectionsKt.throwIndexOverflow();
    L12:
        final b r12 = (b) r11;
        int r15 = ((List) this.g.getValue()).size();
        if (r15 > 1) goto L15;
        int r13 = 0;
    L21:
        OCardListItem r16 = new OCardListItem(requireContext(), null, 6, 0);
        r16.setCardType(0);
        OCardListItem.h(r16, r13);
        r16.setShowCardBg(true);
        r16.setIcon(r12.d);
        r16.p(true);
        r16.setTitle(getString(r12.b));
        r16.s(true);
        r16.setSubTitle(getString(r12.c));
        r16.q(true);
        r16.setDefaultCustomEndView(2);
        r16.m(Intrinsics.areEqual(((LinkedHashMap) this.f).get(r12.a), Boolean.TRUE));
        r16.r(false);
        ViewGroup.LayoutParams r18 = r16.getCardContainer().getLayoutParams();
        if ((r18 instanceof ViewGroup.MarginLayoutParams) == false) goto L24;
        ViewGroup.MarginLayoutParams r20 = (ViewGroup.MarginLayoutParams) r18;
    L25:
        if (r20 == null) goto L27;
        r20.setMargins(0, 0, 0, 0);
        r20.setMarginStart(0);
        r20.setMarginEnd(0);
        r16.getCardContainer().setLayoutParams(r20);
    L27:
        r16.getContentContainer().setPadding(0, 0, T90(4), 0);
        r16.getTitleContainer().setGravity(16);
        r16.getTitleContainer().setPadding(T90(12), T90(10), T90(8), T90(10));
        OTextView r21 = r16.getTitleView();
        r21.setGravity(8388611);
        r21.setMaxLines(1);
        r21.setTextColor(v19.c.a(2130972079, r21.getContext(), 2131103136));
        r21.setTextSize(2, 16.0f);
        Resources r110 = getResources();
        TextViewCompat.setLineHeight(r21, (int) TypedValue.applyDimension(2, 22.0f, WindowDisplayMetricsOverride.apply(r110, r110.getDisplayMetrics())));
        r21.setTypeface(Typeface.create(Typeface.create("sans-serif", 0), 400, false));
        OTextView r22 = r16.getSubTitleView();
        r22.setTextColor(v19.c.a(2130972081, r22.getContext(), 2131103143));
        r22.setTextSize(2, 12.0f);
        Resources r111 = getResources();
        TextViewCompat.setLineHeight(r22, (int) TypedValue.applyDimension(2, 16.0f, WindowDisplayMetricsOverride.apply(r111, r111.getDisplayMetrics())));
        ViewGroup.LayoutParams r23 = r22.getLayoutParams();
        if ((r23 instanceof ViewGroup.MarginLayoutParams) == false) goto L30;
        ViewGroup.MarginLayoutParams r112 = (ViewGroup.MarginLayoutParams) r23;
    L31:
        if (r112 == null) goto L33;
        r112.topMargin = T90(2);
        r22.setLayoutParams(r112);
    L33:
        r16.o(false);
        r16.setOnContentClickListener(new n2(this, r12));
        this.e.put(r12.a, r16);
        r8.addView(r16, new LinearLayout.LayoutParams(-1, -2));
        r10 = r14;
        goto L8
    L30:
        r112 = null;
        goto L31
    L24:
        r20 = null;
        goto L25
    L15:
        if (r10 != 0) goto L18;
        r13 = 1;
        goto L21
    L18:
        if (r10 != (r15 - 1)) goto L20;
        r13 = 3;
        goto L21
    L20:
        r13 = 2;
        goto L21
    L34:
        LinearLayout r24 = new LinearLayout(r7);
        r24.setOrientation(1);
        r24.setPadding(T90(12), 0, T90(12), T90(16));
        r24.addView(r8, new LinearLayout.LayoutParams(-1, -2));
        NestedScrollView r25 = new NestedScrollView(r7);
        r25.setClipChildren(false);
        r25.setClipToPadding(false);
        r25.setOverScrollMode(2);
        r25.setFillViewport(true);
        r25.addView(r24, new ViewGroup.LayoutParams(-1, -2));
        OSheetBase.DefaultImpls.j(r6, r25);
        r6.setOnDismissListener(new m2(this));
        return r6;
    }
}
