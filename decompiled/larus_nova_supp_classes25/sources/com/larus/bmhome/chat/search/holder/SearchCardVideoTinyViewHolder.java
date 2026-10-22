package com.larus.bmhome.chat.search.holder;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.common_ui.widget.roundlayout.RoundFrameLayout;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 %2\u00020\u0001:\u0001%B)\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ,\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020 2\u0014\u0010!\u001a\u0010\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020#\u0018\u00010\"J\b\u0010$\u001a\u00020\bH\u0002R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/larus/bmhome/chat/search/holder/SearchCardVideoTinyViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "indicator", "", "abVersion", "useDetailBox", "", "<init>", "(Landroid/view/View;IIZ)V", "getIndicator", "()I", "getAbVersion", "getUseDetailBox", "()Z", "textCreator", "Landroid/widget/TextView;", "imageCover", "Lcom/facebook/drawee/view/SimpleDraweeView;", "imageCreateAvatar", "videoPlay", "Landroidx/appcompat/widget/AppCompatImageView;", "textTitle", "videoMask", "Landroid/widget/FrameLayout;", "rootView", "Lcom/larus/common_ui/widget/roundlayout/RoundFrameLayout;", "bind", "", "position", "item", "Lcom/larus/bmhome/chat/search/VideoInfo;", "extra", "", "", "shouldGone", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class SearchCardVideoTinyViewHolder extends RecyclerView.ViewHolder {
    public static final /* synthetic */ int k = 0;
    public final int a;
    public final int b;
    public final boolean c;
    public final TextView d;
    public final SimpleDraweeView e;
    public final SimpleDraweeView f;
    public final AppCompatImageView g;
    public final TextView h;
    public final FrameLayout i;
    public final RoundFrameLayout j;

    public static final class a {
    }

    static {
    }

    public SearchCardVideoTinyViewHolder(View r1, int r2, int r3, boolean r4) {
        super(r1);
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = (TextView) r1.findViewById(2131388418);
        this.e = r1.findViewById(2131374973);
        this.f = r1.findViewById(2131374977);
        this.g = r1.findViewById(2131392342);
        this.h = (TextView) r1.findViewById(2131388514);
        this.i = (FrameLayout) r1.findViewById(2131392333);
        this.j = r1.findViewById(2131384840);
    }
}
