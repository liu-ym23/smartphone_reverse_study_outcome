package com.ss.android.lark.contact.customized.externalcontact.view.list;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.larksuite.component.ui.imageview.LKUIRoundedImageView;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.base.adapter.LarkRecyclerViewBaseAdapter;
import com.ss.android.lark.contact.base.contact_list.view.IndexRecyclerViewAdapter;
import com.ss.android.lark.contact.customized.databinding.ContactDbOfficeContactListItemBinding;
import com.ss.android.lark.image.entity.LoadParams;
import com.ss.android.lark.image.impl.LarkImageUtil;
import com.ss.android.lark.passport.signinsdk_api.account.Tenant;
import com.ss.android.lark.passport.signinsdk_api.account.User;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.UIHelper;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import mtb.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0006\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001!B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0018\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\rH\u0016J\u0018\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\rH\u0016J\"\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u001a0\u00192\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00030\u001cH\u0016J\u0014\u0010\u001d\u001a\u00020\u000f2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00030\u001cJ\u0010\u0010\u001f\u001a\u00020\u000f2\b\u0010 \u001a\u0004\u0018\u00010\tR\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/ss/android/lark/contact/customized/externalcontact/view/list/OfficeEnterpriseContactListAdapter;", "Lcom/ss/android/lark/contact/base/contact_list/view/IndexRecyclerViewAdapter;", "Lcom/ss/android/lark/contact/customized/externalcontact/view/list/OfficeEnterpriseContactListAdapter$ContactItemViewHolder;", "Lcom/ss/android/lark/officesdk/contact/api/model/OfficeSubordinateItem;", "<init>", "()V", "context", "Landroid/content/Context;", "itemClickListener", "Lcom/ss/android/lark/contact/customized/externalcontact/view/list/OfficeContactPageDelegate$OfficeContactPageActionHandler;", "getItemId", BuildConfig.FLAVOR, "position", BuildConfig.FLAVOR, "onAttachedToRecyclerView", BuildConfig.FLAVOR, "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "genIndexData", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "items", BuildConfig.FLAVOR, "diff", "newItems", "setItemClickListener", "listener", "ContactItemViewHolder", "contact-doubao_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OfficeEnterpriseContactListAdapter extends IndexRecyclerViewAdapter<ContactItemViewHolder, m> {
    public Context d;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/contact/customized/externalcontact/view/list/OfficeEnterpriseContactListAdapter$ContactItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/ss/android/lark/contact/customized/databinding/ContactDbOfficeContactListItemBinding;", "<init>", "(Lcom/ss/android/lark/contact/customized/databinding/ContactDbOfficeContactListItemBinding;)V", "getBinding", "()Lcom/ss/android/lark/contact/customized/databinding/ContactDbOfficeContactListItemBinding;", "contact-doubao_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ContactItemViewHolder extends RecyclerView.ViewHolder {
        public final ContactDbOfficeContactListItemBinding a;

        public ContactItemViewHolder(ContactDbOfficeContactListItemBinding r2) {
            Intrinsics.checkNotNullParameter(r2, "binding");
            super(r2.a);
            this.a = r2;
        }
    }

    public OfficeEnterpriseContactListAdapter() {
    }

    public final void B2(List<? extends m> r3) {
        Intrinsics.checkNotNullParameter(r3, "newItems");
        final ArrayList r0 = new ArrayList(((LarkRecyclerViewBaseAdapter) this).items);
        final ArrayList r1 = new ArrayList(r3);
        if (r0.isEmpty() == false) goto L6;
        ((LarkRecyclerViewBaseAdapter) this).items.clear();
        ((LarkRecyclerViewBaseAdapter) this).items.addAll(r1);
        notifyDataSetChanged();
        return;
    L6:
        DiffUtil.calculateDiff(new OfficeEnterpriseContactListAdapter$diff$diffResult$1(r0, r1)).dispatchUpdatesTo(this);
        ((LarkRecyclerViewBaseAdapter) this).items.clear();
        ((LarkRecyclerViewBaseAdapter) this).items.addAll(r1);
    }

    public final long getItemId(int r3) {
        return getItem(r3).hashCode();
    }

    public final void onAttachedToRecyclerView(RecyclerView r2) {
        Intrinsics.checkNotNullParameter(r2, "recyclerView");
        super/*androidx.recyclerview.widget.RecyclerView.Adapter*/.onAttachedToRecyclerView(r2);
        this.d = r2.getContext();
    }

    @Override // com.ss.android.lark.contact.base.contact_list.view.IndexRecyclerViewAdapter
    public final Map<Integer, String> z2(List<? extends m> r2) {
        Intrinsics.checkNotNullParameter(r2, "items");
        return MapsKt.emptyMap();
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r7, int r8) {
        ContactItemViewHolder r9 = (ContactItemViewHolder) r7;
        Intrinsics.checkNotNullParameter(r9, "holder");
        mtb.i r10 = (m) getItem(r8);
        Context r0 = this.d;
        if (r0 != null) goto L6;
        return;
    L6:
        if (Intrinsics.areEqual(r10, mtb.g.a) == false) goto L23;
        r9.a.e.setText(UIUtils.getString(r0, 2131892245));
        int r11 = UIHelper.dp2px(48.0f);
        User r1 = ((yzb.b) LarkContext.spiByDwarf(yzb.b.class)).getForegroundUser();
        if (r1 == null) goto L10;
        Tenant r2 = r1.tenant;
    L11:
        LKUIRoundedImageView r3 = r9.a.b;
        String r4 = BuildConfig.FLAVOR;
        if (r2 == null) goto L15;
        String r5 = r2.iconUrl;
        if (r5 == null) goto L15;
    L16:
        LoadParams r6 = new LoadParams();
        r6.a = r11;
        r6.b = r11;
        LarkImageUtil.loadImage(r0, r3, r5, r6);
        r9.a.c.setVisibility(0);
        TextView r12 = r9.a.c;
        if (r2 == null) goto L21;
        String r13 = r2.name;
        if (r13 == null) goto L21;
        r4 = r13;
    L21:
        r12.setText(r4);
        r9.a.d.setOnClickListener(new e(r0));
    L25:
        r9.a.d.setOnLongClickListener(g.a);
        return;
    L15:
        r5 = BuildConfig.FLAVOR;
        goto L16
    L10:
        r2 = null;
        goto L11
    L23:
        if ((r10 instanceof mtb.i) == false) goto L28;
        r9.a.b.setImageResource(2131233627);
        r9.a.e.setText(r10.a);
        r9.a.d.setOnClickListener(new f(r0, r10));
        goto L25
    L28:
        throw new NoWhenBranchMatchedException();
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "parent");
        return new ContactItemViewHolder(ContactDbOfficeContactListItemBinding.a(LayoutInflater.from(r1.getContext()), r1));
    }
}
