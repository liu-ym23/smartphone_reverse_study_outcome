package com.larus.photopicker.v2.impl.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.photopicker.v2.impl.data.model.MediaType;
import com.larus.photopicker.v2.impl.databinding.LarusItemPreviewBottomSelectorBinding;
import com.larus.photopicker.v2.impl.w0;
import com.tencent.open.log.TraceLevel;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import mp9.c;
import op9.d;
import op9.e;
import v19.c7;
import vp9.n;
import vp9.o;
import wp9.b;
import wp9.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u001e2\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0002\u001e\u001fB'\u0012\u001e\u0010\u0003\u001a\u001a\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0004¢\u0006\u0004\b\t\u0010\nJ\u0014\u0010\u000f\u001a\u00020\b2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\u0011J\u000e\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u0005J\u001c\u0010\u0014\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0006H\u0016J\b\u0010\u0018\u001a\u00020\u0006H\u0016J*\u0010\u0019\u001a\u00020\b2\n\u0010\u001a\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u00062\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\rH\u0016J\u001c\u0010\u0019\u001a\u00020\b2\n\u0010\u001a\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u0006H\u0016R&\u0010\u0003\u001a\u001a\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/larus/photopicker/v2/impl/ui/MediaPreviewBottomSelectorAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/larus/photopicker/v2/impl/ui/MediaPreviewBottomSelectorAdapter$MediaPreviewBottomSelectorViewHolder;", "onItemClick", "Lkotlin/Function3;", "Lcom/larus/photopicker/v2/impl/model/UIMediaItem;", "", "Lcom/larus/photopicker/v2/impl/ui/PreviewBottomSelectorClickType;", "", "<init>", "(Lkotlin/jvm/functions/Function3;)V", "resize", "datas", "", "curSelectedUIMediaItem", "setDatas", "newDatas", "", "updateCurSelected", "uiMediaItem", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "getItemCount", "onBindViewHolder", "holder", "position", "payloads", "", "Companion", "MediaPreviewBottomSelectorViewHolder", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class MediaPreviewBottomSelectorAdapter extends RecyclerView.Adapter<MediaPreviewBottomSelectorViewHolder> {
    public final Function3<d, Integer, PreviewBottomSelectorClickType, Unit> a;
    public final int b;
    public final List<d> c;
    public d d;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0007J\u000e\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/larus/photopicker/v2/impl/ui/MediaPreviewBottomSelectorAdapter$MediaPreviewBottomSelectorViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/larus/photopicker/v2/impl/databinding/LarusItemPreviewBottomSelectorBinding;", "<init>", "(Lcom/larus/photopicker/v2/impl/ui/MediaPreviewBottomSelectorAdapter;Lcom/larus/photopicker/v2/impl/databinding/LarusItemPreviewBottomSelectorBinding;)V", "curData", "Lcom/larus/photopicker/v2/impl/model/UIMediaItem;", "bind", "", "uiMediaItem", "bindPart", "curSelectedUIMediaItem", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    public final class MediaPreviewBottomSelectorViewHolder extends RecyclerView.ViewHolder {
        public static final /* synthetic */ int d = 0;
        public final LarusItemPreviewBottomSelectorBinding a;
        public d b;
        public final /* synthetic */ MediaPreviewBottomSelectorAdapter c;

        public final void T3(d r8) {
            Intrinsics.checkNotNullParameter(r8, "curSelectedUIMediaItem");
            View r0 = this.a.b;
            d r1 = this.b;
            boolean r2 = false;
            if (r1 == null) goto L9;
            c r3 = r1.a;
            if (r3 == null) goto L9;
            if (r8.a.a != r3.a) goto L9;
            r2 = true;
        L9:
            i.c(r0, r2);
        }

        public MediaPreviewBottomSelectorViewHolder(final MediaPreviewBottomSelectorAdapter r3, LarusItemPreviewBottomSelectorBinding r4) {
            Intrinsics.checkNotNullParameter(r4, "binding");
            this.c = r3;
            super(r4.a);
            this.a = r4;
            r4.e.setOnClickListener(new n(this, r3));
            r4.c.setOnClickListener(new o(this, r3));
        }
    }

    public static final class a {
    }

    static {
    }

    public final int getItemCount() {
        return ((ArrayList) this.c).size();
    }

    public MediaPreviewBottomSelectorAdapter(w0 r2) {
        Intrinsics.checkNotNullParameter(r2, "onItemClick");
        this.a = r2;
        this.b = c7.b(64);
        this.c = new ArrayList();
    }

    public final /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder r1, int r2) {
        y2((MediaPreviewBottomSelectorViewHolder) r1, r2);
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "parent");
        return new MediaPreviewBottomSelectorViewHolder(this, LarusItemPreviewBottomSelectorBinding.a(LayoutInflater.from(r2.getContext()), r2));
    }

    public final void y2(MediaPreviewBottomSelectorViewHolder r6, int r7) {
        Intrinsics.checkNotNullParameter(r6, "holder");
        d r8 = (d) ListProtector.get(this.c, r7);
        r6.getClass();
        Intrinsics.checkNotNullParameter(r8, "uiMediaItem");
        r6.b = r8;
        SimpleDraweeView r0 = r6.a.e;
        MediaPreviewBottomSelectorAdapter r1 = r6.c;
        int r2 = b.a;
        b.a(r0, r8.a.b, "photo_picker_v2_MediaPreviewBottomSelectorAdapter", r1.b, r1.b);
        if (r8.a.getType() != MediaType.VIDEO) goto L5;
        r6.a.d.setVisibility(0);
        r6.a.d.setText(e.a(r8));
    L6:
        d r9 = r6.c.d;
        if (r9 == null) goto L10;
        r6.T3(r9);
        return;
    L10:
        return;
    L5:
        r6.a.d.setVisibility(8);
        goto L6
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r2, int r3, List r4) {
        MediaPreviewBottomSelectorViewHolder r5 = (MediaPreviewBottomSelectorViewHolder) r2;
        Intrinsics.checkNotNullParameter(r5, "holder");
        Intrinsics.checkNotNullParameter(r4, "payloads");
        Object r6 = CollectionsKt.lastOrNull(r4);
        if ((r6 instanceof vp9.d) == false) goto L5;
        r5.T3(((vp9.d) r6).a);
        return;
    L5:
        y2(r5, r3);
    }
}
