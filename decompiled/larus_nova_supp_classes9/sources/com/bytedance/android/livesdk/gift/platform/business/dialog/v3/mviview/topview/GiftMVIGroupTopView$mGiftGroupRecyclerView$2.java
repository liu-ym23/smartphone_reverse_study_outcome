package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview.topview;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Landroidx/recyclerview/widget/RecyclerView;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 4, 3})
public final class GiftMVIGroupTopView$mGiftGroupRecyclerView$2 extends Lambda implements Function0<RecyclerView> {
    final /* synthetic */ Context $context;
    final /* synthetic */ GiftMVIGroupTopView this$0;

    public GiftMVIGroupTopView$mGiftGroupRecyclerView$2(GiftMVIGroupTopView r1, Context r2) {
        this.this$0 = r1;
        this.$context = r2;
        super(0);
    }

    public final RecyclerView invoke() {
        final RecyclerView r0 = this.this$0.r().findViewById(2131373716);
        r0.setLayoutManager(new GiftMVIGroupTopView.b(this.$context));
        r0.addOnScrollListener(new GiftMVIGroupTopView$mGiftGroupRecyclerView$2$$special$$inlined$apply$lambda$1(r0, this));
        return r0;
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m146invoke() {
        return invoke();
    }
}
