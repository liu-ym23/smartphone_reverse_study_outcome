package com.obric.matrix.platform.sdk.ones.internal.tunnel;

import com.obric.matrix.proto.Response;
import io.reactivex.j;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "errorCode", "", "errorMsg", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
final class CmdManager$sendCMDByBind$1$onResult$1 extends Lambda implements Function2<Integer, String, Unit> {
    final /* synthetic */ int $cmd;
    final /* synthetic */ j<Pair<Integer, Response>> $emitter;

    public CmdManager$sendCMDByBind$1$onResult$1(int r1, j<Pair<Integer, Response>> r2) {
        this.$cmd = r1;
        this.$emitter = r2;
        super(2);
    }

    public final void invoke(int r4, String r5) {
        Intrinsics.checkNotNullParameter(r5, "errorMsg");
        List<Integer> r0 = a.a;
        a.a(this.$cmd, this.$emitter, null, r4, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        invoke(((Number) r1).intValue(), (String) r2);
        return Unit.INSTANCE;
    }
}
