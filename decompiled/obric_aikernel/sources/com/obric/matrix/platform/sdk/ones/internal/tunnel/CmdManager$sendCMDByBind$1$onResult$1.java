package com.obric.matrix.platform.sdk.ones.internal.tunnel;

import com.obric.matrix.proto.Response;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes2.dex */
final class CmdManager$sendCMDByBind$1$onResult$1 extends Lambda implements Function2<Integer, String, Unit> {
    final /* synthetic */ int $cmd;
    final /* synthetic */ xb.i<Pair<Integer, Response>> $emitter;

    CmdManager$sendCMDByBind$1$onResult$1(int r10, xb.i<Pair<Integer, Response>> r11) {
        this.$cmd = r10;
        this.$emitter = r11;
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Integer r10, String r11) {
        invoke(r10.intValue(), r11);
        return Unit.INSTANCE;
    }

    public final void invoke(int r10, String r11) {
        Intrinsics.checkNotNullParameter(r11, "errorMsg");
        b.b(b.f5893a, this.$cmd, this.$emitter, null, r10, r11);
    }
}
