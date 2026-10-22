package com.ss.android.lark.contact.customized.externalcontact.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.larksuite.component.ui.imageview.LKUIRoundedImageView2;
import com.ss.android.lark.contact.customized.databinding.ContactDbContactSubpageEntryItemLayoutBinding;
import com.ss.android.lark.image.ImageModule;
import com.ss.android.lark.image.entity.LoadParams;
import com.ss.android.lark.utils.UIHelper;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001bB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0018\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0016J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0007\u001a\u00020\u0004J\u001e\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\tJ\u0018\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0010H\u0016R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/ss/android/lark/contact/customized/externalcontact/view/SubPageEntryAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/ss/android/lark/contact/customized/externalcontact/view/SubPageEntryAdapter$SubPageEntryViewHolder;", "initialConfig", "Lcom/ss/android/lark/contact/customized/externalcontact/view/list/OfficeContactHeaderConfig;", "<init>", "(Lcom/ss/android/lark/contact/customized/externalcontact/view/list/OfficeContactHeaderConfig;)V", "config", "selfUserId", BuildConfig.FLAVOR, "selfUserName", "selfAvatarKey", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", BuildConfig.FLAVOR, "getItemCount", "updateConfig", BuildConfig.FLAVOR, "updateSelfCardHeader", "userId", "userName", "avatarKey", "onBindViewHolder", "holder", "position", "SubPageEntryViewHolder", "contact-doubao_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SubPageEntryAdapter extends RecyclerView.Adapter<SubPageEntryViewHolder> {
    public l9b.a a;
    public String b;
    public String c;
    public String d;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J&\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bJ\u0010\u0010\u000e\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0002J\u0010\u0010\u000f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0002J(\u0010\u0010\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH\u0002J\u0010\u0010\u0011\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0002J\u0010\u0010\u0012\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/ss/android/lark/contact/customized/externalcontact/view/SubPageEntryAdapter$SubPageEntryViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "viewBinding", "Lcom/ss/android/lark/contact/customized/databinding/ContactDbContactSubpageEntryItemLayoutBinding;", "<init>", "(Lcom/ss/android/lark/contact/customized/databinding/ContactDbContactSubpageEntryItemLayoutBinding;)V", "bindData", BuildConfig.FLAVOR, "config", "Lcom/ss/android/lark/contact/customized/externalcontact/view/list/OfficeContactHeaderConfig;", "selfUserId", BuildConfig.FLAVOR, "selfUserName", "selfAvatarKey", "bindNewFriendEntry", "bindGroupChatEntry", "bindProfileCardEntry", "bindExternalContactEntry", "bindOrgContactsTitle", "contact-doubao_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class SubPageEntryViewHolder extends RecyclerView.ViewHolder {
        public final ContactDbContactSubpageEntryItemLayoutBinding a;

        public SubPageEntryViewHolder(ContactDbContactSubpageEntryItemLayoutBinding r2) {
            Intrinsics.checkNotNullParameter(r2, "viewBinding");
            super(r2.a);
            this.a = r2;
        }
    }

    public final int getItemCount() {
        return 1;
    }

    public SubPageEntryAdapter(l9b.a r2) {
        Intrinsics.checkNotNullParameter(r2, "initialConfig");
        this.a = r2;
        this.b = BuildConfig.FLAVOR;
        this.c = BuildConfig.FLAVOR;
        this.d = BuildConfig.FLAVOR;
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r9, int r10) {
        SubPageEntryViewHolder r11 = (SubPageEntryViewHolder) r9;
        Intrinsics.checkNotNullParameter(r11, "holder");
        l9b.a r12 = this.a;
        String r0 = this.b;
        String r1 = this.c;
        String r2 = this.d;
        r11.getClass();
        Intrinsics.checkNotNullParameter(r12, "config");
        Intrinsics.checkNotNullParameter(r0, "selfUserId");
        Intrinsics.checkNotNullParameter(r1, "selfUserName");
        Intrinsics.checkNotNullParameter(r2, "selfAvatarKey");
        LinearLayout r3 = r11.a.e;
        int r5 = 0;
        if (r12.a == false) goto L5;
        int r4 = 0;
    L6:
        r3.setVisibility(r4);
        boolean r6 = true;
        if (r12.a == false) goto L21;
        TextView r7 = r11.a.h;
        r7.setText(r12.c);
        if ((!StringsKt.isBlank(r12.c)) == false) goto L12;
        int r8 = 0;
    L13:
        r7.setVisibility(r8);
        TextView r13 = r11.a.g;
        r13.setText(r12.b);
        if (r12.b.length() <= 0) goto L16;
        boolean r14 = true;
    L17:
        if (r14 == false) goto L19;
        int r15 = 0;
    L20:
        r13.setVisibility(r15);
        r11.a.e.setOnClickListener(new x(r12));
        goto L21
    L19:
        r15 = 8;
        goto L20
    L16:
        r14 = false;
        goto L17
    L12:
        r8 = 8;
    L21:
        r11.a.d.setOnClickListener(new w(r12));
        LinearLayout r16 = r11.a.f;
        if (r12.d == false) goto L24;
        int r17 = 0;
    L25:
        r16.setVisibility(r17);
        if (r12.d == false) goto L33;
        r11.a.j.setText(r1);
        if (r0.length() > 0) goto L31;
        r6 = false;
    L31:
        if (r6 == false) goto L33;
        int r18 = UIHelper.dp2px(48.0f);
        Context r19 = r11.a.a.getContext();
        LKUIRoundedImageView2 r20 = r11.a.b;
        LoadParams r21 = new LoadParams();
        r21.a = r18;
        r21.b = r18;
        ImageModule.a(r19, r20, r2, r0, r21);
    L33:
        r11.a.f.setOnClickListener(new y(r12));
        LinearLayout r22 = r11.a.c;
        if (r12.e == false) goto L36;
        int r23 = 0;
    L37:
        r22.setVisibility(r23);
        r11.a.c.setOnClickListener(new v(r12));
        TextView r24 = r11.a.i;
        if (r12.f == true) goto L41;
        r5 = 8;
    L41:
        r24.setVisibility(r5);
        return;
    L36:
        r23 = 8;
        goto L37
    L24:
        r17 = 8;
        goto L25
    L5:
        r4 = 8;
        goto L6
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r13, int r14) {
        Intrinsics.checkNotNullParameter(r13, "parent");
        View r15 = LayoutInflater.from(r13.getContext()).inflate(2131559905, r13, false);
        int r16 = 2131376226;
        if (((ImageView) ViewBindings.findChildViewById(r15, 2131376226)) == null) goto L33;
        r16 = 2131376431;
        if (((ImageView) ViewBindings.findChildViewById(r15, 2131376431)) == null) goto L33;
        r16 = 2131376509;
        LKUIRoundedImageView2 r3 = ViewBindings.findChildViewById(r15, 2131376509);
        if (r3 == null) goto L33;
        r16 = 2131378688;
        LinearLayout r4 = (LinearLayout) ViewBindings.findChildViewById(r15, 2131378688);
        if (r4 == null) goto L33;
        r16 = 2131378706;
        LinearLayout r5 = (LinearLayout) ViewBindings.findChildViewById(r15, 2131378706);
        if (r5 == null) goto L33;
        r16 = 2131378766;
        LinearLayout r6 = (LinearLayout) ViewBindings.findChildViewById(r15, 2131378766);
        if (r6 == null) goto L33;
        r16 = 2131378808;
        LinearLayout r7 = (LinearLayout) ViewBindings.findChildViewById(r15, 2131378808);
        if (r7 == null) goto L33;
        r16 = 2131390597;
        if (((TextView) ViewBindings.findChildViewById(r15, 2131390597)) == null) goto L33;
        r16 = 2131390985;
        TextView r8 = (TextView) ViewBindings.findChildViewById(r15, 2131390985);
        if (r8 == null) goto L33;
        r16 = 2131390986;
        TextView r9 = (TextView) ViewBindings.findChildViewById(r15, 2131390986);
        if (r9 == null) goto L33;
        r16 = 2131390987;
        if (((TextView) ViewBindings.findChildViewById(r15, 2131390987)) == null) goto L33;
        r16 = 2131391051;
        TextView r10 = (TextView) ViewBindings.findChildViewById(r15, 2131391051);
        if (r10 == null) goto L33;
        r16 = 2131391180;
        if (((TextView) ViewBindings.findChildViewById(r15, 2131391180)) == null) goto L33;
        r16 = 2131391181;
        TextView r11 = (TextView) ViewBindings.findChildViewById(r15, 2131391181);
        if (r11 == null) goto L33;
        return new SubPageEntryViewHolder(new ContactDbContactSubpageEntryItemLayoutBinding((LinearLayout) r15, r3, r4, r5, r6, r7, r8, r9, r10, r11));
    L33:
        throw new NullPointerException("Missing required view with ID: ".concat(r15.getResources().getResourceName(r16)));
    }
}
