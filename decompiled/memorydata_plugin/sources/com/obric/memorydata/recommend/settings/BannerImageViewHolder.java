package com.obric.memorydata.recommend.settings;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.obric.memorydata.recommend.databinding.ItemRecommendSettingsBannerBinding;
import com.obric.oui.banner.BannerViewHolder;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\tH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000e"}, d2 = {"Lcom/obric/memorydata/recommend/settings/BannerImageViewHolder;", "Lcom/obric/oui/banner/BannerViewHolder;", "binding", "Lcom/obric/memorydata/recommend/databinding/ItemRecommendSettingsBannerBinding;", "<init>", "(Lcom/obric/memorydata/recommend/databinding/ItemRecommendSettingsBannerBinding;)V", "getBinding", "()Lcom/obric/memorydata/recommend/databinding/ItemRecommendSettingsBannerBinding;", "onBind", "", "data", "Lcom/obric/oui/banner/BannerData;", "onSelect", "Companion", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class BannerImageViewHolder extends BannerViewHolder {
    public static final a Companion = null;
    private final ItemRecommendSettingsBannerBinding binding;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u0014\u0010\u0004\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\f"}, d2 = {"Lcom/obric/memorydata/recommend/settings/BannerImageViewHolder$Companion;", "Lcom/obric/oui/banner/IBannerViewHolderFactory;", "<init>", "()V", "key", "", "getKey", "()Ljava/lang/String;", "newInstance", "Lcom/obric/oui/banner/BannerViewHolder;", "parent", "Landroid/view/ViewGroup;", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a implements com.obric.oui.banner.c {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        @Override // com.obric.oui.banner.c
        public BannerViewHolder a(ViewGroup r4) {
            Intrinsics.checkNotNullParameter(r4, "parent");
            ItemRecommendSettingsBannerBinding r3 = ItemRecommendSettingsBannerBinding.inflate(LayoutInflater.from((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")), r4, false);
            Intrinsics.checkNotNullExpressionValue(r3, "inflate(...)");
            return (BannerViewHolder) ZeusTransformUtils.preCheckCast(new BannerImageViewHolder(r3), BannerViewHolder.class, "com.obric.memorydata.plugin");
        }

        @Override // com.obric.oui.banner.c
        public String a() {
            return "_image_item";
        }
    }

    static {
        Companion = new a(null);
    }

    public BannerImageViewHolder(ItemRecommendSettingsBannerBinding r4) {
        Intrinsics.checkNotNullParameter(r4, "binding");
        ConstraintLayout r0 = r4.getRoot();
        Intrinsics.checkNotNullExpressionValue(r0, "getRoot(...)");
        super((View) ZeusTransformUtils.preCheckCast(r0, View.class, "com.obric.memorydata.plugin"));
        this.binding = r4;
    }

    public final ItemRecommendSettingsBannerBinding getBinding() {
        return this.binding;
    }

    @Override // com.obric.oui.banner.BannerViewHolder
    public void onBind(com.obric.oui.banner.a r3) {
        com.obric.oui.banner.a r4 = (com.obric.oui.banner.a) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.oui.banner.a.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "data");
        if (ZeusTransformUtils.instanceOf(r4, d.class) == false) goto L6;
        this.binding.ivRecommendSettingsBanner.setImageResource(((d) ZeusTransformUtils.preCheckCast(r4, d.class, "com.obric.memorydata.plugin")).a());
        return;
    }

    @Override // com.obric.oui.banner.BannerViewHolder
    public void onSelect() {
        super.onSelect();
        BannerViewHolder.delayPlayDone$default((BannerViewHolder) ZeusTransformUtils.preCheckCast(this, BannerViewHolder.class, "com.obric.memorydata.plugin"), 0, 1, null);
    }
}
