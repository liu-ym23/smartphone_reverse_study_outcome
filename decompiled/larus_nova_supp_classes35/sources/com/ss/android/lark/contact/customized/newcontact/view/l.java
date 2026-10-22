package com.ss.android.lark.contact.customized.newcontact.view;

import android.content.Context;
import android.view.View;
import com.ss.android.lark.contact.base.contact_new.mvp.NewContactView;
import com.ss.android.lark.contact.customized.common.OfficeContactUtils;
import com.ss.android.lark.contact.customized.databinding.ContactDbFragmentOfficeNewContactBinding;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class l {
    public final ContactDbFragmentOfficeNewContactBinding a;
    public final b b;
    public a c;
    public OfficeNewContactAdapter d;
    public Context e;
    public lt7.d f;

    public interface a {
        void T();

        boolean canLoadMore();

        void j0(NewContactView.a r1);

        void t0(String r1, String r2);
    }

    public interface b {
        void A();

        void J(String r1, String r2);

        void y();

        void z();
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ l a;

        public c(l r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            this.a.b.z();
        }
    }

    public final void a() {
        this.a.f.setEmptyIcon(2131233633);
        ContactDbFragmentOfficeNewContactBinding r0 = this.a;
        r0.f.setEmptyText(r0.a.getContext().getString(2131890067));
        if (OfficeContactUtils.f() == false) goto L5;
        this.a.f.setHideActionButton(true);
        this.a.f.setOnActionClickListener(null);
    L6:
        this.a.d.setVisibility(8);
        this.a.e.setVisibility(0);
        this.a.f.setVisibility(0);
        this.a.b.setVisibility(8);
        lt7.d r1 = this.f;
        if (r1 == null) goto L10;
        r1.a();
        return;
    L10:
        return;
    L5:
        ContactDbFragmentOfficeNewContactBinding r2 = this.a;
        r2.f.setEmptyActionText(r2.a.getContext().getString(2131890064));
        this.a.f.setOnActionClickListener(new c(this));
        goto L6
    }

    public final void b() {
        this.a.d.setVisibility(0);
        this.a.e.setVisibility(8);
        this.a.f.setVisibility(8);
        this.a.b.setVisibility(8);
        lt7.d r0 = this.f;
        if (r0 == null) goto L6;
        r0.a();
        return;
    }

    public l(ContactDbFragmentOfficeNewContactBinding r2, OfficeNewContactFragment.b r3) {
        Intrinsics.checkNotNullParameter(r2, "viewBinding");
        Intrinsics.checkNotNullParameter(r3, "viewDependency");
        this.a = r2;
        this.b = r3;
    }
}
