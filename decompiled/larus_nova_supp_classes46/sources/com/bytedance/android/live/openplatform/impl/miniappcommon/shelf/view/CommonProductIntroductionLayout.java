package com.bytedance.android.live.openplatform.impl.miniappcommon.shelf.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.openplatform.api.model.shelf.ProductIntroductionInfo;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappcommon/shelf/view/CommonProductIntroductionLayout;", "Landroidx/recyclerview/widget/RecyclerView;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CommonProductIntroductionLayout extends RecyclerView {
    public final CommonProductIntroductionListAdapter a;

    public final void r(List<ProductIntroductionInfo> r2) {
        Intrinsics.checkNotNullParameter(r2, "introductionList");
        List<ProductIntroductionInfo> r0 = this.a.a;
        r0.clear();
        r0.addAll(r2);
        this.a.notifyDataSetChanged();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CommonProductIntroductionLayout(final Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3, r4);
        CommonProductIntroductionListAdapter r5 = new CommonProductIntroductionListAdapter(new ArrayList());
        this.a = r5;
        setLayoutManager(new AnonymousClass1(r3));
        DividerItemDecoration r0 = new DividerItemDecoration(r3);
        Drawable r6 = getResources().getDrawable(2131252662);
        Intrinsics.checkNotNullParameter(r6, "drawable");
        r0.b = r6;
        Unit r7 = Unit.INSTANCE;
        addItemDecoration(r0);
        setAdapter(r5);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
        int r6 = getChildCount() - 1;
    L3:
        if (r6 < 0) goto L7;
        View r7 = getChildAt(r6);
        if ((r7.getLeft() + r7.getMeasuredWidth()) < getMeasuredWidth()) goto L10;
        removeViewInLayout(r7);
        r6 = r6 - 1;
        goto L3
    L10:
        return;
    }
}
