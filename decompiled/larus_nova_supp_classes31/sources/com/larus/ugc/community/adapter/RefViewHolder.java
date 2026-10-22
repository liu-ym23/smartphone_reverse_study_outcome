package com.larus.ugc.community.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.tencent.open.log.TraceLevel;
import f0a.a;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B4\u0012#\u0010\u0002\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0003\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0016\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004R+\u0010\u0002\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/larus/ugc/community/adapter/RefViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "onRefViewClickListener", "Lkotlin/Function1;", "Lcom/larus/ugc/community/adapter/RefData;", "Lkotlin/ParameterName;", "name", "item", "", "itemView", "Landroid/view/View;", "<init>", "(Lkotlin/jvm/functions/Function1;Landroid/view/View;)V", "getItemView", "()Landroid/view/View;", "refView", "Lcom/facebook/drawee/view/SimpleDraweeView;", "audioView", "audioIcon", "Landroid/widget/ImageView;", "audioDuration", "Landroid/widget/TextView;", "bindData", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class RefViewHolder extends RecyclerView.ViewHolder {
    public static final /* synthetic */ int g = 0;
    public final Function1<a, Unit> a;
    public final View b;
    public final SimpleDraweeView c;
    public final View d;
    public final ImageView e;
    public final TextView f;

    /* JADX WARN: Multi-variable type inference failed */
    public RefViewHolder(Function1<? super a, Unit> r2, View r3) {
        Intrinsics.checkNotNullParameter(r2, "onRefViewClickListener");
        Intrinsics.checkNotNullParameter(r3, "itemView");
        super(r3);
        this.a = r2;
        this.b = r3;
        this.c = r3.findViewById(2131384122);
        this.d = r3.findViewById(2131363509);
        this.e = (ImageView) r3.findViewById(2131363433);
        this.f = (TextView) r3.findViewById(2131363426);
    }
}
