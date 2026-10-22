package com.obric.matrix.platform.sdk.ones.internal.tunnel;

import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import mt.i;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "errorCode", "", "errorMsg", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
final class CmdManager$sendCMDByBind$1$onResult$3 extends Lambda implements Function2<Integer, String, Unit> {
    final /* synthetic */ int $cmd;
    final /* synthetic */ i $emitter;

    public CmdManager$sendCMDByBind$1$onResult$3(int r5, i r10) {
        this.$cmd = r5;
        this.$emitter = r10;
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Unit mo2invoke(Integer r5, String r10) {
        invoke(r5.intValue(), r10);
        return Unit.INSTANCE;
    }

    public final void invoke(int r5, String r10) {
        Intrinsics.checkNotNullParameter(r10, "errorMsg");
        List r11 = a.f11900a;
        a.a(this.$cmd, this.$emitter, r5, r10);
    }
}
