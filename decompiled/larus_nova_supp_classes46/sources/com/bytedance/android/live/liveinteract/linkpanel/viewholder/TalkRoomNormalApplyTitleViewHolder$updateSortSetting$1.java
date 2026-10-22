package com.bytedance.android.live.liveinteract.linkpanel.viewholder;

import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 5, 1})
final class TalkRoomNormalApplyTitleViewHolder$updateSortSetting$1 extends Lambda implements Function1<Integer, Unit> {
    final /* synthetic */ TalkRoomNormalApplyTitleViewHolder this$0;

    public TalkRoomNormalApplyTitleViewHolder$updateSortSetting$1(TalkRoomNormalApplyTitleViewHolder r1) {
        this.this$0 = r1;
        super(1);
    }

    public final void invoke(int r9) {
        LinkedList<?> r10 = this.this$0.l;
        if (r10 == null) goto L5;
        r10.clear();
    L5:
        yf0.a.h(this.this$0.k, true, "anchorChangeSortType", 50, "", 0, 48);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke(((Number) r1).intValue());
        return Unit.INSTANCE;
    }
}
