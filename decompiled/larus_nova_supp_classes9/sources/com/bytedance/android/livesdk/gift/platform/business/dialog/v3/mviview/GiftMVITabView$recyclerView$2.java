package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview;

import android.content.Context;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Landroidx/recyclerview/widget/RecyclerView;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 4, 3})
public final class GiftMVITabView$recyclerView$2 extends Lambda implements Function0<RecyclerView> {
    final /* synthetic */ Context $context;
    final /* synthetic */ GiftMVITabView this$0;

    public GiftMVITabView$recyclerView$2(GiftMVITabView r1, Context r2) {
        this.this$0 = r1;
        this.$context = r2;
        super(0);
    }

    public final RecyclerView invoke() {
        RecyclerView r0 = this.this$0.r().findViewById(2131388038);
        r0.setLayoutManager(new LinearLayoutManager(this.$context, 0, false));
        r0.addOnScrollListener(new GiftMVITabView$recyclerView$2$$special$$inlined$apply$lambda$1(this));
        ViewGroup.LayoutParams r1 = r0.getLayoutParams();
        if ((r1 instanceof ConstraintLayout.LayoutParams) == true) goto L5;
        r1 = null;
    L5:
        ConstraintLayout.LayoutParams r2 = (ConstraintLayout.LayoutParams) r1;
        if (r2 == null) goto L8;
        ((ViewGroup.MarginLayoutParams) r2).height = -1;
        ((ViewGroup.MarginLayoutParams) r2).bottomMargin = 0;
    L8:
        return r0;
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m97invoke() {
        return invoke();
    }
}
