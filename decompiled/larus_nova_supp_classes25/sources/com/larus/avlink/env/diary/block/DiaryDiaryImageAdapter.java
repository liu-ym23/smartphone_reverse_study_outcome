package com.larus.avlink.env.diary.block;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.im.bean.message.block.DoraImage;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.utils.s0;
import h98.m;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000 \u001e2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0003\u001e\u001f B\u0011\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0014\u0010\u0015\u001a\u00020\u00102\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000b0\nJ\u0018\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u000eH\u0016J\u0018\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u000eH\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\bR\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u000e¢\u0006\u0002\n\u0000R:\u0010\f\u001a\"\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006!"}, d2 = {"Lcom/larus/avlink/env/diary/block/DiaryDiaryImageAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/larus/avlink/env/diary/block/DoraImageUIModel;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "isStyleV2", "", "<init>", "(Z)V", "()Z", "originalImages", "", "Lcom/larus/im/bean/message/block/DoraImage;", "onImageClick", "Lkotlin/Function3;", "", "Landroid/view/View;", "", "getOnImageClick", "()Lkotlin/jvm/functions/Function3;", "setOnImageClick", "(Lkotlin/jvm/functions/Function3;)V", "setData", "images", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "position", "Companion", "ScrollImageViewHolder", "RotateImageViewHolder", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class DiaryDiaryImageAdapter extends ListAdapter<m, RecyclerView.ViewHolder> {
    public static final DiaryDiaryImageAdapter$Companion$DIFF_CALLBACK$1 d = null;
    public final boolean a;
    public List<DoraImage> b;
    public Function3<? super Integer, ? super View, ? super List<DoraImage>, Unit> c;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eR\u0016\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\u00070\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n \b*\u0004\u0018\u00010\n0\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/larus/avlink/env/diary/block/DiaryDiaryImageAdapter$RotateImageViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "image", "Lcom/facebook/drawee/view/SimpleDraweeView;", "kotlin.jvm.PlatformType", "imageCount", "Landroid/widget/TextView;", "bindData", "", "data", "Lcom/larus/avlink/env/diary/block/DoraImageUIModel;", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    public static final class RotateImageViewHolder extends RecyclerView.ViewHolder {
        public final SimpleDraweeView a;
        public final TextView b;

        public RotateImageViewHolder(View r2) {
            Intrinsics.checkNotNullParameter(r2, "view");
            super(r2);
            this.a = r2.findViewById(2131369047);
            this.b = (TextView) r2.findViewById(2131369048);
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fR\u0016\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\u00070\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/larus/avlink/env/diary/block/DiaryDiaryImageAdapter$ScrollImageViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "image", "Lcom/facebook/drawee/view/SimpleDraweeView;", "kotlin.jvm.PlatformType", "bindData", "", "data", "Lcom/larus/avlink/env/diary/block/DoraImageUIModel;", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    public static final class ScrollImageViewHolder extends RecyclerView.ViewHolder {
        public final SimpleDraweeView a;

        public ScrollImageViewHolder(View r2) {
            Intrinsics.checkNotNullParameter(r2, "view");
            super(r2);
            this.a = r2.findViewById(2131369049);
        }
    }

    public static final class a {
    }

    public DiaryDiaryImageAdapter() {
        this(false);
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.larus.avlink.env.diary.block.DiaryDiaryImageAdapter$Companion$DIFF_CALLBACK$1] */
    static {
        d = new DiaryDiaryImageAdapter$Companion$DIFF_CALLBACK$1();
    }

    public DiaryDiaryImageAdapter(boolean r2) {
        super(d);
        this.a = r2;
        this.b = CollectionsKt.emptyList();
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r4, final int r5) {
        Intrinsics.checkNotNullParameter(r4, "holder");
        m r0 = (m) getItem(r5);
        r4.itemView.setOnClickListener(new h98.a(this, r5));
        if ((r4 instanceof ScrollImageViewHolder) == false) goto L9;
        ScrollImageViewHolder r6 = (ScrollImageViewHolder) r4;
        if (r0 == null) goto L9;
        ImageLoaderKt.u(r6.a, r0.a, "diary_detail");
    L9:
        if ((r4 instanceof RotateImageViewHolder) == false) goto L18;
        RotateImageViewHolder r7 = (RotateImageViewHolder) r4;
        if (r0 == null) goto L20;
        ImageLoaderKt.u(r7.a, r0.a, "diary_detail");
        ((RecyclerView.ViewHolder) r7).itemView.setRotation(r0.c);
        if (r0.d <= 0) goto L16;
        s0.b(r7.b, "+" + r0.d);
        return;
    L16:
        r7.b.setVisibility(8);
        return;
    L20:
        return;
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "parent");
        if (this.a == false) goto L6;
        View r5 = LayoutInflater.from(r3.getContext()).inflate(2131562545, r3, false);
        Intrinsics.checkNotNull(r5);
        return new RotateImageViewHolder(r5);
    L6:
        View r6 = LayoutInflater.from(r3.getContext()).inflate(2131562544, r3, false);
        Intrinsics.checkNotNull(r6);
        return new ScrollImageViewHolder(r6);
    }
}
