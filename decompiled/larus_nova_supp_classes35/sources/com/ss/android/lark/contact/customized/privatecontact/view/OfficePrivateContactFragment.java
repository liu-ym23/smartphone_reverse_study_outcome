package com.ss.android.lark.contact.customized.privatecontact.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewbinding.ViewBindings;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.lark.base.fragment.BaseFragment;
import com.ss.android.lark.contact.customized.common.view.ContactOfficeTitleBar;
import com.ss.android.lark.contact.customized.databinding.ContactDbFragmentOfficePrivateContactBinding;
import com.ss.android.lark.contact.customized.externalcontact.view.OfficeExternalContactFragment;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import n9b.b;
import n9b.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u001a\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u0011\u001a\u00020\u000fH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/ss/android/lark/contact/customized/privatecontact/view/OfficePrivateContactFragment;", "Lcom/ss/android/lark/base/fragment/BaseFragment;", "<init>", "()V", "binding", "Lcom/ss/android/lark/contact/customized/databinding/ContactDbFragmentOfficePrivateContactBinding;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", BuildConfig.FLAVOR, "view", "initTitleBar", "Companion", "contact-doubao_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OfficePrivateContactFragment extends BaseFragment {
    public static final /* synthetic */ int e = 0;
    public ContactDbFragmentOfficePrivateContactBinding d;

    public static final class a {
    }

    static {
    }

    public OfficePrivateContactFragment() {
    }

    public final void onViewCreated(View r7, Bundle r8) {
        Intrinsics.checkNotNullParameter(r7, "view");
        super.onViewCreated(r7, r8);
        ContactDbFragmentOfficePrivateContactBinding r9 = this.d;
        ContactDbFragmentOfficePrivateContactBinding r10 = null;
        if (r9 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r9 = null;
    L5:
        r9.c.setLeftIconClickListener(new n9b.a(this));
        ContactDbFragmentOfficePrivateContactBinding r11 = this.d;
        if (r11 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r11 = null;
    L8:
        r11.c.setRightIconClickListener(new b(this));
        ContactDbFragmentOfficePrivateContactBinding r12 = this.d;
        if (r12 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L12:
        ContactOfficeTitleBar r13 = r10.c;
        c r14 = new c(this);
        r13.getClass();
        FrameLayout r0 = new FrameLayout(r13.getContext());
        r0.setLayoutParams(new LinearLayout.LayoutParams(r13.a(44), r13.a(44)));
        r0.setClickable(true);
        r0.setFocusable(true);
        r0.setOnClickListener(new j9b.a(r14));
        ImageView r15 = new ImageView(r13.getContext());
        r15.setLayoutParams(new FrameLayout.LayoutParams(r13.a(24), r13.a(24), 17));
        r15.setImageResource(2131233636);
        r0.addView(r15);
        r13.c.addView(r0);
        if (getChildFragmentManager().findFragmentByTag("Contact_ExtContactFrag") != null) goto L20;
        int r16 = OfficeExternalContactFragment.r;
        OfficeExternalContactFragment r17 = OfficeExternalContactFragment.a.a(true, false, BuildConfig.FLAVOR);
        FragmentTransaction r1 = getChildFragmentManager().beginTransaction();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r1, r17, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, "Contact_ExtContactFrag", 2131383049) == true) goto L18;
        r1.add(2131383049, r17, "Contact_ExtContactFrag");
    L18:
        r1.commitNow();
        return;
    L20:
        return;
    L11:
        r10 = r12;
        goto L12
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        View r5 = r2.inflate(2131559911, r3, false);
        int r6 = 2131383049;
        FrameLayout r7 = (FrameLayout) ViewBindings.findChildViewById(r5, 2131383049);
        if (r7 == null) goto L9;
        r6 = 2131388807;
        ContactOfficeTitleBar r0 = (ContactOfficeTitleBar) ViewBindings.findChildViewById(r5, 2131388807);
        if (r0 == null) goto L9;
        ContactDbFragmentOfficePrivateContactBinding r8 = new ContactDbFragmentOfficePrivateContactBinding((LinearLayout) r5, r7, r0);
        this.d = r8;
        return r8.a;
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(r5.getResources().getResourceName(r6)));
    }
}
