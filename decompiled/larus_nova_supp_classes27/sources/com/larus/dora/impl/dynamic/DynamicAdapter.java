package com.larus.dora.impl.dynamic;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.dora.impl.databinding.LarusDoraDeviceBatteryLayoutBinding;
import com.larus.dora.impl.databinding.LarusDoraDeviceInfoGeneraGroupLayoutBinding;
import com.larus.dora.impl.databinding.LarusDoraDeviceInfoReconnectLayoutBinding;
import com.larus.dora.impl.databinding.LarusDoraDeviceSingleProductDisplayBinding;
import com.larus.dora.impl.databinding.LarusDoraDeviceUnbindLayoutBinding;
import com.larus.dora.impl.databinding.LarusDoraDynamicListItemBinding;
import com.larus.dora.impl.dynamic.viewholder.DeviceInfoReconnectViewHolder;
import com.larus.dora.impl.dynamic.viewholder.DeviceListViewHolder;
import com.larus.dora.impl.dynamic.viewholder.DeviceSingleProductDisplayHolder;
import com.larus.dora.impl.dynamic.viewholder.DoraDeviceAttributeHolder;
import com.larus.dora.impl.dynamic.viewholder.DoraDeviceNameViewHolder;
import com.larus.dora.impl.dynamic.viewholder.DoraDeviceUnbindViewHolder;
import com.larus.dora.impl.dynamic.viewholder.GeneraGroupHolder;
import com.larus.dora.impl.view.DoraTextView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0014\u0010\u0017\u001a\u00020\u00102\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00030\rJ\u0014\u0010\u0019\u001a\u00020\u00102\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fJ\u001c\u0010\u001b\u001a\u00020\u00102\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00030\u001d2\u0006\u0010\u0013\u001a\u00020\u0014J\u0014\u0010\u001e\u001a\u00020\u00102\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00030\u001dJ\u000e\u0010\u001f\u001a\u00020\u00102\u0006\u0010 \u001a\u00020\u0003J\u0006\u0010!\u001a\u00020\u0010J\u000e\u0010\"\u001a\u00020\u00102\u0006\u0010#\u001a\u00020\u0016J\u0006\u0010\u0015\u001a\u00020\u0016J\u0006\u0010$\u001a\u00020\u0010J\u001e\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)H\u0016J\u001e\u0010*\u001a\u00020\u00102\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010,\u001a\u00020)H\u0016J\u0016\u0010-\u001a\u00020\u00102\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J\u0016\u0010.\u001a\u00020\u00102\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J\b\u0010/\u001a\u00020)H\u0016J\u0010\u00100\u001a\u00020)2\u0006\u0010,\u001a\u00020)H\u0016J\u000e\u00101\u001a\u00020\u00102\u0006\u00102\u001a\u000203R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00064"}, d2 = {"Lcom/larus/dora/impl/dynamic/DynamicAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/larus/dora/impl/dynamic/BaseViewHolder;", "Lcom/larus/dora/impl/dynamic/entity/CardInstance;", "actionHandler", "Lcom/larus/dora/impl/dynamic/event/ActionHandler;", "traceNode", "Lcom/ixigua/lib/track/ITrackNode;", "<init>", "(Lcom/larus/dora/impl/dynamic/event/ActionHandler;Lcom/ixigua/lib/track/ITrackNode;)V", "items", "", "itemCallback", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "loadMoreListener", "Lkotlin/Function0;", "", "isLoading", "", "cardContext", "Lcom/larus/dora/impl/dynamic/entity/CardContext;", "connectionState", "Lcom/larus/dora/impl/dynamic/event/DeviceConnectionState;", "setItemCallback", "callback", "setLoadMoreListener", "listener", "setData", "newItems", "", "addData", "removeData", "data", "onLoadMoreComplete", "updateConnectionState", "newState", "updateDeviceInfoState", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "holder", "position", "onViewDetachedFromWindow", "onViewRecycled", "getItemCount", "getItemViewType", "enableLoadMore", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DynamicAdapter extends RecyclerView.Adapter<BaseViewHolder<d59.c>> {
    public final int getItemCount() {
        throw null;
    }

    public final int getItemViewType(int r1) {
        throw null;
    }

    public final void onViewDetachedFromWindow(RecyclerView.ViewHolder r2) {
        BaseViewHolder r3 = (BaseViewHolder) r2;
        Intrinsics.checkNotNullParameter(r3, "holder");
        super.onViewDetachedFromWindow(r3);
        r3.V3();
    }

    public final void onViewRecycled(RecyclerView.ViewHolder r2) {
        BaseViewHolder r3 = (BaseViewHolder) r2;
        Intrinsics.checkNotNullParameter(r3, "holder");
        super.onViewRecycled(r3);
        r3.onViewRecycled();
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r2, int r3) {
        BaseViewHolder r4 = (BaseViewHolder) r2;
        Intrinsics.checkNotNullParameter(r4, "holder");
        r4.U3();
        r4.T3(ListProtector.get(null, r3), null, null);
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r13, int r14) {
        Intrinsics.checkNotNullParameter(r13, "parent");
        int r1 = b2.a;
        Intrinsics.checkNotNullParameter(r13, "parent");
        Intrinsics.checkNotNullParameter(null, "traceNode");
        g49.d.a("ViewHolderFactory", "create: viewType=" + r14);
        if (r14 != CardCons$CardType.CARD_TEXT.getViewType()) goto L5;
        int r15 = DeviceListViewHolder.c;
        Intrinsics.checkNotNullParameter(r13, "parent");
        BaseViewHolder r16 = new DeviceListViewHolder(LarusDoraDynamicListItemBinding.a(LayoutInflater.from(r13.getContext()), r13));
    L54:
        Intrinsics.checkNotNullParameter(null, "handler");
        r16.a = null;
        throw null;
    L5:
        if (r14 != CardCons$CardType.CARD_GENERAL_GROUP.getViewType()) goto L7;
        int r17 = GeneraGroupHolder.e;
        r16 = GeneraGroupHolder.a.a(r13);
        goto L54
    L7:
        if (r14 != CardCons$CardType.CARD_DEVICE_NAME.getViewType()) goto L9;
        int r18 = DoraDeviceNameViewHolder.f;
        Intrinsics.checkNotNullParameter(r13, "parent");
        Intrinsics.checkNotNullParameter(null, "traceNode");
        r16 = new DoraDeviceNameViewHolder(LarusDoraDeviceInfoGeneraGroupLayoutBinding.a(LayoutInflater.from(r13.getContext()), r13));
        goto L54
    L9:
        if (r14 != CardCons$CardType.CARD_DEVICE_ATTRIBUTE.getViewType()) goto L11;
        int r110 = DoraDeviceAttributeHolder.e;
        Intrinsics.checkNotNullParameter(r13, "parent");
        r16 = new DoraDeviceAttributeHolder(LarusDoraDeviceInfoGeneraGroupLayoutBinding.a(LayoutInflater.from(r13.getContext()), r13));
        goto L54
    L11:
        if (r14 != CardCons$CardType.CARD_DEVICE_UNBIND_BUTTON.getViewType()) goto L18;
        int r111 = DoraDeviceUnbindViewHolder.c;
        Intrinsics.checkNotNullParameter(r13, "parent");
        View r112 = LayoutInflater.from(r13.getContext()).inflate(2131562161, r13, false);
        LinearLayout r113 = (LinearLayout) r112;
        AppCompatTextView r2 = ViewBindings.findChildViewById(r112, 2131369509);
        if (r2 == null) goto L16;
        r16 = new DoraDeviceUnbindViewHolder(new LarusDoraDeviceUnbindLayoutBinding(r113, r113, r2));
        goto L54
    L16:
        throw new NullPointerException("Missing required view with ID: ".concat(r112.getResources().getResourceName(2131369509)));
    L18:
        if (r14 != CardCons$CardType.CARD_DEVICE_RECONNECT.getViewType()) goto L29;
        int r114 = DeviceInfoReconnectViewHolder.g;
        Intrinsics.checkNotNullParameter(r13, "parent");
        View r115 = LayoutInflater.from(r13.getContext()).inflate(2131562156, r13, false);
        int r116 = 2131369467;
        LinearLayout r0 = (LinearLayout) ViewBindings.findChildViewById(r115, 2131369467);
        if (r0 == null) goto L27;
        r116 = 2131369469;
        AppCompatTextView r3 = ViewBindings.findChildViewById(r115, 2131369469);
        if (r3 == null) goto L27;
        r116 = 2131379075;
        ImageView r4 = (ImageView) ViewBindings.findChildViewById(r115, 2131379075);
        if (r4 == null) goto L27;
        r16 = new DeviceInfoReconnectViewHolder(new LarusDoraDeviceInfoReconnectLayoutBinding((FrameLayout) r115, r0, r3, r4));
    L27:
        throw new NullPointerException("Missing required view with ID: ".concat(r115.getResources().getResourceName(r116)));
    L29:
        if (r14 != CardCons$CardType.CARD_DEVICE_KEEP_ALIVE.getViewType()) goto L31;
        int r117 = GeneraGroupHolder.e;
        r16 = GeneraGroupHolder.a.a(r13);
        goto L54
    L31:
        if (r14 != CardCons$CardType.CARD_SINGLE_DEVICE_PRODUCT_DISPLAY.getViewType()) goto L46;
        int r118 = DeviceSingleProductDisplayHolder.c;
        Intrinsics.checkNotNullParameter(r13, "parent");
        ConstraintLayout r119 = LayoutInflater.from(r13.getContext()).inflate(2131562159, r13, false);
        int r120 = 2131369463;
        ConstraintLayout r7 = ViewBindings.findChildViewById(r119, 2131369463);
        if (r7 == null) goto L44;
        r120 = 2131369464;
        View r5 = ViewBindings.findChildViewById(r119, 2131369464);
        if (r5 == null) goto L44;
        LarusDoraDeviceBatteryLayoutBinding r8 = LarusDoraDeviceBatteryLayoutBinding.a(r5);
        r120 = 2131369465;
        SimpleDraweeView r9 = ViewBindings.findChildViewById(r119, 2131369465);
        if (r9 == null) goto L44;
        r120 = 2131369470;
        DoraTextView r10 = (DoraTextView) ViewBindings.findChildViewById(r119, 2131369470);
        if (r10 == null) goto L44;
        r120 = 2131369479;
        SimpleDraweeView r11 = ViewBindings.findChildViewById(r119, 2131369479);
        if (r11 == null) goto L44;
        r16 = new DeviceSingleProductDisplayHolder(new LarusDoraDeviceSingleProductDisplayBinding(r119, r7, r8, r9, r10, r11));
    L44:
        throw new NullPointerException("Missing required view with ID: ".concat(r119.getResources().getResourceName(r120)));
    L46:
        if (r14 != CardCons$CardType.CARD_FEEDBACK.getViewType()) goto L48;
        int r121 = GeneraGroupHolder.e;
        r16 = GeneraGroupHolder.a.a(r13);
        goto L54
    L48:
        int r122 = DeviceListViewHolder.c;
        Intrinsics.checkNotNullParameter(r13, "parent");
        r16 = new DeviceListViewHolder(LarusDoraDynamicListItemBinding.a(LayoutInflater.from(r13.getContext()), r13));
        goto L54
    }
}
