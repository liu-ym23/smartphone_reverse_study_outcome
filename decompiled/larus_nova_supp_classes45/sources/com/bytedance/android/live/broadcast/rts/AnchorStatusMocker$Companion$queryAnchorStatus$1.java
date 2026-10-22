package com.bytedance.android.live.broadcast.rts;

import com.bytedance.android.live.core.monitor.LiveSlardarMonitor;
import com.bytedance.rts.foundation.u;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012!\u0010\u0002\u001a\u001d\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\u00010\u00032%\u0010\b\u001a!\u0012\u0017\u0012\u00150\tj\u0002`\n¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\u00010\u0003H\n¢\u0006\u0002\b\f"}, d2 = {"<no name provided>", "", "resolve", "Lkotlin/Function1;", "Lcom/bytedance/android/live/broadcast/rts/AnchorStatusResponse;", "Lkotlin/ParameterName;", "name", "value", "reject", "", "Lcom/bytedance/rts/foundation/RTSError;", "reason", "invoke"}, k = 3, mv = {1, 4, 3})
final class AnchorStatusMocker$Companion$queryAnchorStatus$1 extends Lambda implements Function2<Function1<? super AnchorStatusResponse, ? extends Unit>, Function1<? super Throwable, ? extends Unit>, Unit> {
    final /* synthetic */ String $roomId;

    public AnchorStatusMocker$Companion$queryAnchorStatus$1(String r1) {
        this.$roomId = r1;
        super(2);
    }

    public final void invoke(final Function1<? super AnchorStatusResponse, Unit> r2, Function1<? super Throwable, Unit> r3) {
        Intrinsics.checkNotNullParameter(r2, "resolve");
        Intrinsics.checkNotNullParameter(r3, "reject");
        u.d(new AnonymousClass1(this, r2), LiveSlardarMonitor.DELAY_3000);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        invoke((Function1) r1, (Function1) r2);
        return Unit.INSTANCE;
    }
}
