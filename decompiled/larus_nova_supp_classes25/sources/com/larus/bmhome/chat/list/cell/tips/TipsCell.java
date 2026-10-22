package com.larus.bmhome.chat.list.cell.tips;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.larus.bmhome.chat.cell.BaseMessageListCell;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import ei9.f;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import zg8.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0016J \u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u000bH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/larus/bmhome/chat/list/cell/tips/TipsCell;", "Lcom/larus/bmhome/chat/cell/BaseMessageListCell;", "Lcom/larus/bmhome/chat/list/cell/tips/TipsCellState;", "<init>", "()V", "tipsView", "Landroid/view/View;", "onCreateBoxView", "context", "Landroid/content/Context;", "viewType", "", "boxType", "onBindView", "", "view", "state", "position", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class TipsCell extends BaseMessageListCell<a> {
    public View e;

    public TipsCell() {
    }

    public final View m(Context r2, int r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        View r5 = LayoutInflater.from(r2).inflate(2131562696, null, false);
        this.e = r5;
        if (r5 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("tipsView");
        return null;
    L6:
        return r5;
    }

    public final void onBindView(View r1, f r2, int r3) {
        a r4 = (a) r2;
        Intrinsics.checkNotNullParameter(r1, "view");
        Intrinsics.checkNotNullParameter(r4, "state");
        View r5 = this.e;
        if (r5 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("tipsView");
        r5 = null;
    L5:
        TextView r6 = (TextView) r5.findViewById(2131388367);
        String r7 = r4.a.getContent();
        if (r7 != null) goto L8;
        r7 = "";
    L8:
        r6.setText(r7);
    }
}
