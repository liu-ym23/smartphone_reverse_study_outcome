package com.larus.search.impl.global.view.aggregate.kmp;

import android.view.View;
import android.widget.TextView;
import com.bytedance.flow.search.kmp.api.model.payload.SearchAccountPayload;
import com.larus.common_ui.view.SearchAccountEntryView;
import com.larus.extension.aggregate_search_ui.api.BaseSearchListCell;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J \u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0006H\u0016R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/larus/search/impl/global/view/aggregate/kmp/KmpSearchAccountPayloadCell;", "Lcom/larus/extension/aggregate_search_ui/api/BaseSearchListCell;", "Lcom/larus/search/impl/global/view/aggregate/kmp/KmpSearchAccountCellState;", "<init>", "()V", "layoutId", "", "getLayoutId", "()I", "entryView", "Lcom/larus/common_ui/view/SearchAccountEntryView;", "boundData", "Lcom/bytedance/flow/search/kmp/api/model/payload/SearchAccountPayload;", "onViewCreated", "", "view", "Landroid/view/View;", "onBindView", "state", "position", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class KmpSearchAccountPayloadCell extends BaseSearchListCell<p> {
    public final int a;
    public SearchAccountEntryView b;
    public SearchAccountPayload c;

    public KmpSearchAccountPayloadCell() {
        this.a = 2131561692;
    }

    public final int getLayoutId() {
        return this.a;
    }

    public final void onViewCreated(View r2) {
        Intrinsics.checkNotNullParameter(r2, "view");
        this.b = (SearchAccountEntryView) r2;
        r2.setOnClickListener(new r(this));
    }

    public final void onBindView(View r3, ei9.f r4, int r5) {
        p r6 = (p) r4;
        Intrinsics.checkNotNullParameter(r3, "view");
        Intrinsics.checkNotNullParameter(r6, "state");
        SearchAccountPayload r7 = r6.a;
        this.c = r7;
        SearchAccountEntryView r8 = this.b;
        TextView r9 = null;
        if (r8 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("entryView");
        r8 = null;
    L5:
        String r10 = r7.i;
        r8.getClass();
        Intrinsics.checkNotNullParameter(r10, "keyword");
        TextView r0 = r8.a;
        if (r0 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("titleView");
    L9:
        r9.setText(r8.getContext().getString(2131898115, new Object[]{r10}));
        return;
    L8:
        r9 = r0;
        goto L9
    }
}
