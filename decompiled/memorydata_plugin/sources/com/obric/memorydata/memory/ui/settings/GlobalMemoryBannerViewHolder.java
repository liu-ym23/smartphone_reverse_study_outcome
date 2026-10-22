package com.obric.memorydata.memory.ui.settings;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.obric.memorydata.memory.databinding.ItemGlobalMemorySettingsBannerBinding;
import com.obric.oui.banner.BannerViewHolder;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\tH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000e"}, d2 = {"Lcom/obric/memorydata/memory/ui/settings/GlobalMemoryBannerViewHolder;", "Lcom/obric/oui/banner/BannerViewHolder;", "binding", "Lcom/obric/memorydata/memory/databinding/ItemGlobalMemorySettingsBannerBinding;", "<init>", "(Lcom/obric/memorydata/memory/databinding/ItemGlobalMemorySettingsBannerBinding;)V", "getBinding", "()Lcom/obric/memorydata/memory/databinding/ItemGlobalMemorySettingsBannerBinding;", "onBind", "", "data", "Lcom/obric/oui/banner/BannerData;", "onSelect", "Companion", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class GlobalMemoryBannerViewHolder extends BannerViewHolder {
    public static final a Companion = null;
    private final ItemGlobalMemorySettingsBannerBinding binding;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u0014\u0010\u0004\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\f"}, d2 = {"Lcom/obric/memorydata/memory/ui/settings/GlobalMemoryBannerViewHolder$Companion;", "Lcom/obric/oui/banner/IBannerViewHolderFactory;", "<init>", "()V", "key", "", "getKey", "()Ljava/lang/String;", "newInstance", "Lcom/obric/oui/banner/BannerViewHolder;", "parent", "Landroid/view/ViewGroup;", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a implements com.obric.oui.banner.c {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        @Override // com.obric.oui.banner.c
        public BannerViewHolder a(ViewGroup r4) {
            Intrinsics.checkNotNullParameter(r4, "parent");
            ItemGlobalMemorySettingsBannerBinding r3 = ItemGlobalMemorySettingsBannerBinding.inflate(LayoutInflater.from((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")), r4, false);
            Intrinsics.checkNotNullExpressionValue(r3, "inflate(...)");
            return (BannerViewHolder) ZeusTransformUtils.preCheckCast(new GlobalMemoryBannerViewHolder(r3), BannerViewHolder.class, "com.obric.memorydata.plugin");
        }

        @Override // com.obric.oui.banner.c
        public String a() {
            return "_global_memory_item";
        }
    }

    static {
        Companion = new a(null);
    }

    public GlobalMemoryBannerViewHolder(ItemGlobalMemorySettingsBannerBinding r4) {
        Intrinsics.checkNotNullParameter(r4, "binding");
        ConstraintLayout r0 = r4.getRoot();
        Intrinsics.checkNotNullExpressionValue(r0, "getRoot(...)");
        super((View) ZeusTransformUtils.preCheckCast(r0, View.class, "com.obric.memorydata.plugin"));
        this.binding = r4;
    }

    public final ItemGlobalMemorySettingsBannerBinding getBinding() {
        return this.binding;
    }

    @Override // com.obric.oui.banner.BannerViewHolder
    public void onBind(com.obric.oui.banner.a r5) {
        com.obric.oui.banner.a r6 = (com.obric.oui.banner.a) ZeusTransformUtils.wrapperContextForParams(r5, com.obric.oui.banner.a.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "data");
        if (ZeusTransformUtils.instanceOf(r6, e.class) == false) goto L6;
        this.binding.globalMemoryBannerImage.setImageResource(((e) ZeusTransformUtils.preCheckCast(r6, e.class, "com.obric.memorydata.plugin")).a());
        this.binding.globalMemoryBannerTitle.setText((CharSequence) ZeusTransformUtils.preCheckCast(((e) ZeusTransformUtils.preCheckCast(r6, e.class, "com.obric.memorydata.plugin")).b(), CharSequence.class, "com.obric.memorydata.plugin"));
        this.binding.globalMemoryBannerTip.setText((CharSequence) ZeusTransformUtils.preCheckCast(((e) ZeusTransformUtils.preCheckCast(r6, e.class, "com.obric.memorydata.plugin")).c(), CharSequence.class, "com.obric.memorydata.plugin"));
        TextView r4 = this.binding.globalMemoryBannerTip;
        Intrinsics.checkNotNullExpressionValue(r4, "globalMemoryBannerTip");
        g.a(r4);
        return;
    }

    @Override // com.obric.oui.banner.BannerViewHolder
    public void onSelect() {
        super.onSelect();
        BannerViewHolder.delayPlayDone$default((BannerViewHolder) ZeusTransformUtils.preCheckCast(this, BannerViewHolder.class, "com.obric.memorydata.plugin"), 0, 1, null);
    }
}
