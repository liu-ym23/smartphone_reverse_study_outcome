package com.obric.matrix.platform.sdk.ones.internal.tunnel;

import com.bytedance.bdinstall.dtrait.constant.DTraitConstant;
import com.obric.matrix.proto.Response;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.l;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "errorCode", "", DTraitConstant.ERROR, "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
final class CmdManager$sendCMDByBind$1$onResult$1 extends Lambda implements Function2<Integer, String, Unit> {
    final /* synthetic */ int $cmd;
    final /* synthetic */ l<Pair<Integer, Response>> $emitter;

    CmdManager$sendCMDByBind$1$onResult$1(int r3, l<Pair<Integer, Response>> r4) {
        l<Pair<Integer, Response>> r5 = (l) ZeusTransformUtils.wrapperContextForParams(r4, l.class, "com.obric.memorydata.plugin");
        this.$cmd = r3;
        this.$emitter = r5;
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Unit invoke(Integer r3, String r4) {
        invoke(((Number) ZeusTransformUtils.preCheckCast(r3, Number.class, "com.obric.memorydata.plugin")).intValue(), (String) ZeusTransformUtils.preCheckCast(r4, String.class, "com.obric.memorydata.plugin"));
        return Unit.INSTANCE;
    }

    public final void invoke(int r8, String r9) {
        Intrinsics.checkNotNullParameter(r9, DTraitConstant.ERROR);
        a.a(a.f8113a, this.$cmd, this.$emitter, null, r8, r9);
    }
}
