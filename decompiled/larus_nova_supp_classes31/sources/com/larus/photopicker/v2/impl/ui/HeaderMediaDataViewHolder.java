package com.larus.photopicker.v2.impl.ui;

import androidx.recyclerview.widget.RecyclerView;
import com.larus.photopicker.v2.impl.databinding.LarusItemHeaderPermissionBinding;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import op9.d;
import vp9.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u001e\u0010\u0004\u001a\u001a\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0005¢\u0006\u0004\b\n\u0010\u000bJ\u0006\u0010\f\u001a\u00020\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R&\u0010\u0004\u001a\u001a\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/larus/photopicker/v2/impl/ui/HeaderMediaDataViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/larus/photopicker/v2/impl/databinding/LarusItemHeaderPermissionBinding;", "onItemClick", "Lkotlin/Function3;", "Lcom/larus/photopicker/v2/impl/model/UIMediaItem;", "", "Lcom/larus/photopicker/v2/impl/ui/ClickType;", "", "<init>", "(Lcom/larus/photopicker/v2/impl/databinding/LarusItemHeaderPermissionBinding;Lkotlin/jvm/functions/Function3;)V", "bind", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class HeaderMediaDataViewHolder extends RecyclerView.ViewHolder {
    public static final /* synthetic */ int b = 0;
    public final Function3<d, Integer, ClickType, Unit> a;

    /* JADX WARN: Multi-variable type inference failed */
    public HeaderMediaDataViewHolder(LarusItemHeaderPermissionBinding r2, Function3<? super d, ? super Integer, ? super ClickType, Unit> r3) {
        Intrinsics.checkNotNullParameter(r2, "binding");
        Intrinsics.checkNotNullParameter(r3, "onItemClick");
        super(r2.a);
        this.a = r3;
        r2.a.setOnClickListener(new c(this));
    }
}
