package com.bytedance.android.livesdk.dynamicstrategy.impl.nfa;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/dynamicstrategy/impl/nfa/a;", "it", "", "invoke", "(Lcom/bytedance/android/livesdk/dynamicstrategy/impl/nfa/a;)Z", "<anonymous>"}, k = 3, mv = {1, 4, 3})
final class EventCepNfa$finishFollow$1 extends Lambda implements Function1<a, Boolean> {
    final /* synthetic */ long $lastTime;
    final /* synthetic */ String $reason;
    final /* synthetic */ long $startTime;
    final /* synthetic */ e this$0;

    public EventCepNfa$finishFollow$1(e r1, long r2, long r4, String r6) {
        this.this$0 = r1;
        this.$startTime = r2;
        this.$lastTime = r4;
        this.$reason = r6;
        super(1);
    }

    public final boolean invoke(a r10) {
        Intrinsics.checkNotNullParameter(r10, "it");
        long r0 = r10.b;
        long r4 = this.$startTime;
        if (r0 != r4) goto L10;
        int r1 = b.a;
        b.a(this.this$0.j, r10.a, r4, this.$lastTime, this.$reason);
        m r11 = r10.d;
        if (r11 == null) goto L9;
        l r2 = this.this$0.b;
        if (r2 == null) goto L9;
        r2.c(r11);
    L9:
        return true;
    L10:
        return false;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return Boolean.valueOf(invoke((a) r1));
    }
}
