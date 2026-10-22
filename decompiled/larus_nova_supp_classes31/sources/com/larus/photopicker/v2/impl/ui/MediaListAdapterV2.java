package com.larus.photopicker.v2.impl.ui;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.photopicker.v2.impl.data.model.MediaType;
import com.larus.photopicker.v2.impl.databinding.LarusItemFooterMediaBinding;
import com.larus.photopicker.v2.impl.databinding.LarusItemHeaderPermissionBinding;
import com.larus.photopicker.v2.impl.databinding.LarusItemMediaBinding;
import com.larus.photopicker.v2.impl.e0;
import com.larus.photopicker.v2.impl.j2;
import com.larus.photopicker.v2.impl.model.MediaTab;
import com.larus.photopicker.v2.impl.model.MediaViewType;
import com.larus.utils.m0;
import com.tencent.open.log.TraceLevel;
import com.tencent.open.miniapp.MiniApp;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import op9.d;
import op9.e;
import up9.q;
import v19.c;
import v19.i5;
import vp9.f;
import vp9.j;
import vp9.m;
import vp9.u;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u008d\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r*\u0001#\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001BQ\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u001e\u0010\f\u001a\u001a\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000b0\r¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010%\u001a\u00020\u000b2\u0006\u0010&\u001a\u00020'H\u0016J\u0010\u0010(\u001a\u00020\u000b2\u0006\u0010&\u001a\u00020'H\u0016J\u0006\u0010)\u001a\u00020\u000bJ\u0010\u0010*\u001a\u00020\u00072\u0006\u0010+\u001a\u00020\u0007H\u0016J\u0018\u0010,\u001a\u00020\u00032\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020\u0007H\u0016J&\u00100\u001a\u00020\u000b2\u0006\u00101\u001a\u00020\u00032\u0006\u0010+\u001a\u00020\u00072\f\u00102\u001a\b\u0012\u0004\u0012\u00020403H\u0016J\u0018\u00100\u001a\u00020\u000b2\u0006\u00101\u001a\u00020\u00032\u0006\u0010+\u001a\u00020\u0007H\u0016J\b\u00105\u001a\u00020\u0007H\u0016J\u000e\u00106\u001a\b\u0012\u0004\u0012\u00020\u000207H\u0002J\u0010\u00108\u001a\u00020\u00072\u0006\u0010+\u001a\u00020\u0007H\u0002J\u000e\u00109\u001a\u00020\u00072\u0006\u0010+\u001a\u00020\u0007J\u000e\u0010:\u001a\u00020\u00072\u0006\u0010;\u001a\u00020<J\u001e\u0010=\u001a\u00020\u000b2\u000e\u0010>\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u0001072\u0006\u0010?\u001a\u00020@J\u000e\u0010A\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u0016J\u000e\u0010B\u001a\u00020\u00162\u0006\u0010C\u001a\u00020\u0016J\u000e\u0010D\u001a\u00020\u000b2\u0006\u0010E\u001a\u00020\u0007J\u000e\u0010F\u001a\u00020\u000b2\u0006\u0010G\u001a\u00020\u0007J\u0010\u0010H\u001a\u00020\u000b2\b\b\u0001\u0010/\u001a\u00020\u0007J\u000e\u0010I\u001a\u00020\u000b2\u0006\u0010J\u001a\u00020\u0016J\u000e\u0010K\u001a\u00020\u000b2\u0006\u0010L\u001a\u00020\u001bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u000e¢\u0006\u0002\n\u0000R&\u0010\f\u001a\u001a\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000b0\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082D¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u001c\u001a\u00020\u00028BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b\u001d\u0010\u001eR\u000e\u0010!\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u00020#X\u0082\u0004¢\u0006\u0004\n\u0002\u0010$¨\u0006M"}, d2 = {"Lcom/larus/photopicker/v2/impl/ui/MediaListAdapterV2;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/larus/photopicker/v2/impl/model/UIMediaItem;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "context", "Landroid/content/Context;", "spanCount", "", "scrollThreshold", "loadMoreCallback", "Lkotlin/Function0;", "", "onItemClick", "Lkotlin/Function3;", "Lcom/larus/photopicker/v2/impl/ui/ClickType;", "<init>", "(Landroid/content/Context;IILkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function3;)V", "TAG", "", "resizeOption", "Lcom/facebook/imagepipeline/common/ResizeOptions;", "addPartImageEnable", "", "headerDataSize", "footerDataSize", "footerData", "curMediaListState", "Lcom/larus/photopicker/v2/impl/ui/MediaListStateData;", "headerData", "getHeaderData", "()Lcom/larus/photopicker/v2/impl/model/UIMediaItem;", "headerData$delegate", "Lkotlin/Lazy;", "lastItemCount", "scrollListener", "com/larus/photopicker/v2/impl/ui/MediaListAdapterV2$scrollListener$1", "Lcom/larus/photopicker/v2/impl/ui/MediaListAdapterV2$scrollListener$1;", "onAttachedToRecyclerView", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "onDetachedFromRecyclerView", MiniApp.MINIAPP_VERSION_RELEASE, "getItemViewType", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "payloads", "", "", "getItemCount", "getAllData", "", "getDataPosition", "getDataRealPosition", "findDataPositionByUri", "uri", "Landroid/net/Uri;", "submitListOuter", "list", "curMediaTab", "Lcom/larus/photopicker/v2/impl/model/MediaTab;", "isAddPartImageEnable", "headerVisibleOrGone", "visible", "footerVisibleOrGone", "height", "updateCornerRadius", "spacing", "updateSelectView", "updateSelectable", "selectable", "setCurMediaListState", "state", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class MediaListAdapterV2 extends ListAdapter<d, RecyclerView.ViewHolder> {
    public final int a;
    public final int b;
    public Function0<Unit> c;
    public Function3<? super d, ? super Integer, ? super ClickType, Unit> d;
    public final String e;
    public final ResizeOptions f;
    public boolean g;
    public int h;
    public int i;
    public int j;
    public m k;
    public final Lazy l;
    public int m;
    public final MediaListAdapterV2$scrollListener$1 n;

    public final int getItemCount() {
        return getCurrentList().size() + this.i;
    }

    public final boolean A2(boolean r4) {
        if (this.g == true) goto L5;
        return false;
    L5:
        int r0 = this.h;
        if (r0 != 1) goto L8;
        if (r4 == false) goto L8;
    L10:
        return false;
    L8:
        if (r0 != 0) goto L11;
        if (r4 == false) goto L10;
    L11:
        if (r4 == false) goto L13;
        this.h = 1;
        List r5 = CollectionsKt.toMutableList(getCurrentList());
        ListProtector.add(r5, 0, (d) this.l.getValue());
        submitList(r5);
    L14:
        return true;
    L13:
        this.h = 0;
        List r6 = CollectionsKt.toMutableList(getCurrentList());
        r6.remove((d) this.l.getValue());
        submitList(r6);
        goto L14
    }

    public final void C2(@ViewHolderSelectViewType int r4) {
        int r0 = e0.a;
        e0.d(this.e, "updateSelectView: " + r4);
        m r1 = this.k;
        if (r4 == r1.d) goto L6;
        r1.d = r4;
        notifyItemRangeChanged(0, getItemCount(), new f("selectViewVisible"));
        return;
    }

    public final void D2(boolean r4) {
        int r0 = e0.a;
        e0.d(this.e, "updateSelectable: " + r4);
        m r1 = this.k;
        if (r4 == r1.c) goto L6;
        r1.c = r4;
        notifyItemRangeChanged(0, getItemCount());
        return;
    }

    public final int getItemViewType(int r3) {
        if (r3 >= getCurrentList().size()) goto L5;
    L8:
        List r0 = getCurrentList();
        if (r3 < 0) goto L16;
        if (r3 >= r0.size()) goto L16;
        return ((d) ListProtector.get(r0, r3)).d.getType();
    L16:
        return super/*androidx.recyclerview.widget.RecyclerView.Adapter*/.getItemViewType(r3);
    L5:
        if (r3 >= getItemCount()) goto L8;
        return MediaViewType.FOOTER.getType();
    }

    public final void onAttachedToRecyclerView(RecyclerView r2) {
        Intrinsics.checkNotNullParameter(r2, "recyclerView");
        super/*androidx.recyclerview.widget.RecyclerView.Adapter*/.onAttachedToRecyclerView(r2);
        r2.addOnScrollListener(this.n);
    }

    public final void onDetachedFromRecyclerView(RecyclerView r2) {
        Intrinsics.checkNotNullParameter(r2, "recyclerView");
        super/*androidx.recyclerview.widget.RecyclerView.Adapter*/.onDetachedFromRecyclerView(r2);
        r2.removeOnScrollListener(this.n);
    }

    public final void y2(int r2) {
        this.j = r2;
        if (r2 <= 0) goto L5;
        this.i = this.a;
        notifyItemInserted(getItemCount());
        return;
    L5:
        if (r2 != 0) goto L9;
        notifyItemRangeRemoved(getCurrentList().size(), this.i);
        this.i = 0;
        return;
    }

    public final int z2(int r2) {
        return RangesKt.coerceAtMost(r2 + this.h, getItemCount() - 1);
    }

    public final void B2(List<d> r4, MediaTab r5) {
        Intrinsics.checkNotNullParameter(r5, "curMediaTab");
        int r0 = e0.a;
        String r1 = this.e;
        StringBuilder r2 = new StringBuilder("[");
        r2.append(r5);
        r2.append("] submitListOuter，list=");
        if (r4 == null) goto L5;
        Integer r6 = Integer.valueOf(r4.size());
    L6:
        r2.append(r6);
        e0.d(r1, r2.toString());
        if (this.h <= 0) goto L12;
        if (r4 == null) goto L14;
        List r7 = CollectionsKt.toMutableList(r4);
        if (r7 == null) goto L15;
        ListProtector.add(r7, 0, (d) this.l.getValue());
        super.submitList(r7);
        return;
    L15:
        return;
    L14:
        return;
    L12:
        super.submitList(r4);
        return;
    L5:
        r6 = null;
        goto L6
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r8, int r9) {
        Intrinsics.checkNotNullParameter(r8, "holder");
        if ((r8 instanceof MediaViewHolder) == false) goto L10;
        final d r0 = (d) getItem(r9);
        final int r10 = RangesKt.coerceAtLeast(r9 - this.h, 0);
        final MediaViewHolder r11 = (MediaViewHolder) r8;
        Intrinsics.checkNotNull(r0);
        m r2 = this.k;
        r11.getClass();
        Intrinsics.checkNotNullParameter(r0, "mediaItem");
        Intrinsics.checkNotNullParameter(r2, "mediaListState");
        r11.e = r0;
        r11.f = r10;
        final Uri r3 = r0.a.b;
        GenericDraweeHierarchy r4 = r11.a.b.getHierarchy();
        r4.setPlaceholderImage(2131243521);
        r4.setActualImageScaleType(ScalingUtils.ScaleType.CENTER_CROP);
        r4.setFadeDuration(10);
        ImageLoaderKt.y(r11.a.b, r3.toString(), "photo_picker_v2_MediaViewHolder", new u(r11, r3, r0, r10), 4);
        if (r0.a.getType() != MediaType.VIDEO) goto L7;
        r11.a.f.setVisibility(0);
        r11.a.f.setText(e.a(r0));
    L8:
        r11.U3(r0, r2);
        r11.V3(r2);
        r11.T3(r0, r2);
        r11.W3(r0, r0.b);
        return;
    L7:
        r11.a.f.setVisibility(8);
        goto L8
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r9, int r10) {
        Intrinsics.checkNotNullParameter(r9, "parent");
        if (r10 != MediaViewType.HEADER.getType()) goto L11;
        View r11 = LayoutInflater.from(r9.getContext()).inflate(2131562576, r9, false);
        if (r11 == null) goto L9;
        return new HeaderMediaDataViewHolder(new LarusItemHeaderPermissionBinding((AspectRatioFrameLayout) r11), this.d);
    L9:
        throw new NullPointerException("rootView");
    L11:
        if (r10 != MediaViewType.FOOTER.getType()) goto L18;
        View r12 = LayoutInflater.from(r9.getContext()).inflate(2131562571, r9, false);
        if (r12 == null) goto L17;
        return new FooterMediaDataViewHolder(new LarusItemFooterMediaBinding(r12));
    L17:
        throw new NullPointerException("rootView");
    L18:
        View r13 = LayoutInflater.from(r9.getContext()).inflate(2131562586, r9, false);
        int r14 = 2131379787;
        SimpleDraweeView r3 = ViewBindings.findChildViewById(r13, 2131379787);
        if (r3 == null) goto L31;
        r14 = 2131379791;
        AppCompatTextView r4 = ViewBindings.findChildViewById(r13, 2131379791);
        if (r4 == null) goto L31;
        r14 = 2131379792;
        FrameLayout r5 = (FrameLayout) ViewBindings.findChildViewById(r13, 2131379792);
        if (r5 == null) goto L31;
        r14 = 2131379793;
        View r6 = ViewBindings.findChildViewById(r13, 2131379793);
        if (r6 == null) goto L31;
        r14 = 2131379794;
        AppCompatTextView r7 = ViewBindings.findChildViewById(r13, 2131379794);
        if (r7 == null) goto L31;
        return new MediaViewHolder(new LarusItemMediaBinding((AspectRatioFrameLayout) r13, r3, r4, r5, r6, r7), this.f, this.d);
    L31:
        throw new NullPointerException("Missing required view with ID: ".concat(r13.getResources().getResourceName(r14)));
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r3, int r4, List<Object> r5) {
        Intrinsics.checkNotNullParameter(r3, "holder");
        Intrinsics.checkNotNullParameter(r5, "payloads");
        r5.size();
        if ((r3 instanceof HeaderMediaDataViewHolder) == false) goto L6;
        ((HeaderMediaDataViewHolder) r3).getClass();
        return;
    L6:
        if ((r3 instanceof FooterMediaDataViewHolder) == false) goto L15;
        FooterMediaDataViewHolder r6 = (FooterMediaDataViewHolder) r3;
        int r7 = this.j;
        boolean r1 = true;
        if (r4 == (getItemCount() - 1)) goto L11;
        r1 = false;
    L11:
        if (r1 == false) goto L13;
        ViewGroup.LayoutParams r8 = r6.a.a.getLayoutParams();
        r8.height = r7;
        r6.a.a.setLayoutParams(r8);
        return;
    L13:
        r6.getClass();
        return;
    L15:
        if ((r3 instanceof MediaViewHolder) == false) goto L27;
        Object r9 = CollectionsKt.lastOrNull(r5);
        if ((r9 instanceof f) == false) goto L20;
        ((MediaViewHolder) r3).V3(this.k);
        return;
    L20:
        if ((r9 instanceof vp9.e) == true) goto L22;
        onBindViewHolder(r3, r4);
        return;
    L22:
        ((vp9.e) r9).getClass();
        ((MediaViewHolder) r3).U3(null, this.k);
        throw null;
    }

    /* JADX WARN: Type inference failed for: r3v5, types: [com.larus.photopicker.v2.impl.ui.MediaListAdapterV2$scrollListener$1] */
    public MediaListAdapterV2(Context r3, int r4, int r5, j2 r6, q r7) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r6, "loadMoreCallback");
        Intrinsics.checkNotNullParameter(r7, "onItemClick");
        super(new MediaDiffCallback());
        this.a = r4;
        this.b = r5;
        this.c = r6;
        this.d = r7;
        this.e = "MediaListAdapterV2";
        Intrinsics.checkNotNullParameter(r3, "context");
        this.f = ResizeOptions.forSquareSize(m0.b(r3) / r4);
        RoundingParams r8 = RoundingParams.fromCornersRadius(i5.h());
        r8.setBorder(ContextCompat.getColor(r3, c.b(2130972086, r3, 2131103159)), i5.b());
        this.k = new m(r8, -1, 0, false);
        this.l = LazyKt.lazy(new j());
        this.n = new MediaListAdapterV2$scrollListener$1(this);
    }
}
