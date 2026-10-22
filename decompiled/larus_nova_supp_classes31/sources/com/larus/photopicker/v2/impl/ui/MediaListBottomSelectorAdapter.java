package com.larus.photopicker.v2.impl.ui;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.photopicker.v2.impl.data.model.MediaType;
import com.larus.photopicker.v2.impl.databinding.LarusItemPreviewBottomSelectorBinding;
import com.larus.photopicker.v2.impl.w1;
import com.tencent.open.log.TraceLevel;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import op9.d;
import op9.e;
import v19.c7;
import vp9.k;
import vp9.l;
import wp9.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00192\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0002\u0019\u001aB'\u0012\u001e\u0010\u0003\u001a\u001a\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0004¢\u0006\u0004\b\t\u0010\nJ\u0014\u0010\u000e\u001a\u00020\b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\u0010J\u001c\u0010\u0011\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0006H\u0016J\b\u0010\u0015\u001a\u00020\u0006H\u0016J\u001c\u0010\u0016\u001a\u00020\b2\n\u0010\u0017\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u0006H\u0016R&\u0010\u0003\u001a\u001a\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/larus/photopicker/v2/impl/ui/MediaListBottomSelectorAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/larus/photopicker/v2/impl/ui/MediaListBottomSelectorAdapter$MediaListBottomSelectorViewHolder;", "onItemClick", "Lkotlin/Function3;", "Lcom/larus/photopicker/v2/impl/model/UIMediaItem;", "", "Lcom/larus/photopicker/v2/impl/ui/BottomSelectorClickType;", "", "<init>", "(Lkotlin/jvm/functions/Function3;)V", "resize", "datas", "", "setDatas", "newDatas", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "getItemCount", "onBindViewHolder", "holder", "position", "Companion", "MediaListBottomSelectorViewHolder", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class MediaListBottomSelectorAdapter extends RecyclerView.Adapter<MediaListBottomSelectorViewHolder> {
    public final Function3<d, Integer, BottomSelectorClickType, Unit> a;
    public final int b;
    public final List<d> c;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/larus/photopicker/v2/impl/ui/MediaListBottomSelectorAdapter$MediaListBottomSelectorViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/larus/photopicker/v2/impl/databinding/LarusItemPreviewBottomSelectorBinding;", "<init>", "(Lcom/larus/photopicker/v2/impl/ui/MediaListBottomSelectorAdapter;Lcom/larus/photopicker/v2/impl/databinding/LarusItemPreviewBottomSelectorBinding;)V", "curData", "Lcom/larus/photopicker/v2/impl/model/UIMediaItem;", "bind", "", "uiMediaItem", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    public final class MediaListBottomSelectorViewHolder extends RecyclerView.ViewHolder {
        public static final /* synthetic */ int d = 0;
        public final LarusItemPreviewBottomSelectorBinding a;
        public d b;
        public final /* synthetic */ MediaListBottomSelectorAdapter c;

        public MediaListBottomSelectorViewHolder(final MediaListBottomSelectorAdapter r3, LarusItemPreviewBottomSelectorBinding r4) {
            Intrinsics.checkNotNullParameter(r4, "binding");
            this.c = r3;
            super(r4.a);
            this.a = r4;
            r4.e.setOnClickListener(new k(this, r3));
            r4.c.setOnClickListener(new l(this, r3));
        }
    }

    public static final class a {
    }

    static {
    }

    public final int getItemCount() {
        return ((ArrayList) this.c).size();
    }

    public MediaListBottomSelectorAdapter(w1 r2) {
        Intrinsics.checkNotNullParameter(r2, "onItemClick");
        this.a = r2;
        this.b = c7.b(64);
        this.c = new ArrayList();
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r6, int r7) {
        MediaListBottomSelectorViewHolder r8 = (MediaListBottomSelectorViewHolder) r6;
        Intrinsics.checkNotNullParameter(r8, "holder");
        d r9 = (d) ListProtector.get(this.c, r7);
        r8.getClass();
        Intrinsics.checkNotNullParameter(r9, "uiMediaItem");
        r8.b = r9;
        SimpleDraweeView r0 = r8.a.e;
        MediaListBottomSelectorAdapter r1 = r8.c;
        int r2 = b.a;
        b.a(r0, r9.a.b, "photo_picker_v2_MediaListBottomSelectorAdapter", r1.b, r1.b);
        if (r9.a.getType() != MediaType.VIDEO) goto L5;
        r8.a.d.setVisibility(0);
        r8.a.d.setText(e.a(r9));
        return;
    L5:
        r8.a.d.setVisibility(8);
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "parent");
        return new MediaListBottomSelectorViewHolder(this, LarusItemPreviewBottomSelectorBinding.a(LayoutInflater.from(r2.getContext()), r2));
    }
}
