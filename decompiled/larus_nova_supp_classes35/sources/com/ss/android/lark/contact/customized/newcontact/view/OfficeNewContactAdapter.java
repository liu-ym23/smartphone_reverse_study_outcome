package com.ss.android.lark.contact.customized.newcontact.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.ui.imageview.LKUIRoundedImageView;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.contact.base.contact_new.mvp.NewContactView;
import com.ss.android.lark.contact.base.dto.ChatApplication;
import com.ss.android.lark.image.ImageModule;
import com.ss.android.lark.image.entity.LoadParams;
import com.ss.android.lark.utils.UIHelper;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0000\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002#$B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0011H\u0016J\b\u0010\u0016\u001a\u00020\u0011H\u0016J\u000e\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\fJ\u0014\u0010\u0019\u001a\u00020\u00132\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00070\u001bJ\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00070\u001dJ\u000e\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u001f\u001a\u00020\u0007J\u0018\u0010 \u001a\u00020\u00132\u0006\u0010!\u001a\u00020\"2\u0006\u0010\u0014\u001a\u00020\u0002H\u0002R\u001e\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/ss/android/lark/contact/customized/newcontact/view/OfficeNewContactAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/ss/android/lark/contact/customized/newcontact/view/OfficeNewContactAdapter$NewContactViewHolder;", "<init>", "()V", "items", "Ljava/util/ArrayList;", "Lcom/ss/android/lark/contact/base/contact_new/mvp/NewContactView$FriendRequestViewData;", "Lkotlin/collections/ArrayList;", "context", "Landroid/content/Context;", "itemClickListener", "Lcom/ss/android/lark/contact/customized/newcontact/view/OfficeNewContactAdapter$IItemClickListener;", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", BuildConfig.FLAVOR, "onBindViewHolder", BuildConfig.FLAVOR, "holder", "position", "getItemCount", "setItemClickListener", "listener", "setItems", "newItems", BuildConfig.FLAVOR, "getItems", BuildConfig.FLAVOR, "remove", "viewData", "updateConfirmBtn", "status", "Lcom/ss/android/lark/contact/base/dto/ChatApplication$Status;", "IItemClickListener", "NewContactViewHolder", "contact-doubao_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OfficeNewContactAdapter extends RecyclerView.Adapter<NewContactViewHolder> {
    public final ArrayList<NewContactView.a> a;
    public a b;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0011\u0010\u0013\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010¨\u0006\u0015"}, d2 = {"Lcom/ss/android/lark/contact/customized/newcontact/view/OfficeNewContactAdapter$NewContactViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "root", "getRoot", "()Landroid/view/View;", "newContactAvatar", "Lcom/larksuite/component/ui/imageview/LKUIRoundedImageView;", "getNewContactAvatar", "()Lcom/larksuite/component/ui/imageview/LKUIRoundedImageView;", "newContactNameTv", "Landroid/widget/TextView;", "getNewContactNameTv", "()Landroid/widget/TextView;", "newContactSubTv", "getNewContactSubTv", "confirmBtn", "getConfirmBtn", "contact-doubao_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class NewContactViewHolder extends RecyclerView.ViewHolder {
        public final View a;
        public final LKUIRoundedImageView b;
        public final TextView c;
        public final TextView d;
        public final TextView e;

        public NewContactViewHolder(View r2) {
            Intrinsics.checkNotNullParameter(r2, "itemView");
            super(r2);
            this.a = r2;
            this.b = r2.findViewById(2131367709);
            this.c = (TextView) r2.findViewById(2131367719);
            this.d = (TextView) r2.findViewById(2131367725);
            this.e = (TextView) r2.findViewById(2131367647);
        }
    }

    public interface a {
        void a(View r1, NewContactView.a r2);

        void b(String r1, String r2);
    }

    public final int getItemCount() {
        return this.a.size();
    }

    public OfficeNewContactAdapter() {
        this.a = new ArrayList();
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r9, int r10) {
        NewContactViewHolder r11 = (NewContactViewHolder) r9;
        Intrinsics.checkNotNullParameter(r11, "holder");
        NewContactView.a r12 = (NewContactView.a) ListProtector.get(this.a, r10);
        r11.c.setText(r12.d);
        String r0 = r12.g;
        boolean r1 = true;
        if (r0 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == true) goto L11;
        String r3 = r12.g;
    L12:
        if (r3 == null) goto L18;
        if (r3.length() == 0) goto L18;
        r1 = false;
    L18:
        if (r1 == false) goto L20;
        r11.d.setVisibility(8);
    L21:
        int r4 = UIHelper.dp2px(60.0f);
        Context r5 = r11.b.getContext();
        LKUIRoundedImageView r6 = r11.b;
        String r7 = r12.c;
        String r8 = r12.b;
        LoadParams r13 = new LoadParams();
        r13.a = r4;
        r13.b = r4;
        ImageModule.a(r5, r6, r7, r8, r13);
        ChatApplication.Status r14 = r12.h;
        Intrinsics.checkNotNull(r14);
        if (r14 != ChatApplication.Status.PEDING) goto L24;
        r11.e.setVisibility(0);
        TextView r15 = r11.e;
        r15.setTextColor(UIUtils.getColor(r15.getContext(), 2131102063));
        r11.e.setBackgroundResource(2131233648);
        r11.e.setText(UIHelper.getString(2131890083));
    L35:
        if (r14 != ChatApplication.Status.DELETED) goto L37;
        r11.a.setVisibility(8);
    L38:
        r11.e.setOnClickListener(new c(this, r12));
        r11.a.setOnClickListener(new d(this, r12));
        r11.a.setOnLongClickListener(new e(this, r12));
        return;
    L37:
        r11.a.setVisibility(0);
        goto L38
    L24:
        ChatApplication.Status r16 = ChatApplication.Status.AGREED;
        if (r14 != r16) goto L27;
    L30:
        r11.e.setVisibility(0);
        r11.e.setBackgroundResource(2131233647);
        TextView r17 = r11.e;
        r17.setTextColor(UIUtils.getColor(r17.getContext(), 2131102042));
        if (r14 != r16) goto L33;
        r11.e.setText(UIHelper.getString(2131890032));
        goto L35
    L33:
        r11.e.setText(UIHelper.getString(2131891780));
        goto L35
    L27:
        if (r14 == ChatApplication.Status.EXPIRED) goto L30;
        r11.e.setVisibility(8);
        goto L35
    L20:
        r11.d.setVisibility(0);
        r11.d.setText(r3);
        goto L21
    L11:
        r3 = UIHelper.getString(2131890042);
        goto L12
    L5:
        if (r0.length() == 0) goto L8;
        r2 = false;
        goto L9
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "parent");
        r3.getContext();
        View r5 = LayoutInflater.from(r3.getContext()).inflate(2131559921, r3, false);
        Intrinsics.checkNotNull(r5);
        return new NewContactViewHolder(r5);
    }
}
