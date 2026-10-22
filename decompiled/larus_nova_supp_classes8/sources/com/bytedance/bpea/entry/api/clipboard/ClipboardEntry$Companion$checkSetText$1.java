package com.bytedance.bpea.entry.api.clipboard;

import com.bytedance.android.livesdk.chatroom.vs_base.base.service.inner.ReplayUIStateCode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import qc4.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 1, ReplayUIStateCode.IS_FOLD_OPEN})
final class ClipboardEntry$Companion$checkSetText$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Function1 $block;
    final /* synthetic */ d $checkResult;

    public ClipboardEntry$Companion$checkSetText$1(Function1 r1, d r2) {
        this.$block = r1;
        this.$checkResult = r2;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m1566invoke() {
        this.$block.invoke(this.$checkResult);
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m1566invoke();
        return Unit.INSTANCE;
    }
}
