package com.ss.android.lark.contact.customized.externalcontact.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.ui.imageview.LKUIRoundedImageView;
import com.larksuite.framework.utils.ICUUtils;
import com.ss.android.lark.base.adapter.LarkRecyclerViewBaseAdapter;
import com.ss.android.lark.contact.base.contact_list.view.IndexRecyclerViewAdapter;
import com.ss.android.lark.contact.customized.common.OfficeContactUtils;
import com.ss.android.lark.contact.customized.databinding.ContactDbOfficeContactListItemBinding;
import com.ss.android.lark.image.ImageModule;
import com.ss.android.lark.image.entity.LoadParams;
import com.ss.android.lark.utils.UIHelper;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0007\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002!\"B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0018\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\rH\u0016J\u0018\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\rH\u0016J\"\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u001a0\u00192\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00030\u001cH\u0016J\u0010\u0010\u001d\u001a\u00020\u000f2\b\u0010\u001e\u001a\u0004\u0018\u00010\tJ\u0014\u0010\u001f\u001a\u00020\u000f2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00030\u001cR\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/ss/android/lark/contact/customized/externalcontact/view/OfficeContactListAdapter;", "Lcom/ss/android/lark/contact/base/contact_list/view/IndexRecyclerViewAdapter;", "Lcom/ss/android/lark/contact/customized/externalcontact/view/OfficeContactListAdapter$ContactItemViewHolder;", "Lcom/ss/android/lark/officesdk/contact/api/model/OfficeContactItemModel;", "<init>", "()V", "context", "Landroid/content/Context;", "itemClickListener", "Lcom/ss/android/lark/contact/customized/externalcontact/view/OfficeContactListAdapter$IItemClickListener;", "getItemId", BuildConfig.FLAVOR, "position", BuildConfig.FLAVOR, "onAttachedToRecyclerView", BuildConfig.FLAVOR, "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "genIndexData", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "items", BuildConfig.FLAVOR, "setItemClickListener", "listener", "diff", "newItems", "IItemClickListener", "ContactItemViewHolder", "contact-doubao_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OfficeContactListAdapter extends IndexRecyclerViewAdapter<ContactItemViewHolder, mtb.d> {
    public Context d;
    public a e;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/contact/customized/externalcontact/view/OfficeContactListAdapter$ContactItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/ss/android/lark/contact/customized/databinding/ContactDbOfficeContactListItemBinding;", "<init>", "(Lcom/ss/android/lark/contact/customized/databinding/ContactDbOfficeContactListItemBinding;)V", "getBinding", "()Lcom/ss/android/lark/contact/customized/databinding/ContactDbOfficeContactListItemBinding;", "contact-doubao_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ContactItemViewHolder extends RecyclerView.ViewHolder {
        public final ContactDbOfficeContactListItemBinding a;

        public ContactItemViewHolder(ContactDbOfficeContactListItemBinding r2) {
            Intrinsics.checkNotNullParameter(r2, "binding");
            super(r2.a);
            this.a = r2;
        }
    }

    public interface a {
        void a(String r1);

        void b(View r1, long r2);
    }

    public OfficeContactListAdapter() {
    }

    public final void B2(List<mtb.d> r3) {
        Intrinsics.checkNotNullParameter(r3, "newItems");
        final ArrayList r0 = new ArrayList(((LarkRecyclerViewBaseAdapter) this).items);
        final ArrayList r1 = new ArrayList(r3);
        if (r0.isEmpty() == false) goto L6;
        ((LarkRecyclerViewBaseAdapter) this).items.clear();
        ((LarkRecyclerViewBaseAdapter) this).items.addAll(r1);
        notifyDataSetChanged();
        return;
    L6:
        DiffUtil.calculateDiff(new OfficeContactListAdapter$diff$diffResult$1(r0, r1)).dispatchUpdatesTo(this);
        ((LarkRecyclerViewBaseAdapter) this).items.clear();
        ((LarkRecyclerViewBaseAdapter) this).items.addAll(r1);
    }

    public final long getItemId(int r3) {
        return ((mtb.d) getItem(r3)).a;
    }

    public final void onAttachedToRecyclerView(RecyclerView r2) {
        Intrinsics.checkNotNullParameter(r2, "recyclerView");
        super/*androidx.recyclerview.widget.RecyclerView.Adapter*/.onAttachedToRecyclerView(r2);
        this.d = r2.getContext();
    }

    @Override // com.ss.android.lark.contact.base.contact_list.view.IndexRecyclerViewAdapter
    public final Map<Integer, String> z2(List<? extends mtb.d> r7) {
        Intrinsics.checkNotNullParameter(r7, "items");
        LinkedHashMap r0 = new LinkedHashMap();
        if (r7.isEmpty() == false) goto L5;
        return r0;
    L5:
        Lazy r3 = OfficeContactUtils.a;
        r0.put(0, OfficeContactUtils.c(((mtb.d) ListProtector.get(r7, 0)).f));
        int r1 = r7.size();
        int r4 = 1;
    L6:
        if (r4 >= r1) goto L11;
        Lazy r5 = OfficeContactUtils.a;
        String r6 = OfficeContactUtils.c(((mtb.d) ListProtector.get(r7, r4 - 1)).f);
        String r8 = OfficeContactUtils.c(((mtb.d) ListProtector.get(r7, r4)).f);
        if (StringsKt.equals(r6, r8, true) == true) goto L10;
        r0.put(Integer.valueOf(r4), r8);
    L10:
        r4 = r4 + 1;
        goto L6
    L11:
        return r0;
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r8, int r9) {
        ContactItemViewHolder r10 = (ContactItemViewHolder) r8;
        Intrinsics.checkNotNullParameter(r10, "holder");
        mtb.d r11 = (mtb.d) getItem(r9);
        Context r0 = this.d;
        if (r0 == null) goto L14;
        String r1 = r11.e;
        r10.a.e.setText(r1);
        if (r11.d.length() <= 0) goto L8;
        boolean r2 = true;
    L9:
        if (r2 == false) goto L11;
        ICUUtils.FormatArgsBuilder r3 = new ICUUtils.FormatArgsBuilder();
        r3.b("nickname", r11.c);
        List r4 = r3.a;
        r10.a.c.setVisibility(0);
        r10.a.c.setText(ICUUtils.icuFormat(UIHelper.getString(2131890047), r4));
    L12:
        String r5 = String.valueOf(r11.a);
        long r6 = r11.a;
        int r7 = UIHelper.dp2px(48.0f);
        LKUIRoundedImageView r12 = r10.a.b;
        String r13 = r11.g;
        LoadParams r14 = new LoadParams();
        r14.a = r7;
        r14.b = r7;
        ImageModule.a(r0, r12, r13, r5, r14);
        r10.a.d.setOnClickListener(new c(this, r5));
        r10.a.d.setOnLongClickListener(new d(this, r6));
        return;
    L11:
        r10.a.c.setVisibility(8);
        goto L12
    L8:
        r2 = false;
        goto L9
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "parent");
        return new ContactItemViewHolder(ContactDbOfficeContactListItemBinding.a(LayoutInflater.from(r1.getContext()), r1));
    }
}
