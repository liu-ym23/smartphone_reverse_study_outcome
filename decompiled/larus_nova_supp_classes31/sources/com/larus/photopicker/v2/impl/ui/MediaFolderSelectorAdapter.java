package com.larus.photopicker.v2.impl.ui;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.photopicker.v2.impl.databinding.LarusItemMediaFolderBinding;
import com.larus.photopicker.v2.impl.u1;
import com.tencent.open.log.TraceLevel;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import op9.c;
import v19.c7;
import vp9.g;
import wp9.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u001d2\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0002\u001d\u001eB'\u0012\u001e\u0010\u0003\u001a\u001a\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0004¢\u0006\u0004\b\b\u0010\tJ\u0014\u0010\u000e\u001a\u00020\u00072\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\u0010J\u000e\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0005J\u001c\u0010\u0013\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0006H\u0016J\b\u0010\u0017\u001a\u00020\u0006H\u0016J*\u0010\u0018\u001a\u00020\u00072\n\u0010\u0019\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u00062\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\fH\u0016J\u001c\u0010\u0018\u001a\u00020\u00072\n\u0010\u0019\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u0006H\u0016R&\u0010\u0003\u001a\u001a\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/larus/photopicker/v2/impl/ui/MediaFolderSelectorAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/larus/photopicker/v2/impl/ui/MediaFolderSelectorAdapter$MediaFolderSelectorViewHolder;", "onItemClick", "Lkotlin/Function3;", "Lcom/larus/photopicker/v2/impl/model/UIMediaFolder;", "", "", "<init>", "(Lkotlin/jvm/functions/Function3;)V", "resize", "datas", "", "curSelectedUIMediaFolder", "setDatas", "newDatas", "", "updateCurSelected", "uiMediaFolder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "getItemCount", "onBindViewHolder", "holder", "position", "payloads", "", "Companion", "MediaFolderSelectorViewHolder", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class MediaFolderSelectorAdapter extends RecyclerView.Adapter<MediaFolderSelectorViewHolder> {
    public final Function3<c, Integer, Integer, Unit> a;
    public final int b;
    public final List<c> c;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/larus/photopicker/v2/impl/ui/MediaFolderSelectorAdapter$MediaFolderSelectorViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/larus/photopicker/v2/impl/databinding/LarusItemMediaFolderBinding;", "<init>", "(Lcom/larus/photopicker/v2/impl/ui/MediaFolderSelectorAdapter;Lcom/larus/photopicker/v2/impl/databinding/LarusItemMediaFolderBinding;)V", "curData", "Lcom/larus/photopicker/v2/impl/model/UIMediaFolder;", "bind", "", "uiMediaFolder", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    public final class MediaFolderSelectorViewHolder extends RecyclerView.ViewHolder {
        public static final /* synthetic */ int d = 0;
        public final LarusItemMediaFolderBinding a;
        public c b;
        public final /* synthetic */ MediaFolderSelectorAdapter c;

        public MediaFolderSelectorViewHolder(final MediaFolderSelectorAdapter r2, LarusItemMediaFolderBinding r3) {
            Intrinsics.checkNotNullParameter(r3, "binding");
            this.c = r2;
            super(r3.a);
            this.a = r3;
            r3.a.setOnClickListener(new g(this, r2));
        }
    }

    public static final class a {
    }

    static {
    }

    public final int getItemCount() {
        return ((ArrayList) this.c).size();
    }

    public MediaFolderSelectorAdapter(u1 r2) {
        Intrinsics.checkNotNullParameter(r2, "onItemClick");
        this.a = r2;
        this.b = c7.b(64);
        this.c = new ArrayList();
    }

    public final /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder r1, int r2) {
        y2((MediaFolderSelectorViewHolder) r1, r2);
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r5, int r6) {
        Intrinsics.checkNotNullParameter(r5, "parent");
        View r7 = LayoutInflater.from(r5.getContext()).inflate(2131562587, r5, false);
        int r0 = 2131375764;
        SimpleDraweeView r1 = ViewBindings.findChildViewById(r7, 2131375764);
        if (r1 == null) goto L11;
        r0 = 2131375765;
        TextView r2 = (TextView) ViewBindings.findChildViewById(r7, 2131375765);
        if (r2 == null) goto L11;
        r0 = 2131375766;
        TextView r3 = (TextView) ViewBindings.findChildViewById(r7, 2131375766);
        if (r3 == null) goto L11;
        return new MediaFolderSelectorViewHolder(this, new LarusItemMediaFolderBinding((RelativeLayout) r7, r1, r2, r3));
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r7.getResources().getResourceName(r0)));
    }

    public final void y2(MediaFolderSelectorViewHolder r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "holder");
        c r6 = (c) ListProtector.get(this.c, r5);
        r4.getClass();
        Intrinsics.checkNotNullParameter(r6, "uiMediaFolder");
        r4.b = r6;
        r4.a.c.setText(r6.b.b);
        r4.a.d.setText(String.valueOf(r6.b.d));
        SimpleDraweeView r0 = r4.a.b;
        MediaFolderSelectorAdapter r7 = r4.c;
        Uri r8 = r6.b.c;
        if (r8 == null) goto L6;
        int r1 = b.a;
        b.a(r0, r8, "photo_picker_v2_MediaFolderSelectorAdapter", r7.b, r7.b);
        return;
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r2, int r3, List r4) {
        MediaFolderSelectorViewHolder r5 = (MediaFolderSelectorViewHolder) r2;
        Intrinsics.checkNotNullParameter(r5, "holder");
        Intrinsics.checkNotNullParameter(r4, "payloads");
        CollectionsKt.lastOrNull(r4);
        y2(r5, r3);
    }
}
