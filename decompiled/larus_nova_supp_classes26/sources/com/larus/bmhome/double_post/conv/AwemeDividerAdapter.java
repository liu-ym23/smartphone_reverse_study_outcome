package com.larus.bmhome.double_post.conv;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import androidx.viewbinding.ViewBindings;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.bmhome.databinding.LarusItemAwemeViewMoreBinding;
import com.larus.common_ui.view.AvatarListView;
import com.larus.common_ui.widget.GradientTextView;
import com.larus.im.bean.conversation.IconImage;
import com.larus.im.bean.message.ImageObj;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.utils.e1;
import ic8.n;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u001d\u001eB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0016\u0010\n\u001a\u00020\u000b2\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006J\u000e\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\tJ\u0018\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0016J\u0018\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0011H\u0016J\u001c\u0010\u0016\u001a\u00020\u000b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0007H\u0002J\u0010\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u0002H\u0016J\u0006\u0010\u001b\u001a\u00020\u001cR\u0016\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/larus/bmhome/double_post/conv/AwemeDividerAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/larus/bmhome/double_post/conv/AwemeDividerAdapter$ViewMoreHolder;", "<init>", "()V", "data", "", "Lcom/larus/bmhome/chat/model/api/ConversationData;", "callback", "Lcom/larus/bmhome/double_post/conv/AwemeDividerAdapter$ICallback;", "submitData", "", "setCallback", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "getItemCount", "onBindViewHolder", "holder", "position", "setAvatar", "view", "Lcom/facebook/drawee/view/SimpleDraweeView;", "conv", "onViewAttachedToWindow", "showViewMoreItem", "", "ViewMoreHolder", "ICallback", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AwemeDividerAdapter extends RecyclerView.Adapter<ViewMoreHolder> {
    public List<wh8.a> a;
    public a b;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/larus/bmhome/double_post/conv/AwemeDividerAdapter$ViewMoreHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/larus/bmhome/databinding/LarusItemAwemeViewMoreBinding;", "<init>", "(Lcom/larus/bmhome/databinding/LarusItemAwemeViewMoreBinding;)V", "getBinding", "()Lcom/larus/bmhome/databinding/LarusItemAwemeViewMoreBinding;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ViewMoreHolder extends RecyclerView.ViewHolder {
        public final LarusItemAwemeViewMoreBinding a;

        public ViewMoreHolder(LarusItemAwemeViewMoreBinding r2) {
            Intrinsics.checkNotNullParameter(r2, "binding");
            super(r2.a);
            this.a = r2;
        }
    }

    public interface a {
        void a();
    }

    public final int getItemCount() {
        return 1;
    }

    public AwemeDividerAdapter() {
    }

    public final void onViewAttachedToWindow(RecyclerView.ViewHolder r2) {
        ViewMoreHolder r3 = (ViewMoreHolder) r2;
        Intrinsics.checkNotNullParameter(r3, "holder");
        super.onViewAttachedToWindow(r3);
        StaggeredGridLayoutManager.LayoutParams r4 = ((RecyclerView.ViewHolder) r3).itemView.getLayoutParams();
        if ((r4 instanceof StaggeredGridLayoutManager.LayoutParams) == false) goto L5;
        StaggeredGridLayoutManager.LayoutParams r5 = r4;
    L6:
        if (r5 == null) goto L9;
        r5.setFullSpan(true);
        return;
    L9:
        return;
    L5:
        r5 = null;
        goto L6
    }

    public static void y2(SimpleDraweeView r3, wh8.a r4) {
        if (r4 == null) goto L8;
        wc9.e r0 = r4.a;
        if (r0 == null) goto L8;
        boolean r1 = true;
        if (n.w(r0) != true) goto L8;
    L9:
        if (r1 == false) goto L13;
        if (r3 == null) goto L24;
        r3.setImageResource(2131241230);
        return;
    L24:
        return;
    L13:
        if (r4 == null) goto L21;
        wc9.e r5 = r4.a;
        if (r5 == null) goto L21;
        IconImage r6 = r5.b;
        if (r6 == null) goto L21;
        ImageObj r7 = r6.imageThumb;
        if (r7 == null) goto L21;
        String r8 = r7.url;
    L22:
        ImageLoaderKt.v(r3, r8, "covn_list.avatar", null, new i());
        return;
    L21:
        r8 = null;
    L8:
        r1 = false;
        goto L9
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r5, int r6) {
        ViewMoreHolder r7 = (ViewMoreHolder) r5;
        Intrinsics.checkNotNullParameter(r7, "holder");
        LarusItemAwemeViewMoreBinding r8 = r7.a;
        List<wh8.a> r9 = this.a;
        if (r9 != null) goto L5;
    L8:
        boolean r10 = true;
    L9:
        if (r10 == true) goto L18;
        e1.x(r8.c);
        SimpleDraweeView r11 = (SimpleDraweeView) CollectionsKt.getOrNull(r8.b.getAvatarList(), 0);
        List<wh8.a> r2 = this.a;
        wh8.a r3 = null;
        if (r2 == null) goto L13;
        wh8.a r1 = (wh8.a) CollectionsKt.getOrNull(r2, 0);
    L14:
        y2(r11, r1);
        SimpleDraweeView r12 = (SimpleDraweeView) CollectionsKt.getOrNull(r8.b.getAvatarList(), 1);
        List<wh8.a> r13 = this.a;
        if (r13 == null) goto L17;
        r3 = (wh8.a) CollectionsKt.getOrNull(r13, 1);
    L17:
        y2(r12, r3);
        return;
    L13:
        r1 = null;
        goto L14
    L18:
        e1.o(r8.c);
        return;
    L5:
        if (r9.isEmpty() == true) goto L8;
        r10 = false;
        goto L9
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r6, int r7) {
        Intrinsics.checkNotNullParameter(r6, "parent");
        View r8 = LayoutInflater.from(r6.getContext()).inflate(2131562498, null, false);
        int r9 = 2131363710;
        AvatarListView r0 = ViewBindings.findChildViewById(r8, 2131363710);
        if (r0 == null) goto L11;
        r9 = 2131369245;
        GradientTextView r2 = ViewBindings.findChildViewById(r8, 2131369245);
        if (r2 == null) goto L11;
        r9 = 2131377674;
        LinearLayout r3 = (LinearLayout) ViewBindings.findChildViewById(r8, 2131377674);
        if (r3 == null) goto L11;
        LarusItemAwemeViewMoreBinding r10 = new LarusItemAwemeViewMoreBinding((LinearLayout) r8, r0, r2, r3);
        e1.u(r3, 0.0f, v19.c.b(2130970529, null, 2131102529), v19.c.b(2130972118, null, 2131103188));
        e1.d(r3, new j(this));
        Lazy r11 = com.larus.bmhome.video.b.a;
        r2.setText(com.larus.bmhome.video.b.e());
        return new ViewMoreHolder(r10);
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r8.getResources().getResourceName(r9)));
    }
}
