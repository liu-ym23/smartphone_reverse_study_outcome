package com.obric.assistant.card.layout.viewholder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.image.loader.ImageLoaderKt;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.card.databinding.ObricCardPhotoHorizontalContainerBinding;
import com.obric.assistant.card.databinding.ObricCardPhotoHorizontalItemBinding;
import com.obric.assistant.card.layout.bean.MessageExtraForViewHolder;
import com.obric.assistant.card.layout.viewholder.abs.AbsCardItemViewHolder;
import com.obric.assistant.card.provider.PrivilegedUriProvider;
import com.obric.capabilitykit.entity.app.PhotoEntity;
import com.obric.capabilitykit.entity.enums.AssetTypeEnum;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u001c\u001dB\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J0\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001aH\u0014R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u001b\u0010\u0010\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u000f\u001a\u0004\b\u0011\u0010\r¨\u0006\u001e"}, d2 = {"Lcom/obric/assistant/card/layout/viewholder/PhotoHorizontalViewHolder;", "Lcom/obric/assistant/card/layout/viewholder/abs/AbsCardItemViewHolder;", "Lcom/obric/assistant/card/layout/bean/wrapper/PhotoEntityHorizontalStyleWrapper;", "Lcom/obric/assistant/card/databinding/ObricCardPhotoHorizontalContainerBinding;", "parent", "Landroid/view/ViewGroup;", "<init>", "(Landroid/view/ViewGroup;)V", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "itemPadding", NameKeys.UnloadStrategy_No_Strategy, "getItemPadding", "()I", "itemPadding$delegate", "Lkotlin/Lazy;", "itemPaddingHead", "getItemPaddingHead", "itemPaddingHead$delegate", "onBind", NameKeys.UnloadStrategy_No_Strategy, "messageExtra", "Lcom/obric/assistant/card/layout/bean/MessageExtraForViewHolder;", "entity", "position", "isDeleted", NameKeys.UnloadStrategy_No_Strategy, "isRefreshed", "MyAdapter", "MyViewHolder", "card_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PhotoHorizontalViewHolder extends AbsCardItemViewHolder<mca.d, ObricCardPhotoHorizontalContainerBinding> {
    public static final /* synthetic */ int m = 0;
    public final RecyclerView j;
    public final Lazy k;
    public final Lazy l;

    public static final class a extends RecyclerView.Adapter<b> {
        public final PhotoHorizontalViewHolder a;
        public final List<PhotoEntity> b;

        public final int getItemCount() {
            return ((ArrayList) this.b).size();
        }

        public a(PhotoHorizontalViewHolder r2) {
            Intrinsics.checkNotNullParameter(r2, "parentViewHolder");
            this.a = r2;
            this.b = new ArrayList();
        }

        public final void onBindViewHolder(RecyclerView.ViewHolder r7, int r8) {
            b r9 = (b) r7;
            Intrinsics.checkNotNullParameter(r9, "holder");
            PhotoEntity r0 = (PhotoEntity) ListProtector.get(this.b, r8);
            int r3 = 0;
            if (r0.getAssetType() != AssetTypeEnum.VIDEO) goto L5;
            boolean r1 = true;
        L6:
            SimpleDraweeView r2 = r9.a.b;
            int r4 = PrivilegedUriProvider.b;
            ImageLoaderKt.s(r2, PrivilegedUriProvider.a.a(r0.getFile().getContentUrl(), r0.getPackageName(), r1, r1), "obric_chat.cards");
            ImageView r5 = r9.a.c;
            if (r1 == true) goto L10;
            r3 = 8;
        L10:
            r5.setVisibility(r3);
            PhotoHorizontalViewHolder r6 = this.a;
            View r10 = ((RecyclerView.ViewHolder) r9).itemView;
            List<PhotoEntity> r11 = this.b;
            int r12 = PhotoHorizontalViewHolder.m;
            r6.W3(r10, r11, r0, r8);
            return;
        L5:
            r1 = false;
            goto L6
        }

        public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r4, int r5) {
            Intrinsics.checkNotNullParameter(r4, "parent");
            View r6 = LayoutInflater.from(r4.getContext()).inflate(2131563974, r4, false);
            int r0 = 2131374931;
            SimpleDraweeView r1 = ViewBindings.findChildViewById(r6, 2131374931);
            if (r1 == null) goto L9;
            r0 = 2131392307;
            ImageView r2 = (ImageView) ViewBindings.findChildViewById(r6, 2131392307);
            if (r2 == null) goto L9;
            return new b(new ObricCardPhotoHorizontalItemBinding((RelativeLayout) r6, r1, r2));
        L9:
            throw new NullPointerException("Missing required view with ID: ".concat(r6.getResources().getResourceName(r0)));
        }
    }

    public static final class b extends RecyclerView.ViewHolder {
        public final ObricCardPhotoHorizontalItemBinding a;

        public b(ObricCardPhotoHorizontalItemBinding r2) {
            Intrinsics.checkNotNullParameter(r2, "viewBinding");
            super(r2.a);
            this.a = r2;
        }
    }

    public PhotoHorizontalViewHolder(ViewGroup r4) {
        Intrinsics.checkNotNullParameter(r4, "parent");
        RecyclerView r5 = LayoutInflater.from(r4.getContext()).inflate(2131563973, r4, false);
        if (r5 == null) goto L7;
        super(new ObricCardPhotoHorizontalContainerBinding(r5), false);
        RecyclerView r6 = ((ObricCardPhotoHorizontalContainerBinding) this.a).a;
        this.j = r6;
        this.k = LazyKt.lazy(new n(this));
        this.l = LazyKt.lazy(new o(this));
        r6.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        r6.addItemDecoration(new AnonymousClass1(this));
        r6.setAdapter(new a(this));
        return;
    L7:
        throw new NullPointerException("rootView");
    }

    @Override // com.obric.assistant.card.layout.viewholder.abs.AbsCardItemViewHolder
    public final void T3(MessageExtraForViewHolder r1, mca.d r2, int r3, boolean r4, boolean r5) {
        mca.d r6 = r2;
        Intrinsics.checkNotNullParameter(r1, "messageExtra");
        Intrinsics.checkNotNullParameter(r6, "entity");
        RecyclerView.Adapter r7 = this.j.getAdapter();
        Intrinsics.checkNotNull(r7, "null cannot be cast to non-null type com.obric.assistant.card.layout.viewholder.PhotoHorizontalViewHolder.MyAdapter");
        a r8 = (a) r7;
        Collection r9 = r6.a;
        r8.getClass();
        Intrinsics.checkNotNullParameter(r9, "photoList");
        ((ArrayList) r8.b).clear();
        ArrayList r10 = (ArrayList) r8.b;
        r10.addAll(r9);
        r8.notifyDataSetChanged();
    }
}
