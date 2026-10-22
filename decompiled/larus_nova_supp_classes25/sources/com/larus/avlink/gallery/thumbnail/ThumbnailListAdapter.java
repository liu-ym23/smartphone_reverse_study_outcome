package com.larus.avlink.gallery.thumbnail;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.bytedance.mt.protector.impl.UriProtector;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.avlink.gallery.model.ThumbnailMetadata;
import com.larus.avlink.impl.databinding.LarusItemThumbnailBinding;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0010\"\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0007\u0018\u0000 \u001e2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u001eB\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0014\u0010\u000f\u001a\u00020\u00102\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\tJ\u0014\u0010\u0011\u001a\u00020\u00102\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\f0\u000bJ\u0018\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0018\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u0017H\u0016J&\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u00172\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/larus/avlink/gallery/thumbnail/ThumbnailListAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/larus/avlink/gallery/model/ThumbnailMetadata;", "Lcom/larus/avlink/gallery/thumbnail/ThumbnailViewHolder;", "callback", "Lcom/larus/avlink/gallery/thumbnail/ThumbnailItemCallback;", "<init>", "(Lcom/larus/avlink/gallery/thumbnail/ThumbnailItemCallback;)V", "data", "", "selectedItems", "", "", "isSelectionMode", "", "setData", "", "setSelectedItems", "selected", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "holder", "position", "payloads", "", "", "Companion", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class ThumbnailListAdapter extends ListAdapter<ThumbnailMetadata, ThumbnailViewHolder> {
    public static final ThumbnailListAdapter$Companion$DIFF_CALLBACK$1 d = null;
    public final i0 a;
    public List<ThumbnailMetadata> b;
    public Set<Long> c;

    public static final class a {
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.larus.avlink.gallery.thumbnail.ThumbnailListAdapter$Companion$DIFF_CALLBACK$1] */
    static {
        d = new ThumbnailListAdapter$Companion$DIFF_CALLBACK$1();
    }

    public ThumbnailListAdapter(c0 r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        super(d);
        this.a = r2;
        this.b = CollectionsKt.emptyList();
        this.c = SetsKt.emptySet();
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r18, int r19) {
        final ThumbnailViewHolder r2 = (ThumbnailViewHolder) r18;
        Intrinsics.checkNotNullParameter(r2, "holder");
        final ThumbnailMetadata r3 = (ThumbnailMetadata) getItem(r19);
        boolean r4 = this.c.contains(Long.valueOf(r3.getImageUuid()));
        FLogger.a.d("ThumbnailListAdapter", "onBindViewHolder: position=" + r19 + ", imageUuid=" + r3.getImageUuid() + ", isSelected=" + r4 + ", isSelectionMode=false");
        Intrinsics.checkNotNull(r3);
        r2.getClass();
        Intrinsics.checkNotNullParameter(r3, "item");
        r2.c = r3.getImageUuid();
        ImageLoaderKt.x(r2.a.c, UriProtector.parse("file://" + r3.getFilePath()), null, null, new r0(r3), 6);
        if (Intrinsics.areEqual(r3.getMediaType(), "video") == true) goto L5;
    L14:
        e1.o(r2.a.d);
    L15:
        r2.T3(r4);
        r2.a.a.setOnClickListener(new s0(r2, r3));
        r2.a.a.setOnLongClickListener(new t0(r2, r3));
        return;
    L5:
        if (r3.getDuration() <= 0) goto L14;
        e1.x(r2.a.d);
        TextView r1 = r2.a.d;
        long r5 = r3.getDuration();
        long r11 = 60;
        long r9 = (r5 / ((long) 1000)) % r11;
        long r13 = (r5 / ((long) 60000)) % r11;
        long r6 = r5 / ((long) 3600000);
        if (r6 <= 0) goto L10;
        StringCompanionObject r7 = StringCompanionObject.INSTANCE;
        String r8 = String.format("%d:%02d:%02d", Arrays.copyOf(new Object[]{Long.valueOf(r6), Long.valueOf(r13), Long.valueOf(r9)}, 3));
    L13:
        r1.setText(r8);
        goto L15
    L10:
        if (r13 <= 0) goto L12;
        StringCompanionObject r10 = StringCompanionObject.INSTANCE;
        r8 = String.format("%d:%02d", Arrays.copyOf(new Object[]{Long.valueOf(r13), Long.valueOf(r9)}, 2));
        goto L13
    L12:
        StringCompanionObject r12 = StringCompanionObject.INSTANCE;
        r8 = String.format("0:%02d", Arrays.copyOf(new Object[]{Long.valueOf(r9)}, 1));
        goto L13
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "parent");
        ConstraintLayout r6 = LayoutInflater.from(r4.getContext()).inflate(2131562694, r4, false);
        int r7 = 2131385831;
        CheckBox r0 = (CheckBox) ViewBindings.findChildViewById(r6, 2131385831);
        if (r0 == null) goto L11;
        r7 = 2131388625;
        SimpleDraweeView r1 = ViewBindings.findChildViewById(r6, 2131388625);
        if (r1 == null) goto L11;
        r7 = 2131392297;
        TextView r2 = (TextView) ViewBindings.findChildViewById(r6, 2131392297);
        if (r2 == null) goto L11;
        return new ThumbnailViewHolder(new LarusItemThumbnailBinding(r6, r0, r1, r2), this.a);
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r6.getResources().getResourceName(r7)));
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r3, int r4, List r5) {
        ThumbnailViewHolder r6 = (ThumbnailViewHolder) r3;
        Intrinsics.checkNotNullParameter(r6, "holder");
        Intrinsics.checkNotNullParameter(r5, "payloads");
        if ((!r5.isEmpty()) == true) goto L5;
    L7:
        super/*androidx.recyclerview.widget.RecyclerView.Adapter*/.onBindViewHolder(r6, r4, r5);
        return;
    L5:
        if (r5.contains("payload_selection_changed") == false) goto L7;
        r6.T3(this.c.contains(Long.valueOf(((ThumbnailMetadata) getItem(r4)).getImageUuid())));
    }
}
