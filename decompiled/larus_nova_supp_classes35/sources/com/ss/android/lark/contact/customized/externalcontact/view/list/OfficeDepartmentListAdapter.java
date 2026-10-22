package com.ss.android.lark.contact.customized.externalcontact.view.list;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.larksuite.component.ui.imageview.LKUIRoundedImageView;
import com.ss.android.lark.contact.base.contact_list.view.IndexRecyclerViewAdapter;
import com.ss.android.lark.contact.customized.databinding.ContactDbOfficeContactListItemBinding;
import com.ss.android.lark.image.ImageModule;
import com.ss.android.lark.image.entity.LoadParams;
import com.ss.android.lark.utils.UIHelper;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0006\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001!B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0018\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u000eH\u0016J\u0018\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eH\u0016J\"\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u001a0\u00192\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00030\u001cH\u0016J\u0014\u0010\u001d\u001a\u00020\n2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00030\u001cJ\u001a\u0010\u001f\u001a\u00020\n2\u0012\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\n0\tR\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\n\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/ss/android/lark/contact/customized/externalcontact/view/list/OfficeDepartmentListAdapter;", "Lcom/ss/android/lark/contact/base/contact_list/view/IndexRecyclerViewAdapter;", "Lcom/ss/android/lark/contact/customized/externalcontact/view/list/OfficeDepartmentListAdapter$ContactItemViewHolder;", "Lcom/ss/android/lark/officesdk/contact/api/model/OfficeContactEnterpriseModel;", "<init>", "()V", "context", "Landroid/content/Context;", "onClickListener", "Lkotlin/Function1;", BuildConfig.FLAVOR, "getItemId", BuildConfig.FLAVOR, "position", BuildConfig.FLAVOR, "onAttachedToRecyclerView", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "genIndexData", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "items", BuildConfig.FLAVOR, "diff", "newItems", "setOnClickListener", "listener", "ContactItemViewHolder", "contact-doubao_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OfficeDepartmentListAdapter extends IndexRecyclerViewAdapter<ContactItemViewHolder, mtb.c> {
    public Context d;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/contact/customized/externalcontact/view/list/OfficeDepartmentListAdapter$ContactItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/ss/android/lark/contact/customized/databinding/ContactDbOfficeContactListItemBinding;", "<init>", "(Lcom/ss/android/lark/contact/customized/databinding/ContactDbOfficeContactListItemBinding;)V", "getBinding", "()Lcom/ss/android/lark/contact/customized/databinding/ContactDbOfficeContactListItemBinding;", "contact-doubao_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ContactItemViewHolder extends RecyclerView.ViewHolder {
        public final ContactDbOfficeContactListItemBinding a;

        public ContactItemViewHolder(ContactDbOfficeContactListItemBinding r2) {
            Intrinsics.checkNotNullParameter(r2, "binding");
            super(r2.a);
            this.a = r2;
        }
    }

    public OfficeDepartmentListAdapter() {
    }

    public final long getItemId(int r3) {
        return ((mtb.c) getItem(r3)).hashCode();
    }

    public final void onAttachedToRecyclerView(RecyclerView r2) {
        Intrinsics.checkNotNullParameter(r2, "recyclerView");
        super/*androidx.recyclerview.widget.RecyclerView.Adapter*/.onAttachedToRecyclerView(r2);
        this.d = r2.getContext();
    }

    @Override // com.ss.android.lark.contact.base.contact_list.view.IndexRecyclerViewAdapter
    public final Map<Integer, String> z2(List<? extends mtb.c> r2) {
        Intrinsics.checkNotNullParameter(r2, "items");
        return MapsKt.emptyMap();
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r8, int r9) {
        ContactItemViewHolder r10 = (ContactItemViewHolder) r8;
        Intrinsics.checkNotNullParameter(r10, "holder");
        mtb.i r11 = (mtb.c) getItem(r9);
        Context r0 = this.d;
        if (r0 != null) goto L6;
        return;
    L6:
        if ((r11 instanceof mtb.i) == false) goto L9;
        r10.a.b.setImageResource(2131233627);
        r10.a.e.setText(r11.a);
        r10.a.d.setOnClickListener(new b(this, r11));
    L11:
        r10.a.d.setOnLongClickListener(d.a);
        return;
    L9:
        if ((r11 instanceof mtb.j) == false) goto L14;
        int r1 = UIHelper.dp2px(48.0f);
        LKUIRoundedImageView r2 = r10.a.b;
        mtb.j r3 = (mtb.j) r11;
        String r4 = r3.c;
        String r5 = r3.b;
        LoadParams r6 = new LoadParams();
        r6.a = r1;
        r6.b = r1;
        ImageModule.a(r0, r2, r4, r5, r6);
        r10.a.e.setText(r3.a);
        r10.a.d.setOnClickListener(new c(this, r11));
        goto L11
    L14:
        throw new NoWhenBranchMatchedException();
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "parent");
        return new ContactItemViewHolder(ContactDbOfficeContactListItemBinding.a(LayoutInflater.from(r1.getContext()), r1));
    }
}
