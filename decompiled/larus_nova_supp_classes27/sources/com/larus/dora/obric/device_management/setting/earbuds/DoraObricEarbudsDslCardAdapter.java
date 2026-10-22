package com.larus.dora.obric.device_management.setting.earbuds;

import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.dora.impl.databinding.LarusDoraDeviceInfoGeneraGroupLayoutBinding;
import com.larus.dora.impl.dynamic.BaseViewHolder;
import com.larus.dora.impl.dynamic.dsl.DslTemplateType;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0000\u0018\u0000 &2\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001:\u0002&'B\u0013\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0014\u0010\u0010\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00030\u0013J\u0010\u0010\u0014\u001a\u00020\u00112\b\u0010\n\u001a\u0004\u0018\u00010\u000bJ\u000e\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\rJ\u000e\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u0019J\u001e\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u001e\u0010\u001f\u001a\u00020\u00112\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010!\u001a\u00020\u001eH\u0016J\u0016\u0010\"\u001a\u00020\u00112\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J\u0016\u0010#\u001a\u00020\u00112\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J\b\u0010$\u001a\u00020\u001eH\u0016J\u0010\u0010%\u001a\u00020\u001e2\u0006\u0010!\u001a\u00020\u001eH\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/larus/dora/obric/device_management/setting/earbuds/DoraObricEarbudsDslCardAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/larus/dora/impl/dynamic/BaseViewHolder;", "Lcom/larus/dora/impl/dynamic/dsl/DslCard;", "actionHandler", "Lcom/larus/dora/impl/dynamic/event/ActionHandler;", "<init>", "(Lcom/larus/dora/impl/dynamic/event/ActionHandler;)V", "items", "", "cardContext", "Lcom/larus/dora/impl/dynamic/entity/CardContext;", "connectionState", "Lcom/larus/dora/impl/dynamic/event/DeviceConnectionState;", "handler", "Landroid/os/Handler;", "setCards", "", "newItems", "", "setCardContext", "updateConnectionState", "newState", "handleEvent", "event", "Lcom/larus/dora/obric/device_management/setting/earbuds/DoraObricEarbudsDslCardAdapter$DslCardAdapterEvent;", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "holder", "position", "onViewDetachedFromWindow", "onViewRecycled", "getItemCount", "getItemViewType", "Companion", "DslCardAdapterEvent", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraObricEarbudsDslCardAdapter extends RecyclerView.Adapter<BaseViewHolder<c59.i>> {
    public static final /* synthetic */ int f = 0;
    public final e59.a a;
    public final List<c59.i> b;
    public d59.b c;
    public e59.b d;
    public final Handler e;

    public static final class a {
    }

    static {
    }

    public DoraObricEarbudsDslCardAdapter() {
        this(null);
    }

    public final int getItemCount() {
        return ((ArrayList) this.b).size();
    }

    public DoraObricEarbudsDslCardAdapter(e59.a r2) {
        this.a = r2;
        this.b = new ArrayList();
        this.d = e59.b.d.a;
        this.e = new Handler(Looper.getMainLooper());
    }

    public final int getItemViewType(int r3) {
        if (((ArrayList) this.b).isEmpty() == false) goto L5;
        return 0;
    L5:
        if (((c59.i) ListProtector.get(this.b, r3)).b == null) goto L13;
        DslTemplateType r4 = ((c59.i) ListProtector.get(this.b, r3)).a;
        if (r4 != null) goto L10;
        return 0;
    L10:
        return r4.ordinal();
    L13:
        return 0;
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

    public final void onBindViewHolder(RecyclerView.ViewHolder r3, int r4) {
        BaseViewHolder r5 = (BaseViewHolder) r3;
        Intrinsics.checkNotNullParameter(r5, "holder");
        r5.U3();
        r5.T3(ListProtector.get(this.b, r4), this.d, this.c);
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "parent");
        if (r4 != DslTemplateType.GENERAL_GROUP.ordinal()) goto L6;
        int r5 = DoraObricEarbudsSettingsGeneralGroupHolder.e;
        Intrinsics.checkNotNullParameter(r3, "parent");
        BaseViewHolder r6 = new DoraObricEarbudsSettingsGeneralGroupHolder(LarusDoraDeviceInfoGeneraGroupLayoutBinding.a(LayoutInflater.from(r3.getContext()), r3));
    L9:
        e59.a r7 = this.a;
        if (r7 == null) goto L12;
        Intrinsics.checkNotNullParameter(r7, "handler");
        r6.a = r7;
    L12:
        return r6;
    L6:
        if (r4 != DslTemplateType.RECONNECT_UNBIND_PANEL.ordinal()) goto L8;
        int r8 = DoraObricEarbudsReconnectUnbindHolder.j;
        Intrinsics.checkNotNullParameter(r3, "parent");
        r6 = new DoraObricEarbudsReconnectUnbindHolder(r3);
        goto L9
    L8:
        r6 = com.larus.dora.impl.dynamic.viewholder.n.a(r3, r4);
        goto L9
    }
}
