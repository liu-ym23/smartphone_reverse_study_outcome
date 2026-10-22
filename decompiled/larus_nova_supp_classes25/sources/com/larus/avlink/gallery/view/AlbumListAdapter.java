package com.larus.avlink.gallery.view;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.avlink.gallery.AlbumUtils;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.dora.VideoThumbnailHelper;
import com.larus.bmhome.chat.plugin.image4.view.ImageViewWithLastMotion;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 12\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u00011B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0006\u0010\f\u001a\u00020\rJ$\u0010\u000e\u001a\u00020\u000f2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\u000b2\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0011J\u0006\u0010\u0012\u001a\u00020\u000fJ \u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\r2\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0011J&\u0010\u0015\u001a\u00020\u000f2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u000b2\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0011J\"\u0010\u0018\u001a\u00020\u000f2\b\u0010\u0019\u001a\u0004\u0018\u00010\u00022\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0011J*\u0010\u001a\u001a\u00020\u000f2\b\u0010\u001b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0014\u001a\u00020\r2\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0011J(\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u00172\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0011J\u000e\u0010\u001f\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020!J(\u0010\"\u001a\u00020\u000f2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\u000b2\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0011H\u0002J\u000e\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00020$H\u0002J\u0018\u0010%\u001a\u00020\u000f2\u0006\u0010&\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\rH\u0016J\u0018\u0010'\u001a\u00020\u00032\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\rH\u0016J6\u0010+\u001a\u00020\u000f2\u0012\u0010,\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020!0-2\b\u0010.\u001a\u0004\u0018\u00010\u00022\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0011J\u0010\u0010/\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\rH\u0016J\u0010\u00100\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\rH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00062"}, d2 = {"Lcom/larus/avlink/gallery/view/AlbumListAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/larus/bmhome/bigimg/MediaItem;", "Lcom/larus/avlink/gallery/view/AlbumViewHolder;", "lifecycleScope", "Landroidx/lifecycle/LifecycleCoroutineScope;", "callback", "Lcom/larus/avlink/gallery/view/AlbumListHolderCallback;", "<init>", "(Landroidx/lifecycle/LifecycleCoroutineScope;Lcom/larus/avlink/gallery/view/AlbumListHolderCallback;)V", "data", "", "itemCount", "", "setData", "", "onSubmitted", "Lkotlin/Function0;", "clear", "removeItem", "position", "deleteItemsByUrls", "urls", "", "insert", "file", "updateItem", "item", "renameItem", "preName", "newName", "setSelectMode", "isSelectMode", "", "submitData", "getDeepCopyData", "", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "replaceItemWhere", "predicate", "Lkotlin/Function1;", "replacement", "getItem", "getItemViewType", "Companion", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class AlbumListAdapter extends ListAdapter<com.larus.bmhome.bigimg.t1, AlbumViewHolder> {
    public static final AlbumListAdapter$Companion$DIFF_CALLBACK$1 d = null;
    public final LifecycleCoroutineScope a;
    public final f b;
    public List<? extends com.larus.bmhome.bigimg.t1> c;

    public static final class a {
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.larus.avlink.gallery.view.AlbumListAdapter$Companion$DIFF_CALLBACK$1] */
    static {
        d = new AlbumListAdapter$Companion$DIFF_CALLBACK$1();
    }

    public final List<com.larus.bmhome.bigimg.t1> y2() {
        ArrayList r0 = new ArrayList();
        Iterator<T> r1 = this.c.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r0.add(com.larus.bmhome.bigimg.t1.a.a((com.larus.bmhome.bigimg.t1) r1.next(), null, false, false, 1023));
        goto L4
    L6:
        return r0;
    }

    public final /* bridge */ /* synthetic */ Object getItem(int r1) {
        return z2(r1);
    }

    public final int getItemViewType(int r1) {
        return z2(r1).getMediaType();
    }

    public final com.larus.bmhome.bigimg.t1 z2(int r1) {
        return (com.larus.bmhome.bigimg.t1) super.getItem(r1);
    }

    public AlbumListAdapter(LifecycleCoroutineScope r2, MineAlbumFragment.e r3) {
        Intrinsics.checkNotNullParameter(r2, "lifecycleScope");
        Intrinsics.checkNotNullParameter(r3, "callback");
        super(d);
        this.a = r2;
        this.b = r3;
        this.c = CollectionsKt.emptyList();
    }

    public final void insert(com.larus.bmhome.bigimg.t1 r5, Function0<Unit> r6) {
        if (r5 != null) goto L4;
        return;
    L4:
        List<com.larus.bmhome.bigimg.t1> r0 = y2();
        ListProtector.add(r0, 0, com.larus.bmhome.bigimg.t1.a.a(r5, null, false, false, 1023));
        this.c = r0;
        submitList(r0, new e(r6));
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r14, int r15) {
        AlbumViewHolder r16 = (AlbumViewHolder) r14;
        Intrinsics.checkNotNullParameter(r16, "holder");
        final yt8.p r17 = z2(r15);
        if ((r16 instanceof AlbumVideoItemHolder) == false) goto L51;
        final AlbumVideoItemHolder r18 = (AlbumVideoItemHolder) r16;
        r18.getClass();
        Intrinsics.checkNotNullParameter(r17, "item");
        FLogger r0 = FLogger.a;
        r0.i("AlbumVideoItemHolder", "bindData, item=" + r17 + ", absoluteAdapterPosition = " + r18.getAbsoluteAdapterPosition());
        if ((r17 instanceof yt8.p) == false) goto L7;
        yt8.p r3 = r17;
    L8:
        if (r3 == null) goto L11;
        String r4 = r3.d;
        if (r4 == null) goto L11;
    L12:
        int r6 = VideoThumbnailHelper.a;
        Context r7 = ((RecyclerView.ViewHolder) r18).itemView.getContext();
        Intrinsics.checkNotNullParameter(r7, "context");
        Intrinsics.checkNotNullParameter(r4, "mediaID");
        PolarisFileWrapper r8 = new PolarisFileWrapper(r7.getCacheDir(), "video_thumb_" + r4.hashCode() + ".jpg");
        if (r8.exists() == false) goto L15;
        String r9 = r8.getAbsolutePath();
    L17:
        if (r9 == null) goto L21;
        r0.i("AlbumVideoItemHolder", "Using cached thumbnail for mediaID: " + r4 + ", path: " + r9);
        ImageViewWithLastMotion r10 = r18.c;
        if (r10 == null) goto L23;
        ImageLoaderKt.x(r10, Uri.fromFile(new PolarisFileWrapper(r9)), null, null, new t(), 6);
    L23:
        if (r17.d() == false) goto L27;
        com.larus.utils.e1.x(r18.f);
        com.larus.utils.e1.x(r18.g);
        View r1 = r18.d;
        if (r1 == null) goto L43;
        com.larus.utils.e1.o(r1);
    L43:
        TextView r2 = r18.e;
        if (r2 == null) goto L46;
        int r5 = AlbumUtils.a;
        r2.setText(AlbumUtils.d((long) (r17.k / ((double) 1000))));
    L46:
        TextView r11 = r18.e;
        if (r11 == null) goto L49;
        com.larus.utils.e1.x(r11);
    L49:
        ((RecyclerView.ViewHolder) r18).itemView.setOnTouchListener(new u(r18));
        com.larus.utils.e1.d(((RecyclerView.ViewHolder) r18).itemView, new v(r18, r17));
        ((RecyclerView.ViewHolder) r18).itemView.setOnLongClickListener(new w(r18, r17));
        return;
    L27:
        com.larus.utils.e1.o(r18.f);
        com.larus.utils.e1.o(r18.g);
        if (r17.b() == false) goto L40;
        View r12 = r18.d;
        if (r12 == null) goto L33;
        com.larus.utils.e1.x(r12);
    L33:
        if (r17.isSelected() == false) goto L37;
        View r13 = r18.d;
        if (r13 == null) goto L43;
        r13.setBackgroundResource(2131240819);
        goto L43
    L37:
        View r19 = r18.d;
        if (r19 == null) goto L43;
        r19.setBackgroundResource(2131240820);
        goto L43
    L40:
        View r20 = r18.d;
        if (r20 == null) goto L43;
        com.larus.utils.e1.o(r20);
        goto L43
    L21:
        r0.i("AlbumVideoItemHolder", "No cached thumbnail, generating for mediaID: " + r4 + ", path: " + r17.getPath());
        BuildersKt.launch$default(r18.b, Dispatchers.getIO(), null, new AlbumVideoItemHolder$bindData$1(r18, r4, r17, null), 2, null);
        goto L23
    L15:
        r9 = null;
    L11:
        r4 = r17.getPath();
        goto L12
    L7:
        r3 = null;
        goto L8
    L51:
        if ((r16 instanceof AlbumImageViewHolder) == false) goto L80;
        final AlbumImageViewHolder r110 = (AlbumImageViewHolder) r16;
        r110.getClass();
        Intrinsics.checkNotNullParameter(r17, "item");
        PolarisFileWrapper r21 = new PolarisFileWrapper(r17.getPath());
        if (r21.exists() == true) goto L55;
        FLogger.a.e("AlbumViewHolder", "bindData, File not found, item=" + r17);
    L56:
        ImageLoaderKt.x(r110.b, UriProtector.parse("file://" + r17.getPath()), null, null, new com.larus.avlink.gallery.view.a(r17), 6);
        if (r17.d() == false) goto L61;
        com.larus.utils.e1.x(r110.d);
        com.larus.utils.e1.x(r110.e);
        View r22 = r110.c;
        if (r22 == null) goto L77;
        com.larus.utils.e1.o(r22);
    L77:
        ((RecyclerView.ViewHolder) r110).itemView.setOnTouchListener(new b(r110));
        com.larus.utils.e1.d(((RecyclerView.ViewHolder) r110).itemView, new c(r110, r17));
        ((RecyclerView.ViewHolder) r110).itemView.setOnLongClickListener(new d(r110, r17));
        return;
    L61:
        com.larus.utils.e1.o(r110.d);
        com.larus.utils.e1.o(r110.e);
        if (r17.b() == false) goto L74;
        View r23 = r110.c;
        if (r23 == null) goto L67;
        com.larus.utils.e1.x(r23);
    L67:
        if (r17.isSelected() == false) goto L71;
        View r24 = r110.c;
        if (r24 == null) goto L77;
        r24.setBackgroundResource(2131240819);
        goto L77
    L71:
        View r25 = r110.c;
        if (r25 == null) goto L77;
        r25.setBackgroundResource(2131240820);
        goto L77
    L74:
        View r26 = r110.c;
        if (r26 == null) goto L77;
        com.larus.utils.e1.o(r26);
        goto L77
    L55:
        FLogger.a.i("AlbumViewHolder", "bindData, File found, item=" + r17 + ", size=" + r21.length());
        goto L56
    L80:
        throw new IllegalArgumentException("Unknown ViewHolder type: ".concat(r16.getClass().getSimpleName()));
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "parent");
        ConstraintLayout r6 = LayoutInflater.from(r4.getContext()).inflate(2131562490, r4, false);
        int r0 = 2131362467;
        if (((ProgressBar) ViewBindings.findChildViewById(r6, 2131362467)) == null) goto L22;
        r0 = 2131362468;
        if (ViewBindings.findChildViewById(r6, 2131362468) == null) goto L22;
        r0 = 2131370393;
        if (((TextView) ViewBindings.findChildViewById(r6, 2131370393)) == null) goto L22;
        r0 = 2131373413;
        if (ViewBindings.findChildViewById(r6, 2131373413) == null) goto L22;
        r0 = 2131374931;
        if (((ImageViewWithLastMotion) ViewBindings.findChildViewById(r6, 2131374931)) == null) goto L22;
        ConstraintLayout r7 = r6;
        if (r5 == 1) goto L20;
        if (r5 != 2) goto L18;
        return new AlbumVideoItemHolder(r7, this.b, this.a);
    L18:
        throw new IllegalArgumentException("Unknown view type: " + r5);
    L20:
        return new AlbumImageViewHolder(r7, this.b, this.a);
    L22:
        throw new NullPointerException("Missing required view with ID: ".concat(r6.getResources().getResourceName(r0)));
    }
}
