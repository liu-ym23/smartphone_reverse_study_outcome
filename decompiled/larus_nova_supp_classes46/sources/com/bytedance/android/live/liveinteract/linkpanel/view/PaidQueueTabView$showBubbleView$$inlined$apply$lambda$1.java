package com.bytedance.android.live.liveinteract.linkpanel.view;

import android.widget.TextView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, d2 = {"updateAllBubbleSelectUi", "", "selectSortType", "", "invoke", "com/bytedance/android/live/liveinteract/linkpanel/view/PaidQueueTabView$showBubbleView$1$1"}, k = 3, mv = {1, 5, 1})
final class PaidQueueTabView$showBubbleView$$inlined$apply$lambda$1 extends Lambda implements Function1<Integer, Unit> {
    final /* synthetic */ Ref.ObjectRef $fanTv;
    final /* synthetic */ Ref.ObjectRef $firstFocusableView$inlined;
    final /* synthetic */ Ref.ObjectRef $recommendTv;
    final /* synthetic */ int $sortType$inlined;
    final /* synthetic */ Ref.ObjectRef $timeTv;
    final /* synthetic */ int $txPadding$inlined;
    final /* synthetic */ PaidQueueTabView this$0;

    public PaidQueueTabView$showBubbleView$$inlined$apply$lambda$1(Ref.ObjectRef r1, Ref.ObjectRef r2, Ref.ObjectRef r3, PaidQueueTabView r4, int r5, Ref.ObjectRef r6, int r7) {
        this.$timeTv = r1;
        this.$fanTv = r2;
        this.$recommendTv = r3;
        this.this$0 = r4;
        this.$txPadding$inlined = r5;
        this.$firstFocusableView$inlined = r6;
        this.$sortType$inlined = r7;
        super(1);
    }

    public final void invoke(int r4) {
        switch(r4) {
            case 40: goto L23;
            case 41: goto L14;
            case 42: goto L5;
            default: goto L38;
        };
    L5:
        TextView r5 = (TextView) this.$timeTv.element;
        if (r5 == null) goto L8;
        this.this$0.U5(r5, false);
    L8:
        TextView r6 = (TextView) this.$fanTv.element;
        if (r6 == null) goto L11;
        this.this$0.U5(r6, false);
    L11:
        TextView r7 = (TextView) this.$recommendTv.element;
        if (r7 == null) goto L33;
        this.this$0.U5(r7, true);
        return;
    L33:
        return;
    L14:
        TextView r8 = (TextView) this.$timeTv.element;
        if (r8 == null) goto L17;
        this.this$0.U5(r8, false);
    L17:
        TextView r9 = (TextView) this.$fanTv.element;
        if (r9 == null) goto L20;
        this.this$0.U5(r9, true);
    L20:
        TextView r10 = (TextView) this.$recommendTv.element;
        if (r10 == null) goto L35;
        this.this$0.U5(r10, false);
        return;
    L35:
        return;
    L23:
        TextView r11 = (TextView) this.$timeTv.element;
        if (r11 == null) goto L26;
        this.this$0.U5(r11, true);
    L26:
        TextView r12 = (TextView) this.$fanTv.element;
        if (r12 == null) goto L29;
        this.this$0.U5(r12, false);
    L29:
        TextView r13 = (TextView) this.$recommendTv.element;
        if (r13 == null) goto L37;
        this.this$0.U5(r13, false);
        return;
    L37:
        return;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke(((Number) r1).intValue());
        return Unit.INSTANCE;
    }
}
