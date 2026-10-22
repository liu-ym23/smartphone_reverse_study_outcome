package com.larus.setting.impl.blocklist;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.larus.account.base.model.profile.AvatarInfo;
import com.larus.bmhome.view.RoundAvatarImageView;
import com.larus.common_res.common_ui.databinding.LarusItemLoadMoreBinding;
import com.larus.common_ui.paging.FPagingAdapter;
import com.larus.common_ui.view.ViewBindingHolder;
import com.larus.home.api.block.BlockUserInfo;
import com.larus.setting.impl.databinding.LarusItemBlockPlaceholderBinding;
import com.larus.setting.impl.databinding.LarusItemBlockUserBinding;
import com.larus.utils.e1;
import com.larus.utils.o0;
import com.larus.utils.y0;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 #2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001#B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001c\u0010\u000e\u001a\u00020\u000b2\u0014\u0010\u000f\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0004\u0012\u00020\u000b0\tJ\u001c\u0010\u0010\u001a\u00020\u000b2\u0014\u0010\u000f\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0004\u0012\u00020\u000b0\tJ \u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0018\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0015H\u0016J\u0010\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u001a\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0002J\u000e\u0010 \u001a\u00020\u000b2\u0006\u0010!\u001a\u00020\u0015J\u0006\u0010\"\u001a\u00020\u0015R\u001e\u0010\b\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\f\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0002X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/larus/setting/impl/blocklist/BlockListAdapter;", "Lcom/larus/common_ui/paging/FPagingAdapter;", "Lcom/larus/setting/impl/blocklist/BlockUserItem;", "Lcom/larus/common_ui/view/ViewBindingHolder;", "config", "Lcom/larus/common_ui/paging/FPagingAdapter$Config;", "<init>", "(Lcom/larus/common_ui/paging/FPagingAdapter$Config;)V", "blockListener", "Lkotlin/Function1;", "", "", "unblockListener", "loadMoreItem", "setBlockButtonClickListener", "listener", "setUnBlockButtonClickListener", "onBindViewHolder", "holder", "blockUserItem", "position", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "getItemViewType", "loadAvatar", "view", "Lcom/larus/bmhome/view/RoundAvatarImageView;", "data", "Lcom/larus/account/base/model/profile/AvatarInfo;", "updateLoadMoreStatus", "status", "getRealBlockUserNum", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class BlockListAdapter extends FPagingAdapter<m, ViewBindingHolder> {
    public static final /* synthetic */ int i = 0;
    public Function1<? super String, Unit> f;
    public Function1<? super String, Unit> g;
    public final m h;

    public static final class a {
    }

    static {
    }

    public BlockListAdapter(FPagingAdapter.a r5) {
        Intrinsics.checkNotNullParameter(r5, "config");
        super(r5);
        this.h = new m(null, false, -2, 10);
    }

    public final void H2(int r4) {
        m r0 = this.h;
        if (r0.d != r4) goto L5;
        return;
    L5:
        r0.d = r4;
        boolean r1 = Intrinsics.areEqual(A2(getItemCount() - 1), this.h);
        if (r4 != 1) goto L8;
    L14:
        if (r1 == false) goto L16;
        notifyItemChanged(getItemCount() - 1);
        return;
    L16:
        y2(CollectionsKt.listOf(this.h));
        return;
    L8:
        if (r4 != 2) goto L10;
        if (r1 == false) goto L18;
        F2(getItemCount() - 1);
        return;
    L18:
        return;
    L10:
        if (r4 == 3) goto L14;
    }

    public final int getItemViewType(int r1) {
        m r2 = (m) A2(r1);
        if (r2 != null) goto L7;
        return -1;
    L7:
        return r2.getType();
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r6, int r7) {
        Intrinsics.checkNotNullParameter(r6, "parent");
        LayoutInflater r0 = LayoutInflater.from(r6.getContext());
        if (r7 == (-2)) goto L23;
        if (r7 == (-1)) goto L15;
        View r8 = r0.inflate(2131562504, r6, false);
        int r1 = 2131364269;
        RoundAvatarImageView r2 = ViewBindings.findChildViewById(r8, 2131364269);
        if (r2 == null) goto L14;
        r1 = 2131364270;
        Button r3 = (Button) ViewBindings.findChildViewById(r8, 2131364270);
        if (r3 == null) goto L14;
        r1 = 2131364284;
        TextView r4 = (TextView) ViewBindings.findChildViewById(r8, 2131364284);
        if (r4 == null) goto L14;
        return new BlockUserItemViewHolder(new LarusItemBlockUserBinding((LinearLayout) r8, r2, r3, r4));
    L14:
        throw new NullPointerException("Missing required view with ID: ".concat(r8.getResources().getResourceName(r1)));
    L15:
        View r9 = r0.inflate(2131562503, r6, false);
        int r5 = 2131363623;
        View r10 = ViewBindings.findChildViewById(r9, 2131363623);
        if (r10 == null) goto L21;
        r5 = 2131377337;
        if (((LinearLayout) ViewBindings.findChildViewById(r9, 2131377337)) == null) goto L21;
        return new ViewBindingHolder(new LarusItemBlockPlaceholderBinding((RelativeLayout) r9, r10));
    L21:
        throw new NullPointerException("Missing required view with ID: ".concat(r9.getResources().getResourceName(r5)));
    L23:
        return new LoadMoreItemViewHolder(LarusItemLoadMoreBinding.a(r0, r6));
    }

    public final void D2(RecyclerView.ViewHolder r9, Object r10, int r11) {
        ViewBindingHolder r12 = (ViewBindingHolder) r9;
        final m r13 = (m) r10;
        Intrinsics.checkNotNullParameter(r12, "holder");
        Intrinsics.checkNotNullParameter(r13, "blockUserItem");
        if ((r12 instanceof BlockUserItemViewHolder) == false) goto L43;
        LarusItemBlockUserBinding r14 = ((BlockUserItemViewHolder) r12).a;
        RoundAvatarImageView r3 = r14.b;
        BlockUserInfo r4 = r13.a;
        CharSequence r5 = null;
        if (r4 == null) goto L7;
        AvatarInfo r6 = r4.getAvatar();
    L8:
        if (r6 == null) goto L10;
        String r7 = r6.b();
    L12:
        if (o0.d(r7) == false) goto L17;
        if (r6 == null) goto L15;
        String r0 = r6.b();
    L16:
        RoundAvatarImageView.f(r3, r0, "settings_itg.bot", false, 8);
    L27:
        TextView r1 = r14.d;
        BlockUserInfo r2 = r13.a;
        if (r2 == null) goto L30;
        String r8 = r2.getNickName();
    L31:
        r1.setText(r8);
        Button r15 = r14.c;
        if (r13.b == false) goto L37;
        r15.setTextColor(ContextCompat.getColor(((RecyclerView.ViewHolder) r12).itemView.getContext(), 2131103136));
        r15.setBackgroundResource(2131238725);
        Context r16 = r14.a.getContext();
        if (r16 == null) goto L36;
        r5 = r16.getText(2131910786);
    L36:
        r15.setText(r5);
    L41:
        e1.d(r15, new com.larus.setting.impl.blocklist.a(r13, this));
        return;
    L37:
        r15.setTextColor(ContextCompat.getColor(((RecyclerView.ViewHolder) r12).itemView.getContext(), 2131103298));
        r15.setBackgroundResource(2131238724);
        Context r17 = r14.a.getContext();
        if (r17 == null) goto L40;
        r5 = r17.getText(2131900169);
    L40:
        r15.setText(r5);
        goto L41
    L30:
        r8 = null;
        goto L31
    L15:
        r0 = null;
        goto L16
    L17:
        if (r6 == null) goto L19;
        String r18 = r6.a();
    L21:
        if (o0.d(r18) == false) goto L26;
        if (r6 == null) goto L24;
        String r19 = r6.a();
    L25:
        RoundAvatarImageView.f(r3, r19, "settings_itg.bot", true, 8);
        goto L27
    L24:
        r19 = null;
        goto L25
    L26:
        RoundAvatarImageView.f(r3, y0.k(new Uri.Builder().scheme("res").path(String.valueOf(2131240119)).build()), null, false, 8);
        goto L27
    L19:
        r18 = null;
        goto L21
    L10:
        r7 = null;
        goto L12
    L7:
        r6 = null;
        goto L8
    L43:
        if ((r12 instanceof LoadMoreItemViewHolder) == false) goto L56;
        LoadMoreItemViewHolder r20 = (LoadMoreItemViewHolder) r12;
        int r110 = r13.d;
        if (r110 != 1) goto L47;
        r20.a.c.setVisibility(8);
        r20.a.b.setVisibility(0);
        return;
    L47:
        if (r110 != 2) goto L49;
        r20.a.c.setVisibility(8);
        r20.a.b.setVisibility(8);
        return;
    L49:
        if (r110 == 3) goto L51;
        r20.getClass();
        return;
    L51:
        r20.a.c.setVisibility(0);
        r20.a.b.setVisibility(8);
        return;
    }
}
