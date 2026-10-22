package com.obric.assistant.settings.autoend;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.viewbinding.ViewBindings;
import cga.a;
import cga.d;
import cga.e;
import com.larus.bmhome.view.NovaTitleBarEx;
import com.obric.assistant.AutoEndConversationScene;
import com.obric.assistant.AutoEndConversationTime;
import com.obric.assistant.impl.databinding.ObricFragmentAutoEndConversationBinding;
import com.obric.assistant.interaction.impl.activityresult.ActivityProxyRequestStoreKt;
import com.obric.assistant.interaction.impl.window.helpers.PopupWindowLancet;
import com.obric.assistant.settings.t;
import com.obric.assistant.t1;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.oswitch.OSwitch;
import com.obric.oui.popover.v2.c;
import com.obric.oui.titlebar.OFloatingTitleBar;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import t9a.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\n\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J$\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u001a\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00102\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\b\u0010\u001a\u001a\u00020\u0018H\u0016J\b\u0010\u001b\u001a\u00020\u0018H\u0016J\b\u0010\u001c\u001a\u00020\u0018H\u0002J\b\u0010\u001d\u001a\u00020\u0018H\u0002J*\u0010\u001e\u001a\u00020\u00182\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\b\b\u0001\u0010#\u001a\u00020\"2\u0006\u0010$\u001a\u00020\"H\u0002J\b\u0010%\u001a\u00020\u0018H\u0002J\b\u0010&\u001a\u00020\fH\u0002J\u001a\u0010'\u001a\u00020\u00182\u0006\u0010\u001f\u001a\u00020 2\b\b\u0001\u0010#\u001a\u00020\"H\u0002J\u001a\u0010(\u001a\u00020\u00182\u0006\u0010)\u001a\u00020 2\b\b\u0001\u0010#\u001a\u00020\"H\u0002J\u0018\u0010*\u001a\b\u0012\u0004\u0012\u00020,0+2\b\b\u0001\u0010#\u001a\u00020\"H\u0002J\u0012\u0010-\u001a\u00020.2\b\b\u0001\u0010/\u001a\u00020,H\u0002J\u0018\u00100\u001a\u00020\u00182\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010$\u001a\u00020\"H\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u00061"}, d2 = {"Lcom/obric/assistant/settings/autoend/ObricAutoEndConversationFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/obric/assistant/settings/ObricFloatingTitleBarProvider;", "<init>", "()V", "binding", "Lcom/obric/assistant/impl/databinding/ObricFragmentAutoEndConversationBinding;", "doubaoTitleBar", "Lcom/larus/bmhome/view/NovaTitleBarEx;", "optionPopover", "Lcom/obric/oui/popover/v2/OPopover;", "isObricOS", "", "getFloatingTitleBar", "Lcom/obric/oui/titlebar/OFloatingTitleBar;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "onResume", "onDestroyView", "initTopBar", "initSettingItems", "bindTimeItem", "item", "Lcom/obric/oui/lisitem/OCardListItem;", "titleRes", "", "scene", "position", "refreshSettingItems", "isGazeKeepDisplaySupported", "updateTimeItem", "showOptionMenu", "anchor", "timesForScene", "", "", "optionText", "", "time", "applyDoubaoCardStyle", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricAutoEndConversationFragment extends Fragment implements t {
    public static final /* synthetic */ int g = 0;
    public ObricFragmentAutoEndConversationBinding d;
    public c e;
    public final boolean f;

    @Override // com.obric.assistant.settings.t
    public final OFloatingTitleBar gW() {
        if (this.f == true) goto L5;
        return null;
    L5:
        ObricFragmentAutoEndConversationBinding r0 = this.d;
        if (r0 != null) goto L8;
        return null;
    L8:
        return r0.e;
    }

    public final void onDestroyView() {
        c r0 = this.e;
        if (r0 == null) goto L5;
        PopupWindowLancet.handleDismissBeforeOrigin(r0);
        r0.dismiss();
    L5:
        this.e = null;
        this.d = null;
        super.onDestroyView();
    }

    public final void refreshSettingItems() {
        ObricFragmentAutoEndConversationBinding r0 = this.d;
        if (r0 != null) goto L5;
        return;
    L5:
        U90(r0.c, 0);
        U90(r0.d, 1);
        t1 r1 = t1.a;
        if (r1.R1() == true) goto L8;
        return;
    L8:
        OSwitch r2 = r0.b.getEndSwitch();
        if (r2 == null) goto L12;
        r2.setOnCheckedChangeListener(null);
        r2.setChecked(r1.s1());
        r2.setOnCheckedChangeListener(new a());
        return;
    }

    public ObricAutoEndConversationFragment() {
        this.f = b.a().b();
    }

    public final void onResume() {
        super.onResume();
        refreshSettingItems();
    }

    public final String T90(@AutoEndConversationTime long r4) {
        if (r4 != ActivityProxyRequestStoreKt.PROXY_CREATE_TIMEOUT_MS) goto L6;
        int r5 = 2131912420;
    L19:
        return getString(r5);
    L6:
        if (r4 != 20000) goto L9;
        r5 = 2131912421;
        goto L19
    L9:
        if (r4 != 30000) goto L12;
        r5 = 2131912422;
        goto L19
    L12:
        if (r4 != 60000) goto L15;
        r5 = 2131912423;
        goto L19
    L15:
        if (r4 != (-1)) goto L17;
        r5 = 2131912424;
        goto L19
    L17:
        r5 = 2131912425;
        goto L19
    }

    public final void U90(OCardListItem r3, @AutoEndConversationScene int r4) {
        String r5 = T90(t1.a.M1(r4));
        int r0 = OCardListItem.I;
        r3.k(r5, -1);
    }

    public final void onViewCreated(View r9, Bundle r10) {
        Intrinsics.checkNotNullParameter(r9, "view");
        super.onViewCreated(r9, r10);
        ObricFragmentAutoEndConversationBinding r11 = this.d;
        if (r11 == null) goto L11;
        OFloatingTitleBar r12 = r11.e;
        if (r12 == null) goto L11;
        if (this.f == false) goto L10;
        r12.setCenterTitle(2131912419);
        OFloatingTitleBar.k(r12, new cga.b(this), 2);
        goto L11
    L10:
        NovaTitleBarEx r13 = rda.a.b(r12);
        NovaTitleBarEx.Y5(r13, getString(2131912419), null, null, 6);
        NovaTitleBarEx.b6(r13, 2131241477, false, null, null, new cga.c(this), 14);
    L11:
        ObricFragmentAutoEndConversationBinding r14 = this.d;
        if (r14 == null) goto L26;
        S90(r14.c, 2131912426, 0, 1);
        S90(r14.d, 2131912427, 1, 3);
        OCardListItem r0 = r14.b;
        if (t1.a.R1() == false) goto L17;
        int r1 = 0;
    L18:
        r0.setVisibility(r1);
        OCardListItem r15 = r14.b;
        r15.setCardType(0);
        OCardListItem.h(r15, 0);
        r15.p(false);
        r15.setTitle(getString(2131912501));
        r15.s(true);
        r15.setSubTitle(getString(2131912502));
        r15.q(true);
        r15.getSubTitleView().setMaxLines(2);
        r15.setDefaultCustomEndView(1);
        r15.m(true);
        r15.r(false);
        Intrinsics.checkNotNull(r15);
        if (this.f == true) goto L21;
        rda.a.a(r15, 0);
    L21:
        OSwitch r16 = r15.getEndSwitch();
        if (r16 == null) goto L24;
        r16.setOnCheckedChangeListener(new d());
    L24:
        refreshSettingItems();
        return;
    L17:
        r1 = 8;
        goto L18
    }

    public final View onCreateView(LayoutInflater r7, ViewGroup r8, Bundle r9) {
        Intrinsics.checkNotNullParameter(r7, "inflater");
        ConstraintLayout r10 = r7.inflate(2131563994, r8, false);
        int r11 = 2131373614;
        OCardListItem r2 = ViewBindings.findChildViewById(r10, 2131373614);
        if (r2 == null) goto L13;
        r11 = 2131379167;
        OCardListItem r3 = ViewBindings.findChildViewById(r10, 2131379167);
        if (r3 == null) goto L13;
        r11 = 2131379462;
        OCardListItem r4 = ViewBindings.findChildViewById(r10, 2131379462);
        if (r4 == null) goto L13;
        r11 = 2131389118;
        OFloatingTitleBar r5 = ViewBindings.findChildViewById(r10, 2131389118);
        if (r5 == null) goto L13;
        ConstraintLayout r12 = r10;
        this.d = new ObricFragmentAutoEndConversationBinding(r12, r2, r3, r4, r5);
        return r12;
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(r10.getResources().getResourceName(r11)));
    }

    public final void S90(final OCardListItem r2, int r3, @AutoEndConversationScene final int r4, int r5) {
        r2.setCardType(0);
        OCardListItem.h(r2, r5);
        r2.p(false);
        r2.setTitle(getString(r3));
        r2.s(true);
        r2.q(false);
        r2.setDefaultCustomEndView(3);
        r2.m(true);
        r2.setDefaultTailIcon(1);
        r2.r(true);
        if (this.f == true) goto L5;
        rda.a.a(r2, r5);
    L5:
        r2.setOnContentClickListener(new e(this, r2, r4));
    }
}
