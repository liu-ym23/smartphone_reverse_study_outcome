package com.larus.dora.impl.dynamic.viewholder;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.UriProtector;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.dora.impl.databinding.LarusDoraDynamicListItemBinding;
import com.larus.dora.impl.dynamic.BaseViewHolder;
import com.larus.dora.impl.dynamic.a1;
import com.larus.utils.e1;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000e2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000eB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\"\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/larus/dora/impl/dynamic/viewholder/DeviceListViewHolder;", "Lcom/larus/dora/impl/dynamic/BaseViewHolder;", "Lcom/larus/dora/impl/dynamic/entity/CardInstance;", "binding", "Lcom/larus/dora/impl/databinding/LarusDoraDynamicListItemBinding;", "<init>", "(Lcom/larus/dora/impl/databinding/LarusDoraDynamicListItemBinding;)V", "bind", "", "data", "connectionState", "Lcom/larus/dora/impl/dynamic/event/DeviceConnectionState;", "cardContext", "Lcom/larus/dora/impl/dynamic/entity/CardContext;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DeviceListViewHolder extends BaseViewHolder<d59.c> {
    public static final /* synthetic */ int c = 0;
    public final LarusDoraDynamicListItemBinding b;

    public static final class a {
    }

    static {
    }

    public DeviceListViewHolder(LarusDoraDynamicListItemBinding r2) {
        Intrinsics.checkNotNullParameter(r2, "binding");
        super(r2.a);
        this.b = r2;
    }

    @Override // com.larus.dora.impl.dynamic.BaseViewHolder
    public final void T3(d59.c r6, e59.b r7, final d59.b r8) {
        d59.c r9 = r6;
        Intrinsics.checkNotNullParameter(r9, "data");
        Intrinsics.checkNotNullParameter(r7, "connectionState");
        final d59.j r10 = r9.e;
        if ((r10 instanceof com.larus.dora.impl.dynamic.j) == false) goto L15;
        com.larus.dora.impl.dynamic.j r11 = (com.larus.dora.impl.dynamic.j) r10;
        String r0 = UriProtector.getQueryParameter(UriProtector.parse(r11.b()), "product_id");
        if (r0 == null) goto L7;
        Integer r1 = StringsKt.toIntOrNull(r0);
    L9:
        if (r11.c() == null) goto L11;
        SimpleDraweeView r2 = this.b.b;
        r2.getHierarchy().setActualImageScaleType(ScalingUtils.ScaleType.CENTER_CROP);
        Intrinsics.checkNotNull(r2);
        a1.b(r2, r11.c(), r1, null, 12);
    L11:
        final View r12 = ((RecyclerView.ViewHolder) this).itemView;
        if (r12 == null) goto L16;
        e1.d(r12, new f(r10, r12, r8));
        return;
    L16:
        return;
    L7:
        r1 = null;
        goto L9
    }
}
