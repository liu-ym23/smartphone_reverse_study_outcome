package com.larus.dora.obric.device_management.setting.earbuds.broadcast;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.core.os.BundleKt;
import androidx.core.widget.NestedScrollView;
import androidx.core.widget.TextViewCompat;
import androidx.fragment.app.DialogFragment;
import com.larus.dora.impl.noti_v3.social_message.model.MessageModeSheetSource;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.sheet.v2.OSheet;
import com.obric.oui.sheet.v2.OSheetBase;
import com.obric.oui.text.OTextView;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\u0018\u0000 &2\u00020\u0001:\u0001&B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0002J\u0010\u0010\u0014\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bH\u0002J\b\u0010\u0015\u001a\u00020\u0013H\u0002J\u0018\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\b\u0010\u001b\u001a\u00020\u001cH\u0002J\u0018\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020\u001aH\u0002J\u0010\u0010 \u001a\u00020!2\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\f\u0010\"\u001a\u00020!*\u00020\bH\u0002J\f\u0010#\u001a\u00020\u001a*\u00020\u001aH\u0002J\f\u0010$\u001a\u00020\u001a*\u00020%H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R*\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0007j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b`\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00020\u000b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006'"}, d2 = {"Lcom/larus/dora/obric/device_management/setting/earbuds/broadcast/DoraObricEarbudsMessageModeSheet;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "currentSelectedMode", "", "optionCards", "Ljava/util/LinkedHashMap;", "Lcom/obric/oui/lisitem/OCardListItem;", "Lkotlin/collections/LinkedHashMap;", "source", "Lcom/larus/dora/impl/noti_v3/social_message/model/MessageModeSheetSource;", "getSource", "()Lcom/larus/dora/impl/noti_v3/social_message/model/MessageModeSheetSource;", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "Landroid/os/Bundle;", "buildHeader", "Landroid/view/View;", "defaultMode", "buildBody", "buildOptionCard", "option", "Lcom/larus/dora/impl/noti_v3/social_message/model/MessageModeOption;", "position", "", "buildItemLayoutParams", "Landroid/widget/LinearLayout$LayoutParams;", "resolveCardPosition", "index", "size", "onOptionSelected", "", "applyCardStyle", "dp", "sp", "", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraObricEarbudsMessageModeSheet extends DialogFragment {
    public static final /* synthetic */ int f = 0;
    public String d;
    public final LinkedHashMap<String, OCardListItem> e;

    public static final class a {
        public static DoraObricEarbudsMessageModeSheet a(MessageModeSheetSource r3, String r4) {
            Intrinsics.checkNotNullParameter(r3, "source");
            DoraObricEarbudsMessageModeSheet r0 = new DoraObricEarbudsMessageModeSheet();
            r0.setArguments(BundleKt.bundleOf(new Pair[]{TuplesKt.to("arg_source", r3.name()), TuplesKt.to("arg_selected_mode", r4)}));
            return r0;
        }
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[MessageModeSheetSource.values().length];
            r0[MessageModeSheetSource.SINGLE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r0[MessageModeSheetSource.GROUP.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r0[MessageModeSheetSource.CONFLICT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[MessageModeSheetSource.RHYTHM.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            a = r0;
        }
    }

    static {
    }

    public final MessageModeSheetSource U90() {
        MessageModeSheetSource.a r0 = MessageModeSheetSource.Companion;
        Bundle r1 = getArguments();
        if (r1 == null) goto L5;
        String r2 = r1.getString("arg_source");
    L6:
        r0.getClass();
        return MessageModeSheetSource.a.a(r2);
    L5:
        r2 = null;
        goto L6
    }

    public DoraObricEarbudsMessageModeSheet() {
        this.e = new LinkedHashMap();
    }

    public static void S90(DoraObricEarbudsMessageModeSheet r1) {
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

    public final Dialog onCreateDialog(Bundle r18) {
        Bundle r1 = getArguments();
        if (r1 == null) goto L6;
        String r2 = r1.getString("arg_selected_mode");
        if (r2 == null) goto L6;
    L15:
        this.d = r2;
        OSheet r3 = new OSheet(requireContext(), 0, false, 30);
        OSheetBase.DefaultImpls.p(r3, t2.a(requireContext(), getString(U90().getTitleResId()), new e2(this), new f2(this)).a);
        Context r6 = requireContext();
        List<v59.a> r7 = U90().toOptions();
        LinearLayout r9 = new LinearLayout(r6);
        r9.setOrientation(1);
        Iterator<T> r10 = r7.iterator();
        int r11 = 0;
    L17:
        if (r10.hasNext() == false) goto L47;
        Object r12 = r10.next();
        int r16 = r11 + 1;
        if (r11 >= 0) goto L21;
        CollectionsKt.throwIndexOverflow();
    L21:
        final v59.a r13 = (v59.a) r12;
        int r14 = r7.size();
        if (r14 > 1) goto L24;
        int r15 = 0;
    L30:
        final OCardListItem r17 = new OCardListItem(requireContext(), null, 6, 0);
        r17.setCardType(0);
        OCardListItem.h(r17, r15);
        r17.setShowCardBg(true);
        r17.p(false);
        r17.setTitle(getString(r13.a));
        r17.s(true);
        Integer r110 = r13.b;
        if (r110 == null) goto L33;
        r17.setSubTitle(getString(r110.intValue()));
        r17.q(true);
    L34:
        r17.setDefaultCustomEndView(2);
        r17.m(Intrinsics.areEqual(r13.c, this.d));
        r17.r(false);
        ViewGroup.LayoutParams r111 = r17.getCardContainer().getLayoutParams();
        if ((r111 instanceof ViewGroup.MarginLayoutParams) == false) goto L37;
        ViewGroup.MarginLayoutParams r112 = (ViewGroup.MarginLayoutParams) r111;
    L38:
        if (r112 == null) goto L40;
        r112.setMargins(0, 0, 0, 0);
        r112.setMarginStart(0);
        r112.setMarginEnd(0);
        r17.getCardContainer().setLayoutParams(r112);
    L40:
        r17.getContentContainer().setPadding(T90(12), 0, T90(4), 0);
        r17.getTitleContainer().setGravity(16);
        r17.getTitleContainer().setPadding(T90(0), T90(10), T90(8), T90(10));
        OTextView r4 = r17.getTitleView();
        r4.setGravity(8388611);
        r4.setMaxLines(1);
        r4.setTextColor(v19.c.a(2130972079, r4.getContext(), 2131103136));
        r4.setTextSize(2, 16.0f);
        Resources r113 = getResources();
        TextViewCompat.setLineHeight(r4, (int) TypedValue.applyDimension(2, 22.0f, WindowDisplayMetricsOverride.apply(r113, r113.getDisplayMetrics())));
        r4.setTypeface(Typeface.create(Typeface.create("sans-serif", 0), 400, false));
        OTextView r5 = r17.getSubTitleView();
        r5.setTextColor(v19.c.a(2130972081, r5.getContext(), 2131103143));
        r5.setTextSize(2, 12.0f);
        Resources r114 = getResources();
        TextViewCompat.setLineHeight(r5, (int) TypedValue.applyDimension(2, 16.0f, WindowDisplayMetricsOverride.apply(r114, r114.getDisplayMetrics())));
        ViewGroup.LayoutParams r8 = r5.getLayoutParams();
        if ((r8 instanceof ViewGroup.MarginLayoutParams) == false) goto L43;
        ViewGroup.MarginLayoutParams r20 = (ViewGroup.MarginLayoutParams) r8;
    L44:
        if (r20 == null) goto L46;
        r20.topMargin = T90(2);
        r5.setLayoutParams(r20);
    L46:
        r17.o(false);
        r17.setOnContentClickListener(new d2(r17, this, r13));
        this.e.put(r13.c, r17);
        r9.addView(r17, new LinearLayout.LayoutParams(-1, -2));
        r11 = r16;
        goto L17
    L43:
        r20 = null;
        goto L44
    L37:
        r112 = null;
        goto L38
    L33:
        r17.q(false);
        goto L34
    L24:
        if (r11 != 0) goto L27;
        r15 = 1;
        goto L30
    L27:
        if (r11 != (r14 - 1)) goto L29;
        r15 = 3;
        goto L30
    L29:
        r15 = 2;
        goto L30
    L47:
        LinearLayout r21 = new LinearLayout(r6);
        r21.setOrientation(1);
        r21.setPadding(T90(12), 0, T90(12), T90(16));
        r21.addView(r9, new LinearLayout.LayoutParams(-1, -2));
        NestedScrollView r22 = new NestedScrollView(r6);
        r22.setClipChildren(false);
        r22.setClipToPadding(false);
        r22.setOverScrollMode(2);
        r22.setFillViewport(true);
        r22.addView(r21, new ViewGroup.LayoutParams(-1, -2));
        OSheetBase.DefaultImpls.j(r3, r22);
        r3.setOnDismissListener(new c2(this));
        return r3;
    L6:
        int r23 = b.a[U90().ordinal()];
        if (r23 == 1) goto L14;
        if (r23 == 2) goto L14;
        if (r23 == 3) goto L14;
        if (r23 != 4) goto L13;
        r2 = "10";
        goto L15
    L13:
        throw new NoWhenBranchMatchedException();
    L14:
        r2 = "1";
        goto L15
    }
}
