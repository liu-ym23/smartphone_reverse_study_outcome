package com.larksuite.component.card.component.personlist.detail;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.card.component.personlist.PersonInfo;
import com.larksuite.component.card.component.personlist.g;
import com.larksuite.component.ui.imageview.LKUIRoundedImageView2;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.ss.android.lark.image.ImageLoader;
import com.ss.android.lark.image.entity.AvatarImage;
import com.ss.android.lark.utils.UIHelper;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 #2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003#$%B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u000eH\u0016J \u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u000eH\u0002J\b\u0010\u0019\u001a\u00020\u000eH\u0016J\u0016\u0010\u001a\u001a\u00020\u00102\u000e\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u001cJ\u001a\u0010\u001d\u001a\u00020\u00102\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020!0\u001fJ\u000e\u0010\"\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020\tR\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/larksuite/component/card/component/personlist/detail/PersonListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "<init>", "()V", "personList", "", "Lcom/larksuite/component/card/component/personlist/PersonInfo;", "itemClickListener", "Lcom/larksuite/component/card/component/personlist/detail/PersonListAdapter$OnItemClickListener;", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "", "holder", "position", "getPlaceHolderDrawable", "Landroid/graphics/drawable/Drawable;", "context", "Landroid/content/Context;", "width", "height", "getItemCount", "setDataList", "newData", "", "updateData", "personMap", "", "", "Lcom/larksuite/component/card/component/personlist/detail/SimpleChatterInfo;", "setOnItemClickListener", "Companion", "OnItemClickListener", "MemberViewHolder", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class PersonListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public final List<PersonInfo> a;
    public b b;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/larksuite/component/card/component/personlist/detail/PersonListAdapter$MemberViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "getItemView", "()Landroid/view/View;", "avatar", "Lcom/larksuite/component/ui/imageview/LKUIRoundedImageView2;", "getAvatar", "()Lcom/larksuite/component/ui/imageview/LKUIRoundedImageView2;", "setAvatar", "(Lcom/larksuite/component/ui/imageview/LKUIRoundedImageView2;)V", "userName", "Landroid/widget/TextView;", "getUserName", "()Landroid/widget/TextView;", "setUserName", "(Landroid/widget/TextView;)V", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class MemberViewHolder extends RecyclerView.ViewHolder {
        public final View a;

        public MemberViewHolder(View r2) {
            Intrinsics.checkNotNullParameter(r2, "itemView");
            super(r2);
            this.a = r2;
            LKUIRoundedImageView2 r0 = (LKUIRoundedImageView2) r2.findViewById(2131363623);
            TextView r3 = (TextView) r2.findViewById(2131392049);
        }
    }

    public static final class a {
    }

    public interface b {
        void a(String r1);
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ PersonListAdapter a;
        public final /* synthetic */ PersonInfo b;

        public c(PersonListAdapter r1, PersonInfo r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            b r3 = this.a.b;
            if (r3 == null) goto L6;
            r3.a(this.b.getId());
            return;
        }
    }

    static {
    }

    public final int getItemCount() {
        return ((ArrayList) this.a).size();
    }

    public PersonListAdapter() {
        this.a = new ArrayList();
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r8, int r9) {
        Intrinsics.checkNotNullParameter(r8, "holder");
        PersonInfo r10 = (PersonInfo) ListProtector.get(this.a, r9);
        AppCompatImageView r0 = (LKUIRoundedImageView2) r8.itemView.findViewById(2131363623);
        if (r0.getLayoutParams().width <= 0) goto L5;
        int r1 = r0.getLayoutParams().width;
    L7:
        if (r0.getLayoutParams().height <= 0) goto L9;
        int r2 = r0.getLayoutParams().height;
    L10:
        AvatarImage r3 = AvatarImage.Builder.obtain(r10.getAvatarKey(), r10.getId(), r1, r2).build();
        Context r4 = r0.getContext();
        g.a.getClass();
        Intrinsics.checkNotNullParameter(r4, "context");
        Resources r5 = r4.getResources();
        BitmapDrawable r6 = new BitmapDrawable(r5, Bitmap.createScaledBitmap(BitmapFactory.decodeResource(r5, 2131232484), r1, r2, true));
        ImageLoader.with(r0.getContext()).load(r3).placeholder(r6).override(r1, r2).into(r0);
        ((TextView) r8.itemView.findViewById(2131392049)).setText(g.f(r10));
        ((LinearLayout) r8.itemView.findViewById(2131379255)).setOnClickListener(new c(this, r10));
        return;
    L9:
        r2 = UIHelper.dp2px(40.0f);
        goto L10
    L5:
        r1 = UIHelper.dp2px(40.0f);
        goto L7
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "parent");
        View r5 = LayoutInflater.from(r3.getContext()).inflate(2131559262, r3, false);
        Intrinsics.checkNotNull(r5);
        return new MemberViewHolder(r5);
    }
}
