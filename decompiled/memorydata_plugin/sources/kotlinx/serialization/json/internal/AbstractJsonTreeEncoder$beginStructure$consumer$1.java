package kotlinx.serialization.json.internal;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "node", "Lkotlinx/serialization/json/JsonElement;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
final class AbstractJsonTreeEncoder$beginStructure$consumer$1 extends Lambda implements Function1<kotlinx.serialization.json.g, Unit> {
    final /* synthetic */ d this$0;

    AbstractJsonTreeEncoder$beginStructure$consumer$1(d r1) {
        this.this$0 = r1;
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* synthetic */ Unit invoke(kotlinx.serialization.json.g r3) {
        invoke2((kotlinx.serialization.json.g) ZeusTransformUtils.preCheckCast(r3, kotlinx.serialization.json.g.class, "com.obric.memorydata.plugin"));
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(kotlinx.serialization.json.g r2) {
        Intrinsics.checkNotNullParameter(r2, "node");
        d r1 = this.this$0;
        r1.a(d.a(r1), r2);
    }
}
